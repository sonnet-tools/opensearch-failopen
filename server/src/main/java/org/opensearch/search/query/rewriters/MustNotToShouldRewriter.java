        return 175;
            if (!boolQuery.should().isEmpty() && boolQuery.must().isEmpty() && boolQuery.filter().isEmpty()) {
 * This improves performance by transforming negative queries into positive ones.
import org.opensearch.search.query.QueryRewriter;
        // We need LeafReaderContexts to verify single-valued fields (only for must_not rewriting)
                    }
        // Copy should clauses (rewrite nested queries first)
    }
 * compatible open source license.
        }
                if (pointValues != null) {
        }
                    }
            return context.getIndexReader().leaves();
            return true;
                rewritten.minimumShouldMatch(1);
 * {"bool": {"must": [{"bool": {"should": [
        try {
 * This optimization applies to:
                // If we added a must clause due to this rewrite, we should respect the original default.
            rewritten.must(rewrite(mustClause, context));
                // For now, only handle the case where there's exactly 1 complement-aware query per field
            }
                } else {
                }
    }
                // If there were originally should clauses and no must/filter clauses,
        if (!nestedQueriesChanged) {
                    // If complement couldn't be determined, keep original
                } else {
                // Rewrite this clause
import org.opensearch.index.query.WithFieldName;
                        String fieldName = wfn.fieldName();
        }
                    long valueCount = pointValues.size();
    public static final MustNotToShouldRewriter INSTANCE = new MustNotToShouldRewriter();
                    }
            }
                PointValues pointValues = leafReaderContext.reader().getPointValues(fieldName);
                        return false;
        // Copy must clauses (rewrite nested queries first)
            return false;
    private MustNotToShouldRewriter() {
                if (complement != null && !complement.isEmpty()) {
        }
                    // If there are no point values but there are documents, some docs are missing the field
            }
    @Override
        List<LeafReaderContext> leafReaderContexts = null;
    }
    private List<LeafReaderContext> getLeafReaderContexts(QueryShardContext context) {
        // Process must_not clauses
        }
                }
        if (!(query instanceof BoolQueryBuilder boolQuery)) {
        }
        List<QueryBuilder> mustNotClausesToRewrite = new ArrayList<>();
        }
            if (mustClause instanceof BoolQueryBuilder && rewritten.must().contains(mustClause) == false) {
        // Run after boolean flattening (100) and must-to-filter (150)
/*
                    if (clause instanceof ComplementAwareQueryBuilder && clause instanceof WithFieldName wfn) {
                            }
 * SPDX-License-Identifier: Apache-2.0
        if (context == null) {
/**
        }
 * becomes:
                    break;
    private boolean checkAllDocsHaveOneValue(List<LeafReaderContext> leafReaderContexts, String fieldName) {
 * - TermsQueryBuilder (on numeric fields)
 *
                    nestedQueriesChanged = true;
                }
    }
            rewritten.filter(rewrite(filterClause, context));
            leafReaderContexts = getLeafReaderContexts(context);
        try {
        rewritten.minimumShouldMatch(boolQuery.minimumShouldMatch());
                    }
                    // Also check if all documents in the segment have a value for this field
                break;
 * - MatchQueryBuilder (on numeric fields)
 * </pre>
                }
        }
                        }
                    rewritten.must(nestedBoolQuery);
import java.util.Map;
    }
            }
import org.apache.lucene.index.LeafReaderContext;
            }
 * {"bool": {"must_not": [{"range": {"age": {"gte": 18, "lte": 65}}}]}}
package org.opensearch.search.query.rewriters;
                            if (checkAllDocsHaveOneValue(leafReaderContexts, fieldName)) {
        // but before terms merging (200)
                // But if there was originally a must or filter clause, the default is 0.
        boolean changed = false;
        } catch (IOException e) {
        for (QueryBuilder mustClause : boolQuery.must()) {
                List<? extends QueryBuilder> complement = caq.getComplement(context);
        return (changed || nestedQueriesChanged) ? rewritten : query;
            for (QueryBuilder filterClause : boolQuery.filter()) {
                    nestedQueriesChanged = true;
                if (shouldClause instanceof BoolQueryBuilder && rewritten.should().contains(shouldClause) == false) {
                        fieldCounts.merge(wfn.fieldName(), 1, Integer::sum);
        // Only process must_not clauses if they exist
                    changed = true;
    public int priority() {
                    // Check if all documents have exactly one value
        if (!boolQuery.mustNot().isEmpty()) {
import org.opensearch.index.query.QueryShardContext;
                    int maxDoc = leafReaderContext.reader().maxDoc();
                    nestedQueriesChanged = true;
        if (!nestedQueriesChanged) {
        }
                }
 *   {"range": {"age": {"gt": 65}}}
        boolean nestedQueriesChanged = false;
                                mustNotClausesToRewrite.add(clause);
            for (QueryBuilder mustNotClause : boolQuery.mustNot()) {
 */
                    break;
 * ], "minimum_should_match": 1}}]}}
            }
        }
        }
 * - RangeQueryBuilder
                    if (docCount != valueCount) {
                    if (leafReaderContext.reader().maxDoc() > 0) {
                    if (clause instanceof ComplementAwareQueryBuilder && clause instanceof WithFieldName wfn) {
                if (filterClause instanceof BoolQueryBuilder && rewritten.filter().contains(filterClause) == false) {
            return null;
                }
        // Copy filter clauses (rewrite nested queries first)
 * <pre>
 *
                Map<String, Integer> fieldCounts = new HashMap<>();
                    if (docCount != maxDoc) {
    @Override
                    }
            if (mustNotClausesToRewrite.contains(mustNotClause)) {
                // Keep clauses we're not rewriting
            rewritten.should(rewrite(shouldClause, context));
        rewritten.boost(boolQuery.boost());
 * <pre>
                        return false;
    }
                        nestedBoolQuery.should(complementComponent);
                        if (fieldCounts.getOrDefault(fieldName, 0) == 1) {
        if (changed && boolQuery.minimumShouldMatch() == null) {
        rewritten.queryName(boolQuery.queryName());
                    // If some documents are missing the field, we can't do the optimization
 * Rewrites must_not clauses to should clauses when possible.
            return null;
public class MustNotToShouldRewriter implements QueryRewriter {
import org.opensearch.index.query.BoolQueryBuilder;
    @Override
 * For example:
            }
                            // Check that all docs on this field have exactly 1 value
            } else {
 * @opensearch.internal
import java.util.HashMap;
import org.apache.lucene.index.PointValues;
        if (!nestedQueriesChanged) {
        // Singleton
        // Create a new BoolQueryBuilder with rewritten clauses
                    BoolQueryBuilder nestedBoolQuery = new BoolQueryBuilder();
        for (QueryBuilder mustClause : boolQuery.must()) {
                    rewritten.mustNot(mustNotClause);
        // Handle minimumShouldMatch adjustment
            for (QueryBuilder shouldClause : boolQuery.should()) {
 * - TermQueryBuilder (on numeric fields)
import org.opensearch.index.query.QueryBuilder;
        BoolQueryBuilder rewritten = new BoolQueryBuilder();
                // null minimumShouldMatch defaults to 1 in Lucene.
 * this file be licensed under the Apache-2.0 license or a
        for (QueryBuilder shouldClause : boolQuery.should()) {
                    int docCount = pointValues.getDocCount();
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {
import org.opensearch.index.query.ComplementAwareQueryBuilder;
    public String name() {
        // Check if any nested queries were rewritten
 *   {"range": {"age": {"lt": 18}}},
                for (QueryBuilder clause : boolQuery.mustNot()) {
            if (leafReaderContexts != null && !leafReaderContexts.isEmpty()) {
import java.io.IOException;
        }
                for (QueryBuilder clause : boolQuery.mustNot()) {
                ComplementAwareQueryBuilder caq = (ComplementAwareQueryBuilder) mustNotClause;
        for (QueryBuilder filterClause : boolQuery.filter()) {
            for (LeafReaderContext leafReaderContext : leafReaderContexts) {
 * The OpenSearch Contributors require contributions made to
        for (QueryBuilder mustNotClause : boolQuery.mustNot()) {
        return "must_not_to_should";
}
 * </pre>
        }
                nestedQueriesChanged = true;
                // Find complement-aware queries that can be rewritten
                    }
 *
        // Copy all properties
            return query;
 */
        } catch (Exception e) {
                        return false;
                rewritten.mustNot(rewrite(mustNotClause, context));
import java.util.ArrayList;
                    nestedBoolQuery.minimumShouldMatch(1);
                }
        rewritten.adjustPureNegative(boolQuery.adjustPureNegative());
                    // because the semantics change (missing values won't match positive queries)
 *
import java.util.List;
                    break;
            }
                if (mustNotClause instanceof BoolQueryBuilder && rewritten.mustNot().contains(mustNotClause) == false) {
                    for (QueryBuilder complementComponent : complement) {
