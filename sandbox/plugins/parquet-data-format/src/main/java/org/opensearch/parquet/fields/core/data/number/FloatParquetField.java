/*  
    public FieldType getFieldType() {  
    public FloatParquetField() {}
 */
public class FloatParquetField extends NumericParquetField {
    /** Creates a new FloatParquetField. */
        return new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE);
        return FieldType.nullable(getArrowType());
import org.apache.arrow.vector.Float4Vector;
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
import org.apache.arrow.vector.types.pojo.FieldType;
import org.opensearch.parquet.vsr.ManagedVSR;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.parquet.fields.core.data.number;
}  
/**
import org.apache.arrow.vector.types.FloatingPointPrecision;
    }
import org.apache.arrow.vector.types.pojo.ArrowType;  
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
 * Parquet field for single-precision floating-point values using {@link Float4Vector}.  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    @Override  
 */  
    }
        ((Float4Vector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Float) parseValue);  
import org.opensearch.index.mapper.MappedFieldType;
    @Override
    public ArrowType getArrowType() {
