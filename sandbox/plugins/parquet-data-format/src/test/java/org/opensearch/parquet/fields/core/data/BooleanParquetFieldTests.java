        allocator.close();
import org.apache.arrow.vector.types.pojo.ArrowType;
        BufferAllocator child = allocator.newChildAllocator("bool-test", 0, Long.MAX_VALUE);
        BooleanParquetField field = new BooleanParquetField();
    }
    private ManagedVSR createVSR(BooleanParquetField field) {
        allocator = new RootAllocator();  
    }
        return new ManagedVSR("bool-test", schema, child);
public class BooleanParquetFieldTests extends OpenSearchTestCase {
/*  
    public void testAddToGroupFalse() {
    private BufferAllocator allocator;
        super.tearDown();  
 * compatible open source license.
        vsr.close();
        BooleanParquetField field = new BooleanParquetField();
        super.setUp();
    private void cleanupVSR(ManagedVSR vsr) {
        assertTrue(field.getArrowType() instanceof ArrowType.Bool);
import org.apache.arrow.memory.RootAllocator;
import org.opensearch.parquet.vsr.ManagedVSR;  
import org.apache.arrow.vector.BitVector;  
        vsr.setRowCount(1);  
        MappedFieldType ft = new BooleanFieldMapper.BooleanFieldType("val");  
        vsr.setRowCount(1);
    }
}  
    }  
    @Override  
        assertTrue(field.getFieldType().isNullable());  
import org.apache.arrow.vector.types.pojo.Schema;  
        ManagedVSR vsr = createVSR(field);  
    public void testArrowType() {  
        assertEquals(0, ((BitVector) vsr.getVector("val")).get(0));
    }
        Schema schema = new Schema(List.of(new Field("val", field.getFieldType(), null)));  
        ManagedVSR vsr = createVSR(field);
import org.apache.arrow.memory.BufferAllocator;
import org.opensearch.index.mapper.BooleanFieldMapper;
        vsr.moveToFrozen();  
    }  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.parquet.fields.core.data;
        MappedFieldType ft = new BooleanFieldMapper.BooleanFieldType("val");
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
        field.createField(ft, vsr, false);
        BooleanParquetField field = new BooleanParquetField();
    @Override  
        assertEquals(1, ((BitVector) vsr.getVector("val")).get(0));  
 *
        field.createField(ft, vsr, true);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.mapper.MappedFieldType;
    public void testAddToGroupTrue() {  
    public void tearDown() throws Exception {
    }
    public void setUp() throws Exception {
        cleanupVSR(vsr);
import org.apache.arrow.vector.types.pojo.Field;
        cleanupVSR(vsr);
 * The OpenSearch Contributors require contributions made to  
 */  
