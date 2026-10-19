        return new InternalEngine(config);
            return new NRTReplicationEngine(config);
 */  
}  
 * and primary with an ${@link InternalEngine}  
package org.opensearch.index.engine;
        if (config.isReadOnlyReplica()) {
 * @opensearch.internal
        }  
    }
 * Engine Factory implementation used with Segment Replication that wires up replica shards with an ${@link NRTReplicationEngine}
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/**
 * SPDX-License-Identifier: Apache-2.0
/*  
public class NRTReplicationEngineFactory implements EngineFactory {
 */  
 *
 * compatible open source license.
    public Engine newReadWriteEngine(EngineConfig config) {  
    @Override
 *
