    public void testGetPlatformDirectory() {  
        String expected = PlatformHelper.getOSName() + "-" + PlatformHelper.getArchName();
    }
        if (PlatformHelper.isMac()) {  
    public void testGetPlatformLibraryNameMatchesCurrentOS() {
        assertTrue(
        );
            assertEquals(".dll", ext);  
 * SPDX-License-Identifier: Apache-2.0
        String osName = PlatformHelper.getOSName();
            assertEquals(".dylib", ext);
        assertTrue("Library name should contain base name", libName.contains("mylib"));
        } else if (PlatformHelper.isWindows()) {  
 *
            assertEquals(".so", ext);
    }
    }  
        String libName = PlatformHelper.getPlatformLibraryName("testlib");  
        } else if (PlatformHelper.isWindows()) {
        assertTrue("Exactly one OS should be detected, or none for unknown OS", count <= 1);  
        if (PlatformHelper.isLinux()) count++;
        }  
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(
        assertEquals(expected, dir);  
        if (PlatformHelper.isMac()) count++;  
    }
        if (PlatformHelper.isMac()) {
        String arch = PlatformHelper.getArchName();  
        }
            assertEquals("libtestlib.dylib", libName);
        );
            "OS name should be one of: macos, linux, windows, unknown but was: " + osName,  
        String libName = PlatformHelper.getPlatformLibraryName("mylib");
        String ext = PlatformHelper.getNativeExtension();
 * this file be licensed under the Apache-2.0 license or a
    public void testExactlyOneOSDetected() {
    public void testGetOSNameReturnsKnownValue() {  
            assertEquals("testlib.dll", libName);
    }
/*  
        String dir = PlatformHelper.getPlatformDirectory();
        } else {
            osName.equals("macos") || osName.equals("linux") || osName.equals("windows") || osName.equals("unknown")
 */  
}
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        } else if (PlatformHelper.isLinux()) {
package org.opensearch.nativebridge.spi;
    }
            arch.equals("x86_64") || arch.equals("x86") || arch.equals("aarch64") || arch.length() > 0  
        int count = 0;
    }  
            "Arch should be one of: x86_64, x86, aarch64 or raw arch but was: " + arch,
    public void testGetArchNameReturnsKnownValue() {
public class PlatformHelperTests extends OpenSearchTestCase {  
    public void testLibraryNameContainsBaseName() {  
            assertEquals("libtestlib.so", libName);  
        if (PlatformHelper.isWindows()) count++;
    public void testGetNativeExtensionMatchesCurrentOS() {
