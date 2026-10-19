import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        RelNode result = input;
 *
            List<RexNode> projects = new ArrayList<>();
        if (!notNullChecks.isEmpty()) {
    protected boolean isApplicable(ConversionContext ctx) {
                    + "] for field '"  
                }  
 * {@code CASE WHEN field IS NOT NULL THEN field ELSE missingValue END} (not COALESCE, which the
        // missing-value substitution for group fields that configure one  
    protected RelNode doConvert(RelNode input, ConversionContext ctx) throws ConversionException {
        RexBuilder rexBuilder = ctx.getRexBuilder();
                    projects.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));
                    projects.add(missingSubstitution(ctx, field, missingValues.get(field.getName())));  
     * Builds {@code CASE WHEN field IS NOT NULL THEN field ELSE missingValue END}, typed
 * Gives group fields classic terms null semantics by inserting operators between the shared
 * produce a NULL group and are skipped.</li>  
        AggregationMetadata metadata = ctx.getAggregationMetadata();
 * compatible open source license.
import org.apache.calcite.rel.RelNode;
import java.util.ArrayList;  
                rexBuilder.makeCall(SqlStdOperatorTable.IS_NOT_NULL, rexBuilder.makeInputRef(field.getType(), field.getIndex()))
import org.apache.calcite.rel.type.RelDataType;
 * <ul>
        RexNode missingLiteral;
}  
 * <li>with {@code missing} — a {@code LogicalProject} replacing the field with
    }
        throws ConversionException {  
 * engine bridge cannot translate), so those documents group under the missing value. A missing  
    private static RexNode missingSubstitution(ConversionContext ctx, RelDataTypeField field, Object missingValue)
                } else {
        RelDataType rowType = input.getRowType();
 */
    }
 * The OpenSearch Contributors require contributions made to  
                fieldNames.add(field.getName());
    /**  
 * grouping indices resolved against the base row type stay valid. Metric columns pass through
            }
 */  
        return ctx.getAggregationMetadata() != null && !ctx.getAggregationMetadata().getGroupByFieldNames().isEmpty();  
            }  
 * untouched: SQL aggregate functions skip NULL inputs, matching classic metric semantics.  
import org.apache.calcite.rel.logical.LogicalFilter;
        return result;  
            result = LogicalProject.create(result, List.of(), projects, fieldNames);  
 * SPDX-License-Identifier: Apache-2.0
        RelDataType nonNullableType = ctx.getCluster().getTypeFactory().createTypeWithNullability(field.getType(), false);
            throw new ConversionException(  
     * its type records that the key can never be null.  
            );  
 * <p>Per group field:
            List<String> fieldNames = new ArrayList<>();  
                e instanceof Exception ex ? ex : null
                "[missing] value ["
            }  
        return rexBuilder.makeCall(nonNullableType, SqlStdOperatorTable.CASE, List.of(isNotNull, fieldRef, missingLiteral));
import java.util.List;
                    + missingValue
 * the top-K groups, and a NULL group must never occupy a top-K slot. Non-nullable fields cannot
 * documents missing a group field; classic terms instead excludes those documents — or, when
import java.util.Map;
        for (String fieldName : metadata.getGroupByFieldNames()) {
import org.opensearch.dsl.aggregation.AggregationMetadata;
 *  
        }
    }
        Map<String, Object> missingValues = metadata.getMissingValues();  
        }
 * the aggregation configures a {@code missing} value, counts them in that value's bucket.
     * non-nullable: neither branch can yield NULL, and the expression becomes a group key, so
            RelDataTypeField field = rowType.getField(fieldName, false, false);  
        List<RexNode> notNullChecks = new ArrayList<>();
    public PreAggregateConverter() {}
        RexBuilder rexBuilder = ctx.getRexBuilder();
     */
            result = LogicalFilter.create(result, RexUtil.composeConjunction(rexBuilder, notNullChecks));  
 *  
        // IS NOT NULL for group fields without a missing value  
 * <li>without {@code missing} — a {@code LogicalFilter(field IS NOT NULL)} below the aggregate,  
            if (missingValues.containsKey(fieldName)) {  
                    + field.getName()
                throw new ConversionException("Group-by field '" + fieldName + "' not found in schema");
            }
                continue;
/**
 * </ul>
            notNullChecks.add(
                    + "' is incompatible with the field type "
        RexNode fieldRef = rexBuilder.makeInputRef(field.getType(), field.getIndex());
            if (field == null) {
        } catch (RuntimeException | AssertionError e) {
        RexNode isNotNull = rexBuilder.makeCall(SqlStdOperatorTable.IS_NOT_NULL, fieldRef);  
public class PreAggregateConverter extends AbstractDslConverter {
            );
import org.apache.calcite.rex.RexBuilder;  
/*  
 * <p>The projection preserves the input schema exactly (same field names and positions), so
 * value equal to a real value merges into that value's bucket, matching classic semantics.</li>
            for (RelDataTypeField field : rowType.getFieldList()) {
import org.apache.calcite.rex.RexUtil;
                    + field.getType().getSqlTypeName(),  
    @Override  
package org.opensearch.dsl.converter;
import org.apache.calcite.rel.logical.LogicalProject;  
    /** Creates a pre-aggregate converter. */
            missingLiteral = rexBuilder.makeLiteral(missingValue, nonNullableType, true);
import org.apache.calcite.rel.type.RelDataTypeField;
 * so a NULL group never forms. The filter must sit below the aggregate: bounded plans keep only
            if (!field.getType().isNullable()) {
        if (!missingValues.isEmpty()) {
        }
import org.apache.calcite.rex.RexNode;
                if (missingValues.containsKey(field.getName())) {
        try {  
                continue; // a non-nullable column cannot produce a NULL group
 * scan+filter base and the {@code LogicalAggregate}. SQL GROUP BY emits a NULL group for  
        }  
 * this file be licensed under the Apache-2.0 license or a
    @Override
