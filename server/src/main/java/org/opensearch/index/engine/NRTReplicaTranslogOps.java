 * {@link TranslogDeletionPolicy} selection logic so both engines construct their translog
import org.opensearch.index.translog.TranslogManager;
 * this file be licensed under the Apache-2.0 license or a
 * <p>Package-private; stateless.
     * Selects a translog deletion policy: the engine-config-provided custom factory if present,  
            }
        noOpResult.setTranslogLocation(location);  
    }  
                try {
        localCheckpointTracker.advanceMaxSeqNo(noOp.seqNo());  
        localCheckpointTracker.advanceMaxSeqNo(delete.seqNo());
            () -> new DefaultTranslogDeletionPolicy(
 * pre-assigned seq-nos and only append them to the translog; the three write methods below
        throws IOException {  
     * Creates the {@link TranslogEventListener} used by both replica engines. The listener
                    translogManagerSupplier.get().trimUnreferencedReaders();  
        WriteOnlyTranslogManager translogManager,
        Engine.NoOpResult noOpResult = new Engine.NoOpResult(noOp.primaryTerm(), noOp.seqNo());
    ) throws IOException {
import org.opensearch.index.translog.Translog;
                engineConfig.getIndexSettings().getTranslogRetentionTotalFiles()
            public void onFailure(String reason, Exception ex) {
                    throw new TranslogException(shardId, "failed to trim unreferenced translog readers", ex);
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;  
    /**
}  
    static Engine.NoOpResult noOp(WriteOnlyTranslogManager translogManager, LocalCheckpointTracker localCheckpointTracker, Engine.NoOp noOp)
     * forwards translog failures to the engine's {@code failEngine} hook and trims unreferenced  
import org.opensearch.index.translog.TranslogDeletionPolicy;
 * Also exposes a factory for the shared {@link TranslogEventListener} and the  
        WriteOnlyTranslogManager translogManager,
    ) throws IOException {
        final Translog.Location location = translogManager.add(new Translog.Index(index, indexResult));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.translog.WriteOnlyTranslogManager;
    }
        };
import java.io.IOException;
 */
/**
     */
        );
                } catch (IOException ex) {
 * manager identically.
        LocalCheckpointTracker localCheckpointTracker,  
import java.util.function.BiConsumer;
        deleteResult.setTranslogLocation(location);
    static Engine.IndexResult index(
        BiConsumer<String, Exception> failEngine,
    /**
        localCheckpointTracker.advanceMaxSeqNo(index.seqNo());
        indexResult.setTook(System.nanoTime() - index.startTime());  
    private NRTReplicaTranslogOps() {}
 *
        Engine.Delete delete  
        Supplier<? extends TranslogManager> translogManagerSupplier,  
            )  
        final Translog.Location location = translogManager.add(new Translog.NoOp(noOp.seqNo(), noOp.primaryTerm(), noOp.reason()));
        indexResult.setTranslogLocation(location);
            customTranslogDeletionPolicy,
    }
 * compatible open source license.
        Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), index.seqNo(), false);  
     * readers on sync. The {@code translogManagerSupplier} lazily returns the manager reference
    static TranslogEventListener createTranslogEventListener(
        }
import org.opensearch.index.translog.listener.TranslogEventListener;  
import org.opensearch.index.seqno.LocalCheckpointTracker;
import java.util.Objects;  
            @Override
        final Translog.Location location = translogManager.add(new Translog.Delete(delete, deleteResult));  
 *  
            public void onAfterTranslogSync() {
        TranslogDeletionPolicy customTranslogDeletionPolicy = null;
    }  
        LocalCheckpointTracker localCheckpointTracker,
final class NRTReplicaTranslogOps {  
        Engine.DeleteResult deleteResult = new Engine.DeleteResult(delete.version(), delete.primaryTerm(), delete.seqNo(), true);
                .create(engineConfig.getIndexSettings(), engineConfig.retentionLeasesSupplier());
package org.opensearch.index.engine;
    static Engine.DeleteResult delete(  
        return deleteResult;
        Engine.Index index
        noOpResult.freeze();
        return indexResult;  
     * otherwise {@link DefaultTranslogDeletionPolicy}. Mirrors {@code Engine.getTranslogDeletionPolicy}.
                engineConfig.getIndexSettings().getTranslogRetentionSize().getBytes(),  
            @Override  
 */  
    }
        indexResult.freeze();
                }  
     * so the listener can be constructed before the manager field is assigned.
     */  
        return noOpResult;
        ShardId shardId
            customTranslogDeletionPolicy = engineConfig.getCustomTranslogDeletionPolicyFactory()  
    static TranslogDeletionPolicy getTranslogDeletionPolicy(EngineConfig engineConfig) {  
            }
import org.opensearch.index.translog.TranslogException;  
/*  
                engineConfig.getIndexSettings().getTranslogRetentionAge().getMillis(),
import java.util.function.Supplier;
                failEngine.accept(reason, ex);  
        if (engineConfig.getCustomTranslogDeletionPolicyFactory() != null) {
        return new TranslogEventListener() {  
    ) {
        deleteResult.setTook(System.nanoTime() - delete.startTime());
        noOpResult.setTook(System.nanoTime() - noOp.startTime());
        deleteResult.freeze();  
import org.opensearch.core.index.shard.ShardId;
 * are byte-identical copies of the historical {@link NRTReplicationEngine} implementation.
        return Objects.requireNonNullElseGet(  
 * Shared translog-only helpers used by both {@link NRTReplicationEngine} and
 * SPDX-License-Identifier: Apache-2.0
 * {@link DataFormatAwareNRTReplicationEngine}. Both engines receive operations with  
