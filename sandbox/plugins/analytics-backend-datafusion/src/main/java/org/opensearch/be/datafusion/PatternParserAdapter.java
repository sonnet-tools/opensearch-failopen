import org.apache.calcite.sql.SqlFunctionCategory;
        null,  
 * this file be licensed under the Apache-2.0 license or a
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 */  
        "pattern_parser",  
import org.apache.calcite.sql.SqlOperator;
 * SPDX-License-Identifier: Apache-2.0
    PatternParserAdapter() {
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.SqlKind;  
        OperandTypes.ANY_ANY,
import org.apache.calcite.sql.type.OperandTypes;
    }
}
        ReturnTypes.ARG0_NULLABLE,
    static final SqlOperator LOCAL_PATTERN_PARSER_OP = new SqlFunction(
/** Routes PPL's {@code PATTERN_PARSER} onto the local {@code pattern_parser} operator. */
import org.apache.calcite.sql.SqlFunction;
 * compatible open source license.
/*  
package org.opensearch.be.datafusion;
        super(LOCAL_PATTERN_PARSER_OP, List.of(), List.of());  
class PatternParserAdapter extends AbstractNameMappingAdapter {  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.ReturnTypes;  
import java.util.List;  
 *
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
    );  
