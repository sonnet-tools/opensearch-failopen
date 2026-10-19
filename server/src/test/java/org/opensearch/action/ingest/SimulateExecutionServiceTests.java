        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
    }  
        assertThat(
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getIngestDocument(), nullValue());
    }
 * this work for additional information regarding copyright
        assertThat(verboseResult.getProcessorResults().get(0).getFailure(), nullValue());
 */  
    }  
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
import static org.hamcrest.Matchers.equalTo;  
        latch.await();  
        CountDownLatch latch = new CountDownLatch(1);  
 * compatible open source license.
        CountDownLatch latch = new CountDownLatch(1);  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure(), nullValue());
        executionService.executeDocument(pipeline, ingestDocument, false, (r, e) -> {
        assertThat(simulateDocumentBaseResult.getFailure(), nullValue());
        assertThat(errorHolder.get(), nullValue());
        }
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        SimulateDocumentResult actualItemResponse = holder.get();
        latch.await();
    }
    }  
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
            holder.set(r);
    public void testExecuteVerboseItemExceptionWithoutOnFailure() throws Exception {
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(3));
            responseHolder.set(response);
        });
            holder.set(r);
            holder.set(r);  
 * this file be licensed under the Apache-2.0 license or a
/*
        assertThat(actualItemResponse, instanceOf(SimulateDocumentBaseResult.class));
        TestProcessor testProcessor = new TestProcessor("processor_0", "mock", null, ingestDocument -> {});  
import org.opensearch.ingest.IngestDocument;  
 */  
        assertThat(processor.getInvokedCounter(), equalTo(1));
        }
 * the Apache License, Version 2.0 (the "License"); you may
public class SimulateExecutionServiceTests extends OpenSearchTestCase {
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getProcessorTag(), equalTo("processor_1"));
        AtomicReference<Exception> errorHolder = new AtomicReference<>();
import static org.mockito.Mockito.mock;
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
        TestProcessor processor1 = new TestProcessor("processor_0", "mock", null, ingestDocument -> {});  
import org.opensearch.ingest.TestProcessor;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testExecuteVerboseItem() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
    private IngestDocument ingestDocument;
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
        assertThat(processor1.getInvokedCounter(), equalTo(1));  
        assertThat(verboseResult.getProcessorResults().get(1).getFailure(), nullValue());  
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));  
        for (int id = 0; id < numDocs; id++) {
import java.util.ArrayList;
import java.util.function.BiConsumer;  
    ) {
        );
        executionService.execute(request, ActionListener.wrap(response -> {  
        }));  
        List<IngestDocument> documents = new ArrayList<>(numDocs);  
            errorHolder.set(e);
import static org.hamcrest.Matchers.not;  
            }  
import org.junit.Before;
            }
import static org.hamcrest.Matchers.sameInstance;  
        TestProcessor processor1 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field", "value"));  
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) actualItemResponse;  
        threadPool = new TestThreadPool(SimulateExecutionServiceTests.class.getSimpleName());
    public void testExecuteVerboseItemExceptionWithIgnoreFailure() throws Exception {
        TestProcessor processor = new TestProcessor("test-id", "mock", null, ingestDocument -> {});  
    @After  
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2, processor3));  
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor));
        latch.await();  
        for (int id = 0; id < numDocs; id++) {
        assertThat(runtimeException.getMessage(), equalTo("processor failed"));
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) actualItemResponse;  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));  
        SimulateDocumentResult actualItemResponse = holder.get();  
        assertThat(actualItemResponse, instanceOf(SimulateDocumentBaseResult.class));
    }
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor, processor));
            latch.countDown();
        latch.await();
        SimulateDocumentResult actualItemResponse = holder.get();
import java.util.List;
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        );
        int numDocs = randomIntBetween(1, 64);
        SimulateDocumentResult actualItemResponse = holder.get();
    }  
import java.util.concurrent.TimeUnit;
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));  
            ingestDocumentWithOnFailureMetadata
    public void testValidateProcessorCountForIngestPipelineThrowsException() {
import org.opensearch.threadpool.TestThreadPool;
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), sameInstance(exception));
        RuntimeException runtimeException = (RuntimeException) simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure();  
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));
        CompoundProcessor processor = new CompoundProcessor(true, Collections.singletonList(testProcessor), Collections.emptyList());
        assertThat(exception, instanceOf(IngestProcessorException.class));
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));  
        }, e -> {  
            pipeline.getId(),  
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(1), pipeline.getId(), ingestDocument);  
            holder.set(r);
                });
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getIngestDocument(), not(sameInstance(ingestDocument)));  
    public void setup() {
        String actualPipelineId = (String) simulateVerboseIngestDocument.getIngestMetadata().remove("pipeline");  
    public void testDropDocument() throws Exception {
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
    private IngestService ingestService;
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        SimulateDocumentResult actualItemResponse = holder.get();  
import org.opensearch.test.OpenSearchTestCase;
        SimulateDocumentResult actualItemResponse = holder.get();  
        SimulateDocumentResult actualItemResponse = holder.get();
        metadata.put(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD, "mock");
        SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
        TestProcessor processor1 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field1", "value"));
        assertThat(processor2.getInvokedCounter(), equalTo(1));
            "_id",  
        TestProcessor processor = new TestProcessor("processor_0", "mock", null, ingestDocument -> {});  
    private static void assertVerboseResult(  
    }
        RuntimeException exception = new RuntimeException("processor failed");
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
    }  
        Exception exception = simulateDocumentBaseResult.getFailure();  
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();  
                new CompoundProcessor(false, Collections.singletonList(processor1), Collections.singletonList(processor2)),
import java.util.HashMap;  
import static org.hamcrest.Matchers.notNullValue;
        SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
        assertThat(verboseResult.getProcessorResults().get(0).getFailure(), nullValue());
        TestProcessor processor2 = new TestProcessor("processor_1", "mock", null, ingestDocument -> {});  
    }
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(2), pipeline.getId(), ingestDocument);  
            simulateDocumentVerboseResult.getProcessorResults().get(1),
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));  
    public void testExecuteItem() throws Exception {
        assertVerboseResult(
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();  
        CountDownLatch latch = new CountDownLatch(1);  
        assertThat(simulateDocumentBaseResult.getFailure(), nullValue());
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {  
import org.opensearch.ingest.CompoundProcessor;
        IngestDocument ingestDocumentWithOnFailureMetadata = new IngestDocument(ingestDocument);
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), instanceOf(RuntimeException.class));
import org.opensearch.core.action.ActionListener;
        TestProcessor testProcessor = new TestProcessor("processor_0", "mock", null, exception);  
    private SimulateExecutionService executionService;  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(1));
            )  
        });
            }
            public String getType() {
    }  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure(), instanceOf(RuntimeException.class));
        assertThat(processor1.getInvokedCounter(), equalTo(1));
                return "none-of-your-business";  
        assertThat(verboseResult.getProcessorResults().get(1).getIngestDocument(), nullValue());
import java.util.Collections;
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("test-id"));
        Processor processor2 = new DropProcessor.Factory().create(Collections.emptyMap(), null, null, Collections.emptyMap());
    public void testExecuteItemWithFailure() throws Exception {
        Processor processor1 = new AbstractProcessor(null, null) {
        assertThat(verboseResult.getProcessorResults().get(1).getIngestDocument(), nullValue());  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
import org.opensearch.ingest.IngestProcessorException;
 * You may obtain a copy of the License at  
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2, processor3));
        executionService.executeDocument(pipeline, ingestDocument, false, (r, e) -> {
        TestProcessor processor1 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field", "value"));
    }
            latch.countDown();  
        TestProcessor processor3 = new TestProcessor("processor_2", "mock", null, ingestDocument -> {});
        assertThat(simulateDocumentBaseResult.getIngestDocument(), nullValue());  
        );
        assertThat(processor3.getInvokedCounter(), equalTo(0));
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(2).getFailure(), nullValue());
 */
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2));
        doThrow(new IllegalStateException()).when(ingestService).validateProcessorCountForIngestPipeline(pipeline);
        IngestDocument expectedIngestDocument  
        Map<String, Object> metadata = ingestDocumentWithOnFailureMetadata.getIngestMetadata();  
import org.opensearch.ingest.Pipeline;  
 * under the License.  
import java.util.Map;
            "_description",
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));  
import org.opensearch.ingest.AbstractProcessor;  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(1));
        metadata.put(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD, "processor_0");
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getProcessorTag(), equalTo("test-id"));
                    handler.accept(ingestDocument, null);
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(2));
        };
        // The key gets added and removed during pipeline execution.
        assertThat(actualItemResponse, instanceOf(SimulateDocumentBaseResult.class));
import org.opensearch.ingest.IngestService;
        assertThat(simulateVerboseIngestDocument, not(sameInstance(expectedIngestDocument)));  
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {  
                processor3
/*  
                    ingestDocument.setFieldValue("processed", true);  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), nullValue());
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1));  
        assertThat(response.getResults().size(), equalTo(numDocs));
            holder.set(r);
        latch.await(1, TimeUnit.MINUTES);
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
            assertThat(result.getIngestDocument().getMetadata().get(IngestDocument.Metadata.ID), equalTo(Integer.toString(id)));  
    public void testDropDocumentVerboseExtraProcessor() throws Exception {  
            latch.countDown();
import org.opensearch.ingest.RandomDocumentPicks;
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(verboseResult.getProcessorResults().get(0).getIngestDocument(), notNullValue());
import org.junit.After;
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        assertThat(exception.getMessage(), equalTo("java.lang.RuntimeException: processor failed"));
            not(sameInstance(simulateDocumentVerboseResult.getProcessorResults().get(0).getIngestDocument().getSourceAndMetadata()))  
        SimulateDocumentResult actualItemResponse = holder.get();
                threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> {
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2));
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
 * GitHub history for details.
        latch.await();
            holder.set(r);
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure(), nullValue());  
            latch.countDown();
 *  
import org.opensearch.threadpool.ThreadPool;  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(2));
            public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
        List<IngestDocument> documents = new ArrayList<>(numDocs);
            holder.set(r);  
        assertThat(verboseResult.getProcessorResults().size(), equalTo(2));  
import static org.hamcrest.Matchers.is;
        latch.await();  
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
        assertThat(simulateDocumentBaseResult.getIngestDocument(), equalTo(ingestDocument));
    public void destroy() {
        assertThat(simulateDocumentBaseResult.getFailure(), instanceOf(RuntimeException.class));
            version,
package org.opensearch.action.ingest;
/*  
        assertThat(processor.getInvokedCounter(), equalTo(2));
    private TestThreadPool threadPool;
        TestProcessor processor2 = new TestProcessor("processor_1", "mock", null, new RuntimeException("processor failed"));
            holder.set(r);  
        IngestDocument simulateVerboseIngestDocument = result.getIngestDocument();
        AtomicReference<SimulatePipelineResponse> responseHolder = new AtomicReference<>();  
            SimulateDocumentBaseResult result = (SimulateDocumentBaseResult) response.getResults().get(id);
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));  
        });
        CountDownLatch latch = new CountDownLatch(1);
        ingestService = mock(IngestService.class);  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), nullValue());
        TestProcessor processor1 = new TestProcessor("processor_0", "mock", null, new RuntimeException("processor failed"));
            latch.countDown();
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
import org.opensearch.ingest.Processor;
        CountDownLatch latch = new CountDownLatch(1);  
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) actualItemResponse;
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor));
        TestProcessor processor = new TestProcessor(ingestDocument -> { throw new RuntimeException("processor failed"); });  
            latch.countDown();
 * license agreements. See the NOTICE file distributed with
        assertThat(verboseResult.getProcessorResults().size(), equalTo(2));
        assertThat(processor1.getInvokedCounter(), equalTo(1));
    }  
import java.util.concurrent.CountDownLatch;  
        metadata.put(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD, "processor failed");  
        int numDocs = randomIntBetween(1, 64);
        Processor processor2 = new DropProcessor.Factory().create(Collections.emptyMap(), null, null, Collections.emptyMap());  
        // Remove and compare pipeline key. It is always in the verbose result,  
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getIngestDocument(), nullValue());
        CountDownLatch latch = new CountDownLatch(1);
                throw new UnsupportedOperationException();
            latch.countDown();
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        assertThat(processor.getInvokedCounter(), equalTo(2));
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getProcessorTag(), equalTo("processor_1"));  
        latch.await();
        assertThat(processor1.getInvokedCounter(), equalTo(1));
import java.util.concurrent.atomic.AtomicReference;
    @Before
        TestProcessor processor3 = new TestProcessor("processor_2", "mock", null, ingestDocument -> {});
            holder.set(r);  
        });
 * SPDX-License-Identifier: Apache-2.0
        String expectedPipelineId,
        SimulatePipelineRequest.Parsed request = new SimulatePipelineRequest.Parsed(pipeline, documents, false);
 * KIND, either express or implied.  See the License for the
    public void testAsyncSimulation() throws Exception {
            @Override
 * Unless required by applicable law or agreed to in writing,
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        assertThat(verboseResult.getProcessorResults().get(0).getIngestDocument(), notNullValue());  
        latch.await();
        });
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(2).getProcessorTag(), equalTo("processor_2"));
 * software distributed under the License is distributed on an
            latch.countDown();
 * Licensed to Elasticsearch under one or more contributor  
            @Override  
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor, processor));
 *
        });
 * specific language governing permissions and limitations
            latch.countDown();
        SimulatePipelineResponse response = responseHolder.get();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        CountDownLatch latch = new CountDownLatch(1);
        SimulatePipelineRequest.Parsed request = new SimulatePipelineRequest.Parsed(pipeline, documents, false);
        assertThat(verboseResult.getProcessorResults().get(1).getFailure(), nullValue());
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));  
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        Processor processor2 = new DropProcessor.Factory().create(Collections.emptyMap(), null, null, Collections.emptyMap());
        CompoundProcessor processor = new CompoundProcessor(true, Collections.singletonList(testProcessor), Collections.emptyList());
 * The OpenSearch Contributors require contributions made to  
            latch.countDown();
}
        latch.await();  
        assertThat(runtimeException.getMessage(), equalTo("processor failed"));
        });  
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));  
            documents.add(new IngestDocument("_index", Integer.toString(id), null, 0L, VersionType.INTERNAL, new HashMap<>()));
    private final Integer version = randomBoolean() ? randomInt() : null;  
        assertThat(processor2.getInvokedCounter(), equalTo(1));
        Pipeline pipeline = new Pipeline(
        RuntimeException runtimeException = (RuntimeException) simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure();  
import org.opensearch.index.VersionType;
        TestProcessor processor3 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field2", "value"));  
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor());
            latch.countDown();  
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            documents.add(new IngestDocument("_index", Integer.toString(id), null, 0L, VersionType.INTERNAL, new HashMap<>()));
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), nullValue());  
 * ownership. Elasticsearch licenses this file to you under  
        // since that is a snapshot of how the ingest doc looks during pipeline execution, but not in the final ingestDocument.
import org.opensearch.ingest.DropProcessor;
            @Override
        });
        latch.await();  
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor, processor));
        SimulateDocumentResult actualItemResponse = holder.get();
        });
            assertThat(result.getIngestDocument().getSourceAndMetadata().get("processed"), is(true));
        assertThat(response, notNullValue());
        SimulateDocumentResult actualItemResponse = holder.get();
        executionService = new SimulateExecutionService(threadPool, ingestService);
    }  
            simulateDocumentVerboseResult.getProcessorResults().get(1).getIngestDocument().getSourceAndMetadata(),
        threadPool.shutdown();
            new CompoundProcessor(  
            latch.countDown();  
        assertThat(processor3.getInvokedCounter(), equalTo(0));  
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
        assertIngestDocument(simulateVerboseIngestDocument, expectedIngestDocument);
        expectThrows(IllegalStateException.class, () -> executionService.execute(request, ActionListener.wrap(response -> {}, e -> {})));  
        CountDownLatch latch = new CountDownLatch(1);  
    public void testExecuteVerboseItemWithoutExceptionAndWithIgnoreFailure() throws Exception {
        for (int id = 0; id < numDocs; id++) {  
        assertThat(simulateDocumentBaseResult.getIngestDocument(), nullValue());
    public void testDropDocumentVerbose() throws Exception {
        });  
            holder.set(r);  
    public void testExecuteVerboseItemWithOnFailure() throws Exception {
 *
import static org.mockito.Mockito.doThrow;
import static org.hamcrest.Matchers.instanceOf;
        SimulateProcessorResult result,
        assertThat(processor1.getInvokedCounter(), equalTo(1));  
        assertThat(actualPipelineId, equalTo(expectedPipelineId));
import static org.hamcrest.Matchers.nullValue;
        executionService.executeDocument(pipeline, ingestDocument, false, (r, e) -> {  
        assertThat(simulateVerboseIngestDocument.getSourceAndMetadata(), not(sameInstance(expectedIngestDocument.getSourceAndMetadata())));
        }  
