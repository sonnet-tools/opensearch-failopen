 */  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.parquet.fields.core.data.number;
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
 *
    @Override
import org.apache.arrow.vector.types.pojo.FieldType;  
 */  
/*  
public class ShortParquetField extends NumericParquetField {
import org.apache.arrow.vector.types.pojo.ArrowType;
        return new ArrowType.Int(16, true);
}
import org.opensearch.parquet.vsr.ManagedVSR;
    @Override
        ((SmallIntVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Short) parseValue);
    public FieldType getFieldType() {
 * Parquet field for 16-bit signed short values using {@link SmallIntVector}.
/**
 * this file be licensed under the Apache-2.0 license or a
        return FieldType.nullable(getArrowType());  
import org.opensearch.index.mapper.MappedFieldType;
    @Override  
 * compatible open source license.
    public ShortParquetField() {}
    /** Creates a new ShortParquetField. */  
import org.apache.arrow.vector.SmallIntVector;
    }
    }  
    }
    public ArrowType getArrowType() {  
