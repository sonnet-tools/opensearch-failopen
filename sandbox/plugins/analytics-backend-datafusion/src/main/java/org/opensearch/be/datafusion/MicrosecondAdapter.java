class MicrosecondAdapter implements ScalarFunctionAdapter {
    /** String → TIMESTAMP(6) preserving µs. Bare-time strings get today-anchored first. */
        if (operandType == SqlTypeName.TIME) {
        RelDataType nullableVarchar = factory.createTypeWithNullability(varchar, operand.getType().isNullable());
import java.math.BigDecimal;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.plan.RelOptCluster;
        // force TIMESTAMP(6) so date_part keeps the µs fraction (DataFusion would downcast to ms)
            return rexBuilder.makeCast(tsMicros, concat);
        if (original.getOperands().size() != 1) {
 * SPDX-License-Identifier: Apache-2.0
        return rexBuilder.makeCast(tsMicros, operand);
            java.time.LocalTime.parse(value);
        if (isBareTimeStringLiteral(operand)) {  
        if (value == null) return false;
import org.apache.calcite.sql.type.SqlTypeName;  
        if (!(operand instanceof org.apache.calcite.rex.RexLiteral literal)) return false;  
        RexNode operand = original.getOperands().get(0);
        RexBuilder rexBuilder = cluster.getRexBuilder();
            RexNode concat = rexBuilder.makeCall(varchar, SqlStdOperatorTable.CONCAT, List.of(prefixLit, operand));
        RexNode partLiteral = rexBuilder.makeLiteral("microsecond", varchar, true);  
 * The OpenSearch Contributors require contributions made to  
/*  
import java.util.List;
import org.apache.calcite.rex.RexNode;  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        try {  
        } else if (operandType == SqlTypeName.VARCHAR || operandType == SqlTypeName.CHAR) {
        RelDataType varchar = factory.createSqlType(SqlTypeName.VARCHAR);  
import org.apache.calcite.rex.RexCall;
            return true;
    private static final BigDecimal ONE_MILLION = BigDecimal.valueOf(1_000_000L);  
        } catch (java.time.format.DateTimeParseException ignored) {  
        String value = literal.getValueAs(String.class);
/**
        RexNode prefixLit = rexBuilder.makeLiteral(prefix, varchar, false);
    ) {  
 */  
            RexNode prefixLit = rexBuilder.makeLiteral(prefix, varchar, false);  
        RelDataType tsMicros = factory.createSqlType(SqlTypeName.TIMESTAMP, 6);
    }
        RexNode datePart = rexBuilder.makeCall(SqlLibraryOperators.DATE_PART, partLiteral, operand);
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        return rexBuilder.makeCast(tsMicros, concat);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    @Override
 */  
        }  
package org.opensearch.be.datafusion;
        RexNode timeAsVarchar = rexBuilder.makeCast(nullableVarchar, operand);  
    private static RexNode todayPrefixedTimeAsTimestamp6(
        RexNode operand,
        RexNode mod = rexBuilder.makeCall(SqlStdOperatorTable.MOD, datePart, rexBuilder.makeExactLiteral(ONE_MILLION));
 *
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexBuilder rexBuilder,  
    private static RexNode stringAsTimestamp6(RexNode operand, RexBuilder rexBuilder, RelDataTypeFactory factory, RelDataType tsMicros) {
        RelDataTypeFactory factory = cluster.getTypeFactory();
        } else if (operandType == SqlTypeName.TIMESTAMP) {  
 * PPL {@code MICROSECOND(x)} returns sub-second microseconds (0..999_999); date_part returns
 * @opensearch.internal
        }
            return original;
        RelDataType tsMicros
    /** TIME → CONCAT('today ', CAST(time AS VARCHAR)) → TIMESTAMP(6). */  
            operand = rexBuilder.makeCast(tsMicros, operand);
    }
 * compatible open source license.
        String prefix = java.time.LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";
        RelDataType varchar = factory.createSqlType(SqlTypeName.VARCHAR);
    }  
            operand = stringAsTimestamp6(operand, rexBuilder, factory, tsMicros);
import org.apache.calcite.rex.RexBuilder;
        }  
            return false;
        return rexBuilder.makeCast(original.getType(), mod);  
        RexNode concat = rexBuilder.makeCall(nullableVarchar, SqlStdOperatorTable.CONCAT, List.of(prefixLit, timeAsVarchar));  
            String prefix = java.time.LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";
 * {@code seconds * 1_000_000 + microseconds}, so wrap in {@code MOD(..., 1_000_000)}.  
        SqlTypeName operandType = operand.getType().getSqlTypeName();  
import org.opensearch.analytics.spi.FieldStorageInfo;
 *
        }
            operand = todayPrefixedTimeAsTimestamp6(operand, rexBuilder, factory, tsMicros);  
import org.apache.calcite.rel.type.RelDataType;
        RelDataTypeFactory factory,
    private static boolean isBareTimeStringLiteral(RexNode operand) {
}
    }
 * this file be licensed under the Apache-2.0 license or a
    /** True for a CHAR/VARCHAR {@link org.apache.calcite.rex.RexLiteral} that parses as bare time only. */
            RelDataType varchar = factory.createSqlType(SqlTypeName.VARCHAR);
