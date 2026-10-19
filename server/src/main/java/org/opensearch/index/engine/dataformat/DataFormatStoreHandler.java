     * @param size       file size in bytes
 *
     * in the DataFusion runtime environment.
 * <p>Data format plugins that use a native (e.g. Rust) reader return one of
    default NativeStoreHandle getFormatStoreHandle() {
 *
    /**  
 *  
    /**
     * Returns the native store handle wrapping the Rust object store pointer,
@ExperimentalApi
     */
     * Called after a file has been removed from tracking.  
    @ExperimentalApi
     *  
     */  
    void onRemoved(String file);
     * @param file the file identifier
    /**
 * <p>Formats without a native reader return {@link java.util.Optional#empty()}  
import java.io.Closeable;
     * or {@code null} if this handler does not manage a native store.
 * remove) that originate in the Java directory.
        return null;
    void seed(Map<String, FileEntry> files);  
     * <p>The reader manager uses this to register the native object store
     * @param file       the file identifier (absolute path)
package org.opensearch.index.engine.dataformat;
 * Per-shard handler for a data format's store lifecycle.
 * the instance, drives its lifecycle, and forwards file events (seed, upload,  
     *
 * from the strategy and never produce an instance of this interface.
     *   <li>{@code LOCAL}  — file exists only on local disk</li>
    int REMOTE = 1;
 * these via {@link StoreStrategy#storeHandler()}. The store layer owns
/*  
    }  
     * A file entry carrying the blob path, location, and size.
     */
public interface DataFormatStoreHandler extends Closeable {  
    void onUploaded(String file, String remotePath, long size);  
    /**  
     * @param files map of file identifier (e.g. {@code "parquet/seg_0.parquet"})  
    int LOCAL = 0;  
     * Seeds the handler with a batch of files and their locations.  
/**
     */  
    }  
 * SPDX-License-Identifier: Apache-2.0
     * @param location one of {@link #LOCAL} or {@link #REMOTE}
 * this file be licensed under the Apache-2.0 license or a
     *   <li>{@code REMOTE} — file exists only on a remote object store</li>  
     * File location constants matching the Rust {@code FileLocation} enum.  
import org.opensearch.plugins.NativeStoreHandle;
 *
     */
     * @param remotePath the remote blob path (base path + format prefix + blob key)  
     * Called once per shard at open time.
    record FileEntry(String path, int location, long size) {
     *              to {@link FileEntry} carrying the blob path and location
     * Called after a file has been uploaded to the remote store.  
     * <ul>
    /**
 * @opensearch.experimental  
     * @param path     fully-qualified blob path (local path for LOCAL, remote blob path for REMOTE)  
 */  
    /**
 */
     *
     *
 * The OpenSearch Contributors require contributions made to  
     */  
}
 * compatible open source license.
import java.util.Map;
     * @param size     file size in bytes (0 if unknown)
     * </ul>
     *
import org.opensearch.common.annotation.ExperimentalApi;
