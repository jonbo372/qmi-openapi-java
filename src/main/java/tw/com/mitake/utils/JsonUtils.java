package tw.com.mitake.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    public static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static <T> T fromJson(String string, Class<T> clazz) {
        return GSON.fromJson(string, clazz);
    }

    public static String toJson(Object object){
        return GSON.toJson(object);
    }
}
