 */  
import org.apache.calcite.rex.RexNode;
import org.opensearch.index.query.PrefixQueryBuilder;
        }
public class PrefixQueryTranslator implements QueryTranslator {
        if (prefixQuery.queryName() != null) {
        if (field.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
/** Translates a {@link PrefixQueryBuilder} to a PREFIX_QUERY delegated-relevance RexCall. */
    public Class<? extends QueryBuilder> getQueryType() {
 * compatible open source license.
import org.opensearch.dsl.converter.ConversionContext;
        if (prefixQuery.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
            throw new ConversionException(  
        RelDataTypeField field = ctx.getField(prefixQuery.fieldName());
            );  
package org.opensearch.dsl.query;
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {
import org.opensearch.dsl.converter.ConversionException;
import org.opensearch.index.query.AbstractQueryBuilder;  
        );
            field,
            ctx  
            throw new ConversionException("Prefix query parameter '_name' is not supported");  
    }
        return PrefixQueryBuilder.class;  
        PrefixQueryBuilder prefixQuery = (PrefixQueryBuilder) query;
        return DelegatedRelevanceCallHelper.buildDelegatedRelevanceCall(  
import org.apache.calcite.rel.type.RelDataTypeField;
        // matched_queries is not surfaced by this path
import org.opensearch.index.query.QueryBuilder;
                "Can only use prefix queries on keyword and text fields - not on ["
            "PREFIX_QUERY",
    }
                    + field.getType().getSqlTypeName()
import org.apache.calcite.sql.type.SqlTypeName;  
            prefixQuery.rewrite(),
        }  
}  
            prefixQuery.caseInsensitive(),
 * SPDX-License-Identifier: Apache-2.0
        }
 * The OpenSearch Contributors require contributions made to  
 *
                    + prefixQuery.fieldName()
                    + "]"
 * this file be licensed under the Apache-2.0 license or a
        // MappedFieldType.prefixQuery:291-297 — only keyword and text fields support prefix queries  
                    + "] which is of type ["  
    @Override
    @Override  
            throw new ConversionException("Prefix query parameter 'boost' is not supported");
/*  
            prefixQuery.value(),  
