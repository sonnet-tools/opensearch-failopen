    public List<String> getSubDimensionNames() {  
import java.util.function.Consumer;  
    public void setDimensionValues(Long value, Consumer<Long> dimSetter) {  
    }
public class IpDimension implements Dimension {
    }
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return Objects.hash(field);
        return 1;
import java.util.List;
        builder.field(CompositeDataCubeFieldType.TYPE, IP);
@ExperimentalApi
    @Override
        return Objects.equals(field, dimension.getField());
        builder.endObject();
    public static final String IP = "ip";  
    }
    }
        return builder;  
 *
    @Override
        this.field = field;
    @Override
package org.opensearch.index.compositeindex.datacube;
        return DocValuesType.SORTED_SET;  
    @Override  
    }  
        if (this == o) return true;
        builder.field(CompositeDataCubeFieldType.NAME, field);  
import java.io.IOException;  
    }  
    }  
}  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
    public String getField() {
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object o) {
        // This will set the keyword dimension value's ordinal
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * @opensearch.experimental
import org.apache.lucene.index.DocValuesType;
    @Override  
    @Override
    public int hashCode() {  
 *
    }
    public int getNumSubDimensions() {
        return field;  
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
import org.opensearch.common.annotation.ExperimentalApi;
 * Composite index keyword dimension class  
    public DocValuesType getDocValuesType() {
        dimSetter.accept(value);
    @Override  
        return List.of(field);
/*  
/**
        if (o == null || getClass() != o.getClass()) return false;  
    }
    public IpDimension(String field) {  
        builder.startObject();
import org.opensearch.core.xcontent.XContentBuilder;  
        IpDimension dimension = (IpDimension) o;
 */  
    private final String field;
 */  
