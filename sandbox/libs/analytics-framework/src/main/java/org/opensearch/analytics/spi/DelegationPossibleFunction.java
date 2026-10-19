        OperandTypes.family(SqlTypeFamily.BOOLEAN, SqlTypeFamily.NUMERIC),
    private DelegationPossibleFunction() {}
    }  
 *  
        return rexBuilder.makeCall(FUNCTION, original, rexBuilder.makeLiteral(annotationId, intType, false));
}
/**
        NAME,  
 * <p>Plan shape after FragmentConversion (Performance branch):
/*  
import org.apache.calcite.sql.type.ReturnTypes;  
 *   delegation_possible(originalPredicate, annotationId)  
 * intersects the resulting bitset with its own candidates.
import org.apache.calcite.sql.SqlKind;
 * compatible open source license.
    public static final SqlFunction FUNCTION = new SqlFunction(
        SqlKind.OTHER_FUNCTION,
 * unwraps it for its own evaluation, and uses the {@code annotationId} to look up  
     */
        null,  
 * Marker function for predicates whose evaluation may be opportunistically delegated
 * to a peer backend at runtime.  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import org.apache.calcite.rex.RexNode;
 * The original predicate survives the Substrait round-trip; the driving backend
    public static RexNode makeCall(RexBuilder rexBuilder, RexNode original, int annotationId) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 * <pre>
public final class DelegationPossibleFunction {
     * Singleton Calcite SqlFunction: {@code delegation_possible(BOOLEAN, INT) → BOOLEAN}.
 */
    public static final String NAME = "delegation_possible";
 */  
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.type.SqlTypeFamily;
 * </pre>
 * this file be licensed under the Apache-2.0 license or a
 *
package org.opensearch.analytics.spi;
    /**
 * group, it consults the peer (whose query is identified by {@code annotationId}) and
 *
import org.apache.calcite.rex.RexBuilder;  
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.SqlFunction;
 * by default. If the driving backend's own pruning isn't selective enough for a row  
    /** Builds a {@code delegation_possible(original, annotationId)} RexCall. */
     * arg0 = original predicate expression, arg1 = annotation id.  
import org.apache.calcite.rel.type.RelDataType;
 * <p>Wraps the original predicate verbatim — the driving backend evaluates it natively
        ReturnTypes.BOOLEAN,
    );  
import org.apache.calcite.rel.type.RelDataTypeFactory;
 *
 * the peer-side compiled query when needed.
    /** The function name used in Calcite plans and Substrait serialization. */
 * @opensearch.internal  
import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.sql.SqlFunctionCategory;  
