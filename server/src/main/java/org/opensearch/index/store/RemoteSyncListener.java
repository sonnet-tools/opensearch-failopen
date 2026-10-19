/*  
 * calls {@link #afterSyncToRemote(String)} on all registered listeners.
 * construction time. When a file is uploaded to the remote segment store, the uploader
    /**
     * @param file the name of the file that was synced to remote  
/**  
import org.opensearch.common.annotation.ExperimentalApi;
     *
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
     *
 */  
@ExperimentalApi
 *   <li>TieredSubdirectoryAwareDirectory — delegates to format-specific handlers</li>
 * @opensearch.experimental
 * <ul>
     * as remotely available in a registry, or forwarding the notification to a delegate.
     * Called after a file has been successfully uploaded to the remote store.  
 *
     * <p>Implementations should use this callback to update internal state related to the
 * Listener that receives notifications after files are synced to the remote store.
package org.opensearch.index.store;
 *
 * compatible open source license.
}  
 * <p>Registered via {@code RemoteStoreUploaderService.addSyncListener()} at uploader  
 * The OpenSearch Contributors require contributions made to  
 *   <li>{@link CompositeDirectory} — unpins files from FileCache after upload</li>  
     * file's remote availability — such as unpinning from a local cache, marking the file  
 *  
 * <p>Implemented by:
@FunctionalInterface
 *   <li>{@link DataFormatAwareStoreDirectory} — pass-through to inner directory</li>
public interface RemoteSyncListener {  
    void afterSyncToRemote(String file);
 * </ul>  
 * this file be licensed under the Apache-2.0 license or a
     */
