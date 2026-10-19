        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_PRIMARY_SHARDS));  
        this.shards = shards;
                }
        ClusterIndexHealth parsed = innerFromXContent(parser, index);  
    ) {  
        switch (shardHealth) {  
import java.util.Objects;
        }  
                if (shardHealth.isPrimaryActive()) {
            List<ClusterShardHealth> shardList = (List<ClusterShardHealth>) parsedObjects[i];
        out.writeVInt(initializingShards);
            int initializingShards = (int) parsedObjects[i++];
            initializingShards,  
        this.activeShards = computeActiveShards;
            relocatingShards,
            } else {  
    }
            + initializingShards
    @Override
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;
    static {
                    if (primaryShard.active()) {  
    private final int relocatingShards;
                int activeShardsPerShardId = 0;  
    }
                // do not override an existing red
        }  
import java.io.IOException;
    }  
    }  
    private final int unassignedShards;  
    public int getActivePrimaryShards() {  
        return Objects.equals(index, that.index)
        shards = new HashMap<>();
        index = in.readString();
        if (shards.isEmpty()) { // might be since none has been created yet (two phase index creation)
        builder.field(STATUS, getStatus().name().toLowerCase(Locale.ROOT));
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
            );
            computeStatus = ClusterHealthStatus.RED;
        int computeRelocatingShards = 0;  
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());
            + '}';
            && unassignedShards == that.unassignedShards
    public int getActiveShards() {
                        }
            computeUnassignedShards += shardHealth.getUnassignedShards();
    @Override
            default:
                numberOfReplicas,  
    private static final String NUMBER_OF_REPLICAS = "number_of_replicas";  
        return activeShards;
import java.util.Iterator;
import org.opensearch.common.annotation.PublicApi;  
        int computeInitializingShards = 0;
    public int hashCode() {
        relocatingShards = in.readVInt();  
        this.status = computeStatus;
        this.numberOfReplicas = numberOfReplicas;  
        this.status = status;  
                    return ClusterHealthStatus.YELLOW;  
                            computeRelocatingShards++;
    }
        this.delayedUnassignedShards = computeDelayedUnassignedShards;
        this.activeShards = activeShards;
                computeRelocatingShards += shardHealth.getRelocatingShards();  
                index,
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {  
}
        this.relocatingShards = computeRelocatingShards;
        out.writeVInt(relocatingShards);  
    private final int initializingShards;
    public boolean equals(Object o) {  
    ) {  
                        computeActivePrimaryShards++;
    private static final String SHARDS = "shards";  
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashMap;  
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;  
    public static ClusterHealthStatus getIndexHealthStatus(ClusterHealthStatus shardHealth, ClusterHealthStatus computeStatus) {
    public ClusterIndexHealth(final IndexMetadata indexMetadata, final IndexRoutingTable indexRoutingTable) {  
import org.opensearch.cluster.routing.ShardRouting;
    @Override
        Map<Integer, ClusterShardHealth> shards
    }
        numberOfShards = in.readVInt();
            index,
    private final int numberOfReplicas;
        }  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            computeStatus = ClusterHealthStatus.RED;
        String shardId) -> ClusterShardHealth.innerFromXContent(p, Integer.valueOf(shardId));  
            builder.startObject(SHARDS);
        this.initializingShards = initializingShards;  
                    ShardRouting shardRouting = shardRoutings.get(index);
                ClusterShardHealth shardHealth = new ClusterShardHealth(shardId, indexShardRoutingTable, indexMetadata);
 * Modifications Copyright OpenSearch Contributors. See
                        activeShardsPerShardId++;
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
import org.opensearch.core.common.io.stream.StreamOutput;  
            case RED:
        if ("shards".equals(params.param("level", "indices"))) {
public final class ClusterIndexHealth implements Iterable<ClusterShardHealth>, Writeable, ToXContentFragment {  
        int initializingShards,
        this.numberOfReplicas = indexMetadata.getNumberOfReplicas();  
        this.activePrimaryShards = computeActivePrimaryShards;
import org.opensearch.core.ParseField;
            int relocatingShards = (int) parsedObjects[i++];
    private int delayedUnassignedShards;
        this.index = index;
    private static final String RELOCATING_SHARDS = "relocating_shards";  
    }  
                } else {
        }
 * license agreements. See the NOTICE file distributed with
        activePrimaryShards = in.readVInt();
                    ClusterHealthStatus shardHealth = ClusterShardHealth.getShardHealth(  
    }
            int numberOfShards = (int) parsedObjects[i++];
        this.index = indexMetadata.getIndex().getName();
    }
        shards = new HashMap<>();
 *
    public String getIndex() {
                computeActivePrimaryShards++;  
                return ClusterHealthStatus.RED;
    @Override
    public ClusterHealthStatus getStatus() {
        PARSER.declareString(constructorArg(), new ParseField(STATUS));
            && activeShards == that.activeShards
                        primaryShard,
        for (int i = 0; i < size; i++) {
            + ", activeShards="  
            && relocatingShards == that.relocatingShards
        this.relocatingShards = relocatingShards;
        }  
        } else {
    }
 *  
        this.relocatingShards = computeRelocatingShards;
        this.numberOfShards = numberOfShards;
        int computeActivePrimaryShards = 0;
            && activePrimaryShards == that.activePrimaryShards
                            computeDelayedUnassignedShards++;
    private final String index;  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        this.delayedUnassignedShards = computeDelayedUnassignedShards;
import org.opensearch.core.xcontent.XContentParser;  
            }
        int activeShards,
        this.status = computeStatus;
                    return ClusterHealthStatus.RED;
        builder.field(NUMBER_OF_SHARDS, getNumberOfShards());
import org.opensearch.cluster.routing.IndexRoutingTable;  
        int computeActiveShards = 0;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        ClusterHealthStatus status,
                computeStatus = getIndexHealthStatus(shardHealth.getStatus(), computeStatus);
        String indexIgnored,
    public static ClusterIndexHealth innerFromXContent(XContentParser parser, String index) {  
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_REPLICAS));
        builder.startObject(getIndex());  
        int computeUnassignedShards = 0;
        return Objects.hash(  
                        if (shardRouting.relocating()) {  
                computeDelayedUnassignedShards += shardHealth.getDelayedUnassignedShards();  
                        activeShardsPerShardId,
    private static final String ACTIVE_PRIMARY_SHARDS = "active_primary_shards";
                for (ClusterShardHealth shardHealth : shardList) {
            if (shardList == null || shardList.isEmpty()) {
            activeShards,
        PARSER.declareInt(constructorArg(), new ParseField(INITIALIZING_SHARDS));
        // update the index status
        activeShards = in.readVInt();
 * not use this file except in compliance with the License.
    private final Map<Integer, ClusterShardHealth> shards;
 * software distributed under the License is distributed on an
        String index,
                        if (shardRouting.unassignedInfo().isDelayed()) {
 * Licensed to Elasticsearch under one or more contributor  
                computeActiveShards += shardHealth.getActiveShards();
            + "index='"
 * SPDX-License-Identifier: Apache-2.0
            case YELLOW:  
            + status
                        computeStatus = getIndexHealthStatus(ClusterHealthStatus.RED, computeStatus);  
    }  
        int relocatingShards,  
                ShardRouting primaryShard = indexShardRoutingTable.primaryShard();  
            numberOfShards,
            final Map<Integer, ClusterShardHealth> shards;  
                } else {
        }  
 */
        this.index = indexMetadata.getIndex().getName();
            + ", numberOfShards="
                shards.put(shardId, shardHealth);
    public String toString() {  
                    }
        return numberOfReplicas;
        int computeActiveShards = 0;
                    shards.put(shardHealth.getShardId(), shardHealth);  
                for (int index = 0; index < shardRoutingCountPerShardId; index++) {
    }
        String index = parser.currentName();
        int activePrimaryShards,  
    public int getInitializingShards() {
    @Override
        return PARSER.apply(parser, index);
        return activePrimaryShards;
/*  
            }
import org.opensearch.core.xcontent.ObjectParser;  
    public static final ObjectParser.NamedObjectParser<ClusterShardHealth, String> SHARD_PARSER = (  
                unassignedShards,
        PARSER.declareInt(constructorArg(), new ParseField(UNASSIGNED_SHARDS));
        int numberOfShards,  
    private static final String STATUS = "status";
    public void writeTo(final StreamOutput out) throws IOException {  
            + index  
    public ClusterIndexHealth(
            + activeShards
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            for (ClusterShardHealth shardHealth : shards.values()) {  
                shards
        unassignedShards = in.readVInt();
        out.writeString(index);
        builder.field(INITIALIZING_SHARDS, getInitializingShards());
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";
    public int getUnassignedShards() {
    }  
                    if (shardRouting.active()) {  
            && numberOfShards == that.numberOfShards
                        shardRoutingCountPerShardId,  
        return relocatingShards;  
 * @opensearch.api  
        for (ClusterShardHealth shardHealth : shards.values()) {
    public ClusterIndexHealth(final StreamInput in) throws IOException {  
    }  
import java.util.Map;
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
     * For XContent Parser and serialization tests
        return index;
        this.initializingShards = computeInitializingShards;
            + ", status="
        final IndexRoutingTable indexRoutingTable,
        int size = in.readVInt();
 * this work for additional information regarding copyright
            }
            @SuppressWarnings("unchecked")
            && status == that.status  
@PublicApi(since = "1.0.0")
 *
                initializingShards,  
 */
        this.numberOfReplicas = indexMetadata.getNumberOfReplicas();  
            + relocatingShards  
                if (computeStatus != ClusterHealthStatus.RED) {
            && Objects.equals(shards, that.shards);
        int computeInitializingShards = 0;  
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_SHARDS));
            + ", unassignedShards="  
        int computeUnassignedShards = 0;
import java.util.List;
            ClusterShardHealth shardHealth = new ClusterShardHealth(in);
                        indexMetadata
        out.writeByte(status.value());  
    @Override  
            activePrimaryShards,
                int shardId = indexShardRoutingTable.shardId().id();  
                shardHealth.toXContent(builder, params);
            builder.endObject();  
            computeStatus = getIndexHealthStatus(shardHealth.getStatus(), computeStatus);
                }
        out.writeVInt(activeShards);
        this.numberOfShards = indexMetadata.getNumberOfShards();
            int activeShards = (int) parsedObjects[i++];  
            .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
import org.opensearch.core.common.io.stream.StreamInput;
        if (o == null || getClass() != o.getClass()) return false;
            int shardId = shardRoutingTable.shardId().id();
        builder.field(RELOCATING_SHARDS, getRelocatingShards());  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public int getDelayedUnassignedShards() {  
     */  
                relocatingShards,
 * Unless required by applicable law or agreed to in writing,
import java.util.Locale;  
                    } else if (shardRouting.unassigned()) {
                        computeUnassignedShards++;  
    private final int activeShards;  
        out.writeVInt(numberOfShards);
import org.opensearch.core.xcontent.ToXContentFragment;
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_SHARDS));  
        out.writeCollection(shards.values());
    private static final String ACTIVE_SHARDS = "active_shards";
 */  
    private static final String INITIALIZING_SHARDS = "initializing_shards";
        this.unassignedShards = unassignedShards;
    }  
 *
            + '\''
                    }
            computeActiveShards += shardHealth.getActiveShards();
                        computeActiveShards++;
            int i = 0;  
        final IndexMetadata indexMetadata,  
 * KIND, either express or implied.  See the License for the
    public int getNumberOfShards() {
                computeUnassignedShards += shardHealth.getUnassignedShards();
        out.writeVInt(activePrimaryShards);
        return shards.values().iterator();
    );
    private final ClusterHealthStatus status;  
                    );
                shards = new HashMap<>(shardList.size());
                numberOfShards,
        builder.field(ACTIVE_SHARDS, getActiveShards());
        true,
        if (indexRoutingTable.shards() != null && indexRoutingTable.shards().isEmpty()) {
            if (shardHealth.isPrimaryActive()) {
            + (shards == null ? "null" : shards.size())
                        computeInitializingShards++;
 * compatible open source license.
            int activePrimaryShards = (int) parsedObjects[i++];
package org.opensearch.cluster.health;
import static java.util.Collections.emptyMap;
            int numberOfReplicas = (int) parsedObjects[i++];
    private static final String NUMBER_OF_SHARDS = "number_of_shards";
                }
    }
 * ownership. Elasticsearch licenses this file to you under  
 */  
        // update the index status
        int computeDelayedUnassignedShards = 0;
            shards.put(shardHealth.getShardId(), shardHealth);  
        return initializingShards;
        builder.field(NUMBER_OF_REPLICAS, getNumberOfReplicas());  
import org.opensearch.cluster.metadata.IndexMetadata;
            status,  
                        }  
        final ClusterHealthRequest.Level healthLevel
        out.writeVInt(unassignedShards);
            String statusStr = (String) parsedObjects[i++];
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
        builder.endObject();
            }
        if (isShardLevelHealthRequired) {
            unassignedShards,
    }
        );
            + numberOfShards  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
 * You may obtain a copy of the License at  
        int unassignedShards,
    }
        return "ClusterIndexHealth{"
        out.writeVInt(numberOfReplicas);  
            + ", shards.size="  
        int computeActivePrimaryShards = 0;  
        this.initializingShards = computeInitializingShards;  
    private final int activePrimaryShards;
    }  
    public int getNumberOfReplicas() {  
 * under the License.  
        int numberOfReplicas,
                status,  
        // Can be absent if LEVEL == 'indices' or 'cluster'
            + activePrimaryShards  
        return this.shards;  
            && initializingShards == that.initializingShards  
                activeShards,
 * Cluster Index Health Information
                    } else {
            shards
    }  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            }  
    /**
                }  
        int computeDelayedUnassignedShards = 0;  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
        PARSER.declareNamedObjects(optionalConstructorArg(), SHARD_PARSER, new ParseField(SHARDS));  
        return delayedUnassignedShards;
            + unassignedShards
                    computeActivePrimaryShards++;  
        }
        this.activePrimaryShards = activePrimaryShards;
            computeInitializingShards += shardHealth.getInitializingShards();
                        computeStatus = getIndexHealthStatus(ClusterHealthStatus.GREEN, computeStatus);
            + ", initializingShards="
                    } else if (shardRouting.initializing()) {  
            computeRelocatingShards += shardHealth.getRelocatingShards();  
                }
    }
        return numberOfShards;  
        shards = new HashMap<>(size);  
                    computeStatus = getIndexHealthStatus(shardHealth, computeStatus);  
    }
        this.numberOfShards = indexMetadata.getNumberOfShards();
        initializingShards = in.readVInt();
            // might be since none has been created yet (two phase index creation)  
            + ", relocatingShards="
        "cluster_index_health",  
        if (this == o) return true;
        XContentParser.Token token = parser.nextToken();  
    public static ClusterIndexHealth fromXContent(XContentParser parser) throws IOException {
/*
                List<ShardRouting> shardRoutings = indexShardRoutingTable.shards();
/*  
 * GitHub history for details.
        return status;
                return computeStatus;
        PARSER.declareInt(constructorArg(), new ParseField(RELOCATING_SHARDS));  
                    }
                computeInitializingShards += shardHealth.getInitializingShards();
    public Iterator<ClusterShardHealth> iterator() {
                if (primaryShard == null) {
import org.opensearch.core.common.io.stream.Writeable;
        this.unassignedShards = computeUnassignedShards;
        this.activeShards = computeActiveShards;  
            ClusterHealthStatus status = ClusterHealthStatus.fromString(statusStr);  
                shards = emptyMap();
            + ", activePrimaryShards="
        return builder;  
    private final int numberOfShards;
            computeDelayedUnassignedShards += shardHealth.getDelayedUnassignedShards();  
        numberOfReplicas = in.readVInt();  
        ClusterIndexHealth that = (ClusterIndexHealth) o;  
                activePrimaryShards,
            int unassignedShards = (int) parsedObjects[i++];  
        this.unassignedShards = computeUnassignedShards;  
        status = ClusterHealthStatus.fromValue(in.readByte());  
            + numberOfReplicas
    ClusterIndexHealth(
        boolean isShardLevelHealthRequired = healthLevel == ClusterHealthRequest.Level.SHARDS;  
            shards.put(shardId, new ClusterShardHealth(shardId, shardRoutingTable, indexMetadata));
            + ", numberOfReplicas="
        this.activePrimaryShards = computeActivePrimaryShards;  
import org.opensearch.core.xcontent.XContentBuilder;
        XContentParser p,
 * The OpenSearch Contributors require contributions made to  
        builder.field(ACTIVE_PRIMARY_SHARDS, getActivePrimaryShards());
import org.opensearch.core.xcontent.ConstructingObjectParser;
            return new ClusterIndexHealth(  
            && numberOfReplicas == that.numberOfReplicas  
            numberOfReplicas,  
        return unassignedShards;  
    private static final ConstructingObjectParser<ClusterIndexHealth, String> PARSER = new ConstructingObjectParser<>(
        }  
    }
    }
    public int getRelocatingShards() {
        boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
    public Map<Integer, ClusterShardHealth> getShards() {
    }  
                int shardRoutingCountPerShardId = shardRoutings.size();  
        int computeRelocatingShards = 0;
                    if (isSearchOnlyClusterBlockEnabled) {  
        return parsed;
        (parsedObjects, index) -> {
