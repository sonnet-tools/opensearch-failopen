    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        RexNode sum = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, product, minute);
 * <p>TIME operand handling: see {@link DatePartAdapters}.  
 * PPL {@code minute_of_day(x)} → {@code CAST(date_part('hour', x) * 60 + date_part('minute', x)
import java.math.BigDecimal;  
        RexNode arg = DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster);  
 * AS <retType>)} for TIMESTAMP/DATE/STRING/TIME operands. Reference impl
        RexNode minute = rexBuilder.makeCall(SqlLibraryOperators.DATE_PART, rexBuilder.makeLiteral("minute", varchar, true), arg);
        RexNode product = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, hour, sixty);
import org.apache.calcite.plan.RelOptCluster;
import java.util.List;
        // signature resolves (DATE_PART has no (string, ...) impl). Mirrors DayOfWeek/Second.
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexNode;
        // Coerce a character/TIME operand to TIMESTAMP at emit time so date_part's Substrait
 *
import org.apache.calcite.rex.RexCall;
class MinuteOfDayAdapter implements ScalarFunctionAdapter {
        if (original.getOperands().size() != 1) {
        RexNode hour = rexBuilder.makeCall(SqlLibraryOperators.DATE_PART, rexBuilder.makeLiteral("hour", varchar, true), arg);
 *
    }
        }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * {@code DateTimeFunctions.exprMinuteOfDay} computes {@code MINUTES.between(LocalTime.MIN, time)},  
/*  
package org.opensearch.be.datafusion;
 *
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.sql.type.SqlTypeName;
 * SPDX-License-Identifier: Apache-2.0
        return rexBuilder.makeCast(original.getType(), sum);  
            return original;  
import org.opensearch.analytics.spi.FieldStorageInfo;  
 */  
        RelDataType varchar = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);  
 * which equals {@code hour*60 + minute}.
}
 * compatible open source license.
    @Override  
        RexBuilder rexBuilder = cluster.getRexBuilder();
 * @opensearch.internal
        RexNode sixty = rexBuilder.makeExactLiteral(BigDecimal.valueOf(60));  
import org.apache.calcite.rex.RexBuilder;  
/**  
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
