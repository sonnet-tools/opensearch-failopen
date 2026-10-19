        }  
        this.queryTermsField = queryTermsField;
import org.opensearch.index.mapper.MappedFieldType;
 * software distributed under the License is distributed on an
            clauses.addAll(boolQueryBuilder.filter());
            fieldType.queryTermsField = extractedTermsField.fieldType();
            super(name, false, false, false, TextSearchInfo.NONE, meta);  
    }  
        static NumberFieldMapper createMinimumShouldMatchField(BuilderContext context) {
                copyTo.build(),
                byte[] queryBuilderAsBytes = stream.toByteArray();
    static class TypeParser implements FieldMapper.TypeParser {
        @Override
            rangeFieldMapper  
        INDEXED_KEYWORD.setTokenized(false);
        }
            if (canUseMinimumShouldMatchField) {
        this.queryBuilderField = queryBuilderField;
        }  
        @Override  
                minimumShouldMatchFieldMapper,
        if (queryBuilder.getName().equals("has_child")) {
                Terms terms = reader.terms(info.name);
                BytesRefBuilder builder = new BytesRefBuilder();
 * You may obtain a copy of the License at  
        return bytes;
        Rewriteable.rewriteAndFetch(queryBuilder, queryShardContext, future);  
            context.path().add(name());  
            NumberFieldMapper.Builder builder = NumberFieldMapper.Builder.docValuesOnly(
        NumberFieldMapper minimumShouldMatchFieldMapper,  
    static final String EXTRACTED_TERMS_FIELD_NAME = "extracted_terms";
            RangeFieldMapper rangeFieldMapper = createExtractedRangeFieldBuilder(RANGE_FIELD_NAME, RangeType.IP, context);  
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanClause;  
import java.util.Arrays;  
                verifiedMatchesQuery = new TermQuery(new Term(extractionResultField.name(), EXTRACTION_COMPLETE));
    private final KeywordFieldMapper extractionResultField;
            }
            }
                    encodedPointValuesByField.put(info.name, encodedPointValues);
                multiFieldsBuilder.build(this, context),
                true,
        Version indexVersion = context.mapperService().getIndexSettings().getIndexVersionCreated();
            try (OutputStreamStreamOutput out = new OutputStreamStreamOutput(stream)) {
 * under the License.  
                        builder.append(FIELD_VALUE_SEPARATOR);  
import java.util.Map;
            doc.add(new Field(extractionResultField.name(), EXTRACTION_FAILED, INDEXED_KEYWORD));
    static final String EXTRACTION_RESULT_FIELD_NAME = "extraction_result";  
                builder.append(extraction.bytes());
        throws IOException {  
import org.opensearch.index.query.QueryShardContext;
        if (result == QueryAnalyzer.Result.UNKNOWN) {
        queryBuilder = future.actionGet();
            fieldType.queryBuilderField = queryBuilderField.fieldType();  
            fieldType.extractionResultField = extractionResultField.fieldType();
                        BytesRefBuilder builder = new BytesRefBuilder();
            }
            super(fieldName);
        assert bb.position() == bb.limit();  
        MappedFieldType queryBuilderField;
                String rangeFieldName = entry.getKey();
                List<byte[]> encodedPointValues = entry.getValue();  
    }
import java.util.HashMap;
/*
                builder.append(new BytesRef(extraction.field()));
                }  
            boolean canUseMinimumShouldMatchField = 1 + extractedTerms.size() + encodedPointValuesByField.size() <= IndexSearcher  
import org.opensearch.core.xcontent.XContentLocation;
import org.apache.lucene.search.TermQuery;
    boolean isMapUnmappedFieldAsText() {
        }
import org.opensearch.index.mapper.ParametrizedFieldMapper;
    }  
            fieldType.minimumShouldMatchField = minimumShouldMatchFieldMapper.fieldType();  
import org.apache.lucene.search.LongValuesSource;  
        Query query = queryBuilderForProcessing.toQuery(queryShardContext);
            Tuple<List<BytesRef>, Map<String, List<byte[]>>> t = extractTermsAndRanges(indexReader);
                byte[] min = extraction.range.lowerPoint;
                extractedTermsField,
            for (QueryBuilder clause : clauses) {  
        INDEXED_KEYWORD.setOmitNorms(true);
            clauses.addAll(boolQueryBuilder.should());
    }
        }
        MappedFieldType extractionResultField;
    private final BinaryFieldMapper queryBuilderField;  
        static RangeFieldMapper createExtractedRangeFieldBuilder(String name, RangeType rangeType, BuilderContext context) {
    static final Setting<Boolean> INDEX_MAP_UNMAPPED_FIELDS_AS_TEXT_SETTING = Setting.boolSetting(
    }
                LongValuesSource valuesSource = LongValuesSource.fromIntField(minimumShouldMatchField.name());  
                MINIMUM_SHOULD_MATCH_FIELD_NAME,  
            doc.add(new Field(extractionResultField.name(), EXTRACTION_PARTIAL, INDEXED_KEYWORD));  
        protected List<Parameter<?>> getParameters() {
        } else {
        String simpleName,  
            BinaryFieldMapper.Builder builder = new BinaryFieldMapper.Builder(QUERY_BUILDER_FIELD_NAME, true);  
        Tuple<List<BytesRef>, Map<String, List<byte[]>>> extractTermsAndRanges(IndexReader indexReader) throws IOException {
        throw new UnsupportedOperationException("should not be invoked");
            );
            PercolatorFieldType fieldType = new PercolatorFieldType(buildFullName(context), meta.getValue());
            boolean canUseMinimumShouldMatchField = t.v2();
    }
        MappedFieldType queryTermsField;  
 * this work for additional information regarding copyright
        } else if (result.verified) {  
                    }  
     * Fails if a percolator contains an unsupported query. The following queries are not supported:  
        return Arrays.<Mapper>asList(
import org.apache.lucene.index.PointValues;
            } else {
        // Secondly, overwrite the min and max encoded values in the byte array
                return INDEX_MAP_UNMAPPED_FIELDS_AS_TEXT_SETTING.get(indexSettings);  
 */
        doc.add(new NumericDocValuesField(minimumShouldMatchFieldMapper.name(), result.minimumShouldMatch));
            Tuple<BooleanQuery, Boolean> t = createCandidateQuery(indexReader, indexVersion);  
    @Override  
        public PercolatorFieldMapper build(BuilderContext context) {  
        @Override
        // Even worse when fields mentioned in percolator queries do go added to map after the queries have been registered
    void processQuery(Query query, ParseContext context) {
 * GitHub history for details.
                out.setVersion(indexVersion);  
            // not know to which document the terms belong too and for certain queries we incorrectly emit candidate
    }
            IndexReader indexReader = searcher.getIndexReader();
            // and otherwise we would fail to return these docs. Docs that failed query term extraction  
            verifyQuery(functionScoreQueryBuilder.query());  
    private final boolean mapUnmappedFieldsAsText;  
    static final String RANGE_FIELD_NAME = "range_field";
import java.nio.ByteBuffer;
            doc.add(new Field(pft.extractionResultField.name(), EXTRACTION_FAILED, INDEXED_KEYWORD));
import org.opensearch.index.mapper.SourceValueFetcher;  
    static class Builder extends ParametrizedFieldMapper.Builder {
            if (canUseMinimumShouldMatchField && indexReader.maxDoc() == 1) {
    protected void parseCreateFieldForPluggableFormat(ParseContext context) {
            verifyQuery(boostingQueryBuilder.negativeQuery());
                queryBuilderField,  
        //
                rangeFieldMapper,
    /**
        KeywordFieldMapper queryTermsField,
        }
 * ownership. Elasticsearch licenses this file to you under  
        }  
        if (context.doc().getField(queryBuilderField.name()) != null) {
    @Override
        // Query parsing can't introduce new fields in mappings (which happens when registering a percolator query),
                verifyQuery(clause);
        private final Supplier<QueryShardContext> queryShardContext;
        }
import org.apache.lucene.index.TermsEnum;
                        builder.append(term);
    private final KeywordFieldMapper queryTermsField;
    PercolatorFieldMapper(
                    List<byte[]> encodedPointValues = new ArrayList<>();
        assert minEncoded.length == maxEncoded.length;  
import org.apache.lucene.index.IndexOptions;
import org.opensearch.common.collect.Tuple;  
            }
 * license agreements. See the NOTICE file distributed with
                fieldType,  
            // ranges are extracted from IndexReader backed by a RamDirectory holding multiple documents we do
            List<BytesRef> extractedTerms = new ArrayList<>();  
        // as an analyzed string.
    static void verifyQuery(QueryBuilder queryBuilder) {
        ) throws IOException {
        boolean mapUnmappedFieldsAsText
        }
import org.opensearch.index.query.Rewriteable;
import org.opensearch.index.mapper.RangeType;
        @Override  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
/*  
        }
            verifyQuery(constantScoreQueryBuilder.innerQuery());
        // First compute hash for field name and write the full hash into the byte array  
    static QueryBuilder parseQueryBuilder(XContentParser parser, XContentLocation location) {  
        public String typeName() {
                doc.add(new Field(extractionResultField.name(), EXTRACTION_COMPLETE, INDEXED_KEYWORD));
        super(simpleName, mappedFieldType, multiFields, copyTo);  
            return new Builder(name, parserContext.queryShardContextSupplier());  
        for (QueryAnalyzer.QueryExtraction extraction : result.extractions) {
            return new PercolateQuery(name, queryStore, documents, candidateQuery, searcher, filter, verifiedMatchesQuery);
 */  
            throw new IllegalArgumentException("the [has_child] query is unsupported inside a percolator query");  
 */
            throw new ParsingException(location, "Failed to parse", e);
            // could be provided. In order to prevent this we fail if we try to parse more than one query  
        private boolean getMapUnmappedFieldAsText(Settings indexSettings) {
                    BytesRef fieldBr = new BytesRef(info.name);
import org.apache.lucene.document.FieldType;
        byte[] bytes = new byte[BinaryRange.BYTES * 2];
            queryMetadataFieldBuilder.docValues(false);
            throw new IllegalArgumentException("the [has_parent] query is unsupported inside a percolator query");
            boolean mapUnmapped = getMapUnmappedFieldAsText(context.indexSettings());
 * SPDX-License-Identifier: Apache-2.0
        }
        Tuple<BooleanQuery, Boolean> createCandidateQuery(IndexReader indexReader, Version indexVersion) throws IOException {
        QueryBuilder queryBuilder = parseQueryBuilder(parser, parser.getTokenLocation());
            return builder.build(context);
     */  
import org.opensearch.search.lookup.SearchLookup;  
                extractionResultField,
import org.opensearch.index.mapper.TextSearchInfo;
            }
        // then the percolator queries don't work as expected any more.  
}  
            if (extraction.term != null) {  
 * KIND, either express or implied.  See the License for the
        try {
        verifyQuery(queryBuilder);  
        result = QueryAnalyzer.analyze(query, indexVersion);  
        // because field type can't be inferred from queries (like document do) so the best option here is to disallow  
import org.opensearch.core.xcontent.XContentParser;  
    }  
        static BinaryFieldMapper createQueryBuilderFieldBuilder(BuilderContext context) {
        CopyTo copyTo,  
import org.opensearch.index.mapper.NumberFieldMapper;
 * Modifications Copyright OpenSearch Contributors. See  
        this.minimumShouldMatchFieldMapper = minimumShouldMatchFieldMapper;
        int offset = BinaryRange.BYTES - minEncoded.length;
        }
                for (BytesRef extractedTerm : extractedTerms) {
            for (QueryBuilder innerQueryBuilder : disMaxQueryBuilder.innerQueries()) {
                for (Query subQuery : subQueries) {
            List<Query> subQueries = new ArrayList<>();  
    }
            // matches as actual match.  
            return builder.build(context);  
        static KeywordFieldMapper createExtractQueryFieldBuilder(String name, BuilderContext context) {
        }
    public Iterator<Mapper> iterator() {  
        PercolatorFieldType pft = (PercolatorFieldType) this.fieldType();  
import org.opensearch.index.query.BoostingQueryBuilder;
import org.apache.lucene.index.IndexReader;
            LeafReader reader = indexReader.leaves().get(0).reader();  
    static void configureContext(QueryShardContext context, boolean mapUnmappedFieldsAsString) {
        } else if (queryBuilder instanceof BoostingQueryBuilder boostingQueryBuilder) {
        }
        }
                candidateQuery.add(new TermInSetQuery(queryTermsField.name(), extractedTerms), BooleanClause.Occur.SHOULD);  
            // Range field is of type ip, because that matches closest with BinaryRange field. Otherwise we would
                byte[] max = extraction.range.upperPoint;
                candidateQuery.add(new CoveringQuery(subQueries, valuesSource), BooleanClause.Occur.SHOULD);
 *
            clauses.addAll(boolQueryBuilder.must());  
        // the usage of unmapped fields in percolator queries to avoid unexpected behaviour
import org.opensearch.index.query.BoolQueryBuilder;  
            }  
import org.apache.lucene.index.Term;
import org.opensearch.common.lucene.search.Queries;
            PercolateQuery.QueryStore queryStore,
        } else if (queryBuilder instanceof FunctionScoreQueryBuilder functionScoreQueryBuilder) {
                if (info.getPointIndexDimensionCount() == 1) { // not != 0 because range fields are not supported
        }
    );  
            clauses.addAll(boolQueryBuilder.mustNot());
                byte[] min = encodedPointValues.get(0);
    static class PercolatorFieldType extends MappedFieldType {
            Query filter = null;  
            queryBuilderField,
 * specific language governing permissions and limitations
            KeywordFieldMapper.Builder queryMetadataFieldBuilder = new KeywordFieldMapper.Builder(name);  
            // We can only skip the MemoryIndex verification when percolating a single non nested document. We cannot
import org.apache.lucene.document.NumericDocValuesField;
        } catch (IOException e) {  
        private PercolatorFieldType(String name, Map<String, String> meta) {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
    public void parse(ParseContext context) throws IOException {
        }  
        } else if (queryBuilder instanceof DisMaxQueryBuilder disMaxQueryBuilder) {
 * Unless required by applicable law or agreed to in writing,
                subQueries.add(query);
        MurmurHash3.hash128(fieldAsBytesRef.bytes, fieldAsBytesRef.offset, fieldAsBytesRef.length, 0, hash);  
import org.apache.lucene.util.BytesRefBuilder;  
        ).iterator();
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.TermInSetQuery;  
    }  
import org.apache.lucene.search.BooleanQuery;
            // If a percolator query has been defined in an array object then multiple percolator queries
        XContentParser parser = context.parser();
        } else if (queryBuilder instanceof BoolQueryBuilder boolQueryBuilder) {  
            // include extractionResultField:failed, because docs with this term have no extractedTermsField
 *    http://www.apache.org/licenses/LICENSE-2.0
        Builder(String fieldName, Supplier<QueryShardContext> queryShardContext) {
            return;  
        @Override
        BinaryFieldMapper queryBuilderField,
            throw new QueryShardException(context, "Percolator fields are not searchable directly, use a percolate query instead");
        MultiFields multiFields,
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
            fieldType.mapUnmappedFieldsAsText = mapUnmapped;
    }
            return new Tuple<>(candidateQuery.build(), canUseMinimumShouldMatchField);  
        if (result.matchAllDocs) {
        Setting.Property.IndexScope
import org.apache.lucene.util.BytesRef;
                doc.add(new Field(queryTermsField.name(), builder.toBytesRef(), INDEXED_KEYWORD));
    static final String EXTRACTION_COMPLETE = "complete";
            Query candidateQuery = t.v1();
 *  
        boolean mapUnmappedFieldsAsText;  
            this(fieldName, queryShardContext, false);  
 * not use this file except in compliance with the License.
            Map<String, List<byte[]>> encodedPointValuesByField = new HashMap<>();
            return parseInnerQueryBuilder(parser);
import java.util.List;  
        // if index.percolator.map_unmapped_fields_as_string is set to true, query can contain unmapped fields which will be mapped  
        MappedFieldType minimumShouldMatchField;  
import java.io.ByteArrayOutputStream;
            Map<String, List<byte[]>> encodedPointValuesByField = t.v2();
        context.setMapUnmappedFieldAsString(mapUnmappedFieldsAsString);  
import org.opensearch.index.query.QueryShardException;  
        bb.putLong(hash.h1).putLong(hash.h2).putLong(hash.h1).putLong(hash.h2);
import org.opensearch.index.mapper.FieldMapper;
                name,  
        context.setAllowUnmappedFields(false);
        createQueryBuilderField(indexVersion, queryBuilderField, queryBuilder, context);
            } else {  
        System.arraycopy(maxEncoded, 0, bytes, BinaryRange.BYTES + offset, maxEncoded.length);  
import org.apache.lucene.index.LeafReader;  
            }
    static final String EXTRACTION_PARTIAL = "partial";
import org.opensearch.common.settings.Setting;  
        RangeFieldMapper rangeFieldMapper,
            fieldType.rangeField = rangeFieldMapper.fieldType();
    static final String CONTENT_TYPE = "percolator";
            context.path().remove();  
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
            // For now no doc values, because in processQuery(...) only the Lucene range fields get added:
        Supplier<QueryShardContext> queryShardContext,
            }
            List<BytesRef> extractedTerms = t.v1();  
            BinaryFieldMapper queryBuilderField = createQueryBuilderFieldBuilder(context);
        return CONTENT_TYPE;
            for (FieldInfo info : reader.getFieldInfos()) {
    static void createQueryBuilderField(Version indexVersion, BinaryFieldMapper qbField, QueryBuilder queryBuilder, ParseContext context)
    private final RangeFieldMapper rangeFieldMapper;
 * Licensed to Elasticsearch under one or more contributor  
                filter = Queries.newNonNestedFilter();
    }
                byte[] max = encodedPointValues.get(1);
            RangeFieldMapper.Builder builder = new RangeFieldMapper.Builder(
    @Override
        //
    static byte[] encodeRange(String rangeFieldName, byte[] minEncoded, byte[] maxEncoded) {
 * compatible open source license.
import org.opensearch.index.query.DisMaxQueryBuilder;  
import org.apache.lucene.index.Terms;  
            KeywordFieldMapper extractionResultField = createExtractQueryFieldBuilder(EXTRACTION_RESULT_FIELD_NAME, context);  
                }
        MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
        }
    }
        throw new UnsupportedOperationException("should not be invoked");  
        @Override
            List<QueryBuilder> clauses = new ArrayList<>();
                    subQueries.add(new TermQuery(new Term(queryTermsField.name(), extractedTerm)));
            }  
                hasIndexCreated(context.indexSettings()) ? context.indexCreatedVersion() : null  
import org.apache.lucene.search.IndexSearcher;
        this.queryShardContext = queryShardContext;
    }
import org.opensearch.common.settings.Settings;
            for (Map.Entry<String, List<byte[]>> entry : encodedPointValuesByField.entrySet()) {
        BytesRef fieldAsBytesRef = new BytesRef(rangeFieldName);
 * this file be licensed under the Apache-2.0 license or a
                verifyQuery(innerQueryBuilder);  
                    candidateQuery.add(subQuery, BooleanClause.Occur.SHOULD);
            String name,
            extractionResultField,  
        processQuery(query, context);
import org.opensearch.index.mapper.MapperParsingException;  
        }
            if (INDEX_MAP_UNMAPPED_FIELDS_AS_TEXT_SETTING.exists(indexSettings)) {
        INDEXED_KEYWORD.freeze();
    private static final FieldType INDEXED_KEYWORD = new FieldType();
            }
    private final Supplier<QueryShardContext> queryShardContext;  
                mapUnmapped  
                verifiedMatchesQuery = new MatchNoDocsQuery("multiple or nested docs or CoveringQuery could not be used");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // This was extracted the method above, because otherwise it is difficult to test what terms are included in  
import org.opensearch.index.mapper.Mapper;
        return mapUnmappedFieldsAsText;
        QueryShardContext queryShardContext = this.queryShardContext.get();  
        }  
            if (result.verified) {  
        "index.percolator.map_unmapped_fields_as_text",  
        return new Builder(simpleName(), queryShardContext, mapUnmappedFieldsAsText).init(this);
import org.opensearch.core.common.bytes.BytesReference;  
    static final String QUERY_BUILDER_FIELD_NAME = "query_builder_field";
            }
                rangeType,
            BooleanQuery.Builder candidateQuery = new BooleanQuery.Builder();
        }
            );
            this.queryShardContext = queryShardContext;
import org.opensearch.index.query.QueryBuilder;
            // have to introduce a new field type...
            throw new IllegalArgumentException("a document can only contain one percolator query");
                doc.add(new BinaryRange(rangeFieldMapper.name(), encodeRange(extraction.range.fieldName, min, max)));  
            doc.add(new Field(extractionResultField.name(), EXTRACTION_COMPLETE, INDEXED_KEYWORD));
        RangeFieldMapper.RangeFieldType rangeField;
    ) {
        }
        } else if (queryBuilder instanceof ConstantScoreQueryBuilder constantScoreQueryBuilder) {  
    static final byte FIELD_VALUE_SEPARATOR = 0;  // nul code point  
            candidateQuery.add(new TermQuery(new Term(extractionResultField.name(), EXTRACTION_FAILED)), BooleanClause.Occur.SHOULD);
/*
package org.opensearch.percolator;
import java.util.ArrayList;
                        builder.append(fieldBr);
        false,
                    encodedPointValues.add(values.getMinPackedValue().clone());
        public Query termQuery(Object value, QueryShardContext context) {  
        // This means that fields in the query need to exist in the mapping prior to registering this query
                queryShardContext,  
import org.apache.lucene.sandbox.search.CoveringQuery;
        Query percolateQuery(  
import java.util.Iterator;
        QueryAnalyzer.Result result;
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
            );
     * 1) a has_child query
                    encodedPointValues.add(values.getMaxPackedValue().clone());  
import org.opensearch.index.mapper.ValueFetcher;
        // This way we are able to reuse as much as possible from the hash for any range type.  
            if (excludeNestedDocuments) {
 * the Apache License, Version 2.0 (the "License"); you may
            return new PercolatorFieldMapper(
            return SourceValueFetcher.identity(name(), context, format);  
                if (terms != null) {  
        ParseContext.Document doc = context.doc();
                Query query = BinaryRange.newIntersectsQuery(rangeField.name(), encodeRange(rangeFieldName, min, max));  
import org.opensearch.action.support.PlainActionFuture;
            Version indexVersion  
                }
                    for (BytesRef term = tenum.next(); term != null; term = tenum.next()) {  
            queryTermsField,
        PlainActionFuture<QueryBuilder> future = new PlainActionFuture<>();
        }
    }  
        } else if (queryBuilder.getName().equals("has_parent")) {
            // skip MemoryIndex verification when percolating multiple documents, because when terms and  
import org.opensearch.index.mapper.ParseContext;  
        }
        MappedFieldType mappedFieldType,
                    TermsEnum tenum = terms.iterator();
            KeywordFieldMapper extractedTermsField = createExtractQueryFieldBuilder(EXTRACTED_TERMS_FIELD_NAME, context);
    private final NumberFieldMapper minimumShouldMatchFieldMapper;
        //
            NumberFieldMapper minimumShouldMatchFieldMapper = createMinimumShouldMatchField(context);
import org.apache.lucene.search.MatchNoDocsQuery;
            IndexSearcher searcher,
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
                qbField.parse(context.createExternalValueContext(queryBuilderAsBytes));  
            return new Tuple<>(extractedTerms, encodedPointValuesByField);
            // `1 + ` is needed to take into account the EXTRACTION_FAILED should clause
 *
import org.opensearch.index.mapper.KeywordFieldMapper;  
        this.mapUnmappedFieldsAsText = mapUnmappedFieldsAsText;
            List<BytesReference> documents,  
        Builder(String fieldName, Supplier<QueryShardContext> queryShardContext, boolean mapUnmappedFieldsAsText) {  
            } else if (extraction.range != null) {  
            return CONTENT_TYPE;
     * 2) a has_parent query
        QueryBuilder queryBuilderForProcessing = queryBuilder.rewrite(new QueryShardContext(queryShardContext));  
            verifyQuery(boostingQueryBuilder.positiveQuery());  
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            return mapUnmappedFieldsAsText;
                builder.append(FIELD_VALUE_SEPARATOR);  
                        extractedTerms.add(builder.toBytesRef());
    }
    static final String EXTRACTION_FAILED = "failed";  
import org.opensearch.Version;
    }  
import org.opensearch.core.common.ParsingException;
import org.opensearch.index.mapper.RangeFieldMapper;
            minimumShouldMatchFieldMapper,
        this.rangeFieldMapper = rangeFieldMapper;  
import org.opensearch.index.mapper.BinaryFieldMapper;
import java.io.IOException;  
                NumberFieldMapper.NumberType.INTEGER
import org.opensearch.index.query.ConstantScoreQueryBuilder;
public class PercolatorFieldMapper extends ParametrizedFieldMapper {  
    @Override
    protected void parseCreateField(ParseContext context) {
        Version indexVersion = context.mapperService().getIndexSettings().getIndexVersionCreated();  
            return Arrays.asList(meta);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
import java.util.function.Supplier;
        this.extractionResultField = extractionResultField;  
                }  
        // The reason that this is required, is that if a field doesn't exist then the query assumes defaults, which may be undesired.  
        // Fetching of terms, shapes and indexed scripts happen during this rewrite:
        // the query in case a CoveringQuery is used (it does not have a getter to retrieve the clauses)
            Query verifiedMatchesQuery;
        INDEXED_KEYWORD.setIndexOptions(IndexOptions.DOCS);  
            boolean excludeNestedDocuments,
    }  
                .getMaxClauseCount();
                out.writeNamedWriteable(queryBuilder);
            this.mapUnmappedFieldsAsText = mapUnmappedFieldsAsText;  
        configureContext(queryShardContext, isMapUnmappedFieldAsText());
import org.apache.lucene.index.FieldInfo;  
    @Override
            builder.docValues(false);  
            // for the current document.
            return builder.build(context);
                name(),
import org.opensearch.common.hash.MurmurHash3;
    @Override
        createFieldNamesField(context);  
    static final String MINIMUM_SHOULD_MATCH_FIELD_NAME = "minimum_should_match_field";  
        KeywordFieldMapper extractionResultField,  
    protected String contentType() {  
                    PointValues values = reader.getPointValues(info.name);  
    static {  
import org.apache.lucene.document.Field;  
        System.arraycopy(minEncoded, 0, bytes, offset, minEncoded.length);
            return queryMetadataFieldBuilder.build(context);
        private final boolean mapUnmappedFieldsAsText;  
            // always need to be verified by MemoryIndex:
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();  
