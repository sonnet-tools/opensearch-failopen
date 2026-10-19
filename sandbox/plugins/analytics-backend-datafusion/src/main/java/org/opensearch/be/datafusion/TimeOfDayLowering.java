import org.apache.calcite.rex.RexBuilder;  
}  
 * {@code CAST(timestamp AS TIME)} is rejected by DataFusion's optimizer
 * <p>The key building block is {@link #secondsToTime}: it turns a BIGINT seconds expression into a  
        RexBuilder rexBuilder = cluster.getRexBuilder();  
    static final long SECONDS_PER_DAY = 86_400L;
        );
     * The seconds-of-day {@code [0, 86400)} of a temporal value:
        RexNode norm = rexBuilder.makeCall(SqlStdOperatorTable.MOD, plusDay, bigintLit(rexBuilder, SECONDS_PER_DAY));
package org.opensearch.be.datafusion;
    }
        return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT));
    /**
     */
        RexNode mod1 = rexBuilder.makeCall(SqlStdOperatorTable.MOD, secondsExpr, bigintLit(rexBuilder, SECONDS_PER_DAY));
     * {@code [0, 86400)}, decompose into hour/minute/second, and call {@code maketime(h, m, s)}.  
 *
    }
        // norm = ((s MOD 86400) + 86400) MOD 86400 — wraps negatives and >1-day sums into a day.
    static RexNode bigintLit(RexBuilder rexBuilder, long value) {  
    static RexNode secondsToTime(RexNode secondsExpr, RelDataType timeType, RelOptCluster cluster) {
            RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP,
 */
 * past-midnight sums wrap the MySQL way.
        RexNode minute = rexBuilder.makeCall(
            java.util.List.of(
        RexNode second = rexBuilder.makeCall(SqlStdOperatorTable.MOD, norm, bigintLit(rexBuilder, 60));  
            )  
 * {@link AddSubTimeAdapter}, and {@link TimeDiffAdapter}.
 * The OpenSearch Contributors require contributions made to  
 *
 */  
        );
 * ({@code Unsupported CAST from Timestamp to Time}). The seconds are first normalized into a single  
     * {@code ((to_unixtime(anchor(x)) MOD 86400) + 86400) MOD 86400}. The floor-mod is required  
import org.apache.calcite.rel.type.RelDataType;
        RexNode plusDay = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, mod1, bigintLit(rexBuilder, SECONDS_PER_DAY));  
import org.apache.calcite.sql.type.SqlTypeName;  
     * because pre-1970 values have a negative epoch and SQL {@code MOD} truncates toward zero (so a
 * this file be licensed under the Apache-2.0 license or a
    /**
        RexNode hour = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, norm, bigintLit(rexBuilder, 3600));  
    private TimeOfDayLowering() {}
 * SPDX-License-Identifier: Apache-2.0
 *  
 * {@code TIME} value via the {@code maketime(h, m, s)} Rust UDF, because a direct
        RexNode anchored = DatePartAdapters.coerceCharacterOperandToTimestamp(operand, cluster);  
 * day {@code [0, 86400)} with {@code ((s MOD 86400) + 86400) MOD 86400} so negative differences and
import java.math.BigDecimal;  
 * @opensearch.internal
final class TimeOfDayLowering {  
/*  
            timeType,  
     * bare {@code MOD 86400} would yield a negative seconds-of-day).
import org.opensearch.analytics.spi.NumericToDoubleAdapter;
        return rexBuilder.makeCall(SqlStdOperatorTable.MOD, plusDay, bigintLit(rexBuilder, SECONDS_PER_DAY));
     * Build a {@code TIME}-typed value from a BIGINT seconds expression: normalize into
            SqlStdOperatorTable.DIVIDE,
                NumericToDoubleAdapter.widenToDoubleIfNumeric(second, cluster)
                NumericToDoubleAdapter.widenToDoubleIfNumeric(minute, cluster),
        RexNode mod1 = rexBuilder.makeCall(SqlStdOperatorTable.MOD, epoch, bigintLit(rexBuilder, SECONDS_PER_DAY));
    }
        RexNode epoch = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, anchored);
    static RexNode secondsOfDay(RexNode operand, RelOptCluster cluster) {
        return rexBuilder.makeCall(
                NumericToDoubleAdapter.widenToDoubleIfNumeric(hour, cluster),  
        RexBuilder rexBuilder = cluster.getRexBuilder();
/**
     */  
        RexNode plusDay = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, mod1, bigintLit(rexBuilder, SECONDS_PER_DAY));  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.plan.RelOptCluster;
            bigintLit(rexBuilder, 60)
 * compatible open source license.
 * Shared lowering helpers for PPL time-of-day arithmetic, used by {@link SecToTimeAdapter},  
            rexBuilder.makeCall(SqlStdOperatorTable.MOD, norm, bigintLit(rexBuilder, 3600)),  
import org.apache.calcite.rex.RexNode;
