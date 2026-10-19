import org.apache.calcite.rex.RexBuilder;  
/**
 * PPL {@code second}/{@code second_of_minute} → {@code CAST(FLOOR(date_part('second', x)) AS ret)}.  
            return original;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.type.SqlTypeName;
    @Override
        RexNode floored = rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, datePartDouble);  
/*  
        RelDataType doubleType = cluster.getTypeFactory()  
import org.apache.calcite.rel.type.RelDataType;
 * @opensearch.internal
 * <p>VARCHAR / TIME operand handling: see {@link DatePartAdapters}.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode partLiteral = rexBuilder.makeLiteral("second", varchar, true);  
 * FLOOR drops {@code date_part}'s fp64 fractional part (integer portion already in [0, 59]); the
 */  
package org.opensearch.be.datafusion;
        RexNode datePart = rexBuilder.makeCall(SqlLibraryOperators.DATE_PART, partLiteral, operand);
 */
 *
    }
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
import org.apache.calcite.rex.RexCall;
 * intermediate CAST to DOUBLE is needed because our substrait YAML declares date_part/floor as
 * fp64-only while Calcite's inference returns BIGINT for {@code part='second'}.  
 * compatible open source license.
        RelDataType varchar = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
 *
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        if (original.getOperands().size() != 1) {
        RexBuilder rexBuilder = cluster.getRexBuilder();
}  
        return rexBuilder.makeCast(original.getType(), floored);
class SecondAdapter implements ScalarFunctionAdapter {  
 * The OpenSearch Contributors require contributions made to  
        }  
import java.util.List;  
import org.opensearch.analytics.spi.FieldStorageInfo;  
        RexNode datePartDouble = rexBuilder.makeCast(doubleType, datePart);
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.plan.RelOptCluster;
        RexNode operand = DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster);
            .createTypeWithNullability(cluster.getTypeFactory().createSqlType(SqlTypeName.DOUBLE), datePart.getType().isNullable());
 *  
 * SPDX-License-Identifier: Apache-2.0
