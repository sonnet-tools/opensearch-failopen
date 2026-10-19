    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {  
import org.opensearch.index.mapper.MappedFieldType;
        return new ArrowType.Utf8();  
            FieldTypeCapabilities.Capability.COLUMNAR_STORAGE,
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.apache.arrow.vector.types.pojo.ArrowType;
        ((VarCharVector) managedVSR.getVector(mappedFieldType.name())).setSafe(
        );
            managedVSR.getRowCount(),
    @Override  
import org.opensearch.parquet.fields.ParquetField;  
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
    @Override
        );
            FieldTypeCapabilities.Capability.BLOOM_FILTER,  
    /** Creates a new TextParquetField. */
/**  
 */
/*  
        return FieldType.nullable(getArrowType());
package org.opensearch.parquet.fields.core.data.text;
    }  
    public ArrowType getArrowType() {
    public TextParquetField() {}  
            parseValue.toString().getBytes(StandardCharsets.UTF_8)  
 *
import java.util.Set;
    @Override
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
 * compatible open source license.
        return Set.of(
}
import org.opensearch.parquet.vsr.ManagedVSR;
import java.nio.charset.StandardCharsets;  
    }
 * Parquet field for text values using {@link VarCharVector} with UTF-8 encoding.
 */  
import org.apache.arrow.vector.VarCharVector;
    }
public class TextParquetField extends ParquetField {  
import org.apache.arrow.vector.types.pojo.FieldType;  
 * SPDX-License-Identifier: Apache-2.0
            FieldTypeCapabilities.Capability.STORED_FIELDS
    }  
    public FieldType getFieldType() {
 * The OpenSearch Contributors require contributions made to  
