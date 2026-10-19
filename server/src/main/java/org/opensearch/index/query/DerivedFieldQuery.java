 * compatible open source license.
    private final SearchLookup searchLookup;  
        if (this == o) {
            indexableFieldGenerator,
                        MemoryIndex memoryIndex = new MemoryIndex();
        if (query instanceof PointRangeQuery) {
                            memoryIndex.addField(indexableField, indexAnalyzer);
                                return false;
import org.opensearch.search.approximate.ApproximateScoreQuery;
 */
import org.apache.lucene.search.Scorer;
package org.opensearch.index.query;
        Function<Object, IndexableField> indexableFieldGenerator,
        }  
import java.util.Objects;
        return true;
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
                        }
import org.apache.lucene.analysis.Analyzer;
                            }
            }
                return false;
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        }
import org.apache.lucene.search.ConstantScoreScorer;
    public String toString(String f) {  
        this.indexableFieldGenerator = indexableFieldGenerator;
    }
import java.util.function.Function;
        if (query instanceof ApproximateScoreQuery approximateQuery) {  
                    }
import org.opensearch.search.lookup.LeafSearchLookup;
    private final Query query;
    private final Function<Object, IndexableField> indexableFieldGenerator;
        this.valueFetcherSupplier = valueFetcherSupplier;
import org.apache.lucene.search.TwoPhaseIterator;
                DocIdSetIterator approximation;
            return true;  
                Query indexQuery = indexOrDocValuesQuery.getIndexQuery();  
 */  
import java.util.List;  
        Query rewritten = query.rewrite(indexSearcher);
import org.apache.lucene.search.IndexSearcher;  
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {  
        boolean ignoreMalformed
                        try {  
                        return 1000f;
    public int hashCode() {
 * The OpenSearch Contributors require contributions made to  
    private final boolean ignoreMalformed;
    @Override  
            return false;  
                approximation = DocIdSetIterator.all(context.reader().maxDoc());
            ignoreMalformed  
            }
                            indexableFields = valueFetcher.getIndexableField(leafSearchLookup.source(), indexableFieldGenerator);
                        } catch (Exception e) {
                    @Override
public final class DerivedFieldQuery extends Query {  
                // Create a new ValueFetcher per thread.
import org.opensearch.search.lookup.SearchLookup;  
            return this;
    private final Analyzer indexAnalyzer;
                return new DefaultScorerSupplier(scorer);
import org.apache.lucene.index.IndexableField;
            @Override
import java.util.function.Supplier;  
/**
import org.apache.lucene.search.QueryVisitor;  
        }
    private boolean needsRewrite() {
 * this file be licensed under the Apache-2.0 license or a
     */
                        }
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Weight;
                };  
import org.apache.lucene.search.PointRangeQuery;
    @Override  
        Analyzer indexAnalyzer,  
        return new DerivedFieldQuery(  
                            if (ignoreMalformed) {  
        if (query instanceof IndexOrDocValuesQuery indexOrDocValuesQuery) {
                return !(indexQuery instanceof PointRangeQuery);
import org.apache.lucene.search.ScorerSupplier;  
            return false;  
import org.apache.lucene.search.IndexOrDocValuesQuery;
            Query originalQuery = approximateQuery.getOriginalQuery();
     * @param query lucene query to be executed against the derived field
                TwoPhaseIterator twoPhase = new TwoPhaseIterator(approximation) {
     * @param searchLookup SearchLookup to get the LeafSearchLookup look used by valueFetcher to fetch the _source  
import org.apache.lucene.index.memory.MemoryIndex;
        DerivedFieldQuery other = (DerivedFieldQuery) o;
    ) {  
        ;
        return Objects.hash(classHash(), query, indexAnalyzer);
import org.apache.lucene.search.ScoreMode;
    }
                final DerivedFieldValueFetcher valueFetcher = valueFetcherSupplier.get();
import java.io.IOException;
                        return score > 0.0f;
        return new ConstantScoreWeight(this, boost) {
                            throw e;  
    @Override  
        );
    }  
            rewritten,
        }
        this.searchLookup = searchLookup;  
    }
                        float score = memoryIndex.search(query);  
                        for (IndexableField indexableField : indexableFields) {  
                    }
            if (originalQuery instanceof IndexOrDocValuesQuery indexOrDocValuesQuery) {
}  
    public void visit(QueryVisitor visitor) {
    }  
import org.apache.lucene.search.DocIdSetIterator;
    @Override
        Supplier<DerivedFieldValueFetcher> valueFetcherSupplier,
            valueFetcherSupplier,
        query.visit(visitor);
                // thread safe.  
            indexAnalyzer,
 * SPDX-License-Identifier: Apache-2.0
        if (!needsRewrite()) {
 * DerivedFieldQuery used for querying derived fields. It contains the logic to execute an input lucene query against  
        }  
        this.ignoreMalformed = ignoreMalformed;  
    @Override
            }  
    public DerivedFieldQuery(
 * DerivedField. It also accepts DerivedFieldValueFetcher and SearchLookup as an input.
    }
                    public boolean matches() {  
        SearchLookup searchLookup,
    private final Supplier<DerivedFieldValueFetcher> valueFetcherSupplier;
                        leafSearchLookup.source().setSegmentAndDocument(context, approximation.docID());
                    @Override
                valueFetcher.setNextReader(context);
        return Objects.equals(this.query, other.query) && Objects.equals(this.indexAnalyzer, other.indexAnalyzer);  
                LeafSearchLookup leafSearchLookup = searchLookup.getLeafSearchLookup(context);  
import org.apache.lucene.index.LeafReaderContext;  
        this.query = query;
        };  
        if (sameClassAs(o) == false) {
    /**  
                // ValueFetcher.setNextReader creates a DerivedFieldScript and internally SourceLookup and these objects are not
        return "DerivedFieldQuery (Query: [ " + query.toString(f) + "])";
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, twoPhase);
     * @param valueFetcherSupplier Supplier of a DerivedFieldValueFetcher that will be reconstructed per leaf
import org.opensearch.index.mapper.DerivedFieldValueFetcher;  
        }
            public boolean isCacheable(LeafReaderContext ctx) {  
        this.indexAnalyzer = indexAnalyzer;
            @Override
    @Override
import org.apache.lucene.search.ConstantScoreWeight;  
            searchLookup,  
                        // TODO: how can we compute this?  
        }
    }
                    public float matchCost() {
 *
            return this;  
                        List<IndexableField> indexableFields;
/*  
            Query indexQuery = indexOrDocValuesQuery.getIndexQuery();  
    public boolean equals(Object o) {
        Query query,  
    }
            return !(indexQuery instanceof PointRangeQuery);
        if (rewritten == query) {
