 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        T task = mock(type);
import org.opensearch.tasks.CancellableTask;
    public static <T extends CancellableTask> T createMockTaskWithResourceStats(  
import static org.mockito.Mockito.anyString;
 *
 * SPDX-License-Identifier: Apache-2.0
        doAnswer(invocation -> isCancelled.get()).when(task).isCancelled();
        long taskId
            return null;  
            isCancelled.set(true);
        long heapUsage,  
        when(task.getStartTimeNanos()).thenReturn(startTimeNanos);  
import static org.mockito.Mockito.when;
 * compatible open source license.
        return task;
package org.opensearch.search.backpressure;
        when(task.getTotalResourceStats()).thenReturn(new TaskResourceUsage(cpuUsage, heapUsage));
    }
public class SearchBackpressureTestHelpers extends OpenSearchTestCase {  
        return createMockTaskWithResourceStats(type, cpuUsage, heapUsage, 0, taskId);  
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
    }
import org.opensearch.test.OpenSearchTestCase;  
 */  
    public static <T extends CancellableTask> T createMockTaskWithResourceStats(Class<T> type, long cpuUsage, long heapUsage, long taskId) {
import static org.mockito.Mockito.doAnswer;
        doAnswer(invocation -> {
/*  
        Class<T> type,
        long startTimeNanos,
    ) {  
import static org.mockito.Mockito.mock;  
}  
        long cpuUsage,
        }).when(task).cancel(anyString());
        AtomicBoolean isCancelled = new AtomicBoolean(false);  
        when(task.getId()).thenReturn(randomNonNegativeLong());
