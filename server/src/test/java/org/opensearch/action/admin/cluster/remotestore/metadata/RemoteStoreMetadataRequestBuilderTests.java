import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.unit.TimeValue;
        assertSame(builder, returned);
        assertArrayEquals(shards, returned.request().shards());
 * The OpenSearch Contributors require contributions made to  
 *
package org.opensearch.action.admin.cluster.remotestore.metadata;
    public void testSetShards() {
    }
import org.opensearch.transport.client.OpenSearchClient;  
        RemoteStoreMetadataRequestBuilder builder = new RemoteStoreMetadataRequestBuilder(mockClient, RemoteStoreMetadataAction.INSTANCE);
        TimeValue timeout = TimeValue.timeValueSeconds(15);
        RemoteStoreMetadataRequestBuilder builder = new RemoteStoreMetadataRequestBuilder(mockClient, RemoteStoreMetadataAction.INSTANCE);  
public class RemoteStoreMetadataRequestBuilderTests extends OpenSearchTestCase {
        RemoteStoreMetadataRequestBuilder builder = new RemoteStoreMetadataRequestBuilder(mockClient, RemoteStoreMetadataAction.INSTANCE);
    public void testChaining() {
        String[] shards = new String[] { "0", "2" };
        assertEquals(timeout, builder.request().timeout());
        builder.setShards(shards);  
    public void testSetTimeout() {  
        OpenSearchClient mockClient = mock(OpenSearchClient.class);
        builder.setTimeout(timeout);
        String[] shards = new String[] { "0", "1" };
        OpenSearchClient mockClient = mock(OpenSearchClient.class);
 */  
import static org.mockito.Mockito.mock;
        RemoteStoreMetadataRequestBuilder returned = builder.setTimeout(timeout).setShards(shards);  
        OpenSearchClient mockClient = mock(OpenSearchClient.class);  
        TimeValue timeout = TimeValue.timeValueSeconds(10);  
        assertArrayEquals(shards, builder.request().shards());
 * SPDX-License-Identifier: Apache-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(timeout, returned.request().timeout());  
 * compatible open source license.
/*  
}  
    }  
