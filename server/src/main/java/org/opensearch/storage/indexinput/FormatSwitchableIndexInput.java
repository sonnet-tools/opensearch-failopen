    }  
        this.fileLength = localInput.length();
            return operation.get();  
                    throw new IOException("Failed to create remote input for file=" + fileName);  
    }  
    private FormatSwitchableIndexInput(
        return hasSwitchedToRemote;  
        IndexInput localInput,
        if (hasSwitchedToRemote) {
     *  
        if (remoteDirectory.getExistingRemoteFilename(fileName) == null) {
        IndexInput clonedLocal,  
 * @opensearch.experimental  
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readLong(pos));
        return withOptionalLock(() -> underlyingIndexInput.get().readLong());
 * block-based remote reads. The remote input is obtained directly from the  
    }
                } else {
        long fileLength,
    @Override  
    private final AtomicReference<IndexInput> localIndexInput = new AtomicReference<>();
        this.localIndexInput.set(localInput);
    }  
    public int readInt(long pos) throws IOException {
    private Lock objectLock;
        RemoteSegmentStoreDirectory remoteDirectory,  
                        sharedLock  
        this.remoteInputSupplier = remoteInputSupplier;  
        sharedLock.writeLock().lock();  
    private volatile boolean isClosed;  
    /**
import java.util.concurrent.locks.ReentrantReadWriteLock;
        this.localIndexInput.set(localInput);
                    throw new RuntimeException(e);
    private volatile boolean hasSwitchedToRemote;
import org.apache.lucene.store.RandomAccessInput;
        sharedLock.readLock().lock();  
            sharedLock.writeLock().unlock();
                        // Local file may already be deleted — that's fine.  
        }
            }
        }
            });
        }
 * <p>Mirrors the locking semantics of {@link SwitchableIndexInput}:  
        if (remoteInputSupplier != null) {
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readByte(pos));
    }
        this.isClone = false;
            this.underlyingIndexInput.set(clonedRemote);  
            } finally {  
    private IndexInput getRemoteIndexInput() throws IOException {
/**
 * this file be licensed under the Apache-2.0 license or a
     *   <li>Already switched or closed → no-op</li>
            logger.error(  
    private ReadWriteLock sharedLock;
                        (hasSwitchedToRemote && remoteIndexInput.get() != null) ? remoteIndexInput.get().clone() : null,  
        this.sharedLock = new ReentrantReadWriteLock();
    // -- withOptionalLock helpers (same pattern as SwitchableIndexInput) ------
     * are released even if the caller forgets to call {@link #close()}.
    /**
    private final long fileLength;
    @Override
        this.isClosed = false;
     * Clone/slice constructor — shares sharedLock and clones map with the original.  
     * @param localInput          the initial local IndexInput (already opened)  
    @Override  
    public long readLong() throws IOException {
                        fileLength,
        } finally {
     * No-op if already switched or closed.
        return withOptionalLock(() -> underlyingIndexInput.get().readByte());  
                            logger.error(
        throw new IOException("No remote directory or supplier configured for file=" + fileName);
    public void run() {
    public short readShort(long pos) throws IOException {  
        if (hasSwitchedToRemote) {
        boolean hasSwitchedToRemote,
            return;
    }
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        this.sharedLock = new ReentrantReadWriteLock();
        String fileName,
 * A switchable IndexInput for format files (e.g., parquet) that can transition  
        ReadWriteLock sharedLock  
        this.fileLength = localInput.length();
            objectLock.lock();
    }
                    try {  
                    FormatSwitchableIndexInput cloned = new FormatSwitchableIndexInput(
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.LogManager;
        return withOptionalLock(() -> underlyingIndexInput.get().readShort());
    public long getFilePointer() {
                }
        Supplier<IndexInput> remoteInputSupplier  
        objectLock.lock();
        return withOptionalLock(() -> underlyingIndexInput.get().readInt());  
        this.isClosed = false;  
                } catch (IOException e) {
     * @param remoteDirectory     the remote directory to open remote input from on switch
                                    "Failed to switch clone to remote for file={}",
    }  
    private interface ThrowingSupplier<T, E extends Exception> {
            objectLock.unlock();  
                    clones.put(cloned, true);
    @Override
     * Bypassed once switched (volatile fast-path).  
                            ? localIndexInput.get().slice(sliceDescription, offset, length)  
                    sliced.seek(0);
                        "FormatSwitchableIndexInput Slice " + sliceDescription + " (file=" + fileName + ")",
                    clones.remove(this);
     * @param fileName            the file name (for logging and remote lookup)
     */  
    }
/*  
     * Creates the remote IndexInput. Uses remoteDirectory if available (production),
     */
 * supplied factory (typically {@code remoteDirectory.openInput}).
    private final AtomicReference<IndexInput> remoteIndexInput = new AtomicReference<>();  
    /**
        super(resourceDescription);
                    remoteInput.seek(oldLocal.getFilePointer());
    public long readLong(long pos) throws IOException {
        if (remoteDirectory != null) {
    private final boolean isClone;
        try {  
            this.localIndexInput.set(clonedLocal);
     *
import java.util.concurrent.locks.ReentrantLock;
        this.fileName = fileName;  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
        objectLock.lock();
 *   <li>A shared {@link ReadWriteLock} coordinates switch (write lock) with
        }  
     * @param resourceDescription description for debugging
        this.sharedLock = sharedLock;
        this.clones = clones;  
            return remoteDirectory.openInput(fileName, IOContext.DEFAULT);  
    @Override  
    public void prefetch(long offset, long length) throws IOException {  
                                ),  
            }  
    public long readVLong() throws IOException {
    }  
        this.objectLock = new ReentrantLock();
     * Switch all reads (this instance + all clones) to remote.
                if (remoteInput == null) {
            // Supplier-based mode (tests) — skip validation, trust the caller.
                        clones,
        underlyingIndexInput.get().prefetch(offset, length);
                    for (FormatSwitchableIndexInput clone : clones.keySet()) {  
        try {
    private static final Logger logger = LogManager.getLogger(FormatSwitchableIndexInput.class);
                            // Clone may be closed or supplier may fail for clone — log and continue.
        } finally {
                                () -> new org.apache.logging.log4j.message.ParameterizedMessage(  
    @Override  
        }
        this.remoteDirectory = null;
                isClosed = true;
            operation.run();
     */
                    FormatSwitchableIndexInput sliced = new FormatSwitchableIndexInput(
     * </ul>  
    ) {
     * Per-instance lock serializing reads on the same instance.
        return withOptionalLock(() -> underlyingIndexInput.get().readVLong());  
        this.fileLength = fileLength;
    private final ConcurrentMap<FormatSwitchableIndexInput, Boolean> clones;
        this.remoteInputSupplier = null;
            operation.run();
            this.remoteIndexInput.set(clonedRemote);
                    } catch (Exception e) {
    @Override
        this.remoteDirectory = remoteDirectory;  
                        remoteInputSupplier,  
    /**
        this.remoteInputSupplier = remoteInputSupplier;  
                        hasSwitchedToRemote,
            close();
                            e  
        this.hasSwitchedToRemote = hasSwitchedToRemote;  
     * Takes the shared write lock — blocks concurrent clone/slice.  
    @FunctionalInterface
                        remoteDirectory,
                if (isClone) {  
        this.underlyingIndexInput.set(localInput);  
                                "Failed to close local input during switch for file={}",  
                if (remoteIndexInput.get() != null) remoteIndexInput.get().close();
                if (localIndexInput.get() != null) localIndexInput.get().close();
import org.opensearch.common.annotation.ExperimentalApi;
        this.objectLock = new ReentrantLock();
            if (isClosed == false) {  
 *       instance. Once switched, reads bypass the lock (volatile fast-path).</li>
                                fileName
import java.util.concurrent.locks.Lock;
                // Close old local input — release file handle.
                            : null,
                        hasSwitchedToRemote,
    }
    }  
     */
    /**
        }
     *   <li>oldLocal.close() throws → logged, switch still completes</li>
        super(resourceDescription);  
     *   <li>File not present in remote metadata → throws IllegalStateException (same as SwitchableIndexInput)</li>  
                        length,
            return operation.get();
                // Swap the delegate — all subsequent reads go to remote.
     * Creates a new FormatSwitchableIndexInput starting from a local input (supplier-based, for testing).
    @Override
                        }  
        if (remoteDirectory == null) {  
        this.hasSwitchedToRemote = false;
    private <T, E extends Exception> T withOptionalLock(ThrowingSupplier<T, E> operation) throws E {
     * Same pattern as .
    /**  
    }
     * @param fileName            the file name (for logging)
                if (oldLocal != null) {
     *   <li>oldLocal is null (defensive) → skip seek, skip close</li>
                    clones.clear();  
     *   <li>Clone already closed → skipped during cascade</li>
                            );
            sharedLock.readLock().unlock();
        try {
     * @throws IllegalStateException if the file is not present in remote  
     */  
        T get() throws E;  
                objectLock.unlock();
     * Runnable implementation for use with {@link java.lang.ref.Cleaner}.  
 * compatible open source license.
     * Validates that the file exists in remote metadata before switching.  
                        sharedLock
     * @param resourceDescription description for debugging  
            throw new IllegalStateException("Cannot switch to remote — file " + fileName + " not present in remote metadata");
    public void close() throws IOException {
                        (hasSwitchedToRemote == false && localIndexInput.get() != null)
                // Create remote input — if this fails, state is unchanged (still on local).  
 */  
    }  
     * Shared lock between original and all clones/slices.
        IndexInput localInput,  
            return;  
        String resourceDescription,  
    @Override
                        (hasSwitchedToRemote == false && localIndexInput.get() != null) ? localIndexInput.get().clone() : null,
                }
    private final RemoteSegmentStoreDirectory remoteDirectory;
        } finally {  
        if (hasSwitchedToRemote == false) {
        withOptionalLock(() -> underlyingIndexInput.get().seek(pos));
                if (isClosed || hasSwitchedToRemote) return;
        return fileLength;  
                        clones,
                IndexInput remoteInput = getRemoteIndexInput();
            objectLock.unlock();  
import java.util.concurrent.locks.ReadWriteLock;  
        RemoteSegmentStoreDirectory remoteDirectory
     *   <li>Remote input creation fails → exception propagated, state unchanged (still on local)</li>
            return withOptionalLock(() -> {
                }  
     * falls back to supplier (tests).
                () -> new org.apache.logging.log4j.message.ParameterizedMessage(
        this.isClosed = false;
                hasSwitchedToRemote = true;
                    return sliced;
    }
     * <ul>
                                    fileName
                        (hasSwitchedToRemote && remoteIndexInput.get() != null)
        });
    @Override
     */
    public long length() {
                                e
    public FormatSwitchableIndexInput(  
     * @param localInput          the initial local IndexInput (already opened)
 * <p>Unlike {@link SwitchableIndexInput}, this does NOT use FileCache or
        } finally {
import java.io.IOException;
                        "FormatSwitchableIndexInput Clone (file=" + fileName + ")",
    }
    ) {
        try {
        sharedLock.readLock().lock();  
     * <p>Edge cases handled:  
    /**
    }  
    public byte readByte() throws IOException {
    @Override
                    }
        }
        this.fileName = fileName;
        withOptionalLock(() -> {
    private final Supplier<IndexInput> remoteInputSupplier;
    @Override
                if (isClone == false) {
    }
                }
                    return cloned;  
                }  
        this.remoteDirectory = remoteDirectory;
 *
                        try {
                // Preserve file pointer position across the switch.
        try {  
    private void validateFilePresentInRemote() {
        return withOptionalLock(() -> underlyingIndexInput.get().getFilePointer());
 *
package org.opensearch.storage.indexinput;
                try {  
    private final String fileName;  
        String fileName,
 * SPDX-License-Identifier: Apache-2.0
            });
    }
import org.apache.lucene.util.IORunnable;  
     */
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readInt(pos));  
    }
        super(resourceDescription);
                    cloned.seek(getFilePointer());
        Supplier<IndexInput> remoteInputSupplier,
    public int readVInt() throws IOException {  
            return remoteInputSupplier.get();  
     *
import org.apache.lucene.store.IOContext;  
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readShort(pos));
                        );
            this.underlyingIndexInput.set(clonedLocal);  
    }
    private final AtomicReference<IndexInput> underlyingIndexInput = new AtomicReference<>();
 *
            return withOptionalLock(() -> {
    ) {
                            () -> new org.apache.logging.log4j.message.ParameterizedMessage(
                        remoteInputSupplier,  
        } finally {  
                remoteIndexInput.set(remoteInput);
    public boolean hasSwitchedToRemote() {
        }
        IndexInput clonedRemote,
import org.apache.logging.log4j.Logger;
                e
        } else {
            sharedLock.readLock().unlock();  
public class FormatSwitchableIndexInput extends IndexInput implements RandomAccessInput, Runnable {  
    }
        String fileName,
 * <ul>
                        } catch (Exception e) {  
    }
                underlyingIndexInput.set(remoteInput);
        }
        String resourceDescription,
        }
    public byte readByte(long pos) throws IOException {
        }  
    /**  
     */
     * Returns true if this input has been switched to remote.  
    }
     * Write lock: switchToRemote. Read lock: clone/slice.  
        return withOptionalLock(() -> underlyingIndexInput.get().readVInt());
     *   <li>Clone switch fails → logged, other clones still switched, exception not propagated</li>  
    }
    @Override  
                            : null,
                    );  
    @Override
        }
@ExperimentalApi
        this.isClone = true;
    @Override  
 *   <li>A per-instance {@link Lock} serializes concurrent reads on the same
import java.util.concurrent.ConcurrentMap;  
        this.objectLock = new ReentrantLock();  
                        oldLocal.close();
        this.fileName = fileName;  
                        remoteDirectory,
                            ? remoteIndexInput.get().slice(sliceDescription, offset, length)  
        String resourceDescription,  
        this.hasSwitchedToRemote = false;  
                } catch (IOException e) {
import java.util.function.Supplier;  
        try {  
 * The OpenSearch Contributors require contributions made to  
                            ),
}
                    fileName  
    /**
    public void readBytes(byte[] b, int offset, int len) throws IOException {
                IndexInput oldLocal = underlyingIndexInput.get();
    public FormatSwitchableIndexInput(
    }
    public short readShort() throws IOException {  
                if (isClone && oldLocal != null) {  
                    clones.put(sliced, true);  
        this.isClone = false;
    }
 * </ul>  
                        fileName,  
                        fileName,  
        ConcurrentMap<FormatSwitchableIndexInput, Boolean> clones,
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
     *
                // Cascade to all clones (parent only). Each clone switches independently.
                    throw new RuntimeException(e);  
     * @param remoteInputSupplier supplier that creates the remote IndexInput on demand  
            );  
                        logger.debug(
    private void withOptionalLock(IORunnable operation) throws IOException {  
                }
        } catch (Exception e) {
    @Override
        withOptionalLock(() -> underlyingIndexInput.get().readBytes(b, offset, len));
                    );
    }  
     */
    public void seek(long pos) throws IOException {  
 * from local to remote without FileCache.
 *
                ),
                    }
    public void switchToRemote() throws IOException {
 *       clone/slice (read lock) across the original and all its clones.</li>  
    public FormatSwitchableIndexInput clone() {
     * Invoked when the object becomes phantom-reachable — ensures resources
                    "Error while cleaning up FormatSwitchableIndexInput for file={}",
        }
        this.clones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();  
    @Override
        this.underlyingIndexInput.set(localInput);
     * Creates a new FormatSwitchableIndexInput starting from a local input.
                try {  
                            clone.switchToRemote();
                validateFilePresentInRemote();
    public int readInt() throws IOException {
        this.clones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
    @Override
import org.apache.lucene.store.IndexInput;
    }
 */
            try {  
                }
    @Override
                // Validate file is present in remote — same guard as SwitchableIndexInput.validateFilePresentInRemote()  
     */
    /**
