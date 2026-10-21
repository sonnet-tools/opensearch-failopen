        boolean primaryActive
     * @param primaryRouting the routing entry for the primary shard, may be null
    public String toString() {
        }
    }
        if (unassignedInfo.getLastAllocationStatus() != AllocationStatus.DECIDERS_NO
        return initializingShards;
        initializingShards = in.readVInt();
 * @opensearch.api
    private final int activeShards;
 *     http://www.apache.org/licenses/LICENSE-2.0
     *     Shard health is YELLOW when primary shard is active but at-least one replica shard is inactive.
import org.opensearch.core.common.io.stream.StreamOutput;
        "cluster_shard_health",
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";
            );
    public ClusterShardHealth(final int shardId, final IndexShardRoutingTable shardRoutingTable, final IndexMetadata indexMetadata) {
    static {
/**
    );
                unassignedShards,
        return getShardHealth(primaryRouting, activeShards, totalShards, isSearchOnlyClusterBlockEnabled);
            } else if (shardRouting.unassigned()) {
        boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()
     * </p>
     * </p>
        builder.field(ACTIVE_SHARDS, getActiveShards());
            indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
    }
        for (int index = 0; index < shardRoutings.size(); index++) {
        unassignedShards = in.readVInt();
import java.io.IOException;
        this.initializingShards = computeInitializingShards;
        final ShardRouting primaryRouting,
        (parsedObjects, shardId) -> {
    }
    public boolean equals(Object o) {
 * KIND, either express or implied.  See the License for the
        int computeUnassignedShards = 0;
        }
     *     Shard health is RED when the primary is not active.
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor
     *     <li>Shard health is YELLOW when some (but not all) search replicas are active</li>
        }
        return builder;
        int computeActiveShards = 0;
            && relocatingShards == that.relocatingShards
    public static final ConstructingObjectParser<ClusterShardHealth, Integer> PARSER = new ConstructingObjectParser<>(
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                activeShards,
     * @param totalShards the total number of shards (primary and replicas)
        builder.field(PRIMARY_ACTIVE, isPrimaryActive());
    public static ClusterHealthStatus getShardHealth(
    ) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.common.io.stream.Writeable;
 * this file be licensed under the Apache-2.0 license or a
        this.shardId = shardId;
                || recoveryType == RecoverySource.Type.SNAPSHOT)) {
     * </ul>
    }
    private final int relocatingShards;
            } else if (shardRouting.initializing()) {
    @Override
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        final int activeShards,
 *
            return ClusterHealthStatus.YELLOW;
    public int getInitializingShards() {
 */
        builder.field(INITIALIZING_SHARDS, getInitializingShards());
     *     Shard health is GREEN when all primary and replica shards of the indices are active.
    }
     */
            && primaryActive == that.primaryActive
import java.util.Objects;
}
     *     Shard health is GREEN when all primary and replica shards of the indices are active.
import org.opensearch.cluster.routing.UnassignedInfo;
        out.writeByte(status.value());
        this.activeShards = activeShards;
    }
        this.activeShards = computeActiveShards;
        final boolean isSearchOnlyClusterBlockEnabled
    private static final String ACTIVE_SHARDS = "active_shards";
     * However, in case of exceptional events, for example when the primary shard cannot be assigned to a node or initialization fails at
    @Override
        builder.endObject();
        assert shardRouting.recoverySource() != null : "cannot invoke on a shard that has no recovery source" + shardRouting;
            shardId,
            }
        List<ShardRouting> shardRoutings = shardRoutingTable.shards();
 */
package org.opensearch.cluster.health;
        assert shardRouting.unassignedInfo() != null : "cannot invoke on a shard with no UnassignedInfo: " + shardRouting;
 * You may obtain a copy of the License at
        PARSER.declareInt(constructorArg(), new ParseField(RELOCATING_SHARDS));
                }
        final int totalShards,
            // when warm/searchable-remote shards can serve queries directly off the remote store mid-hydration.
    }
    private final int unassignedShards;
            }
        this(
        out.writeVInt(activeShards);
        int activeShards,
            ShardRouting shardRouting = shardRoutings.get(index);
 *
     *     <li>Shard health is YELLOW when some (but not all) search replicas are active</li>
                initializingShards,
    }
    public static ClusterShardHealth fromXContent(XContentParser parser) throws IOException {
        this.unassignedShards = unassignedShards;
@PublicApi(since = "1.0.0")
     * </p>
import org.opensearch.core.common.Strings;
            int initializingShards = (int) parsedObjects[i++];
import org.opensearch.common.annotation.PublicApi;
                computeInitializingShards++;
            } else {
/*
import org.opensearch.core.xcontent.ConstructingObjectParser;
                computeUnassignedShards++;
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());
    private final ClusterHealthStatus status;
    private int delayedUnassignedShards;
    private final boolean primaryActive;
    public int getRelocatingShards() {
    }
            int i = 0;
        return relocatingShards;
        status = ClusterHealthStatus.fromValue(in.readByte());
        if (!(o instanceof ClusterShardHealth)) return false;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * specific language governing permissions and limitations
     * </ul>
     * <p>
        this.relocatingShards = relocatingShards;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        builder.field(RELOCATING_SHARDS, getRelocatingShards());
    }
     *     Shard health is RED when the primary is not active.
            }
        this.primaryActive = primaryRouting != null && primaryRouting.active();
import java.util.Locale;
     * For XContent Parser and serialization tests
/*
    private static final String RELOCATING_SHARDS = "relocating_shards";
    }
    public ClusterHealthStatus getStatus() {
    public static ClusterHealthStatus getInactivePrimaryHealth(final ShardRouting shardRouting) {
            // REMOTE_STORE is deliberately NOT in this list: a primary hydrating from the remote store cannot
 * the Apache License, Version 2.0 (the "License"); you may
     * <p>
        final IndexShardRoutingTable shardRoutingTable,
        );
     * <p>
                return ClusterHealthStatus.YELLOW;
    public int hashCode() {
                    computeDelayedUnassignedShards++;
     *
        this.relocatingShards = computeRelocatingShards;
        if (primaryRouting.active()) {
        int computeDelayedUnassignedShards = 0;
     */
            String statusStr = (String) parsedObjects[i];
                return (activeShards < totalShards) ? ClusterHealthStatus.YELLOW : ClusterHealthStatus.GREEN;
 * this work for additional information regarding copyright
    /**
        shardId = in.readVInt();
        ClusterHealthStatus status,
            int unassignedShards = (int) parsedObjects[i++];
        final boolean isSearchOnlyClusterBlockEnabled
    private static final String INITIALIZING_SHARDS = "initializing_shards";
        this.status = status;
            shardRoutingTable,
import org.opensearch.cluster.routing.RecoverySource;
            if (activeShards == totalShards) {
                }
        return shardId == that.shardId
     * NB: this method should *not* be called on active shards nor on non-primary shards.
    public int getDelayedUnassignedShards() {
    @Override
import org.opensearch.cluster.metadata.IndexMetadata;
        return activeShards;
        out.writeVInt(initializingShards);
    }
        }
        return unassignedShards;
    ClusterShardHealth(
     *     <li>Shard health is RED when no search replicas are active</li>
                    computeRelocatingShards++;
        return delayedUnassignedShards;
        ClusterShardHealth parsed = innerFromXContent(parser, Integer.valueOf(shardIdStr));
    // Original constructor can call the new one
import org.opensearch.core.xcontent.XContentBuilder;
    /**
     * @param activeShards the number of active shards (primary and replicas)
        out.writeVInt(relocatingShards);
        int shardId,
        PARSER.declareInt(constructorArg(), new ParseField(INITIALIZING_SHARDS));
 */
        activeShards = in.readVInt();
    public int getShardId() {
     * @param isSearchOnlyClusterBlockEnabled whether the index is in search-only mode
        primaryActive = in.readBoolean();
     * unavailable. In case of index creation, snapshot restore or index shrinking, which are unexceptional events in the cluster lifecycle,
    /**
 * SPDX-License-Identifier: Apache-2.0
    }
        builder.startObject(Integer.toString(getShardId()));
    }
        PARSER.declareBoolean(constructorArg(), new ParseField(PRIMARY_ACTIVE));
    }
import org.opensearch.core.xcontent.ToXContentFragment;
        XContentParser.Token token = parser.nextToken();
            // serve queries until recovery completes, so reporting it YELLOW would overstate availability. It
            return getInactivePrimaryHealth(primaryRouting);
        int computeInitializingShards = 0;
public final class ClusterShardHealth implements Writeable, ToXContentFragment {
    public ClusterShardHealth(
 * license agreements. See the NOTICE file distributed with
            && status == that.status;
                return ClusterHealthStatus.GREEN;
 * compatible open source license.
     * <ul>
import org.opensearch.cluster.routing.ShardRouting;
                relocatingShards,
        return Objects.hash(shardId, status, activeShards, relocatingShards, initializingShards, unassignedShards, primaryActive);
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
                computeActiveShards++;
        this.shardId = shardId;
        true,
import java.util.List;
    public static ClusterHealthStatus getShardHealth(
            && initializingShards == that.initializingShards
     * <ul>
    static ClusterShardHealth innerFromXContent(XContentParser parser, Integer shardId) {
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_SHARDS));
            return ClusterHealthStatus.RED;
        final int shardId,
        final int activeShards,
     * Checks if an inactive primary shard should cause the cluster health to go RED.
        int computeRelocatingShards = 0;
                return ClusterHealthStatus.RED;
        builder.field(STATUS, getStatus().name().toLowerCase(Locale.ROOT));
 */
     * cluster health should not turn RED for the time where primaries are still in the initializing state but go to YELLOW instead.
            // stays RED while unassigned/initializing and converges to GREEN without operator action. Revisit
    private final int shardId;
 * software distributed under the License is distributed on an
     */
        RecoverySource.Type recoveryType = shardRouting.recoverySource().getType();
     *     Shard health is YELLOW when primary shard is active but at-least one replica shard is inactive.
    public void writeTo(final StreamOutput out) throws IOException {
    /**
        PARSER.declareString(constructorArg(), new ParseField(STATUS));
            boolean primaryActive = (boolean) parsedObjects[i++];
 *
                if (shardRouting.unassignedInfo() != null && shardRouting.unassignedInfo().isDelayed()) {
            && activeShards == that.activeShards
    private static final String PRIMARY_ACTIVE = "primary_active";
    private final int initializingShards;
            if (shardRouting.active()) {
    }
        ClusterShardHealth that = (ClusterShardHealth) o;
 * under the License.
     *     In search-only mode (when {@link IndexMetadata#INDEX_BLOCKS_SEARCH_ONLY_SETTING} is enabled):
            } else {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        out.writeVInt(shardId);
        out.writeBoolean(primaryActive);
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
import org.opensearch.core.xcontent.XContentParser;
     *     In search-only mode (when {@code isSearchOnlyClusterBlockEnabled} is {@code true}):
        } else {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        assert shardRouting.primary() : "cannot invoke on a replica shard: " + shardRouting;
        return status;
        return PARSER.apply(parser, shardId);
        return shardId;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        if (this == o) return true;
     *     <li>Shard health is GREEN when all expected search replicas are active</li>
        out.writeVInt(unassignedShards);
                shardId,
    }
    ) {
        this.status = getShardHealth(primaryRouting, computeActiveShards, shardRoutingTable.size(), isSearchOnlyClusterBlockEnabled);
                if (shardRouting.relocating()) {
 * Cluster shard health information
     * <p>
     * <p>
        int unassignedShards,
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    }
    }
        if (primaryRouting == null) {
    @Override
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        } else {
        int initializingShards,
    private static final String STATUS = "status";
     */
 * GitHub history for details.
        this.primaryActive = primaryActive;
    }
    public boolean isPrimaryActive() {
        final IndexMetadata indexMetadata
     * @return the health status for the shard
 * ownership. Elasticsearch licenses this file to you under
    ) {
     * Computes the shard health of an index.
    }
    public int getActiveShards() {
     * some point, cluster health should still turn RED.
        relocatingShards = in.readVInt();
            .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
import org.opensearch.core.ParseField;
    ) {
            int activeShards = (int) parsedObjects[i++];
        final ShardRouting primaryRouting = shardRoutingTable.primaryShard();
            && unassignedShards == that.unassignedShards
        PARSER.declareInt(constructorArg(), new ParseField(UNASSIGNED_SHARDS));
            return new ClusterShardHealth(
        final ShardRouting primaryRouting,
            && unassignedInfo.getNumFailedAllocations() == 0
    public ClusterShardHealth(final StreamInput in) throws IOException {
        final UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
        }
        final int totalShards,
        return primaryActive;
    }
        this.unassignedShards = computeUnassignedShards;
            ClusterHealthStatus status = ClusterHealthStatus.fromString(statusStr);
 * not use this file except in compliance with the License.
                primaryActive
            int relocatingShards = (int) parsedObjects[i++];
        return parsed;
        assert shardRouting.active() == false : "cannot invoke on an active shard: " + shardRouting;
            && (recoveryType == RecoverySource.Type.EMPTY_STORE || recoveryType == RecoverySource.Type.LOCAL_SHARDS
 *
     * Computes the shard health of an index.
        String shardIdStr = parser.currentName();
        this.delayedUnassignedShards = computeDelayedUnassignedShards;
     *     <li>Shard health is RED when no search replicas are active</li>
            if (isSearchOnlyClusterBlockEnabled) {
     * <p>
     * </p>
     *     <li>Shard health is GREEN when all expected search replicas are active</li>
        int relocatingShards,
/*
     * An inactive primary shard in an index should cause the cluster health to be RED to make it visible that some of the existing data is
    public int getUnassignedShards() {
    }
                status,
 * Unless required by applicable law or agreed to in writing,
        return Strings.toString(MediaTypeRegistry.JSON, this);
        this.initializingShards = initializingShards;
