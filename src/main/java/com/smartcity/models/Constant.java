package com.smartcity.models;

/**
 * Created by ZJDX on 2015/8/29.
 */
public class Constant {

    private Constant(){}

    public static int SUCCESS = 0;
    public static int FAIL = 1;
    public static int ALREADY_EXISTS = 2;
    public static int NO_SUCH_USER = 4;
    public static int UNKNOWN_REASON = 2;
    public static int MISMATCH = 3;
    public static int UNKNOWN_CATEGORY = 1;
    public static int UNKNOWN_PRODUCT = 1;
    public static int WRONG_ORDER_STATUS = 1;
    public static int UNKNOWN_ORDER = 1;
    public static int NO_PRODUCT = 1;
    public static int AUTHENTICATE_FAILURE = 1;


    public static String MSG_SUCCESS = "Success";
    public static String MSG_UNKNOWN_REASON = "Unknown Reason";
    public static String MSG_NO_SUCH_USER = "No Such User";
    public static String MSG_MISMATCH = "Mismatch";
    public static String MSG_ALREADY_REGISTER = "Already Register";
    public static String MSG_UNKNOWN_CATEGORY = "Unknown Category";
    public static String MSG_UNKNOWN_PRODUCT = "Unknown Product";
    public static String MSG_WRONG_ORDER_STATUS = "Wrong Order Status";
    public static String MSG_UNKNOWN_ORDER = "Unknown Order";
    public static String MSG_NO_PRODUCT = "No Product";
    public static String MSG_AUTHENTICATE_FAILURE = "Authenticate Failure";

    public static int ORDER_UNFINISHED = 0;
    public static int ORDER_FINISHED = 1;

    public static String ORDER_STATUS_START = "Start";
    public static String ORDER_STATUS_FINISH = "Finish";
    public static String ORDER_STATUS_BEFORE_PRODUCE = "Product is going to produce";
    public static String ORDER_STATUS_AFTER_PRODUCE = "Product has been produced";
    public static String ORDER_STATUS_IN_DELIVERY = "Product is delivering";
}
