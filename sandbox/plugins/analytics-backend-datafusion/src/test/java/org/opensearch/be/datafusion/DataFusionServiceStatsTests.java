/**  
     * Calling getStats() must throw IllegalStateException with a descriptive message.
            .spillMemoryLimit(2L)  
 * fresh instance after TTL expires) requires a running native runtime since  
            .build();
    }
     */
            .memoryPoolLimit(1L)
        assertEquals(2L, spill.getDiskReservedBytes());  
    /**  
        assertEquals(0L, spill.getDiskReservedBytes());
 * Note: Cache TTL behavior (Requirement 5.3 — same instance within TTL window,
    }
        assertEquals("/var/lib/opensearch/spill", service.getSpillDirectory());
 */  
            .spillMemoryLimit(32L * 1024L * 1024L)
    }
 * compatible open source license.
 * Unit tests for {@link DataFusionService#getStats()}.
 *
 *
        assertTrue(spill.getDiskTotalBytes() > 0L);
 * {@code doStart()} calls {@code NativeBridge.stats()} to seed the cache.
    public void testBuildSpillStatsWithDisabledSpillReturnsEmptyDirectory() {  
        DataFusionService service = DataFusionService.builder()
        IllegalStateException ex = expectThrows(IllegalStateException.class, service::getStats);  
import java.nio.file.Path;
 * SPDX-License-Identifier: Apache-2.0
     * When the service is constructed but not started, the statsCache field is null.  
            .build();  
    public void testGetSpillDirectoryReflectsBuilderValue() {
            .spillDirectory("/var/lib/opensearch/spill")
        Path realSpillDir = createTempDir();  
        DataFusionService service = DataFusionService.builder().build();
 * That behavior is verified in integration tests where the native library is loaded.
/*  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(32L * 1024L * 1024L, service.getSpillMemoryLimit());  
     * Validates Requirement 5.5: getStats() throws IllegalStateException before doStart().
    public void testGetStatsBeforeStartThrowsIllegalStateException() {  
    public void testBuildSpillStatsReadsConfiguredDirectory() {
 * this file be licensed under the Apache-2.0 license or a
 */  
 *
            .memoryPoolLimit(64L * 1024L * 1024L)  
        assertEquals(0L, spill.getDiskTotalBytes());
        DataFusionService service = DataFusionService.builder()
import org.opensearch.be.datafusion.stats.SpillStats;
        SpillStats spill = service.buildSpillStats();
package org.opensearch.be.datafusion;
        assertEquals(realSpillDir.toString(), spill.getDirectory());
        DataFusionService service = DataFusionService.builder().memoryPoolLimit(1L).spillMemoryLimit(2L).spillDirectory("").build();
 * Validates: Requirements 5.2, 5.3, 5.5  
        assertEquals("", spill.getDirectory());  
     *
public class DataFusionServiceStatsTests extends OpenSearchTestCase {
            .spillDirectory(realSpillDir.toString())
    }  
 * The OpenSearch Contributors require contributions made to  
        SpillStats spill = service.buildSpillStats();
        assertEquals("DataFusionService has not been started", ex.getMessage());
}  
