 * The OpenSearch Contributors require contributions made to  
    public FieldType getFieldType() {
    public ArrowType getArrowType() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
 */
    @Override
import org.opensearch.parquet.fields.ParquetField;  
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {  
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
/*  
 */  
    }  
        );
        ((VarCharVector) managedVSR.getVector(mappedFieldType.name())).setSafe(
    /** Creates a new IgnoredParquetField. */
/**  
public class IgnoredParquetField extends ParquetField {  
 * Parquet field for _ignored metadata stored as UTF-8 using {@link VarCharVector}.
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;
import java.nio.charset.StandardCharsets;  
import org.apache.arrow.vector.VarCharVector;
 * compatible open source license.
    }
    public IgnoredParquetField() {}  
import org.opensearch.index.mapper.MappedFieldType;
        return new ArrowType.Utf8();  
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    }
    @Override  
import org.apache.arrow.vector.types.pojo.FieldType;  
import org.apache.arrow.vector.types.pojo.ArrowType;
    }
}  
        return FieldType.nullable(getArrowType());
 * this file be licensed under the Apache-2.0 license or a
        return Set.of(STORED_FIELDS, COLUMNAR_STORAGE);
import org.opensearch.parquet.vsr.ManagedVSR;
 *
            managedVSR.getRowCount(),
            parseValue.toString().getBytes(StandardCharsets.UTF_8)  
    @Override
package org.opensearch.parquet.fields.core.metadata;
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;  
