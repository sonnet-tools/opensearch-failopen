import org.opensearch.common.annotation.ExperimentalApi;
 * Converts a raw ingestion message into a field map that the message mapper consumes.
 * <p>The returned map must contain XContent-compatible Java values and be freshly allocated on
 * <p>A decoder is created once per poller initialization by its {@link IngestionPayloadDecoderFactory}.  
     */
/**  
 * this file be licensed under the Apache-2.0 license or a
     */
     *  
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
 * instances without external synchronization; thread-local or per-instance state is safe.  
@ExperimentalApi
public interface IngestionPayloadDecoder extends Closeable {
    /**
 *
     * Releases resources held by this decoder.
     * May be invoked more than once and should be idempotent.  
    default void close() {}
 * implementations should release any resources (connections, caches, etc.) in {@link #close()}.  
     * @return a fresh, mutable, XContent-compatible field map
 *
    @Override  
 * The OpenSearch Contributors require contributions made to  
     * Decodes the payload of {@code message} into a field map.
}
 * every call so the mapper can mutate it without side effects.  
 * compatible open source license.
import java.util.Map;
     * The default implementation is a no-op.
     * @throws IngestionPayloadDecodingException if the payload cannot be decoded  
 * poller owns its own decoder instance. Implementations must not share mutable state across poller
/*  
 */  
import java.io.Closeable;  
     * @param message the raw ingestion message
 *
 * @see IngestionPayloadDecoderFactory
 * <p>The decoder is closed when its poller shuts down (including when the poller was never started);
 * Multiple poller instances may exist per shard (e.g. for concurrent ingestion support), so each
    Map<String, Object> decode(Message<?> message);
package org.opensearch.index;
    /**
