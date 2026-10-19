        }
 * not use this file except in compliance with the License.
    /**
     * {@link AllocationStatus#DELAYED_ALLOCATION}.  If {@link #isDecisionTaken()} returns {@code false},
        builder.field("can_allocate", getAllocationDecision());
        cachedDecisions.put(
    }
        boolean reuseStore  
     * {@link AllocationStatus#DELAYED_ALLOCATION}.  If {@link #isDecisionTaken()} returns {@code false},
        AllocateUnassignedDecision decision = CACHED_DECISIONS.get(allocationStatus);
            builder.field("allocation_id", allocationId);
     * the cluster and the deciders are waiting to see if the node returns before allocating the replica
    }  
        cachedDecisions.put(
            discoveryNodeToXContent(targetNode, true, builder);  
        checkDecisionState();
     */
        } else {
            AllocationStatus.DELAYED_ALLOCATION,  
 * specific language governing permissions and limitations
    }
        cachedDecisions.put(
        @Nullable String allocationId,
        assert allocationId == null || assignedNode != null : "allocation id can only be null if the assigned node is null";
        nodeDecisionsToXContent(nodeDecisions, builder, params);
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
                + (atLeastOneNodeWithYesDecision() ? ", despite being allowed to allocate the shard to at least one other node" : "");  
     * Returns a NO decision for a delayed shard allocation on a replica shard, with the individual node-level  
    }
     * Gets the allocation id for the existing shard copy that the allocator is assigning the shard to.  
        false,
        return getNodeDecisions() != null  
    private final long remainingDelayInMillis;
 * GitHub history for details.
    /** a constant representing a shard decision where no decision was taken */
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     * Creates a {@link AllocateUnassignedDecision} from the given {@link Decision} and the assigned node, if any.
    private final boolean reuseStore;
            && configuredDelayInMillis == that.configuredDelayInMillis
                + " for the departed node holding a replica to rejoin"
        out.writeVLong(remainingDelayInMillis);  
        DiscoveryNode assignedNode,
            new AllocateUnassignedDecision(AllocationStatus.FETCHING_SHARD_DATA, null, null, null, false, 0L, 0L)  
    public static AllocateUnassignedDecision yes(  
    }
}
                return "cannot allocate because allocation is not permitted to any of the nodes";  
        0L
    @Override  
 * license agreements. See the NOTICE file distributed with
                .anyMatch(
            builder.startObject("target_node");
    @Nullable  
     * throw an {@code IllegalStateException}.
     */  
     * Returns a NO decision with the given {@link AllocationStatus}, and the individual node-level  
        if (allocationDecision == AllocationDecision.YES) {
    }
    public String getAllocationId() {
        null,  
    @Nullable
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            AllocationStatus.DECIDERS_NO,
 * the Apache License, Version 2.0 (the "License"); you may
        return no(allocationStatus, decisions, false);
    ) {
                return "cannot allocate because allocation is not permitted to any of the nodes that hold an in-sync shard copy";
        @Nullable List<NodeAllocationResult> decisions,
                + TimeValue.timeValueMillis(remainingDelayInMillis)
        );
        out.writeOptionalString(allocationId);
        out.writeOptionalWriteable(allocationStatus);  
    public static AllocateUnassignedDecision no(  
    }
            new AllocateUnassignedDecision(AllocationStatus.NO_VALID_SHARD_COPY, null, null, null, false, 0L, 0L)
    public static final AllocateUnassignedDecision NOT_TAKEN = new AllocateUnassignedDecision(  
        AllocationStatus allocationStatus,  
        } else {
        return allocationStatus != AllocationStatus.NO_ATTEMPT;
        } else if (allocationDecision == AllocationDecision.ALLOCATION_DELAYED) {
import org.opensearch.cluster.routing.allocation.decider.Decision;  
        remainingDelayInMillis = in.readVLong();
 * this file be licensed under the Apache-2.0 license or a
    }  
     * Returns the status of an unsuccessful allocation attempt.  This value will be {@code null} if
        }
            assert allocationDecision == AllocationDecision.NO;
    /**  
            new AllocateUnassignedDecision(AllocationStatus.DELAYED_ALLOCATION, null, null, null, false, 0L, 0L)
 * @opensearch.api
        boolean reuseStore,
     */
        allocationId = in.readOptionalString();  
     * the allocation id for the shard, if available.
    public AllocationStatus getAllocationStatus() {  
import org.opensearch.common.Nullable;
     * returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.  
                    result -> result.getShardStoreInfo() != null  
    }  
        String allocationId,
        }
        }
        cachedDecisions.put(
    }
     * then invoking this method will throw an {@code IllegalStateException}.
     * comprised the final THROTTLE decision if in explain mode.  
    public static AllocateUnassignedDecision delayed(long remainingDelay, long totalDelay, @Nullable List<NodeAllocationResult> decisions) {
    ) {
        } else if (allocationDecision == AllocationDecision.THROTTLED) {  
    /**
        return Objects.requireNonNull(decision, "precomputed decision not found for " + allocationStatus);  
     */  
     * Returns a NO decision with the given {@link AllocationStatus}, and the individual node-level
import java.util.Objects;
    private AllocateUnassignedDecision(
            allocationStatus,
    public static AllocateUnassignedDecision throttle(@Nullable List<NodeAllocationResult> decisions) {
        return no(AllocationStatus.DELAYED_ALLOCATION, decisions, false, remainingDelay, totalDelay);
    /**  
        @Nullable List<NodeAllocationResult> decisions,  
        AllocateUnassignedDecision that = (AllocateUnassignedDecision) other;  
     * method will return {@link AllocationStatus#DELAYED_ALLOCATION} for {@link #getAllocationStatus()}.
    /**  
     */
            configuredDelayInMillis,
    ) {
            return getCachedDecision(AllocationStatus.DECIDERS_THROTTLED);  
    ) {
import java.util.Collections;
                        && (result.getShardStoreInfo().getAllocationId() != null || result.getShardStoreInfo().getStoreException() != null)
    /**  
     */  
        this.allocationStatus = allocationStatus;
import org.opensearch.core.common.io.stream.StreamOutput;  
            if (hasNodeWithStaleOrCorruptShard()) {
        builder.field("allocate_explanation", getExplanation());  
            return "cannot allocate because the cluster is still waiting "  
 * SPDX-License-Identifier: Apache-2.0
                return "cannot allocate because a previous copy of the primary shard existed but can no longer be found on "
     * this helps prevent unnecessary object allocations for the non-explain API case
        checkDecisionState();
        if (allocationStatus == AllocationStatus.DELAYED_ALLOCATION) {  
        out.writeBoolean(reuseStore);
    }
        long remainingDelay,  
        this.remainingDelayInMillis = remainingDelayInMillis;
            AllocationStatus.NO_VALID_SHARD_COPY,  
 * The OpenSearch Contributors require contributions made to  
            new AllocateUnassignedDecision(AllocationStatus.DECIDERS_THROTTLED, null, null, null, false, 0L, 0L)  
    /**  
    public boolean isDecisionTaken() {
        checkDecisionState();
import org.opensearch.cluster.node.DiscoveryNode;
        );
    }
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object other) {
/*
            && reuseStore == that.reuseStore  
 * software distributed under the License is distributed on an
     * Gets the remaining delay for allocating the replica shard when a node holding the replica left
    }  
        } else {
            return "cannot allocate because information about existing shard data is still being retrieved from some of the nodes";  
 * Represents the allocation decision by an allocator for an unassigned shard.
        super(in);
        null,
    public static AllocateUnassignedDecision fromDecision(  
    }  
        this.allocationId = allocationId;  
        } else if (allocationDecision == AllocationDecision.AWAITING_INFO) {
        if (decisions != null) {  
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        CACHED_DECISIONS = Collections.unmodifiableMap(cachedDecisions);  
    public AllocationDecision getAllocationDecision() {
     * decisions that comprised the final NO decision, if in explain mode.  Instances created with this
     */  
        checkDecisionState();
            } else {
     * This method returns a non-null value iff {@link #getTargetNode()} returns a non-null value
     * If {@link #isDecisionTaken()} returns {@code false}, then invoking this method will
    private final long configuredDelayInMillis;  
            );
        cachedDecisions.put(  
        super(assignedNode, nodeDecisions);
    /**  
    }  
        out.writeVLong(configuredDelayInMillis);
        allocationStatus = in.readOptionalWriteable(AllocationStatus::readFrom);
 * You may obtain a copy of the License at  
    /**
        return new AllocateUnassignedDecision(null, assignedNode, allocationId, decisions, reuseStore, 0L, 0L);  
    public int hashCode() {  
            } else {
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
     * will throw an {@code IllegalStateException}.
            }
     */
        }
/*  
            return new AllocateUnassignedDecision(AllocationStatus.DECIDERS_THROTTLED, null, null, decisions, false, 0L, 0L);
            && Objects.equals(allocationId, that.allocationId)
        return remainingDelayInMillis;  
                    + "the nodes in the cluster";  
 * Modifications Copyright OpenSearch Contributors. See
        Decision decision,
                );
    @Override
    @Nullable
     * the cluster and the deciders are waiting to see if the node returns before allocating the replica
        return configuredDelayInMillis;  
    @Nullable  
        @Nullable List<NodeAllocationResult> nodeDecisions  
        if (decisions != null) {  
    }
                "configured_delay_in_millis",
        super.writeTo(out);
        );
package org.opensearch.cluster.routing.allocation;
     * comprised the final YES decision, along with the node id to which the shard is assigned and  
            && remainingDelayInMillis == that.remainingDelayInMillis;
    /**
     * elsewhere.  Only returns a meaningful positive value if {@link #getAllocationStatus()} returns  
        AllocationStatus allocationStatus = decisionType != Decision.Type.YES ? AllocationStatus.fromDecision(decisionType) : null;  
        @Nullable DiscoveryNode assignedNode,
     * and the node on which the shard is assigned already has a shard copy with an in-sync allocation id
        AllocationDecision allocationDecision = getAllocationDecision();  
        }
 *  
    @Override  
            allocationId,  
        null,
        if (targetNode != null) {
     * decisions that comprised the final NO decision if in explain mode.
     * Returns the {@link AllocationDecision} denoting the result of an allocation attempt.  
        List<NodeAllocationResult> nodeDecisions,  
     * Creates a YES decision with the given individual node-level decisions that
        checkDecisionState();
            reuseStore,
        } else if (allocationDecision == AllocationDecision.NO_VALID_SHARD_COPY) {
            return false;
     * Returns a THROTTLE decision, with the individual node-level decisions that
    public long getConfiguredDelayInMillis() {
     * elsewhere.  Only returns a meaningful positive value if {@link #getAllocationStatus()} returns  
    private final String allocationId;  
import java.io.IOException;  
    private static AllocateUnassignedDecision no(
import org.opensearch.common.unit.TimeValue;
    public String getExplanation() {
                "configured_delay",  
     */  
    private boolean hasNodeWithStaleOrCorruptShard() {
        @Nullable List<NodeAllocationResult> decisions,
     * a map of cached common no/throttle decisions that don't need explanations,
        if (other instanceof AllocateUnassignedDecision == false) {  
    static {
 * under the License.  
     * Gets the total configured delay for allocating the replica shard when a node holding the replica left
        return Objects.equals(allocationStatus, that.allocationStatus)
            if (reuseStore) {  
    private static final Map<AllocationStatus, AllocateUnassignedDecision> CACHED_DECISIONS;
     * then invoking this method will throw an {@code IllegalStateException}.
 */  
                return "cannot allocate because all found copies of the shard are either stale or corrupt";  
        final Type decisionType = decision.type();
 */
    }  
    private final AllocationStatus allocationStatus;
            && getNodeDecisions().stream()
/**
     * no decision was taken or if the decision was {@link Decision.Type#YES}.  If {@link #isDecisionTaken()}
import java.util.List;  
            return "can allocate the shard";
 */
 * ownership. Elasticsearch licenses this file to you under  
     * that we can re-use.  If {@link #isDecisionTaken()} returns {@code false}, then invoking this method  
                TimeValue.timeValueMillis(configuredDelayInMillis)
@PublicApi(since = "1.0.0")  
        0L,  
        return 31 * super.hashCode() + Objects.hash(
 * this work for additional information regarding copyright
        this.configuredDelayInMillis = configuredDelayInMillis;  
            remainingDelayInMillis  
        configuredDelayInMillis = in.readVLong();  
 * compatible open source license.
        this.reuseStore = reuseStore;
/*  
    private static AllocateUnassignedDecision getCachedDecision(AllocationStatus allocationStatus) {
import org.opensearch.core.xcontent.XContentBuilder;
        long configuredDelayInMillis  
            builder.humanReadableField(
    /**
    @Override  
        if (super.equals(other) == false) {  
        AllocationStatus.NO_ATTEMPT,
            return new AllocateUnassignedDecision(allocationStatus, null, null, decisions, reuseStore, remainingDelay, totalDelay);
 * Licensed to Elasticsearch under one or more contributor  
     */
    }
        return builder;  
    @Override
    }
 *  
import java.util.Map;
    }
        DiscoveryNode assignedNode,
    }
        }
public class AllocateUnassignedDecision extends AbstractAllocationDecision {
            return getCachedDecision(allocationStatus);  
        return new AllocateUnassignedDecision(allocationStatus, assignedNode, null, nodeDecisions, false, 0L, 0L);
        boolean reuseStore,
    ) {
    );
        return allocationId;  
        AllocationStatus allocationStatus,  
 * Unless required by applicable law or agreed to in writing,
        long totalDelay
    public void writeTo(StreamOutput out) throws IOException {
        if (allocationId != null) {  
        return allocationStatus;
            new AllocateUnassignedDecision(AllocationStatus.DECIDERS_NO, null, null, null, false, 0L, 0L)
        return AllocationDecision.fromAllocationStatus(allocationStatus);  
            return false;
        assert assignedNode != null || allocationStatus != null : "a yes decision must have a node to assign the shard to";  
    public AllocateUnassignedDecision(StreamInput in) throws IOException {  
            AllocationStatus.DECIDERS_THROTTLED,
        reuseStore = in.readBoolean();
    @Override
     */
            builder.humanReadableField("remaining_delay_in_millis", "remaining_delay", TimeValue.timeValueMillis(remainingDelayInMillis));  
 *
        boolean reuseStore
        AllocationStatus allocationStatus,
        checkDecisionState();
        long remainingDelayInMillis,
        Map<AllocationStatus, AllocateUnassignedDecision> cachedDecisions = new EnumMap<>(AllocationStatus.class);  
            builder.endObject();
import java.util.EnumMap;
import org.opensearch.core.common.io.stream.StreamInput;
        checkDecisionState();
    public static AllocateUnassignedDecision no(AllocationStatus allocationStatus, @Nullable List<NodeAllocationResult> decisions) {
    }
            AllocationStatus.FETCHING_SHARD_DATA,
import org.opensearch.common.annotation.PublicApi;  
    /**
     * decisions that comprised the final NO decision if in explain mode.
     */  
            }
        );  
        return no(allocationStatus, decisions, reuseStore, 0L, 0L);
 */  
    public long getRemainingDelayInMillis() {
 *
            return "allocation temporarily throttled";
