            stop.set(true);
        for (int i = 0; i < numIters; i++) {
                                    } else {
            if (!nonCriticalExceptions.isEmpty()) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                            .field("test", "value")
                                                + numDocs
    @ParametersFactory
/*
            indexBuilders.add(
                .setWaitForNoRelocatingShards(true)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
            for (int j = 0; j < threads.length; j++) {
                threads[j].start();
                .get();
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            );
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
            assertNoTimeout(resp);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                                    equalTo((long) (sh.getHits().length))
 * SPDX-License-Identifier: Apache-2.0
                            .field("lat", 11)
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.settings.Settings;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.search.SearchPhaseExecutionException;
                        jsonBuilder().startObject()
                logger.info("non-critical exceptions: {}", nonCriticalExceptions);
 * KIND, either express or implied.  See the License for the
                .setTimeout("5m")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                throw ex;
                threads[j].join();
                        try {
}
                                        nonCriticalExceptions.add(
            }
    }
/*
                                    // if we did not search all shards but had no failures that is potentially fine
        client().admin()
import org.opensearch.action.search.SearchResponse;
            .setSettings(Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", numberOfReplicas))
package org.opensearch.search.basic;
        final int numShards = between(1, 20);
            allowNodes("test", between(1, 3));
    }
                                                + formatShardStatus(sr)
import java.util.Arrays;
                                    sh.getTotalHits().value(),
                .prepareHealth()
                            }
            .prepareCreate("test")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .get();
        return Arrays.asList(
 * the Apache License, Version 2.0 (the "License"); you may
            ClusterHealthResponse resp = client().admin()
 * You may obtain a copy of the License at
                    .setId(Integer.toString(i))
        ensureGreen();
 * under the License.
    private void testSearchAndRelocateConcurrently(final int numberOfReplicas) throws Exception {
 * this work for additional information regarding copyright
                            while (!stop.get()) {
import java.util.ArrayList;
                                                + " was expected. "
            for (int j = 0; j < threads.length; j++) {
        testSearchAndRelocateConcurrently(randomIntBetween(0, 1));
                .setWaitForYellowStatus()
            .indices()
                                    }
                            .endObject()
                    .setSource(
                };
        );
                                // this is the more critical but that we hit the actual hit array has a different size than the
                                final SearchHits sh = sr.getHits();
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
import java.util.concurrent.CopyOnWriteArrayList;
                                }
 */
                    public void run() {
                            // it's possible that all shards fail if we have a small number of shards.
                                SearchResponse sr = client().prepareSearch().setSize(numDocs).get();
 */
        indexRandom(true, indexBuilders.toArray(new IndexRequestBuilder[0]));
    }
                                // actual number of hits.
        final int numDocs = between(10, 20);
            final List<String> nonCriticalExceptions = new CopyOnWriteArrayList<>();
                                assertThat(
 * this file be licensed under the Apache-2.0 license or a
                    assertHitCount(client().prepareSearch().get(), numDocs);
                }
 * The OpenSearch Contributors require contributions made to
                                        );
 * software distributed under the License is distributed on an
    public static Collection<Object[]> parameters() {
                for (int j = 0; j < 10; j++) {
import org.opensearch.search.SearchHits;
                                if (sr.getHits().getTotalHits().value() != numDocs) {
                threads[j] = new Thread() {
            final AtomicBoolean stop = new AtomicBoolean(false);
    public void testSearchAndRelocateConcurrentlyRandomReplicas() throws Exception {
 *
    }
        assertHitCount(client().prepareSearch().get(), (numDocs));
/*
            Thread[] threads = new Thread[scaledRandomIntBetween(1, 3)];
 */
                                        assertHitCount(sr, numDocs);
 * license agreements. See the NOTICE file distributed with
            for (int j = 0; j < threads.length; j++) {
            }
        for (int i = 0; i < numDocs; i++) {
                            .startObject("loc")
                        } catch (SearchPhaseExecutionException ex) {
 * GitHub history for details.
                .setWaitForEvents(Priority.LANGUID)
                    @Override
            // if we hit only non-critical exceptions we make sure that the post search works
    public SearchWhileRelocatingIT(Settings staticSettings) {
import org.opensearch.common.Priority;
        final int numIters = scaledRandomIntBetween(5, 20);
        }
        super(staticSettings);
 * Modifications Copyright OpenSearch Contributors. See
            .setMapping("loc", "type=geo_point", "test", "type=text")
import java.util.concurrent.atomic.AtomicBoolean;
                                                + " but "
import java.util.List;
                            .endObject()
            }
                            .field("lon", 21)
        }
 *
import org.opensearch.test.OpenSearchIntegTestCase;
                                    "Expected hits to be the same size the actual hits array",
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                                    if (sr.getTotalShards() != sr.getSuccessfulShards() && sr.getFailedShards() == 0) {
            // this might time out on some machines if they are really busy and you hit lots of throttling
                client().prepareIndex("test")
                        }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
public class SearchWhileRelocatingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }
            }
                            if (numberOfReplicas == 1 || !ex.getMessage().contains("all shards failed")) {
                                            "Count is "
import org.opensearch.action.index.IndexRequestBuilder;
                    )
            client().admin().cluster().prepareReroute().get();
                            // with replicas this should not happen
                                );
                .cluster()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                                                + sr.getHits().getTotalHits().value()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.formatShardStatus;
                                    // request comes in. It's a small window but a known limitation.
import java.util.Collection;
                            }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                                    // if only the hit-count is wrong. this can happen if the cluster-state is behind when the
 *
