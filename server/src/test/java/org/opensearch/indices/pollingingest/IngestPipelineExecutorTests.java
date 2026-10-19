            onCompletion.accept(Thread.currentThread(), null);
        assertTrue(e.getMessage().contains("_id mutations are not allowed"));  
        assertTrue(e.getMessage().contains("_routing mutations are not allowed"));
import static org.mockito.Mockito.verify;
            return null;  
    }
import static org.mockito.ArgumentMatchers.anyInt;  
            for (DocWriteRequest<?> req : requests) {
        mockPipelineExecution("added_field", "added_value");  
        Map<String, Object> source = new HashMap<>();  
import org.opensearch.test.OpenSearchTestCase;
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);  
    public void testExecutePipelines_CompletionException() {
        Map<String, Object> source = new HashMap<>();
        doAnswer(invocation -> {
    }
    public void testExecutePipelines_TransformsSource() throws Exception {
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());  
    public void testExecutePipelines_DropsDocument() throws Exception {  
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "my-pipeline");
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> executor.executePipelines("1", source));
            return null;
    }
            onCompletion.accept(Thread.currentThread(), null);
            IntConsumer onDropped = invocation.getArgument(4);
            for (DocWriteRequest<?> req : requests) {
import static org.mockito.ArgumentMatchers.any;
    private void mockPipelineExecution(String addedField, Object addedValue) {
import java.util.function.IntConsumer;  
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "mutate-pipeline");  
        doAnswer(invocation -> {
    public void setUp() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        source.put("name", "alice");
    public void testExecutePipelines_Failure() {
    }
    }
import org.opensearch.action.index.IndexRequest;
    public void testConstructorRequiresNonNullIndex() {
    // --- Helper ---
        source.put("name", "alice");  
            return null;  
        Map<String, Object> source = new HashMap<>();
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);  
        assertEquals(0, metrics.totalFailedCount());  
import org.opensearch.action.DocWriteRequest;
        assertEquals(1, metrics.totalExecutionCount());
    }  
    }
            onCompletion.accept(Thread.currentThread(), null);
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> executor.executePipelines("1", source));
        expectThrows(NullPointerException.class, () -> new IngestPipelineExecutor(ingestService, null, (String) null));
        // Verify metrics
        assertEquals(1, metrics.totalFailedCount());  
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();
import java.util.HashMap;  
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", (String) null);
        super.setUp();  
        Map<String, Object> source = new HashMap<>();  
            return null;
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();
    // --- Execution: no pipeline configured ---
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        expectThrows(NullPointerException.class, () -> new IngestPipelineExecutor(null, "test_index", (String) null));
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);  
        assertTrue(e.getMessage().contains("processor failed"));
        doAnswer(invocation -> {
        RuntimeException e = expectThrows(RuntimeException.class, () -> executor.executePipelines("1", source));
        assertNull(result);
        // Verify drop metric  
        assertEquals(0, metrics.totalFailedCount());
        assertEquals(0, metrics.totalDroppedCount());
    // --- Construction tests ---
 * The OpenSearch Contributors require contributions made to  
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);  
                ((IndexRequest) req).routing("new_routing");
        Map<String, Object> source = new HashMap<>();
        ingestService = mock(IngestService.class);
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.never;  
import static org.mockito.Mockito.mock;
import org.opensearch.ingest.IngestService;  
    public void testExecutePipelines_NoPipeline_ReturnsSourceUnchanged() throws Exception {
    }  
public class IngestPipelineExecutorTests extends OpenSearchTestCase {  
                ((IndexRequest) req).id("changed_id");  
 *
    public void testConstructorRequiresNonNullIngestService() {  
    public void testExecutePipelines_IdMutation_Throws() {
import java.util.Map;
        Map<String, Object> result = executor.executePipelines("1", source);
        PollingIngestStats.PipelineStats metrics = executor.getMetrics();
    // --- Execution: pipeline drops document ---
    // --- Execution: pipeline transforms source ---  
import static org.mockito.Mockito.doAnswer;
 * compatible open source license.
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());  
        // No pipeline configured — metrics should be zero  
        doAnswer(invocation -> {
        source.put("name", "alice");
                IndexRequest indexRequest = (IndexRequest) req;  
            onCompletion.accept(Thread.currentThread(), null);  
            return null;  
    }
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
            for (DocWriteRequest<?> req : requests) {
    }  
        source.put("name", "alice");
 */  
            onFailure.accept(0, new RuntimeException("processor failed"));
            BiConsumer<Integer, Exception> onFailure = invocation.getArgument(2);  
        Map<String, Object> source = new HashMap<>();
}  
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "fail-pipeline");
    // --- Guardrails ---
        doAnswer(invocation -> {
                sourceMap.put(addedField, addedValue);
                indexRequest.source(sourceMap);  
/*  
import java.util.function.BiConsumer;
        assertEquals(0, metrics.totalFailedCount());  
            }  
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        source.put("name", "alice");
            }
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);  
            onCompletion.accept(Thread.currentThread(), new RuntimeException("bulk execution failed"));
        assertEquals(1, metrics.totalExecutionCount());
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
package org.opensearch.indices.pollingingest;
        assertEquals(1, metrics.totalExecutionCount());
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        verify(ingestService, never()).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            onDropped.accept(0);
        assertEquals(0, metrics.totalDroppedCount());
        Map<String, Object> result = executor.executePipelines("1", source);
        Map<String, Object> source = new HashMap<>();
        doAnswer(invocation -> {
                Map<String, Object> sourceMap = indexRequest.sourceAsMap();
            return null;
    private IngestService ingestService;
            onCompletion.accept(Thread.currentThread(), null);
        // Verify failure metric  
        Exception e = expectThrows(RuntimeException.class, () -> executor.executePipelines("1", source));  
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "drop-pipeline");  
        Map<String, Object> result = executor.executePipelines("1", source);  
        assertEquals(1, metrics.totalDroppedCount());  
        verify(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());  
        assertTrue(e.getMessage().contains("bulk execution failed"));
    }
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "fail-pipeline");
        IngestPipelineExecutor executor = new IngestPipelineExecutor(ingestService, "test_index", "mutate-pipeline");
    @Override
        assertSame(source, result);  
        assertEquals(0, metrics.totalExecutionCount());
        assertTrue(metrics.totalExecutionTimeInMillis() >= 0);
        source.put("name", "alice");
            }
        assertNotNull(result);
    public void testExecutePipelines_RoutingMutation_Throws() {  
        source.put("name", "alice");  
