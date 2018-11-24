package com.acme.edu;

public class Logger {
    private static final String PRIM = "primitive: ";
    private static final String CHAR = "character: ";
    private static final String STR = "string: ";
    private static int intSum = 0;
    private static String prevString = "";
    private static int stringCounter;
    private static boolean ifWasByteOfInt;

    private static void print(String message) {
        System.out.println(message);
    }

    private static void intCheck() {
        if (ifWasByteOfInt) {
            print(PRIM + intSum);
            intSum = 0;
            ifWasByteOfInt = false;
        }
    }

    private static void stringCheck() {
        if (stringCounter == 0) {
            return;
        }
        if (stringCounter == 1) {
            print(STR + prevString);
        } else {
            print(STR + prevString + " x(" + stringCounter + ")");
        }
        stringCounter = 0;

    }

    private static void close() {
        stringCheck();
        intCheck();
    }

    public static void log(int message) {
        stringCheck();
        long temp = intSum;
        if ((temp + message) > Integer.MAX_VALUE) {
            intCheck();
            print(PRIM + message);
        } else {
            intSum += message;
            ifWasByteOfInt = true;
        }
    }

    public static void log(byte message) {
        stringCheck();
        int temp = intSum;
        if ((temp + message) > Byte.MAX_VALUE) {
            intCheck();
            print(PRIM + message);
        }
        else {
            intSum += message;
            ifWasByteOfInt = true;
        }
    }

    public static void log(boolean message) {
        stringCheck();
        intCheck();
        print(PRIM + message);
    }

    public static void log(char message) {
        stringCheck();
        intCheck();
        print(CHAR + message);
    }

    public static void log(String message) {
        intCheck();
        if (prevString.equals(message)) {
            stringCounter++;
        }
        else {
            stringCheck();
            prevString = message;
            stringCounter = 1;

        }
    }

    public static void main(String[] args) {
        //region Iteration1
/*      log(1);
        log(-1);
        log(0);
        log((byte)1);
        log((byte)-11);
        log((byte)0);
        log('a');
        log('b');
        log("test string 1");
        log("other string");
        log(true);
        log(false);*/
        //endregion

        //region Iteration2
        //region Test1, shouldLogSequentIntegerAsSum
        /*log("str 1");
        log(1);
        log(2);
        log('a');
        log(0);
        close();*/
        //endregion
        //region Test2, shouldLogCorrectlyIntegerOverflowWhenSequentialIntegers
/*        log("str 1");
        log(10);
        log(Integer.MAX_VALUE);
        log("str 2");
        log(2);
        log(1);
        close();*/
        //endregion
        //region Test3, shouldLogCorrectlyByteOverflowWhenSequentialBythes
        log("str 1");
        log((byte)10);
        log((byte)Byte.MAX_VALUE);
        log("str 2");
        log(2);
        log(1);
        close();
        //endregion
        //region Test4,shouldLogSameSubsequentStringsWithoutRepeat
/*        log("str 1");
        log("str 2");
        log("str 2");
        log('a');
        log("str 2");
        log("str 3");
        log("str 3");
        log("str 3");
        close();*/

        //endregion

        //endregion


    }
}