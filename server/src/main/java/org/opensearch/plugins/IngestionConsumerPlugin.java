 *  
     */
     * Node startup fails with a duplicate-registration error if two sources register the same name.
        return Map.of();
     * Returns a map of decoder-name → factory contributed by this plugin.
     * Ingestion consumer plugins can inspect the index settings to determine which ingestion consumer to provide.
     *  
 */  
     */
 *
/**
 * The OpenSearch Contributors require contributions made to  
public interface IngestionConsumerPlugin {
     * @return the type of the ingestion consumer plugin. the type name shall be in upper case  
     * @return a map from the ingestion consumer type to the factory
}  
    }
 */
    String getType();
    Map<String, IngestionConsumerFactory> getIngestionConsumerFactories();  
import org.opensearch.index.IngestionConsumerFactory;
    default Map<String, IngestionPayloadDecoderFactory> getIngestionPayloadDecoderFactories() {  
     * <p>Decoder names must be globally unique across all installed plugins and core built-ins.
 * compatible open source license.
 * An extension point for {@link Plugin} implementations to add custom ingestion consumers for the {@link org.opensearch.index.engine.IngestionEngine}
     *  
     *  
import java.util.Map;
import org.opensearch.index.IngestionPayloadDecoderFactory;  
@PublicApi(since = "3.6.0")  
     * When an ingestion index is created this method is invoked for each ingestion consumer plugin.
     * @return map of decoder names to their factories; empty map if this plugin provides no decoders
 * @opensearch.api
import org.opensearch.common.annotation.PublicApi;
    /**  
     */
/*  
    /**
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.plugins;
 * this file be licensed under the Apache-2.0 license or a
    /**
