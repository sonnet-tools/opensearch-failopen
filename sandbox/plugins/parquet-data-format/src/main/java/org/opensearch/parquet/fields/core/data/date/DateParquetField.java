    }
/**  
    }
 */  
 * Parquet field for date values stored as millisecond timestamps using {@link TimeStampMilliVector}.
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    @Override
 */
import org.apache.arrow.vector.types.pojo.FieldType;
    }  
 * The OpenSearch Contributors require contributions made to  
public class DateParquetField extends ParquetField {  
import org.apache.arrow.vector.types.pojo.ArrowType;  
    @Override
 *
        return new ArrowType.Timestamp(TimeUnit.MILLISECOND, null);  
import org.opensearch.parquet.fields.ParquetField;
    }
import org.apache.arrow.vector.types.TimeUnit;
        return Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.BLOOM_FILTER);
/*  
 * compatible open source license.
    public ArrowType getArrowType() {
    public DateParquetField() {}  
import org.opensearch.index.mapper.MappedFieldType;  
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {  
}  
        return FieldType.nullable(getArrowType());
    /** Creates a new DateParquetField. */
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
    @Override
        ((TimeStampMilliVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (long) parseValue);
import org.apache.arrow.vector.TimeStampMilliVector;
package org.opensearch.parquet.fields.core.data.date;
    public FieldType getFieldType() {
import org.opensearch.parquet.vsr.ManagedVSR;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
