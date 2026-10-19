/*  
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.Logger;
public final class NativeAllocatorConfig {  
import java.lang.foreign.SymbolLookup;  
 * <p>  
    /**
     *
        SET_DIRTY = linker.downcallHandle(lookup.find("native_jemalloc_set_dirty_decay_ms").orElseThrow(), desc);
        try {  
    }  
    }  
     * Sets muzzy_decay_ms for all jemalloc arenas. No restart required.  
            long rc = (long) handle.invokeExact(ms);
 * Note: {@code lg_tcache_max} is NOT dynamically tunable by jemalloc (init-time only).
 * this file be licensed under the Apache-2.0 license or a
 * Provides methods to adjust jemalloc's {@code dirty_decay_ms} and {@code muzzy_decay_ms}
    private static final MethodHandle SET_DIRTY;
        SymbolLookup lookup = NativeLibraryLoader.symbolLookup();
    public static void setMuzzyDecayMs(long ms) {
        }  
    static {
 *
import org.apache.logging.log4j.LogManager;
    }
 * compatible open source license.
     */  
            logger.info("jemalloc {} updated to {}", name, ms);  
        applyDecay(SET_MUZZY, "muzzy_decay_ms", ms);
    private NativeAllocatorConfig() {}  
    /**
 */
        } catch (Throwable t) {
import java.lang.invoke.MethodHandle;
 */  
    private static final MethodHandle SET_MUZZY;
     * @param ms decay time in milliseconds (-1 to disable decay)
        applyDecay(SET_DIRTY, "dirty_decay_ms", ms);
/**
 * Dynamic jemalloc tuning via FFM.
        SET_MUZZY = linker.downcallHandle(lookup.find("native_jemalloc_set_muzzy_decay_ms").orElseThrow(), desc);  
        FunctionDescriptor desc = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);
 * SPDX-License-Identifier: Apache-2.0
            logger.warn("Error setting jemalloc " + name, t);
     * @param ms decay time in milliseconds (-1 to disable decay)
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
     * Sets dirty_decay_ms for all jemalloc arenas. No restart required.  
}
            NativeLibraryLoader.checkResult(rc);
import java.lang.foreign.ValueLayout;
     */  
    }
 * <p>  
        Linker linker = Linker.nativeLinker();  
    private static final Logger logger = LogManager.getLogger(NativeAllocatorConfig.class);
 * at runtime for all arenas. These are called by plugin-level cluster settings listeners.
    private static void applyDecay(MethodHandle handle, String name, long ms) {
     *
    public static void setDirtyDecayMs(long ms) {
package org.opensearch.nativebridge.spi;
