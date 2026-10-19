    public void tearDown() throws Exception {
        assertEquals(50L * 1024 * 1024, service.getMemoryPoolLimit());
        service.setMemoryPoolLimit(100L * 1024 * 1024);  
    @Override
        // Null out so tearDown does not try to stop again.
    }
            .memoryPoolLimit(64 * 1024 * 1024) // 64MB
    public void testSetPoolLimitDecrease() {
        long usage = NativeBridge.getMemoryPoolUsage(runtimePtr);
        service.setMemoryPoolLimit(newLimit);
            .spillMemoryLimit(32 * 1024 * 1024)  
        expectThrows(IllegalStateException.class, () -> service.setMemoryPoolLimit(128L * 1024 * 1024));
    public void testSetMemoryPoolLimitAfterStopThrowsIllegalState() {
        NativeBridge.initTokioRuntimeManager(2);
        long newLimit = 32L * 1024 * 1024; // 32MB  
    public void testSetPoolLimitMultipleTimes() {
    }  
    }  
        long limit = NativeBridge.getMemoryPoolLimit(runtimePtr);
            .cpuThreads(2)
        assertEquals("Initial pool limit should be 64 MB", 64 * 1024 * 1024, limit);  
    }
    /**
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        assertTrue("Usage should be >= 0", usage >= 0);
            service.stop();
    }
        }
 * this file be licensed under the Apache-2.0 license or a
        service.setMemoryPoolLimit(200L * 1024 * 1024);  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        assertEquals(256L * 1024 * 1024, NativeBridge.getMemoryPoolLimit(runtimePtr));
}
        assertEquals("Pool limit should be updated to 32 MB", newLimit, service.getMemoryPoolLimit());
        long newLimit = 128L * 1024 * 1024; // 128MB  
        super.tearDown();
        service = null;  
 * can be read and changed at runtime via the FFM bridge.
    public void testGetInitialPoolUsage() {  
        service = DataFusionService.builder()
        assertEquals(100L * 1024 * 1024, service.getMemoryPoolLimit());
        super.setUp();
            .build();  
        assertEquals("Initial pool usage should be 0", 0, usage);
     * handle. The plugin-level listener catches this to keep cluster-state updates quiet during
/**  
/*  
    public void setUp() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
        service.stop();  
 * Tests for the DynamicLimitPool — verifies that the memory pool limit
    public void testGetInitialPoolLimit() {
        long limit = service.getMemoryPoolLimit();
    @Override
    public void testSetPoolLimitIncrease() {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(64 * 1024 * 1024, limit);
 */  
import java.nio.file.Path;
        NativeBridge.setMemoryPoolLimit(runtimePtr, 256L * 1024 * 1024);
            .spillDirectory(spillDir.toString())
     * node shutdown.  
 */  
    }
    }
    }  
        long usage = service.getMemoryPoolUsage();
        if (service != null) {  
        service.setMemoryPoolLimit(newLimit);
        assertEquals(200L * 1024 * 1024, service.getMemoryPoolLimit());
public class DynamicMemoryPoolTests extends OpenSearchTestCase {
        assertEquals("Pool limit should be updated to 128 MB", newLimit, service.getMemoryPoolLimit());
        long runtimePtr = service.getNativeRuntime().get();
    }  
        NativeBridge.shutdownTokioRuntimeManager();  
        service.start();
     */
 *
    private DataFusionService service;  
        service.setMemoryPoolLimit(50L * 1024 * 1024);  
    public void testDirectNativeBridgeCalls() {
        Path spillDir = createTempDir("datafusion-spill");  
package org.opensearch.be.datafusion;
     * must surface an {@link IllegalStateException} rather than dereferencing a closed runtime
     * H1 — after the service has been stopped, {@link DataFusionService#setMemoryPoolLimit}  
