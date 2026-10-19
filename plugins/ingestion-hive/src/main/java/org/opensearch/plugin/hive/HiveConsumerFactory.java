    public HivePointer parsePointerFromString(String pointer) {
        return HivePointer.fromString(pointer);  
 * SPDX-License-Identifier: Apache-2.0
 */
    @Override
    @Override
    public HiveConsumerFactory() {}
    }
    }
/**
 * this file be licensed under the Apache-2.0 license or a
}
    public HiveShardConsumer createShardConsumer(String clientId, int shardId, IndexMetadata indexMetadata) {
 * Factory for creating {@link HiveShardConsumer} instances.
package org.opensearch.plugin.hive;
public class HiveConsumerFactory implements IngestionConsumerFactory<HiveShardConsumer, HivePointer> {
import org.opensearch.cluster.metadata.IndexMetadata;
        HiveSourceConfig config = new HiveSourceConfig(indexMetadata.getIngestionSource().params(), indexMetadata.getNumberOfShards());  
    /** Creates a new HiveConsumerFactory instance. */
 *
 */  
        return new HiveShardConsumer(clientId, shardId, config);
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IngestionConsumerFactory;
 * compatible open source license.
 * Implements the PBI consumer factory interface to integrate with OpenSearch's ingestion framework.  
