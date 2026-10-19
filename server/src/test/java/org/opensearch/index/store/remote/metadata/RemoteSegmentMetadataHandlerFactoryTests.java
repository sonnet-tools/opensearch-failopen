 * this file be licensed under the Apache-2.0 license or a
/**
    }  
    @Before  
import org.opensearch.test.OpenSearchTestCase;
}
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> { segmentMetadataHandlerFactory.getHandler(3); });
        IndexIOStreamHandler<RemoteSegmentMetadata> versionTwoHandlerOne = segmentMetadataHandlerFactory.getHandler(2);
import org.junit.Before;  
import org.opensearch.common.io.IndexIOStreamHandler;
package org.opensearch.index.store.remote.metadata;
    public void testGetHandlerWhenHandlerNotProvidedThrowsException() {  
 * compatible open source license.
    public void testGetHandlerReturnsBasedOnVersion() {
        segmentMetadataHandlerFactory = new RemoteSegmentMetadataHandlerFactory();
        assertTrue(versionTwoHandler instanceof RemoteSegmentMetadataHandler);  
        IndexIOStreamHandler<RemoteSegmentMetadata> versionOneHandler = segmentMetadataHandlerFactory.getHandler(1);  
 * Unit tests for {@link org.opensearch.index.store.remote.metadata.RemoteSegmentMetadataHandlerFactoryTests}.  
 *
        assertTrue(versionOneHandler instanceof RemoteSegmentMetadataHandler);
        IndexIOStreamHandler<RemoteSegmentMetadata> versionTwoHandlerTwo = segmentMetadataHandlerFactory.getHandler(2);
 */
 * SPDX-License-Identifier: Apache-2.0
    public void testGetHandlerWhenCalledMultipleTimesReturnsCachedHandler() {  
        assertEquals("Unsupported RemoteSegmentMetadata version: 3", throwable.getMessage());
 * The OpenSearch Contributors require contributions made to  
        IndexIOStreamHandler<RemoteSegmentMetadata> versionTwoHandler = segmentMetadataHandlerFactory.getHandler(2);
/*  
public class RemoteSegmentMetadataHandlerFactoryTests extends OpenSearchTestCase {
    }
    }  
    }
 */  
    private RemoteSegmentMetadataHandlerFactory segmentMetadataHandlerFactory;
        assertEquals(versionTwoHandlerOne, versionTwoHandlerTwo);  
    public void setup() {
