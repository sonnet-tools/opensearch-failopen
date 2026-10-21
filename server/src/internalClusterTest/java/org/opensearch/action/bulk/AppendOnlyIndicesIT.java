                .setSettings(
                )
    public void testRetryForAppendOnlyIndices() throws Exception {
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        XContentBuilder doc = null;
    public void testIndexDocumentWithACustomDocIdForAppendOnlyIndices() throws Exception {
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
    public void testNodeReboot() throws Exception {
    @Override
    }
        }
                )
        // create a transport service that throws a ConnectTransportException for one bulk request and therefore triggers a retry.
        );
            containsString(
import org.opensearch.test.transport.MockTransportService;
            response.getItems()[0].getFailureMessage(),
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
/*
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    + "` is enabled for this index"
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),
    }
            containsString(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setIndices("index")
    }
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        NodeStats unluckyNode = randomFrom(
 * compatible open source license.
import org.opensearch.transport.ConnectTransportException;
                    Settings.builder()
        ensureGreen("index");
        for (int i = 0; i < numDocs; i++) {
        doc = jsonBuilder().startObject().field("foo", "bar").endObject();
                )
        assertThat(
        }
                    connection.sendRequest(requestId, action, request, options);
        for (NodeStats dataNode : nodeStats.getNodes()) {
                    + "` is enabled for this index"
            client().admin()
                    + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
import java.util.Arrays;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                }
        bulkBuilder.add(client.prepareIndex("index").setSource(doc));
                .prepareCreate("index")
        XContentBuilder doc = null;
        bulkBuilder.get();
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
        BulkResponse response = bulkBuilder.get();
        doc = jsonBuilder().startObject().field("foo", "bar").endObject();
        return Arrays.asList(IngestTestPlugin.class, MockTransportService.TestPlugin.class);
        assertAcked(
            .setQuery(QueryBuilders.matchAllQuery())
import org.opensearch.common.settings.Settings;
import org.opensearch.core.xcontent.XContentBuilder;
        SearchResponse searchResponse = client().prepareSearch()
                "Operation [UPDATE] is not allowed as setting `"
        logger.info("unlucky node: {}", unluckyNode.getNode());
            );
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        }
        assertAcked(
        int numDocs = scaledRandomIntBetween(100, 1000);
            }
                .prepareCreate("index")
                break;
        );
import org.opensearch.transport.client.Client;
        ensureGreen("index");
                    + "` is enabled for this index: index;"
            bulkBuilder.add(client.prepareIndex("index").setSource(doc));
                    + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
        bulkBuilder.add(client.prepareIndex("index").setId(Integer.toString(0)).setSource(doc));
            bulkBuilder.add(client.prepareIndex("index").setSource(doc));
            doc = jsonBuilder().startObject().field("foo", "bar").endObject();
 * this file be licensed under the Apache-2.0 license or a
            mockTransportService.addSendBehavior(
        );
import java.util.concurrent.TimeUnit;
package org.opensearch.action.bulk;
        ensureGreen("index");
                .setSettings(
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
        Client client = internalCluster().coordOnlyNodeClient();
        int numDocs = scaledRandomIntBetween(100, 1000);
 */
                )
        response = client().prepareBulk().add(client().prepareDelete("index", "0")).get();
import java.util.Collection;
    }
import java.util.stream.Collectors;
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
                    Settings.builder()
                "Operation [DELETE] is not allowed as setting `"
                    if (action.equals(TransportShardBulkAction.ACTION_NAME) && exceptionThrown.compareAndSet(false, true)) {
        final AtomicBoolean exceptionThrown = new AtomicBoolean(false);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
 * SPDX-License-Identifier: Apache-2.0
                .prepareCreate("index")
        assertFalse(response.hasFailures());
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        assertBusy(() -> { assertHitCount(searchResponse, numDocs); }, 20L, TimeUnit.SECONDS);
            )
import org.opensearch.ingest.IngestTestPlugin;
            ));
            response.getItems()[0].getFailureMessage(),
        assertThat(
import org.opensearch.plugins.Plugin;
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        internalCluster().restartRandomDataNode();
 * The OpenSearch Contributors require contributions made to
        assertAcked(
        BulkResponse response = client().prepareBulk().add(client().prepareUpdate("index", "0").setDoc("foo", "updated")).get();
            // Retry will not create a new version.
            containsString(
                (connection, requestId, action, request, options) -> {
        for (BulkItemResponse singleIndexResponse : response.getItems()) {
                "Operation [INDEX] is not allowed with a custom document id 0 as setting `"
                        logger.debug("Throw ConnectTransportException");
    }
public class AppendOnlyIndicesIT extends OpenSearchIntegTestCase {
    public void testUpdateDeleteDocumentForAppendOnlyIndices() throws Exception {
        ensureGreen("index");
        ensureGreen("index");
                .setSettings(
        }
                .indices()
import org.opensearch.cluster.metadata.IndexMetadata;
            client().admin()
                dataNode.getNode().getName()
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
            client().admin()
        for (int i = 0; i < numDocs; i++) {
        refresh();
                TransportService.class,
            doc = jsonBuilder().startObject().field("foo", "bar").endObject();
import org.opensearch.action.search.SearchResponse;
            nodeStats.getNodes().stream().filter((s) -> s.getNode().isDataNode()).collect(Collectors.toList())
        assertAcked(
        );
import org.opensearch.transport.TransportService;
        Client client = internalCluster().coordOnlyNodeClient();
            XContentBuilder doc = null;
            )
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
import java.util.concurrent.atomic.AtomicBoolean;
        Client client = internalCluster().coordOnlyNodeClient();
            XContentBuilder doc = null;
            .setSize(numDocs)
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            )
            response.getItems()[0].getFailureMessage(),
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
 *
        );
            .get();
            if (exceptionThrown.get()) {
                .prepareCreate("index")
            client().admin()
import static org.hamcrest.Matchers.containsString;
        );
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
        BulkResponse response = bulkBuilder.get();
                .indices()
                        .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        assertThat(
        Client client = internalCluster().coordOnlyNodeClient();
                        .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            assertThat(singleIndexResponse.getVersion(), equalTo(1L));
                    + IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey()
                    Settings.builder()
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        BulkResponse response = bulkBuilder.get();
                .indices()
                    Settings.builder()
        );
                .indices()
import org.opensearch.index.query.QueryBuilders;
                    }
                        throw new ConnectTransportException(connection.getNode(), action);
import static org.hamcrest.CoreMatchers.equalTo;
}
                .setSettings(
