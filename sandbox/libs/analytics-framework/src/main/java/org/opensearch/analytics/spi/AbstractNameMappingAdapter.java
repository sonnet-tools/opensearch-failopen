    }
 * <p>Example use:  
 * write a dedicated adapter instead.
 *
 * </pre>
 */  
        // / Filter) caches its rowType from the pre-adaptation expression; if the
        // target operator's own return-type inference — the result will be a  
import org.apache.calcite.rex.RexBuilder;
        if (literal instanceof String) return typeFactory.createSqlType(SqlTypeName.VARCHAR);
import java.util.List;  
     *                        will use. The isthmus visitor resolves this to a
    }
     *                        extension catalog.  
     *                        {@code List.of("year")} to prepend a string literal).
import org.apache.calcite.plan.RelOptCluster;
 *           super(SqlLibraryOperators.DATE_PART, List.of("year"), List.of());
        if (literal instanceof Integer) return typeFactory.createSqlType(SqlTypeName.INTEGER);  
        throw new IllegalArgumentException("Unsupported literal type: " + literal.getClass());
        // LogicalProject.create together with the cached rowType, and
 * operands. Pure shape rewriting — no decomposition into a different semantic
 *
import org.apache.calcite.sql.type.SqlTypeName;  
import org.apache.calcite.rex.RexCall;  
     *                        Substrait invocation against the backend's loaded
 * Reusable base for {@link ScalarFunctionAdapter}s that rewrite a Calcite call  
        //
        if (literal instanceof Double) return typeFactory.createSqlType(SqlTypeName.DOUBLE);
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    /**
        // etc.) which Substrait can serialise.
     * @param targetOperator  the Calcite {@link SqlOperator} the rewritten call  
 *       }
 * rewrites {@code YEAR(ts)} to {@code date_part('year', ts)}. Paired with the
     *                        Currently supports {@link String}, {@link Integer},  
     */  
        if (original.getType().getSqlTypeName() == SqlTypeName.ANY) {  
        }
        this.appendLiterals = List.copyOf(appendLiterals);
        var typeFactory = rexBuilder.getTypeFactory();
    private final SqlOperator targetOperator;
    }
        // Exception: polymorphic PPL UDFs (e.g. SCALAR_MAX, SCALAR_MIN) declare  
 * SPDX-License-Identifier: Apache-2.0
            operands.add(rexBuilder.makeLiteral(literal, inferLiteralType(rexBuilder, literal), true));
 * <pre>
        }
import org.apache.calcite.rex.RexNode;
 * to a different named target, optionally prepending or appending literal
        for (Object literal : prependLiterals) {
        // INTEGER but SqlLibraryOperators.DATE_PART is SqlExtractFunction → BIGINT),  
import java.util.ArrayList;
/**
        // breaks fragment conversion.
        return rexBuilder.makeCall(original.getType(), targetOperator, operands);  
    protected AbstractNameMappingAdapter(SqlOperator targetOperator, List<Object> prependLiterals, List<Object> appendLiterals) {
            operands.add(rexBuilder.makeLiteral(literal, inferLiteralType(rexBuilder, literal), true));  
        // operand shapes. Substrait cannot serialise ANY, so fall back to the
            return rexBuilder.makeCall(targetOperator, operands);
 * The OpenSearch Contributors require contributions made to  
        this.prependLiterals = List.copyOf(prependLiterals);  
 * @opensearch.internal  
        // concrete type derived from operands (DOUBLE for GREATEST(DOUBLE, DOUBLE),
 *       YearAdapter() {  
 * {@code date_part} signature in a backend's extension catalog so the isthmus  
     *                        {@link Long}, {@link Double}, {@link Boolean}.
        operands.addAll(original.getOperands());
 *   class YearAdapter extends AbstractNameMappingAdapter {
        // their return type as SqlTypeName.ANY because they accept heterogeneous
        for (Object literal : appendLiterals) {  
        this.targetOperator = targetOperator;
public abstract class AbstractNameMappingAdapter implements ScalarFunctionAdapter {
}  
        // Preserve the original call's return type. The enclosing operator (Project  
        if (literal instanceof Long) return typeFactory.createSqlType(SqlTypeName.BIGINT);
        // the downstream stripAnnotations path feeds the adapted expr into
import org.apache.calcite.sql.SqlOperator;
 * compatible open source license.
    private final List<Object> appendLiterals;  
        List<RexNode> operands = new ArrayList<>(original.getOperands().size() + prependLiterals.size() + appendLiterals.size());
     * @param appendLiterals  literals to append to the operand list.
        RexBuilder rexBuilder = cluster.getRexBuilder();  
        // rewritten call's Calcite-inferred type differs (e.g. PPL YEAR returns
/*  
    private static org.apache.calcite.rel.type.RelDataType inferLiteralType(RexBuilder rexBuilder, Object literal) {  
        // Project.isValid's compatibleTypes check throws an AssertionError that  
    @Override
        }
 *
    private final List<Object> prependLiterals;
     * @param prependLiterals literals to prepend to the operand list (e.g.
 * this file be licensed under the Apache-2.0 license or a
 */
        if (literal instanceof Boolean) return typeFactory.createSqlType(SqlTypeName.BOOLEAN);  
 *   }  
package org.opensearch.analytics.spi;
 * visitor resolves it against the backend's native date_part.
 * function. For that use case (e.g. {@code ILIKE → LIKE(LOWER(a), LOWER(b))})  
