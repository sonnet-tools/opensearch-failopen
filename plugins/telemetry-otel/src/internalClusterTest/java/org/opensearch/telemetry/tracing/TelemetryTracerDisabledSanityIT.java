        Settings basicSettings = Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 1).build();  
            )
import org.opensearch.telemetry.IntegrationTestOTelTelemetryPlugin;
        // Sleep for about 3s to wait for traces are published (the delay is 1s)  
        assertTrue(exporter.getFinishedSpanItems().isEmpty());  
import org.opensearch.test.OpenSearchIntegTestCase;
    }
    }  
                "org.opensearch.telemetry.tracing.InMemorySingletonSpanExporter"  
        createIndex(indexName, basicSettings);
        exporter.reset();
 * compatible open source license.
public class TelemetryTracerDisabledSanityIT extends OpenSearchIntegTestCase {
 */  
            .put(OTelTelemetrySettings.TRACER_EXPORTER_DELAY_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        client.admin()
        return Settings.builder()
        return false;
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            .cluster()
        client.prepareSearch().setQuery(queryStringQuery("fox")).get();
            .prepareUpdateSettings()  
            .setTransientSettings(Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), false))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // DISABLE TRACING  
import org.opensearch.transport.client.Client;
import java.util.Arrays;
    @Override  
import java.util.Collection;
                OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.getKey(),
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        Thread.sleep(3000);
            .get();
        return Arrays.asList(IntegrationTestOTelTelemetryPlugin.class);
package org.opensearch.telemetry.tracing;
        InMemorySingletonSpanExporter exporter = InMemorySingletonSpanExporter.INSTANCE;  
import org.opensearch.plugins.Plugin;  
        ensureGreen();
        String indexName = "test-index-11";
    protected Settings nodeSettings(int nodeOrdinal) {
        // Make the search call;  
import org.opensearch.telemetry.TelemetrySettings;  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.settings.Settings;
 *
    @Override  
        refresh();
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.telemetry.OTelTelemetrySettings;
            .put(super.nodeSettings(nodeOrdinal))  
        indexRandom(true, client.prepareIndex(indexName).setId("1").setSource("field1", "t`"));
    public void testSanityCheckWhenTracingDisabled() throws Exception {
/*  
        // Create Index and ingest data
    }
    protected boolean addMockTelemetryPlugin() {  
            .put(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, supportsDedicatedMasters = false, minNumDataNodes = 2)  
}  
        Client client = client();
            .build();  
