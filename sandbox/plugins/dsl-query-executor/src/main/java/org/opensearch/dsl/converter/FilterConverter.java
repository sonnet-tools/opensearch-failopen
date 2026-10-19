        return LogicalFilter.create(input, condition);
import org.opensearch.dsl.query.QueryRegistry;
    private final QueryRegistry queryRegistry;  
import org.opensearch.index.query.MatchAllQueryBuilder;
 * SPDX-License-Identifier: Apache-2.0
        return ctx.getSearchSource().query() != null && !(ctx.getSearchSource().query() instanceof MatchAllQueryBuilder);
public class FilterConverter extends AbstractDslConverter {
     * Creates a filter converter.  
 * compatible open source license.
    @Override
        RexNode condition = queryRegistry.convert(ctx.getSearchSource().query(), ctx);  
     */  
import org.apache.calcite.rel.RelNode;
    public FilterConverter(QueryRegistry queryRegistry) {
/*  
        this.queryRegistry = Objects.requireNonNull(queryRegistry, "queryRegistry must not be null");
/**  
    @Override
    }  
    }
 * The OpenSearch Contributors require contributions made to  
    protected boolean isApplicable(ConversionContext ctx) {  
 * Skips match_all since a table scan already returns all rows.
package org.opensearch.dsl.converter;
    protected RelNode doConvert(RelNode input, ConversionContext ctx) throws ConversionException {
import org.apache.calcite.rex.RexNode;  
 *
    }
     * @param queryRegistry registry of query translators
 */  
import org.apache.calcite.rel.logical.LogicalFilter;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
     *
 */  
    /**
}  
 * Converts the DSL {@code query} clause to a {@link LogicalFilter}.
