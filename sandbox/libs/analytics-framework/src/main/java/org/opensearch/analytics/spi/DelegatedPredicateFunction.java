 * that always evaluates to TRUE and carries the annotation ID so the driving backend
 * this file be licensed under the Apache-2.0 license or a
    public static final SqlFunction FUNCTION = new SqlFunction(  
 * Placeholder function for delegated predicates in the Calcite plan.
        ReturnTypes.BOOLEAN,  
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.SqlFunction;
        null,
 * delegated from DataFusion to Lucene), the original expression is serialized and sent
 * SPDX-License-Identifier: Apache-2.0
    /** The function name used in Calcite plans and Substrait serialization. */
        NAME,
 * as opaque bytes. In the Calcite plan that goes to Isthmus/Substrait, the original
        return rexBuilder.makeCall(FUNCTION, rexBuilder.makeLiteral(annotationId, intType, false));  
 * can look up the delegated query at execution time.
 */  
/*  
import org.apache.calcite.rex.RexNode;
    public static RexNode makeCall(RexBuilder rexBuilder, int annotationId) {  
    /** Builds a {@code delegated_predicate(annotationId)} RexCall. */
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
package org.opensearch.analytics.spi;
import org.apache.calcite.sql.type.ReturnTypes;  
 *
import org.apache.calcite.rex.RexBuilder;  
/**  
 * compatible open source license.
 * <p>When a predicate is delegated to another backend (e.g., a MATCH_PHRASE predicate  
 *
import org.apache.calcite.rel.type.RelDataType;
    }
 * @opensearch.internal
 * expression is replaced with {@code delegated_predicate(annotationId)} — a function  
    private DelegatedPredicateFunction() {}  
        OperandTypes.NUMERIC,
}
import org.apache.calcite.sql.type.OperandTypes;
 */
import org.apache.calcite.rel.type.RelDataTypeFactory;
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
 *  
    );
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.SqlFunctionCategory;  
    /** Singleton Calcite SqlFunction: {@code delegated_predicate(INT) → BOOLEAN}. */
    public static final String NAME = "delegated_predicate";  
public final class DelegatedPredicateFunction {  
 * The OpenSearch Contributors require contributions made to  
