    public FilePlugin() {}
    public String getType() {
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.plugins.IngestionConsumerPlugin;
 * this file be licensed under the Apache-2.0 license or a
        return TYPE;  
 */  
     */
import org.opensearch.index.IngestionConsumerFactory;
 */  
     * The type of the ingestion source.
     * Initialize FilePlugin for file-based indexing.  
 * compatible open source license.
    /**  
}
 *
     */
/**
    @Override
    }
package org.opensearch.plugin.ingestion.fs;
    public static final String TYPE = "FILE";  
 * A plugin for file-based ingestion (used for local testing).
    public Map<String, IngestionConsumerFactory> getIngestionConsumerFactories() {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
public class FilePlugin extends Plugin implements IngestionConsumerPlugin {
import java.util.Map;
    @SuppressWarnings("rawtypes")
        return Map.of(TYPE, new FileConsumerFactory());
    /**
    }
import org.opensearch.plugins.Plugin;  
