    @Before
        CachedIndexInput cachedIndexInput = getFileCacheEntry(FILE_NAME_BLOCK);
    }
import org.opensearch.storage.indexinput.SwitchableIndexInput;
        populateData();
        syncLocalAndRemoteForFile(localDirectory, FILE_NAME);
        assertNull(getFileCacheEntry(FILE_NAME));
        assertNull(getFileCacheEntry(FILE_NAME_BLOCK));
        switchableIndexInput.prefetch(0, 10);
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(
        }
            return delegate.newCondition();
        final ExecutorService testRunner = Executors.newFixedThreadPool(8);
        }
/**
            remoteSegmentStoreDirectory,
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(
            threadPool
import java.util.List;
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, false);
    public void testPrefetch() throws IOException {
import java.util.function.Supplier;
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(
    public void testSwitchableIndexInputLocal() throws IOException {
    FSDirectory localDirectory;
        return settings;
    private static class InjectableLock implements Lock {
        private final Lock delegate;
        assertNotNull(cachedIndexInput);
                remoteDirectory,
    }
        assertNull(getFileCacheEntry(FILE_NAME));
        private final InjectableLock writeLockWrapper;
    private static final String FILE_NAME = "_0.si";
        setupRemoteSegmentStoreDirectory();
import org.junit.Before;
    }
        );
            try {
    public void testSwitchableIndexInputRemote() throws IOException {
            FILE_NAME,
            objectLock.setDelayEnabled(true);
import org.opensearch.storage.indexinput.OnDemandPrefetchBlockSnapshotIndexInput;
        localDirectory = FSDirectory.open(createTempDir());
                indexInput.readByte();
        assertNotNull(getFileCacheEntry(FILE_NAME_BLOCK));
            maybeDelay();
            remoteSegmentStoreDirectory,
        }
                localDirectory,
        List<SwitchableIndexInput> indexInputs,
        }
import org.opensearch.index.store.remote.filecache.FileCache;
        CachedIndexInput cachedIndexInput = getFileCacheEntry(FILE_NAME);
        CountDownLatch latch
            true,
        fileCache.prune();
        private volatile boolean delayEnabled = false;
        public void setWriteDelayEnabled(boolean enabled) {
    private static final String FILE_NAME_BLOCK = "_0.si_block_0";
        clonedIndexInput.close();
            FILE_NAME,
            }
        long filePointerBeforeSwitching = switchableIndexInput.getFilePointer();
            return (InjectableLock) objectLock;
        slicedIndexInput.seek(slicedIndexInput.getFilePointer() + 2);
    }
            startTogether.countDown();
        indexInputs.add(clone2);
        return cachedIndexInput;
        byte b0 = switchableIndexInput1.readByte();
                throw new RuntimeException(e);
        List<SwitchableIndexInput> indexInputs = new ArrayList<>();
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
            localDirectory,
            for (Consumer<SwitchableIndexInput> operation : operations) {
    public void testConcurrencyMultipleIndexInput() throws IOException, InterruptedException {
        switchableIndexInput.readByte();
            transferManager,
        }
        SwitchableIndexInput slicedIndexInput = switchableIndexInput.slice("slice", 0, switchableIndexInput.length());
        public boolean tryLock(long time, java.util.concurrent.TimeUnit unit) throws InterruptedException {
    }
            fileCache,
            "switchable",
            getFilePathSwitchable(localDirectory, FILE_NAME),
        assertNotEquals(switchableIndexInput.getFilePointer(), slicedIndexInput.getFilePointer());
        assertTrue(indexInput instanceof OnDemandPrefetchBlockSnapshotIndexInput);
                while (delayEnabled) {
    }
        assertEquals(slicedIndexInput.getFilePointer(), 0);
        return new MockSwitchableIndexInput(
            ),
            getPrefetchSettingsSupplier()
        assertNull(cachedIndexInput);
            CountDownLatch latch = new CountDownLatch(indexInputs.size() * operations.size());
        );
        private void maybeDelay() {
    }
            getFilePath(localDirectory, FILE_NAME),
    private MockSwitchableIndexInput getMockSwitchableIndexInput() throws IOException {
        slicedIndexInput.close();
        );
        private final Object delayMonitor = new Object();
            try {
    }
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, true);
                for (SwitchableIndexInput indexInput : indexInputs) {
                        delayMonitor.wait();
        assertNotEquals(switchableIndexInput.getFilePointer(), clonedIndexInput.getFilePointer());
        assertEquals(switchableIndexInput.readByte(), localIndexInput.readByte());
        @Override
import java.util.concurrent.Executors;
            "switchable",
    }
        for (int i = 0; i <= numTimesToExecute; i++) {
import org.opensearch.threadpool.ThreadPool;
        return MOCK_PREFETCH_SETTINGS_SUPPLIER;
        SwitchableIndexInput clone1 = switchableIndexInput.clone();
                transferManager,
        }
        }
            localDirectory,
            getFilePath(localDirectory, FILE_NAME),
import org.apache.lucene.store.FSDirectory;
import static org.opensearch.storage.utils.DirectoryUtils.getFilePath;
        CachedIndexInput cachedIndexInput = getFileCacheEntry(fileName);
        assertEquals(switchableIndexInput1.length(), remoteIndexInput.length());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        InjectableReadWriteLock getSharedLock() {
                resourceDescription,
        operations.add(SwitchableIndexInput::length);
        MockSwitchableIndexInput switchableIndexInput = getMockSwitchableIndexInput();
import org.opensearch.index.store.remote.filecache.FullFileCachedIndexInput;
            return delegate.tryLock(time, unit);
            writeLockWrapper.setDelayEnabled(enabled);
            return readLockWrapper;
            remoteSegmentStoreDirectory,
            objectLock.setDelayEnabled(false);
 *
        IndexInput remoteIndexInput = remoteSegmentStoreDirectory.openInput(FILE_NAME, IOContext.DEFAULT);
        IndexInput indexInput = cachedIndexInput.getIndexInput();
                    } catch (InterruptedException e) {
        testCloneSliceRefCounting(switchableIndexInput, FILE_NAME);
    private static class MockSwitchableIndexInput extends SwitchableIndexInput {
            sharedLock = new InjectableReadWriteLock(sharedLock);
        }
        public void unlock() {
            } catch (IOException e) {
        @Override
            getFilePathSwitchable(localDirectory, FILE_NAME),
        SwitchableIndexInput switchableIndexInput1 = switchableIndexInput.clone();
                latch.countDown();
            sharedLock.setWriteDelayEnabled(false);
            return writeLockWrapper;
    public void testConcurrencySingleIndexInput() throws IOException, InterruptedException {
        );
            threadPool
        SwitchableIndexInput clone2 = clone1.clone();
        assertEquals(switchableIndexInput.getFilePointer(), parentPointer);
        indexInputs.add(clone1);
        public void lockInterruptibly() throws InterruptedException {
        assertEquals(switchableIndexInput.getFilePointer(), localIndexInput.getFilePointer());
    ) throws InterruptedException {
    private Runnable createOperationRunner(
    private static class InjectableReadWriteLock implements ReadWriteLock {
        }
            assertTrue(terminate(testRunner));
                throw new AssertionError(e);
            return delegate.tryLock();
        assertTrue(indexInput instanceof FullFileCachedIndexInput);
    }
        if (fileName.contains(BLOCK_FILE_IDENTIFIER) == false) {
            remoteSegmentStoreDirectory,
                fileCache,
            transferManager,
            transferManager,
        public Condition newCondition() {
        fileCache.decRef(path);
            List<Consumer<SwitchableIndexInput>> operations = getOperationsToExecute();
        SwitchableIndexInput switchableIndexInput,
            } catch (Exception e) {
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, true);
            List<Consumer<SwitchableIndexInput>> operations = getOperationsToExecute();
 */
        assertTrue(indexInput instanceof FullFileCachedIndexInput);
        assertNull(cachedIndexInput);
 * SPDX-License-Identifier: Apache-2.0
            delegate.unlock();
                }
        }
        assertFalse(switchableIndexInput.isCachedFromRemote());
        public InjectableReadWriteLock(ReadWriteLock delegate) {
        }
            (name, position, length) -> new InputStreamIndexInput(
        transferManager = new TransferManager(
        assertFalse(clonedIndexInput.hasSwitchedToRemote());
        assertEquals(b0, b1);
            localDirectory,
                }
        int numTimesToExecute,
        when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
            InjectableReadWriteLock sharedLock = switchableIndexInput.getSharedLock();
        boolean shouldComplete
        @Override
        final ExecutorService testRunner = Executors.newFixedThreadPool(8);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(switchableIndexInput.hasSwitchedToRemote());
            localDirectory,
        }
            synchronized (delayMonitor) {
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, false);
            false,
            "switchable",
        populateMetadata();
        Path path = getFilePath(localDirectory, name);
        private final InjectableLock readLockWrapper;
        return operations;
 */
            assertTrue(terminate(testRunner));
            super(
        assertTrue(clonedIndexInput.hasSwitchedToRemote());
    }
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
    private void uploadToRemote(String file) {
        MockSwitchableIndexInput switchableIndexInput = getMockSwitchableIndexInput();
        populateData();
            transferManager,
                MOCK_PREFETCH_SETTINGS_SUPPLIER
                cacheFromRemote,
        public Lock readLock() {
        @Override
            }
        assertFalse(switchableIndexInput.hasSwitchedToRemote());
        remoteSegmentStoreDirectory.init();
            "switchable",
        List<SwitchableIndexInput> indexInputs = new ArrayList<>();
    }
 * Tests for {@link SwitchableIndexInput}.
        }
    TransferManager transferManager;
                throw new RuntimeException(e);
        assertNotNull(getFileCacheEntry(FILE_NAME));
        switchableIndexInput.switchToRemote();
            delegate.lockInterruptibly();
import java.util.concurrent.locks.Lock;
        operations.add(SwitchableIndexInput::getFilePointer);
        });
    ) {
            objectLock = new InjectableLock(objectLock);
        @Override
                fileName,
        } finally {
                getFilePathSwitchable(localDirectory, FILE_NAME),
import java.nio.file.Path;
            String resourceDescription,
        assertTrue(switchableIndexInput.hasSwitchedToRemote());
            String fileName,
            remoteSegmentStoreDirectory,
            );
            threadPool,
            InjectableLock objectLock = switchableIndexInput.getObjectLock();
        TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
}
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
            this.readLockWrapper = new InjectableLock(delegate.readLock());
        indexInput = switchableIndexInput.getUnderlyingIndexInput();
        try {
        public MockSwitchableIndexInput(
            threadPool,
import java.util.concurrent.locks.Condition;
            this.delegate = delegate;
import org.apache.lucene.store.IndexInput;
        byte b1 = remoteIndexInput.readByte();
    private Supplier<TieredStoragePrefetchSettings> getPrefetchSettingsSupplier() {
                threadPool,
            localDirectory,
            getPrefetchSettingsSupplier()
            getFilePath(localDirectory, FILE_NAME),
        assertNotNull(cachedIndexInput);
            return (InjectableReadWriteLock) sharedLock;
                getFilePath(localDirectory, FILE_NAME),
        int concurrencyLevel = randomIntBetween(1, 2);
            FSDirectory localDirectory,
            FileCache fileCache,
            getPrefetchSettingsSupplier()
        }
        operations.add(SwitchableIndexInput::clone);
            fileCache,
    private void testCloneSliceRefCounting(SwitchableIndexInput switchableIndexInput, String fileName) throws IOException {
                operation.accept(switchableIndexInput);
import static org.mockito.Mockito.mock;
    FileCache fileCache;
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        IndexInput slicedIndexInput = switchableIndexInput.slice("slice", 0, switchableIndexInput.length());
 * The OpenSearch Contributors require contributions made to
        assertEquals(switchableIndexInput.length(), localIndexInput.length());
import java.util.concurrent.CountDownLatch;
        switchableIndexInput.prefetch(0, 10);
import org.opensearch.index.store.remote.utils.TransferManager;
import org.apache.lucene.store.IOContext;
    }
        assertEquals(filePointerAfterSwitching, filePointerBeforeSwitching);
            fileCache,
            }
        assertNotNull(cachedIndexInput);
            CountDownLatch startTogether = new CountDownLatch(1);
        public InjectableLock(Lock delegate) {
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        });
        fileCache.decRef(getFilePath(localDirectory, file));
            threadPool,
        assertNotNull(cachedIndexInput);
            }
            }
        long parentPointer = switchableIndexInput.getFilePointer();
        @Override
    };
            getPrefetchSettingsSupplier()
import java.util.ArrayList;
        CachedIndexInput cachedIndexInput = fileCache.get(path);
import static org.opensearch.index.store.remote.utils.FileTypeUtils.BLOCK_FILE_IDENTIFIER;
        SwitchableIndexInput clonedIndexInput = switchableIndexInput.clone();
        indexInputs.add(switchableIndexInput);
        public boolean tryLock() {
            FILE_NAME,
    private CachedIndexInput getFileCacheEntry(String name) {
                    try {
import static org.mockito.Mockito.when;
        IndexInput clonedIndexInput = switchableIndexInput.clone();
        assertNull(getFileCacheEntry(FILE_NAME_BLOCK));
        ) throws IOException {
                if (!enabled) {
            boolean cacheFromRemote,
            this.writeLockWrapper = new InjectableLock(delegate.writeLock());
            try {
    }
        operations.add(indexInput -> {
    }
            fileCache,
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(
        return () -> {
        cachedIndexInput = getFileCacheEntry(FILE_NAME_BLOCK);
            FILE_NAME,
        List<Consumer<SwitchableIndexInput>> operations,
                startTogether.await();
        when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
                indexInput.switchToRemote();
        IndexInput indexInput = switchableIndexInput.getUnderlyingIndexInput();
            uploadToRemote(fileName);
            threadPool,
            fileCache,
    }
public class SwitchableIndexInputTests extends TieredStorageBaseTestCase {
        switchableIndexInput1.close();
        @Override
        Consumer<SwitchableIndexInput> operation,
            FILE_NAME,
    private List<Consumer<SwitchableIndexInput>> getOperationsToExecute() {
        long filePointerAfterSwitching = switchableIndexInput.getFilePointer();
    public void setup() throws IOException {
        when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
                    }
                this.remoteSegmentStoreDirectory.openBlockInput(name, position, length, IOContext.DEFAULT),
        clonedIndexInput.seek(clonedIndexInput.getFilePointer() + 1);
        List<Consumer<SwitchableIndexInput>> operations = new ArrayList<>();
        public Lock writeLock() {
        assertEquals(switchableIndexInput.getFilePointer(), clonedIndexInput.getFilePointer());
                length
    }
            getFilePath(localDirectory, FILE_NAME),
            } catch (IOException e) {
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);
        }
        @Override
    private void runOperationsConcurrently(
            TransferManager transferManager,
        ExecutorService testRunner,
            getFilePathSwitchable(localDirectory, FILE_NAME),
        }
        assertEquals(switchableIndexInput1.getFilePointer(), remoteIndexInput.getFilePointer());
            org.opensearch.index.store.RemoteSegmentStoreDirectory remoteDirectory,
        switchableIndexInput.switchToRemote();
/*
        IndexInput localIndexInput = localDirectory.openInput(FILE_NAME, IOContext.DEFAULT);
                    delayMonitor.notifyAll();
                        throw new RuntimeException("Interrupted during delay", e);
import java.util.concurrent.ExecutorService;
        }
            "switchable",
            false,
            synchronized (delayMonitor) {
            }
        assertTrue(switchableIndexInput.isCachedFromRemote());
            transferManager,
                        Thread.currentThread().interrupt();
            sharedLock.setWriteDelayEnabled(true);
        assertFalse(slicedIndexInput.hasSwitchedToRemote());
import java.util.concurrent.TimeUnit;
        );
            fileCache,
        operations.add(indexInput -> {
            getFilePathSwitchable(localDirectory, FILE_NAME),
 * compatible open source license.
import java.util.concurrent.locks.ReadWriteLock;
            delegate.lock();
import java.util.function.Consumer;
    public void testSwitchToRemote() throws IOException {
            } finally {
        fileCache.prune();
        }
            false,
    }
        fileCache.decRef(getFilePathSwitchable(localDirectory, file));
        CountDownLatch startTogether,
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
import org.opensearch.common.lucene.store.InputStreamIndexInput;
                delayEnabled = enabled;
        testCloneSliceRefCounting(switchableIndexInput, FILE_NAME_BLOCK);
        public void setDelayEnabled(boolean enabled) {
        );
        };
                    testRunner.submit(createOperationRunner(startTogether, operation, indexInput, latch));
        try {
        cachedIndexInput = getFileCacheEntry(fileName);
        public void lock() {
import java.io.IOException;
        }
            ThreadPool threadPool
        assertTrue(slicedIndexInput.hasSwitchedToRemote());
            false,
        cachedIndexInput = getFileCacheEntry(fileName);
        } finally {
package org.opensearch.storage.directory;
        }
            assertEquals(shouldComplete, latch.await(5, TimeUnit.SECONDS));
    private static final Supplier<TieredStoragePrefetchSettings> MOCK_PREFETCH_SETTINGS_SUPPLIER = () -> {
        InjectableLock getObjectLock() {
                }
