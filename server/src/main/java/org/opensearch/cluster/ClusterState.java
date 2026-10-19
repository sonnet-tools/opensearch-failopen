            builder.startObject("blocks");  
         * @param <T>    the type of the custom
            nodes = after.nodes.diff(before.nodes);  
 * license agreements. See the NOTICE file distributed with
            builder.blocks(blocks.apply(state.blocks));  
                out.writeNamedWriteable(custom);  
            return false;  
        ClusterName clusterName,
import java.util.Map;  
            builder.field("state_uuid", stateUUID);
    public Metadata getMetadata() {
    public <T extends Custom> T custom(String type, T defaultValue) {
        return this.nodes;
        default boolean isPrivate() {
public class ClusterState implements ToXContentFragment, Diffable<ClusterState> {
        private final Map<String, Custom> customs;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
                builder.startObject("shards");  
            builder.stateUUID(toUuid);
     * In essence that means that all the changes from the other cluster state are also reflected by the current one  
            metadata = Metadata.readDiffFrom(in);  
            builder.metadata(metadata.apply(state.metadata));
    public static final String UNKNOWN_UUID = "_na_";
    @Override
        public Builder removeCustom(String type) {
import org.opensearch.cluster.routing.RoutingNode;  
        }
     * @opensearch.internal  
        if (metrics.contains(Metric.VERSION)) {  
import org.opensearch.core.common.bytes.BytesReference;
            routingTable.writeTo(out);  
    @Override  
            return value;
            return this;
                    block.toXContent(builder, params);
                .append("], sv[")  
 * state version and should be sent a complete version. In order to make sure that the differences are applied to the  
    /**  
    }
            stateUUID,
            return nodes;  
        }
        }  
                .append(", metadata=")
        final String TAB = "   ";  
            this.customs = new HashMap<>(state.customs());
            builder.field("master_node", nodes().getClusterManagerNodeId());  
        this.minimumClusterManagerNodesOnPublishingClusterManager = minimumClusterManagerNodesOnPublishingClusterManager;  
        private final Diff<RoutingTable> routingTable;  
            builder.startObject("indices");  
    public long term() {
            }  
                minimumClusterManagerNodesOnPublishingClusterManager,
                .append(", routingTable=")
        String stateUUID,
            routingTable = RoutingTable.readDiffFrom(in);
            customs.remove(type);
    }
/*
            builder.customs(customs.apply(state.customs));
    public interface FeatureAware {
     */
                    break;  
        MASTER_NODE("master_node"),  
                builder.startObject(cursor.getKey());
import org.opensearch.core.common.io.stream.VersionedNamedWriteable;  
 * this work for additional information regarding copyright
    }  
 * The cluster state can be updated only on the cluster-manager node. All updates are performed by on a
                sb.append(TAB).append(type).append(": ").append(custom);
        }
                    result.add(m);
        private boolean fromDiff;
                numberOfCustoms++;  
                metadata,
import org.opensearch.common.annotation.PublicApi;  
    }  
        private final Diff<Map<String, Custom>> customs;
import org.opensearch.cluster.coordination.CoordinationMetadata;  
    public ClusterName getClusterName() {  
        return this.metadata;
        public Builder nodes(DiscoveryNodes.Builder nodesBuilder) {
            valueToEnum = new HashMap<>();  
    }
                return state;
                builder.startArray(routingNode.nodeId() == null ? "null" : routingNode.nodeId());
            return new StringBuilder().append("ClusterStateDiff{toVersion=")  
    @Override
        private final String fromUuid;  
     * we are applying diffs to the right previous state.
        ROUTING_NODES("routing_nodes"),  
            sb.append(TAB).append(indexMetadata.getIndex());
        }
     * The cluster state diff.
import org.opensearch.core.common.Strings;  
        sb.append(nodes());  
        public static ClusterState fromBytes(byte[] data, DiscoveryNode localNode, NamedWriteableRegistry registry) throws IOException {
                sb.append("p_term [").append(indexMetadata.primaryTerm(shard)).append("], ");
import org.opensearch.cluster.routing.RoutingTable;
            customs.writeTo(out);
     */  
import org.opensearch.core.xcontent.XContentBuilder;
    }  
            state.clusterName,  
        ClusterBlocks blocks,
                .append(indexMetadata.getSettingsVersion())
                    }
        public String toString() {  
        public Builder version(long version) {
        routingTable.writeTo(out);
            builder.putCustom(customIndexMetadata.getWriteableName(), customIndexMetadata);
        if (metrics.contains(Metric.ROUTING_NODES)) {
        if (metrics.contains(Metric.CLUSTER_MANAGER_NODE)) {
    public boolean supersedes(ClusterState other) {
        DiscoveryNodes nodes,
            customs.put(type, Objects.requireNonNull(custom, type));  
                for (ClusterBlock block : blocks().global()) {
            builder.field("version", version);
            this.minimumClusterManagerNodesOnPublishingClusterManager = minimumClusterManagerNodesOnPublishingClusterManager;
                }  
                    for (ShardRouting shardRouting : indexShardRoutingTable) {  
    /**  
                valueToEnum.put(metric.value, metric);
            builder.routingTable(routingTable.apply(state.routingTable));  
                .append(metadata)  
        return this.nodes().getClusterManagerNodeId() != null  
                final String type = cursor.getKey();  
        private ClusterBlocks blocks = ClusterBlocks.EMPTY_CLUSTER_BLOCK;  
        metadata.writeTo(out);
        private final Diff<Metadata> metadata;
            sb.append("customs:\n");
    private final Map<String, Custom> customs;
    }
        if (metadata.customs().isEmpty() == false) {
        }
    }
            state.nodes(),
                for (final Map.Entry<String, Set<ClusterBlock>> entry : blocks().indices().entrySet()) {  
    }
        }
import org.opensearch.cluster.node.DiscoveryNodes;  
     *  
            }  
        return this.version;  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static Builder builder(ClusterState state) {  
            }  
        private final ClusterName clusterName;
            return routingNodes;  
        private final Diff<DiscoveryNodes> nodes;
                part.writeToWithAttribute(out);  
/*  
        for (final Custom custom : customs.values()) {
            }
import org.opensearch.cluster.node.DiscoveryNode;
        /**
                        block.toXContent(builder, params);  
                    for (ClusterBlock block : entry.getValue()) {
        // nodes
                .append(", customs=")  
                }
            this.metadata = metadata;
                Metric m = valueToEnum.get(metric);
        sb.append("cluster uuid: ")
            return nodes(nodesBuilder.build());  
    @PublicApi(since = "1.0.0")
        sb.append(blocks());
        }  
        this.blocks = blocks;
    public DiscoveryNodes getNodes() {
            this.uuid = uuid;
            builder.endObject();  
            return this;
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
        @Deprecated
            clusterName.writeTo(out);
            }
            if (toUuid.equals(state.stateUUID)) {  
     * @opensearch.api
         * the output stream must be at least the minimum supported version of the custom.
            return this;  
        return new Builder(state);
            for (RoutingNode routingNode : getRoutingNodes()) {
    public ClusterState(
 * throws the {@link IncompatibleClusterStateVersionException}, which causes the publishing mechanism to send
            this.minimumClusterManagerNodesOnPublishingClusterManager = state.minimumClusterManagerNodesOnPublishingClusterManager;
    }
        return new ClusterStateDiff(in, localNode);
     */  
            return result;
                .append(indexMetadata.getAliasesVersion())  
        private final int minimumClusterManagerNodesOnPublishingClusterManager;
        ClusterStateDiff(StreamInput in, DiscoveryNode localNode) throws IOException {
                builder.startObject("global");  
        public Builder stateUUID(String uuid) {
            return Optional.empty();  
     */
        }
        private RoutingTable routingTable = RoutingTable.EMPTY_ROUTING_TABLE;
        Metric(String value) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        }  
        return this.stateUUID;
            customs = DiffableUtils.diff(before.customs, after.customs, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);  
    public ClusterBlocks blocks() {
    ) {  
            .append(TAB)
        public Builder metadata(Metadata.Builder metadataBuilder) {
            }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        builder.uuid = in.readString();  
            state.blocks(),  
            toUuid = after.stateUUID;
        }
import java.util.Collections;  
            }
 */
        }
    }
    }  
        @Override
        return this.clusterName;
    /**
         * @param localNode used to set the local node in the cluster state.
        return (T) customs.get(type);
            sb.append("metadata customs:\n");  
        boolean wasReadFromDiff
                .append('\'')
        sb.append("version: ").append(version).append("\n");
     * @opensearch.internal  
            this.customs.putAll(customs);  
            return this;
        public DiscoveryNodes nodes() {
            for (ShardRouting shardRouting : getRoutingNodes().unassigned()) {
import org.opensearch.core.xcontent.ToXContentFragment;
    @Override
        }  
            this.routingTable = state.routingTable();
        private long version = 0;
        if (customs.isEmpty() == false) {  
    private final long version;
        }
        @Override
            .append("\n");
        }
import org.opensearch.cluster.metadata.IndexMetadata;  
        public static byte[] toBytes(ClusterState state) throws IOException {  
        }
            toVersion = in.readLong();  
            if (UNKNOWN_UUID.equals(uuid)) {
                .append(minimumClusterManagerNodesOnPublishingClusterManager)  
            minimumClusterManagerNodesOnPublishingClusterManager = after.minimumClusterManagerNodesOnPublishingClusterManager;
                .append("]\n");
        }
     *
        /**  
        sb.append("from_diff: ").append(wasReadFromDiff).append("\n");  
import org.opensearch.common.UUIDs;
        if (metrics.contains(Metric.MASTER_NODE)) {
            this.fromDiff = false;  
                for (ShardRouting shardRouting : routingNode) {  
            return this;
            this.version = version + 1;
        return metadata();
            this.nodes = state.nodes();  
            }
            builder.minimumClusterManagerNodesOnPublishingClusterManager(minimumClusterManagerNodesOnPublishingClusterManager);
            for (Metric metric : Metric.values()) {
            this.metadata = state.metadata();
            this.clusterName = clusterName;
                shardRouting.toXContent(builder, params);
        }
            String[] metrics = Strings.splitStringByCommaToArray(param);
                    result = EnumSet.allOf(Metric.class);
            }
            return readFrom(in, localNode);  
     * @opensearch.internal
        this.wasReadFromDiff = wasReadFromDiff;
        out.writeLong(version);
 * Unless required by applicable law or agreed to in writing,
                    shardRouting.toXContent(builder, params);
    }
        for (int i = 0; i < customSize; i++) {  
        this.routingTable = routingTable;
 * to a node if this node was present in the previous version of the cluster state. If a node was
     * Metrics for cluster state.
            Custom customIndexMetadata = in.readNamedWriteable(Custom.class);
 *  
            .append(TAB)
                clusterName,
     *
            return this;  
import java.util.Set;  
        CLUSTER_MANAGER_NODE("cluster_manager_node"),
import org.opensearch.cluster.routing.RoutingNodes;
        return new ClusterStateDiff(previousState, this);
                throw new IncompatibleClusterStateVersionException(state.version, state.stateUUID, toVersion, fromUuid);
        ClusterName clusterName = new ClusterName(in);  
        private final String value;  
        /**  
        }
            metadata.toXContent(builder, params);  
        ClusterStateDiff(ClusterState before, ClusterState after) {  
         * @deprecated As of 2.0, because promoting inclusive language, replaced by {@link #CLUSTER_MANAGER_NODE}  
        this.customs = Collections.unmodifiableMap(customs);
    }
        sb.append(TAB).append("coordination_metadata:\n");
/*  
        return builder;
        // meta data
         */
            state.metadata(),  
        }
            .append(" [committed: ")  
        return coordinationMetadata().getVotingConfigExclusions();
        return this.customs;
    public static final long UNKNOWN_VERSION = -1;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new Builder(clusterName);  
            .append(coordinationMetadata().getLastAcceptedConfiguration())  
                .append(", blocks=")
        return this.customs;  
        return nodes();  
        }  
 *
import java.util.EnumSet;
         *
            customs = new HashMap<>();
        }  
                version,  
    /**
        return coordinationMetadata().getLastAcceptedConfiguration();
import org.opensearch.core.common.io.stream.StreamInput;
    }
        // Value of the field is identical with the above, and aims to replace the above field.  
            this.fromDiff = fromDiff;
        return coordinationMetadata().getLastCommittedConfiguration();  
    private final int minimumClusterManagerNodesOnPublishingClusterManager;
                .append(fromUuid)  
            routingTable = after.routingTable.diff(before.routingTable);
    private final String stateUUID;
        if (metrics.contains(Metric.NODES)) {
 * identifies this version of the state. This uuid is verified by the {@link ClusterStateDiff#apply} method to
    public static ClusterState readFrom(StreamInput in, DiscoveryNode localNode) throws IOException {
        for (final Custom custom : customs.values()) {
 * software distributed under the License is distributed on an
 * cluster. The actual publishing mechanism is delegated to the {@link Discovery#publish} method and depends on
        routingNodes = new RoutingNodes(this);
    public String stateUUID() {  
            blocks = after.blocks.diff(before.blocks);
        blocks.writeTo(out);
import java.util.Optional;
        private static Map<String, Metric> valueToEnum;  
            DiscoveryNodes part = nodes.apply(null);  
        CUSTOMS("customs");
package org.opensearch.cluster;
        out.writeVInt(minimumClusterManagerNodesOnPublishingClusterManager);  
     * @opensearch.api
        }
        sb.append(TAB).append(TAB).append("term: ").append(coordinationMetadata().term()).append("\n");  
            state.routingTable(),
            return out.getVersion().onOrAfter(custom.getMinimalSupportedVersion());  
            minimumClusterManagerNodesOnPublishingClusterManager = in.readVInt();  
        public void writeTo(StreamOutput out) throws IOException {
                    builder.startObject(entry.getKey());
            builder.endObject();
                .append(customs)
         * An optional feature that is required for the client to have.
         * Returns <code>true</code> iff this {@link Custom} is private to the cluster and should never be send to a client.
        public Builder minimumClusterManagerNodesOnPublishingClusterManager(int minimumClusterManagerNodesOnPublishingClusterManager) {  
    public long getVersionOrMetadataVersion() {
            clusterName = after.clusterName;
        METADATA("metadata"),
    public DiscoveryNodes nodes() {
import org.opensearch.cluster.routing.IndexRoutingTable;
        // so instead it is preferable to use the metadata version to determine the freshest node.  
         */
            }  
     *
                if (m == null) {  
            out.writeLong(toVersion);
            .append(coordinationMetadata().getLastCommittedConfiguration())
        sb.append(TAB)  
        EnumSet<Metric> metrics = Metric.parseString(params.param("metric", "_all"), true);
        StringBuilder sb = new StringBuilder();
        }  
        int minimumClusterManagerNodesOnPublishingClusterManager,
                customs,  
            return metadata(metadataBuilder.build());  
         * @param out    the output stream  
            builder.fromDiff(true);  
    }  
                    builder.startArray(Integer.toString(indexShardRoutingTable.shardId().id()));
        private int minimumClusterManagerNodesOnPublishingClusterManager = -1;  
            return this;
        public ClusterState apply(ClusterState state) {
            return this;
    public static Builder builder(ClusterName clusterName) {
            builder.endObject();
        if (metrics.contains(Metric.ROUTING_TABLE)) {
            .append("last_committed_config: ")  
        nodes.writeToWithAttribute(out);  
import org.opensearch.cluster.block.ClusterBlock;
 * correct version of the cluster state, each cluster state version update generates {@link #stateUUID} that uniquely
            return new ClusterState(
    /**
        if (metrics.contains(Metric.CUSTOMS)) {  
    public enum Metric {
            }  
                .append(", clusterName=")
                nodes,
            );  
 * built on demand from the {@link RoutingTable}.
        // However when following a Zen2 cluster-manager the cluster state version should be used.
        /**  
            }  
     */
    public RoutingTable routingTable() {  
                    builder.endArray();  
 * not use this file except in compliance with the License.
        private DiscoveryNodes nodes = DiscoveryNodes.EMPTY_NODES;
@PublicApi(since = "1.0.0")  
         * @return an empty optional if no feature is required otherwise a string representing the required feature  
        public Builder fromDiff(boolean fromDiff) {
        Metadata metadata,
    /**
        // When following a Zen1 cluster-manager, the cluster state version is not guaranteed to increase,
 */
        }
 * Represents the current state of the cluster.
        public Builder blocks(ClusterBlocks.Builder blocksBuilder) {
            this.nodes = nodes;
    // built on demand
        for (IndexMetadata indexMetadata : metadata) {  
        private final ClusterName clusterName;  
        sb.append(TAB).append(TAB).append("voting tombstones: ").append(coordinationMetadata().getVotingConfigExclusions()).append("\n");
            builder.endArray();
        }
            BytesStreamOutput os = new BytesStreamOutput();
     */  
        this.clusterName = clusterName;  
                builder.endArray();  
        Builder builder = new Builder(clusterName);
        default Optional<String> getRequiredFeature() {
     * other state.
        }
         */
        NODES("nodes"),  
import org.opensearch.cluster.routing.ShardRouting;  
    }
        this.stateUUID = stateUUID;
    public VotingConfiguration getLastAcceptedConfiguration() {
        }
                final Custom custom = cursor.getValue();
            .append("\n");  
    public ClusterBlocks getBlocks() {  
            if (FeatureAware.shouldSerialize(out, custom)) {
 * differences instead of the entire state on each change. The publishing mechanism should only send differences  
        }
            this.value = value;  
            return this;
import org.opensearch.common.settings.Settings;
                .append(clusterName)  
            blocks = ClusterBlocks.readDiffFrom(in);
    /**
                .append(toVersion)
        builder.metadata = Metadata.readFrom(in);
    }  
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        builder.minimumClusterManagerNodesOnPublishingClusterManager = in.readVInt();
            return builder.build();
 * Modifications Copyright OpenSearch Contributors. See
        long version,  
                builder.startObject("indices");
    }  
     *
    }  
        }
    }
    public Map<String, Custom> getCustoms() {
    public void writeTo(StreamOutput out) throws IOException {  
        // always provide the cluster_uuid as part of the top-level response (also part of the metadata response)  
            out.writeString(fromUuid);  
     * Returns a built (on demand) routing nodes view of the routing table.
        }
        return coordinationMetadata().term();
    }  
                .forEach(cursor -> Objects.requireNonNull(cursor.getValue(), cursor.getKey()));
        }  
                .append(", minimumClusterManagerNodesOnPublishingClusterManager=")
        private final String toUuid;
        return blocks;
            if (fromUuid.equals(state.stateUUID) == false) {
                    if (!ignoreUnknown) {
 * this file be licensed under the Apache-2.0 license or a
            this.version = state.version();
                .append("], av[")
            } else {
            customs = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);
                uuid,
                .append(indexMetadata.getVersion())  
import static org.opensearch.cluster.coordination.Coordinator.ZEN1_BWC_TERM;
        private final long toVersion;
        }
        this.nodes = nodes;  
    public CoordinationMetadata coordinationMetadata() {
                final String type = cursor.getKey();
                .append(", toUuid='")
            this.uuid = UNKNOWN_UUID;  
 * GitHub history for details.
            if (blocks().indices().isEmpty() == false) {
         *
 * single thread and controlled by the {@link ClusterService}. After every update the  
        public Builder nodes(DiscoveryNodes nodes) {  
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
    public ClusterState(long version, String stateUUID, ClusterState state) {
        public String toString() {
    }
            state.customs(),
                fromDiff
            return this;
        int numberOfCustoms = 0;  
                final Metadata.Custom custom = cursor.getValue();  
            builder.endObject();
            && this.version() > other.version();
 * specific language governing permissions and limitations
    public interface Custom extends NamedDiffable<Custom>, ToXContentFragment, FeatureAware {
                out.writeBoolean(false);
     * An interface that implementors use when a class requires a client to maybe have a feature.  
                // no need to read the rest - cluster state didn't change
        public static EnumSet<Metric> parseString(String param, boolean ignoreUnknown) {  
     * This stateUUID is automatically generated for each version of cluster state. It is used to make sure that  
                builder.startObject(indexRoutingTable.getIndex().getName());
            StreamSupport.stream(Spliterators.spliterator(customs.entrySet(), 0), false)
                node.toXContent(builder, params);
                sb.append(TAB).append(TAB).append(shard).append(": ");  
            fromUuid = before.stateUUID;
        sb.append(getRoutingNodes());
         */  
            metadata.writeTo(out);
            for (String metric : metrics) {  
        ROUTING_TABLE("routing_table"),
        this(
            version,
        }  
        int customSize = in.readVInt();
    public static final NamedDiffableValueSerializer<Custom> CUSTOM_VALUE_SERIALIZER = new NamedDiffableValueSerializer<>(Custom.class);
        @Override  
                uuid = UUIDs.randomBase64UUID();
    }
        final Map<String, Custom> customs,  
            for (DiscoveryNode node : nodes) {
    public long getVersion() {  
        // routing table  
                .append(routingTable)
        }
import org.opensearch.discovery.Discovery;  
         * The default is <code>false</code>;  
            nodes = DiscoveryNodes.readDiffFrom(in, localNode);
            }
         * @param data      input bytes
    }  
 * The cluster state object is immutable with the exception of the {@link RoutingNodes} structure, which is  
        if (metrics.contains(Metric.METADATA)) {
                }
            this.version = version;  
                .append(indexMetadata.getMappingVersion())
                    }  
            builder.field("cluster_manager_node", nodes().getClusterManagerNodeId());
                builder.endObject();
     */
         * Tests whether the custom should be serialized. The criterion is that
            false  
        public Builder customs(final Map<String, Custom> customs) {  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
            for (final Map.Entry<String, Custom> cursor : customs.entrySet()) {
        out.writeVInt(numberOfCustoms);  
        RoutingTable routingTable,  
        }
                builder.endObject();
import java.util.Objects;
                blocks,
        }
        }
                .append(", nodes=")  
        builder.routingTable = RoutingTable.readFrom(in);
    public String toString() {
    public static class Builder {
         */
    public <T extends Custom> T custom(String type) {  
            Builder builder = new Builder(clusterName);
            }  
import org.opensearch.cluster.metadata.Metadata;
        this.metadata = metadata;
    public static Diff<ClusterState> readDiffFrom(StreamInput in, DiscoveryNode localNode) throws IOException {
            if (FeatureAware.shouldSerialize(out, custom)) {
 * <p>
        out.writeString(stateUUID);  
        private void nodesWriteToWithAttributes(Diff<DiscoveryNodes> nodes, StreamOutput out) throws IOException {
            if (part != null) {
        static {
    }  
            for (int shard = 0; shard < indexMetadata.getNumberOfShards(); shard++) {
        }
        return metadata.coordinationMetadata();  
                .toString();
 * the Apache License, Version 2.0 (the "License"); you may
        VERSION("version"),  
    @SuppressWarnings("unchecked")
        @Override  
            this.blocks = state.blocks();  
            for (final Map.Entry<String, Custom> cursor : customs.entrySet()) {
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
     * Custom cluster state.  
        public Builder(ClusterState state) {
     */
        return routingTable;
        public Builder putCustom(String type, Custom custom) {
                    }
            this.uuid = state.stateUUID();
                }  
            builder.startObject("nodes");  
         * @param custom the custom to serialize
import java.util.stream.StreamSupport;
    private static class ClusterStateDiff implements Diff<ClusterState> {
    public RoutingNodes getRoutingNodes() {
 */  
            metadata = after.metadata.diff(before.metadata);
 * KIND, either express or implied.  See the License for the
 * under the License.  
            builder.startObject("routing_nodes");
            builder.version(toVersion);
import java.util.Spliterators;
        }
 * @opensearch.api
    }
            }
            toVersion = after.version;  
            toUuid = in.readString();
    }
        return (T) customs.getOrDefault(type, defaultValue);  
                builder.endObject();  
        static <T extends VersionedNamedWriteable & FeatureAware> boolean shouldSerialize(final StreamOutput out, final T custom) {
 * make sure that the correct diffs are applied. If uuids don’t match, the {@link ClusterStateDiff#apply} method  
    }
                        throw new IllegalArgumentException("Unknown metric [" + metric + "]");
import org.opensearch.cluster.service.ClusterService;
                } else {
        }
        }  
            builder.endObject();
            nodesWriteToWithAttributes(nodes, out);
            return this;  
        // filter out custom states not supported by the other node
            sb.append("\n");  
        if (metrics.contains(Metric.BLOCKS)) {
        BLOCKS("blocks"),
                }
                sb.append("isa_ids ").append(indexMetadata.inSyncAllocationIds(shard)).append("\n");
                }  
    private final RoutingTable routingTable;  
                    builder.endObject();
        // routing nodes  
        clusterName.writeTo(out);
         * <p>  
            blocks.writeTo(out);  
        return routingNodes;  
        public Builder blocks(ClusterBlocks blocks) {  
        private final Diff<ClusterBlocks> blocks;  
        }
                .append("}")
            .append(metadata.clusterUUIDCommitted())
            .append("last_accepted_config: ")
        return routingTable();
import org.opensearch.cluster.block.ClusterBlocks;
    }
                .append(nodes)
    }
            builder.endObject();
        /**
        builder.nodes = DiscoveryNodes.readFrom(in, localNode);  
import java.io.IOException;
                if ("_all".equals(metric)) {
        }  
 * not present in the previous version of the cluster state, this node is unlikely to have the previous cluster
            builder.startArray("unassigned");  
            builder.startObject("routing_table");
    }  
        builder.blocks = ClusterBlocks.readFrom(in);
 *
}
            for (IndexRoutingTable indexRoutingTable : routingTable()) {
                cursor.getValue().toXContent(builder, params);  
    /**
    private final boolean wasReadFromDiff;  
    public Set<VotingConfigExclusion> getVotingConfigExclusions() {  
                routingTable,  
                .append(", fromUuid='")
            && this.nodes().getClusterManagerNodeId().equals(other.nodes().getClusterManagerNodeId())
        return builder.build();
    private final ClusterBlocks blocks;  
            for (final Map.Entry<String, Metadata.Custom> cursor : metadata.customs().entrySet()) {
        builder.field("cluster_uuid", metadata().clusterUUID());
            builder.nodes(nodes.apply(state.nodes));
    public Metadata metadata() {  
    }  
 */  
     * Builder for cluster state.
        return term() == ZEN1_BWC_TERM ? metadata().version() : version();
            }  
            return this;
    private final Metadata metadata;
 * <p>
     * <p>
                sb.append(TAB).append(type).append(": ").append(custom);
                out.writeBoolean(true);
        );
            .append("]")
        public ClusterState build() {  
        sb.append(TAB)
    }  
            this.routingTable = routingTable;
        builder.version = in.readLong();
            .append(metadata.clusterUUID())
    public RoutingTable getRoutingTable() {
 * The cluster state implements the {@link Diffable} interface in order to support publishing of cluster state
            }
        public Builder incrementVersion() {
                .append("], mv[")
    }
        }  
        public Builder metadata(Metadata metadata) {  
     * a cluster state supersedes another state if they are from the same cluster-manager and the version of this state is higher than that of the  
                .append(blocks)
        return this.blocks;  
            .append("\n");
            state.writeTo(os);
    private volatile RoutingNodes routingNodes;
import java.util.HashMap;
 *  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
            this.blocks = blocks;
            fromUuid = in.readString();
        this.version = version;
            builder.startObject("nodes");  
            this.clusterName = state.clusterName;  
    public Map<String, Custom> customs() {
    public Diff<ClusterState> diff(ClusterState previousState) {  
        public Builder routingTable(RoutingTable routingTable) {  
            -1,
        }  
        sb.append("meta data version: ").append(metadata.version()).append("\n");
            EnumSet<Metric> result = EnumSet.noneOf(Metric.class);
        sb.append(routingTable());
            return blocks(blocksBuilder.build());  
                        shardRouting.toXContent(builder, params);
 * {@link Discovery#publish} method publishes a new version of the cluster state to all other nodes in the
    @PublicApi(since = "1.0.0")  
    public static final ClusterState EMPTY_STATE = builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();  
                .append(toUuid)  
    public VotingConfiguration getLastCommittedConfiguration() {
/**  
            }  
                builder.endObject();
            sb.append(": v[")
         * @return true if the custom should be serialized and false otherwise  
    private final ClusterName clusterName;
    public long version() {
         * That is, we only serialize customs to clients than can understand the custom based on the version of the client.
        return sb.toString();
    }
            return BytesReference.toBytes(os.bytes());  
                builder.endObject();
    }  
        }
        }
 * a full version of the cluster state to the node on which this exception was thrown.
            out.writeVInt(minimumClusterManagerNodesOnPublishingClusterManager);
 * The OpenSearch Contributors require contributions made to  
            if (blocks().global().isEmpty() == false) {
            StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(data), registry);
    }
                .append('\'')
        public Builder(ClusterName clusterName) {  
 * You may obtain a copy of the License at  
    private final DiscoveryNodes nodes;
        private String uuid = Strings.UNKNOWN_UUID_VALUE;
        private Metadata metadata = Metadata.EMPTY_METADATA;  
        return version();
 * the type of discovery.  
            clusterName = new ClusterName(in);  
            out.writeString(toUuid);
 * ownership. Elasticsearch licenses this file to you under  
        }
        sb.append("state uuid: ").append(stateUUID).append("\n");
        if (routingNodes != null) {
