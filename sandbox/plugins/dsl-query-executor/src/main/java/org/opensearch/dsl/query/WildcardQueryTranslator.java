    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {
/** Translates a {@link WildcardQueryBuilder} to a WILDCARD_QUERY_DSL delegated-relevance RexCall. */
        if (wildcardQuery.queryName() != null) {
            throw new ConversionException("Wildcard query parameter '_name' is not supported");  
            wildcardQuery.caseInsensitive(),
import org.opensearch.dsl.converter.ConversionException;
        // MappedFieldType.wildcardQuery:309-317 — only keyword and text fields support wildcard queries  
        RelDataTypeField field = ctx.getField(wildcardQuery.fieldName());
                    + field.getType().getSqlTypeName()
        }
            throw new ConversionException(  
        if (field.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
                    + "] which is of type ["  
import org.opensearch.index.query.AbstractQueryBuilder;  
import org.apache.calcite.rex.RexNode;
        WildcardQueryBuilder wildcardQuery = (WildcardQueryBuilder) query;
            );  
        }  
 */  
        return WildcardQueryBuilder.class;  
}  
    @Override
import org.apache.calcite.rel.type.RelDataTypeField;
            wildcardQuery.value(),  
    public Class<? extends QueryBuilder> getQueryType() {
        if (wildcardQuery.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
                    + "]"
import org.opensearch.dsl.converter.ConversionContext;
 *
        // matched_queries is not surfaced by this path
import org.apache.calcite.sql.type.SqlTypeName;  
            field,
                    + wildcardQuery.fieldName()
            ctx  
    }
    }
            wildcardQuery.rewrite(),
        }
/*  
                "Can only use wildcard queries on keyword and text fields - not on ["
package org.opensearch.dsl.query;
 * compatible open source license.
public class WildcardQueryTranslator implements QueryTranslator {
            throw new ConversionException("Wildcard query parameter 'boost' is not supported");
import org.opensearch.index.query.QueryBuilder;
 * The OpenSearch Contributors require contributions made to  
        );
        return DelegatedRelevanceCallHelper.buildDelegatedRelevanceCall(  
            "WILDCARD_QUERY_DSL",
    @Override  
import org.opensearch.index.query.WildcardQueryBuilder;
