     */  
 * SPDX-License-Identifier: Apache-2.0
     * Issues NoOps for every seqNo gap below {@code maxSeqNo} via {@code handler}, then
        final long maxSeqNo = tracker.getMaxSeqNo();
import org.opensearch.index.seqno.LocalCheckpointTracker;
     * fsyncs the translog.  
/*  
 * {@link InternalEngine} writes a soft-delete tombstone, {@link DataFormatAwareEngine} does
import java.io.IOException;
        for (long seqNo = localCheckpoint + 1; seqNo <= maxSeqNo; seqNo = tracker.getProcessedCheckpoint()  
            + "], max seq no ["
 *
    interface NoOpHandler {  
    /**
 *
    }
 * <p>Caller must hold the engine's write lock for the duration.
 *
            + 1 /* leap-frog the local checkpoint */) {
            + maxSeqNo
 * blocks replication progress.
 * Shared loop that fills gaps in a {@link LocalCheckpointTracker}'s seqNo space by issuing
        throws IOException {
 *  
     * @return the number of NoOps written
        int numNoOpsAdded = 0;
 * The OpenSearch Contributors require contributions made to  
                + "]";
 * this file be licensed under the Apache-2.0 license or a
            + "]";  
                + tracker.getProcessedCheckpoint()
        assert tracker.getPersistedCheckpoint() == maxSeqNo : "persisted local checkpoint did not advance to max seq no; is ["
 * before persisting). Without this step, the local checkpoint stays stuck below maxSeqNo and  
            numNoOpsAdded++;  
 * compatible open source license.
 * post-fill translog sync are identical across both.  
    private SeqNoGapFiller() {}  
 * were assigned but never made it into a durable record (e.g., the previous primary crashed
        void apply(Engine.NoOp noOp) throws IOException;
    }
            assert seqNo <= tracker.getProcessedCheckpoint() : "local checkpoint did not advance; was ["
package org.opensearch.index.engine;
    static int fillGaps(LocalCheckpointTracker tracker, TranslogManager translogManager, long primaryTerm, NoOpHandler handler)
 */  
     *
            + tracker.getPersistedCheckpoint()  
    @FunctionalInterface
 * NoOp operations until the local checkpoint catches up to the max seq no.
 * not (it has no tombstone concept). The loop, leap-frog over the processed checkpoint, and
        final long localCheckpoint = tracker.getProcessedCheckpoint();  
/**  
 * <p>Each engine supplies its own {@link NoOpHandler} so the leaf operation can vary —  
final class SeqNoGapFiller {
 */  
                + seqNo
            handler.apply(new Engine.NoOp(seqNo, primaryTerm, Engine.Operation.Origin.PRIMARY, System.nanoTime(), "filling gaps"));
        return numNoOpsAdded;
                + "], now ["  
}  
import org.opensearch.index.translog.TranslogManager;
        translogManager.syncTranslog(); // persist noops associated with the advancement of the local checkpoint
        }  
 * <p>Used by primary-side engines after a recovery or primary-term bump to plug seqNos that
