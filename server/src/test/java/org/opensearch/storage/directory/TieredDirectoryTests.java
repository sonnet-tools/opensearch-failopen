                throw new RuntimeException(e);
        assertFalse(existsInTieredDirectory(NON_EXISTENT_FILE));
        addFilesToDirectory(new String[] { fileName });
        TieredDirectoryFactory factory = new TieredDirectoryFactory(getMockPrefetchSettingsSupplier());
import org.apache.lucene.store.IndexOutput;
        assertFalse(existsInLocalDirectory(fileName));
        );
        assertFalse(getSwitchableIndexInputFromWrapper(indexInput).isCachedFromRemote());
        IndexInput indexInput = tieredDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT);
 * Tests for {@link TieredDirectory}.
        assertNull(exception);
    private TieredDirectory tieredDirectory;
 * The OpenSearch Contributors require contributions made to
import java.util.HashSet;
        tieredDirectory.rename(FILE_PRESENT_LOCALLY, FILE_RENAMED);
            tieredDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString(),
        assertTrue(existsInTieredDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
import org.apache.lucene.store.FSDirectory;
    public void testListAll() throws IOException {
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
        assertNotNull(fileCache.get(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
        assertNotNull(indexInput);
import org.junit.Before;
            exception = e;
            }
        assertEquals(0, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
            remoteSegmentStoreDirectory,
        assertTrue(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
    private void createUnclosedClones(IndexInput indexInput, Path path) {
    }
        return (fileCache.get(path) != null);
import org.apache.lucene.store.IOContext;
        assertFalse(existsInTieredDirectory(NON_EXISTENT_FILE));
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
public class TieredDirectoryTests extends TieredStorageBaseTestCase {
        fileCache.prune();
            "_x.abc",
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);
    public void testIndexInputCleanup() throws IOException {
            "_0.si",
            tieredDirectory.deleteFile(NON_EXISTENT_FILE);
        assertTrue(existsInLocalDirectory(fileName));
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import java.nio.file.NoSuchFileException;
        assertFalse(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
            getMockPrefetchSettingsSupplier()
        Exception exception = null;
        IndexInput cloneOfClone = clone.clone();
        IndexInput indexInput = tieredDirectory.openInput(FILE_PRESENT_LOCALLY, IOContext.DEFAULT);
        "_1.cfe",
            return settings;
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
        assertEquals(2, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
        assertThrows(NoSuchFileException.class, () -> tieredDirectory.rename(NON_EXISTENT_FILE, FILE_RENAMED));
    }
    private SwitchableIndexInput getSwitchableIndexInputFromWrapper(IndexInput indexInput) {
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);
    }
        }
        assertArrayEquals(expectedFileNames, actualFileNames);
import static org.mockito.Mockito.mock;
    }
            assertBusy(() -> {
                assertEquals("Expected refCount to drop to original count", (int) fileCache.getRef(path), 0);
        }
        assertEquals(1, (int) fileCache.getRef(path));
    public void testDeleteFile() throws IOException {
        assertEquals(2, (int) fileCache.getRef(path));
 */
        String[] actualFileNames = tieredDirectory.listAll();
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileName)));
        populateData();
                localDirectory.deleteFile(file);
            "segments_1",
import org.apache.lucene.store.IndexInput;
        "_1.cfe_block_0",
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
        for (int i = 0; i < refCount; i++) {
        assertNull(fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
import static org.mockito.Mockito.when;
    private FileCache fileCache;
        triggerGarbageCollectionAndAssertClonesClosed(path);
import java.util.function.Supplier;
 * SPDX-License-Identifier: Apache-2.0
            "_0.cfs",
import java.io.IOException;
        int refCount = fileCache.getRef(path);
        Path path = getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY);
    }
        tieredDirectory.deleteFile(FILE_PRESENT_LOCALLY);
        tieredDirectory.afterSyncToRemote(fileName);
        indexInput.close();
 * this file be licensed under the Apache-2.0 license or a
    private boolean existsInRemoteDirectory(String name) throws IOException {
    @Before
import org.opensearch.storage.indexinput.SwitchableIndexInputWrapper;
        for (String file : files) {
import static org.mockito.ArgumentMatchers.any;
        assertEquals(2, (int) fileCache.getRef(getFilePath(localDirectory, fileName)));
        "temp_file.tmp" };
        FileCache factoryFileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, 1);
        localDirectory = FSDirectory.open(createTempDir());
        return (SwitchableIndexInput) (((FilterIndexInput) indexInput).getDelegate());
        assertFalse(existsInFileCache(getFilePath(localDirectory, FILE_PRESENT_LOCALLY)));
import org.opensearch.index.store.remote.filecache.FileCache;
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            logger.error("Exception thrown while triggering gc", e);
    private static final String[] LOCAL_FILES = new String[] {
                System.gc();
        assertTrue(result instanceof TieredDirectory);
            fileCache.decRef(path);
        assertFalse(existsInTieredDirectory(FILE_PRESENT_LOCALLY));
    }
    }
        int concurrencyLevel = randomIntBetween(1, 2);
    }
        assertTrue(existsInTieredDirectory(FILE_PRESENT_LOCALLY));
        assertEquals(1, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
            IndexOutput indexOutput = tieredDirectory.createOutput(file, IOContext.DEFAULT);
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);
        assertFalse(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
        assertTrue(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_RENAMED)));
    }
        assertEquals(1, (int) fileCache.getRef(getFilePath(localDirectory, fileName)));
    private static final String NON_EXISTENT_FILE = "non_existent_file";
        assertTrue(existsInLocalDirectory(TEMP_FILE) && FileTypeUtils.isTempFile(TEMP_FILE));
        assertFalse(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_RENAMED)));
    private void triggerGarbageCollectionAndAssertClonesClosed(Path path) {
    private static final String TEMP_FILE = "temp_file.tmp";
    }
        setupRemoteSegmentStoreDirectory();
        populateMetadata();
        IndexInput indexInput = tieredDirectory.openInput(fileName, IOContext.DEFAULT);
 *
    private boolean existsInFileCache(Path path) {
        HashSet<String> allFiles = new HashSet<>(Arrays.asList(localDirectory.listAll()));
        assertEquals(
        result.close();
import java.util.Arrays;
    public void testAfterSyncToRemote() throws IOException {
import static org.opensearch.storage.utils.DirectoryUtils.getFilePath;
        assertTrue(existsInRemoteDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
        tieredDirectory = new TieredDirectory(
}
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        assertTrue(existsInTieredDirectory(FILE_PRESENT_LOCALLY));
        assertTrue(existsInTieredDirectory(TEMP_FILE));
    public void testTieredDirectoryFactory() throws IOException {
        assertTrue(getSwitchableIndexInputFromWrapper(indexInput).isCachedFromRemote());
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
            localDirectory.openInput(TEMP_FILE, IOContext.DEFAULT).toString()
        );
import org.opensearch.plugins.IndexStorePlugin;
    public void setup() throws IOException {
import org.apache.lucene.store.Directory;
    private void decRefToZero(Path path) {
            indexOutput.close();
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
 * compatible open source license.
        return Arrays.asList(localDirectory.listAll()).contains(name);
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
            fileCache,
        "_x.abc_block_0",
            localDirectory,
        assertEquals(0, (int) fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
    private static final String FILE_RENAMED = "_1_new.cfe";
    }
    private static final String FILE_PRESENT_IN_REMOTE_ONLY = "_0.si";
            "temp_file.tmp" };
import org.apache.lucene.store.FilterIndexInput;
        assertEquals(0, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
    }
    }
        assertFalse(existsInTieredDirectory(TEMP_FILE));
        });
        } catch (Exception e) {
        "_0.cfs_block_7",
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        assertTrue(existsInFileCache(getFilePath(localDirectory, FILE_PRESENT_LOCALLY)));
        tieredDirectory.deleteFile(TEMP_FILE);
        populateData();
        IndexStorePlugin.DirectoryFactory localDirFactory = mock(IndexStorePlugin.DirectoryFactory.class);
        assertTrue(existsInTieredDirectory(FILE_PRESENT_IN_REMOTE_ONLY));
        assertNull(fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
        } catch (Exception e) {
import java.nio.file.Path;
        };
        assertFalse(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
        String fileNameBlock = "_0.si_block_0";
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {
        assertEquals(1, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
        assertTrue(existsInLocalDirectory(FILE_PRESENT_LOCALLY));
        "_0.cfe_block_7",
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        assertFalse(existsInTieredDirectory(FILE_PRESENT_LOCALLY));
            "_0.cfe",
        remoteSegmentStoreDirectory.init();
            "_1.cfe",
    }
        indexInput = tieredDirectory.openInput(fileName, IOContext.DEFAULT);
/*
    }
    private static final String FILE_PRESENT_LOCALLY = "_1.cfe";
        assertEquals(1, (int) fileCache.getRef(getFilePath(localDirectory, fileNameBlock)));
    public void testRename() throws IOException {
        assertTrue(indexInput instanceof SwitchableIndexInputWrapper);
        IndexInput clone = indexInput.clone();
    }
        allFiles.stream().filter(FileTypeUtils::isExtraFSFile).forEach(file -> {
        return () -> {
            } catch (IOException e) {
        try {
    private FSDirectory localDirectory;
        assertFalse(getSwitchableIndexInputFromWrapper(indexInput).isCachedFromRemote());
    private boolean existsInLocalDirectory(String name) throws IOException {
        assertTrue(existsInRemoteDirectory(fileName));
        assertEquals(1, (int) fileCache.getRef(getFilePath(localDirectory, fileName)));
        }
import org.opensearch.storage.indexinput.SwitchableIndexInput;
            "_2.cfe",
package org.opensearch.storage.directory;
        decRefToZero(path);
        createUnclosedClones(indexInput, path);
        assertEquals(1, (int) fileCache.getRef(getFilePathSwitchable(localDirectory, fileName)));
            try {
    }
        assertNull(fileCache.get(getFilePathSwitchable(localDirectory, FILE_PRESENT_IN_REMOTE_ONLY)));
/**
        when(localDirFactory.newDirectory(any(), any())).thenReturn(factoryLocalDir);
        tieredDirectory.deleteFile(FILE_PRESENT_IN_REMOTE_ONLY);
        assertThrows(NoSuchFileException.class, () -> tieredDirectory.openInput(NON_EXISTENT_FILE, IOContext.DEFAULT));
    private void removeExtraFSFiles() throws IOException {
    }
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
        }
    public void testOpenInput() throws IOException {
        try {
        return Arrays.asList(tieredDirectory.listAll()).contains(name);
        assertTrue(existsInFileCache(getFilePathSwitchable(localDirectory, FILE_PRESENT_LOCALLY)));
        String fileName = "_0.si";
 */
        addFilesToDirectory(LOCAL_FILES);
        "_1.cfe_block_1",
    }
        indexInput = tieredDirectory.openInput(FILE_PRESENT_IN_REMOTE_ONLY, IOContext.DEFAULT);
    private boolean existsInTieredDirectory(String name) throws IOException {
import java.util.concurrent.TimeUnit;
        Directory result = factory.newDirectory(null, null, localDirFactory, remoteSegmentStoreDirectory, factoryFileCache, threadPool);
        String[] expectedFileNames = new String[] {
import org.opensearch.index.store.remote.utils.FileTypeUtils;
        removeExtraFSFiles();
        populateData();
        indexInput.close();
        FSDirectory factoryLocalDir = FSDirectory.open(createTempDir());
        assertEquals(2, (int) fileCache.getRef(path));
        assertNotNull(indexInput);
        return Arrays.asList(remoteSegmentStoreDirectory.listAll()).contains(name);
    private void addFilesToDirectory(String[] files) throws IOException {
        "_2.cfe",
            fail();
            }, 5, TimeUnit.SECONDS);
            threadPool,
