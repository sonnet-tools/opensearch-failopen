            pinned,
    }  
                validateFullFileCacheStats(fileCacheStats, new FileCacheStats(in));
import org.opensearch.test.OpenSearchTestCase;  
        final long evicted = randomLongBetween(0, active);
        final long active = randomLongBetween(100000, BYTES_IN_GB);  
        }
            hits,
            removed,  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expected.getEvicted(), actual.getEvicted());
            misses,
        assertEquals(expected.getHits(), actual.getHits());  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.io.stream.BytesStreamOutput;
public class FileCacheStatsTests extends OpenSearchTestCase {
    }
        assertEquals(expected.getActivePercent(), actual.getActivePercent());
        assertEquals(expected.getActive(), actual.getActive());
    public void testFullFileCacheStatsSerialization() throws IOException {
            }  
            try (StreamInput in = out.bytes().streamInput()) {
        final long misses = randomLongBetween(0, 10);
        return new FileCacheStats(  
        assertEquals(expected.getUsed(), actual.getUsed());  
package org.opensearch.index.store.remote.filecache;
}
    private static final long BYTES_IN_GB = 1024 * 1024 * 1024;  
        );
            active,
        assertEquals(expected.getCacheMisses(), actual.getCacheMisses());
        assertEquals(expected.getRemoved(), actual.getRemoved());
        final long total = randomLongBetween(100000, BYTES_IN_GB);
        final FileCacheStats fileCacheStats = getMockFullFileCacheStats();  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        final long removed = randomLongBetween(0, 10);
            used,  
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS  
            fileCacheStats.writeTo(out);  
            evicted,
            total,
 * compatible open source license.
    public static FileCacheStats getMockFullFileCacheStats() {
 */  
 *
/*  
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
    }  
        final long used = randomLongBetween(100000, BYTES_IN_GB);
        final long hits = randomLongBetween(0, 10);  
    public static void validateFullFileCacheStats(FileCacheStats expected, FileCacheStats actual) {
 * The OpenSearch Contributors require contributions made to  
        final long pinned = randomLongBetween(100000, BYTES_IN_GB);  
