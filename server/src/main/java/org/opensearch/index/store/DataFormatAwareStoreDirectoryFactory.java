     * @param localDirectoryFactory  the factory for creating the underlying local directory
     *  
     */  
        throw new UnsupportedOperationException("Warm-aware directory creation not supported by this factory");  
    DataFormatAwareStoreDirectory newDataFormatAwareStoreDirectory(
 *
 * Factory interface for creating DataFormatAwareStoreDirectory instances.
@ExperimentalApi
        ShardId shardId,  
        IndexSettings indexSettings,
     * @return a new DataFormatAwareStoreDirectory
     * @param checksumStrategies     pre-built checksum strategies keyed by format name  
}
        FileCache fileCache,  
/*  
        IndexSettings indexSettings,
     *  
     * and passes it in so that native store handles can be extracted before
 * local directory creation rather than hardcoding a specific implementation.  
 */  
    default DataFormatAwareStoreDirectory newDataFormatAwareStoreDirectory(
    }
 *
import org.opensearch.index.IndexSettings;  
     * @throws IOException if directory creation fails
     * @param indexSettings          the shard's index settings
     * @param fileCache              the file cache for warm node caching
 * formats. Accepts a {@link IndexStorePlugin.DirectoryFactory} to delegate
     * {@link org.opensearch.storage.directory.StoreStrategyRegistry} externally  
import java.util.Map;
     * @param indexSettings          the shard's index settings
     * @param shardId                the shard identifier
     * @return a new DataFormatAwareStoreDirectory
     * @param shardPath              the path the shard is using for file storage
import org.opensearch.plugins.IndexStorePlugin;  
     * the directory is created.
        IndexStorePlugin.DirectoryFactory localDirectoryFactory,
 * The OpenSearch Contributors require contributions made to  
     * Creates a new DataFormatAwareStoreDirectory for warm nodes with tiered
import java.io.IOException;  
        Map<String, FormatChecksumStrategy> checksumStrategies,  
    /**
     * @param remoteDirectory        the remote segment store directory
     *
import org.opensearch.index.shard.ShardPath;
import org.opensearch.index.store.remote.filecache.FileCache;
    ) throws IOException {
        IndexStorePlugin.DirectoryFactory localDirectoryFactory,
    ) throws IOException;
import org.opensearch.common.annotation.ExperimentalApi;
     * @param strategies             the pre-built store strategy registry for this shard  
     */  
 * SPDX-License-Identifier: Apache-2.0
public interface DataFormatAwareStoreDirectoryFactory {
 * centralized way to create directories that understand multiple data
     * @param localDirectoryFactory  the factory for creating the underlying local directory
     * @param shardId                the shard identifier  
        ThreadPool threadPool
 * compatible open source license.
/**  
    /**  
     * format discovery.  
     * <p>Implementations that support warm+format override this method to
        ShardPath shardPath,
     * @throws IOException if directory creation fails
package org.opensearch.index.store;
        ShardPath shardPath,
 * <p>Follows the existing {@link IndexStorePlugin} pattern to provide a  
import org.opensearch.threadpool.ThreadPool;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
        Map<String, FormatChecksumStrategy> checksumStrategies  
     * @param checksumStrategies     pre-built checksum strategies keyed by format name
     * Creates a new DataFormatAwareStoreDirectory per shard with automatic
        org.opensearch.storage.directory.StoreStrategyRegistry strategies,
     * storage support.
        ShardId shardId,  
     * @param shardPath              the path the shard is using for file storage  
     * @param threadPool             the thread pool for async operations  
        RemoteSegmentStoreDirectory remoteDirectory,
import org.opensearch.core.index.shard.ShardId;
 */  
     * build the full tiered directory stack. The caller creates the
 *
