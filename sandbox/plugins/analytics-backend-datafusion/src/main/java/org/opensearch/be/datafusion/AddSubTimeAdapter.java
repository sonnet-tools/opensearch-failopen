        if (ts.getType().equals(original.getType())) {  
 * compatible open source license.
        RexNode anchoredA = DatePartAdapters.coerceCharacterOperandToTimestamp(a, cluster);
 *   <li><b>TIMESTAMP result:</b> {@code from_unixtime(to_unixtime(a) ± delta)} — whole-second epoch
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            return ts;
    @Override  
        RexNode a = original.getOperands().get(0);  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * this file be licensed under the Apache-2.0 license or a
 * {@code delta = to_unixtime(anchor(b)) MOD 86400}.
import org.apache.calcite.rex.RexNode;
        RexNode delta = TimeOfDayLowering.secondsOfDay(b, cluster);
 *
 *       arithmetic, rebuilt into a timestamp.</li>  
        RexNode ts = rexBuilder.makeCall(tsType, RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, List.of(epochDouble));
package org.opensearch.be.datafusion;
 * @opensearch.internal
        }
            .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP), true);
 * is a {@code TIME}, otherwise {@code TIMESTAMP}. {@code b} contributes only its seconds-of-day,
 */  
import org.opensearch.analytics.spi.FieldStorageInfo;
 * <p>TIME operands are anchored to a TIMESTAMP first because {@code to_unixtime} rejects an Arrow
import org.apache.calcite.rel.type.RelDataType;
        return rexBuilder.makeCast(original.getType(), ts, true);  
    private final boolean isAdd;  
 * <p>Return type (already inferred onto the call by the PPL frontend): {@code TIME} when {@code a}  
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode epoch = rexBuilder.makeCall(addsub, aEpoch, delta);
 *
import org.apache.calcite.plan.RelOptCluster;
/*  
/**
        RexNode aEpoch = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, anchoredA);  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        org.apache.calcite.sql.SqlOperator addsub = isAdd ? SqlStdOperatorTable.PLUS : SqlStdOperatorTable.MINUS;  
    }
            return TimeOfDayLowering.secondsToTime(combined, original.getType(), cluster);
 *       normalized into a day — see {@link TimeOfDayLowering#secondsToTime}.</li>
        // TIMESTAMP result: from_unixtime(to_unixtime(a) ± delta).
 * {@code b} to/from the temporal value {@code a}.
 * <ul>
        if (original.getType().getSqlTypeName() == SqlTypeName.TIME) {
 *
        RelDataType tsType = rexBuilder.getTypeFactory()  
        RexNode epochDouble = NumericToDoubleAdapter.widenToDoubleIfNumeric(epoch, cluster);
class AddSubTimeAdapter implements ScalarFunctionAdapter {
 *  
 * {@code Time64} (see {@link TimeOfDayLowering#secondsOfDay}). {@code from_unixtime} takes fp64.  
        }
import org.opensearch.analytics.spi.NumericToDoubleAdapter;  
 */  
        RexNode b = original.getOperands().get(1);
        }
        if (original.getOperands().size() != 2) {
    AddSubTimeAdapter(boolean isAdd) {
 * The OpenSearch Contributors require contributions made to  
            RexNode combined = rexBuilder.makeCall(addsub, TimeOfDayLowering.secondsOfDay(a, cluster), delta);  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexBuilder;  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        this.isAdd = isAdd;  
    }
 * </ul>  
}
 *
import java.util.List;  
import org.apache.calcite.rex.RexCall;
 * PPL {@code ADDTIME(a, b)} / {@code SUBTIME(a, b)} — add (or subtract) the <em>time-of-day</em> of  
            return original;  
 *   <li><b>TIME result</b> (a is TIME): {@code maketime} of {@code secondsOfDay(a) ± delta},
