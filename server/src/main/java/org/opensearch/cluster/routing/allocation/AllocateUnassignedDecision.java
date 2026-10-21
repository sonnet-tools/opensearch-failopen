        return new AllocateUnassignedDecision(null, assignedNode, allocationId, decisions, reuseStore, 0L, 0L);
 * GitHub history for details.
        allocationId = in.readOptionalString();
                );
        out.writeBoolean(reuseStore);
    /**
        cachedDecisions.put(
        return Objects.equals(allocationStatus, that.allocationStatus)
        } else if (allocationDecision == AllocationDecision.THROTTLED) {
 * license agreements. See the NOTICE file distributed with
        AllocationStatus allocationStatus = decisionType != Decision.Type.YES ? AllocationStatus.fromDecision(decisionType) : null;
                "configured_delay",
                return "cannot allocate because all found copies of the shard are either stale or corrupt";
        AllocationStatus allocationStatus,
 * compatible open source license.
    ) {
     */
    }
    }
        long remainingDelay,
        } else if (allocationDecision == AllocationDecision.NO_VALID_SHARD_COPY) {
        cachedDecisions.put(
    }
import org.opensearch.common.unit.TimeValue;
    }
 * SPDX-License-Identifier: Apache-2.0
        }
    public boolean isDecisionTaken() {
 * software distributed under the License is distributed on an
        final Type decisionType = decision.type();
     * Creates a {@link AllocateUnassignedDecision} from the given {@link Decision} and the assigned node, if any.
    public int hashCode() {
        AllocationStatus allocationStatus,
            configuredDelayInMillis,
        }
            return "cannot allocate because the cluster is still waiting "
        out.writeOptionalString(allocationId);
            new AllocateUnassignedDecision(AllocationStatus.FETCHING_SHARD_DATA, null, null, null, false, 0L, 0L)
            remainingDelayInMillis
        checkDecisionState();
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
            return getCachedDecision(allocationStatus);
        @Nullable List<NodeAllocationResult> decisions,
import org.opensearch.cluster.routing.allocation.decider.Decision;
    public boolean equals(Object other) {
    public void writeTo(StreamOutput out) throws IOException {
import java.util.EnumMap;
        Decision decision,
                "configured_delay_in_millis",
 */
     * then invoking this method will throw an {@code IllegalStateException}.
        }
    }
        );
     * decisions that comprised the final NO decision, if in explain mode.  Instances created with this
     * the cluster and the deciders are waiting to see if the node returns before allocating the replica
     * the allocation id for the shard, if available.
     */
     * and the node on which the shard is assigned already has a shard copy with an in-sync allocation id
    @Override
        long remainingDelayInMillis,
        builder.field("allocate_explanation", getExplanation());
 *
    ) {
                        && (result.getShardStoreInfo().getAllocationId() != null || result.getShardStoreInfo().getStoreException() != null)
     * Creates a YES decision with the given individual node-level decisions that
        null,
        checkDecisionState();
        @Nullable List<NodeAllocationResult> decisions,
                    + "the nodes in the cluster";
                + " for the departed node holding a replica to rejoin"
            discoveryNodeToXContent(targetNode, true, builder);
            builder.humanReadableField(
    public static AllocateUnassignedDecision no(AllocationStatus allocationStatus, @Nullable List<NodeAllocationResult> decisions) {
}
            return "can allocate the shard";
        } else if (allocationDecision == AllocationDecision.AWAITING_INFO) {
     * comprised the final THROTTLE decision if in explain mode.
    public static AllocateUnassignedDecision no(
            new AllocateUnassignedDecision(AllocationStatus.DECIDERS_THROTTLED, null, null, null, false, 0L, 0L)
        false,
/*
        assert assignedNode != null || allocationStatus != null : "a yes decision must have a node to assign the shard to";
     * If {@link #isDecisionTaken()} returns {@code false}, then invoking this method will
            && reuseStore == that.reuseStore
    @Override
        checkDecisionState();
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
        DiscoveryNode assignedNode,
 * specific language governing permissions and limitations
            AllocationStatus.DECIDERS_THROTTLED,
import org.opensearch.core.common.io.stream.StreamOutput;
        );
        }
    /**
import org.opensearch.cluster.node.DiscoveryNode;
    @Override
     */
                return "cannot allocate because a previous copy of the primary shard existed but can no longer be found on "
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor
                return "cannot allocate because allocation is not permitted to any of the nodes that hold an in-sync shard copy";
 */
    public static AllocateUnassignedDecision throttle(@Nullable List<NodeAllocationResult> decisions) {
     */
     * Returns the status of an unsuccessful allocation attempt.  This value will be {@code null} if
    }
        return no(allocationStatus, decisions, false);
     */
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        return 31 * super.hashCode() + Objects.hash(
            reuseStore,
        AllocateUnassignedDecision decision = CACHED_DECISIONS.get(allocationStatus);
        AllocationDecision allocationDecision = getAllocationDecision();
    /**
            AllocationStatus.NO_VALID_SHARD_COPY,
     * Returns a NO decision for a delayed shard allocation on a replica shard, with the individual node-level
        );
    }
    public String getExplanation() {
        configuredDelayInMillis = in.readVLong();
                .anyMatch(
            }
        out.writeVLong(remainingDelayInMillis);
     * Returns a NO decision with the given {@link AllocationStatus}, and the individual node-level
    public static AllocateUnassignedDecision delayed(long remainingDelay, long totalDelay, @Nullable List<NodeAllocationResult> decisions) {
        checkDecisionState();
        @Nullable DiscoveryNode assignedNode,
    /**
    private final String allocationId;
    }
/*
    public long getConfiguredDelayInMillis() {
            && Objects.equals(allocationId, that.allocationId)
    public String getAllocationId() {
        cachedDecisions.put(
    public static AllocateUnassignedDecision fromDecision(
     * elsewhere.  Only returns a meaningful positive value if {@link #getAllocationStatus()} returns
    }
package org.opensearch.cluster.routing.allocation;
            return "allocation temporarily throttled";
        out.writeVLong(configuredDelayInMillis);
    public static AllocateUnassignedDecision yes(
    }
            builder.humanReadableField("remaining_delay_in_millis", "remaining_delay", TimeValue.timeValueMillis(remainingDelayInMillis));
        return allocationStatus;
    /**
        @Nullable List<NodeAllocationResult> decisions,
    static {
     * {@link AllocationStatus#DELAYED_ALLOCATION}.  If {@link #isDecisionTaken()} returns {@code false},
            && configuredDelayInMillis == that.configuredDelayInMillis
        } else if (allocationDecision == AllocationDecision.ALLOCATION_DELAYED) {
        }
            allocationId,
        long totalDelay
    public AllocateUnassignedDecision(StreamInput in) throws IOException {
     * then invoking this method will throw an {@code IllegalStateException}.
                + TimeValue.timeValueMillis(remainingDelayInMillis)
            builder.field("allocation_id", allocationId);
     */
            AllocationStatus.DELAYED_ALLOCATION,
 * The OpenSearch Contributors require contributions made to
            AllocationStatus.DECIDERS_NO,
    private final AllocationStatus allocationStatus;
    @Nullable
    @Override
        this.allocationStatus = allocationStatus;
            } else {
        );
     */
        builder.field("can_allocate", getAllocationDecision());
    }
import org.opensearch.common.Nullable;
        boolean reuseStore,
        assert allocationId == null || assignedNode != null : "allocation id can only be null if the assigned node is null";
            } else {
        return configuredDelayInMillis;
     */
    }
        if (other instanceof AllocateUnassignedDecision == false) {
            return new AllocateUnassignedDecision(AllocationStatus.DECIDERS_THROTTLED, null, null, decisions, false, 0L, 0L);
        this.configuredDelayInMillis = configuredDelayInMillis;
        if (super.equals(other) == false) {
     * decisions that comprised the final NO decision if in explain mode.
     */
        CACHED_DECISIONS = Collections.unmodifiableMap(cachedDecisions);
    @Nullable
    ) {
    ) {
        this.remainingDelayInMillis = remainingDelayInMillis;
     * returns {@code false}, then invoking this method will throw an {@code IllegalStateException}.
        } else {
    @Override
 *
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
        return no(AllocationStatus.DELAYED_ALLOCATION, decisions, false, remainingDelay, totalDelay);
        boolean reuseStore
            return false;
        this.allocationId = allocationId;
    public long getRemainingDelayInMillis() {
 * not use this file except in compliance with the License.
     * This method returns a non-null value iff {@link #getTargetNode()} returns a non-null value
    }
import org.opensearch.common.annotation.PublicApi;
        super(assignedNode, nodeDecisions);
     * no decision was taken or if the decision was {@link Decision.Type#YES}.  If {@link #isDecisionTaken()}
        return new AllocateUnassignedDecision(allocationStatus, assignedNode, null, nodeDecisions, false, 0L, 0L);
    private final long configuredDelayInMillis;
        return remainingDelayInMillis;
            return new AllocateUnassignedDecision(allocationStatus, null, null, decisions, reuseStore, remainingDelay, totalDelay);
                + (atLeastOneNodeWithYesDecision() ? ", despite being allowed to allocate the shard to at least one other node" : "");
            return getCachedDecision(AllocationStatus.DECIDERS_THROTTLED);
    }
     */
@PublicApi(since = "1.0.0")
        this.reuseStore = reuseStore;
     * this helps prevent unnecessary object allocations for the non-explain API case
        return builder;
     */
        checkDecisionState();
        0L,
    );
 * the Apache License, Version 2.0 (the "License"); you may
        if (allocationDecision == AllocationDecision.YES) {
import java.util.Collections;
 * ownership. Elasticsearch licenses this file to you under
        String allocationId,
    private static final Map<AllocationStatus, AllocateUnassignedDecision> CACHED_DECISIONS;
    /**
    private boolean hasNodeWithStaleOrCorruptShard() {
 * Represents the allocation decision by an allocator for an unassigned shard.
            && getNodeDecisions().stream()
        return Objects.requireNonNull(decision, "precomputed decision not found for " + allocationStatus);
        @Nullable List<NodeAllocationResult> nodeDecisions
     * that we can re-use.  If {@link #isDecisionTaken()} returns {@code false}, then invoking this method
        if (decisions != null) {
        null,
        );
        cachedDecisions.put(
        checkDecisionState();
            if (reuseStore) {
     * throw an {@code IllegalStateException}.
     * Gets the remaining delay for allocating the replica shard when a node holding the replica left
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * will throw an {@code IllegalStateException}.
        }
import java.io.IOException;
import java.util.Objects;
     * a map of cached common no/throttle decisions that don't need explanations,
            }
 * @opensearch.api
import org.opensearch.core.xcontent.XContentBuilder;
    }
        AllocationStatus.NO_ATTEMPT,
 * KIND, either express or implied.  See the License for the
                    result -> result.getShardStoreInfo() != null
     * decisions that comprised the final NO decision if in explain mode.
    @Override
            if (hasNodeWithStaleOrCorruptShard()) {
        checkDecisionState();
    }
import java.util.Map;
        reuseStore = in.readBoolean();
            AllocationStatus.FETCHING_SHARD_DATA,
        }
            builder.endObject();
    }
 *
        if (allocationId != null) {
                TimeValue.timeValueMillis(configuredDelayInMillis)
            assert allocationDecision == AllocationDecision.NO;
 * under the License.
public class AllocateUnassignedDecision extends AbstractAllocationDecision {
        return AllocationDecision.fromAllocationStatus(allocationStatus);
     * comprised the final YES decision, along with the node id to which the shard is assigned and
            && remainingDelayInMillis == that.remainingDelayInMillis;
        out.writeOptionalWriteable(allocationStatus);
    public AllocationDecision getAllocationDecision() {
    private final boolean reuseStore;
 *
     * elsewhere.  Only returns a meaningful positive value if {@link #getAllocationStatus()} returns
        AllocateUnassignedDecision that = (AllocateUnassignedDecision) other;
    /** a constant representing a shard decision where no decision was taken */
    /**
        long configuredDelayInMillis
        0L
            builder.startObject("target_node");
 * this work for additional information regarding copyright
        boolean reuseStore
 * this file be licensed under the Apache-2.0 license or a
        super(in);
            );
        nodeDecisionsToXContent(nodeDecisions, builder, params);
    /**
        cachedDecisions.put(
                return "cannot allocate because allocation is not permitted to any of the nodes";
    private AllocateUnassignedDecision(
    private final long remainingDelayInMillis;
        super.writeTo(out);
    public static final AllocateUnassignedDecision NOT_TAKEN = new AllocateUnassignedDecision(
 */
        return allocationStatus != AllocationStatus.NO_ATTEMPT;
    ) {
        if (allocationStatus == AllocationStatus.DELAYED_ALLOCATION) {
        AllocationStatus allocationStatus,
        null,
 * You may obtain a copy of the License at
    /**
    private static AllocateUnassignedDecision getCachedDecision(AllocationStatus allocationStatus) {
        remainingDelayInMillis = in.readVLong();
            return "cannot allocate because information about existing shard data is still being retrieved from some of the nodes";
    @Nullable
        DiscoveryNode assignedNode,
            new AllocateUnassignedDecision(AllocationStatus.DECIDERS_NO, null, null, null, false, 0L, 0L)
    }
        return allocationId;
    }
        if (decisions != null) {
    public AllocationStatus getAllocationStatus() {
        Map<AllocationStatus, AllocateUnassignedDecision> cachedDecisions = new EnumMap<>(AllocationStatus.class);
        return getNodeDecisions() != null
     * Returns a THROTTLE decision, with the individual node-level decisions that
    private static AllocateUnassignedDecision no(
     * method will return {@link AllocationStatus#DELAYED_ALLOCATION} for {@link #getAllocationStatus()}.
        return no(allocationStatus, decisions, reuseStore, 0L, 0L);
     * Gets the total configured delay for allocating the replica shard when a node holding the replica left
/*
        } else {
        @Nullable String allocationId,
 */
     * Gets the allocation id for the existing shard copy that the allocator is assigning the shard to.
     * Returns the {@link AllocationDecision} denoting the result of an allocation attempt.
        } else {
        allocationStatus = in.readOptionalWriteable(AllocationStatus::readFrom);
        boolean reuseStore,
    }
            allocationStatus,
    /**
    @Nullable
     * {@link AllocationStatus#DELAYED_ALLOCATION}.  If {@link #isDecisionTaken()} returns {@code false},
/**
        );
            return false;
    }
     */
     * the cluster and the deciders are waiting to see if the node returns before allocating the replica
        }
    }
            new AllocateUnassignedDecision(AllocationStatus.NO_VALID_SHARD_COPY, null, null, null, false, 0L, 0L)
    }
        if (targetNode != null) {
            new AllocateUnassignedDecision(AllocationStatus.DELAYED_ALLOCATION, null, null, null, false, 0L, 0L)
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
     * Returns a NO decision with the given {@link AllocationStatus}, and the individual node-level
        List<NodeAllocationResult> nodeDecisions,
