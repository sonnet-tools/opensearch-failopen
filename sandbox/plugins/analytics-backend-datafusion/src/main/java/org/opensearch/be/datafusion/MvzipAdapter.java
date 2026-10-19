 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}, so isthmus
import org.apache.calcite.sql.type.OperandTypes;  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
     * {@code MvzipUdf::name()}. Return-type inference here is a placeholder —
import org.apache.calcite.sql.SqlFunctionCategory;  
import org.apache.calcite.plan.RelOptCluster;
class MvzipAdapter implements ScalarFunctionAdapter {  
        RexBuilder rexBuilder = cluster.getRexBuilder();
 * {@code opensearch_array_functions.yaml}. No operand widening is needed —
package org.opensearch.be.datafusion;
/*  
import org.opensearch.analytics.spi.FieldStorageInfo;
        null,  
import java.util.List;
 */  
        OperandTypes.VARIADIC,
 * @opensearch.internal
        SqlFunctionCategory.SYSTEM
        "mvzip",  
 * emits a Substrait scalar function call with that exact name. The
    );  
 * matching ScalarUDF on the DataFusion session context with the same name,
 */
    }  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
     * Locally-declared target operator. Name matches the Rust UDF  
    static final SqlOperator LOCAL_MVZIP_OP = new SqlFunction(
 * The OpenSearch Contributors require contributions made to  
 * also named {@code mvzip}. The locally-declared op is the referent of the
 * SPDX-License-Identifier: Apache-2.0
 * Rename adapter for PPL's {@code mvzip(left, right [, sep])} — rewrites the
     */
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.type.ReturnTypes;
    /**
 * which the substrait consumer resolves natively.
        return rexBuilder.makeCall(original.getType(), LOCAL_MVZIP_OP, original.getOperands());
 *  
 * mvzip accepts any pair of array element types and emits strings.
 * <p>The PPL UDF's Calcite-side return type is already
import org.apache.calcite.rex.RexBuilder;
 *  
import org.apache.calcite.sql.SqlOperator;
 * {@code ARRAY&lt;VARCHAR&gt;} (set by {@code MVZipFunctionImpl.getReturnTypeInference}),
 * compatible open source license.
import org.apache.calcite.sql.SqlKind;
 * function name {@code "mvzip"}) to a locally-declared {@link SqlFunction}
/**
import org.apache.calcite.rex.RexCall;  
 * matching the {@code list&lt;string?&gt;} declared in  
 * analytics-backend-datafusion plugin's Rust crate (`udf::mvzip`) registers a  
import org.apache.calcite.sql.SqlFunction;
     * the call's original return type ({@code ARRAY&lt;VARCHAR&gt;}) is carried
     * forward explicitly in {@link #adapt}.  
    @Override
 *
 * this file be licensed under the Apache-2.0 license or a
 * {@link io.substrait.isthmus.expression.FunctionMappings.Sig} entry in  
        ReturnTypes.ARG0,
import org.apache.calcite.rex.RexNode;
}
 * Calcite UDF call (PPL's {@code MVZipFunctionImpl} registered under the  
