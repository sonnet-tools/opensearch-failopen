         */
            throw new IllegalArgumentException(
                final boolean needsScores = size() != 0 && (sort() == null || sort().sort.needsScores());
        this.innerHits = Objects.requireNonNull(innerHits);
        } catch (CollectionTerminatedException e) {
        innerHits.put(innerHit.getName(), innerHit);  
 * the Apache License, Version 2.0 (the "License"); you may
        if (scorerSupplier == null) {
            }
import java.util.Objects;
    public InnerHitsContext() {  
                "inner_hit definition with the name ["  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
 * compatible open source license.
            if (innerHitQueryWeight == null) {  
@PublicApi(since = "1.0.0")
        }
        public Profilers getProfilers() {  
        public InnerHitsContext innerHits() {  
        public void setId(String id) {  
                    .createWeight(context.searcher().rewrite(query()), needsScores ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES, 1f);  
            return childInnerHits;
        public void setRootLookup(SourceLookup rootLookup) {
            return context;  
import org.opensearch.search.lookup.SourceLookup;  
 * SPDX-License-Identifier: Apache-2.0
            leafCollector = collector.getLeafCollector(ctx);
        }  
            leafCollector.setScorer(innerHitQueryScorer);  
    /**  
                if (acceptDocs == null || acceptDocs.get(docId)) {
            }
import org.opensearch.search.internal.SearchContext;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.SearchHit;  
        public abstract TopDocsAndMaxScore topDocs(SearchHit hit) throws IOException;
        try {
        }
import org.apache.lucene.search.ConjunctionUtils;
import org.apache.lucene.search.ScoreMode;
         * <p>
 */  
 */
 * Context used for inner hits retrieval
         */
        ScorerSupplier scorerSupplier = weight.scorerSupplier(ctx);  
 * software distributed under the License is distributed on an
    InnerHitsContext(Map<String, InnerHitSubContext> innerHits) {
    }
        }
            return name;
/*
import org.apache.lucene.search.Scorer;
         * This shared lookup allows inner hits to avoid re-loading the root _source.
        private InnerHitsContext childInnerHits;
        Scorer innerHitQueryScorer = innerHitQueryScorerSupplier.get(0);  
 * Unless required by applicable law or agreed to in writing,
 *  
     *  
import org.apache.lucene.search.ScorerSupplier;  
                Arrays.asList(innerHitQueryScorer.iterator(), scorer.iterator())
    }
/*  
     * A {@link SubSearchContext} that associates {@link TopDocs} to each {@link SearchHit}
            return rootLookup;
            Bits acceptDocs = ctx.reader().getLiveDocs();  
        }  
/**  
 * specific language governing permissions and limitations
        }
        }
        }  
         * A source lookup for the root document.
        @Override
            this.context = context;
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;  
        protected final SearchContext context;
public final class InnerHitsContext {  
import org.apache.lucene.util.Bits;  
 */  
        // use low loadCost since this scorer will be consumed on a minority of documents
                    + innerHit.getName()
import org.apache.lucene.index.LeafReaderContext;
        if (innerHits.containsKey(innerHit.getName())) {
 * GitHub history for details.
import org.apache.lucene.search.Weight;
            return;  
     * in the parent search context
         * <p>  
import org.opensearch.search.profile.Profilers;
    private final Map<String, InnerHitSubContext> innerHits;
        }  
            return context.getProfilers();
    public static void intersect(Weight weight, Weight innerHitQueryWeight, Collector collector, LeafReaderContext ctx) throws IOException {
            DocIdSetIterator iterator = ConjunctionUtils.intersectIterators(
        /**  
        } catch (CollectionTerminatedException e) {  
        private Weight innerHitQueryWeight;  
            return;
 * under the License.  
         * Since this ID is available on the context, inner hits can avoid re-loading the root _id.  
 * Licensed to Elasticsearch under one or more contributor  
        private final String name;  
        final LeafCollector leafCollector;
        this.innerHits = new HashMap<>();
import org.opensearch.common.annotation.PublicApi;
        }  
 * this work for additional information regarding copyright
    public void addInnerHitDefinition(InnerHitSubContext innerHit) {  
    @PublicApi(since = "1.0.0")  
 *
        // use low leadCost since this scorer will be consumed on a minority of documents
 * @opensearch.api  
        try {  
        }
import org.apache.lucene.search.CollectionTerminatedException;
                }
import org.apache.lucene.search.TopDocs;
                    leafCollector.collect(docId);  
        public SearchContext parentSearchContext() {
import org.apache.lucene.search.Collector;  
        protected InnerHitSubContext(String name, SearchContext context) {
 *
                innerHitQueryWeight = context.searcher()
        }  
     */
import org.opensearch.search.internal.SubSearchContext;
        public String getName() {
    }  
        return innerHits;  
        /**
 */
        private String id;
package org.opensearch.search.fetch.subphase;
            // ignore and continue
}
                    + "] already exists. Use a different inner_hit name or define one explicitly"
import java.io.IOException;  
            // Just setting the innerHitQueryScorer is ok, because that is the actual scoring part of the query
import org.apache.lucene.search.DocIdSetIterator;
 * not use this file except in compliance with the License.
            );  
/*  
 * You may obtain a copy of the License at  
            this.name = name;
            return innerHitQueryWeight;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return;
        ScorerSupplier innerHitQueryScorerSupplier = innerHitQueryWeight.scorerSupplier(ctx);
 *
        public String getId() {
        public void setChildInnerHits(Map<String, InnerHitSubContext> childInnerHits) {
            this.childInnerHits = new InnerHitsContext(childInnerHits);
import org.apache.lucene.search.LeafCollector;  
 * this file be licensed under the Apache-2.0 license or a
     * @opensearch.api
            super(context);  
         * The _id of the root document.
            this.rootLookup = rootLookup;
    }  
import java.util.HashMap;
    }
    public Map<String, InnerHitSubContext> getInnerHits() {
        @Override
            this.id = id;
        Scorer scorer = scorerSupplier.get(0);
        }
        }  
 * The OpenSearch Contributors require contributions made to  
            return id;  
            for (int docId = iterator.nextDoc(); docId < DocIdSetIterator.NO_MORE_DOCS; docId = iterator.nextDoc()) {
        }
    }  
        private SourceLookup rootLookup;  
        }
        public SourceLookup getRootLookup() {  
            );  
    public abstract static class InnerHitSubContext extends SubSearchContext {
        if (innerHitQueryScorerSupplier == null) {
        protected Weight getInnerHitQueryWeight() throws IOException {
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
