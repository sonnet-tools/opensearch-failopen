final class EpochArithmeticAdapters {
            // Reject a malformed string literal at plan time (HTTP 400 + format hint) instead of an
 * {@link RustUdfDateTimeAdapters}). The raw PPL UDFs have no Substrait binding, so isthmus rejects
 * <p>Constants:
    /**
            RexNode epochSeconds = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, epochDays, bigintLit(rexBuilder, SECONDS_PER_DAY));
}
    /**
     * PPL {@code TIME_TO_SEC(x)} — seconds-of-day of a TIME / TIMESTAMP (BIGINT):
            RexNode ts = rexBuilder.makeCall(tsType, RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, List.of(epochSecondsDouble));
 */
    private static RexNode bigintLit(RexBuilder rexBuilder, long value) {
/*
    }
            );
                return original;
                original.getOperands().get(0),
            RexNode epochSecondsDouble = NumericToDoubleAdapter.widenToDoubleIfNumeric(epochSeconds, cluster);
    private static final long SECONDS_PER_DAY = 86_400L;
            // from_unixtime's Substrait signature is fp64; widen the i64 seconds to DOUBLE or
    static final class ToDaysAdapter implements ScalarFunctionAdapter {
 *
     * PPL {@code FROM_DAYS(n)} — inverse of {@link ToDaysAdapter}, returns DATE:
            RexNode total = rexBuilder.makeCall(
                toUnixtime(rexBuilder, original.getOperands().get(0)),
                SqlStdOperatorTable.PLUS,
     */
 * <ul>
 * compatible open source license.
            return pinReturnType(rexBuilder, totalDays, original);
    static final class TimeToSecAdapter implements ScalarFunctionAdapter {
    private static RexNode toUnixtime(RexBuilder rexBuilder, RexNode operand) {
                return original;
 * Lowerings for PPL datetime scalars that reduce to epoch arithmetic over the local
            if (original.getOperands().size() != 1) {
    private static final long DAYS_YEAR0_TO_EPOCH = 719_528L;
import org.apache.calcite.rex.RexCall;
     * {@code to_unixtime(x) / 86400 + 719528}.
    }
 * {@code to_unixtime} / {@code from_unixtime} UDFs (see {@link UnixTimestampAdapter},
 * them; each adapter rewrites to {@code to_unixtime(...)} plus integer arithmetic that lowers
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
     * PPL {@code TO_DAYS(x)} — days since {@code 0000-01-01} (BIGINT):
        if (expr.getType().equals(original.getType())) {
                bigintLit(rexBuilder, SECONDS_PER_DAY)
            }
                bigintLit(rexBuilder, SECONDS_PER_DAY)
            // opaque runtime to_unixtime parse error. Kind.DATE accepts both bare dates and full
import org.opensearch.analytics.spi.NumericToDoubleAdapter;
            return pinReturnType(rexBuilder, secOfDay, original);
            RexNode epochDays = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, days, bigintLit(rexBuilder, DAYS_YEAR0_TO_EPOCH));
        }
        return rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, operand);
 * The OpenSearch Contributors require contributions made to
            );
     */
     * {@code to_unixtime(x) + 62167219200}.
            RexBuilder rexBuilder = cluster.getRexBuilder();
     * {@code from_unixtime((n - 719528) * 86400)}.
 * through the Substrait default catalog.
            RexBuilder rexBuilder = cluster.getRexBuilder();
        }
    static final class ToSecondsAdapter implements ScalarFunctionAdapter {
            if (original.getOperands().size() != 1) {
            );
     * today UTC via the shared {@link DatePartAdapters#coerceCharacterOperandToTimestamp} CONCAT path
    }
     * PPL {@code TO_SECONDS(x)} — seconds since {@code 0000-01-01} (BIGINT):
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
import org.apache.calcite.rel.type.RelDataType;
                rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT),
 *       ({@code 719528 * 86400}).</li>
    }
        @Override
            return expr;
 *   <li>{@code SECONDS_YEAR0_TO_EPOCH = 62167219200} — seconds for the same span
     * {@code to_unixtime} rejects an Arrow {@code Time64} operand, and a direct
 *
    /**
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 */
            RexNode days = rexBuilder.makeCast(
            return pinReturnType(rexBuilder, ts, original);
 *       (MySQL's day 1 is {@code 0000-01-01}, so {@code TO_DAYS('1970-01-01') = 719528}).</li>
 *   <li>{@code DAYS_YEAR0_TO_EPOCH = 719528} — days from {@code 0000-01-01} to {@code 1970-01-01}
    }
     * (cast to VARCHAR, prefix today's date, parse as TIMESTAMP) — the date is modded away anyway.
/**
     * {@code CAST(time AS timestamp)} is also unsupported by DataFusion's optimizer
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            DatetimeLiteralValidator.validate(original.getOperands().get(0), DatetimeLiteralValidator.Kind.DATE);
    /**
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
            // isthmus rejects the call with "Unable to convert call from_unixtime(i64)".
            RexNode totalDays = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, epochDays, bigintLit(rexBuilder, DAYS_YEAR0_TO_EPOCH));
        }
     * ({@code Unsupported CAST from Time64(ns) to Timestamp}), so a bare {@code TIME} is anchored to
    private EpochArithmeticAdapters() {}
            }
            RexNode operand = DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster);
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rex.RexBuilder;
 * SPDX-License-Identifier: Apache-2.0
            RelDataType tsType = rexBuilder.getTypeFactory()
            RexNode epochDays = rexBuilder.makeCall(
    }
import org.opensearch.analytics.spi.FieldStorageInfo;
            DatetimeLiteralValidator.validate(original.getOperands().get(0), DatetimeLiteralValidator.Kind.DATE);
                SqlStdOperatorTable.MOD,
        }
            }
 * @opensearch.internal
                true
            );
                toUnixtime(rexBuilder, operand),
            RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.plan.RelOptCluster;
    private static RexNode pinReturnType(RexBuilder rexBuilder, RexNode expr, RexCall original) {
                return original;
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            RexBuilder rexBuilder = cluster.getRexBuilder();
            RexNode secOfDay = rexBuilder.makeCall(
                .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP), true);
            if (original.getOperands().size() != 1) {
            if (original.getOperands().size() != 1) {
import org.apache.calcite.sql.type.SqlTypeName;
        @Override
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
     */
            // (HTTP 400) rather than letting to_unixtime fail opaquely at runtime (HTTP 500).
     */
            // datetimes, so valid TO_SECONDS inputs like '2020-09-16 07:40:00' still pass.
                bigintLit(rexBuilder, SECONDS_YEAR0_TO_EPOCH)
        return rexBuilder.makeCast(original.getType(), expr, true);
                return original;
            return pinReturnType(rexBuilder, total, original);
                SqlStdOperatorTable.DIVIDE,
            // Reject a malformed string literal at plan time with the PPL format-hint message
     * {@code to_unixtime(x) MOD 86400}. The modulus discards the date, so anchoring is irrelevant.
 *
package org.opensearch.be.datafusion;
            }
import java.math.BigDecimal;
        @Override
 * </ul>
    static final class FromDaysAdapter implements ScalarFunctionAdapter {
    }
        return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT));
        @Override
                toUnixtime(rexBuilder, original.getOperands().get(0)),
        }
    private static final long SECONDS_YEAR0_TO_EPOCH = DAYS_YEAR0_TO_EPOCH * SECONDS_PER_DAY;
