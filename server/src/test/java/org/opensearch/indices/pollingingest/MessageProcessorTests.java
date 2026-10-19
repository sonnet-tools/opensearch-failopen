            errorStrategy,  
        IllegalStateException e = assertThrows(
        when(documentMapper.parse(any())).thenReturn(parsedDocument);  
        assertEquals(1, combinedMetric.processorThreadInterruptCounter().count());  
                ((IndexRequest) req).id("changed_id");  
        MessageProcessorRunnable.MessageProcessorMetrics metrics2 = MessageProcessorRunnable.MessageProcessorMetrics.create();
        );
            IllegalArgumentException.class,  
            assertEquals(6, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageCounter().count());  
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
        metrics1.processedCounter().inc(100);  
            processor,
        documentMapperForType = mock(DocumentMapperForType.class);
        assertThrows(
        );  
import static org.mockito.ArgumentMatchers.anyInt;
        doThrow(new RuntimeException()).when(processor).process(any(), any());
        assertTrue(e.getCause().getMessage().contains("Pipeline processor failed"));
    /**  
        final byte[] payload = "{\"_id\":\"1\"}".getBytes(StandardCharsets.UTF_8);
        // source has wrong type  
        Thread thread = new Thread(messageProcessorRunnable::run);
    public void testGetDeleteOperation() throws IOException {
            verify(processor, times(6)).process(any(), any());
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
    }
    public void testProcessWithFinalPipeline() throws Exception {
        metrics2.processedCounter().inc(100);
        messageProcessorRunnable.getBlockingQueue()  
        IngestService ingestService = mock(IngestService.class);
        assertTrue(operation.engineOperation() instanceof Engine.Index);  
        assertTrue(operation.engineOperation() instanceof Engine.Delete);
    private IngestionEngine ingestionEngine;
import static org.mockito.Mockito.verify;
    }
 *
import org.opensearch.index.mapper.DocumentMapper;
import org.opensearch.index.mapper.ParsedDocument;
        assertTrue(e.getMessage().contains("Ingest pipeline execution failed"));  
        ParsedDocument parsedDoc = mock(ParsedDocument.class);
    }
        messageProcessorRunnable.close();
        // final_pipeline = _none → no pipeline configured  
        // Mock pipeline that changes _id
        metrics2.failedMessageCounter().inc(100);
        when(engine.getDocumentMapperForType()).thenReturn(dmft);
        doAnswer(invocation -> {
            assertEquals(2, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageDroppedCounter().count());
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
                sourceMap.put(addedField, addedValue);
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
            MessageProcessorRunnable.MessageProcessorMetrics.create()
    public void testGetIndexOperation() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        byte[] payload = "{\"_id\":\"1\",\"_op_type\":\"delete\"}".getBytes(StandardCharsets.UTF_8);
        );
            onFailure.accept(0, new RuntimeException("Pipeline processor failed"));
        // Use IngestPipelineExecutor with pre-resolved pipeline name  
            () -> proc.getOperation(
            IllegalStateException.class,  
    }
/*  
        doAnswer(invocation -> {
                IndexRequest indexRequest = (IndexRequest) req;
    }  
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), System.currentTimeMillis()),
    }  
        MessageProcessorRunnable.MessageProcessor processor = mock(MessageProcessorRunnable.MessageProcessor.class);
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);  
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);  
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),  
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
    public void testPipelineMutatesId_Throws() throws Exception {
    }  
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), 0),
        ParsedDocument parsedDocument = mock(ParsedDocument.class);
        assertEquals("index", captor.getValue().index());
        assertEquals("index", captor.getValue().index());  
 * The OpenSearch Contributors require contributions made to  
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        when(dm.parse(any())).thenReturn(parsedDoc);
public class MessageProcessorTests extends OpenSearchTestCase {
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;  
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
        );
        when(documentMapper.parse(any())).thenReturn(parsedDocument);
        );
        doAnswer(invocation -> {
package org.opensearch.indices.pollingingest;
        );
                MessageProcessorRunnable.MessageProcessorMetrics.create()
    public void testProcessWithNoPipelines() throws Exception {  
        // Pipeline should NOT be called for delete operations
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "_none");
 */  
            MessageProcessorRunnable.MessageProcessorMetrics.create()  
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),  
        documentMapper = mock(DocumentMapper.class);
    public void testInvalidOperationType() throws IOException {  
        DocumentMapper dm = mock(DocumentMapper.class);
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
     */  
        mockPipelineExecution(ingestService, "pipeline_processed", true);  
            () -> processor.getOperation(  
    }  
        messageProcessorRunnable.getBlockingQueue().put(new ShardUpdateMessage(null, null, null, 0));
        messageProcessorRunnable.close();  
            new IngestPipelineExecutor(mock(IngestService.class), "index", (String) null)
        ingestionEngine = mock(IngestionEngine.class);
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
        // Mock pipeline that fails  
        byte[] payload = "{\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8);
        metrics1.failedMessageDroppedCounter().inc(1);
        doAnswer(invocation -> {  
        ParsedDocument parsedDocument = mock(ParsedDocument.class);  
    public void testDeleteWithAutoGeneratedID() throws IOException {
    public void testPipelineNotCalledForDeleteOperations() throws Exception {
import org.opensearch.index.engine.Engine;
        metrics2.invalidMessageCounter().inc(0);  
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "test-pipeline");
        ParsedDocument parsedDocument = mock(ParsedDocument.class);
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "drop-pipeline");
import java.util.concurrent.ArrayBlockingQueue;
import java.io.IOException;
            () -> processor.getOperation(  
        Engine.Delete deleteOperation = (Engine.Delete) operation.engineOperation();
    }
        thread.interrupt();
        );
import org.junit.Before;  
        assertEquals(200, combinedMetric.processedCounter().count());
        metrics1.invalidMessageCounter().inc(5);
        MessageProcessorRunnable messageProcessorRunnable = new MessageProcessorRunnable(  
        thread.start();
            .put(new ShardUpdateMessage(mock(IngestionShardPointer.class), null, Collections.emptyMap(), -1));  
    }
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());  
                MessageProcessorRunnable.MessageProcessorMetrics.create()  
        assertEquals(101, combinedMetric.failedMessageCounter().count());
        // Mock pipeline that drops the document
            )
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(  
            "index",  
                MessageProcessorRunnable.MessageProcessorMetrics.create()
    public void setUp() throws Exception {
    // --- Pipeline execution tests ---
    }
            () -> processor.getOperation(
        byte[] payload = "{\"_id\":\"1\", \"_op_type\":\"update\"}".getBytes(StandardCharsets.UTF_8);  
                java.util.Map<String, Object> sourceMap = indexRequest.sourceAsMap();  
    private MessageProcessorRunnable.MessageProcessor processor;
            MessageProcessorRunnable.MessageProcessorMetrics.create()  
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
import static org.mockito.Mockito.doAnswer;
                MessageProcessorRunnable.MessageProcessorMetrics.create()  
            return null;
            assertEquals(1, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageCounter().count());
    }
            () -> processor.getOperation(
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        DropIngestionErrorStrategy errorStrategy = new DropIngestionErrorStrategy("ingestion_source");
            MessageProcessorRunnable.MessageProcessorMetrics.create()
    public void testMessageRetrySuccess() throws Exception {  
            onCompletion.accept(Thread.currentThread(), null);
            "test_index",  
            for (DocWriteRequest<?> req : requests) {
import static org.mockito.Mockito.never;
            // Simulate pipeline adding a field to the source  
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
        when(documentMapper.parse(any())).thenReturn(parsedDocument);
        verify(ingestService, never()).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        assertThrows(  
        RuntimeException e = assertThrows(
        return new MessageProcessorRunnable.MessageProcessor(engine, "test_index", pipelineExecutor);  
    private DocumentMapperForType documentMapperForType;
    @Before
import org.opensearch.index.engine.FakeIngestionSource;  
        }, 2, TimeUnit.MINUTES);
        assertBusy(() -> {
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());
            ingestionEngine,
    }
        // IngestService should NOT be called when no pipelines configured
        when(documentMapperForType.getDocumentMapper()).thenReturn(documentMapper);  
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(
    public void testPipelineFailure() throws Exception {  
        DropIngestionErrorStrategy errorStrategy = new DropIngestionErrorStrategy("ingestion_source");
        );
    public void testPipelineDropsDocument() throws Exception {
import java.util.function.BiConsumer;
        assertEquals(DocWriteRequest.OpType.CREATE, operation.opType());  
import java.util.Collections;
            BiConsumer<Integer, Exception> onFailure = invocation.getArgument(2);
        thread.interrupt();
        metrics1.processorThreadInterruptCounter().inc(0);
    public void testSkipNoSourceIndexOperation() throws IOException {  
            0
        assertThrows(
import org.opensearch.index.Message;
    }  
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);  
        assertTrue(operation.engineOperation() instanceof Engine.NoOp);
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());  
        assertTrue(operation.engineOperation() instanceof Engine.Index);  
     * Creates a MessageProcessor with a mocked IngestService and index settings that have a final_pipeline configured.
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
            )
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}, \"_op_type\": \"create\"}".getBytes(  
        IngestService ingestService = mock(IngestService.class);
            )
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);  
        IngestionEngine engine = mock(IngestionEngine.class);
            IllegalArgumentException.class,  
            new ArrayBlockingQueue<>(5),  
            onCompletion.accept(Thread.currentThread(), null);
        IngestPipelineExecutor pipelineExecutor = new IngestPipelineExecutor(ingestService, "test_index", resolvedPipeline);
        ArgumentCaptor<SourceToParse> captor = ArgumentCaptor.forClass(SourceToParse.class);
            () -> proc.getOperation(
    /**  
    }
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(  
            )  
        verify(documentMapper).parse(captor.capture());  
        );
        DocumentMapperForType dmft = mock(DocumentMapperForType.class);  
        String resolvedPipeline = "_none".equals(finalPipeline) ? null : finalPipeline;
            processor,
        );
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(
        assertEquals(101, combinedMetric.failedMessageDroppedCounter().count());
        metrics2.processorThreadInterruptCounter().inc(1);
        when(documentMapper.parse(any())).thenReturn(parsedDocument);
    public void testMessageProcessorMetrics() {
import static org.mockito.Mockito.doThrow;  
 * compatible open source license.
        IngestService ingestService = mock(IngestService.class);
        processor = new MessageProcessorRunnable.MessageProcessor(
    }  
            return null;  
import java.nio.charset.StandardCharsets;  
            IllegalArgumentException.class,
        ParsedDocument parsedDocument = mock(ParsedDocument.class);  
        messageProcessorRunnable.getBlockingQueue()
        when(dmft.getDocumentMapper()).thenReturn(dm);  
     * that modifies the document source (adds a field).
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        );
        assertBusy(() -> {  
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
     * Mocks IngestService.executeBulkRequest to simulate successful pipeline execution
import org.opensearch.ingest.IngestService;
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);  
        super.setUp();  
            errorStrategy,
            verify(processor, times(2)).process(any(), any());
        assertEquals("1", captor.getValue().id());
            IllegalArgumentException.class,
}
        assertEquals(2, combinedMetric.versionConflictCounter().count());  
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);  
        assertTrue(operation.engineOperation() instanceof Engine.Index);
            MessageProcessorRunnable.MessageProcessorMetrics.create()
        );
        assertThrows(
            0
        MessageProcessorRunnable.MessageProcessorMetrics combinedMetric = metrics1.combine(metrics2);  
        // Dropped documents should return NoOp  
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8);  
            )  
import org.opensearch.action.index.IndexRequest;
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        MessageProcessorRunnable messageProcessorRunnable = new MessageProcessorRunnable(
            MessageProcessorRunnable.MessageProcessorMetrics.create()
            "test_index",
    }  
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);  
     */
import java.util.function.IntConsumer;
import static org.mockito.Mockito.when;
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(
        metrics2.failedMessageDroppedCounter().inc(100);  
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "fail-pipeline");  
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        MessageProcessorRunnable.MessageProcessorMetrics metrics1 = MessageProcessorRunnable.MessageProcessorMetrics.create();
            }
        );  
    private MessageProcessorRunnable.MessageProcessor createProcessorWithPipeline(IngestService ingestService, String finalPipeline)  
        assertThrows(
            StandardCharsets.UTF_8
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());
        );  
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());
        assertTrue(operation.engineOperation() instanceof Engine.Delete);
            onCompletion.accept(Thread.currentThread(), null);
    public void testGetIndexOperationInCreateMode() throws IOException {
            assertEquals(0, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageDroppedCounter().count());  
import org.opensearch.index.engine.IngestionEngine;
        assertEquals(DocWriteRequest.OpType.INDEX, operation.opType());
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(  
        throws Exception {
        byte[] payload = "{\"_id\":\"1\",\"_op_type\":\"delete\"}".getBytes(StandardCharsets.UTF_8);  
            () -> processor.getOperation(
    public void testMissingID() throws IOException {
        byte[] payload = "{\"_id\":\"1\", \"_op_type\":100}".getBytes(StandardCharsets.UTF_8);
            MessageProcessorRunnable.MessageProcessorMetrics.create()
        );  
        metrics2.versionConflictCounter().inc(0);
            return null;  
        IngestService ingestService = mock(IngestService.class);  
        byte[] payload = "{\"_id\":\"1\",\"_op_type\":\"delete\"}".getBytes(StandardCharsets.UTF_8);  
                MessageProcessorRunnable.MessageProcessorMetrics.create()
        assertTrue(operation.engineOperation() instanceof Engine.Index);
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "test-pipeline");
import org.mockito.ArgumentCaptor;
    private DocumentMapper documentMapper;  
    private void mockPipelineExecution(IngestService ingestService, String addedField, Object addedValue) {
        final byte[] payload2 = "{\"_id\":\"1\", \"_source\":1}".getBytes(StandardCharsets.UTF_8);
        assertTrue(operation.engineOperation() instanceof Engine.NoOp);
        when(ingestionEngine.getDocumentMapperForType()).thenReturn(documentMapperForType);  
import org.opensearch.index.mapper.ParseContext;
    public void testDropPolicyMessageRetryFail() throws Exception {
            IntConsumer onDropped = invocation.getArgument(4);
        MessageProcessorRunnable.MessageProcessor processor = mock(MessageProcessorRunnable.MessageProcessor.class);  
import java.util.concurrent.TimeUnit;  
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
            new ArrayBlockingQueue<>(5),
import org.opensearch.index.IngestionShardPointer;  
        metrics1.versionConflictCounter().inc(2);
        );
            )
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), 0),
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);  
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
            )
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
    }
        );
        verify(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());  
            IllegalArgumentException.class,
        thread.start();  
    public void testUnsupportedOperation() throws IOException {
        doThrow(new RuntimeException()).doNothing().when(processor).process(any(), any());  
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);  
            onDropped.accept(0);  
        verify(documentMapper).parse(captor.capture());
    }
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(  
        assertEquals("1", captor.getValue().id());
        assertTrue(e.getMessage().contains("_id mutations are not allowed"));  
import org.opensearch.index.mapper.SourceToParse;  
        Thread thread = new Thread(messageProcessorRunnable::run);
            return null;  
                MessageProcessorRunnable.MessageProcessorMetrics.create()  
            RuntimeException.class,  
            onCompletion.accept(Thread.currentThread(), null);
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "mutate-id-pipeline");  
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.times;  
            .put(new ShardUpdateMessage(mock(IngestionShardPointer.class), null, Collections.emptyMap(), 0));
        metrics1.failedMessageCounter().inc(1);  
        when(parsedDoc.rootDoc()).thenReturn(new ParseContext.Document());  
                indexRequest.source(sourceMap);
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload2), 0),
        verify(ingestService, never()).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            MessageProcessorRunnable.MessageProcessorMetrics.create()  
import org.opensearch.index.mapper.DocumentMapperForType;  
        assertEquals("1", deleteOperation.id());  
        // Verify IngestService was called
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
            }  
        ArgumentCaptor<SourceToParse> captor = ArgumentCaptor.forClass(SourceToParse.class);
import org.opensearch.action.DocWriteRequest;
        IngestService ingestService = mock(IngestService.class);
        );  
        IngestService ingestService = mock(IngestService.class);
                MessageProcessorRunnable.MessageProcessorMetrics.create()  
            for (DocWriteRequest<?> req : requests) {
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        assertEquals(5, combinedMetric.invalidMessageCounter().count());
    }
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        );  
        }, 1, TimeUnit.MINUTES);
