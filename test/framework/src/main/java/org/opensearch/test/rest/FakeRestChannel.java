 * not use this file except in compliance with the License.
    public RestResponse capturedResponse() {  
    private final CountDownLatch latch;  
/*  
import org.opensearch.rest.RestResponse;  
import java.util.concurrent.CountDownLatch;
        if (response.status() == RestStatus.OK) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 */
        super(request, detailedErrorsEnabled);  
 * SPDX-License-Identifier: Apache-2.0
 *
 * under the License.  
import org.opensearch.core.rest.RestStatus;  
        return errors;  
        this.capturedRestResponse = response;  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
import java.util.concurrent.atomic.AtomicInteger;  
    }
            responses.incrementAndGet();
}
 * license agreements. See the NOTICE file distributed with
    private final AtomicInteger errors = new AtomicInteger();
 * the Apache License, Version 2.0 (the "License"); you may
    private final AtomicInteger responses = new AtomicInteger();
    @Override
 * software distributed under the License is distributed on an
        }
/*
        this.latch = new CountDownLatch(responseCount);
 * ownership. Elasticsearch licenses this file to you under  
            errors.incrementAndGet();
    }
 *  
/*
        latch.countDown();  
    }  
 * GitHub history for details.
import org.opensearch.rest.RestRequest;
 * this work for additional information regarding copyright
public final class FakeRestChannel extends AbstractRestChannel {
    }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.AbstractRestChannel;
package org.opensearch.test.rest;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 */
 * specific language governing permissions and limitations
    private RestResponse capturedRestResponse;  
        return responses;
        return capturedRestResponse;
 * The OpenSearch Contributors require contributions made to  
        } else {  
    public AtomicInteger errors() {
    public void sendResponse(RestResponse response) {
 * Modifications Copyright OpenSearch Contributors. See  
    public AtomicInteger responses() {
    public FakeRestChannel(RestRequest request, boolean detailedErrorsEnabled, int responseCount) {
