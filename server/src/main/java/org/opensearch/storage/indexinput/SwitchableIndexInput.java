    private final FileCache fileCache;
        String fileName,
                        switchableFilePath,
        );
            throw new IllegalStateException("Cannot switch to remote as file " + fileName + " not present in remote");
    @Override
                        hasSwitchedToRemote,
     */
     * @return returns underlying index input
    @Override
    }
import java.util.concurrent.locks.Lock;
 * FileCache Interactions with Switchable Index Input:
                    );
                }
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readLong(pos));
import java.io.IOException;
        String resourceDescription,
    public boolean hasSwitchedToRemote() {
                if (!isClone) fileCache.remove(fullFilePath);
    public void prefetch(long offset, long length) throws IOException {
                try {
    private void withOptionalLock(IORunnable operation) throws IOException {
                fileCache.put(
    (since we iterate over a copy of the clone map) and the entry won't be switched and will always remain as a full file.
            this.sharedLock = sharedLock;
        return withOptionalLock(() -> underlyingIndexInput.get().readInt());
            objectLock.unlock();
import org.opensearch.threadpool.ThreadPool;
    @Override
                try {
            operation.run();
            }
            switchableFilePath,
        ThreadPool threadPool,
    public long readLong() throws IOException {
                    throw new RuntimeException(e);
    This lock variable has been intentionally not kept final as we are overwriting this in tests
                    return clonedIndexInput;
        Path switchableFilePath,
 * Depending upon the constructor param we either initialize the local or remote based index input and make the underlying index input point to it
    }
            });
                        transferManager,
                        remoteDirectory,
                        hasSwitchedToRemote,
    public byte readByte() throws IOException {
                        (hasSwitchedToRemote && remoteIndexInput.get() != null)
    @Override
                fileCache.incRef(switchableFilePath);
 * In Directory itself we create a switchable entry when we are writing to the directory
    private final ConcurrentMap<SwitchableIndexInput, Boolean> clones;
                        (!hasSwitchedToRemote && localIndexInput.get() != null)
            objectLock.lock();
        this.threadPool = threadPool;
    protected ReadWriteLock sharedLock;
}
            } else {
                        "SwitchableIndexInput Slice " + sliceDescription + "(path=" + fullFilePath.toString() + ")\"",
        String resourceDescription,
    private static final Logger logger = LogManager.getLogger(SwitchableIndexInput.class);
    Each instance of IndexInput will have its own copy of this lock
                            c.switchToRemote();
            return withOptionalLock(() -> {
            fullFilePath,
            return operation.get();
    @Override
        FileCache fileCache,
    public void close() throws IOException {
                        } catch (IOException e) {
    }
        ThreadPool threadPool,
        sharedLock.readLock().lock();
        Path fullFilePath,
        }
    }
    private final RemoteSegmentStoreDirectory remoteDirectory;
            offset,
        this.isClone = isClone;
        this(
                     Further since we are using a Wrapper on top of SwitchableIndexInput which is using a Cleaner,
            transferManager,
                    new CachedFullFileIndexInput(fileCache, fullFilePath, localDirectory.openInput(fileName, IOContext.DEFAULT))
        RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()
        IndexInput clonedRemoteIndexInput,
        this.hasSwitchedToRemote = cacheFromRemote;
        this.fullFilePath = fullFilePath;
            .get(fileName);
                if (isClone) remoteIndexInput.get().seek(localIndexInput.getFilePointer());
    private final Path fullFilePath;
    protected IndexInput getRemoteIndexInput() {
                     close will automatically be called once object is phantom reachable
                    slicedIndexInput.seek(0);
                        fileCache,
    public void readBytes(byte[] b, int offset, int len) throws IOException {
    That is the reason we have used a ReadWriteLock here - we take write lock when we want to perform switchToRemote and read lock for cloning/slicing
    }
        }
            null,
    }
    }
        });
import java.util.concurrent.locks.ReadWriteLock;
    }
import org.opensearch.index.store.remote.filecache.FileCache;
                        transferManager,
                }
    private void validateFilePresentInRemote() {
        } finally {
    public short readShort(long pos) throws IOException {
            return operation.get();
                        threadPool,
                        tieredStoragePrefetchSettingsSupplier
    private final AtomicReference<IndexInput> underlyingIndexInput = new AtomicReference<>();
package org.opensearch.storage.indexinput;
    }
    }
                );
        this.switchableFilePath = switchableFilePath;
            return withOptionalLock(() -> {
                remoteIndexInput.set(getRemoteIndexInput());
    private volatile boolean cachedFromRemote;
    @Override
                        fileCache,
        );
    @Override
                if (localIndexInput.get() != null) localIndexInput.get().close();
                        fileName,
                        "SwitchableIndexInput Clone (path=" + fullFilePath.toString() + ")\"",
                if (isClone) {
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readInt(pos));
        try {
import java.util.concurrent.locks.ReentrantReadWriteLock;
    public int readVInt() throws IOException {
        } else {
            null,
 *
            false,
                underlyingIndexInput.set(remoteIndexInput.get());
        this.localDirectory = localDirectory;
        IndexInput clonedLocalIndexInput,
        } finally {
        if (hasSwitchedToRemote) {
        TransferManager transferManager,
                            : null,
        return indexInput;
                IndexInput localIndexInput = underlyingIndexInput.get();
            transferManager,
            null
    The reason is that whenever we do a clone/slice operation we update the clone map that we maintain, and in switchToRemote we iterate through the map
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
    @Override
        Path fullFilePath,
            return;
        boolean isClone,
        if (hasSwitchedToRemote) {
    private final String fileName;
import java.nio.file.Path;
                }
    @Override
import org.opensearch.index.store.StoreFileMetadata;
    public long readVLong() throws IOException {
        sharedLock.writeLock().lock();
        withOptionalLock(() -> {
    private interface ThrowingSupplier<T, E extends Exception> {
                    clones.put(clonedIndexInput, true);
                    fullFilePath,
            resourceDescription,
            fileCache,
    }
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
                        clones,
    /**
            }
            });
    }
            "Remote Index Input",
import java.util.concurrent.atomic.AtomicReference;
        fileCache.decRef(fullFilePath);
    @Override
    public IndexInput getUnderlyingIndexInput() {
    ) throws IOException {
            this.clones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
                underlyingIndexInput.set(localIndexInput.get());
                    clones.put(slicedIndexInput, true);
    public SwitchableIndexInput slice(String sliceDescription, long offset, long length) {
    private volatile boolean isClosed;
                } else {
                     We do not close the clones as it may cause deadlocks - between index-input-cleaner thread and thread which calls composite directory delete
    @Override
            tieredStoragePrefetchSettingsSupplier
                        fullFilePath,
        if (!isClone) {
            cacheFromRemote ? remoteDirectory.fileLength(fileName) : localDirectory.fileLength(fileName),
            }
import org.opensearch.index.store.remote.filecache.CachedFullFileIndexInput;
                        }
    ) throws IOException {
                        try {
        FSDirectory localDirectory,
                    clones.keySet().forEach(c -> {
    }
    }
                validateFilePresentInRemote();
import org.apache.lucene.util.Version;
                            logger.error("Failed to switch IndexInput to remote - " + c, e);
                isClosed = true;
            threadPool,
        IndexInput indexInput = fileCache.get(fullFilePath).getIndexInput();
    This lock is shared between the original index input and all of its clones/slices
        }
        return underlyingIndexInput.get();
        return withOptionalLock(() -> underlyingIndexInput.get().getFilePointer());
     */
        } finally {
import org.apache.logging.log4j.LogManager;
    }
            0,
                hasSwitchedToRemote = true;
        );
                        (hasSwitchedToRemote && remoteIndexInput.get() != null) ? remoteIndexInput.get().clone() : null,
        return cachedFromRemote;
                remoteIndexInput.set(clonedRemoteIndexInput);
import org.apache.lucene.store.RandomAccessInput;
                    /*
                            ? remoteIndexInput.get().slice(sliceDescription, offset, length)
    }
                remoteIndexInput.set(getRemoteIndexInput());
        return withOptionalLock(() -> underlyingIndexInput.get().readLong());
                        fileName,
                    SwitchableIndexInput slicedIndexInput = new SwitchableIndexInput(
        } finally {
        try {
        }
    // constructor for original index input
        } finally {
    public void seek(long pos) throws IOException {
        return withOptionalLock(() -> underlyingIndexInput.get().readShort());
        this.underlyingIndexInput.get().prefetch(offset, length);
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readShort(pos));
                if (isClosed || hasSwitchedToRemote) return;
            objectLock.unlock();
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
                } catch (IOException e) {
        TransferManager transferManager,
            fileCache,
                underlyingIndexInput.set(localIndexInput.get());
    public int readInt(long pos) throws IOException {
                        tieredStoragePrefetchSettingsSupplier
    public int readInt() throws IOException {
        ConcurrentMap<SwitchableIndexInput, Boolean> clones,
    and prevent deadlock occurring due to conflicts between the shared lock and object lock
            tieredStoragePrefetchSettingsSupplier
                        clones,
    }
        }
import java.util.concurrent.locks.ReentrantLock;
    @FunctionalInterface
            } finally {
        super(resourceDescription);
    }
    }
            null,
        withOptionalLock(() -> underlyingIndexInput.get().readBytes(b, offset, len));
                underlyingIndexInput.set(remoteIndexInput.get());
        RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()
        return withOptionalLock(() -> underlyingIndexInput.get().readVLong());
                        this.fileLength,
        this.cachedFromRemote = cacheFromRemote;
    This is to ensure that we do not allow cloning/slicing operations for any of the index inputs when switchToRemote is in progress
 * this file be licensed under the Apache-2.0 license or a
    }
            if (!hasSwitchedToRemote) {
            } else {
                        true,
        withOptionalLock(() -> underlyingIndexInput.get().seek(pos));
    /*
                if (!isClone) {
            if (!isClosed) {
    public SwitchableIndexInput(
    }
                underlyingIndexInput.set(remoteIndexInput.get());
        String fileName,
     * Used only for testing
    public void switchToRemote() throws IOException, IllegalStateException {
            null,
 * If Switchable Index Input hasn't switched we add one more entry _0.cfs pointing to the full file
                        sharedLock,
                localIndexInput.close();
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            if (!cacheFromRemote) {
    }
    private volatile boolean hasSwitchedToRemote;
    private final long offset;
    // constructor for clones/slices
                            : null,
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readByte(pos));
        if (uploadedSegmentMetadata == null) {
    private final boolean isClone;
    @Override
        try {
        }
                    SwitchableIndexInput clonedIndexInput = new SwitchableIndexInput(
    private final ThreadPool threadPool;
import org.apache.lucene.store.IndexInput;
    public SwitchableIndexInput clone() {
            sharedLock.writeLock().unlock();
                        fullFilePath,
        FSDirectory localDirectory,
            fileName,
 * E.g, if filename is _0.cfs, after we have written the file locally, we add an entry _0.cfs_switchable which points to the SwitchableIndexInput we create
    private final Path switchableFilePath;
    private final AtomicReference<IndexInput> remoteIndexInput = new AtomicReference<>();
                        (!hasSwitchedToRemote && localIndexInput.get() != null) ? localIndexInput.get().clone() : null,
        }
            false,
        ReadWriteLock sharedLock,
 * IndexInput that provides a hook for switching from full file based local index input to block based remote index input
        this.fileName = fileName;
                        localDirectory,
import org.apache.lucene.store.IOContext;
            fileName,
                    clones.remove(this);
                }
            this.sharedLock = new ReentrantReadWriteLock();
    // Visible for testing
                    clones.clear();
    SwitchableIndexInput(
            sharedLock.readLock().unlock();
 * Note that the Directory is only concerned about the switchable entry in FileCache while the SwitchableIndexInput handles the full file and block file entries
        return withOptionalLock(() -> underlyingIndexInput.get().readByte());
    @Override
        try {
                    );
    }
                    throw new RuntimeException(e);
    @Override
                    fileCache.decRef(switchableFilePath);
import org.apache.lucene.util.IORunnable;
        long offset,
    @Override
                localIndexInput.set(getLocalIndexInput());
        return withOptionalLock(() -> underlyingIndexInput.get().readVInt());
                objectLock.unlock();
    This lock variable has been intentionally not kept final as we are overwriting this in tests
    @Override
            fileInfo,
 */
                        length,
            try {
public class SwitchableIndexInput extends IndexInput implements Runnable, RandomAccessInput {
    public void run() {
                    });
        FileCache fileCache,
 * SPDX-License-Identifier: Apache-2.0
                        sharedLock,
                     */
     *
        return new OnDemandPrefetchBlockSnapshotIndexInput(
 * The OpenSearch Contributors require contributions made to
        RemoteSegmentStoreDirectory remoteDirectory,
        this.offset = offset;
        Path switchableFilePath,
    }
    public byte readByte(long pos) throws IOException {
            operation.run();
        objectLock.lock();
/**
            localDirectory,
    }
import java.util.concurrent.ConcurrentMap;
            logger.error("Error while cleaning up Switchable Index Input", e);
    public long getFilePointer() {
            this.clones = clones;
                    return slicedIndexInput;
    }
    protected Lock objectLock;
    protected IndexInput getLocalIndexInput() throws IOException {
                        this.offset + offset,
    We have created a separate lock instead of making each function synchronised to maintain ordering of lock acquisition
        this.remoteDirectory = remoteDirectory;
            remoteDirectory,
        }
    If while switching any entry is cloned/sliced (or vice-versa, while cloning/slicing switch is called), race conditions might occur
            localDirectory,
                        threadPool,
        RemoteSegmentStoreDirectory remoteDirectory,
        sharedLock.readLock().lock();
                    clonedIndexInput.seek(getFilePointer());
        boolean cacheFromRemote,
    private <T, E extends Exception> T withOptionalLock(ThrowingSupplier<T, E> operation) throws E {
/*
                        this.offset,
                localIndexInput.set(clonedLocalIndexInput);
 */
            .get(fileName);
            cacheFromRemote,
    public long length() {
        }
        boolean cacheFromRemote,
                        true,
    private final AtomicReference<IndexInput> localIndexInput = new AtomicReference<>();
        objectLock.lock();
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        this.fileCache = fileCache;
    Similarly when cloning/slicing is in progress for any of the index inputs, switchToRemote will have to wait, but additional cloning/slicing operations can function
        this.isClosed = false;
            }
    private final FSDirectory localDirectory;
                            ? localIndexInput.get().slice(sliceDescription, offset, length)
    }
    private final long fileLength;
import org.apache.lucene.store.FSDirectory;
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
                        remoteDirectory,
                if (remoteIndexInput.get() != null) remoteIndexInput.get().close();
        long fileLength,
    // Visible for testing
    @Override
        this.fileLength = fileLength;
        this.objectLock = new ReentrantLock();
    private final TransferManager transferManager;
                        localDirectory,
        this.transferManager = transferManager;
            sharedLock.readLock().unlock();
 * compatible open source license.
                } catch (IOException e) {
    }
        }
        try {
import java.util.function.Supplier;
        } catch (Exception e) {
    /*
        return hasSwitchedToRemote;
    }
 * If Switchable Index Input has switched we add block entries such as _0.cfs_block_0 pointing to the block files
 *
        BlobStoreIndexShardSnapshot.FileInfo fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
import org.apache.logging.log4j.Logger;
        return withOptionalLock(() -> underlyingIndexInput.get().length());
            threadPool,
                        switchableFilePath,
            fileLength,
    @Override
     */
            new StoreFileMetadata(fileName, uploadedSegmentMetadata.getLength(), uploadedSegmentMetadata.getChecksum(), Version.LATEST),
import org.opensearch.index.store.remote.utils.TransferManager;
    }
    }
        T get() throws E;
                fileCache.incRef(switchableFilePath);
    @Override
    This is to ensure that for an IndexInput we do not allow any two operations to run concurrently
    public short readShort() throws IOException {
        try {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
    public boolean isCachedFromRemote() {
            close();
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
    public long readLong(long pos) throws IOException {
