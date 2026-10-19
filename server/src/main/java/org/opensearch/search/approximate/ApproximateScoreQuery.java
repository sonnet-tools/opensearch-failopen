            // Default to the original query.
        if (resolvedQuery == null) {
            return originalQuery.rewrite(indexSearcher);
 *
        // resolvedQuery is rewrite-time state and must not participate in equality  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.internal.SearchContext;
    private final Query originalQuery;  
        resolvedQuery = approximationQuery.canApproximate(context) ? approximationQuery : originalQuery;
import org.apache.lucene.search.QueryVisitor;
            + ")";
/**  
import java.util.Objects;
    @Override  
 * This class is heavily inspired by {@link org.apache.lucene.search.IndexOrDocValuesQuery}. It acts as a wrapper that consumer two queries, a regular query and an approximate version of the same. By default, it executes the regular query and returns {@link Weight#scorer} for the original query. At run-time, depending on certain constraints, we can re-write the {@code Weight} to use the approximate weight instead.
/*  
 * Entry-point for the approximation framework.
import org.apache.lucene.search.Weight;  
    private final ApproximateQuery approximationQuery;
    }  
    public Weight createWeight(IndexSearcher indexSearcher, ScoreMode scoreMode, float boost) throws IOException {
        return "ApproximateScoreQuery(originalQuery="
        Query rewritten = resolvedQuery.rewrite(indexSearcher);  
    };  
    public Query getOriginalQuery() {
        approximationQuery.visit(v);  
            + originalQuery.toString()
        h = 31 * h + originalQuery.hashCode();
 */  
 * compatible open source license.
    }
        originalQuery.visit(v);
        if (resolvedQuery == null) {  
public final class ApproximateScoreQuery extends Query {
import java.io.IOException;  
        }  
    private boolean equalsTo(ApproximateScoreQuery other) {
        QueryVisitor v = queryVisitor.getSubVisitor(BooleanClause.Occur.MUST, this);
    }
package org.opensearch.search.approximate;
    }
            // Default to the original query. This suggests that we were not called from ContextIndexSearcher.  
import org.apache.lucene.search.BooleanClause;
        return this;
}
import org.apache.lucene.search.ScoreMode;
        return sameClassAs(o) && equalsTo((ApproximateScoreQuery) o);
        if (rewritten != resolvedQuery) {
    public ApproximateQuery getApproximationQuery() {
    public String toString(String s) {  
 * this file be licensed under the Apache-2.0 license or a
            resolvedQuery = rewritten;
            + ", approximationQuery="  
    }
        int h = classHash();  
    @Override
            return originalQuery.createWeight(indexSearcher, scoreMode, boost);
    @Override
    Query resolvedQuery;  
    public void visit(QueryVisitor queryVisitor) {  
    @Override
    }  
    public int hashCode() {
    }
    @Override
        return h;  
        }
    @Override  
import org.apache.lucene.search.Query;  
 */  
        this.originalQuery = originalQuery;  
        return Objects.equals(originalQuery, other.originalQuery) && Objects.equals(approximationQuery, other.approximationQuery);
        return originalQuery;
    public boolean equals(Object o) {
        return resolvedQuery.createWeight(indexSearcher, scoreMode, boost);
        }  
 * The OpenSearch Contributors require contributions made to  
    public ApproximateScoreQuery(Query originalQuery, ApproximateQuery approximationQuery) {
    }
        this.approximationQuery = approximationQuery;
    public void setContext(SearchContext context) {
import org.apache.lucene.search.IndexSearcher;
            + approximationQuery.toString()
        return approximationQuery;  
    }
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
    }  
        h = 31 * h + approximationQuery.hashCode();
