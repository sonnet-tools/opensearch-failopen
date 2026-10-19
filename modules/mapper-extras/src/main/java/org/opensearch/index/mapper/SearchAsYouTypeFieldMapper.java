        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
        ) {  
     * ngrams token filter, it also adds a {@link TrailingShingleTokenFilter} to add extra position increments at the end of the stream
                maxShingleSize,
 *
            // don't wrap the root field's search quote analyzer as prefix field doesn't support phrase queries
    }
            if (posIncAtt.getPositionIncrement() != 0) {
        @Override
                this.positionIncrementAttribute = addAttribute(PositionIncrementAttribute.class);  
            this.shingleSize = shingleSize;  
import org.apache.lucene.document.FieldType;
                    return query;  
            final PrefixFieldType prefixFieldType = new PrefixFieldType(fullName, prefixSearchInfo, Defaults.MIN_GRAM, Defaults.MAX_GRAM);  
        while (stream.incrementToken()) {
                }
                similarity,
        this.index = builder.index.getValue();  
        final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> ft(m).getTextSearchInfo().getSimilarity());  
    public PrefixFieldMapper prefixField() {  
        final int maxChars;  
            if (shingleFields.length == 0 || slop > 0 || hasGaps(stream) || numPos <= 1) {
    ) {
     * handling phrase queries, it analyzes the query text to find the appropriate sized shingle subfield to delegate to. When handling
            return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);
import org.apache.lucene.queries.spans.SpanTermQuery;
import org.apache.lucene.index.Term;  
import java.util.Collections;
                final Query query = prefixFieldType.prefixQuery(value, method, caseInsensitive, context);  
                shingleFieldType.setPrefixFieldType(prefixFieldType);
            this.indexPrefixes = indexPrefixes;
        assert stream instanceof CachingTokenFilter;  
        subIterators.addAll(Arrays.asList(shingleFields));  
    }  
        // `doc_values=false`, even though it cannot be set; and so we need to continue
        return CONTENT_TYPE;  
                slop,  
        @Override  
            for (int i = 0; i < shingleFieldMappers.length; i++) {
            return Arrays.asList(  
    }
                final int shingleSize = i + 2;
        }  
    @Override
        }
        }
            context.doc().add(new Field(subFieldMapper.fieldType().name(), value, subFieldMapper.getLuceneFieldType()));
 * this work for additional information regarding copyright
    static class SearchAsYouTypeAnalyzer extends AnalyzerWrapper {
        }
            return (ShingleFieldType) super.fieldType();  
            if (shingleFields.length == 0 || slop > 0 || hasGaps(stream) || numPos <= 1) {  
        }
            } else {
            public boolean incrementToken() throws IOException {
            return fieldType;
        @Override
        }
        this.prefixField = prefixField;  
import org.opensearch.index.similarity.SimilarityProvider;
            return shingleField.multiPhraseQuery(stream, 0, true);
 * Licensed to Elasticsearch under one or more contributor  
            return shingleFields[Math.min(indexFromShingleSize, shingleFields.length - 1)];  
        @Override
            TokenStream tokenStream = components.getTokenStream();
            return length >= minChars - 1 && length <= maxChars;
        }  
            }
        return shingleFields;
    public SearchAsYouTypeFieldMapper(
        super(simpleName, mappedFieldType, multiFields, copyTo);
            for (int i = value.length(); i < minChars; i++) {  
            final ShingleFieldType shingleField = shingleFieldForPositions(numPos);
            throw new UnsupportedOperationException();
            } else {
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).index, true);  
                );
                return super.prefixQuery(value, method, caseInsensitive, context);
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {  
            }  
        subIterators.add(prefixField);
        }
        }  
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);
import static org.opensearch.index.mapper.TextFieldMapper.TextFieldType.hasGaps;
            fieldType.setIndexOptions(TextParams.toIndexOptions(index.getValue(), indexOptions.getValue()));
 * </pre>  
        this.maxShingleSize = builder.maxShingleSize.getValue();
import org.opensearch.search.lookup.SearchLookup;
            this.delegate = Objects.requireNonNull(delegate);
        FieldType getLuceneFieldType() {  
        @Override
import java.util.Iterator;
            AutomatonQuery query = AutomatonQueries.createAutomatonQuery(new Term(name(), value + "*"), automaton, method);
    private final String termVectors;  
    private final int maxShingleSize;
 *     └── [ PrefixFieldMapper, PrefixFieldType, analysis wrapped with max_shingle_size-shingles and edge-ngrams ]
        SearchAsYouTypeFieldType(
            String name,  
        }
    private static int countPosition(TokenStream stream) throws IOException {
            if (prefixFieldType != null && prefixFieldType.termLengthWithinBounds(value.length())) {  
        protected String contentType() {
    private final IndexAnalyzers indexAnalyzers;  
        return toType(in).fieldType();
        }
        final int minChars;
                positionCount += posIncAtt.getPositionIncrement();  
            return new TokenStreamComponents(components.getSource(), tokenStream);  
import org.apache.lucene.search.AutomatonQuery;
    private static final String PREFIX_FIELD_SUFFIX = "._index_prefix";
            final PrefixFieldMapper prefixFieldMapper = new PrefixFieldMapper(prefixft, prefixFieldType);
                shingleFieldMappers,
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
        // serializing it forever because of mapper assertions in mixed clusters.
        ).setValidator(v -> {
        PrefixFieldType(String parentField, TextSearchInfo textSearchInfo, int minChars, int maxChars) {  
                    shingleft,
            return indexPrefixes;
        }  
                prefixFieldName,
            }  
    }
        return maxShingleSize;  
                    indexAnalyzer.analyzer(),
                this  
        final TextParams.Analyzers analyzers;
                        + "]"  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            // parent field in _source. So we don't need to use the parent field name here.
        @Override
            if (indexPrefixes) {  
                return new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixFieldType.name(), indexedValueForSearch(value))), name());
 * license agreements. See the NOTICE file distributed with
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        }  
        }  
                    new PrefixQuery(new Term(name(), indexedValueForSearch(value)))  
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
    /**  
    }
        private final Parameter<Integer> maxShingleSize = Parameter.intParam(  
import org.apache.lucene.search.BooleanClause;  
                docValues,  
        }  
                prefixFieldType::termLengthWithinBounds  
            } else {  
                searchAnalyzer.scope(),
            final ShingleFieldMapper[] shingleFieldMappers = new ShingleFieldMapper[maxShingleSize.getValue() - 1];
            private final int extraPositionIncrements;  
        context.doc().add(new Field(prefixField.fieldType().name(), value, prefixField.getLuceneFieldType()));  
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {  
        }  
 */
            super(name);  
            @Override  
            if (indexPrefixes) {
        MultiFields multiFields,
import org.apache.lucene.util.automaton.Automaton;
            NamedAnalyzer searchAnalyzer,  
                maxExpansions,
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
                } else {  
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
import org.apache.lucene.search.TermQuery;  
        }
    private final PrefixFieldMapper prefixField;  
                    shingleSize  
        this.indexAnalyzers = builder.analyzers.indexAnalyzers;
                name,  
            TextParams.setTermVectorParams(termVectors.getValue(), fieldType);
        @Override  
        @Override
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
            return new SearchAsYouTypeAnalyzer(delegate, shingleSize, true);  
    }
        @Override  
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
 * not use this file except in compliance with the License.
    }  
        for (ShingleFieldMapper subFieldMapper : shingleFields) {  
                fieldType.indexOptions() != IndexOptions.NONE,  
     * The prefix field type handles prefix and phrase prefix queries that are delegated to it by the other field types in a  
    private String extractValue(ParseContext context) throws IOException {  
    @Override  
        public String typeName() {  
            final int indexFromShingleSize = Math.max(positions - 2, 0);
                }
                        + "], got ["
            }  
            }  
                final NamedAnalyzer shingleSearchWrapper = new NamedAnalyzer(
        return new Builder(simpleName(), this.indexAnalyzers).init(this);
                super(input);
     */
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
        @Override
    private final boolean index;  
     * to induce the shingle token filter to create tokens at the end of the stream smaller than the shingle size  
        @Override
        stream.reset();
                shingleft.setStored(false);
 * KIND, either express or implied.  See the License for the
                SpanMultiTermQueryWrapper<?> spanMulti = new SpanMultiTermQueryWrapper<>(
            prefixFieldType.setIndexAnalyzer(new NamedAnalyzer(indexAnalyzer.name(), AnalyzerScope.INDEX, prefixIndexWrapper));
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
     * search_as_you_type structure
 *
        }
                indexOptions,  
        PrefixFieldMapper(FieldType fieldType, PrefixFieldType mappedFieldType) {
        }
    public static final String CONTENT_TYPE = "search_as_you_type";
        }
     */
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        @Override  
        private final Analyzer delegate;
            );  
            // set up the prefix field
            return;
                return new FieldMaskingSpanQuery(new SpanTermQuery(new Term(prefixField.name(), indexedValueForSearch(value))), name());  
                TextSearchInfo textSearchInfo = new TextSearchInfo(  
        ShingleFieldType(String name, int shingleSize, TextSearchInfo textSearchInfo) {
            return delegate;
            return new BooleanQuery.Builder().add(query, BooleanClause.Occur.SHOULD)
import org.opensearch.common.collect.Iterators;
            ft.setShingleFields(shingleFieldTypes);
        if (value == null) {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    private final ShingleFieldMapper[] shingleFields;
                String fieldName = getShingleFieldName(buildFullName(context), shingleSize);
                    return super.termQueryCaseInsensitive(value, context);  
            }
            private final PositionIncrementAttribute positionIncrementAttribute;
        this.termVectors = builder.termVectors.getValue();  
                // wrap the root field's index, search, and search quote analyzers with shingles  
        @Override
    }
                norms,
import org.apache.lucene.analysis.CachingTokenFilter;  
    }
        return concat;  
        }
            }
    private static final int MAX_SHINGLE_SIZE_UPPER_BOUND = 4;  
import org.apache.lucene.search.Query;
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> false, false).setValidator(v -> {  
            ft.setPrefixField(prefixFieldType);  
        }  
        private SearchAsYouTypeAnalyzer(Analyzer delegate, int shingleSize, boolean indexPrefixes) {
        protected void mergeOptions(FieldMapper other, List<String> conflicts) {
        boolean termLengthWithinBounds(int length) {
    @Override
        @Override
                maxShingleSize.getValue()
import org.apache.lucene.search.ConstantScoreQuery;
 * Modifications Copyright OpenSearch Contributors. See
        return context.externalValueSet() ? context.externalValue().toString() : context.parser().textOrNull();
import org.apache.lucene.analysis.Analyzer;
            if (v) {
        return positionCount;  
        }  
            NamedAnalyzer searchAnalyzer = analyzers.getSearchAnalyzer();
            @Override
 *  
    }
    public SearchAsYouTypeFieldType fieldType() {
                similarity.getValue(),
    }
        }  
        int positionCount = 0;  
                    return new ConstantScoreQuery(query);
            super(delegate.getReuseStrategy());
        @Override  
                        + MAX_SHINGLE_SIZE_LOWER_BOUND  
            return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);  
        @Override
    private final boolean store;
            this.maxChars = maxChars;  
                analyzers.getSearchQuoteAnalyzer(),  
            if (prefixField != null && prefixField.termLengthWithinBounds(value.length())) {
        private ShingleFieldType shingleFieldForPositions(int positions) {
        @Override
            );
import java.util.List;  
            int numPos = countPosition(stream);
import org.opensearch.index.analysis.IndexAnalyzers;
/*  
        }
            }
                if (method == null
        return parentField + "._" + shingleSize + "gram";  
            return new SearchAsYouTypeAnalyzer(delegate, shingleSize, false);
        }
        public ShingleFieldType fieldType() {
        }).alwaysSerialize();  
        protected void parseCreateField(ParseContext context) {
        private final int shingleSize;
 * SPDX-License-Identifier: Apache-2.0
        @Override
            // parent field in _source. So we don't need to use the parent field name here.
            createFieldNamesField(context);
import org.apache.lucene.analysis.shingle.FixedShingleFilter;
                return input.incrementToken();
                fieldType,  
            NamedAnalyzer searchQuoteAnalyzer,
        }
    }
        private static class TrailingShingleTokenFilter extends TokenFilter {
        @SuppressWarnings("unchecked")
            super(mappedFieldtype.name(), fieldType, mappedFieldtype, MultiFields.empty(), CopyTo.empty());  
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getIndexAnalyzers()));  
 *     ├── ...  
                        + v
            FieldType fieldType = new FieldType();
            }
                fieldType.stored(),
            List<Automaton> automata = new ArrayList<>();
        public static final int MIN_GRAM = 1;
                index,
 * Mapper for a text field that optimizes itself for as-you-type completion by indexing its content into subfields. Each subfield
                    searchAnalyzer.name(),  
        this.store = builder.store.getValue();
            return "<" + getClass().getCanonicalName() + " shingleSize=[" + shingleSize + "] indexPrefixes=[" + indexPrefixes + "]>";
        List<Mapper> subIterators = new ArrayList<>();
                );
                return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);  
 * software distributed under the License is distributed on an
        }
        static SearchAsYouTypeAnalyzer withShingle(Analyzer delegate, int shingleSize) {
            TextSearchInfo prefixSearchInfo = new TextSearchInfo(prefixft, similarity.getValue(), prefixSearchWrapper, searchAnalyzer);
                analyzers.getSearchAnalyzer(),
            this.fieldType = fieldType;  
    }
            this.shingleSize = shingleSize;  
        FieldType getLuceneFieldType() {
            if (v < MAX_SHINGLE_SIZE_LOWER_BOUND || v > MAX_SHINGLE_SIZE_UPPER_BOUND) {  
import org.apache.lucene.search.MultiTermQuery;  
 *     [ SearchAsYouTypeFieldMapper, SearchAsYouTypeFieldType, unmodified analysis ]
    @Override  
            final String fullName = buildFullName(context);
                    searchAnalyzer.scope(),
                .build();
        }
                        + "] and at most "
        @Override
                automata.add(Automata.makeAnyChar());
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    SearchAsYouTypeAnalyzer.withShingle(searchAnalyzer.analyzer(), shingleSize)
            int numPos = countPosition(stream);
 * this file be licensed under the Apache-2.0 license or a
    }
            );
                    "[max_shingle_size] must be at least ["
                    || method == MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE) {
 *
        @Override
        ShingleFieldMapper(FieldType fieldType, ShingleFieldType mappedFieldtype) {
    /**  
        }  
        }
public class SearchAsYouTypeFieldMapper extends ParametrizedFieldMapper {
    static class ShingleFieldType extends StringFieldType {  
        protected String contentType() {
        PrefixFieldType prefixFieldType;
            automata.add(Automata.makeString(value));
        Iterator<Mapper> concat = Iterators.concat(super.iterator(), subIterators.iterator());
    public static class Defaults {  
        public void setPrefixField(PrefixFieldType prefixField) {  
        @Override  
                name(),
        PrefixFieldMapper prefixField,
                    searchAnalyzer.scope(),  
import java.util.Map;
    public static String getShingleFieldName(String parentField, int shingleSize) {
import java.util.Objects;
                name,
            stream = new FixedShingleFilter(stream, shingleField.shingleSize);  
                final SearchAsYouTypeAnalyzer shingleIndexWrapper = SearchAsYouTypeAnalyzer.withShingle(
    static class SearchAsYouTypeFieldType extends StringFieldType {
            final ShingleFieldType[] shingleFieldTypes = new ShingleFieldType[maxShingleSize.getValue() - 1];  
                    shingleSearchWrapper,  
     */
            throw new UnsupportedOperationException();
            return "prefix";
                meta.getValue()
import org.apache.lucene.document.Field;  
                        + "["
    private static SearchAsYouTypeFieldType ft(FieldMapper in) {  
    public Iterator<Mapper> iterator() {  
        }
            return (PrefixFieldType) super.fieldType();
            SimilarityProvider similarity,
            return CONTENT_TYPE;
        @Override  
                final Query query = prefixField.prefixQuery(value, method, caseInsensitive, context);
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its  
        if (value == null) {  
        String simpleName,  
        void setPrefixFieldType(PrefixFieldType prefixFieldType) {  
            return "prefix";  
            final String prefixFieldName = slop > 0 ? null : prefixFieldType.name();
            if (shingleFields.length == 0 || slop > 0 || hasGaps(stream) || numPos <= 1) {
        public static final int MAX_SHINGLE_SIZE = 3;  
                meta
    }
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {  
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {  
            SearchAsYouTypeFieldType ft = new SearchAsYouTypeFieldType(
            if (prefixField == null || prefixField.termLengthWithinBounds(value.length()) == false) {
        // This is only here because for some reason the initial impl of this always serialized  
        }
        final FieldType fieldType;
import java.util.Arrays;  
        static SearchAsYouTypeAnalyzer withShingleAndPrefix(Analyzer delegate, int shingleSize) {
        final String parentField;
            public void end() throws IOException {  
            FieldType fieldType,
    /**  
            stream = new FixedShingleFilter(stream, shingleField.shingleSize);
                spanMulti.setRewriteMethod(method);
        SearchAsYouTypeFieldType mappedFieldType,
        return (SearchAsYouTypeFieldType) super.fieldType();
    static final class PrefixFieldType extends StringFieldType {  
                throw new MapperParsingException("Cannot set [doc_values] on field of type [search_as_you_type]");
                );
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();  
        final Parameter<Boolean> norms = TextParams.norms(true, m -> ft(m).getTextSearchInfo().hasNorms());  
        CopyTo copyTo,  
        }
            // wrap the root field's index analyzer with shingles and edge ngrams
 * modifies the analysis chain of the root field to index terms the user would create as they type out the value in the root field
     * An analyzer wrapper to add a shingle token filter, an edge ngram token filter or both to its wrapped analyzer. When adding an edge
 * Unless required by applicable law or agreed to in writing,
    }  
            );
            return new SearchAsYouTypeFieldMapper(
            );
                );
        @Override
    @Override  
            return;
        final int shingleSize;
        public SearchAsYouTypeFieldMapper build(Mapper.BuilderContext context) {
        this.indexOptions = builder.indexOptions.getValue();
        }
     * The root field type, which most queries should target as it will delegate queries to subfields better optimized for the query. When
import org.apache.lucene.analysis.TokenStream;
                shingleFieldTypes[i] = shingleFieldType;  
                .add(new TermQuery(new Term(parentField, value)), BooleanClause.Occur.SHOULD)  
        public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
    protected void parseCreateField(ParseContext context) throws IOException {
        public Query existsQuery(QueryShardContext context) {
        public String typeName() {  
package org.opensearch.index.mapper;
                if (method == null
        @Override  
            return shingleField.phraseQuery(stream, 0, true);
                SearchAsYouTypeAnalyzer.withShingle(searchAnalyzer.analyzer(), maxShingleSize.getValue())
        @Override
            m -> toType(m).maxShingleSize,  
 * compatible open source license.
        @Override
 * <p>  
                return super.prefixQuery(value, method, caseInsensitive, context);
                SpanMultiTermQueryWrapper<?> spanMulti = new SpanMultiTermQueryWrapper<>(  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
            this.prefixFieldType = prefixFieldType;
import org.apache.lucene.search.BooleanQuery;
        return prefixField;
 * specific language governing permissions and limitations
            }
            this.minChars = minChars;
                termVectors,
    }
/*  
    private final String indexOptions;
import org.apache.lucene.search.PrefixQuery;
        @Override
                return super.termQuery(value, context);
            }
                    SearchAsYouTypeAnalyzer.withShingle(searchAnalyzer.analyzer(), shingleSize)
            );  
        }  
    /**
                FieldType shingleft = new FieldType(fieldType);  
            final NamedAnalyzer prefixSearchWrapper = new NamedAnalyzer(
        }
        }
            super(name, true, false, false, textSearchInfo, Collections.emptyMap());
    static final class PrefixFieldMapper extends FieldMapper {  
import org.opensearch.index.analysis.AnalyzerScope;  
                meta  
        this.shingleFields = shingleFields;
            TrailingShingleTokenFilter(TokenStream input, int extraPositionIncrements) {  
 *     ├── [ ShingleFieldMapper, ShingleFieldType, analysis wrapped with 2-shingles ]
            this.parentField = parentField;
import java.util.ArrayList;
            }
            fieldType.setOmitNorms(norms.getValue() == false);  
                copyTo.build(),  
        public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
                this.extraPositionIncrements = extraPositionIncrements;
            stream = new FixedShingleFilter(stream, shingleField.shingleSize);
            }  
            super(mappedFieldType.name(), fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());  
            return shingleSize;
                tokenStream = new TrailingShingleTokenFilter(tokenStream, shingleSize - 1);  
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;  
            false,
        final String value = extractValue(context);  
        public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {  
    public ShingleFieldMapper[] shingleFields() {
import org.opensearch.common.lucene.search.AutomatonQueries;
            prefixft.setIndexOptions(fieldType.indexOptions());
            }
                    || method == MultiTermQuery.CONSTANT_SCORE_REWRITE  
            }  
        @Override  
        public static final int MAX_GRAM = 20;
                throw new MapperParsingException(
                tokenStream = new EdgeNGramTokenFilter(tokenStream, Defaults.MIN_GRAM, Defaults.MAX_GRAM, true);
        }  
    }
    protected String contentType() {
            super(
                    similarity.getValue(),
import org.apache.lucene.queries.spans.SpanQuery;  
            throw new UnsupportedOperationException();
                store,
        protected Analyzer getWrappedAnalyzer(String fieldName) {
            if (value.length() >= minChars) {
                stream,
import org.apache.lucene.util.automaton.Automata;
                        + MAX_SHINGLE_SIZE_UPPER_BOUND  
            super(parentField + PREFIX_FIELD_SUFFIX, true, false, false, textSearchInfo, Collections.emptyMap());
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {  
        PositionIncrementAttribute posIncAtt = stream.getAttribute(PositionIncrementAttribute.class);
import org.opensearch.index.analysis.NamedAnalyzer;
        }
            tokenStream = new FixedShingleFilter(tokenStream, shingleSize, " ", "");
        }  
                    return query;
        }
            FieldType prefixft = new FieldType();  
    public int maxShingleSize() {
            return shingleField.phrasePrefixQuery(stream, 0, maxExpansions);  
        ShingleFieldType[] shingleFields = new ShingleFieldType[0];  
    }
                indexAnalyzer.analyzer(),
                    new PrefixQuery(new Term(name(), indexedValueForSearch(value)))
    public static class Builder extends ParametrizedFieldMapper.Builder {
        public String toString() {
                    || method == MultiTermQuery.CONSTANT_SCORE_REWRITE
        }).alwaysSerialize();
            return super.toString() + ",prefixChars=" + minChars + ":" + maxChars;  
        @Override  
                return TextFieldMapper.createPhraseQuery(stream, name(), slop, enablePositionIncrements);
 *     ├── [ ShingleFieldMapper, ShingleFieldType, analysis wrapped with max_shingle_size-shingles ]
        }  
        }
            final ShingleFieldType shingleField = shingleFieldForPositions(numPos);
            return TextFieldMapper.createPhrasePrefixQuery(  
 */
                searchAnalyzer.name(),  
        Builder builder  
        }
            return CONTENT_TYPE;
        }  
        public PrefixFieldType fieldType() {
            );
            throw new UnsupportedOperationException();
        protected void parseCreateField(ParseContext context) {
        @Override  
    private static SearchAsYouTypeFieldMapper toType(FieldMapper in) {
            Map<String, String> meta
            final ShingleFieldType shingleField = shingleFieldForPositions(numPos);  
 * You may obtain a copy of the License at  
            return "shingle";
        public int shingleSize() {  
                } else {
                prefixFieldMapper,
        final String value = extractValue(context);
     */
        return (SearchAsYouTypeFieldMapper) in;  
}  
                spanMulti.setRewriteMethod(method);  
            final Analyzer prefixIndexWrapper = SearchAsYouTypeAnalyzer.withShingleAndPrefix(  
 * the Apache License, Version 2.0 (the "License"); you may
            Automaton automaton = Operations.concatenate(automata);  
        }  
        public boolean indexPrefixes() {
            return SourceValueFetcher.toString(name(), context, format);
        @Override
        public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {  
            return SourceValueFetcher.toString(name(), context, format);
            prefixft.setOmitNorms(true);
        }
            // Because this internal field is modelled as a multi-field, SourceValueFetcher will look up its  
                    shingleSearchQuoteWrapper
/*
 */  
                return spanMulti;
                if (caseInsensitive) {
            this.prefixField = prefixField;
        context.doc().add(new Field(fieldType().name(), value, fieldType().fieldType));
    private static final int MAX_SHINGLE_SIZE_LOWER_BOUND = 2;
                );  
    }
/**  
 * under the License.  
            } else {
            }
        }
import org.apache.lucene.analysis.TokenFilter;
            this.analyzers = new TextParams.Analyzers(indexAnalyzers);
import org.opensearch.index.query.QueryShardContext;  
                    || method == MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE) {  
        final Parameter<String> indexOptions = TextParams.indexOptions(m -> toType(m).indexOptions);
            return fieldType;  
                positionIncrementAttribute.setPositionIncrement(extraPositionIncrements);
     * prefix or phrase prefix queries, it delegates to the prefix subfield  
            }
        }
        public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
                false,
                new TextSearchInfo(fieldType, similarity, searchAnalyzer, searchQuoteAnalyzer),  
                }
        context.documentInput().addField(fieldType(), value);  
        }  
                final ShingleFieldType shingleFieldType = new ShingleFieldType(fieldName, shingleSize, textSearchInfo);  
            NamedAnalyzer indexAnalyzer = analyzers.getIndexAnalyzer();
                shingleFieldType.setIndexAnalyzer(new NamedAnalyzer(indexAnalyzer.name(), AnalyzerScope.INDEX, shingleIndexWrapper));
            "max_shingle_size",
        ShingleFieldMapper[] shingleFields,
            if (prefixFieldType == null || prefixFieldType.termLengthWithinBounds(value.length()) == false) {  
            prefixft.setStored(false);  
 */  
        }
        final Parameter<String> termVectors = TextParams.termVectors(m -> toType(m).termVectors);
        PrefixFieldType prefixField;
        }
        protected List<Parameter<?>> getParameters() {
            return fieldType().toString();
        public String toString() {
                );
        }
            fieldType.setStored(store.getValue());
        @Override
                    return new ConstantScoreQuery(query);
            // wrap the root field's search analyzer with only shingles
import org.apache.lucene.analysis.AnalyzerWrapper;
                shingleFieldMappers[i] = new ShingleFieldMapper(shingleft, shingleFieldType);
    }  
                final NamedAnalyzer shingleSearchQuoteWrapper = new NamedAnalyzer(
        public String toString() {  
                );
                ft,
        public String typeName() {  
            this.shingleFields = shingleFields;
            return SourceValueFetcher.toString(name(), context, format);
                analyzers.searchQuoteAnalyzer,
 * <pre>  
        }
            ft.setIndexAnalyzer(analyzers.getIndexAnalyzer());  
            }
 * GitHub history for details.
 * The structure of these fields is
     * The shingle field type handles phrase queries and delegates prefix and phrase prefix queries to the prefix field
        private final boolean indexPrefixes;  
    @Override
                analyzers.searchAnalyzer,  
            int numPos = countPosition(stream);  
            Defaults.MAX_SHINGLE_SIZE
            // set up the shingle fields
                return TextFieldMapper.createPhrasePrefixQuery(stream, name(), slop, maxExpansions, null, null);
    }
                analyzers.indexAnalyzer,
        }
                buildFullName(context),
                return spanMulti;  
                    searchAnalyzer.name(),
import org.apache.lucene.index.IndexOptions;
 * The OpenSearch Contributors require contributions made to  
        if (fieldType().fieldType.omitNorms()) {
    static final class ShingleFieldMapper extends FieldMapper {  
                multiFieldsBuilder.build(this, context),
    }  
import org.apache.lucene.util.automaton.Operations;  
                super.end();
        public void setShingleFields(ShingleFieldType[] shingleFields) {
        @Override
