            return readLockWrapper;  
                operation.accept(switchableIndexInput);
            FILE_NAME,  
        }
        CountDownLatch latch
            this.delegate = delegate;  
                }  
        cachedIndexInput = getFileCacheEntry(fileName);
        assertNull(getFileCacheEntry(FILE_NAME));
            FILE_NAME,
            sharedLock.setWriteDelayEnabled(true);
        syncLocalAndRemoteForFile(localDirectory, FILE_NAME);
                    try {  
            "switchable",
        assertEquals(filePointerAfterSwitching, filePointerBeforeSwitching);
        assertFalse(slicedIndexInput.hasSwitchedToRemote());
                        Thread.currentThread().interrupt();  
        fileCache.prune();
        operations.add(SwitchableIndexInput::getFilePointer);  
        switchableIndexInput.readByte();
            threadPool
        }  
        }
    }
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
        Path path = getFilePath(localDirectory, name);
            threadPool,
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, true);
import org.opensearch.index.store.remote.utils.TransferManager;  
        Consumer<SwitchableIndexInput> operation,  
        return () -> {
            }
    }
        assertNotNull(cachedIndexInput);  
    }
import java.util.concurrent.locks.Lock;
    private void testCloneSliceRefCounting(SwitchableIndexInput switchableIndexInput, String fileName) throws IOException {
        );
import java.nio.file.Path;
        operations.add(indexInput -> {
import java.util.function.Supplier;
        assertNull(getFileCacheEntry(FILE_NAME));  
            }  
            return writeLockWrapper;
            } finally {
        assertNotNull(getFileCacheEntry(FILE_NAME_BLOCK));  
        clonedIndexInput.close();
        assertFalse(switchableIndexInput.isCachedFromRemote());  
        IndexInput slicedIndexInput = switchableIndexInput.slice("slice", 0, switchableIndexInput.length());  
 * this file be licensed under the Apache-2.0 license or a
            localDirectory,
        }
        }
                startTogether.await();  
        );  
            "switchable",  
            } catch (IOException e) {  
        MockSwitchableIndexInput switchableIndexInput = getMockSwitchableIndexInput();  
            objectLock.setDelayEnabled(false);
                localDirectory,
        assertNotEquals(switchableIndexInput.getFilePointer(), clonedIndexInput.getFilePointer());
            "switchable",
import java.util.concurrent.ExecutorService;  
            return delegate.tryLock();
        IndexInput clonedIndexInput = switchableIndexInput.clone();
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, true);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        });  
    public void testSwitchableIndexInputLocal() throws IOException {
        public Lock writeLock() {
        );
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import java.util.concurrent.locks.ReadWriteLock;
            FILE_NAME,
    }  
import org.opensearch.common.lucene.store.InputStreamIndexInput;  
    }  
import org.apache.lucene.store.IOContext;
        remoteSegmentStoreDirectory.init();
            assertEquals(shouldComplete, latch.await(5, TimeUnit.SECONDS));  
        TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
        }
        when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
        assertFalse(switchableIndexInput.hasSwitchedToRemote());  
        byte b1 = remoteIndexInput.readByte();
        fileCache.decRef(path);  
                getFilePathSwitchable(localDirectory, FILE_NAME),
        }  
        SwitchableIndexInput switchableIndexInput1 = switchableIndexInput.clone();
        private final Object delayMonitor = new Object();
        public boolean tryLock(long time, java.util.concurrent.TimeUnit unit) throws InterruptedException {  
        assertNull(getFileCacheEntry(FILE_NAME_BLOCK));
 * The OpenSearch Contributors require contributions made to  
            getFilePath(localDirectory, FILE_NAME),
                    } catch (InterruptedException e) {
            transferManager,
import java.util.concurrent.locks.Condition;  
    private MockSwitchableIndexInput getMockSwitchableIndexInput() throws IOException {  
        );  
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, false);  
        return cachedIndexInput;
 */
            delegate.unlock();  
            remoteSegmentStoreDirectory,  
        }
                fileName,  
        @Override
    @Before  
        return settings;
        for (int i = 0; i <= numTimesToExecute; i++) {  
import org.opensearch.storage.indexinput.OnDemandPrefetchBlockSnapshotIndexInput;
        public boolean tryLock() {
                cacheFromRemote,
    }
    }
            InjectableLock objectLock = switchableIndexInput.getObjectLock();  
        slicedIndexInput.close();  
    }  
        setupRemoteSegmentStoreDirectory();
    private static class InjectableReadWriteLock implements ReadWriteLock {  
            fileCache,  
            transferManager,
        IndexInput indexInput = switchableIndexInput.getUnderlyingIndexInput();  
    FileCache fileCache;
        public void lock() {
            ),
            }
    TransferManager transferManager;
            assertTrue(terminate(testRunner));  
        switchableIndexInput1.close();
            boolean cacheFromRemote,
        fileCache.prune();  
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(
            getPrefetchSettingsSupplier()
            }  
                fileCache,  
        long parentPointer = switchableIndexInput.getFilePointer();
        assertNotNull(getFileCacheEntry(FILE_NAME));  
            getPrefetchSettingsSupplier()  
import java.util.function.Consumer;  
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(
        private final Lock delegate;
    }
        CachedIndexInput cachedIndexInput = fileCache.get(path);
import org.opensearch.threadpool.ThreadPool;
        when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
                    delayMonitor.notifyAll();
        indexInputs.add(switchableIndexInput);  
            String resourceDescription,
package org.opensearch.storage.directory;
                remoteDirectory,
        } finally {
        public void setWriteDelayEnabled(boolean enabled) {  
    public void setup() throws IOException {
                }
        public Condition newCondition() {
        SwitchableIndexInput switchableIndexInput,
            return (InjectableLock) objectLock;
import static org.mockito.Mockito.mock;  
import java.util.ArrayList;  
        public void setDelayEnabled(boolean enabled) {  
import java.util.concurrent.Executors;
        long filePointerBeforeSwitching = switchableIndexInput.getFilePointer();  
                    }
        IndexInput localIndexInput = localDirectory.openInput(FILE_NAME, IOContext.DEFAULT);
    ) {  
                throw new AssertionError(e);  
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(  
    }
        SwitchableIndexInput switchableIndexInput = new SwitchableIndexInput(  
import java.util.concurrent.CountDownLatch;
        slicedIndexInput.seek(slicedIndexInput.getFilePointer() + 2);
            remoteSegmentStoreDirectory,  
    private static final String FILE_NAME_BLOCK = "_0.si_block_0";
    }
        CachedIndexInput cachedIndexInput = getFileCacheEntry(FILE_NAME_BLOCK);
import java.io.IOException;
import java.util.List;
        SwitchableIndexInput clone1 = switchableIndexInput.clone();
import org.opensearch.index.store.remote.filecache.FileCache;  
        SwitchableIndexInput slicedIndexInput = switchableIndexInput.slice("slice", 0, switchableIndexInput.length());
            transferManager,
        } finally {  
            CountDownLatch startTogether = new CountDownLatch(1);
        }
            fileCache,
            super(
        assertEquals(switchableIndexInput.readByte(), localIndexInput.readByte());
        }
    private CachedIndexInput getFileCacheEntry(String name) {  
        indexInputs.add(clone2);
    private Runnable createOperationRunner(
        ) throws IOException {  
    private static class InjectableLock implements Lock {  
            assertTrue(terminate(testRunner));
            FileCache fileCache,  
            return delegate.tryLock(time, unit);
        List<SwitchableIndexInput> indexInputs = new ArrayList<>();
        public InjectableLock(Lock delegate) {
            localDirectory,
            CountDownLatch latch = new CountDownLatch(indexInputs.size() * operations.size());
        byte b0 = switchableIndexInput1.readByte();  
            } catch (Exception e) {
        IndexInput indexInput = cachedIndexInput.getIndexInput();
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
        operations.add(SwitchableIndexInput::clone);
        @Override  
            objectLock = new InjectableLock(objectLock);  
        assertEquals(switchableIndexInput.getFilePointer(), parentPointer);  
                throw new RuntimeException(e);
            threadPool  
        switchableIndexInput.switchToRemote();
        indexInput = switchableIndexInput.getUnderlyingIndexInput();
    }
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            org.opensearch.index.store.RemoteSegmentStoreDirectory remoteDirectory,
        final ExecutorService testRunner = Executors.newFixedThreadPool(8);  
            }
        int numTimesToExecute,  
                    testRunner.submit(createOperationRunner(startTogether, operation, indexInput, latch));
    private static final Supplier<TieredStoragePrefetchSettings> MOCK_PREFETCH_SETTINGS_SUPPLIER = () -> {  
        );
        );
        private void maybeDelay() {  
        assertNotEquals(switchableIndexInput.getFilePointer(), slicedIndexInput.getFilePointer());
        testCloneSliceRefCounting(switchableIndexInput, FILE_NAME_BLOCK);  
                delayEnabled = enabled;
    public void testPrefetch() throws IOException {
            threadPool,
        CachedIndexInput cachedIndexInput = getFileCacheEntry(fileName);
    }
            threadPool,
/*  
    };  
            localDirectory,  
        CachedIndexInput cachedIndexInput = getFileCacheEntry(FILE_NAME);
    public void testSwitchableIndexInputRemote() throws IOException {
        assertTrue(switchableIndexInput.isCachedFromRemote());
import static org.opensearch.index.store.remote.utils.FileTypeUtils.BLOCK_FILE_IDENTIFIER;  
        assertEquals(switchableIndexInput1.getFilePointer(), remoteIndexInput.getFilePointer());
import static org.opensearch.storage.utils.DirectoryUtils.getFilePath;
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);  
            getFilePath(localDirectory, FILE_NAME),
        @Override
            uploadToRemote(fileName);  
            FILE_NAME,
            sharedLock = new InjectableReadWriteLock(sharedLock);
        assertEquals(slicedIndexInput.getFilePointer(), 0);
                indexInput.switchToRemote();
import java.util.concurrent.TimeUnit;
 */  
        assertNull(cachedIndexInput);  
    private void uploadToRemote(String file) {
            ThreadPool threadPool
}
        }
    FSDirectory localDirectory;  
            localDirectory,
        }
            threadPool,  
import org.apache.lucene.store.IndexInput;
            "switchable",
 * Tests for {@link SwitchableIndexInput}.
import static org.mockito.Mockito.when;
            getFilePathSwitchable(localDirectory, FILE_NAME),
        assertNotNull(cachedIndexInput);  
                latch.countDown();
        testCloneSliceRefCounting(switchableIndexInput, FILE_NAME);
        }  
                length
            synchronized (delayMonitor) {
        assertTrue(indexInput instanceof FullFileCachedIndexInput);
        assertEquals(switchableIndexInput.getFilePointer(), clonedIndexInput.getFilePointer());
        assertTrue(indexInput instanceof FullFileCachedIndexInput);
        ExecutorService testRunner,  
        operations.add(indexInput -> {  
        localDirectory = FSDirectory.open(createTempDir());  
    }
            getFilePath(localDirectory, FILE_NAME),  
                this.remoteSegmentStoreDirectory.openBlockInput(name, position, length, IOContext.DEFAULT),  
        final ExecutorService testRunner = Executors.newFixedThreadPool(8);
                resourceDescription,
import org.opensearch.storage.indexinput.SwitchableIndexInput;
            try {
            remoteSegmentStoreDirectory,
        public InjectableReadWriteLock(ReadWriteLock delegate) {
    public void testSwitchToRemote() throws IOException {  
                if (!enabled) {  
    private List<Consumer<SwitchableIndexInput>> getOperationsToExecute() {
            localDirectory,  
        assertTrue(switchableIndexInput.hasSwitchedToRemote());
        assertTrue(slicedIndexInput.hasSwitchedToRemote());
            delegate.lock();  
            getFilePath(localDirectory, FILE_NAME),  
            false,
                }  
        assertNull(getFileCacheEntry(FILE_NAME_BLOCK));
        if (fileName.contains(BLOCK_FILE_IDENTIFIER) == false) {
        InjectableLock getObjectLock() {
        }
            startTogether.countDown();
            (name, position, length) -> new InputStreamIndexInput(
            try {
            this.readLockWrapper = new InjectableLock(delegate.readLock());
        populateData();
            } catch (IOException e) {
            InjectableReadWriteLock sharedLock = switchableIndexInput.getSharedLock();
            this.writeLockWrapper = new InjectableLock(delegate.writeLock());  
 * compatible open source license.
        public void lockInterruptibly() throws InterruptedException {
            false,
        populateMetadata();  
        assertFalse(clonedIndexInput.hasSwitchedToRemote());
    }
        assertNotNull(cachedIndexInput);
        @Override
            true,  
        MockSwitchableIndexInput switchableIndexInput = getMockSwitchableIndexInput();
            getFilePathSwitchable(localDirectory, FILE_NAME),
 * SPDX-License-Identifier: Apache-2.0
        CountDownLatch startTogether,
            fileCache,
        public Lock readLock() {
        });
            sharedLock.setWriteDelayEnabled(false);
            getPrefetchSettingsSupplier()
        @Override
            getFilePathSwitchable(localDirectory, FILE_NAME),
        return new MockSwitchableIndexInput(
    ) throws InterruptedException {
        int concurrencyLevel = randomIntBetween(1, 2);
        SwitchableIndexInput clonedIndexInput = switchableIndexInput.clone();  
    private Supplier<TieredStoragePrefetchSettings> getPrefetchSettingsSupplier() {
            getFilePathSwitchable(localDirectory, FILE_NAME),  
            runOperationsConcurrently(testRunner, operations, indexInputs, 10, false);
                        throw new RuntimeException("Interrupted during delay", e);
            delegate.lockInterruptibly();  
            remoteSegmentStoreDirectory,
import org.junit.Before;
            false,  
        switchableIndexInput.prefetch(0, 10);
        switchableIndexInput.switchToRemote();
                indexInput.readByte();  
            "switchable",
            List<Consumer<SwitchableIndexInput>> operations = getOperationsToExecute();
                getFilePath(localDirectory, FILE_NAME),
                transferManager,  
        transferManager = new TransferManager(
        return MOCK_PREFETCH_SETTINGS_SUPPLIER;  
        try {
        populateData();
            remoteSegmentStoreDirectory,
    private static class MockSwitchableIndexInput extends SwitchableIndexInput {
        }
        List<SwitchableIndexInput> indexInputs,
        @Override  
    }
        when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);  
        }
    }  
        return operations;
            return delegate.newCondition();
        List<Consumer<SwitchableIndexInput>> operations,
            writeLockWrapper.setDelayEnabled(enabled);
        clonedIndexInput.seek(clonedIndexInput.getFilePointer() + 1);
        assertEquals(b0, b1);
        assertEquals(switchableIndexInput.getFilePointer(), localIndexInput.getFilePointer());
        assertNotNull(cachedIndexInput);  
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
            }  
            return (InjectableReadWriteLock) sharedLock;
        private volatile boolean delayEnabled = false;  
            synchronized (delayMonitor) {
        List<Consumer<SwitchableIndexInput>> operations = new ArrayList<>();
    private static final String FILE_NAME = "_0.si";  
            getPrefetchSettingsSupplier()
    private void runOperationsConcurrently(
/**  
        }  
            for (Consumer<SwitchableIndexInput> operation : operations) {  
                MOCK_PREFETCH_SETTINGS_SUPPLIER  
        };
        }
        try {
        operations.add(SwitchableIndexInput::length);
        InjectableReadWriteLock getSharedLock() {  
        private final InjectableLock writeLockWrapper;
        assertNull(cachedIndexInput);  
        private final InjectableLock readLockWrapper;
        SwitchableIndexInput clone2 = clone1.clone();
            fileCache,  
        fileCache.decRef(getFilePath(localDirectory, file));
                while (delayEnabled) {
        assertTrue(indexInput instanceof OnDemandPrefetchBlockSnapshotIndexInput);  
import org.opensearch.index.store.remote.filecache.FullFileCachedIndexInput;
            transferManager,
            fileCache,
            transferManager,  
            FILE_NAME,  
            false,
            );
                for (SwitchableIndexInput indexInput : indexInputs) {
    public void testConcurrencySingleIndexInput() throws IOException, InterruptedException {  
        assertEquals(switchableIndexInput1.length(), remoteIndexInput.length());  
            FSDirectory localDirectory,
        public MockSwitchableIndexInput(  
            objectLock.setDelayEnabled(true);  
        @Override  
        List<SwitchableIndexInput> indexInputs = new ArrayList<>();  
        indexInputs.add(clone1);
        @Override
        boolean shouldComplete
            fileCache,
        cachedIndexInput = getFileCacheEntry(fileName);
import org.apache.lucene.store.FSDirectory;  
            List<Consumer<SwitchableIndexInput>> operations = getOperationsToExecute();  
        public void unlock() {
            try {
 *
        assertTrue(clonedIndexInput.hasSwitchedToRemote());  
public class SwitchableIndexInputTests extends TieredStorageBaseTestCase {
        assertTrue(switchableIndexInput.hasSwitchedToRemote());  
        cachedIndexInput = getFileCacheEntry(FILE_NAME_BLOCK);
                        delayMonitor.wait();
        long filePointerAfterSwitching = switchableIndexInput.getFilePointer();
            TransferManager transferManager,  
            maybeDelay();
            String fileName,
        }
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
        }
                throw new RuntimeException(e);
                threadPool,
        fileCache.decRef(getFilePathSwitchable(localDirectory, file));  
        assertEquals(switchableIndexInput.length(), localIndexInput.length());  
        switchableIndexInput.prefetch(0, 10);
    public void testConcurrencyMultipleIndexInput() throws IOException, InterruptedException {
    }
        IndexInput remoteIndexInput = remoteSegmentStoreDirectory.openInput(FILE_NAME, IOContext.DEFAULT);
