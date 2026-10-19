    public void testGetHandlerWhenHandlerNotProvidedThrowsException() {
 * SPDX-License-Identifier: Apache-2.0
    public void testGetHandlerReturnsBasedOnVersion() {
 * Unit tests for {@link org.opensearch.index.translog.transfer.TranslogTransferMetadataHandlerFactoryTests}.  
        IndexIOStreamHandler<TranslogTransferMetadata> versionOneHandler = translogTransferMetadataHandlerFactory.getHandler(1);  
}
public class TranslogTransferMetadataHandlerFactoryTests extends OpenSearchTestCase {
import org.junit.Before;  
        assertTrue(versionOneHandler instanceof TranslogTransferMetadataHandler);
import org.opensearch.test.OpenSearchTestCase;
    private TranslogTransferMetadataHandlerFactory translogTransferMetadataHandlerFactory;
package org.opensearch.index.translog.transfer;
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(versionTwoHandlerOne, versionTwoHandlerTwo);
 */
        IndexIOStreamHandler<TranslogTransferMetadata> versionTwoHandlerTwo = translogTransferMetadataHandlerFactory.getHandler(1);  
 *
 * compatible open source license.
    public void testGetHandlerWhenCalledMultipleTimesReturnsCachedHandler() {
    }  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Unsupported TranslogTransferMetadata version: 2", throwable.getMessage());  
        translogTransferMetadataHandlerFactory = new TranslogTransferMetadataHandlerFactory();
    }
    @Before  
 */  
import org.opensearch.common.io.IndexIOStreamHandler;
/**
    public void setup() {
/*  
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> { translogTransferMetadataHandlerFactory.getHandler(2); });
        IndexIOStreamHandler<TranslogTransferMetadata> versionTwoHandlerOne = translogTransferMetadataHandlerFactory.getHandler(1);
