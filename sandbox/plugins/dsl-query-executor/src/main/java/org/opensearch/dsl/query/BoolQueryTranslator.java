 * this file be licensed under the Apache-2.0 license or a
        // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.
        if (isPureNegative && !boolQuery.adjustPureNegative()) {
        }
    /** @throws ConversionException if boost or _name is non-default, or if nested conversion fails */
        }
        }  
 * <p>Supports minimum_should_match of 0, 1, and values at or above the should-clause count
 * compatible open source license.
import org.opensearch.index.query.AbstractQueryBuilder;
 * returns FALSE literal for pure-negative bools with adjust_pure_negative=false (legacy match-none).
            if (condition instanceof RexCall && ((RexCall) condition).getOperator() == SqlStdOperatorTable.IS_NOT_TRUE) {
/**
            RexNode shouldCondition = processShouldClauses(boolQuery, ctx);
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        int requiredMatches = MinimumShouldMatchParser.calculateRequiredMatches(minimumShouldMatch, totalShould, hasRequired);
        BoolQueryBuilder boolQuery = (BoolQueryBuilder) query;
            } else {
            && !boolQuery.mustNot().isEmpty();  
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {
            shouldConditions.add(queryRegistry.convert(shouldClause, ctx));  
                + ", should clauses = "
 *
        throw new ConversionException(  
 * Converts a {@link BoolQueryBuilder} to a Calcite {@link RexNode}.  
 * less-than n) are unsupported on this path and throw ConversionException.
        if (conditions.isEmpty()) {
                }
            }
        if (requiredMatches > shouldConditions.size()) {
    @Override  
                + shouldConditions.size()
        String minimumShouldMatch = boolQuery.minimumShouldMatch();
 * (optional, disjunction, and conjunction respectively). Intermediate values (1 less-than k  
        // adjustPureNegative is true. Citation: Queries.isNegativeQuery:113-119 requires every  
}  
            return RexUtil.composeConjunction(ctx.getRexBuilder(), shouldConditions);  
    /** @return RexNode for should logic, FALSE if MSM is unsatisfiable, or null if optional */
        // Intermediate minimum_should_match (1 < k < n) has no flat AND/OR/NOT form; the
        return RexUtil.composeConjunction(ctx.getRexBuilder(), conditions);
        // Citation: BoolQueryBuilder.doToQuery:338 only calls fixNegativeQueryIfNeeded when
import java.util.List;  
        }  
import org.opensearch.dsl.converter.ConversionContext;
                + ")"  
                // evaluation (a filter discards rows whose predicate is not TRUE).  
        for (QueryBuilder shouldClause : shouldClauses) {
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexUtil;  
 *
        }
            }
            // Citation: BoolQueryBuilder.doRewrite line ~279.
        // exception routes the request to the codec / non-Calcite execution path once that lands.
import org.opensearch.dsl.converter.ConversionException;  
    private final QueryRegistry queryRegistry;  
        boolean hasRequired = !boolQuery.must().isEmpty() || !boolQuery.filter().isEmpty();
            "Bool query does not support minimum_should_match between 1 and the number of should clauses"
        }
import org.opensearch.index.query.BoolQueryBuilder;
        if (boolQuery.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
        }
            conditions.add(queryRegistry.convert(filterClause, ctx));  
    private RexNode processShouldClauses(BoolQueryBuilder boolQuery, ConversionContext ctx) throws ConversionException {  
            return ctx.getRexBuilder().makeLiteral(false);
                + " (resolved minimum_should_match = "
        // filter), excluding rows whose field is missing. Lucene must_not INCLUDES those rows.
 */  
        if (shouldConditions.isEmpty()) {  
            return ctx.getRexBuilder().makeLiteral(true);  
            return RexUtil.composeDisjunction(ctx.getRexBuilder(), shouldConditions);
    public Class<? extends QueryBuilder> getQueryType() {
            return ctx.getRexBuilder().makeLiteral(false);
            RexNode condition = queryRegistry.convert(mustNotClause, ctx);  
            && boolQuery.should().isEmpty()
 * The OpenSearch Contributors require contributions made to  
 *
                + requiredMatches  
import java.util.ArrayList;
            throw new ConversionException("Bool query does not support non-default boost");  
 * <p>Rejects non-default boost (AbstractQueryBuilder.toQuery wraps in BoostQuery),  
    public BoolQueryTranslator(QueryRegistry queryRegistry) {
package org.opensearch.dsl.query;
 * non-null _name (AbstractQueryBuilder.toQuery registers for matched_queries), and
            return null;
    }  
            return null;
        // WHY IS_NOT_TRUE: Under SQL three-valued logic NOT(NULL) evaluates to NULL (falsy in a
        // clause to be prohibited. Citation: Queries.fixNegativeQueryIfNeeded:121-130 injects
        List<RexNode> conditions = new ArrayList<>();
            return ctx.getRexBuilder().makeLiteral(false);
public class BoolQueryTranslator implements QueryTranslator {
            && boolQuery.filter().isEmpty()
import org.opensearch.index.query.QueryBuilder;  
        if (requiredMatches == 1) {  
        this.queryRegistry = queryRegistry;  
    }  
        // Legacy Lucene accepts MSM > shouldCount but matches nothing.
        // Citation: AbstractQueryBuilder.toQuery lines 130-139 (boost wrapping + named query registration).
        // non-nullable BOOLEAN return type, letting Calcite's ReduceExpressionsRule rewrite  
        for (QueryBuilder filterClause : boolQuery.filter()) {
        //
        }
        List<QueryBuilder> shouldClauses = boolQuery.should();
        if (requiredMatches > totalShould) {  
            conditions.add(queryRegistry.convert(mustClause, ctx));
        );
        int totalShould = shouldClauses.size();
        }
    }
        for (QueryBuilder mustClause : boolQuery.must()) {
        List<RexNode> shouldConditions = new ArrayList<>();
        }
import org.apache.calcite.rex.RexCall;
        // WHY this works for Lucene-delegated children: DelegatedRelevanceCallHelper declares a
        }  
        boolean isPureNegative = boolQuery.must().isEmpty()  
                conditions.add(ctx.getRexBuilder().makeCall(SqlStdOperatorTable.IS_NOT_TRUE, condition));  
        if (boolQuery.queryName() != null) {
        // IS_NOT_TRUE(call) to NOT(call), which the planner then recurses through.
                if (shouldCondition.isAlwaysFalse()) {  
/*  
            if (shouldCondition != null) {
        }
import org.apache.calcite.rex.RexNode;
                    return ctx.getRexBuilder().makeLiteral(false);
        // MatchAllDocsQuery as FILTER.
            throw new ConversionException("Bool query does not support _name");  
                conditions.add(shouldCondition);  
                conditions.add(((RexCall) condition).getOperands().get(0));
        // IS_NOT_TRUE(condition) returns TRUE when condition is NULL, preserving that semantics.  
    @Override  
        }
        for (QueryBuilder mustNotClause : boolQuery.mustNot()) {
                // Double-negation: IS_NOT_TRUE(IS_NOT_TRUE(x)) is equivalent to x under filter
        }
        if (!boolQuery.should().isEmpty()) {  
        if (requiredMatches == shouldConditions.size()) {
        return BoolQueryBuilder.class;
        }
        if (requiredMatches == 0) {  
 */  
