            FieldType fieldType = TextParams.buildFieldType(index, store, indexOptions, norms, termVectors);
        } else {
        int position = -1;
import org.opensearch.core.xcontent.XContentBuilder;
        }
     */
        return mpqb.build();
    protected static final class PrefixFieldMapper extends FieldMapper {
        public Builder fielddataFrequencyFilter(double min, double max, int segs) {
    }
            this.fieldData.setValue(fielddata);
                prefixFieldMapper.addField(context, value);
            builder.field("min_segment_size", minSegmentSize);
        mapperBuilder.analyzers.indexAnalyzer.toXContent(builder, includeDefaults);
        }
        private boolean fielddata;
            throw new UnsupportedOperationException();
            }
            } else {
             * or a multi-field). This way search will continue to work on old indices and new indices
        public String typeName() {
                if (termAtt.getBytesRef() == null) {
            Term[] posTerms = terms[i];
        SpanNearQuery.Builder spanQuery = new SpanNearQuery.Builder(field, true);
 * SPDX-License-Identifier: Apache-2.0
             * will use the expected full name.
                        new SpanTermQuery(new Term(prefixField, posTerms[0].bytes())),
                    FieldMaskingSpanQuery fieldMask = new FieldMaskingSpanQuery(
import org.apache.lucene.search.MultiTermQuery;
        final Parameter<Integer> positionIncrementGap = Parameter.intParam(
     *
import org.apache.lucene.queries.spans.SpanQuery;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        }
            currentTerms.add(new Term(field, termAtt.getBytesRef()));
            PositionIncrementAttribute posIncAtt = stream.getAttribute(PositionIncrementAttribute.class);
        public String toString() {
            FielddataFrequencyFilter that = (FielddataFrequencyFilter) o;
                } else {
        }
                }
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
            return this;
    /**
            return this;
         * The default position_increment_gap is set to 100 so that phrase
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        public Builder store(boolean store) {
     * @opensearch.internal
        this.prefixFieldMapper = prefixFieldMapper;
        private final Analyzer delegate;
 * A {@link FieldMapper} for full-text fields.
            super(name, indexed, stored, false, tsi, meta);
                        + "field data like aggregations and sorting, so these operations are disabled by default. Please use a "
        public boolean equals(Object o) {
        @Override
            return this;
import org.opensearch.index.analysis.IndexAnalyzers;
                position += posIncrAtt.getPositionIncrement();
                return new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixFieldType.name(), indexedValueForSearch(value))), name());
import org.apache.lucene.util.automaton.Operations;
            }
        @Override
            public FieldValueType getDerivedFieldPreference() {
        }
        }
            setAnalyzer(parent.indexAnalyzer());
        }
 * license agreements. See the NOTICE file distributed with
    @Override
        final TextFieldType parent;
                name,
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            TextSearchInfo tsi = new TextSearchInfo(fieldType, similarity.getValue(), searchAnalyzer, searchQuoteAnalyzer);
        builder.add(currentTerms.toArray(new Term[0]), position);
                    indexOptions,
        mpqb.setSlop(slop);
                this
 * under the License.
                BytesRef normalizedTerm = analyzer.normalize(name(), text);
        @Override
     *
            if (posInc > 1) {
                    termVectors,
            false
    /**
            if (analyzer == null) {
            throw new UnsupportedOperationException();
     * Frequency filter for field data
     * Field type for phrase fields
        @Override
    public static class Defaults {
            stream.reset();
            return CONTENT_TYPE;
        }
        private FielddataFrequencyFilter(double minFreq, double maxFreq, int minSegmentSize) {
        private final Analyzer delegate;
                        field
        return CONTENT_TYPE;
     *
        protected TextFieldType buildFieldType(FieldType fieldType, BuilderContext context) {
            String field = name();
 *
        PrefixWrappedAnalyzer(Analyzer delegate, int minChars, int maxChars, int positionIncrementGap) {
            }
            false
    protected final Version indexCreatedVersion;
                return builder;
        @Override
            tft.setPrefixFieldType(prefixFieldType);
     */
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {
        List<Term> currentTerms = new ArrayList<>();
import org.opensearch.index.analysis.NamedAnalyzer;
import org.apache.lucene.queries.intervals.Intervals;
            if (phraseFieldMapper != null) {
                // frequencies are not needed because prefix queries always use a constant score
            FIELD_TYPE.setOmitNorms(false);
    private final int positionIncrementGap;
        this.indexCreatedVersion = builder.indexCreatedVersion;
        @Override
        public static final int INDEX_PREFIX_MAX_CHARS = 5;
            }
                && Double.compare(that.maxFreq, maxFreq) == 0
        public int hashCode() {
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
                && value.length() <= prefixFieldType.maxChars
            if (maxChars >= 20) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
            if (indexPhrases && slop == 0 && hasGaps(stream) == false) {
     * Field type for prefix fields
        protected void parseCreateField(ParseContext context) {
        void addField(ParseContext context, String value) {
             * to build prefix field names so we preserve the name that was used at creation time
                    return super.termQueryCaseInsensitive(value, context);
                || method == MultiTermQuery.CONSTANT_SCORE_REWRITE
            setPluginMappingParameters(pluginParameters);
                .map(p -> new PrefixConfig(p.minChars, p.maxChars))
            return SourceValueFetcher.toString(name(), context, format);
        if (fieldType.indexOptions() == IndexOptions.NONE && fieldType().fielddata()) {
        }
        @Override
     *
        final int minChars;
            builder.endObject();
        private boolean indexPhrases = false;
        public Query existsQuery(QueryShardContext context) {
        public int hashCode() {
        public IntervalsSource intervals(String text, int maxGaps, IntervalMode mode, NamedAnalyzer analyzer, boolean prefix)
        protected final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).fieldType.stored(), false);
                sb.append("?");
                return null;
                .build();
    }
 * You may obtain a copy of the License at
import org.apache.lucene.search.BooleanClause;
                automata.add(AutomatonQueries.toCaseInsensitiveString(value));
            PrefixFieldType prefixFieldType = new PrefixFieldType(tft, fullName + "._index_prefix", indexPrefixes.get());
            super(name);
    protected static final class PhraseFieldMapper extends FieldMapper {
        }
     * @opensearch.internal
        this.mappingPluginParameterValues = builder.pluginMappingParameterValues();
        }
            if (i == lastPos) {
    /**
    private static TextFieldMapper toType(FieldMapper in) {
            this.maxChars = maxChars;
            return new PagedBytesIndexFieldData.Builder(
        final Parameter<Boolean> eagerGlobalOrdinals = Parameter.boolParam(
            return false;
    public static Query createPhraseQuery(TokenStream stream, String field, int slop, boolean enablePositionIncrements) throws IOException {
            builder.field("max", maxFreq);
        public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
        TextFieldType mappedFieldType,
import org.apache.lucene.search.MultiPhraseQuery;
            }
        @Override
     */
    @Override
            TextFieldType ft = new TextFieldType(buildFullName(context), index.getValue(), store.getValue(), tsi, meta.getValue());
import org.apache.lucene.document.Field;
            }
        @Override
                    spanQuery.addClause(new SpanTermQuery(posTerms[0]));
                ft.setFielddata(true, freqFilter.getValue());
    /**
    private final String termVectors;
        context.documentInput().addField(fieldType(), value);
        @Override
        final double minFreq;
                return Intervals.fixField(name(), Intervals.term(term));
        assert mappedFieldType.getTextSearchInfo().isTokenized();
            }
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
        Builder mapperBuilder = (TextFieldMapper.Builder) getMergeBuilder();
            }
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
     */
import java.util.Arrays;
 */
            position += positionIncrement;
        mapperBuilder.indexPrefixes.toXContent(builder, includeDefaults);
            if (indexPhrases.get() == false) {
        public String typeName() {
            context.doc().add(new Field(fieldType().name(), value, fieldType));
        @Override
         * queries of reasonably high slop will not match across field values.
 * this work for additional information regarding copyright
            return filter.maxFreq;
            if (getTextSearchInfo().hasPositions() == false) {
        }
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {
                    throw new IllegalStateException("Null term while building phrase query");
        }
import java.util.function.Supplier;
        }
            true,
/*
        protected Analyzer getWrappedAnalyzer(String fieldName) {
                stream = new FixedShingleFilter(stream, 2);
    private static class PhraseWrappedAnalyzer extends AnalyzerWrapper {
        int maxExpansions,
            if (positionIncrement > 0 && multiTerms.size() > 0) {
        }
    private static FielddataFrequencyFilter parseFrequencyFilter(String name, ParserContext parserContext, Object node) {
            IntervalBuilder builder = new IntervalBuilder(name(), analyzer == null ? getTextSearchInfo().getSearchAnalyzer() : analyzer);
     */
 * software distributed under the License is distributed on an
    }
            return new TextFieldMapper(
    ) throws IOException {
        protected List<Parameter<?>> getParameters() {
    @Override
    public Map<String, Object> mappingPluginParameterValues() {
     * A prefix wrapped analyzer
        @Override
            } else {
                throw new IllegalArgumentException(
                } else {
        }
        protected FieldTypeCapabilities.Capability searchCapability() {
            throws IOException {
            false,
            return;
        PrefixFieldType(TextFieldType parentField, String name, PrefixConfig config) {
            m -> toType(m).mappedFieldType.eagerGlobalOrdinals(),
import org.apache.lucene.analysis.tokenattributes.BytesTermAttribute;
                    builder.add(currentTerms.toArray(new Term[0]), position);
import org.opensearch.common.lucene.Lucene;
            IntPredicate usePrefix = (len) -> len >= prefixFieldType.minChars && len <= prefixFieldType.maxChars;
        final Parameter<String> indexOptions = TextParams.indexOptions(m -> toType(m).indexOptions);
package org.opensearch.index.mapper;
        @Override
        if (enablePositionIncrements) {
                true,
        CopyTo copyTo,
                field = field + FAST_PHRASE_SUFFIX;
            true,
            }
            throw new IllegalArgumentException("Cannot enable fielddata on a [text] field that is not indexed: [" + name() + "]");
        stream.reset();
        PhraseFieldType(TextFieldType parent) {
    }
            this(name, Version.CURRENT, indexAnalyzers);
            applyPluginParameterEffects();
            return ft;
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
        }
                Arrays.asList(
            this(parentField, name, config.minChars, config.maxChars);
        if (context.externalValueSet()) {
        int minSegmentSize = XContentMapValues.nodeIntegerValue(frequencyFilter.remove("min_segment_size"), 0);
            if (prefixFieldType != null
            // https://issues.apache.org/jira/browse/LUCENE-8916
                SpanMultiTermQueryWrapper<?> spanMulti = new SpanMultiTermQueryWrapper<>(
                if (posTerms.length == 1) {
     * A phrase wrapped field analyzer
            );
        final Parameter<PrefixConfig> indexPrefixes = new Parameter<>(
        }
 *
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
     * @opensearch.internal
    private final PhraseFieldMapper phraseFieldMapper;
            }
}
                    throw new IllegalArgumentException(
        @Override
        final String value = getFieldValue(context);
            return "{ min_chars=" + minChars + ", max_chars=" + maxChars + " }";
    public static class TextFieldType extends StringFieldType {
        int slop,
            }
        }
            throw new UnsupportedOperationException();
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
     */
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
            this.positionIncrementGap = positionIncrementGap;
        return (TextFieldType) super.fieldType();
            builder.setSlop(slop);
    protected String contentType() {
        stream.reset();
        private final int minChars;
                    AnalyzerScope.INDEX,
        @Override
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;
    protected void parseCreateField(ParseContext context) throws IOException {
        mapperBuilder.similarity.toXContent(builder, includeDefaults);
            }
                .orElse(null)
            super(name, true, false, false, parent.getTextSearchInfo(), Collections.emptyMap());
    @Override
        }
        mapperBuilder.eagerGlobalOrdinals.toXContent(builder, includeDefaults);
        DocumentMapperParser.checkNoRemainingFields(propName, indexPrefix, parserContext.indexVersionCreated());
        public void setFielddata(boolean fielddata) {
            pft.setOmitNorms(true);
        }
 * Licensed to Elasticsearch under one or more contributor
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            FIELD_TYPE.setStored(false);
        static {
        Defaults.FIELDDATA_MAX_FREQUENCY,
        List<Parameter<?>> pluginParameters = c.dataFormatRegistry() == null
        );
                builder.add(new Term(field, termAtt.getBytesRef()), position);
            return builder.analyzeText(text, maxGaps, mode);
    private final SimilarityProvider similarity;
        if (terms.length == 1) {
    /**
            : c.dataFormatRegistry().getPluginMappingParameters(CONTENT_TYPE, c.mapperService().getIndexSettings());
        protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                throw new IllegalArgumentException("Cannot set index_phrases on field [" + name() + "] if positions are not enabled");
        public String typeName() {
    public static final String CONTENT_TYPE = "text";
                multiFieldsBuilder.build(this, context),
    private final List<Parameter<?>> mappingPluginParameters;
        }
 * not use this file except in compliance with the License.
    @Override
    @Override
                || (context.indexSettings().getAsBoolean(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)
            this.minSegmentSize = minSegmentSize;
        int position = -1;
            return;
            if (indexPrefixes.get() == null) {
        public static final FieldType FIELD_TYPE = new FieldType();
        public Query existsQuery(QueryShardContext context) {
    }
        }
            return builder;
import org.apache.lucene.queries.intervals.IntervalsSource;
            return delegate;
            List<Parameter<?>> parameters = new ArrayList<>(
    private final FielddataFrequencyFilter freqFilter;
        if (value == null) {
import org.apache.lucene.search.TermQuery;
                if (posIncAtt.getPositionIncrement() > 1) {
     * @opensearch.internal
            if (prefix) {
            PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);
            assert stream instanceof CachingTokenFilter;
        }
            this.multiFieldsBuilder.add(builder);
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its
    }
        protected final Parameter<Map<String, String>> meta = Parameter.metaParam();
            Arrays.stream(terms[0]).map(term -> new Term(prefixField, term.bytes())).forEach(sb::addTerm);
        public void setFielddata(boolean fielddata, FielddataFrequencyFilter filter) {
            () -> null,
        double fielddataMinFrequency() {
        }
            return fieldType().toString();
     */
            TextFieldMapper::parseFrequencyFilter,
            this.setFielddata(fielddata, DEFAULT_FILTER);
import org.opensearch.index.mapper.Mapper.TypeParser.ParserContext;
            }
    @Override
import org.apache.lucene.index.Term;
                    norms,
import java.util.ArrayList;
                        .map(term -> new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixField, term.bytes())), field))
        this.mappingPluginParameters = builder.pluginMappingParameters();
import org.apache.lucene.queries.spans.SpanNearQuery;
        return new PrefixConfig(minChars, maxChars);
                name,
            }
            setIndexAnalyzer(
import java.util.Iterator;
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * the Apache License, Version 2.0 (the "License"); you may
        public static final int INDEX_PREFIX_MIN_CHARS = 2;
import org.apache.lucene.analysis.TokenStream;
            }
        Defaults.FIELDDATA_MIN_SEGMENT_SIZE
        protected final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).mappedFieldType.isSearchable(), true);
        final int[] positions = builder.getPositions();
            if (fieldType.storeTermVectorOffsets()) {
            while (stream.incrementToken()) {
                    similarity,
        private final int positionIncrementGap;
        }
import org.apache.lucene.search.BooleanQuery;
import org.opensearch.core.xcontent.ToXContent;
     */
        int fielddataMinSegmentSize() {
            FIELD_TYPE.setTokenized(true);
            }
        void setAnalyzer(NamedAnalyzer delegate) {
            return SourceValueFetcher.toString(name(), context, format);
    protected void canDeriveSourceInternal() {}
        void setPrefixFieldType(PrefixFieldType prefixFieldType) {
            this.freqFilter.setValue(new FielddataFrequencyFilter(min, max, segs));
            String prefixField = prefixFieldType == null || slop > 0 ? null : prefixFieldType.name();
            return createPhrasePrefixQuery(stream, name(), slop, maxExpansions, prefixField, usePrefix);
import org.opensearch.index.query.IntervalMode;
        private final int maxChars;
                    mpqb.add(multiTerms.toArray(new Term[0]), position);
import java.io.IOException;
        MultiFields multiFields,
    }
        private PrefixFieldType prefixFieldType;
                indexed,
                searchQuoteAnalyzer = new NamedAnalyzer(searchQuoteAnalyzer, positionIncrementGap.get());
        public TextFieldMapper build(BuilderContext context) {
    @Override
        if (value == null) {
            }
    /**
            this.filter = filter;
            );
import org.apache.lucene.analysis.TokenFilter;
            if (this == o) return true;
        return (TextFieldMapper) super.clone();
                searchAnalyzer = new NamedAnalyzer(searchAnalyzer, positionIncrementGap.get());
        return new Builder(n, c.indexVersionCreated(), c.getIndexAnalyzers(), pluginParameters);
        this.indexOptions = builder.indexOptions.getValue();
            return Objects.hash(minChars, maxChars);
                return Intervals.prefix(term);
            }
        if (phraseFieldMapper != null) {
            multiTerms.add(new Term(field, termAtt.getBytesRef()));
        }
                || method == MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
            this.index.setValue(index);
            // the prefix field.
import org.apache.lucene.util.automaton.Automata;
            TokenFilter filter = new EdgeNGramTokenFilter(components.getTokenStream(), minChars, maxChars, false);
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
            this.maxFreq = maxFreq;
                    SpanQuery[] queries = Arrays.stream(posTerms)
        for (Term term : terms[lastPos]) {
    }
        Defaults.FIELDDATA_MIN_FREQUENCY,
            m -> toType(m).freqFilter
                currentTerms.clear();
            AutomatonQuery query = AutomatonQueries.createAutomatonQuery(new Term(name(), value + "*"), automaton, method);
    }
            }
                    && context.isMultiField() == false)) {
                        + name()
            stream.reset();
     * Field mapper for prefix fields
                stream = new FixedShingleFilter(stream, 2);
        }
            this.minChars = minChars;
            this.maxChars = maxChars;
        }
        List<Term> multiTerms = new ArrayList<>();
                if (fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS) < 0) {
        // Plugin-contributed parameters are not part of the fixed backwards-compatibility list above and are serialized explicitly.
        this.phraseFieldMapper = phraseFieldMapper;
            previousPos = positions[i];
    protected TextFieldMapper(
        }
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
    private final PrefixFieldMapper prefixFieldMapper;
        return Iterators.concat(super.iterator(), subIterators.iterator());
        @Override
        }
        PhraseWrappedAnalyzer(Analyzer delegate) {
                }
     */
            this.fielddata = fielddata;
        MultiPhrasePrefixQuery builder = new MultiPhrasePrefixQuery(field);
        protected final Parameter<Float> boost = Parameter.boostParam();
    }
                );
            String value = term.text();
                fieldType,
        String prefixField,
        IntPredicate usePrefixField
        );
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {
            }
    @Override
        protected String contentType() {
                if (posTerms.length == 1) {
            StringBuilder sb = new StringBuilder(term.utf8ToString());
                    fieldData,
        }
import org.apache.lucene.search.SynonymQuery;
                return super.prefixQuery(value, method, caseInsensitive, context);
            m -> toType(m).positionIncrementGap,
                filter.minSegmentSize,
            return minChars == that.minChars && maxChars == that.maxChars;
            TextFieldMapper::parsePrefixConfig,
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
        public TextFieldType(String name) {
        }
        while (stream.incrementToken()) {
        }
            ? List.of()
        @Override
        final int minSegmentSize;
            FIELD_TYPE.freeze();
            TextFieldType tft = buildFieldType(fieldType, context);
        List<Mapper> subIterators = new ArrayList<>();
                }
        }
        @Override
                false,
            }
        this.termVectors = builder.termVectors.getValue();
        );
    private final Map<String, Object> mappingPluginParameterValues;
                    new PrefixWrappedAnalyzer(delegate.analyzer(), minChars, maxChars, delegate.getPositionIncrementGap(analyzerName))
                name(),
        private FielddataFrequencyFilter filter;
        return new FielddataFrequencyFilter(minFrequency, maxFrequency, minSegmentSize);
            return Double.compare(that.minFreq, minFreq) == 0
            }
            return builder;
                    SpanTermQuery[] queries = Arrays.stream(posTerms).map(SpanTermQuery::new).toArray(SpanTermQuery[]::new);
        }
        mapperBuilder.index.toXContent(builder, includeDefaults);
     * Field mapper for phrase fields
                filter.minFreq,
        protected Analyzer getWrappedAnalyzer(String fieldName) {
        }
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        FieldType fieldType,
    });
        @Override
                buildPrefixMapper(context, fieldType, tft),
            return "phrase";
             * even if it is different from the expected one (in case the field is nested under an object
            if (fieldType.indexOptions() == IndexOptions.DOCS_AND_FREQS) {
        while (stream.incrementToken()) {
            return "phrase";
        return spanQuery.build();
        @Override
import java.util.List;
            builder.startObject();
     * @opensearch.internal
        mapperBuilder.meta.toXContent(builder, includeDefaults);
            } else {
                } else {
            return this;
                && minSegmentSize == that.minSegmentSize;
            ft.setBoost(boost.getValue());
            }
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePosIncrements) throws IOException {
        for (int i = 0; i < terms.length; i++) {
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its
                }
    }
    );
        }
            setIndexAnalyzer(new NamedAnalyzer(name, AnalyzerScope.INDEX, new PhraseWrappedAnalyzer(delegate)));
        public TextFieldType(String name, boolean indexed, boolean stored, TextSearchInfo tsi, Map<String, String> meta) {
        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
        @Override
        if (propNode == null) {
import org.apache.lucene.index.IndexOptions;
        }
            Field field = new Field(fieldType().name(), value, fieldType);
                throw new IllegalArgumentException("max_chars [" + maxChars + "] must be less than 20");
        final Parameter<FielddataFrequencyFilter> freqFilter = new Parameter<>(
                }
            this.minChars = minChars;
            ft.setEagerGlobalOrdinals(eagerGlobalOrdinals.getValue());
        this.multiFields.toXContent(builder, params);
            if (prefixFieldType == null || prefixFieldType.accept(value.length()) == false) {
            if (minChars < 1) {
        @Override
            this.maxChars = maxChars;
import java.util.Collections;
        MultiPhraseQuery.Builder mpqb = new MultiPhraseQuery.Builder();
        public Builder addMultiField(Mapper.Builder<?> builder) {
        TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
            // or if the incoming token stream is the output of a token graph due to
            FieldType phraseFieldType = new FieldType(fieldType);
 * this file be licensed under the Apache-2.0 license or a
        final String value = getFieldValue(context);
    }
        }
                    indexPhrases,
        ).acceptsNull();
import org.opensearch.index.similarity.SimilarityProvider;
        this.indexAnalyzers = builder.analyzers.indexAnalyzers;
                }
            builder.endObject();
        mapperBuilder.norms.toXContent(builder, includeDefaults);
/**
        }
        void setIndexPhrases() {
        mapperBuilder.termVectors.toXContent(builder, includeDefaults);
                spanMulti.setRewriteMethod(method);
            }
        mapperBuilder.indexOptions.toXContent(builder, includeDefaults);
            for (int i = term.length; i < minChars; i++) {
        protected String contentType() {
            false
        @Override
    private static final FielddataFrequencyFilter DEFAULT_FILTER = new FielddataFrequencyFilter(
            true,
        }
            if (fieldType.omitNorms()) {
        mapperBuilder.fieldData.toXContent(builder, includeDefaults);
            if (indexPhrases && slop == 0 && hasGaps(stream) == false && stream.hasAttribute(BytesTermAttribute.class) == false) {
                } else {
     */
                && value.length() >= prefixFieldType.minChars
            throw new UnsupportedOperationException();
            m -> Optional.ofNullable(((TextFieldType) toType(m).mappedFieldType).prefixFieldType)
import org.opensearch.search.lookup.SearchLookup;
         */
        }
    }
        public boolean equals(Object o) {
        }
     * Derive source using stored field, which would always be present for derived source enabled index field
            return Intervals.or(Intervals.fixField(name(), Intervals.wildcard(new BytesRef(wildcardTerm))), Intervals.term(term));
                if (caseInsensitive) {
                Collections.emptyMap()
                && prefixFieldType.getTextSearchInfo().hasPositions()) {
        final Parameter<Boolean> fieldData = Parameter.boolParam(
import java.util.function.IntPredicate;
        }
        }
        TokenStream stream,
            if (this == o) return true;
            "fielddata_frequency_filter",
                analyzer = getTextSearchInfo().getSearchAnalyzer();
     * Prefix configuration
        }
        final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> toType(m).similarity);
                        + "keyword field instead. Alternatively, set fielddata=true on ["
        final int minChars;
        }
import org.opensearch.index.analysis.AnalyzerScope;
        this.positionIncrementGap = builder.positionIncrementGap.getValue();
        }
            }
        this.copyTo.toXContent(builder, params);
 * compatible open source license.
        String field,
        protected PrefixFieldMapper buildPrefixMapper(BuilderContext context, FieldType fieldType, TextFieldType tft) {
            String fullName = buildFullName(context);
                );
                false,
import org.apache.lucene.document.FieldType;
        }
            this.minFreq = minFreq;
import org.apache.lucene.queries.spans.SpanOrQuery;
        }
                if (enablePosIncrements) {
                new TextSearchInfo(Defaults.FIELD_TYPE, null, Lucene.STANDARD_ANALYZER, Lucene.STANDARD_ANALYZER),
        TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
                    indexPrefixes,
            return "prefix";
    }
    }
        double fielddataMaxFrequency() {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
 * Unless required by applicable law or agreed to in writing,
                    analyzerName,
    }
            } else {
                context.doc().add(new Field(phraseFieldMapper.fieldType().name(), value, phraseFieldMapper.fieldType));
            if (term.length > maxChars) {
     *
        mapperBuilder.analyzers.searchQuoteAnalyzer.toXContent(builder, includeDefaults);
        public String toString() {
                pft.setStoreTermVectorOffsets(true);
import org.opensearch.index.query.QueryShardContext;
                throw new IllegalArgumentException("Cannot create intervals over field [" + name() + "] with no positions indexed");
            m -> ((TextFieldType) toType(m).mappedFieldType).indexPhrases,
            return null;
            // we can't use the index_phrases shortcut with slop, if there are gaps in the stream,
            );
                    position += 1;
            return new TokenStreamComponents(components.getSource(), filter);
        Builder builder = new Builder(simpleName(), this.indexCreatedVersion, this.indexAnalyzers, mappingPluginParameters);
            () -> DEFAULT_FILTER,
        private Query analyzePhrasePrefix(TokenStream stream, int slop, int maxExpansions) throws IOException {
        }
        builder.field("type", contentType());
            POSITION_INCREMENT_GAP_USE_ANALYZER
        }
     * @opensearch.internal
            setAnalyzer(parent.indexAnalyzer().name(), parent.indexAnalyzer().analyzer());
        }
            if (index.getValue() == false) {
            return super.iterator();
        }
        public boolean fielddata() {
    }
            }
 *
        if (prefixFieldMapper != null) {
            return createPhraseQuery(stream, field, slop, enablePositionIncrements);
            if (fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS) < 0) {
        @Override
    static final class PhraseFieldType extends StringFieldType {
        super(simpleName, mappedFieldType, multiFields, copyTo);
     */
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
            while (stream.incrementToken()) {
        final Term[][] terms = builder.getTerms();
                new NamedAnalyzer(
            builder.field("min_chars", minChars);
        }
                    positionIncrementGap,
        }
                }
        int lastPos = builder.getTerms().length - 1;
     */
            return analyzePhrasePrefix(stream, slop, maxExpansions);
 *
                filter.maxFreq,
        if (prefixField == null) {
            }
        Map<?, ?> indexPrefix = (Map<?, ?>) propNode;
        @Override
            this.parent = parent;
import org.apache.lucene.search.PrefixQuery;
        PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);
        }
                if (enablePositionIncrements) {
    /**
    @Override
import org.apache.lucene.search.PhraseQuery;
        }
        int minChars = XContentMapValues.nodeIntegerValue(indexPrefix.remove("min_chars"), Defaults.INDEX_PREFIX_MIN_CHARS);
        return mappingPluginParameterValues;
                        + "] in order to load "
 * GitHub history for details.
            }
                        + "field data by uninverting the inverted index. Note that this can use significant memory."
                field = field + FAST_PHRASE_SUFFIX;
import org.apache.lucene.queries.spans.SpanTermQuery;
        }
import org.apache.lucene.search.AutomatonQuery;
        @Override
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
            }
            if (posIncrAtt.getPositionIncrement() != 0) {
    @Override
            Query tq = prefixFieldType.prefixQuery(value, method, caseInsensitive, context);
            if (fieldData.getValue()) {
                automata.add(Automata.makeString(value));
        }
             */
        public static final double FIELDDATA_MIN_FREQUENCY = 0;
        }
        PhraseFieldMapper(FieldType fieldType, PhraseFieldType mappedFieldType) {
    public Iterator<Mapper> iterator() {
        }
        final int maxChars;
                copyTo.build(),
        protected PhraseFieldMapper buildPhraseMapper(FieldType fieldType, TextFieldType parent) {
        }
    static final class PrefixFieldType extends StringFieldType {
    private static class PrefixWrappedAnalyzer extends AnalyzerWrapper {
        @Override
                name,
                    );
                }
            super(delegate.getReuseStrategy());
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;
             * Mappings before v7.2.1 use {@link Builder#name} instead of {@link Builder#fullName}
            if (context.indexSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
            builder.field("max_chars", maxChars);
            return builder;
            }
            );
            fielddata = false;
        final double maxFreq;
                    analyzers.searchQuoteAnalyzer,
        }
        }
            mpqb.add(multiTerms.toArray(new Term[0]), position);
    /**
        for (Parameter<?> pluginMappingParameter : mapperBuilder.pluginMappingParameters()) {
        final TextFieldType parent;
            }
 * specific language governing permissions and limitations
            return new TokenStreamComponents(components.getSource(), new FixedShingleFilter(components.getTokenStream(), 2));
                throw new IllegalArgumentException("min_chars [" + minChars + "] must be less than max_chars [" + maxChars + "]");
        mapperBuilder.indexPhrases.toXContent(builder, includeDefaults);
import org.opensearch.index.IndexSettings;
import org.opensearch.index.fielddata.IndexFieldData;
            if (usePrefixField.test(value.length()) == false) {
            super(mappedFieldType.name(), fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());
    protected TextFieldMapper clone() {
                    analyzers.indexAnalyzer,
    }
    }
import org.apache.lucene.analysis.CachingTokenFilter;
            }
                }
            }
        PrefixFieldType(TextFieldType parent, String name, int minChars, int maxChars) {
    ) {
        public TextFieldType(String name, boolean indexed, boolean stored, Map<String, String> meta) {
            NamedAnalyzer indexAnalyzer = analyzers.getIndexAnalyzer();
            return delegate;
/*
     *
        builder.setMaxExpansions(maxExpansions);
                    return prefixFieldType.intervals(normalizedTerm);
            PhraseQuery.Builder builder = new PhraseQuery.Builder();
                    freqFilter,
 * ownership. Elasticsearch licenses this file to you under
import java.util.Objects;
        PrefixFieldMapper prefixFieldMapper,
                )
                CoreValuesSourceType.BYTES
        }
import org.apache.lucene.util.BytesRef;
                return super.termQuery(value, context);
        }
            SynonymQuery.Builder sb = new SynonymQuery.Builder(prefixField);
            context.doc().add(field);
        return (TextFieldMapper) in;
        PrefixConfig(int minChars, int maxChars) {
            int positionIncrement = posIncrAtt.getPositionIncrement();
    }
                pft.setIndexOptions(fieldType.indexOptions());
     *
            return context.externalValue().toString();
    }
            if (term.length >= minChars) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        PhraseFieldMapper phraseFieldMapper,
        @Override
import java.util.Map;
                return spanMulti;
            if (value.length() >= minChars) {
            return builder.build();
            }
        /**
        @Override
        double maxFrequency = XContentMapValues.nodeDoubleValue(frequencyFilter.remove("max"), Integer.MAX_VALUE);
     * @opensearch.internal
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
     * @opensearch.internal
            this.parent = parent;
                throw new IllegalArgumentException("Cannot set index_prefixes on unindexed field [" + name() + "]");
    protected static final int POSITION_INCREMENT_GAP_USE_ANALYZER = -1;
            this.indexPhrases = true;
                buildPhraseMapper(fieldType, tft),
            String wildcardTerm = sb.toString();
            if (o == null || getClass() != o.getClass()) return false;
        @Override
        builder.setSlop(slop);
        }
    protected final FieldType fieldType;
            parameters.addAll(pluginMappingParameters());
                }
            }
        @Override
        }
                    return true;
            NamedAnalyzer searchAnalyzer = analyzers.getSearchAnalyzer();
        );
        public Builder(String name, Version indexCreatedVersion, IndexAnalyzers indexAnalyzers, List<Parameter<?>> pluginParameters) {
        }
    protected String getFieldValue(ParseContext context) throws IOException {
        final TextParams.Analyzers analyzers;
            // Copy the index options of the main field to allow phrase queries on
        this.fieldType = fieldType;
            return length >= minChars - 1 && length <= maxChars;
            // parent field in _source. So we don't need to use the parent field name here.
            return this;
        @Override
            return Objects.hash(minFreq, maxFreq, minSegmentSize);
            pluginMappingParameter.toXContent(builder, includeDefaults);
        }
import org.apache.lucene.search.ConstantScoreQuery;
        }
                spanQuery.addGap(posInc - 1);
            }
            if (prefixFieldMapper != null) {
            return "prefix";
        }
        } else {
            if (method == null
        mapperBuilder.positionIncrementGap.toXContent(builder, includeDefaults);
            List<Automaton> automata = new ArrayList<>();
            subIterators.add(prefixFieldMapper);
        );
        public Builder index(boolean index) {
            Automaton automaton = Operations.concatenate(automata);
     *
                    eagerGlobalOrdinals,
    public TextFieldType fieldType() {
                )
                throw new IllegalArgumentException("Cannot create intervals over a field [" + name() + "] without indexed positions");
    }
            "fielddata",
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
    }
        final int maxChars;
     * Default paramters for text fields
        Builder builder
        public String toString() {
        }
                    analyzers.searchAnalyzer,
        }
        }
        }
        this.freqFilter = builder.freqFilter.getValue();
        mapperBuilder.boost.toXContent(builder, includeDefaults);
        }
            this.delegate = delegate;
    @Override
 */
                pft.setIndexOptions(IndexOptions.DOCS);
        assert mappedFieldType.hasDocValues() == false;
            NamedAnalyzer searchQuoteAnalyzer = analyzers.getSearchQuoteAnalyzer();
                createFieldNamesField(context);
                    meta
            return super.toString() + ",prefixChars=" + minChars + ":" + maxChars;
 */
    }
    }
        @Override
        }
        this.similarity = builder.similarity.getValue();
                return null;
        @Override
            }
            if (fielddata == false) {
            "index_prefixes",
        }
            return context.parser().textOrNull();
            "eager_global_ordinals",
/*
    /**
            mpqb.add(multiTerms.toArray(new Term[0]));
            parent.setIndexPhrases();
        }
            @Override
            return new BooleanQuery.Builder().add(query, BooleanClause.Occur.SHOULD)
            if (positionIncrementGap.get() != POSITION_INCREMENT_GAP_USE_ANALYZER) {
                meta
                        .toArray(SpanQuery[]::new);
     * @opensearch.internal
                fieldType.setStored(true);
     *
                throw new IllegalArgumentException("min_chars [" + minChars + "] must be greater than zero");
        }
        }
        }
        @Override
            this(
        final Parameter<Boolean> indexPhrases = Parameter.boolParam(
        @Override
        }
            return new PrefixFieldMapper(pft, prefixFieldType);
        public int getPositionIncrementGap(String fieldName) {
                    index,
        final Parameter<String> termVectors = TextParams.termVectors(m -> toType(m).termVectors);
        return builder.init(this);
            this.minChars = minChars;
        @Override
        final Parameter<Boolean> norms = TextParams.norms(true, m -> toType(m).fieldType.omitNorms() == false);
     * Field type for text fields
            this.store.setValue(store);
import org.opensearch.common.xcontent.support.XContentMapValues;
import org.apache.lucene.analysis.AnalyzerWrapper;
        }
        @Override
    public static class Builder extends ParametrizedFieldMapper.Builder {
        DocumentMapperParser.checkNoRemainingFields(name, frequencyFilter, parserContext.indexVersionCreated());
        @Override
        spanQuery.setSlop(slop);
            fielddata = false;
            return tq;
    protected static final class FielddataFrequencyFilter implements ToXContent {
    public static Query createPhrasePrefixQuery(
import org.apache.lucene.search.Query;
            return positionIncrementGap;
            return new PhraseFieldMapper(phraseFieldType, new PhraseFieldType(parent));
                stored,
    protected final IndexAnalyzers indexAnalyzers;
public class TextFieldMapper extends ParametrizedFieldMapper {
        int previousPos = -1;
                tft,
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
                indexAnalyzer = new NamedAnalyzer(indexAnalyzer, positionIncrementGap.get());
        Map<?, ?> frequencyFilter = (Map<?, ?>) node;
            return filter.minSegmentSize;
            return "{ min=" + minFreq + ", max=" + maxFreq + ", min_segment_size=" + minSegmentSize + " }";
        }
    /**
    protected static final class PrefixConfig implements ToXContent {
        }
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
        public String toString() {
            builder.startObject();
        mapperBuilder.freqFilter.toXContent(builder, includeDefaults);
            String analyzerName = delegate.name();
            "index_phrases",
 * @opensearch.internal
    protected DerivedFieldGenerator derivedFieldGenerator() {
                    boost,
        if (subIterators.size() == 0) {
     * Builder for text fields
                throw new IllegalArgumentException("Cannot set index_phrases on unindexed field [" + name() + "]");
            super(parent.name() + FAST_PHRASE_SUFFIX, true, false, false, parent.getTextSearchInfo(), Collections.emptyMap());
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            );
                return FieldValueType.STORED;
        protected PrefixFieldMapper(FieldType fieldType, PrefixFieldType mappedFieldType) {
        PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);
                .add(new TermQuery(new Term(parent.name(), value)), BooleanClause.Occur.SHOULD)
            int position = -1;
            String field = name();
            FIELD_TYPE.setStoreTermVectors(false);
                    spanQuery.addClause(new SpanOrQuery(queries));
        }
            if (caseInsensitive) {
        String simpleName,
     * @opensearch.internal
            return SourceValueFetcher.toString(name(), context, format);
        void setAnalyzer(String name, Analyzer delegate) {
        private final Version indexCreatedVersion;
            super(delegate.getReuseStrategy());
                if (prefixFieldType != null) {
                    spanQuery.addClause(new SpanOrQuery(queries));
 * KIND, either express or implied.  See the License for the
            }
                    "Text fields are not optimised for operations that require per-document "
    /**
                    new PrefixQuery(new Term(name(), indexedValueForSearch(value)))
            throw new UnsupportedOperationException();
        return new DerivedFieldGenerator(mappedFieldType, null, new StoredFieldFetcher(mappedFieldType, simpleName())) {
            this.analyzers = new TextParams.Analyzers(indexAnalyzers);
                return new ConstantScoreQuery(tq);
     *
 * The OpenSearch Contributors require contributions made to
            return filter.minFreq;
            if (o == null || getClass() != o.getClass()) return false;
            if (minChars > maxChars) {
        public static final int POSITION_INCREMENT_GAP = 100;
                    store,
    static PrefixConfig parsePrefixConfig(String propName, ParserContext parserContext, Object propNode) {
        int maxChars = XContentMapValues.nodeIntegerValue(indexPrefix.remove("max_chars"), Defaults.INDEX_PREFIX_MAX_CHARS);
            for (int i = value.length(); i < minChars; i++) {
import org.opensearch.common.lucene.search.AutomatonQueries;
        public Builder fielddata(boolean fielddata) {
                automata.add(Automata.makeAnyChar());
            throw new UnsupportedOperationException();
        double minFrequency = XContentMapValues.nodeDoubleValue(frequencyFilter.remove("min"), 0);
            this.prefixFieldType = prefixFieldType;
import java.util.Optional;
    /**
                        "Cannot set position_increment_gap on field [" + name + "] without positions enabled"
            m -> ((TextFieldType) toType(m).mappedFieldType).fielddata,
            }
            if (index.get() == false) {
            subIterators.add(phraseFieldMapper);
        public PrefixFieldType getPrefixFieldType() {
    }
            // parent field in _source. So we don't need to use the parent field name here.
                || method == MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE) {
import org.apache.lucene.util.automaton.Automaton;
        @Override
        }
            }
        @Override
    }
import org.opensearch.index.query.IntervalBuilder;
        };
            if (getTextSearchInfo().hasPositions() == false) {
            ft.setIndexAnalyzer(indexAnalyzer);
            this.indexCreatedVersion = indexCreatedVersion;
            false,
            super(mappedFieldType.name(), fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());
import org.opensearch.common.collect.Iterators;
import org.apache.lucene.analysis.Analyzer;
        }
    private final String indexOptions;
            failIfNotIndexed();
        boolean accept(int length) {
                if (currentTerms.isEmpty() == false) {
        }
     *
        mapperBuilder.analyzers.searchAnalyzer.toXContent(builder, includeDefaults);
        }
        public IntervalsSource intervals(BytesRef term) {
        protected void parseCreateField(ParseContext context) {
                    mpqb.add(multiTerms.toArray(new Term[0]));
            return sb.build();
import org.opensearch.Version;
        public static boolean hasGaps(TokenStream stream) throws IOException {
    private static final String FAST_PHRASE_SUFFIX = "._index_phrase";
        public Builder(String name, Version indexCreatedVersion, IndexAnalyzers indexAnalyzers) {
                    spanQuery.addClause(fieldMask);
            int posInc = positions[i] - previousPos;
            super(
        }
            FieldType pft = new FieldType(fieldType);
        // this is a pain, but we have to do this to maintain BWC
 * Modifications Copyright OpenSearch Contributors. See
            builder.field("min", minFreq);
                    );
                return Intervals.prefix(normalizedTerm);
        }
                multiTerms.clear();
            return fielddata;
        }
                new TextSearchInfo(Defaults.FIELD_TYPE, null, Lucene.STANDARD_ANALYZER, Lucene.STANDARD_ANALYZER),
        mapperBuilder.store.toXContent(builder, includeDefaults);
        public static final int FIELDDATA_MIN_SEGMENT_SIZE = 0;
            /*
 */
        }
            "position_increment_gap",
            return this.prefixFieldType;
            PrefixConfig that = (PrefixConfig) o;
            this(name, indexCreatedVersion, indexAnalyzers);
            return List.copyOf(parameters);
     * @opensearch.internal
        public static final double FIELDDATA_MAX_FREQUENCY = Integer.MAX_VALUE;
    }
import org.apache.lucene.analysis.shingle.FixedShingleFilter;
                    position += posIncrAtt.getPositionIncrement();
            this.delegate = delegate;
            false,
