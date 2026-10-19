            ScalarFunction.FLOOR,  
     * Tier-2 adapter targets: enum entries exist for PPL UDFs even though the
 * SPDX-License-Identifier: Apache-2.0
            }  
        assertSame(ScalarFunction.TRUNCATE, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.TRUNCATE));
    public void testSargPredicateIsBoundToSqlKindSearch() {
 * Unit coverage for {@link ScalarFunction}'s three resolution paths used by the analytics-engine  
    public void testFromSqlKindResolvesDedicatedKind() {
        assertSame(ScalarFunction.ATAN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ATAN));
        assertEquals(ScalarFunction.GREATER_THAN, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.GREATER_THAN));  
        // SqlStdOperatorTable.CONCAT is a SqlBinaryOperator named "||" with SqlKind.OTHER —
        // SqlStdOperatorTable.UPPER is a SqlFunction named "UPPER" with SqlKind.OTHER_FUNCTION;
        assertSame(ScalarFunction.ATAN2, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ATAN2));  
    public void testFromSqlOperatorResolvesVariadicConcatViaReferenceOperator() {
            ScalarFunction.ATAN2,
        assertSame(ScalarFunction.DEGREES, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.DEGREES));
        assertSame(ScalarFunction.TAN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.TAN));  
        assertSame(ScalarFunction.CONCAT_FUNCTION, ScalarFunction.fromSqlOperatorWithFallback(SqlLibraryOperators.CONCAT_FUNCTION));
        assertSame(ScalarFunction.ABS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ABS));
    public void testMathFunctionsHaveMathCategory() {
            "exception message must mention the failure, got: " + e.getMessage(),
        assertSame(ScalarFunction.ACOS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ACOS));  
        assertSame(ScalarFunction.RAND, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.RAND));  
            ScalarFunction.ASIN,  
     * The DataFusion adapter rewrites the UDF call to the Calcite-library  
    }
 *
            assertSame("expected MATH category for " + func, ScalarFunction.Category.MATH, func.getCategory());
 */  
            ScalarFunction.POWER,  
     *  AbstractNameMappingAdapter instances targeting SqlLibraryOperators.GREATEST / LEAST. */  
        // SqlKind.OTHER is shared by many SqlBinaryOperators — must NOT resolve via SqlKind.
        assertNull(ScalarFunction.fromSqlKind(SqlKind.OTHER_FUNCTION));
    }
        // fromToken trims surrounding whitespace and upper-cases before valueOf.
    }  
            e.getMessage().contains("Unknown scalar function")  
 * The OpenSearch Contributors require contributions made to  
    // ── fromSqlOperatorWithFallback: identifier-name branch ────────────────────────────────
            ScalarFunction.LOG10,  
        assertEquals(ScalarFunction.EQUALS, ScalarFunction.fromSqlKind(SqlKind.EQUALS));
            SqlKind kind = func.getSqlKind();  
        assertSame(ScalarFunction.COT, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.COT));  
    public void testFromSqlFunctionReturnsNullForUnknownName() {  
 */
    public void testFromSqlOperatorResolvesViaIdentifierName() {  
            }
                fail("SqlKind." + kind + " claimed by both " + existing + " and " + func);  
        assertSame(ScalarFunction.ROUND, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ROUND));
        assertEquals(ScalarFunction.PLUS, ScalarFunction.fromSqlKind(SqlKind.PLUS));  
    public void testScalarMaxMinResolveByName() {
        assertSame(ScalarFunction.COSH, ScalarFunction.valueOf("COSH"));  
    }
     *  PPLBuiltinOperators variants that DataFusionAnalyticsBackendPlugin binds to
    }  
            ScalarFunction.SCALAR_MAX,
        // named "IS JSON VALUE" with SqlKind.OTHER. Neither fromSqlKind (OTHER is unmapped) nor  
            ScalarFunction.RADIANS,
        // UNARY_MINUS has SqlKind.MINUS_PREFIX (no enum) and name "-" (not a valid valueOf input);  
            ScalarFunction.ACOS,
    public void testFromSqlFunctionResolvesKnownName() {  
        assertSame(ScalarFunction.LIKE, ScalarFunction.fromToken("LIKE"));
            if (kind == SqlKind.OTHER_FUNCTION) {
    /**
import org.apache.calcite.sql.SqlKind;
    // depends on fromSqlFunction resolving them by name, so guard every entry.
            ScalarFunction.EXP,
    /** Non-OTHER_FUNCTION SqlKinds must be unique: fromSqlKind picks the first match and would shadow later entries. */
        // referenceOperator pin disambiguates by singleton identity, routing the variadic
    // ── fromToken: case-insensitive token resolution ───────────────────────────────────────
        assertEquals(ScalarFunction.CAST, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.CAST));
    // ── Group G math functions: name-based lookup via fromSqlFunction ──────────
        // SqlLibraryOperators.CONCAT_FUNCTION shares the name "CONCAT" with the binary `||` enum
            ScalarFunction.SIN,
        assertEquals(ScalarFunction.SAFE_CAST, ScalarFunction.fromSqlKind(SqlKind.SAFE_CAST));
        assertSame(ScalarFunction.SARG_PREDICATE, ScalarFunction.fromSqlKind(SqlKind.SEARCH));  
        ScalarFunction resolved = ScalarFunction.fromSqlFunction(upper);  
    // ── fromSqlOperatorWithFallback: SqlKind branch ────────────────────────────────────────  
    // PPL emits these as Calcite SqlBasicFunction calls whose name matches the  
        assertEquals(ScalarFunction.LOWER, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.LOWER));
            ScalarFunction.SCALAR_MIN,
        // neither fromSqlKind nor fromSqlFunction(SqlFunction) resolves it. CONCAT's  
        assertSame(ScalarFunction.JSON_VALID, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.IS_JSON_VALUE));
            ScalarFunction existing = claimedBy.put(kind, func);
        assertSame(ScalarFunction.E, ScalarFunction.valueOf("E"));  
        // referenceOperator field points at the singleton, so the resolver matches by identity.
            ScalarFunction.CEIL,
    // enum constant. STANDARD_PROJECT_OPS registration (and adapter dispatch)
        // does not yet declare.  
            ScalarFunction.COT,
     */  
import org.opensearch.test.OpenSearchTestCase;
            ScalarFunction.SIGN,  
            ScalarFunction.LN,
 * <p>Each test pins one of the resolver's branches so a regression that drops a branch surfaces  
    }  
        ScalarFunction resolved = ScalarFunction.fromSqlFunction(initcap);
import java.util.Map;  
        assertSame(ScalarFunction.LN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.LN));  
    public void testFromSqlOperatorResolvesJsonValidViaReferenceOperator() {
        assertTrue(
            ScalarFunction.PI,
        assertNull(ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.UNARY_MINUS));
        assertSame(ScalarFunction.RADIANS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.RADIANS));
        assertSame(ScalarFunction.LIKE, ScalarFunction.fromToken("like"));  
    }  
    public void testFromTokenCaseInsensitive() {
    public void testMathFunctionsResolveByName() {
        assertEquals(ScalarFunction.UPPER, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.UPPER));  
        assertSame(ScalarFunction.COS, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.COS));
import java.util.EnumMap;
     * operator before Substrait conversion, but the name-based lookup here
    }  
        assertSame(ScalarFunction.LOG10, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.LOG10));
        assertSame(ScalarFunction.PI, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.PI));  
    public void testNoDuplicateSqlKindBindings() {  
 * planner ({@code OpenSearchProjectRule}, {@code OpenSearchFilterRule}, {@code BackendPlanAdapter}).
     * {@link ScalarFunction#fromSqlFunction(SqlFunction)}. The contract (per the
        );
                continue;
            ScalarFunction.ABS,
        for (ScalarFunction func : ScalarFunction.values()) {
    // ── fromSqlOperatorWithFallback: reference-operator branch ─────────────────────────────
        }
 * here rather than in IT-level "No backend supports scalar function [null]" errors.
    public void testTier2AdapterTargetFunctionsExistByName() {
    public void testFromSqlKindReturnsNullForOtherKind() {  
 * compatible open source license.
    // ── fromSqlKind ─────────────────────────────────────────────────────────────
        assertEquals(ScalarFunction.CAST, ScalarFunction.fromSqlKind(SqlKind.CAST));
            ScalarFunction.EXPM1,
        // of any function routed through the name-based path that the enum
 *
        // LOG(x, e) by PPLFuncImpTable, so this single LOG entry covers both arities.
        // PPL json_valid reaches AE as SqlStdOperatorTable.IS_JSON_VALUE — a SqlPostfixOperator
        assertNull("fromSqlFunction must return null for unknown names", resolved);  
     * upstream isthmus SCALAR_SIGS only recognises SqlLibraryOperators variants.
        // resolve via SqlKind even though several enum entries declare it.
        assertEquals("IS JSON VALUE", SqlStdOperatorTable.IS_JSON_VALUE.getName());
            ScalarFunction.COSH,  
        assertNull(ScalarFunction.fromSqlKind(SqlKind.OTHER));
        assertSame(ScalarFunction.CBRT, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.CBRT));
        assertSame(ScalarFunction.EXP, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.EXP));
        // both resolution paths miss and the resolver returns null instead of throwing.
        // function" at the AE route.
        );
        // resolves through the valueOf(name.toUpperCase()) fallback after SqlKind misses.
        // identifier-name valueOf ("IS JSON VALUE" != "JSON_VALID") resolves it; only the
        // Calcite's CAST has a dedicated SqlKind.CAST — short-circuit before name lookup.  
            ScalarFunction.CBRT,  
     * match any enum constant. Without this contract, any unknown scalar  
    }
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
        assertEquals(ScalarFunction.PLUS, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.PLUS));
/**
            ScalarFunction.DEGREES,
        assertSame(ScalarFunction.SCALAR_MIN, ScalarFunction.valueOf("SCALAR_MIN"));  
public class ScalarFunctionTests extends OpenSearchTestCase {  
    }
        // The original "no backend supports scalar function [null]" symptom for PPL string `+`.
        assertSame(ScalarFunction.LOG2, ScalarFunction.fromSqlFunction(SqlLibraryOperators.LOG2));
        assertEquals(SqlKind.OTHER, SqlStdOperatorTable.IS_JSON_VALUE.getKind());  
        // INITCAP is a Calcite operator the enum does not model. Representative
        // call to its dedicated adapter.
        assertEquals(ScalarFunction.COALESCE, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.COALESCE));
    public void testFromSqlKindReturnsNullForOtherFunctionKind() {
        for (ScalarFunction func : mathFuncs) {  
        assertEquals(ScalarFunction.CONCAT, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.CONCAT));
        // PPL's COSH/SINH UDFs have getName() = "COSH"/"SINH"; valueOf succeeds.
        List<ScalarFunction> mathFuncs = List.of(  
    }  
    /** PPL's SCALAR_MAX / SCALAR_MIN UDFs resolve by the UDF's declared name — these are the
        assertSame(ScalarFunction.EXPM1, ScalarFunction.valueOf("EXPM1"));
     * function short-circuits the Hep planner rule with an IllegalArgumentException.
     * must still succeed so STANDARD_PROJECT_OPS and adapter dispatch can run.
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ScalarFunction.fromToken("NOPE"));  
        }
}  
/*  
            ScalarFunction.TRUNCATE
    /** Category hygiene: every math enum constant belongs to the MATH category. */
            ScalarFunction.LOG,
    /**  
        // 2-arg log: PPL emits SqlLibraryOperators.LOG(x, base); 1-arg log(x) is pre-lowered to
        // constant, so identifier-name fallback resolves to the wrong constant. The  
        assertSame(ScalarFunction.POWER, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.POWER));
        assertSame(ScalarFunction.EQUALS, ScalarFunction.fromToken("  Equals "));
    }
            ScalarFunction.E,  
 * this file be licensed under the Apache-2.0 license or a
        // referenceOperator identity pin does. Pins the exact production resolution path so a
        assertEquals("||", SqlStdOperatorTable.CONCAT.getName());
        assertSame(ScalarFunction.SCALAR_MAX, ScalarFunction.valueOf("SCALAR_MAX"));
        assertSame(ScalarFunction.LOG, ScalarFunction.fromSqlFunction(SqlLibraryOperators.LOG));  
        assertEquals(ScalarFunction.COALESCE, ScalarFunction.fromSqlKind(SqlKind.COALESCE));  
        SqlFunction initcap = SqlStdOperatorTable.INITCAP;
        // PPL's E() and EXPM1 UDFs likewise resolve by name.
    }  
    }
        assertEquals(ScalarFunction.ABS, ScalarFunction.fromSqlOperatorWithFallback(SqlStdOperatorTable.ABS));
    }  
import java.util.List;
    public void testFromTokenRejectsUnknown() {
    public void testFromSqlOperatorResolvesPipeConcatViaReferenceOperator() {  
    }
        assertSame(ScalarFunction.ASIN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.ASIN));
            ScalarFunction.TAN,  
     */
    }
        // future refactor can't silently regress json_valid to "No backend supports scalar  
            ScalarFunction.RAND,
            if (existing != null) {
            ScalarFunction.ROUND,  
        // SqlKind.OTHER_FUNCTION is shared by many name-distinguished SqlFunctions — must NOT  
import org.apache.calcite.sql.SqlFunction;
        assertSame(ScalarFunction.UPPER, resolved);
            ScalarFunction.ATAN,
    public void testFromSqlOperatorResolvesViaSqlKind() {
     * Callers (e.g. {@code OpenSearchProjectRule}) guard on a null return from  
        assertEquals("CONCAT", SqlLibraryOperators.CONCAT_FUNCTION.getName());  
package org.opensearch.analytics.spi;
    }
        assertSame(ScalarFunction.SIGN, ScalarFunction.fromSqlFunction(SqlStdOperatorTable.SIGN));
            ScalarFunction.LOG2,
            ScalarFunction.COS,
        Map<SqlKind, ScalarFunction> claimedBy = new EnumMap<>(SqlKind.class);
        assertNotNull("fromSqlFunction must resolve known names", resolved);
    public void testFromSqlOperatorReturnsNullForUnknownFunction() {
            ScalarFunction.SINH,
    }
        // UPPER is a well-known scalar function — valueOf("UPPER") succeeds.
        assertEquals(SqlKind.OTHER, SqlStdOperatorTable.CONCAT.getKind());  
        assertSame(ScalarFunction.SINH, ScalarFunction.valueOf("SINH"));
     * javadoc) must return null — not throw — when the function name does not
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        SqlFunction upper = SqlStdOperatorTable.UPPER;
