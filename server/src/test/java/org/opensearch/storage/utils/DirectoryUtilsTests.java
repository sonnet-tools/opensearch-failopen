import java.nio.file.Path;
        FilterDirectory wrapped = new FilterDirectory(fsDirectory) {
        };
    public void testUnwrapFSDirectoryDirect() {
import org.apache.lucene.store.Directory;
    public void testUnwrapFSDirectoryMultipleWrappers() {
        FilterDirectory outer = new FilterDirectory(inner) {
        Path result = DirectoryUtils.getFilePath(wrapped, "test_file.si");  
public class DirectoryUtilsTests extends OpenSearchTestCase {
    }  
        assertSame(fsDirectory, result);
    public void testUnwrapFSDirectoryThrowsWhenNoFSDirectory() {
    private FSDirectory fsDirectory;
    }
        assertEquals(tempDir.resolve("test_file.si" + DirectoryUtils.SWITCHABLE_PREFIX), result);
        };
        assertEquals(tempDir.resolve("test_file.si"), result);
        assertSame(fsDirectory, result);
 * compatible open source license.
    public void testUnwrapFSDirectoryThrowsWhenWrappedNonFSDirectory() {
import org.opensearch.test.OpenSearchTestCase;
        };
 * this file be licensed under the Apache-2.0 license or a
    public void testGetFilePath() {
        FilterDirectory wrapped = new FilterDirectory(fsDirectory) {
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> DirectoryUtils.unwrapFSDirectory(nonFsDir));
    private Path tempDir;
        FSDirectory result = DirectoryUtils.unwrapFSDirectory(fsDirectory);  
        FSDirectory result = DirectoryUtils.unwrapFSDirectory(fsDirectory);
import org.apache.lucene.store.ByteBuffersDirectory;
        assertSame(fsDirectory, result);
    }
 */  
        Path result = DirectoryUtils.getFilePathSwitchable(wrapped, "test_file.si");  
 * Tests for {@link DirectoryUtils}.
 * The OpenSearch Contributors require contributions made to  
    public void testGetFilePathSwitchableWithWrappedDirectory() {  
    @Override
        };
    }  
        super.tearDown();
        assertSame(fsDirectory, result);
        super.setUp();  
        assertTrue(ex.getMessage().contains("Expected FSDirectory but got"));
        fsDirectory = FSDirectory.open(tempDir);
        Directory nonFsDir = new ByteBuffersDirectory();  
        FilterDirectory wrapped = new FilterDirectory(nonFsDir) {
    }  
    public void testGetFilePathWithWrappedDirectory() {  
        fsDirectory.close();
    }
        assertTrue(ex.getMessage().contains("Expected FSDirectory but got"));
    }
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> DirectoryUtils.unwrapFSDirectory(wrapped));  
        FSDirectory result = DirectoryUtils.unwrapFSDirectory(wrapped);  
 *
    }  
    }
        Path result = DirectoryUtils.getFilePath(fsDirectory, "test_file.si");
        FilterDirectory inner = new FilterDirectory(fsDirectory) {  
    }
import org.apache.lucene.store.FSDirectory;  
/**  
        FSDirectory result = DirectoryUtils.unwrapFSDirectory(wrapped);
 * @opensearch.experimental  
    }  
 * SPDX-License-Identifier: Apache-2.0
    public void testUnwrapFSDirectoryWrapped() {  
package org.opensearch.storage.utils;
/*  
    public void setUp() throws Exception {
        FSDirectory result = DirectoryUtils.unwrapFSDirectory(outer);
    public void testGetFilePathSwitchable() {
    }
        assertSame(fsDirectory, result);  
        tempDir = createTempDir();
        Directory nonFsDir = new ByteBuffersDirectory();  
        assertEquals(tempDir.resolve("test_file.si"), result);  
    @Override
 */
        };
}  
        };  
import org.apache.lucene.store.FilterDirectory;
        assertEquals(tempDir.resolve("test_file.si" + DirectoryUtils.SWITCHABLE_PREFIX), result);  
    public void tearDown() throws Exception {  
    public void testUnwrapFSDirectoryAlias() {
        FilterDirectory wrapped = new FilterDirectory(fsDirectory) {
 *
    }
    public void testUnwrapFSDirectorySingleWrapper() {
        FilterDirectory wrapped = new FilterDirectory(fsDirectory) {
        };  
        Path result = DirectoryUtils.getFilePathSwitchable(fsDirectory, "test_file.si");
