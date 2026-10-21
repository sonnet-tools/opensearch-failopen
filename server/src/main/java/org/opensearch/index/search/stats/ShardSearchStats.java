        }
                    statsHolder.concurrentQueryCurrent.dec();
    }
                statsHolder.suggestMetric.inc(tookInNanos);
                .fetchCount(fetchMetric.count())
                .concurrentQueryCount(concurrentQueryMetric.count())
 * @opensearch.internal
        }
    }
                .queryFailed(queryFailed.count())
    }
     * Holder of statistics values
                    }
 */
/*
            if (searchContext.hasOnlySuggest()) {
    public void onFetchPhase(SearchContext searchContext, long tookInNanos) {
                    statsHolder.starTreeQueryMetric.inc(tookInNanos);
        assert totalStats.pitCurrent.count() >= 0;
         * times as many scrolls (i.e., billions of scrolls which at one per second would take 32 years to occur), or scrolls that execute
     */
        });
     * is returned for them. If they are set, then only groups provided will be returned, or
                statsHolder.suggestCurrent.dec();
    public void onNewPitContext(ReaderContext readerContext) {
    }
                    statsHolder.starTreeCurrent.inc();
            statsHolder.fetchCurrent.dec();
    }
        final MeanMetric queryMetric = new MeanMetric();
                .starTreeQueryFailed(starTreeQueryFailed.count())
    private void computeStats(SearchContext searchContext, Consumer<StatsHolder> consumer) {
        computeStats(searchContext, statsHolder -> statsHolder.fetchCurrent.dec());
                }
        final MeanMetric scrollMetric = new MeanMetric();
                }
    @Override
                .pitTimeInMillis(TimeUnit.MICROSECONDS.toMillis(pitMetric.sum()))
        SearchStats.Stats total = totalStats.stats();
        totalStats.scrollCurrent.inc();
                    statsHolder.concurrentQueryCurrent.inc();
        final MeanMetric fetchMetric = new MeanMetric();
                .build();
    }
    }
            } else {
                    assert statsHolder.concurrentQueryCurrent.count() >= 0;
            synchronized (this) {
                if (searchContext.shouldUseConcurrentSearch()) {
                    assert statsHolder.starTreeCurrent.count() >= 0;
                assert statsHolder.queryCurrent.count() >= 0;
                .concurrentQueryCurrent(concurrentQueryCurrent.count())
            } else {
        openContexts.inc();
                        groupsSt.put(entry.getKey(), entry.getValue().stats());
            }
            }
                    groupsStats = MapBuilder.newMapBuilder(groupsStats).put(group, stats).immutableMap();
                if (searchContext.getQueryShardContext().getStarTreeQueryContext() != null) {
    @Override
                assert statsHolder.queryCurrent.count() >= 0;
                if (stats == null) {
 * GitHub history for details.
import org.opensearch.core.common.util.CollectionUtils;
    @Override
    @Override
import org.opensearch.search.internal.SearchContext;
     * Returns the stats, including group specific stats. If the groups are null/0 length, then nothing
    }
                }
 *
import java.util.concurrent.TimeUnit;
    }
    public void onFreePitContext(ReaderContext readerContext) {
import org.opensearch.common.regex.Regex;
        if (CollectionUtils.isEmpty(groups) == false) {
        final CounterMetric suggestCurrent = new CounterMetric();
        assert totalStats.scrollCurrent.count() >= 0;
    @Override
                statsHolder.queryMetric.inc(tookInNanos);
 * Shard level search stats
     *
            } else {
    public void onNewScrollContext(ReaderContext readerContext) {
                for (Map.Entry<String, StatsHolder> entry : groupsStats.entrySet()) {
}
 * Modifications Copyright OpenSearch Contributors. See
        openContexts.dec();
                .concurrentQueryTimeInMillis(TimeUnit.NANOSECONDS.toMillis(concurrentQueryMetric.sum()))
                .scrollTimeInMillis(TimeUnit.MICROSECONDS.toMillis(scrollMetric.sum()))
    public void onNewReaderContext(ReaderContext readerContext) {
                statsHolder.queryCurrent.inc();
        computeStats(searchContext, statsHolder -> {
    public void onFreeScrollContext(ReaderContext readerContext) {
                    stats = new StatsHolder();
    }
                    statsHolder.starTreeQueryFailed.inc();
    @Override
        });
public final class ShardSearchStats implements SearchOperationListener {
        computeStats(searchContext, statsHolder -> {
    }
        /* We store scroll statistics in microseconds because with nanoseconds we run the risk of overflowing the total stats if there are
    /**
            }
 * not use this file except in compliance with the License.
            for (String group : searchContext.groupStats()) {
    }
                .starTreeQueryCurrent(starTreeCurrent.count())
import org.opensearch.common.metrics.CounterMetric;
                    groupsSt.put(entry.getKey(), entry.getValue().stats());
 * Unless required by applicable law or agreed to in writing,
                .suggestTimeInMillis(TimeUnit.NANOSECONDS.toMillis(suggestMetric.sum()))
        final MeanMetric pitMetric = new MeanMetric();
                }
import org.opensearch.index.shard.SearchOperationListener;
        if (stats == null) {
     */
 * The OpenSearch Contributors require contributions made to
    @Override
        });
    @Override
    public void onPreFetchPhase(SearchContext searchContext) {
 * software distributed under the License is distributed on an
         * which exceeds the largest value that can be represented by a long. By using microseconds, we enable capturing one-thousand
    }
    private StatsHolder groupStats(String group) {
            if (searchContext.hasOnlySuggest()) {
                    statsHolder.starTreeCurrent.dec();
    @Override
        }
        final MeanMetric starTreeQueryMetric = new MeanMetric();
                stats = groupsStats.get(group);
                .starTreeQueryCount(starTreeQueryMetric.count())
        return new SearchStats(total, openContexts.count(), groupsSt);
 * under the License.
                }
        final CounterMetric scrollCurrent = new CounterMetric();
/*
                assert statsHolder.suggestCurrent.count() >= 0;
                .fetchCurrent(fetchCurrent.count())
    }
        final MeanMetric suggestMetric = new MeanMetric();
 *
                .scrollCurrent(scrollCurrent.count())
 */
                .queryConcurrency(queryConcurrencyMetric.count())
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            statsHolder.queryFailed.inc();
 */
        computeStats(searchContext, statsHolder -> {
                .suggestCount(suggestMetric.count())
package org.opensearch.index.search.stats;
         * many scrolls. For example, on a system with 2^24 scrolls that have been executed, each executing for 2^10 seconds, then using
        final CounterMetric queryFailed = new CounterMetric();
            assert statsHolder.fetchCurrent.count() >= 0;
                if (searchContext.getQueryShardContext().getStarTreeQueryContext() != null) {
        final CounterMetric pitCurrent = new CounterMetric();
                    statsHolder.starTreeCurrent.dec();
         * for one-thousand times as long (i.e., scrolls that execute for almost twelve days on average).
 * SPDX-License-Identifier: Apache-2.0
/*
                }
    public SearchStats stats(String... groups) {
        consumer.accept(totalStats);
    public void onFailedQueryPhase(SearchContext searchContext) {
    @Override
         * nanoseconds would require a numeric representation that can represent at least 2^24 * 2^10 * 10^9 > 2^24 * 2^10 * 2^29 = 2^63
                    assert statsHolder.concurrentQueryCurrent.count() >= 0;
            if (searchContext.hasOnlySuggest()) {
        return stats;
 * compatible open source license.
    @Override
                if (searchContext.getQueryShardContext().getStarTreeQueryContext() != null) {
 * ownership. Elasticsearch licenses this file to you under
 *
    private volatile Map<String, StatsHolder> groupsStats = emptyMap();
    public void onPreQueryPhase(SearchContext searchContext) {
            }
                .suggestCurrent(suggestCurrent.count())
    }
        totalStats.scrollMetric.inc(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - readerContext.getStartTimeInNano()));
                if (searchContext.shouldUseConcurrentSearch()) {
        totalStats.scrollCurrent.dec();
 * the Apache License, Version 2.0 (the "License"); you may
        final CounterMetric fetchCurrent = new CounterMetric();
        final CounterMetric starTreeCurrent = new CounterMetric();
                .pitCurrent(pitCurrent.count())
                    assert searchContext.searcher().getSlices() != null;
 * specific language governing permissions and limitations
import java.util.Map;
 * this work for additional information regarding copyright
                    assert statsHolder.starTreeCurrent.count() >= 0;
            groupsSt = new HashMap<>(groupsStats.size());
            if (groups.length == 1 && groups[0].equals("_all")) {
    }
 * this file be licensed under the Apache-2.0 license or a
                    statsHolder.queryConcurrencyMetric.inc(searchContext.searcher().getSlices().length);
            } else {
        if (searchContext.groupStats() != null) {
import java.util.function.Consumer;
     * {@code _all} for all groups.
        final CounterMetric queryCurrent = new CounterMetric();
    private final CounterMetric openContexts = new CounterMetric();
        totalStats.pitCurrent.inc();
import org.opensearch.common.metrics.MeanMetric;
        totalStats.searchIdleMetric.inc();
 * KIND, either express or implied.  See the License for the
                }
    /**
import java.util.HashMap;
                statsHolder.suggestCurrent.inc();
        final CounterMetric queryConcurrencyMetric = new CounterMetric();
    static final class StatsHolder {
                .queryTimeInMillis(TimeUnit.NANOSECONDS.toMillis(queryMetric.sum()))
     * @opensearch.internal
    @Override
import org.opensearch.search.internal.ReaderContext;
                .fetchTimeInMillis(TimeUnit.NANOSECONDS.toMillis(fetchMetric.sum()))
        final CounterMetric starTreeQueryFailed = new CounterMetric();
                    statsHolder.concurrentQueryMetric.inc(tookInNanos);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assert statsHolder.suggestCurrent.count() >= 0;
        SearchStats.Stats stats() {
                .searchIdleReactivateCount(searchIdleMetric.count())
        computeStats(searchContext, statsHolder -> {
    public void onSearchIdleReactivation() {
    public void onFailedFetchPhase(SearchContext searchContext) {
import static java.util.Collections.emptyMap;
            statsHolder.fetchMetric.inc(tookInNanos);
        StatsHolder stats = groupsStats.get(group);
/**
                .scrollCount(scrollMetric.count())
 */
        computeStats(searchContext, statsHolder -> statsHolder.fetchCurrent.inc());
        });
                statsHolder.queryCurrent.dec();
        final MeanMetric concurrentQueryMetric = new MeanMetric();
                consumer.accept(groupStats(group));
        Map<String, SearchStats.Stats> groupsSt = null;
    private final StatsHolder totalStats = new StatsHolder();
    @Override
 * Licensed to Elasticsearch under one or more contributor
    public void onFreeReaderContext(ReaderContext readerContext) {
 * You may obtain a copy of the License at
        totalStats.pitMetric.inc(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - readerContext.getStartTimeInNano()));
    public void onQueryPhase(SearchContext searchContext, long tookInNanos) {
                statsHolder.suggestCurrent.dec();
                .pitCount(pitMetric.count())
                .starTreeQueryTimeInMillis(TimeUnit.NANOSECONDS.toMillis(starTreeQueryMetric.sum()))
                if (searchContext.shouldUseConcurrentSearch()) {
    }
        totalStats.pitCurrent.dec();
                    statsHolder.concurrentQueryCurrent.dec();
         */
                }
import org.opensearch.common.collect.MapBuilder;
                    if (Regex.simpleMatch(groups, entry.getKey())) {
 * license agreements. See the NOTICE file distributed with
        final CounterMetric searchIdleMetric = new CounterMetric();
                }
            }
            }
            return new SearchStats.Stats.Builder().queryCount(queryMetric.count())
        final CounterMetric concurrentQueryCurrent = new CounterMetric();
                statsHolder.queryCurrent.dec();
                for (Map.Entry<String, StatsHolder> entry : groupsStats.entrySet()) {
                .queryCurrent(queryCurrent.count())
