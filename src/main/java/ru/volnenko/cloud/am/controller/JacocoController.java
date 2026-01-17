package ru.volnenko.cloud.am.controller;

import lombok.NonNull;
import ru.volnenko.cloud.am.dto.JacocoDto;
import ru.volnenko.cloud.am.dto.ResultDto;
import ru.volnenko.cloud.am.repository.MetricRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public final class JacocoController extends AbstractController {

    @NonNull
    private final MetricRepository metricRepository;

    public JacocoController(@NonNull final MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    public String url() {
        return "/api/v1/jacoco";
    }

    @POST
    @Path("/metric")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDto metric(final JacocoDto metric) {
        metricRepository.metric(metric);
        return new ResultDto();
    }

}
