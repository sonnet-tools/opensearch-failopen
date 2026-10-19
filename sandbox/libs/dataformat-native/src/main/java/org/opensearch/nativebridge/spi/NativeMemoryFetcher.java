import org.apache.logging.log4j.LogManager;
 * No caching, no server dependencies — just raw downcalls.
import java.lang.foreign.ValueLayout;
            logger.warn("Error fetching native memory stats", t);  
 * compatible open source license.
    }
 */
 * SPDX-License-Identifier: Apache-2.0
    private static final MethodHandle ALLOCATED;
            long resident = (long) RESIDENT.invokeExact();
        SymbolLookup lookup = NativeLibraryLoader.symbolLookup();
            logger.warn("Error reading jemalloc resident bytes", t);
     */
    public static long fetchResidentBytes() {
            if (resident < 0) {
    private static final Logger logger = LogManager.getLogger(NativeMemoryFetcher.class);
/*  
package org.opensearch.nativebridge.spi;
     */
        } catch (Throwable t) {
import java.lang.foreign.Linker;  
        RESIDENT = linker.downcallHandle(lookup.find("native_jemalloc_resident_bytes").orElseThrow(), desc);  
    /**
    /**
/**
import java.lang.invoke.MethodHandle;  
import java.lang.foreign.FunctionDescriptor;
            return -1;  
 *
     * Performs FFM downcalls and returns a fresh AnalyticsBackendNativeMemoryStats snapshot.
                return -1;
import org.apache.logging.log4j.Logger;
                logger.warn("Native memory stats returned error: allocated={}, resident={}", allocated, resident);
            return new AnalyticsBackendNativeMemoryStats(allocated, resident, NativeArenaPurger.getPurgeCount());
            if (allocated < 0 || resident < 0) {  
    private static final MethodHandle RESIDENT;
        }
            }
        } catch (Throwable t) {
     * Returns current jemalloc resident bytes, or -1 on error.  
            }  
 */  
            long allocated = (long) ALLOCATED.invokeExact();
    static {
 * Stateless FFM fetcher for jemalloc memory metrics.  
            long resident = (long) RESIDENT.invokeExact();
 * The OpenSearch Contributors require contributions made to  
        try {  
     * Returns AnalyticsBackendNativeMemoryStats(-1, -1) on error or negative values.  
            return resident;  
                return new AnalyticsBackendNativeMemoryStats(-1, -1, 0);
    }  
        FunctionDescriptor desc = FunctionDescriptor.of(ValueLayout.JAVA_LONG);
    private NativeMemoryFetcher() {}  
 * this file be licensed under the Apache-2.0 license or a
public class NativeMemoryFetcher {  
        }
        ALLOCATED = linker.downcallHandle(lookup.find("native_jemalloc_allocated_bytes").orElseThrow(), desc);
        Linker linker = Linker.nativeLinker();  
                logger.warn("jemalloc resident_bytes returned negative value: {}", resident);  
}
    }
import java.lang.foreign.SymbolLookup;
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;  
            return new AnalyticsBackendNativeMemoryStats(-1, -1, 0);
    public static AnalyticsBackendNativeMemoryStats fetch() {
        try {  
