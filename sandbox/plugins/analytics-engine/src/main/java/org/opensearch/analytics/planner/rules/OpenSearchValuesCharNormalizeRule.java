            RexNode ref = rexBuilder.makeInputRef(normalizedValues, i);
    private static RelNode projectToOriginalRowType(RelOptRuleCall call, RelDataType originalRowType, LogicalValues normalizedValues) {
        return relBuilder.build();
        List<RelDataTypeField> newFields = normalizedValues.getRowType().getFieldList();  
    }
        call.transformTo(projectToOriginalRowType(call, originalRowType, normalizedValues));
            names.add(origFields.get(i).getName());
            return false;
        return t == SqlTypeName.VARCHAR && type.getPrecision() != RelDataType.PRECISION_NOT_SPECIFIED;
        List<String> names = new ArrayList<>(origFields.size());
 *
        }
            ImmutableList.Builder<RexLiteral> row = ImmutableList.builder();
 *
    }
        RelDataType normalizedRowType = typeBuilder.build();
import org.apache.calcite.rex.RexNode;
            if (needsNormalization(field.getType())) {
        RelDataType originalRowType = values.getRowType();  
            if (!newFields.get(i).getType().equals(targetType)) {  
 * in a casting {@link org.apache.calcite.rel.logical.LogicalProject} restoring the original row type.  
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), nullable);
            }
        if (t == SqlTypeName.CHAR) {
        }  
 */  
    private static RelDataType strType(RelDataTypeFactory typeFactory, boolean nullable) {
 * row-conforms-to-schema check. Normalising column and literals to {@code Str} makes both sides match
        if (values.getTuples().isEmpty()) {
        List<RelDataTypeField> fields = originalRowType.getFieldList();
 * compatible open source license.
                ref = rexBuilder.makeCast(targetType, ref);
                if (!normalized[i]) {
import org.apache.calcite.rel.type.RelDataTypeFactory;
 * It covers {@code CHAR} columns and any {@code VARCHAR} column that carries an explicit precision.
 * {@code VARCHAR} type. {@code makeLiteral} would canonicalise a bare string back to {@code CHAR}.  
import org.apache.calcite.rel.RelNode;
            newTuples.add(row.build());  
 *
    }
    public OpenSearchValuesCharNormalizeRule() {  
import org.apache.calcite.plan.RelOptRuleCall;  
    private static boolean needsNormalization(RelDataType type) {
            }
            return true;
 * {@code CHAR} literals produce fixed-length cells that fail the {@code VirtualTableScan}
                typeBuilder.add(field);
        boolean[] normalized = new boolean[fields.size()];
import java.util.ArrayList;  
/**  
        for (int i = 0; i < fields.size(); i++) {
        List<RexNode> projects = new ArrayList<>(origFields.size());
 */  
            return normalizedValues;  
        }
    public void onMatch(RelOptRuleCall call) {
 * and keeps {@code DataFusionFragmentConvertor} generic.  
        }
        RelBuilder relBuilder = call.builder();
        }  
            for (int i = 0; i < tuple.size(); i++) {
    }  
        SqlTypeName t = type.getSqlTypeName();  
                    row.add((RexLiteral) rexBuilder.makeNullLiteral(strType(typeFactory, true)));
        for (List<RexLiteral> tuple : values.getTuples()) {  
public class OpenSearchValuesCharNormalizeRule extends RelOptRule {
                typeBuilder.add(field.getName(), strType(typeFactory, field.getType().isNullable()));  
 * <p>isthmus types each Substrait {@code VirtualTable} cell from its own literal, so mixed-length  
                normalized[i] = true;
 * @opensearch.internal
    @Override
        super(operand(LogicalValues.class, any()), "OpenSearchValuesCharNormalizeRule");
    @Override
/*  
import com.google.common.collect.ImmutableList;
        relBuilder.project(projects, names, /* forceProject */ true);  
        RexBuilder rexBuilder = relBuilder.getRexBuilder();
}
        relBuilder.push(normalizedValues);  
 * Pre-marking rule that rewrites the inline {@link LogicalValues} character columns to
package org.opensearch.analytics.planner.rules;
import org.apache.calcite.rel.type.RelDataType;  
                    row.add(RexLiteral.fromJdbcString(literalTarget, SqlTypeName.CHAR, lit.getValueAs(String.class)));  
    }
        return values.getRowType().getFieldList().stream().anyMatch(f -> needsNormalization(f.getType()));
import org.apache.calcite.tools.RelBuilder;
        RelDataTypeFactory typeFactory = values.getCluster().getTypeFactory();
 * <p>Literals are rebuilt with {@link RexLiteral#fromJdbcString} at a plain unspecified-precision
            }  
import org.apache.calcite.rex.RexLiteral;
                    row.add(lit);
        LogicalValues normalizedValues = (LogicalValues) LogicalValues.create(values.getCluster(), normalizedRowType, newTuples.build());  
 * The OpenSearch Contributors require contributions made to  
        RexBuilder rexBuilder = values.getCluster().getRexBuilder();
        List<RelDataTypeField> origFields = originalRowType.getFieldList();
        for (int i = 0; i < origFields.size(); i++) {  
    /** {@code CHAR} and explicit-precision {@code VARCHAR} need rewriting. Bare {@code VARCHAR} is already {@code Str}. */
        LogicalValues values = call.rel(0);  
                }
        RelDataTypeFactory.Builder typeBuilder = typeFactory.builder();  
                } else if (lit.isNull()) {  
 * this file be licensed under the Apache-2.0 license or a
            projects.add(ref);  
    }
            RelDataType targetType = origFields.get(i).getType();
 *
                } else {
import org.apache.calcite.rel.type.RelDataTypeField;
    public boolean matches(RelOptRuleCall call) {
import org.apache.calcite.rel.logical.LogicalValues;
        LogicalValues values = call.rel(0);  
import org.apache.calcite.plan.RelOptRule;
            } else {
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 * precision-unspecified {@code VARCHAR}, rebuilds the row literals at that type, and wraps the result
        }
import org.apache.calcite.rex.RexBuilder;  
import org.apache.calcite.sql.type.SqlTypeName;  
            RelDataTypeField field = fields.get(i);  
                RexLiteral lit = tuple.get(i);  
        RelDataType literalTarget = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        if (normalizedValues.getRowType().equals(originalRowType)) {
        ImmutableList.Builder<ImmutableList<RexLiteral>> newTuples = ImmutableList.builder();
