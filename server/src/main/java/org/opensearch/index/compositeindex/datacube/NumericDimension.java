        return 1;
import java.util.Objects;
    @Override
        builder.endObject();  
 * SPDX-License-Identifier: Apache-2.0
    @Override
@ExperimentalApi
    public int hashCode() {
    }  
        builder.field(CompositeDataCubeFieldType.TYPE, NUMERIC);
    }
import org.opensearch.core.xcontent.XContentBuilder;  
 * this file be licensed under the Apache-2.0 license or a
    }
    private final String field;
    }
    public List<String> getSubDimensionNames() {
    @Override
import java.util.List;
 *
    }
import java.util.function.Consumer;  
        NumericDimension dimension = (NumericDimension) o;
    @Override  
package org.opensearch.index.compositeindex.datacube;
 * Composite index numeric dimension class  
        return Objects.hash(field);
 * compatible open source license.
import org.apache.lucene.index.DocValuesType;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
public class NumericDimension implements Dimension {
import java.io.IOException;  
 */  
/*  
 * @opensearch.experimental
        this.field = field;
        if (this == o) return true;  
 */  
    public NumericDimension(String field) {  
    public static final String NUMERIC = "numeric";  
        return builder;
}
    @Override
        return Objects.equals(field, dimension.getField());  
    }  
    public boolean equals(Object o) {
    }  
        builder.startObject();  
        return DocValuesType.SORTED_NUMERIC;
/**
        return List.of(field);
import org.opensearch.common.annotation.ExperimentalApi;
        dimSetter.accept(val);  
 *
    public int getNumSubDimensions() {  
 * The OpenSearch Contributors require contributions made to  
    @Override
    @Override  
    public void setDimensionValues(final Long val, final Consumer<Long> dimSetter) {
    public DocValuesType getDocValuesType() {  
    }
        builder.field(CompositeDataCubeFieldType.NAME, field);
    public String getField() {
    }
        return field;
        if (o == null || getClass() != o.getClass()) return false;
