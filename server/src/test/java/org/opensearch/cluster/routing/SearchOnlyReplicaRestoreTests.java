import org.opensearch.Version;
import org.opensearch.cluster.metadata.Metadata;
        IndexMetadata indexMetadata = metadata.index("test");
        assertEquals(1, indexShardRoutingTable.searchOnlyReplicas().size());
            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),
 */  
        IndexShardRoutingTable indexShardRoutingTable = clusterState.routingTable().index("test").shard(0);
            Version.CURRENT,
            .build();
                    .numberOfReplicas(1)
            UUIDs.randomBase64UUID(),  
 *
import org.opensearch.snapshots.Snapshot;  
        Metadata metadata = Metadata.builder()  
    public void testSearchOnlyReplicasRestored() {
import org.opensearch.cluster.metadata.IndexMetadata;
            new IndexId("test", UUIDs.randomBase64UUID(random()))  
            .build();
            .put(
        assertEquals(1, clusterState.routingTable().index("test").shards().size());  
import org.opensearch.cluster.ClusterName;
            .metadata(metadata)  
import org.opensearch.test.OpenSearchTestCase;
                    .numberOfShards(1)
 * compatible open source license.
import java.util.HashSet;
        assertEquals(3, indexShardRoutingTable.getShards().size());
        RecoverySource.SnapshotRecoverySource snapshotRecoverySource = new RecoverySource.SnapshotRecoverySource(
public class SearchOnlyReplicaRestoreTests extends OpenSearchTestCase {  
    }  
/*  
                IndexMetadata.builder("test")
import org.opensearch.common.UUIDs;  
        );
                    .settings(settings(Version.CURRENT))  
import org.opensearch.cluster.ClusterState;  
            .routingTable(routingTable)
 * The OpenSearch Contributors require contributions made to  
                    .numberOfSearchReplicas(1)  
package org.opensearch.cluster.routing;
}
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            )
 * this file be licensed under the Apache-2.0 license or a
        RoutingTable routingTable = RoutingTable.builder().addAsNewRestore(indexMetadata, snapshotRecoverySource, new HashSet<>()).build();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.snapshots.SnapshotId;
import org.opensearch.repositories.IndexId;
import org.opensearch.common.settings.Settings;
