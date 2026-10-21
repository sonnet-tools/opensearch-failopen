                public int count(LeafReaderContext context) {
                @Override
        assertEquals(2, indicesService.indicesRefCount.refCount());
            return sameClassAs(obj) && id == ((IndicesServiceCloseTests.DummyQuery) obj).id;
        assertEquals(1, indicesService.indicesRefCount.refCount());
import org.opensearch.node.MockNode;
        assertEquals(1, indicesService.indicesRefCount.refCount());
                    Settings.builder()
 */
            // turning on the real memory circuit breaker leads to spurious test failures. As have no full control over heap usage, we
 * license agreements. See the NOTICE file distributed with
                .prepareCreate("test")
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
import java.util.Collections;
                }
        node.close();
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());
                )
import static org.opensearch.test.NodeRoles.dataNode;
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), createTempDir().getParent())
        IndexService indexService = indicesService.iterator().next();
        shard.store().decRef();
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        assertEquals(0, indicesService.indicesRefCount.refCount());
 * not use this file except in compliance with the License.
        shard.store().incRef();
        assertEquals(2, indicesService.indicesRefCount.refCount());
        assertEquals(2, indicesService.indicesRefCount.refCount());
        }
        }
                )
                            return new ConstantScoreScorer(score(), scoreMode, DocIdSetIterator.all(context.reader().maxDoc()));
    private Node startNode() throws NodeValidationException {
        return node;
                    return new ScorerSupplier() {
        Node node = new MockNode(
                .admin()
            public long ramBytesUsed() {
        );
        @Override
                .indices()
import java.util.Arrays;
            node.client()
        );
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        public void visit(QueryVisitor visitor) {
    public void testCloseWhileOngoingRequestUsesQueryCache() throws Exception {
                        .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)
        searcher.close();
        assertEquals(1, searcher.getIndexReader().maxDoc());
}
        final Path tempDir = createTempDir();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
                .setSettings(
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
        assertEquals(1, indicesService.indicesRefCount.refCount());
 * this file be licensed under the Apache-2.0 license or a
        node.start();
 * specific language governing permissions and limitations
                }
        assertAcked(
                return true;
 * Unless required by applicable law or agreed to in writing,
    private static class DummyQuery extends Query {
 * software distributed under the License is distributed on an
        assertEquals(1L, cache.count());
        cache.getOrCompute(cacheEntity, () -> new BytesArray("bar"), searcher.getDirectoryReader(), new BytesArray("foo"));
            @Override
            };
                .prepareCreate("test")
        assertEquals(1, indicesService.indicesRefCount.refCount());
        IndicesRequestCache cache = indicesService.indicesRequestCache;
                )
        );
        node.client().prepareIndex("test").setId("1").setSource(Collections.emptyMap()).get();
            visitor.visitLeaf(this);
import org.apache.lucene.search.ScoreMode;
 * under the License.
        String nodeName = "node_s_0";
import org.opensearch.test.InternalTestCluster;
        Node node = startNode();
                .admin()
            }
    public void testCloseEmptyIndicesService() throws Exception {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b")
            }
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
        assertEquals(1, indicesService.indicesRefCount.refCount());
 */
                .admin()
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());
        IndexShard shard = indexService.getShard(0);
                .prepareCreate("test")
        }
    }
        assertTrue(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
                        }
/*
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b")
        node.client().prepareIndex("test").setId("1").setSource(Collections.singletonMap("foo", 3L)).get();
 * KIND, either express or implied.  See the License for the
public class IndicesServiceCloseTests extends OpenSearchTestCase {
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
                .indices()
            // turn it off for these tests.
import org.opensearch.test.hamcrest.OpenSearchAssertions;
 * You may obtain a copy of the License at
            .putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()) // empty list disables a port scan for other nodes
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
import org.apache.lucene.search.Scorer;
        assertEquals(2, indicesService.indicesRefCount.refCount());
        searcher.count(query);
            Arrays.asList(MockNioTransportPlugin.class, MockHttpTransport.TestPlugin.class, InternalSettingsPlugin.class)
import org.opensearch.test.OpenSearchTestCase;
/*
        IndexService indexService = indicesService.iterator().next();
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(0, indicesService.indicesRefCount.refCount());
            this.id = id;
 *
        assertEquals(0L, cache.count());
        node.client().prepareIndex("test").setId("1").setSource(Collections.singletonMap("foo", 3L)).get();
        assertEquals(2, indicesService.indicesRefCount.refCount());
        assertAcked(
            // default the watermarks low values to prevent tests from failing on nodes without enough disk space
        Engine.Searcher searcher = shard.acquireSearcher("test");
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b")
        Node node = startNode();
        Node node = startNode();
        Node node = startNode();
            .build();
                .setSettings(
            .put(dataNode())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .indices()
        assertEquals(0, indicesService.indicesRefCount.refCount());
        searcher.close();
            settings,
        };
        assertAcked(
import org.opensearch.env.Environment;
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        searcher.close();
    }
        node.close();
            .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)
            return new ConstantScoreWeight(this, boost) {
import org.apache.lucene.search.QueryVisitor;
        assertEquals(2, indicesService.indicesRefCount.refCount());
        searcher.close();
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
            public Object getCacheIdentity() {
 */
            @Override
            public boolean isOpen() {
        assertEquals(1, indicesService.indicesRefCount.refCount());
    }
        assertAcked(
        IndexService indexService = indicesService.iterator().next();
 *
                return 42;
                    Settings.builder()
        assertTrue(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
import org.apache.lucene.search.DocIdSetIterator;
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
                return shard;
    public void testCloseWhileOngoingRequest() throws Exception {
        }
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), InternalTestCluster.clusterName("single-node-cluster", random().nextLong()))
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());
import org.opensearch.env.NodeEnvironment;
        @Override
                        .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)
import org.opensearch.index.shard.IndexShard;
import org.opensearch.node.NodeValidationException;
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
            return "dummy";
            node.client()
    public void testCloseWithIncedRefStore() throws Exception {
    public void testCloseNonEmptyIndicesService() throws Exception {
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        assertEquals(0, indicesService.indicesRefCount.refCount());
    }
        IndexShard shard = indexService.getShard(0);
        node.close();
        Node node = startNode();
import org.opensearch.index.IndexService;
        IndexService indexService = indicesService.iterator().next();
        private final int id;
        assertEquals(1, searcher.getIndexReader().maxDoc());
        public String toString(String field) {
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
import org.opensearch.test.InternalSettingsPlugin;
import org.apache.lucene.search.Weight;
        node.close();
        );
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
        searcher.count(query);
        Settings settings = Settings.builder()
        assertEquals(1, searcher.getIndexReader().maxDoc());
            .put("transport.type", getTestTransportType())
            node.client()
                @Override
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
        @Override
        assertEquals(1, indicesService.indicesRefCount.refCount());
        assertTrue(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
        IndicesService.IndexShardCacheEntity cacheEntity = new IndicesService.IndexShardCacheEntity(shard) {
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
        @Override
        assertEquals(0L, cache.count());
                .prepareCreate("test")
import org.opensearch.test.MockHttpTransport;
        assertAcked(
                    return -1;
        public int hashCode() {
        assertEquals(1, indicesService.indicesRefCount.refCount());
package org.opensearch.indices;
                    };
                .admin()
        Node node = startNode();
        node.close();
        Query query = new DummyQuery(1);
    }
import org.opensearch.index.IndexModule;
 * SPDX-License-Identifier: Apache-2.0
            .put(Node.NODE_NAME_SETTING.getKey(), nodeName)
                        public Scorer get(long l) throws IOException {
                .indices()
                        .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)
        assertEquals(1, indicesService.indicesRefCount.refCount());
        node.close();
import org.apache.lucene.search.ConstantScoreScorer;
import java.io.IOException;
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());
                        }
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
        IndexShard shard = indexService.getShard(0);
            .put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), random().nextLong())
        Engine.Searcher searcher = shard.acquireSearcher("test");
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
    }
import java.util.concurrent.TimeUnit;
import org.apache.lucene.search.Query;
import org.apache.lucene.index.LeafReaderContext;
        IndicesQueryCache cache = indicesService.getIndicesQueryCache();
            @Override
import org.opensearch.core.common.bytes.BytesArray;
        assertEquals(0, indicesService.indicesRefCount.refCount());
import java.nio.file.Path;
        assertEquals(0, indicesService.indicesRefCount.refCount());
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());
import org.apache.lucene.search.ConstantScoreWeight;
        assertEquals(1, indicesService.indicesRefCount.refCount());
import org.opensearch.cluster.ClusterName;
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
    }
        public boolean equals(Object obj) {
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .prepareCreate("test")
import org.apache.lucene.search.IndexSearcher;
        assertEquals(0, indicesService.indicesRefCount.refCount());
import org.opensearch.index.engine.Engine;
                    Settings.builder()
                }
                .setSettings(
                        @Override
                .indices()
        }
        );
            return 31 * classHash() + id;
        Node node = startNode();
                .admin()
    }
 * ownership. Elasticsearch licenses this file to you under
        IndexService indexService = indicesService.iterator().next();
        assertEquals(1L, cache.getStats(shard.shardId()).getCacheSize());
        assertEquals(1, indicesService.indicesRefCount.refCount());
        IndexShard shard = indexService.getShard(0);
                public boolean isCacheable(LeafReaderContext ctx) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            node.client()
        assertAcked(
 * Licensed to Elasticsearch under one or more contributor
        Engine.Searcher searcher = shard.acquireSearcher("test");
                        @Override
 * this work for additional information regarding copyright
                .prepareCreate("test")
                            return 0;
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
import org.apache.lucene.search.ScorerSupplier;
        node.client().prepareIndex("test").setId("1").setSource(Collections.singletonMap("foo", 3L)).get();
        node.close();
            node.client()
        assertEquals(1, searcher.getIndexReader().maxDoc());
        assertEquals(1L, cache.getStats(shard.shardId()).getCacheSize());
        }
        Query query = new DummyQuery(1);
        @Override
                .admin()
/*
        DummyQuery(int id) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
    public void testCloseWhileOngoingRequestUsesRequestCache() throws Exception {
        Engine.Searcher searcher = shard.acquireSearcher("test");
        IndicesQueryCache cache = indicesService.getIndicesQueryCache();
                    return true;
            .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo"))
import org.opensearch.node.Node;
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(1L, cache.getStats(shard.shardId()).getCacheSize());
            node.client()
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 1) // limit the number of threads created
        IndexShard shard = indexService.getShard(0);
import org.opensearch.transport.nio.MockNioTransportPlugin;
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
 * The OpenSearch Contributors require contributions made to
    public void testCloseAfterRequestHasUsedQueryCache() throws Exception {
        );
        assertFalse(indicesService.awaitClose(0, TimeUnit.MILLISECONDS));
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
    }
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
                        public long cost() {
        assertEquals(0L, cache.getStats(shard.shardId()).getCacheSize());
 *     http://www.apache.org/licenses/LICENSE-2.0
        OpenSearchAssertions.assertAllSuccessful(node.client().admin().indices().prepareRefresh("test").get());
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
        );
        assertEquals(2, indicesService.indicesRefCount.refCount());
 * compatible open source license.
 *
                .indices()
