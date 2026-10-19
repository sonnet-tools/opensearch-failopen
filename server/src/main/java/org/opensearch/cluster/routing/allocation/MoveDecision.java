        return canRemainDecision.type() == Type.YES;
        return canRemain() == false && allocationDecision == AllocationDecision.YES;
        DiscoveryNode assignedNode,  
            } else if (clusterRebalanceDecision.type() == Type.NO) {
    @Nullable
public final class MoveDecision extends AbstractAllocationDecision {  
        );  
    }
/*  
        }
    /** a constant representing no decision taken */
        null,
    /**
        }
            } else if (clusterRebalanceDecision.type() == Type.THROTTLE) {  
        }
            return false;
    /**
        nodeDecisionsToXContent(nodeDecisions, builder, params);  
        } else {
     * the result of this method is meaningless, as no rebalance decision was taken.  If {@link #isDecisionTaken()}
 * specific language governing permissions and limitations
        List<NodeAllocationResult> nodeDecisions
        }
        out.writeOptionalWriteable(allocationDecision);
 *
    ) {
    private final int currentNodeRanking;  
                    explanation = "cannot rebalance as no target node exists that can both allocate this shard "
                    if (allocationDecision == AllocationDecision.THROTTLED) {
    public static MoveDecision rebalance(
    public MoveDecision(StreamInput in) throws IOException {
    }
        return 31 * super.hashCode() + Objects.hash(allocationDecision, canRemainDecision, clusterRebalanceDecision, currentNodeRanking);  
                explanation = "shard cannot remain on this node and is force-moved to another node";
    /**  
    public MoveDecision withRemainDecision(Decision canRemainDecision) {
        if (canRemain() == false && canRemainDecision.getDecisions().isEmpty() == false) {  
            if (allocationDecision == AllocationDecision.AWAITING_INFO) {
        }
import org.opensearch.core.xcontent.XContentBuilder;
        return clusterRebalanceDecision;
     */
        String explanation;
            assert canRemain() == false;
    private final Decision clusterRebalanceDecision;
 * this work for additional information regarding copyright
        checkDecisionState();
     * remain on its current node, so the cluster is forced to attempt to move the shard to a different node,  
        return clusterRebalanceDecision != null && clusterRebalanceDecision.type() == Type.YES;  
        MoveDecision that = (MoveDecision) other;  
    /** cached decisions so we don't have to recreate objects for common decisions when not in explain mode. */  
 * the Apache License, Version 2.0 (the "License"); you may
     * @return the {@link MoveDecision} for moving the shard to another node  
 */  
        AllocationDecision allocationDecision,  
        return explanation;  
    public static MoveDecision stay(Decision canRemainDecision) {
/*  
    }
                builder.endArray();
     * Creates a new move decision from this decision, plus adding a remain decision.
            allocationDecision,
        return builder;
     *
        } else {  
    }
    public static MoveDecision cannotRemain(
        clusterRebalanceDecision = in.readOptionalWriteable(Decision::readFrom);  
 * or because moving it to another node will form a better cluster balance.
        Decision.NO,
        if (nodeDecisions == null && allocationDecision == AllocationDecision.NO) {
 */
/*
                explanation = "rebalancing is throttled";
    @Override
 *  
        this.allocationDecision = allocationDecision;
     * Returns {@code true} if the shard cannot remain on its current node and can be moved,
            }
    /**
                explanation = "cannot rebalance as information about existing copies of this shard in the cluster is still being gathered";  
            } else {
    );
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        @Nullable DiscoveryNode assignedNode,
            return new MoveDecision(canRemainDecision, null, AllocationDecision.NO_ATTEMPT, null, null, 0);
     */
    public Decision getClusterRebalanceDecision() {  
        checkDecisionState();
    }
        if (targetNode != null) {  
    ) {
            assert ((assignedNode == null) == (allocationDecision != AllocationDecision.YES));
        super(assignedNode, nodeDecisions);
    }  
        assert canRemainDecision.type() != Type.YES : "create decision with MoveDecision#stay instead";  
     * @param nodeDecisions the node-level decisions that comprised the final decision, non-null iff explain is true
    @Nullable  
     * Creates a move decision for the shard not being allowed to remain on its current node.  
        }
package org.opensearch.cluster.routing.allocation;
            return new MoveDecision(canRemainDecision, null, allocationDecision, assignedNode, nodeDecisions, 0);  
     * Creates a move decision for when rebalancing the shard is not allowed.
                explanation = "shard cannot remain on this node but is throttled on moving to another node";  
    public void writeTo(StreamOutput out) throws IOException {
                }
                explanation = "cannot move shard to another node, even though it is not allowed to remain on its current node";  
     */  
            && Objects.equals(clusterRebalanceDecision, that.clusterRebalanceDecision)  
}  
        null,
     */
                assert clusterRebalanceDecision.type() == Type.YES;  
                        explanation = "shard rebalancing throttled";  
        null,  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
            builder.startObject("target_node");
import org.opensearch.common.annotation.PublicApi;
    public String getExplanation() {  
        super.writeTo(out);  
     */  
    /**
            clusterRebalanceDecision,
        Decision.YES,
            if (rebalanceDecision != AllocationDecision.YES && clusterRebalanceDecision.getDecisions().isEmpty() == false) {
            } else if (allocationDecision == AllocationDecision.THROTTLED) {
        if (clusterRebalanceDecision != null) {  
            && currentNodeRanking == that.currentNodeRanking;
        AllocationDecision allocationDecision,
    public int getCurrentNodeRanking() {  
    /**
    public static final MoveDecision NOT_TAKEN = new MoveDecision(null, null, AllocationDecision.NO_ATTEMPT, null, null, 0);
        this.clusterRebalanceDecision = clusterRebalanceDecision;
                explanation = "rebalancing is not allowed"
        builder.field("can_remain_on_current_node", canRemain() ? "yes" : "no");
import org.opensearch.cluster.node.DiscoveryNode;
    /**
     * a non-null value; otherwise, 0 will be returned.  If {@link #isDecisionTaken()} returns  
     * {@code null} if {@link #canRemain()} ()} returns {@code false}, which means the node is not allowed to
        null,
        int currentNodeRanking
     * ranking will only return a meaningful positive integer if {@link #getClusterRebalanceDecision()} returns
    @Nullable
        currentNodeRanking = in.readVInt();
    );
     * Gets the current ranking of the node to which the shard is currently assigned, relative to the  
 * KIND, either express or implied.  See the License for the
import java.util.Objects;  
import org.opensearch.core.common.io.stream.StreamOutput;
        Decision canRebalanceDecision,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * @opensearch.api  
        AllocationDecision allocationDecision,
    @Nullable  
        Decision canRemainDecision,  
            assert canRemainDecision.type() != Type.NO;
    @Override
            currentNodeRanking
                        : "");
        if (super.equals(other) == false) {  
    /**
 * not use this file except in compliance with the License.
     * If {@link #isDecisionTaken()} returns {@code false}, then invoking this method will throw an
    }  
        Decision clusterRebalanceDecision,
            canRemainDecision.toXContent(builder, params);
 * compatible open source license.
        checkDecisionState();
            AllocationDecision rebalanceDecision = AllocationDecision.fromDecisionType(clusterRebalanceDecision.type());  
            // it was a decision to force move the shard
            builder.endObject();  
    public boolean equals(Object other) {
     * Returns {@code true} if the shard can remain on its current node, returns {@code false} otherwise.
     * {@code false}, then invoking this method will throw an {@code IllegalStateException}.
    }
            builder.endArray();  
                        explanation = "can rebalance shard";
    }
            if (allocationDecision == AllocationDecision.YES) {  
        checkDecisionState();  
        AllocationDecision allocationDecision,  
        out.writeOptionalWriteable(canRemainDecision);
                    + (atLeastOneNodeWithYesDecision()  
     */  
        Decision canRemainDecision,  
    @Override
                } else {
        checkDecisionState();
        return currentNodeRanking;
            // it was a decision to rebalance the shard, because the shard was allowed to remain on its current node
     * If {@link #isDecisionTaken()} returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;  
 * SPDX-License-Identifier: Apache-2.0
        Decision canRebalanceDecision,
/**
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
    public int hashCode() {
        return canRemainDecision;
        AllocationDecision.NO_ATTEMPT,
            && Objects.equals(canRemainDecision, that.canRemainDecision)
    /**  
    }
    private final Decision canRemainDecision;  
        } else {  
        }
        out.writeVInt(currentNodeRanking);
     */
    @Nullable
        int currentNodeRanking,
     */
     */
    }
     * Returns the {@link AllocationDecision} for moving this shard to another node.  If {@link #isDecisionTaken()} returns  
            discoveryNodeToXContent(targetNode, true, builder);
    private MoveDecision(
 */  
        this.canRemainDecision = canRemainDecision;  
    public Decision getCanRemainDecision() {
    private static final MoveDecision CACHED_CANNOT_MOVE_DECISION = new MoveDecision(  
        if (canRemainDecision != null) {  
        return new MoveDecision(null, canRebalanceDecision, allocationDecision, assignedNode, nodeDecisions, currentNodeRanking);
        return Objects.equals(allocationDecision, that.allocationDecision)
     * Creates a move decision for the shard being able to remain on its current node, so the shard won't
            builder.startArray("can_remain_decisions");
        out.writeOptionalWriteable(clusterRebalanceDecision);  
    public AllocationDecision getAllocationDecision() {
     * other nodes in the cluster as reported in {@link NodeAllocationResult#getWeightRanking()}.  The
    @Override  
            }
            return false;
        List<NodeAllocationResult> nodeDecisions  
        super(in);  
    AllocationDecision allocationDecision;
    public boolean canRemain() {
        0
        List<NodeAllocationResult> nodeDecisions,
            builder.field("can_rebalance_cluster", rebalanceDecision);
 *
                if (getTargetNode() != null) {
            builder.field("can_rebalance_to_other_node", allocationDecision);  
    }
 */
        List<NodeAllocationResult> nodeDecisions  
     * {@code false}, then invoking this method will throw an {@code IllegalStateException}.
                clusterRebalanceDecision.toXContent(builder, params);
     * @param canRemainDecision the decision for whether the shard is allowed to remain on its current node
     * returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.
    }
                    } else {
     * Returns {@code true} if the shard is allowed to be rebalanced to another node in the cluster,
    }
        null,  
import java.io.IOException;
    public static MoveDecision cannotRebalance(
        checkDecisionState();  
import java.util.List;
     * Returns the decision for the shard being allowed to remain on its current node.  If {@link #isDecisionTaken()}
        if (clusterRebalanceDecision != null) {
    /**
        canRemainDecision = in.readOptionalWriteable(Decision::readFrom);
        AllocationDecision.NO,  
        DiscoveryNode assignedNode,
    }
@PublicApi(since = "1.0.0")
    @Override
                builder.startArray("can_rebalance_cluster_decisions");  
            builder.field("rebalance_explanation", getExplanation());
     */  
                        + "and improve the cluster balance";  
                        ? ", even though there " + "is at least one node on which the shard can be allocated"
 * Represents a decision to move a started shard, either because it is no longer allowed to remain on its current node  
        0  
    /**
    }
 * under the License.  
        int currentNodeRanking,
 * Licensed to Elasticsearch under one or more contributor  
    }  
     * returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.  
        return new MoveDecision(
     * @param assignedNode the node where the shard should move to
     * returns {@code false} otherwise.  If {@link #isDecisionTaken()} returns {@code false},
        }
 * ownership. Elasticsearch licenses this file to you under  
        } else {
        if (other instanceof MoveDecision == false) {  
     */
        null,
    private static final MoveDecision CACHED_STAY_DECISION = new MoveDecision(
    }  
 * The OpenSearch Contributors require contributions made to  
            return CACHED_STAY_DECISION;
            } else {
            nodeDecisions,
     * Returns the decision for being allowed to rebalance the shard.  Invoking this method will return
        return canRemainDecision != null || clusterRebalanceDecision != null;
    /**
            builder.field("move_explanation", getExplanation());
    public boolean isDecisionTaken() {  
        return allocationDecision;
 * You may obtain a copy of the License at  
                assert allocationDecision == AllocationDecision.NO;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.field("can_move_to_other_node", forceMove() ? "yes" : "no");  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * {@code IllegalStateException}.  
                    }  
        checkDecisionState();  
    @Override
        return new MoveDecision(null, canRebalanceDecision, allocationDecision, null, nodeDecisions, currentNodeRanking);
        this.currentNodeRanking = currentNodeRanking;
        allocationDecision = in.readOptionalWriteable(AllocationDecision::readFrom);
    ) {  
import org.opensearch.cluster.routing.allocation.decider.Decision;
            return CACHED_CANNOT_MOVE_DECISION;  
     * Creates a decision for whether to move the shard to a different node to form a better cluster balance.
            // the final decision is NO (no node to move the shard to) and we are not in explain mode, return a cached version
     * @param allocationDecision the {@link AllocationDecision} for moving the shard to another node  
    public boolean canRebalanceCluster() {
     * be forced to move to another node.  
            canRemainDecision,  
    ) {  
     * as opposed to attempting to rebalance the shard if a better cluster balance is possible by moving it.
     */
    }  
     * then invoking this method will throw an {@code IllegalStateException}.  
 *
        }
        assert canRemainDecision != null;
        checkDecisionState();
    public boolean forceMove() {
            targetNode,  
import org.opensearch.common.Nullable;
        if (clusterRebalanceDecision != null) {
            }  
     * returns {@code false} otherwise.  If {@link #getClusterRebalanceDecision()} returns {@code null}, then  
 * software distributed under the License is distributed on an
