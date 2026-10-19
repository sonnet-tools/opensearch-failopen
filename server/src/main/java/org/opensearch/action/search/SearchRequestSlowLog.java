        Setting.Property.NodeScope
import org.opensearch.common.unit.TimeValue;
        setEnabledIfThresholdExceed();
        }
    );
        Setting.Property.NodeScope
            messageFields.put("shards", searchRequestContext.formattedShardStats());
    private long traceThreshold;
            messageFields.put("id", context.getTask().getHeader(Task.X_OPAQUE_ID));
    }
        TimeValue.timeValueNanos(-1),
/*
                String source = escapeJson(context.getRequest().source().toString(FORMAT_PARAMS));
    );
    /**
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
            }
            .addSettingsUpdateConsumer(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING, this::setDebugThreshold);
 *
    private long infoThreshold;
 * SPDX-License-Identifier: Apache-2.0
    private final Logger logger;
    public static final Setting<TimeValue> CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING = Setting.timeSetting(
import org.apache.logging.log4j.Logger;
        setEnabledIfThresholdExceed();
 * Unless required by applicable law or agreed to in writing,
    );
 * not use this file except in compliance with the License.
        return level;
                sb.append("request_id[]");
            return new String(sourceEscaped, UTF_8);
    }
    }
        return traceThreshold;
            sb.append("took[").append(TimeValue.timeValueNanos(tookInNanos)).append("], ");
 *
            sb.append("search_type[").append(context.getRequest().searchType()).append("], ");
                messageFields.put("total_hits", "-1");
            final Map<String, Object> messageFields = new HashMap<>();
 * The request-level search slow log implementation
 * You may obtain a copy of the License at
        private static String message(SearchPhaseContext context, long tookInNanos, SearchRequestContext searchRequestContext) {
            if (context.getTask().getHeader(Task.X_OPAQUE_ID) != null) {
        Setting.Property.Dynamic,
import java.util.Arrays;
    private long debugThreshold;
            sb.append("shards[").append(searchRequestContext.formattedShardStats()).append("], ");
        setEnabledIfThresholdExceed();
                messageFields.put("total_hits", searchRequestContext.totalHits());
    protected void onPhaseStart(SearchPhaseContext context) {}
    SlowLogLevel getLevel() {
                messageFields.put("source", "{}");
            sb.append("indices").append(Arrays.toString(context.getRequest().indices())).append(", ");
     */
        Setting.Property.Dynamic,
        TimeValue.timeValueMillis(-1),
            } else {
        return warnThreshold;
        clusterService.getClusterSettings()
    }
        }
 * compatible open source license.
            byte[] sourceEscaped = JsonStringEncoder.getInstance().quoteAsUTF8(text);
 * ownership. Elasticsearch licenses this file to you under
        SlowLogLevel.TRACE.name(),
        Setting.Property.NodeScope
                sb.append("total_hits[").append(searchRequestContext.totalHits()).append("], ");
}
 *
        clusterService.getClusterSettings()
        clusterService.getClusterSettings()
            messageFields.put("took_millis", TimeUnit.NANOSECONDS.toMillis(tookInNanos));
        SearchRequestSlowLogMessage(SearchPhaseContext context, long tookInNanos, SearchRequestContext searchRequestContext) {
            SearchRequestContext searchRequestContext
            } else {
     * @opensearch.internal
import java.util.Collections;
                sb.append("id[], ");
            } else {
        CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".threshold.info",
    }
                sb.append("source[], ");
        TimeValue.timeValueNanos(-1),
 * under the License.
 * software distributed under the License is distributed on an
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
    static final String CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX = "cluster.search.request.slowlog";
    SearchRequestSlowLog(ClusterService clusterService, Logger logger) {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.TimeUnit;
            messageFields.put("phase_took", searchRequestContext.phaseTookMap().toString());
        super.setEnabled(this.warnThreshold >= 0 || this.debugThreshold >= 0 || this.infoThreshold >= 0 || this.traceThreshold >= 0);
import java.nio.charset.StandardCharsets;
        CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".threshold.debug",
        private static String escapeJson(String text) {
 * @opensearch.internal
            logger.warn(new SearchRequestSlowLogMessage(context, tookInNanos, searchRequestContext));
            if (searchRequestContext.totalHits() != null) {
import org.opensearch.common.logging.Loggers;
            long tookInNanos,
        this.level = level;
 * the Apache License, Version 2.0 (the "License"); you may
    public static final Setting<TimeValue> CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING = Setting.timeSetting(
     *
        CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".threshold.trace",
        TimeValue.timeValueMillis(-1),
 */
import org.opensearch.core.xcontent.ToXContent;
 * this file be licensed under the Apache-2.0 license or a
        this.logger = logger;
 * The OpenSearch Contributors require contributions made to
        this.debugThreshold = debugThreshold.nanos();
                sb.append("total_hits[-1]");
        this.traceThreshold = traceThreshold.nanos();
 */
    public static final Setting<TimeValue> CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING = Setting.timeSetting(
            logger.trace(new SearchRequestSlowLogMessage(context, tookInNanos, searchRequestContext));
    private static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
 * GitHub history for details.
        Setting.Property.Dynamic,
            messageFields.put("indices", Arrays.toString(context.getRequest().indices()));
        }
        TimeValue.timeValueNanos(-1),
        } else if (traceThreshold >= 0 && tookInNanos > traceThreshold && level.isLevelEnabledFor(SlowLogLevel.TRACE)) {
            logger.debug(new SearchRequestSlowLogMessage(context, tookInNanos, searchRequestContext));
    protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {}
     * Search request slow log message
 */
            return sb.toString();
        // Message will be used in plaintext logs
        this.warnThreshold = warnThreshold.nanos();
    public static final Setting<TimeValue> CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING = Setting.timeSetting(
    protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {}
            super(prepareMap(context, tookInNanos, searchRequestContext), message(context, tookInNanos, searchRequestContext));
import org.opensearch.tasks.Task;
    void setLevel(SlowLogLevel level) {
 * Licensed to Elasticsearch under one or more contributor
    }
        Loggers.setLevel(this.logger, SlowLogLevel.TRACE.name());
    @Override
    protected long getWarnThreshold() {
            messageFields.put("took", TimeValue.timeValueNanos(tookInNanos));
        if (warnThreshold >= 0 && tookInNanos > warnThreshold && level.isLevelEnabledFor(SlowLogLevel.WARN)) {
import org.opensearch.common.logging.SlowLogLevel;
    protected long getDebugThreshold() {
            } else {
    protected long getTraceThreshold() {
 *
        } else if (debugThreshold >= 0 && tookInNanos > debugThreshold && level.isLevelEnabledFor(SlowLogLevel.DEBUG)) {
    static final class SearchRequestSlowLogMessage extends OpenSearchLogMessage {
        Setting.Property.Dynamic,
 */
/**
    protected void onRequestEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
    }
            sb.append("took_millis[").append(TimeUnit.NANOSECONDS.toMillis(tookInNanos)).append("], ");
        ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            if (searchRequestContext.totalHits() != null) {
        long tookInNanos = System.nanoTime() - searchRequestContext.getAbsoluteStartNanos();
    );
            .addSettingsUpdateConsumer(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING, this::setTraceThreshold);
        CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".level",
        SlowLogLevel::parse,
    private long warnThreshold;
            return messageFields;
        private static Map<String, Object> prepareMap(
        this.setLevel(clusterService.getClusterSettings().get(CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL));
                messageFields.put("source", source);
        TimeValue.timeValueMillis(-1),
            if (context.getTask().getHeader(Task.X_REQUEST_ID) != null) {
import tools.jackson.core.io.JsonStringEncoder;
        this(clusterService, LogManager.getLogger(CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX)); // logger configured in log4j2.properties
    }
            }
            messageFields.put("request_id", context.getTask().getHeader(Task.X_REQUEST_ID));
 * specific language governing permissions and limitations
            } else {
/*
            messageFields.put("search_type", context.getRequest().searchType());
    }
        }
        clusterService.getClusterSettings()
            }
package org.opensearch.action.search;
            }
    void setDebugThreshold(TimeValue debugThreshold) {
import org.opensearch.common.logging.OpenSearchLogMessage;
    @Override
    @Override
                sb.append("id[").append(context.getTask().getHeader(Task.X_OPAQUE_ID)).append("]");
/*
        return infoThreshold;
        this.setTraceThreshold(clusterService.getClusterSettings().get(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING));
            .addSettingsUpdateConsumer(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING, this::setWarnThreshold);
 * this work for additional information regarding copyright
        CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".threshold.warn",
            SearchPhaseContext context,
        setEnabledIfThresholdExceed();
import java.nio.charset.Charset;
    }
        Setting.Property.NodeScope
    @Override
        this.setDebugThreshold(clusterService.getClusterSettings().get(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING));
    protected void onRequestStart(SearchRequestContext searchRequestContext) {}
                sb.append("source[").append(context.getRequest().source().toString(FORMAT_PARAMS)).append("], ");
            }
        this.infoThreshold = infoThreshold.nanos();
            if (context.getRequest().source() != null) {
        TimeValue.timeValueNanos(-1),
        TimeValue.timeValueMillis(-1),
    }
        }
    void setWarnThreshold(TimeValue warnThreshold) {
    void setTraceThreshold(TimeValue traceThreshold) {
    }
            logger.info(new SearchRequestSlowLogMessage(context, tookInNanos, searchRequestContext));
                sb.append("request_id[").append(context.getTask().getHeader(Task.X_REQUEST_ID)).append("]");
        this.setInfoThreshold(clusterService.getClusterSettings().get(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING));
    }
    private void setEnabledIfThresholdExceed() {
    );
    @Override
    public static final Setting<SlowLogLevel> CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL = new Setting<>(
import org.apache.logging.log4j.LogManager;
            } else {
    protected long getInfoThreshold() {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL, this::setLevel);
            final StringBuilder sb = new StringBuilder();
import java.util.HashMap;
            }
    public SearchRequestSlowLog(ClusterService clusterService) {
import org.opensearch.common.settings.Setting;
 * license agreements. See the NOTICE file distributed with
public final class SearchRequestSlowLog extends SearchRequestOperationsListener {
            .addSettingsUpdateConsumer(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING, this::setInfoThreshold);
            sb.append("phase_took_millis[").append(searchRequestContext.phaseTookMap().toString()).append("], ");
    private SlowLogLevel level;
        Setting.Property.NodeScope
import org.opensearch.cluster.service.ClusterService;
        Setting.Property.Dynamic,
    }
        this.setWarnThreshold(clusterService.getClusterSettings().get(CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING));
        } else if (infoThreshold >= 0 && tookInNanos > infoThreshold && level.isLevelEnabledFor(SlowLogLevel.INFO)) {
            if (context.getRequest().source() != null) {
 * KIND, either express or implied.  See the License for the
    void setInfoThreshold(TimeValue infoThreshold) {
        return debugThreshold;
