import org.apache.calcite.sql.type.SqlTypeName;
 *
class DayOfWeekAdapter implements ScalarFunctionAdapter {  
    }
import java.math.BigDecimal;  
 * PPL {@code dayofweek}/{@code day_of_week} → {@code CAST(date_part('dow', x) + 1 AS <retType>)}:
 * MySQL/PPL uses 1=Sun..7=Sat but DataFusion/Postgres {@code date_part('dow')} returns 0..6, so we
            return original;
import org.apache.calcite.plan.RelOptCluster;
        RexNode operand = DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster);
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
        RelDataType varchar = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
 *  
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rex.RexCall;
 * compatible open source license.
        RexNode sum = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, datePart, rexBuilder.makeExactLiteral(BigDecimal.ONE));  
/**  
        RexNode partLiteral = rexBuilder.makeLiteral("dow", varchar, true);  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        RexNode datePart = rexBuilder.makeCall(SqlLibraryOperators.DATE_PART, partLiteral, operand);
        }  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * add 1 and cast back to the original call's return type.  
package org.opensearch.be.datafusion;
import java.util.List;
    @Override
 */
import org.opensearch.analytics.spi.FieldStorageInfo;  
import org.apache.calcite.rex.RexBuilder;  
import org.apache.calcite.rel.type.RelDataType;
 * <p>VARCHAR / TIME operand handling: see {@link DatePartAdapters}.
}  
        if (original.getOperands().size() != 1) {
/*  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        return rexBuilder.makeCast(original.getType(), sum);
 * @opensearch.internal
 */  
 * SPDX-License-Identifier: Apache-2.0
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 *
