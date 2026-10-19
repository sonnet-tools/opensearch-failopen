        RelDataTypeFactory typeFactory = aggregate.getCluster().getTypeFactory();
        RelNode input = aggregate.getInput();
    private MultiValueRelRewriter() {}
            projects.add(rewritten.getCluster().getRexBuilder().makeInputRef(rewritten, rewrittenGroupFields.indexOf(rewrittenField)));  
 * {@code analytics-backend-datafusion} extends {@code analytics-engine}).  This is tracked
    private static ImmutableBitSet remap(ImmutableBitSet fields, Map<Integer, Integer> replacements) {
 * this file to be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.type.RelDataTypeField;
        List<Integer> rewrittenGroupFields = groupSet.asList();
 * SPDX-License-Identifier: Apache-2.0
            @Override
     * stream is {@code Utf8View}, which DataFusion rejects at the ReadRel. Retype the affected  
 *
            aggregate.getGroupSets().stream().map(fields -> remap(fields, expandedGroupFields)).toList()
    private static RelNode rewriteAggregate(Aggregate aggregate) {
 *
 * the PARTIAL and FINAL fragments and the FINAL-side retyping becomes unnecessary.  That
        if (OpenSearchAggregate.isFinalMode(aggregate) && input instanceof DataFusionFragmentConvertor.StageInputTableScan stageInput) {  
 * <p><b>Known issue</b>: the cleaner fix is to move this expansion into
 * for a follow-up PR.  
                changed = true;
            stageInput.getTable().getQualifiedName().getFirst(),
            } else {  
 * can depend on (the dependency currently flows the other way:
            if (elementType != null && aggregate.getGroupSet().get(fieldIndex)) {  
        return builder.build();  
        }
        if (!changed) {
        }
            public RelNode visit(RelNode other) {  
            return aggregate;
 * Adds implicit element expansion for LIST-valued GROUP BY keys.  
    /**
 * The OpenSearch Contributors require contributions made to  
     * re-derives from the input, so no expansion or reordering Project is needed.
package org.opensearch.be.datafusion;
        return aggregate.copy(
            projects.add(rewritten.getCluster().getRexBuilder().makeInputRef(rewritten, index));  
        );
 */
import org.apache.calcite.util.ImmutableBitSet;  
 * {@code PlannerImpl.decomposeAggregates} has already split the aggregate into  
            builder.set(replacements.getOrDefault(field, field));
                MultiValueExpandRel expansion = new MultiValueExpandRel(input, fieldIndex);  
        }
        for (int field : fields) {  
            aggregate.getAggCallList()  
 * compatible open source license.
            int rewrittenField = expandedGroupFields.getOrDefault(originalField, originalField);
        for (int index = groupSet.cardinality(); index < rewritten.getRowType().getFieldCount(); index++) {
                builder.add(field.getName(), typeFactory.createTypeWithNullability(elementType, true));
            stageInput.getCluster(),
        return root.accept(new RelHomogeneousShuttle() {
            }  
final class MultiValueRelRewriter {
        for (int originalField : aggregate.getGroupSet()) {
        }
    }
     * however, still types the stage input from the pre-expansion aggregate row type, so the  
                RelNode visited = super.visit(other);
 */  
import java.util.ArrayList;  
            stageInput.getTraitSet(),  
 * PARTIAL/FINAL halves. The PARTIAL half is expanded here; the FINAL half reads the
        boolean changed = false;
        for (int fieldIndex = 0; fieldIndex < fields.size(); fieldIndex++) {  
        if (expandedGroupFields.isEmpty()) {
 * {@code PlannerImpl.runAllOptimizations} <em>before</em> the  
        Map<Integer, Integer> expandedGroupFields = new HashMap<>();  
            builder.build()
        return LogicalProject.create(rewritten, List.of(), projects, aggregate.getRowType().getFieldNames());
 * type instead of being expanded again (see {@link #retypeExpandedStageInputKeys}).  
     * the partition's Substrait {@code base_schema} as {@code List(Utf8)} where the registered
import java.util.Map;  
}
        }
        for (int fieldIndex : aggregate.getGroupSet()) {
        List<RelDataTypeField> fields = stageInput.getRowType().getFieldList();  
     * LIST GROUP BY key with its expanded scalar element (see {@link #rewriteAggregate}), so the
        RelDataTypeFactory.Builder builder = typeFactory.builder();
                expandedGroupFields.put(fieldIndex, expansion.expandedFieldIndex());
/*  
            }  
            }
        List<ImmutableBitSet> groupSets = ImmutableBitSet.ORDERING.immutableSortedCopy(
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            return aggregate;  
            if (input.getRowType().getFieldList().get(fieldIndex).getType().getComponentType() != null) {
     * rows arriving on the reduce stage's input partition carry the element type. Calcite,
        }  
import org.apache.calcite.rel.RelHomogeneousShuttle;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.rel.core.Aggregate;  
        RelNode retyped = new DataFusionFragmentConvertor.StageInputTableScan(
import org.apache.calcite.rel.type.RelDataType;
            return retypeExpandedStageInputKeys(aggregate, stageInput);
        // Appending group keys can change their ordinal order and uses internal field names. Restore  
 * {@code DataFusionFragmentConvertor.preprocessForSubstrait}), which is <em>after</em>
            RelDataType elementType = field.getType().getComponentType();
            aggregate.getTraitSet(),
        }  
        );  
            retyped,  
 *
        Aggregate rewritten = aggregate.copy(aggregate.getTraitSet(), input, groupSet, groupSets, aggregate.getAggCallList());
    static RelNode rewrite(RelNode root) {  
import org.apache.calcite.rel.logical.LogicalProject;
            RelDataTypeField field = fields.get(fieldIndex);
 * <p>This rewriter appends a scalar unnested column per LIST GROUP BY key and remaps
        ImmutableBitSet groupSet = remap(aggregate.getGroupSet(), expandedGroupFields);  
 * It runs at Substrait-conversion time (inside
                input = expansion;
                builder.add(field.getName(), field.getType());
    }  
 * {@code decomposeAggregates} call so that Calcite propagates element types into both
            aggregate.getGroupSet(),
        List<RexNode> projects = new ArrayList<>(rewritten.getRowType().getFieldCount());  
     * keys on the stage input to the nullable element type instead; the aggregate's row type
            aggregate.getGroupSets(),
/**
 * already-expanded rows from its stage input, so its LIST keys are retyped to the element
 * the grouping set indices so that Substrait serialisation sees scalar types throughout.  
import org.apache.calcite.rex.RexNode;
        ImmutableBitSet.Builder builder = ImmutableBitSet.builder();
import java.util.List;
    }
     * FINAL aggregate would (a) expand an already-scalar column a second time and (b) declare
import java.util.HashMap;
     * FINAL-side counterpart of the expansion above. The PARTIAL fragment already replaced each  
     */  
        });
    private static RelNode retypeExpandedStageInputKeys(Aggregate aggregate, DataFusionFragmentConvertor.StageInputTableScan stageInput) {
        // the original aggregate output order and names while retaining the expanded scalar types.
        );  
                return visited instanceof Aggregate aggregate ? rewriteAggregate(aggregate) : visited;
 * requires relocating {@link MultiValueExpandRel} into a module that {@code analytics-engine}  
        }
    }
