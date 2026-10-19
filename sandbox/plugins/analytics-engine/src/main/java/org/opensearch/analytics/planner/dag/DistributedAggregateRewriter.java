    private static RelDataType resolveColumnType(
            rebuiltType.build(),
         * engine-native-merge rules.
        }
            List<IntermediateField> result = new ArrayList<>(originalCalls.size());
         */  
        boolean changed = false;  
            return new TransformResult(finalInput, Map.of());
                // No decomposition — pass through, let Calcite re-infer.
            // List.copyOf would NPE on the null pass-through entries.
                    // Function swap (COUNT → SUM, etc.). Let Calcite re-infer.
            projectType.build(),
        private FinalAggCallBuilder() {}
 * The OpenSearch Contributors require contributions made to  
                aggFunc,  
                hasEmptyGroup,  
import java.util.Map;  
 * rebinds aggCalls via {@link FinalAggCallBuilder} when anything changed. Called from
    /** Carries the running input chain plus the per-call indexes of any literal columns added. */
        result = overrideExchangeType(finalAgg, result);
        List<IntermediateField> intermediateFields,
     * Re-introduces a STATE_EXPANDING aggregate's literal config args (e.g. {@code take(field, 10)}'s  
                call.ignoreNulls(),  
                call.rexList,
                } else if (fields.size() == 1) {
         * {@code [groupCount + i, ...extras]}; the function is swapped per its  
            String name,
        RelDataTypeFactory.Builder projectType = finalAgg.getCluster().getTypeFactory().builder();
                        ? finalInput.getRowType().getFieldList().get(finalArgIdx).getType()
        // Append one column per captured literal; record where each call's literals landed.  
                call.distinctKeys,
public final class DistributedAggregateRewriter {
/**
            int callIdx = entry.getKey();  
            if (!resolvedType.equals(column.getType())) changed = true;
            RelDataTypeField column = stageInputType.getFieldList().get(idx);
            stageInput.getTraitSet(),  
import java.util.List;
                    result.add(fields.get(0));
 * {@code BackendPlanAdapter.adaptNode}.  
        RelDataTypeFactory typeFactory = finalAgg.getCluster().getTypeFactory();
                if (fields == null) {
                    explicitType = null;  
            argList.add(finalArgIdx);
        Map<Integer, List<RexLiteral>> literalsByCall = finalAgg.getFinalExtraLiteralArgs();
            RelNode finalInput,
        return field.typeResolver().resolve(List.of(column.getType()), typeFactory);
                List.copyOf(argList),
                List<IntermediateField> fields = AggregateFunction.fromSqlAggFunction(call.getAggregation()).intermediateFields();
                    aggFunc = field.reducer().toSqlAggFunction();
import java.util.ArrayList;
            input.getTraitSet(),
            List<IntermediateField> intermediateFields,
        RelDataTypeField column,
                call.isDistinct(),
                        "Aggregate [" + call.getAggregation().getName() + "] has multiple intermediate fields; expected at most one"  
 * re-types the StageInputScan, inserts a literal-Project for STATE_EXPANDING aggregates, and
    public static final class FinalAggCallBuilder {  
import java.util.Collections;  
            return Collections.unmodifiableList(result);
         * {@link IntermediateField#reducer}; the return type is re-inferred or pinned per the
                } else {  
            List<RexLiteral> literals = entry.getValue();
        return new TransformResult(rebuiltExchange, current.extraLiteralColIdxByCallIdx());
     */
            boolean hasEmptyGroup,  
        for (int idx = 0; idx < inputType.getFieldCount(); idx++) {
    }  
        List<IntermediateField> intermediateFields = finalAgg.getIntermediateFields();
        }  
 * @opensearch.internal  
        if (callIdx < 0 || callIdx >= intermediateFields.size()) return column.getType();
            List<IntermediateField> intermediateFields,  
                    // Multi-field decompositions (AVG, STDDEV, ...) must be reduced upstream.
            Map<Integer, List<Integer>> extraLiteralColIdxByCallIdx
        private static AggregateCall buildOne(
                explicitType = null;
 *
    }  
     * {@link #rewrite} when an input adapter changed the chain — idempotent given the same  
        ) {
                }
    /**
        }
            List<AggregateCall> calls,
     * sketch). Reads the per-call classification stored on FINAL — never re-classifies.  
        if (exchange.getInputs().isEmpty()) return current;
        static TransformResult initial(RelNode finalInput) {
 *
    private record TransformResult(RelNode finalInput, Map<Integer, List<Integer>> extraLiteralColIdxByCallIdx) {
    }
            int groupCount,  
                    result.add(null);  
            stageInput.getOutputFieldStorage()
            for (int i = 0; i < calls.size(); i++) {
                        : call.getType();
     * {@code 10}) as constant columns above the StageInputScan. PARTIAL emits only state, so FINAL
                boolean isEngineNativeMerge = field.reducer() == enumFn;
     * {@code intermediateFields} list.
        // Forward existing input columns unchanged.
            result.finalInput(),  
        OpenSearchStageInputScan rebuiltStageInput = new OpenSearchStageInputScan(
            List<Integer> argList = new ArrayList<>(1 + extraColIdxs.size());
         */  
                call.isApproximate(),
        if (intermediateFields.isEmpty()) return current;
         * passes such a call through unchanged.
                call.collation,
            // Group keys (idx < groupCount) keep their type; agg columns resolve through the SPI.  
            }
            rebuiltType.add(column.getName(), resolvedType);  
        return new TransformResult(project, Map.copyOf(literalColumnsByCall));
            List<AggregateCall> rebuilt = new ArrayList<>(calls.size());  
        RelDataType stageInputType = stageInput.getRowType();
        if (!(exchange.getInputs().get(0) instanceof OpenSearchStageInputScan)) return finalAgg;
            finalAgg.getGroupSet().cardinality(),
            if (field == null) {
            List<Integer> columnIdxs = new ArrayList<>(literals.size());
            result.extraLiteralColIdxByCallIdx()
        }
        if (literalsByCall.isEmpty()) return current;  
        /**
         * reducer. A {@code null} entry means the aggregate has no SPI decomposition; FINAL
     * <p>Called by the split rule (so Volcano's {@code typeMatchesInferred} passes) and again by
        public static List<AggregateCall> buildFinalCalls(
import org.apache.calcite.rel.core.AggregateCall;
        List<AggregateCall> rebuiltCalls = FinalAggCallBuilder.buildFinalCalls(
            }
                -1,  // filterArg dropped: FILTER consumed by PARTIAL on raw rows; FINAL only merges states.  
        result = insertLiteralProject(finalAgg, result);
    private static TransformResult insertLiteralProject(OpenSearchAggregate finalAgg, TransformResult current) {
                AggregateCall call = calls.get(i);
 *
 * {@code planner.rel} once a third construction-time consumer appears.
            stageInput.getCluster(),
     *
            finalAgg.getIntermediateFields(),
        RelDataTypeFactory typeFactory
        IntermediateField field = intermediateFields.get(callIdx);
            RelNode finalInput,
        if (!(exchange.getInputs().get(0) instanceof OpenSearchStageInputScan stageInput)) return current;
        ) {  
            List<AggregateCall> calls,
            }
            } else {
import org.apache.calcite.rex.RexLiteral;
                aggFunc = call.getAggregation();  
            int groupCount,
import org.opensearch.analytics.planner.rel.OpenSearchProject;  
    ) {  
import org.apache.calcite.rel.type.RelDataTypeFactory;
        return OpenSearchAggregate.finalAfterRewrite(finalAgg, result.finalInput(), rebuiltCalls);
        assert finalAgg.getMode() == AggregateMode.FINAL : "rewrite is only called on FINAL aggregates";
     * Re-types the StageInputScan when an aggregate's intermediate state has a different shape
     */
                columnIdxs.add(projectExpressions.size()); // capture index BEFORE adding
    static RelNode rewrite(OpenSearchAggregate finalAgg) {  
 */  
            List<Integer> extraColIdxs,  
                rebuilt.add(buildOne(call, intermediateFields.get(i), stateColIdx, extraColIdxs, name, finalInput, hasEmptyGroup));  
        RelNode input = current.finalInput();
import org.apache.calcite.rel.RelNode;
    // ── Transformer 1: StageInputScan re-typing ─────────────────────────────
                    throw new IllegalStateException(
            literalColumnsByCall.put(callIdx, List.copyOf(columnIdxs));  
        );  
        if (!changed) return current;
        );
import org.apache.calcite.rex.RexNode;
     */  
    /**
import org.opensearch.analytics.planner.rel.AggregateMode;
                projectType.add(LITERAL_COL_PREFIX + callIdx + "_" + litIdx, literal.getType());
         * Rebuilds FINAL aggCalls bound against {@code finalInput}. Each call's argList becomes
    // ── FinalAggCallBuilder: construction-time aggCall factory ──────────────
            return rebuilt;
        if (!result.changed(exchange)) return finalAgg;  
import org.apache.calcite.rel.type.RelDataTypeField;
            argList.addAll(extraColIdxs);  
 * Adapts a FINAL {@link OpenSearchAggregate}'s input chain after the DAG is fragmented:  
    private DistributedAggregateRewriter() {}
                int stateColIdx = groupCount + i;  
                AggregateFunction enumFn = AggregateFunction.fromSqlAggFunction(call.getAggregation());  
            projectExpressions.add(new RexInputRef(idx, columnType));
        ) {
            }  
                List<Integer> extraColIdxs = extraLiteralColIdxByCallIdx.getOrDefault(i, List.of());
 * <p>TODO: {@link FinalAggCallBuilder} is also used by the split rule, so {@code planner.rules}
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;  
}
                    // others keep the user-facing return type.
            String columnName = inputType.getFieldList().get(idx).getName();
        for (int idx = 0; idx < stageInputType.getFieldCount(); idx++) {
 * reaches into {@code planner.dag} — backwards from the usual layering. Move it to  
            boolean hasEmptyGroup  
            return AggregateCall.create(
         * Run on the ORIGINAL aggCalls — classifying a post-swap call could pick the wrong  
    // ── Transformer 2: literal-Project insertion ────────────────────────────
                String name = finalInput.getRowType().getFieldList().get(stateColIdx).getName();
            int finalArgIdx,
     * needs the literals projected back in to reference them by index.
/*  
        if (field == null) return column.getType();  
        /** Overload for callers without literal-arg columns to forward (the common case). */
        OpenSearchProject project = new OpenSearchProject(  
        public static List<AggregateCall> buildFinalCalls(  
            SqlAggFunction aggFunc;
        Map<Integer, List<Integer>> literalColumnsByCall = new LinkedHashMap<>();
            );
        boolean changed(RelNode original) {
     * function swap (e.g. COUNT→SUM), and return-type pinning. Pure: no rel-tree walking.  
import org.apache.calcite.sql.SqlAggFunction;  
            stageInput.getChildStageId(),
            IntermediateField field,
            RelNode finalInput,
            for (int litIdx = 0; litIdx < literals.size(); litIdx++) {  
            input,  
            for (AggregateCall call : originalCalls) {  
            AggregateCall call,  
            boolean hasEmptyGroup
import java.util.LinkedHashMap;
        RelNode rebuiltExchange = exchange.copy(exchange.getTraitSet(), List.of(rebuiltStageInput));  
    private static TransformResult overrideExchangeType(OpenSearchAggregate finalAgg, TransformResult current) {
                } else {  
                    aggFunc = call.getAggregation();
            projectType.add(columnName, columnType);  
         * Returns the {@link IntermediateField} per call (parallel to {@code originalCalls}).
        TransformResult result = TransformResult.initial(exchange);  
     * Construction-time factory for FINAL aggCalls. Owns argList rebase to {@code groupCount + i},
        for (Map.Entry<Integer, List<RexLiteral>> entry : literalsByCall.entrySet()) {
        public static List<IntermediateField> classify(List<AggregateCall> originalCalls) {
                explicitType,
 * compatible open source license.
package org.opensearch.analytics.planner.dag;
        int groupCount = finalAgg.getGroupSet().cardinality();  
    /**  
        RelNode exchange = current.finalInput();  
                    // Same function on FINAL: STATE_EXPANDING pins to the state column type;  
            RelDataType explicitType;  
import org.apache.calcite.rex.RexInputRef;  
import org.opensearch.analytics.spi.AggregateFunction;
    }
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
        /**
        RelNode exchange = finalAgg.getInput();
        RelDataType inputType = input.getRowType();  
import org.apache.calcite.rel.type.RelDataType;  
            projectExpressions,
    private static final String LITERAL_COL_PREFIX = "$lit_call";  
                RexLiteral literal = literals.get(litIdx);
            finalAgg.getAggCallList(),  
                }
            return finalInput != original || !extraLiteralColIdxByCallIdx.isEmpty();  
            finalAgg.getViableBackends()  
        if (exchange.getInputs().isEmpty()) return finalAgg;  
            input.getCluster(),
    }
                    explicitType = enumFn.getType() == AggregateFunction.Type.STATE_EXPANDING  
        );
        List<RexNode> projectExpressions = new ArrayList<>(inputType.getFieldCount() + literalsByCall.size());
            RelDataType columnType = inputType.getFieldList().get(idx).getType();  
            return buildFinalCalls(calls, intermediateFields, groupCount, finalInput, hasEmptyGroup, Map.of());
                if (isEngineNativeMerge) {
 * this file be licensed under the Apache-2.0 license or a
        }  
                    );
        }
     * than PARTIAL's declared output (e.g. APPROX_COUNT_DISTINCT emits a {@code VARBINARY} HLL
            stageInput.getViableBackends(),  
        int callIdx,  
        }
                finalInput,
                projectExpressions.add(literal);  
    }
        RelDataTypeFactory.Builder rebuiltType = typeFactory.builder();
        }  
                name  
            finalAgg.getGroupSet().isEmpty(),
            RelDataType resolvedType = resolveColumnType(column, idx - groupCount, intermediateFields, typeFactory);
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
 * SPDX-License-Identifier: Apache-2.0
 */
        }
