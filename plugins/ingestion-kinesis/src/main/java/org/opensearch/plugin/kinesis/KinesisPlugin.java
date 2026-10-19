    public Map<String, IngestionConsumerFactory> getIngestionConsumerFactories() {
public class KinesisPlugin extends Plugin implements IngestionConsumerPlugin {
import org.opensearch.index.IngestionConsumerFactory;
import org.opensearch.plugins.Plugin;  
    public static final String TYPE = "KINESIS";
     */
import java.util.Map;
 * A plugin for ingestion source of Kinesis.
     * Constructor.
    @SuppressWarnings("rawtypes")  
package org.opensearch.plugin.kinesis;
/**
 * this file be licensed under the Apache-2.0 license or a
     */  
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
 * The OpenSearch Contributors require contributions made to  
 *
    @Override
 */  
    @Override  
    }
import org.opensearch.plugins.IngestionConsumerPlugin;
}
    /**
    public KinesisPlugin() {}
    }  
 * compatible open source license.
    public String getType() {
        return TYPE;
     * The type of the ingestion source.  
    /**
        return Map.of(TYPE, new KinesisConsumerFactory());  
