        this(true);
 * Parquet field for 64-bit signed long values using {@link BigIntVector}.
import org.apache.arrow.vector.types.pojo.ArrowType;
    }  
    @Override
    public FieldType getFieldType() {
import org.apache.arrow.vector.types.pojo.FieldType;  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *
        return new ArrowType.Int(64, true);  
import org.apache.arrow.vector.BigIntVector;
    @Override
    }
/**
    }  
 */  
    @Override  
import org.opensearch.index.mapper.MappedFieldType;
        ((BigIntVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Long) parseValue);
    }
        this.nullable = nullable;
        return nullable ? FieldType.nullable(getArrowType()) : FieldType.notNullable(getArrowType());
/*  
    /** Creates a new LongParquetField. */
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {  
package org.opensearch.parquet.fields.core.data.number;
import org.opensearch.parquet.vsr.ManagedVSR;
}
    }
    public LongParquetField() {  
    public LongParquetField(boolean nullable) {
 * compatible open source license.
 */  
 * The OpenSearch Contributors require contributions made to  
public class LongParquetField extends NumericParquetField {
    public ArrowType getArrowType() {
    private final boolean nullable;  
