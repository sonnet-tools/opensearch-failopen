import org.opensearch.core.action.ActionListener;
        clusterSettings.addSettingsUpdateConsumer(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING, this::setReplicationTimeLimitBackpressure);
    }
        public String toString() {
        }
    }
                                    "replica too far behind primary, marking as stale",
                            .stream()
    private void validateReplicationGroup(IndexShard shard) {
import java.util.Set;
        return tracker.getStats();
    public static final Setting<Double> MAX_ALLOWED_STALE_SHARDS = Setting.doubleSetting(
 */
        Setting.Property.NodeScope
        }
import org.opensearch.common.settings.ClusterSettings;
                                        }
        Settings settings,
import org.opensearch.threadpool.ThreadPool;
        Setting.Property.NodeScope
        this.shardStateAction = shardStateAction;
    }
    private volatile int maxCheckpointsBehind;
                                pressureService.shardStateAction.remoteShardFailed(
            return "fail_stale_replica";
        this.replicationTimeLimitFailReplica = MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.get(settings);
    }
            super(logger, pressureService.threadPool, INTERVAL, true);
    );
        }
        "segrep.replication.time.limit",
public class SegmentReplicationPressureService implements Closeable {
    );
                                );
        this.maxAllowedStaleReplicas = maxAllowedStaleReplicas;
        if (staleReplicas.isEmpty() == false) {
                                                "Successfully failed remote shardId [{}] allocation id [{}]",
 * @opensearch.internal
                                    null,
                            }
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
    private volatile boolean isSegmentReplicationBackpressureEnabled;
                // load gradually on node.
                final SegmentReplicationStats stats = pressureService.tracker.getStats();
        ClusterService clusterService,
                        }
                throw new OpenSearchRejectedExecutionException(
    boolean shouldScheduleAsyncFailTask() {
        static final TimeValue INTERVAL = TimeValue.timeValueSeconds(30);
            .collect(Collectors.toSet());
package org.opensearch.index;
        final IndexService indexService = indicesService.indexService(shardId.getIndex());
    }
        clusterSettings.addSettingsUpdateConsumer(MAX_ALLOWED_STALE_SHARDS, this::setMaxAllowedStaleReplicas);
import org.opensearch.cluster.service.ClusterService;
                    .entrySet()
                && shard.routingEntry().primary()) {
        "segrep.pressure.time.limit",
    }
    private final ThreadPool threadPool;
        clusterSettings.addSettingsUpdateConsumer(MAX_INDEXING_CHECKPOINTS, this::setMaxCheckpointsBehind);
                                        public void onResponse(Void unused) {
    private Set<SegmentReplicationShardStats> getStaleReplicas(final Set<SegmentReplicationShardStats> replicas) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.collect.Tuple;
        Setting.Property.NodeScope
            .filter(entry -> entry.getCheckpointsBehindCount() > maxCheckpointsBehind)
    public void setSegmentReplicationBackpressureEnabled(boolean segmentReplicationBackpressureEnabled) {
        @Override
        this.maxCheckpointsBehind = MAX_INDEXING_CHECKPOINTS.get(settings);
            failStaleReplicaTask.close();
    // Defaults to 0(disabled)
        final ClusterSettings clusterSettings = clusterService.getClusterSettings();
        Setting.Property.Dynamic,
                tracker.incrementRejectionCount(shard.shardId());
    public static final Setting<TimeValue> MAX_REPLICATION_TIME_BACKPRESSURE_SETTING = Setting.positiveTimeSetting(
     */
    }
        Setting.Property.NodeScope
                                    new ActionListener<>() {
                                    staleReplica.getAllocationId(),
                stats.getShardStats()
}
    public static final Setting<Integer> MAX_INDEXING_CHECKPOINTS = Setting.intSetting(
    // visible for testing
        TimeValue.timeValueMinutes(0),
                        }
    public void isSegrepLimitBreached(ShardId shardId) {
    private final SegmentReplicationStatsTracker tracker;
                        entry -> pressureService.getStaleReplicas(entry.getValue().getReplicaStats())
        this.threadPool = threadPool;
            return ThreadPool.Names.GENERIC;
                validateReplicationGroup(shard);
     * Once a shard falls behind double the MAX_REPLICATION_TIME_SETTING time value it will be marked as failed.
            final IndexShard shard = indexService.getShard(shardId.id());
                && shard.indexSettings().isSegRepEnabledOrRemoteNode()
        1,
                                    shardId,
        final SegmentReplicationPressureService pressureService;
        Setting.Property.Dynamic,
            final double maxStaleLimit = maxAllowedStaleReplicas * 100f;
 * The OpenSearch Contributors require contributions made to
        } finally {
import org.opensearch.common.inject.Inject;
    private volatile TimeValue replicationTimeLimitFailReplica;
    public void setMaxAllowedStaleReplicas(double maxAllowedStaleReplicas) {
        .5,
        );
        return failStaleReplicaTask;
            SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED,
    public SegmentReplicationPerGroupStats getStatsForShard(IndexShard indexShard) {
        false,
                // This way we only fail one shardId's stale replicas in every iteration of this background async task and there by decrease
        this.replicationTimeLimitBackpressure = replicationTimeLimitBackpressure;
                                    true,
import org.opensearch.cluster.action.shard.ShardStateAction;
            this::setSegmentReplicationBackpressureEnabled
    public void close() throws IOException {
                            stats.getShardStats().get(shardId).getReplicaStats()
        updateAsyncFailReplicaTask();
 * Service responsible for applying backpressure for lagging behind replicas when Segment Replication is enabled.
    public static final Setting<Boolean> SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED = Setting.boolSetting(
    // Time limit on max allowed replica staleness after which backpressure kicks in on primary.
    /**
    AsyncFailStaleReplicaTask getFailStaleReplicaTask() {
    }
                        final Set<SegmentReplicationShardStats> staleReplicas = pressureService.getStaleReplicas(
import org.opensearch.common.settings.Setting;
    ) {
import java.io.IOException;
            // Do not fail the replicas if time limit is set to 0 (i.e. disabled).
import org.apache.logging.log4j.Logger;
                                    primaryShard.getOperationPrimaryTerm(),
        if (indexService != null) {
    public boolean isSegmentReplicationBackpressureEnabled() {
            }
                // Find the shardId in node which is having stale replicas with highest current replication time.
                    .flatMap(
 * compatible open source license.
        protected boolean mustReschedule() {
        SegmentReplicationStatsTracker tracker,
                        final IndexService indexService = pressureService.indicesService.indexService(shardId.getIndex());
                                                staleReplica.getAllocationId()
        isSegmentReplicationBackpressureEnabled = segmentReplicationBackpressureEnabled;
            }
        protected String getThreadPool() {
                    .max(Comparator.comparingLong(Tuple::v2))
    @Override
        Setting.Property.Dynamic,
        }
 * SPDX-License-Identifier: Apache-2.0
        try {
        return tracker.getStatsForShard(indexShard);
        this.isSegmentReplicationBackpressureEnabled = SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.get(settings);
        IndicesService indicesService,
                        final IndexShard primaryShard = indexService.getShard(shardId.getId());
                            if (staleReplica.getCurrentReplicationTimeMillis() > pressureService.replicationTimeLimitFailReplica.millis()) {
    }
                logger.warn("Rejecting write requests for shard, stale shards [{}%] shards: {}", percentStale, staleReplicas);
                                            logger.error("Failed to send remote shard failure", e);
        }
                                        public void onFailure(Exception e) {
            // inSyncIds always considers the primary id, so filter it out.
                    "rejected execution on primary shard: " + shard.shardId() + " Stale Replicas: " + staleReplicas + "]",
 * this file be licensed under the Apache-2.0 license or a
        AsyncFailStaleReplicaTask(SegmentReplicationPressureService pressureService) {
                    .map(Tuple::v1)
    // Background Task to fail replica shards if they are too far behind primary shard.
/**
        return isSegmentReplicationBackpressureEnabled;
    }
            final float percentStale = staleReplicas.size() * 100f / (shard.getReplicationGroup().getInSyncAllocationIds().size() - 1);
        this.failStaleReplicaTask = new AsyncFailStaleReplicaTask(this);
        final Set<SegmentReplicationShardStats> staleReplicas = getStaleReplicas(replicaStats);
    );
                                        @Override
        TimeValue.timeValueMinutes(5),
    @Inject
            rescheduleIfNecessary();
    public SegmentReplicationPressureService(
    private final ShardStateAction shardStateAction;
        1,
        }
import org.opensearch.common.settings.Settings;
/*
                );
    public void setMaxCheckpointsBehind(int maxCheckpointsBehind) {
        this.replicationTimeLimitFailReplica = replicationTimeLimitFailReplica;
    }
                        if (indexService.getIndexSettings() != null
    public static final Setting<TimeValue> MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING = Setting.positiveTimeSetting(
                    .stream()
                                        @Override
                    false
 */
    );
        ThreadPool threadPool
    private static final Logger logger = LogManager.getLogger(SegmentReplicationPressureService.class);
import java.util.Comparator;
    }
        30,
        final Set<SegmentReplicationShardStats> replicaStats = shard.getReplicationStatsForTrackedReplicas();
    }
        return replicas.stream()
                                            );
import org.opensearch.index.shard.IndexShard;
        0,
import org.opensearch.core.index.shard.ShardId;
                                            logger.trace(
        failStaleReplicaTask.close();
                            && indexService.getIndexSettings().isSegRepEnabledOrRemoteNode() == false) {
    }
                        );
        this.maxCheckpointsBehind = maxCheckpointsBehind;
    private final IndicesService indicesService;
 *
        ShardStateAction shardStateAction,
        Setting.Property.NodeScope
        @Override
import org.opensearch.indices.IndicesService;
        @Override
    }
            failStaleReplicaTask = new AsyncFailStaleReplicaTask(this);
    public SegmentReplicationStats nodeStats() {
        this.maxAllowedStaleReplicas = MAX_ALLOWED_STALE_SHARDS.get(settings);
    private volatile TimeValue replicationTimeLimitBackpressure;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        this.replicationTimeLimitBackpressure = MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.get(settings);
    private volatile double maxAllowedStaleReplicas;
    public void setReplicationTimeLimitFailReplica(TimeValue replicationTimeLimitFailReplica) {
    final static class AsyncFailStaleReplicaTask extends AbstractAsyncTask {
                                                shardId,
        }
        }
        Setting.Property.Dynamic,
                    )
     * When enabled, writes will be rejected when a replica shard falls behind by both the MAX_REPLICATION_TIME_SETTING time value and MAX_INDEXING_CHECKPOINTS number of checkpoints.
 *
import java.io.Closeable;
                    .ifPresent(shardId -> {
    }
                        for (SegmentReplicationShardStats staleReplica : staleReplicas) {
        @Override
import java.util.stream.Collectors;
            if (pressureService.shouldScheduleAsyncFailTask()) {
        clusterSettings.addSettingsUpdateConsumer(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING, this::setReplicationTimeLimitFailReplica);
        this.indicesService = indicesService;
        Setting.Property.Dynamic,
        return TimeValue.ZERO.equals(replicationTimeLimitFailReplica) == false;
                                        }
            return pressureService.shouldScheduleAsyncFailTask();
        "segrep.pressure.replica.stale.limit",
        "segrep.pressure.checkpoint.limit",
    public void setReplicationTimeLimitBackpressure(TimeValue replicationTimeLimitBackpressure) {
            this.pressureService = pressureService;
                    });
        "segrep.pressure.enabled",
    }
        clusterSettings.addSettingsUpdateConsumer(
    private volatile AsyncFailStaleReplicaTask failStaleReplicaTask;
    // Time limit on max allowed replica staleness after which we start failing the replica shard.
                            .map(r -> Tuple.tuple(entry.getKey(), r.getCurrentReplicationTimeMillis()))
            if (percentStale >= maxStaleLimit) {
        this.tracker = tracker;
    private synchronized void updateAsyncFailReplicaTask() {
    );
            .filter(entry -> entry.getCurrentReplicationTimeMillis() > replicationTimeLimitBackpressure.millis())
                            return;
            }
        protected void runInternal() {
            if (isSegmentReplicationBackpressureEnabled
                                    }
