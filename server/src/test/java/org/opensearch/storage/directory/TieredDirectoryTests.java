        assertThrows(NoSuchFileException.class, () -> tieredDirectory.openInput(NON_EXISTENT_FILE, IOContext.DEFAULT));
                System.gc();
import java.io.IOException;
    public void testAfterSyncToRemote() throws IOException {
        removeExtraFSFiles();
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
        assertNotNull(fileCache.get(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
        populateData();  
        return () -> {  
        assertEquals(1, (int) fileCache.getRef(getFilePath(localDirectory, fileName)));  
            "_2.cfe",
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
import org.apache.lucene.store.Directory;  
        assertEquals(2, (int) fileCache.getRef(getFilePath(localDirectory, fileName)));
        assertTrue(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_RENAMED)));  
    public void testTieredDirectoryFactory() throws IOException {
        result.close();
        return Arrays.asList(localDirectory.listAll()).contains(name);  
import static org.opensearch.storage.utils.DirectoryUtils.getFilePath;  
        "_x.abc_block_0",
            localDirectory,
    }
    private static final String[] LOCAL_FILES = new String[] {
        assertFalse(existsInTieredDirectory(FILE_PRESENT_LOCALLY));
    private boolean existsInRemoteDirectory(String name) throws IOException {  
    }  
    public void testIndexInputCleanup() throws IOException {
import static org.mockito.Mockito.mock;  
import org.junit.Before;
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
        try {  
import org.opensearch.storage.indexinput.SwitchableIndexInputWrapper;  
        tieredDirectory = new TieredDirectory(
            "_0.cfe",  
            IndexOutput indexOutput = tieredDirectory.createOutput(file, IOContext.DEFAULT);  
import org.apache.lucene.store.IOContext;  
    }  
            "temp_file.tmp" };
    }  
        }
            }  
        assertEquals(1, (int) fileCache.getRef(path));
        createUnclosedClones(indexInput, path);  
        return (SwitchableIndexInput) (((FilterIndexInput) indexInput).getDelegate());
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
 * SPDX-License-Identifier: Apache-2.0
        decRefToZero(path);
        String[] actualFileNames = tieredDirectory.listAll();
        return Arrays.asList(remoteSegmentStoreDirectory.listAll()).contains(name);
            "_x.abc",
        FSDirectory factoryLocalDir = FSDirectory.open(createTempDir());  
    }  
        FileCache factoryFileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, 1);  
    }  
        populateData();
        IndexStorePlugin.DirectoryFactory localDirFactory = mock(IndexStorePlugin.DirectoryFactory.class);
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));  
            fileCache,
        assertTrue(existsInLocalDirectory(fileName));
        assertFalse(existsInLocalDirectory(fileName));
    }
        assertTrue(getSwitchableIndexInputFromWrapper(indexInput).isCachedFromRemote());
        assertFalse(getSwitchableIndexInputFromWrapper(indexInput).isCachedFromRemote());
        assertEquals(0, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
        "temp_file.tmp" };  
    }
            return settings;
        IndexInput indexInput = tieredDirectory.openInput(fileName, IOContext.DEFAULT);  
    private static final String FILE_PRESENT_LOCALLY = "_1.cfe";
        try {  
import java.util.HashSet;
        assertTrue(existsInTieredDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
    public void testRename() throws IOException {  
    private void addFilesToDirectory(String[] files) throws IOException {
        assertFalse(existsInTieredDirectory(NON_EXISTENT_FILE));
import org.opensearch.index.store.remote.utils.FileTypeUtils;  
        assertFalse(existsInTieredDirectory(FILE_PRESENT_LOCALLY));  
        setupRemoteSegmentStoreDirectory();  
            assertBusy(() -> {
        "_1.cfe_block_0",  
        assertFalse(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_RENAMED)));
        IndexInput cloneOfClone = clone.clone();
        assertEquals(0, (int) fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
import org.opensearch.index.store.remote.filecache.FileCache;
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
            threadPool,
        for (int i = 0; i < refCount; i++) {  
        } catch (Exception e) {
            } catch (IOException e) {
        assertEquals(
    private boolean existsInLocalDirectory(String name) throws IOException {
        assertEquals(2, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));  
        assertTrue(result instanceof TieredDirectory);  
        populateData();
 *
package org.opensearch.storage.directory;
        allFiles.stream().filter(FileTypeUtils::isExtraFSFile).forEach(file -> {
        for (String file : files) {
    }
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);
        "_0.cfe_block_7",  
        assertTrue(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        assertFalse(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
                assertEquals("Expected refCount to drop to original count", (int) fileCache.getRef(path), 0);  
            fileCache.decRef(path);
import java.nio.file.NoSuchFileException;
            getMockPrefetchSettingsSupplier()  
        assertFalse(getSwitchableIndexInputFromWrapper(indexInput).isCachedFromRemote());
    private static final String TEMP_FILE = "temp_file.tmp";
/*  
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileName)));
import java.util.function.Supplier;
        assertTrue(existsInLocalDirectory(TEMP_FILE) && FileTypeUtils.isTempFile(TEMP_FILE));  
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        addFilesToDirectory(LOCAL_FILES);
        assertEquals(1, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
    private void triggerGarbageCollectionAndAssertClonesClosed(Path path) {
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);
        });
    }
        assertTrue(existsInTieredDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
import java.util.Arrays;
        assertNull(fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
        };  
        );
    }  
        indexInput = tieredDirectory.openInput(fileName, IOContext.DEFAULT);
        "_1.cfe_block_1",
        String fileNameBlock = "_0.si_block_0";
    }  
                localDirectory.deleteFile(file);  
        tieredDirectory.deleteFile(FILE_PRESENT_LOCALLY);
        assertNotNull(indexInput);  
        assertEquals(1, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));  
    public void testOpenInput() throws IOException {  
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {
        IndexInput indexInput = tieredDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT);
import org.opensearch.storage.indexinput.SwitchableIndexInput;
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(existsInTieredDirectory(TEMP_FILE));
        return (fileCache.get(path) != null);  
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);
        }
        IndexInput indexInput = tieredDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT);  
/**  
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);  
        HashSet<String> allFiles = new HashSet<>(Arrays.asList(localDirectory.listAll()));  
    }  
            indexOutput.close();
    private SwitchableIndexInput getSwitchableIndexInputFromWrapper(IndexInput indexInput) {
        assertFalse(existsInTieredDirectory(NON_EXISTENT_FILE));  
        remoteSegmentStoreDirectory.init();
import java.nio.file.Path;  
 * compatible open source license.
        }
        assertNotNull(indexInput);  
import org.apache.lucene.store.IndexOutput;
            logger.error("Exception thrown while triggering gc", e);  
        Exception exception = null;
    }
    private static final String NON_EXISTENT_FILE = "non_existent_file";
        assertTrue(existsInTieredDirectory(FILE_PRESENT_LOCALLY));
        indexInput.close();
            "_0.si",
        assertTrue(existsInTieredDirectory(FILE_PRESENT_LOCALLY));  
            tieredDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString(),  
            localDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString()
    }
        assertEquals(0, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));  
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));  
            fail();
    }  
    private static final String FILE_PRESENT_IN_REMOTE_ONLY = "_0.si";  
    private boolean existsInTieredDirectory(String name) throws IOException {
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);  
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
    private static final String FILE_RENAMED = "_1_new.cfe";
import org.opensearch.plugins.IndexStorePlugin;
 */  
            exception = e;  
    }
import org.apache.lucene.store.FilterIndexInput;
    public void testListAll() throws IOException {  
 * Tests for {@link TieredDirectory}.
        }
        );
        assertEquals(2, (int) fileCache.getRef(path));
        "_1.cfe",
    private boolean existsInFileCache(Path path) {
        tieredDirectory.deleteFile(TEMP_FILE);
        assertNull(fileCache.get(getFilePathSwitchable(localDirectory, FILE_PRESENT_IN_REMOTE_ONLY)));
import org.apache.lucene.store.FSDirectory;
        IndexInput clone = indexInput.clone();  
        indexInput.close();
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);  
        Path path = getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY);
    public void setup() throws IOException {
    private void decRefToZero(Path path) {
        Directory result = factory.newDirectory(null, null, localDirFactory, remoteSegmentStoreDirectory, factoryFileCache, threadPool);
}
                throw new RuntimeException(e);
    private void createUnclosedClones(IndexInput indexInput, Path path) {
        triggerGarbageCollectionAndAssertClonesClosed(path);
            "_1.cfe",  
            "_0.cfs",
        assertThrows(NoSuchFileException.class, () -> tieredDirectory.rename(NON_EXISTENT_FILE, FILE_RENAMED));
        fileCache.prune();  
        tieredDirectory.deleteFile(FILE_PRESENT_IN_REMOTE_ONLY);
    private FSDirectory localDirectory;
    public void testDeleteFile() throws IOException {
import static org.mockito.ArgumentMatchers.any;
        return Arrays.asList(tieredDirectory.listAll()).contains(name);
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    private TieredDirectory tieredDirectory;
        int concurrencyLevel = randomIntBetween(1, 2);
        addFilesToDirectory(new String[] { fileName });
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));  
        assertTrue(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));  
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to  
        String fileName = "_0.si";  
        assertEquals(1, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
        } catch (Exception e) {
        assertFalse(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
    @Before
        indexInput = tieredDirectory.openInput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT);
        when(localDirFactory.newDirectory(any(), any())).thenReturn(factoryLocalDir);
        "_0.cfs_block_7",
import org.apache.lucene.store.IndexInput;
        assertEquals(1, (int) fileCache.getRef(getFilePath(localDirectory, fileName)));
        assertArrayEquals(expectedFileNames, actualFileNames);
        assertEquals(1, (int) fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
        TieredDirectoryFactory factory = new TieredDirectoryFactory(getMockPrefetchSettingsSupplier());
        populateMetadata();
        assertNull(exception);
            "segments_1",  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
    private void removeExtraFSFiles() throws IOException {
import java.util.concurrent.TimeUnit;  
        assertTrue(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
        tieredDirectory.rename(FILE_PRESENT_LOCALLY, FILE_RENAMED);  
        String[] expectedFileNames = new String[] {
        "_2.cfe",
        assertTrue(existsInFileCache(getFilePath(localDirectory, FILE_PRESENT_LOCALLY)));
        assertTrue(existsInTieredDirectory(TEMP_FILE));  
 */
        assertEquals(2, (int) fileCache.getRef(path));
public class TieredDirectoryTests extends TieredStorageBaseTestCase {
        assertTrue(existsInRemoteDirectory(fileName));  
        int refCount = fileCache.getRef(path);
    }
            tieredDirectory.deleteFile(NON_EXISTENT_FILE);
            }, 5, TimeUnit.SECONDS);
    private FileCache fileCache;  
            try {
            remoteSegmentStoreDirectory,  
        assertFalse(existsInFileCache(getFilePath(localDirectory, FILE_PRESENT_LOCALLY)));  
        tieredDirectory.afterSyncToRemote(fileName);  
        localDirectory = FSDirectory.open(createTempDir());  
        assertFalse(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
