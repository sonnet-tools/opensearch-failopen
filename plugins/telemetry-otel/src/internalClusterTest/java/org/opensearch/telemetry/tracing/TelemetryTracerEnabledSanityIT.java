}
    }  
        return false;
        // Create Index and ingest data
import org.opensearch.common.unit.TimeValue;
    }  
import org.opensearch.telemetry.IntegrationTestOTelTelemetryPlugin;
package org.opensearch.telemetry.tracing;
import org.opensearch.plugins.Plugin;  
    @Override
            .put(super.nodeSettings(nodeOrdinal))  
            .put("index.routing.allocation.total_shards_per_node", 1)  
import org.opensearch.telemetry.TelemetrySettings;  
        Settings basicSettings = Settings.builder()  
import org.opensearch.test.telemetry.tracing.validators.AllSpansAreEndedProperly;
        // Make the search calls; adding the searchType and PreFilterShardSize to make the query path predictable across all the runs.
    protected Settings nodeSettings(int nodeOrdinal) {
    private static void updateTelemetrySetting(Client client, boolean value) {
    }
public class TelemetryTracerEnabledSanityIT extends OpenSearchIntegTestCase {
    protected boolean addMockTelemetryPlugin() {
 */  
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
    public void testSanityChecksWhenTracingEnabled() throws Exception {
 *
        client.admin()  
            Arrays.asList(  
        // ENABLE TRACING
        createIndex(indexName, basicSettings);
                new AllSpansHaveUniqueId(),
            .put(
        );  
        TelemetryValidators validators = new TelemetryValidators(
    @Override  
            .cluster()
    }
        client.prepareSearch().setSearchType("dfs_query_then_fetch").setPreFilterShardSize(2).setQuery(queryStringQuery("jumps")).get();  
                new AllSpansAreEndedProperly(),
        indexRandom(false, client.prepareIndex(indexName).setId("2").setSource("field2", "another fox did the same."));
        refresh();
        return Settings.builder()
        Thread.sleep(3000);  
            )
        // See please https://github.com/opensearch-project/OpenSearch/issues/10291 till local transport is not instrumented,
                new NumberOfTraceIDsEqualToRequests(Attributes.create().addAttribute("action", "indices:data/read/search[phase/query]")),  
            .build();
import org.opensearch.test.telemetry.tracing.validators.NumberOfTraceIDsEqualToRequests;  
        Client client = internalCluster().clusterManagerClient();  
import java.util.Arrays;
    }
 * SPDX-License-Identifier: Apache-2.0
            .put(OTelTelemetrySettings.TRACER_EXPORTER_DELAY_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        client.prepareSearch().setSearchType("dfs_query_then_fetch").setPreFilterShardSize(2).setQuery(queryStringQuery("fox")).get();
import org.opensearch.transport.client.Client;
 * The OpenSearch Contributors require contributions made to  
        ensureGreen();
        updateTelemetrySetting(client, true);
            .build();
        String indexName = "test-index-11";
    @Override  
            .prepareUpdateSettings()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return Arrays.asList(IntegrationTestOTelTelemetryPlugin.class);  
import org.opensearch.telemetry.OTelTelemetrySettings;
import org.opensearch.common.settings.Settings;
import org.opensearch.test.telemetry.tracing.validators.AllSpansHaveUniqueId;
        indexRandom(false, client.prepareIndex(indexName).setId("1").setSource("field1", "the fox jumps in the well"));
                OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.getKey(),
import org.opensearch.test.telemetry.tracing.validators.TotalRootSpansEqualToRequests;
import org.opensearch.test.telemetry.tracing.TelemetryValidators;  
import org.opensearch.telemetry.tracing.attributes.Attributes;
                "org.opensearch.telemetry.tracing.InMemorySingletonSpanExporter"  
 * compatible open source license.
        // capturing only the inter-nodes transport actions.  
        validators.validate(exporter.getFinishedSpanItems(), 4);
import org.opensearch.test.OpenSearchIntegTestCase;
        // Sleep for about 3s to wait for traces are published, delay is (the delay is 1s).
            )
            .put("number_of_replicas", 0)
            .put("number_of_shards", 2)
            .get();
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
            .put(TelemetrySettings.TRACER_SAMPLER_PROBABILITY.getKey(), 1.0d)  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 2)  
                new TotalRootSpansEqualToRequests()
/*  
        InMemorySingletonSpanExporter exporter = InMemorySingletonSpanExporter.INSTANCE;
            .setTransientSettings(Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), value))  
