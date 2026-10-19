            "test_index",
        metrics2.processedCounter().inc(100);
        );
        when(dmft.getDocumentMapper()).thenReturn(dm);
        );
        ParsedDocument parsedDocument = mock(ParsedDocument.class);
        );
     * that modifies the document source (adds a field).
import java.nio.charset.StandardCharsets;
    public void testUnsupportedOperation() throws IOException {
        assertThrows(
            MessageProcessorRunnable.MessageProcessorMetrics.create()
        byte[] payload = "{\"_id\":\"1\",\"_op_type\":\"delete\"}".getBytes(StandardCharsets.UTF_8);
        IllegalStateException e = assertThrows(
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
    }
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
    }
            )
        // Use IngestPipelineExecutor with pre-resolved pipeline name
            onCompletion.accept(Thread.currentThread(), null);
     * Mocks IngestService.executeBulkRequest to simulate successful pipeline execution
            MessageProcessorRunnable.MessageProcessorMetrics.create()
            () -> processor.getOperation(
        assertEquals(DocWriteRequest.OpType.INDEX, operation.opType());
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
            .put(new ShardUpdateMessage(mock(IngestionShardPointer.class), null, Collections.emptyMap(), 0));
 * The OpenSearch Contributors require contributions made to
        );
import static org.mockito.Mockito.doThrow;
            assertEquals(0, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageDroppedCounter().count());
/*
        when(dm.parse(any())).thenReturn(parsedDoc);
import org.opensearch.index.mapper.ParsedDocument;
        );
        thread.interrupt();
            0
            )
        byte[] payload = "{\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8);
                MessageProcessorRunnable.MessageProcessorMetrics.create()
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
    private IngestionEngine ingestionEngine;
        assertTrue(operation.engineOperation() instanceof Engine.NoOp);
                MessageProcessorRunnable.MessageProcessorMetrics.create()
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        );
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "mutate-id-pipeline");
        // Mock pipeline that drops the document
            ingestionEngine,
        verify(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload2), 0),
import java.util.Collections;
    public void testMessageRetrySuccess() throws Exception {
        // Pipeline should NOT be called for delete operations
    }
            MessageProcessorRunnable.MessageProcessorMetrics.create()
        verify(ingestService, never()).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());
        when(documentMapperForType.getDocumentMapper()).thenReturn(documentMapper);
        MessageProcessorRunnable.MessageProcessor processor = mock(MessageProcessorRunnable.MessageProcessor.class);
            }
        assertBusy(() -> {
        ArgumentCaptor<SourceToParse> captor = ArgumentCaptor.forClass(SourceToParse.class);
            IllegalArgumentException.class,
        assertBusy(() -> {
                sourceMap.put(addedField, addedValue);
import static org.mockito.ArgumentMatchers.anyInt;
        byte[] payload = "{\"_id\":\"1\",\"_op_type\":\"delete\"}".getBytes(StandardCharsets.UTF_8);
import java.util.concurrent.ArrayBlockingQueue;
            BiConsumer<Integer, Exception> onFailure = invocation.getArgument(2);
        byte[] payload = "{\"_id\":\"1\", \"_op_type\":\"update\"}".getBytes(StandardCharsets.UTF_8);
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(
            verify(processor, times(2)).process(any(), any());
public class MessageProcessorTests extends OpenSearchTestCase {
        metrics2.invalidMessageCounter().inc(0);
            return null;
        assertTrue(operation.engineOperation() instanceof Engine.Delete);
    }
        metrics2.versionConflictCounter().inc(0);
            RuntimeException.class,
            new ArrayBlockingQueue<>(5),
        doThrow(new RuntimeException()).when(processor).process(any(), any());
            new IngestPipelineExecutor(mock(IngestService.class), "index", (String) null)
        assertTrue(e.getCause().getMessage().contains("Pipeline processor failed"));
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
import org.opensearch.index.mapper.DocumentMapperForType;
    public void setUp() throws Exception {
import org.opensearch.index.engine.Engine;
 *
        assertThrows(
    private DocumentMapper documentMapper;
        );
            IllegalArgumentException.class,
        RuntimeException e = assertThrows(
import org.opensearch.index.engine.FakeIngestionSource;
        messageProcessorRunnable.getBlockingQueue().put(new ShardUpdateMessage(null, null, null, 0));
    }
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
        assertEquals("1", deleteOperation.id());
        }, 2, TimeUnit.MINUTES);
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}, \"_op_type\": \"create\"}".getBytes(
            errorStrategy,
        metrics1.invalidMessageCounter().inc(5);
                MessageProcessorRunnable.MessageProcessorMetrics.create()
import static org.mockito.ArgumentMatchers.any;
        // Mock pipeline that fails
            MessageProcessorRunnable.MessageProcessorMetrics.create()
        MessageProcessorRunnable messageProcessorRunnable = new MessageProcessorRunnable(
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "test-pipeline");
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), 0),
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        // IngestService should NOT be called when no pipelines configured
                MessageProcessorRunnable.MessageProcessorMetrics.create()
 */
        thread.start();
            return null;
package org.opensearch.indices.pollingingest;
            onCompletion.accept(Thread.currentThread(), null);
    /**
        metrics2.processorThreadInterruptCounter().inc(1);
import org.opensearch.index.mapper.DocumentMapper;
        );
        byte[] payload = "{\"_id\":\"1\", \"_op_type\":100}".getBytes(StandardCharsets.UTF_8);
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
import org.opensearch.action.index.IndexRequest;
    @Before
        assertEquals("index", captor.getValue().index());
        byte[] payload = "{\"_id\":\"1\",\"_op_type\":\"delete\"}".getBytes(StandardCharsets.UTF_8);
            () -> proc.getOperation(
import org.opensearch.index.Message;
            MessageProcessorRunnable.MessageProcessorMetrics.create()
            )
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), 0),
        assertEquals("1", captor.getValue().id());
            assertEquals(1, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageCounter().count());
        IngestService ingestService = mock(IngestService.class);
    }
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "_none");
        final byte[] payload = "{\"_id\":\"1\"}".getBytes(StandardCharsets.UTF_8);
        doAnswer(invocation -> {
            () -> processor.getOperation(
 * this file be licensed under the Apache-2.0 license or a
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
        IngestPipelineExecutor pipelineExecutor = new IngestPipelineExecutor(ingestService, "test_index", resolvedPipeline);
import org.opensearch.index.mapper.SourceToParse;
        ingestionEngine = mock(IngestionEngine.class);
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(
import org.opensearch.index.mapper.ParseContext;
    public void testGetIndexOperationInCreateMode() throws IOException {
 * compatible open source license.
import static org.mockito.Mockito.mock;
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(
            return null;
        ArgumentCaptor<SourceToParse> captor = ArgumentCaptor.forClass(SourceToParse.class);
        DropIngestionErrorStrategy errorStrategy = new DropIngestionErrorStrategy("ingestion_source");
        metrics2.failedMessageCounter().inc(100);
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "drop-pipeline");
        MessageProcessorRunnable.MessageProcessorMetrics metrics1 = MessageProcessorRunnable.MessageProcessorMetrics.create();
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
            0
    }
    }
            IllegalArgumentException.class,
                MessageProcessorRunnable.MessageProcessorMetrics.create()
        // Verify IngestService was called
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        );
    }
        processor = new MessageProcessorRunnable.MessageProcessor(
        ParsedDocument parsedDoc = mock(ParsedDocument.class);
    }
        MessageProcessorRunnable.MessageProcessor processor = mock(MessageProcessorRunnable.MessageProcessor.class);
        doThrow(new RuntimeException()).doNothing().when(processor).process(any(), any());
        DocumentMapperForType dmft = mock(DocumentMapperForType.class);
            MessageProcessorRunnable.MessageProcessorMetrics.create()
            MessageProcessorRunnable.MessageProcessorMetrics.create()
        MessageProcessorRunnable messageProcessorRunnable = new MessageProcessorRunnable(
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
import static org.mockito.Mockito.verify;
import java.io.IOException;
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
import static org.mockito.Mockito.times;
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
    }
            onCompletion.accept(Thread.currentThread(), null);
        );
    private void mockPipelineExecution(IngestService ingestService, String addedField, Object addedValue) {
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
            IntConsumer onDropped = invocation.getArgument(4);
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), System.currentTimeMillis()),
        doAnswer(invocation -> {
        verify(documentMapper).parse(captor.capture());
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
                MessageProcessorRunnable.MessageProcessorMetrics.create()
        metrics2.failedMessageDroppedCounter().inc(100);
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());
        assertTrue(operation.engineOperation() instanceof Engine.Index);
            assertEquals(6, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageCounter().count());
    }
import org.mockito.ArgumentCaptor;
     * Creates a MessageProcessor with a mocked IngestService and index settings that have a final_pipeline configured.
    }
        super.setUp();
        metrics1.processedCounter().inc(100);
import static org.mockito.Mockito.doAnswer;
                MessageProcessorRunnable.MessageProcessorMetrics.create()
        assertThrows(
    public void testGetIndexOperation() throws IOException {
            "index",
            IllegalArgumentException.class,
    public void testMissingID() throws IOException {
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
        messageProcessorRunnable.close();
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        metrics1.failedMessageCounter().inc(1);
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());
            for (DocWriteRequest<?> req : requests) {
        ParsedDocument parsedDocument = mock(ParsedDocument.class);
        when(engine.getDocumentMapperForType()).thenReturn(dmft);
            )
        IngestService ingestService = mock(IngestService.class);
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);
        IngestService ingestService = mock(IngestService.class);
        IngestService ingestService = mock(IngestService.class);
    public void testProcessWithFinalPipeline() throws Exception {
    }
            // Simulate pipeline adding a field to the source
        messageProcessorRunnable.getBlockingQueue()
        metrics1.versionConflictCounter().inc(2);
        return new MessageProcessorRunnable.MessageProcessor(engine, "test_index", pipelineExecutor);
            .put(new ShardUpdateMessage(mock(IngestionShardPointer.class), null, Collections.emptyMap(), -1));
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
    public void testDropPolicyMessageRetryFail() throws Exception {
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        );
        final byte[] payload2 = "{\"_id\":\"1\", \"_source\":1}".getBytes(StandardCharsets.UTF_8);
        Thread thread = new Thread(messageProcessorRunnable::run);
import static org.mockito.Mockito.when;
    }
                IndexRequest indexRequest = (IndexRequest) req;
            assertEquals(2, messageProcessorRunnable.getMessageProcessorMetrics().failedMessageDroppedCounter().count());
import org.opensearch.test.OpenSearchTestCase;
import java.util.function.BiConsumer;
        doAnswer(invocation -> {
        DocumentMapper dm = mock(DocumentMapper.class);
                indexRequest.source(sourceMap);
            )
            Iterable<DocWriteRequest<?>> requests = invocation.getArgument(1);
        assertEquals(2, combinedMetric.versionConflictCounter().count());
        when(documentMapper.parse(any())).thenReturn(parsedDocument);
        IngestionEngine engine = mock(IngestionEngine.class);
                ((IndexRequest) req).id("changed_id");
}
    }
import org.opensearch.action.DocWriteRequest;
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "test-pipeline");
 * SPDX-License-Identifier: Apache-2.0
        );
    }
    public void testPipelineDropsDocument() throws Exception {
        );
        assertThrows(
            processor,
        throws Exception {
            () -> processor.getOperation(
        assertTrue(operation.engineOperation() instanceof Engine.Index);
        when(ingestionEngine.getDocumentMapperForType()).thenReturn(documentMapperForType);
        );
        thread.start();
    }
        assertEquals(101, combinedMetric.failedMessageDroppedCounter().count());
        when(parsedDocument.rootDoc()).thenReturn(new ParseContext.Document());
import java.util.concurrent.TimeUnit;
            new ArrayBlockingQueue<>(5),
        ParsedDocument parsedDocument = mock(ParsedDocument.class);
    public void testPipelineNotCalledForDeleteOperations() throws Exception {
            processor,
            BiConsumer<Thread, Exception> onCompletion = invocation.getArgument(3);
        );
            () -> processor.getOperation(
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
    public void testSkipNoSourceIndexOperation() throws IOException {
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(
        documentMapperForType = mock(DocumentMapperForType.class);
        messageProcessorRunnable.getBlockingQueue()
            onFailure.accept(0, new RuntimeException("Pipeline processor failed"));
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        );
            )
        String resolvedPipeline = "_none".equals(finalPipeline) ? null : finalPipeline;
        mockPipelineExecution(ingestService, "pipeline_processed", true);
        );
    private MessageProcessorRunnable.MessageProcessor processor;
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(
            IllegalStateException.class,
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
    public void testPipelineMutatesId_Throws() throws Exception {
import org.opensearch.index.engine.IngestionEngine;
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
import org.junit.Before;
        messageProcessorRunnable.close();
        MessageProcessorRunnable.MessageProcessor proc = createProcessorWithPipeline(ingestService, "fail-pipeline");
            }
            for (DocWriteRequest<?> req : requests) {
        // source has wrong type
                java.util.Map<String, Object> sourceMap = indexRequest.sourceAsMap();
        IngestService ingestService = mock(IngestService.class);
        metrics1.processorThreadInterruptCounter().inc(0);
        assertEquals(5, combinedMetric.invalidMessageCounter().count());
import java.util.function.IntConsumer;
        // Dropped documents should return NoOp
    public void testMessageProcessorMetrics() {
import org.opensearch.index.IngestionShardPointer;
        }, 1, TimeUnit.MINUTES);
    /**
        MessageProcessorRunnable.MessageProcessorMetrics metrics2 = MessageProcessorRunnable.MessageProcessorMetrics.create();
        when(documentMapper.parse(any())).thenReturn(parsedDocument);
        when(parsedDoc.rootDoc()).thenReturn(new ParseContext.Document());
        when(documentMapper.parse(any())).thenReturn(parsedDocument);
        // final_pipeline = _none → no pipeline configured
        }).when(ingestService).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
            errorStrategy,
            MessageProcessorRunnable.MessageProcessorMetrics.create()
            IllegalArgumentException.class,
        when(documentMapper.parse(any())).thenReturn(parsedDocument);
    public void testDeleteWithAutoGeneratedID() throws IOException {
        assertTrue(operation.engineOperation() instanceof Engine.NoOp);
        verify(ingestService, never()).executeBulkRequestSync(anyInt(), any(), any(), any(), any());
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8);
        MessageProcessorRunnable.MessageProcessorMetrics combinedMetric = metrics1.combine(metrics2);
    public void testInvalidOperationType() throws IOException {
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
        byte[] payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\"}}".getBytes(StandardCharsets.UTF_8);
    private DocumentMapperForType documentMapperForType;
        assertTrue(operation.engineOperation() instanceof Engine.Delete);
     */
        FakeIngestionSource.FakeIngestionShardPointer pointer = new FakeIngestionSource.FakeIngestionShardPointer(0);
        assertEquals(101, combinedMetric.failedMessageCounter().count());
        IngestService ingestService = mock(IngestService.class);
    public void testPipelineFailure() throws Exception {
                new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
    }
            new ShardUpdateMessage(pointer, mock(Message.class), IngestionUtils.getParsedPayloadMap(payload), -1),
            onCompletion.accept(Thread.currentThread(), null);
            return null;
     */
        assertTrue(operation.engineOperation() instanceof Engine.Index);
    }
            "test_index",
    private MessageProcessorRunnable.MessageProcessor createProcessorWithPipeline(IngestService ingestService, String finalPipeline)
import org.opensearch.ingest.IngestService;
import static org.mockito.Mockito.never;
        ParsedDocument parsedDocument = mock(ParsedDocument.class);
        MessageProcessorRunnable.MessageOperation operation = processor.getOperation(
        assertTrue(operation.engineOperation() instanceof Engine.Index);
        // Mock pipeline that changes _id
        assertEquals("index", captor.getValue().index());
        documentMapper = mock(DocumentMapper.class);
        metrics1.failedMessageDroppedCounter().inc(1);
        assertTrue(e.getMessage().contains("_id mutations are not allowed"));
        verify(documentMapper).parse(captor.capture());
            StandardCharsets.UTF_8
        assertThrows(
    public void testGetDeleteOperation() throws IOException {
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(
        );
    public void testProcessWithNoPipelines() throws Exception {
        doAnswer(invocation -> {
            verify(processor, times(6)).process(any(), any());
    // --- Pipeline execution tests ---
        assertEquals(1, combinedMetric.processorThreadInterruptCounter().count());
        assertTrue(e.getMessage().contains("Ingest pipeline execution failed"));
        thread.interrupt();
        DropIngestionErrorStrategy errorStrategy = new DropIngestionErrorStrategy("ingestion_source");
        assertEquals(DocWriteRequest.OpType.CREATE, operation.opType());
            () -> processor.getOperation(
        Engine.Delete deleteOperation = (Engine.Delete) operation.engineOperation();
        MessageProcessorRunnable.MessageOperation operation = proc.getOperation(
        assertEquals(200, combinedMetric.processedCounter().count());
            () -> proc.getOperation(
        assertEquals("1", captor.getValue().id());
            onDropped.accept(0);
        Thread thread = new Thread(messageProcessorRunnable::run);
            )
        );
