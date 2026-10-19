 * the Apache License, Version 2.0 (the "License"); you may
public final class WarningFailureException extends RuntimeException {  
 * this file be licensed under the Apache-2.0 license or a
/**
 * Licensed to Elasticsearch under one or more contributor  
}  
    /**
// if the exception is not of type OpenSearchException or RuntimeException it will be wrapped in a UncategorizedExecutionException
    private final Response response;
        this.response = e.getResponse();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * This exception is used to indicate that one or more {@link Response#warnings()} exist  
     *  
     * Creates a {@link WarningFailureException} instance.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    public Response getResponse() {  
        super(e.getMessage(), e);
 * and is typically used when the {@link RestHttpClient} is set to fail by setting
 *
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 */  
        this.response = response;  
 * this work for additional information regarding copyright
     */
        return response;
 * The OpenSearch Contributors require contributions made to  
    }
 *
     * @throws IOException if there is a problem building the exception message.
     */  
import static org.opensearch.internal.httpclient.ResponseException.buildMessage;  
 * KIND, either express or implied.  See the License for the
    public WarningFailureException(Response response) throws IOException {
    WarningFailureException(WarningFailureException e) {
 * GitHub history for details.
     * @param response the response that contains warnings.
 *  
     * ends up in the stack trace of the exception thrown.  
 * license agreements. See the NOTICE file distributed with
    }
/*
     * @param e the exception to be wrapped.
package org.opensearch.internal.httpclient;
    /**  
import java.io.IOException;
/*  
     */  
/*  
     * stack trace. This is used during synchronous calls so that the caller
 */  
    }
     * Wrap a {@linkplain WarningFailureException} with another one with the current
 */  
     * Returns the {@link Response} that caused this exception to be thrown.
 * Unless required by applicable law or agreed to in writing,
        super(buildMessage(response));
// This class extends RuntimeException in order to deal with wrapping that is done in FutureUtils on exception.
 * specific language governing permissions and limitations
 * {@link RestHttpClientBuilder#setStrictDeprecationMode(boolean)} to `true`.
     *
    /**  
 * You may obtain a copy of the License at  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
