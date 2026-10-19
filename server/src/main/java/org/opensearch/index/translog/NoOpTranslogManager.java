    @Override
    private final boolean skipRecoveryStep;
    public void ensureCanFlush() {}  
        Translog.Snapshot emptyTranslogSnapshot  
        ShardId shardId,  
        Runnable ensureOpen,
                throw new TranslogException(shardId, "failed to recover from empty translog snapshot", e);
    public int restoreLocalHistoryFromTranslog(long processedCheckpoint, TranslogRecoveryRunner translogRecoveryRunner) throws IOException {  
    @Override  
        boolean skipRecoveryStep  
        return false;
    }
        return SequenceNumbers.NO_OPS_PERFORMED;  
    }
    @Override
/*  
    @Override
    public Exception getTragicExceptionIfClosed() {  
    public Releasable drainSync() {
        return new Translog.Location(0, 0, 0);
    public Translog.Location getTranslogLastWriteLocation() {
        return 0;
    }  
    public void syncTranslog() throws IOException {}  
    }
import java.io.IOException;  
    public void setMinSeqNoToKeep(long seqNo) {}  
    public void skipTranslogRecovery() {}
import org.opensearch.index.seqno.SequenceNumbers;
    public long getLastSyncedGlobalCheckpoint() {  
            } catch (final Exception e) {  
            try (Translog.Snapshot snapshot = emptyTranslogSnapshot) {
    public Translog.Location add(Translog.Operation operation) throws IOException {
    public void trimUnreferencedTranslogFiles() throws TranslogException {}
    public String getTranslogUUID() {
    @Override
    public long getMaxSeqNo() {
        this.skipRecoveryStep = skipRecoveryStep;  
    }  
        this.translogStats = translogStats;  
        return emptyTranslogSnapshot.totalOperations();
    public void trimUnreferencedReaders() throws IOException {}
 * SPDX-License-Identifier: Apache-2.0
    @Override  
    }
        throw new UnsupportedOperationException("Translog snapshot unsupported with no-op translogs");
    ) throws IOException {
    @Override
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    }
/**  
        throws IOException {
    @Override
    }
        ShardId shardId,
    @Override  
        return translogUUID;
    @Override
    public boolean ensureTranslogSynced(Stream<Translog.Location> locations) {
        this.emptyTranslogSnapshot = emptyTranslogSnapshot;
    @Override
    public NoOpTranslogManager(
    public void close() throws IOException {}  
public class NoOpTranslogManager implements TranslogManager {
    @Override
        return false;  
    }
        return null;  
    @Override
    }
        return 0;
package org.opensearch.index.translog;
    @Override
}
    }  
        return translogStats;
    public void rollTranslogGeneration() throws TranslogException {}
        }  
    }  
        return new Translog.Location(0, 0, 0);  
    public Translog.Operation readOperation(Translog.Location location) throws IOException {
    }
    ) throws IOException {
    public Translog.Snapshot newChangesSnapshot(long fromSeqNo, long toSeqNo, boolean requiredFullRange) throws IOException {  
    public TranslogStats getTranslogStats() {  
        try (ReleasableLock ignored = readLock.acquire()) {
        TranslogStats translogStats,  
        this(shardId, readLock, ensureOpen, translogStats, emptyTranslogSnapshot, "", false);
        return new Translog.TranslogGeneration(translogUUID, 0);
    private final ReleasableLock readLock;
        return false;
        TranslogStats translogStats,
    @Override  
        Runnable ensureOpen,
    @Override
 * @opensearch.internal  
    public NoOpTranslogManager(
    private final TranslogStats translogStats;
    public void trimOperationsFromTranslog(long belowTerm, long aboveSeqNo) throws TranslogException {}  
        return () -> {};  
        if (skipRecoveryStep) {
    }  
    public TranslogDeletionPolicy getDeletionPolicy() {
        return translogDeletionPolicy;  
        Translog.Snapshot emptyTranslogSnapshot,
    }
    @Override  
                translogRecoveryRunner.run(snapshot);
        ReleasableLock readLock,
    private final ShardId shardId;
    @Override
    public Translog.TranslogGeneration getTranslogGeneration() {
    public boolean isTranslogSyncNeeded() {
 *
 */  
import org.opensearch.common.util.concurrent.ReleasableLock;
 */
        this.translogDeletionPolicy = new DefaultTranslogDeletionPolicy(0, 0, 0);
 *
        this.translogUUID = translogUUID;
        ReleasableLock readLock,  
 * The OpenSearch Contributors require contributions made to  
    public void onDelete() {}
    @Override  
        this.ensureOpen = ensureOpen;
    @Override
    @Override
    public boolean shouldPeriodicallyFlush(long localCheckpointOfLastCommit, long flushThreshold) {
        this.shardId = shardId;
import java.util.stream.Stream;
        return false;
    private final String translogUUID;
    }  
    private final Runnable ensureOpen;  
 * compatible open source license.
import org.opensearch.common.lease.Releasable;
    @Override  
import org.opensearch.core.index.shard.ShardId;  
        }  
            return 0;
    }  
    private final TranslogDeletionPolicy translogDeletionPolicy;  
    }
    @Override  
        // skip translog recovery attempt when skipRecoveryStep is true  
    }
            ensureOpen.run();  
            }
    @Override
        String translogUUID,
    @Override  
    @Override
        return null;
    private final Translog.Snapshot emptyTranslogSnapshot;
    }
    public int recoverFromTranslog(TranslogRecoveryRunner translogRecoveryRunner, long localCheckpoint, long recoverUpToSeqNo)
 * The no-op implementation of {@link TranslogManager} that doesn't perform any operation
    @Override
    public boolean shouldRollTranslogGeneration() {
        this.readLock = readLock;  
