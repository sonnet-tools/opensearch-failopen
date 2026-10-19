        assertEquals(StageExecution.State.CANCELLED, exec.getState());  
            public void feed(VectorSchemaRoot batch) {}
            @Override
import org.opensearch.analytics.exec.stage.coordinator.PassThroughStageExecution;
        QueryContext ctx = mock(QueryContext.class);
        when(ctx.localTaskExecutor()).thenReturn(java.util.concurrent.Executors.newThreadPerTaskExecutor(r -> {  
 *
        assertSame(sink, exec.outputSource());  
        return ctx;  
        assertTrue(e.getMessage().contains("RowProducingSink"));
        ExchangeSink notRowProducing = new ExchangeSink() {  
    /** start() materialises one no-op LOCAL task and transitions to RUNNING. */  
        when(stage.getStageId()).thenReturn(id);
        assertSame(sink, exec.inputSink(42));  
    public void testStartMaterialisesSingleLocalTask() {
            IllegalArgumentException.class,
        assertEquals("tasks list unchanged after second start()", tasksBefore, exec.tasks().size());
    // ── helpers ──────────────────────────────────────────────────────────
 * The OpenSearch Contributors require contributions made to  
    }
 * this file be licensed under the Apache-2.0 license or a
            Thread t = new Thread(r);
/** Unit tests for {@link PassThroughStageExecution}. */
        assertEquals(1, exec.tasks().size());
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
        RowProducingSink sink = new RowProducingSink();
import org.opensearch.analytics.spi.ExchangeSink;
    }  
    private static Stage stageWithId(int id) {  
import org.opensearch.core.action.ActionListener;
            () -> new PassThroughStageExecution(stageWithId(0), mockContext(), notRowProducing)  
        int tasksBefore = exec.tasks().size();
    }
import static org.mockito.Mockito.when;  
    }
package org.opensearch.analytics.exec.stage;
        // Drive to a terminal directly via cancel; subsequent start() must not re-materialise tasks.
import org.apache.arrow.vector.VectorSchemaRoot;
            public void close() {}
import org.opensearch.test.OpenSearchTestCase;  
 * SPDX-License-Identifier: Apache-2.0
        when(ctx.parentTask()).thenReturn(mock(org.opensearch.analytics.exec.task.AnalyticsQueryTask.class));
        PassThroughStageExecution exec = new PassThroughStageExecution(stageWithId(0), mockContext(), sink);
        }));
import org.opensearch.analytics.planner.dag.Stage;  
 * compatible open source license.
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
            t.setDaemon(true);
        IllegalArgumentException e = expectThrows(
    public void testStartIsNoopAfterTerminalTransition() {
        when(ctx.schedulerExecutor()).thenReturn(Runnable::run);
        };  
    public void testOutputSourceReturnsOwnedSink() {  
        assertEquals(StageExecution.State.CANCELLED, exec.getState());  
        exec.start(ActionListener.wrap(v -> {}, e -> {}));  
        assertSame(sink, exec.inputSink(1));
        return stage;  
        Stage stage = mock(Stage.class);
    public void testCtorRejectsNonRowProducingSink() {
    public void testInputSinkReturnsOwnedSinkForAnyChildId() {
/*  
    private static QueryContext mockContext() {  
public class PassThroughStageExecutionTests extends OpenSearchTestCase {  
        );
import org.opensearch.analytics.exec.RowProducingSink;  
        RowProducingSink sink = new RowProducingSink();  
            return t;  
        assertEquals(StageExecution.State.RUNNING, exec.getState());
        PassThroughStageExecution exec = new PassThroughStageExecution(stageWithId(0), mockContext(), new RowProducingSink());
        PassThroughStageExecution exec = new PassThroughStageExecution(stageWithId(0), mockContext(), new RowProducingSink());
}
    }
        assertTrue("local task variant", exec.tasks().get(0) instanceof LocalStageTask);  
import org.opensearch.analytics.exec.QueryContext;
            @Override
 */  
    }
        PassThroughStageExecution exec = new PassThroughStageExecution(stageWithId(0), mockContext(), sink);
        exec.start(ActionListener.wrap(v -> {}, e -> {}));  
        exec.cancel("test");
    }
    /** Re-entry guard: second start() after terminal is a no-op (no task re-materialisation). */  
import static org.mockito.Mockito.mock;
