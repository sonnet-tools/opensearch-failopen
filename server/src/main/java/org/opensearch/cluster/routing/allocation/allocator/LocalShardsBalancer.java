            // fill in the correct weight ranking, once we've been through all nodes
                        weights[highIdx] = sorter.weight(modelNodes[highIdx]);
        }  
        for (Tuple<BalancedShardsAllocator.ModelNode, Decision> result : betterBalanceNodes) {  
                    checkAndAddInEligibleTargetNode(targetNode.getRoutingNode());
                        while (i < primaryLength - 1 && comparator.compare(primary[i], primary[i + 1]) == 0) {
                        + "are being throttled. Skipping shard iteration"
                                weights[lowIdx],
 */
     *      populated with the decision of moving to another node.  If {@link MoveDecision#forceMove()} ()} returns {@code true}, then
                    }  
             * Therefore we only do a rebalance if we have fetched all information.  
    ) {
                         */
                        logger.trace("Assigned shard [{}] to [{}]", shard, minNode.getNodeId());
 *
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
    }
    private boolean tryRelocateShard(BalancedShardsAllocator.ModelNode minNode, BalancedShardsAllocator.ModelNode maxNode, String idx) {
                    /* Shrinking the window from MIN to MAX  
                         * balance if we only achieve the same delta the relocation is useless
                            break;
        Decision decision = null;
            }
    @Override  
                        updateMinNode = currentDecision.type() == Decision.Type.YES;  
        }.sort(0, deltas.length);  
            if (currentWeight > minWeight && explain == false) {
            final int indexCmp;
            }
                            + ". Skipping relevant nodes iteration"
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
                }  
        return ((float) metadata.index(index).getTotalNumberOfShards()) / nodes.size();
            if (rebalanceConditionsMet) {
                        highIdx = relevantNodes - 1;
                            maxNode.getNodeId(),  
         * the sorter holds the minimum weight node first for the shards index.
     * allocations on added nodes from one index when the weight parameters
            }
            return MoveDecision.NOT_TAKEN;  
                    } else {
        }
                            allocation.clusterInfo(),  
             * we might end up with unnecessary rebalance operations which can be super confusion/frustrating
                        break;
     * The absolute value difference between two weights.  
    }  
                // if the simulated weight delta with the shard moved away is better than the weight delta
    private final float threshold;
                .filter(ShardRouting::started) // cannot rebalance unassigned, initializing or relocating shards anyway
     */  
    private boolean canShardBeSkipped(ShardRouting shardRouting) {  
                         */  
                indices[i] = indices[j];  
     *      {@link MoveDecision#getCanRemainDecision} will have a decision type of YES.  All other fields in the object will be null.
            return AllocateUnassignedDecision.no(UnassignedInfo.AllocationStatus.DECIDERS_NO, null);
        if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation))) {
                    modelNodes[relevantNodes] = modelNode;
        // balance the shard, if a better node can be found
                            weights[lowIdx],  
             * since once the fetches come back we might just move all the shards back again.
                    shardRouting,  
        Decision canRemain = allocation.deciders().canRemain(shardRouting, routingNode, allocation);  
                new NodeAllocationResult(
                    logger.info(
        Decision canRebalance = allocation.deciders().canRebalance(shard, allocation);
                if (logger.isTraceEnabled()) {
    public float avgShardsPerNode(String index) {  
    MoveDecision decideRebalance(final ShardRouting shard) {
    private final Supplier<Boolean> timedOutFunc;
            // Terminate if the time allocated to the balanced shards allocator has elapsed  
                nodeDecisions.add(new NodeAllocationResult(current.getNode(), current.getCanAllocateDecision(), ++weightRanking));  
            Stream<ShardRouting> routingStream = StreamSupport.stream(index.spliterator(), false)  
                } else {
                     *  for the 3 shards 2 replica case we try to build up:  
                nodeExplanationMap.put(node.getNodeId(), new NodeAllocationResult(node.getRoutingNode().node(), currentDecision, 0));
            if (moveDecision.isDecisionTaken() && moveDecision.forceMove()) {  
    /**  
            final MoveDecision moveDecision = decideMove(shardRouting);
                    // If we cannot allocate any shard to node marking it in eligible
                if (preferPrimaryRebalance == true && shard.primary() && maxNode.numPrimaryShards() - minNode.numPrimaryShards() < 2) {  
                    && maxNode.numPrimaryShards(shard.getIndexName()) - minNode.numPrimaryShards(shard.getIndexName()) < 2) {
                    "Cannot move any shard in the cluster as time allocated to balanced shards allocator has elapsed"  
     * with respect to the weight function. All given shards must be unassigned.
     */
            }  
            // that's why it's added last even though it could be easier to read
        final Comparator<ShardRouting> comparator = (o1, o2) -> {
import org.opensearch.cluster.routing.RoutingNode;
                        }
            ShardRouting[] tmp = primary;
     * function. The configured threshold is the minimum delta between the
            }
        }
        }
                }
                    break;
            int highIdx = relevantNodes - 1;
            } else if (betterWeightThanCurrent) {  
        }
            );
         * we use 2 arrays and move replicas to the second array once we allocated an identical
        ShardRouting[] primary = primaryList.toArray(new ShardRouting[0]);
    }
     * Returns {@code true} iff the weight delta between two nodes is under a defined threshold.
                    if (bestDecision == Decision.Type.YES) {  
     * weight of the maximum node and the minimum node according to the  
    /**
                continue;
                        logger.trace(
            }  
                            shard,
                    logger.debug("Relocate [{}] from [{}] to [{}]", shard, maxNode.getNodeId(), minNode.getNodeId());
        Logger logger,
                if (currentWeight == minWeight) {
                    final long shardSize = DiskThresholdDecider.getExpectedShardSize(
                                weights[highIdx],  
        Decision nodeLevelAllocationDecision = allocation.deciders().canAllocateAnyShardToNode(targetNode, allocation);
                    // when a replica cannot be allocated relies on this comparator.
     * current weight with respect to the index passed to the sorter. The  
                // the gains make it worth it, as defined by the threshold
    private final Metadata metadata;
                );
            }
                        }
                // with the shard remaining on the current node, and we are allowed to allocate to the  
                    ++weightRanking  
     * of ineligible target nodes
     */
            ShardRouting shardRouting = it.next();  
        RoutingNode routingNode = sourceNode.getRoutingNode();
                    }  
                // doing such relocation wouldn't help in primary balance. The condition won't be applicable when we enable node level  
                     * now we go max to min since obviously we can't move anything to the max node
                ShardRouting shard = primary[i];
                        + ". Skipping shard iteration"
            // For REMOTE_STORE recoveries, THROTTLE is as good as NO as we want faster recoveries
                NodeAllocationResult current = nodeExplanationMap.get(nodeWeight.v1());
                    /* Shrinking the window from MAX to MIN  
                continue;
            return;  
                // hence we add 2.0f to the weight delta  
                    }
             * if we allow rebalance operations while we are still fetching shard store data  
        final List<String> localIndices = new ArrayList<>();
                        new NodeAllocationResult(currentNode.getRoutingNode().node(), allocationDecision, ++weightRanking)  
        this.preferPrimaryRebalance = preferPrimaryRebalance;
                if (!explain && inEligibleTargetNode.contains(target)) continue;
        List<NodeAllocationResult> nodeDecisions = null;
        }  
        this.logger = logger;  
    private final boolean ignoreThrottleInRestore;
            protected int comparePivot(int j) {  
                continue;
                if (allocationDecision.type().higherThan(bestDecision)) {
import org.opensearch.cluster.routing.UnassignedInfo;
            // move these nodes to the front of modelNodes so that we can only balance based on these nodes  
     * to a node. This method will skip shards in the state
        for (BalancedShardsAllocator.ModelNode node : nodes.values()) {
                        if (logger.isTraceEnabled()) {
    }
    void balance() {
            canRemain,
                     */
    /**  
 * for local shards within the cluster.
                    /* only allocate on the cluster if we are not throttled */  
        if (shard.assignedToNode()) {
                    ++totalShardCount;  
                            logger.trace(  
                primaryList.add(shard);
        }  
        // when no target is eligible
        RoutingNode targetNode = null;
                final BalancedShardsAllocator.ModelNode minNode = modelNodes[lowIdx];
            for (ShardRouting shard : rn) {
        if (canShardBeSkipped(shardRouting)) {
                    if (logger.isTraceEnabled()) {
                        ++totalShardCount;  
        boolean preferPrimaryRebalance,
     * Checks if target node is ineligible and if so, adds to the list  
            sorter.reset(index, 0, relevantNodes);
        }
                    || (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG) && isPartialShard(shard, allocation)))
        }
            AllocationDecision nodeDecision = result.v2().type() == Decision.Type.NO  
            for (Tuple<String, Float> nodeWeight : nodeWeights) {
        }
                     *  2. prefer the node that holds the primary for this index with the next id in the ring ie.
import java.util.Iterator;
                // more even, it doesn't make sense to execute the heavyweight operation of relocating a shard unless
                    // Ensures that a failed replica allocation does not block the allocation of a search replica.
                        allocation.routingTable()
                        );
                final BalancedShardsAllocator.ModelNode targetNode = nodes.get(moveDecision.getTargetNode().getId());
                pivotWeight = deltas[i];
    private final RoutingNodes routingNodes;
     *   4. If the method is invoked in explain mode (e.g. from the cluster allocation explain APIs), then  
     * Checks if the shard can be skipped from the local shard balancer operations
                            allocation.routingTable()  
                        minNode.addShard(shard.initialize(minNode.getNodeId(), null, shardSize));
            if (RoutingPool.LOCAL_ONLY.equals(RoutingPool.getIndexPool(metadata.index(index)))) {  
        // offloading the shards.
                final BalancedShardsAllocator.ModelNode maxNode = modelNodes[highIdx];  
                // checks if the weight delta is above a certain threshold; if it is not above a certain threshold,
                        weights[lowIdx] = sorter.weight(modelNodes[lowIdx]);  
        List<Tuple<BalancedShardsAllocator.ModelNode, Decision>> sameBalanceNodes = new ArrayList<>();  
            final Iterable<ShardRouting> shardRoutings = routingStream::iterator;  
         * The arrays are sorted by primaries first and then by index and shard ID so a 2 indices with
                }  
                --totalShardCount;
     * Builds the internal model from all shards in the given  
                // Relax the above condition to per node to allow rebalancing to attain global balance
     * See {@link BalancedShardsAllocator#THRESHOLD_SETTING} for defining the threshold.  
     * is balanced moving three shards from two of the nodes over to the new node since it  
                                delta
                    }
        final AllocationDeciders deciders = allocation.deciders();
                final boolean updateMinNode;
            boolean considerThrottleAsNo = ignoreThrottleInRestore
    private final RoutingAllocation allocation;  
                if ((RoutingPool.LOCAL_ONLY.equals(RoutingPool.getShardPool(shard, allocation))
             * see https://github.com/elastic/elasticsearch/issues/14387
            // can make the balance of the cluster better, so we check for that here
import java.util.stream.Stream;  
     */  
        this.timedOutFunc = timedOutFunc;
                || (currentDecision.type() == Decision.Type.THROTTLE && considerThrottleAsNo == false)) {  
                        unassigned.ignoreShard(primary[i], UnassignedInfo.AllocationStatus.NO_ATTEMPT, allocation.changes());  
    }
        final float currentWeight = weight.weightWithRebalanceConstraints(this, currentNode, idxName);
                     *  such that if we need to tie-break we try to prefer the node holding a shard with the minimal id greater
                    "Cannot balance any shard in the cluster as time allocated to balanced shards allocator has elapsed"
                }
        }
                if (rebalanceConditionsMet && canAllocate.type().higherThan(rebalanceDecisionType)) {
                             */
            .sum()) / routingNodes.size();
        if (allocation.hasPendingAsyncFetch()) {  
    private final float avgPrimaryShardsPerNode;
        BalancedShardsAllocator.WeightFunction weight,
                currentNode = node;
            if (explain) {  
                    // This order is maintained because the logic that moves all replicas to unassigned  
        }
        if (canRemain.type() != Decision.Type.NO) {
                        // copy over the same replica shards to the secondary array so they will get allocated
            logger.trace("Staring allocation of [{}] unassigned shards", primaryLength);
                // node in question and move it away from the node that currently holds it.
                }
                    updateMinNode = currentWeight < minWeight;  
            }
        if (shardLevelDecision.type() == Decision.Type.NO && explain == false) {  
                                maxNode.getNodeId(),
                     *  1. if one decision is YES prefer it
                    lowIdx++;
    private static final Comparator<ShardRouting> PRIMARY_FIRST = Comparator.comparing(ShardRouting::primary).reversed();
                    }  
                return Float.compare(deltas[j], pivotWeight);
            if (canMoveAwayDecision.type() != Decision.Type.YES) {  
        boolean ignoreThrottleInRestore,  
                if (targetNode != null) {  
import org.opensearch.cluster.routing.ShardRouting;
                return;
            @Override
         * iteration order is different for each run and makes testing hard */
                    }  
                    if (logger.isTraceEnabled()) {  
    private final Set<RoutingNode> inEligibleTargetNode;  
        BalancedShardsAllocator.ModelNode currentNode = null;
    @Override  
                if (timedOutFunc != null && timedOutFunc.get()) {
 * this file be licensed under the Apache-2.0 license or a
        Decision.Type rebalanceDecisionType = Decision.Type.NO;  
                    lowIdx = 0;  
        // shard movements, the goal of this iteration order is to achieve a fairer movement of shards from the nodes that are  
                if (!explain) {  
    private void checkAndAddInEligibleTargetNode(RoutingNode targetNode) {  
        ShardRouting[] secondary = new ShardRouting[primary.length];
        }  
        /*  
                if (preferPrimaryBalance == true
                ? AllocationDecision.NO  
import org.opensearch.cluster.routing.allocation.MoveDecision;
            // we can only move started shards
                betterBalanceNodes.add(nodeResult);
     * explain API only.
        final float[] deltas = new float[indices.length];  
                Tuple<ShardRouting, ShardRouting> relocatingShards = routingNodes.relocateShard(
    @Override
     * Allocates all given shards on the minimal eligible node for the shards index
        // Trying to eliminate target nodes so that we do not unnecessarily iterate over source nodes  
                // Verifying if this node can be considered ineligible for further iterations
        RoutingAllocation allocation,  
            nodes.put(rn.nodeId(), node);  
            return;
            return MoveDecision.cannotRebalance(canRebalance, allocationDecision, currentNodeWeightRanking, nodeDecisions);  
    /**
                     *  primaries are added first and we only add one shard set a time in this algorithm.  
                if (allocationDecision.type() == Decision.Type.NO) {
                        i++;
                        );
    private int totalShardCount = 0;
                    modelNodes[i] = modelNodes[relevantNodes];
        List<Tuple<BalancedShardsAllocator.ModelNode, Decision>> betterBalanceNodes = new ArrayList<>();
            deltas[i] = sorter.delta();  
                    if (!shard.primary()) { // we could not allocate it and we are a replica - check if we can ignore the other replicas
        if (allocation.deciders().canRebalance(allocation).type() != Decision.Type.YES) {
        this.threshold = threshold;  
        this.metadata = allocation.metadata();
        int weightRanking = 0;  
        sorter.reset(shard.getIndexName());
        sorter.reset(shardRouting.getIndexName());
            IndexMetadata indexMetadata = metadata.index(index);  
import java.util.Set;
            && !(FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG) && isPartialShard(shardRouting, allocation)));
     * Returns an array view on the nodes in the balancer. Nodes should not be removed from this list.
     *      {@link MoveDecision#getTargetNode} will return a non-null value, otherwise the assignedNodeId will be null.
            nodeWeights.sort((nodeWeight1, nodeWeight2) -> Float.compare(nodeWeight1.v2(), nodeWeight2.v2()));
                continue;
     */
                );
    /**
                            && (nodeHigh < minNodeHigh)) || (nodeHigh > repId && minNodeHigh < repId));
        }  
        for (String index : allocation.routingTable().indicesRouting().keySet().toArray(new String[0])) {
            for (int i = 0; i < primaryLength; i++) {
            if (betterWeightThanCurrent) {
     * to the minimal eligible node with respect to the  
                    if (!shard.primary()) {
                    node.addShard(shard);
                    return;  
     * {@link ShardRoutingState#RELOCATING} since each relocating shard has  
    public float avgPrimaryShardsPerNode(String index) {
        final AllocationDeciders deciders = allocation.deciders();  
                } else {
     * optimally balanced cluster.  This method is invoked from the cluster allocation  
        return nodes.values().toArray(new BalancedShardsAllocator.ModelNode[0]);
     * is of type {@link Decision.Type#NO}, then the assigned node will be null.
                    /* allocate on the model even if throttled */  
                }
                ? AllocationDecision.AWAITING_INFO
            @Override
                    return;  
import org.opensearch.gateway.PriorityComparator;  
                        if (lowIdx > 0
     * a shadow shard in the state {@link ShardRoutingState#INITIALIZING}
                final BalancedShardsAllocator.ModelNode minNode = assignedNodeId != null ? nodes.get(assignedNodeId) : null;
            // as well as shards per index)
     * Balances the nodes on the cluster model according to the weight
                final String tmpIdx = indices[i];
        return Math.abs(higher - lower);
                final float tmpDelta = deltas[i];
                    if (delta <= 1.0f) {
    /**  
           to prevent floating point problems if the delta is very close to the
                    logger.debug("Simulate relocation of [{}] from [{}] to [{}]", shard, maxNode.getNodeId(), minNode.getNodeId());
            return MoveDecision.NOT_TAKEN;
            float pivotWeight;
    @Override
         * if we allocate for instance (0, R, IDX1) we move the second replica to the secondary array and proceed with
                    ++totalShardCount;
            // Early terminate node interleaved shard iteration when no eligible target nodes are available  
    }  
        int secondaryLength = 0;  
                            "Balancing from node [{}] weight: [{}] to node [{}] weight: [{}]  delta: [{}]",
     * {@link ShardRoutingState#RELOCATING} and a shadow instance of this
        }  
                     *    1 2 0
                return o1.primary() ? -1 : 1;
     * {@link ShardRoutingState#INITIALIZING}.
        for (Iterator<ShardRouting> it = allocation.routingNodes().nodeInterleavedShardIterator(shardMovementStrategy); it.hasNext();) {  
/*  
                logger.info(
                        lowIdx = 0;  
    /**  
        assert currentNode != null : "currently assigned node could not be found";  
        };  
                    relevantNodes++;  
                    if (minNode != null) {  
                    "Cannot move any shard in the cluster as there is no node on which shards can be allocated"  
                             * This break jumps straight to the condition below were we start moving from the high index towards
            }
        ArrayUtil.timSort(primary, comparator);
         * We now walk through the nodes until we find a node to allocate the shard.
        }
        final List<NodeAllocationResult> nodeExplanationMap = explain ? new ArrayList<>() : null;
         * This is not guaranteed to be balanced after this operation we still try best effort to  
                canRebalance,  
                logger.info(  
     * the threshold is set to {@code 1.0} to enforce gaining relocation
                if (o1.isSearchOnly() ^ o2.isSearchOnly()) {
            if (canShardBeSkipped(shardRouting)) {
     * Returns the average of shards per node for the given index  
        }  
            // find nodes that have a shard of this index or where shards of this index are allowed to be allocated to,
        ShardMovementStrategy shardMovementStrategy,
                    }
    }
                currentNodeWeightRanking,  
     * for global balance overrule the index balance at an intermediate
     * Makes a decision on whether to move a started shard to another node.  The following rules apply
                        continue;
 * compatible open source license.
                            );
            Tuple<BalancedShardsAllocator.ModelNode, Decision> nodeResult = Tuple.tuple(node, canAllocate);  
                nodeWeights.add(Tuple.tuple(node.getNodeId(), currentWeight));
        assert higher >= lower : higher + " lt " + lower + " but was expected to be gte";  
                BalancedShardsAllocator.ModelNode modelNode = modelNodes[i];  
                        }
             */
                }  
        Decision.Type bestDecision = Decision.Type.NO;  
    /**  
                         * compared to the added complexity
        }
            if (timedOutFunc != null && timedOutFunc.get()) {
            nodeDecisions.add(  
        }  
                ? AllocationDecision.NO
            Decision canMoveAwayDecision = allocation.deciders().canMoveAway(shardRouting, allocation);
            for (int i = 0; i < modelNodes.length; i++) {
            if (node == currentNode) {  
                long shardSize = allocation.clusterInfo().getShardSize(shard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);  
                    } else if (tryRelocateShard(minNode, maxNode, index)) {  
    void moveShards() {
                logger.info(  
            return MoveDecision.stay(canRemain);
            if (RoutingPool.LOCAL_ONLY.equals(RoutingPool.getShardPool(shard, allocation))) {  
                            /* This is a special case if allocations from the "heaviest" to the "lighter" nodes is not possible
     * {@link BalancedShardsAllocator.ModelNode} representing the node that the shard should be assigned to.  If the decision returned  
     * This builds a initial index ordering where the indices are returned
import java.util.List;
                        if (logger.isTraceEnabled()) {
                worseBalanceNodes.add(nodeResult);  
         * [(0,P,IDX1), (0,P,IDX2), (0,R,IDX1), (0,R,IDX1), (0,R,IDX2), (0,R,IDX2)]  
                         * we could just find the place to insert linearly but the win might be minor  
    /**
                }  
                    /*  we have an equal weight tie breaking:  
            if (currentDecision.type() == Decision.Type.YES
        }
        }  
                : AllocationDecision.WORSE_BALANCE;
            if (timedOutFunc != null && timedOutFunc.get()) {
            }
import java.util.HashMap;
     * with 3 primary and 1 replica shards. At the first stage all three nodes hold
            // moving the shard would not improve the balance, and we are not in explain mode, so short circuit  
                     *  than the id of the shard we need to assign. This works find when new indices are created since
    private static final Comparator<ShardRouting> BY_DESCENDING_SHARD_ID = Comparator.comparing(ShardRouting::shardId).reversed();  
            if (o1.primary() ^ o2.primary()) {  
    }
     * has no shards yet and global balance for the node is way below
                routingNodes.unassigned().add(shard);  
                }
     * simulation model as well as on the cluster.  
            }
                    return o1.isSearchOnly() ? 1 : -1;  
                    // did *not* receive a YES decision  
                         * hit this case anyway.
     * @param shardRouting the shard to be checked  
                            maxNode.getNodeId(),  
                RoutingNode target = currentNode.getRoutingNode();  
                }
            for (ShardRouting shard : shardRoutings) {
            decision = Decision.NO;
     * average. To re-balance we need to move shards back eventually likely
                        allocation.metadata(),
                        "Cannot balance any shard in the cluster as time allocated to balanced shards allocator has elapsed"  
import java.util.Collections;  
                if (allocationDecision.getAllocationDecision() == AllocationDecision.YES) {  
import org.opensearch.cluster.routing.ShardMovementStrategy;
                             * less nodes than another zone. so one zone is horribly overloaded from a balanced perspective but we
                    ++totalShardCount;  
    }
                sourceNode.removeShard(shardRouting);  
                // primary rebalance
    }  
        return ((float) metadata.index(index).getNumberOfShards()) / nodes.size();  
                sameBalanceNodes.add(nodeResult);
    private BalancedShardsAllocator.NodeSorter newNodeSorter() {
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;  
        return avgPrimaryShardsPerNode;
        Map<String, NodeAllocationResult> nodeExplanationMap = explain ? new HashMap<>() : null;
         */
        if (logger.isTraceEnabled()) {
            }  
        for (Tuple<BalancedShardsAllocator.ModelNode, Decision> result : sameBalanceNodes) {
                assert rn.nodeId().equals(shard.currentNodeId());
    public float avgPrimaryShardsPerNode() {
        List<ShardRouting> primaryList = new ArrayList<>();
            secondary = tmp;  
        final String idxName = shard.getIndexName();  
                }
            logger.debug("skipping rebalance due to in-flight shard/store fetches");
        List<Tuple<BalancedShardsAllocator.ModelNode, Decision>> worseBalanceNodes = new ArrayList<>();
                        + ". Skipping indices iteration"
                );
                    assert decision.type() == Decision.Type.THROTTLE;
            BalancedShardsAllocator.ModelNode node = new BalancedShardsAllocator.ModelNode(rn);
                    }
            nodeExplanationMap
    void allocateUnassigned() {
        }
            if ((shardMovementStrategy == ShardMovementStrategy.PRIMARY_FIRST) && primariesThrottled && !shardRouting.primary()) {
    private String[] buildWeightOrderedIndices() {
     * distribute shards evenly per index. The balancer tries to relocate
     * Move started shards that can not be allocated to a node anymore  
import org.opensearch.cluster.routing.RoutingNodes;
                continue;  
        /*  
            protected void swap(int i, int j) {
        assert sourceNode != null && sourceNode.containsShard(shardRouting);
     * Returns a new {@link BalancedShardsAllocator.NodeSorter} that sorts the nodes based on their
        if (logger.isTraceEnabled()) {  
import org.apache.lucene.util.IntroSorter;  
                .filter(maxNode::containsShard) // check shards which are present on heaviest node
                     * lets pick the next highest */
            inEligibleTargetNode.add(targetNode);  
            }
                }
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
                        continue;
         * allocate on the minimal eligible node.
            }
                    // Orders replicas first, followed by search replicas (e.g., R1, R1, S1, S1).
                if (updateMinNode) {
     *   3. If the shard is not allowed to remain on its current node, then {@link MoveDecision#getAllocationDecision()} will be  
                        final long shardSize = DiskThresholdDecider.getExpectedShardSize(  
            }
                advance_range: if (maxNode.numShards(index) > 0) {
            }
                    && shard.primary()
        boolean primariesThrottled = false;
            Decision currentDecision = allocation.deciders().canAllocate(shard, node.getRoutingNode(), allocation);
        Map<String, BalancedShardsAllocator.ModelNode> nodes = new HashMap<>();  
        BalancedShardsAllocator.ModelNode minNode = null;
                            "No eligible node found to assign shard [{}] allocation_status [{}]",  
        final BalancedShardsAllocator.ModelNode[] modelNodes = sorter.modelNodes;
            // this comparator is more expensive than all the others up there  
                    continue;
                routingStream = routingStream.sorted(PRIMARY_FIRST);
                        }  
            // indices all shards of the same index is treated equally.  
import org.opensearch.cluster.metadata.IndexMetadata;
                    nodeExplanationMap.add(
                            && (absDelta(weights[0], weights[highIdx - 1]) > threshold) // check if we need to break at all  
                            allocation.metadata(),
    /**
        int weightRanking = 0;
                            && highIdx - 1 > 0 // is there a chance for a higher delta?
     * <p>
            // if the node we are examining has a worse (higher) weight than the node the shard is  
        if (index != null) {
            // is not being throttled.
        return AllocateUnassignedDecision.fromDecision(decision, minNode != null ? minNode.getRoutingNode().node() : null, nodeDecisions);  
    private final Map<String, BalancedShardsAllocator.ModelNode> nodes;
            AllocationDecision allocationDecision = allocation.hasPendingAsyncFetch()  
            // weight of this index currently on the node
        RoutingNodes.UnassignedShards unassigned = routingNodes.unassigned();  
                }  
            checkAndAddInEligibleTargetNode(currentNode.getRoutingNode());  
                ++totalShardCount;  
                            secondary[secondaryLength++] = primary[++i];
     * on the target node which we respect during the allocation / balancing
 *  
    }  
            // Verify if the cluster concurrent recoveries have been reached.
                        );  
            );
                            break advance_range;  
                        ) {
                new NodeAllocationResult(result.v1().getRoutingNode().node(), nodeDecision, result.v2(), currentNodeWeightRanking)
                : AllocationDecision.WORSE_BALANCE;
                if (decision.type() == Decision.Type.YES) {
import static org.opensearch.action.admin.indices.tiering.TieringUtils.isPartialShard;  
                final Decision allocationDecision = deciders.canAllocate(shard, minNode.getRoutingNode(), allocation);
                    continue;  
                        allocation.snapshotShardSizeInfo(),  
            if (relevantNodes < 2) {
        } else {
                    Decision nodeLevelAllocationDecision = allocation.deciders().canAllocateAnyShardToNode(target, allocation);
        BalancedShardsAllocator.ModelNode[] modelNodes = sorter.modelNodes;
                             * the low index to shrink the window we are considering for balance from the other direction.
    @Override
    /**
            );
    }
                );  
                } else {
     *      {@link MoveDecision#getNodeDecisions} will have a non-null value.
        if (logger.isTraceEnabled()) {  
        this.preferPrimaryBalance = preferPrimaryBalance;  
    private final ShardMovementStrategy shardMovementStrategy;
            return MoveDecision.NOT_TAKEN;
        nodes = Collections.unmodifiableMap(buildModelFromAssigned());  
                }
        if (nodeLevelAllocationDecision.type() != Decision.Type.YES) {
                    primariesThrottled = true;  
     * {@link BalancedShardsAllocator.WeightFunction}. This weight is calculated per index to
                final Decision rebalanceDecision = deciders.canRebalance(shard, allocation);  
            logger.trace("Try relocating shard of [{}] from [{}] to [{}]", idx, maxNode.getNodeId(), minNode.getNodeId());
                    && shard.state() != RELOCATING) {  
        } while (primaryLength > 0);
        final float[] weights = sorter.weights;
     */
        // clear everything we have either added it or moved to ignoreUnassigned  
                     * we can't move from any shard from the min node lets move on to the next node
                        sorter.sort(0, relevantNodes);
                    );  
        if (decision == null) {  
    @Override
            logger.trace("Start allocating unassigned shards");  
 * SPDX-License-Identifier: Apache-2.0
                }
            }
                            weights[highIdx],
                localIndices.add(index);
            }
                    // THROTTLE and we get a decision with YES on another node
                    minNode.addShard(shard.relocate(minNode.getNodeId(), shardSize));  
    private final BalancedShardsAllocator.WeightFunction weight;
            // Terminate if the time allocated to the balanced shards allocator has elapsed
     * Balances the nodes on the cluster model according to the weight function.
                /* we skip relocating shards here since we expect an initializing shard with the same id coming in */  
                         * TODO we could be a bit smarter here, we don't need to fully sort necessarily
                }
                final String assignedNodeId = allocationDecision.getTargetNode() != null
}
                    // swap nodes at position i and relevantNodes  
                // This is a safety net which prevents un-necessary primary shard relocations from maxNode to minNode when
        for (RoutingNode rn : routingNodes) {
                if (shardRouting.primary() && canMoveAwayDecision.type() == Decision.Type.THROTTLE) {
                    if (currentDecision.type() == decision.type()) {
        return indices;
            } else {
        final boolean explain = allocation.debugDecision();
                    }
                // then even though the node we are examining has a better weight and may make the cluster balance  
                    } else {
    AllocateUnassignedDecision decideAllocateUnassigned(final ShardRouting shard) {
 * The OpenSearch Contributors require contributions made to  
        sorter = newNodeSorter();
                return;  
     * to the {@link MoveDecision} return object:
                    unassigned.ignoreShard(shard, allocationDecision.getAllocationStatus(), allocation.changes());
                        while (i < primaryLength - 1 && comparator.compare(primary[i], primary[i + 1]) == 0) {  
                        + ". Skipping shard iteration"
            // the current weight of the node in the cluster, as computed by the weight function;
        this.weight = weight;
        if (shardRouting.started() == false) {  
            // Verify if the shard is allowed to move if outgoing recovery on the node hosting the primary shard  
                assignedNode != null ? assignedNode.getRoutingNode().node() : null,
            return;
import java.util.function.Supplier;
        logger.trace("No shards of [{}] can relocate from [{}] to [{}]", idx, maxNode.getNodeId(), minNode.getNodeId());  
                .sorted(BY_DESCENDING_SHARD_ID); // check in descending order of shard id so that the decision is deterministic  
                float currentDelta = absDelta(nodeWeight, currentWeight);
     * shards only if the delta exceeds the threshold. In the default case  
                    }
                AllocationDecision.fromDecisionType(rebalanceDecisionType),
                if (explain) {
                Decision allocationDecision = allocation.deciders().canAllocate(shardRouting, target, allocation);  
    /**
            }  
                if (modelNode.getIndex(index) != null
        this.ignoreThrottleInRestore = ignoreThrottleInRestore;  
            }
                if (timedOutFunc != null && timedOutFunc.get()) {
     * balance model. Iff this method returns a <code>true</code> the relocation has already been executed on the
                    highIdx--;
        // Iterate over the started shards interleaving between nodes, and check if they can remain. In the presence of throttling
                    minNode = node;  
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>(modelNodes.length - 1);
                            allocationDecision.getAllocationStatus()
     * returned sorter is not sorted. Use {@link BalancedShardsAllocator.NodeSorter#reset(String)}
            protected int compare(int i, int j) {
        this.routingNodes = allocation.routingNodes();
            primaryLength = secondaryLength;  
                final BalancedShardsAllocator.ModelNode sourceNode = nodes.get(shardRouting.currentNodeId());
     * shard is created with an incremented version in the state  
        /* find an node with minimal weight we can allocate on*/
import org.opensearch.cluster.metadata.Metadata;
        /* deltas close to the threshold are "rounded" to the threshold manually  
                        if (explain == false) {
                    AllocationDecision.fromDecisionType(result.v2().type()),
                boolean deltaAboveThreshold = lessThan(currentDelta, threshold) == false;  
            // decision was not set and a node was not assigned, so treat it as a NO decision
                deltas[j] = tmpDelta;
        new IntroSorter() {
                return;
    private static boolean lessThan(float delta, float threshold) {
    public LocalShardsBalancer(
    /**
    private void balanceByWeights() {
    MoveDecision decideMove(final ShardRouting shardRouting) {
import java.util.Comparator;
import java.util.Map;  
                            ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE,
        Supplier<Boolean> timedOutFunc
                    shard = routingNodes.initializeShard(shard, minNode.getNodeId(), null, shardSize, allocation.changes());
            }
                if (rebalanceDecision.type() == Decision.Type.NO) {
            logger.trace("Start balancing cluster");
        for (BalancedShardsAllocator.ModelNode currentNode : sorter.modelNodes) {
                // If both are primary or both are non-primary, compare by ID  
                targetNode.addShard(relocatingShards.v2());
    /**
                     * index on this node of allocation deciders prevent any relocation.*/  
                indices[j] = tmpIdx;
    private static float absDelta(float lower, float higher) {
                : AllocationDecision.fromDecisionType(canRebalance.type());
            }  
     * For each shard to be moved this function executes a move operation
        if (shard.started() == false) {  
            boolean rebalanceConditionsMet = false;
                             * can't move to the "lighter" shards since otherwise the zone would go over capacity.
    private final Logger logger;
     */
 * A {@link LocalShardsBalancer} used by the {@link BalancedShardsAllocator} to perform allocation operations
     * Makes a decision about moving a single shard to a different node to form a more
                    final float delta = absDelta(weights[lowIdx], weights[highIdx]);
     */  
        assert !nodes.isEmpty();
        }
                        shard,  
        if (canRebalance.type() != Decision.Type.YES || allocation.hasPendingAsyncFetch()) {
            }
                // node in question, then allow the rebalance
     * process. In short, this method recreates the status-quo in the cluster.  
                break;  
            nodeDecisions = new ArrayList<>();  
                    }  
                                index,
    private final BalancedShardsAllocator.NodeSorter sorter;
                        }  
                    return false;
                // don't use canRebalance as we want hard filtering rules to apply. See #17698
                // don't use canRebalance as we want hard filtering rules to apply. See #17698
                    if (lessThan(delta, threshold)) {  
    }
            int lowIdx = 0;  
           threshold ie. 1.000000002 which can trigger unnecessary balance actions*/
        // find currently assigned node
            // NO decision for allocating the shard, irrespective of any particular node, so exit early
            logger.trace("skipping rebalance as it is disabled");  
                        final int repId = shard.id();  
                        assert allocationDecision.getAllocationStatus() == UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED;
                        (primaryLength - i)  
                            // no need to continue iterating
            // The side effect of this are increased relocations post these allocations.  
            return MoveDecision.NOT_TAKEN;  
        boolean preferPrimaryBalance,
                // get the delta between the weights of the node we are checking and the node that holds the shard  
                    minNode.addShard(shard);
                             *  
        Decision shardLevelDecision = allocation.deciders().canAllocate(shard, allocation);
                        logger.trace("Assigned shard [{}] to node [{}]", shard, node.getNodeId());
        if (nodes.size() < 2) { /* skip if we only have one node */  
            // If primary balance is preferred then prioritize moving primaries first
                );
     * to the nodes we relocated them from.  
                return;  
            if (sorter.modelNodes.length == inEligibleTargetNode.size()) {
                    "Cannot move any shard in the cluster due to cluster concurrent recoveries getting breached"
        final BalancedShardsAllocator.ModelIndex index = maxNode.getIndex(idx);  
        );
            if (preferPrimaryBalance == true) {  
                    ? allocationDecision.getTargetNode().getId()
                                "Stop balancing index [{}]  min_node [{}] weight: [{}]" + "  max_node [{}] weight: [{}]  delta: [{}]",
        float minWeight = Float.POSITIVE_INFINITY;  
/**  
            // that should be on each node on average (both taking the cluster as a whole into account  
                             * See #3580
        return delta <= (threshold + 0.001f);  
                            minNode.getNodeId()
     */
import java.util.ArrayList;
            int weightRanking = 0;  
            // assigned to, then there is no way moving the shard to the node with the worse weight
                final Decision decision = new Decision.Multi().add(allocationDecision).add(rebalanceDecision);  
                } else {
        balanceByWeights();
                         * prevent relocations that only swap the weights of the two nodes. a relocation must bring us closer to the  
 */  
                            allocation.snapshotShardSizeInfo(),
import org.opensearch.common.util.FeatureFlags;
                    assignedNode = node;  
        int primaryLength = primary.length;
        this.allocation = allocation;
                --totalShardCount;
                    continue;  
         * replica in the current iteration to make sure all indices get allocated in the same manner.  
        }
                        targetNode = target;
            final boolean betterWeightThanCurrent = nodeWeight <= currentWeight;  
import org.apache.lucene.util.ArrayUtil;
            final int secondary = secondaryComparator.compare(o1, o2);
                return;  
         * the next replica. If we could not find a node to allocate (0,R,IDX1) we move all it's replicas to ignoreUnassigned.
    private BalancedShardsAllocator.ModelNode[] nodesArray() {
            if (allocation.deciders().canMoveAnyShard(allocation).type() != Decision.Type.YES) {
     */
                            "Couldn't find shard to relocate from node [{}] to node [{}]",
    }
     * Make a decision for allocating an unassigned shard.  This method returns a two values in a tuple: the
        }
import java.util.HashSet;  
import org.opensearch.cluster.routing.RoutingPool;  
     *   2. If the shard is allowed to remain on its current node, no attempt will be made to move the shard and
                         * already know that lessThan(delta, threshold) == false and threshold defaults to 1.0, so by default we never
import org.opensearch.cluster.routing.allocation.AllocationDecision;  
                            unassigned.ignoreShard(primary[++i], allocationDecision.getAllocationStatus(), allocation.changes());
                    if (logger.isTraceEnabled()) {  
                    : null;  
    }
                    );
        }
                     * and see if the threshold still holds. We either don't have any shard of this
        }
        }  
            return;  
                logger.info(
                    /* we are done here, we either can't relocate anymore or we are balanced */  
                        // throttle decision scenario
            secondaryLength = 0;
                boolean betterWeightWithShardAdded = proposedDelta < currentDelta;
        int currentNodeWeightRanking = ++weightRanking;
        }  
        final boolean explain = allocation.debugDecision();
        do {  
            final Decision canAllocate = deciders.canAllocate(shard, node.getRoutingNode(), allocation);  
        final PriorityComparator secondaryComparator = PriorityComparator.getAllocationComparator(allocation);
        for (Tuple<BalancedShardsAllocator.ModelNode, Decision> result : worseBalanceNodes) {
            }
            }
            }  
        BalancedShardsAllocator.ModelNode assignedNode = null;
            float currentWeight = weight.weightWithAllocationConstraints(this, node, shard.getIndexName());
    }  
        final BalancedShardsAllocator.ModelNode sourceNode = nodes.get(shardRouting.currentNodeId());  
                            minNode.getNodeId(),
                    // rebalance to the node, only will get overwritten if the decision here is to  
                // If one is primary and the other isn't, primary comes first
                // decision is NO without needing to check anything further, so short circuit  
import org.opensearch.common.collect.Tuple;
        List<Tuple<String, Float>> nodeWeights = explain ? new ArrayList<>() : null;  
                    result.v1().getRoutingNode().node(),  
import org.opensearch.cluster.routing.allocation.decider.Decision;
            // Ensure that replicas don't relocate if primaries are being throttled and primary first shard movement strategy is enabled  
            .mapToInt(IndexMetadata::getNumberOfShards)
            sorter.reset(indices[i]);
        for (BalancedShardsAllocator.ModelNode currentNode : sorter.modelNodes) {
                }
            }
            protected void setPivot(int i) {
            }
                            shard,
                    decision = currentDecision;
         */  
                    || deciders.canAllocate(indexMetadata, modelNode.getRoutingNode(), allocation).type() != Decision.Type.NO) {
                    minWeight = currentWeight;
     */
    }
                nodeDecisions
                        );
        return (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shardRouting, allocation))
     */  
    @Override  
                             * due to some allocation decider restrictions like zone awareness. if one zone has for instance  
    /**  
        final String currentNodeId = shard.currentNodeId();  
                    logger.info(
                    );
                     *    2 0 1
        return new BalancedShardsAllocator.NodeSorter(nodesArray(), weight, this);
         * TODO: We could be smarter here and group the shards by index and then
    private final boolean preferPrimaryRebalance;
        if (explain) {
            } else if (moveDecision.isDecisionTaken() && moveDecision.canRemain() == false) {  
                             * (check shrinking the window from MAX to MIN)  
                    allocation.clusterInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
public class LocalShardsBalancer extends ShardsBalancer {  
                if (logger.isDebugEnabled()) logger.debug("Cannot move away shard [{}] Skipping this shard", shardRouting);
                            // we are not in explain mode and already have a YES decision on the best weighted node,  
        for (BalancedShardsAllocator.ModelNode node : modelNodes) {  
                    result.v2(),
            /*
        for (BalancedShardsAllocator.ModelNode node : modelNodes) {
     * only, or in other words relocations that move the weight delta closer
     * Returns the global average of shards per node  
                        "Ignoring [{}] unassigned shards for allocation as time allocated to balanced shards allocator has elapsed",
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
        this.shardMovementStrategy = shardMovementStrategy;
        return false;
                    logger.trace("Moved shard [{}] to node [{}]", shardRouting, targetNode.getRoutingNode());
                )
                    );
        avgPrimaryShardsPerNode = (float) (StreamSupport.stream(metadata.spliterator(), false)  
                        allocation.clusterInfo(),
            if ((indexCmp = o1.getIndexName().compareTo(o2.getIndexName())) == 0) {  
            }
        }
     * to {@code 0.0}  
         * use the sorter to save some iterations.
                );  
            }  
        /*
            // we can only rebalance started shards
                    bestDecision = allocationDecision.type();
                     *    0 1 2  
                float proposedDelta = 2.0f + nodeWeight - currentWeight;
                            logger.trace("No Node found to assign shard [{}]", shard);  
                }
        for (String index : buildWeightOrderedIndices()) {  
                            delta
                continue; // skip over node we're currently allocated to
     * state. For example this can happen if we have 3 nodes and 3 indices  
    /**
     */
                        /*
            } else {
                         * NB this comment above was preserved from an earlier version but doesn't obviously describe the code today. We  
            AllocationDecision.fromDecisionType(bestDecision),
            while (true) {
                }
package org.opensearch.cluster.routing.allocation.allocator;
                    minNode.addShard(routingNodes.relocateShard(shard, minNode.getNodeId(), shardSize, allocation.changes()).v1());
                        logger.trace(
                && shard.primary();  
 * @opensearch.internal
                        }  
     * 2 shard for each index. Now we add another node and the first index
                } else if (lowIdx > 0) {
import java.util.stream.StreamSupport;
    @Override  
    }
                && shard.recoverySource().getType() == RecoverySource.Type.REMOTE_STORE
                    targetNode.getNodeId(),
                    // TODO - maybe check if we can allow wait for active shards thingy bypass this condition  
     */
                logger.info(
            if (node.containsShard(shard) && explain == false) {
    private Map<String, BalancedShardsAllocator.ModelNode> buildModelFromAssigned() {
    @Override
            logger.trace("skipping rebalance as single node only");
         */  
            final AllocationDeciders deciders = allocation.deciders();
                    ++totalShardCount;
         * 2 replica and 1 shard would look like:
            nodeDecisions.add(new NodeAllocationResult(result.v1().getRoutingNode().node(), nodeDecision, result.v2(), ++weightRanking));
                    && preferPrimaryRebalance == false  
                        + ". Skipping shard iteration"
    /**
    private final boolean preferPrimaryBalance;
        inEligibleTargetNode = new HashSet<>();
import org.opensearch.cluster.routing.RecoverySource;  
            }  
            nodeDecisions.add(
    /**
        /* Don't iterate over an identity hashset here the  
        return totalShardCount / nodes.size();
            if (currentNode != sourceNode) {
                    continue;
     * to sort based on an index.
                        final int minNodeHigh = minNode.highestPrimary(shard.getIndexName());
     * Tries to find a relocation from the max node to the minimal node for an arbitrary shard of the given index on the
            }
            return secondary == 0 ? indexCmp : secondary;
    @Override  
                                minNode.getNodeId(),  
                return Float.compare(deltas[j], deltas[i]);  
     * first value is the {@link Decision} taken to allocate the unassigned shard, the second value is the
                rebalanceConditionsMet = deltaAboveThreshold && betterWeightWithShardAdded;
                final AllocateUnassignedDecision allocationDecision = decideAllocateUnassigned(shard);  
            final float nodeWeight = weight.weightWithRebalanceConstraints(this, node, idxName);
                return o1.getId() - o2.getId();
                    if (nodeLevelAllocationDecision.type() != Decision.Type.YES) {  
        }
            int relevantNodes = 0;
            @Override  
            if (node.getNodeId().equals(currentNodeId)) {
                    allocation.changes()  
     *   1. If the shard is not started, no decision will be taken and {@link MoveDecision#isDecisionTaken()} will return false.  
                // break if the time allocated to the balanced shards allocator has elapsed  
            // we only make decisions for unassigned shards here  
                    return true;
                }
                    "Cannot move any replica shard in the cluster as movePrimaryFirst is enabled and primary shards"  
                }
                maxNode.removeShard(shard);
            // this is a comparison of the number of shards on this node to the number of shards
            return MoveDecision.rebalance(
                    }
        }
     */
                if (lowIdx < highIdx - 1) {
     * weight function. If a shard is moved the shard will be set to
            primary = secondary;
                }
        if (unassigned.isEmpty()) {
        float threshold,  
import org.opensearch.cluster.routing.ShardRoutingState;  
                    }
     * The actual balancing is delegated to {@link #balanceByWeights()}
                        /*
                deltas[i] = deltas[j];  
    }
            targetNode != null ? targetNode.node() : null,  
     */
    }  
                // TODO maybe we can respect throttling here too?  
        for (int i = 0; i < deltas.length; i++) {
                    while (i < primaryLength) {
                // calculate the delta of the weights of the two nodes if we were to add the shard to the
                        updateMinNode = ((((nodeHigh > repId && minNodeHigh > repId) || (nodeHigh < repId && minNodeHigh < repId))  
        return MoveDecision.cannotRemain(  
            }
                        inEligibleTargetNode.add(currentNode.getRoutingNode());
            return AllocateUnassignedDecision.NOT_TAKEN;
    }
     * in most unbalanced first. We need this in order to prevent over  
     */
                         *
        final String[] indices = localIndices.toArray(new String[0]);
                        // in a subsequent iteration, allowing replicas of other shards to be allocated first  
        return nodes;  
                logger.trace("[{}][{}] can't move", shardRouting.index(), shardRouting.id());
                        logger.trace(
            @Override  
    public float avgShardsPerNode() {  
                    if (logger.isTraceEnabled()) {
        for (ShardRouting shard : unassigned.drain()) {
     * @return true if the shard can be skipped, false otherwise
                        ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE,
            AllocationDecision nodeDecision = result.v2().type() == Decision.Type.NO
                        final int nodeHigh = node.highestPrimary(shard.index().getName());
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
import org.apache.logging.log4j.Logger;
     * {@link Iterable}. All shards in the {@link Iterable} must be assigned
        }  
                    rebalanceDecisionType = canAllocate.type();
            // if we'd apply it earlier. this comparator will only differentiate across
     */
