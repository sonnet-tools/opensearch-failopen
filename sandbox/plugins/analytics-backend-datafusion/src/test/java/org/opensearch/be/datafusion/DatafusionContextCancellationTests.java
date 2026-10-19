        ctx.setDatafusionQuery(new DatafusionQuery("table", new byte[0], 42L));
    }
        task.cancel("test");
    public void testIsCancelledReturnsTrueWhenTaskCancelled() {
        return new DatafusionContext(task, reader, null);
import java.util.Collections;
    }
/*  
        DatafusionContext ctx = createContext(task);  
        assertFalse(ctx.isCancelled());
        DatafusionContext ctx = createContext(null);
        assertEquals(0L, ctx.getContextId());  
        assertTrue(ctx.isCancelled());
    public void testIsCancelledReturnsFalseWhenTaskIsNull() {
    public void testGetContextIdReturnsZeroForZeroContextQuery() {  
    }
 * The OpenSearch Contributors require contributions made to  
public class DatafusionContextCancellationTests extends OpenSearchTestCase {
        AnalyticsShardTask task = createTask();
    public void testGetContextIdReturnsQueryContextId() {  
    public void testGetContextIdReturnsZeroWhenNoQuery() {
        when(reader.getReaderHandle()).thenReturn(null);  
        AnalyticsShardTask task = createTask();
    public void testIsCancelledReturnsFalseWhenTaskNotCancelled() {
    }
package org.opensearch.be.datafusion;
        DatafusionContext ctx = createContext(null);
import org.opensearch.core.tasks.TaskId;
    private AnalyticsShardTask createTask() {  
import static org.mockito.Mockito.when;
    }
        DatafusionContext ctx = createContext(null);  
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
        assertEquals(42L, ctx.getContextId());  
    }
        DatafusionContext ctx = createContext(null);
        assertFalse(ctx.isCancelled());
import static org.mockito.Mockito.mock;
    }  
        return new AnalyticsShardTask(1L, "type", "action", "desc", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
 * compatible open source license.
    private DatafusionContext createContext(AnalyticsShardTask task) {
 * this file be licensed under the Apache-2.0 license or a
        ctx.setDatafusionQuery(new DatafusionQuery("table", new byte[0], 0L));
        DatafusionContext ctx = createContext(task);  
    }
import org.opensearch.test.OpenSearchTestCase;  
        DatafusionReader reader = mock(DatafusionReader.class);
 * SPDX-License-Identifier: Apache-2.0
 */  
 *
}
        assertEquals(0L, ctx.getContextId());  
