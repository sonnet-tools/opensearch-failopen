            if (Objects.requireNonNull(regExp.kind) == RegExp.Kind.REGEXP_UNION) {
                BytesRef binaryValue = (BytesRef) value;
        if (normalizer != null) {
                "Can only use fuzzy queries on keyword and text fields - not on [" + name() + "] which is of type [" + typeName() + "]"
        }
                        return value.substring(startFrom, i);
            return CONTENT_TYPE;
                }
import java.util.HashSet;
                name,
        // Copy relevant parameters from KeywordFieldMapper
                rawSequence = getNonWildcardSequence(value, pos);
         * {@code LRUQueryCache} keeps it alive as a cache key — so it must not hold onto the {@link QueryShardContext}
                clauses.add(regexpToQuery(fieldName, regExp.exp1, caseInsensitive, possiblePrefixTerms));
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
            }
            } else {
import org.apache.lucene.search.ScoreMode;
    @Override
     * 1. Doc values must be enabled to derive the source, later we can add explicit stored field in case of
        context.doc().add(new Field(fieldType().name(), tokenizer, FIELD_TYPE));
    }
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
        String value = parseWildcardValue(context);
                String stringVal = BytesRefs.toString(value);
     * <p>
        tokenizer.setReader(new StringReader(value));
            } else if (regExp.kind == RegExp.Kind.REGEXP_STRING) {
                rawSequence = getNonWildcardSequence(value, 0);
    @Override
            } else if (query.clauses().size() == 0) {
     *
            if (hasDocValues()) {
                        final Query subQuery;
        public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
                && Objects.equals(patternString, that.patternString);
 * compatible open source license.
        @Override
                    if (caseInsensitive) {
    private final String normalizerName;
                        String candidate = possiblePrefixTerms.get(i);
                        buffer[rightStartIdx - j] = currentSequence.charAt(currentSequence.length() - j - 1);
                            buffer[i + 1] = currentSequence.charAt(i);
        }
            super(name);
                    approximation = this.existsQuery(context);
                    return MatchAllDocsQuery.INSTANCE;
                                    return MATCH_COST_ESTIMATE;
                            SourceLookup sourceLookup = new SourceLookup();
        }, null) {
        ) {
        this.hasDocValues = builder.hasDocValues.getValue();
     * ['e', 'n', 'e']
    private final int ignoreAbove;
            return "WildcardMatchingQuery(" + fieldName + ":\"" + patternString + "\")";
                    if (caseInsensitive) {
import org.opensearch.core.xcontent.XContentParser;
            if (approximation instanceof MatchAllDocsQuery) {
import org.apache.lucene.util.automaton.RegExp;
            if (this == o) return true;
                    builder.add(clause, BooleanClause.Occur.SHOULD);
                                @Override
        this.indexAnalyzers = builder.indexAnalyzers;
import java.util.Locale;
            if (context != null) {
            if (rewriteFirstPhase != firstPhaseQuery) {
                        assert string.length() < NGRAM_SIZE;
        if (fieldType().hasDocValues()) {
     * Implements the various query types over wildcard fields.
            Query rewriteFirstPhase = firstPhaseQuery.rewrite(indexSearcher);
                    Query clause = clauses.get(i);
                regexpPredicate = s -> {
import org.apache.lucene.search.BooleanQuery;
                        for (int i = 0; i < currentSequence.length(); i++) {
                    sb.append('\\');
     *    derived source, so that we can always derive source even if doc values are disabled
     * ['e', 0, 0]
            '^',
            char[] buffer = new char[NGRAM_SIZE];
        }
            }
            this.ignoreAbove = Integer.MAX_VALUE;
        WildcardFieldMapper.Builder normalizer(String normalizerName) {
        if (context.externalValueSet()) {
        @Override
                                    for (Object value : values) {
                boolean isEndOfValue = pos + rawSequence.length() == value.length();
                    if (caseInsensitive) {
    @Override
                        terms.add(new String(buffer));
            this.nullValue = null;
    }
                                @Override
     * ['u','c','e']
        this.ignoreAbove = builder.ignoreAbove.getValue();
            '}',
         * @return a query that matches on the known required parts of the given regular expression
            }
                    }
                sb.append(str.charAt(i));
import java.util.function.Predicate;
                }
                        public long cost() {
                0,
        }
        }
                // when type equals SINGLE, #compiledAutomaton.runAutomaton is null
                    clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, possiblePrefixTerms));
                    matchAllTermsQuery(name(), getRequiredNGrams(quoteWildcard(stringVal), false), false),
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            // field type or to the query shard context.
            }
            );
     *    1. When using doc values, for multi value field, result would be deduplicated and in sorted order
import org.apache.lucene.analysis.Tokenizer;
                    regExp = regExp.exp1;
            Integer.MAX_VALUE
        private final int matchFlags;
            String value,
        return new Builder(simpleName(), indexAnalyzers).init(this);
        public WildcardFieldMapper.Builder docValues(boolean hasDocValues) {
        // convert to utf8 only once before feeding postings/dv/stored fields
                    }
import org.apache.lucene.search.Weight;
            setIndexAnalyzer(normalizer);
    protected String contentType() {
                    Query clause = clauses.get(i);
            for (int i = 0; i < str.length(); i++) {
            if (requiredNGrams.isEmpty()) {
        }
        private static final Set<Character> WILDCARD_SPECIAL = Set.of('?', '*', '\\');
        public void reset() throws IOException {
            @Override
            this.patternString = Objects.requireNonNull(patternString);
import org.apache.lucene.search.MultiTermQuery;
import org.opensearch.search.lookup.SourceLookup;
                // Use ROOT locale, as it seems to be consistent with AutomatonQueries.toCaseInsensitiveChar.
        MappedFieldType mappedFieldType,
        private final Parameter<String> normalizer = Parameter.stringParam("normalizer", false, m -> toType(m).normalizerName, "default");
            int syntaxFlags,
     * [0, 'l', 'u']
                matchPredicate,
import java.util.Objects;
        if (this.ignoreAbove != Integer.MAX_VALUE || !Objects.equals(this.normalizerName, "default")) {
        }
            '\\'
import org.apache.lucene.search.ConstantScoreScorer;
         * alone does not always pin down which documents the matcher accepts: a case-sensitive and a
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        public WildcardFieldType(String name) {
                value,
            for (int i = startFrom; i < value.length(); i++) {
        XContentParser parser = context.parser();
                public boolean isCacheable(LeafReaderContext leafReaderContext) {
                            }
                    }
        }
                        terms.add(currentSequence.substring(i, i + 3));
                    BooleanClause.Occur.SHOULD
            this.ignoreAbove.setValue(ignoreAbove);
                }
        private final char[] buffer = new char[NGRAM_SIZE]; // Ring buffer for up to 3 chars
                                return Long.MAX_VALUE;
                    }
        }
    /**
                }
                    String prefixTerm = possiblePrefixTerms.get(0);
                value = normalizeWildcardPattern(name(), value, normalizer);
     * Support:
import org.opensearch.index.fielddata.IndexFieldData;
            String rawSequence = null;
            this.secondPhaseMatcher = secondPhaseMatcher;
                        }
            return terms;
            }
        }
                            final ValueFetcher valueFetcher = valueFetcherSupplier.get();
                query = builder.build();
        private final Predicate<String> secondPhaseMatcher;
                matchFlags,
         * Resolved from the {@link QueryShardContext} at construction time and {@code null} when the query was
            m -> toType(m).ignoreAbove,
            MultiTermQuery.RewriteMethod method,
            }
         * state: an {@link IndexFieldData} (itself cached per field by the index) or the set of source paths.
     * Visible for testing.
        // Copied from KeywordFieldMapper.KeywordFieldType. Static so that the returned fetcher captures only the
                    char c = str.charAt(i + 1);
                && Objects.equals(fieldName, that.fieldName)
                    if (targetChars.contains(c)) {
        public boolean equals(Object o) {
            );
        @Override
import org.opensearch.search.lookup.SearchLookup;
         * {@link #createWeight(IndexSearcher, ScoreMode, float)}.
            value = normalizeValue(normalizer, name(), value);
                if (pattern.length() > 0) {
                        if (caseInsensitive) {
                        }
        /**
                    } else {
            this.valueFetcherSupplier = valueFetcherSupplier;
        private static Query regexpToQuery(String fieldName, RegExp regExp, boolean caseInsensitive, List<String> possiblePrefixTerms) {
    private final IndexAnalyzers indexAnalyzers;
            throw new IllegalArgumentException(
     * For example, given the string "lucene", output the following terms:
                name(),
        checkDocValuesForDerivedSource();
                }
         * cache answer one with the other's documents.
                pattern.append(stringVal);
            return wildcardQuery(quoteWildcard(BytesRefs.toString(value)), MultiTermQuery.CONSTANT_SCORE_REWRITE, true, context);
                if (possiblePrefixTerms.isEmpty()) {
            final String finalValue = normalizer != null ? value = normalizer.normalize(name(), value).utf8ToString() : value;
                if (currentSequence.length() >= NGRAM_SIZE) {
            int matchFlags,
        }
            return Arrays.asList(nullValue, ignoreAbove, normalizer, hasDocValues, meta);
            }
                currentSequence = performEscape(rawSequence, regexpMode);
        ) {
                        public Scorer get(long leadCost) throws IOException {
                return FieldValueType.DOC_VALUES;
                            Scorer approximateScorer = firstPhaseSupplier.get(leadCost);
            "ignore_above",
     * @opensearch.internal
        return ignoreAbove;
    ) {
            String patternString,
            this.nullValue.setValue(nullValue);
                if (isEndOfValue) {
        final BytesRef binaryValue = new BytesRef(value);
     * ['c', 'e', 'n']
         * @param regexpMode whether is used for regexp escape
import org.apache.lucene.search.MatchNoDocsQuery;
    }
            '*',
                    secondPhaseMatcher,
        public Query termsQuery(List<?> values, QueryShardContext context) {
        private static final Set<Character> REGEXP_SPECIAL = Set.of(
            ']',
    }
        // ---------------------------------------------------------------------------------------------
            RegExp regExp = new RegExp(finalValue, syntaxFlags, matchFlags);
        private static String performEscape(String str, boolean regexpMode) {
 * @opensearch.internal
            this.secondPhaseMatcher = Objects.requireNonNull(secondPhaseMatcher);
            '(',
                List<Query> clauses = new ArrayList<>();
import org.apache.lucene.search.Query;
    }
                } else {
            Supplier<ValueFetcher> valueFetcherSupplier
        Builder builder
            Automaton automaton = WildcardQuery.toAutomaton(new Term(name(), finalValue), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
            true,
        return CONTENT_TYPE;
                approximation,
            int pos = 0;
        public String toString(String s) {
                BooleanQuery.Builder builder = new BooleanQuery.Builder();
            StringBuilder pattern = new StringBuilder();
            Query query;
            @Override
                                            return true;
                        if (candidate.length() > prefixTerm.length()) {
        private static SourceValueFetcher sourceValueFetcher(
                            TwoPhaseIterator twoPhaseIterator = new TwoPhaseIterator(approximation) {
            int matchFlags,
         *
import org.opensearch.index.analysis.IndexAnalyzers;
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
                "/" + finalValue + "/",
            List<String> possiblePrefixTerms = new ArrayList<>();
            this.fieldName = Objects.requireNonNull(fieldName);
                "Unable to derive source for [" + name() + "] with " + "ignore_above and/or normalizer set"
                }
         * only for term query
        } else {
            MultiTermQuery.RewriteMethod method,
                } else {
        }
        }
                    Arrays.fill(buffer, (char) 0);
            Set<String> sourcePaths,
import org.apache.lucene.search.WildcardQuery;
            );
                    } else if (possiblePrefixTerms != null) {
                has_next |= curChar != 0;
     * Custom two-phase query type for queries over the wildcard field. The expected behavior is that a first-phase
            '$',
            int c = input.read();
        }
                    } else {
        private final int ignoreAbove;
        public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
    private static WildcardFieldMapper toType(FieldMapper in) {
                                    return false;
    static {
            failIfNoDocValues();
                    return regexpToQuery(fieldName, regExp.exp1, caseInsensitive, possiblePrefixTerms);
            return indexAnalyzer();
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
            return has_next;
import org.apache.lucene.util.automaton.CompiledAutomaton;
            return this;
        public Query rewrite(IndexSearcher indexSearcher) throws IOException {
            Query firstPhaseQuery,
            '.',
                if (term.length() == NGRAM_SIZE) {
    public int ignoreAbove() {
        public Query regexpQuery(
     * <p>
            for (int i = startFrom; i < value.length(); i++) {
import java.util.List;
            super(name, true, false, false, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                }
                    return true;
                protected String parseSourceValue(Object value) {
        public WildcardFieldMapper build(BuilderContext context) {
                terms.addAll(possiblePrefixTerms);
 *
                    syntaxFlags,
                        return null;
    }
            for (String term : terms) {
    public static final class Builder extends ParametrizedFieldMapper.Builder {
                    return MatchAllDocsQuery.INSTANCE;
                        s = s.toLowerCase(Locale.ROOT);
        if (value == null || value.length() > ignoreAbove) {
                && matchFlags == that.matchFlags
     * ['l', 'u', 'c']
                        builder.add(subQuery, BooleanClause.Occur.FILTER);
import java.io.StringReader;
                    }
        }
     * query provides the best possible filter over the indexed trigrams, while the second phase matcher eliminates
                    regExp = regExp.exp1;
        public int hashCode() {
                charTermAttribute.buffer()[i] = curChar;
        @Override
     *    2. If "normalizer" is set in the field mapping, then also we won't support derived source, as with
                    return s.equals(performEscape(finalValue, true));
        private final Parameter<Integer> ignoreAbove = Parameter.intParam(
                    } catch (IOException e) {
            }
                }
                        query = new TermQuery(new Term(fieldName, term));
                return terms;
            int maxExpansions,
                return () -> new DocValueFetcher(DocValueFormat.RAW, fieldData);
            if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.ALL) {
                                        }
            }
            this.matchFlags = matchFlags;
                clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, possiblePrefixTerms));
            if (!value.startsWith("?") && !value.startsWith("*")) {
                    if (clause instanceof MatchAllDocsQuery) {
            } else {
                    }
                        }
        protected List<Parameter<?>> getParameters() {
    @Override
         * {@link #equals(Object)} because the matcher itself is a lambda that cannot be compared, and the pattern
        this.nullValue = builder.nullValue.getValue();
                if (findNonWildcardSequence(value, 0) != value.length() || value.length() == 0 || value.contains("?")) {
                }
                        return null;
                            long firstPhaseCost = firstPhaseSupplier.cost();
/*
                    }
                @Override
                        s = s.toLowerCase(Locale.ROOT);
import java.util.Map;
                    terms.add(new String(buffer));
            };
                            if (firstPhaseCost >= Long.MAX_VALUE / MATCH_COST_ESTIMATE) {
            int syntaxFlags,
import org.apache.lucene.index.LeafReaderContext;
            this.firstPhaseQuery = firstPhaseQuery;
     * The builder for the field mapper.
                }
                    }
                        i++;
                }
        CopyTo copyTo,
        }
        @Override
import java.util.Arrays;
         */
            } else if ((regExp.kind == RegExp.Kind.REGEXP_REPEAT_MIN || regExp.kind == RegExp.Kind.REGEXP_REPEAT_MINMAX)
                    if (!(clause instanceof MatchAllDocsQuery)) {
            return this;
    protected void canDeriveSourceInternal() {
            this.hasDocValues.setValue(hasDocValues);
        public Builder(String name) {
            } else {
                while (regExp.exp1.kind == RegExp.Kind.REGEXP_UNION) {
            };
         * everything it needs from {@code context} eagerly so that the returned supplier retains only index-level
                    return compiledAutomaton.runAutomaton.run(valueBytes.bytes, valueBytes.offset, valueBytes.length);
                finalValue = value.toLowerCase(Locale.ROOT);
            Set<String> requiredNGrams = getRequiredNGrams(finalValue, false);
                            prefixTerm = candidate;
         */
            final String fieldName = name();
     */
import java.util.Collections;
                buffer[i] = 0;
        ) {
            );
                    }
            NamedAnalyzer normalizer = normalizer();
            Set<String> terms = new HashSet<>();
         * @return string before escaped
        private static int findNonWildcardSequence(String value, int startFrom) {
        /**
import org.opensearch.common.lucene.BytesRefs;
import org.opensearch.common.unit.Fuzziness;
            NamedAnalyzer normalizer,
                approximation,
                    return null;
        NamedAnalyzer normalizer() {
        }
            }
         * This matters because a {@link WildcardMatchingQuery} can outlive the request that built it — Lucene's
            }
            return sb.toString();
                int startIdx = Math.max(NGRAM_SIZE - currentSequence.length(), 1);
        }
         * reversed process of quoteWildcard
                    for (int j = 0; j < currentSequence.length() && j < NGRAM_SIZE - 1; j++) {
                        approximation = new PrefixQuery(new Term(name(), prefixTerm));
                Arrays.fill(buffer, (char) 0);
            throw new UnsupportedOperationException(
import org.apache.lucene.search.QueryVisitor;
                char c = value.charAt(i);
    /**
            this.ignoreAbove = builder.ignoreAbove.getValue();
                } else {
    /**
            );
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
            int ignoreAbove,
                // Can add prefix term
        private static final long MATCH_COST_ESTIMATE = 1000L;
     * false positives by evaluating the true field value.
        }
            return new WildcardMatchingQuery(
                    BytesRef valueBytes = BytesRefs.toBytesRef(s);
                    buffer[startIdx + j] = currentSequence.charAt(j);
        @Override
                }
    public static final class WildcardFieldType extends StringFieldType {
        }
         * @param fieldName name of the wildcard field
                caseInsensitive ? RegExp.ASCII_CASE_INSENSITIVE : 0,
    static final class WildcardFieldTokenizer extends Tokenizer {
        ) {
import org.apache.lucene.search.DocIdSetIterator;
                    consecutiveBackslashes = 0;
        }
                name(),
            } else {
            final boolean caseInsensitive = matchFlags == RegExp.ASCII_CASE_INSENSITIVE;
                            // A fresh SourceLookup and ValueFetcher per scorer: ValueFetcher.setNextReader and
                this.valueFetcherSupplier = fieldType.valueFetcherSupplier(context);
            this.nullValue = builder.nullValue.getValue();
                            subQuery = new TermQuery(new Term(fieldName, string));
 */
        }
                normalizer = indexAnalyzers.getNormalizer(normalizerName);
            // Bind every value the fetcher needs to a local so the lambda below captures no reference to this
                    String keywordValue = value.toString();
            return wildcardQuery(quoteWildcard(BytesRefs.toString(value)), MultiTermQuery.CONSTANT_SCORE_REWRITE, false, context);
            this.patternString = patternString;
            final String nullValue = this.nullValue;
import org.opensearch.index.fielddata.plain.NonPruningSortedSetOrdinalsIndexFieldData;
            int consecutiveBackslashes = 0;
                } else if (regExp.kind == RegExp.Kind.REGEXP_CHAR && possiblePrefixTerms != null) {
            } else if (regExp.kind == RegExp.Kind.REGEXP_CONCATENATION) {
            return new SourceValueFetcher(sourcePaths, nullValue) {
            this(name, Collections.emptyMap());
                );
            Automaton automaton = Operations.determinize(regExp.toAutomaton(), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
                regexpPredicate = s -> {
                                        if (secondPhaseMatcher.test(value.toString())) {
                );
            return new WildcardMatchingQuery(name(), builder.build(), expectedValues::contains, pattern.toString(), 0, 0, context, this);
        String value = parseWildcardValue(context);
                // or it's only contains sequential characters less than NGRAM_SIZE (which defaults to 3).
public class WildcardFieldMapper extends ParametrizedFieldMapper {
        }
        }
                    possiblePrefixTerms.add(String.valueOf((char) regExp.c));
        context.documentInput().addField(fieldType(), value);
            }
                    return s.equals(performEscape(finalValue, false));
        private final Query firstPhaseQuery;
            }
                    // resolves index-level data up front (see WildcardFieldType#valueFetcherSupplier), and equal
                if (WILDCARD_SPECIAL.contains(str.charAt(i))) {
                }
                    }
                for (String string : getRequiredNGrams("*" + regExp.s + "*", true)) {
     */
            WildcardMatchingQuery that = (WildcardMatchingQuery) o;
    /**
         * share the pattern string, yet match different documents. Treating those two as equal would let the query
        /**
                List<Query> clauses = new ArrayList<>();
                multiFieldsBuilder.build(this, context),
    private final boolean hasDocValues;
                query = builder.build();
                    };
        }
                            return new ConstantScoreScorer(score(), scoreMode, twoPhaseIterator);
 *
            '+',
            BooleanQuery.Builder matchAllTermsBuilder = new BooleanQuery.Builder();
        private final String fieldName;
                if (value == null) {
        }
        if (value == null || value.length() > ignoreAbove) {
         * built without one. Such a query can be compared, hashed and rewritten, but not searched: see
        Tokenizer tokenizer = new WildcardFieldTokenizer();
     * <p>
            '[',
                while (regExp.exp1.kind == RegExp.Kind.REGEXP_CONCATENATION) {
        this.normalizerName = builder.normalizer.getValue();
            public Object convert(Object value) {
        @Override
            return new NonPruningSortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
         */
            String patternString,
                } else {
                    int rightStartIdx = NGRAM_SIZE - currentSequence.length() - 2;
            NamedAnalyzer normalizer = Lucene.KEYWORD_ANALYZER;
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValue, null)
            }
                // buffer[0] is automatically set to 0
                            valueFetcher.setNextReader(context);
        private static String quoteWildcard(String str) {
        public void visit(QueryVisitor queryVisitor) {
        private final Supplier<ValueFetcher> valueFetcherSupplier;
import org.apache.lucene.index.IndexOptions;
                    return existsQuery(context);
         * documents. It fetches the same values {@link #valueFetcher} would for a query-phase lookup, but resolves
        }
        );
                    patternString,
                    return i;
     *    1. If "ignore_above" is set in the field mapping, then we won't be supporting derived source for now,
    public WildcardFieldType fieldType() {
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true).alwaysSerialize();
        }
                    return compiledAutomaton.runAutomaton.run(valueBytes.bytes, valueBytes.offset, valueBytes.length);
                    assert term.length() < NGRAM_SIZE;
                    }
            }
            charTermAttribute.setLength(NGRAM_SIZE);
                        s = s.toLowerCase(Locale.ROOT);
package org.opensearch.index.mapper;
import org.apache.lucene.search.BooleanClause;
                    }
                }
import org.apache.lucene.util.automaton.Automaton;
                                }
                terms.add(new String(buffer));
            }
            String fieldName,
        // Package-private for testing
            this.matchFlags = matchFlags;
            Set<String> expectedValues = new HashSet<>();
            String normalizerName = normalizer.getValue();
     * Tokenizer to emit tokens to support wildcard first-phase matching.
import java.io.IOException;
            int syntaxFlags,
import org.opensearch.common.lucene.Lucene;
                query = builder.build();
        private final int syntaxFlags;
            ')',
            return Objects.hash(fieldName, firstPhaseQuery, patternString, syntaxFlags, matchFlags);
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.NONE) {
            this.syntaxFlags = syntaxFlags;
    }
            return this;
         * Implement the match rules described in <a href="https://swtch.com/~rsc/regexp/regexp4.html">Regular Expression Matching with a Trigram Index</a>.
import org.opensearch.search.DocValueFormat;
            if (caseInsensitive) {
        return new DerivedFieldGenerator(mappedFieldType, new SortedSetDocValuesFetcher(mappedFieldType, simpleName()) {
     * ['n', 'e', 0]
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
                final IndexFieldData<?> fieldData = context.getForField(this);
                return new DocValueFetcher(DocValueFormat.RAW, searchLookup.doc().getForField(this));
                    if (keywordValue.length() > ignoreAbove) {
        super(simpleName, mappedFieldType, multiFields, copyTo);
        public Query fuzzyQuery(
                );
            firstPhaseQuery.visit(queryVisitor);
                } else {
                    consecutiveBackslashes++;
            return sourceValueFetcher(context.sourcePath(name()), nullValue, ignoreAbove, normalizer(), name());
        @Override
import org.apache.lucene.search.ConstantScoreWeight;
    }
                if (c == '\\') {
                // This only happens when all characters are wildcard characters (* or ?),
            this.syntaxFlags = syntaxFlags;
            } else {
                rawSequence = getNonWildcardSequence(value, pos);
                        query = AutomatonQueries.caseInsensitivePrefixQuery(new Term(fieldName, term));
                        }
            QueryShardContext context
     */
        FIELD_TYPE.setTokenized(true);
            }
 * SPDX-License-Identifier: Apache-2.0
            if ("default".equals(normalizerName) == false) {
            }
        return parser.textOrNull();
            if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.SINGLE) {
            for (int i = 0; i < NGRAM_SIZE; i++) {
    }
        private static String getNonWildcardSequence(String value, int startFrom) {
                char curChar = buffer[(offset + i) % NGRAM_SIZE];
         * case-insensitive regexp {@code a|b}, for instance, both approximate with the field's exists query and
                copyTo.build(),
        private final String nullValue;
            return () -> sourceValueFetcher(sourcePaths, nullValue, ignoreAbove, normalizer, fieldName);
                if (str.charAt(i) == '\\' && (i + 1) < str.length()) {
        @Override
            if (o == null || getClass() != o.getClass()) return false;
                        + ": the query was built without a QueryShardContext, so field values cannot be fetched to verify candidates"
                    }
            }
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        }
            this.normalizer.setValue(normalizerName);
import org.apache.lucene.index.Term;
            return secondPhaseMatcher;
                    valueFetcherSupplier
        private final IndexAnalyzers indexAnalyzers;
         * @param str target string
    }
                }
                createFieldNamesField(context);
                return binaryValue.utf8ToString();
            this.fieldName = fieldName;
                        builder.add(clause, BooleanClause.Occur.FILTER);
                        }
                    if (string.length() == NGRAM_SIZE) {
    private static final FieldType FIELD_TYPE = new FieldType();
         * manually escape instead of call String.replace for better performance
        /**
         * {@link RegExp} syntax and match flags the {@link #secondPhaseMatcher} was compiled with. They take part in
            final Set<Character> targetChars = regexpMode ? REGEXP_SPECIAL : WILDCARD_SPECIAL;
                char c = value.charAt(i);
        @Override
                clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, null));
                pos = findNonWildcardSequence(value, pos + rawSequence.length());
                return new WildcardMatchingQuery(
        }
            .acceptsNull();
                    }
                        return normalizeValue(normalizer, fieldName, keywordValue);
        };
                matchPredicate = s -> {
                                    List<?> values = valueFetcher.fetchValues(sourceLookup);
         */
            }
            boolean has_next = false;
                return MatchAllDocsQuery.INSTANCE;
         * <p>
        @Override
/**
                        + this
            this.indexAnalyzers = indexAnalyzers;
                            };
            return this;
        public Query termQuery(Object value, QueryShardContext context) {
                @Override
        public WildcardFieldMapper.Builder ignoreAbove(int ignoreAbove) {
        }
import org.apache.lucene.util.BytesRef;
     */
            }
                                    sourceLookup.setSegmentAndDocument(context, approximation.docID());
                for (int i = clauses.size() - 1; i >= 0; i--) {
            Predicate<String> matchPredicate;
                for (int i = clauses.size() - 1; i >= 0; i--) {
                approximation = matchAllTermsQuery(name(), requiredNGrams, caseInsensitive);
        // Visible for testing only. Nothing below is used by production code.
            for (int i = 0; i < str.length(); i++) {
    static class WildcardMatchingQuery extends Query {
import org.opensearch.common.lucene.search.AutomatonQueries;
        }
     * Will emit all substrings of only 3, with 0-valued anchors for the prefix/suffix.
import java.util.ArrayList;
        NamedAnalyzer normalizer = fieldType().normalizer();
import org.apache.lucene.document.Field;
                                }
            return syntaxFlags == that.syntaxFlags
        @Override
        @Override
                            DocIdSetIterator approximation = approximateScorer.iterator();
            return;
                        return keywordValue;
                        query = AutomatonQueries.caseInsensitiveTermQuery(new Term(fieldName, term));
                        query = new PrefixQuery(new Term(fieldName, term));
}
                    matchFlags,
import org.apache.lucene.search.MatchAllDocsQuery;
            return nullValue;
                    ScorerSupplier firstPhaseSupplier = firstPhaseWeight.scorerSupplier(context);
    }
                    BytesRef valueBytes = BytesRefs.toBytesRef(s);
            this.firstPhaseQuery = Objects.requireNonNull(firstPhaseQuery);
            buffer[offset++ % NGRAM_SIZE] = (char) c;
                    rewriteFirstPhase,
            '/',
                return new MatchNoDocsQuery("Wildcard expression matches nothing");
                finalValue = value;
                new WildcardFieldType(context.path().pathAsText(name), normalizer, this),
         */
    public static final int NGRAM_SIZE = 3;
            if (format != null) {
            int maxDeterminizedStates,
     * [0, 0, 'l']
        }
            BooleanQuery query;
        MultiFields multiFields,
import org.opensearch.index.query.QueryShardContext;
        }
                        approximation = AutomatonQueries.caseInsensitivePrefixQuery(new Term(name(), prefixTerm));
                regexpPredicate,
                        throw new UncheckedIOException(e);
            return context.externalValue().toString();
            final StringBuilder sb = new StringBuilder();
 * The OpenSearch Contributors require contributions made to
            this(name, null);
            Predicate<String> regexpPredicate;
                            return firstPhaseCost * MATCH_COST_ESTIMATE;
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
import java.util.Set;
            Query approximation;
        @Override
            return value.length();
                return query.iterator().next().query();
        }
        );
        }
                                    }
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;
        public WildcardFieldType(String name, Map<String, String> meta) {
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.ALL) {
            '?',
            // Copied from KeywordFieldMapper.KeywordFieldType
            '{',
            String currentSequence = null;
                }
        String simpleName,
 * Mapper for the "wildcard" field type, which supports (relatively) efficient matching by wildcard, prefix, and regexp
                            subQuery = AutomatonQueries.caseInsensitiveTermQuery(new Term(fieldName, string));
    }
    public static final TypeParser PARSER = new TypeParser((n, c) -> new WildcardFieldMapper.Builder(n, c.getIndexAnalyzers()));
        @Override
            return wildcardQuery(value + "*", method, caseInsensitive, context);
                    possiblePrefixTerms.add(currentSequence);
            boolean transpositions,
                    // a cached bitset stays valid for the life of the cache entry.
        public WildcardFieldType(String name, NamedAnalyzer normalizer, Builder builder) {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        /**
        @Override
            }
            List<String> possiblePrefixTerms = new ArrayList<>();
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't " + "support formats.");
                    if (caseInsensitive) {
            for (int i = 0; i < NGRAM_SIZE - 1; i++) {
        FIELD_TYPE.setStored(false);
                    rightStartIdx = rightStartIdx < 0 ? NGRAM_SIZE - 2 : rightStartIdx;
            }
            WildcardFieldType fieldType
            return matchAllTermsBuilder.build();
                    if (normalizer == null) {
import org.apache.lucene.search.TermQuery;
         * readers. See <a href="https://github.com/opensearch-project/OpenSearch/issues/22419">issue 22419</a>.
                clauses.add(regexpToQuery(fieldName, regExp.exp1, caseInsensitive, null));
                syntaxFlags,
     */
        }
        }
                        Arrays.fill(buffer, (char) 0);
            if (fieldType().hasDocValues() == false) {
            Fuzziness fuzziness,
                        @Override
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            NamedAnalyzer normalizer = normalizer();
                    for (int i = 0; i < currentSequence.length() - NGRAM_SIZE + 1; i++) {
            if (value.isEmpty()) {
                }
                throw new IllegalStateException(
            return new WildcardFieldMapper(
            return;
            Weight firstPhaseWeight = firstPhaseQuery.createWeight(searcher, scoreMode, boost);
                if (c != '?' && c != '*') {
                pos = findNonWildcardSequence(value, pos);
        }
        public String typeName() {
                    // special case when we should generate '0xxxxxxx0', where we have (NGRAM_SIZE - 2) * x
                    if (firstPhaseSupplier == null) {
        }
            if (hasDocValues() && searchLookup != null) {
                assert indexAnalyzers != null;
            Predicate<String> secondPhaseMatcher,
            while (pos < value.length()) {
                    } else {
            final Set<String> sourcePaths = context.sourcePath(name());
        private static BooleanQuery matchAllTermsQuery(String fieldName, Set<String> terms, boolean caseInsensitive) {
            final int ignoreAbove = this.ignoreAbove;
    protected WildcardFieldMapper(
        ) {
        }
                context,
            }
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                };
            return new ConstantScoreWeight(this, boost) {
                context,
    }
            return query;
    protected DerivedFieldGenerator derivedFieldGenerator() {
        @Override
                    "Cannot search "
                this.valueFetcherSupplier = null;
        @Override
        FIELD_TYPE.freeze();
            Predicate<String> secondPhaseMatcher,
                        @Override
                    fieldName,
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        return (WildcardFieldType) super.fieldType();
            } else {
                for (int j = 0; j < currentSequence.length() && j < NGRAM_SIZE - 1; j++) {
            c = c == -1 ? 0 : c;
import org.apache.lucene.search.IndexSearcher;
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.NONE) {
         */
                        possiblePrefixTerms.add(string);
                BooleanQuery.Builder builder = new BooleanQuery.Builder();
            }
        }
        // ---------------------------------------------------------------------------------------------
            super.reset();
            return this;
                return new MatchNoDocsQuery("Regular expression matches nothing");
                this
                };
            String fieldName,
            '|',
            String nullValue,
                    }
        }
            }
         * Returns a supplier of the {@link ValueFetcher} that {@link WildcardMatchingQuery} uses to verify candidate
    protected void parseCreateField(ParseContext context) throws IOException {
                    pattern.append('|');
        WildcardFieldMapper.Builder nullValue(String nullValue) {
            }
                    // queries select the same documents on a given segment (see #equals). Segments are immutable, so
                sb.append(str.charAt(i));
                }
        private int offset = NGRAM_SIZE - 1; // next position in buffer to store next input char
                    }
import org.apache.lucene.document.FieldType;
                this
        static Set<String> getRequiredNGrams(String value, boolean regexpMode) {
        FIELD_TYPE.setOmitNorms(true);
import org.apache.lucene.search.Scorer;
    @Override
         * @param str target string
            if (terms.isEmpty()) {
                    if (pos == 0 && currentSequence.length() == NGRAM_SIZE - 2) {
                                public float matchCost() {
import java.util.function.Supplier;
                }
     * Considerations:
    }
        private WildcardMatchingQuery(
                    // Safe because the query holds no request- or shard-scoped state: the value fetcher supplier
     *       considering for these cases we will need to have explicit stored field.
            Object value,
            int prefixLength,
            CompiledAutomaton compiledAutomaton = new CompiledAutomaton(automaton);
                    approximation = existsQuery(context);
            final NamedAnalyzer normalizer = normalizer();
    /**
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                } else if (isEndOfValue != true && currentSequence.isEmpty() == false) {
     *       normalizer it is hard to regenerate original source
         * @param regExp a parsed node in the {@link RegExp} tree
                    return new ScorerSupplier() {
import org.apache.lucene.search.TwoPhaseIterator;
                    }
        public WildcardMatchingQuery(
            QueryShardContext context,
        }
                // when type equals SINGLE, #compiledAutomaton.runAutomaton is null
            StringBuilder sb = new StringBuilder();
                    try {
                }
    }
                                public boolean matches() throws IOException {
        /**
import org.opensearch.index.analysis.NamedAnalyzer;
        }
            for (Object value : values) {
     * <p>
        public boolean incrementToken() throws IOException {
            // Made it to the end. No more wildcards.
                this
            final String finalValue;
                matchAllTermsBuilder.add(query, BooleanClause.Occur.FILTER);
        Predicate<String> getSecondPhaseMatcher() {
            public FieldValueType getDerivedFieldPreference() {
        if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
     * <p>
 * queries. It's not really a "full-text" field type, but rather an "unstructured string" field type.
 * this file be licensed under the Apache-2.0 license or a
                && regExp.min > 0) {
                    if (caseInsensitive) {
            return sb.toString();
                    if (caseInsensitive) {
        Supplier<ValueFetcher> valueFetcherSupplier(QueryShardContext context) {
                currentSequence = performEscape(rawSequence, regexpMode);
        }
                builder.add(
            // TODO: Not sure if we can reasonably describe a fuzzy query in terms of n-grams without exploding the cardinality
            if (valueFetcherSupplier == null) {
            return value.substring(startFrom);
                expectedValues.add(stringVal);
            if (query.clauses().size() == 1) {
        @Override
import org.apache.lucene.search.ScorerSupplier;
        private final CharTermAttribute charTermAttribute = addAttribute(CharTermAttribute.class);
                    if ((c == '?' || c == '*') && consecutiveBackslashes % 2 == 0) {
 */
            int matchFlags,
            }
    @Override
            if (normalizer != null) {
import org.apache.lucene.search.PrefixQuery;
        @Override
            } else if (compiledAutomaton.type == CompiledAutomaton.AUTOMATON_TYPE.SINGLE) {
            throw new UnsupportedOperationException("TODO");
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), binaryValue));
            CompiledAutomaton compiledAutomaton = new CompiledAutomaton(automaton);
        }
                    clauses.add(regexpToQuery(fieldName, regExp.exp2, caseInsensitive, null));
         * @return escaped string
import java.io.UncheckedIOException;
                    }
        }
import org.apache.lucene.document.SortedSetDocValuesField;
                @Override
    }
                    for (int i = 1; i < possiblePrefixTerms.size(); i++) {
        }
                BooleanQuery.Builder builder = new BooleanQuery.Builder();
                };
            Query firstPhaseQuery,
                // If there are 3-gram terms, keep the first phase selective with shorter prefix terms.
                && Objects.equals(firstPhaseQuery, that.firstPhaseQuery)
import org.apache.lucene.util.automaton.Operations;
    private String parseWildcardValue(ParseContext context) throws IOException {
        // arguments handed to it — see valueFetcherSupplier.
                            // SourceLookup are not thread safe, and a scorer is confined to one slice.
    @Override
                };
        }
            String fieldName
                return existsQuery(context);
        @Override
            }
            QueryShardContext context
     * <p>
         * or its {@link SearchLookup}, which transitively reference the shard's {@code IndexSearcher} and segment
            super(name, true, false, builder.hasDocValues.getValue(), TextSearchInfo.SIMPLE_MATCH_ONLY, builder.meta.getValue());
                return existsQuery(context);
    private final String nullValue;
    public static final String CONTENT_TYPE = "wildcard";
            Query approximation = regexpToQuery(name(), regExp, caseInsensitive, possiblePrefixTerms);
        return (WildcardFieldMapper) in;
                        return clause;
                    }
            return new WildcardMatchingQuery(
        private final String patternString; // For toString
                        } else {
                matchPredicate = s -> {
                }
                    // This is the end of the input. We can attach a suffix anchor.
