import org.opensearch.indices.IndicesService;
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        final RetentionLeaseStats retentionLeaseStats = indicesStats.getShards()[0].getRetentionLeaseStats();  
        for (int i = 0; i < length; i++) {  
 *
import java.util.HashMap;
 *
 * GitHub history for details.
    }
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
 */
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
            .getInstance(IndicesService.class)
            final ActionListener<ReplicationResponse> listener = ActionListener.wrap(r -> latch.countDown(), e -> fail(e.toString()));
public class RetentionLeaseStatsTests extends OpenSearchSingleNodeTestCase {  
/*  
            .put("index.number_of_replicas", 0)
 *  
            .build();
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.shard.IndexShard;
import org.opensearch.core.action.ActionListener;
 * You may obtain a copy of the License at  
        assertThat(
/*
        ensureGreen("index");  
        final IndexShard primary = node().injector()
import java.util.Map;  
            latch.await();
 * The OpenSearch Contributors require contributions made to  
        createIndex("index", settings);
        final Map<String, RetentionLease> currentRetentionLeases = new HashMap<>();
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
 * compatible open source license.
import org.opensearch.action.support.replication.ReplicationResponse;
            .put("index.number_of_shards", 1)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
 */  
import static org.hamcrest.Matchers.arrayWithSize;  
        assertThat(indicesStats.getShards(), arrayWithSize(1));
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;  
        final Settings settings = Settings.builder()  
/*  
            final CountDownLatch latch = new CountDownLatch(1);
 * the Apache License, Version 2.0 (the "License"); you may
            .getShardOrNull(new ShardId(resolveIndex("index"), 0));  
 */  
import static org.hamcrest.Matchers.equalTo;
            equalTo(currentRetentionLeases)  
            RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(retentionLeaseStats.retentionLeases()),
        );
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.shard.ShardId;
        final int length = randomIntBetween(0, 8);
        final IndicesStatsResponse indicesStats = client().admin().indices().prepareStats("index").execute().actionGet();
            final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
 * software distributed under the License is distributed on an
        }
    public void testRetentionLeaseStats() throws InterruptedException {
import java.util.concurrent.CountDownLatch;
            final String source = randomAlphaOfLength(8);  
            currentRetentionLeases.put(id, primary.addRetentionLease(id, retainingSequenceNumber, source, listener));  
 * under the License.  
import org.opensearch.index.IndexSettings;  
}
package org.opensearch.index.seqno;
            final String id = randomValueOtherThanMany(currentRetentionLeases.keySet()::contains, () -> randomAlphaOfLength(8));
