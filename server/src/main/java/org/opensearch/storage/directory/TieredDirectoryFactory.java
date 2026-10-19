 * compatible open source license.
import org.opensearch.threadpool.ThreadPool;  
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
        ShardPath shardPath,
        ThreadPool threadPool
import java.util.function.Supplier;  
        return new TieredDirectory(localDirectory, remoteDirectory, fileCache, threadPool, tieredStoragePrefetchSettingsSupplier);  
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
    }
 * Factory for creating {@link TieredDirectory} instances that combine local and remote storage.  
 *
 */  
        IndexStorePlugin.DirectoryFactory localDirectoryFactory,
    @Override
    }
     * Creates a new TieredDirectoryFactory.  
import org.apache.logging.log4j.Logger;
import org.opensearch.plugins.IndexStorePlugin;
import org.apache.lucene.store.Directory;
}
/*  
        Directory remoteDirectory,  
    public TieredDirectoryFactory(Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier) {  
    /**
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi
        FileCache fileCache,
import org.opensearch.index.store.remote.filecache.FileCache;  
import org.opensearch.index.shard.ShardPath;
package org.opensearch.storage.directory;
 * @opensearch.experimental
public class TieredDirectoryFactory implements IndexStorePlugin.CompositeDirectoryFactory {
 *
import org.apache.logging.log4j.LogManager;  
 */  
    ) throws IOException {  
        Directory localDirectory = localDirectoryFactory.newDirectory(indexSettings, shardPath);
    private static final Logger logger = LogManager.getLogger(TieredDirectoryFactory.class);
     */
     * @param tieredStoragePrefetchSettingsSupplier supplier for prefetch settings
        IndexSettings indexSettings,  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        logger.trace("Creating composite directory from TieredDirectoryFactory");
import java.io.IOException;
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;  
import org.opensearch.common.annotation.ExperimentalApi;  
    public Directory newDirectory(
/**
import org.opensearch.index.IndexSettings;
