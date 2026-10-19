            }
     * @param persistedSequenceNumberConsumer a callback that's called whenever an operation with a given sequence number is successfully
     *
            config,
        try (ReleasableLock lock = readLock.acquire()) {
    /**
     * @param deletionPolicy           an instance of {@link TranslogDeletionPolicy} that controls when a translog file can be safely
        final TranslogOperationHelper translogOperationHelper,
            final Path currentCheckpointFile = location.resolve(getCommitCheckpointFileName(checkpoint.generation));
            primaryTermSupplier,
            globalCheckpointSupplier,
            closeOnTragicEvent(ex);
/*
            // file exists. If not we don't even try to clean it up and wait until we fail creating it
            }
        }
        final LongSupplier globalCheckpointSupplier,
 * compatible open source license.
    /**
        }
    public TranslogStats stats() {
        final String translogUUID,
                    current.sync();
        return false;
        );
            this.readers.addAll(recoverFromFiles(checkpoint));
            // https://discuss.elastic.co/t/cannot-recover-index-because-of-missing-tanslog-files/38336 as an example
            translogOperationHelper,
        final ChannelFactory channelFactory
     *                                 deleted
        final LongSupplier primaryTermSupplier,
        final TranslogOperationHelper translogOperationHelper
     * translog file referenced by this generation. The translog creation will fail if this generation can't be opened.
                    checkpoint.globalCheckpoint,
            IOUtils.closeWhileHandlingException(current);
        final LongConsumer persistedSequenceNumberConsumer,
        final LongConsumer persistedSequenceNumberConsumer,
            translogOperationHelper,
        // acquire lock to make the two numbers roughly consistent (no file change half way)
                logger.warn(
import java.io.IOException;
     * @param translogUUID             the translog uuid to open, null for a new translog
        assert Translog.calledFromOutsideOrViaTragedyClose()
            current = null;
            // we just need to cleanup before we continue
                }
 * this file be licensed under the Apache-2.0 license or a
import java.nio.file.Files;
            globalCheckpointSupplier,
    Releasable drainSync() {
        final LongSupplier primaryTermSupplier,
                current = createWriter(
            long uncommittedGen = getMinGenerationForSeqNo(deletionPolicy.getLocalCheckpointOfSafeCommit() + 1).translogFileGeneration;
                    closeFilesIfNoPendingRetentionLocks();
                return current.syncUpTo(location.translogLocation + location.size);
 */
            try (ReleasableLock lock = writeLock.acquire()) {
            // close the opened translog files if we fail to create a new translog...
    @Override
     * Creates a new Translog instance. This method will create a new transaction log unless the given {@link TranslogGeneration} is
            : "Translog.close method is called from inside Translog, but not via closeOnTragicEvent method";
        );
    /**
        try {
                    persistedSequenceNumberConsumer
                ensureOpen();
        final LongSupplier globalCheckpointSupplier,
     */
    public LocalTranslog(
        }
            } finally {
            // the newly written file (generation+1) into the checkpoint. This is still a valid state
                // for instance if we have a lot of tlog and we can't create the writer we keep on holding
    @Override
            if (location.generation == current.getGeneration()) { // if we have a new one it's already synced
    @Override
import org.opensearch.common.util.io.IOUtils;
                success = true;
    }
            null
            channelFactory
            // we hit this before and then blindly deleted the new generation even though we managed to bake it in and then hit this:
            if (readers.isEmpty()) {
            }
                .earliestLastModifiedAge(earliestLastModifiedAge())
        super(
 * @opensearch.internal
     *                                 examined and stored in the header whenever a new generation is rolled. It's guaranteed from outside
        return () -> {}; // noop
        if (closed.compareAndSet(false, true)) {
     * Ensures that the given location has be synced / written to the underlying storage.
            return new TranslogStats.Builder().numberOfOperations(totalOperations())
    }
        }
    }
                // on to all the uncommitted tlog files if we don't close
     * Secondary constructor that does not accept ChannelFactory parameter.
 * A {@link Translog} implementation that creates translog files in local filesystem.
                logger.debug("translog closed");
            persistedSequenceNumberConsumer,
     */
     * generation referenced from already committed data. This means all operations that have not yet been committed should be in the
     */
            // For this to happen we must have already copied the translog.ckp file into translog-gen.ckp so we first check if that
            deletionPolicy,
     *                                        persisted.
        final String translogUUID,
            assert Files.exists(nextTranslogFile) == false || Files.size(nextTranslogFile) <= TranslogHeader.headerSizeInBytes(translogUUID)
 * SPDX-License-Identifier: Apache-2.0
        } catch (Exception e) {
    public boolean ensureSynced(Location location) throws IOException {
        try (ReleasableLock ignored = readLock.acquire()) {
            translogUUID,
            primaryTermSupplier,
                if (success == false) {
 * The OpenSearch Contributors require contributions made to
     * return stats
import org.opensearch.common.util.concurrent.ReleasableLock;
            translogUUID,
     * @param primaryTermSupplier      a supplier for the latest value of primary term of the owning index shard. The latest term value is
     * the generation is not {@code null}, this method tries to open the given translog generation. The generation is treated as the last
     * {@code null}. If the generation is {@code null} this method is destructive and will delete all files in the translog path given. If
        TranslogDeletionPolicy deletionPolicy,
     *
                    checkpoint.generation + 1,
                );
package org.opensearch.index.translog;
            } finally {
}
        } catch (final Exception ex) {
    ) throws IOException {
                throw new IllegalStateException("at least one reader must be recovered");
                .translogSizeInBytes(sizeInBytes())
            }
    }
    public LocalTranslog(
                try {
            // this is special handling for error condition when we create a new writer but we fail to bake
import org.opensearch.common.lease.Releasable;
                .uncommittedOperations(totalOperationsByMinGen(uncommittedGen))
            final Checkpoint checkpoint = readCheckpoint(location);
import java.nio.file.Path;
            deletionPolicy,
     * @return Returns <code>true</code> iff this call caused an actual sync operation otherwise <code>false</code>
            IOUtils.closeWhileHandlingException(readers);
     *                                 and reject operation whose term is higher than the primary term stored in the translog header.
                    IOUtils.closeWhileHandlingException(readers);
     */
            boolean success = false;
            persistedSequenceNumberConsumer,
        this(
     * @param globalCheckpointSupplier a supplier for the global checkpoint
            final Path nextTranslogFile = location.resolve(getFilename(checkpoint.generation + 1));
public class LocalTranslog extends Translog {
            throw ex;
            config,
                        + " tragic exception when creating a new generation",
 */
            }
                .build();
    }
        TranslogDeletionPolicy deletionPolicy,
     * @param config                   the configuration of this translog
        final TranslogConfig config,
/**
    @Override
     *                                 that a new generation is rolled when the term is increased. This guarantee allows to us to validate
 *
                    getMinFileGeneration(),
                && Files.deleteIfExists(nextTranslogFile)) { // delete it and log a warning
                }
    ) throws IOException {
                : "unexpected translog file: [" + nextTranslogFile + "]";
                    nextTranslogFile.getFileName()
            throw e;
            try {
import java.util.function.LongSupplier;
    public void close() throws IOException {
                );
            //
                // we have to close all the recovered ones otherwise we leak file handles here
                    "deleted previously created, but not yet committed, next generation [{}]. This can happen due to a"
    /**
                } finally {
        final TranslogConfig config,
import java.util.function.LongConsumer;
    }
            if (Files.exists(currentCheckpointFile) // current checkpoint is already copied
                .uncommittedSizeInBytes(sizeInBytesByMinGen(uncommittedGen))
