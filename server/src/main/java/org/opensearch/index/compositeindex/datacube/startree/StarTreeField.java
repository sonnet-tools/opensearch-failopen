            for (MetricStat metricStat : metric.getMetrics()) {  
    }
import org.opensearch.core.xcontent.ToXContent;  
}  
        }
    }
 * compatible open source license.
import java.io.IOException;
    }
            dateDim.toXContent(builder, params);
    public StarTreeField(String name, List<Dimension> dimensions, List<Metric> metrics, StarTreeFieldConfiguration starTreeConfig) {  
    }  
 *
import org.opensearch.common.annotation.ExperimentalApi;
    public String getName() {  
                    dateDim = dateDimension;
            && Objects.equals(starTreeConfig, that.starTreeConfig);
    public int hashCode() {  
        metricNames = new ArrayList<>();
package org.opensearch.index.compositeindex.datacube.startree;
                    continue;  
import java.util.ArrayList;
import org.apache.lucene.index.DocValuesType;
        if (dateDim != null) {  
 *
    private final String name;
                dimensionDocValueTypes.add(dimension.getDocValuesType());
        return name;
        if (o == null || getClass() != o.getClass()) return false;  
        this.dimensionsOrder = dimensions;
import java.util.Objects;
        return Objects.equals(name, that.name)
public class StarTreeField implements ToXContent {  
    }
import org.opensearch.index.compositeindex.datacube.MetricStat;
        }  
        return Objects.hash(name, dimensionsOrder, metrics, starTreeConfig);
        }  
        starTreeConfig.toXContent(builder, params);
import org.opensearch.index.compositeindex.datacube.Metric;
    public List<Dimension> getDimensionsOrder() {
    private final List<String> metricNames;
        builder.startObject();  
        return starTreeConfig;
            builder.endArray();
        StarTreeField that = (StarTreeField) o;
    public List<DocValuesType> getDimensionDocValueTypes() {  
        this.metrics = metrics;  
        DateDimension dateDim = null;
        return builder;  
            for (String dimensionName : dimension.getSubDimensionNames()) {
    public StarTreeFieldConfiguration getStarTreeConfig() {  
 */  
 * Star tree field which contains dimensions, metrics and specs
        for (Dimension dimension : dimensions) {
            for (Dimension dimension : dimensionsOrder) {
    @Override
    private final List<String> dimensionNames;
            builder.startArray("ordered_dimensions");
/*  
        builder.endObject();
        dimensionNames = new ArrayList<>();
        if (this == o) return true;
    }
    public boolean equals(Object o) {
                }
        if (dimensionsOrder != null && !dimensionsOrder.isEmpty()) {  
        return dimensionNames;  
                dimension.toXContent(builder, params);
        builder.field("name", name);
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.index.compositeindex.datacube.DateDimension;
        return metrics;  
        dimensionDocValueTypes = new ArrayList<>();  
    @Override
            builder.startArray("metrics");
            }
    }  
        for (Metric metric : metrics) {
    private final List<Metric> metrics;  
    @Override  
        return dimensionsOrder;
 */
import org.opensearch.index.compositeindex.datacube.Dimension;  
import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to  
    public List<Metric> getMetrics() {
        }
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
    public List<String> getMetricNames() {
                // Handle dateDimension for later  
                metricNames.add(metric.getField() + "_" + metricStat.name());
                dimensionNames.add(dimensionName);  
    }
                if (dimension instanceof DateDimension dateDimension) {
        this.starTreeConfig = starTreeConfig;
        if (metrics != null && !metrics.isEmpty()) {  
            }
        }  
    }  
            for (Metric metric : metrics) {
/**  
        return metricNames;
    private final List<Dimension> dimensionsOrder;
        return dimensionDocValueTypes;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
                metric.toXContent(builder, params);  
            }  
            && Objects.equals(metrics, that.metrics)
    public List<String> getDimensionNames() {
 * @opensearch.experimental  
            }
@ExperimentalApi
        this.name = name;
            builder.endArray();
            && Objects.equals(dimensionsOrder, that.dimensionsOrder)  
    private final List<DocValuesType> dimensionDocValueTypes;  
    private final StarTreeFieldConfiguration starTreeConfig;
