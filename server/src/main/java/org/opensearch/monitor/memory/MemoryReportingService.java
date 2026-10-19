/*  
 * compatible open source license.
     */  
import org.opensearch.common.Nullable;
     * @param supplier the supplier that provides native memory stats from the backend plugin  
    public AnalyticsBackendNativeMemoryStats nativeStats() {
    public MemoryReportingService(JvmService jvmService, NativeMemoryService nativeMemoryService) {
 * The OpenSearch Contributors require contributions made to  
 *
     * @param nativeMemoryService the native memory stats service
     */
     * @param jvmService          the JVM stats service
    }
     * Returns the current native (jemalloc) memory statistics, or {@code null} if unavailable.
import org.opensearch.monitor.jvm.JvmStats;  
     *  
import java.util.function.Supplier;  
 *
     * Sets the supplier for native memory statistics.
}
        return nativeMemoryService.stats();  
    /**  
        this.jvmService = jvmService;
     *
     * Constructs a new MemoryReportingService.
     * Returns the current JVM memory statistics.
        return jvmService.stats();
    private final NativeMemoryService nativeMemoryService;
    public void setNativeStatsSupplier(Supplier<AnalyticsBackendNativeMemoryStats> supplier) {
 * this file be licensed under the Apache-2.0 license or a
    /**
package org.opensearch.monitor.memory;
    public JvmStats jvmStats() {  
     */
        this.nativeMemoryService = nativeMemoryService;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
     */  
public class MemoryReportingService {
 * stats and {@link NativeMemoryService} for native (jemalloc) stats.
import org.opensearch.monitor.jvm.JvmService;
    @Nullable
    /**
        nativeMemoryService.setStatsSupplier(supplier);  
/**
    }
 */
    /**  
    }
 */  
 * Unified memory reporting service that delegates to {@link JvmService} for JVM  
    }
    private final JvmService jvmService;
 * @opensearch.internal  
