    /**
            sb.append(", details[").append(details).append("]");
        builder.field("at", DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(unassignedTimeMillis)));
        long nextDelayNanos = Long.MAX_VALUE;
    public boolean equals(Object o) {
         */
        int failedAllocations,
        int result = reason.hashCode();
 * SPDX-License-Identifier: Apache-2.0
        builder.startObject("unassigned_info");
 *
 * specific language governing permissions and limitations
    public int getNumFailedAllocations() {
        return this.reason;
     * at the end and handle version serialization properly.
        } else {
    /**
         * Unassigned as a result of the node hosting it leaving the cluster.
            + " for reason "
import org.opensearch.common.settings.Settings;
        out.writeCollection(failedNodeIds, StreamOutput::writeString);
 * under the License.
        }
            failedNodeIds = new HashSet<>(previous.getFailedNodeIds().size() + 1);
        }
        }
     * Only relevant if shard is effectively delayed (see {@link #isDelayed()})
     */
        this.failure = in.readException();
     * @param message     why it failed, which is recorded after the node it failed on
    public static long findNextDelayedAllocation(long currentNanoTime, ClusterState state, Settings clusterSettings) {
         * Unassigned as a result of closing an index.
    /**
        if (lastAllocationStatus != that.lastAllocationStatus) {
        this.delayed = in.readBoolean();
    /**
    }
            UnassignedInfo unassignedInfo = shard.unassignedInfo();
        }
            switch (id) {
        return failedNodeIds.equals(that.failedNodeIds);
        String details = getDetails();
    public long getRemainingDelay(final long nanoTimeNow, final Settings indexSettings, final Settings clusterSettings) {
    }
         * this can happen on node restart with gateway allocation
        NEW_INDEX_RESTORED,
        builder.field("reason", reason);
     * Only relevant if shard is effectively delayed (see {@link #isDelayed()})
     * The unassigned info for a copy that failed: {@link Reason#ALLOCATION_FAILED}, one more failed allocation than the
        this.failedNodeIds = Collections.unmodifiableSet(in.readSet(StreamInput::readString));
     */
        return message + (failure == null ? "" : ", failure " + ExceptionsHelper.detailedMessage(failure));
        assert !(delayed && reason != Reason.NODE_LEFT) : "shard can only be delayed if it is unassigned due to a node leaving";
            return INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.get(indexSettings);
                    return DECIDERS_THROTTLED;
        result = 31 * result + lastAllocationStatus.hashCode();
        out.writeOptionalString(message);
            switch (decision) {
                case 3:
         */
                    return DECIDERS_THROTTLED;
        this.lastAllocationStatus = Objects.requireNonNull(lastAllocationStatus);
     */
import org.opensearch.core.xcontent.ToXContentFragment;
     * @param message more information about cause.
     * Finds the next (closest) delay expiration of an delayed shard in nanoseconds based on current time.
        long unassignedTimeNanos,
import java.time.ZoneOffset;
     * the index settings or the cluster-level default.
    @Deprecated
            out.writeByte(id);
    @Nullable
            System.currentTimeMillis(),
        result = 31 * result + Integer.hashCode(failedAllocations);
    public static final Setting<TimeValue> INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING = Setting.positiveTimeSetting(
         * A better replica location is identified and causes the existing replica allocation to be cancelled.
     *
            Collections.emptySet()
        return state.routingTable().shardsMatchingPredicateCount(predicate);
        if (reason != that.reason) {
    }
        builder.endObject();
    public String getDetails() {
    }
    /**
         */
     * @param failedNodeIds        a set of nodeIds that failed to complete allocations for this shard
     * at the end and handle version serialization properly.
         */
        @Override
     * otherwise returns the cluster-level delayed allocation timeout.
        CHILD_SHARD_CREATED
        public static AllocationStatus fromDecision(Decision.Type decision) {
            return false;
                case 1:
            unassignedTimeMillis,
        return CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.get(clusterSettings);
     *
        if (Objects.equals(failure, that.failure) == false) {
        out.writeByte((byte) reason.ordinal());
            failedNodeIds.addAll(previous.getFailedNodeIds());
     * Calculates the delay left based on current time (in nanoseconds) and the effective delay defined by
    }
    private final String message;
    private final AllocationStatus lastAllocationStatus; // result of the last allocation attempt for this shard
    }
         */
        if (delayed != that.delayed) {
 * ownership. Elasticsearch licenses this file to you under
     * The timestamp in nanoseconds when the shard became unassigned, based on System.nanoTime().
        DEFAULT_DELAYED_NODE_LEFT_TIMEOUT,
        this.failedAllocations = in.readVInt();
        public String value() {
        /**
        }
        }
        }
            builder.field("details", details);
        this.failedNodeIds = Collections.unmodifiableSet(failedNodeIds);
        /**
     */
     */
     * Note, ordering of the enum is important, make sure to add new values
     * @param unassignedTimeMillis the time of unassignment used to display to in our reporting.
            Objects.requireNonNull(decision);
     * @param reason               the cause for making this shard unassigned. See {@link Reason} for more information.
        return Math.max(0L, delayTimeoutNanos - (nanoTimeNow - unassignedTimeNanos));
            if (unassignedInfo.isDelayed()) {
        Metadata metadata = state.metadata();
            failedNodeIds
         */
        if (details != null) {
     * Returns 0 if delay is negative
 * not use this file except in compliance with the License.
                case 0:
     * @param lastAllocationStatus the result of the last allocation attempt for this shard
                case NO:
        public void writeTo(StreamOutput out) throws IOException {
    private final Set<String> failedNodeIds;
            return toString().toLowerCase(Locale.ROOT);
                case 2:
            sb.append(", failed_attempts[").append(failedAllocations).append("]");
    @PublicApi(since = "1.0.0")
     * Returns the number of shards that are unassigned and currently being delayed.
 */
import org.opensearch.common.unit.TimeValue;
 */
         */
     * Note, we use timestamp here since we want to make sure its preserved across node serializations.
    private final boolean delayed; // if allocation of this shard is delayed due to delayed node-left timeout settings
            this.id = id;
                    throw new IllegalArgumentException("no allocation attempt from decision[" + decision + "]");
        result = 31 * result + (message != null ? message.hashCode() : 0);
        if (failedNodeIds.isEmpty() == false) {
            failedAllocations + 1,
    /**
        /**
    /**
        return builder;
            message,
import org.opensearch.common.settings.Setting.Property;
        Predicate<ShardRouting> predicate = s -> s.state() == ShardRoutingState.UNASSIGNED && s.unassignedInfo().isDelayed();
        }
     * A set of nodeIds that failed to complete allocations for this shard. {@link org.opensearch.gateway.ReplicaShardAllocator}
    }
                default:
                    return NO_VALID_SHARD_COPY;
    /**
        this.delayed = delayed;
import org.opensearch.common.settings.Setting;
        CLUSTER_RECOVERED,
        /**
            return false;
        @Nullable String message,
    }
    public Set<String> getFailedNodeIds() {
     * @return calculated delay in nanoseconds
        DANGLING_INDEX_IMPORTED,
/**
                    nextDelayNanos = newComputedLeftDelayNanos;
            return true;
        // Do not serialize unassignedTimeNanos as System.nanoTime() cannot be compared across different JVMs
                    return DECIDERS_NO;
     * Calculates the delay left based on current time (in nanoseconds) and the delay defined by the index settings,
    @PublicApi(since = "1.0.0")
        builder.field("allocation_status", lastAllocationStatus.value());
     * uses this set to avoid repeatedly canceling ongoing recoveries for copies on those nodes although they can perform noop recoveries.
        "index.unassigned.node_left.delayed_timeout",
    public UnassignedInfo(
    }
     * Used to calculate the delay for delayed shard allocation.
     */
            byte id = in.readByte();
        /**
@PublicApi(since = "1.0.0")
     * @deprecated use {@link #findNextDelayedAllocation(long, ClusterState, Settings)} with effective cluster settings.
                    return DELAYED_ALLOCATION;
    private final long unassignedTimeNanos; // in nanoseconds, used to calculate delay for delayed shard allocation
     *
     */
        ALLOCATION_FAILED,
                }
     **/
            reason,
import org.opensearch.cluster.routing.allocation.decider.Decision;
        private final byte id;
     * ONLY EXPOSED FOR TESTS!
        result = 31 * result + (failure != null ? failure.hashCode() : 0);
        out.writeVInt(failedAllocations);
    private final Reason reason;
        }
                final long newComputedLeftDelayNanos = unassignedInfo.getRemainingDelay(currentNanoTime, indexSettings, clusterSettings);
        this.failedAllocations = failedAllocations;
         * Unassigned as a result of explicit addition of a replica.
    public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        REROUTE_CANCELLED,
        this.reason = Reason.values()[(int) in.readByte()];
import java.util.Objects;
    public static UnassignedInfo failedShard(
                if (newComputedLeftDelayNanos < nextDelayNanos) {
     * Reason why the shard is in unassigned state.
                case THROTTLE:
        assert nanoTimeNow >= unassignedTimeNanos;
import org.opensearch.core.common.io.stream.StreamInput;
    }
         * Unassigned as allocation of this child shard is pending.
     * @param failure     what it failed with, if anything
     * @param failure              the shard level failure that caused this shard to be unassigned, if exists.
        if (failedAllocations > 0) {
    public AllocationStatus getLastAllocationStatus() {
 * software distributed under the License is distributed on an
/*
    /**
         */
     * Returns the node-left delayed allocation timeout from the index settings if explicitly configured,
        /**
        NO_VALID_SHARD_COPY((byte) 1),
    ) {
    public static TimeValue getNodeLeftDelayedTimeout(final Settings indexSettings, final Settings clusterSettings) {
                case 4:
         * Unassigned as a result of a failed primary while the replica was initializing.
        }
        DELAYED_ALLOCATION((byte) 4),
     */
        DECIDERS_THROTTLED((byte) 2),
        }
        out.writeBoolean(delayed);
    }
        INDEX_REOPENED,
     */
     * Returns 0 if delay is negative.
import java.util.Locale;
     * creates an UnassignedInfo object based on **current** time
        return failure;
        return this.unassignedTimeMillis;
    }
         * Unassigned as a result of importing a dangling index.
     */
                    throw new IllegalArgumentException("Unknown AllocationStatus value [" + id + "]");
    /**
     */
    );
            builder.field("failed_nodes", failedNodeIds);
        }
         * Unassigned as a result of explicit cancel reroute command.
    ) {
            + failedAllocations
    }
            }
    @Nullable
     * Finds the next (closest) delay expiration of a delayed shard in nanoseconds based on current time
            builder.field("failed_attempts", failedAllocations);
    public enum Reason {
    public long getUnassignedTimeInMillis() {
     */
     * and the supplied effective cluster settings.
    @Override
     */
         * Allocation decision has been delayed
        return new UnassignedInfo(
     * <p>
import org.opensearch.core.xcontent.XContentBuilder;
     * The timestamp in milliseconds when the shard became unassigned, based on System.currentTimeMillis().
     * @opensearch.api
        /**
         * The allocation attempt was throttled on the shard by the allocation deciders
    }
        );
    /**
         */
import java.time.Instant;
        /**
 * KIND, either express or implied.  See the License for the
        long delayTimeoutNanos = getNodeLeftDelayedTimeout(indexSettings, clusterSettings).nanos();
        if (failedAllocations != that.failedAllocations) {
         */
        return lastAllocationStatus;
        return failedNodeIds;
     * Returns optional details explaining the reasons.
     *
     */
        /**
            + reason;
        this.lastAllocationStatus = AllocationStatus.readFrom(in);
 * Holds additional information as to why the shard is in unassigned state.
        this.message = in.readOptionalString();
            System.nanoTime(),
    }
     * @param failedShard the copy as it is in the routing table being updated
     * Builds a string representation of the message and the failure if exists.
        /**
    /**
        }
import org.opensearch.cluster.ClusterState;
        long unassignedTimeNanos,
     */
/*
            AllocationStatus.NO_ATTEMPT,
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        result = 31 * result + Long.hashCode(unassignedTimeMillis);
        FETCHING_SHARD_DATA((byte) 3),
        int failedAllocations = previous != null ? previous.getNumFailedAllocations() : 0;
    }
         * The shard was denied allocation to a node because there were no valid shard copies found for it;
        REINITIALIZED,
         * The shard was denied allocation to a node because the allocation deciders all returned a NO decision
     * Returns -1 if no delayed shard is found.
    private final Exception failure;
         */
    public String getMessage() {
        );
         * When a shard moves from started back to initializing.
                default:
         */
        }
        EXISTING_INDEX_RESTORED,
        DECIDERS_NO((byte) 0),
        /**
    private final int failedAllocations;
        }
    }
    public UnassignedInfo(Reason reason, String message) {
        assert !(message == null && failure != null) : "provide a message if a failure exception is provided";
        }
 *
         */
package org.opensearch.cluster.routing;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
     * @see org.opensearch.gateway.ReplicaShardAllocator#processExistingRecoveries(RoutingAllocation)
        UnassignedInfo that = (UnassignedInfo) o;
        }
import org.opensearch.common.Nullable;
        result = 31 * result + failedNodeIds.hashCode();
        if (Objects.equals(message, that.message) == false) {
         */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        Property.Dynamic,
         */
        REALLOCATED_REPLICA,
        this.message = message;
    public Reason getReason() {
        }
         */
        // This means that in cluster-manager fail-over situations, elapsed delay time is forgotten.
 *    http://www.apache.org/licenses/LICENSE-2.0
            return false;
        boolean delayed,
    /**
     */
import java.util.HashSet;
                Settings indexSettings = metadata.index(shard.index()).getSettings();
            reason == Reason.ALLOCATION_FAILED ? 1 : 0,
 */
     * This set will be discarded when a shard moves to started. And if a shard is failed while started (i.e., from started to unassigned),
    }
     * copy had before, and the copy's node added to the nodes it has failed on.
        if (this == o) {
        DEFAULT_DELAYED_NODE_LEFT_TIMEOUT,
    }
        this.unassignedTimeMillis = in.readLong();
        /**
        if (unassignedTimeMillis != that.unassignedTimeMillis) {
    public enum AllocationStatus implements Writeable {
        /**
        return getRemainingDelay(nanoTimeNow, indexSettings, Settings.EMPTY);
         * Unassigned as a result of an API creation of an index.
                // calculate next time to schedule
        return result;
        if (failedAllocations > 0) {
         */
     * Captures the status of an unsuccessful allocation attempt for the shard,
    private final long unassignedTimeMillis; // used for display and log messages, in milliseconds
    public int hashCode() {
     * Note, ordering of the enum is important, make sure to add new values
/*
    }
    /**
    /**
        /**
        sb.append("[reason=").append(reason).append("]");
        /**
import org.opensearch.common.time.DateFormatter;
            null,
         * Unassigned as a result of opening a closed index.
     */
         * Unassigned after forcing an empty primary
            }
        final Set<String> failedNodeIds;
        this(
     * @opensearch.api
    @Nullable
        StringBuilder sb = new StringBuilder();
        /**
        String message,
        Property.NodeScope
 *
     * @param reason  the cause for making this shard unassigned. See {@link Reason} for more information.
        assert (failedAllocations > 0) == (reason == Reason.ALLOCATION_FAILED) : "failedAllocations: "
        }
     * @deprecated use {@link #getRemainingDelay(long, Settings, Settings)} with effective cluster settings.
        Property.Dynamic,
        builder.field("delayed", delayed);
        FORCED_EMPTY_PRIMARY,
            return false;
    /**
            Reason.ALLOCATION_FAILED,
     * <p>
        }
     * @param unassignedTimeNanos  the time to use as the base for any delayed re-assignment calculation
        UnassignedInfo previous = failedShard.unassignedInfo();
            sb.append(", failed_nodes[").append(failedNodeIds).append("]");
        return sb.toString();
            return false;
            false,
    }
        /**
    public String toString() {
            unassignedTimeNanos,
        if (previous != null) {
        RoutingTable routingTable = state.routingTable();
        Reason reason,
import java.io.IOException;
     * Returns -1 if no delayed shard is found.
     * or the built-in cluster default if the index setting is not set.
         */
        /**
        if (failedNodeIds.isEmpty() == false) {
        }
        for (ShardRouting shard : routingTable.shardsWithState(ShardRoutingState.UNASSIGNED)) {
     */
     * Returns 0 if delay is negative
         * Unassigned as a result of a failed allocation of the shard.
        AllocationStatus lastAllocationStatus,
            }
     * the currently assigned node won't be added to this set.
        this.reason = Objects.requireNonNull(reason);
    }
         * Unassigned as a result of restoring into a closed index.
        sb.append(", allocation_status[").append(lastAllocationStatus.value()).append("]");
        lastAllocationStatus.writeTo(out);
 *
        INDEX_CREATED,
     *
        return this.message;
     * @return calculated delay in nanoseconds
    /**
    }
        @Nullable Exception failure,
        return findNextDelayedAllocation(currentNanoTime, state, state.metadata().settings());
 * GitHub history for details.
    public static final DateFormatter DATE_TIME_FORMATTER = DateFormatter.forPattern("date_optional_time").withZone(ZoneOffset.UTC);
import org.opensearch.ExceptionsHelper;
    }
        // As System.nanoTime() cannot be compared across different JVMs, reset it to now.
            return null;
    public long getRemainingDelay(final long nanoTimeNow, final Settings indexSettings) {
 * Unless required by applicable law or agreed to in writing,
     *
        }
    /**
            return false;
        AllocationStatus(byte id) {
     */
         */
         */
            failedNodeIds.add(failedShard.currentNodeId());
                    return DECIDERS_NO;
import java.util.function.Predicate;
         * No allocation attempt has been made yet
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        MANUAL_ALLOCATION,
        /**
     * Returns the number of previously failed allocations of this shard.
     * @see org.opensearch.cluster.routing.allocation.AllocationService#applyFailedShards(ClusterState, List, List)
     * Returns additional failure exception details if exists.
        return this.unassignedTimeNanos;
        this.unassignedTimeNanos = unassignedTimeNanos;
    @Deprecated
 * license agreements. See the NOTICE file distributed with
    }
        this.failure = failure;
import java.util.Collections;
        this.unassignedTimeNanos = System.nanoTime();
        return "unassigned_info[" + shortSummary() + "]";
     * Returns true if allocation of this shard is delayed due to delayed node-left timeout settings.
            return false;
    public static final TimeValue DEFAULT_DELAYED_NODE_LEFT_TIMEOUT = TimeValue.timeValueMinutes(1);
     *
         */
        out.writeException(failure);
            AllocationStatus.NO_ATTEMPT,
        /**
     * Returns 0 if delay is negative.
        NO_ATTEMPT((byte) 5);
        sb.append(", delayed=").append(delayed);
        ShardRouting failedShard,
     * causing it to remain in the unassigned state.
            false,
        return nextDelayNanos == Long.MAX_VALUE ? -1L : nextDelayNanos;
        if (message == null) {
    @Override
        long unassignedTimeMillis
import org.opensearch.core.common.io.stream.Writeable;
        result = 31 * result + Boolean.hashCode(delayed);
        }
 * Modifications Copyright OpenSearch Contributors. See
            failure,
 * The OpenSearch Contributors require contributions made to
        long unassignedTimeMillis,
import java.util.List;
        /**
    @Override
                    return NO_ATTEMPT;
         * Forced manually to allocate
         * Unassigned as a result of restoring into a new index.
     *
        /**
        public static AllocationStatus readFrom(StreamInput in) throws IOException {
 */
    }
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        NODE_LEFT,
    public UnassignedInfo(StreamInput in) throws IOException {
        Property.IndexScope
        sb.append(", at[").append(DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(unassignedTimeMillis))).append("]");
        PRIMARY_FAILED,
    }
    public boolean isDelayed() {
        return failedAllocations;
    public static long findNextDelayedAllocation(long currentNanoTime, ClusterState state) {
     * @param delayed              if allocation of this shard is delayed due to delayed node-left timeout settings.
    public String shortSummary() {
    public long getUnassignedTimeInNanos() {
                case 5:
    /**
            return false;
    );
        @Nullable Exception failure,
         * Unassigned as a result of a full cluster recovery.
import java.util.Set;
         */
     */
    public Exception getFailure() {
public final class UnassignedInfo implements ToXContentFragment, Writeable {
            failedNodeIds = Collections.emptySet();
     * @param message              more information about cause.
        "cluster.routing.allocation.unassigned.node_left.delayed_timeout",
import org.opensearch.core.common.io.stream.StreamOutput;
        this.unassignedTimeMillis = unassignedTimeMillis;
        out.writeLong(unassignedTimeMillis);
     * The reason why the shard is unassigned.
    }
        if (details != null) {
            "failed shard on node [" + failedShard.currentNodeId() + "]: " + message,
 * You may obtain a copy of the License at
    public static int getNumberOfDelayedUnassigned(ClusterState state) {
import org.opensearch.cluster.metadata.Metadata;
        REPLICA_ADDED,
        /**
        INDEX_CLOSED,
        if (INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.exists(indexSettings)) {
        Set<String> failedNodeIds
         * Waiting on getting shard data from all nodes before making a decision about where to allocate the shard
}
                    return FETCHING_SHARD_DATA;
    public static final Setting<TimeValue> CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING = Setting.positiveTimeSetting(
        return delayed;
    /**
        if (o == null || getClass() != o.getClass()) {
 * compatible open source license.
    /**
        String details = getDetails();
import org.opensearch.common.annotation.PublicApi;
        }
     * Get the status for the last allocation attempt for this shard.
         */
 * @opensearch.api
