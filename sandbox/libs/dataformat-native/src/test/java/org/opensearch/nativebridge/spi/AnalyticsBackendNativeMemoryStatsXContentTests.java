    public void testXContentRenderingCorrectness() throws Exception {
                ((Number) analyticsBackend.get("allocated_bytes")).longValue()  
 * SPDX-License-Identifier: Apache-2.0
            );
            assertFalse("native_memory wrapper should be opened by NodeStats, not this class", root.containsKey("native_memory"));
        assertEquals(-1L, ((Number) analyticsBackend.get("resident_bytes")).longValue());
        String json = Strings.toString(MediaTypeRegistry.JSON, stats);
 * The {@code native_memory} parent wrapper and {@code total_estimated_bytes} field are owned by
            // Top-level key must be "analytics_backend" and nothing else.  
            AnalyticsBackendNativeMemoryStats stats = new AnalyticsBackendNativeMemoryStats(allocatedBytes, residentBytes, 0);  
/**
        Map<String, Object> root = XContentHelper.convertToMap(JsonXContent.jsonXContent, json, false);
 * {@code NodeStats.toXContent} and tested there; this class is responsible only for the inner  
            assertFalse(
            // analytics_backend must contain exactly the three fields.
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> analyticsBackend = (Map<String, Object>) root.get("analytics_backend");
        assertEquals(0L, ((Number) analyticsBackend.get("resident_bytes")).longValue());
            long residentBytes = randomBoolean() ? -1L : randomLongBetween(Long.MIN_VALUE, Long.MAX_VALUE);
     * {@code analytics_backend} object with both fields verbatim. Iterates 100 random
        AnalyticsBackendNativeMemoryStats stats = new AnalyticsBackendNativeMemoryStats(0L, 0L, 0);
 */
        String json = Strings.toString(MediaTypeRegistry.JSON, stats);  
    }  
     * Property: any valid (allocatedBytes, residentBytes) pair renders as a single  
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
    public void testXContentRenderingWithZeroValues() throws Exception {  
}  
 * }</pre>
        for (int i = 0; i < 100; i++) {
 */  
        AnalyticsBackendNativeMemoryStats stats = new AnalyticsBackendNativeMemoryStats(-1, -1, 0);
                allocatedBytes,
                ((Number) analyticsBackend.get("resident_bytes")).longValue()
        assertNotNull("analytics_backend should be present", analyticsBackend);
        assertEquals(-1L, ((Number) analyticsBackend.get("allocated_bytes")).longValue());
            assertEquals("purge_count mismatch on iteration " + i, 0L, ((Number) analyticsBackend.get("purge_count")).longValue());
package org.opensearch.nativebridge.spi;
 * {@code analytics_backend} object.
            assertEquals(  
 * <p>The class now emits a single inner block:
            assertTrue("Expected 'analytics_backend' on iteration " + i + ", got: " + root.keySet(), root.containsKey("analytics_backend"));
            assertEquals(
     */  
 *  
 * Property-based tests for {@link AnalyticsBackendNativeMemoryStats} XContent rendering correctness.
            assertEquals("Expected exactly 3 fields on iteration " + i, 3, analyticsBackend.size());
            long allocatedBytes = randomBoolean() ? -1L : randomLongBetween(Long.MIN_VALUE, Long.MAX_VALUE);  
import org.opensearch.test.OpenSearchTestCase;  
/*  
 * <pre>{@code
    public void testXContentRenderingWithErrorState() throws Exception {
                root.containsKey("total_estimated_bytes")
    }
            assertNotNull("analytics_backend should not be null on iteration " + i, analyticsBackend);
    /** Error sentinel (-1, -1) renders verbatim. */  
                residentBytes,
    /**
import org.opensearch.common.xcontent.XContentHelper;
            );
            @SuppressWarnings("unchecked")
        }  
public class AnalyticsBackendNativeMemoryStatsXContentTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
            );  
        Map<String, Object> root = XContentHelper.convertToMap(JsonXContent.jsonXContent, json, false);
            Map<String, Object> root = XContentHelper.convertToMap(JsonXContent.jsonXContent, json, false);
        assertNotNull("analytics_backend should be present", analyticsBackend);  
                "resident_bytes mismatch on iteration " + i + " for value: " + residentBytes,  
            Map<String, Object> analyticsBackend = (Map<String, Object>) root.get("analytics_backend");  
 * compatible open source license.
                "total_estimated_bytes is computed in NodeStats from OsProbe, not emitted here",  
import java.util.Map;
            String json = Strings.toString(MediaTypeRegistry.JSON, stats);  
        assertEquals(0L, ((Number) analyticsBackend.get("allocated_bytes")).longValue());  
    /** Zero values render as 0, not omitted. */
import org.opensearch.common.xcontent.json.JsonXContent;
        @SuppressWarnings("unchecked")  
        Map<String, Object> analyticsBackend = (Map<String, Object>) root.get("analytics_backend");
            assertEquals("Expected exactly one top-level key on iteration " + i, 1, root.size());
    }
            // Render to JSON string via Strings.toString (wraps fragment in root object).
 *
                "allocated_bytes mismatch on iteration " + i + " for value: " + allocatedBytes,
     * inputs, including the {@code -1} error sentinel.
import org.opensearch.core.common.Strings;  
 * "analytics_backend": { "allocated_bytes": ..., "resident_bytes": ... }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            // Sanity: the parent-level fields are NOT emitted by this class.  
        @SuppressWarnings("unchecked")
