            unassignedShards,
        shards = new HashMap<>();
        int numberOfReplicas,
        int computeActiveShards = 0;
    private static final String INITIALIZING_SHARDS = "initializing_shards";
     * For XContent Parser and serialization tests
        return Objects.equals(index, that.index)
                activePrimaryShards,
        shards = new HashMap<>();
                computeActivePrimaryShards++;
        } else {
        this.numberOfReplicas = numberOfReplicas;
        int computeActivePrimaryShards = 0;
        this.relocatingShards = computeRelocatingShards;
        this.index = indexMetadata.getIndex().getName();
    private final int activeShards;
                            computeRelocatingShards++;
        return builder;
            String statusStr = (String) parsedObjects[i++];
        this.status = computeStatus;
        activeShards = in.readVInt();
    private static final ConstructingObjectParser<ClusterIndexHealth, String> PARSER = new ConstructingObjectParser<>(
                List<ShardRouting> shardRoutings = indexShardRoutingTable.shards();
    static {
    }
            + activeShards
        this.relocatingShards = relocatingShards;
                    } else if (shardRouting.initializing()) {
        builder.field(NUMBER_OF_SHARDS, getNumberOfShards());
        return shards.values().iterator();
            + ", shards.size="
                computeDelayedUnassignedShards += shardHealth.getDelayedUnassignedShards();
            + '}';
        // update the index status
                if (primaryShard == null) {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            final Map<Integer, ClusterShardHealth> shards;
        int computeActiveShards = 0;
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            + ", numberOfShards="
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());
    public static ClusterIndexHealth fromXContent(XContentParser parser) throws IOException {
            && numberOfShards == that.numberOfShards
            }
                    computeActivePrimaryShards++;
        builder.field(NUMBER_OF_REPLICAS, getNumberOfReplicas());
        return unassignedShards;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.IndexRoutingTable;
                computeActiveShards += shardHealth.getActiveShards();
            // might be since none has been created yet (two phase index creation)
            int initializingShards = (int) parsedObjects[i++];
        this.numberOfReplicas = indexMetadata.getNumberOfReplicas();
                shards = emptyMap();
            int i = 0;
                        activeShardsPerShardId++;
            + (shards == null ? "null" : shards.size())
    public String toString() {
            );
        }
                shards = new HashMap<>(shardList.size());
            int numberOfReplicas = (int) parsedObjects[i++];
            + '\''
        final IndexRoutingTable indexRoutingTable,
            return new ClusterIndexHealth(
 * SPDX-License-Identifier: Apache-2.0
            activePrimaryShards,
                }
            .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
            List<ClusterShardHealth> shardList = (List<ClusterShardHealth>) parsedObjects[i];
    private int delayedUnassignedShards;
        String index,
        String index = parser.currentName();
                    }
            computeActiveShards += shardHealth.getActiveShards();
            relocatingShards,
        out.writeCollection(shards.values());
        this.unassignedShards = computeUnassignedShards;
            int numberOfShards = (int) parsedObjects[i++];
        return activePrimaryShards;
        ClusterIndexHealth that = (ClusterIndexHealth) o;
    private final int numberOfShards;
            computeStatus = ClusterHealthStatus.RED;
        this.delayedUnassignedShards = computeDelayedUnassignedShards;
    public Map<Integer, ClusterShardHealth> getShards() {
/*
                return computeStatus;
        final ClusterHealthRequest.Level healthLevel
                computeRelocatingShards += shardHealth.getRelocatingShards();
    }
    );
                }
    }
        return relocatingShards;
/*
        builder.field(STATUS, getStatus().name().toLowerCase(Locale.ROOT));
    public int getActivePrimaryShards() {
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_REPLICAS));
                activeShards,
import java.util.HashMap;
        int computeUnassignedShards = 0;
        out.writeVInt(numberOfShards);
        (parsedObjects, index) -> {
            + activePrimaryShards
                } else {
            && numberOfReplicas == that.numberOfReplicas
import static java.util.Collections.emptyMap;
                    } else {
                numberOfReplicas,
    }
            + unassignedShards
            && Objects.equals(shards, that.shards);
        if (indexRoutingTable.shards() != null && indexRoutingTable.shards().isEmpty()) {
            numberOfReplicas,
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_PRIMARY_SHARDS));
                        indexMetadata
public final class ClusterIndexHealth implements Iterable<ClusterShardHealth>, Writeable, ToXContentFragment {
            default:
    ) {
    public ClusterIndexHealth(
    }
            builder.endObject();
        this.activePrimaryShards = activePrimaryShards;
        return initializingShards;
                if (shardHealth.isPrimaryActive()) {
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
        if (shards.isEmpty()) { // might be since none has been created yet (two phase index creation)
            ClusterHealthStatus status = ClusterHealthStatus.fromString(statusStr);
    }
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
    }
            case YELLOW:
        }
        int computeInitializingShards = 0;
    @Override
    }
            if (shardList == null || shardList.isEmpty()) {
                        activeShardsPerShardId,
 * Modifications Copyright OpenSearch Contributors. See
            int activeShards = (int) parsedObjects[i++];
        this.unassignedShards = unassignedShards;
                for (ClusterShardHealth shardHealth : shardList) {
    private final int relocatingShards;
import java.util.Iterator;
        return activeShards;
        final IndexMetadata indexMetadata,
    @Override
        builder.field(RELOCATING_SHARDS, getRelocatingShards());
    public void writeTo(final StreamOutput out) throws IOException {
            shards
        builder.endObject();
        Map<Integer, ClusterShardHealth> shards
                } else {
        }
 */
    }
        out.writeString(index);
 */
                        }
    }
    ) {
        this.shards = shards;
            + initializingShards
        }
 * You may obtain a copy of the License at
            }
                    if (shardRouting.active()) {
        ClusterIndexHealth parsed = innerFromXContent(parser, index);
import org.opensearch.core.xcontent.ConstructingObjectParser;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            + ", status="
    private final ClusterHealthStatus status;
    private static final String ACTIVE_PRIMARY_SHARDS = "active_primary_shards";
        int computeDelayedUnassignedShards = 0;
        status = ClusterHealthStatus.fromValue(in.readByte());
            status,
 * Cluster Index Health Information
                    }
                shardHealth.toXContent(builder, params);
        this.numberOfShards = indexMetadata.getNumberOfShards();
 * ownership. Elasticsearch licenses this file to you under
        int size = in.readVInt();
        this.status = status;
    @Override
        return numberOfReplicas;
    }
    private final Map<Integer, ClusterShardHealth> shards;
        ClusterHealthStatus status,
            index,
        if (isShardLevelHealthRequired) {
        numberOfShards = in.readVInt();
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
                    }
        switch (shardHealth) {
            int relocatingShards = (int) parsedObjects[i++];
            computeInitializingShards += shardHealth.getInitializingShards();
}
    private static final String NUMBER_OF_REPLICAS = "number_of_replicas";
                        if (shardRouting.unassignedInfo().isDelayed()) {
    }
                unassignedShards,
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                        if (shardRouting.relocating()) {
        this.numberOfShards = indexMetadata.getNumberOfShards();
                relocatingShards,
        index = in.readString();
        this.numberOfShards = numberOfShards;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
            int shardId = shardRoutingTable.shardId().id();
                    return ClusterHealthStatus.YELLOW;
    public int getUnassignedShards() {
        out.writeVInt(activeShards);
    private final int unassignedShards;
 *
    public static ClusterHealthStatus getIndexHealthStatus(ClusterHealthStatus shardHealth, ClusterHealthStatus computeStatus) {
import java.util.Map;
        this.activeShards = computeActiveShards;
            + ", unassignedShards="
    public static final ObjectParser.NamedObjectParser<ClusterShardHealth, String> SHARD_PARSER = (
            @SuppressWarnings("unchecked")
    public static ClusterIndexHealth innerFromXContent(XContentParser parser, String index) {
        int unassignedShards,
        int computeInitializingShards = 0;
        int computeRelocatingShards = 0;
import org.opensearch.core.xcontent.XContentParser;
        return "ClusterIndexHealth{"
            initializingShards,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                        computeActiveShards++;
                    return ClusterHealthStatus.RED;
            computeStatus = ClusterHealthStatus.RED;
                computeStatus = getIndexHealthStatus(shardHealth.getStatus(), computeStatus);
            case RED:
            numberOfShards,
        return Objects.hash(
                        }
            + "index='"
    public int getInitializingShards() {
        for (int i = 0; i < size; i++) {
                initializingShards,
    public int hashCode() {
/**
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_SHARDS));
            int unassignedShards = (int) parsedObjects[i++];
        PARSER.declareString(constructorArg(), new ParseField(STATUS));
            }
            + numberOfReplicas
        PARSER.declareInt(constructorArg(), new ParseField(RELOCATING_SHARDS));
    public int getActiveShards() {
            && relocatingShards == that.relocatingShards
        PARSER.declareNamedObjects(optionalConstructorArg(), SHARD_PARSER, new ParseField(SHARDS));
        XContentParser.Token token = parser.nextToken();
import org.opensearch.core.ParseField;
                int shardRoutingCountPerShardId = shardRoutings.size();
                shards
        // update the index status
        this.initializingShards = computeInitializingShards;
/*
                index,
        int relocatingShards,
package org.opensearch.cluster.health;
    @Override
    }
import org.opensearch.core.common.io.stream.StreamOutput;
                int activeShardsPerShardId = 0;
                        computeStatus = getIndexHealthStatus(ClusterHealthStatus.GREEN, computeStatus);
                        computeUnassignedShards++;
    }
        this.index = indexMetadata.getIndex().getName();
                computeUnassignedShards += shardHealth.getUnassignedShards();
            computeStatus = getIndexHealthStatus(shardHealth.getStatus(), computeStatus);
    }
 *
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
        return index;
@PublicApi(since = "1.0.0")
        this.activeShards = activeShards;
import org.opensearch.core.xcontent.XContentBuilder;
        return this.shards;
    @Override
    public int getNumberOfShards() {
        for (ClusterShardHealth shardHealth : shards.values()) {
        builder.field(INITIALIZING_SHARDS, getInitializingShards());
            computeRelocatingShards += shardHealth.getRelocatingShards();
            + numberOfShards
        this.activePrimaryShards = computeActivePrimaryShards;
                for (int index = 0; index < shardRoutingCountPerShardId; index++) {
    private final int numberOfReplicas;
        this.status = computeStatus;
 * Unless required by applicable law or agreed to in writing,
    }
        this.delayedUnassignedShards = computeDelayedUnassignedShards;
            && activeShards == that.activeShards
        int computeRelocatingShards = 0;
 * under the License.
            }
        this.activePrimaryShards = computeActivePrimaryShards;
    public ClusterIndexHealth(final IndexMetadata indexMetadata, final IndexRoutingTable indexRoutingTable) {
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.ObjectParser;
                }
    public ClusterHealthStatus getStatus() {
                    computeStatus = getIndexHealthStatus(shardHealth, computeStatus);
            computeDelayedUnassignedShards += shardHealth.getDelayedUnassignedShards();
import java.io.IOException;
        shards = new HashMap<>(size);
        this.relocatingShards = computeRelocatingShards;
    private final int activePrimaryShards;
    @Override
            ClusterShardHealth shardHealth = new ClusterShardHealth(in);
    }
        }
 * The OpenSearch Contributors require contributions made to
            }
        return status;
    public String getIndex() {
        if (this == o) return true;
        int activePrimaryShards,
        out.writeVInt(relocatingShards);
 * @opensearch.api
                }
        int initializingShards,
 * license agreements. See the NOTICE file distributed with
            shards.put(shardId, new ClusterShardHealth(shardId, shardRoutingTable, indexMetadata));
        int computeUnassignedShards = 0;
    private final String index;
    private static final String NUMBER_OF_SHARDS = "number_of_shards";
        this.initializingShards = initializingShards;
            int activePrimaryShards = (int) parsedObjects[i++];
 *
 * GitHub history for details.
    public ClusterIndexHealth(final StreamInput in) throws IOException {
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;
        this.activeShards = computeActiveShards;
        return delayedUnassignedShards;
    public int getNumberOfReplicas() {
import org.opensearch.cluster.metadata.IndexMetadata;
            && status == that.status
                    if (isSearchOnlyClusterBlockEnabled) {
     */
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_SHARDS));
    /**
            + ", activePrimaryShards="
    private final int initializingShards;
                ClusterShardHealth shardHealth = new ClusterShardHealth(shardId, indexShardRoutingTable, indexMetadata);
    }
        out.writeVInt(numberOfReplicas);
                        computeActivePrimaryShards++;
        String indexIgnored,
    }
import org.opensearch.core.common.io.stream.Writeable;
            if (shardHealth.isPrimaryActive()) {
        PARSER.declareInt(constructorArg(), new ParseField(UNASSIGNED_SHARDS));
        boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()
        if (o == null || getClass() != o.getClass()) return false;
                if (computeStatus != ClusterHealthStatus.RED) {
                numberOfShards,
import java.util.Objects;
 * KIND, either express or implied.  See the License for the
            && unassignedShards == that.unassignedShards
        int computeDelayedUnassignedShards = 0;
            && initializingShards == that.initializingShards
                        shardRoutingCountPerShardId,
            + ", activeShards="
                    if (primaryShard.active()) {
    private static final String ACTIVE_SHARDS = "active_shards";
                    );
        activePrimaryShards = in.readVInt();
        return PARSER.apply(parser, index);
        String shardId) -> ClusterShardHealth.innerFromXContent(p, Integer.valueOf(shardId));
import org.opensearch.core.xcontent.ToXContentFragment;
    public boolean equals(Object o) {
        numberOfReplicas = in.readVInt();
    }
        XContentParser p,
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
import java.util.List;
                            computeDelayedUnassignedShards++;
            activeShards,
        }
        builder.startObject(getIndex());
 *
 * specific language governing permissions and limitations
                ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
    ClusterIndexHealth(
                computeInitializingShards += shardHealth.getInitializingShards();
        this.numberOfReplicas = indexMetadata.getNumberOfReplicas();
                        primaryShard,
                }
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeVInt(activePrimaryShards);
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";
 */
        }
        unassignedShards = in.readVInt();
 * this file be licensed under the Apache-2.0 license or a
        this.initializingShards = computeInitializingShards;
        out.writeVInt(initializingShards);
        int activeShards,
            + index
    private static final String RELOCATING_SHARDS = "relocating_shards";
 * Licensed to Elasticsearch under one or more contributor
                        computeInitializingShards++;
                        computeStatus = getIndexHealthStatus(ClusterHealthStatus.RED, computeStatus);
    }
        this.index = index;
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        PARSER.declareInt(constructorArg(), new ParseField(INITIALIZING_SHARDS));
        builder.field(ACTIVE_SHARDS, getActiveShards());
                // do not override an existing red
 * compatible open source license.
        "cluster_index_health",
            shards.put(shardHealth.getShardId(), shardHealth);
    public int getRelocatingShards() {
 * the Apache License, Version 2.0 (the "License"); you may
                    ClusterHealthStatus shardHealth = ClusterShardHealth.getShardHealth(
import java.util.Locale;
    }
        }
    public Iterator<ClusterShardHealth> iterator() {
            + relocatingShards
                    ShardRouting shardRouting = shardRoutings.get(index);
    private static final String SHARDS = "shards";
 */
    }
        out.writeByte(status.value());
import org.opensearch.common.annotation.PublicApi;
            } else {
            builder.startObject(SHARDS);
        builder.field(ACTIVE_PRIMARY_SHARDS, getActivePrimaryShards());
                status,
        initializingShards = in.readVInt();
        if ("shards".equals(params.param("level", "indices"))) {
    }
        out.writeVInt(unassignedShards);
        int computeActivePrimaryShards = 0;
                int shardId = indexShardRoutingTable.shardId().id();
    public int getDelayedUnassignedShards() {
        int numberOfShards,
            + status
    }
            + ", relocatingShards="
        // Can be absent if LEVEL == 'indices' or 'cluster'
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;
                shards.put(shardId, shardHealth);
        }
                return ClusterHealthStatus.RED;
        boolean isShardLevelHealthRequired = healthLevel == ClusterHealthRequest.Level.SHARDS;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + ", numberOfReplicas="
            computeUnassignedShards += shardHealth.getUnassignedShards();
    private static final String STATUS = "status";
        return numberOfShards;
                    } else if (shardRouting.unassigned()) {
        relocatingShards = in.readVInt();
 * not use this file except in compliance with the License.
            + ", initializingShards="
        this.unassignedShards = computeUnassignedShards;
                    shards.put(shardHealth.getShardId(), shardHealth);
        );
            && activePrimaryShards == that.activePrimaryShards
        return parsed;
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        true,
            for (ClusterShardHealth shardHealth : shards.values()) {
