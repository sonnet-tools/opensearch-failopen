            TimeOfDayLowering.secondsOfDay(original.getOperands().get(1), cluster)
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.be.datafusion;
 */  
 * {@code Time64}); the result is rebuilt with {@code maketime} rather than a {@code CAST AS TIME}  
        RexBuilder rexBuilder = cluster.getRexBuilder();  
import org.opensearch.analytics.spi.FieldStorageInfo;  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * @opensearch.internal  
 * {@code secondsOfDay(a) - secondsOfDay(b)}, normalized into a day (e.g.
            TimeOfDayLowering.secondsOfDay(original.getOperands().get(0), cluster),  
        );
 * that DataFusion's optimizer rejects. See {@link TimeOfDayLowering}.
            return original;
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
 *
 *
 * SPDX-License-Identifier: Apache-2.0
class TimeDiffAdapter implements ScalarFunctionAdapter {
 * PPL {@code TIMEDIFF(a, b)} (engine label {@code TIME_DIFF}) — the difference between two  
import org.apache.calcite.rex.RexNode;
        return TimeOfDayLowering.secondsToTime(diff, original.getType(), cluster);  
import org.apache.calcite.rex.RexBuilder;
        }
 * time-of-day values as a {@code TIME}: {@code maketime} of
}
import org.apache.calcite.rex.RexCall;  
            SqlStdOperatorTable.MINUS,
 * {@code TIMEDIFF('23:59:59', '13:00:00') = '10:59:59'}).  
        if (original.getOperands().size() != 2) {  
/**
 */
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * compatible open source license.
import org.apache.calcite.plan.RelOptCluster;
        RexNode diff = rexBuilder.makeCall(
/*  
 * <p>Both operands are anchored to a TIMESTAMP before {@code to_unixtime} (which rejects an Arrow
import java.util.List;  
 *
