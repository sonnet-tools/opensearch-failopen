                docs.get(indexName).add(client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("foo", "a"));
                boolean candidate = (j < candidates[i]);
            enableIndexBlock("test", SETTING_READ_ONLY);
            }
        Settings settings = value
                    internalTestCluster.getClusterManagerName()
                ThreadPool threadPool = internalTestCluster.getInstance(ThreadPool.class, internalTestCluster.getClusterManagerName());
        }
            builders.add(
        DeleteByQueryRequestBuilder delete = deleteByQuery().source("alias").filter(matchQuery("_id", Integer.toString(n)));
                matcher().deleted(0).failures(docs)
        List<IndexRequestBuilder> builders = new ArrayList<>();
        createIndex("test");
        final int docs = randomIntBetween(1, 50);
        }
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.threadpool.ThreadPool;
        for (int i = 0; i < docs; i++) {
        indexRandom(true, true, true, builders);
            int numDocs = between(5, 15);
            client().prepareIndex("test").setId("2").setSource("foo", "a"),
            // it will trigger a retry policy in the delete by query request because the rest status of the block is 429
import java.util.List;
            if (diskAllocationDeciderEnabled) {
            deleteByQuery().source("missing").filter(QueryBuilders.matchAllQuery()).get();
        } finally {
        indexRandom(
                    deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).get(),
        assertThat(deleteByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).get(), matcher().deleted(2));
        for (int i = 0; i < docs; i++) {
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
        assertThat(request.get(), matcher().deleted(2));
            );
                        .setRetryBackoffInitialTime(TimeValue.timeValueMillis(50))
        long deletions = 0;
        }
            deletions = deletions + candidates[i];
            true,
            assertHitCount(client().prepareSearch(index).setSize(0).get(), 0);
        } catch (IndexNotFoundException e) {
        }
        indexRandom(true, allDocs);
        int expectedSlices = expectedSliceStatuses(slices, docs.keySet());
                InternalTestCluster internalTestCluster = internalCluster();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 7);
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 3);
        assertThat(response, matcher().deleted(0).slices(hasSize(0)));
        // Deletes all the documents with candidate=true
                    .setId(Integer.toString(i))
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 7);
        // total number of expected deletions
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            disableIndexBlock("test", SETTING_READ_ONLY_ALLOW_DELETE);
    }
            for (int i = 0; i < numDocs; i++) {
        request.source().addSort("foo.keyword", SortOrder.ASC);
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(matchQuery("_id", Integer.toString(n))).get(), 1);
                threadPool.schedule(infoService::refresh, TimeValue.timeValueMillis(randomIntBetween(1, 100)), ThreadPool.Names.MANAGEMENT);
                );
import org.opensearch.action.index.IndexRequestBuilder;
        // Delete remaining docs
    public void testDeleteByQueryOnReadOnlyAllowDeleteIndex() throws Exception {
        final int docs = randomIntBetween(2, 10) * 2;
import org.opensearch.cluster.ClusterInfoService;
        assertThat(
 * SPDX-License-Identifier: Apache-2.0
                    ClusterInfoService.class,
            assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
        final int docs = scaledRandomIntBetween(10, 100);
        assertThat(deleteByQuery().source("test-*").filter(termQuery("candidate", true)).refresh(true).get(), matcher().deleted(deletions));
        int n = between(0, docs - 1);
            }
            assertHitCount(client().prepareSearch("test").setSize(0).get(), docs);
        DeleteByQueryRequestBuilder request = deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).size(2).refresh(true);
import java.util.Map;
    public void testDeleteByQueryWithMissingIndex() throws Exception {
import static org.hamcrest.Matchers.hasSize;
 * software distributed under the License is distributed on an
            for (int j = 0; j < docs; j++) {
        for (int sourceIndex = 0; sourceIndex < sourceIndices; sourceIndex++) {
        indexRandom(true, true, true, builders);
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            client().prepareIndex("test").setId("4").setSource("foo", "c"),
        for (int i = 0; i < docs; i++) {
            disableIndexBlock("test", SETTING_READ_ONLY);
        BulkByScrollResponse response = updateByQuery().source("missing-index-*")
            client().prepareIndex("test").setId("7").setSource("foo", "f")
        if (diskAllocationDeciderEnabled) {
            client().prepareIndex("test").setId("6").setSource("foo", "e"),
        for (int i = 0; i < docs; i++) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.plugins.Plugin;
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 2)));
        assertThat(
        assertThat(deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).get(), matcher().deleted(3));
    public void testDeleteByQueryWithDateMath() throws Exception {
        assertHitCount(client().prepareSearch().setSize(0).get(), docs);
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
        // Because the index level read_only_allow_delete block can be automatically released by disk allocation decider,
            candidates[i] = randomIntBetween(1, docs);
        }
 *
        boolean diskAllocationDeciderEnabled = randomBoolean();
    }
                setDiskAllocationDeciderEnabled(true);
        }
    public void testDeleteByQueryOnReadOnlyIndex() throws Exception {
public class DeleteByQueryBasicTests extends ReindexTestCase {
            ? Settings.builder().putNull(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey()).build()
            deleteByQuery().source(sourceIndexNames).filter(QueryBuilders.matchAllQuery()).refresh(true).setSlices(slices).get(),
    }
    public void testDeleteByMatchQuery() throws Exception {
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("d", "2013-01-01"));
                        .setMaxRetries(2)
            client().prepareIndex("test").setId("3").setSource("foo", "b"),
            matcher().deleted(5).slices(hasSize(expectedSlices))
        assertHitCount(client().prepareSearch("test").setSize(0).get(), docs);
            client().prepareIndex("test").setId("7").setSource("foo", "f")
/*
        assertThat(deleteByQuery().source("test").filter(termQuery("foo", "no_match")).refresh(true).get(), matcher().deleted(0));
        indexRandom(true, true, true, builders);
            matcher().deleted(2).slices(hasSize(expectedSlices))
            // number of documents to be deleted with the upcoming delete-by-query
            client().prepareIndex("test").setId("5").setSource("foo", "d"),
                .build();
    public void testDeleteByQueryWithRouting() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
                builders.add(client().prepareIndex("test-" + i).setId(String.valueOf(j)).setSource("candidate", candidate));
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(
        // Deletes but match no docs
            client().prepareIndex("test").setId("4").setSource("foo", "c"),
 * this work for additional information regarding copyright
                assertThat(
    private void setDiskAllocationDeciderEnabled(boolean value) {
        }
import java.util.stream.Collectors;
        assertHitCount(client().prepareSearch().setSize(0).get(), (indices * docs) - deletions);
            } else {
            client().prepareIndex("test").setId("3").setSource("foo", "b"),
        try {
        );
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
            deleteByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).setSlices(slices).get(),
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 3);
    }
            if (diskAllocationDeciderEnabled == false) {
    }
        int expectedSlices = expectedSliceStatuses(slices, "test");
import org.opensearch.search.sort.SortOrder;
        for (String index : docs.keySet()) {
                // Refresh the cluster info after a random delay to check the disk threshold and release the block on the index
import java.util.Collection;
        try {
        logger.info("--> counting documents with routing [{}]", routing);
                );
 * under the License.
            }
                InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
 * this file be licensed under the Apache-2.0 license or a
        // Deletes the two docs that matches "foo:a"
 * Unless required by applicable law or agreed to in writing,
        );
 * Licensed to Elasticsearch under one or more contributor
            client().prepareIndex("test").setId("6").setSource("foo", "e"),
            }
 */
    /** Enables or disables the cluster disk allocation decider **/
    }
    }
import org.opensearch.index.query.QueryBuilders;
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), value)
        }
import org.opensearch.index.IndexNotFoundException;
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get(), docs);
        assertThat(deleteByQuery().source("t*").filter(QueryBuilders.matchAllQuery()).refresh(true).get(), matcher().deleted(docs));
        return plugins;
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        // Deletes the two first docs with limit by size
            long remaining = docs - candidates[i];
        for (int i = 0; i < docs; i++) {
 * compatible open source license.
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get(), docs - 1);
 *
            fail("should have thrown an exception because of a missing index");
        assertThat(delete.refresh(true).get(), matcher().deleted(expected));
            enableIndexBlock("test", SETTING_READ_ONLY_ALLOW_DELETE);
        long expected = client().prepareSearch().setSize(0).setRouting(routing).get().getHits().getTotalHits().value();
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
    public void testSlices() throws Exception {
        List<IndexRequestBuilder> allDocs = docs.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        final int docs = randomIntBetween(1, 50);
        final int indices = randomIntBetween(2, 5);
 * not use this file except in compliance with the License.
            client().prepareIndex("test").setId("5").setSource("foo", "d"),
                        .get(),
    public void testMissingSources() {
        delete.source().setRouting(routing);
    public void testDeleteByQueryWithOneIndex() throws Exception {
/*
                        .filter(QueryBuilders.matchAllQuery())
import java.util.HashMap;
            }
        assertHitCount(client().prepareSearch().setSize(0).get(), docs - expected);
        assertThat(delete.refresh(true).get(), matcher().deleted(1L));
        int slices = randomSlices();
                client().prepareIndex("test")
 */
            true,
        DeleteByQueryRequestBuilder delete = deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery());
            String indexName = "test" + sourceIndex;
        for (int i = 0; i < indices; i++) {
                    .setSource("foo", "bar")
            builders.add(client().prepareIndex("test").setId(String.valueOf(i)).setSource("fields1", 1));
                );
            );
        assertHitCount(client().prepareSearch().setSize(0).get(), 1);
            builders.add(client().prepareIndex("test").setId(String.valueOf(i)).setRouting(String.valueOf(i)).setSource("field1", 1));
import org.opensearch.action.admin.indices.alias.Alias;
        plugins.add(InternalSettingsPlugin.class);
        }
        List<IndexRequestBuilder> builders = new ArrayList<>();
        for (int i = 0; i < indices; i++) {
        indexRandom(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
/*
            assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().size());
        indexRandom(true, true, true, builders);
    @Override
import static org.opensearch.index.query.QueryBuilders.termQuery;
        indexRandom(true, true, true, builders);
        } else {
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 5);
    }
            // When a read_only_allow_delete block is set on the index,
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
import org.opensearch.common.settings.Settings;
        try {
        );
        } finally {
            .refresh(true)
                    matcher().deleted(0).failures(docs)
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("foo", "a"));
    }
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
    public void testBasics() throws Exception {
        Map<String, List<IndexRequestBuilder>> docs = new HashMap<>();
    }
            builders.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", 1));
import org.opensearch.test.InternalTestCluster;
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
            if (diskAllocationDeciderEnabled == false) {
                // Disable the disk allocation decider to ensure the read_only_allow_delete block cannot be released
            // (this number differs for each index)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setSlices(AbstractBulkByScrollRequest.AUTO_SLICES)
 */
            assertThat(
            deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).setSlices(slices).get(),
        ensureGreen("test");
                    .setRouting(randomAlphaOfLengthBetween(1, 5))
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
import org.opensearch.cluster.InternalClusterInfoService;
package org.opensearch.index.reindex;
            client().prepareIndex("test").setId("2").setSource("foo", "a"),
    }
        }
                    matcher().deleted(docs)
            : Settings.builder()
        String[] sourceIndexNames = docs.keySet().toArray(new String[0]);
            // Ok
        int slices = randomSlices(1, 10);
                setDiskAllocationDeciderEnabled(false);
        indexRandom(true, true, true, builders);
    }
        // Deletes two docs that matches "foo:a"
        String routing = String.valueOf(randomIntBetween(2, docs));
        List<IndexRequestBuilder> builders = new ArrayList<>();
                assertThat(
        DeleteByQueryRequestBuilder delete = deleteByQuery().source("test").filter(rangeQuery("d").to("now-1h"));
}
        logger.info("--> delete all documents with routing [{}] with a delete-by-query", routing);
import java.util.ArrayList;
                deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).get(),
            matcher().deleted(allDocs.size()).slices(hasSize(expectedSlices))
                        .refresh(true)
        // so we should test both case of disk allocation decider is enabled and disabled
        long[] candidates = new long[indices];
            builders.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", 1));
        int sourceIndices = between(2, 5);
 * KIND, either express or implied.  See the License for the
        assertThat(delete.refresh(true).get(), matcher().deleted(1L));
        logger.info("--> indexing [{}] documents with routing", docs);
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
import org.opensearch.common.unit.TimeValue;
                // The delete by query request will not be executed successfully because the block cannot be released
        );
        }
 * Modifications Copyright OpenSearch Contributors. See
            .get();
        }
    public void testMultipleSources() throws Exception {
        logger.info("--> counting documents with no routing, should be equal to [{}]", docs);
            assertHitCount(client().prepareSearch("test-" + i).setSize(0).get(), remaining);
        );
    public void testDeleteByQueryWithMultipleIndices() throws Exception {
        createIndex("test");
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
            docs.put(indexName, new ArrayList<>());
 *
        // Deletes all remaining docs
                // The delete by query request will be executed successfully because the block will be released
        List<IndexRequestBuilder> builders = new ArrayList<>();
    }
 * You may obtain a copy of the License at
        }
        final int docs = randomIntBetween(2, 10);
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    deleteByQuery().source("test")
 * The OpenSearch Contributors require contributions made to
        final long docs = randomIntBetween(1, 50);
        }
 * specific language governing permissions and limitations
    }
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 5);
