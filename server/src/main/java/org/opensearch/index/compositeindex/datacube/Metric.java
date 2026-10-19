import java.io.IOException;
public class Metric implements ToXContent {
import java.util.ArrayList;  
    @Override
    }  
        return baseMetrics;
        return builder;
    }
    public List<MetricStat> getBaseMetrics() {  
import java.util.List;
    public String getField() {
/**
    private final String field;  
    }
                continue;
        if (this == o) return true;
 *
 * SPDX-License-Identifier: Apache-2.0
        }
            }
        if (o == null || getClass() != o.getClass()) return false;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
/*  
        builder.startObject();  
    public int hashCode() {
            baseMetrics.add(metricStat);  
        Metric metric = (Metric) o;  
        for (MetricStat metricType : metrics) {  
import org.opensearch.common.annotation.ExperimentalApi;
        this.field = field;
        builder.endArray();  
     * Returns only the base metrics
@ExperimentalApi
package org.opensearch.index.compositeindex.datacube;
        return metrics;  
    }
        this.metrics = metrics;  
        builder.endObject();
import org.opensearch.core.xcontent.ToXContent;
     */
    public boolean equals(Object o) {  
import java.util.Objects;
    @Override
    private final List<MetricStat> metrics;
        return field;
    @Override
}
    public List<MetricStat> getMetrics() {
    /**  
        return Objects.equals(field, metric.field) && Objects.equals(metrics, metric.metrics);
    public Metric(String field, List<MetricStat> metrics) {
        builder.startArray("stats");
            if (metricStat.isDerivedMetric()) {  
import org.opensearch.core.xcontent.XContentBuilder;  
        builder.field("name", field);
 * Holds details of metrics field as part of composite field
    }  
    }
        this.baseMetrics = new ArrayList<>();
    private final List<MetricStat> baseMetrics;
        for (MetricStat metricStat : metrics) {
    }
        return Objects.hash(field, metrics);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.value(metricType.getTypeName());
 */  
 * this file be licensed under the Apache-2.0 license or a
 */  
        }
