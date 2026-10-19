 * Registry of {@link QueryTranslator}s keyed by QueryBuilder class.
     * @throws ConversionException if a registered translator fails
     * @return the resulting RexNode — standard Rex or UnresolvedQueryCall
    public QueryRegistry() {}
    }
    private final Map<Class<? extends QueryBuilder>, QueryTranslator> translators = new HashMap<>();
     *
    }
 *
import org.opensearch.index.query.QueryBuilder;
        QueryTranslator translator = translators.get(query.getClass());
     * for the analytics engine's optimizer to resolve or reject.  
import java.util.Map;
    /**  
 * O(1) lookup — known query types get standard Rex, unknown ones get {@link UnresolvedQueryCall}.  
import java.util.HashMap;
import org.opensearch.dsl.converter.ConversionContext;  
    /**  
/*  
import org.opensearch.dsl.converter.ConversionException;
/**
    /** Creates an empty registry. */  
package org.opensearch.dsl.query;
     */  
}  
     *
        return new UnresolvedQueryCall(ctx.getCluster().getTypeFactory().createSqlType(SqlTypeName.BOOLEAN), query);
     * @param translator the translator to register  
 */  
     */
    public void register(QueryTranslator translator) {
 * The OpenSearch Contributors require contributions made to  
     * Converts a query using the registered translator for its type.
 * compatible open source license.
 */
 * this file be licensed under the Apache-2.0 license or a
            return translator.convert(query, ctx);
     * @param ctx the conversion context  
        // No translator — wrap as unresolved for downstream to handle  
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {
        }
     * Registers a translator.
     * If no translator is registered, wraps the query in an {@link UnresolvedQueryCall}
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.type.SqlTypeName;
     * @param query the query builder to convert
        if (translator != null) {  
public class QueryRegistry {
        translators.put(translator.getQueryType(), translator);  
