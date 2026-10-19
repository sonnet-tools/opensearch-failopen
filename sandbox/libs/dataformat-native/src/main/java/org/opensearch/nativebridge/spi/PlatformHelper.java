     *
        }  
 */  
     * @param resourceAnchor a class from the plugin JAR that bundles the native library  
    /**
            Path tempLib = tempDir.resolve(libFileName);
    /**  
     */  
    /**  
            return baseName + ".dll";
            return "lib" + baseName + ".dylib";  
/**
     * @return one of "windows", "macos", "linux", or "unknown"
    private PlatformHelper() {}  
        return OS_NAME.contains("mac") || OS_NAME.contains("darwin");
    private static final String OS_ARCH = System.getProperty("os.arch").toLowerCase(Locale.ROOT);
import org.opensearch.common.SuppressForbidden;
     * @param libName        base library name (e.g. "parquet_dataformat_jni")
            tempDir.toFile().deleteOnExit();  
            throw new RuntimeException("Failed to load native library: " + libFileName, e);
     */
            return "aarch64";
    public static boolean isWindows() {
     */
            System.load(tempLib.toAbsolutePath().toString());
    }
    }
import java.nio.file.Files;
        if (isWindows()) {  
     */
    @SuppressForbidden(reason = "Needs temp directory to extract native library from classpath")
        if (isWindows()) return ".dll";  
            }  
     * @return one of "x86_64", "x86", "aarch64", or the raw arch string  
    public static String getPlatformDirectory() {
     */
        if (OS_ARCH.contains("amd64") || OS_ARCH.contains("x86_64")) {  
     */
    }
 * The OpenSearch Contributors require contributions made to  
import java.io.InputStream;
            return "x86_64";
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase(Locale.ROOT);  
     * Returns the normalized operating system name.  
    }  
     * @return true on Windows  
    /**
     * @return ".dll", ".dylib", or ".so"  
        return getOSName() + "-" + getArchName();
     * @return true on macOS
        return ".so";
    /**
    /**
     */  
        }  
     * Returns {@code true} if the current OS is Windows.
     * Returns {@code true} if the current OS is macOS.
     * Returns the normalized CPU architecture name.
        String libFileName = getPlatformLibraryName(libName);
        if (isLinux()) return "linux";  
        return OS_NAME.contains("linux");
            return "x86";  
        if (isMac()) return ".dylib";
    }
    public static void loadNativeLibrary(String libName, Class<?> resourceAnchor) {  
import java.nio.file.Path;  
 *
 * compatible open source license.
        } catch (IOException e) {
        String resourcePath = "/native/" + platformDir + "/" + libFileName;  
    public static String getOSName() {  
            tempLib.toFile().deleteOnExit();
     * Returns {@code true} if the current OS is Linux.  
    /**  
    }  
        return OS_ARCH;
        } else if (OS_ARCH.contains("x86")) {
     * Returns the platform directory name in the format {@code os-arch}.
 * this file be licensed under the Apache-2.0 license or a
 * Utility class for platform-specific operations and native library handling.
     */
public class PlatformHelper {
        if (isWindows()) return "windows";
        try (InputStream is = resourceAnchor.getResourceAsStream(resourcePath)) {
     * @return platform directory string (e.g. linux-x86_64, macos-aarch64)
    }
        }  
     * @param baseName the base library name without extension
     * Returns the platform-specific library file name for the given base name.
package org.opensearch.nativebridge.spi;
 */  
        } else if (isMac()) {
     * Returns the native library file extension for the current platform.
            Files.copy(is, tempLib, StandardCopyOption.REPLACE_EXISTING);  
     * Loads a native library by name, using the given class to locate the resource on the classpath.  
    public static boolean isLinux() {  
    public static String getArchName() {
            return "lib" + baseName + ".so";
     * @return true on Linux
    public static String getNativeExtension() {
import java.util.Locale;
                return;
}
            if (is == null) {  
        return OS_NAME.contains("win");  
    public static boolean isMac() {
    /**
            Path tempDir = Files.createTempDirectory("opensearch-native-");
/*  
        return "unknown";
     */
        } else {
        if (isMac()) return "macos";
import java.io.IOException;  
    /**
        String platformDir = getPlatformDirectory();
                System.loadLibrary(libName);
    public static String getPlatformLibraryName(String baseName) {
import java.nio.file.StandardCopyOption;
     * @return the full library file name (e.g. libfoo.so, libfoo.dylib, foo.dll)  
        } else if (OS_ARCH.contains("aarch64") || OS_ARCH.contains("arm64")) {
