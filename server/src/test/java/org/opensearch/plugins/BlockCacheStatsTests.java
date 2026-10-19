            randomNonNegativeLong(),
            randomNonNegativeLong(),
        BlockCacheStats roundTripped = copyWriteable(original, getNamedWriteableRegistry(), instanceReader(), Version.V_3_8_0);  
        assertEquals(original, roundTripped);  
            randomNonNegativeLong(),  
/*  
            randomNonNegativeLong(),
            randomNonNegativeLong(),  
            randomNonNegativeLong(),
        assertTrue(json.contains("\"over_all_stats\""));
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        BlockCacheStats expectedStripped = new BlockCacheStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    public void testSerializationBeforeV_3_8_0WithNullTieredStats() throws IOException {
    // ── Version-gated (BWC) wire serialization ───────────────────────────────
package org.opensearch.plugins;
    public void testSerializationBeforeV_3_8_0DropsTieredStats() throws IOException {
            randomNonNegativeLong(),  
            randomNonNegativeLong(),
            randomNonNegativeLong(),
            randomNonNegativeLong(),  
            5000,
            randomNonNegativeLong(),
            randomNonNegativeLong(),
        BlockCacheStats stats = new BlockCacheStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        return new BlockCacheStats(  
        assertTrue(json.contains("\"pinned_file_stats\""));
            200,
 * SPDX-License-Identifier: Apache-2.0
            2500,  
            100,
     * A null-tiered instance round-trips cleanly across the version boundary —
    }
        assertTrue(json.contains("\"metadata_cache_stats\""));
    }
    }
            1,
            randomNonNegativeLong(),
     * (the field is gated at {@code V_3_8_0}), while all 12 base counters survive.  
            32
    }  
            randomNonNegativeLong(),
    /**
            randomNonNegativeLong(),
            300,  
        BlockCacheTieredStats tiered = randomTieredStats();
    }
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.opensearch.test.AbstractWireSerializingTestCase;  
    @Override  
     */
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            150,
            10,  
}
            5000,
            randomNonNegativeLong(),
        BlockCacheTieredStats tiered = randomBoolean() ? randomTieredStats() : null;
        assertTrue(json.contains("\"data_cache_stats\""));  
        assertTrue(json.contains("\"capacity_in_bytes\":5000"));  
    /**  
            500,
    }  
            randomNonNegativeLong(),
            8000,
        assertFalse("Non-tiered stats should not contain data_cache_stats", json.contains("\"data_cache_stats\""));  
        BlockCacheStats stats = new BlockCacheStats(10, 5, 1024, 512, 3, 300, 2, 200, 0, 4096, 8192, 512);
            randomNonNegativeLong(),
        assertTrue(json.contains("\"used_in_bytes\":4096"));
 * this file be licensed under the Apache-2.0 license or a
    protected BlockCacheStats createTestInstance() {
import org.opensearch.core.common.io.stream.Writeable;  
        String json = builder.toString();
        assertNull(roundTripped.tieredStats());
            randomNonNegativeLong(),  
            100,  
        assertTrue(json.contains("\"capacity_in_bytes\":10000"));
        builder.endObject();
import org.opensearch.Version;
    }
        BlockCacheStats original = new BlockCacheStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        String json = builder.toString();  
            tiered
import java.io.IOException;
        BlockCacheTieredStats tiered = new BlockCacheTieredStats(
            10000,
            randomNonNegativeLong(),
        assertTrue(json.contains("\"hit_count\":10"));  
        BlockCacheStats stats = new BlockCacheStats(150, 15, 7500, 750, 3, 300, 0, 0, 0, 12000, 15000, 96, tiered);
            2,  
     * the pre-{@code V_3_8_0} path must not write/read the optional field.
        assertEquals("base counters must survive the BWC round-trip", expectedStripped, roundTripped);  
            randomNonNegativeLong(),  
            randomNonNegativeLong(),
        // The 12 base counters must survive; the stripped instance is the null-tiered equivalent.
            randomNonNegativeLong(),  
    public void testToXContentWithTieredStats() throws IOException {  
            5,
        );  
    private BlockCacheTieredStats randomTieredStats() {  
        assertNull(stats.tieredStats());
        BlockCacheStats roundTripped = copyWriteable(original, getNamedWriteableRegistry(), instanceReader(), Version.V_3_7_0);
        BlockCacheStats roundTripped = copyWriteable(original, getNamedWriteableRegistry(), instanceReader(), Version.V_3_7_0);  
     * Round-tripping at {@code V_3_8_0} (CURRENT) preserves {@code tieredStats} verbatim.
            randomNonNegativeLong(),
    protected Writeable.Reader<BlockCacheStats> instanceReader() {  
        builder.endObject();
     */
        BlockCacheStats original = new BlockCacheStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, tiered);
            3,
            randomNonNegativeLong(),
        );
    }
        assertEquals(original, roundTripped);  
 * The OpenSearch Contributors require contributions made to  
            randomNonNegativeLong(),  
    public void testNonTieredConstructorHasNullTieredStats() {  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
            randomNonNegativeLong(),
        assertTrue(json.contains("\"block_cache\""));
    }
            randomNonNegativeLong(),
 */  
    @Override
    public void testToXContentStructure() throws IOException {
            randomNonNegativeLong(),
        return new BlockCacheTieredStats(
        assertTrue(json.contains("\"block_file_stats\""));  
            2,
            4000,  
        BlockCacheStats original = new BlockCacheStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, randomTieredStats());  
public class BlockCacheStatsTests extends AbstractWireSerializingTestCase<BlockCacheStats> {
        assertTrue(json.contains("\"miss_count\":5"));
            250,
        assertNull("tieredStats must be dropped when written to a pre-V_3_8_0 node", roundTripped.tieredStats());  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.xcontent.XContentFactory;
        );  
        assertTrue(json.contains("\"full_file_stats\""));
    /**  
            randomNonNegativeLong(),  
            randomNonNegativeLong(),  
            50,
            randomNonNegativeLong(),
        return BlockCacheStats::new;
        assertEquals(tiered, roundTripped.tieredStats());
            64,  
            randomNonNegativeLong(),  
     * Serializing to a pre-{@code V_3_8_0} node must drop {@code tieredStats}
 *
import org.opensearch.core.xcontent.ToXContent;
     */  
    public void testSerializationAtV_3_8_0PreservesTieredStats() throws IOException {  
 * compatible open source license.
            randomNonNegativeLong()
