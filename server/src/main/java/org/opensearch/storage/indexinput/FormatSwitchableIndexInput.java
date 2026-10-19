     * @param localInput          the initial local IndexInput (already opened)
        this.remoteInputSupplier = null;
        String resourceDescription,
    public FormatSwitchableIndexInput clone() {
    }
 * this file be licensed under the Apache-2.0 license or a
        } finally {
                            ? localIndexInput.get().slice(sliceDescription, offset, length)
            } finally {
        }
        });
            return operation.get();
                // Validate file is present in remote — same guard as SwitchableIndexInput.validateFilePresentInRemote()
                                () -> new org.apache.logging.log4j.message.ParameterizedMessage(
     */
                        }
            }
        }
            this.underlyingIndexInput.set(clonedRemote);
    @Override
                                    fileName
    private final long fileLength;
                if (remoteInput == null) {
                            );
                    throw new IOException("Failed to create remote input for file=" + fileName);
                remoteIndexInput.set(remoteInput);
        this.isClone = false;
            // Supplier-based mode (tests) — skip validation, trust the caller.
                    "Error while cleaning up FormatSwitchableIndexInput for file={}",
import org.apache.lucene.store.RandomAccessInput;
import java.util.concurrent.locks.ReentrantLock;
     *   <li>Clone already closed → skipped during cascade</li>
@ExperimentalApi
    public void close() throws IOException {
            objectLock.lock();
        super(resourceDescription);
        Supplier<IndexInput> remoteInputSupplier,
    @Override
    @Override
     * @param localInput          the initial local IndexInput (already opened)
        this.fileLength = fileLength;
    public void switchToRemote() throws IOException {
import java.util.concurrent.locks.ReadWriteLock;
                    FormatSwitchableIndexInput sliced = new FormatSwitchableIndexInput(
                        try {
        this.underlyingIndexInput.set(localInput);
        IndexInput localInput,
        this.isClosed = false;
    }
    }
        this.sharedLock = sharedLock;
     * @param fileName            the file name (for logging)
     * Creates a new FormatSwitchableIndexInput starting from a local input (supplier-based, for testing).
     * Per-instance lock serializing reads on the same instance.
    /**
import java.util.concurrent.atomic.AtomicReference;
        T get() throws E;
                    throw new RuntimeException(e);
    }
                    fileName
        this.isClosed = false;
                    clones.clear();
        this.clones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
        this.clones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
        this.hasSwitchedToRemote = false;
    @Override
 * <ul>
                }
     *
import java.util.concurrent.locks.Lock;
     * @param remoteDirectory     the remote directory to open remote input from on switch
        IndexInput localInput,
        return withOptionalLock(() -> underlyingIndexInput.get().readInt());
    private interface ThrowingSupplier<T, E extends Exception> {
                    cloned.seek(getFilePointer());
    }
 *       clone/slice (read lock) across the original and all its clones.</li>
     * Write lock: switchToRemote. Read lock: clone/slice.
    private IndexInput getRemoteIndexInput() throws IOException {
    ) {
                e
        } catch (Exception e) {
                } catch (IOException e) {
     */
     */
import org.opensearch.common.annotation.ExperimentalApi;
                if (isClone && oldLocal != null) {
 */
     * Shared lock between original and all clones/slices.
            sharedLock.readLock().unlock();
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readShort(pos));
     * are released even if the caller forgets to call {@link #close()}.
    }
     * Takes the shared write lock — blocks concurrent clone/slice.
                    try {
     */
                        remoteInputSupplier,
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readByte(pos));
            objectLock.unlock();
                            () -> new org.apache.logging.log4j.message.ParameterizedMessage(
                    } catch (Exception e) {
        if (hasSwitchedToRemote) {
    }
        this.sharedLock = new ReentrantReadWriteLock();
    public byte readByte() throws IOException {
                                    "Failed to switch clone to remote for file={}",
                IndexInput oldLocal = underlyingIndexInput.get();
    @Override
import java.util.concurrent.ConcurrentMap;
        this.remoteInputSupplier = remoteInputSupplier;
 * from local to remote without FileCache.
    public boolean hasSwitchedToRemote() {
    private final RemoteSegmentStoreDirectory remoteDirectory;
                    throw new RuntimeException(e);
                underlyingIndexInput.set(remoteInput);
        this.isClosed = false;
                        remoteDirectory,
 *
                        remoteInputSupplier,
import java.io.IOException;
        this.fileName = fileName;
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readInt(pos));
    public int readInt(long pos) throws IOException {
                        (hasSwitchedToRemote == false && localIndexInput.get() != null) ? localIndexInput.get().clone() : null,
 * supplied factory (typically {@code remoteDirectory.openInput}).
                if (isClosed || hasSwitchedToRemote) return;
    public void seek(long pos) throws IOException {
import org.apache.logging.log4j.Logger;
                                ),
 *   <li>A per-instance {@link Lock} serializes concurrent reads on the same
        try {
        try {
     * @throws IllegalStateException if the file is not present in remote
    private volatile boolean hasSwitchedToRemote;
        withOptionalLock(() -> underlyingIndexInput.get().seek(pos));
                    }
        this.isClone = true;
     * @param resourceDescription description for debugging
                        );
    private ReadWriteLock sharedLock;
                // Swap the delegate — all subsequent reads go to remote.
                        logger.debug(
        long fileLength,
     * Invoked when the object becomes phantom-reachable — ensures resources
        try {
                // Preserve file pointer position across the switch.
    }
            });
        RemoteSegmentStoreDirectory remoteDirectory
     *   <li>Already switched or closed → no-op</li>
        this.sharedLock = new ReentrantReadWriteLock();
        this.fileLength = localInput.length();
    /**
            sharedLock.writeLock().unlock();
    @Override
        this.remoteInputSupplier = remoteInputSupplier;
                try {
 * The OpenSearch Contributors require contributions made to
            return remoteInputSupplier.get();
    /**
        ReadWriteLock sharedLock
                        fileLength,
            objectLock.unlock();
    private final ConcurrentMap<FormatSwitchableIndexInput, Boolean> clones;
    @Override
        if (remoteInputSupplier != null) {
                if (oldLocal != null) {
    }
     * No-op if already switched or closed.
    public FormatSwitchableIndexInput(
            sharedLock.readLock().unlock();
    public void prefetch(long offset, long length) throws IOException {
    @Override
     *   <li>Clone switch fails → logged, other clones still switched, exception not propagated</li>
        String fileName,
     */
            }
     * @param resourceDescription description for debugging
        sharedLock.readLock().lock();
            return remoteDirectory.openInput(fileName, IOContext.DEFAULT);
     * Bypassed once switched (volatile fast-path).
            this.remoteIndexInput.set(clonedRemote);
                        // Local file may already be deleted — that's fine.
        boolean hasSwitchedToRemote,
                }
 *       instance. Once switched, reads bypass the lock (volatile fast-path).</li>
                if (isClone == false) {
    @Override
                        (hasSwitchedToRemote && remoteIndexInput.get() != null)
    }
     *
     *
    private volatile boolean isClosed;
        underlyingIndexInput.get().prefetch(offset, length);
                IndexInput remoteInput = getRemoteIndexInput();
    }
        }
            return withOptionalLock(() -> {
                                fileName
        this.localIndexInput.set(localInput);
        this.fileName = fileName;
                    FormatSwitchableIndexInput cloned = new FormatSwitchableIndexInput(
     * @param fileName            the file name (for logging and remote lookup)
        return withOptionalLock(() -> underlyingIndexInput.get().readVLong());
 */
        IndexInput clonedLocal,
        } else {
     * Switch all reads (this instance + all clones) to remote.
import org.apache.lucene.store.IndexInput;
                }
        IndexInput clonedRemote,
    }
                    );
    private final AtomicReference<IndexInput> underlyingIndexInput = new AtomicReference<>();
 *
        return withOptionalLock(() -> ((RandomAccessInput) underlyingIndexInput.get()).readLong(pos));
                        "FormatSwitchableIndexInput Clone (file=" + fileName + ")",
    @FunctionalInterface
    @Override
        String fileName,
        this.hasSwitchedToRemote = false;
package org.opensearch.storage.indexinput;
     *   <li>File not present in remote metadata → throws IllegalStateException (same as SwitchableIndexInput)</li>
        } finally {
        this.fileLength = localInput.length();
        super(resourceDescription);
                    return sliced;
        return withOptionalLock(() -> underlyingIndexInput.get().readShort());
    private void withOptionalLock(IORunnable operation) throws IOException {
    @Override
     * </ul>
                }
        RemoteSegmentStoreDirectory remoteDirectory,
     *   <li>oldLocal is null (defensive) → skip seek, skip close</li>
    public int readVInt() throws IOException {
        objectLock.lock();
                        sharedLock
    }
                    clones.remove(this);
        }
        this.fileName = fileName;
        this.localIndexInput.set(localInput);
                hasSwitchedToRemote = true;
    @Override
        }
                    for (FormatSwitchableIndexInput clone : clones.keySet()) {
import java.util.function.Supplier;
        this.underlyingIndexInput.set(localInput);
        throw new IOException("No remote directory or supplier configured for file=" + fileName);
import org.apache.lucene.util.IORunnable;
    }
        return withOptionalLock(() -> underlyingIndexInput.get().readByte());
        }
     * <p>Edge cases handled:
                            ? remoteIndexInput.get().slice(sliceDescription, offset, length)
            throw new IllegalStateException("Cannot switch to remote — file " + fileName + " not present in remote metadata");
                objectLock.unlock();
        this.remoteDirectory = remoteDirectory;
     * Same pattern as .
    }
                        } catch (Exception e) {
            return;
    @Override
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
                    );
 * <p>Mirrors the locking semantics of {@link SwitchableIndexInput}:
    private Lock objectLock;
                        remoteDirectory,
    }
        return withOptionalLock(() -> underlyingIndexInput.get().readVInt());
    }
                }
        }
 *
    }
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.concurrent.ConcurrentCollections;
     * Runnable implementation for use with {@link java.lang.ref.Cleaner}.
                        "FormatSwitchableIndexInput Slice " + sliceDescription + " (file=" + fileName + ")",
    /**
                        clones,
            operation.run();
        }
                // Cascade to all clones (parent only). Each clone switches independently.
        }
        this.objectLock = new ReentrantLock();
    }
    @Override
                if (localIndexInput.get() != null) localIndexInput.get().close();
                    return cloned;
    /**
                // Create remote input — if this fails, state is unchanged (still on local).
        return fileLength;
        return withOptionalLock(() -> underlyingIndexInput.get().getFilePointer());
    @Override
    ) {
                        sharedLock
    private final boolean isClone;
                            logger.error(
                    clones.put(sliced, true);
    }
    public byte readByte(long pos) throws IOException {
 * </ul>
    }
    public void run() {
                            e
                    remoteInput.seek(oldLocal.getFilePointer());
            try {
 * A switchable IndexInput for format files (e.g., parquet) that can transition
                        hasSwitchedToRemote,
    /**
     * @param remoteInputSupplier supplier that creates the remote IndexInput on demand
        this.objectLock = new ReentrantLock();
            this.underlyingIndexInput.set(clonedLocal);
                }
import java.util.concurrent.locks.ReentrantReadWriteLock;
     * Returns true if this input has been switched to remote.
                                e
                        clones,
     * Creates the remote IndexInput. Uses remoteDirectory if available (production),
        Supplier<IndexInput> remoteInputSupplier
        sharedLock.writeLock().lock();
        this.clones = clones;
        String resourceDescription,
                }
            return;
    /**
                        hasSwitchedToRemote,
    }
    private FormatSwitchableIndexInput(
        } finally {
            operation.run();
    public int readInt() throws IOException {
        try {
     */
        objectLock.lock();
    /**
        }
    @Override
 *   <li>A shared {@link ReadWriteLock} coordinates switch (write lock) with
        if (remoteDirectory == null) {
     * Clone/slice constructor — shares sharedLock and clones map with the original.
        String resourceDescription,
                    }
    public long length() {
     *   <li>oldLocal.close() throws → logged, switch still completes</li>
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
     *   <li>Remote input creation fails → exception propagated, state unchanged (still on local)</li>
                } else {
                            : null,
                            : null,
        if (hasSwitchedToRemote == false) {
    ) {
    }
                if (remoteIndexInput.get() != null) remoteIndexInput.get().close();
                                "Failed to close local input during switch for file={}",
     */
                } catch (IOException e) {
    // -- withOptionalLock helpers (same pattern as SwitchableIndexInput) ------
    @Override
                        (hasSwitchedToRemote == false && localIndexInput.get() != null)
    public long readVLong() throws IOException {
            });
    }
 * block-based remote reads. The remote input is obtained directly from the
                validateFilePresentInRemote();
        this.remoteDirectory = remoteDirectory;
        } finally {
        try {
                        oldLocal.close();
    }
    public long readLong(long pos) throws IOException {
        }
    public long getFilePointer() {
                if (isClone) {
    }
        withOptionalLock(() -> {
        }
 * @opensearch.experimental
                try {
    }
     * <ul>
            return withOptionalLock(() -> {
     * Validates that the file exists in remote metadata before switching.
        return hasSwitchedToRemote;
                        length,
        if (remoteDirectory.getExistingRemoteFilename(fileName) == null) {
 * <p>Unlike {@link SwitchableIndexInput}, this does NOT use FileCache or
    /**
    private final Supplier<IndexInput> remoteInputSupplier;
                            ),
        if (remoteDirectory != null) {
    private final AtomicReference<IndexInput> remoteIndexInput = new AtomicReference<>();
import org.apache.logging.log4j.LogManager;
    @Override
    @Override
                            // Clone may be closed or supplier may fail for clone — log and continue.
     * Creates a new FormatSwitchableIndexInput starting from a local input.
        ConcurrentMap<FormatSwitchableIndexInput, Boolean> clones,
                        fileName,
                            clone.switchToRemote();
     * falls back to supplier (tests).
            return operation.get();
                // Close old local input — release file handle.
        return withOptionalLock(() -> underlyingIndexInput.get().readLong());
                        fileName,
        try {
        if (hasSwitchedToRemote) {
                    clones.put(cloned, true);
    public void readBytes(byte[] b, int offset, int len) throws IOException {
                    sliced.seek(0);
            );
     */
            this.localIndexInput.set(clonedLocal);
        this.remoteDirectory = null;
                        (hasSwitchedToRemote && remoteIndexInput.get() != null) ? remoteIndexInput.get().clone() : null,
    public long readLong() throws IOException {
     *
    private void validateFilePresentInRemote() {
        sharedLock.readLock().lock();
public class FormatSwitchableIndexInput extends IndexInput implements RandomAccessInput, Runnable {
import org.apache.lucene.store.IOContext;
        withOptionalLock(() -> underlyingIndexInput.get().readBytes(b, offset, len));
    public short readShort(long pos) throws IOException {
     */
        } finally {
        String fileName,
        this.hasSwitchedToRemote = hasSwitchedToRemote;
}
                ),
    }
        }
    public short readShort() throws IOException {
    private <T, E extends Exception> T withOptionalLock(ThrowingSupplier<T, E> operation) throws E {
    private static final Logger logger = LogManager.getLogger(FormatSwitchableIndexInput.class);
 *
/**
        super(resourceDescription);
                isClosed = true;
    private final String fileName;
            logger.error(
    public FormatSwitchableIndexInput(
            if (isClosed == false) {
/*
            close();
                () -> new org.apache.logging.log4j.message.ParameterizedMessage(
        this.objectLock = new ReentrantLock();
        this.isClone = false;
     */
 * compatible open source license.
    /**
    private final AtomicReference<IndexInput> localIndexInput = new AtomicReference<>();
