import org.opensearch.common.xcontent.XContentFactory;
            8000,
            10,
            randomNonNegativeLong(),  
 * The OpenSearch Contributors require contributions made to  
            0,  
            0,
    @Override  
            0,
            randomNonNegativeLong(),
            5,  
        assertTrue(json.contains("\"removed_in_bytes\":300"));
    @Override
            0,  
            randomNonNegativeLong(),
            randomNonNegativeLong(),
            500,  
        assertTrue(json.contains("\"hit_count\":100"));  
            randomNonNegativeLong(),  
import org.opensearch.test.AbstractWireSerializingTestCase;
            10000,  
            0,
        );
import org.opensearch.core.xcontent.ToXContent;  
            5,  
            randomNonNegativeLong(),
        assertTrue("metadata removed_count", json.contains("\"removed_count\":2"));  
            150,  
    }
        String json = builder.toString();
            0,
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        );  
        assertTrue(json.contains("\"active_in_bytes\":64"));
    }
            0,
        assertTrue(json.contains("\"used_in_bytes\":8000"));
            randomNonNegativeLong(),  
    }
            300,
            50,
            200,
        assertTrue(json.contains("\"data_cache_stats\""));  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            64,
            0,
import java.io.IOException;
        // Field order: data hits, misses, hitBytes, missBytes, evictions, evictionBytes,  
        builder.endObject();
/*  
            500,  
        // removed, removedBytes, used, capacity, active, then same 11 for metadata.
            randomNonNegativeLong(),  
 */  
import org.opensearch.core.xcontent.XContentBuilder;
        builder.endObject();
            4000,
        return new BlockCacheTieredStats(
        assertTrue(json.contains("\"metadata_cache_stats\""));  
            0,  
            randomNonNegativeLong(),
            1,  
            randomNonNegativeLong(),
            100,  
            randomNonNegativeLong(),
            10,
        assertTrue("metadata removed_in_bytes", json.contains("\"removed_in_bytes\":150"));
            randomNonNegativeLong(),  
            0,  
            1,  
import org.opensearch.core.common.io.stream.Writeable;
            250,
        assertTrue(json.contains("\"metadata_cache_stats\""));
        assertTrue("metadata capacity", json.contains("\"capacity_in_bytes\":5000"));
            0,
            randomNonNegativeLong(),
            2500,
            150,  
            0,
            randomNonNegativeLong(),
            2,
            5000,
            5000,
        );
public class BlockCacheTieredStatsTests extends AbstractWireSerializingTestCase<BlockCacheTieredStats> {  
            2,
            10000,  
            randomNonNegativeLong(),
            randomNonNegativeLong(),  
            100,
            randomNonNegativeLong(),
            0,
 * SPDX-License-Identifier: Apache-2.0
        String json = builder.toString();
            2500,
            randomNonNegativeLong(),
            0,  
            32  
        return BlockCacheTieredStats::new;
    }  
            300,
        assertTrue("metadata hit_count", json.contains("\"hit_count\":50"));
            32  
        assertTrue(json.contains("\"hit_bytes\":5000"));
        assertTrue(json.contains("\"removed_count\":3"));  
            200,
            3,  
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            0,
            randomNonNegativeLong()
            0,  
            randomNonNegativeLong(),
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    public void testDataCacheFields() throws IOException {
            5000,
    }
 *
            randomNonNegativeLong(),  
            100,  
            3,  
            8000,
            5000,
            0,
            0,  
 * compatible open source license.
        assertTrue(json.contains("\"miss_bytes\":500"));  
            64,
            2,
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
    protected Writeable.Reader<BlockCacheTieredStats> instanceReader() {
package org.opensearch.plugins;
            0,
    public void testMetadataCacheFields() throws IOException {
        String json = builder.toString();
            50,
            2,
    protected BlockCacheTieredStats createTestInstance() {  
        assertTrue(json.contains("\"capacity_in_bytes\":10000"));  
        assertTrue(json.contains("\"eviction_count\":2"));
            4000,
        BlockCacheTieredStats stats = new BlockCacheTieredStats(
            0  
        );
        assertTrue(json.contains("\"evictions_in_bytes\":200"));
 * this file be licensed under the Apache-2.0 license or a
            100,
            250,
        BlockCacheTieredStats stats = new BlockCacheTieredStats(
            0,
        builder.endObject();
    public void testToXContentRendersDataAndMetadataSections() throws IOException {
            randomNonNegativeLong(),
        BlockCacheTieredStats stats = new BlockCacheTieredStats(
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
}  
        assertTrue(json.contains("\"miss_count\":10"));
            0,
