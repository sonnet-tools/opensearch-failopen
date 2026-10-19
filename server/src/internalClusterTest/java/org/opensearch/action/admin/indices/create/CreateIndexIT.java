        settings = Settings.builder().put(settings).put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), Integer.toString(numReplicas + 1)).build();  
                .cluster()  
package org.opensearch.action.admin.indices.create;
            prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, value).build()).get();
            public void onResponse(AcknowledgedResponse deleteIndexResponse) {
        assertThat(index, notNullValue());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), Integer.toString(numReplicas))
            () -> request.source("{\"mappings\": \"{}\"}", MediaTypeRegistry.JSON)  
            .cluster()  
            fail("should have thrown an exception about the shard count");
        Settings settings = Settings.builder()
        );
        // crazy exceptions  
        assertNotNull(mappings);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
                        .put("index.routing_partition_size", partitionSize)  
            + "}\n";
    /**
                }
        try {
    public void testCreateIndexWithMetadataBlocks() {
    }
    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
                Settings.builder()
        });
        final Map<String, IndexMetadata> indices = metadata.getIndices();
        assertFalse(
    public void testMappingParamAndNestedMismatch() throws Exception {  
 */  
    }
        Context context = new Context("test");  
            + "    }\n"  
import org.opensearch.index.mapper.MapperService;
        assertFalse(
        logger.info("total: {}", expected.getHits().getTotalHits().value());
        );
                latch.countDown();  
        for (IndexService indexService : indicesService) {  
        int numDocs = randomIntBetween(1, 10);  
        assertAcked(client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get());  
                                indexVersion.incrementAndGet();  
                .get()  
        assertBlocked(client().admin().indices().prepareGetSettings("test"), IndexMetadata.INDEX_METADATA_BLOCK);
        );  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), (String) null)
            prepareCreate("test").setMapping(  
 * You may obtain a copy of the License at  
        } catch (IllegalArgumentException e) {
            fail("should have thrown an exception about private settings");  
    public void testCreateAndDeleteIndexConcurrently() throws InterruptedException {
            + "  \"version\": 1\n"  
        ensureGreen("test");  
            public void onFailure(Exception e) {
import org.opensearch.cluster.metadata.Context;  
            @Override  
            .build();
        String indexName = "test-idx-1";  
    }
                };
        try {
    }  
        disableIndexBlock("test", IndexMetadata.SETTING_BLOCKS_METADATA);
        );  
                    .build()
    public void testInvalidShardCountSettingsWithoutPrefix() throws Exception {  
    public void testInvalidShardCountSettings() throws Exception {
            .build();
        } catch (IllegalArgumentException e) {
    public void testNonNestedMappings() throws Exception {
            .build();
        final Object indexVersionLock = new Object();
        for (IndexService indexService : indicesService) {
                .prepareCreate("test-idx-1")  
        );
                    @Override  
        int value = randomIntBetween(-10, 0);  
 */  
            .build();
            prepareCreate("test").setSettings(Settings.builder().put("index.unknown.value", "this must fail").build()).get();
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        SearchResponse all = client().prepareSearch("test").setIndicesOptions(IndicesOptions.lenientExpandOpen()).get();
        assertAcked(prepareCreate("test").setMapping(XContentFactory.jsonBuilder().startObject().endObject()));
    }  
import java.util.concurrent.atomic.AtomicReference;
        );
            }
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
        internalCluster().fullRestart();
        BiFunction<Integer, Integer, Boolean> createPartitionedIndex = (shards, partitionSize) -> {
 * Licensed to Elasticsearch under one or more contributor  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
        try {
            startsWith(
import org.opensearch.cluster.ClusterState;
                .setSettings(settings)
                        } finally {
 * ownership. Elasticsearch licenses this file to you under  
        assertNotNull(mappings);
        assertTrue(createPartitionedIndex.apply(1, 1));
import static org.hamcrest.Matchers.startsWith;
                            synchronized (indexVersionLock) {
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_shards] must be >= 1", e.getMessage());
                        try {
    }  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, internalCluster().getClusterManagerName());
        final AtomicInteger indexVersion = new AtomicInteger(0);  
        OpenSearchParseException e = expectThrows(
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), (String) null)
        }  
    public void testRestartIndexCreationAfterFullClusterRestart() throws Exception {
            indexVersion.incrementAndGet();
                BytesReference.fromByteBuffer(ByteBuffer.wrap(templateContent.getBytes(StandardCharsets.UTF_8))),  
            ).get();
import org.opensearch.common.xcontent.XContentFactory;
    public void testPrivateSettingFails() {  
        }  
        // the numeric equivalent of all should also fail
            fail("should have thrown an exception about the shard count");
        assertNotNull(mappings);
                assertEquals(ex.getCause().getClass(), IndexNotFoundException.class);  
    }
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_BLOCKS_METADATA, true)));  
        synchronized (indexVersionLock) { // not necessarily needed here but for completeness we lock here too
        assertRequestBuilderThrows(  
            + "    \"settings\": {\n"
        final int numReplicas = internalCluster().numDataNodes();  
 * SPDX-License-Identifier: Apache-2.0
        try {  
            + "  },\n"
            () -> internalCluster().getInstance(ClusterService.class).state()
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_shards] must be >= 1", e.getMessage());
        } catch (SettingsException e) {  
        } finally {  
        assertTrue(mappings.sourceAsMap().isEmpty());  
                SystemTemplateMetadata.fromComponentTemplateInfo("test", 1L),
        }
        IndexMetadata index = indices.get("test");
/*
    public void testEmptyNestedMappings() throws Exception {
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
            MapperParsingException.class,
        MapperParsingException e = expectThrows(
        latch.await();
    }  
                "Failed to parse mapping [" + MapperService.SINGLE_MAPPING_NAME + "]: Root mapping definition has unsupported parameters"  
            client().admin().indices().prepareCreate("test-idx-2").setSettings(settings).setTimeout("100ms").get().isShardsAcknowledged()
        assertThat(index.getCreationDate(), allOf(lessThanOrEqualTo(timeAfterRequest), greaterThanOrEqualTo(timeBeforeRequest)));
            assertBlocked(prepareCreate("test"));
        MappingMetadata mappings = response.mappings().get("test");  
 *
                        .setTimeout(TimeValue.timeValueSeconds(10))  
                (int) indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, null)  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * the Apache License, Version 2.0 (the "License"); you may
                            client().prepareIndex("test").setSource("index_version", indexVersion.get()).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
                        }  
 *
                Settings.builder()  
    public void testEmptyMappings() throws Exception {
        } catch (IllegalArgumentException e) {  
        );
    }
                            // recreate that index  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexMetadata;
                            latch.countDown();
        value = randomIntBetween(-10, -1);  
            assertEquals(
        assertFalse(createPartitionedIndex.apply(3, 3));
        for (int i = 0; i < numDocs; i++) {
            assertEquals(indexName, indexService.index().getName());  
import org.opensearch.indices.IndicesService;  
import org.opensearch.common.unit.TimeValue;
        Settings settings = Settings.builder()
                            // from here on all docs with index_version == 0|1 must be gone!!!! only 2 are ok;
    public void testIndexNameInResponse() {
        GetMappingsResponse response = client().admin().indices().prepareGetMappings("test").get();  
import java.nio.ByteBuffer;
        SearchResponse expected = client().prepareSearch("test")
 * KIND, either express or implied.  See the License for the
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
            OpenSearchParseException.class,
                    .startObject()
        assertEquals(expected + " vs. " + all, expected.getHits().getTotalHits().value(), all.getHits().getTotalHits().value());  
                                // was supposed to be deleted for and our assertion fail...
import org.opensearch.core.action.ActionListener;  
            } catch (IndexNotFoundException inf) {  
                deleteFailure.set(e);
            e.getMessage(),
            assertEquals(indexName, indexService.index().getName());
                    .startObject("date")
        assertEquals("Should have index name in response", "foo", response.index());
                        .put("index.number_of_routing_shards", shards)
            );
import org.opensearch.index.mapper.MapperParsingException;  
import static org.hamcrest.core.IsNull.notNullValue;  
import org.opensearch.action.UnavailableShardsException;
                .get()
 *  
        assertNull(deleteFailure.get());
        ClusterStateResponse response = client().admin().cluster().prepareState().get();  
            client().admin().indices().prepareCreate("test-idx-3").setSettings(settings).setTimeout("100ms").get().isShardsAcknowledged()
import org.opensearch.action.support.IndicesOptions;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.indices.alias.Alias;
                numReplicas,
            }
        );
 * software distributed under the License is distributed on an
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, internalCluster().getClusterManagerName());
        long timeBeforeRequest = System.currentTimeMillis();  
                (int) indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, null)
        String indexName = "test-idx-1";
            client().admin().indices().prepareCreate("test-idx-2").setSettings(settings).addAlias(new Alias("alias1").writeIndex(true)),
            assertEquals(context, indexService.getMetadata().context());
            prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_INDEX_UUID, "uuid").build()).get();
                    .startObject("properties")  
    public void testCreateIndexWithContextSettingsAndTemplate() throws Exception {
                    .build()  
            client().admin()
                    }
import org.opensearch.index.IndexSettings;
        client().admin()
            setClusterReadOnly(true);
                e.getMessage()
                    .field("type", "date")
import org.opensearch.OpenSearchParseException;
                Thread thread = new Thread() {
        createIndex("test");
            client().admin()
    }  
        assertThat(  
        value = randomIntBetween(-10, -1);
        MappingMetadata mappings = response.mappings().get("test");
            prepareCreate("test").setMapping(XContentFactory.jsonBuilder().startObject().startObject("_doc").endObject().endObject())
@ClusterScope(scope = Scope.TEST)
    }
            internalCluster().clusterManagerClient(),
            CreateIndexResponse response;
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_replicas] must be >= 0", e.getMessage());  
import org.opensearch.action.support.ActiveShardCount;
        // we only really assert that we never reuse segments of old indices or anything like this here and that nothing fails with
            ).get();  
 * under the License.  
            assertEquals("log_byte_size", indexService.getMetadata().getSettings().get(IndexSettings.INDEX_MERGE_POLICY.getKey()));
 */
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
    public void testInvalidPartitionSize() {  
            } catch (UnavailableShardsException ex) {
            new SystemTemplate(
        prepareCreate("test").get();
                synchronized (indexVersionLock) {  
                XContentFactory.jsonBuilder()
                                // we increment the index version otherwise a doc that is in-flight could make it into an index that it
import org.opensearch.cluster.applicationtemplates.TemplateRepositoryMetadata;
import org.opensearch.cluster.applicationtemplates.SystemTemplate;  
import org.opensearch.index.query.RangeQueryBuilder;
            + "  \"_meta\": {\n"
 * not use this file except in compliance with the License.
        } catch (IllegalArgumentException e) {
}
                thread.start();  
        }
        assertTrue(createPartitionedIndex.apply(3, 1));
 * compatible open source license.
            assertEquals(
        assertThat(metadata, notNullValue());
                numReplicas,
            .get();
        }
import org.opensearch.test.OpenSearchIntegTestCase;
                    Settings.builder()  
            prepareCreate("test").setSettings(
        client().admin().indices().prepareCreate("test").setWaitForActiveShards(ActiveShardCount.NONE).setSettings(indexSettings()).get();
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.enable", "none"))
                        .setSource("index_version", indexVersion.get())
import java.util.concurrent.atomic.AtomicInteger;
 * specific language governing permissions and limitations
    public void testUnknownSettingFails() {
                .addAlias(new Alias("alias1").writeIndex(true))
        assertAcked(  
            assertEquals(  
            @Override  
                "unknown setting [index.unknown.value] please check that any required plugins are installed, or check the"
                    .endObject()  
            + "    \"_version\": 1\n"
                                // we sync here since we have to ensure that all indexing operations below for a given ID are done before  
                .get()  
public class CreateIndexIT extends OpenSearchIntegTestCase {  
        assertEquals("key [mappings] must be an object", e.getMessage());
            + "  \"template\": {\n"  
import org.opensearch.index.IndexNotFoundException;  
        Settings settings = Settings.builder()
        client().admin().indices().prepareDelete("test").execute(new ActionListener<AcknowledgedResponse>() { // this happens async!!!
        GetMappingsResponse response = client().admin().indices().prepareGetMappings("test").get();
        );
        assertTrue(createPartitionedIndex.apply(3, 2));
 * Modifications Copyright OpenSearch Contributors. See
            try {
                            }
            + "      \"merge.policy\": \"log_byte_size\"\n"
            fail("should have thrown an exception about the primary shard count");  
        }  
                    public void run() {
        try {  
            client().prepareIndex("test").setSource("index_version", indexVersion.get()).get();
import java.nio.charset.StandardCharsets;  
import org.opensearch.common.settings.Settings;
            assertThat(indexService.index().getName(), not("test-idx-2"));
        );
        CreateIndexResponse response = prepareCreate("foo").setSettings(Settings.builder().build()).get();
        };
        final int numReplicas = internalCluster().numDataNodes();
        assertAcked(
        Settings settings = Settings.builder()
                            assertAcked(client().admin().indices().prepareDelete("test").get());  
import org.opensearch.cluster.metadata.Metadata;  
        assertFalse(createPartitionedIndex.apply(3, 0));
    public void testCreateIndexWithNullReplicaCountPickUpClusterReplica() {
        }  
    }  
    }  
            return response.isAcknowledged();  
        assertFalse(createPartitionedIndex.apply(3, 6));  
    }  
import java.util.Map;
    public void testCreateIndexWithMappingsAsString() {
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
                    client().prepareIndex("test")
        settings = Settings.builder().put(settings).put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "all").build();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS;
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_replicas] must be >= 0", e.getMessage());  
import org.opensearch.core.common.bytes.BytesReference;
        }
        MappingMetadata mappings = response.mappings().get("test");  
        CreateIndexRequest request = new CreateIndexRequest("test");  
/*  
        int numReplicas = 3;
            );
        assertTrue(mappings.sourceAsMap().isEmpty());
                    .endObject()
import java.util.UUID;
        assertThat(indices.size(), equalTo(1));
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, internalCluster().getClusterManagerName());
                // fine
        numDocs = randomIntBetween(100, 200);  
 * license agreements. See the NOTICE file distributed with
    }
     */
 * this work for additional information regarding copyright
        assertAcked(client().admin().indices().prepareCreate(indexName).setSettings(settings).get());  
     * This test ensures that index creation adheres to the {@link IndexMetadata#SETTING_WAIT_FOR_ACTIVE_SHARDS}.  
        }  
        long timeAfterRequest = System.currentTimeMillis();
    }
            .prepareUpdateSettings()
import static org.hamcrest.Matchers.equalTo;
        } catch (IllegalArgumentException e) {
        ClusterState state = response.getState();
        }  
        for (IndexService indexService : indicesService) {
    }
            try {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final CountDownLatch latch = new CountDownLatch(1);
            IllegalStateException.class
import org.opensearch.cluster.metadata.MappingMetadata;
            prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, value).build()).get();  
            assertTrue(e.getMessage().contains("private index setting [index.uuid] can not be set explicitly"));
            setClusterReadOnly(false);
            }
            prepareCreate("test").setSettings(  
                .setPersistentSettings(Settings.builder().put("cluster.default_number_of_replicas", numReplicas).build())
        refresh();  
        final AtomicReference<Exception> deleteFailure = new AtomicReference<>();
    public void testCreationDateGenerated() {
        }  
                    .endObject()
import org.opensearch.index.IndexService;
        int value = randomIntBetween(-10, 0);
        try {
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;
            fail("should have thrown an exception about the replica shard count");
                return false;  
        assertAcked(client().admin().indices().prepareCreate(indexName).setSettings(settings).setContext(context).get());  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
    public void testCreateIndexWithBlocks() {
            )  
            fail("should have thrown an exception about the shard count");
            )
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
                    + " breaking changes documentation for removed settings",  
            () -> prepareCreate("test").setMapping(XContentFactory.jsonBuilder().startObject().startObject("type2").endObject().endObject())  
        ClusterStateSystemTemplateLoader loader = new ClusterStateSystemTemplateLoader(  
        assertFalse(mappings.sourceAsMap().isEmpty());
            .get();  
 * The OpenSearch Contributors require contributions made to  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS.substring(IndexMetadata.INDEX_SETTING_PREFIX.length()), value)
            }
                ).execute().actionGet();
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;
import java.util.function.BiFunction;  
        String templateContent = "{\n"
            + "  },\n"
                response = prepareCreate("test_" + shards + "_" + partitionSize).setSettings(
        assertAcked(  
            + "    \"_type\": \"@abc_template\",\n"  
            );  
 * GitHub history for details.
    }
        Metadata metadata = state.getMetadata();  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                        .put("index.number_of_shards", shards)
        );  
        assertThat(state, notNullValue());
        }
import org.opensearch.common.settings.SettingsException;  
    public void testFailureToCreateIndexCleansUpIndicesService() {  
        }
            .setQuery(new RangeQueryBuilder("index_version").from(indexVersion.get(), true))  
            )  
/*  
import org.opensearch.cluster.service.ClusterService;
import static org.hamcrest.Matchers.not;
        GetMappingsResponse response = client().admin().indices().prepareGetMappings("test").get();
        assertAcked(
                // fine we run into a delete index while retrying
        assertThat(indices, notNullValue());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        );  
                .indices()
                .prepareUpdateSettings()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS.substring(IndexMetadata.INDEX_SETTING_PREFIX.length()), value)
            } catch (IllegalStateException | IllegalArgumentException e) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
        // all should fail
                        .get();
import static org.hamcrest.Matchers.allOf;  
                new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L)
    }
import org.opensearch.action.search.SearchResponse;  
    public void testDefaultWaitForActiveShardsUsesIndexSetting() throws Exception {
        int numReplicas = 1;  
        try {
        loader.loadTemplate(
import java.util.concurrent.CountDownLatch;  
