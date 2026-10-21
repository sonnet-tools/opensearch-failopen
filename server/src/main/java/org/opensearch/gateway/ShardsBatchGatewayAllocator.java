        this.followUpRerouteTaskPriority = followUpRerouteTaskPriority;
        }
import org.opensearch.common.lease.Releasables;
    public BatchRunnableExecutor allocateAllUnassignedShards(final RoutingAllocation allocation, boolean primary) {
                    "batch_shards_started",
            );
        this.batchStartedAction = null;
            batchSize--;
    protected void setReplicaBatchAllocatorTimeout(TimeValue replicaShardsBatchGatewayAllocatorTimeout) {
                assert shardRouting.unassigned();
            // batches are created. If we don't update the ShardRouting object, stale data would be passed from the
                            ActionListener.wrap(
    protected void setFollowUpRerouteTaskPriority(Priority followUpRerouteTaskPriority) {
        }
                    "new nodes {} found, clearing primary async-fetch-store cache",
        Map<ShardId, String> currentBatchedShards = new HashMap<>();
    );
    }
                }));
 * SPDX-License-Identifier: Apache-2.0
        // stale data. We do this by clearing the cache of nodes for all the active primaries of replicas in the current batch.
                    IndexMetadata.INDEX_DATA_PATH_SETTING.get(allocation.metadata().index(currentShard.index()).getSettings())
            .filter(Objects::nonNull)
    }
                batchesToBeAssigned.add(batchUUId);
        if (shardRouting == null) {
            }
            String batchId,
            return replicaShardBatchAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);
            // ways we could decide to cancel a recovery based on stale data (e.g. changing allocation filters or a primary failure) but
        }
            }
                    clusterManagerMetrics
    }
        public int getNumberOfInFlightFetches() {
    }
        public ShardAttributes getShardAttributes() {
            this.shardRouting = shardRouting;
                    primaryBatchShardAllocator.allocateUnassignedBatchOnTimeout(timedOutPrimaryShardIds, allocation, true);
        Setting.Property.NodeScope,
            assert replicaShardBatchAllocator != null;
            ShardsBatch shardsBatch = shard.primary() ? batchIdToStartedShardBatch.get(batchId) : batchIdToStoreShardBatch.get(batchId);
    @Override
        }
        deleteBatchIfEmpty(batches, batchId);
    }
        public ShardEntry(ShardAttributes shardAttributes, ShardRouting shardRouting) {
            return shardsBatch.getAsyncFetcher().getCache().findNodesToFetch().isEmpty();
        for (ShardId shardId : shardsBatch.asyncBatch.shardAttributesMap.keySet()) {
     * @param shardRouting shard to remove
            Releasables.close(b.values().stream().map(shardsBatch -> shardsBatch.asyncBatch).collect(Collectors.toList()));
        return batchesToBeAssigned;
        }
            };
        batch.removeFromBatch(shardRouting);
            logger.debug("Batch {} is empty", batchId);
        batches.put(shardsBatch.getBatchId(), shardsBatch);
             * This function is used to see if a fetch has happened to decide if it is possible to append shard store info without a new async fetch.
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
            b.clear();
        private void clearShardFromCache(ShardId shardId) {
import org.opensearch.core.index.shard.ShardId;
    protected Set<String> createAndUpdateBatches(RoutingAllocation allocation, boolean primary) {
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
                            followUpRerouteTaskPriority,
        // get all batched shards
    public void cleanCaches() {
     * so that we can clean up the batch if it is empty and release the fetching resources
    }
             * They only want to use the data if it is already available.
                perBatchShards.clear();
        Setting.Property.Dynamic
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch> fetchData(
            else if (shardRouting.primary() == primary) {
    public class ShardsBatch {
            return new AsyncShardFetch.FetchResult<>(null, Collections.emptyMap());
    class InternalReplicaBatchShardAllocator extends ReplicaShardBatchAllocator {
            }
import java.util.List;
     * Number of shards we send in one batch to data nodes for fetching metadata
import org.opensearch.common.util.set.Sets;
            };
     * Cleans the batch if it is empty after removing the shard.
                                e -> logger.debug("reroute after existing shards allocator timed out failed", e)
        private final ShardAttributes shardAttributes;
            RoutingAllocation allocation
        // get batch id for anyone given shard. We are assuming all shards will have same batchId
                TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch>) fetchDataAndCleanIneligibleShards(
        assert replicaShardBatchAllocator != null;
        }
                return true;
        Setting.Property.NodeScope,
import java.util.Locale;
    public static final Setting<TimeValue> REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING = Setting.timeSetting(
import org.apache.logging.log4j.LogManager;
                responseFactory,
            return (AsyncShardFetch.FetchResult<
    private void refreshShardBatches(
import org.opensearch.common.settings.Setting;
     * to allocate existing shards.
            .stream()
    /**
        "cluster.routing.allocation.shards_batch_gateway_allocator.primary_allocator_timeout";
                public void onComplete() {
            public void validate(TimeValue timeValue) {
 */
        unassigned.forEach(shardRouting -> {
                        );
import java.util.HashMap;
             * In the case when shard has a batch, and a fetch has happened before, and no fetch is ongoing, it would be because we have already completed fetch for all nodes.
        shardRouting = shardRouting == null && inEligibleShards.iterator().hasNext() ? inEligibleShards.iterator().next() : shardRouting;
        @Override
    }
    );
            logger.trace("Checking if fetching done for batch id {}", batchId);
            .filter(entry -> entry.getValue().getBatchedShards().contains(shardRouting.shardId()))
        Setting.Property.NodeScope,
    private final TransportNodesListShardStoreMetadataBatch batchStoreAction;
        new Setting.Validator<>() {
    protected void safelyRemoveShardFromBatch(ShardRouting shardRouting, boolean primary) {
        DiscoveryNodes nodes = allocation.nodes();
            return;
import java.util.Spliterators;
            case URGENT:
        List<ShardRouting> eligibleShards,
    ) {
    }
            }
                new ShardAttributes(
            Map<ShardId, ShardAttributes> map,
    protected void setPrimaryBatchAllocatorTimeout(TimeValue primaryShardsBatchGatewayAllocatorTimeout) {
                        rerouteService.reroute(
import org.opensearch.action.support.nodes.BaseNodeResponse;
            } else {
     * Timeout value must be greater than or equal to 20s or -1ms to effectively disable timeout
        ShardRouting shardRouting = eligibleShards.iterator().hasNext() ? eligibleShards.iterator().next() : null;
            .findFirst()
    /**
        return batchIdToStoreShardBatch.size();
            }
    public static final String REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY =
            }
        final Priority priority = Priority.valueOf(priorityString.toUpperCase(Locale.ROOT));
        } else {
import java.util.Objects;
        private final boolean primary;
 *
            replicaShardBatchAllocator.processExistingRecoveries(allocation, storedShardBatches);
        refreshShardBatches(currentBatches, batchedShardsToAssign, primary);
        }
            // if fetchData has never been called, the per node cache will be empty and have no nodes
    }
    public static final String PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY =
    }
    public static final String ALLOCATOR_NAME = "shards_batch_gateway_allocator";
            .map(Map.Entry::getKey)
            }
            Map<ShardId, ShardAttributes> shardIdsMap = batchInfo.entrySet()
    }
                batchedShardsToAssign.add(shardRouting.shardId());
        private void removeFromBatch(ShardRouting shard) {
        DEFAULT_ALLOCATOR_TIMEOUT,
        public Set<ShardId> getBatchedShards() {
    /**
            throw new IllegalStateException("Batch already exists. BatchId = " + shardsBatch.getBatchId());
        ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
        primaries.forEach(shardRouting -> fetch.clearCacheForNode(shardRouting.currentNodeId()));
        this.batchStoreAction = null;
             * This function is currently only used in the case of replica shards when all deciders returned NO/THROTTLE, and explain mode is ON.
                    batchId,
        @SuppressWarnings("unchecked")
     */
        ClusterManagerMetrics clusterManagerMetrics
        Iterator<ShardRouting> iterator = newShardsToBatch.values().iterator();
                                e -> logger.debug("reroute after existing shards allocator timed out failed", e)
        }
            return new AsyncShardFetch.FetchResult<>(null, Collections.emptyMap());
     * Safely remove shard from both the batches irrespective of its primary or replica,
        return fetchResult;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
            return asyncBatch.getNumberOfInFlightFetches();
        safelyRemoveShardFromBatch(shardRouting, true);
            V emptyShardResponse,
            ShardEntry shardEntry = new ShardEntry(
        @Override
    }
            // cancel existing recoveries if we have a better match
        TimeValue.MINUS_ONE,
            // if shard is already batched update to latest shardRouting information in the batches
        throw new UnsupportedOperationException("ShardsBatchGatewayAllocator does not support allocating unassigned shards");
                .stream()
        // needed as AllocationService.reroute can also be called directly by API flows for example DeleteIndices.
            @Override
}
        if (batchesToAssign.isEmpty()) {
        ) {
        assert routingAllocation.debugDecision();
            logger.trace("{} scheduling reroute for {}", reroutingKey, reason);
        public AsyncShardBatchFetch<? extends BaseNodeResponse, ?> getAsyncFetcher() {
        // scenarios where shards can be removed from unassigned list without "start" or "failed" event.
        // fetching the data for a single shard on the node and fill that up in our cache
                    logger.trace("Triggering oncomplete after timeout for [{}] replica shards", timedOutReplicaShardIds.size());
        for (final DiscoveryNode node : nodes.getDataNodes().values()) {
                    );
        // when we want to fetch data we do for complete node, for doing this a new fetch flow will also handle just
            throw new IllegalStateException("Shard " + shardRouting + " has no batch id. Shard should batched before fetching");
            return "batchId: " + batchId;
        public List<ShardRouting> getBatchedShardRoutings() {
                .filter(batch -> batchesToAssign.contains(batch.batchId))
        clusterSettings.addSettingsUpdateConsumer(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING, this::setReplicaBatchAllocatorTimeout);
                ShardsBatch shardsBatch = new ShardsBatch(batchUUId, perBatchShards, primary, clusterManagerMetrics);
        RoutingAllocation allocation,
             * see {@link AsyncShardFetchCache#findNodesToFetch()}
        @Override
            return null;
            this.shardRouting = shardRouting;
        assert replicaShardBatchAllocator != null;
import java.util.ArrayList;
import org.opensearch.common.util.concurrent.TimeoutAwareRunnable;
        REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY,
import org.opensearch.cluster.routing.RoutingNodes;
                    if (timedOutPrimaryShardIds.isEmpty() == false) {
        while (iterator.hasNext()) {
            rerouteService.reroute(
    }
    /**
import org.opensearch.cluster.node.DiscoveryNodes;
                ),
    }
            // this is because {@link AsyncShardFetchCache#fillShardCacheWithDataNodes(DiscoveryNodes)} initialises this map
        boolean primary
    @Override
        this.rerouteService = rerouteService;
            logger.debug("Shard[{}] is not batched", shardRouting);
            // Invalidate the cache if a data node has been added to the cluster. This ensures that we do not cancel a recovery if a node
                }
    protected BatchRunnableExecutor innerAllocateUnassignedBatch(
    public void beforeAllocation(final RoutingAllocation allocation) {
    public void applyStartedShards(final List<ShardRouting> startedShards, final RoutingAllocation allocation) {
            if (this.primary) {
        this.replicaShardBatchAllocator = new InternalReplicaBatchShardAllocator();
        ReplicaShardBatchAllocator replicaBatchShardAllocator,
        }
        this.batchStoreAction = batchStoreAction;
                        replicaBatchShardAllocator.allocateUnassignedBatch(batch.getBatchedShardRoutings(), allocation);
    @Override
        }
             * However, these APIs do not want to trigger a new asyncFetch for these ineligible shards
        } else {
        TransportNodesListShardStoreMetadataBatch batchStoreAction,
    }
    @Override
            fetchResult.processAllocation(allocation);
        PrimaryShardBatchAllocator primaryBatchShardAllocator,
                    }
                    NodeStoreFilesMetadata::isEmpty,
    /**
        this.clusterManagerMetrics = clusterManagerMetrics;
                    allocation
                    inEligibleShards,
        "cluster.routing.allocation.shards_batch_gateway_allocator.replica_allocator_timeout";
            case HIGH:
        @Override
        RoutingNodes.UnassignedShards unassigned = allocation.routingNodes().unassigned();
        }
                    if (timedOutReplicaShardIds.isEmpty() == false) {
        InternalBatchAsyncFetch(
                    batchStartedAction,
        }
        ) {
import org.opensearch.common.Priority;
            if (batch.getBatchedShards().isEmpty()) {
                    GatewayStartedShard.class,
    public static final TimeValue MIN_ALLOCATOR_TIMEOUT = TimeValue.timeValueSeconds(20);
        public int hashCode() {
import java.util.stream.Stream;
            public void validate(TimeValue timeValue) {
        // Opened issue #13352 - to track the improvement
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        int count = 0;
    ) {
                        );
                    batchId,
        }
    );
            throw new IllegalStateException("Batch " + batchId + " has no shards batch");
                    e -> logger.debug(new ParameterizedMessage("{} scheduled reroute failed for {}", reroutingKey, reason), e)
    // visible for testing
import org.opensearch.cluster.routing.allocation.FailedShard;
        for (Map.Entry<String, ShardsBatch> batchEntry : currentBatches.entrySet()) {
        ShardRouting shardRouting,
        for (FailedShard failedShard : failedShards) {
    public void applyFailedShards(final List<FailedShard> failedShards, final RoutingAllocation allocation) {
        ShardsBatch shardsBatch = batches.get(batchId);
                .forEach(shardsBatch -> runnables.add(new TimeoutAwareRunnable() {
        this.replicaShardsBatchGatewayAllocatorTimeout = replicaShardsBatchGatewayAllocatorTimeout;
        assert primaryShardBatchAllocator != null;
        PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY,
 * Allocator for the gateway to assign batch of shards.
import org.opensearch.index.store.Store;
import java.util.stream.StreamSupport;
    }
                batchedShardsToAssign.add(shardRouting.shardId());
        Setting.Property.Dynamic
            batchIdToStartedShardBatch.values()
 * @opensearch.internal
                    @Override
                .filter(batch -> batchesToAssign.contains(batch.batchId))
    private void addBatch(ShardsBatch shardsBatch, boolean primary) {
    class InternalPrimaryBatchShardAllocator extends PrimaryShardBatchAllocator {
            this.batchInfo = new HashMap<>(shardsWithInfo);
        if (batches.containsKey(shardsBatch.getBatchId())) {
/*
import org.opensearch.common.unit.TimeValue;
        }
                }
        UnassignedAllocationHandler unassignedAllocationHandler
            boolean primary,
        }
    }
                type,
            return shardAttributes;
        }
        AsyncShardBatchFetch<? extends BaseNodeResponse, ?> asyncFetcher = shardsBatch.getAsyncFetcher();
        logger.debug("Using async fetch batch size {}", maxBatchSize);
            .stream()
                return false;
        if (primary) {
    private static final short DEFAULT_SHARD_BATCH_SIZE = 2000;
            ShardsBatch shardsBatch = (ShardsBatch) o;
            batchIdToStoreShardBatch.values()
    private final ReplicaShardBatchAllocator replicaShardBatchAllocator;
            this.shardAttributes = shardAttributes;
                )
            .orElse(null);
                    public void run() {
    }
                }));
            ShardRouting currentShard = iterator.next();
    private TimeValue replicaShardsBatchGatewayAllocatorTimeout;
        this.replicaShardBatchAllocator = null;
    private TimeValue primaryShardsBatchGatewayAllocatorTimeout;
import java.util.stream.Collectors;
            List<ShardRouting> inEligibleShards,
            // create a ShardId -> customDataPath map for async fetch
                if (timeValue.compareTo(MIN_ALLOCATOR_TIMEOUT) < 0 && timeValue.compareTo(TimeValue.MINUS_ONE) != 0) {
     */
                asyncBatch = new InternalBatchAsyncFetch<>(
                    }
                clusterManagerMetrics
                            + "] should be more than 20s or -1ms to disable timeout"
            Predicate<V> emptyShardResponsePredicate,
        this.replicaShardsBatchGatewayAllocatorTimeout = null;
        List<ShardRouting> inEligibleShards,
            AsyncShardFetch.Lister<? extends BaseNodesResponse<T>, T> action,
             * In order to check if a fetch has ever happened, we check 2 things:
                currentShard
        // We need to clear the cache for the primary shard to ensure we do not cancel recoveries based on excessively
            }
            Set<ShardId> timedOutPrimaryShardIds = new HashSet<>();
    }
            RoutingAllocation allocation
        // cleanup shard from batches if they are not present in unassigned list from allocation object. This is
        for (ShardsBatch batch : batchIdToStoreShardBatch.values()) {
        }
    }
        AsyncShardFetch.FetchResult<? extends BaseNodeResponse> fetchResult = asyncFetcher.fetchData(
            Set<ShardId> timedOutReplicaShardIds = new HashSet<>();
    }
            List<ShardRouting> eligibleShards,
                logger.trace("Batch cache is empty for batch {} ", batchId);
    public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation) {
             * In the case when shard has a batch but no fetch has happened before, it would be because it is a new batch.
                        assert rerouteService != null;
        List<List<ShardRouting>> storedShardBatches = batchIdToStoreShardBatch.values()
            // making the wrong decision here is not catastrophic so we only need to cover the common case.
        Map<ShardId, ShardRouting> newShardsToBatch = new HashMap<>();
    @Inject
        // add all unassigned shards to the batch if they are not already in a batch
    private static Priority parseReroutePriority(String priorityString) {
        return batchIdToStartedShardBatch.size();
                batchesToBeAssigned.add(batchId);
                newShardsToBatch.put(shardRouting.shardId(), shardRouting);
                    batchEntry.getValue().clearShardFromCache(shardId);
                    @Override
     * @param primary from which batch shard needs to be removed
        // So, as part of calling reroute, those shards will be removed from allocation object. It'll handle the
    public ShardsBatchGatewayAllocator(
                    throw new IllegalArgumentException(
    /**
     */
                        primaryBatchShardAllocator.allocateUnassignedBatch(shardsBatch.getBatchedShardRoutings(), allocation);
        },
                    inEligibleShards,
     * <p>
        Map<ShardId, Set<String>> shardToIgnoreNodes = new HashMap<>();
            super(
            // drops out, we fetch the shard data, then some indexing happens and then the node rejoins the cluster again. There are other
        Set<String> batchesToAssign = createAndUpdateBatches(allocation, primary);
                emptyShardResponse,
        inEligibleShards.forEach(sr -> safelyRemoveShardFromBatch(sr, sr.primary()));
import org.opensearch.cluster.metadata.IndexMetadata;
        assert unassignedShard.unassigned();
                    eligibleShards,
        }
     */
    @Override
    ) {
            "priority [" + priority + "] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]"
        private ShardRouting shardRouting;
    private static void clearCacheForBatchPrimary(ShardsBatch batch, RoutingAllocation allocation) {
                ActionListener.wrap(
 */
                // Set updated shard routing in batch if it already exists
        }
                    new GatewayStartedShard(null, false, null, null),
            // Replica shard assignment can be cancelled if we get a better match. These ShardRouting objects also
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> fetchData(
                    clusterManagerMetrics
     */
                currentBatches.get(batchId).batchInfo.get(shardRouting.shardId()).setShardRouting(shardRouting);
            Class<V> clazz,
    }
            this.batchId = batchId;
    ) {
            perBatchShards.put(currentShard.shardId(), shardEntry);
                }
        }
             * <p>
            // failure in executeDecision of BaseGatewayShardAllocator. Previous non-batch mode flow also used to
                String batchId = currentBatchedShards.get(shardRouting.shardId());
    public static final TimeValue DEFAULT_ALLOCATOR_TIMEOUT = TimeValue.timeValueSeconds(20);
        // create batches for unassigned shards
        }
            ShardsBatch batch = batches.get(batchId);
            if (batchId == null) {
            asyncBatch.clearShard(shardId);
    }
        ShardsBatchGatewayAllocator::parseReroutePriority,
     */
            return Objects.hash(batchId);
        );
        if (unassignedShard.primary()) {
        clusterSettings.addSettingsUpdateConsumer(FOLLOW_UP_REROUTE_PRIORITY_SETTING, this::setFollowUpRerouteTaskPriority);
            logger.debug("Shard {} has no batch id", shardRouting);
        safelyRemoveShardFromBatch(shardRouting, false);
        ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
                batchUUId,
            }
                    throw new IllegalArgumentException(
            while (shardIdIterator.hasNext()) {
            // assert that fetcher and shards are the same as batched shards
                )
                currentBatches.get(batchId).batchInfo.get(shardRouting.shardId()).setShardRouting(shardRouting);
        }
            this.lastSeenEphemeralIds = newEphemeralIds;
        this.primaryShardsBatchGatewayAllocatorTimeout = null;
            deleteBatchIfEmpty(batches, batchEntry.getValue().getBatchId());
                    "batch_shards_store",
            batchIdToStoreShardBatch.values().forEach(batch -> clearCacheForBatchPrimary(batch, allocation));
    protected final ConcurrentMap<String, ShardsBatch> batchIdToStartedShardBatch = ConcurrentCollections.newConcurrentMap();
                batchSize = maxBatchSize;
            if ((currentBatchedShards.containsKey(shardRouting.shardId()) == false) && (shardRouting.primary() == primary)) {
                            "reroute after existing shards allocator [R] timed out",
        }
    protected void safelyRemoveShardFromBothBatch(ShardRouting shardRouting) {
                    shardIdsMap,
import org.opensearch.common.settings.ClusterSettings;
            case NORMAL:
            assert rerouteService != null;
    public int getNumberOfInFlightFetches() {
            if (currentBatchedShards.containsKey(shardRouting.shardId()) && shardRouting.primary() == primary) {
        throw new IllegalArgumentException(
        ) {
        }
import java.util.Map;
                    new ShardBatchResponseFactory<>(false),
            assert primaryShardBatchAllocator != null;
        @Override
            return batchId;
            /**
        this.primaryShardBatchAllocator = null;
    private final PrimaryShardBatchAllocator primaryShardBatchAllocator;
             * 2. If we see that the list of nodes to fetch from is empty, we know that all nodes have data or are ongoing a fetch. So we return true.
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
        }
        }
                        rerouteService.reroute(
        if (fetchResult.hasData()) {
            return batchInfo.keySet();
        Set<ShardId> batchedShardsToAssign,
             * It should return false if there has never been a fetch for this batch.
import org.opensearch.cluster.ClusterManagerMetrics;
                map,
        ShardsBatch batch = batches.get(batchId);
            return new BatchRunnableExecutor(runnables, () -> replicaShardsBatchGatewayAllocatorTimeout) {
/**
        ConcurrentMap<String, ShardsBatch> currentBatches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
        if (allocation.routingNodes().hasInactiveShards()) {
                            )
        setFollowUpRerouteTaskPriority(FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(settings));
                }
     * but for a cluster in a messed up state which is starving NORMAL priority tasks, it might be necessary to raise this higher
        assert getBatchId(unassignedShard, unassignedShard.primary()) != null;
            this.primary = primary;
        protected boolean hasInitiatedFetching(ShardRouting shard) {
            }
                emptyShardResponsePredicate,
import java.util.Iterator;
        @Override
            List<ShardRouting> inEligibleShards,
import org.opensearch.indices.store.ShardAttributes;
                );
            ClusterManagerMetrics clusterManagerMetrics
        this.clusterManagerMetrics = new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE);
                    eligibleShards,
        String batchId = primary ? getBatchId(shardRouting, true) : getBatchId(shardRouting, false);
        }));
    protected String getBatchId(ShardRouting shardRouting, boolean primary) {
                if (timeValue.compareTo(MIN_ALLOCATOR_TIMEOUT) < 0 && timeValue.compareTo(TimeValue.MINUS_ONE) != 0) {
    public void allocateUnassigned(
        if (batchId == null) {
        10000,
public class ShardsBatchGatewayAllocator implements ExistingShardsAllocator {
package org.opensearch.gateway;
        assert primaryShardBatchAllocator != null;
                    public void run() {
                logger,
        TimeValue.MINUS_ONE,
            return batchId.equals(shardsBatch.getBatchId()) && batchInfo.keySet().equals(shardsBatch.getBatchedShards());
import java.util.function.Predicate;
    /**
        this.primaryShardBatchAllocator = new InternalPrimaryBatchShardAllocator();
                            + "] should be more than 20s or -1ms to disable timeout"
        private final InternalBatchAsyncFetch<? extends BaseNodeResponse, ?> asyncBatch;
     */
                asyncBatch = new InternalBatchAsyncFetch<>(
        }
                    batchStoreAction,
                        timedOutPrimaryShardIds.addAll(shardsBatch.getBatchedShards());
        protected void removeShard(ShardId shardId) {
        }
                        "Setting ["
        }
        allocation.routingNodes().forEach(routingNode -> routingNode.getInitializingShards().forEach(shardRouting -> {
                            + REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey()
        if (batches.containsKey(batchId) == false) {
import java.util.HashSet;
                    logger,
    /**
import org.opensearch.action.support.nodes.BaseNodesResponse;
            // recalc to also (lazily) clear out old nodes.
        this.maxBatchSize = GATEWAY_ALLOCATOR_BATCH_SIZE.get(settings);
    @Override
                    }
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
    }
                String batchId = currentBatchedShards.get(shardRouting.shardId());
    // visible for testing
        // Although this flow can be optimized by only clearing the cache for the primary shard but currently
        Setting.Property.Dynamic
        Settings settings,
                    public void onTimeout() {
                    NodeStoreFilesMetadata.class,
            removeShard(shard.shardId());
    private void setMaxBatchSize(long maxBatchSize) {
     * Holds information about a shard to be allocated in a batch.
                Releasables.close(batch.getAsyncFetcher());
            if (batchSize == 0 || iterator.hasNext() == false) {
    protected final ConcurrentMap<String, ShardsBatch> batchIdToStoreShardBatch = ConcurrentCollections.newConcurrentMap();
        protected void reroute(String reroutingKey, String reason) {
        if (getBatchId(unassignedShard, unassignedShard.primary()) == null) {
            .collect(Collectors.toList());
import org.opensearch.common.settings.Settings;
            Iterator<ShardId> shardIdIterator = batchEntry.getValue().getBatchedShards().iterator();
        }
import org.opensearch.cluster.node.DiscoveryNode;
        "cluster.routing.allocation.shards_batch_gateway_allocator.schedule_reroute.priority",
        AsyncShardBatchFetch<? extends BaseNodeResponse, ?> fetch = batch.getAsyncFetcher();
     * @param shardRouting shard to be removed
    AsyncShardFetch.FetchResult<? extends BaseNodeResponse> fetchDataAndCleanIneligibleShards(
    }
 *
            // and is called in {@link AsyncShardFetch#fetchData(DiscoveryNodes, Map)}
                    shardIdsMap,
        }
            createAndUpdateBatches(routingAllocation, unassignedShard.primary());
            iterator.remove();
        switch (priority) {
             * This function is to check if asyncFetch has happened before for this shard batch, or is ongoing.
        this.maxBatchSize = batchSize;
        new Setting.Validator<>() {
import java.util.Set;
            return (AsyncShardFetch.FetchResult<
            batchEntry.getValue().getBatchedShards().forEach(shardId -> currentBatchedShards.put(shardId, batchEntry.getKey()));
    public static final Setting<TimeValue> PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING = Setting.timeSetting(
        return false;
    }
            if (shardsBatch == null || shardsBatch.getAsyncFetcher().hasEmptyCache()) {
        }
                .stream()
                action,
     */
            return batchInfo.values().stream().map(ShardEntry::getShardRouting).collect(Collectors.toList());
        }
        String batchId = getBatchId(shardRouting, shardRouting.primary());
     * Holds information about a batch of shards to be allocated.
            .collect(Collectors.toList());
                "async_shard_batch_fetch",
                addBatch(shardsBatch, primary);
                    }
            }
            logger.debug("Batch {} has no shards batch", batchId);
        Priority.NORMAL.toString(),
        TransportNodesListGatewayStartedShardsBatch batchStartedAction,
                    }
        ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
                    @Override
        boolean primary
        this.batchStartedAction = batchStartedAction;
                    logger,
     * Timeout for existing primary shards batch allocator.
                @Override
            final Set<String> newEphemeralIds = StreamSupport.stream(Spliterators.spliterator(nodes.getDataNodes().entrySet(), 0), false)
        Set<String> batchesToBeAssigned = new HashSet<>();
        Set<ShardId> batchedShardsToAssign = Sets.newHashSet();
        }
        });
                        logger.trace("scheduling reroute after existing shards allocator timed out for primary shards");
                // add the batch to list of current batches
    private void deleteBatchIfEmpty(ConcurrentMap<String, ShardsBatch> batches, String batchId) {
import org.apache.logging.log4j.Logger;
        Map<ShardId, ShardEntry> perBatchShards = new HashMap<>();
                return true;
        this.primaryShardsBatchGatewayAllocatorTimeout = primaryShardsBatchGatewayAllocatorTimeout;
        ensureAsyncFetchStorePrimaryRecency(allocation);
        if (batches.containsKey(batchId)) {
        }
    private void ensureAsyncFetchStorePrimaryRecency(RoutingAllocation allocation) {
 * this file be licensed under the Apache-2.0 license or a
            // store other information like relocating node, targetRelocatingShard etc. And it can be updated after
            List<ShardRouting> eligibleShards,
import java.util.Collections;
            Map<ShardId, ShardEntry> shardsWithInfo,
    @Override
    );
            if (o instanceof ShardsBatch == false) {
             */
     */
        this(DEFAULT_SHARD_BATCH_SIZE, null);
            logger.trace(
    }
        }
import org.opensearch.common.inject.Inject;
    public static final Setting<Long> GATEWAY_ALLOCATOR_BATCH_SIZE = Setting.longSetting(
        private final String batchId;
        assert maxBatchSize > 0 : "Shards batch size must be greater than 0";
                            + PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey()
        RoutingAllocation allocation
        }
        }
    class InternalBatchAsyncFetch<T extends BaseNodeResponse, V> extends AsyncShardBatchFetch<T, V> {
        List<ShardRouting> primaries = batch.getBatchedShards()
     * This method should be called when removing the shard from the batch instead {@link ShardsBatch#removeFromBatch(ShardRouting)}
        public String getBatchId() {
        if (batchId == null) {
                .map(node -> node.getValue().getEphemeralId())
            return shardRouting;
                        logger.trace("scheduling reroute after existing shards allocator timed out for replica shards");
            }
                            ActionListener.wrap(
            if (this == o) {
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getShardAttributes()));
 * The OpenSearch Contributors require contributions made to
                            "reroute after existing shards allocator [P] timed out",
        @SuppressWarnings("unchecked")
            ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
    public static final Setting<Priority> FOLLOW_UP_REROUTE_PRIORITY_SETTING = new Setting<>(
        DEFAULT_SHARD_BATCH_SIZE,
        return innerAllocateUnassignedBatch(allocation, primaryShardBatchAllocator, replicaShardBatchAllocator, primary);
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
     * Timeout value must be greater than or equal to 20s or -1ms to effectively disable timeout
import org.opensearch.common.util.BatchRunnableExecutor;
             * 1. If the shard batch cache is empty, we know that fetch has never happened so we return false.
                    );
        this.maxBatchSize = maxBatchSize;
    protected ShardsBatchGatewayAllocator() {
        },
    }
            );
            clearShardFromCache(shard.shardId());
                    r -> logger.trace("{} scheduled reroute completed for {}", reroutingKey, reason),
    // visible for testing
                }
    // for tests
            shardToIgnoreNodes
                    Sets.difference(newEphemeralIds, lastSeenEphemeralIds)
                    shardIdIterator.remove();
            return this;
        }
                .forEach(batch -> runnables.add(new TimeoutAwareRunnable() {
                clazz,
        }
        }
        // remove in eligible shards which allocator is not responsible for
     * If the shard is not in a batch, this is a no-op.
import org.opensearch.cluster.routing.ShardRouting;
        }
        }
                );
            safelyRemoveShardFromBothBatch(startedShard);
    ) {
    }
        private final Map<ShardId, ShardEntry> batchInfo;
                        timedOutReplicaShardIds.addAll(batch.getBatchedShards());
            return asyncBatch;
        "cluster.allocator.gateway.batch_size",
            if (lastSeenEphemeralIds.contains(node.getEphemeralId()) == false) {
    }
                .stream()
                    new NodeStoreFilesMetadata(new StoreFilesMetadata(null, Store.MetadataSnapshot.EMPTY, Collections.emptyList()), null),
        this.replicaShardsBatchGatewayAllocatorTimeout = REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(settings);
        Setting.Property.NodeScope,
            @Override
            String batchUUId,
                String batchUUId = UUIDs.base64UUID();
                () -> new ParameterizedMessage(
            shardToIgnoreNodes.put(shardId, allocation.getIgnoreNodes(shardId));
    private final RerouteService rerouteService;
import java.util.concurrent.ConcurrentMap;
            .map(allocation.routingNodes()::activePrimary)
 * compatible open source license.
        assert replicaShardBatchAllocator != null;
            return new BatchRunnableExecutor(runnables, () -> primaryShardsBatchGatewayAllocatorTimeout) {
        ConcurrentMap<String, ShardsBatch> currentBatches,
    protected ShardsBatchGatewayAllocator(long batchSize, RerouteService rerouteService) {
import org.opensearch.common.UUIDs;
            count += (batch.getNumberOfInFlightFetches() * batch.getBatchedShards().size());
     * after removing the shard
        return batches.entrySet()
     * Clear the fetched data for the primary to ensure we do not cancel recoveries based on excessively stale data.
        for (ShardRouting startedShard : startedShards) {
        public String toString() {
        public boolean equals(Object o) {
            Logger logger,
                return false;
        1,
                );
        RoutingAllocation allocation,
    // for tests
            ClusterManagerMetrics clusterManagerMetrics
        ConcurrentMap<String, ShardsBatch> batches = shardRouting.primary() ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
        return count;
                batches.remove(batchId);
                Priority.HIGH,
    }
    @Override
    public int getNumberOfStoreShardBatches() {
                    allocation
        Stream.of(batchIdToStartedShardBatch, batchIdToStoreShardBatch).forEach(b -> {
        RerouteService rerouteService,
    public int getNumberOfStartedShardBatches() {
            allocation.nodes(),
        this.rerouteService = rerouteService;
    private static final Logger logger = LogManager.getLogger(ShardsBatchGatewayAllocator.class);
        ClusterSettings clusterSettings,
            );
             * <p>
            // add to batch if batch size full or last shard in unassigned list
     * Visible for testing
                    }
            count += (batch.getNumberOfInFlightFetches() * batch.getBatchedShards().size());
             * Allocation explain and manual reroute APIs try to append shard store information (matching bytes) to the allocation decision.
        clusterSettings.addSettingsUpdateConsumer(GATEWAY_ALLOCATOR_BATCH_SIZE, this::setMaxBatchSize);
        }
                    public void onTimeout() {
    private volatile Priority followUpRerouteTaskPriority;
            );
     *
        public ShardsBatch(
                    logger.trace("Triggering oncomplete after timeout for [{}] primary shards", timedOutPrimaryShardIds.size());
     * Async fetcher is used to fetch the data for the batch.
        @Override
            this.batchInfo.remove(shardId);
        ) {
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;
            return primaryShardBatchAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);
     * Adjusts the priority of the followup reroute task when current round times out. NORMAL is right for reasonable clusters,
            // this check below is to make sure we already have all the data and that we wouldn't create a new async fetchData call
                    GatewayStartedShard::isEmpty,
        });
    static class ShardEntry {
    }
     * Safely remove a shard from the appropriate batch depending on if it is primary or replica
                public void onComplete() {
            }
                return false;
            // pass ShardRouting object directly from unassignedIterator, so we're following the same behaviour.
            assert batchInfo.size() == asyncBatch.shardAttributesMap.size() : "Shards size is not equal to fetcher size";
        this.primaryShardsBatchGatewayAllocatorTimeout = PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(settings);
                    @Override
                ShardId shardId = shardIdIterator.next();
                TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch>) fetchDataAndCleanIneligibleShards(
    }
        Setting.Property.Dynamic
        clusterSettings.addSettingsUpdateConsumer(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING, this::setPrimaryBatchAllocatorTimeout);
                );
                    new ShardBatchResponseFactory<>(true),
        );
    }
                            )
             * 3. Otherwise we return false.
    private boolean hasNewNodes(DiscoveryNodes nodes) {
            }
        for (Map.Entry<String, ShardsBatch> batchEntry : currentBatches.entrySet()) {
        public ShardEntry setShardRouting(ShardRouting shardRouting) {
    private final ClusterManagerMetrics clusterManagerMetrics;
            String type,
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata;
        long batchSize = maxBatchSize;
    }
            ShardBatchResponseFactory<T, V> responseFactory,
            .stream()
            String batchId = getBatchId(shard, shard.primary());
import org.opensearch.core.action.ActionListener;
                    replicaBatchShardAllocator.allocateUnassignedBatchOnTimeout(timedOutReplicaShardIds, allocation, false);
    private final TransportNodesListGatewayStartedShardsBatch batchStartedAction;
     * Timeout for existing replica shards batch allocator.
        public ShardRouting getShardRouting() {
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
        if (hasNewNodes(nodes)) {
        }
        for (ShardsBatch batch : batchIdToStartedShardBatch.values()) {
        if (shardsBatch.getBatchedShards().isEmpty() && eligibleShards.isEmpty()) {
            .map(ShardsBatch::getBatchedShardRoutings)
import org.opensearch.cluster.routing.RerouteService;
                .collect(Collectors.toSet());
    private Set<String> lastSeenEphemeralIds = Collections.emptySet();
    @Override
                                r -> logger.trace("reroute after existing shards allocator timed out completed"),
        DEFAULT_ALLOCATOR_TIMEOUT,
    /**
                @Override
                        "Setting ["
                if (batchedShardsToAssign.contains(shardId) == false) {
        List<TimeoutAwareRunnable> runnables = new ArrayList<>();
                            followUpRerouteTaskPriority,
                        assert rerouteService != null;
                                r -> logger.trace("reroute after existing shards allocator timed out completed"),
    private long maxBatchSize;
            // batch. This stale data can end up creating a same decision which has already been taken, and we'll see
     * For the corresponding shardId. The method intends to clean up the batch if it is empty
                return priority;
            safelyRemoveShardFromBothBatch(failedShard.getRoutingEntry());
