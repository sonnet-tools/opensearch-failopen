     * same {@code MAP<VARCHAR, VARCHAR>} return type, so it pairs with {@link #ITEM}
     * concrete Calcite operator constant so resolution is a singleton-identity match — a Calcite
    SIMPLE_QUERY_STRING(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    MATCH_PHRASE_PREFIX(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
package org.opensearch.analytics.spi;
    NUM(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * Maps a Calcite SqlKind to a ScalarFunction, or null if not recognized.
    public enum Category {
        SCALAR  
     * plugin's {@code MVFindFunctionImpl} UDF named {@code "mvfind"}. No  
    CEIL(Category.MATH, SqlKind.CEIL),
    WEEK_OF_YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * constants resolve by SqlKind or identifier-name valueOf).  
    // ── Cryptographic hash ─────────────────────────────────────────────
    SYSDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL {@code DATE_ADD(<date|timestamp|time>, INTERVAL n unit)} — shift a temporal value
     * Reverse index from {@link #referenceOperator} to enum constant. Built from the enum itself
        return category;
    JSON_VALID(Category.SCALAR, SqlKind.OTHER_FUNCTION, SqlStdOperatorTable.IS_JSON_VALUE),  
    private final SqlOperator referenceOperator;
     * whose {@code getName()} returns a non-identifier token (e.g. {@code SqlStdOperatorTable.CONCAT}
     * Substrait's standard {@code add(timestamp, interval)} to DataFusion's native interval add.  
    /** PPL {@code TIME_TO_SEC(x)} — seconds-of-day of a TIME/TIMESTAMP (BIGINT). Epoch-arithmetic lowering. */
    GREATER_THAN_OR_EQUAL(Category.COMPARISON, SqlKind.GREATER_THAN_OR_EQUAL),
    PARSE(Category.STRING, SqlKind.OTHER_FUNCTION),
 * project, and aggregate expression capability declarations.
    LIKE(Category.COMPARISON, SqlKind.LIKE),  
    EXP(Category.MATH, SqlKind.OTHER_FUNCTION),
     */
     * is named {@code "||"}). Null for the common case where SqlKind or name resolution suffices.  
    MONTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /**
        }
     * String concatenation. Calcite's {@code SqlStdOperatorTable.CONCAT} is a
     */  
    CONVERT(Category.MATH, SqlKind.OTHER_FUNCTION),
     * unknown to isthmus's default extension catalog.
        }
    POSITION(Category.STRING, SqlKind.POSITION),
    DATE_SUB(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * Variadic {@code CONCAT(a, b, …)} — {@code SqlLibraryOperators.CONCAT_FUNCTION}, distinct from binary {@code ||}.
 *
    NOW(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    DAYOFYEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    HOUR_OF_DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CONCAT_WS(Category.STRING, SqlKind.OTHER_FUNCTION),
        MATH,
    MEMK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * a custom Rust UDF (`udf::mvzip`) registered on its session context.  
    /**  
     * Calcite's {@code SqlStdOperatorTable.ITEM} — element access ({@code arr[N]}).
    MATCH_PHRASE(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),  
    DATEDIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /**
        // below — wrapping it in Map.copyOf adds an allocation without any external safety guarantee.  
    TIME_DIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * Stored as a reference (not a string) so a Calcite-side rename of the operator surfaces as a
     */  
    DAY_OF_WEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * name-mapping adapter.
     * rewrites the call into a DataFusion-native interval-add expression.
     * which is neither covered by {@code OTHER} {@code SqlKind} nor by {@code SqlFunction}.
    /**
    CTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@code ParseFunction} UDF in the SQL plugin (3rd operand {@code 'grok'}) and the  
    // fromSqlFunction resolves via valueOf(name.toUpperCase()), so the enum name IS
     * is named {@code array_to_string}, so the DataFusion backend rewrites to that  
    ARRAY_DISTINCT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
 * All scalar functions a backend may support — comparisons, full-text search,
     * PPL's {@code mvindex(arr, N)} single-element form lowers through  
    /**
     * {@link SqlKind}-based resolution matches. The {@link SqlKind#OTHER_FUNCTION}  
    MONTHNAME(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
            if (func.sqlKind == kind && func.sqlKind != SqlKind.OTHER_FUNCTION) {
}  
    WEEKDAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    LOG2(Category.MATH, SqlKind.OTHER_FUNCTION),
    RMUNIT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    SARG_PREDICATE(Category.SCALAR, SqlKind.SEARCH),
    /**
     * day-index subtraction by the analytics-backend-datafusion adapter.
     */
    DAY_OF_YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    LOCATE(Category.STRING, SqlKind.OTHER_FUNCTION),  
     * identity match (handles {@code SqlStdOperatorTable.CONCAT} a.k.a. {@code ||}), then
     * a descriptive {@link IllegalArgumentException} if unrecognized. Used by cluster settings that
     */
    LAST_DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    QUERY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),  
    REVERSE(Category.STRING, SqlKind.OTHER_FUNCTION),
    /** PPL {@code TO_SECONDS(x)} — seconds since {@code 0000-01-01} (BIGINT). Epoch-arithmetic lowering. */
    /** PPL span_bucket(value, span). Rust UDF returning a VARCHAR bucket label
    }
     * PPL {@code grok <field> '<grok-pattern>'} — like {@link #PARSE} but the pattern
    /** PPL {@code conv(n, fromBase, toBase)} — base conversion via Rust UDF. */  
    // ── PPL bucketing label functions (return VARCHAR labels via Rust UDFs) ──  
    JSON_EXTEND(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * Substrait CONSISTENT consistency requires the per-op adapter to unify operand types before emission.
    DAYNAME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    CHAR_LENGTH(Category.STRING, SqlKind.OTHER_FUNCTION),  
        // valueOf(toUpperCase). This couples enum constant naming to SQL function naming convention.
    WILDCARD_QUERY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     * PPL {@code mvfind(arr, regex)} — find the 0-based index of the first array
    TRANSLATE(Category.STRING, SqlKind.OTHER_FUNCTION),
    /** PPL minspan_bucket(value, min_span, data_range, max_value). VARCHAR label. */
     * {@code MAP<VARCHAR, VARCHAR>}. Resolves by identifier-name through
    CASE(Category.SCALAR, SqlKind.CASE),  
     */  
    LESS_THAN(Category.COMPARISON, SqlKind.LESS_THAN),  
        ScalarFunction byKind = fromSqlKind(operator.getKind());
    WILDCARD(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     */
    SCALAR_MIN(Category.MATH, SqlKind.OTHER_FUNCTION),  
     * {@code DateAddSubFunction} UDF named {@code "DATE_ADD"}. The analytics-backend-datafusion
    WILDCARD_QUERY_DSL(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    IS_NOT_NULL(Category.COMPARISON, SqlKind.IS_NOT_NULL),  
    WIDTH_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION),
        } catch (IllegalArgumentException ignored) {
     * via a name-mapping adapter.
            return ScalarFunction.valueOf(function.getName().toUpperCase(Locale.ROOT));
    TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */
    }
    /** PPL range_bucket(value, data_min, data_max, start_param, end_param). VARCHAR label. */
    TO_SECONDS(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     *  
    IS_NOT_FALSE(Category.COMPARISON, SqlKind.IS_NOT_FALSE),
    JSON_ARRAY_LENGTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    YEARWEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@code ArrayFunctionImpl} UDF named {@code "array"}. DataFusion's native
    RANGE_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION);
    /** PPL {@code YEARWEEK(x[, mode])} — year*100+week (INTEGER) via the os_yearweek Rust UDF. */
            return ScalarFunction.valueOf(operator.getName().toUpperCase(Locale.ROOT));
        this(category, sqlKind, null);
 */
        return sqlKind;  
    QUERY_STRING(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     * {@link #fromSqlFunction(SqlFunction)} ({@code SqlKind.OTHER_FUNCTION}
    SUBTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TRIM(Category.STRING, SqlKind.TRIM),  
    GROK(Category.STRING, SqlKind.OTHER_FUNCTION),
     */  
    TIMES(Category.MATH, SqlKind.TIMES),
     * Category of scalar function.
     * fixed-width buckets. PPL's {@code stats … by span(field, N)} lowers to
    /**  
    REGEXP_CONTAINS(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),  
    NUMBER_TO_STRING(Category.STRING, SqlKind.OTHER_FUNCTION), // Alias for TOSTRING
     * UDF named {@code "TIMESTAMPDIFF"}. Lowering target for PPL `timechart`'s {@code per_*}
    DATE_FORMAT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    POWER(Category.MATH, SqlKind.OTHER_FUNCTION),
     * declaration opts out of the {@link #fromSqlKind(SqlKind)} scan (which would
     * PPL {@code json_valid(str)} — resolves through the SQL plugin's
    MAKETIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@link #fromSqlFunction(SqlFunction)} when resolving an arbitrary {@code RexCall}'s
    JSON_KEYS(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    IS_TRUE(Category.COMPARISON, SqlKind.IS_TRUE),
     */
    /**
    ADDDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // ── JSON ────────────────────────────────────────────────────────
    SINH(Category.MATH, SqlKind.OTHER_FUNCTION),  
     * operator: a {@code RexCall} may be backed by a {@code SqlBinaryOperator} (e.g. {@code ||})  
    ABS(Category.MATH, SqlKind.OTHER_FUNCTION),
    MVZIP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
                return func;
     * TIME bases (anchored to the query-start date by the PPL UDF) are left on the UDF path.  
     *  VARCHAR bucket label via the OpenSearch nice-number algorithm. Name  
    PREFIX(Category.COMPARISON, SqlKind.OTHER_FUNCTION),
        } catch (IllegalArgumentException e) {
     * PPL {@code TIMESTAMPADD(unit, value, timestamp)} — emits {@code timestamp + value units}.  
    }
     * {@code "TIMESTAMPADD"}. Lowering target for PPL `timechart`'s {@code per_*}
 * The OpenSearch Contributors require contributions made to  
    IN(Category.COMPARISON, SqlKind.IN),
    // vocabulary. Replace with a registration-at-startup mechanism where each frontend  
import java.util.Locale;
    /**  
     * PPL {@code array(a, b, …)} constructor — resolves through the SQL plugin's  
    // ── Cast / type ──────────────────────────────────────────────────  
     */  
    CBRT(Category.MATH, SqlKind.OTHER_FUNCTION),
    MINUTE(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    CURRENT_DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
        /**  
            // name lookup) rather than aborting Hep rule matching with an exception.
    SUBSTRING(Category.STRING, SqlKind.OTHER_FUNCTION),
     * {@code SpanFunction} UDF named {@code "SPAN"}. The analytics-backend
    MULTI_MATCH(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),  
    /**  
     * unrecognized. Resolution order: {@link SqlKind} match, then {@link #referenceOperator}  
    LOWER(Category.STRING, SqlKind.OTHER_FUNCTION),
     * rename surfaces as a compile error rather than as a silent string mismatch at runtime.  
    MONTH_OF_YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * between two timestamps. Resolves through the SQL plugin's {@code TimestampDiffFunction}  
    DEGREES(Category.MATH, SqlKind.OTHER_FUNCTION),  
    /**
    MINSPAN_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    RMCOMMA(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * Shares the {@code DATE_ADD} lowering: the integer form is treated as {@code INTERVAL N DAY}.
     * {@code PPLFuncImpTable} to {@link SqlStdOperatorTable#IS_JSON_VALUE}, which is  
    // the wire contract. Aliases each need their own entry; the adapter map points
    // ── Datetime ────────────────────────────────────────────────────  
    // ── Conditional ──────────────────────────────────────────────────
        for (ScalarFunction func : values()) {  
    FROM_DAYS(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MINUTE_OF_HOUR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /**  
     * singleton-identity match — same pattern as {@link #CONCAT}.
    }
     */
     * failure, so SAFE_CAST and CAST share the same backend semantics.
    UTC_TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    FLOOR(Category.MATH, SqlKind.FLOOR),
    CRC32(Category.STRING, SqlKind.OTHER_FUNCTION),  
            if (func.referenceOperator != null) {
     * name predicate functions (e.g. the delegation block-list).
        try {  
     * via {@link SqlKind} or via identifier-name {@link #valueOf(String)} — typically operators
    TIMESTAMPADD(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
            }  
    DATETIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * so they must be resolved by name via {@link #fromSqlFunction(SqlFunction)}.  
     * PPL {@code TIMESTAMPDIFF(unit, start, end)} — emits the integer number of {@code unit}s
    /**
     * are singletons (e.g. {@code SqlStdOperatorTable.CONCAT}). Empty in the common case (most
    LENGTH(Category.STRING, SqlKind.OTHER_FUNCTION),
    /** PPL {@code SUBTIME(a, b)} — a minus b's time-of-day (TIME if a is TIME, else TIMESTAMP). */
     * recursive resolution live entirely in the {@code grok} Rust UDF (the SQL plugin's
    ARRAY_LENGTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    HOUR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    NULLIF(Category.SCALAR, SqlKind.NULLIF),
     * DataFusion stdlib equivalent — the analytics-backend-datafusion plugin
    UPPER(Category.STRING, SqlKind.OTHER_FUNCTION),
    PI(Category.MATH, SqlKind.OTHER_FUNCTION),  
    ARRAY_SLICE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
import java.util.Map;
    NOT(Category.SCALAR, SqlKind.NOT),  
        STRING,
    SUBSTR(Category.STRING, SqlKind.OTHER_FUNCTION),
    CONVERT_TZ(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // md5(x), sha1(x), sha2(x, bitLen) with bitLen ∈ {224,256,384,512}, crc32(x).
    }
     * through the SQL plugin's {@code MVZipFunctionImpl} UDF named {@code "mvzip"}.
     */
    /** PPL {@code ADDTIME(a, b)} — a plus b's time-of-day (TIME if a is TIME, else TIMESTAMP). */
        // The HashMap is private static final and never exposed beyond the get() in the resolver
     */
import org.apache.calcite.sql.SqlOperator;  
     * PPL {@code parse <field> '<regex>'} — extracts named regex groups into a  
    /** PPL {@code JSON_ARRAY(v1, v2, …)} — JSON-array constructor over heterogeneous scalars. */
    LESS_THAN_OR_EQUAL(Category.COMPARISON, SqlKind.LESS_THAN_OR_EQUAL),
    IS_NULL(Category.COMPARISON, SqlKind.IS_NULL),
    // cross-frontend semantics (CASE, COALESCE, comparisons, etc.).
    DUR2SEC(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    TOSTRING(Category.STRING, SqlKind.OTHER_FUNCTION),  
     * Maps a Calcite SqlFunction to a ScalarFunction by name, or null if not recognized.
    REGEXP_REPLACE(Category.STRING, SqlKind.OTHER_FUNCTION),
    DIVIDE(Category.MATH, SqlKind.DIVIDE),  
    REX_EXTRACT_MULTI(Category.STRING, SqlKind.OTHER_FUNCTION),  
    CONCAT(Category.STRING, SqlKind.OTHER_FUNCTION, SqlStdOperatorTable.CONCAT),
    public static ScalarFunction fromSqlKind(SqlKind kind) {
    // supplies its own function set, keeping ScalarFunction to operators with
    LN(Category.MATH, SqlKind.OTHER_FUNCTION),
    ARRAY_JOIN(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    MD5(Category.STRING, SqlKind.OTHER_FUNCTION),  
     * adapter rewrites numeric span to {@code floor(field/interval)*interval}  
    LTRIM(Category.STRING, SqlKind.OTHER_FUNCTION),
     */
     * scalar arguments into one array, dropping null args and null elements.
    CURRENT_TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
        }
    COS(Category.MATH, SqlKind.OTHER_FUNCTION),  
     * {@code "mvappend"}. DataFusion's {@code array_concat} only accepts arrays  
    TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // live in the shared analytics-framework SPI — they couple the framework to PPL
        }
    ACOS(Category.MATH, SqlKind.OTHER_FUNCTION),  
    DAYOFWEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    LATEST(Category.COMPARISON, SqlKind.OTHER_FUNCTION),  
    AUTO(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * forward by an interval, returning TIMESTAMP. Resolves through the SQL plugin's  
    ATAN(Category.MATH, SqlKind.OTHER_FUNCTION),
    /** PPL {@code WEEKDAY(x)} — day-of-week Mon=0..Sun=6 (INTEGER). date_part('dow') remap lowering. */  
     * Resolves through the SQL plugin's {@code MVAppendFunctionImpl} UDF named
    /**
    }  
public enum ScalarFunction {
 * math, string, conditional, date/time, and cast operations. Used across filter,  
     * {@link #fromSqlFunction(SqlFunction)}. The grok-pattern dictionary and its  
     * Resolves through the SQL plugin's {@code TimestampAddFunction} UDF named
    // ── Array ────────────────────────────────────────────────────────
     * at class init — adding a new symbolic operator is a single-site change on the enum constant,  
/*  
        this.referenceOperator = referenceOperator;
    }
    DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * @timestamp, TIMESTAMPADD(unit, n, @timestamp)))}. The analytics-backend-datafusion adapter  
    JSON_EXTRACT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MINUTE_OF_DAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    // ── Conversion (placeholder UDFs rewritten by backend adapters) ──  
    public Category getCategory() {
     * …) for time buckets. Resolves through the SQL plugin's
    /**  
     * otherwise break {@code testFromSqlKindReturnsNullForOtherKind} by claiming
    /** PPL {@code PERIOD_DIFF(P1, P2)} — months between two YYYYMM periods (INTEGER). Integer-arithmetic lowering. */
    MINUS(Category.MATH, SqlKind.MINUS),
    MVFIND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * uses {@link SqlKind#CAST}. DataFusion's native cast already returns NULL on conversion  
    // ── Full-text search ─────────────────────────────────────────────
    UTC_DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
         * Catch-all for functions that don't fit other categories (CAST, CASE, COALESCE, EXTRACT, etc.).
    LOG10(Category.MATH, SqlKind.OTHER_FUNCTION),
    STRCMP(Category.STRING, SqlKind.OTHER_FUNCTION),  
    COSH(Category.MATH, SqlKind.OTHER_FUNCTION),
    /** Delegated wildcard query for DSL-origin patterns — passes the Lucene pattern verbatim, no SQL conversion. */
    /** PPL {@code SEC_TO_TIME(n)} — time-of-day n seconds past midnight (TIME). from_unixtime-based lowering. */
    CURTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    REX_EXTRACT(Category.STRING, SqlKind.OTHER_FUNCTION),
     * aggregations, which expand to {@code DIVIDE(agg * scale, TIMESTAMPDIFF('MILLISECOND',
     * throwing. Resolves through {@link SqlKind#SAFE_CAST}, distinct from {@link #CAST} which
    GET_FORMAT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */
    DAYOFMONTH(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    ADDTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
        try {
     * {@link #DATE_ADD}. Lowered to {@code DATETIME_PLUS(base, -interval)} by the
    /**
     * a {@link org.apache.calcite.sql.SqlPostfixOperator} named {@code "IS JSON VALUE"}
     * PPL {@code DATEDIFF(a, b)} — whole-day difference between the calendar dates of two temporal  
    CURDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    YEAR(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    JSON_SET(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * named group at the call site.
        BY_REFERENCE_OPERATOR = byOperator;
    ARRAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * grok library is not on OpenSearch core's classpath), so no Java-side resolution
    TIME_FORMAT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL {@code mvzip(left, right [, sep])} — element-wise zip of two arrays into an
    /** PPL {@code GET_FORMAT(type, region)} — constant MySQL format string (VARCHAR). Plan-time literal fold. */  
     */  
    RTRIM(Category.STRING, SqlKind.OTHER_FUNCTION),  
            return byKind;  
    private static final Map<SqlOperator, ScalarFunction> BY_REFERENCE_OPERATOR;
    SUBDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MATCH(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    CAST(Category.SCALAR, SqlKind.CAST),
    /**  
        FULL_TEXT,  
     * array of strings, joined per pair by a separator (default {@code ","}). Resolves  
    MKTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    SPAN(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    MICROSECOND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * Skips OTHER_FUNCTION — multiple functions share this kind,
    COT(Category.MATH, SqlKind.OTHER_FUNCTION),
    /** PPL {@code TO_DAYS(x)} — days since {@code 0000-01-01} (BIGINT). Epoch-arithmetic lowering. */
    /**
    RADIANS(Category.MATH, SqlKind.OTHER_FUNCTION),
 * it supports parameters (e.g., full-text operators accept analyzer, slop, etc.).
    MATCH_BOOL_PREFIX(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     */
    // ── Comparisons ──────────────────────────────────────────────────
    LOG(Category.MATH, SqlKind.OTHER_FUNCTION),  
    // ── String ───────────────────────────────────────────────────────  
    SAFE_CAST(Category.SCALAR, SqlKind.SAFE_CAST),  
        }
     */  
    public SqlKind getSqlKind() {
 *
    private final SqlKind sqlKind;
    SIGN(Category.MATH, SqlKind.OTHER_FUNCTION),
    REX_OFFSET(Category.STRING, SqlKind.OTHER_FUNCTION),
     * no separate map to maintain. Lookup is identity-keyed because Calcite's standard operators
     * identifier-name {@link #valueOf(String)} match.
     * and preserves nulls, so the analytics-backend-datafusion plugin ships a
    JSON_DELETE(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    OR(Category.SCALAR, SqlKind.OR),
    TONUMBER(Category.STRING, SqlKind.OTHER_FUNCTION),
    WEEK(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * {@link org.apache.calcite.sql.SqlBinaryOperator} named {@code "||"} (not {@code "CONCAT"})
import java.util.HashMap;  
        this.category = category;
     * buckets and a unit-name string ({@code "y"}, {@code "M"}, {@code "d"},  
     * rewrites the call into a DataFusion-native expression because the PPL UDF itself is
     */  
    JSON_OBJECT(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    PLUS(Category.MATH, SqlKind.PLUS),  
    GREATER_THAN(Category.COMPARISON, SqlKind.GREATER_THAN),
    PERIOD_ADD(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    /** PPL {@code FROM_DAYS(n)} — inverse of {@link #TO_DAYS}, returns DATE. Epoch-arithmetic lowering. */  
    /**
    UTC_TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),
        }
    STR_TO_DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    TO_DAYS(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    MAKEDATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    DATE_ADD(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * PPL {@code span(field, interval, unit?)} — bucket {@code field} into  
    E(Category.MATH, SqlKind.OTHER_FUNCTION),
    ScalarFunction(Category category, SqlKind sqlKind, SqlOperator referenceOperator) {
            // function through the non-ScalarFunction path (opaque or YAML-alias based
     * (already converted from PPL's 0-based input). DataFusion's native equivalent
import org.apache.calcite.sql.SqlFunction;
 * SPDX-License-Identifier: Apache-2.0
    ASIN(Category.MATH, SqlKind.OTHER_FUNCTION),
    REPLACE(Category.STRING, SqlKind.OTHER_FUNCTION),
     * a 3-arg call where the third argument is {@code NULL} for numeric
     * Optional Calcite operator that this constant maps to when the operator cannot be resolved  
     * and time span (interval=1) to {@code date_trunc(unit, field)} so the
    CURRENT_TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * Resolves a configuration/setting token (case-insensitive) to a {@link ScalarFunction}, throwing  
    BINARY(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * values ({@code arg1 - arg2}, time-of-day discarded), returning BIGINT. Lowered to a
        if (byKind != null) {
    SIN(Category.MATH, SqlKind.OTHER_FUNCTION),
    MSTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    PATTERN_PARSER(Category.SCALAR, SqlKind.OTHER_FUNCTION),
            return byReference;
    SHA2(Category.STRING, SqlKind.OTHER_FUNCTION),
    QUARTER(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
    ROUND(Category.MATH, SqlKind.OTHER_FUNCTION),
    FROM_UNIXTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
 * <p>Each function carries a {@link Category} indicating its type and whether  
    RIGHT(Category.STRING, SqlKind.OTHER_FUNCTION),
    COALESCE(Category.SCALAR, SqlKind.COALESCE),
    public static ScalarFunction fromSqlOperatorWithFallback(SqlOperator operator) {  
        for (ScalarFunction func : values()) {  
    /**
     * Calcite's {@code ARRAY_JOIN} — joins array elements with a separator. PPL
            return null;  
    SEC_TO_TIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * {@code SqlKind.OTHER}); resolution happens via the {@code referenceOperator}  
     * {@code parse} returns the map, {@code item(map, group)} extracts each
     * equivalent is {@code make_array}, so a backend that supports this needs a
        COMPARISON,
    }  
     * is needed here.  
    public static ScalarFunction fromSqlFunction(SqlFunction function) {  
import org.apache.calcite.sql.SqlKind;
     */
    IS_FALSE(Category.COMPARISON, SqlKind.IS_FALSE),
    CONCAT_FUNCTION(Category.STRING, SqlKind.OTHER_FUNCTION, org.apache.calcite.sql.fun.SqlLibraryOperators.CONCAT_FUNCTION),
        if (byReference != null) {  
    MVAPPEND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    JSON_EXTRACT_ALL(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    /** PPL {@code TIMEDIFF(a, b)} (engine label TIME_DIFF) — difference of two times as a TIME. */  
    JSON_ARRAY(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
        }  
     * is grok syntax ({@code %{HOSTNAME:host}}) rather than a raw regex. Shares the
            }  
    ASCII(Category.STRING, SqlKind.OTHER_FUNCTION),  
     * <p>Prefer this entry point over {@link #fromSqlKind(SqlKind)} /
    SHA1(Category.STRING, SqlKind.OTHER_FUNCTION),
    /**  
    PREFIX_QUERY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
         */
    public static ScalarFunction fromToken(String token) {
 * this file be licensed under the Apache-2.0 license or a
        this.sqlKind = sqlKind;  
    LEFT(Category.STRING, SqlKind.OTHER_FUNCTION),
    /**
    /** Calcite's Sarg fold for IN / NOT IN / BETWEEN / range-union. Backends expand it before substrait. */
     * analytics-backend-datafusion adapter.  
    /** PPL {@code PERIOD_ADD(P, n)} — add n months to a YYYYMM period (INTEGER). Integer-arithmetic lowering. */
    /**
    UNIX_TIMESTAMP(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * custom Rust UDF ({@code udf::mvappend}) registered on its session context.
    // ── Logical connectives ─────────────────────────────────────────  
    EXTRACT(Category.SCALAR, SqlKind.EXTRACT),
    SCALAR_MAX(Category.MATH, SqlKind.OTHER_FUNCTION),
    }
    ITEM(Category.SCALAR, SqlKind.ITEM),  
    JSON(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     * element matching a regex, or NULL if no match. Resolves through the SQL
    ATAN2(Category.MATH, SqlKind.OTHER_FUNCTION),  
        ScalarFunction byReference = BY_REFERENCE_OPERATOR.get(operator);
     * {@code mvjoin} is registered to this operator. DataFusion's native equivalent
    /** PPL {@code LAST_DAY(x)} — last day of x's month (DATE). date_trunc('month')+1mo-1day lowering. */
    FUZZY(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),  
     * name-mapping adapter (see {@code MakeArrayAdapter} in the DataFusion backend).  
    REGEXP(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
    // them at one shared instance.  
     *  like "10-20". NOT ISO SQL width_bucket. */
    JSON_APPEND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     */  
    /**  
 *
    MATCHALL(Category.FULL_TEXT, SqlKind.OTHER_FUNCTION),
     * ships a custom Rust UDF (`udf::mvfind`) registered on its session context.
        // TODO: Add an explicit functionName field per enum constant instead of relying on
     * PPL {@code ADDDATE(<date|timestamp>, N | INTERVAL n unit)} — shift a temporal value forward.
     */
                byOperator.put(func.referenceOperator, func);
     * adapter rewrites the call into {@code DATETIME_PLUS(base, interval)}, which binds through
    EXPM1(Category.MATH, SqlKind.OTHER_FUNCTION),  
/**
    /** Delegated prefix query — passes the value verbatim to Lucene PrefixQueryBuilder. */
        } catch (IllegalArgumentException e) {
            return valueOf(token.trim().toUpperCase(Locale.ROOT));  
     */
     * {@link #ADDDATE}, sharing the {@code DATE_SUB} lowering.
    }
     * {@link #valueOf(String)} resolves it. The {@code referenceOperator} hook below pins the
    NOT_EQUALS(Category.COMPARISON, SqlKind.NOT_EQUALS),  
    // TODO: Frontend/lang-specific functions (NUM/AUTO/MEMK/MKTIME etc.) shouldn't
     * PPL {@code DATE_SUB(<date|timestamp|time>, INTERVAL n unit)} — the subtract counterpart of
    TRUNCATE(Category.MATH, SqlKind.OTHER_FUNCTION),
    TAN(Category.MATH, SqlKind.OTHER_FUNCTION),
     * source value may be NULL or the conversion may fail; returns NULL on failure rather than
    TIMESTAMPDIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
     * Substrait-emitted plan reaches DataFusion as standard primitives.
    EARLIEST(Category.COMPARISON, SqlKind.OTHER_FUNCTION),
    ScalarFunction(Category category, SqlKind sqlKind) {  
    /** PPL {@code JSON_OBJECT(k1, v1, k2, v2, …)} — JSON-object constructor over (string, scalar) pairs. */
    CIDRMATCH(Category.COMPARISON, SqlKind.OTHER_FUNCTION),
    SPAN_BUCKET(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
        try {  
    /**
     * compile error here.
     * with {@link SqlKind#OTHER}. Neither name-based {@link #valueOf(String)} nor
            return null;  
    DATE(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
            // Callers (e.g. OpenSearchProjectRule) short-circuit on null — routing the  
    EQUALS(Category.COMPARISON, SqlKind.EQUALS),
 */  
     * aggregations (see {@link #TIMESTAMPDIFF}). The analytics-backend-datafusion adapter  
     * PPL {@code mvappend(arg1, arg2, …)} — flatten a mixed list of array and  
    /**
 * @opensearch.internal  
    TIME_TO_SEC(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     */  
    /**  
     * with {@link SqlKind#OTHER}, so neither {@link #fromSqlKind(SqlKind)} nor identifier-name  
        Map<SqlOperator, ScalarFunction> byOperator = new HashMap<>();
     */
     * shared with many scalar UDFs). Pairs with {@link #ITEM} downstream:  
    SECOND_OF_MINUTE(Category.SCALAR, SqlKind.OTHER_FUNCTION),  
     */  
     * Calcite's {@code SAFE_CAST} — emitted by PPL's explicit {@code CAST(... AS ...)} when the  
     * is {@code array_element}, also 1-based; the DataFusion backend renames via a  
    STRFTIME(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    SECOND(Category.SCALAR, SqlKind.OTHER_FUNCTION),
    PERIOD_DIFF(Category.SCALAR, SqlKind.OTHER_FUNCTION),
            throw new IllegalArgumentException("Unknown scalar function [" + token + "]");
        return null;
    /** PPL width_bucket(value, num_bins, data_range, max_value). Returns a
    IS_NOT_TRUE(Category.COMPARISON, SqlKind.IS_NOT_TRUE),  
     *  collides with ISO-SQL WIDTH_BUCKET but semantics and signature differ. */
     * {@code MVIndexFunctionImp.resolveSingleElement} to ITEM with a 1-based index
     * No DataFusion stdlib equivalent — the analytics-backend-datafusion plugin ships
     * downstream just like {@code parse}. Resolves by identifier-name "GROK" through
    MOD(Category.MATH, SqlKind.MOD),
    AND(Category.SCALAR, SqlKind.AND),
    private final Category category;  
     * PPL {@code SUBDATE(<date|timestamp>, N | INTERVAL n unit)} — the subtract counterpart of
    RAND(Category.MATH, SqlKind.OTHER_FUNCTION),  
    static {
    // ── Math ─────────────────────────────────────────────────────────
 * compatible open source license.
     * Maps any Calcite {@link SqlOperator} to a {@link ScalarFunction}, or returns null if
    /** PPL {@code JSON(s)} — validate / round-trip a JSON string; NULL on malformed input. */
