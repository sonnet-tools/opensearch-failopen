        int docCount = randomIntBetween(2, 32);
    public void testBatchExecute_randomBatches() {
            return ingestDocument;
        );  
        Map<String, Object> config = new HashMap<>();  
import java.util.Arrays;
package org.opensearch.ingest;
        DummyProcessor processor = new DummyProcessor(3);
 * The OpenSearch Contributors require contributions made to  
 */  
        processor.batchExecute(wrapperList, resultList::addAll);
        assertEquals(wrapperList.subList(2, 4), processor.getSubBatches().get(1));
    public void testBatchExecute_defaultBatchSize() {
            super("tag", "description", batchSize);  
            return null;
        DummyProcessor processor = new DummyProcessor(3);  
    public void testFactory_invalidBatchSize() {
        );
        assertEquals(wrapperList, resultList);
        List<IngestDocumentWrapper> resultList = new ArrayList<>();
        config.put("batch_size", 3);
    }  
        }
        List<IngestDocumentWrapper> resultList = new ArrayList<>();
    static class DummyProcessor extends AbstractBatchingProcessor {
        OpenSearchParseException exception = assertThrows(OpenSearchParseException.class, () -> factory.create(config));  
        assertEquals(wrapperList, processor.getSubBatches().get(0));
        assertEquals(wrapperList.subList(0, 1), processor.getSubBatches().get(0));  
    public void testFactory_defaultBatchSize() throws Exception {
        public static class DummyProcessorFactory extends Factory {
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        }
    public void testBatchExecute_multipleBatches() {
    public void testFactory_callNewProcessor() throws Exception {
        public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
            IngestDocumentPreparer.createIngestDocumentWrapper(2),
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
    }
        assertEquals(wrapperList.subList(1, 2), processor.getSubBatches().get(1));
                return new DummyProcessor(batchSize);
        public void subBatchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
            handler.accept(ingestDocumentWrappers);  
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(  
        DummyProcessor.DummyProcessorFactory factory = new DummyProcessor.DummyProcessorFactory("DummyProcessor");
import java.util.function.Consumer;
            IngestDocumentPreparer.createIngestDocumentWrapper(4),
        }
import java.util.List;
        }  
        public String getType() {  
        DummyProcessor processor = new DummyProcessor(2);  
        @Override  
        assertEquals(1, processor.getSubBatches().size());
            IngestDocumentPreparer.createIngestDocumentWrapper(2),  
            IngestDocumentPreparer.createIngestDocumentWrapper(1),  
            IngestDocumentPreparer.createIngestDocumentWrapper(3)
        assertEquals(wrapperList.subList(4, 5), processor.getSubBatches().get(2));
}  
        List<IngestDocumentWrapper> resultList = new ArrayList<>();
        List<IngestDocumentWrapper> resultList = new ArrayList<>();
        }  
        assertEquals(wrapperList, resultList);  
            @Override  
            }
        }
        @Override
    }
            subBatches.add(ingestDocumentWrappers);
        processor.batchExecute(wrapperList, resultList::addAll);  
import java.util.HashMap;
        Map<String, Object> config = new HashMap<>();  
    }
                super(processorType);
 * SPDX-License-Identifier: Apache-2.0
        DummyProcessor processor = new DummyProcessor(1);
            public AbstractBatchingProcessor create(Map<String, Object> config) throws Exception {
            IngestDocumentPreparer.createIngestDocumentWrapper(2),
                return super.create(processorFactories, "tag", "description", config);  
import java.util.ArrayList;
            }  
            }
        }  
public class AbstractBatchingProcessorTests extends OpenSearchTestCase {  
            return subBatches;
        assertEquals(docCount / batchSize + (docCount % batchSize == 0 ? 0 : 1), processor.getSubBatches().size());
/*  
    }
import org.opensearch.test.OpenSearchTestCase;
            protected AbstractBatchingProcessor newProcessor(String tag, String description, int batchSize, Map<String, Object> config) {
        DummyProcessor.DummyProcessorFactory factory = new DummyProcessor.DummyProcessorFactory("DummyProcessor");  
            IngestDocumentPreparer.createIngestDocumentWrapper(3),
            wrapperList.add(IngestDocumentPreparer.createIngestDocumentWrapper(i));
        assertEquals("[batch_size] batch size must be a positive integer", exception.getMessage());
        assertEquals(wrapperList, resultList);  
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
        @Override  
        DummyProcessor processor = (DummyProcessor) factory.create(config);
            protected DummyProcessorFactory(String processorType) {  
    }
        config.put("batch_size", 0);
        assertEquals(wrapperList.subList(0, 2), processor.getSubBatches().get(0));  
    }  
        Map<String, Object> config = new HashMap<>();
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
            IngestDocumentPreparer.createIngestDocumentWrapper(5)  
    }  
        int batchSize = randomIntBetween(2, 32);  
        for (int i = 0; i < docCount; ++i) {
import java.util.Collections;  
 * this file be licensed under the Apache-2.0 license or a
        DummyProcessor processor = new DummyProcessor(batchSize);
        DummyProcessor.DummyProcessorFactory factory = new DummyProcessor.DummyProcessorFactory("DummyProcessor");
        protected DummyProcessor(int batchSize) {
        assertTrue(processor.getSubBatches().isEmpty());  
        DummyProcessor processor = (DummyProcessor) factory.create(config);  
        assertEquals(3, processor.batchSize);
import java.util.Map;  
    }  
    public void testBatchExecute_singleBatchSize() {  
        assertEquals(3, processor.getSubBatches().size());
        processor.batchExecute(wrapperList, resultList::addAll);
        assertEquals(wrapperList, resultList);
        Consumer<List<IngestDocumentWrapper>> handler = (results) -> assertTrue(results.isEmpty());
        private List<List<IngestDocumentWrapper>> subBatches = new ArrayList<>();
            IngestDocumentPreparer.createIngestDocumentWrapper(3)  
        List<IngestDocumentWrapper> wrapperList = new ArrayList<>();  
        );
    public void testBatchExecute_emptyInput() {
 * compatible open source license.
        processor.batchExecute(wrapperList, resultList::addAll);  
import org.opensearch.OpenSearchParseException;
        processor.batchExecute(Collections.emptyList(), handler);
 *
        assertEquals(wrapperList.subList(2, 3), processor.getSubBatches().get(2));
        assertEquals(1, processor.batchSize);
                final Map<String, org.opensearch.ingest.Processor.Factory> processorFactories = new HashMap<>();
        assertEquals(3, processor.getSubBatches().size());
        public List<List<IngestDocumentWrapper>> getSubBatches() {
