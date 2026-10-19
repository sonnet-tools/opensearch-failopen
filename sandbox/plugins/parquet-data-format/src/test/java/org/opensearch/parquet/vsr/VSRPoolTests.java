        super.setUp();
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;  
        pool.completeVSR(frozen);
    public void testUnsetFrozenVSRThrowsWhenNoneSet() {
    }  
    @Override
import java.util.List;  
        pool.maybeRotateActiveVSR();
        }
        expectThrows(IllegalStateException.class, pool::unsetFrozenVSR);
 * this file be licensed under the Apache-2.0 license or a
        assertNull(pool.getFrozenVSR());
        assertNotNull(pool.getActiveVSR());
        pool.unsetFrozenVSR();
        pool.getActiveVSR().setRowCount(50000);
        pool.getActiveVSR().setRowCount(50000);
        VSRPool pool = new VSRPool("pool-2", schema, bufferPool, 50000);  
        assertNotNull(pool.getActiveVSR());
import org.apache.arrow.vector.types.pojo.ArrowType;
        bufferPool.close();
        pool.close();
        assertEquals(VSRState.ACTIVE, pool.getActiveVSR().getState());  
    }  
public class VSRPoolTests extends OpenSearchTestCase {
    public void testRotationFailsWhenFrozenSlotOccupied() throws IOException {
package org.opensearch.parquet.vsr;
        assertFalse(pool.maybeRotateActiveVSR());
    }  
    }  
    private Schema schema;  
        bufferPool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
    }
            nativeAllocator.close();  
    private ArrowBufferPool bufferPool;
        assertTrue(pool.maybeRotateActiveVSR());  
        original.setRowCount(50000);
        expectThrows(IllegalStateException.class, pool::unsetFrozenVSR);
import org.apache.arrow.vector.types.pojo.Schema;
        // frozen VSR is in FROZEN state, not CLOSED
        // cleanup frozen, then freeze active, then close
        VSRPool pool = new VSRPool("pool-6", schema, bufferPool, 50000);  
        VSRPool pool = new VSRPool("pool-3", schema, bufferPool, 50000);  
    public void testCompleteAndUnsetFrozenVSR() throws IOException {  
        pool.unsetFrozenVSR();
        ManagedVSR original = pool.getActiveVSR();
        VSRPool pool = new VSRPool("pool-4", schema, bufferPool, 50000);  
    public void testRotationAtThreshold() throws IOException {
        assertEquals(VSRState.ACTIVE, pool.getActiveVSR().getState());  
    }  
        nativeAllocator = new ArrowNativeAllocator();
    public void tearDown() throws Exception {  
        schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        pool.close();
import org.opensearch.common.settings.Settings;
    public void testNoRotationBelowThreshold() throws IOException {
        VSRPool pool = new VSRPool("pool-1", schema, bufferPool, 50000);
        pool.close();  
import org.apache.arrow.vector.types.pojo.Field;
    }
        pool.close();
        pool.getActiveVSR().setRowCount(50000);
        VSRPool pool = new VSRPool("pool-7", schema, bufferPool, 50000);  
        pool.maybeRotateActiveVSR();  
        pool.completeVSR(pool.getFrozenVSR());
    }
        pool.close();
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        assertNotNull(pool.getFrozenVSR());
        assertNull(pool.getFrozenVSR());
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);  
 * compatible open source license.
            nativeAllocator = null;
import org.opensearch.parquet.memory.ArrowBufferPool;
        pool.close();  
        pool.unsetFrozenVSR();  
        pool.close();
        ManagedVSR frozen = pool.getFrozenVSR();
 * SPDX-License-Identifier: Apache-2.0
    public void setUp() throws Exception {  
        assertFalse(pool.maybeRotateActiveVSR());
        assertNotNull(frozen);  
    }  
        pool.completeVSR(pool.getFrozenVSR());
}
        super.tearDown();  
 * The OpenSearch Contributors require contributions made to  
    private ArrowNativeAllocator nativeAllocator;
        VSRPool pool = new VSRPool("pool-5", schema, bufferPool, 50000);
 */  
        assertEquals(VSRState.CLOSED, frozen.getState());
import java.io.IOException;
    public void testUnsetFrozenVSRThrowsWhenNotClosed() throws IOException {
import org.apache.arrow.vector.types.pojo.FieldType;  
 *
    public void testInitialStateHasActiveVSR() {  
        assertEquals(VSRState.FROZEN, pool.getFrozenVSR().getState());  
        pool.completeVSR(pool.getFrozenVSR());  
        pool.unsetFrozenVSR();
    @Override
import org.opensearch.test.OpenSearchTestCase;  
        if (nativeAllocator != null) {
        pool.getActiveVSR().setRowCount(50000);
        pool.maybeRotateActiveVSR();
/*  
        assertNotSame(original, pool.getActiveVSR());
