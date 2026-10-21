        assertEquals(parameters, request.getParameters());
 * not use this file except in compliance with the License.
        return copy;
}
            new Request(null, endpoint);
                            ),
        assertEquals(builder.build(), request.getOptions());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertNotEquals(request, mutant);
        }
            assertEquals("options cannot be null", e.getMessage());
        }
            request.addParameter("name", randomBoolean() ? firstValue : "second_value");
        Request request = new Request(method, endpoint);
 */
        assertNotEquals(mutant, request);
import static org.junit.Assert.assertEquals;
        }
        } catch (NullPointerException e) {
            } else {
                return mutant;
            assertEquals("url parameter [name] has already been set to [" + firstValue + "]", e.getMessage());
 * Modifications Copyright OpenSearch Contributors. See
import static org.junit.Assert.assertNotEquals;
            request.setOptions((RequestOptions) null);
                throw new UnsupportedOperationException("Unknown mutation type [" + mutationType + "]");
                request.setJsonEntity(randomAsciiAlphanumOfLength(10));
        Request request = new Request(method, endpoint);
 * compatible open source license.
            assertEquals("options cannot be null", e.getMessage());
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });
import org.apache.hc.core5.http.ContentType;
    private static Request copy(Request request) {
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
    public void testEqualsAndHashCode() {
 * license agreements. See the NOTICE file distributed with
/*
            request.addParameter(entry.getKey(), entry.getValue());
        request.setJsonEntity(json);
 */
            RequestOptions.Builder options = request.getOptions().toBuilder();
        Request request = new Request(method, endpoint);
            }
        Request copy = new Request(request.getMethod(), request.getEndpoint());
    }
 * GitHub history for details.
        }
import java.io.IOException;
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
        assertEquals(ContentType.APPLICATION_JSON.toString(), request.getEntity().getContentType());
                ? new Request(request.getMethod() + "m", request.getEndpoint())
        } catch (NullPointerException e) {
import static org.junit.Assert.fail;
            fail("expected failure");
            parameters.put(randomAsciiLettersOfLength(5), randomAsciiLettersOfLength(5));
        try {
            return mutant;
        );
        } catch (IllegalArgumentException e) {
            if (randomBoolean()) {
import java.util.Map;
            options.setHttpAsyncResponseConsumerFactory(new HeapBufferedResponseConsumerFactory(1));
        builder = RequestOptionsTests.randomBuilder();
        }
        }
            request.setOptions((RequestOptions.Builder) null);
            randomFrom(new String[] { "GET", "PUT", "DELETE", "POST", "HEAD", "OPTIONS" }),
import java.io.ByteArrayInputStream;
        assertEquals(method, request.getMethod());
        } catch (NullPointerException e) {
        final HttpEntity entity = randomBoolean()
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            request.addParameter(randomAsciiAlphanumOfLength(i), randomAsciiLettersOfLength(3));
        while (parameters.size() < parametersCount) {
        assertEquals(request.hashCode(), copy.hashCode());
        int parametersCount = between(1, 3);
import java.util.HashMap;
        assertEquals(parameters, request.getParameters());
    }
        }
        request.setEntity(entity);
        assertEquals(json, new String(os.toByteArray(), ContentType.APPLICATION_JSON.getCharset()));
 * The OpenSearch Contributors require contributions made to
            copyMutables(request, mutant);
        request.setOptions(builder);
    }
                                new ByteArrayInputStream(randomAsciiAlphanumOfLength(10).getBytes(StandardCharsets.UTF_8)),
        Request mutant = copy(request);
import org.apache.hc.core5.http.io.entity.StringEntity;
        // Test that adding parameters with a null value is ok.
            fail("expected failure");
        } catch (NullPointerException e) {
            case 2:
        try {
        int parameterCount = between(0, 5);
            to.addParameter(param.getKey(), param.getValue());
 * this file be licensed under the Apache-2.0 license or a
        }
        Request request = randomRequest();
        request.setOptions(options);
                request.setEntity(
        Request mutant = mutate(request);
                : new Request(request.getMethod(), request.getEndpoint() + "m");
            Request mutant = randomBoolean()
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
 *
                );
 * specific language governing permissions and limitations
    }
        final Map<String, String> parameters = new HashMap<>(parametersCount);
        }
 * this work for additional information regarding copyright
import static org.junit.Assert.assertSame;
    }
        RequestOptions options = builder.build();
 * KIND, either express or implied.  See the License for the
/*
            ? new StringEntity(randomAsciiLettersOfLengthBetween(1, 100), ContentType.TEXT_PLAIN)
        try {
                    )
import java.io.ByteArrayOutputStream;
                            new ByteArrayEntity(randomBytesOfLength(40), ContentType.APPLICATION_JSON) }
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });
            assertEquals("method cannot be null", e.getMessage());
 */
        Request request = new Request(
            randomAsciiAlphanumOfLength(5)
        int mutationType = between(0, 2);
                return mutant;
            assertEquals("endpoint cannot be null", e.getMessage());
import java.nio.charset.StandardCharsets;
        try {
                mutant.setOptions(options);
        for (Map.Entry<String, String> param : from.getParameters().entrySet()) {
                options.addHeader("extra", "m");
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
            fail("expected failure");
        String firstValue = randomBoolean() ? null : "value";
            fail("expected failure");
        final String json = randomAsciiLettersOfLengthBetween(1, 100);
package org.opensearch.client;
    public void testConstructor() {
                            new InputStreamEntity(
    private static Request mutate(Request request) {
        } catch (NullPointerException e) {
            request.setOptions(options);
        request.getEntity().writeTo(os);
 *
        assertEquals(endpoint, request.getEndpoint());
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
        }
        to.setEntity(from.getEntity());
            new Request(method, null);
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });
    public void testSetJsonEntity() throws IOException {
                RequestOptions.Builder options = mutant.getOptions().toBuilder();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
 * under the License.
        try {
 * Licensed to Elasticsearch under one or more contributor
        return request;
 * ownership. Elasticsearch licenses this file to you under
                            new StringEntity(randomAsciiAlphanumOfLength(10), ContentType.APPLICATION_JSON),
 * SPDX-License-Identifier: Apache-2.0
    }
        }
import org.apache.hc.core5.http.HttpEntity;
 *
            : null;
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });
 * software distributed under the License is distributed on an
            case 1:
import static org.junit.Assert.assertNull;
        if (randomBoolean()) {
                return mutant;
    }
 * You may obtain a copy of the License at
        if (randomBoolean()) {
                                ContentType.APPLICATION_JSON
            case 0:
                    randomFrom(
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(request, request);
                mutant.addParameter(randomAsciiAlphanumOfLength(mutant.getParameters().size() + 4), "extra");
            assertEquals("url parameter name cannot be null", e.getMessage());
        if (randomBoolean()) {
        // Test that adding a duplicate parameter fails
        RequestOptions.Builder builder = RequestOptionsTests.randomBuilder();
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
                        new HttpEntity[] {
    private static Request randomRequest() {
    public void testAddParameters() {
    }
        Request copy = copy(request);
        assertNull(request.getEntity());
        assertEquals(request, copy);
        request.addParameter("is_null", null);
 * Unless required by applicable law or agreed to in writing,
        request.addParameter("name", firstValue);
        parameters.put("is_null", null);
            default:
public class RequestTests extends RestClientTestCase {
            request.addParameter(null, "value");
            // Mutate request or method but keep everything else constant
        switch (mutationType) {
        to.setOptions(from.getOptions());
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });
        assertEquals(copy, request);
        assertSame(options, request.getOptions());
        }
            fail("expected failure");
    public void testSetOptions() {
        for (int i = 0; i < parameterCount; i++) {
import org.opensearch.client.HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory;
        try {
        Request request = new Request(method, endpoint);
        final Request request = new Request(method, endpoint);
    }
        copyMutables(request, copy);
    private static void copyMutables(Request from, Request to) {
        }
    public void testSetEntity() {
/*
        assertEquals(entity, request.getEntity());
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
            fail("expected failure");
        }
                mutant.setJsonEntity("mutant"); // randomRequest can't produce this value
