            orderKeys.add(new RexFieldCollation(rexBuilder.makeInputRef(field.getType(), field.getIndex()), flags));  
     * Column name of a nested plan's per-parent eligible-document total: a window
            visibleNames.add(field.getName());
        if (metadata.getHavingMinDocCount() != null) {  
        if (countField == null) {
            withWindowNames.add(field.getName());
        RelDataType rowType = input.getRowType();  
            return result;  
    /** Name of the transient window-rank column; dropped before the plan's output. */  
            }
            RelDataTypeField field = rankedType.getFieldList().get(i);
 * plus plain-filter shape is the one unified-query PPL {@code top} emits, so the engine bridge
        RelNode ranked = LogicalFilter.create(windowed, rankLimit);
import java.util.ArrayList;
                    rexBuilder.makeInputRef(left.getType(), left.getIndex()),  
import org.apache.calcite.rel.RelNode;
            }
        return LogicalProject.create(ranked, List.of(), visible, visibleNames);  
            visible.add(rexBuilder.makeInputRef(field.getType(), i));  
 * {@code SUM(_count) OVER (PARTITION BY parentFields)} as the parent's eligible-document total,
import org.apache.calcite.rel.logical.LogicalSort;  
 *
    private RelNode applyPerParentTopK(RelNode input, ConversionContext ctx, AggregationMetadata metadata) throws ConversionException {
                rexBuilder.makeCall(
        RelNode windowed = LogicalProject.create(joined, List.of(), withWindow, withWindowNames);
        return LogicalSort.create(result, RelCollations.of(collations), null, fetch);
                flags.add(SqlKind.NULLS_FIRST);
import org.apache.calcite.rel.type.RelDataType;
            RexWindowBounds.UNBOUNDED_FOLLOWING,
     * Per-parent top-K for a nested level: semi-join to the parent plan's top-N, window-rank
        RexNode condition = rexBuilder.makeCall(
import org.apache.calcite.rel.RelCollations;
import org.apache.calcite.rel.logical.LogicalFilter;  
                throw new ConversionException("Parent group field '" + parentField + "' not found for nested plan join");
            bigint,
            List.of(),
            result = applyHaving(result, ctx, metadata.getHavingMinDocCount());
        List<RelFieldCollation> collations = metadata.hasBucketOrders()
 * carries its parent's eligible-doc total for {@code sum_other_doc_count}. The window-inside-a-project
        int leftFieldCount = rowType.getFieldCount();
        RelDataType rankedType = ranked.getRowType();
        );
            RelDataTypeField right = parentPlan.getRowType().getField(parentField, false, false);
        RelNode parentPlan = ctx.getParentPlan();  
 *
import org.apache.calcite.rel.logical.LogicalJoin;
            rexBuilder.makeLiteral(minDocCount, ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT), false)
import org.apache.calcite.rex.RexWindowBounds;  
    }
import org.apache.calcite.rel.core.JoinRelType;
 * and the sort, so filtering happens before truncation — truncate-then-filter would return  
            true, // rows frame  
import org.opensearch.dsl.aggregation.AggregationMetadataBuilder;
            withWindow.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));
        // 2. Window project: every column, plus the per-parent eligible total, plus the rank.
}
        List<RexNode> withWindow = new ArrayList<>(leftFieldCount + 2);
            false,
 * compatible open source license.
 */  
        for (RelDataTypeField field : rowType.getFieldList()) {  
        List<RexNode> visible = new ArrayList<>(leftFieldCount + 1);
        List<String> parentFields = metadata.getGroupByFieldNames().subList(0, metadata.getGroupByFieldNames().size() - 1);  
            : List.of();
        }  
/**  
        RexBuilder rexBuilder = ctx.getRexBuilder();
            SqlStdOperatorTable.SUM,  
     * within the parent partition, keep rank ≤ K, attach the per-parent eligible total.  
    protected RelNode doConvert(RelNode input, ConversionContext ctx) throws ConversionException {
        if (collations.isEmpty() && fetch == null) {
    }  
        // output keeps the left schema, so downstream indices are unchanged.  
                || metadata.getHavingMinDocCount() != null);
import org.opensearch.dsl.aggregation.AggregationMetadata;
        // 3. Keep each parent's top K.
    /**
                || metadata.getPerParentFetch() != null  
            false,
            } else if (collation.nullDirection == RelFieldCollation.NullDirection.LAST) {
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,  
 * fewer than {@code size} buckets where classic search back-fills.
     */  
            throw new ConversionException(  
            rexBuilder.makeInputRef(countField.getType(), countField.getIndex()),
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.SqlTypeName;  
            if (collation.nullDirection == RelFieldCollation.NullDirection.FIRST) {  
        List<String> withWindowNames = new ArrayList<>(leftFieldCount + 2);
        // 1. Semi-join: only groups belonging to the parent plan's top-N survive. The semi
 * semi-joined to the parent level's top-N plan (only winning parents' groups survive), then a
            RelDataTypeField left = rowType.getField(parentField, false, false);
        withWindow.add(parentEligible);
        List<String> visibleNames = new ArrayList<>(leftFieldCount + 1);  
            ? CollationResolver.resolve(metadata, result.getRowType())  
            }
import org.apache.calcite.rel.RelFieldCollation;  
 * is known to execute it.  
            );
    public PostAggregateConverter() {}
 * {@code ROW_NUMBER() OVER (PARTITION BY parentFields ORDER BY bucketOrder)} — and a filter  
            SqlStdOperatorTable.ROW_NUMBER,  
                flags.add(SqlKind.DESCENDING);
 * <p>The collation always ends with the group key ascending (classic search's tie-breaker,
        RelDataType bigint = ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT);  
 * SPDX-License-Identifier: Apache-2.0
            false
    /** HAVING: {@code _count >= min_doc_count}, between the aggregate and the plan's bound. */
        }
                "Nested aggregation plan ["  
 * computed before the rank filter so it covers the truncated remainder: every surviving row  
    /** Creates a post-aggregate converter. */  
     */
            rexBuilder.makeLiteral(metadata.getPerParentFetch(), bigint, false)
import org.apache.calcite.rex.RexBuilder;  
public class PostAggregateConverter extends AbstractDslConverter {
                flags.add(SqlKind.NULLS_LAST);  
            );  
        for (int i = 0; i <= leftFieldCount; i++) {
            partitionKeys.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));  
        }
 */  
 * <p>Root-level sized plans get a sort with a fetch: the engine's sort becomes a bounded top-K
            orderKeys.build(),  
            RelDataTypeField field = rowType.getFieldList().get(collation.getFieldIndex());
        // single-field groupings).
            RelDataTypeField field = rowType.getField(parentField, false, false);
            partitionKeys,
        RelDataTypeField countField = input.getRowType().getField(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME, false, false);
            List.of(rexBuilder.makeInputRef(countField.getType(), countField.getIndex())),
 *  
            && (metadata.hasBucketOrders()
                || metadata.getFetch() != null
        );
        RelNode result = input;
                )
    protected boolean isApplicable(ConversionContext ctx) {
 * keeps rank ≤ {@code size}. The same window project also attaches
            if (left == null || right == null) {  
            equalities.add(  
                    + String.join(",", metadata.getAggNamePath())
    public static final String PARENT_ELIGIBLE_NAME = "_parent_eligible";
        List<RexNode> equalities = new ArrayList<>(parentFields.size());
        for (RelFieldCollation collation : CollationResolver.resolve(metadata, rowType)) {
 * <p>Nested levels get the per-parent equivalent ({@link #applyPerParentTopK}): the plan is  
        }  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode parentEligible = rexBuilder.makeOver(
        AggregationMetadata metadata = ctx.getAggregationMetadata();  
        for (String parentField : parentFields) {  
        withWindow.add(rowNumber);  
            RexWindowBounds.CURRENT_ROW,
        RexNode rankLimit = rexBuilder.makeCall(
    @Override  
import java.util.HashSet;
 * match classic ordering. Uses {@link CollationResolver} to resolve bucket orders against the
        // All group fields except the last are the parent's keys (eligibility guarantees
                .makeLiteral(metadata.getFetch(), ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER), false);  
            : ctx.getRexBuilder()
            if (collation.getDirection() == RelFieldCollation.Direction.DESCENDING) {  
        }
 * actual post-aggregation schema.
            return applyPerParentTopK(result, ctx, metadata);
        }  
    }
     * the per-parent truncation, so every surviving row carries its parent's  
        // 4. Drop the transient rank column; the parent-eligible total stays for the response.  
            ImmutableList.of(), // whole partition — no ordering, unbounded frame  
 * carried inside every {@code BucketOrder}), so cuts at either bound are deterministic and  
import org.apache.calcite.sql.SqlKind;
            false,  
package org.opensearch.dsl.converter;
 * window computes each row's rank within its parent partition —
        return LogicalFilter.create(input, condition);
 * this file be licensed under the Apache-2.0 license or a
            RexWindowBounds.UNBOUNDED_PRECEDING,
/*  
    @Override
                    rexBuilder.makeInputRef(right.getType(), leftFieldCount + right.getIndex())
        RexNode rowNumber = rexBuilder.makeOver(
            false
     * the response builder reads it back off the result columns.
import org.apache.calcite.rex.RexNode;
        RexBuilder rexBuilder = ctx.getRexBuilder();
        RexNode fetch = metadata.getFetch() == null  
                "min_doc_count requires the implicit " + AggregationMetadataBuilder.IMPLICIT_COUNT_NAME + " column in the aggregate output"
        }
        return metadata != null  
            throw new ConversionException(  
 *
        );  
        withWindowNames.add(ROW_NUMBER_NAME);
        ImmutableList.Builder<RexFieldCollation> orderKeys = ImmutableList.builder();  
     * {@code SUM(_count) OVER (PARTITION BY parentFields)} emitted here after HAVING and before
            Set<SqlKind> flags = new HashSet<>();
    /**  
        if (countField == null) {
            false, // range frame  
        RelNode joined = LogicalJoin.create(input, parentPlan, List.of(), joinCondition, Set.of(), JoinRelType.SEMI);  
        withWindowNames.add(PARENT_ELIGIBLE_NAME);
        }
        }
     * eligible-doc total for {@code sum_other_doc_count}. Constant within a parent's rows; public because
    private static RelNode applyHaving(RelNode input, ConversionContext ctx, long minDocCount) throws ConversionException {  
    static final String ROW_NUMBER_NAME = "_row_number_top_";
    }
        }
import org.apache.calcite.rex.RexFieldCollation;
            partitionKeys,
        List<RexNode> partitionKeys = new ArrayList<>(parentFields.size());  
import org.apache.calcite.rel.type.RelDataTypeField;
                    + "] requires the parent level's plan for its per-parent bound"
        RexNode joinCondition = equalities.size() == 1 ? equalities.get(0) : rexBuilder.makeCall(SqlStdOperatorTable.AND, equalities);
        AggregationMetadata metadata = ctx.getAggregationMetadata();
                "Nested plan requires the implicit " + AggregationMetadataBuilder.IMPLICIT_COUNT_NAME + " column for its parent totals"
            throw new ConversionException(
            SqlStdOperatorTable.LESS_THAN_OR_EQUAL,  
            true, // allow partial
            );
        );  
        if (metadata.getPerParentFetch() != null) {
import com.google.common.collect.ImmutableList;
            ? null
import java.util.Set;
        RelDataTypeField countField = rowType.getField(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME, false, false);
            true,
            );  
 * (O(size) memory, {@code size} rows transferred). The HAVING filter sits between the aggregate
        for (String parentField : parentFields) {
            ctx.getCluster().getTypeFactory().createTypeWithNullability(bigint, true),
import java.util.List;  
        if (parentPlan == null) {
            false,  
            rexBuilder.makeInputRef(bigint, leftFieldCount + 1),
 * plan's bound and order.
import org.apache.calcite.rel.logical.LogicalProject;
        }  
            RexWindowBounds.UNBOUNDED_PRECEDING,
                    SqlStdOperatorTable.EQUALS,
 * Applies post-aggregation shaping: an optional HAVING filter ({@code min_doc_count}), then the
