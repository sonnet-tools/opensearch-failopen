            return false;  
         */  
    }  
     *  
 * KIND, either express or implied.  See the License for the
            System.currentTimeMillis(),
import java.util.Set;  
        return CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.get(clusterSettings);
         * Unassigned as a result of importing a dangling index.
        this.message = message;  
import java.time.ZoneOffset;  
        long nextDelayNanos = Long.MAX_VALUE;
import org.opensearch.core.common.io.stream.StreamOutput;
 *  
        result = 31 * result + Integer.hashCode(failedAllocations);  
    );  
     * the index settings or the cluster-level default.  
     * @param failedShard the copy as it is in the routing table being updated
                case 2:
     * @see org.opensearch.cluster.routing.allocation.AllocationService#applyFailedShards(ClusterState, List, List)  
 * The OpenSearch Contributors require contributions made to  
    }
     * The reason why the shard is unassigned.
        if (delayed != that.delayed) {
    @Override
     *
            AllocationStatus.NO_ATTEMPT,  
                    return DECIDERS_NO;
     * @param unassignedTimeMillis the time of unassignment used to display to in our reporting.
        result = 31 * result + failedNodeIds.hashCode();
        REINITIALIZED,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.opensearch.common.Nullable;  
         * When a shard moves from started back to initializing.
            return true;  
     */
            System.nanoTime(),  
        /**  
     *
        }
        Property.NodeScope
     * Returns 0 if delay is negative
         */
     * and the supplied effective cluster settings.
        /**
        result = 31 * result + (failure != null ? failure.hashCode() : 0);  
     */
    /**  
        boolean delayed,
        builder.startObject("unassigned_info");
     * at the end and handle version serialization properly.  
            failedNodeIds.add(failedShard.currentNodeId());
     * @param failure              the shard level failure that caused this shard to be unassigned, if exists.
    private final Reason reason;
        return findNextDelayedAllocation(currentNanoTime, state, state.metadata().settings());
         * Forced manually to allocate  
        REALLOCATED_REPLICA,
        }  
        public void writeTo(StreamOutput out) throws IOException {  
        out.writeLong(unassignedTimeMillis);
        this.failure = in.readException();
    public static long findNextDelayedAllocation(long currentNanoTime, ClusterState state) {
            sb.append(", failed_attempts[").append(failedAllocations).append("]");
    }  
        long unassignedTimeMillis
     */
        return delayed;
         */
    }  
        Property.Dynamic,
    /**
    @Deprecated  
         */
        this.lastAllocationStatus = AllocationStatus.readFrom(in);
                }
        /**  
     */
            }  
        final Set<String> failedNodeIds;  
                case NO:  
     * Returns 0 if delay is negative.
        AllocationStatus lastAllocationStatus,
        INDEX_CLOSED,  
import java.time.Instant;
        REPLICA_ADDED,  
            + " for reason "
     */  
            return false;  
    }
    }  
    }  
            + reason;
    }  
import org.opensearch.core.xcontent.XContentBuilder;
    /**
    public static TimeValue getNodeLeftDelayedTimeout(final Settings indexSettings, final Settings clusterSettings) {
         * The allocation attempt was throttled on the shard by the allocation deciders
        /**
 * compatible open source license.
            false,
import java.util.HashSet;
    }
    }  
        return this.message;  
         * Unassigned as a result of restoring into a new index.
    public static int getNumberOfDelayedUnassigned(ClusterState state) {  
     * Returns optional details explaining the reasons.
        );  
            this.id = id;
            Objects.requireNonNull(decision);
import java.util.function.Predicate;
    }
         */
    @PublicApi(since = "1.0.0")
                    return FETCHING_SHARD_DATA;
                    return NO_VALID_SHARD_COPY;
        INDEX_REOPENED,
        int result = reason.hashCode();
        "index.unassigned.node_left.delayed_timeout",
    private final String message;  
        /**  
    /**
    public void writeTo(StreamOutput out) throws IOException {
         */  
    public String toString() {
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                case 0:
        /**  
        return message + (failure == null ? "" : ", failure " + ExceptionsHelper.detailedMessage(failure));
        if (failedAllocations > 0) {
    public enum Reason {
    @Override
         * The shard was denied allocation to a node because there were no valid shard copies found for it;
        if (this == o) {
        // This means that in cluster-manager fail-over situations, elapsed delay time is forgotten.
    /**  
        /**
        out.writeCollection(failedNodeIds, StreamOutput::writeString);
    public long getUnassignedTimeInNanos() {  
     *
public final class UnassignedInfo implements ToXContentFragment, Writeable {  
        return state.routingTable().shardsMatchingPredicateCount(predicate);
}  
        public static AllocationStatus fromDecision(Decision.Type decision) {  
        }
        if (Objects.equals(failure, that.failure) == false) {
    }  
     * @param delayed              if allocation of this shard is delayed due to delayed node-left timeout settings.
        result = 31 * result + Boolean.hashCode(delayed);
 * software distributed under the License is distributed on an
        return Math.max(0L, delayTimeoutNanos - (nanoTimeNow - unassignedTimeNanos));  
        @Nullable Exception failure,  
        }
import java.util.List;  
                    throw new IllegalArgumentException("Unknown AllocationStatus value [" + id + "]");
    }
        // As System.nanoTime() cannot be compared across different JVMs, reset it to now.  
     *
         * Unassigned as a result of restoring into a closed index.  
        "cluster.routing.allocation.unassigned.node_left.delayed_timeout",
        return failure;
    /**
                case THROTTLE:
        return failedAllocations;  
        }  
        } else {
import org.opensearch.core.common.io.stream.StreamInput;
 *
        }  
        /**
        }
    }
                case 3:
        }
        result = 31 * result + lastAllocationStatus.hashCode();
    }
     * Reason why the shard is in unassigned state.  
 * this work for additional information regarding copyright
        result = 31 * result + Long.hashCode(unassignedTimeMillis);
    @Override  
                    return DECIDERS_NO;
                case 4:  
            out.writeByte(id);
            switch (decision) {
                    throw new IllegalArgumentException("no allocation attempt from decision[" + decision + "]");
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
            + failedAllocations  
    /**
     * Only relevant if shard is effectively delayed (see {@link #isDelayed()})
     */
                    nextDelayNanos = newComputedLeftDelayNanos;
     * <p>
    ) {  
import org.opensearch.cluster.metadata.Metadata;  
     * Returns -1 if no delayed shard is found.
        this.failedNodeIds = Collections.unmodifiableSet(failedNodeIds);
     * @param message              more information about cause.
     *  
 * @opensearch.api  
 * license agreements. See the NOTICE file distributed with
         */
 * Licensed to Elasticsearch under one or more contributor  
        DANGLING_INDEX_IMPORTED,  
     * This set will be discarded when a shard moves to started. And if a shard is failed while started (i.e., from started to unassigned),
        }
     */
    /**
                    return NO_ATTEMPT;  
        this.message = in.readOptionalString();
        }
        builder.field("delayed", delayed);
    /**  
     * Returns additional failure exception details if exists.
     */  
import java.util.Collections;
        }
import java.util.Objects;
        String details = getDetails();  
         */
     * @param unassignedTimeNanos  the time to use as the base for any delayed re-assignment calculation  
     */  
     *
            builder.field("details", details);
    }  
    public UnassignedInfo(  
import org.opensearch.common.time.DateFormatter;
    /**
        /**
    /**
 */
     * creates an UnassignedInfo object based on **current** time
        REROUTE_CANCELLED,  
     * uses this set to avoid repeatedly canceling ongoing recoveries for copies on those nodes although they can perform noop recoveries.
         */
    /**
            return null;
    public Exception getFailure() {
                    return DECIDERS_THROTTLED;  
            return false;  
        sb.append(", at[").append(DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(unassignedTimeMillis))).append("]");
        /**
        @Override
     * copy had before, and the copy's node added to the nodes it has failed on.  
    public long getUnassignedTimeInMillis() {  
        this.reason = Objects.requireNonNull(reason);
    }
        if (failedAllocations != that.failedAllocations) {
            return false;  
     * or the built-in cluster default if the index setting is not set.
        this.unassignedTimeMillis = in.readLong();
        /**  
         * Unassigned as a result of closing an index.
    /**
        int failedAllocations,
        result = 31 * result + (message != null ? message.hashCode() : 0);
            failedNodeIds = new HashSet<>(previous.getFailedNodeIds().size() + 1);
     */
         */
import org.opensearch.cluster.routing.allocation.decider.Decision;
         */
    /**
        if (Objects.equals(message, that.message) == false) {
     * Finds the next (closest) delay expiration of an delayed shard in nanoseconds based on current time.  
         */  
     * Returns the number of shards that are unassigned and currently being delayed.
    @PublicApi(since = "1.0.0")
                if (newComputedLeftDelayNanos < nextDelayNanos) {  
    }
    public static final DateFormatter DATE_TIME_FORMATTER = DateFormatter.forPattern("date_optional_time").withZone(ZoneOffset.UTC);
        sb.append("[reason=").append(reason).append("]");
    }
            builder.field("failed_nodes", failedNodeIds);  
        assert !(message == null && failure != null) : "provide a message if a failure exception is provided";  
     * A set of nodeIds that failed to complete allocations for this shard. {@link org.opensearch.gateway.ReplicaShardAllocator}  
            sb.append(", failed_nodes[").append(failedNodeIds).append("]");
        return this.reason;
        );
     * Finds the next (closest) delay expiration of a delayed shard in nanoseconds based on current time  
        MANUAL_ALLOCATION,
        }
        DELAYED_ALLOCATION((byte) 4),
        this.lastAllocationStatus = Objects.requireNonNull(lastAllocationStatus);  
         * The shard was denied allocation to a node because the allocation deciders all returned a NO decision
         * Unassigned as a result of a failed primary while the replica was initializing.
        /**
    @Nullable  
         * Unassigned as a result of a full cluster recovery.
/*  
        PRIMARY_FAILED,  
     * Note, we use timestamp here since we want to make sure its preserved across node serializations.
 * Unless required by applicable law or agreed to in writing,
        }
            UnassignedInfo unassignedInfo = shard.unassignedInfo();
         * Unassigned as allocation of this child shard is pending.
import org.opensearch.common.settings.Setting;
        Property.IndexScope
     * Calculates the delay left based on current time (in nanoseconds) and the effective delay defined by
    /**
        this.unassignedTimeNanos = unassignedTimeNanos;
            "failed shard on node [" + failedShard.currentNodeId() + "]: " + message,
        DEFAULT_DELAYED_NODE_LEFT_TIMEOUT,
    }
        /**
     * causing it to remain in the unassigned state.  
            Reason.ALLOCATION_FAILED,  
 * not use this file except in compliance with the License.
     * Only relevant if shard is effectively delayed (see {@link #isDelayed()})
    public long getRemainingDelay(final long nanoTimeNow, final Settings indexSettings, final Settings clusterSettings) {  
        }
            return toString().toLowerCase(Locale.ROOT);
    }  
        this.unassignedTimeNanos = System.nanoTime();
     * @param reason               the cause for making this shard unassigned. See {@link Reason} for more information.  
        Predicate<ShardRouting> predicate = s -> s.state() == ShardRoutingState.UNASSIGNED && s.unassignedInfo().isDelayed();
     * Returns true if allocation of this shard is delayed due to delayed node-left timeout settings.
     * @opensearch.api
     * ONLY EXPOSED FOR TESTS!
    public UnassignedInfo(StreamInput in) throws IOException {  
import java.util.Locale;
    }  
     * otherwise returns the cluster-level delayed allocation timeout.
         * Unassigned as a result of explicit cancel reroute command.
            }  
        builder.field("allocation_status", lastAllocationStatus.value());
     * @see org.opensearch.gateway.ReplicaShardAllocator#processExistingRecoveries(RoutingAllocation)
import org.opensearch.common.unit.TimeValue;  
         * Unassigned as a result of the node hosting it leaving the cluster.  
            builder.field("failed_attempts", failedAllocations);  
        AllocationStatus(byte id) {
    public boolean isDelayed() {  
         * A better replica location is identified and causes the existing replica allocation to be cancelled.  
 * SPDX-License-Identifier: Apache-2.0
            unassignedTimeMillis,
        /**
        return sb.toString();
 *    http://www.apache.org/licenses/LICENSE-2.0
                case 5:
     *
        NEW_INDEX_RESTORED,
        if (details != null) {
            false,  
        out.writeException(failure);
    private final int failedAllocations;
        out.writeOptionalString(message);
            return false;  
 * You may obtain a copy of the License at  
    @Nullable
        }
    }
     * The timestamp in milliseconds when the shard became unassigned, based on System.currentTimeMillis().  
        if (failedNodeIds.isEmpty() == false) {
        this.failure = failure;
         */
    @Nullable
        long delayTimeoutNanos = getNodeLeftDelayedTimeout(indexSettings, clusterSettings).nanos();
            failedNodeIds = Collections.emptySet();  
        return this.unassignedTimeNanos;
    private final long unassignedTimeMillis; // used for display and log messages, in milliseconds  
        assert (failedAllocations > 0) == (reason == Reason.ALLOCATION_FAILED) : "failedAllocations: "
    public UnassignedInfo(Reason reason, String message) {  
        }
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeByte((byte) reason.ordinal());  
@PublicApi(since = "1.0.0")
        for (ShardRouting shard : routingTable.shardsWithState(ShardRoutingState.UNASSIGNED)) {  
         * this can happen on node restart with gateway allocation  
                Settings indexSettings = metadata.index(shard.index()).getSettings();  
            return false;  
        return builder;  
     * Returns the node-left delayed allocation timeout from the index settings if explicitly configured,
    }
        INDEX_CREATED,  
 */
package org.opensearch.cluster.routing;
    private final long unassignedTimeNanos; // in nanoseconds, used to calculate delay for delayed shard allocation
        }
        NO_VALID_SHARD_COPY((byte) 1),
     */
    public int getNumFailedAllocations() {
     */  
        String details = getDetails();
            failedNodeIds.addAll(previous.getFailedNodeIds());  
 */  
        builder.endObject();
    public static long findNextDelayedAllocation(long currentNanoTime, ClusterState state, Settings clusterSettings) {
        NO_ATTEMPT((byte) 5);  
        if (details != null) {  
    );
    /**
        if (unassignedTimeMillis != that.unassignedTimeMillis) {
        builder.field("at", DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(unassignedTimeMillis)));
     * Note, ordering of the enum is important, make sure to add new values
                // calculate next time to schedule
 */  
    private final Exception failure;
    public long getRemainingDelay(final long nanoTimeNow, final Settings indexSettings) {  
        if (lastAllocationStatus != that.lastAllocationStatus) {
     * @opensearch.api
            failedAllocations + 1,  
        }
    @Override  
    public static final Setting<TimeValue> CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING = Setting.positiveTimeSetting(  
         */
         * Unassigned as a result of opening a closed index.  
    public static final Setting<TimeValue> INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING = Setting.positiveTimeSetting(
        if (failedAllocations > 0) {  
import org.opensearch.core.common.io.stream.Writeable;  
        long unassignedTimeNanos,
        Property.Dynamic,  
 * ownership. Elasticsearch licenses this file to you under  
            switch (id) {  
     * @param message     why it failed, which is recorded after the node it failed on  
            sb.append(", details[").append(details).append("]");
        long unassignedTimeNanos,
    public static UnassignedInfo failedShard(  
        if (reason != that.reason) {
     */
        }
        this.delayed = in.readBoolean();  
            reason,
            reason == Reason.ALLOCATION_FAILED ? 1 : 0,
    public static final TimeValue DEFAULT_DELAYED_NODE_LEFT_TIMEOUT = TimeValue.timeValueMinutes(1);
        if (INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.exists(indexSettings)) {
                    return DECIDERS_THROTTLED;  
        CHILD_SHARD_CREATED
        NODE_LEFT,
        UnassignedInfo that = (UnassignedInfo) o;  
        return this.unassignedTimeMillis;
     * Returns -1 if no delayed shard is found.  
    private final boolean delayed; // if allocation of this shard is delayed due to delayed node-left timeout settings
     * @param failure     what it failed with, if anything
                default:
        UnassignedInfo previous = failedShard.unassignedInfo();
        this.failedAllocations = failedAllocations;
    }
    public String getMessage() {
 * specific language governing permissions and limitations
     * the currently assigned node won't be added to this set.  
         * Unassigned as a result of explicit addition of a replica.
        /**  
            unassignedTimeNanos,
        }
        /**
        if (previous != null) {
        if (failedNodeIds.isEmpty() == false) {  
     * @param lastAllocationStatus the result of the last allocation attempt for this shard  
     * Calculates the delay left based on current time (in nanoseconds) and the delay defined by the index settings,  
     */
    public AllocationStatus getLastAllocationStatus() {
    private final Set<String> failedNodeIds;  
     * @return calculated delay in nanoseconds
        assert nanoTimeNow >= unassignedTimeNanos;
        out.writeVInt(failedAllocations);  
    }
     * @param reason  the cause for making this shard unassigned. See {@link Reason} for more information.  
     * @deprecated use {@link #getRemainingDelay(long, Settings, Settings)} with effective cluster settings.  
     * Returns the number of previously failed allocations of this shard.  
    /**  
import org.opensearch.common.settings.Settings;
        FORCED_EMPTY_PRIMARY,
        Reason reason,
        Set<String> failedNodeIds  
        sb.append(", allocation_status[").append(lastAllocationStatus.value()).append("]");  
        this.failedNodeIds = Collections.unmodifiableSet(in.readSet(StreamInput::readString));
        this.reason = Reason.values()[(int) in.readByte()];
    ) {
        @Nullable Exception failure,  
     * The unassigned info for a copy that failed: {@link Reason#ALLOCATION_FAILED}, one more failed allocation than the
        return getRemainingDelay(nanoTimeNow, indexSettings, Settings.EMPTY);
            return false;  
        DECIDERS_NO((byte) 0),  
    public Set<String> getFailedNodeIds() {
        RoutingTable routingTable = state.routingTable();
     * @return calculated delay in nanoseconds
        }
 *
            message,  
    /**
     * Note, ordering of the enum is important, make sure to add new values
     **/
            Collections.emptySet()
    private final AllocationStatus lastAllocationStatus; // result of the last allocation attempt for this shard
         */
     * @param failedNodeIds        a set of nodeIds that failed to complete allocations for this shard
         */
import org.opensearch.common.settings.Setting.Property;  
            failure,
     */
    public enum AllocationStatus implements Writeable {
    public boolean equals(Object o) {
        return result;  
     * <p>
         */  
         * Unassigned as a result of a failed allocation of the shard.
        /**
    /**
                case 1:  
        this(
            return false;  
         * Allocation decision has been delayed  
        ALLOCATION_FAILED,
        return failedNodeIds.equals(that.failedNodeIds);
import org.opensearch.common.annotation.PublicApi;
         * Unassigned as a result of an API creation of an index.
    public Reason getReason() {
     * @param message more information about cause.
     * @deprecated use {@link #findNextDelayedAllocation(long, ClusterState, Settings)} with effective cluster settings.
     * Get the status for the last allocation attempt for this shard.
 * Holds additional information as to why the shard is in unassigned state.
     */  
        }
        builder.field("reason", reason);  
        /**  
        Metadata metadata = state.metadata();  
         */
         * No allocation attempt has been made yet
     */
        return failedNodeIds;  
import java.io.IOException;
         * Waiting on getting shard data from all nodes before making a decision about where to allocate the shard
        /**
        DECIDERS_THROTTLED((byte) 2),  
        private final byte id;
/**  
            AllocationStatus.NO_ATTEMPT,
import org.opensearch.core.xcontent.ToXContentFragment;
     * Builds a string representation of the message and the failure if exists.  
        /**
     */  
/*
        this.delayed = delayed;
        assert !(delayed && reason != Reason.NODE_LEFT) : "shard can only be delayed if it is unassigned due to a node leaving";
    public String shortSummary() {
    @Deprecated
 * this file be licensed under the Apache-2.0 license or a
        if (o == null || getClass() != o.getClass()) {
/*  
import org.opensearch.ExceptionsHelper;
    }  
    public String getDetails() {  
import org.opensearch.cluster.ClusterState;
        CLUSTER_RECOVERED,
        sb.append(", delayed=").append(delayed);  
        // Do not serialize unassignedTimeNanos as System.nanoTime() cannot be compared across different JVMs
        return new UnassignedInfo(
        /**  
        @Nullable String message,
        public static AllocationStatus readFrom(StreamInput in) throws IOException {
        return "unassigned_info[" + shortSummary() + "]";  
         * Unassigned after forcing an empty primary
     */
    /**  
    }
            null,
     * The timestamp in nanoseconds when the shard became unassigned, based on System.nanoTime().
     * at the end and handle version serialization properly.  
        this.failedAllocations = in.readVInt();  
            if (unassignedInfo.isDelayed()) {
            failedNodeIds
 * Modifications Copyright OpenSearch Contributors. See
            byte id = in.readByte();
        public String value() {  
 * GitHub history for details.
 *
        EXISTING_INDEX_RESTORED,
         */
            return INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.get(indexSettings);  
    /**
        out.writeBoolean(delayed);  
         */
                    return DELAYED_ALLOCATION;
     * Captures the status of an unsuccessful allocation attempt for the shard,
                default:
        /**
        /**  
        ShardRouting failedShard,
         */  
        if (message == null) {
        String message,
     * Returns 0 if delay is negative  
        return lastAllocationStatus;
    public int hashCode() {  
        return nextDelayNanos == Long.MAX_VALUE ? -1L : nextDelayNanos;
     * Returns 0 if delay is negative.
         */  
        DEFAULT_DELAYED_NODE_LEFT_TIMEOUT,  
        this.unassignedTimeMillis = unassignedTimeMillis;  
        }
        FETCHING_SHARD_DATA((byte) 3),
        StringBuilder sb = new StringBuilder();  
        int failedAllocations = previous != null ? previous.getNumFailedAllocations() : 0;
 * under the License.  
     * Used to calculate the delay for delayed shard allocation.  
        lastAllocationStatus.writeTo(out);
        long unassignedTimeMillis,  
         */  
                final long newComputedLeftDelayNanos = unassignedInfo.getRemainingDelay(currentNanoTime, indexSettings, clusterSettings);
