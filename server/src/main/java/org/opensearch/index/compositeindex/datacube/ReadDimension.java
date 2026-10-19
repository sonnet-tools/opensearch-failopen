    private final DimensionDataType dimensionDataType;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.DocValuesType;
    @Override
    }
    public DocValuesType getDocValuesType() {
    private final DocValuesType docValuesType;  
    public void setDimensionValues(final Long val, final Consumer<Long> dimSetter) {
        this.field = field;
    public ReadDimension(String field, DocValuesType docValuesType) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field(CompositeDataCubeFieldType.TYPE, READ);
    @Override
 * @opensearch.experimental
    public boolean equals(Object o) {
/**
import java.io.IOException;
    }
        return 1;  
 *
    }
 * compatible open source license.
        return builder;  
import java.util.List;  
        this.dimensionDataType = DimensionDataType.LONG;  
    }
        builder.endObject();
 */
    }  
import java.util.function.Consumer;
    @Override  
    @Override
}  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.index.mapper.CompositeDataCubeFieldType;  
    @Override  
        return Objects.hash(field);
    }
        dimSetter.accept(val);
    public ReadDimension(String field, DocValuesType docValuesType, DimensionDataType dimensionDataType) {  
    public ReadDimension(String field) {  
        return List.of(field);
        this.field = field;
        builder.field(CompositeDataCubeFieldType.NAME, field);  
        return docValuesType;  
        return Objects.equals(field, dimension.getField());
    @Override
        this.dimensionDataType = DimensionDataType.LONG;  
    }  
package org.opensearch.index.compositeindex.datacube;
        this.docValuesType = docValuesType;
    }
        this.dimensionDataType = dimensionDataType;  
 *  
        if (this == o) return true;
/*  
    @Override
        this.field = field;
 */  
        this.docValuesType = DocValuesType.SORTED_NUMERIC;
    }
import java.util.Objects;
    public List<String> getSubDimensionNames() {  
 * Represents a dimension for reconstructing StarTreeField from file formats during searches and merges.
        this.docValuesType = docValuesType;
        return field;
    public DimensionDataType getDimensionDataType() {
    public static final String READ = "read";
    }
    public int hashCode() {  
        return dimensionDataType;  
        if (o == null || getClass() != o.getClass()) return false;  
        builder.startObject();
    }
    public int getNumSubDimensions() {
    private final String field;
    @Override  
public class ReadDimension implements Dimension {  
    public String getField() {  
        ReadDimension dimension = (ReadDimension) o;
 * this file be licensed under the Apache-2.0 license or a
    }
 * SPDX-License-Identifier: Apache-2.0
