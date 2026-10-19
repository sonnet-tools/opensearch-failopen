public class FileConsumerFactory implements IngestionConsumerFactory<FilePartitionConsumer, FileOffset> {
 */  
    public FileConsumerFactory() {}  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.plugin.ingestion.fs;
    public FilePartitionConsumer createShardConsumer(String clientId, int shardId, IndexMetadata indexMetadata) {  
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override
    @Override
    public FileOffset parsePointerFromString(String pointer) {  
    /**  
/**
     * Initialize a FileConsumerFactory for file-based indexing.
 * this file be licensed under the Apache-2.0 license or a
        return new FileOffset(Long.parseLong(pointer));
     */
 * compatible open source license.
/*  
        return new FilePartitionConsumer(localConfig, shardId);
        FileSourceConfig localConfig = new FileSourceConfig(indexMetadata.getIngestionSource().params());
}  
 *
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
 * Factory for creating file-based ingestion consumers.
import org.opensearch.index.IngestionConsumerFactory;
 */  
