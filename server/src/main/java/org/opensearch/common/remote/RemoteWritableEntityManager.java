     *                 read data on successful read. The  
import org.opensearch.core.action.ActionListener;
}
     */  
     * @param entity the entity to be read
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
    /**  
     *                 {@link ActionListener#onFailure(Exception)} method is called with  
     *                 is called with a {@link UploadedMetadata} object containing the
     * @param entity the entity to be written
 */  
     *                 uploaded metadata on successful write. The
    void writeAsync(String component, AbstractClusterMetadataWriteableBlobEntity entity, ActionListener<UploadedMetadata> listener);  
     *                 The listener's {@link ActionListener#onResponse(Object)} method  
     * Performs an asynchronous read operation for the specified component and entity.
    void readAsync(String component, AbstractClusterMetadataWriteableBlobEntity entity, ActionListener<RemoteReadResult> listener);
     *  
     *
 * SPDX-License-Identifier: Apache-2.0
public interface RemoteWritableEntityManager {
import org.opensearch.gateway.remote.model.RemoteReadResult;  
     */
     * @param component the component for which the write operation is performed  
/**
 * this file be licensed under the Apache-2.0 license or a
 */
 * The OpenSearch Contributors require contributions made to  
     *                 is called with a {@link RemoteReadResult} object containing the
     * Performs an asynchronous write operation for the specified component and entity.
     * @param listener the listener to be notified when the read operation completes.  
     *                 {@link ActionListener#onFailure(Exception)} method is called with
     *                 The listener's {@link ActionListener#onResponse(Object)} method
     * @param listener the listener to be notified when the write operation completes.
package org.opensearch.common.remote;
 * The RemoteWritableEntityManager interface provides async read and write methods for managing remote entities in the remote store  
 *
 * compatible open source license.
     *                 an exception if the read operation fails.
    /**
     *                 an exception if the write operation fails.
     * @param component the component for which the read operation is performed
/*  
