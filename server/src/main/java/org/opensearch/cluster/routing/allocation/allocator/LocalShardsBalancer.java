 * compatible open source license.
     * @return true if the shard can be skipped, false otherwise
                // decision is NO without needing to check anything further, so short circuit
            } else {
        }
         * [(0,P,IDX1), (0,P,IDX2), (0,R,IDX1), (0,R,IDX1), (0,R,IDX2), (0,R,IDX2)]
    private final float avgPrimaryShardsPerNode;
                    continue;
                .sorted(BY_DESCENDING_SHARD_ID); // check in descending order of shard id so that the decision is deterministic
                            );
    private final ShardMovementStrategy shardMovementStrategy;
import java.util.stream.StreamSupport;
                    if (logger.isTraceEnabled()) {
        final BalancedShardsAllocator.ModelNode sourceNode = nodes.get(shardRouting.currentNodeId());
                );
            // decision was not set and a node was not assigned, so treat it as a NO decision
    private boolean canShardBeSkipped(ShardRouting shardRouting) {
                }
     * {@link Iterable}. All shards in the {@link Iterable} must be assigned
            // Ensure that replicas don't relocate if primaries are being throttled and primary first shard movement strategy is enabled
        /*
        }
                final float tmpDelta = deltas[i];
        }
        }
                    /*  we have an equal weight tie breaking:
import org.opensearch.cluster.metadata.Metadata;
        }
                        + "are being throttled. Skipping shard iteration"
         * 2 replica and 1 shard would look like:
                final BalancedShardsAllocator.ModelNode maxNode = modelNodes[highIdx];
                     * lets pick the next highest */
     */
import org.opensearch.common.collect.Tuple;
                    // when a replica cannot be allocated relies on this comparator.
                currentNodeWeightRanking,
                float currentDelta = absDelta(nodeWeight, currentWeight);
                    }
        final boolean explain = allocation.debugDecision();
     * average. To re-balance we need to move shards back eventually likely
                            logger.trace("No Node found to assign shard [{}]", shard);
                }
    @Override
                        }
                } else {
        }
                if (allocationDecision.type().higherThan(bestDecision)) {
            while (true) {
        int primaryLength = primary.length;
    private static boolean lessThan(float delta, float threshold) {
                        ++totalShardCount;
                    // did *not* receive a YES decision
import java.util.ArrayList;
                nodeExplanationMap.put(node.getNodeId(), new NodeAllocationResult(node.getRoutingNode().node(), currentDecision, 0));
            nodeDecisions.add(
                         * already know that lessThan(delta, threshold) == false and threshold defaults to 1.0, so by default we never
            if (sorter.modelNodes.length == inEligibleTargetNode.size()) {
        }
        return false;
        RoutingNode targetNode = null;
                            delta
            );
                // don't use canRebalance as we want hard filtering rules to apply. See #17698
                boolean deltaAboveThreshold = lessThan(currentDelta, threshold) == false;
        return ((float) metadata.index(index).getNumberOfShards()) / nodes.size();
            }
            for (ShardRouting shard : shardRoutings) {
                indices[j] = tmpIdx;
    private final Metadata metadata;
            if (currentNode != sourceNode) {
                        logger.trace(
                return Float.compare(deltas[j], pivotWeight);
            // move these nodes to the front of modelNodes so that we can only balance based on these nodes
        Decision.Type bestDecision = Decision.Type.NO;
        for (BalancedShardsAllocator.ModelNode currentNode : sorter.modelNodes) {
        ShardRouting[] primary = primaryList.toArray(new ShardRouting[0]);
            }
        );
                new NodeAllocationResult(
                    }
            }
                }
    private void balanceByWeights() {
                deltas[i] = deltas[j];
                     * now we go max to min since obviously we can't move anything to the max node
                );
                long shardSize = allocation.clusterInfo().getShardSize(shard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
     * to {@code 0.0}
    }
    /**
 * for local shards within the cluster.
                            "Balancing from node [{}] weight: [{}] to node [{}] weight: [{}]  delta: [{}]",
     * The actual balancing is delegated to {@link #balanceByWeights()}
                if (!explain) {
        Logger logger,
                }
                        if (logger.isTraceEnabled()) {
     * {@link ShardRoutingState#RELOCATING} since each relocating shard has
                    ++weightRanking
                        if (logger.isTraceEnabled()) {
import org.opensearch.cluster.routing.ShardMovementStrategy;
            @Override
        }
     * first value is the {@link Decision} taken to allocate the unassigned shard, the second value is the
                if (allocationDecision.getAllocationDecision() == AllocationDecision.YES) {
     *   2. If the shard is allowed to remain on its current node, no attempt will be made to move the shard and
    void balance() {
         * The arrays are sorted by primaries first and then by index and shard ID so a 2 indices with
                            allocation.routingTable()
 */
         * use the sorter to save some iterations.
                    shardRouting,
            nodes.put(rn.nodeId(), node);
                    }
                final Decision allocationDecision = deciders.canAllocate(shard, minNode.getRoutingNode(), allocation);
                        final int minNodeHigh = minNode.highestPrimary(shard.getIndexName());
    @Override
            secondaryLength = 0;
                return;
                            weights[highIdx],
        }
        BalancedShardsAllocator.ModelNode minNode = null;
            final int indexCmp;
package org.opensearch.cluster.routing.allocation.allocator;
     * Tries to find a relocation from the max node to the minimal node for an arbitrary shard of the given index on the
import org.opensearch.cluster.routing.RoutingNodes;
            }
         */
                        shard,
            logger.debug("skipping rebalance due to in-flight shard/store fetches");
                float proposedDelta = 2.0f + nodeWeight - currentWeight;
                             *
        return nodes.values().toArray(new BalancedShardsAllocator.ModelNode[0]);
     * to a node. This method will skip shards in the state
            }
            logger.trace("skipping rebalance as single node only");
         * we use 2 arrays and move replicas to the second array once we allocated an identical
            }
     * to the nodes we relocated them from.
                    minNode.addShard(shard.relocate(minNode.getNodeId(), shardSize));
         * iteration order is different for each run and makes testing hard */
        if (index != null) {
                        i++;
        if (shardLevelDecision.type() == Decision.Type.NO && explain == false) {
            .mapToInt(IndexMetadata::getNumberOfShards)
    @Override
     * is balanced moving three shards from two of the nodes over to the new node since it
            }
                    } else {
        int currentNodeWeightRanking = ++weightRanking;
                        allocation.snapshotShardSizeInfo(),
                             * (check shrinking the window from MAX to MIN)
                    allocation.changes()
                        while (i < primaryLength - 1 && comparator.compare(primary[i], primary[i + 1]) == 0) {
         */
        for (RoutingNode rn : routingNodes) {
            AllocationDecision allocationDecision = allocation.hasPendingAsyncFetch()
                            allocation.clusterInfo(),
        final boolean explain = allocation.debugDecision();
                    // This order is maintained because the logic that moves all replicas to unassigned
        return MoveDecision.cannotRemain(
     * 2 shard for each index. Now we add another node and the first index
                    AllocationDecision.fromDecisionType(result.v2().type()),
            .sum()) / routingNodes.size();
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        nodes = Collections.unmodifiableMap(buildModelFromAssigned());
                        }
        sorter.reset(shard.getIndexName());
                    }
            final Decision canAllocate = deciders.canAllocate(shard, node.getRoutingNode(), allocation);
        return nodes;
                    ? allocationDecision.getTargetNode().getId()
            }
        boolean ignoreThrottleInRestore,
                         * we could just find the place to insert linearly but the win might be minor
            }
        List<Tuple<String, Float>> nodeWeights = explain ? new ArrayList<>() : null;
    @Override
     * For each shard to be moved this function executes a move operation
     * shards only if the delta exceeds the threshold. In the default case
        if (nodes.size() < 2) { /* skip if we only have one node */
    private final RoutingNodes routingNodes;
                }
                final AllocateUnassignedDecision allocationDecision = decideAllocateUnassigned(shard);
            // If primary balance is preferred then prioritize moving primaries first
                    primariesThrottled = true;
     * optimally balanced cluster.  This method is invoked from the cluster allocation
        /* Don't iterate over an identity hashset here the
            checkAndAddInEligibleTargetNode(currentNode.getRoutingNode());
        }
                        assert allocationDecision.getAllocationStatus() == UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED;
        }
                logger.info(
     */
                ? AllocationDecision.NO
import java.util.List;
        final float[] weights = sorter.weights;
                // the gains make it worth it, as defined by the threshold
            // this comparator is more expensive than all the others up there
            nodeWeights.sort((nodeWeight1, nodeWeight2) -> Float.compare(nodeWeight1.v2(), nodeWeight2.v2()));
                            // no need to continue iterating
                    && shard.primary()
        return totalShardCount / nodes.size();
    private static final Comparator<ShardRouting> PRIMARY_FIRST = Comparator.comparing(ShardRouting::primary).reversed();
    void moveShards() {
                    modelNodes[relevantNodes] = modelNode;
            }
    private final boolean preferPrimaryRebalance;
                    if (!shard.primary()) {
        for (BalancedShardsAllocator.ModelNode currentNode : sorter.modelNodes) {
                if (!explain && inEligibleTargetNode.contains(target)) continue;
            final boolean betterWeightThanCurrent = nodeWeight <= currentWeight;
                // primary rebalance
                        logger.trace(
                    if (logger.isTraceEnabled()) {
                    "Cannot move any shard in the cluster due to cluster concurrent recoveries getting breached"
                return;
                final Decision decision = new Decision.Multi().add(allocationDecision).add(rebalanceDecision);
                advance_range: if (maxNode.numShards(index) > 0) {
            Tuple<BalancedShardsAllocator.ModelNode, Decision> nodeResult = Tuple.tuple(node, canAllocate);
    }
                // This is a safety net which prevents un-necessary primary shard relocations from maxNode to minNode when
                }
    private String[] buildWeightOrderedIndices() {
                maxNode.removeShard(shard);
            logger.trace("Staring allocation of [{}] unassigned shards", primaryLength);
                if (preferPrimaryBalance == true
                    }
                if (allocationDecision.type() == Decision.Type.NO) {
                    bestDecision = allocationDecision.type();
                            secondary[secondaryLength++] = primary[++i];
                                weights[highIdx],
                        // throttle decision scenario
            // Early terminate node interleaved shard iteration when no eligible target nodes are available
            Decision currentDecision = allocation.deciders().canAllocate(shard, node.getRoutingNode(), allocation);
                if (currentWeight == minWeight) {
    private boolean tryRelocateShard(BalancedShardsAllocator.ModelNode minNode, BalancedShardsAllocator.ModelNode maxNode, String idx) {
                return Float.compare(deltas[j], deltas[i]);
                    return o1.isSearchOnly() ? 1 : -1;
            // this is a comparison of the number of shards on this node to the number of shards
                         *
                    }
 *
                logger.info(
     * simulation model as well as on the cluster.
            }
        for (BalancedShardsAllocator.ModelNode node : modelNodes) {
     */
    ) {
                        inEligibleTargetNode.add(currentNode.getRoutingNode());
            );
                    unassigned.ignoreShard(shard, allocationDecision.getAllocationStatus(), allocation.changes());
            decision = Decision.NO;
                return o1.getId() - o2.getId();
import java.util.Comparator;
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        this.timedOutFunc = timedOutFunc;
                betterBalanceNodes.add(nodeResult);
            return;
                        unassigned.ignoreShard(primary[i], UnassignedInfo.AllocationStatus.NO_ATTEMPT, allocation.changes());
        return indices;
import java.util.Map;
            }
                indices[i] = indices[j];
                // don't use canRebalance as we want hard filtering rules to apply. See #17698
        sorter = newNodeSorter();
     *      {@link MoveDecision#getTargetNode} will return a non-null value, otherwise the assignedNodeId will be null.
            if (moveDecision.isDecisionTaken() && moveDecision.forceMove()) {
                : AllocationDecision.WORSE_BALANCE;
import java.util.Set;
                    if (logger.isTraceEnabled()) {
        this.ignoreThrottleInRestore = ignoreThrottleInRestore;
                final boolean updateMinNode;
                : AllocationDecision.fromDecisionType(canRebalance.type());
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
                    );
    /**
     */
        boolean preferPrimaryBalance,
     * {@link BalancedShardsAllocator.WeightFunction}. This weight is calculated per index to
        return AllocateUnassignedDecision.fromDecision(decision, minNode != null ? minNode.getRoutingNode().node() : null, nodeDecisions);
                    || deciders.canAllocate(indexMetadata, modelNode.getRoutingNode(), allocation).type() != Decision.Type.NO) {
            if (node == currentNode) {
        boolean preferPrimaryRebalance,
    }
            for (ShardRouting shard : rn) {
                targetNode.addShard(relocatingShards.v2());
            AllocationDecision nodeDecision = result.v2().type() == Decision.Type.NO
            // as well as shards per index)
                    // swap nodes at position i and relevantNodes
            logger.trace("Start balancing cluster");
                }
                    return false;
        }
    private final RoutingAllocation allocation;
        }
                         */
                     *  primaries are added first and we only add one shard set a time in this algorithm.
                        }
 * The OpenSearch Contributors require contributions made to
                    || (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG) && isPartialShard(shard, allocation)))
                continue;
     * process. In short, this method recreates the status-quo in the cluster.
            int weightRanking = 0;
            }
        for (BalancedShardsAllocator.ModelNode node : modelNodes) {
                sameBalanceNodes.add(nodeResult);
     * with 3 primary and 1 replica shards. At the first stage all three nodes hold
        }
        final String[] indices = localIndices.toArray(new String[0]);
            // that's why it's added last even though it could be easier to read
                }
            // Verify if the shard is allowed to move if outgoing recovery on the node hosting the primary shard
        if (shard.assignedToNode()) {
            // indices all shards of the same index is treated equally.
     * Makes a decision on whether to move a started shard to another node.  The following rules apply
    }
            return MoveDecision.rebalance(
        final float currentWeight = weight.weightWithRebalanceConstraints(this, currentNode, idxName);
                    shard = routingNodes.initializeShard(shard, minNode.getNodeId(), null, shardSize, allocation.changes());
                         */
     * Balances the nodes on the cluster model according to the weight
import org.apache.lucene.util.ArrayUtil;
                        /*
        List<Tuple<BalancedShardsAllocator.ModelNode, Decision>> sameBalanceNodes = new ArrayList<>();
        // Trying to eliminate target nodes so that we do not unnecessarily iterate over source nodes
                     *  1. if one decision is YES prefer it
        for (Tuple<BalancedShardsAllocator.ModelNode, Decision> result : sameBalanceNodes) {
        List<ShardRouting> primaryList = new ArrayList<>();
                return;
        for (String index : allocation.routingTable().indicesRouting().keySet().toArray(new String[0])) {
        BalancedShardsAllocator.ModelNode[] modelNodes = sorter.modelNodes;
                        lowIdx = 0;
import org.opensearch.cluster.routing.ShardRoutingState;
                    }
                             * the low index to shrink the window we are considering for balance from the other direction.
            canRemain,
            final AllocationDeciders deciders = allocation.deciders();
                    highIdx--;
                        sorter.sort(0, relevantNodes);
    /**
                     * index on this node of allocation deciders prevent any relocation.*/
            logger.trace("skipping rebalance as it is disabled");
            // assigned to, then there is no way moving the shard to the node with the worse weight
        this.weight = weight;
         * TODO: We could be smarter here and group the shards by index and then
        for (Tuple<BalancedShardsAllocator.ModelNode, Decision> result : betterBalanceNodes) {
                     *    1 2 0
            logger.trace("Start allocating unassigned shards");
                    if (delta <= 1.0f) {
     */
            }
                        final long shardSize = DiskThresholdDecider.getExpectedShardSize(
                ++totalShardCount;
        } else {
import org.opensearch.cluster.metadata.IndexMetadata;
                );
        int weightRanking = 0;
    /**
                RoutingNode target = currentNode.getRoutingNode();
                    final long shardSize = DiskThresholdDecider.getExpectedShardSize(
     * returned sorter is not sorted. Use {@link BalancedShardsAllocator.NodeSorter#reset(String)}
        boolean primariesThrottled = false;
        }
    }
                // break if the time allocated to the balanced shards allocator has elapsed
        } while (primaryLength > 0);
                }
            }
        return new BalancedShardsAllocator.NodeSorter(nodesArray(), weight, this);
                boolean betterWeightWithShardAdded = proposedDelta < currentDelta;
        final PriorityComparator secondaryComparator = PriorityComparator.getAllocationComparator(allocation);
    @Override
         */
                continue;
                    decision = currentDecision;
                        allocation.routingTable()
        final String idxName = shard.getIndexName();
            && !(FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG) && isPartialShard(shardRouting, allocation)));
    /**
                    assert decision.type() == Decision.Type.THROTTLE;
                && shard.primary();
                    } else {
                    break;
    private final boolean preferPrimaryBalance;
        RoutingAllocation allocation,
    private BalancedShardsAllocator.NodeSorter newNodeSorter() {
            nodeDecisions.add(new NodeAllocationResult(result.v1().getRoutingNode().node(), nodeDecision, result.v2(), ++weightRanking));
            if (betterWeightThanCurrent) {
                if (modelNode.getIndex(index) != null
                Decision allocationDecision = allocation.deciders().canAllocate(shardRouting, target, allocation);
                        updateMinNode = ((((nodeHigh > repId && minNodeHigh > repId) || (nodeHigh < repId && minNodeHigh < repId))
        }
                    ++totalShardCount;
                final BalancedShardsAllocator.ModelNode targetNode = nodes.get(moveDecision.getTargetNode().getId());
        this.metadata = allocation.metadata();
                        );
            return;
        balanceByWeights();
                    final float delta = absDelta(weights[lowIdx], weights[highIdx]);
     * See {@link BalancedShardsAllocator#THRESHOLD_SETTING} for defining the threshold.
     * to the minimal eligible node with respect to the
         * the sorter holds the minimum weight node first for the shards index.
import java.util.function.Supplier;
     * Move started shards that can not be allocated to a node anymore
        new IntroSorter() {
        assert !nodes.isEmpty();
                currentNode = node;
     * state. For example this can happen if we have 3 nodes and 3 indices
     * @param shardRouting the shard to be checked
 *
                // If both are primary or both are non-primary, compare by ID
 * A {@link LocalShardsBalancer} used by the {@link BalancedShardsAllocator} to perform allocation operations
import org.apache.lucene.util.IntroSorter;
        logger.trace("No shards of [{}] can relocate from [{}] to [{}]", idx, maxNode.getNodeId(), minNode.getNodeId());
                        "Cannot balance any shard in the cluster as time allocated to balanced shards allocator has elapsed"
        if (explain) {
                        continue;
            nodeDecisions.add(
            /*
                // with the shard remaining on the current node, and we are allowed to allocate to the
                // if the simulated weight delta with the shard moved away is better than the weight delta
                    continue;
                // If one is primary and the other isn't, primary comes first
                    }
                continue; // skip over node we're currently allocated to
                }
    public LocalShardsBalancer(
             * we might end up with unnecessary rebalance operations which can be super confusion/frustrating
        this.logger = logger;
                         * balance if we only achieve the same delta the relocation is useless
            // find nodes that have a shard of this index or where shards of this index are allowed to be allocated to,
        if (nodeLevelAllocationDecision.type() != Decision.Type.YES) {
            return MoveDecision.NOT_TAKEN;
                ShardRouting shard = primary[i];
    /**
    @Override
                    /* only allocate on the cluster if we are not throttled */
            return MoveDecision.NOT_TAKEN;
     * has no shards yet and global balance for the node is way below
     * {@link BalancedShardsAllocator.ModelNode} representing the node that the shard should be assigned to.  If the decision returned
            if ((indexCmp = o1.getIndexName().compareTo(o2.getIndexName())) == 0) {
                    minNode.addShard(routingNodes.relocateShard(shard, minNode.getNodeId(), shardSize, allocation.changes()).v1());
                     * and see if the threshold still holds. We either don't have any shard of this
            protected int comparePivot(int j) {
     * This builds a initial index ordering where the indices are returned
        float minWeight = Float.POSITIVE_INFINITY;
    }
        return avgPrimaryShardsPerNode;
     */
                if (updateMinNode) {
     *   3. If the shard is not allowed to remain on its current node, then {@link MoveDecision#getAllocationDecision()} will be
            // if the node we are examining has a worse (higher) weight than the node the shard is
           to prevent floating point problems if the delta is very close to the
        final AllocationDeciders deciders = allocation.deciders();
 * @opensearch.internal
                        + ". Skipping shard iteration"
                // doing such relocation wouldn't help in primary balance. The condition won't be applicable when we enable node level
                             * See #3580
    /**
                            maxNode.getNodeId(),
                // checks if the weight delta is above a certain threshold; if it is not above a certain threshold,
                            logger.trace(
                        );
         * if we allocate for instance (0, R, IDX1) we move the second replica to the secondary array and proceed with
    /**
            int relevantNodes = 0;
                // TODO maybe we can respect throttling here too?
     * is of type {@link Decision.Type#NO}, then the assigned node will be null.
                     * we can't move from any shard from the min node lets move on to the next node
import java.util.stream.Stream;
        List<NodeAllocationResult> nodeDecisions = new ArrayList<>(modelNodes.length - 1);
            final Iterable<ShardRouting> shardRoutings = routingStream::iterator;
        }
        if (logger.isTraceEnabled()) {
            if (currentWeight > minWeight && explain == false) {
        if (canRebalance.type() != Decision.Type.YES || allocation.hasPendingAsyncFetch()) {
                --totalShardCount;
     * Returns the average of shards per node for the given index
        List<NodeAllocationResult> nodeDecisions = null;
            sorter.reset(indices[i]);
                    /* allocate on the model even if throttled */
            return MoveDecision.cannotRebalance(canRebalance, allocationDecision, currentNodeWeightRanking, nodeDecisions);
                // Relax the above condition to per node to allow rebalancing to attain global balance
    @Override
            // Verify if the cluster concurrent recoveries have been reached.
                nodeDecisions
                    assignedNode = node;
                            allocationDecision.getAllocationStatus()
                // calculate the delta of the weights of the two nodes if we were to add the shard to the
             * see https://github.com/elastic/elasticsearch/issues/14387
        /*
                            allocation.metadata(),
                        logger.trace("Assigned shard [{}] to [{}]", shard, minNode.getNodeId());
     * balance model. Iff this method returns a <code>true</code> the relocation has already been executed on the
        ArrayUtil.timSort(primary, comparator);
                        logger.trace(
                final BalancedShardsAllocator.ModelNode minNode = modelNodes[lowIdx];
 */
     * <p>
            // Terminate if the time allocated to the balanced shards allocator has elapsed
                            "No eligible node found to assign shard [{}] allocation_status [{}]",
    /**
     * current weight with respect to the index passed to the sorter. The
        Map<String, BalancedShardsAllocator.ModelNode> nodes = new HashMap<>();
    @Override
        }
import java.util.HashSet;
                    result.v2(),
    private final Logger logger;
    }
            if (allocation.deciders().canMoveAnyShard(allocation).type() != Decision.Type.YES) {
     * Checks if target node is ineligible and if so, adds to the list
            if (preferPrimaryBalance == true) {
                    // Ensures that a failed replica allocation does not block the allocation of a search replica.
                );
                NodeAllocationResult current = nodeExplanationMap.get(nodeWeight.v1());
                    nodeExplanationMap.add(
        Decision canRebalance = allocation.deciders().canRebalance(shard, allocation);
                }
            AllocationDecision.fromDecisionType(bestDecision),
    /**
public class LocalShardsBalancer extends ShardsBalancer {
                        break;
    private int totalShardCount = 0;
                && shard.recoverySource().getType() == RecoverySource.Type.REMOTE_STORE
                        if (explain == false) {
import java.util.Iterator;
    /**
                            && (absDelta(weights[0], weights[highIdx - 1]) > threshold) // check if we need to break at all
                assert rn.nodeId().equals(shard.currentNodeId());
    }
/**
        ShardRouting[] secondary = new ShardRouting[primary.length];
        }
                primaryList.add(shard);
                break;
                logger.info(
        if (shard.started() == false) {
                    if (bestDecision == Decision.Type.YES) {
        this.shardMovementStrategy = shardMovementStrategy;
             * since once the fetches come back we might just move all the shards back again.
import org.opensearch.cluster.routing.UnassignedInfo;
import org.opensearch.gateway.PriorityComparator;
                    continue;
            if (RoutingPool.LOCAL_ONLY.equals(RoutingPool.getShardPool(shard, allocation))) {
import java.util.HashMap;
        Decision shardLevelDecision = allocation.deciders().canAllocate(shard, allocation);
        return Math.abs(higher - lower);
                assignedNode != null ? assignedNode.getRoutingNode().node() : null,
     * Checks if the shard can be skipped from the local shard balancer operations
                    : null;
        for (Tuple<BalancedShardsAllocator.ModelNode, Decision> result : worseBalanceNodes) {
            // can make the balance of the cluster better, so we check for that here
            if (RoutingPool.LOCAL_ONLY.equals(RoutingPool.getIndexPool(metadata.index(index)))) {
    private final Supplier<Boolean> timedOutFunc;
        }
            // For REMOTE_STORE recoveries, THROTTLE is as good as NO as we want faster recoveries
     */
            float currentWeight = weight.weightWithAllocationConstraints(this, node, shard.getIndexName());
     * Returns an array view on the nodes in the balancer. Nodes should not be removed from this list.
        }
                                "Stop balancing index [{}]  min_node [{}] weight: [{}]" + "  max_node [{}] weight: [{}]  delta: [{}]",
                        );
                continue;
        this.allocation = allocation;
            BalancedShardsAllocator.ModelNode node = new BalancedShardsAllocator.ModelNode(rn);
     */
            return;
                // hence we add 2.0f to the weight delta
                    /* Shrinking the window from MIN to MAX
     * Returns the global average of shards per node
            for (Tuple<String, Float> nodeWeight : nodeWeights) {
                }
        avgPrimaryShardsPerNode = (float) (StreamSupport.stream(metadata.spliterator(), false)
                final BalancedShardsAllocator.ModelNode minNode = assignedNodeId != null ? nodes.get(assignedNodeId) : null;
                     *  for the 3 shards 2 replica case we try to build up:
                AllocationDecision.fromDecisionType(rebalanceDecisionType),
            if (canMoveAwayDecision.type() != Decision.Type.YES) {
                    ++totalShardCount;
 * SPDX-License-Identifier: Apache-2.0
        if (canShardBeSkipped(shardRouting)) {
    }
     */
                            minNode.getNodeId(),
        final String currentNodeId = shard.currentNodeId();
        if (logger.isTraceEnabled()) {
                         * TODO we could be a bit smarter here, we don't need to fully sort necessarily
                    result.v1().getRoutingNode().node(),
                        }
import org.opensearch.cluster.routing.RoutingNode;
                    }
             * if we allow rebalance operations while we are still fetching shard store data
        if (shardRouting.started() == false) {
                if (decision.type() == Decision.Type.YES) {
     * Makes a decision about moving a single shard to a different node to form a more
            if (o1.primary() ^ o2.primary()) {
                logger.info(
                }
        Supplier<Boolean> timedOutFunc
        float threshold,
     * to the {@link MoveDecision} return object:
        }
             * Therefore we only do a rebalance if we have fetched all information.
                            && (nodeHigh < minNodeHigh)) || (nodeHigh > repId && minNodeHigh < repId));
                logger.info(
                    && shard.state() != RELOCATING) {
     */
                    while (i < primaryLength) {
        // offloading the shards.
    }
                    logger.info(
                );
                pivotWeight = deltas[i];
                    );
                            allocation.snapshotShardSizeInfo(),
    private BalancedShardsAllocator.ModelNode[] nodesArray() {
    @Override
        // clear everything we have either added it or moved to ignoreUnassigned
                        allocation.metadata(),
     */
import org.opensearch.common.util.FeatureFlags;
                                weights[lowIdx],
        Map<String, NodeAllocationResult> nodeExplanationMap = explain ? new HashMap<>() : null;
                        while (i < primaryLength - 1 && comparator.compare(primary[i], primary[i + 1]) == 0) {
                     */
    /**
            } else {
            // we only make decisions for unassigned shards here
        assert sourceNode != null && sourceNode.containsShard(shardRouting);
            int lowIdx = 0;
    }
            ShardRouting shardRouting = it.next();
            return MoveDecision.NOT_TAKEN;
         * This is not guaranteed to be balanced after this operation we still try best effort to
                worseBalanceNodes.add(nodeResult);
    /**
                    "Cannot move any shard in the cluster as there is no node on which shards can be allocated"
            AllocationDecision nodeDecision = result.v2().type() == Decision.Type.NO
                .filter(maxNode::containsShard) // check shards which are present on heaviest node
            if (rebalanceConditionsMet) {
    public float avgShardsPerNode(String index) {
                rebalanceConditionsMet = deltaAboveThreshold && betterWeightWithShardAdded;
                    // rebalance to the node, only will get overwritten if the decision here is to
                        allocation.clusterInfo(),
            // moving the shard would not improve the balance, and we are not in explain mode, so short circuit
        ShardMovementStrategy shardMovementStrategy,
            }
                }
                );
                return;
                /* we skip relocating shards here since we expect an initializing shard with the same id coming in */
                sourceNode.removeShard(shardRouting);
            @Override
            }
                            "Couldn't find shard to relocate from node [{}] to node [{}]",
     * weight function. If a shard is moved the shard will be set to
                        if (lowIdx > 0
            float pivotWeight;
        // shard movements, the goal of this iteration order is to achieve a fairer movement of shards from the nodes that are
                    ++totalShardCount;
     */
                }
                if (shardRouting.primary() && canMoveAwayDecision.type() == Decision.Type.THROTTLE) {
                                minNode.getNodeId(),
     * Returns {@code true} iff the weight delta between two nodes is under a defined threshold.
                    return;
                if (preferPrimaryRebalance == true && shard.primary() && maxNode.numPrimaryShards() - minNode.numPrimaryShards() < 2) {
        if (allocation.deciders().canRebalance(allocation).type() != Decision.Type.YES) {
    /**
import org.apache.logging.log4j.Logger;
                    if (logger.isTraceEnabled()) {
            }
                Tuple<ShardRouting, ShardRouting> relocatingShards = routingNodes.relocateShard(
                            minNode.getNodeId()
            // NO decision for allocating the shard, irrespective of any particular node, so exit early
            }
                        "Ignoring [{}] unassigned shards for allocation as time allocated to balanced shards allocator has elapsed",
        Decision nodeLevelAllocationDecision = allocation.deciders().canAllocateAnyShardToNode(targetNode, allocation);
                            unassigned.ignoreShard(primary[++i], allocationDecision.getAllocationStatus(), allocation.changes());
                     *    0 1 2
                             * less nodes than another zone. so one zone is horribly overloaded from a balanced perspective but we
                if (rebalanceConditionsMet && canAllocate.type().higherThan(rebalanceDecisionType)) {
                            // we are not in explain mode and already have a YES decision on the best weighted node,
    }
                        + ". Skipping indices iteration"
            final MoveDecision moveDecision = decideMove(shardRouting);
            if (node.containsShard(shard) && explain == false) {
                                index,
                if (explain) {
            ShardRouting[] tmp = primary;
                         * prevent relocations that only swap the weights of the two nodes. a relocation must bring us closer to the
    /**
     * {@link ShardRoutingState#RELOCATING} and a shadow instance of this
                            maxNode.getNodeId(),
                if (lowIdx < highIdx - 1) {
            }
            return secondary == 0 ? indexCmp : secondary;
                        final int repId = shard.id();
                        ) {
            }
                    return true;
        // find currently assigned node
                || (currentDecision.type() == Decision.Type.THROTTLE && considerThrottleAsNo == false)) {
                     *  2. prefer the node that holds the primary for this index with the next id in the ring ie.
     * of ineligible target nodes
     * {@link ShardRoutingState#INITIALIZING}.
                    // If we cannot allocate any shard to node marking it in eligible
                    // THROTTLE and we get a decision with YES on another node
     * shard is created with an incremented version in the state
                        new NodeAllocationResult(currentNode.getRoutingNode().node(), allocationDecision, ++weightRanking)
            boolean rebalanceConditionsMet = false;
     * on the target node which we respect during the allocation / balancing
                    );
        if (canRemain.type() != Decision.Type.NO) {
    /**
                    /* Shrinking the window from MAX to MIN
            // weight of this index currently on the node
                     *  than the id of the shard we need to assign. This works find when new indices are created since
    public float avgPrimaryShardsPerNode() {
                ? AllocationDecision.AWAITING_INFO
            // that should be on each node on average (both taking the cluster as a whole into account
        RoutingNode routingNode = sourceNode.getRoutingNode();
            } else if (moveDecision.isDecisionTaken() && moveDecision.canRemain() == false) {
            Decision canMoveAwayDecision = allocation.deciders().canMoveAway(shardRouting, allocation);
                }
         * the next replica. If we could not find a node to allocate (0,R,IDX1) we move all it's replicas to ignoreUnassigned.
                continue;
                nodeDecisions.add(new NodeAllocationResult(current.getNode(), current.getCanAllocateDecision(), ++weightRanking));
                        );
                    minWeight = currentWeight;
        Decision decision = null;
            // Terminate if the time allocated to the balanced shards allocator has elapsed
                return o1.primary() ? -1 : 1;
                        weights[highIdx] = sorter.weight(modelNodes[highIdx]);
     * Make a decision for allocating an unassigned shard.  This method returns a two values in a tuple: the
     */
            }
                return;
                // Verifying if this node can be considered ineligible for further iterations
                if (logger.isDebugEnabled()) logger.debug("Cannot move away shard [{}] Skipping this shard", shardRouting);
     * distribute shards evenly per index. The balancer tries to relocate
        BalancedShardsAllocator.ModelNode assignedNode = null;
                             * can't move to the "lighter" shards since otherwise the zone would go over capacity.
            int highIdx = relevantNodes - 1;
    /**
        };
            nodeExplanationMap
    public float avgPrimaryShardsPerNode(String index) {
            }
                }
                // get the delta between the weights of the node we are checking and the node that holds the shard
                    "Cannot move any shard in the cluster as time allocated to balanced shards allocator has elapsed"
            }
                         * NB this comment above was preserved from an earlier version but doesn't obviously describe the code today. We
        List<Tuple<BalancedShardsAllocator.ModelNode, Decision>> betterBalanceNodes = new ArrayList<>();
                if ((RoutingPool.LOCAL_ONLY.equals(RoutingPool.getShardPool(shard, allocation))
        /* find an node with minimal weight we can allocate on*/
        }
        for (int i = 0; i < deltas.length; i++) {
            }
            return;
                deltas[j] = tmpDelta;
                final BalancedShardsAllocator.ModelNode sourceNode = nodes.get(shardRouting.currentNodeId());
            sorter.reset(index, 0, relevantNodes);
     *      {@link MoveDecision#getNodeDecisions} will have a non-null value.
            primary = secondary;
        final BalancedShardsAllocator.ModelIndex index = maxNode.getIndex(idx);
     *      populated with the decision of moving to another node.  If {@link MoveDecision#forceMove()} ()} returns {@code true}, then
                    logger.trace("Moved shard [{}] to node [{}]", shardRouting, targetNode.getRoutingNode());
                    allocation.clusterInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
                    "Cannot balance any shard in the cluster as time allocated to balanced shards allocator has elapsed"
                )
                     *    2 0 1
        if (logger.isTraceEnabled()) {
        }
                        updateMinNode = currentDecision.type() == Decision.Type.YES;
    private final Map<String, BalancedShardsAllocator.ModelNode> nodes;
        }
        if (unassigned.isEmpty()) {
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        }
    AllocateUnassignedDecision decideAllocateUnassigned(final ShardRouting shard) {
     */
                } else if (lowIdx > 0) {
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;
        return (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shardRouting, allocation))
            protected void swap(int i, int j) {
                    logger.debug("Relocate [{}] from [{}] to [{}]", shard, maxNode.getNodeId(), minNode.getNodeId());
                        + ". Skipping shard iteration"
            if ((shardMovementStrategy == ShardMovementStrategy.PRIMARY_FIRST) && primariesThrottled && !shardRouting.primary()) {
                    }
import org.opensearch.cluster.routing.allocation.MoveDecision;
                routingStream = routingStream.sorted(PRIMARY_FIRST);
                        continue;
            for (int i = 0; i < modelNodes.length; i++) {
        int secondaryLength = 0;
                : AllocationDecision.WORSE_BALANCE;
                    checkAndAddInEligibleTargetNode(targetNode.getRoutingNode());
     *   4. If the method is invoked in explain mode (e.g. from the cluster allocation explain APIs), then
        RoutingNodes.UnassignedShards unassigned = routingNodes.unassigned();
/*
        return delta <= (threshold + 0.001f);
        }
                ? AllocationDecision.NO
     * Builds the internal model from all shards in the given
                         * hit this case anyway.
            return MoveDecision.stay(canRemain);
                // then even though the node we are examining has a better weight and may make the cluster balance
    }
        // Iterate over the started shards interleaving between nodes, and check if they can remain. In the presence of throttling
        final Comparator<ShardRouting> comparator = (o1, o2) -> {
            );
            }
            }
             */
        final List<String> localIndices = new ArrayList<>();
            return AllocateUnassignedDecision.no(UnassignedInfo.AllocationStatus.DECIDERS_NO, null);
           threshold ie. 1.000000002 which can trigger unnecessary balance actions*/
     */
        this.threshold = threshold;
            }
     */
    @Override
    }
    }
                        // copy over the same replica shards to the secondary array so they will get allocated
                    } else if (tryRelocateShard(minNode, maxNode, index)) {
                BalancedShardsAllocator.ModelNode modelNode = modelNodes[i];
                    logger.debug("Simulate relocation of [{}] from [{}] to [{}]", shard, maxNode.getNodeId(), minNode.getNodeId());
        Decision.Type rebalanceDecisionType = Decision.Type.NO;
                if (timedOutFunc != null && timedOutFunc.get()) {
        }
     * weight of the maximum node and the minimum node according to the
            if (currentDecision.type() == Decision.Type.YES
            if (relevantNodes < 2) {
                new NodeAllocationResult(result.v1().getRoutingNode().node(), nodeDecision, result.v2(), currentNodeWeightRanking)
    }
        if (decision == null) {
            if (timedOutFunc != null && timedOutFunc.get()) {
    }
                        (primaryLength - i)
    public float avgShardsPerNode() {
        BalancedShardsAllocator.WeightFunction weight,
                            shard,
            }
                } else {
                if (rebalanceDecision.type() == Decision.Type.NO) {
            if (canShardBeSkipped(shardRouting)) {
            IndexMetadata indexMetadata = metadata.index(index);
import java.util.Collections;
            // the current weight of the node in the cluster, as computed by the weight function;
                    }
                    }
                            && highIdx - 1 > 0 // is there a chance for a higher delta?
        if (allocation.hasPendingAsyncFetch()) {
                    lowIdx = 0;
                            shard,
     * in most unbalanced first. We need this in order to prevent over
     * with respect to the weight function. All given shards must be unassigned.
    }
                    );
        }
                }
        Decision canRemain = allocation.deciders().canRemain(shardRouting, routingNode, allocation);
                    relevantNodes++;
    private final BalancedShardsAllocator.NodeSorter sorter;
                        final int nodeHigh = node.highestPrimary(shard.index().getName());
         * We now walk through the nodes until we find a node to allocate the shard.
        if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation))) {
                nodeWeights.add(Tuple.tuple(node.getNodeId(), currentWeight));
                .filter(ShardRouting::started) // cannot rebalance unassigned, initializing or relocating shards anyway
        final List<NodeAllocationResult> nodeExplanationMap = explain ? new ArrayList<>() : null;
        }.sort(0, deltas.length);
                         * compared to the added complexity
                        }
     * the threshold is set to {@code 1.0} to enforce gaining relocation
                        ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE,
                }
                        logger.trace("Assigned shard [{}] to node [{}]", shard, node.getNodeId());
        BalancedShardsAllocator.ModelNode currentNode = null;
                    continue;
            // we can only rebalance started shards
    private final boolean ignoreThrottleInRestore;
        this.routingNodes = allocation.routingNodes();
            boolean considerThrottleAsNo = ignoreThrottleInRestore
    }
     * function. The configured threshold is the minimum delta between the
            if (node.getNodeId().equals(currentNodeId)) {
        for (String index : buildWeightOrderedIndices()) {
                            weights[lowIdx],
        List<Tuple<BalancedShardsAllocator.ModelNode, Decision>> worseBalanceNodes = new ArrayList<>();
                } else {
        for (ShardRouting shard : unassigned.drain()) {
     * a shadow shard in the state {@link ShardRoutingState#INITIALIZING}
     */
                                maxNode.getNodeId(),
                        }
                    logger.info(
            for (int i = 0; i < primaryLength; i++) {
                            break advance_range;
                }
         * allocate on the minimal eligible node.
                    "Cannot move any replica shard in the cluster as movePrimaryFirst is enabled and primary shards"
            // we can only move started shards
        for (BalancedShardsAllocator.ModelNode node : nodes.values()) {
                canRebalance,
            final float nodeWeight = weight.weightWithRebalanceConstraints(this, node, idxName);
        assert higher >= lower : higher + " lt " + lower + " but was expected to be gte";
            @Override
                    updateMinNode = currentWeight < minWeight;
                if (o1.isSearchOnly() ^ o2.isSearchOnly()) {
     * explain API only.
            nodeDecisions = new ArrayList<>();
                    if (lessThan(delta, threshold)) {
        return ((float) metadata.index(index).getTotalNumberOfShards()) / nodes.size();
     * Allocates all given shards on the minimal eligible node for the shards index
        for (Iterator<ShardRouting> it = allocation.routingNodes().nodeInterleavedShardIterator(shardMovementStrategy); it.hasNext();) {
     * Balances the nodes on the cluster model according to the weight function.
                continue;
                            /* This is a special case if allocations from the "heaviest" to the "lighter" nodes is not possible
                --totalShardCount;
                        highIdx = relevantNodes - 1;
        /*
    private final float threshold;
                    && preferPrimaryRebalance == false
                        weights[lowIdx] = sorter.weight(modelNodes[lowIdx]);
        sorter.reset(shardRouting.getIndexName());
                logger.trace("[{}][{}] can't move", shardRouting.index(), shardRouting.id());
                    if (nodeLevelAllocationDecision.type() != Decision.Type.YES) {
                                delta
                routingNodes.unassigned().add(shard);
                    if (currentDecision.type() == decision.type()) {
                }
                final Decision rebalanceDecision = deciders.canRebalance(shard, allocation);
                // node in question, then allow the rebalance
            primaryLength = secondaryLength;
    }
            inEligibleTargetNode.add(targetNode);
        }
import org.opensearch.cluster.routing.RecoverySource;
                    if (!shard.primary()) { // we could not allocate it and we are a replica - check if we can ignore the other replicas
        final AllocationDeciders deciders = allocation.deciders();
                        targetNode = target;
        int weightRanking = 0;
            secondary = tmp;
            if (timedOutFunc != null && timedOutFunc.get()) {
    /**
    void allocateUnassigned() {
        }
    MoveDecision decideRebalance(final ShardRouting shard) {
                     *  such that if we need to tie-break we try to prefer the node holding a shard with the minimal id greater
     * allocations on added nodes from one index when the weight parameters
        inEligibleTargetNode = new HashSet<>();
            // The side effect of this are increased relocations post these allocations.
                }
            if (explain) {
     * Returns a new {@link BalancedShardsAllocator.NodeSorter} that sorts the nodes based on their
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
                    ++totalShardCount;
                    node.addShard(shard);
import org.opensearch.cluster.routing.ShardRouting;
                    minNode = node;
                // node in question and move it away from the node that currently holds it.
}
            return AllocateUnassignedDecision.NOT_TAKEN;
        /* deltas close to the threshold are "rounded" to the threshold manually
    private static float absDelta(float lower, float higher) {
            }
                    }
     * for global balance overrule the index balance at an intermediate
            return MoveDecision.NOT_TAKEN;
     * The absolute value difference between two weights.
        }
 * this file be licensed under the Apache-2.0 license or a
            } else if (betterWeightThanCurrent) {
        final BalancedShardsAllocator.ModelNode[] modelNodes = sorter.modelNodes;
                    return;
            Stream<ShardRouting> routingStream = StreamSupport.stream(index.spliterator(), false)
                    targetNode.getNodeId(),
                    rebalanceDecisionType = canAllocate.type();
        assert currentNode != null : "currently assigned node could not be found";
                             * This break jumps straight to the condition below were we start moving from the high index towards
    private final BalancedShardsAllocator.WeightFunction weight;
    private final Set<RoutingNode> inEligibleTargetNode;
                    modelNodes[i] = modelNodes[relevantNodes];
                            ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE,
                if (timedOutFunc != null && timedOutFunc.get()) {
    private static final Comparator<ShardRouting> BY_DESCENDING_SHARD_ID = Comparator.comparing(ShardRouting::shardId).reversed();
import org.opensearch.cluster.routing.allocation.decider.Decision;
    MoveDecision decideMove(final ShardRouting shardRouting) {
                        // in a subsequent iteration, allowing replicas of other shards to be allocated first
         * replica in the current iteration to make sure all indices get allocated in the same manner.
                             */
        final float[] deltas = new float[indices.length];
    private void checkAndAddInEligibleTargetNode(RoutingNode targetNode) {
                    // TODO - maybe check if we can allow wait for active shards thingy bypass this condition
            }
            @Override
                            + ". Skipping relevant nodes iteration"
                } else {
                    minNode.addShard(shard);
                        /*
        this.preferPrimaryBalance = preferPrimaryBalance;
    }
                if (targetNode != null) {
            protected int compare(int i, int j) {
            }
                    lowIdx++;
            // if we'd apply it earlier. this comparator will only differentiate across
                            break;
import static org.opensearch.action.admin.indices.tiering.TieringUtils.isPartialShard;
        }
     *   1. If the shard is not started, no decision will be taken and {@link MoveDecision#isDecisionTaken()} will return false.
            // fill in the correct weight ranking, once we've been through all nodes
                // more even, it doesn't make sense to execute the heavyweight operation of relocating a shard unless
    private Map<String, BalancedShardsAllocator.ModelNode> buildModelFromAssigned() {
                final String assignedNodeId = allocationDecision.getTargetNode() != null
                final String tmpIdx = indices[i];
                localIndices.add(index);
     *      {@link MoveDecision#getCanRemainDecision} will have a decision type of YES.  All other fields in the object will be null.
                    && maxNode.numPrimaryShards(shard.getIndexName()) - minNode.numPrimaryShards(shard.getIndexName()) < 2) {
            protected void setPivot(int i) {
                    // Orders replicas first, followed by search replicas (e.g., R1, R1, S1, S1).
            final int secondary = secondaryComparator.compare(o1, o2);
            targetNode != null ? targetNode.node() : null,
        do {
import org.opensearch.cluster.routing.RoutingPool;
     * to sort based on an index.
        // when no target is eligible
                    if (minNode != null) {
        this.preferPrimaryRebalance = preferPrimaryRebalance;
                    Decision nodeLevelAllocationDecision = allocation.deciders().canAllocateAnyShardToNode(target, allocation);
                        minNode.addShard(shard.initialize(minNode.getNodeId(), null, shardSize));
            // is not being throttled.
        // balance the shard, if a better node can be found
            }
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                if (logger.isTraceEnabled()) {
     * only, or in other words relocations that move the weight delta closer
     */
                             * due to some allocation decider restrictions like zone awareness. if one zone has for instance
                        + ". Skipping shard iteration"
                    /* we are done here, we either can't relocate anymore or we are balanced */
            logger.trace("Try relocating shard of [{}] from [{}] to [{}]", idx, maxNode.getNodeId(), minNode.getNodeId());
            deltas[i] = sorter.delta();
