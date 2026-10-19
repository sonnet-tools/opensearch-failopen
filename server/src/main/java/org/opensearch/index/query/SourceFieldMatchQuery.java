            && Objects.equals(this.fieldType, other.fieldType)  
                "SourceFieldMatchQuery error: unable to fetch fields from _source field: _source is disabled in the mappings "  
            return false;
 *
                        return 1000f;
        };
import org.apache.lucene.search.QueryVisitor;
public class SourceFieldMatchQuery extends Query {  
import org.apache.lucene.search.Scorer;
        this.filter = filter;  
                    @Override  
                            return false;  
        }
            return this;  
        return "SourceFieldMatchQuery (delegate query: [ " + delegateQuery.toString(f) + " ], filter query: [ " + filter.toString(f) + "])";
        if (sameClassAs(o) == false) {  
        }
                // It is fine to cache if delegate query weight is cacheable since additional logic here  
 */
        }
                    + "]"  
        delegateQuery.visit(visitor);
            @Override
    private final Query filter;
        this.valueFetcher = (SourceValueFetcher) fieldType.valueFetcher(context, lookup, null);  
                    public boolean matches() {
            return true;
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
     * Constructs a SourceFieldMatchQuery.  
                Scorer scorer = weight.scorer(context);  
            && Objects.equals(this.context, other.context);
                TwoPhaseIterator twoPhase = new TwoPhaseIterator(approximation) {
 * A query that matches against each document from the parent query by filtering using the source field values.  
    @Override
                            memoryIndex.addField(fieldType.name(), (String) value, fieldType.indexAnalyzer());
    private final MappedFieldType fieldType;
                    // none of the docs are matching
     *
    }  
import org.apache.lucene.search.ScoreMode;  
                DocIdSetIterator approximation = scorer.iterator();
 * compatible open source license.
            }  
    private final QueryShardContext context;  
}
        this.lookup = context.lookup();  
    @Override  
    @Override
        this.delegateQuery = delegateQuery;
    private final SearchLookup lookup;  
import org.apache.lucene.search.ConstantScoreWeight;
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
            @Override  
                        }
                    public float matchCost() {
    public boolean equals(Object o) {
    @Override
        return Objects.equals(this.delegateQuery, other.delegateQuery)
                }
     * @param context The QueryShardContext to get lookup and valueFetcher
 * this file be licensed under the Apache-2.0 license or a
                return new DefaultScorerSupplier(new ConstantScoreScorer(score(), ScoreMode.TOP_DOCS, twoPhase));
        if (rewritten == delegateQuery) {
import org.opensearch.index.mapper.MappedFieldType;
                        if (values.isEmpty()) {
                    }
 * The OpenSearch Contributors require contributions made to  
                if (scorer == null) {
import org.opensearch.search.lookup.LeafSearchLookup;
    @Override
                        float score = memoryIndex.search(filter);  
import java.util.List;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.TwoPhaseIterator;  
    public String toString(String f) {
            }
        return new ConstantScoreWeight(this, boost) {
        this.fieldType = fieldType;
                };  
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.Weight;
import org.opensearch.index.mapper.SourceValueFetcher;  
                    + "for index ["
            );
    }  
                    + context.index().getName()
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {  
import org.opensearch.search.lookup.SearchLookup;
        if (!context.documentMapper("").sourceMapper().enabled()) {
        return Objects.hash(classHash(), delegateQuery, filter, fieldType, context);  
        Query rewritten = delegateQuery.rewrite(indexSearcher);
 * Useful to query against field type which doesn't store positional data and field is not stored/computed dynamically.
import java.util.Objects;  
/*  
     * @param filter The query used to filter further by running against field value fetched using _source field.  
                        for (Object value : values) {  
                        // Missing fields won't count as match. Can we use a default value for missing field?
                        MemoryIndex memoryIndex = new MemoryIndex();
    /**
        this.context = context;
     * @param fieldType The mapped field type.
                        // arbitrary cost  
    }
    private final SourceValueFetcher valueFetcher;
                LeafSearchLookup leafSearchLookup = lookup.getLeafSearchLookup(context);  
import org.apache.lucene.search.IndexSearcher;  
    @Override  
        if (this == o) {  
                return weight.isCacheable(ctx);
                    @Override
            public boolean isCacheable(LeafReaderContext ctx) {
                // is just a filter on top of delegate query matches
     * @param delegateQuery The parent query to use to find matches.
    public int hashCode() {
                        List<Object> values = valueFetcher.fetchValues(leafSearchLookup.source());  
import org.apache.lucene.search.Query;
        return new SourceFieldMatchQuery(rewritten, filter, fieldType, context);
import org.apache.lucene.index.memory.MemoryIndex;
    }
 * SPDX-License-Identifier: Apache-2.0
     */  
                        }
            throw new IllegalArgumentException(
                    return null;  
 */  
                        leafSearchLookup.setDocument(approximation.docID());
    }  
package org.opensearch.index.query;
        }
import java.io.IOException;
    }
    public SourceFieldMatchQuery(Query delegateQuery, Query filter, MappedFieldType fieldType, QueryShardContext context) {
                    }
        Weight weight = delegateQuery.createWeight(searcher, ScoreMode.TOP_DOCS, boost);
                        return score > 0.0f;
import org.apache.lucene.search.ScorerSupplier;
    }
        SourceFieldMatchQuery other = (SourceFieldMatchQuery) o;  
import org.apache.lucene.search.ConstantScoreScorer;  
/**
            && Objects.equals(this.filter, other.filter)
    public void visit(QueryVisitor visitor) {
    private final Query delegateQuery;
