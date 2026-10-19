    }  
        profiler.deactivate();  
        // Should not throw
    public void testDumpRejectsDisallowedPath() {
package org.opensearch.nativebridge.spi;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> profiler.dump("/etc/not_allowed.heap"));
        expectThrows(IllegalArgumentException.class, () -> profiler.dump(null));
        NativeHeapProfiler profiler = new NativeHeapProfiler();
 * These tests run with the native library loaded (same as NativeAllocatorConfigTests).  
        assertTrue(e.getMessage().contains("not under allowed directories"));  
    public void testResetWithValidLgSample() {
 * The OpenSearch Contributors require contributions made to  
/**
    public void testDumpRejectsNullPath() {
    public void testDumpCreatesNonEmptyFile() throws Exception {  
        profiler.activate();
        expectThrows(IllegalArgumentException.class, () -> profiler.reset(-1));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> profiler.dump("relative/path.heap"));
import java.nio.file.Files;  
 */  
        NativeHeapProfiler profiler = new NativeHeapProfiler();
    }
    }
    public void testActivateAndDeactivate() {
        NativeHeapProfiler.setAllowedDumpDirs(List.of("/tmp"));
        NativeHeapProfiler profiler = new NativeHeapProfiler();
        profiler.deactivate();
    public void testDumpRejectsRelativePath() {
 * SPDX-License-Identifier: Apache-2.0
        NativeHeapProfiler.setAllowedDumpDirs(List.of("/tmp"));  
        NativeHeapProfiler.setAllowedDumpDirs(List.of(dumpDir.toString()));  
        expectThrows(IllegalArgumentException.class, () -> profiler.reset(31));
public class NativeHeapProfilerTests extends OpenSearchTestCase {
        NativeHeapProfiler profiler = new NativeHeapProfiler();
        NativeHeapProfiler.setAllowedDumpDirs(List.of("/data"));
 * compatible open source license.
        assertFalse(profiler.isActive());  
    }
 * this file be licensed under the Apache-2.0 license or a
        profiler.reset(17);
        assertFalse(profiler.isActive());  
    }
        String result = profiler.dump(dumpFile.toString());
/*  
        NativeHeapProfiler profiler = new NativeHeapProfiler();
import java.util.List;
        assertTrue(Files.exists(dumpFile));
        Path dumpFile = dumpDir.resolve("test.heap");  
    }
        assertTrue(e.getMessage().contains("must be absolute"));
 * Tests for NativeHeapProfiler MBean operations.
        assertTrue(Files.size(dumpFile) > 0);  
        assertTrue(profiler.isActive());  
        profiler.deactivate();
 */
    public void testResetRejectsInvalidLgSample() {
 *
        Path dumpDir = createTempDir();
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> profiler.dump("/tmp/../etc/evil.heap"));  
}
        NativeHeapProfiler profiler = new NativeHeapProfiler();
        NativeHeapProfiler profiler = new NativeHeapProfiler();  
        NativeHeapProfiler profiler = new NativeHeapProfiler();  
        profiler.activate();  
        profiler.activate();
        expectThrows(IllegalArgumentException.class, () -> profiler.dump(""));
    public void testDumpRejectsEmptyPath() {  
    public void testDumpRejectsPathTraversal() {  
        assertTrue(e.getMessage().contains("Path traversal"));
import java.nio.file.Path;
        assertEquals(dumpFile.toString(), result);
    }
    }  
import org.opensearch.test.OpenSearchTestCase;
        NativeHeapProfiler profiler = new NativeHeapProfiler();
