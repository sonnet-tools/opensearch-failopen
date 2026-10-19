        return new ArrowType.Int(32, true);
import org.apache.arrow.vector.types.pojo.ArrowType;
    /** Creates a new TokenCountParquetField. */  
/*  
    @Override
 * Parquet field for token count values stored as 32-bit integers using {@link IntVector}.
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
    public FieldType getFieldType() {
    @Override
 */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.parquet.vsr.ManagedVSR;
 */  
public class TokenCountParquetField extends NumericParquetField {
    public TokenCountParquetField() {}
import org.opensearch.index.mapper.MappedFieldType;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.parquet.fields.core.data.number;
    }
    }  
}
    }
        return FieldType.nullable(getArrowType());  
    @Override  
import org.apache.arrow.vector.types.pojo.FieldType;  
    public ArrowType getArrowType() {  
 * compatible open source license.
/**
        ((IntVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Integer) parseValue);
 *
 * The OpenSearch Contributors require contributions made to  
import org.apache.arrow.vector.IntVector;
