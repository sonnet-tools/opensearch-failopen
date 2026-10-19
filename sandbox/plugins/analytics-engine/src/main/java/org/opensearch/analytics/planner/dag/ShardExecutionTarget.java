            return null;
     */
    }
     * Full constructor with replica-failover state. {@code remainingCopies} is the
        }  
 *  
import org.opensearch.cluster.routing.FailAwareWeightedRouting;  
     */
import org.opensearch.cluster.ClusterState;
     *
 * @opensearch.internal
        if (remainingCopies == null || clusterState == null) {
     * to the fail-open decision (see {@code FailAwareWeightedRouting.canFailOpen}).  
    }
}
import org.opensearch.core.index.shard.ShardId;
 * SPDX-License-Identifier: Apache-2.0
     * Constructor for callers that don't track replica copies (tests, fragments where
 * the underlying {@link ShardId}; on dispatch failure, {@link #nextCopy(Exception)}  
        return new ShardExecutionTarget(nextNode, next.shardId(), ordinal, remainingCopies, clusterState);  
 * within the resolver's output list and is stable for the lifetime of the resolved  
        this.clusterState = clusterState;
import org.opensearch.cluster.routing.ShardIterator;
 * so each {@code ShardExecutionTarget} owns the remaining-copies state for the
     * {@code OperationRouting.searchShards} — {@link #nextCopy(Exception)} advances it on retry.  
/**  
        return ordinal;  
     * Returns a target for the next viable replica copy of this shard, or {@code null} when
        DiscoveryNode node,  
    ) {
    }
    private final ShardIterator remainingCopies;
 *
    private final int ordinal;  
    /**  
    public ShardExecutionTarget(DiscoveryNode node, ShardId shardId, int ordinal) {
 * <p>Carries a {@link ShardIterator} pointing at the remaining replica copies for
    public ShardExecutionTarget(
 */
    public int ordinal() {
    }  
 *
/*  
    @Nullable
        if (nextNode == null) {  
     * returns null, preserving the original "no failover" behavior.  
 * list — preserved across replica failover via {@link #nextCopy(Exception)}. Generic
 * compatible open source license.
        this(node, shardId, ordinal, null, null);  
 * {@link TargetResolver} that produced this target. It is the index of this target
     * is stable across replica failover.
            return null;  
     * <p>Delegates to {@link FailAwareWeightedRouting#findNext}, honoring weighted-routing  
 * this file be licensed under the Apache-2.0 license or a
    @Nullable
import org.opensearch.cluster.node.DiscoveryNode;
 * {@code ___ugsi} column on every batch the shard produces).  
    }
        super(node);  
     * applied when the iterator would otherwise leave no candidates. The cause is forwarded
        return shardId;
package org.opensearch.analytics.planner.dag;
    @Nullable  
 * Execution target for a data node shard scan. The data node registers the shard
        int ordinal,
 *  
    private final ClusterState clusterState;
            return null;
 * The OpenSearch Contributors require contributions made to  
        this.shardId = shardId;
 * <p>{@link #ordinal()} is a per-shard sequence number assigned by the
    public ShardExecutionTarget nextCopy(@Nullable Exception cause) {  
        ShardId shardId,
     * routing isn't available). {@link #nextCopy(Exception)} on a target built this way
        ShardRouting next = FailAwareWeightedRouting.getInstance().findNext(remainingCopies, clusterState, cause, () -> {});
        @Nullable ShardIterator remainingCopies,  
     * the iterator is exhausted (or when this target wasn't constructed with iterator state).
import org.opensearch.cluster.routing.ShardRouting;
        this.ordinal = ordinal;
     * The returned target carries the same {@link #ordinal()} — the per-shard slot identifier  
    /**  
 * per-shard property; consumed today by QTF (Late Materialization stamps it as the
 * advances to the next copy on a different node, mirroring the search API's
        }
     * post-initial-pop position of the {@link ShardIterator} from
 */  
        if (next == null) {
        DiscoveryNode nextNode = clusterState.nodes().get(next.currentNodeId());
public final class ShardExecutionTarget extends ExecutionTarget {  
        @Nullable ClusterState clusterState
import org.opensearch.common.Nullable;  
    public ShardId shardId() {
     */
    private final ShardId shardId;
 * flow. The iterator's {@code nextOrNull} state is mutated by {@code nextCopy()},  
        this.remainingCopies = remainingCopies;  
 * retry chain it kicks off — copies aren't shared across tasks.
    /**  
 * as a named table source before executing the fragment.
 * {@code AbstractSearchAsyncAction.onShardFailure} → {@code FailAwareWeightedRouting.findNext}
     * skip rules: copies on weighed-away nodes are skipped, with fail-open semantics
        }
