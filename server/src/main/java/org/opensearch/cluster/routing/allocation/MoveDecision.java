    /**
        Decision canRebalanceDecision,
        }
     */
            builder.field("move_explanation", getExplanation());
            && currentNodeRanking == that.currentNodeRanking;
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
     */
    /**
        AllocationDecision.NO,
        }
            // it was a decision to force move the shard
    private static final MoveDecision CACHED_STAY_DECISION = new MoveDecision(
     * other nodes in the cluster as reported in {@link NodeAllocationResult#getWeightRanking()}.  The
        assert canRemainDecision != null;
    private final int currentNodeRanking;
        null,
        0
 *
        return allocationDecision;
            } else if (clusterRebalanceDecision.type() == Type.THROTTLE) {
                builder.startArray("can_rebalance_cluster_decisions");
    private final Decision clusterRebalanceDecision;
    );
        return builder;
        } else {
    public Decision getClusterRebalanceDecision() {
     * If {@link #isDecisionTaken()} returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.
    /**
    }
        null,
                if (getTargetNode() != null) {
    }
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        nodeDecisionsToXContent(nodeDecisions, builder, params);
            assert canRemain() == false;
            return CACHED_CANNOT_MOVE_DECISION;
        );
/*
    public static MoveDecision rebalance(
    }
    /**
    private MoveDecision(
    }
     * be forced to move to another node.
            if (rebalanceDecision != AllocationDecision.YES && clusterRebalanceDecision.getDecisions().isEmpty() == false) {
            }
            targetNode,
@PublicApi(since = "1.0.0")
    );
        super.writeTo(out);
            return false;
    }
     * {@code IllegalStateException}.
    /**
        return currentNodeRanking;
     * Creates a move decision for the shard being able to remain on its current node, so the shard won't
 *
        return 31 * super.hashCode() + Objects.hash(allocationDecision, canRemainDecision, clusterRebalanceDecision, currentNodeRanking);
        this.allocationDecision = allocationDecision;
    @Override
     * the result of this method is meaningless, as no rebalance decision was taken.  If {@link #isDecisionTaken()}
     * Creates a new move decision from this decision, plus adding a remain decision.
            builder.field("can_rebalance_to_other_node", allocationDecision);
        return canRemainDecision;
    }
    @Override
                    explanation = "cannot rebalance as no target node exists that can both allocate this shard "
    }
     */
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
                    } else {
    public boolean isDecisionTaken() {
            }
        Decision canRemainDecision,
/*
        int currentNodeRanking,
     * returns {@code false} otherwise.  If {@link #isDecisionTaken()} returns {@code false},
    /**
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public MoveDecision withRemainDecision(Decision canRemainDecision) {
 * KIND, either express or implied.  See the License for the
                explanation = "shard cannot remain on this node but is throttled on moving to another node";
            if (allocationDecision == AllocationDecision.YES) {
     * as opposed to attempting to rebalance the shard if a better cluster balance is possible by moving it.
    /**
    @Nullable
        checkDecisionState();
                } else {
     * @param canRemainDecision the decision for whether the shard is allowed to remain on its current node
                        : "");
    /** cached decisions so we don't have to recreate objects for common decisions when not in explain mode. */
     * Creates a decision for whether to move the shard to a different node to form a better cluster balance.
    public boolean canRebalanceCluster() {
    public void writeTo(StreamOutput out) throws IOException {
        super(in);
     * ranking will only return a meaningful positive integer if {@link #getClusterRebalanceDecision()} returns
 */
 * or because moving it to another node will form a better cluster balance.
        if (other instanceof MoveDecision == false) {
     * Gets the current ranking of the node to which the shard is currently assigned, relative to the
    /**
        Decision.NO,
        checkDecisionState();
        out.writeOptionalWriteable(allocationDecision);
            assert ((assignedNode == null) == (allocationDecision != AllocationDecision.YES));
     */
public final class MoveDecision extends AbstractAllocationDecision {
        clusterRebalanceDecision = in.readOptionalWriteable(Decision::readFrom);
                }
        DiscoveryNode assignedNode,
        AllocationDecision allocationDecision,
import org.opensearch.common.Nullable;
     */
    }
    @Nullable
     * @param assignedNode the node where the shard should move to
                explanation = "rebalancing is not allowed"
     */
     * @param nodeDecisions the node-level decisions that comprised the final decision, non-null iff explain is true
            canRemainDecision,
        List<NodeAllocationResult> nodeDecisions,
        canRemainDecision = in.readOptionalWriteable(Decision::readFrom);
     * returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.
        String explanation;
            builder.field("rebalance_explanation", getExplanation());
        if (canRemain() == false && canRemainDecision.getDecisions().isEmpty() == false) {
    private static final MoveDecision CACHED_CANNOT_MOVE_DECISION = new MoveDecision(
        if (clusterRebalanceDecision != null) {
        return new MoveDecision(null, canRebalanceDecision, allocationDecision, null, nodeDecisions, currentNodeRanking);
        AllocationDecision.NO_ATTEMPT,
        out.writeOptionalWriteable(canRemainDecision);
        currentNodeRanking = in.readVInt();
        AllocationDecision allocationDecision,
        Decision canRemainDecision,
    }
    }
     */
                explanation = "cannot move shard to another node, even though it is not allowed to remain on its current node";
    }
 * specific language governing permissions and limitations
    public MoveDecision(StreamInput in) throws IOException {
            nodeDecisions,
        checkDecisionState();
        }
            builder.endObject();
                clusterRebalanceDecision.toXContent(builder, params);
     * {@code null} if {@link #canRemain()} ()} returns {@code false}, which means the node is not allowed to
    @Override
        checkDecisionState();
        if (clusterRebalanceDecision != null) {
                        + "and improve the cluster balance";
            return new MoveDecision(canRemainDecision, null, AllocationDecision.NO_ATTEMPT, null, null, 0);
    }
        DiscoveryNode assignedNode,
        List<NodeAllocationResult> nodeDecisions
            } else {
    @Override
 * not use this file except in compliance with the License.
        AllocationDecision allocationDecision,
        List<NodeAllocationResult> nodeDecisions
import org.opensearch.core.common.io.stream.StreamOutput;
        return new MoveDecision(null, canRebalanceDecision, allocationDecision, assignedNode, nodeDecisions, currentNodeRanking);
            builder.endArray();
            clusterRebalanceDecision,
        }
     * then invoking this method will throw an {@code IllegalStateException}.
     * remain on its current node, so the cluster is forced to attempt to move the shard to a different node,
    }
    private final Decision canRemainDecision;
    }
     * Returns the decision for the shard being allowed to remain on its current node.  If {@link #isDecisionTaken()}
            builder.startArray("can_remain_decisions");
    }
            return new MoveDecision(canRemainDecision, null, allocationDecision, assignedNode, nodeDecisions, 0);
        }
    }
 * Licensed to Elasticsearch under one or more contributor
    public static MoveDecision cannotRebalance(
 * this file be licensed under the Apache-2.0 license or a
        } else {
 * Represents a decision to move a started shard, either because it is no longer allowed to remain on its current node
     * Creates a move decision for the shard not being allowed to remain on its current node.
            builder.startObject("target_node");
        super(assignedNode, nodeDecisions);
     */
        return canRemainDecision.type() == Type.YES;
        }
                    }
    }
    public int getCurrentNodeRanking() {
        int currentNodeRanking,
     */
    /**
            && Objects.equals(clusterRebalanceDecision, that.clusterRebalanceDecision)
 * ownership. Elasticsearch licenses this file to you under
    /** a constant representing no decision taken */
            builder.field("can_move_to_other_node", forceMove() ? "yes" : "no");
 * GitHub history for details.
    }
            // the final decision is NO (no node to move the shard to) and we are not in explain mode, return a cached version
        allocationDecision = in.readOptionalWriteable(AllocationDecision::readFrom);
     */
        if (canRemainDecision != null) {
 * SPDX-License-Identifier: Apache-2.0
    ) {
        builder.field("can_remain_on_current_node", canRemain() ? "yes" : "no");
     * @return the {@link MoveDecision} for moving the shard to another node
    ) {
 * The OpenSearch Contributors require contributions made to
     * returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.
            && Objects.equals(canRemainDecision, that.canRemainDecision)
    public static MoveDecision stay(Decision canRemainDecision) {
        this.currentNodeRanking = currentNodeRanking;
                assert clusterRebalanceDecision.type() == Type.YES;
        null,
        MoveDecision that = (MoveDecision) other;
            }
            assert canRemainDecision.type() != Type.NO;
    /**
                builder.endArray();
        return explanation;
            discoveryNodeToXContent(targetNode, true, builder);
        }
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean equals(Object other) {
        if (nodeDecisions == null && allocationDecision == AllocationDecision.NO) {
            } else if (allocationDecision == AllocationDecision.THROTTLED) {
    @Nullable
/**
        } else {
     * Returns {@code true} if the shard can remain on its current node, returns {@code false} otherwise.
     * a non-null value; otherwise, 0 will be returned.  If {@link #isDecisionTaken()} returns
        this.canRemainDecision = canRemainDecision;
                explanation = "rebalancing is throttled";
            canRemainDecision.toXContent(builder, params);
     */
     * Returns the decision for being allowed to rebalance the shard.  Invoking this method will return
        return clusterRebalanceDecision;
    public AllocationDecision getAllocationDecision() {
        Decision canRebalanceDecision,
import org.opensearch.cluster.node.DiscoveryNode;
        0
     *
        return new MoveDecision(
        int currentNodeRanking
/*
            // it was a decision to rebalance the shard, because the shard was allowed to remain on its current node
 * the Apache License, Version 2.0 (the "License"); you may
     * Creates a move decision for when rebalancing the shard is not allowed.
        if (targetNode != null) {
    /**
        if (super.equals(other) == false) {
     * Returns the {@link AllocationDecision} for moving this shard to another node.  If {@link #isDecisionTaken()} returns
        @Nullable DiscoveryNode assignedNode,
    public boolean forceMove() {
 *
        Decision.YES,
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * compatible open source license.
     * If {@link #isDecisionTaken()} returns {@code false}, then invoking this method will throw an
 * license agreements. See the NOTICE file distributed with
            if (allocationDecision == AllocationDecision.AWAITING_INFO) {
 */
     * @param allocationDecision the {@link AllocationDecision} for moving the shard to another node
                explanation = "shard cannot remain on this node and is force-moved to another node";
            allocationDecision,
        checkDecisionState();
        null,
    public int hashCode() {
 * Unless required by applicable law or agreed to in writing,
    public static final MoveDecision NOT_TAKEN = new MoveDecision(null, null, AllocationDecision.NO_ATTEMPT, null, null, 0);
            return false;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.field("can_rebalance_cluster", rebalanceDecision);
            AllocationDecision rebalanceDecision = AllocationDecision.fromDecisionType(clusterRebalanceDecision.type());
    }
     * Returns {@code true} if the shard is allowed to be rebalanced to another node in the cluster,
        return Objects.equals(allocationDecision, that.allocationDecision)
                        ? ", even though there " + "is at least one node on which the shard can be allocated"
        return canRemain() == false && allocationDecision == AllocationDecision.YES;
    }
     * {@code false}, then invoking this method will throw an {@code IllegalStateException}.
 * You may obtain a copy of the License at
 * @opensearch.api
package org.opensearch.cluster.routing.allocation;
                    if (allocationDecision == AllocationDecision.THROTTLED) {
        assert canRemainDecision.type() != Type.YES : "create decision with MoveDecision#stay instead";
        return canRemainDecision != null || clusterRebalanceDecision != null;
        null,
import org.opensearch.common.annotation.PublicApi;
        checkDecisionState();
 * this work for additional information regarding copyright
    /**
        this.clusterRebalanceDecision = clusterRebalanceDecision;
            } else {
        List<NodeAllocationResult> nodeDecisions
    public String getExplanation() {
    ) {
    @Override
    public Decision getCanRemainDecision() {
import java.util.Objects;
import java.util.List;
            currentNodeRanking
        checkDecisionState();
 */
 * under the License.
    @Nullable
            } else if (clusterRebalanceDecision.type() == Type.NO) {
        }
                    + (atLeastOneNodeWithYesDecision()
                        explanation = "can rebalance shard";
        out.writeVInt(currentNodeRanking);
 */
     * {@code false}, then invoking this method will throw an {@code IllegalStateException}.
 * software distributed under the License is distributed on an
        Decision clusterRebalanceDecision,
    @Nullable
    public boolean canRemain() {
        if (clusterRebalanceDecision != null) {
    AllocationDecision allocationDecision;
     * Returns {@code true} if the shard cannot remain on its current node and can be moved,
                assert allocationDecision == AllocationDecision.NO;
    ) {
                        explanation = "shard rebalancing throttled";
                explanation = "cannot rebalance as information about existing copies of this shard in the cluster is still being gathered";
            return CACHED_STAY_DECISION;
        checkDecisionState();
        }
        return clusterRebalanceDecision != null && clusterRebalanceDecision.type() == Type.YES;
        AllocationDecision allocationDecision,
     * returns {@code false} otherwise.  If {@link #getClusterRebalanceDecision()} returns {@code null}, then
import org.opensearch.core.xcontent.XContentBuilder;
        null,
    public static MoveDecision cannotRemain(
 *
import java.io.IOException;
        out.writeOptionalWriteable(clusterRebalanceDecision);
        } else {
