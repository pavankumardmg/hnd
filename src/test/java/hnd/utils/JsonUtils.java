package hnd.utils;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonUtils<T> {
    private static final Gson gson = new Gson();

    //need to change this to generic
    @SneakyThrows
    public static <T> T getObject(File file, Class<T> classT)  {
        return gson.fromJson(Files.readString(getFilePath(file.getName())), classT);
    }
    @SneakyThrows
    public static <T> T getObject(String data, Class<T> classT)  {
        return  gson.fromJson(data, classT);
    }

    public static Path getFilePath(String fileName) {
        return Path.of("src","test","resources", fileName ).toAbsolutePath();
    }
}
