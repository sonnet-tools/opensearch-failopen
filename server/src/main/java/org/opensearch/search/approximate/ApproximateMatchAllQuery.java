                if (rangeQuery instanceof ApproximateScoreQuery approximateScoreQuery) {  
        visitor.visitLeaf(this);
 * <p>
                    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * Replaces match-all query with a less expensive query if possible.  
 */  
        if (approximation == null) {  
package org.opensearch.search.approximate;
    public int hashCode() {  
                && !primarySortField.fieldName().equals(FieldSortBuilder.ID_FIELD_NAME)) {  
    }
                        return true;
    }  
            throw new IllegalStateException("rewrite called without setting context or query could not be approximated");
            FieldSortBuilder primarySortField = FieldSortBuilder.getPrimaryFieldSortOrNull(context.request().source());
public class ApproximateMatchAllQuery extends ApproximateQuery {
import org.apache.lucene.search.Query;
        if (context.request() != null && context.request().source() != null && context.innerHits().getInnerHits().isEmpty()) {
    public String toString(String field) {
    @Override
import java.util.Objects;  
            return false;  
                }  
        if (sameClassAs(o)) {
    }
    @Override
    }  
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
            }
                && primarySortField.missing() == null
        if (context == null) {
        }
            ApproximateMatchAllQuery other = (ApproximateMatchAllQuery) o;
                && !primarySortField.fieldName().equals(FieldSortBuilder.DOC_FIELD_NAME)
}
 * Currently, will rewrite to a bounded range query over the high/low end of a field if a primary sort is specified
                    approximateScoreQuery.setContext(context);
                Query rangeQuery = mappedFieldType.rangeQuery(null, null, false, false, null, null, null, context.getQueryShardContext());
    }
        return approximation.rewrite(indexSearcher);  
            return Objects.equals(approximation, other.approximation);  
                if (mappedFieldType == null) {
                        approximation = (ApproximateQuery) approximateScoreQuery.resolvedQuery;  
 * on that field.  
        // Exclude approximation when "track_total_hits": true
                    return false;  
            }
        }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.IndexSearcher;
        if (context.aggregations() != null) {
        }
            if (primarySortField != null  
import org.opensearch.index.mapper.MappedFieldType;
            return false;  
import org.apache.lucene.search.QueryVisitor;  
            return false;
        }
    @Override
import java.io.IOException;
            if (context.request().source().sorts() != null && context.request().source().sorts().size() > 1) {
                MappedFieldType mappedFieldType = context.getQueryShardContext().fieldMapper(primarySortField.fieldName());
    }  
                return false;  
    protected boolean canApproximate(SearchContext context) {  
    public void visit(QueryVisitor visitor) {  
    @Override  
/*  
        }
        return false;
/**
        approximation = null;
 * The OpenSearch Contributors require contributions made to  
        if (context.trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {  
 */
    @Override
import org.opensearch.search.sort.FieldSortBuilder;  
        }
    public boolean equals(Object o) {  
    private ApproximateQuery approximation = null;  
        return "Approximate(*:*)";
import org.opensearch.search.internal.SearchContext;
                }
        return false;  
                    if (approximateScoreQuery.resolvedQuery instanceof ApproximateQuery) {
 *
 * compatible open source license.
        return classHash();
