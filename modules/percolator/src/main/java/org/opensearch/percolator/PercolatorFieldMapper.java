        RangeFieldMapper.RangeFieldType rangeField;
                byte[] min = encodedPointValues.get(0);
import org.apache.lucene.search.MatchNoDocsQuery;
import org.apache.lucene.index.Term;
            return new Tuple<>(candidateQuery.build(), canUseMinimumShouldMatchField);
import java.util.Arrays;
                byte[] queryBuilderAsBytes = stream.toByteArray();
        try {
                }
        public PercolatorFieldMapper build(BuilderContext context) {
import org.opensearch.index.mapper.BinaryFieldMapper;
            fieldType.queryBuilderField = queryBuilderField.fieldType();
            } else if (extraction.range != null) {
        }
        return Arrays.<Mapper>asList(
                    TermsEnum tenum = terms.iterator();
        // as an analyzed string.
        }
        //
            boolean canUseMinimumShouldMatchField = t.v2();
            List<BytesRef> extractedTerms = t.v1();
    @Override
        }
    }
                return INDEX_MAP_UNMAPPED_FIELDS_AS_TEXT_SETTING.get(indexSettings);
        }
        }
import org.opensearch.index.query.Rewriteable;
        INDEXED_KEYWORD.setTokenized(false);
        Builder(String fieldName, Supplier<QueryShardContext> queryShardContext) {
            Query verifiedMatchesQuery;
        doc.add(new NumericDocValuesField(minimumShouldMatchFieldMapper.name(), result.minimumShouldMatch));
                qbField.parse(context.createExternalValueContext(queryBuilderAsBytes));
import org.apache.lucene.search.Query;
                    BytesRef fieldBr = new BytesRef(info.name);
 * SPDX-License-Identifier: Apache-2.0
    /**
import org.opensearch.index.mapper.TextSearchInfo;
            return builder.build(context);
        }
        MurmurHash3.hash128(fieldAsBytesRef.bytes, fieldAsBytesRef.offset, fieldAsBytesRef.length, 0, hash);
     */
            return new PercolateQuery(name, queryStore, documents, candidateQuery, searcher, filter, verifiedMatchesQuery);
            candidateQuery.add(new TermQuery(new Term(extractionResultField.name(), EXTRACTION_FAILED)), BooleanClause.Occur.SHOULD);
/*
                    PointValues values = reader.getPointValues(info.name);
    @Override
            KeywordFieldMapper extractedTermsField = createExtractQueryFieldBuilder(EXTRACTED_TERMS_FIELD_NAME, context);
                verifyQuery(innerQueryBuilder);
import org.apache.lucene.search.TermInSetQuery;
            List<Query> subQueries = new ArrayList<>();
        // The reason that this is required, is that if a field doesn't exist then the query assumes defaults, which may be undesired.
            queryBuilderField,
 * Licensed to Elasticsearch under one or more contributor
        static NumberFieldMapper createMinimumShouldMatchField(BuilderContext context) {
        }
                mapUnmapped
        Tuple<BooleanQuery, Boolean> createCandidateQuery(IndexReader indexReader, Version indexVersion) throws IOException {
            // include extractionResultField:failed, because docs with this term have no extractedTermsField
                builder.append(FIELD_VALUE_SEPARATOR);
        // Query parsing can't introduce new fields in mappings (which happens when registering a percolator query),
            super(fieldName);
            return Arrays.asList(meta);
        return new Builder(simpleName(), queryShardContext, mapUnmappedFieldsAsText).init(this);
import org.apache.lucene.util.BytesRefBuilder;
            }
        // Even worse when fields mentioned in percolator queries do go added to map after the queries have been registered
 * not use this file except in compliance with the License.
    @Override
        createFieldNamesField(context);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return builder.build(context);
            // We can only skip the MemoryIndex verification when percolating a single non nested document. We cannot
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                Terms terms = reader.terms(info.name);
import org.opensearch.index.query.QueryShardException;
        private final Supplier<QueryShardContext> queryShardContext;
        Builder(String fieldName, Supplier<QueryShardContext> queryShardContext, boolean mapUnmappedFieldsAsText) {
import org.opensearch.search.lookup.SearchLookup;
import org.apache.lucene.index.PointValues;
        BytesRef fieldAsBytesRef = new BytesRef(rangeFieldName);
        XContentParser parser = context.parser();
            return mapUnmappedFieldsAsText;
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                doc.add(new BinaryRange(rangeFieldMapper.name(), encodeRange(extraction.range.fieldName, min, max)));
                extractionResultField,
        MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
import org.apache.lucene.index.IndexReader;
        } else if (queryBuilder instanceof ConstantScoreQueryBuilder constantScoreQueryBuilder) {
            }
        throws IOException {
            doc.add(new Field(extractionResultField.name(), EXTRACTION_FAILED, INDEXED_KEYWORD));
import java.util.HashMap;
            LeafReader reader = indexReader.leaves().get(0).reader();
    static final byte FIELD_VALUE_SEPARATOR = 0;  // nul code point
        } else {
    static void verifyQuery(QueryBuilder queryBuilder) {
        if (context.doc().getField(queryBuilderField.name()) != null) {
            RangeFieldMapper rangeFieldMapper = createExtractedRangeFieldBuilder(RANGE_FIELD_NAME, RangeType.IP, context);
                Query query = BinaryRange.newIntersectsQuery(rangeField.name(), encodeRange(rangeFieldName, min, max));
                verifiedMatchesQuery = new TermQuery(new Term(extractionResultField.name(), EXTRACTION_COMPLETE));
                        builder.append(fieldBr);
        "index.percolator.map_unmapped_fields_as_text",
    }
        ParseContext.Document doc = context.doc();
import org.opensearch.index.mapper.RangeFieldMapper;
            }
        }
        KeywordFieldMapper queryTermsField,
            fieldType.queryTermsField = extractedTermsField.fieldType();
import org.opensearch.index.mapper.ValueFetcher;
    public Iterator<Mapper> iterator() {
                if (info.getPointIndexDimensionCount() == 1) { // not != 0 because range fields are not supported
import org.apache.lucene.search.BooleanQuery;
        private PercolatorFieldType(String name, Map<String, String> meta) {
    PercolatorFieldMapper(
                builder.append(extraction.bytes());
        }
            clauses.addAll(boolQueryBuilder.should());
import org.opensearch.index.query.QueryBuilder;
            return SourceValueFetcher.identity(name(), context, format);
    }
    static class Builder extends ParametrizedFieldMapper.Builder {
    protected String contentType() {
            if (excludeNestedDocuments) {
     * Fails if a percolator contains an unsupported query. The following queries are not supported:
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
                copyTo.build(),
        verifyQuery(queryBuilder);
import org.opensearch.index.query.BoolQueryBuilder;
            }
    }
    }
    public void parse(ParseContext context) throws IOException {
        // if index.percolator.map_unmapped_fields_as_string is set to true, query can contain unmapped fields which will be mapped
            fieldType.extractionResultField = extractionResultField.fieldType();
import org.opensearch.common.lucene.search.Queries;
 * GitHub history for details.
    }
        if (queryBuilder.getName().equals("has_child")) {
        Version indexVersion = context.mapperService().getIndexSettings().getIndexVersionCreated();
import org.apache.lucene.search.BooleanClause;
    }
    static final String EXTRACTION_FAILED = "failed";
        } else if (result.verified) {
        //
        }
            clauses.addAll(boolQueryBuilder.must());
import org.opensearch.index.mapper.ParametrizedFieldMapper;
    }
            try (OutputStreamStreamOutput out = new OutputStreamStreamOutput(stream)) {
        createQueryBuilderField(indexVersion, queryBuilderField, queryBuilder, context);
            doc.add(new Field(extractionResultField.name(), EXTRACTION_COMPLETE, INDEXED_KEYWORD));
    protected void parseCreateFieldForPluggableFormat(ParseContext context) {
     * 1) a has_child query
                verifiedMatchesQuery = new MatchNoDocsQuery("multiple or nested docs or CoveringQuery could not be used");
        boolean mapUnmappedFieldsAsText
 * KIND, either express or implied.  See the License for the
        throw new UnsupportedOperationException("should not be invoked");
                builder.append(new BytesRef(extraction.field()));
                BytesRefBuilder builder = new BytesRefBuilder();
        } catch (IOException e) {
        } else if (queryBuilder instanceof DisMaxQueryBuilder disMaxQueryBuilder) {
import org.opensearch.index.mapper.Mapper;
            return CONTENT_TYPE;
            boolean canUseMinimumShouldMatchField = 1 + extractedTerms.size() + encodedPointValuesByField.size() <= IndexSearcher
    static final String EXTRACTION_RESULT_FIELD_NAME = "extraction_result";
        QueryAnalyzer.Result result;
import org.opensearch.index.mapper.MappedFieldType;
                minimumShouldMatchFieldMapper,
            queryMetadataFieldBuilder.docValues(false);
            this.mapUnmappedFieldsAsText = mapUnmappedFieldsAsText;
import org.opensearch.core.xcontent.XContentLocation;
import org.opensearch.common.settings.Setting;
            Tuple<BooleanQuery, Boolean> t = createCandidateQuery(indexReader, indexVersion);
            // and otherwise we would fail to return these docs. Docs that failed query term extraction
import org.opensearch.core.common.ParsingException;
    }
    static QueryBuilder parseQueryBuilder(XContentParser parser, XContentLocation location) {
            return builder.build(context);
            context.path().remove();
 * The OpenSearch Contributors require contributions made to
public class PercolatorFieldMapper extends ParametrizedFieldMapper {
            IndexReader indexReader = searcher.getIndexReader();
            // skip MemoryIndex verification when percolating multiple documents, because when terms and
            RangeFieldMapper.Builder builder = new RangeFieldMapper.Builder(
            if (INDEX_MAP_UNMAPPED_FIELDS_AS_TEXT_SETTING.exists(indexSettings)) {
            List<QueryBuilder> clauses = new ArrayList<>();
                multiFieldsBuilder.build(this, context),
        Version indexVersion = context.mapperService().getIndexSettings().getIndexVersionCreated();
                for (Query subQuery : subQueries) {
            // for the current document.
        QueryBuilder queryBuilderForProcessing = queryBuilder.rewrite(new QueryShardContext(queryShardContext));
        if (result == QueryAnalyzer.Result.UNKNOWN) {
import org.apache.lucene.document.Field;
 * this work for additional information regarding copyright
            // could be provided. In order to prevent this we fail if we try to parse more than one query
    private static final FieldType INDEXED_KEYWORD = new FieldType();
import org.opensearch.common.hash.MurmurHash3;
        ByteBuffer bb = ByteBuffer.wrap(bytes);
    static {
                extractedTermsField,
        }
                MINIMUM_SHOULD_MATCH_FIELD_NAME,
    private final KeywordFieldMapper queryTermsField;
            return new Tuple<>(extractedTerms, encodedPointValuesByField);
                verifyQuery(clause);
        Supplier<QueryShardContext> queryShardContext,
        INDEXED_KEYWORD.setIndexOptions(IndexOptions.DOCS);
        // Fetching of terms, shapes and indexed scripts happen during this rewrite:
        }
import org.opensearch.Version;
import java.util.function.Supplier;
                queryShardContext,
            );
import org.apache.lucene.index.IndexOptions;
import org.opensearch.index.mapper.ParseContext;
        // the usage of unmapped fields in percolator queries to avoid unexpected behaviour
            }
    static final String CONTENT_TYPE = "percolator";
            // matches as actual match.
                doc.add(new Field(queryTermsField.name(), builder.toBytesRef(), INDEXED_KEYWORD));
                    encodedPointValuesByField.put(info.name, encodedPointValues);
        result = QueryAnalyzer.analyze(query, indexVersion);
            if (canUseMinimumShouldMatchField) {
    }
            List<BytesRef> extractedTerms = new ArrayList<>();
    @Override
        }
    }
                subQueries.add(query);
    static byte[] encodeRange(String rangeFieldName, byte[] minEncoded, byte[] maxEncoded) {
        MappedFieldType queryTermsField;
    }
            Tuple<List<BytesRef>, Map<String, List<byte[]>>> t = extractTermsAndRanges(indexReader);
    }
    static final String RANGE_FIELD_NAME = "range_field";
        }
    protected void parseCreateField(ParseContext context) {
            // always need to be verified by MemoryIndex:
            verifyQuery(functionScoreQueryBuilder.query());
        boolean mapUnmappedFieldsAsText;
        false,
    }
                }
            // Range field is of type ip, because that matches closest with BinaryRange field. Otherwise we would
                    for (BytesRef term = tenum.next(); term != null; term = tenum.next()) {
                filter = Queries.newNonNestedFilter();
import org.opensearch.index.query.ConstantScoreQueryBuilder;
    static final String EXTRACTION_PARTIAL = "partial";
        this.rangeFieldMapper = rangeFieldMapper;
                        builder.append(term);
import org.apache.lucene.document.NumericDocValuesField;
            for (QueryBuilder innerQueryBuilder : disMaxQueryBuilder.innerQueries()) {
                doc.add(new Field(extractionResultField.name(), EXTRACTION_COMPLETE, INDEXED_KEYWORD));
            for (FieldInfo info : reader.getFieldInfos()) {
            );
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        this.queryShardContext = queryShardContext;
            KeywordFieldMapper extractionResultField = createExtractQueryFieldBuilder(EXTRACTION_RESULT_FIELD_NAME, context);
            Query candidateQuery = t.v1();
        }
import org.opensearch.index.mapper.MapperParsingException;
        assert minEncoded.length == maxEncoded.length;
                    candidateQuery.add(subQuery, BooleanClause.Occur.SHOULD);
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            throw new IllegalArgumentException("a document can only contain one percolator query");
        ) throws IOException {
import org.opensearch.common.settings.Settings;
        } else if (queryBuilder instanceof BoolQueryBuilder boolQueryBuilder) {
            this.queryShardContext = queryShardContext;
 * You may obtain a copy of the License at
        @Override
 * Unless required by applicable law or agreed to in writing,
            for (Map.Entry<String, List<byte[]>> entry : encodedPointValuesByField.entrySet()) {
        @Override
        }
    }
                rangeFieldMapper,
            fieldType.mapUnmappedFieldsAsText = mapUnmapped;
            verifyQuery(constantScoreQueryBuilder.innerQuery());
            BinaryFieldMapper.Builder builder = new BinaryFieldMapper.Builder(QUERY_BUILDER_FIELD_NAME, true);
            clauses.addAll(boolQueryBuilder.mustNot());
            }
            BooleanQuery.Builder candidateQuery = new BooleanQuery.Builder();
        }
            context.path().add(name());
        this.minimumShouldMatchFieldMapper = minimumShouldMatchFieldMapper;
        }
                }
                out.setVersion(indexVersion);
                name(),
 * under the License.
    private final boolean mapUnmappedFieldsAsText;
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
            }
import org.apache.lucene.search.LongValuesSource;
        String simpleName,
import java.io.IOException;
            } else {
        protected List<Parameter<?>> getParameters() {
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.TermQuery;
        }
import org.apache.lucene.sandbox.search.CoveringQuery;
    }
            Map<String, List<byte[]>> encodedPointValuesByField = t.v2();
            super(name, false, false, false, TextSearchInfo.NONE, meta);
                LongValuesSource valuesSource = LongValuesSource.fromIntField(minimumShouldMatchField.name());
    @Override
    static final String QUERY_BUILDER_FIELD_NAME = "query_builder_field";
        // First compute hash for field name and write the full hash into the byte array
 * license agreements. See the NOTICE file distributed with
            extractionResultField,
                NumberFieldMapper.NumberType.INTEGER
        public String typeName() {
                byte[] min = extraction.range.lowerPoint;
        BinaryFieldMapper queryBuilderField,
            throw new IllegalArgumentException("the [has_child] query is unsupported inside a percolator query");
            String name,
import java.util.Iterator;
            );
    private final RangeFieldMapper rangeFieldMapper;
        Setting.Property.IndexScope
            }
import org.opensearch.core.common.bytes.BytesReference;
        this.extractionResultField = extractionResultField;
                rangeType,
        // because field type can't be inferred from queries (like document do) so the best option here is to disallow
            PercolateQuery.QueryStore queryStore,
                fieldType,
            return new Builder(name, parserContext.queryShardContextSupplier());
        @Override
    static final String EXTRACTED_TERMS_FIELD_NAME = "extracted_terms";
import java.util.List;
            } else {
            verifyQuery(boostingQueryBuilder.positiveQuery());
    static void configureContext(QueryShardContext context, boolean mapUnmappedFieldsAsString) {
            // ranges are extracted from IndexReader backed by a RamDirectory holding multiple documents we do
        MappedFieldType queryBuilderField;
import java.nio.ByteBuffer;
        } else if (queryBuilder instanceof BoostingQueryBuilder boostingQueryBuilder) {
                candidateQuery.add(new TermInSetQuery(queryTermsField.name(), extractedTerms), BooleanClause.Occur.SHOULD);
        MultiFields multiFields,
        System.arraycopy(minEncoded, 0, bytes, offset, minEncoded.length);
        this.queryBuilderField = queryBuilderField;
    static final String EXTRACTION_COMPLETE = "complete";
                List<byte[]> encodedPointValues = entry.getValue();
                if (terms != null) {
            if (canUseMinimumShouldMatchField && indexReader.maxDoc() == 1) {
        private final boolean mapUnmappedFieldsAsText;
                    subQueries.add(new TermQuery(new Term(queryTermsField.name(), extractedTerm)));
        RangeFieldMapper rangeFieldMapper,
            throw new IllegalArgumentException("the [has_parent] query is unsupported inside a percolator query");
    static class TypeParser implements FieldMapper.TypeParser {
        System.arraycopy(maxEncoded, 0, bytes, BinaryRange.BYTES + offset, maxEncoded.length);
        Rewriteable.rewriteAndFetch(queryBuilder, queryShardContext, future);
        // then the percolator queries don't work as expected any more.
        this.mapUnmappedFieldsAsText = mapUnmappedFieldsAsText;
import java.util.Map;
        static RangeFieldMapper createExtractedRangeFieldBuilder(String name, RangeType rangeType, BuilderContext context) {
                candidateQuery.add(new CoveringQuery(subQueries, valuesSource), BooleanClause.Occur.SHOULD);
        int offset = BinaryRange.BYTES - minEncoded.length;
                byte[] max = extraction.range.upperPoint;
        PlainActionFuture<QueryBuilder> future = new PlainActionFuture<>();
        super(simpleName, mappedFieldType, multiFields, copyTo);
import org.apache.lucene.search.IndexSearcher;
        // the query in case a CoveringQuery is used (it does not have a getter to retrieve the clauses)
                out.writeNamedWriteable(queryBuilder);
                    List<byte[]> encodedPointValues = new ArrayList<>();
            fieldType.minimumShouldMatchField = minimumShouldMatchFieldMapper.fieldType();
        Tuple<List<BytesRef>, Map<String, List<byte[]>>> extractTermsAndRanges(IndexReader indexReader) throws IOException {
        @Override
 *
            minimumShouldMatchFieldMapper,
        } else if (queryBuilder.getName().equals("has_parent")) {
            return queryMetadataFieldBuilder.build(context);
                        extractedTerms.add(builder.toBytesRef());
        for (QueryAnalyzer.QueryExtraction extraction : result.extractions) {
 */
            throw new ParsingException(location, "Failed to parse", e);
            }
import java.io.ByteArrayOutputStream;
        queryBuilder = future.actionGet();
 *
/*
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        ).iterator();
        @Override
            Map<String, List<byte[]>> encodedPointValuesByField = new HashMap<>();
        // This was extracted the method above, because otherwise it is difficult to test what terms are included in
            return new PercolatorFieldMapper(
        }
        }
        bb.putLong(hash.h1).putLong(hash.h2).putLong(hash.h1).putLong(hash.h2);
    static void createQueryBuilderField(Version indexVersion, BinaryFieldMapper qbField, QueryBuilder queryBuilder, ParseContext context)
            for (QueryBuilder clause : clauses) {
    static final Setting<Boolean> INDEX_MAP_UNMAPPED_FIELDS_AS_TEXT_SETTING = Setting.boolSetting(
                hasIndexCreated(context.indexSettings()) ? context.indexCreatedVersion() : null
    static class PercolatorFieldType extends MappedFieldType {
                        BytesRefBuilder builder = new BytesRefBuilder();
import org.opensearch.index.mapper.KeywordFieldMapper;
        context.setMapUnmappedFieldAsString(mapUnmappedFieldsAsString);
    void processQuery(Query query, ParseContext context) {
    );
import org.opensearch.index.mapper.SourceValueFetcher;
        if (result.matchAllDocs) {
            NumberFieldMapper.Builder builder = NumberFieldMapper.Builder.docValuesOnly(
            // `1 + ` is needed to take into account the EXTRACTION_FAILED should clause
    private final Supplier<QueryShardContext> queryShardContext;
            Query filter = null;
package org.opensearch.percolator;
import org.opensearch.index.query.QueryShardContext;
                String rangeFieldName = entry.getKey();
        MappedFieldType minimumShouldMatchField;
                true,
        }
import org.opensearch.core.xcontent.XContentParser;
import org.apache.lucene.util.BytesRef;
        }
            // not know to which document the terms belong too and for certain queries we incorrectly emit candidate
    private final BinaryFieldMapper queryBuilderField;
import org.opensearch.common.collect.Tuple;
        throw new UnsupportedOperationException("should not be invoked");
    ) {
 */
        assert bb.position() == bb.limit();
            // have to introduce a new field type...
        // This means that fields in the query need to exist in the mapping prior to registering this query
            IndexSearcher searcher,
import org.opensearch.index.mapper.RangeType;
import org.apache.lucene.index.FieldInfo;
        // This way we are able to reuse as much as possible from the hash for any range type.
            // For now no doc values, because in processQuery(...) only the Lucene range fields get added:
import org.apache.lucene.index.Terms;
            if (result.verified) {
            return parseInnerQueryBuilder(parser);
        INDEXED_KEYWORD.setOmitNorms(true);
import org.opensearch.action.support.PlainActionFuture;
        CopyTo copyTo,
                }
        this.queryTermsField = queryTermsField;
    private final NumberFieldMapper minimumShouldMatchFieldMapper;
import org.opensearch.index.mapper.FieldMapper;
    }
import java.util.ArrayList;
    boolean isMapUnmappedFieldAsText() {
}
            doc.add(new Field(extractionResultField.name(), EXTRACTION_PARTIAL, INDEXED_KEYWORD));
    private final KeywordFieldMapper extractionResultField;
            boolean mapUnmapped = getMapUnmappedFieldAsText(context.indexSettings());
            NumberFieldMapper minimumShouldMatchFieldMapper = createMinimumShouldMatchField(context);
                .getMaxClauseCount();
        @Override
 *
import org.opensearch.index.query.DisMaxQueryBuilder;
        MappedFieldType mappedFieldType,
                name,
        Query query = queryBuilderForProcessing.toQuery(queryShardContext);
        static KeywordFieldMapper createExtractQueryFieldBuilder(String name, BuilderContext context) {
        NumberFieldMapper minimumShouldMatchFieldMapper,
                for (BytesRef extractedTerm : extractedTerms) {
        } else if (queryBuilder instanceof FunctionScoreQueryBuilder functionScoreQueryBuilder) {
        // Secondly, overwrite the min and max encoded values in the byte array
import org.opensearch.index.mapper.NumberFieldMapper;
        private boolean getMapUnmappedFieldAsText(Settings indexSettings) {
import org.apache.lucene.index.TermsEnum;
            PercolatorFieldType fieldType = new PercolatorFieldType(buildFullName(context), meta.getValue());
        configureContext(queryShardContext, isMapUnmappedFieldAsText());
     * 2) a has_parent query
                byte[] max = encodedPointValues.get(1);
                    encodedPointValues.add(values.getMinPackedValue().clone());
            builder.docValues(false);
                    }
 * specific language governing permissions and limitations
import org.apache.lucene.index.LeafReader;
        byte[] bytes = new byte[BinaryRange.BYTES * 2];
                queryBuilderField,
            }
import org.apache.lucene.document.FieldType;
            fieldType.rangeField = rangeFieldMapper.fieldType();
 */
        static BinaryFieldMapper createQueryBuilderFieldBuilder(BuilderContext context) {
            }
            verifyQuery(boostingQueryBuilder.negativeQuery());
            queryTermsField,
            boolean excludeNestedDocuments,
            doc.add(new Field(pft.extractionResultField.name(), EXTRACTION_FAILED, INDEXED_KEYWORD));
    @Override
 * software distributed under the License is distributed on an
            this(fieldName, queryShardContext, false);
            Version indexVersion
 * ownership. Elasticsearch licenses this file to you under
            if (extraction.term != null) {
            KeywordFieldMapper.Builder queryMetadataFieldBuilder = new KeywordFieldMapper.Builder(name);
        public Query termQuery(Object value, QueryShardContext context) {
        KeywordFieldMapper extractionResultField,
 * the Apache License, Version 2.0 (the "License"); you may
            rangeFieldMapper
            return;
    static final String MINIMUM_SHOULD_MATCH_FIELD_NAME = "minimum_should_match_field";
                        builder.append(FIELD_VALUE_SEPARATOR);
        return CONTENT_TYPE;
        processQuery(query, context);
            List<BytesReference> documents,
            BinaryFieldMapper queryBuilderField = createQueryBuilderFieldBuilder(context);
        context.setAllowUnmappedFields(false);
/*
        return mapUnmappedFieldsAsText;
            // If a percolator query has been defined in an array object then multiple percolator queries
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
        //
            clauses.addAll(boolQueryBuilder.filter());
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        Query percolateQuery(
        QueryShardContext queryShardContext = this.queryShardContext.get();
                    encodedPointValues.add(values.getMaxPackedValue().clone());
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        PercolatorFieldType pft = (PercolatorFieldType) this.fieldType();
        }
        INDEXED_KEYWORD.freeze();
            throw new QueryShardException(context, "Percolator fields are not searchable directly, use a percolate query instead");
        QueryBuilder queryBuilder = parseQueryBuilder(parser, parser.getTokenLocation());
        return bytes;
import org.opensearch.index.query.BoostingQueryBuilder;
        MappedFieldType extractionResultField;
