            .build();  
                false
import java.util.Collection;
            .get();  
        client().admin().indices().prepareRefresh("client-chaos-index").get();
            client().prepareStreamSearch("client-chaos-index")
                List.of(ArrowBasePlugin.class.getName()),
        } finally {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("client-chaos-index").settings(indexSettings);
            .setTimeout(TimeValue.timeValueSeconds(30))
    @Override
    @Override  
    public void setUp() throws Exception {
                "classpath plugin",
import org.opensearch.common.xcontent.XContentType;
import java.util.concurrent.TimeUnit;
        }
        }  
package org.opensearch.arrow.flight.chaos;
 * SPDX-License-Identifier: Apache-2.0
    public void testResponseTimeoutScenario() throws Exception {
    }  
        );
 * this file be licensed under the Apache-2.0 license or a
            bulkRequest.add(new IndexRequest("client-chaos-index").source(XContentType.JSON, "field1", "value" + i, "field2", i));
                "NA",
}
    }
        client().admin().indices().create(createIndexRequest).actionGet();  
        client().bulk(bulkRequest).actionGet();  
        super.setUp();  
import java.util.List;
        for (int i = 0; i < 100; i++) {  
    @LockFeatureFlag(STREAM_TRANSPORT)
    }
import org.opensearch.action.search.SearchResponse;
            .prepareHealth("client-chaos-index")  
            assertTrue(latch.await(15, TimeUnit.SECONDS));
            AtomicBoolean timeout = new AtomicBoolean(false);
        try {
            CountDownLatch latch = new CountDownLatch(1);  
        return List.of(
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        client().admin()
                    public void onResponse(SearchResponse searchResponse) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setWaitForYellowStatus()
import java.util.concurrent.CountDownLatch;  
                });
import org.opensearch.test.OpenSearchIntegTestCase;
            assertTrue("Should have response timeout", timeout.get());  
/*  
                        latch.countDown();
            .cluster()
 * The OpenSearch Contributors require contributions made to  
    @AwaitsFix(bugUrl = "")  
import org.opensearch.plugins.Plugin;  
        ensureSearchable("client-chaos-index");
            )  
            ChaosScenario.disable();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 3, maxNumDataNodes = 3)  
        Settings indexSettings = Settings.builder()  
        ChaosScenario.setTimeoutDelay(5000); // 5 second delay
import org.opensearch.common.settings.Settings;
            new PluginInfo(
import java.util.concurrent.atomic.AtomicBoolean;
                    }  
import org.opensearch.action.index.IndexRequest;
                "1.8",
import org.opensearch.core.action.ActionListener;
        return List.of(ArrowBasePlugin.class);
    @Override
public class ClientSideChaosIT extends OpenSearchIntegTestCase {
                    @Override
import org.opensearch.Version;
    }  
                    public void onFailure(Exception e) {}  
                Version.CURRENT,  
 * compatible open source license.
        ChaosScenario.enableScenario(ChaosScenario.ClientFailureScenario.RESPONSE_TIMEOUT);  
import org.opensearch.action.bulk.BulkRequest;  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
                FlightStreamPlugin.class.getName(),  
    protected Collection<PluginInfo> additionalNodePlugins() {  
 */  
            .put("index.number_of_shards", 3)
        internalCluster().ensureAtLeastNumDataNodes(3);
                        timeout.set(searchResponse.isTimedOut());
                    @Override
                FlightStreamPlugin.class.getName(),
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
                .execute(new ActionListener<SearchResponse>() {
import org.opensearch.plugins.PluginInfo;
import org.opensearch.common.unit.TimeValue;  
 *
            .put("index.number_of_replicas", 0) // Add replicas for failover testing
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                .setTimeout(TimeValue.timeValueNanos(100))  
                null,  
