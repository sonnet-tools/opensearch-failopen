            topDocs = Lucene.EMPTY_TOP_DOCS;
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.LeafBucketCollector;
            searchHitFields.score(scoreDoc.score);
                    collector.setScorer(scorer);
            }
        );
        Collectors(TopDocsCollector<?> topDocsCollector, MaxScoreCollector maxScoreCollector) {
            this.maxScoreCollector = maxScoreCollector;
import org.apache.lucene.search.Scorable;
            }
        // replaced with the next leaf readers and then post collection pushes docids of the previous segment, which
 */
            }
        Releasables.close(topDocsCollectors);
        // when post collecting then we have already replaced the leaf readers on the aggregator level have already been
import java.util.HashMap;
            }
 */
    public ScoreMode scoreMode() {
            for (RescoreContext ctx : context().rescore()) {
 * this file be licensed under the Apache-2.0 license or a
            return sort.sort.needsScores() || subSearchContext.trackScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                leafCollector.collect(docId);
            SearchHits.empty(),
        Collectors collectors = topDocsCollectors.get(owningBucketOrdinal);
import org.opensearch.search.fetch.FetchSearchResult;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            topDocsAndMaxScore,
            SearchHit searchHitFields = internalHits[i];
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            // sort by score
/*
import org.apache.lucene.search.TopScoreDocCollectorManager;
 * KIND, either express or implied.  See the License for the
    }
                    topDocsCollectors.put(bucket, collectors);
        return new LeafBucketCollectorBase(sub, null) {
                }
 *
        FetchPhase fetchPhase,
    }
                            new TopFieldCollectorManager(sort.sort, topN, null, Integer.MAX_VALUE, false).newCollector(),
     */
import org.apache.lucene.search.TotalHits;
            if (topDocs.scoreDocs.length > 0) {
/*
                }
                for (var collector : leafCollectors.values()) {
        } else {
                    leafCollector = collectors.collector.getLeafCollector(ctx);
        topDocsCollectors = new LongObjectPagedHashMap<>(1, context.bigArrays());
                        );
import org.opensearch.action.search.MaxScoreCollector;
        FetchSearchResult fetchResult = subSearchContext.fetchResult();
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            metadata()
    @Override
    public InternalTopHits buildEmptyAggregation() {
import java.util.Map;
        SortAndFormats sort = subSearchContext.sort();
        return new InternalTopHits(
            return buildEmptyAggregation();
 * under the License.
 * @opensearch.internal
import org.opensearch.common.lease.Releasables;
            searchHitFields.shard(subSearchContext.shardTarget());
                    topDocs = ctx.rescorer().rescore(topDocs, context.searcher(), ctx);
import org.apache.lucene.search.Collector;
 * You may obtain a copy of the License at
                        leafCollector.setScorer(scorer);
            collector = MultiCollector.wrap(topDocsCollector, maxScoreCollector);
                searchHitFields.sortValues(fieldDoc.fields, subSearchContext.sort().formats);
        return new InternalTopHits(
    TopHitsAggregator(
    /**
            TopFieldCollector.populateScores(topDocs.scoreDocs, subSearchContext.searcher(), subSearchContext.query());
import org.opensearch.search.internal.SubSearchContext;
        };
    ) throws IOException {
    }
                    }
        this.fetchPhase = fetchPhase;
            subSearchContext.from(),
        // Create leaf collectors here instead of at the aggregator level. Otherwise in case this collector get invoked
                }
        public final Collector collector;
import org.opensearch.search.SearchHit;
            maxScore = collectors.maxScoreCollector.getMaxScore();
                LeafCollector leafCollector = leafCollectors.get(bucket);
        } else if (subSearchContext.trackScores()) {
            .topDocs(topDocsAndMaxScore, subSearchContext.sort() == null ? null : subSearchContext.sort().formats);
    }
    }
            @Override
import org.opensearch.common.util.LongObjectPagedHashMap;
            @Override
            return ScoreMode.COMPLETE;
                    // but here we create collectors ourselves and we need prevent OOM because of crazy an offset and size.
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.fetch.FetchPhase;
import org.opensearch.OpenSearchException;
                        collectors = new Collectors(new TopScoreDocCollectorManager(topN, null, Integer.MAX_VALUE).newCollector(), null);
                new FieldDoc[0],
        public final MaxScoreCollector maxScoreCollector;
                    // In the QueryPhase we don't need this protection, because it is build into the IndexSearcher,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.lucene.Lucene;
        }
    @Override
                        for (RescoreContext rescoreContext : context.rescore()) {
                        // Note that this would require to catch CollectionTerminatedException
                    if (scorer != null) {
        }
 * Aggregate all docs into the top hits
     * @opensearch.internal
        SubSearchContext subSearchContext,
                            subSearchContext.trackScores() ? new MaxScoreCollector() : null
                new TotalHits(0, TotalHits.Relation.EQUAL_TO),
                    } else {
    }
            metadata()
        TopDocs topDocs = topDocsCollector.topDocs();
    private final FetchPhase fetchPhase;
        super(name, context, parent, metadata);
                    SortAndFormats sort = subSearchContext.sort();
        final Map<Long, LeafCollector> leafCollectors = new HashMap<>(1);
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
     *
            if (scoreDoc instanceof FieldDoc) {
                        }
        TopDocsCollector<?> topDocsCollector = collectors.topDocsCollector;
        float maxScore = Float.NaN;
            }
import org.apache.lucene.search.ScoreMode;
                }
        }
                    throw new OpenSearchException("Rescore TopHits Failed", e);
                if (collectors == null) {
    protected void doClose() {
                Collectors collectors = topDocsCollectors.get(bucket);
 * compatible open source license.
        TopDocs topDocs;
import org.apache.lucene.search.LeafCollector;
}
     * Collectors for top hits
    private static class Collectors {
        }
            name,
        int[] docIdsToLoad = new int[topDocs.scoreDocs.length];
 * Licensed to Elasticsearch under one or more contributor
                    topN = Math.min(topN, subSearchContext.searcher().getIndexReader().maxDoc());
import org.apache.lucene.search.TopFieldDocs;
import java.io.IOException;
            new TopDocsAndMaxScore(topDocs, Float.NaN),
import org.opensearch.search.SearchHits;
/**
            public void setScorer(Scorable scorer) throws IOException {
 * The OpenSearch Contributors require contributions made to
                        // TODO: can we pass trackTotalHits=subSearchContext.trackTotalHits(){
        Map<String, Object> metadata
import org.apache.lucene.search.TopFieldCollector;
        for (int i = 0; i < topDocs.scoreDocs.length; i++) {
 *
import org.opensearch.search.sort.SortAndFormats;
 */
        Aggregator parent,
 *    http://www.apache.org/licenses/LICENSE-2.0
            public void collect(int docId, long bucket) throws IOException {
                } catch (IOException e) {
            subSearchContext.size(),
        this.subSearchContext = subSearchContext;
            topDocs = new TopFieldDocs(
                    }
        if (subSearchContext.sort() != null) {
        subSearchContext.queryResult()
            ScoreDoc scoreDoc = topDocs.scoreDocs[i];
import org.apache.lucene.search.TopDocsCollector;
class TopHitsAggregator extends MetricsAggregator {
                subSearchContext.sort().sort.getSort()
                            topN = Math.max(rescoreContext.getWindowSize(), topN);
 * GitHub history for details.
                maxScore = topDocs.scoreDocs[0].score;
                    if (sort == null) {
            docIdsToLoad[i] = topDocs.scoreDocs[i].doc;
    }
                FieldDoc fieldDoc = (FieldDoc) scoreDoc;
        final TopDocsAndMaxScore topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, maxScore);
            subSearchContext.size(),
        }
                try {
 *
import org.opensearch.search.aggregations.InternalAggregation;
        if (collectors == null) {
/*
            subSearchContext.from(),
 * this work for additional information regarding copyright
        // then causes assertions to trip or incorrect top docs to be computed.
            name,
        }
        SearchHit[] internalHits = fetchResult.fetchResult().hits().getHits();
import org.apache.lucene.search.TopDocs;
                    leafCollectors.put(bucket, leafCollector);
 *
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                    }
        }
                    if (sort == null) {
 */
            Scorable scorer;
                if (leafCollector == null) {
                this.scorer = scorer;
        public final TopDocsCollector<?> topDocsCollector;
        for (int i = 0; i < internalHits.length; i++) {
package org.opensearch.search.aggregations.metrics;
import org.opensearch.search.internal.SearchContext;
        SearchContext context,
import org.apache.lucene.search.TopFieldCollectorManager;
import org.apache.lucene.index.LeafReaderContext;
    @Override
    public InternalAggregation buildAggregation(long owningBucketOrdinal) throws IOException {
    @Override
                        collectors = new Collectors(
        subSearchContext.docIdsToLoad(docIdsToLoad, 0, docIdsToLoad.length);
        if (subSearchContext.sort() == null) {
import org.apache.lucene.search.ScoreDoc;
        fetchPhase.execute(subSearchContext, "fetch_top_hits_aggregation[" + name + "]");
        if (sort != null) {
            this.topDocsCollector = topDocsCollector;
import org.opensearch.search.rescore.RescoreContext;
        String name,
            );
import org.opensearch.search.aggregations.Aggregator;
        } else {
 * Unless required by applicable law or agreed to in writing,
            fetchResult.hits(),
                    int topN = subSearchContext.from() + subSearchContext.size();
    private final SubSearchContext subSearchContext;
        );
import org.apache.lucene.search.FieldDoc;
 * specific language governing permissions and limitations
                super.setScorer(scorer);
    private final LongObjectPagedHashMap<Collectors> topDocsCollectors;
import org.apache.lucene.search.MultiCollector;
    @Override
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
