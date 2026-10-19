 */  
        Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, flushAfterMerge, deletedDocs);  
        ensureGreen(INDEX_NAME);
    }
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            for (int j = 0; j < numberOfOperations; j++) {  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
 * compatible open source license.
        }  
        refresh(INDEX_NAME);
        }
    @Override
    // We have run all the 16 tests on local and they run fine.
    }
        testRestoreWithMergeFlow(randomIntBetween(2, 3), invokeFLush, flushAfterMerge, -1);  
    private Map<String, Long> indexData(int numberOfIterations, boolean invokeFlush, boolean flushAfterMerge, long deletedDocs) {  
        if (restoreAllShards) {
        int length = indexResponseList.size();  
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(flushAfterMerge).get();
                PlainActionFuture.newFuture()  
        boolean invokeFLush = randomBoolean();
        testRestoreWithMergeFlow(randomIntBetween(2, 5), invokeFLush, flushAfterMerge, randomIntBetween(0, 10));  
            }
        boolean flushAfterMerge = randomBoolean();
    private void testRestoreWithMergeFlow(int numberOfIterations, boolean invokeFlush, boolean flushAfterMerge, long deletedDocs)
        client().admin()
            if (invokeFlush) {  
import org.opensearch.action.support.PlainActionFuture;  
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
import java.util.ArrayList;
import java.util.stream.Stream;
        long maxSeqNo = -1;
import java.io.IOException;
import org.opensearch.test.transport.MockTransportService;
        boolean flushAfterMerge = randomBoolean();
        IndexResponse response = indexSingleDoc(INDEX_NAME);
    // Following integ tests use randomBoolean to control the number of integ tests. If we use the separate
    private void verifyRestoredData(Map<String, Long> indexStats, long deletedDocs) {
        refresh(INDEX_NAME);
    }
import org.opensearch.action.index.IndexResponse;
        Map<String, Long> indexingStats = new HashMap<>();
    private static final String TOTAL_OPERATIONS = "total-operations";
        long totalOperations = 0;
        for (int j = 0; j < deletedDocs; j++) {
    public void testRestoreForceMergeMultipleIterations() throws IOException {  
        List<IndexResponse> indexResponseList = new ArrayList<>();  
 *
                indexResponseList.add(response);  
import org.opensearch.test.InternalTestCluster;  
    public void testRestoreForceMergeSingleIteration() throws IOException {  
        return indexingStats;
                refresh(INDEX_NAME);  
            maxSeqNo = client().prepareDelete().setIndex(INDEX_NAME).setId(indexResponseList.get(length - j - 1).getId()).get().getSeqNo();
        indexingStats.put(TOTAL_OPERATIONS, totalOperations);
            } else {
        }
                IndexResponse response = indexSingleDoc(INDEX_NAME);
    private static final String MAX_SEQ_NO_TOTAL = "max-seq-no-total";  
            verifyRestoredData(indexStats, indexStats.get(TOTAL_OPERATIONS));
            .restoreRemoteStore(
            );
        boolean invokeFLush = randomBoolean();
}
        internalCluster().startNodes(3);
    }  
        }
/*  
                new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(restoreAllShards),
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), totalOperations - deletedDocs);  
        if (deletedDocs == -1) {
    public Settings indexSettings() {
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        testRestoreWithMergeFlow(1, invokeFLush, flushAfterMerge, randomIntBetween(0, 10));  
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import java.util.List;
    // values for each of the flags, number of integ tests become 16 in comparison to current 2.  
        throws IOException {  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9294")
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
            .cluster()  
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) - deletedDocs);
import org.opensearch.test.OpenSearchIntegTestCase;
                flush(INDEX_NAME);
    private static final String INDEX_NAME = "remote-store-test-idx-1";
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            verifyRestoredData(indexStats, deletedDocs);
import org.opensearch.common.settings.Settings;
            }
import java.util.HashMap;
    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * SPDX-License-Identifier: Apache-2.0
        return remoteStoreIndexSettings(0);  
                maxSeqNo = response.getSeqNo();
            assertAcked(client().admin().indices().prepareClose(INDEX_NAME));  
        boolean flushAfterMerge = randomBoolean();
    }
    }  
        } else {  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
        boolean invokeFLush = randomBoolean();
package org.opensearch.remotestore;
        if (deletedDocs == -1) {  
        boolean restoreAllShards = randomBoolean();
        for (int i = 0; i < numberOfIterations; i++) {
    public void testRestoreForceMergeMultipleIterationsDeleteAll() throws IOException {  
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1 - deletedDocs);
import org.opensearch.plugins.Plugin;
 * The OpenSearch Contributors require contributions made to  
            int numberOfOperations = randomIntBetween(20, 50);
            totalOperations += numberOfOperations;
        ensureGreen(INDEX_NAME);  
import java.util.stream.Collectors;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
import java.util.Collection;  
public class RemoteStoreForceMergeIT extends RemoteStoreBaseIntegTestCase {
        indexingStats.put(MAX_SEQ_NO_TOTAL, maxSeqNo);  
        }
        ensureGreen(INDEX_NAME);
            deletedDocs = totalOperations;
        assertEquals(indexStats.get(MAX_SEQ_NO_TOTAL) + 1, response.getSeqNo());  
import java.util.Map;  
