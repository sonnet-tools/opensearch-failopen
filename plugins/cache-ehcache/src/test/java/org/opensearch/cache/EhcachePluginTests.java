 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
import org.opensearch.test.OpenSearchTestCase;  
 * compatible open source license.
}
 *
        Map<String, ICache.Factory> factoryMap = ehcacheCachePlugin.getCacheFactoryMap();  
import org.opensearch.cache.store.disk.EhcacheDiskCache;
/*  
        assertNotNull(factoryMap);
    }  
package org.opensearch.cache;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(factoryMap.get(EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME));
    public void testGetCacheStoreTypeMap() {
import org.opensearch.common.cache.ICache;
 */  
public class EhcachePluginTests extends OpenSearchTestCase {
    private EhcacheCachePlugin ehcacheCachePlugin = new EhcacheCachePlugin();  
