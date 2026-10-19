        return fromName(operator.getName());
    public SqlKind getSqlKind() {
 * this file be licensed under the Apache-2.0 license or a
            return null;
    WindowFunction(SqlKind sqlKind) {  
        return sqlKind;
        return null;  
            if (fn.sqlKind == sqlKind) return fn;
        } catch (IllegalArgumentException e) {  
    ROW_NUMBER(SqlKind.ROW_NUMBER),
    AVG(SqlKind.AVG),  
 *
 */  
 * The OpenSearch Contributors require contributions made to  
    }  
        }
    MIN(SqlKind.MIN),
import org.apache.calcite.sql.SqlKind;
 *
        }
 * {@link WindowFunctionAdapter} before substrait emission, and PATTERN (PPL {@code patterns}).  
    /** Resolves by SqlKind, falling back to operator name for generic OTHER / OTHER_FUNCTION kinds. */
    ARG_MIN(SqlKind.ARG_MIN),
    SUM(SqlKind.SUM),
 * @opensearch.internal
 * ROW_NUMBER (PPL {@code dedup} and {@code streamstats … by} helper), RANK / DENSE_RANK, NTH_VALUE, plus the PPL-form  
 */  
        for (WindowFunction fn : values()) {  
        // Calcite's SqlStdOperatorTable.APPROX_COUNT_DISTINCT (the operator the distinct-count
    }
    PATTERN(SqlKind.OTHER);
        String upper = name.toUpperCase(java.util.Locale.ROOT);
        // is DISTINCT_COUNT_APPROX (PPL ordering: dc/distinct_count). Map the Calcite spelling onto
        try {
 * aggregates {@link #ARG_MIN} / {@link #ARG_MAX} ({@code earliest}/{@code latest}) and
    DISTINCT_COUNT_APPROX(SqlKind.OTHER_FUNCTION),  
    NTH_VALUE(SqlKind.NTH_VALUE),
        }  
/**
            return fn;  
        this.sqlKind = sqlKind;
 * SPDX-License-Identifier: Apache-2.0
            return null;
        if (fn != null) {
        }
    }
    public static WindowFunction fromSqlKind(SqlKind sqlKind) {
    }  
    RANK(SqlKind.RANK),
package org.opensearch.analytics.spi;
    DENSE_RANK(SqlKind.DENSE_RANK),  
        WindowFunction fn = fromSqlKind(operator.getKind());
            return DISTINCT_COUNT_APPROX;
 * {@link #DISTINCT_COUNT_APPROX} ({@code dc}/{@code distinct_count}) that backends rewrite via
    private final SqlKind sqlKind;
    public static WindowFunction fromName(String name) {  
        }
        if ("APPROX_COUNT_DISTINCT".equals(upper)) {
        // rewrite produces over a window) is named "APPROX_COUNT_DISTINCT", but our enum constant  
 * compatible open source license.
    MAX(SqlKind.MAX),  
            return valueOf(upper);
 * Window functions a backend may support. Covers SUM/AVG/COUNT/MIN/MAX (PPL {@code eventstats}),
        // the constant so window distinct-count (eventstats/streamstats dc()) resolves instead of
    public static WindowFunction resolveFunction(SqlOperator operator) {  
    }  
public enum WindowFunction {
    ARG_MAX(SqlKind.ARG_MAX),
}
/*  
        if (sqlKind == SqlKind.OTHER || sqlKind == SqlKind.OTHER_FUNCTION) {  
        // failing as "not supported".  
    COUNT(SqlKind.COUNT),
import org.apache.calcite.sql.SqlOperator;
