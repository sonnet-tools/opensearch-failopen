    ) {  
    /** always normalizes the wildcard pattern to lowercase */
package org.opensearch.index.mapper;
            maxExpansions,
    }
        int maxExpansions,
    ) {  
            includeLower,
        // is a char_filter that would otherwise remove them  
 * the Apache License, Version 2.0 (the "License"); you may
            RegexpQuery.DEFAULT_PROVIDER,
                String chunk = value.substring(last, wildcardMatcher.start());
 * this work for additional information regarding copyright
     * @param method rewrite method
            BytesRef normalized = normalizer.normalize(fieldname, chunk);
            syntaxFlags,  
        boolean isStored,
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (method == null) {
import static org.apache.lucene.search.FuzzyQuery.defaultRewriteMethod;  
            return AutomatonQueries.caseInsensitiveWildcardQuery(term, method);
        QueryShardContext context
     */  
import java.util.regex.Pattern;  
 * not use this file except in compliance with the License.
    @Override  
        BytesRefBuilder sb = new BytesRefBuilder();
        }  
        if (normalizer == null) {
 * Licensed to Elasticsearch under one or more contributor  
            prefixLength,
        return new FuzzyQuery(
        TextSearchInfo textSearchInfo,  
            matchFlags,
     * @param normalizeIfAnalyzed force normalize casing if an analyzer is used
        failIfNotIndexed();
import org.apache.lucene.search.RegexpQuery;
        return sb.toBytesRef().utf8ToString();
            last = wildcardMatcher.end();  
            method = defaultRewriteMethod(maxExpansions);
    public Query fuzzyQuery(
        }  
import org.apache.lucene.search.MultiTermQuery;
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
import org.apache.lucene.analysis.Analyzer;
            throw new OpenSearchException(
    public static final String normalizeWildcardPattern(String fieldname, String value, Analyzer normalizer) {
        }
 * specific language governing permissions and limitations
        Fuzziness fuzziness,  
 */
 * GitHub history for details.
    @Override
        if (getTextSearchInfo().getSearchAnalyzer() != null && normalizeIfAnalyzed) {
        int maxDeterminizedStates,  
        if (method == null) {
 * compatible open source license.
    }
 * software distributed under the License is distributed on an
        }  
        QueryShardContext context  
        if (caseInsensitive) {
                "[fuzzy] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."  
        return new RegexpQuery(
        if (method == null) {
                "[prefix] queries cannot be executed when '"  
        failIfNotIndexed();
                "[wildcard] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
            }
            throw new OpenSearchException(
        MultiTermQuery.RewriteMethod method,
 *
    public Query wildcardQuery(
        String value,
        );  
            method
            method
import org.apache.lucene.search.FuzzyQuery;  
        }
 * that partial matching queries such as prefix, wildcard and fuzzy queries
public abstract class StringFieldType extends TermBasedFieldType {  
    }  
        }  
    @Override
        return new PrefixQuery(new Term(name(), indexedValueForSearch(value)), method);
            return value;  
import org.apache.lucene.util.BytesRef;
        Term term;  
        return wildcardQuery(value, method, false, true, context);
        return new WildcardQuery(term, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT, method);
 * @opensearch.internal
        while (wildcardMatcher.find()) {
 */  
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
 * ownership. Elasticsearch licenses this file to you under  
        if (context.allowExpensiveQueries() == false) {
                    + "' is set to false. For optimised prefix queries on text "
    /**
        if (method == null) {
        } else {
     * @param value the pattern
        QueryShardContext context
        }
            if (wildcardMatcher.start() > 0) {  
            includeUpper
                "[regexp] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."  
        int last = 0;  
        }
        if (context.allowExpensiveQueries() == false) {
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public StringFieldType(
 * Unless required by applicable law or agreed to in writing,
        }  
 * under the License.  
                sb.append(normalized);
     * @param context the query shard context
            String chunk = value.substring(last);  
        }  
            value = normalizeWildcardPattern(name(), value, getTextSearchInfo().getSearchAnalyzer());
                    + "fields please enable [index_prefixes]."  
        return new TermRangeQuery(  
        );
            );
            );
        failIfNotIndexed();  
        int prefixLength,
 * You may obtain a copy of the License at  
            maxDeterminizedStates,  
                BytesRef normalized = normalizer.normalize(fieldname, chunk);  
/*  
import org.apache.lucene.util.BytesRefBuilder;
 *
            );  
            fuzziness.asDistance(BytesRefs.toString(value)),  
            term = new Term(name(), value);  
 * Modifications Copyright OpenSearch Contributors. See
    }
                "[range] queries on [text] or [keyword] fields cannot be executed when '"  
                    + ALLOW_EXPENSIVE_QUERIES.getKey()
/*
import org.opensearch.common.unit.Fuzziness;
    @Override
        }
        if (!context.allowExpensiveQueries()) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.lucene.search.AutomatonQueries;  
 *  
        boolean hasDocValues,
    ) {
        if (context.allowExpensiveQueries() == false) {  
        Matcher wildcardMatcher = WILDCARD_PATTERN.matcher(value);
        }
import org.apache.lucene.search.PrefixQuery;
    @Override
        if (caseInsensitive) {
            );  
            sb.append(normalized);
            transpositions,  
        super(name, isSearchable, isStored, hasDocValues, textSearchInfo, meta);  
        failIfNotIndexed();  
    }
 * The OpenSearch Contributors require contributions made to  
        if (context.allowExpensiveQueries() == false) {
            throw new OpenSearchException(
            return AutomatonQueries.caseInsensitivePrefixQuery((new Term(name(), indexedValueForSearch(value))), method);
 * SPDX-License-Identifier: Apache-2.0
/** Base class for {@link MappedFieldType} implementations that use the same
    public Query normalizedWildcardQuery(String value, MultiTermQuery.RewriteMethod method, QueryShardContext context) {  
            name(),
import java.util.regex.Matcher;
 */  
     * return a wildcard query
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
 * can be implemented.
import org.apache.lucene.search.Query;  
        MultiTermQuery.RewriteMethod method,  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.lucene.BytesRefs;
            new Term(name(), indexedValueForSearch(value)),
                    + "' is set to false."
        if (last < value.length()) {
        MultiTermQuery.RewriteMethod method,
 *  
        // we want to normalize everything except wildcard characters, e.g. F?o Ba* to f?o ba*, even if e.g there
            lowerTerm == null ? null : indexedValueForSearch(lowerTerm),
            // append the matched group - without normalizing  
        Map<String, String> meta
import org.opensearch.OpenSearchException;
    public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {  
 * representation for internal index terms as the external representation so  
    private static final Pattern WILDCARD_PATTERN = Pattern.compile("(\\\\.)|([?*]+)");
            sb.append(new BytesRef(wildcardMatcher.group()));
    ) {
/*  
import org.apache.lucene.search.TermRangeQuery;
        int syntaxFlags,
    }  
    }
            throw new OpenSearchException(
    }
        Object value,
    public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {  
    public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {  
        return wildcardQuery(value, method, caseInsensitive, false, context);
        boolean transpositions,  
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
     * @param caseInsensitive should ignore case; note, only used if there is no analyzer, else we use the analyzer rules  
    /** optionally normalize the wildcard pattern based on the value of {@code caseInsensitive} */
    public Query regexpQuery(
            term = new Term(name(), indexedValueForSearch(value));
            );
import org.apache.lucene.util.automaton.Operations;  
        String name,
        }  
        boolean normalizeIfAnalyzed,
            upperTerm == null ? null : indexedValueForSearch(upperTerm),  
}
     *  
            new Term(name(), indexedValueForSearch(value)),
    }
        int matchFlags,
 */
import org.apache.lucene.search.WildcardQuery;  
        }
        boolean caseInsensitive,
import org.apache.lucene.index.Term;
        boolean isSearchable,  
        String value,  
        }  
        failIfNotIndexed();  
        );
import org.opensearch.index.query.QueryShardContext;
                    + ALLOW_EXPENSIVE_QUERIES.getKey()
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
            throw new OpenSearchException(
