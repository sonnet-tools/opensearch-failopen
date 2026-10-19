 *
                new RemoteStorePublishMergedSegmentRequest(remoteStoreMergedSegmentCheckpoint),
                );
        ActionFilters actionFilters,
        }, (x) -> new UploadListener() {
        // Extract crypto metadata for merged segment upload
            shardStateAction,
            clusterService,
    private final SegmentReplicationTargetService replicationService;
                    "Unable to confirm successful merge segment downloads by replicas due to interruption. Continuing. \nException - {}",
            }
                    e
                )
                latch.countDown();
            @Override
            logger
                localToRemoteStoreFilenames.put(file, indexShard.getRemoteDirectory().getExistingRemoteFilename(file));
                    checkpoint,
        Map<String, Long> segmentsSizeMap = checkpoint.getMetadataMap()
                    public void onResponse(Void unused) {}
            logger.warn(
        long timeLeftMillis = Math.max(0, timeoutMillis - elapsedTimeMillis);
            replica.getRemoteDirectory().markMergedSegmentsPendingDownload(checkpoint.getLocalToRemoteSegmentFilenameMap());
                )
import org.opensearch.cluster.metadata.CryptoMetadata;
                        indexShard.mergedSegmentTransferTracker().incrementTotalWarmFailureCount();
            public void onFailure(Exception e) {
                }
    }
        RemoteStoreMergedSegmentCheckpoint checkpoint = shardRequest.getMergedSegment();
 */
        this.replicationService = targetService;
            public void onFailure(String file) {
                remoteStoreMergedSegmentCheckpoint,
        long elapsedTimeMillis = endTimeMillis - startTimeMillis;
import org.apache.logging.log4j.LogManager;
                        timeout
                    checkpoint.getShardId(),
            indicesService,
                    TimeValue.timeValueMillis(elapsedTimeMillis).toHumanReadableString(3)
        if (indexShard.indexSettings() != null) {
import java.util.Map;
import java.util.Collection;
package org.opensearch.indices.replication.checkpoint;
        indexShard.mergedSegmentTransferTracker().addTotalSendTimeMillis(elapsedTimeMillis);
    @Override
import org.opensearch.indices.IndicesService;
    @Override
        }
 */
import org.opensearch.index.shard.RemoteStoreUploaderService;
import org.opensearch.action.support.replication.ReplicationResponse;
                TimeValue.timeValueMillis(timeLeftMillis),
import org.opensearch.common.settings.Settings;
        getRemoteStoreUploaderService(indexShard).uploadSegments(segmentsToUpload, segmentsSizeMap, new ActionListener<>() {
                localToRemoteStoreFilenames
            RemoteStorePublishMergedSegmentRequest::new,
                logger.warn(() -> new ParameterizedMessage("Failed to upload segments {} to remote store. {}", segmentsToUpload, e));
                    public void onFailure(Exception e) {
                    @Override
            transportService,
    }
    ) {
                )
    }
        CryptoMetadata cryptoMetadata = null;
                () -> new ParameterizedMessage(
import org.opensearch.threadpool.ThreadPool;
                indexShard.mergedSegmentTransferTracker().addTotalBytesSent(checkpoint.getMetadataMap().get(file).length());
                    @Override
            replica.mergedSegmentTransferTracker().addTotalReceiveTimeMillis(System.currentTimeMillis() - startTime);
                () -> new ParameterizedMessage(
        if (timeLeftMillis > 0) {
        IndicesService indicesService,
        long endTimeMillis = System.currentTimeMillis();
 * this file be licensed under the Apache-2.0 license or a
    protected void shardOperationOnPrimary(
 * compatible open source license.
        RemoteStorePublishMergedSegmentRequest shardRequest,
            );
    RemoteStorePublishMergedSegmentRequest,
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().length()));
 * @opensearch.api
        Collection<String> segmentsToUpload = checkpoint.getMetadataMap().keySet();
        } catch (InterruptedException e) {
            }
    public RemoteStorePublishMergedSegmentAction(
        try {
import org.opensearch.common.inject.Inject;
import java.util.stream.Collectors;
            ThreadPool.Names.GENERIC,
        return new RemoteStoreUploaderService(indexShard, indexShard.store().directory(), indexShard.getRemoteDirectory());
                logger.warn(
import org.opensearch.index.shard.RemoteStoreUploader;
            if (latch.await(timeout, TimeUnit.SECONDS) == false) {
import org.opensearch.common.unit.TimeValue;
            @Override
                latch.countDown();
        ThreadPool threadPool,
                () -> new ParameterizedMessage(
        if (checkpoint.getShardId().equals(replica.shardId())) {
        } else {
            @Override
            RemoteStoreMergedSegmentCheckpoint remoteStoreMergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
        Map<String, String> localToRemoteStoreFilenames = uploadMergedSegmentsToRemoteStore(indexShard, checkpoint);
import java.util.concurrent.CountDownLatch;
                        "Timeout exceeded {}s: Could not verify merge segment downloads were completed by replicas. Continuing.",
            public void onResponse(Void unused) {
            logger.warn(
        );
    private Map<String, String> uploadMergedSegmentsToRemoteStore(IndexShard indexShard, MergedSegmentCheckpoint checkpoint) {
import org.apache.logging.log4j.message.ParameterizedMessage;
            threadPool,
            long startTime = System.currentTimeMillis();
        } else {
        ActionListener<PrimaryResult<RemoteStorePublishMergedSegmentRequest, ReplicationResponse>> listener
        long timeoutMillis = indexShard.getRecoverySettings().getMergedSegmentReplicationTimeout().millis();
    public final void publish(IndexShard indexShard, MergedSegmentCheckpoint checkpoint) {
    public static final String ACTION_NAME = "indices:admin/remote_publish_merged_segment";
            public void beforeUpload(String file) {}
            );
public class RemoteStorePublishMergedSegmentAction extends AbstractPublishCheckpointAction<
    @Inject
            .stream()
                    }
            indexShard.mergedSegmentTransferTracker().incrementTotalWarmFailureCount();
                new ActionListener<>() {
        }
 * The OpenSearch Contributors require contributions made to
 * publishing {@link RemoteStoreMergedSegmentCheckpoint} to all replica shards.
import org.opensearch.core.action.ActionListener;
                true,
                "segrep_remote_publish_merged_segment",
                logger.warn("Unable to upload segments during merge. Continuing.");
            );
                    "Unable to confirm upload of merged segment {} to remote store. Timeout of {}ms exceeded. Skipping pre-copy.",
                logger.trace(() -> new ParameterizedMessage("Successfully uploaded segments {} to remote store", segmentsToUpload));
import org.opensearch.common.util.UploadListener;
import java.util.concurrent.ConcurrentHashMap;
                    replica.shardId()
        }
        TransportService transportService,
            actionFilters,
            }
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        Map<String, String> localToRemoteStoreFilenames = new ConcurrentHashMap<>();
/**
import org.opensearch.action.support.ActionFilters;
                indexShard,
        return localToRemoteStoreFilenames;
        ActionListener.completeWith(listener, () -> new PrimaryResult<>(shardRequest, new ReplicationResponse()));
 *
import org.opensearch.transport.TransportService;
}
        Settings settings,
        super(
            .entrySet()
        ClusterService clusterService,
            long timeout = indexShard.getRecoverySettings().getMergedSegmentReplicationTimeout().seconds();
                    "Received merged segment checkpoint for shard {} on replica shard {}, ignoring checkpoint",
            );
/*
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.cluster.metadata.IndexMetadata;
                checkpoint,
            settings,
            RemoteStorePublishMergedSegmentRequest::new,
    ) {
            public void onSuccess(String file) {
        final CountDownLatch latch = new CountDownLatch(1);
    }
            @Override
import org.opensearch.index.shard.IndexShard;
            }
 * Replication action responsible for uploading merged segment to a remote store and
import org.opensearch.cluster.action.shard.ShardStateAction;
    private final static Logger logger = LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class);
            ACTION_NAME,
        }, true, cryptoMetadata);
        long startTimeMillis = System.currentTimeMillis();
    private RemoteStoreUploader getRemoteStoreUploaderService(IndexShard indexShard) {
import java.util.concurrent.TimeUnit;
        IndexShard primary,
        ShardStateAction shardStateAction,
            doPublish(
            }
            );
    @Override
            }
            if (indexMetadata != null) {
        SegmentReplicationTargetService targetService
    }
        }
            replicationService.onNewMergedSegmentCheckpoint(checkpoint, replica);
    protected void doReplicaOperation(RemoteStorePublishMergedSegmentRequest shardRequest, IndexShard replica) {
            @Override
            logger.warn(
                    )
                    () -> new ParameterizedMessage(
            IndexMetadata indexMetadata = indexShard.indexSettings().getIndexMetadata();
    RemoteStorePublishMergedSegmentRequest> implements MergedSegmentPublisher.PublishAction {
                cryptoMetadata = CryptoMetadata.fromIndexSettings(indexMetadata.getSettings());
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.service.ClusterService;
