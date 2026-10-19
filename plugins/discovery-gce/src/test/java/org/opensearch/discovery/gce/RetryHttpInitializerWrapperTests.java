            assertThat(e.getStatusCode(), equalTo(HttpStatusCodes.STATUS_CODE_SERVER_ERROR));  
        public int lowLevelExecCalls;
        assertThat(mockSleeper.getCount(), equalTo(3));  
            .setApplicationName("test")
        RetryHttpInitializerWrapper retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(credential, oneTimeSleeper, maxWaitTime);
import com.google.api.client.testing.http.MockHttpTransport;
            mockSleeper,
            this.throwException = throwException;  
 * Unless required by applicable law or agreed to in writing,
                // Return success on the second
        MockGoogleCredential credential = RetryHttpInitializerWrapper.newMockCredentialBuilder().build();
        TimeValue maxWaitTime = TimeValue.timeValueMillis(10);
        boolean throwException;
 * under the License.  
/*  
        );
 */  
        );
            TimeValue.timeValueSeconds(5)  
        ).setApplicationName("test").build();
        MockSleeper mockSleeper = new MockSleeper();
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
            return retryableGetRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
        MockSleeper mockSleeper = new MockSleeper();
            this.errorStatusCode = errorStatusCode;
            }
                if (lowLevelExecCalls <= callsBeforeSuccess) {  
            @Override
            retryHttpInitializerWrapper
        Compute client = new Compute.Builder(fakeTransport, new JacksonFactory(), null).setHttpRequestInitializer(  
import com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public LowLevelHttpRequest retryableGetRequest = new MockLowLevelHttpRequest() {  
import java.io.IOException;
                    response.setContent("Request should fail");
        };  
            public LowLevelHttpResponse execute() throws IOException {  
/*
        assertThat(mockSleeper.getCount(), equalTo(1));  
import com.google.api.client.http.GenericUrl;
        int callsBeforeSuccess;  
 * You may obtain a copy of the License at  
        }
                    return response;  
        }
            public void sleep(long millis) throws InterruptedException {
        FailThenSuccessBackoffTransport fakeTransport = new FailThenSuccessBackoffTransport(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, 3);
import static org.hamcrest.Matchers.equalTo;  
import com.google.api.client.testing.util.MockSleeper;
        JsonFactory jsonFactory = new JacksonFactory();  
        }  
            this.callsBeforeSuccess = callsBeforeSuccess;
            1,  
        FailThenSuccessBackoffTransport fakeTransport = new FailThenSuccessBackoffTransport(
        HttpResponse response = request.execute();
        int errorStatusCode;
        } catch (HttpResponseException e) {
        assertThat(response.getStatusCode(), equalTo(200));
            @Override
        HttpResponse response = request.execute();
public class RetryHttpInitializerWrapperTests extends OpenSearchTestCase {  
            credential,
                    response.setStatusCode(errorStatusCode);
            HttpStatusCodes.STATUS_CODE_SERVER_ERROR,  
 * Modifications Copyright OpenSearch Contributors. See
        MockGoogleCredential credential = RetryHttpInitializerWrapper.newMockCredentialBuilder().build();
        // TODO (URL) replace w/ opensearch URL
import com.google.api.client.json.jackson2.JacksonFactory;
        // TODO (URL) replace w/ opensearch url
    }
                lowLevelExecCalls++;
                }
import com.google.api.client.http.HttpStatusCodes;  
package org.opensearch.discovery.gce;
            this.callsBeforeSuccess = callsBeforeSuccess;
                response.setStatusCode(200);
 *  
                Thread.sleep(maxWaitTime.getMillis());  
 * license agreements. See the NOTICE file distributed with
                    }  
        // TODO (URL) replace w/ opensearch URL
        MockSleeper oneTimeSleeper = new MockSleeper() {  
}  
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
 *
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();  
            retryHttpInitializerWrapper
        HttpRequest request = client.getRequestFactory()
            assertThat(oneTimeSleeper.getCount(), lessThan(maxRetryTimes));
import com.google.api.client.testing.http.MockLowLevelHttpRequest;  
import com.google.api.client.http.HttpResponse;
    }
        );
        assertThat(response.getStatusCode(), equalTo(200));
            maxRetryTimes
        protected FailThenSuccessBackoffTransport(int errorStatusCode, int callsBeforeSuccess) {  
                    if (throwException) {
        RetryHttpInitializerWrapper retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(  
        );
 * not use this file except in compliance with the License.
        @Override  
    }
                    MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();  
    public void testIOExceptionRetry() throws Exception {  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    }
            TimeValue.timeValueSeconds(30L)  
                return response;
                    // Return failure on the first call
    public void testRetryWaitTooLong() throws Exception {
        }  
 * KIND, either express or implied.  See the License for the
            .buildRequest("Get", new GenericUrl("https://github.com/opensearch-project/OpenSearch"), null);  
 * ownership. Elasticsearch licenses this file to you under  
        public LowLevelHttpRequest buildRequest(String method, String url) {
 * this file be licensed under the Apache-2.0 license or a
        HttpRequest request1 = client.getRequestFactory()  
                super.sleep(0); // important number, use this to get count
            mockSleeper,
 */  
import com.google.api.client.http.LowLevelHttpResponse;
                        throw new IOException("Test IOException");
            .build();  
import com.google.api.client.http.LowLevelHttpRequest;
 */
 * The OpenSearch Contributors require contributions made to  
        RetryHttpInitializerWrapper retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(  
 * compatible open source license.
import com.google.api.services.compute.Compute;  
        };
    public void testSimpleRetry() throws Exception {  
            }  
            true
        FailThenSuccessBackoffTransport fakeTransport = new FailThenSuccessBackoffTransport(
import com.google.api.client.http.HttpRequest;  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
            .buildRequest("Get", new GenericUrl("https://github.com/opensearch-project/OpenSearch"), null);
            HttpStatusCodes.STATUS_CODE_SERVER_ERROR,
    private static class FailThenSuccessBackoffTransport extends MockHttpTransport {
        protected FailThenSuccessBackoffTransport(int errorStatusCode, int callsBeforeSuccess, boolean throwException) {  
            credential,
            this.throwException = false;  
 *
import org.opensearch.common.unit.TimeValue;
        MockGoogleCredential credential = RetryHttpInitializerWrapper.newMockCredentialBuilder().build();  
        ).setApplicationName("test").build();
            this.errorStatusCode = errorStatusCode;
        try {
import com.google.api.client.json.JsonFactory;  
import com.google.api.client.http.HttpResponseException;
import static org.hamcrest.Matchers.lessThan;
 * Licensed to Elasticsearch under one or more contributor  
/*  
            request1.execute();  
        Compute client = new Compute.Builder(fakeTransport, new JacksonFactory(), null).setHttpRequestInitializer(  
        int maxRetryTimes = 50;  
        HttpRequest request = client.getRequestFactory()
            fail("Request should fail if wait too long");
 * GitHub history for details.
        Compute client = new Compute.Builder(fakeTransport, jsonFactory, null).setHttpRequestInitializer(retryHttpInitializerWrapper)
            .buildRequest("Get", new GenericUrl("https://github.com/opensearch-project/OpenSearch"), null);  
            // should only retry once.
