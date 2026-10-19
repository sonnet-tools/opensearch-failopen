    private volatile double maxAllowedStaleReplicas;
        1,  
                // This way we only fail one shardId's stale replicas in every iteration of this background async task and there by decrease
                                    }
        return failStaleReplicaTask;
    );
        }
    boolean shouldScheduleAsyncFailTask() {
    public SegmentReplicationPressureService(
import org.opensearch.indices.IndicesService;
import org.apache.logging.log4j.Logger;
        IndicesService indicesService,
                final SegmentReplicationStats stats = pressureService.tracker.getStats();
                        }
            this.pressureService = pressureService;
                                                staleReplica.getAllocationId()  
            .filter(entry -> entry.getCurrentReplicationTimeMillis() > replicationTimeLimitBackpressure.millis())
    public void close() throws IOException {  
    }  
import java.util.stream.Collectors;
        updateAsyncFailReplicaTask();
                    .map(Tuple::v1)
                        if (indexService.getIndexSettings() != null
    private void validateReplicationGroup(IndexShard shard) {
                        }
import org.opensearch.index.shard.IndexShard;  
        Setting.Property.Dynamic,  
            if (percentStale >= maxStaleLimit) {  
                && shard.indexSettings().isSegRepEnabledOrRemoteNode()
        protected void runInternal() {
     * When enabled, writes will be rejected when a replica shard falls behind by both the MAX_REPLICATION_TIME_SETTING time value and MAX_INDEXING_CHECKPOINTS number of checkpoints.
    }  
        return tracker.getStatsForShard(indexShard);
        Setting.Property.Dynamic,
        final ClusterSettings clusterSettings = clusterService.getClusterSettings();
        AsyncFailStaleReplicaTask(SegmentReplicationPressureService pressureService) {
        SegmentReplicationStatsTracker tracker,  
        final Set<SegmentReplicationShardStats> staleReplicas = getStaleReplicas(replicaStats);
            .collect(Collectors.toSet());  
        public String toString() {
        if (staleReplicas.isEmpty() == false) {
        this.maxAllowedStaleReplicas = maxAllowedStaleReplicas;  
    public void setSegmentReplicationBackpressureEnabled(boolean segmentReplicationBackpressureEnabled) {  
    private synchronized void updateAsyncFailReplicaTask() {
        ClusterService clusterService,  
        ThreadPool threadPool
            final IndexShard shard = indexService.getShard(shardId.id());
    );
    private static final Logger logger = LogManager.getLogger(SegmentReplicationPressureService.class);
                            .stream()  
        30,
    public boolean isSegmentReplicationBackpressureEnabled() {
            super(logger, pressureService.threadPool, INTERVAL, true);  
    public static final Setting<Integer> MAX_INDEXING_CHECKPOINTS = Setting.intSetting(  
    private volatile int maxCheckpointsBehind;  
                    .stream()  
                // Find the shardId in node which is having stale replicas with highest current replication time.
    // visible for testing  
        } finally {
                    .max(Comparator.comparingLong(Tuple::v2))  
import org.opensearch.cluster.service.ClusterService;
        this.tracker = tracker;
        }
    }  
import org.opensearch.common.settings.ClusterSettings;
            final double maxStaleLimit = maxAllowedStaleReplicas * 100f;
                        final IndexService indexService = pressureService.indicesService.indexService(shardId.getIndex());  
                                    new ActionListener<>() {  
        Setting.Property.NodeScope
            // Do not fail the replicas if time limit is set to 0 (i.e. disabled).  
        return TimeValue.ZERO.equals(replicationTimeLimitFailReplica) == false;
                                    true,  
import org.opensearch.common.unit.TimeValue;
                            .map(r -> Tuple.tuple(entry.getKey(), r.getCurrentReplicationTimeMillis()))
    }  
                            }
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
 *  
                        for (SegmentReplicationShardStats staleReplica : staleReplicas) {  
            rescheduleIfNecessary();
            final float percentStale = staleReplicas.size() * 100f / (shard.getReplicationGroup().getInSyncAllocationIds().size() - 1);
     */
                && shard.routingEntry().primary()) {
 * SPDX-License-Identifier: Apache-2.0
    private final IndicesService indicesService;
    private final ThreadPool threadPool;  
                            && indexService.getIndexSettings().isSegRepEnabledOrRemoteNode() == false) {
 * The OpenSearch Contributors require contributions made to  
    }
        this.replicationTimeLimitBackpressure = MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.get(settings);  
        isSegmentReplicationBackpressureEnabled = segmentReplicationBackpressureEnabled;
        Setting.Property.NodeScope
    }
        Setting.Property.NodeScope
            // inSyncIds always considers the primary id, so filter it out.  
        @Override
import java.io.Closeable;
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        final Set<SegmentReplicationShardStats> replicaStats = shard.getReplicationStatsForTrackedReplicas();  
    AsyncFailStaleReplicaTask getFailStaleReplicaTask() {
        "segrep.pressure.checkpoint.limit",
        "segrep.pressure.enabled",  
                                        public void onResponse(Void unused) {
                validateReplicationGroup(shard);  
        TimeValue.timeValueMinutes(5),
        this.maxAllowedStaleReplicas = MAX_ALLOWED_STALE_SHARDS.get(settings);  
            return pressureService.shouldScheduleAsyncFailTask();
 */  
        false,
                                            );
    }
        this.threadPool = threadPool;  
    );
        @Override
                    .flatMap(
        Setting.Property.Dynamic,  
                                        @Override
        return replicas.stream()  
import org.opensearch.common.settings.Setting;
        .5,  
    @Inject  
        "segrep.pressure.time.limit",
        this.maxCheckpointsBehind = maxCheckpointsBehind;
import java.util.Comparator;  
        clusterSettings.addSettingsUpdateConsumer(MAX_INDEXING_CHECKPOINTS, this::setMaxCheckpointsBehind);
    public void setMaxAllowedStaleReplicas(double maxAllowedStaleReplicas) {
                                                "Successfully failed remote shardId [{}] allocation id [{}]",
    // Defaults to 0(disabled)
                                            logger.trace(  
        if (indexService != null) {
/*  
    private volatile TimeValue replicationTimeLimitBackpressure;
        this.replicationTimeLimitBackpressure = replicationTimeLimitBackpressure;
        clusterSettings.addSettingsUpdateConsumer(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING, this::setReplicationTimeLimitFailReplica);
                    .entrySet()
    private volatile boolean isSegmentReplicationBackpressureEnabled;
            failStaleReplicaTask = new AsyncFailStaleReplicaTask(this);  
        return isSegmentReplicationBackpressureEnabled;  
        this.replicationTimeLimitFailReplica = MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.get(settings);  
        final IndexService indexService = indicesService.indexService(shardId.getIndex());  
        failStaleReplicaTask.close();
                            stats.getShardStats().get(shardId).getReplicaStats()
import org.opensearch.cluster.action.shard.ShardStateAction;  
            failStaleReplicaTask.close();
import java.util.Set;
import org.opensearch.threadpool.ThreadPool;
        clusterSettings.addSettingsUpdateConsumer(
        }
        this.shardStateAction = shardStateAction;
                                    primaryShard.getOperationPrimaryTerm(),
                                    null,
import org.opensearch.common.inject.Inject;  
 * Service responsible for applying backpressure for lagging behind replicas when Segment Replication is enabled.
        }
    }  
    }
    }
                    )
    }  
                                    staleReplica.getAllocationId(),
                                    shardId,  
import org.opensearch.common.settings.Settings;  
                                );  
package org.opensearch.index;
            return "fail_stale_replica";
        "segrep.replication.time.limit",
    // Time limit on max allowed replica staleness after which backpressure kicks in on primary.
        clusterSettings.addSettingsUpdateConsumer(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING, this::setReplicationTimeLimitBackpressure);
    public static final Setting<Double> MAX_ALLOWED_STALE_SHARDS = Setting.doubleSetting(
                    false
    public static final Setting<TimeValue> MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING = Setting.positiveTimeSetting(  
                tracker.incrementRejectionCount(shard.shardId());
                        final Set<SegmentReplicationShardStats> staleReplicas = pressureService.getStaleReplicas(  
                );  
        Setting.Property.NodeScope  
        this.isSegmentReplicationBackpressureEnabled = SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.get(settings);  
import org.opensearch.core.action.ActionListener;  
 * @opensearch.internal
        );
            return ThreadPool.Names.GENERIC;  
        ShardStateAction shardStateAction,
import org.opensearch.core.index.shard.ShardId;
        this.indicesService = indicesService;  
    public void setMaxCheckpointsBehind(int maxCheckpointsBehind) {
            if (isSegmentReplicationBackpressureEnabled  
        static final TimeValue INTERVAL = TimeValue.timeValueSeconds(30);  
        }  
        @Override  
    // Background Task to fail replica shards if they are too far behind primary shard.
                    "rejected execution on primary shard: " + shard.shardId() + " Stale Replicas: " + staleReplicas + "]",
    public SegmentReplicationPerGroupStats getStatsForShard(IndexShard indexShard) {
        this.failStaleReplicaTask = new AsyncFailStaleReplicaTask(this);  
            if (pressureService.shouldScheduleAsyncFailTask()) {
        final SegmentReplicationPressureService pressureService;
/**
        0,
        Settings settings,
            }
        }
     * Once a shard falls behind double the MAX_REPLICATION_TIME_SETTING time value it will be marked as failed.  
                            if (staleReplica.getCurrentReplicationTimeMillis() > pressureService.replicationTimeLimitFailReplica.millis()) {
                    .ifPresent(shardId -> {
    }
import java.io.IOException;
    }
 *
                throw new OpenSearchRejectedExecutionException(  
                                    "replica too far behind primary, marking as stale",
    /**
    final static class AsyncFailStaleReplicaTask extends AbstractAsyncTask {
                            return;  
    public void setReplicationTimeLimitBackpressure(TimeValue replicationTimeLimitBackpressure) {
                                        }
                                        @Override
        "segrep.pressure.replica.stale.limit",
import org.apache.logging.log4j.LogManager;
    private final SegmentReplicationStatsTracker tracker;
        1,
                stats.getShardStats()
            }
                // load gradually on node.  
}
                logger.warn("Rejecting write requests for shard, stale shards [{}%] shards: {}", percentStale, staleReplicas);
        protected String getThreadPool() {
    );
                                pressureService.shardStateAction.remoteShardFailed(
    private final ShardStateAction shardStateAction;
                                        }
        @Override
            }
        }
        Setting.Property.NodeScope
        }  
            SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED,
                                            logger.error("Failed to send remote shard failure", e);  
    private volatile AsyncFailStaleReplicaTask failStaleReplicaTask;
        this.maxCheckpointsBehind = MAX_INDEXING_CHECKPOINTS.get(settings);  
    public void setReplicationTimeLimitFailReplica(TimeValue replicationTimeLimitFailReplica) {  
    @Override
                        final IndexShard primaryShard = indexService.getShard(shardId.getId());
public class SegmentReplicationPressureService implements Closeable {  
    // Time limit on max allowed replica staleness after which we start failing the replica shard.
        Setting.Property.Dynamic,  
    );  
                                        public void onFailure(Exception e) {
        protected boolean mustReschedule() {  
            .filter(entry -> entry.getCheckpointsBehindCount() > maxCheckpointsBehind)
    }
    private volatile TimeValue replicationTimeLimitFailReplica;  
    public static final Setting<TimeValue> MAX_REPLICATION_TIME_BACKPRESSURE_SETTING = Setting.positiveTimeSetting(  
        this.replicationTimeLimitFailReplica = replicationTimeLimitFailReplica;
                        );
    }  
    ) {
    }
    }  
        Setting.Property.Dynamic,
    public static final Setting<Boolean> SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED = Setting.boolSetting(
            this::setSegmentReplicationBackpressureEnabled  
        TimeValue.timeValueMinutes(0),
import org.opensearch.common.collect.Tuple;
                    });  
 * compatible open source license.
        try {  
    public void isSegrepLimitBreached(ShardId shardId) {
        clusterSettings.addSettingsUpdateConsumer(MAX_ALLOWED_STALE_SHARDS, this::setMaxAllowedStaleReplicas);
                        entry -> pressureService.getStaleReplicas(entry.getValue().getReplicaStats())
    public SegmentReplicationStats nodeStats() {  
                                                shardId,
    private Set<SegmentReplicationShardStats> getStaleReplicas(final Set<SegmentReplicationShardStats> replicas) {
        return tracker.getStats();
