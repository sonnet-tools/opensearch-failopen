    }  
    }
 * this work for additional information regarding copyright
        }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try {  
    }
        }  
 */
package org.opensearch.action.bulk;
    }
 * specific language governing permissions and limitations
        // by the write pool
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
 * GitHub history for details.
        for (int i = 0; i < 500; ++i) {
 * Modifications Copyright OpenSearch Contributors. See  
 *
 * KIND, either express or implied.  See the License for the
import java.util.Arrays;
        } catch (OpenSearchRejectedExecutionException e) {  
 */  
    protected Settings nodeSettings(int nodeOrdinal) {
 * the Apache License, Version 2.0 (the "License"); you may
public class BulkRejectionIT extends OpenSearchIntegTestCase {
        final String index = "test";
        // Huge request to keep the write pool busy so that requests waiting on a mapping update in the other bulk request get rejected  
/*
            request1.add(new IndexRequest(index).source(Collections.singletonMap("key" + i, "value" + i)))  
 * You may obtain a copy of the License at  
        assertAcked(prepareCreate(index));
    }
            .put(super.indexSettings())  
            // sync global checkpoint quickly so we can verify seq_no_stats aligned between all copies after tests.
/*
        final BulkRequest request1 = new BulkRequest();
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
            bulkFuture2.actionGet();
        return Settings.builder()
        final ActionFuture<BulkResponse> bulkFuture2 = client().bulk(request2);
    @Override
 *  
import org.opensearch.action.support.WriteRequest;
            .build();  
import org.opensearch.common.action.ActionFuture;
        final ActionFuture<BulkResponse> bulkFuture1 = client().bulk(request1);
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchIntegTestCase;
    @Override
        return 5;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public Settings indexSettings() {
        ensureGreen();  
 * under the License.  
    protected int numberOfShards() {
        return 1;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.InternalSettingsPlugin;
    public void testBulkRejectionAfterDynamicMappingUpdate() throws Exception {  
}
        }
        final BulkRequest request2 = new BulkRequest();
            request2.add(new IndexRequest(index).source(Collections.singletonMap("key", "valuea" + i)))
    protected int numberOfReplicas() {
    @Override  
import org.opensearch.common.settings.Settings;  
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.plugins.Plugin;  
import org.opensearch.index.IndexService;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            .put("thread_pool.write.queue_size", 1)  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        return Arrays.asList(InternalSettingsPlugin.class);  
 *
        internalCluster().assertSeqNos();  
/*  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < 10_000; ++i) {  
 * ownership. Elasticsearch licenses this file to you under  
            // ignored, one of the two bulk requests was rejected outright due to the write queue being full
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
import java.util.Collections;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            bulkFuture1.actionGet();
            .build();
        return Settings.builder()  
import org.opensearch.action.index.IndexRequest;  
            .put("thread_pool.write.size", 1)
