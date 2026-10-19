        }
package org.opensearch.search.query.rewriters;
import java.util.ArrayList;
 * compatible open source license.
    }
                mustClausesToMove.add(rewrittenClause);  
    public String name() {
 * The OpenSearch Contributors require contributions made to  
 */
 */  
        }
/**
        for (int i = 0; i < boolQuery.must().size(); i++) {  
        // First, rewrite all clauses recursively  
        List<QueryBuilder> rewrittenMustClauses = new ArrayList<>();
            if (boolQuery.must().get(i) != rewrittenMustClauses.get(i)) {
    public static final MustToFilterRewriter INSTANCE = new MustToFilterRewriter();
            return query;  
        // Run after boolean flattening (100) but before terms merging (200)  
 * <pre>
 *   {"term": {"status": "active"}}
 * }}  
    @Override
/*  
import org.opensearch.index.query.TermQueryBuilder;  
        return rewritten;  
        }
            }
        if (clause instanceof RangeQueryBuilder) return true;
 * ]}}
        BoolQueryBuilder rewritten = new BoolQueryBuilder();  
            rewritten.should(rewriteIfNeeded(shouldClause, context));  
import org.opensearch.index.mapper.MappedFieldType;
 * This improves performance by avoiding unnecessary scoring calculations.
        for (QueryBuilder filterClause : boolQuery.filter()) {  
        return query;
        return false;
        if (clause instanceof GeoBoundingBoxQueryBuilder) return true;
        List<QueryBuilder> mustClausesToMove = new ArrayList<>();
        for (QueryBuilder movedClause : mustClausesToMove) {
        if (clause instanceof MatchQueryBuilder) return true;  
        return 150;
        if (query instanceof BoolQueryBuilder boolQueryBuilder) {
 * this file be licensed under the Apache-2.0 license or a
        // Copy should and mustNot clauses
            QueryBuilder rewrittenClause = rewriteIfNeeded(clause, context);
 *   "must": [{"term": {"status": "active"}}]
 * becomes:
            }
        // Singleton
        if (!(clause instanceof WithFieldName wfn)) return false;
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.index.query.GeoBoundingBoxQueryBuilder;
import org.opensearch.index.query.WithFieldName;
        if (boolQuery.must().isEmpty()) {
import org.opensearch.index.query.BoolQueryBuilder;  
    }  
 * <pre>
            return query;
        }  
        }
 *   "filter": [{"range": {"date": {"gte": "2024-01-01"}}}],
        // it'll be the same for all returned docs  
        // Recursively rewrite nested boolean queries
        if (!hasChanges) {
    private boolean isClauseIrrelevantToScoring(QueryBuilder clause, QueryShardContext context) {
        for (QueryBuilder shouldClause : boolQuery.should()) {
                break;  
        if (!(query instanceof BoolQueryBuilder boolQuery)) {  
        rewritten.minimumShouldMatch(boolQuery.minimumShouldMatch());
        // Create a new BoolQueryBuilder with moved clauses
    private QueryBuilder rewriteIfNeeded(QueryBuilder query, QueryShardContext context) {  
        if (context == null) return false;  
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.index.mapper.NumberFieldMapper;
        boolean hasChanges = !mustClausesToMove.isEmpty();
        if (clause instanceof TermQueryBuilder) return true;
            if (!mustClausesToMove.contains(rewrittenClause)) {
            return query;
            return rewrite(boolQueryBuilder, context);  
        // Check if anything changed - either clauses to move or nested rewrites
import org.opensearch.index.query.RangeQueryBuilder;
            rewritten.filter(movedClause);
            if (isClauseIrrelevantToScoring(rewrittenClause, context)) {
 * </pre>  
    public int priority() {
        // Copy existing filter clauses
    private MustToFilterRewriter() {  
        // Copy all properties
        // Numeric field queries have constant scores
        rewritten.queryName(boolQuery.queryName());
    @Override
        if (clause instanceof TermsQueryBuilder) return true;
        for (QueryBuilder clause : boolQuery.must()) {
            rewritten.filter(rewriteIfNeeded(filterClause, context));
        return "must_to_filter";  
                rewritten.must(rewrittenClause);
        MappedFieldType fieldType = context.fieldMapper(wfn.fieldName());
        if (!(fieldType instanceof NumberFieldMapper.NumberFieldType)) return false;  
 *
    }
                hasChanges = true;
            rewritten.mustNot(rewriteIfNeeded(mustNotClause, context));  
        for (QueryBuilder mustNotClause : boolQuery.mustNot()) {
        }  
    }
        // If there are no must clauses, nothing to rewrite
    }
        rewritten.adjustPureNegative(boolQuery.adjustPureNegative());  
        // Further optimizations depend on knowing whether the field is numeric.
            rewrittenMustClauses.add(rewrittenClause);  
 * {"bool": {  
import org.opensearch.search.query.QueryRewriter;  
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
        }
        // Add the moved clauses to filter  
        rewritten.boost(boolQuery.boost());  
}
            }  
    @Override
 *   {"range": {"date": {"gte": "2024-01-01"}}},  
 * {"bool": {"must": [
import org.opensearch.index.query.TermsQueryBuilder;
 *
        }
import org.opensearch.index.query.MatchQueryBuilder;
        // Skip moving these clauses if we don't have the shard context.
 * </pre>
        for (QueryBuilder rewrittenClause : rewrittenMustClauses) {  
 *
 * SPDX-License-Identifier: Apache-2.0
 * For example:  
import java.util.List;  
public class MustToFilterRewriter implements QueryRewriter {
        }
        // Copy must clauses except the ones we're moving
        }
 * @opensearch.internal  
        // If a clause is purely numeric, for example a date range, its score is unimportant as
 * Rewrites must clauses to filter clauses when they don't affect scoring.  
        // This is an incomplete list of clauses this might apply for; it can be expanded in future.  
    }
        }
