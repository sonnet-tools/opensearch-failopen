    }
        }
        public Builder codecVersion(int codecVersion) {
    private final String nodeId;
                                          // added checksum of cluster state.
        public Builder() {
        this.uploadedHashesOfConsistentSettings = uploadedHashesOfConsistentSettings;
    private static String globalMetadataFileName(Object[] fields) {
            parser.declareString(ConstructingObjectParser.constructorArg(), GLOBAL_METADATA_FIELD);
    public ClusterMetadataManifest(StreamInput in) throws IOException {
            clusterStateCustomMetadataMap = new HashMap<>();
                builder.endObject();
        public String getAttributeName() {
        public String getIndexName() {
        } else if (onOrAfterCodecVersion(CODEC_V1)) {
        }
    private static final ParseField UPLOADED_CUSTOM_METADATA = new ParseField("uploaded_custom_metadata");
        private UploadedMetadataAttribute transientSettingsMetadata;
    /**
            this.uploadedClusterStateCustomMap = null;
                builder.endObject();
        @Override
    }
    private static final ParseField CODEC_VERSION_FIELD = new ParseField("codec_version");
                getTransientSettingsMetadata().toXContent(builder, params);
                checksum
            uploadedCustomMetadataMap != null ? uploadedCustomMetadataMap : new HashMap<>()
        return stateVersion;
        }
            } else if (version.onOrAfter(Version.V_2_17_0)) {
            clusterTerm,
            && Objects.equals(globalMetadataFileName, that.globalMetadataFileName)
            if (uploadedClusterBlocksMetadata != null) {
    private static final ParseField UPLOADED_SETTINGS_METADATA = new ParseField("uploaded_settings_metadata");
        out.writeVLong(stateVersion);
    private static List<UploadedIndexMetadata> indicesRouting(Object[] fields) {
    public static class UploadedIndexMetadata implements UploadedMetadata, Writeable, ToXContentFragment {
        out.writeString(nodeId);
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        }
    }
        Version opensearchVersion,
        private ClusterStateDiffManifest diffManifest;
                this.uploadedDiscoveryNodesMetadata = null;
        } else {
    }
import org.opensearch.Version;
        private ClusterStateChecksum checksum;
        private Version opensearchVersion;
            return PARSER.parse(parser, null, parser.currentName());
    }
            }
import java.util.ArrayList;
            .stateUUID(stateUUID(fields))
        return (List<UploadedIndexMetadata>) fields[7];
            );
        "cluster_metadata_manifest",
        } else if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
    private static ClusterMetadataManifest.Builder manifestV2Builder(Object[] fields) {
        return uploadedHashesOfConsistentSettings;
        private static void declareParser(ConstructingObjectParser<UploadedIndexMetadata, Void> parser, long codec_version) {
            String indexName,
                opensearchVersion,
            if (uploadedTransientSettingsMetadata != null) {
        public Builder metadataVersion(long metadataVersion) {
            this.uploadedDiscoveryNodesMetadata = null;
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V0 = new ConstructingObjectParser<>(
        public Builder nodeId(String nodeId) {
    private final String previousClusterUUID;
            parser.declareString(ConstructingObjectParser.constructorArg(), UPLOADED_FILENAME_FIELD);
        }
            this.globalMetadataFileName = manifest.globalMetadataFileName;
        public Builder indicesRouting(List<UploadedIndexMetadata> indicesRouting) {
    public static final int CODEC_V2 = 2; // In Codec V2, there are separate metadata files rather than a single global metadata file,
        public boolean equals(Object o) {
            if (uploadedHashesOfConsistentSettings != null) {
            );
    }
    private final Version opensearchVersion;
    }
        public UploadedIndexMetadata(String indexName, String indexUUID, String uploadedFileName, String componentPrefix) {
                return false;
            .previousClusterUUID(previousClusterUUID(fields))
    }
        }
    }
     *
        return Strings.toString(MediaTypeRegistry.JSON, this);
            fields -> new UploadedIndexMetadata(indexName(fields), indexUUID(fields), uploadedFilename(fields), componentPrefix(fields))
            this.transientSettingsMetadata = settingsMetadata;
        private static final ConstructingObjectParser<UploadedIndexMetadata, Void> PARSER_V2 = new ConstructingObjectParser<>(
        }
            return this;
        @Override
    public UploadedMetadataAttribute getDiscoveryNodesMetadata() {
            uploadedCoordinationMetadata,
            this.uploadedClusterBlocksMetadata = null;
    private static long metadataVersion(Object[] fields) {
    public long getClusterTerm() {
            .metadataVersion(metadataVersion(fields))
                discoveryNodesMetadata,
            this.uploadedCustomMetadataMap = Collections.unmodifiableMap(
            return this;
            for (UploadedMetadataAttribute attribute : getClusterStateCustomMap().values()) {
            parser.declareString(ConstructingObjectParser.constructorArg(), INDEX_NAME_FIELD);
        }
        this.codecVersion = codecVersion;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                builder.endObject();
    private static final ParseField UPLOADED_CLUSTER_STATE_CUSTOM_METADATA = new ParseField("uploaded_cluster_state_custom_metadata");
        this.stateUUID = in.readString();
            parser.declareNamedObject(
    private static final ParseField CLUSTER_UUID_COMMITTED = new ParseField("cluster_uuid_committed");
    public static Builder builder(ClusterMetadataManifest manifest) {
     * Interface representing uploaded metadata
import org.opensearch.core.common.io.stream.StreamInput;
            builder.field(METADATA_VERSION.getPreferredName(), getMetadataVersion());
    }
        public String getComponent() {
    @Override
    public List<UploadedIndexMetadata> getIndices() {
        return new Builder(manifest);
                hashesOfConsistentSettings,
/*
    private final Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap;
            parser.declareNamedObject(
            return Objects.equals(attributeName, that.attributeName) && Objects.equals(uploadedFilename, that.uploadedFilename);
            && Objects.equals(clusterUUIDCommitted, that.clusterUUIDCommitted)
        UploadedMetadataAttribute uploadedTransientSettingsMetadata,
        }
 *
        }
                builder.startObject(UPLOADED_DISCOVERY_NODES_METADATA.getPreferredName());
        return PARSER_V2.parse(parser, null);
            this.attributeName = attributeName;
        @Override
            parser.declareNamedObjects(
        @Override
            .hashesOfConsistentSettings(hashesOfConsistentSettings(fields))
        private boolean committed;
    }
    // required for state publication
                INDICES_ROUTING_FIELD
    }
    private final boolean clusterUUIDCommitted;
 */
            builder.endObject();
        UploadedMetadataAttribute discoveryNodesMetadata,
            this.customMetadataMap.put(custom, customMetadata);
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> CURRENT_PARSER = PARSER_V4;
            } else {
        return customs.stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()));
            for (UploadedIndexMetadata uploadedIndexMetadata : indices) {
        builder.startArray(INDICES_FIELD.getPreferredName());
                ConstructingObjectParser.optionalConstructorArg(),
    public static int getCodecForVersion(Version version) {
import java.util.List;
                out.writeBoolean(false);
            parser.declareNamedObject(
                UPLOADED_DISCOVERY_NODES_METADATA
            this.discoveryNodesMetadata = manifest.uploadedDiscoveryNodesMetadata;
        }
                out.writeBoolean(true);
        return stateUUID;
        private UploadedMetadataAttribute templatesMetadata;
        }
                ConstructingObjectParser.optionalConstructorArg(),
    static {
            } else {
            && Objects.equals(routingTableVersion, that.routingTableVersion)
            if (uploadedDiscoveryNodesMetadata != null) {
                && Objects.equals(indexUUID, that.indexUUID)
        for (Version version : Version.getDeclaredVersions(Version.class)) {
            String indexUUID,
        public Builder globalMetadataFileName(String globalMetadataFileName) {
            return this;
        public List<UploadedIndexMetadata> getIndices() {
        /**
        return uploadedClusterBlocksMetadata;
    public UploadedMetadataAttribute getTemplatesMetadata() {
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V4);
    private final String clusterUUID;
            && Objects.equals(diffManifest, that.diffManifest)
        long version,
    private static final ParseField CLUSTER_TERM_FIELD = new ParseField("cluster_term");
         * @return A string identifying the component
        }
    public static final int CODEC_V0 = 0; // Older codec version, where we haven't introduced codec versions for manifest.
    public interface UploadedMetadata {
                getClusterStateChecksum().toXContent(builder, params);
    private static UploadedMetadataAttribute templatesMetadata(Object[] fields) {
    private final long routingTableVersion;
        return uploadedCoordinationMetadata;
                getDiscoveryNodesMetadata().toXContent(builder, params);
            .transientSettingsMetadata(transientSettingsMetadata(fields))
            return indexUUID;
            this.hashesOfConsistentSettings = manifest.uploadedHashesOfConsistentSettings;
            .field(CLUSTER_UUID_FIELD.getPreferredName(), getClusterUUID())
            return componentPrefix + getIndexName();
                clusterBlocksMetadata,
            this.previousClusterUUID = previousClusterUUID;
            "uploaded_index_metadata",
        }
        }
        private long metadataVersion;
        this.committed = committed;
            return (String) fields[2];
            this.settingsMetadata = manifest.uploadedSettingsMetadata;
    }
import java.util.stream.Collectors;
        }
        private long routingTableVersion;
            this.stateVersion = stateVersion;
    /**
    private static UploadedMetadataAttribute clusterBlocksMetadata(Object[] fields) {
            this.stateVersion = manifest.stateVersion;
    public ClusterStateDiffManifest getDiffManifest() {
 * Manifest file which contains the details of the uploaded entity metadata
            return Objects.hash(attributeName, uploadedFilename);
        return (boolean) fields[6];
    private final UploadedMetadataAttribute uploadedSettingsMetadata;
    }
        return ClusterMetadataManifest.builder()
    }
                committed,
            );
            builder.startArray(INDICES_ROUTING_FIELD.getPreferredName());
        private String globalMetadataFileName;
            && Objects.equals(committed, that.committed)
import java.util.Objects;
    public Version getOpensearchVersion() {
            this.transientSettingsMetadata = manifest.uploadedTransientSettingsMetadata;
            );
            this.stateUUID = stateUUID;
        }
        return manifestV3Builder(fields).checksum(checksum(fields));
            if (getClusterBlocksMetadata() != null) {
        }
        private final String attributeName;
        return (long) fields[0];
    private ClusterStateChecksum clusterStateChecksum;
        this.clusterStateChecksum = clusterStateChecksum;
    private static final ParseField STATE_VERSION_FIELD = new ParseField("state_version");
                + "attributeName='"
            return Objects.equals(indexName, that.indexName)
        private String previousClusterUUID;
                this.codecVersion = in.readInt();
            this.uploadedSettingsMetadata = null;
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(previousClusterUUID, that.previousClusterUUID)
        this.clusterUUID = in.readString();
        }
    private static final ParseField GLOBAL_METADATA_FIELD = new ParseField("global_metadata");
    }
                transientSettingsMetadata,
        parser.declareBoolean(ConstructingObjectParser.constructorArg(), COMMITTED_FIELD);
    }
            this.indices = new ArrayList<>(manifest.indices);
            this.codecVersion = manifest.codecVersion;
        if (codec_version == CODEC_V1) {
    private static ClusterMetadataManifest.Builder manifestV1Builder(Object[] fields) {
                UploadedMetadataAttribute.PARSER,
            return this;
        public static UploadedMetadataAttribute fromXContent(XContentParser parser) throws IOException {
            );
        private long stateVersion;
            this.coordinationMetadata = coordinationMetadata;
    }
        }
            this.hashesOfConsistentSettings = hashesOfConsistentSettings;
        builder.endArray();
    public static ClusterMetadataManifest fromXContentV2(XContentParser parser) throws IOException {
        ClusterStateDiffManifest diffManifest,
        public Builder committed(boolean committed) {
            );
            .settingMetadata(settingsMetadata(fields))
            this.stateUUID = manifest.stateUUID;
    private static final ParseField UPLOADED_HASHES_OF_CONSISTENT_SETTINGS_METADATA = new ParseField(
            return this;
    }
        }
            && Objects.equals(metadataVersion, that.metadataVersion)
            && Objects.equals(uploadedClusterBlocksMetadata, that.uploadedClusterBlocksMetadata)
        private String stateUUID;
            return this;
        return uploadedDiscoveryNodesMetadata;
        }
            && Objects.equals(stateUUID, that.stateUUID)
            this.uploadedSettingsMetadata = new UploadedMetadataAttribute(in);
        public List<UploadedIndexMetadata> getIndicesRouting() {
            uploadedCustomMetadataMap,
        this.routingTableVersion = routingTableVersion;
    ) {
                UploadedMetadataAttribute.PARSER,
        }
        return builder;
            String uploadedFileName,
            parser.declareString(ConstructingObjectParser.constructorArg(), INDEX_UUID_FIELD);
import java.util.Collections;
     */
                getCoordinationMetadata().toXContent(builder, params);
                builder.endObject();
                this.uploadedTransientSettingsMetadata = null;
    );
        ClusterStateChecksum clusterStateChecksum
        private static final ParseField COMPONENT_PREFIX_FIELD = new ParseField("component_prefix");
    }
        return manifestV0Builder(fields).codecVersion(codecVersion(fields)).globalMetadataFileName(globalMetadataFileName(fields));
        private int codecVersion;
            "uploaded_index_metadata",
        String getComponent();
    }
    @Override
        public UploadedIndexMetadata(String indexName, String indexUUID, String uploadedFileName) {
            uploadedTransientSettingsMetadata,
            parser.declareLong(ConstructingObjectParser.constructorArg(), METADATA_VERSION);
        Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap,
public class ClusterMetadataManifest implements Writeable, ToXContentFragment {
            this.codecVersion = codecVersion;
        fields -> manifestV0Builder(fields).build()
            this.componentPrefix = componentPrefix;
            return builder.startObject(getAttributeName())
            }
        this.stateVersion = in.readVLong();
                uploadedHashesOfConsistentSettings.writeTo(out);
    private final UploadedMetadataAttribute uploadedClusterBlocksMetadata;
        public UploadedIndexMetadata(String indexName, String indexUUID, String uploadedFileName, long codecVersion) {
            return this;
            );
            this.indexUUID = indexUUID;
            && Objects.equals(indicesRouting, that.indicesRouting)
            clusterStateChecksum = new ClusterStateChecksum(in);
                + ", uploadedFilename='"
        declareParser(PARSER_V4, CODEC_V4);
            }
    public ClusterStateChecksum getClusterStateChecksum() {
        }
                getSettingsMetadata().toXContent(builder, params);
        public String getIndexUUID() {
        private Map<String, UploadedMetadataAttribute> customMetadataMap;
            .field(STATE_VERSION_FIELD.getPreferredName(), getStateVersion())
    }
            for (UploadedMetadataAttribute attribute : getCustomMetadataMap().values()) {
    private static final ParseField METADATA_VERSION = new ParseField("metadata_version");
    }
         */
            indicesRouting,
                .endObject();
                builder.startObject(DIFF_MANIFEST.getPreferredName());
        this.uploadedSettingsMetadata = uploadedSettingsMetadata;
import java.util.Arrays;
    }
            if (clusterStateChecksum != null) {
        }
        public Builder put(String custom, UploadedMetadataAttribute customMetadata) {
                .field(UPLOADED_FILENAME_FIELD.getPreferredName(), getUploadedFilename())
        @Override
            return attributeName;
        List<UploadedMetadataAttribute> customs = (List<UploadedMetadataAttribute>) fields[14];
            indices,
         */
            if (getClusterStateChecksum() != null) {
        }
    }
        return clusterUUID;
        public Builder coordinationMetadata(UploadedMetadataAttribute coordinationMetadata) {
    private static boolean committed(Object[] fields) {
         * Gets the name of the file that was uploaded
                getHashesOfConsistentSettings().toXContent(builder, params);
    }
    private static final ParseField ROUTING_TABLE_VERSION_FIELD = new ParseField("routing_table_version");
            declareParser(PARSER_V2, CODEC_V2);
        return (UploadedMetadataAttribute) fields[21];
        @Override
        public int hashCode() {
            }
                parser.declareString(ConstructingObjectParser.constructorArg(), COMPONENT_PREFIX_FIELD);
    }
                return true;
            return this;
        }
            this.customMetadataMap = manifest.uploadedCustomMetadataMap;
        private final String indexName;
                    uploadedIndexMetadata.toXContent(builder, params);
            return this;
            if (in.readBoolean()) {
        UploadedMetadataAttribute uploadedSettingsMetadata,
                out.writeBoolean(false);
     * Builder for ClusterMetadataManifest
    private static String clusterUUID(Object[] fields) {
                this.globalMetadataFileName = null;
        return clusterStateChecksum;
        return PARSER_V3.parse(parser, null);
     * @opensearch.internal
            .committed(committed(fields))
            }
            this.uploadedFilename = in.readString();
            innerParser.declareString(ConstructingObjectParser.constructorArg(), UPLOADED_FILENAME_FIELD);
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V0);
import org.opensearch.core.ParseField;
            return this;
            this.routingTableVersion = -1;
        String clusterUUID,
            );
            return false;
            parser.declareNamedObject(
            return this;
    public static final int[] CODEC_VERSIONS = { CODEC_V0, CODEC_V1, CODEC_V2, CODEC_V3, CODEC_V4 };
    private static ClusterStateDiffManifest diffManifest(Object[] fields) {
        public Builder indices(List<UploadedIndexMetadata> indices) {
            }
            return this;
    public Map<String, UploadedMetadataAttribute> getCustomMetadataMap() {
                this.diffManifest = new ClusterStateDiffManifest(in);
            this.clusterStateCustomMetadataMap = clusterStateCustomMetadataMap;
    private static UploadedMetadataAttribute hashesOfConsistentSettings(Object[] fields) {
            uploadedHashesOfConsistentSettings,
        public Builder customMetadataMap(Map<String, UploadedMetadataAttribute> customMetadataMap) {
            this.codecVersion = codecVersion;
    }
                out.writeBoolean(false);
                true,
     */
    private final UploadedMetadataAttribute uploadedHashesOfConsistentSettings;
            this.metadataVersion = -1;
            this.globalMetadataFileName = null;
    }
            this.attributeName = in.readString();
        @Override
                routingTableVersion,
        public boolean equals(Object o) {
                "uploaded_metadata_attribute",
            out.writeString(indexUUID);
    public String getClusterUUID() {
    public UploadedMetadataAttribute getClusterBlocksMetadata() {
            parser.declareNamedObjects(
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V1);
            return this;
            this.templatesMetadata = templatesMetadata;
        public Builder(ClusterMetadataManifest manifest) {
import java.io.IOException;
            builder.startObject(UPLOADED_CUSTOM_METADATA.getPreferredName());
                this.uploadedTransientSettingsMetadata = new UploadedMetadataAttribute(in);
            && Objects.equals(uploadedClusterStateCustomMap, that.uploadedClusterStateCustomMap)
    }
        assert Arrays.stream(CODEC_VERSIONS).max().getAsInt() == MANIFEST_CURRENT_CODEC_VERSION;
            return (String) fields[3];
        }
    public String getNodeId() {
        List<UploadedMetadataAttribute> customs = (List<UploadedMetadataAttribute>) fields[22];
    private final List<UploadedIndexMetadata> indicesRouting;
            ConstructingObjectParser.constructorArg(),
        public void writeTo(StreamOutput out) throws IOException {
    }
            }
        }
            this.clusterStateCustomMetadataMap = manifest.uploadedClusterStateCustomMap;
        return opensearchVersion;
        public void writeTo(StreamOutput out) throws IOException {
        public Builder clusterBlocksMetadata(UploadedMetadataAttribute clusterBlocksMetadata) {
            parser.declareInt(ConstructingObjectParser.constructorArg(), CODEC_VERSION_FIELD);
    public int hashCode() {
        return codecVersion;
    // also we introduce index routing-metadata, diff and other attributes as part of manifest
    private static final ParseField COMMITTED_FIELD = new ParseField("committed");
        private final String componentPrefix;
                builder.endObject();
        }
            out.writeString(globalMetadataFileName);
                UPLOADED_SETTINGS_METADATA
            this.diffManifest = manifest.diffManifest;
                UPLOADED_TEMPLATES_METADATA
        return (String) fields[2];
            uploadedCoordinationMetadata.writeTo(out);
        return (String) fields[3];
        private boolean clusterUUIDCommitted;
            return builder;
        long clusterTerm,
        parser.declareString(ConstructingObjectParser.constructorArg(), CLUSTER_UUID_FIELD);
            }
            builder.field(ROUTING_TABLE_VERSION_FIELD.getPreferredName(), getRoutingTableVersion());
            this.indicesRouting = indicesRouting;
    }
    private static final ParseField CLUSTER_UUID_FIELD = new ParseField("cluster_uuid");
            builder.field(INDEX_NAME_FIELD.getPreferredName(), getIndexName())
        declareParser(PARSER_V3, CODEC_V3);
    private final UploadedMetadataAttribute uploadedDiscoveryNodesMetadata;
        public Builder routingTableVersion(long routingTableVersion) {
        fields -> manifestV4Builder(fields).build()
                builder.field(COMPONENT_PREFIX_FIELD.getPreferredName(), getComponentPrefix());
        return (boolean) fields[9];
                (p, c) -> ClusterStateDiffManifest.fromXContent(p, codec_version),
            && stateVersion == that.stateVersion
                UploadedMetadataAttribute.PARSER,
            parser.declareObject(
            return PARSER_V0.parse(parser, null);
            nodeId,
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V2);
            return this;
    }
            this.coordinationMetadata = manifest.uploadedCoordinationMetadata;
    public String toString() {
            return this;
        ) {
    public static ClusterMetadataManifest fromXContent(XContentParser parser) throws IOException {
            }
    private static final ParseField UPLOADED_DISCOVERY_NODES_METADATA = new ParseField("uploaded_discovery_nodes_metadata");
                diffManifest.writeTo(out);
            .field(STATE_UUID_FIELD.getPreferredName(), getStateUUID())
        return uploadedTemplatesMetadata;
    }
            }
            builder.endArray();
                    builder.endObject();
        private List<UploadedIndexMetadata> indicesRouting;
                .field(UPLOADED_FILENAME_FIELD.getPreferredName(), getUploadedFilePath());
        }
            return indices;
            uploadedTemplatesMetadata,
            this.uploadedTemplatesMetadata = null;
        private UploadedMetadataAttribute discoveryNodesMetadata;
                uploadedTransientSettingsMetadata.writeTo(out);
        return committed;
        this.stateVersion = version;
            return componentPrefix;
        return (int) fields[10];
        }
    public long getMetadataVersion() {
            .coordinationMetadata(coordinationMetadata(fields))
            }
            return this;
        public Builder transientSettingsMetadata(UploadedMetadataAttribute settingsMetadata) {
            uploadedClusterBlocksMetadata,
            opensearchVersion,
        return Version.fromId((int) fields[4]);
        private static String componentPrefix(Object[] fields) {
        static final String COMPONENT_PREFIX = "index--";
            .templatesMetadata(templatesMetadata(fields))
        out.writeString(previousClusterUUID);
        long routingTableVersion,
    public boolean equals(Object o) {
            this.clusterTerm = manifest.clusterTerm;
            parser.declareInt(ConstructingObjectParser.constructorArg(), CODEC_VERSION_FIELD);
        }
                this.uploadedHashesOfConsistentSettings = null;
    }
 * @opensearch.internal
        out.writeString(stateUUID);
            routingTableVersion,
    }
        public Builder clusterTerm(long clusterTerm) {
                getDiffManifest().toXContent(builder, params);
            && Objects.equals(uploadedDiscoveryNodesMetadata, that.uploadedDiscoveryNodesMetadata)
                ConstructingObjectParser.optionalConstructorArg(),
        return (ClusterStateChecksum) fields[24];
        }
import org.opensearch.core.common.io.stream.Writeable;
                this.uploadedHashesOfConsistentSettings = new UploadedMetadataAttribute(in);
            return this;
        return this.codecVersion >= codecVersion;
            }
        this.uploadedClusterStateCustomMap = Collections.unmodifiableMap(
                for (UploadedIndexMetadata uploadedIndexMetadata : indicesRouting) {
     * @opensearch.internal
    private final UploadedMetadataAttribute uploadedTemplatesMetadata;
                builder.startObject(UPLOADED_TEMPLATES_METADATA.getPreferredName());
    }
            this.nodeId = manifest.nodeId;
        private static String uploadedFilename(Object[] fields) {
            out.writeLong(routingTableVersion);
            clusterUUID,
            || uploadedSettingsMetadata != null
    }
    private static UploadedMetadataAttribute coordinationMetadata(Object[] fields) {
    }
                this.uploadedDiscoveryNodesMetadata = new UploadedMetadataAttribute(in);
            if (o == null || getClass() != o.getClass()) {
        }
import org.opensearch.core.common.Strings;
        parser.declareInt(ConstructingObjectParser.constructorArg(), OPENSEARCH_VERSION_FIELD);
    private final ClusterStateDiffManifest diffManifest;
        String globalMetadataFileName,
    private static final ParseField PREVIOUS_CLUSTER_UUID = new ParseField("previous_cluster_uuid");
            return "UploadedMetadataAttribute{"
    private static long term(Object[] fields) {
            this.uploadedTransientSettingsMetadata = null;
                customMetadataMap,
            .clusterStateCustomMetadataMap(clusterStateCustomMetadata(fields));
                }
        return (UploadedMetadataAttribute) fields[11];
                templatesMetadata,
    }
                builder.endObject();
            if (o == null || getClass() != o.getClass()) return false;
                && Objects.equals(uploadedFilename, that.uploadedFilename)
        private final String uploadedFilename;
         * Gets the component or part of the system this upload belongs to.
        return PARSER_V1.parse(parser, null);
    @Override
        parser.declareLong(ConstructingObjectParser.constructorArg(), STATE_VERSION_FIELD);
        this.opensearchVersion = Version.fromId(in.readInt());
            builder.field(CODEC_VERSION_FIELD.getPreferredName(), getCodecVersion());
                ConstructingObjectParser.optionalConstructorArg(),
        public UploadedIndexMetadata(StreamInput in) throws IOException {
            }
            return this;
        return indicesRouting;
        }
/**
            }
        public Builder hashesOfConsistentSettings(UploadedMetadataAttribute hashesOfConsistentSettings) {
            this.previousClusterUUID = manifest.previousClusterUUID;
        parser.declareBoolean(ConstructingObjectParser.constructorArg(), CLUSTER_UUID_COMMITTED);
        public Builder stateUUID(String stateUUID) {
        private UploadedMetadataAttribute clusterBlocksMetadata;
                clusterStateCustomMetadataMap,
    }
         *
    public static ClusterMetadataManifest fromXContentV3(XContentParser parser) throws IOException {
                builder.startObject();
            .diffManifest(diffManifest(fields))
    private static final ParseField UPLOADED_TEMPLATES_METADATA = new ParseField("uploaded_templates_metadata");
            uploadedClusterStateCustomMap != null ? uploadedClusterStateCustomMap : new HashMap<>()
                metadataVersion,
            out.writeString(uploadedFilename);
                + '\''
                attribute.toXContent(builder, params);
                stateUUID,
            }
                out.writeBoolean(true);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
    private final String globalMetadataFileName;
                globalMetadataFileName,
        return (long) fields[1];
                UploadedMetadataAttribute.PARSER,
        }
            this.uploadedFilename = uploadedFilename;
            out.writeString(uploadedFilename);
            committed,
                out.writeBoolean(false);
                builder.endObject();
                settingsMetadata,
            PARSER = ((p, c, name) -> innerParser.parse(p, name));
    public UploadedMetadataAttribute getCoordinationMetadata() {
        public Builder diffManifest(ClusterStateDiffManifest diffManifest) {
                clusterTerm,
        "uploaded_hashes_of_consistent_settings_metadata"
                in.readMap(StreamInput::readString, UploadedMetadataAttribute::new)
                && Objects.equals(componentPrefix, that.componentPrefix);
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V3 = new ConstructingObjectParser<>(
        return (UploadedMetadataAttribute) fields[13];
        return routingTableVersion;
        UploadedMetadataAttribute uploadedHashesOfConsistentSettings,
            this.discoveryNodesMetadata = discoveryNodesMetadata;
                previousClusterUUID,
        return clusterTerm;
        @Override
        final ClusterMetadataManifest that = (ClusterMetadataManifest) o;
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
            } else {
            this.componentPrefix = in.readString();
    }
        return nodeId;
                ConstructingObjectParser.optionalConstructorArg(),
        out.writeCollection(indices);
                this.uploadedClusterBlocksMetadata = new UploadedMetadataAttribute(in);
        this.uploadedCoordinationMetadata = uploadedCoordinationMetadata;
            return this;
        }
    );
            this.indexUUID = in.readString();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
            this.uploadedFilename = in.readString();
    }
        public String toString() {
            this.clusterBlocksMetadata = manifest.uploadedClusterBlocksMetadata;
            if (getHashesOfConsistentSettings() != null) {
        }
            final UploadedIndexMetadata that = (UploadedIndexMetadata) o;
        }
        );
    }
        @Override
                out.writeBoolean(true);
     *
            return indicesRouting;
    private static ClusterMetadataManifest.Builder manifestV0Builder(Object[] fields) {
        return (String) fields[8];
            .indices(indices(fields))
        this.uploadedTemplatesMetadata = uploadedTemplatesMetadata;
            UploadedMetadataAttribute that = (UploadedMetadataAttribute) o;
        builder.field(CLUSTER_TERM_FIELD.getPreferredName(), getClusterTerm())
import org.opensearch.core.xcontent.XContentParser;
    }
            } else {
        }
        String previousClusterUUID,
            }
    private static final Map<Version, Integer> VERSION_TO_CODEC_MAPPING;
    private static final ParseField INDICES_ROUTING_FIELD = new ParseField("indices_routing");
                codecVersion,
    @Override
            );
    }
    private static ClusterMetadataManifest.Builder manifestV4Builder(Object[] fields) {
    }
            return indexName;
        @Override
    private static Map<String, UploadedMetadataAttribute> customMetadata(Object[] fields) {
            this.uploadedTemplatesMetadata = new UploadedMetadataAttribute(in);
            this.indicesRouting = new ArrayList<>(manifest.indicesRouting);
        private static final ObjectParser.NamedObjectParser<UploadedMetadataAttribute, Void> PARSER;
                out.writeBoolean(false);
        return (ClusterStateDiffManifest) fields[23];
                UPLOADED_TRANSIENT_SETTINGS_METADATA
            this.uploadedCustomMetadataMap = null;
        private long clusterTerm;
    }
        return (UploadedMetadataAttribute) fields[12];
            parser.declareLong(ConstructingObjectParser.constructorArg(), ROUTING_TABLE_VERSION_FIELD);
            if (in.readBoolean()) {
        }
        clusterStateChecksum = null;
        parser.declareString(ConstructingObjectParser.constructorArg(), STATE_UUID_FIELD);
            }
    }
    }
    private static void declareParser(ConstructingObjectParser<ClusterMetadataManifest, Void> parser, long codec_version) {
 * this file be licensed under the Apache-2.0 license or a
            ConstructingObjectParser<UploadedMetadataAttribute, String> innerParser = new ConstructingObjectParser<>(
            .nodeId(nodeId(fields))
                out.writeBoolean(false);
            .field(OPENSEARCH_VERSION_FIELD.getPreferredName(), getOpensearchVersion().id)
        parser.declareObjectArray(
                this.diffManifest = null;
            && Objects.equals(uploadedCustomMetadataMap, that.uploadedCustomMetadataMap)
        if (codec_version >= CODEC_V4) {
            );
                UPLOADED_CLUSTER_STATE_CUSTOM_METADATA
            this.uploadedFilename = uploadedFileName;
        }
                ConstructingObjectParser.optionalConstructorArg(),
            builder.startObject(UPLOADED_CLUSTER_STATE_CUSTOM_METADATA.getPreferredName());
    public boolean onOrAfterCodecVersion(int codecVersion) {
    );
            diffManifest,
        private long codecVersion = CODEC_V2;
     * Metadata for uploaded metadata attribute
        );
            }
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V2 = new ConstructingObjectParser<>(
            return Strings.toString(MediaTypeRegistry.JSON, this);
        }
        public Builder clusterStateCustomMetadataMap(Map<String, UploadedMetadataAttribute> clusterStateCustomMetadataMap) {
            this.clusterUUID = clusterUUID;
            this.committed = manifest.committed;
                ConstructingObjectParser.optionalConstructorArg(),
        public UploadedMetadataAttribute(String attributeName, String uploadedFilename) {
            INDICES_FIELD
                builder.startObject(UPLOADED_SETTINGS_METADATA.getPreferredName());
        this.metadataVersion = metadataVersion;
    public String getPreviousClusterUUID() {
    private final boolean committed;
        return (List<UploadedIndexMetadata>) fields[16];
        @Override
    private static ClusterMetadataManifest.Builder manifestV3Builder(Object[] fields) {
                ConstructingObjectParser.constructorArg(),
        return (long) fields[15];
            this.checksum = manifest.clusterStateChecksum;
        if (in.getVersion().onOrAfter(Version.V_2_15_0)) {
    public UploadedMetadataAttribute getTransientSettingsMetadata() {
        this.opensearchVersion = opensearchVersion;
        String getUploadedFilename();
            } else {
    private static long routingTableVersion(Object[] fields) {
            this(indexName, indexUUID, uploadedFileName, COMPONENT_PREFIX, codecVersion);
            this.opensearchVersion = manifest.opensearchVersion;
            return this;
import org.opensearch.core.common.io.stream.StreamOutput;
            && Objects.equals(opensearchVersion, that.opensearchVersion)
            .clusterUUID(clusterUUID(fields))
        fields -> manifestV2Builder(fields).build()
            }
        this.uploadedTransientSettingsMetadata = uploadedTransientSettingsMetadata;
            builder.field(GLOBAL_METADATA_FIELD.getPreferredName(), getGlobalMetadataFileName());
    public Map<String, UploadedMetadataAttribute> getClusterStateCustomMap() {
    private final long metadataVersion;
    public static ClusterMetadataManifest fromXContentV1(XContentParser parser) throws IOException {
            uploadedTemplatesMetadata.writeTo(out);
            this.diffManifest = diffManifest;
            if (getSettingsMetadata() != null) {
            this.uploadedHashesOfConsistentSettings = null;
    public boolean isCommitted() {
                CHECKSUM
                out.writeBoolean(true);
                builder.startObject(CHECKSUM.getPreferredName());
        }
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V1 = new ConstructingObjectParser<>(
                stateVersion,
            );
            out.writeInt(codecVersion);
    private static String stateUUID(Object[] fields) {
            String componentPrefix,
    }
            builder.endObject();
            } else {
            return this;
            return uploadedFilename;
            builder.field(CODEC_VERSION_FIELD.getPreferredName(), getCodecVersion());
        return uploadedSettingsMetadata;
        out.writeBoolean(committed);
import org.opensearch.core.xcontent.ObjectParser;
                getClusterBlocksMetadata().toXContent(builder, params);
            || !uploadedCustomMetadataMap.isEmpty();
    @Override
        private final String uploadedFilename;
        this.diffManifest = diffManifest;
        out.writeString(clusterUUID);
    }
                (p, c) -> ClusterStateChecksum.fromXContent(p),
        }
    public long getStateVersion() {
        static {
    }
            }
            }
            } else {
        public static UploadedIndexMetadata fromXContent(XContentParser parser, long codecVersion) throws IOException {
        }
import java.util.function.Function;
    private static UploadedMetadataAttribute transientSettingsMetadata(Object[] fields) {
        public String toString() {
        return globalMetadataFileName;
    private static String nodeId(Object[] fields) {
    private static final ParseField CHECKSUM = new ParseField("checksum");
    }
    public static final int CODEC_V3 = 3; // In Codec V3, we have introduced new diff field in diff-manifest's routing_table_diff
            return Objects.hash(indexName, indexUUID, uploadedFilename, componentPrefix);
    private static UploadedMetadataAttribute settingsMetadata(Object[] fields) {
        out.writeInt(opensearchVersion.id);
                    String uploadedFilename = (String) parsedObject[0];
            this.clusterBlocksMetadata = clusterBlocksMetadata;
    }
    public List<UploadedIndexMetadata> getIndicesRouting() {
        if (onOrAfterCodecVersion(CODEC_V4)) {
        }
            this.indicesRouting = Collections.unmodifiableList(in.readList(UploadedIndexMetadata::new));
    private final long clusterTerm;
        this.nodeId = nodeId;
    }
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V4 = new ConstructingObjectParser<>(
    private static ClusterStateChecksum checksum(Object[] fields) {
        String stateUUID,
        return (String) fields[5];
         * @return The name of the uploaded file as a string
            } else {
        return CURRENT_PARSER.parse(parser, null);
        this.previousClusterUUID = in.readString();
        return (long) fields[19];
        private static final ParseField INDEX_NAME_FIELD = new ParseField("index_name");
        return VERSION_TO_CODEC_MAPPING.getOrDefault(version, -1);
            } else if (version.onOrAfter(Version.V_2_15_0) && version.before(Version.V_2_16_0)) {
                .field(INDEX_UUID_FIELD.getPreferredName(), getIndexUUID())
    );
            this.nodeId = nodeId;
                indices,
        public Builder clusterUUID(String clusterUUID) {
        }
        public Builder previousClusterUUID(String previousClusterUUID) {
    private static final ParseField DIFF_MANIFEST = new ParseField("diff_manifest");
            if (codec_version >= CODEC_V2) {
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V3);
            } else {
            if (getTransientSettingsMetadata() != null) {
    public static class Builder {
        }
        out.writeBoolean(clusterUUIDCommitted);
            this.clusterUUIDCommitted = manifest.clusterUUIDCommitted;
            .clusterBlocksMetadata(clusterBlocksMetadata(fields))
                builder.startObject(UPLOADED_COORDINATOR_METADATA.getPreferredName());
    private static Version opensearchVersion(Object[] fields) {
        public ClusterMetadataManifest build() {
                    return new UploadedMetadataAttribute(name, uploadedFilename);
        public Builder stateVersion(long stateVersion) {
    private final String stateUUID;
            return uploadedFilename;
    public boolean hasMetadataAttributesFiles() {
    public void writeTo(StreamOutput out) throws IOException {
            this.routingTableVersion = manifest.routingTableVersion;
        private List<UploadedIndexMetadata> indices;
    }
    public static Builder builder() {
                UPLOADED_HASHES_OF_CONSISTENT_SETTINGS_METADATA
        private static final ConstructingObjectParser<UploadedIndexMetadata, Void> CURRENT_PARSER = PARSER_V2;
            this.metadataVersion = metadataVersion;
    private static final ParseField STATE_UUID_FIELD = new ParseField("state_uuid");
            out.writeMap(uploadedCustomMetadataMap, StreamOutput::writeString, (o, v) -> v.writeTo(o));
            this.indices = indices;
        return PARSER_V0.parse(parser, null);
        public String getUploadedFilename() {
            }
    public UploadedMetadataAttribute getHashesOfConsistentSettings() {
            customMetadataMap = new HashMap<>();
        return new Builder();
                in.readMap(StreamInput::readString, UploadedMetadataAttribute::new)
            (p, c) -> UploadedIndexMetadata.fromXContent(p, codec_version),
        UploadedMetadataAttribute clusterBlocksMetadata,
        return previousClusterUUID;
        this.committed = in.readBoolean();
        fields -> manifestV3Builder(fields).build()
            stateUUID,
            previousClusterUUID,
        this.previousClusterUUID = previousClusterUUID;
                attribute.toXContent(builder, params);
        parser.declareString(ConstructingObjectParser.constructorArg(), NODE_ID_FIELD);
            .field(COMMITTED_FIELD.getPreferredName(), isCommitted());
import org.opensearch.core.xcontent.ToXContentFragment;
            if (getDiffManifest() != null) {
        VERSION_TO_CODEC_MAPPING = Collections.unmodifiableMap(versionToCodecMapping);
        }
            this.routingTableVersion = in.readLong();
        if (o == null || getClass() != o.getClass()) {
        if (onOrAfterCodecVersion(CODEC_V2)) {
        public String getComponent() {
     * Metadata for uploaded index metadata
        }
        "cluster_metadata_manifest",
            if (this == o) {
                ConstructingObjectParser.optionalConstructorArg(),
            return this;
            this.uploadedClusterStateCustomMap = Collections.unmodifiableMap(
        private Map<String, UploadedMetadataAttribute> clusterStateCustomMetadataMap;
            parser.declareNamedObject(
    }
            parser.declareNamedObject(
            if (this == o) return true;
        return manifestV2Builder(fields);
        public Builder discoveryNodesMetadata(UploadedMetadataAttribute discoveryNodesMetadata) {
            }
        public Builder templatesMetadata(UploadedMetadataAttribute templatesMetadata) {
            );
                ConstructingObjectParser.optionalConstructorArg(),
            declareParser(PARSER_V0, CODEC_V0);
        this.clusterTerm = in.readVLong();
        public String getUploadedFilename() {
            stateVersion,
                UPLOADED_CLUSTER_BLOCKS_METADATA
     */
        public Builder checksum(ClusterStateChecksum checksum) {
            this.opensearchVersion = opensearchVersion;
            this.customMetadataMap = customMetadataMap;
        private UploadedMetadataAttribute coordinationMetadata;
                getTemplatesMetadata().toXContent(builder, params);
            && Objects.equals(codecVersion, that.codecVersion)
            }
            .customMetadataMap(customMetadata(fields))
            );
        );
            && clusterTerm == that.clusterTerm
    }
        }
            && Objects.equals(uploadedTemplatesMetadata, that.uploadedTemplatesMetadata)
    );
        this.clusterUUIDCommitted = in.readBoolean();
        this.uploadedDiscoveryNodesMetadata = discoveryNodesMetadata;
        return uploadedCoordinationMetadata != null
    }
        }
    }
                builder.endObject();
            uploadedSettingsMetadata,
            this.uploadedCoordinationMetadata = null;
        private static final ConstructingObjectParser<UploadedIndexMetadata, Void> PARSER_V0 = new ConstructingObjectParser<>(
            .stateVersion(version(fields))
            parser.declareObject(
        parser.declareString(ConstructingObjectParser.constructorArg(), PREVIOUS_CLUSTER_UUID);
}
        private static final ParseField INDEX_UUID_FIELD = new ParseField("index_uuid");
        this.globalMetadataFileName = globalMetadataFileName;
        }
            {
        public int hashCode() {
    );
            parser.declareNamedObject(
                out.writeBoolean(true);
    public int getCodecVersion() {
    public UploadedMetadataAttribute getSettingsMetadata() {
            && Objects.equals(uploadedCoordinationMetadata, that.uploadedCoordinationMetadata)
                UploadedMetadataAttribute.PARSER,
            out.writeString(componentPrefix);
        return Objects.hash(
            .clusterTerm(term(fields))
        this.indices = Collections.unmodifiableList(in.readList(UploadedIndexMetadata::new));
            && Objects.equals(uploadedHashesOfConsistentSettings, that.uploadedHashesOfConsistentSettings)
        private static String indexUUID(Object[] fields) {
                builder.startObject(UPLOADED_CLUSTER_BLOCKS_METADATA.getPreferredName());
        declareParser(PARSER_V2, CODEC_V2);
    }
import java.util.HashMap;
                coordinationMetadata,
    private static Map<String, UploadedMetadataAttribute> clusterStateCustomMetadata(Object[] fields) {
    private final int codecVersion;
            if (version.onOrAfter(Version.V_2_10_0) && version.before(Version.V_2_12_0)) {
    private static final ParseField INDICES_FIELD = new ParseField("indices");
        int codecVersion,
            }
    public String getGlobalMetadataFileName() {
            return getAttributeName();
                this.uploadedClusterBlocksMetadata = null;
        }
        }
            return this;
            }
        UploadedMetadataAttribute uploadedCoordinationMetadata,
        return uploadedCustomMetadataMap;
                builder.endObject();
        private String clusterUUID;
            indicesRouting = new ArrayList<>();
    }
    public static class UploadedMetadataAttribute implements UploadedMetadata, Writeable, ToXContentFragment {
            if (codecVersion >= CODEC_V2) {
            return (String) fields[1];
            this.uploadedCoordinationMetadata = new UploadedMetadataAttribute(in);
        } else if (codec_version >= CODEC_V2) {
        private UploadedMetadataAttribute settingsMetadata;
        return (UploadedMetadataAttribute) fields[17];
            this.checksum = checksum;
        builder.field(CLUSTER_UUID_COMMITTED.getPreferredName(), isClusterUUIDCommitted());
    }
        public Builder opensearchVersion(Version opensearchVersion) {
                uploadedClusterBlocksMetadata.writeTo(out);
        }
            return this;
        }
        static {
                (Object[] parsedObject, String name) -> {
        {
            this.diffManifest = null;
        }
            uploadedDiscoveryNodesMetadata,
        private UploadedMetadataAttribute hashesOfConsistentSettings;
        }
    }
    }
        return (UploadedMetadataAttribute) fields[20];
            indices = new ArrayList<>();
            this.indicesRouting = null;
        }
         *
        this.clusterUUID = clusterUUID;
        private static final ParseField UPLOADED_FILENAME_FIELD = new ParseField("uploaded_filename");
            .codecVersion(CODEC_V0)
            if (codecVersion >= CODEC_V2) {
            }
            uploadedClusterStateCustomMap,
    private final Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap;
            metadataVersion,
            .routingTableVersion(routingTableVersion(fields))
        }
     *
            }
 */
    /**
                indicesRouting,
    }
        return diffManifest;
        declareParser(PARSER_V1, CODEC_V1);
            return this;
        "cluster_metadata_manifest",
        }
    public static final int CODEC_V1 = 1; // In Codec V1 we have introduced global-metadata and codec version in Manifest file.
        }
    private final long stateVersion;
    public long getRoutingTableVersion() {
            }
            .opensearchVersion(opensearchVersion(fields))
            if (getTemplatesMetadata() != null) {
        return indices;
    private static String previousClusterUUID(Object[] fields) {
            return new ClusterMetadataManifest(
                uploadedIndexMetadata.toXContent(builder, params);
            uploadedSettingsMetadata.writeTo(out);
            );
     * @opensearch.internal
    private final UploadedMetadataAttribute uploadedCoordinationMetadata;
    }
            this.templatesMetadata = manifest.uploadedTemplatesMetadata;
            this.routingTableVersion = routingTableVersion;
                uploadedDiscoveryNodesMetadata.writeTo(out);
        );
            && Objects.equals(clusterStateChecksum, that.clusterStateChecksum);
            this(indexName, indexUUID, uploadedFileName, componentPrefix, CODEC_V2);
                UPLOADED_CUSTOM_METADATA
            fields -> new UploadedIndexMetadata(indexName(fields), indexUUID(fields), uploadedFilename(fields))
    private static final ParseField UPLOADED_COORDINATOR_METADATA = new ParseField("uploaded_coordinator_metadata");
                UploadedMetadataAttribute.PARSER,
            }
                }
            this.indexName = indexName;
                nodeId,
                clusterUUIDCommitted,
                UploadedMetadataAttribute.PARSER,
        }
        }
    private static final ParseField UPLOADED_CLUSTER_BLOCKS_METADATA = new ParseField("uploaded_cluster_blocks_metadata");
    }
            this.clusterUUIDCommitted = clusterUUIDCommitted;
            && Objects.equals(clusterUUID, that.clusterUUID)
        return Objects.equals(indices, that.indices)
        private final String indexUUID;
        fields -> manifestV1Builder(fields).build()
        this.stateUUID = stateUUID;
            out.writeCollection(indicesRouting);
        long metadataVersion,
                this.codecVersion = CODEC_V0; // Default codec
        private static String indexName(Object[] fields) {
        if (out.getVersion().onOrAfter(Version.V_2_15_0)) {
            if (in.readBoolean()) {
        @Override
        }
        public Builder settingMetadata(UploadedMetadataAttribute settingsMetadata) {
        return (String) fields[11];
    private static List<UploadedIndexMetadata> indices(Object[] fields) {
            out.writeInt(codecVersion);
        if (in.getVersion().onOrAfter(Version.V_2_17_0) && in.readBoolean()) {
        boolean committed,
            this.clusterTerm = clusterTerm;
            }
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
            out.writeString(indexName);
        "cluster_metadata_manifest",
            clusterStateChecksum
                + attributeName
            codecVersion,
        if (this == o) {
            && Objects.equals(uploadedSettingsMetadata, that.uploadedSettingsMetadata)
        public UploadedMetadataAttribute(StreamInput in) throws IOException {
        out.writeVLong(clusterTerm);
        return uploadedTransientSettingsMetadata;
                clusterUUID,
        "cluster_metadata_manifest",
            && Objects.equals(uploadedTransientSettingsMetadata, that.uploadedTransientSettingsMetadata)
    }
            this.committed = committed;
    private final UploadedMetadataAttribute uploadedTransientSettingsMetadata;
        private static final ParseField UPLOADED_FILENAME_FIELD = new ParseField("uploaded_filename");
                return CURRENT_PARSER.parse(parser, null);
                UploadedMetadataAttribute.PARSER,
        }
        parser.declareLong(ConstructingObjectParser.constructorArg(), CLUSTER_TERM_FIELD);
        }
                clusterStateChecksum.writeTo(out);
        }
            this(indexName, indexUUID, uploadedFileName, CODEC_V2);
            out.writeString(attributeName);
                    builder.startObject();
                out.writeBoolean(true);
            if (getCoordinationMetadata() != null) {
        }
import java.util.Map;
            out.writeLong(metadataVersion);
            long codecVersion
            parser.declareObjectArray(
        return (UploadedMetadataAttribute) fields[18];
        public Builder clusterUUIDCommitted(boolean clusterUUIDCommitted) {
                builder.startObject(UPLOADED_TRANSIENT_SETTINGS_METADATA.getPreferredName());
        this.nodeId = in.readString();
        this.clusterTerm = clusterTerm;
        );
        }
 *
package org.opensearch.gateway.remote;
        declareParser(PARSER_V0, CODEC_V0);
    private static final ParseField NODE_ID_FIELD = new ParseField("node_id");
        }
        List<UploadedIndexMetadata> indices,
        public String getComponentPrefix() {
    public String getStateUUID() {
            .clusterUUIDCommitted(clusterUUIDCommitted(fields));
            .indicesRouting(indicesRouting(fields))
                + '\''
    private static UploadedMetadataAttribute discoveryNodesMetadata(Object[] fields) {
    }
        boolean clusterUUIDCommitted,
        return clusterUUIDCommitted;
    public static final int CODEC_V4 = 4; // In Codec V4, we have removed upserts and delete field for routing table in diff manifest and
    private final List<UploadedIndexMetadata> indices;
        /**
            return this;
            globalMetadataFileName,
                ConstructingObjectParser.optionalConstructorArg(),
            && Objects.equals(nodeId, that.nodeId)
        );
    }
    private static boolean clusterUUIDCommitted(Object[] fields) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return customs.stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()));
        }
    private static final ParseField OPENSEARCH_VERSION_FIELD = new ParseField("opensearch_version");
            } else if (version.onOrAfter(Version.V_2_16_0) && version.before(Version.V_2_17_0)) {
            );
    }
            .discoveryNodesMetadata(discoveryNodesMetadata(fields))
        return manifestV0Builder(fields).codecVersion(codecVersion(fields))
            this.clusterUUID = manifest.clusterUUID;
            } else {
        }
        String nodeId,
            } else {
                (p, c) -> UploadedIndexMetadata.fromXContent(p, codec_version),
            );
        }
            return this;
    }
    /**
        this.indices = Collections.unmodifiableList(indices);
                DIFF_MANIFEST
            return uploadedFilename;
 * The OpenSearch Contributors require contributions made to
        this.uploadedClusterBlocksMetadata = clusterBlocksMetadata;
            clusterUUIDCommitted,
     */
        this.clusterUUIDCommitted = clusterUUIDCommitted;
            this.metadataVersion = in.readLong();
    private static long version(Object[] fields) {
            } else {
                ConstructingObjectParser.optionalConstructorArg(),
            .field(NODE_ID_FIELD.getPreferredName(), getNodeId())
            if (in.readBoolean()) {
                this.globalMetadataFileName = in.readString();
            } else if (version.onOrAfter(Version.V_2_12_0) && version.before(Version.V_2_15_0)) {
    public ClusterMetadataManifest(
    private static int codecVersion(Object[] fields) {
            this.globalMetadataFileName = globalMetadataFileName;
    public static ClusterMetadataManifest fromXContentV0(XContentParser parser) throws IOException {
            if (getDiscoveryNodesMetadata() != null) {
                UPLOADED_COORDINATOR_METADATA
    private static final ParseField UPLOADED_TRANSIENT_SETTINGS_METADATA = new ParseField("uploaded_transient_settings_metadata");
    public boolean isClusterUUIDCommitted() {
        Map<Version, Integer> versionToCodecMapping = new HashMap<>();
                diffManifest,
    public static final int MANIFEST_CURRENT_CODEC_VERSION = CODEC_V4;
 * compatible open source license.
            || uploadedTemplatesMetadata != null
            this.codecVersion = in.readInt();
                UploadedMetadataAttribute.PARSER,
            if (in.readBoolean()) {
            if (diffManifest != null) {
        this.indicesRouting = Collections.unmodifiableList(indicesRouting);
import org.opensearch.core.xcontent.ConstructingObjectParser;
                + uploadedFilename
        public UploadedIndexMetadata(
        return uploadedClusterStateCustomMap;
    }
                + '}';
        private String nodeId;
                builder.startObject(UPLOADED_HASHES_OF_CONSISTENT_SETTINGS_METADATA.getPreferredName());
            this.settingsMetadata = settingsMetadata;
    }
        Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap,
        UploadedMetadataAttribute uploadedTemplatesMetadata,
            this.indexName = in.readString();
        return metadataVersion;
        }
            out.writeMap(uploadedClusterStateCustomMap, StreamOutput::writeString, (o, v) -> v.writeTo(o));
        List<UploadedIndexMetadata> indicesRouting,
        public String getUploadedFilePath() {
        this.uploadedCustomMetadataMap = Collections.unmodifiableMap(
    }
                builder.endObject();
            return (String) fields[0];
            return true;
        builder.field(PREVIOUS_CLUSTER_UUID.getPreferredName(), getPreviousClusterUUID());
