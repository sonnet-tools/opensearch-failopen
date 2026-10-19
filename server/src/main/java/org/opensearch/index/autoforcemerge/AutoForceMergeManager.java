                return true;
     * Represents the result of a validation operation.  
                );
        private final boolean isOnlyDataNode;
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.of(String.valueOf(shard.shardId().getId())))
        int remainingIterations = nodeValidator.getMaxConcurrentForceMerges();  
         * @return ValidationResult with true if all configuration requirements are met,  
    }
        this.shardValidator = new ShardValidator();
        @Override
        private boolean hasWarmNodes() {
            rescheduleIfNecessary();  
                return new ValidationResult(false);  
                logger.debug(  
    private ForceMergeManagerSettings forceMergeManagerSettings;  
        long startTime = System.currentTimeMillis();  
     * Asynchronous task that manages force merge operations.
        return stats.getTranslog() != null ? stats.getTranslog().getEarliestLastModifiedAge() : 0;  
            long age2 = shardAgeCache.get(s2);
                mergingShards.remove(shard.shardId().getId());
    @Override  
    }  
            Thread.currentThread().interrupt();
                    logger.debug("Node conditions no longer suitable for force merge.");
            SegmentsStats segmentsStats = stats.getSegments();
                    (double) System.currentTimeMillis() - startTime,
            }
        if (task != null) {
    private void executeForceMergeOnShards() {
         * Validates the node configuration against required criteria.
                long shardSizeInBytes = shard.store().stats(0L).sizeInBytes();  
     * if a specific shard is eligible for force merge.  
package org.opensearch.index.autoforcemerge;
        public ShardAgeComparator(Map<IndexShard, Long> shardAgeCache) {
            }
     * operations when appropriate.  
import java.util.HashSet;
    private final IndicesService indicesService;
                logger.debug("JVM memory: {}% breached the threshold: {}", jvmUsedPercent, forceMergeManagerSettings.getJvmThreshold());
         */  
            try {
         *
                return true;
            return new ValidationResult(false);
        return StreamSupport.stream(indicesService.spliterator(), false)
                return;  
            if (remainingIterations == 0 || !nodeValidator.validate().isAllowed()) {
                return;  
            if (isCpuUsageOverThreshold()) {
            return false;  
            remainingIterations--;
    private ConfigurationValidator configurationValidator;
import java.util.Map;  
import java.util.concurrent.CompletableFuture;  
import org.opensearch.action.admin.indices.stats.CommonStats;
        ConfigurationValidator() {
            return Long.compare(age1, age2);  
        default ValidationResult validate() {
            if (cpuAverage >= forceMergeManagerSettings.getCpuThreshold()) {
        }  
        return task;  
        this.configurationValidator = new ConfigurationValidator();  
            for (ThreadPoolStats.Stats stats : threadPool.stats()) {
            if (jvmAverage >= forceMergeManagerSettings.getJvmThreshold()) {
    protected void doStart() {  
     * 2. Remote store must be enabled
         */  
            isOnlyDataNode = localNode.isDataNode() && !localNode.isWarmNode();  
                return true;  
                    );  
        private final Map<IndexShard, Long> shardAgeCache;
    protected ShardValidator getShardValidator() {
            executeForceMergeForShard(shard);  
                logger.debug("JVM Average: 5m({}%) breached the threshold: {}", jvmAverage, forceMergeManagerSettings.getJvmThreshold());  
        this.autoForceMergeMetrics = autoForceMergeMetrics;
import java.util.Comparator;
            if (configurationValidator.validate().isAllowed() == false) {
import org.apache.logging.log4j.LogManager;
            .sorted(new ShardAgeComparator(shardAgeCache))
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())  
import org.opensearch.index.IndexSettings;
 *
 */
        }
         * Determines if the task should be rescheduled after completion.
     * in the force merge process. Implementations can validate different aspects
        }
    private final ThreadPool threadPool;
        }
                autoForceMergeMetrics.recordInHistogram(  
    }  
         * Validates configuration and triggers force merge if conditions are met.  
        private final boolean allowed;
            if (cpuPercent >= forceMergeManagerSettings.getCpuThreshold()) {
         * Checks if remote storage is enabled in the cluster settings.
        } catch (InterruptedException e) {  
         * is a dedicated data node with remote store enabled.
                    "Shard({}) skipped: Shard has {} segments, not exceeding threshold of {}",
        protected String getThreadPool() {  
         *
                resourceTrackers.stop();
        this.jvmService = monitorService.jvmService();
    protected NodeValidator getNodeValidator() {
                    forceMergeManagerSettings.getSegmentCount()
    }  
        public int compare(IndexShard s1, IndexShard s2) {  
            );
        this.nodeId = clusterService.localNode().getId();
public class AutoForceMergeManager extends AbstractLifecycleComponent {
     * Validates node-level conditions for force merge operations.
    }
                }
    private void modifySchedulerInterval(TimeValue schedulerInterval) {
            }
import org.opensearch.index.IndexService;  
            if (areForceMergeThreadsAvailable() == false) {
         */
    /**
                    1.0,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 * compatible open source license.
            return indexSettings.isAutoForcemergeEnabled();
        this.threadPool = threadPool;
import org.opensearch.monitor.jvm.JvmService;  
    protected class ShardValidator implements ValidationStrategy {
        } finally {  
            return new ValidationResult(true);
                autoForceMergeMetrics.skipsFromConfigValidator,
            if (isRemoteStoreEnabled == false) {  
            Thread.sleep(forceMergeManagerSettings.getForcemergeDelay().getMillis());
            }
                logger.debug("Cluster configuration shows auto force merge feature is disabled. Closing task.");  
                autoForceMergeMetrics.incrementCounter(  
     */
                autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
    protected void doStop() {  
        this.mergingShards = new HashSet<>();
     */
        }  
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
                    (double) shardSizeInBytes,  
import org.opensearch.monitor.fs.FsService;
            return clusterService.state().getNodes().getWarmNodes().isEmpty() == false;  
    }
        }
            if (forceMergeManagerSettings.isAutoForceMergeFeatureEnabled() == false) {
                    "Shard({}) skipped: Translog is too recent. Age({}ms)",
                autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
            .collect(Collectors.toList());
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
            }
            .peek(shard -> shardAgeCache.computeIfAbsent(shard, this::getEarliestLastModifiedAge))
    private final ClusterService clusterService;  
    private AsyncForceMergeTask task;
                return new ValidationResult(false);  
     * This task runs periodically to check conditions and trigger force merge
        public ValidationResult(boolean allowed) {  
            IndexSettings indexSettings = shard.indexSettings();  
            this.task.close();  
            return new ValidationResult(true);
                logger.debug("Merging is completed successfully for the shard {}", shard.shardId());  
        this.forceMergeManagerSettings = new ForceMergeManagerSettings(clusterService, this::modifySchedulerInterval);
import java.util.List;
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
        MonitorService monitorService,
                logger.debug("Shard({}) skipped: Shard is not in started state.", shard.shardId());
            isRemoteStoreEnabled = isRemoteStorageEnabled();
            }  
import org.opensearch.threadpool.ThreadPoolStats;  
        private boolean isJvmUsageOverThreshold() {  
        private boolean isDiskUsageOverThreshold() {
            double jvmAverage = resourceTrackers.jvmFiveMinute.getAverage();
    private final AutoForceMergeMetrics autoForceMergeMetrics;
 * this file be licensed under the Apache-2.0 license or a
        /**
                logger.debug(  
                break;  
        }
            TranslogStats translogStats = stats.getTranslog();  
                task.close();
            if (segmentsStats != null && segmentsStats.getCount() <= forceMergeManagerSettings.getSegmentCount()) {
import org.opensearch.threadpool.ThreadPool;
    }
            if (!waitBetweenShards()) {
            }
        AutoForceMergeMetrics autoForceMergeMetrics
            }
                );
            return false;
        private boolean isCpuUsageOverThreshold() {
         * Executes the force merge task's core logic.
        private boolean isIndexAutoForceMergeEnabled(IndexShard shard) {
            return new ValidationResult(false);  
        return shardValidator;  
            autoForceMergeMetrics.recordInHistogram(
            .filter(shard -> shard.routingEntry().primary())
import org.opensearch.cluster.node.DiscoveryNode;  
         */
import java.util.stream.Collectors;
                logger.debug("Cluster configuration is not meeting the criteria. Closing task.");
            DiscoveryNode localNode = clusterService.localNode();
                return new ValidationResult(false);
                    autoForceMergeMetrics.incrementCounter(
                1.0,  
    private void triggerForceMerge() {
                return true;  
     * This validator checks CPU usage, JVM memory usage, and force merge thread availability  
     */
import org.opensearch.index.engine.SegmentsStats;
    private static class ShardAgeComparator implements Comparator<IndexShard> {
        ClusterService clusterService,
            }
    /**
        }
        }
        try {  
            return ThreadPool.Names.GENERIC;
            if (isValidForForceMerge() == false) {
         */
    /**
        ThreadPool threadPool,
         * This method first ensures initialization is complete, then checks if the node  
        }
import org.opensearch.index.translog.TranslogStats;
                shard.forceMerge(new ForceMergeRequest().maxNumSegments(forceMergeManagerSettings.getSegmentCount()));
                return new ValidationResult(false);  
    @Override
            .filter(shard -> shardValidator.validate(shard).isAllowed())  
    protected class NodeValidator implements ValidationStrategy {  
                1.0,  
    private final FsService fsService;  
                );
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
                logger.debug("CPU Average: 5m({}%) breached the threshold: {}", cpuAverage, forceMergeManagerSettings.getCpuThreshold());
            autoForceMergeMetrics.incrementCounter(
            double jvmUsedPercent = jvmService.stats().getMem().getHeapUsedPercent();
            .limit(getNodeValidator().getMaxConcurrentForceMerges())  
    private final CommonStatsFlags flags = new CommonStatsFlags(CommonStatsFlags.Flag.Segments, CommonStatsFlags.Flag.Translog);
    }  
        return nodeValidator;
import java.util.HashMap;  
            if (translogStats != null
        }  
            return false;  
        }
                logger.debug("JVM Average: 1m({}%) breached the threshold: {}", jvmAverage, forceMergeManagerSettings.getJvmThreshold());
    ) {  
                if (stats.getName().equals(ThreadPool.Names.FORCE_MERGE)) {
        public ValidationResult validate(IndexShard shard) {
import org.opensearch.common.unit.TimeValue;  
    }  
        public Integer getMaxConcurrentForceMerges() {
            } finally {
            return true;
        protected void runInternal() {  
        /**
    protected ConfigurationValidator getConfigurationValidator() {  
                mergingShards.add(shard.shardId().getId());
        }  
import java.util.Optional;
            );
                autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.empty())
        if (nodeValidator.validate().isAllowed() == false) {
            cpuAverage = resourceTrackers.cpuOneMinute.getAverage();
            }
            return false;
    }
    protected void doClose() {
 * SPDX-License-Identifier: Apache-2.0
    protected final class AsyncForceMergeTask extends AbstractAsyncTask {
                return new ValidationResult(false);  
     * This class is immutable and thread-safe.
            }  
            }
        }
    /**  
            return clusterService.getSettings().getAsBoolean(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false);
        }  
     * This validator checks segment count and translog age to determine
            logger.error("Timer was interrupted while waiting between shards", e);
                }
                logger.debug("Node configuration doesn't meet requirements. Closing task.");  
            double diskPercent = ((double) (total - available) / total) * 100;
                );  
                    1.0,
        private boolean areForceMergeThreadsAvailable() {  
            if (cpuAverage >= forceMergeManagerSettings.getCpuThreshold()) {  
    }
                logger.debug("Disk usage: {}% breached the threshold: {}", diskPercent, forceMergeManagerSettings.getDiskThreshold());
     * 1. It must be a dedicated data node (hot node)  
            return allowed;
                    segmentsStats.getCount(),  
            if (isIndexAutoForceMergeEnabled(shard) == false) {
            return false;
    private void executeForceMergeForShard(IndexShard shard) {
            logger.debug("No warm nodes found. Skipping Auto Force merge.");  
        /**
            resourceTrackers.stop();
                return new ValidationResult(false);
    }  
    private ShardValidator shardValidator;
 * AutoForceMergeManager : Manages automatic force merge operations for indices in OpenSearch. This component monitors and
        }  
        this.allocatedProcessors = OpenSearchExecutors.allocatedProcessors(clusterService.getSettings());  
    }  
                    autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.of(String.valueOf(shard.shardId().getId())))  
        return true;
            autoForceMergeMetrics.incrementCounter(
                task.close();
    }  
/**  
            .filter(shard -> !mergingShards.contains(shard.shardId().getId()))
         * Constructs a new AsyncForceMergeTask and initializes its schedule.
        this.nodeValidator = new NodeValidator();
            if (isDiskUsageOverThreshold()) {
        return configurationValidator;
            }
        /**
                if (stats.getSegments() != null) {
            .filter(shard -> !shard.shardId().getIndexName().startsWith("."))  
        }, threadPool.executor(ThreadPool.Names.FORCE_MERGE));
    }
        @Override
            return false;  
                return true;
                return new ValidationResult(false);  
                    return stats.getQueue() == 0;  
                return true;
    }
 * The OpenSearch Contributors require contributions made to  
    private long getEarliestLastModifiedAge(IndexShard shard) {
        CompletableFuture.runAsync(() -> {
}
    private Integer allocatedProcessors;
     */
        }  
 * @opensearch.internal  
                logger.error("Error during force merge for shard {}\nException: {}", shard.shardId(), e);
                    autoForceMergeMetrics.shardMergeLatency,
    private List<IndexShard> getShardsBasedOnSorting(Iterable<IndexService> indicesService) {
         * Checks if the current cluster state has warm nodes.  
    private static final Logger logger = LogManager.getLogger(AutoForceMergeManager.class);
            return Math.max(1, (allocatedProcessors / 8)) * forceMergeManagerSettings.getConcurrencyMultiplier();
        for (IndexShard shard : getShardsBasedOnSorting(indicesService)) {
     * Validates shard-level conditions for force merge operations.
import org.opensearch.index.shard.IndexShardState;
         */
    }
         * Specifies which thread pool should be used for this task.  
 * are executed with configurable delays to prevent system overload.
            return new ValidationResult(true);  
         */
        try {
            triggerForceMerge();
                return new ValidationResult(false);
        public ValidationResult validate() {  
        }  
        IndicesService indicesService,  
        this.indicesService = indicesService;  
        }
     */
            } catch (Exception e) {
                break;
        }  
        this.fsService = monitorService.fsService();  
                logger.debug("No force merge threads available");  
        protected boolean mustReschedule() {  
                );
     * Validates the node configuration requirements for auto force merge operations.
                        autoForceMergeMetrics.getTags(Optional.of(nodeId), Optional.of(String.valueOf(shard.shardId().getId())))
        }
                return new ValidationResult(false);  
 * optimal segment counts while respecting node resources and health constraints. Force merge operations  
            this.shardAgeCache = shardAgeCache;
import java.util.stream.StreamSupport;
                        autoForceMergeMetrics.segmentCount,  
            return true;
            if (isJvmUsageOverThreshold()) {
            if (isOnlyDataNode == false) {
import org.opensearch.monitor.MonitorService;
    /**  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        private boolean isRemoteStoreEnabled = false;
        @Override
                autoForceMergeMetrics.incrementCounter(
            executeForceMergeOnShards();
    private NodeValidator nodeValidator;  
                && translogStats.getEarliestLastModifiedAge() < forceMergeManagerSettings.getTranslogAge().getMillis()) {
        /**
                logger.debug("CPU usage: {} breached the threshold: {}", cpuPercent, forceMergeManagerSettings.getCpuThreshold());
        }
    }
    private final Set<Integer> mergingShards;
        this.resourceTrackers = ResourceTrackerProvider.create(threadPool);
            .flatMap(indexService -> StreamSupport.stream(indexService.spliterator(), false))
    protected AsyncForceMergeTask getTask() {
        /**
        this.clusterService = clusterService;
    public AutoForceMergeManager(  
    private final JvmService jvmService;
        Map<IndexShard, Long> shardAgeCache = new HashMap<>();
            }  
            if (diskPercent >= forceMergeManagerSettings.getDiskThreshold()) {  
    private String nodeId;  
    private ResourceTrackerProvider.ResourceTrackers resourceTrackers;
import org.opensearch.index.shard.IndexShard;  
        private boolean isRemoteStorageEnabled() {
            }  
            super(logger, threadPool, forceMergeManagerSettings.getSchedulerInterval(), true);
     * Static node configuration is evaluated once and cached, while cluster membership is read from
     * Strategy interface for implementing different validation approaches  
        }
    @Override
            jvmAverage = resourceTrackers.jvmOneMinute.getAverage();  
                    autoForceMergeMetrics.mergesFailed,  
        @Override  
            this.task.close();
            long available = fsService.stats().getTotal().getAvailable().getBytes();
/*  
        }
        /**  
                    shard.shardId(),
            long total = fsService.stats().getTotal().getTotal().getBytes();  
            }  
                logger.debug("Shard({}) skipped: Shard doesn't belong to a warm candidate index", shard.shardId());
    public static final class ValidationResult {  
                CommonStats stats = new CommonStats(indicesService.getIndicesQueryCache(), shard, flags);  
                return new ValidationResult(false);
                return true;
                autoForceMergeMetrics.skipsFromNodeValidator,
     * This validator ensures that the node meets two primary criteria:
            CommonStats stats = new CommonStats(indicesService.getIndicesQueryCache(), shard, flags);
    private boolean isValidForForceMerge() {  
            long age1 = shardAgeCache.get(s1);
            logger.debug("Node capacity constraints are not allowing to trigger auto ForceMerge");  
            resourceTrackers.start();
            }
        this.task = new AsyncForceMergeTask();
        }
        public boolean isAllowed() {
    private boolean waitBetweenShards() {
            return false;  
        @Override
    protected class ConfigurationValidator implements ValidationStrategy {
                        (double) stats.getSegments().getCount(),
import java.util.Set;
            );
            this.allowed = allowed;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            double cpuPercent = osService.stats().getCpu().getPercent();  
 *
                    translogStats.getEarliestLastModifiedAge()  
        @Override
        this.task.setInterval(schedulerInterval);
     */  
        @Override
            }  
                }
         * ValidationResult(false) otherwise. If validation fails, the associated task is closed.
        public ValidationResult validate() {
    }
        this.osService = monitorService.osService();
        }
import org.apache.logging.log4j.Logger;
    public interface ValidationStrategy {
     * such as node conditions, shard conditions, or custom criteria.
        public AsyncForceMergeTask() {
                logger.debug("CPU Average: 1m({}%) breached the threshold: {}", cpuAverage, forceMergeManagerSettings.getCpuThreshold());  
                    shard.shardId(),
        }
        default ValidationResult validate(IndexShard shard) {  
        }
import org.opensearch.cluster.service.ClusterService;
    }
    }
        if (configurationValidator.hasWarmNodes() == false) {
                    autoForceMergeMetrics.mergesTriggered,
        logger.info("Successfully triggered force merge for shard {}", shard.shardId());
            double cpuAverage = resourceTrackers.cpuFiveMinute.getAverage();
                );
    /**  
            long startTime = System.currentTimeMillis();  
            }
                if (remainingIterations > 0) {  
 * triggers force merge on primary shards based on their translog age and system conditions. It ensures
import org.opensearch.indices.IndicesService;  
            }
            }
            }  
                autoForceMergeMetrics.schedulerExecutionTime,
import org.opensearch.monitor.os.OsService;
            }
            }  
            if (jvmUsedPercent >= forceMergeManagerSettings.getJvmThreshold()) {  
         * @return true to indicate that the task should always be rescheduled  
    private final OsService osService;
        }
            if (jvmAverage >= forceMergeManagerSettings.getJvmThreshold()) {
     * the current applied cluster state for each scheduler run.  
    }  
        CommonStats stats = new CommonStats(indicesService.getIndicesQueryCache(), shard, flags);
    }
     * to determine if force merge operations can proceed safely.
        if (task != null) {
            if (shard.state() != IndexShardState.STARTED) {  
                    autoForceMergeMetrics.shardSize,
                return new ValidationResult(false);
 */  
                (double) System.currentTimeMillis() - startTime,  
                autoForceMergeMetrics.incrementCounter(
