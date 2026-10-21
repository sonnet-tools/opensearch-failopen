            return shards.contains(shard);
     */
            highestPrimary = -1;
                followUpRerouteTaskPriority,
            float threshold,
    }
    public BalancedShardsAllocator(Settings settings) {
 * this work for additional information regarding copyright
    }
import org.apache.logging.log4j.LogManager;
        }
    }
        timeValue -> {
            ShardMovementStrategy shardMovementStrategy,
import java.util.Collections;
    @Inject
        public void reset(String index, int from, int to) {
        Property.NodeScope
        }
        return weightFunction.indexBalance;
            numShards++;
        Property.NodeScope
            final float shardBalance = (Float) settings.get(SHARD_BALANCE_FACTOR_SETTING);
    static class WeightFunction {
            failAllocationOfNewPrimaries(allocation);
        private String index;
        public float weight(ModelNode node) {
            }
            reset(index, 0, modelNodes.length);
 */
        "cluster.routing.allocation.balance.index",
        public String getIndexId() {
import org.opensearch.common.settings.Setting.Property;
                );
                        unassignedInfo.getFailedNodeIds()
    public BalancedShardsAllocator(Settings settings, ClusterSettings clusterSettings) {
            case NORMAL:
                    r -> logger.trace("reroute after balanced shards allocator timed out completed"),
                index = new ModelIndex(shard.getIndexName());
            updateAllocationConstraint(INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID, true);
        protected void swap(int i, int j) {
        Property.NodeScope
            return sb.toString();
            }
                assert primaryShards.contains(shard) : "Primary shard not allocated on current node: " + shard;
            assert shards.contains(shard) == false : "Shard already allocated on current node: " + shard;
     */
            float balancerWeight = weight(balancer, node, index);
        1.0f,
            return shards.size();
    }
            doValidateBalanceFactorSum(indexBalance, value);
    public ShardAllocationDecision decideShardAllocation(final ShardRouting shard, final RoutingAllocation allocation) {
    public static final Setting<ShardMovementStrategy> SHARD_MOVEMENT_STRATEGY_SETTING = new Setting<ShardMovementStrategy>(
     */
        }
        );
            doValidateBalanceFactorSum(value, shardBalance);
import org.opensearch.common.inject.Inject;
     * Returns the index related weight factor.
        this.weightFunction.updateRebalanceConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
            return weights[weights.length - 1] - weights[0];
        ModelIndex(String id) {
        @Override
import java.util.List;
     */
        }
            shards.add(shard);
        public void addShard(ShardRouting shard) {
            return numShards;
                index.removeShard(shard);
        private int numShards = 0;
    }
        updateWeightFunction();
                "Balance factors ["
        assert this.rerouteService == null : "RerouteService is already set";
            case HIGH:
            for (int i = from; i < to; i++) {
        "cluster.routing.allocation.balance.prefer_primary",
        @Override
        setIndexBalanceFactor(INDEX_BALANCE_FACTOR_SETTING.get(settings));
        public boolean containsShard(ShardRouting shard) {
        ) {
        this.preferPrimaryShardRebalanceBuffer = preferPrimaryShardBalanceBuffer;
            this.balancer = balancer;
        clusterSettings.addSettingsUpdateConsumer(PREFER_PRIMARY_SHARD_BALANCE, this::setPreferPrimaryShardBalance);
        private RebalanceConstraints rebalanceConstraints;
 * The {@link BalancedShardsAllocator} re-balances the nodes allocations
     * <li><code>index balance</code> - balance property over shards per index</li>
            ModelIndex index = getIndex(shard.getIndexName());
    public static final Setting<Boolean> SHARD_MOVE_PRIMARY_FIRST_SETTING = Setting.boolSetting(
        }
        );
 * within a cluster based on a {@link WeightFunction}. The clusters balance is defined by four parameters which can be set
        TimeValue.MINUS_ONE,
        this.indexBalanceFactor = indexBalanceFactor;
        0,
                        unassignedInfo.getFailure(),
            }
    @Override
        public int numPrimaryShards() {
    );
        public void removeShard(ShardRouting shard) {
            }
                return highestPrimary = maxId;
    );
                int maxId = -1;
        Setting.Property.NodeScope,
            }
        BalancedShardsAllocator::parseReroutePriority,
            if (shard.primary()) {
            modelNodes[j] = tmpNode;
                ActionListener.wrap(
        clusterSettings.addSettingsUpdateConsumer(PRIMARY_SHARD_REBALANCE_BUFFER, this::updatePreferPrimaryShardBalanceBuffer);
            this.constraints.updateAllocationConstraint(constraint, enable);
     * and {@link ConstraintTypes#isPrimaryShardsPerNodeBreached} which is used during unassigned shard allocation
     * </ul>
            }
        clusterSettings.addSettingsUpdateConsumer(PREFER_PRIMARY_SHARD_REBALANCE, this::setPreferPrimaryShardRebalance);
        ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
            logger,
        setPrimaryConstraintThresholdSetting(PRIMARY_CONSTRAINT_THRESHOLD_SETTING.get(settings));
        private final float shardBalance;
    private volatile long primaryConstraintThreshold;
        this.weightFunction.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
        private long primaryConstraintThreshold;
        }
        Property.Dynamic,
            preferPrimaryShardBalance,
        void updatePrimaryConstraintThreshold(long primaryConstraintThreshold) {
        private final WeightFunction function;
        WeightFunction(
    private RerouteService rerouteService;
        public Iterator<Setting<?>> settings() {
import org.opensearch.common.settings.Settings;
        assert routingNodes.size() == 0 : routingNodes;
 * <li><code>cluster.routing.allocation.balance.prefer_primary</code> - Defines whether primary shard balance is desired</li>
import org.opensearch.cluster.routing.allocation.RebalanceParameter;
            if (shard.primary()) {
        @Override
        public int numShards() {
        @Override
            final List<Setting<?>> settings = Collections.singletonList(INDEX_BALANCE_FACTOR_SETTING);
    /**
        protected int comparePivot(int j) {
        }
    }
    }
        ) {
    }
    }
    public static final Setting<Float> PRIMARY_SHARD_REBALANCE_BUFFER = Setting.floatSetting(
 * The OpenSearch Contributors require contributions made to
    /**
            if (logger.isTraceEnabled()) {
    }
    private void setShardMovementStrategy(ShardMovementStrategy shardMovementStrategy) {
        Property.NodeScope,
 * are used to re-balance shards based on global as well as per-index factors.
        0.10f,
        new IndexBalanceFactorValidator(),
            threshold,
            final ShardRouting shardRouting = unassignedIterator.next();
    /**
        public String getNodeId() {
            );
        private int numPrimaryShards = 0;
        }
            }
     * <code>weight<sub>index</sub>(node, index) = indexBalance * (node.numShards(index) - avgShardsPerNode(index))</code>
            weights[j] = tmpWeight;
                return;
        Property.NodeScope
    private void updateIndexBalanceFactor(float indexBalanceFactor) {
    );
        Property.NodeScope
    );
    private void setFollowUpRerouteTaskPriority(Priority followUpRerouteTaskPriority) {
import org.opensearch.cluster.routing.RoutingNodes;
     * <p>
    private void failAllocationOfNewPrimaries(RoutingAllocation allocation) {
        Setting.Property.Dynamic
        true,
                return idx.highestPrimary();
                    }
        Property.Dynamic,
     *
 * of {@link org.opensearch.cluster.routing.ShardRouting}s per index allocated on a specific node</li>
     * A model index.
        }
    private static Priority parseReroutePriority(String priorityString) {
     */
        public float weightWithAllocationConstraints(ShardsBalancer balancer, ModelNode node, String index) {
        protected int compare(int i, int j) {
    }
import org.opensearch.common.settings.ClusterSettings;
            this.preferPrimaryShardBalance,
    private void setPreferPrimaryShardRebalance(boolean preferPrimaryShardRebalance) {
        private final Map<String, ModelIndex> indices = new HashMap<>();
        private AllocationConstraints constraints;
            return index == null ? 0 : index.numShards();
import org.apache.lucene.util.IntroSorter;
                    indices.remove(shard.getIndexName());
        }
        switch (priority) {
                weights[i] = weight(modelNodes[i]);
        this.followUpRerouteTaskPriority = followUpRerouteTaskPriority;
    static void doValidateBalanceFactorSum(float indexBalance, float shardBalance) {
        }
            this.function = function;
        this.movePrimaryFirst = movePrimaryFirst;
        clusterSettings.addSettingsUpdateConsumer(ALLOCATOR_TIMEOUT_SETTING, this::setAllocatorTimeout);
     * Changes in deprecated setting SHARD_MOVE_PRIMARY_FIRST_SETTING affect value of its replacement setting SHARD_MOVEMENT_STRATEGY_SETTING.
    /**
    }
import java.util.Set;
        this.weightFunction.updatePrimaryConstraintThreshold(threshold);
            rerouteService.reroute(
     * {@link LocalShardsBalancer#allocateUnassigned()} and shard re-balance/relocation to a different node via {@link LocalShardsBalancer#balance()} .
        this.preferPrimaryShardRebalance = preferPrimaryShardRebalance;
        public Iterator<ShardRouting> iterator() {
            StringBuilder sb = new StringBuilder();
        final Priority priority = Priority.valueOf(priorityString.toUpperCase(Locale.ROOT));
     * Validates that the index balance factor, combined with the shard balance factor, sums to a value greater than zero.
        clusterSettings.addSettingsUpdateConsumer(SHARD_BALANCE_FACTOR_SETTING, this::updateShardBalanceFactor);
     * to allocate shards.
        public Iterator<Setting<?>> settings() {
     * The weight per index is calculated based on the following formula:
     * @deprecated As of 2.4.0, replaced by {@link LocalShardsBalancer}
     * <p>
        }
     *  A {@link Balancer} used by the {@link BalancedShardsAllocator} to perform allocation operations
     * Returns preferPrimaryShardBalance.
import org.opensearch.cluster.routing.ShardRouting;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        updateWeightFunction();
            return id;
                        unassignedInfo.getMessage(),
        }
    public void setRerouteService(RerouteService rerouteService) {
    private void setMovePrimaryFirst(boolean movePrimaryFirst) {
            this.primaryConstraintThreshold,
     * <ul>
            ModelIndex index = indices.get(idx);
        clusterSettings.addSettingsUpdateConsumer(FOLLOW_UP_REROUTE_PRIORITY_SETTING, this::setFollowUpRerouteTaskPriority);
            boolean preferPrimaryShardRebalance
            final List<Setting<?>> settings = Collections.singletonList(SHARD_BALANCE_FACTOR_SETTING);
        clusterSettings.addSettingsUpdateConsumer(PRIMARY_CONSTRAINT_THRESHOLD_SETTING, this::setPrimaryConstraintThresholdSetting);
     */
            return;
    private void setIndexBalanceFactor(float indexBalanceFactor) {
        final ModelNode[] modelNodes;
     */
    }
        @Override
        this.shardMovementStrategy = shardMovementStrategy;
        }
        @Override
     */
            threshold,
        public String toString() {
        this.allocatorTimeout = allocatorTimeout;
        protected void setPivot(int i) {
                }
            this.primaryConstraintThreshold = primaryConstraintThreshold;
            RebalanceParameter rebalanceParameter = new RebalanceParameter(preferPrimaryBalanceBuffer);
                        unassignedInfo.getNumFailedAllocations(),
        false,
    );
     * @opensearch.internal
import org.opensearch.core.action.ActionListener;
    private void scheduleRerouteIfAllocatorTimedOut() {
            this.rebalanceConstraints.updateRebalanceConstraint(constraint, add);
            this.preferPrimaryShardRebalance
    }
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
        0.55f,
        localShardsBalancer.moveShards();
import static org.opensearch.cluster.action.shard.ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING;
            return settings.iterator();
            numShards--;
            preferPrimaryShardRebalance,
        updateWeightFunction();
     * <ul>
            highestPrimary = -1;
            float balancerWeight = weight(balancer, node, index);
    public float getThreshold() {
            this.id = id;
        Property.Dynamic,
        ModelNode(RoutingNode routingNode) {
     * Decides order in which to move shards from node when shards can not stay on node anymore. {@link LocalShardsBalancer#moveShards()}
        0.45f,
        if (allocatorTimeout.equals(TimeValue.MINUS_ONE)) {
        }
 * <li><code>cluster.routing.allocation.balance.index</code> - The <b>index balance</b> defines a factor to the number
        setPreferPrimaryShardRebalance(PREFER_PRIMARY_SHARD_REBALANCE.get(settings));
    static final class NodeSorter extends IntroSorter {
    private volatile ShardMovementStrategy shardMovementStrategy;
     * Adjusts the priority of the followup reroute task when current round times out. NORMAL is right for reasonable clusters,
        0.0f,
 */
            }
 * this file be licensed under the Apache-2.0 license or a
            }
    public static final Setting<Boolean> PREFER_PRIMARY_SHARD_REBALANCE = Setting.boolSetting(
        final ShardsBalancer remoteShardsBalancer = new RemoteShardsBalancer(logger, allocation);
     * @opensearch.internal
    }
                "reroute after balanced shards allocator timed out",
     * In the event of changing ShardMovementStrategy setting from default setting NO_PREFERENCE to either PRIMARY_FIRST or REPLICA_FIRST, we want that
         */
            }
        Float.MAX_VALUE,
        public float delta() {
    }
            ModelIndex index = indices.get(idx);
        Property.NodeScope
            "priority [" + priority + "] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]"
     * </li>
            throw new IllegalArgumentException(
    }
        clusterSettings.addSettingsUpdateConsumer(IGNORE_THROTTLE_FOR_REMOTE_RESTORE, this::setIgnoreThrottleInRestore);
        }
/*
    public float getShardBalance() {
 * <li><code>cluster.routing.allocation.balance.threshold</code> - A <b>threshold</b> to set the minimal optimization
        this.primaryConstraintThreshold = threshold;
     * <li>
     * <li>
    public void allocate(RoutingAllocation allocation) {
     * This setting governs whether primary shards balance is desired during allocation. This is used by {@link ConstraintTypes#isPerIndexPrimaryShardsPerNodeBreached()}
    @Deprecated
    private void setAllocatorTimeout(TimeValue allocatorTimeout) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        AllocateUnassignedDecision allocateUnassignedDecision = AllocateUnassignedDecision.NOT_TAKEN;
        }
            weights[i] = weights[j];
    private void updatePreferPrimaryShardBalanceBuffer(float preferPrimaryShardBalanceBuffer) {
        this.preferPrimaryShardBalance = preferPrimaryShardBalance;
        /**
    }
            return routingNode.nodeId();
        Property.NodeScope
        }
        "cluster.routing.allocation.balance.threshold",
        private final float theta1;
        private final float indexBalance;
        }
            return indices.values().iterator();
        if (allocation.routingNodes().size() == 0) {
 * ownership. Elasticsearch licenses this file to you under
                        unassignedInfo.getUnassignedTimeInNanos(),
     *
            return balancerWeight + constraints.weight(balancer, node, index, primaryConstraintThreshold);
            return Float.compare(weights[i], weights[j]);
        Priority.NORMAL.toString(),
        }
            return index == null ? 0 : index.numPrimaryShards();
     *
    private volatile boolean preferPrimaryShardBalance;
        setPreferPrimaryShardBalance(PREFER_PRIMARY_SHARD_BALANCE.get(settings));
                    + "] and ["
        Setting.Property.NodeScope,
        TimeValue.MINUS_ONE,
     */
            this.shardMovementStrategy = ShardMovementStrategy.PRIMARY_FIRST;
        @Override
        "cluster.routing.allocation.primary_constraint.threshold",
        }
        weightFunction = new WeightFunction(
            weightFunction,
import java.util.Iterator;
            theta1 = indexBalance / sum;
        @Override
        MoveDecision moveDecision = MoveDecision.NOT_TAKEN;
import org.apache.logging.log4j.Logger;
         * nodes by weight, with minimal weight first.
    static final class ShardBalanceFactorValidator implements Setting.Validator<Float> {
        public int numPrimaryShards() {
    @Override
 * @opensearch.internal
    private volatile float preferPrimaryShardRebalanceBuffer;
        }
     * <li><code>shard balance</code> - balance property over shards per cluster</li>
 * SPDX-License-Identifier: Apache-2.0
        }
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID;
    public static final Setting<Boolean> PREFER_PRIMARY_SHARD_BALANCE = Setting.boolSetting(
import org.opensearch.cluster.routing.UnassignedInfo;
            return primaryShards.size();
                unassignedIterator.updateUnassigned(
            boolean preferPrimaryShardBalance,
    );
        while (unassignedIterator.hasNext()) {
        public int highestPrimary() {
import java.util.HashMap;
            );
    private volatile boolean preferPrimaryShardRebalance;
    private volatile boolean movePrimaryFirst;
    }
 * <p>
        private final String id;
    /**
    /**
        }
        private final Set<ShardRouting> primaryShards = new HashSet<>();
        }
                    "Setting ["
                    new UnassignedInfo(
            case URGENT:
        clusterSettings.addSettingsUpdateConsumer(INDEX_BALANCE_FACTOR_SETTING, this::updateIndexBalanceFactor);
     * A node sorter.
    public static final Setting<Boolean> IGNORE_THROTTLE_FOR_REMOTE_RESTORE = Setting.boolSetting(
    }
                indices.put(index.getIndexId(), index);
import java.util.Map;
            this.primaryConstraintThreshold = primaryConstraintThreshold;
            return indices.get(indexId);
            weights = new float[modelNodes.length];
    /**
        RoutingNodes routingNodes = allocation.routingNodes();
import org.opensearch.cluster.routing.RoutingNode;
    public static final Setting<Float> INDEX_BALANCE_FACTOR_SETTING = Setting.floatSetting(
 * value of operations that should be performed</li>
        public float weightWithRebalanceConstraints(ShardsBalancer balancer, ModelNode node, String index) {
        @Override
                logger.trace("Allocator timeout is disabled. Will not short circuit allocator tasks");
            shards.remove(shard);
        float weight(ShardsBalancer balancer, ModelNode node, String index) {
     *
            preferPrimaryShardBalance,
            updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
        private int highestPrimary = -1;
     * Encapsulates behavior of above SHARD_MOVE_PRIMARY_FIRST_SETTING.
        remoteShardsBalancer.balance();
                        unassignedInfo.isDelayed(),
        this.ignoreThrottleInRestore = ignoreThrottleInRestore;
        }
    }
    }
 * software distributed under the License is distributed on an
            ModelIndex index = indices.get(shard.getIndexName());
        } else {
        @Override
        private final Set<ShardRouting> shards = new HashSet<>(4); // expect few shards of same index to be allocated on same node
    private void updateWeightFunction() {
     * When primary shards balance is desired, enable primary shard balancing constraints
        public void reset(String index) {
     */
    private volatile float indexBalanceFactor;
        }
            if (moveDecision.isDecisionTaken() && moveDecision.canRemain()) {
        return System.nanoTime() - this.startTime > allocatorTimeout.nanos();
        }
        localShardsBalancer.balance();
     * @param preferPrimaryShardBalance boolean to prefer balancing by primary shard
        "cluster.routing.allocation.balanced_shards_allocator.schedule_reroute.priority",
    }
                    + sum
 * compatible open source license.
        new ShardBalanceFactorValidator(),
            return false;
     * Validates that the shard balance factor, combined with the index balance factor, sums to a value greater than zero.
    private void setPrimaryConstraintThresholdSetting(long threshold) {
            return -1;
    /**
            moveDecision = localShardsBalancer.decideMove(shard);
    public static class ModelNode implements Iterable<ModelIndex> {
        public int highestPrimary(String index) {
 * not use this file except in compliance with the License.
    }
     */
        scheduleRerouteIfAllocatorTimedOut();
import org.opensearch.cluster.routing.allocation.ConstraintTypes;
            return Float.compare(pivotWeight, weights[j]);
    /**
     */
                MoveDecision rebalanceDecision = localShardsBalancer.decideRebalance(shard);
        public void addShard(ShardRouting shard) {
        setShardMovementStrategy(SHARD_MOVEMENT_STRATEGY_SETTING.get(settings));
        return threshold;
            }
        },
    public boolean getPreferPrimaryBalance() {
import org.opensearch.cluster.routing.RerouteService;
    }
/*
            updateRebalanceConstraint(CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID, preferPrimaryShardRebalance);
     * <code>weight<sub>node</sub>(node, index) = shardBalance * (node.numShards() - avgShardsPerNode)</code>
        setThreshold(THRESHOLD_SETTING.get(settings));
                );
        "cluster.routing.allocation.shard_movement_strategy",
            BalancedShardsAllocator.WeightFunction weight,
    private volatile TimeValue allocatorTimeout;
        ShardMovementStrategy::parse,
        setAllocatorTimeout(ALLOCATOR_TIMEOUT_SETTING.get(settings));
 * You may obtain a copy of the License at
        Float.MAX_VALUE,
    private void setShardBalanceFactor(float shardBalanceFactor) {
 * </ul>
        public RoutingNode getRoutingNode() {
    static final class ModelIndex implements Iterable<ShardRouting> {
        Property.Dynamic,
 * <ul><li><code>cluster.routing.allocation.balance.shard</code> - The <b>shard balance</b> defines the weight factor
}
        Property.NodeScope
                        maxId = Math.max(maxId, shard.id());
                    shardRouting.recoverySource(),
                for (ShardRouting shard : shards) {
        public Iterator<ModelIndex> iterator() {
            final float indexBalance = (Float) settings.get(INDEX_BALANCE_FACTOR_SETTING);
    public float getIndexBalance() {
        public void removeShard(ShardRouting shard) {
        this.shardBalanceFactor = shardBalanceFactor;
        public ModelIndex getIndex(String indexId) {
    public static final Setting<Float> SHARD_BALANCE_FACTOR_SETTING = Setting.floatSetting(
            this.shardBalance = shardBalance;
            return function.weightWithRebalanceConstraints(balancer, node, index);
     * @opensearch.internal
    private volatile WeightFunction weightFunction;
        Property.NodeScope
            if (timeValue.compareTo(MIN_ALLOCATOR_TIMEOUT) < 0 && timeValue.compareTo(TimeValue.MINUS_ONE) != 0) {
        }
            () -> false // as we don't need to check if timed out or not while just understanding ShardAllocationDecision
        }
                        AllocationStatus.DECIDERS_NO,
    public static final Setting<Priority> FOLLOW_UP_REROUTE_PRIORITY_SETTING = new Setting<>(
 *
    }
            final float weightIndex = node.numShards(index) - balancer.avgShardsPerNode(index);
     * package-private for testing
         * Resets the sorter, recalculates the weights per node and sorts the
     * in turn have no effect on the distribution.
        }
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
            final float tmpWeight = weights[i];
            if (shardRouting.primary() && unassignedInfo.getLastAllocationStatus() == AllocationStatus.NO_ATTEMPT) {
            pivotWeight = weights[i];
 * These parameters are combined in a {@link WeightFunction} that allows calculation of node weights which
 */
        ShardMovementStrategy.NO_PREFERENCE.toString(),
                )
        this.startTime = System.nanoTime();
        public int numShards(String idx) {
            if (idx != null) {
    }
    }
    public static final Setting<Float> THRESHOLD_SETTING = Setting.floatSetting(
 * for shards allocated on a {@link RoutingNode}</li>
            modelNodes[i] = modelNodes[j];
    }
        Setting.Property.Dynamic
        this.indexBalanceFactor = indexBalanceFactor;
                    e -> logger.debug("reroute after balanced shards allocator timed out failed", e)
        throw new IllegalArgumentException(
        public void validate(Float value) {}
            updateRebalanceConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
                numPrimaryShards--;
import java.util.Locale;
        }
                return priority;
 * Unless required by applicable law or agreed to in writing,
    }
    private void setThreshold(float threshold) {
        }
        remoteShardsBalancer.allocateUnassigned();
                if (index.numShards() == 0) {
            sb.append("Node(").append(routingNode.nodeId()).append(")");
            this.constraints = new AllocationConstraints();
        }
     * Each of these properties are expressed as factor such that the properties factor defines the relative
            final ModelNode tmpNode = modelNodes[i];
                throw new IllegalArgumentException(
            final UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
        if (shardMovementStrategy == ShardMovementStrategy.NO_PREFERENCE && this.movePrimaryFirst) {
     */
import java.util.HashSet;
        public void validate(Float value) {}
            assert shards.contains(shard) : "Shard not allocated on current node: " + shard;
import org.opensearch.cluster.routing.allocation.AllocationConstraints;
        "cluster.routing.allocation.move.primary_first",
 *
    private volatile boolean ignoreThrottleInRestore;
        private float pivotWeight;
    }
        clusterSettings.addSettingsUpdateConsumer(SHARD_MOVE_PRIMARY_FIRST_SETTING, this::setMovePrimaryFirst);
        "cluster.routing.allocation.balanced_shards_allocator.allocator_timeout",
        private final ShardsBalancer balancer;
        "cluster.routing.allocation.balance.shard",
        }
     * This class is the primary weight function used to create balanced over nodes and shards in the cluster.
            weightFunction,
            this.shardBalanceFactor,
        private final float theta0;
            this.indexBalanceFactor,
        0.0f,
    /**
        final float[] weights;
                        + "cluster.routing.allocation.balanced_shards_allocator.allocator_timeout"
        "cluster.routing.allocation.rebalance.primary.buffer",
    public static final Setting<Long> PRIMARY_CONSTRAINT_THRESHOLD_SETTING = Setting.longSetting(
     * </li>
    private volatile float shardBalanceFactor;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private long startTime;
            if (shard.primary()) {
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
    private static final Logger logger = LogManager.getLogger(BalancedShardsAllocator.class);
            if (index != null) {
            ModelIndex idx = indices.get(index);
            RoutingAllocation allocation,
    public static class Balancer extends LocalShardsBalancer {
        float sum = indexBalance + shardBalance;
    public static final TimeValue MIN_ALLOCATOR_TIMEOUT = TimeValue.timeValueSeconds(20);
     * Move primary shards first from node for shard movement when shards can not stay on node anymore. {@link LocalShardsBalancer#moveShards()}
        this.shardBalanceFactor = shardBalanceFactor;
                    + INDEX_BALANCE_FACTOR_SETTING.getKey()
        updateWeightFunction();
     * A model node.
     * @opensearch.internal
            allocation,
            }
            if (shard.primary()) {
                numPrimaryShards++;
    }
        @Override
     * If users are still using deprecated setting `move_primary_first`, we want behavior to remain unchanged.
    /**
    );
/**
 * license agreements. See the NOTICE file distributed with
     * but for a cluster in a messed up state which is starving NORMAL priority tasks, it might be necessary to raise this higher
            float indexBalance,
            ignoreThrottleInRestore,
    private void setPreferPrimaryShardRebalanceBuffer(float preferPrimaryShardRebalanceBuffer) {
        }
        }
    /**
    /**
        clusterSettings.addSettingsUpdateConsumer(SHARD_MOVEMENT_STRATEGY_SETTING, this::setShardMovementStrategy);
 * under the License.
                        unassignedInfo.getUnassignedTimeInMillis(),
            sort(from, to);
            return balancerWeight + rebalanceConstraints.weight(balancer, node, index, primaryConstraintThreshold);
        0.0f,
            index.addShard(shard);
                    if (shard.primary()) {
        this.weightFunction.updateRebalanceConstraint(CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID, preferPrimaryShardRebalance);
                assert primaryShards.contains(shard) == false : "Primary shard already allocated on current node: " + shard;
            updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
            this.routingNode = routingNode;
        }
        Property.Dynamic,
        public int numShards() {
import org.opensearch.common.settings.Setting;
        localShardsBalancer.allocateUnassigned();
            allocateUnassignedDecision = localShardsBalancer.decideAllocateUnassigned(shard);
            return routingNode;
     * </p>
        NodeSorter(ModelNode[] modelNodes, WeightFunction function, ShardsBalancer balancer) {
            Logger logger,
        }
    static final class IndexBalanceFactorValidator implements Setting.Validator<Float> {
            return settings.iterator();
     * </ul>
     * to have priority over values set in move_primary_first setting.
     */
            }
     */
                    + "] must sum to a value greater than zero but was ["
                    ),
     * the weights only based on a global (shard) balance the index balance can be set to {@code 0.0} and will
        public Balancer(
    /**
        }
 */
        }
        this.preferPrimaryShardRebalanceBuffer = preferPrimaryShardRebalanceBuffer;
            ignoreThrottleInRestore,
            preferPrimaryShardRebalance,
        this.rerouteService = rerouteService;
 * in the cluster update API that allows changes in real-time:
     * <code>weight(node, index) = weight<sub>index</sub>(node, index) + weight<sub>node</sub>(node, index)</code>
            super(logger, allocation, shardMovementStrategy, weight, threshold, preferPrimaryBalance, false, false, () -> false);
    );
            this.modelNodes = modelNodes;
        Property.Dynamic,
     *
            this.indexBalance = indexBalance;
/*
        this.threshold = threshold;
        private final RoutingNode routingNode;
                logger.info("RerouteService not set to schedule reroute after allocator time out");
            this::allocatorTimedOut
            if (highestPrimary == -1) {
            return numPrimaryShards;
    /**
        setShardMovementStrategy(this.shardMovementStrategy);
    /**
     * @opensearch.internal
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            boolean preferPrimaryBalance
            long primaryConstraintThreshold,
    }
            // Enable index shard per node breach constraint
    }
                throw new IllegalArgumentException("Balance factors must sum to a value > 0 but was: " + sum);
    }
                }
            if (rerouteService == null) {
    private void setPreferPrimaryShardBalance(boolean preferPrimaryShardBalance) {
        }
        if (allocatorTimedOut()) {
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
        if (shard.unassigned()) {
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID;
        }
            if (sum <= 0.0f) {
        10,
            return index == null ? false : index.containsShard(shard);
                        unassignedInfo.getReason(),
 * specific language governing permissions and limitations
public class BalancedShardsAllocator implements ShardsAllocator {
        "cluster.routing.allocation.remote_primary.ignore_throttle",
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            theta0 = shardBalance / sum;
 *
        public boolean containsShard(ShardRouting shard) {
    );
     *
 * KIND, either express or implied.  See the License for the
    public static final Setting<TimeValue> ALLOCATOR_TIMEOUT_SETTING = Setting.timeSetting(
            this.index = index;
        setIgnoreThrottleInRestore(IGNORE_THROTTLE_FOR_REMOTE_RESTORE.get(settings));
            float shardBalance,
            float sum = indexBalance + shardBalance;
     * Returns the shard related weight factor.
        return new ShardAllocationDecision(allocateUnassignedDecision, moveDecision);
import org.opensearch.cluster.routing.ShardMovementStrategy;
            allocation,
        this(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
        @Override
        if (sum <= 0.0f) {
    protected boolean allocatorTimedOut() {
import org.opensearch.common.unit.TimeValue;
 * Modifications Copyright OpenSearch Contributors. See
        false,
    );
                    + "]"
        /* the nodes weights with respect to the current weight function / index */
        }
    );
            this.rebalanceConstraints = new RebalanceConstraints(rebalanceParameter);
        }
            final float weightShard = node.numShards() - balancer.avgShardsPerNode();
        final RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = routingNodes.unassigned().iterator();
     * Returns the currently configured delta threshold
            return shards.iterator();
            float preferPrimaryBalanceBuffer,
import org.opensearch.cluster.routing.allocation.RebalanceConstraints;
     * Currently this function has 3 properties:
        public int numPrimaryShards(String idx) {
    /**
                primaryShards.add(shard);
    );
    private void updateShardBalanceFactor(float shardBalanceFactor) {
            }
                        + "] should be more than 20s or -1ms to disable timeout"
        setShardBalanceFactor(SHARD_BALANCE_FACTOR_SETTING.get(settings));
     * Sets the correct Shard movement strategy to use.
                moveDecision = rebalanceDecision.withRemainDecision(moveDecision.getCanRemainDecision());
    private volatile Priority followUpRerouteTaskPriority;
        Property.Deprecated
                    + SHARD_BALANCE_FACTOR_SETTING.getKey()
            this.preferPrimaryShardRebalanceBuffer,
        void updateAllocationConstraint(String constraint, boolean enable) {
        setPreferPrimaryShardRebalanceBuffer(PRIMARY_SHARD_REBALANCE_BUFFER.get(settings));
package org.opensearch.cluster.routing.allocation.allocator;
        this.weightFunction.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
        return preferPrimaryShardBalance;
    @Override
                primaryShards.remove(shard);
            return theta0 * weightShard + theta1 * weightIndex;
        0.0f,
        }
        return weightFunction.shardBalance;
                    allocation.changes()
        @Override
        }
 *
            }
import org.opensearch.common.Priority;
        }
            shardMovementStrategy,
    /**
     */
        }
            return highestPrimary;
        clusterSettings.addSettingsUpdateConsumer(THRESHOLD_SETTING, this::setThreshold);
        setFollowUpRerouteTaskPriority(FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(settings));
    }
     */
     * importance of the property for the weight function. For example if the weight function should calculate
        void updateRebalanceConstraint(String constraint, boolean add) {
    private volatile float threshold;
        Property.Dynamic,
        Property.Dynamic,
        remoteShardsBalancer.moveShards();
        }
            if (index == null) {
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        }
        Property.Dynamic,
        false,
        );
        Property.Dynamic,
        public void validate(final Float value, final Map<Setting<?>, Object> settings) {
        );
            shardMovementStrategy,
     */
        public void validate(final Float value, final Map<Setting<?>, Object> settings) {
        "cluster.routing.allocation.rebalance.primary.enable",
     * @opensearch.internal
        }
import org.opensearch.cluster.routing.allocation.MoveDecision;
            logger,
 * Licensed to Elasticsearch under one or more contributor
            ModelIndex index = indices.get(shard.getIndexName());
    private void setIgnoreThrottleInRestore(boolean ignoreThrottleInRestore) {
