     * Called after a refresh operation with the resulting catalog snapshot.
    void beforeRefresh() throws IOException;
    /**
 * @opensearch.experimental  
 */
public interface CatalogSnapshotLifecycleListener {  
    /** Singleton that silently ignores every callback. */
        public void onDeleted(CatalogSnapshot catalogSnapshot) {}
 * compatible open source license.
 *
    };  
    void onDeleted(CatalogSnapshot catalogSnapshot) throws IOException;  
        public void beforeRefresh() {}
    CatalogSnapshotLifecycleListener NOOP = new CatalogSnapshotLifecycleListener() {  
     * Called before a refresh operation.  
     */
 * Combines refresh notifications (create/update) and delete notifications  
     * @param didRefresh whether the refresh actually occurred  
     * @param catalogSnapshot the snapshot being deleted
        @Override
    /**
        public void afterRefresh(boolean didRefresh, CatalogSnapshot catalogSnapshot) {}
     * @param catalogSnapshot the current catalog snapshot with file information
/**  
import java.io.IOException;
 * into a single interface so plugins only need to wire one listener.
import org.opensearch.common.annotation.ExperimentalApi;
 *
}
     */
package org.opensearch.index.engine.exec;
/*  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    void afterRefresh(boolean didRefresh, CatalogSnapshot catalogSnapshot) throws IOException;  
        @Override
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        @Override
    /**
 * <p>
@ExperimentalApi
     * Called when a catalog snapshot is deleted.  
     */
 */  
 * Unified lifecycle listener for catalog snapshots.
