            assertTrue(  
    }
    }  
                "resident bytes should be positive when jemalloc is active, got " + stats.getResidentBytes(),
 */  
/*  
 */
     * with jemalloc symbols. If jemalloc symbols are not available, the test verifies
            );
/**
            AnalyticsBackendNativeMemoryStats stats = NativeMemoryFetcher.fetch();  
     */
public class NativeMemoryFetcherTests extends OpenSearchTestCase {  
        AnalyticsBackendNativeMemoryStats validStats = new AnalyticsBackendNativeMemoryStats(1024, 2048, 0);
            // If we get here, jemalloc symbols are available
                stats.getAllocatedBytes() > 0
    /**
                "Class init failure should be caused by missing jemalloc symbols",
            );  
        assertTrue("Error state residentBytes should be negative", errorStats.getResidentBytes() < 0);  
 *
 * Unit tests for {@link NativeMemoryFetcher} error handling contract.
 * native library. In test environments where the library is built without jemalloc support,  
 * the class cannot be initialized. Tests handle this gracefully.
                    || e.getCause() instanceof java.util.NoSuchElementException  
        assertEquals("Zero should be a valid allocatedBytes value", 0L, stats.getAllocatedBytes());
 *   <li>The error handling contract: exceptions → (-1, -1), negative values → (-1, -1)</li>
 * compatible open source license.
     * construction directly.  
        assertEquals("Error sentinel for residentBytes should be -1", -1L, errorStats.getResidentBytes());  
 * The OpenSearch Contributors require contributions made to  
        AnalyticsBackendNativeMemoryStats errorStats = new AnalyticsBackendNativeMemoryStats(-1, -1, 0);
        assertTrue("Valid state residentBytes should be positive", validStats.getResidentBytes() > 0);
    }
     * error sentinel values are correctly constructed.  
        assertEquals("Zero should be a valid residentBytes value", 0L, stats.getResidentBytes());
 * <p>  
                e.getCause() == null
            logger.info("NativeMemoryFetcher class init failed (expected without jemalloc symbols): {}", e.getMessage());
 * Note: NativeMemoryFetcher's static initializer requires the jemalloc symbols
            assertTrue(
 * </ul>
            assertTrue(  
     * Documents the error handling contract: when allocated or resident bytes are -1,
    /**  
    public void testFetchReturnsPositiveValuesOrFailsWithoutJemalloc() {
    /**  
                stats.getResidentBytes() > 0  
        } catch (ExceptionInInitializerError | NoClassDefFoundError e) {
 * <ul>
        // Valid state has positive values
        }  
    public void testErrorSentinelValuesContract() {
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
    public void testErrorStateIsDistinguishableFromValidStats() {  
        AnalyticsBackendNativeMemoryStats stats = new AnalyticsBackendNativeMemoryStats(0, 0, 0);  
                    || e.getMessage().contains("NativeMemoryFetcher")
     */  
     */
    /**
     * <p>
        AnalyticsBackendNativeMemoryStats errorStats = new AnalyticsBackendNativeMemoryStats(-1, -1, 0);
 * SPDX-License-Identifier: Apache-2.0
 * The fetcher performs FFM downcalls to jemalloc. These tests verify:
                "allocated bytes should be positive when jemalloc is active, got " + stats.getAllocatedBytes(),
     * - FFM downcall throwing an exception  
     */
     * that the class initialization fails as expected (symbols not found).
     * Tests that fetch() returns valid positive values when the native library is loaded  
     * Tests that the error state AnalyticsBackendNativeMemoryStats(-1, -1) is distinguishable from
        // Error state has -1 for both fields
    public void testZeroValuesAreValid() {
 * (native_jemalloc_allocated_bytes, native_jemalloc_resident_bytes) to be present in the
 * <p>  
 *   <li>When the native library is loaded with jemalloc symbols, fetch() returns positive values</li>  
            // Expected when jemalloc symbols are not in the native library.  
     * valid and error states). Zero is a valid value (no memory allocated yet).  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.nativebridge.spi;
    }
            // The static initializer uses orElseThrow() on symbol lookup.
        assertTrue("Valid state allocatedBytes should be positive", validStats.getAllocatedBytes() > 0);  
}
import org.opensearch.test.OpenSearchTestCase;
     * - FFM downcall returning a negative value
            );
     * it indicates an error condition. This test verifies that the AnalyticsBackendNativeMemoryStats
        // Directly construct the error state that fetch() would return on failure  
     * valid stats. This documents the contract that fetch() returns (-1, -1) on:
        assertEquals("Error sentinel for allocatedBytes should be -1", -1L, errorStats.getAllocatedBytes());
     * This test does NOT require the native library since it only tests AnalyticsBackendNativeMemoryStats
        assertTrue("Error state allocatedBytes should be negative", errorStats.getAllocatedBytes() < 0);
            assertNotNull("fetch() should never return null", stats);
     * Tests that AnalyticsBackendNativeMemoryStats correctly stores zero values (boundary between
        try {
