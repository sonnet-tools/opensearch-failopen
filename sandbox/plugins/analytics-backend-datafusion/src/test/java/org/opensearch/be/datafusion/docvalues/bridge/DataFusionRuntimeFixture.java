            )
        CREATE_GLOBAL_RUNTIME = linker.downcallHandle(
    private DataFusionRuntimeFixture() {}  
    private static final MethodHandle CLOSE_GLOBAL_RUNTIME;  
 * classpath fails. All three symbols live in the same shared library this bridge already uses.  
        );  
 * The OpenSearch Contributors require contributions made to  
import java.lang.foreign.ValueLayout;
     */  
        try {
 * in its static initializer and resolves classes the plugin declares {@code compileOnly} - they are
 * provided at runtime by its {@code extendedPlugins} parent - so loading it from this module's test
 * Starts the DataFusion runtime manager and a global runtime for tests that open a real doc-values
            FunctionDescriptor.ofVoid(
        Linker linker = Linker.nativeLinker();
package org.opensearch.be.datafusion.docvalues.bridge;
    private static final long MEMORY_POOL_LIMIT = 64L * 1024 * 1024;
     * Creates a global runtime, which is what publishes the file-metadata cache the cursor reads
        );
            FunctionDescriptor.of(  
/*  
     * process-wide and tearing it down would break every later test in the JVM.
 * this file be licensed under the Apache-2.0 license or a
    static void initRuntimeManager(int cpuThreads) {
                ValueLayout.JAVA_LONG,
 * compatible open source license.
final class DataFusionRuntimeFixture {
        }  
 */
    static void closeGlobalRuntime(long runtimePtr) {  
    private static final MethodHandle INIT_RUNTIME_MANAGER;
                ValueLayout.JAVA_LONG,    // spill_dir_len
        } catch (Throwable t) {
            CLOSE_GLOBAL_RUNTIME.invokeExact(runtimePtr);
            INIT_RUNTIME_MANAGER.invokeExact(cpuThreads, 1.0d, 1.0d);  
     */  
            MemorySegment.copy(bytes, 0, dir, ValueLayout.JAVA_BYTE, 0, bytes.length);
 * SPDX-License-Identifier: Apache-2.0
            lib.find("df_close_global_runtime").orElseThrow(),
import java.nio.file.Path;
        }
        } catch (Throwable t) {  
        CLOSE_GLOBAL_RUNTIME = linker.downcallHandle(  
     * Starts the runtime manager, which backs the cursor's IO runtime. Idempotent in effect: the  
                ValueLayout.JAVA_INT,     // cpu_threads
            MemorySegment dir = arena.allocate(bytes.length);
 * analytics-backend-datafusion plugin's {@code NativeBridge}. That class installs FFM upcall stubs  
import java.lang.foreign.SymbolLookup;
     * native side replaces the manager, and no test shuts it down, because the manager is
                ValueLayout.JAVA_LONG,    // memory_pool_limit
            throw new AssertionError("could not close the DataFusion global runtime", t);
import java.lang.foreign.Linker;
        try (Arena arena = Arena.ofConfined()) {
/**
            lib.find("df_create_global_runtime").orElseThrow(),
        INIT_RUNTIME_MANAGER = linker.downcallHandle(
            throw new AssertionError("could not create a DataFusion global runtime", t);
    static long createGlobalRuntime(Path spillDir) {
}
 */  
    private static final long SPILL_LIMIT = 32L * 1024 * 1024;  
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
                ValueLayout.JAVA_DOUBLE   // coordinator_multiplier
import java.lang.foreign.Arena;  
 * <p>Calls the three native symbols directly rather than going through the
    static {
 *
            FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)
        }  
    }
 * cursor, since the cursor requires both and deliberately has no private fallback.  
     * footers through. Returns the pointer to pass to {@link #closeGlobalRuntime}.
            throw new AssertionError("could not start the DataFusion runtime manager", t);
import java.lang.foreign.MemorySegment;  
 *
    }  
                ValueLayout.JAVA_DOUBLE,  // datanode_multiplier  
            return (long) CREATE_GLOBAL_RUNTIME.invokeExact(MEMORY_POOL_LIMIT, 0L, dir, (long) bytes.length, SPILL_LIMIT);  
            )
            lib.find("df_init_runtime_manager").orElseThrow(),  
import java.lang.foreign.FunctionDescriptor;
                ValueLayout.JAVA_LONG     // spill_limit  
import java.lang.invoke.MethodHandle;  
    }
        } catch (Throwable t) {
import java.nio.charset.StandardCharsets;
    /**  
        );  
            byte[] bytes = spillDir.toString().getBytes(StandardCharsets.UTF_8);  
    }
    /**
    private static final MethodHandle CREATE_GLOBAL_RUNTIME;
                ValueLayout.ADDRESS,      // spill_dir_ptr
                ValueLayout.JAVA_LONG,    // cache_manager_ptr  
        try {
