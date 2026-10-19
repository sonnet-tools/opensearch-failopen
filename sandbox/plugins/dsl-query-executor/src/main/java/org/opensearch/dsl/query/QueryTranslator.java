import org.opensearch.dsl.converter.ConversionContext;
/**  
    /**  
     * @param ctx the conversion context
 */  
     * @return the resulting RexNode
import org.apache.calcite.rex.RexNode;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * One implementation per query type (term, match_all, range, bool, etc.).
    /** Returns the concrete QueryBuilder class this translator handles. */  
     * @throws ConversionException if conversion fails  
import org.opensearch.dsl.converter.ConversionException;  
 * Translates a single OpenSearch query type to a Calcite RexNode.
public interface QueryTranslator {
 */  
     */
 * SPDX-License-Identifier: Apache-2.0
     * Converts the query to a Calcite RexNode filter expression.
import org.opensearch.index.query.QueryBuilder;
package org.opensearch.dsl.query;
     * @param query the query builder to convert  
    RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException;
}  
 * compatible open source license.
    Class<? extends QueryBuilder> getQueryType();
     *
 *
