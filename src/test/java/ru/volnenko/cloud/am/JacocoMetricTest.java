package ru.volnenko.cloud.am;

import org.junit.Test;
import ru.volnenko.cloud.am.dto.JacocoMetric;

public class JacocoMetricTest {

    @Test
    public void test() {
        JacocoMetric metric = new JacocoMetric();
        System.out.println(metric.key());
    }

}
