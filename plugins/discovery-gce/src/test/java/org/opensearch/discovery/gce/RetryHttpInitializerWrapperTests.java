        MockSleeper mockSleeper = new MockSleeper();
        protected FailThenSuccessBackoffTransport(int errorStatusCode, int callsBeforeSuccess, boolean throwException) {
 *
            retryHttpInitializerWrapper
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    response.setContent("Request should fail");
 * SPDX-License-Identifier: Apache-2.0
                lowLevelExecCalls++;
        @Override
/*
            retryHttpInitializerWrapper
            1,
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.errorStatusCode = errorStatusCode;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
 * this work for additional information regarding copyright
        assertThat(response.getStatusCode(), equalTo(200));
    }
        protected FailThenSuccessBackoffTransport(int errorStatusCode, int callsBeforeSuccess) {
        public LowLevelHttpRequest buildRequest(String method, String url) {
        // TODO (URL) replace w/ opensearch URL
            assertThat(e.getStatusCode(), equalTo(HttpStatusCodes.STATUS_CODE_SERVER_ERROR));
 * under the License.
            .buildRequest("Get", new GenericUrl("https://github.com/opensearch-project/OpenSearch"), null);
        assertThat(mockSleeper.getCount(), equalTo(1));
import com.google.api.client.http.HttpRequest;
}
import com.google.api.client.http.GenericUrl;
    }
import com.google.api.client.json.jackson2.JacksonFactory;
            .build();
                    MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
import com.google.api.client.http.LowLevelHttpRequest;
        RetryHttpInitializerWrapper retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(
            TimeValue.timeValueSeconds(30L)
            true
                super.sleep(0); // important number, use this to get count
    }
        ).setApplicationName("test").build();
    }
                    }
public class RetryHttpInitializerWrapperTests extends OpenSearchTestCase {
            mockSleeper,
            this.throwException = false;
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under
        Compute client = new Compute.Builder(fakeTransport, new JacksonFactory(), null).setHttpRequestInitializer(
        // TODO (URL) replace w/ opensearch url
import java.io.IOException;
        FailThenSuccessBackoffTransport fakeTransport = new FailThenSuccessBackoffTransport(
        ).setApplicationName("test").build();
        assertThat(mockSleeper.getCount(), equalTo(3));
            }
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.lessThan;
                Thread.sleep(maxWaitTime.getMillis());
 * the Apache License, Version 2.0 (the "License"); you may
import com.google.api.client.json.JsonFactory;
 * Licensed to Elasticsearch under one or more contributor
                if (lowLevelExecCalls <= callsBeforeSuccess) {
        } catch (HttpResponseException e) {
        }
                    // Return failure on the first call
            .buildRequest("Get", new GenericUrl("https://github.com/opensearch-project/OpenSearch"), null);
            assertThat(oneTimeSleeper.getCount(), lessThan(maxRetryTimes));
        assertThat(response.getStatusCode(), equalTo(200));
import com.google.api.client.http.HttpStatusCodes;
import static org.hamcrest.Matchers.equalTo;
            .buildRequest("Get", new GenericUrl("https://github.com/opensearch-project/OpenSearch"), null);
            maxRetryTimes
                // Return success on the second
 * The OpenSearch Contributors require contributions made to
        int errorStatusCode;
            // should only retry once.
            @Override
import com.google.api.client.http.HttpResponseException;
    public void testSimpleRetry() throws Exception {
            }
        };
        TimeValue maxWaitTime = TimeValue.timeValueMillis(10);
        RetryHttpInitializerWrapper retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(credential, oneTimeSleeper, maxWaitTime);
        JsonFactory jsonFactory = new JacksonFactory();
        FailThenSuccessBackoffTransport fakeTransport = new FailThenSuccessBackoffTransport(
        public int lowLevelExecCalls;
                response.setStatusCode(200);
        );
import com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential;
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
import com.google.api.services.compute.Compute;
        HttpResponse response = request.execute();
        RetryHttpInitializerWrapper retryHttpInitializerWrapper = new RetryHttpInitializerWrapper(
package org.opensearch.discovery.gce;
            credential,
        try {
import org.opensearch.common.unit.TimeValue;
            this.throwException = throwException;
 * KIND, either express or implied.  See the License for the
            return retryableGetRequest;
        Compute client = new Compute.Builder(fakeTransport, jsonFactory, null).setHttpRequestInitializer(retryHttpInitializerWrapper)
        FailThenSuccessBackoffTransport fakeTransport = new FailThenSuccessBackoffTransport(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, 3);
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
 * GitHub history for details.
            fail("Request should fail if wait too long");
            @Override
 * You may obtain a copy of the License at
import com.google.api.client.http.LowLevelHttpResponse;
 *
        Compute client = new Compute.Builder(fakeTransport, new JacksonFactory(), null).setHttpRequestInitializer(
        );
import com.google.api.client.testing.http.MockHttpTransport;
 *
import com.google.api.client.testing.util.MockSleeper;
        HttpRequest request = client.getRequestFactory()
                }
/*
                return response;
        }
 */
                    response.setStatusCode(errorStatusCode);
        MockSleeper mockSleeper = new MockSleeper();
        HttpRequest request = client.getRequestFactory()
        int callsBeforeSuccess;
                    if (throwException) {
        );
    public void testIOExceptionRetry() throws Exception {
        MockGoogleCredential credential = RetryHttpInitializerWrapper.newMockCredentialBuilder().build();
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
                    return response;
            public LowLevelHttpResponse execute() throws IOException {
            .setApplicationName("test")
        MockGoogleCredential credential = RetryHttpInitializerWrapper.newMockCredentialBuilder().build();
        }
            mockSleeper,
        }
        int maxRetryTimes = 50;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
            request1.execute();
        HttpResponse response = request.execute();
 * Unless required by applicable law or agreed to in writing,
            TimeValue.timeValueSeconds(5)
                        throw new IOException("Test IOException");
            this.errorStatusCode = errorStatusCode;
            HttpStatusCodes.STATUS_CODE_SERVER_ERROR,
import com.google.api.client.http.HttpResponse;
 */
            this.callsBeforeSuccess = callsBeforeSuccess;
/*
        // TODO (URL) replace w/ opensearch URL
            HttpStatusCodes.STATUS_CODE_SERVER_ERROR,
        );
        boolean throwException;
        MockGoogleCredential credential = RetryHttpInitializerWrapper.newMockCredentialBuilder().build();
        HttpRequest request1 = client.getRequestFactory()
    private static class FailThenSuccessBackoffTransport extends MockHttpTransport {
            this.callsBeforeSuccess = callsBeforeSuccess;
        MockSleeper oneTimeSleeper = new MockSleeper() {
 * Modifications Copyright OpenSearch Contributors. See
            public void sleep(long millis) throws InterruptedException {
 * license agreements. See the NOTICE file distributed with
            credential,
 */
        public LowLevelHttpRequest retryableGetRequest = new MockLowLevelHttpRequest() {
    public void testRetryWaitTooLong() throws Exception {
        };
