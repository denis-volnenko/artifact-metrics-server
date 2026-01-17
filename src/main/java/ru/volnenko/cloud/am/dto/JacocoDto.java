package ru.volnenko.cloud.am.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.cloud.am.enumerated.ArtifactType;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public final class JacocoDto {

    private ArtifactType type;

    private String groupId;

    private String artifactId;

    private String version;

    private float value;

    private Map<String, String> labels;

}
