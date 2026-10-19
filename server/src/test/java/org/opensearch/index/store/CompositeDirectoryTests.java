 *
        assertNotNull(input);
        indexInput.getFilePointer();
import java.util.Collection;
        compositeDirectory = new CompositeDirectory(localDirectory, remoteSegmentStoreDirectory, fileCache, threadPool);  
            assertNull(fileCache.get(localDirectory.getDirectory().resolve(NEW_FILE)));
        // Use FILE_PRESENT_LOCALLY ("_1.cfe") which is already set up locally
        assertThrows(AlreadyClosedException.class, () -> compositeDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT));
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.fileLength(NON_EXISTENT_FILE));
import java.util.Arrays;  
        String[] actualFileNames = compositeDirectory.listAll();  
    }
    }
    public void testCreateOutput() throws IOException {
    }
    }
        String[] actualFileNames = compositeDirectory.listAll();
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        indexInput.close();
        compositeDirectory.sync(List.of("_1.cfe"));
    }
        // File not present in both local and remote  
        compositeDirectory.close();  
        assertTrue(existsInLocalDirectory(BLOCK_FILE_PRESENT_LOCALLY));
        allFiles.stream().filter(FileTypeUtils::isExtraFSFile).forEach(file -> {  
        assertFalse(existsInCompositeDirectory(NON_EXISTENT_FILE));  
                throw new RuntimeException(e);
        Collection<String> names = List.of("_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_1");
        // Should still be able to open input, now from remote  
        );
 * The OpenSearch Contributors require contributions made to  
        fileCache.put(key, restoredCachedIndexInput);  
        try (IndexOutput indexOutput = compositeDirectory.createOutput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT)) {
        assertTrue(existsInLocalDirectory(TEMP_FILE) && FileTypeUtils.isTempFile(TEMP_FILE));
        assertEquals(compositeDirectory.fileLength(FILE_PRESENT_LOCALLY), localDirectory.fileLength(FILE_PRESENT_LOCALLY));
        "_1.cfe_block_0",
}  
        Path filePath = getFilePath(NEW_FILE);
        // served
    public void testFileLength() throws IOException {
        // File present in file cache
import org.apache.lucene.store.FSDirectory;
    }  
public class CompositeDirectoryTests extends BaseRemoteSegmentStoreDirectoryTests {  
import java.util.List;  
        compositeDirectory.deleteFile("_1.cfe");
    public void testSync() throws IOException {
        assertFalse(existsInRemoteDirectory(FILE_PRESENT_LOCALLY));
        "_0.cfe_block_7",
        }
            }
        assertNotNull(fileCache.get(localDirectory.getDirectory().resolve(NEW_FILE)));
    private final static String BLOCK_FILE_PRESENT_LOCALLY = "_1.cfe_block_0";
    private final static String LOCAL_SEGMENT_FILE = "segments_2";
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.rename(NON_EXISTENT_FILE, "_1_new.cfe"));
        // Below list contains a non-existent file, hence will throw an error  
    }  
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY);
    public void testOpenInputAfterFileCacheEviction() throws IOException {  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        // File will be present locally until uploaded to Remote
            exception = e;
    public void testOpenInputWithClosedCachedInput() throws Exception {  
        "_0.cfs_block_7",
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
        // Clear the file cache  
        assertThrows(RuntimeException.class, indexInput::getFilePointer);  
        // Should throw error for file not present  
        // File present locally
        compositeDirectory.rename(FILE_PRESENT_LOCALLY, "_1_new.cfe");
    private Path getFilePath(String name) {  
        IndexInput input = compositeDirectory.openInput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT);
    public void testListAll_withLocalSegmentFiles() throws IOException {
        // Existing open IndexInputs will be served  
import org.apache.lucene.store.IOContext;
        // Temp file, read directly form local directory  
            // File not present in FileCache until the indexOutput is Closed
        return Arrays.asList(localDirectory.listAll()).contains(name);
    }  
        Exception exception = null;
    private FSDirectory localDirectory;
        setupRemoteSegmentStoreDirectory();  
        assertTrue(input instanceof FileCachedIndexInput);
import org.opensearch.index.store.remote.filecache.FileCache;
import org.opensearch.index.store.remote.filecache.FileCachedIndexInput;
    @Before
        assertTrue(existsInLocalDirectory(FILE_PRESENT_LOCALLY));  
    public void testOpenInput() throws IOException {
    }  
        assertTrue(existsInCompositeDirectory(FILE_PRESENT_LOCALLY));  
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assertThrows(IOException.class, () -> compositeDirectory.openInput(NEW_FILE, IOContext.DEFAULT));  
            compositeDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString(),  
        Path key = getFilePath(NEW_FILE);
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        try (IndexOutput indexOutput = compositeDirectory.createOutput(NEW_FILE, IOContext.DEFAULT)) {
    }
        assertNull(fileCache.get(getFilePath(FILE_PRESENT_LOCALLY)));  
                localDirectory.deleteFile(file);
        addFilesToDirectory(LOCAL_FILES);
        removeExtraFSFiles();
import java.util.HashSet;
        fileCache.prune();
    private boolean existsInLocalDirectory(String name) throws IOException {  
        assertEquals(
import java.nio.file.NoSuchFileException;
        }
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));  
    private final static String NEW_FILE = "new_file";
    private FileCache fileCache;
    }
            remoteSegmentStoreDirectory.fileLength(FILE_PRESENT_IN_REMOTE_ONLY)  
        );
        // Similar to delete, when close is called existing openInput should be able to function properly but new requests should not be  
        // State of _1.cfe file after these operations - not present in remote, full file not present locally but blocks present in local
    public void testRename() throws IOException {
        // After uploading to Remote, refCount will be decreased by 1 making it 0 and will be evicted if cache is pruned  
        // Rename should work as expected for file present in directory  
package org.opensearch.index.store;
        }
    private void removeExtraFSFiles() throws IOException {
        assertFalse(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
        }  
import org.junit.Before;
        assertTrue(existsInCompositeDirectory(FILE_PRESENT_LOCALLY));
        // replace the original index input with RestoredCachedIndexInput
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.openInput(NON_EXISTENT_FILE, IOContext.DEFAULT));
    private final static String TEMP_FILE = "temp_file.tmp";  
        // File not present in Directory
import org.apache.lucene.store.AlreadyClosedException;  
import org.opensearch.index.store.remote.filecache.FileCache.RestoredCachedIndexInput;  
        addFilesToDirectory(new String[] { LOCAL_SEGMENT_FILE });
        assertFalse(existsInCompositeDirectory(BLOCK_FILE_PRESENT_LOCALLY));
        assertFalse(existsInLocalDirectory(FILE_PRESENT_IN_REMOTE_ONLY));  
    }
import org.opensearch.index.store.remote.utils.FileTypeUtils;  
            IndexOutput indexOutput = compositeDirectory.createOutput(file, IOContext.DEFAULT);
        assertNull(exception);
        remoteSegmentStoreDirectory.init();
            indexOutput.writeString("test data");  
        assertFalse(Arrays.asList(compositeDirectory.listAll()).contains(NON_EXISTENT_FILE));
    public void setup() throws IOException {
    private boolean existsInCompositeDirectory(String name) throws IOException {
        }
        // Get the cached input and close it  
        return Arrays.asList(compositeDirectory.listAll()).contains(name);  
        assertArrayEquals(expectedFileNames, actualFileNames);
        // All the files in the below list are present either locally or on remote, so sync should work as expected  
        assertTrue(input instanceof OnDemandBlockSnapshotIndexInput);  
        try (IndexOutput indexOutput = compositeDirectory.createOutput(NEW_FILE, IOContext.DEFAULT)) {  
        for (String file : files) {
        // Deletion of non-existent file should fail silently without throwing any error  
        assertEquals(
        // Corrupt the local file to cause IOException  
        IndexInput input = compositeDirectory.openInput(NEW_FILE, IOContext.DEFAULT);  
    }  
        HashSet<String> allFiles = new HashSet<>(Arrays.asList(localDirectory.listAll()));
        assertNotNull(input);
        "_1.cfe",  
        "_1.cfe_block_1",
        fileCache.clear();
        // Any operations after close will throw AlreadyClosedException
        // Verify that we can still open the file and get a valid input
        assertFalse(existsInCompositeDirectory(FILE_PRESENT_LOCALLY));
    public void testDeleteFile() throws IOException {
        assertNotNull(fileCache.get(getFilePath(FILE_PRESENT_LOCALLY)));
        input.close();  
        String[] expectedFileNames = new String[] { "_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_2", "temp_file.tmp" };
    private boolean existsInRemoteDirectory(String name) throws IOException {
        // File present in FileCache after the indexOutput is Closed
import java.io.IOException;  
        assertFalse(existsInLocalDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
    }
            indexOutput.writeString("test data");  
        populateMetadata();
        cachedInput.close();
        Collection<String> names1 = List.of("_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_1", "non_existent_file");
            compositeDirectory.deleteFile(NON_EXISTENT_FILE);  
/*  
        "_2.cfe",  
        CachedIndexInput cachedInput = fileCache.get(key);  
        RestoredCachedIndexInput restoredCachedIndexInput = new RestoredCachedIndexInput(0);
        assertTrue(compositeDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT) instanceof FileCachedIndexInput);  
        } catch (Exception e) {
        }  
        try {
import org.apache.lucene.store.IndexInput;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.store.IndexOutput;
            compositeDirectory.fileLength(FILE_PRESENT_IN_REMOTE_ONLY),
        String[] expectedFileNames = new String[] { "_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_1", "temp_file.tmp" };  
        // Sync should work as expected since blocks are present in local
            } catch (IOException e) {  
    public void testClose() throws IOException {
        // Deleting file _1.cfe and then adding its blocks locally so that full file is not present but block files are present in local  
        assertTrue(existsInLocalDirectory(FILE_PRESENT_LOCALLY));  
    private final static String FILE_PRESENT_IN_REMOTE_ONLY = "_0.si";  
        IndexInput indexInput = compositeDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT);
        compositeDirectory.afterSyncToRemote(FILE_PRESENT_LOCALLY);
        addFilesToDirectory(new String[] { "_1.cfe_block_0", "_1.cfe_block_2" });  
        compositeDirectory.sync(names);
    private CompositeDirectory compositeDirectory;  
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
        compositeDirectory.deleteFile(FILE_PRESENT_LOCALLY);  
    private final static String NON_EXISTENT_FILE = "non_existent_file";
 * SPDX-License-Identifier: Apache-2.0
        input.close();
 */  
        try (IndexOutput output = localDirectory.createOutput(NEW_FILE, IOContext.DEFAULT)) {
        // First create and cache the file locally
            localDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString()
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.sync(names1));
    private final static int FILE_CACHE_CAPACITY = 10000;
    public void testAfterSyncToRemote() throws IOException {
    }
    private final static String FILE_PRESENT_LOCALLY = "_1.cfe";
        assertThrows(AlreadyClosedException.class, () -> compositeDirectory.close());
        // File not present locally - present in Remote
        "temp_file.tmp" };  
        return localDirectory.getDirectory().resolve(name);
        // Delete the file and assert that it no more is a part of the directory
        localDirectory = FSDirectory.open(createTempDir());  
    }
    private final static String[] LOCAL_FILES = new String[] {
        // Asserting file is not present in FileCache
    }
 * compatible open source license.
        assertTrue(compositeDirectory.openInput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT) instanceof OnDemandBlockSnapshotIndexInput);
    private void addFilesToDirectory(String[] files) throws IOException {  
    }  
        });  
    }
    public void testListAll() throws IOException {
        // File present in Remote
        // Setup: Create a file and get it into cache
import java.nio.file.Path;
            output.writeString("corrupted data");  
            try {
        assertArrayEquals(expectedFileNames, actualFileNames);
            indexOutput.close();  
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;  
    public void testOpenInputThrowsIOException() throws IOException {
        return Arrays.asList(remoteSegmentStoreDirectory.listAll()).contains(name);
