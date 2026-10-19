            }
            return MappingMetadata.EMPTY_MAPPINGS;
                                    iv = new TreeMap<>();
                        matched = Regex.simpleMatch(patterns[i], alias) == false;
                + aliasOrIndex
    public static EnumSet<XContentContext> API_AND_GATEWAY = EnumSet.of(XContentContext.API, XContentContext.GATEWAY);  
            // do the required operations, the bottleneck isn't resolving expressions into concrete indices.  
        EnumSet.of(ClusterBlockLevel.WRITE, ClusterBlockLevel.METADATA_WRITE)  
                );
     * Gets the total number of open remote capable shards from all indices. Includes  
                throw new IllegalArgumentException("Expected [meta-data] as a field name but got " + currentFieldName);  
    public static final ClusterBlock CLUSTER_READ_ONLY_BLOCK = new ClusterBlock(
            for (String index : indices) {  
        private SortedMap<String, IndexAbstraction> buildIndicesLookup() {  
        SNAPSHOT  
         * Update the number of search replicas for the specified indices.
            String[] allClosedIndicesArray = allClosedIndices.toArray(Strings.EMPTY_ARRAY);
            return put(template.build());
        throw new IndexNotFoundException(index);
        }
            .map(ComponentTemplateMetadata::componentTemplates)
    private final String[] allClosedIndices;
                    if (visible) {  
        /* Custom metadata should be stored as part of a snapshot */
     * Identifies whether the array containing type names given as argument explicitly refers to all types
        }
     * overridden via plugins)
     * Finds the specific index aliases that point to the requested concrete indices directly
                    totalOpenLocalOnlyIndexShards += cursor.getTotalNumberOfShards();  
    }
            return this;  
            this.customs.put(ComponentTemplateMetadata.TYPE, new ComponentTemplateMetadata(existingTemplates));
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
    }
        /**
            for (final AliasMetadata value : indexMetadata.getAliases().values()) {  
        String[] visibleIndices,
        return metadata1.hashesOfConsistentSettings.equals(metadata2.hashesOfConsistentSettings);
            if (FeatureAware.shouldSerialize(out, cursor)) {
                        visibleClosedIndices.add(name);
            return builder.build();  
            ).map(ctm -> new HashMap<>(ctm.componentTemplates())).orElse(new HashMap<>());
    public static final Metadata EMPTY_METADATA = builder().build();
            .map(  
        return new Builder(metadata);  
        public Builder generateClusterUuidIfNeeded() {
            builder.clusterUUID(clusterUUID);
     * aliases then the result will <b>not</b> include the index's key.  
            if (aliasMd.indexRouting().indexOf(',') != -1) {
                    // multi fields that should be excluded but hold subfields that don't have to be excluded are converted to objects  
        this.customs = Collections.unmodifiableMap(customs);
                        .stream()
        RestStatus.FORBIDDEN,
    public Diff<Metadata> diff(Metadata previousState) {
        @Override
     * Finds the specific index aliases that match with the specified aliases directly or partially via wildcards, and
         * @param indices          the indices to update the number of replicas for
    @Override
        return this.clusterUUIDCommitted;
    public Map<String, SortedMap<Long, String>> systemTemplatesLookup() {  
            }  
        false,  
            return false;
            new DiffableUtils.DiffableValueReader<>(IndexTemplateMetadata::readFrom, IndexTemplateMetadata::readDiffFrom);  
        int i = 0;
            }
    }
            previousMetadata = null;
                builder.endObject();
        int totalNumberOfShards = 0;  
        }  
        return getIndicesLookup().containsKey(index);  
            builder.endObject();  
        return Optional.ofNullable((ComposableIndexTemplateMetadata) this.custom(ComposableIndexTemplateMetadata.TYPE))
        return metadata1.coordinationMetadata.equals(metadata2.coordinationMetadata);  
        public static void toXContent(Metadata metadata, XContentBuilder builder, ToXContent.Params params) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
    private static final ToXContent.Params FORMAT_PARAMS;
        String[] allClosedIndices,
            return Builder.fromXContent(parser);  
    /**  
            Map<String, DataStream> indexToDataStreamLookup = new HashMap<>();
    private final Map<String, Custom> customs;  
                            map.remove("fields");
                    }
                    "index uuid doesn't match expected: [" + index.getUUID() + "] but got: [" + metadata.getIndexUUID() + "]"  
            }
    }
import org.opensearch.index.IndexNotFoundException;
        }
import org.opensearch.common.regex.Regex;  
     */  
            for (final Map.Entry<String, Custom> cursor : metadata.customs().entrySet()) {
import java.util.Arrays;
                            assert alias.getType() == IndexAbstraction.Type.ALIAS : alias.getClass().getName();
    /**
    /**
                    for (String alias : aliasDuplicatesWithDataStreams) {
        return builder;
        private final Settings persistentSettings;
                    // move to the next object
                out.writeNamedWriteable(cursor);
            } else {
            return this;
        /* Custom metadata should be returns as part of API call */
        }
            mapping = (Map<String, Object>) sourceAsMap.get(mappingMetadata.type());  
    }
    }
                        );  
            for (String index : indices) {  
    public static boolean isGlobalResourcesMetadataEquals(Metadata metadata1, Metadata metadata2) {  
            if (routing != null) {
         * `.ds-foo-000001`, `.ds-foo-000002` and `.ds-foo-000006` this will throw an IllegalStateException (as attempting to rollover the  
        public Builder putCustom(String type, Custom custom) {
    public static Metadata readFrom(StreamInput in) throws IOException {
    /**
        }
     * filter will be returned (default is a predicate that always returns true, which can be
        }  
            indexMetadataBuilder.version(indexMetadataBuilder.version() + 1);
                    } else {
     */
    }
            MappingMetadata mappingMetadata = indexMetadata.mapping();
                for (DataStream dataStream : dataStreamMetadata.dataStreams().values()) {  
        this.visibleClosedIndices = visibleClosedIndices;
    public static final MetadataStateFormat<Metadata> FORMAT = new MetadataStateFormat<Metadata>(GLOBAL_STATE_FILE_PREFIX) {  
        return this.clusterUUID;
        GATEWAY,  
                }
        public Builder() {  
            builder.field("cluster_uuid", metadata.clusterUUID);
        public IndexMetadata getSafe(Index index) {
     * Indicates that this custom metadata will be returned as part of an API call but will not be persisted
     * a snapshot global state, but will not be persisted between node restarts
                coordinationMetadata,
                persistentSettings,
        String[] allIndices,
        Property.NodeScope
        private DiffableStringMap hashesOfConsistentSettings = new DiffableStringMap(Collections.emptyMap());  
        public Settings transientSettings() {  
                throw new IllegalStateException("cannot filter mappings, found unknown element of type [" + value.getClass() + "]");
                include[i] = true;
    public static Metadata fromXContent(XContentParser parser) throws IOException {  
        return visibleIndices;
     * Returns indexing routing for the given index.  
        }  
            this.previousMetadata = metadata;
                + "] has more than one index associated with it ["
                Map<String, Object> properties = (Map<String, Object>) map.get("properties");  
            indices = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), INDEX_METADATA_DIFF_VALUE_READER);
            }
    public static boolean isTransientSettingsMetadataEqual(Metadata metadata1, Metadata metadata2) {
            // handling any Exception is caller's responsibility
 * not use this file except in compliance with the License.
        }
            }
            XContentContext context = XContentContext.valueOf(params.param(CONTEXT_MODE_PARAM, CONTEXT_MODE_API));
        }
        for (String index : concreteIndices) {  
        out.writeString(clusterUUID);
            return routing;  
            this.customs.put(ComponentTemplateMetadata.TYPE, new ComponentTemplateMetadata(existingTemplates));
            if (indices.get(indexMetadata.getIndex().getName()) == indexMetadata) {
 * Metadata information
        if (aliasOrIndex == null) {
        public Builder updateNumberOfSearchReplicas(final int numberOfSearchReplicas, final String[] indices) {
        public Builder put(String name, ComponentTemplate componentTemplate) {
import org.opensearch.common.settings.Setting.Property;
                index,
            clusterUUID = in.readString();  
    /**
    }  
            return this;  
    }  
            return new Metadata(
            return this;  
            return this;  
            throw new IllegalArgumentException("alias [" + aliasOrIndex + "] does not have a write index");  
        "cluster.default_number_of_replicas",
                        + "] provided with routing value ["
 * Unless required by applicable law or agreed to in writing,
            return this;  
    }  
                for (int i = 0; i < patterns.length; i++) {  
     * Gets the total number of shards from all indices, including replicas and  
        public Builder put(IndexTemplateMetadata.Builder template) {  
        private Settings transientSettings = Settings.Builder.EMPTY_SETTINGS;
        Map<String, String> params = new HashMap<>(2);  
                        .collect(Collectors.toList());
 * this work for additional information regarding copyright
            builder.clusterUUIDCommitted(clusterUUIDCommitted);  
     */  
            );
            }
            clusterUUID = after.clusterUUID;
        this.coordinationMetadata = coordinationMetadata;
            }
        }
    /**  
     * @param aliases The aliases to look for. Might contain include or exclude wildcards.
            validateDataStreams(indicesLookup, (DataStreamMetadata) customs.get(DataStreamMetadata.TYPE));
        public Builder hashesOfConsistentSettings(DiffableStringMap hashesOfConsistentSettings) {
     */  
                    });
                put(IndexMetadata.builder(indexMetadata).numberOfReplicas(numberOfReplicas));
            for (final IndexMetadata indexMetadata : indices.values()) {  
     */
            final List<String> visibleIndices = new ArrayList<>();  
        if (!metadata1.clusterUUID.equals(metadata2.clusterUUID)) {  
     * that point to the specified concrete indices (directly or matching indices via wildcards).
                for (final AliasMetadata aliasMetadata : indexMetadata.getAliases().values()) {  
        if (aliasMd.indexRouting() != null) {  
                        + aliasOrIndex
            .map(ComposableIndexTemplateMetadata::indexTemplates)  
    /**  
            List<AliasMetadata> filteredValues = new ArrayList<>();
    private final Map<String, IndexMetadata> indices;
            assert index.getType() == IndexAbstraction.Type.CONCRETE_INDEX;
            Map<String, WorkloadGroup> existing = new HashMap<>(getWorkloadGroups());  
        Property.Dynamic,
        throws IOException {
            return this;
    public IndexMetadata index(Index index) {
        builder.transientSettings(readSettingsFromStream(in));
import java.util.Iterator;
    public static boolean isHashesOfConsistentSettingsEqual(Metadata metadata1, Metadata metadata2) {  
                indexMetadata -> ReplicationType.parseString(indexMetadata.getSettings().get(IndexMetadata.SETTING_REPLICATION_TYPE))
        this.totalOpenLocalOnlyIndexShards = totalOpenLocalOnlyIndexShards;
        public Builder removeComponentTemplate(String name) {
                metadata.persistentSettings().toXContent(builder, new MapParams(Collections.singletonMap("flat_settings", "true")));
                                + " including '"  
        // filter out custom states not supported by the other node
                    } else if (matched) {  
     * Utility to identify whether input index uses SEGMENT replication strategy in established cluster state metadata.
            return graveyard;
            assert index != null;
            builder.put(IndexTemplateMetadata.readFrom(in));
            if (indexMetadata != null) {
    );  
                    IndexAbstraction existing = indicesLookup.put(
        if (!isCoordinationMetadataEqual(metadata1, metadata2)) {  
                Map<String, Object> map = (Map<String, Object>) value;
            existing.put(workloadGroup.get_id(), workloadGroup);
                indices,  
    public static class Builder {  
            IndexGraveyard graveyard = (IndexGraveyard) getCustom(IndexGraveyard.TYPE);
    }
                            return new IndexAbstraction.Alias(aliasMetadata, indexMetadata);  
        public DiffableStringMap hashesOfConsistentSettings() {  
import java.util.ArrayList;  
                        + "] provided with routing value ["
     * A diff of metadata.
                for (final IndexMetadata cursor : indices.values()) {
    public String[] getConcreteAllIndices() {  
import java.util.Collections;
            Objects.requireNonNull(workloadGroup, "workloadGroup should not be null");
     */  
                allOpenIndicesArray,  
        private final Settings transientSettings;  
        }
     * Note: Method intended for use by other plugins as well.
        this.visibleIndices = visibleIndices;  
     * Custom metadata.  
        return visibleOpenIndices;
     * Context of the XContent.
                || (previousDataStreamMetadata != null && previousDataStreamMetadata.equals(dataStreamMetadata) == false)
        return allIndices;
        }
    private static String mergePaths(String path, String field) {
                    mayRemove = filterFields(newPath, properties, fieldPredicate);
    /**
         * <p>
            return this;
            this.coordinationMetadata = metadata.coordinationMetadata;  
        }
            final Set<String> allIndices = new HashSet<>(indices.size());
        AliasMetadata aliasMd = alias.getFirstAliasMetadata();
        public Builder indices(final Map<String, IndexMetadata> indices) {
            Map<String, ComposableIndexTemplate> existingTemplates = Optional.ofNullable(
                        if (cursor.getAliases().containsKey(alias)) {
                visibleClosedIndicesArray,  
     * @see MapperPlugin#getFieldFilter()
                if (token == XContentParser.Token.START_OBJECT) {
    public String[] getConcreteVisibleOpenIndices() {  
     */  
    @SuppressWarnings("unchecked")
import java.util.Map;  
        return types != null && types.length == 1 && ALL.equals(types[0]);  
                after.templates.getTemplates(),  
     * in the write index.
                        + aliasMd.getIndexRouting()  
            String[] allOpenIndicesArray = allOpenIndices.toArray(Strings.EMPTY_ARRAY);  
    public static boolean isCustomMetadataEqual(Metadata metadata1, Metadata metadata2) {
/*
            if (otherIndex.getAliases().equals(thisIndex.getAliases()) == false) {  
                    } else if ("hashes_of_consistent_settings".equals(currentFieldName)) {  
                    allOpenIndices.add(name);  
    private final transient int totalNumberOfShards; // Transient ? not serializable anyway?
import java.util.EnumSet;
            }
    public static Builder builder() {
    );  
        }
                        .filter(s -> NUMBER_PATTERN.matcher(s.substring(prefix.length())).matches())
                    }
        writeSettingsToStream(persistentSettings, out);  
 * software distributed under the License is distributed on an
                            + routing  
            );
            }  
            }  
        for (int i = 0; i < customSize; i++) {
            String[] visibleOpenIndicesArray = visibleOpenIndices.toArray(Strings.EMPTY_ARRAY);
                    allDataStreams.add(dataStream.getName());
                            builder.put(IndexMetadata.Builder.fromXContent(parser), false);
    public Settings transientSettings() {
            return mappingMetadata;
                        if (cursor.getAliases().containsKey(alias)) {
 */  
        }  
        protected Metadata buildMetadataWithRecomputedIndicesLookups() {
        Arrays.stream(concreteIndices)  
     */
        public Builder removeAllIndices() {
        public Builder put(final WorkloadGroup workloadGroup) {
    }
        IndexAbstraction result = getIndicesLookup().get(aliasOrIndex);  
        boolean clusterUUIDCommitted,
        Property.NodeScope
        public IndexGraveyard indexGraveyard() {  
        return this.settings;
            for (final IndexMetadata indexMetadata : indices.values()) {
            .map(DataStreamMetadata::dataStreams)  
     */  
        }  
            return this;
            builder.put(IndexMetadata.readFrom(in), false);  
    public boolean hasIndexMetadata(final IndexMetadata indexMetadata) {
import org.opensearch.cluster.routing.RoutingPool;
                    }
    public interface Custom extends NamedDiffable<Custom>, ToXContentFragment, ClusterState.FeatureAware {
 * Licensed to Elasticsearch under one or more contributor  
        }  
    public int getTotalOpenRemoteCapableIndexShards() {
                    visibleIndices.add(name);  
        private Map<String, WorkloadGroup> getWorkloadGroups() {  
    }  
                );
        int totalOpenLocalOnlyIndexShards = 0;
    public WeightedRoutingMetadata weightedRoutingMetadata() {  
    }
    public int getTotalNumberOfShards() {
                throw new IllegalStateException(  
                clusterUUIDCommitted,  
            }  
            }  
                    throw new IllegalArgumentException(  
        public Builder put(IndexTemplateMetadata template) {
 *
            templates = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), TEMPLATES_DIFF_VALUE_READER);
    }
     */
                        dataStream.getName(),  
        public Builder removeIndexTemplate(String name) {
        }  
    private final String[] visibleClosedIndices;
    /**
    /**  
        private long version;
            }
/*  
            existingTemplates.remove(name);
     */  
 * under the License.  
    public Map<String, MappingMetadata> findMappings(String[] concreteIndices, Function<String, Predicate<String>> fieldFilter)
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
         * @return the builder  
            indexMetadata.writeTo(out);
    }  
    }
                persistentSettings,
        int size = in.readVInt();
     * Gets the total number of open shards from all indices. Includes  
        out.writeVInt(indices.size());
    }
        assert aliases != null;
                        + "] that resolved to several routing values, rejecting operation"
        return this.totalOpenLocalOnlyIndexShards;
            } else {  
                builder.startObject("settings");  
            return false;
                        if (matched == false) {
     *  
        public Builder dataStreams(Map<String, DataStream> dataStreams) {
    );
        }  
    public boolean clusterUUIDCommitted() {  
        final Map<String, IndexMetadata> indices,
            if (!"meta-data".equals(currentFieldName)) {  
        int customSize = in.readVInt();  
        private final String clusterUUID;  
            // we know its a new one, increment the version and store  
     *  
         * @param indicesLookup the indices in the system (this includes the data stream backing indices)  
     *
                if (!routing.equals(aliasMd.indexRouting())) {
        }
     */
                    assert parent.getIndices().contains(indexMetadata.getIndex());  
            }  
        templates.writeTo(out);  
    }
        private boolean clusterUUIDCommitted;  
        return allOpenIndices;  
        static void validateDataStreams(SortedMap<String, IndexAbstraction> indicesLookup, @Nullable DataStreamMetadata dsMetadata) {  
import org.opensearch.common.Nullable;  
            customs = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);  
                }
     * @opensearch.internal
        this.clusterUUIDCommitted = clusterUUIDCommitted;
        return this.totalNumberOfShards;
    ) {  
import java.util.Spliterators;
                indexMetadata.getAliases().keySet().iterator().forEachRemaining(allAliases::add);
        return (T) customs.get(type);
        public Settings persistentSettings() {  
     */
                    if (token != XContentParser.Token.FIELD_NAME) {
        return false;  
            if (cursor.context().contains(XContentContext.GATEWAY)) {
                }
    }  
        this.templates = new TemplatesMetadata(templates);
     * @return The total number of open shards from all indices.
    public Map<String, List<AliasMetadata>> findAllAliases(final String[] concreteIndices) {
    public Iterator<IndexMetadata> iterator() {
        return this.indices;
     */
                    builder.endObject();  
                    );
     * @return A map of index name to the list of aliases metadata. If a concrete index does not have matching
                        builder.persistentSettings(Settings.fromXContent(parser));
            existingDataStreams.remove(name);  
                    }  
     * @param types the array containing types  
    public String[] getConcreteVisibleClosedIndices() {
        String[] visibleOpenIndices,
        private final Diff<Map<String, Custom>> customs;
 * specific language governing permissions and limitations
        }
            Object value = entry.getValue();
        int numberOfCustoms = 0;
                    assert existing == null : "duplicate data stream for " + dataStream.getName();  
     */
                IndexAbstraction.Index index;  
            return this;
            builder.version(version);
     * Returns all of the concrete indices that are closed and not hidden.  
        return routing;
        10,
            builder.putCustom(customIndexMetadata.getWriteableName(), customIndexMetadata);  
        }
     *  
    }  
                Collections.unmodifiableSortedMap(previousMetadata.indicesLookup),  
                for (DataStream dataStream : dataStreamMetadata.dataStreams().values()) {
            ).map(ctm -> new HashMap<>(ctm.componentTemplates())).orElse(new HashMap<>());
                        "Alias ["
            ).map(dsmd -> new HashMap<>(dsmd.dataStreams())).orElse(new HashMap<>());
        DiffableStringMap hashesOfConsistentSettings,  
     *
            this.transientSettings = settings;
    private final int totalOpenLocalOnlyIndexShards;  
    /**  
    public Map<String, Custom> getCustoms() {  
        public Builder put(IndexMetadata.Builder indexMetadataBuilder) {
        boolean matchAllAliases = patterns.length == 0;
         *
            builder.transientSettings(transientSettings);  
     * @opensearch.api  
        public void writeTo(StreamOutput out) throws IOException {
            // 2) The aliasAndIndexLookup can be updated instead of rebuilding it all the time.  
     */
                                + ds.getName()
            ).map(itmd -> new HashMap<>(itmd.indexTemplates())).orElse(new HashMap<>());
     * replicas, but does not include shards that are part of closed indices.
            return parser.namedObject(Custom.class, name, null);
        size = in.readVInt();
        return indices.containsKey(index);  
            final Set<String> aliasDuplicatesWithIndices = new HashSet<>(allAliases);  
        }
    public int getTotalOpenIndexShards() {
        @Override
        );
            if (!"meta-data".equals(parser.currentName())) {
            if (fieldPredicate.test(newPath) == false) {
        }
        EnumSet.of(ClusterBlockLevel.CREATE_INDEX)
        }
            }
        Property.NodeScope
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;
        final Map<String, Custom> customs,  
                (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE)
        }
                systemTemplatesLookup
                            + aliasMd.indexRouting()
            this.clusterUUID = clusterUUID;
                if (matched) {
     * @param concreteIndex The concrete index to check if routing is required
        return Builder.fromXContent(parser);
                                + conflicts.size()
    private final boolean clusterUUIDCommitted;
            return this.persistentSettings;
                indices = this.indices.keySet().toArray(new String[0]);
            this.hashesOfConsistentSettings = metadata.hashesOfConsistentSettings;  
            return field;
            if (context != XContentContext.API && !metadata.persistentSettings().isEmpty()) {
                    cursor.getValue().toXContent(builder, params);
            customs = DiffableUtils.diff(before.customs, after.customs, DiffableUtils.getStringKeySerializer(), CUSTOM_VALUE_SERIALIZER);  
    public String[] getConcreteAllOpenIndices() {
            metadata.templatesMetadata().toXContent(builder, params);  
    @PublicApi(since = "1.0.0")
            hashesOfConsistentSettings = after.hashesOfConsistentSettings.diff(before.hashesOfConsistentSettings);
    public Map<String, ComponentTemplate> componentTemplates() {  
            }
        this.indices = Collections.unmodifiableMap(indices);  
    public Map<String, String> hashesOfConsistentSettings() {
        private final Map<String, IndexTemplateMetadata> templates;  
        Settings transientSettings,
import java.util.stream.StreamSupport;
        public Builder clusterUUIDCommitted(boolean clusterUUIDCommitted) {  
    public static final ClusterBlock CLUSTER_CREATE_INDEX_BLOCK = new ClusterBlock(  
        }
        return isCustomMetadataEqual(metadata1, metadata2);
    public Map<String, Custom> customs() {
        return this.customs();
                }  
            Objects.requireNonNull(indexTemplate, "it is invalid to add a null index template: " + name);
                }  
            return this;
        if (writeIndex == null) {
        return new MetadataDiff(previousState, this);
            )  
        throw new IllegalArgumentException(
     * *  
        }
        }  
                    }
                                + conflicts.iterator().next()
            builder.field("cluster_uuid_committed", metadata.clusterUUIDCommitted);
                Optional.ofNullable((ComponentTemplateMetadata) this.customs.get(ComponentTemplateMetadata.TYPE))  
                allIndicesArray,
            }  
                        throw new IllegalArgumentException("Expected a field name but got " + token);  
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
                        .collect(Collectors.toSet());  
            DataStreamMetadata dataStreamMetadata = (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE);
        false,  
        } else {
    public Map<String, IndexTemplateMetadata> getTemplates() {
    public boolean equalsAliases(Metadata other) {  
            ).map(itmd -> new HashMap<>(itmd.indexTemplates())).orElse(new HashMap<>());
                        } else {
                // iterate again and constructs a helpful message
        private void buildSystemTemplatesLookup() {  
        for (final Custom cursor : metadata2.customs.values()) {
                            builder.putCustom(custom.getWriteableName(), custom);
    }
                (ComposableIndexTemplateMetadata) this.customs.get(ComposableIndexTemplateMetadata.TYPE)  
                                if (iv == null) {
 * ownership. Elasticsearch licenses this file to you under  
        }  
        // Check if any persistent metadata needs to be saved
        return Optional.ofNullable(index(indexName))
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
        return findAliases(Strings.EMPTY_ARRAY, concreteIndices);  
            DataStreamMetadata previousDataStreamMetadata = (previousMetadata != null)
        long version,
                    totalOpenRemoteCapableIndexShards += cursor.getTotalNumberOfShards();
            out.writeBoolean(clusterUUIDCommitted);  
                throw new IndexNotFoundException(
        }  
            Objects.requireNonNull(componentTemplate, "it is invalid to add a null component template: " + name);
        }  
                final boolean visible = IndexMetadata.INDEX_HIDDEN_SETTING.get(indexMetadata.getSettings()) == false;
            DataStreamMetadata dataStreamMetadata = (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE);  
import java.util.SortedMap;
    }
            version = in.readLong();
    /**
    public boolean hasIndex(Index index) {  
        if (indexMetadata != null) {  
        public Builder put(DataStream dataStream) {
                customCount2++;  
            DataStreamMetadata dataStreamMetadata = (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE);
import java.util.HashSet;  
    }
        return systemTemplatesLookup;
            clusterUUIDCommitted = after.clusterUUIDCommitted;  
     */
            return this;  
                IndexMetadata indexMetadata = this.indices.get(index);
            if (FeatureAware.shouldSerialize(out, cursor)) {
    }
 */  
        return new MappingMetadata(mappingMetadata.type(), sourceAsMap);  
                templates,
        public Metadata build() {  
                }  
                            parser.skipChildren();
    }
import org.opensearch.cluster.NamedDiffable;
                throw new IllegalArgumentException(
        private final Diff<DiffableStringMap> hashesOfConsistentSettings;
            builder.customs(customs.apply(part.customs));
                    throw new IllegalArgumentException(  
        public DecommissionAttributeMetadata decommissionAttributeMetadata() {
    }  
        this.systemTemplatesLookup = systemTemplatesLookup;  
    public static EnumSet<XContentContext> API_ONLY = EnumSet.of(XContentContext.API);  
    public static boolean isTemplatesMetadataEqual(Metadata metadata1, Metadata metadata2) {
                        if (MetadataIndexTemplateService.isSystemTemplate(v)) {
        if (fieldPredicate == MapperPlugin.NOOP_FIELD_PREDICATE) {  
        if (result == null || result.getType() != IndexAbstraction.Type.ALIAS) {
            if (index.getParentDataStream() != null) {  
    }  
    public static final NamedDiffableValueSerializer<Custom> CUSTOM_VALUE_SERIALIZER = new NamedDiffableValueSerializer<>(Custom.class);
                clusterUUIDCommitted,
                IndexAbstraction existing = indicesLookup.put(indexMetadata.getIndex().getName(), index);  
        public Builder removeTemplate(String templateName) {  
        IndexAbstraction.Alias alias = (IndexAbstraction.Alias) result;
            this.clusterUUID = metadata.clusterUUID;
        return indices();  
                if (indexMetadata.getIndexUUID().equals(index.getUUID())) {
        params.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
            this.customs.put(DataStreamMetadata.TYPE, new DataStreamMetadata(existingDataStreams));
import org.opensearch.core.xcontent.XContentBuilder;
            .orElse(Collections.emptyMap());  
        out.writeBoolean(clusterUUIDCommitted);  
                String alias = value.alias();
    }
import org.opensearch.core.index.Index;
                builder.put(indexName, index.getParentDataStream());
                ? (DataStreamMetadata) this.previousMetadata.customs.get(DataStreamMetadata.TYPE)  
    public Map<String, WorkloadGroup> workloadGroups() {
 * KIND, either express or implied.  See the License for the
            .orElse(false);
                }
import org.apache.logging.log4j.LogManager;
    private final Settings settings;
                        .keySet()
        }  
                    if (include[i]) {
                } else if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
            this.persistentSettings = metadata.persistentSettings;
    public IndexMetadata getIndexSafe(Index index) {  
                    builder.startObject(cursor.getKey());
                hashesOfConsistentSettings,  
        }  
        final Map<String, IndexAbstraction.DataStream> builder = new HashMap<>();  
        if (!isTemplatesMetadataEqual(metadata1, metadata2)) {
            .orElse(Collections.emptyMap());
        public Builder(Metadata metadata) {  
import org.opensearch.cluster.DiffableUtils;  
            persistentSettings = after.persistentSettings;
            }
                }  
            totalNumberOfShards += cursor.getTotalNumberOfShards();
            if (alias.charAt(0) == '-') {
        builder.hashesOfConsistentSettings(DiffableStringMap.readFrom(in));  
                indexMetadata = IndexMetadata.builder(indexMetadata).version(indexMetadata.getVersion() + 1).build();
                    if (subFields != null) {
                    previousMetadata.customs.get(ComponentTemplateMetadata.TYPE),  
        @Override  
        }
            // if we put a new index metadata, increment its version
                transientSettings,  
                builder.startObject("meta-data");  
            this.indices = new HashMap<>(metadata.indices);
            builder.coordinationMetadata(coordinationMetadata);
        String clusterUUID,  
            return workloadGroups(existing);  
                        new IndexAbstraction.DataStream(dataStream, backingIndices)
import java.util.Optional;
        if (!isSettingsMetadataEqual(metadata1, metadata2)) {
        Property.Dynamic,  
        return this.persistentSettings;
            Map<String, ComposableIndexTemplate> existingTemplates = Optional.ofNullable(
            // Alias routing overrides the parent routing (if any).
import org.opensearch.cluster.Diff;
            this.indices.putAll(indices);
        IndexMetadata metadata = index(index.getName());
                for (final IndexMetadata cursor : indices.values()) {  
    public static final Setting<Boolean> SETTING_READ_ONLY_SETTING = Setting.boolSetting(
        }
        Iterator<Map.Entry<String, Object>> entryIterator = fields.entrySet().iterator();  
        return custom(WeightedRoutingMetadata.TYPE);
        private CoordinationMetadata coordinationMetadata = CoordinationMetadata.EMPTY_METADATA;  
        this.transientSettings = transientSettings;
        private final Map<String, IndexMetadata> indices;
     * @param concreteIndices The concrete indices that the aliases must point to in order to be returned  
            return false;
    private final String[] allOpenIndices;
            indices = new HashMap<>();
         *  
        return Optional.ofNullable((WorkloadGroupMetadata) this.custom(WorkloadGroupMetadata.TYPE))
     * Returns the {@link IndexMetadata} for this index.  
        return this.totalOpenRemoteCapableIndexShards;
    }
        }
        }
                if (indexMetadata == null) {
    }
                }
        return Optional.ofNullable((ComponentTemplateMetadata) this.custom(ComponentTemplateMetadata.TYPE))
     */  
    }
    public static final Setting<Boolean> SETTING_CREATE_INDEX_BLOCK_SETTING = Setting.boolSetting(
            return false;
            persistentSettings = Settings.readSettingsFromStream(in);
        if (path.length() == 0) {  
            String[] visibleIndicesArray = visibleIndices.toArray(Strings.EMPTY_ARRAY);
        private final Diff<Map<String, IndexMetadata>> indices;  
     * @return The weighted routing metadata for search requests
        }  
                }
import java.util.Objects;
        }
        this.indicesLookup = indicesLookup;
                    if ("version".equals(currentFieldName)) {
        return this.transientSettings;  
                    } else if ("cluster_uuid".equals(currentFieldName) || "uuid".equals(currentFieldName)) {
                    duplicates.add("data stream [" + dataStream + "] conflicts with index");
    @Override  
        IndexMetadata metadata = index(index.getName());
                }  
    public static Builder builder(Metadata metadata) {
                            + aliasOrIndex
            throw new IndexNotFoundException(  
            return metadata;
        }
        }
                hashesOfConsistentSettings,
                        + aliasMd.getIndexRouting()  
        Map<String, Object> sourceAsMap = XContentHelper.convertToMap(mappingMetadata.source().compressedReference(), true).v2();  
        Map<String, SortedMap<Long, String>> systemTemplatesLookup
            .filter(indices.keySet()::contains)
                .stream()
            this.version = version;  
    }
                : null;
     * @opensearch.api
        }
            templates.writeTo(out);
        false,
import java.util.Set;  
    public static final String UNKNOWN_CLUSTER_UUID = Strings.UNKNOWN_UUID_VALUE;  
            if (clusterUUID.equals(UNKNOWN_CLUSTER_UUID)) {  
            }
            if (dataStreamMetadata != null && indices.size() > 0) {
                    if (visible) {
            if (IndexMetadata.State.OPEN.equals(cursor.getState())) {
            indices.put(indexMetadata.getIndex().getName(), indexMetadata);  
    /**
                visibleOpenIndicesArray,
@PublicApi(since = "1.0.0")  
            if (routing != null) {
                    }
                    "index/alias ["  
            hashesOfConsistentSettings = DiffableStringMap.readDiffFrom(in);  
                    throw new IndexNotFoundException(index);  
        private final Diff<Map<String, IndexTemplateMetadata>> templates;
                return this;  
        if (properties == null || properties.isEmpty()) {  
        }
            boolean recomputeRequiredforIndicesLookups = (previousMetadata == null)
    public DecommissionAttributeMetadata decommissionAttributeMetadata() {
     */
                CollectionUtil.timSort(filteredValues, Comparator.comparing(AliasMetadata::alias));
        return Collections.unmodifiableMap(indexMapBuilder);
    public IndexMetadata index(String index) {  
            existingTemplates.remove(name);  
            coordinationMetadata = new CoordinationMetadata(in);  
            this.customs.put(ComposableIndexTemplateMetadata.TYPE, new ComposableIndexTemplateMetadata(existingTemplates));  
    public static final String CONTEXT_MODE_PARAM = "context_mode";  
    }
            return this;  
        }  
    }  
    public long version() {  
        for (Map.Entry<String, Custom> cursor : metadata1.customs.entrySet()) {  
    }
                visibleIndicesArray,
        public Builder remove(String index) {  
                    Set<String> conflicts = indicesLookup.subMap(prefix, DataStream.BACKING_INDEX_PREFIX + ds.getName() + ".")
    }  
                    }
        return fields.size() == 0;
     *  
        }
        private final CoordinationMetadata coordinationMetadata;
        for (IndexMetadata cursor : indices.values()) {  
                assert added : "double index named [" + name + "]";  
    public static final String CONTEXT_MODE_GATEWAY = XContentContext.GATEWAY.toString();
            return false;
        public Builder transientSettings(Settings settings) {
            buildSystemTemplatesLookup();  
                version,
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        assert concreteIndices != null;  
        public static Metadata fromXContent(XContentParser parser) throws IOException {  
     */
                            logger.warn("Skipping unknown custom object with type {}", currentFieldName);  
            }  
    public String[] getConcreteAllClosedIndices() {
    private final TemplatesMetadata templates;
                    "index, alias, and data stream names need to be unique, but the following duplicates "
        }
    public boolean routingRequired(String concreteIndex) {
        this.clusterUUID = clusterUUID;
        /* Custom metadata should be stored as part of the persistent cluster state */
                        } catch (NamedObjectNotFoundException ex) {
    // in the index,bulk,update and delete apis.  
         * Update the number of replicas for the specified indices.
        private final long version;
                Arrays.copyOf(previousMetadata.visibleOpenIndices, previousMetadata.visibleOpenIndices.length),  
    /**
            }  
            // while these datastructures aren't even used.
            IndexAbstraction index = lookup.get(indexName);  
        if (concreteIndices.length == 0) {
    @PublicApi(since = "1.0.0")
     * a snapshot global state, and will be persisted between node restarts
import java.util.regex.Pattern;  
                .forEach(cursor -> Objects.requireNonNull(cursor.getValue(), cursor.getKey()));
            return this;
    }
        IndexMetadata indexMetadata = indices.get(concreteIndex);
    }
            SortedMap<String, IndexAbstraction> indicesLookup = Collections.unmodifiableSortedMap(buildIndicesLookup());
                mapBuilder.put(index, Collections.unmodifiableList(filteredValues));
     */  
            putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata);  
                if (visible) {
     * Returns all of the concrete indices that are open and not hidden.
     * Indicates that this custom metadata will be returned as part of an API call and stored as a part of  
import org.opensearch.cluster.Diffable;
                new IllegalStateException(
                        builder.hashesOfConsistentSettings(parser.mapStrings());
            Builder.toXContent(state, builder, FORMAT_PARAMS);
                        }
            return routing;
    }
                    assert backingIndices.isEmpty() == false;
                                iv.put(templateMetadata.version(), k);
            indicesLookup.values()
                put(IndexMetadata.builder(indexMetadata).settings(Settings.builder().put(indexMetadata.getSettings()).put(settings)));
            return indexAbstraction.getType() == IndexAbstraction.Type.ALIAS;  
        public Metadata apply(Metadata part) {  
            }
     * Returns the merged transient and persistent settings.
                    }  
                            matched = ALL.equals(pattern) || Regex.simpleMatch(pattern, alias);
 *  
            );  
        return builder.build();
        }
    public boolean hasAlias(String alias) {  
        }  
            return this;
                templates,
        Property.Dynamic,
     */
    public Map<String, IndexMetadata> getIndices() {
import org.opensearch.cluster.NamedDiffableValueSerializer;
                        }
         * Validates there isn't any index with a name that would clash with the future backing indices of the existing data streams.  
            if (mappingMetadata != null) {
     * The empty or null array doesn't explicitly map to all types  
import org.opensearch.gateway.MetadataStateFormat;  
                customs,
        public IndexMetadata get(String index) {
            final List<String> allClosedIndices = new ArrayList<>();  
 */
    private void rejectSingleIndexOperation(String aliasOrIndex, IndexAbstraction result) {
            }  
            return Optional.ofNullable(this.customs.get(WorkloadGroupMetadata.TYPE))
        return this.customs;  
                        "index uuid doesn't match expected: [" + index.getUUID() + "] but got: [" + indexMetadata.getIndexUUID() + "]"
     */
                for (String dataStream : dataStreamDuplicatesWithIndices) {  
        13,
                assert existing == null : "duplicate for " + indexMetadata.getIndex();
                    new IllegalStateException(
                return false;
    /** Returns true iff existing index has the same {@link IndexMetadata} instance */  
            Builder builder = new Builder();
                        }
        boolean[] include = new boolean[aliases.length];
        out.writeVInt(numberOfCustoms);
            XContentParser.Token token = parser.currentToken();
                    map.remove("fields");
                );
     */
                            + aliasMd.indexRouting()
    public SortedMap<String, IndexAbstraction> getIndicesLookup() {
    public Map<String, ComposableIndexTemplate> templatesV2() {
        return mapBuilder;
        EnumSet<XContentContext> context();
                if (RoutingPool.getIndexPool(cursor) == RoutingPool.REMOTE_CAPABLE) {  
     * The collection of index deletions in the cluster.
        }
    }
     */  
                + Arrays.toString(indexNames)  
            } else {
        AliasMetadata aliasMd = writeIndex.getAliases().get(result.getName());
        }
import org.opensearch.indices.replication.common.ReplicationType;
                if (indexMetadata == null) {
                            + "], rejecting operation"
            String currentFieldName = parser.currentName();
    public Map<String, DataStream> dataStreams() {
                            + "] has index routing associated with it ["  
                                }  
        public Builder removeCustom(String type) {
        }
     * @throws IndexNotFoundException if no metadata for this index is found
     * Whether the current node with the given cluster state is locked into the cluster with the UUID returned by {@link #clusterUUID()},  
import java.util.function.Function;
        public DataStream dataStream(String dataStreamName) {
        if (aliasMd.indexRouting() != null) {  
     * Returns all the concrete indices that are not hidden.
        builder.persistentSettings(readSettingsFromStream(in));
        public Builder removeDataStream(String name) {
            if (metadata.getIndexUUID().equals(index.getUUID())) {  
                }  
     * Finds the parent data streams, if any, for the specified concrete indices.
     * @return The total number shards from all indices.
            builder.hashesOfConsistentSettings(hashesOfConsistentSettings.apply(part.hashesOfConsistentSettings));
        private static final DiffableUtils.DiffableValueReader<String, IndexTemplateMetadata> TEMPLATES_DIFF_VALUE_READER =
                numberOfCustoms++;
        String[] visibleClosedIndices,  
        return path + "." + field;  
                // Make the list order deterministic  
                }
            aliasDuplicatesWithDataStreams.retainAll(allDataStreams);  
        }
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        for (String indexName : concreteIndices) {
        return templates();
                        .filter(s -> IndexMetadata.parseIndexNameCounter(s) > ds.getGeneration())
            rejectSingleIndexOperation(aliasOrIndex, result);  
                        builder.templates(TemplatesMetadata.fromXContent(parser));  
                // iterate again and constructs a helpful message
        String[] indexNames = new String[result.getIndices().size()];  
     * @return A map of index name to the list of aliases metadata. If a concrete index does not have matching
        }
        int totalOpenRemoteCapableIndexShards = 0;
            aliasDuplicatesWithIndices.retainAll(allIndices);
        }
        coordinationMetadata.writeTo(out);
        }  
            return workloadGroups(existing);
            this.customs = new HashMap<>(metadata.customs);
        }
            customs.put(type, Objects.requireNonNull(custom, type));  
     * State format for {@link Metadata} to write to and load from disk
                }
                    String prefix = DataStream.BACKING_INDEX_PREFIX + ds.getName() + "-";  
import org.opensearch.core.xcontent.XContentParser;
                                return iv;
            Map<String, ComponentTemplate> existingTemplates = Optional.ofNullable(  
            return this;
    }
     * Finds the specific index aliases that match with the specified aliases directly or partially via wildcards, and
        }
            if (cursor.getValue().context().contains(XContentContext.GATEWAY)) {
    /**
        public Builder persistentSettings(Settings settings) {
        }
            if (token != XContentParser.Token.START_OBJECT) {
        return this.templates;  
            templates = DiffableUtils.diff(
                    );
    };
                indicesLookup,
    /**  
                    List<IndexMetadata> backingIndices = dataStream.getIndices()
        assert fieldPredicate != MapperPlugin.NOOP_FIELD_PREDICATE;
        Builder builder = new Builder();
                before.templates.getTemplates(),
            this.templates.clear();
     * @opensearch.api
        hashesOfConsistentSettings.writeTo(out);
    @Override
    public String clusterUUID() {
            final List<String> visibleClosedIndices = new ArrayList<>();
                for (IndexMetadata indexMetadata : metadata) {
    }
                }
    public Settings persistentSettings() {  
                clusterUUID,
        "cluster read-only (api)",
        }
                if (!routing.equals(aliasMd.indexRouting())) {
                        builder.clusterUUID = parser.text();
    @PublicApi(since = "1.0.0")  
        }
    }
        return custom(DecommissionAttributeMetadata.TYPE);
        }
            // TODO: We should move these datastructures to IndexNameExpressionResolver, this will give the following benefits:  
            String newPath = mergePaths(currentPath, entry.getKey());  
    public Map<String, IndexMetadata> indices() {
     * meaning that it will not accept any cluster state with a different clusterUUID.
            return builder.build();  
        false,
        RestStatus.FORBIDDEN,  
     * @return true if index uses SEGMENT replication, false otherwise
import org.opensearch.cluster.ClusterState;
            }
    }  
            existingTemplates.put(name, componentTemplate);  
            return this;  
        out.writeLong(version);
                customCount1++;  
            ).map(dsmd -> new HashMap<>(dsmd.dataStreams())).orElse(new HashMap<>());
    public boolean hasIndex(String index) {
            metadata.coordinationMetadata().toXContent(builder, params);
                clusterUUID,  
        return customCount1 == customCount2;  
                        }
    }
            return this;
                systemTemplatesLookup = new HashMap<>();
            Map.Entry<String, Object> entry = entryIterator.next();
            }  
                    for (Index i : dataStream.getIndices()) {
import org.opensearch.cluster.coordination.CoordinationMetadata;  
                    } else if ("templates".equals(currentFieldName)) {
        String[] patterns = new String[aliases.length];
                : buildMetadataWithRecomputedIndicesLookups();  
    private final String[] visibleIndices;
        }
import java.io.IOException;
import java.util.Comparator;  
            customs.remove(type);
                        if (alias == null) {
        RestStatus.FORBIDDEN,  
        return new Builder();
            this.version = metadata.version;
    }
    public static boolean isExplicitAllType(String[] types) {
    public static final Setting<Boolean> SETTING_READ_ONLY_ALLOW_DELETE_SETTING = Setting.boolSetting(
     * @param indexName Index name
            return false;
package org.opensearch.cluster.metadata;
     */
     * Returns indexing routing for the given <code>aliasOrIndex</code>. Resolves routing from the alias metadata used
        public Builder indexTemplates(Map<String, ComposableIndexTemplate> indexTemplates) {
            return this;
                boolean added = allIndices.add(name);
            // 1) The datastructures will be rebuilt only when needed. Now during serializing we rebuild these datastructures
import org.opensearch.action.AliasesRequest;
            Settings.writeSettingsToStream(transientSettings, out);  
                .map(o -> (WorkloadGroupMetadata) o)
     */  
                } else {
                final String name = indexMetadata.getIndex().getName();
                        .stream()  
    public static EnumSet<XContentContext> ALL_CONTEXTS = EnumSet.allOf(XContentContext.class);  
                (DataStreamMetadata) this.customs.get(DataStreamMetadata.TYPE)
    /**  
    );
                        + "] that resolved to several routing values, rejecting operation"
                    .forEach((k, v) -> {  
     */
        public Builder templates(Map<String, IndexTemplateMetadata> templates) {
        this.persistentSettings = persistentSettings;  
        }
                            duplicates.add(alias + " (alias of " + cursor.getIndex() + ") conflicts with data stream");  
        false,
    private final String[] visibleOpenIndices;  
     */  
    private final long version;
     * Finds all mappings for concrete indices. Only fields that match the provided field  
    public static final String ALL = "_all";
     * @return true if the provided array explicitly maps to all types, false otherwise  
            return Map.of();
         */
        }
                Arrays.copyOf(previousMetadata.allClosedIndices, previousMetadata.allClosedIndices.length),
            return ((DataStreamMetadata) customs.get(DataStreamMetadata.TYPE)).dataStreams().get(dataStreamName);
                }
        for (int i = 0; i < size; i++) {  
            templates = new HashMap<>();  
    private final String clusterUUID;  
    /**  
                } else if (isMultiField) {
        return null;  
                && Objects.equals(
                } else if (token == XContentParser.Token.START_OBJECT) {  
            mapping = sourceAsMap;
        return allClosedIndices;
    /**
        public Builder indexGraveyard(final IndexGraveyard indexGraveyard) {
            }
        Map<String, Object> mapping;
import org.opensearch.core.rest.RestStatus;  
     *  
            builder.endObject();  
    );
         * @param numberOfSearchReplicas the number of search replicas
                    indicesLookup.compute(aliasMetadata.getAlias(), (aliasName, alias) -> {
         * `foo` data stream from generation 5 to 6 will not be possible)
            return this;
            .forEach((idx) -> indexMapBuilder.put(idx, filterFields(indices.get(idx).mapping(), fieldFilter.apply(idx))));
        Builder.toXContent(this, builder, params);  
    }
            IndexMetadata thisIndex = index(otherIndex.getIndex());
            }
            if (dataStreamDuplicatesWithIndices.isEmpty() == false) {
    public static EnumSet<XContentContext> API_AND_SNAPSHOT = EnumSet.of(XContentContext.API, XContentContext.SNAPSHOT);  
    public static Diff<Metadata> readDiffFrom(StreamInput in) throws IOException {
                                + "'"
    // TODO: This can be moved to IndexNameExpressionResolver too, but this means that we will support wildcards and other expressions
                    entryIterator.remove();
        FORMAT_PARAMS = new MapParams(params);  
        // return true if the ancestor may be removed, as it has no sub-fields left
                }
    }
        }  
        public Builder hashesOfConsistentSettings(Map<String, String> hashesOfConsistentSettings) {  
                patterns[i] = alias;  
                include[i] = false;
    private static final Logger logger = LogManager.getLogger(Metadata.class);  
        return indices.get(indexMetadata.getIndex().getName()) == indexMetadata;
        this.hashesOfConsistentSettings = hashesOfConsistentSettings;
    /**
                    map.put("properties", subFields);
     * Returns all of the concrete indices that are open.  
                        + "were found ["
            this.transientSettings = metadata.transientSettings;
         */
                Arrays.copyOf(previousMetadata.allIndices, previousMetadata.allIndices.length),  
 * license agreements. See the NOTICE file distributed with
     */
                    map.remove("type");  
        return findAliases(aliasesRequest.aliases(), concreteIndices);
                }
            IndexMetadata indexMetadata = indexMetadataBuilder.build();
                    "index/alias ["  
import org.opensearch.cluster.block.ClusterBlock;
    public static boolean isAllTypes(String[] types) {  
    /**
         * @param dsMetadata    the data streams in the system
                clusterUUID = UUIDs.randomBase64UUID();
            this.customs.put(WorkloadGroupMetadata.TYPE, new WorkloadGroupMetadata(workloadGroups));  
        if (metadata != null) {
        if (concreteIndices.length == 0) {
    }
        public void toXContent(XContentBuilder builder, Metadata state) throws IOException {  
    /**
        final SortedMap<String, IndexAbstraction> lookup = getIndicesLookup();
    private static class MetadataDiff implements Diff<Metadata> {  
    /**  
        return Collections.unmodifiableMap(builder);
            }
    }
            if (context == XContentContext.API) {  
     * @return true if the provided array maps to all types, false otherwise
                indices,
        }  
    }
                    token = parser.nextToken();
     * closed indices.
                .forEach(alias -> ((IndexAbstraction.Alias) alias).computeAndValidateAliasProperties());
                            String pattern = patterns[i];  
            indexNames[i++] = indexMetadata.getIndex().getName();  
                        }  
        "cluster create-index blocked (api)",
                    throw new IndexNotFoundException(index);  
        }  
    public static boolean isCoordinationMetadataEqual(Metadata metadata1, Metadata metadata2) {
        private static final DiffableUtils.DiffableValueReader<String, IndexMetadata> INDEX_METADATA_DIFF_VALUE_READER =  
     */  
                systemTemplatesLookup
 *  
            this.coordinationMetadata = coordinationMetadata;
        }
        private final Metadata previousMetadata;
                    for (String alias : aliasDuplicatesWithIndices) {  
            return this.hashesOfConsistentSettings;
    }  
        private Map<String, SortedMap<Long, String>> systemTemplatesLookup;
    public Map<String, IndexTemplateMetadata> templates() {  
        }  
        assert concreteIndices != null;
    public static final String CONTEXT_MODE_API = XContentContext.API.toString();  
        }
        }  
        }
    public enum XContentContext {
        if (sourceAsMap.size() == 1 && sourceAsMap.containsKey(mappingMetadata.type())) {
                    index = new IndexAbstraction.Index(indexMetadata, (IndexAbstraction.DataStream) indicesLookup.get(parent.getName()));
            if (aliasDuplicatesWithDataStreams.isEmpty() == false) {
 * The OpenSearch Contributors require contributions made to  
    }
        if (!metadata1.hashesOfConsistentSettings.equals(metadata2.hashesOfConsistentSettings)) {  
            return this;  
            if (previousMetadata != null
     * @param concreteIndices The concrete indices that the aliases must point to in order to be returned.
            StreamSupport.stream(Spliterators.spliterator(customs.entrySet(), 0), false)
    }  
            this.clusterUUIDCommitted = metadata.clusterUUIDCommitted;
            if (thisIndex == null) {  
        false,  
            version = after.version;
            coordinationMetadata = after.coordinationMetadata;
        return indices.get(index);
    @Override  
        }  
        return routing;
    private static MappingMetadata filterFields(MappingMetadata mappingMetadata, Predicate<String> fieldPredicate) {
    public String resolveIndexRouting(@Nullable String routing, String aliasOrIndex) {
            builder.startObject("cluster_coordination");
            return aliasMd.indexRouting();  
            }
                            + routing  
                if (parent != null) {
     * @return Whether routing is required according to the mapping for the specified index and type
     * @return The total number of open shards from all indices.
                            Custom custom = Custom.fromXContent(parser, currentFieldName);  
        EnumSet.of(ClusterBlockLevel.WRITE, ClusterBlockLevel.METADATA_WRITE)
                put(IndexMetadata.builder(indexMetadata).numberOfSearchReplicas(numberOfSearchReplicas));
        return metadata1.templates.equals(metadata2.templates);  
    /**  
                }
        public Builder decommissionAttributeMetadata(final DecommissionAttributeMetadata decommissionAttributeMetadata) {
            this.customs.put(DataStreamMetadata.TYPE, new DataStreamMetadata(existingDataStreams));
            this.customs.put(DataStreamMetadata.TYPE, new DataStreamMetadata(dataStreams));  
            SortedMap<String, IndexAbstraction> indicesLookup = new TreeMap<>();
        return indicesLookup;  
        int customCount1 = 0;
        return new MetadataDiff(in);  
            return false;
     *
            Custom customIndexMetadata = in.readNamedWriteable(Custom.class);
        }
                    )  
    public String[] getConcreteVisibleIndices() {
            if (incrementVersion) {  
        }  
         * @return the builder  
        public Builder clusterUUID(String clusterUUID) {
                    throw new IndexNotFoundException(index);  
    public static final String GLOBAL_STATE_FILE_PREFIX = "global-";
}
            this.clusterUUIDCommitted = clusterUUIDCommitted;
                    } else if ("settings".equals(currentFieldName)) {  
                DataStream parent = indexToDataStreamLookup.get(indexMetadata.getIndex().getName());
        "cluster.blocks.create_index",  
        }
            builder.templates(templates.apply(part.templates.getTemplates()));
/*  
                builder.field("version", metadata.version());
        public Builder templates(TemplatesMetadata templatesMetadata) {
        writeSettingsToStream(transientSettings, out);
            builder.startObject("templates");
            return this;
        @Override
            }
    public static boolean isSettingsMetadataEqual(Metadata metadata1, Metadata metadata2) {  
                        builder.version = parser.longValue();  
 * You may obtain a copy of the License at  
            final Set<String> dataStreamDuplicatesWithIndices = new HashSet<>(allDataStreams);  
            templates.remove(templateName);
                        if (mayRemove = filterFields(newPath, subFields, fieldPredicate)) {
        Map<String, Object> properties = (Map<String, Object>) mapping.get("properties");
        }  
            }
        builder.clusterUUID = in.readString();
                builder.startObject("metadata");
            }
                        .map(index -> indices.get(index.getName()))  
    private final Settings persistentSettings;
        this.visibleOpenIndices = visibleOpenIndices;
            }
                allClosedIndicesArray,
            new DiffableUtils.DiffableValueReader<>(IndexMetadata::readFrom, IndexMetadata::readDiffFrom);
                } else {
    );
            } else {
            existing.remove(workloadGroup.get_id());
                            });  
import org.apache.lucene.util.CollectionUtil;  
        builder.coordinationMetadata(new CoordinationMetadata(in));  
                    currentFieldName = parser.currentName();
                    }
    public static final String CONTEXT_MODE_SNAPSHOT = XContentContext.SNAPSHOT.toString();
            String[] visibleClosedIndicesArray = visibleClosedIndices.toArray(Strings.EMPTY_ARRAY);  
            return this;
        for (IndexMetadata otherIndex : other.indices().values()) {
                            + "] has index routing associated with it ["  
                version,
        private Settings persistentSettings = Settings.Builder.EMPTY_SETTINGS;
        for (IndexMetadata indexMetadata : result.getIndices()) {
    }  
            String alias = aliases[i];
        private String clusterUUID;
    public static boolean isGlobalStateEquals(Metadata metadata1, Metadata metadata2) {
     * node restarts, but will not be a part of a snapshot global state
    }  
        final Map<String, IndexTemplateMetadata> templates,
                    return indexMetadata;  
import java.util.HashMap;
     */
    );
            final Set<String> aliasDuplicatesWithDataStreams = new HashSet<>(allAliases);
 * this file be licensed under the Apache-2.0 license or a
     * @param types the array containing index names
                            return alias;
        for (final Custom cursor : customs.values()) {  
        }
                        + aliasOrIndex
     * @param aliasesRequest The request to find aliases for
        }
import java.util.function.Predicate;
        false,
            throw new IndexNotFoundException(index);  
     * @return A map of index name to the list of aliases metadata. If a concrete index does not have matching  
            return this;
            indices.remove(index);
                        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            Objects.requireNonNull(workloadGroup, "workloadGroup should not be null");  
                    Map<String, Object> map = (Map<String, Object>) value;
        public Builder componentTemplates(Map<String, ComponentTemplate> componentTemplates) {
    /**
    }
    }  
    @SuppressWarnings("unchecked")  
import org.opensearch.core.xcontent.ToXContent;
import java.util.List;
import org.apache.logging.log4j.Logger;
        public Custom getCustom(String type) {
            final Set<String> allDataStreams = new HashSet<>();
                    index,  
            this.customs.putAll(customs);  
        "cluster.blocks.read_only_allow_delete",
                + "], can't execute a single index op"
    }  
            return new Metadata(
            .orElse(Collections.emptyMap());
        public Builder workloadGroups(final Map<String, WorkloadGroup> workloadGroups) {
                        }  
                    }
    }
        private final Map<String, Custom> customs;
        1,
    public static final ClusterBlock CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK = new ClusterBlock(  
        this.totalNumberOfShards = totalNumberOfShards;
                    .equals(ReplicationType.SEGMENT)
        false,  
                        visibleOpenIndices.add(name);
        assert concreteIndices != null;  
                    });  
    }  
            return this;
            Map<String, DataStream> existingDataStreams = Optional.ofNullable(  
import java.util.stream.Collectors;
        /**
                        builder.clusterUUIDCommitted = parser.booleanValue();
        filterFields("", properties, fieldPredicate);
        public Builder customs(Map<String, Custom> customs) {  
            IndexMetadata indexMetadata = indices.get(index);
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+$");
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
public class Metadata implements Iterable<IndexMetadata>, Diffable<Metadata>, ToXContentFragment {
    /**
        return isGlobalResourcesMetadataEquals(metadata1, metadata2);  
                    if (conflicts.size() > 0) {
    public <T extends Custom> T custom(String type) {
        API,  
        this.totalOpenRemoteCapableIndexShards = totalOpenRemoteCapableIndexShards;  
            transientSettings = after.transientSettings;  
        }
    private final Settings transientSettings;  
        return this.version;
            existingTemplates.put(name, indexTemplate);
        true,
import org.opensearch.core.common.io.stream.StreamInput;  
 * Modifications Copyright OpenSearch Contributors. See
            clusterUUID = UNKNOWN_CLUSTER_UUID;
        return custom(IndexGraveyard.TYPE);
        }  
     * aliases then the result will <b>not</b> include the index's key.
            this.templates.putAll(templatesMetadata.getTemplates());  
            return this;
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;  
            return this;
                patterns[i] = alias.substring(1);  
    public Map<String, List<AliasMetadata>> findAliases(final AliasesRequest aliasesRequest, final String[] concreteIndices) {  
                IndexMetadata indexMetadata = this.indices.get(index);
        }  
                if (cursor.getValue().context().contains(context)) {  
                if (mayRemove) {  
            .orElse(Collections.emptyMap());
     * Builder of metadata.
import org.opensearch.cluster.ClusterState.FeatureAware;  
        return metadata1.transientSettings.equals(metadata2.transientSettings);
import org.opensearch.common.UUIDs;
        MetadataDiff(Metadata before, Metadata after) {
            return this;
        return indices.values().iterator();
            // Alias routing overrides the parent routing (if any).
    }
    private static boolean filterFields(String currentPath, Map<String, Object> fields, Predicate<String> fieldPredicate) {
    private final String[] allIndices;  
    }  
            return this;
        return Optional.ofNullable((DataStreamMetadata) this.custom(DataStreamMetadata.TYPE))
    public Map<String, IndexAbstraction.DataStream> findDataStreams(String[] concreteIndices) {
            this.persistentSettings = settings;
    public boolean hasConcreteIndex(String index) {
            }
 * compatible open source license.
    public boolean isSegmentReplicationEnabled(String indexName) {
     */
    public String resolveWriteIndexRouting(@Nullable String routing, String aliasOrIndex) {
                )) {
                ? buildMetadataWithPreviousIndicesLookups()
        public Builder updateNumberOfReplicas(final int numberOfReplicas, final String[] indices) {
            boolean mayRemove = true;
    }
                }
    }  
            }
import org.opensearch.cluster.block.ClusterBlockLevel;
        }
                builder.endObject();
import org.opensearch.common.settings.Setting;
                throw new IllegalArgumentException(
                    } else {
    /**
            return indicesLookup;
         * @param numberOfReplicas the number of replicas
                    assert backingIndices.contains(null) == false;  
                            + "], and was provided with routing value ["
                                + "] could create backing indices that conflict with "  
    private final int totalOpenRemoteCapableIndexShards;
                || (dataStreamMetadata != null && dataStreamMetadata.equals(previousDataStreamMetadata) == false);
        public Metadata fromXContent(XContentParser parser) throws IOException {
        return this.hashesOfConsistentSettings;
                (ComposableIndexTemplateMetadata) this.customs.get(ComposableIndexTemplateMetadata.TYPE)  
            }
        public Builder put(String name, ComposableIndexTemplate indexTemplate) {  
        if (metadata1.clusterUUIDCommitted != metadata2.clusterUUIDCommitted) {  
        }  
                currentFieldName = parser.currentName();
        }
import org.opensearch.common.annotation.PublicApi;
        }  
                        throw new IllegalStateException(  
        params.put("binary", "true");
                    // move to the field name (meta-data)  
        }
                }  
        CoordinationMetadata coordinationMetadata,  
                .filter(aliasOrIndex -> aliasOrIndex.getType() == IndexAbstraction.Type.ALIAS)  
    }
            return this;  
        } else {
                                + " existing index(s) or alias(s)"
    private final CoordinationMetadata coordinationMetadata;
                    .orElseGet(Collections::emptyMap)
            this.templates = new HashMap<>(metadata.templates.getTemplates());  
            // build all concrete indices arrays:  
            return (recomputeRequiredforIndicesLookups == false)
            return Map.of();
        Property.Dynamic,
                )
                } else {  
            "Alias ["  
    }
                if (indexMetadata.getState() == IndexMetadata.State.OPEN) {
            coordinationMetadata.writeTo(out);
                }
        builder.version = in.readLong();  
            return this;  
    private final DiffableStringMap hashesOfConsistentSettings;  
import org.opensearch.common.settings.Settings;  
    /**
            if (dataStreamMetadata != null) {  
            indices.clear();  
    }  
                        throw new IllegalArgumentException("Unexpected field [" + currentFieldName + "]");  
        protected Metadata buildMetadataWithPreviousIndicesLookups() {  
        private boolean clusterUUIDCommitted;
    static {
                            + aliasOrIndex
                    filteredValues.add(value);
        static Custom fromXContent(XContentParser parser, String name) throws IOException {  
    /**
     * that point to the specified concrete indices (directly or matching indices via wildcards).  
        }
        public Builder coordinationMetadata(CoordinationMetadata coordinationMetadata) {
                        isMultiField = true;  
                if (token == XContentParser.Token.FIELD_NAME) {
     * or that match with the indices via wildcards.
 * the Apache License, Version 2.0 (the "License"); you may
            this.customs.put(ComposableIndexTemplateMetadata.TYPE, new ComposableIndexTemplateMetadata(indexTemplates));
         * E.g., if data stream `foo` has backing indices [`.ds-foo-000001`, `.ds-foo-000002`] and the indices lookup contains indices
        }
            }  
            boolean isMultiField = false;  
            indices.put(indexMetadata.getIndex().getName(), indexMetadata);  
        return types == null || types.length == 0 || isExplicitAllType(types);
                Arrays.copyOf(previousMetadata.visibleClosedIndices, previousMetadata.visibleClosedIndices.length),
    public static final Setting<Integer> DEFAULT_REPLICA_COUNT_SETTING = Setting.intSetting(  
        false,
            Objects.requireNonNull(dataStream, "it is invalid to add a null data stream");
        }
    /**
                            duplicates.add(alias + " (alias of " + cursor.getIndex() + ") conflicts with index");
                builder.startObject("indices");
                );
            out.writeString(clusterUUID);
            if (indices == null || indices.length == 0) {  
        if (mappingMetadata == null) {  
                            ((IndexAbstraction.Alias) alias).addIndex(indexMetadata);  
        }
                        + Strings.collectionToCommaDelimitedString(duplicates)  
                            SystemTemplateMetadata templateMetadata = SystemTemplateMetadata.fromComponentTemplate(k);
        if (aliasOrIndex == null) {
        /**
            this.hashesOfConsistentSettings = new DiffableStringMap(hashesOfConsistentSettings);
                    Map<String, Object> subFields = (Map<String, Object>) map.get("fields");
                return mappingMetadata.routingRequired();  
            }  
    public TemplatesMetadata templatesMetadata() {
    public Settings settings() {
        }  
     * The empty or null array identifies all types
            return this;
 *
                            systemTemplatesLookup.compute(templateMetadata.name(), (ik, iv) -> {  
    }
            this.customs.put(ComponentTemplateMetadata.TYPE, new ComponentTemplateMetadata(componentTemplates));  
            putCustom(IndexGraveyard.TYPE, indexGraveyard);
        public Builder put(IndexMetadata indexMetadata, boolean incrementVersion) {
                    } else if ("indices".equals(currentFieldName)) {
                return metadata;
            hashesOfConsistentSettings.writeTo(out);
            }  
        }  
                        builder.coordinationMetadata(CoordinationMetadata.fromXContent(parser));
     * aliases then the result will <b>not</b> include the index's key.
    private final SortedMap<String, IndexAbstraction> indicesLookup;
         * @param indices          the indices to update the number of replicas for
            this.customs.put(ComposableIndexTemplateMetadata.TYPE, new ComposableIndexTemplateMetadata(existingTemplates));  
            return routing;
            dataStreamDuplicatesWithIndices.retainAll(allIndices);
            final List<String> visibleOpenIndices = new ArrayList<>();
                } else if (token.isValue()) {
        }  
    /**
        if (result == null || result.getType() != IndexAbstraction.Type.ALIAS) {
    private final Map<String, SortedMap<Long, String>> systemTemplatesLookup;  
        return visibleClosedIndices;  
                            + "], and was provided with routing value ["
                boolean matched = matchAllAliases;
    /**
     * @param concreteIndices The concrete indices that the aliases must point to in order to be returned.
        false,
            ArrayList<String> duplicates = new ArrayList<>();
                DiffableUtils.getStringKeySerializer()
            if (dsMetadata != null) {
            clusterUUIDCommitted = in.readBoolean();
            indices = DiffableUtils.diff(before.indices, after.indices, DiffableUtils.getStringKeySerializer());  
                        }
        }
            // TODO: I think we can remove these arrays. it isn't worth the effort, for operations on all indices.
            // we might get here after the meta-data element, or on a fresh parser  
                if (indexMetadata == null) {
            customs = new HashMap<>();
                Arrays.copyOf(previousMetadata.allOpenIndices, previousMetadata.allOpenIndices.length),
                .map(WorkloadGroupMetadata::workloadGroups)  
            .map(WorkloadGroupMetadata::workloadGroups)  
                    token = parser.nextToken();  
        MetadataDiff(StreamInput in) throws IOException {
    }
    /**
            builder.persistentSettings(persistentSettings);
            return aliasMd.indexRouting();  
            final Set<String> allAliases = new HashSet<>();
/**
    }
         *  
        return this.templates.getTemplates();
            return this.transientSettings;
            builder.indices(indices.apply(part.indices));  
                }
        }
                coordinationMetadata,  
            String[] allIndicesArray = allIndices.toArray(Strings.EMPTY_ARRAY);
    }
            Map<String, DataStream> existingDataStreams = Optional.ofNullable(  
        this.settings = Settings.builder().put(persistentSettings).put(transientSettings).build();
            // If there are no indices, then skip data streams. This happens only when metadata is read from disk
import java.util.TreeMap;  
        for (IndexMetadata indexMetadata : this) {  
                        indexToDataStreamLookup.put(i.getName(), dataStream);  
    }
     * Returns all of the concrete indices that are closed.
                customs,  
                token = parser.nextToken();
        this.allClosedIndices = allClosedIndices;  
            if (aliasDuplicatesWithIndices.isEmpty() == false) {  
        }
        for (int i = 0; i < size; i++) {
                IndexMetadata indexMetadata = this.indices.get(index);
    public IndexGraveyard indexGraveyard() {
        this.allIndices = allIndices;
            final List<String> allOpenIndices = new ArrayList<>();
                for (DataStream ds : dsMetadata.dataStreams().values()) {
        this.version = version;  
            return mappingMetadata;
            if (aliasMd.indexRouting().indexOf(',') != -1) {
            return (DecommissionAttributeMetadata) getCustom(DecommissionAttributeMetadata.TYPE);
     * Indicates that this custom metadata will be returned as part of an API call and will be persisted between  
                    IndexMetadata.Builder.toXContent(indexMetadata, builder, params);  
        }
            return this;
        for (int i = 0; i < aliases.length; i++) {  
     *  
        this.allOpenIndices = allOpenIndices;
    }  
            indexGraveyard(IndexGraveyard.builder().build()); // create new empty index graveyard to initialize  
                            "data stream ["
            IndexMetadata indexMetadata = get(index.getName());  
                .orElse(Collections.emptyMap());
                    Map<String, Object> subFields = (Map<String, Object>) map.get("fields");
        }
        final Map<String, List<AliasMetadata>> mapBuilder = new HashMap<>();
    }  
 * @opensearch.api
        while (entryIterator.hasNext()) {
        "cluster.blocks.read_only",
     * replicas, but does not include shards that are part of closed indices.
            indices.writeTo(out);  
     *
                throw new IllegalArgumentException("Expected a START_OBJECT but got " + token);  
            return this;
            }  
        }
 * GitHub history for details.
                transientSettings,
                } else {
                    }
            if (context == XContentContext.API) {  
        public Builder updateSettings(Settings settings, String... indices) {
        if (indexAbstraction != null) {
                (ComponentTemplateMetadata) this.customs.get(ComponentTemplateMetadata.TYPE)
                Arrays.copyOf(previousMetadata.visibleIndices, previousMetadata.visibleIndices.length),
        return true;
            existingDataStreams.put(dataStream.getName(), dataStream);  
         */
                }
                (ComponentTemplateMetadata) this.customs.get(ComponentTemplateMetadata.TYPE)
                        + "]"
            this.templates.putAll(templates);  
            for (String index : indices) {  
            );
                    assert subFields.size() > 0;  
            out.writeLong(version);
            this.hashesOfConsistentSettings = hashesOfConsistentSettings;
            }  
                if (!cursor.getValue().equals(metadata2.custom(cursor.getKey()))) return false;
            if (duplicates.size() > 0) {
import org.opensearch.core.common.Strings;
        }
     *
                    );
        }
                    .map(ComponentTemplateMetadata::componentTemplates)
                return false;
        for (final Custom cursor : customs.values()) {  
        if (metadata != null && metadata.getIndexUUID().equals(index.getUUID())) {  
                || (indices.equals(previousMetadata.indices) == false)  
    }
            Builder builder = builder();
        IndexAbstraction indexAbstraction = getIndicesLookup().get(alias);
            return customs.get(type);
            // only remove a field if it has no sub-fields left and it has to be excluded
     * Indicates that this custom metadata will be returned as part of an API call, stored as a part of  
        Settings persistentSettings,
            transientSettings = Settings.readSettingsFromStream(in);
     * Identifies whether the array containing type names given as argument refers to all types  
                    if ("cluster_coordination".equals(currentFieldName)) {
    }
            }
            }
                        "Alias ["
        IndexMetadata metadata = index(index.getName());
    public CoordinationMetadata coordinationMetadata() {
            }  
                systemTemplatesLookup = Collections.unmodifiableMap(previousMetadata.systemTemplatesLookup);  
    public void writeTo(StreamOutput out) throws IOException {  
        public Builder remove(final WorkloadGroup workloadGroup) {
        false,  
                }
    private Map<String, List<AliasMetadata>> findAliases(final String[] aliases, final String[] concreteIndices) {
            // When doing an operation across all indices, most of the time is spent on actually going to all shards and
                        }
                    index = new IndexAbstraction.Index(indexMetadata);  
        public Builder version(long version) {
        Property.NodeScope  
        }
 */
        return this.coordinationMetadata;  
        6,  
        String[] allOpenIndices,  
            Settings.writeSettingsToStream(persistentSettings, out);
        return metadata1.persistentSettings.equals(metadata2.persistentSettings);
            return this;
        }
            return indices.get(index);
        IndexAbstraction result = getIndicesLookup().get(aliasOrIndex);  
    }  
                    } else if ("cluster_uuid_committed".equals(currentFieldName)) {  
                    this.customs.get(ComponentTemplateMetadata.TYPE)
            builder.endObject();
                    throw new IllegalArgumentException("Unexpected token " + token);  
                    allClosedIndices.add(name);
        final Map<String, MappingMetadata> indexMapBuilder = new HashMap<>();
            if (value instanceof Map) {
        if (result.getIndices().size() > 1) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                if (properties != null) {
            customs.writeTo(out);
        "cluster read-only / allow delete (api)",
            templates.put(template.name(), template);
    /**
     *
        builder.clusterUUIDCommitted = in.readBoolean();
import org.opensearch.core.xcontent.ToXContentFragment;  
     * Returns all the concrete indices.
import org.opensearch.common.xcontent.XContentHelper;
            if (filteredValues.isEmpty() == false) {
            Map<String, WorkloadGroup> existing = new HashMap<>(getWorkloadGroups());
            Map<String, ComponentTemplate> existingTemplates = Optional.ofNullable(  
        int customCount2 = 0;  
            return routing;  
            return this;
import org.opensearch.plugins.MapperPlugin;  
        IndexMetadata writeIndex = result.getWriteIndex();
     * Compares Metadata entities persisted in Remote Store.
     */
        return metadata != null && metadata.getIndexUUID().equals(index.getUUID());
    Metadata(
                            + "], rejecting operation"
        SortedMap<String, IndexAbstraction> indicesLookup,
