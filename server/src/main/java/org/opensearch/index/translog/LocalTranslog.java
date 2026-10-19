            primaryTermSupplier,  
                .uncommittedSizeInBytes(sizeInBytesByMinGen(uncommittedGen))  
            long uncommittedGen = getMinGenerationForSeqNo(deletionPolicy.getLocalCheckpointOfSafeCommit() + 1).translogFileGeneration;
            }
                    checkpoint.generation + 1,
        final String translogUUID,
            }  
                return current.syncUpTo(location.translogLocation + location.size);
            try (ReleasableLock lock = writeLock.acquire()) {
            if (Files.exists(currentCheckpointFile) // current checkpoint is already copied
                );
                ensureOpen();  
            }  
 */  
            globalCheckpointSupplier,
            channelFactory  
 * this file be licensed under the Apache-2.0 license or a
                }  
            config,
        this(  
import org.opensearch.common.util.concurrent.ReleasableLock;
            }
            closeOnTragicEvent(ex);
        }  
    public void close() throws IOException {  
            } finally {
import org.opensearch.common.util.io.IOUtils;  
                    getMinFileGeneration(),  
 * SPDX-License-Identifier: Apache-2.0
    /**  
        } catch (final Exception ex) {  
            // we hit this before and then blindly deleted the new generation even though we managed to bake it in and then hit this:  
                .translogSizeInBytes(sizeInBytes())
            persistedSequenceNumberConsumer,  
    ) throws IOException {
                    IOUtils.closeWhileHandlingException(readers);
            this.readers.addAll(recoverFromFiles(checkpoint));  
     * Secondary constructor that does not accept ChannelFactory parameter.
     */
     * translog file referenced by this generation. The translog creation will fail if this generation can't be opened.
}
import java.nio.file.Files;  
            translogUUID,  
     *                                 examined and stored in the header whenever a new generation is rolled. It's guaranteed from outside  
                try {
                logger.debug("translog closed");
            // https://discuss.elastic.co/t/cannot-recover-index-because-of-missing-tanslog-files/38336 as an example
import java.util.function.LongConsumer;
        );
            //
        }
 */
    Releasable drainSync() {
        }  
        final LongConsumer persistedSequenceNumberConsumer,  
 *
 * @opensearch.internal
        super(
            deletionPolicy,
     * @param globalCheckpointSupplier a supplier for the global checkpoint
            // the newly written file (generation+1) into the checkpoint. This is still a valid state
        final LongConsumer persistedSequenceNumberConsumer,  
    @Override  
    ) throws IOException {  
            : "Translog.close method is called from inside Translog, but not via closeOnTragicEvent method";
            }  
                && Files.deleteIfExists(nextTranslogFile)) { // delete it and log a warning
            final Path nextTranslogFile = location.resolve(getFilename(checkpoint.generation + 1));
     * @param persistedSequenceNumberConsumer a callback that's called whenever an operation with a given sequence number is successfully  
    }
                } finally {
        final LongSupplier globalCheckpointSupplier,
            throw ex;
            deletionPolicy,  
        final String translogUUID,
            // close the opened translog files if we fail to create a new translog...
    @Override
                    closeFilesIfNoPendingRetentionLocks();
    @Override
     * generation referenced from already committed data. This means all operations that have not yet been committed should be in the  
    @Override
                    persistedSequenceNumberConsumer
            final Path currentCheckpointFile = location.resolve(getCommitCheckpointFileName(checkpoint.generation));
                    current.sync();  
                .build();
        TranslogDeletionPolicy deletionPolicy,  
     *
        try (ReleasableLock ignored = readLock.acquire()) {
                current = createWriter(
     * Creates a new Translog instance. This method will create a new transaction log unless the given {@link TranslogGeneration} is  
        final LongSupplier primaryTermSupplier,
public class LocalTranslog extends Translog {  
            try {  
/**
                    "deleted previously created, but not yet committed, next generation [{}]. This can happen due to a"
        }  
                if (success == false) {  
            if (readers.isEmpty()) {
     * @param translogUUID             the translog uuid to open, null for a new translog
    }
                logger.warn(  
     * @param deletionPolicy           an instance of {@link TranslogDeletionPolicy} that controls when a translog file can be safely
 * The OpenSearch Contributors require contributions made to  
                    nextTranslogFile.getFileName()  
            globalCheckpointSupplier,
import java.io.IOException;
        final TranslogConfig config,
        );  
     * return stats
    public TranslogStats stats() {
        final LongSupplier primaryTermSupplier,
     */
    /**  
    }
                }
            null
     *                                        persisted.
                // on to all the uncommitted tlog files if we don't close
        try {
     * Ensures that the given location has be synced / written to the underlying storage.
     * @param primaryTermSupplier      a supplier for the latest value of primary term of the owning index shard. The latest term value is
package org.opensearch.index.translog;
            translogUUID,
     * @param config                   the configuration of this translog  
        final TranslogOperationHelper translogOperationHelper,
     * {@code null}. If the generation is {@code null} this method is destructive and will delete all files in the translog path given. If
    public LocalTranslog(  
            // we just need to cleanup before we continue
            // For this to happen we must have already copied the translog.ckp file into translog-gen.ckp so we first check if that  
    public LocalTranslog(  
            persistedSequenceNumberConsumer,
import java.util.function.LongSupplier;  
        } catch (Exception e) {
            boolean success = false;
        TranslogDeletionPolicy deletionPolicy,  
     *                                 that a new generation is rolled when the term is increased. This guarantee allows to us to validate
     * @return Returns <code>true</code> iff this call caused an actual sync operation otherwise <code>false</code>  
    }  
import java.nio.file.Path;
                .uncommittedOperations(totalOperationsByMinGen(uncommittedGen))
        if (closed.compareAndSet(false, true)) {  
            // this is special handling for error condition when we create a new writer but we fail to bake  
                        + " tragic exception when creating a new generation",
            translogOperationHelper,
    /**
            final Checkpoint checkpoint = readCheckpoint(location);  
     *                                 and reject operation whose term is higher than the primary term stored in the translog header.
     *                                 deleted  
        return () -> {}; // noop
            IOUtils.closeWhileHandlingException(readers);
            return new TranslogStats.Builder().numberOfOperations(totalOperations())  
        assert Translog.calledFromOutsideOrViaTragedyClose()
     */
        final ChannelFactory channelFactory
 * A {@link Translog} implementation that creates translog files in local filesystem.  
        final TranslogOperationHelper translogOperationHelper
            if (location.generation == current.getGeneration()) { // if we have a new one it's already synced
                throw new IllegalStateException("at least one reader must be recovered");
 * compatible open source license.
                : "unexpected translog file: [" + nextTranslogFile + "]";  
     *
            IOUtils.closeWhileHandlingException(current);  
                // for instance if we have a lot of tlog and we can't create the writer we keep on holding
            current = null;
    /**
                    checkpoint.globalCheckpoint,
        final TranslogConfig config,
                .earliestLastModifiedAge(earliestLastModifiedAge())
            primaryTermSupplier,
        final LongSupplier globalCheckpointSupplier,
                // we have to close all the recovered ones otherwise we leak file handles here  
     */  
    }
            throw e;
                success = true;
        // acquire lock to make the two numbers roughly consistent (no file change half way)  
        return false;
            config,
            } finally {
                );  
    }
    public boolean ensureSynced(Location location) throws IOException {  
            translogOperationHelper,
            assert Files.exists(nextTranslogFile) == false || Files.size(nextTranslogFile) <= TranslogHeader.headerSizeInBytes(translogUUID)
        try (ReleasableLock lock = readLock.acquire()) {
import org.opensearch.common.lease.Releasable;
     * the generation is not {@code null}, this method tries to open the given translog generation. The generation is treated as the last
            // file exists. If not we don't even try to clean it up and wait until we fail creating it
/*  
