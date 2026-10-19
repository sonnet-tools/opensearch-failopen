                newProjects.add(rexBuilder.makeLiteral(name, varcharType));
                return visited;
                return AggregateCall.create(
                    // PPL list/values is ARRAY<VARCHAR>; the operand is cast to VARCHAR on the
        }
 */  
                if (visited instanceof Project p) {
                    agg.getGroupCount(),
    private PplAggregateCallRewriter() {}
import org.apache.calcite.rel.RelHomogeneousShuttle;
            }
            }
                RelDataType nullableArg0 = agg.getCluster().getTypeFactory().createTypeWithNullability(arg0Type, true);  
                }
                    call.ignoreNulls(),
    }
                SqlAggFunction op = isMin ? DataFusionFragmentConvertor.LOCAL_FIRST_OP : DataFusionFragmentConvertor.LOCAL_LAST_OP;
                boolean isValues = "VALUES".equalsIgnoreCase(aggregation.getName());  
                // PPL declares ARRAY<MAP<VARCHAR, ANY>>; substrait can't carry ANY.
        if (LOCAL_OPS.contains(aggregation)) {
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
            agg.getGroupCount(),
                    call.collation,
                    return rewriteAggregate(agg);  
            return call;  
        boolean targetDistinct = call.isDistinct();  
                    trimmedArgList,
package org.opensearch.be.datafusion;
                int valueArg = call.getArgList().get(0);
    }  
                    RelDataTypeFactory typeFactory = agg.getCluster().getTypeFactory();
                    call.getName()
        }
    private static RelDataType internalPatternReturnType(RelDataTypeFactory typeFactory) {
                // ORDER BY key (DataFusion 53 has no arg_min/max UDAF; first/last_value take ordering).
        return node.getInputs().size() == 1 && readsStageInput(node.getInput(0));
            } else {
    }
                if (call.getArgList().size() != 2) {  
                explicitReturnType = internalPatternReturnType(agg.getCluster().getTypeFactory());
                }
                }
        RelDataTypeFactory typeFactory = project.getCluster().getTypeFactory();  
            case "FIRST" -> targetOp = DataFusionFragmentConvertor.LOCAL_FIRST_OP;
                    // op's inferred type (a NOT NULL array trips Calcite's typeMatchesInferred).  
        return AggregateCall.create(  
    }
/**
import org.apache.calcite.rel.RelNode;
            project.getRowType().getFieldNames(),
                newProjects.add(p);  
                    } else {  
        DataFusionFragmentConvertor.LOCAL_LAST_OP,  
            if (p instanceof RexLiteral lit && lit.getType().getSqlTypeName() == SqlTypeName.SYMBOL) {
            newCalls.add(rewritten);
 * Rewrites PPL state-expanding aggregates (TAKE / FIRST / LAST / LIST / VALUES / PATTERN /  
        }
                RelDataType nullableArg0 = agg.getCluster().getTypeFactory().createTypeWithNullability(arg0Type, true);
        }
        return root.accept(new RelHomogeneousShuttle() {
        List<RexNode> newProjects = new ArrayList<>(oldProjects.size());  
            return project;
        DataFusionFragmentConvertor.LOCAL_PERCENTILE_APPROX_OP,  
        boolean hasSymbol = oldProjects.stream()
            case "TAKE" -> targetOp = DataFusionFragmentConvertor.LOCAL_TAKE_OP;  
                    RelDataType arrayType = typeFactory.createArrayType(varchar, -1);  
import org.apache.calcite.rel.RelCollation;
            call.getName()
                if (arg0IsList) {  
        DataFusionFragmentConvertor.LOCAL_INTERNAL_PATTERN_OP
            call.isApproximate(),  
                }
 * {@link DataFusionFragmentConvertor}'s ADDITIONAL_AGGREGATE_SIGS. Also normalises any
                RelCollation collation = RelCollations.of(
        switch (aggregation.getName().toUpperCase(java.util.Locale.ROOT)) {
                targetOp = DataFusionFragmentConvertor.LOCAL_INTERNAL_PATTERN_OP;  
        }  
 * this file be licensed under the Apache-2.0 license or a
                } else {
                }
                    collation,  
            agg.getInput(),
    private static RelNode normaliseSymbolFlagLiterals(Project project) {
import java.util.List;
                return AggregateCall.create(  
        for (AggregateCall call : oldCalls) {
        DataFusionFragmentConvertor.LOCAL_LIST_MERGE_OP,
                // (DataFusionFragmentConvertor#normaliseLiteralArg) rescales the percentile.
            targetOp,
                    return normaliseSymbolFlagLiterals(p);  
        for (RexNode p : oldProjects) {
 * compatible open source license.
                    call.filterArg,
    static RelNode rewrite(RelNode root) {  
            call.collation,  
                return call;  
            case "ARG_MIN", "ARG_MAX" -> {  
 */  
        RexBuilder rexBuilder = project.getCluster().getRexBuilder();
                );  
                targetOp = DataFusionFragmentConvertor.LOCAL_PERCENTILE_APPROX_OP;  
                if (visited instanceof Aggregate agg) {
import org.apache.calcite.rel.RelFieldCollation;  
                            : DataFusionFragmentConvertor.LOCAL_MV_COLLECT_OP;  
                        targetOp = isValues  
        return agg.copy(agg.getTraitSet(), agg.getInput(), agg.getGroupSet(), agg.getGroupSets(), newCalls);
            case "PATTERN" -> {
 * The OpenSearch Contributors require contributions made to  
        });
                    call.filterArg,
            }  
                    call.getName()
                    List.of(valueArg),  
        return typeFactory.createArrayType(structType, -1);
                RelNode visited = super.visit(other);
    }
    }
 *
            AggregateCall rewritten = rewriteCall(agg, call);  
        }  
        RelDataType tokensMap = typeFactory.createMapType(varchar, varcharArray);
            .anyMatch(p -> p instanceof RexLiteral lit && lit.getType().getSqlTypeName() == SqlTypeName.SYMBOL);
        DataFusionFragmentConvertor.LOCAL_FIRST_OP,
        if (node instanceof TableScan scan) {  
        List<AggregateCall> oldCalls = agg.getAggCallList();
import org.apache.calcite.rel.RelCollations;
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            }
import org.apache.calcite.rel.core.Project;
            List.of(varchar, bigint, tokensMap, varcharArray),
                int timeArg = call.getArgList().get(1);  
                List<Integer> trimmedArgList = new ArrayList<>(call.getArgList().subList(0, 2));
import java.util.Set;  
/*  
            public RelNode visit(RelNode other) {  
                    if (finalState) {
        return LogicalProject.create(  
                if (call.getArgList().size() < 3) {  
                    targetDistinct = isValues;  
                    RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
                    call.distinctKeys,  
import java.util.ArrayList;
                    targetDistinct = false;
 * median emit a SymbolFlag arg purely for type inference.
            List.of("pattern", "pattern_count", "tokens", "sample_logs")
            return agg;
        RelDataType varcharArray = typeFactory.createArrayType(varchar, -1);
            case "PERCENTILE_APPROX" -> {  
                    new RelFieldCollation(timeArg, RelFieldCollation.Direction.ASCENDING, RelFieldCollation.NullDirection.LAST)
        DataFusionFragmentConvertor.LOCAL_TAKE_OP,
            explicitReturnType,  
            }  
                            ? DataFusionFragmentConvertor.LOCAL_LIST_MERGE_DISTINCT_OP
            project.getInput(),
                    agg.getInput(),  
                boolean isMin = "ARG_MIN".equalsIgnoreCase(aggregation.getName());  
                    agg.getGroupCount(),
import org.apache.calcite.rex.RexNode;  
    /** Replace any RexLiteral{SymbolFlag} in {@code project}'s projection list with a VARCHAR literal of the symbol's name. */
    private static AggregateCall rewriteCall(Aggregate agg, AggregateCall call) {  
            call.distinctKeys,
                // Trim the PPL type-flag arg; the substrait emit-time literal-arg normaliser
        SqlAggFunction targetOp;
                    nullableArg0,  
import org.apache.calcite.rel.type.RelDataType;
                    call.isApproximate(),  
    private static final Set<SqlAggFunction> LOCAL_OPS = Set.of(  
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);  
import org.apache.calcite.rex.RexBuilder;
                    // substrait arg (LOCAL_ARRAY_AGG_OP#rewriteDataArg). Nullable array matches the
}  
                );  
                // arg0 type distinguishes PARTIAL (raw element → array_agg) from FINAL (array → list_merge).
                    targetOp = DataFusionFragmentConvertor.LOCAL_ARRAY_AGG_OP;
                    return call;
            call.getArgList(),  
    );
            List<String> qualifiedName = scan.getTable().getQualifiedName();
 * LiteralConverter rejects unregistered Enum classes, and PPL's percentile_approx /
        List<RexNode> oldProjects = project.getProjects();  
import org.apache.calcite.sql.SqlAggFunction;
                    return call;
                RelDataType arg0Type = agg.getInput().getRowType().getFieldList().get(call.getArgList().get(0)).getType();
                    call.distinctKeys,
        if (!changed) {
        );
            call.rexList,
                    call.rexList,
        if (!hasSymbol) {  
            targetDistinct,
                    call.isApproximate(),
        DataFusionFragmentConvertor.LOCAL_MV_COLLECT_OP,
                    explicitReturnType = typeFactory.createTypeWithNullability(arrayType, true);
                    }
                boolean arg0IsList = arg0Type.getComponentType() != null;
            project.getHints(),
        RelDataType explicitReturnType = call.getType();
import org.apache.calcite.rel.logical.LogicalProject;
                    nullableArg0,
                    explicitReturnType = arg0Type;  
            call.filterArg,
        }  
                    call.ignoreNulls(),
        );  
                    return call;
                }
                RelDataType arg0Type = agg.getInput().getRowType().getFieldList().get(valueArg).getType();
                String name = lit.getValue() == null ? "" : lit.getValue().toString();  
import org.apache.calcite.rex.RexLiteral;
        SqlAggFunction aggregation = call.getAggregation();
 * PERCENTILE_APPROX) onto local stubs the substrait emitter binds via
            changed |= rewritten != call;
 * RexLiteral{SqlTypeName.SYMBOL} in upstream Projects to VARCHAR — isthmus's  
                // ARG_MIN/ARG_MAX(value, ts) -> first_value/last_value(value) with ts as the agg
    private static boolean readsStageInput(RelNode node) {
            case "LIST", "VALUES" -> {
            @Override
                    boolean finalState = readsStageInput(agg.getInput());
final class PplAggregateCallRewriter {
                    op,
                    agg.getInput(),
import org.apache.calcite.rel.core.TableScan;  
                    call.rexList,  
                    targetDistinct,
            newProjects,  
                    targetDistinct,  
        List<AggregateCall> newCalls = new ArrayList<>(oldCalls.size());  
        boolean changed = false;
        RelDataType structType = typeFactory.createStructType(  
        );  
                );
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rel.core.AggregateCall;
        DataFusionFragmentConvertor.LOCAL_MV_COLLECT_DISTINCT_OP,  
        DataFusionFragmentConvertor.LOCAL_LIST_MERGE_DISTINCT_OP,
            }  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.rel.core.Aggregate;  
                            : DataFusionFragmentConvertor.LOCAL_LIST_MERGE_OP;
            case "LAST" -> targetOp = DataFusionFragmentConvertor.LOCAL_LAST_OP;
            }
            call.ignoreNulls(),
                RelDataType arg0Type = agg.getInput().getRowType().getFieldList().get(call.getArgList().get(0)).getType();
                        targetOp = isValues
            project.getVariablesSet()
    private static RelNode rewriteAggregate(Aggregate agg) {
import org.apache.calcite.sql.type.SqlTypeName;
                    targetOp,
        DataFusionFragmentConvertor.LOCAL_ARRAY_AGG_OP,
                if (call.getArgList().isEmpty()) {  
                            ? DataFusionFragmentConvertor.LOCAL_MV_COLLECT_DISTINCT_OP
            return !qualifiedName.isEmpty() && qualifiedName.getLast().startsWith("input-");
            default -> {
