import java.util.ArrayList;  
import java.util.Collections;
            }  
    public void testSystemFactory_shouldNotModifyConfig() throws Exception {
import static org.mockito.Mockito.mock;  
    }
            subBatches.add(ingestDocumentWrappers);
            return ingestDocument;
        AbstractBatchingSystemProcessorTests.DummyProcessor.DummySystemProcessorFactory factory =
    static class DummyProcessor extends AbstractBatchingSystemProcessor {  
        protected DummyProcessor(int batchSize) {
import org.opensearch.test.OpenSearchTestCase;
        public String getType() {
        }  
            protected DummySystemProcessorFactory(String processorType) {
        @Override
public class AbstractBatchingSystemProcessorTests extends OpenSearchTestCase {  
        }
            return null;  
            return subBatches;
}  
        public IngestDocument execute(IngestDocument ingestDocument) throws Exception {  
 */  
        factory.create(config);  
package org.opensearch.ingest;
                super(processorType);
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        public List<List<IngestDocumentWrapper>> getSubBatches() {  
import java.util.function.Consumer;
        verifyNoInteractions(config);  
    }
                return super.create(Collections.emptyMap(), "tag", "description", config);
 * compatible open source license.
        assertTrue(factory.isSystemGenerated());
        }
                return new AbstractBatchingSystemProcessorTests.DummyProcessor(1);
/*  
import java.util.Map;  
 * this file be licensed under the Apache-2.0 license or a
            handler.accept(ingestDocumentWrappers);
            }
            new AbstractBatchingSystemProcessorTests.DummyProcessor.DummySystemProcessorFactory("DummyProcessor");
        public void subBatchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {  
        private List<List<IngestDocumentWrapper>> subBatches = new ArrayList<>();
            super("tag", "description", batchSize);
 *
            }  
        @Override
import java.util.List;
import static org.mockito.Mockito.verifyNoInteractions;
        }  
        }
        Map<String, Object> config = mock(Map.class);
        }
        public static class DummySystemProcessorFactory extends AbstractBatchingSystemProcessor.Factory {  
            @Override
            protected AbstractBatchingSystemProcessor newProcessor(String tag, String description, Map<String, Object> config) {  
        @Override
            public AbstractBatchingSystemProcessor create(Map<String, Object> config) throws Exception {
