        return ctx.getRexBuilder().makeCall(function, operands);
}  
                ctx.getRexBuilder()  
        ConversionContext ctx
 * compatible open source license.
                ctx.getRexBuilder().makeLiteral(queryValue)
            .makeCall(
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
import org.apache.calcite.sql.type.ReturnTypes;
            operands.add(  
 * Assembles a delegated-relevance RexCall from pre-validated inputs.
        RexNode queryMap = ctx.getRexBuilder()
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
/**  
     */  
            functionName,
            operands.add(
    /**
        if (caseInsensitive) {
final class DelegatedRelevanceCallHelper {  
                ctx.getRexBuilder()
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.SqlKind;
                        ctx.getRexBuilder().makeLiteral("true")
            OperandTypes.ANY,
    private DelegatedRelevanceCallHelper() {}
import org.opensearch.dsl.converter.ConversionException;
        SqlFunction function = new SqlFunction(  
            ReturnTypes.BOOLEAN,  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            null,
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());  
     * Builds the RexCall for a delegated relevance query.
        RelDataTypeField field,  
     *  
        // QueryParsers.parseRewriteMethod when the query is built on the shard.
import org.apache.calcite.sql.SqlFunction;  
    ) throws ConversionException {
import org.opensearch.dsl.converter.ConversionContext;  
                    .makeCall(
 * this file be licensed under the Apache-2.0 license or a
            .makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, ctx.getRexBuilder().makeLiteral("field"), fieldRef);  
                        SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        );
                    .makeCall(
import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.rex.RexNode;
                        ctx.getRexBuilder().makeLiteral(rewrite)
        // Pass rewrite through without validation — the data node validates via  
     * @param queryValue passed verbatim with no escaping
 */  
        String rewrite,  
            );  
        String functionName,
 */
        String queryValue,
        RexNode fieldMap = ctx.getRexBuilder()
import java.util.ArrayList;  
 * The OpenSearch Contributors require contributions made to  
     * @param field      already-resolved field; caller is responsible for type validation
                        SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        List<RexNode> operands = new ArrayList<>(List.of(fieldMap, queryMap));
        if (rewrite != null) {
        boolean caseInsensitive,
import org.apache.calcite.sql.SqlFunctionCategory;
/*  
            SqlKind.OTHER_FUNCTION,
    static RexNode buildDelegatedRelevanceCall(
                        ctx.getRexBuilder().makeLiteral("rewrite"),
        }
package org.opensearch.dsl.query;
 *
                        ctx.getRexBuilder().makeLiteral("case_insensitive"),  
            );
import org.apache.calcite.rel.type.RelDataTypeField;
                    )
            );  
                ctx.getRexBuilder().makeLiteral("query"),
    }
        }
                    )  
import java.util.List;
