package ru.volnenko.cloud.am.repository;

import lombok.NonNull;
import ru.volnenko.cloud.am.dto.AbstractMetric;
import ru.volnenko.cloud.am.dto.JacocoDto;
import ru.volnenko.cloud.am.dto.JacocoMetric;

import java.util.*;

public final class MetricRepository {

    @NonNull
    private final Map<String, AbstractMetric> metrics = new LinkedHashMap<>();

    {
        jacoco("ru.volnenko.cloud", "artifact-metrics-server", "1.0.0", 23);
        jacoco("ru.volnenko.cloud", "asciidoc-server", "1.0.0", 67);
        jacoco("ru.volnenko.cloud", "asciidoc-server", "1.0.0", 11);
    }

    private void jacoco(String groupId, String artifactId, String version, int value) {
        final JacocoMetric jacocoMetric = new JacocoMetric();
        jacocoMetric.groupId(groupId);
        jacocoMetric.artifactId(artifactId);
        jacocoMetric.version(version);
        jacocoMetric.value(value);
        jacocoMetric.application();
        metrics.put(jacocoMetric.key(), jacocoMetric);
    }

    public void metric(@NonNull final JacocoDto metric) {
        @NonNull final JacocoMetric jacocoMetric = new JacocoMetric();
        if (metric.getLabels() != null) jacocoMetric.putAll(metric.getLabels());
        jacocoMetric.artifactId(metric.getArtifactId());
        jacocoMetric.artifactId(metric.getGroupId());
        jacocoMetric.artifactId(metric.getVersion());
        jacocoMetric.value(metric.getValue());
        if (metric.getType() != null) {
            if (metric.getType().isApplication()) jacocoMetric.application();
            if (metric.getType().isLibrary()) jacocoMetric.library();
        } else {
            jacocoMetric.application();
        }
        metrics.put(jacocoMetric.key(), jacocoMetric);
    }

    @NonNull
    public Collection<AbstractMetric> metrics() {
        return metrics.values();
    }

}
