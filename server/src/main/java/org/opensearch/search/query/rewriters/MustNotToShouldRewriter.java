 * The OpenSearch Contributors require contributions made to  
                    nestedBoolQuery.minimumShouldMatch(1);
/**
                PointValues pointValues = leafReaderContext.reader().getPointValues(fieldName);  
        }
            return context.getIndexReader().leaves();  
            } else {
        }
 *
/*  
 * @opensearch.internal
import org.opensearch.index.query.QueryBuilder;
            return true;
                    // Also check if all documents in the segment have a value for this field
 * This improves performance by transforming negative queries into positive ones.  
            for (QueryBuilder shouldClause : boolQuery.should()) {  
                } else {  
                if (pointValues != null) {
        rewritten.queryName(boolQuery.queryName());
        }
    @Override  
        } catch (IOException e) {
public class MustNotToShouldRewriter implements QueryRewriter {
            if (mustClause instanceof BoolQueryBuilder && rewritten.must().contains(mustClause) == false) {
        }
                    if (docCount != maxDoc) {  
        } catch (Exception e) {
 * </pre>  
    private MustNotToShouldRewriter() {
            for (QueryBuilder filterClause : boolQuery.filter()) {
package org.opensearch.search.query.rewriters;
        // We need LeafReaderContexts to verify single-valued fields (only for must_not rewriting)  
 * This optimization applies to:
 * - RangeQueryBuilder  
        for (QueryBuilder filterClause : boolQuery.filter()) {  
                rewritten.minimumShouldMatch(1);  
 * <pre>  
                    }
                for (QueryBuilder clause : boolQuery.mustNot()) {
                    changed = true;  
            rewritten.must(rewrite(mustClause, context));
        try {
                    }
 *
                    for (QueryBuilder complementComponent : complement) {
 * becomes:  
        return "must_not_to_should";
 * <pre>
        List<QueryBuilder> mustNotClausesToRewrite = new ArrayList<>();
        // but before terms merging (200)
        // Create a new BoolQueryBuilder with rewritten clauses  
import java.io.IOException;
                // null minimumShouldMatch defaults to 1 in Lucene.  
        // Copy filter clauses (rewrite nested queries first)
    }
        // Copy should clauses (rewrite nested queries first)
        if (!nestedQueriesChanged) {
import org.opensearch.index.query.BoolQueryBuilder;  
    }
        // Process must_not clauses  
                // Keep clauses we're not rewriting  
 *   {"range": {"age": {"gt": 65}}}
                    nestedQueriesChanged = true;  
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
                    break;
                }  
 * - TermsQueryBuilder (on numeric fields)
    public static final MustNotToShouldRewriter INSTANCE = new MustNotToShouldRewriter();  
        if (!(query instanceof BoolQueryBuilder boolQuery)) {
    }
import org.opensearch.index.query.ComplementAwareQueryBuilder;
                    }
import org.opensearch.index.query.QueryShardContext;  
                    break;
                    if (leafReaderContext.reader().maxDoc() > 0) {
                    nestedQueriesChanged = true;
                    if (docCount != valueCount) {
import org.opensearch.search.query.QueryRewriter;
                if (shouldClause instanceof BoolQueryBuilder && rewritten.should().contains(shouldClause) == false) {
                        }  
                        return false;  
            }
    private boolean checkAllDocsHaveOneValue(List<LeafReaderContext> leafReaderContexts, String fieldName) {  
                                mustNotClausesToRewrite.add(clause);
        rewritten.minimumShouldMatch(boolQuery.minimumShouldMatch());  
import java.util.List;
    }
        for (QueryBuilder mustNotClause : boolQuery.mustNot()) {
                for (QueryBuilder clause : boolQuery.mustNot()) {  
 * For example:
                    break;  
import org.apache.lucene.index.PointValues;
        }  
 */  
            rewritten.filter(rewrite(filterClause, context));
    public int priority() {
                }
 * Rewrites must_not clauses to should clauses when possible.
            if (!boolQuery.should().isEmpty() && boolQuery.must().isEmpty() && boolQuery.filter().isEmpty()) {
import org.opensearch.index.query.WithFieldName;
                Map<String, Integer> fieldCounts = new HashMap<>();
                    // because the semantics change (missing values won't match positive queries)
                } else {
        for (QueryBuilder mustClause : boolQuery.must()) {  
        BoolQueryBuilder rewritten = new BoolQueryBuilder();
                        return false;
            rewritten.should(rewrite(shouldClause, context));  
            return null;
    @Override
                if (complement != null && !complement.isEmpty()) {
        try {
 * ], "minimum_should_match": 1}}]}}
        return (changed || nestedQueriesChanged) ? rewritten : query;
            }
 *   {"range": {"age": {"lt": 18}}},  
                        return false;  
        for (QueryBuilder shouldClause : boolQuery.should()) {
        for (QueryBuilder mustClause : boolQuery.must()) {
                    int docCount = pointValues.getDocCount();
                    rewritten.mustNot(mustNotClause);  
 * {"bool": {"must_not": [{"range": {"age": {"gte": 18, "lte": 65}}}]}}
import java.util.Map;
}  
                    long valueCount = pointValues.size();  
                }
            }  
        boolean changed = false;
                    // Check if all documents have exactly one value
            return query;  
        rewritten.adjustPureNegative(boolQuery.adjustPureNegative());
        }
            }
        // Handle minimumShouldMatch adjustment
                }  
                // But if there was originally a must or filter clause, the default is 0.
 * </pre>
                // Find complement-aware queries that can be rewritten
        }
    }  
 * - MatchQueryBuilder (on numeric fields)  
                    // If complement couldn't be determined, keep original
        // Singleton  
 * - TermQueryBuilder (on numeric fields)
 * compatible open source license.
        rewritten.boost(boolQuery.boost());
                    nestedQueriesChanged = true;
                    rewritten.must(nestedBoolQuery);
        return 175;
        // Only process must_not clauses if they exist
            }  
        boolean nestedQueriesChanged = false;
 */  
                List<? extends QueryBuilder> complement = caq.getComplement(context);  
        }
                            }
    public String name() {  
        if (!boolQuery.mustNot().isEmpty()) {
        }
                        String fieldName = wfn.fieldName();
        if (context == null) {
                rewritten.mustNot(rewrite(mustNotClause, context));
            leafReaderContexts = getLeafReaderContexts(context);  
                    // If there are no point values but there are documents, some docs are missing the field
                break;  
                    BoolQueryBuilder nestedBoolQuery = new BoolQueryBuilder();  
        if (!nestedQueriesChanged) {  
                // For now, only handle the case where there's exactly 1 complement-aware query per field
 *
                    }
        if (!nestedQueriesChanged) {
import java.util.HashMap;  
                            if (checkAllDocsHaveOneValue(leafReaderContexts, fieldName)) {  
                    }
                // If there were originally should clauses and no must/filter clauses,
import java.util.ArrayList;
            return null;  
        List<LeafReaderContext> leafReaderContexts = null;
                    int maxDoc = leafReaderContext.reader().maxDoc();
    @Override
    private List<LeafReaderContext> getLeafReaderContexts(QueryShardContext context) {
            }  
            for (QueryBuilder mustNotClause : boolQuery.mustNot()) {
        }
            for (LeafReaderContext leafReaderContext : leafReaderContexts) {
            return false;  
                        if (fieldCounts.getOrDefault(fieldName, 0) == 1) {
                nestedQueriesChanged = true;
                }
        // Copy must clauses (rewrite nested queries first)  
                    // If some documents are missing the field, we can't do the optimization  
 * {"bool": {"must": [{"bool": {"should": [
    }
        // Run after boolean flattening (100) and must-to-filter (150)  
import org.apache.lucene.index.LeafReaderContext;
        if (changed && boolQuery.minimumShouldMatch() == null) {  
                }
                            // Check that all docs on this field have exactly 1 value
            if (mustNotClausesToRewrite.contains(mustNotClause)) {  
                    if (clause instanceof ComplementAwareQueryBuilder && clause instanceof WithFieldName wfn) {
 * SPDX-License-Identifier: Apache-2.0
                if (mustNotClause instanceof BoolQueryBuilder && rewritten.mustNot().contains(mustNotClause) == false) {  
        }
            }
                    if (clause instanceof ComplementAwareQueryBuilder && clause instanceof WithFieldName wfn) {  
        }  
 *
                // Rewrite this clause
 * this file be licensed under the Apache-2.0 license or a
                    }
        }  
                        fieldCounts.merge(wfn.fieldName(), 1, Integer::sum);
            if (leafReaderContexts != null && !leafReaderContexts.isEmpty()) {
        // Check if any nested queries were rewritten
        }  
            }
                }
                ComplementAwareQueryBuilder caq = (ComplementAwareQueryBuilder) mustNotClause;
                // If we added a must clause due to this rewrite, we should respect the original default.
        // Copy all properties  
                if (filterClause instanceof BoolQueryBuilder && rewritten.filter().contains(filterClause) == false) {
                        nestedBoolQuery.should(complementComponent);  
