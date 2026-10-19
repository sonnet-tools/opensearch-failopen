        return new ArrowType.Binary();  
            FieldTypeCapabilities.Capability.STORED_FIELDS
package org.opensearch.parquet.fields.core.metadata;
import org.opensearch.parquet.vsr.ManagedVSR;
        vector.setSafe(managedVSR.getRowCount(), (byte[]) parseValue);
 */
 * Parquet field for document _id metadata stored as binary using {@link VarBinaryVector}.  
import java.util.Set;  
    @Override
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
 * compatible open source license.
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.parquet.fields.ParquetField;  
    /** Creates a new IdParquetField. */
 * this file be licensed under the Apache-2.0 license or a
    public FieldType getFieldType() {
            FieldTypeCapabilities.Capability.COLUMNAR_STORAGE,
    public ArrowType getArrowType() {
import org.opensearch.index.mapper.MappedFieldType;
 *
    }
/*  
    }  
            FieldTypeCapabilities.Capability.BLOOM_FILTER,  
/**
}
public class IdParquetField extends ParquetField {
    }  
    public IdParquetField() {}
        VarBinaryVector vector = (VarBinaryVector) managedVSR.getVector(mappedFieldType.name());  
        return Set.of(
import org.apache.arrow.vector.VarBinaryVector;
 * SPDX-License-Identifier: Apache-2.0
    @Override
        return FieldType.notNullable(getArrowType());
    @Override  
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
import org.apache.arrow.vector.types.pojo.FieldType;  
    }
import org.apache.arrow.vector.types.pojo.ArrowType;
    @Override
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        );
