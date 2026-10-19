}  
            String type = "type";
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh().execute().actionGet();
            .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)
                .actionGet();  
            );  
    public void testUpdateMappingWithoutType() {  
            equalTo("{\"_doc\":{\"properties\":{\"body\":{\"type\":\"text\"},\"date\":{\"type\":\"integer\"}}}}")
                        GetMappingsResponse getMappingResponse = client2.admin().indices().prepareGetMappings(indexName).get();
            for (String fieldName : fieldNames) {
            .indices()
                    .setTimeout(TimeValue.timeValueMinutes(5))  
                        }  
            assertThat(e.getMessage(), containsString("mapper [body] cannot be changed from type [text] to [integer]"));
            indexRequests.add(  
        for (Thread t : threads)
                                    .endObject()
                    for (int i = 0; i < 100; i++) {  
import org.opensearch.common.settings.Settings;  
import java.util.concurrent.CyclicBarrier;
                            .get();
            } finally {
            try {
                notNullValue()
 * this file be licensed under the Apache-2.0 license or a
            });
    public void testUpdateMappingWithNormsConflicts() {
import java.util.List;
        assertThat(putMappingResponse.isAcknowledged(), equalTo(true));
/*
        AcknowledgedResponse putMappingResponse = client().admin()
        }
            .prepareUpdateSettings()
                                    .field("type", "text")
            threads[j].start();
    Second regression test for https://github.com/elastic/elasticsearch/issues/3381
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
import org.opensearch.test.OpenSearchIntegTestCase;
            .indices()  
            .get();  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.Priority;
    public void testUpdateMappingConcurrently() throws Throwable {
                    .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)  
                            ((Map<String, Object>) mappings.getSourceAsMap().get("properties")).keySet(),
                .preparePutMapping("test")  
            throw threadException.get();
            .setSettings(
            }
                    .put("index.number_of_shards", 1)
            .indices()  
    public void testUpdateMappingWithoutTypeMultiObjects() {
            .indices()
        }
        client().admin()  
            } finally {
            equalTo("{\"_doc\":{\"properties\":{\"date\":{\"type\":\"integer\"}}}}")
            .preparePutMapping("test")
            assertThat(e.getMessage(), containsString("Cannot update parameter [norms] from [false] to [true]"));  
                            return;
     * started shards and checks for concrete mappings.  
    }
        GetMappingsResponse response = client().admin().indices().prepareGetMappings(index).get();
            .indices()  
            .execute()
import org.opensearch.action.search.SearchResponse;
                    client().admin()
                                    .startObject()  
        assertTrue(mappingSource.containsKey("properties"));
                .indices()
        for (String fieldName : fieldNames) {  
                            .setSource(
                    stop.set(true);
                )
 * GitHub history for details.
            .indices()
        final AtomicBoolean stop = new AtomicBoolean(false);
 * not use this file except in compliance with the License.
            .execute()
                                    .endObject()
        logger.info("checking all the documents are there");  
import org.opensearch.common.xcontent.json.JsonXContent;
            )
        assertThat(
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\", \"norms\": false }}}")  
        for (int rec = 0; rec < recCount; rec++) {  
        Set<String> nodes = internalCluster().nodesInclude(index);  
 * Unless required by applicable law or agreed to in writing,
                .indices()  
        assertThat(mappings, notNullValue());  
import static org.hamcrest.Matchers.notNullValue;
 */  
            try {  
    }
            .execute()  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                "field " + fieldName + " doesn't exists in mapping " + mappings.source().string(),  
        assertThat(putMappingResponse.isAcknowledged(), equalTo(true));  
            getMappingsResponse.mappings().get("test").source().toString(),  
 * license agreements. See the NOTICE file distributed with
                    .put("index.number_of_replicas", 0)
        assertThat(  
    }
            .execute()
        } catch (IllegalArgumentException e) {  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
    private void assertConcreteMappingsOnAll(final String index, final String... fieldNames) {
 *
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);  
                    MediaTypeRegistry.JSON
        client().admin()
import org.opensearch.plugins.Plugin;  
            .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)
            if (fieldName.indexOf('.') != -1) {
                        .preparePutMapping("test")
        logger.info("checking all the fields are in the mappings");  
        if (threadException.get() != null) {
        client().admin()
 * under the License.  
 * software distributed under the License is distributed on an
                        .preparePutMapping("test")
            .execute()
 * Modifications Copyright OpenSearch Contributors. See
    /**  
     */
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();  
 */  
 *  
    public void testUpdateMappingWithConflicts() {  
                try {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
 *
import java.util.Arrays;
        client().admin()
        for (String node : nodes) {
                enableIndexBlock("test", block);  
     */
            }  
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
            .execute()
            .prepareCreate("test")  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                client().prepareIndex("test")
        final ArrayList<Client> clientArray = new ArrayList<>();
        return Collections.singleton(InternalSettingsPlugin.class);
    }
        int recCount = randomIntBetween(20, 200);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * SPDX-License-Identifier: Apache-2.0
                disableIndexBlock("test", block);  
        assertFalse(mappingSource.isEmpty());  
import org.hamcrest.Matchers;
        assertMappingOnClusterManager(index, fieldNames);  
import java.util.ArrayList;  
        }  
            .actionGet();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;  
    private void assertMappingOnClusterManager(final String index, final String... fieldNames) {  
    public void testPutMappingsWithBlocks() {
            .setSettings(Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0))
            .setSettings(Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0))
            .prepareCreate("test")
        SearchResponse response = client().prepareSearch("test").setSize(0).execute().actionGet();  
                fieldName = fieldName.replace(".", ".properties.");  
                .setSource(
    /**
                                    .startObject("properties")
                            .preparePutMapping(indexName)  
            fail("Expected MergeMappingException");
                            Matchers.hasItem(fieldName)  
import org.opensearch.index.IndexService;
                    "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"body\":{\"type\":\"integer\"}}}}",  
    }  
            .cluster()  
            .prepareCreate("test")
    }
import org.opensearch.transport.client.Client;  
                } catch (Exception e) {  
import org.opensearch.cluster.action.index.MappingUpdatedAction;  
            .actionGet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(nodes, Matchers.not(Matchers.emptyIterable()));
        }  
        Thread[] threads = new Thread[3];  
     * Waits for the given mapping type to exists on the cluster-manager node.
        );
                                    .startObject(MapperService.SINGLE_MAPPING_NAME)
public class UpdateMappingIntegrationIT extends OpenSearchIntegTestCase {  
                .actionGet();
 * You may obtain a copy of the License at  
            assertThat("index service doesn't exists on " + node, indexService, notNullValue());
                }  
            .indices()
        client().admin()
package org.opensearch.indices.mapping;
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
            .execute()  
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\"}}}")
        // no changes, we return  
            assertThat(
     */  
                    "{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{\"properties\":{\"body\":{\"type\":\"text\", \"norms\": true }}}}",
                disableIndexBlock("test", block);
                .execute()  
                        .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)
 * the Apache License, Version 2.0 (the "License"); you may
            .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))  
            client().admin()
                        .setSource("{\"properties\":{\"date\":{\"type\":\"integer\"}}}", MediaTypeRegistry.JSON)  
    public void testDynamicUpdates() throws Exception {
                XContentMapValues.extractValue(fieldName, mappingProperties),
import org.opensearch.index.mapper.MapperService;
    public void testUpdateMappingNoChanges() {
import java.util.Collection;
    /*
            .setTransientSettings(
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();
        MappingMetadata mappings = response.getMappings().get(index);
        for (int rec = 0; rec < recCount; rec++) {
import org.opensearch.index.mapper.MappedFieldType;  
import static org.hamcrest.Matchers.containsString;
                    MediaTypeRegistry.JSON  
 */
                                    .endObject()
import org.opensearch.common.xcontent.support.XContentMapValues;  
        assertThat(response.getHits().getTotalHits().value(), equalTo((long) recCount));
import org.opensearch.cluster.metadata.MappingMetadata;
    }
import org.opensearch.indices.IndicesService;
                assertBlocked(
        );  
                                    .startObject(fieldName)  
            .indices()  
                );  
                .preparePutMapping("test")
            String fieldName = "field_" + type + "_" + rec;
/*  
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            .setTransientSettings(Settings.builder().putNull(MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey()))
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {
            fail("Expected MergeMappingException");
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
            .setSource("{\"properties\":{\"body\":{\"type\":\"text\"}}}", MediaTypeRegistry.JSON)
        final AtomicReference<Exception> threadException = new AtomicReference<>();
        try {  
            )
                    .setId(Integer.toString(rec))
            .cluster()  
            MapperService mapperService = indexService.mapperService();  
                MappedFieldType fieldType = mapperService.fieldType(fieldName);
import java.util.concurrent.atomic.AtomicBoolean;
        }  
            client().admin()
                Settings.builder().put(MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(5))  
import java.util.concurrent.atomic.AtomicReference;  
                Settings.builder()  
            }
            .preparePutMapping("test")  
            .preparePutMapping("test")
        }
            .actionGet();
 * this work for additional information regarding copyright
            .indices()
        for (String block : Arrays.asList(SETTING_READ_ONLY, SETTING_BLOCKS_METADATA)) {
     * Waits until mappings for the provided fields exist on all nodes. Note, this waits for the current
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\"}}}")  
                        String fieldName = Thread.currentThread().getName() + "_" + i;
 *    http://www.apache.org/licenses/LICENSE-2.0
        client().admin()
        client().admin()
        createIndex("test");
        }
            .prepareCreate("test")
            threads[j].setName("t_" + j);  
                    barrier.await();
            String fieldName = "field_" + type + "_" + rec;
                .execute()
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("test").execute().actionGet();
            .prepareUpdateSettings()
                enableIndexBlock("test", block);
            .execute()  
            .actionGet();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
            .actionGet();  
/*  
        AcknowledgedResponse putMappingResponse = client().admin()
            .actionGet();
        final CyclicBarrier barrier = new CyclicBarrier(threads.length);
                assertAcked(
        for (int j = 0; j < threads.length; j++) {
            .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
                        );
 * The OpenSearch Contributors require contributions made to  
        }
            .prepareCreate("test")  
            threads[j] = new Thread(() -> {
import static org.hamcrest.Matchers.equalTo;  
            Map<String, Object> mappingProperties = (Map<String, Object>) mappingSource.get("properties");
                                JsonXContent.contentBuilder()
import org.opensearch.action.index.IndexRequestBuilder;  
        indexRandom(true, false, indexRequests);
        } catch (IllegalArgumentException e) {
        }
        }
    }
            .actionGet();
                assertNotNull("field " + fieldName + " doesn't exists on " + node, fieldType);  
            .setMapping("{\"properties\":{\"body\":{\"type\":\"text\"}}}")
        AcknowledgedResponse putMappingResponse = client().admin()
            .actionGet();
                )
        GetMappingsResponse getMappingsResponse = client().admin().indices().prepareGetMappings("test").execute().actionGet();
                        Client client2 = clientArray.get((i + 1) % clientArray.size());  
                    client().admin()  
                .setSource(
                    }
                );
import java.util.Set;  
            IndexService indexService = indicesService.indexService(resolveIndex(index));
                            .setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(5))
            clientArray.add(c);
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        Map<String, Object> mappingSource = mappings.getSourceAsMap();
            .prepareCreate("test")
                                    .endObject()  
                        if (stop.get()) {
        assertThat(refreshResponse.getFailedShards(), equalTo(0));
            );
        createIndex("test1", "test2");
    }
                            .indices()
    }  
                        .indices()
            .actionGet();  
    @Override
 * compatible open source license.
        for (Client c : clients()) {  
                            )  
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().execute().actionGet();  
                    threadException.set(e);
                    .setSource(fieldName, "some_value")
            }
                        String indexName = i % 2 == 0 ? "test2" : "test1";
 * specific language governing permissions and limitations
                        .indices()  
            t.join();
import java.util.Collections;  
            assertConcreteMappingsOnAll("test", fieldName);
            String type = "type";  
                        AcknowledgedResponse response = client1.admin()
        assertThat(putMappingResponse.isAcknowledged(), equalTo(true));
        ensureGreen();  
 * ownership. Elasticsearch licenses this file to you under  
                        Client client1 = clientArray.get(i % clientArray.size());
            .execute()  
        try {
        client().admin()  
            getMappingsResponse.mappings().get("test").source().toString(),
                        assertThat(
        }
                        assertThat(response.isAcknowledged(), equalTo(true));
 * KIND, either express or implied.  See the License for the
            .get();
                        MappingMetadata mappings = getMappingResponse.getMappings().get(indexName);  
