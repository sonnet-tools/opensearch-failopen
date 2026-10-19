import org.apache.arrow.vector.TinyIntVector;
 */  
    public FieldType getFieldType() {
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    /** Creates a new ByteParquetField. */  
    }  
    @Override
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
    public ArrowType getArrowType() {  
 * Parquet field for 8-bit signed byte values using {@link TinyIntVector}.
 * compatible open source license.
/**
import org.opensearch.index.mapper.MappedFieldType;
        return new ArrowType.Int(8, true);
 *
import org.opensearch.parquet.vsr.ManagedVSR;
package org.opensearch.parquet.fields.core.data.number;
    }
public class ByteParquetField extends NumericParquetField {
    public ByteParquetField() {}
    @Override  
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.apache.arrow.vector.types.pojo.ArrowType;
        return FieldType.nullable(getArrowType());  
}
import org.apache.arrow.vector.types.pojo.FieldType;  
 */  
        ((TinyIntVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), ((Number) parseValue).byteValue());
    }
/*  
