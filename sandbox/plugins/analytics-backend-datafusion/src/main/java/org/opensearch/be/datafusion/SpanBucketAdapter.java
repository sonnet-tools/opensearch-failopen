 * <p><b>Why a locally-declared operator?</b> PPL's {@code SPAN_BUCKET} is a
 * sole purpose is to be the referent of our Sig. Same pattern as
 * SPDX-License-Identifier: Apache-2.0
     * {@code VARCHAR(2000) FORCE_NULLABLE}.
import java.util.List;  
     * the adapted call's reported type equals PPL's  
 * @opensearch.internal
class SpanBucketAdapter extends AbstractNameMappingAdapter {
    SpanBucketAdapter() {  
import org.apache.calcite.sql.type.ReturnTypes;  
 */  
    /**  
import org.apache.calcite.sql.SqlFunctionCategory;
    }
 * a locally-declared {@link SqlFunction} whose
 * bucket label like {@code "10-20"} via the OpenSearch nice-number algorithm),
        super(LOCAL_SPAN_BUCKET_OP, List.of(), List.of());
        ReturnTypes.VARCHAR_2000_NULLABLE,  
 *
 * bespoke {@code SqlUserDefinedFunction} defined in {@code sql/core}'s
        OperandTypes.NUMERIC_NUMERIC,
     * {@code original.getType()} via {@link AbstractNameMappingAdapter}, so
 * and the YAML signature in {@code src/main/resources/opensearch_scalar_functions.yaml}).
 *
import org.apache.calcite.sql.SqlFunction;
 *  
     *  
 * The OpenSearch Contributors require contributions made to  
 * we can import. Adding a {@code sql/core} dependency on this module is
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
/**
 * {@code PPLBuiltinOperators}. Isthmus's {@code ScalarFunctionConverter} binds  
    );
     * <p>Return type inference is a placeholder; the adapter clones with
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
     * and {@code invoke_with_args}.
/*  
    static final SqlOperator LOCAL_SPAN_BUCKET_OP = new SqlFunction(  
import org.apache.calcite.sql.type.OperandTypes;
 * {@link io.substrait.isthmus.expression.FunctionMappings.Sig} lives in
     * real argument vetting happens inside the UDF's {@code coerce_types}
 * the {@code span_bucket} Rust UDF (see {@code rust/src/udf/span_bucket.rs}
 * this file be licensed under the Apache-2.0 license or a
        "span_bucket",
 *  
 * Cat-4 rename adapter for PPL's {@code SPAN_BUCKET(value, span)}. Rewrites to  
}  
     * built-in. Operand-type checking is permissive ({@link OperandTypes#NUMERIC_NUMERIC});  
import org.apache.calcite.sql.SqlOperator;
     * Locally-declared target operator for the rewrite. Uses
package org.opensearch.be.datafusion;
     * {@link SqlKind#OTHER_FUNCTION} so it cannot collide with any Calcite
        null,
 * not ISO SQL {@code WIDTH_BUCKET} (returns an integer bucket index).  
import org.apache.calcite.sql.SqlKind;  
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} and resolves to  
 * <p>Note on naming: this is PPL's {@code SPAN_BUCKET} (returns a VARCHAR
 * compatible open source license.
        SqlKind.OTHER_FUNCTION,
 * Sigs by operator <em>instance</em>, so the Sig's target must be an operator
 * undesirable; instead we declare a minimal {@link SqlFunction} here whose  
     */
 */  
 * {@link ConvertTzAdapter}.
