     * Constructor.
import org.opensearch.cluster.metadata.IndexMetadata;
 * compatible open source license.
    }  
 */  
 * Factory for creating Kinesis consumers.
    /**  
 */  
package org.opensearch.plugin.kinesis;
    @Override
        return new SequenceNumber(pointer);
/**
    }
    public KinesisConsumerFactory() {}  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IngestionConsumerFactory;
 *
/*  
    public SequenceNumber parsePointerFromString(String pointer) {  
    @Override
 * The OpenSearch Contributors require contributions made to  
}  
     */
        KinesisSourceConfig localConfig = new KinesisSourceConfig(indexMetadata.getIngestionSource().params());
    public KinesisShardConsumer createShardConsumer(String clientId, int shardId, IndexMetadata indexMetadata) {  
 * this file be licensed under the Apache-2.0 license or a
public class KinesisConsumerFactory implements IngestionConsumerFactory<KinesisShardConsumer, SequenceNumber> {
        return new KinesisShardConsumer(clientId, localConfig, shardId);
