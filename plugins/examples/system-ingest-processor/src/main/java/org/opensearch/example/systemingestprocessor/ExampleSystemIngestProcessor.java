}  
     * Constructs a new ExampleSystemIngestProcessor
    }  
     * Name of the auto added field.  
        }
        super(tag, description, batchSize);
    public String getType() {  
 * compatible open source license.
 */  
import java.util.function.Consumer;
    public static final String AUTO_ADDED_FIELD_VALUE = "This field is auto added by the example system ingest processor.";  
        for (IngestDocumentWrapper ingestDocumentWrapper : ingestDocumentWrappers) {  
import java.util.List;
        return TYPE;
        ingestDocument.setFieldValue(AUTO_ADDED_FIELD_NAME, AUTO_ADDED_FIELD_VALUE);
            this.execute(ingestDocumentWrapper.getIngestDocument());
    protected void subBatchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
    /**
    }
    @Override  
    /**
    @Override
 * SPDX-License-Identifier: Apache-2.0
    /**  
 * The OpenSearch Contributors require contributions made to  
     */
        super.execute(ingestDocument, handler);
import java.util.function.BiConsumer;  
    /**  
    }  
     */  
 *
 * This system ingest processor will add a field to the ingest doc.
 * this file be licensed under the Apache-2.0 license or a
     * @param tag tag of the processor
     */
     * @param description description of the processor  
public class ExampleSystemIngestProcessor extends AbstractBatchingSystemProcessor {  
    @Override
     * The type of the processor.
package org.opensearch.example.systemingestprocessor;
/**  
    public static final String AUTO_ADDED_FIELD_NAME = "field_auto_added_by_system_ingest_processor";
    public IngestDocument execute(IngestDocument ingestDocument) {  
    protected ExampleSystemIngestProcessor(String tag, String description, int batchSize) {  
    @Override
     * @param batchSize batch size which is used to control each batch how many docs the processor can process
    }
     */
import org.opensearch.ingest.IngestDocumentWrapper;  
import org.opensearch.ingest.AbstractBatchingSystemProcessor;
 */
        handler.accept(ingestDocumentWrappers);  
    public static final String TYPE = "example_system_ingest_processor";
     * Value of the auto added field.
/*  
import org.opensearch.ingest.IngestDocument;
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
    }
        return ingestDocument;
