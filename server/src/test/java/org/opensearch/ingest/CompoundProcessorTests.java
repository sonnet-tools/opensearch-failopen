            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id"));
            relativeTimeProvider
            IngestDocumentPreparer.createIngestDocumentWrapper(3)
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testSingleProcessorWithOnFailureDropProcessor() throws Exception {  
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
        assertStats(compoundProcessor, 1, 1, 0);  
    }
        assertThat(ingestProcessorException.getHeader("pipeline_origin"), equalTo(Arrays.asList("2", "1")));  
        compoundProcessor.batchExecute(wrapperList, results -> {  
        TestProcessor processor1 = new TestProcessor("id", "first", null, new RuntimeException("error"));
            @Override
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));  
        CompoundProcessor pipeline = new CompoundProcessor(
    }
        );
                return null;
        compoundProcessor.batchExecute(wrapperList, results -> {
                    assertNull(totalResults.get(i).getException());
            relativeTimeProvider  
    }
            singletonList(processor),
        CompoundProcessor compoundProcessor = new CompoundProcessor(
                        assertEquals(wrapperList.get(i).getIngestDocument(), totalResults.get(i).getIngestDocument());  
        assertStats(compoundProcessor, 1, 1, 0);  
            singletonList(secondProcessor),
            if (callCounter.incrementAndGet() == 3) {
            assertThat(e, nullValue());
        Pipeline pipeline1 = new Pipeline("1", null, null, new CompoundProcessor(false, singletonList(new AbstractProcessor(null, null) {  
        }), singletonList(onFailureProcessor)));  
import java.util.Collections;
        TestProcessor processor1 = new TestProcessor(new RuntimeException("error"));
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
            @Override
            singletonList(processor2),
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);  
            if (callCounter.incrementAndGet() == 3) {  
        assertThat(compoundProcessor.getProcessors().size(), equalTo(1));  
    }
        compoundProcessor.batchExecute(wrapperList, results -> {
            singletonList(compoundOnFailProcessor),
    }
        );
            @Override  
            public String getType() {
        IngestProcessorException ingestProcessorException = (IngestProcessorException) holder[0];  
    public void testSingleProcessorWithException() throws Exception {
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("tag_fail"));
            Arrays.asList(firstProcessor, secondProcessor),  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id1"));
            public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {  
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
        assertThat(compoundProcessor.getProcessors().get(0), sameInstance(processor));
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        Exception[] holder = new Exception[1];
        assertThat(ingestProcessorException2, sameInstance(ingestProcessorException1));
    }
                assertEquals(wrapperList.get(i).getSlot(), results.get(i).getSlot());  
        processor.execute(ingestDocument, (result, e) -> {});
            relativeTimeProvider  
            }
            relativeTimeProvider
 * Modifications Copyright OpenSearch Contributors. See
            processor,
        assertThat(processor.getOnFailureProcessors().isEmpty(), is(true));  
    public void testIgnoreFailure() throws Exception {  
        assertThat(processor1.getInvokedCounter(), equalTo(1));  
        CompoundProcessor compoundProcessor = new CompoundProcessor(  
import static org.opensearch.ingest.IngestDocumentPreparer.SHOULD_FAIL_KEY;
/*
        AtomicInteger callCounter = new AtomicInteger();
            false,
package org.opensearch.ingest;
    }  
        );  
            singletonList(processor1),
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
 */  
 * software distributed under the License is distributed on an
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));  
        TestProcessor secondProcessor = new TestProcessor("id2", "second", null, new RuntimeException("error2"));
        );
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);  
        assertThat(compoundProcessor.getOnFailureProcessors().isEmpty(), is(true));  
            public String getType() {  
        assertThat(processor1.getInvokedCounter(), equalTo(1));
        ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());  
    }
                throw new AssertionError();
            singletonList(onFailureProcessor),
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("second"));  
        CompoundProcessor compoundProcessor = new CompoundProcessor(
            singletonList(secondProcessor),
import static org.hamcrest.Matchers.is;
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id2"));
            OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
                }  
            Collections.emptyList(),
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {
                assertEquals(1, secondProcessor.getInvokedCounter());
    public void init() {
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
        TestProcessor onFailureProcessor = new TestProcessor(null, "on_failure", null, ingestDocument -> {
                for (int i = 0; i < wrapperList.size(); ++i) {
        CompoundProcessor compoundProcessor = new CompoundProcessor(  
            false,
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(  
        TestProcessor firstProcessor = new TestProcessor(doc -> {
            totalResults.addAll(results);
            @Override
        };
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
            @Override  
        });  
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        CompoundProcessor failCompoundProcessor = new CompoundProcessor(
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(1));  
            IngestDocumentPreparer.createIngestDocumentWrapper(3)
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error"));
            singletonList(processorToFail),
            totalResults.addAll(results);  
        assertThat(((OpenSearchException) holder[0]).getRootCause().getMessage(), equalTo("error"));  
                assertEquals(0, stats.getCurrent());  
            @Override  
    @Before
    public void testBatchExecute_happyCase() {  
        CompoundProcessor compoundProcessor = new CompoundProcessor(relativeTimeProvider, processor);
            totalResults.addAll(results);
            OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
            ingestProcessorException1,  
                    }
            assertThat(document, notNullValue());  
                    assertEquals(wrapperList.get(i).getIngestDocument(), totalResults.get(i).getIngestDocument());  
        );
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(1));
        CompoundProcessor compoundProcessor = new CompoundProcessor(
            }
            @Override
        assertThat(secondProcessor.getInvokedCounter(), equalTo(1));
            }  
            false,
import org.opensearch.test.OpenSearchTestCase;  
            assertStats(0, ingestDocument.getFieldValue("compoundProcessor", CompoundProcessor.class), 1, 0, 0, 0);
            false,
        Pipeline pipeline2 = new Pipeline("2", null, null, new CompoundProcessor(new TestProcessor(new RuntimeException("failure!"))));
            assertEquals(results.size(), wrapperList.size());
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
    public void testBatchExecute_exception_with_onFailureProcessor() {
            @Override
        assertThat(ingestProcessorException1.getHeader("processor_type"), equalTo(singletonList("my_type")));
            Arrays.asList(firstProcessor, secondProcessor),
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        });
/*  
        TestProcessor processor = new TestProcessor("my_tag", "my_type", null, new RuntimeException());
import org.opensearch.OpenSearchException;
        AtomicInteger callCounter = new AtomicInteger();  
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);  
import java.util.concurrent.atomic.AtomicInteger;
        });
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
                    assertEquals(wrapperList.get(i).getSlot(), totalResults.get(i).getSlot());
            singletonList(processor1),  
        assertStats(0, compoundProcessor, 0, 1, 1, 0);
        });  
            assertThat(ingestMetadata.entrySet(), hasSize(3));
        });  
            if (callCounter.addAndGet(results.size()) == 3) {
    }
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
import org.junit.Before;
        IngestProcessorException ingestProcessorException2 = CompoundProcessor.newCompoundProcessorException(
import static org.hamcrest.Matchers.hasSize;  
        assertThat(secondProcessor.getInvokedCounter(), equalTo(1));
            for (int i = 0; i < wrapperList.size(); ++i) {
                    }
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));  
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);  
    public void testBreakOnFailure() throws Exception {
import static org.mockito.Mockito.times;  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PIPELINE_FIELD), equalTo("2"));
            "2",  
        );  
    }
        );  
    }
        assertThat(compoundProcessor.getProcessors().get(0), sameInstance(processor));
            }
    public void testFailureProcessorIsInvokedOnFailure() {  
            Arrays.asList(firstProcessor, secondProcessor),  
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(1));  
                    assertEquals(wrapperList.get(i).getSlot(), totalResults.get(i).getSlot());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        });
        );
                assertEquals(0, stats.getCurrent());  
                assertEquals(wrapperList.get(i).getException(), results.get(i).getException());
            relativeTimeProvider  
        Processor processor2 = new Processor() {
        TestProcessor processorToFail = new TestProcessor("id2", "second", null, (Consumer<IngestDocument>) ingestDocument -> {  
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
        CompoundProcessor failCompoundProcessor = new CompoundProcessor(
        TestProcessor firstProcessor = new TestProcessor("", "", "", doc -> {
        );
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("first"));  
import static org.mockito.Mockito.verify;
                assertEquals(secondProcessor.getInvokedCounter(), wrapperList.size() - 1);
        TestProcessor firstProcessor = new TestProcessor(doc -> {
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("custom error message"));  
                assertEquals(totalResults.size(), wrapperList.size());
        }));
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
import java.util.concurrent.TimeUnit;  
                    } else {
        CompoundProcessor compoundProcessor = new CompoundProcessor(
            singletonList(failProcessor),
            }
            null,  
                OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
        Pipeline pipeline2 = new Pipeline(
import org.opensearch.common.metrics.OperationStats;
            throw new RuntimeException("error");  
            false,  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("fail"));
        );  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("id"));
            singletonList(onFailureProcessor),
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(  
        compoundProcessor.execute(ingestDocument, (r, e) -> result[0] = r);
        assertThat(ingestProcessorException1.getHeader("pipeline_origin"), nullValue());  
            IngestDocumentPreparer.createIngestDocumentWrapper(3, true)
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        assertThat(ingestProcessorException.getHeader("processor_type"), equalTo(singletonList("my_type")));
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
                assertEquals(wrapperList.get(i).getSlot(), results.get(i).getSlot());
            IngestDocumentPreparer.createIngestDocumentWrapper(2),  
            relativeTimeProvider
                assertEquals(wrapperList.size(), firstProcessor.getInvokedCounter());
import java.util.Set;
            assertEquals(0, stats.getCurrent());  
        List<IngestDocumentWrapper> totalResults = Collections.synchronizedList(new ArrayList<>());  
import java.util.ArrayList;  
import java.util.HashMap;
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));
        assertStats(compoundProcessor, 1, 1, 0);  
    private void assertStats(CompoundProcessor compoundProcessor, long count, long failed, long time) {
        assertThat(stats.getCurrent(), equalTo(current));
 * You may obtain a copy of the License at  
                return "pipeline";
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));
                }  
    }
    public void testSingleProcessorWithOnFailureProcessor() throws Exception {
        List<IngestDocumentWrapper> totalResults = Collections.synchronizedList(new ArrayList<>());
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        assertThat(lastProcessor.getInvokedCounter(), equalTo(1));
        assertThat(processor.getProcessors().isEmpty(), is(true));
        TestProcessor firstProcessor = new TestProcessor(doc -> {});  
        );
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            assertEquals(firstProcessor.getInvokedCounter(), wrapperList.size());  
 */
                assertEquals(totalResults.size(), wrapperList.size());
                    if (failureSlot.contains(wrapperList.get(i).getSlot())) {  
            relativeTimeProvider
        assertThat(firstProcessor.getInvokedCounter(), equalTo(1));
            assertEquals(secondProcessor.getInvokedCounter(), wrapperList.size());
            false,
            }
        assertStats(1, compoundProcessor, 0, 1, 0, 0);  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("tag_fail"));
    public void testNewCompoundProcessorExceptionPipelineOrigin() {
 * Unless required by applicable law or agreed to in writing,
        TestProcessor onFailureProcessor = new TestProcessor("id2", "on_failure", null, doc -> {});
            }
            null,
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
        IngestProcessorException ingestProcessorException1 = CompoundProcessor.newCompoundProcessorException(
            false,
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
                throw new RuntimeException("fail");
            ingestDocument
            singletonList(firstProcessor),  
                return "drop";
            assertEquals(firstProcessor.getInvokedCounter(), wrapperList.size());
            public String getType() {
            singletonList(firstProcessor),  
            singletonList(failCompoundProcessor),
    private void assertStats(int processor, CompoundProcessor compoundProcessor, long current, long count, long failed, long time) {
            relativeTimeProvider
        });
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("custom error message"));  
                throw new RuntimeException("fail");  
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
import java.util.Comparator;  
 * under the License.  
                // Simulates the drop processor
                assertEquals(wrapperList.get(i).getIngestDocument(), results.get(i).getIngestDocument());
            singletonList(new CompoundProcessor(relativeTimeProvider, failProcessor))
        CompoundProcessor compoundProcessor = new CompoundProcessor(
 *
        });  
    public void testCompoundProcessorExceptionFail() throws Exception {  
public class CompoundProcessorTests extends OpenSearchTestCase {
        TestProcessor secondProcessor = new TestProcessor(doc -> {});  
                assertEquals(wrapperList.get(i).getIngestDocument(), results.get(i).getIngestDocument());  
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {  
            null,
                        assertNotNull(totalResults.get(i).getException());
            assertEquals(0, stats.getCurrent());
            assertThat(ingestMetadata.entrySet(), hasSize(3));
        assertThat(processor.getInvokedCounter(), equalTo(1));  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("fail"));
        TestProcessor secondProcessor = new TestProcessor("id3", "second", null, ingestDocument -> {  
        Set<Integer> failureSlot = new HashSet<>(Arrays.asList(2, 3));
            }  
            @Override
        );  
    public void testSingleProcessorWithNestedFailures() throws Exception {
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();  
        compoundProcessor.batchExecute(wrapperList, results -> {
            assertEquals(3, stats.getCount());  
 * this file be licensed under the Apache-2.0 license or a
}  
        verify(relativeTimeProvider, times(2)).getAsLong();
        TestProcessor onFailureProcessor = new TestProcessor("id2", "on_failure", null, doc -> {});
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();  
 *
        assertThat(secondProcessor.getInvokedCounter(), equalTo(0));
                totalResults.sort(Comparator.comparingInt(IngestDocumentWrapper::getSlot));  
    public void testBatchExecute_exception_no_onFailureProcessor() {  
            singletonList(failCompoundProcessor),
    }
            false,  
        );
            assertEquals(3, stats.getCount());
        );
 * compatible open source license.
        TestProcessor processor = new TestProcessor(new RuntimeException("error"));  
    public void testEmpty() throws Exception {  
 * specific language governing permissions and limitations
        });  
            }
            new RuntimeException(),  
        pipeline.execute(ingestDocument, (result, e) -> {});
            Collections.emptyList(),
            IngestDocumentPreparer.createIngestDocumentWrapper(3, true)  
            @Override  
            assertEquals(secondProcessor.getInvokedCounter(), wrapperList.size());  
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
                totalResults.sort(Comparator.comparingInt(IngestDocumentWrapper::getSlot));  
        });
                assertEquals(firstProcessor.getInvokedCounter(), wrapperList.size());  
            }
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
        CompoundProcessor processor = new CompoundProcessor();
            assertEquals(results.size(), wrapperList.size());  
                assertEquals(3, stats.getCount());
            assertEquals(0, onFailureProcessor.getInvokedCounter());
            }
        });
                return "my_type2";  
        assertThat(stats.getTotalTime(), equalTo(time));
            true,  
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
                throw new UnsupportedOperationException();
        assertThat(ingestProcessorException.getHeader("processor_tag"), equalTo(singletonList("my_tag")));
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error"));
            ingestDocument
                ingestDocument.executePipeline(pipeline2, handler);  
        assertThat(processor1.getInvokedCounter(), equalTo(1));  
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
                assertEquals(wrapperList.get(i).getException(), results.get(i).getException());
import static org.hamcrest.Matchers.sameInstance;
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);  
    private IngestDocument ingestDocument;
    }
            false,
                    assertEquals(wrapperList.get(i).getException(), totalResults.get(i).getException());
        CompoundProcessor compoundProcessor = new CompoundProcessor(  
                ingestDocument.executePipeline(pipeline2, handler);
            }
            true,
import java.util.function.Consumer;  
        });  
            }
                assertEquals(1, secondProcessor.getInvokedCounter());  
 * ownership. Elasticsearch licenses this file to you under  
        );
            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),
import static org.mockito.Mockito.when;
                        assertEquals(wrapperList.get(i).getException(), totalResults.get(i).getException());
        TestProcessor secondProcessor = new TestProcessor("id3", "second", null, ingestDocument -> {  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("failure!"));
                }
            false,  
        );  
                assertEquals(2, stats.getFailedCount());
        IngestDocument[] result = new IngestDocument[1];  
        );  
            singletonList(onFailureProcessor),
 */  
        List<IngestDocumentWrapper> totalResults = Collections.synchronizedList(new ArrayList<>());
            Arrays.asList(firstProcessor, secondProcessor),
            false,  
            }  
            }
        });
        );
        });
                assertEquals(2, stats.getFailedCount());
        assertThat(processor2.getInvokedCounter(), equalTo(1));  
        TestProcessor onFailureProcessor = new TestProcessor("id2", "on_failure", null, ingestDocument -> {});
        CompoundProcessor compoundOnFailProcessor = new CompoundProcessor(
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
                OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();  
                assertEquals(0, stats.getCurrent());
            Arrays.asList(firstProcessor, secondProcessor),
                        assertEquals(wrapperList.get(i).getIngestDocument(), totalResults.get(i).getIngestDocument());  
                throw new RuntimeException("fail");
        TestProcessor processor = new TestProcessor(ingestDocument -> {
    }
        CompoundProcessor compoundProcessor = new CompoundProcessor(
        compoundProcessor.execute(ingestDocument, (result, e) -> {});
    }
        assertThat(processor2.getInvokedCounter(), equalTo(1));
            null,  
/*  
        assertThat(compoundProcessor.getOnFailureProcessors().isEmpty(), is(true));  
                return null;  
                totalResults.sort(Comparator.comparingInt(IngestDocumentWrapper::getSlot));  
            }
        assertThat(stats.getCount(), equalTo(count));
            processor,
            Arrays.asList(firstProcessor, secondProcessor),
    }
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));
                        assertNull(totalResults.get(i).getIngestDocument());
            assertThat(ingestMetadata.entrySet(), hasSize(3));
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(1));  
                for (int i = 0; i < wrapperList.size(); ++i) {
        ingestDocument.executePipeline(pipeline1, (document, e) -> holder[0] = e);
        TestProcessor processor2 = new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue("field", "value"); });
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD), nullValue());  
        assertThat(compoundProcessor.getProcessors().size(), equalTo(1));
    }  
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {  
        ingestDocument.setFieldValue("compoundProcessor", compoundProcessor); // ugly hack to assert current count = 1
import java.util.function.BiConsumer;
        assertThat(stats.getFailedCount(), equalTo(failed));  
        });
        TestProcessor secondProcessor = new TestProcessor("id3", "second", null, ingestDocument -> {
            }
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {
        });  
            relativeTimeProvider
            relativeTimeProvider  
            IngestDocumentPreparer.createIngestDocumentWrapper(1),  
        TestProcessor firstProcessor = new TestProcessor(doc -> {
                assertEquals(2, onFailureProcessor.getInvokedCounter());  
    public void testCompoundProcessorExceptionFailInOnFailure() throws Exception {  
import java.util.Map;
 * this work for additional information regarding copyright
            assertThat(ingestMetadata.entrySet(), hasSize(5));  
            singletonList(processor2),  
                assertEquals(totalResults.size(), wrapperList.size());
            public String getDescription() {
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            singletonList(failCompoundProcessor),  
            for (int i = 0; i < wrapperList.size(); ++i) {
        compoundProcessor.execute(ingestDocument, (result, e) -> holder[0] = e);
            assertThat(ingestMetadata.size(), equalTo(3));
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("first"));
        Pipeline pipeline1 = new Pipeline("1", null, null, new CompoundProcessor(new AbstractProcessor(null, null) {
        Exception[] holder = new Exception[1];
            Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
    }  
                    if (2 == wrapperList.get(i).getSlot()) {  
            false,  
        TestProcessor failProcessor = new TestProcessor("tag_fail", "fail", null, new RuntimeException("custom error message"));
        );  
import java.util.function.LongSupplier;
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
        );
        TestProcessor processor2 = new TestProcessor(ingestDocument -> {  
            IngestDocumentPreparer.createIngestDocumentWrapper(1),  
                assertEquals(3, stats.getCount());
 * KIND, either express or implied.  See the License for the
        compoundProcessor.batchExecute(wrapperList, results -> {
import java.util.Arrays;
                OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(0).v2().createStats();
        AtomicInteger callCounter = new AtomicInteger();
            relativeTimeProvider
        assertThat(secondProcessor.getInvokedCounter(), equalTo(1));
            singletonList(secondProcessor),
                assertEquals(wrapperList.size(), firstProcessor.getInvokedCounter());
    public void testCompoundProcessorExceptionFailWithoutOnFailure() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
        TestProcessor lastProcessor = new TestProcessor(ingestDocument -> {
    }  
        assertStats(pipeline, 1, 1, 0);  
import java.util.HashSet;
        assertStats(compoundProcessor, 1, 1, 0);
import static org.mockito.Mockito.mock;
        OperationStats stats = compoundProcessor.getProcessorsWithMetrics().get(processor).v2().createStats();  
        assertThat(ingestProcessorException1.getHeader("processor_tag"), equalTo(singletonList("my_tag")));
        assertThat(result[0], nullValue());
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test-processor"));
    public void testBatchExecute_documentToDrop() {
        assertStats(0, compoundProcessor, 0L, count, failed, time);
        verify(relativeTimeProvider, times(2)).getAsLong();
        });  
                    assertEquals(wrapperList.get(i).getSlot(), totalResults.get(i).getSlot());
            relativeTimeProvider  
                for (int i = 0; i < wrapperList.size(); ++i) {
        );
        CompoundProcessor failCompoundProcessor = new CompoundProcessor(relativeTimeProvider, firstProcessor);  
        assertStats(compoundProcessor, 1, 1, 0);
            return doc;
        TestProcessor failProcessor = new TestProcessor("tag_fail", "fail", null, new RuntimeException("custom error message"));
        assertThat(compoundProcessor.getProcessors().get(0), sameInstance(processor));
            relativeTimeProvider  
            assertThat(ingestMetadata.size(), equalTo(3));
            relativeTimeProvider  
            relativeTimeProvider
    }  
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
        assertThat(processorToFail.getInvokedCounter(), equalTo(1));
import static java.util.Collections.singletonList;  
            IngestDocumentPreparer.createIngestDocumentWrapper(3, true)  
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        );
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);  
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error"));
        assertStats(compoundProcessor, 1, 1, 0);
        );  
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);  
        TestProcessor processor1 = new TestProcessor("id", "first", null, new RuntimeException("error"));
                return null;  
            public String getTag() {  
        TestProcessor secondProcessor = new TestProcessor(doc -> {});
        TestProcessor firstProcessor = new TestProcessor("id1", "first", null, new RuntimeException("error1"));  
        assertThat(ingestDocument.getFieldValue("field", String.class), equalTo("value"));
    public void testSingleProcessor() throws Exception {
            false,  
import static org.hamcrest.Matchers.nullValue;  
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);  
            public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
        assertStats(compoundProcessor, 1, 1, 1);
    public void testNewCompoundProcessorException() {  
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
        );
            false,
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
            new CompoundProcessor(new TestProcessor("my_tag", "my_type", null, new RuntimeException()))  
 * license agreements. See the NOTICE file distributed with
                assertEquals(3, stats.getCount());
        CompoundProcessor compoundProcessor = new CompoundProcessor(relativeTimeProvider, processor);  
            Arrays.asList(processor1, processor2),
 *  
 * not use this file except in compliance with the License.
            assertThat(ingestMetadata.size(), equalTo(3));
            }  
    public void testBatchExecute_ignoreFailure() {
            }  
                    } else {
import static org.hamcrest.CoreMatchers.equalTo;
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("first"));
import java.util.List;  
            assertThat(ingestMetadata.get(CompoundProcessor.ON_FAILURE_MESSAGE_FIELD), equalTo("error"));  
            singletonList(lastProcessor),
        ingestDocument.executePipeline(pipeline1, (document, e) -> {
import static org.hamcrest.Matchers.notNullValue;
        assertStats(compoundProcessor, 1, 0, 1);
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(processor.getInvokedCounter(), equalTo(1));
        TestProcessor processor = new TestProcessor("id", "first", null, new RuntimeException("error"));
                return null;  
        });  
 * SPDX-License-Identifier: Apache-2.0
            assertThat(ingestMetadata.get("pipeline"), equalTo("1"));
    }
