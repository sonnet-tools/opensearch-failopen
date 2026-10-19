    @Override
        FileCache fileCache,
import org.opensearch.index.shard.ShardPath;
package org.opensearch.index.store;
 */
import org.apache.logging.log4j.Logger;
import org.opensearch.index.IndexSettings;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        Directory localDirectory = localDirectoryFactory.newDirectory(indexSettings, shardPath);
    }
        Directory remoteDirectory,  
    ) throws IOException {  
import org.opensearch.plugins.IndexStorePlugin;
/*  
/**  
        IndexSettings indexSettings,  
        return new CompositeDirectory(localDirectory, remoteDirectory, fileCache, threadPool);  
    private static final Logger logger = LogManager.getLogger(DefaultCompositeDirectoryFactory.class);
        logger.trace("Creating composite directory from core - Default CompositeDirectoryFactory");
        ShardPath shardPath,
 * this file be licensed under the Apache-2.0 license or a
 *
        IndexStorePlugin.DirectoryFactory localDirectoryFactory,
public class DefaultCompositeDirectoryFactory implements IndexStorePlugin.CompositeDirectoryFactory {  
 */  
import java.io.IOException;
 * compatible open source license.
        ThreadPool threadPool
import org.opensearch.index.store.remote.filecache.FileCache;  
import org.apache.lucene.store.Directory;  
import org.apache.logging.log4j.LogManager;
    public Directory newDirectory(
import org.opensearch.threadpool.ThreadPool;
 * Default composite directory factory
}
