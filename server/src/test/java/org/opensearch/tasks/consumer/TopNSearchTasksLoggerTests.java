                .setTransientSettings(Settings.builder().putNull("*"))
    public static void cleanup() {  
        Loggers.removeAppender(searchLogger, appender);
            .build();  
    @BeforeClass
 * The OpenSearch Contributors require contributions made to  
                "test",
import org.opensearch.common.logging.MockAppender;
            .put(LOG_TOP_QUERIES_SIZE_SETTING.getKey(), 1)
        generateTasks(2);
import static org.opensearch.tasks.consumer.TopNSearchTasksLogger.LOG_TOP_QUERIES_SIZE_SETTING;
            client().admin()  
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
                new ResourceUsageMetric(ResourceStats.MEMORY, i * 100L),
                ResourceStatsType.WORKER_STATS,  
            task.updateThreadResourceStats(
        final Settings settings = Settings.builder()  
import static org.opensearch.tasks.consumer.TopNSearchTasksLogger.LOG_TOP_QUERIES_FREQUENCY_SETTING;
    }  
                new ResourceUsageMetric(ResourceStats.CPU, 0L)
import org.apache.logging.log4j.Level;
import org.opensearch.common.settings.Settings;  
            );  
    }
            .build();
        topNSearchTasksLogger = new TopNSearchTasksLogger(
                i,
                .prepareUpdateSettings()
    static MockAppender appender;  
            );  
        // setting the frequency to a really large value and confirming that nothing gets written to log file.
    public void testLoggerWithHighFrequency() {  
        topNSearchTasksLogger.setTopQueriesLogFrequencyInNanos(TimeValue.timeValueMillis(0));  
        topNSearchTasksLogger = new TopNSearchTasksLogger(  
    // generate search tasks and updates the topN search tasks logger consumer.
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        assertNotNull(logEvent);  
            );  
        assertTrue(logEvent.getMessage().getFormattedMessage().contains("cpu_time_in_nanos=300, memory_in_bytes=300"));
import java.util.Collections;
            settings,
import org.junit.After;
        topNSearchTasksLogger = new TopNSearchTasksLogger(
public class TopNSearchTasksLoggerTests extends OpenSearchSingleNodeTestCase {
            .build();  
import org.apache.logging.log4j.core.LogEvent;
            .put(LOG_TOP_QUERIES_SIZE_SETTING.getKey(), 1)  
}
        generateTasks(5);
            .put(LOG_TOP_QUERIES_SIZE_SETTING.getKey(), 1)
    }
                new ResourceUsageMetric(ResourceStats.MEMORY, 0L),
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.apache.logging.log4j.Logger;  
                i,
            task.startThreadResourceTracking(
            .put(LOG_TOP_QUERIES_FREQUENCY_SETTING.getKey(), "60s")
import org.opensearch.action.search.SearchShardTask;
import org.apache.logging.log4j.LogManager;
import org.junit.BeforeClass;  
                null,  
    public void testLoggerWithTasks() {
                Collections.singletonMap(Task.X_OPAQUE_ID, "my_id"),
 */  
        );
 * SPDX-License-Identifier: Apache-2.0
    private TopNSearchTasksLogger topNSearchTasksLogger;  
                i,
        LogEvent logEvent = appender.getLastEventAndReset();
        assertAcked(
    public void cleanupAfterTest() {
                "n/a",
    }  
    }
 * compatible open source license.
        // This setting overrides is just for testing purpose
                new ResourceUsageMetric(ResourceStats.CPU, i * 100L)
            settings,
        }
 * this file be licensed under the Apache-2.0 license or a
    public void testLoggerWithoutTasks() {
                .cluster()
import org.opensearch.common.logging.Loggers;  
package org.opensearch.tasks.consumer;
        appender.stop();
            .put(LOG_TOP_QUERIES_FREQUENCY_SETTING.getKey(), "60s")
        final Settings settings = Settings.builder()
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
    static Logger searchLogger = LogManager.getLogger(TopNSearchTasksLogger.TASK_DETAILS_LOG_PREFIX + ".search");
        for (int i = 0; i < numberOfTasks; i++) {  
            Task task = new SearchShardTask(
        );  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
    public void generateTasks(int numberOfTasks) {
            topNSearchTasksLogger.accept(task);
        assertNull(appender.getLastEventAndReset());  
                .setPersistentSettings(Settings.builder().putNull("*"))  
import org.opensearch.common.unit.TimeValue;
/*  
    @After  
import org.opensearch.common.settings.ClusterSettings;
                ResourceStatsType.WORKER_STATS,  
        appender.start();
        assertNull(appender.getLastEventAndReset());
 *
        final Settings settings = Settings.builder()  
                () -> "n/a"
import org.junit.AfterClass;
        Loggers.addAppender(searchLogger, appender);  
    }  
        assertEquals(logEvent.getLevel(), Level.INFO);
    @AfterClass
        appender = new MockAppender("trace_appender");
                "n/a",  
    public static void init() throws IllegalAccessException {  
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;  
        );
            settings,
        );
            .put(LOG_TOP_QUERIES_FREQUENCY_SETTING.getKey(), "10m")
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        generateTasks(5);
import org.opensearch.tasks.Task;
