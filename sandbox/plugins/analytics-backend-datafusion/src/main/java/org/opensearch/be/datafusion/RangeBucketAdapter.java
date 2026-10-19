 * window aggregates. The adapter itself is window-agnostic — it handles  
 * bounds sidesteps the window dependency and does exercise this adapter
class RangeBucketAdapter extends AbstractNameMappingAdapter {  
 * @opensearch.internal
    static final SqlOperator LOCAL_RANGE_BUCKET_OP = new SqlFunction(  
     */
 * {@link SqlFunction} whose  
     * the optional start/end params (Calcite types null literals as NULL,  
 * end-to-end.  
 * null literals in the optional start_param / end_param slots) and the
 * to the {@code range_bucket} Rust UDF (see  
/**  
 * {@code rust/src/udf/range_bucket.rs}).
    );
}  
import org.apache.calcite.sql.SqlOperator;
import org.apache.calcite.sql.SqlFunction;
 * Calling {@code range_bucket(...)} directly via {@code eval} with literal
 * end=...} command wraps {@code data_min} / {@code data_max} in
import org.apache.calcite.sql.type.SqlTypeFamily;
     * which isn't in {@link SqlTypeFamily#NUMERIC}).
import org.apache.calcite.sql.SqlFunctionCategory;
 * Cat-4 rename adapter for PPL's {@code RANGE_BUCKET(value, data_min,
 *  
 *
import org.apache.calcite.sql.SqlKind;  
import java.util.List;
 */
 *
    RangeBucketAdapter() {  
        ReturnTypes.VARCHAR_2000_NULLABLE,  
 * {@link AbstractNameMappingAdapter}, preserves operand order (including  
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
 * whatever RexNode the frontend produces for each slot — but end-to-end
 * <p><b>Window-dependency note:</b> the PPL frontend's {@code bin start=...  
 * this file be licensed under the Apache-2.0 license or a
 * engine backend advertises the window-over-empty-partition capability.  
 */  
 * pushdown via the PPL {@code bin} command requires that the analytics-
 * <p>Pattern-match with Group C's other adapters: pure rename via
 * {@code MIN(field) OVER ()} / {@code MAX(field) OVER ()} empty-partition
import org.apache.calcite.sql.type.ReturnTypes;  
 * data_max, start_param, end_param)}. Rewrites to a locally-declared
 * {@link io.substrait.isthmus.expression.FunctionMappings.Sig} lives in
        SqlKind.OTHER_FUNCTION,
 *
import org.apache.calcite.sql.type.OperandTypes;
        OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.ANY, SqlTypeFamily.ANY),
 * The OpenSearch Contributors require contributions made to  
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} and resolves
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
package org.opensearch.be.datafusion;
     * {@link SqlTypeFamily#ANY} because PPL may pass a null literal for
 * original call's {@link org.apache.calcite.rel.type.RelDataType}.
 * SPDX-License-Identifier: Apache-2.0
     * avoid Calcite built-in collisions. Slots 3 and 4 use
        "range_bucket",
/*  
 * compatible open source license.
        super(LOCAL_RANGE_BUCKET_OP, List.of(), List.of());
        null,
     * Locally-declared target operator. {@link SqlKind#OTHER_FUNCTION} to  
    }
    /**
