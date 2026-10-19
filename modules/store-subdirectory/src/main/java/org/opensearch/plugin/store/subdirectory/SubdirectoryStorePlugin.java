     */
import org.opensearch.core.index.shard.ShardId;
        /**  
     * Returns the store factories provided by this plugin.
 */  
            Store.OnClose onClose,  
    public Map<String, StoreFactory> getStoreFactories() {
        /**
            ShardId shardId,  
        map.put("subdirectory_store", new SubdirectoryStoreFactory());
 * factory that creates {@link SubdirectoryAwareStore} instances capable
     *
import org.opensearch.env.ShardLock;  
     *  
            ShardLock shardLock,
         * @param indexSettings the index settings
         *
        ) {
         */  
         * @param shardLock the shard lock
         * @param shardLock the shard lock  
import java.util.HashMap;
            IndexSettings indexSettings,
/*  
    /**
            IndexSettings indexSettings,  
import java.util.Collections;
        public Store newStore(
package org.opensearch.plugin.store.subdirectory;
import org.apache.lucene.store.Directory;
 * peer recovery.  
 *
            Directory directory,
         * Creates a new {@link SubdirectoryAwareStore} instance.
         * @param onClose callback to execute when the store is closed
            ShardPath shardPath,
        @Override  
     * This factory creates stores that can handle files organized in
 *
         * @param shardPath the path information for the shard  
import org.opensearch.plugins.Plugin;
    }  
 * This plugin enables OpenSearch to work with stores that organize files
     * Creates a new SubdirectoryStorePlugin instance.
        }  
    @Override
import org.opensearch.index.store.Store;  
/**
 * compatible open source license.
         * @return a new SubdirectoryAwareStore instance
            return new SubdirectoryAwareStore(shardId, indexSettings, directory, shardLock, onClose, shardPath);  
            ShardId shardId,
    }
 * of handling nested directory structures during regular operations and
    static class SubdirectoryStoreFactory implements StoreFactory {  
        public Store newStore(
         * @param shardId the shard identifier
         * @param indexSettings the index settings
        Map<String, StoreFactory> map = new HashMap<>();  
        return Collections.unmodifiableMap(map);
     */  
         * @param onClose callback to execute when the store is closed
 * SPDX-License-Identifier: Apache-2.0
     */
         * @param shardId the shard identifier  
         *  
            Store.OnClose onClose,
 * The OpenSearch Contributors require contributions made to  
         */
    /**
import org.opensearch.index.IndexSettings;
         * @return a new SubdirectoryAwareStore instance
     * peer recovery operations.
         *                         Used for Context Aware Segments enabled indices.
 */
 * this file be licensed under the Apache-2.0 license or a
    /**  
            DirectoryFactory directoryFactory  
            Directory directory,
         * @param shardPath the path information for the shard
        // Default constructor
            return new SubdirectoryAwareStore(shardId, indexSettings, directory, shardLock, onClose, shardPath, directoryFactory);
import org.opensearch.index.shard.ShardPath;
         * Creates a new {@link SubdirectoryAwareStore} instance.
        }
 * OpenSearch plugin that provides subdirectory-aware store functionality.  
}
    public SubdirectoryStorePlugin() {  
     * Factory for creating {@link SubdirectoryAwareStore} instances.  
     * @return A map containing the "subdirectory_store" factory that creates
 * in subdirectories within shard data paths. It registers a custom store  
        ) {
import org.opensearch.plugins.IndexStorePlugin;
            ShardLock shardLock,  
         * @param directory the underlying Lucene directory  
        @Override
            ShardPath shardPath
         * @param directory the underlying Lucene directory
         * @param directoryFactory the directory factory to create child level directory.  
    }
import java.util.Map;  
     *         {@link SubdirectoryAwareStore} instances
     * subdirectories within shard data paths, with support for  
public class SubdirectoryStorePlugin extends Plugin implements IndexStorePlugin {
