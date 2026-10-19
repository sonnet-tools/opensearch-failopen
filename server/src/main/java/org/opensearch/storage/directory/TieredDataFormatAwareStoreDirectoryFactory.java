 * @opensearch.experimental
    public DataFormatAwareStoreDirectory newDataFormatAwareStoreDirectory(  
        boolean success = false;  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
    @Override
import org.opensearch.index.store.FormatChecksumStrategy;
        IndexSettings indexSettings,
        }  
                subdirAware,  
        Map<String, FormatChecksumStrategy> checksumStrategies,  
 *
            tieredSubdir = new TieredSubdirectoryAwareDirectory(
import org.apache.lucene.store.Directory;  
        );  
import org.opensearch.common.util.io.IOUtils;
        Directory localDir = localDirectoryFactory.newDirectory(indexSettings, shardPath);
 * SPDX-License-Identifier: Apache-2.0
        logger.debug("Creating warm+format directory stack for shard [{}]", shardId);  
        ShardId shardId,
        Map<String, FormatChecksumStrategy> checksumStrategies
            if (success == false) {
import org.opensearch.index.IndexSettings;
            );
    }
/**
    ) throws IOException {
public class TieredDataFormatAwareStoreDirectoryFactory implements DataFormatAwareStoreDirectoryFactory {
import org.opensearch.plugins.IndexStorePlugin;  
 * this file be licensed under the Apache-2.0 license or a
                shardPath,
 * Factory for creating the warm+format directory stack.  
            );
    @Override  
import org.apache.logging.log4j.Logger;
 */  
import org.opensearch.core.index.shard.ShardId;  
                tieredSubdir,
                }
            }
        } finally {
            success = true;
 * The OpenSearch Contributors require contributions made to  
        IndexStorePlugin.DirectoryFactory localDirectoryFactory,
        throw new UnsupportedOperationException(
                fileCache,
import org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory;
        ShardPath shardPath,
    }
 *
    public static final String FACTORY_KEY = "dataformat-tiered";
                    IOUtils.closeWhileHandlingException(tieredSubdir);
}
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
                shardPath,
                if (tieredSubdir != null) {  
                strategies,
package org.opensearch.storage.directory;
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
import java.util.function.Supplier;  
import org.opensearch.index.store.SubdirectoryAwareDirectory;
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        ThreadPool threadPool
    ) throws IOException {  
 * compatible open source license.
        IndexSettings indexSettings,
 */  
import org.opensearch.threadpool.ThreadPool;
        IndexStorePlugin.DirectoryFactory localDirectoryFactory,
    public TieredDataFormatAwareStoreDirectoryFactory(Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier) {
                tieredStoragePrefetchSettingsSupplier  
    public DataFormatAwareStoreDirectory newDataFormatAwareStoreDirectory(
            DataFormatAwareStoreDirectory result = DataFormatAwareStoreDirectory.withDirectoryDelegate(  
                threadPool,  
import org.opensearch.common.annotation.ExperimentalApi;
            return result;  
import org.opensearch.index.store.DataFormatAwareStoreDirectory;  
        SubdirectoryAwareDirectory subdirAware = new SubdirectoryAwareDirectory(localDir, shardPath);  
import java.util.Map;
import java.io.IOException;
@ExperimentalApi
                remoteDirectory,
                } else {
import org.apache.logging.log4j.LogManager;
/*  
                    IOUtils.closeWhileHandlingException(strategies);  
        ShardPath shardPath,  
    }  
        RemoteSegmentStoreDirectory remoteDirectory,
import org.opensearch.index.shard.ShardPath;
            "TieredDataFormatAwareStoreDirectoryFactory requires warm parameters. Use the warm-aware overload."
        StoreStrategyRegistry strategies,
        ShardId shardId,  
        try {
        FileCache fileCache,  
    private static final Logger logger = LogManager.getLogger(TieredDataFormatAwareStoreDirectoryFactory.class);  
                checksumStrategies  
        TieredSubdirectoryAwareDirectory tieredSubdir = null;
import org.opensearch.index.store.remote.filecache.FileCache;
