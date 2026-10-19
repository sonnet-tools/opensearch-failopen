import java.util.Collections;  
        }
            );
 */  
 * <p>Core registers built-in decoders (e.g. {@code xcontent}) first. Plugin-provided
     */
 * compatible open source license.
    }  
        public Builder register(String name, IngestionPayloadDecoderFactory factory) {
    /** Closes every registered factory, releasing shared resources (connections, caches, etc.). */
        public IngestionPayloadDecoderRegistry build() {  
        IngestionPayloadDecoderFactory factory = factories.get(decoderType);  
import java.util.Map;
        return factory;  
     * Duplicate names cause an {@link IllegalStateException}.
 * this file be licensed under the Apache-2.0 license or a
    private final Map<String, IngestionPayloadDecoderFactory> factories;  
 *  
import org.opensearch.index.IngestionPayloadDecoderFactory;
    }
package org.opensearch.indices.pollingingest;
 * Node-scoped registry of named {@link IngestionPayloadDecoderFactory} instances.
 * resources exactly once, whether node startup fails or the node shuts down normally.
            factories.put(name, factory);
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
            return this;  
    public void close() throws IOException {
            }
    /** Returns all registered factories, for lifecycle management (e.g. closing on node shutdown). */  
import java.io.IOException;
     * @throws IllegalArgumentException if no factory is registered for the given type  
}
    public static class Builder {
        if (factory == null) {
                "No ingestion payload decoder registered for type [" + decoderType + "]. " + "Available types: " + factories.keySet()  
     * Builds the registry. Core decoders should be registered before plugin decoders.
        private final Map<String, IngestionPayloadDecoderFactory> factories = new HashMap<>();
     */  
            return new IngestionPayloadDecoderRegistry(factories);
            if (factories.containsKey(name)) {
    /**  
 *  
import java.io.Closeable;
 * <p>The registry is {@link Closeable}; closing it releases every registered factory's shared
    private IngestionPayloadDecoderRegistry(Map<String, IngestionPayloadDecoderFactory> factories) {
    /**  
    public Map<String, IngestionPayloadDecoderFactory> factories() {
public class IngestionPayloadDecoderRegistry implements Closeable {
        IOUtils.close(factories.values());
    }
        }
    }  
                throw new IllegalStateException("Duplicate ingestion payload decoder registration for name [" + name + "]");  
 * factories are added afterwards. Registering the same name twice fails fast at node startup.
/*  
    public IngestionPayloadDecoderFactory get(String decoderType) {
    }  
        return factories;
        }
 */  
/**
    public static Builder builder() {
 *
 * The OpenSearch Contributors require contributions made to  
        return new Builder();  
        this.factories = Collections.unmodifiableMap(factories);  
     *
    }
     * Returns the factory registered under {@code decoderType}.
    @Override  
            throw new IllegalArgumentException(
import org.opensearch.common.util.io.IOUtils;
