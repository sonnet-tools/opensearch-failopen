        return List.of(field);
/**
    public OrdinalDimension(String field) {  
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
 * @opensearch.experimental
    }
/*  
        OrdinalDimension dimension = (OrdinalDimension) o;
    @Override  
    }  
        builder.startObject();
    }
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
    }
        this.field = field;
 */  
 *
    @Override  
    @Override
    public int hashCode() {  
public class OrdinalDimension implements Dimension {
import org.apache.lucene.index.DocValuesType;
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
    public String getField() {
        // This will set the keyword dimension value's ordinal
    public int getNumSubDimensions() {
        if (o == null || getClass() != o.getClass()) return false;  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        if (this == o) return true;
    }
    @Override
        return Objects.hash(field);
    public DocValuesType getDocValuesType() {
import java.util.Objects;
}  
import java.util.List;
        return DocValuesType.SORTED_SET;  
        return Objects.equals(field, dimension.getField());
    }  
        builder.endObject();
        return field;  
        return 1;
    }
 * The OpenSearch Contributors require contributions made to  
        dimSetter.accept(value);
    public boolean equals(Object o) {
    public void setDimensionValues(Long value, Consumer<Long> dimSetter) {  
@ExperimentalApi
    }
package org.opensearch.index.compositeindex.datacube;
 *
        builder.field(CompositeDataCubeFieldType.NAME, field);  
    private final String field;
import org.opensearch.common.annotation.ExperimentalApi;
    @Override  
    @Override
 * Composite index keyword dimension class  
import java.util.function.Consumer;  
        builder.field(CompositeDataCubeFieldType.TYPE, ORDINAL);
    public static final String ORDINAL = "ordinal";  
import java.io.IOException;  
    }  
 * SPDX-License-Identifier: Apache-2.0
    public List<String> getSubDimensionNames() {  
        return builder;  
