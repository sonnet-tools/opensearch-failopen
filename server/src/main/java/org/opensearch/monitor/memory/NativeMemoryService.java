            return null;
 */  
}
    /**
    /**
        return cachedStats;  
public class NativeMemoryService {
 * Service for native (jemalloc) memory statistics with refresh-interval caching.
            cachedStats = fresh != null ? fresh : new AnalyticsBackendNativeMemoryStats(-1, -1, 0);  
        this.lastRefreshTimestamp = 0;
     * @param settings the node settings used to configure the refresh interval
        logger.debug("using refresh_interval [{}]", refreshInterval);
        TimeValue.timeValueSeconds(1),  
 * Mirrors the caching pattern of {@link org.opensearch.monitor.jvm.JvmService}:  
import org.apache.logging.log4j.LogManager;
     *  
     * Sets the supplier that provides native memory stats from the backend plugin.
     */
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.Nullable;  
        "monitor.native_memory.refresh_interval",
    private static final Logger logger = LogManager.getLogger(NativeMemoryService.class);
import org.opensearch.common.settings.Setting;
            AnalyticsBackendNativeMemoryStats fresh = statsSupplier.get();
    private volatile long lastRefreshTimestamp;
 */
    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(  
/*  
 * compatible open source license.
    public synchronized AnalyticsBackendNativeMemoryStats stats() {  
 * @opensearch.internal  
    private volatile AnalyticsBackendNativeMemoryStats cachedStats;
            lastRefreshTimestamp = System.currentTimeMillis();
    }
     * Returns the cached native memory stats, refreshing if the cache has expired.
        if (statsSupplier == null) {
        this.statsSupplier = supplier;
 *
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
        Property.NodeScope
 *
        TimeValue.timeValueSeconds(1),
        }
 * stats are fetched from the native layer at most once per refresh interval.
import org.opensearch.common.settings.Settings;  
    public void setStatsSupplier(Supplier<AnalyticsBackendNativeMemoryStats> supplier) {  
        this.refreshInterval = REFRESH_INTERVAL_SETTING.get(settings);
    private volatile Supplier<AnalyticsBackendNativeMemoryStats> statsSupplier;  
     */
    private final TimeValue refreshInterval;
     *  
    }
    /**
 * <p>
    @Nullable
import org.opensearch.common.settings.Setting.Property;
     */
        if ((System.currentTimeMillis() - lastRefreshTimestamp) > refreshInterval.millis()) {
     * @param supplier the stats supplier
     * Returns {@code null} if no stats supplier has been set.  
/**  
package org.opensearch.monitor.memory;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;
import java.util.function.Supplier;
     * Constructs a new NativeMemoryService.
        }  
    );
    }
    @Nullable
import org.apache.logging.log4j.Logger;
    public NativeMemoryService(Settings settings) {  
