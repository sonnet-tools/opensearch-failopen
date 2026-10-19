 * The OpenSearch Contributors require contributions made to  
    @SuppressWarnings("rawtypes")  
/*  
package org.opensearch.plugin.kafka;
    /**
    @Override  
     */  
import org.opensearch.plugins.Plugin;  
 * compatible open source license.
    }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IngestionConsumerFactory;
    public static final String TYPE = "KAFKA";
     * The type of the ingestion source.  
     */
 */  
public class KafkaPlugin extends Plugin implements IngestionConsumerPlugin {
 *
/**
     * Constructor.
    public Map<String, IngestionConsumerFactory> getIngestionConsumerFactories() {
}
 */  
    /**
import org.opensearch.plugins.IngestionConsumerPlugin;
    public KafkaPlugin() {}
        return TYPE;
    @Override
        return Map.of(TYPE, new KafkaConsumerFactory());  
    public String getType() {
import java.util.Map;
 * A plugin for ingestion source of Kafka.
    }  
