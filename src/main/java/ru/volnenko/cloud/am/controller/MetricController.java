package ru.volnenko.cloud.am.controller;


import lombok.NonNull;
import ru.volnenko.cloud.am.dto.AbstractMetric;
import ru.volnenko.cloud.am.repository.MetricRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

public final class MetricController extends AbstractController {

    @NonNull
    private final MetricRepository metricRepository;

    public MetricController(@NonNull MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    public String url() {
        return "/metrics";
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        final Collection<AbstractMetric> metrics = metricRepository.metrics();
        final StringBuilder sb = new StringBuilder();
        for (final AbstractMetric metric: metrics) sb.append(metric).append("\n");
        return sb.toString();
    }

}
