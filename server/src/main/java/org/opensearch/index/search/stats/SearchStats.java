         * Use Builder to create Stats object  
            public Builder suggestCurrent(long current) {
                out.writeVLong(concurrentQueryTimeInMillis);
            new PhaseStatsLongHolder(
            }
        private long starTreeQueryCurrent;  
        if (searchStats == null) {  
 */  
                groupStats = new HashMap<>(searchStats.groupStats.size());
                    builder.endObject();  
            this(0, 0, 0);
            scrollCount += stats.scrollCurrent;  
     * @opensearch.api  
            this.pitCurrent = builder.pitCurrent;  
                return this;
        totalStats.addForClosingShard(searchStats.totalStats);  
            public Builder scrollTimeInMillis(long time) {  
                pitTimeInMillis = in.readVLong();
        }
        }
            return requestStatsHolder;
            for (Map.Entry<String, Stats> entry : groupStats.entrySet()) {
            starTreeQueryFailed += stats.starTreeQueryFailed;
            this.concurrentQueryTimeInMillis = builder.concurrentQueryTimeInMillis;  
        } else {
                    builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, new TimeValue(tookStatsLongHolder.timeInMillis));  
            suggestTimeInMillis += stats.suggestTimeInMillis;
            }
            long queryTimeInMillis,
            return new TimeValue(suggestTimeInMillis);
        if (searchStats == null) {
            concurrentQueryCurrent += stats.concurrentQueryCurrent;
                        PhaseStatsLongHolder.logger.warn(  
        static final String TOTAL = "total";
                out.writeVLong(pitTimeInMillis);
                    builder.field(Fields.CURRENT, statsLongHolder.current);
            this.pitTimeInMillis = pitTimeInMillis;  
                builder.startObject(entry.getKey());  
        private Stats(StreamInput in) throws IOException {  
    }
                out.writeVLong(concurrentQueryCount);  
            private long queryCount = 0;  
        static final String FETCH_TOTAL = "fetch_total";  
 *
        }
            queryTimeInMillis = in.readVLong();
                return this;  
            this.suggestCount = suggestCount;
            return starTreeQueryCurrent;
        static final String SUGGEST_TIME = "suggest_time";
        public long getSearchIdleReactivateCount() {
            builder.field(Fields.STARTREE_QUERY_TOTAL, starTreeQueryCount);
            this.timeInMillis = timeInMillis;
         */  
        totalStats.toXContent(builder, params);
        /**
            this.queryConcurrency = builder.queryConcurrency;
        if (groupStats == null || groupStats.isEmpty()) {  
            builder.field(Fields.PIT_CURRENT, pitCurrent);
            return suggestCurrent;
            this.scrollCount = builder.scrollCount;
 */  
            builder.field(Fields.CONCURRENT_QUERY_CURRENT, concurrentQueryCurrent);
            private long searchIdleReactivateCount = 0;
            Fields.TOOK,  
            out.writeVLong(scrollCount);
        }  
        public long getStarTreeQueryCount() {  
        private long suggestCount;  
                this.starTreeQueryCurrent = current;
            out.writeVLong(fetchTimeInMillis);
        private long scrollTimeInMillis;  
            public Builder queryConcurrency(long concurrency) {
 * Modifications Copyright OpenSearch Contributors. See
        }
            }
                out.writeVLong(queryFailedCount);
        private long scrollCurrent;
        }
            }  
     * Holds all requests stats.
        static final String QUERY_CURRENT = "query_current";  
            }
                this.suggestCount = count;
            private long fetchCurrent = 0;
            if (in.getVersion().onOrAfter(Version.V_2_4_0)) {
     * Holds statistic values for a particular phase.
            public Builder starTreeQueryCurrent(long current) {
            builder.startObject(Fields.GROUPS);
                this.searchIdleReactivateCount = count;
 */  
            this.pitCurrent = pitCurrent;
 * KIND, either express or implied.  See the License for the
    }  
            this.starTreeQueryTimeInMillis = builder.starTreeQueryTimeInMillis;
            }  
         */
            if (groupStats == null) {  
            private long queryFailedCount = 0;  
            private long pitCurrent = 0;
            if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
        long total;
        public long getStarTreeQueryTimeInMillis() {
            public Builder fetchCount(long count) {
        }
            this.queryCurrent = builder.queryCurrent;
                        );
            long suggestTimeInMillis,  
            }
            }  
                this.requestStatsLongHolder = new RequestStatsLongHolder();  
            }  
                return this;
 * You may obtain a copy of the License at  
            private long concurrentQueryCount = 0;
    /**  
            long pitCurrent,
            this.scrollCurrent = builder.scrollCurrent;
     * @opensearch.api
                    searchRequestStats.getPhaseTotal(searchPhaseName),
                return this;
            fetchCount = in.readVLong();
                return this;  
        public long getFetchCurrent() {
        }
            out.writeVLong(scrollTimeInMillis);
import org.opensearch.core.xcontent.ToXContent;
        }
            long fetchCount,
}
        private long queryCurrent;
            queryConcurrency += stats.queryConcurrency;
            return pitCount;
            builder.field(Fields.FETCH_TOTAL, fetchCount);  
                            phaseStats.current  
        }
        private long queryConcurrency;
            queryTimeInMillis += stats.queryTimeInMillis;
        return this.groupStats != null ? Collections.unmodifiableMap(this.groupStats) : null;
            this.starTreeQueryCurrent = builder.starTreeQueryCurrent;  
    public void addTotals(SearchStats searchStats) {
            return starTreeQueryCount;
            this.suggestTimeInMillis = builder.suggestTimeInMillis;
                this.suggestTimeInMillis = time;
        static final String TIME = "time";  
                this.starTreeQueryFailed = count;
        public double getConcurrentAvgSliceCount() {  
            }  
        private long concurrentQueryCount;
            builder.field(Fields.PIT_TOTAL, pitCount);
        static final String SEARCH = "search";  
        public long getQueryCount() {
        static final String QUERY_TOTAL = "query_total";  
        public long getSuggestCount() {
            builder.humanReadableField(Fields.CONCURRENT_QUERY_TIME_IN_MILLIS, Fields.CONCURRENT_QUERY_TIME, getConcurrentQueryTime());  
    @PublicApi(since = "1.0.0")  
            return timeInMillis;
                builder.endObject();
                return this;
        }
    /**
        this.groupStats = groupStats;  
                return this;
            private long suggestCurrent = 0;
        private long searchIdleReactivateCount;
            private long queryCurrent = 0;
            long queryConcurrency,
    @PublicApi(since = "1.0.0")
     *  
import org.apache.logging.log4j.Logger;
        @Override
                this.pitTimeInMillis = time;
        PhaseStatsLongHolder(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.ToXContentFragment;  
        static final String SUGGEST_CURRENT = "suggest_current";  
                            "SearchRequestStats 'current' is negative for phase '{}': {}",
        public void addForClosingShard(Stats stats) {
                this.fetchCount = count;
                    PhaseStatsLongHolder statsLongHolder = requestStatsLongHolder.requestStatsHolder.get(searchPhaseName.getName());
        public long getFetchTimeInMillis() {  
            if (current < 0) {  
            suggestCurrent += stats.suggestCurrent;
     * @opensearch.internal  
            out.writeVLong(scrollCurrent);  
         * This constructor will be deprecated in 4.0
        private long queryCount;  
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
        static final String QUERY_FAILED_TOTAL = "query_failed";
            return new TimeValue(scrollTimeInMillis);
            scrollCount += stats.scrollCount;
             * @return A new Stats instance.
            }  
        public TimeValue getQueryTime() {  
            for (Map.Entry<String, Stats> entry : searchStats.groupStats.entrySet()) {  
            public Builder concurrentQueryTimeInMillis(long time) {
                this.starTreeQueryTimeInMillis = time;  
        }
        public long getPitCount() {  
            this.pitTimeInMillis = builder.pitTimeInMillis;
            builder.field(Fields.CONCURRENT_QUERY_TOTAL, concurrentQueryCount);
import org.opensearch.Version;  
        static final String SCROLL_TOTAL = "scroll_total";
                this.pitCount = count;
            return fetchCount;
            queryConcurrency += stats.queryConcurrency;
    public Stats getTotal() {  
        long timeInMillis;
         * Builder for the {@link Stats} class.
import java.io.IOException;  
        }
        }
     */
                return 0;
        openContexts += searchStats.openContexts;
            this.concurrentQueryTimeInMillis = concurrentQueryTimeInMillis;
    }
            }
            builder.field(Fields.SUGGEST_TOTAL, suggestCount);  
            private long fetchCount = 0;
            long concurrentQueryCount,
        private static final Logger logger = LogManager.getLogger(PhaseStatsLongHolder.class);
import org.apache.logging.log4j.LogManager;
/**
    private final Stats totalStats;  
            this.suggestCurrent = builder.suggestCurrent;
        }
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    public Map<String, Stats> getGroupStats() {  
 * ownership. Elasticsearch licenses this file to you under  
                return this;
            scrollCount = in.readVLong();  
        long current;  
                return this;
        return this.totalStats;
            pitCurrent += stats.pitCurrent;  
        }  
    public SearchStats(StreamInput in) throws IOException {  
            this.queryTimeInMillis = builder.queryTimeInMillis;
            concurrentQueryCount += stats.concurrentQueryCount;  
 * Encapsulates stats for search time  
            pitCount += stats.pitCount;
                this.queryCount = count;
    @PublicApi(since = "1.0.0")  
        @Override
        public static Stats readStats(StreamInput in) throws IOException {
import org.opensearch.common.unit.TimeValue;
            queryCount = in.readVLong();
            private long scrollCount = 0;
        }
    @Override
        }  
            public Builder scrollCount(long count) {
        public long getQueryFailedCount() {  
    public void writeTo(StreamOutput out) throws IOException {  
    }
                this.suggestCurrent = current;  
            private long concurrentQueryTimeInMillis = 0;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        private long suggestCurrent;
import java.util.HashMap;
     *
        public long getFetchCount() {
        @Deprecated
            }  
        }
        static final String SUGGEST_TIME_IN_MILLIS = "suggest_time_in_millis";
 * under the License.  
        }
    }
        static final String CURRENT = "current";
        static final String FETCH_TIME_IN_MILLIS = "fetch_time_in_millis";
            }  
            this.concurrentQueryCount = builder.concurrentQueryCount;
        private long starTreeQueryCount;
 *  
            builder.field(Fields.FETCH_CURRENT, fetchCurrent);
        }
                concurrentQueryTimeInMillis = in.readVLong();
            return queryCurrent;  
                this.concurrentQueryTimeInMillis = time;
                pitCount = in.readVLong();  
            private long pitCount = 0;
        Map<String, PhaseStatsLongHolder> requestStatsHolder = new HashMap<>();
        }  
        }  
                searchPhaseName.getName(),
        public static class Builder {
            }
                    searchRequestStats.getPhaseMetric(searchPhaseName)  
            fetchTimeInMillis += stats.fetchTimeInMillis;
            private RequestStatsLongHolder requestStatsLongHolder = null;
            if (concurrentQueryCount == 0) {
        public long getScrollTimeInMillis() {
     * @opensearch.api
        public long getCurrent() {
            this.scrollCurrent = scrollCurrent;
                out.writeVLong(concurrentQueryCurrent);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
             * Creates a {@link Stats} object from the builder's current state.  
            out.writeVLong(suggestCurrent);
            out.writeVLong(suggestTimeInMillis);  
            this.queryCurrent = queryCurrent;
            long fetchTimeInMillis,  
            out.writeVLong(queryCurrent);
 *
        private long pitCount;
            searchIdleReactivateCount += stats.searchIdleReactivateCount;
        totalStats = Stats.readStats(in);
    static final class Fields {
            private long pitTimeInMillis = 0;  
                out.writeVLong(starTreeQueryTimeInMillis);  
            private long starTreeQueryFailed = 0;  
            long pitTimeInMillis,  
    public static class PhaseStatsLongHolder implements Writeable {
            this.concurrentQueryCurrent = concurrentQueryCurrent;
                groupStats.putIfAbsent(entry.getKey(), new Stats());
import org.opensearch.core.common.io.stream.StreamOutput;
         * @param builder The builder instance containing all the values.
            this.queryCount = queryCount;
            if (in.getVersion().onOrAfter(Version.V_2_14_0)) {
        }
    public static class RequestStatsLongHolder {  
            return suggestTimeInMillis;  
            long pitCount,
            public Builder queryCurrent(long current) {
    // Set the different Request Stats fields in here
        static final String SCROLL_CURRENT = "scroll_current";
            private long suggestCount = 0;
            } else {  
            scrollTimeInMillis += stats.scrollTimeInMillis;  
 * this file be licensed under the Apache-2.0 license or a
            suggestCurrent = in.readVLong();  
        static final String CONCURRENT_QUERY_CURRENT = "concurrent_query_current";
        private long pitCurrent;  
            if (out.getVersion().onOrAfter(Version.V_2_11_0)) {  
 *
            this.searchIdleReactivateCount = builder.searchIdleReactivateCount;
            builder.field(Fields.QUERY_TOTAL, queryCount);  
import java.util.Collections;
import org.opensearch.common.annotation.PublicApi;
            concurrentQueryCount += stats.concurrentQueryCount;
        public long getQueryCurrent() {
            this.fetchCurrent = fetchCurrent;
            }
            }
        static final String STARTREE_QUERY_FAILED = "startree_query_failed";
            public Stats build() {  
        // Set took stats
            public Builder starTreeQueryFailed(long count) {  
            long queryCount,
            out.writeBoolean(true);  
        static final String CONCURRENT_AVG_SLICE_COUNT = "concurrent_avg_slice_count";  
                this.queryConcurrency = concurrency;  
            this.searchIdleReactivateCount = searchIdleReactivateCount;  
            public Builder starTreeQueryTimeInMillis(long time) {
        static final String TIME_IN_MILLIS = "time_in_millis";
     *
        }
                concurrentQueryCount = in.readVLong();
                return this;
            if (requestStatsLongHolder != null) {  
            private long queryConcurrency = 0;
            queryCount += stats.queryCount;
        static final String QUERY_TIME_IN_MILLIS = "query_time_in_millis";
 * Licensed to Elasticsearch under one or more contributor  
                    (stream, stats) -> stats.writeTo(stream)
                out.writeVLong(queryConcurrency);  
            return new TimeValue(queryTimeInMillis);
        private RequestStatsLongHolder requestStatsLongHolder;
            }
        if (totalStats.requestStatsLongHolder == null) {  
        }
        // Set phase stats
            return concurrentQueryCurrent;
            private long queryTimeInMillis = 0;
    }
            fetchTimeInMillis += stats.fetchTimeInMillis;
    }
 * this work for additional information regarding copyright
                out.writeVLong(current);  
            fetchCurrent += stats.fetchCurrent;  
            builder.field(Fields.SCROLL_CURRENT, scrollCurrent);  
     *  
        public long getConcurrentQueryCurrent() {  
            long queryCurrent,  
        }
        static final String STARTREE_QUERY_TIME = "startree_query_time";
    @Nullable
            queryCount += stats.queryCount;  
                return this;
        );  
            builder.field(Fields.CONCURRENT_AVG_SLICE_COUNT, getConcurrentAvgSliceCount());
            public Builder concurrentQueryCurrent(long current) {  
            }
            starTreeQueryCount += stats.starTreeQueryCount;
            }  
        }  
            this.queryFailedCount = builder.queryFailedCount;  
import java.util.Map;  
            }  
            this.starTreeQueryCount = builder.starTreeQueryCount;
        if (searchStats == null) {  
            private long starTreeQueryTimeInMillis = 0;
        public TimeValue getConcurrentQueryTime() {
            totalStats.requestStatsLongHolder = new RequestStatsLongHolder();
        openContexts = in.readVLong();
            return new Stats(in);  
                for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
        builder.field(Fields.OPEN_CONTEXTS, openContexts);
        static final String SUGGEST_TOTAL = "suggest_total";  
    }
                    builder.field(Fields.CURRENT, tookStatsLongHolder.current);
            }
                builder.endObject();
    public SearchStats() {  
            return concurrentQueryTimeInMillis;  
            return;
        addTotals(searchStats);  
            this.queryTimeInMillis = queryTimeInMillis;  
            builder.humanReadableField(Fields.SUGGEST_TIME_IN_MILLIS, Fields.SUGGEST_TIME, getSuggestTime());
                requestStatsHolder.put(searchPhaseName.getName(), new PhaseStatsLongHolder());
            starTreeQueryCount += stats.starTreeQueryCount;  
        public long getConcurrentQueryCount() {
     */
            return scrollCurrent;  
            long concurrentQueryCurrent,  
        }  
            builder.humanReadableField(Fields.PIT_TIME_IN_MILLIS, Fields.PIT_TIME, getPitTime());  
            return fetchCurrent;
            groupStats = in.readMap(StreamInput::readString, Stats::readStats);
        totalStats = new Stats();
            queryCurrent = in.readVLong();  
            }
            public Builder concurrentQueryCount(long count) {
                    requestStatsLongHolder = new RequestStatsLongHolder();
            this.total = total;  
            return new TimeValue(pitTimeInMillis);
                return this;
            builder.field(Fields.STARTREE_QUERY_CURRENT, getStarTreeQueryCurrent());  
        public TimeValue getSuggestTime() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
                            phaseName,
                out.writeVLong(pitCurrent);  
     * Holder of statistics values
            } else {
            this.queryCount = builder.queryCount;  
                starTreeQueryFailed = in.readVLong();
            this.current = in.readVLong();
            builder.field(Fields.QUERY_FAILED_TOTAL, queryFailedCount);  
            }
                out.writeVLong(searchIdleReactivateCount);
            queryCurrent += stats.queryCurrent;
            long scrollTimeInMillis,  
            builder.humanReadableField(Fields.FETCH_TIME_IN_MILLIS, Fields.FETCH_TIME, getFetchTime());
 * license agreements. See the NOTICE file distributed with
            /**
        builder.endObject();  
            public Builder() {}
            out.writeVLong(suggestCount);
        out.writeVLong(openContexts);
 */
        public void add(Stats stats) {
            long fetchCurrent,
        RequestStatsLongHolder() {
 * SPDX-License-Identifier: Apache-2.0
            return queryCount;  
            requestStatsHolder.put(Fields.TOOK, new PhaseStatsLongHolder());  
            }
                requestStatsLongHolder.requestStatsHolder.forEach((phaseName, phaseStats) -> {
            return starTreeQueryFailed;
            pitTimeInMillis += stats.pitTimeInMillis;
                this.scrollCount = count;
        private long suggestTimeInMillis;
            this.pitCount = pitCount;
        static final String FETCH_TIME = "fetch_time";
            public Builder fetchCurrent(long current) {
            fetchCount += stats.fetchCount;  
            if (in.getVersion().onOrAfter(Version.V_2_11_0)) {
        PhaseStatsLongHolder() {  
    public void add(SearchStats searchStats) {
    private long openContexts;
        }
                    if (statsLongHolder == null) {
            public Builder searchIdleReactivateCount(long count) {
            builder.field(Fields.SEARCH_IDLE_REACTIVATE_COUNT_TOTAL, searchIdleReactivateCount);
        }  
            out.writeVLong(timeInMillis);  
            this.scrollTimeInMillis = builder.scrollTimeInMillis;  
        @Nullable  
                this.scrollCurrent = current;  
        static final String QUERY_TIME = "query_time";
                    if (phaseStats.current < 0) {
        public long getStarTreeQueryFailed() {
    public void addTotalsForClosingShard(SearchStats searchStats) {
        static final String STARTREE_QUERY_CURRENT = "startree_query_current";
        static final String CONCURRENT_QUERY_TIME = "concurrent_query_time";  
            out.writeBoolean(false);
            public Builder queryTimeInMillis(long time) {
        public long getSuggestTimeInMillis() {
        builder.startObject(Fields.SEARCH);  
package org.opensearch.index.search.stats;
        static final String PIT_TIME = "point_in_time_time";  
            if (out.getVersion().onOrAfter(Version.V_2_14_0)) {  
        public RequestStatsLongHolder getRequestStatsLongHolder() {  
import org.opensearch.action.search.SearchPhaseName;
        }  
    }
            return suggestCount;
         * Provides a fluent API for constructing a Stats object.  
        }  
            builder.field(Fields.SCROLL_TOTAL, scrollCount);
                    builder.endObject();  
    @Override
 * @opensearch.api
            this.current = current;
            public Builder fetchTimeInMillis(long time) {  
                this.fetchTimeInMillis = time;
        private Stats(Builder builder) {
            suggestCount += stats.suggestCount;  
        static final String SEARCH_IDLE_REACTIVATE_COUNT_TOTAL = "search_idle_reactivate_count_total";  
        public Map<String, PhaseStatsLongHolder> getRequestStatsHolder() {
        public long getPitTimeInMillis() {
        return this.openContexts;
        static final String SCROLL_TIME_IN_MILLIS = "scroll_time_in_millis";  
         * Private constructor that takes a builder.  
        this.openContexts = openContexts;
        private long fetchCount;
        this.totalStats = totalStats;
            // need consider the count of the shard's current scroll
                searchIdleReactivateCount = in.readVLong();
        static final String TOOK = "took";
            this.scrollTimeInMillis = scrollTimeInMillis;
            concurrentQueryTimeInMillis += stats.concurrentQueryTimeInMillis;  
 * specific language governing permissions and limitations
                    builder.startObject(Fields.TOOK);
            long suggestCount,
            concurrentQueryTimeInMillis += stats.concurrentQueryTimeInMillis;
@PublicApi(since = "1.0.0")
                new PhaseStatsLongHolder(  
                });  
        static final String CONCURRENT_QUERY_TOTAL = "concurrent_query_total";
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {  
         */
        }  
                out.writeMap(
    @Nullable  
     */
            }
            if (out.getVersion().onOrAfter(Version.V_3_3_0)) {
        static final String PIT_TIME_IN_MILLIS = "point_in_time_time_in_millis";
        }
            }  
        private long starTreeQueryFailed;
            this.suggestTimeInMillis = suggestTimeInMillis;
                pitCurrent = in.readVLong();
            long suggestCurrent,
            return new TimeValue(starTreeQueryTimeInMillis);
            }
                    StreamOutput::writeString,  
        public TimeValue getScrollTime() {  
            }  
        static final String SCROLL_TIME = "scroll_time";
                return this;
                    builder.field(Fields.TOTAL, tookStatsLongHolder.total);
                    searchRequestStats.getPhaseCurrent(searchPhaseName),
            return current;
        Stats() {
        }
                        continue;  
            }
                this.starTreeQueryCount = count;
                return this;  
        private long queryFailedCount;  
             */
        static final String REQUEST = "request";
            builder.field(Fields.STARTREE_QUERY_FAILED, getStarTreeQueryFailed());
            this.scrollCount = scrollCount;  
            public Builder queryFailed(long count) {  
        public long getStarTreeQueryCurrent() {  
            }
                out.writeVLong(pitCount);
        PhaseStatsLongHolder(long current, long total, long timeInMillis) {
        }
            fetchCurrent = in.readVLong();
                this.queryCurrent = current;
                this.concurrentQueryCurrent = current;
            return queryFailedCount;
        @Override  
        }
        static final String PIT_CURRENT = "point_in_time_current";
        public TimeValue getFetchTime() {
                    builder.startObject(searchPhaseName.getName());
            }  
                concurrentQueryCurrent = in.readVLong();  
                    requestStatsLongHolder.getRequestStatsHolder(),
                groupStats.get(entry.getKey()).add(entry.getValue());
                if (requestStatsLongHolder == null) {
                requestStatsLongHolder.requestStatsHolder = in.readMap(StreamInput::readString, PhaseStatsLongHolder::new);
    public String toString() {
            return concurrentQueryCount;
            totalStats.requestStatsLongHolder.requestStatsHolder.put(
import org.opensearch.core.common.io.stream.StreamInput;
        }  
                return this;
        /**
import org.opensearch.action.search.SearchRequestStats;
            queryFailedCount += stats.queryFailedCount;  
                }
        }
            }  
            }  
            starTreeQueryTimeInMillis += stats.starTreeQueryTimeInMillis;
                return this;
        private long concurrentQueryTimeInMillis;  
        private long scrollCount;
    private Map<String, Stats> groupStats;
            out.writeVLong(fetchCurrent);
                return this;  
        private long starTreeQueryTimeInMillis;
            out.writeVLong(total);
                queryConcurrency = in.readVLong();
 * not use this file except in compliance with the License.
            @Nullable
                this.fetchCurrent = current;  
                searchRequestStats.getTookCurrent(),
        public long getTotal() {
    public void setSearchRequestStats(SearchRequestStats searchRequestStats) {
                out.writeVLong(starTreeQueryCount);
            long scrollCurrent,
        public long getSuggestCurrent() {
        }
            return pitCurrent;
        }
        }  
    }  
            }  
            this.timeInMillis = in.readVLong();
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);  
            )
            scrollCount += stats.scrollCount;  
            }
        return builder;
            }
        private long fetchCurrent;  
            private long scrollCurrent = 0;
                )
            queryFailedCount += stats.queryFailedCount;
                builder.startObject(Fields.REQUEST);
            out.writeVLong(queryCount);
            }
                return this;
            private long starTreeQueryCount = 0;  
        static final String CONCURRENT_QUERY_TIME_IN_MILLIS = "concurrent_query_time_in_millis";
            this.fetchTimeInMillis = fetchTimeInMillis;  
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
            starTreeQueryCurrent += stats.starTreeQueryCurrent;  
        }  
                out.writeVLong(0);
                starTreeQueryCount = in.readVLong();  
/*  
            this.pitCount = builder.pitCount;
            long searchIdleReactivateCount
            return queryTimeInMillis;
 * compatible open source license.
            suggestCount = in.readVLong();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
            builder.field(Fields.SUGGEST_CURRENT, suggestCurrent);
            public Builder pitCount(long count) {
            pitCurrent += stats.pitCurrent;
 * GitHub history for details.
            public Builder queryCount(long count) {  
        static final String STARTREE_QUERY_TIME_IN_MILLIS = "startree_query_time_in_millis";  
            pitCount += stats.pitCount;
            builder.humanReadableField(Fields.STARTREE_QUERY_TIME_IN_MILLIS, Fields.STARTREE_QUERY_TIME, getStarTreeQueryTime());
            out.writeVLong(queryTimeInMillis);  
            public Builder starTreeQueryCount(long count) {  
        }
                entry.getValue().toXContent(builder, params);
            out.writeMap(groupStats, StreamOutput::writeString, (stream, stats) -> stats.writeTo(stream));
            builder.humanReadableField(Fields.SCROLL_TIME_IN_MILLIS, Fields.SCROLL_TIME, getScrollTime());
            public Builder scrollCurrent(long current) {
        if (groupStats != null && !groupStats.isEmpty()) {  
            public Builder pitCurrent(long current) {
                return queryConcurrency / (double) concurrentQueryCount;
                return this;
            public Builder suggestCount(long count) {
        public TimeValue getPitTime() {
     */
/*  
/*
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
            this.suggestCount = builder.suggestCount;  
            }
            starTreeQueryFailed += stats.starTreeQueryFailed;
            return searchIdleReactivateCount;  
            }
            public Builder suggestTimeInMillis(long time) {  
            this.fetchCount = fetchCount;
                return this;
                return this;  
 * The OpenSearch Contributors require contributions made to  
            builder.humanReadableField(Fields.QUERY_TIME_IN_MILLIS, Fields.QUERY_TIME, getQueryTime());
                this.scrollTimeInMillis = time;
                this.concurrentQueryCount = count;  
            if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
        }
    public long getOpenContexts() {
        static final String FETCH_CURRENT = "fetch_current";  
                return this;
        ) {  
        static final String STARTREE_QUERY_TOTAL = "startree_query_total";
    }
                return this;  
import org.opensearch.core.common.Strings;  
        }
            this.concurrentQueryCurrent = builder.concurrentQueryCurrent;
        private long fetchTimeInMillis;
    /**
                this.pitCurrent = current;  
            if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
            long scrollCount,
import org.opensearch.core.common.io.stream.Writeable;  
                    builder.humanReadableField(Fields.TIME_IN_MILLIS, Fields.TIME, new TimeValue(statsLongHolder.timeInMillis));  
                PhaseStatsLongHolder tookStatsLongHolder = requestStatsLongHolder.requestStatsHolder.get(Fields.TOOK);  
            pitTimeInMillis += stats.pitTimeInMillis;  
                }  
                out.writeVLong(starTreeQueryFailed);  
                    }
        if (in.readBoolean()) {  
        }
 * Unless required by applicable law or agreed to in writing,
            fetchCount += stats.fetchCount;
        }
     * Fields for search statistics
                    }
    public SearchStats(Stats totalStats, long openContexts, @Nullable Map<String, Stats> groupStats) {  
        public long getTimeInMillis() {  
            suggestCount += stats.suggestCount;
            return builder;
            long concurrentQueryTimeInMillis,
            return;
    }
import org.opensearch.common.Nullable;  
            builder.field(Fields.QUERY_CURRENT, queryCurrent);
        public long getPitCurrent() {  
            this.queryConcurrency = queryConcurrency;  
        }  
            searchIdleReactivateCount += stats.searchIdleReactivateCount;
            return new TimeValue(concurrentQueryTimeInMillis);  
            return new TimeValue(fetchTimeInMillis);  
        }  
public class SearchStats implements Writeable, ToXContentFragment {
    }  
            this.starTreeQueryFailed = builder.starTreeQueryFailed;
            private long scrollTimeInMillis = 0;  
            return total;  
            }
        public void writeTo(StreamOutput out) throws IOException {
            }
            return scrollCount;  
 * software distributed under the License is distributed on an
            private long starTreeQueryCurrent = 0;
        }
            fetchTimeInMillis = in.readVLong();  
            scrollTimeInMillis += stats.scrollTimeInMillis;
            }
        public void writeTo(StreamOutput out) throws IOException {
        public long getScrollCount() {
            queryTimeInMillis += stats.queryTimeInMillis;  
        public long getConcurrentQueryTimeInMillis() {
            this.concurrentQueryCount = concurrentQueryCount;  
            this.total = in.readVLong();  
        static final String OPEN_CONTEXTS = "open_contexts";
                queryFailedCount = in.readVLong();  
            return fetchTimeInMillis;
        /**
            return;  
        public long getQueryTimeInMillis() {
    @Override
            builder.endObject();
            }  
                starTreeQueryCurrent = in.readVLong();
            this.fetchTimeInMillis = builder.fetchTimeInMillis;
        static final String PIT_TOTAL = "point_in_time_total";
            public Builder pitTimeInMillis(long time) {  
        }  
        public Stats(  
            return pitTimeInMillis;  
        private long pitTimeInMillis;
        private long concurrentQueryCurrent;
            this.requestStatsLongHolder = builder.requestStatsLongHolder;
    }  
            return scrollTimeInMillis;
            );
            this.fetchCount = builder.fetchCount;
            private long fetchTimeInMillis = 0;  
        public long getScrollCurrent() {
import org.opensearch.core.xcontent.XContentBuilder;
                starTreeQueryTimeInMillis = in.readVLong();
            private long suggestTimeInMillis = 0;  
                this.queryTimeInMillis = time;  
                return this;  
            suggestTimeInMillis += stats.suggestTimeInMillis;  
        public TimeValue getStarTreeQueryTime() {
        if (searchStats.groupStats != null && !searchStats.groupStats.isEmpty()) {
        }
            return requestStatsLongHolder;
                searchRequestStats.getTookMetric()
        }
                searchRequestStats.getTookTotal(),  
         * This is the sole entry point for creating a new Stats object.
        private long queryTimeInMillis;
            this.fetchCurrent = builder.fetchCurrent;  
    }
                    builder.field(Fields.TOTAL, statsLongHolder.total);
        totalStats.writeTo(out);
    }
        }
            scrollCurrent = in.readVLong();
            scrollTimeInMillis = in.readVLong();
                );
 * the Apache License, Version 2.0 (the "License"); you may
        static final String GROUPS = "groups";
        totalStats.add(searchStats.totalStats);
        }  
        }
                return new Stats(this);
            this.requestStatsLongHolder = new RequestStatsLongHolder();
            scrollCurrent += stats.scrollCurrent;
            suggestTimeInMillis = in.readVLong();
    }  
                this.queryFailedCount = count;
        totalStats.requestStatsLongHolder.requestStatsHolder.put(
            private long concurrentQueryCurrent = 0;  
        }
                out.writeVLong(starTreeQueryCurrent);
            this.suggestCurrent = suggestCurrent;  
        }
            // for internal use, initializes all counts to 0
    public static class Stats implements Writeable, ToXContentFragment {
        }
            return starTreeQueryTimeInMillis;  
                return this;  
            if (out.getVersion().onOrAfter(Version.V_2_4_0)) {  
            starTreeQueryTimeInMillis += stats.starTreeQueryTimeInMillis;
                if (tookStatsLongHolder != null) {
            out.writeVLong(fetchCount);  
