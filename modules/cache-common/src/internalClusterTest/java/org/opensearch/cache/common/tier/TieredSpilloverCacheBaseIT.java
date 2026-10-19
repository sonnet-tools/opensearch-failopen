 * compatible open source license.
            .put(  
            )
}  
import org.opensearch.common.cache.settings.CacheSettings;
    public int getNumberOfSegments() {  
 * SPDX-License-Identifier: Apache-2.0
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
    public Settings defaultSettings(String onHeapCacheSizeInBytesOrPercentage, int numberOfSegments) {  
 *
                ).getKey(),  
            )
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(
        return Settings.builder()
public class TieredSpilloverCacheBaseIT extends OpenSearchIntegTestCase {
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),  
 * this file be licensed under the Apache-2.0 license or a
            )
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
/*  
                numberOfSegments
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
package org.opensearch.cache.common.tier;
 */  
    }
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
    }
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;  
 * The OpenSearch Contributors require contributions made to  
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        return randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
            .put(
                ).getKey(),  
                onHeapCacheSizeInBytesOrPercentage
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            .put(  
import org.opensearch.common.cache.CacheType;
                ).getKey(),  
                ).getKey(),  
            )
            )
import org.opensearch.test.OpenSearchIntegTestCase;
            .build();  
import org.opensearch.common.settings.Settings;
            .put(  
                MockDiskCache.MockDiskCacheFactory.NAME
            .put(  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
