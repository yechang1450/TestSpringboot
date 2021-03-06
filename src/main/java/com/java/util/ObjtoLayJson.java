package com.java.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


/***
 *
 * @author Administrator
 *
 */
public class ObjtoLayJson {

    public static String toJson(Object object, String[] colums) throws Exception {
        String[] dataRow = new String[colums.length];

        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            String fistfont = fieldName.substring(0, 1).toUpperCase();
            String methodname = "get" + fistfont + fieldName.substring(1);
            Method method = object.getClass().getMethod(methodname);
            if (method.invoke(object) == null) {
                dataRow[i] = "null";
            } else {
                dataRow[i] = method.invoke(object).toString();
            }
        }
        //System.out.println(Arrays.toString(dataRow));

        String jsonStr = "[{\"status\":0}, {\"message\": \"成功了\" }, {\"count\": 1000},{\"rows\":{\"item\":[";
        for (int i = 0; i < dataRow.length; i++) {
            String arr = "{";
            if (dataRow[i] == null || "NULL".equals(dataRow[i])) {
                arr += "\"\"";
            } else {
                arr += "\"" + colums[i] + "\"" + ":";
                arr += "\"" + dataRow[i] + "\"";
            }

            arr += "}";
            if (i < dataRow.length - 1) {
                arr += ",";
            }

            jsonStr += arr;

        }

        jsonStr += "]}}]";
        return jsonStr;
    }


    public static <T> String ListtoJson(List<T> objects, String[] colums) throws Exception {
        String[][] dataRow = new String[objects.size()][colums.length];
        int count = 0;
        for (Object object : objects) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String fieldName = fields[i].getName();
                String fistfont = fieldName.substring(0, 1).toUpperCase();
                String methodname = "get" + fistfont + fieldName.substring(1);
                Method method = object.getClass().getMethod(methodname);
                if (method.invoke(object) == null) {
                    dataRow[count][i] = "null";
                } else {
                    dataRow[count][i] = method.invoke(object).toString();
                }
            }
            count += 1;
        }


        String jsonStr = "[{\"status\":0}, {\"message\": \"成功了\" }, {\"count\": 1000},{\"rows\":{\"item\":[";
        for (int i = 0; i < dataRow.length; i++) {

            String arr = "{";
            for (int j = 0; j < dataRow[i].length; j++) {
                //System.out.println("j======"+j);
                if (dataRow[i][j] == null || "NULL".equals(dataRow[i][j])) {
                    arr += "\"\"";
                } else {
                    arr += "\"" + colums[j] + "\"" + ":";
                    arr += "\"" + dataRow[i][j] + "\"";
                }

                if (j < dataRow[i].length - 1) {
                    arr += ",";
                }
            }
            arr += "}";
            if (i < dataRow.length - 1) {
                arr += ",";
            }

            jsonStr += arr;
        }
        jsonStr += "]}}]";
        return jsonStr;
    }


}
