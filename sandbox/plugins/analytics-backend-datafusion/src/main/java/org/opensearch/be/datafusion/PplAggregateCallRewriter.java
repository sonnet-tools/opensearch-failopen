            case "LIST", "VALUES" -> {
                // (DataFusionFragmentConvertor#normaliseLiteralArg) rescales the percentile.
        }
            changed |= rewritten != call;
    /** Replace any RexLiteral{SymbolFlag} in {@code project}'s projection list with a VARCHAR literal of the symbol's name. */
 * compatible open source license.
        RelDataTypeFactory typeFactory = project.getCluster().getTypeFactory();
                boolean isMin = "ARG_MIN".equalsIgnoreCase(aggregation.getName());
                    return rewriteAggregate(agg);
                    // op's inferred type (a NOT NULL array trips Calcite's typeMatchesInferred).
                return call;
            newProjects,
            call.ignoreNulls(),
                    call.ignoreNulls(),
            call.getName()
        }
    private static RelNode rewriteAggregate(Aggregate agg) {
            project.getVariablesSet()
            project.getHints(),
                    targetOp,
                // arg0 type distinguishes PARTIAL (raw element → array_agg) from FINAL (array → list_merge).
 * {@link DataFusionFragmentConvertor}'s ADDITIONAL_AGGREGATE_SIGS. Also normalises any
            project.getRowType().getFieldNames(),
            case "FIRST" -> targetOp = DataFusionFragmentConvertor.LOCAL_FIRST_OP;
 */
 * PERCENTILE_APPROX) onto local stubs the substrait emitter binds via
                    return normaliseSymbolFlagLiterals(p);
                if (call.getArgList().size() != 2) {
                        targetOp = isValues
                return AggregateCall.create(
        switch (aggregation.getName().toUpperCase(java.util.Locale.ROOT)) {
        DataFusionFragmentConvertor.LOCAL_LIST_MERGE_OP,
                }
        DataFusionFragmentConvertor.LOCAL_TAKE_OP,
        RelDataType structType = typeFactory.createStructType(
            }
                newProjects.add(p);
                return AggregateCall.create(
                    agg.getInput(),
        for (AggregateCall call : oldCalls) {
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
        RelDataType tokensMap = typeFactory.createMapType(varchar, varcharArray);
}
            agg.getInput(),
                    call.getName()
        if (!hasSymbol) {
                );
    }
                    boolean finalState = readsStageInput(agg.getInput());
                    call.filterArg,
    private static AggregateCall rewriteCall(Aggregate agg, AggregateCall call) {
        });
                RelDataType arg0Type = agg.getInput().getRowType().getFieldList().get(valueArg).getType();
                int valueArg = call.getArgList().get(0);
                RelNode visited = super.visit(other);
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        boolean changed = false;
                    List.of(valueArg),
                } else {
                    op,
            call.filterArg,
import org.apache.calcite.rel.RelNode;
                if (call.getArgList().isEmpty()) {
                boolean arg0IsList = arg0Type.getComponentType() != null;
        }
 * median emit a SymbolFlag arg purely for type inference.
                // PPL declares ARRAY<MAP<VARCHAR, ANY>>; substrait can't carry ANY.
                            ? DataFusionFragmentConvertor.LOCAL_MV_COLLECT_DISTINCT_OP
import java.util.Set;
            case "LAST" -> targetOp = DataFusionFragmentConvertor.LOCAL_LAST_OP;
 * Rewrites PPL state-expanding aggregates (TAKE / FIRST / LAST / LIST / VALUES / PATTERN /
                    trimmedArgList,
            return agg;
                    call.rexList,
                    targetDistinct,
        DataFusionFragmentConvertor.LOCAL_ARRAY_AGG_OP,
import org.apache.calcite.rel.core.Project;
            } else {
    private PplAggregateCallRewriter() {}
            project.getInput(),
        DataFusionFragmentConvertor.LOCAL_PERCENTILE_APPROX_OP,
        DataFusionFragmentConvertor.LOCAL_LAST_OP,
            List<String> qualifiedName = scan.getTable().getQualifiedName();
import org.apache.calcite.rel.RelCollation;
                    call.collation,
        List<RexNode> newProjects = new ArrayList<>(oldProjects.size());
import java.util.List;
            default -> {
import org.apache.calcite.rel.logical.LogicalProject;
        return typeFactory.createArrayType(structType, -1);
                    targetDistinct,
        List<RexNode> oldProjects = project.getProjects();
                    RelDataType arrayType = typeFactory.createArrayType(varchar, -1);
                }
                int timeArg = call.getArgList().get(1);
                    return call;
                if (visited instanceof Project p) {
            case "PERCENTILE_APPROX" -> {
        if (node instanceof TableScan scan) {
                explicitReturnType = internalPatternReturnType(agg.getCluster().getTypeFactory());
                RelDataType arg0Type = agg.getInput().getRowType().getFieldList().get(call.getArgList().get(0)).getType();
                    new RelFieldCollation(timeArg, RelFieldCollation.Direction.ASCENDING, RelFieldCollation.NullDirection.LAST)
                RelDataType nullableArg0 = agg.getCluster().getTypeFactory().createTypeWithNullability(arg0Type, true);
                    call.isApproximate(),
            call.collation,
            call.distinctKeys,
        for (RexNode p : oldProjects) {
    }
    private static final Set<SqlAggFunction> LOCAL_OPS = Set.of(
            List.of(varchar, bigint, tokensMap, varcharArray),
            }
import org.apache.calcite.rel.core.Aggregate;
                    call.isApproximate(),
                );
import org.apache.calcite.rex.RexNode;
            }
        SqlAggFunction aggregation = call.getAggregation();
 * RexLiteral{SqlTypeName.SYMBOL} in upstream Projects to VARCHAR — isthmus's
                RelCollation collation = RelCollations.of(
                        targetOp = isValues
        RelDataType varcharArray = typeFactory.createArrayType(varchar, -1);
                    return call;
                    // PPL list/values is ARRAY<VARCHAR>; the operand is cast to VARCHAR on the
            }
        return node.getInputs().size() == 1 && readsStageInput(node.getInput(0));
            explicitReturnType,
                    agg.getInput(),
                    return call;
            call.isApproximate(),
    );
            AggregateCall rewritten = rewriteCall(agg, call);
                return visited;
import org.apache.calcite.sql.type.SqlTypeName;
                }
        }
                targetOp = DataFusionFragmentConvertor.LOCAL_INTERNAL_PATTERN_OP;
                    call.distinctKeys,
        }
        DataFusionFragmentConvertor.LOCAL_LIST_MERGE_DISTINCT_OP,
            return project;
                    nullableArg0,
                }
        if (LOCAL_OPS.contains(aggregation)) {
                newProjects.add(rexBuilder.makeLiteral(name, varcharType));
                    collation,
        DataFusionFragmentConvertor.LOCAL_MV_COLLECT_DISTINCT_OP,
                            : DataFusionFragmentConvertor.LOCAL_LIST_MERGE_OP;
/**
            .anyMatch(p -> p instanceof RexLiteral lit && lit.getType().getSqlTypeName() == SqlTypeName.SYMBOL);
            @Override
        DataFusionFragmentConvertor.LOCAL_MV_COLLECT_OP,
import org.apache.calcite.rel.core.TableScan;
package org.opensearch.be.datafusion;
import org.apache.calcite.rel.RelCollations;
                }
        return root.accept(new RelHomogeneousShuttle() {
import org.apache.calcite.rel.core.AggregateCall;
        return LogicalProject.create(
            targetOp,
        }
            case "TAKE" -> targetOp = DataFusionFragmentConvertor.LOCAL_TAKE_OP;
                List<Integer> trimmedArgList = new ArrayList<>(call.getArgList().subList(0, 2));
        boolean targetDistinct = call.isDistinct();
        RelDataType explicitReturnType = call.getType();
import org.apache.calcite.rel.RelFieldCollation;
                    agg.getGroupCount(),
            }
            }
            targetDistinct,
import org.apache.calcite.rel.RelHomogeneousShuttle;
                    call.rexList,
        return agg.copy(agg.getTraitSet(), agg.getInput(), agg.getGroupSet(), agg.getGroupSets(), newCalls);
                targetOp = DataFusionFragmentConvertor.LOCAL_PERCENTILE_APPROX_OP;
                // ORDER BY key (DataFusion 53 has no arg_min/max UDAF; first/last_value take ordering).
                    targetDistinct = isValues;
    private static RelNode normaliseSymbolFlagLiterals(Project project) {
        if (!changed) {
            agg.getGroupCount(),
                boolean isValues = "VALUES".equalsIgnoreCase(aggregation.getName());
        List<AggregateCall> oldCalls = agg.getAggCallList();
                );
    }
import org.apache.calcite.rex.RexLiteral;
            return !qualifiedName.isEmpty() && qualifiedName.getLast().startsWith("input-");
            call.rexList,
                // Trim the PPL type-flag arg; the substrait emit-time literal-arg normaliser
        );
    }
                    call.filterArg,
            call.getArgList(),
        return AggregateCall.create(
    private static RelDataType internalPatternReturnType(RelDataTypeFactory typeFactory) {
            public RelNode visit(RelNode other) {
 * The OpenSearch Contributors require contributions made to
import org.apache.calcite.rel.type.RelDataType;
            return call;
                    call.getName()
final class PplAggregateCallRewriter {
                // ARG_MIN/ARG_MAX(value, ts) -> first_value/last_value(value) with ts as the agg
                    explicitReturnType = typeFactory.createTypeWithNullability(arrayType, true);
 *
        boolean hasSymbol = oldProjects.stream()
 * LiteralConverter rejects unregistered Enum classes, and PPL's percentile_approx /
                    }
                    // substrait arg (LOCAL_ARRAY_AGG_OP#rewriteDataArg). Nullable array matches the
        List<AggregateCall> newCalls = new ArrayList<>(oldCalls.size());
    }
 * this file be licensed under the Apache-2.0 license or a
        );
            if (p instanceof RexLiteral lit && lit.getType().getSqlTypeName() == SqlTypeName.SYMBOL) {
                    call.distinctKeys,
                    } else {
                    agg.getGroupCount(),
import java.util.ArrayList;
            case "ARG_MIN", "ARG_MAX" -> {
                String name = lit.getValue() == null ? "" : lit.getValue().toString();
                    nullableArg0,
        SqlAggFunction targetOp;
                            ? DataFusionFragmentConvertor.LOCAL_LIST_MERGE_DISTINCT_OP
            case "PATTERN" -> {
                    RelDataTypeFactory typeFactory = agg.getCluster().getTypeFactory();
                    targetOp = DataFusionFragmentConvertor.LOCAL_ARRAY_AGG_OP;
            List.of("pattern", "pattern_count", "tokens", "sample_logs")
/*
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
                    explicitReturnType = arg0Type;
import org.apache.calcite.sql.SqlAggFunction;
import org.apache.calcite.rel.type.RelDataTypeFactory;
    static RelNode rewrite(RelNode root) {
                            : DataFusionFragmentConvertor.LOCAL_MV_COLLECT_OP;
            newCalls.add(rewritten);
    }
        );
                RelDataType nullableArg0 = agg.getCluster().getTypeFactory().createTypeWithNullability(arg0Type, true);
        RexBuilder rexBuilder = project.getCluster().getRexBuilder();
                    if (finalState) {
                    call.ignoreNulls(),
            }
        DataFusionFragmentConvertor.LOCAL_INTERNAL_PATTERN_OP
                SqlAggFunction op = isMin ? DataFusionFragmentConvertor.LOCAL_FIRST_OP : DataFusionFragmentConvertor.LOCAL_LAST_OP;
                if (call.getArgList().size() < 3) {
 * SPDX-License-Identifier: Apache-2.0
                    targetDistinct = false;
import org.apache.calcite.rex.RexBuilder;
        }
        DataFusionFragmentConvertor.LOCAL_FIRST_OP,
                if (visited instanceof Aggregate agg) {
 */
                RelDataType arg0Type = agg.getInput().getRowType().getFieldList().get(call.getArgList().get(0)).getType();
    private static boolean readsStageInput(RelNode node) {
                    RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
                }
                if (arg0IsList) {
