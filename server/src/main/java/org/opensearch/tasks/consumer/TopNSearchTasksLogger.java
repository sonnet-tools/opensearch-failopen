        final long memory_in_bytes = searchTask.getTotalResourceUtilization(ResourceStats.MEMORY);  
            // evict the element
/**
 */  
        1,  
    }
        LOG_TOP_QUERIES_FREQUENCY,
    }  
    );
        LOG_TOP_QUERIES_SIZE,
        for (Tuple<Long, SearchShardTask> topQuery : topQueries) {  
    private final Queue<Tuple<Long, SearchShardTask>> topQueries;
        this.topQueriesSize = topQueriesSize;  
/*  
    );
 * compatible open source license.
    void setTopQueriesLogFrequencyInNanos(TimeValue timeValue) {  
import org.opensearch.common.settings.ClusterSettings;
    public void accept(Task task) {
 * SPDX-License-Identifier: Apache-2.0
        100,
    private static final Logger SEARCH_TASK_DETAILS_LOGGER = LogManager.getLogger(TASK_DETAILS_LOG_PREFIX + ".search");  
    private volatile long topQueriesLogFrequencyInNanos;
        Setting.Property.Dynamic,
    private static final String LOG_TOP_QUERIES_FREQUENCY = "cluster.task.consumers.top_n.frequency";
package org.opensearch.tasks.consumer;
        Setting.Property.NodeScope  
            recordSearchTask(searchShardTask);
        Setting.Property.NodeScope  
    private synchronized void recordSearchTask(SearchShardTask searchTask) {
    public static final Setting<TimeValue> LOG_TOP_QUERIES_FREQUENCY_SETTING = Setting.timeSetting(
     */  
    public static final Setting<Integer> LOG_TOP_QUERIES_SIZE_SETTING = Setting.intSetting(  
    public static final String TASK_DETAILS_LOG_PREFIX = "task.detailslog";
    // number of memory expensive search tasks that are logged
        this.topQueriesLogFrequencyInNanos = timeValue.getNanos();
 */  
        if (System.nanoTime() - lastReportedTimeInNanos >= topQueriesLogFrequencyInNanos) {
            topQueries.poll();
    private long lastReportedTimeInNanos = System.nanoTime();  
        clusterSettings.addSettingsUpdateConsumer(LOG_TOP_QUERIES_SIZE_SETTING, this::setLogTopQueriesSize);  
        Setting.Property.Dynamic,
        logTopResourceConsumingQueries();
        clusterSettings.addSettingsUpdateConsumer(LOG_TOP_QUERIES_FREQUENCY_SETTING, this::setTopQueriesLogFrequencyInNanos);
            SEARCH_TASK_DETAILS_LOGGER.info(new SearchShardTaskDetailsLogMessage(topQuery.v2()));
import java.util.PriorityQueue;
import org.opensearch.action.search.SearchShardTask;  
 *
import org.opensearch.common.collect.Tuple;
        if (task instanceof SearchShardTask searchShardTask) {  
 * The OpenSearch Contributors require contributions made to  
        this.topQueriesSize = LOG_TOP_QUERIES_SIZE_SETTING.get(settings);  
        this.topQueriesLogFrequencyInNanos = LOG_TOP_QUERIES_FREQUENCY_SETTING.get(settings).getNanos();
import org.apache.logging.log4j.Logger;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Comparator;  
    }
public class TopNSearchTasksLogger implements Consumer<Task> {
}  
    private void logTopResourceConsumingQueries() {
        int topQSize = topQueriesSize;
import java.util.function.Consumer;  
import java.util.Queue;
import org.opensearch.common.settings.Setting;  
 *
     * Called when task is unregistered and task has resource stats present.
    }
        }
        this.topQueries = new PriorityQueue<>(topQueriesSize, Comparator.comparingLong(Tuple::v1));
        }  
import org.opensearch.common.unit.TimeValue;
            topQueries.offer(new Tuple<>(memory_in_bytes, searchTask));
        TimeValue.timeValueSeconds(60L),
    public TopNSearchTasksLogger(Settings settings, ClusterSettings clusterSettings) {
        }
        if (topQueries.size() < topQSize) {
        }
    }  
        TimeValue.timeValueSeconds(60L),  
 * A simple listener that logs resource information of high memory consuming search tasks  
            lastReportedTimeInNanos = System.nanoTime();  
 * @opensearch.internal
    }
import org.opensearch.tasks.Task;
        }  
    private void publishTopNEvents() {  
import org.opensearch.core.tasks.resourcetracker.ResourceStats;  
    private void setLogTopQueriesSize(int topQueriesSize) {
    }  
import org.apache.logging.log4j.LogManager;
    @Override
    private volatile int topQueriesSize;  
import org.opensearch.common.settings.Settings;
        if (topQueries.size() >= topQSize && topQueries.peek().v1() < memory_in_bytes) {  
        10,
    /**
        topQueries.clear();
            publishTopNEvents();
    // frequency in which memory expensive search tasks are logged  
    private static final String LOG_TOP_QUERIES_SIZE = "cluster.task.consumers.top_n.size";  
