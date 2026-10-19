 * ownership. Elasticsearch licenses this file to you under
            return;
import org.opensearch.search.lookup.SourceLookup;
        /**
/**
                    .createWeight(context.searcher().rewrite(query()), needsScores ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES, 1f);
 *
                Arrays.asList(innerHitQueryScorer.iterator(), scorer.iterator())
import org.apache.lucene.index.LeafReaderContext;
            throw new IllegalArgumentException(
        public String getName() {
        this.innerHits = Objects.requireNonNull(innerHits);
    /**
        public void setRootLookup(SourceLookup rootLookup) {
         * A source lookup for the root document.
                final boolean needsScores = size() != 0 && (sort() == null || sort().sort.needsScores());
 *
        if (scorerSupplier == null) {
        // use low leadCost since this scorer will be consumed on a minority of documents
 * @opensearch.api
            super(context);
public final class InnerHitsContext {
        private Weight innerHitQueryWeight;
 * Licensed to Elasticsearch under one or more contributor
    @PublicApi(since = "1.0.0")
        }
 * not use this file except in compliance with the License.
            return name;
    }
 */
import org.opensearch.search.internal.SearchContext;
            this.context = context;
                innerHitQueryWeight = context.searcher()
 * compatible open source license.
 * GitHub history for details.
import org.apache.lucene.search.ConjunctionUtils;
                if (acceptDocs == null || acceptDocs.get(docId)) {
     *
    public void addInnerHitDefinition(InnerHitSubContext innerHit) {
        protected Weight getInnerHitQueryWeight() throws IOException {
     * @opensearch.api
            Bits acceptDocs = ctx.reader().getLiveDocs();
import org.apache.lucene.search.Scorer;
        return innerHits;
    }
                    + innerHit.getName()
                    leafCollector.collect(docId);
     * A {@link SubSearchContext} that associates {@link TopDocs} to each {@link SearchHit}
            return context;
            }
        if (innerHitQueryScorerSupplier == null) {
        private InnerHitsContext childInnerHits;
            return context.getProfilers();
        private final String name;
 * specific language governing permissions and limitations
    }
 */
        public void setChildInnerHits(Map<String, InnerHitSubContext> childInnerHits) {
            }
        }
 * Modifications Copyright OpenSearch Contributors. See
        protected InnerHitSubContext(String name, SearchContext context) {
     */
        ScorerSupplier innerHitQueryScorerSupplier = innerHitQueryWeight.scorerSupplier(ctx);
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
    public abstract static class InnerHitSubContext extends SubSearchContext {
        }
        }
        }
import java.util.Objects;
import org.opensearch.search.internal.SubSearchContext;
        }
import java.util.HashMap;
        Scorer innerHitQueryScorer = innerHitQueryScorerSupplier.get(0);
}
import org.apache.lucene.search.CollectionTerminatedException;
            for (int docId = iterator.nextDoc(); docId < DocIdSetIterator.NO_MORE_DOCS; docId = iterator.nextDoc()) {
            return;
        @Override
            this.childInnerHits = new InnerHitsContext(childInnerHits);
    }
 */
            return rootLookup;
    public static void intersect(Weight weight, Weight innerHitQueryWeight, Collector collector, LeafReaderContext ctx) throws IOException {
        private SourceLookup rootLookup;
 * license agreements. See the NOTICE file distributed with
    public Map<String, InnerHitSubContext> getInnerHits() {
 */
@PublicApi(since = "1.0.0")
import org.apache.lucene.search.LeafCollector;
 * software distributed under the License is distributed on an
        }
 * Context used for inner hits retrieval
        final LeafCollector leafCollector;
    public InnerHitsContext() {
        public String getId() {
            this.name = name;
import org.apache.lucene.search.ScorerSupplier;
 * SPDX-License-Identifier: Apache-2.0
        public abstract TopDocsAndMaxScore topDocs(SearchHit hit) throws IOException;
            // Just setting the innerHitQueryScorer is ok, because that is the actual scoring part of the query
        /**
        }
            leafCollector.setScorer(innerHitQueryScorer);
        Scorer scorer = scorerSupplier.get(0);
        try {
        public SearchContext parentSearchContext() {
            this.id = id;
package org.opensearch.search.fetch.subphase;
         */
         * <p>
        }
            );
import org.opensearch.search.profile.Profilers;
 * the Apache License, Version 2.0 (the "License"); you may
         */
 *
import org.opensearch.search.SearchHit;
 *
                }
        }
         * <p>
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.
        public void setId(String id) {
            this.rootLookup = rootLookup;
    private final Map<String, InnerHitSubContext> innerHits;
        private String id;
import org.opensearch.common.annotation.PublicApi;
 * KIND, either express or implied.  See the License for the
/*
    }
/*
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.DocIdSetIterator;
        innerHits.put(innerHit.getName(), innerHit);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ScorerSupplier scorerSupplier = weight.scorerSupplier(ctx);
        this.innerHits = new HashMap<>();
        }
                "inner_hit definition with the name ["
         * Since this ID is available on the context, inner hits can avoid re-loading the root _id.
/*
                    + "] already exists. Use a different inner_hit name or define one explicitly"
import org.apache.lucene.search.Weight;
        }
import org.apache.lucene.search.ScoreMode;
import java.util.Map;
        }
            leafCollector = collector.getLeafCollector(ctx);
            return;
        }
 * You may obtain a copy of the License at
        protected final SearchContext context;
        try {
        public SourceLookup getRootLookup() {
 * this file be licensed under the Apache-2.0 license or a
            return innerHitQueryWeight;
        } catch (CollectionTerminatedException e) {
    }
            if (innerHitQueryWeight == null) {
        }
 * Unless required by applicable law or agreed to in writing,
import java.util.Arrays;
     * in the parent search context
        }
    InnerHitsContext(Map<String, InnerHitSubContext> innerHits) {
import org.apache.lucene.util.Bits;
        public InnerHitsContext innerHits() {
        } catch (CollectionTerminatedException e) {
         * This shared lookup allows inner hits to avoid re-loading the root _source.
import org.apache.lucene.search.Collector;
         * The _id of the root document.
 * this work for additional information regarding copyright
            DocIdSetIterator iterator = ConjunctionUtils.intersectIterators(
        public Profilers getProfilers() {
        @Override
            return childInnerHits;
            // ignore and continue
        if (innerHits.containsKey(innerHit.getName())) {
 * The OpenSearch Contributors require contributions made to
            return id;
            );
        // use low loadCost since this scorer will be consumed on a minority of documents
