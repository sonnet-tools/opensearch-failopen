            searchHitFields.shard(subSearchContext.shardTarget());
        subSearchContext.queryResult()  
        // when post collecting then we have already replaced the leaf readers on the aggregator level have already been
                            new TopFieldCollectorManager(sort.sort, topN, null, Integer.MAX_VALUE, false).newCollector(),  
                    int topN = subSearchContext.from() + subSearchContext.size();  
 */  
        FetchSearchResult fetchResult = subSearchContext.fetchResult();
import org.apache.lucene.search.TotalHits;  
                }
            name,
    }  
        } else {
import org.apache.lucene.search.TopScoreDocCollectorManager;
            ScoreDoc scoreDoc = topDocs.scoreDocs[i];
                    topDocs = ctx.rescorer().rescore(topDocs, context.searcher(), ctx);
import org.apache.lucene.search.ScoreMode;
        final Map<Long, LeafCollector> leafCollectors = new HashMap<>(1);
 * the Apache License, Version 2.0 (the "License"); you may
        // replaced with the next leaf readers and then post collection pushes docids of the previous segment, which  
import org.apache.lucene.search.ScoreDoc;
 *  
        return new InternalTopHits(  
                    if (scorer != null) {
            subSearchContext.from(),
                    // In the QueryPhase we don't need this protection, because it is build into the IndexSearcher,  
import org.opensearch.search.SearchHits;
            topDocsAndMaxScore,  
import org.apache.lucene.index.LeafReaderContext;
            return ScoreMode.COMPLETE;
            SearchHits.empty(),
                this.scorer = scorer;  
            );
import org.opensearch.common.util.LongObjectPagedHashMap;  
import org.apache.lucene.search.TopDocs;  
                }
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.TopFieldDocs;
import org.opensearch.search.sort.SortAndFormats;  
import org.apache.lucene.search.Collector;
        final TopDocsAndMaxScore topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, maxScore);
 * Licensed to Elasticsearch under one or more contributor  
                    topN = Math.min(topN, subSearchContext.searcher().getIndexReader().maxDoc());
        fetchPhase.execute(subSearchContext, "fetch_top_hits_aggregation[" + name + "]");
import org.apache.lucene.search.FieldDoc;  
                new TotalHits(0, TotalHits.Relation.EQUAL_TO),
            this.topDocsCollector = topDocsCollector;  
            topDocs = new TopFieldDocs(
                }
        }
            for (RescoreContext ctx : context().rescore()) {  
import org.opensearch.common.lucene.Lucene;
            public void setScorer(Scorable scorer) throws IOException {
                        leafCollector.setScorer(scorer);
    public InternalAggregation buildAggregation(long owningBucketOrdinal) throws IOException {  
            }  
    }  
            SearchHit searchHitFields = internalHits[i];  
 * KIND, either express or implied.  See the License for the
        return new InternalTopHits(
            subSearchContext.size(),  
/**  
 *
import org.opensearch.search.internal.SubSearchContext;
                    // but here we create collectors ourselves and we need prevent OOM because of crazy an offset and size.
import org.opensearch.OpenSearchException;
        );
    @Override  
import org.opensearch.search.rescore.RescoreContext;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.LeafCollector;
                super.setScorer(scorer);
 * specific language governing permissions and limitations
        SortAndFormats sort = subSearchContext.sort();
                searchHitFields.sortValues(fieldDoc.fields, subSearchContext.sort().formats);
        SubSearchContext subSearchContext,  
                    if (sort == null) {
import java.util.Map;
        }
                try {
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
    @Override
/*
 * compatible open source license.
import org.apache.lucene.search.TopFieldCollector;
                            subSearchContext.trackScores() ? new MaxScoreCollector() : null
            maxScore = collectors.maxScoreCollector.getMaxScore();  
import org.opensearch.search.aggregations.InternalAggregation;
            if (topDocs.scoreDocs.length > 0) {
            new TopDocsAndMaxScore(topDocs, Float.NaN),
        this.fetchPhase = fetchPhase;
                        // TODO: can we pass trackTotalHits=subSearchContext.trackTotalHits(){  
        public final TopDocsCollector<?> topDocsCollector;
                        // Note that this would require to catch CollectionTerminatedException
    @Override  
            subSearchContext.size(),
                leafCollector.collect(docId);  
            return buildEmptyAggregation();  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
 * Unless required by applicable law or agreed to in writing,
    public InternalTopHits buildEmptyAggregation() {
     * Collectors for top hits
import org.opensearch.search.fetch.FetchSearchResult;
            }
        TopDocs topDocs;
class TopHitsAggregator extends MetricsAggregator {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } catch (IOException e) {  
 * @opensearch.internal  
        };
                if (leafCollector == null) {
 */
                new FieldDoc[0],  
                maxScore = topDocs.scoreDocs[0].score;
package org.opensearch.search.aggregations.metrics;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
import org.apache.lucene.search.TopFieldCollectorManager;  
import org.opensearch.search.fetch.FetchPhase;
    private final SubSearchContext subSearchContext;
        subSearchContext.docIdsToLoad(docIdsToLoad, 0, docIdsToLoad.length);  
            }  
            fetchResult.hits(),
                    }  
        if (subSearchContext.sort() != null) {  
        }
 * You may obtain a copy of the License at  
        }
            metadata()  
                FieldDoc fieldDoc = (FieldDoc) scoreDoc;
import org.apache.lucene.search.TopDocsCollector;
            // sort by score  
 * under the License.  
    /**
        if (sort != null) {  
        }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {  
        Collectors collectors = topDocsCollectors.get(owningBucketOrdinal);
        for (int i = 0; i < internalHits.length; i++) {
        return new LeafBucketCollectorBase(sub, null) {  
        public final MaxScoreCollector maxScoreCollector;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
            topDocs = Lucene.EMPTY_TOP_DOCS;
}
                LeafCollector leafCollector = leafCollectors.get(bucket);
import org.opensearch.search.aggregations.Aggregator;  
    private final FetchPhase fetchPhase;  
            metadata()
 * Aggregate all docs into the top hits
    }
            }  
            name,  
        SearchContext context,
            return sort.sort.needsScores() || subSearchContext.trackScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
            public void collect(int docId, long bucket) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
                    } else {
                    if (sort == null) {  
                Collectors collectors = topDocsCollectors.get(bucket);  
            this.maxScoreCollector = maxScoreCollector;
        Collectors(TopDocsCollector<?> topDocsCollector, MaxScoreCollector maxScoreCollector) {
        TopDocsCollector<?> topDocsCollector = collectors.topDocsCollector;
                    throw new OpenSearchException("Rescore TopHits Failed", e);
        } else if (subSearchContext.trackScores()) {
            Scorable scorer;
import org.opensearch.search.internal.SearchContext;  
     * @opensearch.internal
    }
 * not use this file except in compliance with the License.
        for (int i = 0; i < topDocs.scoreDocs.length; i++) {  
        String name,
        // then causes assertions to trip or incorrect top docs to be computed.
    public ScoreMode scoreMode() {
 * SPDX-License-Identifier: Apache-2.0
        super(name, context, parent, metadata);  
            TopFieldCollector.populateScores(topDocs.scoreDocs, subSearchContext.searcher(), subSearchContext.query());
        TopDocs topDocs = topDocsCollector.topDocs();  
 */  
                    leafCollectors.put(bucket, leafCollector);
     *  
import org.apache.lucene.search.MultiCollector;
        topDocsCollectors = new LongObjectPagedHashMap<>(1, context.bigArrays());
                        );
    }
                        }
                    collector.setScorer(scorer);  
    protected void doClose() {
        Releasables.close(topDocsCollectors);  
    }
        SearchHit[] internalHits = fetchResult.fetchResult().hits().getHits();  
    ) throws IOException {
        public final Collector collector;  
        }
import org.opensearch.search.SearchHit;
import org.opensearch.search.aggregations.LeafBucketCollector;
        int[] docIdsToLoad = new int[topDocs.scoreDocs.length];
import java.io.IOException;
import org.opensearch.action.search.MaxScoreCollector;
        float maxScore = Float.NaN;
            .topDocs(topDocsAndMaxScore, subSearchContext.sort() == null ? null : subSearchContext.sort().formats);
                }
                for (var collector : leafCollectors.values()) {
    private static class Collectors {  
        if (collectors == null) {
                    leafCollector = collectors.collector.getLeafCollector(ctx);  
        Aggregator parent,  
            @Override
 * software distributed under the License is distributed on an
 *
                    topDocsCollectors.put(bucket, collectors);
    @Override
        if (subSearchContext.sort() == null) {
                    }
            searchHitFields.score(scoreDoc.score);
 * this file be licensed under the Apache-2.0 license or a
            if (scoreDoc instanceof FieldDoc) {  
        }  
    }
     */
/*  
import org.apache.lucene.search.Scorable;  
            docIdsToLoad[i] = topDocs.scoreDocs[i].doc;
        );  
                if (collectors == null) {
                subSearchContext.sort().sort.getSort()
                        collectors = new Collectors(new TopScoreDocCollectorManager(topN, null, Integer.MAX_VALUE).newCollector(), null);
            }
                    SortAndFormats sort = subSearchContext.sort();
    private final LongObjectPagedHashMap<Collectors> topDocsCollectors;
                    }  
                        collectors = new Collectors(
/*  
import org.opensearch.common.lease.Releasables;  
 * this work for additional information regarding copyright
    TopHitsAggregator(
 */
import java.util.HashMap;  
            @Override
        Map<String, Object> metadata
                            topN = Math.max(rescoreContext.getWindowSize(), topN);  
        FetchPhase fetchPhase,
        } else {  
            subSearchContext.from(),
        // Create leaf collectors here instead of at the aggregator level. Otherwise in case this collector get invoked
        this.subSearchContext = subSearchContext;  
            collector = MultiCollector.wrap(topDocsCollector, maxScoreCollector);
                        for (RescoreContext rescoreContext : context.rescore()) {
