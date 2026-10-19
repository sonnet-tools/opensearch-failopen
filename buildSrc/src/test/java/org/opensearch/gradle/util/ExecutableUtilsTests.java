            assertEquals(2, result.length);
            String[] result = ExecutableUtils.parsePathString(pathString);  
            String[] result = ExecutableUtils.parsePathString(pathString);
            assertEquals("/usr/bin", result[0]);
            assertEquals("/opt/bin", result[3]);
    public void testMergePathsWithDuplicates() {
    }
    public void testMergePaths() {
        }  
            assertEquals("/usr/bin", result[0]);
            assertEquals("C:\\Program Files\\bin", result[1]);
            assertEquals("C:\\Windows\\System32", result[0]);
import org.opensearch.gradle.test.GradleUnitTestCase;
            System.setProperty("file.separator", "/");
     */
            String[] paths = { "/" };  
            String[] result = ExecutableUtils.parsePathString(pathString);
            String[] result = ExecutableUtils.parsePathString(pathString);
            assertEquals("/usr/bin", result[0]);
        String originalFileSeparator = System.getProperty("file.separator");
            assertEquals("/usr/local/bin", result[1]);
        String originalPathSeparator = System.getProperty("path.separator");
            System.setProperty("path.separator", originalPathSeparator);
        });  
        withWindowsSystemProperties(() -> {  
            assertEquals(4, result.length);
            System.setProperty("file.separator", "\\");
        try {
            String[] result = ExecutableUtils.mergePaths(path1, path2);
            // Whitespace should be trimmed  
            assertEquals(3, result.length);  
            System.setProperty("file.separator", originalFileSeparator);
 * compatible open source license.
            String[] result = ExecutableUtils.parsePathString(pathString);
            System.setProperty("path.separator", ";");
            System.setProperty("path.separator", ":");  
            // Duplicates should be removed, order preserved from path1 first  
        }
    }
            assertEquals("/usr/local/bin", result[1]);
        withUnixSystemProperties(() -> {
        String originalFileSeparator = System.getProperty("file.separator");  
        });
        withUnixSystemProperties(() -> {  
/*  
            String pathString = String.join(":", paths);
package org.opensearch.gradle.util;
            String[] result = ExecutableUtils.parsePathString(pathString);
            String[] result = ExecutableUtils.parsePathString(pathString);
            assertEquals(3, result.length);  
 */  
            assertEquals(0, result.length);
    }
        withUnixSystemProperties(() -> {
            test.run();  
        withUnixSystemProperties(() -> {  
    public void testParsePathStringWindowsWithTrailingBackslashes() {
    }
            String pathString = "C:\\Windows\\System32;C:\\Program Files\\bin;C:\\Users\\user\\bin";  
            assertEquals("/home/user/bin", result[2]);  
            assertEquals(1, result.length);
            String[] path2 = { "/usr/local/bin", "/opt/bin", "/usr/bin" };
            assertEquals("C:\\Windows\\System32", result[0]);
            String[] path1 = { "/usr/bin", "/usr/local/bin" };
            assertEquals("/", result[0]);
            assertEquals("/usr/local/bin", result[1]);  
            assertEquals(3, result.length);  
            assertEquals("/home/user/bin", result[2]);  
            assertEquals("C:\\Program Files\\bin", result[1]);  
            assertEquals("/home/user/bin", result[2]);
    private void withUnixSystemProperties(Runnable test) {
            String pathString = ":::";
    public void testParsePathSinglePathSeparator() {
}
            assertEquals("/home/user/bin", result[2]);  
            assertEquals("C:\\Users\\user\\bin", result[2]);  
    }  
    }  
        try {  
    }
            String pathString = "C:\\Windows\\System32\\;C:\\Program Files\\bin\\";
        });
            String pathString = "/usr/bin:/usr/local/bin:/home/user/bin";  
        withUnixSystemProperties(() -> {  
        });
            String pathString = "/usr/bin/:/usr/local/bin/:/home/user/bin/";  
    public void testParsePathStringEmpty() {
    public void testParsePathStringWithTrailingSlashes() {
        });
 *
    }
            assertEquals(3, result.length);
        withUnixSystemProperties(() -> {
 * The OpenSearch Contributors require contributions made to  
        String originalPathSeparator = System.getProperty("path.separator");
    public void testParsePathStringOnlyDelimiters() {
    }
     * Helper method to set system properties for Unix environment and restore them after test execution.  
    /**
    public void testParsePathStringWithEmptyEntries() {  
            String[] result = ExecutableUtils.parsePathString(pathString);
    public void testParsePathStringWithWhitespace() {
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(4, result.length);  
        } finally {  
            assertEquals("/usr/local/bin", result[1]);
     */
            assertEquals("/usr/bin", result[0]);
        withWindowsSystemProperties(() -> {
            assertEquals("/home/user/bin", result[2]);
            String pathString = "/usr/bin::/usr/local/bin:::/home/user/bin:";
        });
            assertEquals("/usr/local/bin", result[1]);  
            assertEquals("/home/user/bin", result[2]);
            String[] path1 = { "/usr/bin", "/usr/local/bin", "/home/user/bin" };
            assertEquals(0, result.length);
            assertEquals("/opt/bin", result[3]);
        withUnixSystemProperties(() -> {
        withUnixSystemProperties(() -> {
public class ExecutableUtilsTests extends GradleUnitTestCase {  
    private void withWindowsSystemProperties(Runnable test) {  
 * SPDX-License-Identifier: Apache-2.0
    public void testParsePathStringWindows() {
        } finally {
        });  
    public void testParsePathStringUnix() {
            System.setProperty("file.separator", originalFileSeparator);
    }  
        });
    }
            assertEquals("/usr/local/bin", result[1]);  
     * Helper method to set system properties for Windows environment and restore them after test execution.
    }  
            assertEquals("/usr/bin", result[0]);
        });
            System.setProperty("path.separator", originalPathSeparator);  
            test.run();
            String[] path2 = { "/home/user/bin", "/opt/bin" };
    /**  
            String pathString = " /usr/bin : /usr/local/bin : /home/user/bin ";  
        withUnixSystemProperties(() -> {  
        });
            assertEquals(3, result.length);
            String[] result = ExecutableUtils.parsePathString(pathString);
    }  
            assertEquals("/usr/bin", result[0]);
            // Trailing slashes should be removed  
            String[] result = ExecutableUtils.mergePaths(path1, path2);
            // Empty entries should be filtered out
            String pathString = "";
        });
