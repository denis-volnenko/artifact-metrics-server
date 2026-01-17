package ru.volnenko.cloud.am.dto;

import lombok.NonNull;
import ru.volnenko.cloud.am.util.JsonUtil;

import java.util.LinkedHashMap;

public abstract class AbstractMetric extends LinkedHashMap<String, String> {

    private float value;

    @NonNull
    public abstract String name();

    public String type() {
        return get("type");
    }

    public void application() {
        put("type", "APPLICATION");
    }

    public void library() {
        put("type", "LIBRARY");
    }

    public String artifactId() {
        return get("artifactId");
    }

    @NonNull
    public void artifactId(final String artifactId) {
        put("artifactId", artifactId);
    }

    public String groupId() {
        return get("groupId");
    }

    @NonNull
    public void groupId(final String groupId) {
        put("groupId", groupId);
    }

    public String version() {
        return get("version");
    }

    @NonNull
    public void version(final String version) {
        put("version", version);
    }

    public float value() {
        return value;
    }

    public void value(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name() + JsonUtil.format(this) + " " + value();
    }

    public String key() {
        return new StringBuilder()
                .append(name()).append(":")
                .append(type()).append(":")
                .append(groupId()).append(":")
                .append(artifactId())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractMetric metric = (AbstractMetric) o;
        return key().equals(metric.key());
    }

    @Override
    public int hashCode() {
        return key().hashCode();
    }
}
