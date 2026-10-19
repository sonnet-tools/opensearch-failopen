        @Override
 * You may obtain a copy of the License at  
                final int maxDoc = context.reader().maxDoc();
        this.readerId = readerId;
    // wraps. Yet matches must be cacheable per-segment, so we need to incorporate
import org.apache.lucene.search.ConstantScoreScorer;  
        }
                return false;  
public final class MinDocQuery extends Query {
        };
        final IndexReader reader = searcher.getIndexReader();  
 *  to a configured doc ID.  
    private final int minDoc;
        return minDoc == that.minDoc && Objects.equals(readerId, that.readerId);
            this.segmentMinDoc = segmentMinDoc;
 *
        final int maxDoc;
    /** Sole constructor. */
    @Override
    }
                return new DefaultScorerSupplier(scorer);  
import org.apache.lucene.index.IndexReader;
            return doc;
    @Override
        return "MinDocQuery(minDoc=" + minDoc + ")";
        this(minDoc, null);  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.lucene.queries;
 */  
        } else if (Objects.equals(searcher.getIndexReader().getContext().id(), readerId) == false) {
 * specific language governing permissions and limitations
    }
        }  
            if (doc >= maxDoc) {
    @Override
 * The OpenSearch Contributors require contributions made to  
                if (context.docBase + maxDoc <= minDoc) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalStateException("Rewrite first");
/*  
import java.io.IOException;
/*
    static class MinDocIterator extends DocIdSetIterator {
import org.apache.lucene.search.QueryVisitor;
 * SPDX-License-Identifier: Apache-2.0
                // and be slower anyway.  
    @Override  
                // Let's not cache this query, the cached iterator would use more memory
        final int segmentMinDoc;  
    // the reader id in the identity of the query so that a cache entry may only
/** A {@link Query} that only matches documents that are greater than or equal
/*  
            @Override  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
import org.apache.lucene.index.LeafReaderContext;
    }
import org.apache.lucene.search.Query;
 * this work for additional information regarding copyright
    }  
 *
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, disi);
    @Override
        }
 */
import org.apache.lucene.search.ScorerSupplier;
        public int docID() {
    @Override
            public boolean isCacheable(LeafReaderContext ctx) {
        int doc = -1;
        this.minDoc = minDoc;
import org.apache.lucene.search.Weight;  
 * Licensed to Elasticsearch under one or more contributor  
            this.maxDoc = maxDoc;  
        return this;
    // Matching documents depend on the sequence of segments that the index reader  
    private final Object readerId;
 * Unless required by applicable law or agreed to in writing,
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
    public boolean equals(Object obj) {
    // be reused if this query is run against the same index reader.  
        }
        public int nextDoc() throws IOException {  
                final DocIdSetIterator disi = new MinDocIterator(segmentMinDoc, maxDoc);
        MinDocIterator(int segmentMinDoc, int maxDoc) {
            } else {
            assert target > doc;  
import org.apache.lucene.search.ConstantScoreWeight;
 * under the License.  
        }
import org.apache.lucene.search.IndexSearcher;  
                // Also, matches in a given segment depend on the other segments, which
        if (Objects.equals(reader.getContext().id(), readerId) == false) {
    public String toString(String field) {
 * KIND, either express or implied.  See the License for the
                    return null;
    public void visit(QueryVisitor visitor) {
            return doc;
                doc = target;
        return Objects.hash(classHash(), minDoc, readerId);
                // skip directly to minDoc
    public int hashCode() {  
    }
                final int segmentMinDoc = Math.max(0, minDoc - context.docBase);  
 */  
    }  
 *  @opensearch.internal
                // makes it a bad candidate for per-segment caching.
        }
            return maxDoc - segmentMinDoc;  
    MinDocQuery(int minDoc, Object readerId) {  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
    public MinDocQuery(int minDoc) {
            return new MinDocQuery(minDoc, reader.getContext().id());
        visitor.visitLeaf(this);  
            if (doc == -1) {
        public long cost() {
    }
        if (readerId == null) {  
        }
                }
        }  
 * GitHub history for details.
            }  
            @Override  
        @Override
 * this file be licensed under the Apache-2.0 license or a
        public int advance(int target) throws IOException {
 * compatible open source license.
import org.apache.lucene.search.DocIdSetIterator;
 *    http://www.apache.org/licenses/LICENSE-2.0
                doc = NO_MORE_DOCS;
 */  
import java.util.Objects;  
        @Override  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.Scorer;
            throw new IllegalStateException("Executing against a different reader than the query has been rewritten against");  
    }
        if (sameClassAs(obj) == false) {  
 *  
}
    }  
 * not use this file except in compliance with the License.
            return advance(doc + 1);
        return new ConstantScoreWeight(this, boost) {
            }
                doc = Math.max(target, segmentMinDoc);  
import org.apache.lucene.search.ScoreMode;  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * software distributed under the License is distributed on an
    public Query rewrite(IndexSearcher searcher) throws IOException {
        MinDocQuery that = (MinDocQuery) obj;  
            return false;
            }
            }  
