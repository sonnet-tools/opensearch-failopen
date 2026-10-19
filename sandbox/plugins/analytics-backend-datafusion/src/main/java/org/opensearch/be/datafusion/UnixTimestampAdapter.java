import org.apache.calcite.sql.SqlOperator;  
        BigDecimal raw = literal.getValueAs(BigDecimal.class);
import org.apache.calcite.sql.type.ReturnTypes;
        if (!(operand instanceof RexLiteral literal)) return null;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.be.datafusion;
        if (digits.length() != 14) return null;
}  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        RexBuilder rexBuilder = cluster.getRexBuilder();
import java.time.DateTimeException;
                return rexBuilder.makeCall(original.getType(), LOCAL_TO_UNIXTIME_OP, List.of(strLit));
        } catch (NumberFormatException | DateTimeException invalid) {
import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.sql.SqlFunction;  
    @Override  
            return null;  
 * <p>Numeric literal in {@code YYYYMMDDhhmmss} shape is rewritten to {@code 'YYYY-MM-DD hh:mm:ss'}
        SqlFunctionCategory.TIMEDATE  
 * Rust UDF registration). PPL declares the result {@code DOUBLE_FORCE_NULLABLE} but DataFusion  
import org.apache.calcite.rex.RexLiteral;
        try {
            if (dateLiteral != null) {  
            int day = Integer.parseInt(digits.substring(6, 8));
        OperandTypes.ANY,
    /** Detect 14-digit numeric literal {@code YYYYMMDDhhmmss}; returns the formatted string or null. */
        }
 * this file be licensed under the Apache-2.0 license or a
            String dateLiteral = numericYyyyMmDdHhMmSsToString(operands.get(0));
 *  
import org.opensearch.analytics.spi.FieldStorageInfo;
 * compatible open source license.
            int minute = Integer.parseInt(digits.substring(10, 12));
 * so {@code to_unixtime} (which only accepts strings/timestamps) can parse it (MySQL semantics).
 * Rewrites PPL's {@code UNIX_TIMESTAMP(ts)} to {@code to_unixtime} (DataFusion's native name; no
import java.math.BigDecimal;
import org.apache.calcite.rex.RexNode;
    static final SqlOperator LOCAL_TO_UNIXTIME_OP = new SqlFunction(  
    /** Locally-declared rewrite target; name matches DataFusion's native {@code to_unixtime}. */
            int month = Integer.parseInt(digits.substring(4, 6));
        if (!SqlTypeName.NUMERIC_TYPES.contains(typeName)) return null;  
    );
import org.apache.calcite.sql.SqlKind;
        if (operands.size() == 1) {
/*  
        }
            return String.format(Locale.ROOT, "%04d-%02d-%02d %02d:%02d:%02d", year, month, day, hour, minute, second);
        return rexBuilder.makeCall(original.getType(), LOCAL_TO_UNIXTIME_OP, operands);
 * holds; the substrait consumer re-resolves and re-coerces by name.
        ReturnTypes.BIGINT_NULLABLE,  
 *  
/**
import org.apache.calcite.rex.RexCall;  
class UnixTimestampAdapter implements ScalarFunctionAdapter {  
            int year = Integer.parseInt(digits.substring(0, 4));  
import java.util.Locale;
 * SPDX-License-Identifier: Apache-2.0
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 */  
                RexNode strLit = rexBuilder.makeLiteral(dateLiteral, rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR), true);
        if (raw == null || raw.scale() > 0) return null;
        null,
    private static String numericYyyyMmDdHhMmSsToString(RexNode operand) {  
            int second = Integer.parseInt(digits.substring(12, 14));
 * returns {@code Int64} — return type is preserved on the rewritten call so {@code Project.isValid}
            }  
        List<RexNode> operands = original.getOperands();  
import java.time.LocalDateTime;  
 */
            int hour = Integer.parseInt(digits.substring(8, 10));  
import org.apache.calcite.sql.SqlFunctionCategory;
        "to_unixtime",
import org.apache.calcite.plan.RelOptCluster;
        SqlTypeName typeName = literal.getType().getSqlTypeName();
import java.util.List;
 * @opensearch.internal
        SqlKind.OTHER_FUNCTION,
 *
    }  
        String digits = raw.toBigInteger().toString();  
import org.apache.calcite.sql.type.SqlTypeName;  
            LocalDateTime.of(year, month, day, hour, minute, second); // calendar validity check  
import org.apache.calcite.rex.RexBuilder;
    }
