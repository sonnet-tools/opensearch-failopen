        for (int i = 0; i < numParameters; i++) {
            randomBuilder().addHeader(null, randomAsciiLettersOfLengthBetween(3, 10));
            assertNull(e.getMessage());
        HttpAsyncResponseConsumerFactory factory = mock(HttpAsyncResponseConsumerFactory.class);
    public void testEqualsAndHashCode() {
        }
        assertNotEquals(mutant, request);
                return mutant.build();
        assertEquals(request, copy);
            fail("expected failure");
import static org.junit.Assert.assertNull;
                builder.addParameter(randomAsciiAlphanumOfLength(3), randomAsciiAlphanumOfLength(3));
        if (randomBoolean()) {
            parameters.put(name, value);
        assertEquals(request.hashCode(), copy.hashCode());
                return mutant.build();
        RequestOptions options = builder.build();
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        }
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
 * You may obtain a copy of the License at
        }
            String value = randomAsciiAlphanumOfLength(3);
    }
import static org.junit.Assert.assertThrows;
        try {
            }
    }
    public void testAddHeader() {
        RequestConfig requestConfig = requestConfigBuilder.build();
 * Modifications Copyright OpenSearch Contributors. See
            int queryParamCount = between(1, 5);
        assertEquals(headers, options.getHeaders());
                builder.addHeader(randomAsciiAlphanumOfLength(3), randomAsciiAlphanumOfLength(3));
    }
            "query parameter value cannot be null",
        assertEquals(options.getRequestConfig().getConnectTimeout(), connectTimeout);
                    @Override
 */
        }
            assertEquals("header name cannot be null", e.getMessage());
    private static RequestOptions copy(RequestOptions options) {
        assertEquals(HttpAsyncResponseConsumerFactory.DEFAULT, RequestOptions.DEFAULT.getHttpAsyncResponseConsumerFactory());
                    }
        Timeout connectTimeout = Timeout.ofMilliseconds(100);
        requestConfigBuilder.setResponseTimeout(responseTimeout).setConnectTimeout(connectTimeout);
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
            int headerCount = between(1, 5);
        assertEquals(parameters, options.getParameters());
 */
        );
                mutant.addHeader("extra", "m");
 * KIND, either express or implied.  See the License for the
    public void testAddParameter() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(options.getRequestConfig().getResponseTimeout(), responseTimeout);
            options.getHeaders()
        List<Header> headers = new ArrayList<>();
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
        assertEquals(RequestOptions.DEFAULT, RequestOptions.DEFAULT.toBuilder().build());
            for (int i = 0; i < headerCount; i++) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        } catch (NullPointerException e) {
    }
 * this work for additional information regarding copyright
            case 2:
            builder.addParameter(name, value);
        if (randomBoolean()) {
public class RequestOptionsTests extends RestClientTestCase {
        }
        int numHeaders = between(0, 5);
        }
    }
                });
    }
/*
        assertEquals(request, request);
        return options.toBuilder().build();
/*
import org.apache.hc.core5.http.Header;
        RequestOptions options = builder.build();
            default:
                mutant.setHttpAsyncResponseConsumerFactory(new HeapBufferedResponseConsumerFactory(5));
package org.opensearch.client;
        if (randomBoolean()) {
            () -> randomBuilder().addParameter(null, randomAsciiLettersOfLengthBetween(3, 10))
            "query parameter name cannot be null",
        return builder;
            headers.add(header);
        } catch (UnsupportedOperationException e) {
            builder.setHttpAsyncResponseConsumerFactory(new HeapBufferedResponseConsumerFactory(1));
            Header header = new RequestOptions.ReqHeader(randomAsciiAlphanumOfLengthBetween(5, 10), randomAsciiAlphanumOfLength(3));
            builder.setWarningsHandler(randomBoolean() ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE);
}
import static org.junit.Assert.assertEquals;
            case 0:
    }
        }
    static RequestOptions.Builder randomBuilder() {
        } catch (NullPointerException e) {
                mutant.setWarningsHandler(new WarningsHandler() {
        RequestOptions.Builder mutant = options.toBuilder();
        try {
        assertThrows(
            randomBuilder().addHeader(randomAsciiLettersOfLengthBetween(3, 10), null);
        assertNotEquals(request, mutant);
            NullPointerException.class,
        assertThrows(
        RequestOptions mutant = mutate(request);
 * Unless required by applicable law or agreed to in writing,
            fail("expected failure");
                .add(new RequestOptions.ReqHeader(randomAsciiAlphanumOfLengthBetween(5, 10), randomAsciiAlphanumOfLength(3)));
        switch (mutationType) {
        }
    }
            () -> randomBuilder().addParameter(randomAsciiLettersOfLengthBetween(3, 10), null)
 * license agreements. See the NOTICE file distributed with
        RequestOptions options = builder.build();
        builder.setRequestConfig(requestConfig);
 * Licensed to Elasticsearch under one or more contributor
        try {
        }
            for (int i = 0; i < queryParamCount; i++) {
        RequestOptions copy = copy(request);
            builder.addHeader(header.getName(), header.getValue());
        try {
import static org.junit.Assert.assertNotEquals;
 *
 * this file be licensed under the Apache-2.0 license or a
        int numParameters = between(0, 5);
    private static RequestOptions mutate(RequestOptions options) {
 */
import org.opensearch.client.HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory;
        if (randomBoolean()) {
            RequestOptions.DEFAULT.toBuilder().setHttpAsyncResponseConsumerFactory(null);
        assertSame(options.getRequestConfig(), requestConfig);
import java.util.Map;
        int mutationType = between(0, 2);
 * the Apache License, Version 2.0 (the "License"); you may
        assertSame(factory, options.getHttpAsyncResponseConsumerFactory());
 *
        builder.setHttpAsyncResponseConsumerFactory(factory);
            String name = randomAsciiAlphanumOfLengthBetween(5, 10);
        } catch (UnsupportedOperationException e) {
        }
            options.getParameters().put(randomAsciiAlphanumOfLengthBetween(5, 10), randomAsciiAlphanumOfLength(3));
            assertNull(e.getMessage());
 * specific language governing permissions and limitations
                    public boolean warningsShouldFailRequest(List<String> warnings) {
/*
    }
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("httpAsyncResponseConsumerFactory cannot be null", e.getMessage());
 *
        }
import static org.mockito.Mockito.mock;
 * GitHub history for details.
                throw new UnsupportedOperationException("Unknown mutation type [" + mutationType + "]");
        RequestOptions options = builder.build();
            builder.setRequestConfig(RequestConfig.custom().build());
 * compatible open source license.
        RequestOptions request = randomBuilder().build();
        }
import org.apache.hc.client5.http.config.RequestConfig;
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
import java.util.HashMap;
    public void testSetRequestBuilder() {
 * not use this file except in compliance with the License.
        Map<String, String> parameters = new HashMap<>();
                        fail("never called");
import static org.junit.Assert.fail;
        for (int i = 0; i < numHeaders; i++) {
    public void testDefault() {
        assertEquals(copy, request);
        try {
                        return false;
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
    public void testSetHttpAsyncResponseConsumerFactory() {
            fail("expected failure");
        } catch (NullPointerException e) {
import static org.junit.Assert.assertSame;
            assertEquals("header value cannot be null", e.getMessage());
import java.util.Collections;
            }
 * software distributed under the License is distributed on an
            case 1:
            NullPointerException.class,
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
import org.apache.hc.core5.util.Timeout;
        Timeout responseTimeout = Timeout.ofMilliseconds(10000);
        }
        assertEquals(Collections.<Header>emptyList(), RequestOptions.DEFAULT.getHeaders());
import java.util.ArrayList;
        );
                return mutant.build();
import java.util.List;
            fail("expected failure");
            fail("expected failure");
