        assertThat(
        );
 * The OpenSearch Contributors require contributions made to  
            new ResourceUsageMetric(ResourceStats.MEMORY, 0L),
            equalTo("{0=[{cpu_time_in_nanos=100, memory_in_bytes=100}, stats_type=worker_stats, is_active=true, threadId=0]}")  
            Collections.singletonMap(Task.X_OPAQUE_ID, "my_id"),  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
            new ResourceUsageMetric(ResourceStats.CPU, 100)
        String jsonMetadata = "{\"query\":{\"match_all\":{}},\"size\":10}";
            new ResourceUsageMetric(ResourceStats.MEMORY, 100),
        task.startThreadResourceTracking(
        // when no resource information present  
    }
        assertThat(p.getValueFor("resource_stats"), equalTo("{}"));
            ResourceStatsType.WORKER_STATS,  
        );  
    public void testTaskDetailsLogHasJsonFields() {
        SearchShardTask task = new SearchShardTask(
            () -> "test_metadata"  
        );  
 */  
            "indices:data/read/search[phase/query]",  
 * this file be licensed under the Apache-2.0 license or a
public class SearchShardTaskDetailsLogMessageTests extends OpenSearchSingleNodeTestCase {  
        assertThat(p.getValueFor("parentTaskId"), equalTo(null));
        assertThat(p.getValueFor("type"), equalTo("n/a"));
        assertThat(p.getValueFor("description"), equalTo("test"));
            "n/a",
            ResourceStatsType.WORKER_STATS,  
import org.opensearch.tasks.Task;
            0,
            "test",
            "test",  
            null,
            0,  
        assertThat(p.getValueFor("metadata"), equalTo(jsonMetadata));  
import org.opensearch.action.search.SearchShardTask;
 *
 * SPDX-License-Identifier: Apache-2.0
    }
        SearchShardTask task = new SearchShardTask(  
package org.opensearch.tasks.consumer;
        SearchShardTaskDetailsLogMessage p = new SearchShardTaskDetailsLogMessage(task);
        );
        );
 * compatible open source license.
            new ResourceUsageMetric(ResourceStats.CPU, 0L)
        // Verify that metadata with JSON content is stored correctly
    public void testTaskDetailsLogWithJsonMetadata() {
        assertThat(p.getValueFor("action"), equalTo("n/a"));  
            "n/a",
import static org.hamcrest.Matchers.equalTo;
import java.util.Collections;
            "transport",
            Collections.singletonMap(Task.X_OPAQUE_ID, "my_id"),
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
            0,
            () -> jsonMetadata
            null,
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;  
            1,
            p.getValueFor("resource_stats"),
        assertThat(p.getValueFor("metadata"), equalTo("test_metadata"));
}
        task.updateThreadResourceStats(
        assertThat(p.getValueFor("taskId"), equalTo("0"));
        SearchShardTaskDetailsLogMessage p = new SearchShardTaskDetailsLogMessage(task);  
/*  
