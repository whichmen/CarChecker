package com.baidu.push.example;

public class Users {
    public static String userNameString = null;

    public static String userId = null;

    private static SharedPreferences mPreferences = null;

    private static SharedPreferences.Editor mEditer = null;

//    public static void init(Context context) {
////        userNameString = loadUserName(context);
////        userId = loadString(context, "userId", null);
//
//        if (userNameString.equals("error"))
//            userNameString = null;
//    }

    public static void setUserNameAndPassword(Context context, String name, String password) {
        userNameString = name;
        saveString(context, "userName", name);
        saveString(context, "password", password);
    }
//
    public static String loadUserName(Context context) {
        return loadString(context, "userName", "error");
    }

    public static String loadPassword(Context context) {
        return loadString(context, "password", "error");
    }


//    public static String loadAccessToken(Context context) {
//
//        long now = System.currentTimeMillis();
//        if (now < Long.valueOf(loadString(context, "expires_time", "0")))
//            return loadString(context, "token", null);
//        else
//            return null;
//    }
//
//    public static void setAccessToken(Context context, String token,
//            long expires_in) {
//
//        long expires_time = System.currentTimeMillis();
//        expires_time = expires_time + expires_in;
//
//        saveString(context, "token", token);
//        saveString(context, "expires_time", Long.toString(expires_time));
//    }

    /**
     * 加载boolean类型值
     *
     * @param key
     *            待加载值的主键
     * @param defValue
     *            如果key不存在默认值
     * @return 指定key的boolean值
     */
    public static String loadString(Context context, String key, String defValue) {
        if (mPreferences == null) {
            mPreferences = PreferenceManager
                    .getDefaultSharedPreferences(context);
        }
        return mPreferences.getString(key, defValue);
    }

    /**
     * 保存指定key的boolean类型值
     *
     * @param key
     *            待保存值的主键
     * @param value
     *            待保存的boolean值
     */
    public static void saveString(Context context, String key, String value) {
        if (mPreferences == null) {
            mPreferences = PreferenceManager
                    .getDefaultSharedPreferences(context);
        }
        if (mEditer == null) {
            mEditer = mPreferences.edit();
        }
        mEditer.putString(key, value);
        mEditer.commit();
    }

}
