     */
     * Field mapper for prefix fields
        }
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
 * SPDX-License-Identifier: Apache-2.0
        }  
 * @opensearch.internal
     */
        }  
package org.opensearch.index.mapper;
     * Field type for prefix fields
        private final int positionIncrementGap;
                buildPhraseMapper(fieldType, tft),  
            NamedAnalyzer searchAnalyzer = analyzers.getSearchAnalyzer();
            this.fieldData.setValue(fielddata);  
    private final PrefixFieldMapper prefixFieldMapper;  
        mapperBuilder.analyzers.indexAnalyzer.toXContent(builder, includeDefaults);
        double minFrequency = XContentMapValues.nodeDoubleValue(frequencyFilter.remove("min"), 0);
        return new PrefixConfig(minChars, maxChars);  
            if (term.length >= minChars) {
        }
        mapperBuilder.boost.toXContent(builder, includeDefaults);
        static {
        }  
        }  
            return new BooleanQuery.Builder().add(query, BooleanClause.Occur.SHOULD)
            if (minChars < 1) {
                builder.add(new Term(field, termAtt.getBytesRef()), position);  
                if (posIncAtt.getPositionIncrement() > 1) {
        @Override
                true,
     * A prefix wrapped analyzer
        if (value == null) {
    /**
        public String toString() {
        @Override
        if (subIterators.size() == 0) {
                )
        @Override
        int fielddataMinSegmentSize() {  
    public TextFieldType fieldType() {
    ) throws IOException {
    }
                && minSegmentSize == that.minSegmentSize;
            }
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            }  
                spanMulti.setRewriteMethod(method);
        }  
                }
            currentTerms.add(new Term(field, termAtt.getBytesRef()));
            }  
    /**  
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
            return SourceValueFetcher.toString(name(), context, format);
                    SpanQuery[] queries = Arrays.stream(posTerms)  
            builder.field("min", minFreq);
        protected Analyzer getWrappedAnalyzer(String fieldName) {  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return this.prefixFieldType;  
                    norms,  
        void addField(ParseContext context, String value) {  
            // parent field in _source. So we don't need to use the parent field name here.
            }  
            /*
import java.util.Objects;
        public Query existsQuery(QueryShardContext context) {  
        mapperBuilder.analyzers.searchAnalyzer.toXContent(builder, includeDefaults);
            setIndexAnalyzer(
 *
    public static class Defaults {
            TokenFilter filter = new EdgeNGramTokenFilter(components.getTokenStream(), minChars, maxChars, false);  
            this.maxChars = maxChars;  
        mapperBuilder.index.toXContent(builder, includeDefaults);
        void setIndexPhrases() {
                false,  
        );
    static final class PrefixFieldType extends StringFieldType {
import org.apache.lucene.queries.intervals.Intervals;  
import org.apache.lucene.document.Field;
            }  
 * Licensed to Elasticsearch under one or more contributor  
        mapperBuilder.eagerGlobalOrdinals.toXContent(builder, includeDefaults);
        final Parameter<Boolean> indexPhrases = Parameter.boolParam(
import org.apache.lucene.util.automaton.Operations;
        );  
        }  
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {
        final Parameter<FielddataFrequencyFilter> freqFilter = new Parameter<>(
        Defaults.FIELDDATA_MIN_SEGMENT_SIZE
     * Derive source using stored field, which would always be present for derived source enabled index field  
        private Query analyzePhrasePrefix(TokenStream stream, int slop, int maxExpansions) throws IOException {  
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {  
import org.apache.lucene.queries.intervals.IntervalsSource;
            m -> ((TextFieldType) toType(m).mappedFieldType).fielddata,
        mapperBuilder.meta.toXContent(builder, includeDefaults);  
                multiFieldsBuilder.build(this, context),
    }  
        TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
        }
                || method == MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE) {
            for (int i = value.length(); i < minChars; i++) {  
        }  
            }
                    analyzers.searchAnalyzer,  
             */
                position += posIncrAtt.getPositionIncrement();
import java.util.Arrays;  
                field = field + FAST_PHRASE_SUFFIX;
 * not use this file except in compliance with the License.
                    );
            );
     */
        this.indexCreatedVersion = builder.indexCreatedVersion;
            return builder;
        return (TextFieldMapper) in;
        @Override  
        public int hashCode() {  
     */
        for (Parameter<?> pluginMappingParameter : mapperBuilder.pluginMappingParameters()) {  
     *  
import org.opensearch.index.query.QueryShardContext;
            builder.endObject();
            "fielddata",  
                    new PrefixWrappedAnalyzer(delegate.analyzer(), minChars, maxChars, delegate.getPositionIncrementGap(analyzerName))  
import org.opensearch.index.IndexSettings;
                if (currentTerms.isEmpty() == false) {
        super(simpleName, mappedFieldType, multiFields, copyTo);
            }
                    analyzers.searchQuoteAnalyzer,
import org.apache.lucene.search.AutomatonQuery;
        }
                return new ConstantScoreQuery(tq);
            this.minChars = minChars;
            FieldType fieldType = TextParams.buildFieldType(index, store, indexOptions, norms, termVectors);  
            throw new UnsupportedOperationException();
import org.apache.lucene.util.BytesRef;
        }
                    "Text fields are not optimised for operations that require per-document "
        this.mappingPluginParameterValues = builder.pluginMappingParameterValues();
            this.store.setValue(store);
     * @opensearch.internal
                pft.setIndexOptions(IndexOptions.DOCS);  
        Builder builder
        public static final int POSITION_INCREMENT_GAP = 100;  
        }
import org.opensearch.Version;
                stream = new FixedShingleFilter(stream, 2);
        mapperBuilder.analyzers.searchQuoteAnalyzer.toXContent(builder, includeDefaults);  
            }  
            super(name, true, false, false, parent.getTextSearchInfo(), Collections.emptyMap());
                );
import org.opensearch.common.lucene.Lucene;
            }  
            } else {
                context.doc().add(new Field(phraseFieldMapper.fieldType().name(), value, phraseFieldMapper.fieldType));  
     * Default paramters for text fields
                name(),
        public Builder fielddataFrequencyFilter(double min, double max, int segs) {
                        new SpanTermQuery(new Term(prefixField, posTerms[0].bytes())),
    /**
        protected PhraseFieldMapper buildPhraseMapper(FieldType fieldType, TextFieldType parent) {  
                    spanQuery.addClause(new SpanOrQuery(queries));  
            NamedAnalyzer indexAnalyzer = analyzers.getIndexAnalyzer();  
        final int minChars;
                || method == MultiTermQuery.CONSTANT_SCORE_REWRITE
        protected PrefixFieldMapper buildPrefixMapper(BuilderContext context, FieldType fieldType, TextFieldType tft) {  
    }  
        void setAnalyzer(NamedAnalyzer delegate) {  
        @Override
                    && context.isMultiField() == false)) {
        @Override
     * @opensearch.internal  
            int posInc = positions[i] - previousPos;
                .map(p -> new PrefixConfig(p.minChars, p.maxChars))
    /**  
                return builder;
                && prefixFieldType.getTextSearchInfo().hasPositions()) {
            failIfNotIndexed();  
                }
        MultiPhrasePrefixQuery builder = new MultiPhrasePrefixQuery(field);  
    private static final String FAST_PHRASE_SUFFIX = "._index_phrase";
            false,  
import org.apache.lucene.analysis.TokenStream;
        final int maxChars;
        protected PrefixFieldMapper(FieldType fieldType, PrefixFieldType mappedFieldType) {
            stream.reset();
    protected TextFieldMapper(  
    }  
        final Parameter<Integer> positionIncrementGap = Parameter.intParam(
import org.apache.lucene.search.PhraseQuery;
            return "phrase";  
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
import org.apache.lucene.analysis.AnalyzerWrapper;
                createFieldNamesField(context);  
            builder.field("min_chars", minChars);  
            }  
            if (minChars > maxChars) {
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
                throw new IllegalArgumentException("min_chars [" + minChars + "] must be less than max_chars [" + maxChars + "]");
import org.apache.lucene.queries.spans.SpanQuery;  
        }
        protected String contentType() {
            builder.field("min_segment_size", minSegmentSize);  
        }
            if (value.length() >= minChars) {
            }
            return fielddata;
            this.fielddata = fielddata;
     * Field mapper for phrase fields  
            return "{ min_chars=" + minChars + ", max_chars=" + maxChars + " }";  
    }  
            this.setFielddata(fielddata, DEFAULT_FILTER);
                if (caseInsensitive) {  
            parent.setIndexPhrases();
            m -> toType(m).mappedFieldType.eagerGlobalOrdinals(),  
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {  
            throw new IllegalArgumentException("Cannot enable fielddata on a [text] field that is not indexed: [" + name() + "]");
            return Intervals.or(Intervals.fixField(name(), Intervals.wildcard(new BytesRef(wildcardTerm))), Intervals.term(term));
            if (fielddata == false) {
        }  
            }
                automata.add(Automata.makeString(value));  
/**
        }
            applyPluginParameterEffects();
            return builder;
     * @opensearch.internal  
            }
            context.doc().add(new Field(fieldType().name(), value, fieldType));
import java.util.function.IntPredicate;
            m -> toType(m).positionIncrementGap,
        int minSegmentSize = XContentMapValues.nodeIntegerValue(frequencyFilter.remove("min_segment_size"), 0);  
        int slop,
                return super.prefixQuery(value, method, caseInsensitive, context);
import java.util.Map;
            String fullName = buildFullName(context);
        if (prefixFieldMapper != null) {
        private PrefixFieldType prefixFieldType;  
                field = field + FAST_PHRASE_SUFFIX;
        }  
    }
            if (prefixFieldMapper != null) {
            this.prefixFieldType = prefixFieldType;
                return super.termQuery(value, context);  
        return mappingPluginParameterValues;
                prefixFieldMapper.addField(context, value);  
import org.opensearch.core.xcontent.ToXContent;
import org.apache.lucene.search.TermQuery;  
        mapperBuilder.store.toXContent(builder, includeDefaults);  
            return tq;
        String prefixField,  
            this(name, Version.CURRENT, indexAnalyzers);
        this.copyTo.toXContent(builder, params);
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePosIncrements) throws IOException {
                    spanQuery.addClause(new SpanOrQuery(queries));
     *  
                CoreValuesSourceType.BYTES
            IntPredicate usePrefix = (len) -> len >= prefixFieldType.minChars && len <= prefixFieldType.maxChars;
        List<Mapper> subIterators = new ArrayList<>();
        }
            FIELD_TYPE.setStored(false);
        protected TextFieldType buildFieldType(FieldType fieldType, BuilderContext context) {
            throws IOException {  
        }
                indexed,
        }
    /**  
     *  
import org.apache.lucene.analysis.CachingTokenFilter;  
            return minChars == that.minChars && maxChars == that.maxChars;
    }  
        }
            TextFieldType tft = buildFieldType(fieldType, context);
            if (o == null || getClass() != o.getClass()) return false;
        PhraseFieldMapper phraseFieldMapper,
        @Override
            return length >= minChars - 1 && length <= maxChars;  
        }
        }
        final Parameter<String> termVectors = TextParams.termVectors(m -> toType(m).termVectors);  
            setAnalyzer(parent.indexAnalyzer().name(), parent.indexAnalyzer().analyzer());
            builder.field("max_chars", maxChars);
                if (enablePositionIncrements) {  
        @Override
        final int minSegmentSize;
        }
    private static TextFieldMapper toType(FieldMapper in) {  
                }
        }  
        if (fieldType.indexOptions() == IndexOptions.NONE && fieldType().fielddata()) {
import org.apache.lucene.index.Term;
            true,
            if (fieldType.omitNorms()) {
        String field,  
            () -> DEFAULT_FILTER,
        protected void parseCreateField(ParseContext context) {
                spanQuery.addGap(posInc - 1);
            false,  
            this.delegate = delegate;
                throw new IllegalArgumentException("Cannot set index_prefixes on unindexed field [" + name() + "]");
        int position = -1;
        double maxFrequency = XContentMapValues.nodeDoubleValue(frequencyFilter.remove("max"), Integer.MAX_VALUE);
        }  
        PhraseFieldMapper(FieldType fieldType, PhraseFieldType mappedFieldType) {  
        CopyTo copyTo,
 * this work for additional information regarding copyright
import org.opensearch.index.query.IntervalMode;
            return analyzePhrasePrefix(stream, slop, maxExpansions);  
        Defaults.FIELDDATA_MAX_FREQUENCY,
            return SourceValueFetcher.toString(name(), context, format);  
            // or if the incoming token stream is the output of a token graph due to
            if (fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS) < 0) {
                } else {
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;  
                    spanQuery.addClause(fieldMask);
            return this;
            this.maxFreq = maxFreq;  
            return delegate;
            }  
                SpanMultiTermQueryWrapper<?> spanMulti = new SpanMultiTermQueryWrapper<>(
    }
        this.fieldType = fieldType;
            }  
        if (context.externalValueSet()) {
                this  
        }
     */  
        PrefixFieldType(TextFieldType parentField, String name, PrefixConfig config) {
            ft.setEagerGlobalOrdinals(eagerGlobalOrdinals.getValue());
            return builder;  
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
            subIterators.add(phraseFieldMapper);  
        void setPrefixFieldType(PrefixFieldType prefixFieldType) {
        final double maxFreq;
            mpqb.add(multiTerms.toArray(new Term[0]));
        mapperBuilder.freqFilter.toXContent(builder, includeDefaults);
import java.util.ArrayList;
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {  
        public String typeName() {
            return this;  
            this.filter = filter;  
     * Field type for text fields
        TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);  
     * @opensearch.internal
            }
        @Override  
            }
        protected final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).mappedFieldType.isSearchable(), true);
            pft.setOmitNorms(true);  
        if (terms.length == 1) {  
            true,
            }  
        }  
            );  
            throw new UnsupportedOperationException();  
            // parent field in _source. So we don't need to use the parent field name here.
                new TextSearchInfo(Defaults.FIELD_TYPE, null, Lucene.STANDARD_ANALYZER, Lucene.STANDARD_ANALYZER),
     */
        public PrefixFieldType getPrefixFieldType() {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
        ).acceptsNull();  
        );  
        protected List<Parameter<?>> getParameters() {  
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            false
            if (caseInsensitive) {  
        this.termVectors = builder.termVectors.getValue();  
        @Override  
                    termVectors,
        while (stream.incrementToken()) {
        if (prefixField == null) {
    /**  
            }  
            m -> ((TextFieldType) toType(m).mappedFieldType).indexPhrases,
            if (posInc > 1) {
     *
        }
        if (phraseFieldMapper != null) {
        }
        this.indexAnalyzers = builder.analyzers.indexAnalyzers;  
        private final Analyzer delegate;
                if (prefixFieldType != null) {  
import org.apache.lucene.analysis.Analyzer;
                multiTerms.clear();
            return this;
        FieldType fieldType,
        this.multiFields.toXContent(builder, params);
            PrefixFieldType prefixFieldType = new PrefixFieldType(tft, fullName + "._index_prefix", indexPrefixes.get());
                } else {  
        public String toString() {
 * The OpenSearch Contributors require contributions made to  
                new TextSearchInfo(Defaults.FIELD_TYPE, null, Lucene.STANDARD_ANALYZER, Lucene.STANDARD_ANALYZER),
        // this is a pain, but we have to do this to maintain BWC
            } else {
    protected static final int POSITION_INCREMENT_GAP_USE_ANALYZER = -1;  
import org.apache.lucene.util.automaton.Automata;
                        + "field data by uninverting the inverted index. Note that this can use significant memory."  
        stream.reset();  
    protected final FieldType fieldType;
    @Override
        builder.add(currentTerms.toArray(new Term[0]), position);  
            mpqb.add(multiTerms.toArray(new Term[0]), position);  
        );
        }
import org.apache.lucene.index.IndexOptions;
    @Override
             * or a multi-field). This way search will continue to work on old indices and new indices
        }
        }  
        final String value = getFieldValue(context);  
            }  
        }  
        private final int maxChars;  
 * GitHub history for details.
    }  
                        field
        private final Analyzer delegate;
import org.apache.lucene.search.BooleanClause;  
        if (enablePositionIncrements) {
                throw new IllegalArgumentException("min_chars [" + minChars + "] must be greater than zero");
        private FielddataFrequencyFilter filter;
     * @opensearch.internal  
            return super.toString() + ",prefixChars=" + minChars + ":" + maxChars;
                        .toArray(SpanQuery[]::new);
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;  
            if (index.getValue() == false) {
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
import org.opensearch.index.analysis.IndexAnalyzers;  
        }
    @Override
import java.util.Iterator;
        }
            while (stream.incrementToken()) {  
        }
import org.apache.lucene.analysis.shingle.FixedShingleFilter;
        }
        public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
        protected String contentType() {
                throw new IllegalArgumentException(  
        TextFieldType mappedFieldType,  
import java.util.List;  
        public TextFieldMapper build(BuilderContext context) {
        public Builder(String name, Version indexCreatedVersion, IndexAnalyzers indexAnalyzers, List<Parameter<?>> pluginParameters) {
        }
        }
        @Override
                name,
     *
            }
        @Override
            }  
                BytesRef normalizedTerm = analyzer.normalize(name(), text);
        @Override  
import java.util.Collections;
        }
                new NamedAnalyzer(  
            for (int i = term.length; i < minChars; i++) {  
            return builder.analyzeText(text, maxGaps, mode);  
                    indexPhrases,
import org.opensearch.search.lookup.SearchLookup;
        }  
        PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);  
            false  
             * even if it is different from the expected one (in case the field is nested under an object
/*  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
        // Plugin-contributed parameters are not part of the fixed backwards-compatibility list above and are serialized explicitly.
                ft.setFielddata(true, freqFilter.getValue());
        PrefixFieldMapper prefixFieldMapper,
            fielddata = false;
            return;  
    }
            () -> null,
        }
        PrefixWrappedAnalyzer(Analyzer delegate, int minChars, int maxChars, int positionIncrementGap) {
import org.opensearch.common.collect.Iterators;  
        }
        assert mappedFieldType.hasDocValues() == false;  
        }  
        }
        }
 *  
            if (positionIncrement > 0 && multiTerms.size() > 0) {
                pft.setStoreTermVectorOffsets(true);
            this.delegate = delegate;  
        public Builder store(boolean store) {  
        @Override
        final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> toType(m).similarity);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public static final double FIELDDATA_MIN_FREQUENCY = 0;  
    /**
                // frequencies are not needed because prefix queries always use a constant score
    public Map<String, Object> mappingPluginParameterValues() {
    }
    }
            List<Parameter<?>> parameters = new ArrayList<>(
    private final List<Parameter<?>> mappingPluginParameters;
        }  
            }  
import java.util.function.Supplier;
        }
            POSITION_INCREMENT_GAP_USE_ANALYZER
    public static Query createPhrasePrefixQuery(
    static final class PhraseFieldType extends StringFieldType {
        }
        private final Version indexCreatedVersion;  
            this(  
            "index_phrases",
                } else {
    private static FielddataFrequencyFilter parseFrequencyFilter(String name, ParserContext parserContext, Object node) {
         * The default position_increment_gap is set to 100 so that phrase  
            return "prefix";  
            }  
                return new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixFieldType.name(), indexedValueForSearch(value))), name());  
            return Objects.hash(minChars, maxChars);
            return new PagedBytesIndexFieldData.Builder(  
            stream.reset();  
        }
                name,
            this.minFreq = minFreq;
 */  
        return spanQuery.build();
            return fieldType().toString();
            "fielddata_frequency_filter",  
        final Parameter<PrefixConfig> indexPrefixes = new Parameter<>(
        public static final int INDEX_PREFIX_MIN_CHARS = 2;  
            FIELD_TYPE.setTokenized(true);  
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
                    return prefixFieldType.intervals(normalizedTerm);
    static PrefixConfig parsePrefixConfig(String propName, ParserContext parserContext, Object propNode) {
        final double minFreq;  
            setPluginMappingParameters(pluginParameters);
            return "{ min=" + minFreq + ", max=" + maxFreq + ", min_segment_size=" + minSegmentSize + " }";
        }
            return filter.maxFreq;  
                )
            this.multiFieldsBuilder.add(builder);
            setIndexAnalyzer(new NamedAnalyzer(name, AnalyzerScope.INDEX, new PhraseWrappedAnalyzer(delegate)));  
        List<Term> multiTerms = new ArrayList<>();  
                    position += posIncrAtt.getPositionIncrement();
            super(name);  
     */
public class TextFieldMapper extends ParametrizedFieldMapper {  
    public static class Builder extends ParametrizedFieldMapper.Builder {
        public boolean fielddata() {  
                stream = new FixedShingleFilter(stream, 2);
        private FielddataFrequencyFilter(double minFreq, double maxFreq, int minSegmentSize) {
        @Override
        }  
                currentTerms.clear();
                && value.length() >= prefixFieldType.minChars
            return;
        @Override
     *
     */
            if (getTextSearchInfo().hasPositions() == false) {
        mapperBuilder.termVectors.toXContent(builder, includeDefaults);
            Arrays.stream(terms[0]).map(term -> new Term(prefixField, term.bytes())).forEach(sb::addTerm);
    }
            multiTerms.add(new Term(field, termAtt.getBytesRef()));
        public Query existsQuery(QueryShardContext context) {
            this.analyzers = new TextParams.Analyzers(indexAnalyzers);
        }  
        MultiPhraseQuery.Builder mpqb = new MultiPhraseQuery.Builder();
                name,
            if (i == lastPos) {
        Builder mapperBuilder = (TextFieldMapper.Builder) getMergeBuilder();  
import org.apache.lucene.queries.spans.SpanNearQuery;
        int position = -1;
                Arrays.asList(
            FIELD_TYPE.setOmitNorms(false);  
        final Parameter<String> indexOptions = TextParams.indexOptions(m -> toType(m).indexOptions);
            );
     * @opensearch.internal  
            if (prefixFieldType == null || prefixFieldType.accept(value.length()) == false) {  
        }  
                    mpqb.add(multiTerms.toArray(new Term[0]));  
import org.apache.lucene.search.BooleanQuery;
    protected String getFieldValue(ParseContext context) throws IOException {  
            if (posIncrAtt.getPositionIncrement() != 0) {  
            String field = name();
            this.indexCreatedVersion = indexCreatedVersion;
import org.apache.lucene.analysis.tokenattributes.BytesTermAttribute;
    }  
    private final String indexOptions;  
        Defaults.FIELDDATA_MIN_FREQUENCY,  
         */
     * @opensearch.internal
    }  
        PhraseWrappedAnalyzer(Analyzer delegate) {  
        protected final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).fieldType.stored(), false);  
                return Intervals.fixField(name(), Intervals.term(term));  
    @Override
    private static class PrefixWrappedAnalyzer extends AnalyzerWrapper {  
 * ownership. Elasticsearch licenses this file to you under  
        final Parameter<Boolean> norms = TextParams.norms(true, m -> toType(m).fieldType.omitNorms() == false);
            return super.iterator();  
            if (phraseFieldMapper != null) {
            while (stream.incrementToken()) {
        public void setFielddata(boolean fielddata, FielddataFrequencyFilter filter) {
            String wildcardTerm = sb.toString();  
                        + "] in order to load "
/*
        return Iterators.concat(super.iterator(), subIterators.iterator());
        builder.setSlop(slop);
            this.maxChars = maxChars;  
            return new TokenStreamComponents(components.getSource(), new FixedShingleFilter(components.getTokenStream(), 2));  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.support.XContentMapValues;
/*  
                if (posTerms.length == 1) {  
     * Prefix configuration
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
                        + "keyword field instead. Alternatively, set fielddata=true on ["  
                throw new IllegalArgumentException("Cannot set index_phrases on field [" + name() + "] if positions are not enabled");
    protected DerivedFieldGenerator derivedFieldGenerator() {  
            IntervalBuilder builder = new IntervalBuilder(name(), analyzer == null ? getTextSearchInfo().getSearchAnalyzer() : analyzer);
            }
            : c.dataFormatRegistry().getPluginMappingParameters(CONTENT_TYPE, c.mapperService().getIndexSettings());
    }
            return context.parser().textOrNull();
            );  
import org.opensearch.index.mapper.Mapper.TypeParser.ParserContext;
            if (analyzer == null) {
        public boolean equals(Object o) {
        protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            fielddata = false;
     * @opensearch.internal
            this.freqFilter.setValue(new FielddataFrequencyFilter(min, max, segs));
            if (indexPhrases && slop == 0 && hasGaps(stream) == false && stream.hasAttribute(BytesTermAttribute.class) == false) {  
    }
        }
            return createPhraseQuery(stream, field, slop, enablePositionIncrements);
}
import java.io.IOException;
            this.positionIncrementGap = positionIncrementGap;  
                filter.minSegmentSize,
        int lastPos = builder.getTerms().length - 1;
            }
        };  
        double fielddataMinFrequency() {
                    );  
        PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);
        }
            if (fieldType.storeTermVectorOffsets()) {
            }  
        return (TextFieldType) super.fieldType();  
                return Intervals.prefix(term);  
            // https://issues.apache.org/jira/browse/LUCENE-8916
            if (index.get() == false) {
            int position = -1;  
                    eagerGlobalOrdinals,  
                }
        PhraseFieldType(TextFieldType parent) {
        public int hashCode() {  
        return CONTENT_TYPE;
import org.opensearch.common.lucene.search.AutomatonQueries;
        @Override
        public void setFielddata(boolean fielddata) {  
            if (fieldType.indexOptions() == IndexOptions.DOCS_AND_FREQS) {
            builder.field("max", maxFreq);
    @Override
    );  
                automata.add(AutomatonQueries.toCaseInsensitiveString(value));
                    similarity,
    @Override  
            return null;  
        }
                analyzer = getTextSearchInfo().getSearchAnalyzer();
            m -> toType(m).freqFilter
            this.index.setValue(index);
            ? List.of()
            }
            throw new UnsupportedOperationException();
        private boolean indexPhrases = false;
                && Double.compare(that.maxFreq, maxFreq) == 0
        } else {
                if (termAtt.getBytesRef() == null) {
     * Frequency filter for field data
        }  
            subIterators.add(prefixFieldMapper);  
            parameters.addAll(pluginMappingParameters());
        public TextFieldType(String name, boolean indexed, boolean stored, Map<String, String> meta) {
            StringBuilder sb = new StringBuilder(term.utf8ToString());
                }  
        spanQuery.setSlop(slop);
        final Parameter<Boolean> eagerGlobalOrdinals = Parameter.boolParam(  
                    SpanTermQuery[] queries = Arrays.stream(posTerms).map(SpanTermQuery::new).toArray(SpanTermQuery[]::new);  
            super(mappedFieldType.name(), fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());  
        protected void parseCreateField(ParseContext context) {
        mapperBuilder.fieldData.toXContent(builder, includeDefaults);
        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
                fieldType.setStored(true);
     *
            previousPos = positions[i];  
    }  
    protected static final class PrefixFieldMapper extends FieldMapper {  
            return this;
import org.opensearch.index.analysis.NamedAnalyzer;
            if (prefix) {
     * Field type for phrase fields  
        protected final Parameter<Float> boost = Parameter.boostParam();
        IntPredicate usePrefixField
        return (TextFieldMapper) super.clone();
        }
        mapperBuilder.positionIncrementGap.toXContent(builder, includeDefaults);  
                    analyzers.indexAnalyzer,
import org.apache.lucene.search.Query;
     */
    /**
        public IntervalsSource intervals(String text, int maxGaps, IntervalMode mode, NamedAnalyzer analyzer, boolean prefix)
    @Override
        final Term[][] terms = builder.getTerms();  
                searchAnalyzer = new NamedAnalyzer(searchAnalyzer, positionIncrementGap.get());
        );
            return builder.build();  
 * Unless required by applicable law or agreed to in writing,
        if (value == null) {
    /**
        @Override
        final int maxChars;
    }
            public FieldValueType getDerivedFieldPreference() {  
         * queries of reasonably high slop will not match across field values.
                );
    private final String termVectors;
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;  
            return CONTENT_TYPE;
            builder.startObject();
        } else {  
                        + name()
        public String toString() {  
        mapperBuilder.indexOptions.toXContent(builder, includeDefaults);
            FieldType pft = new FieldType(fieldType);
     *
            FIELD_TYPE.freeze();
     * Builder for text fields  
        @Override  
        public String toString() {
            }  
            return SourceValueFetcher.toString(name(), context, format);  
 * compatible open source license.
            this.maxChars = maxChars;
        PrefixConfig(int minChars, int maxChars) {
    }  
    private final int positionIncrementGap;
        String simpleName,
        for (Term term : terms[lastPos]) {
        return mpqb.build();
            if (indexPhrases.get() == false) {
     * @opensearch.internal
            }
            TextFieldMapper::parseFrequencyFilter,  
                copyTo.build(),
    protected String contentType() {  
        @Override
        DocumentMapperParser.checkNoRemainingFields(name, frequencyFilter, parserContext.indexVersionCreated());
        }  
        }
        }
        public boolean equals(Object o) {
     */
        public String typeName() {
        @Override
            PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);
     * @opensearch.internal
                return null;
import org.apache.lucene.queries.spans.SpanOrQuery;
        assert mappedFieldType.getTextSearchInfo().isTokenized();
        PrefixFieldType(TextFieldType parent, String name, int minChars, int maxChars) {  
                if (fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS) < 0) {
            return createPhrasePrefixQuery(stream, name(), slop, maxExpansions, prefixField, usePrefix);  
            tft.setPrefixFieldType(prefixFieldType);
        }
            List<Automaton> automata = new ArrayList<>();
                throw new IllegalArgumentException("max_chars [" + maxChars + "] must be less than 20");
            this.parent = parent;
    @Override
            }
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;  
import org.apache.lucene.search.ConstantScoreQuery;
        protected final Parameter<Map<String, String>> meta = Parameter.metaParam();  
        }
        List<Parameter<?>> pluginParameters = c.dataFormatRegistry() == null  
    private final PhraseFieldMapper phraseFieldMapper;
    private static class PhraseWrappedAnalyzer extends AnalyzerWrapper {
        public Builder fielddata(boolean fielddata) {
                }
    }  
            TextFieldType ft = new TextFieldType(buildFullName(context), index.getValue(), store.getValue(), tsi, meta.getValue());
                sb.append("?");
     * @opensearch.internal  
        List<Term> currentTerms = new ArrayList<>();
        int maxChars = XContentMapValues.nodeIntegerValue(indexPrefix.remove("max_chars"), Defaults.INDEX_PREFIX_MAX_CHARS);
     *
        return new Builder(n, c.indexVersionCreated(), c.getIndexAnalyzers(), pluginParameters);  
            FieldType phraseFieldType = new FieldType(fieldType);
                false,
            if (indexPrefixes.get() == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.parent = parent;
            FielddataFrequencyFilter that = (FielddataFrequencyFilter) o;
        @Override
     *
    private final FielddataFrequencyFilter freqFilter;
     */  
            builder.setSlop(slop);
            if (term.length > maxChars) {
        }  
                throw new IllegalArgumentException("Cannot create intervals over field [" + name() + "] with no positions indexed");
                filter.maxFreq,  
    @Override
import org.opensearch.index.similarity.SimilarityProvider;  
             * to build prefix field names so we preserve the name that was used at creation time  
                }
    }
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
            "index_prefixes",
                    position += 1;
                }  
            FIELD_TYPE.setStoreTermVectors(false);
        public static boolean hasGaps(TokenStream stream) throws IOException {  
 * specific language governing permissions and limitations
            false,  
            return filter.minSegmentSize;
        }  
        final String value = getFieldValue(context);
    protected static final class FielddataFrequencyFilter implements ToXContent {
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
            int positionIncrement = posIncrAtt.getPositionIncrement();  
                Collections.emptyMap()
            super(mappedFieldType.name(), fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());
        }  
                return spanMulti;  
            this.minChars = minChars;
        mapperBuilder.indexPhrases.toXContent(builder, includeDefaults);
            m -> Optional.ofNullable(((TextFieldType) toType(m).mappedFieldType).prefixFieldType)  
        }
        }  
            setAnalyzer(parent.indexAnalyzer());
                indexAnalyzer = new NamedAnalyzer(indexAnalyzer, positionIncrementGap.get());  
 *
    }  
            this.minSegmentSize = minSegmentSize;
        public static final int INDEX_PREFIX_MAX_CHARS = 5;
        @Override
        public Builder addMultiField(Mapper.Builder<?> builder) {  
            @Override
        this.phraseFieldMapper = phraseFieldMapper;  
            pluginMappingParameter.toXContent(builder, includeDefaults);
                return FieldValueType.STORED;
 */  
            Query tq = prefixFieldType.prefixQuery(value, method, caseInsensitive, context);  
                    analyzerName,
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
 * software distributed under the License is distributed on an
    public static final String CONTENT_TYPE = "text";
        }
import org.apache.lucene.util.automaton.Automaton;  
            this(parentField, name, config.minChars, config.maxChars);  
        }
                return null;
        public Builder(String name, Version indexCreatedVersion, IndexAnalyzers indexAnalyzers) {
                fieldType,  
            TextFieldMapper::parsePrefixConfig,
import org.apache.lucene.search.MultiTermQuery;
    public static class TextFieldType extends StringFieldType {
        protected Analyzer getWrappedAnalyzer(String fieldName) {
            return filter.minFreq;
                    store,
            "eager_global_ordinals",
            return context.externalValue().toString();
                    meta
        @Override  
        SpanNearQuery.Builder spanQuery = new SpanNearQuery.Builder(field, true);  
            builder.startObject();  
        public TextFieldType(String name, boolean indexed, boolean stored, TextSearchInfo tsi, Map<String, String> meta) {  
        }  
        @Override  
            Automaton automaton = Operations.concatenate(automata);  
            super(delegate.getReuseStrategy());
 * license agreements. See the NOTICE file distributed with
            return new TextFieldMapper(
import org.apache.lucene.analysis.TokenFilter;
                return Intervals.prefix(normalizedTerm);  
        stream.reset();
                    FieldMaskingSpanQuery fieldMask = new FieldMaskingSpanQuery(  
                && value.length() <= prefixFieldType.maxChars  
            if (positionIncrementGap.get() != POSITION_INCREMENT_GAP_USE_ANALYZER) {  
        private boolean fielddata;
            TextSearchInfo tsi = new TextSearchInfo(fieldType, similarity.getValue(), searchAnalyzer, searchQuoteAnalyzer);
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
                .build();
            return this;  
                } else {
        }
                    new PrefixQuery(new Term(name(), indexedValueForSearch(value)))  
        }  
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {  
        while (stream.incrementToken()) {
        final TextFieldType parent;  
            super(  
        final TextParams.Analyzers analyzers;
             * will use the expected full name.  
        }
        void setAnalyzer(String name, Analyzer delegate) {
        }
            return new PrefixFieldMapper(pft, prefixFieldType);  
        @Override
    protected TextFieldMapper clone() {  
            }
    protected static final class PhraseFieldMapper extends FieldMapper {
            String value = term.text();  
        }  
        }
            throw new UnsupportedOperationException();
        }
        public Builder index(boolean index) {
                || (context.indexSettings().getAsBoolean(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)  
            if (fieldData.getValue()) {  
            Term[] posTerms = terms[i];
            return Double.compare(that.minFreq, minFreq) == 0  
            if (getTextSearchInfo().hasPositions() == false) {
        int minChars = XContentMapValues.nodeIntegerValue(indexPrefix.remove("min_chars"), Defaults.INDEX_PREFIX_MIN_CHARS);  
            return List.copyOf(parameters);
        @Override
            position += positionIncrement;
            if (o == null || getClass() != o.getClass()) return false;  
                automata.add(Automata.makeAnyChar());
        protected FieldTypeCapabilities.Capability searchCapability() {
        int maxExpansions,
            false
            this.indexPhrases = true;  
                throw new IllegalArgumentException("Cannot create intervals over a field [" + name() + "] without indexed positions");  
                    throw new IllegalArgumentException(
            NamedAnalyzer searchQuoteAnalyzer = analyzers.getSearchQuoteAnalyzer();
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
 */
    @Override
        mpqb.setSlop(slop);
 * A {@link FieldMapper} for full-text fields.
        /**
                    boost,  
        }
import org.opensearch.index.query.IntervalBuilder;  
            throw new UnsupportedOperationException();
            } else {
            AutomatonQuery query = AutomatonQueries.createAutomatonQuery(new Term(name(), value + "*"), automaton, method);
        }
            String analyzerName = delegate.name();
        @Override  
            String field = name();
        final int[] positions = builder.getPositions();
        public static final double FIELDDATA_MAX_FREQUENCY = Integer.MAX_VALUE;
        mapperBuilder.norms.toXContent(builder, includeDefaults);  
                    fieldData,
        @Override
                    AnalyzerScope.INDEX,
        public String typeName() {
            return new TokenStreamComponents(components.getSource(), filter);
        @Override  
            }  
        @Override  
import org.apache.lucene.search.MultiPhraseQuery;  
            }
                filter.minFreq,
        public IntervalsSource intervals(BytesRef term) {
            super(delegate.getReuseStrategy());
            }
            }  
            );
            // Copy the index options of the main field to allow phrase queries on  
     *
    @Override
    @Override
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
 */
        int previousPos = -1;
        this.indexOptions = builder.indexOptions.getValue();
import java.util.Optional;  
    private final Map<String, Object> mappingPluginParameterValues;  
        double fielddataMaxFrequency() {
                    return super.termQueryCaseInsensitive(value, context);
            PositionIncrementAttribute posIncAtt = stream.getAttribute(PositionIncrementAttribute.class);
        @Override  
    protected void parseCreateField(ParseContext context) throws IOException {
            return ft;  
            if (usePrefixField.test(value.length()) == false) {
        return new FielddataFrequencyFilter(minFrequency, maxFrequency, minSegmentSize);
        this.freqFilter = builder.freqFilter.getValue();
        MultiFields multiFields,  
    }
        @Override
                if (enablePosIncrements) {
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its
        this.similarity = builder.similarity.getValue();
    }
                .add(new TermQuery(new Term(parent.name(), value)), BooleanClause.Occur.SHOULD)  
        @Override  
            assert stream instanceof CachingTokenFilter;
        private final int minChars;
                    spanQuery.addClause(new SpanTermQuery(posTerms[0]));
        }
        this.prefixFieldMapper = prefixFieldMapper;
        @Override
            Field field = new Field(fieldType().name(), value, fieldType);  
     * A phrase wrapped field analyzer
                }
import org.apache.lucene.search.PrefixQuery;  
                    positionIncrementGap,  
import org.apache.lucene.queries.spans.SpanTermQuery;
        builder.setMaxExpansions(maxExpansions);
            }  
        if (propNode == null) {
                        "Cannot set position_increment_gap on field [" + name + "] without positions enabled"  
            return positionIncrementGap;
 * Modifications Copyright OpenSearch Contributors. See
            this(name, indexCreatedVersion, indexAnalyzers);  
        return new DerivedFieldGenerator(mappedFieldType, null, new StoredFieldFetcher(mappedFieldType, simpleName())) {
import org.opensearch.index.fielddata.IndexFieldData;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            if (context.indexSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
        }
        builder.field("type", contentType());
    ) {  
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;
             * Mappings before v7.2.1 use {@link Builder#name} instead of {@link Builder#fullName}
                buildPrefixMapper(context, fieldType, tft),
            builder.endObject();
        final Parameter<Boolean> fieldData = Parameter.boolParam(
            true,
            }
        Map<?, ?> indexPrefix = (Map<?, ?>) propNode;
                    freqFilter,
                .orElse(null)
            // we can't use the index_phrases shortcut with slop, if there are gaps in the stream,  
        boolean accept(int length) {
    public Iterator<Mapper> iterator() {  
        }
        public static final int FIELDDATA_MIN_SEGMENT_SIZE = 0;
                    throw new IllegalStateException("Null term while building phrase query");
        this.positionIncrementGap = builder.positionIncrementGap.getValue();
        }
            } else {
                        + "field data like aggregations and sorting, so these operations are disabled by default. Please use a "
    protected final IndexAnalyzers indexAnalyzers;
            return sb.build();  
                    mpqb.add(multiTerms.toArray(new Term[0]), position);
        }
    private static final FielddataFrequencyFilter DEFAULT_FILTER = new FielddataFrequencyFilter(
                stored,  
            String prefixField = prefixFieldType == null || slop > 0 ? null : prefixFieldType.name();
        mapperBuilder.indexPrefixes.toXContent(builder, includeDefaults);  
            if (maxChars >= 20) {
        final int minChars;
    protected void canDeriveSourceInternal() {}  
        for (int i = 0; i < terms.length; i++) {  
        }
                    indexPrefixes,
            }  
import org.apache.lucene.search.SynonymQuery;
    }
        }
    protected final Version indexCreatedVersion;  
        @Override  
        public TextFieldType(String name) {
        @Override
        @Override  
            return new PhraseFieldMapper(phraseFieldType, new PhraseFieldType(parent));  
            ft.setBoost(boost.getValue());
 *  
        }
        public static final FieldType FIELD_TYPE = new FieldType();  
            if (this == o) return true;  
        @Override  
            return Objects.hash(minFreq, maxFreq, minSegmentSize);
            ft.setIndexAnalyzer(indexAnalyzer);  
        }  
                }
        context.documentInput().addField(fieldType(), value);
                    builder.add(currentTerms.toArray(new Term[0]), position);
            );  
            throw new UnsupportedOperationException();  
                tft,
import org.opensearch.index.analysis.AnalyzerScope;
            if (method == null
import org.apache.lucene.document.FieldType;  
                || method == MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE  
                        .map(term -> new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixField, term.bytes())), field))
            if (indexPhrases && slop == 0 && hasGaps(stream) == false) {  
                throw new IllegalArgumentException("Cannot set index_phrases on unindexed field [" + name() + "]");
                    return true;  
            PhraseQuery.Builder builder = new PhraseQuery.Builder();
                pft.setIndexOptions(fieldType.indexOptions());
 * KIND, either express or implied.  See the License for the
            return "prefix";  
            super(parent.name() + FAST_PHRASE_SUFFIX, true, false, false, parent.getTextSearchInfo(), Collections.emptyMap());  
        this.mappingPluginParameters = builder.pluginMappingParameters();  
            if (this == o) return true;
        @Override  
        }
    /**
        mapperBuilder.similarity.toXContent(builder, includeDefaults);
            context.doc().add(field);
        }
 * the Apache License, Version 2.0 (the "License"); you may
        TokenStream stream,
        return builder.init(this);
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        }
            // the prefix field.
            SynonymQuery.Builder sb = new SynonymQuery.Builder(prefixField);
    public static Query createPhraseQuery(TokenStream stream, String field, int slop, boolean enablePositionIncrements) throws IOException {  
        @Override
    }  
        @Override
    protected static final class PrefixConfig implements ToXContent {  
                searchQuoteAnalyzer = new NamedAnalyzer(searchQuoteAnalyzer, positionIncrementGap.get());
            return false;  
                if (posTerms.length == 1) {
            if (prefixFieldType != null
            "position_increment_gap",
            return "phrase";
        }
 * under the License.  
        }  
            return delegate;
            this.minChars = minChars;
    /**  
            PrefixConfig that = (PrefixConfig) o;
import org.opensearch.core.xcontent.XContentBuilder;  
                meta  
    });
                    indexOptions,
        final TextFieldType parent;  
            super(name, indexed, stored, false, tsi, meta);
 * You may obtain a copy of the License at  
    /**
        Map<?, ?> frequencyFilter = (Map<?, ?>) node;  
        public int getPositionIncrementGap(String fieldName) {  
        DocumentMapperParser.checkNoRemainingFields(propName, indexPrefix, parserContext.indexVersionCreated());
        Builder builder = new Builder(simpleName(), this.indexCreatedVersion, this.indexAnalyzers, mappingPluginParameters);  
    private final SimilarityProvider similarity;
        }
     */  
                    index,  
    }
