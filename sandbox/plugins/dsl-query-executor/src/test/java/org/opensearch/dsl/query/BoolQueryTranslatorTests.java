    public void testParseCombinationTrailingLessThanThrowsConversionException() {  
    }
        assertTrue(inner instanceof RexCall);
        assertEquals(
    }
            ctx
        // IS_NOT_TRUE(IS_NOT_TRUE(term)) → term
        // 2<75%: if total <= 2 match all; if total > 2 match 75%
 * The OpenSearch Contributors require contributions made to  
        assertMidBandRejected(ex, 3, 5);
        assertEquals(SqlKind.IS_NOT_TRUE, call.getKind());  
            List.of(rexBuilder.makeInputRef(typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true), 0))  
import org.opensearch.index.query.QueryBuilder;
        );  
        RexNode resultWithFlag = translator.convert(queryWithFlag, ctx);
        RexCall call = (RexCall) result;
            nonNullableBoolType,
    }  
                ),
                .must(QueryBuilders.termQuery("name", "required"))
        // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.  
    }
        assertTrue("Message must name the offending field", ex.getMessage().contains("created_date"));
        RexCall call = (RexCall) result;
                .mustNot(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("brand", "wanted"))),
    }  
            .filter(QueryBuilders.termQuery("name", "active"))
        RexCall cast = (RexCall) eq.getOperands().get(1);
            ConversionException.class,  
    public void testMsmMidBandCombinationSpecThrows() {
                .should(QueryBuilders.termQuery("name", "a"))  
    public void testNestedBoolQueryFlattening() throws ConversionException {
    }
        // n=3, k=1 → disjunction (supported)  
        // Pins: must_not wraps nullable child in IS_NOT_TRUE (not NOT) to preserve  
        assertEquals(SqlKind.AND, ((RexCall) result).getKind());
import org.apache.calcite.sql.type.SqlTypeName;
        int result = MinimumShouldMatchParser.calculateRequiredMatches("200%", 3, false);  
        RexCall call = (RexCall) result;
        assertEquals(2, call.getOperands().size());
        RexCall call = (RexCall) result;  
        assertEquals(0, ((RexInputRef) eq0.getOperands().get(0)).getIndex());
            QueryBuilders.boolQuery()
            SqlStdOperatorTable.IS_NOT_NULL,
        );
            ctx  
        QueryRegistry stubRegistry = new QueryRegistry();  
            QueryBuilders.boolQuery().mustNot(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "value"))),  
        var rexBuilder = ctx.getRexBuilder();
        // Citation: BoolQueryBuilder.doRewrite line ~279 and doToQuery line 333.  
        assertEquals(2, call.getOperands().size());
    // --- must_not contract tests: IS_NOT_TRUE emission regardless of nullability ---
        );
        assertEquals(SqlKind.EQUALS, call.getKind());
        RexNode result = translator.convert(  
            ctx
        assertTrue(result instanceof RexCall);
        assertTrue("Message must name the should-clause count", ex.getMessage().contains("should clauses = " + shouldClauses));
        assertMidBandRejected(ex, 3, 4);
        assertEquals("MSM exceeding totalShould must be returned as-is (> totalShould signals match-none)", 5, result);
        // adjustPureNegative=true (default) → IS_NOT_TRUE conditions.
        RexCall call = (RexCall) result;
    }  
    }
        assertTrue(result instanceof RexCall);
                .minimumShouldMatch("2<75%"),
        assertEquals(SqlKind.AND, call.getKind());  
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));
    }  
        assertMidBandRejected(ex, 3, 4);
        RexNode inner = call.getOperands().get(0);
        // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.  
        RexNode resultDefault = translator.convert(queryDefault, ctx);  
            .mustNot(QueryBuilders.termQuery("brand", "excluded"));
        assertTrue(result instanceof RexCall);
    // --- MSM result clamping tests ---
    }  
            ctx
                .should(QueryBuilders.termQuery("name", "a"))
    }
        assertTrue("Boolean literal must be TRUE", literal.getValueAs(Boolean.class));
                .should(QueryBuilders.termQuery("name", "b"))  
        assertEquals(SqlKind.AND, call.getKind());
    // --- Should-gate local branch tests ---  
        assertTrue(result instanceof RexCall);
        assertTrue("Message must identify date fields", ex.getMessage().toLowerCase(Locale.ROOT).contains("date field"));  
            resultWithFlag.toString()
            ctx
    private static BoolQueryBuilder shouldQuery(int n, String msm) {
        RexCall eq0 = (RexCall) and.getOperands().get(0);  
                .must(QueryBuilders.termQuery("name", "keep"))
                .must(QueryBuilders.termQuery("price", 999))
                .should(QueryBuilders.termQuery("name", "a"))
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "-25%"), ctx));
                    QueryBuilders.boolQuery().must(QueryBuilders.termQuery("brand", "value2")).must(QueryBuilders.termQuery("rating", 3.0))
import org.apache.calcite.rex.RexInputRef;
        assertFalse("Operand type must be non-nullable BOOLEAN", inner.getType().isNullable());
public class BoolQueryTranslatorTests extends OpenSearchTestCase {
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(5, "3"), ctx));
        RexCall call = (RexCall) result;
        // Inner must_not emits IS_NOT_TRUE(term2); outer must_not unwraps → AND(term1, term2).
        // n=3, k=2 → first mid-band value above the OR boundary
                        .should(
        assertEquals(SqlKind.EQUALS, eq.getKind());
        );
        // Pins: must_not emits IS_NOT_TRUE so missing-field rows (NULL) are retained.
    private final QueryRegistry registry = QueryRegistryFactory.create();
        assertEquals(SqlKind.EQUALS, eq.getKind());
        RexNode result = translator.convert(  
        assertTrue("MSM exceeding should-count must produce FALSE literal (match-none)", result instanceof RexLiteral);
        assertTrue("MSM exceeding should-count must produce FALSE literal", result instanceof RexLiteral);
                .should(QueryBuilders.termQuery("name", "b"))  
    public void testMsmUpperBoundaryK4SucceedsAsAnd() throws ConversionException {
        assertTrue(result instanceof RexCall);
    }
        assertEquals(BoolQueryBuilder.class, translator.getQueryType());
        assertEquals(SqlKind.EQUALS, ((RexCall) call.getOperands().get(1)).getKind());
                .minimumShouldMatch("1"),  
        assertEquals(SqlKind.OR, call.getKind());
        RexLiteral literal = (RexLiteral) cast.getOperands().get(0);
        assertTrue("Message must contain the offending value", ex.getMessage().contains("abc"));  
    public void testNestedShouldQueryFlattening() throws ConversionException {  
        RexNode result = translator.convert(
                .should(
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")).queryName("my_bool");
    public void testAdjustPureNegativeDefaultTruePureNegativeProducesNot() throws ConversionException {
        RexCall call = (RexCall) result;
    }
        assertEquals(2, fieldRef.getIndex());
        // "5<" is malformed — legacy throws ArrayIndexOutOfBoundsException.
    public void testEmptyBoolProducesTrueLiteral() throws ConversionException {
    public void testMustNotEmitsIsNotTrueForNonNullableBooleanChild() throws ConversionException {  
import java.util.List;
    }
            QueryBuilders.boolQuery()
            assertEquals(SqlKind.IS_NOT_TRUE, ((RexCall) operand).getKind());
        RexNode result = translator.convert(
            QueryBuilders.boolQuery()  
        RexLiteral lit0 = (RexLiteral) ((RexCall) eq0.getOperands().get(1)).getOperands().get(0);  
        // n=5, msm="3" → resolved k=3 (1 < 3 < 5)  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexCall call = (RexCall) result;
        // n=4, msm="2<75%" → total>2 so 75% of 4 = 3 (1 < 3 < 4)  
            QueryBuilders.boolQuery()
    public void testMsmLargeNNoThresholdThrows() {  
        // MSM > shouldConditions.size() → unsatisfiable → FALSE
        assertMidBandRejected(ex, 2, 3);
    // Edge cases
            ConversionException.class,
        assertTrue(result instanceof RexCall);  
            ctx
        RexNode result = translator.convert(
        stubRegistry.register(new QueryTranslator() {
        assertMidBandRejected(ex, 2, 3);
    }
    public void testMsmUpperBoundaryK3Throws() {
        assertTrue("MSM exceeding should-count must produce FALSE literal even with must", result instanceof RexLiteral);
            ctx  
            ctx
        assertEquals(5, ((RexInputRef) eq2.getOperands().get(0)).getIndex());
    }
                .mustNot(QueryBuilders.termQuery("brand", "excluded2")),
            QueryBuilders.boolQuery()
        // n=4, msm="70%" → floor(2.8)=2 (1 < 2 < 4)  
        ConversionException ex = expectThrows(
import org.opensearch.index.query.QueryBuilders;
    // --- Nested bool recursion with isFlat assertion ---  
                .should(QueryBuilders.termQuery("name", "a"))
 *
                .should(QueryBuilders.termQuery("name", "a"))
            resultWithFlag.toString()  
    }
        assertEquals("laptop", lit0.getValueAs(String.class));
        });
        );  
        );
            () -> MinimumShouldMatchParser.calculateRequiredMatches("abc", 3, false)  
        RexNode result = translator.convert(
            query.should(QueryBuilders.termQuery("name", "val" + i));
                .should(QueryBuilders.termQuery("brand", "high"))  
        assertTrue(result instanceof RexCall);
            public RexNode convert(QueryBuilder query, ConversionContext ctx) {
    public void testMinimumShouldMatchInteger1() throws ConversionException {
        // Citation: Queries.isNegativeQuery:113-119.  
        // "200%" with 3 clauses → floor(6) > 3 → raw value returned; convert() handles match-none.
package org.opensearch.dsl.query;
        for (int i = 0; i < n; i++) {  
            ConversionException.class,
        );  
            QueryBuilders.boolQuery()
    public void testShouldWithMustAndMinimumShouldMatch() throws ConversionException {
    // minimum_should_match: Single combination
        );  
        RexLiteral lit1 = (RexLiteral) ((RexCall) eq1.getOperands().get(1)).getOperands().get(0);  
    public void testShouldWithMustClause() throws ConversionException {
    public void testAdjustPureNegativeFalseMustPlusMustNotAccepted() throws ConversionException {
        assertNotNull(result);  
                .should(QueryBuilders.termQuery("name", "b"))
        RexLiteral literal = (RexLiteral) cast.getOperands().get(0);
        assertTrue(result instanceof RexCall);
        return query.minimumShouldMatch(msm);  
    public void testParseIntegerInvalidThrowsConversionExceptionWithValue() {  
    }  
    public void testMustNotClause() throws ConversionException {  
        assertTrue("must_not on nullable child must emit IS_NOT_TRUE", result instanceof RexCall);
    }
            ctx  
        assertEquals(2, call.getOperands().size());  
        }
        ConversionException ex = expectThrows(  
                .should(QueryBuilders.termQuery("name", "c"))
        BoolQueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.matchAllQuery());
        BoolQueryBuilder queryDefault = QueryBuilders.boolQuery()
        assertEquals(SqlKind.IS_NOT_TRUE, call.getKind());  
    public void testDoubleNegationElimination() throws ConversionException {  
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));
    public void testCalculateRequiredMatchesNotClampedWhenWithinRange() throws ConversionException {
        assertEquals(SqlKind.EQUALS, eq1.getKind());
        assertTrue("brand field must be nullable in test schema", fieldRef.getType().isNullable());  
    public void testMsmMidBandNegativePercentageThrows() {
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("created_date", 19738));  
    }
        // adjustPureNegative=true (default) → table scan is the implicit match-all → IS_NOT_TRUE.  
    // --- MSM exceeding should-count: legacy matches nothing ---
                .mustNot(QueryBuilders.termQuery("name", "deleted"))
        RexNode result = translator.convert(
            resultDefault.toString(),
        RexNode result = stubTranslator.convert(query, ctx);  
                    QueryBuilders.boolQuery()  
    public void testQueryNameThrowsConversionException() {  
        RexCall call = (RexCall) result;  
    }  
        assertTrue("must_not must emit IS_NOT_TRUE", result instanceof RexCall);
            ctx
            ctx
        assertTrue("Message must name the resolved minimum_should_match", ex.getMessage().contains("minimum_should_match = " + resolvedK));
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "2<75%"), ctx));
    public void testBoolMustMixedTypesPreservesAllLiteralsInOrder() throws ConversionException {
        assertEquals(SqlKind.OR, ((RexCall) result).getKind());  
    }  
        assertEquals(SqlKind.EQUALS, call.getKind());  
import org.opensearch.index.query.BoolQueryBuilder;  
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "3"), ctx));  
            }
        assertTrue("Message must contain the offending value", ex.getMessage().contains("abc"));
            ctx
            ctx  
        assertEquals(5, ((RexInputRef) eq.getOperands().get(0)).getIndex());  
    public void testMustNotEmitsIsNotTrueForNullableChild() throws ConversionException {
        int result = MinimumShouldMatchParser.calculateRequiredMatches("5", 3, false);
    // minimum_should_match: Non-negative integer  
        // n=4, k=3 → last mid-band value below the AND boundary
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(20, "10"), ctx));
        BoolQueryBuilder queryDefault = QueryBuilders.boolQuery()
    }
    public void testCalculateRequiredMatchesPercentageClampedAboveTotal() throws ConversionException {
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery("name", "test1")).should(QueryBuilders.termQuery("name", "test2")),
        assertEquals("MSM within valid range should not be clamped", 2, result);
        assertMidBandRejected(ex, 10, 20);  
    }
    public void testParsePercentageInvalidThrowsConversionExceptionWithValue() {
        RexNode result = translator.convert(
        RexNode result = translator.convert(QueryBuilders.boolQuery(), ctx);
    }
        RexNode result = translator.convert(  
        RexNode inner = ((RexCall) result).getOperands().get(0);
                ),
        assertFalse("Boolean literal must be FALSE", lit2.getValueAs(Boolean.class));
            QueryBuilders.boolQuery()  
    }
        assertTrue("Pure-negative with default adjustPureNegative must produce IS_NOT_TRUE", result instanceof RexCall);  
            QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "test")).adjustPureNegative(false),
        // n=20, msm="10" → mid-band; proves no leaf-occurrence cap survives to admit/limit this
            QueryBuilders.boolQuery()
    public void testMsmExceedingShouldCountProducesMatchNone() throws ConversionException {
        RexNode result = translator.convert(shouldQuery(4, "4"), ctx);  
    private final BoolQueryTranslator translator = new BoolQueryTranslator(registry);
            () -> MinimumShouldMatchParser.calculateRequiredMatches("xyz%", 3, false)
    }
    public void testCalculateRequiredMatchesClampedToTotalWhenExceedsTotal() throws ConversionException {
    }
    public void testDefaultBoostAccepted() throws ConversionException {
        );
                .minimumShouldMatch("1"),
        RexCall eq1 = (RexCall) and.getOperands().get(1);  
        );
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));
        assertTrue(result instanceof RexCall);
        assertTrue("Message must mention _name", ex.getMessage().contains("_name"));
            resultDefault.toString(),
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")).boost(2.0f);  
        assertTrue(result instanceof RexCall);
    }
                ),
                .must(QueryBuilders.termQuery("name", "required"))  
        RexNode result = translator.convert(
    // --- Empty bool and pure-negative ---  
                .must(QueryBuilders.termQuery("is_active", false)),  
        assertEquals(3, ((RexCall) result).getOperands().size());  
            resultDefault.toString(),  
                        )  
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")).boost(1.0f), ctx);
        assertTrue(result instanceof RexCall);  
            QueryBuilders.boolQuery()  
                .should(QueryBuilders.termQuery("name", "b"))
    public void testReportsCorrectQueryType() {
        assertNotNull(result);  
            .should(QueryBuilders.termQuery("name", "b"))
/*  
        // "-10" with 3 clauses → 3+(-10)=-7 → clamp to 0
        );
    public void testMinimumShouldMatchCombination2Less75Percent() throws ConversionException {
            public Class<? extends QueryBuilder> getQueryType() {  
            ctx
        // Pins contract with DelegatedRelevanceCallHelper: non-nullable BOOLEAN child under
        RexNode result = translator.convert(shouldQuery(3, "1"), ctx);
                .should(QueryBuilders.termQuery("name", "c"))
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(3, "-1"), ctx));
            .adjustPureNegative(false);
    public void testMsmLowerBoundaryK1SucceedsAsOr() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "test")), ctx);
        assertEquals(SqlKind.EQUALS, ((RexCall) inner).getKind());  
        ConversionException ex = expectThrows(
        for (RexNode operand : call.getOperands()) {  
    public void testComplexBoolQuery() throws ConversionException {
        );
            QueryBuilders.boolQuery()
                .should(QueryBuilders.termQuery("brand", "b"))
        RexNode result = translator.convert(  
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
            .mustNot(QueryBuilders.termQuery("brand", "excluded"))
            ctx  
            .must(QueryBuilders.termQuery("name", "keep"))
        assertEquals(2, call.getOperands().size());  
    }  
        // the translator must emit IS_NOT_TRUE unconditionally.  
            .filter(QueryBuilders.termQuery("name", "active"))  
        assertEquals(SqlKind.AND, ((RexCall) result).getKind());
        RexNode resultWithFlag = translator.convert(queryWithFlag, ctx);  
import org.apache.calcite.rex.RexLiteral;  
        // Citation: Queries.fixNegativeQueryIfNeeded lines 111-121.  
        RexCall call = (RexCall) result;
        assertTrue("Message must mention the spec", ex.getMessage().contains("5<"));  
        assertEquals(SqlKind.IS_NOT_TRUE, ((RexCall) result).getKind());  
        RexNode result = translator.convert(
                .must(  
        assertEquals(SqlKind.AND, call.getKind());
        // "5" with 3 clauses → 5 > 3 → raw value returned; convert() handles match-none.
        RexNode resultDefault = translator.convert(queryDefault, ctx);
        BoolQueryBuilder queryDefault = QueryBuilders.boolQuery()  
    public void testAdjustPureNegativeFalseFilterPlusMustNotAccepted() throws ConversionException {  
        // should-only is not pure-negative, so adjustPureNegative=false is a no-op.
        // Citation: BoolQueryBuilder.doToQuery:338, Queries.isNegativeQuery:113-119.  
                .must(QueryBuilders.termQuery("name", "active"))
        RexNode result = translator.convert(
    }
        RexCall call = (RexCall) result;
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));  
    }
            "should-only with adjustPureNegative=false must equal default-true result",  
    }  
        RexCall call = (RexCall) result;
        assertEquals(3, and.getOperands().size());
        RexInputRef fieldRef = (RexInputRef) ((RexCall) inner).getOperands().get(0);
        // adjustPureNegative=false is a no-op when must clauses exist.
    public void testPureNegativeBoolProducesNot() throws ConversionException {
    }  
    public void testMsmMidBandAbsoluteIntThrows() {
        );
                .minimumShouldMatch("1"),
                .mustNot(QueryBuilders.termQuery("name", "excluded1"))  
import org.apache.calcite.rex.RexCall;
        RexLiteral lit2 = (RexLiteral) ((RexCall) eq2.getOperands().get(1)).getOperands().get(0);  
    public void testBoolMustWithDateChildPropagatesRejection() {
            "must+must_not with adjustPureNegative=false must equal default-true result",
        // n=4, k=4 → conjunction (supported)
        assertEquals(3, call.getOperands().size());  
    public void testShouldGateOverLargeProducesFalse() throws ConversionException {  
    // --- Parameter audit: boost, _name, adjustPureNegative ---
            () -> MinimumShouldMatchParser.calculateRequiredMatches("abc<75%", 3, false)
                .should(QueryBuilders.termQuery("name", "b"))
        );
        ConversionException ex = expectThrows(
        );
    public void testNestedMustNotDoubleNegationWithMultipleClauses() throws ConversionException {  
        );
        );
        );
    public void testCalculateRequiredMatchesClampedToTotalProducesAnd() throws ConversionException {
    }
            .mustNot(QueryBuilders.termQuery("brand", "excluded"))  
    public void testBoolMustWithBooleanChildPreservesBooleanLiteral() throws ConversionException {  
            .must(QueryBuilders.termQuery("name", "keep"))  
        assertTrue("Message must mention boost", ex.getMessage().contains("boost"));  
        assertEquals(1, ((RexInputRef) eq1.getOperands().get(0)).getIndex());
            }
    }  
import org.apache.calcite.rex.RexNode;
        // n=4, msm="-25%" → miss floor(1.0)=1, so 4-1=3 (1 < 3 < 4)  
                .minimumShouldMatch("5"),  
        BoolQueryBuilder queryWithFlag = QueryBuilders.boolQuery()
        RexCall call = (RexCall) result;  
            .should(QueryBuilders.termQuery("name", "a"))
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(3, "2"), ctx));  
        // Citation: AbstractQueryBuilder.toQuery registers named query for matched_queries response.
import org.opensearch.dsl.TestUtils;  
import org.opensearch.dsl.converter.ConversionContext;
        );
                .should(QueryBuilders.termQuery("brand", "a"))
        assertEquals(SqlKind.EQUALS, call.getKind());
        assertFalse("Precondition: type must be non-nullable", nonNullableBoolType.isNullable());
            .should(QueryBuilders.termQuery("name", "a"))
    }  
        assertEquals(4, ((RexCall) result).getOperands().size());  
        assertEquals(1, ((RexInputRef) eq.getOperands().get(0)).getIndex());
        assertTrue(result instanceof RexCall);
    }  
    }
        assertSame("Wrapped operand must be the injected non-nullable node", syntheticChild, inner);  
                .should(QueryBuilders.termQuery("name", "a"))
    public void testShouldClauseWithoutMust() throws ConversionException {  
            assertTrue(operand instanceof RexCall);
        RexNode result = translator.convert(
        RexCall eq2 = (RexCall) and.getOperands().get(2);  
        RexNode syntheticChild = rexBuilder.makeCall(  
    }  
        RexCall call = (RexCall) result;  
        assertEquals(SqlTypeName.INTEGER, literal.getType().getSqlTypeName());
        assertEquals(3, call.getOperands().size());  
        RexNode result = translator.convert(
    public void testShouldGateExactEqualProducesAnd() throws ConversionException {
                        .should(QueryBuilders.termQuery("rating", 3.0))
        var nonNullableBoolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
        );
                return syntheticChild;  
            QueryBuilders.boolQuery()  
        assertEquals(3, ((RexCall) result).getOperands().size());
        );  
    public void testParseCombinationInvalidThresholdThrowsConversionException() {
            .mustNot(QueryBuilders.termQuery("brand", "excluded"));
        int result = MinimumShouldMatchParser.calculateRequiredMatches("2", 3, false);  
            ctx
import java.util.Locale;  
        assertEquals(SqlKind.EQUALS, ((RexCall) call.getOperands().get(0)).getKind());
        assertTrue("Over-large MSM must produce FALSE literal", result instanceof RexLiteral);
        assertTrue("Empty bool must produce TRUE literal (match-all)", result instanceof RexLiteral);  
        assertEquals(3, call.getOperands().size());
    public void testCalculateRequiredMatchesClampedToZeroMakesShouldOptional() throws ConversionException {
    public void testBoolMustWithNumericChildPreservesIntegerLiteral() throws ConversionException {
        assertTrue(result instanceof RexCall);
            @Override
                return org.opensearch.index.query.MatchAllQueryBuilder.class;
    }
import org.opensearch.test.OpenSearchTestCase;  
            QueryBuilders.boolQuery()
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("is_active", true)), ctx);
        assertTrue(result instanceof RexCall);  
        assertEquals("Percentage exceeding 100% returns raw computed value (> totalShould signals match-none)", 6, result);
        );
                    QueryBuilders.boolQuery()
    public void testAdjustPureNegativeFalseShouldOnlyAccepted() throws ConversionException {
import org.apache.calcite.rex.RexUtil;
        // Lucene's "include missing-field rows" semantics under SQL three-valued logic.
            QueryBuilders.boolQuery()
        assertEquals(SqlTypeName.BOOLEAN, literal.getType().getSqlTypeName());  
 * this file be licensed under the Apache-2.0 license or a
 */  
        // Citation: AbstractQueryBuilder.toQuery wraps result in BoostQuery when boost != 1.0f.
                .minimumShouldMatch("3"),  
        assertEquals(  
            .should(QueryBuilders.termQuery("name", "b"));  
        // Should clauses are optional when must is present (no minimum_should_match)  
        assertEquals(
        RexNode result = translator.convert(
            QueryBuilders.boolQuery()  
            resultWithFlag.toString()
    }
        assertTrue("Pure-negative with adjustPureNegative=false must produce FALSE literal", result instanceof RexLiteral);  
    }
    }  
        assertMidBandRejected(ex, 3, 4);
        // must_not must be wrapped in IS_NOT_TRUE. Calcite may later rewrite to NOT(x), but
                .must(
            ctx  
    }  
    private final ConversionContext ctx = TestUtils.createContext();  
        // filter+must_not is not pure-negative, so adjustPureNegative=false is a no-op.
        // total=2 so all required → AND
                .should(QueryBuilders.termQuery("brand", "medium"))
    public void testMustClause() throws ConversionException {
            QueryBuilders.boolQuery()  
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")), ctx);
        BoolQueryBuilder queryWithFlag = QueryBuilders.boolQuery()  
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(  
import org.apache.calcite.sql.SqlKind;  
    }  
                .must(QueryBuilders.termQuery("name", "value1"))
                        .should(QueryBuilders.termQuery("rating", 3.0))
    private static void assertMidBandRejected(ConversionException ex, int resolvedK, int shouldClauses) {  
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
            QueryBuilders.boolQuery()
        RexNode resultDefault = translator.convert(queryDefault, ctx);
        int result = MinimumShouldMatchParser.calculateRequiredMatches("-10", 3, false);  
    // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.
import org.opensearch.dsl.converter.ConversionException;
        RexCall cast = (RexCall) eq.getOperands().get(1);  
    // Basic bool query tests
                .should(QueryBuilders.termQuery("name", "b"))  
    }
    public void testMsmMidBandNegativeIntThrows() {
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
        assertFalse("Must be boolean FALSE", RexLiteral.booleanValue(result));
        RexCall call = (RexCall) result;  
    // --- minimum_should_match mid-band rejection (1 < k < n is unsupported on this path) ---
        );
            .adjustPureNegative(false);
        assertEquals(Integer.valueOf(42), literal.getValueAs(Integer.class));  
        assertEquals(SqlKind.AND, and.getKind());  
        );  
        // MSM > shouldCount → legacy matches nothing → FALSE literal.
    public void testMsmExceedingShouldCountWithMustProducesMatchNone() throws ConversionException {  
                .minimumShouldMatch("5"),
        RexNode result = translator.convert(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("brand", "excluded")), ctx);
            () -> MinimumShouldMatchParser.calculateRequiredMatches("5<", 6, false)
        assertTrue(result instanceof RexCall);  
        );
        assertMidBandRejected(ex, 2, 4);
        );
    }
            .adjustPureNegative(false);  
                .must(QueryBuilders.termQuery("name", "required"))  
        assertEquals(SqlKind.AND, call.getKind());
            ctx
        RexCall eq = (RexCall) result;  
                .must(QueryBuilders.termQuery("name", "required"))
        }  
        assertEquals(SqlKind.OR, call.getKind());
                .should(QueryBuilders.termQuery("name", "a"))
            QueryBuilders.boolQuery()
                .minimumShouldMatch("5"),  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(SqlKind.EQUALS, eq2.getKind());
                .minimumShouldMatch("-10"),
                .should(QueryBuilders.termQuery("name", "b"))
            ctx
        RexNode result = translator.convert(
    }
        RexNode result = translator.convert(
    }
        );  
        // n=3, msm="-1" → 3-1=2 (1 < 2 < 3)  
        // Bool composition propagates a child translator's rejection rather than swallowing it.
    // --- Data-type variety: bool composition preserves child literal typing ---  
        RexNode result = translator.convert(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "test")), ctx);
}
            @Override
    // --- Parser hardening: NumberFormatException wrapping ---
                .should(QueryBuilders.termQuery("brand", "a"))
        assertEquals(SqlKind.EQUALS, call.getKind());  
        // MSM="3" with 3 should → requiredMatches==size → AND  
        BoolQueryBuilder queryWithFlag = QueryBuilders.boolQuery()
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(
                            QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "a")).must(QueryBuilders.termQuery("brand", "b"))
            "filter+must_not with adjustPureNegative=false must equal default-true result",
        RexCall and = (RexCall) result;
        assertTrue("Exact-equal gate must produce AND", result instanceof RexCall);
        assertTrue("Must be boolean TRUE", RexLiteral.booleanValue(result));
                .should(QueryBuilders.termQuery("brand", "c"))  
                        .should(QueryBuilders.termQuery("brand", "value2"))  
        assertEquals("Negative MSM result must be clamped to 0", 0, result);
    public void testNestedBoolInShouldInMustIsFlat() throws ConversionException {
        assertEquals(SqlTypeName.BOOLEAN, inner.getType().getSqlTypeName());
                .should(QueryBuilders.termQuery("name", "a"))  
    }
        assertTrue(result instanceof RexCall);  
    }
                .should(QueryBuilders.termQuery("name", "value1"))  
    }
        BoolQueryTranslator stubTranslator = new BoolQueryTranslator(stubRegistry);  
        RexCall eq = (RexCall) result;
    public void testNonDefaultBoostThrowsConversionException() {
        assertTrue("Message must contain the offending value", ex.getMessage().contains("xyz"));
                .must(QueryBuilders.termQuery("name", "laptop"))
    }  
    public void testAdjustPureNegativeFalsePureNegativeReturnsFalseLiteral() throws ConversionException {
        assertEquals(SqlKind.EQUALS, eq0.getKind());
                .should(QueryBuilders.termQuery("name", "b")),  
            ConversionException.class,  
        assertTrue(result instanceof RexCall);  
    public void testMsmLowerBoundaryK2Throws() {
        assertEquals(SqlKind.IS_NOT_TRUE, ((RexCall) result).getKind());
                .should(QueryBuilders.termQuery("name", "c"))  
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("price", 42)), ctx);  
    }
        assertEquals(Integer.valueOf(999), lit1.getValueAs(Integer.class));
        var typeFactory = rexBuilder.getTypeFactory();
        RexNode resultWithFlag = translator.convert(queryWithFlag, ctx);
                .minimumShouldMatch("5"),  
    }
        assertEquals(2, call.getOperands().size());
        );  
                .should(QueryBuilders.termQuery("brand", "b"))
    public void testCalculateRequiredMatchesClampedToZeroWhenNegativeResult() throws ConversionException {
        assertTrue("Nested bool composition must produce flat RexNode", RexUtil.isFlat(result));
        assertEquals(SqlKind.AND, call.getKind());
            ctx
        // "-10" on 3 should → result=-7 → clamp to 0 → should optional  
    public void testMsmMidBandPercentageThrows() {
 * compatible open source license.
        assertEquals(SqlKind.AND, call.getKind());
        assertEquals(SqlKind.OR, call.getKind());
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "70%"), ctx));
