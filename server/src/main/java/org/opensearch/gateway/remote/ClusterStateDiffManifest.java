    private static final String DELETES_FIELD = "deletes";
    public boolean equals(Object o) {
                            case DELETES_FIELD:
    }
            } else {
 */
        return templatesMetadataUpdated;
            builder.endArray();
            builder.field(DIFF_FIELD, indicesRoutingDiffPath);
        XContentParser.Token token;
        boolean transientSettingsMetadataUpdate,
            return new ClusterStateDiffManifest(
                        currentFieldName = parser.currentName();
    }
    private final boolean settingsMetadataUpdated;
    public ClusterStateDiffManifest(StreamInput in) throws IOException {
        out.writeStringCollection(customMetadataDeleted);
    }
            return this;
        public Builder coordinationMetadataUpdated(boolean coordinationMetadataUpdated) {
            && hashesOfConsistentSettingsUpdated == that.hashesOfConsistentSettingsUpdated
            && Objects.equals(indicesRoutingUpdated, that.indicesRoutingUpdated)
            }
    }
            }
            builder.endArray();
            settingsMetadataUpdated,
        customMetadataDeleted = customDiff.getDeletes();
        return transientSettingsMetadataUpdated;
            builder.field(TRANSIENT_SETTINGS_METADATA_UPDATED_FIELD, transientSettingsMetadataUpdated);
                        break;
        if (!indicesRoutingDeleted.isEmpty()) {
                        if (token.isValue()) {
        }
    @Override
                                    token = parser.nextToken();
                                case HASHES_OF_CONSISTENT_SETTINGS_UPDATED_FIELD:
    public List<String> getIndicesRoutingUpdated() {
import org.opensearch.cluster.ClusterState;
        }
            builder.field(COORDINATION_METADATA_UPDATED_FIELD, coordinationMetadataUpdated);
    ) {
                            throw new XContentParseException("Unexpected token [" + token + "]");
            clusterStateCustomDeleted = Collections.emptyList();
                discoveryNodesUpdated,
        }
            this.indicesDeleted = indicesDeleted;
            && Objects.equals(fromStateUUID, that.fromStateUUID)
                            default:
        return hashesOfConsistentSettingsUpdated;
            && Objects.equals(customMetadataUpdated, that.customMetadataUpdated)
            getStringKeySerializer()
            templatesMetadataUpdated,
            && discoveryNodesUpdated == that.discoveryNodesUpdated
                    }
                                }
        private List<String> indicesUpdated;
                        }
                                break;
            this.discoveryNodesUpdated = discoveryNodesUpdated;
    public static class Builder {
        fromStateUUID = previousState.stateUUID();
            this.indicesRoutingUpdated = indicesRoutingUpdated;
                indicesUpdated,
    public List<String> getClusterStateCustomUpdated() {
        String indicesRoutingDiffPath,
                        break;
        builder.startArray(DELETES_FIELD);
        List<String> indicesDeleted,
    public List<String> getIndicesDeleted() {
        this.fromStateUUID = in.readString();
        discoveryNodesUpdated = state.nodes().delta(previousState.nodes()).hasChanges();
        clusterStateCustomUpdated = new ArrayList<>(clusterStateCustomDiff.getDiffs().keySet());
            }
 * this file be licensed under the Apache-2.0 license or a
                routingTableDiff.provideDiff().getUpserts().forEach((k, v) -> indicesRoutingUpdated.add(k));
            customMetadataUpdated = Collections.emptyList();
            .hashesOfConsistentSettings()
                                    builder.settingsMetadataUpdated(parser.booleanValue());
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff,
    public ClusterStateDiffManifest(
        out.writeStringCollection(clusterStateCustomDeleted);
    public int hashCode() {
            );
            && Objects.equals(clusterStateCustomUpdated, that.clusterStateCustomUpdated)
        public Builder indicesRoutingDiffPath(String indicesRoutingDiffPath) {
            builder.value(custom);
        private boolean templatesMetadataUpdated;
            this.customMetadataDeleted = customMetadataDeleted;
            indicesRoutingDeleted,
                    case CLUSTER_BLOCKS_UPDATED_FIELD:
            && templatesMetadataUpdated == that.templatesMetadataUpdated
        settingsMetadataUpdated = !Metadata.isSettingsMetadataEqual(state.metadata(), previousState.metadata());
            customMetadataUpdated,
import java.io.IOException;
     *
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.xcontent.XContentParseException;
    public List<String> getCustomMetadataDeleted() {
                            } else if (currentFieldName.equals(METADATA_CUSTOM_DIFF_FIELD)) {
import org.opensearch.cluster.metadata.IndexMetadata;
        return indicesRoutingDeleted;
    @Override
import org.opensearch.core.common.io.stream.Writeable;
    }
        public Builder customMetadataUpdated(List<String> customMetadataUpdated) {
            builder.endArray();
    }
    private final String toStateUUID;
    }
            return this;
                            if (currentFieldName.equals(INDICES_DIFF_FIELD)) {
/*
        String fromStateUUID,
        this.clusterBlocksUpdated = clusterBlocksUpdated;
                customMetadataDeleted,
                                        case UPSERTS_FIELD:
            this.hashesOfConsistentSettingsUpdated = hashesOfConsistentSettingsUpdated;
    public void writeTo(StreamOutput out) throws IOException {
            builder.field(SETTINGS_METADATA_UPDATED_FIELD, settingsMetadataUpdated);
        this.customMetadataDeleted = Collections.unmodifiableList(customMetadataDeleted);
                    }
            builder.startArray(UPSERTS_FIELD);
    }
                                    builder.indicesRoutingDeleted(convertListToString(parser.listOrderedMap()));
                                        default:
    private static final String ROUTING_TABLE_DIFF = "routing_table_diff";
        templatesMetadataUpdated = !Metadata.isTemplatesMetadataEqual(state.metadata(), previousState.metadata());
        return convertedList;
                } else if (currentFieldName.equals(ROUTING_TABLE_DIFF)) {
            for (String index : indicesDeleted) {
        this.customMetadataUpdated = Collections.unmodifiableList(customMetadataUpdated);
        out.writeString(toStateUUID);
        return coordinationMetadataUpdated == that.coordinationMetadataUpdated
            .equals(previousState.metadata().hashesOfConsistentSettings());
        builder.endArray();
        hashesOfConsistentSettingsUpdated = !state.metadata()
            this.clusterBlocksUpdated = clusterBlocksUpdated;
        public Builder() {
        this.fromStateUUID = fromStateUUID;
    private final boolean coordinationMetadataUpdated;
                        } else {
            && clusterBlocksUpdated == that.clusterBlocksUpdated
        this.discoveryNodesUpdated = discoveryNodesUpdated;
                                    throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
            for (String custom : customMetadataDeleted) {
            this.transientSettingsMetadataUpdated = settingsMetadataUpdated;
        private String fromStateUUID;
                        currentFieldName = parser.currentName();
    private final boolean discoveryNodesUpdated;
        return new Builder();
        this.coordinationMetadataUpdated = coordinationMetadataUpdated;
        return clusterBlocksUpdated;
    /**
                                case TRANSIENT_SETTINGS_METADATA_UPDATED_FIELD:
                fromStateUUID,
        String toStateUUID,
        return indicesRoutingUpdated;
        public Builder discoveryNodesUpdated(boolean discoveryNodesUpdated) {
    public String getFromStateUUID() {
        out.writeStringCollection(clusterStateCustomUpdated);
        return settingsMetadataUpdated;
            for (String index : indicesRoutingDeleted) {
    public static ClusterStateDiffManifest fromXContent(XContentParser parser, long codec_version) throws IOException {
        return customMetadataUpdated;
                        currentFieldName = parser.currentName();
    public boolean isTransientSettingsMetadataUpdated() {
                                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        this.indicesUpdated = in.readStringList();
                indicesRoutingUpdated,
                builder.value(index);
import java.util.Objects;
        private String indicesRoutingDiff;
        this.toStateUUID = in.readString();
                                            builder.indicesUpdated(convertListToString(parser.listOrderedMap()));
    public void setIndicesRoutingDiffPath(String indicesRoutingDiffPath) {
                } else if (currentFieldName.equals(CLUSTER_STATE_CUSTOM_DIFF_FIELD)) {
            return this;
            indicesUpdated,
                        builder.discoveryNodesUpdated(parser.booleanValue());
            getStringKeySerializer(),
            this.indicesRoutingDiff = indicesRoutingDiffPath;
            return this;
        out.writeBoolean(coordinationMetadataUpdated);
                                            break;
import org.opensearch.core.xcontent.ToXContentFragment;
                                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                            case DELETES_FIELD:
            clusterStateCustomUpdated = Collections.emptyList();
    }
                    case TO_STATE_UUID_FIELD:
                                case TEMPLATES_METADATA_UPDATED_FIELD:
                clusterStateCustomDeleted
        }
                            } else {
            indicesUpdated = Collections.emptyList();
                builder.value(custom);
        this.indicesRoutingDiffPath = indicesRoutingDiffPath;
        }
    }
        this.indicesDeleted = in.readStringList();
                indicesRoutingDeleted,
    }
        out.writeBoolean(templatesMetadataUpdated);
    public boolean isClusterBlocksUpdated() {
     * Builder for ClusterStateDiffManifest
                                    switch (currentFieldName) {
            return this;
                        parser.nextToken();
            return this;
    private final List<String> indicesUpdated;
                                }
            this.toStateUUID = toStateUUID;
            toStateUUID,
            state.metadata().customs(),
        this.indicesRoutingDiffPath = indicesRoutingDiffPath;
                                throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
        for (String custom : clusterStateCustomUpdated) {
        }
        ClusterState previousState,
                coordinationMetadataUpdated,
        return clusterStateCustomDeleted;
        int codecVersion,
    private final boolean hashesOfConsistentSettingsUpdated;
    private static final String CLUSTER_BLOCKS_UPDATED_FIELD = "cluster_blocks_diff";
        out.writeBoolean(discoveryNodesUpdated);
        List<String> convertedList = new ArrayList<>();
    }
                                    currentFieldName = parser.currentName();
        this.discoveryNodesUpdated = in.readBoolean();
                        builder.clusterBlocksUpdated(parser.booleanValue());
import org.opensearch.cluster.routing.StringKeyDiffProvider;
                                        case UPSERTS_FIELD:
        ClusterStateDiffManifest that = (ClusterStateDiffManifest) o;
        out.writeStringCollection(indicesRoutingDeleted);
                indicesRoutingDiff,
            return this;
            parser.nextToken();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.DiffableUtils;
                                }
                    while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
                currentFieldName = parser.currentName();
        return indicesDeleted;
public class ClusterStateDiffManifest implements ToXContentFragment, Writeable {
        toStateUUID = state.stateUUID();
                indicesRoutingDeleted.addAll(routingTableDiff.provideDiff().getDeletes());
    private final boolean clusterBlocksUpdated;
        builder.startArray(UPSERTS_FIELD);
            for (String index : indicesUpdated) {
import java.util.Collections;
                                            throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
            this.customMetadataUpdated = customMetadataUpdated;
     * @opensearch.internal
import org.opensearch.core.xcontent.XContentParser;
                            case UPSERTS_FIELD:
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private final boolean transientSettingsMetadataUpdated;
        this.indicesRoutingUpdated = Collections.unmodifiableList(indicesRoutingUpdated);
            }
            coordinationMetadataUpdated,
            if (routingTableDiff != null && routingTableDiff.provideDiff() != null) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
                                case SETTINGS_METADATA_UPDATED_FIELD:
        return fromStateUUID;
        }
    }
        );
                                            builder.customMetadataDeleted(convertListToString(parser.listOrderedMap()));
import org.opensearch.cluster.metadata.Metadata;
     */
            }
            builder.value(custom);
        builder.endObject();
                transientSettingsMetadataUpdated,
        customMetadataUpdated.addAll(customDiff.getUpserts().keySet());
            builder.field(TEMPLATES_METADATA_UPDATED_FIELD, templatesMetadataUpdated);
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
            return this;
        builder.endObject();
            this.indicesUpdated = indicesUpdated;
        clusterStateCustomUpdated.addAll(clusterStateCustomDiff.getUpserts().keySet());
        this.hashesOfConsistentSettingsUpdated = in.readBoolean();
        out.writeString(fromStateUUID);
        }
        customMetadataUpdated = new ArrayList<>(customDiff.getDiffs().keySet());
                        builder.fromStateUUID(parser.text());
        public Builder clusterBlocksUpdated(boolean clusterBlocksUpdated) {
        public Builder fromStateUUID(String fromStateUUID) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        out.writeBoolean(hashesOfConsistentSettingsUpdated);
        builder.startObject(METADATA_DIFF_FIELD);
                        parser.nextToken();
    }
            && Objects.equals(customMetadataDeleted, that.customMetadataDeleted)
    public List<String> getIndicesUpdated() {
        boolean templatesMetadataUpdated,
        DiffableUtils.MapDiff<String, IndexMetadata, Map<String, IndexMetadata>> indicesDiff = DiffableUtils.diff(
            }
    }
    private final List<String> indicesDeleted;
            builder.startArray(UPSERTS_FIELD);
import static org.opensearch.cluster.DiffableUtils.NonDiffableValueSerializer.getAbstractInstance;
        public Builder hashesOfConsistentSettingsUpdated(boolean hashesOfConsistentSettingsUpdated) {
            builder.endArray();
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
        public Builder settingsMetadataUpdated(boolean settingsMetadataUpdated) {
    private final List<String> indicesRoutingDeleted;
        builder.field(DISCOVERY_NODES_UPDATED_FIELD, discoveryNodesUpdated);
            this.fromStateUUID = fromStateUUID;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            && transientSettingsMetadataUpdated == that.transientSettingsMetadataUpdated
import static org.opensearch.cluster.DiffableUtils.getStringKeySerializer;
                                    token = parser.nextToken();
            clusterStateCustomDeleted,
        }
                                    break;
            builder.endArray();
                                    break;
                    throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
    }
                templatesMetadataUpdated,
                                            break;
            this.templatesMetadataUpdated = templatesMetadataUpdated;
        this.indicesRoutingUpdated = in.readStringList();
        return toStateUUID;
                                    break;
        private List<String> indicesRoutingDeleted;
                                break;
        public Builder indicesRoutingDeleted(List<String> indicesRoutingDeleted) {
            indicesDeleted = Collections.emptyList();
                        }
    }
                } else {
    }
        }
                                        case DELETES_FIELD:
            builder.endObject();
                        } else if (token == XContentParser.Token.START_OBJECT) {
            this.coordinationMetadataUpdated = coordinationMetadataUpdated;
import java.util.ArrayList;
        return indicesUpdated;
        }
        {
            clusterBlocksUpdated,
    @Override
        List<String> clusterStateCustomUpdated,
                                            builder.indicesDeleted(convertListToString(parser.listOrderedMap()));
            builder.startArray(DELETES_FIELD);
                            }
/**
            return this;
        this.settingsMetadataUpdated = in.readBoolean();
        }
                            switch (currentFieldName) {
    private final List<String> customMetadataUpdated;
    }
                                    }
            }
import java.util.List;
        for (Object o : list) {
                                throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
            previousState.metadata().indices(),
    public List<String> getCustomMetadataUpdated() {
        public Builder indicesRoutingUpdated(List<String> indicesRoutingUpdated) {
    private static final String TO_STATE_UUID_FIELD = "to_state_uuid";
        }
        if (parser.currentToken() == null) { // fresh parser? move to next token
        ClusterState state,
        boolean discoveryNodesUpdated,
        private boolean coordinationMetadataUpdated;
        }
 * @opensearch.internal
                builder.value(custom);
        this.indicesRoutingDeleted = in.readStringList();
            discoveryNodesUpdated,
                            case UPSERTS_FIELD:
                throw new XContentParseException("Unexpected token [" + token + "]");
        builder.field(CLUSTER_BLOCKS_UPDATED_FIELD, clusterBlocksUpdated);
                            case DIFF_FIELD:
        }
        this.hashesOfConsistentSettingsUpdated = hashesOfConsistentSettingsUpdated;
        List<String> customMetadataDeleted,
        return discoveryNodesUpdated;
        this.clusterStateCustomUpdated = in.readStringList();
        public Builder transientSettingsMetadataUpdate(boolean settingsMetadataUpdated) {
    private static final String UPSERTS_FIELD = "upserts";
    private static List<String> convertListToString(List<Object> list) {
 */
                                if (codec_version == CODEC_V2 || codec_version == CODEC_V3) {
        out.writeStringCollection(indicesDeleted);
                                break;
                                            throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
        String currentFieldName = parser.currentName();
            getStringKeySerializer(),
            return this;
        clusterBlocksUpdated = !state.blocks().equals(previousState.blocks());
            state.customs(),
        coordinationMetadataUpdated = !Metadata.isCoordinationMetadataEqual(state.metadata(), previousState.metadata());
        public Builder templatesMetadataUpdated(boolean templatesMetadataUpdated) {
import java.util.Map;
            return this;
 * The OpenSearch Contributors require contributions made to
            builder.startArray(DELETES_FIELD);
        }
            parser.nextToken();
        boolean settingsMetadataUpdated,
    public boolean isCoordinationMetadataUpdated() {
        return clusterStateCustomUpdated;
        DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> customDiff = DiffableUtils.diff(
        this.indicesRoutingDiffPath = in.readOptionalString();
        List<String> clusterStateCustomDeleted
                    case DISCOVERY_NODES_UPDATED_FIELD:
            } else if (token.isValue()) {
                                default:
                        break;
    private final boolean templatesMetadataUpdated;
        private List<String> customMetadataUpdated;
                                    break;
                builder.value(index);
    private static final String HASHES_OF_CONSISTENT_SETTINGS_UPDATED_FIELD = "hashes_of_consistent_settings_diff";
        private List<String> clusterStateCustomDeleted;
            && Objects.equals(clusterStateCustomDeleted, that.clusterStateCustomDeleted)
            builder.field(HASHES_OF_CONSISTENT_SETTINGS_UPDATED_FIELD, hashesOfConsistentSettingsUpdated);
    public static Builder builder() {
        }
                                case COORDINATION_METADATA_UPDATED_FIELD:
        private boolean hashesOfConsistentSettingsUpdated;
import org.opensearch.core.xcontent.XContentBuilder;
        }
                    while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        out.writeStringCollection(indicesRoutingUpdated);
    private static final String DISCOVERY_NODES_UPDATED_FIELD = "discovery_nodes_diff";
            builder.startArray(DELETES_FIELD);
    private static final String CLUSTER_STATE_CUSTOM_DIFF_FIELD = "cluster_state_custom_diff";
    private final List<String> clusterStateCustomUpdated;
            return this;
            && Objects.equals(toStateUUID, that.toStateUUID)
    public List<String> getClusterStateCustomDeleted() {
        builder.field(TO_STATE_UUID_FIELD, toStateUUID);
        }
}
                        token = parser.nextToken();
                                    builder.coordinationMetadataUpdated(parser.booleanValue());
                    }
    private final List<String> customMetadataDeleted;
    public List<String> getIndicesRoutingDeleted() {
            builder.endArray();
                clusterStateCustomUpdated,
            && Objects.equals(indicesRoutingDeleted, that.indicesRoutingDeleted)
                indicesDeleted,
    }
                builder.value(index);
        List<String> customMetadataUpdated,
        out.writeOptionalString(indicesRoutingDiffPath);
    }
        }
        this.indicesRoutingDeleted = Collections.unmodifiableList(indicesRoutingDeleted);
    public boolean isSettingsMetadataUpdated() {
                hashesOfConsistentSettingsUpdated,
        public Builder indicesUpdated(List<String> indicesUpdated) {
            return this;
    public String toString() {
                                    builder.transientSettingsMetadataUpdate(parser.booleanValue());
                                    builder.indicesRoutingUpdated(convertListToString(parser.listOrderedMap()));
            state.metadata().indices(),
            && Objects.equals(indicesUpdated, that.indicesUpdated)
        DiffableUtils.MapDiff<String, ClusterState.Custom, Map<String, ClusterState.Custom>> clusterStateCustomDiff = DiffableUtils.diff(
        if (indicesRoutingDiffPath != null) {
    }
    private static final String DIFF_FIELD = "diff";
    private final String fromStateUUID;
                        builder.toStateUUID(parser.text());
        );
            builder.endObject();
    }
                                            break;
 *
                                            builder.customMetadataUpdated(convertListToString(parser.listOrderedMap()));
                                    builder.indicesRoutingDiffPath(parser.textOrNull());
        out.writeStringCollection(customMetadataUpdated);
        this.indicesRoutingDiffPath = indicesRoutingDiffPath;
                settingsMetadataUpdated,
        private List<String> customMetadataDeleted;
            return this;
        return coordinationMetadataUpdated;
                        switch (currentFieldName) {
        return Objects.hash(
    ) {
        if (codecVersion == CODEC_V2 || codecVersion == CODEC_V3) {
        this.templatesMetadataUpdated = templatesMetadataUpdated;
        for (String custom : clusterStateCustomDeleted) {
    private final List<String> clusterStateCustomDeleted;
        indicesDeleted = indicesDiff.getDeletes();
        this.customMetadataDeleted = in.readStringList();
        builder.endArray();
            transientSettingsMetadataUpdated,
            indicesRoutingUpdated = Collections.emptyList();
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            return this;
    }
                                    currentFieldName = parser.currentName();
        if (!indicesRoutingUpdated.isEmpty()) {
                                        case DELETES_FIELD:
    private final List<String> indicesRoutingUpdated;
        boolean coordinationMetadataUpdated,
        }
    }
        boolean clusterBlocksUpdated,
        }
    public String getIndicesRoutingDiffPath() {
        this.coordinationMetadataUpdated = in.readBoolean();
                                    break;
            hashesOfConsistentSettingsUpdated,
                                throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
            builder.startArray(UPSERTS_FIELD);
            convertedList.add(o.toString());
            for (String index : indicesRoutingUpdated) {
                                if (codec_version >= CODEC_V3) {
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
            indicesDeleted,
        this.clusterBlocksUpdated = in.readBoolean();
    private static final String TRANSIENT_SETTINGS_METADATA_UPDATED_FIELD = "transient_settings_metadata_diff";
        );
                clusterBlocksUpdated,
            && Objects.equals(indicesDeleted, that.indicesDeleted)
            getAbstractInstance()
    }
        private boolean transientSettingsMetadataUpdated;
        clusterStateCustomDeleted = clusterStateCustomDiff.getDeletes();
                            default:
        this.transientSettingsMetadataUpdated = in.readBoolean();
                        break;
    }
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
        this.settingsMetadataUpdated = settingsMetadataUpdated;
            this.settingsMetadataUpdated = settingsMetadataUpdated;
            customMetadataDeleted = Collections.emptyList();
    }
    }
        List<String> indicesRoutingDeleted,
        Builder builder = new Builder();
        }
        }
        if (this == o) return true;
    }
            customMetadataDeleted,
        return customMetadataDeleted;
        }
        out.writeBoolean(clusterBlocksUpdated);
                switch (currentFieldName) {
            indicesRoutingUpdated,
            clusterStateCustomUpdated,
        public ClusterStateDiffManifest build() {
        boolean hashesOfConsistentSettingsUpdated,
            indicesRoutingDeleted = Collections.emptyList();
            getAbstractInstance()
                                }
package org.opensearch.gateway.remote;
                                break;
        public Builder toStateUUID(String toStateUUID) {
    private static final String TEMPLATES_METADATA_UPDATED_FIELD = "templates_metadata_diff";
    private static final String FROM_STATE_UUID_FIELD = "from_state_uuid";
    public String getToStateUUID() {
    }
                                    builder.templatesMetadataUpdated(parser.booleanValue());
                                builder.clusterStateCustomUpdated(convertListToString(parser.listOrderedMap()));
                            }
        List<String> indicesRoutingUpdated,
            return this;
 * Manifest of diff between two cluster states
        private boolean settingsMetadataUpdated;
        this.indicesDeleted = Collections.unmodifiableList(indicesDeleted);
            && settingsMetadataUpdated == that.settingsMetadataUpdated
        private boolean discoveryNodesUpdated;
                                if (codec_version == CODEC_V2 || codec_version == CODEC_V3) {
import org.opensearch.cluster.routing.IndexRoutingTable;
        builder.endObject();
    private static final String METADATA_CUSTOM_DIFF_FIELD = "metadata_custom_diff";
        List<String> indicesUpdated,
        return indicesRoutingDiffPath;
        public Builder clusterStateCustomUpdated(List<String> clusterStateCustomUpdated) {
            if (token == XContentParser.Token.FIELD_NAME) {
    private static final String COORDINATION_METADATA_UPDATED_FIELD = "coordination_metadata_diff";
 *
                                builder.clusterStateCustomDeleted(convertListToString(parser.listOrderedMap()));
        private List<String> clusterStateCustomUpdated;
        this.customMetadataUpdated = in.readStringList();
        this.clusterStateCustomUpdated = Collections.unmodifiableList(clusterStateCustomUpdated);
            }
            builder.startObject(METADATA_CUSTOM_DIFF_FIELD);
    public ClusterStateDiffManifest(
        }
        String indicesRoutingDiffPath
                builder.value(index);
        this.toStateUUID = toStateUUID;
            builder.startObject(INDICES_DIFF_FIELD);
                    case FROM_STATE_UUID_FIELD:
        transientSettingsMetadataUpdated = !Metadata.isTransientSettingsMetadataEqual(state.metadata(), previousState.metadata());
            previousState.metadata().customs(),
            this.clusterStateCustomUpdated = clusterStateCustomUpdated;
        builder.field(FROM_STATE_UUID_FIELD, fromStateUUID);
            for (String custom : customMetadataUpdated) {
            fromStateUUID,
                                }
            return this;
                                    switch (currentFieldName) {
        this.clusterStateCustomDeleted = in.readStringList();
        }
        indicesRoutingDeleted = new ArrayList<>();
                }
        indicesUpdated = new ArrayList<>(indicesDiff.getDiffs().keySet());
        indicesUpdated.addAll(indicesDiff.getUpserts().keySet());
                customMetadataUpdated,
    private static final String INDICES_DIFF_FIELD = "indices_diff";
        }
        public Builder clusterStateCustomDeleted(List<String> clusterStateCustomDeleted) {
            } else if (token == XContentParser.Token.START_OBJECT) {
        private String toStateUUID;
                    default:
import org.opensearch.core.common.Strings;
        }
    private String indicesRoutingDiffPath;
                                    builder.hashesOfConsistentSettingsUpdated(parser.booleanValue());
    public boolean isHashesOfConsistentSettingsUpdated() {
    @Override
        out.writeBoolean(transientSettingsMetadataUpdated);
        );
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
                                break;
        public Builder customMetadataDeleted(List<String> customMetadataDeleted) {
            this.clusterStateCustomDeleted = clusterStateCustomDeleted;
                                            break;
        return builder.build();
    @Override
                        }
    public boolean isDiscoveryNodesUpdated() {
    public boolean isTemplatesMetadataUpdated() {
        builder.startObject(CLUSTER_STATE_CUSTOM_DIFF_FIELD);
    private static final String SETTINGS_METADATA_UPDATED_FIELD = "settings_metadata_diff";
        out.writeBoolean(settingsMetadataUpdated);
                }
        private boolean clusterBlocksUpdated;
                                    }
        builder.startObject(ROUTING_TABLE_DIFF);
        return builder;
                        switch (currentFieldName) {
        private List<String> indicesDeleted;
    private static final String METADATA_DIFF_FIELD = "metadata_diff";
        this.indicesUpdated = Collections.unmodifiableList(indicesUpdated);
        this.templatesMetadataUpdated = in.readBoolean();
            && Objects.equals(indicesRoutingDiffPath, that.indicesRoutingDiffPath);
            indicesRoutingDiffPath
        public Builder indicesDeleted(List<String> indicesDeleted) {
                if (currentFieldName.equals(METADATA_DIFF_FIELD)) {
            return this;
                                        default:
        indicesRoutingUpdated = new ArrayList<>();
                        throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
        this.transientSettingsMetadataUpdated = transientSettingsMetadataUpdate;
        out.writeStringCollection(indicesUpdated);
        private List<String> indicesRoutingUpdated;
            previousState.customs(),
            this.indicesRoutingDeleted = indicesRoutingDeleted;
        this.clusterStateCustomDeleted = Collections.unmodifiableList(clusterStateCustomDeleted);
        }
        if (o == null || getClass() != o.getClass()) return false;
                toStateUUID,
