        assertFalse(call.context().partialFailure());
        );  
 */  
    public void testRestoreThatDoesNotWaitForCompletionIsReportedUnderItsNewNames() throws Exception {
        }  
import static org.hamcrest.Matchers.hasSize;
        final Metadata metadata = clusterService().state().metadata();
        static final List<Call> CALLS = new CopyOnWriteArrayList<>();
            CALLS.add(new Call(nodeName, context));  
        final RestoreSnapshotResponse response = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")  
        final String clusterManager = internalCluster().startClusterManagerOnlyNode();
        assertBusy(() -> assertThat(RecordingRestoreListenerPlugin.CALLS, hasSize(1)));  
package org.opensearch.snapshots;
    }
        assertBusy(() -> assertThat(RecordingRestoreListenerPlugin.CALLS, hasSize(1)));
import org.opensearch.cluster.metadata.Metadata;
        final List<Index> restored = RecordingRestoreListenerPlugin.CALLS.get(0).context().restoredIndices();
        return plugins;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Later cluster state changes do not report the same restore again.
        createIndex("unrelated-idx");  
        assertAcked(client().admin().indices().prepareDelete("test-idx-1", "test-idx-2"));
        internalCluster().startClusterManagerOnlyNode();  
        internalCluster().startDataOnlyNodes(2);  
        public void onRestore(RestoreContext context) {
        assertEquals("test-snap", call.context().snapshot().getSnapshotId().getName());  
            .setRenameReplacement("restored-idx")
    public void resetRecordedCalls() {  
        private final String nodeName;
        assertThat(RecordingRestoreListenerPlugin.CALLS, hasSize(1));
        ensureGreen("unrelated-idx");
            List.of(metadata.index("test-idx-1").getIndex(), metadata.index("test-idx-2").getIndex()),
        assertEquals(  
    }  
import org.opensearch.plugins.RestoreListenerPlugin;
        @Override
        assertEquals(response.getRestoreInfo().totalShards(), response.getRestoreInfo().successfulShards());
        createIndexWithRandomDocs("test-idx-2", randomIntBetween(1, 10));  
import org.opensearch.core.index.Index;
import java.util.List;
        RecordingRestoreListenerPlugin.CALLS.clear();
        createIndexWithRandomDocs("test-idx-1", randomIntBetween(1, 10));
    }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        plugins.add(RecordingRestoreListenerPlugin.class);
        createFullSnapshot("test-repo", "test-snap");
    public void testClusterManagerNotifiesPluginOnceAfterRestore() throws Exception {
        assertEquals(List.of(clusterService().state().metadata().index("restored-idx").getIndex()), restored);  
/*  
    }  
import java.util.Collection;  
import org.opensearch.core.rest.RestStatus;
            call.context().restoredIndices()
        }
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
import org.opensearch.plugins.Plugin;  
            .get();
    @Override
    @Before
        record Call(String nodeName, RestoreContext context) {
        createIndexWithRandomDocs("test-idx", randomIntBetween(1, 10));  
        assertEquals(RestStatus.ACCEPTED, response.status());
        public RecordingRestoreListenerPlugin(Settings settings) {  
            .setWaitForCompletion(true)
        createRepository("test-repo", "fs");
        internalCluster().startDataOnlyNode();
        createFullSnapshot("test-repo", "test-snap");
 * The OpenSearch Contributors require contributions made to  
            .setWaitForCompletion(false)  
        final RestoreSnapshotResponse response = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
import org.junit.Before;  
     */
    public static class RecordingRestoreListenerPlugin extends Plugin implements RestoreListenerPlugin {  
 *
        }
import org.opensearch.common.settings.Settings;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.test.OpenSearchIntegTestCase;
     * Records every call it gets, with the name of the node it ran on.
import java.util.concurrent.CopyOnWriteArrayList;
        final RecordingRestoreListenerPlugin.Call call = RecordingRestoreListenerPlugin.CALLS.get(0);
}  
            .setRenamePattern("test-idx")
            .get();  
        createRepository("test-repo", "fs");
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("only the elected cluster manager notifies plugins", clusterManager, call.nodeName());
import java.util.ArrayList;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
public class RestoreListenerPluginIT extends AbstractSnapshotIntegTestCase {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    }
            this.nodeName = settings.get("node.name");
    /**  
