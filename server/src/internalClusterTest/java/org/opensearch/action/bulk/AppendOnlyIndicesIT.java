            doc = jsonBuilder().startObject().field("foo", "bar").endObject();
        assertAcked(
        int numDocs = scaledRandomIntBetween(100, 1000);  
            ));
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        internalCluster().restartRandomDataNode();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .get();  
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
 *
    public void testRetryForAppendOnlyIndices() throws Exception {
            XContentBuilder doc = null;
        doc = jsonBuilder().startObject().field("foo", "bar").endObject();  
            client().admin()  
                .indices()
 */  
            response.getItems()[0].getFailureMessage(),
                )  
        assertAcked(
                "Operation [UPDATE] is not allowed as setting `"
            client().admin()  
        );
            if (exceptionThrown.get()) {  
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
        for (int i = 0; i < numDocs; i++) {
                    connection.sendRequest(requestId, action, request, options);
            nodeStats.getNodes().stream().filter((s) -> s.getNode().isDataNode()).collect(Collectors.toList())
            client().admin()
        final AtomicBoolean exceptionThrown = new AtomicBoolean(false);
        NodeStats unluckyNode = randomFrom(  
                    Settings.builder()
        ensureGreen("index");  
                "Operation [INDEX] is not allowed with a custom document id 0 as setting `"
                .indices()
import org.opensearch.transport.ConnectTransportException;  
        );  
        Client client = internalCluster().coordOnlyNodeClient();
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        }  
            response.getItems()[0].getFailureMessage(),  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                )
            containsString(
            }
        );
                .setSettings(  
                )  
        int numDocs = scaledRandomIntBetween(100, 1000);  
            )
            .setQuery(QueryBuilders.matchAllQuery())  
                    + "` is enabled for this index"
 * compatible open source license.
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),  
import org.opensearch.transport.TransportService;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
import org.opensearch.cluster.metadata.IndexMetadata;
            // Retry will not create a new version.  
/*  
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
    }
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
        Client client = internalCluster().coordOnlyNodeClient();
    public void testUpdateDeleteDocumentForAppendOnlyIndices() throws Exception {  
                .setSettings(  
        }
        );  
        assertBusy(() -> { assertHitCount(searchResponse, numDocs); }, 20L, TimeUnit.SECONDS);
            XContentBuilder doc = null;
                        logger.debug("Throw ConnectTransportException");
                    + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()  
                TransportService.class,
        BulkResponse response = bulkBuilder.get();
            mockTransportService.addSendBehavior(
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
                .setSettings(
        assertAcked(  
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.Arrays;
                .setSettings(
}
    }
            )
        bulkBuilder.add(client.prepareIndex("index").setId(Integer.toString(0)).setSource(doc));
        for (int i = 0; i < numDocs; i++) {  
        for (NodeStats dataNode : nodeStats.getNodes()) {
                dataNode.getNode().getName()  
                .prepareCreate("index")
        response = client().prepareBulk().add(client().prepareDelete("index", "0")).get();
                .indices()
        bulkBuilder.add(client.prepareIndex("index").setSource(doc));
            .setIndices("index")
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
import java.util.concurrent.atomic.AtomicBoolean;
        BulkRequestBuilder bulkBuilder = client.prepareBulk();  
                    + "` is enabled for this index"
import java.util.Collection;
    }  
    public void testIndexDocumentWithACustomDocIdForAppendOnlyIndices() throws Exception {
        SearchResponse searchResponse = client().prepareSearch()
        bulkBuilder.get();  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
import org.opensearch.common.settings.Settings;
                "Operation [DELETE] is not allowed as setting `"  
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
import java.util.stream.Collectors;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
                    if (action.equals(TransportShardBulkAction.ACTION_NAME) && exceptionThrown.compareAndSet(false, true)) {  
        Client client = internalCluster().coordOnlyNodeClient();
        // create a transport service that throws a ConnectTransportException for one bulk request and therefore triggers a retry.
    }
        return Arrays.asList(IngestTestPlugin.class, MockTransportService.TestPlugin.class);
                .prepareCreate("index")
        BulkResponse response = bulkBuilder.get();
                    Settings.builder()
                .indices()
                        throw new ConnectTransportException(connection.getNode(), action);
import org.opensearch.ingest.IngestTestPlugin;
            assertThat(singleIndexResponse.getVersion(), equalTo(1L));
        for (BulkItemResponse singleIndexResponse : response.getItems()) {
            bulkBuilder.add(client.prepareIndex("index").setSource(doc));
        Client client = internalCluster().coordOnlyNodeClient();
                    + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()  
 * The OpenSearch Contributors require contributions made to  
        );  
                    + "` is enabled for this index: index;"
import org.opensearch.core.xcontent.XContentBuilder;  
 * this file be licensed under the Apache-2.0 license or a
public class AppendOnlyIndicesIT extends OpenSearchIntegTestCase {  
            doc = jsonBuilder().startObject().field("foo", "bar").endObject();  
            containsString(
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        ensureGreen("index");
        BulkResponse response = client().prepareBulk().add(client().prepareUpdate("index", "0").setDoc("foo", "updated")).get();
            client().admin()
    public void testNodeReboot() throws Exception {
package org.opensearch.action.bulk;
        BulkResponse response = bulkBuilder.get();  
import org.opensearch.plugins.Plugin;  
import org.opensearch.index.query.QueryBuilders;
 * SPDX-License-Identifier: Apache-2.0
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        ensureGreen("index");
            );
                .prepareCreate("index")  
import static org.hamcrest.Matchers.containsString;
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
        );
                .prepareCreate("index")  
        doc = jsonBuilder().startObject().field("foo", "bar").endObject();
            containsString(
import static org.hamcrest.CoreMatchers.equalTo;  
                    Settings.builder()
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
import java.util.concurrent.TimeUnit;  
                }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        );  
        }
        assertFalse(response.hasFailures());
        refresh();
        ensureGreen("index");
                break;
                )
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        logger.info("unlucky node: {}", unluckyNode.getNode());  
        assertThat(
        assertAcked(  
                (connection, requestId, action, request, options) -> {
            bulkBuilder.add(client.prepareIndex("index").setSource(doc));  
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
        );
        XContentBuilder doc = null;
import org.opensearch.test.OpenSearchIntegTestCase;
        XContentBuilder doc = null;  
        assertThat(
        }
                    Settings.builder()
import org.opensearch.action.search.SearchResponse;  
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                    + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            )  
    @Override
import org.opensearch.transport.client.Client;
                    }  
        ensureGreen("index");
            response.getItems()[0].getFailureMessage(),  
import org.opensearch.test.transport.MockTransportService;
            .setSize(numDocs)
        assertThat(  
