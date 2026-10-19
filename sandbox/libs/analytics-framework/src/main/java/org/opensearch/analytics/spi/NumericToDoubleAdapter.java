    public static RexNode widenToDoubleIfNumeric(RexNode operand, RelOptCluster cluster) {  
 * @opensearch.internal
 * when the backend's substrait extension YAML declares a single {@code fp64}  
                factory.createSqlType(SqlTypeName.DOUBLE),
 * fails with {@code "Unable to convert call X(i32?)"} because there's no  
 *       own logic rather than rely on this adapter.</li>
            return cluster.getRexBuilder().makeCast(doubleType, operand);
        return cluster.getRexBuilder().makeCall(original.getType(), target, rewritten);
     * Exposed for adapters that perform a structural rewrite (e.g. lowering  
 *   <li><b>Widen + rename</b> — pass a different {@link SqlOperator}
 *       e.g. {@code MAKEDATE}, {@code MAKETIME}, {@code FROM_UNIXTIME}.</li>
 *
 * (e.g. fp64 for transcendental fns, TIMESTAMP for {@code from_unixtime}) and
     * has already visited this subtree, so it won't be re-adapted.
 *       unchanged. Used for math functions like {@code EXP} / {@code LN} /  
    }  
 * i32 / i64 / fp32 / DECIMAL} — without widening, isthmus' signature matcher
import org.apache.calcite.sql.SqlOperator;  
            rewritten.add(widenToDoubleIfNumeric(operand, cluster));  
 * <p>The target operator is supplied at construction time. Two common shapes:
 *       that need non-numeric handling should subclass or compose with their
     * before threading it into the synthesised inner call — the synthesised
        this.target = target;
        }  
package org.opensearch.analytics.spi;
            return operand;  
 * rebuilding the call with a configured target {@link SqlOperator}. Use this
 *       (typically a locally-declared {@code SqlFunction} pointing at a Rust  
 *   <li>Anything else (string, date, boolean, struct, …) → unchanged. Adapters  
 * Casts every numeric operand of a {@link RexCall} to {@code DOUBLE} before
 * <p>Widening rules:  
            RelDataTypeFactory factory = cluster.getTypeFactory();  
 * <ul>  
 * this file be licensed under the Apache-2.0 license or a
    /**
     * call is created after BackendPlanAdapter  
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.sql.type.SqlTypeName;
    private final SqlOperator target;
 * impl per arity but Calcite hands the call operands as {@code i8 / i16 /
 *       preserving the operand's nullability.</li>
 * matching key.
     */
/*  
 * not recomputed — Calcite's type system already determined the expected return  
 *   <li>{@code INT_TYPES} ({@code TINYINT, SMALLINT, INTEGER, BIGINT}),  
 * compatible open source license.
        }
 *   <li>{@code DOUBLE} → unchanged.</li>
import org.apache.calcite.rex.RexCall;
 *       {@code POWER} where Calcite's operator matches the substrait name.</li>
        if (type == SqlTypeName.DOUBLE) {
 *
    }  
        }
        List<RexNode> rewritten = new ArrayList<>(original.getOperands().size());
/**  
 * </ul>  
}  
        SqlTypeName type = operand.getType().getSqlTypeName();
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.plan.RelOptCluster;
        return operand;
import java.util.List;
 *       {@code FLOAT, REAL, DECIMAL} → wrapped in {@code CAST AS DOUBLE},
                operand.getType().isNullable()  
 * <ul>
        for (RexNode operand : original.getOperands()) {
    @Override
 * </ul>  
            );
 */
 *
 *
 * <p>The return type of the rebuilt call is taken from {@code original.getType()},
    }
        if (SqlTypeName.INT_TYPES.contains(type) || type == SqlTypeName.FLOAT || type == SqlTypeName.REAL || type == SqlTypeName.DECIMAL) {
import org.apache.calcite.rex.RexNode;
 *   <li><b>Pure widening</b> — pass the same {@link SqlOperator} that came in.
 * we don't want widening operands to perturb the outer-visible schema.
import java.util.ArrayList;  
 *       The call is rebuilt with widened operands but the operator is
 *  
public class NumericToDoubleAdapter implements ScalarFunctionAdapter {  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            RelDataType doubleType = factory.createTypeWithNullability(
 * SPDX-License-Identifier: Apache-2.0
 *       UDF). Used for PPL functions that don't have a Calcite stdlib operator
     * {@code EXPM1(x)} to {@code EXP(x) - 1}) and need to widen the operand
    public NumericToDoubleAdapter(SqlOperator target) {
 * The OpenSearch Contributors require contributions made to  
 */  
