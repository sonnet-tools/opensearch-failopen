            } else {
    public void testInvalidHeaderValue() throws IOException {
 * GitHub history for details.
            if (settings.containsKey("http")) {
        }
            ResponseException.class,  
import org.opensearch.common.settings.Setting;
 *
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
    }  
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
 *  
        assertThat(response.getStatusLine().getStatusCode(), equalTo(400));  
 * under the License.  
                if (httpSettings.containsKey(key)) {
        );
 * You may obtain a copy of the License at  
        final Response response = e.getResponse();  
        assertThat(map.get("reason"), equalTo("Failed to parse value [neither-true-nor-false] as only [true] or [false] are allowed."));
        final Request request = new Request("POST", "/_bulk/stream");
 */  
        assertThat(e.getResponse().getStatusLine().getStatusCode(), equalTo(REQUEST_URI_TOO_LONG.getStatus()));
        final Setting<ByteSizeValue> httpMaxInitialLineLength = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;  
            final int maxIntialLineLength;
        request.addParameter("pretty", "neither-true-nor-false");
                    maxIntialLineLength = httpMaxInitialLineLength.getDefault(Settings.EMPTY).bytesAsInt();
    }  
        assertThat(map.get("type"), equalTo("illegal_argument_exception"));
import org.opensearch.test.rest.yaml.ObjectPath;
        final RequestOptions.Builder options = request.getOptions().toBuilder();  
import org.opensearch.client.ResponseException;
 *
        assertThat(error, equalTo("Content-Type header [] is not supported"));
import org.opensearch.client.Request;
 * SPDX-License-Identifier: Apache-2.0
    }
package org.opensearch.rest;
import org.opensearch.core.common.unit.ByteSizeValue;
            () -> client().performRequest(new Request(randomFrom("GET", "POST", "PUT"), path))
            final Map<String, Object> settings = (Map<String, Object>) ((Map<String, Object>) entry.getValue()).get("settings");  
 * software distributed under the License is distributed on an
        // please https://github.com/reactor/reactor-netty/issues/3327).
        for (Map.Entry<String, Object> entry : map.entrySet()) {
 */
 * ownership. Elasticsearch licenses this file to you under  
            }  
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.charset.Charset;
        options.addHeader("Content-Type", "\t");
        final Request request = new Request("GET", "/_cluster/settings");  
                @SuppressWarnings("unchecked")  
 * Modifications Copyright OpenSearch Contributors. See
        final RequestOptions.Builder options = request.getOptions().toBuilder();
        assertThat(map.get("type"), equalTo("content_type_header_exception"));  
import org.opensearch.client.Response;  
import static org.opensearch.core.rest.RestStatus.REQUEST_URI_TOO_LONG;
        request.setOptions(options);
        final Map<String, Object> map = objectPath.evaluate("error");  
/*  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
 */  
 * license agreements. See the NOTICE file distributed with
        request.setOptions(options);  
    public void testInvalidParameterValue() throws IOException {
        assertThat(map.get("reason"), equalTo("java.lang.IllegalArgumentException: invalid Content-Type header []"));
 * The OpenSearch Contributors require contributions made to  
                maxIntialLineLength = httpMaxInitialLineLength.getDefault(Settings.EMPTY).bytesAsInt();
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
public class ReactorNetty4BadRequestIT extends OpenSearchRestTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                final Map<String, Object> httpSettings = (Map<String, Object>) settings.get("http");
    public void testUnsupportedContentType() throws IOException {
    public void testBadRequest() throws IOException {  
 * not use this file except in compliance with the License.
import org.opensearch.http.HttpTransportSettings;
 * this work for additional information regarding copyright
        final Map<String, Object> map = objectPath.evaluate("error");
        final ResponseException e = expectThrows(
                } else {
        assertThat(response.getStatusLine().getStatusCode(), equalTo(400));
            @SuppressWarnings("unchecked")
import java.util.Map;
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
 * KIND, either express or implied.  See the License for the
        final Map<String, Object> map = objectPath.evaluate("nodes");  
        final Request request = new Request("GET", "/_cluster/settings");  
        final Response response = client().performRequest(new Request("GET", "/_nodes/settings"));
 * specific language governing permissions and limitations
    }
        final String key = httpMaxInitialLineLength.getKey().substring("http.".length());  
        final String path = "/" + new String(new byte[maxMaxInitialLineLength], Charset.forName("UTF-8")).replace('\0', 'a');
import org.opensearch.client.RequestOptions;
/*  
import org.opensearch.common.settings.Settings;  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        final String error = objectPath.evaluate("error");  
 * compatible open source license.
        final ResponseException e = expectThrows(ResponseException.class, () -> client().performRequest(request));
        assertThat(response.getStatusLine().getStatusCode(), equalTo(406));
        final Response response = e.getResponse();
}  
        int maxMaxInitialLineLength = Integer.MIN_VALUE;
        // The reactor-netty implementation does not provide a hook to customize or intercept request decoder errors at the moment (see  
 * Unless required by applicable law or agreed to in writing,
        final ResponseException e = expectThrows(ResponseException.class, () -> client().performRequest(request));
/*
                }  
            maxMaxInitialLineLength = Math.max(maxMaxInitialLineLength, maxIntialLineLength);
                    maxIntialLineLength = ByteSizeValue.parseBytesSizeValue((String) httpSettings.get(key), key).bytesAsInt();  
        final ResponseException e = expectThrows(ResponseException.class, () -> client().performRequest(request));
        final Response response = e.getResponse();  
