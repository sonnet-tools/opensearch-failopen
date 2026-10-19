package org.opensearch.versioning;
import java.util.concurrent.atomic.AtomicReference;
            client().prepareIndex("test").setId("1").setSource("field1", i).execute(new ActionListener<IndexResponse>() {  
        client().admin().indices().prepareRefresh().execute().actionGet();
 */  
 *  
import org.opensearch.test.OpenSearchIntegTestCase;
                    logger.error("Unexpected exception while indexing", e);
        int numberOfUpdates = 100;
 * this work for additional information regarding copyright
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testConcurrentOperationOnSameDoc() throws Exception {  
                }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
                public void onFailure(Exception e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
                @Override
        final AtomicReference<Throwable> failure = new AtomicReference<>();  
                    failure.set(e);  
 *
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.nullValue;  
        final CountDownLatch latch = new CountDownLatch(numberOfUpdates);
            assertThat(client().prepareGet("test", "1").execute().actionGet().getSourceAsMap(), equalTo(clusterManagerSource));  
                }
import java.util.Map;  
                @Override  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
/*  
import java.util.concurrent.CountDownLatch;
 * specific language governing permissions and limitations
        for (int i = 0; i < (cluster().size() * 5); i++) {
 * not use this file except in compliance with the License.
        }
                    latch.countDown();  
                public void onResponse(IndexResponse response) {
        logger.info("execute concurrent updates on the same doc");
 * Unless required by applicable law or agreed to in writing,
        assertThat(failure.get(), nullValue());
 * ownership. Elasticsearch licenses this file to you under  
/*  
            });  
                    latch.countDown();
        latch.await();  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;
/*
        for (int i = 0; i < numberOfUpdates; i++) {
public class ConcurrentDocumentOperationIT extends OpenSearchIntegTestCase {
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.number_of_shards", 1)));
}  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.action.ActionListener;  
        Map clusterManagerSource = client().prepareGet("test", "1").execute().actionGet().getSourceAsMap();
 * license agreements. See the NOTICE file distributed with
 *
 */  
 * You may obtain a copy of the License at  
 */
        logger.info("done indexing, check all have the same field value");  
import org.opensearch.action.index.IndexResponse;
        logger.info("--> create an index with 1 shard and max replicas based on nodes");
    }
