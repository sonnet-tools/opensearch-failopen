 *
    @Override
/*  
        ((BitVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Boolean) parseValue ? 1 : 0);  
import org.apache.arrow.vector.types.pojo.ArrowType;
 * The OpenSearch Contributors require contributions made to  
 */  
    }
    }  
public class BooleanParquetField extends ParquetField {
package org.opensearch.parquet.fields.core.data;
    }
    @Override  
    /** Creates a new BooleanParquetField. */
    @Override
import org.opensearch.parquet.vsr.ManagedVSR;
    public ArrowType getArrowType() {
        return new ArrowType.Bool();
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.index.mapper.MappedFieldType;
 * compatible open source license.
import org.opensearch.parquet.fields.ParquetField;  
/**
    public FieldType getFieldType() {
}
    @Override
import org.apache.arrow.vector.types.pojo.FieldType;  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        return Set.of(FieldTypeCapabilities.Capability.BLOOM_FILTER, FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
import org.apache.arrow.vector.BitVector;
        return FieldType.nullable(getArrowType());  
 * Parquet field for boolean values using {@link BitVector}.  
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
import java.util.Set;  
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
    }
 * SPDX-License-Identifier: Apache-2.0
    public BooleanParquetField() {}
