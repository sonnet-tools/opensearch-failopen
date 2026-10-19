     */
    /**
            }  
    public static long getPurgeCount() {
        try {  
    }
    /** Number of times a purge was actually executed by the Rust background thread. */  
            if (rc != 0) {  
    private static final Logger logger = LogManager.getLogger(NativeArenaPurger.class);  
    }  
    static {
     * Sets the check interval in milliseconds. Set to 0 to pause periodic purging.
    }  
import java.lang.foreign.SymbolLookup;  
 * this file be licensed under the Apache-2.0 license or a
                logger.warn("native_jemalloc_set_purge_threshold returned {}", rc);
        SET_INTERVAL = linker.downcallHandle(lookup.find("native_jemalloc_set_purge_interval").orElseThrow(), longToLong);
            }
        }  
 * Delegates to a dedicated Rust OS thread ({@code jemalloc-purge}) that periodically
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
/*  
     * Starts the Rust-side background purge thread. Idempotent — only the first call
                logger.warn("native_jemalloc_set_purge_interval returned {}", rc);
            logger.info("jemalloc purge check interval updated to {} ms", ms);  
            logger.warn("Failed to stop purge thread", t);
        try {
            long rc = (long) START_PURGE_THREAD.invokeExact(thresholdBytes, intervalMs);
 * <p>  
    public static void stop() {
 *
            return (long) GET_PURGE_COUNT.invokeExact();  
     * Typically computed as {@code node.native_memory.limit * purge_threshold_percent / 100}.
            if (rc != 0) {
        SymbolLookup lookup = NativeLibraryLoader.symbolLookup();  
        Linker linker = Linker.nativeLinker();
}  
import org.apache.logging.log4j.LogManager;
    private static final MethodHandle SET_THRESHOLD;
        SET_THRESHOLD = linker.downcallHandle(lookup.find("native_jemalloc_set_purge_threshold").orElseThrow(), longToLong);  
            logger.warn("Failed to set purge interval", t);
        FunctionDescriptor longToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);  
            long rc = (long) STOP_PURGE_THREAD.invokeExact();  
 * <p>Java controls the thread via FFI setters for threshold and interval. The thread  
    public static void init(long thresholdBytes, long intervalMs) {
        GET_PURGE_COUNT = linker.downcallHandle(lookup.find("native_jemalloc_get_purge_count").orElseThrow(), voidToLong);
 * The OpenSearch Contributors require contributions made to  
            }
     */
/**
 * <p><b>Configuration:</b>  
        } catch (Throwable t) {
        } catch (Throwable t) {
        try {
 *   <li>{@code native.jemalloc.purge_interval} — how often to check. Default: 5s.</li>
            logger.info("jemalloc purge threshold updated to {} MB", bytes / (1024 * 1024));  
        } catch (Throwable t) {  
        STOP_PURGE_THREAD = linker.downcallHandle(lookup.find("native_jemalloc_stop_purge_thread").orElseThrow(), voidToLong);
 * is started once at node startup and runs until process exit.
            logger.warn("Failed to set purge threshold", t);
 *   <li>{@code native.jemalloc.purge_threshold_percent} — purge fires only when
    }
        try {
    private static final MethodHandle GET_PURGE_COUNT;  
 * SPDX-License-Identifier: Apache-2.0
                logger.warn("native_jemalloc_start_purge_thread returned {}", rc);  
     */
 *
    private static final MethodHandle STOP_PURGE_THREAD;  
 */  
 * directly — no FFI round-trip per check cycle.
            if (rc != 0) {
        } catch (Throwable t) {
package org.opensearch.nativebridge.spi;
        }
    }
            }
    /**  
            logger.info("jemalloc purge thread started (threshold={} MB, interval={} ms)", thresholdBytes / (1024 * 1024), intervalMs);
import java.lang.foreign.FunctionDescriptor;
            long rc = (long) SET_INTERVAL.invokeExact(ms);
        START_PURGE_THREAD = linker.downcallHandle(
    private NativeArenaPurger() {}
     * spawns the thread. Must be called once at node startup.  
import java.lang.foreign.Linker;
 */  
 *
    public static void setThresholdBytes(long bytes) {  
 * checks jemalloc resident bytes and purges all arenas if resident exceeds the
            long rc = (long) SET_THRESHOLD.invokeExact(bytes);
     * Sets the threshold in absolute bytes. Purge fires only when resident exceeds this.  
 * </ul>
    /** Stops the Rust-side purge thread. Called during node shutdown. */  
        );
import org.apache.logging.log4j.Logger;
    private static final MethodHandle START_PURGE_THREAD;
    }
 * configured threshold. The Rust thread reads jemalloc stats and calls mallctl  
                logger.warn("native_jemalloc_stop_purge_thread returned {}", rc);
        } catch (Throwable t) {
        }  
 * <ul>
            return 0;
            logger.warn("Failed to start jemalloc purge thread", t);
    /**
 * compatible open source license.
 * Periodic jemalloc arena purger with threshold-based activation.
public final class NativeArenaPurger {
            if (rc != 0) {  
        }  
            lookup.find("native_jemalloc_start_purge_thread").orElseThrow(),
import java.lang.invoke.MethodHandle;
        FunctionDescriptor voidToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG);
import java.lang.foreign.ValueLayout;
    public static void setCheckIntervalMs(long ms) {  
        }  
 *       resident exceeds this percentage of {@code node.native_memory.limit}. Default: 85%.</li>  
        try {
    private static final MethodHandle SET_INTERVAL;
