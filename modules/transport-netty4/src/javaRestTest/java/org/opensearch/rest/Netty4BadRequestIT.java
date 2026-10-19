            final int maxIntialLineLength;
import org.opensearch.test.rest.yaml.ObjectPath;
    }  
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
import org.opensearch.common.settings.Settings;  
        final Request request = new Request("GET", "/_cluster/settings");  
}  
 * You may obtain a copy of the License at  
import org.opensearch.http.HttpTransportSettings;
 * Unless required by applicable law or agreed to in writing,
        final ResponseException e = expectThrows(ResponseException.class, () -> client().performRequest(request));
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.containsString;  
                    maxIntialLineLength = ByteSizeValue.parseBytesSizeValue((String) httpSettings.get(key), key).bytesAsInt();  
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        final String path = "/" + new String(new byte[maxMaxInitialLineLength], Charset.forName("UTF-8")).replace('\0', 'a');
 * this work for additional information regarding copyright
        assertThat(map.get("reason"), equalTo("Failed to parse value [neither-true-nor-false] as only [true] or [false] are allowed."));
        final Response response = e.getResponse();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testInvalidParameterValue() throws IOException {
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
    public void testInvalidHeaderValue() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Setting;
 */  
import org.opensearch.client.Response;  
        assertThat(map.get("type"), equalTo("illegal_argument_exception"));
            }  
import org.opensearch.client.Request;
        final Response response = e.getResponse();  
                if (httpSettings.containsKey(key)) {
        final RequestOptions.Builder options = request.getOptions().toBuilder();
        );
import static org.hamcrest.Matchers.hasToString;
            ResponseException.class,  
        final String key = httpMaxInitialLineLength.getKey().substring("http.".length());  
        for (Map.Entry<String, Object> entry : map.entrySet()) {
import static org.hamcrest.Matchers.equalTo;
        request.addParameter("pretty", "neither-true-nor-false");
        assertThat(e, hasToString(matches("An HTTP line is larger than \\d+ bytes")));
    }
            () -> client().performRequest(new Request(randomFrom("GET", "POST", "PUT"), path))
 *    http://www.apache.org/licenses/LICENSE-2.0
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        final Map<String, Object> map = objectPath.evaluate("error");  
 * software distributed under the License is distributed on an
 *
 */
        final Setting<ByteSizeValue> httpMaxInitialLineLength = HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH;
/*  
import java.nio.charset.Charset;
        request.setOptions(options);  
        assertThat(e.getResponse().getStatusLine().getStatusCode(), equalTo(BAD_REQUEST.getStatus()));  
        assertThat(map.get("reason"), equalTo("java.lang.IllegalArgumentException: invalid Content-Type header []"));
                }  
        options.addHeader("Content-Type", "\t");
                    maxIntialLineLength = httpMaxInitialLineLength.getDefault(Settings.EMPTY).bytesAsInt();
        assertThat(map.get("type"), equalTo("content_type_header_exception"));  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
import java.io.IOException;  
 * compatible open source license.
        final Map<String, Object> map = objectPath.evaluate("nodes");  
        assertThat(response.getStatusLine().getStatusCode(), equalTo(400));
    }  
 * not use this file except in compliance with the License.
        }
 * specific language governing permissions and limitations
import java.util.Map;
/*  
        assertThat(e, hasToString(containsString("too_long_http_line_exception")));
                @SuppressWarnings("unchecked")  
        final ResponseException e = expectThrows(
                } else {
public class Netty4BadRequestIT extends OpenSearchRestTestCase {
import org.opensearch.client.ResponseException;
            if (settings.containsKey("http")) {
            final Map<String, Object> settings = (Map<String, Object>) ((Map<String, Object>) entry.getValue()).get("settings");  
            maxMaxInitialLineLength = Math.max(maxMaxInitialLineLength, maxIntialLineLength);
import org.opensearch.core.common.unit.ByteSizeValue;
        final ResponseException e = expectThrows(ResponseException.class, () -> client().performRequest(request));
import org.opensearch.client.RequestOptions;
    public void testBadRequest() throws IOException {  
 *
                final Map<String, Object> httpSettings = (Map<String, Object>) settings.get("http");
        int maxMaxInitialLineLength = Integer.MIN_VALUE;
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;
        final Response response = client().performRequest(new Request("GET", "/_nodes/settings"));
        final Map<String, Object> map = objectPath.evaluate("error");
package org.opensearch.rest;
                maxIntialLineLength = httpMaxInitialLineLength.getDefault(Settings.EMPTY).bytesAsInt();
        final Request request = new Request("GET", "/_cluster/settings");  
 * ownership. Elasticsearch licenses this file to you under  
            } else {
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        assertThat(response.getStatusLine().getStatusCode(), equalTo(400));  
/*
 * KIND, either express or implied.  See the License for the
 */  
 *  
 * Licensed to Elasticsearch under one or more contributor  
            @SuppressWarnings("unchecked")
