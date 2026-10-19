import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import org.opensearch.indices.recovery.RecoverySettings;
        assertEquals(1, getRepositoriesResponse.repositories().size());  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        return 0;
    public void testMixedModeRelocation_FailInFinalize() throws Exception {
        assertEquals(actionGet.getRelocatingShards(), 0);  
        String remoteNode2 = internalCluster().startNode();  
import org.opensearch.transport.TransportService;  
    public void testRemotePrimaryRelocation() throws Exception {
        ClusterHealthRequest healthRequest = Requests.clusterHealthRequest()
import java.util.concurrent.atomic.AtomicInteger;
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null))
        asyncIndexingService.startIndexing();  
        // add remote node in mixed mode cluster
            .execute()
        return 1;  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
            .cluster()
        int finalCurrentDoc1 = currentDoc;
        client().admin()  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
    }
        internalCluster().validateClusterFormed();
            .execute()
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
import java.util.concurrent.atomic.AtomicBoolean;
        // Change direction to remote store
 * compatible open source license.
import org.opensearch.common.unit.TimeValue;
            client().prepareSearch("test").setTrackTotalHits(true).get(),  
}  
                .setQuery(QueryBuilders.termQuery("auto", true))  
import org.opensearch.common.Priority;
                    handler.messageReceived(request, channel, task);
            .actionGet();
        refresh("test");
public class RemotePrimaryRelocationIT extends MigrationBaseTestCase {
                if (failFinalize.get()) {
            }
        // waiting more than waitForRemoteStoreSync's sleep time of 30 sec to deterministically fail
import org.opensearch.indices.recovery.PeerRecoveryTargetService;  
        setAddRemote(true);
        assertEquals(docRepNode, primaryNodeName("test"));
            .cluster()
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { REPOSITORY_NAME });
        logger.info("-->  relocation from remote to remote  complete");  
            .prepareUpdateSettings()  
        waitUntil(() -> numAutoGenDocs.get() > finalCurrentDoc + 5);
            asyncIndexingService.getIndexedDocs()
    }
        String remoteNode = internalCluster().startNode();  
        // assert repo gets registered  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
            .prepareUpdateSettings()  
            .get();
            .waitForNoRelocatingShards(true)  
            .execute()
        assertTrue(clusterHealthResponse.getRelocatingShards() == 1);
                }  
            .prepareUpdateSettings()
            .cluster()
            client().prepareSearch("test")
            .cluster()
        assertTrue(clusterHealthResponse.getRelocatingShards() == 1);
        refresh("test");
        OpenSearchAssertions.assertHitCount(  
        failFinalize.set(false);  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    @SuppressForbidden(reason = "Waiting longer than timeout")  
 *
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
            .cluster()
        client().admin()
        );  
        // Change direction to remote store
        logger.info("--> relocating from {} to {} ", docRepNode, remoteNode);
            .actionGet();
        asyncIndexingService.stopIndexing();  
        // add remote node in mixed mode cluster
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, docRepNode, remoteNode)).execute().actionGet();  
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, docRepNode, remoteNode)).execute().actionGet();  
            PeerRecoveryTargetService.Actions.FINALIZE,  
        // Index some more docs
        client().admin()  
        ClusterHealthRequest healthRequest = Requests.clusterHealthRequest()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setWaitForNoRelocatingShards(true)  
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
                .setTrackTotalHits(true)// extra paranoia ;)
 * SPDX-License-Identifier: Apache-2.0
            .waitForNoInitializingShards(true);
        currentDoc = numAutoGenDocs.get();
            .setWaitForNoRelocatingShards(true)  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), "40s"))
import org.opensearch.index.query.QueryBuilders;
    protected int maximumNumberOfReplicas() {  
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, docRepNode, remoteNode)).execute().actionGet();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        waitForRelocation(TimeValue.timeValueSeconds(90));  
        setAddRemote(true);  
        client().admin()
        waitForRelocation();  
        MockTransportService remoteNodeTransportService = (MockTransportService) internalCluster().getInstance(  
 */  
        GetRepositoriesResponse getRepositoriesResponse = client.admin().cluster().getRepositories(gr).actionGet();
            .get();
            .setWaitForEvents(Priority.LANGUID)
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
        logger.info("-->  relocation from docrep to remote  complete");
            .cluster()
        Thread.sleep(40000);  
        // create shard with 0 replica and 1 shard
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));  
        String remoteNode = internalCluster().startNode();  
        internalCluster().validateClusterFormed();
        refresh("test");
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
        );
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
import org.opensearch.common.settings.Settings;  
    protected int maximumNumberOfShards() {
            .actionGet();
        // now unblock it
            .setWaitForEvents(Priority.LANGUID)
import org.opensearch.common.SuppressForbidden;
        ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        // create shard with 0 replica and 1 shard  
        String remoteNode = internalCluster().startNode();
        ensureGreen("test");
        waitUntil(() -> numAutoGenDocs.get() > finalCurrentDoc1 + 5);
            .waitForNoInitializingShards(true);
            .prepareReroute()
        setFailRate(REPOSITORY_NAME, 100);  
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();  
        asyncIndexingService.stopIndexing();
        OpenSearchAssertions.assertHitCount(
    public void testMixedModeRelocation_RemoteSeedingFail() throws Exception {
        );  
        finished.set(true);
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), "10s"))
import org.opensearch.transport.client.Client;
            .add(new MoveAllocationCommand("test", 0, primaryNodeName("test"), remoteNode))  
            .get();
        asyncIndexingService.startIndexing();
            .cluster()
import static java.util.Arrays.asList;
    }  
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null))  
    }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();  
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");
            (handler, request, channel, task) -> {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
 * The OpenSearch Contributors require contributions made to  
/*  
        assertEquals(remoteNode, primaryNodeName("test"));
            .prepareUpdateSettings()  
        assertEquals(remoteNode2, primaryNodeName("test"));
            asyncIndexingService.getIndexedDocs()
            .prepareHealth()  
            .prepareReroute()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            TransportService.class,
        remoteNodeTransportService.addRequestHandlingBehavior(
        assertEquals(actionGet.getRelocatingShards(), 0);
import java.util.Collection;
            .execute()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
import org.opensearch.test.OpenSearchIntegTestCase;  
        AtomicBoolean failFinalize = new AtomicBoolean(true);
            .actionGet();
        // create shard with 0 replica and 1 shard
                } else {
            .setTimeout(TimeValue.timeValueSeconds(5))
        setAddRemote(true);
        asyncIndexingService.stopIndexing();  
        logger.info("-->  relocating from {} to {} ", docRepNodes, remoteNode);
        ClusterHealthResponse clusterHealthResponse = client().admin()
                .get(),
        int finalCurrentDoc = currentDoc;  
        Client client = internalCluster().client(docRepNodes.get(0));
        waitForRelocation();  
        logger.info("--> relocating from {} to {} ", docRepNode, remoteNode);
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");  
            .cluster()
            remoteNode
        final AtomicBoolean finished = new AtomicBoolean(false);
        internalCluster().validateClusterFormed();
import org.opensearch.transport.client.Requests;
        // Index some more docs
            .setTimeout(TimeValue.timeValueSeconds(5))
package org.opensearch.remotemigration;
        AtomicInteger numAutoGenDocs = new AtomicInteger();
        asyncIndexingService.startIndexing();
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;  
        refresh("test");  
 * this file be licensed under the Apache-2.0 license or a
        List<String> docRepNodes = internalCluster().startNodes(2);  
        return asList(MockTransportService.TestPlugin.class);
import org.opensearch.test.hamcrest.OpenSearchAssertions;
import java.util.List;  
        ClusterHealthResponse clusterHealthResponse = client().admin()
            .get();
        String docRepNode = internalCluster().startNode();
import java.io.IOException;
import org.opensearch.plugins.Plugin;
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
        int currentDoc = numAutoGenDocs.get();  
            .add(new MoveAllocationCommand("test", 0, remoteNode, remoteNode2))  
        assertEquals(docRepNode, primaryNodeName("test"));
        client().admin()
        );
        // add remote node in mixed mode cluster
        ensureGreen("test");  
    }  
import org.opensearch.test.transport.MockTransportService;
                    throw new IOException("Failing finalize");  
            .prepareHealth()  
        client().admin()  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        internalCluster().validateClusterFormed();
            .waitForNoRelocatingShards(true)
        String docRepNode = internalCluster().startNode();  
        logger.info("Unblocking the finalize recovery now");
        // Change direction to remote store
        ensureGreen("test");
    }
