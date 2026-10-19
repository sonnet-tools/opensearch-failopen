    @Override
package org.opensearch.parquet.fields.core.data.number;
}  
import org.apache.arrow.vector.types.pojo.ArrowType;  
 */  
 * SPDX-License-Identifier: Apache-2.0
    public ArrowType getArrowType() {
 */
 *
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
import org.apache.arrow.vector.Float8Vector;
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
/*  
        return new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE);
    public FieldType getFieldType() {  
import org.apache.arrow.vector.types.pojo.FieldType;
    @Override  
    /** Creates a new DoubleParquetField. */
 * The OpenSearch Contributors require contributions made to  
public class DoubleParquetField extends NumericParquetField {
        return FieldType.nullable(getArrowType());
/**
    }
        ((Float8Vector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (Double) parseValue);  
 * Parquet field for double-precision floating-point values using {@link Float8Vector}.  
 * compatible open source license.
    }  
    public DoubleParquetField() {}
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.arrow.vector.types.FloatingPointPrecision;
import org.opensearch.parquet.vsr.ManagedVSR;  
