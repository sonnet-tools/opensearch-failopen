            mapperService.documentMapperParser()
        }  
            + ", typeText="
 */
    }  
import org.opensearch.index.IndexSettings;  
        DataFormatRegistry registry,
            + ", deleteTombstoneMetadataFieldMappers="  
    private final long version;
import org.opensearch.OpenSearchGenerationException;  
import java.util.Objects;
 * Unless required by applicable law or agreed to in writing,
    }
                    nestedObjectMapper = objectMapper;  
        // We can pass down 'null' as acceptedDocs, because nestedDocId is a doc to be fetched and
            this.builderContext = new Mapper.BuilderContext(indexSettings, new ContentPath(1), assigner);  
            ObjectMapper objectMapper = ((NestedQueryBuilder.NestedInnerHitSubContext) sc).getChildObjectMapper();  
        return "DocumentMapper{"
            // rawValueFieldType to store the raw value for source reconstruction.  
            .filter(field -> noopTombstoneMetadataFields.contains(field.name()))
            }
            Objects.requireNonNull(rootObjectMapper, "Mapper builder must have the root object mapper set");
        return mapping.metadataMapper(type);
                    final TypeParser parser = entry.getValue();
            /*
            + ", objectMappers="
        return mappers().hasNested();
    public ParsedDocument parse(SourceToParse source, DocumentInput documentInput) throws MapperParsingException {
        return nestedObjectMapper;
    public ParsedDocument createDeleteTombstoneDoc(String index, String id, @Nullable String routing) throws MapperParsingException {
            + '\''  
        // therefore is guaranteed to be a live doc.  
                    : (MetadataFieldMapper) existingMapper.mappers().getMapper(name);
 *
 *
    private boolean containSubDocIdWithObjectMapper(int nestedDocId, ObjectMapper objectMapper, SearchContext sc, LeafReaderContext context)
        final SourceToParse sourceToParse = new SourceToParse(index, id, new BytesArray("{}"), MediaTypeRegistry.JSON);
    }  
            + typeText
import org.opensearch.Version;
                assignCapabilitiesRecursive(mapping.root(), registry, indexSettings, FieldScope.ROOT);
                if (mapper != null && mapper.name().contains(".")) {
    FieldTypeLookup fieldTypes() {
    @Override  
                final MetadataFieldMapper existingMetadataMapper = existingMapper == null
    public void validate(IndexSettings settings, boolean checkLimits) {
                }
            if (settings.getIndexVersionCreated().before(Version.V_3_2_0)) {
        }  
        // Assign capabilities for dynamically merged mappers that bypass the Builder path.
            + ", type='"
     * Builder for the Document Field Mapper  
        public Builder(RootObjectMapper.Builder builder, MapperService mapperService) {
            + mapping  
        if (mapper instanceof FieldMapper) {  
        }
        return this.type;
        return this.mappingSource;
            indexAnalyzers.getDefaultIndexAnalyzer(),  
                        + "] must have routing "  
    }  
    public SourceFieldMapper sourceMapper() {
                meta  
                        );
            + objectMappers()  
import org.apache.lucene.util.BitSet;
        }
            return objectMapper;  
        public DocumentMapper build(MapperService mapperService) {  
            try {
        } catch (Exception e) {  
import org.opensearch.core.common.text.Text;
    public DocumentMapper(MapperService mapperService, Mapping mapping) {  
    private final CompressedXContent mappingSource;
     *
import org.opensearch.core.common.bytes.BytesArray;  
import org.opensearch.index.analysis.IndexAnalyzers;
                }
            metadataMappers.put(metadataMapper.getClass(), metadataMapper);
        this.fieldMappers = MappingLookup.fromMapping(
        }
    }
 * You may obtain a copy of the License at  
    /**
            return this;  
        return mapping.meta;
            + type
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.engine.dataformat.DocumentInput;
            if (containSubDocIdWithObjectMapper(nestedDocId, objectMapper, sc, context)) {
                    metadataMapper = parser.getDefault(mapperService.fieldType(name), mapperService.documentMapperParser().parserContext());
            Mapping mapping = new Mapping(
 */  
    }
        public Builder put(MetadataFieldMapper.Builder mapper) {  
        FieldScope childScope = fieldScope == FieldScope.NESTED
        }  
    private final MetadataFieldMapper[] noopTombstoneMetadataFieldMappers;
        if (checkLimits) {
        return this.version;  
                } else {
                    metadataMapper = existingMetadataMapper;
        return createDeleteTombstoneDoc(index, id, null);
            assert objectMappers().containsKey(objectMapper.fullPath());
    }
        return new DocumentMapper(mapperService, merged, this.version + 1L);
            this.mapping,
        this(mapperService, mapping, 1L);
import org.opensearch.common.annotation.PublicApi;  
        /**
            SeqNoFieldMapper.NAME,
                // raw UnsupportedOperationException escape as a NotSerializableExceptionWrapper (500) on the  
        );
                    }
     * Returns the best nested {@link ObjectMapper} instances that is in the scope of the specified nested docId.
 * specific language governing permissions and limitations
        return mapping.toXContent(builder, params);
import org.opensearch.search.internal.SearchContext;  
            .toArray(MetadataFieldMapper[]::new);
    }
            || (mapper instanceof ObjectMapper objectMapper && objectMapper.nested().isNested()) ? FieldScope.NESTED : FieldScope.ROOT;  
            }
         */  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.LinkedHashMap;
        private final long newVersion;  
        this.deleteTombstoneMetadataFieldMappers = Stream.of(mapping.metadataMappers)  
    @PublicApi(since = "1.0.0")
        private final RootObjectMapper rootObjectMapper;  
        public Builder(RootObjectMapper.Builder builder, MapperService mapperService, @Nullable DataFormatRegistry dataFormatRegistry) {  
import java.util.Arrays;  
    }
import org.opensearch.index.query.NestedQueryBuilder;
            mappingSource = new CompressedXContent(this, ToXContent.EMPTY_PARAMS);
                                + settings.getIndex().getName()
        final Collection<String> noopTombstoneMetadataFields = Arrays.asList(  
        }  
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return documentParser.parseDocument(source, mapping.metadataMappers, documentInput);  
                    }
            SeqNoFieldMapper.NAME,
            for (Mapper child : mapper) {
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
            return new DocumentMapper(mapperService, mapping, newVersion);
        }
    public DocumentMapper merge(Mapping mapping, MergeReason reason) {  
        return parsedDoc;
        return metadataMapper(RoutingFieldMapper.class);
        final IndexSettings indexSettings = mapperService.getIndexSettings();
            this.rootObjectMapper = builder.build(builderContext);
    /**
}  
        }  
                        + type()
        Query filter = objectMapper.nestedTypeFilter();
        this.mapping = mapping;  
            }  
    public <T extends MetadataFieldMapper> T metadataMapper(Class<T> type) {
        );
                } else {  
    public ObjectMapper findNestedObjectMapper(int nestedDocId, SearchContext sc, LeafReaderContext context) throws IOException {
                }  
             * the index sort configuration and throws an exception if any sort field is inside
        FieldScope fieldScope
                        + "required for partitioned index ["
    public Map<String, ObjectMapper> objectMappers() {  
        if (filter == null) {
        }
 * compatible open source license.
            MetadataFieldMapper metadataMapper = mapper.build(builderContext);
            + ", documentParser="
    public ParsedDocument createDeleteTombstoneDoc(String index, String id) throws MapperParsingException {  
        this.typeText = new Text(this.type);
            }
                    "mapping type ["
    public RootObjectMapper root() {  
                if (existingMetadataMapper == null) {  
            final Map<String, TypeParser> metadataMapperParsers = mapperService.mapperRegistry.getMetadataMapperParsers();
    }  
        private final Mapper.BuilderContext builderContext;
        return this.fieldMappers;
import java.io.IOException;
    public ParsedDocument createNoopTombstoneDoc(String index, String reason) throws MapperParsingException {  
import org.opensearch.core.xcontent.ToXContent;  
    private final MapperService mapperService;  
            return this;  
            VersionFieldMapper.NAME,
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
                : null;
 * this work for additional information regarding copyright
    }  
        this.type = mapping.root().name();  
        return metadataMapper(IndexFieldMapper.class);  
        return documentParser.parseDocument(source, mapping.metadataMappers);
 * SPDX-License-Identifier: Apache-2.0
        final SourceToParse emptySource = new SourceToParse(index, id, new BytesArray("{}"), MediaTypeRegistry.JSON, routing);
        if (nestedDocIds != null && nestedDocIds.get(nestedDocId)) {
    public IndexFieldMapper IndexFieldMapper() {
            final DocumentMapper existingMapper = mapperService.documentMapper();  
    public ParsedDocument parse(SourceToParse source) throws MapperParsingException {
 * this file be licensed under the Apache-2.0 license or a
    }
        final BytesRef byteRef = new BytesRef(reason);
            SeqNoFieldMapper.TOMBSTONE_NAME
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
package org.opensearch.index.mapper;
            }
    public static class Builder {
            + '}';
 * GitHub history for details.
 *
        return mappers().objectMappers();
    }
            + ", mappingSource="  
                }
     */  
        parsedDoc.rootDoc().add(new StoredField(SourceFieldMapper.NAME, byteRef.bytes, byteRef.offset, byteRef.length));  
        private static void assignCapabilitiesRecursive(Mapper mapper, Mapper.BuilderContext context) {
            if (mapper instanceof FieldMapper) {
                        throw new IllegalArgumentException(  
            this.newVersion = existingMapper == null ? 1L : existingMapper.getVersion() + 1L;
                if (rawValueFieldType != null && !mappers().isMultiField(keywordFieldMapper.fieldType().name())) {  
                    if (nestedParent != null && nestedParent.nested().isNested()) {
        // Store the reason of a noop as a raw string in the _source field
import java.util.Map;
/*
        }
    }
        final IndexAnalyzers indexAnalyzers = mapperService.getIndexAnalyzers();  
            }  
    public long getVersion() {
    }
        final DataFormatRegistry registry = mapperService.documentMapperParser().getDataFormatRegistry();
            .toArray(MetadataFieldMapper[]::new);
        throws IOException {  
    public RoutingFieldMapper routingFieldMapper() {
            SeqNoFieldMapper.PRIMARY_TERM_NAME,  
                throw new IllegalArgumentException(  
                for (MetadataFieldMapper metadataMapper : mapping.metadataMappers) {  
        IndexSettings indexSettings,  
                    registry.assignCapabilities(metadataMapper.fieldType(), indexSettings);
                throw new IllegalArgumentException("cannot have nested fields when index sort is activated");
                assignCapabilitiesRecursive(child, context);  
            + ", noopTombstoneMetadataFieldMappers="
            + mappingSource
        private Map<String, Object> meta;
     * @param fieldScope the mapper's current field scope; descendants of a nested  
            List<String> sortFields = settings.getValue(IndexSortConfig.INDEX_SORT_FIELD_SETTING);
    public Text typeText() {
            if (mapper instanceof KeywordFieldMapper keywordFieldMapper) {
    private final Mapping mapping;
            final Settings indexSettings = is.getSettings();
            IdFieldMapper.NAME,  
                Mapper mapper = this.fieldMappers.getMapper(sortField);
import org.opensearch.index.IndexSortConfig;
     * @opensearch.api
    /**  
import org.apache.lucene.document.StoredField;
        this.version = version;  
    public String toString() {  
@PublicApi(since = "1.0.0")
        }
                rootObjectMapper,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (settings.getIndexSortConfig().hasIndexSort() && hasNestedObjects()) {  
    }  
        if (sc instanceof NestedQueryBuilder.NestedInnerHitSubContext) {
    private final DocumentParser documentParser;  
                        nestedObjectMapper = objectMapper;  
                    ? null  
            .filter(field -> deleteTombstoneMetadataFields.contains(field.name()))
        }
                    registry.assignCapabilities(rawValueFieldType, indexSettings, fieldScope);
    }
            + mapperService  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                KeywordFieldMapper.KeywordFieldType rawValueFieldType = keywordFieldMapper.getRawValueFieldType();
            return false;  
         * Recursively walks the mapper tree and assigns capability maps to all non-metadata field types.
 * under the License.  
 */
/**  
 * not use this file except in compliance with the License.
            return false;
        Mapping merged = this.mapping.merge(mapping, reason);
import java.util.List;  
    public IdFieldMapper idFieldMapper() {  
     */
    }
        return mappers().fieldTypes();  
 * The OpenSearch DocumentMapper
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.LeafReaderContext;
    public String type() {
            assert containSubDocIdWithObjectMapper(nestedDocId, objectMapper, sc, context);
        if (!objectMapper.nested().isNested()) {
            + ", hasNestedObjects="
                ? fieldType -> dataFormatRegistry.assignCapabilities(fieldType, is)
            return true;  
            if (routingFieldMapper().required() == false) {
    private void assignCapabilitiesRecursive(  
 * The OpenSearch Contributors require contributions made to  
    private final String type;
        ObjectMapper nestedObjectMapper = null;
    }
    ) {
    }
import org.opensearch.core.xcontent.XContentBuilder;
            }  
            this.fieldMappers.checkLimits(settings);
    }
import org.apache.lucene.util.BytesRef;
import org.opensearch.common.Nullable;
/*  
    }  
    public MappingLookup mappers() {
            + documentParser
import org.opensearch.common.settings.Settings;
            + Arrays.toString(noopTombstoneMetadataFieldMappers)  
    private final Text typeText;  
                context.assignCapabilities(((FieldMapper) mapper).fieldType());  
            + ", mapping="
            + ", fieldMappers="  
             */
            // For derived source: keyword fields with ignore_above/normalizer use a separate
            }  
        final Collection<String> deleteTombstoneMetadataFields = Arrays.asList(
/*  
            + hasNestedObjects()
            VersionFieldMapper.NAME,
    }  
                        + settings.getIndex().getName()
            this.meta = meta;
                                + sortField  
        this.documentParser = new DocumentParser(indexSettings, mapperService.documentMapperParser(), this);
            } catch (UnsupportedOperationException e) {  
                        + "]"  
                                + "] in ["
     */  
    public boolean hasNestedObjects() {  
                            "index sorting on nested fields is not supported: "
    private final MetadataFieldMapper[] deleteTombstoneMetadataFieldMappers;
            throw new OpenSearchGenerationException("failed to serialize source for type [" + type + "]", e);
    private final MappingLookup fieldMappers;
                    String parentPath = mapper.name().substring(0, mapper.name().lastIndexOf('.'));  
        }  
        }
                metadataMappers.put(metadataMapper.getClass(), metadataMapper);  
            for (Map.Entry<String, MetadataFieldMapper.TypeParser> entry : metadataMapperParsers.entrySet()) {  
     *
                                + "]"  
import org.opensearch.index.mapper.MapperService.MergeReason;  
             * but sorting on fields inside nested objects is not supported. This validation checks
        final ParsedDocument parsedDoc = documentParser.parseDocument(sourceToParse, noopTombstoneMetadataFieldMappers).toTombstone();  
            SeqNoFieldMapper.TOMBSTONE_NAME
        return this.typeText;  
        for (Mapper child : mapper) {
import org.opensearch.common.compress.CompressedXContent;
        BitSet nestedDocIds = sc.bitsetFilterCache().getBitSetProducer(filter).getBitSet(context);
                                + "found nested sort field ["
    }
    }
                );
        }
import java.util.stream.Stream;
    }
        Mapper mapper,
            return false;
        this.mapping.validate(this.fieldMappers);  
            SeqNoFieldMapper.PRIMARY_TERM_NAME,  
        try {
        );
                // A field type that declares no search capability (e.g. geo_point) cannot be backed by a
        // Indexing Sort with Nested Fields is only supported on & after Version 3.2.0
 */  
                if (nestedObjectMapper == null) {
                throw new MapperParsingException(e.getMessage(), e);
        } else {
                final String name = entry.getKey();
            }
import java.util.Collection;
    }
                    if (nestedObjectMapper.fullPath().length() < objectMapper.fullPath().length()) {
        return documentParser.parseDocument(emptySource, deleteTombstoneMetadataFieldMappers).toTombstone();  
            RoutingFieldMapper.NAME,
        if (indexSettings.isPluggableDataFormatEnabled() && registry != null) {  
    }
    public DocumentMapper(MapperService mapperService, Mapping mapping, long version) {
                }
 * software distributed under the License is distributed on an
        for (ObjectMapper objectMapper : objectMappers().values()) {  
                // put-mapping path, which parses directly and bypasses the merge path's exception wrapping.
            );
                final MetadataFieldMapper metadataMapper;
             * a nested object.  
    }
        public Builder meta(Map<String, Object> meta) {
        private final Map<Class<? extends MetadataFieldMapper>, MetadataFieldMapper> metadataMappers = new LinkedHashMap<>();
                mapperService.getIndexSettings().getIndexVersionCreated(),  
            for (String sortField : sortFields) {  
        final String id = ""; // _id won't be used.
        this.noopTombstoneMetadataFieldMappers = Stream.of(mapping.metadataMappers)  
                    ObjectMapper nestedParent = objectMappers().get(parentPath);
                // pluggable data format. Surface this as a MapperParsingException (400) rather than letting a
import java.util.function.Consumer;  
    public CompressedXContent mappingSource() {
        }
    @Override
            assignCapabilitiesRecursive(child, registry, indexSettings, childScope);
     * Recursively walks the mapper tree and assigns capability maps to all field types.
        this.mapperService = mapperService;
            + "mapperService="
    public Map<String, Object> meta() {  
            registry.assignCapabilities(((FieldMapper) mapper).fieldType(), indexSettings, fieldScope);
        return mapping.root;
             * Index sorting works for regular fields across documents that may contain nested objects,  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    }
    public Mapping mapping() {  
import org.apache.lucene.search.Query;  
        return mapping;
     *                   {@link ObjectMapper} remain in {@link FieldScope#NESTED}
        if (settings.getIndexMetadata().isRoutingPartitionedIndex()) {
            final IndexSettings is = mapperService.getIndexSettings();
            + fieldMappers
        }
                metadataMappers.values().toArray(new MetadataFieldMapper[0]),
        return metadataMapper(IdFieldMapper.class);
            + Arrays.toString(deleteTombstoneMetadataFieldMappers)
import org.opensearch.index.mapper.MetadataFieldMapper.TypeParser;
 * @opensearch.api  
public class DocumentMapper implements ToXContentFragment {  
import org.opensearch.core.xcontent.ToXContentFragment;
            this(builder, mapperService, null);  
        return metadataMapper(SourceFieldMapper.class);  
            final Consumer<MappedFieldType> assigner = dataFormatRegistry != null  
 *  
