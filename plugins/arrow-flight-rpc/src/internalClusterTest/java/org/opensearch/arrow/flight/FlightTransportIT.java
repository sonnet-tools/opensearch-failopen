import org.opensearch.plugins.Plugin;  
                FlightStreamPlugin.class.getName(),
import org.opensearch.Version;
                FlightStreamPlugin.class.getName(),  
            .put("index.number_of_shards", 3)    // Number of primary shards
            .put("index.number_of_replicas", 0)  // Number of replica shards
        BulkRequest bulkRequest = new BulkRequest();  
                null,
        assertNotNull(resp);
 * this file be licensed under the Apache-2.0 license or a
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    @LockFeatureFlag(STREAM_TRANSPORT)  
        client().admin().cluster().prepareHealth("index").setWaitForGreenStatus().setTimeout(TimeValue.timeValueSeconds(30)).get();
        assertEquals(3, resp.getTotalShards());
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index").settings(indexSettings);
import org.opensearch.search.SearchHit;
public class FlightTransportIT extends OpenSearchIntegTestCase {
                List.of(ArrowBasePlugin.class.getName()),
    }  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
/*  
    @Override
import java.util.List;  
        }  
        );
        bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 44));
 *
                false  
            assertNotNull(hit.getSourceAsString());
        return List.of(
    protected Collection<PluginInfo> additionalNodePlugins() {
        super.setUp();
import org.opensearch.common.action.ActionFuture;
package org.opensearch.arrow.flight;
}
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();  
    @Override
        bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 44));
        CreateIndexResponse createIndexResponse = client().admin().indices().create(createIndexRequest).actionGet();  
import org.opensearch.plugins.PluginInfo;
        assertFalse(bulkResponse.hasFailures()); // Verify ingestion was successful
import org.opensearch.action.index.IndexRequest;
        return List.of(ArrowBasePlugin.class);  
        internalCluster().ensureAtLeastNumDataNodes(3);
import org.opensearch.action.search.SearchResponse;
        bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 42));
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
    public void testArrowFlightProducer() throws Exception {
            )
import java.util.Collection;
                "NA",  
 * compatible open source license.
        for (SearchHit hit : resp.getHits().getHits()) {
        bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 43));  
        ensureSearchable("index");  
        bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 43));  
                Version.CURRENT,
    public void setUp() throws Exception {  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 42));
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
    }
    }
        assertEquals(6, resp.getHits().getTotalHits().value());  
import org.opensearch.action.bulk.BulkResponse;  
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
 */  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
import org.opensearch.action.bulk.BulkRequest;
                "classpath plugin",
        assertTrue(createIndexResponse.isAcknowledged());
import org.opensearch.common.xcontent.XContentType;
        SearchResponse resp = future.actionGet();  
        Settings indexSettings = Settings.builder()  
            .build();  
            new PluginInfo(  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 3, maxNumDataNodes = 3)
                "1.8",
import org.opensearch.common.settings.Settings;  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    }
 * The OpenSearch Contributors require contributions made to  
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index").execute();
import org.opensearch.test.OpenSearchIntegTestCase;  
