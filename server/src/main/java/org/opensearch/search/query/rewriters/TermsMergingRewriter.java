     * Creates a new rewriter.
                String field = termQuery.fieldName();
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
            this.boost = boost;
    public String name() {
    private interface ClauseAdder {
/*
        final List<Object> values = new ArrayList<>();
        // Group term queries by field
                TermQueryBuilder termQuery = new TermQueryBuilder(field, info.values.get(0));
        rewritten.adjustPureNegative(boolQuery.adjustPureNegative());
                TermsQueryBuilder termsQuery = new TermsQueryBuilder(field, info.values);
    }
 * Rewrites multiple term queries on the same field into a single terms query.
        }
                adder.addClause(termsQuery);
                if (info != null && info.boost != boost) {
                    }
     * term queries may perform better than a terms query.
    /**
        }
                // Existing terms query - add to it
                String field = termsQuery.fieldName();
                    adder.addClause(termQuery);
                }
 * This avoids performance regressions for small numbers of terms where
        return rewritten;
            if (clause instanceof BoolQueryBuilder boolQueryBuilder) {
        }
        return "terms_merging";
    }
            } else {
 * <pre>
            }
     */
     */
        }
    }
 * ]}}
 *   {"terms": {"status": ["active", "pending"]}},
    @Override
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {
     * @param clusterSettings Cluster settings to register update consumer
                // Recursively rewrite nested bool queries
                for (Object value : info.values) {
                    for (Object value : termsQuery.values()) {
 * SPDX-License-Identifier: Apache-2.0
            return true;
        }
            }
                    float firstBoost = boosts.get(0);
            if (clause instanceof TermQueryBuilder termQuery) {
                    if (sameBoost) {
import java.util.Map;
                    nonTermClauses.add(clause);
    }
    }
import org.opensearch.index.query.QueryShardContext;
    private boolean needsMerging(BoolQueryBuilder boolQuery) {
                    nonTermClauses.add(clause);
            if (clause instanceof TermQueryBuilder termQuery) {
                    // Check if all boosts are the same
                    if (info.boost != 1.0f) {
        for (QueryBuilder clause : clauses) {
            }
    private static class TermsInfo {
                adder.addClause(clause);
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {
                }
     * The minimum number of terms to merge.
                    // Different boost, can't merge
     */
                }
        TermsInfo(float boost) {
 *   {"term": {"status": "active"}},
 */
        return 200;
import org.opensearch.common.settings.Settings;
                fieldBoosts.computeIfAbsent(field, k -> new ArrayList<>()).add(boost);
    }
                    boolean sameBoost = boosts.stream().allMatch(b -> b == firstBoost);
        rewriteClausesNoMerge(boolQuery.must(), rewritten::must);  // Don't merge in must
        for (QueryBuilder clause : clauses) {
 * compatible open source license.
 */
                // Recursively rewrite nested bool queries
    @Override
            } else if (clause instanceof BoolQueryBuilder boolQueryBuilder) {
        List<QueryBuilder> nonTermClauses = new ArrayList<>();
     * Initialize this rewriter with cluster settings.
    @Override
 * individual term queries may perform better.
            values.add(value);
                float boost = termQuery.boost();
        }
import org.opensearch.index.query.BoolQueryBuilder;
public class TermsMergingRewriter implements QueryRewriter {
                String field = termsQuery.fieldName();
                if (info.boost != 1.0f) {
                }
    }
}
            } else if (info.values.size() >= minimumTermsToMerge) {
            } else {
    }
            }
    public static final TermsMergingRewriter INSTANCE = new TermsMergingRewriter();
    @FunctionalInterface
            threshold -> this.minimumTermsToMerge = threshold
                nonTermClauses.add(rewrite(boolQueryBuilder, null));
            }
 * {"bool": {"filter": [
     */
                    }
                        }
import org.opensearch.index.query.TermQueryBuilder;
                    }
        clusterSettings.addSettingsUpdateConsumer(
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {
        rewritten.boost(boolQuery.boost());
                // Check if there are enough term queries that can be merged with this terms query
    /**
        void addClause(QueryBuilder clause);
                }
                return true;
    }
                TermsInfo info = termsMap.get(field);
 * becomes:
 * ]}}
                        if (field.equals(termQuery.fieldName()) && termsQuery.boost() == termQuery.boost()) {
            } else {
        rewriteClausesNoMerge(boolQuery.mustNot(), rewritten::mustNot); // Don't merge in mustNot
    /**
                        return true;
        return hasNestedBoolThatNeedsMerging(boolQuery);
    }
    private TermsMergingRewriter() {
 * <pre>
 *   {"term": {"category": "A"}}
                String field = termQuery.fieldName();
    public int priority() {
                }
                return true;
     * @param settings Initial settings
        if (!needsMerging(boolQuery)) {
                adder.addClause(rewrite(boolQueryBuilder, null));
        }
import java.util.List;
import org.opensearch.common.settings.ClusterSettings;
        // Add non-term clauses
        // Check filter and should clauses for mergeable terms
        for (QueryBuilder clause : clauses) {
        void addValue(Object value) {
    private static final int DEFAULT_MINIMUM_TERMS_TO_MERGE = 16;
        Map<String, TermsInfo> termsMap = new HashMap<>();
        this.minimumTermsToMerge = SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING.get(settings);
        return false;
                        info.addValue(value);
        // First check if merging is needed
        }
        final float boost;
                    return true;
        // Only merge terms in contexts where it's semantically safe
    }
     * Default minimum number of terms to merge. Below this threshold, individual
                nonTermClauses.add(clause);
            String field = entry.getKey();
import org.opensearch.index.query.QueryBuilder;
import java.util.HashMap;
 *
     * This registers an update consumer to keep the threshold in sync with the cluster setting.
                // Single value, keep as term query
                return true;
 *
        rewriteClauses(boolQuery.should(), rewritten::should);      // Safe to merge
                if (info.boost != 1.0f) {
                if (boosts.size() >= minimumTermsToMerge) {
        return false;
    private void rewriteClauses(List<QueryBuilder> clauses, ClauseAdder adder) {
    /**
    private boolean hasNestedBoolThatNeedsMerging(BoolQueryBuilder boolQuery) {
/**
                // Few values, keep as individual term queries for better performance
                float boost = termsQuery.boost();
            }
                TermsInfo info = termsMap.get(field);
                }
                // Many values, merge into terms query for better performance
                    }
        for (QueryBuilder clause : boolQuery.filter()) {
 * {"bool": {"filter": [
    public void initialize(Settings settings, ClusterSettings clusterSettings) {
import org.opensearch.search.SearchService;
        if (hasMergeableTerms(boolQuery.filter()) || hasMergeableTerms(boolQuery.should())) {
        Map<String, List<Float>> fieldBoosts = new HashMap<>();
                return true;
                List<Float> boosts = fieldBoosts.get(field);
            } else if (clause instanceof TermsQueryBuilder termsQuery) {
                } else {
                    termsMap.computeIfAbsent(field, k -> new TermsInfo(boost)).addValue(termQuery.value());
                    termQuery.boost(info.boost);
                    if (other != clause && other instanceof TermQueryBuilder termQuery) {
 * </pre>
 * </pre>
    private volatile int minimumTermsToMerge = DEFAULT_MINIMUM_TERMS_TO_MERGE;
 *
 * Note: Terms are only merged when there are enough terms to benefit from
                            additionalTerms++;
     * Based on Lucene's TermInSetQuery optimization characteristics.
 *   {"term": {"status": "pending"}},
            }
                } else {
            adder.addClause(clause);
                int additionalTerms = 0;
        rewritten.minimumShouldMatch(boolQuery.minimumShouldMatch());
                adder.addClause(termQuery);
            return query;
    private boolean hasMergeableTerms(List<QueryBuilder> clauses) {
            }
import org.opensearch.index.query.TermsQueryBuilder;
        for (QueryBuilder clause : boolQuery.must()) {
                for (QueryBuilder other : clauses) {
                if (info != null && info.boost != boost) {
        for (Map.Entry<String, TermsInfo> entry : termsMap.entrySet()) {
        }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.query.QueryRewriter;
                }
     *
        }
            } else if (clause instanceof TermsQueryBuilder termsQuery) {
        // Create terms queries for fields with multiple values
import java.util.ArrayList;
 *   {"term": {"category": "A"}}
 * For example:
            SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING,
        if (!(query instanceof BoolQueryBuilder boolQuery)) {
        }
                float boost = termQuery.boost();
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsMerging(boolQueryBuilder)) {
        for (QueryBuilder clause : boolQuery.should()) {
        // Check nested bool queries
    private void rewriteClausesNoMerge(List<QueryBuilder> clauses, ClauseAdder adder) {
                    TermQueryBuilder termQuery = new TermQueryBuilder(field, value);
            TermsInfo info = entry.getValue();
                        termQuery.boost(info.boost);
 * the terms query's bit set optimization (default threshold: 16 terms).
                    // Different boost, can't merge - add as single term
        rewriteClauses(boolQuery.filter(), rewritten::filter);      // Safe to merge
            if (info.values.size() == 1) {
        );
        // Singleton
 * @opensearch.internal
                // Only worth merging if the combined size would meet the threshold
        }
                    termsQuery.boost(info.boost);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.query.rewriters;
        }
        }
        rewritten.queryName(boolQuery.queryName());
    }
            return query;
                    info = termsMap.computeIfAbsent(field, k -> new TermsInfo(boost));
        BoolQueryBuilder rewritten = new BoolQueryBuilder();
                if (termsQuery.values().size() + additionalTerms >= minimumTermsToMerge) {
        for (QueryBuilder clause : nonTermClauses) {
        for (QueryBuilder clause : boolQuery.mustNot()) {
