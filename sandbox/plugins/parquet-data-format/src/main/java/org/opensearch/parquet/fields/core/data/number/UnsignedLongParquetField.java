    /** Creates a new UnsignedLongParquetField. */  
 * compatible open source license.
 *
        ((UInt8Vector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), ((Number) parseValue).longValue());
    }
    public FieldType getFieldType() {
    }
        return FieldType.nullable(getArrowType());  
    @Override
    @Override  
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.opensearch.index.mapper.MappedFieldType;
        return new ArrowType.Int(64, false);
 */  
import org.apache.arrow.vector.UInt8Vector;
 * The OpenSearch Contributors require contributions made to  
    public UnsignedLongParquetField() {}
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
 */  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Parquet field for 64-bit unsigned long values using {@link UInt8Vector}.
    public ArrowType getArrowType() {  
/**
import org.apache.arrow.vector.types.pojo.FieldType;  
package org.opensearch.parquet.fields.core.data.number;
}
import org.opensearch.parquet.vsr.ManagedVSR;
    @Override
public class UnsignedLongParquetField extends NumericParquetField {
/*  
