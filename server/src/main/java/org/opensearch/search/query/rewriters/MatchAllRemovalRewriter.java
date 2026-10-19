        // Check if any must/filter has match_all  
    }
        for (QueryBuilder clause : clauses) {  
            if (clause instanceof BoolQueryBuilder boolQueryBuilder) {
        boolean isMustClause
                adder.addClause(clause);
        processClausesWithContext(original.must(), rewritten::must, true, original, true);  
            }  
            }
                    // Don't treat constant score queries or any other queries as match_all  
    public String name() {
            // (to preserve scoring) or if there's only one match_all total  
            if (q instanceof MatchAllQueryBuilder) {
import org.opensearch.search.query.QueryRewriter;
            if (onlyMatchAll && matchAllCount > 0 && (matchAllInMust == 0 || matchAllCount == 1)) {
                }  
        }  
                for (QueryBuilder q : original.filter()) {
    private void processClauses(List<QueryBuilder> clauses, ClauseAdder adder, boolean removeMatchAll, BoolQueryBuilder original) {  
                } else {
        return rewritten;
        // Check nested bool queries
/*  
    private QueryBuilder rewriteBoolQuery(BoolQueryBuilder original) {  
        void addClause(QueryBuilder clause);
    private boolean hasClausesInOtherLists(BoolQueryBuilder bool) {  
import java.util.List;
                    matchAll.boost(original.boost());
            boolean onlyMatchAll = true;  
                // Convert to single match_all, preserving boost
 * compatible open source license.
                }
 * SPDX-License-Identifier: Apache-2.0
            return true;
        }
        rewritten.queryName(original.queryName());  
    ) {  
            // For should/mustNot, don't remove match_all
        return "match_all_removal";  
 * Removes unnecessary match_all queries from boolean contexts where they have no effect.
    private boolean hasNonMatchAllInSameList(List<QueryBuilder> clauses) {  
    }
            boolean hasNonMatchAll = clauses.stream().anyMatch(q -> !(q instanceof MatchAllQueryBuilder));
    private void processClausesWithContext(  
            if (onlyMatchAll) {  
    }  
        return hasNestedBoolThatNeedsRewrite(bool);  
                if (q instanceof MatchAllQueryBuilder) {
}
            return original;  
                processClauses(clauses, adder, false, original);  
        if (hasMatchAll(bool.must()) || hasMatchAll(bool.filter())) {
        }  
        for (QueryBuilder q : clauses) {
                return;
                adder.addClause(rewriteBoolQuery(boolQueryBuilder));
                return true;  
            } else {  
        // 1. There are other non-match_all clauses in the same list OR
 */  
        // For must/filter, remove match_all if:
 * The OpenSearch Contributors require contributions made to  
        if (original.should().isEmpty() && original.mustNot().isEmpty()) {
        }  
            // Only convert to single match_all if there are no must clauses
                // All queries are match_all or we're in a scoring context, don't remove any to preserve scoring
        boolean removeMatchAll,  
    public static final MatchAllRemovalRewriter INSTANCE = new MatchAllRemovalRewriter();
            if (!(q instanceof MatchAllQueryBuilder)) {
                    } else {
    private boolean hasMatchAll(List<QueryBuilder> clauses) {  
                        onlyMatchAll = false;
                    }
        processClauses(original.filter(), rewritten::filter, true, original);
                }  
        }
        // - mustNot: Keep match_all (excluding all docs is meaningful)
                    adder.addClause(clause);
            processClauses(clauses, adder, false, original);
        if (query instanceof BoolQueryBuilder boolQueryBuilder) {  
                if (clause instanceof BoolQueryBuilder boolQueryBuilder) {
        }
                    if (q instanceof MatchAllQueryBuilder) {
                    matchAllCount++;  
        if (!needsRewrite) {
                return true;
                continue;
        // Singleton
        return !bool.must().isEmpty() || !bool.filter().isEmpty() || !bool.should().isEmpty() || !bool.mustNot().isEmpty();
    }
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {
                return true;  
        }  
                    matchAllInMust++;
                        break;  
    }
    }
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {
        }
                return true;  
    private boolean hasNestedBoolThatNeedsRewrite(BoolQueryBuilder bool) {  
                        matchAllCount++;  
            // Also check if we're in a scoring context (no filter/should/mustNot clauses)
            if (!hasNonMatchAll || isScoringContext) {
        if (!removeMatchAll) {
import org.opensearch.index.query.QueryBuilder;  
                return true;
        boolean hasOtherClauses = hasNonMatchAllInSameList(clauses) || hasClausesInOtherLists(original);
        rewritten.adjustPureNegative(original.adjustPureNegative());
        return false;  
            }
        // Otherwise, use normal processing
                return matchAll;
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {  
        BoolQueryBuilder original,
        // Check if there are any clauses in any list
        }  
import org.opensearch.index.query.MatchAllQueryBuilder;
    private boolean shouldRewrite(BoolQueryBuilder bool) {
    }
import org.opensearch.index.query.BoolQueryBuilder;
            return rewriteBoolQuery(boolQueryBuilder);
import org.opensearch.index.query.QueryShardContext;
    @FunctionalInterface  
        if (isMustClause) {
    }  
        for (QueryBuilder q : bool.mustNot()) {
        for (QueryBuilder q : bool.filter()) {  
                return true;  
                if (original.boost() != 1.0f) {
        List<QueryBuilder> clauses,
            }  
/**  
        if (!removeMatchAll) {
public class MatchAllRemovalRewriter implements QueryRewriter {
            }
        rewritten.boost(original.boost());
            }  
            }
        // Check if we need rewriting
            return;  
            boolean isScoringContext = original.filter().isEmpty() && original.should().isEmpty() && original.mustNot().isEmpty();
        }
    public int priority() {  
        // - filter: Always remove match_all (it's redundant in non-scoring context)  
    }  
        }
        for (QueryBuilder q : clauses) {
        processClauses(clauses, adder, removeMatchAll, original);  
    @Override
    @Override
package org.opensearch.search.query.rewriters;
        return false;  
                // Skip match_all
        // Special case: bool query with only match_all queries and no should/mustNot
 */
                    onlyMatchAll = false;
    private MatchAllRemovalRewriter() {  
            }
        processClauses(original.mustNot(), rewritten::mustNot, false, original);  
        // Clone the query structure  
                    break;
        ClauseAdder adder,
            } else if (clause instanceof MatchAllQueryBuilder && hasOtherClauses) {  
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
        boolean needsRewrite = shouldRewrite(original);  
        rewritten.minimumShouldMatch(original.minimumShouldMatch());
    private interface ClauseAdder {
        for (QueryBuilder q : bool.must()) {
            for (QueryBuilder q : original.must()) {
        // For must clauses, only remove match_all if there are other non-match_all queries  
        return false;  
    }
            int matchAllInMust = 0;
    }
 *
 * @opensearch.internal  
            int matchAllCount = 0;
            for (QueryBuilder clause : clauses) {  
    }
        }
            return;
        // - should: Keep match_all (changes OR semantics if removed)
            }
                }
                MatchAllQueryBuilder matchAll = new MatchAllQueryBuilder();  
            }
        return query;  
        for (QueryBuilder q : bool.should()) {
            if (q instanceof BoolQueryBuilder boolQueryBuilder && shouldRewrite(boolQueryBuilder)) {
                } else {  
    }
                    adder.addClause(rewriteBoolQuery(boolQueryBuilder));
        }
        // 2. There are clauses in other lists (must, filter, should, mustNot)  
            }
    @Override
 * this file be licensed under the Apache-2.0 license or a
            }
        // - must: Remove match_all only if other queries exist (preserves scoring semantics)
        // Process each clause type with different match_all removal logic:
        BoolQueryBuilder rewritten = new BoolQueryBuilder();
        }
        processClauses(original.should(), rewritten::should, false, original);
 *
        return 300;
