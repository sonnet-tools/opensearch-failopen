import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
     * however, still types the stage input from the pre-expansion aggregate row type, so the
        }
        Map<Integer, Integer> expandedGroupFields = new HashMap<>();
            if (elementType != null && aggregate.getGroupSet().get(fieldIndex)) {
        for (int field : fields) {
     * LIST GROUP BY key with its expanded scalar element (see {@link #rewriteAggregate}), so the
import org.apache.calcite.rel.RelNode;
        boolean changed = false;
 * for a follow-up PR.
        );
import java.util.ArrayList;
    private static ImmutableBitSet remap(ImmutableBitSet fields, Map<Integer, Integer> replacements) {
 * {@code DataFusionFragmentConvertor.preprocessForSubstrait}), which is <em>after</em>
        }
        );
 * {@code decomposeAggregates} call so that Calcite propagates element types into both
     * stream is {@code Utf8View}, which DataFusion rejects at the ReadRel. Retype the affected
                input = expansion;
            stageInput.getTraitSet(),
import org.apache.calcite.util.ImmutableBitSet;
        return builder.build();
                RelNode visited = super.visit(other);
        RelNode input = aggregate.getInput();
 *
 * type instead of being expanded again (see {@link #retypeExpandedStageInputKeys}).
        for (int index = groupSet.cardinality(); index < rewritten.getRowType().getFieldCount(); index++) {
            }
 * the PARTIAL and FINAL fragments and the FINAL-side retyping becomes unnecessary.  That
import java.util.HashMap;
 */
        );
     * FINAL-side counterpart of the expansion above. The PARTIAL fragment already replaced each
                changed = true;
        }
import org.apache.calcite.rel.RelHomogeneousShuttle;
        if (!changed) {
    static RelNode rewrite(RelNode root) {
            builder.build()
        return root.accept(new RelHomogeneousShuttle() {
 * already-expanded rows from its stage input, so its LIST keys are retyped to the element
        for (int fieldIndex = 0; fieldIndex < fields.size(); fieldIndex++) {
}
 */
    /**
 * The OpenSearch Contributors require contributions made to
        RelDataTypeFactory.Builder builder = typeFactory.builder();
            aggregate.getGroupSets().stream().map(fields -> remap(fields, expandedGroupFields)).toList()
            projects.add(rewritten.getCluster().getRexBuilder().makeInputRef(rewritten, index));
     * keys on the stage input to the nullable element type instead; the aggregate's row type
        }
 * requires relocating {@link MultiValueExpandRel} into a module that {@code analytics-engine}
import java.util.Map;
 * {@code PlannerImpl.runAllOptimizations} <em>before</em> the
        return aggregate.copy(
    private MultiValueRelRewriter() {}
            }
 * compatible open source license.
            aggregate.getGroupSet(),
        }
 * this file to be licensed under the Apache-2.0 license or a
        });
     * rows arriving on the reduce stage's input partition carry the element type. Calcite,
 * the grouping set indices so that Substrait serialisation sees scalar types throughout.
 * {@code PlannerImpl.decomposeAggregates} has already split the aggregate into
    private static RelNode rewriteAggregate(Aggregate aggregate) {
import org.apache.calcite.rel.type.RelDataTypeFactory;
    }
                builder.add(field.getName(), field.getType());
            if (input.getRowType().getFieldList().get(fieldIndex).getType().getComponentType() != null) {
        List<ImmutableBitSet> groupSets = ImmutableBitSet.ORDERING.immutableSortedCopy(
import org.apache.calcite.rel.type.RelDataTypeField;
            RelDataTypeField field = fields.get(fieldIndex);
            RelDataType elementType = field.getType().getComponentType();
     * the partition's Substrait {@code base_schema} as {@code List(Utf8)} where the registered
            stageInput.getCluster(),
        if (OpenSearchAggregate.isFinalMode(aggregate) && input instanceof DataFusionFragmentConvertor.StageInputTableScan stageInput) {
 * SPDX-License-Identifier: Apache-2.0
        // Appending group keys can change their ordinal order and uses internal field names. Restore
    }
        for (int originalField : aggregate.getGroupSet()) {
                return visited instanceof Aggregate aggregate ? rewriteAggregate(aggregate) : visited;
            return aggregate;
            public RelNode visit(RelNode other) {
 * <p>This rewriter appends a scalar unnested column per LIST GROUP BY key and remaps
import org.apache.calcite.rel.type.RelDataType;
            builder.set(replacements.getOrDefault(field, field));
import org.apache.calcite.rex.RexNode;
 * It runs at Substrait-conversion time (inside
/*
     * re-derives from the input, so no expansion or reordering Project is needed.
            aggregate.getGroupSets(),
        Aggregate rewritten = aggregate.copy(aggregate.getTraitSet(), input, groupSet, groupSets, aggregate.getAggCallList());
 * {@code analytics-backend-datafusion} extends {@code analytics-engine}).  This is tracked
     * FINAL aggregate would (a) expand an already-scalar column a second time and (b) declare
            stageInput.getTable().getQualifiedName().getFirst(),
 * PARTIAL/FINAL halves. The PARTIAL half is expanded here; the FINAL half reads the
            } else {
            return retypeExpandedStageInputKeys(aggregate, stageInput);
        RelDataTypeFactory typeFactory = aggregate.getCluster().getTypeFactory();
    }
        ImmutableBitSet groupSet = remap(aggregate.getGroupSet(), expandedGroupFields);
 * Adds implicit element expansion for LIST-valued GROUP BY keys.
        return LogicalProject.create(rewritten, List.of(), projects, aggregate.getRowType().getFieldNames());
                MultiValueExpandRel expansion = new MultiValueExpandRel(input, fieldIndex);
        ImmutableBitSet.Builder builder = ImmutableBitSet.builder();
import org.apache.calcite.rel.logical.LogicalProject;
            retyped,
 * can depend on (the dependency currently flows the other way:
package org.opensearch.be.datafusion;
                builder.add(field.getName(), typeFactory.createTypeWithNullability(elementType, true));
/**
        RelNode retyped = new DataFusionFragmentConvertor.StageInputTableScan(
 * <p><b>Known issue</b>: the cleaner fix is to move this expansion into
     */
    private static RelNode retypeExpandedStageInputKeys(Aggregate aggregate, DataFusionFragmentConvertor.StageInputTableScan stageInput) {
    }
 *
        }
            aggregate.getTraitSet(),
            @Override
        }
                expandedGroupFields.put(fieldIndex, expansion.expandedFieldIndex());
            return aggregate;
import java.util.List;
            }
        if (expandedGroupFields.isEmpty()) {
            aggregate.getAggCallList()
import org.apache.calcite.rel.core.Aggregate;
            projects.add(rewritten.getCluster().getRexBuilder().makeInputRef(rewritten, rewrittenGroupFields.indexOf(rewrittenField)));
 *
            int rewrittenField = expandedGroupFields.getOrDefault(originalField, originalField);
        for (int fieldIndex : aggregate.getGroupSet()) {
        List<RexNode> projects = new ArrayList<>(rewritten.getRowType().getFieldCount());
        List<Integer> rewrittenGroupFields = groupSet.asList();
        // the original aggregate output order and names while retaining the expanded scalar types.
        }
final class MultiValueRelRewriter {
        List<RelDataTypeField> fields = stageInput.getRowType().getFieldList();
