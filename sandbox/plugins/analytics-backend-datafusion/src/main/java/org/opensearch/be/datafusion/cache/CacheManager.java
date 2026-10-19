        this.runtimeHandle = runtimeHandle;  
            String[] filesArray = files.toArray(new String[0]);
            if (files == null || files.isEmpty()) {
    private static final Logger logger = LogManager.getLogger(CacheManager.class);
                return;  
        }
        try {
        } catch (Exception e) {
            NativeBridge.cacheManagerUpdateSizeLimit(runtimeHandle.get(), cacheType.getCacheTypeName(), sizeLimit);  
        } catch (Exception e) {
    public void removeFilesFromCacheManager(List<String> files) {  
 * this file be licensed under the Apache-2.0 license or a
 */  
            return 0;  
            logger.error("Error getting entry from cache", e);
}  
        } catch (Exception e) {
import org.apache.logging.log4j.Logger;
    }
    public long getMemoryConsumed(CacheUtils.CacheType cacheType) {
        }
                return;  
    }  
            NativeBridge.cacheManagerClearByCacheType(runtimeHandle.get(), cacheType.getCacheTypeName());
        } catch (Exception e) {
        }
        }
            logger.error("Error removing files from cache manager", e);
/*  
        } catch (Exception e) {  
    public void clearCacheForCacheType(CacheUtils.CacheType cacheType) {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            logger.error("Error adding files to cache manager", e);
 * The OpenSearch Contributors require contributions made to  
    public void addFilesToCacheManager(List<String> files) {  
 *
    public void clearAllCache() {  
            }
public class CacheManager {  
            logger.info("Updated {} cache size limit to {} bytes", cacheType.getCacheTypeName(), sizeLimit);
    }
            }
    }
    }
    public boolean getEntryFromCacheType(CacheUtils.CacheType cacheType, String filePath) {
            logger.error("Error updating cache size limit", e);  
 * Manages cache lifecycle for DataFusion caches.  
    private final NativeRuntimeHandle runtimeHandle;  
 * compatible open source license.
            logger.error("Error clearing cache manager", e);
    }
    public long getTotalMemoryConsumed() {
            return 0;  
    public void updateSizeLimit(CacheUtils.CacheType cacheType, long sizeLimit) {
        }  
        try {
            NativeBridge.cacheManagerClear(runtimeHandle.get());
        try {
        try {
        } catch (Exception e) {
            if (files == null || files.isEmpty()) {
        try {
    }
 */
            logger.error("Error clearing cache for cache type", e);  
            return NativeBridge.cacheManagerGetTotalMemoryConsumed(runtimeHandle.get());  
package org.opensearch.be.datafusion.cache;
            return NativeBridge.cacheManagerGetItemByCacheType(runtimeHandle.get(), cacheType.getCacheTypeName(), filePath);  
        try {
        try {
    }
            NativeBridge.cacheManagerAddFiles(runtimeHandle.get(), filesArray);  
    public CacheManager(NativeRuntimeHandle runtimeHandle) {
        } catch (Exception e) {
/**
        }
        }  
        try {  
            return NativeBridge.cacheManagerGetMemoryConsumedForCacheType(runtimeHandle.get(), cacheType.getCacheTypeName());  
            String[] filesArray = files.toArray(new String[0]);
        } catch (Exception e) {
import java.util.List;  
            logger.error("Error getting memory consumed for cache type", e);
        }
            return false;  
import org.apache.logging.log4j.LogManager;
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.be.datafusion.NativeRuntimeHandle;  
 * Holds the cache manager pointer for runtime cache operations.
            NativeBridge.cacheManagerRemoveFiles(runtimeHandle.get(), filesArray);  
            logger.error("Error getting total memory consumed", e);
