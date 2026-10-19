        ).setSleeper(sleeper);
import com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential;
 * You may obtain a copy of the License at  
                } else {
    // Use only for testing  
                    // and no backoff is desired.
 * Unless required by applicable law or agreed to in writing,
                    // something specific to authentication,  
 * ownership. Elasticsearch licenses this file to you under  
}  
                    logger.debug("Retrying [{}] times : [{}]", retry, request.getUrl());  
    // retry.
import com.google.api.client.http.HttpResponse;
                } else if (backoffHandler.handleResponse(request, response, supportsRetry)) {  
    // A sleeper; you can replace it with a mock in your test.
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.LogManager;
                    // the return code or message indicated
    // Use only for testing.
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
import java.util.Objects;
 * this file be licensed under the Apache-2.0 license or a
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    return true;
 * not use this file except in compliance with the License.
        this(wrappedCredential, Sleeper.DEFAULT, TimeValue.timeValueMillis(ExponentialBackOff.DEFAULT_MAX_ELAPSED_TIME_MILLIS));
 * GitHub history for details.
 * specific language governing permissions and limitations
    }
        final HttpUnsuccessfulResponseHandler backoffHandler = new HttpBackOffUnsuccessfulResponseHandler(
    @Override  
import com.google.api.client.http.HttpRequestInitializer;  
 * The OpenSearch Contributors require contributions made to  
        httpRequest.setUnsuccessfulResponseHandler(new HttpUnsuccessfulResponseHandler() {
    }
        this.wrappedCredential = Objects.requireNonNull(wrappedCredential);
import org.apache.logging.log4j.Logger;  
package org.opensearch.discovery.gce;
 * under the License.  
 */  
            }
public class RetryHttpInitializerWrapper implements HttpRequestInitializer {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public RetryHttpInitializerWrapper(Credential wrappedCredential) {  
import com.google.api.client.util.Sleeper;
        this.sleeper = sleeper;
                if (wrappedCredential.handleResponse(request, response, supportsRetry)) {  
    RetryHttpInitializerWrapper(Credential wrappedCredential, Sleeper sleeper, TimeValue maxWait) {  
        });  
        this(wrappedCredential, Sleeper.DEFAULT, maxWait);
    public void initialize(HttpRequest httpRequest) {
                    // Otherwise, we defer to the judgement of
 * Licensed to Elasticsearch under one or more contributor  
/*
 * compatible open source license.
        httpRequest.setInterceptor(wrappedCredential);  
    }
    public RetryHttpInitializerWrapper(Credential wrappedCredential, TimeValue maxWait) {
    private final Credential wrappedCredential;
 * this work for additional information regarding copyright
                    // our internal backoff handler.
    private TimeValue maxWait;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
            int retry = 0;
                    // If credential decides it can handle it,
                .setSleeper(sleeper)  
        // TODO: figure out why GCE is so bad like this
            @Override
                    return true;
    // Intercepts the request for filling in the "Authorization"
 * SPDX-License-Identifier: Apache-2.0
 *
                }
/*  
        httpRequest.setIOExceptionHandler(
 * the Apache License, Version 2.0 (the "License"); you may
            new ExponentialBackOff.Builder().setMaxElapsedTimeMillis(((int) maxWait.getMillis())).build()  
    // header field, as well as recovering from certain unsuccessful
import com.google.api.client.http.HttpRequest;
/*  
            public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) throws IOException {
    private static final Logger logger = LogManager.getLogger(RetryHttpInitializerWrapper.class);
 * KIND, either express or implied.  See the License for the
    private final Sleeper sleeper;
        );
 *
    // error codes wherein the Credential must refresh its token for a  
        this.maxWait = maxWait;  
    static MockGoogleCredential.Builder newMockCredentialBuilder() {
    }
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
        return AccessController.doPrivileged(MockGoogleCredential.Builder::new);  
import com.google.api.client.http.HttpBackOffIOExceptionHandler;  
 */
                    return false;  
            new HttpBackOffIOExceptionHandler(new ExponentialBackOff.Builder().setMaxElapsedTimeMillis(((int) maxWait.getMillis())).build())
 *  
import com.google.api.client.auth.oauth2.Credential;
import java.io.IOException;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.secure_sm.AccessController;
import com.google.api.client.util.ExponentialBackOff;  
    }  
