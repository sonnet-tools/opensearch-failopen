    }
        assertEquals(  
 *
        );  
 * SPDX-License-Identifier: Apache-2.0
import java.util.TreeMap;  
            deserialized.getStatsByCache(CacheType.INDICES_REQUEST_CACHE)
public class NodeCacheStatsTests extends OpenSearchTestCase {
import java.io.IOException;
    public void testSerializationRoundTrip() throws IOException {
import org.opensearch.common.cache.CacheType;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
package org.opensearch.common.cache.service;
/*  
        NodeCacheStats deserialized = copyWriteable(original, writableRegistry(), NodeCacheStats::new);
import org.opensearch.test.OpenSearchTestCase;  
            original.getStatsByCache(CacheType.INDICES_REQUEST_CACHE),
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
}
        CommonStatsFlags flags = new CommonStatsFlags().clear();
        flags.includeCacheType(CacheType.INDICES_REQUEST_CACHE);  
 * The OpenSearch Contributors require contributions made to  
        NodeCacheStats original = new NodeCacheStats(new TreeMap<>(), flags);
 */  
