        public static List<IntermediateField> classify(List<AggregateCall> originalCalls) {
         * {@link IntermediateField#reducer}; the return type is re-inferred or pinned per the
/*
         * Rebuilds FINAL aggCalls bound against {@code finalInput}. Each call's argList becomes
                    result.add(null);
            List<AggregateCall> calls,
        // Forward existing input columns unchanged.
 * @opensearch.internal
        RelDataTypeFactory typeFactory
        }
            // List.copyOf would NPE on the null pass-through entries.
            rebuiltType.add(column.getName(), resolvedType);
                name
     */
            int finalArgIdx,
            if (field == null) {
         * Run on the ORIGINAL aggCalls — classifying a post-swap call could pick the wrong
        for (int idx = 0; idx < stageInputType.getFieldCount(); idx++) {
    public static final class FinalAggCallBuilder {
                List<Integer> extraColIdxs = extraLiteralColIdxByCallIdx.getOrDefault(i, List.of());
            for (int litIdx = 0; litIdx < literals.size(); litIdx++) {
            stageInput.getTraitSet(),
        RelDataTypeField column,
 * <p>TODO: {@link FinalAggCallBuilder} is also used by the split rule, so {@code planner.rules}
        TransformResult result = TransformResult.initial(exchange);
            stageInput.getCluster(),
                boolean isEngineNativeMerge = field.reducer() == enumFn;
                call.rexList,
                    // Function swap (COUNT → SUM, etc.). Let Calcite re-infer.
     */
import org.apache.calcite.rel.type.RelDataTypeField;
import org.apache.calcite.rex.RexNode;
            IntermediateField field,
                    explicitType = enumFn.getType() == AggregateFunction.Type.STATE_EXPANDING
                String name = finalInput.getRowType().getFieldList().get(stateColIdx).getName();
            result.finalInput(),
            projectType.add(columnName, columnType);
        if (exchange.getInputs().isEmpty()) return current;
     * function swap (e.g. COUNT→SUM), and return-type pinning. Pure: no rel-tree walking.
import org.apache.calcite.rel.core.AggregateCall;
 * Adapts a FINAL {@link OpenSearchAggregate}'s input chain after the DAG is fragmented:
            literalColumnsByCall.put(callIdx, List.copyOf(columnIdxs));
     * Construction-time factory for FINAL aggCalls. Owns argList rebase to {@code groupCount + i},
    /**
import org.apache.calcite.rex.RexInputRef;
            stageInput.getOutputFieldStorage()
        return OpenSearchAggregate.finalAfterRewrite(finalAgg, result.finalInput(), rebuiltCalls);
        if (!result.changed(exchange)) return finalAgg;
                explicitType,
        RelDataType inputType = input.getRowType();
            return finalInput != original || !extraLiteralColIdxByCallIdx.isEmpty();
        private static AggregateCall buildOne(
            stageInput.getChildStageId(),
        }
        if (exchange.getInputs().isEmpty()) return finalAgg;
            }
        /**
                List<IntermediateField> fields = AggregateFunction.fromSqlAggFunction(call.getAggregation()).intermediateFields();
import org.apache.calcite.sql.SqlAggFunction;
        RelNode input = current.finalInput();
     * <p>Called by the split rule (so Volcano's {@code typeMatchesInferred} passes) and again by
            List<AggregateCall> rebuilt = new ArrayList<>(calls.size());
import org.apache.calcite.rex.RexLiteral;
            } else {
        RelDataTypeFactory.Builder projectType = finalAgg.getCluster().getTypeFactory().builder();
                // No decomposition — pass through, let Calcite re-infer.
            return buildFinalCalls(calls, intermediateFields, groupCount, finalInput, hasEmptyGroup, Map.of());
                call.isDistinct(),
            RelDataType columnType = inputType.getFieldList().get(idx).getType();
            Map<Integer, List<Integer>> extraLiteralColIdxByCallIdx
         * passes such a call through unchanged.
        if (!changed) return current;
                projectExpressions.add(literal);
                call.ignoreNulls(),
                columnIdxs.add(projectExpressions.size()); // capture index BEFORE adding
        List<AggregateCall> rebuiltCalls = FinalAggCallBuilder.buildFinalCalls(
                        ? finalInput.getRowType().getFieldList().get(finalArgIdx).getType()
 * re-types the StageInputScan, inserts a literal-Project for STATE_EXPANDING aggregates, and
            List<RexLiteral> literals = entry.getValue();
            }
     * {@code 10}) as constant columns above the StageInputScan. PARTIAL emits only state, so FINAL
                }
            List<IntermediateField> intermediateFields,
 * compatible open source license.
        OpenSearchStageInputScan rebuiltStageInput = new OpenSearchStageInputScan(
        for (int idx = 0; idx < inputType.getFieldCount(); idx++) {
package org.opensearch.analytics.planner.dag;
                call.isApproximate(),
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;
                -1,  // filterArg dropped: FILTER consumed by PARTIAL on raw rows; FINAL only merges states.
                RexLiteral literal = literals.get(litIdx);
 */
            finalAgg.getAggCallList(),
}
            result.extraLiteralColIdxByCallIdx()
        public static List<AggregateCall> buildFinalCalls(
            List<AggregateCall> calls,
        public static List<AggregateCall> buildFinalCalls(
        Map<Integer, List<Integer>> literalColumnsByCall = new LinkedHashMap<>();
         */
        if (field == null) return column.getType();
            SqlAggFunction aggFunc;
                AggregateFunction enumFn = AggregateFunction.fromSqlAggFunction(call.getAggregation());
        /**
        // Append one column per captured literal; record where each call's literals landed.
            input.getCluster(),
                }
    // ── Transformer 2: literal-Project insertion ────────────────────────────
            for (AggregateCall call : originalCalls) {
import org.opensearch.analytics.planner.rel.AggregateMode;
                    explicitType = null;
    private static RelDataType resolveColumnType(
        );
        List<IntermediateField> intermediateFields,
import java.util.Map;
        RelDataType stageInputType = stageInput.getRowType();
     * {@code intermediateFields} list.
    static RelNode rewrite(OpenSearchAggregate finalAgg) {
            projectExpressions.add(new RexInputRef(idx, columnType));
     * sketch). Reads the per-call classification stored on FINAL — never re-classifies.
        boolean changed(RelNode original) {
        result = overrideExchangeType(finalAgg, result);
    private DistributedAggregateRewriter() {}
     * Re-types the StageInputScan when an aggregate's intermediate state has a different shape
import java.util.ArrayList;
            projectType.build(),
    }
            finalAgg.getGroupSet().isEmpty(),
            RelNode finalInput,
            int groupCount,
         * Returns the {@link IntermediateField} per call (parallel to {@code originalCalls}).
                int stateColIdx = groupCount + i;
            finalAgg.getGroupSet().cardinality(),
        if (!(exchange.getInputs().get(0) instanceof OpenSearchStageInputScan stageInput)) return current;
        RelNode rebuiltExchange = exchange.copy(exchange.getTraitSet(), List.of(rebuiltStageInput));
        }
                aggFunc,
public final class DistributedAggregateRewriter {
                    // Multi-field decompositions (AVG, STDDEV, ...) must be reduced upstream.
            finalAgg.getIntermediateFields(),
                rebuilt.add(buildOne(call, intermediateFields.get(i), stateColIdx, extraColIdxs, name, finalInput, hasEmptyGroup));
        List<IntermediateField> intermediateFields = finalAgg.getIntermediateFields();
        if (callIdx < 0 || callIdx >= intermediateFields.size()) return column.getType();
            List<Integer> columnIdxs = new ArrayList<>(literals.size());
            List<IntermediateField> intermediateFields,
                projectType.add(LITERAL_COL_PREFIX + callIdx + "_" + litIdx, literal.getType());
            rebuiltType.build(),
         * reducer. A {@code null} entry means the aggregate has no SPI decomposition; FINAL
            int callIdx = entry.getKey();
     * {@link #rewrite} when an input adapter changed the chain — idempotent given the same
        static TransformResult initial(RelNode finalInput) {
                call.distinctKeys,
            if (!resolvedType.equals(column.getType())) changed = true;
import java.util.LinkedHashMap;
            boolean hasEmptyGroup,
/**
    /** Carries the running input chain plus the per-call indexes of any literal columns added. */
    }
                finalInput,
        if (literalsByCall.isEmpty()) return current;
                    );
     * needs the literals projected back in to reference them by index.
        int callIdx,
        return new TransformResult(rebuiltExchange, current.extraLiteralColIdxByCallIdx());
    }
        }
            List<IntermediateField> result = new ArrayList<>(originalCalls.size());
            AggregateCall call,
 */
            int groupCount,
            List<Integer> argList = new ArrayList<>(1 + extraColIdxs.size());
 * rebinds aggCalls via {@link FinalAggCallBuilder} when anything changed. Called from
        IntermediateField field = intermediateFields.get(callIdx);
            RelNode finalInput,
import java.util.List;
    ) {
                    // others keep the user-facing return type.
            return new TransformResult(finalInput, Map.of());
                if (fields == null) {
        if (!(exchange.getInputs().get(0) instanceof OpenSearchStageInputScan)) return finalAgg;
        result = insertLiteralProject(finalAgg, result);
            );
        assert finalAgg.getMode() == AggregateMode.FINAL : "rewrite is only called on FINAL aggregates";
    }
            boolean hasEmptyGroup
        RelDataTypeFactory typeFactory = finalAgg.getCluster().getTypeFactory();
                    result.add(fields.get(0));
     */
         * engine-native-merge rules.
                } else {
            return Collections.unmodifiableList(result);
    private static TransformResult insertLiteralProject(OpenSearchAggregate finalAgg, TransformResult current) {
    private static final String LITERAL_COL_PREFIX = "$lit_call";
 * {@code planner.rel} once a third construction-time consumer appears.
        if (intermediateFields.isEmpty()) return current;
                AggregateCall call = calls.get(i);
                    // Same function on FINAL: STATE_EXPANDING pins to the state column type;
    }
import org.apache.calcite.rel.RelNode;
                call.collation,
        ) {
        /** Overload for callers without literal-arg columns to forward (the common case). */
        ) {
    // ── FinalAggCallBuilder: construction-time aggCall factory ──────────────
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
                } else {
     * Re-introduces a STATE_EXPANDING aggregate's literal config args (e.g. {@code take(field, 10)}'s
    private static TransformResult overrideExchangeType(OpenSearchAggregate finalAgg, TransformResult current) {
import org.apache.calcite.rel.type.RelDataType;
            RelNode finalInput,
         * {@code [groupCount + i, ...extras]}; the function is swapped per its
 * The OpenSearch Contributors require contributions made to
import org.opensearch.analytics.spi.AggregateFunction;
            }
            argList.add(finalArgIdx);
            boolean hasEmptyGroup
                        "Aggregate [" + call.getAggregation().getName() + "] has multiple intermediate fields; expected at most one"
                    aggFunc = call.getAggregation();
        }
            input,
 *
            argList.addAll(extraColIdxs);
        }
 * {@code BackendPlanAdapter.adaptNode}.
        }
        boolean changed = false;
                List.copyOf(argList),
        }
        ) {
            RelDataType resolvedType = resolveColumnType(column, idx - groupCount, intermediateFields, typeFactory);
            projectExpressions,
            input.getTraitSet(),
        );
 *
            for (int i = 0; i < calls.size(); i++) {
                hasEmptyGroup,
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
        for (Map.Entry<Integer, List<RexLiteral>> entry : literalsByCall.entrySet()) {
                } else if (fields.size() == 1) {
            RelDataTypeField column = stageInputType.getFieldList().get(idx);
            List<Integer> extraColIdxs,
        return field.typeResolver().resolve(List.of(column.getType()), typeFactory);
        RelNode exchange = finalAgg.getInput();
        int groupCount = finalAgg.getGroupSet().cardinality();
    private record TransformResult(RelNode finalInput, Map<Integer, List<Integer>> extraLiteralColIdxByCallIdx) {
         */
        return new TransformResult(project, Map.copyOf(literalColumnsByCall));
        }
        private FinalAggCallBuilder() {}
                        : call.getType();
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        Map<Integer, List<RexLiteral>> literalsByCall = finalAgg.getFinalExtraLiteralArgs();
                    aggFunc = field.reducer().toSqlAggFunction();
            return rebuilt;
        OpenSearchProject project = new OpenSearchProject(
 *
                explicitType = null;
            return AggregateCall.create(
    /**
            finalAgg.getViableBackends()
    // ── Transformer 1: StageInputScan re-typing ─────────────────────────────
        List<RexNode> projectExpressions = new ArrayList<>(inputType.getFieldCount() + literalsByCall.size());
                if (isEngineNativeMerge) {
            stageInput.getViableBackends(),
     * than PARTIAL's declared output (e.g. APPROX_COUNT_DISTINCT emits a {@code VARBINARY} HLL
        RelNode exchange = current.finalInput();
    }
        RelDataTypeFactory.Builder rebuiltType = typeFactory.builder();
 * reaches into {@code planner.dag} — backwards from the usual layering. Move it to
                    throw new IllegalStateException(
            String name,
            }
            RelDataType explicitType;
                aggFunc = call.getAggregation();
     *
import java.util.Collections;
            String columnName = inputType.getFieldList().get(idx).getName();
import org.opensearch.analytics.planner.rel.OpenSearchProject;
    /**
            // Group keys (idx < groupCount) keep their type; agg columns resolve through the SPI.
        );
import org.apache.calcite.rel.type.RelDataTypeFactory;
