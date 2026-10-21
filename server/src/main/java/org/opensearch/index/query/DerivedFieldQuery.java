        Supplier<DerivedFieldValueFetcher> valueFetcherSupplier,
                            }
    }
                        for (IndexableField indexableField : indexableFields) {
    public DerivedFieldQuery(
        }
import org.opensearch.search.lookup.LeafSearchLookup;
    private final Supplier<DerivedFieldValueFetcher> valueFetcherSupplier;
            indexableFieldGenerator,
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        return Objects.equals(this.query, other.query) && Objects.equals(this.indexAnalyzer, other.indexAnalyzer);
                        }
    public boolean equals(Object o) {
        );
        if (!needsRewrite()) {
        Function<Object, IndexableField> indexableFieldGenerator,
import org.apache.lucene.search.PointRangeQuery;
            indexAnalyzer,
                        MemoryIndex memoryIndex = new MemoryIndex();
import org.apache.lucene.index.IndexableField;
            valueFetcherSupplier,
            if (originalQuery instanceof IndexOrDocValuesQuery indexOrDocValuesQuery) {
                            throw e;
                // thread safe.
                    }
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.IndexOrDocValuesQuery;
        if (sameClassAs(o) == false) {
        this.searchLookup = searchLookup;
import org.opensearch.search.lookup.SearchLookup;
                        leafSearchLookup.source().setSegmentAndDocument(context, approximation.docID());
    @Override
            Query indexQuery = indexOrDocValuesQuery.getIndexQuery();
                    @Override
     */
    @Override
            return this;
        }
    private final SearchLookup searchLookup;
    }
/**
        if (query instanceof ApproximateScoreQuery approximateQuery) {
    @Override
                        float score = memoryIndex.search(query);
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
                        return score > 0.0f;
    @Override
    ) {
                    @Override
        };
import org.apache.lucene.search.TwoPhaseIterator;
                            if (ignoreMalformed) {
    public String toString(String f) {
    }
            public boolean isCacheable(LeafReaderContext ctx) {
/*
        }
        return new ConstantScoreWeight(this, boost) {
        return new DerivedFieldQuery(
    }
                // ValueFetcher.setNextReader creates a DerivedFieldScript and internally SourceLookup and these objects are not
                            memoryIndex.addField(indexableField, indexAnalyzer);
 * compatible open source license.
                    public boolean matches() {
                LeafSearchLookup leafSearchLookup = searchLookup.getLeafSearchLookup(context);
            }
                DocIdSetIterator approximation;
package org.opensearch.index.query;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.Weight;
    private final Analyzer indexAnalyzer;
import org.apache.lucene.search.QueryVisitor;
        Analyzer indexAnalyzer,
     * @param searchLookup SearchLookup to get the LeafSearchLookup look used by valueFetcher to fetch the _source
                        }
 */
import java.io.IOException;
        }
    }
                        // TODO: how can we compute this?
        }
                        try {
 * DerivedFieldQuery used for querying derived fields. It contains the logic to execute an input lucene query against
import java.util.List;
            return true;
        this.ignoreMalformed = ignoreMalformed;
        if (query instanceof IndexOrDocValuesQuery indexOrDocValuesQuery) {
        this.query = query;
            }
        }
            return false;
        DerivedFieldQuery other = (DerivedFieldQuery) o;
    /**
import org.apache.lucene.search.ConstantScoreWeight;
import org.apache.lucene.analysis.Analyzer;
    private boolean needsRewrite() {
                TwoPhaseIterator twoPhase = new TwoPhaseIterator(approximation) {
        SearchLookup searchLookup,
            return this;
        if (rewritten == query) {
import java.util.function.Supplier;
    public int hashCode() {
    }
import org.apache.lucene.index.LeafReaderContext;
        boolean ignoreMalformed
                        List<IndexableField> indexableFields;
    public void visit(QueryVisitor visitor) {
import org.apache.lucene.search.DocIdSetIterator;
                valueFetcher.setNextReader(context);
                return new DefaultScorerSupplier(scorer);
                // Create a new ValueFetcher per thread.
                    }
    private final boolean ignoreMalformed;
            Query originalQuery = approximateQuery.getOriginalQuery();
 * DerivedField. It also accepts DerivedFieldValueFetcher and SearchLookup as an input.
                Query indexQuery = indexOrDocValuesQuery.getIndexQuery();
            rewritten,
 * The OpenSearch Contributors require contributions made to
                        } catch (Exception e) {
import org.apache.lucene.search.ScorerSupplier;
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
import org.apache.lucene.search.ConstantScoreScorer;
            @Override
        ;
                return !(indexQuery instanceof PointRangeQuery);
    private final Query query;
                };
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.approximate.ApproximateScoreQuery;
     * @param valueFetcherSupplier Supplier of a DerivedFieldValueFetcher that will be reconstructed per leaf
        if (query instanceof PointRangeQuery) {
    private final Function<Object, IndexableField> indexableFieldGenerator;
        query.visit(visitor);
                return false;
            @Override
                approximation = DocIdSetIterator.all(context.reader().maxDoc());
     * @param query lucene query to be executed against the derived field
                    public float matchCost() {
        return "DerivedFieldQuery (Query: [ " + query.toString(f) + "])";
    }
    }
                        return 1000f;
            return !(indexQuery instanceof PointRangeQuery);
import java.util.function.Function;
}
 */
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, twoPhase);
            ignoreMalformed
        if (this == o) {
    @Override
            return false;
import org.apache.lucene.search.Query;
        return true;
        }
            }
import org.apache.lucene.index.memory.MemoryIndex;
                                return false;
        this.indexAnalyzer = indexAnalyzer;
 *
            searchLookup,
        Query query,
                final DerivedFieldValueFetcher valueFetcher = valueFetcherSupplier.get();
        this.valueFetcherSupplier = valueFetcherSupplier;
public final class DerivedFieldQuery extends Query {
    @Override
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
        this.indexableFieldGenerator = indexableFieldGenerator;
        Query rewritten = query.rewrite(indexSearcher);
import org.opensearch.index.mapper.DerivedFieldValueFetcher;
                            indexableFields = valueFetcher.getIndexableField(leafSearchLookup.source(), indexableFieldGenerator);
        return Objects.hash(classHash(), query, indexAnalyzer);
