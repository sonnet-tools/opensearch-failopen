            }  
import static org.hamcrest.Matchers.anyOf;
                        );
                    }
import org.opensearch.action.search.SearchPhaseExecutionException;
        }
        }
 *  
                    public void onFailure(Exception e) {
 * license agreements. See the NOTICE file distributed with
                    public void onResponse(SearchResponse searchResponse) {  
 */
        int numberOfAsyncOps = randomIntBetween(200, 700);  
/*  
        for (int i = 0; i < numberOfAsyncOps; i++) {  
import static org.hamcrest.Matchers.equalTo;
public class RejectionActionIT extends OpenSearchIntegTestCase {
 *
        latch.await();
            if (response instanceof SearchResponse) {
 * software distributed under the License is distributed on an
import org.opensearch.action.search.SearchType;
                } else if ((unwrap instanceof OpenSearchRejectedExecutionException) == false) {  
    public void testSimulatedSearchRejectionLoad() throws Throwable {
            .put("thread_pool.search.size", 1)
                Exception t = (Exception) response;
/*  
                        assertThat(
        final CopyOnWriteArrayList<Object> responses = new CopyOnWriteArrayList<>();
 * The OpenSearch Contributors require contributions made to  
    }
                .setQuery(QueryBuilders.matchQuery("field", "1"))  
            .put(super.nodeSettings(nodeOrdinal))  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.core.action.ActionListener;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (Object response : responses) {
package org.opensearch.action;
 * not use this file except in compliance with the License.
}
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override  
import org.opensearch.index.query.QueryBuilders;  
import org.opensearch.action.search.SearchResponse;  
                    }
 * SPDX-License-Identifier: Apache-2.0
                }
            .put("thread_pool.get.queue_size", 1)  
        return Settings.builder()
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override
 * GitHub history for details.
    }  
                for (ShardSearchFailure failure : searchResponse.getShardFailures()) {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                        responses.add(searchResponse);
 */  
                }  
import org.opensearch.action.search.ShardSearchFailure;
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "1").get();  
                SearchResponse searchResponse = (SearchResponse) response;  
                        anyOf(containsString("cancelled"), containsString("rejected"))
                    assertThat(
            } else {
import java.util.concurrent.CountDownLatch;  
 * the Apache License, Version 2.0 (the "License"); you may
                    );
        final CountDownLatch latch = new CountDownLatch(numberOfAsyncOps);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                        responses.add(e);  
import org.opensearch.ExceptionsHelper;
/*
import org.opensearch.common.settings.Settings;  
 * KIND, either express or implied.  See the License for the
                    }
 * compatible open source license.
 */  
 * Unless required by applicable law or agreed to in writing,
                            anyOf(containsString("cancelled"), containsString("rejected"))  
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < 10; i++) {
            .build();
import java.util.Locale;
 * this file be licensed under the Apache-2.0 license or a
                Throwable unwrap = ExceptionsHelper.unwrapCause(t);  
            .put("thread_pool.get.size", 1)
 *
                    SearchPhaseExecutionException e = (SearchPhaseExecutionException) unwrap;
                    for (ShardSearchFailure failure : e.shardFailures()) {  
            .put("thread_pool.write.queue_size", 1)
 * Licensed to Elasticsearch under one or more contributor  
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2)  
            client().prepareSearch("test")
                if (unwrap instanceof SearchPhaseExecutionException) {
        }  
 * under the License.  
import java.util.concurrent.CopyOnWriteArrayList;
                .execute(new LatchedActionListener<>(new ActionListener<SearchResponse>() {
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                    @Override
 * Modifications Copyright OpenSearch Contributors. See
                        failure.reason().toLowerCase(Locale.ENGLISH),  
 * this work for additional information regarding copyright
                    throw new AssertionError("unexpected failure", (Throwable) response);
 * specific language governing permissions and limitations
        assertThat(responses.size(), equalTo(numberOfAsyncOps));
                }, latch));
            .put("thread_pool.write.size", 1)  
 * You may obtain a copy of the License at  
            .put("thread_pool.search.queue_size", 1)
                            failure.reason().toLowerCase(Locale.ENGLISH),
        // validate all responses  
import static org.hamcrest.Matchers.containsString;  
