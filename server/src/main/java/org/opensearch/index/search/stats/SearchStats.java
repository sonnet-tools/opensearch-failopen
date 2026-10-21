    @Override
            return concurrentQueryTimeInMillis;
            this.total = total;
        }
            queryTimeInMillis += stats.queryTimeInMillis;
            }
     * @opensearch.api
            }
            suggestCount += stats.suggestCount;
 * license agreements. See the NOTICE file distributed with
            }
        static final String CURRENT = "current";
            }
            public Builder starTreeQueryCount(long count) {
            out.writeVLong(fetchCount);
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
    /**
            }
            return scrollCurrent;
            private long suggestCurrent = 0;
            public Builder suggestCount(long count) {
                this.scrollCurrent = current;
        PhaseStatsLongHolder(long current, long total, long timeInMillis) {
        public long getTotal() {
                out.writeVLong(queryConcurrency);
            searchIdleReactivateCount += stats.searchIdleReactivateCount;
        );
            long suggestCount,
        static final String CONCURRENT_QUERY_CURRENT = "concurrent_query_current";
                        PhaseStatsLongHolder.logger.warn(
        }
                out.writeVLong(starTreeQueryCount);
        if (in.readBoolean()) {
        totalStats.requestStatsLongHolder.requestStatsHolder.put(
                return this;
                    searchRequestStats.getPhaseCurrent(searchPhaseName),
        static final String STARTREE_QUERY_TIME_IN_MILLIS = "startree_query_time_in_millis";
                return 0;
    public Map<String, Stats> getGroupStats() {
        public long getStarTreeQueryTimeInMillis() {
            }
            }
            }
                return new Stats(this);
    }
 * not use this file except in compliance with the License.
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        static final String FETCH_TIME_IN_MILLIS = "fetch_time_in_millis";
/*
            this.concurrentQueryCount = builder.concurrentQueryCount;
        }
            this(0, 0, 0);
        if (groupStats == null || groupStats.isEmpty()) {
            return new TimeValue(starTreeQueryTimeInMillis);
            }
                    PhaseStatsLongHolder statsLongHolder = requestStatsLongHolder.requestStatsHolder.get(searchPhaseName.getName());
                searchRequestStats.getTookTotal(),
                    builder.field(Fields.TOTAL, statsLongHolder.total);
}
     */
            queryCount += stats.queryCount;
                queryConcurrency = in.readVLong();
 *
            long concurrentQueryTimeInMillis,
        private long queryFailedCount;
        public Stats(
            }
            out.writeVLong(suggestCurrent);
        /**
                if (requestStatsLongHolder == null) {
            fetchTimeInMillis += stats.fetchTimeInMillis;
        static final String FETCH_TIME = "fetch_time";
                builder.endObject();
import org.opensearch.core.common.io.stream.Writeable;
                out.writeVLong(starTreeQueryFailed);
        public long getCurrent() {
        }
            return;
        public long getPitCount() {
            long queryCurrent,
        static final String QUERY_TIME_IN_MILLIS = "query_time_in_millis";
            return starTreeQueryTimeInMillis;
            public Builder starTreeQueryTimeInMillis(long time) {
        ) {
            return searchIdleReactivateCount;
 * @opensearch.api
                    searchRequestStats.getPhaseTotal(searchPhaseName),
        private Stats(Builder builder) {
            return queryTimeInMillis;
                out.writeVLong(pitCurrent);
            }
        private long fetchCount;
            this.queryTimeInMillis = queryTimeInMillis;
            this.suggestTimeInMillis = suggestTimeInMillis;
                }
        private long scrollCurrent;
                    StreamOutput::writeString,
        }
        static final String SCROLL_TOTAL = "scroll_total";
            out.writeBoolean(false);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                this.queryTimeInMillis = time;
            queryConcurrency += stats.queryConcurrency;
        private long concurrentQueryTimeInMillis;
            out.writeVLong(scrollCurrent);
            scrollCount += stats.scrollCount;
            }
        private long pitCount;
                    builder.field(Fields.CURRENT, tookStatsLongHolder.current);
        }
                this.pitCurrent = current;
            out.writeVLong(fetchTimeInMillis);
                this.starTreeQueryCurrent = current;
            return timeInMillis;
        totalStats.toXContent(builder, params);
            out.writeVLong(scrollTimeInMillis);
            builder.humanReadableField(Fields.QUERY_TIME_IN_MILLIS, Fields.QUERY_TIME, getQueryTime());
        }
        Stats() {
            )
            if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
                out.writeVLong(0);
import org.opensearch.core.common.io.stream.StreamInput;
            long fetchCount,
            this.queryCurrent = queryCurrent;
            long pitCount,
        private long queryConcurrency;
        private Stats(StreamInput in) throws IOException {
            this.scrollTimeInMillis = scrollTimeInMillis;
        if (searchStats.groupStats != null && !searchStats.groupStats.isEmpty()) {
                out.writeVLong(pitTimeInMillis);
        private long fetchTimeInMillis;
            private long queryConcurrency = 0;
        }
                return this;
            builder.field(Fields.FETCH_TOTAL, fetchCount);
                this.suggestTimeInMillis = time;
                this.queryCount = count;
            private long pitCurrent = 0;
            long searchIdleReactivateCount
        }
            public Builder pitTimeInMillis(long time) {
                this.scrollCount = count;
        totalStats = Stats.readStats(in);
        static final String STARTREE_QUERY_TIME = "startree_query_time";
        static final String TOOK = "took";
                    requestStatsLongHolder = new RequestStatsLongHolder();
            builder.startObject(Fields.GROUPS);
        private RequestStatsLongHolder requestStatsLongHolder;
        public TimeValue getSuggestTime() {
            builder.humanReadableField(Fields.SCROLL_TIME_IN_MILLIS, Fields.SCROLL_TIME, getScrollTime());
                    }
        }
            searchIdleReactivateCount += stats.searchIdleReactivateCount;
        totalStats.writeTo(out);
            public Builder suggestTimeInMillis(long time) {
        }
        // Set took stats
            builder.field(Fields.QUERY_CURRENT, queryCurrent);
import org.opensearch.common.unit.TimeValue;
        }
            return new TimeValue(scrollTimeInMillis);
 * software distributed under the License is distributed on an
    @Override
            scrollCurrent = in.readVLong();
    public SearchStats(Stats totalStats, long openContexts, @Nullable Map<String, Stats> groupStats) {
            this.starTreeQueryTimeInMillis = builder.starTreeQueryTimeInMillis;
            this.queryCount = builder.queryCount;
            return;
                return this;
            this.suggestTimeInMillis = builder.suggestTimeInMillis;
            this.fetchCurrent = builder.fetchCurrent;
                out.writeVLong(current);
            Fields.TOOK,
            return builder;
            long suggestTimeInMillis,
        public void addForClosingShard(Stats stats) {
                        continue;
            return queryCurrent;
                for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
package org.opensearch.index.search.stats;
        }
import org.apache.logging.log4j.LogManager;
 *
        public static Stats readStats(StreamInput in) throws IOException {
            builder.field(Fields.QUERY_FAILED_TOTAL, queryFailedCount);
        }
            this.concurrentQueryCount = concurrentQueryCount;
                    builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, new TimeValue(statsLongHolder.timeInMillis));
            public Builder starTreeQueryCurrent(long current) {
            if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
        }
            }
    @Override
            this.requestStatsLongHolder = new RequestStatsLongHolder();
 * SPDX-License-Identifier: Apache-2.0
 * under the License.
        }
            scrollCount += stats.scrollCount;
        }
            public Builder concurrentQueryCurrent(long current) {
                    builder.field(Fields.TOTAL, tookStatsLongHolder.total);
     * Holds statistic values for a particular phase.
            return queryFailedCount;
    public void add(SearchStats searchStats) {
        public TimeValue getScrollTime() {
            this.pitCount = builder.pitCount;
        public long getSuggestCount() {
            fetchCount += stats.fetchCount;
        }
            }
            fetchCount = in.readVLong();
        }
 * You may obtain a copy of the License at
        }
            private long concurrentQueryCount = 0;
        }
        }
            this.concurrentQueryCurrent = concurrentQueryCurrent;
                out.writeMap(
            builder.field(Fields.FETCH_CURRENT, fetchCurrent);
                this.pitTimeInMillis = time;
        static final String STARTREE_QUERY_TOTAL = "startree_query_total";
        @Override
                return this;
                this.starTreeQueryTimeInMillis = time;
    public void writeTo(StreamOutput out) throws IOException {
        }
        builder.startObject(Fields.SEARCH);
            }
        public long getConcurrentQueryCurrent() {
            fetchCurrent += stats.fetchCurrent;
                searchPhaseName.getName(),
        public TimeValue getStarTreeQueryTime() {
        static final String SEARCH_IDLE_REACTIVATE_COUNT_TOTAL = "search_idle_reactivate_count_total";
            private long pitTimeInMillis = 0;
            groupStats = in.readMap(StreamInput::readString, Stats::readStats);
    public String toString() {
            }
        static final String QUERY_TIME = "query_time";
            }
                this.queryConcurrency = concurrency;
            this.queryCount = queryCount;
                out.writeVLong(starTreeQueryTimeInMillis);
            this.current = in.readVLong();
        static final String SUGGEST_TOTAL = "suggest_total";
            }
            private long fetchTimeInMillis = 0;
    /**
import org.opensearch.core.common.Strings;
        }
            out.writeVLong(total);
    /**
            out.writeVLong(suggestCount);
            public Builder queryCount(long count) {
    }
            return new Stats(in);
            }
        @Deprecated
                    searchRequestStats.getPhaseMetric(searchPhaseName)
            this.fetchCount = builder.fetchCount;
                this.concurrentQueryTimeInMillis = time;
import org.opensearch.Version;
import org.apache.logging.log4j.Logger;
        }
            builder.field(Fields.QUERY_TOTAL, queryCount);
        openContexts = in.readVLong();
        }
            builder.field(Fields.STARTREE_QUERY_TOTAL, starTreeQueryCount);
        this.openContexts = openContexts;
            private long pitCount = 0;
                starTreeQueryCurrent = in.readVLong();
            }
            return pitTimeInMillis;
                builder.startObject(entry.getKey());
            private RequestStatsLongHolder requestStatsLongHolder = null;
            }
         * This is the sole entry point for creating a new Stats object.
 * KIND, either express or implied.  See the License for the
            this.timeInMillis = timeInMillis;
        }
                return this;
            return scrollCount;
 *
        public long getQueryFailedCount() {
            suggestTimeInMillis += stats.suggestTimeInMillis;
     * @opensearch.internal
import java.util.Collections;
            return suggestCurrent;
                this.starTreeQueryFailed = count;
        private long concurrentQueryCurrent;
            this.suggestCount = suggestCount;
        public long getScrollCount() {
        public long getScrollTimeInMillis() {
            queryTimeInMillis += stats.queryTimeInMillis;
                });
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        totalStats.add(searchStats.totalStats);
        static final String REQUEST = "request";
            private long scrollTimeInMillis = 0;
                this.fetchTimeInMillis = time;
            starTreeQueryTimeInMillis += stats.starTreeQueryTimeInMillis;
 * Encapsulates stats for search time
    }
            this.starTreeQueryCurrent = builder.starTreeQueryCurrent;
            public Builder starTreeQueryFailed(long count) {
        }
/*
            return fetchCount;
import java.util.HashMap;
            queryCurrent += stats.queryCurrent;
            if (out.getVersion().onOrAfter(Version.V_2_14_0)) {
            return pitCurrent;
            this.pitCurrent = pitCurrent;
            return concurrentQueryCount;
                return this;
                new PhaseStatsLongHolder(
        public long getConcurrentQueryCount() {
                            phaseStats.current
    }
        static final String TOTAL = "total";
        PhaseStatsLongHolder() {
        if (searchStats == null) {
     */
    }
            new PhaseStatsLongHolder(
         * Provides a fluent API for constructing a Stats object.
            scrollTimeInMillis = in.readVLong();
         */
            suggestTimeInMillis += stats.suggestTimeInMillis;
        static final String PIT_CURRENT = "point_in_time_current";
    public static class RequestStatsLongHolder {
            this.concurrentQueryTimeInMillis = builder.concurrentQueryTimeInMillis;
            scrollTimeInMillis += stats.scrollTimeInMillis;
            }
        static final String SCROLL_CURRENT = "scroll_current";
                return this;
            long concurrentQueryCount,
                return this;
            public Builder scrollCount(long count) {
            this.queryConcurrency = builder.queryConcurrency;
                return this;
        public void add(Stats stats) {
            long scrollTimeInMillis,
            fetchCurrent = in.readVLong();
            this.pitCount = pitCount;
/*
            private long fetchCount = 0;
            if (current < 0) {
            return starTreeQueryFailed;
                out.writeVLong(concurrentQueryCount);
    /**
            if (out.getVersion().onOrAfter(Version.V_3_3_0)) {
                this.scrollTimeInMillis = time;
        }
            if (out.getVersion().onOrAfter(Version.V_2_4_0)) {
            out.writeVLong(suggestTimeInMillis);
                out.writeVLong(concurrentQueryCurrent);
        }
        public TimeValue getPitTime() {
     * @opensearch.api
            totalStats.requestStatsLongHolder.requestStatsHolder.put(
        static final String PIT_TIME = "point_in_time_time";
                concurrentQueryTimeInMillis = in.readVLong();
            this.queryCurrent = builder.queryCurrent;
            queryConcurrency += stats.queryConcurrency;
                concurrentQueryCount = in.readVLong();
        }
        RequestStatsLongHolder() {
 * compatible open source license.
            long pitCurrent,
            for (Map.Entry<String, Stats> entry : searchStats.groupStats.entrySet()) {
        return this.openContexts;
 *    http://www.apache.org/licenses/LICENSE-2.0
        static final String SUGGEST_TIME_IN_MILLIS = "suggest_time_in_millis";
            long queryConcurrency,
import org.opensearch.action.search.SearchPhaseName;
                requestStatsLongHolder.requestStatsHolder = in.readMap(StreamInput::readString, PhaseStatsLongHolder::new);
        static final String SCROLL_TIME_IN_MILLIS = "scroll_time_in_millis";
            starTreeQueryFailed += stats.starTreeQueryFailed;
        static final String QUERY_FAILED_TOTAL = "query_failed";
    @Nullable
                this.concurrentQueryCount = count;
                queryFailedCount = in.readVLong();
            scrollCurrent += stats.scrollCurrent;
                this.suggestCount = count;
            return requestStatsLongHolder;
            builder.field(Fields.PIT_CURRENT, pitCurrent);
        }
    // Set the different Request Stats fields in here
        long timeInMillis;
            suggestCurrent += stats.suggestCurrent;
            concurrentQueryCurrent += stats.concurrentQueryCurrent;
        }
     *
import java.io.IOException;
     */
         * Private constructor that takes a builder.
         */
        // Set phase stats
 */
        static final String STARTREE_QUERY_CURRENT = "startree_query_current";
     * Holder of statistics values
            public Builder scrollCurrent(long current) {
        builder.field(Fields.OPEN_CONTEXTS, openContexts);
                    builder.endObject();
        builder.endObject();
            scrollCount = in.readVLong();
            long fetchTimeInMillis,
     *
            out.writeVLong(timeInMillis);
                this.concurrentQueryCurrent = current;
                )
    private long openContexts;
            return suggestCount;
            public Builder concurrentQueryTimeInMillis(long time) {
            this.current = current;
        static final String CONCURRENT_QUERY_TOTAL = "concurrent_query_total";
        }
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        }
 * Licensed to Elasticsearch under one or more contributor
        }
                starTreeQueryTimeInMillis = in.readVLong();
            fetchTimeInMillis += stats.fetchTimeInMillis;
            return suggestTimeInMillis;
        if (searchStats == null) {
            }
                return this;
        }
                builder.endObject();
        public Map<String, PhaseStatsLongHolder> getRequestStatsHolder() {
        }
    @PublicApi(since = "1.0.0")
            this.searchIdleReactivateCount = builder.searchIdleReactivateCount;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return new TimeValue(queryTimeInMillis);
    public Stats getTotal() {
            return starTreeQueryCurrent;
                if (tookStatsLongHolder != null) {
            private long queryTimeInMillis = 0;
        static final String QUERY_TOTAL = "query_total";
            return new TimeValue(pitTimeInMillis);
        public void writeTo(StreamOutput out) throws IOException {
        static final String SEARCH = "search";
                this.pitCount = count;
            long pitTimeInMillis,
            );
                    requestStatsLongHolder.getRequestStatsHolder(),
    }
        static final String PIT_TOTAL = "point_in_time_total";
            builder.humanReadableField(Fields.STARTREE_QUERY_TIME_IN_MILLIS, Fields.STARTREE_QUERY_TIME, getStarTreeQueryTime());
        long total;
            private long searchIdleReactivateCount = 0;
 * ownership. Elasticsearch licenses this file to you under
    private Map<String, Stats> groupStats;
        /**
        public long getScrollCurrent() {
        }
        public TimeValue getConcurrentQueryTime() {
                return this;
                starTreeQueryCount = in.readVLong();
         * This constructor will be deprecated in 4.0
        public long getFetchTimeInMillis() {
            }
        @Nullable
            totalStats.requestStatsLongHolder = new RequestStatsLongHolder();
                            phaseName,
            public Builder fetchCount(long count) {
            return;
            private long fetchCurrent = 0;
                        );
            private long scrollCurrent = 0;
            public Builder queryCurrent(long current) {
                groupStats.get(entry.getKey()).add(entry.getValue());
            }
import org.opensearch.core.common.io.stream.StreamOutput;
            return fetchTimeInMillis;
        public TimeValue getFetchTime() {
            this.pitTimeInMillis = builder.pitTimeInMillis;
            pitCount += stats.pitCount;
            private long starTreeQueryFailed = 0;
        PhaseStatsLongHolder(StreamInput in) throws IOException {
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        private long starTreeQueryFailed;
        private long suggestCurrent;
            public Builder queryConcurrency(long concurrency) {
        /**
        static final String FETCH_TOTAL = "fetch_total";
            queryFailedCount += stats.queryFailedCount;
                return this;
            this.total = in.readVLong();
            suggestCount += stats.suggestCount;
            public Builder pitCurrent(long current) {
            private long starTreeQueryCount = 0;
                return this;
        public long getQueryCurrent() {
     *
import org.opensearch.common.Nullable;
            return new TimeValue(fetchTimeInMillis);
            builder.humanReadableField(Fields.SUGGEST_TIME_IN_MILLIS, Fields.SUGGEST_TIME, getSuggestTime());
    public SearchStats(StreamInput in) throws IOException {
            private long queryCount = 0;
                pitTimeInMillis = in.readVLong();
        public long getPitTimeInMillis() {
         * Use Builder to create Stats object
     */
                this.queryFailedCount = count;
            scrollCount += stats.scrollCurrent;
            }
                out.writeVLong(queryFailedCount);
            this.fetchTimeInMillis = fetchTimeInMillis;
         */
        }
                searchIdleReactivateCount = in.readVLong();
        static final String GROUPS = "groups";
import org.opensearch.core.xcontent.ToXContent;
    }
            this.queryConcurrency = queryConcurrency;
        }
            suggestCount = in.readVLong();
        private long pitTimeInMillis;
            }
                }
        static final String PIT_TIME_IN_MILLIS = "point_in_time_time_in_millis";
            this.suggestCurrent = builder.suggestCurrent;
                    builder.endObject();
            private long queryFailedCount = 0;
            }
            this.starTreeQueryFailed = builder.starTreeQueryFailed;
import org.opensearch.core.xcontent.ToXContentFragment;
            starTreeQueryCount += stats.starTreeQueryCount;
            this.scrollTimeInMillis = builder.scrollTimeInMillis;
        public long getFetchCount() {
        static final String CONCURRENT_AVG_SLICE_COUNT = "concurrent_avg_slice_count";
 * this work for additional information regarding copyright
                return this;
    public static class PhaseStatsLongHolder implements Writeable {
                this.fetchCount = count;
            this.queryTimeInMillis = builder.queryTimeInMillis;
            }
            private long starTreeQueryTimeInMillis = 0;
    @Nullable
                searchRequestStats.getTookCurrent(),
            public Builder suggestCurrent(long current) {
    private final Stats totalStats;
            public Builder fetchCurrent(long current) {
            queryFailedCount += stats.queryFailedCount;
            public Stats build() {
            out.writeVLong(fetchCurrent);
        public long getTimeInMillis() {
        }
 * this file be licensed under the Apache-2.0 license or a
    }
            }
            private long starTreeQueryCurrent = 0;
            this.searchIdleReactivateCount = searchIdleReactivateCount;
        if (groupStats != null && !groupStats.isEmpty()) {
            this.fetchTimeInMillis = builder.fetchTimeInMillis;
        }
        return this.totalStats;
            concurrentQueryTimeInMillis += stats.concurrentQueryTimeInMillis;
                return this;
        public long getStarTreeQueryCurrent() {
        }
            fetchCount += stats.fetchCount;
                out.writeVLong(searchIdleReactivateCount);
        public TimeValue getQueryTime() {
                return this;
                return this;
            suggestCurrent = in.readVLong();
            out.writeVLong(scrollCount);
        private long searchIdleReactivateCount;
                    }
            starTreeQueryCurrent += stats.starTreeQueryCurrent;
                this.queryCurrent = current;
            }
/**
    public static class Stats implements Writeable, ToXContentFragment {
            }
        public long getSearchIdleReactivateCount() {
            pitCurrent += stats.pitCurrent;
            starTreeQueryCount += stats.starTreeQueryCount;
            public Builder pitCount(long count) {
            private long suggestCount = 0;
        return builder;
import java.util.Map;
            this.concurrentQueryTimeInMillis = concurrentQueryTimeInMillis;
        private long queryCount;
        }
                return this;
        private long queryCurrent;
            if (in.getVersion().onOrAfter(Version.V_2_4_0)) {
                    builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, new TimeValue(tookStatsLongHolder.timeInMillis));
            if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
                this.fetchCurrent = current;
        out.writeVLong(openContexts);
            // need consider the count of the shard's current scroll
                    builder.field(Fields.CURRENT, statsLongHolder.current);
     *
            public Builder() {}
            }
            }
        if (searchStats == null) {
        }
            this.pitCurrent = builder.pitCurrent;
            }
@PublicApi(since = "1.0.0")
            builder.field(Fields.CONCURRENT_QUERY_TOTAL, concurrentQueryCount);
            concurrentQueryCount += stats.concurrentQueryCount;
        totalStats = new Stats();
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
        @Override
        long current;
            } else {
            private long concurrentQueryTimeInMillis = 0;
        }
            requestStatsHolder.put(Fields.TOOK, new PhaseStatsLongHolder());
            this.scrollCurrent = scrollCurrent;
    }
                this.searchIdleReactivateCount = count;
                return this;
     * Fields for search statistics
        public long getSuggestTimeInMillis() {
            return new TimeValue(suggestTimeInMillis);
            if (in.getVersion().onOrAfter(Version.V_2_14_0)) {
        public static class Builder {
    }
        this.groupStats = groupStats;
         * @param builder The builder instance containing all the values.
        public long getStarTreeQueryFailed() {
        return this.groupStats != null ? Collections.unmodifiableMap(this.groupStats) : null;
            builder.field(Fields.SUGGEST_CURRENT, suggestCurrent);
            out.writeVLong(queryCount);
            }
                return this;
        private long starTreeQueryCurrent;
    }
        } else {
                    if (phaseStats.current < 0) {
        public long getSuggestCurrent() {
        static final String SUGGEST_TIME = "suggest_time";
        static final String FETCH_CURRENT = "fetch_current";
            queryTimeInMillis = in.readVLong();
            return scrollTimeInMillis;
            queryCount = in.readVLong();
            return fetchCurrent;
                    builder.startObject(searchPhaseName.getName());
            pitTimeInMillis += stats.pitTimeInMillis;
            for (Map.Entry<String, Stats> entry : groupStats.entrySet()) {
            long fetchCurrent,
        private long starTreeQueryTimeInMillis;
     * @opensearch.api
            builder.humanReadableField(Fields.PIT_TIME_IN_MILLIS, Fields.PIT_TIME, getPitTime());
            } else {
            builder.field(Fields.SCROLL_TOTAL, scrollCount);
 * specific language governing permissions and limitations
            builder.field(Fields.CONCURRENT_QUERY_CURRENT, concurrentQueryCurrent);
            this.timeInMillis = in.readVLong();
            fetchTimeInMillis = in.readVLong();
                );
        }
        }
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing,
                pitCount = in.readVLong();
        private long pitCurrent;
            if (out.getVersion().onOrAfter(Version.V_2_11_0)) {
            this.fetchCount = fetchCount;
         * Builder for the {@link Stats} class.
                out.writeVLong(starTreeQueryCurrent);
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
    static final class Fields {
        }
            }
                    (stream, stats) -> stats.writeTo(stream)
        Map<String, PhaseStatsLongHolder> requestStatsHolder = new HashMap<>();
                            "SearchRequestStats 'current' is negative for phase '{}': {}",
import org.opensearch.action.search.SearchRequestStats;
            return pitCount;
        public long getStarTreeQueryCount() {
                    if (statsLongHolder == null) {
            starTreeQueryTimeInMillis += stats.starTreeQueryTimeInMillis;
            builder.field(Fields.CONCURRENT_AVG_SLICE_COUNT, getConcurrentAvgSliceCount());
 * Modifications Copyright OpenSearch Contributors. See
                groupStats.putIfAbsent(entry.getKey(), new Stats());
            @Nullable
        }
        public long getQueryTimeInMillis() {
            public Builder queryFailed(long count) {
            private long suggestTimeInMillis = 0;
 */
                requestStatsHolder.put(searchPhaseName.getName(), new PhaseStatsLongHolder());
             * Creates a {@link Stats} object from the builder's current state.
    }
            out.writeBoolean(true);
        this.totalStats = totalStats;
            if (in.getVersion().onOrAfter(Version.V_2_11_0)) {
        }
        public long getConcurrentQueryTimeInMillis() {
                return queryConcurrency / (double) concurrentQueryCount;
        }
    @PublicApi(since = "1.0.0")
            }
        static final String QUERY_CURRENT = "query_current";
            long suggestCurrent,
                requestStatsLongHolder.requestStatsHolder.forEach((phaseName, phaseStats) -> {
        static final String OPEN_CONTEXTS = "open_contexts";
                groupStats = new HashMap<>(searchStats.groupStats.size());
                PhaseStatsLongHolder tookStatsLongHolder = requestStatsLongHolder.requestStatsHolder.get(Fields.TOOK);
            builder.humanReadableField(Fields.CONCURRENT_QUERY_TIME_IN_MILLIS, Fields.CONCURRENT_QUERY_TIME, getConcurrentQueryTime());
            this.suggestCount = builder.suggestCount;
    public void addTotalsForClosingShard(SearchStats searchStats) {
        }
     * Holds all requests stats.
        static final String TIME = "time";
            // for internal use, initializes all counts to 0
                out.writeVLong(concurrentQueryTimeInMillis);
        private static final Logger logger = LogManager.getLogger(PhaseStatsLongHolder.class);
            if (requestStatsLongHolder != null) {
             * @return A new Stats instance.
            this.starTreeQueryCount = builder.starTreeQueryCount;
                return this;
                this.starTreeQueryCount = count;
            if (concurrentQueryCount == 0) {
                pitCurrent = in.readVLong();
            suggestTimeInMillis = in.readVLong();
            }
    }
        static final String SCROLL_TIME = "scroll_time";
                }
        private long starTreeQueryCount;
                return this;
        public double getConcurrentAvgSliceCount() {
 *
            this.scrollCount = builder.scrollCount;
            this.scrollCount = scrollCount;
 */
            private long concurrentQueryCurrent = 0;
                this.suggestCurrent = current;
            this.suggestCurrent = suggestCurrent;
            private long scrollCount = 0;
        private long scrollCount;
            }
            }
    public void setSearchRequestStats(SearchRequestStats searchRequestStats) {
            this.fetchCurrent = fetchCurrent;
        private long scrollTimeInMillis;
        }
import org.opensearch.core.xcontent.XContentBuilder;
    public SearchStats() {
            }
        if (totalStats.requestStatsLongHolder == null) {
            scrollTimeInMillis += stats.scrollTimeInMillis;
                starTreeQueryFailed = in.readVLong();
            this.scrollCurrent = builder.scrollCurrent;
            builder.endObject();
        }
            out.writeVLong(queryTimeInMillis);
        static final String CONCURRENT_QUERY_TIME = "concurrent_query_time";
        private long queryTimeInMillis;
            this.queryFailedCount = builder.queryFailedCount;
        static final String STARTREE_QUERY_FAILED = "startree_query_failed";
                return this;
        private long suggestCount;
            concurrentQueryCount += stats.concurrentQueryCount;
            return starTreeQueryCount;
            long queryCount,
            return total;
             */
        totalStats.addForClosingShard(searchStats.totalStats);
    }
            out.writeMap(groupStats, StreamOutput::writeString, (stream, stats) -> stats.writeTo(stream));
        static final String CONCURRENT_QUERY_TIME_IN_MILLIS = "concurrent_query_time_in_millis";
                searchRequestStats.getTookMetric()
        }
            out.writeVLong(queryCurrent);
                entry.getValue().toXContent(builder, params);
                return this;
            builder.field(Fields.SCROLL_CURRENT, scrollCurrent);
    }
    public long getOpenContexts() {
            /**
        static final String TIME_IN_MILLIS = "time_in_millis";
        private long concurrentQueryCount;
            builder.field(Fields.SUGGEST_TOTAL, suggestCount);
            builder.field(Fields.STARTREE_QUERY_FAILED, getStarTreeQueryFailed());
                out.writeVLong(pitCount);
            long scrollCurrent,
        }
            public Builder searchIdleReactivateCount(long count) {
        public RequestStatsLongHolder getRequestStatsLongHolder() {
        public long getPitCurrent() {
            builder.field(Fields.PIT_TOTAL, pitCount);
        private long fetchCurrent;
            pitCount += stats.pitCount;
        public long getFetchCurrent() {
        addTotals(searchStats);
                concurrentQueryCurrent = in.readVLong();
        static final String SUGGEST_CURRENT = "suggest_current";
            queryCount += stats.queryCount;
            private long queryCurrent = 0;
            if (groupStats == null) {
            }
                this.requestStatsLongHolder = new RequestStatsLongHolder();
        }
        openContexts += searchStats.openContexts;
        public void writeTo(StreamOutput out) throws IOException {
            builder.humanReadableField(Fields.FETCH_TIME_IN_MILLIS, Fields.FETCH_TIME, getFetchTime());
            return queryCount;
    public void addTotals(SearchStats searchStats) {
            }
            this.pitTimeInMillis = pitTimeInMillis;
        }
                    builder.startObject(Fields.TOOK);
            public Builder scrollTimeInMillis(long time) {
            concurrentQueryTimeInMillis += stats.concurrentQueryTimeInMillis;
        @Override
            long queryTimeInMillis,
            builder.field(Fields.SEARCH_IDLE_REACTIVATE_COUNT_TOTAL, searchIdleReactivateCount);
            return requestStatsHolder;
    }
    @PublicApi(since = "1.0.0")
            builder.field(Fields.STARTREE_QUERY_CURRENT, getStarTreeQueryCurrent());
            long concurrentQueryCurrent,
            pitTimeInMillis += stats.pitTimeInMillis;
        public long getQueryCount() {
            return current;
 * The OpenSearch Contributors require contributions made to
                return this;
            public Builder fetchTimeInMillis(long time) {
 * GitHub history for details.
            }
 * the Apache License, Version 2.0 (the "License"); you may
        private long suggestTimeInMillis;
 */
            public Builder queryTimeInMillis(long time) {
public class SearchStats implements Writeable, ToXContentFragment {
        }
                builder.startObject(Fields.REQUEST);
    }
            return concurrentQueryCurrent;
            this.requestStatsLongHolder = builder.requestStatsLongHolder;
            return new TimeValue(concurrentQueryTimeInMillis);
            this.concurrentQueryCurrent = builder.concurrentQueryCurrent;
            queryCurrent = in.readVLong();
            long scrollCount,
            public Builder concurrentQueryCount(long count) {
            starTreeQueryFailed += stats.starTreeQueryFailed;
            pitCurrent += stats.pitCurrent;
