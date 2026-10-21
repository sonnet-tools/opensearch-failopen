    public void testDeleteFile() throws IOException {
import java.util.HashSet;
        fileCache.clear();
        removeExtraFSFiles();
        assertNotNull(fileCache.get(getFilePath(FILE_PRESENT_LOCALLY)));
        assertFalse(existsInRemoteDirectory(FILE_PRESENT_LOCALLY));
    private FileCache fileCache;
        fileCache.prune();
    public void setup() throws IOException {
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
 * The OpenSearch Contributors require contributions made to
    }
    }
    }
        assertThrows(IOException.class, () -> compositeDirectory.openInput(NEW_FILE, IOContext.DEFAULT));
        // File not present in Directory
        try (IndexOutput indexOutput = compositeDirectory.createOutput(NEW_FILE, IOContext.DEFAULT)) {
        // File present in Remote
    private boolean existsInLocalDirectory(String name) throws IOException {
        // Sync should work as expected since blocks are present in local
        assertTrue(compositeDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT) instanceof FileCachedIndexInput);
        assertFalse(existsInLocalDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
        assertTrue(input instanceof OnDemandBlockSnapshotIndexInput);
        assertTrue(existsInLocalDirectory(BLOCK_FILE_PRESENT_LOCALLY));
    private void addFilesToDirectory(String[] files) throws IOException {
public class CompositeDirectoryTests extends BaseRemoteSegmentStoreDirectoryTests {
    }
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.fileLength(NON_EXISTENT_FILE));
        "_1.cfe_block_0",
        "temp_file.tmp" };
    public void testOpenInput() throws IOException {
    private final static String NEW_FILE = "new_file";
        // After uploading to Remote, refCount will be decreased by 1 making it 0 and will be evicted if cache is pruned
    }
        // File not present locally - present in Remote
    private final static String TEMP_FILE = "temp_file.tmp";
        remoteSegmentStoreDirectory.init();
        compositeDirectory = new CompositeDirectory(localDirectory, remoteSegmentStoreDirectory, fileCache, threadPool);
import org.apache.lucene.store.IndexInput;
    public void testRename() throws IOException {
        assertNotNull(fileCache.get(localDirectory.getDirectory().resolve(NEW_FILE)));
        String[] actualFileNames = compositeDirectory.listAll();
        }
        assertFalse(existsInCompositeDirectory(BLOCK_FILE_PRESENT_LOCALLY));
import org.apache.lucene.store.FSDirectory;
 * compatible open source license.
        indexInput.close();
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
    private final static String FILE_PRESENT_IN_REMOTE_ONLY = "_0.si";
        localDirectory = FSDirectory.open(createTempDir());
    public void testOpenInputAfterFileCacheEviction() throws IOException {
    }
    private final static String[] LOCAL_FILES = new String[] {
        for (String file : files) {
        addFilesToDirectory(new String[] { "_1.cfe_block_0", "_1.cfe_block_2" });
    private boolean existsInCompositeDirectory(String name) throws IOException {
    private final static String FILE_PRESENT_LOCALLY = "_1.cfe";
        Path key = getFilePath(NEW_FILE);
        HashSet<String> allFiles = new HashSet<>(Arrays.asList(localDirectory.listAll()));
        String[] actualFileNames = compositeDirectory.listAll();
        // replace the original index input with RestoredCachedIndexInput
    }
            indexOutput.writeString("test data");
        "_2.cfe",
        fileCache.put(key, restoredCachedIndexInput);
        // All the files in the below list are present either locally or on remote, so sync should work as expected
        assertThrows(RuntimeException.class, indexInput::getFilePointer);
        compositeDirectory.deleteFile("_1.cfe");
            localDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString()
        // Any operations after close will throw AlreadyClosedException
}
        "_1.cfe",
        IndexInput input = compositeDirectory.openInput(NEW_FILE, IOContext.DEFAULT);
import org.apache.lucene.store.IOContext;
            compositeDirectory.deleteFile(NON_EXISTENT_FILE);
import org.opensearch.index.store.remote.filecache.FileCache.RestoredCachedIndexInput;
    private final static int FILE_CACHE_CAPACITY = 10000;
        // Use FILE_PRESENT_LOCALLY ("_1.cfe") which is already set up locally
        assertEquals(
            assertNull(fileCache.get(localDirectory.getDirectory().resolve(NEW_FILE)));
        allFiles.stream().filter(FileTypeUtils::isExtraFSFile).forEach(file -> {
        Collection<String> names = List.of("_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_1");
import java.util.Collection;
        try (IndexOutput indexOutput = compositeDirectory.createOutput(NEW_FILE, IOContext.DEFAULT)) {
import org.junit.Before;
        assertTrue(input instanceof FileCachedIndexInput);
    }
        // Should throw error for file not present
        assertNotNull(input);
    public void testListAll_withLocalSegmentFiles() throws IOException {
        addFilesToDirectory(new String[] { LOCAL_SEGMENT_FILE });
        String[] expectedFileNames = new String[] { "_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_2", "temp_file.tmp" };
    }
        return Arrays.asList(remoteSegmentStoreDirectory.listAll()).contains(name);
        });
            IndexOutput indexOutput = compositeDirectory.createOutput(file, IOContext.DEFAULT);
        assertFalse(existsInLocalDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
    }
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
 * this file be licensed under the Apache-2.0 license or a
        // Get the cached input and close it
        // State of _1.cfe file after these operations - not present in remote, full file not present locally but blocks present in local
        assertEquals(compositeDirectory.fileLength(FILE_PRESENT_LOCALLY), localDirectory.fileLength(FILE_PRESENT_LOCALLY));
        assertFalse(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
            }
    public void testOpenInputThrowsIOException() throws IOException {
        "_0.cfe_block_7",
        IndexInput indexInput = compositeDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT);
        // Similar to delete, when close is called existing openInput should be able to function properly but new requests should not be
            indexOutput.close();
        }
import java.nio.file.Path;
import org.opensearch.index.store.remote.filecache.FileCachedIndexInput;
                throw new RuntimeException(e);
        assertFalse(existsInCompositeDirectory(NON_EXISTENT_FILE));
    public void testClose() throws IOException {
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
import org.apache.lucene.store.IndexOutput;
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
    }
        // Asserting file is not present in FileCache
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        }
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY);
        }
        populateMetadata();
            remoteSegmentStoreDirectory.fileLength(FILE_PRESENT_IN_REMOTE_ONLY)
import org.opensearch.index.store.remote.utils.FileTypeUtils;
            try {
            compositeDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString(),
        assertFalse(existsInCompositeDirectory(FILE_PRESENT_LOCALLY));
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.sync(names1));
    private boolean existsInRemoteDirectory(String name) throws IOException {
        // Existing open IndexInputs will be served
            indexOutput.writeString("test data");
    public void testCreateOutput() throws IOException {
        return Arrays.asList(localDirectory.listAll()).contains(name);
            output.writeString("corrupted data");
        assertTrue(existsInLocalDirectory(TEMP_FILE) && FileTypeUtils.isTempFile(TEMP_FILE));
        input.close();
        // Delete the file and assert that it no more is a part of the directory
import java.nio.file.NoSuchFileException;
        // Rename should work as expected for file present in directory
        assertTrue(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
    }
        compositeDirectory.sync(names);
        compositeDirectory.sync(List.of("_1.cfe"));
        CachedIndexInput cachedInput = fileCache.get(key);
        assertTrue(existsInCompositeDirectory(FILE_PRESENT_LOCALLY));
        }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        // File present locally
    private FSDirectory localDirectory;
        RestoredCachedIndexInput restoredCachedIndexInput = new RestoredCachedIndexInput(0);
        // Corrupt the local file to cause IOException
        // Deleting file _1.cfe and then adding its blocks locally so that full file is not present but block files are present in local
    private final static String NON_EXISTENT_FILE = "non_existent_file";
        } catch (Exception e) {
        try (IndexOutput output = localDirectory.createOutput(NEW_FILE, IOContext.DEFAULT)) {
        );
        // Temp file, read directly form local directory
        setupRemoteSegmentStoreDirectory();
            } catch (IOException e) {
import org.apache.lucene.store.AlreadyClosedException;
        cachedInput.close();
    private final static String LOCAL_SEGMENT_FILE = "segments_2";
        addFilesToDirectory(LOCAL_FILES);
/*
    }
        // File present in FileCache after the indexOutput is Closed
    public void testOpenInputWithClosedCachedInput() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.rename(NON_EXISTENT_FILE, "_1_new.cfe"));
            compositeDirectory.fileLength(FILE_PRESENT_IN_REMOTE_ONLY),
    private Path getFilePath(String name) {
        assertThrows(NoSuchFileException.class, () -> compositeDirectory.openInput(NON_EXISTENT_FILE, IOContext.DEFAULT));
        assertThrows(AlreadyClosedException.class, () -> compositeDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT));
import org.opensearch.index.store.remote.filecache.FileCache;
        assertArrayEquals(expectedFileNames, actualFileNames);
        // Should still be able to open input, now from remote
        assertArrayEquals(expectedFileNames, actualFileNames);
    public void testFileLength() throws IOException {
        try {
import java.util.Arrays;
        assertNull(fileCache.get(getFilePath(FILE_PRESENT_LOCALLY)));
        assertNull(exception);
import java.io.IOException;
                localDirectory.deleteFile(file);
import java.util.List;
 *
        // Verify that we can still open the file and get a valid input
        compositeDirectory.afterSyncToRemote(FILE_PRESENT_LOCALLY);
        Path filePath = getFilePath(NEW_FILE);
        // served
    }
        return localDirectory.getDirectory().resolve(name);
package org.opensearch.index.store;
    }
        indexInput.getFilePointer();
        "_0.cfs_block_7",
        // Setup: Create a file and get it into cache
    @Before
        compositeDirectory.deleteFile(FILE_PRESENT_LOCALLY);
        assertEquals(
    public void testListAll() throws IOException {
            exception = e;
        Collection<String> names1 = List.of("_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_1", "non_existent_file");
        input.close();
        compositeDirectory.close();
    }
        "_1.cfe_block_1",
        // First create and cache the file locally
        try (IndexOutput indexOutput = compositeDirectory.createOutput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT)) {
    }
 */
            // File not present in FileCache until the indexOutput is Closed
        String[] expectedFileNames = new String[] { "_0.cfe", "_0.cfs", "_0.si", "_1.cfe", "_2.cfe", "segments_1", "temp_file.tmp" };
    private final static String BLOCK_FILE_PRESENT_LOCALLY = "_1.cfe_block_0";
        // Below list contains a non-existent file, hence will throw an error
        assertTrue(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
        // File will be present locally until uploaded to Remote
        compositeDirectory.rename(FILE_PRESENT_LOCALLY, "_1_new.cfe");
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
        assertTrue(compositeDirectory.openInput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT) instanceof OnDemandBlockSnapshotIndexInput);
    public void testAfterSyncToRemote() throws IOException {
        IndexInput input = compositeDirectory.openInput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT);
        // File present in file cache
    }
    }
        );
        assertThrows(AlreadyClosedException.class, () -> compositeDirectory.close());
    private CompositeDirectory compositeDirectory;
    private void removeExtraFSFiles() throws IOException {
        }
        // File not present in both local and remote
        assertTrue(existsInCompositeDirectory(FILE_PRESENT_LOCALLY));
        assertFalse(Arrays.asList(compositeDirectory.listAll()).contains(NON_EXISTENT_FILE));
        Exception exception = null;
        // Clear the file cache
        return Arrays.asList(compositeDirectory.listAll()).contains(name);
    public void testSync() throws IOException {
        // Deletion of non-existent file should fail silently without throwing any error
    }
        assertNotNull(input);
