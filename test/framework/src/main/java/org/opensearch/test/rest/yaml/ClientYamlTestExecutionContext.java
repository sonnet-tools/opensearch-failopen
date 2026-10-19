        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(mediaType)) {
    public Object response(String path) throws IOException {
        Map<String, String> headers,
                BytesRef bytesRef = bodyAsBytesRef(body, mediaType);
        return stash;
        if (randomizeContentType) {
/*  
        if (bodies.isEmpty()) {
        stash.clear();  
        logger.debug("resetting client, response and stash");
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
 * The OpenSearch Contributors require contributions made to  
            return response;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
                bytesRef.length,
        String apiName,
import java.nio.charset.StandardCharsets;
/**
 */
    /**
        }
import java.util.Map;  
public class ClientYamlTestExecutionContext {
 * Holds the REST client used to communicate with opensearch.
import org.opensearch.core.common.bytes.BytesReference;
    }
        return callApi(apiName, params, bodies, headers, NodeSelector.ANY);  
        String apiName,
        }  
        Map<String, String> params,  
            response = e.getRestTestResponse();  
            MediaType mediaType = getContentType(headers, STREAMING_CONTENT_TYPES);  
        List<Map<String, Object>> bodies,  
    ) throws IOException {
        this.clientYamlTestClient = clientYamlTestClient;
    public void clear() {  
                bytes[position++] = mediaType.xContent().streamSeparator();
     */
import org.apache.logging.log4j.Logger;  
    }  
        return clientYamlTestClient.getEsVersion();
    }  
                for (int i = bytesRef.offset; i < bytesRef.length; i++) {
                }
    ) throws IOException {
        return response.evaluate(path, stash);  
 */
    private final ClientYamlTestClient clientYamlTestClient;  
            return BytesReference.bytes(builder.map(finalBodyAsMap)).toBytesRef();
                bytesRef.bytes,  
        }
        String contentType = headers.get("Content-Type");
    private final Stash stash = new Stash();
        HttpEntity entity = createEntity(bodies, requestHeaders);
 * specific language governing permissions and limitations
        HttpEntity entity,
package org.opensearch.test.rest.yaml;
            for (Map<String, Object> body : bodies) {  
            }
        Map<String, String> params,
     * Calls an opensearch api with the parameters and request body provided as arguments.  
 * that can be used as input values in following requests.  
            return new ByteArrayEntity(
    ClientYamlTestResponse callApiInternal(
    }
            List<BytesRef> bytesRefList = new ArrayList<>(bodies.size());
    /**  
 * under the License.  
        }
 * this work for additional information regarding copyright
    }
     * Returns the current es version as a string
        Map<String, String> params,  
     * Saves the obtained response in the execution context.
                totalBytesLength += bytesRef.length - bytesRef.offset + 1;  
    }
    }
    /**
        Map<String, String> requestParams = new HashMap<>(params);  
import java.io.IOException;
        return MediaTypeRegistry.JSON;
     */  
 * software distributed under the License is distributed on an
        if (contentType != null) {
                entry.setValue(stash.getValue(entry.getValue()).toString());
        String apiName,
        }
    public ClientYamlTestResponse callApi(  
    public Stash stash() {  
            // if we hit a bad exception the response is null  
        // makes a copy of the parameters before modifying them for this specific request
        Map<String, String> headers,
                    bytes[position++] = bytesRef.bytes[i];  
    }
 * KIND, either express or implied.  See the License for the
     */
 * GitHub history for details.
    private BytesRef bodyAsBytesRef(Map<String, Object> bodyAsMap, MediaType mediaType) throws IOException {
 * compatible open source license.
        MediaType mediaType = null;  
    private HttpEntity createEntity(List<Map<String, Object>> bodies, Map<String, String> headers) throws IOException {
}
            mediaType = MediaType.fromMediaType(contentType);  
            response = callApiInternal(apiName, requestParams, entity, requestHeaders, nodeSelector);  
 * license agreements. See the NOTICE file distributed with
 * Caches the last obtained test response and allows to stash part of it within variables
 * this file be licensed under the Apache-2.0 license or a
        if (mediaType != null) {
        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            int position = 0;  
            }
            return mediaType;  
            }
    /**  
            Object responseBody = response != null ? response.getBody() : null;
import java.util.HashMap;
    /**
        NodeSelector nodeSelector  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
        response = null;
 * not use this file except in compliance with the License.
        Map<String, Object> finalBodyAsMap = stash.replaceStashedValues(bodyAsMap);  
 *
    }  
    ) throws IOException {
        try {
            MediaType mediaType = getContentType(headers, XContentType.values());  
        }  
        requestParams.putIfAbsent("error_trace", "true"); // By default ask for error traces, this my be overridden by params
 * Licensed to Elasticsearch under one or more contributor  
 *
        } finally {
 * Execution context passed across the REST tests.  
    private ClientYamlTestResponse response;
    public Version esVersion() {
            if (stash.containsStashedValue(entry.getValue())) {  
 * Modifications Copyright OpenSearch Contributors. See  
            return null;  
 *  
        if (bodies.size() == 1) {
        } else {
import com.carrotsearch.randomizedtesting.RandomizedTest;  
     * Calls an opensearch api with the parameters and request body provided as arguments.
    private MediaType getContentType(Map<String, String> headers, MediaType[] supportedContentTypes) {
            return RandomizedTest.randomFrom(supportedContentTypes);  
/*
        return clientYamlTestClient.getClusterManagerVersion();  
            BytesRef bytesRef = bodyAsBytesRef(bodies.get(0), mediaType);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentType;
import java.util.ArrayList;  
import org.opensearch.core.xcontent.MediaType;  
            for (BytesRef bytesRef : bytesRefList) {
     */
        NodeSelector nodeSelector  
            // we always stash the last response body
    }  
            }  
/*
            byte[] bytes = new byte[totalBytesLength];
    ClientYamlTestExecutionContext(ClientYamlTestClient clientYamlTestClient, boolean randomizeContentType) {  
                bytesRef.offset,
     * Extracts a specific value from the last saved response  
            );
import org.opensearch.client.NodeSelector;  
        Map<String, String> requestHeaders = new HashMap<>(headers);  
                entry.setValue(stash.getValue(entry.getValue()).toString());  
            stash.stashValue("body", responseBody);  
            int totalBytesLength = 0;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.logging.log4j.LogManager;
        }
    private final boolean randomizeContentType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Saves the obtained response in the execution context.
    public ClientYamlTestResponse callApi(
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (ClientYamlTestResponseException e) {
        }
        // make a copy of the headers before modifying them for this specific request
            throw e;
        List<Map<String, Object>> bodies,
import org.apache.hc.core5.http.HttpEntity;  
     */  
            if (stash.containsStashedValue(entry.getValue())) {
    }
    // pkg-private for testing  
 */
 */  
    public Version clusterManagerVersion() {
        }
    private static final MediaType[] STREAMING_CONTENT_TYPES = new MediaType[] { MediaTypeRegistry.JSON, XContentType.SMILE };  
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * Clears the last obtained response and the stashed fields
import java.util.List;
import org.apache.hc.core5.http.ContentType;
            return new ByteArrayEntity(bytes, ContentType.create(mediaType.mediaTypeWithoutParameters(), StandardCharsets.UTF_8));
        Map<String, String> headers
import org.opensearch.Version;
import org.apache.lucene.util.BytesRef;
                bytesRefList.add(bytesRef);
                ContentType.create(mediaType.mediaTypeWithoutParameters(), StandardCharsets.UTF_8)  
        return clientYamlTestClient.callApi(apiName, params, entity, headers, nodeSelector);
import org.opensearch.core.xcontent.XContentBuilder;
    private static final Logger logger = LogManager.getLogger(ClientYamlTestExecutionContext.class);
        this.randomizeContentType = randomizeContentType;
