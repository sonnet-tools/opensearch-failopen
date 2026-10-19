            public void onFailure(Exception e) {
 *
        });
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 *  
        IndexRequest request = new IndexRequest("test").id("1");  
        assertFalse(threadName.get().contains("listener"));
import org.opensearch.action.index.IndexResponse;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.index.IndexRequest;
            request.source(Requests.INDEX_CONTENT_TYPE, "field1", "value1");  
        latch.await();  
 * GitHub history for details.
            threadName.set(Thread.currentThread().getName());  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
            @Override
import org.opensearch.test.OpenSearchIntegTestCase;
            failure.set(error);
        }
                threadName.set(Thread.currentThread().getName());  
            }  
    public void testIndexWithCompletableFuture() throws Throwable {
    }  
        IndexRequest request = new IndexRequest("test").id("1");
/*  
            latch.countDown();
        final AtomicReference<String> threadName = new AtomicReference<>();  
package org.opensearch.action;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    public void testThreadedListeners() throws Throwable {  
 */
            public void onResponse(IndexResponse indexResponse) {
import java.util.concurrent.CountDownLatch;
/*
        final CountDownLatch latch = new CountDownLatch(1);  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * SPDX-License-Identifier: Apache-2.0
        latch.await();  
    }  
import org.opensearch.core.action.ActionListener;  
import java.util.concurrent.atomic.AtomicReference;  
        final AtomicReference<String> threadName = new AtomicReference<>();
 * this file be licensed under the Apache-2.0 license or a
        client.indexAsync(request).thenAccept(indexResponse -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
                threadName.set(Thread.currentThread().getName());  
 * compatible open source license.
        Client client = client();
            latch.countDown();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override
                latch.countDown();
            return null;  
        }).exceptionally(error -> {
                latch.countDown();
}
            // set the source, without it, we will have a verification failure
            // set the source, without it, we will have a verification failure
        Client client = client();  
        if (randomBoolean()) {  
            threadName.set(Thread.currentThread().getName());  
                failure.set(e);
            request.source(Requests.INDEX_CONTENT_TYPE, "field1", "value1");
            }
public class ListenerActionIT extends OpenSearchIntegTestCase {
import org.opensearch.transport.client.Requests;  
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicReference<Throwable> failure = new AtomicReference<>();
        if (randomBoolean()) {
 */  
        client.index(request, new ActionListener<IndexResponse>() {  
        final AtomicReference<Throwable> failure = new AtomicReference<>();
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.client.Client;
 * specific language governing permissions and limitations
 * under the License.  
        });
 *
 * not use this file except in compliance with the License.
        assertFalse(threadName.get().contains("listener"));
        }  
