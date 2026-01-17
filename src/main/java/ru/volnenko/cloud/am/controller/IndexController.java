package ru.volnenko.cloud.am.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashMap;
import java.util.Map;

public final class IndexController extends AbstractController {

    @Override
    public String url() {
        return "/";
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> index() {
        final Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "artifact-metrics-server");
        map.put("version", "1.0.0");
        map.put("developer", "Denis Volnenko");
        map.put("site", "https://www.volnenko.ru");
        return map;
    }

}
