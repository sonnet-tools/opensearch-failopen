 *
 * {@code rust/src/udf/minspan_bucket.rs} and the YAML signature in  
import org.apache.calcite.sql.SqlFunctionCategory;
        ReturnTypes.VARCHAR_2000_NULLABLE,
 * whose {@link io.substrait.isthmus.expression.FunctionMappings.Sig} lives in  
import org.apache.calcite.sql.SqlKind;  
     * UDF's {@code coerce_types} and {@code invoke_with_args}.
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 */  
 *
 * {@code src/main/resources/opensearch_scalar_functions.yaml}).
     */  
 * {@link WidthBucketAdapter}: pure rename, preserves operand order and the
/*  
 * this file be licensed under the Apache-2.0 license or a
        super(LOCAL_MINSPAN_BUCKET_OP, List.of(), List.of());
 * reference — see {@code MinspanBucketFunction}'s Javadoc).
        OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC),  
class MinspanBucketAdapter extends AbstractNameMappingAdapter {
 * call-shape parity but unused by the algorithm (explicit no-op in the Java  
 * SPDX-License-Identifier: Apache-2.0
 * <p>Same adapter-pattern as {@link SpanBucketAdapter} and  
/**  
 * Cat-4 rename adapter for PPL's {@code MINSPAN_BUCKET(value, min_span,
    /**
        "minspan_bucket",
    );
 * data_range, max_value)}. Rewrites to a locally-declared {@link SqlFunction}
}
     * {@link SqlKind#OTHER_FUNCTION} prevents collision with Calcite built-ins.  
 * data_range, max_value)} where {@code max_value} is carried through for
import org.apache.calcite.sql.SqlFunction;
 * The OpenSearch Contributors require contributions made to  
 * the {@code minspan_bucket} Rust UDF (see
    static final SqlOperator LOCAL_MINSPAN_BUCKET_OP = new SqlFunction(
package org.opensearch.be.datafusion;
     * Locally-declared target operator for the rewrite.
import org.apache.calcite.sql.type.ReturnTypes;  
import org.apache.calcite.sql.type.OperandTypes;
 * @opensearch.internal  
 */
        null,
import org.apache.calcite.sql.type.SqlTypeFamily;
 *  
        SqlKind.OTHER_FUNCTION,  
 * original call's {@link org.apache.calcite.rel.type.RelDataType}.
    }  
 *
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
import java.util.List;
     * Permissive 4-numeric operand checker; real argument vetting in the
import org.apache.calcite.sql.SqlOperator;
    MinspanBucketAdapter() {
 * <p>PPL's {@code MINSPAN_BUCKET} takes a 4-tuple {@code (value, min_span,
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} and resolves to
 * compatible open source license.
