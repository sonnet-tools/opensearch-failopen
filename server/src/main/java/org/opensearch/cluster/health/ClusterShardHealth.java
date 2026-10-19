        }
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";
    }
/**  
        assert shardRouting.unassignedInfo() != null : "cannot invoke on a shard with no UnassignedInfo: " + shardRouting;
        builder.field(PRIMARY_ACTIVE, isPrimaryActive());
        final int totalShards,
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;  
     *     Shard health is RED when the primary is not active.
        this.relocatingShards = computeRelocatingShards;  
            int activeShards = (int) parsedObjects[i++];
    static ClusterShardHealth innerFromXContent(XContentParser parser, Integer shardId) {
     */  
            && activeShards == that.activeShards  
import org.opensearch.cluster.routing.UnassignedInfo;
        return activeShards;  
    private static final String RELOCATING_SHARDS = "relocating_shards";  
        return relocatingShards;
        true,
     * NB: this method should *not* be called on active shards nor on non-primary shards.
            if (shardRouting.active()) {
                primaryActive  
    private final int relocatingShards;
        int relocatingShards,  
        ClusterHealthStatus status,
     * </p>  
    public ClusterHealthStatus getStatus() {  
    }
 * not use this file except in compliance with the License.
        PARSER.declareInt(constructorArg(), new ParseField(INITIALIZING_SHARDS));  
    }
     */  
    private static final String ACTIVE_SHARDS = "active_shards";
     *     In search-only mode (when {@link IndexMetadata#INDEX_BLOCKS_SEARCH_ONLY_SETTING} is enabled):
        this.status = status;  
            && initializingShards == that.initializingShards
 * You may obtain a copy of the License at  
    public boolean isPrimaryActive() {  
    private final int initializingShards;  
    public static ClusterHealthStatus getShardHealth(
 */
        return PARSER.apply(parser, shardId);  
        assert shardRouting.primary() : "cannot invoke on a replica shard: " + shardRouting;
     * <ul>
            return ClusterHealthStatus.RED;  
            }
        out.writeVInt(unassignedShards);
     *     Shard health is YELLOW when primary shard is active but at-least one replica shard is inactive.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                return ClusterHealthStatus.RED;  
                shardId,  
import org.opensearch.core.xcontent.ToXContentFragment;  
     *     <li>Shard health is YELLOW when some (but not all) search replicas are active</li>  
        return shardId;  
    }  
    @Override
 * software distributed under the License is distributed on an
            int initializingShards = (int) parsedObjects[i++];
     * Checks if an inactive primary shard should cause the cluster health to go RED.  
        return shardId == that.shardId
        this.delayedUnassignedShards = computeDelayedUnassignedShards;  
                unassignedShards,
        RecoverySource.Type recoveryType = shardRouting.recoverySource().getType();
        return delayedUnassignedShards;
        status = ClusterHealthStatus.fromValue(in.readByte());  
    ) {
 */  
 * KIND, either express or implied.  See the License for the
 * @opensearch.api  
    }  
 * this work for additional information regarding copyright
        return Strings.toString(MediaTypeRegistry.JSON, this);  
        ClusterShardHealth parsed = innerFromXContent(parser, Integer.valueOf(shardIdStr));
                    computeRelocatingShards++;
        return primaryActive;
 * Licensed to Elasticsearch under one or more contributor  
        this.unassignedShards = computeUnassignedShards;
/*
import org.opensearch.core.common.io.stream.Writeable;  
        int computeDelayedUnassignedShards = 0;  
        final boolean isSearchOnlyClusterBlockEnabled
    public int getInitializingShards() {
     * <p>
            ClusterHealthStatus status = ClusterHealthStatus.fromString(statusStr);
        if (primaryRouting.active()) {
    }
     *     Shard health is YELLOW when primary shard is active but at-least one replica shard is inactive.
        this.status = getShardHealth(primaryRouting, computeActiveShards, shardRoutingTable.size(), isSearchOnlyClusterBlockEnabled);
        }  
        primaryActive = in.readBoolean();
        builder.field(ACTIVE_SHARDS, getActiveShards());  
        (parsedObjects, shardId) -> {
        int initializingShards,
     * <ul>
        } else {
        XContentParser.Token token = parser.nextToken();
            int i = 0;  
import org.opensearch.core.ParseField;
        final ShardRouting primaryRouting,
        int shardId,  
     *     <li>Shard health is YELLOW when some (but not all) search replicas are active</li>  
        builder.startObject(Integer.toString(getShardId()));  
    }
     * <p>
            return ClusterHealthStatus.YELLOW;
        return builder;
        this.shardId = shardId;
        int activeShards,
    @Override
        this.primaryActive = primaryRouting != null && primaryRouting.active();
        this.unassignedShards = unassignedShards;
     * cluster health should not turn RED for the time where primaries are still in the initializing state but go to YELLOW instead.
import org.opensearch.core.xcontent.ConstructingObjectParser;
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
    public int getUnassignedShards() {
        relocatingShards = in.readVInt();
        return unassignedShards;  
            shardRoutingTable,
            } else {
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);  
     *     <li>Shard health is GREEN when all expected search replicas are active</li>
        this.relocatingShards = relocatingShards;
        PARSER.declareBoolean(constructorArg(), new ParseField(PRIMARY_ACTIVE));  
                return ClusterHealthStatus.YELLOW;
            // when warm/searchable-remote shards can serve queries directly off the remote store mid-hydration.
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);  
     * @param isSearchOnlyClusterBlockEnabled whether the index is in search-only mode
        final int totalShards,
    private static final String PRIMARY_ACTIVE = "primary_active";  
     * <p>
    public boolean equals(Object o) {
     * </p>  
     * <p>
/*  
    }
        final int shardId,  
public final class ClusterShardHealth implements Writeable, ToXContentFragment {  
    /**
    @Override
            .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);  
     *     Shard health is RED when the primary is not active.
    }
        if (this == o) return true;
     */
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
            }
    private final int activeShards;
                relocatingShards,  
 * GitHub history for details.
    public int getShardId() {
package org.opensearch.cluster.health;
    public int hashCode() {  
     * </ul>
     * Computes the shard health of an index.
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
     * unavailable. In case of index creation, snapshot restore or index shrinking, which are unexceptional events in the cluster lifecycle,  
    @Override
 */  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public int getActiveShards() {
    }  
            // serve queries until recovery completes, so reporting it YELLOW would overstate availability. It  
     *     In search-only mode (when {@code isSearchOnlyClusterBlockEnabled} is {@code true}):
    public int getRelocatingShards() {
        if (unassignedInfo.getLastAllocationStatus() != AllocationStatus.DECIDERS_NO
    static {
            );
import java.util.List;
            } else if (shardRouting.unassigned()) {
        out.writeVInt(initializingShards);
import java.io.IOException;
    private static final String INITIALIZING_SHARDS = "initializing_shards";
            && (recoveryType == RecoverySource.Type.EMPTY_STORE || recoveryType == RecoverySource.Type.LOCAL_SHARDS
        shardId = in.readVInt();
    ) {  
 *
     * @param activeShards the number of active shards (primary and replicas)
    }
        PARSER.declareInt(constructorArg(), new ParseField(UNASSIGNED_SHARDS));
     *     <li>Shard health is RED when no search replicas are active</li>
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        out.writeBoolean(primaryActive);  
     * However, in case of exceptional events, for example when the primary shard cannot be assigned to a node or initialization fails at
    }
     * @param primaryRouting the routing entry for the primary shard, may be null
    }
        );
    /**  
            && unassignedShards == that.unassignedShards  
            if (isSearchOnlyClusterBlockEnabled) {  
        builder.field(INITIALIZING_SHARDS, getInitializingShards());
                activeShards,
 * Unless required by applicable law or agreed to in writing,
        out.writeVInt(shardId);  
        int computeActiveShards = 0;
    public static ClusterHealthStatus getInactivePrimaryHealth(final ShardRouting shardRouting) {
            && primaryActive == that.primaryActive
import org.opensearch.core.common.io.stream.StreamInput;
            boolean primaryActive = (boolean) parsedObjects[i++];
            return getInactivePrimaryHealth(primaryRouting);
    }  
    ) {  
                computeActiveShards++;
        out.writeVInt(relocatingShards);  
    @Override  
import org.opensearch.core.common.Strings;  
     * Computes the shard health of an index.
 * license agreements. See the NOTICE file distributed with
            if (activeShards == totalShards) {
    ) {  
    }
                return ClusterHealthStatus.GREEN;  
     *     Shard health is GREEN when all primary and replica shards of the indices are active.  
     *  
        }
     * For XContent Parser and serialization tests  
        if (!(o instanceof ClusterShardHealth)) return false;  
     *     <li>Shard health is RED when no search replicas are active</li>
 * ownership. Elasticsearch licenses this file to you under  
    ClusterShardHealth(
        return status;
        final ShardRouting primaryRouting = shardRoutingTable.primaryShard();  
    private final int shardId;
        this.initializingShards = initializingShards;  
        return initializingShards;
            } else {
    private int delayedUnassignedShards;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Locale;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
@PublicApi(since = "1.0.0")
                computeInitializingShards++;
        activeShards = in.readVInt();
    private static final String STATUS = "status";
    public void writeTo(final StreamOutput out) throws IOException {
        return parsed;
        final UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();  
            int unassignedShards = (int) parsedObjects[i++];
        PARSER.declareString(constructorArg(), new ParseField(STATUS));
        return Objects.hash(shardId, status, activeShards, relocatingShards, initializingShards, unassignedShards, primaryActive);
 * compatible open source license.
    public static ClusterShardHealth fromXContent(XContentParser parser) throws IOException {  
        builder.field(STATUS, getStatus().name().toLowerCase(Locale.ROOT));
     * An inactive primary shard in an index should cause the cluster health to be RED to make it visible that some of the existing data is
        final IndexShardRoutingTable shardRoutingTable,
        }
     *     <li>Shard health is GREEN when all expected search replicas are active</li>
     * <p>
        boolean primaryActive  
            int relocatingShards = (int) parsedObjects[i++];  
        final int activeShards,  
    }
            shardId,
    public static ClusterHealthStatus getShardHealth(
        ClusterShardHealth that = (ClusterShardHealth) o;
        assert shardRouting.recoverySource() != null : "cannot invoke on a shard that has no recovery source" + shardRouting;
    }
                }  
     * @param totalShards the total number of shards (primary and replicas)  
            String statusStr = (String) parsedObjects[i];  
        PARSER.declareInt(constructorArg(), new ParseField(RELOCATING_SHARDS));
}  
        int computeRelocatingShards = 0;  
        out.writeByte(status.value());
                || recoveryType == RecoverySource.Type.SNAPSHOT)) {  
    /**  
     * </p>  
    public int getDelayedUnassignedShards() {  
                }
                return (activeShards < totalShards) ? ClusterHealthStatus.YELLOW : ClusterHealthStatus.GREEN;
    private final ClusterHealthStatus status;  
        int computeInitializingShards = 0;
            }  
/*  
import org.opensearch.cluster.routing.RecoverySource;  
        for (int index = 0; index < shardRoutings.size(); index++) {
            return new ClusterShardHealth(
                if (shardRouting.relocating()) {  
        final int activeShards,  
                initializingShards,
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
                computeUnassignedShards++;  
    public String toString() {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import java.util.Objects;
 *
        this.primaryActive = primaryActive;
    }
        int unassignedShards,
     * </p>  
import org.opensearch.core.common.io.stream.StreamOutput;
        this(  
        assert shardRouting.active() == false : "cannot invoke on an active shard: " + shardRouting;  
 * specific language governing permissions and limitations
                status,
                if (shardRouting.unassignedInfo() != null && shardRouting.unassignedInfo().isDelayed()) {
 * under the License.  
        this.activeShards = computeActiveShards;
     * @return the health status for the shard
            && status == that.status;
                    computeDelayedUnassignedShards++;
    private final boolean primaryActive;  
     * </ul>
     * some point, cluster health should still turn RED.  
 * Cluster shard health information
        final ShardRouting primaryRouting,
        final IndexMetadata indexMetadata
 * this file be licensed under the Apache-2.0 license or a
        this.shardId = shardId;
            indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)  
    public ClusterShardHealth(final int shardId, final IndexShardRoutingTable shardRoutingTable, final IndexMetadata indexMetadata) {
        builder.field(RELOCATING_SHARDS, getRelocatingShards());
 * Modifications Copyright OpenSearch Contributors. See
     *     Shard health is GREEN when all primary and replica shards of the indices are active.  
        String shardIdStr = parser.currentName();
            // stays RED while unassigned/initializing and converges to GREEN without operator action. Revisit
        } else {
        List<ShardRouting> shardRoutings = shardRoutingTable.shards();
        final boolean isSearchOnlyClusterBlockEnabled
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_SHARDS));
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());  
        return getShardHealth(primaryRouting, activeShards, totalShards, isSearchOnlyClusterBlockEnabled);
    public ClusterShardHealth(final StreamInput in) throws IOException {
    }  
        int computeUnassignedShards = 0;
            ShardRouting shardRouting = shardRoutings.get(index);  
        builder.endObject();
        this.activeShards = activeShards;
    // Original constructor can call the new one
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.ShardRouting;
            && unassignedInfo.getNumFailedAllocations() == 0  
    public ClusterShardHealth(
        if (primaryRouting == null) {
        }
 */
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;
        this.initializingShards = computeInitializingShards;
            // REMOTE_STORE is deliberately NOT in this list: a primary hydrating from the remote store cannot
            && relocatingShards == that.relocatingShards
    );  
    }  
    /**
        initializingShards = in.readVInt();  
        out.writeVInt(activeShards);
        "cluster_shard_health",  
import org.opensearch.common.annotation.PublicApi;
    private final int unassignedShards;
     * <p>
    public static final ConstructingObjectParser<ClusterShardHealth, Integer> PARSER = new ConstructingObjectParser<>(
        unassignedShards = in.readVInt();
    }
 *
import org.opensearch.core.xcontent.XContentBuilder;
            } else if (shardRouting.initializing()) {  
 *  
        boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()
