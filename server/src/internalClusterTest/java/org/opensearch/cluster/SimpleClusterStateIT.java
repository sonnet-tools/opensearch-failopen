import static org.hamcrest.Matchers.is;
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("foo"), is(false));
        assertThat(
            .clear()
        }
import java.util.concurrent.atomic.AtomicBoolean;
        } catch (IndexNotFoundException e) {
    }
            final IndexNameExpressionResolver expressionResolver,
        private final AtomicBoolean installed = new AtomicBoolean();
 * compatible open source license.
import org.opensearch.common.UUIDs;
 * the Apache License, Version 2.0 (the "License"); you may
            if (counter > estimatedBytesSize) {
        TestCustom(int value) {
            fail("Expected IndexNotFoundException");
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates("foo_template").get();
    @Before
        );
        @Override
    public void testRoutingTable() throws Exception {
                .get()
        );
                .setMetadata(true)
                .get();
            numberOfFields++;
        public Version getMinimalSupportedVersion() {
            final Supplier<RepositoriesService> repositoriesServiceSupplier
        final Map<String, IndexMetadata> metadata = clusterState.getState().getMetadata().indices();
    }
            .indices()
/**
            .setIndices(indices)
import org.opensearch.script.ScriptService;
        ClusterStateResponse clusterStateResponseUnfiltered = client().admin().cluster().prepareState().clear().setRoutingTable(true).get();
                                }
                    .field("store", false)
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    @Override
        assertThat(client().admin().cluster().prepareState().clear().setMetadata(false).get().getState().metadata().version(), equalTo(0L));
        @Override
        ClusterStateResponse clusterStateResponseUnfiltered = client().admin().cluster().prepareState().get();
        IndicesOptions allowNoIndices = IndicesOptions.fromOptions(false, true, true, false);
        // empty wildcard expansion throws exception when allowNoIndices is turned off
            new String[] { "*" },
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("fuu"), is(false));
                XContentFactory.jsonBuilder()
            .clear()
            greaterThanOrEqualTo(baselineVersion)
            mapping.startObject(UUIDs.randomBase64UUID()).field("type", "text").endObject();
    public void testLargeClusterStatePublishing() throws Exception {
        }
 *
 *
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .setIndices("f*")
            .setPatterns(Collections.singletonList("te*"))
                .setMapping(mapping)
            final Client client,
            .cluster()
                    .field("type", "text")
            .setOrder(1)
        assertThat(baselineVersion, greaterThan(0L));
            return Collections.emptyList();
                                @Override
            .setIndices("f*")
 * this file be licensed under the Apache-2.0 license or a
            return Version.CURRENT;
        testFilteringByIndexWorks(new String[] { "foo", "fuu", "non-existent" }, new String[] { "foo", "fuu" });
        }
        IndicesOptions allowNoIndices = IndicesOptions.fromOptions(false, true, true, false);
        testFilteringByIndexWorks(new String[] { "baz" }, new String[] { "baz" });
 * KIND, either express or implied.  See the License for the
            .get();
            return true;
            return readDiffFrom(ClusterState.Custom.class, "test", in);
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(0));
            entries.add(new NamedWriteableRegistry.Entry(ClusterState.Custom.class, "test", TestCustom::new));
import org.opensearch.core.common.unit.ByteSizeValue;
    }
import java.util.ArrayList;
            .get()
            client().admin().cluster().prepareState().setIndices("index-2").get().getState().metadata().version(),
        private final int value;
        testFilteringByIndexWorks(new String[] { "b*" }, new String[] { "baz" });
            greaterThanOrEqualTo(baselineVersion)
            new String[] { "f*", "b*" }
                                    throw new AssertionError(e);
            this.value = in.readInt();
                    .endObject()
     */
        RoutingTable routingTable = clusterState.getState().getRoutingTable();
import org.opensearch.env.Environment;
            client().admin().cluster().prepareState().setIndices("index-1").get().getState().metadata().version(),
 */
            .prepareGetMappings("test")
import org.opensearch.repositories.RepositoriesService;
                            clusterService.submitStateUpdateTask("install-metadata-custom", new ClusterStateUpdateTask(Priority.URGENT) {
            .prepareState()
                    .startObject()
                )
        client().admin()
                                        final ClusterState.Builder builder = ClusterState.builder(currentState);
    }
                        if (installed.compareAndSet(false, true)) {
                }
import org.opensearch.action.support.IndicesOptions;
        assertAcked(
        for (Client client : clients()) {
        ClusterStateResponse clusterStateResponseFiltered = client().admin().cluster().prepareState().clear().get();
                        .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
    }
        }
            .get();
            .cluster()
 * software distributed under the License is distributed on an
            .clear()
        assertThat(clusterStateResponse.getState().metadata().indices().isEmpty(), is(true));
    }
package org.opensearch.cluster;
import static org.hamcrest.Matchers.equalTo;
                .setTimeout("60s")
import org.opensearch.common.Priority;
            counter += 10; // each field is about 10 bytes, assuming compression in place
        MappingMetadata clusterManagerMappingMetadata = client().admin()
        } catch (IndexNotFoundException e) {
        }
 * under the License.
                .cluster()
                                        return builder.build();
            });
 * Licensed to Elasticsearch under one or more contributor
    public void indexData() throws Exception {
            .setMetadata(true)
        }
                .get()
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("baz"), is(false));
            return "test";
    protected boolean useRandomReplicationStrategy() {
            fail("Expected IndexNotFoundException");
     * that the cluster state returns coherent data for both routing table and metadata.
import org.opensearch.plugins.ClusterPlugin;
        ensureGreen(); // wait for green state, so its both green, and there are no more pending events
            assertThat(e.getMessage(), is("no such index [a*]"));
import org.opensearch.common.xcontent.XContentFactory;
            return entries;
        );
    }
                    .field("type", "keyword")
        public Collection<Object> createComponents(
import java.util.Collections;
        testFilteringByIndexWorks(randomIndices, new String[] { "foo", "fuu", "baz" });
                .indices()
            .prepareState()
    }
import org.opensearch.index.mapper.MapperService;
        ClusterStateResponse clusterStateResponseUnfiltered = client().admin().cluster().prepareState().clear().setMetadata(true).get();
            client().admin()
        assertThat(clusterStateResponseUnfiltered.getState().metadata().indices().size(), is(3));
        return true;
            .get();
        @Override
                    .endObject()
                    .field("store", true)
        mapping.endObject().endObject();
            assertThat(mappingMetadata.source().string(), equalTo(clusterManagerMappingMetadata.source().string()));
                    .endObject()
            .indices()
        refreshAndWaitForReplication();
            entries.add(new NamedWriteableRegistry.Entry(NamedDiff.class, "test", TestCustom::readDiffFrom));
            MappingMetadata mappingMetadata = client.admin()
        );
        assertBusy(() -> assertTrue(clusterService().state().customs().containsKey("test")));
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
import org.opensearch.test.OpenSearchIntegTestCase;
        clusterStateResponse = client().admin()
import org.opensearch.cluster.service.ClusterService;
        int estimatedBytesSize = scaledRandomIntBetween(
            final NamedWriteableRegistry namedWriteableRegistry,
            .setMapping(
import org.opensearch.core.common.Strings;
            .setRoutingTable(true)
            .cluster()
        public boolean isPrivate() {
                    .startObject("field1")
 */
        );
            .setMapping(
            clusterService.addListener(event -> {
    public void testPrivateCustomsAreExcluded() throws Exception {
        assertThat(clusterStateResponseFiltered.getState().nodes().getNodes().size(), is(0));
            .clear()
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("foo"), is(true));
        testFilteringByIndexWorks(new String[] { "*u" }, new String[] { "fuu" });
        // ignore_unavailable set to true should not raise exception on fzzbzz
        testFilteringByIndexWorks(new String[] { "f*" }, new String[] { "foo", "fuu" });
        }
        int numberOfFields = 0;
            .prepareState()
            )
        logger.info("number of fields [{}], estimated bytes [{}]", numberOfFields, estimatedBytesSize);
            assertThat(e.getMessage(), is("no such index [fzzbzz]"));
            .indices()
            final NamedXContentRegistry xContentRegistry,
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("non-existent"), is(false));
                .setIndicesOptions(allowNoIndices)
        TestCustom(StreamInput in) throws IOException {
    }
            .setPatterns(Collections.singletonList("test*"))
                                        return currentState;
        }
     * Retrieves the cluster state for the given indices and then checks
        assertThat(routingTable.indicesRouting().size(), is(expected.length));
 *
            Strings.EMPTY_ARRAY,
        assertThat(
            )
            .setIndicesOptions(ignoreUnavailabe)
                    .startObject("field2")
            .get();
                .prepareGetMappings("test")
import java.util.List;
        }
            .setIndices("a*")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(
    public void testIndicesOptions() throws Exception {
 *
            new String[] { Metadata.ALL },
import org.opensearch.plugins.Plugin;
            .cluster()
            assertThat(mappingMetadata, equalTo(clusterManagerMappingMetadata));
 * SPDX-License-Identifier: Apache-2.0
        assertIndexTemplateExists(getIndexTemplatesResponse, "foo_template");
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("properties");
 *    http://www.apache.org/licenses/LICENSE-2.0
        public void writeTo(StreamOutput out) throws IOException {
        index("baz", "baz", "1", XContentFactory.jsonBuilder().startObject().field("baz", "baz").endObject());
/*
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.Version;
    public static class PrivateCustomPlugin extends Plugin implements ClusterPlugin {
        assertThat(clusterStateResponse.getState().nodes().getNodes().size(), is(cluster().size()));
                .get("test");
        @Override
            .get("test");
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            .setMetadata(true)
import org.opensearch.core.xcontent.NamedXContentRegistry;
                .setIndices("fzzbzz")
/*
                if (state.nodes().isLocalNodeElectedClusterManager()) {
        assertThat(clusterStateResponse.getState().metadata().index("fuu").getState(), equalTo(IndexMetadata.State.CLOSE));
import org.opensearch.cluster.routing.RoutingTable;
        for (final String expectedIndex : expected) {
        public String getWriteableName() {
            .setMetadata(true)
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().setCustoms(true).get();
                XContentFactory.jsonBuilder()
        assertFalse(clusterStateResponse.getState().customs().containsKey("test"));
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
        IndicesOptions ignoreUnavailabe = IndicesOptions.fromOptions(true, true, true, false);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    .field("store", true)
        // expand_wildcards_closed should toggle return only closed index fuu
 * GitHub history for details.
                .getMappings()
            .setIndicesOptions(expandCloseOptions)
    public void testNodes() throws Exception {
        index("fuu", "buu", "1", XContentFactory.jsonBuilder().startObject().field("fuu", "fuu").endObject());
            }
                    .endObject()
                break;
    @Override
                    if (state.custom("test") == null) {
        index("foo", "bar", "1", XContentFactory.jsonBuilder().startObject().field("foo", "foo").endObject());
            final Environment environment,
        static NamedDiff<ClusterState.Custom> readDiffFrom(StreamInput in) throws IOException {
                .prepareCreate("test")
        createIndex("index-1");
import java.util.Map;
        // ensure that the custom is injected into the cluster state
import java.util.Collection;
}
    private void testFilteringByIndexWorks(String[] indices, String[] expected) {
        public PrivateCustomPlugin() {}
                final ClusterState state = event.state();
        client().admin().indices().close(Requests.closeIndexRequest("fuu")).get();
            greaterThanOrEqualTo(baselineVersion)
            .get();
        long baselineVersion = client().admin().cluster().prepareState().get().getState().metadata().version();
                .indices()
    }
                    return;
import org.opensearch.cluster.metadata.IndexMetadata;
            .preparePutTemplate("fuu_template")
        @Override
        ClusterStateResponse clusterStateResponse = client().admin()
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(2));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * ownership. Elasticsearch licenses this file to you under
    /**
        clusterStateResponse = client().admin()
            client().admin().cluster().prepareState().clear().setMetadata(true).setIndices("a*").setIndicesOptions(allowNoIndices).get();
        client().admin()
/*
        }
                                @Override
        createIndex("index-2");
        try {
            .preparePutTemplate("foo_template")
        try {
    public void testIndexTemplates() throws Exception {
        int numberOfShards = scaledRandomIntBetween(1, cluster().numDataNodes());
        assertThat(clusterStateResponse.getState().metadata().indices().isEmpty(), is(true));
    }
            .setMetadata(true)
            .setIndices("fzzbzz")
        // empty wildcard expansion result should work when allowNoIndices is
            .prepareState()
                    .startObject()
        }
                                    } else {
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("baz"), is(true));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;
                                    }
            assertThat(routingTable.hasIndex(expectedIndex), is(true));
 * Checking simple filtering capabilities of the cluster state
        return Collections.singletonList(PrivateCustomPlugin.class);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .get();
                        }
            .getMappings()
            client().admin().cluster().prepareState().setIndices("*").get().getState().metadata().version(),
            final ScriptService scriptService,
        );
import org.opensearch.transport.client.Requests;
            ByteSizeValue.parseBytesSizeValue("256k", "estimatedBytesSize").bytesAsInt()
        ) {
        }
        while (true) {
        }
    public void testMetadata() throws Exception {
        IndicesOptions expandCloseOptions = IndicesOptions.fromOptions(false, true, false, true);
            final NodeEnvironment nodeEnvironment,
import org.opensearch.env.NodeEnvironment;
 * Unless required by applicable law or agreed to in writing,
        // if the create index is ack'ed, then all nodes have successfully processed the cluster state
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
            assertThat(metadata, hasKey(expectedIndex));
import org.opensearch.cluster.metadata.MappingMetadata;
            client().admin().cluster().prepareState().setIndices("not-found").get().getState().metadata().version(),
        );
import static org.hamcrest.Matchers.greaterThan;
import org.junit.Before;
            client().admin()
                                    if (currentState.custom("test") == null) {
    public void testIndicesOptionsOnAllowNoIndicesFalse() throws Exception {
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().get();
import org.opensearch.transport.client.Client;
            return builder;
        @Override
                    Settings.builder()
                    .endObject()
public class SimpleClusterStateIT extends OpenSearchIntegTestCase {
                    .endObject()
    }
            .clear()
            .setIndicesOptions(allowNoIndices)
            out.writeInt(value);
                                        builder.putCustom("test", new TestCustom(42));
    public void testMetadataVersion() {
                    .startObject("field2")
                                public void onFailure(String source, Exception e) {
            .cluster()
            final ResourceWatcherService resourceWatcherService,
 */
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
                                public ClusterState execute(ClusterState currentState) {
                    .endObject()
import static org.hamcrest.Matchers.hasKey;
            .setOrder(0)
            this.value = value;
        assertThat(metadata.size(), is(expected.length));
        public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
            final ClusterService clusterService,
        assertThat(
            ByteSizeValue.parseBytesSizeValue("10k", "estimatedBytesSize").bytesAsInt(),
import org.opensearch.common.settings.Settings;
                                }
        clusterStateResponse = client().admin()
    private static class TestCustom extends AbstractNamedDiffable<ClusterState.Custom> implements ClusterState.Custom {
        }
 * You may obtain a copy of the License at
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
        // turned on
                .setLocal(true)
        // ignore_unavailable set to false throws exception when allowNoIndices is turned off
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("fuu"), is(true));
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(1));
                    .startObject("properties")
                .setSettings(
        IndicesOptions allowNoIndices = IndicesOptions.fromOptions(false, false, true, false);
                    .field("type", "text")
                }
import java.util.function.Supplier;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
 * license agreements. See the NOTICE file distributed with
                    .startObject("properties")
        @Override
        ClusterStateResponse clusterState = client().admin()
import org.opensearch.watcher.ResourceWatcherService;
    }
                .prepareState()
import org.opensearch.cluster.metadata.Metadata;
            greaterThanOrEqualTo(baselineVersion)
            final ThreadPool threadPool,
    }
        }
        assertThat(clusterStateResponse.getState().metadata().index("foo").getState(), equalTo(IndexMetadata.State.OPEN));
    }
    public void testIndicesIgnoreUnavailableFalse() throws Exception {
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("non-existent"), is(false));
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().setNodes(true).get();
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(1));
                            });
        // close one index
                if (state.getBlocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK)) {
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentBuilder;
        String[] randomIndices = randomFrom(
        int counter = 0;
            List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
        ensureGreen("fuu");
    public void testThatFilteringByIndexWorksForMetadataAndRoutingTable() throws Exception {
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().get();
                    }
import java.io.IOException;
            .prepareState()
            .setMetadata(true)
            .get();
                .clear()
        clusterStateResponse = client().admin().cluster().prepareState().clear().setMetadata(true).setIndices("f*").get();
        assertThat(clusterStateResponseUnfiltered.getState().metadata().templates().size(), is(greaterThanOrEqualTo(2)));
