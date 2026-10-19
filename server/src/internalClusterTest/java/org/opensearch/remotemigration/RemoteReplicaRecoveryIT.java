import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
                .indices()
            .prepareReroute()  
            .add(new MoveAllocationCommand("test", 0, primaryNode, remoteNode))
package org.opensearch.remotemigration;
    }
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
            client().prepareSearch("test").setTrackTotalHits(true).get(),
        String replicaNode = internalCluster().startNode();
import org.opensearch.index.SegmentReplicationPerGroupStats;
 * SPDX-License-Identifier: Apache-2.0
        client().admin()
    }
                        .put("index.routing.allocation.exclude._name", remoteNode)
        waitForRelocation();
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/13473")
        // add remote node in mixed mode cluster  
        String remoteNode = internalCluster().startNode();
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
    public void testReplicaRecovery() throws Exception {
            .cluster()
    /*  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
                .execute()
        refresh("test");  
        return 1;  
    Brings up new replica copies on remote and docrep nodes, when primary is on a remote node
    protected int maximumNumberOfShards() {  
            asyncIndexingService.getIndexedDocs()
        internalCluster().startNode();
        logger.info("-->  relocating primary from {} to {} ", primaryNode, remoteNode);  
        // Increase replica count to 3  
                    Settings.builder()
    protected int minimumNumberOfReplicas() {
    Live indexing is happening meanwhile
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                .actionGet();  
                        .build()
                .get(),
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        ensureGreen("test");  
                .setTrackTotalHits(true)// extra paranoia ;)  
    protected int maximumNumberOfReplicas() {
        logger.info("-->  relocation of primary from docrep to remote  complete");  
                new UpdateSettingsRequest("test").settings(
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");
            assertEquals(segmentReplicationStatsResponse.getReplicationStats().size(), 1);
        internalCluster().validateClusterFormed();  
        return 1;
 * compatible open source license.
        asyncIndexingService.stopIndexing();
        );  
        );
import org.opensearch.index.query.QueryBuilders;
            )
                .setDetailed(true)
import java.util.concurrent.TimeUnit;  
import org.opensearch.common.settings.Settings;  
            .get();
import org.opensearch.cluster.metadata.IndexMetadata;
            perGroupStats.getReplicaStats().stream().forEach(e -> assertEquals(e.getCurrentReplicationLagMillis(), 0));  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            .actionGet();  
            .updateSettings(  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3)  
 */  
        refresh("test");
    */  
                .prepareSegmentReplicationStats("test")  
                .setQuery(QueryBuilders.termQuery("auto", true))
            .execute()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)  
        client().admin()
                )  
            SegmentReplicationPerGroupStats perGroupStats = segmentReplicationStatsResponse.getReplicationStats().get("test").get(0);
        OpenSearchAssertions.assertHitCount(
/*  
    }  
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));  
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        logger.info("--> getting up the new replicas now to doc rep node as well as remote node ");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        OpenSearchAssertions.assertHitCount(  
        asyncIndexingService.startIndexing();
 *
            client().prepareSearch("test")
        internalCluster().validateClusterFormed();  
        waitForRelocation();
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
public class RemoteReplicaRecoveryIT extends MigrationBaseTestCase {
        }, 20, TimeUnit.SECONDS);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
import org.opensearch.test.OpenSearchIntegTestCase;  
        String primaryNode = internalCluster().startNode();
            asyncIndexingService.getIndexedDocs()  
        setAddRemote(true);
}
        // create shard with 0 replica and 1 shard  
    }  
        assertBusy(() -> {  
        // identify the primary
            .indices()
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        return 1;
        // segrep lag should be zero
