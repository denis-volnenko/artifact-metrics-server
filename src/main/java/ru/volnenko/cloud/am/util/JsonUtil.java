package ru.volnenko.cloud.am.util;

import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;

public final class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @SneakyThrows
    public static String format(Object o) {
        return MAPPER.writeValueAsString(o);
    }

}
