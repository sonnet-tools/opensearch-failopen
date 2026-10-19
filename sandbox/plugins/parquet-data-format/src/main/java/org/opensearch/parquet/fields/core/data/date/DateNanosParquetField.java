    @Override
    /** Creates a new DateNanosParquetField. */
import org.opensearch.parquet.vsr.ManagedVSR;
        return new ArrowType.Timestamp(TimeUnit.NANOSECOND, null);  
    public DateNanosParquetField() {}  
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * compatible open source license.
 * Parquet field for date_nanos values stored as nanosecond timestamps using {@link TimeStampNanoVector}.
    }
 * this file be licensed under the Apache-2.0 license or a
    }
 */
/*  
 */  
/**  
        return FieldType.nullable(getArrowType());
import org.opensearch.parquet.fields.ParquetField;
    public FieldType getFieldType() {
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {  
 * The OpenSearch Contributors require contributions made to  
    public ArrowType getArrowType() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.TimeStampNanoVector;
    @Override
    @Override  
package org.opensearch.parquet.fields.core.data.date;
}  
        ((TimeStampNanoVector) managedVSR.getVector(mappedFieldType.name())).setSafe(managedVSR.getRowCount(), (long) parseValue);
import org.apache.arrow.vector.types.pojo.ArrowType;  
    }  
    }
import org.apache.arrow.vector.types.TimeUnit;
import java.util.Set;
import org.opensearch.index.mapper.MappedFieldType;  
public class DateNanosParquetField extends ParquetField {  
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
        return Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.BLOOM_FILTER);
 *
