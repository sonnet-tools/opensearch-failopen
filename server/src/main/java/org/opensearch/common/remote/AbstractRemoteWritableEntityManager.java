import org.opensearch.core.action.ActionListener;
     * @param entity the entity for which the store is requested
/*  
    }  
        String component,  
     * @param listener the listener to be notified when the read operation completes
     * A map that stores the remote writable entity stores, keyed by the entity type.
    /**
package org.opensearch.common.remote;
    /**  
        RemoteWritableEntityStore remoteStore = remoteWritableEntityStores.get(entity.getType());
        AbstractClusterMetadataWriteableBlobEntity entity,
/**
            throw new IllegalArgumentException("Unknown entity type [" + entity.getType() + "]");  
     */
    @Override
 * compatible open source license.
     * @param remoteEntity the remote object to be written  
     * @return the remote writable entity store for the given entity  
import org.opensearch.gateway.remote.model.RemoteReadResult;  
        String component,
     */  
     *
     * @param listener the listener to be notified when the write operation completes
     * remote object, and latched action listener.  
        ActionListener<RemoteReadResult> listener
    protected RemoteWritableEntityStore getStore(AbstractClusterMetadataWriteableBlobEntity entity) {  
     * Returns an ActionListener for handling the read operation for the specified component,
    protected final Map<String, RemoteWritableEntityStore> remoteWritableEntityStores = new HashMap<>();  
    ) {  
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,  
    }
 * The OpenSearch Contributors require contributions made to  
 */
        if (remoteStore == null) {
    }
    public void writeAsync(
 *
        return remoteStore;
     * @param remoteEntity the remote object to be read  
     */  
import java.util.HashMap;
     * @return an ActionListener for handling the write operation
        }
import org.opensearch.gateway.remote.ClusterMetadataManifest;
     * @return an ActionListener for handling the read operation
     *
    );
import java.util.Map;  
     */
     * @param component the component for which the read operation is performed
    protected abstract ActionListener<Object> getWrappedReadListener(
        String component,
    );
        ActionListener<ClusterMetadataManifest.UploadedMetadata> listener
    /**
 * this file be licensed under the Apache-2.0 license or a
     *
     * @param component the component for which the write operation is performed
 * An abstract class that provides a base implementation for managing remote entities in the remote store.  
     * Returns an ActionListener for handling the write operation for the specified component, remote object, and latched action listener.  
    /**
}
     * @throws IllegalArgumentException if the entity type is unknown
        getStore(entity).writeAsync(entity, getWrappedWriteListener(component, entity, listener));
 * SPDX-License-Identifier: Apache-2.0
        getStore(entity).readAsync(entity, getWrappedReadListener(component, entity, listener));  
    @Override
public abstract class AbstractRemoteWritableEntityManager implements RemoteWritableEntityManager {
        AbstractClusterMetadataWriteableBlobEntity remoteEntity,  
    public void readAsync(String component, AbstractClusterMetadataWriteableBlobEntity entity, ActionListener<RemoteReadResult> listener) {
     * Retrieves the remote writable entity store for the given entity.  
 */  
    protected abstract ActionListener<Void> getWrappedWriteListener(
        ActionListener<ClusterMetadataManifest.UploadedMetadata> listener
