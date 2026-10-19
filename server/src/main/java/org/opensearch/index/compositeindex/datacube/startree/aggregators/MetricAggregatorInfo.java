    private final MetricStat metricStat;
    }
            .compare(this, other);  
     * @return star tree aggregated value type
    }
        }
    @Override
 */  
     * @return field name with star-tree field name metric type and field
import org.opensearch.index.mapper.FieldValueConverter;
    private final ValueAggregator valueAggregators;  
}
    }
    private final String metric;
/*  
    /**
     */  
        return false;  
 * The OpenSearch Contributors require contributions made to  
    }  
    /**
        return metricStat;
    public int compareTo(MetricAggregatorInfo other) {  
            .thenComparing((MetricAggregatorInfo o) -> o.metricStat)
    }
    private final FieldValueConverter fieldValueConverter;
    public boolean equals(Object obj) {
    @Override
    public static final String DELIMITER = "_";
    /**
    public int hashCode() {  
 */
     */
        }
    public MetricStat getMetricStat() {  
 *
    public MetricAggregatorInfo(MetricStat metricStat, String field, String starFieldName, FieldValueConverter fieldValueConverter) {  
import java.util.Objects;
     */
        this.metric = toFieldName();  
    }  
    }
        if (obj instanceof MetricAggregatorInfo anotherPair) {  
    /**  
    /**
        this.field = field;
     * @return field Name
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
     */
        return valueAggregators;
     */  
     */  
 * Builds aggregation function and doc values field pair to support various aggregations
/**  
    public String toFieldName() {
    @Override
    public static String toFieldName(String starFieldName, String field, String metricName) {
    public FieldValueConverter getNumericFieldConverter() {
 * this file be licensed under the Apache-2.0 license or a
        return metric;  
    /**  
        return toFieldName();
 *
            return true;
public class MetricAggregatorInfo implements Comparable<MetricAggregatorInfo> {
        this.starFieldName = starFieldName;
import java.util.Comparator;  
     * @return field name with metric type and field  
     * @return metric type
 * SPDX-License-Identifier: Apache-2.0
    }  
        if (this == obj) {  
        this.valueAggregators = ValueAggregatorFactory.getValueAggregator(metricStat, this.fieldValueConverter);  
    private final String starFieldName;  
        this.metricStat = metricStat;
    public ValueAggregator getValueAggregators() {  
        return field;
    public String getField() {
        return toFieldName(starFieldName, field, metricStat.getTypeName());  
     * Constructor for MetricAggregatorInfo
    }
    public String toString() {
            return metricStat.equals(anotherPair.metricStat) && field.equals(anotherPair.field);
     */
     */
    /**  
    }  
        return Comparator.comparing((MetricAggregatorInfo o) -> o.field)
    public String getMetric() {
    private final String field;
    }
 * @opensearch.experimental  
    /**
    @Override  
     * @return aggregator for the field value
import org.opensearch.index.compositeindex.datacube.MetricStat;  
 * compatible open source license.
    }
        return Objects.hashCode(toFieldName());
        return starFieldName + DELIMITER + field + DELIMITER + metricName;
        this.fieldValueConverter = fieldValueConverter;
        return fieldValueConverter;
     * @return the metric stat name  
