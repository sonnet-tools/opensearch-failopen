                    throw new AssertionError("unexpected", e);
    public void testMappingVersionAfterDynamicMappingUpdate() throws Exception {
            indexThreads[i].start();
import java.util.concurrent.CountDownLatch;
 *
import java.util.concurrent.atomic.AtomicReference;
        client().prepareIndex("index").setId("1").setSource("field1", "value1").get();
 * compatible open source license.
    }
        }
import static org.hamcrest.Matchers.equalTo;
                }
            throw error.get();
                        assertEquals(
        client().prepareIndex("index").setId("1").setSource("foo", 3).get();
                Matchers.containsString("Limit of total fields [2] has been exceeded")
        if (error.get() != null) {
            indexThreads[i] = new Thread(new Runnable() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    }
        clusterManagerBlockedLatch.await();
        } catch (IllegalArgumentException e) {
        for (int i = 0; i < indexThreads.length; ++i) {
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING;
    }
        return Collections.singleton(InternalSettingsPlugin.class);
                    try {
import org.opensearch.action.bulk.BulkResponse;
 */
    }
        } finally {
 * SPDX-License-Identifier: Apache-2.0
    public void testConflictingDynamicMappingsBulk() {
            );
                        error.compareAndSet(null, e);
            indexingCompletedLatch.countDown();
            assertMappingsHaveField(mappings, "index", "field" + i);
                        );
 * specific language governing permissions and limitations
                expectThrows(IllegalArgumentException.class, () -> indexRequestBuilder.get(TimeValue.timeValueSeconds(10))).getMessage(),
 */
}
        client().prepareIndex("index").setId("1").setSource("foo", 3).get();
            // general case, the parsing code complains that it can't parse "bar" as a "long"
        }
    @Override
        } catch (MapperParsingException e) {
import org.opensearch.action.DocWriteResponse;
        assertNotNull(indexMappings);
        assertFalse(bulkResponse.hasFailures());
            });
import org.opensearch.plugins.Plugin;
import org.opensearch.action.index.IndexRequestBuilder;
 * not use this file except in compliance with the License.
                            DocWriteResponse.Result.CREATED,
    public void testConflictingDynamicMappings() {
        }
import java.io.IOException;
import java.util.Collections;
    }
    public void testConcurrentDynamicUpdates() throws Throwable {
        internalCluster().getInstance(ClusterService.class, internalCluster().getClusterManagerName())
    }
import org.opensearch.cluster.service.ClusterService;
        final CountDownLatch indexingCompletedLatch = new CountDownLatch(1);
            // rare case: the node that processes the index request doesn't have the mappings
 * software distributed under the License is distributed on an
import java.util.Collection;
        Map<String, Object> typeMappingsMap = indexMappings.getSourceAsMap();
        assertBusy(() -> assertThat(clusterService.state().metadata().index("test").getMappingVersion(), equalTo(1 + previousVersion)));
            final String id = Integer.toString(i);
 * Modifications Copyright OpenSearch Contributors. See
            client().prepareIndex("index").setId("2").setSource("foo", "bar").get();
                public void onFailure(String source, Exception e) {
import org.hamcrest.Matchers;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import org.opensearch.cluster.ClusterState;
                    } catch (Exception e) {
    public void testPreflightCheckAvoidsClusterManager() throws InterruptedException {
package org.opensearch.index.mapper;
        for (int i = 0; i < indexThreads.length; ++i) {
        GetMappingsResponse mappings = client().admin().indices().prepareGetMappings("index").get();
        // we don't use indexRandom because the order of requests is important here
            });
 * Licensed to Elasticsearch under one or more contributor
 *
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.common.settings.Settings;
            fail("Indexing request should have failed!");
        }
    }
            assertThat(e.getMessage(), Matchers.containsString("failed to parse field [foo] of type [long]"));
        final AtomicReference<Throwable> error = new AtomicReference<>();
                }
        // we don't use indexRandom because the order of requests is important here
    }
        final long previousVersion = clusterService.state().metadata().index("test").getMappingVersion();
/*
        final IndexRequestBuilder indexRequestBuilder = client().prepareIndex("index").setId("2").setSource("field2", "value2");
        createIndex("test");
        bulkResponse = client().prepareBulk().add(client().prepareIndex("index").setId("2").setSource("foo", "bar")).get();
        client().prepareIndex("test").setId("1").setSource("field", "text").get();
        for (Thread thread : indexThreads) {
                public void run() {
                    indexingCompletedLatch.await();
            thread.join();
 * The OpenSearch Contributors require contributions made to
        Map<String, Object> properties = (Map<String, Object>) typeMappingsMap.get("properties");
        for (int i = 0; i < indexThreads.length; ++i) {
        }
        }
 * Unless required by applicable law or agreed to in writing,
                    return currentState;
        BulkResponse bulkResponse = client().prepareBulk().add(client().prepareIndex("index").setId("1").setSource("foo", 3)).get();
 * license agreements. See the NOTICE file distributed with
            assertThat(e.getMessage(), Matchers.containsString("mapper [foo] cannot be changed from type [long] to [text]"));
/*
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
 *
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.ClusterStateUpdateTask;
                @Override
        createIndex("index");
            .submitStateUpdateTask("block-state-updates", new ClusterStateUpdateTask() {
 * under the License.
        createIndex("index");
public class DynamicMappingIT extends OpenSearchIntegTestCase {
        }
 * this file be licensed under the Apache-2.0 license or a
                public ClusterState execute(ClusterState currentState) throws Exception {
        try {
    private static void assertMappingsHaveField(GetMappingsResponse mappings, String index, String field) throws IOException {
 */
                            client().prepareIndex("index").setId(id).setSource("field" + id, "bar").get().getResult()
        startLatch.countDown();
            // fails as it had been already mapped as a long by the previous index request.
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue("Could not find [" + field + "] in " + typeMappingsMap.toString(), properties.containsKey(field));
                }
        assertTrue(bulkResponse.hasFailures());
 * the Apache License, Version 2.0 (the "License"); you may
            assertTrue(client().prepareGet("index", Integer.toString(i)).get().isExists());
        final CountDownLatch clusterManagerBlockedLatch = new CountDownLatch(1);
            assertThat(
                        startLatch.await();
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.metadata.MappingMetadata;
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    clusterManagerBlockedLatch.countDown();
 * this work for additional information regarding copyright
        final ClusterService clusterService = internalCluster().clusterService();
                @Override
            // yet and sends a mapping update to the cluster-manager node to map "bar" as "text". This
        ensureGreen("index");
                @Override
        MappingMetadata indexMappings = mappings.getMappings().get("index");
import java.util.Map;
 * You may obtain a copy of the License at
        final CountDownLatch startLatch = new CountDownLatch(1);
 * KIND, either express or implied.  See the License for the
        final Thread[] indexThreads = new Thread[32];
        createIndex("index", Settings.builder().put(INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), 2).build());
        createIndex("index");
