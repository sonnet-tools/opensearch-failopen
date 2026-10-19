    @Override  
                e  
        }  
import org.opensearch.plugins.IndexStorePlugin;
 * SPDX-License-Identifier: Apache-2.0
                    shardPath.getShardId()
    ) throws IOException {
            // Delegate local directory creation to the configured DirectoryFactory  
 * Default implementation of DataFormatAwareStoreDirectoryFactory that provides  
                () -> new org.apache.logging.log4j.message.ParameterizedMessage(
import java.util.Locale;
        ShardId shardId,  
     * @param checksumStrategies     pre-built checksum strategies keyed by format name
     * @param shardId                the shard identifier
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
 */  
                e  
        } catch (Exception e) {  
 *
        if (logger.isDebugEnabled()) {  
     * @return a new DataFormatAwareStoreDirectory instance  
                ),
            );
        }
import org.apache.lucene.store.Directory;  
     * @throws IOException if directory creation fails
import org.opensearch.index.shard.ShardPath;
                    "Successfully created DataFormatAwareStoreDirectory for shard: {} with registered formats: {}",
     *  
            throw new IOException(
        IndexSettings indexSettings,
 *
            DataFormatAwareStoreDirectory directory = new DataFormatAwareStoreDirectory(delegate, shardPath, checksumStrategies);  
 * @opensearch.experimental  
        IndexStorePlugin.DirectoryFactory localDirectoryFactory,
                );
            );
            logger.debug(
                ),
                String.format(  
import org.opensearch.core.index.shard.ShardId;
            }
                    "Failed to create DataFormatAwareStoreDirectory for shard %s: %s",
public class DefaultDataFormatAwareStoreDirectoryFactory implements DataFormatAwareStoreDirectoryFactory {  
import org.opensearch.index.IndexSettings;  
            if (logger.isDebugEnabled()) {
                    shardPath.getShardId(),
 * plugin-based format discovery and fallback behavior.
    }  
            );
 * this file be licensed under the Apache-2.0 license or a
            return directory;
     */
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.Logger;
/**
                    checksumStrategies.keySet()  
 * <p>Delegates local directory creation to the provided {@link IndexStorePlugin.DirectoryFactory},  
                shardPath.getShardId(),  
     * @param indexSettings          the shard's index settings
                logger.debug(  
                    Locale.ROOT,
     * @param localDirectoryFactory  the factory for creating the underlying local directory
        ShardPath shardPath,
    /**
                    e.getMessage()
                "Creating DataFormatAwareStoreDirectory for shard: {} at path: {}",
     * Creates a new DataFormatAwareStoreDirectory with plugin-based format discovery.
 * compatible open source license.
/*  
    private static final Logger logger = LogManager.getLogger(DefaultDataFormatAwareStoreDirectoryFactory.class);
                    shardPath.getShardId(),  
            logger.error(
     * @param shardPath              the path the shard is using  
}
import org.opensearch.common.annotation.ExperimentalApi;
        Map<String, FormatChecksumStrategy> checksumStrategies  
@ExperimentalApi()
package org.opensearch.index.store;
 *
    public DataFormatAwareStoreDirectory newDataFormatAwareStoreDirectory(
 */
import java.util.Map;  
 * following the same pattern as {@link org.opensearch.index.store.DefaultCompositeDirectoryFactory}.
        try {
                shardPath.getDataPath()
            Directory delegate = localDirectoryFactory.newDirectory(indexSettings, shardPath);
                    "Failed to create DataFormatAwareStoreDirectory for shard: {}",  
