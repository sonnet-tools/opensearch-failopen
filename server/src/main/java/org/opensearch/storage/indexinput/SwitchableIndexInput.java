                     close will automatically be called once object is phantom reachable
    }  
        }
                    );
            transferManager,
            return;
            false,
    @Override
    }
            return operation.get();
                    new CachedFullFileIndexInput(fileCache, fullFilePath, localDirectory.openInput(fileName, IOContext.DEFAULT))  
            null
import java.util.function.Supplier;  
            offset,  
    We have created a separate lock instead of making each function synchronised to maintain ordering of lock acquisition  
            sharedLock.readLock().unlock();  
    public SwitchableIndexInput clone() {
        RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()  
                underlyingIndexInput.set(remoteIndexInput.get());
        this.threadPool = threadPool;  
            close();
            null,
    private volatile boolean hasSwitchedToRemote;
                if (!isClone) {
    public void switchToRemote() throws IOException, IllegalStateException {  
            operation.run();  
                        threadPool,
        }
import org.apache.lucene.store.RandomAccessInput;  
        String resourceDescription,  
import org.apache.lucene.store.IOContext;
    The reason is that whenever we do a clone/slice operation we update the clone map that we maintain, and in switchToRemote we iterate through the map  
                        clones,
        }
        if (!isClone) {  
        this.remoteDirectory = remoteDirectory;  
                            : null,
        this.transferManager = transferManager;
    }
    protected Lock objectLock;
    @Override
        ThreadPool threadPool,  
 */  
    }
                        this.offset,
                localIndexInput.close();
        sharedLock.writeLock().lock();
    }  
    private final AtomicReference<IndexInput> localIndexInput = new AtomicReference<>();
        this.fileName = fileName;
    // constructor for original index input
    public SwitchableIndexInput slice(String sliceDescription, long offset, long length) {
                        tieredStoragePrefetchSettingsSupplier  
                remoteIndexInput.set(getRemoteIndexInput());
    protected IndexInput getRemoteIndexInput() {
    public int readVInt() throws IOException {
        TransferManager transferManager,
                } catch (IOException e) {
        }
            "Remote Index Input",
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
                    return clonedIndexInput;  
                    SwitchableIndexInput slicedIndexInput = new SwitchableIndexInput(
            fileName,
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
            new StoreFileMetadata(fileName, uploadedSegmentMetadata.getLength(), uploadedSegmentMetadata.getChecksum(), Version.LATEST),  
 * SPDX-License-Identifier: Apache-2.0
        super(resourceDescription);
            return withOptionalLock(() -> {
        return withOptionalLock(() -> underlyingIndexInput.get().readLong());
                        clones,  
            this.clones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
    private final long offset;
                        hasSwitchedToRemote,
            fileCache,  
import org.opensearch.index.store.remote.filecache.FileCache;
            null,  
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
                fileCache.incRef(switchableFilePath);  
                localIndexInput.set(getLocalIndexInput());
     * Used only for testing  
            null,
            });
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;  
                underlyingIndexInput.set(localIndexInput.get());  
                    clonedIndexInput.seek(getFilePointer());
    }
                        transferManager,
    private volatile boolean isClosed;
                    /*
    /**
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readInt(pos));
            if (!cacheFromRemote) {  
        } finally {
}  
                        (hasSwitchedToRemote && remoteIndexInput.get() != null) ? remoteIndexInput.get().clone() : null,
                     */  
            objectLock.unlock();
        withOptionalLock(() -> {  
                        threadPool,
import java.util.concurrent.locks.ReentrantReadWriteLock;
    @Override
    }  
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readShort(pos));  
        if (uploadedSegmentMetadata == null) {
                            ? localIndexInput.get().slice(sliceDescription, offset, length)
                        remoteDirectory,  
        this.switchableFilePath = switchableFilePath;
        boolean cacheFromRemote,
            .get(fileName);
        this.underlyingIndexInput.get().prefetch(offset, length);
                localIndexInput.set(clonedLocalIndexInput);  
        TransferManager transferManager,
        T get() throws E;
    public void seek(long pos) throws IOException {
        ConcurrentMap<SwitchableIndexInput, Boolean> clones,
    public long getFilePointer() {  
 * IndexInput that provides a hook for switching from full file based local index input to block based remote index input  
        return withOptionalLock(() -> underlyingIndexInput.get().readShort());  
    }  
                        "SwitchableIndexInput Clone (path=" + fullFilePath.toString() + ")\"",  
        );
            }
                }
                    fileCache.decRef(switchableFilePath);  
    @Override  
        }
                fileCache.put(
    }
        RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()
import org.apache.lucene.store.FSDirectory;  
                        sharedLock,
    }
    public short readShort(long pos) throws IOException {
public class SwitchableIndexInput extends IndexInput implements Runnable, RandomAccessInput {
    (since we iterate over a copy of the clone map) and the entry won't be switched and will always remain as a full file.
    Similarly when cloning/slicing is in progress for any of the index inputs, switchToRemote will have to wait, but additional cloning/slicing operations can function
            return withOptionalLock(() -> {
    @Override  
    SwitchableIndexInput(
    }  
        IndexInput clonedRemoteIndexInput,
        try {
    public short readShort() throws IOException {
     * @return returns underlying index input
    }
                fileCache.incRef(switchableFilePath);  
                    clones.put(clonedIndexInput, true);
        this.localDirectory = localDirectory;
                    slicedIndexInput.seek(0);
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
import org.opensearch.index.store.StoreFileMetadata;  
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
        String fileName,
        return withOptionalLock(() -> underlyingIndexInput.get().readVInt());  
    @Override
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readByte(pos));
    }
        String resourceDescription,  
                     Further since we are using a Wrapper on top of SwitchableIndexInput which is using a Cleaner,
    public void readBytes(byte[] b, int offset, int len) throws IOException {  
    // Visible for testing
    }
            switchableFilePath,
        this.cachedFromRemote = cacheFromRemote;  
    }
            threadPool,
            }
        );
        if (hasSwitchedToRemote) {
 *
        this.objectLock = new ReentrantLock();
        IndexInput clonedLocalIndexInput,  
    public boolean isCachedFromRemote() {
    }  
        IndexInput indexInput = fileCache.get(fullFilePath).getIndexInput();
     */  
        return hasSwitchedToRemote;  
    @Override
            tieredStoragePrefetchSettingsSupplier
                        localDirectory,
    }  
        RemoteSegmentStoreDirectory remoteDirectory,  
    public void close() throws IOException {
        this.isClosed = false;
    }
 */  
    private final ThreadPool threadPool;  
    private void withOptionalLock(IORunnable operation) throws IOException {
 * FileCache Interactions with Switchable Index Input:  
    This lock is shared between the original index input and all of its clones/slices  
            objectLock.lock();  
        objectLock.lock();  
        FileCache fileCache,
    }
import org.apache.lucene.store.IndexInput;
                        fileName,
    public byte readByte(long pos) throws IOException {  
    private final TransferManager transferManager;
            threadPool,
        Path fullFilePath,
        this(  
    }
        long offset,
        try {
                );
    public void prefetch(long offset, long length) throws IOException {  
    @Override
    This is to ensure that we do not allow cloning/slicing operations for any of the index inputs when switchToRemote is in progress
                        fileCache,
        sharedLock.readLock().lock();  
            false,  
    private final Path fullFilePath;
                    fullFilePath,
        try {
        Path switchableFilePath,  
    protected ReadWriteLock sharedLock;
    }  
            fileInfo,
                        (hasSwitchedToRemote && remoteIndexInput.get() != null)  
            fileCache,
            cacheFromRemote,
    public long readLong() throws IOException {  
                objectLock.unlock();  
    Each instance of IndexInput will have its own copy of this lock
    @FunctionalInterface
import java.util.concurrent.locks.Lock;
    public SwitchableIndexInput(
                        length,  
            }
            throw new IllegalStateException("Cannot switch to remote as file " + fileName + " not present in remote");  
    @Override
    @Override  
            null,
            }
    private final ConcurrentMap<SwitchableIndexInput, Boolean> clones;
            if (!hasSwitchedToRemote) {
    and prevent deadlock occurring due to conflicts between the shared lock and object lock
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
                        tieredStoragePrefetchSettingsSupplier
        withOptionalLock(() -> underlyingIndexInput.get().readBytes(b, offset, len));
            });
                        switchableFilePath,  
        FSDirectory localDirectory,
    @Override
    This lock variable has been intentionally not kept final as we are overwriting this in tests  
            resourceDescription,
                        transferManager,
        if (hasSwitchedToRemote) {  
        String fileName,
        } finally {
                        try {
                IndexInput localIndexInput = underlyingIndexInput.get();
        }
    @Override
        } finally {  
import org.apache.logging.log4j.Logger;
                    );  
    This lock variable has been intentionally not kept final as we are overwriting this in tests
import org.apache.lucene.util.IORunnable;
import java.util.concurrent.locks.ReadWriteLock;  
                if (!isClone) fileCache.remove(fullFilePath);
        withOptionalLock(() -> underlyingIndexInput.get().seek(pos));  
    /*  
                        true,
        return indexInput;
            logger.error("Error while cleaning up Switchable Index Input", e);  
    }
            cacheFromRemote ? remoteDirectory.fileLength(fileName) : localDirectory.fileLength(fileName),
    ) throws IOException {
        }  
        this.isClone = isClone;
        return withOptionalLock(() -> underlyingIndexInput.get().readInt());
        objectLock.lock();  
    }
        } catch (Exception e) {
                    return slicedIndexInput;
    }
    }
        FileCache fileCache,
                if (isClosed || hasSwitchedToRemote) return;
import org.opensearch.index.store.remote.filecache.CachedFullFileIndexInput;
 * Depending upon the constructor param we either initialize the local or remote based index input and make the underlying index input point to it
            this.sharedLock = new ReentrantReadWriteLock();
 * compatible open source license.
    public IndexInput getUnderlyingIndexInput() {
                            logger.error("Failed to switch IndexInput to remote - " + c, e);
            localDirectory,  
/**
import org.apache.lucene.util.Version;
    @Override
        ReadWriteLock sharedLock,  
    }  
            try {
            0,  
        });
            if (!isClosed) {
                    throw new RuntimeException(e);  
            localDirectory,  
            fileName,
    }
        );
                        "SwitchableIndexInput Slice " + sliceDescription + "(path=" + fullFilePath.toString() + ")\"",  
package org.opensearch.storage.indexinput;
        boolean cacheFromRemote,
    @Override
                        localDirectory,
                        (!hasSwitchedToRemote && localIndexInput.get() != null) ? localIndexInput.get().clone() : null,  
                if (isClone) {
        this.fileLength = fileLength;  
        }
                        } catch (IOException e) {  
                isClosed = true;  
                hasSwitchedToRemote = true;  
    private void validateFilePresentInRemote() {
    private final AtomicReference<IndexInput> remoteIndexInput = new AtomicReference<>();
    private final FSDirectory localDirectory;  
                if (localIndexInput.get() != null) localIndexInput.get().close();
    private interface ThrowingSupplier<T, E extends Exception> {  
                        fullFilePath,
        this.fullFilePath = fullFilePath;  
    private final boolean isClone;  
        sharedLock.readLock().lock();  
    public void run() {
                        }
    public int readInt() throws IOException {
 * In Directory itself we create a switchable entry when we are writing to the directory
        boolean isClone,
        } finally {  
                        switchableFilePath,  
    If while switching any entry is cloned/sliced (or vice-versa, while cloning/slicing switch is called), race conditions might occur
            operation.run();
                            : null,
    public long length() {
            } finally {
    private final RemoteSegmentStoreDirectory remoteDirectory;
            tieredStoragePrefetchSettingsSupplier  
        BlobStoreIndexShardSnapshot.FileInfo fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
            sharedLock.writeLock().unlock();  
            fullFilePath,  
                if (isClone) remoteIndexInput.get().seek(localIndexInput.getFilePointer());  
        fileCache.decRef(fullFilePath);  
    private volatile boolean cachedFromRemote;  
import org.apache.logging.log4j.LogManager;
        return cachedFromRemote;
import org.opensearch.index.store.remote.utils.TransferManager;  
    // constructor for clones/slices
                     We do not close the clones as it may cause deadlocks - between index-input-cleaner thread and thread which calls composite directory delete  
        this.hasSwitchedToRemote = cacheFromRemote;
                remoteIndexInput.set(getRemoteIndexInput());
    }  
    private final AtomicReference<IndexInput> underlyingIndexInput = new AtomicReference<>();  
                if (remoteIndexInput.get() != null) remoteIndexInput.get().close();  
    That is the reason we have used a ReadWriteLock here - we take write lock when we want to perform switchToRemote and read lock for cloning/slicing  
                try {
                        this.fileLength,  
                        true,
                underlyingIndexInput.set(remoteIndexInput.get());  
                try {
        }
    private static final Logger logger = LogManager.getLogger(SwitchableIndexInput.class);
 * The OpenSearch Contributors require contributions made to  
            } else {
        return withOptionalLock(() -> underlyingIndexInput.get().length());
    /*
    This is to ensure that for an IndexInput we do not allow any two operations to run concurrently
        this.offset = offset;
    public int readInt(long pos) throws IOException {
            sharedLock.readLock().unlock();
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
                }
                    SwitchableIndexInput clonedIndexInput = new SwitchableIndexInput(
                        fileCache,
        return withOptionalLock(() -> underlyingIndexInput.get().readByte());
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readLong(pos));
    @Override
    public long readVLong() throws IOException {
            objectLock.unlock();
            transferManager,
            } else {
 * E.g, if filename is _0.cfs, after we have written the file locally, we add an entry _0.cfs_switchable which points to the SwitchableIndexInput we create
        try {  
                        hasSwitchedToRemote,
        } finally {  
        return underlyingIndexInput.get();
                remoteIndexInput.set(clonedRemoteIndexInput);  
                } catch (IOException e) {
                        fileName,
 * If Switchable Index Input has switched we add block entries such as _0.cfs_block_0 pointing to the block files
                        remoteDirectory,  
        this.fileCache = fileCache;
/*  
                }
            .get(fileName);  
import org.opensearch.threadpool.ThreadPool;
        FSDirectory localDirectory,
    private <T, E extends Exception> T withOptionalLock(ThrowingSupplier<T, E> operation) throws E {
     */  
        ThreadPool threadPool,
        return new OnDemandPrefetchBlockSnapshotIndexInput(  
    private final long fileLength;
    @Override
    @Override
                            ? remoteIndexInput.get().slice(sliceDescription, offset, length)
                underlyingIndexInput.set(remoteIndexInput.get());
                validateFilePresentInRemote();  
    }
                }  
        } else {
                        this.offset + offset,
                        (!hasSwitchedToRemote && localIndexInput.get() != null)  
                    clones.keySet().forEach(c -> {  
    @Override
                    throw new RuntimeException(e);
        long fileLength,  
        try {
        }
        Path switchableFilePath,  
    }
            this.sharedLock = sharedLock;  
    private final Path switchableFilePath;
 *
                    clones.put(slicedIndexInput, true);  
                } else {
    ) throws IOException {  
    // Visible for testing  
                        sharedLock,  
            fileLength,
    @Override  
                underlyingIndexInput.set(localIndexInput.get());
        RemoteSegmentStoreDirectory remoteDirectory,  
import java.nio.file.Path;
import java.util.concurrent.locks.ReentrantLock;
            this.clones = clones;
import java.util.concurrent.atomic.AtomicReference;
     *
    public byte readByte() throws IOException {  
 * Note that the Directory is only concerned about the switchable entry in FileCache while the SwitchableIndexInput handles the full file and block file entries
    private final String fileName;  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
 * If Switchable Index Input hasn't switched we add one more entry _0.cfs pointing to the full file  
                    });  
     */
        try {
                            c.switchToRemote();
        Path fullFilePath,
                        fullFilePath,
    private final FileCache fileCache;  
            remoteDirectory,
    public long readLong(long pos) throws IOException {  
                    clones.clear();
 * this file be licensed under the Apache-2.0 license or a
        return withOptionalLock(() -> underlyingIndexInput.get().getFilePointer());
                    clones.remove(this);
    public boolean hasSwitchedToRemote() {
        return withOptionalLock(() -> underlyingIndexInput.get().readVLong());
    }  
    protected IndexInput getLocalIndexInput() throws IOException {
            return operation.get();
