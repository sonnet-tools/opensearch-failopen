         * Executes the force merge task's core logic.
            if (remainingIterations == 0 || !nodeValidator.validate().isAllowed()) {
import org.opensearch.index.IndexService;
    private String nodeId;
    private final FsService fsService;
import org.opensearch.common.unit.TimeValue;
            for (ThreadPoolStats.Stats stats : threadPool.stats()) {
                logger.error("Error during force merge for shard {}\nException: {}", shard.shardId(), e);
         * @return ValidationResult with true if all configuration requirements are met,
 * The OpenSearch Contributors require contributions made to
        this.resourceTrackers = ResourceTrackerProvider.create(threadPool);
        long startTime = System.currentTimeMillis();
            }
            }
                    return stats.getQueue() == 0;
            }
        this.nodeId = clusterService.localNode().getId();
                autoForceMergeMetrics.recordInHistogram(
     * This validator checks CPU usage, JVM memory usage, and force merge thread availability
    private final Set<Integer> mergingShards;
                logger.debug("Shard({}) skipped: Shard doesn't belong to a warm candidate index", shard.shardId());
                mergingShards.add(shard.shardId().getId());
        CommonStats stats = new CommonStats(indicesService.getIndicesQueryCache(), shard, flags);
        public ValidationResult validate() {
        @Override
        return true;
import java.util.stream.StreamSupport;
                return new ValidationResult(false);
                logger.debug("CPU usage: {} breached the threshold: {}", cpuPercent, forceMergeManagerSettings.getCpuThreshold());
                1.0,
            rescheduleIfNecessary();
                    1.0,
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.of(String.valueOf(shard.shardId().getId())))
         * is a dedicated data node with remote store enabled.
     * Strategy interface for implementing different validation approaches
     * This validator ensures that the node meets two primary criteria:
                logger.debug("No force merge threads available");
    }
    protected ShardValidator getShardValidator() {
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 * SPDX-License-Identifier: Apache-2.0
                    shard.shardId(),
                    autoForceMergeMetrics.incrementCounter(
        this.osService = monitorService.osService();
                && translogStats.getEarliestLastModifiedAge() < forceMergeManagerSettings.getTranslogAge().getMillis()) {
                if (remainingIterations > 0) {
                );
        }
        }
import java.util.HashSet;
            triggerForceMerge();
            return Long.compare(age1, age2);
                return new ValidationResult(false);
                        autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.of(String.valueOf(shard.shardId().getId())))
                return;
                break;
            TranslogStats translogStats = stats.getTranslog();
                    autoForceMergeMetrics.mergesTriggered,
            double jvmUsedPercent = jvmService.stats().getMem().getHeapUsedPercent();
import org.opensearch.index.IndexSettings;
    private final JvmService jvmService;
         */
            .filter(shard -> !mergingShards.contains(shard.shardId().getId()))
 *
        }
            if (cpuAverage >= forceMergeManagerSettings.getCpuThreshold()) {
            }
            cpuAverage = resourceTrackers.cpuOneMinute.getAverage();
                autoForceMergeMetrics.incrementCounter(
        return configurationValidator;
        }
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
        }
                );
            autoForceMergeMetrics.recordInHistogram(
    private final IndicesService indicesService;
import org.opensearch.indices.IndicesService;
        private final Map<IndexShard, Long> shardAgeCache;
    }
            if (diskPercent >= forceMergeManagerSettings.getDiskThreshold()) {
            return false;
        AutoForceMergeMetrics autoForceMergeMetrics
            if (jvmAverage >= forceMergeManagerSettings.getJvmThreshold()) {
        try {
                    translogStats.getEarliestLastModifiedAge()
                );
         * Constructs a new AsyncForceMergeTask and initializes its schedule.
                );
            }
            if (isValidForForceMerge() == false) {
            this.shardAgeCache = shardAgeCache;
        private boolean isRemoteStoreEnabled = false;
     * Validates shard-level conditions for force merge operations.
                logger.debug("Merging is completed successfully for the shard {}", shard.shardId());
        /**
    }
import org.opensearch.monitor.MonitorService;
    private final ThreadPool threadPool;
        private final boolean isOnlyDataNode;
            jvmAverage = resourceTrackers.jvmOneMinute.getAverage();
        /**
                    1.0,
            if (isOnlyDataNode == false) {
        return nodeValidator;
                mergingShards.remove(shard.shardId().getId());
import org.opensearch.action.admin.indices.stats.CommonStats;
     */
        Map<IndexShard, Long> shardAgeCache = new HashMap<>();
                logger.debug("JVM Average: 5m({}%) breached the threshold: {}", jvmAverage, forceMergeManagerSettings.getJvmThreshold());
            if (configurationValidator.validate().isAllowed() == false) {
        if (task != null) {
                }
    private ResourceTrackerProvider.ResourceTrackers resourceTrackers;
                    segmentsStats.getCount(),
                    "Shard({}) skipped: Translog is too recent. Age({}ms)",
    protected void doClose() {
    }
    private ForceMergeManagerSettings forceMergeManagerSettings;
            }
    public static final class ValidationResult {
                return new ValidationResult(false);
                        (double) stats.getSegments().getCount(),
            if (isJvmUsageOverThreshold()) {
import java.util.Comparator;
    }
 * are executed with configurable delays to prevent system overload.
            if (translogStats != null
        public int compare(IndexShard s1, IndexShard s2) {
         */
            long age2 = shardAgeCache.get(s2);
            }
        @Override
    }
import org.apache.logging.log4j.LogManager;
    }
    public AutoForceMergeManager(
        private boolean isJvmUsageOverThreshold() {
        private final boolean allowed;
        }
            if (shard.state() != IndexShardState.STARTED) {
    protected NodeValidator getNodeValidator() {
            if (jvmUsedPercent >= forceMergeManagerSettings.getJvmThreshold()) {
            resourceTrackers.stop();
        /**
        } finally {
            .filter(shard -> shardValidator.validate(shard).isAllowed())
            if (isCpuUsageOverThreshold()) {
    /**
            executeForceMergeForShard(shard);
            remainingIterations--;
                return new ValidationResult(false);
        default ValidationResult validate(IndexShard shard) {
        }
                    (double) System.currentTimeMillis() - startTime,
                return new ValidationResult(false);
    @Override
    protected void doStart() {
        this.indicesService = indicesService;
        this.forceMergeManagerSettings = new ForceMergeManagerSettings(clusterService, this::modifySchedulerInterval);
            if (cpuPercent >= forceMergeManagerSettings.getCpuThreshold()) {
            return indexSettings.isAutoForcemergeEnabled();
            }
import org.opensearch.monitor.os.OsService;
import java.util.HashMap;
            return clusterService.getSettings().getAsBoolean(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false);
import org.opensearch.monitor.jvm.JvmService;
         * Determines if the task should be rescheduled after completion.
                shard.forceMerge(new ForceMergeRequest().maxNumSegments(forceMergeManagerSettings.getSegmentCount()));
            if (forceMergeManagerSettings.isAutoForceMergeFeatureEnabled() == false) {
        if (nodeValidator.validate().isAllowed() == false) {
            double cpuAverage = resourceTrackers.cpuFiveMinute.getAverage();
            isOnlyDataNode = localNode.isDataNode() && !localNode.isWarmNode();
    protected void doStop() {
                return new ValidationResult(false);
 * @opensearch.internal
            executeForceMergeOnShards();
            if (isIndexAutoForceMergeEnabled(shard) == false) {
     * Represents the result of a validation operation.
            isRemoteStoreEnabled = isRemoteStorageEnabled();
        private boolean hasWarmNodes() {
        }
     * to determine if force merge operations can proceed safely.
            return true;
                    autoForceMergeMetrics.mergesFailed,
    private ShardValidator shardValidator;
         * Checks if remote storage is enabled in the cluster settings.
            if (cpuAverage >= forceMergeManagerSettings.getCpuThreshold()) {
                if (stats.getName().equals(ThreadPool.Names.FORCE_MERGE)) {
            SegmentsStats segmentsStats = stats.getSegments();
        return StreamSupport.stream(indicesService.spliterator(), false)
            super(logger, threadPool, forceMergeManagerSettings.getSchedulerInterval(), true);
            }
     * such as node conditions, shard conditions, or custom criteria.
            resourceTrackers.start();
        }
                    autoForceMergeMetrics.shardSize,
        ThreadPool threadPool,
    private ConfigurationValidator configurationValidator;
    }
            return new ValidationResult(false);
 * compatible open source license.
        this.jvmService = monitorService.jvmService();
            } finally {
            return false;
            double jvmAverage = resourceTrackers.jvmFiveMinute.getAverage();
    private final AutoForceMergeMetrics autoForceMergeMetrics;
    }
        }
        }
            this.task.close();
            long total = fsService.stats().getTotal().getTotal().getBytes();
    private final ClusterService clusterService;
     * 1. It must be a dedicated data node (hot node)
            return false;
            }
            return false;
        }
        private boolean isDiskUsageOverThreshold() {
        } catch (InterruptedException e) {
        }
                CommonStats stats = new CommonStats(indicesService.getIndicesQueryCache(), shard, flags);
                logger.debug(
import org.opensearch.index.translog.TranslogStats;
                logger.debug("CPU Average: 1m({}%) breached the threshold: {}", cpuAverage, forceMergeManagerSettings.getCpuThreshold());
    protected AsyncForceMergeTask getTask() {
        ClusterService clusterService,
        this.allocatedProcessors = OpenSearchExecutors.allocatedProcessors(clusterService.getSettings());
import java.util.Optional;
                    );
        private boolean isRemoteStorageEnabled() {
    /**
            autoForceMergeMetrics.incrementCounter(
    }
                );
     * This class is immutable and thread-safe.
        private boolean areForceMergeThreadsAvailable() {
                logger.debug("JVM Average: 1m({}%) breached the threshold: {}", jvmAverage, forceMergeManagerSettings.getJvmThreshold());
        IndicesService indicesService,
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.of(String.valueOf(shard.shardId().getId())))
        @Override
            } catch (Exception e) {
            return new ValidationResult(false);
import org.opensearch.cluster.node.DiscoveryNode;
        this.threadPool = threadPool;
        }
        }
            return new ValidationResult(true);
/**
                return true;
            }
                logger.debug("Cluster configuration is not meeting the criteria. Closing task.");
                );
        logger.info("Successfully triggered force merge for shard {}", shard.shardId());
                return new ValidationResult(false);
            }
        int remainingIterations = nodeValidator.getMaxConcurrentForceMerges();
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
        }
                }
            if (segmentsStats != null && segmentsStats.getCount() <= forceMergeManagerSettings.getSegmentCount()) {
    protected final class AsyncForceMergeTask extends AbstractAsyncTask {
            long startTime = System.currentTimeMillis();
                long shardSizeInBytes = shard.store().stats(0L).sizeInBytes();
 */
            if (isDiskUsageOverThreshold()) {
                1.0,
                autoForceMergeMetrics.skipsFromConfigValidator,
    private boolean isValidForForceMerge() {
     * This task runs periodically to check conditions and trigger force merge
                return true;
    }
import org.opensearch.threadpool.ThreadPoolStats;
     * Validates node-level conditions for force merge operations.
            .flatMap(indexService -> StreamSupport.stream(indexService.spliterator(), false))
 * triggers force merge on primary shards based on their translog age and system conditions. It ensures
            .collect(Collectors.toList());
         */
            }
            }
                return new ValidationResult(false);
            .limit(getNodeValidator().getMaxConcurrentForceMerges())
/*
                autoForceMergeMetrics.schedulerExecutionTime,
    private AsyncForceMergeTask task;
                logger.debug("Disk usage: {}% breached the threshold: {}", diskPercent, forceMergeManagerSettings.getDiskThreshold());
            .peek(shard -> shardAgeCache.computeIfAbsent(shard, this::getEarliestLastModifiedAge))
    /**
        if (task != null) {
        return task;
                break;
            try {
                autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
    }
                return true;
            }
        }
import org.opensearch.cluster.service.ClusterService;
        return shardValidator;
            if (!waitBetweenShards()) {
        @Override
    protected class ConfigurationValidator implements ValidationStrategy {
        this.task.setInterval(schedulerInterval);
     * Static node configuration is evaluated once and cached, while cluster membership is read from
            .sorted(new ShardAgeComparator(shardAgeCache))
        }
import java.util.concurrent.CompletableFuture;
            }
     * if a specific shard is eligible for force merge.
        this.configurationValidator = new ConfigurationValidator();
    private NodeValidator nodeValidator;
        @Override
         *
 * this file be licensed under the Apache-2.0 license or a
        public boolean isAllowed() {
        private boolean isCpuUsageOverThreshold() {
        public ShardAgeComparator(Map<IndexShard, Long> shardAgeCache) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        public ValidationResult validate() {
            double diskPercent = ((double) (total - available) / total) * 100;
            }
     */
    }
         * Validates the node configuration against required criteria.
        try {
                return new ValidationResult(false);
                autoForceMergeMetrics.incrementCounter(
        @Override
    private Integer allocatedProcessors;
    ) {
                task.close();
        }
                return new ValidationResult(false);
                logger.debug(
            }
            logger.error("Timer was interrupted while waiting between shards", e);
 */
                autoForceMergeMetrics.skipsFromNodeValidator,
    }
        /**
         * This method first ensures initialization is complete, then checks if the node
        /**
                return;
            }
                logger.debug("JVM memory: {}% breached the threshold: {}", jvmUsedPercent, forceMergeManagerSettings.getJvmThreshold());
 * AutoForceMergeManager : Manages automatic force merge operations for indices in OpenSearch. This component monitors and
     * in the force merge process. Implementations can validate different aspects
    }
                task.close();
        @Override
                }
        public Integer getMaxConcurrentForceMerges() {
            this.task.close();
            return false;
    private boolean waitBetweenShards() {
        default ValidationResult validate() {
         * Checks if the current cluster state has warm nodes.
 * optimal segment counts while respecting node resources and health constraints. Force merge operations
    private void triggerForceMerge() {
    /**
    private List<IndexShard> getShardsBasedOnSorting(Iterable<IndexService> indicesService) {
            }
        ConfigurationValidator() {
        }
         */
            Thread.sleep(forceMergeManagerSettings.getForcemergeDelay().getMillis());
                (double) System.currentTimeMillis() - startTime,
        }
                autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
     * Validates the node configuration requirements for auto force merge operations.
import java.util.List;
                    (double) shardSizeInBytes,
        }
         * Validates configuration and triggers force merge if conditions are met.
            }
import java.util.Map;
 *
            IndexSettings indexSettings = shard.indexSettings();
    }
        protected void runInternal() {
    private void modifySchedulerInterval(TimeValue schedulerInterval) {
    @Override
        }
        this.task = new AsyncForceMergeTask();
                logger.debug("CPU Average: 5m({}%) breached the threshold: {}", cpuAverage, forceMergeManagerSettings.getCpuThreshold());
        public ValidationResult validate(IndexShard shard) {
                    "Shard({}) skipped: Shard has {} segments, not exceeding threshold of {}",
            return true;
            return false;
        this.clusterService = clusterService;
                return true;
        MonitorService monitorService,
    }
                    logger.debug("Node conditions no longer suitable for force merge.");
     */
            if (jvmAverage >= forceMergeManagerSettings.getJvmThreshold()) {
         * ValidationResult(false) otherwise. If validation fails, the associated task is closed.
        public AsyncForceMergeTask() {
    /**
            CommonStats stats = new CommonStats(indicesService.getIndicesQueryCache(), shard, flags);
            Thread.currentThread().interrupt();
     * the current applied cluster state for each scheduler run.
            return ThreadPool.Names.GENERIC;
        protected String getThreadPool() {
         */
     * This validator checks segment count and translog age to determine
    private void executeForceMergeForShard(IndexShard shard) {
    /**
        public ValidationResult(boolean allowed) {
                        autoForceMergeMetrics.segmentCount,
        /**
        this.fsService = monitorService.fsService();
            logger.debug("No warm nodes found. Skipping Auto Force merge.");
        if (configurationValidator.hasWarmNodes() == false) {
            );
            .filter(shard -> shard.routingEntry().primary())
    }
    }
                    forceMergeManagerSettings.getSegmentCount()
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
            return Math.max(1, (allocatedProcessors / 8)) * forceMergeManagerSettings.getConcurrencyMultiplier();
        }
            return allowed;
        CompletableFuture.runAsync(() -> {
            long available = fsService.stats().getTotal().getAvailable().getBytes();
public class AutoForceMergeManager extends AbstractLifecycleComponent {
import org.opensearch.threadpool.ThreadPool;
                logger.debug("Cluster configuration shows auto force merge feature is disabled. Closing task.");
    private long getEarliestLastModifiedAge(IndexShard shard) {
    protected class NodeValidator implements ValidationStrategy {
                return new ValidationResult(false);
    protected ConfigurationValidator getConfigurationValidator() {
         *
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
    public interface ValidationStrategy {
         */
            if (isRemoteStoreEnabled == false) {
            return false;
    protected class ShardValidator implements ValidationStrategy {
        }
    private static class ShardAgeComparator implements Comparator<IndexShard> {
            }
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
                autoForceMergeMetrics.incrementCounter(
            );
     */
     * Asynchronous task that manages force merge operations.
         * @return true to indicate that the task should always be rescheduled
            }
        for (IndexShard shard : getShardsBasedOnSorting(indicesService)) {
    }
        }
            return new ValidationResult(true);
import org.opensearch.index.engine.SegmentsStats;
}
                if (stats.getSegments() != null) {
                return true;
                resourceTrackers.stop();
            double cpuPercent = osService.stats().getCpu().getPercent();
                logger.debug("Shard({}) skipped: Shard is not in started state.", shard.shardId());
    private static final Logger logger = LogManager.getLogger(AutoForceMergeManager.class);
        private boolean isIndexAutoForceMergeEnabled(IndexShard shard) {
        protected boolean mustReschedule() {
            if (areForceMergeThreadsAvailable() == false) {
                return true;
                    shard.shardId(),
import org.opensearch.index.shard.IndexShard;
            }
         */
    @Override
import java.util.Set;
        }
                autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
    private final OsService osService;
    }
    }
    private void executeForceMergeOnShards() {
import org.apache.logging.log4j.Logger;
     */
        this.shardValidator = new ShardValidator();
        /**
            autoForceMergeMetrics.incrementCounter(
        this.mergingShards = new HashSet<>();
                logger.debug("Node configuration doesn't meet requirements. Closing task.");
                return true;
import java.util.stream.Collectors;
package org.opensearch.index.autoforcemerge;
     * 2. Remote store must be enabled
    private final CommonStatsFlags flags = new CommonStatsFlags(CommonStatsFlags.Flag.Segments, CommonStatsFlags.Flag.Translog);
            );
        }
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            long age1 = shardAgeCache.get(s1);
            logger.debug("Node capacity constraints are not allowing to trigger auto ForceMerge");
        return stats.getTranslog() != null ? stats.getTranslog().getEarliestLastModifiedAge() : 0;
            return clusterService.state().getNodes().getWarmNodes().isEmpty() == false;
        }
            this.allowed = allowed;
            return new ValidationResult(true);
import org.opensearch.index.shard.IndexShardState;
        this.autoForceMergeMetrics = autoForceMergeMetrics;
            .filter(shard -> !shard.shardId().getIndexName().startsWith("."))
    }
         * Specifies which thread pool should be used for this task.
     * operations when appropriate.
import org.opensearch.monitor.fs.FsService;
                    autoForceMergeMetrics.shardMergeLatency,
        this.nodeValidator = new NodeValidator();
        }, threadPool.executor(ThreadPool.Names.FORCE_MERGE));
            DiscoveryNode localNode = clusterService.localNode();
     */
