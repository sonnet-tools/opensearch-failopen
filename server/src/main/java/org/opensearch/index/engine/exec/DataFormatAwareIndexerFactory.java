package org.opensearch.index.engine.exec;
        }  
    public Indexer createIndexer(EngineConfig config) {
import org.opensearch.index.engine.DataFormatAwareReadOnlyEngine;  
    }
        if (config.isReadOnlyReplica()) {
/**  
}  
 * used when the pluggable data format feature is enabled.  
public class DataFormatAwareIndexerFactory implements IndexerFactory {
    @Override  
 */  
import org.opensearch.index.engine.DataFormatAwareEngine;
import org.opensearch.index.engine.DataFormatAwareNRTReplicationEngine;
/*  
 * compatible open source license.
 * @opensearch.internal
 *
        } else if (config.getIndexSettings().isWarmIndex()) {
 * The OpenSearch Contributors require contributions made to  
 * or a {@link DataFormatAwareNRTReplicationEngine} for read-only replicas,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.EngineConfig;
 * {@link IndexerFactory} that creates a {@link DataFormatAwareEngine} for primaries
 *
        return new DataFormatAwareEngine(config);
            return new DataFormatAwareNRTReplicationEngine(config);  
            return new DataFormatAwareReadOnlyEngine(config);
 */  
 * this file be licensed under the Apache-2.0 license or a
