    }
/*  
            .register("a", factoryA)
            .build();  
        IngestionPayloadDecoderFactory factoryA = mock(IngestionPayloadDecoderFactory.class);
            .register("xcontent", mock(IngestionPayloadDecoderFactory.class))  
    }
        IngestionPayloadDecoderFactory factoryB = mock(IngestionPayloadDecoderFactory.class);
}
        expectThrows(IllegalArgumentException.class, () -> registry.get("unknown"));  
        IngestionPayloadDecoderRegistry.Builder builder = IngestionPayloadDecoderRegistry.builder().register("xcontent", factoryA);
            .register("b", factoryB)
import org.opensearch.index.IngestionPayloadDecoderFactory;
    public void testRegisterAndGet() {  
import static org.mockito.Mockito.verify;
        registry.close();
package org.opensearch.indices.pollingingest;
        IngestionPayloadDecoderFactory factory = mock(IngestionPayloadDecoderFactory.class);
import org.opensearch.test.OpenSearchTestCase;
    public void testCloseClosesAllRegisteredFactories() throws Exception {  
import static org.mockito.Mockito.mock;
        verify(factoryB).close();
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> builder.register("xcontent", factoryB));  
public class IngestionPayloadDecoderRegistryTests extends OpenSearchTestCase {
        verify(factoryA).close();
 */  
    }  
        IngestionPayloadDecoderRegistry registry = IngestionPayloadDecoderRegistry.builder()  
        IngestionPayloadDecoderFactory factoryA = mock(IngestionPayloadDecoderFactory.class);
        IngestionPayloadDecoderFactory factoryB = mock(IngestionPayloadDecoderFactory.class);  
            .build();
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        assertSame(factory, registry.get("xcontent"));
 * SPDX-License-Identifier: Apache-2.0
    public void testDuplicateRegistrationThrows() {
        IngestionPayloadDecoderRegistry registry = IngestionPayloadDecoderRegistry.builder().register("xcontent", factory).build();
 *
    public void testGetUnknownTypeThrows() {
    }
        IngestionPayloadDecoderRegistry registry = IngestionPayloadDecoderRegistry.builder()
        assertTrue(e.getMessage().contains("xcontent"));
 * this file be licensed under the Apache-2.0 license or a
