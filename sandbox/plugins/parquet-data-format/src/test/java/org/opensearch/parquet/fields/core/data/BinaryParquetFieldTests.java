 *
        byte[] data = new byte[] { 1, 2, 3, 4 };
        assertArrayEquals(data, result);  
        // BinaryParquetField uses set() not setSafe(), so allocate capacity first
    }
        field.createField(ft, vsr, data);
        assertTrue(field.getFieldType().isNullable());  
public class BinaryParquetFieldTests extends OpenSearchTestCase {
 * compatible open source license.
        allocator.close();
        ((VarBinaryVector) vsr.getVector("val")).allocateNew(64, 1);
        BufferAllocator child = allocator.newChildAllocator("bin-test", 0, Long.MAX_VALUE);
/*  
    }
import java.util.List;  
import org.apache.arrow.vector.VarBinaryVector;  
        byte[] result = ((VarBinaryVector) vsr.getVector("val")).get(0);
}
    }
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.index.mapper.BinaryFieldMapper;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.types.pojo.Schema;  
        BinaryParquetField field = new BinaryParquetField();
        super.setUp();
        assertTrue(field.getArrowType() instanceof ArrowType.Binary);
    public void testAddToGroup() {  
import org.opensearch.test.OpenSearchTestCase;
 */  
        BinaryParquetField field = new BinaryParquetField();
        super.tearDown();  
        vsr.close();  
    private BufferAllocator allocator;
    public void testArrowType() {  
    public void tearDown() throws Exception {
        ManagedVSR vsr = new ManagedVSR("bin-test", schema, child);
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.opensearch.parquet.vsr.ManagedVSR;  
package org.opensearch.parquet.fields.core.data;
 * The OpenSearch Contributors require contributions made to  
    public void setUp() throws Exception {
import org.apache.arrow.memory.RootAllocator;
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override  
        MappedFieldType ft = new BinaryFieldMapper.BinaryFieldType("val");
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.vector.types.pojo.Field;
        allocator = new RootAllocator();  
        vsr.moveToFrozen();
    @Override  
        vsr.setRowCount(1);  
        Schema schema = new Schema(List.of(new Field("val", field.getFieldType(), null)));  
