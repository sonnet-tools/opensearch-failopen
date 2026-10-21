    // --- Parser hardening: NumberFormatException wrapping ---
    }
        // Pins: must_not wraps nullable child in IS_NOT_TRUE (not NOT) to preserve
                .should(QueryBuilders.termQuery("name", "c"))
                            QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "a")).must(QueryBuilders.termQuery("brand", "b"))
    }
 * The OpenSearch Contributors require contributions made to
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("created_date", 19738));
        assertEquals(SqlKind.IS_NOT_TRUE, ((RexCall) result).getKind());
        }
                .minimumShouldMatch("-10"),
        // total=2 so all required → AND
            ctx
            ConversionException.class,
import org.apache.calcite.rex.RexCall;
        RexCall call = (RexCall) result;
    public void testMinimumShouldMatchInteger1() throws ConversionException {
}
                .should(QueryBuilders.termQuery("name", "c"))
        assertEquals(SqlKind.AND, call.getKind());
        RexNode result = translator.convert(
public class BoolQueryTranslatorTests extends OpenSearchTestCase {
    public void testMsmMidBandAbsoluteIntThrows() {
                .should(
        );
    public void testMinimumShouldMatchCombination2Less75Percent() throws ConversionException {
import org.apache.calcite.sql.type.SqlTypeName;
            ctx
                .should(QueryBuilders.termQuery("brand", "c"))
        // n=3, k=1 → disjunction (supported)
    // --- minimum_should_match mid-band rejection (1 < k < n is unsupported on this path) ---
        assertTrue(result instanceof RexCall);
            ctx
        assertEquals(1, ((RexInputRef) eq.getOperands().get(0)).getIndex());
        assertEquals(SqlKind.OR, call.getKind());
    public void testMsmLargeNNoThresholdThrows() {
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
 * SPDX-License-Identifier: Apache-2.0
                        .should(
    }
        );
            QueryBuilders.boolQuery()
    }
        RexCall eq0 = (RexCall) and.getOperands().get(0);
        assertTrue(result instanceof RexCall);
        RexCall call = (RexCall) result;
        assertTrue("Pure-negative with adjustPureNegative=false must produce FALSE literal", result instanceof RexLiteral);
            .mustNot(QueryBuilders.termQuery("brand", "excluded"));
        });
                .mustNot(QueryBuilders.termQuery("name", "excluded1"))
        );
        assertTrue(result instanceof RexCall);
            QueryBuilders.boolQuery()
        RexCall call = (RexCall) result;
            QueryBuilders.boolQuery()
        // "5" with 3 clauses → 5 > 3 → raw value returned; convert() handles match-none.
        assertTrue("MSM exceeding should-count must produce FALSE literal", result instanceof RexLiteral);
        assertEquals(1, ((RexInputRef) eq1.getOperands().get(0)).getIndex());
        // n=4, k=3 → last mid-band value below the AND boundary
                .should(QueryBuilders.termQuery("name", "a"))
    public void testMustNotEmitsIsNotTrueForNonNullableBooleanChild() throws ConversionException {
        RexCall call = (RexCall) result;
    public void testReportsCorrectQueryType() {
        BoolQueryTranslator stubTranslator = new BoolQueryTranslator(stubRegistry);
        assertTrue("Nested bool composition must produce flat RexNode", RexUtil.isFlat(result));
        // Inner must_not emits IS_NOT_TRUE(term2); outer must_not unwraps → AND(term1, term2).
        RexCall call = (RexCall) result;
    }
    public void testParseCombinationTrailingLessThanThrowsConversionException() {
        assertTrue(result instanceof RexCall);
        RexCall eq = (RexCall) result;
    public void testMsmMidBandNegativeIntThrows() {
/*
        // Citation: AbstractQueryBuilder.toQuery registers named query for matched_queries response.
            .should(QueryBuilders.termQuery("name", "a"))
    }
        // n=3, msm="-1" → 3-1=2 (1 < 2 < 3)
        assertEquals(SqlKind.OR, call.getKind());
            QueryBuilders.boolQuery()
        assertTrue("Message must contain the offending value", ex.getMessage().contains("abc"));
        assertTrue("Pure-negative with default adjustPureNegative must produce IS_NOT_TRUE", result instanceof RexCall);
        // n=20, msm="10" → mid-band; proves no leaf-occurrence cap survives to admit/limit this
        assertEquals(SqlKind.EQUALS, call.getKind());
        assertFalse("Boolean literal must be FALSE", lit2.getValueAs(Boolean.class));
        // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(5, "3"), ctx));
    }
        RexNode result = translator.convert(
            QueryBuilders.boolQuery()
        // MSM > shouldConditions.size() → unsatisfiable → FALSE
    public void testDefaultBoostAccepted() throws ConversionException {
            nonNullableBoolType,
    private static void assertMidBandRejected(ConversionException ex, int resolvedK, int shouldClauses) {
        );
import org.apache.calcite.rex.RexNode;
        assertNotNull(result);
        assertFalse("Must be boolean FALSE", RexLiteral.booleanValue(result));
    // --- must_not contract tests: IS_NOT_TRUE emission regardless of nullability ---
        RexLiteral lit0 = (RexLiteral) ((RexCall) eq0.getOperands().get(1)).getOperands().get(0);
            ctx
                .minimumShouldMatch("5"),
            public Class<? extends QueryBuilder> getQueryType() {
        assertEquals(5, ((RexInputRef) eq.getOperands().get(0)).getIndex());
            ConversionException.class,
        RexLiteral literal = (RexLiteral) cast.getOperands().get(0);
            }
    }
        // the translator must emit IS_NOT_TRUE unconditionally.
import org.opensearch.dsl.converter.ConversionException;
        // "-10" on 3 should → result=-7 → clamp to 0 → should optional
        RexNode result = translator.convert(QueryBuilders.boolQuery(), ctx);
        assertEquals(SqlKind.EQUALS, eq2.getKind());
                .should(QueryBuilders.termQuery("name", "b"))
        assertEquals(SqlKind.IS_NOT_TRUE, ((RexCall) result).getKind());
        // Citation: BoolQueryBuilder.doToQuery:338, Queries.isNegativeQuery:113-119.
    public void testQueryNameThrowsConversionException() {
        assertTrue("Message must mention _name", ex.getMessage().contains("_name"));
            ctx
import org.opensearch.index.query.BoolQueryBuilder;
    // --- MSM exceeding should-count: legacy matches nothing ---
    public void testNonDefaultBoostThrowsConversionException() {
        assertMidBandRejected(ex, 2, 4);
        stubRegistry.register(new QueryTranslator() {
    // --- Parameter audit: boost, _name, adjustPureNegative ---
        var nonNullableBoolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
        assertEquals(SqlKind.IS_NOT_TRUE, call.getKind());
        // Citation: Queries.fixNegativeQueryIfNeeded lines 111-121.
        // n=4, msm="-25%" → miss floor(1.0)=1, so 4-1=3 (1 < 3 < 4)
        );
    }
        RexCall call = (RexCall) result;
        assertMidBandRejected(ex, 10, 20);
    public void testAdjustPureNegativeFalseShouldOnlyAccepted() throws ConversionException {
                ),
        RexNode result = translator.convert(shouldQuery(4, "4"), ctx);
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(
        assertEquals(SqlKind.EQUALS, eq.getKind());
        RexNode result = translator.convert(
 *
        );
                .must(QueryBuilders.termQuery("name", "value1"))
            ctx
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "3"), ctx));
 * this file be licensed under the Apache-2.0 license or a
        );
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(
            ConversionException.class,
        );
                .minimumShouldMatch("5"),
    public void testAdjustPureNegativeDefaultTruePureNegativeProducesNot() throws ConversionException {
                .must(QueryBuilders.termQuery("name", "active"))
    }
            .must(QueryBuilders.termQuery("name", "keep"))
        RexCall cast = (RexCall) eq.getOperands().get(1);
        assertTrue("Boolean literal must be TRUE", literal.getValueAs(Boolean.class));
        assertEquals(3, call.getOperands().size());
    public void testNestedBoolQueryFlattening() throws ConversionException {
        assertEquals(SqlKind.AND, ((RexCall) result).getKind());
        );
        // Pins: must_not emits IS_NOT_TRUE so missing-field rows (NULL) are retained.
        RexNode inner = ((RexCall) result).getOperands().get(0);
        assertEquals(SqlKind.OR, call.getKind());
                .should(QueryBuilders.termQuery("brand", "b"))
        // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.
    public void testParsePercentageInvalidThrowsConversionExceptionWithValue() {
        assertEquals("Negative MSM result must be clamped to 0", 0, result);
                .should(QueryBuilders.termQuery("name", "b"))
    public void testMsmLowerBoundaryK2Throws() {
        assertTrue("MSM exceeding should-count must produce FALSE literal (match-none)", result instanceof RexLiteral);
        }
        );
        assertEquals(
    private final QueryRegistry registry = QueryRegistryFactory.create();
 */
        assertEquals(SqlKind.EQUALS, eq0.getKind());
        RexNode result = translator.convert(
        int result = MinimumShouldMatchParser.calculateRequiredMatches("200%", 3, false);
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        // 2<75%: if total <= 2 match all; if total > 2 match 75%
        assertTrue(result instanceof RexCall);
        );
            .should(QueryBuilders.termQuery("name", "a"))
        assertEquals(SqlKind.EQUALS, ((RexCall) call.getOperands().get(1)).getKind());
            List.of(rexBuilder.makeInputRef(typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true), 0))
                .mustNot(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("brand", "wanted"))),
    }
import org.apache.calcite.rex.RexInputRef;
        assertTrue("Message must identify date fields", ex.getMessage().toLowerCase(Locale.ROOT).contains("date field"));
            QueryBuilders.boolQuery()
                ),
    }
            QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("brand", "value2"))
            QueryBuilders.boolQuery()
            "filter+must_not with adjustPureNegative=false must equal default-true result",
                .must(QueryBuilders.termQuery("name", "required"))
        // n=5, msm="3" → resolved k=3 (1 < 3 < 5)
    }
        BoolQueryBuilder queryDefault = QueryBuilders.boolQuery()
import java.util.Locale;
        assertTrue(result instanceof RexCall);
                .should(QueryBuilders.termQuery("name", "a"))
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
        BoolQueryBuilder queryWithFlag = QueryBuilders.boolQuery()
        assertEquals(2, call.getOperands().size());
        assertTrue("brand field must be nullable in test schema", fieldRef.getType().isNullable());
        assertTrue("Message must mention boost", ex.getMessage().contains("boost"));
        assertTrue(result instanceof RexCall);
            .mustNot(QueryBuilders.termQuery("brand", "excluded"))
                .should(QueryBuilders.termQuery("name", "b"))
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")).boost(2.0f);
        ConversionException ex = expectThrows(
        assertTrue(result instanceof RexCall);
        // "200%" with 3 clauses → floor(6) > 3 → raw value returned; convert() handles match-none.
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")).boost(1.0f), ctx);
                return org.opensearch.index.query.MatchAllQueryBuilder.class;
            .adjustPureNegative(false);
                .should(QueryBuilders.termQuery("brand", "medium"))
        QueryRegistry stubRegistry = new QueryRegistry();
        assertTrue(result instanceof RexCall);
        RexLiteral literal = (RexLiteral) cast.getOperands().get(0);
        assertTrue(result instanceof RexCall);
        assertEquals(SqlKind.EQUALS, eq.getKind());
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")), ctx);
        assertTrue("must_not on nullable child must emit IS_NOT_TRUE", result instanceof RexCall);
        assertTrue("Must be boolean TRUE", RexLiteral.booleanValue(result));
    public void testBoolMustWithBooleanChildPreservesBooleanLiteral() throws ConversionException {
    public void testShouldWithMustClause() throws ConversionException {
            () -> MinimumShouldMatchParser.calculateRequiredMatches("xyz%", 3, false)
        // n=4, msm="2<75%" → total>2 so 75% of 4 = 3 (1 < 3 < 4)
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
        );
    public void testComplexBoolQuery() throws ConversionException {
        assertTrue(result instanceof RexCall);
            () -> MinimumShouldMatchParser.calculateRequiredMatches("5<", 6, false)
        assertEquals(0, ((RexInputRef) eq0.getOperands().get(0)).getIndex());
        assertEquals(SqlKind.IS_NOT_TRUE, call.getKind());
            resultDefault.toString(),
    public void testPureNegativeBoolProducesNot() throws ConversionException {
            "must+must_not with adjustPureNegative=false must equal default-true result",
    }
        assertEquals(SqlKind.EQUALS, ((RexCall) call.getOperands().get(0)).getKind());
        assertMidBandRejected(ex, 3, 5);
    public void testEmptyBoolProducesTrueLiteral() throws ConversionException {
        assertEquals(SqlKind.AND, call.getKind());
    }
                return syntheticChild;
        RexNode resultWithFlag = translator.convert(queryWithFlag, ctx);
        for (int i = 0; i < n; i++) {
    public void testBoolMustWithDateChildPropagatesRejection() {
    }
                .must(QueryBuilders.termQuery("name", "required"))
    }
        RexCall call = (RexCall) result;
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(20, "10"), ctx));
        assertEquals(5, ((RexInputRef) eq2.getOperands().get(0)).getIndex());
        assertEquals(SqlKind.OR, ((RexCall) result).getKind());
    }
                .minimumShouldMatch("3"),
        RexNode resultDefault = translator.convert(queryDefault, ctx);
        RexNode result = translator.convert(
            public RexNode convert(QueryBuilder query, ConversionContext ctx) {
                    QueryBuilders.boolQuery().must(QueryBuilders.termQuery("brand", "value2")).must(QueryBuilders.termQuery("rating", 3.0))
    }
        assertEquals(3, and.getOperands().size());
        RexNode result = translator.convert(
        ConversionException ex = expectThrows(
            assertTrue(operand instanceof RexCall);
                .should(QueryBuilders.termQuery("name", "b"))
        BoolQueryBuilder queryWithFlag = QueryBuilders.boolQuery()
        assertFalse("Precondition: type must be non-nullable", nonNullableBoolType.isNullable());
    public void testShouldClauseWithoutMust() throws ConversionException {
        RexNode result = translator.convert(
        RexLiteral lit2 = (RexLiteral) ((RexCall) eq2.getOperands().get(1)).getOperands().get(0);
    }
        assertEquals(Integer.valueOf(999), lit1.getValueAs(Integer.class));
                .should(QueryBuilders.termQuery("name", "c"))
    public void testParseIntegerInvalidThrowsConversionExceptionWithValue() {
    public void testBoolMustWithNumericChildPreservesIntegerLiteral() throws ConversionException {
        RexNode result = translator.convert(
        assertEquals(SqlKind.EQUALS, call.getKind());
        // "-10" with 3 clauses → 3+(-10)=-7 → clamp to 0
import org.opensearch.dsl.converter.ConversionContext;
            QueryBuilders.boolQuery()
            query.should(QueryBuilders.termQuery("name", "val" + i));
            ctx
                .should(QueryBuilders.termQuery("name", "a"))
        assertEquals("MSM within valid range should not be clamped", 2, result);
                .must(
        assertEquals(SqlKind.AND, call.getKind());
        RexNode result = translator.convert(
            ctx
    public void testMsmUpperBoundaryK3Throws() {
                ),
    }
        // n=3, k=2 → first mid-band value above the OR boundary
        int result = MinimumShouldMatchParser.calculateRequiredMatches("-10", 3, false);
        RexNode result = translator.convert(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "test")), ctx);
    // --- Should-gate local branch tests ---
        RexNode result = translator.convert(
    public void testAdjustPureNegativeFalseMustPlusMustNotAccepted() throws ConversionException {
    // Basic bool query tests
    public void testDoubleNegationElimination() throws ConversionException {
    public void testShouldGateExactEqualProducesAnd() throws ConversionException {
    public void testMsmExceedingShouldCountProducesMatchNone() throws ConversionException {
            ctx
            QueryBuilders.boolQuery()
            .must(QueryBuilders.termQuery("name", "keep"))
                .must(
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "-25%"), ctx));
        RexNode result = translator.convert(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("brand", "excluded")), ctx);
import org.apache.calcite.rex.RexLiteral;
            resultWithFlag.toString()
        assertEquals(3, ((RexCall) result).getOperands().size());
            QueryBuilders.boolQuery()
            ctx
        // Pins contract with DelegatedRelevanceCallHelper: non-nullable BOOLEAN child under
    }
                .must(QueryBuilders.termQuery("name", "required"))
        RexInputRef fieldRef = (RexInputRef) ((RexCall) inner).getOperands().get(0);
    }
        assertTrue(result instanceof RexCall);
            QueryBuilders.boolQuery()
        );
        BoolQueryBuilder queryDefault = QueryBuilders.boolQuery()
        assertTrue("Over-large MSM must produce FALSE literal", result instanceof RexLiteral);
    public void testMustNotEmitsIsNotTrueForNullableChild() throws ConversionException {
        assertMidBandRejected(ex, 3, 4);
    public void testParseCombinationInvalidThresholdThrowsConversionException() {
            QueryBuilders.boolQuery()
        assertTrue("Exact-equal gate must produce AND", result instanceof RexCall);
    // Edge cases
        // adjustPureNegative=true (default) → table scan is the implicit match-all → IS_NOT_TRUE.
                .should(QueryBuilders.termQuery("name", "b"))
                .must(QueryBuilders.termQuery("name", "keep"))
        assertEquals("laptop", lit0.getValueAs(String.class));
            .should(QueryBuilders.termQuery("name", "b"))
    public void testBoolMustMixedTypesPreservesAllLiteralsInOrder() throws ConversionException {
        RexCall eq1 = (RexCall) and.getOperands().get(1);
        );
                .should(QueryBuilders.termQuery("name", "a"))
        // Lucene's "include missing-field rows" semantics under SQL three-valued logic.
    }
        assertEquals(SqlKind.AND, call.getKind());
        assertEquals(3, call.getOperands().size());
            QueryBuilders.boolQuery()
    }
        BoolQueryBuilder queryWithFlag = QueryBuilders.boolQuery()
        ConversionException ex = expectThrows(
        assertTrue("Message must contain the offending value", ex.getMessage().contains("abc"));
        );
        assertMidBandRejected(ex, 3, 4);
    }
                .should(QueryBuilders.termQuery("name", "b"))
        RexNode result = translator.convert(
            ctx
        RexCall cast = (RexCall) eq.getOperands().get(1);
                .mustNot(QueryBuilders.termQuery("name", "deleted"))
                .must(QueryBuilders.termQuery("is_active", false)),
                .should(QueryBuilders.termQuery("brand", "b"))
        RexCall eq = (RexCall) result;
        assertEquals(SqlTypeName.BOOLEAN, literal.getType().getSqlTypeName());
    public void testCalculateRequiredMatchesNotClampedWhenWithinRange() throws ConversionException {
        assertTrue(result instanceof RexCall);
        assertTrue(result instanceof RexCall);
        assertEquals(
        var rexBuilder = ctx.getRexBuilder();
    }
    private static BoolQueryBuilder shouldQuery(int n, String msm) {
                .should(QueryBuilders.termQuery("brand", "a"))
        int result = MinimumShouldMatchParser.calculateRequiredMatches("2", 3, false);
        assertTrue(inner instanceof RexCall);
        assertEquals(2, fieldRef.getIndex());
        RexNode result = translator.convert(
        RexCall eq2 = (RexCall) and.getOperands().get(2);
        assertTrue("must_not must emit IS_NOT_TRUE", result instanceof RexCall);
        assertTrue("Message must mention the spec", ex.getMessage().contains("5<"));
        );
        assertTrue("MSM exceeding should-count must produce FALSE literal even with must", result instanceof RexLiteral);
            .mustNot(QueryBuilders.termQuery("brand", "excluded"));
        RexCall call = (RexCall) result;
        // IS_NOT_TRUE(IS_NOT_TRUE(term)) → term
        // n=4, k=4 → conjunction (supported)
                .minimumShouldMatch("5"),
    }
            ctx
    public void testMsmMidBandNegativePercentageThrows() {
    }
        assertEquals(4, ((RexCall) result).getOperands().size());
        BoolQueryBuilder query = QueryBuilders.boolQuery().mustNot(QueryBuilders.matchAllQuery());
                        .should(QueryBuilders.termQuery("rating", 3.0))
        BoolQueryBuilder queryDefault = QueryBuilders.boolQuery()
        );
            }
            ctx
        assertTrue("Message must name the should-clause count", ex.getMessage().contains("should clauses = " + shouldClauses));
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(3, "2"), ctx));
            .mustNot(QueryBuilders.termQuery("brand", "excluded"))
            @Override
            resultDefault.toString(),
        RexNode resultWithFlag = translator.convert(queryWithFlag, ctx);
            () -> MinimumShouldMatchParser.calculateRequiredMatches("abc", 3, false)
            .adjustPureNegative(false);
import org.opensearch.index.query.QueryBuilders;
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("is_active", true)), ctx);
        RexNode result = translator.convert(
    public void testMsmMidBandPercentageThrows() {
        assertEquals(3, call.getOperands().size());
    }
 * compatible open source license.
    }
                .must(QueryBuilders.termQuery("name", "laptop"))
                .should(QueryBuilders.termQuery("name", "b")),
    private final ConversionContext ctx = TestUtils.createContext();
        // adjustPureNegative=true (default) → IS_NOT_TRUE conditions.
    }
        // should-only is not pure-negative, so adjustPureNegative=false is a no-op.
            .should(QueryBuilders.termQuery("name", "b"));
        );
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    }
                .should(QueryBuilders.termQuery("name", "a"))
            ctx
    public void testAdjustPureNegativeFalsePureNegativeReturnsFalseLiteral() throws ConversionException {
        RexNode resultDefault = translator.convert(queryDefault, ctx);
    public void testCalculateRequiredMatchesClampedToZeroMakesShouldOptional() throws ConversionException {
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(3, "-1"), ctx));
        assertMidBandRejected(ex, 3, 4);
        RexCall and = (RexCall) result;
        );
            resultWithFlag.toString()
    }
    public void testMustNotClause() throws ConversionException {
                .should(QueryBuilders.termQuery("brand", "high"))
                .minimumShouldMatch("1"),
        );
        // Bool composition propagates a child translator's rejection rather than swallowing it.
    }
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "test")).queryName("my_bool");
        assertEquals(SqlKind.AND, ((RexCall) result).getKind());
        assertTrue("Empty bool must produce TRUE literal (match-all)", result instanceof RexLiteral);
        // Citation: AbstractQueryBuilder.toQuery wraps result in BoostQuery when boost != 1.0f.
        var typeFactory = rexBuilder.getTypeFactory();
            QueryBuilders.boolQuery()
        assertEquals(SqlKind.EQUALS, call.getKind());
        // adjustPureNegative=false is a no-op when must clauses exist.
            ctx
            "should-only with adjustPureNegative=false must equal default-true result",
            ctx
        RexCall call = (RexCall) result;
        assertFalse("Operand type must be non-nullable BOOLEAN", inner.getType().isNullable());
        // Citation: Queries.isNegativeQuery:113-119.
    public void testNestedBoolInShouldInMustIsFlat() throws ConversionException {
        RexLiteral lit1 = (RexLiteral) ((RexCall) eq1.getOperands().get(1)).getOperands().get(0);
            QueryBuilders.boolQuery().mustNot(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "value"))),
import org.apache.calcite.rex.RexUtil;
    }
                .should(QueryBuilders.termQuery("name", "a"))
    public void testAdjustPureNegativeFalseFilterPlusMustNotAccepted() throws ConversionException {
        // Should clauses are optional when must is present (no minimum_should_match)
        RexCall call = (RexCall) result;
        return query.minimumShouldMatch(msm);
        assertEquals(SqlTypeName.BOOLEAN, inner.getType().getSqlTypeName());
        assertEquals(2, call.getOperands().size());
        // must_not must be wrapped in IS_NOT_TRUE. Calcite may later rewrite to NOT(x), but
        assertTrue("Message must name the offending field", ex.getMessage().contains("created_date"));
        // "5<" is malformed — legacy throws ArrayIndexOutOfBoundsException.
        assertEquals(SqlTypeName.INTEGER, literal.getType().getSqlTypeName());
        assertEquals(Integer.valueOf(42), literal.getValueAs(Integer.class));
            resultDefault.toString(),
            ctx
    public void testMsmMidBandCombinationSpecThrows() {
                    QueryBuilders.boolQuery()
            assertEquals(SqlKind.IS_NOT_TRUE, ((RexCall) operand).getKind());
            ctx
        RexNode result = stubTranslator.convert(query, ctx);
    // --- MSM result clamping tests ---
    }
    // minimum_should_match: Single combination
            ctx
                .minimumShouldMatch("1"),
        assertEquals(SqlKind.AND, and.getKind());
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "70%"), ctx));
    public void testNestedShouldQueryFlattening() throws ConversionException {
        assertTrue(result instanceof RexCall);
import org.opensearch.dsl.TestUtils;
            ctx
            .adjustPureNegative(false);
    }
    // --- Empty bool and pure-negative ---
                .should(QueryBuilders.termQuery("name", "a"))
    }
        assertEquals(2, call.getOperands().size());
    }
            @Override
        assertMidBandRejected(ex, 2, 3);
                .must(QueryBuilders.termQuery("name", "required"))
    }
        RexNode resultDefault = translator.convert(queryDefault, ctx);
        RexCall call = (RexCall) result;
            ConversionException.class,
    public void testNestedMustNotDoubleNegationWithMultipleClauses() throws ConversionException {
    }
        assertMidBandRejected(ex, 2, 3);
            .filter(QueryBuilders.termQuery("name", "active"))
        // MSM > shouldCount → legacy matches nothing → FALSE literal.
        ConversionException ex = expectThrows(
package org.opensearch.dsl.query;
        RexNode result = translator.convert(
        assertEquals(SqlKind.AND, call.getKind());
import org.opensearch.index.query.QueryBuilder;
    public void testMsmExceedingShouldCountWithMustProducesMatchNone() throws ConversionException {
        );
import org.opensearch.test.OpenSearchTestCase;
        assertTrue("Message must name the resolved minimum_should_match", ex.getMessage().contains("minimum_should_match = " + resolvedK));
        RexCall call = (RexCall) result;
                .must(QueryBuilders.termQuery("price", 999))
        assertEquals(2, call.getOperands().size());
                .should(QueryBuilders.termQuery("brand", "a"))
                .mustNot(QueryBuilders.termQuery("brand", "excluded2")),
        assertEquals("Percentage exceeding 100% returns raw computed value (> totalShould signals match-none)", 6, result);
                        )
    }
    }
    }
        // MSM="3" with 3 should → requiredMatches==size → AND
        assertEquals(
    // --- Nested bool recursion with isFlat assertion ---
            QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "test")).adjustPureNegative(false),
    public void testMsmUpperBoundaryK4SucceedsAsAnd() throws ConversionException {
    }
            SqlStdOperatorTable.IS_NOT_NULL,
        assertEquals(SqlKind.EQUALS, eq1.getKind());
    }
    }
        RexNode result = translator.convert(
        assertSame("Wrapped operand must be the injected non-nullable node", syntheticChild, inner);
        assertTrue(result instanceof RexCall);
        assertEquals("MSM exceeding totalShould must be returned as-is (> totalShould signals match-none)", 5, result);
    public void testShouldWithMustAndMinimumShouldMatch() throws ConversionException {
        assertTrue(result instanceof RexCall);
        // filter+must_not is not pure-negative, so adjustPureNegative=false is a no-op.
        assertEquals(2, call.getOperands().size());
        );
import java.util.List;
            .filter(QueryBuilders.termQuery("name", "active"))
    public void testMsmLowerBoundaryK1SucceedsAsOr() throws ConversionException {
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(
                .should(QueryBuilders.termQuery("name", "a"))
        for (RexNode operand : call.getOperands()) {
    private final BoolQueryTranslator translator = new BoolQueryTranslator(registry);
    }
        // n=4, msm="70%" → floor(2.8)=2 (1 < 2 < 4)
        RexNode result = translator.convert(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("price", 42)), ctx);
    public void testCalculateRequiredMatchesClampedToZeroWhenNegativeResult() throws ConversionException {
                .minimumShouldMatch("2<75%"),
        RexNode result = translator.convert(
            QueryBuilders.boolQuery()
        assertEquals(SqlKind.AND, call.getKind());
    }
    // --- Data-type variety: bool composition preserves child literal typing ---
                .minimumShouldMatch("5"),
        );
    public void testCalculateRequiredMatchesClampedToTotalWhenExceedsTotal() throws ConversionException {
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery("name", "test1")).should(QueryBuilders.termQuery("name", "test2")),
    public void testCalculateRequiredMatchesPercentageClampedAboveTotal() throws ConversionException {
        RexNode syntheticChild = rexBuilder.makeCall(
        RexNode result = translator.convert(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "test")), ctx);
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));
    }
            QueryBuilders.boolQuery()
        RexNode resultWithFlag = translator.convert(queryWithFlag, ctx);
        RexNode result = translator.convert(
            () -> MinimumShouldMatchParser.calculateRequiredMatches("abc<75%", 3, false)
                .minimumShouldMatch("1"),
        assertEquals(BoolQueryBuilder.class, translator.getQueryType());
        );
        RexNode result = translator.convert(shouldQuery(3, "1"), ctx);
import org.apache.calcite.sql.SqlKind;
        assertEquals(SqlKind.EQUALS, call.getKind());
        assertTrue("Message must contain the offending value", ex.getMessage().contains("xyz"));
    }
                .should(QueryBuilders.termQuery("name", "b"))
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));
        ConversionException ex = expectThrows(ConversionException.class, () -> translator.convert(shouldQuery(4, "2<75%"), ctx));
    public void testShouldGateOverLargeProducesFalse() throws ConversionException {
    }
        );
        );
        int result = MinimumShouldMatchParser.calculateRequiredMatches("5", 3, false);
        assertEquals(3, ((RexCall) result).getOperands().size());
                    QueryBuilders.boolQuery()
        assertNotNull(result);
        RexCall call = (RexCall) result;
    }
    }
                        .should(QueryBuilders.termQuery("rating", 3.0))
    public void testMustClause() throws ConversionException {
        RexNode inner = call.getOperands().get(0);
    // Witnessed: BoolQueryBuilderTests.testMinShouldMatchBiggerThanNumberOfShouldClauses.
    public void testCalculateRequiredMatchesClampedToTotalProducesAnd() throws ConversionException {
    // minimum_should_match: Non-negative integer
        assertTrue(result instanceof RexCall);
        assertFalse("Must be boolean FALSE (match-none)", RexLiteral.booleanValue(result));
    }
            resultWithFlag.toString()
        );
        // Citation: BoolQueryBuilder.doRewrite line ~279 and doToQuery line 333.
        );
                .should(QueryBuilders.termQuery("name", "value1"))
        assertEquals(SqlKind.EQUALS, ((RexCall) inner).getKind());
