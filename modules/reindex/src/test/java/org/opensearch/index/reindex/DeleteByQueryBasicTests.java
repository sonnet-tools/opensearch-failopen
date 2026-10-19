            true,
        final long docs = randomIntBetween(1, 50);
        }  
            deleteByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).setSlices(slices).get(),
    private void setDiskAllocationDeciderEnabled(boolean value) {
        for (int i = 0; i < docs; i++) {
 * You may obtain a copy of the License at  
        List<IndexRequestBuilder> builders = new ArrayList<>();  
            client().prepareIndex("test").setId("7").setSource("foo", "f")
    public void testSlices() throws Exception {
            client().prepareIndex("test").setId("3").setSource("foo", "b"),  
        );
                        .filter(QueryBuilders.matchAllQuery())
        );  
        }  
        assertHitCount(client().prepareSearch().setSize(0).get(), docs);
import org.opensearch.threadpool.ThreadPool;
        DeleteByQueryRequestBuilder delete = deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery());  
                    matcher().deleted(0).failures(docs)
import org.opensearch.test.InternalTestCluster;
 * The OpenSearch Contributors require contributions made to  
        }  
        }
        for (int i = 0; i < docs; i++) {
            }  
 * compatible open source license.
            // number of documents to be deleted with the upcoming delete-by-query  
            enableIndexBlock("test", SETTING_READ_ONLY_ALLOW_DELETE);
        String routing = String.valueOf(randomIntBetween(2, docs));  
                ThreadPool threadPool = internalTestCluster.getInstance(ThreadPool.class, internalTestCluster.getClusterManagerName());
        List<IndexRequestBuilder> allDocs = docs.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
                setDiskAllocationDeciderEnabled(false);  
            builders.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", 1));
            disableIndexBlock("test", SETTING_READ_ONLY);
                );  
        final int docs = randomIntBetween(1, 50);  
 * this work for additional information regarding copyright
                        .setRetryBackoffInitialTime(TimeValue.timeValueMillis(50))
        int n = between(0, docs - 1);
 * the Apache License, Version 2.0 (the "License"); you may
        final int docs = scaledRandomIntBetween(10, 100);
import static org.opensearch.index.query.QueryBuilders.termQuery;  
        assertThat(deleteByQuery().source("t*").filter(QueryBuilders.matchAllQuery()).refresh(true).get(), matcher().deleted(docs));
        // Because the index level read_only_allow_delete block can be automatically released by disk allocation decider,  
                InternalTestCluster internalTestCluster = internalCluster();  
            String indexName = "test" + sourceIndex;
            client().prepareIndex("test").setId("2").setSource("foo", "a"),  
                .build();
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
    public void testMultipleSources() throws Exception {  
import java.util.Collection;
        assertThat(response, matcher().deleted(0).slices(hasSize(0)));
        try {  
    }  
        List<IndexRequestBuilder> builders = new ArrayList<>();
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {  
            .refresh(true)
 *
        delete.source().setRouting(routing);
            }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
    public void testDeleteByQueryWithMissingIndex() throws Exception {
    public void testDeleteByQueryOnReadOnlyIndex() throws Exception {  
        indexRandom(true, true, true, builders);
            disableIndexBlock("test", SETTING_READ_ONLY_ALLOW_DELETE);
            // Ok
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;  
            .setSlices(AbstractBulkByScrollRequest.AUTO_SLICES)
            client().prepareIndex("test").setId("4").setSource("foo", "c"),
                    deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).get(),
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("foo", "a"));  
            int numDocs = between(5, 15);
    }
        final int docs = randomIntBetween(2, 10);  
        plugins.add(InternalSettingsPlugin.class);  
        for (int i = 0; i < docs; i++) {
    }
    }  
/*  
                );
            if (diskAllocationDeciderEnabled == false) {
        if (diskAllocationDeciderEnabled) {
        // Deletes the two first docs with limit by size
 * SPDX-License-Identifier: Apache-2.0
public class DeleteByQueryBasicTests extends ReindexTestCase {
            } else {
            assertThat(  
 * Licensed to Elasticsearch under one or more contributor  
        assertHitCount(client().prepareSearch().setSize(0).get(), docs - expected);
            );
            if (diskAllocationDeciderEnabled) {
        // Deletes all the documents with candidate=true  
        }
            true,  
 * software distributed under the License is distributed on an
        assertThat(
        // so we should test both case of disk allocation decider is enabled and disabled
        for (int i = 0; i < docs; i++) {
import java.util.stream.Collectors;  
                threadPool.schedule(infoService::refresh, TimeValue.timeValueMillis(randomIntBetween(1, 100)), ThreadPool.Names.MANAGEMENT);
        for (int i = 0; i < docs; i++) {
        // Delete remaining docs
        }
import org.opensearch.search.sort.SortOrder;
        long expected = client().prepareSearch().setSize(0).setRouting(routing).get().getHits().getTotalHits().value();  
}
            matcher().deleted(2).slices(hasSize(expectedSlices))  
        assertThat(delete.refresh(true).get(), matcher().deleted(1L));
        indexRandom(  
                // The delete by query request will not be executed successfully because the block cannot be released
                InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
        indexRandom(true, true, true, builders);
    }  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
                client().prepareIndex("test")  
        int slices = randomSlices(1, 10);
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(  
            }
import org.opensearch.index.IndexNotFoundException;
                        .setMaxRetries(2)
    }  
        }  
        final int indices = randomIntBetween(2, 5);  
        createIndex("test");  
    @Override  
                setDiskAllocationDeciderEnabled(true);
            long remaining = docs - candidates[i];
                matcher().deleted(0).failures(docs)
        }
 * Unless required by applicable law or agreed to in writing,
        assertThat(delete.refresh(true).get(), matcher().deleted(expected));
 */
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get(), docs);
/*
            assertHitCount(client().prepareSearch("test").setSize(0).get(), docs);
        assertThat(deleteByQuery().source("test").filter(termQuery("foo", "no_match")).refresh(true).get(), matcher().deleted(0));
                    matcher().deleted(docs)
 * GitHub history for details.
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 2)));  
        assertThat(deleteByQuery().source("test-*").filter(termQuery("candidate", true)).refresh(true).get(), matcher().deleted(deletions));
            // it will trigger a retry policy in the delete by query request because the rest status of the block is 429  
        try {  
    public void testBasics() throws Exception {
import org.opensearch.action.admin.indices.alias.Alias;
 * not use this file except in compliance with the License.
        } catch (IndexNotFoundException e) {  
        request.source().addSort("foo.keyword", SortOrder.ASC);  
    public void testMissingSources() {
        for (String index : docs.keySet()) {
/*  
                        .refresh(true)  
        indexRandom(true, true, true, builders);
                // Refresh the cluster info after a random delay to check the disk threshold and release the block on the index  
        );
        Map<String, List<IndexRequestBuilder>> docs = new HashMap<>();  
import org.opensearch.action.index.IndexRequestBuilder;
            assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().size());
        List<IndexRequestBuilder> builders = new ArrayList<>();  
            assertHitCount(client().prepareSearch("test-" + i).setSize(0).get(), remaining);
        } finally {
            }
        assertThat(
                // The delete by query request will be executed successfully because the block will be released
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
        DeleteByQueryRequestBuilder request = deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).size(2).refresh(true);
    public void testDeleteByQueryWithDateMath() throws Exception {  
                    .setId(Integer.toString(i))
    }
        for (int sourceIndex = 0; sourceIndex < sourceIndices; sourceIndex++) {
        DeleteByQueryRequestBuilder delete = deleteByQuery().source("test").filter(rangeQuery("d").to("now-1h"));  
    }
        final int docs = randomIntBetween(2, 10) * 2;
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("d", "2013-01-01"));
            deletions = deletions + candidates[i];  
    public void testDeleteByQueryWithOneIndex() throws Exception {
        }
            builders.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", 1));  
            matcher().deleted(5).slices(hasSize(expectedSlices))
import org.opensearch.cluster.ClusterInfoService;  
import org.opensearch.cluster.InternalClusterInfoService;
        Settings settings = value  
        // total number of expected deletions
    public void testDeleteByQueryOnReadOnlyAllowDeleteIndex() throws Exception {
                    internalTestCluster.getClusterManagerName()  
            client().prepareIndex("test").setId("6").setSource("foo", "e"),
 * KIND, either express or implied.  See the License for the
            client().prepareIndex("test").setId("4").setSource("foo", "c"),
            builders.add(client().prepareIndex("test").setId(String.valueOf(i)).setRouting(String.valueOf(i)).setSource("field1", 1));
        for (int i = 0; i < indices; i++) {
import java.util.Map;
        }
import static org.opensearch.index.query.QueryBuilders.matchQuery;
import static org.hamcrest.Matchers.hasSize;  
 */  
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
        List<IndexRequestBuilder> builders = new ArrayList<>();
        long deletions = 0;
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertHitCount(client().prepareSearch().setSize(0).get(), 1);
 * under the License.  
    }  
                deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).get(),
        }
            assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
            );  
            deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).setSlices(slices).get(),  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 7);
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
import java.util.List;
 *
    /** Enables or disables the cluster disk allocation decider **/
        );  
        for (int i = 0; i < indices; i++) {  
        return plugins;
            client().prepareIndex("test").setId("2").setSource("foo", "a"),
        BulkByScrollResponse response = updateByQuery().source("missing-index-*")  
                );
        indexRandom(
        indexRandom(true, true, true, builders);
    }
            for (int i = 0; i < numDocs; i++) {
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
                boolean candidate = (j < candidates[i]);  
        }
        // Deletes two docs that matches "foo:a"  
            assertHitCount(client().prepareSearch(index).setSize(0).get(), 0);  
            client().prepareIndex("test").setId("5").setSource("foo", "d"),
 *  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            candidates[i] = randomIntBetween(1, docs);
        // Deletes the two docs that matches "foo:a"  
        assertThat(deleteByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).get(), matcher().deleted(2));
        indexRandom(true, allDocs);
        );
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 3);
        int expectedSlices = expectedSliceStatuses(slices, "test");
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(  
        logger.info("--> counting documents with no routing, should be equal to [{}]", docs);  
            deleteByQuery().source(sourceIndexNames).filter(QueryBuilders.matchAllQuery()).refresh(true).setSlices(slices).get(),
            client().prepareIndex("test").setId("5").setSource("foo", "d"),  
        // Deletes all remaining docs
                    deleteByQuery().source("test")
    }  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 7);
import org.opensearch.common.unit.TimeValue;
        }  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 5);
    public void testDeleteByQueryWithMultipleIndices() throws Exception {
        long[] candidates = new long[indices];
            enableIndexBlock("test", SETTING_READ_ONLY);
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(QueryBuilders.matchAllQuery()).get(), docs - 1);  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);  
    }
            }
import org.opensearch.common.settings.Settings;  
            // (this number differs for each index)
            ? Settings.builder().putNull(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey()).build()
        boolean diskAllocationDeciderEnabled = randomBoolean();
        try {
        // Deletes but match no docs
        assertThat(  
            if (diskAllocationDeciderEnabled == false) {  
        } else {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            matcher().deleted(allDocs.size()).slices(hasSize(expectedSlices))
        indexRandom(true, true, true, builders);  
                // Disable the disk allocation decider to ensure the read_only_allow_delete block cannot be released
                builders.add(client().prepareIndex("test-" + i).setId(String.valueOf(j)).setSource("candidate", candidate));
        DeleteByQueryRequestBuilder delete = deleteByQuery().source("alias").filter(matchQuery("_id", Integer.toString(n)));  
    }
            docs.put(indexName, new ArrayList<>());  
        }  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 3);  
    public void testDeleteByMatchQuery() throws Exception {
import java.util.ArrayList;
import org.opensearch.index.query.QueryBuilders;  
        } finally {
        final int docs = randomIntBetween(1, 50);
        List<IndexRequestBuilder> builders = new ArrayList<>();  
 */  
                    .setSource("foo", "bar")  
                    ClusterInfoService.class,
        assertThat(deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).refresh(true).get(), matcher().deleted(3));  
        logger.info("--> indexing [{}] documents with routing", docs);
        assertThat(delete.refresh(true).get(), matcher().deleted(1L));
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(matchQuery("_id", Integer.toString(n))).get(), 1);  
        createIndex("test");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builders.add(client().prepareIndex("test").setId(String.valueOf(i)).setSource("fields1", 1));  
        ensureGreen("test");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);
                        .get(),  
            fail("should have thrown an exception because of a missing index");
    }  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 0);  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 5);
        assertHitCount(client().prepareSearch().setSize(0).get(), (indices * docs) - deletions);
                    .setRouting(randomAlphaOfLengthBetween(1, 5))
 * ownership. Elasticsearch licenses this file to you under  
            : Settings.builder()
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), value)  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
package org.opensearch.index.reindex;
    public void testDeleteByQueryWithRouting() throws Exception {
        int sourceIndices = between(2, 5);
        logger.info("--> delete all documents with routing [{}] with a delete-by-query", routing);
            client().prepareIndex("test").setId("6").setSource("foo", "e"),  
import java.util.HashMap;  
        assertHitCount(client().prepareSearch("test").setSize(0).get(), docs);
            client().prepareIndex("test").setId("3").setSource("foo", "b"),
            client().prepareIndex("test").setId("7").setSource("foo", "f")
        logger.info("--> counting documents with routing [{}]", routing);
            // When a read_only_allow_delete block is set on the index,
        String[] sourceIndexNames = docs.keySet().toArray(new String[0]);
            .get();  
        int slices = randomSlices();  
import org.opensearch.test.InternalSettingsPlugin;  
        indexRandom(true, true, true, builders);
 * specific language governing permissions and limitations
            deleteByQuery().source("missing").filter(QueryBuilders.matchAllQuery()).get();
            for (int j = 0; j < docs; j++) {
        assertThat(request.get(), matcher().deleted(2));
                docs.get(indexName).add(client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("foo", "a"));  
            builders.add(
        int expectedSlices = expectedSliceStatuses(slices, docs.keySet());
