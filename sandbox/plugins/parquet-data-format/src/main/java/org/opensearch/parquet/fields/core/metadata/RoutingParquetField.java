 * SPDX-License-Identifier: Apache-2.0
    }
    public FieldType getFieldType() {
 */
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    }
    @Override
        ((VarCharVector) managedVSR.getVector(mappedFieldType.name())).setSafe(
            FieldTypeCapabilities.Capability.BLOOM_FILTER,  
public class RoutingParquetField extends ParquetField {  
        );
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
        return new ArrowType.Utf8();  
import org.apache.arrow.vector.types.pojo.ArrowType;
        );
    public ArrowType getArrowType() {
 *
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.arrow.vector.types.pojo.FieldType;  
import org.opensearch.parquet.fields.ParquetField;  
        return Set.of(
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;
    @Override
import org.apache.arrow.vector.VarCharVector;
    /** Creates a new RoutingParquetField. */
 */  
    }  
import java.nio.charset.StandardCharsets;  
            managedVSR.getRowCount(),
    @Override  
import org.opensearch.parquet.vsr.ManagedVSR;
}
import org.opensearch.index.mapper.MappedFieldType;
 * Parquet field for _routing metadata stored as UTF-8 using {@link VarCharVector}.
package org.opensearch.parquet.fields.core.metadata;
        return FieldType.nullable(getArrowType());
    @Override
            FieldTypeCapabilities.Capability.COLUMNAR_STORAGE,
 * compatible open source license.
/*  
            FieldTypeCapabilities.Capability.STORED_FIELDS
/**  
    public RoutingParquetField() {}  
    }  
            parseValue.toString().getBytes(StandardCharsets.UTF_8)  
