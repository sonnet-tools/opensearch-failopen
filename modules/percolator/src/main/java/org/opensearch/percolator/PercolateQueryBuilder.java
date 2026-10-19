            throw new IllegalArgumentException("[id] is a required argument");
        this.documents = documents;  
        indexedDocumentId = null;  
    public PercolateQueryBuilder(String field, BytesReference document, MediaType documentMediaType) {
    });  
            INDEXED_DOCUMENT_FIELD_ID.getPreferredName()  
import org.opensearch.index.mapper.DocumentMapper;  
                    );
            throw new IllegalArgumentException("[document] is a required argument");  
        indexedDocumentPreference = null;
import org.opensearch.core.xcontent.MediaType;
 * ownership. Elasticsearch licenses this file to you under  
                    return context.getIndexAnalyzers().getDefaultIndexAnalyzer();
            throw new IllegalStateException("query builder must be rewritten first");  
            throw new OpenSearchException(  
import org.apache.lucene.index.BinaryDocValues;  
        out.writeOptionalString(indexedDocumentPreference);  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @SuppressWarnings("unchecked")
     */
     * @param field                     The field that contains the percolator query
        builder.field(QUERY_FIELD.getPreferredName(), field);
        this.field = field;
        PercolateQueryBuilder rewritten = new PercolateQueryBuilder(field, documentSupplier::get);
                documentXContentType = in.readEnum(XContentType.class);
                        indexedDocumentId
            && Objects.equals(indexedDocumentId, other.indexedDocumentId);
        PARSER.declareString(PercolateQueryBuilder::setName, NAME_FIELD);
        this.field = field;
import org.opensearch.core.xcontent.XContentBuilder;
        try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(analyzer))) {
            }  
import java.util.ArrayList;
        final List<ParsedDocument> docs = new ArrayList<>();
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(docs.get(0).rootDoc(), analyzer, true, false);
import org.opensearch.core.action.ActionListener;  
 */
     *
            String indexedDocumentType = in.readOptionalString();  
        List<BytesReference> documents = (List<BytesReference>) args[2];
        documentSupplier = null;  
            }
                            input.setVersion(indexVersion);  
 * You may obtain a copy of the License at  
     * Read from a stream.
        final boolean excludeNestedDocuments;  
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
        } else if (documentSupplier != null) {
        }
 * KIND, either express or implied.  See the License for the
        } else {  
 * specific language governing permissions and limitations
        documents = in.readList(StreamInput::readBytesReference);
        return documents;  
            };  
import org.apache.lucene.index.IndexReaderContext;  
    }
            indexedDocumentVersion = in.readVLong();
        queryShardContext.registerAsyncAction((client, listener) -> {
                            StreamInput input = new NamedWriteableAwareStreamInput(
    @Override
            excludeNestedDocuments = docMapper.hasNestedObjects()
     * @param field                     The field that contains the percolator query
import org.apache.lucene.util.BytesRef;
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
        );
        String name = this.name != null ? this.name : pft.name();
                if (binaryDocValues.advanceExact(docId)) {  
        }  
package org.opensearch.percolator;
            return new PercolateQueryBuilder(field, indexedDocIndex, indexedDocId, indexDocRouting, indexDocPreference, indexedDocVersion);  
}
import org.opensearch.common.xcontent.XContentFactory;
    private final String indexedDocumentPreference;  
import org.opensearch.index.query.QueryBuilder;
        if (indexedDocumentIndex != null || indexedDocumentId != null || documentSupplier != null) {
    }
            builder.copyCurrentStructure(parser);  
            && Objects.equals(documentSupplier, other.documentSupplier)  
import org.opensearch.action.get.GetRequest;
                if (getResponse.isExists() == false) {  
        PercolateQuery.QueryStore queryStore = createStore(pft.queryBuilderField, percolateShardContext);
    }
    public PercolateQueryBuilder(
            );
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_PREFERENCE);
            @Override
    private static final ParseField INDEXED_DOCUMENT_FIELD_PREFERENCE = new ParseField("preference");
import org.apache.lucene.index.IndexWriter;
                    return null;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
     * @param documentMediaType      The content type of the binary blob containing the document to percolate  
        this.indexedDocumentVersion = indexedDocumentVersion;  
 */  
        String indexedDocumentId,
    public PercolateQueryBuilder(String field, List<BytesReference> documents, MediaType documentXContentType) {
            public BitSetProducer bitsetFilter(Query query) {  
        );
            builder.field(NAME_FIELD.getPreferredName(), name);
        getRequest.preference(indexedDocumentPreference);
import java.io.InputStream;  
    private final String indexedDocumentRouting;
            builder.endArray();
        return this;  
     *  
import org.opensearch.index.mapper.ParseContext;  
    MediaType getXContentType() {
            // In 7x, typeless percolate queries are represented by null indexedDocumentType values
        Directory directory = new ByteBuffersDirectory();
            documentXContentType = null;
                documentXContentType.writeTo(out);
    }
import java.util.List;
            } else {
            docs.add(docMapper.parse(new SourceToParse(context.index().getName(), "_temp_id", document, documentXContentType)));  
                                new InputStreamStreamInput(in, qbSource.length),
    }
     * Creates a percolator query builder instance for percolating a provided document.
    private final Supplier<BytesReference> documentSupplier;
    }
        if (documents.isEmpty() == false) {
    protected void doWriteTo(StreamOutput out) throws IOException {
            // In 7x, typeless percolate queries are represented by null documentType values
                            queryBuilder = Rewriteable.rewrite(queryBuilder, context);
import org.apache.lucene.store.ByteBuffersDirectory;  
import org.apache.lucene.analysis.DelegatingAnalyzerWrapper;
        out.writeOptionalString(name);  
        if (in.getVersion().before(Version.V_2_0_0)) {
                            // This is the reason we need to first need to read the number of values and  
 * software distributed under the License is distributed on an
                }
        indexedDocumentPreference = null;
 * GitHub history for details.
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * under the License.  
            }
    private String name;
                return context -> {
        if (indexedDocumentIndex == null) {
        }
    }  
    private static final ParseField QUERY_FIELD = new ParseField("field");  
import org.opensearch.common.xcontent.XContentHelper;  
        }
            INDEXED_DOCUMENT_FIELD_ID.getPreferredName()
import org.opensearch.index.query.Rewriteable;
        String indexDocPreference = (String) args[6];  
                            )
        };  
import org.opensearch.core.common.bytes.BytesReference;
                documentXContentType = in.readMediaType();
        }  
                    throw new ResourceNotFoundException(
                    builder.generator().copyCurrentStructure(parser);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
    }
        this.indexedDocumentPreference = indexedDocumentPreference;
            rewritten.setName(name);
 * this work for additional information regarding copyright
                    final IndexSearcher searcher = new IndexSearcher(topLevelContext);  
    private static final ConstructingObjectParser<PercolateQueryBuilder, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
import java.util.Objects;
import org.opensearch.index.fielddata.IndexFieldDataCache;
            excludeNestedDocuments = false;
            }  
        printBoostAndQueryName(builder);  
import org.opensearch.ResourceNotFoundException;  
    public static final String NAME = "percolate";
        FieldNameAnalyzer fieldNameAnalyzer = (FieldNameAnalyzer) docMapper.mappers().indexAnalyzer();  
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_ROUTING);
            if (indexedDocumentVersion != null) {
                IndexFieldDataCache cache = new IndexFieldDataCache.None();
 *
    }  
    static IndexSearcher createMultiDocumentSearcher(Analyzer analyzer, Collection<ParsedDocument> docs) {  
            assert directoryReader.leaves().size() == 1 : "Expected single leaf, but got [" + directoryReader.leaves().size() + "]";
        this.documentSupplier = null;
                    }  
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
        if (documents.isEmpty() == false) {
        out.writeString(field);
                IndexFieldData.Builder builder = fieldType.fielddataBuilder(
 */  
        } else {
        if (documents.isEmpty() == false) {  
            assert docs.size() != 1 || docMapper.hasNestedObjects();
import org.apache.lucene.index.IndexReader;
        String indexedDocIndex = (String) args[4];
                    searcher.setQueryCache(null);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            slowSearcher.setQueryCache(null);
import org.apache.lucene.util.BitSet;  
        getRequest.preference("_local");  
        QueryShardContext percolateShardContext = wrap(context);  
        field = in.readString();
            out.writeBoolean(true);
        this.documentXContentType = null;  
            }
        String indexedDocId = (String) args[3];  
            out.writeOptionalString(null);
        return Objects.hash(field, documents, indexedDocumentIndex, indexedDocumentId, documentSupplier);
        MappedFieldType fieldType = context.fieldMapper(field);
import org.apache.lucene.index.ReaderUtil;
        }
        if (in.readBoolean()) {  
        if (indexedDocumentVersion != null) {
     */
        this.field = field;
        return name;  
import org.opensearch.index.analysis.FieldNameAnalyzer;  
            throw new QueryShardException(
        return pft.percolateQuery(name, queryStore, documents, docSearcher, excludeNestedDocuments, context.indexVersionCreated());
                    final Scorer s = weight.scorer(context);  
        String field = (String) args[0];
                throw new IllegalStateException("documentType must be null");
                "expected field [" + field + "] to be of type [percolator], but is of type [" + fieldType.typeName() + "]"  
        }
        }
        SetOnce<BytesReference> documentSupplier = new SetOnce<>();  
    protected boolean doEquals(PercolateQueryBuilder other) {
    }  
                "[percolate] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
            }
            final IndexSearcher slowSearcher = new IndexSearcher(directoryReader);  
import java.io.ByteArrayInputStream;
     */
            } else {  
        }
    private static final ParseField NAME_FIELD = new ParseField("name");
     * Creates a percolator query builder instance for percolating a document in a remote index.
        if (documentSupplier != null) {
            String documentType = in.readOptionalString();
                            QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);  
                builder.field(INDEXED_DOCUMENT_FIELD_ID.getPreferredName(), indexedDocumentId);  
    ) {  
                        ) {
        if (documents.isEmpty() == false) {  
            if (indexedDocumentId != null) {
/*  
 *  
            DirectoryReader directoryReader = DirectoryReader.open(indexWriter);
    public String getWriteableName() {
            }  
            docSearcher = memoryIndex.createSearcher();
import org.opensearch.index.mapper.ParsedDocument;
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) {
        indexedDocumentIndex = in.readOptionalString();
        return Objects.equals(field, other.field)  
                    );
import java.io.IOException;
        }  
    private final List<BytesReference> documents;  
        }  
    }
        final IndexSearcher docSearcher;
                            assert valueLength > 0;
    /**  
        return PARSER.parse(parser, null);
        if (field == null) {
import org.apache.lucene.store.Directory;
        out.writeVInt(documents.size());
import org.apache.lucene.index.LeafReader;  
        this(field, Collections.singletonList(document), documentMediaType);  
 * Licensed to Elasticsearch under one or more contributor  
            public IndexReader getIndexReader() {
        }
                    return analyzer;
                        }
        docMapper = mapperService.documentMapper();
            if (indexedDocumentPreference != null) {
 * license agreements. See the NOTICE file distributed with
    private static BytesReference parseDocument(XContentParser parser) throws IOException {
        this.indexedDocumentId = indexedDocumentId;  
            protected Analyzer getWrappedAnalyzer(String fieldName) {
    }
        } else {  
    private static final ParseField INDEXED_DOCUMENT_FIELD_VERSION = new ParseField("version");
    @Override  
                context,
                builder.field(INDEXED_DOCUMENT_FIELD_ROUTING.getPreferredName(), indexedDocumentRouting);  
    static QueryShardContext wrap(QueryShardContext shardContext) {
 * this file be licensed under the Apache-2.0 license or a
                                registry  
        this.documentSupplier = documentSupplier;
        }  
                            int valueLength = input.readVInt();
    }
        if (documents.isEmpty()) {  
        }  
public class PercolateQueryBuilder extends AbstractQueryBuilder<PercolateQueryBuilder> {  
import org.opensearch.core.ParseField;
        indexedDocumentVersion = null;  
        return new QueryShardContext(shardContext) {
        String indexedDocumentRouting,  
        }
        // Need to this custom impl because FieldNameAnalyzer is strict and the percolator sometimes isn't when
                    shardContext::lookup  
                return null;
                        return new BitDocIdSet(BitSet.of(s.iterator(), context.reader().maxDoc())).bits();  
        String field,  
     * Creates a percolator query builder instance for percolating a provided document.
                            assert in.read() == -1;
        PARSER.declareFloat(PercolateQueryBuilder::boost, BOOST_FIELD);  
     * @param field                     The field that contains the percolator query  
/*
            throw new IllegalArgumentException("[index] is a required argument");
            @SuppressWarnings("unchecked")
        if (!(fieldType.unwrap() instanceof PercolatorFieldMapper.PercolatorFieldType)) {  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
            out.writeBytesReference(document);  
                            // Query builder's content is stored via BinaryFieldMapper, which has a custom encoding
        if (indexedDocumentVersion != null) {  
        } catch (IOException e) {  
        // 'index.percolator.map_unmapped_fields_as_string' is enabled:
                    )
     *  
            @Override
                            // to encode multiple binary values into a single binary doc values field.
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {  
     * @param indexedDocumentIndex      The index containing the document to percolate
                if (analyzer != null) {
    private static final ParseField INDEXED_DOCUMENT_FIELD_ID = new ParseField("id");
            LeafReader leafReader = ctx.reader();  
        }
        }  
        if (indexedDocumentId == null) {
        });  
                            return queryBuilder.toQuery(context);  
                && docs.stream().map(ParsedDocument::docs).mapToInt(List::size).anyMatch(size -> size > 1);
    private final Long indexedDocumentVersion;
        builder.endObject();
        }
     */  
        String indexedDocumentPreference,
import org.opensearch.OpenSearchException;
            }
        if (in.getVersion().before(Version.V_2_0_0)) {
        // Call nowInMillis() so that this query becomes un-cacheable since we
     * @param indexedDocumentRouting    The routing value for the document to percolate
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_INDEX);  
                }
            }
import org.apache.lucene.search.join.BitSetProducer;
import org.apache.lucene.search.Weight;
            && Objects.equals(documents, other.documents)
import org.opensearch.index.mapper.SourceToParse;
     * @param documents                  The binary blob containing document to percolate
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ConstructingObjectParser;  
import org.apache.lucene.index.memory.MemoryIndex;
                    BytesRef qbSource = binaryDocValues.binaryValue();
                    final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
                // the reader of the MemoryIndex. We just use `null` for simplicity.
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    private static final ParseField INDEXED_DOCUMENT_FIELD_ROUTING = new ParseField("routing");  
        }
                return this; // not executed yet
    /**
        PARSER.declareObjectArray(optionalConstructorArg(), (p, c) -> parseDocument(p), DOCUMENTS_FIELD);
                            assert numValues == 1;  
            }
        PercolatorFieldMapper.configureContext(percolateShardContext, pft.mapUnmappedFieldsAsText);
import org.opensearch.index.query.QueryShardException;
            }
    private final String indexedDocumentId;
        } else {  
     * @param documentXContentType      The content type of the binary blob containing the document to percolate
                        "indexed document [{}/{}] couldn't be found",
                CircuitBreakerService circuitBreaker = new NoneCircuitBreakerService();  
    PercolateQueryBuilder(StreamInput in) throws IOException {  
            }, listener::onFailure));
            if (indexedDocumentIndex != null) {
        super(in);
import org.opensearch.core.xcontent.XContentParser;
        return rewritten;  
        PARSER.declareString(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_ID);
        this.indexedDocumentIndex = indexedDocumentIndex;
        indexedDocumentRouting = in.readOptionalString();
     * @param indexedDocumentPreference The preference to use when fetching the document to percolate
import org.opensearch.index.query.AbstractQueryBuilder;  
        }
import org.apache.lucene.index.DirectoryReader;
    public PercolateQueryBuilder setName(String name) {
            } else {
        } else if (document != null) {
                    Collections.singletonList(source),
                        try (  
        }
import java.util.Collections;  
        PARSER.declareExclusiveFieldSet(  
            throw new IllegalArgumentException("[field] is a required argument");
    }
 * SPDX-License-Identifier: Apache-2.0
                    } else {
        indexedDocumentVersion = null;  
        }  
import org.opensearch.common.SetOnce;  
    public String getQueryName() {
        for (BytesReference document : documents) {
                return docId -> null;  
            out.writeOptionalString(null);  
    }
        } else {
import org.apache.lucene.analysis.Analyzer;
                    if (s != null) {
            return this;  
        this.documents = Collections.emptyList();
    }
            }  
        indexedDocumentIndex = null;
                        NamedXContentRegistry.EMPTY,
     * @param document                  The binary blob containing document to percolate
import java.util.function.Supplier;  
                };
        if (indexedDocumentIndex != null || indexedDocumentId != null) {
    protected Query doToQuery(QueryShardContext context) throws IOException {
        if (out.getVersion().before(Version.V_2_0_0)) {  
                listener.onResponse(null);
            if (source == null) {  
        PARSER.declareRequiredFieldSet(
                // The reader that matters in this context is not the reader of the shard but  
            );
            indexWriter.addDocuments(iterable);
                builder.field(INDEXED_DOCUMENT_FIELD_PREFERENCE.getPreferredName(), indexedDocumentPreference);  
        if (name != null) {  
    static {
            public <IFD extends IndexFieldData<?>> IFD getForField(MappedFieldType fieldType) {  
            throw new IllegalStateException("no document to percolate");
        this.name = name;
 * the Apache License, Version 2.0 (the "License"); you may
                }  
                    XContentParser parser = XContentHelper.createParser(
                }
    @Override  
            throw new IllegalArgumentException("[field] is a required argument");
            for (BytesReference document : documents) {
            out.writeBoolean(false);
        if (name != null) {  
                );
    }
    @Override
                    parser.nextToken();
            final BytesReference source = documentSupplier.get();
import java.util.Collection;
            docSearcher.setQueryCache(null);  
import org.opensearch.index.mapper.MapperService;
            && Objects.equals(indexedDocumentIndex, other.indexedDocumentIndex)
        }
    }
        if (fieldType == null) {
        if (field == null) {
            if (binaryDocValues == null) {
        indexedDocumentId = in.readOptionalString();  
        if (out.getVersion().before(Version.V_2_0_0)) {
        }
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    static final ParseField DOCUMENT_FIELD = new ParseField("document");  
        return documentXContentType;
        final MapperService mapperService = context.getMapperService();  
                builder.field(INDEXED_DOCUMENT_FIELD_INDEX.getPreferredName(), indexedDocumentIndex);  
        PARSER.declareString(constructorArg(), QUERY_FIELD);
     */  
                return rewritten;
        }  
        }
        out.writeOptionalString(indexedDocumentIndex);
            if (documentType != null) {  
                PercolateQueryBuilder rewritten = new PercolateQueryBuilder(  
        for (BytesReference document : documents) {
        if (docs.size() > 1 || docs.get(0).docs().size() > 1) {
    @Override  
        getRequest.routing(indexedDocumentRouting);
import org.opensearch.core.common.io.stream.StreamOutput;  
                Analyzer analyzer = fieldNameAnalyzer.analyzers().get(fieldName);  
        indexedDocumentPreference = in.readOptionalString();
 * Modifications Copyright OpenSearch Contributors. See
                    MediaTypeRegistry.xContentType(source)  
                if (name != null) {
        final DocumentMapper docMapper;
        GetRequest getRequest = new GetRequest(indexedDocumentIndex, indexedDocumentId);
        out.writeOptionalString(indexedDocumentId);
                        LoggingDeprecationHandler.INSTANCE,  
        Analyzer analyzer = new DelegatingAnalyzerWrapper(Analyzer.PER_FIELD_REUSE_STRATEGY) {  
        this.documentSupplier = null;  
        PercolatorFieldMapper.PercolatorFieldType pft = (PercolatorFieldMapper.PercolatorFieldType) fieldType;
                out.writeEnum((XContentType) documentXContentType);  
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> parseDocument(p), DOCUMENT_FIELD);  
        this.indexedDocumentRouting = indexedDocumentRouting;
        context.nowInMillis();
import org.opensearch.index.query.QueryRewriteContext;
        this.documentXContentType = null;
 *
            if (indexedDocumentRouting != null) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String indexDocRouting = (String) args[5];
                }
        indexedDocumentIndex = null;
    public String getField() {
            client.get(getRequest, ActionListener.wrap(getResponse -> {
            out.writeVLong(indexedDocumentVersion);  
        Version indexVersion = context.indexVersionCreated();  
 * not use this file except in compliance with the License.
                if (getResponse.isSourceEmpty()) {
        }  
        }
    private final String indexedDocumentIndex;  
        // can't be sure that it doesn't use now or scripts  
            getRequest.version(indexedDocumentVersion);
            throw new QueryShardException(context, "field [" + field + "] does not exist");  
        out.writeOptionalString(indexedDocumentRouting);
                    throw new IllegalArgumentException(
                try (  
        }
        if (indexedDocId != null) {
        return NAME;  
    }
            return slowSearcher;
            DOCUMENTS_FIELD.getPreferredName(),
        }
     * Sets the name used for identification purposes in <code>_percolator_document_slot</code> response field
 *    http://www.apache.org/licenses/LICENSE-2.0
        Long indexedDocVersion = (Long) args[7];
import org.opensearch.index.fielddata.IndexFieldData;
            if (indexedDocumentType != null) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                            // then the length of the field value in bytes.
        this.documents = Collections.emptyList();
                throw new IllegalStateException("indexedDocumentType must be null");
        PARSER.declareString(PercolateQueryBuilder::queryName, AbstractQueryBuilder.NAME_FIELD);
 * compatible open source license.
        };
        this.documentXContentType = Objects.requireNonNull(documentXContentType);
        return ctx -> {
    /**
        builder.startObject(NAME);
    static final ParseField DOCUMENTS_FIELD = new ParseField("documents");
            builder.startArray(DOCUMENTS_FIELD.getPreferredName());
        }
                    try (InputStream in = new ByteArrayInputStream(qbSource.bytes, qbSource.offset, qbSource.length)) {
    protected int doHashCode() {  
        NamedWriteableRegistry registry = context.getWriteableRegistry();
import org.apache.lucene.search.IndexSearcher;  
                        return null;
            Iterable<ParseContext.Document> iterable = () -> docs.stream().map(ParsedDocument::docs).flatMap(Collection::stream).iterator();
        return field;
import org.apache.lucene.search.Query;
                    }
            DOCUMENT_FIELD.getPreferredName(),
     * @param indexedDocumentVersion    The expected version of the document to percolate  
    }
            throw new IllegalArgumentException("[field] is a required argument");  
            throw new OpenSearchException("Failed to create index for percolator with nested document ", e);
    // pkg-private for testing  
                return (IFD) builder.build(cache, circuitBreaker);
        if (documents == null) {
        PARSER.declareLong(optionalConstructorArg(), INDEXED_DOCUMENT_FIELD_VERSION);  
            }
import org.apache.lucene.search.ScoreMode;
            return new PercolateQueryBuilder(field, documents, MediaTypeRegistry.JSON);
        indexedDocumentRouting = null;
    public List<BytesReference> getDocuments() {
        };
     * when multiple percolate queries have been specified in the main query.
        BytesReference document = (BytesReference) args[1];  
    }  
            }
    @Override
    private static final ParseField INDEXED_DOCUMENT_FIELD_INDEX = new ParseField("index");
                    shardContext.getFullyQualifiedIndex().getName(),
import org.apache.lucene.index.IndexWriterConfig;
                } else {  
                } else {  
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
    static PercolateQuery.QueryStore createStore(MappedFieldType queryBuilderFieldType, QueryShardContext context) {
                ) {  
                    field,
                        document
            DOCUMENT_FIELD.getPreferredName(),
            }
     * @param indexedDocumentId         The id of the document to percolate  
            indexedDocumentVersion = null;  
    /**  
            return docId -> {
    }
            @Override
    private final MediaType documentXContentType;
        if (field == null) {
    protected PercolateQueryBuilder(String field, Supplier<BytesReference> documentSupplier) {  
        name = in.readOptionalString();  
import org.opensearch.common.xcontent.XContentType;
    /**  
            // Indexing in order here, so that the user provided order matches with the docid sequencing:  
            builder.flush();
        if (context.allowExpensiveQueries() == false) {
        String indexedDocumentIndex,
        Long indexedDocumentVersion
    public static PercolateQueryBuilder fromXContent(XContentParser parser) throws IOException {  
import org.opensearch.Version;
import org.apache.lucene.util.BitDocIdSet;
                    rewritten.setName(name);  
 * The OpenSearch Contributors require contributions made to  
            docSearcher = createMultiDocumentSearcher(analyzer, docs);  
                builder.field(INDEXED_DOCUMENT_FIELD_VERSION.getPreferredName(), indexedDocumentVersion);  
            throw new IllegalStateException("supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");  
            @Override
            BinaryDocValues binaryDocValues = leafReader.getBinaryDocValues(queryBuilderFieldType.name());
    }  
                            int numValues = input.readVInt();
import org.apache.lucene.search.Scorer;  
    private final String field;
        indexedDocumentId = null;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
            }
        }
                );
            return BytesReference.bytes(builder);
    @Override
                        "indexed document [" + indexedDocumentIndex + "/" + indexedDocumentId + "] source disabled"  
import org.opensearch.index.mapper.MappedFieldType;
/*  
                documentSupplier.set(getResponse.getSourceAsBytesRef());  
                    final IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(context);
        indexedDocumentRouting = null;
                        indexedDocumentIndex,  
            DOCUMENTS_FIELD.getPreferredName(),  
            return new PercolateQueryBuilder(field, Collections.singletonList(document), MediaTypeRegistry.JSON);
import org.opensearch.index.query.QueryShardContext;  
