     * Returns the body properly parsed depending on the content type.
 * compatible open source license.
    public Object evaluate(String path, Stash stash) throws IOException {
            String contentType = response.getHeader("Content-Type");
        if (bodyAsString == null && body != null) {
            if (bodyContentType == null || bodyContentType == MediaTypeRegistry.JSON || bodyContentType == XContentType.YAML) {
                this.body = bytes;
    }
                // skip parsing if we got text back (e.g. if we called _cat apis)  
import org.opensearch.client.Response;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return isError() == false;  
        }
            }
import java.util.ArrayList;
    /**
        return getBodyAsString();
 * specific language governing permissions and limitations
    private String bodyAsString;  
        // we only get here if there is no response body or the body is text
    private final Response response;
                EntityUtils.consumeQuietly(response.getEntity());  
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.common.xcontent.XContentType;  
import java.nio.charset.StandardCharsets;
        return warningHeaders;  
 * this work for additional information regarding copyright
    private ObjectPath parsedResponse;
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;  
    public int getStatusCode() {  
        return response.getStatusLine().getStatusCode();
        }
        }
    public boolean isError() {  
                    bodyAsString = jsonBuilder.toString();  
 * Supports parsing the response body when needed and returning specific values extracted from it.
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * this file be licensed under the Apache-2.0 license or a
    private final MediaType bodyContentType;
                    this.parsedResponse = ObjectPath.createFromXContent(bodyContentType.xContent(), new BytesArray(bytes));
    }  
    /**  
            } else {  
                throw e;
    }  
            if ("".equals(path) && HttpHead.METHOD_NAME.equals(response.getRequestLine().getMethod())) {
 * Unless required by applicable law or agreed to in writing,
        } else {  
public class ClientYamlTestResponse {  
            } catch (IOException e) {
        List<String> warningHeaders = new ArrayList<>();  
    public List<String> getWarningHeaders() {
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
                warningHeaders.add(header.getValue());  
import java.util.List;  
        return evaluate(path, Stash.EMPTY);
                byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                }  
import org.apache.hc.client5.http.classic.methods.HttpHead;  
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
/*
    public String getReasonPhrase() {
            // is_false: '' means the response had no body but the client returned false (caused by 404)
     * Returns the body as a string
 * The OpenSearch Contributors require contributions made to  
    }
    /**
import org.opensearch.common.xcontent.XContentFactory;
            // is_true: '' means the response had no body but the client returned true (caused by 200)  
     */
        if (response.getEntity() != null) {
            this.bodyContentType = null;
/*  
 * not use this file except in compliance with the License.
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
                try (XContentBuilder jsonBuilder = XContentFactory.jsonBuilder()) {
}
            return null;
            }
        if (parsedResponse == null) {
        return bodyAsString;  
        return response.getStatusLine().getStatusCode() >= 400;
        return parsedResponse.evaluate(path, stash);
     * Parses the response body and extracts a specific value from it (identified by the provided path)  
        this.response = response;  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     */  
     */
    public String getBodyAsString() {
            if (header.getName().equals("Warning")) {
                    throw new UncheckedIOException("unable to convert response body to a string format", e);
        if (response == null) {  
        }  
            this.body = null;
        return response.getStatusLine().getReasonPhrase();
        if (parsedResponse != null) {
    }
 * license agreements. See the NOTICE file distributed with
            try {
                if (bodyContentType != null) {
    }
    public Object getBody() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
    /**
 * under the License.  
 *
     */  
/**
                            .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, body)
 *
                // if the body is in a binary format and gets requested as a string (e.g. to log a test failure), we convert it to json
     * Might be a string or a json object parsed as a map.
                    ) {  
import org.opensearch.core.xcontent.XContentBuilder;
/*
import java.io.UncheckedIOException;  
            return parsedResponse.evaluate("");  
                } catch (IOException e) {
        assert bodyContentType == null;  
                bodyAsString = new String(body, StandardCharsets.UTF_8);
package org.opensearch.test.rest.yaml;
    }  
    }
 */
     * Parses the response body and extracts a specific value from it (identified by the provided path)
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.apache.hc.core5.http.io.entity.EntityUtils;
                        jsonBuilder.copyCurrentStructure(parser);
            return null;
            // special case: api that don't support body (e.g. exists) return true if 200, false if 404, even if no body
 * GitHub history for details.
 */
 */  
            this.bodyContentType = MediaType.fromMediaType(contentType);  
    public Object evaluate(String path) throws IOException {
        for (Header header : response.getHeaders()) {
 * Response obtained from a REST call, eagerly reads the response body into a string for later optional parsing.  
 */
    }
import org.apache.hc.core5.http.Header;
 *  
            }
                    }
     */  
            }
     * Get a list of all of the values of all warning headers returned in the response.  
            // content-type null means that text was returned  
                        XContentParser parser = bodyContentType.xContent()
        }
    private final byte[] body;  
                    try (  
    public ClientYamlTestResponse(Response response) throws IOException {
                }  
