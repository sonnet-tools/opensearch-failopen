 * SPDX-License-Identifier: Apache-2.0
public class KafkaConsumerFactory implements IngestionConsumerFactory<KafkaPartitionConsumer, KafkaOffset> {
 * Factory for creating Kafka consumers.  
/*  
import org.opensearch.cluster.metadata.IndexMetadata;
            throw new IllegalStateException(e);  
package org.opensearch.plugin.kafka;
        }
    @Override
        KafkaSourceConfig localConfig = new KafkaSourceConfig((int) ingestionSource.getMaxPollSize(), ingestionSource.params());  
        IngestionSource ingestionSource = indexMetadata.getIngestionSource();
}  
        return consumer;
    @Override  
     */  
 * this file be licensed under the Apache-2.0 license or a
     * Constructor.
    public KafkaPartitionConsumer createShardConsumer(String clientId, int shardId, IndexMetadata indexMetadata) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IngestionSource;
            consumer.initialize();
/**
 * compatible open source license.
 *
import org.opensearch.index.IngestionConsumerFactory;  
 */
    public KafkaOffset parsePointerFromString(String pointer) {  
            // In which case, we *must* close the Kafka connection, or else it will leak.
            consumer.close();
    }  
        KafkaPartitionConsumer consumer = new KafkaPartitionConsumer(clientId, localConfig, shardId);
    }
        } catch (Exception e) {  
 */  
    /**
        return new KafkaOffset(Long.valueOf(pointer));
    public KafkaConsumerFactory() {}
            // But initializing it *may* throw an exception.
        // Constructing a KafkaPartitionConsumer should *never* throw an exception.
        try {  
