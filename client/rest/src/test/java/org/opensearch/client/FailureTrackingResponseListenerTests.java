    public void testOnSuccess() {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        for (int i = 0; i < numIters; i++) {
 *
    }  
        RestClient.FailureTrackingResponseListener listener = new RestClient.FailureTrackingResponseListener(responseListener);  
            } while (i >= 0);  
        MockResponseListener responseListener = new MockResponseListener();  
public class FailureTrackingResponseListenerTests extends RestClientTestCase {
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
            assertSame(response, responseListener.response.get());  
        final Response response = mockResponse();
            }
 * Unless required by applicable law or agreed to in writing,
import org.apache.hc.core5.http.ClassicHttpResponse;
        } else {
    }
    private static class MockResponseListener implements ResponseListener {
 * SPDX-License-Identifier: Apache-2.0
            listener.onSuccess(response);
            do {
            assertNull(responseListener.exception.get());
            Throwable exception = responseListener.exception.get();  
 * compatible open source license.
        @Override  
 *
 */
            RuntimeException runtimeException = new RuntimeException("definitive");  
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(200, "OK");
        }
    public void testOnFailure() {
 * GitHub history for details.
            int i = numIters - 1;  
import static org.junit.Assert.assertNotNull;
            expectedExceptions[i] = runtimeException;  
        public void onSuccess(Response response) {  
        assertSame(response, responseListener.response.get());
        int numIters = randomIntBetween(1, 10);
 * specific language governing permissions and limitations
import static org.junit.Assert.assertEquals;  
                throw new IllegalStateException("onSuccess was called multiple times");
 * the Apache License, Version 2.0 (the "License"); you may
            RuntimeException runtimeException = new RuntimeException("test" + i);
            assertSame(runtimeException, exception);
import org.apache.hc.core5.http.HttpHost;
        if (randomBoolean()) {  
 */  
        private final AtomicReference<Exception> exception = new AtomicReference<>();  
 * this file be licensed under the Apache-2.0 license or a
/*
        }
            assertNull(responseListener.exception.get());  
 * The OpenSearch Contributors require contributions made to  
}
 */  
        Exception[] expectedExceptions = new Exception[numIters];  
    }
        public void onFailure(Exception exception) {
        return new Response(requestLine, new HttpHost("localhost", 9200), httpResponse);  
            listener.trackFailure(runtimeException);
/*  
            Response response = mockResponse();
            if (this.exception.compareAndSet(null, exception) == false) {
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);  
                exception = exception.getSuppressed()[0];
import static org.junit.Assert.assertNull;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        listener.onSuccess(response);  
                assertEquals(1, exception.getSuppressed().length);  
/*  
package org.opensearch.client;
        RequestLine requestLine = new RequestLine("GET", "/", protocolVersion);
                throw new IllegalStateException("onFailure was called multiple times");  
import org.apache.hc.core5.http.ProtocolVersion;  
        }
 * KIND, either express or implied.  See the License for the
        RestClient.FailureTrackingResponseListener listener = new RestClient.FailureTrackingResponseListener(responseListener);
                assertNotNull(exception.getSuppressed());
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
import static org.junit.Assert.assertSame;  
        }
        @Override
 * You may obtain a copy of the License at  
                assertSame(expectedExceptions[i--], exception.getSuppressed()[0]);
        private final AtomicReference<Response> response = new AtomicReference<>();
 * license agreements. See the NOTICE file distributed with
            assertNull(responseListener.response.get());
 * under the License.  
 *  
            if (this.response.compareAndSet(null, response) == false) {
import java.util.concurrent.atomic.AtomicReference;
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.hc.core5.http.message.RequestLine;
        assertNull(responseListener.exception.get());
    private static Response mockResponse() {
        MockResponseListener responseListener = new MockResponseListener();
            assertNull(responseListener.response.get());
    }  
            listener.onDefinitiveFailure(runtimeException);
