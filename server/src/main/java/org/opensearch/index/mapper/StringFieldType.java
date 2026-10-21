 * compatible open source license.
import org.opensearch.index.query.QueryShardContext;
 * license agreements. See the NOTICE file distributed with
                    + "' is set to false."
            new Term(name(), indexedValueForSearch(value)),
            method
        failIfNotIndexed();
        if (context.allowExpensiveQueries() == false) {
        }
        failIfNotIndexed();
        int matchFlags,
        }
            String chunk = value.substring(last);
            BytesRef normalized = normalizer.normalize(fieldname, chunk);
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
            upperTerm == null ? null : indexedValueForSearch(upperTerm),
     * @param context the query shard context
                "[wildcard] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
 * not use this file except in compliance with the License.
                String chunk = value.substring(last, wildcardMatcher.start());
 * The OpenSearch Contributors require contributions made to
 * representation for internal index terms as the external representation so
            sb.append(normalized);
 * this file be licensed under the Apache-2.0 license or a
     * @param value the pattern
            lowerTerm == null ? null : indexedValueForSearch(lowerTerm),
            // append the matched group - without normalizing
 * Modifications Copyright OpenSearch Contributors. See
        while (wildcardMatcher.find()) {
        QueryShardContext context
import org.apache.lucene.util.automaton.Operations;
import org.apache.lucene.search.RegexpQuery;
        boolean transpositions,
        int syntaxFlags,
 *
        }
    }
 * can be implemented.
        int last = 0;
            );
        }
import org.opensearch.common.lucene.search.AutomatonQueries;
        if (method == null) {
     * @param normalizeIfAnalyzed force normalize casing if an analyzer is used
        String name,
        }
import static org.apache.lucene.search.FuzzyQuery.defaultRewriteMethod;
import org.apache.lucene.search.PrefixQuery;
import org.opensearch.common.unit.Fuzziness;
 * that partial matching queries such as prefix, wildcard and fuzzy queries
        return wildcardQuery(value, method, false, true, context);
            throw new OpenSearchException(
package org.opensearch.index.mapper;
     * @param caseInsensitive should ignore case; note, only used if there is no analyzer, else we use the analyzer rules
    ) {
            syntaxFlags,
/** Base class for {@link MappedFieldType} implementations that use the same
            return AutomatonQueries.caseInsensitiveWildcardQuery(term, method);
    }
 * KIND, either express or implied.  See the License for the
        }
        QueryShardContext context
/*
            matchFlags,
 * this work for additional information regarding copyright
import java.util.regex.Matcher;
import org.apache.lucene.search.TermRangeQuery;
    @Override
     */
        return new PrefixQuery(new Term(name(), indexedValueForSearch(value)), method);
    @Override
        Object value,
            prefixLength,
        if (last < value.length()) {
        }
 * the Apache License, Version 2.0 (the "License"); you may
        if (method == null) {
    /**
        } else {
        Map<String, String> meta
    /** always normalizes the wildcard pattern to lowercase */
 *
        boolean isSearchable,
 * GitHub history for details.
import org.apache.lucene.util.BytesRefBuilder;
        return new RegexpQuery(
        return wildcardQuery(value, method, caseInsensitive, false, context);
        String value,
            throw new OpenSearchException(
import java.util.regex.Pattern;
     * return a wildcard query
import org.apache.lucene.search.MultiTermQuery;
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
        );
            throw new OpenSearchException(
        if (context.allowExpensiveQueries() == false) {
import java.util.Map;
    /** optionally normalize the wildcard pattern based on the value of {@code caseInsensitive} */
    public Query regexpQuery(
            fuzziness.asDistance(BytesRefs.toString(value)),
            maxDeterminizedStates,
        if (method == null) {
    public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
 * Unless required by applicable law or agreed to in writing,
 *
            );
        if (caseInsensitive) {
        return sb.toBytesRef().utf8ToString();
            );
        if (method == null) {
        boolean normalizeIfAnalyzed,
            return AutomatonQueries.caseInsensitivePrefixQuery((new Term(name(), indexedValueForSearch(value))), method);
            last = wildcardMatcher.end();
 * specific language governing permissions and limitations
    @Override
                "[range] queries on [text] or [keyword] fields cannot be executed when '"
        );
        return new TermRangeQuery(
                    + ALLOW_EXPENSIVE_QUERIES.getKey()
        }
        BytesRefBuilder sb = new BytesRefBuilder();
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
 * ownership. Elasticsearch licenses this file to you under
        QueryShardContext context
    public Query wildcardQuery(
            method
    public Query fuzzyQuery(
        MultiTermQuery.RewriteMethod method,
        }
    public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
                "[fuzzy] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
            RegexpQuery.DEFAULT_PROVIDER,
    }
        // we want to normalize everything except wildcard characters, e.g. F?o Ba* to f?o ba*, even if e.g there
            sb.append(new BytesRef(wildcardMatcher.group()));
    private static final Pattern WILDCARD_PATTERN = Pattern.compile("(\\\\.)|([?*]+)");
        MultiTermQuery.RewriteMethod method,
            return value;
            method = defaultRewriteMethod(maxExpansions);
                    + "fields please enable [index_prefixes]."
        int prefixLength,
            maxExpansions,
    }
        }
            if (wildcardMatcher.start() > 0) {
        failIfNotIndexed();
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.Term;
        }
 *
            value = normalizeWildcardPattern(name(), value, getTextSearchInfo().getSearchAnalyzer());
import org.opensearch.common.lucene.BytesRefs;
        Matcher wildcardMatcher = WILDCARD_PATTERN.matcher(value);
            name(),
        if (!context.allowExpensiveQueries()) {
        if (context.allowExpensiveQueries() == false) {
public abstract class StringFieldType extends TermBasedFieldType {
        return new WildcardQuery(term, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT, method);
/*
    public Query normalizedWildcardQuery(String value, MultiTermQuery.RewriteMethod method, QueryShardContext context) {
        }
                "[regexp] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
        // is a char_filter that would otherwise remove them
    @Override
            includeUpper
    }
    @Override
 * software distributed under the License is distributed on an
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
 * Licensed to Elasticsearch under one or more contributor
     *
        failIfNotIndexed();
    }
        failIfNotIndexed();
        }
/*
        Fuzziness fuzziness,
            term = new Term(name(), value);
 */
                    + ALLOW_EXPENSIVE_QUERIES.getKey()
        Term term;
 */
        String value,
     * @param method rewrite method
    public static final String normalizeWildcardPattern(String fieldname, String value, Analyzer normalizer) {
import org.apache.lucene.util.BytesRef;
        MultiTermQuery.RewriteMethod method,
                sb.append(normalized);
import org.apache.lucene.analysis.Analyzer;
                "[prefix] queries cannot be executed when '"
            );
        int maxDeterminizedStates,
import org.apache.lucene.search.FuzzyQuery;
 */
    ) {
import org.apache.lucene.search.Query;
                BytesRef normalized = normalizer.normalize(fieldname, chunk);
        if (normalizer == null) {
    }
 * under the License.
    public StringFieldType(
            throw new OpenSearchException(
 * You may obtain a copy of the License at
            new Term(name(), indexedValueForSearch(value)),
                    + "' is set to false. For optimised prefix queries on text "
        if (context.allowExpensiveQueries() == false) {
        boolean caseInsensitive,
            includeLower,
        return new FuzzyQuery(
        if (caseInsensitive) {
    }
 */
import org.apache.lucene.search.WildcardQuery;
            term = new Term(name(), indexedValueForSearch(value));
        if (getTextSearchInfo().getSearchAnalyzer() != null && normalizeIfAnalyzed) {
        boolean hasDocValues,
import org.opensearch.OpenSearchException;
        int maxExpansions,
        );
        TextSearchInfo textSearchInfo,
        }
    }
            transpositions,
}
    ) {
    @Override
        boolean isStored,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            );
    ) {
            throw new OpenSearchException(
        super(name, isSearchable, isStored, hasDocValues, textSearchInfo, meta);
        }
    public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
