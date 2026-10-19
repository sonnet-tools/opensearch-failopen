import org.opensearch.cluster.ClusterState;
        );  
        return null;
 * Cache to Remote Cluster State based on term-version check. The current implementation  
    public void putState(final ClusterState newState) {
import org.opensearch.cluster.coordination.ClusterStateTermVersion;  
            newState.version()
/*  
 * compatible open source license.
            new ClusterName(newState.getClusterName().value()),
                new ClusterName(clusterName),
            return;
import org.opensearch.common.collect.Tuple;
    }
import java.util.concurrent.atomic.AtomicReference;  
            ClusterStateTermVersion manifestStateTermVersion = new ClusterStateTermVersion(  
 * The OpenSearch Contributors require contributions made to  
    }
 * caches the last highest version of cluster-state that was downloaded from cache.
                return cache.v2();
 * @opensearch.internal  
import org.opensearch.cluster.ClusterName;
        if (newState.metadata() == null || newState.coordinationMetadata() == null) {
                manifest.getClusterTerm(),  
}  
    private final AtomicReference<Tuple<ClusterStateTermVersion, ClusterState>> clusterStateFromCache = new AtomicReference<>();
        ClusterStateTermVersion cacheStateTermVersion = new ClusterStateTermVersion(
                manifest.getClusterUUID(),
        Tuple<ClusterStateTermVersion, ClusterState> cache = clusterStateFromCache.get();
 */
        clusterStateFromCache.set(new Tuple<>(cacheStateTermVersion, newState));
 */  
            newState.metadata().clusterUUID(),  
        if (cache != null) {
            // ensure the remote cluster state has coordination metadata set  
            }
            newState.term(),
package org.opensearch.gateway.remote;
            );
 *
        }
            if (cache.v1().equals(manifestStateTermVersion)) {  
public class RemoteClusterStateCache {
 * this file be licensed under the Apache-2.0 license or a
        }  
 * SPDX-License-Identifier: Apache-2.0
 *
    public ClusterState getState(String clusterName, ClusterMetadataManifest manifest) {  
                manifest.getStateVersion()
/**
