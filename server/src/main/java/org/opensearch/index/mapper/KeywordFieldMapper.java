                    nullValue,
            value = context.externalValue().toString();
                Query query = super.termQuery(value, context);
                if (normalizer == null) {
            return indexAnalyzer();
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                return null;
            if (hasDocValues()) {
            if (isSearchable() && hasDocValues()) {
                    stored,
                if (splitQueriesOnWhitespace.getValue()) {
     * 2. If doc_values is disabled in field mapping, then build source using stored field
            "index_options",
                new TextSearchInfo(fieldType, null, Lucene.KEYWORD_ANALYZER, Lucene.KEYWORD_ANALYZER),
            if (context.allowExpensiveQueries() == false) {
import org.opensearch.common.Nullable;
    private final boolean hasDocValues;
            if (isSearchable() && hasDocValues()) {
            }
            failIfNotIndexedAndNoDocValues();
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
            // keywords are internally stored as utf8 bytes
    private final String normalizerName;
                    lowerTerm == null ? null : indexedValueForSearch(rewriteForDocValue(lowerTerm)),
import org.apache.lucene.search.FuzzyQuery;
        this.fieldType = fieldType;
        public Query termsQuery(List<?> values, QueryShardContext context) {
                for (Object value : values) {
        return new DerivedFieldGenerator(
                    normalizer,
                if (dVByteRefs == null) { // index and docValues are the same, pack them once
                value = nullValue;
        return new Builder(n, c.getIndexAnalyzers(), pluggableDataFormatEnabled, pluginParameters);
            }
                term = new Term(name(), (String) rewriteForDocValue(value));
    @Override
            return getTextSearchInfo().getSearchAnalyzer().normalize(name(), value.toString());
    /**
                    }
            } else if (splitQueriesOnWhitespace.getValue()) {
        private final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> toType(m).similarity);
            Object value,
    private static KeywordFieldMapper toType(FieldMapper in) {
    private final String indexOptions;
        private final int ignoreAbove;
                Query query = SortedSetDocValuesField.newSlowRangeQuery(
                    fuzziness.asDistance(BytesRefs.toString(rewriteForDocValue(value))),
                        return normalizeValue(normalizer, name(), keywordValue);
            "split_queries_on_whitespace",
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
    @Override
        this.useSimilarity = builder.useSimilarity.getValue();
            if (Objects.equals(normalizerName, "default") == false) {
            failIfNotIndexedAndNoDocValues();
    }
            failIfNotIndexedAndNoDocValues();
            value = normalizeValue(normalizer, name(), value);
        }
    @Override
                Query indexQuery = super.prefixQuery(value, method, caseInsensitive, context);
                    name(),
            if (context.allowExpensiveQueries() == false) {
                    }
        protected KeywordFieldType buildFieldType(BuilderContext context, FieldType fieldType) {
            this.indexAnalyzers = indexAnalyzers;
                    includeUpper
                                dVByteRefs.accept(dvBytesOld);
                }
                        }
                    maxDeterminizedStates,
                if (caseInsensitive) {
            .orElse(false);
        String value;
            checkToDisableCaching(context);
            return new KeywordFieldType(buildFullName(context), fieldType, normalizer, searchAnalyzer, this);
        public KeywordFieldMapper build(BuilderContext context) {
            return List.copyOf(parameters);
            setEagerGlobalOrdinals(builder.eagerGlobalOrdinals.getValue());
            "eager_global_ordinals",
                            dVByteRefs = new BytesRefsCollectionBuilder(values.size());
            FIELD_TYPE.setTokenized(false);
            this.nullValue = null;
    @Override
            this.useSimilarity = false;
        private final Parameter<MappedFieldType.MultiValueState> multiValue = multiValueParameter();
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
            List<Parameter<?>> parameters = new ArrayList<>(
     *    1. When using doc values, for multi value field, result would be deduplicated and in sorted order
                    new Term(name(), indexedValueForSearch(rewriteForDocValue(value))),
         * multi-valued, so the flag matters only to pluggable formats whose column type is
     *    2. If "normalizer" is set in the field mapping, then also we won't support derived source, as with
            }
import java.util.List;
                return new TermRangeQuery(
 *
            ? List.of()
 * specific language governing permissions and limitations
                    (String) rewriteForDocValue(value),
     * Values that have more chars than the return value of this method will
        @Override
            mappedFieldType,
                    caseInsensitive,
import java.io.IOException;
    private final List<Parameter<?>> mappingPluginParameters;
        return mappingPluginParameterValues;
            this.canConsumeRawValueForSource = canConsumeRawValueForSource;
                for (int i = 0; i < values.size(); i++) {
            String value,
                )
                // in that case we skip normalization, which may be slow if there many terms need to
            NamedAnalyzer normalizer = Lucene.KEYWORD_ANALYZER;
            }
        String value = parseKeywordValue(context);
                        return keywordValue;
            this(name, isSearchable, hasDocValues, useSimilarity, false, meta);
                            for (int rewind = 0; rewind <= i; rewind++) {
                    searchAnalyzer = normalizer;
                    name(),
                    Query indexQuery = new TermInSetQuery(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, name(), iBytesRefs.get());
            return new KeywordFieldMapper(
            }
            setBoost(builder.boost.getValue());
                }
            }
     *    1. If "ignore_above" is set in the field mapping, then we won't be supporting derived source for now,
        this.hasDocValues = builder.hasDocValues.getValue();
    private final int ignoreAbove;
        }
                normalizer = indexAnalyzers.getNormalizer(normalizerName);
                }
    /**
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
import org.apache.lucene.document.Field;
            // keyword field types are always normalized, so ignore case sensitivity and force normalize the
            false,
        this.indexAnalyzers = builder.indexAnalyzers;
    }
                );
            return new TermRangeQuery(
    }
                    similarity,
        }
                    matchFlags,
                    return TermInSetQuery.newIndexOrDocValuesQuery(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, name(), iBytesRefs.get());
        public Query prefixQuery(
            this.nullValue.setValue(nullValue);
            checkToDisableCaching(context);
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
            this(name, isSearchable, hasDocValues, false, meta);
            this.splitQueriesOnWhitespace = splitQueriesOnWhitespace;
            );
                    BytesRef idxBytes = indexedValueForSearch(value);
                        + "\""
                throw new IllegalStateException(
            }
        ) {
            Integer.MAX_VALUE
                    prefixLength,
                copyTo.build(),
                return query;
        private final String nullValue;
                    (String) rewriteForDocValue(value),
            String name,
                    "[prefix] queries cannot be executed when '"
        @Override
                    return super.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
import java.util.Collections;
    }
            QueryShardContext context
            setMultiValueSupported(true);
import org.apache.lucene.document.SortedSetDocValuesField;
    /**
            @Nullable MultiTermQuery.RewriteMethod method,
        );
    }
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't " + "support formats.");
        }
                    return AutomatonQueries.caseInsensitivePrefixQuery(
            context.doc().add(field);
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                    context
            if (ts.incrementToken()) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        return null;
 *
    }
                            }
        }
            }
            );
import org.apache.lucene.analysis.TokenStream;
 * Modifications Copyright OpenSearch Contributors. See
            this.ignoreAbove.setValue(ignoreAbove);
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
                }
                    context
            .map(MapperService::getIndexSettings)
            fieldtype.setOmitNorms(this.hasNorms.getValue() == false);
        public Object valueForDisplay(Object value) {
        private final Parameter<Integer> ignoreAbove = Parameter.intParam(
            int syntaxFlags,
import org.opensearch.common.lucene.BytesRefs;
            KeywordFieldType rawValueType = new KeywordFieldType(
                return null;
            super(field, term, ft);
        @Override
            this(name, true, true, Collections.emptyMap());
                assert indexAnalyzers != null;
            this.nullValue = builder.nullValue.getValue();
        return value;
 * GitHub history for details.
            if (isSearchable() && hasDocValues()) {
            this.useSimilarity = builder.useSimilarity.getValue();
                        + "\""
        return value;
            return super.wildcardQuery(value, method, caseInsensitive, true, context);
            true,
        public Query wildcardQuery(
 */
            } else {
        this.mappingPluginParameterValues = builder.pluginMappingParameterValues();
        this.canConsumeRawValueForSource = builder.canConsumeRawValueForSource;
                "Unable to derive source for [" + name() + "] with " + "ignore_above and/or normalizer set"
            @Nullable MultiTermQuery.RewriteMethod method,
        }
                    NamedAnalyzer normalizer = normalizer();
            int matchFlags,
     * @opensearch.internal
                name(),
        private final Parameter<Boolean> eagerGlobalOrdinals = Parameter.boolParam(
        @Override
                        dVByteRefs.accept(dvBytes);
                );
import org.apache.lucene.search.MultiTermQuery;
                );
                this
        return normalizerName;
                        + "fields please enable [index_prefixes]."
                Term term;
 * ownership. Elasticsearch licenses this file to you under
            return;
                return new WildcardQuery(term, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT, MultiTermQuery.DOC_VALUES_REWRITE);
            }
            super(name, isSearchable, false, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                    return super.wildcardQuery(value, method, caseInsensitive, true, context);
                    "[range] queries on [text] or [keyword] fields cannot be executed when '"
            this(name, null, false);
                    indexedValueForSearch(rewriteForDocValue(value)),
        protected List<Parameter<?>> getParameters() {
     * <p>
        }
                    context
public final class KeywordFieldMapper extends ParametrizedFieldMapper {
                Query dvQuery = super.fuzzyQuery(
        public Builder(String name, IndexAnalyzers indexAnalyzers, boolean canConsumeRawValueForSource) {
                }
            FIELD_TYPE.setOmitNorms(true);
        );
        public Query fuzzyQuery(
                fieldType.indexOptions() != IndexOptions.NONE,
            failIfNoDocValues();
                    "[wildcard] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to " + "false."
                    MultiTermQuery.DOC_VALUES_REWRITE,
     * In such cases, storage layer would need to add another field which can be used for source generation
        public Builder docValues(boolean hasDocValues) {
            if (hasDocValues()) {
        ) {
        public KeywordFieldType(String name, FieldType fieldType) {
                    return AutomatonQueries.caseInsensitiveWildcardQuery(term, method);
    @Override
/*
import org.apache.lucene.search.WildcardQuery;
            }
                    MultiTermQuery.DOC_VALUES_REWRITE,
                createFieldNamesField(context);
                );
                                BytesRef dvBytesOld = indexedValueForSearch(rewrittenOld);
            rawValueType.setMultiValueState(multiValueState);
            }
                        BytesRef dvBytes = indexedValueForSearch(rewritten);
            ts.reset();
            setIndexAnalyzer(normalizer);
                searchAnalyzer = Lucene.WHITESPACE_ANALYZER;
    public static class KeywordFieldType extends StringFieldType {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        private final IndexAnalyzers indexAnalyzers;
                false,
                    AutomatonQueries.toCaseInsensitiveString(bytesRef.utf8ToString()),
                }
            // the default normalizer is a single KeywordTokenizer with no filters, so it always returns the input unchanged
                false,
        @Override
     * @opensearch.internal
            }
                    MultiTermQuery.DOC_VALUES_REWRITE
        return useSimilarity;
                    );
        } else {
import org.apache.lucene.util.automaton.Operations;
            int prefixLength,
    private final MappedFieldType.MultiValueState multiValueState;
import java.util.Optional;
            if (context.allowExpensiveQueries() == false) {
        MultiFields multiFields,
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BoostQuery;
            QueryShardContext context
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                );
                );
        }
        if (value != null) {
    }
        }
                buildFieldType(context, fieldtype),
import java.util.Objects;
import org.apache.lucene.search.ConstantScoreQuery;
            return;
            if (value == null) {
                    hasNorms,
        public Builder(
import org.opensearch.index.analysis.NamedAnalyzer;
            // has index and doc_values enabled
     */
        if (fieldType().hasDocValues()) {
                    return super.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);
                    } else {
            return binaryValue.utf8ToString();
import org.apache.lucene.search.RegexpQuery;
                if (!this.useSimilarity) {
            }
            this.ignoreAbove = Integer.MAX_VALUE;
            if (getTextSearchInfo().getSearchAnalyzer() == Lucene.KEYWORD_ANALYZER) {
        private final boolean splitQueriesOnWhitespace;
import org.opensearch.index.fielddata.IndexFieldData;
    public KeywordFieldType getRawValueFieldType() {
                // keyword analyzer with the default attribute source which encodes terms using UTF8
        Builder nullValue(String nullValue) {
                fieldType().meta()
     *    2. When using stored field, order and duplicate values would be preserved
        }
            // if we only have doc_values enabled, we construct a new query with doc_values re-written
     * @return sourceKeywordFieldType
                        + "expected to produce exactly 1 token, but got 2+ for analyzer "
    private boolean isIneligibleForGeneratingSource() {
            String normalizerName = this.normalizer.getValue();
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
    }
    /**
            } else {
                    query = new BoostQuery(query, boost());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            NamedAnalyzer searchAnalyzer = Lucene.KEYWORD_ANALYZER;
        }
    }
        return CONTENT_TYPE;
            }
     * 1. If it has doc values, build source using doc values
    public static class KeywordField extends Field {
                    MultiTermQuery.DOC_VALUES_REWRITE,
                }
                return query;
        if (isIneligibleForGeneratingSource() && canConsumeRawValueForSource) {
    }
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
        super(simpleName, mappedFieldType, multiFields, copyTo);
            if (useSimilarity || splitQueriesOnWhitespace) {
            // wildcard
        FieldType fieldType,
 * this file be licensed under the Apache-2.0 license or a
            if (fieldType().hasDocValues() == false && fieldType.omitNorms()) {
    private String parseKeywordValue(ParseContext context) throws IOException {
            new SortedSetDocValuesFetcher(mappedFieldType, simpleName()),
import org.apache.lucene.index.Term;
 * under the License.
        boolean pluggableDataFormatEnabled = Optional.ofNullable(c.mapperService())
                    splitQueriesOnWhitespace,
        }
            this.splitQueriesOnWhitespace = false;
        }
            fieldtype.setIndexOptions(TextParams.toIndexOptions(this.indexed.getValue(), this.indexOptions.getValue()));
        @Override
                    }
     * @opensearch.internal
                    iBytesRefs.accept(idxBytes);
import org.opensearch.OpenSearchException;
            false
     * @return normalizerName
                    term,
        @Override
    public String normalizerName() {
        this.rawKeywordValueFieldType = buildRawKeywordValueFieldType();
            );
        assert fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS) <= 0;
                    MultiTermQuery.DOC_VALUES_REWRITE,
        this.indexOptions = builder.indexOptions.getValue();
                    upperTerm == null ? null : indexedValueForSearch(upperTerm),
            checkToDisableCaching(context);
    @Override
        }
                name,
import java.util.Arrays;
            fieldtype.setStored(this.stored.getValue());
        if (rawKeywordValueFieldType != null && (textValue.length() > ignoreAbove || !Objects.equals(normalizerName, "default"))) {
            boolean transpositions,
                );
                    true,
            return value;
        private final boolean useSimilarity;
    protected String contentType() {
                }
        @Override
                                Object rewrittenOld = rewind < i ? rewriteForDocValue(values.get(rewind)) : rewritten;
        }
        if (value == null || value.length() > ignoreAbove) {
                    prefixLength,
                    lowerTerm == null ? null : indexedValueForSearch(rewriteForDocValue(lowerTerm)),
                value = ((BytesRef) value).utf8ToString();
                    throw new MapperParsingException("normalizer [" + normalizerName + "] not found for field [" + name + "]");
            }
            m -> toType(m).ignoreAbove,
                context.setIsCacheable(false);
                Query indexQuery = super.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
        try (TokenStream ts = normalizer.tokenStream(field, value)) {
                }
            setPluginMappingParameters(pluginParameters);
    static String normalizeValue(NamedAnalyzer normalizer, String field, String value) throws IOException {
                    includeLower,
     * <p>
                    upperTerm == null ? null : indexedValueForSearch(rewriteForDocValue(upperTerm)),
            @Nullable MultiTermQuery.RewriteMethod method,
    protected KeywordFieldMapper clone() {
        }
            boolean isSearchable,
     * The keyword field for the field mapper
    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.BytesRef;
        }
            return this;
                    query = new ConstantScoreQuery(super.termQuery(value, context));
                builder.meta.getValue()
            if (context.allowExpensiveQueries() == false) {
 * KIND, either express or implied.  See the License for the
        ) {
                if (boost() != 1f) {
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
import org.opensearch.common.lucene.search.AutomatonQueries;
            this.nullValue = null;
                    BytesRef dvBytes = indexedValueForSearch(rewriteForDocValue(value));
                    multiValue
                    maxExpansions,
        }
        }
        CopyTo copyTo,
            Field field = new KeywordField(fieldType().name(), binaryValue, fieldType);
                    new Term(name(), indexedValueForSearch(rewriteForDocValue(value))),
                fieldType.stored(),
                }
    }
import org.apache.lucene.search.PrefixQuery;
            }
                );
            this.ignoreAbove = builder.ignoreAbove.getValue();
                Query indexQuery = new TermRangeQuery(
            String name,
            boolean hasDocValues,
        @Override
    /**
                // This if statement will be used whenever a normalizer is NOT configured
     */
            }
 */
        // For derived source: store raw value separately when normalizer/ignore_above alters it.
                );
    }
    }
                    true,
                    RegexpQuery.DEFAULT_PROVIDER,
        return parseKeyword(value);
                    if (keywordValue.length() > ignoreAbove) {
import org.opensearch.core.xcontent.XContentParser;
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).fieldType.stored(), false);
        }
import org.opensearch.common.unit.Fuzziness;
        }
            );
                    includeLower,
                    searchAnalyzer = indexAnalyzers.getWhitespaceNormalizer(normalizerName);
            }
    private final KeywordFieldType rawKeywordValueFieldType;
    private final boolean useSimilarity;
            QueryShardContext context
     *       normalizer it is hard to regenerate original source
        }
            }
import java.util.Map;
                    MultiTermQuery.DOC_VALUES_REWRITE
            ts.end();
    protected DerivedFieldGenerator derivedFieldGenerator() {
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValue, null)
            if (value instanceof BytesRef) {
        }
                        return null;
        private final Parameter<Boolean> hasNorms = TextParams.norms(false, m -> toType(m).fieldType.omitNorms() == false);
            failIfNotIndexedAndNoDocValues();
        }
    @Override
            @Nullable MultiTermQuery.RewriteMethod method,
                return new PrefixQuery(
            }
        if (normalizer == Lucene.KEYWORD_ANALYZER) {
            FIELD_TYPE.freeze();
        MappedFieldType mappedFieldType,
        }
 * Licensed to Elasticsearch under one or more contributor
                    matchFlags,
                throw new OpenSearchException(
        NamedAnalyzer normalizer = fieldType().normalizer();
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, true);
        @Override
            true,
    @Override
        }
     * Considerations:
        }
            super(
                );
    private final boolean splitQueriesOnWhitespace;
                        (new Term(name(), indexedValueForSearch(rewriteForDocValue(value)))),
        public KeywordFieldType(String name, FieldType fieldType, NamedAnalyzer normalizer, NamedAnalyzer searchAnalyzer, Builder builder) {
        public KeywordFieldType(String name, NamedAnalyzer analyzer) {
            this.useSimilarity = false;
                    Query dvQuery = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, name(), dVByteRefs.get());
                    return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                    transpositions,
            this.splitQueriesOnWhitespace = builder.splitQueriesOnWhitespace.getValue();
            if (isSearchable() && hasDocValues()) {
                    syntaxFlags,
                        MultiTermQuery.DOC_VALUES_REWRITE
     * Returns the normalizer used for this keyword field.
import java.util.ArrayList;
        String value = parseKeyword(textValue);
        this.eagerGlobalOrdinals = builder.eagerGlobalOrdinals.getValue();
        @Override
    protected KeywordFieldMapper(
                        + " and input \""
            } else {
                Query dvQuery = super.prefixQuery(
            if (hasDocValues()) {
                if (caseInsensitive) {
                );
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                throw new OpenSearchException(
                    boost,
    }
            this.ignoreAbove = Integer.MAX_VALUE;
        return builder.init(this);
                            // first time index and dv are divergent
                Query dvQuery = super.regexpQuery(
            return this;
                    query = new BoostQuery(query, boost());
import org.opensearch.common.lucene.Lucene;
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
        private final Parameter<String> normalizer = Parameter.stringParam("normalizer", false, m -> toType(m).normalizerName, "default");
            new StoredFieldFetcher(mappedFieldType, simpleName())
            if (isSearchable() && hasDocValues()) {
            return this;
                return new RegexpQuery(
        private void checkToDisableCaching(QueryShardContext context) {
 * @opensearch.internal
        this.mappingPluginParameters = builder.pluginMappingParameters();
            );
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
                        + normalizer
import org.opensearch.index.IndexSettings;
        this.nullValue = builder.nullValue.getValue();
     */
            parameters.addAll(pluginMappingParameters());
            m -> toType(m).indexOptions,
                upperTerm == null ? null : indexedValueForSearch(upperTerm),
         */
                );
        ) {
                if (boost() != 1f) {
    public static class Builder extends ParametrizedFieldMapper.Builder {
                        + ALLOW_EXPENSIVE_QUERIES.getKey()
            return CONTENT_TYPE;
                Query dvQuery = super.wildcardQuery(
        }
                    includeUpper,
        Builder builder = new Builder(simpleName(), indexAnalyzers, canConsumeRawValueForSource, mappingPluginParameters);
                    syntaxFlags,
                    eagerGlobalOrdinals,
            final String newValue = termAtt.toString();
                multiFieldsBuilder.build(this, context),
                    lowerTerm == null ? null : indexedValueForSearch(lowerTerm),
                "_ignored_source." + fieldType().name(),
 */
    public KeywordFieldType fieldType() {
        if (context.externalValueSet()) {
            return super.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
        );
            boolean splitQueriesOnWhitespace,
import org.apache.lucene.search.IndexOrDocValuesQuery;
    });
            applyPluginParameterEffects();
/**
            Map<String, String> meta
    }
            this.useSimilarity = useSimilarity;
     */
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            this.ignoreAbove = Integer.MAX_VALUE;
        }
        public KeywordFieldType(
        Builder builder
            if (value == null) {
        this.similarity = builder.similarity.getValue();
                    Object rewritten = rewriteForDocValue(value);
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
            }
                BytesRefsCollectionBuilder dVByteRefs = null;
            if (isSearchable() && hasDocValues()) {
            // The companion carries the pre-normalization values for derived source, so it must
                throw new IllegalStateException(
                    useSimilarity,
    protected void parseCreateField(ParseContext context) throws IOException {
            failIfNotIndexedAndNoDocValues();
import java.io.UncheckedIOException;
            super(
                        + " and input \""
            // query text
                );
        @Override
                    "[regexp] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to " + "false."
    ) {
                    indexOptions,
            m -> toType(m).eagerGlobalOrdinals,
 * not use this file except in compliance with the License.
        }
        return this.ignoreAbove != Integer.MAX_VALUE || !Objects.equals(this.normalizerName, "default");
            }
            boolean caseInsensitive,
        }
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
                    indexedValueForSearch(rewriteForDocValue(value)),
    }
                    includeUpper,
                BytesRefsCollectionBuilder bytesCollector = new BytesRefsCollectionBuilder(values.size());
 */
    public static class Defaults {
            FieldType fieldtype = new FieldType(Defaults.FIELD_TYPE);
                return super.indexedValueForSearch(value);
                    MultiTermQuery.DOC_VALUES_REWRITE
/*
        @Override
            return super.termsQuery(values, context);
                includeUpper
            Fuzziness fuzziness,
     */
                // attributes through reflection
 * You may obtain a copy of the License at
        );
            return super.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);
            return value;
        public KeywordFieldType(String name, boolean isSearchable, boolean hasDocValues, boolean useSimilarity, Map<String, String> meta) {
                    hasDocValues,
                Arrays.asList(
            // mirror the parent's multi-value state or source reconstruction would lose values.
        @Override
                    "The normalization token stream is "
     *       considering for these cases we will need to have explicit stored field.
                        if (rewritten != value && !rewritten.equals(value)) {
        }
                        + "expected to produce exactly 1 token, but got 0 for analyzer "
         * Declares this field multi-valued for columnar data formats. Lucene is inherently
            if (format != null) {
        NamedAnalyzer normalizer() {
    public Map<String, Object> mappingPluginParameterValues() {
        String value = textValue(context);
            IndexAnalyzers indexAnalyzers,
            return this;
         * encounters a second stored value. The transition is one-way because existing LIST
                    ignoreAbove,
                    includeLower,
                @Override
     * Support:
            );
                lowerTerm == null ? null : indexedValueForSearch(lowerTerm),
        public static final FieldType FIELD_TYPE = new FieldType();
     */
                fieldtype,
                    MultiTermQuery.DOC_VALUES_REWRITE
                Term term = new Term(name(), bytesRef);
                    rewriteForDocValue(value),
    private final IndexAnalyzers indexAnalyzers;
import java.util.function.Supplier;
        }
        private final boolean canConsumeRawValueForSource;
            setMultiValueState(builder.multiValue.getValue());
        );
                    "[fuzzy] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to " + "false."
            }
    private final String nullValue;
            failIfNotIndexedAndNoDocValues();
                    upperTerm == null ? null : indexedValueForSearch(rewriteForDocValue(upperTerm)),
    }
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
            }
                );
        }
 *
                }
                Query indexQuery = super.wildcardQuery(value, method, caseInsensitive, true, context);
        public Builder ignoreAbove(int ignoreAbove) {
import org.apache.lucene.index.IndexOptions;
        return (KeywordFieldMapper) in;
        protected FieldTypeCapabilities.Capability searchCapability() {
                    meta,
                    return super.prefixQuery(value, method, caseInsensitive, context);
                        + ALLOW_EXPENSIVE_QUERIES.getKey()
            );
                return super.termQueryCaseInsensitive(value, context);
            int maxExpansions,
        }
                    bytesCollector.accept(dvBytes);
                Collections.emptyMap()
 *
        }
            XContentParser parser = context.parser();
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
import org.apache.lucene.document.FieldType;
            .map(IndexSettings::isPluggableDataFormatEnabled)
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {
        static {
                    "The normalization token stream is "
    private KeywordFieldType buildRawKeywordValueFieldType() {
        public String typeName() {
            if (hasDocValues()) {
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                        + "' is set to false. For optimised prefix queries on text "
        }
                }
                );
                        + "' is set to false."
                    (String) rewriteForDocValue(value),
                Query query = AutomatonQueries.createAutomatonQuery(
                throw new OpenSearchException(
                protected String parseSourceValue(Object value) {
     * Default parameters
        List<Parameter<?>> pluginParameters = c.dataFormatRegistry() == null
            return new SourceValueFetcher(name(), context, nullValue) {
                );
         * files cannot be interpreted as scalar columns.
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
        }
                        throw new UncheckedIOException(e);
                    try {
                    fuzziness,
        // convert to utf8 only once before feeding postings/dv/stored fields
                return new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, name(), bytesCollector.get());
                    indexed,
                } else {
        return (KeywordFieldMapper) super.clone();
                false,
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
                }
    private final FieldType fieldType;
                    context
                builder.hasDocValues.getValue(),
        Builder normalizer(String normalizerName) {
            }
    protected void canDeriveSourceInternal() {
        if (normalizer != null) {
    private final SimilarityProvider similarity;
                        + normalizer
        public Query termQuery(Object value, QueryShardContext context) {
    }
                if (boost() != 1f) {
                return new FuzzyQuery(
    @Override
                    MultiTermQuery.DOC_VALUES_REWRITE
                }
    private final boolean eagerGlobalOrdinals;
            return rawValueType;
import org.opensearch.search.lookup.SearchLookup;
     *
            List<Parameter<?>> pluginParameters
import org.opensearch.index.analysis.IndexAnalyzers;
            boolean caseInsensitive,
                    return super.termsQuery(values, context);
                true,
package org.opensearch.index.mapper;
                }
            "docs",
            if (hasDocValues()) {
        this.ignoreAbove = builder.ignoreAbove.getValue();
                new TextSearchInfo(fieldType, builder.similarity.getValue(), searchAnalyzer, searchAnalyzer),
            checkToDisableCaching(context);
        if (isIneligibleForGeneratingSource() && rawKeywordValueFieldType == null) {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
    }
        @Override
            String value,
        }
                fieldType.indexOptions() != IndexOptions.NONE,
            context.documentInput().addField(rawKeywordValueFieldType, textValue);
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), binaryValue));
     * be skipped at parsing time.
    public int ignoreAbove() {
            this(name, indexAnalyzers, canConsumeRawValueForSource);
        public KeywordFieldType(String name, boolean isSearchable, boolean hasDocValues, Map<String, String> meta) {
            false
            return super.prefixQuery(value, method, caseInsensitive, context);
        protected BytesRef indexedValueForSearch(Object value) {
        return ignoreAbove;
        final BytesRef binaryValue = new BytesRef(value);
            }
            final CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
                );
            .acceptsNull();
     * Field type for keyword fields
        }
    }
        return (KeywordFieldType) super.fieldType();
        String simpleName,
        if (value == null) {
            rawValueType.setMultiValueSupported(true);
                includeLower,
                    maxExpansions,
                throw new OpenSearchException(
import org.apache.lucene.search.TermInSetQuery;
            if (isSearchable()) {
                    transpositions,
        }
    private final boolean indexed;
            if (hasDocValues()) {
 * The OpenSearch Contributors require contributions made to
        ) {
/*
                name,
                        + value
        }
            this.normalizer.setValue(normalizerName);
        public KeywordField(String field, BytesRef term, FieldType ft) {
            "ignore_above",
            checkToDisableCaching(context);
                }
     * @opensearch.internal
                Query dvQuery = new TermRangeQuery(
}
        private final Parameter<Boolean> splitQueriesOnWhitespace = Parameter.boolParam(
                }
    }
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
            }
        }
 * this work for additional information regarding copyright
import org.opensearch.index.similarity.SimilarityProvider;
            // has index enabled, we're going to return the query as is
            boolean useSimilarity,
 * Unless required by applicable law or agreed to in writing,
        }
         * fixed per file. A scalar field can promote to multi-valued when indexing first
                false,
            this.splitQueriesOnWhitespace = false;
            : c.dataFormatRegistry().getPluginMappingParameters(CONTENT_TYPE, c.mapperService().getIndexSettings());
import org.opensearch.index.query.QueryShardContext;
                return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                    String keywordValue = value.toString();
        }
                    new Term(name(), indexedValueForSearch(rewriteForDocValue(value))),
                    }
        ) {
 * A field mapper for keywords. This mapper accepts strings and indexes them as-is.
    public static final String CONTENT_TYPE = "keyword";
            };
                Query indexQuery = super.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);
            super(name);
                return query;
        this.splitQueriesOnWhitespace = builder.splitQueriesOnWhitespace.getValue();
                BytesRef bytesRef = indexedValueForSearch(rewriteForDocValue(value));
 * compatible open source license.
            String value,
            if (context.allowExpensiveQueries() == false) {
        private final Parameter<Boolean> useSimilarity = Parameter.boolParam("use_similarity", true, m -> toType(m).useSimilarity, false);
            m -> toType(m).splitQueriesOnWhitespace,
                value = normalizeWildcardPattern(name(), value, getTextSearchInfo().getSearchAnalyzer());
     *
        this.normalizerName = builder.normalizer.getValue();
    private volatile boolean canConsumeRawValueForSource;
                    } catch (IOException e) {
        }
                    name(),
            }
                BytesRefsCollectionBuilder iBytesRefs = new BytesRefsCollectionBuilder(values.size());
                    Object value = values.get(i);
        }
    /**
        // Skip for multi-field sub-fields (name contains dot) — parent field stores the raw source.
        if (textValue == null) {
                throw new OpenSearchException(
                false,
                name,
            checkToDisableCaching(context);
        @Override
                        + value
            throw new UnsupportedOperationException(
    }
            failIfNotIndexedAndNoDocValues();
     */
            "freqs"
 * software distributed under the License is distributed on an
    /**
            }
     */
    /**
            failIfNotIndexedAndNoDocValues();
        checkStoredAndDocValuesForDerivedSource();
                value = parser.textOrNull();
    private String parseKeyword(String value) throws IOException {
import org.apache.lucene.search.TermRangeQuery;
        }
            if (ts.incrementToken() == false) {
            return newValue;
                    true
                    MultiTermQuery.DOC_VALUES_REWRITE
     * The builder for the field mapper
        }
                );
    boolean useSimilarity() {
            return null;
                    name(),
        public Query regexpQuery(
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                    caseInsensitive,
                    query = new BoostQuery(query, boost());
        public KeywordFieldType(String name) {
                );
                    if (dVByteRefs == null) { // needs to check
            checkToDisableCaching(context);
            // Mark the query as non-cacheable if the defaults for useSimilarity or splitQueriesOnWhitespace are not used.
            return Optional.of(DimensionType.ORDINAL);
            super(name, true, false, true, new TextSearchInfo(Defaults.FIELD_TYPE, null, analyzer, analyzer), Collections.emptyMap());
            }
            BytesRef binaryValue = (BytesRef) value;
                    maxDeterminizedStates,
        private final Parameter<String> indexOptions = Parameter.restrictedStringParam(
            this.hasDocValues.setValue(hasDocValues);
            this.nullValue = null;
            if (isSearchable()) {
            addFieldForPluggableFormat(context, value);
        this.indexed = builder.indexed.getValue();
        protected Object rewriteForDocValue(Object value) {
                } else {
    }
        return rawKeywordValueFieldType;
     * Keyword fields get ignored above a certain length and/or may get normalized.
                    if (normalizer == null) {
 * license agreements. See the NOTICE file distributed with
    }
            true,
            int maxDeterminizedStates,
        /**
        this.multiValueState = builder.multiValue.getValue();
        }
            boolean canConsumeRawValueForSource,
            QueryShardContext context
    private String textValue(ParseContext context) throws IOException {
     * The field type to be used for derived source use cases.
    private final Map<String, Object> mappingPluginParameterValues;
        private final Parameter<Float> boost = Parameter.boostParam();
                if (!context.keywordFieldIndexOrDocValuesEnabled()) {
        public Builder(String name) {
                // parse (eg. large terms query) since Analyzer.normalize involves things like creating
     *
            checkToDisableCaching(context);
        String textValue = textValue(context);
import org.opensearch.index.compositeindex.datacube.DimensionType;
