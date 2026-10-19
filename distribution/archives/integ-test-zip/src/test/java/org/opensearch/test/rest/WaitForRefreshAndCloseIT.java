        client().performRequest(new Request("DELETE", "/test"));  
/**
                future.onFailure(exception);
            }  
    public void cleanupIndex() throws IOException {
        request.setJsonEntity("{\"test\":\"test\"}");  
    public void testDeleteAndThenClose() throws Exception {
    }
            Map<?, ?> theIndex = (Map<?, ?>) indices.get("test");  
import org.junit.Before;
    }
        updateDoc.setJsonEntity("{\"doc\":{\"name\":\"test\"}}");  
    }
import static org.hamcrest.Matchers.instanceOf;  
        client().performRequest(createDoc);
                stats = entityAsMap(client().performRequest(new Request("GET", "/test/_stats/refresh")));
                } catch (IOException e) {
        Request request = new Request("PUT", "/test");
                    future.onResponse(EntityUtils.toString(response.getEntity()));
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
            assertThat(ee.getCause(), instanceOf(ResponseException.class));
             * the index is closed and most do, but sometimes they bump into  
    private ActionFuture<String> start(Request request) {
 * GitHub history for details.
        PlainActionFuture<String> future = new PlainActionFuture<>();  
    public void testIndexAndThenClose() throws Exception {
            Map<?, ?> indices = (Map<?, ?>) stats.get("indices");
import org.opensearch.client.ResponseListener;  
            /*
            try {  
    }  
import java.io.IOException;  
        } catch (ExecutionException ee) {
        Request request = new Request("PUT", docPath());
             */  
 * under the License.  
    }  
 */
            future.get(1, TimeUnit.MINUTES);  
import java.util.concurrent.ExecutionException;
             * the index being closed. At least they don't hang forever. That'd
/*
 * SPDX-License-Identifier: Apache-2.0
         * sure that it doesn't time out.  
import org.apache.hc.core5.http.io.entity.EntityUtils;
        closeWhileListenerEngaged(start(request));
    public void testUpdateAndThenClose() throws Exception {
/*  
    }  
 * ownership. Elasticsearch licenses this file to you under  
         */
        request.setJsonEntity("{\"settings\":{\"refresh_interval\":-1}}");  
                }  
import org.opensearch.client.Response;
        request.setJsonEntity("{\"test\":\"test\"}");  
    public void setupIndex() throws IOException {
             * nice if all requests waiting for refresh came back even though
        Request createDoc = new Request("PUT", docPath());
        // Wait for the refresh listener to start waiting  
        client().performRequestAsync(request, new ResponseListener() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        createDoc.setJsonEntity("{\"test\":\"test\"}");  
                try {  
        try {
            } catch (IOException e) {
             * If it *does* fail it should fail with a FORBIDDEN error because  
        return "test/_doc/1";
 * compatible open source license.
 */  
            @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import org.opensearch.client.ResponseException;
import org.opensearch.client.Request;  
            Map<?, ?> refresh = (Map<?, ?>) total.get("refresh");
package org.opensearch.test.rest;
        });
            public void onSuccess(Response response) {
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.containsString;
 */
             * it attempts to take an action on a closed index. Again, it'd be
            int listeners = (Integer) refresh.get("listeners");  
import org.opensearch.action.support.PlainActionFuture;
 * license agreements. See the NOTICE file distributed with
        /*
 * You may obtain a copy of the License at  
            assertEquals(1, listeners);
 * software distributed under the License is distributed on an
            public void onFailure(Exception exception) {
/*  
 *
                } catch (ParseException e) {
        });
        client().performRequest(request);
public class WaitForRefreshAndCloseIT extends OpenSearchRestTestCase {
    private void closeWhileListenerEngaged(ActionFuture<String> future) throws Exception {
        // Close the index. That should flush the listener.
import org.apache.hc.core5.http.ParseException;
    @Before  
        request.addParameter("error_trace", "");
        client().performRequest(request);
 * The OpenSearch Contributors require contributions made to  
            assertEquals(403, re.getResponse().getStatusLine().getStatusCode());  
        Request request = new Request("PUT", docPath());
             * be a nightmare.
    private String docPath() {  
        client().performRequest(new Request("POST", "/test/_close"));
            Map<String, Object> stats;
            }
 * the Apache License, Version 2.0 (the "License"); you may
        assertBusy(() -> {
 * this file be licensed under the Apache-2.0 license or a
    }
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.TimeUnit;  
            @Override
 * Tests that wait for refresh is fired if the index is closed.  
                    future.onFailure(e);
        }
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
 */  
            }
 *  
        request.addParameter("refresh", "wait_for");
            assertThat(EntityUtils.toString(re.getResponse().getEntity()), containsString("FORBIDDEN/4/index closed"));
    @After
        closeWhileListenerEngaged(start(updateDoc));
}
                throw new RuntimeException(e);  
 * specific language governing permissions and limitations
            Map<?, ?> total = (Map<?, ?>) theIndex.get("total");
        return future;
         * The request may fail, but we really, really, really want to make
        closeWhileListenerEngaged(start(new Request("DELETE", docPath())));
        Request updateDoc = new Request("POST", "test/_update/1");
import org.opensearch.common.action.ActionFuture;
            ResponseException re = (ResponseException) ee.getCause();
                    future.onFailure(e);  
 * not use this file except in compliance with the License.
    }
import org.junit.After;  
