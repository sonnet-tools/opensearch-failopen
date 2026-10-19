        public float getMaxScore(int upTo) throws IOException {  
    public void visit(QueryVisitor visitor) {
                        @Override
import org.apache.lucene.search.BooleanClause.Occur;
 * software distributed under the License is distributed on an
    @Override
    }  
    private final List<BytesReference> documents;
 * You may obtain a copy of the License at  
    public Query rewrite(IndexSearcher searcher) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
    private final QueryStore queryStore;
    // Note that in theory if the same instance gets used multiple times it could still get cached,  
            }
                    return new DefaultScorerSupplier(new BaseScorer(this, approximation) {  
        Query rewritten = candidateMatchesQuery.rewrite(searcher);
    }  
                            return 0f;
                        boolean matchDocId(int docId) throws IOException {
 */
                            return score;  
            }
        this.verifiedMatchesQuery = Objects.requireNonNull(verifiedMatchesQuery);
                            // we were able to extract all query terms and for this candidate match
        }
                }
    }
        this.percolatorIndexSearcher = Objects.requireNonNull(percolatorIndexSearcher);  
 *  
        Query verifiedMatchesQuery  
                    ScorerSupplier verifiedDocsScorer = verifiedMatchesWeight.scorerSupplier(leafReaderContext);
 * Licensed to Elasticsearch under one or more contributor  
                Scorer scorer = scorer(leafReaderContext);
                                Explanation detail = percolatorIndexSearcher.explain(query, 0);
 * the Apache License, Version 2.0 (the "License"); you may
    // however since we create a new query instance each time we this query this shouldn't happen and thus
import org.apache.lucene.util.Bits;
            return new PercolateQuery(  
                            if (query == null) {
        if (rewritten != candidateMatchesQuery) {
        return name;  
                                return Explanation.match(scorer.score(), "PercolateQuery");
                                query = new BooleanQuery.Builder().add(query, Occur.MUST).add(nonNestedDocsFilter, Occur.FILTER).build();  
 * under the License.  
        }  
        return percolatorIndexSearcher;
                            Query query = percolatorQueries.apply(docId);  
        public final int docID() {
            };
                }
            public boolean isCacheable(LeafReaderContext ctx) {  
        @Override
                final Scorer approximation = candidateMatchesWeight.scorer(leafReaderContext);
                documents,  
 * The OpenSearch Contributors require contributions made to  
                }
                            } else {  
            sources.append('\n');
                return false;  
            sources.append(document.utf8ToString());  
        }
import org.apache.lucene.search.DocIdSetIterator;
            @Override
import org.apache.lucene.search.Weight;
                @Override  
                        if (twoPhaseIterator.matches()) {  
 * GitHub history for details.
        }
    }
                            } else {
    public boolean equals(Object o) {
            return Float.MAX_VALUE;
                                    return false;  
        @Override
 * ownership. Elasticsearch licenses this file to you under  
        return ramUsed;  
                                        .build();
    private final String name;  
                                return false;  
/*  
        long ramUsed = 0L;
    @Override
                                if (nonNestedDocsFilter != null) {
    }
                                CheckedFunction<Integer, Query, IOException> percolatorQueries = queryStore.getQueries(leafReaderContext);
                        public float score() throws IOException {  
        return verifiedMatchesQuery;  
                return Explanation.noMatch("PercolateQuery");  
                    }
    boolean excludesNestedDocs() {
    @Override  
        };
    }  
                                } else {
                            return Lucene.exists(percolatorIndexSearcher, query);
                public boolean matches() throws IOException {
    QueryStore getQueryStore() {  
        return new Weight(this) {  
        for (BytesReference document : documents) {
    }  
 * KIND, either express or implied.  See the License for the
                        boolean matchDocId(int docId) throws IOException {
                                    query = new BooleanQuery.Builder().add(query, Occur.MUST)  
    }  
        for (BytesReference document : documents) {  
                                TopDocs topDocs = percolatorIndexSearcher.search(query, 1);
    List<BytesReference> getDocuments() {
    }  
    @Override  
                // This query uses a significant amount of memory, let's never
        List<BytesReference> documents,
    interface QueryStore {
import org.apache.lucene.search.TopDocs;  
 * specific language governing permissions and limitations
                            // We use the verifiedDocsBits to skip the expensive MemoryIndex verification.
import org.apache.lucene.index.LeafReaderContext;
                            if (verifiedDocsBits.get(docId)) {
                            Query query = percolatorQueries.apply(docId);
    }
    // Computing hashcode based on identity to avoid caching.
            public Explanation explain(LeafReaderContext leafReaderContext, int docId) throws IOException {  
                percolatorIndexSearcher,
        return documents;  
                queryStore,
import java.util.Objects;
    private final Query verifiedMatchesQuery;
        visitor.visitLeaf(this);
        }
            @Override  
 * compatible open source license.
                    });
                @Override
import org.opensearch.common.CheckedFunction;
                                return true;
            this.approximation = approximation;
    abstract static class BaseScorer extends Scorer {
import org.apache.lucene.util.Accountable;  
    // cost of matching the query against the document, arbitrary as it would be really complex to estimate  
                }
    public long ramBytesUsed() {
        return System.identityHashCode(this);
    @Override  
 */  
                    if (result == docId) {
                    return matchDocId(approximation.docID());  
        this.nonNestedDocsFilter = nonNestedDocsFilter;
    }
                        public float score() throws IOException {
        public final TwoPhaseIterator twoPhaseIterator() {
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
        return candidateMatchesQuery;
import org.apache.lucene.search.TwoPhaseIterator;
                            if (scoreMode.needsScores()) {
import org.apache.lucene.search.ScoreMode;  
 * license agreements. See the NOTICE file distributed with
 *
            @Override
                                }  
        }
    String getName() {
 */  
    }  
                if (scoreMode.needsScores()) {
        return nonNestedDocsFilter != null;
                            }  
                                        .add(nonNestedDocsFilter, Occur.FILTER)
    @Override
        }
    }
    public int hashCode() {
            super();
    PercolateQuery(
                // cache it or compound queries that wrap it.
        String name,  
    private final Query nonNestedDocsFilter;  
                            if (nonNestedDocsFilter != null) {
            ramUsed += document.ramBytesUsed();
        final Scorer approximation;
                    return MATCH_COST;
                                if (topDocs.scoreDocs.length > 0) {
        this.documents = Objects.requireNonNull(documents);  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String toString(String s) {  
        this.name = name;
import org.apache.lucene.search.Explanation;
                            // If docId also appears in the verifiedDocsBits then that means during indexing  
                    TwoPhaseIterator twoPhaseIterator = scorer.twoPhaseIterator();  
                        }  
        @Override
 * not use this file except in compliance with the License.
            return TwoPhaseIterator.asDocIdSetIterator(twoPhaseIterator());
        Query nonNestedDocsFilter,
                        }
        @Override
                                return false;  
                if (approximation == null) {  
                name,
    Query getCandidateMatchesQuery() {
            return this;
        QueryStore queryStore,
import org.apache.lucene.search.ScorerSupplier;
                        }  
 *
    }  
import org.apache.lucene.search.Query;
                    });
                        @Override
        this.queryStore = Objects.requireNonNull(queryStore);
                verifiedMatchesQuery
    private final IndexSearcher percolatorIndexSearcher;
                            }
            }  
        CheckedFunction<Integer, Query, IOException> getQueries(LeafReaderContext ctx) throws IOException;
import org.apache.lucene.search.QueryVisitor;
import java.io.IOException;  
/*
        return "PercolateQuery{document_sources={" + sources + "},inner={" + candidateMatchesQuery.toString(s) + "}}";  
        return this == o;
                            // the MemoryIndex verification.  
                } else {  
        BaseScorer(Weight weight, Scorer approximation) {  
                        }
final class PercolateQuery extends Query implements Accountable {
                    return new DefaultScorerSupplier(new BaseScorer(this, approximation) {  
    }  
                    int result = twoPhaseIterator.approximation().advance(docId);
    }
import org.apache.lucene.search.Scorer;
                nonNestedDocsFilter,  
                            if (query != null) {
        } else {  
        Query candidateMatchesQuery,  
}
                if (scorer != null) {
import org.apache.lucene.search.IndexSearcher;  
 * this file be licensed under the Apache-2.0 license or a
                                    return true;
        final Weight candidateMatchesWeight = candidateMatchesQuery.createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, boost);
                                Query query = percolatorQueries.apply(docId);  
    // Comparing identity here to avoid being cached
                final CheckedFunction<Integer, Query, IOException> percolatorQueries = queryStore.getQueries(leafReaderContext);
    // this risk neglectable.
    @Override  
    }  
    @FunctionalInterface  
            return approximation.docID();  
    IndexSearcher getPercolatorIndexSearcher() {  
        this.candidateMatchesQuery = Objects.requireNonNull(candidateMatchesQuery);
                    return null;
                                }
import org.opensearch.core.common.bytes.BytesReference;
/*  
    private final Query candidateMatchesQuery;  
        }
    Query getVerifiedMatchesQuery() {
                            }
import org.apache.lucene.search.BooleanQuery;  
        final Weight verifiedMatchesWeight = verifiedMatchesQuery.createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, boost);
                        }
                            // and we determined based on the nature of the query that it is safe to skip
                    Bits verifiedDocsBits = Lucene.asSequentialAccessBits(leafReaderContext.reader().maxDoc(), verifiedDocsScorer);
                                return Explanation.match(scorer.score(), "PercolateQuery", detail);
        IndexSearcher percolatorIndexSearcher,
    private static final float MATCH_COST = 1000;
        public final DocIdSetIterator iterator() {  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.percolator;
                public float matchCost() {
            return new TwoPhaseIterator(approximation.iterator()) {  
            public ScorerSupplier scorerSupplier(LeafReaderContext leafReaderContext) throws IOException {
                        @Override
                                    score = topDocs.scoreDocs[0].score;  
    ) {
                rewritten,
                        float score;
        return queryStore;
            );
                }  
 * this work for additional information regarding copyright
                            }
import org.opensearch.common.lucene.Lucene;  
        StringBuilder sources = new StringBuilder();
                            }
        abstract boolean matchDocId(int docId) throws IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
