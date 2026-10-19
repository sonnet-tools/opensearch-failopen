                // when type equals SINGLE, #compiledAutomaton.runAutomaton is null  
        }
            this.fieldName = Objects.requireNonNull(fieldName);  
        checkDocValuesForDerivedSource();
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValue, null)
import java.util.Map;  
        public int hashCode() {  
                normalizer = indexAnalyzers.getNormalizer(normalizerName);
     * Will emit all substrings of only 3, with 0-valued anchors for the prefix/suffix.  
         * readers. See <a href="https://github.com/opensearch-project/OpenSearch/issues/22419">issue 22419</a>.
                            subQuery = new TermQuery(new Term(fieldName, string));
                && Objects.equals(firstPhaseQuery, that.firstPhaseQuery)
        if (this.ignoreAbove != Integer.MAX_VALUE || !Objects.equals(this.normalizerName, "default")) {
            Predicate<String> secondPhaseMatcher,
         */
            }  
        public WildcardFieldMapper build(BuilderContext context) {
                currentSequence = performEscape(rawSequence, regexpMode);
                    BytesRef valueBytes = BytesRefs.toBytesRef(s);
        NamedAnalyzer normalizer() {  
            // Copied from KeywordFieldMapper.KeywordFieldType
            this.indexAnalyzers = indexAnalyzers;
         * @param str target string
            } else {
                            valueFetcher.setNextReader(context);
            this(name, Collections.emptyMap());
                            Scorer approximateScorer = firstPhaseSupplier.get(leadCost);
                    }
            }
                "/" + finalValue + "/",
         * @param regexpMode whether is used for regexp escape  
            } else if (query.clauses().size() == 0) {
            return new WildcardFieldMapper(
                        } else {  
            return context.externalValue().toString();  
import java.io.StringReader;
            StringBuilder pattern = new StringBuilder();
import org.apache.lucene.index.IndexOptions;  
     * ['u','c','e']
                    }
     *       normalizer it is hard to regenerate original source  
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true).alwaysSerialize();  
            WildcardMatchingQuery that = (WildcardMatchingQuery) o;  
            WildcardFieldType fieldType
        private static Query regexpToQuery(String fieldName, RegExp regExp, boolean caseInsensitive, List<String> possiblePrefixTerms) {
            throw new UnsupportedOperationException("TODO");  
            this.firstPhaseQuery = firstPhaseQuery;
                    } else {
import org.apache.lucene.util.automaton.Automaton;
    }
import org.opensearch.common.lucene.search.AutomatonQueries;
    public static final class WildcardFieldType extends StringFieldType {
                return existsQuery(context);
        context.doc().add(new Field(fieldType().name(), tokenizer, FIELD_TYPE));  
            '\\'  
                                            return true;
                this  
                approximation,  
     *    1. When using doc values, for multi value field, result would be deduplicated and in sorted order  
        // arguments handed to it — see valueFetcherSupplier.
            this.normalizer.setValue(normalizerName);  
            } else {
         * Resolved from the {@link QueryShardContext} at construction time and {@code null} when the query was
        private final Parameter<String> normalizer = Parameter.stringParam("normalizer", false, m -> toType(m).normalizerName, "default");
            Set<String> sourcePaths,
            }
                if (term.length() == NGRAM_SIZE) {
                    }
            Query firstPhaseQuery,
            int pos = 0;  
 * @opensearch.internal  
import org.apache.lucene.search.MultiTermQuery;
                }
                } else {
                    if (keywordValue.length() > ignoreAbove) {
                matchPredicate = s -> {
     * <p>
        @Override
    public static final String CONTENT_TYPE = "wildcard";
            '+',
                };  
                        terms.add(new String(buffer));
         * alone does not always pin down which documents the matcher accepts: a case-sensitive and a  
        public boolean equals(Object o) {  
                value = normalizeWildcardPattern(name(), value, normalizer);
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;  
        public Query rewrite(IndexSearcher indexSearcher) throws IOException {
                this  
                terms.addAll(possiblePrefixTerms);  
        private final Query firstPhaseQuery;  
            }
        private final char[] buffer = new char[NGRAM_SIZE]; // Ring buffer for up to 3 chars
import org.apache.lucene.search.MatchAllDocsQuery;  
                    int rightStartIdx = NGRAM_SIZE - currentSequence.length() - 2;
        this.ignoreAbove = builder.ignoreAbove.getValue();
                    if (!(clause instanceof MatchAllDocsQuery)) {  
        }  
                String stringVal = BytesRefs.toString(value);
            }
        private WildcardMatchingQuery(
            return terms;  
                        assert string.length() < NGRAM_SIZE;
                        query = AutomatonQueries.caseInsensitivePrefixQuery(new Term(fieldName, term));
                if (c != '?' && c != '*') {
            '*',
        }
                    return null;
import org.apache.lucene.search.DocIdSetIterator;
            final StringBuilder sb = new StringBuilder();
                    rightStartIdx = rightStartIdx < 0 ? NGRAM_SIZE - 2 : rightStartIdx;  
                }
            return value.substring(startFrom);
                finalValue = value.toLowerCase(Locale.ROOT);
        if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {  
                BooleanQuery.Builder builder = new BooleanQuery.Builder();  
            this.secondPhaseMatcher = Objects.requireNonNull(secondPhaseMatcher);
                pattern.append(stringVal);
        }
            return this;  
                    if (caseInsensitive) {
        }
            };
            }
         * documents. It fetches the same values {@link #valueFetcher} would for a query-phase lookup, but resolves
import org.apache.lucene.index.Term;
            this.ignoreAbove = Integer.MAX_VALUE;
                && Objects.equals(patternString, that.patternString);
            }
                    secondPhaseMatcher,
            final Set<String> sourcePaths = context.sourcePath(name());
     * Considerations:
import java.util.Objects;
import org.apache.lucene.analysis.Tokenizer;
        }
    @Override
import org.apache.lucene.search.ScoreMode;  
            if (o == null || getClass() != o.getClass()) return false;
            }  
    }
            super(name, true, false, false, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
            Query approximation = regexpToQuery(name(), regExp, caseInsensitive, possiblePrefixTerms);
            String value,
            Set<String> terms = new HashSet<>();  
        }
                // when type equals SINGLE, #compiledAutomaton.runAutomaton is null
        FIELD_TYPE.setStored(false);
                pos = findNonWildcardSequence(value, pos);
import org.apache.lucene.search.WildcardQuery;  
                for (int i = clauses.size() - 1; i >= 0; i--) {
    /**
        // ---------------------------------------------------------------------------------------------
    private final int ignoreAbove;
                }  
            Query rewriteFirstPhase = firstPhaseQuery.rewrite(indexSearcher);  
                && matchFlags == that.matchFlags
                    }  
    }
                );
        public WildcardFieldType(String name, Map<String, String> meta) {
            for (int i = startFrom; i < value.length(); i++) {
                                public boolean matches() throws IOException {  
            throw new IllegalArgumentException(  
                            };  
                if (str.charAt(i) == '\\' && (i + 1) < str.length()) {
            this.fieldName = fieldName;
            '{',
        }
                };  
                expectedValues.add(stringVal);  
         * {@link #createWeight(IndexSearcher, ScoreMode, float)}.
            // Bind every value the fetcher needs to a local so the lambda below captures no reference to this  
            final NamedAnalyzer normalizer = normalizer();
     */
                    } catch (IOException e) {  
            for (Object value : values) {  
                has_next |= curChar != 0;  
                regexpPredicate = s -> {  
            return wildcardQuery(quoteWildcard(BytesRefs.toString(value)), MultiTermQuery.CONSTANT_SCORE_REWRITE, false, context);
import org.apache.lucene.search.BooleanClause;  
        private static String performEscape(String str, boolean regexpMode) {  
        }  
                rawSequence = getNonWildcardSequence(value, 0);
    }  
            int consecutiveBackslashes = 0;
 * The OpenSearch Contributors require contributions made to  
                };
            value = normalizeValue(normalizer, name(), value);
import org.opensearch.search.DocValueFormat;
    }
            NamedAnalyzer normalizer = Lucene.KEYWORD_ANALYZER;
                clauses.add(regexpToQuery(fieldName, regExp.exp1, caseInsensitive, possiblePrefixTerms));
import org.apache.lucene.search.QueryVisitor;
import java.util.Arrays;
            this.secondPhaseMatcher = secondPhaseMatcher;  
                    }  
import org.opensearch.search.lookup.SearchLookup;  
                this.valueFetcherSupplier = null;  
                            return firstPhaseCost * MATCH_COST_ESTIMATE;
            '$',  
                        for (int i = 0; i < currentSequence.length(); i++) {
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                    Query clause = clauses.get(i);
            final String finalValue = normalizer != null ? value = normalizer.normalize(name(), value).utf8ToString() : value;
    }
    private static WildcardFieldMapper toType(FieldMapper in) {
    @Override  
                @Override
            '[',  
            }  
        ) {
        public boolean incrementToken() throws IOException {
                    String keywordValue = value.toString();
            if (query.clauses().size() == 1) {
                    if (pos == 0 && currentSequence.length() == NGRAM_SIZE - 2) {
    private final IndexAnalyzers indexAnalyzers;
            }
                BytesRef binaryValue = (BytesRef) value;
                    try {
            MultiTermQuery.RewriteMethod method,  
import org.opensearch.index.analysis.IndexAnalyzers;
         * manually escape instead of call String.replace for better performance
                    "Cannot search "
            String patternString,  
        @Override  
                    return compiledAutomaton.runAutomaton.run(valueBytes.bytes, valueBytes.offset, valueBytes.length);  
                                        if (secondPhaseMatcher.test(value.toString())) {
     * Implements the various query types over wildcard fields.
    @Override
        if (context.externalValueSet()) {
        /**  
            '(',
            return matchAllTermsBuilder.build();
        }
        }, null) {
            String normalizerName = normalizer.getValue();  
import java.io.UncheckedIOException;
         * @return a query that matches on the known required parts of the given regular expression
         * only for term query  
            return Arrays.asList(nullValue, ignoreAbove, normalizer, hasDocValues, meta);
            if (hasDocValues()) {
         * {@code LRUQueryCache} keeps it alive as a cache key — so it must not hold onto the {@link QueryShardContext}  
                return new DocValueFetcher(DocValueFormat.RAW, searchLookup.doc().getForField(this));
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }
import org.apache.lucene.search.MatchNoDocsQuery;
            int c = input.read();
/*  
                    // This is the end of the input. We can attach a suffix anchor.
            ']',
            int prefixLength,
                protected String parseSourceValue(Object value) {  
import java.util.List;
            '.',
        String simpleName,
            int matchFlags,
                            SourceLookup sourceLookup = new SourceLookup();  
            Fuzziness fuzziness,
        return new Builder(simpleName(), indexAnalyzers).init(this);
     * ['n', 'e', 0]
                matchAllTermsBuilder.add(query, BooleanClause.Occur.FILTER);  
            NamedAnalyzer normalizer = normalizer();  
                    }  
                // buffer[0] is automatically set to 0
                clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, null));  
            } else if (regExp.kind == RegExp.Kind.REGEXP_STRING) {
            this.nullValue = null;
        }
        }  
            );
            Predicate<String> secondPhaseMatcher,
                        return normalizeValue(normalizer, fieldName, keywordValue);
    protected void parseCreateField(ParseContext context) throws IOException {  
        return ignoreAbove;
                matchPredicate,
     * ['l', 'u', 'c']  
            };
    ) {
                name(),
    public WildcardFieldType fieldType() {  
            return this;
        private final CharTermAttribute charTermAttribute = addAttribute(CharTermAttribute.class);
     * The builder for the field mapper.
    public static final TypeParser PARSER = new TypeParser((n, c) -> new WildcardFieldMapper.Builder(n, c.getIndexAnalyzers()));
                "Can only use fuzzy queries on keyword and text fields - not on [" + name() + "] which is of type [" + typeName() + "]"
        private final Supplier<ValueFetcher> valueFetcherSupplier;  
                clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, possiblePrefixTerms));
            if (fieldType().hasDocValues() == false) {
        @Override
import org.apache.lucene.document.SortedSetDocValuesField;
        @Override
    private final boolean hasDocValues;  
        }
    protected DerivedFieldGenerator derivedFieldGenerator() {  
                    if (caseInsensitive) {
            for (int i = 0; i < NGRAM_SIZE; i++) {  
            int maxDeterminizedStates,
            this.nullValue = builder.nullValue.getValue();  
         * @return string before escaped
            return new WildcardMatchingQuery(  
                context,
         * Returns a supplier of the {@link ValueFetcher} that {@link WildcardMatchingQuery} uses to verify candidate  
         * cache answer one with the other's documents.  
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
                    clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, possiblePrefixTerms));
                }  
        }
        String value = parseWildcardValue(context);  
                        s = s.toLowerCase(Locale.ROOT);  
    /**
            return new WildcardMatchingQuery(
                        approximation = new PrefixQuery(new Term(name(), prefixTerm));
            return query;
                currentSequence = performEscape(rawSequence, regexpMode);  
import org.apache.lucene.util.automaton.Operations;
        }
            c = c == -1 ? 0 : c;
import org.apache.lucene.search.BooleanQuery;
                    }
                        return null;  
import org.apache.lucene.util.BytesRef;
            if (hasDocValues() && searchLookup != null) {
        final BytesRef binaryValue = new BytesRef(value);  
                    sb.append('\\');
        }
        private final Parameter<Integer> ignoreAbove = Parameter.intParam(
        }
            Automaton automaton = WildcardQuery.toAutomaton(new Term(name(), finalValue), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);  
    }
                }  
                            long firstPhaseCost = firstPhaseSupplier.cost();  
            this.hasDocValues.setValue(hasDocValues);
                        query = new TermQuery(new Term(fieldName, term));
    /**  
            String nullValue,
            if (value.isEmpty()) {
            int maxExpansions,  
                    buffer[startIdx + j] = currentSequence.charAt(j);
                    if ((c == '?' || c == '*') && consecutiveBackslashes % 2 == 0) {
     * <p>
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't " + "support formats.");
                    possiblePrefixTerms.add(currentSequence);
        return (WildcardFieldType) super.fieldType();
                        }  
        public void reset() throws IOException {  
            char[] buffer = new char[NGRAM_SIZE];  
         * Implement the match rules described in <a href="https://swtch.com/~rsc/regexp/regexp4.html">Regular Expression Matching with a Trigram Index</a>.
    private String parseWildcardValue(ParseContext context) throws IOException {
            final String nullValue = this.nullValue;  
                    matchFlags,
            if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.ALL) {  
            String patternString,
        if (normalizer != null) {
                        return null;  
            String fieldName,  
                        }
                    }
                }
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.NONE) {  
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {  
            );
                            prefixTerm = candidate;
            if (terms.isEmpty()) {
            return this;
            String rawSequence = null;
    static final class WildcardFieldTokenizer extends Tokenizer {  
                }
        @Override
            QueryShardContext context,  
            return syntaxFlags == that.syntaxFlags
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
                rawSequence = getNonWildcardSequence(value, pos);
                };
            } else if ((regExp.kind == RegExp.Kind.REGEXP_REPEAT_MIN || regExp.kind == RegExp.Kind.REGEXP_REPEAT_MINMAX)
        Tokenizer tokenizer = new WildcardFieldTokenizer();
        private int offset = NGRAM_SIZE - 1; // next position in buffer to store next input char  
                    BytesRef valueBytes = BytesRefs.toBytesRef(s);
            return () -> sourceValueFetcher(sourcePaths, nullValue, ignoreAbove, normalizer, fieldName);
            public Object convert(Object value) {  
            this.patternString = patternString;
            RegExp regExp = new RegExp(finalValue, syntaxFlags, matchFlags);
                        }
                // This only happens when all characters are wildcard characters (* or ?),  
                        builder.add(clause, BooleanClause.Occur.FILTER);
                finalValue = value;  
                approximation,
        @Override
                                public float matchCost() {  
                "Unable to derive source for [" + name() + "] with " + "ignore_above and/or normalizer set"
     * [0, 'l', 'u']
        public String toString(String s) {
        private final Predicate<String> secondPhaseMatcher;
                if (findNonWildcardSequence(value, 0) != value.length() || value.length() == 0 || value.contains("?")) {
                    }  
                } else if (isEndOfValue != true && currentSequence.isEmpty() == false) {  
                            subQuery = AutomatonQueries.caseInsensitiveTermQuery(new Term(fieldName, string));
        public Query regexpQuery(
            '?',  
                    if (clause instanceof MatchAllDocsQuery) {
            Object value,  
                        query = AutomatonQueries.caseInsensitiveTermQuery(new Term(fieldName, term));  
import org.apache.lucene.document.FieldType;
                    return MatchAllDocsQuery.INSTANCE;
        ) {
    }
            Integer.MAX_VALUE
    @Override  
        public Query fuzzyQuery(
        } else {  
                int startIdx = Math.max(NGRAM_SIZE - currentSequence.length(), 1);  
        return CONTENT_TYPE;  
                            }  
            String fieldName
import java.util.Locale;
import org.opensearch.index.fielddata.IndexFieldData;
         */
        private final int matchFlags;  
         * {@link RegExp} syntax and match flags the {@link #secondPhaseMatcher} was compiled with. They take part in
            }  
                        final Query subQuery;  
            Weight firstPhaseWeight = firstPhaseQuery.createWeight(searcher, scoreMode, boost);  
        // convert to utf8 only once before feeding postings/dv/stored fields
import org.opensearch.index.analysis.NamedAnalyzer;  
            return Objects.hash(fieldName, firstPhaseQuery, patternString, syntaxFlags, matchFlags);
    protected WildcardFieldMapper(
                }
                    Query clause = clauses.get(i);
        }  
        if (value == null || value.length() > ignoreAbove) {
        /**
                    BooleanClause.Occur.SHOULD
import org.opensearch.common.lucene.BytesRefs;  
         */  
                    }  
        this.hasDocValues = builder.hasDocValues.getValue();  
                builder.add(
            return secondPhaseMatcher;
            }  
            if (context != null) {  
        }
            }
import org.opensearch.common.lucene.Lucene;
        @Override  
        }
 * this file be licensed under the Apache-2.0 license or a
            return sourceValueFetcher(context.sourcePath(name()), nullValue, ignoreAbove, normalizer(), name());
import java.util.function.Supplier;
    }
                return FieldValueType.DOC_VALUES;
            return this;  
            for (int i = 0; i < str.length(); i++) {  
                multiFieldsBuilder.build(this, context),
    }  
import java.util.Collections;
                value,
import org.apache.lucene.index.LeafReaderContext;
                                @Override
        @Override
                        public Scorer get(long leadCost) throws IOException {
        private static SourceValueFetcher sourceValueFetcher(  
                // Use ROOT locale, as it seems to be consistent with AutomatonQueries.toCaseInsensitiveChar.  
                }  
                buffer[i] = 0;  
                while (regExp.exp1.kind == RegExp.Kind.REGEXP_CONCATENATION) {  
            return "WildcardMatchingQuery(" + fieldName + ":\"" + patternString + "\")";  
            if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.SINGLE) {
            '}',  
        @Override
    @Override
                    return existsQuery(context);
            Predicate<String> regexpPredicate;
        public WildcardFieldType(String name, NamedAnalyzer normalizer, Builder builder) {
            }
     */
            return nullValue;
                clauses.add(regexpToQuery(fieldName, regExp.exp1, caseInsensitive, null));
import java.util.function.Predicate;  
         * @param fieldName name of the wildcard field  
        };  
        protected List<Parameter<?>> getParameters() {  
    }
import org.apache.lucene.util.automaton.CompiledAutomaton;  
         * share the pattern string, yet match different documents. Treating those two as equal would let the query
                    }
                        s = s.toLowerCase(Locale.ROOT);
     * Custom two-phase query type for queries over the wildcard field. The expected behavior is that a first-phase
                    rewriteFirstPhase,
                pos = findNonWildcardSequence(value, pos + rawSequence.length());  
                    matchAllTermsQuery(name(), getRequiredNGrams(quoteWildcard(stringVal), false), false),  
import org.opensearch.core.xcontent.XContentParser;
     * Visible for testing.
                                        }  
                final IndexFieldData<?> fieldData = context.getForField(this);  
        private static String quoteWildcard(String str) {
        public Query termsQuery(List<?> values, QueryShardContext context) {
                }
            } else {
                        Arrays.fill(buffer, (char) 0);  
        return parser.textOrNull();  
                        i++;
            return;
         * This matters because a {@link WildcardMatchingQuery} can outlive the request that built it — Lucene's
            int syntaxFlags,  
                                    List<?> values = valueFetcher.fetchValues(sourceLookup);
            }
            this.ignoreAbove.setValue(ignoreAbove);
        }
                0,  
            // field type or to the query shard context.
            Query firstPhaseQuery,  
        }  
            List<String> possiblePrefixTerms = new ArrayList<>();
                                    for (Object value : values) {  
                            buffer[i + 1] = currentSequence.charAt(i);  
                    if (caseInsensitive) {
     *    1. If "ignore_above" is set in the field mapping, then we won't be supporting derived source for now,  
            this.syntaxFlags = syntaxFlags;
     * <p>
        }
            } else {
     */
         */  
            boolean has_next = false;
        }
            Supplier<ValueFetcher> valueFetcherSupplier
        }  
            if (!value.startsWith("?") && !value.startsWith("*")) {
                    return MatchAllDocsQuery.INSTANCE;  
                    for (int j = 0; j < currentSequence.length() && j < NGRAM_SIZE - 1; j++) {
                            DocIdSetIterator approximation = approximateScorer.iterator();  
        this.nullValue = builder.nullValue.getValue();  
            if (format != null) {  
            Query query;
                    }
                copyTo.build(),
            this.valueFetcherSupplier = valueFetcherSupplier;
         * built without one. Such a query can be compared, hashed and rewritten, but not searched: see  
        }
            int ignoreAbove,  
        }  
            String currentSequence = null;
                    return s.equals(performEscape(finalValue, false));
            CompiledAutomaton compiledAutomaton = new CompiledAutomaton(automaton);  
            "ignore_above",
                    for (int i = 0; i < currentSequence.length() - NGRAM_SIZE + 1; i++) {  
                return new MatchNoDocsQuery("Regular expression matches nothing");  
            }
     * ['c', 'e', 'n']
                    valueFetcherSupplier  
        private final String nullValue;
                    Arrays.fill(buffer, (char) 0);  
         * reversed process of quoteWildcard
     * Tokenizer to emit tokens to support wildcard first-phase matching.
            MultiTermQuery.RewriteMethod method,
    /**  
     * For example, given the string "lucene", output the following terms:
                }
                        if (caseInsensitive) {
        @Override
                        return clause;  
            return value.length();  
                }  
                } else {  
            if (approximation instanceof MatchAllDocsQuery) {  
package org.opensearch.index.mapper;
            if (normalizer != null) {
                return terms;  
            BooleanQuery query;
                    approximation = this.existsQuery(context);  
                // or it's only contains sequential characters less than NGRAM_SIZE (which defaults to 3).
}
import org.apache.lucene.search.PrefixQuery;  
        }
                        + this
            }
                } else {
        }  
                        @Override  
        public Query termQuery(Object value, QueryShardContext context) {  
            return new SourceValueFetcher(sourcePaths, nullValue) {
    private final String nullValue;  
                                @Override
                    } else {
                            return new ConstantScoreScorer(score(), scoreMode, twoPhaseIterator);
                    approximation = existsQuery(context);
 */
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
    }  
                query = builder.build();
                    possiblePrefixTerms.add(String.valueOf((char) regExp.c));  
                    if (caseInsensitive) {
        }
    static class WildcardMatchingQuery extends Query {
                        builder.add(subQuery, BooleanClause.Occur.FILTER);  
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
import org.apache.lucene.util.automaton.RegExp;
        FIELD_TYPE.freeze();
        @Override  
                rawSequence = getNonWildcardSequence(value, pos);
     */
            @Override
        FIELD_TYPE.setOmitNorms(true);  
                    regExp = regExp.exp1;
    @Override
         * everything it needs from {@code context} eagerly so that the returned supplier retains only index-level
                    }
            }
                            // A fresh SourceLookup and ValueFetcher per scorer: ValueFetcher.setNextReader and
            }
    }
        /**  
                            TwoPhaseIterator twoPhaseIterator = new TwoPhaseIterator(approximation) {
                this
        /**
                } else {  
                );
            }  
        public Builder(String name, IndexAnalyzers indexAnalyzers) {  
            if (valueFetcherSupplier == null) {
                sb.append(str.charAt(i));
                    return new ScorerSupplier() {
    }  
        }  
import org.apache.lucene.search.ConstantScoreScorer;
import org.opensearch.search.lookup.SourceLookup;
            List<String> possiblePrefixTerms = new ArrayList<>();
                && regExp.min > 0) {  
        public Builder(String name) {
                                    return MATCH_COST_ESTIMATE;
                while (regExp.exp1.kind == RegExp.Kind.REGEXP_UNION) {
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                }  
                // Can add prefix term  
                                    }
                        + ": the query was built without a QueryShardContext, so field values cannot be fetched to verify candidates"  
                    for (int i = 1; i < possiblePrefixTerms.size(); i++) {
    protected String contentType() {
            return;  
         * @param str target string
                assert indexAnalyzers != null;  
                        return value.substring(startFrom, i);
            while (pos < value.length()) {
                name,
                    patternString,  
                char c = value.charAt(i);
                    }
            setIndexAnalyzer(normalizer);
 * Mapper for the "wildcard" field type, which supports (relatively) efficient matching by wildcard, prefix, and regexp  
                context,
            }  
                throw new IllegalStateException(  
                        @Override
                            if (firstPhaseCost >= Long.MAX_VALUE / MATCH_COST_ESTIMATE) {
        }  
                    String prefixTerm = possiblePrefixTerms.get(0);
        // Visible for testing only. Nothing below is used by production code.  
                        public long cost() {
        MappedFieldType mappedFieldType,  
                    consecutiveBackslashes = 0;
        private static final Set<Character> WILDCARD_SPECIAL = Set.of('?', '*', '\\');
                } else if (regExp.kind == RegExp.Kind.REGEXP_CHAR && possiblePrefixTerms != null) {
            return new WildcardMatchingQuery(name(), builder.build(), expectedValues::contains, pattern.toString(), 0, 0, context, this);  
                matchFlags,  
     * [0, 0, 'l']
                    if (normalizer == null) {  
            final Set<Character> targetChars = regexpMode ? REGEXP_SPECIAL : WILDCARD_SPECIAL;
            Automaton automaton = Operations.determinize(regExp.toAutomaton(), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
    /**  
                        if (candidate.length() > prefixTerm.length()) {
        FIELD_TYPE.setTokenized(true);
         * state: an {@link IndexFieldData} (itself cached per field by the index) or the set of source paths.  
                terms.add(new String(buffer));
                if (isEndOfValue) {  
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            return this;
        }
                    // Safe because the query holds no request- or shard-scoped state: the value fetcher supplier
                query = builder.build();  
                // If there are 3-gram terms, keep the first phase selective with shorter prefix terms.
        @Override
                BooleanQuery.Builder builder = new BooleanQuery.Builder();
            if (caseInsensitive) {
        private static String getNonWildcardSequence(String value, int startFrom) {  
            } else {  
 *
        }
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.NONE) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            this.nullValue.setValue(nullValue);
import org.apache.lucene.document.Field;  
                    }
            return indexAnalyzer();
            return sb.toString();
        }
            if (this == o) return true;
        tokenizer.setReader(new StringReader(value));
                }
 *
                    return regexpToQuery(fieldName, regExp.exp1, caseInsensitive, possiblePrefixTerms);
        private static final long MATCH_COST_ESTIMATE = 1000L;  
        this.normalizerName = builder.normalizer.getValue();
     *    derived source, so that we can always derive source even if doc values are disabled  
        }
                        }
                    clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, null));  
                    if (targetChars.contains(c)) {
        @Override
            return new ConstantScoreWeight(this, boost) {
        private static final Set<Character> REGEXP_SPECIAL = Set.of(  
                    return s.equals(performEscape(finalValue, true));
            if (Objects.requireNonNull(regExp.kind) == RegExp.Kind.REGEXP_UNION) {  
            '/',
        public WildcardMatchingQuery(
            @Override
        // ---------------------------------------------------------------------------------------------
            super.reset();
                        return keywordValue;
     * <p>  
                }
                regexpPredicate,  
         * @return escaped string
            );
            '^',
                if (possiblePrefixTerms.isEmpty()) {
    public int ignoreAbove() {
    @Override
            super(name, true, false, builder.hasDocValues.getValue(), TextSearchInfo.SIMPLE_MATCH_ONLY, builder.meta.getValue());  
                for (int i = clauses.size() - 1; i >= 0; i--) {  
                        }
         * case-insensitive regexp {@code a|b}, for instance, both approximate with the field's exists query and
                                }
     * ['e', 'n', 'e']  
                    }  
            firstPhaseQuery.visit(queryVisitor);
        }
            this.syntaxFlags = syntaxFlags;
            final String finalValue;
                @Override  
        @Override
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), binaryValue));
         *
                        query = new PrefixQuery(new Term(fieldName, term));  
     *    2. If "normalizer" is set in the field mapping, then also we won't support derived source, as with
                return binaryValue.utf8ToString();
            failIfNoDocValues();  
        public String typeName() {
                    assert term.length() < NGRAM_SIZE;
     * @opensearch.internal  
            return sb.toString();  
                List<Query> clauses = new ArrayList<>();
        }
                    }  
                sb.append(str.charAt(i));
            BooleanQuery.Builder matchAllTermsBuilder = new BooleanQuery.Builder();
                    // a cached bitset stays valid for the life of the cache entry.
            return has_next;  
     * <p>  
            ')',
/**
        if (fieldType().hasDocValues()) {
            buffer[offset++ % NGRAM_SIZE] = (char) c;
                            final ValueFetcher valueFetcher = valueFetcherSupplier.get();
     */  
                                    return false;
            if ("default".equals(normalizerName) == false) {
        @Override  
        }  
        }
        this.indexAnalyzers = builder.indexAnalyzers;
            true,  
                    fieldName,  
        XContentParser parser = context.parser();
                List<Query> clauses = new ArrayList<>();
                && Objects.equals(fieldName, that.fieldName)  
            int matchFlags,
     * 1. Doc values must be enabled to derive the source, later we can add explicit stored field in case of
            Predicate<String> matchPredicate;
        public WildcardFieldMapper.Builder ignoreAbove(int ignoreAbove) {  
                public boolean isCacheable(LeafReaderContext leafReaderContext) {
                    terms.add(new String(buffer));
                matchPredicate = s -> {  
                    if (string.length() == NGRAM_SIZE) {
            Set<String> requiredNGrams = getRequiredNGrams(finalValue, false);  
            public FieldValueType getDerivedFieldPreference() {  
            Query approximation;
            if (rewriteFirstPhase != firstPhaseQuery) {
                    ScorerSupplier firstPhaseSupplier = firstPhaseWeight.scorerSupplier(context);
                return query.iterator().next().query();  
            StringBuilder sb = new StringBuilder();
    public static final int NGRAM_SIZE = 3;  
                }  
                boolean isEndOfValue = pos + rawSequence.length() == value.length();
            final int ignoreAbove = this.ignoreAbove;
import org.opensearch.index.fielddata.plain.NonPruningSortedSetOrdinalsIndexFieldData;
            }
                    syntaxFlags,
            int syntaxFlags,  
        /**
                    } else {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                        String candidate = possiblePrefixTerms.get(i);  
            }
                    // resolves index-level data up front (see WildcardFieldType#valueFetcherSupplier), and equal  
                if (pattern.length() > 0) {
    private final String normalizerName;
            );  
                BooleanQuery.Builder builder = new BooleanQuery.Builder();  
        CopyTo copyTo,
        NamedAnalyzer normalizer = fieldType().normalizer();  
                approximation = matchAllTermsQuery(name(), requiredNGrams, caseInsensitive);
            // TODO: Not sure if we can reasonably describe a fuzzy query in terms of n-grams without exploding the cardinality
                @Override
import java.io.IOException;  
            final boolean caseInsensitive = matchFlags == RegExp.ASCII_CASE_INSENSITIVE;
                } else {
            }
        /**  
        }
            }
    }
import org.apache.lucene.search.IndexSearcher;
                return () -> new DocValueFetcher(DocValueFormat.RAW, fieldData);
            for (String term : terms) {  
            QueryShardContext context
        private static int findNonWildcardSequence(String value, int startFrom) {
        private final int ignoreAbove;  
     *
                }
import org.apache.lucene.search.ConstantScoreWeight;  
                regexpPredicate = s -> {
            QueryShardContext context  
 * queries. It's not really a "full-text" field type, but rather an "unstructured string" field type.
        @Override  
        @Override
                );
            int syntaxFlags,
                    } else if (possiblePrefixTerms != null) {
        // Copy relevant parameters from KeywordFieldMapper
        }  
        ) {
import org.opensearch.common.unit.Fuzziness;  
            return wildcardQuery(quoteWildcard(BytesRefs.toString(value)), MultiTermQuery.CONSTANT_SCORE_REWRITE, true, context);
            Set<String> expectedValues = new HashSet<>();
                                }  
            this.matchFlags = matchFlags;  
                char c = value.charAt(i);  
                Arrays.fill(buffer, (char) 0);
        }
                    return compiledAutomaton.runAutomaton.run(valueBytes.bytes, valueBytes.offset, valueBytes.length);
        ) {  
    }
     * false positives by evaluating the true field value.  
                char curChar = buffer[(offset + i) % NGRAM_SIZE];
        @Override
        }  
                }
                    }
     * query provides the best possible filter over the indexed trigrams, while the second phase matcher eliminates
    public static final class Builder extends ParametrizedFieldMapper.Builder {
            for (int i = 0; i < NGRAM_SIZE - 1; i++) {
         * @param regExp a parsed node in the {@link RegExp} tree
        }
                    consecutiveBackslashes++;
         */
                    regExp = regExp.exp1;
            }  
 * SPDX-License-Identifier: Apache-2.0
            NamedAnalyzer normalizer = normalizer();  
                for (int j = 0; j < currentSequence.length() && j < NGRAM_SIZE - 1; j++) {
            final String fieldName = name();  
        // Package-private for testing
                        throw new UncheckedIOException(e);
            super(name);
            this.ignoreAbove = builder.ignoreAbove.getValue();
                return new WildcardMatchingQuery(
            charTermAttribute.setLength(NGRAM_SIZE);  
                if (value == null) {
        }  
                if (WILDCARD_SPECIAL.contains(str.charAt(i))) {
            if (requiredNGrams.isEmpty()) {
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
            m -> toType(m).ignoreAbove,
                if (c == '\\') {
        WildcardFieldMapper.Builder nullValue(String nullValue) {
        private final String patternString; // For toString
        private static BooleanQuery matchAllTermsQuery(String fieldName, Set<String> terms, boolean caseInsensitive) {  
                syntaxFlags,
         */  
 */  
            this(name, null);  
                return existsQuery(context);
import org.opensearch.index.query.QueryShardContext;  
            .acceptsNull();  
        Supplier<ValueFetcher> valueFetcherSupplier(QueryShardContext context) {
     *       considering for these cases we will need to have explicit stored field.
        static Set<String> getRequiredNGrams(String value, boolean regexpMode) {
        return new DerivedFieldGenerator(mappedFieldType, new SortedSetDocValuesFetcher(mappedFieldType, simpleName()) {
                }  
        );
                    if (caseInsensitive) {
            NamedAnalyzer normalizer,
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.SINGLE) {
                        approximation = AutomatonQueries.caseInsensitivePrefixQuery(new Term(name(), prefixTerm));  
            }
        public WildcardFieldMapper.Builder docValues(boolean hasDocValues) {  
            return wildcardQuery(value + "*", method, caseInsensitive, context);
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
import org.apache.lucene.search.TwoPhaseIterator;
                }  
                    if (caseInsensitive) {  
import java.util.ArrayList;  
    private static final FieldType FIELD_TYPE = new FieldType();
                    // special case when we should generate '0xxxxxxx0', where we have (NGRAM_SIZE - 2) * x
        MultiFields multiFields,
            } else if (regExp.kind == RegExp.Kind.REGEXP_CONCATENATION) {
                        possiblePrefixTerms.add(string);  
                    }
                    pattern.append('|');
import java.util.Set;
        private final String fieldName;
        public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
         * {@link #equals(Object)} because the matcher itself is a lambda that cannot be compared, and the pattern
        private final int syntaxFlags;
        }  
                charTermAttribute.buffer()[i] = curChar;
public class WildcardFieldMapper extends ParametrizedFieldMapper {
     * <p>
            return new NonPruningSortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
                query = builder.build();
        public void visit(QueryVisitor queryVisitor) {
        super(simpleName, mappedFieldType, multiFields, copyTo);
            this.patternString = Objects.requireNonNull(patternString);  
                    return true;  
        String value = parseWildcardValue(context);
        }
        }
            this.matchFlags = matchFlags;
        private final IndexAnalyzers indexAnalyzers;
        ) {  
        @Override
                createFieldNamesField(context);
                    char c = str.charAt(i + 1);  
            );
                        terms.add(currentSequence.substring(i, i + 3));
                return new MatchNoDocsQuery("Wildcard expression matches nothing");
        @Override
        // Copied from KeywordFieldMapper.KeywordFieldType. Static so that the returned fetcher captures only the
import java.util.HashSet;  
                if (currentSequence.length() >= NGRAM_SIZE) {
                                    sourceLookup.setSegmentAndDocument(context, approximation.docID());
                this.valueFetcherSupplier = fieldType.valueFetcherSupplier(context);
                name(),
            // Made it to the end. No more wildcards.
                                return Long.MAX_VALUE;
                    if (firstPhaseSupplier == null) {
        context.documentInput().addField(fieldType(), value);
                    builder.add(clause, BooleanClause.Occur.SHOULD);
            } else {  
                for (String string : getRequiredNGrams("*" + regExp.s + "*", true)) {
                return MatchAllDocsQuery.INSTANCE;
            }
    protected void canDeriveSourceInternal() {
            String fieldName,
        return (WildcardFieldMapper) in;  
                }
                            // SourceLookup are not thread safe, and a scorer is confined to one slice.
                caseInsensitive ? RegExp.ASCII_CASE_INSENSITIVE : 0,
                        s = s.toLowerCase(Locale.ROOT);
                        buffer[rightStartIdx - j] = currentSequence.charAt(currentSequence.length() - j - 1);
                    // queries select the same documents on a given segment (see #equals). Segments are immutable, so
            BooleanQuery.Builder builder = new BooleanQuery.Builder();  
        Builder builder  
        @Override
            for (int i = startFrom; i < value.length(); i++) {  
     * ['e', 0, 0]
         * or its {@link SearchLookup}, which transitively reference the shard's {@code IndexSearcher} and segment
         * <p>
                    return i;  
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.ALL) {
import org.apache.lucene.search.Scorer;
        if (value == null || value.length() > ignoreAbove) {
            }  
            return CONTENT_TYPE;  
import org.apache.lucene.search.TermQuery;  
        );  
            this.firstPhaseQuery = Objects.requireNonNull(firstPhaseQuery);
                    };  
import org.apache.lucene.search.ScorerSupplier;
            '|',
        WildcardFieldMapper.Builder normalizer(String normalizerName) {
            int matchFlags,
        Predicate<String> getSecondPhaseMatcher() {  
    static {  
            throw new UnsupportedOperationException(  
            boolean transpositions,
                new WildcardFieldType(context.path().pathAsText(name), normalizer, this),  
 * compatible open source license.
import org.apache.lucene.search.Query;
            for (int i = 0; i < str.length(); i++) {
            CompiledAutomaton compiledAutomaton = new CompiledAutomaton(automaton);
        public WildcardFieldType(String name) {  
     * Support:
import org.apache.lucene.search.Weight;
