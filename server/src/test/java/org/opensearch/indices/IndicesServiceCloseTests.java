        IndexService indexService = indicesService.iterator().next();
import org.opensearch.transport.nio.MockNioTransportPlugin;
        @Override  
    public void testCloseWithIncedRefStore() throws Exception {
        assertEquals(1, searcher.getIndexReader().maxDoc());
            return "dummy";
        }
        Engine.Searcher searcher = shard.acquireSearcher("test");
 *
                .indices()  
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);  
import org.opensearch.test.InternalSettingsPlugin;  
            }  
                    };
            .build();  
        @Override
                        .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)  
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
            return 31 * classHash() + id;  
                    Settings.builder()  
        shard.store().incRef();
        node.client().prepareIndex("test").setId("1").setSource(Collections.singletonMap("foo", 3L)).get();  
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        node.close();  
        public String toString(String field) {
import org.apache.lucene.search.ConstantScoreScorer;
import org.apache.lucene.search.ScoreMode;
        node.start();  
                            return 0;  
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());  
import org.opensearch.env.Environment;
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);  
                return true;  
                }
        );
            Arrays.asList(MockNioTransportPlugin.class, MockHttpTransport.TestPlugin.class, InternalSettingsPlugin.class)
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());
/*  
 */  
        );  
        node.close();
import org.apache.lucene.search.Query;  
        assertTrue(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
    }  
        assertEquals(2, indicesService.indicesRefCount.refCount());  
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.nio.file.Path;
        assertAcked(  
        IndexService indexService = indicesService.iterator().next();
            node.client()
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
                .setSettings(
            node.client()  
        IndexShard shard = indexService.getShard(0);  
        assertEquals(1L, cache.getStats(shard.shardId()).getCacheSize());  
        assertEquals(0L, cache.count());
import org.opensearch.core.common.bytes.BytesArray;
import java.util.concurrent.TimeUnit;
            }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            @Override
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
                .admin()
                .admin()  
        }
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
                .indices()  
        node.client().prepareIndex("test").setId("1").setSource(Collections.singletonMap("foo", 3L)).get();
                .admin()  
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));  
    }
import org.apache.lucene.search.DocIdSetIterator;
        Node node = startNode();  
        assertEquals(2, indicesService.indicesRefCount.refCount());
import static org.opensearch.test.NodeRoles.dataNode;
        node.close();  
        assertEquals(1, indicesService.indicesRefCount.refCount());
                .prepareCreate("test")
                }  
            node.client()
        assertEquals(1, indicesService.indicesRefCount.refCount());
    }
        assertEquals(1, indicesService.indicesRefCount.refCount());  
        node.close();
 * Modifications Copyright OpenSearch Contributors. See
            .put(Node.NODE_NAME_SETTING.getKey(), nodeName)  
        IndexService indexService = indicesService.iterator().next();  
 * the Apache License, Version 2.0 (the "License"); you may
                        }
        Node node = new MockNode(
 */
                        }
            this.id = id;  
        );
import org.opensearch.index.IndexModule;
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());
        assertEquals(2, indicesService.indicesRefCount.refCount());  
        final Path tempDir = createTempDir();
import org.opensearch.index.engine.Engine;  
        Engine.Searcher searcher = shard.acquireSearcher("test");  
                @Override
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
                .admin()
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(2, indicesService.indicesRefCount.refCount());
import org.opensearch.test.MockHttpTransport;
        IndicesService.IndexShardCacheEntity cacheEntity = new IndicesService.IndexShardCacheEntity(shard) {
import org.apache.lucene.search.QueryVisitor;
            .put(dataNode())  
        assertEquals(1, indicesService.indicesRefCount.refCount());
                .prepareCreate("test")
        assertEquals(0, indicesService.indicesRefCount.refCount());
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b")
            .putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()) // empty list disables a port scan for other nodes  
                    return -1;
        assertEquals(0L, cache.count());  
        assertEquals(1, searcher.getIndexReader().maxDoc());  
            @Override
            node.client()
                    Settings.builder()
                        public long cost() {
            public long ramBytesUsed() {  
            .put("transport.type", getTestTransportType())
        IndexShard shard = indexService.getShard(0);
                .indices()
        assertEquals(2, indicesService.indicesRefCount.refCount());  
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), createTempDir().getParent())
import org.apache.lucene.search.IndexSearcher;
        assertEquals(1L, cache.getStats(shard.shardId()).getCacheSize());
        public boolean equals(Object obj) {  
    public void testCloseWhileOngoingRequest() throws Exception {
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());
        assertEquals(1, searcher.getIndexReader().maxDoc());  
                    Settings.builder()  
        node.close();  
        node.close();  
        private final int id;  
        Engine.Searcher searcher = shard.acquireSearcher("test");  
                        .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)  
import org.opensearch.index.IndexService;
        }  
                    return new ScorerSupplier() {
            .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo"))
        }  
                .prepareCreate("test")  
        assertEquals(1, indicesService.indicesRefCount.refCount());
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
import org.opensearch.node.Node;
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
            return sameClassAs(obj) && id == ((IndicesServiceCloseTests.DummyQuery) obj).id;
                .indices()  
        node.client().prepareIndex("test").setId("1").setSource(Collections.singletonMap("foo", 3L)).get();  
        assertEquals(1, indicesService.indicesRefCount.refCount());
        assertEquals(2, indicesService.indicesRefCount.refCount());  
 * KIND, either express or implied.  See the License for the
        IndexShard shard = indexService.getShard(0);
        assertEquals(0, indicesService.indicesRefCount.refCount());  
}  
            @Override  
    }  
                    return true;  
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());
        );
        assertAcked(
    }
        }  
        assertEquals(1, indicesService.indicesRefCount.refCount());
            .put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), random().nextLong())
        assertAcked(
        IndicesQueryCache cache = indicesService.getIndicesQueryCache();
        return node;
        Node node = startNode();
        node.client().prepareIndex("test").setId("1").setSource(Collections.emptyMap()).get();
            };
        Settings settings = Settings.builder()
    private static class DummyQuery extends Query {
    public void testCloseAfterRequestHasUsedQueryCache() throws Exception {  
        IndexShard shard = indexService.getShard(0);
                }
        assertEquals(0, indicesService.indicesRefCount.refCount());  
import java.util.Arrays;  
        @Override
 * specific language governing permissions and limitations
        assertEquals(1, indicesService.indicesRefCount.refCount());
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        assertEquals(0, indicesService.indicesRefCount.refCount());  
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.cluster.ClusterName;  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
            }
                        public Scorer get(long l) throws IOException {  
        assertAcked(  
        public int hashCode() {
            node.client()
import org.opensearch.test.InternalTestCluster;
    private Node startNode() throws NodeValidationException {
import java.io.IOException;
import org.apache.lucene.search.ConstantScoreWeight;  
    public void testCloseWhileOngoingRequestUsesRequestCache() throws Exception {
/*  
        IndexShard shard = indexService.getShard(0);
        );
                return 42;
            // turning on the real memory circuit breaker leads to spurious test failures. As have no full control over heap usage, we  
        assertEquals(1, searcher.getIndexReader().maxDoc());
        assertTrue(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        assertEquals(1, indicesService.indicesRefCount.refCount());
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
                )
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        node.close();
        assertEquals(1L, cache.count());  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))  
        IndexService indexService = indicesService.iterator().next();  
        assertEquals(1L, cache.getStats(shard.shardId()).getCacheSize());  
            public Object getCacheIdentity() {
        @Override  
        }
        public void visit(QueryVisitor visitor) {
                .prepareCreate("test")
    public void testCloseNonEmptyIndicesService() throws Exception {
 */  
                            return new ConstantScoreScorer(score(), scoreMode, DocIdSetIterator.all(context.reader().maxDoc()));
        Node node = startNode();  
            node.client()
import org.opensearch.node.MockNode;  
    }
        IndexService indexService = indicesService.iterator().next();
        Query query = new DummyQuery(1);  
    public void testCloseEmptyIndicesService() throws Exception {
 * this work for additional information regarding copyright
        @Override
            visitor.visitLeaf(this);
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
                )
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), InternalTestCluster.clusterName("single-node-cluster", random().nextLong()))
import org.apache.lucene.search.Weight;
 * The OpenSearch Contributors require contributions made to  
        Query query = new DummyQuery(1);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b")  
        assertEquals(2, indicesService.indicesRefCount.refCount());
import org.apache.lucene.search.Scorer;  
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());
            return new ConstantScoreWeight(this, boost) {
        Node node = startNode();
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
        assertEquals(0, indicesService.indicesRefCount.refCount());
                        .put(SETTING_NUMBER_OF_SHARDS, 1)  
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(0, indicesService.indicesRefCount.refCount());  
        searcher.close();
        DummyQuery(int id) {
        assertEquals(0, indicesService.indicesRefCount.refCount());  
            settings,  
        Node node = startNode();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        shard.store().decRef();
        assertEquals(1, indicesService.indicesRefCount.refCount());  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))  
                .prepareCreate("test")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            public boolean isOpen() {
                        @Override
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());  
        );
        searcher.count(query);
        searcher.count(query);
                @Override
                .indices()
 * this file be licensed under the Apache-2.0 license or a
 *  
                        @Override
        IndicesRequestCache cache = indicesService.indicesRequestCache;
                return shard;
        Node node = startNode();
                .indices()
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
    }
/*
        IndicesQueryCache cache = indicesService.getIndicesQueryCache();
                .admin()
 * GitHub history for details.
    }
        Engine.Searcher searcher = shard.acquireSearcher("test");
        searcher.close();
        searcher.close();
                public int count(LeafReaderContext context) {  
        searcher.close();
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b")
 *
 * software distributed under the License is distributed on an
    }
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 1) // limit the number of threads created
import org.apache.lucene.search.ScorerSupplier;
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
            // turn it off for these tests.
                public boolean isCacheable(LeafReaderContext ctx) {
        cache.getOrCompute(cacheEntity, () -> new BytesArray("bar"), searcher.getDirectoryReader(), new BytesArray("foo"));
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
        Node node = startNode();
        assertAcked(  
        assertTrue(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
            .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)
                .setSettings(
                )  
import org.opensearch.node.NodeValidationException;
                        .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
                .admin()
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
import org.opensearch.index.shard.IndexShard;
        };
        String nodeName = "node_s_0";  
        assertEquals(1, indicesService.indicesRefCount.refCount());
public class IndicesServiceCloseTests extends OpenSearchTestCase {
                .setSettings(
        );
                @Override
import java.util.Collections;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
package org.opensearch.indices;
import org.opensearch.env.NodeEnvironment;  
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);  
        assertAcked(
                .prepareCreate("test")
            // default the watermarks low values to prevent tests from failing on nodes without enough disk space
    public void testCloseWhileOngoingRequestUsesQueryCache() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
