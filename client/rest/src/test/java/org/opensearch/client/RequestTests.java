                            ),
                            new ByteArrayEntity(randomBytesOfLength(40), ContentType.APPLICATION_JSON) }
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
        assertEquals(copy, request);
    }
import static org.junit.Assert.assertSame;  
        }  
            case 2:
        final HttpEntity entity = randomBoolean()
            request.setOptions((RequestOptions.Builder) null);  
            request.addParameter(null, "value");
                ? new Request(request.getMethod() + "m", request.getEndpoint())  
    }  
    }  
import java.util.Map;
 * GitHub history for details.
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
        int mutationType = between(0, 2);  
    }  
 * software distributed under the License is distributed on an
        parameters.put("is_null", null);  
        assertEquals(request, copy);  
            assertEquals("url parameter [name] has already been set to [" + firstValue + "]", e.getMessage());
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });  
    public void testSetEntity() {
            request.addParameter(entry.getKey(), entry.getValue());  
    }  
/*  
        try {  
            fail("expected failure");
        request.setJsonEntity(json);
import java.io.ByteArrayOutputStream;  
                    randomFrom(
        } catch (NullPointerException e) {
import static org.junit.Assert.assertEquals;  
        assertEquals(request.hashCode(), copy.hashCode());
 * ownership. Elasticsearch licenses this file to you under  
            to.addParameter(param.getKey(), param.getValue());
                return mutant;
        try {
        assertEquals(json, new String(os.toByteArray(), ContentType.APPLICATION_JSON.getCharset()));
 * Unless required by applicable law or agreed to in writing,
        copyMutables(request, copy);
        request.setOptions(options);  
            options.setHttpAsyncResponseConsumerFactory(new HeapBufferedResponseConsumerFactory(1));
            randomAsciiAlphanumOfLength(5)  
        try {
 *  
                : new Request(request.getMethod(), request.getEndpoint() + "m");
            case 1:
            fail("expected failure");
                );
                throw new UnsupportedOperationException("Unknown mutation type [" + mutationType + "]");
 */  
                            new StringEntity(randomAsciiAlphanumOfLength(10), ContentType.APPLICATION_JSON),  
            copyMutables(request, mutant);
import java.nio.charset.StandardCharsets;
import org.apache.hc.core5.http.ContentType;
        final Map<String, String> parameters = new HashMap<>(parametersCount);
            request.setOptions((RequestOptions) null);
            request.setOptions(options);
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });
        }
        assertNotEquals(request, mutant);
            new Request(method, null);
        }
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
        final String json = randomAsciiLettersOfLengthBetween(1, 100);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                            new InputStreamEntity(
    public void testSetJsonEntity() throws IOException {
    private static Request mutate(Request request) {
 * this work for additional information regarding copyright
import org.apache.hc.core5.http.io.entity.StringEntity;
 * specific language governing permissions and limitations
        request.addParameter("is_null", null);
    }  
        }  
                request.setEntity(  
        return request;
    public void testAddParameters() {  
import static org.junit.Assert.assertNull;
        Request request = new Request(method, endpoint);  
        request.addParameter("name", firstValue);
    public void testSetOptions() {
    private static Request randomRequest() {  
        assertEquals(method, request.getMethod());
        Request request = new Request(method, endpoint);
    public void testEqualsAndHashCode() {
                mutant.setOptions(options);
import java.io.IOException;
        return copy;
        // Test that adding a duplicate parameter fails  
        }  
            assertEquals("endpoint cannot be null", e.getMessage());
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
                        new HttpEntity[] {
            request.addParameter(randomAsciiAlphanumOfLength(i), randomAsciiLettersOfLength(3));
        request.setOptions(builder);
        try {
            request.addParameter("name", randomBoolean() ? firstValue : "second_value");
        Request copy = copy(request);
        }
        }  
            fail("expected failure");  
        assertEquals(ContentType.APPLICATION_JSON.toString(), request.getEntity().getContentType());
        assertNull(request.getEntity());
            case 0:
import org.apache.hc.core5.http.HttpEntity;
        } catch (NullPointerException e) {  
            }
        to.setEntity(from.getEntity());
                mutant.setJsonEntity("mutant"); // randomRequest can't produce this value  
        switch (mutationType) {
        while (parameters.size() < parametersCount) {
                return mutant;
import static org.junit.Assert.assertNotEquals;
        assertEquals(builder.build(), request.getOptions());
        for (Map.Entry<String, String> param : from.getParameters().entrySet()) {
        int parametersCount = between(1, 3);  
            randomFrom(new String[] { "GET", "PUT", "DELETE", "POST", "HEAD", "OPTIONS" }),
                options.addHeader("extra", "m");
 * not use this file except in compliance with the License.
import java.util.HashMap;  
        );
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
        request.getEntity().writeTo(os);
            return mutant;  
        Request mutant = mutate(request);
        Request mutant = copy(request);
                    )  
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
import static org.junit.Assert.fail;
 * Modifications Copyright OpenSearch Contributors. See
        RequestOptions options = builder.build();
        assertEquals(parameters, request.getParameters());
        }  
        to.setOptions(from.getOptions());
        final Request request = new Request(method, endpoint);
        try {  
        assertEquals(endpoint, request.getEndpoint());  
                RequestOptions.Builder options = mutant.getOptions().toBuilder();  
    }
            fail("expected failure");
 */  
package org.opensearch.client;
        }  
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;  
                                new ByteArrayInputStream(randomAsciiAlphanumOfLength(10).getBytes(StandardCharsets.UTF_8)),
 *
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });  
        Request copy = new Request(request.getMethod(), request.getEndpoint());  
            default:
        assertEquals(entity, request.getEntity());
public class RequestTests extends RestClientTestCase {  
}
        } catch (NullPointerException e) {
        } catch (NullPointerException e) {
        }
        }
            fail("expected failure");  
            assertEquals("options cannot be null", e.getMessage());
            assertEquals("method cannot be null", e.getMessage());  
/*  
                                ContentType.APPLICATION_JSON  
    }
            // Mutate request or method but keep everything else constant
        assertNotEquals(mutant, request);  
            } else {
    private static void copyMutables(Request from, Request to) {  
        assertEquals(parameters, request.getParameters());
    public void testConstructor() {
 * SPDX-License-Identifier: Apache-2.0
        Request request = new Request(method, endpoint);
            parameters.put(randomAsciiLettersOfLength(5), randomAsciiLettersOfLength(5));  
        // Test that adding parameters with a null value is ok.
            if (randomBoolean()) {  
 * under the License.  
        }  
    private static Request copy(Request request) {
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);
            RequestOptions.Builder options = request.getOptions().toBuilder();  
 *
            assertEquals("options cannot be null", e.getMessage());  
        if (randomBoolean()) {  
/*
        Request request = new Request(method, endpoint);  
            Request mutant = randomBoolean()
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
                mutant.addParameter(randomAsciiAlphanumOfLength(mutant.getParameters().size() + 4), "extra");  
        int parameterCount = between(0, 5);  
 * You may obtain a copy of the License at  
        } catch (IllegalArgumentException e) {  
        String firstValue = randomBoolean() ? null : "value";
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        for (int i = 0; i < parameterCount; i++) {
        assertEquals(request, request);  
            new Request(null, endpoint);  
            assertEquals("url parameter name cannot be null", e.getMessage());
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        if (randomBoolean()) {
import java.io.ByteArrayInputStream;
 * KIND, either express or implied.  See the License for the
import org.opensearch.client.HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory;  
        try {
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });
        Request request = new Request(
        builder = RequestOptionsTests.randomBuilder();
        } catch (NullPointerException e) {
        final String method = randomFrom(new String[] { "GET", "PUT", "POST", "HEAD", "DELETE" });  
 * Licensed to Elasticsearch under one or more contributor  
        final String endpoint = randomAsciiLettersOfLengthBetween(1, 10);  
        request.setEntity(entity);
            ? new StringEntity(randomAsciiLettersOfLengthBetween(1, 100), ContentType.TEXT_PLAIN)  
        Request request = randomRequest();
        RequestOptions.Builder builder = RequestOptionsTests.randomBuilder();  
            : null;
 */
 * The OpenSearch Contributors require contributions made to  
    }
                return mutant;  
        assertSame(options, request.getOptions());
            fail("expected failure");
                request.setJsonEntity(randomAsciiAlphanumOfLength(10));
