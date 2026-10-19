        long expectedShardSize
    }
    /**
            expectedShardSize
            : "ShardRouting is a relocation target but the source id isn't equal to source's allocationId.getRelocationId."  
    /**
    public ShardRouting moveToStarted() {
     * Reinitializes a replica shard, giving it a fresh allocation id
            unassignedInfo,  
     * A constructor to internally create shard routing instances, note, the internal flag should only be set to true
        AllocationId allocationId,
        }  
     */
            allocationId,  
        return b;
    public int id() {
            searchOnly,
     */  
     *
            expectedShardSize
    public boolean relocating() {  
            unassignedInfo.toXContent(builder, params);
     *
    /**
        this(
        return currentNodeId != null;
    }
        final AllocationId allocationId;  
            return false;
    /**
    /**
            expectedShardSize
    /**  
        return new PlainShardIterator(shardId, asList);  
        }  
            null,  
 *
     * until the shard moves to STARTED.
        boolean searchOnly,  
    public boolean isSearchOnly() {
    public static final long UNAVAILABLE_EXPECTED_SHARD_SIZE = -1;
            ShardRoutingState.INITIALIZING,  
            relocatingNodeId,
     */  
            : "ShardRouting is a relocation source but shard state isn't relocating. This [" + this + "], other [" + other + "]";
        } else {  
        assert b == false || this.currentNodeId().equals(other.relocatingNodeId)  
     *
        return shardId.getIndexName();
     */
     */  
    }  
    }  
        }  
        if (state == ShardRoutingState.RELOCATING) {
            currentNodeId,
        return new ShardRouting(  
    @Nullable  
     */  
            allocationId,  
import org.opensearch.core.index.Index;
                + "]";
    }  
    /**
                currentNodeId,  
    ) {  
            h = 31 * h + (primary ? 1 : 0);
        if (searchOnly) {  
    protected ShardRouting(
                recoverySource = ExistingStoreRecoverySource.INSTANCE;
import org.opensearch.core.common.io.stream.Writeable;  
            }
            null,
    public int hashCode() {
    @Override
            shardId,
            : "ShardRouting is a relocation source but the allocation id isn't equal to other.allocationId.getRelocationId."
            + "]";  
            unassignedInfo,
    }  
    }  
 * indexRoutings like id, state, version, etc.  
            shardId,
        assert (currentNodeId == null) == (state == ShardRoutingState.UNASSIGNED) : "unassigned shard must not be assigned to a node "
    }  
        );
/*  
            if (primary() || isSearchOnly()) {  
            primary,
    /**
    }  
        primary = in.readBoolean();
        sb.append(", s[").append(state).append("]");  
            : "ShardRouting is a relocation source but current node isn't equal to other's relocating node."  
    @Nullable  
    public ShardIterator shardsIt() {
            recoverySource = RecoverySource.readFrom(in);  
 */  
        if (allocationId.getRelocationId() != null) {
            null,
        UnassignedInfo unassignedInfo,  
package org.opensearch.cluster.routing;
    }  
            null,
            h = 31 * h + (currentNodeId != null ? currentNodeId.hashCode() : 0);  
     * Returns recovery source for the given shard. Replica shards always recover from the primary {@link PeerRecoverySource}.
            recoverySource,
    }
import org.opensearch.Version;
     * Cache hash code in the same way as {@link String#hashCode()}) using racy single-check idiom
            + "], target ["
        } else {  
        );
                sb.append("[R]");  
import org.opensearch.common.annotation.PublicApi;  
            unassignedInfo,  
    }
            shardId,
    public String getIndexName() {  
        RecoverySource recoverySource,  
        if (h == 0) {
    public boolean isSameAllocation(ShardRouting other) {
     */
            && this.state == ShardRoutingState.INITIALIZING
            builder.field("allocation_id");
            null,  
                + this
        boolean primary,  
            : "ShardRouting is a relocation target but the source shard state isn't relocating. This [" + this + "], other [" + other + "]";  
        this.asList = Collections.singletonList(this);
     *
            primary,
     * shards. If it's size is not available {@value #UNAVAILABLE_EXPECTED_SHARD_SIZE} will be returned.  
    public AllocationId allocationId() {  
            return false;
        if (expectedShardSize != UNAVAILABLE_EXPECTED_SHARD_SIZE) {  
    /**
            || state == ShardRoutingState.SPLITTING : expectedShardSize + " state: " + state;  
    public boolean isRelocationSourceOf(ShardRouting other) {  
    /**  
    private final boolean searchOnly;
                + other  
        }
        assert active() : "expected an active shard " + this;
            return false;
        return new ShardRouting(  
            + other
    }
     * The shard state.
        boolean primary,
                + this  
            : "ShardRouting is a relocation target but current node id isn't equal to source relocating node."
        if (state == ShardRoutingState.UNASSIGNED || state == ShardRoutingState.INITIALIZING) {
        String currentNodeId,  
        if (!primary) {  
        if (state == ShardRoutingState.UNASSIGNED || state == ShardRoutingState.INITIALIZING) {
            ShardRoutingState.UNASSIGNED,  
            hashCode = h;
        }
    public ShardRouting moveActiveReplicaToPrimary() {
        if (recoverySource != null) {  
            throw new IllegalShardRoutingStateException(this, "Cannot move a primary to a search only replica");
    /** returns true if the routing is the relocation target of the given routing */
    @Override
        boolean searchOnly,
import java.util.Collections;
        return state == ShardRoutingState.STARTED;  
            searchOnly,
            recoverySource,
        assert relocatingNodeId != null : this;  
                + "], other ["
    /**
            + this;
            && other.allocationId.getId().equals(this.allocationId.getRelocationId());
        }
                + " This ["
        return recoverySource;
        assert b == false || this.currentNodeId().equals(other.relocatingNodeId)
    public String toString() {
     * Moves the shard to unassigned state.  
        AllocationId allocationId,
    public ShardRouting moveActivePrimaryToReplica() {
            return false;
     * The shard is initializing (usually recovering either from peer shard
            shardId,
     * The current node id the shard is allocated on.  
    }  
    private ShardRouting initializeTargetRelocatingShard() {
        } else {  
    }
            primary,
            relocatingNodeId,  
     */
            }
            relocatingNodeId,  
                + "], other ["
        state = ShardRoutingState.fromValue(in.readByte());
    public boolean unassignedReasonIndexCreated() {
     */
        return h;  
    private final ShardId shardId;  
        return builder.endObject();
        }  
     */
        assert this.unassignedInfo != null : "can only update unassign info if they are already set";
        StringBuilder sb = new StringBuilder();  
            return false;
     */
        return recoveringChildShards == null ? null : recoveringChildShards.clone();
                + other
 *  
     */
            AllocationId.newInitializing(),
        );  
    }  
    private final ShardRouting[] recoveringChildShards;
            h = shardId.hashCode();
                + other  
     */  
    /**
        );  
            : "ShardRoutings have the same allocation id but not the same node. This [" + this + "], other [" + other + "]";
            shardId,
            unassignedInfo,  
     * Make the active primary shard as replica  
     * @return recovery source or null if shard is {@link #active()}  
    /**
        if (state != other.state) {
     * @param out {@link StreamOutput} to write shard information to  
                + this
     */  
    public RecoverySource recoverySource() {  
    private final RecoverySource recoverySource;  
    protected ShardRouting(
        ShardId shardId,  
            && other.allocationId != null
            null
        asList = Collections.singletonList(this);
            null,
    public boolean primary() {
    /**
        RecoverySource recoverySource,
        assert state == ShardRoutingState.STARTED : "current shard has to be started in order to be relocated " + this;
            currentNodeId,
        return new ShardRouting(
     * Cancel relocation of a shard. The shards state must be set  
            .field("index", getIndexName());
    public static ShardRouting newUnassigned(
        long expectedShardSize
    /**  
        return b;
            h = 31 * h + (unassignedInfo != null ? unassignedInfo.hashCode() : 0);  
            shardId,
            state,
            nodeId,
        );
            null,
        ShardRouting that = (ShardRouting) o;  
            expectedShardSize
        writeToThin(out);  
     */
    public boolean unassigned() {  
     */
        return id();  
        if (recoverySource != null) {  
        return shardId;
     */
     * Used if shard size is not available
                recoverySource = PeerRecoverySource.INSTANCE;  
        );  
 * Licensed to Elasticsearch under one or more contributor  
            h = 31 * h + (relocatingNodeId != null ? relocatingNodeId.hashCode() : 0);
        String relocatingNodeId,
    /**
        sb.append('[').append(shardId.getIndexName()).append(']').append('[').append(shardId.getId()).append(']');
        return shardId.getIndex();  
                + " This ["  
 * not use this file except in compliance with the License.
                + "]";
            currentNodeId,  
        allocationId = in.readOptionalWriteable(AllocationId::new);
     */  
@PublicApi(since = "1.0.0")
        // These fields are transient - populated by RoutingNodes constructor, not serialized on the wire.  
            + "]";  
     * @throws IOException if something happens during write
        assert b == false || other.allocationId.getId().equals(this.allocationId.getRelocationId())
    /**
     * Otherwise <code>false</code>
     * {@link ShardRoutingState#SPLITTING splitting} or  
    private final ShardId parentShardId;
 */
        assert b == false || this.allocationId.getId().equals(other.allocationId.getRelocationId())  
 * GitHub history for details.
        assert assignedToNode() : this;
     * Returns <code>true</code> iff the this shard is currently
            sb.append(", ").append(unassignedInfo.toString());
            );
     * A short description of the shard.  
 * this file be licensed under the Apache-2.0 license or a
    /**
            + " This ["
            null,
     */
    /**
import java.io.IOException;  
            + other
            || state == ShardRoutingState.RELOCATING
            || state != ShardRoutingState.SPLITTING : expectedShardSize + " state: " + state;
 */  
            allocationId,
     * Returns a shard routing representing the target shard.
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            primary,
    /** returns true if the current routing is identical to the other routing in all but meta fields, i.e., unassigned info */
        return state == ShardRoutingState.SPLITTING;
            throw new IllegalShardRoutingStateException(this, "Not primary, can't move to replica");
     * Initializes an unassigned shard on a node.
        this.targetRelocatingShard = initializeTargetRelocatingShard();
    }
 * this work for additional information regarding copyright
    public ShardRouting(ShardId shardId, StreamInput in) throws IOException {  
    /**  
        if (unassignedInfo != null) {
            null,
    }
        this.recoveringChildShards = recoveringChildShards;  
 * ownership. Elasticsearch licenses this file to you under  
            expectedShardSize
        sb.append(", node[").append(currentNodeId).append("], ");
            AllocationId.cancelRelocation(allocationId),
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + this
    private final boolean primary;  
            allocationId = AllocationId.newInitializing();
    public ShardRouting[] getRecoveringChildShards() {
            ShardRoutingState.UNASSIGNED,
        }
        return started() || relocating() || splitting();
    public Index index() {
            null,  
            recoverySource,
                + " This ["  
            ShardRoutingState.STARTED,  
        if (searchOnly) {  
            ShardRoutingState.RELOCATING,  
            unassignedInfo,
        assert (state == ShardRoutingState.UNASSIGNED || state == ShardRoutingState.INITIALIZING) == (recoverySource != null)  
        this.searchOnly = searchOnly;
    private int hashCode; // default to 0
        ShardId shardId,  
            out.writeLong(expectedShardSize);
    }
        assert expectedShardSize == UNAVAILABLE_EXPECTED_SHARD_SIZE  
        assert assignedToNode() : this;
        RecoverySource recoverySource,
    /**
        String relocatingNodeId,
        this.expectedShardSize = expectedShardSize;
 */  
            sb.append("[P]");
import org.opensearch.core.xcontent.XContentBuilder;
        assert state == ShardRoutingState.INITIALIZING : "expected an initializing shard " + this;  
            recoverySource = recoverySource();  
 * software distributed under the License is distributed on an
    public void writeToThin(StreamOutput out) throws IOException {  
        this.shardId = shardId;
    /** returns true if the routing is the relocation source for the given routing */
    /**
     * Returns <code>true</code> iff the this shard is currently relocating to
            } else {
        String currentNodeId,
     * Writes shard information to {@link StreamOutput} without writing index name and shard id
     *  
    public static ShardRouting newUnassigned(
                + "], other ["  
            currentNodeId,  
        }
     */
        assert state != ShardRoutingState.UNASSIGNED : this;  
        ShardRouting[] recoveringChildShards,
        }
            sb.append(", a").append(allocationId);
    @Override  
        );
                + "]";
     */  
        );
    public ShardRouting moveToUnassigned(UnassignedInfo unassignedInfo) {
     */
            expectedShardSize,
            unassignedInfo,
        assert state == ShardRoutingState.INITIALIZING : this;
            primary,
     * or from gateway).  
        }  
     * {@link ShardRoutingState#STARTED started} or
                + "], other ["
        assert state == ShardRoutingState.INITIALIZING : this;
                + " This ["
                + other
     */
        if (relocatingNodeId != null ? !relocatingNodeId.equals(other.relocatingNodeId) : other.relocatingNodeId != null) {
            if (searchOnly) {  
                + " This ["
    }
            || recoverySource == PeerRecoverySource.INSTANCE  
    public boolean isRelocationTarget() {  
import org.opensearch.core.xcontent.ToXContentObject;  
    }  
     * relocation source has failed.  
    }
 *
     * canceled.  
        );  
     */
        boolean b = this.allocationId != null && other.allocationId != null && this.allocationId.getId().equals(other.allocationId.getId());
        }  
     * Returns <code>true</code> iff the shard is in splitting state.
            recoverySource,
     * The relocating node id the shard is either relocating to or relocating from.
     * @throws IllegalShardRoutingStateException if shard is already a replica
    private final transient List<ShardRouting> asList;  
            + "], target ["
    public boolean equals(Object o) {
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            recoverySource,
        String relocatingNodeId,
        if (o == null || !(o instanceof ShardRouting)) {  
        boolean primary,
    public ShardId getParentShardId() {
     * Returns a copy of the recovering child shards of this splitting shard, or null if not splitting.
        }  
    /**
     * by either this class or tests. Visible for testing.
                + "]";  
        return state == ShardRoutingState.INITIALIZING && relocatingNodeId != null;
            out.writeBoolean(searchOnly);
    }
        return new ShardRouting(
    }
        return state == ShardRoutingState.INITIALIZING;  
        );
    /**  
    public ShardRoutingState state() {  
                + "], other ["  
    }
                searchOnly,
    }
            state,  
     */
        }
     * Set the shards state to <code>STARTED</code>. The shards state must be
        return state == ShardRoutingState.UNASSIGNED;
    ) {  
            || state == ShardRoutingState.INITIALIZING
        this(
    public long getExpectedShardSize() {
     * The shard id.
            UNAVAILABLE_EXPECTED_SHARD_SIZE
    }
            searchOnly,
        shardId.writeTo(out);
                + this  
 * Unless required by applicable law or agreed to in writing,
    @Nullable
            null,  
    }
        fieldBuilder.field("searchOnly", isSearchOnly());
            unassignedInfo,
        if (active()) {
            h = 31 * h + (recoverySource != null ? recoverySource.hashCode() : 0);
    }  
     * as it is mainly used in single-threaded code ({@link BalancedShardsAllocator}).  
            unassignedInfo,
     */
        if (allocationId != null ? !allocationId.equals(other.allocationId) : other.allocationId != null) {
        return targetRelocatingShard;
     * An id that uniquely identifies an allocation.  
            && other.allocationId != null
    }
     *
    private final long expectedShardSize;
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
    }  
     * Note: if both shard routing has a null as their {@link #allocationId()}, this method returns false as the routing describe
            shardId,
            true,
    }
            return false;
            ShardRoutingState.INITIALIZING,
        final long shardSize;  
        out.writeByte(state.value());
            expectedShardSize
            : "recovery source only available on unassigned or initializing shard but was " + state;
            UNAVAILABLE_EXPECTED_SHARD_SIZE
                expectedShardSize
    private final String currentNodeId;
        return new ShardRouting(
        if (state == ShardRoutingState.RELOCATING || state == ShardRoutingState.INITIALIZING || state == ShardRoutingState.SPLITTING) {
        } else {
    public boolean initializing() {
            recoverySource.writeTo(out);  
        if (relocatingNodeId != null) {  
     */  
        ShardId shardId,  
     */
    }
        boolean primary,  
                AllocationId.newTargetRelocation(allocationId),  
        currentNodeId = in.readOptionalString();
                + "], other ["  
        this.parentShardId = parentShardId;
    /**  
        );
     */
 * compatible open source license.
        assert expectedShardSize >= 0
            recoverySource,
            recoverySource,  
    @Nullable
    }  
        this.recoverySource = recoverySource;
        if (this == o) {  
            recoverySource,
        return new ShardRouting(  
                + "]";  
        return shortSummary();
     * Additional metadata on why the shard is/was unassigned. The metadata is kept around  
     * The index name.
     * (i.e., was created with {@link #initializeTargetRelocatingShard()}
    private final UnassignedInfo unassignedInfo;
     * Returns <code>true</code> iff this shard is a primary.
     */
     * Returns <code>true</code> if this shard is a relocation target for another shard  
        }  
     * This allows the non-primary shard to continue recovery from the primary even though its non-primary
        assert b == false || other.state == ShardRoutingState.RELOCATING
    @Nullable
            unassignedInfo,
     */
    /**
        if (allocationId != null) {
        return false;
     * The shard id.
            searchOnly,  
     * The shard id.  
            allocationId = AllocationId.finishRelocation(allocationId);
            recoverySource = null;
        out.writeOptionalString(currentNodeId);
                + "]";
    /**  
            : "ShardRouting is a relocation target but source current node id isn't equal to target relocating node."
                + other
     * Creates a new unassigned shard, overloaded for bwc for searchOnly addition.  
                ShardRoutingState.INITIALIZING,  
            allocationId,
        }
            return new ShardRouting(  
        return expectedShardSize;  
    private final AllocationId allocationId;
        return new ShardRouting(  
            state,
            shardId,
        assert primary == false : this;
        if (state == ShardRoutingState.RELOCATING || state == ShardRoutingState.INITIALIZING || state == ShardRoutingState.SPLITTING) {
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
import org.opensearch.core.common.io.stream.StreamInput;
        return newUnassigned(shardId, primary, false, recoverySource, unassignedInfo);
                + "]";  
            false,
     * Returns the parent shard id if this is a child shard created by split, or null otherwise.  
            builder.field("expected_shard_size_in_bytes", expectedShardSize);
    }
     * Creates a new unassigned shard.  
    ) {  
            ShardRoutingState.STARTED,
        if (currentNodeId != null ? !currentNodeId.equals(other.currentNodeId) : other.currentNodeId != null) {
        assert recoverySource == null
        ShardRoutingState shardRoutingState,
            allocationId,  
    public ShardRouting initialize(String nodeId, @Nullable String existingAllocationId, long expectedShardSize) {  
        return shardId.id();
            PeerRecoverySource.INSTANCE,  
        return this.state;
    public ShardRouting relocate(String relocatingNodeId, long expectedShardSize) {
            primary,
            : "ShardRouting is a relocation source but both indexRoutings are not of the same shard."
        return true;
     * returns true if this routing has the same allocation ID as another.
            AllocationId.finishRelocation(allocationId),
            primary,
        assert b == false || other.currentNodeId().equals(this.relocatingNodeId)
        return new ShardRouting(  
            || state != ShardRoutingState.INITIALIZING
            .field("shard", id())
        assert b == false || this.primary == other.primary : "ShardRouting is a relocation source but primary flag is different. This ["
        if (primary) {  
        } else {
        UnassignedInfo unassignedInfo,  
    /**  
    public ShardRouting cancelRelocation() {  
 * under the License.  
            relocatingNodeId,  
            state,
     */
    public ShardRouting removeRelocationSource() {
import org.opensearch.core.index.shard.ShardId;
            h = 31 * h + (state != null ? state.hashCode() : 0);  
    public boolean started() {
        assert b == false || this.shardId.equals(other.shardId)
    private final String relocatingNodeId;
import org.opensearch.cluster.routing.RecoverySource.ExistingStoreRecoverySource;
    public String currentNodeId() {
    /**  
     * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
    /**
            return false;
    public void writeTo(StreamOutput out) throws IOException {
            allocationId,  
    public ShardRouting updateUnassigned(UnassignedInfo unassignedInfo, RecoverySource recoverySource) {  
        }
     * {@link ShardRoutingState#RELOCATING relocating} to another node.
                + "], other ["
        assert !(state == ShardRoutingState.UNASSIGNED && unassignedInfo == null) : "unassigned shard must be created with meta";
        relocatingNodeId = in.readOptionalString();  
        ShardId parentShardId
    protected ShardRouting(
     */
            currentNodeId,
        }  
            || primary
        }  
        this.unassignedInfo = unassignedInfo;
import org.opensearch.common.Nullable;
            shardId,
                unassignedInfo,
            h = 31 * h + (allocationId != null ? allocationId.hashCode() : 0);
        }
            searchOnly,  
            null,
        }  
        }  
    /**  
            shardSize = UNAVAILABLE_EXPECTED_SHARD_SIZE;
        out.writeOptionalWriteable(unassignedInfo);
     * {@link ShardRoutingState#UNASSIGNED unassigned}. Otherwise <code>false</code>
     */  
            expectedShardSize  
     * Relocate the shard to another node.  
            sb.append(", recovery_source[").append(recoverySource).append("]");
     * Make the active shard primary unless it's not primary  
            null,
        return parentShardId != null;  
                + this
            return false;
    }  
        ShardId shardId,
        ShardId shardId,  
        assert isRelocationTarget() == false : this;  
            + this  
            UNAVAILABLE_EXPECTED_SHARD_SIZE
 * license agreements. See the NOTICE file distributed with
        );
    @Override
 * SPDX-License-Identifier: Apache-2.0
            searchOnly,
        this.allocationId = allocationId;  
    /**
        }
        return equalsIgnoringMetadata(that);
            searchOnly,  
        RecoverySource recoverySource,  
     */
    }  
    /**
        assert state == ShardRoutingState.RELOCATING : this;
        }  
            primary,
            sb.append("relocating [").append(relocatingNodeId).append("], ");
            + this  
        boolean search,
        if (primary) {  
    @Nullable
     */
            recoverySource,
            throw new IllegalShardRoutingStateException(this, "Already primary, can't move to primary");
            relocatingNodeId,  
    @Nullable  
    ) {
     */
        ShardRoutingState state,
        parentShardId = null;
        XContentBuilder fieldBuilder = builder.startObject().field("state", state()).field("primary", primary());  
            && other.state == ShardRoutingState.INITIALIZING  
    /**  
    public boolean active() {
    }
        return state == ShardRoutingState.RELOCATING;
    }  
        return parentShardId;  
    /**  
        assert b == false || this.primary == other.primary : "ShardRouting is a relocation target but primary flag is different."
    public String shortSummary() {
/**
        assert active() : "expected an active shard " + this;
            relocatingNodeId,
            return unassignedInfo.getReason() == UnassignedInfo.Reason.INDEX_CREATED;  
            return null;
            allocationId,  
     * Set the unassigned primary shard to non-primary  
     * @param relocatingNodeId id of the node to relocate the shard
        out.writeOptionalString(relocatingNodeId);
            || state != ShardRoutingState.RELOCATING  
/*
        if (recoverySource != null ? !recoverySource.equals(other.recoverySource) : other.recoverySource != null) {
    public ShardRouting getTargetRelocatingShard() {  
     * The target shard routing will be the INITIALIZING state and have relocatingNodeId set to the  
    @Override  
 *
        return new ShardRouting(  
            throw new IllegalShardRoutingStateException(this, "Cannot move a search only replica to primary");
            expectedShardSize
        out.writeBoolean(primary);  
    }  
        boolean b = this.allocationId != null
        assert this.unassignedInfo.isDelayed() || (unassignedInfo.isDelayed() == false) : "cannot transition from non-delayed to delayed";
    }
        boolean b = this.allocationId != null  
            AllocationId.newRelocation(allocationId),  
        return this.currentNodeId;  
    /**
            shardId,
        }  
        String currentNodeId,
    public ShardRouting(StreamInput in) throws IOException {
        }
     * Returns <code>true</code> iff this shard is assigned to a node ie. not
    public ShardRouting reinitializeReplicaShard() {  
        assert relocatingNodeId == null : this;
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;  
    @Nullable  
        assert primary == false : this;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assert state == ShardRoutingState.UNASSIGNED : this;
        assert b == false || this.currentNodeId.equals(other.currentNodeId)  
            .field("relocating_node", relocatingNodeId())  
            null,  
     * Returns <code>true</code> iff this shard is a search only replica.  
            currentNodeId,
            shardSize = in.readLong();
        UnassignedInfo unassignedInfo  
        assert relocatingNodeId != null : this;  
            throw new IllegalShardRoutingStateException(this, "Not a primary shard, can't move to replica");
                shardId,
    private final ShardRoutingState state;
                + this
    }
    }
            primary,
     * no allocation at all..
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
     */
            false,
                + "]";
     * The shard is unassigned (not allocated to any node).
     */  
            allocationId = AllocationId.newInitializing(existingAllocationId);
                + other
 * Modifications Copyright OpenSearch Contributors. See
        }
    public ShardRouting moveUnassignedFromPrimary() {
        }
        if (primary != other.primary) {
    }  
     * Removes relocation source of a non-primary shard. The shard state must be <code>INITIALIZING</code>.
        return new ShardRouting(
        return this.primary;
        return unassignedInfo;
        if (allocationId != null) {  
            shardId,
            } else {
    }  
     * <code>INITIALIZING</code> or <code>RELOCATING</code>. Any relocation will be
        fieldBuilder.field("node", currentNodeId())
            primary,
            unassignedInfo,
            || searchOnly
        return sb.toString();
 * {@link ShardRouting} immutably encapsulates information about shard
        }
    public int getId() {
 * You may obtain a copy of the License at  
            unassignedInfo,  
        assert relocating();
    public String relocatingNodeId() {  
            currentNodeId,  
        return this.allocationId;
        if (!primary) {  
        }
                + this  
    }  
     * Returns the expected shard size for {@link ShardRoutingState#RELOCATING} and {@link ShardRoutingState#INITIALIZING}
        );
    public boolean isSplitTarget() {
            null,  
    /**
            allocationId.toXContent(builder, params);
            searchOnly,
        return new ShardRouting(  
}
            // relocation target  
     * A shard iterator with just this shard in it.  
     *
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    private final ShardRouting targetRelocatingShard;  
            relocatingNodeId,  
public class ShardRouting implements Writeable, ToXContentObject {
    /**
            recoverySource,
                sb.append("[S]");
            state,  
            searchOnly,  
    }  
        AllocationId allocationId,
            state,  
        this.shardId = shardId;
    }  
            return true;
            && this.allocationId.getId().equals(other.allocationId.getRelocationId());  
    }  
        }
            allocationId,
        this.relocatingNodeId = relocatingNodeId;  
            shardId,  
 * The OpenSearch Contributors require contributions made to  
        );
            false,
        return new ShardRouting(  
    public boolean equalsIgnoringMetadata(ShardRouting other) {  
        }  
                + " This ["
        assert state == ShardRoutingState.UNASSIGNED : "expected an unassigned shard " + this;
            false,
        unassignedInfo = in.readOptionalWriteable(UnassignedInfo::new);
/*  
                + " This ["
    }
    public ShardId shardId() {
        this(new ShardId(in), in);  
            search,
        if (this.unassignedInfo != null) {
        if (shardId != null ? !shardId.equals(other.shardId) : other.shardId != null) {
        this.primary = primary;
     * @throws IllegalShardRoutingStateException if shard is already a replica
     *  
            : "ShardRouting is a relocation source but relocating node isn't equal to other's current node."
    public UnassignedInfo unassignedInfo() {
            || recoverySource == RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE : "replica shards always recover from primary";  
    ) {
        } else {
            sb.append(", expected_shard_size[").append(expectedShardSize).append("]");
    /**  
        assert b == false || this.shardId.equals(other.shardId)  
                + " This ["
        assert b == false || other.currentNodeId().equals(this.relocatingNodeId)
            expectedShardSize
        return searchOnly;  
        this.state = state;  
        AllocationId allocationId = this.allocationId;
        ShardRoutingState state,
        return b;
    }  
        }  
 * KIND, either express or implied.  See the License for the
        }  
            recoverySource,
     */  
        long expectedShardSize,  
     * @see ShardRoutingState#RELOCATING
     */
            UNAVAILABLE_EXPECTED_SHARD_SIZE  
     **/  
        recoveringChildShards = null;
        } else {
    /**
        out.writeOptionalWriteable(allocationId);  
     * source node.
            shardId,
        if (unassignedInfo != null ? !unassignedInfo.equals(that.unassignedInfo) : that.unassignedInfo != null) {
            currentNodeId,
            currentNodeId,  
        targetRelocatingShard = initializeTargetRelocatingShard();
    }
    }
        assert b == false || this.state == ShardRoutingState.RELOCATING  
            primary,  
            false,  
    /**  
                primary,
    }
    }
import java.util.List;
            searchOnly = in.readBoolean();  
     * @throws IllegalShardRoutingStateException if shard is already a primary
        }
    public boolean splitting() {
        if (expectedShardSize != UNAVAILABLE_EXPECTED_SHARD_SIZE) {
    public boolean assignedToNode() {
        if (existingAllocationId == null) {
 * @opensearch.api
                + other
     * to <code>RELOCATING</code>.
        final RecoverySource recoverySource;
        boolean primary,
            shardRoutingState,
            : "ShardRouting is a relocation target but both indexRoutings are not of the same shard id."  
            recoverySource,
                relocatingNodeId,
        int h = hashCode;  
        return this.relocatingNodeId;
        RecoverySource recoverySource,
    /**
        this.currentNodeId = currentNodeId;
            shardId,
            searchOnly = false;
     * another node. Otherwise <code>false</code>
        UnassignedInfo unassignedInfo
            currentNodeId,  
    }
                + other
            builder.field("recovery_source", recoverySource);
            null,
        }
                + "], target ["
    }
                isSearchOnly() ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : PeerRecoverySource.INSTANCE,
            return false;
     */
            currentNodeId,
     * The shard is in started mode.  
    /**
        }
        if (unassignedInfo != null) {
     * <p>  
    public boolean isRelocationTargetOf(ShardRouting other) {
        expectedShardSize = shardSize;  
     * Returns <code>true</code> if this shard is a child shard created by an in-place split.  
        UnassignedInfo unassignedInfo,
