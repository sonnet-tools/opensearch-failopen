                logger.debug("Cache type {} is disabled", type.getCacheTypeName());
    }
import static org.opensearch.be.datafusion.cache.CacheSettings.METADATA_CACHE_EVICTION_TYPE;
                + "(footer={}% → {} bytes, offset_index={}% → {} bytes, column_index={}% → {} bytes, statistics={}% → {} bytes)",
        }
    public enum CacheType {
package org.opensearch.be.datafusion.cache;
            }
import static org.opensearch.be.datafusion.cache.CacheSettings.METADATA_CACHE_ENABLED;  
        int ciPct = clusterSettings.get(CacheSettings.COLUMN_INDEX_CACHE_PERCENT);  
            oiLimit,
        @Nullable
    public static NativeCacheManagerHandle createCacheConfig(ClusterSettings clusterSettings) {
 */  
 * this file be licensed under the Apache-2.0 license or a
            metaLimit,
import org.opensearch.common.settings.Setting;  
            this.evictionTypeSetting = evictionTypeSetting;  
        };
    // Private constructor to prevent instantiation
            ciLimit,  
            this.enabledSetting = enabledSetting;
            public boolean isEnabled(ClusterSettings clusterSettings) {  
            }  
        long statsLimit = total * statsPct / 100;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.be.datafusion.cache.CacheSettings.STATISTICS_CACHE_EVICTION_TYPE;
import org.opensearch.common.settings.ClusterSettings;
    private static final Logger logger = LogManager.getLogger(CacheUtils.class);
            @Override
        },
        long cacheManagerPtr = NativeBridge.createCustomCacheManager();
            }  
    /**
            return enabledSetting != null && clusterSettings.get(enabledSetting);  
        public Setting<Boolean> getEnabledSetting() {
        // Compute absolute sizes from the percent model BEFORE creating the caches so  
     * Creates and configures a CacheManagerConfig pointer with all enabled caches.
            @Override
 * Contains the CacheType enum and methods for creating cache configurations.
        },  
     * Cache type enumeration with associated settings.
        logger.info("Initializing cache configuration");  
                return metaLimit;
                    type.getEvictionType(clusterSettings)
        logger.info("Cache configuration completed");  
 * compatible open source license.
     *
        COLUMN_INDEX("COLUMN_INDEX", null, COLUMN_INDEX_CACHE_EVICTION_TYPE) {
 */  
        int oiPct = clusterSettings.get(CacheSettings.OFFSET_INDEX_CACHE_PERCENT);
 *
}  
 * SPDX-License-Identifier: Apache-2.0
     */  
/*  
            @Override
        CacheType(String cacheTypeName, @Nullable Setting<Boolean> enabledSetting, Setting<String> evictionTypeSetting) {  
        long total = clusterSettings.get(CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE).getBytes();  
        long oiLimit = total * oiPct / 100;  
import static org.opensearch.be.datafusion.cache.CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE;
        private final Setting<Boolean> enabledSetting;  
        long metaLimit = total * metaPct / 100;
            total,  
            @Override  
                return clusterSettings.get(org.opensearch.be.datafusion.DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED);  
                    sizeLimit,  
                logger.info(  
            statsPct,
        OFFSET_INDEX("OFFSET_INDEX", null, OFFSET_INDEX_CACHE_EVICTION_TYPE) {
            }  
                NativeBridge.createCache(handle.getPointer(), type.cacheTypeName, sizeLimit, type.getEvictionType(clusterSettings));  
            public boolean isEnabled(ClusterSettings clusterSettings) {
        return handle;
            public long sizeBytes(long metaLimit, long oiLimit, long ciLimit, long statsLimit) {
            return clusterSettings.get(evictionTypeSetting);
            } else {
import org.opensearch.common.Nullable;
        STATISTICS("STATISTICS", STATISTICS_CACHE_ENABLED, STATISTICS_CACHE_EVICTION_TYPE) {
            return evictionTypeSetting;  
            public long sizeBytes(long metaLimit, long oiLimit, long ciLimit, long statsLimit) {  
                long sizeLimit = type.sizeBytes(metaLimit, oiLimit, ciLimit, statsLimit);
            @Override  
        private final Setting<String> evictionTypeSetting;
/**  
                return ciLimit;
                return oiLimit;
    /**  
                    type.getCacheTypeName(),
        int statsPct = clusterSettings.get(CacheSettings.STATISTICS_CACHE_PERCENT);
            @Override  
        long ciLimit = total * ciPct / 100;
import org.apache.logging.log4j.Logger;
        // Configure each enabled cache type using the percent-derived limit.
        }
        },
            "Configuring metadata caches: total={} bytes "
        NativeCacheManagerHandle handle = new NativeCacheManagerHandle(cacheManagerPtr);  
    private CacheUtils() {}
     */
import static org.opensearch.be.datafusion.cache.CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE;
        private final String cacheTypeName;
        public Setting<String> getEvictionTypeSetting() {
        @Nullable  
            this.cacheTypeName = cacheTypeName;
        }  
        }
            statsLimit
            return enabledSetting;
    }
            public long sizeBytes(long metaLimit, long oiLimit, long ciLimit, long statsLimit) {
 * Utility class for cache initialization and configuration.
        int metaPct = clusterSettings.get(CacheSettings.FOOTER_METADATA_CACHE_PERCENT);
     * @param clusterSettings OpenSearch cluster settings containing cache configuration  
            }
        // rather than the old standalone METADATA_CACHE_SIZE_LIMIT (hardcoded 250 MB).
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
        public String getCacheTypeName() {
                );
        }
            oiPct,  
            }  
        );  
        public abstract long sizeBytes(long metaLimit, long oiLimit, long ciLimit, long statsLimit);  
        METADATA("METADATA", METADATA_CACHE_ENABLED, METADATA_CACHE_EVICTION_TYPE) {
public final class CacheUtils {
                    "Configuring {} cache: size={} bytes, eviction={}",
            public long sizeBytes(long metaLimit, long oiLimit, long ciLimit, long statsLimit) {
        public String getEvictionType(ClusterSettings clusterSettings) {  
        // All three caches share the unified METADATA_INDEX_CACHE_TOTAL_SIZE budget.
        }
import static org.opensearch.be.datafusion.cache.CacheSettings.STATISTICS_CACHE_ENABLED;  
            }
            metaPct,
                return clusterSettings.get(org.opensearch.be.datafusion.DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED);
        }  
            if (type.isEnabled(clusterSettings)) {
        for (CacheType type : CacheType.values()) {  
        logger.info(  
                return statsLimit;
        // the footer metadata cache (created in the loop below) gets the correct limit
import org.apache.logging.log4j.LogManager;
            ciPct,
        public boolean isEnabled(ClusterSettings clusterSettings) {
            return cacheTypeName;
