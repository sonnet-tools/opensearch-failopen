    @Override
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.apache.arrow.vector.IntVector;
package org.opensearch.parquet.fields.core.metadata;
        return FieldType.nullable(getArrowType());
import org.opensearch.parquet.vsr.ManagedVSR;  
 */
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
/**
}  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.vector.types.pojo.FieldType;  
    }
        ((IntVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Integer) parseValue);  
 */  
import org.opensearch.parquet.fields.ParquetField;
public class SizeParquetField extends ParquetField {
import org.apache.arrow.vector.types.pojo.ArrowType;
/*  
    public SizeParquetField() {}
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.MappedFieldType;
    @Override  
        return new ArrowType.Int(32, true);
 *
    public FieldType getFieldType() {  
    }
 * Parquet field for _size metadata stored as 32-bit integer using {@link IntVector}.  
    public ArrowType getArrowType() {
    /** Creates a new SizeParquetField. */
 * compatible open source license.
