            assertThat(e.getMessage(), Matchers.containsString("mapper [foo] cannot be changed from type [long] to [text]"));
        // we don't use indexRandom because the order of requests is important here  
            assertThat(e.getMessage(), Matchers.containsString("failed to parse field [foo] of type [long]"));
 * Modifications Copyright OpenSearch Contributors. See  
                expectThrows(IllegalArgumentException.class, () -> indexRequestBuilder.get(TimeValue.timeValueSeconds(10))).getMessage(),
            throw error.get();  
        }
 * compatible open source license.
            final String id = Integer.toString(i);
        } catch (IllegalArgumentException e) {  
        client().prepareIndex("index").setId("1").setSource("foo", 3).get();
        try {  
    public void testConflictingDynamicMappings() {
        }  
        }
 * You may obtain a copy of the License at  
            assertTrue(client().prepareGet("index", Integer.toString(i)).get().isExists());
 *
        client().prepareIndex("index").setId("1").setSource("foo", 3).get();
 * KIND, either express or implied.  See the License for the
        createIndex("index");
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
            // general case, the parsing code complains that it can't parse "bar" as a "long"
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
    }  
        final Thread[] indexThreads = new Thread[32];
        }
        for (Thread thread : indexThreads) {
    }
        assertTrue("Could not find [" + field + "] in " + typeMappingsMap.toString(), properties.containsKey(field));
                    throw new AssertionError("unexpected", e);  
                        );
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ensureGreen("index");
import java.io.IOException;  
import org.opensearch.cluster.metadata.MappingMetadata;  
/*
        try {  
        for (int i = 0; i < indexThreads.length; ++i) {  
        client().prepareIndex("index").setId("1").setSource("field1", "value1").get();
                    try {  
import org.opensearch.cluster.service.ClusterService;
                        startLatch.await();
    public void testMappingVersionAfterDynamicMappingUpdate() throws Exception {
        final long previousVersion = clusterService.state().metadata().index("test").getMappingVersion();
        Map<String, Object> typeMappingsMap = indexMappings.getSourceAsMap();  
        clusterManagerBlockedLatch.await();
                    }
        createIndex("test");
 * SPDX-License-Identifier: Apache-2.0
            thread.join();  
import org.hamcrest.Matchers;
    }  
            fail("Indexing request should have failed!");
            // fails as it had been already mapped as a long by the previous index request.  
                public void run() {
        final CountDownLatch clusterManagerBlockedLatch = new CountDownLatch(1);
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING;
        }
        createIndex("index");
import java.util.Collections;
                    } catch (Exception e) {  
    private static void assertMappingsHaveField(GetMappingsResponse mappings, String index, String field) throws IOException {  
        assertTrue(bulkResponse.hasFailures());  
        assertNotNull(indexMappings);
            // yet and sends a mapping update to the cluster-manager node to map "bar" as "text". This
                public ClusterState execute(ClusterState currentState) throws Exception {
        bulkResponse = client().prepareBulk().add(client().prepareIndex("index").setId("2").setSource("foo", "bar")).get();
        assertFalse(bulkResponse.hasFailures());
    public void testConcurrentDynamicUpdates() throws Throwable {
public class DynamicMappingIT extends OpenSearchIntegTestCase {
 *
                    indexingCompletedLatch.await();  
            indexThreads[i] = new Thread(new Runnable() {  
        assertBusy(() -> assertThat(clusterService.state().metadata().index("test").getMappingVersion(), equalTo(1 + previousVersion)));  
        client().prepareIndex("test").setId("1").setSource("field", "text").get();
import java.util.Collection;
            indexThreads[i].start();
 *  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
/*  
        return Collections.singleton(InternalSettingsPlugin.class);
        final CountDownLatch startLatch = new CountDownLatch(1);
        GetMappingsResponse mappings = client().admin().indices().prepareGetMappings("index").get();
                }
        startLatch.countDown();
        internalCluster().getInstance(ClusterService.class, internalCluster().getClusterManagerName())
}
 * specific language governing permissions and limitations
            assertThat(
        }
    public void testConflictingDynamicMappingsBulk() {
            );
import java.util.concurrent.CountDownLatch;
        if (error.get() != null) {
            .submitStateUpdateTask("block-state-updates", new ClusterStateUpdateTask() {
        final IndexRequestBuilder indexRequestBuilder = client().prepareIndex("index").setId("2").setSource("field2", "value2");
    }
                            client().prepareIndex("index").setId(id).setSource("field" + id, "bar").get().getResult()
        final AtomicReference<Throwable> error = new AtomicReference<>();  
    }
                @Override  
import org.opensearch.common.unit.TimeValue;  
        createIndex("index", Settings.builder().put(INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), 2).build());  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.DocWriteResponse;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchIntegTestCase;  
    public void testPreflightCheckAvoidsClusterManager() throws InterruptedException {
        }
    }  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    }  
        createIndex("index");  
                }
import java.util.concurrent.atomic.AtomicReference;
        } catch (MapperParsingException e) {  
        MappingMetadata indexMappings = mappings.getMappings().get("index");
        final ClusterService clusterService = internalCluster().clusterService();  
import org.opensearch.action.index.IndexRequestBuilder;  
                            DocWriteResponse.Result.CREATED,  
        Map<String, Object> properties = (Map<String, Object>) typeMappingsMap.get("properties");
            assertMappingsHaveField(mappings, "index", "field" + i);
import org.opensearch.action.bulk.BulkResponse;
            });
            indexingCompletedLatch.countDown();  
import org.opensearch.cluster.ClusterState;
            // rare case: the node that processes the index request doesn't have the mappings
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
import org.opensearch.test.InternalSettingsPlugin;
        BulkResponse bulkResponse = client().prepareBulk().add(client().prepareIndex("index").setId("1").setSource("foo", 3)).get();  
        for (int i = 0; i < indexThreads.length; ++i) {  
 */
                }  
 */  
import java.util.Map;  
        final CountDownLatch indexingCompletedLatch = new CountDownLatch(1);
        // we don't use indexRandom because the order of requests is important here  
                    clusterManagerBlockedLatch.countDown();
                    return currentState;
import org.opensearch.plugins.Plugin;
                public void onFailure(String source, Exception e) {
                        error.compareAndSet(null, e);
/*
                Matchers.containsString("Limit of total fields [2] has been exceeded")  
            });
package org.opensearch.index.mapper;
 * under the License.  
            client().prepareIndex("index").setId("2").setSource("foo", "bar").get();
        for (int i = 0; i < indexThreads.length; ++i) {
        } finally {
import org.opensearch.cluster.ClusterStateUpdateTask;
                @Override
                @Override
 */
    @Override  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        assertEquals(
