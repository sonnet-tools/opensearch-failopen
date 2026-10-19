     * {@code from_unixtime((n - 719528) * 86400)}.  
     */
                bigintLit(rexBuilder, SECONDS_YEAR0_TO_EPOCH)
 * <ul>
 */
            RexNode epochSeconds = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, epochDays, bigintLit(rexBuilder, SECONDS_PER_DAY));  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        if (expr.getType().equals(original.getType())) {
            return expr;
    }
            RexBuilder rexBuilder = cluster.getRexBuilder();
            if (original.getOperands().size() != 1) {
     */
/**  
    private static RexNode bigintLit(RexBuilder rexBuilder, long value) {
        return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT));
            // Reject a malformed string literal at plan time with the PPL format-hint message
            RexNode total = rexBuilder.makeCall(
    static final class ToDaysAdapter implements ScalarFunctionAdapter {
    private static RexNode toUnixtime(RexBuilder rexBuilder, RexNode operand) {
     * today UTC via the shared {@link DatePartAdapters#coerceCharacterOperandToTimestamp} CONCAT path
            if (original.getOperands().size() != 1) {
                return original;  
    private static final long DAYS_YEAR0_TO_EPOCH = 719_528L;
 * compatible open source license.
            RexNode secOfDay = rexBuilder.makeCall(
     * {@code to_unixtime(x) / 86400 + 719528}.  
            // isthmus rejects the call with "Unable to convert call from_unixtime(i64)".
    }  
 *       (MySQL's day 1 is {@code 0000-01-01}, so {@code TO_DAYS('1970-01-01') = 719528}).</li>
                rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT),
        }
 * SPDX-License-Identifier: Apache-2.0
        return rexBuilder.makeCast(original.getType(), expr, true);
     * PPL {@code FROM_DAYS(n)} — inverse of {@link ToDaysAdapter}, returns DATE:
                toUnixtime(rexBuilder, original.getOperands().get(0)),  
     * {@code CAST(time AS timestamp)} is also unsupported by DataFusion's optimizer  
                bigintLit(rexBuilder, SECONDS_PER_DAY)  
 * {@code to_unixtime} / {@code from_unixtime} UDFs (see {@link UnixTimestampAdapter},
import org.apache.calcite.plan.RelOptCluster;
}  
 * <p>Constants:
 */  
                SqlStdOperatorTable.DIVIDE,
        }
    static final class ToSecondsAdapter implements ScalarFunctionAdapter {
import java.math.BigDecimal;  
import org.apache.calcite.rel.type.RelDataType;
            return pinReturnType(rexBuilder, total, original);  
     * {@code to_unixtime} rejects an Arrow {@code Time64} operand, and a direct
            RelDataType tsType = rexBuilder.getTypeFactory()
import org.apache.calcite.sql.type.SqlTypeName;
            DatetimeLiteralValidator.validate(original.getOperands().get(0), DatetimeLiteralValidator.Kind.DATE);
            }
     * ({@code Unsupported CAST from Time64(ns) to Timestamp}), so a bare {@code TIME} is anchored to
            return pinReturnType(rexBuilder, totalDays, original);  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            }
     */
 * through the Substrait default catalog.
     * {@code to_unixtime(x) MOD 86400}. The modulus discards the date, so anchoring is irrelevant.
            );
            // (HTTP 400) rather than letting to_unixtime fail opaquely at runtime (HTTP 500).  
 *   <li>{@code SECONDS_YEAR0_TO_EPOCH = 62167219200} — seconds for the same span
        @Override  
        }
    }
import org.apache.calcite.rex.RexCall;
            // datetimes, so valid TO_SECONDS inputs like '2020-09-16 07:40:00' still pass.
            if (original.getOperands().size() != 1) {
    private static RexNode pinReturnType(RexBuilder rexBuilder, RexNode expr, RexCall original) {  
 *
     * (cast to VARCHAR, prefix today's date, parse as TIMESTAMP) — the date is modded away anyway.  
        }  
            RexNode epochDays = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, days, bigintLit(rexBuilder, DAYS_YEAR0_TO_EPOCH));
                return original;  
 * @opensearch.internal  
            }
 * Lowerings for PPL datetime scalars that reduce to epoch arithmetic over the local
    }
    private EpochArithmeticAdapters() {}
            );
        @Override  
     * PPL {@code TO_SECONDS(x)} — seconds since {@code 0000-01-01} (BIGINT):
import org.apache.calcite.rex.RexNode;
 *
            return pinReturnType(rexBuilder, ts, original);
            RexNode days = rexBuilder.makeCast(  
    static final class FromDaysAdapter implements ScalarFunctionAdapter {
                SqlStdOperatorTable.PLUS,
import org.opensearch.analytics.spi.FieldStorageInfo;
            RexNode epochSecondsDouble = NumericToDoubleAdapter.widenToDoubleIfNumeric(epochSeconds, cluster);  
    }
            if (original.getOperands().size() != 1) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            );
import org.opensearch.analytics.spi.NumericToDoubleAdapter;  
    static final class TimeToSecAdapter implements ScalarFunctionAdapter {
import java.util.List;
 * </ul>
            RexNode totalDays = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, epochDays, bigintLit(rexBuilder, DAYS_YEAR0_TO_EPOCH));
    }
 * {@link RustUdfDateTimeAdapters}). The raw PPL UDFs have no Substrait binding, so isthmus rejects  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            RexNode ts = rexBuilder.makeCall(tsType, RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, List.of(epochSecondsDouble));  
                .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP), true);
                SqlStdOperatorTable.MOD,
    }  
            // opaque runtime to_unixtime parse error. Kind.DATE accepts both bare dates and full  
            DatetimeLiteralValidator.validate(original.getOperands().get(0), DatetimeLiteralValidator.Kind.DATE);
                return original;  
     * PPL {@code TO_DAYS(x)} — days since {@code 0000-01-01} (BIGINT):
                bigintLit(rexBuilder, SECONDS_PER_DAY)
    private static final long SECONDS_YEAR0_TO_EPOCH = DAYS_YEAR0_TO_EPOCH * SECONDS_PER_DAY;
            RexNode operand = DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster);  
     * PPL {@code TIME_TO_SEC(x)} — seconds-of-day of a TIME / TIMESTAMP (BIGINT):  
final class EpochArithmeticAdapters {
                toUnixtime(rexBuilder, operand),  
 *   <li>{@code DAYS_YEAR0_TO_EPOCH = 719528} — days from {@code 0000-01-01} to {@code 1970-01-01}  
    /**
            return pinReturnType(rexBuilder, secOfDay, original);  
    /**
            RexBuilder rexBuilder = cluster.getRexBuilder();
        }
        @Override  
 *  
 * The OpenSearch Contributors require contributions made to  
/*  
 * them; each adapter rewrites to {@code to_unixtime(...)} plus integer arithmetic that lowers
 * this file be licensed under the Apache-2.0 license or a
                original.getOperands().get(0),
                return original;  
                true  
            RexBuilder rexBuilder = cluster.getRexBuilder();  
        @Override  
            // Reject a malformed string literal at plan time (HTTP 400 + format hint) instead of an
        return rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, operand);  
     * {@code to_unixtime(x) + 62167219200}.  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            RexBuilder rexBuilder = cluster.getRexBuilder();
    private static final long SECONDS_PER_DAY = 86_400L;  
     */
            }
    /**
            // from_unixtime's Substrait signature is fp64; widen the i64 seconds to DOUBLE or
import org.apache.calcite.rex.RexBuilder;  
            RexNode epochDays = rexBuilder.makeCall(  
                toUnixtime(rexBuilder, original.getOperands().get(0)),
            );
 *       ({@code 719528 * 86400}).</li>  
    /**
package org.opensearch.be.datafusion;
