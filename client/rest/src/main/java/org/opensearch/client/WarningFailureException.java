     *  
 * software distributed under the License is distributed on an
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
// This class extends RuntimeException in order to deal with wrapping that is done in FutureUtils on exception.
 * This exception is used to indicate that one or more {@link Response#getWarnings()} exist  
 *  
     *
 */  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 */  
    private final Response response;
 */
 * compatible open source license.
import java.io.IOException;
     * @param e the exception to be wrapped.
/**
    public WarningFailureException(Response response) throws IOException {
     * Wrap a {@linkplain WarningFailureException} with another one with the current
/*  
    }
}  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
     * @param response the response that contains warnings.
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
     * ends up in the stack trace of the exception thrown.  
 * and is typically used when the {@link RestClient} is set to fail by setting
    public Response getResponse() {  
    /**
 *
        this.response = e.getResponse();  
     * Returns the {@link Response} that caused this exception to be thrown.
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(e.getMessage(), e);
package org.opensearch.client;
 * {@link RestClientBuilder#setStrictDeprecationMode(boolean)} to `true`.
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
    /**  
     */  
        return response;
    }
        this.response = response;  
 * this work for additional information regarding copyright
/*
     * @throws IOException if there is a problem building the exception message.
    /**  
 * You may obtain a copy of the License at  
     * stack trace. This is used during synchronous calls so that the caller
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
public final class WarningFailureException extends RuntimeException {  
 *
     * Creates a {@link WarningFailureException} instance.
        super(buildMessage(response));
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
// if the exception is not of type OpenSearchException or RuntimeException it will be wrapped in a UncategorizedExecutionException
import static org.opensearch.client.ResponseException.buildMessage;  
     */
    WarningFailureException(WarningFailureException e) {
