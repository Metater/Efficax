package com.github.metater.efficax.utils;

import javax.lang.model.type.PrimitiveType;

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
        if (args.length == 0)
            return true;
        return false;
    }
    /** Takes in command args checks if not null, and */
    public static boolean argsIsNotNull(String[] args){
        if (args.length == 0)
            return false;
        return true;
    }
    public static boolean firstArgIsNotNullAndIsIntAndOneArg(String[] args) {
        if (args.length != 1 || !argsIsNotNull(args) || !isInt(args[0]))
            return false;
        return true;
    }
}
