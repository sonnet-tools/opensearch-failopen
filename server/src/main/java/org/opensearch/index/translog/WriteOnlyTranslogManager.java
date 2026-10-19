    public void skipTranslogRecovery() {  
        String translogUUID,  
import org.opensearch.index.engine.LifecycleAware;  
        LongSupplier primaryTermSupplier,  
    }  
        ReleasableLock readLock,
    }
/***  
        // Do nothing.
    }
        TranslogDeletionPolicy translogDeletionPolicy,
        ShardId shardId,  
    public Translog.Snapshot newChangesSnapshot(long fromSeqNo, long toSeqNo, boolean requiredFullRange) throws IOException {
        return 0;
    public WriteOnlyTranslogManager(
import org.opensearch.core.index.shard.ShardId;
 * The implementation of {@link TranslogManager} that only orchestrates writes to the underlying {@link Translog}
    public int restoreLocalHistoryFromTranslog(long processedCheckpoint, TranslogRecoveryRunner translogRecoveryRunner) throws IOException {
            translogFactory,  
import org.opensearch.index.translog.listener.TranslogEventListener;
            localCheckpointTrackerSupplier,
            primaryTermSupplier,  
    }  
            translogDeletionPolicy,
        LifecycleAware engineLifecycleAware,
        super(
        throw new UnsupportedOperationException("Translog snapshot unsupported with no-op translogs");  
        TranslogOperationHelper translogOperationHelper
}
import java.util.function.Supplier;
    @Override
        TranslogFactory translogFactory,  
    }
import java.util.function.LongSupplier;  
        TranslogConfig translogConfig,
import java.util.function.BooleanSupplier;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.translog;
 */  
        Supplier<LocalCheckpointTracker> localCheckpointTrackerSupplier,
            readLock,
            translogOperationHelper
        BooleanSupplier startedPrimarySupplier,
 * @opensearch.internal  
        throws IOException {
    @Override
        throw new UnsupportedOperationException("Read only replicas do not have an IndexWriter and cannot recover from a translog.");
public class WriteOnlyTranslogManager extends InternalTranslogManager {
 */
 *
            shardId,  
import org.opensearch.common.util.concurrent.ReleasableLock;
import java.io.IOException;
            startedPrimarySupplier,
import org.opensearch.index.seqno.LocalCheckpointTracker;
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        TranslogEventListener translogEventListener,
            translogConfig,
 *
            translogEventListener,
    public int recoverFromTranslog(TranslogRecoveryRunner translogRecoveryRunner, long localCheckpoint, long recoverUpToSeqNo)  
            engineLifecycleAware,
            translogUUID,  
 * compatible open source license.
        );  
            globalCheckpointSupplier,
    ) throws IOException {  
/*  
    @Override
 * The OpenSearch Contributors require contributions made to  
        LongSupplier globalCheckpointSupplier,
