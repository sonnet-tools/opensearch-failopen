        }  
    private volatile float indexBalanceFactor;
        },  
     * @opensearch.internal  
                )
    private void setThreshold(float threshold) {
                    "Setting ["
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
                return idx.highestPrimary();
            reset(index, 0, modelNodes.length);  
            theta1 = indexBalance / sum;  
        "cluster.routing.allocation.balance.index",
    );
    public static final Setting<Float> THRESHOLD_SETTING = Setting.floatSetting(  
     * <li><code>shard balance</code> - balance property over shards per cluster</li>
        Property.NodeScope
     *
     * package-private for testing
        setPreferPrimaryShardRebalance(PREFER_PRIMARY_SHARD_REBALANCE.get(settings));  
            final List<Setting<?>> settings = Collections.singletonList(SHARD_BALANCE_FACTOR_SETTING);
import org.opensearch.common.settings.Settings;  
    );
     * Adjusts the priority of the followup reroute task when current round times out. NORMAL is right for reasonable clusters,  
        ShardsBalancer localShardsBalancer = new LocalShardsBalancer(  
    }
        @Override
        0.0f,  
                        + "cluster.routing.allocation.balanced_shards_allocator.allocator_timeout"
        throw new IllegalArgumentException(
            final UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
            this.preferPrimaryShardBalance,
            logger,
     * importance of the property for the weight function. For example if the weight function should calculate
            return shards.contains(shard);  
        public float delta() {
    }
     */  
    }
        Property.Dynamic,  
            if (moveDecision.isDecisionTaken() && moveDecision.canRemain()) {
        public boolean containsShard(ShardRouting shard) {
            updateRebalanceConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
            weightFunction,
import org.opensearch.common.settings.Setting.Property;
        this.threshold = threshold;
    /**
                logger.info("RerouteService not set to schedule reroute after allocator time out");
        }
        @Override
     *  
    public boolean getPreferPrimaryBalance() {  
        public int numShards() {  
                for (ShardRouting shard : shards) {
     * in turn have no effect on the distribution.
    }
 * within a cluster based on a {@link WeightFunction}. The clusters balance is defined by four parameters which can be set  
        AllocateUnassignedDecision allocateUnassignedDecision = AllocateUnassignedDecision.NOT_TAKEN;
        public int numShards(String idx) {  
        final RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = routingNodes.unassigned().iterator();
        }
    private void scheduleRerouteIfAllocatorTimedOut() {
            preferPrimaryShardBalance,  
     */
     * but for a cluster in a messed up state which is starving NORMAL priority tasks, it might be necessary to raise this higher
 */  
        protected void setPivot(int i) {
import org.opensearch.cluster.routing.allocation.MoveDecision;
        if (sum <= 0.0f) {
        10,
    public static final Setting<Boolean> PREFER_PRIMARY_SHARD_REBALANCE = Setting.boolSetting(
/*  
        "cluster.routing.allocation.move.primary_first",
                ActionListener.wrap(
    }
        private final float indexBalance;  
     * </p>
    public void setRerouteService(RerouteService rerouteService) {
        } else {  
    /**
        }
    public static final Setting<Long> PRIMARY_CONSTRAINT_THRESHOLD_SETTING = Setting.longSetting(
            }
            final float tmpWeight = weights[i];  
        this.preferPrimaryShardBalance = preferPrimaryShardBalance;
        ) {  
    private volatile boolean preferPrimaryShardRebalance;
        @Override
            this.constraints = new AllocationConstraints();
        clusterSettings.addSettingsUpdateConsumer(INDEX_BALANCE_FACTOR_SETTING, this::updateIndexBalanceFactor);
 * <li><code>cluster.routing.allocation.balance.index</code> - The <b>index balance</b> defines a factor to the number
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
                primaryShards.remove(shard);
            case URGENT:
        scheduleRerouteIfAllocatorTimedOut();
    private void failAllocationOfNewPrimaries(RoutingAllocation allocation) {
        this.allocatorTimeout = allocatorTimeout;
    static final class NodeSorter extends IntroSorter {  
import org.opensearch.cluster.routing.allocation.RebalanceConstraints;  
        protected void swap(int i, int j) {
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;  
                    + INDEX_BALANCE_FACTOR_SETTING.getKey()
    /**
        Property.Deprecated  
        MoveDecision moveDecision = MoveDecision.NOT_TAKEN;  
    }
    );  
                        unassignedInfo.getReason(),
        float sum = indexBalance + shardBalance;  
        public void validate(Float value) {}
            return routingNode.nodeId();
 * specific language governing permissions and limitations
        updateWeightFunction();
                        unassignedInfo.getMessage(),  
        }  
    private volatile WeightFunction weightFunction;  
            // Enable index shard per node breach constraint
        clusterSettings.addSettingsUpdateConsumer(SHARD_BALANCE_FACTOR_SETTING, this::updateShardBalanceFactor);
    private void setPreferPrimaryShardRebalanceBuffer(float preferPrimaryShardRebalanceBuffer) {  
 *
     * Validates that the index balance factor, combined with the shard balance factor, sums to a value greater than zero.
    }
            ModelIndex index = indices.get(shard.getIndexName());
        public RoutingNode getRoutingNode() {
                followUpRerouteTaskPriority,  
        return System.nanoTime() - this.startTime > allocatorTimeout.nanos();
            return shards.iterator();  
        "cluster.routing.allocation.balanced_shards_allocator.allocator_timeout",
     * Sets the correct Shard movement strategy to use.
        false,
     * </li>
            this.indexBalance = indexBalance;
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            return numShards;  
                throw new IllegalArgumentException("Balance factors must sum to a value > 0 but was: " + sum);  
     * This setting governs whether primary shards balance is desired during allocation. This is used by {@link ConstraintTypes#isPerIndexPrimaryShardsPerNodeBreached()}
            this.shardBalanceFactor,
        private final ShardsBalancer balancer;
        private final String id;  
            case HIGH:
                    + SHARD_BALANCE_FACTOR_SETTING.getKey()  
        private float pivotWeight;
         * Resets the sorter, recalculates the weights per node and sorts the  
    private RerouteService rerouteService;
     * </li>
        public int highestPrimary(String index) {
    }
     */  
        false,  
                    + sum
        "cluster.routing.allocation.primary_constraint.threshold",  
            doValidateBalanceFactorSum(value, shardBalance);
import org.apache.logging.log4j.LogManager;
            }
            final float weightIndex = node.numShards(index) - balancer.avgShardsPerNode(index);  
    public static class ModelNode implements Iterable<ModelIndex> {
        @Override
     * Changes in deprecated setting SHARD_MOVE_PRIMARY_FIRST_SETTING affect value of its replacement setting SHARD_MOVEMENT_STRATEGY_SETTING.
        setPrimaryConstraintThresholdSetting(PRIMARY_CONSTRAINT_THRESHOLD_SETTING.get(settings));
import java.util.HashMap;
        protected int compare(int i, int j) {  
    }
                        unassignedInfo.isDelayed(),
    public static final Setting<TimeValue> ALLOCATOR_TIMEOUT_SETTING = Setting.timeSetting(  
        }
        setIndexBalanceFactor(INDEX_BALANCE_FACTOR_SETTING.get(settings));
            if (timeValue.compareTo(MIN_ALLOCATOR_TIMEOUT) < 0 && timeValue.compareTo(TimeValue.MINUS_ONE) != 0) {
        private final WeightFunction function;
        this.movePrimaryFirst = movePrimaryFirst;
        public float weightWithAllocationConstraints(ShardsBalancer balancer, ModelNode node, String index) {  
        Property.NodeScope
    }  
 * value of operations that should be performed</li>
     * Returns the shard related weight factor.  
        Setting.Property.Dynamic
                }  
 * not use this file except in compliance with the License.
    );
        }  
     * If users are still using deprecated setting `move_primary_first`, we want behavior to remain unchanged.
        remoteShardsBalancer.allocateUnassigned();
     */  
    }
     *  A {@link Balancer} used by the {@link BalancedShardsAllocator} to perform allocation operations
        setShardBalanceFactor(SHARD_BALANCE_FACTOR_SETTING.get(settings));
        return new ShardAllocationDecision(allocateUnassignedDecision, moveDecision);
        public int numPrimaryShards() {  
    public static final Setting<Boolean> IGNORE_THROTTLE_FOR_REMOTE_RESTORE = Setting.boolSetting(  
            RebalanceParameter rebalanceParameter = new RebalanceParameter(preferPrimaryBalanceBuffer);
            this.balancer = balancer;  
        clusterSettings.addSettingsUpdateConsumer(IGNORE_THROTTLE_FOR_REMOTE_RESTORE, this::setIgnoreThrottleInRestore);
     * Encapsulates behavior of above SHARD_MOVE_PRIMARY_FIRST_SETTING.
        }  
                        AllocationStatus.DECIDERS_NO,  
 * <ul><li><code>cluster.routing.allocation.balance.shard</code> - The <b>shard balance</b> defines the weight factor
                index.removeShard(shard);  
            }  
     * <li>
        Float.MAX_VALUE,
    private static final Logger logger = LogManager.getLogger(BalancedShardsAllocator.class);  
    }
                        unassignedInfo.getUnassignedTimeInNanos(),  
        clusterSettings.addSettingsUpdateConsumer(PRIMARY_CONSTRAINT_THRESHOLD_SETTING, this::setPrimaryConstraintThresholdSetting);  
        updateWeightFunction();
            this.rebalanceConstraints.updateRebalanceConstraint(constraint, add);  
        TimeValue.MINUS_ONE,
            StringBuilder sb = new StringBuilder();  
        }
        this.indexBalanceFactor = indexBalanceFactor;
    }  
import org.opensearch.cluster.routing.RoutingNode;
            float balancerWeight = weight(balancer, node, index);  
    private long startTime;
            this.primaryConstraintThreshold,  
            if (index == null) {  
            return routingNode;
                unassignedIterator.updateUnassigned(  
                    + "] must sum to a value greater than zero but was ["
        public void removeShard(ShardRouting shard) {  
        Property.Dynamic,
            return shards.size();
    }
     * When primary shards balance is desired, enable primary shard balancing constraints
 * @opensearch.internal
    /**  
     * @opensearch.internal  
        Property.NodeScope  
     * Each of these properties are expressed as factor such that the properties factor defines the relative
                );
            this::allocatorTimedOut
        "cluster.routing.allocation.balance.shard",
    protected boolean allocatorTimedOut() {  
            allocation,  
        0.45f,
            index.addShard(shard);
        public Iterator<ShardRouting> iterator() {
            modelNodes[i] = modelNodes[j];
        public String getNodeId() {  
            sb.append("Node(").append(routingNode.nodeId()).append(")");
            this.shardMovementStrategy = ShardMovementStrategy.PRIMARY_FIRST;  
        ) {
                moveDecision = rebalanceDecision.withRemainDecision(moveDecision.getCanRemainDecision());
    static class WeightFunction {
            return index == null ? 0 : index.numShards();
            threshold,  
            failAllocationOfNewPrimaries(allocation);
                assert primaryShards.contains(shard) : "Primary shard not allocated on current node: " + shard;
     * <p>  
            weights[i] = weights[j];
        RoutingNodes routingNodes = allocation.routingNodes();
    static void doValidateBalanceFactorSum(float indexBalance, float shardBalance) {
        }
    private volatile float threshold;
            boolean preferPrimaryBalance  
    /**
            updateAllocationConstraint(INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID, true);
    @Deprecated
            this.primaryConstraintThreshold = primaryConstraintThreshold;
            float sum = indexBalance + shardBalance;
            }  
                indices.put(index.getIndexId(), index);
    private void updateWeightFunction() {
            threshold,
                numPrimaryShards++;  
        ModelNode(RoutingNode routingNode) {
import java.util.Iterator;
    );
        Property.NodeScope
 *     http://www.apache.org/licenses/LICENSE-2.0
        public int numPrimaryShards(String idx) {
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
            doValidateBalanceFactorSum(indexBalance, value);
            if (shard.primary()) {  
        protected int comparePivot(int j) {
                return priority;  
    private volatile long primaryConstraintThreshold;
    }  
            this.indexBalanceFactor,  
        }  
        private final Map<String, ModelIndex> indices = new HashMap<>();
        public ModelIndex getIndex(String indexId) {
        float weight(ShardsBalancer balancer, ModelNode node, String index) {
    );
        private final float theta0;
        );
import static org.opensearch.cluster.action.shard.ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING;
            this.id = id;  
        setPreferPrimaryShardRebalanceBuffer(PRIMARY_SHARD_REBALANCE_BUFFER.get(settings));  
     * and {@link ConstraintTypes#isPrimaryShardsPerNodeBreached} which is used during unassigned shard allocation  
        public void reset(String index) {
        return weightFunction.indexBalance;
     * <code>weight<sub>index</sub>(node, index) = indexBalance * (node.numShards(index) - avgShardsPerNode(index))</code>  
        localShardsBalancer.balance();  
        void updatePrimaryConstraintThreshold(long primaryConstraintThreshold) {  
            return Float.compare(pivotWeight, weights[j]);
            highestPrimary = -1;
            float shardBalance,
        }  
 * <li><code>cluster.routing.allocation.balance.threshold</code> - A <b>threshold</b> to set the minimal optimization  
            long primaryConstraintThreshold,  
        this.weightFunction.updateRebalanceConstraint(CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID, preferPrimaryShardRebalance);
        if (allocatorTimeout.equals(TimeValue.MINUS_ONE)) {
        public Iterator<Setting<?>> settings() {
        0.0f,  
        ShardMovementStrategy.NO_PREFERENCE.toString(),  
        }
 * ownership. Elasticsearch licenses this file to you under  
            return false;
            if (rerouteService == null) {  
            allocation,
            return balancerWeight + constraints.weight(balancer, node, index, primaryConstraintThreshold);
        this.shardBalanceFactor = shardBalanceFactor;
    @Inject
        this.weightFunction.updatePrimaryConstraintThreshold(threshold);
        this.preferPrimaryShardRebalanceBuffer = preferPrimaryShardBalanceBuffer;  
    private volatile TimeValue allocatorTimeout;
        Setting.Property.NodeScope,
            this.shardBalance = shardBalance;
            highestPrimary = -1;
        }
            final List<Setting<?>> settings = Collections.singletonList(INDEX_BALANCE_FACTOR_SETTING);  
    private void setIndexBalanceFactor(float indexBalanceFactor) {
        @Override
        }  
    public static class Balancer extends LocalShardsBalancer {
            ModelIndex index = indices.get(idx);
        setFollowUpRerouteTaskPriority(FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(settings));  
     */
    }
                    + "]"  
                index = new ModelIndex(shard.getIndexName());
    }
        private final float theta1;  
        setAllocatorTimeout(ALLOCATOR_TIMEOUT_SETTING.get(settings));
        }
                        unassignedInfo.getFailure(),
 */  
            }
    static final class ShardBalanceFactorValidator implements Setting.Validator<Float> {
    }
        BalancedShardsAllocator::parseReroutePriority,
     * <li><code>index balance</code> - balance property over shards per index</li>  
 * GitHub history for details.
 * <p>
            return weights[weights.length - 1] - weights[0];  
        0.0f,  
        if (shard.unassigned()) {
        clusterSettings.addSettingsUpdateConsumer(SHARD_MOVEMENT_STRATEGY_SETTING, this::setShardMovementStrategy);  
    }
                int maxId = -1;  
        false,  
        clusterSettings.addSettingsUpdateConsumer(THRESHOLD_SETTING, this::setThreshold);
            boolean preferPrimaryShardRebalance
    private void setFollowUpRerouteTaskPriority(Priority followUpRerouteTaskPriority) {
        }
                    + "] and ["
            modelNodes[j] = tmpNode;
        Property.NodeScope  
        }
        timeValue -> {
        localShardsBalancer.moveShards();
     * Returns the index related weight factor.
        public String getIndexId() {
        }  
    public static final Setting<Boolean> PREFER_PRIMARY_SHARD_BALANCE = Setting.boolSetting(
        Property.NodeScope,
    }  
 * under the License.  
            final float indexBalance = (Float) settings.get(INDEX_BALANCE_FACTOR_SETTING);  
        Priority.NORMAL.toString(),  
 * Modifications Copyright OpenSearch Contributors. See
        public Balancer(  
            numShards--;
        }
                    ),
            if (shardRouting.primary() && unassignedInfo.getLastAllocationStatus() == AllocationStatus.NO_ATTEMPT) {
    private void setPreferPrimaryShardBalance(boolean preferPrimaryShardBalance) {
     * <code>weight<sub>node</sub>(node, index) = shardBalance * (node.numShards() - avgShardsPerNode)</code>  
    private void updateIndexBalanceFactor(float indexBalanceFactor) {
        weightFunction = new WeightFunction(
        private String index;  
package org.opensearch.cluster.routing.allocation.allocator;
                        maxId = Math.max(maxId, shard.id());  
        WeightFunction(
        Property.Dynamic,  
     */
     * A model index.
/*  
    }  
                    e -> logger.debug("reroute after balanced shards allocator timed out failed", e)  
            this.primaryConstraintThreshold = primaryConstraintThreshold;  
        public float weightWithRebalanceConstraints(ShardsBalancer balancer, ModelNode node, String index) {
            boolean preferPrimaryShardBalance,
        this.shardMovementStrategy = shardMovementStrategy;
    private void setMovePrimaryFirst(boolean movePrimaryFirst) {  
    }  
    public BalancedShardsAllocator(Settings settings, ClusterSettings clusterSettings) {  
            preferPrimaryShardBalance,
        Property.NodeScope
        Setting.Property.NodeScope,
     * Returns the currently configured delta threshold
        clusterSettings.addSettingsUpdateConsumer(PREFER_PRIMARY_SHARD_BALANCE, this::setPreferPrimaryShardBalance);
        this.rerouteService = rerouteService;  
                );
        NodeSorter(ModelNode[] modelNodes, WeightFunction function, ShardsBalancer balancer) {
     */
            "priority [" + priority + "] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]"  
    static final class ModelIndex implements Iterable<ShardRouting> {
import org.opensearch.common.settings.ClusterSettings;  
        }  
        this.preferPrimaryShardRebalanceBuffer = preferPrimaryShardRebalanceBuffer;
            if (highestPrimary == -1) {
            if (shard.primary()) {  
    private void setShardBalanceFactor(float shardBalanceFactor) {
        }  
import org.opensearch.cluster.routing.allocation.AllocationConstraints;  
        }  
                logger.trace("Allocator timeout is disabled. Will not short circuit allocator tasks");  
        @Override  
    private void updateShardBalanceFactor(float shardBalanceFactor) {  
            pivotWeight = weights[i];  
            this.preferPrimaryShardRebalanceBuffer,
        Property.Dynamic,  
            logger,
            this.constraints.updateAllocationConstraint(constraint, enable);
        if (shardMovementStrategy == ShardMovementStrategy.NO_PREFERENCE && this.movePrimaryFirst) {
        this.preferPrimaryShardRebalance = preferPrimaryShardRebalance;  
    }  
        this.followUpRerouteTaskPriority = followUpRerouteTaskPriority;  
            shards.add(shard);
        setThreshold(THRESHOLD_SETTING.get(settings));  
        }
        }
        private int numPrimaryShards = 0;
    }  
                    allocation.changes()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Property.Dynamic,
     */  
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID;  
     *
 * Licensed to Elasticsearch under one or more contributor  
            }  
                }
            () -> false // as we don't need to check if timed out or not while just understanding ShardAllocationDecision  
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @opensearch.internal
            float balancerWeight = weight(balancer, node, index);
 * for shards allocated on a {@link RoutingNode}</li>  
            ShardMovementStrategy shardMovementStrategy,  
        this.ignoreThrottleInRestore = ignoreThrottleInRestore;  
        public String toString() {
                    new UnassignedInfo(
    private volatile boolean ignoreThrottleInRestore;
        if (allocation.routingNodes().size() == 0) {  
        @Override
            final ShardRouting shardRouting = unassignedIterator.next();  
    }  
    }
        return preferPrimaryShardBalance;
            }
        updateWeightFunction();
     * In the event of changing ShardMovementStrategy setting from default setting NO_PREFERENCE to either PRIMARY_FIRST or REPLICA_FIRST, we want that  
            sort(from, to);
            }
            rerouteService.reroute(
                        + "] should be more than 20s or -1ms to disable timeout"  
            return indices.get(indexId);  
        public void validate(Float value) {}  
        final float[] weights;
    }
import org.apache.logging.log4j.Logger;
    public float getThreshold() {  
            return balancerWeight + rebalanceConstraints.weight(balancer, node, index, primaryConstraintThreshold);
                MoveDecision rebalanceDecision = localShardsBalancer.decideRebalance(shard);  
                    if (shard.primary()) {
                primaryShards.add(shard);  
/*
     */  
        }
import org.opensearch.common.settings.Setting;
        }
        }
     * the weights only based on a global (shard) balance the index balance can be set to {@code 0.0} and will  
     */
        TimeValue.MINUS_ONE,  
        assert this.rerouteService == null : "RerouteService is already set";
     * @opensearch.internal
        public Iterator<Setting<?>> settings() {  
        final ModelNode[] modelNodes;
import org.opensearch.common.Priority;
            for (int i = from; i < to; i++) {
     * Currently this function has 3 properties:
    }
            theta0 = shardBalance / sum;
     */  
            ModelIndex idx = indices.get(index);  
 * of {@link org.opensearch.cluster.routing.ShardRouting}s per index allocated on a specific node</li>
 * <li><code>cluster.routing.allocation.balance.prefer_primary</code> - Defines whether primary shard balance is desired</li>
        "cluster.routing.allocation.shard_movement_strategy",
            return highestPrimary;
            return sb.toString();
                return highestPrimary = maxId;  
        assert routingNodes.size() == 0 : routingNodes;  
        }  
            final float weightShard = node.numShards() - balancer.avgShardsPerNode();
    /**
     * @opensearch.internal
        1.0f,
        private int highestPrimary = -1;  
        private RebalanceConstraints rebalanceConstraints;  
     */
        setShardMovementStrategy(SHARD_MOVEMENT_STRATEGY_SETTING.get(settings));
    private void setIgnoreThrottleInRestore(boolean ignoreThrottleInRestore) {
            Logger logger,
     * <p>
            }  
    /**  
            ModelIndex index = indices.get(idx);  
            this.modelNodes = modelNodes;
        final Priority priority = Priority.valueOf(priorityString.toUpperCase(Locale.ROOT));
 * The OpenSearch Contributors require contributions made to  
                return;
     * </ul>
            return Float.compare(weights[i], weights[j]);
     * @opensearch.internal
    /**  
        0.55f,
    /**  
        Property.Dynamic,
 * KIND, either express or implied.  See the License for the
            return theta0 * weightShard + theta1 * weightIndex;
            return index == null ? false : index.containsShard(shard);  
        0,
import org.apache.lucene.util.IntroSorter;  
    private void setPrimaryConstraintThresholdSetting(long threshold) {
    private volatile ShardMovementStrategy shardMovementStrategy;
        setIgnoreThrottleInRestore(IGNORE_THROTTLE_FOR_REMOTE_RESTORE.get(settings));
    }
    public static final TimeValue MIN_ALLOCATOR_TIMEOUT = TimeValue.timeValueSeconds(20);
}  
        this.primaryConstraintThreshold = threshold;  
            weightFunction,
     */
     * This class is the primary weight function used to create balanced over nodes and shards in the cluster.  
        @Override
                        unassignedInfo.getUnassignedTimeInMillis(),
        private final Set<ShardRouting> primaryShards = new HashSet<>();
        setShardMovementStrategy(this.shardMovementStrategy);
        setPreferPrimaryShardBalance(PREFER_PRIMARY_SHARD_BALANCE.get(settings));
        final ShardsBalancer remoteShardsBalancer = new RemoteShardsBalancer(logger, allocation);  
                numPrimaryShards--;
    }
        remoteShardsBalancer.moveShards();
            assert shards.contains(shard) : "Shard not allocated on current node: " + shard;
    private volatile Priority followUpRerouteTaskPriority;  
            return indices.values().iterator();
            float preferPrimaryBalanceBuffer,
            }
                "Balance factors ["  
            if (logger.isTraceEnabled()) {
    );  
 * in the cluster update API that allows changes in real-time:
        clusterSettings.addSettingsUpdateConsumer(ALLOCATOR_TIMEOUT_SETTING, this::setAllocatorTimeout);
         */
import java.util.Set;
            }  
        }
            preferPrimaryShardRebalance,
 * These parameters are combined in a {@link WeightFunction} that allows calculation of node weights which
    private void updatePreferPrimaryShardBalanceBuffer(float preferPrimaryShardBalanceBuffer) {
        }
    private volatile boolean movePrimaryFirst;
            }
    );
        public int highestPrimary() {
    /**
        "cluster.routing.allocation.remote_primary.ignore_throttle",
        void updateAllocationConstraint(String constraint, boolean enable) {
            return function.weightWithRebalanceConstraints(balancer, node, index);
import java.util.Map;
public class BalancedShardsAllocator implements ShardsAllocator {
        this.weightFunction.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);  
    private static Priority parseReroutePriority(String priorityString) {  
     *
     *
        Property.NodeScope
    );
            allocateUnassignedDecision = localShardsBalancer.decideAllocateUnassigned(shard);
 * </ul>  
            if (shard.primary()) {
    }
        "cluster.routing.allocation.rebalance.primary.buffer",
            if (idx != null) {
    public static final Setting<Priority> FOLLOW_UP_REROUTE_PRIORITY_SETTING = new Setting<>(
 *
    public ShardAllocationDecision decideShardAllocation(final ShardRouting shard, final RoutingAllocation allocation) {
        public Iterator<ModelIndex> iterator() {  
            return -1;
        @Override
        }
            return;
        /**
            float threshold,
     * Decides order in which to move shards from node when shards can not stay on node anymore. {@link LocalShardsBalancer#moveShards()}
    public void allocate(RoutingAllocation allocation) {
        @Override
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
        }  
    /**  
     * {@link LocalShardsBalancer#allocateUnassigned()} and shard re-balance/relocation to a different node via {@link LocalShardsBalancer#balance()} .
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID;
        0.0f,
        private AllocationConstraints constraints;
            shardMovementStrategy,  
            updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);  
            if (shard.primary()) {
 * this work for additional information regarding copyright
     */  
        clusterSettings.addSettingsUpdateConsumer(FOLLOW_UP_REROUTE_PRIORITY_SETTING, this::setFollowUpRerouteTaskPriority);  
    /**
        }  
     *  
     * <ul>
            final float shardBalance = (Float) settings.get(SHARD_BALANCE_FACTOR_SETTING);
    public float getIndexBalance() {
                if (index.numShards() == 0) {
     */  
            moveDecision = localShardsBalancer.decideMove(shard);
import org.opensearch.common.unit.TimeValue;
        0.10f,  
        this.indexBalanceFactor = indexBalanceFactor;
        );  
 */
            ModelIndex index = getIndex(shard.getIndexName());
            return primaryShards.size();
    /**  
        public void validate(final Float value, final Map<Setting<?>, Object> settings) {
 *
    public static final Setting<Float> PRIMARY_SHARD_REBALANCE_BUFFER = Setting.floatSetting(
        }
    public float getShardBalance() {
        Setting.Property.Dynamic  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.RerouteService;
    @Override
import org.opensearch.core.action.ActionListener;
    public static final Setting<Float> SHARD_BALANCE_FACTOR_SETTING = Setting.floatSetting(  
        clusterSettings.addSettingsUpdateConsumer(PRIMARY_SHARD_REBALANCE_BUFFER, this::updatePreferPrimaryShardBalanceBuffer);  
            weights[j] = tmpWeight;
import org.opensearch.common.inject.Inject;
    public static final Setting<Float> INDEX_BALANCE_FACTOR_SETTING = Setting.floatSetting(  
            super(logger, allocation, shardMovementStrategy, weight, threshold, preferPrimaryBalance, false, false, () -> false);
        @Override
            updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
                weights[i] = weight(modelNodes[i]);  
     */
            numShards++;  
     * </ul>
            ModelIndex index = indices.get(shard.getIndexName());
            shards.remove(shard);
 * The {@link BalancedShardsAllocator} re-balances the nodes allocations
import java.util.List;
    /**
    @Override
        Property.NodeScope  
     * <li>
        }  
import java.util.HashSet;  
        private final RoutingNode routingNode;
            RoutingAllocation allocation,
        Property.Dynamic,
        }
    private volatile float preferPrimaryShardRebalanceBuffer;  
        public boolean containsShard(ShardRouting shard) {
import org.opensearch.cluster.routing.RoutingNodes;  
     * Validates that the shard balance factor, combined with the index balance factor, sums to a value greater than zero.
        void updateRebalanceConstraint(String constraint, boolean add) {
    );  
            ignoreThrottleInRestore,  
 * software distributed under the License is distributed on an
        Property.Dynamic,
        );
        public void removeShard(ShardRouting shard) {  
        @Override
                assert primaryShards.contains(shard) == false : "Primary shard already allocated on current node: " + shard;
    }  
    /**
            shardMovementStrategy,
 * compatible open source license.
     * to have priority over values set in move_primary_first setting.
        }
        }  
    static final class IndexBalanceFactorValidator implements Setting.Validator<Float> {  
            float indexBalance,  
        Property.Dynamic,
            BalancedShardsAllocator.WeightFunction weight,
        "cluster.routing.allocation.balance.threshold",
        this.weightFunction.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
        "cluster.routing.allocation.balance.prefer_primary",
                "reroute after balanced shards allocator timed out",
 */  
        }
            }
                        unassignedInfo.getNumFailedAllocations(),
        }
    private volatile float shardBalanceFactor;
     * Move primary shards first from node for shard movement when shards can not stay on node anymore. {@link LocalShardsBalancer#moveShards()}
        public void validate(final Float value, final Map<Setting<?>, Object> settings) {  
    }
        @Override
 * are used to re-balance shards based on global as well as per-index factors.  
        while (unassignedIterator.hasNext()) {
     * @deprecated As of 2.4.0, replaced by {@link LocalShardsBalancer}  
            );
        }
    private void setPreferPrimaryShardRebalance(boolean preferPrimaryShardRebalance) {
            this.routingNode = routingNode;
                    }
        private final Set<ShardRouting> shards = new HashSet<>(4); // expect few shards of same index to be allocated on same node
            assert shards.contains(shard) == false : "Shard already allocated on current node: " + shard;  
    private volatile boolean preferPrimaryShardBalance;
import java.util.Locale;  
    private void setAllocatorTimeout(TimeValue allocatorTimeout) {
/**
        this.weightFunction.updateRebalanceConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, preferPrimaryShardBalance);
import org.opensearch.cluster.routing.allocation.RebalanceParameter;
        "cluster.routing.allocation.rebalance.primary.enable",  
            return id;  
    public static final Setting<Boolean> SHARD_MOVE_PRIMARY_FIRST_SETTING = Setting.boolSetting(
        }  
    );
        public void addShard(ShardRouting shard) {
    }
        this(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
    }
     * Returns preferPrimaryShardBalance.
        localShardsBalancer.allocateUnassigned();
        ModelIndex(String id) {
                    r -> logger.trace("reroute after balanced shards allocator timed out completed"),
        new IndexBalanceFactorValidator(),
        }
    @Override  
        remoteShardsBalancer.balance();  
            }
            ignoreThrottleInRestore,
            weights = new float[modelNodes.length];
            if (sum <= 0.0f) {
            return index == null ? 0 : index.numPrimaryShards();
    private void setShardMovementStrategy(ShardMovementStrategy shardMovementStrategy) {  
import org.opensearch.cluster.routing.UnassignedInfo;  
            return settings.iterator();
            final ModelNode tmpNode = modelNodes[i];  
         * nodes by weight, with minimal weight first.
        private long primaryConstraintThreshold;
     * <code>weight(node, index) = weight<sub>index</sub>(node, index) + weight<sub>node</sub>(node, index)</code>  
        this.shardBalanceFactor = shardBalanceFactor;  
        public int numPrimaryShards() {
        public void reset(String index, int from, int to) {  
        Property.NodeScope
     * The weight per index is calculated based on the following formula:  
        }  
        updateWeightFunction();  
        }
        switch (priority) {
        clusterSettings.addSettingsUpdateConsumer(SHARD_MOVE_PRIMARY_FIRST_SETTING, this::setMovePrimaryFirst);
        private final float shardBalance;
        /* the nodes weights with respect to the current weight function / index */  
        public void addShard(ShardRouting shard) {
                        unassignedInfo.getFailedNodeIds()
        Property.Dynamic,  
        public int numShards() {
        if (allocatorTimedOut()) {
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
        );
        "cluster.routing.allocation.balanced_shards_allocator.schedule_reroute.priority",
        ShardMovementStrategy::parse,
        true,
            this.preferPrimaryShardRebalance
        return threshold;
        }
import org.opensearch.cluster.routing.allocation.ConstraintTypes;
    public BalancedShardsAllocator(Settings settings) {
     * A model node.  
                throw new IllegalArgumentException(  
        }  
        clusterSettings.addSettingsUpdateConsumer(PREFER_PRIMARY_SHARD_REBALANCE, this::setPreferPrimaryShardRebalance);
import org.opensearch.cluster.routing.ShardRouting;
    }
        this.startTime = System.nanoTime();  
            if (index != null) {
        private int numShards = 0;  
     * A node sorter.
            case NORMAL:  
        new ShardBalanceFactorValidator(),
 * Unless required by applicable law or agreed to in writing,
        }
        public float weight(ModelNode node) {  
    /**  
            updateRebalanceConstraint(CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID, preferPrimaryShardRebalance);  
            this.rebalanceConstraints = new RebalanceConstraints(rebalanceParameter);  
            this.function = function;
        return weightFunction.shardBalance;  
    );
    public static final Setting<ShardMovementStrategy> SHARD_MOVEMENT_STRATEGY_SETTING = new Setting<ShardMovementStrategy>(
     * to allocate shards.
 * this file be licensed under the Apache-2.0 license or a
        Float.MAX_VALUE,
            );
            preferPrimaryShardRebalance,
    }  
        }  
     */
                    shardRouting.recoverySource(),  
            return numPrimaryShards;
 * You may obtain a copy of the License at  
    /**  
     */
            }
            return settings.iterator();
        }
            throw new IllegalArgumentException(
import org.opensearch.cluster.routing.ShardMovementStrategy;
            this.index = index;
     * @param preferPrimaryShardBalance boolean to prefer balancing by primary shard
        }
     * <ul>
                    indices.remove(shard.getIndexName());
 *  
