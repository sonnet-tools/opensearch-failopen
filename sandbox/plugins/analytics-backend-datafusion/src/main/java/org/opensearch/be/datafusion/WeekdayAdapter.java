        if (original.getOperands().size() != 1) {
        RexNode operand = DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster);
 * compatible open source license.
 * Sunday(0)→6 and Monday(1)→0, matching MySQL.
import org.apache.calcite.plan.RelOptCluster;
 */  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
    }  
package org.opensearch.be.datafusion;
 * @opensearch.internal
 * <p>VARCHAR / TIME operand handling is shared via
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.rex.RexCall;
 * The OpenSearch Contributors require contributions made to  
        RelDataType varchar = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
 * <p>PPL/MySQL {@code WEEKDAY} indexes Monday=0 .. Sunday=6, but DataFusion/Postgres  
import java.math.BigDecimal;  
 * {@code date_part('dow')} returns Sunday=0 .. Saturday=6. The {@code (dow + 6) MOD 7} remap shifts
}
 * {@link DatePartAdapters#coerceCharacterOperandToTimestamp} (see {@link DayOfWeekAdapter}).
/*  
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rel.type.RelDataType;
 * this file be licensed under the Apache-2.0 license or a
        RexBuilder rexBuilder = cluster.getRexBuilder();
        return rexBuilder.makeCast(original.getType(), weekday);
import org.opensearch.analytics.spi.FieldStorageInfo;  
 *  
class WeekdayAdapter implements ScalarFunctionAdapter {  
        RexNode dow = rexBuilder.makeCall(SqlLibraryOperators.DATE_PART, partLiteral, operand);
 *  
            return original;
    @Override
 */
 * PPL {@code weekday(x)} → {@code CAST((date_part('dow', x) + 6) MOD 7 AS <retType>)}.
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
/**  
 *
        RexNode partLiteral = rexBuilder.makeLiteral("dow", varchar, true);  
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
        RexNode shifted = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, dow, rexBuilder.makeExactLiteral(BigDecimal.valueOf(6)));  
import org.apache.calcite.rex.RexBuilder;  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        }  
        RexNode weekday = rexBuilder.makeCall(SqlStdOperatorTable.MOD, shifted, rexBuilder.makeExactLiteral(BigDecimal.valueOf(7)));
 *
