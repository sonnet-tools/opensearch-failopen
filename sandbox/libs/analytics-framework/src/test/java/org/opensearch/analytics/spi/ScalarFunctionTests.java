    // depends on fromSqlFunction resolving them by name, so guard every entry.
    }
        }
    }
        // named "IS JSON VALUE" with SqlKind.OTHER. Neither fromSqlKind (OTHER is unmapped) nor
    }
        assertEquals(ScalarFunction.SAFE_CAST, ScalarFunction.fromSqlKind(SqlKind.SAFE_CAST));
            ScalarFunction.LN,
            ScalarFunction.ATAN,
    }
        assertNull(ScalarFunction.fromSqlKind(SqlKind.OTHER));
 * The OpenSearch Contributors require contributions made to
            "exception message must mention the failure, got: " + e.getMessage(),
        ScalarFunction resolved = ScalarFunction.fromSqlFunction(initcap);
        // INITCAP is a Calcite operator the enum does not model. Representative
        // UNARY_MINUS has SqlKind.MINUS_PREFIX (no enum) and name "-" (not a valid valueOf input);
            ScalarFunction.FLOOR,
            ScalarFunction.ABS,
    }
     * Tier-2 adapter targets: enum entries exist for PPL UDFs even though the
     * match any enum constant. Without this contract, any unknown scalar
        // fromToken trims surrounding whitespace and upper-cases before valueOf.
            ScalarFunction.ACOS,
    }
    /**
            SqlKind kind = func.getSqlKind();
        // both resolution paths miss and the resolver returns null instead of throwing.
        assertSame(ScalarFunction.LOG, ScalarFunction.fromSqlFunction(SqlLibraryOperators.LOG));
        Map<SqlKind, ScalarFunction> claimedBy = new EnumMap<>(SqlKind.class);
    public void testFromSqlOperatorResolvesPipeConcatViaReferenceOperator() {
            ScalarFunction.CBRT,
import org.apache.calcite.sql.SqlFunction;
        SqlFunction upper = SqlStdOperatorTable.UPPER;
        assertEquals(ScalarFunction.EQUALS, ScalarFunction.fromSqlKind(SqlKind.EQUALS));
    public void testFromSqlOperatorResolvesViaSqlKind() {
    public void testFromSqlKindResolvesDedicatedKind() {
            ScalarFunction.SINH,
    // ── fromToken: case-insensitive token resolution ───────────────────────────────────────
     * The DataFusion adapter rewrites the UDF call to the Calcite-library
        // LOG(x, e) by PPLFuncImpTable, so this single LOG entry covers both arities.
            }
        List<ScalarFunction> mathFuncs = List.of(
        assertEquals(SqlKind.OTHER, SqlStdOperatorTable.IS_JSON_VALUE.getKind());
     * javadoc) must return null — not throw — when the function name does not
        // referenceOperator pin disambiguates by singleton identity, routing the variadic
        // SqlKind.OTHER is shared by many SqlBinaryOperators — must NOT resolve via SqlKind.
    }
        assertEquals(ScalarFunction.ABS, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.ABS));
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        assertSame(ScalarFunction.SCALAR_MAX, ScalarFunction.valueOf("SCALAR_MAX"));
                fail("SqlKind." + kind + " claimed by both " + existing + " and " + func);
        assertNull(ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.UNARY_MINUS));
 */
     * upstream isthmus SCALAR_SIGS only recognises SqlLibraryOperators variants.
}
        assertSame(ScalarFunction.COT, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.COT));
     *  AbstractNameMappingAdapter instances targeting SqlLibraryOperators.GREATEST / LEAST. */
            ScalarFunction.E,
        // PPL's E() and EXPM1 UDFs likewise resolve by name.
        // Calcite's CAST has a dedicated SqlKind.CAST — short-circuit before name lookup.
        assertSame(ScalarFunction.LOG10, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.LOG10));
        );
            ScalarFunction.SCALAR_MIN,
        assertSame(ScalarFunction.COS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.COS));
            ScalarFunction.COS,
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ScalarFunction.fromToken("NOPE"));
    // PPL emits these as Calcite SqlBasicFunction calls whose name matches the
    public void testScalarMaxMinResolveByName() {
    }
        assertSame(ScalarFunction.PI, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.PI));
        assertSame(ScalarFunction.ACOS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ACOS));
        // 2-arg log: PPL emits SqlLibraryOperators.LOG(x, base); 1-arg log(x) is pre-lowered to
     */
            e.getMessage().contains("Unknown scalar function")
            ScalarFunction.ROUND,
     */
        assertSame(ScalarFunction.ABS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ABS));
        assertTrue(
    public void testNoDuplicateSqlKindBindings() {
import java.util.List;
        // constant, so identifier-name fallback resolves to the wrong constant. The
        // The original "no backend supports scalar function [null]" symptom for PPL string `+`.
        // PPL json_valid reaches AE as SqlStdOperatorTable.IS_JSON_VALUE — a SqlPostfixOperator
        for (ScalarFunction func : ScalarFunction.values()) {
        assertEquals("CONCAT", SqlLibraryOperators.CONCAT_FUNCTION.getName());
    public void testFromSqlOperatorResolvesJsonValidViaReferenceOperator() {
        assertSame(ScalarFunction.EXP, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.EXP));
    public void testFromTokenCaseInsensitive() {
            ScalarFunction.PI,
        assertNull(ScalarFunction.fromSqlKind(SqlKind.OTHER_FUNCTION));
        assertNotNull("fromSqlFunction must resolve known names", resolved);
        assertSame(ScalarFunction.EQUALS, ScalarFunction.fromToken("  Equals "));
        assertSame(ScalarFunction.JSON_VALID, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.IS_JSON_VALUE));
        assertEquals(ScalarFunction.CAST, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.CAST));
            ScalarFunction.COT,
    public void testFromSqlKindReturnsNullForOtherFunctionKind() {
import java.util.Map;
    public void testMathFunctionsHaveMathCategory() {
        assertSame(ScalarFunction.EXPM1, ScalarFunction.valueOf("EXPM1"));
 * Unit coverage for {@link ScalarFunction}'s three resolution paths used by the analytics-engine
            ScalarFunction.LOG,
    // ── fromSqlOperatorWithFallback: identifier-name branch ────────────────────────────────
        assertSame(ScalarFunction.RADIANS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.RADIANS));
    // ── fromSqlOperatorWithFallback: SqlKind branch ────────────────────────────────────────
            }
        // SqlStdOperatorTable.CONCAT is a SqlBinaryOperator named "||" with SqlKind.OTHER —
        assertEquals(ScalarFunction.CAST, ScalarFunction.fromSqlKind(SqlKind.CAST));
        assertEquals(ScalarFunction.PLUS, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.PLUS));
    public void testFromSqlFunctionResolvesKnownName() {
    public void testFromSqlKindReturnsNullForOtherKind() {
        assertEquals(ScalarFunction.CONCAT, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.CONCAT));
        assertEquals("IS JSON VALUE", SqlStdOperatorTable.IS_JSON_VALUE.getName());
        assertSame(ScalarFunction.LN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.LN));
        assertSame(ScalarFunction.TRUNCATE, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.TRUNCATE));
        for (ScalarFunction func : mathFuncs) {
            ScalarFunction.COSH,
     * {@link ScalarFunction#fromSqlFunction(SqlFunction)}. The contract (per the
            ScalarFunction.TRUNCATE
    /** Category hygiene: every math enum constant belongs to the MATH category. */
     * must still succeed so STANDARD_PROJECT_OPS and adapter dispatch can run.
        assertSame(ScalarFunction.LOG2, ScalarFunction.fromSqlFunction(SqlLibraryOperators.LOG2));
        assertEquals(ScalarFunction.PLUS, ScalarFunction.fromSqlKind(SqlKind.PLUS));
 */
package org.opensearch.analytics.spi;
        assertEquals(ScalarFunction.COALESCE, ScalarFunction.fromSqlKind(SqlKind.COALESCE));
        // resolve via SqlKind even though several enum entries declare it.
            ScalarFunction.POWER,
 * planner ({@code OpenSearchProjectRule}, {@code OpenSearchFilterRule}, {@code BackendPlanAdapter}).
            if (kind == SqlKind.OTHER_FUNCTION) {
        assertEquals(ScalarFunction.GREATER_THAN, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.GREATER_THAN));
    public void testSargPredicateIsBoundToSqlKindSearch() {
    }
        assertEquals(SqlKind.OTHER, SqlStdOperatorTable.CONCAT.getKind());
            ScalarFunction.SIN,
        assertSame(ScalarFunction.RAND, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.RAND));
/**
        // referenceOperator field points at the singleton, so the resolver matches by identity.
        assertNull("fromSqlFunction must return null for unknown names", resolved);
        // function" at the AE route.
    /** Non-OTHER_FUNCTION SqlKinds must be unique: fromSqlKind picks the first match and would shadow later entries. */
    public void testFromSqlOperatorResolvesVariadicConcatViaReferenceOperator() {
            assertSame("expected MATH category for " + func, ScalarFunction.Category.MATH, func.getCategory());
            ScalarFunction.TAN,
        assertSame(ScalarFunction.LIKE, ScalarFunction.fromToken("like"));
    public void testMathFunctionsResolveByName() {
        assertSame(ScalarFunction.ATAN2, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ATAN2));
        assertSame(ScalarFunction.ROUND, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ROUND));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    }
            ScalarFunction.LOG10,
            ScalarFunction.EXP,
    }
        // SqlKind.OTHER_FUNCTION is shared by many name-distinguished SqlFunctions — must NOT
        assertSame(ScalarFunction.DEGREES, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.DEGREES));
     * function short-circuits the Hep planner rule with an IllegalArgumentException.
        }
        // resolves through the valueOf(name.toUpperCase()) fallback after SqlKind misses.
        assertSame(ScalarFunction.SINH, ScalarFunction.valueOf("SINH"));
            ScalarFunction.DEGREES,
 *
    }
        assertSame(ScalarFunction.ASIN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ASIN));
            ScalarFunction.SCALAR_MAX,
        ScalarFunction resolved = ScalarFunction.fromSqlFunction(upper);
            ScalarFunction.RADIANS,
        assertSame(ScalarFunction.SARG_PREDICATE, ScalarFunction.fromSqlKind(SqlKind.SEARCH));
        assertSame(ScalarFunction.LIKE, ScalarFunction.fromToken("LIKE"));
                continue;
    public void testFromSqlOperatorResolvesViaIdentifierName() {
        assertSame(ScalarFunction.ATAN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ATAN));
    }
 * here rather than in IT-level "No backend supports scalar function [null]" errors.
import org.apache.calcite.sql.SqlKind;
        // call to its dedicated adapter.
        // does not yet declare.
    // ── fromSqlOperatorWithFallback: reference-operator branch ─────────────────────────────
        assertSame(ScalarFunction.SIGN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.SIGN));
import java.util.EnumMap;
    public void testFromSqlOperatorReturnsNullForUnknownFunction() {
    }
        // neither fromSqlKind nor fromSqlFunction(SqlFunction) resolves it. CONCAT's
    public void testTier2AdapterTargetFunctionsExistByName() {
    /**
            ScalarFunction.ATAN2,
    }
/*
    }
    public void testFromTokenRejectsUnknown() {
        assertSame(ScalarFunction.UPPER, resolved);
        assertSame(ScalarFunction.COSH, ScalarFunction.valueOf("COSH"));
public class ScalarFunctionTests extends OpenSearchTestCase {
    // ── Group G math functions: name-based lookup via fromSqlFunction ──────────
        assertSame(ScalarFunction.POWER, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.POWER));
            ScalarFunction.LOG2,
 * SPDX-License-Identifier: Apache-2.0
        // identifier-name valueOf ("IS JSON VALUE" != "JSON_VALID") resolves it; only the
        // SqlLibraryOperators.CONCAT_FUNCTION shares the name "CONCAT" with the binary `||` enum
 * compatible open source license.
 * <p>Each test pins one of the resolver's branches so a regression that drops a branch surfaces
            if (existing != null) {
        assertEquals(ScalarFunction.COALESCE, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.COALESCE));
            ScalarFunction.EXPM1,
            ScalarFunction.CEIL,
        // PPL's COSH/SINH UDFs have getName() = "COSH"/"SINH"; valueOf succeeds.
import org.opensearch.test.OpenSearchTestCase;
 *
     * operator before Substrait conversion, but the name-based lookup here
    public void testFromSqlFunctionReturnsNullForUnknownName() {
        // future refactor can't silently regress json_valid to "No backend supports scalar
            ScalarFunction.RAND,
     * Callers (e.g. {@code OpenSearchProjectRule}) guard on a null return from
        assertSame(ScalarFunction.E, ScalarFunction.valueOf("E"));
        // SqlStdOperatorTable.UPPER is a SqlFunction named "UPPER" with SqlKind.OTHER_FUNCTION;
        assertSame(ScalarFunction.TAN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.TAN));
        assertEquals("||", SqlStdOperatorTable.CONCAT.getName());
    /** PPL's SCALAR_MAX / SCALAR_MIN UDFs resolve by the UDF's declared name — these are the
        // of any function routed through the name-based path that the enum
        assertEquals(ScalarFunction.UPPER, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.UPPER));
    }
            ScalarFunction.ASIN,
        assertEquals(ScalarFunction.LOWER, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.LOWER));
        // UPPER is a well-known scalar function — valueOf("UPPER") succeeds.
    }
            ScalarFunction.SIGN,
        assertSame(ScalarFunction.CBRT, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.CBRT));
    // enum constant. STANDARD_PROJECT_OPS registration (and adapter dispatch)
            ScalarFunction existing = claimedBy.put(kind, func);
        );
 * this file be licensed under the Apache-2.0 license or a
     *  PPLBuiltinOperators variants that DataFusionAnalyticsBackendPlugin binds to
        SqlFunction initcap = SqlStdOperatorTable.INITCAP;
    // ── fromSqlKind ─────────────────────────────────────────────────────────────
        assertSame(ScalarFunction.SCALAR_MIN, ScalarFunction.valueOf("SCALAR_MIN"));
        assertSame(ScalarFunction.CONCAT_FUNCTION, ScalarFunction.fromSqlOperatorWithFallback(SqlLibraryOperators.CONCAT_FUNCTION));
        // referenceOperator identity pin does. Pins the exact production resolution path so a
