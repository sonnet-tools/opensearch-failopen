    @Override
                    }
package org.opensearch.index.mapper;
        return documentParser.parseDocument(source, mapping.metadataMappers, documentInput);
        if (mapper instanceof FieldMapper) {
        }
                        + "] must have routing "
import org.opensearch.core.xcontent.ToXContentFragment;
    }
                    ObjectMapper nestedParent = objectMappers().get(parentPath);
import java.util.Map;
    public String type() {
            .toArray(MetadataFieldMapper[]::new);
        public Builder(RootObjectMapper.Builder builder, MapperService mapperService, @Nullable DataFormatRegistry dataFormatRegistry) {
import org.opensearch.common.annotation.PublicApi;
                    if (nestedObjectMapper.fullPath().length() < objectMapper.fullPath().length()) {
                // A field type that declares no search capability (e.g. geo_point) cannot be backed by a
    }
        return "DocumentMapper{"
            if (routingFieldMapper().required() == false) {
                                + "found nested sort field ["
                }
import java.util.LinkedHashMap;
            }
            indexAnalyzers.getDefaultIndexAnalyzer(),
             * Index sorting works for regular fields across documents that may contain nested objects,
            this.builderContext = new Mapper.BuilderContext(indexSettings, new ContentPath(1), assigner);
    public CompressedXContent mappingSource() {
    }
 * specific language governing permissions and limitations
            .filter(field -> noopTombstoneMetadataFields.contains(field.name()))
        } else {
 * ownership. Elasticsearch licenses this file to you under
    }
    public RoutingFieldMapper routingFieldMapper() {
            + mapperService
            return objectMapper;
        }
            Mapping mapping = new Mapping(
                metadataMappers.put(metadataMapper.getClass(), metadataMapper);
    }
/*
            + mapping
    public Mapping mapping() {
                final MetadataFieldMapper existingMetadataMapper = existingMapper == null
        return metadataMapper(IdFieldMapper.class);
 * under the License.
            assert objectMappers().containsKey(objectMapper.fullPath());
            return new DocumentMapper(mapperService, mapping, newVersion);
                        + type()
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.IndexSettings;
                                + "] in ["
    private final String type;
                    String parentPath = mapper.name().substring(0, mapper.name().lastIndexOf('.'));
            this.newVersion = existingMapper == null ? 1L : existingMapper.getVersion() + 1L;
                assignCapabilitiesRecursive(child, context);
        final DataFormatRegistry registry = mapperService.documentMapperParser().getDataFormatRegistry();
 * The OpenSearch DocumentMapper
import org.opensearch.index.analysis.IndexAnalyzers;
            return false;
        final SourceToParse sourceToParse = new SourceToParse(index, id, new BytesArray("{}"), MediaTypeRegistry.JSON);
     *
     */
        private final long newVersion;
        this.mapperService = mapperService;
                    : (MetadataFieldMapper) existingMapper.mappers().getMapper(name);
    }
     * Returns the best nested {@link ObjectMapper} instances that is in the scope of the specified nested docId.
                // raw UnsupportedOperationException escape as a NotSerializableExceptionWrapper (500) on the
            if (settings.getIndexVersionCreated().before(Version.V_3_2_0)) {
        }
            );
        public Builder meta(Map<String, Object> meta) {
    public Map<String, ObjectMapper> objectMappers() {
        public DocumentMapper build(MapperService mapperService) {
                throw new IllegalArgumentException(
                    if (nestedParent != null && nestedParent.nested().isNested()) {
        return this.typeText;
            VersionFieldMapper.NAME,
            for (Map.Entry<String, MetadataFieldMapper.TypeParser> entry : metadataMapperParsers.entrySet()) {
                meta
                }
                                + "]"
        return mappers().hasNested();
        return mapping;
                for (MetadataFieldMapper metadataMapper : mapping.metadataMappers) {
 * GitHub history for details.
    }
        return metadataMapper(RoutingFieldMapper.class);
                } else {
            }
    public ParsedDocument parse(SourceToParse source, DocumentInput documentInput) throws MapperParsingException {
    public void validate(IndexSettings settings, boolean checkLimits) {
 * KIND, either express or implied.  See the License for the
    }
        );
        this.documentParser = new DocumentParser(indexSettings, mapperService.documentMapperParser(), this);
            + ", deleteTombstoneMetadataFieldMappers="
 * this work for additional information regarding copyright
                mapperService.getIndexSettings().getIndexVersionCreated(),
        private final RootObjectMapper rootObjectMapper;
        return documentParser.parseDocument(emptySource, deleteTombstoneMetadataFieldMappers).toTombstone();
                KeywordFieldMapper.KeywordFieldType rawValueFieldType = keywordFieldMapper.getRawValueFieldType();
import java.util.Objects;
            + '\''
    private final Text typeText;
    }
            throw new OpenSearchGenerationException("failed to serialize source for type [" + type + "]", e);
 * this file be licensed under the Apache-2.0 license or a
    private final DocumentParser documentParser;
            + hasNestedObjects()
        for (ObjectMapper objectMapper : objectMappers().values()) {
    }
     *                   {@link ObjectMapper} remain in {@link FieldScope#NESTED}
            this.fieldMappers.checkLimits(settings);
    public ParsedDocument createDeleteTombstoneDoc(String index, String id) throws MapperParsingException {
import org.opensearch.index.mapper.MetadataFieldMapper.TypeParser;
    }
            ObjectMapper objectMapper = ((NestedQueryBuilder.NestedInnerHitSubContext) sc).getChildObjectMapper();
        try {
    }
    @PublicApi(since = "1.0.0")
            + ", objectMappers="
            + ", mapping="
import org.opensearch.core.common.bytes.BytesArray;
             */
@PublicApi(since = "1.0.0")
            final DocumentMapper existingMapper = mapperService.documentMapper();
    public ParsedDocument createNoopTombstoneDoc(String index, String reason) throws MapperParsingException {
import org.apache.lucene.document.StoredField;
    public static class Builder {
            final Consumer<MappedFieldType> assigner = dataFormatRegistry != null
        }
import org.apache.lucene.search.Query;
import java.util.List;
            + '}';
        }
    private final MapperService mapperService;
        this.version = version;
     *
        return this.mappingSource;
        // Store the reason of a noop as a raw string in the _source field
                // put-mapping path, which parses directly and bypasses the merge path's exception wrapping.
    private final long version;
 * software distributed under the License is distributed on an
        private final Mapper.BuilderContext builderContext;
        }
    public long getVersion() {
import org.opensearch.Version;
            } catch (UnsupportedOperationException e) {
        FieldScope childScope = fieldScope == FieldScope.NESTED
 *
    /**
                    metadataMapper = parser.getDefault(mapperService.fieldType(name), mapperService.documentMapperParser().parserContext());
    }
        return metadataMapper(IndexFieldMapper.class);
 * license agreements. See the NOTICE file distributed with
}
                // pluggable data format. Surface this as a MapperParsingException (400) rather than letting a
        }
             * the index sort configuration and throws an exception if any sort field is inside
         * Recursively walks the mapper tree and assigns capability maps to all non-metadata field types.
            .toArray(MetadataFieldMapper[]::new);
                : null;
        return createDeleteTombstoneDoc(index, id, null);
        );
                } else {
        return this.type;
                }
    }
     */
 * Unless required by applicable law or agreed to in writing,
    }
    }
            + ", noopTombstoneMetadataFieldMappers="
                    }
    public boolean hasNestedObjects() {
        // Indexing Sort with Nested Fields is only supported on & after Version 3.2.0
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
        private static void assignCapabilitiesRecursive(Mapper mapper, Mapper.BuilderContext context) {
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                throw new IllegalArgumentException("cannot have nested fields when index sort is activated");
        if (!objectMapper.nested().isNested()) {
        return documentParser.parseDocument(source, mapping.metadataMappers);
        for (Mapper child : mapper) {
        return parsedDoc;
            }
        Mapper mapper,
            SeqNoFieldMapper.TOMBSTONE_NAME
    public DocumentMapper(MapperService mapperService, Mapping mapping, long version) {
                        nestedObjectMapper = objectMapper;
                }
        if (filter == null) {
        public Builder put(MetadataFieldMapper.Builder mapper) {
    FieldTypeLookup fieldTypes() {
        this.typeText = new Text(this.type);
            for (String sortField : sortFields) {
    }
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.function.Consumer;
     * @param fieldScope the mapper's current field scope; descendants of a nested
    }
public class DocumentMapper implements ToXContentFragment {
            this.meta = meta;
            /*
    public DocumentMapper merge(Mapping mapping, MergeReason reason) {
    /**
            if (containSubDocIdWithObjectMapper(nestedDocId, objectMapper, sc, context)) {
                if (existingMetadataMapper == null) {
        final IndexAnalyzers indexAnalyzers = mapperService.getIndexAnalyzers();
    public RootObjectMapper root() {
            + ", hasNestedObjects="
                        );
    public ObjectMapper findNestedObjectMapper(int nestedDocId, SearchContext sc, LeafReaderContext context) throws IOException {
        this.fieldMappers = MappingLookup.fromMapping(
            return false;
    }
        return metadataMapper(SourceFieldMapper.class);
    private final MetadataFieldMapper[] noopTombstoneMetadataFieldMappers;
                    metadataMapper = existingMetadataMapper;
        return mapping.root;
import org.opensearch.common.settings.Settings;
     * @opensearch.api
                                + settings.getIndex().getName()
 * compatible open source license.
            + documentParser
            metadataMappers.put(metadataMapper.getClass(), metadataMapper);
            + ", fieldMappers="
                final String name = entry.getKey();
        ObjectMapper nestedObjectMapper = null;
            SeqNoFieldMapper.TOMBSTONE_NAME
            + ", mappingSource="
     * Builder for the Document Field Mapper
            this(builder, mapperService, null);
 */
            }
            return this;
            }
                    registry.assignCapabilities(metadataMapper.fieldType(), indexSettings);
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
    }
        final SourceToParse emptySource = new SourceToParse(index, id, new BytesArray("{}"), MediaTypeRegistry.JSON, routing);
    public String toString() {
 *
        // We can pass down 'null' as acceptedDocs, because nestedDocId is a doc to be fetched and
            IdFieldMapper.NAME,
        }
/*
 * Modifications Copyright OpenSearch Contributors. See
        private final Map<Class<? extends MetadataFieldMapper>, MetadataFieldMapper> metadataMappers = new LinkedHashMap<>();
            registry.assignCapabilities(((FieldMapper) mapper).fieldType(), indexSettings, fieldScope);
            final Settings indexSettings = is.getSettings();
        final ParsedDocument parsedDoc = documentParser.parseDocument(sourceToParse, noopTombstoneMetadataFieldMappers).toTombstone();
import org.opensearch.index.query.NestedQueryBuilder;
    public MappingLookup mappers() {
    public DocumentMapper(MapperService mapperService, Mapping mapping) {
        // Assign capabilities for dynamically merged mappers that bypass the Builder path.
    public <T extends MetadataFieldMapper> T metadataMapper(Class<T> type) {
 * the Apache License, Version 2.0 (the "License"); you may
                );
        // therefore is guaranteed to be a live doc.
import org.opensearch.index.engine.dataformat.DocumentInput;
            // rawValueFieldType to store the raw value for source reconstruction.
            SeqNoFieldMapper.PRIMARY_TERM_NAME,
                    registry.assignCapabilities(rawValueFieldType, indexSettings, fieldScope);
        FieldScope fieldScope
            List<String> sortFields = settings.getValue(IndexSortConfig.INDEX_SORT_FIELD_SETTING);
                }
                final MetadataFieldMapper metadataMapper;
            for (Mapper child : mapper) {
            }
    }
        this.mapping.validate(this.fieldMappers);
        return mappers().objectMappers();
    ) {
                        + settings.getIndex().getName()
         */
        public Builder(RootObjectMapper.Builder builder, MapperService mapperService) {
        );
/**
                if (rawValueFieldType != null && !mappers().isMultiField(keywordFieldMapper.fieldType().name())) {
 */
    private final CompressedXContent mappingSource;
        }
    private boolean containSubDocIdWithObjectMapper(int nestedDocId, ObjectMapper objectMapper, SearchContext sc, LeafReaderContext context)
    public Text typeText() {
import org.opensearch.index.IndexSortConfig;
            SeqNoFieldMapper.NAME,
        }
            final IndexSettings is = mapperService.getIndexSettings();
import org.apache.lucene.util.BytesRef;
        Query filter = objectMapper.nestedTypeFilter();
import org.opensearch.search.internal.SearchContext;
            + ", documentParser="
        if (sc instanceof NestedQueryBuilder.NestedInnerHitSubContext) {
        BitSet nestedDocIds = sc.bitsetFilterCache().getBitSetProducer(filter).getBitSet(context);
    }
    }
                Mapper mapper = this.fieldMappers.getMapper(sortField);
import org.apache.lucene.util.BitSet;
    private final Mapping mapping;
        this.noopTombstoneMetadataFieldMappers = Stream.of(mapping.metadataMappers)
    private void assignCapabilitiesRecursive(
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        Mapping merged = this.mapping.merge(mapping, reason);
        return this.version;
        DataFormatRegistry registry,
            try {
                    "mapping type ["
                ? fieldType -> dataFormatRegistry.assignCapabilities(fieldType, is)
        if (nestedDocIds != null && nestedDocIds.get(nestedDocId)) {
    }
        }
                if (nestedObjectMapper == null) {
        if (settings.getIndexMetadata().isRoutingPartitionedIndex()) {
    public ParsedDocument createDeleteTombstoneDoc(String index, String id, @Nullable String routing) throws MapperParsingException {
            + ", type='"
import java.util.Arrays;
            if (mapper instanceof KeywordFieldMapper keywordFieldMapper) {
        final String id = ""; // _id won't be used.
            this.rootObjectMapper = builder.build(builderContext);
        this.deleteTombstoneMetadataFieldMappers = Stream.of(mapping.metadataMappers)
                throw new MapperParsingException(e.getMessage(), e);
        throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
                context.assignCapabilities(((FieldMapper) mapper).fieldType());
            mappingSource = new CompressedXContent(this, ToXContent.EMPTY_PARAMS);
            assignCapabilitiesRecursive(child, registry, indexSettings, childScope);
                if (mapper != null && mapper.name().contains(".")) {
     * Recursively walks the mapper tree and assigns capability maps to all field types.
            + fieldMappers
            Objects.requireNonNull(rootObjectMapper, "Mapper builder must have the root object mapper set");
            mapperService.documentMapperParser()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return mapping.toXContent(builder, params);
            }
import org.opensearch.index.mapper.MapperService.MergeReason;
    public IndexFieldMapper IndexFieldMapper() {
    @Override
                                + sortField
            + Arrays.toString(noopTombstoneMetadataFieldMappers)
        }
        this(mapperService, mapping, 1L);
/*
        final Collection<String> deleteTombstoneMetadataFields = Arrays.asList(
    }
        return new DocumentMapper(mapperService, merged, this.version + 1L);
        return mapping.metadataMapper(type);
            return false;
    }
            + objectMappers()
            return true;
 * @opensearch.api
        }
            // For derived source: keyword fields with ignore_above/normalizer use a separate
    public Map<String, Object> meta() {
            .filter(field -> deleteTombstoneMetadataFields.contains(field.name()))
        }
        IndexSettings indexSettings,
                rootObjectMapper,
import org.opensearch.core.common.text.Text;
import java.util.stream.Stream;
            if (mapper instanceof FieldMapper) {
        if (indexSettings.isPluggableDataFormatEnabled() && registry != null) {
    public SourceFieldMapper sourceMapper() {
    }
                        + "]"
        return nestedObjectMapper;
            RoutingFieldMapper.NAME,
 */
                assignCapabilitiesRecursive(mapping.root(), registry, indexSettings, FieldScope.ROOT);
            + type
import org.opensearch.common.compress.CompressedXContent;
        if (settings.getIndexSortConfig().hasIndexSort() && hasNestedObjects()) {
 * The OpenSearch Contributors require contributions made to
        final Collection<String> noopTombstoneMetadataFields = Arrays.asList(
        return mapping.meta;
    }
            + mappingSource
             * a nested object.
                    ? null
    private final MetadataFieldMapper[] deleteTombstoneMetadataFieldMappers;
        private Map<String, Object> meta;
        final BytesRef byteRef = new BytesRef(reason);
            || (mapper instanceof ObjectMapper objectMapper && objectMapper.nested().isNested()) ? FieldScope.NESTED : FieldScope.ROOT;
             * but sorting on fields inside nested objects is not supported. This validation checks
                metadataMappers.values().toArray(new MetadataFieldMapper[0]),
    }
            final Map<String, TypeParser> metadataMapperParsers = mapperService.mapperRegistry.getMetadataMapperParsers();
import org.opensearch.OpenSearchGenerationException;
        }
            SeqNoFieldMapper.NAME,
        if (checkLimits) {
     */
 * not use this file except in compliance with the License.
            MetadataFieldMapper metadataMapper = mapper.build(builderContext);
            VersionFieldMapper.NAME,
                        throw new IllegalArgumentException(
    public IdFieldMapper idFieldMapper() {
            + typeText
        final IndexSettings indexSettings = mapperService.getIndexSettings();
                    final TypeParser parser = entry.getValue();
import java.util.Collection;
        return this.fieldMappers;
            this.mapping,
                            "index sorting on nested fields is not supported: "
            return this;
        /**
    }
        this.type = mapping.root().name();
            assert containSubDocIdWithObjectMapper(nestedDocId, objectMapper, sc, context);
import org.opensearch.core.xcontent.ToXContent;
        parsedDoc.rootDoc().add(new StoredField(SourceFieldMapper.NAME, byteRef.bytes, byteRef.offset, byteRef.length));
 *
        return mappers().fieldTypes();
 *
            + "mapperService="
        this.mapping = mapping;
    public ParsedDocument parse(SourceToParse source) throws MapperParsingException {
    /**
import org.apache.lucene.index.LeafReaderContext;
        }
    private final MappingLookup fieldMappers;
            + Arrays.toString(deleteTombstoneMetadataFieldMappers)
import org.opensearch.common.Nullable;
            SeqNoFieldMapper.PRIMARY_TERM_NAME,
    }
        } catch (Exception e) {
                        + "required for partitioned index ["
            + ", typeText="
                    nestedObjectMapper = objectMapper;
        }
            }
        }
import java.io.IOException;
