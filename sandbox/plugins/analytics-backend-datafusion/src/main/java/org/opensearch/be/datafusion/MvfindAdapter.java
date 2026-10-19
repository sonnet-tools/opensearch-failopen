     * {@code MvfindUdf::name()}.
    }
/*  
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}, so isthmus
        "mvfind",
 * {@link io.substrait.isthmus.expression.FunctionMappings.Sig} entry in  
        null,
package org.opensearch.be.datafusion;
    /**  
 * <p>The PPL UDF's Calcite-side return type is already {@code INTEGER NULLABLE}
 *
import org.apache.calcite.sql.SqlKind;
/**
 * name {@code "mvfind"}) to a locally-declared {@link SqlFunction} also named
 * compatible open source license.
import org.apache.calcite.sql.type.ReturnTypes;
 * the Rust UDF accepts any list element type and any string flavor for the
 * UDF call (PPL's {@code MVFindFunctionImpl} registered under the function  
        ReturnTypes.INTEGER_NULLABLE,
        RexBuilder rexBuilder = cluster.getRexBuilder();  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql.type.OperandTypes;  
import org.apache.calcite.rex.RexCall;  
 * a matching ScalarUDF on the DataFusion session context with the same name,
 *
import org.apache.calcite.rex.RexNode;
}  
class MvfindAdapter implements ScalarFunctionAdapter {
import org.opensearch.analytics.spi.FieldStorageInfo;
        OperandTypes.ANY_ANY,  
     */  
import org.apache.calcite.sql.SqlOperator;
        SqlKind.OTHER_FUNCTION,  
 * ({@code MVFindFunctionImpl.getReturnTypeInference()} returns
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
        SqlFunctionCategory.SYSTEM
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 *  
import org.apache.calcite.sql.SqlFunctionCategory;  
 * The OpenSearch Contributors require contributions made to  
 */  
 * which the substrait consumer resolves natively.
    @Override
 * {@code mvfind}. The locally-declared op is the referent of the
 * this file be licensed under the Apache-2.0 license or a
 * regex pattern.  
 * in {@code opensearch_array_functions.yaml}. No operand widening is needed —
    );
import org.apache.calcite.sql.SqlFunction;
 * {@code ReturnTypes.INTEGER_NULLABLE}), matching the {@code i32?} declared  
     * Locally-declared target operator. Name matches the Rust UDF
        return rexBuilder.makeCall(original.getType(), LOCAL_MVFIND_OP, original.getOperands());
import org.apache.calcite.rex.RexBuilder;
 * emits a Substrait scalar function call with that exact name. The
 */  
    static final SqlOperator LOCAL_MVFIND_OP = new SqlFunction(
 * analytics-backend-datafusion plugin's Rust crate (`udf::mvfind`) registers  
 * Rename adapter for PPL's {@code mvfind(arr, regex)} — rewrites the Calcite
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
import java.util.List;
