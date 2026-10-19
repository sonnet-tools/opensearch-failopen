    @Override
        return reader;
 *
     * @param shardPath the shard path to read data from  
    }
        this.sortFields = sortFields == null ? List.of() : List.copyOf(sortFields);
    public void beforeRefresh() throws IOException {}
        );
            reader.close();  
        DatafusionReader reader = new DatafusionReader(
@ExperimentalApi
        } catch (IllegalStateException closed) {  
            dataFusionService.onFilesAdded(absolutePaths);  
/**
    }
     */  
public class DatafusionReaderManager implements EngineReaderManager<DatafusionReader> {  
        }  
    private final NativeStoreHandle dataformatAwareStoreHandle;
        }
 * The OpenSearch Contributors require contributions made to  
        if (readers.containsKey(catalogSnapshot.getId())) return;  
        try {
import java.util.HashMap;  
     * Sourced from {@code index.sort.field} once at construction; passed to every
    @Override
            return 0L;
 */  
    private final String directoryPath;  
     * legacy local-FS warming path.
    @Override  
    /**  
 * Manages {@link DatafusionReader} instances per shard.  
        this.dataFormat = dataFormat;  
        if (handle == null) {
    private final List<String> sortFields;
        if (reader == null) {
        this.dataformatAwareStoreHandle = dataformatAwareStoreHandle;  
    }  
     * file sort order to DataFusion's query optimizer.  
    /** Parallel to {@link #sortFields}; values are {@code "asc"} or {@code "desc"}. */  
import java.util.Collection;
    }  
     */
import org.apache.logging.log4j.LogManager;
 * <p>
 * On refresh, a new reader is created from the updated catalog snapshot.
 *
        } else {
            return 0L;
            removed.close();  
    public void onFilesAdded(Collection<String> files) throws IOException {
    public void onDeleted(CatalogSnapshot catalogSnapshot) throws IOException {  
import org.opensearch.common.annotation.ExperimentalApi;  
    @Override  
            throw new IOException("No DataFusion reader available for catalog snapshot [version=" + catalogSnapshot.getId() + "]");  
        this.directoryPath = shardPath.getDataPath().resolve(dataFormat.name()).toString();
        List<String> sortOrders
 * File lifecycle events (add/delete) are delegated to the node-level  
        dataFusionService.onFilesDeleted(toAbsolutePaths(files));
    public DatafusionReader getReader(CatalogSnapshot catalogSnapshot) throws IOException {  
 */
 * @opensearch.experimental  
        return fileNames.stream().map(f -> directoryPath + "/" + f).collect(Collectors.toList());  
    private final List<String> sortOrders;
     *                   reader so the indexed scan path can decide whether to iterate segments in reverse  
    public DatafusionReaderManager(
        List<String> sortFields,  
import java.util.stream.Collectors;  
    }
        }
/*  
     *                                   Pointer is extracted at reader creation time via {@code getPointer()}.  
}
        }
        if (files == null || files.isEmpty()) return;  
    private final DataFormat dataFormat;
        }  
            throw new IllegalArgumentException("catalogSnapshot must not be null");
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
    @Override
        }  
    private final DataFusionService dataFusionService;
        DataFusionService dataFusionService,
    }
     * live handle (no per-shard remote store, e.g. hot tier) so the caller falls back to the  
import java.io.IOException;
        if (catalogSnapshot == null) {
 * this file be licensed under the Apache-2.0 license or a
            return handle.getPointer();
        DataFormat dataFormat,
import org.opensearch.index.engine.dataformat.DataFormat;
        DatafusionReader removed = readers.remove(catalogSnapshot.getId());
    /**  
            sortOrders  
            dataformatAwareStoreHandle,
import org.opensearch.index.shard.ShardPath;
            sortFields,
import org.apache.logging.log4j.Logger;
        this.dataFusionService = dataFusionService;
     * @param dataformatAwareStoreHandle per-format native store handle for reads (null if not available).
            directoryPath,
        this.sortOrders = sortOrders == null ? List.of() : List.copyOf(sortOrders);
import java.util.Map;
        for (DatafusionReader reader : readers.values()) {
    private final Map<Long, DatafusionReader> readers = new HashMap<>();
        Collection<String> absolutePaths = toAbsolutePaths(files);
    private static final Logger logger = LogManager.getLogger(DatafusionReaderManager.class);
            dataFusionService.onFilesAddedWithStore(absolutePaths, storePtr);
        readers.put(catalogSnapshot.getId(), reader);
 * {@link DataFusionService} for cache management.
     * @param dataFormat the data format for this reader
    ) {
     * Resolves the native store pointer for cache warming. Returns {@code 0} when there is no
     *                   catalog-snapshot order to feed a {@code TopK} above us.
            catalogSnapshot.getSearchableFiles(dataFormat.name()),  
        NativeStoreHandle dataformatAwareStoreHandle,
    }  
    public void afterRefresh(boolean didRefresh, CatalogSnapshot catalogSnapshot) throws IOException {
import java.util.List;
 * compatible open source license.
    }
     *                                   0 means use default local file system.
    @Override
     * @param sortOrders {@code index.sort.order} values ("asc"/"desc"), parallel to {@code sortFields}.
     */
    public void close() throws IOException {
        if (didRefresh == false) return;
     * @param dataFusionService node-level service for cache management
    }  
     * Creates a reader manager.
import org.opensearch.index.engine.exec.EngineReaderManager;
        }
        long storePtr = storePointerOrDefault(dataformatAwareStoreHandle);
        if (storePtr > 0) {  
            // Handle closed between check and extraction — fall back to local.
    private Collection<String> toAbsolutePaths(Collection<String> fileNames) {
     * {@link DatafusionReader} created on refresh so the native side can declare
    /**
        DatafusionReader reader = readers.get(catalogSnapshot.getId());
        if (removed != null) {
package org.opensearch.be.datafusion;
        if (files == null || files.isEmpty()) return;  
import org.opensearch.plugins.NativeStoreHandle;
    @Override  
    public void onFilesDeleted(Collection<String> files) throws IOException {
        readers.clear();
     * @param sortFields {@code index.sort.field} values, or empty if no index sort. Threaded to the native
    private static long storePointerOrDefault(NativeStoreHandle handle) {  
 * SPDX-License-Identifier: Apache-2.0
        ShardPath shardPath,  
