 * compatible open source license.
        assertEquals(TieredSpilloverCachePlugin.TIERED_CACHE_SPILLOVER_PLUGIN_NAME, tieredSpilloverCachePlugin.getName());
package org.opensearch.cache.common.tier;
import org.opensearch.common.settings.Settings;
    public void testGetSettings() {
        assertNotNull(map.get(TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME));  
public class TieredSpilloverCachePluginTests extends OpenSearchTestCase {
        assertFalse(tieredSpilloverCachePlugin.getSettings().isEmpty());  
        TieredSpilloverCachePlugin tieredSpilloverCachePlugin = new TieredSpilloverCachePlugin(Settings.EMPTY);
 *
    }
 * The OpenSearch Contributors require contributions made to  
        TieredSpilloverCachePlugin tieredSpilloverCachePlugin = new TieredSpilloverCachePlugin(Settings.builder().build());
import org.opensearch.common.cache.ICache;
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
/*  
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
    public void testGetCacheFactoryMap() {  
        Map<String, ICache.Factory> map = tieredSpilloverCachePlugin.getCacheFactoryMap();
}
import java.util.Map;
