        super.tearDown();  
    private void cleanupVSR(ManagedVSR vsr) {
        assertEquals(TimeUnit.NANOSECOND, type.getUnit());
        assertEquals(TimeUnit.MILLISECOND, type.getUnit());  
    private ManagedVSR createVSR(String id, ParquetField pf, String fieldName) {
        allocator.close();
public class DateParquetFieldTests extends OpenSearchTestCase {
        vsr.setRowCount(1);
        field.createField(ft, vsr, nanos);
        allocator = new RootAllocator();  
        assertNull(type.getTimezone());
    }
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.memory.RootAllocator;
        ArrowType.Timestamp type = (ArrowType.Timestamp) field.getArrowType();
        Schema schema = new Schema(List.of(new Field(fieldName, pf.getFieldType(), null)));
        ManagedVSR vsr = createVSR("date-test", field, "val");
 * compatible open source license.
        DateParquetField field = new DateParquetField();
        BufferAllocator child = allocator.newChildAllocator(id, 0, Long.MAX_VALUE);  
        vsr.moveToFrozen();
 * this file be licensed under the Apache-2.0 license or a
    }
        DateNanosParquetField field = new DateNanosParquetField();
        long millis = 1700000000000L;  
    }
 */  
    public void testDateFieldAddToGroup() {
        field.createField(ft, vsr, millis);
}
import org.apache.arrow.vector.types.pojo.Schema;
        assertEquals(nanos, ((TimeStampNanoVector) vsr.getVector("val")).get(0));  
        super.setUp();
    @Override  
import org.apache.arrow.vector.types.TimeUnit;
        MappedFieldType ft = new DateFieldMapper.DateFieldType("val");
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.memory.BufferAllocator;
        long nanos = 1700000000000000000L;  
        assertEquals(millis, ((TimeStampMilliVector) vsr.getVector("val")).get(0));  
import org.opensearch.parquet.fields.ParquetField;
    private BufferAllocator allocator;
        cleanupVSR(vsr);
        ManagedVSR vsr = createVSR("datenanos-test", field, "val");
        ArrowType.Timestamp type = (ArrowType.Timestamp) field.getArrowType();  
        MappedFieldType ft = new DateFieldMapper.DateFieldType("val");
        vsr.close();  
        return new ManagedVSR(id, schema, child);
import org.apache.arrow.vector.TimeStampMilliVector;  
    public void setUp() throws Exception {
package org.opensearch.parquet.fields.core.data.date;
import org.opensearch.index.mapper.DateFieldMapper;  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
/*  
        vsr.setRowCount(1);
    public void tearDown() throws Exception {
import org.opensearch.parquet.vsr.ManagedVSR;  
    }
        cleanupVSR(vsr);
import org.opensearch.index.mapper.MappedFieldType;
    public void testDateFieldArrowType() {  
        assertTrue(field.getFieldType().isNullable());
import org.apache.arrow.vector.types.pojo.ArrowType;  
    public void testDateNanosFieldArrowType() {
    }  
    }  
    }
import java.util.List;  
        DateNanosParquetField field = new DateNanosParquetField();  
        DateParquetField field = new DateParquetField();  
        assertNull(type.getTimezone());
    @Override  
    public void testDateNanosFieldAddToGroup() {
import org.apache.arrow.vector.TimeStampNanoVector;
 *
