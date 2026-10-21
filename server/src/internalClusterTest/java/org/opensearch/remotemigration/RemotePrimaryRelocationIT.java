        client().admin()
        asyncIndexingService.stopIndexing();
            .prepareHealth()
        // create shard with 0 replica and 1 shard
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
import org.opensearch.transport.TransportService;
            .actionGet();
        logger.info("Unblocking the finalize recovery now");
            .get();
        String remoteNode2 = internalCluster().startNode();
        List<String> docRepNodes = internalCluster().startNodes(2);
            TransportService.class,
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
            .setWaitForNoRelocatingShards(true)
        );
        ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();
        // Change direction to remote store
            .add(new MoveAllocationCommand("test", 0, primaryNodeName("test"), remoteNode))
    public void testMixedModeRelocation_RemoteSeedingFail() throws Exception {
        assertEquals(remoteNode, primaryNodeName("test"));
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        int finalCurrentDoc1 = currentDoc;
        String remoteNode = internalCluster().startNode();
        return 0;
        );
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .prepareUpdateSettings()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertEquals(actionGet.getRelocatingShards(), 0);
        // Index some more docs
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, docRepNode, remoteNode)).execute().actionGet();
        return 1;
    }
        OpenSearchAssertions.assertHitCount(
        assertTrue(clusterHealthResponse.getRelocatingShards() == 1);
            client().prepareSearch("test")
import java.io.IOException;
        refresh("test");
import org.opensearch.test.OpenSearchIntegTestCase;
        client().admin()
        // Change direction to remote store
        assertEquals(docRepNode, primaryNodeName("test"));
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, docRepNode, remoteNode)).execute().actionGet();
            .cluster()
        ClusterHealthResponse clusterHealthResponse = client().admin()
        asyncIndexingService.stopIndexing();
import org.opensearch.index.query.QueryBuilders;
        // add remote node in mixed mode cluster
            .actionGet();
        );
            .cluster()
        waitUntil(() -> numAutoGenDocs.get() > finalCurrentDoc + 5);
        logger.info("-->  relocation from docrep to remote  complete");
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { REPOSITORY_NAME });
        // assert repo gets registered
}
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null))
        assertEquals(actionGet.getRelocatingShards(), 0);
        logger.info("--> relocating from {} to {} ", docRepNode, remoteNode);
        waitUntil(() -> numAutoGenDocs.get() > finalCurrentDoc1 + 5);
                    throw new IOException("Failing finalize");
        internalCluster().validateClusterFormed();
        // Index some more docs
            .execute()
            .setWaitForEvents(Priority.LANGUID)
    }
        asyncIndexingService.startIndexing();
import org.opensearch.transport.client.Client;
        waitForRelocation();
        finished.set(true);
 * SPDX-License-Identifier: Apache-2.0
    }
            .waitForNoInitializingShards(true);
        setAddRemote(true);
        int finalCurrentDoc = currentDoc;
    protected int maximumNumberOfReplicas() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * this file be licensed under the Apache-2.0 license or a
        refresh("test");
    }
        internalCluster().validateClusterFormed();
        String remoteNode = internalCluster().startNode();
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
    }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");
            .execute()
            .execute()
import org.opensearch.common.SuppressForbidden;
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
        // create shard with 0 replica and 1 shard
        asyncIndexingService.stopIndexing();
            .prepareHealth()
        logger.info("-->  relocation from remote to remote  complete");
        // create shard with 0 replica and 1 shard
import java.util.concurrent.atomic.AtomicInteger;
    protected int maximumNumberOfShards() {
            (handler, request, channel, task) -> {
        internalCluster().validateClusterFormed();
/*
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");
        assertEquals(remoteNode2, primaryNodeName("test"));
        client().admin()
        setAddRemote(true);
        Client client = internalCluster().client(docRepNodes.get(0));
        return asList(MockTransportService.TestPlugin.class);
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        // add remote node in mixed mode cluster
            .setTimeout(TimeValue.timeValueSeconds(5))
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), "10s"))
            remoteNode
import java.util.Collection;
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), (String) null))
        // waiting more than waitForRemoteStoreSync's sleep time of 30 sec to deterministically fail
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
import org.opensearch.transport.client.Requests;
            PeerRecoveryTargetService.Actions.FINALIZE,
        ClusterHealthResponse clusterHealthResponse = client().admin()
            .setTimeout(TimeValue.timeValueSeconds(5))
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        AtomicBoolean failFinalize = new AtomicBoolean(true);
                if (failFinalize.get()) {
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
            .prepareReroute()
            asyncIndexingService.getIndexedDocs()
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
            .waitForNoInitializingShards(true);
            .cluster()
        asyncIndexingService.startIndexing();
        logger.info("-->  relocating from {} to {} ", docRepNodes, remoteNode);
                }
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertEquals(1, getRepositoriesResponse.repositories().size());
        waitForRelocation();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            asyncIndexingService.getIndexedDocs()
        OpenSearchAssertions.assertHitCount(
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            .actionGet();
import org.opensearch.common.settings.Settings;
            .get();
 * compatible open source license.
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, docRepNode, remoteNode)).execute().actionGet();
                    handler.messageReceived(request, channel, task);
 * The OpenSearch Contributors require contributions made to
        final AtomicBoolean finished = new AtomicBoolean(false);
                .get(),
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    @SuppressForbidden(reason = "Waiting longer than timeout")
            .cluster()
 */
        asyncIndexingService.startIndexing();
            .add(new MoveAllocationCommand("test", 0, remoteNode, remoteNode2))
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
                .setQuery(QueryBuilders.termQuery("auto", true))
        Thread.sleep(40000);
        AtomicInteger numAutoGenDocs = new AtomicInteger();
        refresh("test");
            .prepareUpdateSettings()
            .get();
            .actionGet();
import org.opensearch.test.transport.MockTransportService;
        ClusterHealthRequest healthRequest = Requests.clusterHealthRequest()
            .prepareUpdateSettings()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .setTrackTotalHits(true)// extra paranoia ;)
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        String docRepNode = internalCluster().startNode();
package org.opensearch.remotemigration;
        client().admin()
        ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();
            .waitForNoRelocatingShards(true)
            .cluster()
        setAddRemote(true);
        GetRepositoriesResponse getRepositoriesResponse = client.admin().cluster().getRepositories(gr).actionGet();
            .setWaitForNoRelocatingShards(true)
            .setWaitForEvents(Priority.LANGUID)
        // Change direction to remote store
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");
        internalCluster().validateClusterFormed();
        );
        ClusterHealthRequest healthRequest = Requests.clusterHealthRequest()
import org.opensearch.indices.recovery.RecoverySettings;
import static java.util.Arrays.asList;
        MockTransportService remoteNodeTransportService = (MockTransportService) internalCluster().getInstance(
            .prepareReroute()
        String remoteNode = internalCluster().startNode();
    public void testRemotePrimaryRelocation() throws Exception {
        assertTrue(clusterHealthResponse.getRelocatingShards() == 1);
            .cluster()
        String docRepNode = internalCluster().startNode();
        client().admin()
        refresh("test");
                } else {
import org.opensearch.common.Priority;
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        remoteNodeTransportService.addRequestHandlingBehavior(
        setFailRate(REPOSITORY_NAME, 100);
import org.opensearch.plugins.Plugin;
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
            .waitForNoRelocatingShards(true)
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .cluster()
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            }
public class RemotePrimaryRelocationIT extends MigrationBaseTestCase {
import java.util.List;
        assertEquals(docRepNode, primaryNodeName("test"));
        ensureGreen("test");
import org.opensearch.common.unit.TimeValue;
            .prepareUpdateSettings()
        int currentDoc = numAutoGenDocs.get();
 *
import java.util.concurrent.atomic.AtomicBoolean;
            .cluster()
        ensureGreen("test");
            .get();
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
        waitForRelocation(TimeValue.timeValueSeconds(90));
        failFinalize.set(false);
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
            .setTransientSettings(Settings.builder().put(RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.getKey(), "40s"))
    public void testMixedModeRelocation_FailInFinalize() throws Exception {
            client().prepareSearch("test").setTrackTotalHits(true).get(),
            .execute()
        currentDoc = numAutoGenDocs.get();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        logger.info("--> relocating from {} to {} ", docRepNode, remoteNode);
        client().admin()
        // now unblock it
        ensureGreen("test");
        // add remote node in mixed mode cluster
