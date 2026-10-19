package org.opensearch.action.search;
    protected void onPhaseStart(SearchPhaseContext context) {
            phaseStats.total.inc();
        CounterMetric total = new CounterMetric();
 */
    public long getPhaseMetric(SearchPhaseName searchPhaseName) {  
    StatsHolder tookStatsHolder;
        return tookStatsHolder.timing.sum();
    public SearchRequestStats(ClusterSettings clusterSettings) {
    public long getTookMetric() {  
    @Override
        return phaseStatsMap.get(searchPhaseName).total.count();  
    public long getTookTotal() {
 * Request level search stats to track coordinator level node search latencies
        SEARCH_REQUEST_STATS_ENABLED_KEY,  
    }
    Map<SearchPhaseName, StatsHolder> phaseStatsMap = new EnumMap<>(SearchPhaseName.class);
        tookStatsHolder.current.inc();
    protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {
        context.getCurrentPhase().getSearchPhaseNameOptional().ifPresent(name -> {
/*  
import org.opensearch.common.annotation.PublicApi;
    public long getTookCurrent() {
    }  
    @Inject  
        return phaseStatsMap.get(searchPhaseName).current.count();
    }
    @Override
        MeanMetric timing = new MeanMetric();
    }  
public final class SearchRequestStats extends SearchRequestOperationsListener {  
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        this.setEnabled(clusterSettings.get(SEARCH_REQUEST_STATS_ENABLED));
    }
    }
    }
    protected void onRequestStart(SearchRequestContext searchRequestContext) {
import java.util.concurrent.TimeUnit;
        true,
        });
            phaseStats.timing.inc(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - context.getCurrentPhase().getStartTimeInNanos()));  
    );
    protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
    }
import org.opensearch.common.metrics.MeanMetric;
    public long getPhaseTotal(SearchPhaseName searchPhaseName) {
        tookStatsHolder = new StatsHolder();
    public long getPhaseCurrent(SearchPhaseName searchPhaseName) {
        Setting.Property.Dynamic,
/**  
    /**
@PublicApi(since = "2.11.0")
import java.util.EnumMap;
    protected void onRequestEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {  
 *
        }
        tookStatsHolder.current.dec();
        context.getCurrentPhase().getSearchPhaseNameOptional().ifPresent(name -> phaseStatsMap.get(name).current.inc());  
     *
    }  
     */  
    @Override  
    }
     * Holder of statistics values  
import java.util.Map;  
        return tookStatsHolder.current.count();
        tookStatsHolder.timing.inc(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - searchRequestContext.getAbsoluteStartNanos()));  
    public static final Setting<Boolean> SEARCH_REQUEST_STATS_ENABLED = Setting.boolSetting(
 * this file be licensed under the Apache-2.0 license or a
    }  
    public static final String SEARCH_REQUEST_STATS_ENABLED_KEY = "search.request_stats_enabled";
    @Override
    @Override  
    public static final class StatsHolder {
import org.opensearch.common.settings.Setting;  
}
        context.getCurrentPhase().getSearchPhaseNameOptional().ifPresent(name -> phaseStatsMap.get(name).current.dec());  
import org.opensearch.common.settings.ClusterSettings;
            StatsHolder phaseStats = phaseStatsMap.get(name);  
    protected void onRequestFailure(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
 * @opensearch.api  
        CounterMetric current = new CounterMetric();  
        Setting.Property.NodeScope  
import org.opensearch.common.inject.Inject;
import org.opensearch.common.metrics.CounterMetric;  
 *
        return phaseStatsMap.get(searchPhaseName).timing.sum();
            phaseStats.current.dec();
            phaseStatsMap.put(searchPhaseName, new StatsHolder());  
    @Override  
 * The OpenSearch Contributors require contributions made to  
        tookStatsHolder.current.dec();
        return tookStatsHolder.total.count();  
        clusterSettings.addSettingsUpdateConsumer(SEARCH_REQUEST_STATS_ENABLED, this::setEnabled);  
    }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        tookStatsHolder.total.inc();
     * @opensearch.internal
 */  
    }
    }  
