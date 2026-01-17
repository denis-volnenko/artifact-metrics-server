package ru.volnenko.cloud.am.context;

import lombok.NonNull;
import ru.volnenko.cloud.am.controller.IndexController;
import ru.volnenko.cloud.am.controller.JacocoController;
import ru.volnenko.cloud.am.controller.MetricController;
import ru.volnenko.cloud.am.repository.MetricRepository;

public final class ServerContext {

    @NonNull
    private final MetricRepository metricRepository = new MetricRepository();

    @NonNull
    private final MetricController metricController = new MetricController(metricRepository);

    @NonNull
    private final JacocoController jacocoController = new JacocoController(metricRepository);

    @NonNull
    private final IndexController indexController = new IndexController();

    public void publish() {
        jacocoController.publish();
        metricController.publish();
        indexController.publish();
    }

}
