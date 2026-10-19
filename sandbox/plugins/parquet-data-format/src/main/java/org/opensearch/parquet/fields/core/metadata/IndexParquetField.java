    @Override  
        throw new IllegalStateException("Index field is not supposed to be added to group");  
    }
import org.apache.arrow.vector.types.pojo.FieldType;
}  
 *
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.opensearch.index.mapper.MappedFieldType;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.parquet.fields.ParquetField;
    public FieldType getFieldType() {  
    @Override
    protected void addToGroup(MappedFieldType fieldType, ManagedVSR managedVSR, Object parseValue) {
 * Parquet field for index name.
 * This is a placeholder for declaring support for the field.  
package org.opensearch.parquet.fields.core.metadata;
/**
        return null;
    }  
 * compatible open source license.
 */  
    public ArrowType getArrowType() {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
public class IndexParquetField extends ParquetField {
    @Override
import org.opensearch.parquet.vsr.ManagedVSR;
        return null;
    }
 */
/*  
