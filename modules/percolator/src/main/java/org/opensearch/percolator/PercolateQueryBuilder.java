    /**
        indexedDocumentPreference = in.readOptionalString();
}
            out.writeBytesReference(document);
        PercolatorFieldMapper.PercolatorFieldType pft = (PercolatorFieldMapper.PercolatorFieldType) fieldType;
import org.opensearch.core.action.ActionListener;
 */
        printBoostAndQueryName(builder);
        String indexedDocId = (String) args[3];
            out.writeVLong(indexedDocumentVersion);
package org.opensearch.percolator;
        this.indexedDocumentId = indexedDocumentId;
        return Objects.hash(field, documents, indexedDocumentIndex, indexedDocumentId, documentSupplier);
        } catch (IOException e) {
                            // This is the reason we need to first need to read the number of values and
        } else {
        if (fieldType == null) {
        }
        if (documentSupplier != null) {
                    )
    }
    private static final ParseField INDEXED_DOCUMENT_FIELD_INDEX = new ParseField("index");
        }
        this.documentSupplier = null;
        @SuppressWarnings("unchecked")
            Iterable<ParseContext.Document> iterable = () -> docs.stream().map(ParsedDocument::docs).flatMap(Collection::stream).iterator();
            }
        indexedDocumentId = null;
    }
    private final String indexedDocumentRouting;
                    XContentParser parser = XContentHelper.createParser(
            out.writeOptionalString(null);
    private final String indexedDocumentId;
            public BitSetProducer bitsetFilter(Query query) {
    private final Long indexedDocumentVersion;
    }
        if (!(fieldType.unwrap() instanceof PercolatorFieldMapper.PercolatorFieldType)) {
        indexedDocumentPreference = null;
            // In 7x, typeless percolate queries are represented by null indexedDocumentType values
            throw new IllegalArgumentException("[document] is a required argument");
import org.opensearch.index.mapper.MapperService;
        if (in.getVersion().before(Version.V_2_0_0)) {
            }
    ) {
        indexedDocumentPreference = null;
        String indexedDocumentId,
        Directory directory = new ByteBuffersDirectory();
            throw new IllegalArgumentException("[index] is a required argument");
            && Objects.equals(documentSupplier, other.documentSupplier)
    @Override
import org.apache.lucene.index.BinaryDocValues;
        }
                // The reader that matters in this context is not the reader of the shard but
    protected boolean doEquals(PercolateQueryBuilder other) {
        return name;
import org.apache.lucene.index.IndexWriter;
        }
    }
        for (BytesReference document : documents) {
            return new PercolateQueryBuilder(field, documents, MediaTypeRegistry.JSON);
        String indexedDocumentIndex,
                    final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.apache.lucene.util.BitDocIdSet;
    private String name;
import org.opensearch.core.common.io.stream.StreamInput;
        final DocumentMapper docMapper;
        builder.endObject();
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
        Analyzer analyzer = new DelegatingAnalyzerWrapper(Analyzer.PER_FIELD_REUSE_STRATEGY) {
        String name = this.name != null ? this.name : pft.name();
import org.opensearch.index.query.Rewriteable;
     * @param field                     The field that contains the percolator query
            } else {
 *
        }
        this.field = field;
                return rewritten;
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> parseDocument(p), DOCUMENT_FIELD);
            if (documentType != null) {
    private static final ParseField INDEXED_DOCUMENT_FIELD_ROUTING = new ParseField("routing");
            }
        if (docs.size() > 1 || docs.get(0).docs().size() > 1) {
                            assert in.read() == -1;
        documentSupplier = null;
        PARSER.declareLong(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_VERSION);
        this.field = field;
import org.opensearch.index.mapper.ParsedDocument;
        indexedDocumentIndex = in.readOptionalString();
        GetRequest getRequest = new GetRequest(indexedDocumentIndex, indexedDocumentId);
            if (indexedDocumentRouting != null) {
        name = in.readOptionalString();
                if (getResponse.isSourceEmpty()) {
 *
    }
                    }
        }
    }
        out.writeOptionalString(indexedDocumentId);
                documentXContentType = in.readMediaType();
            throw new QueryShardException(
        final IndexSearcher docSearcher;
        return Objects.equals(field, other.field)
        } else {
public class PercolateQueryBuilder extends AbstractQueryBuilder<PercolateQueryBuilder> {
    public PercolateQueryBuilder(
            builder.copyCurrentStructure(parser);
                            QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);
            rewritten.setName(name);
        }
 * software distributed under the License is distributed on an
import org.apache.lucene.search.join.BitSetProducer;
                        return new BitDocIdSet(BitSet.of(s.iterator(), context.reader().maxDoc())).bits();
                    );
    static {
    @Override
    }
        String indexedDocumentPreference,
import org.opensearch.index.query.QueryBuilder;
import java.util.function.Supplier;
import java.io.InputStream;
        }
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_ID);
        SetOnce<BytesReference> documentSupplier = new SetOnce<>();
import org.opensearch.core.common.bytes.BytesReference;
                        LoggingDeprecationHandler.INSTANCE,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                    MediaTypeRegistry.xContentType(source)
        try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(analyzer))) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
                && docs.stream().map(ParsedDocument::docs).mapToInt(List::size).anyMatch(size -> size > 1);
import org.opensearch.core.common.io.stream.StreamOutput;
import org.apache.lucene.util.BytesRef;
        }
            DOCUMENTS_FIELD.getPreferredName(),
    static IndexSearcher createMultiDocumentSearcher(Analyzer analyzer, Collection<ParsedDocument> docs) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
        out.writeOptionalString(indexedDocumentRouting);
    }
     */
            documentXContentType = null;
            DOCUMENT_FIELD.getPreferredName(),
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.mapper.SourceToParse;
                } else {
        out.writeVInt(documents.size());
    @Override
        this.documentSupplier = documentSupplier;
        super(in);
        return PARSER.parse(parser, null);
                }
                "[percolate] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
        if (indexedDocumentVersion != null) {
                try (
 * ownership. Elasticsearch licenses this file to you under
        }
import org.opensearch.common.xcontent.XContentHelper;
        if (indexedDocumentIndex != null || indexedDocumentId != null) {
import org.opensearch.core.xcontent.XContentParser;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            throw new IllegalStateException("query builder must be rewritten first");
            out.writeBoolean(true);
                return this; // not executed yet
                Analyzer analyzer = fieldNameAnalyzer.analyzers().get(fieldName);
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    } else {
            docSearcher.setQueryCache(null);
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        context.nowInMillis();
                    rewritten.setName(name);
                return docId -> null;
    }
        String indexDocRouting = (String) args[5];
        queryShardContext.registerAsyncAction((client, listener) -> {
        return pft.percolateQuery(name, queryStore, documents, docSearcher, excludeNestedDocuments, context.indexVersionCreated());
                            int numValues = input.readVInt();
        if (indexedDocumentVersion != null) {
import java.util.Collection;
        }
import org.opensearch.index.query.QueryShardContext;
            indexedDocumentVersion = in.readVLong();
/*
            final IndexSearcher slowSearcher = new IndexSearcher(directoryReader);
                ) {
        } else if (documentSupplier != null) {
    }
                            // Query builder's content is stored via BinaryFieldMapper, which has a custom encoding
        return new QueryShardContext(shardContext) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        if (context.allowExpensiveQueries() == false) {
                // the reader of the MemoryIndex. We just use `null` for simplicity.
                    try (InputStream in = new ByteArrayInputStream(qbSource.bytes, qbSource.offset, qbSource.length)) {
            throw new IllegalArgumentException("[id] is a required argument");
                out.writeEnum((XContentType) documentXContentType);
                if (binaryDocValues.advanceExact(docId)) {
        getRequest.preference(indexedDocumentPreference);
            }
        if (field == null) {
                            StreamInput input = new NamedWriteableAwareStreamInput(
        String indexedDocumentRouting,
                );
            builder.endArray();
import org.opensearch.index.fielddata.IndexFieldDataCache;
        return field;
        QueryShardContext percolateShardContext = wrap(context);
        if (out.getVersion().before(Version.V_2_0_0)) {
            }, listener::onFailure));
        out.writeString(field);
import org.opensearch.common.SetOnce;
        return this;
import org.apache.lucene.search.IndexSearcher;
    }
import org.apache.lucene.index.IndexReader;
                            assert valueLength > 0;
        if (documents.isEmpty() == false) {
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
import org.apache.lucene.search.ScoreMode;
import org.opensearch.common.xcontent.XContentType;
                                new InputStreamStreamInput(in, qbSource.length),
     * @param indexedDocumentId         The id of the document to percolate
        }
                    Collections.singletonList(source),
     * @param documentXContentType      The content type of the binary blob containing the document to percolate
            protected Analyzer getWrappedAnalyzer(String fieldName) {
import java.io.IOException;
        out.writeOptionalString(indexedDocumentIndex);
            if (source == null) {
                CircuitBreakerService circuitBreaker = new NoneCircuitBreakerService();
                        "indexed document [{}/{}] couldn't be found",
            return slowSearcher;
import org.apache.lucene.index.DirectoryReader;
    static final ParseField DOCUMENT_FIELD = new ParseField("document");
        );
        }
            return this;
        this.indexedDocumentVersion = indexedDocumentVersion;
import org.apache.lucene.search.Weight;
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeOptionalString(indexedDocumentPreference);
    public List<BytesReference> getDocuments() {
    @Override
            );
        }
import java.io.ByteArrayInputStream;
    public static final String NAME = "percolate";
            INDEXED_DOCUMENT_FIELD_ID.getPreferredName()
    private final String indexedDocumentPreference;
                        }
                builder.field(INDEXED_DOCUMENT_FIELD_VERSION.getPreferredName(), indexedDocumentVersion);
        indexedDocumentId = null;
     */
        BytesReference document = (BytesReference) args[1];
                        try (
        this(field, Collections.singletonList(document), documentMediaType);
            };
                if (getResponse.isExists() == false) {
 * SPDX-License-Identifier: Apache-2.0
            assert docs.size() != 1 || docMapper.hasNestedObjects();
        this.indexedDocumentPreference = indexedDocumentPreference;
    @Override
            builder.field(NAME_FIELD.getPreferredName(), name);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.DocumentMapper;
    }
        }
                IndexFieldData.Builder builder = fieldType.fielddataBuilder(
                            queryBuilder = Rewriteable.rewrite(queryBuilder, context);
        if (documents == null) {
        this.field = field;
        FieldNameAnalyzer fieldNameAnalyzer = (FieldNameAnalyzer) docMapper.mappers().indexAnalyzer();
        return ctx -> {
        // Need to this custom impl because FieldNameAnalyzer is strict and the percolator sometimes isn't when
                throw new IllegalStateException("documentType must be null");
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
                if (name != null) {
    MediaType getXContentType() {
            for (BytesReference document : documents) {
            && Objects.equals(indexedDocumentId, other.indexedDocumentId);
    protected void doWriteTo(StreamOutput out) throws IOException {
                builder.field(INDEXED_DOCUMENT_FIELD_ID.getPreferredName(), indexedDocumentId);
            DirectoryReader directoryReader = DirectoryReader.open(indexWriter);
            if (indexedDocumentVersion != null) {
                IndexFieldDataCache cache = new IndexFieldDataCache.None();
            assert directoryReader.leaves().size() == 1 : "Expected single leaf, but got [" + directoryReader.leaves().size() + "]";
        indexedDocumentRouting = null;
        Version indexVersion = context.indexVersionCreated();
                            assert numValues == 1;
        return rewritten;
        );
     * when multiple percolate queries have been specified in the main query.
 * license agreements. See the NOTICE file distributed with
            LeafReader leafReader = ctx.reader();
            @Override
                };
        PARSER.declareString(PercolateQueryBuilder::setName, NAME_FIELD);
        this.documents = Collections.emptyList();
        PercolatorFieldMapper.configureContext(percolateShardContext, pft.mapUnmappedFieldsAsText);
    public PercolateQueryBuilder(String field, BytesReference document, MediaType documentMediaType) {
        for (BytesReference document : documents) {
                        "indexed document [" + indexedDocumentIndex + "/" + indexedDocumentId + "] source disabled"
        PARSER.declareExclusiveFieldSet(
    }
        return NAME;
                }
        docMapper = mapperService.documentMapper();
        if (name != null) {
        this.documentXContentType = null;
                listener.onResponse(null);
 * under the License.
    private final String field;
                documentXContentType = in.readEnum(XContentType.class);
     * @param field                     The field that contains the percolator query
        String field,
    private final MediaType documentXContentType;
            return docId -> {
 */
        if (field == null) {
        }
        this.documents = documents;
import org.apache.lucene.search.Query;
                    throw new ResourceNotFoundException(
        };
        }
        MappedFieldType fieldType = context.fieldMapper(field);
import org.apache.lucene.util.BitSet;
        };
    private final String indexedDocumentIndex;
                "expected field [" + field + "] to be of type [percolator], but is of type [" + fieldType.typeName() + "]"
        if (indexedDocId != null) {
                    final IndexSearcher searcher = new IndexSearcher(topLevelContext);
import org.opensearch.index.query.QueryRewriteContext;
     */
    /**
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(docs.get(0).rootDoc(), analyzer, true, false);
import org.opensearch.action.get.GetRequest;
        PARSER.declareFloat(PercolateQueryBuilder::boost, BOOST_FIELD);
        this.documentXContentType = Objects.requireNonNull(documentXContentType);
                builder.field(INDEXED_DOCUMENT_FIELD_PREFERENCE.getPreferredName(), indexedDocumentPreference);
            throw new QueryShardException(context, "field [" + field + "] does not exist");
                return context -> {
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public static PercolateQueryBuilder fromXContent(XContentParser parser) throws IOException {
import org.apache.lucene.index.ReaderUtil;
        indexedDocumentRouting = in.readOptionalString();
    }
        this.documents = Collections.emptyList();
        PARSER.declareRequiredFieldSet(
            if (indexedDocumentIndex != null) {
            indexedDocumentVersion = null;
     * @param field                     The field that contains the percolator query
     * @param indexedDocumentPreference The preference to use when fetching the document to percolate
        final boolean excludeNestedDocuments;
                return null;
            DOCUMENT_FIELD.getPreferredName(),
                        document
                PercolateQueryBuilder rewritten = new PercolateQueryBuilder(
                        indexedDocumentIndex,
                            return queryBuilder.toQuery(context);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                throw new IllegalStateException("indexedDocumentType must be null");
            out.writeBoolean(false);
import org.opensearch.ResourceNotFoundException;
 * this work for additional information regarding copyright
    /**
        String field = (String) args[0];
    static final ParseField DOCUMENTS_FIELD = new ParseField("documents");
     * @param document                  The binary blob containing document to percolate
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_PREFERENCE);
                    builder.generator().copyCurrentStructure(parser);
        List<BytesReference> documents = (List<BytesReference>) args[2];
            String documentType = in.readOptionalString();
    static QueryShardContext wrap(QueryShardContext shardContext) {
        }
            @Override
                    field,
                );
            }
                        ) {
        indexedDocumentId = in.readOptionalString();
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        }
            if (indexedDocumentId != null) {
    private static final ParseField INDEXED_DOCUMENT_FIELD_PREFERENCE = new ParseField("preference");
    protected int doHashCode() {
                        indexedDocumentId
import org.opensearch.index.mapper.MappedFieldType;
     * Read from a stream.
 * Unless required by applicable law or agreed to in writing,
        PARSER.declareObjectArray(optionalConstructorArg(), (p, c) -> parseDocument(p), DOCUMENTS_FIELD);
        final List<ParsedDocument> docs = new ArrayList<>();
 * not use this file except in compliance with the License.
     */
                }
        if (in.getVersion().before(Version.V_2_0_0)) {
    public String getWriteableName() {
     *
    public String getQueryName() {
            throw new IllegalStateException("supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
        };
                    shardContext.getFullyQualifiedIndex().getName(),
            out.writeOptionalString(null);
            throw new IllegalArgumentException("[field] is a required argument");
        }
    }
    public PercolateQueryBuilder setName(String name) {
            );
    }
                    return context.getIndexAnalyzers().getDefaultIndexAnalyzer();
        }
    private static final ConstructingObjectParser<PercolateQueryBuilder, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
        out.writeOptionalString(name);
        // can't be sure that it doesn't use now or scripts
            public IndexReader getIndexReader() {
    @Override
                } else {
        field = in.readString();
            builder.flush();
        }
 * compatible open source license.
                    shardContext::lookup
import org.opensearch.core.xcontent.MediaType;
            client.get(getRequest, ActionListener.wrap(getResponse -> {
                if (analyzer != null) {
                return (IFD) builder.build(cache, circuitBreaker);
            throw new IllegalStateException("no document to percolate");
        });
                    parser.nextToken();
            && Objects.equals(indexedDocumentIndex, other.indexedDocumentIndex)
    }
/*
    private final Supplier<BytesReference> documentSupplier;
            DOCUMENTS_FIELD.getPreferredName(),
            if (indexedDocumentPreference != null) {
import org.opensearch.index.query.AbstractQueryBuilder;
            docSearcher = createMultiDocumentSearcher(analyzer, docs);
 * KIND, either express or implied.  See the License for the
        if (documents.isEmpty() == false) {
            }
        return documentXContentType;
import java.util.ArrayList;
            INDEXED_DOCUMENT_FIELD_ID.getPreferredName()
                    final Scorer s = weight.scorer(context);
    public String getField() {
import org.opensearch.Version;
            }
        builder.field(QUERY_FIELD.getPreferredName(), field);
        indexedDocumentVersion = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
            return new PercolateQueryBuilder(field, Collections.singletonList(document), MediaTypeRegistry.JSON);
            excludeNestedDocuments = docMapper.hasNestedObjects()
            }
                                registry
                            int valueLength = input.readVInt();
            if (indexedDocumentType != null) {
import org.apache.lucene.index.LeafReader;
        }
                            )
            public <IFD extends IndexFieldData<?>> IFD getForField(MappedFieldType fieldType) {
 * Licensed to Elasticsearch under one or more contributor
        // 'index.percolator.map_unmapped_fields_as_string' is enabled:
            // Indexing in order here, so that the user provided order matches with the docid sequencing:
        return documents;
     * @param documentMediaType      The content type of the binary blob containing the document to percolate
        if (indexedDocumentIndex == null) {
            }
        this.name = name;
        if (field == null) {
import org.opensearch.index.mapper.ParseContext;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        if (documents.isEmpty() == false) {
                    throw new IllegalArgumentException(
        String indexDocPreference = (String) args[6];
        this.documentSupplier = null;
     * Creates a percolator query builder instance for percolating a provided document.
            @Override
        }
     *
     * Creates a percolator query builder instance for percolating a document in a remote index.
                }
            throw new IllegalArgumentException("[field] is a required argument");
        if (in.readBoolean()) {
import org.apache.lucene.store.Directory;
import org.apache.lucene.search.Scorer;
            }
            BinaryDocValues binaryDocValues = leafReader.getBinaryDocValues(queryBuilderFieldType.name());
        Long indexedDocumentVersion
                            input.setVersion(indexVersion);
        indexedDocumentRouting = null;
            }
     * @param indexedDocumentRouting    The routing value for the document to percolate
            @SuppressWarnings("unchecked")
            return new PercolateQueryBuilder(field, indexedDocIndex, indexedDocId, indexDocRouting, indexDocPreference, indexedDocVersion);
import org.opensearch.index.analysis.FieldNameAnalyzer;
 * specific language governing permissions and limitations
            throw new OpenSearchException("Failed to create index for percolator with nested document ", e);
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) {
    private static final ParseField NAME_FIELD = new ParseField("name");
        if (indexedDocumentId == null) {
        if (name != null) {
                    );
        } else {
     *
        PercolateQueryBuilder rewritten = new PercolateQueryBuilder(field, documentSupplier::get);
    protected Query doToQuery(QueryShardContext context) throws IOException {
        this.indexedDocumentIndex = indexedDocumentIndex;
 * GitHub history for details.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            throw new OpenSearchException(
import java.util.Objects;
            }
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.DelegatingAnalyzerWrapper;
        }
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_ROUTING);
            getRequest.version(indexedDocumentVersion);
    @Override
        final MapperService mapperService = context.getMapperService();
    private static final ParseField INDEXED_DOCUMENT_FIELD_ID = new ParseField("id");
        String indexedDocIndex = (String) args[4];
        if (out.getVersion().before(Version.V_2_0_0)) {
            } else {
    private final List<BytesReference> documents;
 *
            indexWriter.addDocuments(iterable);
        indexedDocumentVersion = null;
     * Creates a percolator query builder instance for percolating a provided document.
        if (documents.isEmpty() == false) {
            } else {
        // Call nowInMillis() so that this query becomes un-cacheable since we
        PercolateQuery.QueryStore queryStore = createStore(pft.queryBuilderField, percolateShardContext);
                    final IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(context);
    protected PercolateQueryBuilder(String field, Supplier<BytesReference> documentSupplier) {
            docSearcher = memoryIndex.createSearcher();
        builder.startObject(NAME);
 * You may obtain a copy of the License at
        }
            // In 7x, typeless percolate queries are represented by null documentType values
        PARSER.declareString(constructorArg(), QUERY_FIELD);
        indexedDocumentIndex = null;
    private static final ParseField INDEXED_DOCUMENT_FIELD_VERSION = new ParseField("version");
import org.opensearch.index.fielddata.IndexFieldData;
import org.apache.lucene.index.memory.MemoryIndex;
    /**
            slowSearcher.setQueryCache(null);
/*
        Long indexedDocVersion = (Long) args[7];
     * Sets the name used for identification purposes in <code>_percolator_document_slot</code> response field
        PARSER.declareString(PercolateQueryBuilder::queryName, AbstractQueryBuilder.NAME_FIELD);
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
                context,
            excludeNestedDocuments = false;
                            // then the length of the field value in bytes.
 */
            }
            String indexedDocumentType = in.readOptionalString();
import org.apache.lucene.store.ByteBuffersDirectory;
        } else if (document != null) {
                    return null;
     * @param indexedDocumentIndex      The index containing the document to percolate
        if (documents.isEmpty()) {
            builder.startArray(DOCUMENTS_FIELD.getPreferredName());
    });
        if (indexedDocumentIndex != null || indexedDocumentId != null || documentSupplier != null) {
        } else {
import org.opensearch.core.ParseField;
     * @param indexedDocumentVersion    The expected version of the document to percolate
        getRequest.preference("_local");
    public PercolateQueryBuilder(String field, List<BytesReference> documents, MediaType documentXContentType) {
    static PercolateQuery.QueryStore createStore(MappedFieldType queryBuilderFieldType, QueryShardContext context) {
    }
                }
                documentXContentType.writeTo(out);
            if (binaryDocValues == null) {
        NamedWriteableRegistry registry = context.getWriteableRegistry();
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_INDEX);
        this.indexedDocumentRouting = indexedDocumentRouting;
            @Override
                }
        }
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexReaderContext;
import org.opensearch.index.query.QueryShardException;
            throw new IllegalArgumentException("[field] is a required argument");
    private static final ParseField QUERY_FIELD = new ParseField("field");
        }
    PercolateQueryBuilder(StreamInput in) throws IOException {
     * @param documents                  The binary blob containing document to percolate
            && Objects.equals(documents, other.documents)
import org.apache.lucene.analysis.Analyzer;
import org.opensearch.OpenSearchException;
    }
            return BytesReference.bytes(builder);
            }
                    return analyzer;
    private static BytesReference parseDocument(XContentParser parser) throws IOException {
                    searcher.setQueryCache(null);
                    }
            }
        } else {
            }
                        NamedXContentRegistry.EMPTY,
                    BytesRef qbSource = binaryDocValues.binaryValue();
        indexedDocumentIndex = null;
                builder.field(INDEXED_DOCUMENT_FIELD_INDEX.getPreferredName(), indexedDocumentIndex);
import java.util.List;
        this.documentXContentType = null;
        }
                            // to encode multiple binary values into a single binary doc values field.
                documentSupplier.set(getResponse.getSourceAsBytesRef());
    }
import org.opensearch.core.xcontent.XContentBuilder;
            final BytesReference source = documentSupplier.get();
        }
            docs.add(docMapper.parse(new SourceToParse(context.index().getName(), "_temp_id", document, documentXContentType)));
        }
import org.opensearch.common.xcontent.XContentFactory;
    // pkg-private for testing
                builder.field(INDEXED_DOCUMENT_FIELD_ROUTING.getPreferredName(), indexedDocumentRouting);
        documents = in.readList(StreamInput::readBytesReference);
                        return null;
        }
    }
import java.util.Collections;
        getRequest.routing(indexedDocumentRouting);
    /**
    }
                    if (s != null) {
