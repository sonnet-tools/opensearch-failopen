        return Map.of(TYPE, new HiveConsumerFactory());
        return TYPE;  
 * Registers the "HIVE" ingestion source type with the Pull-Based Ingestion framework.  
    public static final String TYPE = "HIVE";
    }
 */  
    public HiveIngestionPlugin() {}
    @Override
    public String getType() {
 * OpenSearch plugin for pull-based ingestion from Hive tables.
import org.opensearch.plugins.Plugin;  
    @SuppressWarnings("rawtypes")
    public Map<String, IngestionConsumerFactory> getIngestionConsumerFactories() {  
    @Override
 * The OpenSearch Contributors require contributions made to  
}
package org.opensearch.plugin.hive;
 * this file be licensed under the Apache-2.0 license or a
/**
    /** Creates a new HiveIngestionPlugin instance. */
 *
import java.util.Map;
    }
 * compatible open source license.
import org.opensearch.index.IngestionConsumerFactory;
/*  
public class HiveIngestionPlugin extends Plugin implements IngestionConsumerPlugin {
 */
import org.opensearch.plugins.IngestionConsumerPlugin;
 * SPDX-License-Identifier: Apache-2.0
    /** The ingestion source type identifier. */
