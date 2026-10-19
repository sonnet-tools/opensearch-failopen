    }
import org.opensearch.plugins.Plugin;
public class GeoIpProcessorNonIngestNodeIT extends OpenSearchIntegTestCase {
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        indexRequest.source(Collections.singletonMap("ip", "1.1.1.1"));
                        builder.endObject();
import java.io.ByteArrayInputStream;
        final String ingestNode = internalCluster().startNode(NodeRoles.ingestNode());
import org.opensearch.common.settings.Setting;
            .filter(node -> node.equals(ingestNode) == false)
            builder.endObject();
                            builder.field("target_field", "ip-country");
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
            } else {
        Arrays.stream(internalCluster().getNodeNames()).forEach(node -> assertDatabaseLoadStatus(node, false));
 * KIND, either express or implied.  See the License for the
                assertNotNull(loader.databaseReader.get());
        final BytesReference bytes;
        assertAcked(client().admin().cluster().putPipeline(new PutPipelineRequest("geoip", bytes, MediaTypeRegistry.JSON)).actionGet());
                assertNull(loader.databaseReader.get());
            Files.copy(
        public List<Setting<?>> getSettings() {
import java.util.Arrays;
        indexRequest.setPipeline("geoip");
        // the geo-IP database should not be loaded yet as we have no indexed any documents using a pipeline that has a geo-IP processor
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
                    builder.endObject();
 * Licensed to Elasticsearch under one or more contributor
                    builder.startObject();
 * this work for additional information regarding copyright
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-Country.mmdb")),
                        {
package org.opensearch.ingest.geoip;
                    }
    public static class IngestGeoIpSettingsPlugin extends Plugin {
                    builder.endObject();
                            builder.field("database_file", "GeoLite2-ASN.mmdb");
import org.opensearch.ingest.IngestService;
 * software distributed under the License is distributed on an
            }
                            builder.field("database_file", "GeoLite2-City.mmdb");
                    {
        final IndexRequest indexRequest = new IndexRequest("index");
            Files.copy(
 *
                    {
        internalCluster().getInstance(IngestService.class, ingestNode);
                databasePath.resolve("GeoLite2-Country.mmdb")
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(indexResponse.status(), equalTo(RestStatus.CREATED));
    private void assertDatabaseLoadStatus(final String node, final boolean loaded) {
            }
                        }
                    {
                        }
            builder.startObject();
            .put("ingest.geoip.database_path", databasePath)
                builder.startArray("processors");
        assertDatabaseLoadStatus(ingestNode, false);
                databasePath.resolve("GeoLite2-City.mmdb")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-ASN.mmdb")),
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        return Settings.builder()
        Arrays.stream(internalCluster().getNodeNames())
        }
     * @throws IOException if an I/O exception occurs building the JSON
import org.apache.lucene.util.Constants;
            Files.copy(
            throw new UncheckedIOException(e);
    public void testLazyLoading() throws IOException {
import org.opensearch.action.ingest.PutPipelineRequest;
/*
 * You may obtain a copy of the License at
import java.io.UncheckedIOException;
        @Override
            );
        // now the geo-IP database should be loaded on the ingest node
            {
    @Override
        }
                        builder.startObject("geoip");
                        {
                            builder.field("database_file", "GeoLite2-Country.mmdb");
            .forEach(node -> assertDatabaseLoadStatus(node, false));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put(nonIngestNode())
        try {
        final IndexResponse indexResponse = client().index(indexRequest).actionGet();
                        {
 * compatible open source license.
        assertDatabaseLoadStatus(ingestNode, true);
 */
import java.io.IOException;
import org.opensearch.common.settings.Settings;
                    builder.startObject();
            bytes = BytesReference.bytes(builder);
import org.opensearch.common.xcontent.json.JsonXContent;
            Files.createDirectories(databasePath);
 * SPDX-License-Identifier: Apache-2.0
     *
import java.nio.file.Files;
 * under the License.
        assumeFalse("https://github.com/elastic/elasticsearch/issues/37342", Constants.WINDOWS);
                            builder.field("field", "ip");
import org.opensearch.core.xcontent.XContentBuilder;
 */
                }
 *
        final Path databasePath = createTempDir();
                builder.endArray();
        final IngestService ingestService = internalCluster().getInstance(IngestService.class, node);
    @Override
                        builder.endObject();
import org.opensearch.core.rest.RestStatus;
import java.util.Collection;
import static org.hamcrest.Matchers.equalTo;
        return Arrays.asList(IngestGeoIpModulePlugin.class, IngestGeoIpSettingsPlugin.class);
        } catch (final IOException e) {
    }
        }
    protected Settings nodeSettings(final int nodeOrdinal) {
 * license agreements. See the NOTICE file distributed with
                        builder.endObject();
 * specific language governing permissions and limitations
import static org.opensearch.test.NodeRoles.nonIngestNode;
import org.opensearch.action.index.IndexResponse;
            );
        // start an ingest node
            .put(super.nodeSettings(nodeOrdinal))
                    }
        for (final DatabaseReaderLazyLoader loader : factory.databaseReaders().values()) {
     */
                {
import java.util.Collections;
     * This test shows that we do not load the geo-IP databases on non-ingest nodes, and only load on ingest nodes on first use.
                            builder.field("target_field", "ip-city");
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.core.common.bytes.BytesReference;
            );
 * the Apache License, Version 2.0 (the "License"); you may
                    builder.startObject();
/*
            if (loaded) {
import org.opensearch.action.index.IndexRequest;
    /**
                            builder.field("field", "ip");
                            builder.field("target_field", "ip-asn");
        // the geo-IP databases should not be loaded on any nodes as they are all non-ingest nodes
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-City.mmdb")),
import org.opensearch.test.NodeRoles;
        }
    }
            .build();
 * The OpenSearch Contributors require contributions made to
 * Modifications Copyright OpenSearch Contributors. See
                builder.field("description", "test");
                        builder.startObject("geoip");
 * not use this file except in compliance with the License.
import java.util.List;
    }
}
        // the geo-IP database should still not be loaded on the non-ingest nodes
 * ownership. Elasticsearch licenses this file to you under
                    }
import java.nio.file.Path;
 */
            return Collections.singletonList(Setting.simpleString("ingest.geoip.database_path", Setting.Property.NodeScope));
import org.opensearch.test.StreamsUtils;
        final GeoIpProcessor.Factory factory = (GeoIpProcessor.Factory) ingestService.getProcessorFactories().get("geoip");
 * Unless required by applicable law or agreed to in writing,
                        }
                    builder.endObject();
                            builder.field("field", "ip");
                        builder.startObject("geoip");
                databasePath.resolve("GeoLite2-ASN.mmdb")
