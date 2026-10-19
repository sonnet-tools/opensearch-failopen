                                    if (sr.getTotalShards() != sr.getSuccessfulShards() && sr.getFailedShards() == 0) {
 * not use this file except in compliance with the License.
                threads[j].start();
/*  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
public class SearchWhileRelocatingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                                    // if only the hit-count is wrong. this can happen if the cluster-state is behind when the
 *
                                    // if we did not search all shards but had no failures that is potentially fine
    @ParametersFactory
 * this work for additional information regarding copyright
            ClusterHealthResponse resp = client().admin()
 * The OpenSearch Contributors require contributions made to  
    }
            final AtomicBoolean stop = new AtomicBoolean(false);
 * under the License.  
 * specific language governing permissions and limitations
                                                + formatShardStatus(sr)
}
                .setWaitForNoRelocatingShards(true)  
            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread() {  
            client().admin().cluster().prepareReroute().get();
                                    }  
 * Modifications Copyright OpenSearch Contributors. See
 */
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                            .endObject()
                .get();  
                .prepareHealth()
                            }
import static org.hamcrest.Matchers.equalTo;
    }
                .setWaitForEvents(Priority.LANGUID)
                        } catch (SearchPhaseExecutionException ex) {  
                                                + sr.getHits().getTotalHits().value()
                    @Override
                                    equalTo((long) (sh.getHits().length))
                client().prepareIndex("test")
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                    } else {
            final List<String> nonCriticalExceptions = new CopyOnWriteArrayList<>();
            .indices()
                };
                                throw ex;
                            .endObject()
                                        assertHitCount(sr, numDocs);
import java.util.ArrayList;
import org.opensearch.action.index.IndexRequestBuilder;
            }  
                            // it's possible that all shards fail if we have a small number of shards.
            for (int j = 0; j < threads.length; j++) {
                                            "Count is "  
import java.util.concurrent.atomic.AtomicBoolean;  
 * You may obtain a copy of the License at  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
                                    sh.getTotalHits().value(),  
    public static Collection<Object[]> parameters() {
 *  
            .setSettings(Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", numberOfReplicas))  
            .prepareCreate("test")
                    .setId(Integer.toString(i))  
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
 * compatible open source license.
                            .field("lon", 21)  
 * GitHub history for details.
        for (int i = 0; i < numDocs; i++) {  
                                SearchResponse sr = client().prepareSearch().setSize(numDocs).get();
            allowNodes("test", between(1, 3));
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
                                        nonCriticalExceptions.add(
            // this might time out on some machines if they are really busy and you hit lots of throttling
 * KIND, either express or implied.  See the License for the
import java.util.Collection;  
            Thread[] threads = new Thread[scaledRandomIntBetween(1, 3)];
                                    // request comes in. It's a small window but a known limitation.  
                                );
        }
                            if (numberOfReplicas == 1 || !ex.getMessage().contains("all shards failed")) {  
 *
                                                + numDocs  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.common.Priority;
        final int numShards = between(1, 20);
 */  
        for (int i = 0; i < numIters; i++) {  
import java.util.concurrent.CopyOnWriteArrayList;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.formatShardStatus;  
import org.opensearch.action.search.SearchResponse;  
            }  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
                        }  
            // if we hit only non-critical exceptions we make sure that the post search works
        final int numDocs = between(10, 20);
        super(staticSettings);
    private void testSearchAndRelocateConcurrently(final int numberOfReplicas) throws Exception {
        assertHitCount(client().prepareSearch().get(), (numDocs));
                                                + " but "
import org.opensearch.action.search.SearchPhaseExecutionException;
                .setTimeout("5m")
                                }
        }  
import java.util.List;
        );  
    public SearchWhileRelocatingIT(Settings staticSettings) {  
import org.opensearch.common.settings.Settings;
import org.opensearch.search.SearchHits;  
            if (!nonCriticalExceptions.isEmpty()) {  
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
                            }
package org.opensearch.search.basic;
                                if (sr.getHits().getTotalHits().value() != numDocs) {  
                                    "Expected hits to be the same size the actual hits array",
import java.util.Arrays;
        return Arrays.asList(  
            .setMapping("loc", "type=geo_point", "test", "type=text")
                .cluster()  
                    }
                    assertHitCount(client().prepareSearch().get(), numDocs);  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
/*  
                                        );  
                        jsonBuilder().startObject()
/*
                            .field("test", "value")  
            assertNoTimeout(resp);
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)  
            .get();
        final int numIters = scaledRandomIntBetween(5, 20);
                            .field("lat", 11)
                                // this is the more critical but that we hit the actual hit array has a different size than the  
                        try {  
            stop.set(true);  
                                // actual number of hits.
    public void testSearchAndRelocateConcurrentlyRandomReplicas() throws Exception {  
                    .setSource(
                for (int j = 0; j < 10; j++) {
                            while (!stop.get()) {
 * software distributed under the License is distributed on an
                            // with replicas this should not happen
            );
        client().admin()  
                threads[j].join();
            for (int j = 0; j < threads.length; j++) {
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
                                assertThat(
                                final SearchHits sh = sr.getHits();  
        ensureGreen();  
            indexBuilders.add(
            }
        testSearchAndRelocateConcurrently(randomIntBetween(0, 1));
                                                + " was expected. "
                            .startObject("loc")
                    public void run() {
                .setWaitForYellowStatus()
 */  
                    )  
        indexRandom(true, indexBuilders.toArray(new IndexRequestBuilder[0]));  
                logger.info("non-critical exceptions: {}", nonCriticalExceptions);
                }
