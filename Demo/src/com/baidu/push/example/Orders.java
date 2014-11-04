package com.baidu.push.example;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.baidu.frontia.Frontia;
import com.baidu.frontia.FrontiaData;
import com.baidu.frontia.FrontiaQuery;
import com.baidu.frontia.api.FrontiaStorage;
import com.baidu.frontia.api.FrontiaStorageListener.DataInfoListener;
import com.baidu.frontia.api.FrontiaStorageListener.DataInsertListener;
import com.baidu.frontia.api.FrontiaStorageListener.DataOperationListener;

public class Orders {

    public static FrontiaStorage mCloudStorage;

    public static JSONArray bufferedOrdersJsonArray = null;

    public static JSONArray processedOrdersJsonArray = null;

    public static JSONObject currentOrderJsonObject = null;

    public static int processingBufferedOrderID = -1;

//    public static boolean isLoginBaidu = false;
//    public static boolean isLoginPushManager = false;
//    public static boolean alreadyGetOrderInfo = false;

    public static void initFrontia(Context context) {

        Frontia.init(context, "L15f7Q6RlrGvg9YrAm8Z50sa");
//        Frontia.init(context, "7BhYkKZk2jRqfuDsXhizTmpa");

        mCloudStorage = Frontia.getStorage();

    }

    public static void insert(final JSONObject js) {

        FrontiaData newData = new FrontiaData(js);
        mCloudStorage.insertData(newData, new DataInsertListener() {
            @Override
            public void onSuccess() {
                Log.e("log", "insert js = " + js.toString());
            }

            @Override
            public void onFailure(int errCode, String errMsg) {
                // TODO Auto-generated method stub
                Log.e("log", "inset 错误为" + errCode + errMsg);
            }
        });

    }

    public static void update() {
        FrontiaQuery query = new FrontiaQuery();
        query.startsWith("userName", Users.userNameString);

        FrontiaData newData = new FrontiaData();
        newData.put("userName", Users.userNameString);
        newData.put("ProcessedOrders", processedOrdersJsonArray);
        newData.put("CurrentOrder", currentOrderJsonObject);
        newData.put("BufferedOrders", bufferedOrdersJsonArray);

        Log.e("", "更新数据库：" + newData.toString());

        mCloudStorage.updateData(query, newData, new DataOperationListener() {

            @Override
            public void onSuccess(long arg0) {
                // TODO Auto-generated method stub
                Log.e("", "update success");
            }

            @Override
            public void onFailure(int arg0, String arg1) {
                // TODO Auto-generated method stub
                Log.e("", "update faile");

            }
        });
    }


    public static void getUserOrders(final Context context, final Callback callback) {
        // 空的FrontiaQuery表示query所有的数据(具有可读权限数据才能被查到)
        FrontiaQuery query = new FrontiaQuery();
        query.startsWith("userName", Users.userNameString);
        Log.e("", "查询条件：" + Users.userNameString);
//         mCloudStorage.deleteData(
//         query,
//         new DataOperationListener() {
//
//         @Override
//         public void onSuccess(long count) {
//         Log.e("", "delete all data scuess");
//         }
//
//         @Override
//         public void onFailure(int errCode, String errMsg) {
//         Log.e("", "delete all data failed");
//         }
//         });

        mCloudStorage.findData(query, new DataInfoListener() {

            @Override
            public void onSuccess(List<FrontiaData> dataList) {



                Log.e("",
                        "获取用户数据成功 onSuccess dataList = "
                                + dataList.toString());

                FrontiaData d = dataList.get(0);
                JSONObject data = d.toJSON();

                // data.put("Name", Users.userNameString);
                try {

                    Users.userNameString = data.getString("userName");

                } catch (JSONException e) {
                    Users.userNameString = null;
                    Log.e("", e.toString());

                }

                try {

                    processedOrdersJsonArray = (JSONArray) data
                            .get("ProcessedOrders");

                } catch (JSONException e) {
                    processedOrdersJsonArray = null;
                    Log.e("", e.toString());
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                try {
                    bufferedOrdersJsonArray = (JSONArray) data
                            .get("BufferedOrders");
                } catch (JSONException e1) {
                    bufferedOrdersJsonArray = null;
                    e1.printStackTrace();
                }

                try {
                    currentOrderJsonObject = data.getJSONObject("CurrentOrder");
                } catch (JSONException e) {
                    currentOrderJsonObject = null;
                    e.printStackTrace();
                }

                // try {
                // bufferedOrdersJsonArray = new JSONArray();
                // JSONObject jsonObject1 = new JSONObject();
                // jsonObject1.put("OrderDescription", "下午3点到西直门检测");
                // bufferedOrdersJsonArray.put(jsonObject1);
                //
                // JSONObject jsonObject2 = new JSONObject();
                // jsonObject2.put("OrderDescription", "下午3点到东直门检测");
                // bufferedOrdersJsonArray.put(jsonObject2);
                // } catch (JSONException e) {
                // // TODO Auto-generated catch block
                // e.printStackTrace();
                // }
//                alreadyGetOrderInfo = true;
                callback.onSuccess();
            }

            @Override
            public void onFailure(int errCode, String errMsg) {
                callback.onFail();

                Log.e("222", "on failure errCode = " + errCode + errMsg);

            }
        });

    }

    public static void createUser(final Callback callback) {

        final JSONObject data = new JSONObject();
        try {
            data.put("userName", Users.userNameString);
            processedOrdersJsonArray = new JSONArray();
            data.put("ProcessedOrders", processedOrdersJsonArray);
            currentOrderJsonObject = new JSONObject();
            data.put("CurrentOrder", currentOrderJsonObject);
            bufferedOrdersJsonArray = new JSONArray();
            data.put("BufferededOrders", bufferedOrdersJsonArray);
            Log.e("", "create user string = " + data.toString());

            FrontiaData newData = new FrontiaData(data);
            mCloudStorage.insertData(newData, new DataInsertListener() {
                @Override
                public void onSuccess() {
//                    Orders.alreadyGetOrderInfo = true;
                    Log.e("log", "创建用户成功 js = " + data.toString());

                    callback.onSuccess();

                }

                @Override
                public void onFailure(int errCode, String errMsg) {
                    callback.onFail();

                    // TODO Auto-generated method stub
                    Log.e("log", "创建用户失败 错误为" + errCode + errMsg);
                }
            });


//            insert(data);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void showAll() {
        FrontiaQuery query = new FrontiaQuery();
        mCloudStorage.findData(query, new DataInfoListener() {

            @Override
            public void onFailure(int arg0, String arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onSuccess(List<FrontiaData> dataList) {
                // TODO Auto-generated method stub
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (FrontiaData d : dataList) {
                    sb.append(i).append(":").append(d.toJSON().toString())
                            .append("\n");
                    i++;
                }
                Log.e("", sb.toString());

            }
        });
    }

    public static void finishCurrentOrder() throws JSONException {
        processedOrdersJsonArray.put(currentOrderJsonObject);
        currentOrderJsonObject = null;

        update();
    }

    public static void finishBufferedOrder(int index) {
        try {
            JSONArray tempArray = new JSONArray();
            for (int i = 0; i < bufferedOrdersJsonArray.length(); i++) {
                if (i == index)
                    processedOrdersJsonArray
                            .put(bufferedOrdersJsonArray.get(i));
                else
                    tempArray.put(bufferedOrdersJsonArray.get(i));
            }
            bufferedOrdersJsonArray = tempArray;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        update();
    }

}
