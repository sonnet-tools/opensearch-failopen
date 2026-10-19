 *  
 * <p>Lowering (per operand {@code x}, {@code dayNumber(x) = FLOOR(to_unixtime(x) / 86400)}):
import java.util.List;
        }  
/*  
    }
        if (original.getOperands().size() != 2) {
    /**
 * compatible open source license.
import java.math.BigDecimal;
/**
        RexNode diff = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, left, right);
 * Substrait binding, so isthmus rejects it.  
 * {@link UnixTimestampAdapter}) and the Substrait default catalog. (A {@code date_trunc('day', x)}
        RexNode left = dayNumber(original.getOperands().get(0), cluster);
 *
        RexNode right = dayNumber(original.getOperands().get(1), cluster);  
        RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * wrapper is unnecessary and, on this stack, isthmus can't bind {@code DATE_TRUNC(char, timestamp)}.)
 * {@code arg1 - arg2}.
        return rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, numerator, secondsPerDay);  
 * SPDX-License-Identifier: Apache-2.0
        RexNode mod1 = rexBuilder.makeCall(SqlStdOperatorTable.MOD, epochSeconds, secondsPerDay);
            rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT)  
 */  
 * ({@code to_unixtime}, integer arithmetic) lower through the local {@code to_unixtime} UDF (see  
 * {@code to_unixtime} yields whole epoch seconds (UTC), and the {@code / 86400} floor-divide maps  
 * is {@code 1}, not {@code 0}, because the time-of-day is discarded. Argument order is
import org.apache.calcite.plan.RelOptCluster;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        RexNode epochSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, anchored);  
 * <p>MySQL/PPL semantics: {@code DATEDIFF} is the whole-day difference between the <em>calendar
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
     * matching MySQL's {@code DATEDIFF}-on-times returning 0.
        RexNode plusDay = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, mod1, secondsPerDay);  
     * <pre>{@code   floor(x / d) = (x - ((x MOD d + d) MOD d)) / d}</pre>
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
            BigDecimal.valueOf(TimeOfDayLowering.SECONDS_PER_DAY),
        RexBuilder rexBuilder = cluster.getRexBuilder();
 * any instant within a UTC day to that day's epoch-day index — so the floor-divide <em>is</em> the
        RexNode floorMod = rexBuilder.makeCall(SqlStdOperatorTable.MOD, plusDay, secondsPerDay);
import org.opensearch.analytics.spi.FieldStorageInfo;
        RexNode anchored = DatePartAdapters.coerceCharacterOperandToTimestamp(operand, cluster);
     * integer arithmetic:  
     * rejects {@code Time64}); both operands anchor to the same date so their day-numbers cancel,  
            return original;
        return rexBuilder.makeCast(original.getType(), diff, true);
    private static RexNode dayNumber(RexNode operand, RelOptCluster cluster) {  
class DateDiffAdapter implements ScalarFunctionAdapter {  
    @Override
import org.apache.calcite.rex.RexBuilder;
}
 *
    }  
        if (diff.getType().equals(original.getType())) {
     * Bare {@code TIME} operands are anchored to today's TIMESTAMP first ({@code to_unixtime}
        );
        RexNode secondsPerDay = rexBuilder.makeExactLiteral(
     * isthmus has no {@code FLOOR(i64)} in the bound catalog, so the floor is expressed in pure
            return diff;  
import org.apache.calcite.rex.RexCall;  
 * day truncation and the subtraction is an exact calendar-day delta. Both primitives
        }
 */
     */
     * truncates toward zero, which differs from floor for negative epoch seconds (pre-1970) — and
import org.apache.calcite.rex.RexNode;
 * Rewrites PPL {@code DATEDIFF(a, b)} into a DataFusion-native expression. The PPL UDF has no
 * dates</em> of the two arguments — {@code DATEDIFF('2000-01-02 00:00:00', '2000-01-01 23:59:59')}  
        RexNode numerator = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, epochSeconds, floorMod);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.SqlTypeName;  
     * Epoch-day index of {@code x}: floor-divide {@code to_unixtime(x)} by 86400. SQL {@code /}  
 * <pre>{@code   DATEDIFF(a, b)  →  CAST(dayNumber(a) - dayNumber(b) AS <retType>)}</pre>
package org.opensearch.be.datafusion;
 *  
