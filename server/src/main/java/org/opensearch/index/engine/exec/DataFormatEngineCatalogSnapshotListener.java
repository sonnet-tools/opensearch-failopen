    @Override
        for (CatalogSnapshotLifecycleListener listener : readerManagers.values()) {  
 */
 * <p>
    public DataFormatEngineCatalogSnapshotListener(Map<DataFormat, EngineReaderManager<?>> readerManagers) {
        }  
 * Routes {@link CatalogSnapshotLifecycleListener} events to the per-format  
    }  
 * {@link org.opensearch.index.engine.exec.coord.IndexFileDeleter} inside {@link org.opensearch.index.engine.exec.coord.CatalogSnapshotManager}.
 * this file be licensed under the Apache-2.0 license or a
 */  
public class DataFormatEngineCatalogSnapshotListener implements CatalogSnapshotLifecycleListener {  
            listener.beforeRefresh();
        }
    public void beforeRefresh() throws IOException {  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
/*  
import java.io.IOException;
    }
 * compatible open source license.
            listener.onDeleted(catalogSnapshot);
        for (CatalogSnapshotLifecycleListener listener : readerManagers.values()) {
import org.opensearch.index.engine.dataformat.DataFormat;
    }  
    @Override  
        for (CatalogSnapshotLifecycleListener listener : readerManagers.values()) {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 *
            listener.afterRefresh(didRefresh, catalogSnapshot);  
/**
package org.opensearch.index.engine.exec;
    public void onDeleted(CatalogSnapshot catalogSnapshot) throws IOException {
}
 * {@link EngineReaderManager}s.
        }
 * File lifecycle management (ref counting, deletion) is now handled by  
import java.util.Map;  
    private final Map<DataFormat, EngineReaderManager<?>> readerManagers;
        this.readerManagers = readerManagers;
    }
 *
    @Override
@ExperimentalApi
    public void afterRefresh(boolean didRefresh, CatalogSnapshot catalogSnapshot) throws IOException {
