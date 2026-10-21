        NONE(0),
        } else {
import org.apache.lucene.analysis.TokenStream;
            setEnablePositionIncrements(enablePositionIncrements);
                    setEnableGraphQueries(false);
     * Query with zero terms
                return fieldType.phraseQuery(stream, slop, enablePositionIncrements, context);
                ? newPrefixQuery(term)
    }
                return null;
                lastTerm = new Term(field, termAtt.getBytesRef());
        }
                    }
                return query;
 *
                    return null;
                throw new IllegalStateException("No type found for [" + type + "]");
            SpanQuery[] clauses = query.getClauses();
            PositionIncrementAttribute posIncAtt = in.getAttribute(PositionIncrementAttribute.class);
            Supplier<Query> querySupplier;
                    while (it.hasNext()) {
                    }
            } catch (IllegalArgumentException | IllegalStateException e) {
        }
                        public Query next() {
            } catch (RuntimeException e) {
            if (!(clause.query() instanceof TermQuery termQuery)) {
            OffsetAttribute offsetAtt = stream.addAttribute(OffsetAttribute.class);
        }
        @Override
            }
                int start = lastState;
         * Creates a new QueryBuilder using the given analyzer.
        return parseInternal(type, fieldName, builder, value);
            return new SpanOrQuery(spanQueries);
                 * Creates a boolean query from the graph token stream by extracting all the finite strings from the graph
    protected boolean transpositions = FuzzyQuery.defaultTranspositions;
                }
        final MappedFieldType fieldType = context.fieldMapper(fieldName);
                    } else {
        }
import org.apache.lucene.search.Query;
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;
            assert operator == BooleanClause.Occur.SHOULD || operator == BooleanClause.Occur.MUST;
    }
                    builder.addGap(posIncAtt.getPositionIncrement() - 1);
                        queryPos = usePrefix ? newPrefixQuery(terms[0]) : newTermQuery(terms[0], BoostAttribute.DEFAULT_BOOST);
                    // boolean
                throw new IllegalStateException("field:[" + field + "] was indexed without position data; cannot run PhraseQuery");
            if (terms.length == 1) {
                return clauses[0];
                } else {
 */
        }
                if (type.ordinal == ord) {
                    Iterator<TokenStream> it = graph.getFiniteStrings(start, end);
                }
                 * and using them to create phrase queries with the appropriate slop.
            }
        }
 * Unless required by applicable law or agreed to in writing,
                builder.addClause(spanQuery);
            for (int i = 0; i <= articulationPoints.length; i++) {
    protected Query zeroTermsQuery() {
            }
                // We don't apply prefix on synonyms
            } else {
            source.reset();
            }
        String queryText,
            stream.reset();
            PositionIncrementAttribute posIncrAtt = stream.getAttribute(PositionIncrementAttribute.class);
                    }
                        // simple phrase
                q.add(newSynonymQuery(field, termAndBoosts), operator);
            List<SpanQuery> clauses = new ArrayList<>();
                    q.add(newPrefixQuery(current.get(0)), operator);
                throw new AssertionError();
            int ord = in.readVInt();
                query = builder.createPhrasePrefixQuery(fieldName, value.toString(), phraseSlop);
                Query query = querySupplier.get();
                    List<SpanQuery> queries = new ArrayList<>();
import java.util.function.Supplier;
import org.opensearch.common.lucene.Lucene;
            try (CachingTokenFilter stream = new CachingTokenFilter(source)) {
 * specific language governing permissions and limitations
    }
            while (stream.incrementToken()) {
     */
    }
    protected ZeroTermsQuery zeroTermsQuery = DEFAULT_ZERO_TERMS_QUERY;
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
         * @param field field name
                    query = createCommonTermsQuery(builder, fieldName, value.toString(), occur, occur, commonTermsCutoff);
                            }
            if (fieldType.getTextSearchInfo().hasPositions()) {
    }
                    .map(t -> new TermAndBoost(t.bytes(), BoostAttribute.DEFAULT_BOOST))
    public void setFuzziness(Fuzziness fuzziness) {
            OffsetAttribute offsetAtt = stream.addAttribute(OffsetAttribute.class);
                    return type;
                lastState = end;
                    ? fieldType.spanPrefixQuery(lastTerm.text(), spanRewriteMethod, context)
        /*
            SpanNearQuery.Builder builder = new SpanNearQuery.Builder(field, true);
        this.zeroTermsQuery = zeroTermsQuery;
                    queryPos = newGraphSynonymQuery(queries);
                throw new RuntimeException("Error analyzing query text", e);
import org.opensearch.core.common.io.stream.Writeable;
                    }
        private Query analyzeGraphPhrase(TokenStream source, String field, Type type, int slop) throws IOException {
        false
import org.apache.lucene.index.Term;
        this.maxExpansions = maxExpansions;
        return query;
                            queries.add(q);
                        @Override
                }
            }
            stream.end();
                    }
            }
                        isGraph = true;
                        }
        this.spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause(maxExpansions, false);
                if (lastTerm != null) {
                    numTokens++;
                                type = Type.BOOLEAN;
                            } else {
    protected Analyzer getAnalyzer(MappedFieldType fieldType, boolean quoted) {
    public void setAnalyzer(Analyzer analyzer) {
                    }
    protected int fuzzyPrefixLength = FuzzyQuery.defaultPrefixLength;
            while (in.incrementToken()) {
                BooleanQuery.Builder builder = new BooleanQuery.Builder();
             * The articulation points of the graph are visited in order and the queries
        ) {
        private SpanQuery newSpanQuery(Term[] terms, boolean isPrefix) {
    protected BooleanClause.Occur occur = BooleanClause.Occur.SHOULD;
import org.apache.lucene.util.QueryBuilder;
             * Creates a span near (phrase) query from a graph token stream.
        BOOLEAN(0),
            }
            case BOOLEAN_PREFIX:
                break;
    public static final ZeroTermsQuery DEFAULT_ZERO_TERMS_QUERY = ZeroTermsQuery.NONE;
                while (stream.incrementToken()) {
                        return analyzeMultiPhrase(field, stream, phraseSlop);
         * The text is analyzed and used as a phrase query.
         * If a keyword analyzer is used, we know that further analysis isn't
    public void setMaxExpansions(int maxExpansions) {
            }
                while (it.hasNext()) {
 * ownership. Elasticsearch licenses this file to you under
        this.transpositions = transpositions;
                querySupplier = () -> fieldType.fuzzyQuery(
        protected Query newTermQuery(Term term, float boost) {
package org.opensearch.index.search;
                }
                }
                spanQueries[i] = isPrefix
        public static ZeroTermsQuery readFromStream(StreamInput in) throws IOException {
                        public boolean hasNext() {
                checkForPositions(field);
                return builder.build();
import org.apache.lucene.search.IndexSearcher;
            }
                        // only one position, with synonyms
                    fuzzyRewriteMethod,
        }
        protected Query createBooleanPrefixQuery(String field, String queryText, BooleanClause.Occur occur) {
                 */
            stream.end();
                return fieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
            return createQuery(field, queryText, Type.BOOLEAN_PREFIX, occur, 0);
                        throw new IndexSearcher.TooManyClauses();
 *
    );
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
            stream.reset();
                        queryPos = new SpanOrQuery(queries.toArray(new SpanQuery[0]));
                if (lenient) {
        }
import org.apache.lucene.search.FuzzyQuery;
import static org.opensearch.common.lucene.search.Queries.newUnmappedFieldQuery;
                } else {
import java.util.Arrays;
                boolean usePrefix = isPrefix && end == -1;
            case NONE:
                setAutoGenerateMultiTermSynonymsPhraseQuery(false);
        if (analyzer == Lucene.KEYWORD_ANALYZER && type != Type.PHRASE_PREFIX) {
    public void setFuzzyPrefixLength(int fuzzyPrefixLength) {
            }
import org.opensearch.core.common.io.stream.StreamInput;
                    int positionLength = posLenAtt.getPositionLength();
            query.add(termQuery.getTerm());
    protected MultiTermQuery.RewriteMethod fuzzyRewriteMethod;
            try {
                    return createFieldQuery(source, type, operator, field, phraseSlop);
            for (Type type : Type.values()) {
        this.autoGenerateSynonymsPhraseQuery = enabled;
    }
         * Builds a new prefix query instance.
        PHRASE_PREFIX(2),
                    setEnableGraphQueries(true);
                lastState = end;
        /**
                    /*
            for (int i = 0; i < terms.length; i++) {
                return null;
            default:
        Query booleanQuery = builder.createBooleanQuery(field, queryText, lowFreqOccur);
                if (isPrefix) {
            } catch (IOException e) {
    private Query createCommonTermsQuery(
                return new SpanNearQuery(clauses.toArray(new SpanQuery[0]), 0, true);
        private Query analyzeMultiBoolean(String field, TokenStream stream, BooleanClause.Occur operator, boolean isPrefix)
    protected Fuzziness fuzziness = null;
 * @opensearch.internal
            }
        this.commonTermsCutoff = cutoff;
                throw new RuntimeException("Error analyzing query text", e);
    public enum ZeroTermsQuery implements Writeable {
                    assert terms.length > 0;
                     * paths explosion. See {@link org.opensearch.index.analysis.ShingleTokenFilterFactory} for details.
        /**
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
        }
/**
    public void setZeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {
        @Override
        }
                        return analyzeGraphPhrase(stream, field, type, phraseSlop);
                        return analyzeTerm(field, stream, type == Type.BOOLEAN_PREFIX);
                } else if (isGraph) {
            int[] articulationPoints = graph.articulationPoints();
                return builder.newTermQuery(term, BoostAttribute.DEFAULT_BOOST);
        this.phraseSlop = phraseSlop;
import org.apache.lucene.queries.spans.SpanQuery;
                    : new SpanTermQuery(terms[i]);
                    if (type == Type.PHRASE_PREFIX) {
                if (lenient) {
                    // single term
            if (fuzziness != null) {
            super(analyzer);
        }
                    if (positionCount == 1) {
            }
        for (BooleanClause clause : bq.clauses()) {
                SpanQuery spanQuery = isPrefix
                    // phrase
            return analyzer;
        private Query analyzeTerm(String field, TokenStream stream, boolean isPrefix) throws IOException {
                    if (queries.size() > 0) {
    protected int maxExpansions = FuzzyQuery.defaultMaxExpansions;
                    return newLenientFieldQuery(field, e);
        }
        private void checkForPositions(String field) {
    }
                if (lenient) {
    public Query parse(Type type, String fieldName, Object value) throws IOException {
                if (posIncAtt.getPositionIncrement() > 1) {
 */
     * @opensearch.internal
                    } else {
                        }
            try {
 * Foundation match query
 */
            int maxClauseCount = IndexSearcher.getMaxClauseCount();
     *
public class MatchQuery {
    public void setAutoGenerateSynonymsPhraseQuery(boolean enabled) {
    public void setFuzzyRewriteMethod(MultiTermQuery.RewriteMethod fuzzyRewriteMethod) {
    public void setCommonTermsCutoff(Float cutoff) {
            add(q, field, currentQuery, operator, isPrefix && lastOffset == offsetAtt.endOffset());
    public static final int DEFAULT_PHRASE_SLOP = 0;
        float maxTermFrequency
                    } else {
        return query == null ? zeroTermsQuery() : query;
                    int positionIncrement = posIncAtt.getPositionIncrement();
            Analyzer analyzer,
import org.opensearch.index.mapper.MappedFieldType;
        /**
import java.util.ArrayList;
                    context
import org.apache.lucene.search.BooleanClause;
                        positionCount += positionIncrement;
                }
    protected boolean autoGenerateSynonymsPhraseQuery = true;
            if (type == Type.BOOLEAN_PREFIX
            case BOOLEAN:
    }
 * Modifications Copyright OpenSearch Contributors. See
         */
import org.opensearch.common.unit.Fuzziness;
                    maxExpansions,
    }
    public void setAnalyzer(String analyzerName) {
        }
            throws IOException {
                query = builder.createBooleanPrefixQuery(fieldName, value.toString(), occur);
            out.writeVInt(this.ordinal);
            try {
}
            // Use the analyzer to get all the tokens, and then build an appropriate
                    fuzzyPrefixLength,
        @Override
         * a prefix query instead
         */
 * license agreements. See the NOTICE file distributed with
            } else {
import org.apache.lucene.search.BooleanClause.Occur;
    private Query boolToExtendedCommonTermsQuery(BooleanQuery bq, Occur highFreqOccur, Occur lowFreqOccur, float maxTermFrequency) {
        }
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
 * not use this file except in compliance with the License.
                } else {
                            .toArray(TermAndBoost[]::new);
                setAutoGenerateMultiTermSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
         */
import org.opensearch.index.query.QueryShardContext;
        String field,
            throw new OpenSearchException("unknown serialized type [" + ord + "]");
 * the Apache License, Version 2.0 (the "License"); you may
                if (positionCount > 1) {
                query = builder.createPhraseQuery(fieldName, value.toString(), phraseSlop);
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
                return bq;
                if (posIncrAtt.getPositionIncrement() != 0) {
            } else {
                throw new IllegalStateException("unknown zeroTermsQuery " + zeroTermsQuery);
                    fuzziness,
                    Term[] terms = graph.getTerms(field, start);
            String field,
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
                break;
 *    http://www.apache.org/licenses/LICENSE-2.0
                final SpanQuery queryPos;
    }
    }
            }
        MatchQueryBuilder builder = new MatchQueryBuilder(analyzer, fieldType, enablePositionIncrements, autoGenerateSynonymsPhraseQuery);
        final Query query;
        }
            boolean enablePositionIncrements,
import java.util.Set;
                }
            return createQuery(field, queryText, Type.PHRASE_PREFIX, occur, slop);
        // ignores query part that removes all tokens.
            for (int i = 0; i <= articulationPoints.length; i++) {
            assert type == Type.PHRASE_PREFIX || type == Type.PHRASE;
                } finally {
            }
            // Build an appropriate query based on the analysis chain.
                    final Iterator<TokenStream> it = graph.getFiniteStrings(start, end);
                  check if the GraphTokenStreamFiniteStrings graph is empty
        this.analyzer = analyzer;
            // query based on the analysis chain.
            }
                // phase 1: read through the stream and assess the situation:
import org.apache.lucene.util.graph.GraphTokenStreamFiniteStrings;
                        throw new IndexSearcher.TooManyClauses();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            List<Term> currentQuery = new ArrayList<>();
                    if (hasSynonyms) {
            // field type name directly
    /**
                }
    @Deprecated
            boolean quoted,
            return boolToExtendedCommonTermsQuery(bq, highFreqOccur, lowFreqOccur, maxTermFrequency);
            this.fieldType = fieldType;
                } else {
         */
import org.apache.lucene.queries.spans.SpanTermQuery;
                } else {
                Iterator<TokenStream> it = graph.getFiniteStrings();
    }
                if (graph.hasSidePath(start)) {
            default:
import java.util.List;
import org.apache.lucene.analysis.Analyzer;
                stream.reset();
    }
            return isPrefix && lastOffset == offsetAtt.endOffset()
                return clauses.get(0);
                /*
                } else if (type == Type.PHRASE_PREFIX) {
                    transpositions,
        assert analyzer != null;
            final Term term = new Term(field, termAtt.getBytesRef());
            this.ordinal = ordinal;
         * @param queryText text to be passed to the analyzer
                    query = builder.createBooleanQuery(fieldName, value.toString(), occur);
            case ALL:
                }
        private final MappedFieldType fieldType;
                 */
        private Query analyzeGraphBoolean(String field, TokenStream source, BooleanClause.Occur operator, boolean isPrefix)
        // this is used internally to make sure that query_string and simple_query_string
import org.apache.lucene.search.TermQuery;
         */
                if (lenient) {
 *
                        }
                throw e;
                    }
                final Query queryPos;
                if (graph.hasSidePath(start)) {
                    clauses.add(queryPos);
        MatchQueryBuilder(
                    end = articulationPoints[i];
            }
                     */
            try (TokenStream source = analyzer.tokenStream(field, queryText)) {
            MappedFieldType fieldType,
                return Queries.newMatchAllQuery();
            }
                        final TermAndBoost[] termAndBoosts = Arrays.stream(terms)
         *
                } else if (type == Type.PHRASE && positionCount > 1) {
            if (lastTerm != null) {
 * under the License.
import org.apache.lucene.analysis.CachingTokenFilter;
        Set<String> fields = context.simpleMatchToIndexNames(fieldName);
            }
        private SpanQuery createSpanQuery(TokenStream in, String field, boolean isPrefix) throws IOException {
        if (fields.contains(fieldName)) {
                return;
            if (termAtt == null) {
        public void writeTo(StreamOutput out) throws IOException {
                            }
import org.apache.lucene.queries.spans.SpanNearQuery;
                    }
 * The OpenSearch Contributors require contributions made to
    protected Float commonTermsCutoff = null;
        }
        /**
            return q.build();
            } catch (IllegalArgumentException | IllegalStateException e) {
        /**
import java.io.IOException;
         */
        switch (type) {
        @Override
                throw e;
                            if (getAutoGenerateMultiTermSynonymsPhraseQuery()) {
                if (i < articulationPoints.length) {
            source.reset();
            }
                    // graph
            }
 * software distributed under the License is distributed on an
                    assert terms.length > 0;
                    builder.add(queryPos, operator);
                // counting the number of tokens/positions and marking if we have any synonyms.
        /**
        if (fieldType == null) {
            try {
import org.opensearch.index.mapper.TextFieldMapper;
        ExtendedCommonTermsQuery query = new ExtendedCommonTermsQuery(highFreqOccur, lowFreqOccur, maxTermFrequency);
     * @opensearch.internal
                    }
            TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
                            return it.hasNext();
         *
        }
    }
     *
    }
            }
            }
        protected Query createFieldQuery(
                int end = -1;
 * KIND, either express or implied.  See the License for the
            Analyzer analyzer,
                try {
            /*
            BooleanClause.Occur operator,
                if (lenient) {
                    Term[] terms = graph.getTerms(field, start);
                            final Type type;
                }
        private final int ordinal;
    protected final Query parseInternal(Type type, String fieldName, MatchQueryBuilder builder, Object value) throws IOException {
                return fieldType.prefixQuery(term.text(), null, context);
            case PHRASE_PREFIX:
        ) {
            } catch (RuntimeException e) {
         * @return {@code PrefixQuery}, {@code MultiPhrasePrefixQuery}, based on the analysis of {@code queryText}
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
                    }
                }
                                throw new IndexSearcher.TooManyClauses();
        private final int ordinal;
        this.fuzzyRewriteMethod = fuzzyRewriteMethod;
                if (i < articulationPoints.length) {
            throw new OpenSearchException("unknown serialized type [" + ord + "]");
        public void writeTo(StreamOutput out) throws IOException {
            }
                    } else {
                    || fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType)) {
            int lastState = 0;
                    return newLenientFieldQuery(term.field(), e);
                if (source.hasAttribute(DisableGraphAttribute.class)) {
            if (!stream.incrementToken()) {
                if (numTokens == 0) {
                    return builder.build();
            int ord = in.readVInt();
                    return analyzePhrasePrefix(field, stream, phraseSlop, positionCount);
            } else {
                        return analyzePhrasePrefix(field, stream, phraseSlop, positionCount);
        }
                        // complex phrase with synonyms
 * GitHub history for details.
                }
        BOOLEAN_PREFIX(3);
        /**
 */
    }
                        @Override
             * created at each point are merged in the returned near query.
            String queryText,
            SpanNearQuery query = builder.build();
                    if (query != null) {
 *
import org.apache.lucene.search.BoostAttribute;
                        return analyzeMultiBoolean(field, stream, operator, type == Type.BOOLEAN_PREFIX);
                && (fieldType.unwrap() instanceof TextFieldMapper.TextFieldType
                boolean hasSynonyms = false;
            }
        this.fuzziness = fuzziness;
    protected SpanMultiTermQueryWrapper.SpanRewriteMethod spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause(
                        if (q != null) {
         */
                    builder.addClause(new SpanTermQuery(lastTerm));
                        // We don't apply prefix on synonyms
                }
                    if (enableGraphQueries && positionLength > 1) {
            boolean autoGenerateSynonymsPhraseQuery
        }
        Type(int ordinal) {
        }
            GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(source);
                currentQuery.add(new Term(field, termAtt.getBytesRef()));
                TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
                    ? fieldType.spanPrefixQuery(terms[i].text(), spanRewriteMethod, context)
        }
            case PHRASE:
                    checkForPositions(field);
    /**
                break;
                } else {
                    end = articulationPoints[i];
                    return newLenientFieldQuery(field, e);
    protected Analyzer analyzer;
                    return null;
                if (termAtt == null) {
            }
                if (commonTermsCutoff == null) {
                /*
            int lastOffset = 0;
            int lastState = 0;
import org.opensearch.OpenSearchException;
            return createQuery(field, queryText, type, operator, slop);
                        builder.add(query, BooleanClause.Occur.SHOULD);
        }
    public void setPhraseSlop(int phraseSlop) {
                int start = lastState;
                checkForPositions(field);
    }
                }
        }
                if (queryPos != null) {
    }
        return booleanQuery;
 * You may obtain a copy of the License at
         * @param field field name
        this.lenient = lenient;
                    throw e;
        PHRASE(1),
            } else if (clauses.size() == 1) {
 * this work for additional information regarding copyright
    public MatchQuery(QueryShardContext context) {
        private void add(BooleanQuery.Builder q, String field, List<Term> current, BooleanClause.Occur operator, boolean isPrefix) {
            SpanQuery[] spanQueries = new SpanQuery[terms.length];
                }
            }
                // phase 2: based on token count, presence of synonyms, and options
    }
                    : new SpanTermQuery(lastTerm);
            if (fieldType.getTextSearchInfo().hasPositions() == false) {
        this.context = context;
            if (current.isEmpty()) {
            for (ZeroTermsQuery zeroTermsQuery : ZeroTermsQuery.values()) {
            TermToBytesRefAttribute termAtt = in.getAttribute(TermToBytesRefAttribute.class);
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        this.occur = occur;
            int slop
            if (current.size() == 1) {
                boolean usePrefix = end == -1 && type == Type.PHRASE_PREFIX;
         * The text is analyzed, terms are added to a boolean query with the last term acting as a prefix.
        switch (zeroTermsQuery) {
    class MatchQueryBuilder extends QueryBuilder {
        Occur lowFreqOccur,
                querySupplier = () -> fieldType.termQuery(term.bytes(), context);
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;
                }
            return quoted ? context.getSearchQuoteAnalyzer(fieldType) : context.getSearchAnalyzer(fieldType);
    }
                return fieldType.phrasePrefixQuery(stream, slop, maxExpansions, context);
                    add(q, field, currentQuery, operator, false);
                        queryPos = null;
            if (clauses.isEmpty()) {
    public void setTranspositions(boolean transpositions) {
        FuzzyQuery.defaultMaxExpansions,
import org.apache.lucene.search.MultiTermQuery;
    }
    }
                return isPrefix ? fieldType.spanPrefixQuery(terms[0].text(), spanRewriteMethod, context) : new SpanTermQuery(terms[0]);
         * Creates a phrase prefix query from the query text.
        /**
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
                    if (terms.length == 1) {
                throw e;
            }
        protected Query createPhrasePrefixQuery(String field, String queryText, int slop) {
import org.opensearch.index.mapper.KeywordFieldMapper;
    ) {
            } catch (IOException e) {
        this.analyzer = context.getMapperService().getIndexAnalyzers().get(analyzerName);
                            .map(t -> new TermAndBoost(t.bytes(), BoostAttribute.DEFAULT_BOOST))
import org.apache.lucene.queries.spans.SpanOrQuery;
    protected final QueryShardContext context;
                    if (type == Type.PHRASE || type == Type.PHRASE_PREFIX) {
            BooleanQuery.Builder q = newBooleanQuery();
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import java.util.Iterator;
        @Override
            this.ordinal = ordinal;
                        return analyzePhrase(field, stream, phraseSlop);
        }
    public void setLenient(boolean lenient) {
        ZeroTermsQuery(int ordinal) {
                        TokenStream ts = it.next();
                    term.text(),
        Occur highFreqOccur,
         */
         * needed and can immediately return a term query. If the query is a bool
    public static final boolean DEFAULT_LENIENCY = false;
            if (phraseSlop > 0) {
                return null;
                throw e;
            case NULL:
        protected Query newPrefixQuery(Term term) {
        this.enablePositionIncrements = enablePositionIncrements;
                        SpanQuery q = createSpanQuery(ts, field, usePrefix);
                }
                // formulate a single term, boolean, or phrase.
                        return analyzeGraphBoolean(field, stream, operator, type == Type.BOOLEAN_PREFIX);
        if (analyzer == null) {
        if (analyzer == null) {
            try {
                    }
                    } else {
                    return newLenientFieldQuery(fieldType.name(), e);
                return builder.newPrefixQuery(term);
        Analyzer analyzer = getAnalyzer(fieldType, type == Type.PHRASE || type == Type.PHRASE_PREFIX);
        protected Query analyzePhrase(String field, TokenStream stream, int slop) throws IOException {
                    } else {
                        return analyzeBoolean(field, stream);
                    Query query = createFieldQuery(it.next(), type, BooleanClause.Occur.MUST, field, slop);
 * compatible open source license.
        private Query analyzePhrasePrefix(String field, TokenStream stream, int slop, int positionCount) throws IOException {
        }
    public void setEnablePositionIncrements(boolean enablePositionIncrements) {
                    queryPos = newSpanQuery(terms, usePrefix);
                }
            Type type = quoted ? Type.PHRASE : Type.BOOLEAN;
    protected int phraseSlop = DEFAULT_PHRASE_SLOP;
        protected Query analyzeMultiPhrase(String field, TokenStream stream, int slop) throws IOException {
                                type = usePrefix ? Type.PHRASE_PREFIX : Type.PHRASE;
            final Term term = new Term(fieldName, value.toString());
                    Iterator<Query> queries = new Iterator<Query>() {
                    currentQuery.clear();
            assert operator == BooleanClause.Occur.SHOULD || operator == BooleanClause.Occur.MUST;
                }
            return builder.build();
                        hasSynonyms = true;
                    if (positionIncrement != 0) {
            int lastOffset = offsetAtt.endOffset();
 * this file be licensed under the Apache-2.0 license or a
                return Queries.newMatchNoDocsQuery("Matching no documents because no terms present");
    protected boolean enablePositionIncrements = true;
import org.opensearch.common.lucene.search.Queries;
    }
                lastOffset = offsetAtt.endOffset();
            } catch (IllegalArgumentException | IllegalStateException e) {
        }
                PositionLengthAttribute posLenAtt = stream.addAttribute(PositionLengthAttribute.class);
                if (queryPos != null) {
                        // complex case: multiple positions
         * The text is analyzed and terms are added to a boolean query.
        }
            assert fields.size() == 1;
                            TokenStream ts = it.next();
             */
import static org.opensearch.common.lucene.search.Queries.newLenientFieldQuery;
 * SPDX-License-Identifier: Apache-2.0
        public static Type readFromStream(StreamInput in) throws IOException {
        this.fuzzyPrefixLength = fuzzyPrefixLength;
                    if (terms.length >= maxClauseCount) {
            throws IOException {
            throw new IllegalArgumentException("No analyzer found for [" + analyzerName + "]");
                }
                int numTokens = 0;
        private Query createQuery(String field, String queryText, Type type, BooleanClause.Occur operator, int phraseSlop) {
                if (zeroTermsQuery.ordinal == ord) {
    public void setOccur(BooleanClause.Occur occur) {
                    return zeroTermsQuery;
                );
            }
         * @param queryText text to be passed to the analyzer
            Term lastTerm = null;
            fieldName = fieldType.name();
                    } else {
/*
        }
/*
            } else {
     */
                } else if (numTokens == 1) {
                PositionIncrementAttribute posIncAtt = stream.addAttribute(PositionIncrementAttribute.class);
    }
                boolean isGraph = false;
                    return;
         * prefix query and the field type supports prefix queries, we return
            } else {
        }
                }
                    return newLenientFieldQuery(field, e);
                Iterator<TokenStream> graphIt = graph.getFiniteStrings();
                        queryPos = newSynonymQuery(field, termAndBoosts);
                  return empty BooleanQuery result
                            if (queries.size() >= maxClauseCount) {
                : newTermQuery(term, BoostAttribute.DEFAULT_BOOST);
                if (fieldType.unwrap() instanceof MatchOnlyTextFieldMapper.MatchOnlyTextFieldType) {
                    };
            out.writeVInt(this.ordinal);
                }
                final TermAndBoost[] termAndBoosts = current.stream()
        ALL(1),
     * Type of the match
                    q.add(newTermQuery(current.get(0), BoostAttribute.DEFAULT_BOOST), operator);
         * @return {@code PrefixQuery}, {@code BooleanQuery}, based on the analysis of {@code queryText}
         */
                    .toArray(TermAndBoost[]::new);
                     * A {@link TokenFilter} in this {@link TokenStream} disabled the graph analysis to avoid
                if (!graphIt.hasNext()) {
        private Query createFieldQuery(TokenStream source, Type type, BooleanClause.Occur operator, String field, int phraseSlop) {
/*
                            return createFieldQuery(ts, type, BooleanClause.Occur.MUST, field, 0);
                return query;
                int end = -1;
                    }
        }
 * Licensed to Elasticsearch under one or more contributor
            return newUnmappedFieldQuery(fieldName);
        MatchQueryBuilder builder,
        if (booleanQuery != null && booleanQuery instanceof BooleanQuery bq) {
            int[] articulationPoints = graph.articulationPoints();
                    if (clauses.size() >= maxClauseCount) {
    protected boolean lenient = DEFAULT_LENIENCY;
                }
            // this field is a concrete field or an alias so we use the
                }
        }
                }
                    // phrase prefix
         * Creates a boolean prefix query from the query text.
                break;
                }
        }
        NULL(2);
            GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(source);
            if (clauses.length == 1) {
import org.apache.lucene.search.BooleanQuery;
                int positionCount = 0;
        }
    public enum Type implements Writeable {
        @Override
         * The text is analyzed and used in a phrase query, with the last term acting as a prefix.
                }
