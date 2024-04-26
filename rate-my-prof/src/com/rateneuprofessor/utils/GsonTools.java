package com.rateneuprofessor.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GsonTools {

  private static Gson gson;

  static {
    gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
        .create();
  }

  public static String success(String status, String message, Object data) {
    Response resp = new Response(status, message, data);
    return gson.toJson(resp);
  }

  public static String success(String message, Object data) {
    return success("success", message, data);
  }

  public static String success(String message) {
    return success("success", message, null);
  }

  public static String error(String status, String message) {
    Response resp = new Response(status, message, null);
    return gson.toJson(resp);
  }

  public static String error(String message) {
    return error("error", message);
  }

  private static class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>,
      JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
      return new JsonPrimitive(formatter.format(src));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
      return LocalDateTime.parse(json.getAsString(), formatter);
    }
  }
}
