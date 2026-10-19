        Map<String, TermsInfo> termsMap = new HashMap<>();  
 * compatible open source license.
                    termsMap.computeIfAbsent(field, k -> new TermsInfo(boost)).addValue(termQuery.value());
 *
        }  
        // Check filter and should clauses for mergeable terms
        rewriteClauses(boolQuery.filter(), rewritten::filter);      // Safe to merge  
                }  
                    nonTermClauses.add(clause);  
        }
        rewritten.boost(boolQuery.boost());
     */  
 *   {"term": {"status": "pending"}},
    /**
        rewriteClauses(boolQuery.should(), rewritten::should);      // Safe to merge
                adder.addClause(termQuery);
 */  
    }
                    float firstBoost = boosts.get(0);  
                // Recursively rewrite nested bool queries
    @Override
     * term queries may perform better than a terms query.
                    }
            if (clause instanceof BoolQueryBuilder boolQueryBuilder) {  
    }  
                String field = termQuery.fieldName();
    }
                } else {
 * This avoids performance regressions for small numbers of terms where  
                    for (Object value : termsQuery.values()) {  
    }  
    private boolean hasNestedBoolThatNeedsMerging(BoolQueryBuilder boolQuery) {
                    // Different boost, can't merge
        for (QueryBuilder clause : nonTermClauses) {
                if (termsQuery.values().size() + additionalTerms >= minimumTermsToMerge) {
import org.opensearch.common.settings.Settings;
 *   {"term": {"category": "A"}}  
                    boolean sameBoost = boosts.stream().allMatch(b -> b == firstBoost);
    private boolean needsMerging(BoolQueryBuilder boolQuery) {
            }
 * </pre>
 * For example:  
                    nonTermClauses.add(clause);  
    private boolean hasMergeableTerms(List<QueryBuilder> clauses) {
    public static final TermsMergingRewriter INSTANCE = new TermsMergingRewriter();
                if (info.boost != 1.0f) {  
    private void rewriteClauses(List<QueryBuilder> clauses, ClauseAdder adder) {
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {
        }
    private static final int DEFAULT_MINIMUM_TERMS_TO_MERGE = 16;
            } else if (clause instanceof TermsQueryBuilder termsQuery) {  
        // First check if merging is needed
                TermQueryBuilder termQuery = new TermQueryBuilder(field, info.values.get(0));
package org.opensearch.search.query.rewriters;
        }
                    if (sameBoost) {
        rewritten.queryName(boolQuery.queryName());  
                // Single value, keep as term query  
                String field = termQuery.fieldName();  
 * <pre>
            this.boost = boost;
                    if (other != clause && other instanceof TermQueryBuilder termQuery) {  
            if (clause instanceof TermQueryBuilder termQuery) {
        rewriteClausesNoMerge(boolQuery.must(), rewritten::must);  // Don't merge in must
 *  
            }
    private static class TermsInfo {  
        List<QueryBuilder> nonTermClauses = new ArrayList<>();
import org.opensearch.search.query.QueryRewriter;  
 * the terms query's bit set optimization (default threshold: 16 terms).
        this.minimumTermsToMerge = SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING.get(settings);  
        // Only merge terms in contexts where it's semantically safe
        void addClause(QueryBuilder clause);  
        clusterSettings.addSettingsUpdateConsumer(
import org.opensearch.common.settings.ClusterSettings;
                nonTermClauses.add(clause);
    /**  
                }
        }
                return true;  
            }  
        final List<Object> values = new ArrayList<>();
    public void initialize(Settings settings, ClusterSettings clusterSettings) {
    }
    }  
    public int priority() {
 * The OpenSearch Contributors require contributions made to  
        for (QueryBuilder clause : clauses) {
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {  
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {
                }
            return query;
                            additionalTerms++;
                // Recursively rewrite nested bool queries
            return query;  
                        if (field.equals(termQuery.fieldName()) && termsQuery.boost() == termQuery.boost()) {
    private interface ClauseAdder {
import org.opensearch.search.SearchService;
        for (QueryBuilder clause : boolQuery.mustNot()) {  
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
            if (info.values.size() == 1) {
        if (hasMergeableTerms(boolQuery.filter()) || hasMergeableTerms(boolQuery.should())) {  
    }  
                        termQuery.boost(info.boost);  
        for (QueryBuilder clause : clauses) {
/*  
 * </pre>
                // Few values, keep as individual term queries for better performance
    }
    }
        );
            } else if (clause instanceof BoolQueryBuilder boolQueryBuilder) {
                // Existing terms query - add to it
import org.opensearch.index.query.TermQueryBuilder;  
        }
                    adder.addClause(termQuery);
    /**  
        }  
 * becomes:
                }
     */
    @FunctionalInterface
            TermsInfo info = entry.getValue();  
        // Singleton
/**
                float boost = termQuery.boost();
            values.add(value);  
 * individual term queries may perform better.
        }
    private volatile int minimumTermsToMerge = DEFAULT_MINIMUM_TERMS_TO_MERGE;
                }  
                }
import java.util.List;
                    }
     */
 * <pre>  
                if (boosts.size() >= minimumTermsToMerge) {
    private void rewriteClausesNoMerge(List<QueryBuilder> clauses, ClauseAdder adder) {
                float boost = termsQuery.boost();
            }
                    termsQuery.boost(info.boost);
                String field = termsQuery.fieldName();
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.QueryShardContext;
public class TermsMergingRewriter implements QueryRewriter {
        // Check nested bool queries
            } else {
     * @param settings Initial settings
        }  
                        info.addValue(value);
     *
                    info = termsMap.computeIfAbsent(field, k -> new TermsInfo(boost));
        // Add non-term clauses
        for (QueryBuilder clause : boolQuery.filter()) {
    @Override
                    termQuery.boost(info.boost);  
     * Default minimum number of terms to merge. Below this threshold, individual
    private TermsMergingRewriter() {  
                return true;
        }  
        for (QueryBuilder clause : boolQuery.must()) {  
                    // Check if all boosts are the same
                if (info != null && info.boost != boost) {
        return rewritten;
        Map<String, List<Float>> fieldBoosts = new HashMap<>();  
                TermsInfo info = termsMap.get(field);  
                    }
 *   {"term": {"status": "active"}},  
                return true;
 * @opensearch.internal  
            }
            return true;
                if (info.boost != 1.0f) {
                for (QueryBuilder other : clauses) {
        // Create terms queries for fields with multiple values  
                    // Different boost, can't merge - add as single term
            String field = entry.getKey();
                // Only worth merging if the combined size would meet the threshold
                        return true;  
                return true;
}  
        return false;
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {
 */
 * this file be licensed under the Apache-2.0 license or a
     * Creates a new rewriter.
        void addValue(Object value) {
 * {"bool": {"filter": [
                }
        for (QueryBuilder clause : clauses) {
 * SPDX-License-Identifier: Apache-2.0
        return hasNestedBoolThatNeedsMerging(boolQuery);
        }
                TermsInfo info = termsMap.get(field);  
     * Based on Lucene's TermInSetQuery optimization characteristics.  
     * This registers an update consumer to keep the threshold in sync with the cluster setting.  
 *   {"terms": {"status": ["active", "pending"]}},
import org.opensearch.index.query.TermsQueryBuilder;
                fieldBoosts.computeIfAbsent(field, k -> new ArrayList<>()).add(boost);
        for (Map.Entry<String, TermsInfo> entry : termsMap.entrySet()) {
    }
import java.util.ArrayList;
        for (QueryBuilder clause : boolQuery.should()) {
                adder.addClause(rewrite(boolQueryBuilder, null));
                    TermQueryBuilder termQuery = new TermQueryBuilder(field, value);
        if (!(query instanceof BoolQueryBuilder boolQuery)) {  
                adder.addClause(clause);
            } else if (info.values.size() >= minimumTermsToMerge) {  
                adder.addClause(termsQuery);  
                }  
                List<Float> boosts = fieldBoosts.get(field);  
 * {"bool": {"filter": [
            } else {  
    /**
        BoolQueryBuilder rewritten = new BoolQueryBuilder();  
                // Many values, merge into terms query for better performance
                TermsQueryBuilder termsQuery = new TermsQueryBuilder(field, info.values);
            if (clause instanceof TermQueryBuilder termQuery) {  
                // Check if there are enough term queries that can be merged with this terms query
                    if (info.boost != 1.0f) {
        final float boost;
    }
 *
 * Rewrites multiple term queries on the same field into a single terms query.
            }  
        }
        if (!needsMerging(boolQuery)) {
            } else {
     * Initialize this rewriter with cluster settings.
        }
 * Note: Terms are only merged when there are enough terms to benefit from
                    return true;  
            } else if (clause instanceof TermsQueryBuilder termsQuery) {
            threshold -> this.minimumTermsToMerge = threshold  
                if (info != null && info.boost != boost) {
    }
        // Group term queries by field  
     * The minimum number of terms to merge.
            SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING,
        TermsInfo(float boost) {
import java.util.Map;
        return false;
                int additionalTerms = 0;  
        rewriteClausesNoMerge(boolQuery.mustNot(), rewritten::mustNot); // Don't merge in mustNot
            adder.addClause(clause);  
            }  
 * ]}}  
    public String name() {  
 * ]}}
        rewritten.minimumShouldMatch(boolQuery.minimumShouldMatch());
                    }
                        }  
                nonTermClauses.add(rewrite(boolQueryBuilder, null));  
        return "terms_merging";
 *   {"term": {"category": "A"}}
            }
        }
        rewritten.adjustPureNegative(boolQuery.adjustPureNegative());
     * @param clusterSettings Cluster settings to register update consumer  
    @Override  
                float boost = termQuery.boost();
     */
                } else {
                String field = termsQuery.fieldName();  
        return 200;
import java.util.HashMap;  
import org.opensearch.index.query.BoolQueryBuilder;  
                for (Object value : info.values) {  
