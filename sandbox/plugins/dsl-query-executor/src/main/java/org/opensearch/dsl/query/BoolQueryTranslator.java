    }
            && boolQuery.filter().isEmpty()
    private final QueryRegistry queryRegistry;
        }
            return ctx.getRexBuilder().makeLiteral(true);
        return RexUtil.composeConjunction(ctx.getRexBuilder(), conditions);
        BoolQueryBuilder boolQuery = (BoolQueryBuilder) query;
        throw new ConversionException(
/*
            conditions.add(queryRegistry.convert(filterClause, ctx));
 * (optional, disjunction, and conjunction respectively). Intermediate values (1 less-than k
        // filter), excluding rows whose field is missing. Lucene must_not INCLUDES those rows.
            RexNode shouldCondition = processShouldClauses(boolQuery, ctx);
 *
        int totalShould = shouldClauses.size();
                }
        List<QueryBuilder> shouldClauses = boolQuery.should();
 *
        // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.
        if (shouldConditions.isEmpty()) {
        // IS_NOT_TRUE(condition) returns TRUE when condition is NULL, preserving that semantics.
                + shouldConditions.size()
            RexNode condition = queryRegistry.convert(mustNotClause, ctx);
            return ctx.getRexBuilder().makeLiteral(false);
        }
import org.apache.calcite.rex.RexUtil;
        // exception routes the request to the codec / non-Calcite execution path once that lands.
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {
        boolean hasRequired = !boolQuery.must().isEmpty() || !boolQuery.filter().isEmpty();
 * returns FALSE literal for pure-negative bools with adjust_pure_negative=false (legacy match-none).
        // WHY this works for Lucene-delegated children: DelegatedRelevanceCallHelper declares a
            throw new ConversionException("Bool query does not support _name");
                // evaluation (a filter discards rows whose predicate is not TRUE).
        }
 * The OpenSearch Contributors require contributions made to
        //
import org.opensearch.dsl.converter.ConversionContext;
        if (requiredMatches == 0) {
        // Citation: BoolQueryBuilder.doToQuery:338 only calls fixNegativeQueryIfNeeded when
                conditions.add(ctx.getRexBuilder().makeCall(SqlStdOperatorTable.IS_NOT_TRUE, condition));
            } else {
                + requiredMatches
            if (shouldCondition != null) {
                    return ctx.getRexBuilder().makeLiteral(false);
                // Double-negation: IS_NOT_TRUE(IS_NOT_TRUE(x)) is equivalent to x under filter
        return BoolQueryBuilder.class;
                conditions.add(((RexCall) condition).getOperands().get(0));
        // MatchAllDocsQuery as FILTER.
    }
                if (shouldCondition.isAlwaysFalse()) {
    }
import java.util.List;
        for (QueryBuilder mustClause : boolQuery.must()) {
                + " (resolved minimum_should_match = "
    public BoolQueryTranslator(QueryRegistry queryRegistry) {
            return null;
        // clause to be prohibited. Citation: Queries.fixNegativeQueryIfNeeded:121-130 injects
        // non-nullable BOOLEAN return type, letting Calcite's ReduceExpressionsRule rewrite
        this.queryRegistry = queryRegistry;
import org.opensearch.index.query.AbstractQueryBuilder;
        if (requiredMatches > shouldConditions.size()) {
        if (boolQuery.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
        // WHY IS_NOT_TRUE: Under SQL three-valued logic NOT(NULL) evaluates to NULL (falsy in a
 * SPDX-License-Identifier: Apache-2.0
        }
                + ")"
        }
        }
            throw new ConversionException("Bool query does not support non-default boost");
 * this file be licensed under the Apache-2.0 license or a
        List<RexNode> shouldConditions = new ArrayList<>();
 * non-null _name (AbstractQueryBuilder.toQuery registers for matched_queries), and
            && !boolQuery.mustNot().isEmpty();
        List<RexNode> conditions = new ArrayList<>();
        }
 * <p>Supports minimum_should_match of 0, 1, and values at or above the should-clause count
public class BoolQueryTranslator implements QueryTranslator {
        // Legacy Lucene accepts MSM > shouldCount but matches nothing.
        }
import org.apache.calcite.rex.RexCall;
                + ", should clauses = "
        }
        }
        for (QueryBuilder filterClause : boolQuery.filter()) {
            return ctx.getRexBuilder().makeLiteral(false);
    @Override
                conditions.add(shouldCondition);
        if (requiredMatches == shouldConditions.size()) {
            }
            // Citation: BoolQueryBuilder.doRewrite line ~279.
        if (boolQuery.queryName() != null) {
import org.apache.calcite.rex.RexNode;
        // adjustPureNegative is true. Citation: Queries.isNegativeQuery:113-119 requires every
            shouldConditions.add(queryRegistry.convert(shouldClause, ctx));
        // IS_NOT_TRUE(call) to NOT(call), which the planner then recurses through.
        for (QueryBuilder shouldClause : shouldClauses) {
 *
        }
 * <p>Rejects non-default boost (AbstractQueryBuilder.toQuery wraps in BoostQuery),
        }
    @Override
package org.opensearch.dsl.query;
        int requiredMatches = MinimumShouldMatchParser.calculateRequiredMatches(minimumShouldMatch, totalShould, hasRequired);
            "Bool query does not support minimum_should_match between 1 and the number of should clauses"
    public Class<? extends QueryBuilder> getQueryType() {
    /** @return RexNode for should logic, FALSE if MSM is unsatisfiable, or null if optional */
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        if (isPureNegative && !boolQuery.adjustPureNegative()) {
import org.opensearch.dsl.converter.ConversionException;
            if (condition instanceof RexCall && ((RexCall) condition).getOperator() == SqlStdOperatorTable.IS_NOT_TRUE) {
        // Intermediate minimum_should_match (1 < k < n) has no flat AND/OR/NOT form; the
            }
            conditions.add(queryRegistry.convert(mustClause, ctx));
}
        String minimumShouldMatch = boolQuery.minimumShouldMatch();
 * compatible open source license.
            return RexUtil.composeConjunction(ctx.getRexBuilder(), shouldConditions);
        boolean isPureNegative = boolQuery.must().isEmpty()
    /** @throws ConversionException if boost or _name is non-default, or if nested conversion fails */
import java.util.ArrayList;
            return RexUtil.composeDisjunction(ctx.getRexBuilder(), shouldConditions);
import org.opensearch.index.query.BoolQueryBuilder;
 * Converts a {@link BoolQueryBuilder} to a Calcite {@link RexNode}.
        if (!boolQuery.should().isEmpty()) {
 * less-than n) are unsupported on this path and throw ConversionException.
    private RexNode processShouldClauses(BoolQueryBuilder boolQuery, ConversionContext ctx) throws ConversionException {
        );
        }
        }
        if (requiredMatches == 1) {
        for (QueryBuilder mustNotClause : boolQuery.mustNot()) {
            && boolQuery.should().isEmpty()
/**
 */
            return ctx.getRexBuilder().makeLiteral(false);
        if (requiredMatches > totalShould) {
import org.opensearch.index.query.QueryBuilder;
        if (conditions.isEmpty()) {
            return null;
    }
        }
        // Citation: AbstractQueryBuilder.toQuery lines 130-139 (boost wrapping + named query registration).
 */
