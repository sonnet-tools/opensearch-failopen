        if (object instanceof List) {
        return evaluate(path, Stash.EMPTY);
    /**
                    escape = false;
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * compatible open source license.
     * Returns the object corresponding to the provided path if present, null otherwise
        byte[] bytes = EntityUtils.toByteArray(response.getEntity());
 */
            char c = path.charAt(i);
        }
                escape = true;
            if (c == '\\') {
                return new ObjectPath(parser.listOrderedMap());
    private final Object object;
import java.util.ArrayList;
            if ("_arbitrary_key_".equals(key)) {
        }
            list.add(current.toString());
import org.opensearch.core.common.bytes.BytesReference;
                        current.setLength(0);
            current.append(c);
                }
        ) {
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor
        if (object instanceof Map) {
     * the result of calling {@link #evaluate(String)} on it.
                    "element was a list with " + list.size() + " elements, but [" + key + "] was out of bounds",
            final Map<String, Object> objectAsMap = (Map<String, Object>) object;
            if (parser.nextToken() == XContentParser.Token.START_ARRAY) {
/*
            }
                );
        for (String part : parts) {
        if (this.object instanceof Map) {
                continue;
            }
                if (objectAsMap.containsKey(key)) {
        }
        return builder;
            if (c == '.') {
import org.opensearch.core.xcontent.XContentParser;
            key = stash.getValue(key).toString();
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
 * license agreements. See the NOTICE file distributed with
                }
    }
                return null;
    public static ObjectPath createFromResponse(Response response) throws IOException {
        this.object = object;
 */
    public ObjectPath(Object object) {
                    if (current.length() > 0) {
    public static ObjectPath createFromXContent(XContent xContent, BytesReference input) throws IOException {
 *
            XContentParser parser = xContent.createParser(
        return new ObjectPath(object).evaluate(path, Stash.EMPTY);
                return objectAsMap.keySet().iterator().next();
    /**
     * Returns the object corresponding to the provided path if present, null otherwise
 * KIND, either express or implied.  See the License for the
                NamedXContentRegistry.EMPTY,
                    throw new IllegalArgumentException("requested meta-key [" + key + "] but the map unexpectedly contains this key");
/**
import java.io.IOException;
import org.opensearch.client.Response;
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.core.xcontent.XContent;
 * Holds an object and allows to extract specific values from it given their path
            }
                    throw new IllegalArgumentException("requested [" + key + "] but the map was empty");
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.DeprecationHandler;
        return (T) object;
 */
public class ObjectPath {
        boolean escape = false;
    }
                }
    }
    }
        } else {
        }
import org.opensearch.core.xcontent.MediaType;
    }
     */
        XContentBuilder builder = XContentBuilder.builder(xContent);
 * Unless required by applicable law or agreed to in writing,
                input.streamInput()
        String contentType = response.getHeader("Content-Type");
        MediaType mediaType = MediaType.fromMediaType(contentType);
    private Object evaluate(String key, Object object, Stash stash) throws IOException {
                    }
 * this file be licensed under the Apache-2.0 license or a
        return list.toArray(new String[0]);
    public XContentBuilder toXContentBuilder(XContent xContent) throws IOException {
    /**
        if (current.length() > 0) {
        }
        for (int i = 0; i < path.length(); i++) {
        List<String> list = new ArrayList<>();
 * the Apache License, Version 2.0 (the "License"); you may
 *
                if (escape) {
     * Create a new {@link XContentBuilder} from the xContent object underlying this {@link ObjectPath}.
    /**
 * GitHub history for details.
/*
        throw new IllegalArgumentException("no object found for [" + key + "] within object of class [" + object.getClass() + "]");
        if (stash.containsStashedValue(key)) {
        StringBuilder current = new StringBuilder();
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                    e
            try {
            }
                throw new IllegalArgumentException("element was a list, but [" + key + "] was not numeric", e);
            if (object == null) {
    @SuppressWarnings("unchecked")
    }
        }
    @SuppressWarnings("unchecked")
                if (objectAsMap.isEmpty()) {
    public static <T> T evaluate(Object object, String path) throws IOException {
 * not use this file except in compliance with the License.
            }
                        list.add(current.toString());
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * software distributed under the License is distributed on an
/*
 *
     */
    private String[] parsePath(String path) {
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;
            return objectAsMap.get(key);
            throw new UnsupportedOperationException("Only ObjectPath created from a map supported.");
            builder.map((Map<String, Object>) this.object);
    @SuppressWarnings("unchecked")
 * You may obtain a copy of the License at
            } catch (IndexOutOfBoundsException e) {
                } else {
                return list.get(Integer.valueOf(key));
     * substructures. We throw an {@link UnsupportedOperationException} in those cases.
        Object object = this.object;
            )
package org.opensearch.test.rest.yaml;
 * ownership. Elasticsearch licenses this file to you under
}
 * under the License.
    public <T> T evaluate(String path, Stash stash) throws IOException {
     */
        try (
    public <T> T evaluate(String path) throws IOException {
        String[] parts = parsePath(path);
 * The OpenSearch Contributors require contributions made to
     * This only works for {@link ObjectPath} instances created from an xContent object, not from nested
     * A utility method that creates an {@link ObjectPath} via {@link #ObjectPath(Object)} returns
            List<Object> list = (List<Object>) object;
 * this work for additional information regarding copyright
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                    continue;
import org.opensearch.core.xcontent.XContentBuilder;
 * specific language governing permissions and limitations
            return new ObjectPath(parser.mapOrdered());
        return ObjectPath.createFromXContent(mediaType.xContent(), new BytesArray(bytes));
import org.apache.hc.core5.http.io.entity.EntityUtils;
    }
            object = evaluate(part, object, stash);
     */
