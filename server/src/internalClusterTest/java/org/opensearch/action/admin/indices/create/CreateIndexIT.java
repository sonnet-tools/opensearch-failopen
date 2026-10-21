                new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L)
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS;
    public void testCreateIndexWithMetadataBlocks() {
            fail("should have thrown an exception about private settings");
}
import org.opensearch.cluster.metadata.IndexMetadata;
            assertEquals(indexName, indexService.index().getName());
        assertEquals("Should have index name in response", "foo", response.index());
                    .field("type", "date")
            prepareCreate("test").setSettings(Settings.builder().put("index.unknown.value", "this must fail").build()).get();
            () -> internalCluster().getInstance(ClusterService.class).state()
    public void testCreationDateGenerated() {
                    .startObject()
            client().admin().indices().prepareCreate("test-idx-2").setSettings(settings).setTimeout("100ms").get().isShardsAcknowledged()
import org.opensearch.OpenSearchParseException;
        GetMappingsResponse response = client().admin().indices().prepareGetMappings("test").get();
            } catch (IndexNotFoundException inf) {
            fail("should have thrown an exception about the primary shard count");
            () -> prepareCreate("test").setMapping(XContentFactory.jsonBuilder().startObject().startObject("type2").endObject().endObject())
        long timeBeforeRequest = System.currentTimeMillis();
            prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_INDEX_UUID, "uuid").build()).get();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.applicationtemplates.TemplateRepositoryMetadata;
 * specific language governing permissions and limitations
 *
                };
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), (String) null)
        Settings settings = Settings.builder()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS.substring(IndexMetadata.INDEX_SETTING_PREFIX.length()), value)
    }
        for (IndexService indexService : indicesService) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            ).get();
        assertTrue(mappings.sourceAsMap().isEmpty());
        );
            fail("should have thrown an exception about the replica shard count");
    }
 * The OpenSearch Contributors require contributions made to
        try {
    }
import org.opensearch.test.OpenSearchIntegTestCase;
/*
        );
            );
        value = randomIntBetween(-10, -1);
        }
import java.util.Map;
        ClusterState state = response.getState();
        assertThat(metadata, notNullValue());
                latch.countDown();
 * Licensed to Elasticsearch under one or more contributor
            + "  },\n"
            + "    }\n"
            )
        // the numeric equivalent of all should also fail
        } catch (IllegalArgumentException e) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                    + " breaking changes documentation for removed settings",
        try {
import org.opensearch.cluster.service.ClusterService;
        // crazy exceptions
        assertNotNull(mappings);
                XContentFactory.jsonBuilder()
package org.opensearch.action.admin.indices.create;
        assertAcked(
            + "  \"_meta\": {\n"
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_replicas] must be >= 0", e.getMessage());
 * GitHub history for details.
    public void testInvalidPartitionSize() {
            }
        assertNotNull(mappings);
                            // from here on all docs with index_version == 0|1 must be gone!!!! only 2 are ok;
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_replicas] must be >= 0", e.getMessage());
                .prepareCreate("test-idx-1")
        );
                                // we increment the index version otherwise a doc that is in-flight could make it into an index that it
            fail("should have thrown an exception about the shard count");
                                // was supposed to be deleted for and our assertion fail...
                SystemTemplateMetadata.fromComponentTemplateInfo("test", 1L),
        GetMappingsResponse response = client().admin().indices().prepareGetMappings("test").get();
                    Settings.builder()
                .setPersistentSettings(Settings.builder().put("cluster.default_number_of_replicas", numReplicas).build())
import org.opensearch.index.mapper.MapperService;
        assertFalse(mappings.sourceAsMap().isEmpty());
    }
 * not use this file except in compliance with the License.
        assertAcked(
    /**
                    @Override
/*
                (int) indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, null)
    public void testInvalidShardCountSettingsWithoutPrefix() throws Exception {
                        .put("index.routing_partition_size", partitionSize)
            + "  \"template\": {\n"
    }
 * this work for additional information regarding copyright
    public void testCreateIndexWithNullReplicaCountPickUpClusterReplica() {
 * SPDX-License-Identifier: Apache-2.0
                "Failed to parse mapping [" + MapperService.SINGLE_MAPPING_NAME + "]: Root mapping definition has unsupported parameters"
        }
        prepareCreate("test").get();
                        try {
            }
     * This test ensures that index creation adheres to the {@link IndexMetadata#SETTING_WAIT_FOR_ACTIVE_SHARDS}.
            assertBlocked(prepareCreate("test"));
import static org.hamcrest.Matchers.not;
        String templateContent = "{\n"
        } catch (IllegalArgumentException e) {
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.support.IndicesOptions;
        final int numReplicas = internalCluster().numDataNodes();
        disableIndexBlock("test", IndexMetadata.SETTING_BLOCKS_METADATA);
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
    }
                numReplicas,
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, internalCluster().getClusterManagerName());
        }
import org.opensearch.index.query.RangeQueryBuilder;
import static org.hamcrest.core.IsNull.notNullValue;
 * compatible open source license.
        assertAcked(client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get());
        OpenSearchParseException e = expectThrows(
import org.opensearch.common.unit.TimeValue;
    }
                    .endObject()
                Settings.builder()
        }
        BiFunction<Integer, Integer, Boolean> createPartitionedIndex = (shards, partitionSize) -> {
        final AtomicInteger indexVersion = new AtomicInteger(0);
 *
    public void testUnknownSettingFails() {
    }
        loader.loadTemplate(
        assertTrue(mappings.sourceAsMap().isEmpty());
    }
                            synchronized (indexVersionLock) {
        int numDocs = randomIntBetween(1, 10);
        } catch (IllegalArgumentException e) {
import org.opensearch.indices.IndicesService;
        assertAcked(
            .put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), Integer.toString(numReplicas))
        try {
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
    public void testCreateAndDeleteIndexConcurrently() throws InterruptedException {
                            client().prepareIndex("test").setSource("index_version", indexVersion.get()).get();
        String indexName = "test-idx-1";
        Settings settings = Settings.builder()
        long timeAfterRequest = System.currentTimeMillis();
 * under the License.
            );
            OpenSearchParseException.class,
                .prepareUpdateSettings()
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
    }
        int value = randomIntBetween(-10, 0);
        try {
        assertAcked(prepareCreate("test").setMapping(XContentFactory.jsonBuilder().startObject().endObject()));
                ).execute().actionGet();
            setClusterReadOnly(false);
                deleteFailure.set(e);
                Thread thread = new Thread() {
    }
                response = prepareCreate("test_" + shards + "_" + partitionSize).setSettings(
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), (String) null)
                return false;
        assertTrue(createPartitionedIndex.apply(3, 1));
            } catch (IllegalStateException | IllegalArgumentException e) {
        );
                            latch.countDown();
            } catch (UnavailableShardsException ex) {
                        }
                    .build()
            );
        MapperParsingException e = expectThrows(
        Metadata metadata = state.getMetadata();
        }
            prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, value).build()).get();
import org.opensearch.index.mapper.MapperParsingException;
            client().admin().indices().prepareCreate("test-idx-3").setSettings(settings).setTimeout("100ms").get().isShardsAcknowledged()
import org.opensearch.core.common.bytes.BytesReference;
                    .startObject("properties")
        assertNotNull(mappings);
        } finally {
        ensureGreen("test");
            prepareCreate("test").setSettings(
        // all should fail
                thread.start();
                }
        assertFalse(createPartitionedIndex.apply(3, 0));
        int numReplicas = 3;
        assertThat(index.getCreationDate(), allOf(lessThanOrEqualTo(timeAfterRequest), greaterThanOrEqualTo(timeBeforeRequest)));
        final CountDownLatch latch = new CountDownLatch(1);
        latch.await();
        }
            startsWith(
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertAcked(client().admin().indices().prepareCreate(indexName).setSettings(settings).get());
            () -> request.source("{\"mappings\": \"{}\"}", MediaTypeRegistry.JSON)
import static org.hamcrest.Matchers.startsWith;
        int value = randomIntBetween(-10, 0);
            return response.isAcknowledged();
                            }
 */
                        .put("index.number_of_routing_shards", shards)
        );
        settings = Settings.builder().put(settings).put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), Integer.toString(numReplicas + 1)).build();
        assertFalse(
import org.opensearch.action.admin.indices.alias.Alias;
                Settings.builder()
        }
                .get()
        CreateIndexResponse response = prepareCreate("foo").setSettings(Settings.builder().build()).get();
    }
        String indexName = "test-idx-1";
            assertEquals(
        int numReplicas = 1;
        assertThat(index, notNullValue());
            + "    \"_version\": 1\n"
                "unknown setting [index.unknown.value] please check that any required plugins are installed, or check the"
                .addAlias(new Alias("alias1").writeIndex(true))
        value = randomIntBetween(-10, -1);
    public void testCreateIndexWithMappingsAsString() {
                synchronized (indexVersionLock) {
 * software distributed under the License is distributed on an
            fail("should have thrown an exception about the shard count");
            assertEquals("log_byte_size", indexService.getMetadata().getSettings().get(IndexSettings.INDEX_MERGE_POLICY.getKey()));
                .cluster()
        assertEquals("key [mappings] must be an object", e.getMessage());
    public void testFailureToCreateIndexCleansUpIndicesService() {
        try {
 * KIND, either express or implied.  See the License for the
        }
                    .endObject()
            .cluster()
        } catch (SettingsException e) {
        }
                .indices()
import java.nio.charset.StandardCharsets;
                                indexVersion.incrementAndGet();
                    public void run() {
        assertEquals(expected + " vs. " + all, expected.getHits().getTotalHits().value(), all.getHits().getTotalHits().value());
        CreateIndexRequest request = new CreateIndexRequest("test");
            }
        );
        // we only really assert that we never reuse segments of old indices or anything like this here and that nothing fails with
    }
import org.opensearch.index.IndexSettings;
            .build();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
import static org.hamcrest.Matchers.equalTo;
 *    http://www.apache.org/licenses/LICENSE-2.0
        Settings settings = Settings.builder()
import org.opensearch.cluster.ClusterState;
        });
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        ClusterStateResponse response = client().admin().cluster().prepareState().get();
    }
        } catch (IllegalArgumentException e) {
                assertEquals(ex.getCause().getClass(), IndexNotFoundException.class);
                    .startObject("date")
        refresh();
        }
            CreateIndexResponse response;
import org.opensearch.common.settings.Settings;
            @Override
        }
 * ownership. Elasticsearch licenses this file to you under
        assertThat(indices.size(), equalTo(1));
            .get();
        } catch (IllegalArgumentException e) {
        internalCluster().fullRestart();
import org.opensearch.cluster.applicationtemplates.SystemTemplate;
            assertTrue(e.getMessage().contains("private index setting [index.uuid] can not be set explicitly"));
            IllegalStateException.class
    public void testCreateIndexWithBlocks() {
        for (int i = 0; i < numDocs; i++) {
        assertFalse(
                .setSettings(settings)
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
                            // recreate that index
                (int) indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, null)
                numReplicas,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testMappingParamAndNestedMismatch() throws Exception {
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_shards] must be >= 1", e.getMessage());
        GetMappingsResponse response = client().admin().indices().prepareGetMappings("test").get();
            )
            assertThat(indexService.index().getName(), not("test-idx-2"));
        client().admin()
                        .setSource("index_version", indexVersion.get())
            prepareCreate("test").setMapping(XContentFactory.jsonBuilder().startObject().startObject("_doc").endObject().endObject())
                .get()
public class CreateIndexIT extends OpenSearchIntegTestCase {
     */
        assertThat(indices, notNullValue());
    }
                    .endObject()
 * You may obtain a copy of the License at
        Context context = new Context("test");
        for (IndexService indexService : indicesService) {
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.index.IndexNotFoundException;
            prepareCreate("test").setSettings(
                    }
        createIndex("test");
        }
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
    public void testIndexNameInResponse() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertBlocked(client().admin().indices().prepareGetSettings("test"), IndexMetadata.INDEX_METADATA_BLOCK);
            }
            ).get();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                // fine we run into a delete index while retrying
            .build();
        ClusterStateSystemTemplateLoader loader = new ClusterStateSystemTemplateLoader(
        client().admin().indices().prepareCreate("test").setWaitForActiveShards(ActiveShardCount.NONE).setSettings(indexSettings()).get();
import org.opensearch.cluster.metadata.Context;
            internalCluster().clusterManagerClient(),
            + "}\n";
            + "    \"settings\": {\n"
        );
            + "  },\n"
                            assertAcked(client().admin().indices().prepareDelete("test").get());
        MappingMetadata mappings = response.mappings().get("test");
    public void testPrivateSettingFails() {
        for (int i = 0; i < numDocs; i++) {
        final AtomicReference<Exception> deleteFailure = new AtomicReference<>();
        assertTrue(createPartitionedIndex.apply(3, 2));
            + "  \"version\": 1\n"
        SearchResponse all = client().prepareSearch("test").setIndicesOptions(IndicesOptions.lenientExpandOpen()).get();
import org.opensearch.index.IndexService;
    }
            prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, value).build()).get();
import org.opensearch.cluster.metadata.MappingMetadata;
        Settings settings = Settings.builder()
                    .build()
            assertEquals(context, indexService.getMetadata().context());
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import java.util.concurrent.CountDownLatch;
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
import java.util.concurrent.atomic.AtomicReference;
            .build();
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;
import org.opensearch.action.UnavailableShardsException;
            prepareCreate("test").setMapping(
            client().admin()
            + "      \"merge.policy\": \"log_byte_size\"\n"
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.enable", "none"))
 */
    public void testDefaultWaitForActiveShardsUsesIndexSetting() throws Exception {
            MapperParsingException.class,
        final Map<String, IndexMetadata> indices = metadata.getIndices();
    public void testCreateIndexWithContextSettingsAndTemplate() throws Exception {
        final int numReplicas = internalCluster().numDataNodes();
        assertThat(
 * Unless required by applicable law or agreed to in writing,
        MappingMetadata mappings = response.mappings().get("test");
            client().admin().indices().prepareCreate("test-idx-2").setSettings(settings).addAlias(new Alias("alias1").writeIndex(true)),
        try {
        MappingMetadata mappings = response.mappings().get("test");
        };
            fail("should have thrown an exception about the shard count");
        );
import java.util.function.BiFunction;
    public void testNonNestedMappings() throws Exception {
import java.util.UUID;
import org.opensearch.common.settings.SettingsException;
        IndexMetadata index = indices.get("test");
        client().admin().indices().prepareDelete("test").execute(new ActionListener<AcknowledgedResponse>() { // this happens async!!!
                        } finally {
                e.getMessage()
            public void onResponse(AcknowledgedResponse deleteIndexResponse) {
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_BLOCKS_METADATA, true)));
            @Override
                BytesReference.fromByteBuffer(ByteBuffer.wrap(templateContent.getBytes(StandardCharsets.UTF_8))),
            new SystemTemplate(
import org.opensearch.action.search.SearchResponse;
import org.opensearch.core.action.ActionListener;
    }
import java.util.concurrent.atomic.AtomicInteger;
            assertEquals(
 * Modifications Copyright OpenSearch Contributors. See
            .setQuery(new RangeQueryBuilder("index_version").from(indexVersion.get(), true))
 * this file be licensed under the Apache-2.0 license or a
            .build();
                        .put("index.number_of_shards", shards)
    public void testInvalidShardCountSettings() throws Exception {
        assertTrue(createPartitionedIndex.apply(1, 1));
                .get()
    }
            client().prepareIndex("test").setSource("index_version", indexVersion.get()).get();
            try {
        settings = Settings.builder().put(settings).put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "all").build();
        assertAcked(
            client().admin()
        assertFalse(createPartitionedIndex.apply(3, 3));
        );
        logger.info("total: {}", expected.getHits().getTotalHits().value());
    }
        assertAcked(client().admin().indices().prepareCreate(indexName).setSettings(settings).setContext(context).get());
 * the Apache License, Version 2.0 (the "License"); you may
            indexVersion.incrementAndGet();
                // fine
        assertThat(state, notNullValue());
import static org.hamcrest.Matchers.allOf;
            .get();
import java.nio.ByteBuffer;
                        .setTimeout(TimeValue.timeValueSeconds(10))
            .prepareUpdateSettings()
        numDocs = randomIntBetween(100, 200);
        for (IndexService indexService : indicesService) {
        assertFalse(createPartitionedIndex.apply(3, 6));
/*
            public void onFailure(Exception e) {
            try {
        final Object indexVersionLock = new Object();
            + "    \"_type\": \"@abc_template\",\n"
                        .get();
                    client().prepareIndex("test")
 */
            assertEquals(
    public void testRestartIndexCreationAfterFullClusterRestart() throws Exception {
        );
        try {
    public void testEmptyMappings() throws Exception {
        SearchResponse expected = client().prepareSearch("test")
        );
 *
        assertNull(deleteFailure.get());
            e.getMessage(),
            )
        );
import org.opensearch.action.support.ActiveShardCount;
            setClusterReadOnly(true);
        assertRequestBuilderThrows(
    public void testEmptyNestedMappings() throws Exception {
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, internalCluster().getClusterManagerName());
                                // we sync here since we have to ensure that all indexing operations below for a given ID are done before
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_shards] must be >= 1", e.getMessage());
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS.substring(IndexMetadata.INDEX_SETTING_PREFIX.length()), value)
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, internalCluster().getClusterManagerName());
@ClusterScope(scope = Scope.TEST)
            assertEquals(indexName, indexService.index().getName());
        synchronized (indexVersionLock) { // not necessarily needed here but for completeness we lock here too
