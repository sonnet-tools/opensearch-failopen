        Timeout connectTimeout = Timeout.ofMilliseconds(100);
            }  
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
import java.util.HashMap;
            case 1:  
        RequestOptions options = builder.build();  
            () -> randomBuilder().addParameter(randomAsciiLettersOfLengthBetween(3, 10), null)  
        assertEquals(HttpAsyncResponseConsumerFactory.DEFAULT, RequestOptions.DEFAULT.getHttpAsyncResponseConsumerFactory());
            () -> randomBuilder().addParameter(null, randomAsciiLettersOfLengthBetween(3, 10))  
                builder.addParameter(randomAsciiAlphanumOfLength(3), randomAsciiAlphanumOfLength(3));  
            fail("expected failure");
        try {  
        try {
        }
        assertEquals(options.getRequestConfig().getResponseTimeout(), responseTimeout);
import org.apache.hc.client5.http.config.RequestConfig;
 * The OpenSearch Contributors require contributions made to  
        }
        assertNotEquals(request, mutant);
            RequestOptions.DEFAULT.toBuilder().setHttpAsyncResponseConsumerFactory(null);
 * GitHub history for details.
            "query parameter name cannot be null",
    }  
                        fail("never called");
    }  
        for (int i = 0; i < numParameters; i++) {  
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();  
            case 0:  
 * Modifications Copyright OpenSearch Contributors. See
                return mutant.build();
        assertEquals(request, copy);
        }
            int headerCount = between(1, 5);  
        HttpAsyncResponseConsumerFactory factory = mock(HttpAsyncResponseConsumerFactory.class);
        assertThrows(  
        try {
public class RequestOptionsTests extends RestClientTestCase {
            for (int i = 0; i < queryParamCount; i++) {
    public void testSetHttpAsyncResponseConsumerFactory() {
                mutant.addHeader("extra", "m");
        }  
        Timeout responseTimeout = Timeout.ofMilliseconds(10000);  
        assertEquals(Collections.<Header>emptyList(), RequestOptions.DEFAULT.getHeaders());
    }  
            String value = randomAsciiAlphanumOfLength(3);
                builder.addHeader(randomAsciiAlphanumOfLength(3), randomAsciiAlphanumOfLength(3));
        assertEquals(headers, options.getHeaders());  
            options.getHeaders()  
        assertThrows(  
        requestConfigBuilder.setResponseTimeout(responseTimeout).setConnectTimeout(connectTimeout);
        assertEquals(copy, request);  
        List<Header> headers = new ArrayList<>();
    }  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
                .add(new RequestOptions.ReqHeader(randomAsciiAlphanumOfLengthBetween(5, 10), randomAsciiAlphanumOfLength(3)));
 * SPDX-License-Identifier: Apache-2.0
        RequestOptions options = builder.build();
            fail("expected failure");  
            assertNull(e.getMessage());
 * Unless required by applicable law or agreed to in writing,
            "query parameter value cannot be null",
            case 2:  
                mutant.setHttpAsyncResponseConsumerFactory(new HeapBufferedResponseConsumerFactory(5));
    public void testEqualsAndHashCode() {  
        RequestOptions copy = copy(request);
        }
import static org.junit.Assert.fail;
            fail("expected failure");
        if (randomBoolean()) {
/*
        assertNotEquals(mutant, request);
        int numHeaders = between(0, 5);
import static org.junit.Assert.assertNull;
        RequestOptions request = randomBuilder().build();
        return options.toBuilder().build();
        try {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        RequestOptions.Builder mutant = options.toBuilder();  
            builder.setHttpAsyncResponseConsumerFactory(new HeapBufferedResponseConsumerFactory(1));
import org.apache.hc.core5.http.Header;
                    }  
    }
import org.apache.hc.core5.util.Timeout;  
            randomBuilder().addHeader(randomAsciiLettersOfLengthBetween(3, 10), null);  
 */  
import java.util.Collections;
                throw new UnsupportedOperationException("Unknown mutation type [" + mutationType + "]");
        assertEquals(parameters, options.getParameters());
        for (int i = 0; i < numHeaders; i++) {  
        }
                return mutant.build();
        );
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();  
        builder.setRequestConfig(requestConfig);
 *  
    }  
        RequestConfig requestConfig = requestConfigBuilder.build();  
        } catch (NullPointerException e) {
    public void testSetRequestBuilder() {
 * this work for additional information regarding copyright
                    @Override
        }
        assertEquals(RequestOptions.DEFAULT, RequestOptions.DEFAULT.toBuilder().build());  
                });
            String name = randomAsciiAlphanumOfLengthBetween(5, 10);
            headers.add(header);
    public void testDefault() {  
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();  
            assertEquals("httpAsyncResponseConsumerFactory cannot be null", e.getMessage());
        }  
        int mutationType = between(0, 2);
        assertEquals(request, request);
        Map<String, String> parameters = new HashMap<>();
 * compatible open source license.
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
import org.opensearch.client.HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory;
 * ownership. Elasticsearch licenses this file to you under  
            fail("expected failure");
            for (int i = 0; i < headerCount; i++) {
        }
        assertSame(factory, options.getHttpAsyncResponseConsumerFactory());
import java.util.Map;
        }
            assertEquals("header name cannot be null", e.getMessage());
            builder.addHeader(header.getName(), header.getValue());  
    }
            options.getParameters().put(randomAsciiAlphanumOfLengthBetween(5, 10), randomAsciiAlphanumOfLength(3));
 *
    public void testAddHeader() {  
import java.util.List;  
        RequestOptions options = builder.build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return builder;
            default:  
        RequestOptions mutant = mutate(request);  
            randomBuilder().addHeader(null, randomAsciiLettersOfLengthBetween(3, 10));
    }
        }
        try {
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import static org.junit.Assert.assertNotEquals;
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
        } catch (NullPointerException e) {  
            builder.setRequestConfig(RequestConfig.custom().build());
    static RequestOptions.Builder randomBuilder() {
import java.util.ArrayList;  
        assertEquals(options.getRequestConfig().getConnectTimeout(), connectTimeout);  
import static org.mockito.Mockito.mock;  
 */
    private static RequestOptions mutate(RequestOptions options) {
            Header header = new RequestOptions.ReqHeader(randomAsciiAlphanumOfLengthBetween(5, 10), randomAsciiAlphanumOfLength(3));
        switch (mutationType) {
/*  
 * specific language governing permissions and limitations
                        return false;
            NullPointerException.class,
        assertEquals(request.hashCode(), copy.hashCode());
            assertEquals("header value cannot be null", e.getMessage());  
                mutant.setWarningsHandler(new WarningsHandler() {
 * under the License.  
        }
        RequestOptions options = builder.build();
            parameters.put(name, value);  
        if (randomBoolean()) {
    public void testAddParameter() {
            int queryParamCount = between(1, 5);
        } catch (NullPointerException e) {
package org.opensearch.client;
        int numParameters = between(0, 5);
 * not use this file except in compliance with the License.
            builder.setWarningsHandler(randomBoolean() ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE);  
/*  
 * this file be licensed under the Apache-2.0 license or a
            NullPointerException.class,
            }
            assertNull(e.getMessage());
        } catch (UnsupportedOperationException e) {  
            fail("expected failure");
                return mutant.build();
import static org.junit.Assert.assertSame;  
}
        assertSame(options.getRequestConfig(), requestConfig);
 */  
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();  
        }
        builder.setHttpAsyncResponseConsumerFactory(factory);  
            builder.addParameter(name, value);
        if (randomBoolean()) {  
                    public boolean warningsShouldFailRequest(List<String> warnings) {  
        );
    private static RequestOptions copy(RequestOptions options) {
import static org.junit.Assert.assertThrows;
 *
        if (randomBoolean()) {  
import static org.junit.Assert.assertEquals;  
        } catch (UnsupportedOperationException e) {  
