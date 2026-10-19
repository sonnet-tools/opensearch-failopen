import org.apache.calcite.avatica.util.TimeUnit;
            SqlStdOperatorTable.DATETIME_PLUS,
        }  
            rexBuilder.makeIntervalLiteral(BigDecimal.ONE, new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO))  
        if (operandType == SqlTypeName.TIMESTAMP
        RexNode monthLiteral = rexBuilder.makeLiteral("month", varchar, true);  
import org.apache.calcite.rex.RexBuilder;
 *  
import org.apache.calcite.rel.type.RelDataType;  
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP), true);  
 *
            asTimestamp = rexBuilder.makeCast(tsType, operand);
            rexBuilder.makeIntervalLiteral(BigDecimal.valueOf(-1), new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO))
            // VARCHAR date string / TIME — anchor to a TIMESTAMP the engine can read.
        RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
        } else {  
            return lastDay;  
 * {@link DatePartAdapters#coerceCharacterOperandToTimestamp}.
import org.apache.calcite.rex.RexNode;  
    }  
}
        return rexBuilder.makeCast(original.getType(), lastDay, true);
        RelDataType tsType = rexBuilder.getTypeFactory()
            return original;
 * {@code DATETIME_PLUS}, both of which bind via Substrait (the stock
 * The OpenSearch Contributors require contributions made to  
class LastDayAdapter implements ScalarFunctionAdapter {  
/**
import java.math.BigDecimal;
            firstOfMonth,
import org.apache.calcite.rex.RexCall;
        if (lastDay.getType().equals(original.getType())) {
        }
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.spi.FieldStorageInfo;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 * <p>DATE / TIMESTAMP operands cast straight to TIMESTAMP; VARCHAR / TIME operands are anchored via
        );  
import org.apache.calcite.sql.SqlIntervalQualifier;
package org.opensearch.be.datafusion;
 * PPL {@code last_day(x)} — the last day of {@code x}'s month, returned as a DATE.  
            plusMonth,
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
 */  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 */
        RexNode operand = original.getOperands().get(0);
 * this file be licensed under the Apache-2.0 license or a
        );
import java.util.List;  
 * <p>Lowering: {@code date_trunc('month', x) + INTERVAL 1 MONTH - INTERVAL 1 DAY}, cast to the
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
 * {@code SqlLibraryOperators.DATE_TRUNC} does not).
 * compatible open source license.
        RexNode asTimestamp;  
            || operandType == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE  
 * of the original month (correct for all month lengths, including leap-year February). Routes
        }  
 * call's declared DATE type. {@code date_trunc('month', x)} snaps to the first of the month,  
        RexNode plusMonth = rexBuilder.makeCall(  
import org.apache.calcite.plan.RelOptCluster;
 *
        RexNode lastDay = rexBuilder.makeCall(
        SqlTypeName operandType = operand.getType().getSqlTypeName();
/*  
            || operandType == SqlTypeName.DATE) {
 * through the local {@code date_trunc} UDF ({@link DateTimeAdapters#LOCAL_DATE_TRUNC_OP}) and  
            SqlStdOperatorTable.DATETIME_PLUS,  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        if (original.getOperands().size() != 1) {
 *  
            asTimestamp = DatePartAdapters.coerceCharacterOperandToTimestamp(operand, cluster);
import org.apache.calcite.sql.parser.SqlParserPos;  
    @Override
 * {@code + 1 month} reaches the first of the next month, and {@code - 1 day} lands on the last day
        RexNode firstOfMonth = rexBuilder.makeCall(DateTimeAdapters.LOCAL_DATE_TRUNC_OP, monthLiteral, asTimestamp);
