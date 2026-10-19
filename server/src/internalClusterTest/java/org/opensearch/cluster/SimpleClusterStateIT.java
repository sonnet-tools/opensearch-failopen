            return "test";  
        }
/*  
                .setLocal(true)
        client().admin()
            client().admin().cluster().prepareState().setIndices("not-found").get().getState().metadata().version(),
    }
        @Override
            }  
        // close one index
            assertThat(e.getMessage(), is("no such index [fzzbzz]"));
        ClusterStateResponse clusterStateResponseUnfiltered = client().admin().cluster().prepareState().get();  
                    .endObject()  
            return true;  
import java.util.ArrayList;
                    .startObject()
            .setIndicesOptions(ignoreUnavailabe)
 * Checking simple filtering capabilities of the cluster state
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(1));
        assertFalse(clusterStateResponse.getState().customs().containsKey("test"));
        IndicesOptions allowNoIndices = IndicesOptions.fromOptions(false, true, true, false);
        testFilteringByIndexWorks(randomIndices, new String[] { "foo", "fuu", "baz" });
        // empty wildcard expansion throws exception when allowNoIndices is turned off
        @Override
    }  
            .cluster()
                )
            final ResourceWatcherService resourceWatcherService,
                                    if (currentState.custom("test") == null) {  
        public boolean isPrivate() {
        ensureGreen("fuu");
        index("fuu", "buu", "1", XContentFactory.jsonBuilder().startObject().field("fuu", "fuu").endObject());
            .setIndices("fzzbzz")  
        @Override
import org.opensearch.index.mapper.MapperService;
/**
                    .field("store", false)
                    return;
        // empty wildcard expansion result should work when allowNoIndices is
        testFilteringByIndexWorks(new String[] { "f*" }, new String[] { "foo", "fuu" });
            client().admin().cluster().prepareState().clear().setMetadata(true).setIndices("a*").setIndicesOptions(allowNoIndices).get();
        testFilteringByIndexWorks(new String[] { "foo", "fuu", "non-existent" }, new String[] { "foo", "fuu" });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.service.ClusterService;
        @Override
            assertThat(routingTable.hasIndex(expectedIndex), is(true));  
        clusterStateResponse = client().admin().cluster().prepareState().clear().setMetadata(true).setIndices("f*").get();  
        try {
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("non-existent"), is(false));  
        IndicesOptions allowNoIndices = IndicesOptions.fromOptions(false, false, true, false);  
 * You may obtain a copy of the License at  
        }
                .setIndicesOptions(allowNoIndices)
    }
            assertThat(e.getMessage(), is("no such index [a*]"));
        public String getWriteableName() {
            .indices()
    }
        private final int value;  
            .setIndices("f*")
                                    }  
                .setMapping(mapping)
        String[] randomIndices = randomFrom(
                    .endObject()
    public void testNodes() throws Exception {  
        int numberOfShards = scaledRandomIntBetween(1, cluster().numDataNodes());
        testFilteringByIndexWorks(new String[] { "baz" }, new String[] { "baz" });  
            .setPatterns(Collections.singletonList("te*"))
    public void indexData() throws Exception {  
    public void testRoutingTable() throws Exception {
        }  
        @Override  
        client().admin()  
    @Override  
            final ScriptService scriptService,  
        int numberOfFields = 0;
            final ThreadPool threadPool,
                .setTimeout("60s")  
                    .startObject("properties")
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("properties");  
            greaterThanOrEqualTo(baselineVersion)
import org.opensearch.env.NodeEnvironment;
        int estimatedBytesSize = scaledRandomIntBetween(
            client().admin()
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            client().admin().cluster().prepareState().setIndices("index-2").get().getState().metadata().version(),
            .prepareGetMappings("test")  
        testFilteringByIndexWorks(new String[] { "b*" }, new String[] { "baz" });
            .setIndicesOptions(allowNoIndices)
                            clusterService.submitStateUpdateTask("install-metadata-custom", new ClusterStateUpdateTask(Priority.URGENT) {
            greaterThanOrEqualTo(baselineVersion)  
            .get("test");  
    }
 * this file be licensed under the Apache-2.0 license or a
            final NamedXContentRegistry xContentRegistry,
/*
        assertThat(metadata.size(), is(expected.length));
        IndicesOptions ignoreUnavailabe = IndicesOptions.fromOptions(true, true, true, false);  
            this.value = in.readInt();
        assertThat(baselineVersion, greaterThan(0L));
    }
            .prepareState()
                                }
                        .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)  
    @Before
        }
                .prepareCreate("test")
            .preparePutTemplate("fuu_template")
        }  
                                        return currentState;
 * The OpenSearch Contributors require contributions made to  
            final Environment environment,
 * Licensed to Elasticsearch under one or more contributor  
            final Client client,
            .setMapping(
        IndicesOptions allowNoIndices = IndicesOptions.fromOptions(false, true, true, false);
                    .endObject()  
import org.junit.Before;
    private static class TestCustom extends AbstractNamedDiffable<ClusterState.Custom> implements ClusterState.Custom {
            return Collections.emptyList();
            greaterThanOrEqualTo(baselineVersion)
            .setIndices("f*")
     * that the cluster state returns coherent data for both routing table and metadata.
 * license agreements. See the NOTICE file distributed with
        RoutingTable routingTable = clusterState.getState().getRoutingTable();
import org.opensearch.Version;
        // ensure that the custom is injected into the cluster state
                    .field("type", "keyword")
                if (state.getBlocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK)) {
        clusterStateResponse = client().admin()  
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().setNodes(true).get();
        int counter = 0;
                    .field("type", "text")  
            return builder;  
                            });
import org.opensearch.watcher.ResourceWatcherService;
        for (Client client : clients()) {
            entries.add(new NamedWriteableRegistry.Entry(ClusterState.Custom.class, "test", TestCustom::new));
                .getMappings()
        return Collections.singletonList(PrivateCustomPlugin.class);  
        testFilteringByIndexWorks(new String[] { "*u" }, new String[] { "fuu" });  
                    .field("type", "text")
        public List<NamedWriteableRegistry.Entry> getNamedWriteables() {  
        public void writeTo(StreamOutput out) throws IOException {  
            .prepareState()  
                                        final ClusterState.Builder builder = ClusterState.builder(currentState);
import org.opensearch.core.common.io.stream.StreamInput;
                XContentFactory.jsonBuilder()  
            final Supplier<RepositoriesService> repositoriesServiceSupplier  
            assertThat(mappingMetadata.source().string(), equalTo(clusterManagerMappingMetadata.source().string()));  
                .setMetadata(true)
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("fuu"), is(false));
            .setIndices(indices)
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("foo"), is(true));  
    /**
import org.opensearch.core.xcontent.XContentBuilder;  
 *  
        assertThat(clusterStateResponse.getState().metadata().index("fuu").getState(), equalTo(IndexMetadata.State.CLOSE));  
 *  
        mapping.endObject().endObject();  
            if (counter > estimatedBytesSize) {
 * compatible open source license.
            .get();  
            MappingMetadata mappingMetadata = client.admin()
        assertThat(
            .setOrder(1)
import org.opensearch.core.common.Strings;  
import org.opensearch.core.common.unit.ByteSizeValue;
        try {  
            .get();
import org.opensearch.repositories.RepositoriesService;
    public void testMetadata() throws Exception {
        client().admin().indices().close(Requests.closeIndexRequest("fuu")).get();
                    .startObject("field2")  
                    Settings.builder()  
            .getMappings()
            .cluster()
            client().admin()
    }  
            .setPatterns(Collections.singletonList("test*"))  
    }  
                .indices()  
        public PrivateCustomPlugin() {}  
    }
        // turned on  
/*  
import java.util.Collections;
        }
            .setMetadata(true)
            this.value = value;  
        assertThat(  
        assertThat(client().admin().cluster().prepareState().clear().setMetadata(false).get().getState().metadata().version(), equalTo(0L));
                .prepareState()  
    public void testPrivateCustomsAreExcluded() throws Exception {  
import org.opensearch.test.OpenSearchIntegTestCase;  
    public void testIndicesOptionsOnAllowNoIndicesFalse() throws Exception {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
            clusterService.addListener(event -> {
 */  
        createIndex("index-1");
        }  
        ClusterStateResponse clusterStateResponseFiltered = client().admin().cluster().prepareState().clear().get();
    }
        @Override
                final ClusterState state = event.state();  
                    .endObject()
            .prepareState()  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            final ClusterService clusterService,  
        }
        );
 * SPDX-License-Identifier: Apache-2.0
    }
        TestCustom(int value) {
            counter += 10; // each field is about 10 bytes, assuming compression in place
    public void testIndicesOptions() throws Exception {
            ByteSizeValue.parseBytesSizeValue("10k", "estimatedBytesSize").bytesAsInt(),  
                    .field("store", true)
            assertThat(mappingMetadata, equalTo(clusterManagerMappingMetadata));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;  
    public void testIndicesIgnoreUnavailableFalse() throws Exception {  
                }  
        );
            .cluster()  
            client().admin().cluster().prepareState().setIndices("index-1").get().getState().metadata().version(),
        private final AtomicBoolean installed = new AtomicBoolean();
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.concurrent.atomic.AtomicBoolean;
        }
import org.opensearch.transport.client.Requests;  
                    .endObject()
        static NamedDiff<ClusterState.Custom> readDiffFrom(StreamInput in) throws IOException {  
            return Version.CURRENT;
import org.opensearch.plugins.ClusterPlugin;
        assertThat(clusterStateResponse.getState().nodes().getNodes().size(), is(cluster().size()));
            ByteSizeValue.parseBytesSizeValue("256k", "estimatedBytesSize").bytesAsInt()
        logger.info("number of fields [{}], estimated bytes [{}]", numberOfFields, estimatedBytesSize);
    public void testIndexTemplates() throws Exception {
            .get();
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
import org.opensearch.index.IndexNotFoundException;  
        // expand_wildcards_closed should toggle return only closed index fuu
 */
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterStateResponse clusterStateResponseUnfiltered = client().admin().cluster().prepareState().clear().setMetadata(true).get();  
 * not use this file except in compliance with the License.
        while (true) {  
        @Override  
            final NodeEnvironment nodeEnvironment,  
        assertThat(clusterStateResponse.getState().metadata().indices().isEmpty(), is(true));  
        }
            .get();
        );
        assertThat(clusterStateResponse.getState().metadata().index("foo").getState(), equalTo(IndexMetadata.State.OPEN));
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates("foo_template").get();  
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(2));
            .setMetadata(true)
        // if the create index is ack'ed, then all nodes have successfully processed the cluster state  
            .setIndices("a*")
import static org.hamcrest.Matchers.equalTo;
 * under the License.  
                                @Override  
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().get();
package org.opensearch.cluster;
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(0));
    }  
        assertBusy(() -> assertTrue(clusterService().state().customs().containsKey("test")));
            .clear()
import static org.hamcrest.Matchers.greaterThan;
                                }  
                                        builder.putCustom("test", new TestCustom(42));
        public Version getMinimalSupportedVersion() {
                .cluster()
import java.io.IOException;
    }
    @Override
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("non-existent"), is(false));  
import org.opensearch.script.ScriptService;
import java.util.function.Supplier;
        return true;
    }
        } catch (IndexNotFoundException e) {
 * KIND, either express or implied.  See the License for the
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("baz"), is(true));
        ClusterStateResponse clusterState = client().admin()
            assertThat(metadata, hasKey(expectedIndex));
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        refreshAndWaitForReplication();
        } catch (IndexNotFoundException e) {
        );  
        );
                        }  
            .setOrder(0)  
        final Map<String, IndexMetadata> metadata = clusterState.getState().getMetadata().indices();
                    .startObject("field1")
            out.writeInt(value);
        }
 * software distributed under the License is distributed on an
            fail("Expected IndexNotFoundException");  
import static org.hamcrest.Matchers.hasKey;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        TestCustom(StreamInput in) throws IOException {  
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("baz"), is(false));
        );
                .get()  
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().get();  
            greaterThanOrEqualTo(baselineVersion)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertAcked(
            .indices()  
            )  
    public void testLargeClusterStatePublishing() throws Exception {
    }
            entries.add(new NamedWriteableRegistry.Entry(NamedDiff.class, "test", TestCustom::readDiffFrom));  
 *
        for (final String expectedIndex : expected) {
            fail("Expected IndexNotFoundException");  
    protected boolean useRandomReplicationStrategy() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                .get();
                    .endObject()
     */
            client().admin().cluster().prepareState().setIndices("*").get().getState().metadata().version(),  
        assertThat(clusterStateResponse.getState().metadata().indices().isEmpty(), is(true));
import java.util.Map;  
            .setMetadata(true)
                .clear()
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
                                @Override
import static org.hamcrest.Matchers.is;
        assertThat(clusterStateResponse.getState().metadata().indices().size(), is(1));
import org.opensearch.action.support.IndicesOptions;
                    .startObject("properties")
            .cluster()
        ) {
            });
    public void testThatFilteringByIndexWorksForMetadataAndRoutingTable() throws Exception {
            return readDiffFrom(ClusterState.Custom.class, "test", in);
        assertIndexTemplateExists(getIndexTemplatesResponse, "foo_template");
                .get()
        assertThat(clusterStateResponseUnfiltered.getState().metadata().indices().size(), is(3));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            mapping.startObject(UUIDs.randomBase64UUID()).field("type", "text").endObject();
            .get();
        MappingMetadata clusterManagerMappingMetadata = client().admin()
            .clear()
 * this work for additional information regarding copyright
            final IndexNameExpressionResolver expressionResolver,
        // ignore_unavailable set to false throws exception when allowNoIndices is turned off
        // ignore_unavailable set to true should not raise exception on fzzbzz
                    .field("store", true)
            final NamedWriteableRegistry namedWriteableRegistry,
        );  
                    .endObject()
            .setIndicesOptions(expandCloseOptions)  
        }
                                public void onFailure(String source, Exception e) {
        index("foo", "bar", "1", XContentFactory.jsonBuilder().startObject().field("foo", "foo").endObject());
            .get()
    private void testFilteringByIndexWorks(String[] indices, String[] expected) {  
                                    throw new AssertionError(e);
            .clear()  
                .setIndices("fzzbzz")  
 */
            )  
            Strings.EMPTY_ARRAY,
import org.opensearch.core.common.io.stream.StreamOutput;  
                XContentFactory.jsonBuilder()
        long baselineVersion = client().admin().cluster().prepareState().get().getState().metadata().version();
            List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
                    .startObject("field2")  
        clusterStateResponse = client().admin()
            .prepareState()
            .setRoutingTable(true)  
 * Modifications Copyright OpenSearch Contributors. See
        clusterStateResponse = client().admin()
        }
        }  
import org.opensearch.cluster.metadata.IndexMetadata;
            .prepareState()
                    }
        ClusterStateResponse clusterStateResponseUnfiltered = client().admin().cluster().prepareState().clear().setRoutingTable(true).get();
 * ownership. Elasticsearch licenses this file to you under  
                                        return builder.build();  
        assertThat(routingTable.indicesRouting().size(), is(expected.length));
            .get();  
import org.opensearch.common.xcontent.XContentFactory;
            .setMapping(
                    .startObject()  
        ensureGreen(); // wait for green state, so its both green, and there are no more pending events  
                if (state.nodes().isLocalNodeElectedClusterManager()) {
        assertThat(clusterStateResponseUnfiltered.getState().routingTable().hasIndex("fuu"), is(true));
            .setMetadata(true)  
                .get("test");
                .setSettings(
import org.opensearch.cluster.metadata.Metadata;
            return entries;
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().setCustoms(true).get();  
            .cluster()
    public static class PrivateCustomPlugin extends Plugin implements ClusterPlugin {
 * specific language governing permissions and limitations
 * GitHub history for details.
        createIndex("index-2");  
        assertThat(clusterStateResponseUnfiltered.getState().metadata().templates().size(), is(greaterThanOrEqualTo(2)));
import org.opensearch.cluster.metadata.MappingMetadata;
            new String[] { "f*", "b*" }  
        assertThat(  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.threadpool.ThreadPool;
            .get();
            .clear()  
            .clear()
 */  
            .indices()
            .preparePutTemplate("foo_template")
                .prepareGetMappings("test")
                .indices()  
 *
            new String[] { Metadata.ALL },
public class SimpleClusterStateIT extends OpenSearchIntegTestCase {
        assertThat(clusterStateResponse.getState().routingTable().hasIndex("foo"), is(false));  
    }
        assertThat(
    }
     * Retrieves the cluster state for the given indices and then checks  
            numberOfFields++;  
                }
                                    } else {
                break;
        index("baz", "baz", "1", XContentFactory.jsonBuilder().startObject().field("baz", "baz").endObject());  
import org.opensearch.common.Priority;
                                public ClusterState execute(ClusterState currentState) {
}
                        if (installed.compareAndSet(false, true)) {
import java.util.Collection;  
        public Collection<Object> createComponents(
import java.util.List;
                    if (state.custom("test") == null) {  
            new String[] { "*" },  
import org.opensearch.transport.client.Client;
import org.opensearch.plugins.Plugin;  
        ClusterStateResponse clusterStateResponse = client().admin()  
    public void testMetadataVersion() {
import org.opensearch.env.Environment;
import org.opensearch.cluster.routing.RoutingTable;  
        assertThat(clusterStateResponseFiltered.getState().nodes().getNodes().size(), is(0));
            .setMetadata(true)
        IndicesOptions expandCloseOptions = IndicesOptions.fromOptions(false, true, false, true);
        }
import org.opensearch.common.UUIDs;  
