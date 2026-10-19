                                if (codec_version == CODEC_V2 || codec_version == CODEC_V3) {  
                        currentFieldName = parser.currentName();
        private boolean coordinationMetadataUpdated;
                                            builder.indicesUpdated(convertListToString(parser.listOrderedMap()));
                                break;
            builder.value(custom);  
        }  
        private boolean settingsMetadataUpdated;
        builder.endObject();  
    private static final String INDICES_DIFF_FIELD = "indices_diff";
        private String indicesRoutingDiff;
        transientSettingsMetadataUpdated = !Metadata.isTransientSettingsMetadataEqual(state.metadata(), previousState.metadata());  
                indicesDeleted,
                indicesRoutingDeleted.addAll(routingTableDiff.provideDiff().getDeletes());  
                    case FROM_STATE_UUID_FIELD:
    private static final String FROM_STATE_UUID_FIELD = "from_state_uuid";  
                            default:
                        parser.nextToken();  
                                    currentFieldName = parser.currentName();
                builder.value(index);
        this.indicesDeleted = Collections.unmodifiableList(indicesDeleted);
            builder.field(DIFF_FIELD, indicesRoutingDiffPath);
        }
        return hashesOfConsistentSettingsUpdated;
        for (Object o : list) {
            this.clusterBlocksUpdated = clusterBlocksUpdated;
            } else if (token.isValue()) {  
        return clusterStateCustomDeleted;
    public boolean isTemplatesMetadataUpdated() {  
        }
                            case DELETES_FIELD:
        out.writeString(toStateUUID);
        public ClusterStateDiffManifest build() {
import org.opensearch.cluster.DiffableUtils;
    }  
    private static final String ROUTING_TABLE_DIFF = "routing_table_diff";  
        boolean transientSettingsMetadataUpdate,
            coordinationMetadataUpdated,
        List<String> customMetadataUpdated,  
        return clusterStateCustomUpdated;  
        boolean coordinationMetadataUpdated,
                    while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        parser.nextToken();  
            state.metadata().customs(),
                                break;  
    }  
        return indicesRoutingDeleted;
    private String indicesRoutingDiffPath;
    }  
import org.opensearch.core.xcontent.ToXContentFragment;  
        }
        }  
            if (routingTableDiff != null && routingTableDiff.provideDiff() != null) {
            indicesRoutingDeleted = Collections.emptyList();  
                            throw new XContentParseException("Unexpected token [" + token + "]");  
            builder.endArray();
        List<String> clusterStateCustomUpdated,
        List<String> indicesDeleted,  
    }
        List<String> indicesRoutingUpdated,  
                        builder.clusterBlocksUpdated(parser.booleanValue());  
    }
            hashesOfConsistentSettingsUpdated,
    private final List<String> indicesUpdated;  
            builder.startArray(DELETES_FIELD);
import java.util.Objects;
                indicesRoutingUpdated,
            && Objects.equals(clusterStateCustomDeleted, that.clusterStateCustomDeleted)
            && Objects.equals(toStateUUID, that.toStateUUID)  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        coordinationMetadataUpdated = !Metadata.isCoordinationMetadataEqual(state.metadata(), previousState.metadata());
import org.opensearch.cluster.metadata.Metadata;
            this.templatesMetadataUpdated = templatesMetadataUpdated;
            customMetadataUpdated = Collections.emptyList();
            && Objects.equals(fromStateUUID, that.fromStateUUID)
                                    builder.hashesOfConsistentSettingsUpdated(parser.booleanValue());
                                break;
            for (String index : indicesDeleted) {
        this.indicesRoutingDiffPath = indicesRoutingDiffPath;
            && Objects.equals(indicesRoutingDiffPath, that.indicesRoutingDiffPath);  
    public static Builder builder() {  
    private final boolean discoveryNodesUpdated;
            builder.startArray(DELETES_FIELD);
import org.opensearch.core.xcontent.XContentBuilder;
    public boolean isSettingsMetadataUpdated() {
        }
    }  
                                            throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
    public ClusterStateDiffManifest(
                customMetadataUpdated,
            && Objects.equals(customMetadataDeleted, that.customMetadataDeleted)
            .hashesOfConsistentSettings()
import java.util.Collections;
            indicesUpdated,
            builder.endArray();  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * Manifest of diff between two cluster states
            this.settingsMetadataUpdated = settingsMetadataUpdated;  
        return toStateUUID;  
        public Builder clusterBlocksUpdated(boolean clusterBlocksUpdated) {  
            }
            for (String custom : customMetadataUpdated) {  
                                        case UPSERTS_FIELD:
    public List<String> getIndicesRoutingUpdated() {  
                settingsMetadataUpdated,
                                    switch (currentFieldName) {  
                                    token = parser.nextToken();
        for (String custom : clusterStateCustomUpdated) {  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;  
        if (indicesRoutingDiffPath != null) {  
        this.templatesMetadataUpdated = templatesMetadataUpdated;  
    private static final String CLUSTER_BLOCKS_UPDATED_FIELD = "cluster_blocks_diff";
        builder.field(CLUSTER_BLOCKS_UPDATED_FIELD, clusterBlocksUpdated);
        this.clusterStateCustomUpdated = in.readStringList();
        return coordinationMetadataUpdated == that.coordinationMetadataUpdated
            parser.nextToken();
                indicesUpdated,  
                        } else if (token == XContentParser.Token.START_OBJECT) {
                throw new XContentParseException("Unexpected token [" + token + "]");  
        XContentParser.Token token;
        return indicesDeleted;
            && Objects.equals(clusterStateCustomUpdated, that.clusterStateCustomUpdated)
        builder.field(TO_STATE_UUID_FIELD, toStateUUID);  
        fromStateUUID = previousState.stateUUID();
    private final boolean templatesMetadataUpdated;
            return this;  
import org.opensearch.core.common.io.stream.StreamInput;
            return this;
        String indicesRoutingDiffPath,
    }
        DiffableUtils.MapDiff<String, ClusterState.Custom, Map<String, ClusterState.Custom>> clusterStateCustomDiff = DiffableUtils.diff(  
    }
        private List<String> indicesRoutingDeleted;  
                                builder.clusterStateCustomDeleted(convertListToString(parser.listOrderedMap()));  
            }
                                    break;  
                                    builder.settingsMetadataUpdated(parser.booleanValue());
        if (o == null || getClass() != o.getClass()) return false;
        }
    private final boolean coordinationMetadataUpdated;
    private static final String TEMPLATES_METADATA_UPDATED_FIELD = "templates_metadata_diff";  
        List<String> customMetadataDeleted,
                        }
                                }
        indicesUpdated.addAll(indicesDiff.getUpserts().keySet());  
 * this file be licensed under the Apache-2.0 license or a
                                            break;  
        this.customMetadataDeleted = Collections.unmodifiableList(customMetadataDeleted);
            builder.field(HASHES_OF_CONSISTENT_SETTINGS_UPDATED_FIELD, hashesOfConsistentSettingsUpdated);
            return this;
    private static final String METADATA_DIFF_FIELD = "metadata_diff";
    }  
        private List<String> indicesRoutingUpdated;
    private final List<String> customMetadataUpdated;
                    case TO_STATE_UUID_FIELD:
        out.writeStringCollection(customMetadataDeleted);  
        this.clusterStateCustomDeleted = Collections.unmodifiableList(clusterStateCustomDeleted);
    private static final String UPSERTS_FIELD = "upserts";
        );  
            settingsMetadataUpdated,  
                builder.value(index);
        indicesRoutingDeleted = new ArrayList<>();
            builder.startObject(METADATA_CUSTOM_DIFF_FIELD);
                                    }  
            getAbstractInstance()
        public Builder indicesDeleted(List<String> indicesDeleted) {
                        break;
                routingTableDiff.provideDiff().getUpserts().forEach((k, v) -> indicesRoutingUpdated.add(k));
        }
                                    break;  
        indicesRoutingUpdated = new ArrayList<>();  
                clusterStateCustomDeleted  
        public Builder fromStateUUID(String fromStateUUID) {
    }
        this.indicesRoutingDiffPath = indicesRoutingDiffPath;  
                        throw new XContentParseException("Unexpected field [" + currentFieldName + "]");  
            customMetadataUpdated,  
                                }
        out.writeString(fromStateUUID);  
    private static List<String> convertListToString(List<Object> list) {
import java.io.IOException;
            return this;
                        builder.toStateUUID(parser.text());  
    ) {
                            case DELETES_FIELD:
        }
                indicesRoutingDeleted,
        private String toStateUUID;  
        }  
        if (codecVersion == CODEC_V2 || codecVersion == CODEC_V3) {  
    public void setIndicesRoutingDiffPath(String indicesRoutingDiffPath) {
        builder.endArray();
            this.discoveryNodesUpdated = discoveryNodesUpdated;  
    }  
    public boolean isClusterBlocksUpdated() {
            }
        return Objects.hash(
        this.coordinationMetadataUpdated = in.readBoolean();  
        this.clusterBlocksUpdated = in.readBoolean();
            this.clusterStateCustomUpdated = clusterStateCustomUpdated;
        this.toStateUUID = toStateUUID;
                                    break;  
        return transientSettingsMetadataUpdated;  
        out.writeStringCollection(indicesDeleted);
                            case UPSERTS_FIELD:
            } else {
        ClusterState previousState,  
    private final boolean clusterBlocksUpdated;
                                case TRANSIENT_SETTINGS_METADATA_UPDATED_FIELD:
        builder.field(FROM_STATE_UUID_FIELD, fromStateUUID);
import org.opensearch.core.common.Strings;
import org.opensearch.cluster.ClusterState;
            builder.field(COORDINATION_METADATA_UPDATED_FIELD, coordinationMetadataUpdated);  
    }
            return this;  
            builder.startArray(UPSERTS_FIELD);
    private final List<String> clusterStateCustomUpdated;
    }
    public static class Builder {
                                throw new XContentParseException("Unexpected field [" + currentFieldName + "]");  
        boolean templatesMetadataUpdated,
import java.util.List;
            builder.value(custom);
                        break;
     */  
            }  
                switch (currentFieldName) {
        builder.startObject(METADATA_DIFF_FIELD);
            customMetadataDeleted,
            this.fromStateUUID = fromStateUUID;  
    public String getFromStateUUID() {
                    }
                        } else {
    public boolean isTransientSettingsMetadataUpdated() {
            return this;
    private final List<String> clusterStateCustomDeleted;
            convertedList.add(o.toString());
/**  
    private static final String TO_STATE_UUID_FIELD = "to_state_uuid";
    private static final String DISCOVERY_NODES_UPDATED_FIELD = "discovery_nodes_diff";
 * SPDX-License-Identifier: Apache-2.0
            previousState.metadata().customs(),
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            this.coordinationMetadataUpdated = coordinationMetadataUpdated;
        out.writeBoolean(templatesMetadataUpdated);
                            }
        List<String> clusterStateCustomDeleted
    public List<String> getIndicesRoutingDeleted() {
                clusterBlocksUpdated,
        discoveryNodesUpdated = state.nodes().delta(previousState.nodes()).hasChanges();
            previousState.metadata().indices(),  
        this.settingsMetadataUpdated = in.readBoolean();
        return builder.build();  
                                }
    private static final String METADATA_CUSTOM_DIFF_FIELD = "metadata_custom_diff";  
    }
            getStringKeySerializer()
            parser.nextToken();
    private final List<String> customMetadataDeleted;  
        this.indicesRoutingDeleted = Collections.unmodifiableList(indicesRoutingDeleted);
        customMetadataUpdated.addAll(customDiff.getUpserts().keySet());
                templatesMetadataUpdated,  
import static org.opensearch.cluster.DiffableUtils.getStringKeySerializer;
        builder.startObject(CLUSTER_STATE_CUSTOM_DIFF_FIELD);
            return this;
                builder.value(custom);  
            indicesRoutingUpdated = Collections.emptyList();
    private static final String HASHES_OF_CONSISTENT_SETTINGS_UPDATED_FIELD = "hashes_of_consistent_settings_diff";
        clusterStateCustomUpdated.addAll(clusterStateCustomDiff.getUpserts().keySet());
    /**
            );
    private final List<String> indicesRoutingUpdated;  
                                if (codec_version >= CODEC_V3) {
        out.writeStringCollection(indicesRoutingDeleted);
                                    }  
        private boolean transientSettingsMetadataUpdated;  
    private final boolean hashesOfConsistentSettingsUpdated;  
import org.opensearch.core.xcontent.XContentParser;  
        settingsMetadataUpdated = !Metadata.isSettingsMetadataEqual(state.metadata(), previousState.metadata());
                    throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
            this.indicesDeleted = indicesDeleted;
        }
    public List<String> getIndicesDeleted() {
/*  
        this.fromStateUUID = in.readString();
                                case COORDINATION_METADATA_UPDATED_FIELD:
        private boolean templatesMetadataUpdated;
            if (token == XContentParser.Token.FIELD_NAME) {
    @Override  
                        break;
        hashesOfConsistentSettingsUpdated = !state.metadata()  
        out.writeStringCollection(clusterStateCustomUpdated);  
        public Builder indicesRoutingUpdated(List<String> indicesRoutingUpdated) {  
        private boolean discoveryNodesUpdated;
        this.clusterStateCustomDeleted = in.readStringList();
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                                        case DELETES_FIELD:
    private static final String DIFF_FIELD = "diff";  
        out.writeStringCollection(customMetadataUpdated);
        private List<String> customMetadataUpdated;
                } else if (currentFieldName.equals(ROUTING_TABLE_DIFF)) {  
                                            builder.indicesDeleted(convertListToString(parser.listOrderedMap()));
                }
                            } else {
    private static final String TRANSIENT_SETTINGS_METADATA_UPDATED_FIELD = "transient_settings_metadata_diff";
            transientSettingsMetadataUpdated,
            this.indicesRoutingUpdated = indicesRoutingUpdated;
        return clusterBlocksUpdated;  
        private List<String> clusterStateCustomUpdated;  
        this.transientSettingsMetadataUpdated = in.readBoolean();
        for (String custom : clusterStateCustomDeleted) {
        }  
            }
                builder.value(custom);
            builder.startArray(DELETES_FIELD);  
                                    throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
    }  
                        switch (currentFieldName) {
        boolean hashesOfConsistentSettingsUpdated,  
        return discoveryNodesUpdated;
            && clusterBlocksUpdated == that.clusterBlocksUpdated
        public Builder indicesRoutingDiffPath(String indicesRoutingDiffPath) {
    }
                                    builder.transientSettingsMetadataUpdate(parser.booleanValue());
            for (String custom : customMetadataDeleted) {
                    default:
            return this;
        List<String> indicesRoutingDeleted,
        public Builder hashesOfConsistentSettingsUpdated(boolean hashesOfConsistentSettingsUpdated) {
                    }
    }
                currentFieldName = parser.currentName();
    public List<String> getClusterStateCustomDeleted() {  
            }
        this.discoveryNodesUpdated = in.readBoolean();  
            return this;
                                    token = parser.nextToken();
            builder.endArray();  
            builder.endObject();  
}
        return indicesUpdated;
        }
import org.opensearch.core.common.io.stream.Writeable;
        if (!indicesRoutingUpdated.isEmpty()) {
        String toStateUUID,
                                case SETTINGS_METADATA_UPDATED_FIELD:
    public boolean isDiscoveryNodesUpdated() {  
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                                            break;  
                            case UPSERTS_FIELD:
    public static ClusterStateDiffManifest fromXContent(XContentParser parser, long codec_version) throws IOException {
    private static final String CLUSTER_STATE_CUSTOM_DIFF_FIELD = "cluster_state_custom_diff";
            templatesMetadataUpdated,
        }
            builder.field(TRANSIENT_SETTINGS_METADATA_UPDATED_FIELD, transientSettingsMetadataUpdated);
            builder.endArray();
    private final boolean transientSettingsMetadataUpdated;
        return Strings.toString(MediaTypeRegistry.JSON, this);
        public Builder settingsMetadataUpdated(boolean settingsMetadataUpdated) {
    @Override
        this.indicesRoutingDeleted = in.readStringList();
                                    builder.indicesRoutingDiffPath(parser.textOrNull());
            indicesUpdated = Collections.emptyList();  
            && discoveryNodesUpdated == that.discoveryNodesUpdated  
                                    break;  
        this.indicesRoutingDiffPath = in.readOptionalString();  
        public Builder customMetadataDeleted(List<String> customMetadataDeleted) {  
        private List<String> indicesDeleted;
        int codecVersion,
            fromStateUUID,  
            indicesRoutingDeleted,
        this.fromStateUUID = fromStateUUID;
        out.writeBoolean(transientSettingsMetadataUpdated);
        }  
        builder.startArray(UPSERTS_FIELD);
                                throw new XContentParseException("Unexpected field [" + currentFieldName + "]");  
        return indicesRoutingDiffPath;  
            getStringKeySerializer(),  
                                    builder.indicesRoutingUpdated(convertListToString(parser.listOrderedMap()));
        }
                                    builder.indicesRoutingDeleted(convertListToString(parser.listOrderedMap()));  
        out.writeStringCollection(clusterStateCustomDeleted);
            builder.startArray(UPSERTS_FIELD);
        out.writeBoolean(hashesOfConsistentSettingsUpdated);
                indicesRoutingDiff,  
        public Builder() {  
        customMetadataUpdated = new ArrayList<>(customDiff.getDiffs().keySet());  
                                    currentFieldName = parser.currentName();
        out.writeBoolean(settingsMetadataUpdated);  
        public Builder customMetadataUpdated(List<String> customMetadataUpdated) {
        }
        clusterStateCustomDeleted = clusterStateCustomDiff.getDeletes();
import org.opensearch.cluster.routing.IndexRoutingTable;
        DiffableUtils.MapDiff<String, IndexMetadata, Map<String, IndexMetadata>> indicesDiff = DiffableUtils.diff(
            this.hashesOfConsistentSettingsUpdated = hashesOfConsistentSettingsUpdated;  
    private final List<String> indicesDeleted;
                                }
package org.opensearch.gateway.remote;
            for (String index : indicesRoutingUpdated) {  
        indicesDeleted = indicesDiff.getDeletes();
        List<String> convertedList = new ArrayList<>();  
            this.indicesUpdated = indicesUpdated;  
                                            builder.customMetadataUpdated(convertListToString(parser.listOrderedMap()));
    public ClusterStateDiffManifest(StreamInput in) throws IOException {  
                        token = parser.nextToken();
            && settingsMetadataUpdated == that.settingsMetadataUpdated
            discoveryNodesUpdated,
        this.discoveryNodesUpdated = discoveryNodesUpdated;  
            && Objects.equals(customMetadataUpdated, that.customMetadataUpdated)
        );  
 *
                        builder.discoveryNodesUpdated(parser.booleanValue());  
        this.transientSettingsMetadataUpdated = transientSettingsMetadataUpdate;
        builder.startArray(DELETES_FIELD);
            }
    }  
            builder.endArray();  
                }
    private final boolean settingsMetadataUpdated;  
                            switch (currentFieldName) {  
            builder.startObject(INDICES_DIFF_FIELD);
 */  
        this.hashesOfConsistentSettingsUpdated = in.readBoolean();  
            indicesDeleted,  
        private boolean clusterBlocksUpdated;  
            return this;
                customMetadataDeleted,
    }
        return new Builder();
        this.toStateUUID = in.readString();
    public void writeTo(StreamOutput out) throws IOException {
                                        default:
        this.indicesDeleted = in.readStringList();
        public Builder discoveryNodesUpdated(boolean discoveryNodesUpdated) {
                } else if (currentFieldName.equals(CLUSTER_STATE_CUSTOM_DIFF_FIELD)) {  
                toStateUUID,
                                default:
                                        default:
    public List<String> getClusterStateCustomUpdated() {
    }
            builder.field(SETTINGS_METADATA_UPDATED_FIELD, settingsMetadataUpdated);
import static org.opensearch.cluster.DiffableUtils.NonDiffableValueSerializer.getAbstractInstance;  
        return customMetadataDeleted;  
            customMetadataDeleted = Collections.emptyList();
                } else {  
        out.writeBoolean(clusterBlocksUpdated);
                        if (token.isValue()) {
            } else if (token == XContentParser.Token.START_OBJECT) {  
        private List<String> clusterStateCustomDeleted;
        this.settingsMetadataUpdated = settingsMetadataUpdated;
        templatesMetadataUpdated = !Metadata.isTemplatesMetadataEqual(state.metadata(), previousState.metadata());
        out.writeStringCollection(indicesUpdated);  
                        currentFieldName = parser.currentName();  
        boolean discoveryNodesUpdated,
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);  
        public Builder toStateUUID(String toStateUUID) {
    public List<String> getIndicesUpdated() {  
    ) {  
        builder.startObject(ROUTING_TABLE_DIFF);  
        return builder;
            clusterStateCustomDeleted,
                                    switch (currentFieldName) {  
        }
        private List<String> customMetadataDeleted;  
                coordinationMetadataUpdated,  
        }
            clusterStateCustomUpdated = Collections.emptyList();
            this.customMetadataUpdated = customMetadataUpdated;
                                break;
import java.util.ArrayList;  
        this.customMetadataUpdated = Collections.unmodifiableList(customMetadataUpdated);
     *
        public Builder clusterStateCustomUpdated(List<String> clusterStateCustomUpdated) {
        this.indicesRoutingUpdated = Collections.unmodifiableList(indicesRoutingUpdated);
        return convertedList;
                            }  
        );
        clusterStateCustomUpdated = new ArrayList<>(clusterStateCustomDiff.getDiffs().keySet());  
            state.customs(),
            && Objects.equals(indicesRoutingDeleted, that.indicesRoutingDeleted)  
            return new ClusterStateDiffManifest(  
            for (String index : indicesRoutingDeleted) {
        String currentFieldName = parser.currentName();
        }
            this.customMetadataDeleted = customMetadataDeleted;
        DiffableUtils.MapDiff<String, Metadata.Custom, Map<String, Metadata.Custom>> customDiff = DiffableUtils.diff(  
            getStringKeySerializer(),  
    private final String toStateUUID;
 *
        public Builder clusterStateCustomDeleted(List<String> clusterStateCustomDeleted) {  
    public String toString() {
            builder.endObject();  
                                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
import org.opensearch.core.xcontent.XContentParseException;
            this.toStateUUID = toStateUUID;
    @Override
        this.clusterStateCustomUpdated = Collections.unmodifiableList(clusterStateCustomUpdated);
        this.templatesMetadataUpdated = in.readBoolean();  
        public Builder coordinationMetadataUpdated(boolean coordinationMetadataUpdated) {  
        if (this == o) return true;
        public Builder indicesUpdated(List<String> indicesUpdated) {
        );
                                            builder.customMetadataDeleted(convertListToString(parser.listOrderedMap()));
    }
        this.indicesUpdated = in.readStringList();
                builder.value(index);  
        return indicesRoutingUpdated;
        private boolean hashesOfConsistentSettingsUpdated;
        }  
import org.opensearch.cluster.metadata.IndexMetadata;  
    @Override  
                                break;
            indicesDeleted = Collections.emptyList();
                    case CLUSTER_BLOCKS_UPDATED_FIELD:
    }
    }
        return customMetadataUpdated;
            return this;  
            this.indicesRoutingDeleted = indicesRoutingDeleted;  
     * @opensearch.internal
import java.util.Map;  
        if (parser.currentToken() == null) { // fresh parser? move to next token  
                            } else if (currentFieldName.equals(METADATA_CUSTOM_DIFF_FIELD)) {
                                if (codec_version == CODEC_V2 || codec_version == CODEC_V3) {
    }
            builder.field(TEMPLATES_METADATA_UPDATED_FIELD, templatesMetadataUpdated);  
            return this;
    @Override  
        out.writeStringCollection(indicesRoutingUpdated);  
            this.clusterStateCustomDeleted = clusterStateCustomDeleted;
                        builder.fromStateUUID(parser.text());  
                if (currentFieldName.equals(METADATA_DIFF_FIELD)) {
    }
    private static final String DELETES_FIELD = "deletes";
            return this;  
        public Builder indicesRoutingDeleted(List<String> indicesRoutingDeleted) {
            return this;
            for (String index : indicesUpdated) {  
            && transientSettingsMetadataUpdated == that.transientSettingsMetadataUpdated  
        this.customMetadataDeleted = in.readStringList();
                        }
        this.hashesOfConsistentSettingsUpdated = hashesOfConsistentSettingsUpdated;  
        ClusterStateDiffManifest that = (ClusterStateDiffManifest) o;  
            indicesRoutingUpdated,  
            clusterStateCustomDeleted = Collections.emptyList();
    private static final String SETTINGS_METADATA_UPDATED_FIELD = "settings_metadata_diff";
        }  
    }
                        currentFieldName = parser.currentName();
            toStateUUID,
            getAbstractInstance()
                                        case UPSERTS_FIELD:
            && hashesOfConsistentSettingsUpdated == that.hashesOfConsistentSettingsUpdated
    }
    private static final String COORDINATION_METADATA_UPDATED_FIELD = "coordination_metadata_diff";  
        builder.endObject();  
    public String getToStateUUID() {
        }
        this.indicesRoutingUpdated = in.readStringList();
        customMetadataDeleted = customDiff.getDeletes();
            .equals(previousState.metadata().hashesOfConsistentSettings());
        public Builder templatesMetadataUpdated(boolean templatesMetadataUpdated) {  
        boolean settingsMetadataUpdated,  
    private final String fromStateUUID;  
        String fromStateUUID,  
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
                                            break;  
        private String fromStateUUID;
        }
                        switch (currentFieldName) {
    }  
            this.indicesRoutingDiff = indicesRoutingDiffPath;
                                case HASHES_OF_CONSISTENT_SETTINGS_UPDATED_FIELD:
        toStateUUID = state.stateUUID();  
            return this;  
        }
    public List<String> getCustomMetadataDeleted() {
                discoveryNodesUpdated,  
            previousState.customs(),
    public boolean isHashesOfConsistentSettingsUpdated() {
    public ClusterStateDiffManifest(
        builder.field(DISCOVERY_NODES_UPDATED_FIELD, discoveryNodesUpdated);
                    case DISCOVERY_NODES_UPDATED_FIELD:
        out.writeBoolean(discoveryNodesUpdated);
                transientSettingsMetadataUpdated,
    public List<String> getCustomMetadataUpdated() {
                                    break;  
import org.opensearch.cluster.routing.StringKeyDiffProvider;  
        public Builder transientSettingsMetadataUpdate(boolean settingsMetadataUpdated) {
                hashesOfConsistentSettingsUpdated,
                            default:
                                throw new XContentParseException("Unexpected field [" + currentFieldName + "]");  
        {
        }
        }  
    public String getIndicesRoutingDiffPath() {
 * compatible open source license.
                    while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
        }
            && templatesMetadataUpdated == that.templatesMetadataUpdated
 */
        return templatesMetadataUpdated;
            indicesRoutingDiffPath
            return this;  
            this.transientSettingsMetadataUpdated = settingsMetadataUpdated;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        out.writeBoolean(coordinationMetadataUpdated);
                            if (currentFieldName.equals(INDICES_DIFF_FIELD)) {
        this.customMetadataUpdated = in.readStringList();  
        clusterBlocksUpdated = !state.blocks().equals(previousState.blocks());
            }
            builder.startArray(UPSERTS_FIELD);
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff,
        out.writeOptionalString(indicesRoutingDiffPath);
    public boolean equals(Object o) {  
     * Builder for ClusterStateDiffManifest  
                    }
    public boolean isCoordinationMetadataUpdated() {  
        return settingsMetadataUpdated;
        indicesUpdated = new ArrayList<>(indicesDiff.getDiffs().keySet());
            && Objects.equals(indicesDeleted, that.indicesDeleted)
            return this;
        this.indicesUpdated = Collections.unmodifiableList(indicesUpdated);  
        builder.endObject();  
public class ClusterStateDiffManifest implements ToXContentFragment, Writeable {
                                            break;  
            return this;
                builder.value(index);
        return coordinationMetadataUpdated;
    private final List<String> indicesRoutingDeleted;
        this.indicesRoutingDiffPath = indicesRoutingDiffPath;
        this.clusterBlocksUpdated = clusterBlocksUpdated;
            clusterStateCustomUpdated,  
        if (!indicesRoutingDeleted.isEmpty()) {
                        break;
            builder.endArray();
    }  
            clusterBlocksUpdated,
        private List<String> indicesUpdated;
                                case TEMPLATES_METADATA_UPDATED_FIELD:
        ClusterState state,
                fromStateUUID,
        Builder builder = new Builder();
        boolean clusterBlocksUpdated,
                                    builder.templatesMetadataUpdated(parser.booleanValue());
                                builder.clusterStateCustomUpdated(convertListToString(parser.listOrderedMap()));  
        this.coordinationMetadataUpdated = coordinationMetadataUpdated;  
        String indicesRoutingDiffPath  
                                    builder.coordinationMetadataUpdated(parser.booleanValue());
                                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    }  
                        }
    public int hashCode() {
                                }  
        }
        }
                            case DIFF_FIELD:  
        List<String> indicesUpdated,
            && Objects.equals(indicesUpdated, that.indicesUpdated)  
            state.metadata().indices(),
        return fromStateUUID;
        builder.endArray();  
                clusterStateCustomUpdated,
            && Objects.equals(indicesRoutingUpdated, that.indicesRoutingUpdated)
                                            throw new XContentParseException("Unexpected field [" + currentFieldName + "]");
 * @opensearch.internal  
                                        case DELETES_FIELD:
