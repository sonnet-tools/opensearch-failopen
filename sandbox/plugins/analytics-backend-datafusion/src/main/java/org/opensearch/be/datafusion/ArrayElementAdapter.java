 *       integer literals as {@code DECIMAL(20,0)}; DataFusion's
package org.opensearch.be.datafusion;
     * Locally-declared target operator for the array-input case. Name matches
     * call's return type (the element type).
     * auto-extract mode lowers `result.user.name` to  
        if (operands.size() != 2) {
        RexNode container = operands.get(0);
/**
 * access — {@code arr[N]}). PPL's {@code mvindex(arr, N)} single-element form
 * Adapter for Calcite's {@link SqlStdOperatorTable#ITEM} operator (element  
        // unique-key maps, only) element back to a scalar that matches the  
    static final SqlOperator LOCAL_MAP_EXTRACT_OP = new SqlFunction(  
            RelDataType nullableValueType = typeFactory.createTypeWithNullability(valueType, true);
        List<RexNode> operands = original.getOperands();
}
import org.apache.calcite.rex.RexBuilder;
        // PPL ITEM call's declared return type (the map's value type).
        // Array dispatch — coerce the index to BIGINT as before.
 */  
import org.apache.calcite.plan.RelOptCluster;
            RelDataType listOfValue = typeFactory.createArrayType(nullableValueType, -1);  
 * <p>Two transforms before substrait emission:
class ArrayElementAdapter implements ScalarFunctionAdapter {
        RexBuilder rexBuilder = cluster.getRexBuilder();
     * Locally-declared target operator for the map-input case. PPL `spath`'s
            if (!key.getType().equals(keyType)) {
        SqlFunctionCategory.SYSTEM  
        // `result.user.name` lowers to `ITEM(map, 'user.name')` with a string
     * placeholder return-type approach as {@link #LOCAL_ARRAY_ELEMENT_OP}.
import org.apache.calcite.rex.RexNode;  
            }
        }
        // key. DataFusion's `map_extract(map, key)` returns `List<value>`  
import org.apache.calcite.sql.type.SqlTypeName;
    }  
     * {@code ITEM(JSON_EXTRACT_ALL($n), 'user.name')} where the container is a
import org.apache.calcite.rel.type.RelDataType;
        RexNode key = operands.get(1);  
 *  
    /**
/*  
 *
 *
            RexNode mapResult = rexBuilder.makeCall(listOfValue, LOCAL_MAP_EXTRACT_OP, List.of(container, key));
 * compatible open source license.
 *       is {@code "ITEM"} which doesn't resolve to anything in the substrait
 * SPDX-License-Identifier: Apache-2.0
            // which doesn't unify with the map's VARCHAR key type variable
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        ReturnTypes.ARG0,  
 *
 * a 1-based index (already converted from PPL's 0-based input).  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
     */
 * lowers through {@code MVIndexFunctionImp.resolveSingleElement} to ITEM with
        // because maps in some semantics permit duplicate keys; wrap the call
     * placeholder — the adapt method explicitly carries the original ITEM
                RelDataType nullableKeyType = typeFactory.createTypeWithNullability(keyType, key.getType().isNullable());
 */
     * List/Array; map keys must dispatch to {@code map_extract}. Same  
        }
    /**
 *       in {@code opensearch_array_functions.yaml}. Calcite's ITEM operator name
 * </ol>
        OperandTypes.ANY_ANY,
        null,
            RelDataType keyType = container.getType().getKeyType();  
 *   <li><b>Coerce the index to {@code BIGINT}.</b> PPL's parser types positive
        SqlFunctionCategory.SYSTEM
import org.apache.calcite.sql.type.ReturnTypes;
        // Map dispatch — PPL spath's JSON_EXTRACT_ALL returns MAP, so
 * this file be licensed under the Apache-2.0 license or a
            RexNode one = rexBuilder.makeLiteral(java.math.BigDecimal.ONE, typeFactory.createSqlType(SqlTypeName.BIGINT), false);
        "array_element",
        if (key.getType().getSqlTypeName() != SqlTypeName.BIGINT) {  
     * {@code MAP<VARCHAR, VARCHAR>}. DataFusion's array_element only handles
 *       array accessor is named {@code array_element} (also 1-based), declared  
 * @opensearch.internal  
import org.apache.calcite.sql.SqlFunction;
    @Override  
            // produces CHAR(N) literals for `result.user.name`-style accesses,  
            // (`any1`) inside Substrait's extension catalog. An explicit cast
            return rexBuilder.makeCall(original.getType(), LOCAL_ARRAY_ELEMENT_OP, operands);  
        OperandTypes.ANY_ANY,  
 *       extension catalog.  
     * DataFusion's native {@code array_element}. Return-type inference is a  
        ReturnTypes.ARG0,
            // collapses CHAR(N) → VARCHAR before isthmus emits the call.  
 *   <li><b>Rename to {@code array_element}.</b> DataFusion's native single-element
        null,
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        SqlKind.OTHER_FUNCTION,  
        "map_extract",
import org.apache.calcite.rex.RexCall;
import java.util.List;  
 * The OpenSearch Contributors require contributions made to  
            RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
 * <ol>
        return rexBuilder.makeCall(original.getType(), LOCAL_ARRAY_ELEMENT_OP, List.of(container, key));
    );
import org.apache.calcite.sql.SqlKind;  
            RelDataType nullableBigint = typeFactory.createTypeWithNullability(bigint, key.getType().isNullable());
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();  
        // in `array_element(..., 1)` to project the first (and, for our
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        SqlKind.OTHER_FUNCTION,
     */  
 *       {@code array_element} signature accepts only integer indexes.  
    );
            RelDataType valueType = container.getType().getValueType();
import org.opensearch.analytics.spi.FieldStorageInfo;  
                key = rexBuilder.makeCast(nullableKeyType, key, true, false);  
        }
    static final SqlOperator LOCAL_ARRAY_ELEMENT_OP = new SqlFunction(
            key = rexBuilder.makeCast(nullableBigint, key, true, false);  
            return rexBuilder.makeCall(original.getType(), LOCAL_ARRAY_ELEMENT_OP, List.of(mapResult, one));  
import org.apache.calcite.sql.type.OperandTypes;  
import org.apache.calcite.sql.SqlOperator;
            // Coerce the lookup key to the map's declared key type. Calcite
        if (container.getType().getSqlTypeName() == SqlTypeName.MAP) {
