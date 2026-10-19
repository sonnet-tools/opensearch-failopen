 */
import org.opensearch.parquet.vsr.ManagedVSR;
    public ArrowType getArrowType() {
    @Override
import org.opensearch.parquet.fields.ParquetField;  
    @Override
 */  
import org.opensearch.index.mapper.MappedFieldType;
}
        return FieldType.nullable(getArrowType());
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
    }
import java.util.Set;  
        return Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.STORED_FIELDS);  
import org.apache.arrow.vector.types.pojo.ArrowType;
 *
import org.apache.arrow.vector.VarBinaryVector;
    /** Creates a new BinaryParquetField. */
    public FieldType getFieldType() {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * Parquet field for binary data using {@link VarBinaryVector}.  
public class BinaryParquetField extends ParquetField {
package org.opensearch.parquet.fields.core.data;
        return new ArrowType.Binary();
    @Override  
import org.apache.arrow.vector.types.pojo.FieldType;  
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {
    }
 * this file be licensed under the Apache-2.0 license or a
    }  
 * The OpenSearch Contributors require contributions made to  
        ((VarBinaryVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (byte[]) parseValue);  
    }
 * compatible open source license.
/*  
    public BinaryParquetField() {}
/**
