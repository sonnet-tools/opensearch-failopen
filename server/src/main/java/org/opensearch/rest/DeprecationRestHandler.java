     */
     * This is only expected to be used for assertions. The idea is that only readable US-ASCII characters are expected; the rest must be  
            // 32 = ' ' (31 = unit separator); 126 = '~' (127 = DEL)
import org.opensearch.core.common.Strings;
     * @return Always {@code value}.  
        }  
     * <p>
     * @throws IllegalArgumentException if {@code value} is not a {@link #validHeaderValue(String) valid header}.
     * Throw an exception if the {@code value} is not a {@link #validHeaderValue(String) valid header}.  
     * @param value The header value to check  
     *
package org.opensearch.rest;
 * ownership. Elasticsearch licenses this file to you under  
     * This does a very basic pass at validating that a header's value contains only expected characters according to RFC-5987, and those
     * deprecation {@code warning}.
 * You may obtain a copy of the License at  
        deprecationLogger.deprecate("deprecated_route", deprecationMessage);
     * Create a {@link DeprecationRestHandler} that encapsulates the {@code handler} using the {@code deprecationLogger} to log
     * @param deprecationLogger The deprecation logger  
public class DeprecationRestHandler implements RestHandler {  
        for (int i = 0; i < value.length(); i++) {
/*
        this.deprecationLogger = Objects.requireNonNull(deprecationLogger);
    private final String deprecationMessage;  
     * @throws IllegalArgumentException if {@code deprecationMessage} is not a valid header
        }  
 * software distributed under the License is distributed on an
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
     *  
 * compatible open source license.
     * that it references.
        this.deprecationMessage = requireValidHeader(deprecationMessage);  
    public static String requireValidHeader(String value) {  
        return handler.supportsContentStream();  
 * Licensed to Elasticsearch under one or more contributor  
/**  
 *  
 * @opensearch.api
            throw new IllegalArgumentException("header value must contain only US ASCII text");
    }  
        return value;
/*
 * specific language governing permissions and limitations
    @Override
     * Usage is logged via the {@link DeprecationLogger} so that the actual response can be notified of deprecation as well.
 *
    private final DeprecationLogger deprecationLogger;
            char c = value.charAt(i);  
        if (validHeaderValue(value) == false) {
     */
 */
    /**  
 *
 *  
 * Modifications Copyright OpenSearch Contributors. See  
    private final RestHandler handler;
     * https://tools.ietf.org/html/rfc5987
 * license agreements. See the NOTICE file distributed with
            return false;
 * Unless required by applicable law or agreed to in writing,
    public boolean supportsContentStream() {
    @Override  
    /**
    }
    }
 */
            }
 * under the License.  
    }  
import org.opensearch.transport.client.node.NodeClient;
        this.handler = Objects.requireNonNull(handler);
        if (Strings.hasText(value) == false) {
 * logged using the {@link DeprecationLogger}.
 * {@code DeprecationRestHandler} provides a proxy for any existing {@link RestHandler} so that usage of the handler can be
                return false;
/*  
            if (c < 32 || c > 126) {  
     */  
 */
 * not use this file except in compliance with the License.
 */  
     * @param handler The rest handler to deprecate (it's possible that the handler is reused with a different name!)
     * <p>  
import org.opensearch.common.logging.DeprecationLogger;  
    /**  
     * @throws NullPointerException if any parameter except {@code deprecationMessage} is {@code null}
 * The OpenSearch Contributors require contributions made to  
     * @param value The header value to check
        }  
     * @param deprecationMessage The message to warn users with when they use the {@code handler}
    public DeprecationRestHandler(RestHandler handler, String deprecationMessage, DeprecationLogger deprecationLogger) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
}
 * GitHub history for details.
     * <p>  
    /**
    public static boolean validHeaderValue(String value) {  
     * encoded with percent encoding, which makes checking for a valid character range very simple.
     */
        return true;
 * the Apache License, Version 2.0 (the "License"); you may
     * @return {@code true} if the {@code value} is not obviously wrong.
        handler.handleRequest(request, channel, client);
 * this work for additional information regarding copyright
     * {@inheritDoc}
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
     *
