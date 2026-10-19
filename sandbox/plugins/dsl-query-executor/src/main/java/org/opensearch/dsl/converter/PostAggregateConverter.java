                    SqlStdOperatorTable.EQUALS,
        // 3. Keep each parent's top K.
            ctx.getCluster().getTypeFactory().createTypeWithNullability(bigint, true),
    /** HAVING: {@code _count >= min_doc_count}, between the aggregate and the plan's bound. */
import org.apache.calcite.rel.logical.LogicalSort;
import org.opensearch.dsl.aggregation.AggregationMetadataBuilder;
 */
 * carried inside every {@code BucketOrder}), so cuts at either bound are deterministic and
            visibleNames.add(field.getName());
        ImmutableList.Builder<RexFieldCollation> orderKeys = ImmutableList.builder();
            if (collation.nullDirection == RelFieldCollation.NullDirection.FIRST) {
import java.util.ArrayList;
 * <p>The collation always ends with the group key ascending (classic search's tie-breaker,
 * The OpenSearch Contributors require contributions made to
                "Nested plan requires the implicit " + AggregationMetadataBuilder.IMPLICIT_COUNT_NAME + " column for its parent totals"
        return metadata != null
    private static RelNode applyHaving(RelNode input, ConversionContext ctx, long minDocCount) throws ConversionException {
    @Override
            RelDataTypeField field = rowType.getField(parentField, false, false);
/**
     * {@code SUM(_count) OVER (PARTITION BY parentFields)} emitted here after HAVING and before
 * compatible open source license.
 * is known to execute it.
            );
        RexNode fetch = metadata.getFetch() == null
        }
            && (metadata.hasBucketOrders()
            throw new ConversionException(
            ? CollationResolver.resolve(metadata, result.getRowType())
        RelDataTypeField countField = rowType.getField(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME, false, false);
            : List.of();
            }
            withWindowNames.add(field.getName());
        }
    protected boolean isApplicable(ConversionContext ctx) {
        }
        List<RelFieldCollation> collations = metadata.hasBucketOrders()
    /** Creates a post-aggregate converter. */
        AggregationMetadata metadata = ctx.getAggregationMetadata();
import org.apache.calcite.rel.RelCollations;
    }
            rexBuilder.makeInputRef(bigint, leftFieldCount + 1),
import org.apache.calcite.rex.RexWindowBounds;
            return applyPerParentTopK(result, ctx, metadata);
                rexBuilder.makeCall(
    public static final String PARENT_ELIGIBLE_NAME = "_parent_eligible";
            RexWindowBounds.UNBOUNDED_FOLLOWING,
import org.apache.calcite.rel.RelFieldCollation;
        List<RexNode> withWindow = new ArrayList<>(leftFieldCount + 2);
                flags.add(SqlKind.NULLS_LAST);
        int leftFieldCount = rowType.getFieldCount();
        RelDataType rowType = input.getRowType();
        List<String> withWindowNames = new ArrayList<>(leftFieldCount + 2);
            false,
        // 2. Window project: every column, plus the per-parent eligible total, plus the rank.
            false
        if (countField == null) {
        }
            bigint,
        RelNode parentPlan = ctx.getParentPlan();
import org.apache.calcite.rex.RexNode;
            true, // allow partial
            false, // range frame
        for (int i = 0; i <= leftFieldCount; i++) {
     * Per-parent top-K for a nested level: semi-join to the parent plan's top-N, window-rank
import org.apache.calcite.rex.RexFieldCollation;
        RelNode ranked = LogicalFilter.create(windowed, rankLimit);
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
import org.apache.calcite.rel.core.JoinRelType;
    protected RelNode doConvert(RelNode input, ConversionContext ctx) throws ConversionException {
 * Applies post-aggregation shaping: an optional HAVING filter ({@code min_doc_count}), then the
                flags.add(SqlKind.DESCENDING);
        for (String parentField : parentFields) {
    /** Name of the transient window-rank column; dropped before the plan's output. */
            if (left == null || right == null) {
     */
            List.of(),
                    + "] requires the parent level's plan for its per-parent bound"
        List<String> parentFields = metadata.getGroupByFieldNames().subList(0, metadata.getGroupByFieldNames().size() - 1);
                    rexBuilder.makeInputRef(right.getType(), leftFieldCount + right.getIndex())
     */
 * <p>Root-level sized plans get a sort with a fetch: the engine's sort becomes a bounded top-K
        List<RexNode> partitionKeys = new ArrayList<>(parentFields.size());
 *
     * eligible-doc total for {@code sum_other_doc_count}. Constant within a parent's rows; public because
        );
        List<RexNode> equalities = new ArrayList<>(parentFields.size());
            SqlStdOperatorTable.LESS_THAN_OR_EQUAL,
        }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            }
 * plan's bound and order.
    }
            throw new ConversionException(
import com.google.common.collect.ImmutableList;
        RexBuilder rexBuilder = ctx.getRexBuilder();
            equalities.add(
        RelNode windowed = LogicalProject.create(joined, List.of(), withWindow, withWindowNames);
        withWindowNames.add(PARENT_ELIGIBLE_NAME);
            rexBuilder.makeInputRef(countField.getType(), countField.getIndex()),
        }
        if (parentPlan == null) {
        // All group fields except the last are the parent's keys (eligibility guarantees
        return LogicalProject.create(ranked, List.of(), visible, visibleNames);
            orderKeys.add(new RexFieldCollation(rexBuilder.makeInputRef(field.getType(), field.getIndex()), flags));
 * <p>Nested levels get the per-parent equivalent ({@link #applyPerParentTopK}): the plan is
                "min_doc_count requires the implicit " + AggregationMetadataBuilder.IMPLICIT_COUNT_NAME + " column in the aggregate output"
        if (collations.isEmpty() && fetch == null) {
 *
            SqlStdOperatorTable.SUM,
        withWindow.add(parentEligible);
            return result;
 * carries its parent's eligible-doc total for {@code sum_other_doc_count}. The window-inside-a-project
        // single-field groupings).
            ? null
package org.opensearch.dsl.converter;
import org.apache.calcite.rel.logical.LogicalFilter;
            ImmutableList.of(), // whole partition — no ordering, unbounded frame
     * within the parent partition, keep rank ≤ K, attach the per-parent eligible total.
        RexNode rowNumber = rexBuilder.makeOver(
        RelNode joined = LogicalJoin.create(input, parentPlan, List.of(), joinCondition, Set.of(), JoinRelType.SEMI);
import org.apache.calcite.sql.SqlKind;
            partitionKeys.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));
            result = applyHaving(result, ctx, metadata.getHavingMinDocCount());
        if (countField == null) {
    /**
        // output keeps the left schema, so downstream indices are unchanged.
            rexBuilder.makeLiteral(metadata.getPerParentFetch(), bigint, false)
    }
 *
        for (RelFieldCollation collation : CollationResolver.resolve(metadata, rowType)) {
 * (O(size) memory, {@code size} rows transferred). The HAVING filter sits between the aggregate
            );
        List<RexNode> visible = new ArrayList<>(leftFieldCount + 1);
        }
            partitionKeys,
     * the per-parent truncation, so every surviving row carries its parent's
        return LogicalSort.create(result, RelCollations.of(collations), null, fetch);
    @Override
 * and the sort, so filtering happens before truncation — truncate-then-filter would return
/*
        withWindow.add(rowNumber);
    private RelNode applyPerParentTopK(RelNode input, ConversionContext ctx, AggregationMetadata metadata) throws ConversionException {
        RexNode parentEligible = rexBuilder.makeOver(
        withWindowNames.add(ROW_NUMBER_NAME);
                || metadata.getFetch() != null
            false,
            false,
        RexNode joinCondition = equalities.size() == 1 ? equalities.get(0) : rexBuilder.makeCall(SqlStdOperatorTable.AND, equalities);
            SqlStdOperatorTable.ROW_NUMBER,
            rexBuilder.makeLiteral(minDocCount, ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT), false)
            } else if (collation.nullDirection == RelFieldCollation.NullDirection.LAST) {
 * fewer than {@code size} buckets where classic search back-fills.
            RexWindowBounds.UNBOUNDED_PRECEDING,
        List<String> visibleNames = new ArrayList<>(leftFieldCount + 1);
        AggregationMetadata metadata = ctx.getAggregationMetadata();
                || metadata.getHavingMinDocCount() != null);
        );
        if (metadata.getHavingMinDocCount() != null) {
        RexNode condition = rexBuilder.makeCall(
            partitionKeys,
                )
        );
            RexWindowBounds.CURRENT_ROW,
import java.util.Set;
            );
 * semi-joined to the parent level's top-N plan (only winning parents' groups survive), then a
            false
        RelDataTypeField countField = input.getRowType().getField(AggregationMetadataBuilder.IMPLICIT_COUNT_NAME, false, false);
        // 4. Drop the transient rank column; the parent-eligible total stays for the response.
}
            RexWindowBounds.UNBOUNDED_PRECEDING,
                    + String.join(",", metadata.getAggNamePath())
            }
            visible.add(rexBuilder.makeInputRef(field.getType(), i));
        for (RelDataTypeField field : rowType.getFieldList()) {
            orderKeys.build(),
import org.opensearch.dsl.aggregation.AggregationMetadata;
import org.apache.calcite.rel.RelNode;
        for (String parentField : parentFields) {
                || metadata.getPerParentFetch() != null
            if (collation.getDirection() == RelFieldCollation.Direction.DESCENDING) {
import org.apache.calcite.rel.logical.LogicalProject;
import java.util.HashSet;
 * plus plain-filter shape is the one unified-query PPL {@code top} emits, so the engine bridge
            true, // rows frame
import org.apache.calcite.sql.type.SqlTypeName;
        if (metadata.getPerParentFetch() != null) {
            withWindow.add(rexBuilder.makeInputRef(field.getType(), field.getIndex()));
 * window computes each row's rank within its parent partition —
    /**
        }
 * {@code SUM(_count) OVER (PARTITION BY parentFields)} as the parent's eligible-document total,
    static final String ROW_NUMBER_NAME = "_row_number_top_";
        RexBuilder rexBuilder = ctx.getRexBuilder();
            RelDataTypeField field = rankedType.getFieldList().get(i);
            RelDataTypeField right = parentPlan.getRowType().getField(parentField, false, false);
            List.of(rexBuilder.makeInputRef(countField.getType(), countField.getIndex())),
                    rexBuilder.makeInputRef(left.getType(), left.getIndex()),
            );
            : ctx.getRexBuilder()
    }
            throw new ConversionException(
        return LogicalFilter.create(input, condition);
        );
            RelDataTypeField left = rowType.getField(parentField, false, false);
        RexNode rankLimit = rexBuilder.makeCall(
        }
     * Column name of a nested plan's per-parent eligible-document total: a window
import java.util.List;
     * the response builder reads it back off the result columns.
 *
                throw new ConversionException("Parent group field '" + parentField + "' not found for nested plan join");
        }
 * SPDX-License-Identifier: Apache-2.0
    public PostAggregateConverter() {}
 * computed before the rank filter so it covers the truncated remainder: every surviving row
public class PostAggregateConverter extends AbstractDslConverter {
            false,
        RelDataType bigint = ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BIGINT);
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexBuilder;
 * {@code ROW_NUMBER() OVER (PARTITION BY parentFields ORDER BY bucketOrder)} — and a filter
        RelDataType rankedType = ranked.getRowType();
import org.apache.calcite.rel.type.RelDataTypeField;
            RelDataTypeField field = rowType.getFieldList().get(collation.getFieldIndex());
        // 1. Semi-join: only groups belonging to the parent plan's top-N survive. The semi
                "Nested aggregation plan ["
 * keeps rank ≤ {@code size}. The same window project also attaches
 * match classic ordering. Uses {@link CollationResolver} to resolve bucket orders against the
 * this file be licensed under the Apache-2.0 license or a
        }
                flags.add(SqlKind.NULLS_FIRST);
            true,
import org.apache.calcite.rel.logical.LogicalJoin;
            Set<SqlKind> flags = new HashSet<>();
 */
        RelNode result = input;
                .makeLiteral(metadata.getFetch(), ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER), false);
 * actual post-aggregation schema.
