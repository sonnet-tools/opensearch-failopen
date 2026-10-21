    public boolean hasIndex(Index index) {
            this.customs.put(ComposableIndexTemplateMetadata.TYPE, new ComposableIndexTemplateMetadata(existingTemplates));
    public Map<String, DataStream> dataStreams() {
            indices = DiffableUtils.diff(before.indices, after.indices, DiffableUtils.getStringKeySerializer());
                }
            return this;
                    } else if ("hashes_of_consistent_settings".equals(currentFieldName)) {
    private static String mergePaths(String path, String field) {
            return indexAbstraction.getType() == IndexAbstraction.Type.ALIAS;
    private final String[] allIndices;
        public IndexMetadata getSafe(Index index) {
import org.opensearch.core.common.io.stream.StreamInput;
            aliasDuplicatesWithIndices.retainAll(allIndices);
        private boolean clusterUUIDCommitted;
        if (sourceAsMap.size() == 1 && sourceAsMap.containsKey(mappingMetadata.type())) {
        private static final DiffableUtils.DiffableValueReader<String, IndexTemplateMetadata> TEMPLATES_DIFF_VALUE_READER =
         *
                final String name = indexMetadata.getIndex().getName();
    }
        private final Diff<Map<String, Custom>> customs;
                throw new IndexNotFoundException(
                    }
         * @param numberOfReplicas the number of replicas
        }
            XContentContext context = XContentContext.valueOf(params.param(CONTEXT_MODE_PARAM, CONTEXT_MODE_API));
            final Set<String> allDataStreams = new HashSet<>();
                token = parser.nextToken();
                            systemTemplatesLookup.compute(templateMetadata.name(), (ik, iv) -> {
    public Map<String, List<AliasMetadata>> findAllAliases(final String[] concreteIndices) {
            // handling any Exception is caller's responsibility
        FORMAT_PARAMS = new MapParams(params);
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.cluster.metadata;
    private static class MetadataDiff implements Diff<Metadata> {
    }
            .map(
        }
                        }
        this.systemTemplatesLookup = systemTemplatesLookup;
        }
        return indices.values().iterator();
                if (token == XContentParser.Token.FIELD_NAME) {
            if (clusterUUID.equals(UNKNOWN_CLUSTER_UUID)) {
    @SuppressWarnings("unchecked")
                        + aliasMd.getIndexRouting()
                return this;
        }
        public static void toXContent(Metadata metadata, XContentBuilder builder, ToXContent.Params params) throws IOException {
     * @param aliasesRequest The request to find aliases for
     *
    }
                .stream()
     * State format for {@link Metadata} to write to and load from disk
            }
                builder.startObject("indices");
            return this;
        Property.NodeScope
        RestStatus.FORBIDDEN,
        for (final Custom cursor : customs.values()) {
    /**
                for (final AliasMetadata aliasMetadata : indexMetadata.getAliases().values()) {
    public String[] getConcreteAllIndices() {
            return routing;
        } else {
                templates,
     * or that match with the indices via wildcards.
     * Indicates that this custom metadata will be returned as part of an API call, stored as a part of
                visibleIndicesArray,
    private final TemplatesMetadata templates;
                        }
                mapBuilder.put(index, Collections.unmodifiableList(filteredValues));
        // Check if any persistent metadata needs to be saved
    public Map<String, IndexTemplateMetadata> getTemplates() {
                .map(WorkloadGroupMetadata::workloadGroups)
    }
    }
        }
        // return true if the ancestor may be removed, as it has no sub-fields left
import org.opensearch.common.settings.Settings;
                            "data stream ["
 */
        }
            throw new IllegalArgumentException("alias [" + aliasOrIndex + "] does not have a write index");
            );
                    assert subFields.size() > 0;
        builder.version = in.readLong();
                for (DataStream dataStream : dataStreamMetadata.dataStreams().values()) {
                            builder.putCustom(custom.getWriteableName(), custom);
            return this;
            if (aliasMd.indexRouting().indexOf(',') != -1) {
            return this;
                        builder.persistentSettings(Settings.fromXContent(parser));
                if (indexMetadata == null) {
            this.customs.put(DataStreamMetadata.TYPE, new DataStreamMetadata(dataStreams));
        return Optional.ofNullable((ComponentTemplateMetadata) this.custom(ComponentTemplateMetadata.TYPE))
        }
                customCount1++;
                    Map<String, Object> subFields = (Map<String, Object>) map.get("fields");
        false,
        boolean matchAllAliases = patterns.length == 0;
            if (dataStreamMetadata != null && indices.size() > 0) {
        13,
     */
                    .orElseGet(Collections::emptyMap)
            String[] allOpenIndicesArray = allOpenIndices.toArray(Strings.EMPTY_ARRAY);
        if (!isCoordinationMetadataEqual(metadata1, metadata2)) {
        return fields.size() == 0;
        if (metadata1.clusterUUIDCommitted != metadata2.clusterUUIDCommitted) {
     * @param concreteIndices The concrete indices that the aliases must point to in order to be returned.
                DataStream parent = indexToDataStreamLookup.get(indexMetadata.getIndex().getName());
    public Map<String, IndexMetadata> getIndices() {
                numberOfCustoms++;
        public Builder removeAllIndices() {
            indices.clear();
                assert existing == null : "duplicate for " + indexMetadata.getIndex();
        }
 * not use this file except in compliance with the License.
            Settings.writeSettingsToStream(transientSettings, out);
                    // multi fields that should be excluded but hold subfields that don't have to be excluded are converted to objects
     * @return A map of index name to the list of aliases metadata. If a concrete index does not have matching
                for (DataStream ds : dsMetadata.dataStreams().values()) {
            return this;
            this.templates.clear();
    }
import java.util.SortedMap;
        }
import org.opensearch.cluster.ClusterState.FeatureAware;
    /**
import org.opensearch.core.index.Index;
        public Builder clusterUUID(String clusterUUID) {
import org.opensearch.cluster.NamedDiffableValueSerializer;
            String[] allClosedIndicesArray = allClosedIndices.toArray(Strings.EMPTY_ARRAY);
            this.templates.putAll(templates);
            builder.templates(templates.apply(part.templates.getTemplates()));
                // iterate again and constructs a helpful message
            // while these datastructures aren't even used.
    private final Settings settings;
     * @return true if the provided array maps to all types, false otherwise
     */
            Builder builder = new Builder();
            buildSystemTemplatesLookup();
import java.util.EnumSet;
                throw new IllegalArgumentException(
        }
                        builder.clusterUUID = parser.text();
            ).map(itmd -> new HashMap<>(itmd.indexTemplates())).orElse(new HashMap<>());
    /**
        private Settings transientSettings = Settings.Builder.EMPTY_SETTINGS;
            return this;
                        }
            indices.put(indexMetadata.getIndex().getName(), indexMetadata);
            return this;
        }
    }
            // 2) The aliasAndIndexLookup can be updated instead of rebuilding it all the time.
        return this.persistentSettings;
            DataStreamMetadata dataStreamMetadata = (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE);
            }
     */
     * Returns indexing routing for the given index.
        Property.NodeScope
            existingDataStreams.put(dataStream.getName(), dataStream);
            final List<String> allOpenIndices = new ArrayList<>();
        return Optional.ofNullable(index(indexName))
            return this.hashesOfConsistentSettings;
                hashesOfConsistentSettings,
    public static final Metadata EMPTY_METADATA = builder().build();
        public Builder removeCustom(String type) {
                        if (cursor.getAliases().containsKey(alias)) {
        if (path.length() == 0) {
    public static final String CONTEXT_MODE_PARAM = "context_mode";
         */
    }
        while (entryIterator.hasNext()) {
                Arrays.copyOf(previousMetadata.visibleIndices, previousMetadata.visibleIndices.length),
            // build all concrete indices arrays:
        this.transientSettings = transientSettings;
        if (!isTemplatesMetadataEqual(metadata1, metadata2)) {
            existingDataStreams.remove(name);
                customs,
        public Builder updateSettings(Settings settings, String... indices) {
                            return alias;
            }
        return indices.containsKey(index);
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
        return null;
                    Map<String, Object> map = (Map<String, Object>) value;
     * @return A map of index name to the list of aliases metadata. If a concrete index does not have matching
        "cluster.blocks.read_only_allow_delete",
            existingTemplates.remove(name);
        public DecommissionAttributeMetadata decommissionAttributeMetadata() {
                    "index/alias ["
        }
        }
                    allClosedIndices.add(name);
        false,
                clusterUUID = UUIDs.randomBase64UUID();
    }
            templates.writeTo(out);
        } else {
     * a snapshot global state, and will be persisted between node restarts
            return this.transientSettings;
         * Validates there isn't any index with a name that would clash with the future backing indices of the existing data streams.
            Map.Entry<String, Object> entry = entryIterator.next();
        writeSettingsToStream(persistentSettings, out);
        builder.clusterUUIDCommitted = in.readBoolean();
        );
            boolean recomputeRequiredforIndicesLookups = (previousMetadata == null)
            new DiffableUtils.DiffableValueReader<>(IndexTemplateMetadata::readFrom, IndexTemplateMetadata::readDiffFrom);
                                + " including '"
            return this;
        }
        }
    }
    }
            }
        builder.hashesOfConsistentSettings(DiffableStringMap.readFrom(in));
        CoordinationMetadata coordinationMetadata,
                }
            this.coordinationMetadata = metadata.coordinationMetadata;
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    }
                    map.remove("fields");
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            "Alias ["
                metadata.persistentSettings().toXContent(builder, new MapParams(Collections.singletonMap("flat_settings", "true")));
        DiffableStringMap hashesOfConsistentSettings,
                        + aliasOrIndex
     * aliases then the result will <b>not</b> include the index's key.
        private String clusterUUID;
            builder.clusterUUIDCommitted(clusterUUIDCommitted);
            builder.coordinationMetadata(coordinationMetadata);
        if (aliasMd.indexRouting() != null) {
     */
    private final String[] visibleOpenIndices;
                || (dataStreamMetadata != null && dataStreamMetadata.equals(previousDataStreamMetadata) == false);
            indicesLookup.values()
                            assert alias.getType() == IndexAbstraction.Type.ALIAS : alias.getClass().getName();
 */
            return workloadGroups(existing);
        public Builder coordinationMetadata(CoordinationMetadata coordinationMetadata) {
            DataStreamMetadata previousDataStreamMetadata = (previousMetadata != null)
            return this;
        assert aliases != null;
    }
            .orElse(false);
        builder.persistentSettings(readSettingsFromStream(in));
            return graveyard;
            String alias = aliases[i];
            if (context == XContentContext.API) {
     * @return The weighted routing metadata for search requests
        if (fieldPredicate == MapperPlugin.NOOP_FIELD_PREDICATE) {
    public static boolean isSettingsMetadataEqual(Metadata metadata1, Metadata metadata2) {
        public Builder removeIndexTemplate(String name) {
    );
                return false;
        }
            if (token != XContentParser.Token.START_OBJECT) {
                        throw new IllegalArgumentException("Unexpected field [" + currentFieldName + "]");
        return this.clusterUUID;
            if (!"meta-data".equals(parser.currentName())) {
            return this;
        this.persistentSettings = persistentSettings;
            }
        this.coordinationMetadata = coordinationMetadata;
        if (result == null || result.getType() != IndexAbstraction.Type.ALIAS) {
import org.opensearch.cluster.Diff;
            Map<String, WorkloadGroup> existing = new HashMap<>(getWorkloadGroups());
        if (properties == null || properties.isEmpty()) {
import org.opensearch.common.settings.Setting.Property;
            if (cursor.context().contains(XContentContext.GATEWAY)) {
    public boolean isSegmentReplicationEnabled(String indexName) {
    }
        Iterator<Map.Entry<String, Object>> entryIterator = fields.entrySet().iterator();
        }
                    } else if ("cluster_uuid".equals(currentFieldName) || "uuid".equals(currentFieldName)) {
                            + routing
                    if (include[i]) {
                patterns[i] = alias;
    }
     * Returns all of the concrete indices that are open.
    public static final String CONTEXT_MODE_GATEWAY = XContentContext.GATEWAY.toString();
    public String resolveIndexRouting(@Nullable String routing, String aliasOrIndex) {
            totalNumberOfShards += cursor.getTotalNumberOfShards();
        if (!isSettingsMetadataEqual(metadata1, metadata2)) {
/*
            templates = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), TEMPLATES_DIFF_VALUE_READER);
        public Builder updateNumberOfSearchReplicas(final int numberOfSearchReplicas, final String[] indices) {
        private final Diff<Map<String, IndexMetadata>> indices;
    public static final ClusterBlock CLUSTER_READ_ONLY_BLOCK = new ClusterBlock(
        @Override
     *
 *
            customs.writeTo(out);
     */
                        if (MetadataIndexTemplateService.isSystemTemplate(v)) {
import java.util.ArrayList;
                    throw new IndexNotFoundException(index);
                            });
                    } else {
                    } else {
            if (!"meta-data".equals(currentFieldName)) {
    public String[] getConcreteVisibleIndices() {
        String[] allClosedIndices,
                clusterUUID,
                );
    public static final ClusterBlock CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK = new ClusterBlock(
     * A diff of metadata.
                                iv.put(templateMetadata.version(), k);
        protected Metadata buildMetadataWithRecomputedIndicesLookups() {
                        .keySet()
        public Builder version(long version) {
                throw new IllegalStateException("cannot filter mappings, found unknown element of type [" + value.getClass() + "]");
                    String prefix = DataStream.BACKING_INDEX_PREFIX + ds.getName() + "-";
            return this;
import java.util.function.Predicate;
        MetadataDiff(StreamInput in) throws IOException {
        this.totalNumberOfShards = totalNumberOfShards;
    }
    public static Builder builder() {
                    "index/alias ["
            existingTemplates.put(name, indexTemplate);
            final Set<String> allIndices = new HashSet<>(indices.size());
    /** Returns true iff existing index has the same {@link IndexMetadata} instance */
        for (IndexMetadata otherIndex : other.indices().values()) {
                .forEach(cursor -> Objects.requireNonNull(cursor.getValue(), cursor.getKey()));
 * under the License.
                        } else {
                boolean added = allIndices.add(name);
        if (result.getIndices().size() > 1) {
                    IndexMetadata.Builder.toXContent(indexMetadata, builder, params);
                throw new IllegalArgumentException("Expected a START_OBJECT but got " + token);
                        "Alias ["
                        if (alias == null) {
        IndexMetadata indexMetadata = indices.get(concreteIndex);
            ).map(dsmd -> new HashMap<>(dsmd.dataStreams())).orElse(new HashMap<>());
        public Builder removeDataStream(String name) {
    }
                indices = this.indices.keySet().toArray(new String[0]);
            // TODO: We should move these datastructures to IndexNameExpressionResolver, this will give the following benefits:
            this.persistentSettings = metadata.persistentSettings;
            Map<String, DataStream> existingDataStreams = Optional.ofNullable(
            final List<String> visibleOpenIndices = new ArrayList<>();
        assert fieldPredicate != MapperPlugin.NOOP_FIELD_PREDICATE;
        params.put("binary", "true");
            if (context == XContentContext.API) {
        this.allOpenIndices = allOpenIndices;
                );
        }
     */
        }
    }
    public static final String GLOBAL_STATE_FILE_PREFIX = "global-";
            builder.endObject();
                if (!routing.equals(aliasMd.indexRouting())) {
        public Builder removeComponentTemplate(String name) {
    public Settings persistentSettings() {
        }
                Map<String, Object> properties = (Map<String, Object>) map.get("properties");
        return builder.build();
    public boolean clusterUUIDCommitted() {
            Map<String, ComposableIndexTemplate> existingTemplates = Optional.ofNullable(
                }
                Arrays.copyOf(previousMetadata.allClosedIndices, previousMetadata.allClosedIndices.length),
            builder.version(version);
            return this;
            if (duplicates.size() > 0) {
    public Map<String, IndexMetadata> indices() {
                    assert backingIndices.isEmpty() == false;
    }
        if (aliasOrIndex == null) {
            return this;
            }
        "cluster read-only (api)",
            this.persistentSettings = settings;
            customs = DiffableUtils.diff(before.customs, after.customs, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);
     * Indicates that this custom metadata will be returned as part of an API call and will be persisted between
    private final int totalOpenRemoteCapableIndexShards;
        for (IndexMetadata cursor : indices.values()) {
                (ComponentTemplateMetadata) this.customs.get(ComponentTemplateMetadata.TYPE)
                    } else if ("settings".equals(currentFieldName)) {
    }
            final List<String> allClosedIndices = new ArrayList<>();
        }
            Custom customIndexMetadata = in.readNamedWriteable(Custom.class);
     * replicas, but does not include shards that are part of closed indices.
    private static final Logger logger = LogManager.getLogger(Metadata.class);
                    return indexMetadata;
                Map<String, Object> map = (Map<String, Object>) value;
    /**
            builder.put(IndexMetadata.readFrom(in), false);
        return visibleOpenIndices;
        }
        }
    }
            this.hashesOfConsistentSettings = hashesOfConsistentSettings;
import org.opensearch.cluster.NamedDiffable;
    }
            ).map(dsmd -> new HashMap<>(dsmd.dataStreams())).orElse(new HashMap<>());
            }
        public Builder putCustom(String type, Custom custom) {
        }
                : null;
        private Settings persistentSettings = Settings.Builder.EMPTY_SETTINGS;
        }
                }
        this.visibleOpenIndices = visibleOpenIndices;
                if (parent != null) {
                for (DataStream dataStream : dataStreamMetadata.dataStreams().values()) {
         * @param indices          the indices to update the number of replicas for
                        if (cursor.getAliases().containsKey(alias)) {
            out.writeString(clusterUUID);
        for (Map.Entry<String, Custom> cursor : metadata1.customs.entrySet()) {
    public DecommissionAttributeMetadata decommissionAttributeMetadata() {
        return new MetadataDiff(previousState, this);
        }
        return indices.get(indexMetadata.getIndex().getName()) == indexMetadata;
        public static Metadata fromXContent(XContentParser parser) throws IOException {
    );
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * overridden via plugins)
                    index = new IndexAbstraction.Index(indexMetadata, (IndexAbstraction.DataStream) indicesLookup.get(parent.getName()));
            new DiffableUtils.DiffableValueReader<>(IndexMetadata::readFrom, IndexMetadata::readDiffFrom);
            return false;
            dataStreamDuplicatesWithIndices.retainAll(allIndices);
                        builder.clusterUUIDCommitted = parser.booleanValue();
        }
        public Builder customs(Map<String, Custom> customs) {
     */
        int customSize = in.readVInt();
     */
    public Map<String, List<AliasMetadata>> findAliases(final AliasesRequest aliasesRequest, final String[] concreteIndices) {
    private final DiffableStringMap hashesOfConsistentSettings;
        private final Map<String, IndexTemplateMetadata> templates;
import java.util.Arrays;
        private long version;
                }
                    }
            return MappingMetadata.EMPTY_MAPPINGS;
        private final Metadata previousMetadata;
            this.customs.put(DataStreamMetadata.TYPE, new DataStreamMetadata(existingDataStreams));
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+$");
            }
     * Returns all the concrete indices.
        Builder.toXContent(this, builder, params);
                    throw new IndexNotFoundException(index);
import org.opensearch.plugins.MapperPlugin;
            DataStreamMetadata dataStreamMetadata = (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE);
            this.customs.put(ComponentTemplateMetadata.TYPE, new ComponentTemplateMetadata(existingTemplates));
        false,
import org.apache.logging.log4j.LogManager;
            IndexMetadata indexMetadata = get(index.getName());
            final List<String> visibleIndices = new ArrayList<>();
    }
        int totalOpenRemoteCapableIndexShards = 0;
                        indexToDataStreamLookup.put(i.getName(), dataStream);
            templates = DiffableUtils.diff(
         * `foo` data stream from generation 5 to 6 will not be possible)
                }
        }
        }
            return mappingMetadata;
         */
                    if ("version".equals(currentFieldName)) {
        public Builder indices(final Map<String, IndexMetadata> indices) {
import org.apache.lucene.util.CollectionUtil;
 * this file be licensed under the Apache-2.0 license or a
                        builder.coordinationMetadata(CoordinationMetadata.fromXContent(parser));
                        builder.version = parser.longValue();
import java.util.Objects;
                (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE)
        if (concreteIndices.length == 0) {
        }
        String[] visibleOpenIndices,
            coordinationMetadata = after.coordinationMetadata;
            return this;
        @Override
        this.clusterUUID = clusterUUID;
        }
            return customs.get(type);
                assert added : "double index named [" + name + "]";
                    totalOpenRemoteCapableIndexShards += cursor.getTotalNumberOfShards();
        }
        this.allIndices = allIndices;
    public Map<String, ComponentTemplate> componentTemplates() {
        return metadata != null && metadata.getIndexUUID().equals(index.getUUID());
    @Override
                && Objects.equals(
            if (fieldPredicate.test(newPath) == false) {
            builder.startObject("cluster_coordination");
        public void writeTo(StreamOutput out) throws IOException {
            }
                        .stream()
                if (mayRemove) {
            .map(DataStreamMetadata::dataStreams)
    }
            Objects.requireNonNull(componentTemplate, "it is invalid to add a null component template: " + name);
        private final Map<String, IndexMetadata> indices;
        return findAliases(Strings.EMPTY_ARRAY, concreteIndices);
        IndexMetadata writeIndex = result.getWriteIndex();
                    token = parser.nextToken();
        }
            }
                        .collect(Collectors.toList());
        this.visibleIndices = visibleIndices;
                    if (visible) {
            .orElse(Collections.emptyMap());
        private Map<String, SortedMap<Long, String>> systemTemplatesLookup;
     * aliases then the result will <b>not</b> include the index's key.
                return false;
            transientSettings = Settings.readSettingsFromStream(in);
        templates.writeTo(out);
            if (otherIndex.getAliases().equals(thisIndex.getAliases()) == false) {
     * @return Whether routing is required according to the mapping for the specified index and type
                indexMetadata -> ReplicationType.parseString(indexMetadata.getSettings().get(IndexMetadata.SETTING_REPLICATION_TYPE))
    public String resolveWriteIndexRouting(@Nullable String routing, String aliasOrIndex) {
        public Builder put(final WorkloadGroup workloadGroup) {
 *
     */
        Settings transientSettings,
        writeSettingsToStream(transientSettings, out);
                            String pattern = patterns[i];
                visibleOpenIndicesArray,
        }
            builder.customs(customs.apply(part.customs));
            clusterUUID = UNKNOWN_CLUSTER_UUID;
     */
     */
            XContentParser.Token token = parser.currentToken();
     */
        return new Builder(metadata);
            IndexMetadata thisIndex = index(otherIndex.getIndex());
        return isGlobalResourcesMetadataEquals(metadata1, metadata2);
        int i = 0;
    /**
            MappingMetadata mappingMetadata = indexMetadata.mapping();
                } else if (isMultiField) {
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(mappingMetadata.source().compressedReference(), true).v2();
            );
     *
                            + "] has index routing associated with it ["
                clusterUUID,
         *
        public Builder templates(Map<String, IndexTemplateMetadata> templates) {
        final Map<String, IndexMetadata> indices,
    }
    public int getTotalOpenRemoteCapableIndexShards() {
        public Builder remove(final WorkloadGroup workloadGroup) {
        if (metadata != null && metadata.getIndexUUID().equals(index.getUUID())) {
                after.templates.getTemplates(),
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
            existingTemplates.put(name, componentTemplate);
            indices = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), INDEX_METADATA_DIFF_VALUE_READER);
        6,
            String[] allIndicesArray = allIndices.toArray(Strings.EMPTY_ARRAY);
        if (indexMetadata != null) {
                || (previousDataStreamMetadata != null && previousDataStreamMetadata.equals(dataStreamMetadata) == false)
        }
        return mapBuilder;
        public Builder componentTemplates(Map<String, ComponentTemplate> componentTemplates) {
            }
                IndexAbstraction.Index index;
        public Settings transientSettings() {
            coordinationMetadata.writeTo(out);
        EnumSet.of(ClusterBlockLevel.WRITE, ClusterBlockLevel.METADATA_WRITE)
            return ((DataStreamMetadata) customs.get(DataStreamMetadata.TYPE)).dataStreams().get(dataStreamName);
                .filter(aliasOrIndex -> aliasOrIndex.getType() == IndexAbstraction.Type.ALIAS)
        return customCount1 == customCount2;
    public String[] getConcreteAllClosedIndices() {
     * closed indices.
    }
            mapping = sourceAsMap;
        IndexAbstraction result = getIndicesLookup().get(aliasOrIndex);
        String[] allIndices,
            .filter(indices.keySet()::contains)
                throw new IllegalStateException(
    /**
    /**
        }
        Map<String, Object> properties = (Map<String, Object>) mapping.get("properties");
            StreamSupport.stream(Spliterators.spliterator(customs.entrySet(), 0), false)
                            + aliasMd.indexRouting()
                builder.startObject("metadata");
        public Builder put(DataStream dataStream) {
                IndexMetadata indexMetadata = this.indices.get(index);
 * specific language governing permissions and limitations
        String clusterUUID,
            indexNames[i++] = indexMetadata.getIndex().getName();
            }
            existing.remove(workloadGroup.get_id());
    public CoordinationMetadata coordinationMetadata() {
                    for (String alias : aliasDuplicatesWithIndices) {
        }
        false,
            .forEach((idx) -> indexMapBuilder.put(idx, filterFields(indices.get(idx).mapping(), fieldFilter.apply(idx))));
            // Alias routing overrides the parent routing (if any).
            builder.put(IndexTemplateMetadata.readFrom(in));
        Settings persistentSettings,
    }
                            logger.warn("Skipping unknown custom object with type {}", currentFieldName);
            }
/**
    public IndexMetadata index(Index index) {
            .map(ComposableIndexTemplateMetadata::indexTemplates)
            return this;
        }
         * @param numberOfSearchReplicas the number of search replicas
        String[] indexNames = new String[result.getIndices().size()];
            existing.put(workloadGroup.get_id(), workloadGroup);
        }
         * Update the number of replicas for the specified indices.
        boolean clusterUUIDCommitted,
    }
        return this.indices;
            this.indices = new HashMap<>(metadata.indices);
    @Override
     * Returns the {@link IndexMetadata} for this index.
    private final String[] allClosedIndices;
        }
            return this;
        if (!metadata1.hashesOfConsistentSettings.equals(metadata2.hashesOfConsistentSettings)) {
    public void writeTo(StreamOutput out) throws IOException {
            final Set<String> dataStreamDuplicatesWithIndices = new HashSet<>(allDataStreams);
            }
}
                for (IndexMetadata indexMetadata : metadata) {
        private final Settings persistentSettings;
            this.clusterUUIDCommitted = clusterUUIDCommitted;
        public Builder indexTemplates(Map<String, ComposableIndexTemplate> indexTemplates) {
 * ownership. Elasticsearch licenses this file to you under
        String[] visibleIndices,
            // we might get here after the meta-data element, or on a fresh parser
 * this work for additional information regarding copyright
            return this;
                patterns[i] = alias.substring(1);
            builder.transientSettings(transientSettings);
    }
        }
        private SortedMap<String, IndexAbstraction> buildIndicesLookup() {
            if (aliasDuplicatesWithDataStreams.isEmpty() == false) {
    public static final String CONTEXT_MODE_SNAPSHOT = XContentContext.SNAPSHOT.toString();
    public static final String UNKNOWN_CLUSTER_UUID = Strings.UNKNOWN_UUID_VALUE;
        return indices.get(index);
            this.customs.put(ComposableIndexTemplateMetadata.TYPE, new ComposableIndexTemplateMetadata(existingTemplates));
            } else {
            this.previousMetadata = metadata;
    );
                    assert existing == null : "duplicate data stream for " + dataStream.getName();
        }
            throw new IndexNotFoundException(index);
            .orElse(Collections.emptyMap());
                    } else if ("templates".equals(currentFieldName)) {
            if (filteredValues.isEmpty() == false) {
    private final Map<String, Custom> customs;
        if (writeIndex == null) {
     * @opensearch.api
                        + "] provided with routing value ["
                }
    public Map<String, ComposableIndexTemplate> templatesV2() {
                allClosedIndicesArray,
    /**
        String[] patterns = new String[aliases.length];
        10,
    /**
                systemTemplatesLookup = new HashMap<>();
            clusterUUIDCommitted = in.readBoolean();
                }
     */
                }
        int totalNumberOfShards = 0;
        return metadata1.coordinationMetadata.equals(metadata2.coordinationMetadata);
        }
     * that point to the specified concrete indices (directly or matching indices via wildcards).
                } else {
        return routing;
            return builder.build();
                visibleClosedIndicesArray,
            putCustom(IndexGraveyard.TYPE, indexGraveyard);
                    );
                        builder.hashesOfConsistentSettings(parser.mapStrings());
            throw new IndexNotFoundException(
                        + Strings.collectionToCommaDelimitedString(duplicates)
        this.totalOpenLocalOnlyIndexShards = totalOpenLocalOnlyIndexShards;
                .forEach(alias -> ((IndexAbstraction.Alias) alias).computeAndValidateAliasProperties());
            }
     */
        private Map<String, WorkloadGroup> getWorkloadGroups() {
     * The collection of index deletions in the cluster.
        String[] allOpenIndices,
     */
                }
            );
        public Builder templates(TemplatesMetadata templatesMetadata) {
        assert concreteIndices != null;
     *
            return indices.get(index);
        }
            hashesOfConsistentSettings = DiffableStringMap.readDiffFrom(in);
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
     * Returns all of the concrete indices that are closed and not hidden.
                    filteredValues.add(value);
                final boolean visible = IndexMetadata.INDEX_HIDDEN_SETTING.get(indexMetadata.getSettings()) == false;
    }
        }
                Optional.ofNullable((ComponentTemplateMetadata) this.customs.get(ComponentTemplateMetadata.TYPE))
        return this.transientSettings;
        return this.settings;
        API,
                if (matched) {
                } else if (token == XContentParser.Token.START_OBJECT) {
            persistentSettings = after.persistentSettings;
     * Gets the total number of shards from all indices, including replicas and
                        }
                );
            .orElse(Collections.emptyMap());
            return new Metadata(
    public Settings settings() {
                    }
        return Optional.ofNullable((ComposableIndexTemplateMetadata) this.custom(ComposableIndexTemplateMetadata.TYPE))
     * Finds the parent data streams, if any, for the specified concrete indices.
                transientSettings,
        this.totalOpenRemoteCapableIndexShards = totalOpenRemoteCapableIndexShards;
                if (indexMetadata.getIndexUUID().equals(index.getUUID())) {
     *
     * Finds the specific index aliases that match with the specified aliases directly or partially via wildcards, and
                indices,
                    );
            this.customs.put(ComponentTemplateMetadata.TYPE, new ComponentTemplateMetadata(componentTemplates));
        "cluster.default_number_of_replicas",
        }
        assert concreteIndices != null;
        public Builder removeTemplate(String templateName) {
            boolean isMultiField = false;
            }
        public Settings persistentSettings() {
import org.opensearch.core.xcontent.ToXContentFragment;
    // in the index,bulk,update and delete apis.
    private final long version;
     */
            assert index != null;
    }
            clusterUUID = after.clusterUUID;
    /**
         * @return the builder
                }
                : buildMetadataWithRecomputedIndicesLookups();
        builder.clusterUUID = in.readString();
     */
                                if (iv == null) {
        return routing;
    }
     *
        for (IndexMetadata indexMetadata : result.getIndices()) {
                    }
        static void validateDataStreams(SortedMap<String, IndexAbstraction> indicesLookup, @Nullable DataStreamMetadata dsMetadata) {
    }
            return this;
    public static boolean isExplicitAllType(String[] types) {
        SNAPSHOT
        out.writeVInt(indices.size());
    public Map<String, IndexTemplateMetadata> templates() {
        }
    public Map<String, Custom> customs() {
                    duplicates.add("data stream [" + dataStream + "] conflicts with index");
        false,
            transientSettings = after.transientSettings;
                for (int i = 0; i < patterns.length; i++) {
    }
            return this;
import java.util.stream.StreamSupport;
                    if ("cluster_coordination".equals(currentFieldName)) {
    private final SortedMap<String, IndexAbstraction> indicesLookup;
    /**
        }
    /**
    public long version() {
            if (IndexMetadata.State.OPEN.equals(cursor.getState())) {
                        "Alias ["
        }
    }
    }
        return indicesLookup;
                    mayRemove = filterFields(newPath, properties, fieldPredicate);
                    indicesLookup.compute(aliasMetadata.getAlias(), (aliasName, alias) -> {
                            return new IndexAbstraction.Alias(aliasMetadata, indexMetadata);
        MetadataDiff(Metadata before, Metadata after) {
            Objects.requireNonNull(indexTemplate, "it is invalid to add a null index template: " + name);
            this.indices.putAll(indices);
        }
                    builder.endObject();
                if (indexMetadata.getState() == IndexMetadata.State.OPEN) {
    public Map<String, WorkloadGroup> workloadGroups() {
                if (properties != null) {
        }
        private final Diff<DiffableStringMap> hashesOfConsistentSettings;
            }
    }
import java.util.Set;
                        if (matched == false) {
                    assert parent.getIndices().contains(indexMetadata.getIndex());
import java.util.List;
            return aliasMd.indexRouting();
                    token = parser.nextToken();
            }
        }
            Builder.toXContent(state, builder, FORMAT_PARAMS);
    }
    }
        public Builder hashesOfConsistentSettings(Map<String, String> hashesOfConsistentSettings) {
    private static final ToXContent.Params FORMAT_PARAMS;
    /**
 * You may obtain a copy of the License at
        }
                                + ds.getName()
    public static EnumSet<XContentContext> API_ONLY = EnumSet.of(XContentContext.API);
import org.opensearch.cluster.Diffable;
            Map<String, DataStream> indexToDataStreamLookup = new HashMap<>();
import org.opensearch.common.UUIDs;
            final Set<String> aliasDuplicatesWithIndices = new HashSet<>(allAliases);
            }
            indexGraveyard(IndexGraveyard.builder().build()); // create new empty index graveyard to initialize
                        "index uuid doesn't match expected: [" + index.getUUID() + "] but got: [" + indexMetadata.getIndexUUID() + "]"
     *
        Map<String, Object> mapping;
        this.clusterUUIDCommitted = clusterUUIDCommitted;
                    "index uuid doesn't match expected: [" + index.getUUID() + "] but got: [" + metadata.getIndexUUID() + "]"
import java.util.Optional;
                    for (Index i : dataStream.getIndices()) {
            return indicesLookup;
        }
                    if (conflicts.size() > 0) {
            this.customs.put(WorkloadGroupMetadata.TYPE, new WorkloadGroupMetadata(workloadGroups));
        return this.templates.getTemplates();
import java.util.regex.Pattern;
            this.hashesOfConsistentSettings = metadata.hashesOfConsistentSettings;
                        .stream()
            mapping = (Map<String, Object>) sourceAsMap.get(mappingMetadata.type());
                        .filter(s -> IndexMetadata.parseIndexNameCounter(s) > ds.getGeneration())
            return false;
    }
            if (routing != null) {
                                + conflicts.iterator().next()
         * @param indicesLookup the indices in the system (this includes the data stream backing indices)
            if (incrementVersion) {
                        if (mayRemove = filterFields(newPath, subFields, fieldPredicate)) {
            Map<String, ComponentTemplate> existingTemplates = Optional.ofNullable(
import org.opensearch.core.xcontent.XContentBuilder;
            ).map(ctm -> new HashMap<>(ctm.componentTemplates())).orElse(new HashMap<>());
import java.util.TreeMap;
        long version,
    public <T extends Custom> T custom(String type) {
    }
    ) {
        private final long version;
            IndexGraveyard graveyard = (IndexGraveyard) getCustom(IndexGraveyard.TYPE);
            for (String index : indices) {
 * the Apache License, Version 2.0 (the "License"); you may
                } else if (token.isValue()) {
            return false;
    /**
        for (int i = 0; i < customSize; i++) {
        }
        return templates();
import org.opensearch.core.rest.RestStatus;
            metadata.templatesMetadata().toXContent(builder, params);
        }
                    }
                            ((IndexAbstraction.Alias) alias).addIndex(indexMetadata);
        return Collections.unmodifiableMap(indexMapBuilder);
                        new IndexAbstraction.DataStream(dataStream, backingIndices)
            return parser.namedObject(Custom.class, name, null);
        for (IndexMetadata indexMetadata : this) {
                        }
     * @return The total number of open shards from all indices.
        }
     * @return true if index uses SEGMENT replication, false otherwise
     */
            if (dsMetadata != null) {
        this.indices = Collections.unmodifiableMap(indices);
            return Map.of();
            }
        return metadata1.hashesOfConsistentSettings.equals(metadata2.hashesOfConsistentSettings);
        }
            } else {
    public Map<String, IndexAbstraction.DataStream> findDataStreams(String[] concreteIndices) {
        }
            }
        }
        hashesOfConsistentSettings.writeTo(out);
            }
    /**
            }
                            map.remove("fields");
                if (!routing.equals(aliasMd.indexRouting())) {
                    allDataStreams.add(dataStream.getName());
        public DataStream dataStream(String dataStreamName) {
                )
            }
                (ComposableIndexTemplateMetadata) this.customs.get(ComposableIndexTemplateMetadata.TYPE)
                indices,
     */
     * Returns all of the concrete indices that are closed.
        public Builder hashesOfConsistentSettings(DiffableStringMap hashesOfConsistentSettings) {
            // If there are no indices, then skip data streams. This happens only when metadata is read from disk
     * that point to the specified concrete indices (directly or matching indices via wildcards).
            customs.put(type, Objects.requireNonNull(custom, type));
    }
        return indices();
            this.version = metadata.version;
                throw new IllegalArgumentException(
     * a snapshot global state, but will not be persisted between node restarts
                }
            }
            customs.remove(type);
        }
                    });
            indexMetadata.writeTo(out);
    /**
                            + routing
            customs = new HashMap<>();
                    builder.startObject(cursor.getKey());
        /**
        this.allClosedIndices = allClosedIndices;
                            Custom custom = Custom.fromXContent(parser, currentFieldName);
    private final boolean clusterUUIDCommitted;
    public boolean hasIndex(String index) {
        for (int i = 0; i < size; i++) {
            }
        IndexMetadata metadata = index(index.getName());
                                + "] could create backing indices that conflict with "
     * @return The total number of open shards from all indices.
            }
    /**
                IndexAbstraction existing = indicesLookup.put(indexMetadata.getIndex().getName(), index);
    }
                // iterate again and constructs a helpful message
            return this;
    public Iterator<IndexMetadata> iterator() {
            this.templates.putAll(templatesMetadata.getTemplates());
        /* Custom metadata should be stored as part of the persistent cluster state */
        // filter out custom states not supported by the other node
                        + aliasOrIndex
                    map.put("properties", subFields);
import java.util.Comparator;
        public Builder workloadGroups(final Map<String, WorkloadGroup> workloadGroups) {
        return this.customs;
     * node restarts, but will not be a part of a snapshot global state
    public static boolean isCoordinationMetadataEqual(Metadata metadata1, Metadata metadata2) {
            return workloadGroups(existing);
    }
            this.hashesOfConsistentSettings = new DiffableStringMap(hashesOfConsistentSettings);
        Arrays.stream(concreteIndices)
import org.opensearch.indices.replication.common.ReplicationType;
    /**
    }
    }
                version,
    public interface Custom extends NamedDiffable<Custom>, ToXContentFragment, ClusterState.FeatureAware {
        Property.Dynamic,
        "cluster.blocks.read_only",
        }
    }
     * Finds all mappings for concrete indices. Only fields that match the provided field
            if (value instanceof Map) {
        public DiffableStringMap hashesOfConsistentSettings() {
            }
        "cluster read-only / allow delete (api)",
import org.opensearch.core.common.io.stream.StreamOutput;
                .orElse(Collections.emptyMap());
        this.indicesLookup = indicesLookup;
                            + "], and was provided with routing value ["
 */
            Map<String, WorkloadGroup> existing = new HashMap<>(getWorkloadGroups());
            // 1) The datastructures will be rebuilt only when needed. Now during serializing we rebuild these datastructures
    public IndexMetadata index(String index) {
    /**
    }
                    throw new IllegalArgumentException(
                Arrays.copyOf(previousMetadata.visibleClosedIndices, previousMetadata.visibleClosedIndices.length),
    public static boolean isCustomMetadataEqual(Metadata metadata1, Metadata metadata2) {
        }
            if (context != XContentContext.API && !metadata.persistentSettings().isEmpty()) {
            this.coordinationMetadata = coordinationMetadata;
    );
        }
        filterFields("", properties, fieldPredicate);
                } else {
    public static final Setting<Boolean> SETTING_CREATE_INDEX_BLOCK_SETTING = Setting.boolSetting(
        GATEWAY,
                            duplicates.add(alias + " (alias of " + cursor.getIndex() + ") conflicts with data stream");
        final Map<String, IndexTemplateMetadata> templates,
    public boolean hasConcreteIndex(String index) {
            }
    public Map<String, Custom> getCustoms() {
                }
                                + conflicts.size()
            builder.putCustom(customIndexMetadata.getWriteableName(), customIndexMetadata);
                if (indexMetadata == null) {
                }
            .orElse(Collections.emptyMap());
import org.opensearch.core.common.Strings;
            if (dataStreamMetadata != null) {
        IndexMetadata metadata = index(index.getName());
    private final String[] visibleClosedIndices;
        }
        @Override
    }
                                    iv = new TreeMap<>();
            customs = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);
import java.util.Map;
    public static final ClusterBlock CLUSTER_CREATE_INDEX_BLOCK = new ClusterBlock(
     * Finds the specific index aliases that match with the specified aliases directly or partially via wildcards, and
                // Make the list order deterministic
            Object value = entry.getValue();
            return (recomputeRequiredforIndicesLookups == false)
    }
        private final String clusterUUID;
        public Builder updateNumberOfReplicas(final int numberOfReplicas, final String[] indices) {
        final Map<String, List<AliasMetadata>> mapBuilder = new HashMap<>();
        return this.clusterUUIDCommitted;
                systemTemplatesLookup = Collections.unmodifiableMap(previousMetadata.systemTemplatesLookup);
            hashesOfConsistentSettings.writeTo(out);
            if (mappingMetadata != null) {
            SortedMap<String, IndexAbstraction> indicesLookup = Collections.unmodifiableSortedMap(buildIndicesLookup());
        }
    }
    /**
    public static EnumSet<XContentContext> API_AND_GATEWAY = EnumSet.of(XContentContext.API, XContentContext.GATEWAY);
                if (indexMetadata == null) {
    /**
            assert index.getType() == IndexAbstraction.Type.CONCRETE_INDEX;
    public static class Builder {
            clusterUUIDCommitted = after.clusterUUIDCommitted;
            // Alias routing overrides the parent routing (if any).
                + "] has more than one index associated with it ["
 * Licensed to Elasticsearch under one or more contributor
                    } else if ("indices".equals(currentFieldName)) {
         * <p>
                currentFieldName = parser.currentName();
    private final Settings persistentSettings;
            existingTemplates.remove(name);
    }
                systemTemplatesLookup
     * Gets the total number of open remote capable shards from all indices. Includes
        for (int i = 0; i < aliases.length; i++) {
                        }
            .map(WorkloadGroupMetadata::workloadGroups)
     */
        RestStatus.FORBIDDEN,
            }
            return false;
    /**
            String currentFieldName = parser.currentName();
            return this.persistentSettings;
        public Builder indexGraveyard(final IndexGraveyard indexGraveyard) {
        public Builder put(IndexTemplateMetadata template) {
        return findAliases(aliasesRequest.aliases(), concreteIndices);
            if (metadata.getIndexUUID().equals(index.getUUID())) {
            return this;
                allOpenIndicesArray,
        return this.hashesOfConsistentSettings;
        }
    public IndexGraveyard indexGraveyard() {
            }
        return this.coordinationMetadata;
            if (aliasDuplicatesWithIndices.isEmpty() == false) {
                            + aliasMd.indexRouting()
                    Set<String> conflicts = indicesLookup.subMap(prefix, DataStream.BACKING_INDEX_PREFIX + ds.getName() + ".")
                        .filter(s -> NUMBER_PATTERN.matcher(s.substring(prefix.length())).matches())
            }
     * Custom metadata.
                include[i] = true;
                    IndexAbstraction existing = indicesLookup.put(
                    }
    }
     *
    public enum XContentContext {
                for (final IndexMetadata cursor : indices.values()) {
    @SuppressWarnings("unchecked")
                for (final IndexMetadata cursor : indices.values()) {
     */
                    }
        return this.totalOpenRemoteCapableIndexShards;
            this.customs.putAll(customs);
     * The empty or null array doesn't explicitly map to all types
            return routing;
                put(IndexMetadata.builder(indexMetadata).numberOfReplicas(numberOfReplicas));
        private static final DiffableUtils.DiffableValueReader<String, IndexMetadata> INDEX_METADATA_DIFF_VALUE_READER =
        public Builder persistentSettings(Settings settings) {
        return builder;
        public Builder put(IndexTemplateMetadata.Builder template) {
            // TODO: I think we can remove these arrays. it isn't worth the effort, for operations on all indices.
    private void rejectSingleIndexOperation(String aliasOrIndex, IndexAbstraction result) {
import org.opensearch.cluster.DiffableUtils;
        }
import org.opensearch.cluster.block.ClusterBlockLevel;
        public Custom getCustom(String type) {
    public static boolean isTransientSettingsMetadataEqual(Metadata metadata1, Metadata metadata2) {
    /**
        final Map<String, MappingMetadata> indexMapBuilder = new HashMap<>();
                )) {
    public Map<String, MappingMetadata> findMappings(String[] concreteIndices, Function<String, Predicate<String>> fieldFilter)
                } else {
    @PublicApi(since = "1.0.0")
            .map(ComponentTemplateMetadata::componentTemplates)
        if (aliasOrIndex == null) {
                builder.field("version", metadata.version());
            for (final Map.Entry<String, Custom> cursor : metadata.customs().entrySet()) {
        return custom(IndexGraveyard.TYPE);
 * KIND, either express or implied.  See the License for the
 */
         * `.ds-foo-000001`, `.ds-foo-000002` and `.ds-foo-000006` this will throw an IllegalStateException (as attempting to rollover the
        }
        Map<String, SortedMap<Long, String>> systemTemplatesLookup
         * @param dsMetadata    the data streams in the system
        }
            return aliasMd.indexRouting();
     * Gets the total number of open shards from all indices. Includes
    );
        public IndexGraveyard indexGraveyard() {
                Collections.unmodifiableSortedMap(previousMetadata.indicesLookup),
    static {
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
                    visibleIndices.add(name);
            return Builder.fromXContent(parser);
    }
    private final Map<String, IndexMetadata> indices;
import org.opensearch.common.Nullable;
            IndexAbstraction index = lookup.get(indexName);
                + aliasOrIndex
    private final String clusterUUID;
        out.writeLong(version);
        private boolean clusterUUIDCommitted;
                boolean matched = matchAllAliases;
        SortedMap<String, IndexAbstraction> indicesLookup,
                Arrays.copyOf(previousMetadata.allIndices, previousMetadata.allIndices.length),
            if (routing != null) {
     * @param aliases The aliases to look for. Might contain include or exclude wildcards.
         *
                    assert backingIndices.contains(null) == false;
 * The OpenSearch Contributors require contributions made to
        return new MappingMetadata(mappingMetadata.type(), sourceAsMap);
    };
                    }
        public IndexMetadata get(String index) {
import java.util.Collections;
            return false;
            return Map.of();
            }
        return true;
        return systemTemplatesLookup;
            if (thisIndex == null) {
        IndexAbstraction indexAbstraction = getIndicesLookup().get(alias);
            return false;
        return this.totalNumberOfShards;
        builder.coordinationMetadata(new CoordinationMetadata(in));
     * Finds the specific index aliases that point to the requested concrete indices directly
     * *
    public static boolean isGlobalResourcesMetadataEquals(Metadata metadata1, Metadata metadata2) {
 * Unless required by applicable law or agreed to in writing,
        this.templates = new TemplatesMetadata(templates);
    }
import java.util.function.Function;
    public static Diff<Metadata> readDiffFrom(StreamInput in) throws IOException {
        size = in.readVInt();
        AliasMetadata aliasMd = alias.getFirstAliasMetadata();
                String alias = value.alias();
                customs,
import org.opensearch.action.AliasesRequest;
                hashesOfConsistentSettings,
    }
    public boolean hasIndexMetadata(final IndexMetadata indexMetadata) {
        out.writeBoolean(clusterUUIDCommitted);
                    }
        }
            } else {
        }
            if (FeatureAware.shouldSerialize(out, cursor)) {
     * @opensearch.internal
        public Builder put(IndexMetadata indexMetadata, boolean incrementVersion) {
    }
     * filter will be returned (default is a predicate that always returns true, which can be
            return this;
        assert concreteIndices != null;
                    for (String alias : aliasDuplicatesWithDataStreams) {
                coordinationMetadata,
            builder.persistentSettings(persistentSettings);
    }
            if (index.getParentDataStream() != null) {
     */
            out.writeBoolean(clusterUUIDCommitted);
    }
            } else {
            return new Metadata(
            String[] visibleOpenIndicesArray = visibleOpenIndices.toArray(Strings.EMPTY_ARRAY);
     * @param concreteIndex The concrete index to check if routing is required
            this.clusterUUID = metadata.clusterUUID;
import org.opensearch.common.regex.Regex;
                        + "] that resolved to several routing values, rejecting operation"
    public TemplatesMetadata templatesMetadata() {
                Arrays.copyOf(previousMetadata.allOpenIndices, previousMetadata.allOpenIndices.length),
    @Override
            putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata);
        Builder builder = new Builder();
        }
                builder.put(indexName, index.getParentDataStream());
import java.util.HashSet;
            coordinationMetadata = new CoordinationMetadata(in);
            return routing;
            templates.put(template.name(), template);
    public IndexMetadata getIndexSafe(Index index) {
    public boolean equalsAliases(Metadata other) {
    }
    public int getTotalOpenIndexShards() {
            version = after.version;
            final Set<String> allAliases = new HashSet<>();
                allIndicesArray,
            this.transientSettings = metadata.transientSettings;
                        .collect(Collectors.toSet());
                }
        if (!metadata1.clusterUUID.equals(metadata2.clusterUUID)) {
    }
import java.util.HashMap;
        for (final Custom cursor : customs.values()) {
     */
     * Utility to identify whether input index uses SEGMENT replication strategy in established cluster state metadata.
     *
    public boolean routingRequired(String concreteIndex) {
        Property.Dynamic,
import java.io.IOException;
    /**
            if (alias.charAt(0) == '-') {
            builder.hashesOfConsistentSettings(hashesOfConsistentSettings.apply(part.hashesOfConsistentSettings));
     *
                transientSettings,
     * in the write index.
    private final Settings transientSettings;
                }
                ? buildMetadataWithPreviousIndicesLookups()
    /**
         * Update the number of search replicas for the specified indices.
     * @param concreteIndices The concrete indices that the aliases must point to in order to be returned
     */
                        isMultiField = true;
        this.hashesOfConsistentSettings = hashesOfConsistentSettings;
        "cluster.blocks.create_index",
                + "], can't execute a single index op"
    @PublicApi(since = "1.0.0")
        this.visibleClosedIndices = visibleClosedIndices;
            if (aliasMd.indexRouting().indexOf(',') != -1) {
        boolean[] include = new boolean[aliases.length];
    public Map<String, String> hashesOfConsistentSettings() {
        return visibleClosedIndices;
                customCount2++;
                        } catch (NamedObjectNotFoundException ex) {
        for (final Custom cursor : metadata2.customs.values()) {
         * @param indices          the indices to update the number of replicas for
        }
            this.customs = new HashMap<>(metadata.customs);
            for (String index : indices) {
                    index = new IndexAbstraction.Index(indexMetadata);
        Property.NodeScope
    }
    public String clusterUUID() {
        public Metadata build() {
                        visibleOpenIndices.add(name);
            return this;
            this.clusterUUIDCommitted = metadata.clusterUUIDCommitted;
    }
                            SystemTemplateMetadata templateMetadata = SystemTemplateMetadata.fromComponentTemplate(k);
                        }
            Objects.requireNonNull(workloadGroup, "workloadGroup should not be null");
    public static boolean isAllTypes(String[] types) {
     */
                clusterUUIDCommitted,
 * compatible open source license.
        out.writeVInt(numberOfCustoms);
                }
                    )
         * @return the builder
     *
                        + "were found ["
        return this.version;
        if (concreteIndices.length == 0) {
                persistentSettings,
            // When doing an operation across all indices, most of the time is spent on actually going to all shards and
    /**
                        .map(index -> indices.get(index.getName()))
            ).map(ctm -> new HashMap<>(ctm.componentTemplates())).orElse(new HashMap<>());
                put(IndexMetadata.builder(indexMetadata).settings(Settings.builder().put(indexMetadata.getSettings()).put(settings)));
            metadata.coordinationMetadata().toXContent(builder, params);
    public String[] getConcreteVisibleClosedIndices() {
            Settings.writeSettingsToStream(persistentSettings, out);
        Property.NodeScope
 * license agreements. See the NOTICE file distributed with
            out.writeLong(version);
            // only remove a field if it has no sub-fields left and it has to be excluded
    /**
        false,
        final SortedMap<String, IndexAbstraction> lookup = getIndicesLookup();
        return allIndices;
    /**
                }
    public static boolean isHashesOfConsistentSettingsEqual(Metadata metadata1, Metadata metadata2) {
        public void toXContent(XContentBuilder builder, Metadata state) throws IOException {
        IndexAbstraction result = getIndicesLookup().get(aliasOrIndex);
                                + " existing index(s) or alias(s)"
    @Override
            this.version = version;
    public static final Setting<Integer> DEFAULT_REPLICA_COUNT_SETTING = Setting.intSetting(
    }
            Map<String, DataStream> existingDataStreams = Optional.ofNullable(
                            duplicates.add(alias + " (alias of " + cursor.getIndex() + ") conflicts with index");
        }
 * Metadata information
                        + "] that resolved to several routing values, rejecting operation"
            return this;
                        visibleClosedIndices.add(name);
            return this;
    }
     * Context of the XContent.
        this.customs = Collections.unmodifiableMap(customs);
     * Indicates that this custom metadata will be returned as part of an API call but will not be persisted
            final Set<String> aliasDuplicatesWithDataStreams = new HashSet<>(allAliases);
        this.version = version;
            if (indexMetadata != null) {
                    throw new IllegalArgumentException(
import java.util.Spliterators;
import org.opensearch.cluster.routing.RoutingPool;
    );
        IndexMetadata metadata = index(index.getName());
     */
        }
            return metadata;
            return this;
                    this.customs.get(ComponentTemplateMetadata.TYPE)
            return this;
        return Optional.ofNullable((WorkloadGroupMetadata) this.custom(WorkloadGroupMetadata.TYPE))
        return metadata1.persistentSettings.equals(metadata2.persistentSettings);
     * @return A map of index name to the list of aliases metadata. If a concrete index does not have matching
            IndexMetadata indexMetadata = indices.get(index);
    public static final String CONTEXT_MODE_API = XContentContext.API.toString();
        }
import org.opensearch.gateway.MetadataStateFormat;
        return new Builder();
                } else {
                    // move to the field name (meta-data)
                    throw new IllegalArgumentException("Unexpected token " + token);
        out.writeString(clusterUUID);
                    currentFieldName = parser.currentName();
         * E.g., if data stream `foo` has backing indices [`.ds-foo-000001`, `.ds-foo-000002`] and the indices lookup contains indices
            Map<String, ComponentTemplate> existingTemplates = Optional.ofNullable(
            }
        }
    public int getTotalNumberOfShards() {
        if (aliasMd.indexRouting() != null) {
                    Map<String, Object> subFields = (Map<String, Object>) map.get("fields");
    public static boolean isTemplatesMetadataEqual(Metadata metadata1, Metadata metadata2) {
                                + "'"
                            matched = ALL.equals(pattern) || Regex.simpleMatch(pattern, alias);
    /**
                builder.startObject("meta-data");
     * Returns the merged transient and persistent settings.
    public static EnumSet<XContentContext> ALL_CONTEXTS = EnumSet.allOf(XContentContext.class);
     * @param indexName Index name
            ArrayList<String> duplicates = new ArrayList<>();
                        + "]"
    }
    }
            final List<String> visibleClosedIndices = new ArrayList<>();
            if (previousMetadata != null
    /**
            }
            builder.indices(indices.apply(part.indices));
        this.settings = Settings.builder().put(persistentSettings).put(transientSettings).build();
            return builder.build();
            rejectSingleIndexOperation(aliasOrIndex, result);
                }
                }
    public String[] getConcreteAllOpenIndices() {
    }
 * software distributed under the License is distributed on an
    public Map<String, SortedMap<Long, String>> systemTemplatesLookup() {
        builder.transientSettings(readSettingsFromStream(in));
        public Metadata apply(Metadata part) {
            if (dataStreamDuplicatesWithIndices.isEmpty() == false) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                        builder.templates(TemplatesMetadata.fromXContent(parser));
        coordinationMetadata.writeTo(out);
        if (result == null || result.getType() != IndexAbstraction.Type.ALIAS) {
    }
        false,
                version,
        false,
            version = in.readLong();
                include[i] = false;
            Objects.requireNonNull(workloadGroup, "workloadGroup should not be null");
     * Returns all the concrete indices that are not hidden.
     */
        }
     * Whether the current node with the given cluster state is locked into the cluster with the UUID returned by {@link #clusterUUID()},
                clusterUUIDCommitted,
        }
        false,
            IndexMetadata indexMetadata = indexMetadataBuilder.build();
/*
            templates = new HashMap<>();
    /**
        }
                    entryIterator.remove();
            this.clusterUUID = clusterUUID;
                    } else if ("cluster_uuid_committed".equals(currentFieldName)) {
        public Builder remove(String index) {
            return this;
        }
     */
            Builder builder = builder();
    }
                }
            if (indices == null || indices.length == 0) {
        }
                ? (DataStreamMetadata) this.previousMetadata.customs.get(DataStreamMetadata.TYPE)
    public static EnumSet<XContentContext> API_AND_SNAPSHOT = EnumSet.of(XContentContext.API, XContentContext.SNAPSHOT);
                }
        true,
        }
        final Map<String, IndexAbstraction.DataStream> builder = new HashMap<>();
        if (mappingMetadata == null) {
    }
                        throw new IllegalArgumentException("Expected a field name but got " + token);
                    });
    public boolean hasAlias(String alias) {
    private final Map<String, SortedMap<Long, String>> systemTemplatesLookup;
        }
        return Optional.ofNullable((DataStreamMetadata) this.custom(DataStreamMetadata.TYPE))
        }
            return this;
                || (indices.equals(previousMetadata.indices) == false)
    private static boolean filterFields(String currentPath, Map<String, Object> fields, Predicate<String> fieldPredicate) {
            Objects.requireNonNull(dataStream, "it is invalid to add a null data stream");
    }
        return isCustomMetadataEqual(metadata1, metadata2);
     * @throws IndexNotFoundException if no metadata for this index is found
            }
            clusterUUID = in.readString();
                    if (token != XContentParser.Token.FIELD_NAME) {
            indices.remove(index);
        public Builder put(IndexMetadata.Builder indexMetadataBuilder) {
            return this;
                for (String dataStream : dataStreamDuplicatesWithIndices) {
            }
            return put(template.build());
            }
        return new MetadataDiff(in);
import java.util.Iterator;
                        + aliasMd.getIndexRouting()
                    if (subFields != null) {
                            + aliasOrIndex
    public static final Setting<Boolean> SETTING_READ_ONLY_ALLOW_DELETE_SETTING = Setting.boolSetting(
        return this.totalOpenLocalOnlyIndexShards;
        for (String index : concreteIndices) {
                if (token == XContentParser.Token.START_OBJECT) {
     * Identifies whether the array containing type names given as argument explicitly refers to all types
                if (!cursor.getValue().equals(metadata2.custom(cursor.getKey()))) return false;
                    }
        private void buildSystemTemplatesLookup() {
import org.opensearch.index.IndexNotFoundException;
            return this;
                put(IndexMetadata.builder(indexMetadata).numberOfSearchReplicas(numberOfSearchReplicas));
        return false;
    public static final NamedDiffableValueSerializer<Custom> CUSTOM_VALUE_SERIALIZER = new NamedDiffableValueSerializer<>(Custom.class);
        false,
        return metadata1.templates.equals(metadata2.templates);
        false,
    }
    public static final String ALL = "_all";
                if (RoutingPool.getIndexPool(cursor) == RoutingPool.REMOTE_CAPABLE) {
        private final Diff<Map<String, IndexTemplateMetadata>> templates;
     */
            indices = new HashMap<>();
        return Builder.fromXContent(parser);
    private Map<String, List<AliasMetadata>> findAliases(final String[] aliases, final String[] concreteIndices) {
public class Metadata implements Iterable<IndexMetadata>, Diffable<Metadata>, ToXContentFragment {
    private final int totalOpenLocalOnlyIndexShards;
import org.opensearch.cluster.block.ClusterBlock;
        }
        }
        throw new IllegalArgumentException(
import java.util.stream.Collectors;
            return (DecommissionAttributeMetadata) getCustom(DecommissionAttributeMetadata.TYPE);
                (ComponentTemplateMetadata) this.customs.get(ComponentTemplateMetadata.TYPE)
        static Custom fromXContent(XContentParser parser, String name) throws IOException {
    public WeightedRoutingMetadata weightedRoutingMetadata() {
            return mappingMetadata;
                Arrays.copyOf(previousMetadata.visibleOpenIndices, previousMetadata.visibleOpenIndices.length),
        EnumSet<XContentContext> context();
        }
                }
    }
            builder.endObject();
     * Returns all of the concrete indices that are open and not hidden.
     * @param concreteIndices The concrete indices that the aliases must point to in order to be returned.
    /**
                    if (visible) {
            builder.startObject("templates");
                                return iv;
        return custom(DecommissionAttributeMetadata.TYPE);
    }
     * Indicates that this custom metadata will be returned as part of an API call and stored as a part of
        public Builder decommissionAttributeMetadata(final DecommissionAttributeMetadata decommissionAttributeMetadata) {
                IndexMetadata indexMetadata = this.indices.get(index);
     */
            boolean mayRemove = true;
                    // move to the next object
            String[] visibleClosedIndicesArray = visibleClosedIndices.toArray(Strings.EMPTY_ARRAY);
        }
 * SPDX-License-Identifier: Apache-2.0
                            + "], rejecting operation"
                if (cursor.getValue().context().contains(context)) {
        1,
     */
            return this;
                } else if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
            indices.writeTo(out);
        public Builder generateClusterUuidIfNeeded() {
            return this;
     * Note: Method intended for use by other plugins as well.
     *
        return path + "." + field;
    @PublicApi(since = "1.0.0")
    }
            }
            builder.field("cluster_uuid_committed", metadata.clusterUUIDCommitted);
        }
                .map(o -> (WorkloadGroupMetadata) o)
        public Metadata fromXContent(XContentParser parser) throws IOException {
     */
        return allOpenIndices;
     * aliases then the result will <b>not</b> include the index's key.
        return this.customs();
        private final CoordinationMetadata coordinationMetadata;
        int customCount1 = 0;
        IndexAbstraction.Alias alias = (IndexAbstraction.Alias) result;
        for (int i = 0; i < size; i++) {
                coordinationMetadata,
    public String[] getConcreteVisibleOpenIndices() {
        EnumSet.of(ClusterBlockLevel.CREATE_INDEX)
                throw new IllegalArgumentException("Expected [meta-data] as a field name but got " + currentFieldName);
            this.customs.put(ComponentTemplateMetadata.TYPE, new ComponentTemplateMetadata(existingTemplates));
        public Builder clusterUUIDCommitted(boolean clusterUUIDCommitted) {
    private final String[] allOpenIndices;
    private final CoordinationMetadata coordinationMetadata;
            this.customs.put(ComposableIndexTemplateMetadata.TYPE, new ComposableIndexTemplateMetadata(indexTemplates));
    private final String[] visibleIndices;
                builder.endObject();
            aliasDuplicatesWithDataStreams.retainAll(allDataStreams);
                if (visible) {
        }
                    new IllegalStateException(
            }
            for (String index : indices) {
                (ComposableIndexTemplateMetadata) this.customs.get(ComposableIndexTemplateMetadata.TYPE)
                        }
                        throw new IllegalStateException(
     * replicas, but does not include shards that are part of closed indices.
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
        return allClosedIndices;
        /* Custom metadata should be stored as part of a snapshot */
            return field;
        /**
        private DiffableStringMap hashesOfConsistentSettings = new DiffableStringMap(Collections.emptyMap());
    }
        return Collections.unmodifiableMap(builder);
                new IllegalStateException(
                templates,
        public Builder dataStreams(Map<String, DataStream> dataStreams) {
                CollectionUtil.timSort(filteredValues, Comparator.comparing(AliasMetadata::alias));
 *
    public Diff<Metadata> diff(Metadata previousState) {
    private final transient int totalNumberOfShards; // Transient ? not serializable anyway?
     */
    public SortedMap<String, IndexAbstraction> getIndicesLookup() {
        String[] visibleClosedIndices,
            for (final IndexMetadata indexMetadata : indices.values()) {
        throws IOException {
    /**
        }
        }
        }
                            + "], and was provided with routing value ["
                            builder.put(IndexMetadata.Builder.fromXContent(parser), false);
                persistentSettings,
     * @return true if the provided array explicitly maps to all types, false otherwise
        int customCount2 = 0;
            return Optional.ofNullable(this.customs.get(WorkloadGroupMetadata.TYPE))
        EnumSet.of(ClusterBlockLevel.WRITE, ClusterBlockLevel.METADATA_WRITE)
                        );
            )
                IndexMetadata indexMetadata = this.indices.get(index);
                    "index, alias, and data stream names need to be unique, but the following duplicates "
     * @opensearch.api
            }
            this.customs.put(DataStreamMetadata.TYPE, new DataStreamMetadata(existingDataStreams));
        /**
        }
            if (indices.get(indexMetadata.getIndex().getName()) == indexMetadata) {
        return this.templates;
            return routing;
/*
                    map.remove("type");
                );
            return false;
     * The empty or null array identifies all types
        }
    public static final Setting<Boolean> SETTING_READ_ONLY_SETTING = Setting.boolSetting(
     */
                    totalOpenLocalOnlyIndexShards += cursor.getTotalNumberOfShards();
    }
            for (final AliasMetadata value : indexMetadata.getAliases().values()) {
     * @opensearch.api
        /* Custom metadata should be returns as part of API call */
     * Compares Metadata entities persisted in Remote Store.
        private CoordinationMetadata coordinationMetadata = CoordinationMetadata.EMPTY_METADATA;
            builder.clusterUUID(clusterUUID);
            return this;
        Property.Dynamic,
        return visibleIndices;
        return types != null && types.length == 1 && ALL.equals(types[0]);
            String newPath = mergePaths(currentPath, entry.getKey());
                }
            persistentSettings = Settings.readSettingsFromStream(in);
    /**
                                }
                + Arrays.toString(indexNames)
     * Returns indexing routing for the given <code>aliasOrIndex</code>. Resolves routing from the alias metadata used
                out.writeNamedWriteable(cursor);
                        dataStream.getName(),
                        try {
                    List<IndexMetadata> backingIndices = dataStream.getIndices()
        int numberOfCustoms = 0;
        }
            return this;
            // we know its a new one, increment the version and store
                indexMetadata = IndexMetadata.builder(indexMetadata).version(indexMetadata.getVersion() + 1).build();
            List<AliasMetadata> filteredValues = new ArrayList<>();
                            + "] has index routing associated with it ["
                indicesLookup,
                systemTemplatesLookup
        return custom(WeightedRoutingMetadata.TYPE);
            if (FeatureAware.shouldSerialize(out, cursor)) {
            }
            templates.remove(templateName);
    }
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;
            DataStreamMetadata dataStreamMetadata = (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE);
    public static Metadata readFrom(StreamInput in) throws IOException {
                    previousMetadata.customs.get(ComponentTemplateMetadata.TYPE),
     * meaning that it will not accept any cluster state with a different clusterUUID.
        }
    private static MappingMetadata filterFields(MappingMetadata mappingMetadata, Predicate<String> fieldPredicate) {
import org.opensearch.cluster.coordination.CoordinationMetadata;
                    allOpenIndices.add(name);
    );
        AliasMetadata aliasMd = writeIndex.getAliases().get(result.getName());
                    .equals(ReplicationType.SEGMENT)
                    cursor.getValue().toXContent(builder, params);
        public Builder(Metadata metadata) {
    public static final MetadataStateFormat<Metadata> FORMAT = new MetadataStateFormat<Metadata>(GLOBAL_STATE_FILE_PREFIX) {
            // if we put a new index metadata, increment its version
                    .map(ComponentTemplateMetadata::componentTemplates)
                return mappingMetadata.routingRequired();
import org.opensearch.core.xcontent.ToXContent;
                (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE)
            ).map(itmd -> new HashMap<>(itmd.indexTemplates())).orElse(new HashMap<>());
            indexMetadataBuilder.version(indexMetadataBuilder.version() + 1);
    Metadata(
import org.apache.logging.log4j.Logger;
import org.opensearch.core.xcontent.XContentParser;
            indices.put(indexMetadata.getIndex().getName(), indexMetadata);
     * @see MapperPlugin#getFieldFilter()
            // do the required operations, the bottleneck isn't resolving expressions into concrete indices.
                    );
        public Builder transientSettings(Settings settings) {
        }
     * @param types the array containing index names
 * GitHub history for details.
    }
import org.opensearch.cluster.ClusterState;
                            parser.skipChildren();
     * @param types the array containing types
        }
                }
            String[] visibleIndicesArray = visibleIndices.toArray(Strings.EMPTY_ARRAY);
            for (final IndexMetadata indexMetadata : indices.values()) {
            );
        @Override
            }
        Map<String, String> params = new HashMap<>(2);
        int size = in.readVInt();
         */
     * Identifies whether the array containing type names given as argument refers to all types
@PublicApi(since = "1.0.0")
                index,
        throw new IndexNotFoundException(index);
                before.templates.getTemplates(),
            hashesOfConsistentSettings = after.hashesOfConsistentSettings.diff(before.hashesOfConsistentSettings);
            this.transientSettings = settings;
                builder.endObject();
            validateDataStreams(indicesLookup, (DataStreamMetadata) customs.get(DataStreamMetadata.TYPE));
 *
    }
            }
        int totalOpenLocalOnlyIndexShards = 0;
     */
     * @return The total number shards from all indices.
    public static boolean isGlobalStateEquals(Metadata metadata1, Metadata metadata2) {
        return types == null || types.length == 0 || isExplicitAllType(types);
                indexMetadata.getAliases().keySet().iterator().forEachRemaining(allAliases::add);
                builder.startObject("settings");
            this.templates = new HashMap<>(metadata.templates.getTemplates());
                            + aliasOrIndex
                    .forEach((k, v) -> {
                DiffableUtils.getStringKeySerializer()
                            + "], rejecting operation"
                        + "] provided with routing value ["
import org.opensearch.common.xcontent.XContentHelper;
    // TODO: This can be moved to IndexNameExpressionResolver too, but this means that we will support wildcards and other expressions
        public Builder put(String name, ComponentTemplate componentTemplate) {
            if (cursor.getValue().context().contains(XContentContext.GATEWAY)) {
    public Settings transientSettings() {
        }
        if (metadata != null) {
                    index,
            previousMetadata = null;
import org.opensearch.common.settings.Setting;
        }
                return metadata;
    /**
        private final Settings transientSettings;
                    } else if (matched) {
            Map<String, ComposableIndexTemplate> existingTemplates = Optional.ofNullable(
        private final Map<String, Custom> customs;
            }
        RestStatus.FORBIDDEN,
        }
        return metadata1.transientSettings.equals(metadata2.transientSettings);
    public static Builder builder(Metadata metadata) {
     * Builder of metadata.
 * @opensearch.api
        return (T) customs.get(type);
        final Map<String, Custom> customs,
    public static Metadata fromXContent(XContentParser parser) throws IOException {
            builder.field("cluster_uuid", metadata.clusterUUID);
            SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
            builder.endObject();
        return getIndicesLookup().containsKey(index);
        Property.Dynamic,
        public Builder() {
        for (String indexName : concreteIndices) {
        "cluster create-index blocked (api)",
        protected Metadata buildMetadataWithPreviousIndicesLookups() {
                    throw new IndexNotFoundException(index);
import org.opensearch.common.annotation.PublicApi;
                        matched = Regex.simpleMatch(patterns[i], alias) == false;
            return this;
        if (indexAbstraction != null) {
        public Builder put(String name, ComposableIndexTemplate indexTemplate) {
