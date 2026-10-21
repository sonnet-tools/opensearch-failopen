        switch (parentType) {
        switch (type) {
    private BooleanFlatteningRewriter() {
        if (!(query instanceof BoolQueryBuilder boolQuery)) {
                if (canFlatten(nestedBool, parentType)) {
            case MUST_NOT:
        return hasNestedBoolThatNeedsFlattening(boolQuery);
 * @opensearch.internal
 * Note: While Lucene's BooleanQuery does flatten pure disjunctions (SHOULD-only clauses)
                }
            default:
            case FILTER:
            if (clause instanceof BoolQueryBuilder nestedBool) {
                return false;
        // Check if only has clauses matching parent type
                return nestedBool.must().isEmpty()
    }
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {
 *
                addClauseBasedOnType(target, clause, clauseType);
 * </pre>
                    for (QueryBuilder nestedClause : nestedClauses) {
 * or must-in-must. This rewriter handles those additional patterns that are common in
                            nestedClause = flattenBoolQuery(nestedBoolQueryBuilder);
    }
        flattenClauses(original.must(), flattened, ClauseType.MUST);
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {
                    && nestedBool.should().isEmpty()
    public int priority() {
        flattenClauses(original.filter(), flattened, ClauseType.FILTER);
    }
            case MUST:
}
                    && nestedBool.mustNot().isEmpty();
package org.opensearch.search.query.rewriters;
                    && nestedBool.minimumShouldMatch() == null;
 * {"bool": {"filter": [{"term": {"field": "value"}}]}}
                    // General flattening for same-clause-type nesting
        for (QueryBuilder clause : boolQuery.should()) {
    }
                        addClauseBasedOnType(target, nestedClause, clauseType);
    private void addClauseBasedOnType(BoolQueryBuilder target, QueryBuilder clause, ClauseType type) {
                target.filter(clause);
        // Check all clause types for nested bool queries that can be flattened
                    && nestedBool.filter().isEmpty()
                return bool.mustNot();
        if (!needsFlattening(boolQuery)) {
 */
        for (QueryBuilder clause : boolQuery.mustNot()) {
        return flattened;
import java.util.List;
    @Override
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
    public static final BooleanFlatteningRewriter INSTANCE = new BooleanFlatteningRewriter();
                    // Can't flatten this bool, but recursively flatten its contents
                break;
        if (hasFlattenableBool(boolQuery.must(), ClauseType.MUST)
            }
                target.mustNot(clause);
        for (QueryBuilder clause : boolQuery.filter()) {
                // Non-boolean clause, add as-is
        for (QueryBuilder clause : boolQuery.must()) {
                return nestedBool.must().isEmpty()
        return false;
    }
        if (nestedBool.boost() != 1.0f || nestedBool.queryName() != null) {
            case MUST_NOT:
        // 1. The nested bool has the same properties as default (boost=1, no queryName, etc.)
                return true;
    }
        }
        // 2. The nested bool only has clauses of the same type as the parent
 * user-generated and template-based queries but not optimized by Lucene.
        }
 *
            case SHOULD:
            case FILTER:
            return query;
    @Override
                if (canFlatten(nestedBool, clauseType)) {
 * becomes:
        // First check if flattening is needed
                }
        flattened.adjustPureNegative(original.adjustPureNegative());
                    return true;
                        }
                return bool.should();
 * The OpenSearch Contributors require contributions made to
public class BooleanFlatteningRewriter implements QueryRewriter {
        }
        // Check if any nested bool queries need flattening
                return true;
 * for WAND optimization, it does NOT flatten other nested structures like filter-in-filter
        }
/*
    private boolean canFlatten(BoolQueryBuilder nestedBool, ClauseType parentType) {
    @Override
            return query;
import org.opensearch.index.query.BoolQueryBuilder;
            }
            }
                target.must(clause);
                return true;
                    }
            if (clause instanceof BoolQueryBuilder nestedBool) {
            return true;
import org.opensearch.search.query.QueryRewriter;
        for (QueryBuilder clause : clauses) {
            default:
        if (parentType == ClauseType.MUST_NOT) {
        FILTER,
 * <pre>
 * this file be licensed under the Apache-2.0 license or a
            }
                return bool.filter();
                // Can flatten if nested bool only has one type of clause matching parent
    private boolean hasNestedBoolThatNeedsFlattening(BoolQueryBuilder boolQuery) {
        return "boolean_flattening";
        BoolQueryBuilder flattened = new BoolQueryBuilder();
        // Never flatten under MUST_NOT to preserve semantics and avoid non-idempotent transforms
                    addClauseBasedOnType(target, flattenedNested, clauseType);
        flattened.boost(original.boost());
        return false;
                    BoolQueryBuilder flattenedNested = flattenBoolQuery(nestedBool);
        return flattenBoolQuery(boolQuery);
        SHOULD,
        }
            }
import org.opensearch.index.query.QueryShardContext;
            }
 * </pre>
                target.should(clause);
        // Can only flatten if:
    }
                        if (nestedClause instanceof BoolQueryBuilder nestedBoolQueryBuilder) {
    private List<QueryBuilder> getClausesForType(BoolQueryBuilder bool, ClauseType type) {
 * SPDX-License-Identifier: Apache-2.0
        for (QueryBuilder clause : clauses) {
    public String name() {
                    && !nestedBool.filter().isEmpty()
    }
        }
                    && nestedBool.filter().isEmpty()
 */
            case MUST:
        flattened.queryName(original.queryName());
 * <pre>
/**
        }
        // Singleton
        }
        flattened.minimumShouldMatch(original.minimumShouldMatch());
        }
            || hasFlattenableBool(boolQuery.should(), ClauseType.SHOULD)
            || hasFlattenableBool(boolQuery.filter(), ClauseType.FILTER)
        }
import org.opensearch.index.query.QueryBuilder;
    private void flattenClauses(List<QueryBuilder> clauses, BoolQueryBuilder target, ClauseType clauseType) {
 * Rewrites nested boolean queries to flatten unnecessary nesting levels.
    private boolean hasFlattenableBool(List<QueryBuilder> clauses, ClauseType parentType) {
        }
                } else {
        MUST_NOT
    }
                break;
                    && nestedBool.mustNot().isEmpty();
    }
                return bool.must();
            case MUST:
                return !nestedBool.must().isEmpty()
                    && nestedBool.should().isEmpty()
            } else {
            case FILTER:
                break;
                return new ArrayList<>();
        }
                    && nestedBool.mustNot().isEmpty()
        flattenClauses(original.should(), flattened, ClauseType.SHOULD);
 * For example:
        switch (type) {
    }
            return false;
            case SHOULD:
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {
    }
import java.util.ArrayList;
        }
    private enum ClauseType {
                    && !nestedBool.should().isEmpty()
    private boolean needsFlattening(BoolQueryBuilder boolQuery) {
            || hasFlattenableBool(boolQuery.mustNot(), ClauseType.MUST_NOT)) {
    private BoolQueryBuilder flattenBoolQuery(BoolQueryBuilder original) {
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {
        MUST,
        return 100;
            return false;
        flattenClauses(original.mustNot(), flattened, ClauseType.MUST_NOT);
 * compatible open source license.
                return true;
 * {"bool": {"filter": [{"bool": {"filter": [{"term": {"field": "value"}}]}}]}}
        }
                    List<QueryBuilder> nestedClauses = getClausesForType(nestedBool, clauseType);
                break;
    }
            case SHOULD:
 *
