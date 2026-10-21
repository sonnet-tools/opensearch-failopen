            MediaType mediaType = getContentType(headers, STREAMING_CONTENT_TYPES);
            if (stash.containsStashedValue(entry.getValue())) {
                BytesRef bytesRef = bodyAsBytesRef(body, mediaType);
    }
        Map<String, String> requestParams = new HashMap<>(params);
        if (bodies.size() == 1) {
    // pkg-private for testing
    private MediaType getContentType(Map<String, String> headers, MediaType[] supportedContentTypes) {
            );
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
        NodeSelector nodeSelector
    }
        return stash;
     */
    ) throws IOException {
    ) throws IOException {
    private BytesRef bodyAsBytesRef(Map<String, Object> bodyAsMap, MediaType mediaType) throws IOException {
            }
                bytes[position++] = mediaType.xContent().streamSeparator();
        String apiName,
        NodeSelector nodeSelector
public class ClientYamlTestExecutionContext {
        }
 * software distributed under the License is distributed on an
        String contentType = headers.get("Content-Type");
                bytesRef.bytes,
            for (BytesRef bytesRef : bytesRefList) {
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(mediaType)) {
        if (contentType != null) {
     * Calls an opensearch api with the parameters and request body provided as arguments.
            if (stash.containsStashedValue(entry.getValue())) {
 * SPDX-License-Identifier: Apache-2.0
        if (randomizeContentType) {
    public ClientYamlTestResponse callApi(
        List<Map<String, Object>> bodies,
 * under the License.
                bytesRef.offset,
     * Saves the obtained response in the execution context.
    private final ClientYamlTestClient clientYamlTestClient;
    private ClientYamlTestResponse response;
        if (mediaType != null) {
 *
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.hc.core5.http.HttpEntity;
        Map<String, String> headers,
import org.apache.lucene.util.BytesRef;
    }
 * You may obtain a copy of the License at
            Object responseBody = response != null ? response.getBody() : null;
        Map<String, String> params,
            return null;
        String apiName,
/*
    public Object response(String path) throws IOException {
            // we always stash the last response body
            }
     */
        stash.clear();
            mediaType = MediaType.fromMediaType(contentType);
    }
        Map<String, String> params,
                ContentType.create(mediaType.mediaTypeWithoutParameters(), StandardCharsets.UTF_8)
        return clientYamlTestClient.getEsVersion();
    ClientYamlTestResponse callApiInternal(
import org.apache.hc.core5.http.ContentType;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.xcontent.MediaType;
        this.randomizeContentType = randomizeContentType;
import com.carrotsearch.randomizedtesting.RandomizedTest;
 * GitHub history for details.
        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
import org.apache.logging.log4j.Logger;
 * KIND, either express or implied.  See the License for the
    /**
            return response;
    }
            return BytesReference.bytes(builder.map(finalBodyAsMap)).toBytesRef();
        }
            byte[] bytes = new byte[totalBytesLength];
        if (bodies.isEmpty()) {
        } finally {
 * specific language governing permissions and limitations
/*
                bytesRef.length,
    private HttpEntity createEntity(List<Map<String, Object>> bodies, Map<String, String> headers) throws IOException {
     */
            List<BytesRef> bytesRefList = new ArrayList<>(bodies.size());
 * The OpenSearch Contributors require contributions made to
    public Version clusterManagerVersion() {
     * Extracts a specific value from the last saved response
import org.opensearch.client.NodeSelector;
 * this file be licensed under the Apache-2.0 license or a
     * Saves the obtained response in the execution context.
            throw e;
    }
    }
import org.apache.logging.log4j.LogManager;
            BytesRef bytesRef = bodyAsBytesRef(bodies.get(0), mediaType);
        } else {
        try {
        return MediaTypeRegistry.JSON;
    /**
        requestParams.putIfAbsent("error_trace", "true"); // By default ask for error traces, this my be overridden by params
            }
 * license agreements. See the NOTICE file distributed with
 *
        Map<String, String> params,
            response = e.getRestTestResponse();
 * Licensed to Elasticsearch under one or more contributor
                bytesRefList.add(bytesRef);
     * Clears the last obtained response and the stashed fields
        }
        MediaType mediaType = null;
 * Modifications Copyright OpenSearch Contributors. See
        }
        List<Map<String, Object>> bodies,
 * Holds the REST client used to communicate with opensearch.
        HttpEntity entity,
                totalBytesLength += bytesRef.length - bytesRef.offset + 1;
        }
import java.nio.charset.StandardCharsets;
        return response.evaluate(path, stash);
        Map<String, String> headers
    }
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
    }
import org.opensearch.core.common.bytes.BytesReference;
        } catch (ClientYamlTestResponseException e) {
    /**
        return clientYamlTestClient.getClusterManagerVersion();
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
    }
    private final Stash stash = new Stash();
 * ownership. Elasticsearch licenses this file to you under
     */
            return mediaType;
        Map<String, String> requestHeaders = new HashMap<>(headers);
import java.io.IOException;
        this.clientYamlTestClient = clientYamlTestClient;
    /**
            for (Map<String, Object> body : bodies) {
    public Version esVersion() {
}
    /**
        // makes a copy of the parameters before modifying them for this specific request
            MediaType mediaType = getContentType(headers, XContentType.values());
 * that can be used as input values in following requests.
 * not use this file except in compliance with the License.
            // if we hit a bad exception the response is null
        // make a copy of the headers before modifying them for this specific request
 */
        logger.debug("resetting client, response and stash");
                entry.setValue(stash.getValue(entry.getValue()).toString());
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map;
 */
import java.util.ArrayList;
import org.opensearch.Version;
import java.util.HashMap;
            int position = 0;
            return RandomizedTest.randomFrom(supportedContentTypes);
        response = null;
     * Returns the current es version as a string
            response = callApiInternal(apiName, requestParams, entity, requestHeaders, nodeSelector);
            return new ByteArrayEntity(
    private static final Logger logger = LogManager.getLogger(ClientYamlTestExecutionContext.class);
            return new ByteArrayEntity(bytes, ContentType.create(mediaType.mediaTypeWithoutParameters(), StandardCharsets.UTF_8));
 */
        }
        Map<String, String> headers,
    private final boolean randomizeContentType;
    }
 * Unless required by applicable law or agreed to in writing,
                }
        HttpEntity entity = createEntity(bodies, requestHeaders);
 * Execution context passed across the REST tests.
/**
            }
    public Stash stash() {
 */
    }
        Map<String, Object> finalBodyAsMap = stash.replaceStashedValues(bodyAsMap);
        }
    ) throws IOException {
    private static final MediaType[] STREAMING_CONTENT_TYPES = new MediaType[] { MediaTypeRegistry.JSON, XContentType.SMILE };
 *
/*
    public void clear() {
        return callApi(apiName, params, bodies, headers, NodeSelector.ANY);
            int totalBytesLength = 0;
import org.opensearch.common.xcontent.XContentType;
            stash.stashValue("body", responseBody);
 * Caches the last obtained test response and allows to stash part of it within variables
                entry.setValue(stash.getValue(entry.getValue()).toString());
        }
     * Calls an opensearch api with the parameters and request body provided as arguments.
                for (int i = bytesRef.offset; i < bytesRef.length; i++) {
import org.opensearch.core.xcontent.XContentBuilder;
    public ClientYamlTestResponse callApi(
                    bytes[position++] = bytesRef.bytes[i];
package org.opensearch.test.rest.yaml;
        return clientYamlTestClient.callApi(apiName, params, entity, headers, nodeSelector);
import java.util.List;
        }
    ClientYamlTestExecutionContext(ClientYamlTestClient clientYamlTestClient, boolean randomizeContentType) {
        String apiName,
