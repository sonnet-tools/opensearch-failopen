        RESET = reset;
    public void activate() {
        }
        }
            long rc = (long) ACTIVATE.invokeExact();
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");
 *
        try {
import java.lang.foreign.Linker;
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");
        if (!NATIVE_AVAILABLE) {
package org.opensearch.nativebridge.spi;
            throw new IllegalArgumentException("lg_prof_sample must be between 0 and 30");
import java.lang.management.ManagementFactory;
            deactivate = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_deactivate").orElseThrow(), voidToLong);
        }
            logger.warn("Native heap profiling unavailable — native library not loaded or missing symbols", t);
    }
            }
                "Dump path [" + path + "] (resolved: [" + resolvedPath + "]) not under allowed directories: " + allowedDumpDirs
    public static void setAllowedDumpDirs(java.util.List<String> dirs) {
            logger.info("jemalloc heap profiling activated");
        }
            activate = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_activate").orElseThrow(), voidToLong);
 */
            logger.warn("Failed to register native heap profiler MBean", e);
        return active;
        }
    public boolean isActive() {
    }
            Linker linker = Linker.nativeLinker();
        // Resolve symlinks in parent directory to prevent symlink-based escapes
        MethodHandle dump = null;
        for (String dir : allowedDumpDirs) {
     * Registers this MBean in the platform MBean server.
    /** Allowed dump directories. Defaults to data dir only. Configurable via system property. */
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");
 * SPDX-License-Identifier: Apache-2.0
            );
        }
public class NativeHeapProfiler implements NativeHeapProfilerMBean {
        try {
        MethodHandle reset = null;
import org.apache.logging.log4j.LogManager;
        MethodHandle deactivate = null;
            MemorySegment cPath = arena.allocateFrom(resolvedPath);
        }
    }
            active = false;
    @Override
            }
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            logger.info("jemalloc heap profile dumped to {}", resolvedPath);
        }
import javax.management.MBeanServer;
        boolean available = false;
 * This is the native equivalent of using jcmd for JVM heap dumps.
            NativeLibraryLoader.checkResult(rc);
        MethodHandle activate = null;
            throw new IllegalArgumentException("Cannot resolve path: " + path, e);
 * The OpenSearch Contributors require contributions made to
            SymbolLookup lookup = NativeLibraryLoader.symbolLookup();
    public void deactivate() {
            if (!mbs.isRegistered(name)) {
        if (!allowed) {
        try (Arena arena = Arena.ofConfined()) {
import org.apache.logging.log4j.Logger;
    @Override
 * Registered as {@code org.opensearch.native:type=HeapProfiler} in the platform MBean server.
            available = true;
    }
        }
    @Override
        if (lgSample < 0 || lgSample > 30) {
import java.lang.invoke.MethodHandle;
            java.nio.file.Path realParent = parentDir.toRealPath();
            throw new RuntimeException("Failed to activate heap profiling", t);
            NativeLibraryLoader.checkResult(rc);
            throw new IllegalArgumentException(
            FunctionDescriptor longToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG);
 * compatible open source license.
        NATIVE_AVAILABLE = available;
}
        }
 * The CLI tool {@code bin/opensearch-heap-prof} connects via JMX Attach API to invoke these
    }
        }
        }
        } catch (Throwable t) {
        try {
        try {
    }
import java.lang.foreign.SymbolLookup;
        try {
import java.lang.foreign.ValueLayout;
            throw new IllegalArgumentException("Dump path must be absolute: " + path);
 * <p>
            long rc = (long) RESET.invokeExact((long) lgSample);
    private volatile boolean active = false;
        if (!NATIVE_AVAILABLE) {
        } catch (Throwable t) {
    private static volatile java.util.List<String> allowedDumpDirs = java.util.List.of();
            NativeLibraryLoader.checkResult(rc);
            long rc = (long) DUMP.invokeExact(cPath);
        if (parentDir == null || !java.nio.file.Files.isDirectory(parentDir)) {
    @Override
            resolvedPath = realParent.resolve(filePath.getFileName()).toString();
        if (path == null || path.isEmpty()) {
    @Override
        }
            throw new RuntimeException("Native heap profiling unavailable — native library not loaded");
            throw new IllegalArgumentException("Parent directory does not exist: " + path);
    private static final MethodHandle ACTIVATE;
    private static final Logger logger = LogManager.getLogger(NativeHeapProfiler.class);
        if (!path.startsWith("/")) {
            logger.info("jemalloc heap profiling deactivated");
        DEACTIVATE = deactivate;
        DUMP = dump;
        } catch (Throwable t) {
            logger.info("jemalloc profiling reset with lg_prof_sample={}", lgSample);
     */
    private static final MethodHandle RESET;
            throw new RuntimeException("Failed to reset profiling", t);
            ObjectName name = new ObjectName(MBEAN_NAME);
    /**
 * <p>
            return resolvedPath;
            throw new RuntimeException("Failed to deactivate heap profiling", t);
     * Called once during NativeBridgeModule initialization.
        // Validate resolved path against allowed directories
        boolean allowed = false;
        }
        ACTIVATE = activate;
            active = true;
/*
            throw new RuntimeException("Failed to dump heap profile to " + resolvedPath, t);
import java.lang.foreign.FunctionDescriptor;
    private static final MethodHandle DEACTIVATE;
            throw new IllegalArgumentException("Path traversal (..) not allowed: " + path);
import java.lang.foreign.Arena;
        if (path.contains("..")) {
    private static final boolean NATIVE_AVAILABLE;
 */
    public static final String MBEAN_NAME = "org.opensearch.native:type=HeapProfiler";
    public void reset(int lgSample) {
        if (!NATIVE_AVAILABLE) {
        } catch (Exception e) {
 * operations — no REST API or cluster settings required.
        allowedDumpDirs = java.util.List.copyOf(dirs);
        } catch (Throwable t) {
    private static final MethodHandle DUMP;
    static {
                mbs.registerMBean(new NativeHeapProfiler(), name);
            throw new IllegalArgumentException("Dump path must not be empty");
        }
        if (!NATIVE_AVAILABLE) {
        }
    public String dump(String path) {
    }
    /**
 * JMX MBean for on-demand jemalloc heap profiling.
 * this file be licensed under the Apache-2.0 license or a
                allowed = true;
    }
        java.nio.file.Path filePath = java.nio.file.Path.of(path);
        java.nio.file.Path parentDir = filePath.getParent();
     * Sets the allowed directories for heap dumps. Called during module initialization.
            NativeLibraryLoader.checkResult(rc);
import javax.management.ObjectName;
        } catch (Throwable t) {
            dump = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_dump").orElseThrow(), ptrToLong);
        String resolvedPath;
        }
            reset = linker.downcallHandle(lookup.find("native_jemalloc_heap_prof_reset").orElseThrow(), longToLong);
    public static void register() {
        try {
            if (resolvedPath.startsWith(dir + "/") || resolvedPath.equals(dir)) {
        } catch (java.io.IOException e) {
            FunctionDescriptor voidToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG);
import java.lang.foreign.MemorySegment;
     */
            long rc = (long) DEACTIVATE.invokeExact();
/**
                logger.info("Native heap profiler MBean registered: {}", MBEAN_NAME);
            FunctionDescriptor ptrToLong = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
                break;
        }
