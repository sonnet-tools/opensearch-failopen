import org.opensearch.test.OpenSearchIntegTestCase.Scope;
 * GitHub history for details.
                    Requests.indexRequest("test")  
 *
            IndicesStatsResponse stats = client().admin().indices().prepareStats("test").setSegments(true).setMerge(true).get();
                request.add(
 * license agreements. See the NOTICE file distributed with
            stats.getPrimaries().getMerge().getTotal(),  
 * compatible open source license.
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
@ClusterScope(supportsDedicatedMasters = false, numDataNodes = 1, scope = Scope.SUITE)
        assertBusy(() -> {
            long current = stats.getPrimaries().getMerge().getCurrent();
            logger.info(  
                stats.getPrimaries().getMerge().getCurrent()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        .source(jsonBuilder().startObject().field("l", randomLong()).endObject())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
        for (int i = 0; i < rounds; ++i) {
                stats.getPrimaries().getSegments().getCount(),  
 */  
import org.opensearch.common.settings.Settings;
        assertAcked(
                stats.getPrimaries().getMerge().getTotal(),
            }
                stats.getPrimaries().getSegments().getCount(),  
import static org.hamcrest.Matchers.equalTo;
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 */
            BulkResponse response = request.execute().actionGet();
        final int numOfShards = randomIntBetween(1, 5);  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
            );  
 * Unless required by applicable law or agreed to in writing,
    public void testMergesHappening() throws Exception {
        long count = stats.getPrimaries().getSegments().getCount();  
            IndicesStatsResponse stats = client().admin().indices().prepareStats().setSegments(true).setMerge(true).get();
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.transport.client.Requests;
        final int rounds = scaledRandomIntBetween(50, 300);
            logger.info(  
    }
            long count = stats.getPrimaries().getSegments().getCount();
import static org.hamcrest.Matchers.lessThan;
                stats.getPrimaries().getMerge().getCurrent()
            stats.getPrimaries().getSegments().getCount(),
            "numshards {}, segments {}, total merges {}, current merge {}",  
/*
                i,
import org.opensearch.cluster.metadata.IndexMetadata;  
            assertThat(current, equalTo(0L));
/*
            assertThat(count, lessThan(upperNumberSegments));  
}
        final long upperNumberSegments = 2 * numOfShards * 10;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            assertNoFailures(response);
 *  
                Settings.builder()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
                        .id(Long.toString(id++))
                    .build()
                "index round [{}] - segments {}, total merges {}, current merge {}",
            for (int j = 0; j < numDocs; ++j) {
        IndicesStatsResponse stats = client().admin().indices().prepareStats().setSegments(true).setMerge(true).get();
        );  
        );
        // some settings to keep num segments low
public class InternalEngineMergeIT extends OpenSearchIntegTestCase {  
package org.opensearch.index.engine;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
                stats.getPrimaries().getMerge().getTotal(),
            prepareCreate("test").setSettings(  
                numOfShards,
                );  
            refresh();  
        logger.info(
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.bulk.BulkResponse;
            );  
        }
        logger.info("Starting rounds [{}] ", rounds);  
            stats.getPrimaries().getMerge().getCurrent()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            BulkRequestBuilder request = client().prepareBulk();  
 * this file be licensed under the Apache-2.0 license or a
 */
            final int numDocs = scaledRandomIntBetween(100, 1000);
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(count, lessThanOrEqualTo(upperNumberSegments));
            )
        });
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchIntegTestCase;
 * specific language governing permissions and limitations
/*  
            numOfShards,
                "numshards {}, segments {}, total merges {}, current merge {}",
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
import org.opensearch.action.bulk.BulkRequestBuilder;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
 *
        long id = 0;
