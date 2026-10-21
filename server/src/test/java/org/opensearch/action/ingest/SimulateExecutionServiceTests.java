        });
 * GitHub history for details.
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
        }));
import org.opensearch.threadpool.TestThreadPool;
        String actualPipelineId = (String) simulateVerboseIngestDocument.getIngestMetadata().remove("pipeline");
            "_description",
        threadPool.shutdown();
import java.util.Collections;
        executionService.executeDocument(pipeline, ingestDocument, false, (r, e) -> {
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2));
        // Remove and compare pipeline key. It is always in the verbose result,
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
            holder.set(r);
        assertThat(verboseResult.getProcessorResults().get(1).getIngestDocument(), nullValue());
            public String getType() {
    @Before
        IngestDocument ingestDocumentWithOnFailureMetadata = new IngestDocument(ingestDocument);
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(verboseResult.getProcessorResults().get(1).getFailure(), nullValue());
            pipeline.getId(),
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getProcessorTag(), equalTo("processor_1"));
        });
import static org.hamcrest.Matchers.nullValue;
import java.util.concurrent.CountDownLatch;
                    ingestDocument.setFieldValue("processed", true);
                threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> {
    private IngestService ingestService;
        assertThat(verboseResult.getProcessorResults().get(0).getFailure(), nullValue());
import java.util.function.BiConsumer;
            }
            public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(1), pipeline.getId(), ingestDocument);
        RuntimeException exception = new RuntimeException("processor failed");
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor());
                });
        TestProcessor processor3 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field2", "value"));
        assertThat(actualPipelineId, equalTo(expectedPipelineId));
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        CompoundProcessor processor = new CompoundProcessor(true, Collections.singletonList(testProcessor), Collections.emptyList());
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(3));
        assertThat(verboseResult.getProcessorResults().get(0).getIngestDocument(), notNullValue());
import org.opensearch.ingest.IngestService;
        latch.await();
/*
        );
    public void testValidateProcessorCountForIngestPipelineThrowsException() {
package org.opensearch.action.ingest;
    @After
import java.util.Map;
import org.opensearch.ingest.Processor;
        assertThat(exception, instanceOf(IngestProcessorException.class));
        SimulateDocumentResult actualItemResponse = holder.get();
        );
            assertThat(result.getIngestDocument().getSourceAndMetadata().get("processed"), is(true));
        };
        assertThat(runtimeException.getMessage(), equalTo("processor failed"));
            latch.countDown();
            SimulateDocumentBaseResult result = (SimulateDocumentBaseResult) response.getResults().get(id);
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(2).getFailure(), nullValue());
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));
 * specific language governing permissions and limitations
    }
        assertThat(actualItemResponse, instanceOf(SimulateDocumentBaseResult.class));
            latch.countDown();
        latch.await();
        ingestService = mock(IngestService.class);
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
    public void testExecuteVerboseItemWithOnFailure() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        SimulateDocumentResult actualItemResponse = holder.get();
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor));
        SimulatePipelineRequest.Parsed request = new SimulatePipelineRequest.Parsed(pipeline, documents, false);
        });
            holder.set(r);
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        SimulateDocumentResult actualItemResponse = holder.get();
        }, e -> {
            holder.set(r);
        assertThat(simulateDocumentBaseResult.getIngestDocument(), nullValue());
        assertThat(processor1.getInvokedCounter(), equalTo(1));
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getProcessorTag(), equalTo("processor_1"));
            new CompoundProcessor(
        TestProcessor processor2 = new TestProcessor("processor_1", "mock", null, ingestDocument -> {});
            holder.set(r);
        metadata.put(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD, "processor_0");
        // since that is a snapshot of how the ingest doc looks during pipeline execution, but not in the final ingestDocument.
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor));
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
import static org.hamcrest.Matchers.equalTo;
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1));
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        TestProcessor processor3 = new TestProcessor("processor_2", "mock", null, ingestDocument -> {});
        assertThat(processor.getInvokedCounter(), equalTo(2));
        TestProcessor processor3 = new TestProcessor("processor_2", "mock", null, ingestDocument -> {});
        for (int id = 0; id < numDocs; id++) {
import java.util.concurrent.atomic.AtomicReference;
    }
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure(), instanceOf(RuntimeException.class));
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(2), pipeline.getId(), ingestDocument);
 *
        SimulateDocumentResult actualItemResponse = holder.get();
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), nullValue());
import org.opensearch.index.VersionType;
        SimulateDocumentResult actualItemResponse = holder.get();
 * license agreements. See the NOTICE file distributed with
    }
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), nullValue());
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
    public void testDropDocumentVerboseExtraProcessor() throws Exception {
 */
            simulateDocumentVerboseResult.getProcessorResults().get(1).getIngestDocument().getSourceAndMetadata(),
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2, processor3));
        TestProcessor testProcessor = new TestProcessor("processor_0", "mock", null, ingestDocument -> {});
    public void testDropDocument() throws Exception {
            latch.countDown();
        RuntimeException runtimeException = (RuntimeException) simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure();
    private TestThreadPool threadPool;
        });
 * compatible open source license.
        String expectedPipelineId,
}
        assertThat(processor1.getInvokedCounter(), equalTo(1));
import static org.hamcrest.Matchers.sameInstance;
        CountDownLatch latch = new CountDownLatch(1);
 */
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        SimulatePipelineRequest.Parsed request = new SimulatePipelineRequest.Parsed(pipeline, documents, false);
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(2).getProcessorTag(), equalTo("processor_2"));
    public void testDropDocumentVerbose() throws Exception {
    private IngestDocument ingestDocument;
        CompoundProcessor processor = new CompoundProcessor(true, Collections.singletonList(testProcessor), Collections.emptyList());
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) actualItemResponse;
    public void testExecuteItem() throws Exception {
        RuntimeException runtimeException = (RuntimeException) simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure();
        int numDocs = randomIntBetween(1, 64);
        TestProcessor processor = new TestProcessor("test-id", "mock", null, ingestDocument -> {});
        Pipeline pipeline = new Pipeline(
        Processor processor2 = new DropProcessor.Factory().create(Collections.emptyMap(), null, null, Collections.emptyMap());
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), sameInstance(exception));
        TestProcessor testProcessor = new TestProcessor("processor_0", "mock", null, exception);
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
import org.opensearch.core.action.ActionListener;
        metadata.put(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD, "processor failed");
        assertThat(processor2.getInvokedCounter(), equalTo(1));
    }
            }
        assertThat(actualItemResponse, instanceOf(SimulateDocumentBaseResult.class));
        }
        assertVerboseResult(
        metadata.put(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD, "mock");
        assertThat(verboseResult.getProcessorResults().get(0).getIngestDocument(), notNullValue());
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(2));
        assertThat(simulateVerboseIngestDocument.getSourceAndMetadata(), not(sameInstance(expectedIngestDocument.getSourceAndMetadata())));
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(exception.getMessage(), equalTo("java.lang.RuntimeException: processor failed"));
        doThrow(new IllegalStateException()).when(ingestService).validateProcessorCountForIngestPipeline(pipeline);
        SimulateDocumentResult actualItemResponse = holder.get();
        assertThat(simulateDocumentBaseResult.getIngestDocument(), equalTo(ingestDocument));
        });
import static org.hamcrest.Matchers.notNullValue;
        assertThat(processor3.getInvokedCounter(), equalTo(0));
        SimulateDocumentResult actualItemResponse = holder.get();
    }
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2));
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        assertThat(verboseResult.getProcessorResults().size(), equalTo(2));
        TestProcessor processor1 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field", "value"));
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
    private final Integer version = randomBoolean() ? randomInt() : null;
    public void testExecuteItemWithFailure() throws Exception {
        });
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor, processor));
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(1));
            version,
        executionService.executeDocument(pipeline, ingestDocument, false, (r, e) -> {
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), nullValue());
            holder.set(r);
        assertThat(errorHolder.get(), nullValue());
    public void testExecuteVerboseItemExceptionWithoutOnFailure() throws Exception {
            holder.set(r);
        SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
import org.opensearch.ingest.DropProcessor;
            )
    }
        latch.await();
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        // The key gets added and removed during pipeline execution.
        });
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("test-id"));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        for (int id = 0; id < numDocs; id++) {
        IngestDocument simulateVerboseIngestDocument = result.getIngestDocument();
import java.util.concurrent.TimeUnit;
    private SimulateExecutionService executionService;
import org.opensearch.ingest.TestProcessor;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(response, notNullValue());
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor, processor));
        expectThrows(IllegalStateException.class, () -> executionService.execute(request, ActionListener.wrap(response -> {}, e -> {})));
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
    }
import static org.mockito.Mockito.mock;
        latch.await();
        });
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch = new CountDownLatch(1);
                    handler.accept(ingestDocument, null);
        assertThat(processor.getInvokedCounter(), equalTo(1));
        latch.await();
        for (int id = 0; id < numDocs; id++) {
    public void testExecuteVerboseItemWithoutExceptionAndWithIgnoreFailure() throws Exception {
import org.junit.After;
        assertThat(simulateDocumentBaseResult.getFailure(), nullValue());
            "_id",
            latch.countDown();
 * ownership. Elasticsearch licenses this file to you under
        assertThat(runtimeException.getMessage(), equalTo("processor failed"));
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
        Processor processor2 = new DropProcessor.Factory().create(Collections.emptyMap(), null, null, Collections.emptyMap());
import static org.hamcrest.Matchers.not;
    public void setup() {
import java.util.ArrayList;
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure(), nullValue());
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getProcessorTag(), equalTo("test-id"));
 * software distributed under the License is distributed on an
            latch.countDown();
    }
        assertThat(simulateDocumentBaseResult.getFailure(), instanceOf(RuntimeException.class));
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
        SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
 *
        TestProcessor processor2 = new TestProcessor("processor_1", "mock", null, new RuntimeException("processor failed"));
    }
import org.opensearch.threadpool.ThreadPool;
            errorHolder.set(e);
        CountDownLatch latch = new CountDownLatch(1);
import org.junit.Before;
        CountDownLatch latch = new CountDownLatch(1);
/*
        latch.await();
        assertIngestDocument(simulateVerboseIngestDocument, expectedIngestDocument);
        assertThat(verboseResult.getProcessorResults().get(1).getFailure(), nullValue());
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getFailure(), nullValue());
 * under the License.
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
        assertThat(response.getResults().size(), equalTo(numDocs));
        assertThat(processor1.getInvokedCounter(), equalTo(1));
 * not use this file except in compliance with the License.
        SimulateDocumentResult actualItemResponse = holder.get();
 * Unless required by applicable law or agreed to in writing,
        assertThat(actualItemResponse, instanceOf(SimulateDocumentBaseResult.class));
            not(sameInstance(simulateDocumentVerboseResult.getProcessorResults().get(0).getIngestDocument().getSourceAndMetadata()))
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getIngestDocument(), nullValue());
        executionService = new SimulateExecutionService(threadPool, ingestService);
import static org.hamcrest.Matchers.is;
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
        assertThat(processor.getInvokedCounter(), equalTo(2));
        latch.await();
public class SimulateExecutionServiceTests extends OpenSearchTestCase {
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));
        int numDocs = randomIntBetween(1, 64);
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
            responseHolder.set(response);
import static org.hamcrest.Matchers.instanceOf;
        executionService.executeDocument(pipeline, ingestDocument, false, (r, e) -> {
        latch.await();
                processor3
        SimulateDocumentResult actualItemResponse = holder.get();
            latch.countDown();
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
            }
            ingestDocumentWithOnFailureMetadata
    }
        );
        TestProcessor processor1 = new TestProcessor("processor_0", "mock", null, ingestDocument -> {});
            holder.set(r);
import org.opensearch.ingest.Pipeline;
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getProcessorTag(), equalTo("processor_0"));
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(2));
        assertVerboseResult(simulateDocumentVerboseResult.getProcessorResults().get(0), pipeline.getId(), ingestDocument);
 *
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
 * KIND, either express or implied.  See the License for the
        CountDownLatch latch = new CountDownLatch(1);
        Processor processor2 = new DropProcessor.Factory().create(Collections.emptyMap(), null, null, Collections.emptyMap());
            assertThat(result.getIngestDocument().getMetadata().get(IngestDocument.Metadata.ID), equalTo(Integer.toString(id)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this work for additional information regarding copyright
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        latch.await();
            holder.set(r);
    public void testAsyncSimulation() throws Exception {
        IngestDocument expectedIngestDocument
        SimulateProcessorResult result,
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        assertThat(
 * The OpenSearch Contributors require contributions made to
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        assertThat(simulateVerboseIngestDocument, not(sameInstance(expectedIngestDocument)));
    public void destroy() {
        assertThat(processor1.getInvokedCounter(), equalTo(1));
            latch.countDown();
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
import org.opensearch.ingest.AbstractProcessor;
        }
        executionService.execute(request, ActionListener.wrap(response -> {
/*
    }
                return "none-of-your-business";
    public void testExecuteVerboseItem() throws Exception {
        assertThat(processor1.getInvokedCounter(), equalTo(1));
            latch.countDown();
 *    http://www.apache.org/licenses/LICENSE-2.0
        });
        SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) actualItemResponse;
    ) {
            documents.add(new IngestDocument("_index", Integer.toString(id), null, 0L, VersionType.INTERNAL, new HashMap<>()));
            latch.countDown();
        latch.await(1, TimeUnit.MINUTES);
import org.opensearch.ingest.IngestDocument;
        TestProcessor processor = new TestProcessor("processor_0", "mock", null, ingestDocument -> {});
        TestProcessor processor1 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field1", "value"));
        });
                new CompoundProcessor(false, Collections.singletonList(processor1), Collections.singletonList(processor2)),
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor, processor));
            documents.add(new IngestDocument("_index", Integer.toString(id), null, 0L, VersionType.INTERNAL, new HashMap<>()));
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getIngestDocument(), nullValue());
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(0).getFailure(), instanceOf(RuntimeException.class));
        CountDownLatch latch = new CountDownLatch(1);
    public void testExecuteVerboseItemExceptionWithIgnoreFailure() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        List<IngestDocument> documents = new ArrayList<>(numDocs);
        }
        assertThat(simulateDocumentVerboseResult.getProcessorResults().get(1).getIngestDocument(), not(sameInstance(ingestDocument)));
        assertThat(verboseResult.getProcessorResults().get(1).getIngestDocument(), nullValue());
    }
            holder.set(r);
            simulateDocumentVerboseResult.getProcessorResults().get(1),
        AtomicReference<Exception> errorHolder = new AtomicReference<>();
        assertThat(processor3.getInvokedCounter(), equalTo(0));
            @Override
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) actualItemResponse;
import org.opensearch.ingest.RandomDocumentPicks;
        SimulateDocumentResult actualItemResponse = holder.get();
        assertThat(verboseResult.getProcessorResults().size(), equalTo(2));
import static org.mockito.Mockito.doThrow;
        TestProcessor processor1 = new TestProcessor(ingestDocument -> ingestDocument.setFieldValue("field", "value"));
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
        assertThat(simulateDocumentBaseResult.getIngestDocument(), nullValue());
                throw new UnsupportedOperationException();
        assertThat(verboseResult.getProcessorResults().get(0).getFailure(), nullValue());
    private static void assertVerboseResult(
            @Override
        assertThat(actualItemResponse, instanceOf(SimulateDocumentVerboseResult.class));
    }
import java.util.List;
        assertThat(simulateDocumentVerboseResult.getProcessorResults().size(), equalTo(1));
            latch.countDown();
        TestProcessor processor = new TestProcessor(ingestDocument -> { throw new RuntimeException("processor failed"); });
        assertThat(processor2.getInvokedCounter(), equalTo(1));
        SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) actualItemResponse;
        assertThat(simulateDocumentBaseResult.getFailure(), nullValue());
        Processor processor1 = new AbstractProcessor(null, null) {
    }
 */
import org.opensearch.ingest.CompoundProcessor;
            latch.countDown();
        AtomicReference<SimulatePipelineResponse> responseHolder = new AtomicReference<>();
        threadPool = new TestThreadPool(SimulateExecutionServiceTests.class.getSimpleName());
import org.opensearch.ingest.IngestProcessorException;
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
        latch.await();
        TestProcessor processor1 = new TestProcessor("processor_0", "mock", null, new RuntimeException("processor failed"));
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2, processor3));
 * Licensed to Elasticsearch under one or more contributor
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
            latch.countDown();
        List<IngestDocument> documents = new ArrayList<>(numDocs);
        executionService.executeDocument(pipeline, ingestDocument, true, (r, e) -> {
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
            @Override
        Map<String, Object> metadata = ingestDocumentWithOnFailureMetadata.getIngestMetadata();
        Exception exception = simulateDocumentBaseResult.getFailure();
    }
        SimulatePipelineResponse response = responseHolder.get();
            holder.set(r);
        AtomicReference<SimulateDocumentResult> holder = new AtomicReference<>();
