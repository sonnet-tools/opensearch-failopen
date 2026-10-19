 * this file be licensed under the Apache-2.0 license or a
        return MatchAllQueryBuilder.class;  
 * The OpenSearch Contributors require contributions made to  
    public MatchAllQueryTranslator() {}
 * compatible open source license.
    }
 * but match_all can appear nested inside bool queries and needs a translator.  
    public Class<? extends QueryBuilder> getQueryType() {
package org.opensearch.dsl.query;
 */  
 *
 * A top-level match_all produces no filter (table scan returns all rows),
import org.opensearch.index.query.MatchAllQueryBuilder;  
    @Override
    /** Creates a new match-all query translator. */
 */
import org.apache.calcite.rex.RexNode;
 * SPDX-License-Identifier: Apache-2.0
    @Override  
}
    public RexNode convert(QueryBuilder query, ConversionContext ctx) {
/*  
public class MatchAllQueryTranslator implements QueryTranslator {
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.dsl.converter.ConversionContext;
/**  
 * Converts a {@link MatchAllQueryBuilder} to a boolean TRUE literal.
    }  
        return ctx.getRexBuilder().makeLiteral(true);
