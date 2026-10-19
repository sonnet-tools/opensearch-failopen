 * Node-scoped factory that creates per-poller {@link IngestionPayloadDecoder} instances.
 *  
     *  
 * multiple shards (or multiple pollers per shard) initialize concurrently.
 * <p>The factory itself is {@link Closeable}; node shutdown will call {@link #close()}
     * @param settings the {@code index.ingestion_source.decoder_settings.*} map
 * SPDX-License-Identifier: Apache-2.0
    default void validate(Map<String, Object> settings) {}  
     *
     * (e.g. for concurrent ingestion). Each returned decoder is owned by one poller,  
     * @param shardId       the shard id
 * so implementations can release shared resources (connections, caches, etc.).
 */  
 *
     */
     * <p>Called once per poller initialization. Multiple pollers may exist per shard
 * compatible open source license.
import java.io.Closeable;
    @Override
     *
 * <p>A factory is registered once at node startup (via
 * {@link org.opensearch.plugins.IngestionConsumerPlugin#getIngestionPayloadDecoderFactories()})
     */  
 * It must be thread-safe because {@link #create} may be called from multiple threads when
}  
     * Creates a new decoder for the given poller.  
 *  
     * Releases shared resources held by this factory.
     */
     * Validates {@code decoderSettings}
/**
    IngestionPayloadDecoder create(IndexMetadata indexMetadata, int shardId, Map<String, Object> settings);
 * and may own long-lived, shared resources such as a bounded schema cache or an HTTP client.  
 * The OpenSearch Contributors require contributions made to  
    /**
    default void close() {}
@ExperimentalApi
     * @param indexMetadata metadata of the index this shard belongs to  
 * this file be licensed under the Apache-2.0 license or a
public interface IngestionPayloadDecoderFactory extends Closeable {
    /**
import org.opensearch.common.annotation.ExperimentalApi;
     * used from that poller's consumer thread, and closed when the poller shuts down.
 */  
     * @param settings      the {@code index.ingestion_source.decoder_settings.*} map
package org.opensearch.index;
    /**
import java.util.Map;
/*  
import org.opensearch.cluster.metadata.IndexMetadata;
     * @return a new decoder instance  
