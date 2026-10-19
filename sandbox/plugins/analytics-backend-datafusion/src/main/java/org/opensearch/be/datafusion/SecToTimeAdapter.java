        RexNode seconds = rexBuilder.makeCast(bigint, original.getOperands().get(0), true);  
 */  
 *  
package org.opensearch.be.datafusion;
import org.apache.calcite.rel.type.RelDataType;
 * The OpenSearch Contributors require contributions made to  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 *
 * helper's floor-mod normalization provides that wrap. A direct {@code from_unixtime(n)} +  
import org.apache.calcite.rex.RexNode;
 *
        RexBuilder rexBuilder = cluster.getRexBuilder();
/**  
 * Rust UDF. MySQL wraps second counts past a day (e.g. {@code sec_to_time(123456) = 10:17:36}); the
import java.util.List;
    }
import org.opensearch.analytics.spi.FieldStorageInfo;
 * <p>Lowering: cast {@code n} to BIGINT and hand it to {@link TimeOfDayLowering#secondsToTime}, which  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * {@code CAST AS TIME} can't be used — DataFusion's optimizer rejects {@code CAST from Timestamp to
 * Time} — so {@code maketime} produces the {@code Time64} directly.
import org.apache.calcite.sql.type.SqlTypeName;  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
class SecToTimeAdapter implements ScalarFunctionAdapter {  
        }  
/*  
 * compatible open source license.
import org.apache.calcite.rex.RexCall;
}  
        if (original.getOperands().size() != 1) {
 */
 * PPL {@code sec_to_time(n)} — the time-of-day {@code n} seconds past midnight (returns TIME).
 * normalizes into {@code [0, 86400)} and builds a {@code Time64} via the {@code maketime(h, m, s)}
        RelDataType bigint = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT);
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rex.RexBuilder;  
            return original;
        return TimeOfDayLowering.secondsToTime(seconds, original.getType(), cluster);
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
