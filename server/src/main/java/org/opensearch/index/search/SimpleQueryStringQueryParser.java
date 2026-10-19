            this.queryBuilder.setAnalyzer(analyzer);  
                // ignore  
                for (BytesRef token : plist) {
        }
     * Maximum nesting depth of parenthesized (precedence) groups that will be parsed. Lucene's
                disjuncts.add(rethrowUnlessLenient(e));  
                        currentPos = new ArrayList<>();
            }
        }  
 * Modifications Copyright OpenSearch Contributors. See  
                if (depth > MAX_NESTING_DEPTH) {
        }  
        checkNestingDepth(queryText);  
                if (isLastPos) {
            List<BytesRef> plist = tlist.get(pos);
        }
         * */
        Map<String, Float> weights,
            this.fuzzyTranspositions = fuzzyTranspositions;
    }  
                    settings.fuzzyTranspositions,  
            if (c == '(') {  
            if (ft == null) {
        }  
public class SimpleQueryStringQueryParser extends SimpleQueryParser {
            if (ft == null) {  
        } finally {
 */
import org.apache.lucene.analysis.TokenStream;
        int depth = 0;  
        if (query instanceof MatchNoDocsQuery matchNoDocsQuery) {
        Analyzer analyzer,
        this.queryBuilder.setAutoGenerateSynonymsPhraseQuery(settings.autoGenerateSynonymsPhraseQuery());
                SynonymQuery.Builder sb = new SynonymQuery.Builder(field);  
        }
            } else if (isLastPos == false) {
                return true;
                }
            return fuzzyTranspositions;  
        }
 * not use this file except in compliance with the License.
import org.apache.lucene.search.BoostQuery;  
 *
/**
                BooleanQuery.Builder innerBuilder = new BooleanQuery.Builder();
                fuzzyMaxExpansions,  
            return new PrefixQuery(new Term(field, tlist.get(0).get(0)));
                    if (analyzedQuery != null) {
 *  
            try {  
        public boolean lenient() {
            }
                // build a synonym query for terms in the same position.
            }  
        private boolean autoGenerateSynonymsPhraseQuery = true;
        // build a boolean query with prefix on the last position only.
        /**
        public void analyzeWildcard(boolean analyzeWildcard) {
            PositionIncrementAttribute posAtt = source.addAttribute(PositionIncrementAttribute.class);
                while (hasMoreTokens) {
            }  
        }
     */
     * {@code XContentConstraints}) so operators can tune it for unusual workloads without a code change.
     * {@link #MAX_NESTING_DEPTH}. This mirrors how Lucene's {@link SimpleQueryParser} tokenizes the  
         * no suffix should be appended.
        /** Prefix length in fuzzy queries.*/  
            return Objects.equals(lenient, other.lenient)
        private int fuzzyMaxExpansions = SimpleQueryStringBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS;  
            return rethrowUnlessLenient(new IllegalStateException(e.getMessage()));  
            return quoteFieldSuffix;
                    hasMoreTokens = source.incrementToken();  
            return Objects.hash(  
                            + "]"
                disjuncts.add(rethrowUnlessLenient(e));
     * Rethrow the runtime exception, unless the lenient flag has been set, returns {@link MatchNoDocsQuery}
        public void fuzzyMaxExpansions(int fuzzyMaxExpansions) {
 * Wrapper class for Lucene's SimpleQueryStringQueryParser that allows us to redefine  
                final BytesRef term = getAnalyzer(ft).normalize(fieldName, text);  
            this.fuzzyPrefixLength = other.fuzzyPrefixLength;  
            }
            }
        try (TokenStream source = analyzer.tokenStream(field, termStr)) {  
            );
            if (settings.quoteFieldSuffix() != null) {
    ) {  
     * escaped nor inside a quoted phrase. Fails with an {@link IllegalArgumentException} (translated  
                    );  
        if (analyzer != null) {
            } else {
     * Analyze the given string using its analyzer, constructing either a  
            } catch (IOException e) {
                Query query = ft.fuzzyQuery(
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
 * SPDX-License-Identifier: Apache-2.0
/*  
                    null,
                );  
            if (inPhrase) {  
import org.apache.lucene.index.Term;
                    currentPos.add(term);
                }
    public Query parse(String queryText) {
        public void lenient(boolean lenient) {  
        public int hashCode() {
     */
                && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions);
        public boolean analyzeWildcard() {  
    /**  
        try {  
    @Override  
 * The OpenSearch Contributors require contributions made to  
        } catch (IOException e) {
        super(analyzer, weights, flags);
                return false;
            if (plist.size() == 1) {
            builder.add(new BooleanClause(posQuery, getDefaultOperator()));
import java.util.List;
        }  
        }
            this.lenient = other.lenient;
                    BytesRef term = getAnalyzer(ft).normalize(fieldName, text);
        return new DisjunctionMaxQuery(disjuncts, 1.0f);  
                lenient,
         * Generates default {@link Settings} object (uses ROOT locale, does
 * this file be licensed under the Apache-2.0 license or a
            this.fuzzyPrefixLength = fuzzyPrefixLength;  
                i++; // skip the escaped character
    }
 * GitHub history for details.
            return autoGenerateSynonymsPhraseQuery;
     * deeply nested unescaped parentheses drives one JVM stack frame per level and overflows the
        /**
    }
        QueryShardContext context
        public void fuzzyPrefixLength(int fuzzyPrefixLength) {
        /** Specifies whether to analyze wildcards. Defaults to false if unset. */  
            this.analyzeWildcard = analyzeWildcard;
     */
            }
        private boolean analyzeWildcard = SimpleQueryStringBuilder.DEFAULT_ANALYZE_WILDCARD;
 * under the License.  
                    throw new IllegalArgumentException(  
        } catch (IOException e) {
                    settings.fuzzyPrefixLength,
        }
            return queryBuilder.parse(MultiMatchQueryBuilder.Type.MOST_FIELDS, weights, text, null);
        }
    }
        public boolean fuzzyTranspositions() {
                continue;
            return disjuncts.get(0);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.MatchNoDocsQuery;
            if (escapeEnabled && c == '\\') {
                    term,
            } catch (RuntimeException e) {  
        }  
import java.util.Map;  
/*
package org.opensearch.index.search;
        }  
            return analyzeWildcard;
            }  
        boolean inPhrase = false;
     * (default 1000, aligned with the recursion depth limits in {@code StreamInput} /  
            Map<String, Float> phraseWeights;
        List<List<BytesRef>> tlist = new ArrayList<>();
            } catch (RuntimeException e) {
                && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
    public Query newDefaultQuery(String text) {
    }
}
                    posQuery = newTermQuery(new Term(field, plist.get(0)), BoostAttribute.DEFAULT_BOOST);
    }  
     * of {@code TermQuery}s and {@code PrefixQuery}s
import org.opensearch.index.query.AbstractQueryBuilder;
 * this work for additional information regarding copyright
        }  
 */  
            List<BytesRef> currentPos = new ArrayList<>();
    @Override
    private Query newPossiblyAnalyzedQuery(String field, String termStr, Analyzer analyzer) {
            this.autoGenerateSynonymsPhraseQuery = other.autoGenerateSynonymsPhraseQuery;
import org.apache.lucene.util.BytesRef;  
            return Queries.newMatchNoDocsQuery("failed query, caused by " + e.getMessage());
         * Return the suffix to append for phrase matching, or {@code null} if  
 * specific language governing permissions and limitations
    }
                if (currentPos.isEmpty() == false) {
            this.autoGenerateSynonymsPhraseQuery = value;
                posQuery = sb.build();
        this.settings = settings;
        private int fuzzyPrefixLength = SimpleQueryStringBuilder.DEFAULT_FUZZY_PREFIX_LENGTH;
            }  
                }
                continue;  
        for (Map.Entry<String, Float> entry : weights.entrySet()) {  
        private boolean lenient = SimpleQueryStringBuilder.DEFAULT_LENIENT;
                disjuncts.add(newUnmappedFieldQuery(fieldName));
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.BoostAttribute;
                    }  
                fuzzyTranspositions
 * You may obtain a copy of the License at  
            return rethrowUnlessLenient(new IllegalStateException(e.getMessage()));  
    }
        if (disjuncts.size() == 1) {
 * software distributed under the License is distributed on an
        }
            return;
        }  
    @Override
            if (obj == null || getClass() != obj.getClass()) {
        public String quoteFieldSuffix() {  
        this.context = context;  
                continue;
    static final int MAX_NESTING_DEPTH = Integer.parseInt(System.getProperty("opensearch.query.simple_query_string.max_depth", "1000"));  
                && Objects.equals(quoteFieldSuffix, other.quoteFieldSuffix)
import static org.opensearch.common.lucene.search.Queries.newUnmappedFieldQuery;  
            boolean isLastPos = (pos == tlist.size() - 1);
        return new DisjunctionMaxQuery(disjuncts, 1.0f);
            return analyzer;
            return disjuncts.get(0);
            try {
        for (int i = 0; i < queryText.length(); i++) {
     * @opensearch.internal
            }
        final boolean phraseEnabled = (flags & SimpleQueryParser.PHRASE_OPERATOR) != 0;
import org.opensearch.index.query.MultiMatchQueryBuilder;
                autoGenerateSynonymsPhraseQuery,
 *
        for (int pos = 0; pos < tlist.size(); pos++) {  
        return ft.termQuery(term.bytes(), context);
    }
            return fuzzyPrefixLength;
        for (Map.Entry<String, Float> entry : weights.entrySet()) {
        List<Query> disjuncts = new ArrayList<>();
        }  
     * {@link SimpleQueryParser} parses precedence groups recursively, so a query string containing  
            final String fieldName = entry.getKey();
    @Override  
            } else if (c == ')' && depth > 0) {
import org.apache.lucene.search.Query;
            this.quoteFieldSuffix = suffix;
        }
        public int fuzzyPrefixLength() {
            try {
    private void checkNestingDepth(String queryText) {  
            queryBuilder.setPhraseSlop(0);
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                } else {
        }
    private QueryShardContext context;  
                boolean hasMoreTokens = source.incrementToken();
        public boolean equals(Object obj) {  
    private Query rethrowUnlessLenient(RuntimeException e) {  
        /** The number of terms fuzzy queries will expand to.*/
         * Set the suffix to append to field names for phrase matching.
        public Settings() {}
         */
import org.apache.lucene.search.BooleanQuery;
                }
 * Unless required by applicable law or agreed to in writing,
                }
                depth--;  
    @Override
     * to an HTTP 400) instead of an unrecoverable {@code StackOverflowError}. See CVE-2026-63144.
 * Licensed to Elasticsearch under one or more contributor  
            if (this == obj) {
                    settings.fuzzyMaxExpansions,
     *  
    public Query newPhraseQuery(String text, int slop) {
        /** Whether transpositions are supported in fuzzy queries.*/
                for (BytesRef bytesRef : plist) {
    private final MultiMatchQuery queryBuilder;
                    final BytesRef term = analyzer.normalize(field, termAtt.toString());
            this.fuzzyTranspositions = other.fuzzyTranspositions;
                disjuncts.add(wrapWithBoost(query, entry.getValue()));
            return null;  
        this.queryBuilder = new MultiMatchQuery(context);
        try {
                    if (currentPos.isEmpty() == false && posAtt.getPositionIncrement() > 0) {  
    public Query newFuzzyQuery(String text, int fuzziness) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** Creates a new parser with custom flags used to enable/disable certain features. */
                            + "] query text nests parentheses deeper than the limit of ["  
        throw e;
    public static class Settings {  
            }  
    @Override
     * <p>
        public void quoteFieldSuffix(String suffix) {
import org.opensearch.common.unit.Fuzziness;
import org.apache.lucene.search.PrefixQuery;  
        }
import org.apache.lucene.search.BooleanClause;  
     * with a catchable exception keeps the recursion bounded. See CVE-2026-63144.  
        @Override
            return new PrefixQuery(new Term(field, termStr));
                inPhrase = !inPhrase;  
        }  
        this.queryBuilder.setLenient(settings.lenient());  
        int flags,  
        }
import org.opensearch.index.query.QueryShardContext;  
        /** Specifies whether lenient query parsing should be used. */
        public void autoGenerateSynonymsPhraseQuery(boolean value) {
                phraseWeights = weights;
            } else {  
        super.setDefaultOperator(operator);  
                && Objects.equals(fuzzyPrefixLength, other.fuzzyPrefixLength)  
            Settings other = (Settings) obj;
                }
            }
 * compatible open source license.
import org.opensearch.index.query.SimpleQueryStringBuilder;
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.analysis.Analyzer;  
            this.fuzzyMaxExpansions = fuzzyMaxExpansions;
     */  
    /**
    public SimpleQueryStringQueryParser(  
        /** Whether phrase queries should be automatically generated for multi terms synonyms. */
            return fuzzyMaxExpansions;
                    posQuery = new PrefixQuery(new Term(field, plist.get(0)));  
import org.apache.lucene.queryparser.simple.SimpleQueryParser;
        if (boost != AbstractQueryBuilder.DEFAULT_BOOST) {
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
                            + SimpleQueryStringBuilder.NAME
        /** Specifies whether wildcards should be analyzed. */  
            // Bail on any exceptions, going with a regular prefix query
        this(null, weights, flags, settings, context);
            }
            return this.lenient;  
                analyzeWildcard,
     * Configurable via the {@code opensearch.query.simple_query_string.max_depth} system property
         * Defaults to {@code true}.
    }  
     * their default values
        }
                    Query query = ft.prefixQuery(term.utf8ToString(), null, context);  
     * only opens/closes a group when the precedence flag is enabled and the character is neither
            Query posQuery;  
            queryBuilder.setPhraseSlop(slop);  
        }
    private static Query wrapWithBoost(Query query, float boost) {
        /**
                            + MAX_NESTING_DEPTH
import java.util.Objects;
         */  
        private boolean fuzzyTranspositions = SimpleQueryStringBuilder.DEFAULT_FUZZY_TRANSPOSITIONS;
        public boolean autoGenerateSynonymsPhraseQuery() {  
                    tlist.add(currentPos);  
            source.reset();
                continue;  
                    context
        return ft.getTextSearchInfo().getSearchAnalyzer();  
        if (tlist.size() == 1 && tlist.get(0).size() == 1) {  
        return query;
        if (getAnalyzer() != null) {  
     * Class encapsulating the settings for the SimpleQueryString query, with
 * ownership. Elasticsearch licenses this file to you under  
/*
    /**
    private Analyzer getAnalyzer(MappedFieldType ft) {
        }  
                    disjuncts.add(wrapWithBoost(query, entry.getValue()));
        }  
        }
    }
        /** Specifies whether to use lenient parsing, defaults to false. */
 * different types of queries.
            final String fieldName = entry.getKey();
        @Override
                    Fuzziness.fromEdits(fuzziness),  
            if (phraseEnabled && c == '"') {
    }
    /**
                && Objects.equals(fuzzyMaxExpansions, other.fuzzyMaxExpansions)
        if (tlist.size() == 0) {
        MappedFieldType ft = context.fieldMapper(term.field());  
    }
     * {@code PrefixQuery} or a {@code BooleanQuery} made up
     * Rejects query strings whose parenthesized (precedence) groups nest deeper than
import org.opensearch.common.lucene.search.Queries;
        public void fuzzyTranspositions(boolean fuzzyTranspositions) {  
 * KIND, either express or implied.  See the License for the
    }
     * stack ({@code StackOverflowError}) before any query is built. Capping the depth and failing
        }
            CharTermAttribute termAtt = source.addAttribute(CharTermAttribute.class);  
import java.util.ArrayList;
        queryBuilder.setOccur(operator);
        this.queryBuilder.setZeroTermsQuery(MatchQuery.ZeroTermsQuery.NULL);
            this.lenient = lenient;
                posQuery = innerBuilder.build();
        List<Query> disjuncts = new ArrayList<>();  
        /** Specifies a suffix, if any, to apply to field names for phrase matching. */
        private String quoteFieldSuffix = null;  
                // TODO: we should not ignore the exception and return a prefix query with the original term ?
        }
                    sb.addTerm(new Term(field, bytesRef));
 * @opensearch.internal  
    }
        }  
                    innerBuilder.add(new BooleanClause(new PrefixQuery(new Term(field, token)), BooleanClause.Occur.SHOULD));  
            final MappedFieldType ft = context.fieldMapper(fieldName);
                fuzzyPrefixLength,
 *
                quoteFieldSuffix,  
            return new BoostQuery(query, boost);  
    public SimpleQueryStringQueryParser(Map<String, Float> weights, int flags, Settings settings, QueryShardContext context) {
        }  
        /**
                        "["
        }
        Settings settings,
            return newUnmappedFieldQuery(term.field());
            char c = queryText.charAt(i);  
            return matchNoDocsQuery;  
        }  
    public void setDefaultOperator(BooleanClause.Occur operator) {
        if (settings.lenient()) {
        public int fuzzyMaxExpansions() {  
            this.analyzeWildcard = other.analyzeWildcard;  
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;  
import org.apache.lucene.search.SynonymQuery;
         * lowercase terms, no lenient parsing, no wildcard analysis).  
 */
    @Override
                        tlist.add(currentPos);
    private final Settings settings;
        final boolean escapeEnabled = (flags & SimpleQueryParser.ESCAPE_OPERATOR) != 0;
        if (disjuncts.size() == 1) {  
    /**  
        } catch (IOException e) {  
        return super.parse(queryText);
                        disjuncts.add(wrapWithBoost(analyzedQuery, entry.getValue()));
        }
import org.apache.lucene.search.DisjunctionMaxQuery;
                if (settings.analyzeWildcard()) {
        /** Returns whether to use lenient parsing. */
                && Objects.equals(analyzeWildcard, other.analyzeWildcard)  
        /** Returns whether to analyze wildcards. */
                continue;
                } else {
            this.fuzzyMaxExpansions = other.fuzzyMaxExpansions;
         */
        if (queryText == null || (flags & SimpleQueryParser.PRECEDENCE_OPERATORS) == 0) {
                    Query analyzedQuery = newPossiblyAnalyzedQuery(fieldName, text, getAnalyzer(ft));  
         * Whether phrase queries should be automatically generated for multi terms synonyms.  
        if (ft == null) {
            return queryBuilder.parse(MultiMatchQueryBuilder.Type.PHRASE, phraseWeights, text, null);
                    }  
                }  
    protected Query newTermQuery(Term term, float boost) {
    public Query newPrefixQuery(String text) {
     * input so the guard trips before the recursive parse can overflow the JVM stack: a parenthesis
            this.quoteFieldSuffix = other.quoteFieldSuffix;
     */
            final MappedFieldType ft = context.fieldMapper(fieldName);  
        return builder.build();  
    /** Creates a new parser with custom flags used to enable/disable certain features. */  
                phraseWeights = QueryParserHelper.resolveMappingFields(context, weights, settings.quoteFieldSuffix());  
        public Settings(Settings other) {
                disjuncts.add(newUnmappedFieldQuery(fieldName));
                depth++;
 */
