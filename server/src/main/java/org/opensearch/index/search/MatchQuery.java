                     */
            case ALL:
        this.fuzzyPrefixLength = fuzzyPrefixLength;
 * the Apache License, Version 2.0 (the "License"); you may
                        return analyzeTerm(field, stream, type == Type.BOOLEAN_PREFIX);  
                return clauses[0];
                throw new IllegalStateException("unknown zeroTermsQuery " + zeroTermsQuery);
            } else {
            } catch (IllegalArgumentException | IllegalStateException e) {
import org.apache.lucene.search.MultiTermQuery;
                }
                    return null;  
         */
                } else {  
                break;
        protected Query createPhrasePrefixQuery(String field, String queryText, int slop) {
import org.apache.lucene.search.TermQuery;
            TermToBytesRefAttribute termAtt = in.getAttribute(TermToBytesRefAttribute.class);
                    assert terms.length > 0;  
        }
import org.opensearch.core.common.io.stream.StreamOutput;
    public void setZeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {  
        this.autoGenerateSynonymsPhraseQuery = enabled;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
            }
                final SpanQuery queryPos;
        BOOLEAN_PREFIX(3);
import org.apache.lucene.analysis.Analyzer;
    }
                        // simple phrase  
                    fuzzyRewriteMethod,
import java.io.IOException;
                        throw new IndexSearcher.TooManyClauses();
                if (positionCount > 1) {
        protected Query analyzePhrase(String field, TokenStream stream, int slop) throws IOException {
                // formulate a single term, boolean, or phrase.
        switch (type) {  
    }
                return clauses.get(0);
                    };
                return isPrefix ? fieldType.spanPrefixQuery(terms[0].text(), spanRewriteMethod, context) : new SpanTermQuery(terms[0]);
                if (isPrefix) {
                return builder.build();  
                if (graph.hasSidePath(start)) {
                }  
                    return newLenientFieldQuery(field, e);
                    if (positionIncrement != 0) {  
            stream.end();
                }
            this.ordinal = ordinal;
import org.opensearch.core.common.io.stream.StreamInput;  
                if (lenient) {  
                }
        ) {  
                TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
        }
            }  
                    return newLenientFieldQuery(fieldType.name(), e);
                    if (clauses.size() >= maxClauseCount) {
                throw e;  
                        return analyzeBoolean(field, stream);
        MatchQueryBuilder builder = new MatchQueryBuilder(analyzer, fieldType, enablePositionIncrements, autoGenerateSynonymsPhraseQuery);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void setFuzzyPrefixLength(int fuzzyPrefixLength) {  
                query = builder.createBooleanPrefixQuery(fieldName, value.toString(), occur);
                        return analyzePhrase(field, stream, phraseSlop);
    }
                 */  
import org.opensearch.index.query.QueryShardContext;
                boolean usePrefix = isPrefix && end == -1;
import org.opensearch.common.lucene.Lucene;
                } else {
                                throw new IndexSearcher.TooManyClauses();
        @Override
         * @return {@code PrefixQuery}, {@code BooleanQuery}, based on the analysis of {@code queryText}
            return createQuery(field, queryText, type, operator, slop);  
                    if (type == Type.PHRASE || type == Type.PHRASE_PREFIX) {
            // this field is a concrete field or an alias so we use the
        }
                }  
        MatchQueryBuilder(  
            this.ordinal = ordinal;
    public void setTranspositions(boolean transpositions) {  
                    }  
                            .map(t -> new TermAndBoost(t.bytes(), BoostAttribute.DEFAULT_BOOST))  
            boolean enablePositionIncrements,  
        this.spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause(maxExpansions, false);  
            for (int i = 0; i <= articulationPoints.length; i++) {
            default:
                    return newLenientFieldQuery(field, e);
                    .toArray(TermAndBoost[]::new);
        float maxTermFrequency
    public void setEnablePositionIncrements(boolean enablePositionIncrements) {  
                break;
        this.fuzziness = fuzziness;  
                if (queryPos != null) {
                return;
                    /*
     */  
                PositionLengthAttribute posLenAtt = stream.addAttribute(PositionLengthAttribute.class);  
                    return newLenientFieldQuery(field, e);
        }
                if (termAtt == null) {
                        public boolean hasNext() {
        @Override
                    ? fieldType.spanPrefixQuery(terms[i].text(), spanRewriteMethod, context)
         * If a keyword analyzer is used, we know that further analysis isn't  
                return fieldType.phrasePrefixQuery(stream, slop, maxExpansions, context);
            if (fuzziness != null) {
                        }
                    // phrase
            try {  
 * You may obtain a copy of the License at  
     *
                    }
        this.lenient = lenient;  
                // phase 1: read through the stream and assess the situation:  
    protected final QueryShardContext context;  
        NONE(0),
            add(q, field, currentQuery, operator, isPrefix && lastOffset == offsetAtt.endOffset());
            int lastState = 0;
                if (queryPos != null) {  
        protected Query createFieldQuery(
                lastOffset = offsetAtt.endOffset();
            int maxClauseCount = IndexSearcher.getMaxClauseCount();
 * Modifications Copyright OpenSearch Contributors. See
                builder.addClause(spanQuery);
        }
                SpanQuery spanQuery = isPrefix
    protected boolean transpositions = FuzzyQuery.defaultTranspositions;  
import org.apache.lucene.search.IndexSearcher;
            return createQuery(field, queryText, Type.BOOLEAN_PREFIX, occur, 0);
    }
                lastState = end;  
                  return empty BooleanQuery result
                boolean isGraph = false;  
 * Licensed to Elasticsearch under one or more contributor  
                throw new AssertionError();
            case NONE:  
            } else {
         * @param queryText text to be passed to the analyzer
        this.analyzer = context.getMapperService().getIndexAnalyzers().get(analyzerName);
                    if (positionCount == 1) {
                    }  
            stream.reset();  
    }  
                    }
        for (BooleanClause clause : bq.clauses()) {  
                        // complex case: multiple positions  
                if (zeroTermsQuery.ordinal == ord) {
/*  
        }
    }  
        public void writeTo(StreamOutput out) throws IOException {  
        protected Query analyzeMultiPhrase(String field, TokenStream stream, int slop) throws IOException {
        }
            try (TokenStream source = analyzer.tokenStream(field, queryText)) {  
                  check if the GraphTokenStreamFiniteStrings graph is empty  
import org.apache.lucene.search.BooleanClause.Occur;  
    protected Analyzer analyzer;
                    // phrase prefix
                    : new SpanTermQuery(terms[i]);
                int start = lastState;
            if (type == Type.BOOLEAN_PREFIX
            stream.end();
            boolean autoGenerateSynonymsPhraseQuery
        /**
            return createQuery(field, queryText, Type.PHRASE_PREFIX, occur, slop);
        Query booleanQuery = builder.createBooleanQuery(field, queryText, lowFreqOccur);  
                }  
            if (fieldType.getTextSearchInfo().hasPositions()) {  
        }
            try {
        }
            }  
                query = builder.createPhraseQuery(fieldName, value.toString(), phraseSlop);
        private Query analyzeTerm(String field, TokenStream stream, boolean isPrefix) throws IOException {
         * Creates a new QueryBuilder using the given analyzer.
                if (lenient) {  
                    } else {  
        }  
            assert operator == BooleanClause.Occur.SHOULD || operator == BooleanClause.Occur.MUST;
            return new SpanOrQuery(spanQueries);
         * The text is analyzed and terms are added to a boolean query.  
        }  
        // this is used internally to make sure that query_string and simple_query_string
                throw new IllegalStateException("field:[" + field + "] was indexed without position data; cannot run PhraseQuery");
                    Iterator<Query> queries = new Iterator<Query>() {  
            PositionIncrementAttribute posIncAtt = in.getAttribute(PositionIncrementAttribute.class);  
 * @opensearch.internal
        private Query analyzeMultiBoolean(String field, TokenStream stream, BooleanClause.Occur operator, boolean isPrefix)  
                        hasSynonyms = true;  
            String field,
                        // only one position, with synonyms  
                    queryPos = newGraphSynonymQuery(queries);  
         * @param queryText text to be passed to the analyzer  
    }
                return Queries.newMatchNoDocsQuery("Matching no documents because no terms present");
                /*
        }  
        private void checkForPositions(String field) {
import org.opensearch.OpenSearchException;
                int start = lastState;  
                    } else {  
                    }  
}
            GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(source);
                    setEnableGraphQueries(true);
         */
                if (i < articulationPoints.length) {  
            throw new IllegalArgumentException("No analyzer found for [" + analyzerName + "]");
                        final TermAndBoost[] termAndBoosts = Arrays.stream(terms)
                        builder.add(query, BooleanClause.Occur.SHOULD);  
                 * and using them to create phrase queries with the appropriate slop.
            assert type == Type.PHRASE_PREFIX || type == Type.PHRASE;
                    query = builder.createBooleanQuery(fieldName, value.toString(), occur);  
        }  
        BOOLEAN(0),
        public void writeTo(StreamOutput out) throws IOException {
            fieldName = fieldType.name();  
            if (fieldType.getTextSearchInfo().hasPositions() == false) {  
         * a prefix query instead  
            return builder.build();  
 */  
         * Builds a new prefix query instance.  
            BooleanClause.Occur operator,
                            return createFieldQuery(ts, type, BooleanClause.Occur.MUST, field, 0);  
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;
                } else {
                throw e;  
 */
                if (lenient) {  
        this.analyzer = analyzer;  
    }
public class MatchQuery {  
                return builder.newTermQuery(term, BoostAttribute.DEFAULT_BOOST);  
        }
                    queryPos = newSpanQuery(terms, usePrefix);  
            int ord = in.readVInt();  
            return isPrefix && lastOffset == offsetAtt.endOffset()  
    public void setFuzziness(Fuzziness fuzziness) {
                }
                querySupplier = () -> fieldType.fuzzyQuery(
            stream.reset();
                    setEnableGraphQueries(false);  
                }  
     *
        if (analyzer == null) {  
                            }
                    return newLenientFieldQuery(term.field(), e);
 */
        this.zeroTermsQuery = zeroTermsQuery;
            List<SpanQuery> clauses = new ArrayList<>();
 * under the License.  
        this.context = context;
            int slop
                        queryPos = newSynonymQuery(field, termAndBoosts);
    class MatchQueryBuilder extends QueryBuilder {  
                        @Override  
                query = builder.createPhrasePrefixQuery(fieldName, value.toString(), phraseSlop);  
                    }
            }  
        /**
            try {
import static org.opensearch.common.lucene.search.Queries.newUnmappedFieldQuery;
                if (source.hasAttribute(DisableGraphAttribute.class)) {
    public void setOccur(BooleanClause.Occur occur) {  
        if (fields.contains(fieldName)) {
        this.phraseSlop = phraseSlop;
import org.opensearch.core.common.io.stream.Writeable;
            // Use the analyzer to get all the tokens, and then build an appropriate
                    : new SpanTermQuery(lastTerm);
                    fuzziness,
     * Type of the match  
        }
                boolean usePrefix = end == -1 && type == Type.PHRASE_PREFIX;
    protected MultiTermQuery.RewriteMethod fuzzyRewriteMethod;
    public static final boolean DEFAULT_LENIENCY = false;
                } else {
                return new SpanNearQuery(clauses.toArray(new SpanQuery[0]), 0, true);
        }
                int numTokens = 0;  
import org.apache.lucene.analysis.CachingTokenFilter;
                }
                final TermAndBoost[] termAndBoosts = current.stream()
             * Creates a span near (phrase) query from a graph token stream.
        }
                }
/*
                if (posIncrAtt.getPositionIncrement() != 0) {  
        /**
                        positionCount += positionIncrement;
                    Iterator<TokenStream> it = graph.getFiniteStrings(start, end);
 *  
                } else if (numTokens == 1) {
                    }
         * The text is analyzed, terms are added to a boolean query with the last term acting as a prefix.  
            final Term term = new Term(fieldName, value.toString());  
        @Override
                            queries.add(q);
import org.apache.lucene.analysis.TokenStream;  
                return query;
                }  
            }
                }  
    protected Analyzer getAnalyzer(MappedFieldType fieldType, boolean quoted) {  
        switch (zeroTermsQuery) {  
        /*
    }  
                    return type;
                    builder.addGap(posIncAtt.getPositionIncrement() - 1);  
        public static ZeroTermsQuery readFromStream(StreamInput in) throws IOException {
        /**
            if (clauses.isEmpty()) {
            case PHRASE:
                    return null;  
    }
import java.util.Set;
                            .toArray(TermAndBoost[]::new);
        final Query query;
        String field,  
        this.enablePositionIncrements = enablePositionIncrements;
            try {  
            BooleanQuery.Builder q = newBooleanQuery();
            /*  
                q.add(newSynonymQuery(field, termAndBoosts), operator);
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;
import java.util.Arrays;
     * @opensearch.internal
                lastTerm = new Term(field, termAtt.getBytesRef());
        protected Query createBooleanPrefixQuery(String field, String queryText, BooleanClause.Occur occur) {  
            }
            int lastOffset = 0;
                            final Type type;  
                if (graph.hasSidePath(start)) {  
    protected int phraseSlop = DEFAULT_PHRASE_SLOP;
                try {
                } else {  
            }  
    protected ZeroTermsQuery zeroTermsQuery = DEFAULT_ZERO_TERMS_QUERY;  
            SpanQuery[] clauses = query.getClauses();
            Term lastTerm = null;  
        this.occur = occur;
                // counting the number of tokens/positions and marking if we have any synonyms.
import org.apache.lucene.queries.spans.SpanQuery;  
                    }
    private Query createCommonTermsQuery(
                    q.add(newTermQuery(current.get(0), BoostAttribute.DEFAULT_BOOST), operator);
            }  
             * The articulation points of the graph are visited in order and the queries
            } catch (IOException e) {
        this.fuzzyRewriteMethod = fuzzyRewriteMethod;
                ? newPrefixQuery(term)
    }
                        TokenStream ts = it.next();
         */  
import java.util.ArrayList;  
            throw new OpenSearchException("unknown serialized type [" + ord + "]");
                    if (query != null) {
        }
        this.commonTermsCutoff = cutoff;  
                }
import org.apache.lucene.queries.spans.SpanTermQuery;
                    if (enableGraphQueries && positionLength > 1) {
            }
            } else {  
                if (i < articulationPoints.length) {
                if (lastTerm != null) {
    protected boolean lenient = DEFAULT_LENIENCY;
 *
                );
                        throw new IndexSearcher.TooManyClauses();
        if (analyzer == null) {
            int[] articulationPoints = graph.articulationPoints();  
        @Override  
                throw new IllegalStateException("No type found for [" + type + "]");
                if (posIncAtt.getPositionIncrement() > 1) {
         *
            for (Type type : Type.values()) {  
         */
            if (clauses.length == 1) {  
            SpanNearQuery query = builder.build();
                        SpanQuery q = createSpanQuery(ts, field, usePrefix);
            // query based on the analysis chain.
        final MappedFieldType fieldType = context.fieldMapper(fieldName);  
                    }
 * software distributed under the License is distributed on an
            } else if (clauses.size() == 1) {
        public static Type readFromStream(StreamInput in) throws IOException {
                if (fieldType.unwrap() instanceof MatchOnlyTextFieldMapper.MatchOnlyTextFieldType) {
                        }
            }
    ) {
                 */
            MappedFieldType fieldType,
            PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);  
            }
                }  
                break;  
import org.apache.lucene.util.graph.GraphTokenStreamFiniteStrings;  
                    return analyzePhrasePrefix(field, stream, phraseSlop, positionCount);
     * Query with zero terms  
        }
 * Foundation match query
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
            }
    protected boolean enablePositionIncrements = true;  
        FuzzyQuery.defaultMaxExpansions,
        false  
        NULL(2);  
                }
    }
                int end = -1;
            }  
            source.reset();  
                return fieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
                throw e;
                    clauses.add(queryPos);
            if (lastTerm != null) {
package org.opensearch.index.search;
 * this work for additional information regarding copyright
                    // single term
/*  
                        return analyzeGraphPhrase(stream, field, type, phraseSlop);
import org.opensearch.index.mapper.KeywordFieldMapper;  
                    add(q, field, currentQuery, operator, false);
 * license agreements. See the NOTICE file distributed with
                    if (queries.size() > 0) {
            assert operator == BooleanClause.Occur.SHOULD || operator == BooleanClause.Occur.MUST;
                currentQuery.add(new Term(field, termAtt.getBytesRef()));
            assert fields.size() == 1;  
        }  
                } else {  
    protected int maxExpansions = FuzzyQuery.defaultMaxExpansions;
    public void setPhraseSlop(int phraseSlop) {
            return newUnmappedFieldQuery(fieldName);
    protected Query zeroTermsQuery() {
                        @Override
    public void setMaxExpansions(int maxExpansions) {
            int[] articulationPoints = graph.articulationPoints();  
    }
            }
                    Term[] terms = graph.getTerms(field, start);
    }
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;  
            } else {  
            this.fieldType = fieldType;
            if (termAtt == null) {
        }  
                && (fieldType.unwrap() instanceof TextFieldMapper.TextFieldType
 * GitHub history for details.
            Analyzer analyzer,  
            super(analyzer);  
            while (in.incrementToken()) {
        Occur highFreqOccur,
            // field type name directly
            } else {
            if (!(clause.query() instanceof TermQuery termQuery)) {
                    .map(t -> new TermAndBoost(t.bytes(), BoostAttribute.DEFAULT_BOOST))  
                break;
            } catch (RuntimeException e) {
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
            boolean quoted,
         */
                        return analyzeMultiBoolean(field, stream, operator, type == Type.BOOLEAN_PREFIX);
                    int positionLength = posLenAtt.getPositionLength();  
            default:  
         */
                    ? fieldType.spanPrefixQuery(lastTerm.text(), spanRewriteMethod, context)  
                     * A {@link TokenFilter} in this {@link TokenStream} disabled the graph analysis to avoid  
                        return analyzePhrasePrefix(field, stream, phraseSlop, positionCount);
import org.apache.lucene.queries.spans.SpanNearQuery;
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;  
                    // graph  
import org.opensearch.common.lucene.search.Queries;  
            SpanQuery[] spanQueries = new SpanQuery[terms.length];
                    return zeroTermsQuery;  
            out.writeVInt(this.ordinal);
            }
            int lastOffset = offsetAtt.endOffset();
         * Creates a boolean prefix query from the query text.  
 * specific language governing permissions and limitations
        if (booleanQuery != null && booleanQuery instanceof BooleanQuery bq) {
                    } else {  
        return query == null ? zeroTermsQuery() : query;
/**
    }
                : newTermQuery(term, BoostAttribute.DEFAULT_BOOST);
import org.apache.lucene.search.FuzzyQuery;  
 * ownership. Elasticsearch licenses this file to you under  
        }  
                if (lenient) {  
                } else if (type == Type.PHRASE_PREFIX) {  
        this.maxExpansions = maxExpansions;
import java.util.function.Supplier;
            Supplier<Query> querySupplier;  
                querySupplier = () -> fieldType.termQuery(term.bytes(), context);  
        Set<String> fields = context.simpleMatchToIndexNames(fieldName);
                }
            throws IOException {
                }
                        return analyzeMultiPhrase(field, stream, phraseSlop);
        private final int ordinal;
                stream.reset();
            if (phraseSlop > 0) {
                            if (getAutoGenerateMultiTermSynonymsPhraseQuery()) {
    public void setAutoGenerateSynonymsPhraseQuery(boolean enabled) {
        ALL(1),  
            OffsetAttribute offsetAtt = stream.addAttribute(OffsetAttribute.class);  
            int lastState = 0;
    public void setCommonTermsCutoff(Float cutoff) {
            while (stream.incrementToken()) {
            case PHRASE_PREFIX:
                return null;
                return query;  
                    || fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType)) {  
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
                if (!graphIt.hasNext()) {
         */
 * compatible open source license.
                    maxExpansions,  
        Analyzer analyzer = getAnalyzer(fieldType, type == Type.PHRASE || type == Type.PHRASE_PREFIX);  
    protected boolean autoGenerateSynonymsPhraseQuery = true;
        /**  
            }
            SpanNearQuery.Builder builder = new SpanNearQuery.Builder(field, true);
import org.apache.lucene.util.QueryBuilder;
        private SpanQuery newSpanQuery(Term[] terms, boolean isPrefix) {  
        private Query analyzePhrasePrefix(String field, TokenStream stream, int slop, int positionCount) throws IOException {
                        return analyzeGraphBoolean(field, stream, operator, type == Type.BOOLEAN_PREFIX);
                throw e;  
        /**
         * prefix query and the field type supports prefix queries, we return
    /**
 * Unless required by applicable law or agreed to in writing,
            // Build an appropriate query based on the analysis chain.
                    }
import org.opensearch.index.mapper.MappedFieldType;
            final Term term = new Term(field, termAtt.getBytesRef());  
         * @param field field name
                    } else {
                    return builder.build();
                }
    public MatchQuery(QueryShardContext context) {  
            Analyzer analyzer,
        private Query analyzeGraphBoolean(String field, TokenStream source, BooleanClause.Occur operator, boolean isPrefix)
            case BOOLEAN:
    public void setAnalyzer(String analyzerName) {
        private Query analyzeGraphPhrase(TokenStream source, String field, Type type, int slop) throws IOException {  
            Type type = quoted ? Type.PHRASE : Type.BOOLEAN;
    }
            for (int i = 0; i < terms.length; i++) {
            if (!stream.incrementToken()) {  
        /**  
                    return;
        if (analyzer == Lucene.KEYWORD_ANALYZER && type != Type.PHRASE_PREFIX) {
                            return it.hasNext();  
                    return createFieldQuery(source, type, operator, field, phraseSlop);  
                int positionCount = 0;
        private Query createQuery(String field, String queryText, Type type, BooleanClause.Occur operator, int phraseSlop) {  
 * not use this file except in compliance with the License.
                    int positionIncrement = posIncAtt.getPositionIncrement();
                Query query = querySupplier.get();  
 * KIND, either express or implied.  See the License for the
                    term.text(),  
         * Creates a phrase prefix query from the query text.
    }
            } catch (RuntimeException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;  
                checkForPositions(field);  
                }
                                type = Type.BOOLEAN;
                return null;
            }  
                    if (hasSynonyms) {
                }
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.common.lucene.search.Queries.newLenientFieldQuery;
                    if (type == Type.PHRASE_PREFIX) {  
        return booleanQuery;
                    assert terms.length > 0;
                BooleanQuery.Builder builder = new BooleanQuery.Builder();
                    // boolean
                Iterator<TokenStream> it = graph.getFiniteStrings();
    public void setLenient(boolean lenient) {
         * The text is analyzed and used as a phrase query.
    @Deprecated
            return q.build();  
    public void setAnalyzer(Analyzer analyzer) {
            GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(source);
        }  
            }  
            return analyzer;
                    builder.addClause(new SpanTermQuery(lastTerm));  
                        // We don't apply prefix on synonyms
                throw new RuntimeException("Error analyzing query text", e);
        MatchQueryBuilder builder,
                            } else {  
    public enum Type implements Writeable {
            case BOOLEAN_PREFIX:  
                    context  
                int end = -1;
                lastState = end;
    protected final Query parseInternal(Type type, String fieldName, MatchQueryBuilder builder, Object value) throws IOException {
        ZeroTermsQuery(int ordinal) {
                setAutoGenerateMultiTermSynonymsPhraseQuery(false);  
            OffsetAttribute offsetAtt = stream.addAttribute(OffsetAttribute.class);
            }
                if (type.ordinal == ord) {
import org.apache.lucene.queries.spans.SpanOrQuery;
        }  
        }
    private Query boolToExtendedCommonTermsQuery(BooleanQuery bq, Occur highFreqOccur, Occur lowFreqOccur, float maxTermFrequency) {
                // phase 2: based on token count, presence of synonyms, and options  
                if (commonTermsCutoff == null) {
            }
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            try {  
                }
            }
            query.add(termQuery.getTerm());
                     * paths explosion. See {@link org.opensearch.index.analysis.ShingleTokenFilterFactory} for details.
             * created at each point are merged in the returned near query.  
    }  
    }
                    }  
        if (fieldType == null) {
                return fieldType.prefixQuery(term.text(), null, context);
    protected int fuzzyPrefixLength = FuzzyQuery.defaultPrefixLength;  
         * needed and can immediately return a term query. If the query is a bool
                        queryPos = usePrefix ? newPrefixQuery(terms[0]) : newTermQuery(terms[0], BoostAttribute.DEFAULT_BOOST);
            source.reset();  
        /**  
                final Query queryPos;  
                while (it.hasNext()) {  
                    if (terms.length == 1) {
                throw new RuntimeException("Error analyzing query text", e);
            }  
        this.transpositions = transpositions;
 *
        protected Query newTermQuery(Term term, float boost) {
            throws IOException {
                checkForPositions(field);
            } catch (IOException e) {
        }  
                        public Query next() {
    }  
                    } else {
                }  
    protected SpanMultiTermQueryWrapper.SpanRewriteMethod spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause(
                    } else {
import org.apache.lucene.search.BooleanClause;
            List<Term> currentQuery = new ArrayList<>();  
            }  
        private void add(BooleanQuery.Builder q, String field, List<Term> current, BooleanClause.Occur operator, boolean isPrefix) {
    );
                if (numTokens == 0) {
    public enum ZeroTermsQuery implements Writeable {
                    Query query = createFieldQuery(it.next(), type, BooleanClause.Occur.MUST, field, slop);
                } else if (type == Type.PHRASE && positionCount > 1) {  
            case NULL:
                spanQueries[i] = isPrefix  
                /*  
                PositionIncrementAttribute posIncAtt = stream.addAttribute(PositionIncrementAttribute.class);
                    end = articulationPoints[i];
            if (current.isEmpty()) {  
 */  
import java.util.List;  
            }
    }
                boolean hasSynonyms = false;
                }
         * @param field field name  
            if (terms.length == 1) {
                Iterator<TokenStream> graphIt = graph.getFiniteStrings();  
            int ord = in.readVInt();
            out.writeVInt(this.ordinal);
                return Queries.newMatchAllQuery();  
                    while (it.hasNext()) {  
                }
            throw new OpenSearchException("unknown serialized type [" + ord + "]");  
     */  
        private final int ordinal;
                        queryPos = null;
        }
                } finally {
                }
                    Term[] terms = graph.getTerms(field, start);
            } catch (IllegalArgumentException | IllegalStateException e) {
                        if (q != null) {  
                    numTokens++;
            }
                    q.add(newPrefixQuery(current.get(0)), operator);
        } else {  
                    throw e;  
            return quoted ? context.getSearchQuoteAnalyzer(fieldType) : context.getSearchAnalyzer(fieldType);
                    transpositions,
     * @opensearch.internal
        }  
                    } else {
                }  
        }
                    final Iterator<TokenStream> it = graph.getFiniteStrings(start, end);
                    end = articulationPoints[i];  
                while (stream.incrementToken()) {  
            try (CachingTokenFilter stream = new CachingTokenFilter(source)) {
    }
import org.opensearch.common.unit.Fuzziness;
    public static final ZeroTermsQuery DEFAULT_ZERO_TERMS_QUERY = ZeroTermsQuery.NONE;
        PHRASE(1),  
         * The text is analyzed and used in a phrase query, with the last term acting as a prefix.
                    currentQuery.clear();
                return bq;
        protected Query newPrefixQuery(Term term) {
import org.apache.lucene.index.Term;
        Type(int ordinal) {  
                 * Creates a boolean query from the graph token stream by extracting all the finite strings from the graph
        }
                    List<SpanQuery> queries = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
        private final MappedFieldType fieldType;
        PHRASE_PREFIX(2),
            return boolToExtendedCommonTermsQuery(bq, highFreqOccur, lowFreqOccur, maxTermFrequency);
        @Override  
                            if (queries.size() >= maxClauseCount) {
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
                        isGraph = true;
    }  
        @Override
    protected Float commonTermsCutoff = null;
        return query;  
    protected BooleanClause.Occur occur = BooleanClause.Occur.SHOULD;
    }
import java.util.Iterator;
            }
             */
                return null;  
        }
import org.apache.lucene.search.Query;  
import org.opensearch.index.mapper.TextFieldMapper;  
        String queryText,
            if (current.size() == 1) {  
                        }
                } else if (isGraph) {
 *  
                                type = usePrefix ? Type.PHRASE_PREFIX : Type.PHRASE;
            String queryText,  
                        queryPos = new SpanOrQuery(queries.toArray(new SpanQuery[0]));
                    builder.add(queryPos, operator);  
                            TokenStream ts = it.next();
                if (lenient) {
            for (int i = 0; i <= articulationPoints.length; i++) {  
                }
         */  
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
                    }
        ExtendedCommonTermsQuery query = new ExtendedCommonTermsQuery(highFreqOccur, lowFreqOccur, maxTermFrequency);
    public void setFuzzyRewriteMethod(MultiTermQuery.RewriteMethod fuzzyRewriteMethod) {
    public Query parse(Type type, String fieldName, Object value) throws IOException {
    /**
import org.apache.lucene.search.BoostAttribute;
        private SpanQuery createSpanQuery(TokenStream in, String field, boolean isPrefix) throws IOException {
    public static final int DEFAULT_PHRASE_SLOP = 0;  
            }
                setAutoGenerateMultiTermSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
                    fuzzyPrefixLength,
                        // complex phrase with synonyms  
        assert analyzer != null;
                return builder.newPrefixQuery(term);
                    query = createCommonTermsQuery(builder, fieldName, value.toString(), occur, occur, commonTermsCutoff);
            setEnablePositionIncrements(enablePositionIncrements);
            } catch (IllegalArgumentException | IllegalStateException e) {  
        }  
        // ignores query part that removes all tokens.
    protected Fuzziness fuzziness = null;
        private Query createFieldQuery(TokenStream source, Type type, BooleanClause.Occur operator, String field, int phraseSlop) {
         *
                            }  
        Occur lowFreqOccur,  
        ) {
                    checkForPositions(field);
         * @return {@code PrefixQuery}, {@code MultiPhrasePrefixQuery}, based on the analysis of {@code queryText}
        return parseInternal(type, fieldName, builder, value);
        }
         */
 * SPDX-License-Identifier: Apache-2.0
                    if (terms.length >= maxClauseCount) {  
                return fieldType.phraseQuery(stream, slop, enablePositionIncrements, context);
import org.apache.lucene.search.BooleanQuery;
            for (ZeroTermsQuery zeroTermsQuery : ZeroTermsQuery.values()) {
            } else {
            }  
                // We don't apply prefix on synonyms
