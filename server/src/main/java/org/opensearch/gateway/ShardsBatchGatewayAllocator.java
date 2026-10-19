                );
                    GatewayStartedShard::isEmpty,
    }
    /**
        ConcurrentMap<String, ShardsBatch> currentBatches,  
                    r -> logger.trace("{} scheduled reroute completed for {}", reroutingKey, reason),
            throw new IllegalStateException("Batch " + batchId + " has no shards batch");
        new Setting.Validator<>() {
        }  
            allocation.nodes(),
        }  
                    throw new IllegalArgumentException(
            // batches are created. If we don't update the ShardRouting object, stale data would be passed from the
            }
        );  
                    @Override  
                String batchId = currentBatchedShards.get(shardRouting.shardId());
        }
public class ShardsBatchGatewayAllocator implements ExistingShardsAllocator {
                    allocation
        PrimaryShardBatchAllocator primaryBatchShardAllocator,
        if (shardsBatch.getBatchedShards().isEmpty() && eligibleShards.isEmpty()) {  
    public static final Setting<TimeValue> PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING = Setting.timeSetting(  
            this.shardAttributes = shardAttributes;
            );  
        }
     * Holds information about a batch of shards to be allocated.  
        this.replicaShardsBatchGatewayAllocatorTimeout = replicaShardsBatchGatewayAllocatorTimeout;  
    }
    private final ReplicaShardBatchAllocator replicaShardBatchAllocator;  
        @SuppressWarnings("unchecked")  
    }
                    batchStartedAction,
            if (batchSize == 0 || iterator.hasNext() == false) {
        }
                    NodeStoreFilesMetadata::isEmpty,  
import org.apache.logging.log4j.Logger;
                    throw new IllegalArgumentException(
    protected void setFollowUpRerouteTaskPriority(Priority followUpRerouteTaskPriority) {  
            return shardAttributes;
                .forEach(shardsBatch -> runnables.add(new TimeoutAwareRunnable() {
        } else {
        clusterSettings.addSettingsUpdateConsumer(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING, this::setPrimaryBatchAllocatorTimeout);
                asyncBatch = new InternalBatchAsyncFetch<>(
                .filter(batch -> batchesToAssign.contains(batch.batchId))
        }
 * this file be licensed under the Apache-2.0 license or a
     * Visible for testing  
    private TimeValue primaryShardsBatchGatewayAllocatorTimeout;
                        replicaBatchShardAllocator.allocateUnassignedBatch(batch.getBatchedShardRoutings(), allocation);  
            this.batchId = batchId;
                }
                    }
import org.opensearch.common.util.concurrent.TimeoutAwareRunnable;  
            throw new IllegalStateException("Shard " + shardRouting + " has no batch id. Shard should batched before fetching");  
            }
                        logger.trace("scheduling reroute after existing shards allocator timed out for primary shards");
        }  
        }
                    @Override
        assert replicaShardBatchAllocator != null;
            return replicaShardBatchAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);
                assert shardRouting.unassigned();
            return shardsBatch.getAsyncFetcher().getCache().findNodesToFetch().isEmpty();  
            assert rerouteService != null;  
     */  
            return null;  
    @Override  
                logger,
                batchedShardsToAssign.add(shardRouting.shardId());
     * Adjusts the priority of the followup reroute task when current round times out. NORMAL is right for reasonable clusters,  
             */  
        public boolean equals(Object o) {
import org.opensearch.cluster.metadata.IndexMetadata;
    public static final String ALLOCATOR_NAME = "shards_batch_gateway_allocator";  
                            )
    }
        this.maxBatchSize = GATEWAY_ALLOCATOR_BATCH_SIZE.get(settings);
                    primaryBatchShardAllocator.allocateUnassignedBatchOnTimeout(timedOutPrimaryShardIds, allocation, true);
        Map<ShardId, Set<String>> shardToIgnoreNodes = new HashMap<>();
        Set<ShardId> batchedShardsToAssign = Sets.newHashSet();
     *  
    @Override
                }
    }  
                    batchId,  
                    logger.trace("Triggering oncomplete after timeout for [{}] replica shards", timedOutReplicaShardIds.size());  
        @Override  
        public AsyncShardBatchFetch<? extends BaseNodeResponse, ?> getAsyncFetcher() {
    @Override
import org.opensearch.common.util.set.Sets;
             * In order to check if a fetch has ever happened, we check 2 things:  
     * @param primary from which batch shard needs to be removed
    /**
        public int hashCode() {
        ClusterManagerMetrics clusterManagerMetrics  
        this.rerouteService = rerouteService;  
    public static final Setting<TimeValue> REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING = Setting.timeSetting(  
                    clusterManagerMetrics
                () -> new ParameterizedMessage(
                ShardId shardId = shardIdIterator.next();
        for (final DiscoveryNode node : nodes.getDataNodes().values()) {
import org.opensearch.cluster.routing.RerouteService;
            // drops out, we fetch the shard data, then some indexing happens and then the node rejoins the cluster again. There are other  
    }
        RoutingAllocation allocation
        if (primary) {  
        "cluster.allocator.gateway.batch_size",  
        Setting.Property.Dynamic
                    );  
    private static final Logger logger = LogManager.getLogger(ShardsBatchGatewayAllocator.class);
        // Opened issue #13352 - to track the improvement
        }
        ReplicaShardBatchAllocator replicaBatchShardAllocator,  
                            "reroute after existing shards allocator [P] timed out",
            // recalc to also (lazily) clear out old nodes.  
        RerouteService rerouteService,
            safelyRemoveShardFromBothBatch(failedShard.getRoutingEntry());
    /**
        } else {
    }
        ) {  
        TransportNodesListGatewayStartedShardsBatch batchStartedAction,
    }
    /**  
            count += (batch.getNumberOfInFlightFetches() * batch.getBatchedShards().size());  
                    GatewayStartedShard.class,  
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {
        protected void reroute(String reroutingKey, String reason) {
                );
    ) {  
            return asyncBatch.getNumberOfInFlightFetches();  
            // ways we could decide to cancel a recovery based on stale data (e.g. changing allocation filters or a primary failure) but
            Predicate<V> emptyShardResponsePredicate,  
                    }
                    eligibleShards,
        RoutingNodes.UnassignedShards unassigned = allocation.routingNodes().unassigned();
        assert replicaShardBatchAllocator != null;
    private final PrimaryShardBatchAllocator primaryShardBatchAllocator;
        batches.put(shardsBatch.getBatchId(), shardsBatch);  
            // this check below is to make sure we already have all the data and that we wouldn't create a new async fetchData call
                    public void run() {
/*  
            return primaryShardBatchAllocator.makeAllocationDecision(unassignedShard, routingAllocation, logger);
            V emptyShardResponse,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        public ShardEntry(ShardAttributes shardAttributes, ShardRouting shardRouting) {  
    }
                type,  
import org.opensearch.action.support.nodes.BaseNodeResponse;
             * Allocation explain and manual reroute APIs try to append shard store information (matching bytes) to the allocation decision.
        Priority.NORMAL.toString(),  
        while (iterator.hasNext()) {
            batchIdToStoreShardBatch.values()
            .map(Map.Entry::getKey)
        }
    private static Priority parseReroutePriority(String priorityString) {  
            if (shardsBatch == null || shardsBatch.getAsyncFetcher().hasEmptyCache()) {
    @Override
             * <p>
    public void applyFailedShards(final List<FailedShard> failedShards, final RoutingAllocation allocation) {
            else if (shardRouting.primary() == primary) {  
            return (AsyncShardFetch.FetchResult<  
            .map(ShardsBatch::getBatchedShardRoutings)
    private final TransportNodesListShardStoreMetadataBatch batchStoreAction;  
            };
        this.replicaShardsBatchGatewayAllocatorTimeout = null;
        public Set<ShardId> getBatchedShards() {
import org.opensearch.common.UUIDs;  
            }
            this.batchInfo = new HashMap<>(shardsWithInfo);
        TimeValue.MINUS_ONE,  
    protected void safelyRemoveShardFromBatch(ShardRouting shardRouting, boolean primary) {
        InternalBatchAsyncFetch(
                            "reroute after existing shards allocator [R] timed out",  
                    batchId,
import org.opensearch.core.index.shard.ShardId;  
            );
    /**  
    protected String getBatchId(ShardRouting shardRouting, boolean primary) {
    ) {
    private boolean hasNewNodes(DiscoveryNodes nodes) {  
            case NORMAL:  
        for (Map.Entry<String, ShardsBatch> batchEntry : currentBatches.entrySet()) {
            shardToIgnoreNodes
            );  
            ShardsBatch batch = batches.get(batchId);
        }
        ShardRouting shardRouting,  
        Setting.Property.NodeScope,
        // remove in eligible shards which allocator is not responsible for  
     * but for a cluster in a messed up state which is starving NORMAL priority tasks, it might be necessary to raise this higher
            this.batchInfo.remove(shardId);
                .filter(batch -> batchesToAssign.contains(batch.batchId))  
        }  
                    batchStoreAction,
     * If the shard is not in a batch, this is a no-op.
             * <p>
            // and is called in {@link AsyncShardFetch#fetchData(DiscoveryNodes, Map)}  
                    "batch_shards_store",  
            return batchInfo.keySet();  
            @Override
        UnassignedAllocationHandler unassignedAllocationHandler
        }  
     */
            case HIGH:
            // failure in executeDecision of BaseGatewayShardAllocator. Previous non-batch mode flow also used to
        // stale data. We do this by clearing the cache of nodes for all the active primaries of replicas in the current batch.
        long batchSize = maxBatchSize;
    class InternalReplicaBatchShardAllocator extends ReplicaShardBatchAllocator {
        Stream.of(batchIdToStartedShardBatch, batchIdToStoreShardBatch).forEach(b -> {
             * This function is used to see if a fetch has happened to decide if it is possible to append shard store info without a new async fetch.
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;  
    }
     * <p>
                    NodeStoreFilesMetadata.class,
        clusterSettings.addSettingsUpdateConsumer(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING, this::setReplicaBatchAllocatorTimeout);  
                responseFactory,
    }
        // needed as AllocationService.reroute can also be called directly by API flows for example DeleteIndices.
                return priority;  
                            followUpRerouteTaskPriority,
    private volatile Priority followUpRerouteTaskPriority;  
            .stream()
        }
            asyncBatch.clearShard(shardId);
    }
            if (batch.getBatchedShards().isEmpty()) {  
                )
                batchesToBeAssigned.add(batchUUId);  
    /**
        }
        AsyncShardFetch.FetchResult<? extends BaseNodeResponse> fetchResult = asyncFetcher.fetchData(  
        List<ShardRouting> inEligibleShards,  
    public void beforeAllocation(final RoutingAllocation allocation) {  
    @Override  
        // So, as part of calling reroute, those shards will be removed from allocation object. It'll handle the  
        String batchId = getBatchId(shardRouting, shardRouting.primary());  
     */
    }
    }  
        Map<ShardId, ShardEntry> perBatchShards = new HashMap<>();  
        // scenarios where shards can be removed from unassigned list without "start" or "failed" event.
            // assert that fetcher and shards are the same as batched shards
    // for tests
        DEFAULT_ALLOCATOR_TIMEOUT,
     */
import org.opensearch.common.unit.TimeValue;  
                batches.remove(batchId);
    @Override
     * This method should be called when removing the shard from the batch instead {@link ShardsBatch#removeFromBatch(ShardRouting)}
                clusterManagerMetrics
            batchSize--;
                    inEligibleShards,  
            String batchId = getBatchId(shard, shard.primary());
    public int getNumberOfStartedShardBatches() {
            return (AsyncShardFetch.FetchResult<  
            if (batchId == null) {
            Map<ShardId, ShardAttributes> map,
    }
                    new NodeStoreFilesMetadata(new StoreFilesMetadata(null, Store.MetadataSnapshot.EMPTY, Collections.emptyList()), null),
    }
                        rerouteService.reroute(  
    @Override  
        ShardsBatchGatewayAllocator::parseReroutePriority,
        @SuppressWarnings("unchecked")  
    @Override  
            count += (batch.getNumberOfInFlightFetches() * batch.getBatchedShards().size());  
        assert replicaShardBatchAllocator != null;
        List<ShardRouting> eligibleShards,
    }
        }
             * However, these APIs do not want to trigger a new asyncFetch for these ineligible shards  
                    public void onTimeout() {  
        new Setting.Validator<>() {
                    clusterManagerMetrics
        protected void removeShard(ShardId shardId) {
                // add the batch to list of current batches
                ActionListener.wrap(
        Map<ShardId, String> currentBatchedShards = new HashMap<>();
                    replicaBatchShardAllocator.allocateUnassignedBatchOnTimeout(timedOutReplicaShardIds, allocation, false);
                TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch>) fetchDataAndCleanIneligibleShards(
                                e -> logger.debug("reroute after existing shards allocator timed out failed", e)
                }));
    public void cleanCaches() {
                Releasables.close(batch.getAsyncFetcher());
                .collect(Collectors.toSet());
        TransportNodesListShardStoreMetadataBatch batchStoreAction,  
        ClusterSettings clusterSettings,
        this.primaryShardsBatchGatewayAllocatorTimeout = PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(settings);  
        ShardsBatch batch = batches.get(batchId);
    }
    private final TransportNodesListGatewayStartedShardsBatch batchStartedAction;
            logger.debug("Batch {} has no shards batch", batchId);
                    }
    public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation) {
import org.opensearch.cluster.ClusterManagerMetrics;  
                    public void run() {  
            ShardsBatch shardsBatch = shard.primary() ? batchIdToStartedShardBatch.get(batchId) : batchIdToStoreShardBatch.get(batchId);  
import java.util.Objects;
            RoutingAllocation allocation
                        logger.trace("scheduling reroute after existing shards allocator timed out for replica shards");  
        }
            while (shardIdIterator.hasNext()) {
                clazz,
        AsyncShardBatchFetch<? extends BaseNodeResponse, ?> asyncFetcher = shardsBatch.getAsyncFetcher();
    );
     * Safely remove a shard from the appropriate batch depending on if it is primary or replica
     * @param shardRouting shard to remove
                        timedOutReplicaShardIds.addAll(batch.getBatchedShards());
    public static final String PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY =
        }
            .collect(Collectors.toList());
    }  
        setFollowUpRerouteTaskPriority(FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(settings));
        if (shardRouting == null) {  
                    logger,
            ClusterManagerMetrics clusterManagerMetrics
        List<ShardRouting> primaries = batch.getBatchedShards()  
        logger.debug("Using async fetch batch size {}", maxBatchSize);
                    IndexMetadata.INDEX_DATA_PATH_SETTING.get(allocation.metadata().index(currentShard.index()).getSettings())
import java.util.stream.Stream;
        ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
        ShardRouting shardRouting = eligibleShards.iterator().hasNext() ? eligibleShards.iterator().next() : null;
    }
                public void onComplete() {  
            logger.debug("Shard {} has no batch id", shardRouting);
                    Sets.difference(newEphemeralIds, lastSeenEphemeralIds)
        "cluster.routing.allocation.shards_batch_gateway_allocator.replica_allocator_timeout";
        private final ShardAttributes shardAttributes;
        @Override  
        if (hasNewNodes(nodes)) {
        Setting.Property.NodeScope,
            return shardRouting;  
        for (ShardsBatch batch : batchIdToStoreShardBatch.values()) {
        this.replicaShardBatchAllocator = null;
                    allocation
            }
    public static final Setting<Long> GATEWAY_ALLOCATOR_BATCH_SIZE = Setting.longSetting(
    public int getNumberOfStoreShardBatches() {
            // Invalidate the cache if a data node has been added to the cluster. This ensures that we do not cancel a recovery if a node
        private void removeFromBatch(ShardRouting shard) {
            return this;  
                            + PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey()
    public static final Setting<Priority> FOLLOW_UP_REROUTE_PRIORITY_SETTING = new Setting<>(
                @Override
import org.opensearch.cluster.node.DiscoveryNode;
        allocation.routingNodes().forEach(routingNode -> routingNode.getInitializingShards().forEach(shardRouting -> {
    }  
            // store other information like relocating node, targetRelocatingShard etc. And it can be updated after
        private final Map<ShardId, ShardEntry> batchInfo;
        // cleanup shard from batches if they are not present in unassigned list from allocation object. This is
        if (unassignedShard.primary()) {
                map,
/**
             * This function is currently only used in the case of replica shards when all deciders returned NO/THROTTLE, and explain mode is ON.
     * Timeout for existing primary shards batch allocator.  
            );
            this.shardRouting = shardRouting;
        @Override  
        this.primaryShardBatchAllocator = null;
            // cancel existing recoveries if we have a better match
                return true;  
import java.util.Map;
                }  
        return batchIdToStartedShardBatch.size();
            return new AsyncShardFetch.FetchResult<>(null, Collections.emptyMap());
        10000,  
        public String toString() {  
            logger.trace(
        for (ShardsBatch batch : batchIdToStartedShardBatch.values()) {
            }
                    }  
            Map<ShardId, ShardEntry> shardsWithInfo,  
            assert replicaShardBatchAllocator != null;  
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
            Iterator<ShardId> shardIdIterator = batchEntry.getValue().getBatchedShards().iterator();  
        this.primaryShardsBatchGatewayAllocatorTimeout = primaryShardsBatchGatewayAllocatorTimeout;
        @Override
import java.util.HashMap;
import java.util.HashSet;  
     * For the corresponding shardId. The method intends to clean up the batch if it is empty  
                        assert rerouteService != null;
                    new ShardBatchResponseFactory<>(false),
        private ShardRouting shardRouting;
        }  
        assert getBatchId(unassignedShard, unassignedShard.primary()) != null;
            } else {  
                        timedOutPrimaryShardIds.addAll(shardsBatch.getBatchedShards());
        assert primaryShardBatchAllocator != null;
                }
            String batchUUId,  
        Map<ShardId, ShardRouting> newShardsToBatch = new HashMap<>();  
        ShardsBatch shardsBatch = batches.get(batchId);
        "cluster.routing.allocation.shards_batch_gateway_allocator.primary_allocator_timeout";  
                        primaryBatchShardAllocator.allocateUnassignedBatch(shardsBatch.getBatchedShardRoutings(), allocation);
            logger.trace("Checking if fetching done for batch id {}", batchId);
            return;
    /**
            ShardRouting currentShard = iterator.next();
            batchIdToStartedShardBatch.values()
        primaries.forEach(shardRouting -> fetch.clearCacheForNode(shardRouting.currentNodeId()));  
            "priority [" + priority + "] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]"  
import org.opensearch.cluster.routing.allocation.FailedShard;  
        assert routingAllocation.debugDecision();  
        throw new UnsupportedOperationException("ShardsBatchGatewayAllocator does not support allocating unassigned shards");
        DiscoveryNodes nodes = allocation.nodes();  
                    @Override
                            + REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey()
        ensureAsyncFetchStorePrimaryRecency(allocation);  
            // add to batch if batch size full or last shard in unassigned list  
            iterator.remove();
                    }
            /**
            List<ShardRouting> inEligibleShards,  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
             * 2. If we see that the list of nodes to fetch from is empty, we know that all nodes have data or are ongoing a fetch. So we return true.
        final Priority priority = Priority.valueOf(priorityString.toUpperCase(Locale.ROOT));
    protected void setReplicaBatchAllocatorTimeout(TimeValue replicaShardsBatchGatewayAllocatorTimeout) {
        ) {
        Setting.Property.NodeScope,
        }
            }
                    e -> logger.debug(new ParameterizedMessage("{} scheduled reroute failed for {}", reroutingKey, reason), e)  
            b.clear();
                            followUpRerouteTaskPriority,
            return new AsyncShardFetch.FetchResult<>(null, Collections.emptyMap());
 * compatible open source license.
        unassigned.forEach(shardRouting -> {  
 *
        deleteBatchIfEmpty(batches, batchId);
    // for tests
    private void ensureAsyncFetchStorePrimaryRecency(RoutingAllocation allocation) {
    }
 * @opensearch.internal
    );  
import org.opensearch.cluster.routing.ShardRouting;  
    }
            this.lastSeenEphemeralIds = newEphemeralIds;
    }  
        );
            // making the wrong decision here is not catastrophic so we only need to cover the common case.
            if (this.primary) {
        this.batchStartedAction = null;
import java.util.function.Predicate;  
            }
import org.opensearch.action.support.nodes.BaseNodesResponse;
        }  
                    if (timedOutReplicaShardIds.isEmpty() == false) {
            return "batchId: " + batchId;
            List<ShardRouting> eligibleShards,
        });
        @Override
            }
            .filter(entry -> entry.getValue().getBatchedShards().contains(shardRouting.shardId()))  
import org.opensearch.common.inject.Inject;
     * Number of shards we send in one batch to data nodes for fetching metadata  
                currentShard
        }
    public void applyStartedShards(final List<ShardRouting> startedShards, final RoutingAllocation allocation) {
                        assert rerouteService != null;
    class InternalBatchAsyncFetch<T extends BaseNodeResponse, V> extends AsyncShardBatchFetch<T, V> {  
            logger.debug("Batch {} is empty", batchId);
        safelyRemoveShardFromBatch(shardRouting, false);  
     * Safely remove shard from both the batches irrespective of its primary or replica,
    ) {  
                            + "] should be more than 20s or -1ms to disable timeout"
        this.maxBatchSize = batchSize;
    private void refreshShardBatches(
import java.util.ArrayList;  
    public static final TimeValue MIN_ALLOCATOR_TIMEOUT = TimeValue.timeValueSeconds(20);
     */  
                TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch>) fetchDataAndCleanIneligibleShards(
 */  
                    inEligibleShards,  
    protected ShardsBatchGatewayAllocator() {  
            return batchId.equals(shardsBatch.getBatchId()) && batchInfo.keySet().equals(shardsBatch.getBatchedShards());  
                if (timeValue.compareTo(MIN_ALLOCATOR_TIMEOUT) < 0 && timeValue.compareTo(TimeValue.MINUS_ONE) != 0) {
                new ShardAttributes(
            Class<V> clazz,
            super(
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch> fetchData(
        this.primaryShardsBatchGatewayAllocatorTimeout = null;  
import org.opensearch.common.settings.Setting;
                logger.trace("Batch cache is empty for batch {} ", batchId);
        this.rerouteService = rerouteService;
        public ShardEntry setShardRouting(ShardRouting shardRouting) {
            ClusterManagerMetrics clusterManagerMetrics
        1,
 * The OpenSearch Contributors require contributions made to  
                )
        Settings settings,
                );
                return false;  
     * so that we can clean up the batch if it is empty and release the fetching resources
    }  
                .stream()
            final Set<String> newEphemeralIds = StreamSupport.stream(Spliterators.spliterator(nodes.getDataNodes().entrySet(), 0), false)
        if (batches.containsKey(batchId) == false) {  
             * 3. Otherwise we return false.  
        ConcurrentMap<String, ShardsBatch> currentBatches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
    private long maxBatchSize;
    public void allocateUnassigned(
import org.opensearch.cluster.node.DiscoveryNodes;  
    class InternalPrimaryBatchShardAllocator extends PrimaryShardBatchAllocator {  
            ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
 */  
        if (batchId == null) {  
        boolean primary
        Setting.Property.Dynamic  
        inEligibleShards.forEach(sr -> safelyRemoveShardFromBatch(sr, sr.primary()));
            logger.debug("Shard[{}] is not batched", shardRouting);
        ) {  
                batchedShardsToAssign.add(shardRouting.shardId());
                }));  
     * after removing the shard
            ShardEntry shardEntry = new ShardEntry(  
                    batchEntry.getValue().clearShardFromCache(shardId);
            ShardsBatch shardsBatch = (ShardsBatch) o;
    private static void clearCacheForBatchPrimary(ShardsBatch batch, RoutingAllocation allocation) {
            }
                action,
        }
            Map<ShardId, ShardAttributes> shardIdsMap = batchInfo.entrySet()
        }
    }
            this.primary = primary;
        return batches.entrySet()
        boolean primary
            .findFirst()
        "cluster.routing.allocation.shards_batch_gateway_allocator.schedule_reroute.priority",
        assert maxBatchSize > 0 : "Shards batch size must be greater than 0";
    private static final short DEFAULT_SHARD_BATCH_SIZE = 2000;  
     * Timeout value must be greater than or equal to 20s or -1ms to effectively disable timeout
            assert batchInfo.size() == asyncBatch.shardAttributesMap.size() : "Shards size is not equal to fetcher size";  
    public class ShardsBatch {
        }
    protected ShardsBatchGatewayAllocator(long batchSize, RerouteService rerouteService) {
                                e -> logger.debug("reroute after existing shards allocator timed out failed", e)
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
                                r -> logger.trace("reroute after existing shards allocator timed out completed"),
        if (batches.containsKey(batchId)) {
        // when we want to fetch data we do for complete node, for doing this a new fetch flow will also handle just  
            if ((currentBatchedShards.containsKey(shardRouting.shardId()) == false) && (shardRouting.primary() == primary)) {
                        );
    public static final TimeValue DEFAULT_ALLOCATOR_TIMEOUT = TimeValue.timeValueSeconds(20);
                    eligibleShards,
        this.replicaShardsBatchGatewayAllocatorTimeout = REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(settings);
    @Override
        assert primaryShardBatchAllocator != null;
                String batchId = currentBatchedShards.get(shardRouting.shardId());  
        AsyncShardBatchFetch<? extends BaseNodeResponse, ?> fetch = batch.getAsyncFetcher();
    private void addBatch(ShardsBatch shardsBatch, boolean primary) {
            rerouteService.reroute(
import org.opensearch.core.action.ActionListener;
                if (timeValue.compareTo(MIN_ALLOCATOR_TIMEOUT) < 0 && timeValue.compareTo(TimeValue.MINUS_ONE) != 0) {
                batchesToBeAssigned.add(batchId);
        }  
            };  
            createAndUpdateBatches(routingAllocation, unassignedShard.primary());
        TimeValue.MINUS_ONE,  
            assert primaryShardBatchAllocator != null;  
            ShardBatchResponseFactory<T, V> responseFactory,
        }
import org.opensearch.indices.store.ShardAttributes;  
        },  
        this.batchStoreAction = null;  
        }  
                @Override
                ),  
        }
        RoutingAllocation allocation,
                            + "] should be more than 20s or -1ms to disable timeout"
            Logger logger,
        int count = 0;
    }
    private void deleteBatchIfEmpty(ConcurrentMap<String, ShardsBatch> batches, String batchId) {  
    // visible for testing  
import org.apache.logging.log4j.LogManager;
                            )  
}  
import java.util.Iterator;
        switch (priority) {
            return new BatchRunnableExecutor(runnables, () -> replicaShardsBatchGatewayAllocatorTimeout) {  
                );  
import org.opensearch.common.util.BatchRunnableExecutor;
        }
                // Set updated shard routing in batch if it already exists
        // create batches for unassigned shards  
            }
        Setting.Property.Dynamic
        ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
                perBatchShards.clear();
            String type,  
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
        public ShardRouting getShardRouting() {
                Priority.HIGH,  
                        "Setting ["  
             * It should return false if there has never been a fetch for this batch.  
     * Clear the fetched data for the primary to ensure we do not cancel recoveries based on excessively stale data.  
                .map(node -> node.getValue().getEphemeralId())  
                newShardsToBatch.put(shardRouting.shardId(), shardRouting);  
        // add all unassigned shards to the batch if they are not already in a batch
        public String getBatchId() {  
                        );  
        safelyRemoveShardFromBatch(shardRouting, true);
import org.opensearch.common.settings.ClusterSettings;  
        DEFAULT_ALLOCATOR_TIMEOUT,
        // fetching the data for a single shard on the node and fill that up in our cache
            .map(allocation.routingNodes()::activePrimary)
            @Override
        private final InternalBatchAsyncFetch<? extends BaseNodeResponse, ?> asyncBatch;  
 * Allocator for the gateway to assign batch of shards.  
    }
            if (currentBatchedShards.containsKey(shardRouting.shardId()) && shardRouting.primary() == primary) {  
            replicaShardBatchAllocator.processExistingRecoveries(allocation, storedShardBatches);  
        PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY,
                    public void onTimeout() {
            perBatchShards.put(currentShard.shardId(), shardEntry);  
            }
        this.batchStoreAction = batchStoreAction;  
        }  
        for (FailedShard failedShard : failedShards) {  
                emptyShardResponse,
        }
                }  
        if (allocation.routingNodes().hasInactiveShards()) {
            safelyRemoveShardFromBothBatch(startedShard);  
            // if shard is already batched update to latest shardRouting information in the batches
    /**
            .orElse(null);  
        assert unassignedShard.unassigned();
                    shardIdsMap,
     * @param shardRouting shard to be removed
                return false;  
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata;
            AsyncShardFetch.Lister<? extends BaseNodesResponse<T>, T> action,
     */  
            removeShard(shard.shardId());  
                emptyShardResponsePredicate,  
    protected final ConcurrentMap<String, ShardsBatch> batchIdToStoreShardBatch = ConcurrentCollections.newConcurrentMap();
            // Replica shard assignment can be cancelled if we get a better match. These ShardRouting objects also  
 * SPDX-License-Identifier: Apache-2.0
            .stream()
     * Timeout value must be greater than or equal to 20s or -1ms to effectively disable timeout
    protected BatchRunnableExecutor innerAllocateUnassignedBatch(  
    public int getNumberOfInFlightFetches() {  
        REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY,
    public BatchRunnableExecutor allocateAllUnassignedShards(final RoutingAllocation allocation, boolean primary) {
        // Although this flow can be optimized by only clearing the cache for the primary shard but currently
                    if (timedOutPrimaryShardIds.isEmpty() == false) {  
            batchIdToStoreShardBatch.values().forEach(batch -> clearCacheForBatchPrimary(batch, allocation));
    // visible for testing
        List<TimeoutAwareRunnable> runnables = new ArrayList<>();
    /**
            Set<ShardId> timedOutPrimaryShardIds = new HashSet<>();
        if (batchId == null) {
        return fetchResult;
            String batchId,
                    new GatewayStartedShard(null, false, null, null),
            deleteBatchIfEmpty(batches, batchEntry.getValue().getBatchId());  
                batchUUId,  
            .collect(Collectors.toList());  
            Releasables.close(b.values().stream().map(shardsBatch -> shardsBatch.asyncBatch).collect(Collectors.toList()));  
        return innerAllocateUnassignedBatch(allocation, primaryShardBatchAllocator, replicaShardBatchAllocator, primary);  
            batchEntry.getValue().getBatchedShards().forEach(shardId -> currentBatchedShards.put(shardId, batchEntry.getKey()));  
        if (batchesToAssign.isEmpty()) {
    private final RerouteService rerouteService;
        }
                    @Override
     * to allocate existing shards.
    }
            boolean primary,
            .stream()
        batch.removeFromBatch(shardRouting);  
            }  
    }
            RoutingAllocation allocation
            case URGENT:
    public ShardsBatchGatewayAllocator(  
        }
                    );  
            throw new IllegalStateException("Batch already exists. BatchId = " + shardsBatch.getBatchId());
import java.util.Locale;  
            // batch. This stale data can end up creating a same decision which has already been taken, and we'll see  
        // get all batched shards  
            return batchInfo.values().stream().map(ShardEntry::getShardRouting).collect(Collectors.toList());
     * Timeout for existing replica shards batch allocator.  
    protected Set<String> createAndUpdateBatches(RoutingAllocation allocation, boolean primary) {
                        "Setting ["  
            logger.trace("{} scheduling reroute for {}", reroutingKey, reason);
                    logger.trace("Triggering oncomplete after timeout for [{}] primary shards", timedOutPrimaryShardIds.size());
                                r -> logger.trace("reroute after existing shards allocator timed out completed"),  
        public List<ShardRouting> getBatchedShardRoutings() {
        if (fetchResult.hasData()) {
    protected void setPrimaryBatchAllocatorTimeout(TimeValue primaryShardsBatchGatewayAllocatorTimeout) {
     */
        this.clusterManagerMetrics = clusterManagerMetrics;
        this.replicaShardBatchAllocator = new InternalReplicaBatchShardAllocator();
        refreshShardBatches(currentBatches, batchedShardsToAssign, primary);
        }  
            if (lastSeenEphemeralIds.contains(node.getEphemeralId()) == false) {
        }
        Setting.Property.NodeScope,
        String batchId = primary ? getBatchId(shardRouting, true) : getBatchId(shardRouting, false);
    }
    private TimeValue replicaShardsBatchGatewayAllocatorTimeout;
            // create a ShardId -> customDataPath map for async fetch  
import org.opensearch.common.settings.Settings;
        return false;  
                currentBatches.get(batchId).batchInfo.get(shardRouting.shardId()).setShardRouting(shardRouting);  
        shardRouting = shardRouting == null && inEligibleShards.iterator().hasNext() ? inEligibleShards.iterator().next() : shardRouting;
import java.util.stream.StreamSupport;  
        if (batches.containsKey(shardsBatch.getBatchId())) {  
        }
     * Holds information about a shard to be allocated in a batch.
    ) {
import org.opensearch.common.lease.Releasables;
        Iterator<ShardRouting> iterator = newShardsToBatch.values().iterator();
                        rerouteService.reroute(
                    }
            // this is because {@link AsyncShardFetchCache#fillShardCacheWithDataNodes(DiscoveryNodes)} initialises this map
        }
        }  
                    shardIdsMap,  
             * In the case when shard has a batch, and a fetch has happened before, and no fetch is ongoing, it would be because we have already completed fetch for all nodes.
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> fetchData(
            List<ShardRouting> eligibleShards,
                batchSize = maxBatchSize;
    }
            // if fetchData has never been called, the per node cache will be empty and have no nodes
                asyncBatch = new InternalBatchAsyncFetch<>(  
                    "batch_shards_started",
        // get batch id for anyone given shard. We are assuming all shards will have same batchId  
                ShardsBatch shardsBatch = new ShardsBatch(batchUUId, perBatchShards, primary, clusterManagerMetrics);  
                currentBatches.get(batchId).batchInfo.get(shardRouting.shardId()).setShardRouting(shardRouting);
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
                            ActionListener.wrap(
import org.opensearch.common.Priority;
                            ActionListener.wrap(  
        }
     * Async fetcher is used to fetch the data for the batch.
            public void validate(TimeValue timeValue) {  
    }  
        protected boolean hasInitiatedFetching(ShardRouting shard) {  
 *
    // visible for testing  
        return batchIdToStoreShardBatch.size();  
        this.clusterManagerMetrics = new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE);
                addBatch(shardsBatch, primary);
        }
        this.maxBatchSize = maxBatchSize;
        Set<String> batchesToAssign = createAndUpdateBatches(allocation, primary);
import java.util.stream.Collectors;
            return batchId;
                "async_shard_batch_fetch",
    AsyncShardFetch.FetchResult<? extends BaseNodeResponse> fetchDataAndCleanIneligibleShards(
            }  
            return Objects.hash(batchId);
import java.util.Collections;
                public void onComplete() {
                return true;  
            fetchResult.processAllocation(allocation);
        for (ShardRouting startedShard : startedShards) {
        this.primaryShardBatchAllocator = new InternalPrimaryBatchShardAllocator();  
                return false;  
import org.opensearch.index.store.Store;
import org.apache.logging.log4j.message.ParameterizedMessage;  
            clearShardFromCache(shard.shardId());
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        if (getBatchId(unassignedShard, unassignedShard.primary()) == null) {
            if (this == o) {
                    new ShardBatchResponseFactory<>(true),  
    protected void safelyRemoveShardFromBothBatch(ShardRouting shardRouting) {
    static class ShardEntry {  
        Set<ShardId> batchedShardsToAssign,
            return new BatchRunnableExecutor(runnables, () -> primaryShardsBatchGatewayAllocatorTimeout) {
        private final String batchId;  
        private void clearShardFromCache(ShardId shardId) {  
        @Override
        private final boolean primary;
    }  
            // pass ShardRouting object directly from unassignedIterator, so we're following the same behaviour.
        }
                String batchUUId = UUIDs.base64UUID();
            shardToIgnoreNodes.put(shardId, allocation.getIgnoreNodes(shardId));  
                if (batchedShardsToAssign.contains(shardId) == false) {  
        return count;  
        List<List<ShardRouting>> storedShardBatches = batchIdToStoreShardBatch.values()  
        // We need to clear the cache for the primary shard to ensure we do not cancel recoveries based on excessively  
import java.util.Spliterators;
    private Set<String> lastSeenEphemeralIds = Collections.emptySet();
        return batchesToBeAssigned;
                .forEach(batch -> runnables.add(new TimeoutAwareRunnable() {
             * In the case when shard has a batch but no fetch has happened before, it would be because it is a new batch.  
        ConcurrentMap<String, ShardsBatch> batches = primary ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
        for (Map.Entry<String, ShardsBatch> batchEntry : currentBatches.entrySet()) {
            if (o instanceof ShardsBatch == false) {
        ) {
    );  
    protected final ConcurrentMap<String, ShardsBatch> batchIdToStartedShardBatch = ConcurrentCollections.newConcurrentMap();
                .stream()  
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getShardAttributes()));  
        public int getNumberOfInFlightFetches() {
                    shardIdIterator.remove();
        this.batchStartedAction = batchStartedAction;
        }
        ConcurrentMap<String, ShardsBatch> batches = shardRouting.primary() ? batchIdToStartedShardBatch : batchIdToStoreShardBatch;
            this.shardRouting = shardRouting;
        throw new IllegalArgumentException(
     * Cleans the batch if it is empty after removing the shard.  
     */
        }  
            return asyncBatch;
import java.util.Set;  
    }
                    logger,
             * 1. If the shard batch cache is empty, we know that fetch has never happened so we return false.
             * see {@link AsyncShardFetchCache#findNodesToFetch()}
        this.followUpRerouteTaskPriority = followUpRerouteTaskPriority;
        @Override
        Set<String> batchesToBeAssigned = new HashSet<>();  
        DEFAULT_SHARD_BATCH_SIZE,
    );  
    public static final String REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY =
        RoutingAllocation allocation,
package org.opensearch.gateway;
            .filter(Objects::nonNull)  
             * This function is to check if asyncFetch has happened before for this shard batch, or is ongoing.
            public void validate(TimeValue timeValue) {  
    }  
        this(DEFAULT_SHARD_BATCH_SIZE, null);
import java.util.List;
    private final ClusterManagerMetrics clusterManagerMetrics;  
import java.util.concurrent.ConcurrentMap;
        clusterSettings.addSettingsUpdateConsumer(GATEWAY_ALLOCATOR_BATCH_SIZE, this::setMaxBatchSize);
            }
        });  
import org.opensearch.cluster.routing.RoutingNodes;
     */
        Setting.Property.Dynamic
    private void setMaxBatchSize(long maxBatchSize) {  
             * They only want to use the data if it is already available.
                .stream()
        },  
            List<ShardRouting> inEligibleShards,  
        clusterSettings.addSettingsUpdateConsumer(FOLLOW_UP_REROUTE_PRIORITY_SETTING, this::setFollowUpRerouteTaskPriority);  
        for (ShardId shardId : shardsBatch.asyncBatch.shardAttributesMap.keySet()) {
    @Inject
            Set<ShardId> timedOutReplicaShardIds = new HashSet<>();  
        public ShardAttributes getShardAttributes() {  
    ) {
        public ShardsBatch(
        }));  
                    "new nodes {} found, clearing primary async-fetch-store cache",  
        }
