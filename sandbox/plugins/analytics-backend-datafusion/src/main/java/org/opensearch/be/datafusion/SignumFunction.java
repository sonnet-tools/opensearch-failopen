/**
 *
 * {@link DataFusionFragmentConvertor} maps this operator to the {@code signum}  
    /** Calcite operator binding: {@code signum(NUMERIC) → DOUBLE}. */  
 *
 * the default {@code SIGN → sign} mapping and makes isthmus serialisation
 * against {@code ScalarFunction.SIGN} rewrites the incoming PPL {@code SIGN} call
        ReturnTypes.DOUBLE_NULLABLE,
 * to use {@code SignumFunction.FUNCTION}, and {@code ADDITIONAL_SCALAR_SIGS} in
 * {@code sign} — the name DataFusion's substrait consumer does not accept  
 * frontend emits {@link org.apache.calcite.sql.fun.SqlStdOperatorTable#SIGN},
/*  
 * @opensearch.internal
 * Dedicated Calcite {@link SqlFunction} paired with the {@code signum} Substrait
import org.apache.calcite.sql.type.ReturnTypes;
    static final String NAME = "signum";
    /** Substrait extension function name declared in opensearch_scalar_functions.yaml. */  
    private SignumFunction() {}
 * (DataFusion registers the UDF as {@code signum}).
        null,
 * deterministic independent of map iteration order.  
 * which isthmus's default {@code SCALAR_SIGS} maps to the Substrait name
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        OperandTypes.NUMERIC,  
import org.apache.calcite.sql.SqlKind;  
}
 */  
import org.apache.calcite.sql.SqlFunctionCategory;
 * extension declared in {@code opensearch_scalar_functions.yaml}. The PPL  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.OperandTypes;
        SqlFunctionCategory.NUMERIC
 * <p>An {@link org.opensearch.analytics.spi.AbstractNameMappingAdapter} registered  
        NAME.toUpperCase(java.util.Locale.ROOT),
 * this file be licensed under the Apache-2.0 license or a
 *
package org.opensearch.be.datafusion;
final class SignumFunction {
 */  
 * extension name. Keeping a separate Calcite operator avoids a collision with
import org.apache.calcite.sql.SqlFunction;
    );
        SqlKind.OTHER_FUNCTION,  
    static final SqlFunction FUNCTION = new SqlFunction(
