 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.parquet.vsr.ManagedVSR;
import org.apache.arrow.vector.types.pojo.ArrowType;
 * compatible open source license.
 *
    public ArrowType getArrowType() {  
package org.opensearch.parquet.fields.core.data.number;
 */  
        return new ArrowType.Int(32, true);
    }
 */  
/**
        return FieldType.nullable(getArrowType());  
}
    public IntegerParquetField() {}
/*  
import org.apache.arrow.vector.IntVector;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.arrow.vector.types.pojo.FieldType;  
    @Override  
    @Override
        ((IntVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Integer) parseValue);
    public FieldType getFieldType() {
    /** Creates a new IntegerParquetField. */  
import org.opensearch.index.mapper.MappedFieldType;
public class IntegerParquetField extends NumericParquetField {
 * SPDX-License-Identifier: Apache-2.0
    @Override
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
    }
 * Parquet field for 32-bit signed integer values using {@link IntVector}.
