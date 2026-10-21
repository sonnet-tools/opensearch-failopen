        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
        ingestDocument.executePipeline(pipeline1, (document, e) -> {
            public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
        assertStats(pipeline, 1, 1, 0);
        TestProcessor secondProcessor = new TestProcessor("id2", "second", null, new RuntimeException("error2"));
        assertThat(stats.getFailedCount(), equalTo(failed));
        );
        TestProcessor processor2 = new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue("field", "value"); });
            false,
            @Override
            true,
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
                assertEquals(1, secondProcessor.getInvokedCounter());
        TestProcessor processorToFail = new TestProcessor("id2", "second", null, (Consumer<IngestDocument>) ingestDocument -> {
    }
        CompoundProcessor compoundProcessor = new CompoundProcessor(
                assertEquals(secondProcessor.getInvokedCounter(), wrapperList.size() - 1);
        compoundProcessor.batchExecute(wrapperList, results -> {
import static org.mockito.Mockito.times;
                    }
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            false,
        assertThat(ingestProcessorException.getHeader("processor_type"), equalTo(singletonList("my_type")));
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
            Arrays.asList(firstProcessor, secondProcessor),
                throw new RuntimeException("fail");
import static org.opensearch.ingest.IngestDocumentPreparer.SHOULD_FAIL_KEY;
            assertEquals(0, stats.getCurrent());
        assertThat(processor1.getInvokedCounter(), equalTo(1));
                return null;
        assertStats(1, compoundProcessor, 0, 1, 0, 0);
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));
        TestProcessor secondProcessor = new TestProcessor("id3", "second", null, ingestDocument -> {
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
 * SPDX-License-Identifier: Apache-2.0
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
                }
            }
        CompoundProcessor pipeline = new CompoundProcessor(
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
            public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
            }
        assertThat(compoundProcessor.getOnFailureProcessors().isEmpty(), is(true));
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            @Override
        );
            public String getType() {
    public void testNewCompoundProcessorException() {
            }
        AtomicInteger callCounter = new AtomicInteger();
    }
            }
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("tag_fail"));
        TestProcessor processor = new TestProcessor(ingestDocument -> {
                    assertEquals(wrapperList.get(i).getSlot(), totalResults.get(i).getSlot());
    public void testSingleProcessor() throws Exception {
import java.util.HashSet;
                        assertNull(totalResults.get(i).getIngestDocument());
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));
        assertStats(compoundProcessor, 1, 1, 0);
import java.util.Set;
                throw new RuntimeException("fail");
    }
            @Override
        });
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id"));
            if (callCounter.incrementAndGet() == 3) {
            @Override
            Arrays.asList(firstProcessor, secondProcessor),
            singletonList(lastProcessor),
        });
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
import static org.mockito.Mockito.mock;
 * Unless required by applicable law or agreed to in writing,
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            new CompoundProcessor(new TestProcessor("my_tag", "my_type", null, new RuntimeException()))
            assertThat(document, notNullValue());
            null,
        );
                assertEquals(totalResults.size(), wrapperList.size());
        );
    }
                    assertEquals(wrapperList.get(i).getIngestDocument(), totalResults.get(i).getIngestDocument());
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
        );
        assertThat(compoundProcessor.getProcessors().get(0), sameInstance(processor));
    }
        AtomicInteger callCounter = new AtomicInteger();
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
                assertEquals(wrapperList.size(), firstProcessor.getInvokedCounter());
                for (int i = 0; i < wrapperList.size(); ++i) {
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
                return "pipeline";
        });
 * license agreements. See the NOTICE file distributed with
import static org.mockito.Mockito.when;
        });
            singletonList(processor2),
                    } else {
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
            Collections.emptyList(),
        assertStats(0, compoundProcessor, 0, 1, 1, 0);
            null,
                    if (2 == wrapperList.get(i).getSlot()) {
        assertThat(processor2.getInvokedCounter(), equalTo(1));
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
        });
            singletonList(processor2),
            assertEquals(0, onFailureProcessor.getInvokedCounter());
                throw new AssertionError();
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(1));
                for (int i = 0; i < wrapperList.size(); ++i) {
        assertStats(compoundProcessor, 1, 1, 0);
    public void testCompoundProcessorExceptionFail() throws Exception {
        TestProcessor processor = new TestProcessor("id", "first", null, new RuntimeException("error"));
            false,
 * this work for additional information regarding copyright
        Exception[] holder = new Exception[1];
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("first"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            IngestDocumentPreparer.createIngestDocumentWrapper(3, true)
            null,
            assertThat(ingestMetadata.entrySet(), hasSize(5));
        TestProcessor firstProcessor = new TestProcessor(doc -> {
            @Override
        List<IngestDocumentWrapper> totalResults = Collections.synchronizedList(new ArrayList<>());
        assertThat(processorToFail.getInvokedCounter(), equalTo(1));
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {
 * Modifications Copyright OpenSearch Contributors. See
        assertStats(compoundProcessor, 1, 1, 1);
        compoundProcessor.batchExecute(wrapperList, results -> {
            relativeTimeProvider
            }
import org.opensearch.test.OpenSearchTestCase;
        );
                return null;
 *
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
            singletonList(firstProcessor),
            IngestDocumentPreparer.createIngestDocumentWrapper(3)
            public String getType() {
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));
            assertEquals(secondProcessor.getInvokedCounter(), wrapperList.size());
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("first"));
                return "drop";
        CompoundProcessor failCompoundProcessor = new CompoundProcessor(
                        assertEquals(wrapperList.get(i).getIngestDocument(), totalResults.get(i).getIngestDocument());
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        CompoundProcessor failCompoundProcessor = new CompoundProcessor(
        verify(relativeTimeProvider, times(2)).getAsLong();
        IngestProcessorException ingestProcessorException1 = CompoundProcessor.newCompoundProcessorException(
                return "my_type2";
            public String getTag() {
    }
        CompoundProcessor compoundProcessor = new CompoundProcessor(
            assertThat(ingestMetadata.entrySet(), hasSize(3));
    public void testBatchExecute_happyCase() {
        });
                        assertEquals(wrapperList.get(i).getIngestDocument(), totalResults.get(i).getIngestDocument());
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("custom error message"));
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("tag_fail"));
        CompoundProcessor compoundProcessor = new CompoundProcessor(
import java.util.function.Consumer;
    public void testSingleProcessorWithNestedFailures() throws Exception {
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));
        assertStats(compoundProcessor, 1, 1, 0);
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            public String getDescription() {
                assertEquals(0, stats.getCurrent());
            singletonList(processor),
import java.util.Comparator;
                assertEquals(firstProcessor.getInvokedCounter(), wrapperList.size());
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        IngestProcessorException ingestProcessorException = (IngestProcessorException) holder[0];
    public void testSingleProcessorWithOnFailureDropProcessor() throws Exception {
            throw new RuntimeException("error");
                OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
        assertThat(secondProcessor.getInvokedCounter(), equalTo(1));
        assertThat(secondProcessor.getInvokedCounter(), equalTo(0));
        TestProcessor processor1 = new TestProcessor(new RuntimeException("error"));
            Arrays.asList(firstProcessor, secondProcessor),
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("custom error message"));
package org.opensearch.ingest;
            singletonList(compoundOnFailProcessor),
            }
        Pipeline pipeline1 = new Pipeline("1", null, null, new CompoundProcessor(false, singletonList(new AbstractProcessor(null, null) {
        AtomicInteger callCounter = new AtomicInteger();
        );
        assertThat(stats.getCurrent(), equalTo(current));
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));
import static java.util.Collections.singletonList;
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("fail"));
            relativeTimeProvider
    }
            totalResults.addAll(results);
            @Override
            assertEquals(0, stats.getCurrent());
    }
            }
import static org.hamcrest.Matchers.hasSize;
    public void testBatchExecute_documentToDrop() {
                    assertEquals(wrapperList.get(i).getSlot(), totalResults.get(i).getSlot());
                    assertEquals(wrapperList.get(i).getException(), totalResults.get(i).getException());
    }
                OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
import org.opensearch.common.metrics.OperationStats;
        });
            totalResults.addAll(results);
        assertThat(((OpenSearchException) holder[0]).getRootCause().getMessage(), equalTo("error"));
import java.util.concurrent.atomic.AtomicInteger;
            false,
        assertThat(ingestDocument.getFieldValue("field", String.class), equalTo("value"));
            IngestDocumentPreparer.createIngestDocumentWrapper(3)
            relativeTimeProvider
                throw new UnsupportedOperationException();
            singletonList(secondProcessor),
        TestProcessor onFailureProcessor = new TestProcessor(null, "on_failure", null, ingestDocument -> {
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PIPELINE_FIELD), equalTo("2"));
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
        assertThat(processor.getInvokedCounter(), equalTo(1));
            for (int i = 0; i < wrapperList.size(); ++i) {
                assertEquals(2, onFailureProcessor.getInvokedCounter());
            IngestDocumentPreparer.createIngestDocumentWrapper(3, true)
                assertEquals(totalResults.size(), wrapperList.size());
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("first"));
                assertEquals(wrapperList.get(i).getIngestDocument(), results.get(i).getIngestDocument());
            relativeTimeProvider
            }
        assertThat(processor1.getInvokedCounter(), equalTo(1));
import static org.hamcrest.Matchers.sameInstance;
            singletonList(processor1),
                assertEquals(wrapperList.get(i).getSlot(), results.get(i).getSlot());
            Arrays.asList(processor1, processor2),
            if (callCounter.incrementAndGet() == 3) {
        );
    public void testNewCompoundProcessorExceptionPipelineOrigin() {
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
            }
import java.util.ArrayList;
            assertEquals(firstProcessor.getInvokedCounter(), wrapperList.size());
        CompoundProcessor compoundProcessor = new CompoundProcessor(
            singletonList(secondProcessor),
import java.util.Collections;
                assertEquals(0, stats.getCurrent());
            assertEquals(3, stats.getCount());
import java.util.Arrays;
        pipeline.execute(ingestDocument, (result, e) -> {});
        CompoundProcessor compoundProcessor = new CompoundProcessor(relativeTimeProvider, processor);
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
            ingestDocument
        compoundProcessor.batchExecute(wrapperList, results -> {
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("fail"));
                assertEquals(totalResults.size(), wrapperList.size());
            singletonList(processor1),
            singletonList(onFailureProcessor),
                throw new RuntimeException("fail");
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(1));
                for (int i = 0; i < wrapperList.size(); ++i) {
import java.util.List;
 * specific language governing permissions and limitations
            Arrays.asList(firstProcessor, secondProcessor),
 * The OpenSearch Contributors require contributions made to
/*
        );
 * Licensed to Elasticsearch under one or more contributor
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test-processor"));
            "2",
        CompoundProcessor compoundProcessor = new CompoundProcessor(
                assertEquals(3, stats.getCount());
            @Override
            assertThat(ingestMetadata.size(), equalTo(3));
        TestProcessor lastProcessor = new TestProcessor(ingestDocument -> {
            }
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
                totalResults.sort(Comparator.comparingInt(IngestDocumentWrapper::getSlot));
            false,
        TestProcessor processor1 = new TestProcessor("id", "first", null, new RuntimeException("error"));
    public void testBatchExecute_exception_with_onFailureProcessor() {
        });
import java.util.function.BiConsumer;
        assertStats(compoundProcessor, 1, 1, 0);
            relativeTimeProvider
                assertEquals(wrapperList.get(i).getException(), results.get(i).getException());
 * KIND, either express or implied.  See the License for the
                assertEquals(wrapperList.size(), firstProcessor.getInvokedCounter());
            Collections.emptyList(),
                return null;
            }
        });
        compoundProcessor.batchExecute(wrapperList, results -> {
        compoundProcessor.execute(ingestDocument, (result, e) -> holder[0] = e);
            singletonList(onFailureProcessor),
                }
    private void assertStats(CompoundProcessor compoundProcessor, long count, long failed, long time) {
            assertEquals(results.size(), wrapperList.size());
            relativeTimeProvider
 * not use this file except in compliance with the License.
        assertThat(processor.getInvokedCounter(), equalTo(1));
        };
                    if (failureSlot.contains(wrapperList.get(i).getSlot())) {
                }
            assertEquals(firstProcessor.getInvokedCounter(), wrapperList.size());
            }
/*
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {
 */
        assertThat(ingestProcessorException.getHeader("processor_tag"), equalTo(singletonList("my_tag")));
        Pipeline pipeline2 = new Pipeline("2", null, null, new CompoundProcessor(new TestProcessor(new RuntimeException("failure!"))));
        assertThat(compoundProcessor.getProcessors().get(0), sameInstance(processor));
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
        assertThat(stats.getCount(), equalTo(count));
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
                    } else {
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            false,
                totalResults.sort(Comparator.comparingInt(IngestDocumentWrapper::getSlot));
            relativeTimeProvider
        IngestDocument[] result = new IngestDocument[1];
    public void testSingleProcessorWithException() throws Exception {
        );
/*
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error"));
            false,
            relativeTimeProvider
import org.junit.Before;
            assertThat(ingestMetadata.size(), equalTo(3));
        );
    }
import static org.hamcrest.Matchers.notNullValue;
            Arrays.asList(firstProcessor, secondProcessor),
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));
        TestProcessor onFailureProcessor = new TestProcessor("id2", "on_failure", null, doc -> {});
        CompoundProcessor compoundProcessor = new CompoundProcessor(
            relativeTimeProvider
        assertThat(processor.getProcessors().isEmpty(), is(true));
            relativeTimeProvider
        });
    public void testFailureProcessorIsInvokedOnFailure() {
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
        Processor processor2 = new Processor() {
        ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
                        assertEquals(wrapperList.get(i).getException(), totalResults.get(i).getException());
import java.util.function.LongSupplier;
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
        });
        });
        CompoundProcessor compoundProcessor = new CompoundProcessor(relativeTimeProvider, processor);
            false,
                ingestDocument.executePipeline(pipeline2, handler);
        );
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        );
            false,
public class CompoundProcessorTests extends OpenSearchTestCase {
    public void testCompoundProcessorExceptionFailInOnFailure() throws Exception {
        Set<Integer> failureSlot = new HashSet<>(Arrays.asList(2, 3));
import java.util.Map;
            true,
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
 * under the License.
            null,
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error"));
                ingestDocument.executePipeline(pipeline2, handler);
        assertThat(secondProcessor.getInvokedCounter(), equalTo(1));
            assertThat(ingestMetadata.entrySet(), hasSize(3));
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error1"));
                return null;
        processor.execute(ingestDocument, (result, e) -> {});
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            new RuntimeException(),
        assertThat(compoundProcessor.getProcessors().get(0), sameInstance(processor));
import static org.hamcrest.CoreMatchers.equalTo;
        });
            @Override
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id"));
        assertStats(compoundProcessor, 1, 0, 1);
        verify(relativeTimeProvider, times(2)).getAsLong();
                assertEquals(2, stats.getFailedCount());
    @Before
                assertEquals(3, stats.getCount());
}
            assertEquals(secondProcessor.getInvokedCounter(), wrapperList.size());
            OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
        assertStats(0, compoundProcessor, 0L, count, failed, time);
    }
        );
        });
    }
    }
        assertThat(compoundProcessor.getProcessors().size(), equalTo(1));
        CompoundProcessor compoundProcessor = new CompoundProcessor(
import org.opensearch.OpenSearchException;
        assertThat(processor.getOnFailureProcessors().isEmpty(), is(true));
            assertThat(e, nullValue());
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
    public void testBatchExecute_ignoreFailure() {
        });
            relativeTimeProvider
 * the Apache License, Version 2.0 (the "License"); you may
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            processor,
    public void init() {
            singletonList(new CompoundProcessor(relativeTimeProvider, failProcessor))
                assertEquals(3, stats.getCount());
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
import static org.hamcrest.Matchers.is;
        assertThat(compoundProcessor.getProcessors().size(), equalTo(1));
    }
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
                    }
            assertStats(0, ingestDocument.getFieldValue("compoundProcessor", CompoundProcessor.class), 1, 0, 0, 0);
        assertThat(stats.getTotalTime(), equalTo(time));
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(1));
            }
        );
        TestProcessor processor2 = new TestProcessor(ingestDocument -> {
        });
            singletonList(onFailureProcessor),
                assertEquals(1, secondProcessor.getInvokedCounter());
    }
        });
                    assertNull(totalResults.get(i).getException());
        assertStats(compoundProcessor, 1, 1, 0);
            totalResults.addAll(results);
        ingestDocument.setFieldValue("compoundProcessor", compoundProcessor); // ugly hack to assert current count = 1
        TestProcessor secondProcessor = new TestProcessor("id3", "second", null, ingestDocument -> {
        });
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            IngestDocumentPreparer.createIngestDocumentWrapper(3, true)
            assertEquals(3, stats.getCount());
        IngestProcessorException ingestProcessorException2 = CompoundProcessor.newCompoundProcessorException(
            }
        TestProcessor secondProcessor = new TestProcessor("id3", "second", null, ingestDocument -> {
            singletonList(failCompoundProcessor),
        CompoundProcessor failCompoundProcessor = new CompoundProcessor(relativeTimeProvider, firstProcessor);
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        );
            assertEquals(results.size(), wrapperList.size());
            assertThat(ingestMetadata.entrySet(), hasSize(3));
        );
 * GitHub history for details.
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            singletonList(processorToFail),
        );
            }
    public void testBatchExecute_exception_no_onFailureProcessor() {
    public void testCompoundProcessorExceptionFailWithoutOnFailure() throws Exception {
            IngestDocumentPreparer.createIngestDocumentWrapper(2),
        TestProcessor failProcessor = new TestProcessor("tag_fail", "fail", null, new RuntimeException("custom error message"));
 *
    }
    }
        compoundProcessor.batchExecute(wrapperList, results -> {
            assertThat(ingestMetadata.get("pipeline"), equalTo("1"));
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("failure!"));
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
    private IngestDocument ingestDocument;
        Pipeline pipeline1 = new Pipeline("1", null, null, new CompoundProcessor(new AbstractProcessor(null, null) {
            if (callCounter.addAndGet(results.size()) == 3) {
            false,
 */
        assertThat(compoundProcessor.getOnFailureProcessors().isEmpty(), is(true));
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {
            @Override
        );
 * this file be licensed under the Apache-2.0 license or a
 *
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
    public void testBreakOnFailure() throws Exception {
        assertThat(lastProcessor.getInvokedCounter(), equalTo(1));
            false,
        TestProcessor onFailureProcessor = new TestProcessor("id2", "on_failure", null, ingestDocument -> {});
            for (int i = 0; i < wrapperList.size(); ++i) {
        Exception[] holder = new Exception[1];
            public String getType() {
        assertThat(ingestProcessorException1.getHeader("processor_tag"), equalTo(singletonList("my_tag")));
        assertThat(ingestProcessorException2, sameInstance(ingestProcessorException1));
        assertStats(compoundProcessor, 1, 1, 0);
        }));
        TestProcessor failProcessor = new TestProcessor("tag_fail", "fail", null, new RuntimeException("custom error message"));
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(1));
            singletonList(secondProcessor),
 * You may obtain a copy of the License at
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        );
                // Simulates the drop processor
    }
        List<IngestDocumentWrapper> totalResults = Collections.synchronizedList(new ArrayList<>());
    }
                assertEquals(wrapperList.get(i).getException(), results.get(i).getException());
        CompoundProcessor compoundProcessor = new CompoundProcessor(
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
            assertThat(ingestMetadata.size(), equalTo(3));
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id2"));
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), nullValue());
 * ownership. Elasticsearch licenses this file to you under
    public void testIgnoreFailure() throws Exception {
                totalResults.sort(Comparator.comparingInt(IngestDocumentWrapper::getSlot));
        assertThat(ingestProcessorException.getHeader("pipeline_origin"), equalTo(Arrays.asList("2", "1")));
                    assertEquals(wrapperList.get(i).getSlot(), totalResults.get(i).getSlot());
import java.util.HashMap;
                OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
            }
    }
import static org.mockito.Mockito.verify;
        assertThat(processor2.getInvokedCounter(), equalTo(1));
            Arrays.asList(firstProcessor, secondProcessor),
            return doc;
        );
        assertThat(processor1.getInvokedCounter(), equalTo(1));
        TestProcessor processor = new TestProcessor(new RuntimeException("error"));
                assertEquals(wrapperList.get(i).getSlot(), results.get(i).getSlot());
        assertThat(ingestProcessorException1.getHeader("pipeline_origin"), nullValue());
        TestProcessor firstProcessor = new TestProcessor("", "", "", doc -> {
        compoundProcessor.execute(ingestDocument, (r, e) -> result[0] = r);
            processor,
    public void testEmpty() throws Exception {
            relativeTimeProvider
            @Override
            OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
 * software distributed under the License is distributed on an
        List<IngestDocumentWrapper> totalResults = Collections.synchronizedList(new ArrayList<>());
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
            relativeTimeProvider
                assertEquals(2, stats.getFailedCount());
        CompoundProcessor processor = new CompoundProcessor();
        TestProcessor onFailureProcessor = new TestProcessor("id2", "on_failure", null, doc -> {});
        }), singletonList(onFailureProcessor)));
            relativeTimeProvider
        TestProcessor firstProcessor = new TestProcessor(doc -> {
        assertThat(result[0], nullValue());
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
        TestProcessor processor = new TestProcessor("my_tag", "my_type", null, new RuntimeException());
import java.util.concurrent.TimeUnit;
        );
            }
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));
 * compatible open source license.
import static org.hamcrest.Matchers.nullValue;
 */
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));
    private void assertStats(int processor, CompoundProcessor compoundProcessor, long current, long count, long failed, long time) {
            ingestProcessorException1,
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
            singletonList(failProcessor),
                assertEquals(0, stats.getCurrent());
        TestProcessor processor1 = new TestProcessor("id", "first", null, new RuntimeException("error"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            false,
        );
        Pipeline pipeline2 = new Pipeline(
        TestProcessor firstProcessor = new TestProcessor(doc -> {});
        TestProcessor firstProcessor = new TestProcessor(doc -> {
        assertThat(ingestProcessorException1.getHeader("processor_type"), equalTo(singletonList("my_type")));
            singletonList(failCompoundProcessor),
        );
        assertThat(secondProcessor.getInvokedCounter(), equalTo(1));
        ingestDocument.executePipeline(pipeline1, (document, e) -> holder[0] = e);
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("second"));
    }
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id1"));
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error"));
        CompoundProcessor compoundOnFailProcessor = new CompoundProcessor(
            ingestDocument
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
            relativeTimeProvider
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
            false,
                assertEquals(wrapperList.get(i).getIngestDocument(), results.get(i).getIngestDocument());
            false,
            singletonList(failCompoundProcessor),
    }
    public void testSingleProcessorWithOnFailureProcessor() throws Exception {
        OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(processor).v2().createStats();
            }
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
                        assertNotNull(totalResults.get(i).getException());
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
            singletonList(firstProcessor),
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
            }
