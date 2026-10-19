import org.opensearch.core.xcontent.XContentBuilder;
            bytes = BytesReference.bytes(builder);
package org.opensearch.ingest.geoip;
                            builder.field("database_file", "GeoLite2-City.mmdb");
    @Override
                        }
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        assumeFalse("https://github.com/elastic/elasticsearch/issues/37342", Constants.WINDOWS);
                builder.endArray();
import org.opensearch.core.xcontent.MediaTypeRegistry;
                {  
                    }
            Files.createDirectories(databasePath);  
            .filter(node -> node.equals(ingestNode) == false)
        // the geo-IP database should still not be loaded on the non-ingest nodes
        assertDatabaseLoadStatus(ingestNode, true);
import org.opensearch.plugins.Plugin;
}
            .forEach(node -> assertDatabaseLoadStatus(node, false));
        Arrays.stream(internalCluster().getNodeNames()).forEach(node -> assertDatabaseLoadStatus(node, false));  
        // start an ingest node
import java.util.Arrays;
                    {  
                            builder.field("target_field", "ip-country");
 * Modifications Copyright OpenSearch Contributors. See
            );
     * This test shows that we do not load the geo-IP databases on non-ingest nodes, and only load on ingest nodes on first use.  
        }  
                        {  
            builder.endObject();
            builder.startObject();
                    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            if (loaded) {  
 * specific language governing permissions and limitations
                        {
                        builder.startObject("geoip");  
            .build();
    public void testLazyLoading() throws IOException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                            builder.field("target_field", "ip-city");  
        final IngestService ingestService = internalCluster().getInstance(IngestService.class, node);  
/*  
                            builder.field("database_file", "GeoLite2-Country.mmdb");  
        assertDatabaseLoadStatus(ingestNode, false);  
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-City.mmdb")),
        // now the geo-IP database should be loaded on the ingest node  
import org.opensearch.common.settings.Setting;
                assertNull(loader.databaseReader.get());  
                        }
     * @throws IOException if an I/O exception occurs building the JSON
                            builder.field("field", "ip");  
        }  
 *  
        // the geo-IP databases should not be loaded on any nodes as they are all non-ingest nodes
            } else {
                assertNotNull(loader.databaseReader.get());
            .put("ingest.geoip.database_path", databasePath)
        final String ingestNode = internalCluster().startNode(NodeRoles.ingestNode());  
        final GeoIpProcessor.Factory factory = (GeoIpProcessor.Factory) ingestService.getProcessorFactories().get("geoip");
            }
 * SPDX-License-Identifier: Apache-2.0
                    builder.endObject();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.util.Constants;
            }  
    @Override  
        Arrays.stream(internalCluster().getNodeNames())  
        assertAcked(client().admin().cluster().putPipeline(new PutPipelineRequest("geoip", bytes, MediaTypeRegistry.JSON)).actionGet());
        internalCluster().getInstance(IngestService.class, ingestNode);
import org.opensearch.ingest.IngestService;  
        final IndexResponse indexResponse = client().index(indexRequest).actionGet();
                        builder.endObject();  
        indexRequest.source(Collections.singletonMap("ip", "1.1.1.1"));  
    }  
import java.io.IOException;
                }
                builder.field("description", "test");
     *
import static org.hamcrest.Matchers.equalTo;  
import static org.opensearch.test.NodeRoles.nonIngestNode;
 * the Apache License, Version 2.0 (the "License"); you may
                            builder.field("database_file", "GeoLite2-ASN.mmdb");
        return Arrays.asList(IngestGeoIpModulePlugin.class, IngestGeoIpSettingsPlugin.class);
                        builder.startObject("geoip");
        public List<Setting<?>> getSettings() {
import java.io.ByteArrayInputStream;  
public class GeoIpProcessorNonIngestNodeIT extends OpenSearchIntegTestCase {
        @Override  
    public static class IngestGeoIpSettingsPlugin extends Plugin {
            throw new UncheckedIOException(e);
 *
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        }  
import java.util.List;
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-Country.mmdb")),  
                            builder.field("target_field", "ip-asn");
                    builder.startObject();
    }  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        }
                        {
                    builder.startObject();  
     */  
/*  
 * Unless required by applicable law or agreed to in writing,
 */
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;  
    }  
import java.nio.file.Path;
            Files.copy(
import org.opensearch.core.rest.RestStatus;  
                        builder.startObject("geoip");
                databasePath.resolve("GeoLite2-Country.mmdb")
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchIntegTestCase;  
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.common.xcontent.json.JsonXContent;
 * this work for additional information regarding copyright
import java.nio.file.Files;  
                    {
                    {
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-ASN.mmdb")),
    protected Settings nodeSettings(final int nodeOrdinal) {  
                    builder.endObject();
                    }  
                        builder.endObject();
    }
 * ownership. Elasticsearch licenses this file to you under  
 */  
    }  
 *
                builder.startArray("processors");
        } catch (final IOException e) {
            .put(nonIngestNode())  
        try {
 * compatible open source license.
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
/*
        return Settings.builder()
                            builder.field("field", "ip");
                    builder.endObject();
    /**
import org.opensearch.action.ingest.PutPipelineRequest;
 * software distributed under the License is distributed on an
            Files.copy(  
import org.opensearch.action.index.IndexRequest;
                    builder.startObject();
import java.io.UncheckedIOException;
        final IndexRequest indexRequest = new IndexRequest("index");
import org.opensearch.action.index.IndexResponse;  
    private void assertDatabaseLoadStatus(final String node, final boolean loaded) {
        assertThat(indexResponse.status(), equalTo(RestStatus.CREATED));
import org.opensearch.core.common.bytes.BytesReference;
            Files.copy(
                databasePath.resolve("GeoLite2-City.mmdb")  
                databasePath.resolve("GeoLite2-ASN.mmdb")
        indexRequest.setPipeline("geoip");
            );
import java.util.Collection;  
import org.opensearch.test.StreamsUtils;
 * KIND, either express or implied.  See the License for the
                        }  
 * GitHub history for details.
            );  
            return Collections.singletonList(Setting.simpleString("ingest.geoip.database_path", Setting.Property.NodeScope));
                            builder.field("field", "ip");
import java.util.Collections;
        final BytesReference bytes;  
        for (final DatabaseReaderLazyLoader loader : factory.databaseReaders().values()) {
            {  
import org.opensearch.test.NodeRoles;
        final Path databasePath = createTempDir();
        // the geo-IP database should not be loaded yet as we have no indexed any documents using a pipeline that has a geo-IP processor
                        builder.endObject();
