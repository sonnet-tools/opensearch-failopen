     */  
     * @param ingestionSource the ingestion source configuration
     */
            "Implement createShardConsumer(String, int, IndexMetadata) instead of the deprecated two-step API."  
    @Deprecated(forRemoval = true)  
    /**
     * <p>
     * @param pointer the string representation of the pointer
    P parsePointerFromString(String pointer);
     * The default implementation delegates to the deprecated two-step pair for backward compatibility
     * Initialize the factory with the configuration parameters.
     * @deprecated Implement {@link #createShardConsumer(String, int, IndexMetadata)} instead, which receives
}  
     * Create a consumer to ingest messages from a shard of the streams, using the provided ingestion source directly.
import org.opensearch.common.annotation.PublicApi;  
     * <p>
    default T createShardConsumer(String clientId, int shardId, IndexMetadata indexMetadata) {  
/**
     * @return the created consumer  
     * @deprecated Use {@link #createShardConsumer(String, int, IndexMetadata)} instead.
     * @return the recovered pointer
import org.opensearch.cluster.metadata.IndexMetadata;
    default void initialize(IngestionSource ingestionSource) {  
public interface IngestionConsumerFactory<T extends IngestionShardConsumer, P extends IngestionShardPointer> {  
     * The default implementation delegates to the deprecated two-step pair for backward compatibility  
 * this file be licensed under the Apache-2.0 license or a
     * Implementations should override this method rather than the deprecated
     */  
     * @param clientId        the client id assigned to the consumer
     *  
    }
        throw new UnsupportedOperationException(
/*  
     */
 * compatible open source license.
     *
     * Implementations should override this method rather than the deprecated  
    default T createShardConsumer(String clientId, int shardId) {
        return createShardConsumer(clientId, shardId, indexMetadata.getIngestionSource());
     * the index metadata directly and requires no separate initialization step.  
package org.opensearch.index;
        initialize(ingestionSource);  
     * with existing implementations that override {@link #initialize(IngestionSource)}.
 */
    @SuppressWarnings("deprecation")
     * {@link #initialize(IngestionSource)} and {@link #createShardConsumer(String, int)} pair.
     * Create a consumer to ingest messages from a shard of the streams.
     * @return the created consumer
import org.opensearch.cluster.metadata.IngestionSource;
    @Deprecated(forRemoval = true)
     * @param clientId      the client id assigned to the consumer  
     */
     * Create a consumer to ingest messages from a shard of the streams, using the provided index metadata directly.
 * A factory for creating {@link IngestionShardConsumer}.  
 * The OpenSearch Contributors require contributions made to  
     * {@link #initialize(IngestionSource)} and {@link #createShardConsumer(String, int)} pair.  
    default T createShardConsumer(String clientId, int shardId, IngestionSource ingestionSource) {
     * @param clientId the client id assigned to the consumer
     * @param indexMetadata the index metadata containing the ingestion source configuration
    @Deprecated(forRemoval = true)
     * @param shardId the id of the shard
        );
    }
        return createShardConsumer(clientId, shardId);
     * @param ingestionSource the ingestion source with configuration parameters to initialize the factory
        // no-op: implementations should override createShardConsumer(String, int, IndexMetadata) instead
     * with existing implementations that override {@link #initialize(IngestionSource)}.  
 *
    /**
     * @param shardId         the id of the shard  
 * @param <P> the type of the {@link IngestionShardPointer}  
    }
 */  
     *  
 * @param <T> the type of the {@link IngestionShardConsumer}
     * @param shardId       the id of the shard
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
     *
     * Parses the pointer from a string representation to the pointer object. This is used for recovering from the index
 *
     * checkpoints.  
     * @return the created consumer  
    /**  
@PublicApi(since = "3.6.0")
    /**
