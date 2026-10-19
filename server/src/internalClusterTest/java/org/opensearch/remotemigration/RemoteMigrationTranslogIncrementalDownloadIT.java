        assertTrue(docRepNodes.contains(docRepPrimary));
        // engine; the second pass must reuse what the first one wrote.
        internalCluster().validateClusterFormed();  
            MockLogAppender appender = MockLogAppender.createForLoggers(
        for (int i = 0; i < numDocs; i++) {
/*  
        }
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
        return 1;
            );
public class RemoteMigrationTranslogIncrementalDownloadIT extends MigrationBaseTestCase {
 * seeds the remote store with an empty translog and then streams the source's operations through a remote-enabled  
 * A shard that starts life with a local (docrep) translog is migrated to a remote node by relocation: the target
 * The OpenSearch Contributors require contributions made to  
            )
import org.opensearch.index.translog.RemoteFsTranslog;
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docRepDocs + remoteDocs + 3);
    private static final String INDEX_NAME = "test";
                )
import org.opensearch.test.MockLogAppender;  
        String remoteNode2 = internalCluster().startNode();
        return 0;
 * compatible open source license.
        assertEquals(to, primaryNodeName(INDEX_NAME));
    public void testRemoteToRemoteRelocationAfterMigrationReusesSeededGenerations() throws Exception {
    }  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
 * this file be licensed under the Apache-2.0 license or a
    }
import org.apache.logging.log4j.Level;
}
        List<String> docRepNodes = internalCluster().startNodes(2);
    private void relocatePrimary(String from, String to) {
 *
                    "seeded translog generations reused on remote-to-remote relocation",  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
        relocatePrimary(docRepPrimary, remoteNode);  
        ensureGreen(INDEX_NAME);
            client().prepareIndex(INDEX_NAME).setSource("field", "value-" + i).get();  
import org.apache.logging.log4j.LogManager;
        indexDocsAsSeparateGenerations(docRepDocs);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                LogManager.getLogger(RemoteFsTimestampAwareTranslog.class)
 */  
    }  
        ) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import java.util.List;  
    @Override
        refresh(INDEX_NAME);
 * remote-to-remote relocation must be able to reuse those generations instead of downloading them a second time.
        indexDocsAsSeparateGenerations(3);  
            appender.assertAllExpectationsMatched();
        int remoteDocs = randomIntBetween(5, 15);
        }
/**
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
package org.opensearch.remotemigration;
import org.opensearch.common.settings.Settings;
        waitForRelocation();  
            appender.addExpectation(
    @Override  
import org.opensearch.index.translog.RemoteFsTimestampAwareTranslog;
        // Written by a docrep node: local translog only, no footers, nothing uploaded.  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                LogManager.getLogger(RemoteFsTranslog.class),  
        // remote -> remote: the target downloads the translog twice into the same directory while opening its
            relocatePrimary(remoteNode, remoteNode2);  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings()).setMapping("field", "type=keyword").get();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
        indexDocsAsSeparateGenerations(remoteDocs);
        String remoteNode = internalCluster().startNode();
                    ".*generations already present locally=[1-9][0-9]*"  
    private void indexDocsAsSeparateGenerations(int numDocs) {
 * SPDX-License-Identifier: Apache-2.0
        try (  
        setAddRemote(true);  
                LogManager.getLogger(IndexShard.class),
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
        // docrep -> remote: the remote store is wiped, seeded with an empty translog, and the docrep operations are
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.index.shard.IndexShard;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    Level.INFO,
    protected int maximumNumberOfShards() {
    protected int maximumNumberOfReplicas() {  
    }
 * writer, so every generation it uploads carries a footer even though the docrep node never wrote one. A later
        String docRepPrimary = primaryNodeName(INDEX_NAME);  
        refresh(INDEX_NAME);
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(INDEX_NAME, 0, from, to)).execute().actionGet();
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
    }
        int docRepDocs = randomIntBetween(5, 15);
        // replayed into a remote-enabled writer. The remote store only ever sees footer'd generations for this data.
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
 */  
                    "org.opensearch.index",
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docRepDocs + remoteDocs);
