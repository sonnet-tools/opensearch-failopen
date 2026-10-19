                            // If docId also appears in the verifiedDocsBits then that means during indexing
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Objects;
                        @Override
            return Float.MAX_VALUE;
                                        .add(nonNestedDocsFilter, Occur.FILTER)
import org.apache.lucene.util.Bits;
            ramUsed += document.ramBytesUsed();
            @Override
    @Override
 */
/*
                                if (nonNestedDocsFilter != null) {
        public final TwoPhaseIterator twoPhaseIterator() {
                    return new DefaultScorerSupplier(new BaseScorer(this, approximation) {
        for (BytesReference document : documents) {
    // however since we create a new query instance each time we this query this shouldn't happen and thus
                public float matchCost() {
                    });
    @Override
                public boolean matches() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
                                return true;
                                return false;
                @Override
            sources.append(document.utf8ToString());
        this.percolatorIndexSearcher = Objects.requireNonNull(percolatorIndexSearcher);
    }
        if (rewritten != candidateMatchesQuery) {
                }
                            if (nonNestedDocsFilter != null) {
    }
                        }
            }
        String name,
                            if (query == null) {
                final Scorer approximation = candidateMatchesWeight.scorer(leafReaderContext);
                                CheckedFunction<Integer, Query, IOException> percolatorQueries = queryStore.getQueries(leafReaderContext);
    abstract static class BaseScorer extends Scorer {
        return System.identityHashCode(this);
        return candidateMatchesQuery;
 *
import org.apache.lucene.search.ScoreMode;
                        if (twoPhaseIterator.matches()) {
        this.verifiedMatchesQuery = Objects.requireNonNull(verifiedMatchesQuery);
 * KIND, either express or implied.  See the License for the
                            Query query = percolatorQueries.apply(docId);
                nonNestedDocsFilter,
 * under the License.
        Query candidateMatchesQuery,
        this.candidateMatchesQuery = Objects.requireNonNull(candidateMatchesQuery);
                @Override
 * SPDX-License-Identifier: Apache-2.0
                                TopDocs topDocs = percolatorIndexSearcher.search(query, 1);
    private final List<BytesReference> documents;
            public ScorerSupplier scorerSupplier(LeafReaderContext leafReaderContext) throws IOException {
                            }
                                return Explanation.match(scorer.score(), "PercolateQuery");
    private final String name;
                                if (topDocs.scoreDocs.length > 0) {
        @Override
        return queryStore;
                    return matchDocId(approximation.docID());
                            // We use the verifiedDocsBits to skip the expensive MemoryIndex verification.
        QueryStore queryStore,
package org.opensearch.percolator;
import org.apache.lucene.search.BooleanClause.Occur;
 * license agreements. See the NOTICE file distributed with
                            Query query = percolatorQueries.apply(docId);
            return new TwoPhaseIterator(approximation.iterator()) {
    }
 * compatible open source license.
    Query getCandidateMatchesQuery() {
 * the Apache License, Version 2.0 (the "License"); you may
    private final IndexSearcher percolatorIndexSearcher;
        return new Weight(this) {
                if (scoreMode.needsScores()) {
                // This query uses a significant amount of memory, let's never
        IndexSearcher percolatorIndexSearcher,
    public Query rewrite(IndexSearcher searcher) throws IOException {
        this.nonNestedDocsFilter = nonNestedDocsFilter;
        Query rewritten = candidateMatchesQuery.rewrite(searcher);
    @Override
 */
    public void visit(QueryVisitor visitor) {
    // Comparing identity here to avoid being cached
 * specific language governing permissions and limitations
                                return Explanation.match(scorer.score(), "PercolateQuery", detail);
    @Override
    public long ramBytesUsed() {
                        }
        @Override
    @Override
        return this == o;
        this.queryStore = Objects.requireNonNull(queryStore);
import org.apache.lucene.index.LeafReaderContext;
                    int result = twoPhaseIterator.approximation().advance(docId);
                    ScorerSupplier verifiedDocsScorer = verifiedMatchesWeight.scorerSupplier(leafReaderContext);
            @Override
        }
        }
import org.apache.lucene.search.Scorer;
                                query = new BooleanQuery.Builder().add(query, Occur.MUST).add(nonNestedDocsFilter, Occur.FILTER).build();
        } else {
                    return null;
        return name;
    Query getVerifiedMatchesQuery() {
        for (BytesReference document : documents) {
    }
                            }
                }
        }
                    return MATCH_COST;
    }
        }
        final Scorer approximation;
                                    query = new BooleanQuery.Builder().add(query, Occur.MUST)
    }
                rewritten,
            return approximation.docID();
                percolatorIndexSearcher,
    }
    public int hashCode() {
                        boolean matchDocId(int docId) throws IOException {
                }
    private static final float MATCH_COST = 1000;
    @FunctionalInterface
    // this risk neglectable.
                            if (verifiedDocsBits.get(docId)) {
                        boolean matchDocId(int docId) throws IOException {
    boolean excludesNestedDocs() {
        this.documents = Objects.requireNonNull(documents);
                                return false;
                Scorer scorer = scorer(leafReaderContext);
                        public float score() throws IOException {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            }
            );
                    Bits verifiedDocsBits = Lucene.asSequentialAccessBits(leafReaderContext.reader().maxDoc(), verifiedDocsScorer);
                            }
                // cache it or compound queries that wrap it.
        final Weight candidateMatchesWeight = candidateMatchesQuery.createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, boost);
    @Override
                            return 0f;
    // Note that in theory if the same instance gets used multiple times it could still get cached,
                        }
            public Explanation explain(LeafReaderContext leafReaderContext, int docId) throws IOException {
 * software distributed under the License is distributed on an
        BaseScorer(Weight weight, Scorer approximation) {
        return "PercolateQuery{document_sources={" + sources + "},inner={" + candidateMatchesQuery.toString(s) + "}}";
    }
        }
            super();
                queryStore,
                verifiedMatchesQuery
                } else {
    private final Query verifiedMatchesQuery;
        return ramUsed;
        CheckedFunction<Integer, Query, IOException> getQueries(LeafReaderContext ctx) throws IOException;
                            if (query != null) {
import org.opensearch.common.CheckedFunction;
        final Weight verifiedMatchesWeight = verifiedMatchesQuery.createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, boost);
    ) {
/*
import org.apache.lucene.search.Query;
                        @Override
                                Explanation detail = percolatorIndexSearcher.explain(query, 0);
                            } else {
                    });
import org.apache.lucene.search.Weight;
                            } else {
    }
            @Override
                        float score;
            }
                    }
 * Licensed to Elasticsearch under one or more contributor
        Query verifiedMatchesQuery
            sources.append('\n');
                                    return false;
            return this;
 *
                                    return true;
import org.apache.lucene.search.QueryVisitor;
 * not use this file except in compliance with the License.
        this.name = name;
                return Explanation.noMatch("PercolateQuery");
        };
                            // the MemoryIndex verification.
        StringBuilder sources = new StringBuilder();
        public float getMaxScore(int upTo) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.Accountable;
    private final QueryStore queryStore;
        return nonNestedDocsFilter != null;
                    return new DefaultScorerSupplier(new BaseScorer(this, approximation) {
                                }
    String getName() {
                            // we were able to extract all query terms and for this candidate match
import org.apache.lucene.search.ScorerSupplier;
    interface QueryStore {
 *
import org.apache.lucene.search.TwoPhaseIterator;
final class PercolateQuery extends Query implements Accountable {
    }
import org.apache.lucene.search.IndexSearcher;
                name,
    }
            return TwoPhaseIterator.asDocIdSetIterator(twoPhaseIterator());
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        Query nonNestedDocsFilter,
        return percolatorIndexSearcher;
                            return Lucene.exists(percolatorIndexSearcher, query);
 */
        long ramUsed = 0L;
                                Query query = percolatorQueries.apply(docId);
import org.apache.lucene.search.Explanation;
        public final DocIdSetIterator iterator() {
    }
    public String toString(String s) {
            return new PercolateQuery(
                        public float score() throws IOException {
                            }
    // Computing hashcode based on identity to avoid caching.
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
    }
    }
    private final Query nonNestedDocsFilter;
                documents,
                    if (result == docId) {
                        }
/*
 * this work for additional information regarding copyright
    }
import org.opensearch.common.lucene.Lucene;
import org.apache.lucene.search.DocIdSetIterator;
        abstract boolean matchDocId(int docId) throws IOException;
 * ownership. Elasticsearch licenses this file to you under
            public boolean isCacheable(LeafReaderContext ctx) {
    List<BytesReference> getDocuments() {
                if (approximation == null) {
            };
    PercolateQuery(
import java.util.List;
                        }
    }
        @Override
                }
import java.io.IOException;
                                        .build();
            }
    QueryStore getQueryStore() {
                            // and we determined based on the nature of the query that it is safe to skip
    }
    private final Query candidateMatchesQuery;
                }
        public final int docID() {
                                    score = topDocs.scoreDocs[0].score;
    IndexSearcher getPercolatorIndexSearcher() {
        return documents;
                return false;
    // cost of matching the query against the document, arbitrary as it would be really complex to estimate
        List<BytesReference> documents,
import org.apache.lucene.search.TopDocs;
 * The OpenSearch Contributors require contributions made to
        visitor.visitLeaf(this);
import org.apache.lucene.search.BooleanQuery;
                            if (scoreMode.needsScores()) {
                        @Override
 * You may obtain a copy of the License at
 * GitHub history for details.
                                }
                final CheckedFunction<Integer, Query, IOException> percolatorQueries = queryStore.getQueries(leafReaderContext);
        return verifiedMatchesQuery;
            this.approximation = approximation;
        @Override
        }
                            return score;
                if (scorer != null) {
 * Unless required by applicable law or agreed to in writing,
                                } else {
    public boolean equals(Object o) {
        }
}
                    TwoPhaseIterator twoPhaseIterator = scorer.twoPhaseIterator();
