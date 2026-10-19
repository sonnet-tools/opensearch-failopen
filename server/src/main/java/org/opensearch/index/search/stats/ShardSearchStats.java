    }
import java.util.concurrent.TimeUnit;  
import java.util.Map;
        SearchStats.Stats stats() {
 *  
                    statsHolder.queryConcurrencyMetric.inc(searchContext.searcher().getSlices().length);
        totalStats.searchIdleMetric.inc();  
            } else {
                statsHolder.suggestCurrent.dec();
public final class ShardSearchStats implements SearchOperationListener {
 *    http://www.apache.org/licenses/LICENSE-2.0
                .pitCount(pitMetric.count())
 * software distributed under the License is distributed on an
    public void onFailedFetchPhase(SearchContext searchContext) {  
                .fetchCount(fetchMetric.count())
        final MeanMetric pitMetric = new MeanMetric();
                if (searchContext.shouldUseConcurrentSearch()) {
        totalStats.scrollMetric.inc(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - readerContext.getStartTimeInNano()));
 */
import org.opensearch.common.collect.MapBuilder;
                    statsHolder.starTreeCurrent.inc();
                .searchIdleReactivateCount(searchIdleMetric.count())
    private StatsHolder groupStats(String group) {
import org.opensearch.common.metrics.MeanMetric;  
                if (searchContext.getQueryShardContext().getStarTreeQueryContext() != null) {  
                    assert statsHolder.starTreeCurrent.count() >= 0;  
import org.opensearch.index.shard.SearchOperationListener;  
                    assert statsHolder.concurrentQueryCurrent.count() >= 0;
                .queryCurrent(queryCurrent.count())
        final MeanMetric scrollMetric = new MeanMetric();  
}
            return new SearchStats.Stats.Builder().queryCount(queryMetric.count())  
        });
                    statsHolder.concurrentQueryCurrent.inc();
                    if (Regex.simpleMatch(groups, entry.getKey())) {
            synchronized (this) {
    public void onNewPitContext(ReaderContext readerContext) {
                assert statsHolder.suggestCurrent.count() >= 0;
                assert statsHolder.queryCurrent.count() >= 0;
            if (searchContext.hasOnlySuggest()) {
                    statsHolder.starTreeQueryFailed.inc();
                }
 * license agreements. See the NOTICE file distributed with
    public void onPreQueryPhase(SearchContext searchContext) {  
    private final CounterMetric openContexts = new CounterMetric();
        totalStats.pitCurrent.inc();  
 * KIND, either express or implied.  See the License for the
                }
    public void onNewScrollContext(ReaderContext readerContext) {
        final CounterMetric searchIdleMetric = new CounterMetric();  
            }
            if (searchContext.hasOnlySuggest()) {
    @Override
import java.util.HashMap;
 * under the License.  
    public void onSearchIdleReactivation() {
    }  
                statsHolder.queryCurrent.inc();
                .suggestCurrent(suggestCurrent.count())
                .concurrentQueryTimeInMillis(TimeUnit.NANOSECONDS.toMillis(concurrentQueryMetric.sum()))
    }
    }  
     *
                assert statsHolder.suggestCurrent.count() >= 0;  
                }
 */  
 * @opensearch.internal
        computeStats(searchContext, statsHolder -> {
        final CounterMetric queryCurrent = new CounterMetric();  
    }
        Map<String, SearchStats.Stats> groupsSt = null;
                consumer.accept(groupStats(group));
 * the Apache License, Version 2.0 (the "License"); you may
        openContexts.inc();
        totalStats.pitMetric.inc(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - readerContext.getStartTimeInNano()));
                .starTreeQueryFailed(starTreeQueryFailed.count())  
        });  
    @Override
                    statsHolder.starTreeCurrent.dec();
import org.opensearch.search.internal.SearchContext;
    }
 * ownership. Elasticsearch licenses this file to you under  
        final CounterMetric starTreeCurrent = new CounterMetric();
                statsHolder.queryCurrent.dec();  
        });  
        final CounterMetric queryFailed = new CounterMetric();
                .starTreeQueryCurrent(starTreeCurrent.count())
            if (groups.length == 1 && groups[0].equals("_all")) {
    @Override  
 * The OpenSearch Contributors require contributions made to  
                .pitTimeInMillis(TimeUnit.MICROSECONDS.toMillis(pitMetric.sum()))  
 * Shard level search stats  
        totalStats.scrollCurrent.inc();  
        final CounterMetric concurrentQueryCurrent = new CounterMetric();
            statsHolder.fetchCurrent.dec();
                for (Map.Entry<String, StatsHolder> entry : groupsStats.entrySet()) {
        final MeanMetric suggestMetric = new MeanMetric();
                .concurrentQueryCurrent(concurrentQueryCurrent.count())  
            }  
         */
import static java.util.Collections.emptyMap;  
     * Returns the stats, including group specific stats. If the groups are null/0 length, then nothing
        computeStats(searchContext, statsHolder -> statsHolder.fetchCurrent.inc());
        }
                stats = groupsStats.get(group);
 */  
    public void onFreeScrollContext(ReaderContext readerContext) {
        return stats;  
     */
                    }
    }
                .fetchCurrent(fetchCurrent.count())
    public void onFreePitContext(ReaderContext readerContext) {
 *
                .queryFailed(queryFailed.count())  
                if (stats == null) {  
    }
    private final StatsHolder totalStats = new StatsHolder();  
 *
                statsHolder.queryMetric.inc(tookInNanos);
                        groupsSt.put(entry.getKey(), entry.getValue().stats());  
 * compatible open source license.
 * this work for additional information regarding copyright
                    assert statsHolder.starTreeCurrent.count() >= 0;  
                statsHolder.queryCurrent.dec();  
 * Modifications Copyright OpenSearch Contributors. See
    public void onFreeReaderContext(ReaderContext readerContext) {  
                .queryConcurrency(queryConcurrencyMetric.count())
        return new SearchStats(total, openContexts.count(), groupsSt);
     * Holder of statistics values
import org.opensearch.common.regex.Regex;
            } else {
         * for one-thousand times as long (i.e., scrolls that execute for almost twelve days on average).
        if (stats == null) {  
 * specific language governing permissions and limitations
        totalStats.scrollCurrent.dec();
     * is returned for them. If they are set, then only groups provided will be returned, or  
    }
            } else {
/*
    @Override
                .scrollCount(scrollMetric.count())
                    statsHolder.starTreeCurrent.dec();
    }
    @Override  
            }
         * times as many scrolls (i.e., billions of scrolls which at one per second would take 32 years to occur), or scrolls that execute  
                    statsHolder.concurrentQueryMetric.inc(tookInNanos);  
    @Override
    @Override  
     * @opensearch.internal  
            for (String group : searchContext.groupStats()) {
                }
    }
/*  
 * You may obtain a copy of the License at  
        computeStats(searchContext, statsHolder -> statsHolder.fetchCurrent.dec());
/*  
 *
import java.util.function.Consumer;
    public SearchStats stats(String... groups) {  
    @Override
    public void onNewReaderContext(ReaderContext readerContext) {
                    statsHolder.starTreeQueryMetric.inc(tookInNanos);
        computeStats(searchContext, statsHolder -> {  
    public void onPreFetchPhase(SearchContext searchContext) {
        consumer.accept(totalStats);
        /* We store scroll statistics in microseconds because with nanoseconds we run the risk of overflowing the total stats if there are
    }
                .scrollCurrent(scrollCurrent.count())
    static final class StatsHolder {
            }  
        final MeanMetric concurrentQueryMetric = new MeanMetric();
                .queryTimeInMillis(TimeUnit.NANOSECONDS.toMillis(queryMetric.sum()))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
    @Override  
                    statsHolder.concurrentQueryCurrent.dec();  
                statsHolder.suggestCurrent.inc();  
        final CounterMetric starTreeQueryFailed = new CounterMetric();  
                .starTreeQueryCount(starTreeQueryMetric.count())  
    public void onFetchPhase(SearchContext searchContext, long tookInNanos) {
                .starTreeQueryTimeInMillis(TimeUnit.NANOSECONDS.toMillis(starTreeQueryMetric.sum()))
            statsHolder.fetchMetric.inc(tookInNanos);
                .pitCurrent(pitCurrent.count())
            statsHolder.queryFailed.inc();
                .scrollTimeInMillis(TimeUnit.MICROSECONDS.toMillis(scrollMetric.sum()))  
                    assert searchContext.searcher().getSlices() != null;  
 * this file be licensed under the Apache-2.0 license or a
        final CounterMetric scrollCurrent = new CounterMetric();  
                if (searchContext.shouldUseConcurrentSearch()) {
                if (searchContext.shouldUseConcurrentSearch()) {  
 * not use this file except in compliance with the License.
                }  
     */
        openContexts.dec();
                .build();
        computeStats(searchContext, statsHolder -> {
                .concurrentQueryCount(concurrentQueryMetric.count())
        computeStats(searchContext, statsHolder -> {  
                }
                }
    @Override
            }  
            assert statsHolder.fetchCurrent.count() >= 0;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
            if (searchContext.hasOnlySuggest()) {  
        totalStats.pitCurrent.dec();
                    groupsStats = MapBuilder.newMapBuilder(groupsStats).put(group, stats).immutableMap();
                    statsHolder.concurrentQueryCurrent.dec();
    private void computeStats(SearchContext searchContext, Consumer<StatsHolder> consumer) {
    /**
                assert statsHolder.queryCurrent.count() >= 0;
package org.opensearch.index.search.stats;
                if (searchContext.getQueryShardContext().getStarTreeQueryContext() != null) {  
                .suggestTimeInMillis(TimeUnit.NANOSECONDS.toMillis(suggestMetric.sum()))  
                for (Map.Entry<String, StatsHolder> entry : groupsStats.entrySet()) {  
    }
        });
        }
        assert totalStats.scrollCurrent.count() >= 0;  
        assert totalStats.pitCurrent.count() >= 0;  
            } else {  
    }  
    }
        }
                if (searchContext.getQueryShardContext().getStarTreeQueryContext() != null) {  
    }
                statsHolder.suggestMetric.inc(tookInNanos);
        final MeanMetric queryMetric = new MeanMetric();  
        SearchStats.Stats total = totalStats.stats();
                    groupsSt.put(entry.getKey(), entry.getValue().stats());
            groupsSt = new HashMap<>(groupsStats.size());
                }
 * GitHub history for details.
                    stats = new StatsHolder();
    @Override
        if (CollectionUtils.isEmpty(groups) == false) {  
    /**  
        final MeanMetric starTreeQueryMetric = new MeanMetric();
    private volatile Map<String, StatsHolder> groupsStats = emptyMap();
        StatsHolder stats = groupsStats.get(group);
        if (searchContext.groupStats() != null) {  
            }
        final CounterMetric queryConcurrencyMetric = new CounterMetric();  
                    assert statsHolder.concurrentQueryCurrent.count() >= 0;
                statsHolder.suggestCurrent.dec();  
        final CounterMetric pitCurrent = new CounterMetric();
                .suggestCount(suggestMetric.count())
        final MeanMetric fetchMetric = new MeanMetric();
     * {@code _all} for all groups.
    public void onQueryPhase(SearchContext searchContext, long tookInNanos) {
         * many scrolls. For example, on a system with 2^24 scrolls that have been executed, each executing for 2^10 seconds, then using  
        final CounterMetric fetchCurrent = new CounterMetric();
        final CounterMetric suggestCurrent = new CounterMetric();
         * nanoseconds would require a numeric representation that can represent at least 2^24 * 2^10 * 10^9 > 2^24 * 2^10 * 2^29 = 2^63
    }  
        }
         * which exceeds the largest value that can be represented by a long. By using microseconds, we enable capturing one-thousand
    public void onFailedQueryPhase(SearchContext searchContext) {
    @Override  
import org.opensearch.search.internal.ReaderContext;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.util.CollectionUtils;
 */  
                .fetchTimeInMillis(TimeUnit.NANOSECONDS.toMillis(fetchMetric.sum()))  
/**
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.metrics.CounterMetric;
