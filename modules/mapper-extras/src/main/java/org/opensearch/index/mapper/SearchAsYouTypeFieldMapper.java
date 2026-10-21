        @Override
        ).setValidator(v -> {
                SpanMultiTermQueryWrapper<?> spanMulti = new SpanMultiTermQueryWrapper<>(
            );
                String fieldName = getShingleFieldName(buildFullName(context), shingleSize);
    static final class ShingleFieldMapper extends FieldMapper {
            this.shingleFields = shingleFields;
            if (prefixFieldType != null && prefixFieldType.termLengthWithinBounds(value.length())) {
        @Override
        public PrefixFieldType fieldType() {
            return super.toString() + ",prefixChars=" + minChars + ":" + maxChars;
        public boolean indexPrefixes() {
            ft.setIndexAnalyzer(analyzers.getIndexAnalyzer());
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        context.documentInput().addField(fieldType(), value);
        private final Parameter<Integer> maxShingleSize = Parameter.intParam(
                name,
                        + "], got ["
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        @Override
                buildFullName(context),
                analyzers.searchQuoteAnalyzer,
                meta
import org.apache.lucene.util.automaton.Operations;
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its
            stream = new FixedShingleFilter(stream, shingleField.shingleSize);
     * The root field type, which most queries should target as it will delegate queries to subfields better optimized for the query. When
    private static final int MAX_SHINGLE_SIZE_UPPER_BOUND = 4;
                return new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixField.name(), indexedValueForSearch(value))), name());
    public int maxShingleSize() {
            return TextFieldMapper.createPhrasePrefixQuery(
            final int indexFromShingleSize = Math.max(positions - 2, 0);
        protected void parseCreateField(ParseContext context) {
        public String toString() {
        }
            final ShingleFieldType shingleField = shingleFieldForPositions(numPos);
        }
    protected void parseCreateField(ParseContext context) throws IOException {
            "max_shingle_size",
                    new PrefixQuery(new Term(name(), indexedValueForSearch(value)))
        }
                return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);
                shingleFieldType.setPrefixFieldType(prefixFieldType);
            prefixFieldType.setIndexAnalyzer(new NamedAnalyzer(indexAnalyzer.name(), AnalyzerScope.INDEX, prefixIndexWrapper));
 * KIND, either express or implied.  See the License for the
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its
        private SearchAsYouTypeAnalyzer(Analyzer delegate, int shingleSize, boolean indexPrefixes) {
        @Override
import static org.opensearch.index.mapper.TextFieldMapper.TextFieldType.hasGaps;
        }).alwaysSerialize();
    }
        // `doc_values=false`, even though it cannot be set; and so we need to continue
    @Override
        return new Builder(simpleName(), this.indexAnalyzers).init(this);
import org.apache.lucene.document.FieldType;
                this.positionIncrementAttribute = addAttribute(PositionIncrementAttribute.class);
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.IndexOptions;
        PrefixFieldMapper prefixField,
            List<Automaton> automata = new ArrayList<>();
import org.apache.lucene.util.automaton.Automata;
            return shingleSize;
            return shingleField.phrasePrefixQuery(stream, 0, maxExpansions);
    private static int countPosition(TokenStream stream) throws IOException {
        }
                index,
     */
            stream = new FixedShingleFilter(stream, shingleField.shingleSize);
import org.apache.lucene.search.ConstantScoreQuery;
    }
            ft.setPrefixField(prefixFieldType);
            Map<String, String> meta
            final Analyzer prefixIndexWrapper = SearchAsYouTypeAnalyzer.withShingleAndPrefix(
                return spanMulti;
        protected Analyzer getWrappedAnalyzer(String fieldName) {
        this.shingleFields = shingleFields;
        }
import org.opensearch.index.analysis.NamedAnalyzer;
                        + "]"
        }
            super(parentField + PREFIX_FIELD_SUFFIX, true, false, false, textSearchInfo, Collections.emptyMap());
            super(name, true, false, false, textSearchInfo, Collections.emptyMap());
    }
public class SearchAsYouTypeFieldMapper extends ParametrizedFieldMapper {
        protected String contentType() {
     */
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
import org.apache.lucene.analysis.TokenFilter;
        assert stream instanceof CachingTokenFilter;
            // wrap the root field's index analyzer with shingles and edge ngrams
                spanMulti.setRewriteMethod(method);
        this.prefixField = prefixField;
/*
            throw new UnsupportedOperationException();
            this.fieldType = fieldType;
        public static final int MAX_SHINGLE_SIZE = 3;
        @Override
            int numPos = countPosition(stream);
                    return query;
                maxShingleSize,
        }
    }
import org.apache.lucene.analysis.shingle.FixedShingleFilter;
        @Override
            int numPos = countPosition(stream);
        }
        }
        context.doc().add(new Field(prefixField.fieldType().name(), value, prefixField.getLuceneFieldType()));
            final String prefixFieldName = slop > 0 ? null : prefixFieldType.name();
 * ownership. Elasticsearch licenses this file to you under
                final int shingleSize = i + 2;
        final int minChars;
                if (method == null
                super.end();
    }
        static SearchAsYouTypeAnalyzer withShingle(Analyzer delegate, int shingleSize) {
            final ShingleFieldType shingleField = shingleFieldForPositions(numPos);
                tokenStream = new EdgeNGramTokenFilter(tokenStream, Defaults.MIN_GRAM, Defaults.MAX_GRAM, true);
            // set up the shingle fields
     */
            for (int i = value.length(); i < minChars; i++) {
 * <p>
    private String extractValue(ParseContext context) throws IOException {
        public SearchAsYouTypeFieldMapper build(Mapper.BuilderContext context) {
            }
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
    private final ShingleFieldMapper[] shingleFields;
            } else {
            if (shingleFields.length == 0 || slop > 0 || hasGaps(stream) || numPos <= 1) {
                positionIncrementAttribute.setPositionIncrement(extraPositionIncrements);
        }
            }
    private final boolean store;
        final TextParams.Analyzers analyzers;
        // serializing it forever because of mapper assertions in mixed clusters.
        private ShingleFieldType shingleFieldForPositions(int positions) {
        static SearchAsYouTypeAnalyzer withShingleAndPrefix(Analyzer delegate, int shingleSize) {
        }
        @Override
            if (v < MAX_SHINGLE_SIZE_LOWER_BOUND || v > MAX_SHINGLE_SIZE_UPPER_BOUND) {
            }
    protected String contentType() {
        public String toString() {
import java.util.Objects;
        this.store = builder.store.getValue();
        }
            return SourceValueFetcher.toString(name(), context, format);
            if (prefixFieldType == null || prefixFieldType.termLengthWithinBounds(value.length()) == false) {
                        + "["
        }
        final Parameter<String> indexOptions = TextParams.indexOptions(m -> toType(m).indexOptions);
import org.apache.lucene.search.MultiTermQuery;
                final SearchAsYouTypeAnalyzer shingleIndexWrapper = SearchAsYouTypeAnalyzer.withShingle(
import java.util.Arrays;
        final int maxChars;
/*
        FieldType getLuceneFieldType() {
     * handling phrase queries, it analyzes the query text to find the appropriate sized shingle subfield to delegate to. When handling
            }
            if (prefixField == null || prefixField.termLengthWithinBounds(value.length()) == false) {
import org.opensearch.index.analysis.IndexAnalyzers;
                automata.add(Automata.makeAnyChar());
                termVectors,
import java.util.Iterator;
        @Override
    }
        }
            super(name);
 *     ├── [ ShingleFieldMapper, ShingleFieldType, analysis wrapped with 2-shingles ]
    @Override
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {
    static class SearchAsYouTypeFieldType extends StringFieldType {
     * The shingle field type handles phrase queries and delegates prefix and phrase prefix queries to the prefix field
            }
            return (ShingleFieldType) super.fieldType();
    public static class Defaults {
    private final String indexOptions;
        }
    }
                copyTo.build(),
        @Override
            return new TokenStreamComponents(components.getSource(), tokenStream);
                );
 *     [ SearchAsYouTypeFieldMapper, SearchAsYouTypeFieldType, unmodified analysis ]
import java.util.Collections;
        public static final int MAX_GRAM = 20;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                shingleFieldType.setIndexAnalyzer(new NamedAnalyzer(indexAnalyzer.name(), AnalyzerScope.INDEX, shingleIndexWrapper));
                analyzers.indexAnalyzer,
 * </pre>
                searchAnalyzer.scope(),
                prefixFieldName,
            if (indexPrefixes) {
        return maxShingleSize;
            NamedAnalyzer searchQuoteAnalyzer,
    private final String termVectors;
        @Override
            // set up the prefix field
 * GitHub history for details.
                indexAnalyzer.analyzer(),
    }
    }
        stream.reset();
        }
 */
        }
        return prefixField;
 */
                similarity.getValue(),
        }
        final int shingleSize;
 *
    }
            this.prefixField = prefixField;
            private final PositionIncrementAttribute positionIncrementAttribute;
 *     └── [ PrefixFieldMapper, PrefixFieldType, analysis wrapped with max_shingle_size-shingles and edge-ngrams ]
        public String typeName() {
    }
                    SearchAsYouTypeAnalyzer.withShingle(searchAnalyzer.analyzer(), shingleSize)
        for (ShingleFieldMapper subFieldMapper : shingleFields) {
        }
            }
            return "prefix";
        @Override
            }
        }
    private final boolean index;
import org.apache.lucene.search.PrefixQuery;
            throw new UnsupportedOperationException();
        this.indexOptions = builder.indexOptions.getValue();
        return (SearchAsYouTypeFieldType) super.fieldType();
            } else {
    @Override
            return;
                );
            super(mappedFieldtype.name(), fieldType, mappedFieldtype, MultiFields.empty(), CopyTo.empty());
    /**
            NamedAnalyzer searchAnalyzer = analyzers.getSearchAnalyzer();
            } else {
 * specific language governing permissions and limitations
    }
                searchAnalyzer.name(),
            return new BooleanQuery.Builder().add(query, BooleanClause.Occur.SHOULD)
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
     * prefix or phrase prefix queries, it delegates to the prefix subfield
            this.prefixFieldType = prefixFieldType;
/*
                return new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixFieldType.name(), indexedValueForSearch(value))), name());
     * An analyzer wrapper to add a shingle token filter, an edge ngram token filter or both to its wrapped analyzer. When adding an edge
        }
                docValues,
        @Override
                    "[max_shingle_size] must be at least ["
    }
            if (value.length() >= minChars) {
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
    @Override
        private final Analyzer delegate;
        void setPrefixFieldType(PrefixFieldType prefixFieldType) {
                FieldType shingleft = new FieldType(fieldType);
    /**
        ShingleFieldMapper(FieldType fieldType, ShingleFieldType mappedFieldtype) {
            return CONTENT_TYPE;
import org.apache.lucene.analysis.TokenStream;
     * ngrams token filter, it also adds a {@link TrailingShingleTokenFilter} to add extra position increments at the end of the stream
        ShingleFieldType(String name, int shingleSize, TextSearchInfo textSearchInfo) {
                false,
import org.apache.lucene.search.AutomatonQuery;
        }
                spanMulti.setRewriteMethod(method);
                    searchAnalyzer.scope(),
        }
                return super.prefixQuery(value, method, caseInsensitive, context);
    static final class PrefixFieldType extends StringFieldType {
        final String value = extractValue(context);
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
    }
import org.apache.lucene.search.BooleanQuery;
        SearchAsYouTypeFieldType(
 *
        }
                if (method == null
 * Licensed to Elasticsearch under one or more contributor
 * The structure of these fields is
                shingleft.setStored(false);
            super(mappedFieldType.name(), fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());
            String name,
            this.parentField = parentField;
            return shingleField.multiPhraseQuery(stream, 0, true);
            return "prefix";
            NamedAnalyzer searchAnalyzer,
            }
        if (fieldType().fieldType.omitNorms()) {
        FieldType getLuceneFieldType() {
            TextParams.setTermVectorParams(termVectors.getValue(), fieldType);
 * <pre>
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }
                TextSearchInfo textSearchInfo = new TextSearchInfo(
                this
    }
            final PrefixFieldMapper prefixFieldMapper = new PrefixFieldMapper(prefixft, prefixFieldType);
                    return super.termQueryCaseInsensitive(value, context);
                shingleFieldTypes[i] = shingleFieldType;
                        + "] and at most "
        @Override
            if (shingleFields.length == 0 || slop > 0 || hasGaps(stream) || numPos <= 1) {
            return "shingle";
            }
    private static final String PREFIX_FIELD_SUFFIX = "._index_prefix";
            SimilarityProvider similarity,
import org.apache.lucene.analysis.Analyzer;
            tokenStream = new FixedShingleFilter(tokenStream, shingleSize, " ", "");
            );
                fieldType.stored(),
    private static SearchAsYouTypeFieldType ft(FieldMapper in) {
                prefixFieldType::termLengthWithinBounds
    ) {
            TrailingShingleTokenFilter(TokenStream input, int extraPositionIncrements) {
    private static SearchAsYouTypeFieldMapper toType(FieldMapper in) {
import java.util.List;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
    private final IndexAnalyzers indexAnalyzers;
        @Override
        }
        }
            fieldType.setStored(store.getValue());
            throw new UnsupportedOperationException();
package org.opensearch.index.mapper;
                    return query;
            }
                final ShingleFieldType shingleFieldType = new ShingleFieldType(fieldName, shingleSize, textSearchInfo);
                        + MAX_SHINGLE_SIZE_LOWER_BOUND
            return Arrays.asList(
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {
        context.doc().add(new Field(fieldType().name(), value, fieldType().fieldType));
import org.apache.lucene.document.Field;
            );
            }
            this.analyzers = new TextParams.Analyzers(indexAnalyzers);
                    || method == MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE) {
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;
    }
            }
            return "<" + getClass().getCanonicalName() + " shingleSize=[" + shingleSize + "] indexPrefixes=[" + indexPrefixes + "]>";
import java.util.Map;
        this.indexAnalyzers = builder.analyzers.indexAnalyzers;
        public void setShingleFields(ShingleFieldType[] shingleFields) {
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);
                this.extraPositionIncrements = extraPositionIncrements;
        @Override
    }
                    || method == MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE) {
                maxShingleSize.getValue()
            prefixft.setIndexOptions(fieldType.indexOptions());
        }
        @Override
        @Override
            if (shingleFields.length == 0 || slop > 0 || hasGaps(stream) || numPos <= 1) {
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
            NamedAnalyzer indexAnalyzer = analyzers.getIndexAnalyzer();
        SearchAsYouTypeFieldType mappedFieldType,
        }
        @Override
        }
            );
                name,
        String simpleName,
        public ShingleFieldType fieldType() {
        final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> ft(m).getTextSearchInfo().getSimilarity());
import org.apache.lucene.search.Query;
                shingleFieldMappers,
        PrefixFieldType prefixField;
                return spanMulti;
                positionCount += posIncAtt.getPositionIncrement();
        CopyTo copyTo,
                norms,
                    || method == MultiTermQuery.CONSTANT_SCORE_REWRITE
            return delegate;
        }
            m -> toType(m).maxShingleSize,
        }
     * to induce the shingle token filter to create tokens at the end of the stream smaller than the shingle size
                return super.termQuery(value, context);
                }
            } else {
    @Override
            SearchAsYouTypeFieldType ft = new SearchAsYouTypeFieldType(
     * search_as_you_type structure
        Builder builder
import org.opensearch.common.lucene.search.AutomatonQueries;
            private final int extraPositionIncrements;
                if (caseInsensitive) {
        while (stream.incrementToken()) {
        return concat;
            createFieldNamesField(context);
                final Query query = prefixFieldType.prefixQuery(value, method, caseInsensitive, context);
            final PrefixFieldType prefixFieldType = new PrefixFieldType(fullName, prefixSearchInfo, Defaults.MIN_GRAM, Defaults.MAX_GRAM);
        }
                    indexAnalyzer.analyzer(),
     * The prefix field type handles prefix and phrase prefix queries that are delegated to it by the other field types in a
        protected List<Parameter<?>> getParameters() {
        // This is only here because for some reason the initial impl of this always serialized
        return (SearchAsYouTypeFieldMapper) in;
    private static final int MAX_SHINGLE_SIZE_LOWER_BOUND = 2;
            this.indexPrefixes = indexPrefixes;
import org.apache.lucene.queries.spans.SpanQuery;
    }
        public static final int MIN_GRAM = 1;
        }
    static final class PrefixFieldMapper extends FieldMapper {
}
                slop,
                tokenStream = new TrailingShingleTokenFilter(tokenStream, shingleSize - 1);
                throw new MapperParsingException(
            prefixft.setStored(false);
        }
        }
    public SearchAsYouTypeFieldMapper(
        final Parameter<Boolean> norms = TextParams.norms(true, m -> ft(m).getTextSearchInfo().hasNorms());
                meta
            FieldType fieldType,
            final String fullName = buildFullName(context);
        if (value == null) {
 * software distributed under the License is distributed on an
    }
        }
            Defaults.MAX_SHINGLE_SIZE
        protected String contentType() {
                );
            return new SearchAsYouTypeAnalyzer(delegate, shingleSize, true);
            prefixft.setOmitNorms(true);
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
            );
        final String value = extractValue(context);
        }
            // don't wrap the root field's search quote analyzer as prefix field doesn't support phrase queries
                fieldType,
            final ShingleFieldMapper[] shingleFieldMappers = new ShingleFieldMapper[maxShingleSize.getValue() - 1];
                return TextFieldMapper.createPhrasePrefixQuery(stream, name(), slop, maxExpansions, null, null);
                    return new ConstantScoreQuery(query);
            FieldType fieldType = new FieldType();
                final NamedAnalyzer shingleSearchQuoteWrapper = new NamedAnalyzer(
            fieldType.setOmitNorms(norms.getValue() == false);
        @Override
            final ShingleFieldType[] shingleFieldTypes = new ShingleFieldType[maxShingleSize.getValue() - 1];
            );
            );
            return new SearchAsYouTypeAnalyzer(delegate, shingleSize, false);
     */
                final NamedAnalyzer shingleSearchWrapper = new NamedAnalyzer(
        @Override
                    SearchAsYouTypeAnalyzer.withShingle(searchAnalyzer.analyzer(), shingleSize)
    static class ShingleFieldType extends StringFieldType {
 * license agreements. See the NOTICE file distributed with
        Iterator<Mapper> concat = Iterators.concat(super.iterator(), subIterators.iterator());
 * SPDX-License-Identifier: Apache-2.0
        @Override
            public void end() throws IOException {
                        + v
                // wrap the root field's index, search, and search quote analyzers with shingles
        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
        if (value == null) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getIndexAnalyzers()));
import org.apache.lucene.queries.spans.SpanTermQuery;
                shingleFieldMappers[i] = new ShingleFieldMapper(shingleft, shingleFieldType);
        public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
import org.opensearch.index.analysis.AnalyzerScope;
        @Override
            FieldType prefixft = new FieldType();
        }
                    shingleft,
        public void setPrefixField(PrefixFieldType prefixField) {
        @Override
        return CONTENT_TYPE;
            if (posIncAtt.getPositionIncrement() != 0) {
            }
    }
 * this work for additional information regarding copyright
import org.opensearch.index.similarity.SimilarityProvider;
        protected void parseCreateField(ParseContext context) {
            AutomatonQuery query = AutomatonQueries.createAutomatonQuery(new Term(name(), value + "*"), automaton, method);
            final ShingleFieldType shingleField = shingleFieldForPositions(numPos);
            Automaton automaton = Operations.concatenate(automata);
            if (prefixField != null && prefixField.termLengthWithinBounds(value.length())) {
        public int shingleSize() {
                    shingleSearchWrapper,
                        + MAX_SHINGLE_SIZE_UPPER_BOUND
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        @Override
                similarity,
            @Override
            return fieldType;
    }
            int numPos = countPosition(stream);
        public String toString() {
        }
            if (indexPrefixes) {
            return SourceValueFetcher.toString(name(), context, format);
                indexOptions,
                .add(new TermQuery(new Term(parentField, value)), BooleanClause.Occur.SHOULD)
    public static final String CONTENT_TYPE = "search_as_you_type";
                    shingleSize
                );
        @Override
 *
        }
        @Override
import java.util.ArrayList;
        @Override
        }
                throw new MapperParsingException("Cannot set [doc_values] on field of type [search_as_you_type]");
            final NamedAnalyzer prefixSearchWrapper = new NamedAnalyzer(
                name(),
                prefixFieldMapper,
                );
                store,
            return (PrefixFieldType) super.fieldType();
        }
        }
 * The OpenSearch Contributors require contributions made to
                multiFieldsBuilder.build(this, context),
    private final int maxShingleSize;
            this.minChars = minChars;
    public static String getShingleFieldName(String parentField, int shingleSize) {
import java.io.IOException;
                final Query query = prefixField.prefixQuery(value, method, caseInsensitive, context);
        super(simpleName, mappedFieldType, multiFields, copyTo);
            return fieldType().toString();
        @Override
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.Term;
                ft,
                super(input);
        private final int shingleSize;
        ) {
            this.shingleSize = shingleSize;
                analyzers.searchAnalyzer,
            public boolean incrementToken() throws IOException {
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).index, true);
import org.opensearch.common.collect.Iterators;
            return fieldType;
            this.maxChars = maxChars;
 */
        }
        }
            TextSearchInfo prefixSearchInfo = new TextSearchInfo(prefixft, similarity.getValue(), prefixSearchWrapper, searchAnalyzer);
        public Query existsQuery(QueryShardContext context) {
        private static class TrailingShingleTokenFilter extends TokenFilter {
import org.apache.lucene.analysis.CachingTokenFilter;
        subIterators.addAll(Arrays.asList(shingleFields));
                }
        this.termVectors = builder.termVectors.getValue();
            TokenStream tokenStream = components.getTokenStream();
        ShingleFieldType[] shingleFields = new ShingleFieldType[0];
    }
    }
            return indexPrefixes;
        }
import org.opensearch.search.lookup.SearchLookup;
            fieldType.setIndexOptions(TextParams.toIndexOptions(index.getValue(), indexOptions.getValue()));
            if (v) {
        }
        this.index = builder.index.getValue();
            ft.setShingleFields(shingleFieldTypes);
                return super.prefixQuery(value, method, caseInsensitive, context);
        }
        int positionCount = 0;
    static class SearchAsYouTypeAnalyzer extends AnalyzerWrapper {
            super(
        PrefixFieldType(String parentField, TextSearchInfo textSearchInfo, int minChars, int maxChars) {
                return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);
                }
        }
        }
                    shingleSearchQuoteWrapper
import org.apache.lucene.util.automaton.Automaton;
            }
        }
        return shingleFields;
        PrefixFieldType prefixFieldType;
            // parent field in _source. So we don't need to use the parent field name here.
        subIterators.add(prefixField);
                    searchAnalyzer.name(),
    @Override
 * compatible open source license.
        @Override
 * You may obtain a copy of the License at
import org.opensearch.index.query.QueryShardContext;
                );
                maxExpansions,
            return length >= minChars - 1 && length <= maxChars;
    /**
            throw new UnsupportedOperationException();
    /**
            false,
 * not use this file except in compliance with the License.
    private final PrefixFieldMapper prefixField;
import org.apache.lucene.search.BooleanClause;
            // wrap the root field's search analyzer with only shingles
        public String typeName() {
/**
                analyzers.getSearchAnalyzer(),
            this.shingleSize = shingleSize;
 * this file be licensed under the Apache-2.0 license or a
                    new PrefixQuery(new Term(name(), indexedValueForSearch(value)))
                SpanMultiTermQueryWrapper<?> spanMulti = new SpanMultiTermQueryWrapper<>(
            return CONTENT_TYPE;
 *     ├── [ ShingleFieldMapper, ShingleFieldType, analysis wrapped with max_shingle_size-shingles ]
            automata.add(Automata.makeString(value));
        public String typeName() {
        public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
    public Iterator<Mapper> iterator() {
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
        @Override
        }
            context.doc().add(new Field(subFieldMapper.fieldType().name(), value, subFieldMapper.getLuceneFieldType()));
                    return new ConstantScoreQuery(query);
        }
        List<Mapper> subIterators = new ArrayList<>();
        ShingleFieldMapper[] shingleFields,
            return;
 *
            for (int i = 0; i < shingleFieldMappers.length; i++) {
        }
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        return context.externalValueSet() ? context.externalValue().toString() : context.parser().textOrNull();
                    searchAnalyzer.scope(),
        final String parentField;
                } else {
            super(delegate.getReuseStrategy());
    public PrefixFieldMapper prefixField() {
            stream = new FixedShingleFilter(stream, shingleField.shingleSize);
        return positionCount;
        }
        @Override
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                } else {
            return SourceValueFetcher.toString(name(), context, format);
                fieldType.indexOptions() != IndexOptions.NONE,
                analyzers.getSearchQuoteAnalyzer(),
            @Override
                SearchAsYouTypeAnalyzer.withShingle(searchAnalyzer.analyzer(), maxShingleSize.getValue())
        PositionIncrementAttribute posIncAtt = stream.getAttribute(PositionIncrementAttribute.class);
        @Override
        }
 */
        boolean termLengthWithinBounds(int length) {
 * modifies the analysis chain of the root field to index terms the user would create as they type out the value in the root field
        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.analysis.AnalyzerWrapper;
                    || method == MultiTermQuery.CONSTANT_SCORE_REWRITE
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            return shingleField.phraseQuery(stream, 0, true);
        PrefixFieldMapper(FieldType fieldType, PrefixFieldType mappedFieldType) {
                meta.getValue()
            }
        private final boolean indexPrefixes;
            return shingleFields[Math.min(indexFromShingleSize, shingleFields.length - 1)];
            }
            }
            return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);
    public static class Builder extends ParametrizedFieldMapper.Builder {
        return parentField + "._" + shingleSize + "gram";
        this.maxShingleSize = builder.maxShingleSize.getValue();
                    similarity.getValue(),
            }
 * under the License.
            // parent field in _source. So we don't need to use the parent field name here.
        }).alwaysSerialize();
        @Override
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
        return toType(in).fieldType();
import org.apache.lucene.search.TermQuery;
    public SearchAsYouTypeFieldType fieldType() {
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> false, false).setValidator(v -> {
                    searchAnalyzer.name(),
        @SuppressWarnings("unchecked")
 *     ├── ...
    public ShingleFieldMapper[] shingleFields() {
            this.delegate = Objects.requireNonNull(delegate);
        }
                return input.incrementToken();
 * Modifications Copyright OpenSearch Contributors. See
                );
        @Override
            return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);
            return new SearchAsYouTypeFieldMapper(
                new TextSearchInfo(fieldType, similarity, searchAnalyzer, searchQuoteAnalyzer),
        final FieldType fieldType;
 * Mapper for a text field that optimizes itself for as-you-type completion by indexing its content into subfields. Each subfield
        final Parameter<String> termVectors = TextParams.termVectors(m -> toType(m).termVectors);
                stream,
        MultiFields multiFields,
                .build();
