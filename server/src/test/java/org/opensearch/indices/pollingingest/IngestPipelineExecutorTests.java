        assertEquals(0, metrics.totalDroppedCount());
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        expectThrows(NullPointerException.class, () -> new IngestPipelineExecutor(null, "test_index", (String) null));
    }
        assertTrue(e.getMessage().contains("processor failed"));
        source.put("name", "alice");
        assertTrue(e.getMessage().contains("_id mutations are not allowed"));
                Map<String, Object> sourceMap = indexRequest.sourceAsMap();
import java.util.Map;
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
/*
    public void testConstructorRequiresNonNullIndex() {
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            onCompletion.accept(Thread.currentThread(), null);
    public void testExecutePipelines_RoutingMutation_Throws() {
    private void mockPipelineExecution(String addedField, Object addedValue) {
    public void testExecutePipelines_IdMutation_Throws() {
    }
import static org.mockito.Mockito.verify;
import java.util.function.IntConsumer;
import static org.mockito.Mockito.never;
    // --- Execution: pipeline drops document ---
    }
        Map<String, Object> result = executor.executePipelines("1", source);
            onCompletion.accept(Thread.currentThread(), null);
        ingestService = mock(IngestService.class);
import java.util.function.BiConsumer;
        Exception e = expectThrows(RuntimeException.class, () -> executor.executePipelines("1", source));
                sourceMap.put(addedField, addedValue);
        // Verify failure metric
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "mutate-pipeline");
        assertNotNull(result);
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);
        Map<String, Object> source = new HashMap<>();
        source.put("name", "alice");
import org.opensearch.action.DocWriteRequest;
    @Override
            return null;
        doAnswer(invocation -> {
        source.put("name", "alice");
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
                indexRequest.source(sourceMap);
import static org.mockito.ArgumentMatchers.anyInt;
        assertTrue(metrics.totalExecutionTimeInMillis() >= 0);
            for (DocWriteRequest<?> req : requests) {
        assertNull(result);
            return null;
            IntConsumer onDropped = invocation.getArgument(4);
        assertTrue(e.getMessage().contains("bulk execution failed"));
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "fail-pipeline");
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", (String) null);
            for (DocWriteRequest<?> req : requests) {
            onDropped.accept(0);
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
import org.opensearch.test.OpenSearchTestCase;
    public void testConstructorRequiresNonNullIngestService() {
    }
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "fail-pipeline");
import org.opensearch.ingest.IngestService;
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();
    public void setUp() throws Exception {
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();
        doAnswer(invocation -> {
        Map<String, Object> source = new HashMap<>();
        assertEquals(0, metrics.totalFailedCount());
    // --- Construction tests ---
    public void testExecutePipelines_NoPipeline_ReturnsSourceUnchanged() throws Exception {
        assertEquals(0, metrics.totalFailedCount());
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "drop-pipeline");
        source.put("name", "alice");
        assertEquals(0, metrics.totalExecutionCount());
            return null;
    public void testExecutePipelines_DropsDocument() throws Exception {
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        source.put("name", "alice");
    }
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "mutate-pipeline");
        assertEquals(1, metrics.totalExecutionCount());
            BiConsumer<Integer, Exception> onFailure = invocation.getArgument(2);
    }
import org.opensearch.action.index.IndexRequest;
 * SPDX-License-Identifier: Apache-2.0
    }
        expectThrows(NullPointerException.class, () -> new IngestPipelineExecutor(ingestService, null, (String) null));
        Map<String, Object> source = new HashMap<>();
        assertEquals(0, metrics.totalDroppedCount());
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> executor.executePipelines("1", source));
        assertEquals(0, metrics.totalFailedCount());
 *
        assertTrue(e.getMessage().contains("_routing mutations are not allowed"));
            }
 */
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        Map<String, Object> source = new HashMap<>();
    }
public class IngestPipelineExecutorTests extends OpenSearchTestCase {
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();
        doAnswer(invocation -> {
        Map<String, Object> result = executor.executePipelines("1", source);
            return null;
    private IngestService ingestService;
        // Verify drop metric
                IndexRequest indexRequest = (IndexRequest) req;
        mockPipelineExecution("added_field", "added_value");
            onCompletion.accept(Thread.currentThread(), null);
        verify(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
package org.opensearch.indices.pollingingest;
        // Verify metrics
    // --- Execution: pipeline transforms source ---
        super.setUp();
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            onCompletion.accept(Thread.currentThread(), null);
        Map<String, Object> source = new HashMap<>();
    // --- Execution: no pipeline configured ---
    public void testExecutePipelines_CompletionException() {
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
            }
    }
            return null;
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> executor.executePipelines("1", source));
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();
            onCompletion.accept(Thread.currentThread(), new RuntimeException("bulk execution failed"));
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);
        assertEquals(1, metrics.totalDroppedCount());
    // --- Guardrails ---
        verify(ingestService, never()).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        assertSame(source, result);
    public void testExecutePipelines_Failure() {
            for (DocWriteRequest<?> req : requests) {
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "my-pipeline");
        Map<String, Object> source = new HashMap<>();
        doAnswer(invocation -> {
    }
                ((IndexRequest) req).id("changed_id");
        doAnswer(invocation -> {
 * this file be licensed under the Apache-2.0 license or a
            onFailure.accept(0, new RuntimeException("processor failed"));
import static org.mockito.Mockito.doAnswer;
        // No pipeline configured — metrics should be zero
            return null;
            }
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
}
            onCompletion.accept(Thread.currentThread(), null);
import static org.mockito.Mockito.mock;
                ((IndexRequest) req).routing("new_routing");
        assertEquals(1, metrics.totalExecutionCount());
        assertEquals(1, metrics.totalExecutionCount());
        Map<String, Object> source = new HashMap<>();
    // --- Helper ---
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);
        source.put("name", "alice");
    }
        RuntimeException e = expectThrows(RuntimeException.class, () -> executor.executePipelines("1", source));
        assertEquals(1, metrics.totalFailedCount());
        Map<String, Object> result = executor.executePipelines("1", source);
        doAnswer(invocation -> {
    public void testExecutePipelines_TransformsSource() throws Exception {
        source.put("name", "alice");
import static org.mockito.ArgumentMatchers.any;
