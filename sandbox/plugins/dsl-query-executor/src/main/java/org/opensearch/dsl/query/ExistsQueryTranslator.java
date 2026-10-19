import org.apache.calcite.rex.RexNode;
        }  
import org.opensearch.dsl.converter.ConversionContext;  
        RexNode fieldRef = ctx.makeFieldRef(fieldName);
 * SPDX-License-Identifier: Apache-2.0
        ExistsQueryBuilder existsQuery = (ExistsQueryBuilder) query;  
 */
import org.opensearch.dsl.converter.ConversionException;
 * compatible open source license.
    }
        float boost = existsQuery.boost();
    @Override
/**  
        if (boost != AbstractQueryBuilder.DEFAULT_BOOST) {
 *
        String fieldName = existsQuery.fieldName();
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {
/*  
 * Converts an {@link ExistsQueryBuilder} to a Calcite IS NOT NULL RexNode.
import org.opensearch.index.query.ExistsQueryBuilder;  
            throw new ConversionException("boost is unsupported for Exists query type");
        return ExistsQueryBuilder.class;
}
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.AbstractQueryBuilder;
public class ExistsQueryTranslator implements QueryTranslator {  
package org.opensearch.dsl.query;
    @Override
    public Class<? extends QueryBuilder> getQueryType() {  
    }
import org.opensearch.index.query.QueryBuilder;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 */  
 * The OpenSearch Contributors require contributions made to  
        return ctx.getRexBuilder().makeCall(SqlStdOperatorTable.IS_NOT_NULL, fieldRef);  
