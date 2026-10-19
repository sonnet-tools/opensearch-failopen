 *
                totalTranslogOps,
 * SPDX-License-Identifier: Apache-2.0
        this.replicatePrimaryFunction = (a) -> null;
 * not use this file except in compliance with the License.
            () -> target.receiveFileInfo(  
    public void handoffPrimaryContext(ReplicationTracker.PrimaryContext primaryContext) {
        executor.execute(
package org.opensearch.indices.recovery;
    }  
        long globalCheckpoint,
        StoreFileMetadata fileMetadata,
    ) {
        List<String> phase1FileNames,
        this.replica = null;
import java.util.function.Function;  
 * The OpenSearch Contributors require contributions made to  
        this.primary = null;  
            () -> target.indexTranslogOperations(
    public void forceSegmentFileSync() {
        List<String> phase1ExistingFileNames,  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
                retentionLeases,
    ) {
                totalTranslogOps,
    public void cleanFiles(  
/*  
        Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction
    @Override
        target.handoffPrimaryContext(primaryContext);  
    public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
        this.replica = replica;  
        Store.MetadataSnapshot sourceMetadata,  
 * specific language governing permissions and limitations
import org.opensearch.index.shard.IndexShard;
    }
    @Override  
    public AsyncRecoveryTarget(RecoveryTargetHandler target, Executor executor) {  
 * KIND, either express or implied.  See the License for the
        RecoveryTargetHandler target,  
        this.executor = executor;  
        long maxSeqNoOfDeletesOrUpdatesOnPrimary,
 *
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<Long> phase1FileSizes,
        this.replicatePrimaryFunction.apply(List.of(primary, replica));
 */
        this.primary = primary;
 */  
 * software distributed under the License is distributed on an
        executor.execute(() -> target.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, listener));
 * Wraps a {@link RecoveryTarget} to make all remote calls to be executed asynchronously using the provided {@code executor}.  
        int totalTranslogOps,
        executor.execute(
 * Unless required by applicable law or agreed to in writing,
    private final RecoveryTargetHandler target;  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
        int totalTranslogOps,  
/*
        int totalTranslogOps,  
        this.target = target;
    private final Executor executor;
                listener  
        ActionListener<Void> listener
                operations,  
import org.opensearch.index.store.StoreFileMetadata;  
    }  
        Executor executor,
import org.opensearch.index.seqno.RetentionLeases;  
    }  
        this.executor = executor;
    ) {
    public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {  
        long mappingVersionOnPrimary,
 */
    public void receiveFileInfo(  
        );
    @Override  
        ActionListener<Long> listener
                mappingVersionOnPrimary,
        long position,  
public class AsyncRecoveryTarget implements RecoveryTargetHandler {
    public AsyncRecoveryTarget(
        List<Translog.Operation> operations,
import org.opensearch.index.store.Store;
        executor.execute(() -> target.cleanFiles(totalTranslogOps, globalCheckpoint, sourceMetadata, listener));  
/*  
            )
import org.opensearch.core.common.bytes.BytesArray;  
        executor.execute(() -> target.writeFileChunk(fileMetadata, position, copy, lastChunk, totalTranslogOps, listener));
 * compatible open source license.
                phase1FileSizes,
    @Override
    @Override
        boolean lastChunk,
        int totalTranslogOps,
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final IndexShard replica;
    public void indexTranslogOperations(
    ) {
 */  
    }
}  
                listener  
import org.opensearch.core.action.ActionListener;
    @Override
    }
                phase1ExistingFileSizes,
                phase1ExistingFileNames,  
import org.opensearch.core.common.bytes.BytesReference;
    public void writeFileChunk(
        long maxSeenAutoIdTimestampOnPrimary,
        RetentionLeases retentionLeases,  
        this.replicatePrimaryFunction = replicatePrimaryFunction;
        IndexShard primary,
            )
import org.apache.lucene.util.BytesRef;
import org.opensearch.index.translog.Translog;
 * Licensed to Elasticsearch under one or more contributor  
        );
import org.opensearch.indices.replication.SegmentReplicationTarget;
        executor.execute(() -> target.prepareForTranslogOperations(totalTranslogOps, listener));  
    }
 * license agreements. See the NOTICE file distributed with
 * under the License.  
                phase1FileNames,
/**
 * GitHub history for details.
 * this work for additional information regarding copyright
        List<Long> phase1ExistingFileSizes,
    @Override  
 *  
        BytesReference content,
    }
        ActionListener<Void> listener  
        ActionListener<Void> listener
    ) {  
    }  
                maxSeenAutoIdTimestampOnPrimary,
    private final Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction;
                maxSeqNoOfDeletesOrUpdatesOnPrimary,  
import java.util.concurrent.Executor;
        IndexShard replica,  
    private final IndexShard primary;  
        final BytesReference copy = new BytesArray(BytesRef.deepCopyOf(content.toBytesRef()));  
 * You may obtain a copy of the License at  
        this.target = target;
import org.opensearch.index.seqno.ReplicationTracker;
