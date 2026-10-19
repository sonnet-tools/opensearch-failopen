    public KeywordParquetField() {}
/*  
import org.apache.arrow.vector.types.pojo.ArrowType;  
 * Parquet field for keyword values using {@link VarCharVector} with UTF-8 encoding.  
    @Override  
import org.opensearch.index.mapper.MappedFieldType;
 * compatible open source license.
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
import org.apache.arrow.vector.VarCharVector;
 * The OpenSearch Contributors require contributions made to  
        return new ArrowType.Utf8();  
    }
import org.apache.arrow.vector.types.pojo.FieldType;
    }  
    @Override
    }
 */
    @Override  
        ((VarCharVector) vector).setSafe(index, parseValue.toString().getBytes(StandardCharsets.UTF_8));
 */  
import java.nio.charset.StandardCharsets;  
    }
public class KeywordParquetField extends ParquetField {
package org.opensearch.parquet.fields.core.data.text;
    protected void addToVector(FieldVector vector, int index, Object parseValue) {
    public ArrowType getArrowType() {
    @Override
}
    }  
 *
        return true;
    public boolean supportsMultiValue() {  
import org.opensearch.parquet.vsr.ManagedVSR;
    public FieldType getFieldType() {
import org.opensearch.parquet.fields.ParquetField;  
/**
 * SPDX-License-Identifier: Apache-2.0
    /** Creates a new KeywordParquetField. */
import org.apache.arrow.vector.FieldVector;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return FieldType.nullable(getArrowType());
        addToVector(managedVSR.getVector(mappedFieldType.name()), managedVSR.getRowCount(), parseValue);  
