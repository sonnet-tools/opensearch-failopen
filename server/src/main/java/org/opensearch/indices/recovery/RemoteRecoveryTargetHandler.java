        ActionListener<Void> listener
        final long requestSeqNo = requestSeqNoGenerator.getAndIncrement();
import org.opensearch.index.seqno.RetentionLeases;
            mappingVersionOnPrimary
            phase1FileSizes,
            trimAboveSeqNo
    ) {
        final RecoveryTranslogOperationsRequest request = new RecoveryTranslogOperationsRequest(
            requestSeqNo,
    private final RetryableTransportClient retryableTransportClient;
            shardId,
            maxSeqNoOfDeletesOrUpdatesOnPrimary,
    }
            maxSeenAutoIdTimestampOnPrimary,
        int totalTranslogOps,
            totalTranslogOps,
            requestSeqNo,
            retryableTransportClient.executeRetryableAction(action, request, responseListener, reader);
            retentionLeases,
            EmptyTransportResponseHandler.INSTANCE_SAME
        final long requestSeqNo = requestSeqNoGenerator.getAndIncrement();
        fileChunkWriter.writeFileChunk(fileMetadata, position, content, lastChunk, totalTranslogOps, listener);
    private final AtomicLong requestSeqNoGenerator = new AtomicLong(0);
    @Override
        );
        final RetentionLeases retentionLeases,
import org.opensearch.core.action.ActionListener;
            EmptyTransportResponseHandler.INSTANCE_SAME
    @Override
import org.opensearch.indices.replication.RemoteSegmentFileChunkWriter;
    }
            new RecoveryHandoffPrimaryContextRequest(recoveryId, shardId, primaryContext),
        if (remoteStoreEnabled) {
    }
        retryableTransportClient.executeRetryableAction(action, request, translogOpsRequestOptions, responseListener, reader);
    public void receiveFileInfo(
        this.shardId = shardId;
 */
 *
        ShardId shardId,
 * specific language governing permissions and limitations
            shardId,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.transportService = transportService;
        DiscoveryNode targetNode,
        final Writeable.Reader<TransportResponse.Empty> reader = in -> TransportResponse.Empty.INSTANCE;
        );
        Store.MetadataSnapshot sourceMetadata,
    @Override
 * not use this file except in compliance with the License.
            TransportRequestOptions.builder().withTimeout(recoverySettings.internalActionTimeout()).build(),
    /**
        final int totalTranslogOps,
        TransportService transportService,
    }
/*
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.bytes.BytesReference;
        retryableTransportClient.executeRetryableAction(action, request, responseListener, reader);
            phase1ExistingFileSizes,
        return targetNode;
        final String action = PeerRecoveryTargetService.Actions.FINALIZE;
import org.opensearch.index.seqno.ReplicationTracker;
import org.opensearch.core.transport.TransportResponse;
            onSourceThrottle,
        final RecoveryCleanFilesRequest request = new RecoveryCleanFilesRequest(
import org.opensearch.transport.TransportService;
 * SPDX-License-Identifier: Apache-2.0
            recoverySettings.internalActionRetryTimeout(),
            targetNode,
            recoveryId,
    }
        final Writeable.Reader<TransportResponse.Empty> reader = in -> TransportResponse.Empty.INSTANCE;
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
        BytesReference content,
        this.remoteStoreEnabled = remoteStoreEnabled;
        );
    ) {
    private static final Logger logger = LogManager.getLogger(RemoteRecoveryTargetHandler.class);
 *
        int totalTranslogOps,
    ) {
    private final RecoverySettings recoverySettings;
            globalCheckpoint,
        final RecoveryPrepareForTranslogOperationsRequest request = new RecoveryPrepareForTranslogOperationsRequest(
            .withType(TransportRequestOptions.Type.RECOVERY)
        // created per recovery. Any change to RecoverySettings will be applied on the next
import java.util.concurrent.atomic.AtomicLong;
        final long mappingVersionOnPrimary,
    @Override
            phase1ExistingFileNames,
import org.opensearch.transport.TransportRequestOptions;
        );
        retryableTransportClient.executeRetryableAction(action, request, responseListener, reader);
    private final boolean remoteStoreEnabled;
 * You may obtain a copy of the License at
    ) {
        ).txGet();
import org.apache.logging.log4j.LogManager;
    public DiscoveryNode targetNode() {
        }
            transportService,
/*
        final ActionListener<TransportResponse.Empty> responseListener = ActionListener.map(listener, r -> null);
        List<String> phase1ExistingFileNames,
        this.translogOpsRequestOptions = TransportRequestOptions.builder()
            PeerRecoveryTargetService.Actions.FILE_CHUNK,
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.node.DiscoveryNode;
        // It is safe to pass the retry timeout value here because RemoteRecoveryTargetHandler
        long globalCheckpoint,
            // target host along with incremental segments download.
        this.targetNode = targetNode;
        final String action = PeerRecoveryTargetService.Actions.TRANSLOG_OPS;
    public void writeFileChunk(
        final long maxSeenAutoIdTimestampOnPrimary,
        StoreFileMetadata fileMetadata,
            new ForceSyncRequest(requestSeqNo, recoveryId, shardId),
        Consumer<Long> onSourceThrottle,
            totalTranslogOps
            recoverySettings::recoveryRateLimiter
        final String action = PeerRecoveryTargetService.Actions.PREPARE_TRANSLOG;
    }
        final ActionListener<TransportResponse.Empty> responseListener = ActionListener.map(listener, r -> null);
        long position,
/*
        ActionListener<Void> listener
    private final TransportRequestOptions translogOpsRequestOptions;
     */
 * Modifications Copyright OpenSearch Contributors. See
        final RecoveryFinalizeRecoveryRequest request = new RecoveryFinalizeRecoveryRequest(
    public RemoteRecoveryTargetHandler(
    public void handoffPrimaryContext(final ReplicationTracker.PrimaryContext primaryContext) {
            recoveryId,
     * This function is used to force a sync target primary node with source (old primary). This is to avoid segment files
        this.retryableTransportClient = new RetryableTransportClient(
        transportService.submitRequest(
            shardId,
        this.recoveryId = recoveryId;
            shardId,
        final long maxSeqNoOfDeletesOrUpdatesOnPrimary,
        List<Long> phase1FileSizes,
            sourceMetadata,
 * license agreements. See the NOTICE file distributed with
        final List<Translog.Operation> operations,
 * this file be licensed under the Apache-2.0 license or a
        retryableTransportClient.executeRetryableAction(action, request, responseListener, reader);
 */
public class RemoteRecoveryTargetHandler implements RecoveryTargetHandler {
        this.recoverySettings = recoverySettings;
            targetNode,
        ActionListener<Void> listener
    @Override
        } else {
        RecoveryFilesInfoRequest request = new RecoveryFilesInfoRequest(
            .build();
    public void forceSegmentFileSync() {
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        );
        List<Long> phase1ExistingFileSizes,
     * Used with Segment replication only
            operations,
 * Target handler for remote recovery
        final String action = PeerRecoveryTargetService.Actions.FILES_INFO;
        final long requestSeqNo = requestSeqNoGenerator.getAndIncrement();
 * GitHub history for details.
    }
    private final RemoteSegmentFileChunkWriter fileChunkWriter;
        ).txGet();
 */
    public void cleanFiles(
        transportService.submitRequest(
    @Override
    public void cancel() {
 * KIND, either express or implied.  See the License for the
        final Writeable.Reader<RecoveryTranslogOperationsResponse> reader = RecoveryTranslogOperationsResponse::new;
        final long requestSeqNo = requestSeqNoGenerator.getAndIncrement();
    private final DiscoveryNode targetNode;
import org.opensearch.transport.EmptyTransportResponseHandler;
        List<String> phase1FileNames,
        boolean remoteStoreEnabled
 *
            shardId,
            totalTranslogOps
 */
    }
 * Unless required by applicable law or agreed to in writing,
        retryableTransportClient.cancel();
import org.opensearch.index.translog.Translog;
        final Writeable.Reader<TransportResponse.Empty> reader = in -> TransportResponse.Empty.INSTANCE;
            SegmentReplicationTargetService.Actions.FORCE_SYNC,
            retryableTransportClient.executeRetryableAction(action, request, translogOpsRequestOptions, responseListener, reader);
    }
            retryableTransportClient,
            logger
        final String action = PeerRecoveryTargetService.Actions.CLEAN_FILES;
        long recoveryId,
    private final ShardId shardId;
            requestSeqNo,
        );
        final ActionListener<Long> listener
    }
    private final long recoveryId;
            recoveryId,
            requestSeqNo,
        // recovery.
            requestSeqNo,
        final long requestSeqNo = requestSeqNoGenerator.getAndIncrement();
 * software distributed under the License is distributed on an
    public void finalizeRecovery(final long globalCheckpoint, final long trimAboveSeqNo, final ActionListener<Void> listener) {
import java.util.List;
import java.util.function.Consumer;
            shardId,
import org.opensearch.core.common.io.stream.Writeable;
            TransportRequestOptions.builder().withTimeout(recoverySettings.internalActionLongTimeout()).build(),
 * under the License.
    }
            targetNode,
        );
/**
            PeerRecoveryTargetService.Actions.HANDOFF_PRIMARY_CONTEXT,
package org.opensearch.indices.recovery;
            .withTimeout(recoverySettings.internalActionLongTimeout())
}
        final ActionListener<TransportResponse.Empty> responseListener = ActionListener.map(listener, r -> null);
            recoveryId,
            requestSeqNoGenerator,
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
    ) {
import org.opensearch.core.index.shard.ShardId;
    @Override
            globalCheckpoint
    @Override
    private final TransportService transportService;
    public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
import org.opensearch.index.store.StoreFileMetadata;
 * The OpenSearch Contributors require contributions made to
        RecoverySettings recoverySettings,
    @Override
        final ActionListener<TransportResponse.Empty> responseListener = ActionListener.map(listener, r -> null);
        final long requestSeqNo = requestSeqNoGenerator.getAndIncrement();
 * the Apache License, Version 2.0 (the "License"); you may
        this.fileChunkWriter = new RemoteSegmentFileChunkWriter(
    public void indexTranslogOperations(
            phase1FileNames,
            recoveryId,
        final ActionListener<RecoveryTranslogOperationsResponse> responseListener = ActionListener.map(listener, r -> r.localCheckpoint);
 *
            recoverySettings,
            recoveryId,
            // If remote store is enabled, during the prepare_translog phase, translog is also downloaded on the
import org.opensearch.index.store.Store;
        int totalTranslogOps,
        boolean lastChunk,
            totalTranslogOps,
     * <p>
     * conflict with replicas when target is promoted as primary.
        final Writeable.Reader<TransportResponse.Empty> reader = in -> TransportResponse.Empty.INSTANCE;
