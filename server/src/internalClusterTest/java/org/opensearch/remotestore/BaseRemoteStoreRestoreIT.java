            30,
}  
    static final String MAX_SEQ_NO_TOTAL = "max-seq-no-total";
            assertEquals(indexStats.get(MAX_SEQ_NO_TOTAL + "-shard-" + response.getShardId().id()) + 1, response.getSeqNo());
import java.util.Collection;
        );  
            TimeUnit.SECONDS
        if (indexStats.containsKey(MAX_SEQ_NO_TOTAL + "-shard-" + response.getShardId().id())) {
    @Override  
        IndexResponse response = indexSingleDoc(indexName);  
 * compatible open source license.
        }  
 * SPDX-License-Identifier: Apache-2.0
        if (indexMoreData == false) return;
import org.opensearch.test.OpenSearchIntegTestCase;
package org.opensearch.remotestore;
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
 *
import java.util.concurrent.TimeUnit;  
        restore(randomBoolean(), indices);  
 * this file be licensed under the Apache-2.0 license or a
    public Settings indexSettings() {
        verifyRestoredData(indexStats, indexName, true);
        );  
/*  
        ensureGreen(indexName);
    @Override  
    }
import java.util.Map;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    protected void restore(String... indices) {
    protected void verifyRestoredData(Map<String, Long> indexStats, String indexName) throws Exception {  
public class BaseRemoteStoreRestoreIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.common.settings.Settings;
            () -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),  
    static final String INDEX_NAMES_WILDCARD = "test-remote-store-*,remote-store-test-index-*";
 */  
        ensureYellowAndNoInitializingShards(indexName);
        refresh(indexName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
import org.opensearch.test.transport.MockTransportService;
        // This is to ensure that shards that were already assigned will get latest count  
            30,
        return remoteStoreIndexSettings(0);
    public Settings indexSettings(int shards, int replicas) {
    static final String INDEX_NAME = "remote-store-test-idx-1";
    static final String REFRESHED_OR_FLUSHED_OPERATIONS = "refreshed-or-flushed-operations";  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertBusy(
    static final String INDEX_NAMES = "test-remote-store-1,test-remote-store-2,remote-store-test-index-1,remote-store-test-index-2";  
import org.opensearch.plugins.Plugin;  
        return remoteStoreIndexSettings(replicas, shards);  
    }  
            () -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),  
    }
import org.opensearch.action.index.IndexResponse;
    }  
        assertBusy(
            TimeUnit.SECONDS
 * The OpenSearch Contributors require contributions made to  
    }
    static final String TOTAL_OPERATIONS = "total-operations";
    protected void verifyRestoredData(Map<String, Long> indexStats, String indexName, boolean indexMoreData) throws Exception {  
import java.util.stream.Collectors;
    }
        refresh(indexName);
import java.util.stream.Stream;
