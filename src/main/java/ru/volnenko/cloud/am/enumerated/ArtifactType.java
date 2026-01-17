package ru.volnenko.cloud.am.enumerated;

public enum ArtifactType {

    APPLICATION,
    LIBRARY;

    public boolean isApplication() {
        return this.equals(APPLICATION);
    }

    public boolean isLibrary() {
        return this.equals(LIBRARY);
    }


}
