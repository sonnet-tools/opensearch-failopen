    );  
            if (context.request().source() != null) {  
                sb.append("stats[], ");
        this.queryWarnThreshold = warnThreshold.nanos();
    @Override  
    @Override
        this.queryDebugThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING).nanos();
 *
                .append("took[")  
                sb.append("request_id[").append(context.getTask().getHeader(Task.X_REQUEST_ID)).append("]");  
    long getFetchDebugThreshold() {  
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_LEVEL, this::setLevel);
        TimeValue.timeValueNanos(-1),
    }  
    private void setQueryTraceThreshold(TimeValue traceThreshold) {
 * not use this file except in compliance with the License.
        TimeValue.timeValueMillis(-1),
                sb.append(context.queryResult().getTotalHits());
            } else {
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING, this::setFetchDebugThreshold);
/**  
        return fetchInfoThreshold;  
            } else {  
        TimeValue.timeValueMillis(-1),
        this.queryInfoThreshold = infoThreshold.nanos();  
        this.queryTraceThreshold = traceThreshold.nanos();
    }
 * SPDX-License-Identifier: Apache-2.0
        TimeValue.timeValueMillis(-1),
    }
        this.queryLogger = LogManager.getLogger(INDEX_SEARCH_SLOWLOG_PREFIX + ".query");  
 * this file be licensed under the Apache-2.0 license or a
        TimeValue.timeValueNanos(-1),
    }  
        Property.Dynamic,
        return level;  
 * Modifications Copyright OpenSearch Contributors. See
/*
                sb.append("request_id[], ");
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING, this::setFetchTraceThreshold);
        indexSettings.getScopedSettings()  
    private long fetchTraceThreshold;
    }
    }
import java.util.Map;  
            if (context.queryResult().getTotalHits() != null) {  
     * @opensearch.internal
    private long fetchDebugThreshold;  
        TimeValue.timeValueNanos(-1),  
        private static String escapeJson(String text) {
            fetchLogger.debug(new SearchSlowLogMessage(context, tookInNanos));
                sb.append("id[], ");  
            messageFields.put("id", context.getTask().getHeader(Task.X_OPAQUE_ID));
import org.apache.logging.log4j.LogManager;
    }
 */
 * The search time slow log implementation
        Property.Dynamic,  
    }
        this.queryTraceThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING).nanos();
            );
        TimeValue.timeValueMillis(-1),
    private void setLevel(SlowLogLevel level) {
        SlowLogLevel::parse,  
            super(prepareMap(context, tookInNanos), message(context, tookInNanos));
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING = Setting.timeSetting(
            byte[] sourceEscaped = JsonStringEncoder.getInstance().quoteAsUTF8(text);
        Property.Dynamic,  
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.debug",
        indexSettings.getScopedSettings()  
 */  
            queryLogger.trace(new SearchSlowLogMessage(context, tookInNanos));  
        indexSettings.getScopedSettings()  
 *  
import org.opensearch.index.shard.SearchOperationListener;
        Property.IndexScope
        this.fetchDebugThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING).nanos();
                "stats",  
        setLevel(indexSettings.getValue(INDEX_SEARCH_SLOWLOG_LEVEL));
        SlowLogLevel.TRACE.name(),
        this.queryDebugThreshold = debugThreshold.nanos();
            } else {  
            if (context.queryResult().getTotalHits() != null) {
 * compatible open source license.
    private void setQueryDebugThreshold(TimeValue debugThreshold) {  
    );  
    }  
            fetchLogger.trace(new SearchSlowLogMessage(context, tookInNanos));
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.query.trace",
    );
                .append("took_millis[")  
            messageFields.put("total_shards", context.numberOfShards());
        TimeValue.timeValueMillis(-1),
public final class SearchSlowLog implements SearchOperationListener {
            if (context.request().source() != null) {
     *
    public static final Setting<SlowLogLevel> INDEX_SEARCH_SLOWLOG_LEVEL = new Setting<>(  
    private void setFetchTraceThreshold(TimeValue traceThreshold) {
import java.util.Collections;
                .append("], ")
            } else {
    private long queryDebugThreshold;
    }  
 * The OpenSearch Contributors require contributions made to  
        TimeValue.timeValueMillis(-1),  
 * @opensearch.internal  
/*  
        SearchSlowLogMessage(SearchContext context, long tookInNanos) {  
    private static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
    long getFetchTraceThreshold() {
            } else {  
import org.opensearch.tasks.Task;
 * ownership. Elasticsearch licenses this file to you under  
        this.level = level;  
            return messageFields;
 * Licensed to Elasticsearch under one or more contributor  
            }
    private SlowLogLevel level;  
                .append("], ")
                sb.append("source[").append(context.request().source().toString(FORMAT_PARAMS)).append("], ");
    }
        return queryTraceThreshold;
            } else {
                .append(context.searchType())  
        }
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.query.debug",
    long getFetchInfoThreshold() {
                .append(TimeValue.timeValueNanos(tookInNanos))
                sb.append("], ");  
        }
            }
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.warn",  
        Property.Dynamic,
            queryLogger.debug(new SearchSlowLogMessage(context, tookInNanos));
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING, this::setQueryDebugThreshold);  
        Loggers.setLevel(this.queryLogger, SlowLogLevel.TRACE.name());  
package org.opensearch.index;
        TimeValue.timeValueNanos(-1),  
        this.fetchTraceThreshold = traceThreshold.nanos();  
            messageFields.put("took", TimeValue.timeValueNanos(tookInNanos));
        // Message will be used in plaintext logs
        TimeValue.timeValueNanos(-1),
            fetchLogger.warn(new SearchSlowLogMessage(context, tookInNanos));
        private static Map<String, Object> prepareMap(SearchContext context, long tookInNanos) {
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING = Setting.timeSetting(
        Property.IndexScope  
                .append(TimeUnit.NANOSECONDS.toMillis(tookInNanos))
        Property.Dynamic,
    public SearchSlowLog(IndexSettings indexSettings) {
 * KIND, either express or implied.  See the License for the
                .append(" ")
                sb.append("stats[");
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.query.info",  
 * this work for additional information regarding copyright
        Property.IndexScope  
            }
        this.fetchLogger = LogManager.getLogger(INDEX_SEARCH_SLOWLOG_PREFIX + ".fetch");
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.common.logging.OpenSearchLogMessage;
    private static final Charset UTF_8 = Charset.forName("UTF-8");  
import org.opensearch.core.common.Strings;  
                sb.append("id[").append(context.getTask().getHeader(Task.X_OPAQUE_ID)).append("], ");
import org.apache.logging.log4j.Logger;
            }  
                escapeJson(asJsonArray(context.groupStats() != null ? context.groupStats().stream() : Stream.empty()))
import java.util.concurrent.TimeUnit;
    private final Logger fetchLogger;
    }
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING, this::setFetchWarnThreshold);
            if (context.getTask().getHeader(Task.X_REQUEST_ID) != null) {
                Strings.collectionToDelimitedString(context.groupStats(), ",", "", "", sb);
import tools.jackson.core.io.JsonStringEncoder;
    SlowLogLevel getLevel() {
    }  
            messageFields.put("took_millis", TimeUnit.NANOSECONDS.toMillis(tookInNanos));
        if (queryWarnThreshold >= 0 && tookInNanos > queryWarnThreshold && level.isLevelEnabledFor(SlowLogLevel.WARN)) {
        this.fetchWarnThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING).nanos();
        Property.IndexScope
    private long queryInfoThreshold;  
        private static String message(SearchContext context, long tookInNanos) {
            return sb.toString();
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING = Setting.timeSetting(
        }
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING, this::setFetchInfoThreshold);
/*  
        Property.Dynamic,
import org.opensearch.common.logging.SlowLogLevel;
    long getQueryTraceThreshold() {  
            StringBuilder sb = new StringBuilder();  
                sb.append("source[], ");
        }
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.trace",  
            }  
    public void onQueryPhase(SearchContext context, long tookInNanos) {
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING, this::setQueryWarnThreshold);  
        } else if (queryInfoThreshold >= 0 && tookInNanos > queryInfoThreshold && level.isLevelEnabledFor(SlowLogLevel.INFO)) {
    private void setFetchWarnThreshold(TimeValue warnThreshold) {
            }
        Property.IndexScope
        return queryWarnThreshold;
            return new String(sourceEscaped, UTF_8);  
                .append("], ");  
    static final String INDEX_SEARCH_SLOWLOG_PREFIX = "index.search.slowlog";  
    private long fetchWarnThreshold;
            messageFields.put(
        return queryInfoThreshold;
        } else if (queryDebugThreshold >= 0 && tookInNanos > queryDebugThreshold && level.isLevelEnabledFor(SlowLogLevel.DEBUG)) {  
 *
        indexSettings.getScopedSettings()  
    private void setFetchInfoThreshold(TimeValue infoThreshold) {  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Setting;  
        this.fetchInfoThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING).nanos();
        } else if (fetchDebugThreshold >= 0 && tookInNanos > fetchDebugThreshold && level.isLevelEnabledFor(SlowLogLevel.DEBUG)) {
        Property.IndexScope  
import org.opensearch.common.unit.TimeValue;
 */
            messageFields.put("message", context.indexShard().shardId());  
    private long queryTraceThreshold;
        this.fetchDebugThreshold = debugThreshold.nanos();
        INDEX_SEARCH_SLOWLOG_PREFIX + ".level",
        return fetchWarnThreshold;
                messageFields.put("total_hits", context.queryResult().getTotalHits());
        Loggers.setLevel(this.fetchLogger, SlowLogLevel.TRACE.name());
        Property.Dynamic,  
 * the Apache License, Version 2.0 (the "License"); you may
            queryLogger.warn(new SearchSlowLogMessage(context, tookInNanos));  
    );
    private void setQueryWarnThreshold(TimeValue warnThreshold) {
        TimeValue.timeValueNanos(-1),
import org.opensearch.core.xcontent.ToXContent;
            } else {
        Property.IndexScope
 *
        return fetchTraceThreshold;
        return fetchDebugThreshold;
    }  
        Property.Dynamic,
        } else if (fetchTraceThreshold >= 0 && tookInNanos > fetchTraceThreshold && level.isLevelEnabledFor(SlowLogLevel.TRACE)) {  
 */  
 * specific language governing permissions and limitations
        Property.IndexScope
    private long fetchInfoThreshold;
    }  
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.fetch.info",
    private long queryWarnThreshold;
        Property.Dynamic,
    }
        if (fetchWarnThreshold >= 0 && tookInNanos > fetchWarnThreshold && level.isLevelEnabledFor(SlowLogLevel.WARN)) {  
 * Unless required by applicable law or agreed to in writing,
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING = Setting.timeSetting(
 * GitHub history for details.
            if (context.groupStats() == null) {
 * under the License.  
            sb.append("search_type[")
import org.opensearch.common.logging.Loggers;  
            Map<String, Object> messageFields = new HashMap<>();
import java.util.stream.Stream;
        this.fetchInfoThreshold = infoThreshold.nanos();
    );
import java.nio.charset.Charset;  
    );
    }
    long getFetchWarnThreshold() {
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING, this::setQueryTraceThreshold);  
        TimeValue.timeValueNanos(-1),
                sb.append("-1");
    /**
            fetchLogger.info(new SearchSlowLogMessage(context, tookInNanos));  
                String source = escapeJson(context.request().source().toString(FORMAT_PARAMS));
        TimeValue.timeValueMillis(-1),
            if (context.getTask().getHeader(Task.X_OPAQUE_ID) != null) {  
        }
                .append(context.numberOfShards())
        Property.IndexScope
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static final class SearchSlowLogMessage extends OpenSearchLogMessage {
    long getQueryInfoThreshold() {
 * You may obtain a copy of the License at  
    );  
 * software distributed under the License is distributed on an
            sb.append("], ");  
    }
        } else if (fetchInfoThreshold >= 0 && tookInNanos > fetchInfoThreshold && level.isLevelEnabledFor(SlowLogLevel.INFO)) {
    long getQueryWarnThreshold() {  
            }
    );
        indexSettings.getScopedSettings()
        TimeValue.timeValueNanos(-1),  
    private final Logger queryLogger;  
        indexSettings.getScopedSettings()
    public void onFetchPhase(SearchContext context, long tookInNanos) {
            sb.append(context.indexShard().shardId())
                messageFields.put("source", source);  
    }
                .append("total_hits[");  
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING = Setting.timeSetting(
                messageFields.put("total_hits", "-1");  
import java.util.HashMap;
        INDEX_SEARCH_SLOWLOG_PREFIX + ".threshold.query.warn",
     */  
    private void setQueryInfoThreshold(TimeValue infoThreshold) {
        this.queryWarnThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING).nanos();
        this.fetchTraceThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING).nanos();
            messageFields.put("request_id", context.getTask().getHeader(Task.X_REQUEST_ID));  
}
    );
        indexSettings.getScopedSettings()
import org.opensearch.common.settings.Setting.Property;
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING = Setting.timeSetting(  
        TimeValue.timeValueMillis(-1),  
    long getQueryDebugThreshold() {
     * Search slow log message  
    }  
        return queryDebugThreshold;  
        this.fetchWarnThreshold = warnThreshold.nanos();  
    private void setFetchDebugThreshold(TimeValue debugThreshold) {
                messageFields.put("source", "{}");
        this.queryInfoThreshold = indexSettings.getValue(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING).nanos();
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING = Setting.timeSetting(  
        }
            .addSettingsUpdateConsumer(INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING, this::setQueryInfoThreshold);  
    public static final Setting<TimeValue> INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING = Setting.timeSetting(
                .append("], total_shards[")
        indexSettings.getScopedSettings()
            queryLogger.info(new SearchSlowLogMessage(context, tookInNanos));
        } else if (queryTraceThreshold >= 0 && tookInNanos > queryTraceThreshold && level.isLevelEnabledFor(SlowLogLevel.TRACE)) {
            messageFields.put("search_type", context.searchType());  
