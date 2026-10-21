                    settings.fuzzyMaxExpansions,
     * with a catchable exception keeps the recursion bounded. See CVE-2026-63144.
        }
            this.fuzzyMaxExpansions = other.fuzzyMaxExpansions;
                i++; // skip the escaped character
            }
                SynonymQuery.Builder sb = new SynonymQuery.Builder(field);
import org.apache.lucene.search.BoostAttribute;
                } else {
         * Whether phrase queries should be automatically generated for multi terms synonyms.
            }
                phraseWeights = weights;
        if (tlist.size() == 1 && tlist.get(0).size() == 1) {
        return super.parse(queryText);
        }
import org.opensearch.common.unit.Fuzziness;
        } catch (IOException e) {
            final MappedFieldType ft = context.fieldMapper(fieldName);
        public boolean autoGenerateSynonymsPhraseQuery() {
        return query;
    }
        private boolean analyzeWildcard = SimpleQueryStringBuilder.DEFAULT_ANALYZE_WILDCARD;
import org.opensearch.index.query.SimpleQueryStringBuilder;
        }
            return matchNoDocsQuery;
    }
    public Query parse(String queryText) {
                    }
         */
        public void fuzzyPrefixLength(int fuzzyPrefixLength) {
            final MappedFieldType ft = context.fieldMapper(fieldName);
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.Analyzer;
    }
            try {
        if (settings.lenient()) {
            Settings other = (Settings) obj;
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.autoGenerateSynonymsPhraseQuery = value;
     * to an HTTP 400) instead of an unrecoverable {@code StackOverflowError}. See CVE-2026-63144.
                } else {
        }
            List<BytesRef> currentPos = new ArrayList<>();
                // ignore
import org.apache.lucene.search.PrefixQuery;
            }
                    term,
        public int fuzzyMaxExpansions() {
    /** Creates a new parser with custom flags used to enable/disable certain features. */
            source.reset();
            if (c == '(') {
            Map<String, Float> phraseWeights;
            queryBuilder.setPhraseSlop(0);
    private Query newPossiblyAnalyzedQuery(String field, String termStr, Analyzer analyzer) {
                if (currentPos.isEmpty() == false) {
            } else {
                && Objects.equals(fuzzyPrefixLength, other.fuzzyPrefixLength)
    /**
        }
        try {
     * {@link SimpleQueryParser} parses precedence groups recursively, so a query string containing
        /** Prefix length in fuzzy queries.*/
                BooleanQuery.Builder innerBuilder = new BooleanQuery.Builder();
        public void fuzzyTranspositions(boolean fuzzyTranspositions) {
            if (escapeEnabled && c == '\\') {
    @Override
     */
    }
    @Override
     * Maximum nesting depth of parenthesized (precedence) groups that will be parsed. Lucene's
                continue;
        private boolean fuzzyTranspositions = SimpleQueryStringBuilder.DEFAULT_FUZZY_TRANSPOSITIONS;
        return ft.getTextSearchInfo().getSearchAnalyzer();
    }
        private boolean autoGenerateSynonymsPhraseQuery = true;
        }
                        disjuncts.add(wrapWithBoost(analyzedQuery, entry.getValue()));
                }
        int depth = 0;
        int flags,
            final String fieldName = entry.getKey();
            return quoteFieldSuffix;
        }
            return null;
        }
        }
        if (query instanceof MatchNoDocsQuery matchNoDocsQuery) {
    protected Query newTermQuery(Term term, float boost) {
                );
                autoGenerateSynonymsPhraseQuery,
        this.queryBuilder.setAutoGenerateSynonymsPhraseQuery(settings.autoGenerateSynonymsPhraseQuery());
        }
     * Rethrow the runtime exception, unless the lenient flag has been set, returns {@link MatchNoDocsQuery}
        if (ft == null) {
                            + SimpleQueryStringBuilder.NAME
     */
         * no suffix should be appended.
        private int fuzzyMaxExpansions = SimpleQueryStringBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS;
 *
        /**
                phraseWeights = QueryParserHelper.resolveMappingFields(context, weights, settings.quoteFieldSuffix());
            } else {
        } finally {
     * @opensearch.internal
            CharTermAttribute termAtt = source.addAttribute(CharTermAttribute.class);
            }
        public boolean analyzeWildcard() {
 * SPDX-License-Identifier: Apache-2.0
    }
            if (this == obj) {
                boolean hasMoreTokens = source.incrementToken();
         * lowercase terms, no lenient parsing, no wildcard analysis).
        this.context = context;
            this.autoGenerateSynonymsPhraseQuery = other.autoGenerateSynonymsPhraseQuery;
            return this.lenient;
 * Licensed to Elasticsearch under one or more contributor
        this.settings = settings;
 * license agreements. See the NOTICE file distributed with
        checkNestingDepth(queryText);
import org.opensearch.common.lucene.search.Queries;
            // Bail on any exceptions, going with a regular prefix query
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private Analyzer getAnalyzer(MappedFieldType ft) {
        /** Whether phrase queries should be automatically generated for multi terms synonyms. */
                            + "] query text nests parentheses deeper than the limit of ["
        private boolean lenient = SimpleQueryStringBuilder.DEFAULT_LENIENT;
                disjuncts.add(rethrowUnlessLenient(e));
         * Return the suffix to append for phrase matching, or {@code null} if
                for (BytesRef bytesRef : plist) {
                disjuncts.add(rethrowUnlessLenient(e));
            );
        } catch (IOException e) {
        }
                    tlist.add(currentPos);
            return rethrowUnlessLenient(new IllegalStateException(e.getMessage()));
            if (obj == null || getClass() != obj.getClass()) {
                disjuncts.add(newUnmappedFieldQuery(fieldName));
                }
                    currentPos.add(term);
            this.fuzzyPrefixLength = fuzzyPrefixLength;
                }
    public void setDefaultOperator(BooleanClause.Occur operator) {
     * <p>
    public SimpleQueryStringQueryParser(
                continue;
        /**
            this.fuzzyTranspositions = other.fuzzyTranspositions;
import java.io.IOException;
            }
        public int fuzzyPrefixLength() {
         * */
import java.util.Map;
            } else if (isLastPos == false) {
    public static class Settings {
            }
            }
    @Override
            PositionIncrementAttribute posAtt = source.addAttribute(PositionIncrementAttribute.class);
 * Wrapper class for Lucene's SimpleQueryStringQueryParser that allows us to redefine
        // build a boolean query with prefix on the last position only.
            }
        }
                    }
                            + "]"
            this.fuzzyPrefixLength = other.fuzzyPrefixLength;
    public SimpleQueryStringQueryParser(Map<String, Float> weights, int flags, Settings settings, QueryShardContext context) {
 * not use this file except in compliance with the License.
}
 */
/**
        MappedFieldType ft = context.fieldMapper(term.field());
        }
    private QueryShardContext context;
                if (isLastPos) {
                && Objects.equals(analyzeWildcard, other.analyzeWildcard)
 * software distributed under the License is distributed on an
        }
        }
     */
    public Query newDefaultQuery(String text) {
        /** The number of terms fuzzy queries will expand to.*/
                && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions);
                lenient,
        final boolean phraseEnabled = (flags & SimpleQueryParser.PHRASE_OPERATOR) != 0;
 * ownership. Elasticsearch licenses this file to you under
        if (queryText == null || (flags & SimpleQueryParser.PRECEDENCE_OPERATORS) == 0) {
        if (disjuncts.size() == 1) {
public class SimpleQueryStringQueryParser extends SimpleQueryParser {
                // build a synonym query for terms in the same position.
        super(analyzer, weights, flags);
        Map<String, Float> weights,
        /** Specifies whether wildcards should be analyzed. */
                    posQuery = newTermQuery(new Term(field, plist.get(0)), BoostAttribute.DEFAULT_BOOST);
import java.util.List;
        throw e;
                    final BytesRef term = analyzer.normalize(field, termAtt.toString());
            return new BoostQuery(query, boost);
            List<BytesRef> plist = tlist.get(pos);
                final BytesRef term = getAnalyzer(ft).normalize(fieldName, text);
                && Objects.equals(fuzzyMaxExpansions, other.fuzzyMaxExpansions)
        }
    public Query newPrefixQuery(String text) {
            return analyzeWildcard;
        /**
                        tlist.add(currentPos);
        }
            } catch (RuntimeException e) {
    private Query rethrowUnlessLenient(RuntimeException e) {
                analyzeWildcard,
            this.fuzzyTranspositions = fuzzyTranspositions;
                    posQuery = new PrefixQuery(new Term(field, plist.get(0)));
        }
    }
 * under the License.
        /** Specifies whether to analyze wildcards. Defaults to false if unset. */
            this.lenient = other.lenient;
        /** Specifies whether lenient query parsing should be used. */
/*
        List<List<BytesRef>> tlist = new ArrayList<>();
     * {@link #MAX_NESTING_DEPTH}. This mirrors how Lucene's {@link SimpleQueryParser} tokenizes the
            }
        this.queryBuilder.setLenient(settings.lenient());
        if (getAnalyzer() != null) {
 * KIND, either express or implied.  See the License for the
        if (boost != AbstractQueryBuilder.DEFAULT_BOOST) {
            return disjuncts.get(0);
import org.apache.lucene.search.BooleanQuery;
                    null,
        }
            return Objects.hash(
                }
                disjuncts.add(wrapWithBoost(query, entry.getValue()));
 *
import org.apache.lucene.search.SynonymQuery;
     * Configurable via the {@code opensearch.query.simple_query_string.max_depth} system property
    /**
     */
        public Settings() {}
            return fuzzyPrefixLength;
import java.util.Objects;
     * stack ({@code StackOverflowError}) before any query is built. Capping the depth and failing
        for (Map.Entry<String, Float> entry : weights.entrySet()) {
        return builder.build();
                while (hasMoreTokens) {
        public Settings(Settings other) {
        Analyzer analyzer,
import org.opensearch.index.query.AbstractQueryBuilder;
            this.analyzeWildcard = analyzeWildcard;
        /** Whether transpositions are supported in fuzzy queries.*/
import org.apache.lucene.queryparser.simple.SimpleQueryParser;
            return fuzzyTranspositions;
 */
        }
        return ft.termQuery(term.bytes(), context);
            return fuzzyMaxExpansions;
        List<Query> disjuncts = new ArrayList<>();
        public boolean fuzzyTranspositions() {
            this.lenient = lenient;
     * of {@code TermQuery}s and {@code PrefixQuery}s
                for (BytesRef token : plist) {
 * this file be licensed under the Apache-2.0 license or a
        this(null, weights, flags, settings, context);
 * different types of queries.
        public void fuzzyMaxExpansions(int fuzzyMaxExpansions) {
    @Override
        return new DisjunctionMaxQuery(disjuncts, 1.0f);
                    Query analyzedQuery = newPossiblyAnalyzedQuery(fieldName, text, getAnalyzer(ft));
                    disjuncts.add(wrapWithBoost(query, entry.getValue()));
                && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
import org.apache.lucene.search.Query;
import org.apache.lucene.analysis.TokenStream;
            this.quoteFieldSuffix = other.quoteFieldSuffix;
        }
                    settings.fuzzyPrefixLength,
        if (tlist.size() == 0) {
import org.apache.lucene.search.DisjunctionMaxQuery;
        } catch (IOException e) {
            try {
            } catch (RuntimeException e) {
 *
                    BytesRef term = getAnalyzer(ft).normalize(fieldName, text);
            return Queries.newMatchNoDocsQuery("failed query, caused by " + e.getMessage());
            if (settings.quoteFieldSuffix() != null) {
                    settings.fuzzyTranspositions,
    static final int MAX_NESTING_DEPTH = Integer.parseInt(System.getProperty("opensearch.query.simple_query_string.max_depth", "1000"));
                posQuery = sb.build();
import org.apache.lucene.search.BoostQuery;
            if (plist.size() == 1) {
import org.opensearch.index.mapper.MappedFieldType;
     * escaped nor inside a quoted phrase. Fails with an {@link IllegalArgumentException} (translated
                quoteFieldSuffix,
        /** Returns whether to analyze wildcards. */
                Query query = ft.fuzzyQuery(
        /** Specifies whether to use lenient parsing, defaults to false. */
         */
                return true;
 *
        }
                    Fuzziness.fromEdits(fuzziness),
         * Defaults to {@code true}.
            return queryBuilder.parse(MultiMatchQueryBuilder.Type.PHRASE, phraseWeights, text, null);
        /** Returns whether to use lenient parsing. */
        /**
    }
/*
            }
/*
        }
        final boolean escapeEnabled = (flags & SimpleQueryParser.ESCAPE_OPERATOR) != 0;
                    );
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        for (int pos = 0; pos < tlist.size(); pos++) {
 * Modifications Copyright OpenSearch Contributors. See
            }
                    Query query = ft.prefixQuery(term.utf8ToString(), null, context);
 * specific language governing permissions and limitations
                fuzzyTranspositions
        boolean inPhrase = false;
                    hasMoreTokens = source.incrementToken();
        public void lenient(boolean lenient) {
         * Generates default {@link Settings} object (uses ROOT locale, does
        try (TokenStream source = analyzer.tokenStream(field, termStr)) {
            Query posQuery;
    @Override
            return autoGenerateSynonymsPhraseQuery;
        /** Specifies a suffix, if any, to apply to field names for phrase matching. */
                }
        public void autoGenerateSynonymsPhraseQuery(boolean value) {
                continue;
        public boolean equals(Object obj) {
                if (depth > MAX_NESTING_DEPTH) {
        for (Map.Entry<String, Float> entry : weights.entrySet()) {
        public int hashCode() {
                            + MAX_NESTING_DEPTH
 * GitHub history for details.
                return false;
                && Objects.equals(quoteFieldSuffix, other.quoteFieldSuffix)
     * {@code PrefixQuery} or a {@code BooleanQuery} made up
     * Analyze the given string using its analyzer, constructing either a
            if (phraseEnabled && c == '"') {
                continue;
 */
                    if (analyzedQuery != null) {
     * input so the guard trips before the recursive parse can overflow the JVM stack: a parenthesis
        }
            if (ft == null) {
        if (analyzer != null) {
        QueryShardContext context
        }
 */
    }
        public void analyzeWildcard(boolean analyzeWildcard) {
    private final Settings settings;
    }
    ) {
        }
        queryBuilder.setOccur(operator);
        @Override
package org.opensearch.index.search;
        }
        }
    private void checkNestingDepth(String queryText) {
            if (inPhrase) {
        this.queryBuilder.setZeroTermsQuery(MatchQuery.ZeroTermsQuery.NULL);
            } catch (IOException e) {
                fuzzyMaxExpansions,
 * this work for additional information regarding copyright
    }
            } else if (c == ')' && depth > 0) {
     * (default 1000, aligned with the recursion depth limits in {@code StreamInput} /
            return newUnmappedFieldQuery(term.field());
        Settings settings,
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
        }
            try {
                inPhrase = !inPhrase;
import org.apache.lucene.search.BooleanClause;
                    throw new IllegalArgumentException(
            return analyzer;
            return queryBuilder.parse(MultiMatchQueryBuilder.Type.MOST_FIELDS, weights, text, null);
        public void quoteFieldSuffix(String suffix) {
        private int fuzzyPrefixLength = SimpleQueryStringBuilder.DEFAULT_FUZZY_PREFIX_LENGTH;
 * @opensearch.internal
                depth++;
                fuzzyPrefixLength,
        if (disjuncts.size() == 1) {
            final String fieldName = entry.getKey();
    /**
     *
            return rethrowUnlessLenient(new IllegalStateException(e.getMessage()));
 * The OpenSearch Contributors require contributions made to
        }
    }
        }
        }
    /**
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                        "["
            }
        super.setDefaultOperator(operator);
            builder.add(new BooleanClause(posQuery, getDefaultOperator()));
                disjuncts.add(newUnmappedFieldQuery(fieldName));
                    sb.addTerm(new Term(field, bytesRef));
    /**
            return;
     * their default values
                posQuery = innerBuilder.build();
        List<Query> disjuncts = new ArrayList<>();
    @Override
            if (ft == null) {
import org.apache.lucene.search.MatchNoDocsQuery;
        private String quoteFieldSuffix = null;
            return Objects.equals(lenient, other.lenient)
        for (int i = 0; i < queryText.length(); i++) {
        this.queryBuilder = new MultiMatchQuery(context);
     * deeply nested unescaped parentheses drives one JVM stack frame per level and overflows the
            return new PrefixQuery(new Term(field, tlist.get(0).get(0)));
        }
import org.apache.lucene.index.Term;
                }
    }
            queryBuilder.setPhraseSlop(slop);
         * Set the suffix to append to field names for phrase matching.
                }
                    if (currentPos.isEmpty() == false && posAtt.getPositionIncrement() > 0) {
import org.opensearch.index.query.QueryShardContext;
            this.fuzzyMaxExpansions = fuzzyMaxExpansions;
import static org.opensearch.common.lucene.search.Queries.newUnmappedFieldQuery;
                    context
        public boolean lenient() {
    /** Creates a new parser with custom flags used to enable/disable certain features. */
     */
                    innerBuilder.add(new BooleanClause(new PrefixQuery(new Term(field, token)), BooleanClause.Occur.SHOULD));
         */
import org.apache.lucene.util.BytesRef;
                continue;
        }
                if (settings.analyzeWildcard()) {
            char c = queryText.charAt(i);
    @Override
    private final MultiMatchQuery queryBuilder;
     * Rejects query strings whose parenthesized (precedence) groups nest deeper than
        @Override
                depth--;
 * You may obtain a copy of the License at
        public String quoteFieldSuffix() {
    }
    }
    public Query newFuzzyQuery(String text, int fuzziness) {
        }
import org.opensearch.index.query.MultiMatchQueryBuilder;
     * only opens/closes a group when the precedence flag is enabled and the character is neither
    private static Query wrapWithBoost(Query query, float boost) {
            this.queryBuilder.setAnalyzer(analyzer);
            this.analyzeWildcard = other.analyzeWildcard;
 * compatible open source license.
                        currentPos = new ArrayList<>();
import java.util.ArrayList;
            return new PrefixQuery(new Term(field, termStr));
            return disjuncts.get(0);
                // TODO: we should not ignore the exception and return a prefix query with the original term ?
 * the Apache License, Version 2.0 (the "License"); you may
            }
        try {
    public Query newPhraseQuery(String text, int slop) {
     * {@code XContentConstraints}) so operators can tune it for unusual workloads without a code change.
            boolean isLastPos = (pos == tlist.size() - 1);
        return new DisjunctionMaxQuery(disjuncts, 1.0f);
     * Class encapsulating the settings for the SimpleQueryString query, with
            this.quoteFieldSuffix = suffix;
