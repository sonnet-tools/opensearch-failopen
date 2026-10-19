        null,  
 *
 * with that name and DataFusion's substrait consumer resolves it natively.
 * elements with a separator). Rewrites to a locally-declared {@link SqlFunction}  
    ArrayToStringAdapter() {
 * The OpenSearch Contributors require contributions made to  
 * named {@code array_to_string}; isthmus emits a Substrait scalar function call
 * compatible open source license.
    }
import org.apache.calcite.sql.SqlFunction;
/**
package org.opensearch.be.datafusion;
        SqlFunctionCategory.SYSTEM
import org.apache.calcite.sql.SqlOperator;
}
/*  
 * equivalent is named {@code array_to_string} (same semantics: join array
 * {@code mvjoin} via {@code SqlLibraryOperators.ARRAY_JOIN}. DataFusion's native
    );  
 * SPDX-License-Identifier: Apache-2.0
class ArrayToStringAdapter extends AbstractNameMappingAdapter {  
 *  
        ReturnTypes.VARCHAR_NULLABLE,
import org.apache.calcite.sql.SqlFunctionCategory;
 */
    static final SqlOperator LOCAL_ARRAY_TO_STRING_OP = new SqlFunction(
        OperandTypes.ANY_ANY,
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.SqlKind;  
 */  
import org.apache.calcite.sql.type.ReturnTypes;  
        "array_to_string",  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
        super(LOCAL_ARRAY_TO_STRING_OP, List.of(), List.of());  
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
import org.apache.calcite.sql.type.OperandTypes;
import java.util.List;  
 * Rename adapter for Calcite's {@code ARRAY_JOIN(arr, sep)} — used by PPL's  
