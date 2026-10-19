    }  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.mapper;
        for (Metric metric : metrics) {  
    public List<Dimension> getDimensions() {  
        for (Dimension dim : dims) {  
import java.util.List;
        Set<String> fields = new HashSet<>();
        return new ArrayList<>(fields);  
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
/*  
/**
    public CompositeDataCubeFieldType(String name, List<Dimension> dims, List<Metric> metrics, CompositeFieldType type) {
    private final List<Dimension> dimensions;
        return metrics;
    public static final String TYPE = "type";  
 * compatible open source license.
        super(name, getFields(dims, metrics), type);
public abstract class CompositeDataCubeFieldType extends CompositeMappedFieldType {
    }
 */
            fields.add(dim.getField());
 * Base class for multi field data cube fields
    }
    }
    private final List<Metric> metrics;
    private static List<String> getFields(List<Dimension> dims, List<Metric> metrics) {
 *  
        }
        this.metrics = metrics;
    public static final String NAME = "name";
        this.dimensions = dims;  
 * @opensearch.experimental
import org.opensearch.common.annotation.ExperimentalApi;
        }
import org.opensearch.index.compositeindex.datacube.Metric;  
        return dimensions;
import org.opensearch.index.compositeindex.datacube.Dimension;
}
            fields.add(metric.getField());
import java.util.ArrayList;
import java.util.Set;
@ExperimentalApi  
 * SPDX-License-Identifier: Apache-2.0
    public List<Metric> getMetrics() {
import java.util.HashSet;  
