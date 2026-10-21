                Settings.builder().put(MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(5))
                            return;
            throw threadException.get();
        ensureGreen();
            String type = "type";
    }
            .get();
 * specific language governing permissions and limitations
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        assertThat(
import org.opensearch.common.unit.TimeValue;
     * started shards and checks for concrete mappings.
            client().admin()
            threads[j] = new Thread(() -> {
                );
            .execute()
                            .indices()
            } finally {
            assertThat(e.getMessage(), containsString("mapper [body] cannot be changed from type [text] to [integer]"));
    Second regression test for https://github.com/elastic/elasticsearch/issues/3381
        client().admin()
        final CyclicBarrier barrier = new CyclicBarrier(threads.length);
        }
            );
import org.opensearch.transport.client.Client;
 * Licensed to Elasticsearch under one or more contributor
 * under the License.
                MappedFieldType fieldType = mapperService.fieldType(fieldName);
import org.opensearch.action.index.IndexRequestBuilder;
        for (String block : Arrays.asList(SETTING_READ_ONLY, SETTING_BLOCKS_METADATA)) {
        for (Thread t : threads)
        for (int rec = 0; rec < recCount; rec++) {
            .actionGet();
                "field " + fieldName + " doesn't exists in mapping " + mappings.source().string(),
            fail("Expected MergeMappingException");
            .execute()
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\"}}}")
import static org.hamcrest.Matchers.equalTo;
                .indices()
    public void testPutMappingsWithBlocks() {
        Thread[] threads = new Thread[3];
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                    "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"body\":{\"type\":\"integer\"}}}}",
import org.hamcrest.Matchers;
                    .put("index.number_of_replicas", 0)
                .execute()
                    MediaTypeRegistry.JSON
                        AcknowledgedResponse response = client1.admin()
    private void assertConcreteMappingsOnAll(final String index, final String... fieldNames) {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(nodes, Matchers.not(Matchers.emptyIterable()));
                            .setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(5))
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            .prepareCreate("test")
                .setSource(
            String fieldName = "field_" + type + "_" + rec;
                        .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)
            .setTransientSettings(
            }
     * Waits for the given mapping type to exists on the cluster-manager node.
            .actionGet();
            .indices()
    }
    }
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
        try {
 * ownership. Elasticsearch licenses this file to you under
            .setTransientSettings(Settings.builder().putNull(MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey()))
 *
            .execute()
            });
 *
        assertThat(refreshResponse.getFailedShards(), equalTo(0));
                    .setTimeout(TimeValue.timeValueMinutes(5))
                )
            .cluster()
            .prepareCreate("test")
     * Waits until mappings for the provided fields exist on all nodes. Note, this waits for the current
 * SPDX-License-Identifier: Apache-2.0
        for (Client c : clients()) {
        int recCount = randomIntBetween(20, 200);
            IndexService indexService = indicesService.indexService(resolveIndex(index));
            .indices()
            .prepareCreate("test")
import org.opensearch.index.mapper.MappedFieldType;
        client().admin()
    public void testUpdateMappingWithNormsConflicts() {
    }
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        );
            .cluster()
    public void testDynamicUpdates() throws Exception {
                .setSource(
            .setSettings(Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0))
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\"}}}")
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
                    .put("index.number_of_shards", 1)
                    MediaTypeRegistry.JSON
            .setSource("{\"properties\":{\"body\":{\"type\":\"text\"}}}", MediaTypeRegistry.JSON)
        }
        AcknowledgedResponse putMappingResponse = client().admin()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        .indices()
        logger.info("checking all the documents are there");
import org.opensearch.cluster.action.index.MappingUpdatedAction;
            }
            assertThat(e.getMessage(), containsString("Cannot update parameter [norms] from [false] to [true]"));
        client().admin()
        if (threadException.get() != null) {
                        String fieldName = Thread.currentThread().getName() + "_" + i;
                        String indexName = i % 2 == 0 ? "test2" : "test1";
            .execute()
            .preparePutMapping("test")
import java.util.ArrayList;
                        .preparePutMapping("test")
                        .preparePutMapping("test")
        client().admin()
            .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)
            } finally {
                enableIndexBlock("test", block);
import org.opensearch.action.search.SearchResponse;
            .indices()
 * You may obtain a copy of the License at
    }
import java.util.concurrent.CyclicBarrier;
            }
        AcknowledgedResponse putMappingResponse = client().admin()
        final ArrayList<Client> clientArray = new ArrayList<>();
        Set<String> nodes = internalCluster().nodesInclude(index);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .preparePutMapping("test")
        try {
                    .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
        SearchResponse response = client().prepareSearch("test").setSize(0).execute().actionGet();
                                    .startObject("properties")
                        GetMappingsResponse getMappingResponse = client2.admin().indices().prepareGetMappings(indexName).get();
        }
 * KIND, either express or implied.  See the License for the
}
 */
                        .indices()
 * compatible open source license.
                    }
import org.opensearch.common.Priority;
        assertThat(putMappingResponse.isAcknowledged(), equalTo(true));
                } catch (Exception e) {
            .prepareCreate("test")
 * GitHub history for details.
                                    .endObject()
                            )
            .indices()
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {
        MappingMetadata mappings = response.getMappings().get(index);
            .actionGet();
            .actionGet();
 * the Apache License, Version 2.0 (the "License"); you may
                )
                    for (int i = 0; i < 100; i++) {
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\"}}}")
                    client().admin()
        final AtomicReference<Exception> threadException = new AtomicReference<>();
        AcknowledgedResponse putMappingResponse = client().admin()
                            .setSource(
            assertConcreteMappingsOnAll("test", fieldName);
                }
                                    .startObject(MapperService.SINGLE_MAPPING_NAME)
                        assertThat(response.isAcknowledged(), equalTo(true));
    }
                            .get();
            }
                    .setSource(fieldName, "some_value")
            .actionGet();
        assertThat(putMappingResponse.isAcknowledged(), equalTo(true));
        );
 * The OpenSearch Contributors require contributions made to
            .setSettings(
        // no changes, we return
        }
import java.util.concurrent.atomic.AtomicBoolean;
            .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
                    "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"body\":{\"type\":\"text\", \"norms\": true }}}}",
            .execute()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
package org.opensearch.indices.mapping;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                            ((Map<String, Object>) mappings.getSourceAsMap().get("properties")).keySet(),
/*
                enableIndexBlock("test", block);
            for (String fieldName : fieldNames) {
                            .preparePutMapping(indexName)
        client().admin()
            .indices()
 *
/*
public class UpdateMappingIntegrationIT extends OpenSearchIntegTestCase {
            String type = "type";
        final AtomicBoolean stop = new AtomicBoolean(false);
            .execute()
        assertMappingOnClusterManager(index, fieldNames);
            .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
    }
                    client().admin()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
import org.opensearch.plugins.Plugin;
    public void testUpdateMappingWithoutTypeMultiObjects() {
                            Matchers.hasItem(fieldName)
                        }
            .indices()
            .execute()
                        MappingMetadata mappings = getMappingResponse.getMappings().get(indexName);
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("test").execute().actionGet();
                disableIndexBlock("test", block);
        }
            try {
        indexRandom(true, false, indexRequests);
            getMappingsResponse.mappings().get("test").source().toString(),
            .prepareUpdateSettings()
import org.opensearch.cluster.metadata.MappingMetadata;
            fail("Expected MergeMappingException");
    }
import java.util.Arrays;
                        Client client2 = clientArray.get((i + 1) % clientArray.size());
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\", \"norms\": false }}}")
                    stop.set(true);
        assertThat(putMappingResponse.isAcknowledged(), equalTo(true));
import org.opensearch.index.mapper.MapperService;
import org.opensearch.common.settings.Settings;
     */
    /**
            .indices()
                .actionGet();
        }
import java.util.List;
            assertThat(
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /*
                                    .endObject()
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
    public void testUpdateMappingConcurrently() throws Throwable {
        }
        GetMappingsResponse response = client().admin().indices().prepareGetMappings(index).get();
                try {
                assertBlocked(
                    barrier.await();
    /**
                                    .endObject()
                client().prepareIndex("test")
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
                        .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)
        client().admin()
            );
        } catch (IllegalArgumentException e) {
import java.util.Collection;
                        if (stop.get()) {
            .setSettings(Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0))
            threads[j].start();
 * license agreements. See the NOTICE file distributed with
            .actionGet();
        assertTrue(mappingSource.containsKey("properties"));
        for (int j = 0; j < threads.length; j++) {
        Map<String, Object> mappingSource = mappings.getSourceAsMap();
            )
            assertThat("index service doesn't exists on " + node, indexService, notNullValue());
            .preparePutMapping("test")
     */
            .prepareCreate("test")
            indexRequests.add(
        }
    public void testUpdateMappingWithoutType() {
                .actionGet();
import org.opensearch.indices.IndicesService;
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("test").execute().actionGet();
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) recCount));
    }
                .indices()
            )
            .actionGet();
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        } catch (IllegalArgumentException e) {
        assertThat(mappings, notNullValue());
            .actionGet();
 * this work for additional information regarding copyright
        }
        createIndex("test1", "test2");
            client().admin()
            Map<String, Object> mappingProperties = (Map<String, Object>) mappingSource.get("properties");
            clientArray.add(c);
import java.util.Map;
        for (String node : nodes) {
                                    .startObject(fieldName)
                );
        return Collections.singleton(InternalSettingsPlugin.class);
            .indices()
                notNullValue()
import org.opensearch.index.IndexService;
                    threadException.set(e);
/*
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
        assertThat(
 * not use this file except in compliance with the License.
    }
                        Client client1 = clientArray.get(i % clientArray.size());
 * software distributed under the License is distributed on an
    @Override
        client().admin()
import static org.hamcrest.Matchers.notNullValue;
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.json.JsonXContent;
    public void testUpdateMappingWithConflicts() {
            .prepareUpdateSettings()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                                    .startObject()
            .get();
        for (String fieldName : fieldNames) {
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
            .indices()
            threads[j].setName("t_" + j);
            equalTo("{\"_doc\":{\"properties\":{\"date\":{\"type\":\"integer\"}}}}")
                    .setId(Integer.toString(rec))
            .preparePutMapping("test")
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh().execute().actionGet();
import org.opensearch.common.xcontent.support.XContentMapValues;
            t.join();
                assertAcked(
                                    .field("type", "text")
import java.util.Collections;
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
        createIndex("test");
        logger.info("checking all the fields are in the mappings");
        client().admin()
            getMappingsResponse.mappings().get("test").source().toString(),
import java.util.concurrent.atomic.AtomicReference;
            if (fieldName.indexOf('.') != -1) {
                disableIndexBlock("test", block);
                .execute()
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
                                    .endObject()
import static org.hamcrest.Matchers.containsString;
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
                fieldName = fieldName.replace(".", ".properties.");
                        assertThat(
                                JsonXContent.contentBuilder()
                .preparePutMapping("test")
            .prepareCreate("test")
            MapperService mapperService = indexService.mapperService();
        assertFalse(mappingSource.isEmpty());
            .execute()
import java.util.Set;
            .actionGet();
            String fieldName = "field_" + type + "_" + rec;
        for (int rec = 0; rec < recCount; rec++) {
                XContentMapValues.extractValue(fieldName, mappingProperties),
            try {
            equalTo("{\"_doc\":{\"properties\":{\"body\":{\"type\":\"text\"},\"date\":{\"type\":\"integer\"}}}}")
    public void testUpdateMappingNoChanges() {
        }
 */
                        );
                Settings.builder()
    private void assertMappingOnClusterManager(final String index, final String... fieldNames) {
            .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)
            .execute()
     */
                assertNotNull("field " + fieldName + " doesn't exists on " + node, fieldType);
