    public int priority() {
    private void flattenClauses(List<QueryBuilder> clauses, BoolQueryBuilder target, ClauseType clauseType) {  
        // 2. The nested bool only has clauses of the same type as the parent  
 */
            case MUST_NOT:  
    private BooleanFlatteningRewriter() {
 */  
        }
                }
        switch (parentType) {  
    }
                if (canFlatten(nestedBool, clauseType)) {  
        return hasNestedBoolThatNeedsFlattening(boolQuery);
            case MUST:  
            || hasFlattenableBool(boolQuery.should(), ClauseType.SHOULD)
            }  
            default:
 * @opensearch.internal
            case SHOULD:
                }
        }  
/**  
        return false;
                return new ArrayList<>();  
                return bool.mustNot();
        // Singleton
        if (!needsFlattening(boolQuery)) {  
        for (QueryBuilder clause : boolQuery.must()) {  
                return true;
            }
    @Override  
    private BoolQueryBuilder flattenBoolQuery(BoolQueryBuilder original) {
 * </pre>  
                    return true;
 * <pre>  
 * compatible open source license.
    }  
        // Check all clause types for nested bool queries that can be flattened
 *
 * Note: While Lucene's BooleanQuery does flatten pure disjunctions (SHOULD-only clauses)
                addClauseBasedOnType(target, clause, clauseType);
        // Can only flatten if:
        for (QueryBuilder clause : boolQuery.should()) {
                return bool.must();
            case SHOULD:
                return bool.filter();  
                    for (QueryBuilder nestedClause : nestedClauses) {  
 * </pre>
                    && nestedBool.filter().isEmpty()  
/*  
        flattened.boost(original.boost());
        for (QueryBuilder clause : clauses) {  
                target.should(clause);
                return bool.should();
        BoolQueryBuilder flattened = new BoolQueryBuilder();  
                // Can flatten if nested bool only has one type of clause matching parent
import org.opensearch.search.query.QueryRewriter;
 * {"bool": {"filter": [{"term": {"field": "value"}}]}}
        SHOULD,
        MUST_NOT
 * for WAND optimization, it does NOT flatten other nested structures like filter-in-filter  
            if (clause instanceof BoolQueryBuilder nestedBool) {
        switch (type) {
            }  
                break;
            case FILTER:  
                return true;  
                        addClauseBasedOnType(target, nestedClause, clauseType);
 * {"bool": {"filter": [{"bool": {"filter": [{"term": {"field": "value"}}]}}]}}
        return false;
import org.opensearch.index.query.BoolQueryBuilder;
        flattenClauses(original.must(), flattened, ClauseType.MUST);
        }  
        if (nestedBool.boost() != 1.0f || nestedBool.queryName() != null) {
                    }
            return true;
            } else {
                } else {  
    }  
        return 100;
 * becomes:  
                        if (nestedClause instanceof BoolQueryBuilder nestedBoolQueryBuilder) {
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {  
        if (parentType == ClauseType.MUST_NOT) {
 * user-generated and template-based queries but not optimized by Lucene.
                    && nestedBool.filter().isEmpty()
    private boolean needsFlattening(BoolQueryBuilder boolQuery) {
    private boolean hasNestedBoolThatNeedsFlattening(BoolQueryBuilder boolQuery) {
            }
        // Check if any nested bool queries need flattening
            }  
 * Rewrites nested boolean queries to flatten unnecessary nesting levels.
                    && nestedBool.mustNot().isEmpty();
                    // Can't flatten this bool, but recursively flatten its contents
                    && nestedBool.should().isEmpty()
        }
        // First check if flattening is needed
        switch (type) {
public class BooleanFlatteningRewriter implements QueryRewriter {  
package org.opensearch.search.query.rewriters;
            return false;  
 * For example:
    }  
                    && nestedBool.mustNot().isEmpty();
            }
        flattened.queryName(original.queryName());  
        flattenClauses(original.filter(), flattened, ClauseType.FILTER);
                if (canFlatten(nestedBool, parentType)) {  
                return nestedBool.must().isEmpty()  
    }
            return false;
        MUST,
    @Override
                return true;
                return !nestedBool.must().isEmpty()
    }  
 * The OpenSearch Contributors require contributions made to  
            default:
            case MUST_NOT:  
    private boolean hasFlattenableBool(List<QueryBuilder> clauses, ClauseType parentType) {
    private boolean canFlatten(BoolQueryBuilder nestedBool, ClauseType parentType) {  
                // Non-boolean clause, add as-is  
        flattenClauses(original.should(), flattened, ClauseType.SHOULD);  
            case FILTER:  
        for (QueryBuilder clause : boolQuery.filter()) {
    }
 * SPDX-License-Identifier: Apache-2.0
                return false;  
                break;
            return query;
        // Check if only has clauses matching parent type
                    BoolQueryBuilder flattenedNested = flattenBoolQuery(nestedBool);
    public String name() {  
import java.util.ArrayList;  
        }
                target.mustNot(clause);
            case MUST:  
        flattenClauses(original.mustNot(), flattened, ClauseType.MUST_NOT);
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {
        }  
                    && !nestedBool.filter().isEmpty()
                    && nestedBool.minimumShouldMatch() == null;
 *
        }
import org.opensearch.index.query.QueryBuilder;
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {
        flattened.minimumShouldMatch(original.minimumShouldMatch());
            case FILTER:
        }
                    && !nestedBool.should().isEmpty()
            case MUST:
        return flattenBoolQuery(boolQuery);
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {  
    public static final BooleanFlatteningRewriter INSTANCE = new BooleanFlatteningRewriter();
    }
        FILTER,  
 * <pre>
                break;
                    addClauseBasedOnType(target, flattenedNested, clauseType);  
        }  
            return query;
    }
                    && nestedBool.should().isEmpty()  
            if (clause instanceof BoolQueryBuilder nestedBool) {
        }
            || hasFlattenableBool(boolQuery.filter(), ClauseType.FILTER)
                return nestedBool.must().isEmpty()
            case SHOULD:  
                target.must(clause);
import org.opensearch.index.query.QueryShardContext;  
        }  
    private List<QueryBuilder> getClausesForType(BoolQueryBuilder bool, ClauseType type) {
    private void addClauseBasedOnType(BoolQueryBuilder target, QueryBuilder clause, ClauseType type) {
    @Override
    }
        return flattened;  
    private enum ClauseType {
                    && nestedBool.mustNot().isEmpty()  
    }  
                target.filter(clause);
 *  
}
    }
        for (QueryBuilder clause : clauses) {
        // 1. The nested bool has the same properties as default (boost=1, no queryName, etc.)
        if (!(query instanceof BoolQueryBuilder boolQuery)) {
                    List<QueryBuilder> nestedClauses = getClausesForType(nestedBool, clauseType);
        if (hasFlattenableBool(boolQuery.must(), ClauseType.MUST)  
        for (QueryBuilder clause : boolQuery.mustNot()) {  
        }
    }  
 * this file be licensed under the Apache-2.0 license or a
        }
                        }  
                break;
                            nestedClause = flattenBoolQuery(nestedBoolQueryBuilder);
            if (clause instanceof BoolQueryBuilder boolQueryBuilder && needsFlattening(boolQueryBuilder)) {
                return true;
import java.util.List;
        flattened.adjustPureNegative(original.adjustPureNegative());
        // Never flatten under MUST_NOT to preserve semantics and avoid non-idempotent transforms  
                    // General flattening for same-clause-type nesting
        return "boolean_flattening";
        }
            || hasFlattenableBool(boolQuery.mustNot(), ClauseType.MUST_NOT)) {  
 * or must-in-must. This rewriter handles those additional patterns that are common in
