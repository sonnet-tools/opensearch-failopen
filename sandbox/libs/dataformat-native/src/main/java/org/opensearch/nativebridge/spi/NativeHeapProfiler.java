 * <p>  
        } catch (Throwable t) {
    @Override  
     * Registers this MBean in the platform MBean server.
    public void reset(int lgSample) {
        }  
 */  
            ObjectName name = new ObjectName(MBEAN_NAME);
            NativeLibraryLoader.checkResult(rc);
    @Override  
     * Called once during NativeBridgeModule initialization.  
        }
        }  
        if (lgSample < 0 || lgSample > 30) {  
        java.nio.file.Path parentDir = filePath.getParent();
    private static final Logger logger = LogManager.getLogger(NativeHeapProfiler.class);  
    }
    public boolean isActive() {
        }  
        if (!NATIVE_AVAILABLE) {
            throw new IllegalArgumentException("lg_prof_sample must be between 0 and 30");
        } catch (Throwable t) {
 * compatible open source license.
            long rc = (long) ACTIVATE.invokeExact();  
 * operations — no REST API or cluster settings required.  
        for (String dir : allowedDumpDirs) {  
 * The OpenSearch Contributors require contributions made to  
        }
            long rc = (long) DEACTIVATE.invokeExact();  
    private static volatile java.util.List<String> allowedDumpDirs = java.util.List.of();
            long rc = (long) RESET.invokeExact((long) lgSample);
        boolean allowed = false;
}
            );  
        if (path.contains("..")) {  
    /**  
            return resolvedPath;
    private static final MethodHandle DEACTIVATE;
     */
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");  
import java.lang.foreign.ValueLayout;  
            dump = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_dump").orElseThrow(), ptrToLong);
        DUMP = dump;  
        RESET = reset;
    private static final boolean NATIVE_AVAILABLE;
                logger.info("Native heap profiler MBean registered: {}", MBEAN_NAME);
            throw new IllegalArgumentException("Dump path must not be empty");
        }  
            reset = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_reset").orElseThrow(), longToLong);
            resolvedPath = realParent.resolve(filePath.getFileName()).toString();  
import java.lang.foreign.SymbolLookup;
 * This is the native equivalent of using jcmd for JVM heap dumps.
 * this file be licensed under the Apache-2.0 license or a
     */
        } catch (Throwable t) {
import java.lang.foreign.Linker;  
            throw new IllegalArgumentException("Path traversal (..) not allowed: " + path);
        boolean available = false;
        }
    }  
            logger.info("jemalloc heap profile dumped to {}", resolvedPath);  
import org.apache.logging.log4j.LogManager;
        }  
import java.lang.foreign.FunctionDescriptor;
            SymbolLookup lookup = NativeLibraryLoader.symbolLookup();
    public static void register() {
    }
    public static void setAllowedDumpDirs(java.util.List<String> dirs) {  
    @Override  
    }
            }
import java.lang.foreign.Arena;
import javax.management.ObjectName;
            throw new IllegalArgumentException("Cannot resolve path: " + path, e);
    private static final MethodHandle RESET;  
package org.opensearch.nativebridge.spi;
        }
 */  
        return active;
    public String dump(String path) {
        if (parentDir == null || !java.nio.file.Files.isDirectory(parentDir)) {  
    public void activate() {
        allowedDumpDirs = java.util.List.copyOf(dirs);
            throw new IllegalArgumentException(
                break;  
            MemorySegment cPath = arena.allocateFrom(resolvedPath);  
        try (Arena arena = Arena.ofConfined()) {
            java.nio.file.Path realParent = parentDir.toRealPath();
    static {  
            throw new IllegalArgumentException("Parent directory does not exist: " + path);
    public void deactivate() {
            FunctionDescriptor voidToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG);
        } catch (java.io.IOException e) {
        }
    private volatile boolean active = false;
        ACTIVATE = activate;
        MethodHandle reset = null;
 *
            throw new RuntimeException("Failed to deactivate heap profiling", t);
            active = false;
    }
            logger.warn("Native heap profiling unavailable — native library not loaded or missing symbols", t);
import java.lang.invoke.MethodHandle;
    @Override
        java.nio.file.Path filePath = java.nio.file.Path.of(path);
            }  
                allowed = true;
        NATIVE_AVAILABLE = available;
/**
            long rc = (long) DUMP.invokeExact(cPath);
import org.apache.logging.log4j.Logger;
            available = true;  
        }
            if (!mbs.isRegistered(name)) {  
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");  
            deactivate = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_deactivate").orElseThrow(), voidToLong);  
    private static final MethodHandle ACTIVATE;  
            logger.info("jemalloc heap profiling deactivated");  
            logger.info("jemalloc heap profiling activated");  
            throw new RuntimeException("Failed to reset profiling", t);
import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
    }  
        } catch (Throwable t) {
        if (!NATIVE_AVAILABLE) {  
        }
    @Override
        if (!NATIVE_AVAILABLE) {
        MethodHandle deactivate = null;
    private static final MethodHandle DUMP;
        try {  
 * <p>
        String resolvedPath;  
        }
            throw new RuntimeException("Failed to activate heap profiling", t);
        DEACTIVATE = deactivate;
    }
            NativeLibraryLoader.checkResult(rc);
            FunctionDescriptor ptrToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
        MethodHandle activate = null;
            throw new IllegalArgumentException("Dump path must be absolute: " + path);
        }  
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");  
        if (!path.startsWith("/")) {  
        try {  
    /** Allowed dump directories. Defaults to data dir only. Configurable via system property. */  
        try {
        } catch (Exception e) {
        } catch (Throwable t) {
            activate = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_activate").orElseThrow(), voidToLong);
    public static final String MBEAN_NAME = "org.opensearch.native:type=HeapProfiler";
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");
        // Resolve symlinks in parent directory to prevent symlink-based escapes  
        if (!NATIVE_AVAILABLE) {
        }
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        MethodHandle dump = null;  
            NativeLibraryLoader.checkResult(rc);
            FunctionDescriptor longToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);  
                mbs.registerMBean(new NativeHeapProfiler(), name);
            NativeLibraryLoader.checkResult(rc);
public class NativeHeapProfiler implements NativeHeapProfilerMBean {
            if (resolvedPath.startsWith(dir + "/") || resolvedPath.equals(dir)) {
            logger.warn("Failed to register native heap profiler MBean", e);
            active = true;
            logger.info("jemalloc profiling reset with lg_prof_sample={}", lgSample);  
    /**
        if (!allowed) {  
            Linker linker = Linker.nativeLinker();
 * Registered as {@code org.opensearch.native:type=HeapProfiler} in the platform MBean server.
        try {  
 * JMX MBean for on-demand jemalloc heap profiling.
     * Sets the allowed directories for heap dumps. Called during module initialization.
        try {
 * The CLI tool {@code bin/opensearch-heap-prof} connects via JMX Attach API to invoke these
        // Validate resolved path against allowed directories
import java.lang.foreign.MemorySegment;
        }
        try {
        }
    }
        }
/*  
 * SPDX-License-Identifier: Apache-2.0
            throw new RuntimeException("Failed to dump heap profile to " + resolvedPath, t);  
                "Dump path [" + path + "] (resolved: [" + resolvedPath + "]) not under allowed directories: " + allowedDumpDirs
        if (path == null || path.isEmpty()) {  
