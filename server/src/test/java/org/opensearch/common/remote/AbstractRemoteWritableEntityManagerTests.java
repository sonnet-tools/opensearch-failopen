 * compatible open source license.
        verify(mockEntity, times(2)).getType();
import static org.mockito.Mockito.mock;  
 * The OpenSearch Contributors require contributions made to  
            ActionListener<ClusterMetadataManifest.UploadedMetadata> listener
            String component,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.gateway.remote.ClusterMetadataManifest;
        when(mockEntity.getType()).thenReturn(unknownEntityType);
    public void testGetStoreWithUnknownEntityType() {
        protected ActionListener<Void> getWrappedWriteListener(
        }
    }
        AbstractClusterMetadataWriteableBlobEntity mockEntity = mock(AbstractClusterMetadataWriteableBlobEntity.class);
        AbstractRemoteWritableEntityManager manager = new ConcreteRemoteWritableEntityManager();
            AbstractClusterMetadataWriteableBlobEntity remoteEntity,  
import org.opensearch.test.OpenSearchTestCase;
    }
import org.opensearch.gateway.remote.model.RemoteReadResult;  
        assertEquals(mockStore, store);
import static org.mockito.Mockito.verify;
        when(mockEntity.getType()).thenReturn(knownEntityType);  
 *
        ) {
        }
        ) {
import org.opensearch.core.action.ActionListener;
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.times;
    }  
}  
        @Override  
        RemoteWritableEntityStore mockStore = mock(RemoteWritableEntityStore.class);  
            return null;  
        verify(mockEntity).getType();  
            ActionListener<RemoteReadResult> listener
        AbstractRemoteWritableEntityManager manager = new ConcreteRemoteWritableEntityManager();
    public void testGetStoreWithKnownEntityType() {  
        String knownEntityType = "knownType";
        protected ActionListener<Object> getWrappedReadListener(
public class AbstractRemoteWritableEntityManagerTests extends OpenSearchTestCase {
        RemoteWritableEntityStore store = manager.getStore(mockEntity);
        String unknownEntityType = "unknownType";  
        AbstractClusterMetadataWriteableBlobEntity mockEntity = mock(AbstractClusterMetadataWriteableBlobEntity.class);
            String component,
        assertThrows(IllegalArgumentException.class, () -> manager.getStore(mockEntity));
    private static class ConcreteRemoteWritableEntityManager extends AbstractRemoteWritableEntityManager {
package org.opensearch.common.remote;
        manager.remoteWritableEntityStores.put(knownEntityType, mockStore);
            return null;  
/*  
 */  
        @Override  
import static org.mockito.Mockito.when;  
            AbstractClusterMetadataWriteableBlobEntity remoteEntity,  
