package com.github.metater.efficax.utils;

public class TestUtils {
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    /** Takes in command args checks if null, and */
    public static boolean argsIsNull(String[] args){
        return args.length == 0;
    }
    /** Takes in command args checks if not null, and */
    public static boolean argsIsNotNull(String[] args){
        return args.length != 0;
    }
    public static boolean firstArgIsNotNullAndIsIntAndOneArg(String[] args) {
        return args.length == 1 && argsIsNotNull(args) && isInt(args[0]);
    }
}
