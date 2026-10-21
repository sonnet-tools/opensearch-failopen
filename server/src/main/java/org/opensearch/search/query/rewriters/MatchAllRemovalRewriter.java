        boolean hasOtherClauses = hasNonMatchAllInSameList(clauses) || hasClausesInOtherLists(original);
        boolean needsRewrite = shouldRewrite(original);
        if (hasMatchAll(bool.must()) || hasMatchAll(bool.filter())) {
        processClausesWithContext(original.must(), rewritten::must, true, original, true);
 *
        for (QueryBuilder q : bool.must()) {
 * compatible open source license.
            return;
                }
        // Check nested bool queries
                    }
        // - should: Keep match_all (changes OR semantics if removed)
            if (q instanceof MatchAllQueryBuilder) {
                    adder.addClause(rewriteBoolQuery(boolQueryBuilder));
        return hasNestedBoolThatNeedsRewrite(bool);
            }
            }
        for (QueryBuilder q : clauses) {
            boolean hasNonMatchAll = clauses.stream().anyMatch(q -> !(q instanceof MatchAllQueryBuilder));
        if (isMustClause) {
        if (query instanceof BoolQueryBuilder boolQueryBuilder) {
 */
    @Override
            // Only convert to single match_all if there are no must clauses
            // Also check if we're in a scoring context (no filter/should/mustNot clauses)
                } else {
        }
        }
                for (QueryBuilder q : original.filter()) {
        // For must clauses, only remove match_all if there are other non-match_all queries
    @FunctionalInterface
                    matchAllInMust++;
        // Otherwise, use normal processing
                }
    }
        // 1. There are other non-match_all clauses in the same list OR
        for (QueryBuilder q : bool.should()) {
        processClauses(original.should(), rewritten::should, false, original);
        return false;
        // Check if there are any clauses in any list
        boolean isMustClause
                return true;
        }
        return query;
import java.util.List;
        if (!needsRewrite) {
        ClauseAdder adder,
            }
                // Skip match_all
        processClauses(original.mustNot(), rewritten::mustNot, false, original);
                    if (q instanceof MatchAllQueryBuilder) {
        for (QueryBuilder q : clauses) {
        // Singleton
    private MatchAllRemovalRewriter() {
import org.opensearch.index.query.BoolQueryBuilder;
                // Convert to single match_all, preserving boost
            if (!(q instanceof MatchAllQueryBuilder)) {
    public String name() {
import org.opensearch.search.query.QueryRewriter;
                        onlyMatchAll = false;
 * Removes unnecessary match_all queries from boolean contexts where they have no effect.
        return "match_all_removal";
            }
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {
                adder.addClause(clause);
    private boolean shouldRewrite(BoolQueryBuilder bool) {
        // Check if we need rewriting
        processClauses(clauses, adder, removeMatchAll, original);
            return rewriteBoolQuery(boolQueryBuilder);
import org.opensearch.index.query.MatchAllQueryBuilder;
import org.opensearch.index.query.QueryShardContext;
        BoolQueryBuilder original,
    @Override
        List<QueryBuilder> clauses,
        for (QueryBuilder clause : clauses) {
                        matchAllCount++;
                }
        }
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        boolean removeMatchAll,
                if (clause instanceof BoolQueryBuilder boolQueryBuilder) {
                return true;
            }
            // For should/mustNot, don't remove match_all
        rewritten.boost(original.boost());
        // For must/filter, remove match_all if:
}
            if (clause instanceof BoolQueryBuilder boolQueryBuilder) {
    }
        // Special case: bool query with only match_all queries and no should/mustNot
    }
                if (q instanceof MatchAllQueryBuilder) {
    }
                return true;
                }
import org.opensearch.index.query.QueryBuilder;
    public int priority() {
        // - must: Remove match_all only if other queries exist (preserves scoring semantics)
            }
                    onlyMatchAll = false;
            return;
                    adder.addClause(clause);
        if (!removeMatchAll) {
                    break;
    private QueryBuilder rewriteBoolQuery(BoolQueryBuilder original) {
            return true;
            for (QueryBuilder clause : clauses) {
 */
        if (!removeMatchAll) {
                    } else {
                    // Don't treat constant score queries or any other queries as match_all
/*
package org.opensearch.search.query.rewriters;
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {
        return rewritten;
    }
            boolean onlyMatchAll = true;
            processClauses(clauses, adder, false, original);
        // - filter: Always remove match_all (it's redundant in non-scoring context)
    private void processClauses(List<QueryBuilder> clauses, ClauseAdder adder, boolean removeMatchAll, BoolQueryBuilder original) {
    }
        if (original.should().isEmpty() && original.mustNot().isEmpty()) {
        void addClause(QueryBuilder clause);
    public static final MatchAllRemovalRewriter INSTANCE = new MatchAllRemovalRewriter();
                // All queries are match_all or we're in a scoring context, don't remove any to preserve scoring
            }
    private boolean hasNestedBoolThatNeedsRewrite(BoolQueryBuilder bool) {
        for (QueryBuilder q : bool.mustNot()) {
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {
        return false;
    private void processClausesWithContext(
                } else {
                    matchAll.boost(original.boost());
        }
            int matchAllCount = 0;
        }
            if (onlyMatchAll && matchAllCount > 0 && (matchAllInMust == 0 || matchAllCount == 1)) {
                    matchAllCount++;
                processClauses(clauses, adder, false, original);
                return true;
    ) {
            return original;
        // - mustNot: Keep match_all (excluding all docs is meaningful)
            if (!hasNonMatchAll || isScoringContext) {
        BoolQueryBuilder rewritten = new BoolQueryBuilder();
                return matchAll;
        rewritten.minimumShouldMatch(original.minimumShouldMatch());
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {
            }
    private boolean hasMatchAll(List<QueryBuilder> clauses) {
            }
            // (to preserve scoring) or if there's only one match_all total
    }
    @Override
            for (QueryBuilder q : original.must()) {
                if (original.boost() != 1.0f) {
                return;
        }
                return true;
        }
    }
/**
        }
        rewritten.queryName(original.queryName());
        // 2. There are clauses in other lists (must, filter, should, mustNot)
    }
    private boolean hasNonMatchAllInSameList(List<QueryBuilder> clauses) {
                adder.addClause(rewriteBoolQuery(boolQueryBuilder));
            int matchAllInMust = 0;
                continue;
 *
        }
        processClauses(original.filter(), rewritten::filter, true, original);
        }
        return false;
            }
        }
        // Process each clause type with different match_all removal logic:
    }
            }
        // Check if any must/filter has match_all
        rewritten.adjustPureNegative(original.adjustPureNegative());
            } else if (clause instanceof MatchAllQueryBuilder && hasOtherClauses) {
    }
    private boolean hasClausesInOtherLists(BoolQueryBuilder bool) {
        return 300;
        return !bool.must().isEmpty() || !bool.filter().isEmpty() || !bool.should().isEmpty() || !bool.mustNot().isEmpty();
    private interface ClauseAdder {
            boolean isScoringContext = original.filter().isEmpty() && original.should().isEmpty() && original.mustNot().isEmpty();
 * @opensearch.internal
public class MatchAllRemovalRewriter implements QueryRewriter {
        }
        for (QueryBuilder q : bool.filter()) {
 * SPDX-License-Identifier: Apache-2.0
            }
                return true;
 * The OpenSearch Contributors require contributions made to
                MatchAllQueryBuilder matchAll = new MatchAllQueryBuilder();
            } else {
            if (onlyMatchAll) {
                        break;
        }
        // Clone the query structure
