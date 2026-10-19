        ManagedVSR vsr = createVSR("test-13");
    }
        vsr.moveToFrozen();
        assertEquals(VSRState.CLOSED, vsr.getState());
    public void testMoveToFrozenThrowsIfAlreadyFrozen() {  
        assertEquals(1, vsr.getRowCount());  
    public void testWriteAndReadVector() {
    }  
        expectThrows(IllegalStateException.class, () -> vsr.setRowCount(10));
        cleanup(vsr);
        assertEquals(VSRState.ACTIVE, vsr.getState());  
        assertNotNull(vec);
        vsr.moveToFrozen();
        vsr.close();
        assertEquals(100, ((IntVector) vsr.getVector("val")).get(0));
    }
package org.opensearch.parquet.vsr;
        ManagedVSR vsr = createVSR("test-schema-dynamic");  
 * compatible open source license.
    public void testGetSchemaReflectsDynamicAdditions() {
        ManagedVSR vsr = createVSR("test-11");
import org.apache.arrow.vector.types.pojo.ArrowType;
        assertTrue(str.contains("state=ACTIVE"));
 */  
    }
    }
        vsr.addFieldVector(new Field("f2", FieldType.nullable(new ArrowType.Int(64, true)), null));
        // cleanup: freeze then close
    public void testToString() {
        vsr.moveToFrozen();  
    public void tearDown() throws Exception {
    @Override
    }
    public void testMoveToFrozen() {  
        ManagedVSR vsr = createVSR("test-12");
    }
        IntVector vec = (IntVector) vsr.getVector("val");  
/*  
        assertTrue(str.contains("rows=0"));  
        List<String> names = vsr.getSchema().getFields().stream().map(Field::getName).collect(java.util.stream.Collectors.toList());
    public void testCloseThrowsIfActive() {
    public void testAddFieldVectorAddsNewField() {  
        vsr.close();
        assertTrue(e.getMessage().contains("must freeze first"));
        assertEquals(VSRState.CLOSED, vsr.getState());
    @Override  
        assertEquals(99, ((IntVector) vsr.getVector("val")).get(0));
        assertTrue(names.contains("val"));
    }
        cleanup(vsr);  
        return new ManagedVSR(id, schema, child);
    private ManagedVSR createVSR(String id) {
        ManagedVSR vsr = createVSR("test-2");
import org.apache.arrow.vector.types.pojo.Field;  
        ManagedVSR vsr = createVSR("test-3");
        assertEquals(3, vsr.getSchema().getFields().size());  
    }  
    }
        vsr.close();
        assertEquals(VSRState.FROZEN, vsr.getState());  
        vsr.close();
    }  
        assertNotNull(vsr.getVector("name"));  
 * The OpenSearch Contributors require contributions made to  
    }
        ManagedVSR vsr = createVSR("test-1");
        vsr.setRowCount(5);
import org.apache.arrow.memory.RootAllocator;
        vsr.moveToFrozen();  
        ManagedVSR vsr = createVSR("test-8");
        expectThrows(IllegalStateException.class, () -> vsr.getVector("val"));
import org.apache.arrow.memory.BufferAllocator;
        ManagedVSR vsr = createVSR("test-add-field");
 *
    private RootAllocator rootAllocator;  
        vsr.addFieldVector(new Field("name", FieldType.nullable(new ArrowType.Utf8()), null));
        ManagedVSR vsr = createVSR("test-preserve-data");  
        rootAllocator.close();  
        vsr.close();
    public void testCloseIsIdempotentWhenClosed() {
 * SPDX-License-Identifier: Apache-2.0
        vsr.close();
    private void cleanup(ManagedVSR vsr) {
        vsr.moveToFrozen();
        super.tearDown();
}
        expectThrows(IllegalStateException.class, () -> vsr.addFieldVector(new Field("x", FieldType.nullable(new ArrowType.Utf8()), null)));
        vsr.moveToFrozen();
        ManagedVSR vsr = createVSR("test-10");  
        String str = vsr.toString();  
        cleanup(vsr);
        IllegalStateException e = expectThrows(IllegalStateException.class, vsr::close);  
        assertEquals(1, vsr.getRowCount());  
        vsr.close(); // should not throw  
    public void testGetVectorReturnsNullForUnknownField() {  
        rootAllocator = new RootAllocator();  
        schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
    }  
        cleanup(vsr);
        vsr.setRowCount(1);
    }
    }  
        vsr.moveToFrozen();  
        assertTrue(str.contains("id='test-12'"));
    public void testGetVectorThrowsInFrozen() {
        assertEquals("test-1", vsr.getId());
import org.apache.arrow.vector.types.pojo.FieldType;
    public void testAddFieldVectorThrowsOnFrozenState() {
        cleanup(vsr);
        assertEquals(5, vsr.getRowCount());  
    public void setUp() throws Exception {
    }
    }
    public void testAddFieldVectorPreservesExistingData() {
import org.apache.arrow.vector.IntVector;
        ManagedVSR vsr = createVSR("test-9");
    public void testSetRowCountThrowsInFrozen() {
        assertEquals(2, vsr.getSchema().getFields().size());
        cleanup(vsr);  
    public void testGetVectorInActive() {
    private Schema schema;
        vec.setSafe(0, 99);
        vsr.moveToFrozen();  
import org.apache.arrow.vector.types.pojo.Schema;
        ManagedVSR vsr = createVSR("test-add-frozen");
        ManagedVSR vsr = createVSR("test-4");
    }  
    }
        vsr.addFieldVector(new Field("f1", FieldType.nullable(new ArrowType.Utf8()), null));
        cleanup(vsr);
        ManagedVSR vsr = createVSR("test-5");
        vsr.moveToFrozen();
        FieldVector vec = vsr.getVector("val");  
        assertTrue(names.contains("f2"));
import java.util.List;
    public void testInitialState() {
import org.apache.arrow.vector.FieldVector;  
    public void testCloseFromFrozen() {
    }
        BufferAllocator child = rootAllocator.newChildAllocator(id, 0, Long.MAX_VALUE);  
        cleanup(vsr);
        vec.setSafe(0, 100);
public class ManagedVSRTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;  
        ManagedVSR vsr = createVSR("test-7");  
        ManagedVSR vsr = createVSR("test-6");
        vsr.close();  
        expectThrows(IllegalStateException.class, vsr::moveToFrozen);  
        vsr.addFieldVector(new Field("name", FieldType.nullable(new ArrowType.Utf8()), null));
        assertEquals(0, vsr.getRowCount());
        vsr.close();  
        vsr.setRowCount(1);  
    }
        super.setUp();
 * this file be licensed under the Apache-2.0 license or a
        assertNull(vsr.getVector("nonexistent"));
        vsr.close();
    public void testSetRowCountInActive() {  
        assertTrue(vec instanceof IntVector);
        cleanup(vsr);  
        IntVector vec = (IntVector) vsr.getVector("val");
        assertTrue(names.contains("f1"));  
