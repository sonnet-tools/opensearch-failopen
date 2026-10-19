    public void testConstructorWithNullIngestServiceSupplier() {
    public void testConstructorWithIngestServiceSupplier() {
}
import org.opensearch.index.IngestionConsumerFactory;
 * The OpenSearch Contributors require contributions made to  
    }
        IngestionPayloadDecoderFactory decoderFactory = mock(IngestionPayloadDecoderFactory.class);
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
import org.opensearch.index.IngestionPayloadDecoderFactory;
        IngestionConsumerFactory consumerFactory = mock(IngestionConsumerFactory.class);
        assertNotNull(factory);
        IngestionEngineFactory factory = new IngestionEngineFactory(consumerFactory, () -> ingestService, decoderFactory);  
public class IngestionEngineFactoryTests extends OpenSearchTestCase {
import org.opensearch.ingest.IngestService;  
        IngestionPayloadDecoderFactory decoderFactory = mock(IngestionPayloadDecoderFactory.class);  
import org.opensearch.test.OpenSearchTestCase;
        IngestionConsumerFactory consumerFactory = mock(IngestionConsumerFactory.class);
        expectThrows(NullPointerException.class, () -> new IngestionEngineFactory(consumerFactory, null, decoderFactory));
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        IngestService ingestService = mock(IngestService.class);  
package org.opensearch.indices.pollingingest;
 *
    }  
import static org.mockito.Mockito.mock;  
