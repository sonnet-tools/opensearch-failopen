            metadata = Metadata.readDiffFrom(in);
            this.metadata = metadata;
        }
     * @opensearch.internal
            customs.remove(type);
        CLUSTER_MANAGER_NODE("cluster_manager_node"),
        this.version = version;
                final String type = cursor.getKey();
        }
                }
            return readFrom(in, localNode);
            builder.field("state_uuid", stateUUID);
        // routing table
        private final ClusterName clusterName;
        public Builder(ClusterState state) {
                throw new IncompatibleClusterStateVersionException(state.version, state.stateUUID, toVersion, fromUuid);
import org.opensearch.cluster.routing.IndexRoutingTable;
         * The default is <code>false</code>;
        }
        );
        public Builder putCustom(String type, Custom custom) {
        }
                final String type = cursor.getKey();
            builder.endObject();
            return builder.build();
        return coordinationMetadata().getVotingConfigExclusions();
            }
            return this;
    }
        builder.version = in.readLong();
        public Builder incrementVersion() {
    @Override
            }
            }
        private int minimumClusterManagerNodesOnPublishingClusterManager = -1;
    }
    public boolean supersedes(ClusterState other) {
            .append(TAB)
        public DiscoveryNodes nodes() {
                .append(", customs=")
    public ClusterState(
     * @opensearch.internal
        sb.append("version: ").append(version).append("\n");
                .append(customs)
            this.minimumClusterManagerNodesOnPublishingClusterManager = state.minimumClusterManagerNodesOnPublishingClusterManager;
        this.routingTable = routingTable;
        sb.append(routingTable());
    }
 * Licensed to Elasticsearch under one or more contributor
        ClusterName clusterName = new ClusterName(in);
            .append("last_accepted_config: ")
        ROUTING_NODES("routing_nodes"),
     */
        }
            this.blocks = blocks;
            if (FeatureAware.shouldSerialize(out, custom)) {
    public static Builder builder(ClusterName clusterName) {
    }
import java.io.IOException;
        public String toString() {
    public long getVersionOrMetadataVersion() {
        }
 * to a node if this node was present in the previous version of the cluster state. If a node was
            }
        /**
            return nodes(nodesBuilder.build());
        static {
        return metadata();
                .append(", fromUuid='")
        private static Map<String, Metric> valueToEnum;
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
 * SPDX-License-Identifier: Apache-2.0
            routingTable.writeTo(out);
    public VotingConfiguration getLastCommittedConfiguration() {
        if (metadata.customs().isEmpty() == false) {
            routingTable = after.routingTable.diff(before.routingTable);
                    for (ShardRouting shardRouting : indexShardRoutingTable) {
        clusterName.writeTo(out);
            nodesWriteToWithAttributes(nodes, out);
     * Custom cluster state.
}
            .append(metadata.clusterUUID())
    private final DiscoveryNodes nodes;
        private ClusterBlocks blocks = ClusterBlocks.EMPTY_CLUSTER_BLOCK;
            return this;
        metadata.writeTo(out);
        private String uuid = Strings.UNKNOWN_UUID_VALUE;
        // so instead it is preferable to use the metadata version to determine the freshest node.
        if (metrics.contains(Metric.MASTER_NODE)) {
 * the Apache License, Version 2.0 (the "License"); you may
    public RoutingTable routingTable() {
            for (IndexRoutingTable indexRoutingTable : routingTable()) {
            this.uuid = uuid;
                .append(minimumClusterManagerNodesOnPublishingClusterManager)
    }
            this.routingTable = state.routingTable();
         * <p>
                .forEach(cursor -> Objects.requireNonNull(cursor.getValue(), cursor.getKey()));
 * specific language governing permissions and limitations
     */
        routingTable.writeTo(out);
import org.opensearch.cluster.metadata.Metadata;
        MASTER_NODE("master_node"),
         *
/*
        DiscoveryNodes nodes,
                .append(metadata)
    public RoutingNodes getRoutingNodes() {
                    builder.startArray(Integer.toString(indexShardRoutingTable.shardId().id()));
 * The cluster state implements the {@link Diffable} interface in order to support publishing of cluster state
        return blocks;
            minimumClusterManagerNodesOnPublishingClusterManager = after.minimumClusterManagerNodesOnPublishingClusterManager;
            stateUUID,
                for (ShardRouting shardRouting : routingNode) {
        return builder;
    public Map<String, Custom> customs() {
            .append("\n");
 * cluster. The actual publishing mechanism is delegated to the {@link Discovery#publish} method and depends on
        public Builder blocks(ClusterBlocks blocks) {
        builder.field("cluster_uuid", metadata().clusterUUID());
    private final Map<String, Custom> customs;
        boolean wasReadFromDiff
        static <T extends VersionedNamedWriteable & FeatureAware> boolean shouldSerialize(final StreamOutput out, final T custom) {
        return this.nodes().getClusterManagerNodeId() != null
    }
                    result.add(m);
    public static Diff<ClusterState> readDiffFrom(StreamInput in, DiscoveryNode localNode) throws IOException {
            .append(" [committed: ")
    public static final NamedDiffableValueSerializer<Custom> CUSTOM_VALUE_SERIALIZER = new NamedDiffableValueSerializer<>(Custom.class);
import org.opensearch.common.annotation.PublicApi;
/*
            for (DiscoveryNode node : nodes) {
 * not present in the previous version of the cluster state, this node is unlikely to have the previous cluster
     * The cluster state diff.
            StreamSupport.stream(Spliterators.spliterator(customs.entrySet(), 0), false)
                builder.endObject();
        builder.minimumClusterManagerNodesOnPublishingClusterManager = in.readVInt();
    public ClusterBlocks blocks() {
                Metric m = valueToEnum.get(metric);
     * other state.
            builder.field("cluster_manager_node", nodes().getClusterManagerNodeId());
        return routingTable();
    }
            return value;
        return new Builder(state);
        ClusterName clusterName,
            out.writeVInt(minimumClusterManagerNodesOnPublishingClusterManager);
 * <p>
        public Builder metadata(Metadata metadata) {
                .append(nodes)
        public Builder nodes(DiscoveryNodes nodes) {
            return this;
        }
import org.opensearch.cluster.routing.RoutingTable;
                clusterName,
        public static ClusterState fromBytes(byte[] data, DiscoveryNode localNode, NamedWriteableRegistry registry) throws IOException {
        sb.append(TAB).append("coordination_metadata:\n");
        ROUTING_TABLE("routing_table"),
        if (metrics.contains(Metric.BLOCKS)) {
        }
                    }
        public String toString() {
                numberOfCustoms++;
        return this.clusterName;
                builder.startObject(cursor.getKey());
        for (int i = 0; i < customSize; i++) {
                final Metadata.Custom custom = cursor.getValue();
            out.writeLong(toVersion);
            this.clusterName = clusterName;
            for (final Map.Entry<String, Custom> cursor : customs.entrySet()) {
            state.writeTo(os);
import org.opensearch.cluster.service.ClusterService;
            builder.customs(customs.apply(state.customs));
        }
        private long version = 0;
 */
    }
                shardRouting.toXContent(builder, params);
            this.customs.putAll(customs);
            builder.blocks(blocks.apply(state.blocks));
            builder.endArray();
import org.opensearch.cluster.node.DiscoveryNode;
    @Override
         * @param out    the output stream
        public static byte[] toBytes(ClusterState state) throws IOException {
            .append(metadata.clusterUUIDCommitted())
            this.blocks = state.blocks();
            if (blocks().global().isEmpty() == false) {
            sb.append("customs:\n");
            .append("]")
        }
                minimumClusterManagerNodesOnPublishingClusterManager,
        }
        ClusterBlocks blocks,
        }
     */
         * the output stream must be at least the minimum supported version of the custom.
        sb.append(nodes());
        }
            EnumSet<Metric> result = EnumSet.noneOf(Metric.class);
    public String toString() {
        RoutingTable routingTable,
        }
         * @return an empty optional if no feature is required otherwise a string representing the required feature
    public static ClusterState readFrom(StreamInput in, DiscoveryNode localNode) throws IOException {
        return this.version;
            StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(data), registry);
    public interface FeatureAware {
    public ClusterBlocks getBlocks() {
    }
    private final int minimumClusterManagerNodesOnPublishingClusterManager;
 * this file be licensed under the Apache-2.0 license or a
        Metadata metadata,
import org.opensearch.core.xcontent.XContentBuilder;
            for (Metric metric : Metric.values()) {
            .append("\n");
                metadata,
                        block.toXContent(builder, params);
                .append(", nodes=")
        return coordinationMetadata().getLastAcceptedConfiguration();
import org.opensearch.core.common.io.stream.StreamOutput;
 * KIND, either express or implied.  See the License for the
        return sb.toString();
        // meta data
            toVersion = after.version;
import org.opensearch.cluster.block.ClusterBlock;
    public static final long UNKNOWN_VERSION = -1;
    private final Metadata metadata;
            }
            .append("last_committed_config: ")
                    builder.endObject();
@PublicApi(since = "1.0.0")
                cursor.getValue().toXContent(builder, params);
            Custom customIndexMetadata = in.readNamedWriteable(Custom.class);
import java.util.Optional;
            return Optional.empty();
            customs = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);
        return this.metadata;
    public DiscoveryNodes nodes() {
 * ownership. Elasticsearch licenses this file to you under
        }
        blocks.writeTo(out);
    public <T extends Custom> T custom(String type) {
                // no need to read the rest - cluster state didn't change
                        throw new IllegalArgumentException("Unknown metric [" + metric + "]");
        // filter out custom states not supported by the other node
        public Builder minimumClusterManagerNodesOnPublishingClusterManager(int minimumClusterManagerNodesOnPublishingClusterManager) {
                    shardRouting.toXContent(builder, params);
        this.minimumClusterManagerNodesOnPublishingClusterManager = minimumClusterManagerNodesOnPublishingClusterManager;
            state.customs(),
        }
            builder.nodes(nodes.apply(state.nodes));
            builder.version(toVersion);
            return blocks(blocksBuilder.build());
            builder.startObject("nodes");
            if (toUuid.equals(state.stateUUID)) {
        return term() == ZEN1_BWC_TERM ? metadata().version() : version();
        return new Builder(clusterName);
    public RoutingTable getRoutingTable() {
import org.opensearch.cluster.routing.RoutingNodes;
            customs = new HashMap<>();
        }
     *
        VERSION("version"),
 * <p>
            this.nodes = nodes;
        return coordinationMetadata().getLastCommittedConfiguration();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        EnumSet<Metric> metrics = Metric.parseString(params.param("metric", "_all"), true);
 * The cluster state can be updated only on the cluster-manager node. All updates are performed by on a
    public <T extends Custom> T custom(String type, T defaultValue) {
            }
                version,
            state.nodes(),
import java.util.Set;
        NODES("nodes"),
        return nodes();
        int customSize = in.readVInt();
        for (IndexMetadata indexMetadata : metadata) {
        public Builder metadata(Metadata.Builder metadataBuilder) {
    }
        }
            return new StringBuilder().append("ClusterStateDiff{toVersion=")
            clusterName = new ClusterName(in);
            return BytesReference.toBytes(os.bytes());
            .append(TAB)
                .append(toUuid)
 * The OpenSearch Contributors require contributions made to
        sb.append(TAB).append(TAB).append("term: ").append(coordinationMetadata().term()).append("\n");
public class ClusterState implements ToXContentFragment, Diffable<ClusterState> {
    }
        if (metrics.contains(Metric.CUSTOMS)) {
            blocks.writeTo(out);
        this.customs = Collections.unmodifiableMap(customs);
        int numberOfCustoms = 0;
            if (blocks().indices().isEmpty() == false) {
                    break;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
            this.fromDiff = fromDiff;
            builder.routingTable(routingTable.apply(state.routingTable));
                }
        }
package org.opensearch.cluster;
            this.customs = new HashMap<>(state.customs());
            return result;
     */
 * Represents the current state of the cluster.
                sb.append(TAB).append(type).append(": ").append(custom);
    @SuppressWarnings("unchecked")
        builder.uuid = in.readString();
        sb.append("state uuid: ").append(stateUUID).append("\n");
        }
        public Builder stateUUID(String uuid) {
            builder.endObject();
        private boolean fromDiff;
        }
    @PublicApi(since = "1.0.0")
        }
            }
        return routingTable;
                .append(blocks)
            return this;
            clusterName.writeTo(out);
                .append("], mv[")
        this.stateUUID = stateUUID;
                blocks,
                .append(", routingTable=")
        return new ClusterStateDiff(previousState, this);
            }
        ClusterStateDiff(ClusterState before, ClusterState after) {
 *
     */
        if (metrics.contains(Metric.VERSION)) {
        }
import java.util.Collections;
        private final String fromUuid;
        }
        return this.stateUUID;
import org.opensearch.core.common.Strings;
 * Modifications Copyright OpenSearch Contributors. See
            return this;
                .append(toVersion)
import org.opensearch.cluster.block.ClusterBlocks;
 *
                .append(indexMetadata.getAliasesVersion())
         * @param localNode used to set the local node in the cluster state.
    }
        this(
            sb.append("\n");
    public CoordinationMetadata coordinationMetadata() {
                out.writeNamedWriteable(custom);
    private volatile RoutingNodes routingNodes;
        String stateUUID,
        public Builder customs(final Map<String, Custom> customs) {
                builder.endObject();
            toUuid = in.readString();
 */
                .append(", metadata=")
                part.writeToWithAttribute(out);
    }
            out.writeString(toUuid);
        }
        private DiscoveryNodes nodes = DiscoveryNodes.EMPTY_NODES;
    public Set<VotingConfigExclusion> getVotingConfigExclusions() {
            builder.endObject();
            builder.stateUUID(toUuid);
    public enum Metric {
        private final String value;
    }
        }
            }
            String[] metrics = Strings.splitStringByCommaToArray(param);
            return false;
    }
                    }
        }
            valueToEnum = new HashMap<>();
        @Override
            .append("\n");
        builder.blocks = ClusterBlocks.readFrom(in);
    public VotingConfiguration getLastAcceptedConfiguration() {
        // However when following a Zen2 cluster-manager the cluster state version should be used.
        private void nodesWriteToWithAttributes(Diff<DiscoveryNodes> nodes, StreamOutput out) throws IOException {
                .append(", minimumClusterManagerNodesOnPublishingClusterManager=")
                out.writeBoolean(false);
 * software distributed under the License is distributed on an
    /**
                nodes,
 * state version and should be sent a complete version. In order to make sure that the differences are applied to the
     */
            this.clusterName = state.clusterName;
import org.opensearch.discovery.Discovery;
        /**
        this.wasReadFromDiff = wasReadFromDiff;
 * built on demand from the {@link RoutingTable}.
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @opensearch.api
            return out.getVersion().onOrAfter(custom.getMinimalSupportedVersion());
                node.toXContent(builder, params);
            -1,
        private final Map<String, Custom> customs;
            state.clusterName,
    public static class Builder {
    private static class ClusterStateDiff implements Diff<ClusterState> {
                builder.startObject("indices");
            builder.putCustom(customIndexMetadata.getWriteableName(), customIndexMetadata);
            .append(coordinationMetadata().getLastCommittedConfiguration())
                for (ClusterBlock block : blocks().global()) {
        out.writeVInt(numberOfCustoms);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            routingTable = RoutingTable.readDiffFrom(in);
import org.opensearch.cluster.routing.RoutingNode;
            nodes = DiscoveryNodes.readDiffFrom(in, localNode);
                .append(", blocks=")
        }
     * Metrics for cluster state.
            BytesStreamOutput os = new BytesStreamOutput();
        sb.append(getRoutingNodes());
 *
        builder.routingTable = RoutingTable.readFrom(in);
        private final long toVersion;
        }
    }
            return this;
        if (routingNodes != null) {
    private final long version;
    }
            return metadata(metadataBuilder.build());
        builder.nodes = DiscoveryNodes.readFrom(in, localNode);
            builder.startObject("blocks");
        return version();
    public static final ClusterState EMPTY_STATE = builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();
        sb.append(blocks());
        }
        default boolean isPrivate() {
            if (UNKNOWN_UUID.equals(uuid)) {
            this.uuid = state.stateUUID();
    /**
    public DiscoveryNodes getNodes() {
                    for (ClusterBlock block : entry.getValue()) {
            this.uuid = UNKNOWN_UUID;
    public static Builder builder(ClusterState state) {
        out.writeString(stateUUID);
    }
import org.opensearch.cluster.routing.ShardRouting;
    }
    /**
        return routingNodes;
        if (customs.isEmpty() == false) {
        }
                .append("], av[")
            this.version = version;
    }
                uuid = UUIDs.randomBase64UUID();
         * An optional feature that is required for the client to have.
import org.opensearch.cluster.coordination.CoordinationMetadata;
    public long version() {
import java.util.Map;
    }
            fromUuid = before.stateUUID;
            return new ClusterState(
            }
     * @opensearch.api
            builder.endObject();
        private Metadata metadata = Metadata.EMPTY_METADATA;
                .append('\'')
    private final String stateUUID;
        private final String toUuid;
    }
        if (metrics.contains(Metric.ROUTING_TABLE)) {
        int minimumClusterManagerNodesOnPublishingClusterManager,
    @Override
                sb.append(TAB).append(type).append(": ").append(custom);
            blocks = after.blocks.diff(before.blocks);
            for (ShardRouting shardRouting : getRoutingNodes().unassigned()) {
    public Metadata metadata() {
    }
                for (final Map.Entry<String, Set<ClusterBlock>> entry : blocks().indices().entrySet()) {
        sb.append(TAB).append(TAB).append("voting tombstones: ").append(coordinationMetadata().getVotingConfigExclusions()).append("\n");
    /**
            sb.append("metadata customs:\n");
        routingNodes = new RoutingNodes(this);
     *
        StringBuilder sb = new StringBuilder();
            this.metadata = state.metadata();
            builder.startObject("routing_nodes");
 * license agreements. See the NOTICE file distributed with
                sb.append("p_term [").append(indexMetadata.primaryTerm(shard)).append("], ");
        return this.nodes;
 * not use this file except in compliance with the License.
            for (int shard = 0; shard < indexMetadata.getNumberOfShards(); shard++) {
        out.writeVInt(minimumClusterManagerNodesOnPublishingClusterManager);
        public ClusterState apply(ClusterState state) {
            return this;
        private final Diff<RoutingTable> routingTable;
        BLOCKS("blocks"),
            toVersion = in.readLong();
        if (metrics.contains(Metric.METADATA)) {
        return this.customs;
import org.opensearch.core.common.bytes.BytesReference;
    private final boolean wasReadFromDiff;
                builder.startArray(routingNode.nodeId() == null ? "null" : routingNode.nodeId());
        }
 * identifies this version of the state. This uuid is verified by the {@link ClusterStateDiff#apply} method to
        return this.blocks;
            return this;
            toUuid = after.stateUUID;
        // Value of the field is identical with the above, and aims to replace the above field.
            customs.put(type, Objects.requireNonNull(custom, type));
     * Builder for cluster state.
                routingTable,
     * a cluster state supersedes another state if they are from the same cluster-manager and the version of this state is higher than that of the
                customs,
        }
            builder.endObject();
 * differences instead of the entire state on each change. The publishing mechanism should only send differences
            this.version = state.version();
            builder.startObject("indices");
        if (metrics.contains(Metric.CLUSTER_MANAGER_NODE)) {
        sb.append("cluster uuid: ")
    }
        final Map<String, Custom> customs,
                    }
        // When following a Zen1 cluster-manager, the cluster state version is not guaranteed to increase,
    ) {
            builder.startObject("routing_table");
    }
        sb.append("meta data version: ").append(metadata.version()).append("\n");
            builder.startObject("nodes");
        for (final Custom custom : customs.values()) {
            state.routingTable(),
            customs.writeTo(out);
            clusterName = after.clusterName;
            this.minimumClusterManagerNodesOnPublishingClusterManager = minimumClusterManagerNodesOnPublishingClusterManager;
                    if (!ignoreUnknown) {
     *
        for (final Custom custom : customs.values()) {
                .append('\'')
            false
            .append(coordinationMetadata().getLastAcceptedConfiguration())
            }
                }
        this.blocks = blocks;
    }
     *
         * Returns <code>true</code> iff this {@link Custom} is private to the cluster and should never be send to a client.
        }
            && this.nodes().getClusterManagerNodeId().equals(other.nodes().getClusterManagerNodeId())
        final String TAB = "   ";
 * {@link Discovery#publish} method publishes a new version of the cluster state to all other nodes in the
        long version,
    /**
        return metadata.coordinationMetadata();
            DiscoveryNodes part = nodes.apply(null);
        @Override
import org.opensearch.core.common.io.stream.VersionedNamedWriteable;
        sb.append(TAB)
            return this;
        if (metrics.contains(Metric.NODES)) {
            for (String metric : metrics) {
                }
            this.version = version + 1;
            builder.startArray("unassigned");
        Builder builder = new Builder(clusterName);
 * Unless required by applicable law or agreed to in writing,
    public Diff<ClusterState> diff(ClusterState previousState) {
        /**
        }
            sb.append(TAB).append(indexMetadata.getIndex());
        private final Diff<Map<String, Custom>> customs;
         */
 * the type of discovery.
            sb.append(": v[")
                return state;
         */
        public Builder(ClusterName clusterName) {
            }
        // always provide the cluster_uuid as part of the top-level response (also part of the metadata response)
        }
            return nodes;
        private final ClusterName clusterName;
        return new ClusterStateDiff(in, localNode);
        builder.metadata = Metadata.readFrom(in);
                builder.startObject("global");
            );
    public long getVersion() {
import org.opensearch.cluster.metadata.IndexMetadata;
                    builder.startObject(entry.getKey());
import java.util.Spliterators;
                }
import org.opensearch.core.common.io.stream.StreamInput;
     * An interface that implementors use when a class requires a client to maybe have a feature.
        this.metadata = metadata;
                if ("_all".equals(metric)) {
 * correct version of the cluster state, each cluster state version update generates {@link #stateUUID} that uniquely
    public Map<String, Custom> getCustoms() {
            state.metadata(),
        public Builder blocks(ClusterBlocks.Builder blocksBuilder) {
 *
        Metric(String value) {
    }
    }
         */
         * @param custom the custom to serialize
                    result = EnumSet.allOf(Metric.class);
            metadata.toXContent(builder, params);
 * compatible open source license.
         * Tests whether the custom should be serialized. The criterion is that
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            Builder builder = new Builder(clusterName);
        private final int minimumClusterManagerNodesOnPublishingClusterManager;
        sb.append(TAB)
        public ClusterState build() {
    public ClusterName getClusterName() {
     */
                    builder.endArray();
            if (part != null) {
                .append("]\n");
 * single thread and controlled by the {@link ClusterService}. After every update the
        return this.customs;
import org.opensearch.core.xcontent.ToXContentFragment;
         * @param <T>    the type of the custom
            this.value = value;
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
 * @opensearch.api
            builder.field("master_node", nodes().getClusterManagerNodeId());
            return this;
        }
    public static final String UNKNOWN_UUID = "_na_";
 * You may obtain a copy of the License at
/*
                .append(routingTable)
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
                        shardRouting.toXContent(builder, params);
        private RoutingTable routingTable = RoutingTable.EMPTY_ROUTING_TABLE;
            builder.field("version", version);
 * a full version of the cluster state to the node on which this exception was thrown.
        }
/**
        }
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                if (m == null) {
            }
            builder.endObject();
                .append(fromUuid)
            this.routingTable = routingTable;
            } else {
                .append(clusterName)
        public Builder removeCustom(String type) {
            for (RoutingNode routingNode : getRoutingNodes()) {
    public Metadata getMetadata() {
                builder.startObject(indexRoutingTable.getIndex().getName());
        /**
        nodes.writeToWithAttribute(out);
            if (FeatureAware.shouldSerialize(out, custom)) {
                .append("}")
                .toString();
        CUSTOMS("customs");
 * under the License.
         * @deprecated As of 2.0, because promoting inclusive language, replaced by {@link #CLUSTER_MANAGER_NODE}
    }
        }
                .append(indexMetadata.getVersion())
    }
         * @return true if the custom should be serialized and false otherwise
                sb.append(TAB).append(TAB).append(shard).append(": ");
    }
        }
        }
                out.writeBoolean(true);
            builder.metadata(metadata.apply(state.metadata));
            return this;
import java.util.stream.StreamSupport;
            }
        public Builder fromDiff(boolean fromDiff) {
         *
            out.writeString(fromUuid);
        private final Diff<Metadata> metadata;
                valueToEnum.put(metric.value, metric);
            }
            this.fromDiff = false;
        public static EnumSet<Metric> parseString(String param, boolean ignoreUnknown) {
                builder.endObject();
    public String stateUUID() {
    /**
                fromDiff
                .append(indexMetadata.getSettingsVersion())
     * we are applying diffs to the right previous state.
            if (fromUuid.equals(state.stateUUID) == false) {
        @Deprecated
            blocks = ClusterBlocks.readDiffFrom(in);
 * throws the {@link IncompatibleClusterStateVersionException}, which causes the publishing mechanism to send
        // nodes
    @Override
     */
                    block.toXContent(builder, params);
    private final ClusterBlocks blocks;
 * The cluster state object is immutable with the exception of the {@link RoutingNodes} structure, which is
    public long term() {
            builder.fromDiff(true);
            for (final Map.Entry<String, Custom> cursor : customs.entrySet()) {
        return (T) customs.get(type);
    public ClusterState(long version, String stateUUID, ClusterState state) {
     *
        }
        if (metrics.contains(Metric.ROUTING_NODES)) {
    }
            state.blocks(),
 * GitHub history for details.
        }
            }
 * make sure that the correct diffs are applied. If uuids don’t match, the {@link ClusterStateDiff#apply} method
                .append(", toUuid='")
        @Override
            nodes = after.nodes.diff(before.nodes);
        @Override
import org.opensearch.common.settings.Settings;
                builder.endArray();
        return builder.build();
         * @param data      input bytes
            }
            && this.version() > other.version();
     * This stateUUID is automatically generated for each version of cluster state. It is used to make sure that
     * @opensearch.internal
        return (T) customs.getOrDefault(type, defaultValue);
        }
                builder.startObject("shards");
    }
        METADATA("metadata"),
            customs = DiffableUtils.diff(before.customs, after.customs, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);
         */
                }
        this.nodes = nodes;
     * <p>
            metadata.writeTo(out);
         * That is, we only serialize customs to clients than can understand the custom based on the version of the client.
    @PublicApi(since = "1.0.0")
        }
            return this;
                builder.endObject();
                .append("], sv[")
 */
import java.util.HashMap;
        private final Diff<ClusterBlocks> blocks;
                sb.append("isa_ids ").append(indexMetadata.inSyncAllocationIds(shard)).append("\n");
    }
            for (final Map.Entry<String, Metadata.Custom> cursor : metadata.customs().entrySet()) {
            this.nodes = state.nodes();
        sb.append("from_diff: ").append(wasReadFromDiff).append("\n");
                .append(indexMetadata.getMappingVersion())
        }
                } else {
            }
                uuid,
    /**
        // routing nodes
                builder.endObject();
        }
            fromUuid = in.readString();
        /**
    }
        public Builder version(long version) {
        return coordinationMetadata().term();
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
            minimumClusterManagerNodesOnPublishingClusterManager = in.readVInt();
    private final ClusterName clusterName;
                final Custom custom = cursor.getValue();
import java.util.EnumSet;
        }
            builder.minimumClusterManagerNodesOnPublishingClusterManager(minimumClusterManagerNodesOnPublishingClusterManager);
    private final RoutingTable routingTable;
     * In essence that means that all the changes from the other cluster state are also reflected by the current one
         */
     * Returns a built (on demand) routing nodes view of the routing table.
        default Optional<String> getRequiredFeature() {
 * this work for additional information regarding copyright
        }
import org.opensearch.common.UUIDs;
    }
        out.writeLong(version);
import org.opensearch.cluster.node.DiscoveryNodes;
                .append(", clusterName=")
        this.clusterName = clusterName;
import static org.opensearch.cluster.coordination.Coordinator.ZEN1_BWC_TERM;
    // built on demand
        ClusterStateDiff(StreamInput in, DiscoveryNode localNode) throws IOException {
            version,
        public Builder routingTable(RoutingTable routingTable) {
            metadata = after.metadata.diff(before.metadata);
    }
        public void writeTo(StreamOutput out) throws IOException {
 */
    public void writeTo(StreamOutput out) throws IOException {
    public interface Custom extends NamedDiffable<Custom>, ToXContentFragment, FeatureAware {
        public Builder nodes(DiscoveryNodes.Builder nodesBuilder) {
            return routingNodes;
        private final Diff<DiscoveryNodes> nodes;
import java.util.Objects;
