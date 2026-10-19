        "cluster_metadata_manifest",
        this.diffManifest = diffManifest;
        return customs.stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()));  
                metadataVersion,
            uploadedClusterStateCustomMap != null ? uploadedClusterStateCustomMap : new HashMap<>()
            return true;
            this.uploadedFilename = uploadedFilename;  
            } else {
            this.settingsMetadata = settingsMetadata;
            this.metadataVersion = -1;  
        public static UploadedIndexMetadata fromXContent(XContentParser parser, long codecVersion) throws IOException {
            if (o == null || getClass() != o.getClass()) {  
            && Objects.equals(codecVersion, that.codecVersion)  
                this.uploadedClusterBlocksMetadata = new UploadedMetadataAttribute(in);  
                getClusterBlocksMetadata().toXContent(builder, params);
     * Metadata for uploaded metadata attribute  
    }
    private final boolean committed;
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V4);
        this.clusterUUIDCommitted = clusterUUIDCommitted;  
    private final long routingTableVersion;
    public ClusterMetadataManifest(StreamInput in) throws IOException {  
        String getUploadedFilename();  
                this.uploadedDiscoveryNodesMetadata = null;  
        }
        }
        return PARSER_V3.parse(parser, null);
import java.util.List;
            return Objects.equals(indexName, that.indexName)
            return new ClusterMetadataManifest(  
        return (long) fields[0];
            .discoveryNodesMetadata(discoveryNodesMetadata(fields))
        return indicesRouting;
     * @opensearch.internal  
        private static final ConstructingObjectParser<UploadedIndexMetadata, Void> PARSER_V2 = new ConstructingObjectParser<>(  
            return Objects.equals(attributeName, that.attributeName) && Objects.equals(uploadedFilename, that.uploadedFilename);
            innerParser.declareString(ConstructingObjectParser.constructorArg(), UPLOADED_FILENAME_FIELD);  
        Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap,  
 * compatible open source license.
        }  
            || uploadedTemplatesMetadata != null
            return indexName;
        }
    public static ClusterMetadataManifest fromXContentV1(XContentParser parser) throws IOException {
    private final UploadedMetadataAttribute uploadedSettingsMetadata;  
            customMetadataMap = new HashMap<>();
    private static long version(Object[] fields) {
            .field(STATE_UUID_FIELD.getPreferredName(), getStateUUID())
        public Builder coordinationMetadata(UploadedMetadataAttribute coordinationMetadata) {
            parser.declareInt(ConstructingObjectParser.constructorArg(), CODEC_VERSION_FIELD);
            && Objects.equals(uploadedDiscoveryNodesMetadata, that.uploadedDiscoveryNodesMetadata)
        this.globalMetadataFileName = globalMetadataFileName;  
            this(indexName, indexUUID, uploadedFileName, CODEC_V2);  
            this.diffManifest = diffManifest;  
        );  
            this.componentPrefix = componentPrefix;  
        @Override  
            parser.declareObject(
            this.routingTableVersion = routingTableVersion;
                stateUUID,
                this.diffManifest = null;
        public Builder codecVersion(int codecVersion) {
                out.writeBoolean(true);
        fields -> manifestV1Builder(fields).build()  
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V0);
    private final UploadedMetadataAttribute uploadedDiscoveryNodesMetadata;
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
    private static boolean clusterUUIDCommitted(Object[] fields) {
        return manifestV2Builder(fields);  
    @Override
    }
    );
            ConstructingObjectParser.constructorArg(),
        long version,
        ) {
            if (getClusterBlocksMetadata() != null) {  
            } else if (version.onOrAfter(Version.V_2_17_0)) {  
            this.indicesRouting = indicesRouting;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     *
            this.uploadedFilename = in.readString();
            if (codecVersion >= CODEC_V2) {  
            return this;
        }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            this.routingTableVersion = manifest.routingTableVersion;  
            if (this == o) return true;
        @Override
    private static void declareParser(ConstructingObjectParser<ClusterMetadataManifest, Void> parser, long codec_version) {
            this.templatesMetadata = manifest.uploadedTemplatesMetadata;  
    public Version getOpensearchVersion() {
            return this;
                UploadedMetadataAttribute.PARSER,
            this.uploadedCustomMetadataMap = null;  
            parser.declareNamedObject(
    }
            this.clusterTerm = clusterTerm;
            }
            }
            parser.declareNamedObject(  
    private static UploadedMetadataAttribute hashesOfConsistentSettings(Object[] fields) {  
            this.clusterUUID = manifest.clusterUUID;
        private List<UploadedIndexMetadata> indicesRouting;  
    public String getClusterUUID() {  
            if (uploadedHashesOfConsistentSettings != null) {
                + uploadedFilename
    private final String globalMetadataFileName;
            }
        }  
    private static final ParseField OPENSEARCH_VERSION_FIELD = new ParseField("opensearch_version");
    }
            );  
        parser.declareLong(ConstructingObjectParser.constructorArg(), CLUSTER_TERM_FIELD);  
        public String getComponentPrefix() {
        private final String indexUUID;  
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> CURRENT_PARSER = PARSER_V4;  
                clusterBlocksMetadata,  
        }
        return (boolean) fields[9];
            if (getTemplatesMetadata() != null) {
        this.stateVersion = in.readVLong();
    private final UploadedMetadataAttribute uploadedClusterBlocksMetadata;  
        @Override  
    private static final ParseField UPLOADED_CLUSTER_BLOCKS_METADATA = new ParseField("uploaded_cluster_blocks_metadata");  
        public Builder clusterStateCustomMetadataMap(Map<String, UploadedMetadataAttribute> clusterStateCustomMetadataMap) {  
        }
            return this;
    }  
        return uploadedSettingsMetadata;
            committed,
            && Objects.equals(previousClusterUUID, that.previousClusterUUID)  
                CHECKSUM
 * SPDX-License-Identifier: Apache-2.0
        return Strings.toString(MediaTypeRegistry.JSON, this);  
            || !uploadedCustomMetadataMap.isEmpty();  
    private final long clusterTerm;
            );
        public Builder stateUUID(String stateUUID) {  
        }
        String previousClusterUUID,
            );
        return (boolean) fields[6];
            }
    public long getRoutingTableVersion() {  
            && Objects.equals(clusterUUID, that.clusterUUID)
            this(indexName, indexUUID, uploadedFileName, COMPONENT_PREFIX, codecVersion);
        }
        return Objects.equals(indices, that.indices)
            this.codecVersion = manifest.codecVersion;
        }
    }  
        return opensearchVersion;  
                builder.startObject(UPLOADED_CLUSTER_BLOCKS_METADATA.getPreferredName());
    private static ClusterMetadataManifest.Builder manifestV3Builder(Object[] fields) {
    public List<UploadedIndexMetadata> getIndices() {  
        }  
            }  
            return Strings.toString(MediaTypeRegistry.JSON, this);
        return Version.fromId((int) fields[4]);  
            indicesRouting,  
    public int getCodecVersion() {
    }
        if (codec_version == CODEC_V1) {  
            parser.declareInt(ConstructingObjectParser.constructorArg(), CODEC_VERSION_FIELD);
            this.diffManifest = null;
        out.writeCollection(indices);
            );
        public int hashCode() {
        @Override
    private static String previousClusterUUID(Object[] fields) {  
                this.globalMetadataFileName = in.readString();
                UploadedMetadataAttribute.PARSER,
            this.uploadedClusterBlocksMetadata = null;
                indicesRouting,  
        }
    }
        return uploadedCoordinationMetadata;
    }
    }  
                in.readMap(StreamInput::readString, UploadedMetadataAttribute::new)  
        if (onOrAfterCodecVersion(CODEC_V2)) {
        private String previousClusterUUID;
    public static final int CODEC_V3 = 3; // In Codec V3, we have introduced new diff field in diff-manifest's routing_table_diff
            return this;
                builder.endObject();
            this.uploadedTemplatesMetadata = null;
            this.transientSettingsMetadata = settingsMetadata;  
    /**
            .customMetadataMap(customMetadata(fields))
    }
                true,  
        private static String uploadedFilename(Object[] fields) {
                settingsMetadata,
    private static ClusterMetadataManifest.Builder manifestV1Builder(Object[] fields) {
            return this;  
        }
     */
                builder.startObject(UPLOADED_DISCOVERY_NODES_METADATA.getPreferredName());
        return uploadedClusterBlocksMetadata;
        this.uploadedCoordinationMetadata = uploadedCoordinationMetadata;  
        this.previousClusterUUID = in.readString();  
                diffManifest.writeTo(out);
            } else {
            return this;
            parser.declareString(ConstructingObjectParser.constructorArg(), UPLOADED_FILENAME_FIELD);  
                UPLOADED_TRANSIENT_SETTINGS_METADATA  
    private static final ParseField UPLOADED_CUSTOM_METADATA = new ParseField("uploaded_custom_metadata");  
        ClusterStateChecksum clusterStateChecksum
    // required for state publication  
                    uploadedIndexMetadata.toXContent(builder, params);
        return PARSER_V1.parse(parser, null);  
        /**  
            nodeId,
    private static String stateUUID(Object[] fields) {
            if (getHashesOfConsistentSettings() != null) {
        return manifestV0Builder(fields).codecVersion(codecVersion(fields))
    private final String previousClusterUUID;
            .field(CLUSTER_UUID_FIELD.getPreferredName(), getClusterUUID())
            } else {
        }
        private long clusterTerm;
            return this;  
    }
        );
            .committed(committed(fields))
            return this;  
    }
        return ClusterMetadataManifest.builder()  
    private ClusterStateChecksum clusterStateChecksum;
        private UploadedMetadataAttribute coordinationMetadata;
        this.uploadedSettingsMetadata = uploadedSettingsMetadata;
        private static final ConstructingObjectParser<UploadedIndexMetadata, Void> PARSER_V0 = new ConstructingObjectParser<>(
        return Objects.hash(
    private final List<UploadedIndexMetadata> indicesRouting;
    private static final ParseField ROUTING_TABLE_VERSION_FIELD = new ParseField("routing_table_version");
        return VERSION_TO_CODEC_MAPPING.getOrDefault(version, -1);
                .field(INDEX_UUID_FIELD.getPreferredName(), getIndexUUID())  
            uploadedCustomMetadataMap,
            this.clusterStateCustomMetadataMap = clusterStateCustomMetadataMap;
                builder.startObject(UPLOADED_HASHES_OF_CONSISTENT_SETTINGS_METADATA.getPreferredName());
            uploadedTransientSettingsMetadata,
            return this;
     */  
            return componentPrefix;  
        private static String indexUUID(Object[] fields) {
        private UploadedMetadataAttribute clusterBlocksMetadata;  
    }
            String indexUUID,
    }  
import org.opensearch.core.common.io.stream.Writeable;  
        public boolean equals(Object o) {
            || uploadedSettingsMetadata != null
     * Interface representing uploaded metadata  
                UploadedMetadataAttribute.PARSER,  
    private static String globalMetadataFileName(Object[] fields) {  
                opensearchVersion,
    }
                ConstructingObjectParser.optionalConstructorArg(),
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V2);  
                getDiffManifest().toXContent(builder, params);  
            this.attributeName = in.readString();
            clusterStateCustomMetadataMap = new HashMap<>();
    private static ClusterMetadataManifest.Builder manifestV0Builder(Object[] fields) {
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V4 = new ConstructingObjectParser<>(
        public String getUploadedFilePath() {
import org.opensearch.Version;
        return PARSER_V2.parse(parser, null);
        return routingTableVersion;
import java.util.Objects;  
            if (this == o) {  
        }
        this.uploadedTransientSettingsMetadata = uploadedTransientSettingsMetadata;
        }  
                (Object[] parsedObject, String name) -> {
        this.uploadedClusterBlocksMetadata = clusterBlocksMetadata;
        fields -> manifestV2Builder(fields).build()
                getTransientSettingsMetadata().toXContent(builder, params);
        return metadataVersion;
        private final String attributeName;
        public String getComponent() {
        return PARSER_V0.parse(parser, null);
        for (Version version : Version.getDeclaredVersions(Version.class)) {  
            return uploadedFilename;  
        public Builder committed(boolean committed) {  
                    builder.endObject();  
    @Override
        }
        this.indices = Collections.unmodifiableList(in.readList(UploadedIndexMetadata::new));
        @Override  
            this.uploadedClusterStateCustomMap = null;  
        return diffManifest;  
            }
        "cluster_metadata_manifest",  
         *
    }  
    }  
        public String getIndexName() {  
        public String getUploadedFilename() {
        VERSION_TO_CODEC_MAPPING = Collections.unmodifiableMap(versionToCodecMapping);
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V2 = new ConstructingObjectParser<>(  
    private final List<UploadedIndexMetadata> indices;  
        }  
            );
            parser.declareString(ConstructingObjectParser.constructorArg(), GLOBAL_METADATA_FIELD);
    public static final int CODEC_V0 = 0; // Older codec version, where we haven't introduced codec versions for manifest.
        }
        }  
            this.uploadedFilename = in.readString();
            this.routingTableVersion = in.readLong();  
    }
    /**  
            out.writeInt(codecVersion);
            this.metadataVersion = metadataVersion;  
        }
    }
        this.metadataVersion = metadataVersion;  
        return uploadedTransientSettingsMetadata;  
        @Override
            );
        this.uploadedClusterStateCustomMap = Collections.unmodifiableMap(  
    }
                (p, c) -> UploadedIndexMetadata.fromXContent(p, codec_version),
        return (UploadedMetadataAttribute) fields[20];  
        return uploadedClusterStateCustomMap;
            if (codecVersion >= CODEC_V2) {
            .settingMetadata(settingsMetadata(fields))  
    }  
        public Builder clusterUUIDCommitted(boolean clusterUUIDCommitted) {  
    private static final ParseField NODE_ID_FIELD = new ParseField("node_id");
        return manifestV3Builder(fields).checksum(checksum(fields));
    private final Version opensearchVersion;
        return (String) fields[5];
    private static UploadedMetadataAttribute clusterBlocksMetadata(Object[] fields) {  
            this.indicesRouting = Collections.unmodifiableList(in.readList(UploadedIndexMetadata::new));
    }
            out.writeString(uploadedFilename);  
            this.uploadedCoordinationMetadata = new UploadedMetadataAttribute(in);
        return (String) fields[2];
                globalMetadataFileName,  
        int codecVersion,
            return this;  
                INDICES_ROUTING_FIELD
            fields -> new UploadedIndexMetadata(indexName(fields), indexUUID(fields), uploadedFilename(fields))  
                .field(UPLOADED_FILENAME_FIELD.getPreferredName(), getUploadedFilename())  
            .codecVersion(CODEC_V0)
        this.nodeId = nodeId;  
            .metadataVersion(metadataVersion(fields))
    }
    public static final int[] CODEC_VERSIONS = { CODEC_V0, CODEC_V1, CODEC_V2, CODEC_V3, CODEC_V4 };
            this(indexName, indexUUID, uploadedFileName, componentPrefix, CODEC_V2);
        }
    public int hashCode() {  
                return true;
            return "UploadedMetadataAttribute{"
        }  
            out.writeLong(metadataVersion);  
            this.indexName = indexName;
                clusterStateCustomMetadataMap,  
            this.clusterUUIDCommitted = clusterUUIDCommitted;
            .opensearchVersion(opensearchVersion(fields))
        }
            this.stateUUID = manifest.stateUUID;
            codecVersion,
                getCoordinationMetadata().toXContent(builder, params);  
        @Override  
    }  
    private final UploadedMetadataAttribute uploadedCoordinationMetadata;
                out.writeBoolean(true);
                .endObject();
        @Override  
            this.stateVersion = stateVersion;  
        long clusterTerm,
            } else if (version.onOrAfter(Version.V_2_16_0) && version.before(Version.V_2_17_0)) {
            return (String) fields[3];
            String uploadedFileName,
        }  
            this.clusterStateCustomMetadataMap = manifest.uploadedClusterStateCustomMap;
            for (UploadedIndexMetadata uploadedIndexMetadata : indices) {
                UPLOADED_SETTINGS_METADATA
        List<UploadedMetadataAttribute> customs = (List<UploadedMetadataAttribute>) fields[22];
        this.clusterTerm = clusterTerm;
        }
        }
        return (long) fields[1];  
        return uploadedDiscoveryNodesMetadata;
            "uploaded_index_metadata",
            clusterStateChecksum = new ClusterStateChecksum(in);  
                UploadedMetadataAttribute.PARSER,
        return (ClusterStateChecksum) fields[24];
            "uploaded_index_metadata",
            this.uploadedHashesOfConsistentSettings = null;
        }
                }
        String getComponent();
    private final ClusterStateDiffManifest diffManifest;  
    private static String nodeId(Object[] fields) {  
        public Builder routingTableVersion(long routingTableVersion) {  
                in.readMap(StreamInput::readString, UploadedMetadataAttribute::new)  
                    return new UploadedMetadataAttribute(name, uploadedFilename);  
        public Builder opensearchVersion(Version opensearchVersion) {
            }  
            .indicesRouting(indicesRouting(fields))
            builder.startObject(UPLOADED_CUSTOM_METADATA.getPreferredName());
import org.opensearch.core.xcontent.ObjectParser;  
        return stateVersion;  
    }  
        private String globalMetadataFileName;
        declareParser(PARSER_V3, CODEC_V3);
            uploadedTemplatesMetadata.writeTo(out);
    private static ClusterMetadataManifest.Builder manifestV4Builder(Object[] fields) {  
            return this;
        public String getUploadedFilename() {
        this.uploadedTemplatesMetadata = uploadedTemplatesMetadata;
        );
            for (UploadedMetadataAttribute attribute : getCustomMetadataMap().values()) {
            this.customMetadataMap = manifest.uploadedCustomMetadataMap;
            }  
            return attributeName;  
            return (String) fields[2];  
        out.writeVLong(stateVersion);
                builder.startObject(UPLOADED_SETTINGS_METADATA.getPreferredName());
import org.opensearch.core.xcontent.XContentBuilder;
        this.codecVersion = codecVersion;
        private final String componentPrefix;
        public String getIndexUUID() {
            out.writeLong(routingTableVersion);
        "cluster_metadata_manifest",  
    private static List<UploadedIndexMetadata> indices(Object[] fields) {
            ConstructingObjectParser<UploadedMetadataAttribute, String> innerParser = new ConstructingObjectParser<>(
        );
        Version opensearchVersion,
        this.uploadedDiscoveryNodesMetadata = discoveryNodesMetadata;  
        public int hashCode() {
        public UploadedIndexMetadata(String indexName, String indexUUID, String uploadedFileName) {
        }
     * @opensearch.internal
        return (List<UploadedIndexMetadata>) fields[16];
            this.nodeId = manifest.nodeId;
    private static final ParseField CODEC_VERSION_FIELD = new ParseField("codec_version");
        parser.declareBoolean(ConstructingObjectParser.constructorArg(), CLUSTER_UUID_COMMITTED);
            this.diffManifest = manifest.diffManifest;
 *
            this.previousClusterUUID = manifest.previousClusterUUID;
    private static final ParseField UPLOADED_DISCOVERY_NODES_METADATA = new ParseField("uploaded_discovery_nodes_metadata");
            .field(NODE_ID_FIELD.getPreferredName(), getNodeId())
            return this;  
import java.util.Arrays;
            .clusterBlocksMetadata(clusterBlocksMetadata(fields))  
    }  
    public UploadedMetadataAttribute getSettingsMetadata() {
        }
            builder.field(ROUTING_TABLE_VERSION_FIELD.getPreferredName(), getRoutingTableVersion());  
        } else if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
            && Objects.equals(metadataVersion, that.metadataVersion)
                UPLOADED_CLUSTER_BLOCKS_METADATA  
    @Override  
        public ClusterMetadataManifest build() {
    private static final ParseField UPLOADED_HASHES_OF_CONSISTENT_SETTINGS_METADATA = new ParseField(
            if (version.onOrAfter(Version.V_2_10_0) && version.before(Version.V_2_12_0)) {
            && Objects.equals(uploadedClusterBlocksMetadata, that.uploadedClusterBlocksMetadata)  
 * Manifest file which contains the details of the uploaded entity metadata
                }
                UPLOADED_COORDINATOR_METADATA
                ConstructingObjectParser.optionalConstructorArg(),
    }
            this.opensearchVersion = manifest.opensearchVersion;  
            this.globalMetadataFileName = manifest.globalMetadataFileName;  
    public UploadedMetadataAttribute getCoordinationMetadata() {  
            }  
    }
     *
        @Override  
            builder.field(METADATA_VERSION.getPreferredName(), getMetadataVersion());  
            }  
        this.stateUUID = in.readString();
         *  
import java.util.stream.Collectors;
            return this;
        private Map<String, UploadedMetadataAttribute> clusterStateCustomMetadataMap;  
    }
            uploadedDiscoveryNodesMetadata,  
                builder.endObject();
            if (in.readBoolean()) {
            long codecVersion
    public static class Builder {
    public UploadedMetadataAttribute getDiscoveryNodesMetadata() {  
            this.globalMetadataFileName = globalMetadataFileName;
            .field(STATE_VERSION_FIELD.getPreferredName(), getStateVersion())  
            parser.declareString(ConstructingObjectParser.constructorArg(), INDEX_NAME_FIELD);
            this.clusterBlocksMetadata = manifest.uploadedClusterBlocksMetadata;  
            if (getClusterStateChecksum() != null) {
                UPLOADED_DISCOVERY_NODES_METADATA
            globalMetadataFileName,  
                uploadedHashesOfConsistentSettings.writeTo(out);  
        this.previousClusterUUID = previousClusterUUID;
            .coordinationMetadata(coordinationMetadata(fields))
            .routingTableVersion(routingTableVersion(fields))  
    }  
        }
        }
            && Objects.equals(opensearchVersion, that.opensearchVersion)  
            this.codecVersion = in.readInt();
    );
        out.writeString(stateUUID);  
            );
        private long stateVersion;  
                (p, c) -> ClusterStateDiffManifest.fromXContent(p, codec_version),
    }
        this.routingTableVersion = routingTableVersion;
    }
                ConstructingObjectParser.optionalConstructorArg(),  
                out.writeBoolean(false);
            .previousClusterUUID(previousClusterUUID(fields))
                + '\''
            String componentPrefix,  
            }
            return this;
            this.uploadedClusterStateCustomMap = Collections.unmodifiableMap(
                out.writeBoolean(false);
        this.clusterTerm = in.readVLong();
        }
            stateUUID,
    );
        } else if (onOrAfterCodecVersion(CODEC_V1)) {
        public Builder transientSettingsMetadata(UploadedMetadataAttribute settingsMetadata) {
    );  
            this.stateUUID = stateUUID;
        private static final ObjectParser.NamedObjectParser<UploadedMetadataAttribute, Void> PARSER;
                ConstructingObjectParser.optionalConstructorArg(),
         */
        declareParser(PARSER_V4, CODEC_V4);
            } else {
        public String getComponent() {
        UploadedMetadataAttribute clusterBlocksMetadata,  
                clusterTerm,
        public boolean equals(Object o) {  
        if (codec_version >= CODEC_V4) {  
            this.clusterUUIDCommitted = manifest.clusterUUIDCommitted;
    private final Map<String, UploadedMetadataAttribute> uploadedClusterStateCustomMap;
            routingTableVersion,
        private long metadataVersion;
                UPLOADED_CUSTOM_METADATA
    private static final ParseField CHECKSUM = new ParseField("checksum");  
                out.writeBoolean(true);  
    }  
        return (ClusterStateDiffManifest) fields[23];
    }
            return this;  
        private UploadedMetadataAttribute transientSettingsMetadata;
            metadataVersion,
            uploadedClusterStateCustomMap,
            INDICES_FIELD
        }
        boolean clusterUUIDCommitted,  
        public Builder metadataVersion(long metadataVersion) {
        }
    public UploadedMetadataAttribute getHashesOfConsistentSettings() {
            } else {
            this.clusterUUID = clusterUUID;
    private final String nodeId;  
            parser.declareNamedObject(  
            indicesRouting = new ArrayList<>();  
            this.uploadedCoordinationMetadata = null;  
            this.indexUUID = indexUUID;
            .stateUUID(stateUUID(fields))
    private final Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap;
            out.writeString(componentPrefix);
    }
        builder.field(CLUSTER_UUID_COMMITTED.getPreferredName(), isClusterUUIDCommitted());
            }
    }  
            return this;
            }
                getDiscoveryNodesMetadata().toXContent(builder, params);  
    }
            this.stateVersion = manifest.stateVersion;  
                DIFF_MANIFEST  
        } else if (codec_version >= CODEC_V2) {  
        } else {
 *  
    }  
    }
        UploadedMetadataAttribute uploadedTransientSettingsMetadata,
        return (List<UploadedIndexMetadata>) fields[7];  
            return Objects.hash(indexName, indexUUID, uploadedFilename, componentPrefix);  
        private boolean committed;  
            this.hashesOfConsistentSettings = manifest.uploadedHashesOfConsistentSettings;  
            this.globalMetadataFileName = null;
            uploadedSettingsMetadata,
        this.uploadedHashesOfConsistentSettings = uploadedHashesOfConsistentSettings;
        out.writeBoolean(committed);  
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V0 = new ConstructingObjectParser<>(
    // also we introduce index routing-metadata, diff and other attributes as part of manifest
            }  
            this.codecVersion = codecVersion;
    public String getPreviousClusterUUID() {
            .diffManifest(diffManifest(fields))
            }  
    public static ClusterMetadataManifest fromXContent(XContentParser parser) throws IOException {
                && Objects.equals(componentPrefix, that.componentPrefix);
                this.uploadedTransientSettingsMetadata = null;
    private static Map<String, UploadedMetadataAttribute> customMetadata(Object[] fields) {
                stateVersion,
        parser.declareString(ConstructingObjectParser.constructorArg(), PREVIOUS_CLUSTER_UUID);  
        }
            && Objects.equals(diffManifest, that.diffManifest)
                this.uploadedClusterBlocksMetadata = null;
    }  
        private UploadedMetadataAttribute settingsMetadata;  
            }
    }
    public long getMetadataVersion() {
            && Objects.equals(uploadedTemplatesMetadata, that.uploadedTemplatesMetadata)
    }  
        private static final ParseField INDEX_NAME_FIELD = new ParseField("index_name");
            .clusterUUID(clusterUUID(fields))  
        return customs.stream().collect(Collectors.toMap(UploadedMetadataAttribute::getAttributeName, Function.identity()));  
        ClusterStateDiffManifest diffManifest,
        declareParser(PARSER_V2, CODEC_V2);  
    }
        private static final ParseField INDEX_UUID_FIELD = new ParseField("index_uuid");
    private final String stateUUID;
        private ClusterStateDiffManifest diffManifest;
        private static String indexName(Object[] fields) {  
            && Objects.equals(committed, that.committed)
        return manifestV0Builder(fields).codecVersion(codecVersion(fields)).globalMetadataFileName(globalMetadataFileName(fields));  
 */  
import java.util.function.Function;
            return Objects.hash(attributeName, uploadedFilename);  
    public String toString() {
            && Objects.equals(uploadedHashesOfConsistentSettings, that.uploadedHashesOfConsistentSettings)
            return (String) fields[1];
}  
            .clusterStateCustomMetadataMap(clusterStateCustomMetadata(fields));
        "cluster_metadata_manifest",
        this.uploadedCustomMetadataMap = Collections.unmodifiableMap(  
            return this;
                customMetadataMap,
            out.writeString(indexUUID);
        this.clusterUUID = clusterUUID;  
    }
        private final String uploadedFilename;
            this.clusterBlocksMetadata = clusterBlocksMetadata;
            out.writeMap(uploadedCustomMetadataMap, StreamOutput::writeString, (o, v) -> v.writeTo(o));  
            return this;
    public static Builder builder() {
                                          // added checksum of cluster state.  
                builder.endObject();
                this.globalMetadataFileName = null;
            this.indicesRouting = new ArrayList<>(manifest.indicesRouting);
    private static long metadataVersion(Object[] fields) {
                uploadedDiscoveryNodesMetadata.writeTo(out);  
        }
    private final long stateVersion;
    }
        public UploadedIndexMetadata(String indexName, String indexUUID, String uploadedFileName, long codecVersion) {  
        public Builder customMetadataMap(Map<String, UploadedMetadataAttribute> customMetadataMap) {
        List<UploadedMetadataAttribute> customs = (List<UploadedMetadataAttribute>) fields[14];
    public List<UploadedIndexMetadata> getIndicesRouting() {
 * The OpenSearch Contributors require contributions made to  
            this.checksum = manifest.clusterStateChecksum;
        }
    }  
        }
                UploadedMetadataAttribute.PARSER,
    private static final ParseField CLUSTER_TERM_FIELD = new ParseField("cluster_term");  
                builder.field(COMPONENT_PREFIX_FIELD.getPreferredName(), getComponentPrefix());  
    private static final ParseField UPLOADED_CLUSTER_STATE_CUSTOM_METADATA = new ParseField("uploaded_cluster_state_custom_metadata");
    }
                builder.endObject();
            this.committed = manifest.committed;
     *
            if (getCoordinationMetadata() != null) {
        private boolean clusterUUIDCommitted;
            builder.startArray(INDICES_ROUTING_FIELD.getPreferredName());
            return indices;  
            builder.endObject();
                UploadedMetadataAttribute.PARSER,
                templatesMetadata,  
        out.writeBoolean(clusterUUIDCommitted);  
        public Builder globalMetadataFileName(String globalMetadataFileName) {  
import org.opensearch.core.common.io.stream.StreamOutput;
            return builder.startObject(getAttributeName())
                ConstructingObjectParser.constructorArg(),  
                ConstructingObjectParser.optionalConstructorArg(),  
import java.util.HashMap;  
                builder.endObject();  
    /**  
            } else {
        return clusterUUIDCommitted;
        }  
                builder.startObject(UPLOADED_COORDINATOR_METADATA.getPreferredName());
    private static final ParseField STATE_VERSION_FIELD = new ParseField("state_version");
        this.indices = Collections.unmodifiableList(indices);
    }
        private UploadedMetadataAttribute hashesOfConsistentSettings;
        private List<UploadedIndexMetadata> indices;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                getSettingsMetadata().toXContent(builder, params);
    private static UploadedMetadataAttribute discoveryNodesMetadata(Object[] fields) {
        long routingTableVersion,
    private static String clusterUUID(Object[] fields) {  
        );
            builder.startObject(UPLOADED_CLUSTER_STATE_CUSTOM_METADATA.getPreferredName());  
        Map<String, UploadedMetadataAttribute> uploadedCustomMetadataMap,
            this.indexUUID = in.readString();  
            .templatesMetadata(templatesMetadata(fields))
            && Objects.equals(globalMetadataFileName, that.globalMetadataFileName)
            return this;  
            this.uploadedSettingsMetadata = null;
        }  
    private static final ParseField COMMITTED_FIELD = new ParseField("committed");  
            .field(COMMITTED_FIELD.getPreferredName(), isCommitted());
        this.committed = committed;
            );
            String indexName,  
        public UploadedIndexMetadata(StreamInput in) throws IOException {
                nodeId,  
        boolean committed,
                this.uploadedTransientSettingsMetadata = new UploadedMetadataAttribute(in);
                builder.startObject(CHECKSUM.getPreferredName());
        private static final ParseField UPLOADED_FILENAME_FIELD = new ParseField("uploaded_filename");  
     */
        }
            && Objects.equals(clusterUUIDCommitted, that.clusterUUIDCommitted)
        public Builder indices(List<UploadedIndexMetadata> indices) {
    }  
                builder.endObject();  
    }  
        return previousClusterUUID;  
    private final UploadedMetadataAttribute uploadedHashesOfConsistentSettings;
        this.indicesRouting = Collections.unmodifiableList(indicesRouting);
                ConstructingObjectParser.optionalConstructorArg(),
        if (in.getVersion().onOrAfter(Version.V_2_15_0)) {  
    }
        }
        List<UploadedIndexMetadata> indicesRouting,  
        return globalMetadataFileName;  
                getHashesOfConsistentSettings().toXContent(builder, params);  
     * Metadata for uploaded index metadata
            parser.declareNamedObject(
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V3);
        static final String COMPONENT_PREFIX = "index--";  
        private Map<String, UploadedMetadataAttribute> customMetadataMap;
        return builder;
            if (o == null || getClass() != o.getClass()) return false;
        public Builder clusterTerm(long clusterTerm) {  
            );
            this.metadataVersion = in.readLong();
            declareParser(PARSER_V2, CODEC_V2);  
        this.opensearchVersion = opensearchVersion;
        public String toString() {
        out.writeString(nodeId);
        }
        public Builder diffManifest(ClusterStateDiffManifest diffManifest) {
        out.writeInt(opensearchVersion.id);
    public static ClusterMetadataManifest fromXContentV3(XContentParser parser) throws IOException {
            }  
    public boolean hasMetadataAttributesFiles() {
            PARSER = ((p, c, name) -> innerParser.parse(p, name));
    public ClusterMetadataManifest(  
        private final String uploadedFilename;
        return (UploadedMetadataAttribute) fields[13];
            if (getDiscoveryNodesMetadata() != null) {
            this.uploadedTransientSettingsMetadata = null;
            out.writeMap(uploadedClusterStateCustomMap, StreamOutput::writeString, (o, v) -> v.writeTo(o));
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public UploadedMetadataAttribute getTemplatesMetadata() {
            this.indices = new ArrayList<>(manifest.indices);  
        }
        builder.startArray(INDICES_FIELD.getPreferredName());  
            this.routingTableVersion = -1;
        "uploaded_hashes_of_consistent_settings_metadata"
                (p, c) -> ClusterStateChecksum.fromXContent(p),  
            .transientSettingsMetadata(transientSettingsMetadata(fields))  
            return false;
            return indicesRouting;
    static {  
                discoveryNodesMetadata,
            builder.endArray();  
        }
        return indices;
        String globalMetadataFileName,  
            } else {
                this.diffManifest = new ClusterStateDiffManifest(in);  
                + '}';  
            && Objects.equals(uploadedTransientSettingsMetadata, that.uploadedTransientSettingsMetadata)
            uploadedHashesOfConsistentSettings,  
        UploadedMetadataAttribute uploadedTemplatesMetadata,  
            uploadedClusterBlocksMetadata,
        }
        }
    }
            } else {
    public static final int CODEC_V4 = 4; // In Codec V4, we have removed upserts and delete field for routing table in diff manifest and
    }
        public Builder nodeId(String nodeId) {
            return builder;
        return uploadedTemplatesMetadata;  
        }
        return clusterTerm;
        public void writeTo(StreamOutput out) throws IOException {
            this.previousClusterUUID = previousClusterUUID;
            this.componentPrefix = in.readString();
            this.uploadedTemplatesMetadata = new UploadedMetadataAttribute(in);
        parser.declareString(ConstructingObjectParser.constructorArg(), CLUSTER_UUID_FIELD);
    }  
        return uploadedCustomMetadataMap;
     * @opensearch.internal  
            if (uploadedTransientSettingsMetadata != null) {
                return CURRENT_PARSER.parse(parser, null);
            );
        this.nodeId = in.readString();  
    private static final ParseField STATE_UUID_FIELD = new ParseField("state_uuid");  
    public Map<String, UploadedMetadataAttribute> getCustomMetadataMap() {  
    public boolean equals(Object o) {
        private String nodeId;
        UploadedMetadataAttribute uploadedHashesOfConsistentSettings,
                "uploaded_metadata_attribute",
        Map<Version, Integer> versionToCodecMapping = new HashMap<>();
            if (getTransientSettingsMetadata() != null) {
                builder.endObject();
                uploadedClusterBlocksMetadata.writeTo(out);  
            parser.declareNamedObjects(
        parser.declareLong(ConstructingObjectParser.constructorArg(), STATE_VERSION_FIELD);
    private static UploadedMetadataAttribute transientSettingsMetadata(Object[] fields) {
    }
import org.opensearch.core.common.Strings;  
    private static Map<String, UploadedMetadataAttribute> clusterStateCustomMetadata(Object[] fields) {
            } else if (version.onOrAfter(Version.V_2_15_0) && version.before(Version.V_2_16_0)) {
        return CURRENT_PARSER.parse(parser, null);  
            clusterTerm,
         * @return The name of the uploaded file as a string
    public UploadedMetadataAttribute getTransientSettingsMetadata() {
        static {
                uploadedIndexMetadata.toXContent(builder, params);
            this.indexName = in.readString();
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V1 = new ConstructingObjectParser<>(
        public List<UploadedIndexMetadata> getIndices() {
                builder.endObject();
                indices,
            this.hashesOfConsistentSettings = hashesOfConsistentSettings;
    }  
        public Builder indicesRouting(List<UploadedIndexMetadata> indicesRouting) {
    private static final ConstructingObjectParser<ClusterMetadataManifest, Void> PARSER_V3 = new ConstructingObjectParser<>(
        this.clusterStateChecksum = clusterStateChecksum;  
                clusterStateChecksum.writeTo(out);  
        this.stateVersion = version;
    private final String clusterUUID;  
        private int codecVersion;  
        }
        return (UploadedMetadataAttribute) fields[17];  
        }
            }
        public static UploadedMetadataAttribute fromXContent(XContentParser parser) throws IOException {
            builder.field(GLOBAL_METADATA_FIELD.getPreferredName(), getGlobalMetadataFileName());
        private long routingTableVersion;
        if (out.getVersion().onOrAfter(Version.V_2_15_0)) {
            this.uploadedFilename = uploadedFileName;  
        private static String componentPrefix(Object[] fields) {  
    ) {  
            opensearchVersion,  
                UploadedMetadataAttribute.PARSER,  
package org.opensearch.gateway.remote;
            return PARSER_V0.parse(parser, null);  
    private static final ParseField UPLOADED_COORDINATOR_METADATA = new ParseField("uploaded_coordinator_metadata");  
        public Builder clusterUUID(String clusterUUID) {
    private static final ParseField INDICES_FIELD = new ParseField("indices");  
            }  
    private static final Map<Version, Integer> VERSION_TO_CODEC_MAPPING;
            if (in.readBoolean()) {
        final ClusterMetadataManifest that = (ClusterMetadataManifest) o;  
    public Map<String, UploadedMetadataAttribute> getClusterStateCustomMap() {  
    }
        }  
        if (in.getVersion().onOrAfter(Version.V_2_17_0) && in.readBoolean()) {
            }
    }
        out.writeString(previousClusterUUID);
        private static final ParseField UPLOADED_FILENAME_FIELD = new ParseField("uploaded_filename");
            }
                attribute.toXContent(builder, params);
        }
            builder.field(INDEX_NAME_FIELD.getPreferredName(), getIndexName())
        return (int) fields[10];  
            return this;
            this.discoveryNodesMetadata = discoveryNodesMetadata;
    }  
                builder.startObject(DIFF_MANIFEST.getPreferredName());
        }
            && Objects.equals(indicesRouting, that.indicesRouting)
                out.writeBoolean(true);
        public void writeTo(StreamOutput out) throws IOException {  
                clusterUUIDCommitted,  
        return (long) fields[19];
            );  
            this.uploadedCustomMetadataMap = Collections.unmodifiableMap(
            diffManifest,
    }  
        return (String) fields[3];
    private static List<UploadedIndexMetadata> indicesRouting(Object[] fields) {
        public Builder clusterBlocksMetadata(UploadedMetadataAttribute clusterBlocksMetadata) {  
            && Objects.equals(uploadedCoordinationMetadata, that.uploadedCoordinationMetadata)  
import java.util.ArrayList;  
import java.io.IOException;
        return uploadedCoordinationMetadata != null  
    }  
                out.writeBoolean(false);  
        static {  
                this.codecVersion = in.readInt();  
        long metadataVersion,
            );
                ConstructingObjectParser.optionalConstructorArg(),
        String nodeId,  
    }
        private String clusterUUID;
            out.writeString(attributeName);
            return (String) fields[0];
            }  
    private static UploadedMetadataAttribute settingsMetadata(Object[] fields) {
        return new Builder(manifest);  
            this.coordinationMetadata = coordinationMetadata;  
                    String uploadedFilename = (String) parsedObject[0];
    }
            }
            this.opensearchVersion = opensearchVersion;  
        private long codecVersion = CODEC_V2;  
    public String getStateUUID() {
            && Objects.equals(routingTableVersion, that.routingTableVersion)
            return uploadedFilename;  
        this.clusterUUID = in.readString();  
    private static final ParseField INDICES_ROUTING_FIELD = new ParseField("indices_routing");
                this.codecVersion = CODEC_V0; // Default codec  
    private static ClusterStateDiffManifest diffManifest(Object[] fields) {  
                + ", uploadedFilename='"  
            indices = new ArrayList<>();
            } else {
                previousClusterUUID,
            this.uploadedSettingsMetadata = new UploadedMetadataAttribute(in);  
        public Builder() {  
            }
                codecVersion,
        }
            parser.declareNamedObject(  
                UploadedMetadataAttribute.PARSER,  
                builder.startObject(UPLOADED_TEMPLATES_METADATA.getPreferredName());  
            .field(OPENSEARCH_VERSION_FIELD.getPreferredName(), getOpensearchVersion().id)  
    public static final int CODEC_V2 = 2; // In Codec V2, there are separate metadata files rather than a single global metadata file,
        private ClusterStateChecksum checksum;
            parser.declareLong(ConstructingObjectParser.constructorArg(), ROUTING_TABLE_VERSION_FIELD);
                    builder.startObject();
                diffManifest,
            out.writeInt(codecVersion);  
     * Builder for ClusterMetadataManifest
            this.templatesMetadata = templatesMetadata;
                checksum
            this.coordinationMetadata = manifest.uploadedCoordinationMetadata;
        public Builder discoveryNodesMetadata(UploadedMetadataAttribute discoveryNodesMetadata) {
    public static class UploadedMetadataAttribute implements UploadedMetadata, Writeable, ToXContentFragment {
        }
        out.writeString(clusterUUID);
        }  
            } else {  
    }  
        return (UploadedMetadataAttribute) fields[11];
 */
        return new Builder();
        builder.field(CLUSTER_TERM_FIELD.getPreferredName(), getClusterTerm())
            );  
            } else {
        }  
        UploadedMetadataAttribute uploadedCoordinationMetadata,
        return clusterStateChecksum;  
            this.discoveryNodesMetadata = manifest.uploadedDiscoveryNodesMetadata;
        return clusterUUID;
        private static final ConstructingObjectParser<UploadedIndexMetadata, Void> CURRENT_PARSER = PARSER_V2;
        parser.declareString(ConstructingObjectParser.constructorArg(), STATE_UUID_FIELD);  
        private String stateUUID;
                return false;
        return stateUUID;
        public String toString() {
            this.customMetadataMap = customMetadataMap;  
         * @return A string identifying the component  
        }
                ConstructingObjectParser.optionalConstructorArg(),
            builder.endObject();
        public Builder(ClusterMetadataManifest manifest) {
    private static boolean committed(Object[] fields) {
        parser.declareObjectArray(
    @Override
                this.uploadedHashesOfConsistentSettings = null;  
        private static final ParseField COMPONENT_PREFIX_FIELD = new ParseField("component_prefix");
            if (in.readBoolean()) {
            (p, c) -> UploadedIndexMetadata.fromXContent(p, codec_version),  
            out.writeString(globalMetadataFileName);
                ConstructingObjectParser.optionalConstructorArg(),
    }
        }  
            && clusterTerm == that.clusterTerm
            .stateVersion(version(fields))
            return componentPrefix + getIndexName();
                this.uploadedDiscoveryNodesMetadata = new UploadedMetadataAttribute(in);
            clusterUUIDCommitted,
                coordinationMetadata,
            }
            && Objects.equals(uploadedCustomMetadataMap, that.uploadedCustomMetadataMap)  
            builder.field(CODEC_VERSION_FIELD.getPreferredName(), getCodecVersion());  
                out.writeBoolean(false);
    public static class UploadedIndexMetadata implements UploadedMetadata, Writeable, ToXContentFragment {
        }
    }
        return (UploadedMetadataAttribute) fields[21];
        public Builder checksum(ClusterStateChecksum checksum) {
            uploadedTemplatesMetadata,  
/*  
        }  
        private final String indexName;
    }
            } else {
    }
    private static final ParseField DIFF_MANIFEST = new ParseField("diff_manifest");
            return indexUUID;
        }
            declareParser(PARSER_V0, CODEC_V0);
                hashesOfConsistentSettings,
    public static int getCodecForVersion(Version version) {
        }
    public String getNodeId() {  
            .clusterTerm(term(fields))
        }
        {
        }
    }
    public String getGlobalMetadataFileName() {
                + "attributeName='"  
    private static final ParseField UPLOADED_TEMPLATES_METADATA = new ParseField("uploaded_templates_metadata");
    public UploadedMetadataAttribute getClusterBlocksMetadata() {
    private static final ParseField UPLOADED_SETTINGS_METADATA = new ParseField("uploaded_settings_metadata");
        }
                ConstructingObjectParser.optionalConstructorArg(),
                out.writeBoolean(true);
                out.writeBoolean(true);
            out.writeString(uploadedFilename);  
            return this;  
        builder.field(PREVIOUS_CLUSTER_UUID.getPreferredName(), getPreviousClusterUUID());  
    private static long term(Object[] fields) {
            .indices(indices(fields))  
            if (clusterStateChecksum != null) {
                getClusterStateChecksum().toXContent(builder, params);  
            }
            this.settingsMetadata = manifest.uploadedSettingsMetadata;
                + '\''
        String stateUUID,
        }
                UploadedMetadataAttribute.PARSER,
import org.opensearch.core.common.io.stream.StreamInput;
        return this.codecVersion >= codecVersion;
                getTemplatesMetadata().toXContent(builder, params);
        this.committed = in.readBoolean();
            if (in.readBoolean()) {  
    public static final int CODEC_V1 = 1; // In Codec V1 we have introduced global-metadata and codec version in Manifest file.  
            && Objects.equals(uploadedClusterStateCustomMap, that.uploadedClusterStateCustomMap)  
        return (long) fields[15];
            if (uploadedClusterBlocksMetadata != null) {
    public static final int MANIFEST_CURRENT_CODEC_VERSION = CODEC_V4;
                UPLOADED_CLUSTER_STATE_CUSTOM_METADATA
        return committed;
    private static final ParseField UPLOADED_TRANSIENT_SETTINGS_METADATA = new ParseField("uploaded_transient_settings_metadata");
            return PARSER.parse(parser, null, parser.currentName());
            out.writeString(indexName);
    private static ClusterMetadataManifest.Builder manifestV2Builder(Object[] fields) {  
            return this;
        public Builder stateVersion(long stateVersion) {
        }  
    }
    private final int codecVersion;  
                UPLOADED_HASHES_OF_CONSISTENT_SETTINGS_METADATA
        assert Arrays.stream(CODEC_VERSIONS).max().getAsInt() == MANIFEST_CURRENT_CODEC_VERSION;
/**
    public boolean isCommitted() {
            clusterUUID,
            final UploadedIndexMetadata that = (UploadedIndexMetadata) o;  
            this.indicesRouting = null;
    }
    public boolean isClusterUUIDCommitted() {  
                attribute.toXContent(builder, params);  
    }
        fields -> manifestV0Builder(fields).build()
        declareParser(PARSER_V0, CODEC_V0);
import org.opensearch.core.xcontent.XContentParser;  
            );
            }
        private Version opensearchVersion;  
        }  
    private static final ParseField CLUSTER_UUID_FIELD = new ParseField("cluster_uuid");
                transientSettingsMetadata,
        }
        if (this == o) {  
        return (String) fields[11];
            this.uploadedDiscoveryNodesMetadata = null;  
    }
            return getAttributeName();
                builder.endObject();
        }  
        return (UploadedMetadataAttribute) fields[12];  
public class ClusterMetadataManifest implements Writeable, ToXContentFragment {  
            .hashesOfConsistentSettings(hashesOfConsistentSettings(fields))
     */
        }  
    private static final ParseField PREVIOUS_CLUSTER_UUID = new ParseField("previous_cluster_uuid");
        }  
        private UploadedMetadataAttribute templatesMetadata;
    private static Version opensearchVersion(Object[] fields) {
    }
        }
    public ClusterStateDiffManifest getDiffManifest() {
    public boolean onOrAfterCodecVersion(int codecVersion) {  
    private static ClusterStateChecksum checksum(Object[] fields) {
            parser.declareObject(  
    }
    private static int codecVersion(Object[] fields) {
        if (o == null || getClass() != o.getClass()) {  
    public static ClusterMetadataManifest fromXContentV2(XContentParser parser) throws IOException {  
    }
        public Builder settingMetadata(UploadedMetadataAttribute settingsMetadata) {
        return uploadedHashesOfConsistentSettings;
        List<UploadedIndexMetadata> indices,
        if (onOrAfterCodecVersion(CODEC_V4)) {  
            parser.declareNamedObjects(
        UploadedMetadataAttribute discoveryNodesMetadata,
    private static UploadedMetadataAttribute coordinationMetadata(Object[] fields) {
            uploadedCustomMetadataMap != null ? uploadedCustomMetadataMap : new HashMap<>()
    @Override
                versionToCodecMapping.put(version, ClusterMetadataManifest.CODEC_V1);
                .field(UPLOADED_FILENAME_FIELD.getPreferredName(), getUploadedFilePath());
                routingTableVersion,
import java.util.Map;
        public Builder previousClusterUUID(String previousClusterUUID) {
    private final boolean clusterUUIDCommitted;  
            out.writeCollection(indicesRouting);
        parser.declareInt(ConstructingObjectParser.constructorArg(), OPENSEARCH_VERSION_FIELD);
    private static final ParseField METADATA_VERSION = new ParseField("metadata_version");  
            && Objects.equals(clusterStateChecksum, that.clusterStateChecksum);
            if (in.readBoolean()) {  
        @Override
            if (uploadedDiscoveryNodesMetadata != null) {
    );  
            if (getDiffManifest() != null) {
            return this;
                builder.startObject();  
    public static ClusterMetadataManifest fromXContentV0(XContentParser parser) throws IOException {
        String clusterUUID,  
        }  
                this.uploadedHashesOfConsistentSettings = new UploadedMetadataAttribute(in);
                out.writeBoolean(false);
                builder.startObject(UPLOADED_TRANSIENT_SETTINGS_METADATA.getPreferredName());  
            }
            if (diffManifest != null) {
import java.util.Collections;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public interface UploadedMetadata {
            indices,
    public static Builder builder(ClusterMetadataManifest manifest) {
                out.writeBoolean(false);
            parser.declareString(ConstructingObjectParser.constructorArg(), INDEX_UUID_FIELD);
import org.opensearch.core.ParseField;
    private final UploadedMetadataAttribute uploadedTemplatesMetadata;
            );  
    private final UploadedMetadataAttribute uploadedTransientSettingsMetadata;
    private static final ParseField GLOBAL_METADATA_FIELD = new ParseField("global_metadata");
            parser.declareNamedObject(
            this.customMetadataMap.put(custom, customMetadata);
        clusterStateChecksum = null;
            this.transientSettingsMetadata = manifest.uploadedTransientSettingsMetadata;
    /**
            this.nodeId = nodeId;
            this.clusterTerm = manifest.clusterTerm;
        public UploadedMetadataAttribute(String attributeName, String uploadedFilename) {
        public Builder put(String custom, UploadedMetadataAttribute customMetadata) {
        @Override
import org.opensearch.core.xcontent.ToXContentFragment;
        return nodeId;
        "cluster_metadata_manifest",
        parser.declareBoolean(ConstructingObjectParser.constructorArg(), COMMITTED_FIELD);  
        public String getAttributeName() {
            clusterStateChecksum  
    private static long routingTableVersion(Object[] fields) {  
        parser.declareString(ConstructingObjectParser.constructorArg(), NODE_ID_FIELD);
                for (UploadedIndexMetadata uploadedIndexMetadata : indicesRouting) {  
            } else if (version.onOrAfter(Version.V_2_12_0) && version.before(Version.V_2_15_0)) {  
    public void writeTo(StreamOutput out) throws IOException {
            return this;
            .clusterUUIDCommitted(clusterUUIDCommitted(fields));
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {  
        out.writeVLong(clusterTerm);  
        /**
    public ClusterStateChecksum getClusterStateChecksum() {
        }  
        return codecVersion;
        public UploadedIndexMetadata(String indexName, String indexUUID, String uploadedFileName, String componentPrefix) {
            this.attributeName = attributeName;
            if (getSettingsMetadata() != null) {  
            uploadedCoordinationMetadata.writeTo(out);  
            }
        fields -> manifestV4Builder(fields).build()  
         * Gets the name of the file that was uploaded
            && Objects.equals(stateUUID, that.stateUUID)
                parser.declareString(ConstructingObjectParser.constructorArg(), COMPONENT_PREFIX_FIELD);
    private final long metadataVersion;  
            fields -> new UploadedIndexMetadata(indexName(fields), indexUUID(fields), uploadedFilename(fields), componentPrefix(fields))
            this.indices = indices;
        }
                ConstructingObjectParser.optionalConstructorArg(),  
         */
            && Objects.equals(nodeId, that.nodeId)
                && Objects.equals(indexUUID, that.indexUUID)
            this.codecVersion = codecVersion;
        this.clusterUUIDCommitted = in.readBoolean();
                uploadedTransientSettingsMetadata.writeTo(out);  
            {
            uploadedCoordinationMetadata,
            this.committed = committed;
            this.checksum = checksum;
            return this;  
            if (codec_version >= CODEC_V2) {
 * this file be licensed under the Apache-2.0 license or a
            parser.declareLong(ConstructingObjectParser.constructorArg(), METADATA_VERSION);
                clusterUUID,  
        private static void declareParser(ConstructingObjectParser<UploadedIndexMetadata, Void> parser, long codec_version) {  
        public List<UploadedIndexMetadata> getIndicesRouting() {  
        public UploadedMetadataAttribute(StreamInput in) throws IOException {  
        declareParser(PARSER_V1, CODEC_V1);
    private static final ParseField CLUSTER_UUID_COMMITTED = new ParseField("cluster_uuid_committed");
        private UploadedMetadataAttribute discoveryNodesMetadata;
    private static UploadedMetadataAttribute templatesMetadata(Object[] fields) {  
            uploadedSettingsMetadata.writeTo(out);
            return uploadedFilename;  
        builder.endArray();
            return this;
            stateVersion,  
         * Gets the component or part of the system this upload belongs to.
                builder.endObject();
        public UploadedIndexMetadata(
    }
            .nodeId(nodeId(fields))  
    );
            previousClusterUUID,  
    }
            && Objects.equals(uploadedSettingsMetadata, that.uploadedSettingsMetadata)
 * @opensearch.internal
    }  
                UPLOADED_TEMPLATES_METADATA  
    public long getStateVersion() {
        UploadedMetadataAttribute uploadedSettingsMetadata,
        return (UploadedMetadataAttribute) fields[18];
        return (String) fields[8];
        public Builder templatesMetadata(UploadedMetadataAttribute templatesMetadata) {  
            }  
        fields -> manifestV3Builder(fields).build()
        @Override  
            parser.declareObjectArray(
            );  
        this.stateUUID = stateUUID;
            builder.field(CODEC_VERSION_FIELD.getPreferredName(), getCodecVersion());  
        );
            UploadedMetadataAttribute that = (UploadedMetadataAttribute) o;  
            parser.declareNamedObject(
            }  
                committed,
            return this;  
    public long getClusterTerm() {
        public Builder hashesOfConsistentSettings(UploadedMetadataAttribute hashesOfConsistentSettings) {
            for (UploadedMetadataAttribute attribute : getClusterStateCustomMap().values()) {
        this.opensearchVersion = Version.fromId(in.readInt());
                && Objects.equals(uploadedFilename, that.uploadedFilename)  
            && stateVersion == that.stateVersion  
                + attributeName
