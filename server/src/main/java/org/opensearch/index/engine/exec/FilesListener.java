     *
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental  
/**  
 * compatible open source license.
     * @param files the file names that were added
 *
@ExperimentalApi
}
    /**
    /**
     * @param files the file names that were deleted
     */  
     *  
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
     * Called when files are deleted (ref count reached 0).  
 */  
/*  
 *
    void onFilesDeleted(Collection<String> files) throws IOException;  
import org.opensearch.common.annotation.ExperimentalApi;
package org.opensearch.index.engine.exec;
     */
 * this file be licensed under the Apache-2.0 license or a
 */
     * Called when new files become visible (ref count went from 0 to 1).
 * Listener notified when files are added to or deleted from a data format's storage.
import java.util.Collection;
public interface FilesListener {  
    void onFilesAdded(Collection<String> files) throws IOException;
