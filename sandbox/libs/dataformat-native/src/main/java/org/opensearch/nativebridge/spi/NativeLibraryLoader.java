 * <p>Error convention: FFM functions return {@code i64}. If {@code result < 0},
        // Try native.lib.path system property (for tests)
                Path tempLib = tempDir.resolve(libFile);  
                FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG)  
        return Holder.LOOKUP;
 * The OpenSearch Contributors require contributions made to  
    private static String readAndFreeError(long errPtr) {  
    private static SymbolLookup loadLibrary() {  
import java.nio.file.Files;  
 * compatible open source license.
 * negate it to get a pointer to a heap-allocated error string. Call  
            Linker linker = Linker.nativeLinker();
 *
            // getString stops at the null terminator. This is the standard FFM
    public static long checkResult(long result) {
     * Holder class for lazy, thread-safe initialization.  
import java.io.InputStream;
    }
                tempDir.toFile().deleteOnExit();
     * the native error message, frees it, and throws a {@link RuntimeException}.
     */  
    /**  
 * Loads the unified native library and provides a shared {@link SymbolLookup}.
import java.lang.foreign.Linker;
     * Returns {@code true} if the native library has been (or can be) successfully loaded.  
public final class NativeLibraryLoader {  
import java.nio.file.StandardCopyOption;
        static final MethodHandle ERROR_MESSAGE;  
        try {
            try {
 *  
        return msg;  
        String nativeLibPath = System.getProperty("native.lib.path");  
    private NativeLibraryLoader() {}
        String javaLibPath = System.getProperty("java.library.path", "");
    public static SymbolLookup symbolLookup() {
        throw new RuntimeException("Failed to load native library '" + LIBRARY_NAME + "'");
            // CString is null-terminated — reinterpret to max addressable range,
     */
import java.lang.foreign.Arena;
        }  
        throw new RuntimeException(readAndFreeError(-result));
import java.lang.foreign.FunctionDescriptor;  
    private static final class Holder {
            }
        try (InputStream is = NativeLibraryLoader.class.getResourceAsStream(resourcePath)) {  
import java.lang.foreign.SymbolLookup;  
            if (dir.isEmpty()) {  
        static {  
        }
            }  
 * this file be licensed under the Apache-2.0 license or a
            return result;
                LOOKUP.find("native_error_message").orElseThrow(),
        String msg;
            symbolLookup();
import java.lang.invoke.MethodHandle;
     * Reads a native error message from the given error pointer and frees it.  
}
     * The error pointer must have been produced by Rust's {@code into_error_ptr}.
        } catch (Throwable t) {
        if (result >= 0) {  
        try {
    }
 * initialized exactly once, on first access, with full happens-before semantics.  
            // Register the Rust→Java log callback, then push the active log level
    }  
                continue;
            MemorySegment msgSeg = (MemorySegment) Holder.ERROR_MESSAGE.invokeExact(errPtr);  
    /**
        }
    /**
            LOOKUP.find("native_logger_init").ifPresent(sym -> RustLoggerBridge.register(linker, sym));
 * without explicit synchronization. The JVM guarantees that the holder class is
        // Try java.library.path  
    public static boolean isLoaded() {  
            return false;
            if (is != null) {
            return SymbolLookup.libraryLookup(Path.of(nativeLibPath), Arena.global());
        } finally {
        }
        } catch (Throwable t) {
 */
        }
        if (errPtr == 0) {
            } catch (Throwable ignored) {}
    // ---- Library loading ----  
     */
            );
        if (nativeLibPath != null) {
     * Checks an FFM result. If {@code >= 0}, returns it. If {@code < 0}, reads
            if (Files.exists(candidate)) {
            ERROR_MESSAGE = linker.downcallHandle(  
                Files.copy(is, tempLib, StandardCopyOption.REPLACE_EXISTING);
                LOOKUP.find("native_error_free").orElseThrow(),
        }  
                tempLib.toFile().setExecutable(true);
     * This method does not throw — it returns {@code false} if loading fails.
            msg = msgSeg.reinterpret(Long.MAX_VALUE).getString(0);
    /** Returns the shared {@link SymbolLookup}. Loads the library on first call. */  
    private static final String LIBRARY_NAME = "opensearch_native";
                return SymbolLookup.libraryLookup(tempLib, Arena.global());
            ERROR_FREE = linker.downcallHandle(
     * Same as {@link #checkResult} but throws {@link IOException}.  
        }  
     */
    }
     * @param errPtr the positive error pointer (already negated by the caller)  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.nativebridge.spi;
     * with full happens-before semantics — no volatile, no synchronized needed.
    // ---- Initialization-on-demand holder ----  
            return result;  
    }  
        static final MethodHandle ERROR_FREE;
    /**
    // ---- Error handling ----  
 *
import java.lang.foreign.ValueLayout;
import java.io.IOException;  
     * @return the error message string
        }  
            );  
        for (String dir : javaLibPath.split(System.getProperty("path.separator"))) {
    }
        if (result >= 0) {
     *
            return true;  
     */  
    /**
    @SuppressForbidden(reason = "Needs temp directory to extract native library from classpath")
            }  
    public static long checkResultIO(long result) throws IOException {
                return SymbolLookup.libraryLookup(candidate, Arena.global());
 */  
        } catch (IOException e) {
            return "native error with null pointer";
     * The JVM guarantees this class is initialized exactly once on first access,
 * <p>Uses the initialization-on-demand holder idiom for thread-safe lazy loading
/*  
/**
            LOOKUP = loadLibrary();
            Path candidate = Path.of(dir, libFile);  
        }  
        String platformDir = PlatformHelper.getPlatformDirectory();
import java.lang.foreign.MemorySegment;
                Holder.ERROR_FREE.invokeExact(errPtr);  
 * {@link #checkResult(long)} to automatically convert errors to exceptions.
        static final SymbolLookup LOOKUP;
        String resourcePath = "/native/" + platformDir + "/" + libFile;
        throw new IOException(readAndFreeError(-result));  
                Path tempDir = Files.createTempDirectory("opensearch-native-");
        String libFile = PlatformHelper.getPlatformLibraryName(LIBRARY_NAME);
            // pattern for reading C strings of unknown length.  
                FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
import java.nio.file.Path;
        // Try classpath resources  
            LOOKUP.find("native_logger_set_level").ifPresent(sym -> RustLoggerBridge.registerSetLevel(linker, sym));
            // so the logging macros short-circuit `format!` for suppressed levels.  
            msg = "failed to read native error (ptr=0x" + Long.toHexString(errPtr) + ")";  
    }  
            // fall through
                tempLib.toFile().deleteOnExit();  
import org.opensearch.common.SuppressForbidden;
