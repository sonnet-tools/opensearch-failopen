    LATEST(Category.COMPARISON, SqlKind.OTHER_FUNCTION),
    }
    SECOND_OF_MINUTE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * which is neither covered by {@code OTHER} {@code SqlKind} nor by {@code SqlFunction}.
     * Resolves a configuration/setting token (case-insensitive) to a {@link ScalarFunction}, throwing
     */
     * PPL {@code DATE_SUB(<date|timestamp|time>, INTERVAL n unit)} — the subtract counterpart of
 *
            throw new IllegalArgumentException("Unknown scalar function [" + token + "]");
     * with {@link SqlKind#OTHER}, so neither {@link #fromSqlKind(SqlKind)} nor identifier-name
        // below — wrapping it in Map.copyOf adds an allocation without any external safety guarantee.
    MEMK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    ARRAY_JOIN(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TIME_FORMAT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    WILDCARD(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    SCALAR_MIN(Category.MATH, SqlKind.OTHER_FUNCTION),
        }
     * PPL {@code SUBDATE(<date|timestamp>, N | INTERVAL n unit)} — the subtract counterpart of
    EQUALS(Category.COMPARISON, SqlKind.EQUALS),
    CURTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
        }
    RMCOMMA(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /** PPL {@code TIME_TO_SEC(x)} — seconds-of-day of a TIME/TIMESTAMP (BIGINT). Epoch-arithmetic lowering. */
    MATCH_PHRASE(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    /**
     * are singletons (e.g. {@code SqlStdOperatorTable.CONCAT}). Empty in the common case (most
    /**
    YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CEIL(Category.MATH, SqlKind.CEIL),
     */
    ASCII(Category.STRING, SqlKind.OTHER_FUNCTION),
        ScalarFunction byReference = BY_REFERENCE_OPERATOR.get(operator);
    // ── Cryptographic hash ─────────────────────────────────────────────
     * identity match (handles {@code SqlStdOperatorTable.CONCAT} a.k.a. {@code ||}), then
        BY_REFERENCE_OPERATOR = byOperator;
    LTRIM(Category.STRING, SqlKind.OTHER_FUNCTION),
     * buckets and a unit-name string ({@code "y"}, {@code "M"}, {@code "d"},
     * {@link #ADDDATE}, sharing the {@code DATE_SUB} lowering.
     */
     * compile error here.
 * <p>Each function carries a {@link Category} indicating its type and whether
    DIVIDE(Category.MATH, SqlKind.DIVIDE),
    ADDTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * shared with many scalar UDFs). Pairs with {@link #ITEM} downstream:
     * Category of scalar function.
    ARRAY_SLICE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL's {@code mvindex(arr, N)} single-element form lowers through
 * it supports parameters (e.g., full-text operators accept analyzer, slop, etc.).
     * is needed here.
     * {@link #fromSqlFunction(SqlFunction)} when resolving an arbitrary {@code RexCall}'s
    REGEXP(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
        for (ScalarFunction func : values()) {
     * {@code SpanFunction} UDF named {@code "SPAN"}. The analytics-backend
     * PPL {@code json_valid(str)} — resolves through the SQL plugin's
    NUMBER_TO_STRING(Category.STRING, SqlKind.OTHER_FUNCTION), // Alias for TOSTRING
     * Calcite's {@code SAFE_CAST} — emitted by PPL's explicit {@code CAST(... AS ...)} when the
     */
        } catch (IllegalArgumentException e) {
    public Category getCategory() {
    WEEKDAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */
         * Catch-all for functions that don't fit other categories (CAST, CASE, COALESCE, EXTRACT, etc.).
     * {@link #fromSqlFunction(SqlFunction)}. The grok-pattern dictionary and its
    /** PPL {@code SEC_TO_TIME(n)} — time-of-day n seconds past midnight (TIME). from_unixtime-based lowering. */
    RAND(Category.MATH, SqlKind.OTHER_FUNCTION),
    /** Delegated prefix query — passes the value verbatim to Lucene PrefixQueryBuilder. */
    TAN(Category.MATH, SqlKind.OTHER_FUNCTION),
    ScalarFunction(Category category, SqlKind sqlKind) {
    // cross-frontend semantics (CASE, COALESCE, comparisons, etc.).
    /**
     * rewrites the call into a DataFusion-native interval-add expression.
     * constants resolve by SqlKind or identifier-name valueOf).
     * Substrait-emitted plan reaches DataFusion as standard primitives.
     * element matching a regex, or NULL if no match. Resolves through the SQL
    MVFIND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CURRENT_TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * is grok syntax ({@code %{HOSTNAME:host}}) rather than a raw regex. Shares the
     * PPL {@code grok <field> '<grok-pattern>'} — like {@link #PARSE} but the pattern
            if (func.sqlKind == kind && func.sqlKind != SqlKind.OTHER_FUNCTION) {
    /** PPL {@code GET_FORMAT(type, region)} — constant MySQL format string (VARCHAR). Plan-time literal fold. */
    DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    AUTO(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // ── Datetime ────────────────────────────────────────────────────
     * custom Rust UDF ({@code udf::mvappend}) registered on its session context.
     * forward by an interval, returning TIMESTAMP. Resolves through the SQL plugin's
        return category;
    CONCAT_FUNCTION(Category.STRING, SqlKind.OTHER_FUNCTION, org.apache.calcite.sql.fun.SqlLibraryOperators.CONCAT_FUNCTION),
     * name-mapping adapter.
         */
     * Skips OTHER_FUNCTION — multiple functions share this kind,
     * uses {@link SqlKind#CAST}. DataFusion's native cast already returns NULL on conversion
    JSON_ARRAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /** PPL minspan_bucket(value, min_span, data_range, max_value). VARCHAR label. */
    GROK(Category.STRING, SqlKind.OTHER_FUNCTION),
    /** PPL range_bucket(value, data_min, data_max, start_param, end_param). VARCHAR label. */
    /** PPL width_bucket(value, num_bins, data_range, max_value). Returns a
     * Reverse index from {@link #referenceOperator} to enum constant. Built from the enum itself
    /** PPL span_bucket(value, span). Rust UDF returning a VARCHAR bucket label
    PARSE(Category.STRING, SqlKind.OTHER_FUNCTION),
    RANGE_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION);
    REGEXP_REPLACE(Category.STRING, SqlKind.OTHER_FUNCTION),
    UPPER(Category.STRING, SqlKind.OTHER_FUNCTION),
    public static ScalarFunction fromSqlFunction(SqlFunction function) {
     * {@link #valueOf(String)} resolves it. The {@code referenceOperator} hook below pins the
    JSON_OBJECT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    SUBSTR(Category.STRING, SqlKind.OTHER_FUNCTION),
    /**
    /**
    // ── Conversion (placeholder UDFs rewritten by backend adapters) ──
        try {
        // The HashMap is private static final and never exposed beyond the get() in the resolver
    MINSPAN_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * equivalent is {@code make_array}, so a backend that supports this needs a
     * {@code ParseFunction} UDF in the SQL plugin (3rd operand {@code 'grok'}) and the
     * between two timestamps. Resolves through the SQL plugin's {@code TimestampDiffFunction}
     * with {@link SqlKind#OTHER}. Neither name-based {@link #valueOf(String)} nor
    LEFT(Category.STRING, SqlKind.OTHER_FUNCTION),
     * Maps any Calcite {@link SqlOperator} to a {@link ScalarFunction}, or returns null if
    TIMESTAMPADD(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MULTI_MATCH(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    QUERY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     * UDF named {@code "TIMESTAMPDIFF"}. Lowering target for PPL `timechart`'s {@code per_*}
    ASIN(Category.MATH, SqlKind.OTHER_FUNCTION),
        this.referenceOperator = referenceOperator;
    }
    DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * adapter rewrites the call into {@code DATETIME_PLUS(base, interval)}, which binds through
            return null;
    /** PPL {@code conv(n, fromBase, toBase)} — base conversion via Rust UDF. */
    PATTERN_PARSER(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TIME_DIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * a {@link org.apache.calcite.sql.SqlPostfixOperator} named {@code "IS JSON VALUE"}
    MONTH_OF_YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    REX_EXTRACT_MULTI(Category.STRING, SqlKind.OTHER_FUNCTION),
    ARRAY_DISTINCT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    NOT_EQUALS(Category.COMPARISON, SqlKind.NOT_EQUALS),
    private final Category category;
    ROUND(Category.MATH, SqlKind.OTHER_FUNCTION),
    /** PPL {@code PERIOD_ADD(P, n)} — add n months to a YYYYMM period (INTEGER). Integer-arithmetic lowering. */
    QUERY_STRING(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    SECOND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * analytics-backend-datafusion adapter.
    }
     * and time span (interval=1) to {@code date_trunc(unit, field)} so the
import org.apache.calcite.sql.SqlFunction;
     */
     * unrecognized. Resolution order: {@link SqlKind} match, then {@link #referenceOperator}
    E(Category.MATH, SqlKind.OTHER_FUNCTION),
     * failure, so SAFE_CAST and CAST share the same backend semantics.
    MINUS(Category.MATH, SqlKind.MINUS),
    DAYOFWEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // ── Cast / type ──────────────────────────────────────────────────
    HOUR_OF_DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@code MVIndexFunctionImp.resolveSingleElement} to ITEM with a 1-based index
 * compatible open source license.
     * {@code SqlKind.OTHER}); resolution happens via the {@code referenceOperator}
     * {@code parse} returns the map, {@code item(map, group)} extracts each
 * math, string, conditional, date/time, and cast operations. Used across filter,
    ATAN(Category.MATH, SqlKind.OTHER_FUNCTION),
    OR(Category.SCALAR, SqlKind.OR),
     * source value may be NULL or the conversion may fail; returns NULL on failure rather than
    /**
        try {
    }
    JSON(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * …) for time buckets. Resolves through the SQL plugin's
    JSON_KEYS(Category.SCALAR, SqlKind.OTHER_FUNCTION),
import java.util.HashMap;
    TIMESTAMPDIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@link #DATE_ADD}. Lowered to {@code DATETIME_PLUS(base, -interval)} by the
    MATCH_PHRASE_PREFIX(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    NUM(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    RTRIM(Category.STRING, SqlKind.OTHER_FUNCTION),
     * Substrait's standard {@code add(timestamp, interval)} to DataFusion's native interval add.
    TRUNCATE(Category.MATH, SqlKind.OTHER_FUNCTION),
    EARLIEST(Category.COMPARISON, SqlKind.OTHER_FUNCTION),
            // function through the non-ScalarFunction path (opaque or YAML-alias based
    SPAN_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // live in the shared analytics-framework SPI — they couple the framework to PPL
    JSON_ARRAY_LENGTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * fixed-width buckets. PPL's {@code stats … by span(field, N)} lowers to
        } catch (IllegalArgumentException e) {
     * Maps a Calcite SqlKind to a ScalarFunction, or null if not recognized.
    // ── Logical connectives ─────────────────────────────────────────
    WIDTH_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TONUMBER(Category.STRING, SqlKind.OTHER_FUNCTION),
     *
    // ── String ───────────────────────────────────────────────────────
    // them at one shared instance.
     * PPL {@code span(field, interval, unit?)} — bucket {@code field} into
     */
        Map<SqlOperator, ScalarFunction> byOperator = new HashMap<>();
    JSON_EXTRACT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    public static ScalarFunction fromToken(String token) {
    PI(Category.MATH, SqlKind.OTHER_FUNCTION),
     * {@link #fromSqlFunction(SqlFunction)} ({@code SqlKind.OTHER_FUNCTION}
    /**
    public static ScalarFunction fromSqlKind(SqlKind kind) {
    LOCATE(Category.STRING, SqlKind.OTHER_FUNCTION),
/**
     */
    SUBDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // TODO: Frontend/lang-specific functions (NUM/AUTO/MEMK/MKTIME etc.) shouldn't
    REGEXP_CONTAINS(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     * PPL {@code mvzip(left, right [, sep])} — element-wise zip of two arrays into an
    STRCMP(Category.STRING, SqlKind.OTHER_FUNCTION),
     * {@code ArrayFunctionImpl} UDF named {@code "array"}. DataFusion's native
 */
     * at class init — adding a new symbolic operator is a single-site change on the enum constant,
    LOG(Category.MATH, SqlKind.OTHER_FUNCTION),
    JSON_SET(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */
    EXPM1(Category.MATH, SqlKind.OTHER_FUNCTION),
        }
     * whose {@code getName()} returns a non-identifier token (e.g. {@code SqlStdOperatorTable.CONCAT}
    /**
    CURRENT_DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
}
    UTC_TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // supplies its own function set, keeping ScalarFunction to operators with
     * PPL {@code mvfind(arr, regex)} — find the 0-based index of the first array
    public enum Category {
     * array of strings, joined per pair by a separator (default {@code ","}). Resolves
    COALESCE(Category.SCALAR, SqlKind.COALESCE),
    TIME_TO_SEC(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CURRENT_TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    DATE_ADD(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // ── Array ────────────────────────────────────────────────────────
    WILDCARD_QUERY_DSL(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
        this.sqlKind = sqlKind;
                return func;
    JSON_DELETE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * name-mapping adapter (see {@code MakeArrayAdapter} in the DataFusion backend).
    // ── Conditional ──────────────────────────────────────────────────
    /**
     * Resolves through the SQL plugin's {@code TimestampAddFunction} UDF named
    static {
     * aggregations (see {@link #TIMESTAMPDIFF}). The analytics-backend-datafusion adapter
            return byKind;
    }
     */
     * values ({@code arg1 - arg2}, time-of-day discarded), returning BIGINT. Lowered to a
    /** PPL {@code TIMEDIFF(a, b)} (engine label TIME_DIFF) — difference of two times as a TIME. */
    SHA2(Category.STRING, SqlKind.OTHER_FUNCTION),
    NOW(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */
    IS_NOT_NULL(Category.COMPARISON, SqlKind.IS_NOT_NULL),
    ITEM(Category.SCALAR, SqlKind.ITEM),
     * named group at the call site.
    LESS_THAN_OR_EQUAL(Category.COMPARISON, SqlKind.LESS_THAN_OR_EQUAL),
     * rename surfaces as a compile error rather than as a silent string mismatch at runtime.
     * No DataFusion stdlib equivalent — the analytics-backend-datafusion plugin ships
     * PPL {@code mvappend(arg1, arg2, …)} — flatten a mixed list of array and
     * operator: a {@code RexCall} may be backed by a {@code SqlBinaryOperator} (e.g. {@code ||})
            }
     * a descriptive {@link IllegalArgumentException} if unrecognized. Used by cluster settings that
     */
    EXTRACT(Category.SCALAR, SqlKind.EXTRACT),
 * this file be licensed under the Apache-2.0 license or a
    POSITION(Category.STRING, SqlKind.POSITION),
public enum ScalarFunction {
     * Calcite's {@code ARRAY_JOIN} — joins array elements with a separator. PPL
    SEC_TO_TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
 * SPDX-License-Identifier: Apache-2.0
    WEEK_OF_YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MKTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    REX_OFFSET(Category.STRING, SqlKind.OTHER_FUNCTION),
     * through the SQL plugin's {@code MVZipFunctionImpl} UDF named {@code "mvzip"}.
     * a custom Rust UDF (`udf::mvzip`) registered on its session context.
        // TODO: Add an explicit functionName field per enum constant instead of relying on
    // the wire contract. Aliases each need their own entry; the adapter map points
     * PPL {@code TIMESTAMPADD(unit, value, timestamp)} — emits {@code timestamp + value units}.
    CONCAT_WS(Category.STRING, SqlKind.OTHER_FUNCTION),
     * Optional Calcite operator that this constant maps to when the operator cannot be resolved
 * @opensearch.internal
    MONTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // ── Full-text search ─────────────────────────────────────────────
    private static final Map<SqlOperator, ScalarFunction> BY_REFERENCE_OPERATOR;
    SINH(Category.MATH, SqlKind.OTHER_FUNCTION),
    SUBTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MVZIP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    UTC_DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * Resolves through the SQL plugin's {@code MVAppendFunctionImpl} UDF named
    CRC32(Category.STRING, SqlKind.OTHER_FUNCTION),
    /** PPL {@code JSON_ARRAY(v1, v2, …)} — JSON-array constructor over heterogeneous scalars. */
    IN(Category.COMPARISON, SqlKind.IN),
    JSON_VALID(Category.SCALAR, SqlKind.OTHER_FUNCTION, SqlStdOperatorTable.IS_JSON_VALUE),
    DATE_SUB(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /**
    WILDCARD_QUERY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     * downstream just like {@code parse}. Resolves by identifier-name "GROK" through
     * Variadic {@code CONCAT(a, b, …)} — {@code SqlLibraryOperators.CONCAT_FUNCTION}, distinct from binary {@code ||}.
        }
            if (func.referenceOperator != null) {
    TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    SAFE_CAST(Category.SCALAR, SqlKind.SAFE_CAST),
    UTC_TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /**
    IS_NOT_FALSE(Category.COMPARISON, SqlKind.IS_NOT_FALSE),
     * ships a custom Rust UDF (`udf::mvfind`) registered on its session context.
    POWER(Category.MATH, SqlKind.OTHER_FUNCTION),
    SIN(Category.MATH, SqlKind.OTHER_FUNCTION),
    PERIOD_ADD(Category.SCALAR, SqlKind.OTHER_FUNCTION),
        }
    TIMES(Category.MATH, SqlKind.TIMES),
    DATETIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * Shares the {@code DATE_ADD} lowering: the integer form is treated as {@code INTERVAL N DAY}.
    CONVERT(Category.MATH, SqlKind.OTHER_FUNCTION),
    CASE(Category.SCALAR, SqlKind.CASE),
     */
    DEGREES(Category.MATH, SqlKind.OTHER_FUNCTION),
 *
    /** PPL {@code WEEKDAY(x)} — day-of-week Mon=0..Sun=6 (INTEGER). date_part('dow') remap lowering. */
import org.apache.calcite.sql.SqlKind;
            return null;
     * {@code "mvappend"}. DataFusion's {@code array_concat} only accepts arrays
    CIDRMATCH(Category.COMPARISON, SqlKind.OTHER_FUNCTION),
    NOT(Category.SCALAR, SqlKind.NOT),
/*
     */
    MD5(Category.STRING, SqlKind.OTHER_FUNCTION),
    /**
    public static ScalarFunction fromSqlOperatorWithFallback(SqlOperator operator) {
     * Calcite's {@code SqlStdOperatorTable.ITEM} — element access ({@code arr[N]}).
    /** PPL {@code FROM_DAYS(n)} — inverse of {@link #TO_DAYS}, returns DATE. Epoch-arithmetic lowering. */
        SCALAR
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            }
        if (byKind != null) {
     */
    COS(Category.MATH, SqlKind.OTHER_FUNCTION),
    MVAPPEND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    PREFIX(Category.COMPARISON, SqlKind.OTHER_FUNCTION),
     * and preserves nulls, so the analytics-backend-datafusion plugin ships a
    REVERSE(Category.STRING, SqlKind.OTHER_FUNCTION),
     * plugin's {@code MVFindFunctionImpl} UDF named {@code "mvfind"}. No
     * {@code PPLFuncImpTable} to {@link SqlStdOperatorTable#IS_JSON_VALUE}, which is
        try {
    TRANSLATE(Category.STRING, SqlKind.OTHER_FUNCTION),
    private final SqlOperator referenceOperator;
     *  collides with ISO-SQL WIDTH_BUCKET but semantics and signature differ. */
    // ── PPL bucketing label functions (return VARCHAR labels via Rust UDFs) ──
    SIGN(Category.MATH, SqlKind.OTHER_FUNCTION),
     * (already converted from PPL's 0-based input). DataFusion's native equivalent
    /**
        } catch (IllegalArgumentException ignored) {
    LOG2(Category.MATH, SqlKind.OTHER_FUNCTION),
     */
    MINUTE_OF_HOUR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /** Delegated wildcard query for DSL-origin patterns — passes the Lucene pattern verbatim, no SQL conversion. */
     * Stored as a reference (not a string) so a Calcite-side rename of the operator surfaces as a
     */
     * {@link org.apache.calcite.sql.SqlBinaryOperator} named {@code "||"} (not {@code "CONCAT"})
    DAYOFMONTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CHAR_LENGTH(Category.STRING, SqlKind.OTHER_FUNCTION),
     * {@code MAP<VARCHAR, VARCHAR>}. Resolves by identifier-name through
    /** PPL {@code JSON_OBJECT(k1, v1, k2, v2, …)} — JSON-object constructor over (string, scalar) pairs. */
import java.util.Map;
    UNIX_TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL {@code ADDDATE(<date|timestamp>, N | INTERVAL n unit)} — shift a temporal value forward.
     * Substrait CONSISTENT consistency requires the per-op adapter to unify operand types before emission.
    FUZZY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    /**
     * scalar arguments into one array, dropping null args and null elements.
    DAYOFYEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@code "TIMESTAMPADD"}. Lowering target for PPL `timechart`'s {@code per_*}
    HOUR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    FLOOR(Category.MATH, SqlKind.FLOOR),
    }
    public SqlKind getSqlKind() {
     * @timestamp, TIMESTAMPADD(unit, n, @timestamp)))}. The analytics-backend-datafusion adapter
     * via a name-mapping adapter.
    WEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    LAST_DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * String concatenation. Calcite's {@code SqlStdOperatorTable.CONCAT} is a
    MATCHALL(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    MAKEDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL {@code DATEDIFF(a, b)} — whole-day difference between the calendar dates of two temporal
    DAYNAME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * identifier-name {@link #valueOf(String)} match.
    /**
    /**
     */
     * no separate map to maintain. Lookup is identity-keyed because Calcite's standard operators
 * project, and aggregate expression capability declarations.
        }
    /**
    LESS_THAN(Category.COMPARISON, SqlKind.LESS_THAN),
    BINARY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL {@code DATE_ADD(<date|timestamp|time>, INTERVAL n unit)} — shift a temporal value
    CBRT(Category.MATH, SqlKind.OTHER_FUNCTION),
    STRFTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@code mvjoin} is registered to this operator. DataFusion's native equivalent
    LIKE(Category.COMPARISON, SqlKind.LIKE),
    /**
    LENGTH(Category.STRING, SqlKind.OTHER_FUNCTION),
    ADDDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * day-index subtraction by the analytics-backend-datafusion adapter.
    TRIM(Category.STRING, SqlKind.TRIM),
    ATAN2(Category.MATH, SqlKind.OTHER_FUNCTION),
 * All scalar functions a backend may support — comparisons, full-text search,
 * The OpenSearch Contributors require contributions made to
     */
        ScalarFunction byKind = fromSqlKind(operator.getKind());
    EXP(Category.MATH, SqlKind.OTHER_FUNCTION),
     * <p>Prefer this entry point over {@link #fromSqlKind(SqlKind)} /
    SHA1(Category.STRING, SqlKind.OTHER_FUNCTION),
    /** PPL {@code ADDTIME(a, b)} — a plus b's time-of-day (TIME if a is TIME, else TIMESTAMP). */
    // fromSqlFunction resolves via valueOf(name.toUpperCase()), so the enum name IS
    YEARWEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CONVERT_TZ(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * declaration opts out of the {@link #fromSqlKind(SqlKind)} scan (which would
    private final SqlKind sqlKind;
    /**
     * adapter rewrites numeric span to {@code floor(field/interval)*interval}
     */
     * same {@code MAP<VARCHAR, VARCHAR>} return type, so it pairs with {@link #ITEM}
    MATCH_BOOL_PREFIX(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    }
    SUBSTRING(Category.STRING, SqlKind.OTHER_FUNCTION),
import java.util.Locale;
    ARRAY_LENGTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */
    IS_NULL(Category.COMPARISON, SqlKind.IS_NULL),
    // ── Comparisons ──────────────────────────────────────────────────
     * recursive resolution live entirely in the {@code grok} Rust UDF (the SQL plugin's
    /**
    REPLACE(Category.STRING, SqlKind.OTHER_FUNCTION),
    CURDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    DATE_FORMAT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    REX_EXTRACT(Category.STRING, SqlKind.OTHER_FUNCTION),
    AND(Category.SCALAR, SqlKind.AND),
package org.opensearch.analytics.spi;
        for (ScalarFunction func : values()) {
    MAKETIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * so they must be resolved by name via {@link #fromSqlFunction(SqlFunction)}.
    /**
    LOG10(Category.MATH, SqlKind.OTHER_FUNCTION),
    /**
        STRING,
     */
            return ScalarFunction.valueOf(function.getName().toUpperCase(Locale.ROOT));
     * grok library is not on OpenSearch core's classpath), so no Java-side resolution
            return byReference;
     * is named {@code array_to_string}, so the DataFusion backend rewrites to that
    MOD(Category.MATH, SqlKind.MOD),
     * DataFusion stdlib equivalent — the analytics-backend-datafusion plugin
     * rewrites the call into a DataFusion-native expression because the PPL UDF itself is
    GREATER_THAN_OR_EQUAL(Category.COMPARISON, SqlKind.GREATER_THAN_OR_EQUAL),
    COT(Category.MATH, SqlKind.OTHER_FUNCTION),
        this(category, sqlKind, null);
    JSON_APPEND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    PERIOD_DIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /**
    // md5(x), sha1(x), sha2(x, bitLen) with bitLen ∈ {224,256,384,512}, crc32(x).
    FROM_UNIXTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /** PPL {@code PERIOD_DIFF(P1, P2)} — months between two YYYYMM periods (INTEGER). Integer-arithmetic lowering. */
    GET_FORMAT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    GREATER_THAN(Category.COMPARISON, SqlKind.GREATER_THAN),
    ABS(Category.MATH, SqlKind.OTHER_FUNCTION),
    SARG_PREDICATE(Category.SCALAR, SqlKind.SEARCH),
    ARRAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * otherwise break {@code testFromSqlKindReturnsNullForOtherKind} by claiming
    ACOS(Category.MATH, SqlKind.OTHER_FUNCTION),
     * TIME bases (anchored to the query-start date by the PPL UDF) are left on the UDF path.
 *
    /** PPL {@code TO_SECONDS(x)} — seconds since {@code 0000-01-01} (BIGINT). Epoch-arithmetic lowering. */
    RADIANS(Category.MATH, SqlKind.OTHER_FUNCTION),
    IS_FALSE(Category.COMPARISON, SqlKind.IS_FALSE),
    }
        FULL_TEXT,
     * aggregations, which expand to {@code DIVIDE(agg * scale, TIMESTAMPDIFF('MILLISECOND',
     */
    SYSDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /** PPL {@code SUBTIME(a, b)} — a minus b's time-of-day (TIME if a is TIME, else TIMESTAMP). */
     * is named {@code "||"}). Null for the common case where SqlKind or name resolution suffices.
    /** PPL {@code TO_DAYS(x)} — days since {@code 0000-01-01} (BIGINT). Epoch-arithmetic lowering. */
     * a 3-arg call where the third argument is {@code NULL} for numeric
        return sqlKind;
     * unknown to isthmus's default extension catalog.
     *  like "10-20". NOT ISO SQL width_bucket. */
    COSH(Category.MATH, SqlKind.OTHER_FUNCTION),
        this.category = category;
        }
    DUR2SEC(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    QUARTER(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    JSON_EXTEND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MONTHNAME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MINUTE_OF_DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    LN(Category.MATH, SqlKind.OTHER_FUNCTION),
    }
    TO_SECONDS(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * throwing. Resolves through {@link SqlKind#SAFE_CAST}, distinct from {@link #CAST} which
     * singleton-identity match — same pattern as {@link #CONCAT}.
            return ScalarFunction.valueOf(operator.getName().toUpperCase(Locale.ROOT));
    DAY_OF_YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * concrete Calcite operator constant so resolution is a singleton-identity match — a Calcite
    DATEDIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@link SqlKind}-based resolution matches. The {@link SqlKind#OTHER_FUNCTION}
     * PPL {@code TIMESTAMPDIFF(unit, start, end)} — emits the integer number of {@code unit}s
     * Maps a Calcite SqlFunction to a ScalarFunction by name, or null if not recognized.
    /** PPL {@code JSON(s)} — validate / round-trip a JSON string; NULL on malformed input. */
    RMUNIT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TO_DAYS(Category.SCALAR, SqlKind.OTHER_FUNCTION),
        COMPARISON,
     * name predicate functions (e.g. the delegation block-list).
    PLUS(Category.MATH, SqlKind.PLUS),
     */
    IS_NOT_TRUE(Category.COMPARISON, SqlKind.IS_NOT_TRUE),
    /**
                byOperator.put(func.referenceOperator, func);
    // ── JSON ────────────────────────────────────────────────────────
    /** Calcite's Sarg fold for IN / NOT IN / BETWEEN / range-union. Backends expand it before substrait. */
            // Callers (e.g. OpenSearchProjectRule) short-circuit on null — routing the
    DAY_OF_WEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TOSTRING(Category.STRING, SqlKind.OTHER_FUNCTION),
    MICROSECOND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */
    RIGHT(Category.STRING, SqlKind.OTHER_FUNCTION),
        return null;
    SIMPLE_QUERY_STRING(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
        if (byReference != null) {
    /**
    JSON_EXTRACT_ALL(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    IS_TRUE(Category.COMPARISON, SqlKind.IS_TRUE),
     *  VARCHAR bucket label via the OpenSearch nice-number algorithm. Name
import org.apache.calcite.sql.SqlOperator;
    NULLIF(Category.SCALAR, SqlKind.NULLIF),
        /**
    LOWER(Category.STRING, SqlKind.OTHER_FUNCTION),
    // ── Math ─────────────────────────────────────────────────────────
    /** PPL {@code YEARWEEK(x[, mode])} — year*100+week (INTEGER) via the os_yearweek Rust UDF. */
        // valueOf(toUpperCase). This couples enum constant naming to SQL function naming convention.
     */
    PREFIX_QUERY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
            return valueOf(token.trim().toUpperCase(Locale.ROOT));
    MATCH(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    }
     * via {@link SqlKind} or via identifier-name {@link #valueOf(String)} — typically operators
     * {@code DateAddSubFunction} UDF named {@code "DATE_ADD"}. The analytics-backend-datafusion
    SPAN(Category.SCALAR, SqlKind.OTHER_FUNCTION),
            // name lookup) rather than aborting Hep rule matching with an exception.
    /**
    FROM_DAYS(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /** PPL {@code LAST_DAY(x)} — last day of x's month (DATE). date_trunc('month')+1mo-1day lowering. */
        MATH,
    // vocabulary. Replace with a registration-at-startup mechanism where each frontend
     */
    CONCAT(Category.STRING, SqlKind.OTHER_FUNCTION, SqlStdOperatorTable.CONCAT),
    CAST(Category.SCALAR, SqlKind.CAST),
    /**
    SCALAR_MAX(Category.MATH, SqlKind.OTHER_FUNCTION),
    STR_TO_DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL {@code array(a, b, …)} constructor — resolves through the SQL plugin's
 */
    MINUTE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * is {@code array_element}, also 1-based; the DataFusion backend renames via a
    ScalarFunction(Category category, SqlKind sqlKind, SqlOperator referenceOperator) {
     * PPL {@code parse <field> '<regex>'} — extracts named regex groups into a
    MSTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
