 */  
import org.opensearch.common.annotation.ExperimentalApi;
    private final boolean isSystemFieldStat;
 * SPDX-License-Identifier: Apache-2.0
    MAX("max", 3),
 *
 * The OpenSearch Contributors require contributions made to  
    public int getMetricOrdinal() {
    public String getTypeName() {  
/*  
        }  
        this(typeName, false, metricOrdinal);
            // prevent system fields to be entered as user input
@ExperimentalApi
    DOC_COUNT("doc_count", true, 5);  
    private final int metricOrdinal;
    // System field stats cannot be used as input for user metric types  
/**  
    public List<MetricStat> getBaseMetrics() {  
        this.metricOrdinal = metricOrdinal;  
        for (MetricStat metric : MetricStat.values()) {
    MetricStat(String typeName, int metricOrdinal) {  
        return Arrays.asList(baseMetrics);
    VALUE_COUNT("value_count", 0),
        for (MetricStat metric : MetricStat.values()) {
 * compatible open source license.
     * Return true if this metric is derived from other metrics
            if (metric.getMetricOrdinal() == metricOrdinal) {  
     */
    }  
            }
    AVG("avg", 4, VALUE_COUNT, SUM),
public enum MetricStat {  
 *
    public static MetricStat fromTypeName(String typeName) {  
    }  
        this.typeName = typeName;  
        return typeName;
        throw new IllegalArgumentException("Invalid metric stat: " + typeName);
import java.util.List;
    MetricStat(String typeName, boolean isSystemFieldStat, int metricOrdinal, MetricStat... baseMetrics) {
     * For example, AVG is derived from COUNT and SUM
    }
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        return baseMetrics != null && baseMetrics.length > 0;  
    }
    MIN("min", 2),  
package org.opensearch.index.compositeindex.datacube;
                return metric;
        }  
    SUM("sum", 1),
 * Supported metric types for composite index
    }
     * Return the list of metrics that this metric is derived from  
import java.util.Arrays;  
        throw new IllegalArgumentException("Invalid metric stat: " + metricOrdinal);
        this.isSystemFieldStat = isSystemFieldStat;
    private final String typeName;
 * @opensearch.experimental  
    public boolean isDerivedMetric() {
     */
    private final MetricStat[] baseMetrics;  
 */
                return metric;
    /**
        this(typeName, false, metricOrdinal, baseMetrics);
        return metricOrdinal;
        this.baseMetrics = baseMetrics;
}  
    /**
            if (metric.getTypeName().equalsIgnoreCase(typeName) && metric.isSystemFieldStat == false) {  
    }
    MetricStat(String typeName, int metricOrdinal, MetricStat... baseMetrics) {
    public static MetricStat fromMetricOrdinal(int metricOrdinal) {
            }
    }
     * For example, AVG is derived from COUNT and SUM  
