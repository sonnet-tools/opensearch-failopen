    public ShardRouting moveToUnassigned(UnassignedInfo unassignedInfo) {
        }
                + other
     * Returns <code>true</code> iff the this shard is currently relocating to
    }
    }
     * Returns a shard routing representing the target shard.
        }
     */
    public boolean isSplitTarget() {
    /**
    public ShardRouting moveUnassignedFromPrimary() {
    public void writeToThin(StreamOutput out) throws IOException {
    @Override
        sb.append('[').append(shardId.getIndexName()).append(']').append('[').append(shardId.getId()).append(']');
            .field("relocating_node", relocatingNodeId())
        }
                + "], other ["
        String currentNodeId,
    protected ShardRouting(
    private final ShardId parentShardId;
    }
            primary,
        }
            unassignedInfo,
                recoverySource = ExistingStoreRecoverySource.INSTANCE;
        out.writeOptionalWriteable(unassignedInfo);
            || state != ShardRoutingState.RELOCATING
    /**
    }
        return b;
        this.recoveringChildShards = recoveringChildShards;
            : "ShardRouting is a relocation source but the allocation id isn't equal to other.allocationId.getRelocationId."
    /** returns true if the current routing is identical to the other routing in all but meta fields, i.e., unassigned info */
     *
                + "], other ["
            h = shardId.hashCode();
 */
            recoverySource,
            || searchOnly
                + other
            expectedShardSize
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
    protected ShardRouting(
     * The shard is initializing (usually recovering either from peer shard
    ) {
            hashCode = h;
        assert relocatingNodeId == null : this;
    }
            sb.append(", expected_shard_size[").append(expectedShardSize).append("]");
    /**
        }
     */
     * A shard iterator with just this shard in it.
                + "], target ["
            state,
            unassignedInfo,
     * Make the active shard primary unless it's not primary
            searchOnly,
 * Modifications Copyright OpenSearch Contributors. See
            shardId,
        }
    /**
            unassignedInfo,
            searchOnly,
    /**
            h = 31 * h + (state != null ? state.hashCode() : 0);
        assert relocating();
            UNAVAILABLE_EXPECTED_SHARD_SIZE
                + " This ["
        assert (currentNodeId == null) == (state == ShardRoutingState.UNASSIGNED) : "unassigned shard must not be assigned to a node "
            expectedShardSize,
            searchOnly,
    }
     * An id that uniquely identifies an allocation.
        RecoverySource recoverySource,
        }
     */
            throw new IllegalShardRoutingStateException(this, "Cannot move a search only replica to primary");
                sb.append("[R]");
    public ShardId getParentShardId() {
            recoverySource,
        ShardRoutingState state,
    public boolean relocating() {
    }
        if (o == null || !(o instanceof ShardRouting)) {
    public ShardRouting getTargetRelocatingShard() {
     * Returns <code>true</code> iff this shard is assigned to a node ie. not
 */
        if (allocationId.getRelocationId() != null) {
                + "]";
                + " This ["
                + this
        );
    /**
    /**
                + "], other ["
        boolean primary,
            null,
     * This allows the non-primary shard to continue recovery from the primary even though its non-primary
    }
            recoverySource,
     */
    public ShardRouting cancelRelocation() {
            sb.append(", a").append(allocationId);
        assert relocatingNodeId != null : this;
    }
    /**
            state,
            return false;
     *
            shardId,
     * Returns the parent shard id if this is a child shard created by split, or null otherwise.
        return this.primary;
        }
        final AllocationId allocationId;
            .field("shard", id())
    /**
    public String toString() {
        }
    @Override
            primary,
        return new ShardRouting(
    }
        RecoverySource recoverySource,
    /**
        assert this.unassignedInfo != null : "can only update unassign info if they are already set";
        assert b == false || this.primary == other.primary : "ShardRouting is a relocation source but primary flag is different. This ["
     * Returns <code>true</code> if this shard is a relocation target for another shard
        return state == ShardRoutingState.STARTED;
     * Note: if both shard routing has a null as their {@link #allocationId()}, this method returns false as the routing describe
            sb.append("relocating [").append(relocatingNodeId).append("], ");
    private final UnassignedInfo unassignedInfo;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (primary) {
    public ShardRouting reinitializeReplicaShard() {
            relocatingNodeId,
        AllocationId allocationId = this.allocationId;
    public AllocationId allocationId() {
            null,
    public void writeTo(StreamOutput out) throws IOException {
    private final ShardRouting targetRelocatingShard;
        assert b == false || other.state == ShardRoutingState.RELOCATING
    public UnassignedInfo unassignedInfo() {
     */
     * Removes relocation source of a non-primary shard. The shard state must be <code>INITIALIZING</code>.
     * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
     * or from gateway).
        state = ShardRoutingState.fromValue(in.readByte());
        );
            return false;
    }
 * @opensearch.api
            primary,
            h = 31 * h + (currentNodeId != null ? currentNodeId.hashCode() : 0);
        }
        return new ShardRouting(
            unassignedInfo,
        assert !(state == ShardRoutingState.UNASSIGNED && unassignedInfo == null) : "unassigned shard must be created with meta";
            : "ShardRouting is a relocation source but shard state isn't relocating. This [" + this + "], other [" + other + "]";
        }
        );
     */
        }
        assert isRelocationTarget() == false : this;
            if (primary() || isSearchOnly()) {
    }
     * Returns <code>true</code> iff this shard is a search only replica.
            } else {
        return state == ShardRoutingState.INITIALIZING;
    /**
        asList = Collections.singletonList(this);
    public RecoverySource recoverySource() {
    public boolean isSameAllocation(ShardRouting other) {
            expectedShardSize
            null,
    }
        return this.allocationId;
            : "recovery source only available on unassigned or initializing shard but was " + state;
            + " This ["
     * Reinitializes a replica shard, giving it a fresh allocation id
    @Nullable
        return recoverySource;
        }
     */
            : "ShardRouting is a relocation target but source current node id isn't equal to target relocating node."
        }
    private ShardRouting initializeTargetRelocatingShard() {
     */
    public ShardRouting moveActivePrimaryToReplica() {
    public static ShardRouting newUnassigned(
        return b;
        if (unassignedInfo != null ? !unassignedInfo.equals(that.unassignedInfo) : that.unassignedInfo != null) {
    }
     */
     * Returns <code>true</code> iff the shard is in splitting state.
        return new ShardRouting(
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
     */
            currentNodeId,
        long expectedShardSize,
        );
        assert state == ShardRoutingState.INITIALIZING : this;
    }
        assert b == false || other.allocationId.getId().equals(this.allocationId.getRelocationId())
        assert this.unassignedInfo.isDelayed() || (unassignedInfo.isDelayed() == false) : "cannot transition from non-delayed to delayed";
     * until the shard moves to STARTED.
     *
            h = 31 * h + (relocatingNodeId != null ? relocatingNodeId.hashCode() : 0);
    public ShardId shardId() {
import org.opensearch.common.Nullable;
        );
    /**
        String currentNodeId,
    private final RecoverySource recoverySource;
 * specific language governing permissions and limitations
        ShardId shardId,
                + this
        if (searchOnly) {
            : "ShardRouting is a relocation source but both indexRoutings are not of the same shard."
            searchOnly,
    /**
    public boolean equals(Object o) {
    }
     * The shard id.
     * Returns <code>true</code> iff this shard is a primary.
            recoverySource = null;
    private final String relocatingNodeId;
            + this
    public String currentNodeId() {
    }
    public ShardRouting updateUnassigned(UnassignedInfo unassignedInfo, RecoverySource recoverySource) {
            primary,
            relocatingNodeId,
    }
        out.writeOptionalString(currentNodeId);
 * ownership. Elasticsearch licenses this file to you under
            AllocationId.newInitializing(),
     * The shard id.
        out.writeOptionalWriteable(allocationId);
     * @throws IllegalShardRoutingStateException if shard is already a replica
    private final boolean searchOnly;
        }
     *
    public String relocatingNodeId() {
        boolean primary,
            return false;
        return parentShardId;
        return new ShardRouting(
    @Nullable
            return false;
/*
            recoverySource,
        sb.append(", s[").append(state).append("]");
        long expectedShardSize
    public boolean equalsIgnoringMetadata(ShardRouting other) {
            h = 31 * h + (recoverySource != null ? recoverySource.hashCode() : 0);
        );
            + this;
        }
     *
        assert b == false || this.state == ShardRoutingState.RELOCATING
        }
import org.opensearch.core.xcontent.ToXContentObject;
     * @throws IOException if something happens during write
     */
        assert b == false || this.shardId.equals(other.shardId)
            allocationId = AllocationId.newInitializing(existingAllocationId);
            return false;
    @Override
    }
    public boolean isRelocationSourceOf(ShardRouting other) {
        this(
            + this
    private final ShardRoutingState state;
     * @throws IllegalShardRoutingStateException if shard is already a replica
    }
            allocationId,
            : "ShardRouting is a relocation target but the source shard state isn't relocating. This [" + this + "], other [" + other + "]";
     * <code>INITIALIZING</code> or <code>RELOCATING</code>. Any relocation will be
            : "ShardRouting is a relocation source but current node isn't equal to other's relocating node."
    /**
        assert b == false || this.currentNodeId.equals(other.currentNodeId)
     * The relocating node id the shard is either relocating to or relocating from.
                + " This ["
        if (searchOnly) {
        assert b == false || this.currentNodeId().equals(other.relocatingNodeId)
    /**
        this.asList = Collections.singletonList(this);
    }
    /**
    }
            .field("index", getIndexName());
        assert active() : "expected an active shard " + this;
        assert expectedShardSize >= 0
     */
     * {@link ShardRoutingState#STARTED started} or
        if (!primary) {
    public ShardRouting(StreamInput in) throws IOException {
                + this
        }
        }
        ShardId shardId,
            shardId,
            null,
        this.state = state;
    public ShardRouting[] getRecoveringChildShards() {
                + "]";
     * {@link ShardRoutingState#SPLITTING splitting} or
        this.shardId = shardId;
        return sb.toString();
            + "], target ["
    /**
        return shardId.getIndex();
        assert b == false || this.primary == other.primary : "ShardRouting is a relocation target but primary flag is different."
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        XContentBuilder fieldBuilder = builder.startObject().field("state", state()).field("primary", primary());
    /**
     * Returns recovery source for the given shard. Replica shards always recover from the primary {@link PeerRecoverySource}.
        }
            unassignedInfo,
            : "ShardRouting is a relocation target but both indexRoutings are not of the same shard id."
     * Set the shards state to <code>STARTED</code>. The shards state must be
            + other
    public ShardIterator shardsIt() {
        final long shardSize;
                + " This ["
     */
                + other
            ShardRoutingState.STARTED,
            || state != ShardRoutingState.SPLITTING : expectedShardSize + " state: " + state;
     * Initializes an unassigned shard on a node.
            false,
    public boolean unassignedReasonIndexCreated() {
     * Moves the shard to unassigned state.
    /**
        String currentNodeId,
        assert b == false || other.currentNodeId().equals(this.relocatingNodeId)
        );
    /**
        return new ShardRouting(
    /**
        assert assignedToNode() : this;
            false,
            throw new IllegalShardRoutingStateException(this, "Not a primary shard, can't move to replica");
        return shardId;
                + this
    public int getId() {
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.cluster.routing;
            + "]";
        assert primary == false : this;
     * The index name.
        }
        if (active()) {
import org.opensearch.Version;
        unassignedInfo = in.readOptionalWriteable(UnassignedInfo::new);
            relocatingNodeId,
    /**
                + " This ["
        this.searchOnly = searchOnly;
            currentNodeId,
        ShardRoutingState state,
    }
            return null;
        return false;
     * <p>
            allocationId,
        String relocatingNodeId,
    /**
    /**
            unassignedInfo,
        } else {
            shardId,
    @Nullable
     */
            expectedShardSize
            currentNodeId,
    @Nullable
        if (unassignedInfo != null) {
        AllocationId allocationId,
    /**
            allocationId,
     */
     */
     * Writes shard information to {@link StreamOutput} without writing index name and shard id
     * Creates a new unassigned shard.
     * @throws IllegalShardRoutingStateException if shard is already a primary
 * under the License.
            AllocationId.newRelocation(allocationId),
        assert b == false || other.currentNodeId().equals(this.relocatingNodeId)
        writeToThin(out);
     */
        return equalsIgnoringMetadata(that);
            allocationId = AllocationId.newInitializing();
            unassignedInfo,
    private final String currentNodeId;
        if (allocationId != null ? !allocationId.equals(other.allocationId) : other.allocationId != null) {
                shardId,
    public boolean initializing() {
    public boolean assignedToNode() {
    ) {
        } else {
     */
    /**
     * Used if shard size is not available
        return expectedShardSize;
        return state == ShardRoutingState.UNASSIGNED;
     */
            allocationId,
     * The shard is unassigned (not allocated to any node).
        this.expectedShardSize = expectedShardSize;
     * source node.
        this(new ShardId(in), in);
    /**
        // These fields are transient - populated by RoutingNodes constructor, not serialized on the wire.
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            throw new IllegalShardRoutingStateException(this, "Cannot move a primary to a search only replica");
    public boolean splitting() {
    @Nullable
        }
    public boolean isRelocationTargetOf(ShardRouting other) {
    public int hashCode() {
            recoverySource,
        return h;
/*
    public ShardRouting moveActiveReplicaToPrimary() {
            state,
     * Make the active primary shard as replica
            ShardRoutingState.INITIALIZING,
     * to <code>RELOCATING</code>.
     * The current node id the shard is allocated on.
        this.allocationId = allocationId;
        assert b == false || this.shardId.equals(other.shardId)
        long expectedShardSize
        fieldBuilder.field("node", currentNodeId())
     * shards. If it's size is not available {@value #UNAVAILABLE_EXPECTED_SHARD_SIZE} will be returned.
            UNAVAILABLE_EXPECTED_SHARD_SIZE
     */
    /**
                + "]";
    }
            currentNodeId,
        sb.append(", node[").append(currentNodeId).append("], ");
        }
            unassignedInfo,
        parentShardId = null;
     * no allocation at all..
            false,
                + other
            recoverySource,
    /**
            currentNodeId,
        }
 *
            // relocation target
 * The OpenSearch Contributors require contributions made to
    }
    public ShardRoutingState state() {
 *
        } else {
        }
    }
            primary,
        int h = hashCode;
            && other.allocationId != null
        if (allocationId != null) {
        assert assignedToNode() : this;
        assert relocatingNodeId != null : this;
            ShardRoutingState.INITIALIZING,
        if (recoverySource != null ? !recoverySource.equals(other.recoverySource) : other.recoverySource != null) {
            recoverySource.writeTo(out);
     */
public class ShardRouting implements Writeable, ToXContentObject {
            ShardRoutingState.STARTED,
        boolean searchOnly,
                unassignedInfo,
                + "], other ["
        return state == ShardRoutingState.INITIALIZING && relocatingNodeId != null;
            );
        return targetRelocatingShard;
            null,
    public ShardRouting(ShardId shardId, StreamInput in) throws IOException {
        if (allocationId != null) {
    public static final long UNAVAILABLE_EXPECTED_SHARD_SIZE = -1;
            shardId,
     * @param out {@link StreamOutput} to write shard information to
            expectedShardSize
            shardId,
 * Unless required by applicable law or agreed to in writing,
        allocationId = in.readOptionalWriteable(AllocationId::new);
 * this work for additional information regarding copyright
        expectedShardSize = shardSize;
    }
    public ShardRouting moveToStarted() {
 */
            shardId,
            currentNodeId,
    }
                + " This ["
        return this.state;
    }
}
        return state == ShardRoutingState.SPLITTING;
        String relocatingNodeId,
            ShardRoutingState.UNASSIGNED,
 * the Apache License, Version 2.0 (the "License"); you may
        relocatingNodeId = in.readOptionalString();
     */
            expectedShardSize
            sb.append(", recovery_source[").append(recoverySource).append("]");
            shardId,
            null,
            || state != ShardRoutingState.INITIALIZING
    /**
            allocationId,
import org.opensearch.core.index.Index;
        }
            primary,
        boolean primary,
                + "], other ["
            unassignedInfo,
    private int hashCode; // default to 0
            builder.field("allocation_id");
            null,
        if (state == ShardRoutingState.RELOCATING || state == ShardRoutingState.INITIALIZING || state == ShardRoutingState.SPLITTING) {
            allocationId = AllocationId.finishRelocation(allocationId);
            && other.allocationId != null
            recoverySource,
    }
            null,
        if (expectedShardSize != UNAVAILABLE_EXPECTED_SHARD_SIZE) {
        assert state == ShardRoutingState.UNASSIGNED : "expected an unassigned shard " + this;
            allocationId.toXContent(builder, params);
        ShardId parentShardId
    /**
    }
        assert state == ShardRoutingState.INITIALIZING : "expected an initializing shard " + this;
    }
 * software distributed under the License is distributed on an
            UNAVAILABLE_EXPECTED_SHARD_SIZE
 *
        String relocatingNodeId,
            null,
                + "]";
        return shortSummary();
    }
    public static ShardRouting newUnassigned(
    @Nullable
    }
        );
            nodeId,
            primary,
import org.opensearch.core.common.io.stream.StreamInput;
            : "ShardRouting is a relocation source but relocating node isn't equal to other's current node."
            true,
            search,
                AllocationId.newTargetRelocation(allocationId),
            return false;
    }
            builder.field("expected_shard_size_in_bytes", expectedShardSize);
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;
            state,
        assert state != ShardRoutingState.UNASSIGNED : this;
     * @return recovery source or null if shard is {@link #active()}
        }
            null,
    public boolean unassigned() {
     */
            primary,
        if (recoverySource != null) {
            searchOnly,
        return new ShardRouting(
        out.writeOptionalString(relocatingNodeId);
            searchOnly,
        targetRelocatingShard = initializeTargetRelocatingShard();
    private final ShardId shardId;
        );
     */
            state,
    /**
        UnassignedInfo unassignedInfo
            expectedShardSize
        UnassignedInfo unassignedInfo,
                + other
        );
            return true;
 * SPDX-License-Identifier: Apache-2.0
    }
        assert primary == false : this;
    }
     *
        return new ShardRouting(
            currentNodeId,
        return this.currentNodeId;
            null,
        primary = in.readBoolean();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            searchOnly,
            ShardRoutingState.RELOCATING,
                sb.append("[S]");
        boolean b = this.allocationId != null
            currentNodeId,
    }
            null,
        this.recoverySource = recoverySource;
            recoverySource = recoverySource();
        this.relocatingNodeId = relocatingNodeId;
            relocatingNodeId,
    }
        ShardRouting that = (ShardRouting) o;
            : "ShardRouting is a relocation target but the source id isn't equal to source's allocationId.getRelocationId."
        ShardRoutingState shardRoutingState,
        fieldBuilder.field("searchOnly", isSearchOnly());
        currentNodeId = in.readOptionalString();
            || state == ShardRoutingState.INITIALIZING
            expectedShardSize
            null
    /**
                + "]";
     *
import java.util.Collections;
            : "ShardRoutings have the same allocation id but not the same node. This [" + this + "], other [" + other + "]";
            allocationId,
        return b;
     * Returns a copy of the recovering child shards of this splitting shard, or null if not splitting.
     * The shard state.
    @Override
            expectedShardSize
                primary,
@PublicApi(since = "1.0.0")
            return false;
     * @param relocatingNodeId id of the node to relocate the shard
    public String getIndexName() {
        boolean b = this.allocationId != null && other.allocationId != null && this.allocationId.getId().equals(other.allocationId.getId());
        this.currentNodeId = currentNodeId;
            throw new IllegalShardRoutingStateException(this, "Already primary, can't move to primary");
                + "]";
        }
        recoveringChildShards = null;
            || recoverySource == RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE : "replica shards always recover from primary";
    private final ShardRouting[] recoveringChildShards;
        return state == ShardRoutingState.RELOCATING;
 * You may obtain a copy of the License at
        UnassignedInfo unassignedInfo,
            allocationId,
            null,
        );
                + "]";
    }
        return started() || relocating() || splitting();
    ) {
     */
            PeerRecoverySource.INSTANCE,
import java.util.List;
            currentNodeId,
            searchOnly,
        assert state == ShardRoutingState.STARTED : "current shard has to be started in order to be relocated " + this;
        this(
 * this file be licensed under the Apache-2.0 license or a
                + this
        final RecoverySource recoverySource;
        } else {
            }
                + "], other ["
        boolean searchOnly,
                relocatingNodeId,
     * The shard id.
     */
    public boolean started() {
            null,
        ShardId shardId,
            shardSize = in.readLong();
 */
        boolean b = this.allocationId != null
            shardId,
     * Relocate the shard to another node.
        if (shardId != null ? !shardId.equals(other.shardId) : other.shardId != null) {
     */
                + "]";
            UNAVAILABLE_EXPECTED_SHARD_SIZE
            h = 31 * h + (primary ? 1 : 0);
                + this
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
    }
     * Set the unassigned primary shard to non-primary
        RecoverySource recoverySource,
            recoverySource,
 * compatible open source license.
        } else {
            null,
    @Nullable
    /**
        assert state == ShardRoutingState.INITIALIZING : this;
            || recoverySource == PeerRecoverySource.INSTANCE
     * relocation source has failed.
            state,
        assert b == false || this.currentNodeId().equals(other.relocatingNodeId)
            shardId,
     * Otherwise <code>false</code>
        return newUnassigned(shardId, primary, false, recoverySource, unassignedInfo);
        assert state == ShardRoutingState.UNASSIGNED : this;
     */
        boolean primary,
    public boolean primary() {
        }
            h = 31 * h + (unassignedInfo != null ? unassignedInfo.hashCode() : 0);
            && other.state == ShardRoutingState.INITIALIZING
        assert (state == ShardRoutingState.UNASSIGNED || state == ShardRoutingState.INITIALIZING) == (recoverySource != null)
    @Nullable
            currentNodeId,
        ShardId shardId,
                expectedShardSize
 * not use this file except in compliance with the License.
    }
        if (this == o) {
        return new ShardRouting(
        this.primary = primary;
            null,
     * another node. Otherwise <code>false</code>
        } else {
    }
                + other
     * canceled.
 * Licensed to Elasticsearch under one or more contributor
    public boolean isSearchOnly() {
            searchOnly,
            recoverySource,
        out.writeByte(state.value());
     * {@link ShardRoutingState#UNASSIGNED unassigned}. Otherwise <code>false</code>
            h = 31 * h + (allocationId != null ? allocationId.hashCode() : 0);
     */
        if (expectedShardSize != UNAVAILABLE_EXPECTED_SHARD_SIZE) {
            allocationId,
     */
        }
     * A short description of the shard.
        }
                + other
    private final transient List<ShardRouting> asList;
        this.unassignedInfo = unassignedInfo;
    ) {
            shardRoutingState,
        assert active() : "expected an active shard " + this;
            || primary
        this.shardId = shardId;
        if (h == 0) {
            : "ShardRouting is a relocation target but current node id isn't equal to source relocating node."
        boolean primary,
            expectedShardSize
    }
        return builder.endObject();
    }
    public long getExpectedShardSize() {
    protected ShardRouting(
        return currentNodeId != null;
                isSearchOnly() ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : PeerRecoverySource.INSTANCE,
            searchOnly = false;
                currentNodeId,
     * A constructor to internally create shard routing instances, note, the internal flag should only be set to true
import org.opensearch.core.common.io.stream.Writeable;
    /**
    /**
     */
        assert state == ShardRoutingState.RELOCATING : this;
        return recoveringChildShards == null ? null : recoveringChildShards.clone();
    /**
        assert recoverySource == null
        ShardId shardId,
                + this
        return shardId.getIndexName();
        if (state == ShardRoutingState.RELOCATING || state == ShardRoutingState.INITIALIZING || state == ShardRoutingState.SPLITTING) {
        if (state == ShardRoutingState.RELOCATING) {
     */
                ShardRoutingState.INITIALIZING,
            currentNodeId,
     */
            recoverySource,
     */
    }
import org.opensearch.cluster.routing.RecoverySource.ExistingStoreRecoverySource;
    private final long expectedShardSize;
                + " This ["
                + " This ["
        if (existingAllocationId == null) {
            shardId,
            ShardRoutingState.UNASSIGNED,
            AllocationId.cancelRelocation(allocationId),
    /**
        if (relocatingNodeId != null) {
            shardSize = UNAVAILABLE_EXPECTED_SHARD_SIZE;
            relocatingNodeId,
        );
            recoverySource,
    /**
    }
        );
    public Index index() {
import java.io.IOException;
            && other.allocationId.getId().equals(this.allocationId.getRelocationId());
            return false;
            recoverySource = RecoverySource.readFrom(in);
        if (state != other.state) {
            sb.append("[P]");
        if (unassignedInfo != null) {
        }
            + "]";
    public ShardRouting initialize(String nodeId, @Nullable String existingAllocationId, long expectedShardSize) {
    public ShardRouting removeRelocationSource() {
        return this.relocatingNodeId;
            return new ShardRouting(
            }
     */
        }
        if (recoverySource != null) {
     * Returns <code>true</code> iff the this shard is currently
        }
        shardId.writeTo(out);
 * KIND, either express or implied.  See the License for the
        RecoverySource recoverySource,
    /**
 * {@link ShardRouting} immutably encapsulates information about shard
     * by either this class or tests. Visible for testing.
    /**
     */
        );
    public boolean active() {
     * @see ShardRoutingState#RELOCATING
    }
     * returns true if this routing has the same allocation ID as another.
     * Cancel relocation of a shard. The shards state must be set
            unassignedInfo.toXContent(builder, params);
        if (currentNodeId != null ? !currentNodeId.equals(other.currentNodeId) : other.currentNodeId != null) {
        assert expectedShardSize == UNAVAILABLE_EXPECTED_SHARD_SIZE
            return unassignedInfo.getReason() == UnassignedInfo.Reason.INDEX_CREATED;
        this.targetRelocatingShard = initializeTargetRelocatingShard();
        return new PlainShardIterator(shardId, asList);
                + other
import org.opensearch.core.index.shard.ShardId;
                searchOnly,
            shardId,
    }
                + "], other ["
    /**
    public String shortSummary() {
     */
        }
     * Returns the expected shard size for {@link ShardRoutingState#RELOCATING} and {@link ShardRoutingState#INITIALIZING}
        this.parentShardId = parentShardId;
 *
    }
    /** returns true if the routing is the relocation target of the given routing */
     * Additional metadata on why the shard is/was unassigned. The metadata is kept around
        assert b == false || this.allocationId.getId().equals(other.allocationId.getRelocationId())
        return new ShardRouting(
     * {@link ShardRoutingState#RELOCATING relocating} to another node.
    /**
     * (i.e., was created with {@link #initializeTargetRelocatingShard()}
    /** returns true if the routing is the relocation source for the given routing */
            out.writeBoolean(searchOnly);
            primary,
                recoverySource = PeerRecoverySource.INSTANCE;
    public ShardRouting relocate(String relocatingNodeId, long expectedShardSize) {
            + "], target ["
        AllocationId allocationId,
    public int id() {
/**
 * license agreements. See the NOTICE file distributed with
        }
    }
        UnassignedInfo unassignedInfo,
    }
    @Override
            || state == ShardRoutingState.RELOCATING
            recoverySource,
        boolean search,
     */
            } else {
            && this.allocationId.getId().equals(other.allocationId.getRelocationId());
     */
            relocatingNodeId,
     * The target shard routing will be the INITIALIZING state and have relocatingNodeId set to the
            unassignedInfo,
 * indexRoutings like id, state, version, etc.
            false,
            relocatingNodeId,
    /**
            searchOnly = in.readBoolean();
    private final boolean primary;
            || state == ShardRoutingState.SPLITTING : expectedShardSize + " state: " + state;
     * as it is mainly used in single-threaded code ({@link BalancedShardsAllocator}).
        if (!primary) {
        StringBuilder sb = new StringBuilder();
        }
        ShardRouting[] recoveringChildShards,
/*
        out.writeBoolean(primary);
        return new ShardRouting(
            shardId,
     * Cache hash code in the same way as {@link String#hashCode()}) using racy single-check idiom
    }
            primary,
        if (primary) {
     */
    }
        return searchOnly;
            primary,
                + this
     * Creates a new unassigned shard, overloaded for bwc for searchOnly addition.
            && this.state == ShardRoutingState.INITIALIZING
     **/
    }
    public boolean isRelocationTarget() {
     * Returns <code>true</code> if this shard is a child shard created by an in-place split.
     *
            shardId,
import org.opensearch.common.annotation.PublicApi;
        if (primary != other.primary) {
        return id();
            sb.append(", ").append(unassignedInfo.toString());
    private final AllocationId allocationId;
     * The shard is in started mode.
        return shardId.id();
        return new ShardRouting(
        UnassignedInfo unassignedInfo
            if (searchOnly) {
            + other
            AllocationId.finishRelocation(allocationId),
        return new ShardRouting(
     */
    }
 * GitHub history for details.
            throw new IllegalShardRoutingStateException(this, "Not primary, can't move to replica");
        if (this.unassignedInfo != null) {
    }
        RecoverySource recoverySource,
        if (state == ShardRoutingState.UNASSIGNED || state == ShardRoutingState.INITIALIZING) {
            out.writeLong(expectedShardSize);
     */
        return parentShardId != null;
        return true;
        if (relocatingNodeId != null ? !relocatingNodeId.equals(other.relocatingNodeId) : other.relocatingNodeId != null) {
    ) {
            false,
        if (state == ShardRoutingState.UNASSIGNED || state == ShardRoutingState.INITIALIZING) {
        return unassignedInfo;
        AllocationId allocationId,
            builder.field("recovery_source", recoverySource);
        } else {
            unassignedInfo,
            return false;
