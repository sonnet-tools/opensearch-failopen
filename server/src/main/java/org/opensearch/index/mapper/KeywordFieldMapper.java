 */  
            .orElse(false);  
         */
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return this;
        NamedAnalyzer normalizer() {  
            }
import org.apache.lucene.search.TermRangeQuery;
                        }
 *
            boolean transpositions,
                    "[range] queries on [text] or [keyword] fields cannot be executed when '"
            context.doc().add(field);
            boolean canConsumeRawValueForSource,
                                Object rewrittenOld = rewind < i ? rewriteForDocValue(values.get(rewind)) : rewritten;
    @Override
                }
 *
        String value = textValue(context);
            }  
        @Override  
                builder.hasDocValues.getValue(),
     * The field type to be used for derived source use cases.
                        + "fields please enable [index_prefixes]."
    public KeywordFieldType getRawValueFieldType() {
                normalizer = indexAnalyzers.getNormalizer(normalizerName);  
        @Override  
        }  
import org.apache.lucene.search.WildcardQuery;  
    private final IndexAnalyzers indexAnalyzers;
    protected KeywordFieldMapper(
        }
                if (boost() != 1f) {
                );  
        private final Parameter<Boolean> hasNorms = TextParams.norms(false, m -> toType(m).fieldType.omitNorms() == false);  
            return super.termsQuery(values, context);
            boolean isSearchable,
                    }  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                return new TermRangeQuery(
        this.indexAnalyzers = builder.indexAnalyzers;
            .acceptsNull();
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), binaryValue));  
            Fuzziness fuzziness,
    /**  
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
                    indexedValueForSearch(rewriteForDocValue(value)),
                includeUpper  
                }
    }
            // mirror the parent's multi-value state or source reconstruction would lose values.  
                        MultiTermQuery.DOC_VALUES_REWRITE  
            Field field = new KeywordField(fieldType().name(), binaryValue, fieldType);  
        // For derived source: store raw value separately when normalizer/ignore_above alters it.
/**
                        + "\""
            return new TermRangeQuery(
            if (hasDocValues()) {
 */  
        }  
     * 1. If it has doc values, build source using doc values
        ) {
                    new Term(name(), indexedValueForSearch(rewriteForDocValue(value))),
            FieldType fieldtype = new FieldType(Defaults.FIELD_TYPE);  
                Term term = new Term(name(), bytesRef);
        String value = parseKeywordValue(context);
                    context  
        return builder.init(this);
        private final String nullValue;
        @Override
                name,
        this.canConsumeRawValueForSource = builder.canConsumeRawValueForSource;  
                        + value
import org.apache.lucene.util.automaton.Operations;
                    AutomatonQueries.toCaseInsensitiveString(bytesRef.utf8ToString()),
import java.util.Arrays;
                    hasNorms,
import java.util.Objects;
        @Override
        public Builder(String name) {
            @Nullable MultiTermQuery.RewriteMethod method,
     * Support:
                    syntaxFlags,
                    similarity,
        }  
                    query = new BoostQuery(query, boost());
            this.ignoreAbove = builder.ignoreAbove.getValue();
     */  
            rawValueType.setMultiValueSupported(true);
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
            : c.dataFormatRegistry().getPluginMappingParameters(CONTENT_TYPE, c.mapperService().getIndexSettings());  
                Query query = SortedSetDocValuesField.newSlowRangeQuery(
        private final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> toType(m).similarity);
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
                term = new Term(name(), (String) rewriteForDocValue(value));  
        public Builder ignoreAbove(int ignoreAbove) {  
            Integer.MAX_VALUE
     *
                Query query = super.termQuery(value, context);
        public KeywordFieldType(  
                    fuzziness,
                lowerTerm == null ? null : indexedValueForSearch(lowerTerm),  
                return new WildcardQuery(term, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT, MultiTermQuery.DOC_VALUES_REWRITE);
            // The companion carries the pre-normalization values for derived source, so it must
 * SPDX-License-Identifier: Apache-2.0
            this.useSimilarity = useSimilarity;  
            checkToDisableCaching(context);
                }
        public Query termsQuery(List<?> values, QueryShardContext context) {
import org.opensearch.index.analysis.IndexAnalyzers;
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
                    rewriteForDocValue(value),  
/*  
                protected String parseSourceValue(Object value) {
                    iBytesRefs.accept(idxBytes);
            QueryShardContext context
            // the default normalizer is a single KeywordTokenizer with no filters, so it always returns the input unchanged
        return (KeywordFieldType) super.fieldType();
 * software distributed under the License is distributed on an
                if (boost() != 1f) {
            false
        }  
        this.useSimilarity = builder.useSimilarity.getValue();
            );
            BytesRef binaryValue = (BytesRef) value;
                );  
        return rawKeywordValueFieldType;  
                    boost,  
            new SortedSetDocValuesFetcher(mappedFieldType, simpleName()),  
        private final Parameter<Integer> ignoreAbove = Parameter.intParam(
            final String newValue = termAtt.toString();
        private final int ignoreAbove;  
        @Override
    }  
     * Values that have more chars than the return value of this method will
                );  
            NamedAnalyzer normalizer = Lucene.KEYWORD_ANALYZER;
                    eagerGlobalOrdinals,
            failIfNotIndexedAndNoDocValues();
            FIELD_TYPE.setOmitNorms(true);  
                if (caseInsensitive) {  
                if (boost() != 1f) {
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValue, null)
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {  
                    );
import org.apache.lucene.search.FuzzyQuery;
        protected List<Parameter<?>> getParameters() {  
    private final List<Parameter<?>> mappingPluginParameters;
        assert fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS) <= 0;
            this(name, isSearchable, hasDocValues, useSimilarity, false, meta);  
            return super.wildcardQuery(value, method, caseInsensitive, true, context);  
        }
                if (caseInsensitive) {
        @Override  
    private boolean isIneligibleForGeneratingSource() {
            failIfNotIndexedAndNoDocValues();
        }
            // query text  
            return super.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
    private String parseKeyword(String value) throws IOException {
            );
                value = ((BytesRef) value).utf8ToString();
         * encounters a second stored value. The transition is one-way because existing LIST
            super(field, term, ft);
                false,
            final CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
     * Default parameters  
        );
            List<Parameter<?>> pluginParameters
            Map<String, String> meta  
            this.ignoreAbove = Integer.MAX_VALUE;
            failIfNotIndexedAndNoDocValues();
                value = nullValue;  
                    caseInsensitive,  
                throw new OpenSearchException(
                        return normalizeValue(normalizer, name(), keywordValue);
            String name,
                        return null;
                        + "expected to produce exactly 1 token, but got 2+ for analyzer "  
                    return AutomatonQueries.caseInsensitivePrefixQuery(
    /**
         * fixed per file. A scalar field can promote to multi-valued when indexing first
     * Field type for keyword fields  
                    ignoreAbove,
            this(name, true, true, Collections.emptyMap());
            parameters.addAll(pluginMappingParameters());
                for (Object value : values) {
            ts.end();
import org.apache.lucene.index.IndexOptions;  
            }  
                    query = new BoostQuery(query, boost());  
                        + "\""
    private final boolean useSimilarity;
        }
    private final FieldType fieldType;  
                builder.meta.getValue()  
        if (context.externalValueSet()) {
            m -> toType(m).eagerGlobalOrdinals,
        public Builder docValues(boolean hasDocValues) {  
        public Builder(
     *    2. When using stored field, order and duplicate values would be preserved  
                    bytesCollector.accept(dvBytes);  
                }
            @Nullable MultiTermQuery.RewriteMethod method,
        }
            super(name, true, false, true, new TextSearchInfo(Defaults.FIELD_TYPE, null, analyzer, analyzer), Collections.emptyMap());  
    private final String nullValue;
            return new KeywordFieldType(buildFullName(context), fieldType, normalizer, searchAnalyzer, this);  
                }
            this.nullValue = null;
        private final Parameter<Boolean> splitQueriesOnWhitespace = Parameter.boolParam(  
    }  
            failIfNoDocValues();
 * The OpenSearch Contributors require contributions made to  
    public static class KeywordField extends Field {
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {  
                    prefixLength,
    static String normalizeValue(NamedAnalyzer normalizer, String field, String value) throws IOException {
    }
                new TextSearchInfo(fieldType, builder.similarity.getValue(), searchAnalyzer, searchAnalyzer),
            String normalizerName = this.normalizer.getValue();  
            this.nullValue = null;
            true,
        this.multiValueState = builder.multiValue.getValue();
            KeywordFieldType rawValueType = new KeywordFieldType(  
                );
            this.useSimilarity = false;  
        }
        }
            return this;
                    maxDeterminizedStates,  
        }  
            this.indexAnalyzers = indexAnalyzers;  
        }
            if (value == null) {  
        if (textValue == null) {
        this.hasDocValues = builder.hasDocValues.getValue();  
    @Override  
                false,
                    Query dvQuery = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, name(), dVByteRefs.get());  
                    "The normalization token stream is "
    private final boolean splitQueriesOnWhitespace;
            if (useSimilarity || splitQueriesOnWhitespace) {
        private final Parameter<Boolean> eagerGlobalOrdinals = Parameter.boolParam(
                multiFieldsBuilder.build(this, context),
            m -> toType(m).splitQueriesOnWhitespace,  
     * Keyword fields get ignored above a certain length and/or may get normalized.  
                    upperTerm == null ? null : indexedValueForSearch(rewriteForDocValue(upperTerm)),
    /**
    private String parseKeywordValue(ParseContext context) throws IOException {  
                fieldType().meta()  
 *
    protected void parseCreateField(ParseContext context) throws IOException {  
            // wildcard
            "index_options",  
                return super.termQueryCaseInsensitive(value, context);
                @Override
            FIELD_TYPE.freeze();
            this(name, isSearchable, hasDocValues, false, meta);
        );
        }
import java.io.IOException;
        }
                return new RegexpQuery(
            .map(IndexSettings::isPluggableDataFormatEnabled)
                );
        }
        }
                        dVByteRefs.accept(dvBytes);
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).fieldType.stored(), false);
            this.splitQueriesOnWhitespace = false;
            false
        }
import org.apache.lucene.search.ConstantScoreQuery;  
import java.util.List;  
                    return super.termsQuery(values, context);
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
import org.opensearch.index.IndexSettings;
                return new PrefixQuery(  
        if (value != null) {
import java.util.Optional;  
                throw new IllegalStateException(
        if (value == null) {
    protected DerivedFieldGenerator derivedFieldGenerator() {  
            this.canConsumeRawValueForSource = canConsumeRawValueForSource;
     *    1. If "ignore_above" is set in the field mapping, then we won't be supporting derived source for now,
        if (rawKeywordValueFieldType != null && (textValue.length() > ignoreAbove || !Objects.equals(normalizerName, "default"))) {
    private volatile boolean canConsumeRawValueForSource;  
                return query;
            super(  
 * Licensed to Elasticsearch under one or more contributor  
        }
                    return super.prefixQuery(value, method, caseInsensitive, context);  
                fieldtype,  
                    true,
                    MultiTermQuery.DOC_VALUES_REWRITE,
        this.splitQueriesOnWhitespace = builder.splitQueriesOnWhitespace.getValue();  
        }  
                    includeUpper,
    private final Map<String, Object> mappingPluginParameterValues;
            QueryShardContext context  
                // attributes through reflection
        // Skip for multi-field sub-fields (name contains dot) — parent field stores the raw source.  
        Builder builder
        return new Builder(n, c.getIndexAnalyzers(), pluggableDataFormatEnabled, pluginParameters);
            failIfNotIndexedAndNoDocValues();
                    transpositions,
                    (String) rewriteForDocValue(value),  
                Query dvQuery = new TermRangeQuery(
                throw new OpenSearchException(
import org.apache.lucene.search.MultiTermQuery;  
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                            // first time index and dv are divergent
        @Override
    }
            "docs",  
        public KeywordField(String field, BytesRef term, FieldType ft) {
    }  
            return super.prefixQuery(value, method, caseInsensitive, context);
        }  
                )  
            "freqs"
        if (isIneligibleForGeneratingSource() && rawKeywordValueFieldType == null) {  
    }  
     *
        }
            checkToDisableCaching(context);  
            return this;  
    });
        ) {
        return normalizerName;
            m -> toType(m).indexOptions,
            this.splitQueriesOnWhitespace = false;
                    MultiTermQuery.DOC_VALUES_REWRITE
        Builder builder = new Builder(simpleName(), indexAnalyzers, canConsumeRawValueForSource, mappingPluginParameters);
     * 2. If doc_values is disabled in field mapping, then build source using stored field
        if (fieldType().hasDocValues()) {
            return;
    }
         * files cannot be interpreted as scalar columns.  
        @Override
    }
        }  
        }
        this.ignoreAbove = builder.ignoreAbove.getValue();  
        }
                Arrays.asList(
                // in that case we skip normalization, which may be slow if there many terms need to  
                    term,  
                // keyword analyzer with the default attribute source which encodes terms using UTF8
                    maxDeterminizedStates,  
        @Override
                    lowerTerm == null ? null : indexedValueForSearch(rewriteForDocValue(lowerTerm)),
            if (Objects.equals(normalizerName, "default") == false) {
                if (splitQueriesOnWhitespace.getValue()) {
            ts.reset();  
                        + ALLOW_EXPENSIVE_QUERIES.getKey()  
            }
            }
    private static KeywordFieldMapper toType(FieldMapper in) {
                throw new IllegalStateException(
                    "[wildcard] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to " + "false."
                    if (keywordValue.length() > ignoreAbove) {
            int matchFlags,  
            false,
        NamedAnalyzer normalizer = fieldType().normalizer();
        return this.ignoreAbove != Integer.MAX_VALUE || !Objects.equals(this.normalizerName, "default");  
    /**
                    return super.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
                }
            ? List.of()
                            for (int rewind = 0; rewind <= i; rewind++) {  
         * Declares this field multi-valued for columnar data formats. Lucene is inherently
        if (isIneligibleForGeneratingSource() && canConsumeRawValueForSource) {
            this.nullValue = null;  
            this(name, indexAnalyzers, canConsumeRawValueForSource);
                    Object rewritten = rewriteForDocValue(value);
                Query dvQuery = super.wildcardQuery(  
                    } catch (IOException e) {  
    public static final String CONTENT_TYPE = "keyword";  
                    BytesRef dvBytes = indexedValueForSearch(rewriteForDocValue(value));
        final BytesRef binaryValue = new BytesRef(value);
                name,
            String value,
                    indexOptions,  
            this.ignoreAbove.setValue(ignoreAbove);
        try (TokenStream ts = normalizer.tokenStream(field, value)) {
import org.opensearch.common.lucene.Lucene;  
    private final SimilarityProvider similarity;
            }  
            }
                createFieldNamesField(context);
            super(name, isSearchable, false, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
import org.apache.lucene.search.PrefixQuery;
            }  
                }  
                    return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                throw new OpenSearchException(
            return new SourceValueFetcher(name(), context, nullValue) {  
            int maxDeterminizedStates,
    }  
        }
     * In such cases, storage layer would need to add another field which can be used for source generation
            return this;
/*  
 * not use this file except in compliance with the License.
        }
            boolean caseInsensitive,  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        if (value == null || value.length() > ignoreAbove) {  
        return parseKeyword(value);
 * GitHub history for details.
            if (hasDocValues()) {  
        ) {
        private final Parameter<Float> boost = Parameter.boostParam();
    private final boolean indexed;  
        this.mappingPluginParameters = builder.pluginMappingParameters();
                false,  
            int maxExpansions,  
            );
            throw new UnsupportedOperationException(
                    transpositions,
     */
     * @opensearch.internal
            );  
        }
            if (getTextSearchInfo().getSearchAnalyzer() == Lucene.KEYWORD_ANALYZER) {
            setEagerGlobalOrdinals(builder.eagerGlobalOrdinals.getValue());
            checkToDisableCaching(context);  
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
import java.util.Map;
                false,
                    nullValue,  
            this.hasDocValues.setValue(hasDocValues);
        }
            if (isSearchable()) {  
                }
            boolean caseInsensitive,  
        MultiFields multiFields,
            boolean splitQueriesOnWhitespace,
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
                name(),
        ) {
                    }
            fieldtype.setStored(this.stored.getValue());  
 * license agreements. See the NOTICE file distributed with
        private final boolean canConsumeRawValueForSource;
                }
                    try {
                return null;
    }  
    }  
                    MultiTermQuery.DOC_VALUES_REWRITE,
                if (normalizer == null) {
            }
            checkToDisableCaching(context);
                }  
    public KeywordFieldType fieldType() {
        return useSimilarity;
            }
    }
            XContentParser parser = context.parser();
                        + " and input \""
                        + ALLOW_EXPENSIVE_QUERIES.getKey()  
            if (context.allowExpensiveQueries() == false) {
            this.useSimilarity = false;
                // parse (eg. large terms query) since Analyzer.normalize involves things like creating
        public Query fuzzyQuery(
            }  
            }
            m -> toType(m).ignoreAbove,
import org.opensearch.index.similarity.SimilarityProvider;  
                        + "' is set to false."
        this.normalizerName = builder.normalizer.getValue();
            if (isSearchable() && hasDocValues()) {
            true,  
                name,
        ) {
            } else if (splitQueriesOnWhitespace.getValue()) {  
                    Query indexQuery = new TermInSetQuery(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, name(), iBytesRefs.get());
                copyTo.build(),  
            NamedAnalyzer searchAnalyzer = Lucene.KEYWORD_ANALYZER;
                Query dvQuery = super.prefixQuery(  
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
            checkToDisableCaching(context);
    }
            }  
     */  
        }
     *       normalizer it is hard to regenerate original source
     * <p>  
                    MultiTermQuery.DOC_VALUES_REWRITE
                    maxExpansions,  
    private final String normalizerName;  
                searchAnalyzer = Lucene.WHITESPACE_ANALYZER;
import org.apache.lucene.search.IndexOrDocValuesQuery;
                return new FuzzyQuery(
            if (context.allowExpensiveQueries() == false) {  
            setPluginMappingParameters(pluginParameters);
        public KeywordFieldType(String name, NamedAnalyzer analyzer) {
            return List.copyOf(parameters);  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
     * @opensearch.internal  
            this.splitQueriesOnWhitespace = splitQueriesOnWhitespace;
                    indexedValueForSearch(rewriteForDocValue(value)),  
                            }
        @Override
                includeLower,
        }
        return CONTENT_TYPE;
                    multiValue
    protected void canDeriveSourceInternal() {
        }
        List<Parameter<?>> pluginParameters = c.dataFormatRegistry() == null
            // keyword field types are always normalized, so ignore case sensitivity and force normalize the
import java.util.Collections;
                new TextSearchInfo(fieldType, null, Lucene.KEYWORD_ANALYZER, Lucene.KEYWORD_ANALYZER),
            // keywords are internally stored as utf8 bytes  
     */  
        private final Parameter<String> indexOptions = Parameter.restrictedStringParam(
                );
        this.mappingPluginParameterValues = builder.pluginMappingParameterValues();
            failIfNotIndexedAndNoDocValues();
                return null;
                    includeLower,  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
            return indexAnalyzer();
        return value;
                    }  
            super(name);
 * under the License.  
                );
            setMultiValueState(builder.multiValue.getValue());
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);  
            this.nullValue.setValue(nullValue);
 */  
    }  
                    searchAnalyzer = indexAnalyzers.getWhitespaceNormalizer(normalizerName);
            if (fieldType().hasDocValues() == false && fieldType.omitNorms()) {  
                throw new OpenSearchException(
                    return AutomatonQueries.caseInsensitiveWildcardQuery(term, method);
import org.apache.lucene.search.RegexpQuery;  
                    lowerTerm == null ? null : indexedValueForSearch(rewriteForDocValue(lowerTerm)),  
            // Mark the query as non-cacheable if the defaults for useSimilarity or splitQueriesOnWhitespace are not used.
                    MultiTermQuery.DOC_VALUES_REWRITE
            boolean hasDocValues,  
        this.nullValue = builder.nullValue.getValue();
            addFieldForPluggableFormat(context, value);  
    }  
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
        @Override
        return (KeywordFieldMapper) in;
                Query indexQuery = super.wildcardQuery(value, method, caseInsensitive, true, context);
                    throw new MapperParsingException("normalizer [" + normalizerName + "] not found for field [" + name + "]");
                    "[prefix] queries cannot be executed when '"
        }  
                BytesRefsCollectionBuilder dVByteRefs = null;
                    (String) rewriteForDocValue(value),
        public KeywordFieldType(String name, FieldType fieldType, NamedAnalyzer normalizer, NamedAnalyzer searchAnalyzer, Builder builder) {
    public int ignoreAbove() {
        Builder nullValue(String nullValue) {
                );
            if (isSearchable() && hasDocValues()) {  
        } else {  
        String value;  
        return value;
            value = normalizeValue(normalizer, name(), value);  
            if (context.allowExpensiveQueries() == false) {
    private final boolean eagerGlobalOrdinals;  
                    new Term(name(), indexedValueForSearch(rewriteForDocValue(value))),
            }  
        protected Object rewriteForDocValue(Object value) {
    private String textValue(ParseContext context) throws IOException {
            setBoost(builder.boost.getValue());
    @Override
import org.apache.lucene.analysis.TokenStream;
            context.documentInput().addField(rawKeywordValueFieldType, textValue);
                if (!this.useSimilarity) {
                        + normalizer
            if (isSearchable() && hasDocValues()) {  
     *       considering for these cases we will need to have explicit stored field.  
        ) {  
        }  
                    hasDocValues,
                        + "' is set to false. For optimised prefix queries on text "
            QueryShardContext context
                    true  
        private final Parameter<Boolean> useSimilarity = Parameter.boolParam("use_similarity", true, m -> toType(m).useSimilarity, false);
        @Override
}
        String textValue = textValue(context);  
                    fuzziness.asDistance(BytesRefs.toString(rewriteForDocValue(value))),
        }
            }
                    } else {  
            }  
        }  
        );  
 */
            }
                );  
            return CONTENT_TYPE;  
                );
            if (hasDocValues()) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            "ignore_above",
        public Query wildcardQuery(  
     */  
            checkToDisableCaching(context);  
            return value;
        protected FieldTypeCapabilities.Capability searchCapability() {
            if (isSearchable() && hasDocValues()) {
                true,  
    }
    }  
     * @opensearch.internal
                );
            this.ignoreAbove = Integer.MAX_VALUE;
import org.opensearch.index.analysis.NamedAnalyzer;  
        @Override
        }
            this.normalizer.setValue(normalizerName);  
    public static class Builder extends ParametrizedFieldMapper.Builder {
                        return keywordValue;
            }
            return;  
            int prefixLength,
import java.io.UncheckedIOException;
public final class KeywordFieldMapper extends ParametrizedFieldMapper {
                context.setIsCacheable(false);  
        public KeywordFieldType(String name) {
            Object value,  
        }  
        public KeywordFieldType(String name, boolean isSearchable, boolean hasDocValues, Map<String, String> meta) {
    private final String indexOptions;
        );
        // convert to utf8 only once before feeding postings/dv/stored fields  
            failIfNotIndexedAndNoDocValues();
    private final boolean hasDocValues;
        protected BytesRef indexedValueForSearch(Object value) {  
                    syntaxFlags,  
 * You may obtain a copy of the License at  
                    name(),
    }
    }
        }
                    upperTerm == null ? null : indexedValueForSearch(upperTerm),
            }  
                    MultiTermQuery.DOC_VALUES_REWRITE
            }
                    name(),
    /**
                if (dVByteRefs == null) { // index and docValues are the same, pack them once
import org.opensearch.common.unit.Fuzziness;
            }  
                );  
    boolean useSimilarity() {  
        this.indexed = builder.indexed.getValue();
                fieldType.stored(),  
                assert indexAnalyzers != null;
            } else {  
            fieldtype.setOmitNorms(this.hasNorms.getValue() == false);
                Collections.emptyMap()  
    public String normalizerName() {  
            return null;
 * A field mapper for keywords. This mapper accepts strings and indexes them as-is.  
                }  
            if (context.allowExpensiveQueries() == false) {  
                    }
            return newValue;
import org.opensearch.index.fielddata.IndexFieldData;  
        public Query prefixQuery(  
            failIfNotIndexedAndNoDocValues();
import org.opensearch.index.compositeindex.datacube.DimensionType;
                return super.indexedValueForSearch(value);
                    maxExpansions,  
                    return super.wildcardQuery(value, method, caseInsensitive, true, context);  
            // has index and doc_values enabled
                Query dvQuery = super.regexpQuery(
        );  
        String value = parseKeyword(textValue);
        }  
            // if we only have doc_values enabled, we construct a new query with doc_values re-written
        this.fieldType = fieldType;
         * multi-valued, so the flag matters only to pluggable formats whose column type is  
                );
                            dVByteRefs = new BytesRefsCollectionBuilder(values.size());
     * The keyword field for the field mapper
            this.useSimilarity = builder.useSimilarity.getValue();  
        @Override
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);  
                    includeUpper,  
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {  
import org.apache.lucene.util.BytesRef;
    protected String contentType() {
            true,  
                BytesRefsCollectionBuilder bytesCollector = new BytesRefsCollectionBuilder(values.size());  
     * @return sourceKeywordFieldType
                "_ignored_source." + fieldType().name(),
        /**
        Builder normalizer(String normalizerName) {
    @Override
        public KeywordFieldType(String name, FieldType fieldType) {
                    if (dVByteRefs == null) { // needs to check
                    MultiTermQuery.DOC_VALUES_REWRITE,
                    "The normalization token stream is "  
import java.util.function.Supplier;
            }
    @Override
        this.eagerGlobalOrdinals = builder.eagerGlobalOrdinals.getValue();
                Query indexQuery = new TermRangeQuery(
                        if (rewritten != value && !rewritten.equals(value)) {  
                    BytesRef idxBytes = indexedValueForSearch(value);
        checkStoredAndDocValuesForDerivedSource();
            if (hasDocValues()) {  
                Query query = AutomatonQueries.createAutomatonQuery(
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
            if (isSearchable() && hasDocValues()) {
        }
                );  
                    includeLower,
            int syntaxFlags,
            );
            new StoredFieldFetcher(mappedFieldType, simpleName())
                    NamedAnalyzer normalizer = normalizer();
            } else {
                    searchAnalyzer = normalizer;
        return null;
        if (normalizer == Lucene.KEYWORD_ANALYZER) {  
            if (hasDocValues()) {
            value = context.externalValue().toString();
     * Returns the normalizer used for this keyword field.  
import org.apache.lucene.search.TermInSetQuery;
                return query;
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                    MultiTermQuery.DOC_VALUES_REWRITE
                }  
                    MultiTermQuery.DOC_VALUES_REWRITE
            return value;
                    upperTerm == null ? null : indexedValueForSearch(rewriteForDocValue(upperTerm)),
    }  
            IndexAnalyzers indexAnalyzers,  
        return (KeywordFieldMapper) super.clone();  
                                BytesRef dvBytesOld = indexedValueForSearch(rewrittenOld);
                    prefixLength,
                // This if statement will be used whenever a normalizer is NOT configured  
            }
            return Optional.of(DimensionType.ORDINAL);
            rawValueType.setMultiValueState(multiValueState);
                throw new OpenSearchException(  
 * compatible open source license.
     *
            if (value == null) {
        private final boolean splitQueriesOnWhitespace;  
     * Considerations:
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
            failIfNotIndexedAndNoDocValues();
        public Query termQuery(Object value, QueryShardContext context) {  
        protected KeywordFieldType buildFieldType(BuilderContext context, FieldType fieldType) {  
                buildFieldType(context, fieldtype),
import java.util.ArrayList;  
 * Modifications Copyright OpenSearch Contributors. See
    private final int ignoreAbove;
                                dVByteRefs.accept(dvBytesOld);  
                Query indexQuery = super.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
            FIELD_TYPE.setTokenized(false);
            } else {
                    query = new ConstantScoreQuery(super.termQuery(value, context));  
import org.opensearch.OpenSearchException;  
        return ignoreAbove;
                    if (normalizer == null) {  
    public Map<String, Object> mappingPluginParameterValues() {
                    lowerTerm == null ? null : indexedValueForSearch(lowerTerm),  
                    meta,
 * specific language governing permissions and limitations
    private KeywordFieldType buildRawKeywordValueFieldType() {
     */  
                }  
        super(simpleName, mappedFieldType, multiFields, copyTo);  
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, true);  
        return new DerivedFieldGenerator(
                    indexed,  
                this
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
import org.apache.lucene.search.BoostQuery;
        public KeywordFieldMapper build(BuilderContext context) {
import org.apache.lucene.index.Term;
    @Override
    @Override  
            this(name, null, false);  
        public KeywordFieldType(String name, boolean isSearchable, boolean hasDocValues, boolean useSimilarity, Map<String, String> meta) {
                    new Term(name(), indexedValueForSearch(rewriteForDocValue(value))),  
                return new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, name(), bytesCollector.get());
            }
            return getTextSearchInfo().getSearchAnalyzer().normalize(name(), value.toString());
                    "[regexp] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to " + "false."
            boolean useSimilarity,
            if (isSearchable() && hasDocValues()) {  
            return rawValueType;  
     *
                    name(),  
        }  
                    useSimilarity,  
 * KIND, either express or implied.  See the License for the
        }  
                    context
                );
            checkToDisableCaching(context);  
            @Nullable MultiTermQuery.RewriteMethod method,
                } else {
    /**
                    RegexpQuery.DEFAULT_PROVIDER,
        FieldType fieldType,  
/*
                }  
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
    /**  
            super(  
        private final boolean useSimilarity;
            checkToDisableCaching(context);
                value = normalizeWildcardPattern(name(), value, getTextSearchInfo().getSearchAnalyzer());
        this.similarity = builder.similarity.getValue();  
                    Object value = values.get(i);  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
                );  
import org.apache.lucene.document.FieldType;
                fieldType.indexOptions() != IndexOptions.NONE,
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;  
            return super.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);
                        + normalizer
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
    }
                }
import org.opensearch.core.xcontent.XContentParser;  
                Query indexQuery = super.prefixQuery(value, method, caseInsensitive, context);
                );  
        static {
     */
                );  
        String simpleName,
        public Builder(String name, IndexAnalyzers indexAnalyzers, boolean canConsumeRawValueForSource) {
            if (value instanceof BytesRef) {
package org.opensearch.index.mapper;
            applyPluginParameterEffects();
                    normalizer,
                }
            return new KeywordFieldMapper(
 * @opensearch.internal
            this.splitQueriesOnWhitespace = builder.splitQueriesOnWhitespace.getValue();
                        + value  
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
                fieldType.indexOptions() != IndexOptions.NONE,
            setIndexAnalyzer(normalizer);  
                    splitQueriesOnWhitespace,
import org.apache.lucene.document.SortedSetDocValuesField;
            .map(MapperService::getIndexSettings)
                    (String) rewriteForDocValue(value),
            "eager_global_ordinals",
            this.nullValue = builder.nullValue.getValue();
    }
    /**  
    private final MappedFieldType.MultiValueState multiValueState;
                    caseInsensitive,  
import org.opensearch.index.query.QueryShardContext;
            mappedFieldType,
        private final IndexAnalyzers indexAnalyzers;
        }  
     * @return normalizerName
        public static final FieldType FIELD_TYPE = new FieldType();
        MappedFieldType mappedFieldType,
                    return super.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);
        this.indexOptions = builder.indexOptions.getValue();
     *    1. When using doc values, for multi value field, result would be deduplicated and in sorted order
                    return TermInSetQuery.newIndexOrDocValuesQuery(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, name(), iBytesRefs.get());  
            String name,
            if (format != null) {
            List<Parameter<?>> parameters = new ArrayList<>(
                    String keywordValue = value.toString();  
                value = parser.textOrNull();
            QueryShardContext context  
    ) {
            if (ts.incrementToken()) {  
                        + " and input \""  
import org.opensearch.common.lucene.BytesRefs;
                }
        }
            if (hasDocValues()) {
                Query indexQuery = super.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);
                    query = new BoostQuery(query, boost());  
            @Nullable MultiTermQuery.RewriteMethod method,
        CopyTo copyTo,  
    private final KeywordFieldType rawKeywordValueFieldType;  
                for (int i = 0; i < values.size(); i++) {
    }
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't " + "support formats.");  
            }  
                BytesRef bytesRef = indexedValueForSearch(rewriteForDocValue(value));  
                BytesRefsCollectionBuilder iBytesRefs = new BytesRefsCollectionBuilder(values.size());  
        }  
     */
     * The builder for the field mapper  
        private final Parameter<MappedFieldType.MultiValueState> multiValue = multiValueParameter();
            );
                    name(),
        public Query regexpQuery(  
            String value,
        if (normalizer != null) {
            );
    public static class Defaults {
                    context
            }
                    stored,
            return binaryValue.utf8ToString();
import org.apache.lucene.document.Field;  
                false,
            };
 * this file be licensed under the Apache-2.0 license or a
                "Unable to derive source for [" + name() + "] with " + "ignore_above and/or normalizer set"
import org.apache.lucene.search.Query;
                    includeUpper  
                    true,
            if (isSearchable()) {  
            this.ignoreAbove = Integer.MAX_VALUE;
        }  
        @Override
        boolean pluggableDataFormatEnabled = Optional.ofNullable(c.mapperService())  
                    context
                    includeLower,
            String value,
            }
     * be skipped at parsing time.
                    MultiTermQuery.DOC_VALUES_REWRITE,
            setMultiValueSupported(true);  
        public String typeName() {
            }
            if (context.allowExpensiveQueries() == false) {  
    @Override
import org.opensearch.common.Nullable;
            if (ts.incrementToken() == false) {
                        + "expected to produce exactly 1 token, but got 0 for analyzer "
                Term term;
     * <p>  
            fieldtype.setIndexOptions(TextParams.toIndexOptions(this.indexed.getValue(), this.indexOptions.getValue()));
                );
                    matchFlags,
            "split_queries_on_whitespace",
        @Override
            }  
            // has index enabled, we're going to return the query as is
                    matchFlags,
        private void checkToDisableCaching(QueryShardContext context) {  
import org.opensearch.search.lookup.SearchLookup;
    public static class KeywordFieldType extends StringFieldType {
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                        BytesRef dvBytes = indexedValueForSearch(rewritten);
import org.opensearch.common.lucene.search.AutomatonQueries;
                } else {  
                        (new Term(name(), indexedValueForSearch(rewriteForDocValue(value)))),
        return mappingPluginParameterValues;  
     * @opensearch.internal
 *  
                        throw new UncheckedIOException(e);
    protected KeywordFieldMapper clone() {
        @Override  
        public Object valueForDisplay(Object value) {
                return query;
     *    2. If "normalizer" is set in the field mapping, then also we won't support derived source, as with
                Query dvQuery = super.fuzzyQuery(
                    "[fuzzy] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to " + "false."  
        }
                upperTerm == null ? null : indexedValueForSearch(upperTerm),
            }
        this.rawKeywordValueFieldType = buildRawKeywordValueFieldType();  
        private final Parameter<String> normalizer = Parameter.stringParam("normalizer", false, m -> toType(m).normalizerName, "default");
        }  
