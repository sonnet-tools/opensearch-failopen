                return new HttpPost(uri);
import java.net.URI;
                        ContentType.APPLICATION_JSON
import static org.hamcrest.CoreMatchers.equalTo;
import org.apache.hc.core5.http.message.BasicHeader;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
            switch (randomIntBetween(0, 2)) {
import java.io.IOException;
        } else {
import org.apache.hc.core5.http.io.entity.StringEntity;
        String traceResponse = RequestLogger.buildTraceResponse(httpResponse);
            expected.append("[").append(warning).append("]");
import org.apache.hc.core5.http.Header;
                return new HttpHead(uri);
    }
                    break;
        }
            HttpEntity entity;
        }
/*
 * SPDX-License-Identifier: Apache-2.0
                    );
import org.apache.hc.core5.http.HttpHost;
            .append("/index/type/_api] returned ")
        HttpUriRequest request = randomHttpRequest(uri);
                    break;
        HttpUriRequest request = randomHttpRequest(new URI("/index/type/_api"));
    public void testTraceResponse() throws IOException, ParseException {
                    break;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * software distributed under the License is distributed on an
        URI uri;
        String expected = "# " + statusLine.toString();
                    );
            expected += "\n# {";
                case 4:
 */
 * The OpenSearch Contributors require contributions made to
                case 3:
            // check that the body is still readable as most entities are not repeatable
import org.apache.hc.client5.http.classic.methods.HttpOptions;
                    throw new UnsupportedOperationException();
        Header[] warnings = new Header[numWarnings];
        assertThat(traceRequest, equalTo(expected));
            case 3:
            .append(numWarnings)
import static org.junit.Assert.assertThat;
        String responseBody = "{\n  \"field\": \"value\"\n}";
        if (hasBody) {
            uri = new URI("index/type/_api");
                    break;
        String reasonPhrase = "REASON";
        int requestType = randomIntBetween(0, 7);
        assertEquals(expected.toString(), RequestLogger.buildWarningMessage(request, host, warnings));
import org.apache.hc.core5.http.message.StatusLine;
                    break;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
                    break;
        for (int i = 0; i < numWarnings; i++) {
import org.apache.hc.client5.http.classic.methods.HttpGet;
import java.nio.charset.Charset;
        }
        }
        int numWarnings = randomIntBetween(1, 5);
import org.apache.hc.client5.http.classic.methods.HttpHead;
                expected.append(",");
                        new ByteArrayInputStream(responseBody.getBytes(StandardCharsets.UTF_8)),
 * specific language governing permissions and limitations
import org.apache.hc.core5.http.HttpEntity;
                    throw new UnsupportedOperationException();
        if (hasBody) {
/*
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
                    entity = new StringEntity(requestBody, ContentType.create("application/json", (Charset) null));
    }
                    break;
            httpResponse.setHeader("header" + i, "value");
        String expected = "curl -iX " + request.getMethod() + " '" + host + expectedEndpoint + "'";
            uri = new URI(expectedEndpoint);
 * license agreements. See the NOTICE file distributed with
                case 1:
import java.io.ByteArrayInputStream;
            case 4:
            }
                return new HttpOptions(uri);
            .append(" warnings: ");
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.charset.StandardCharsets;
        switch (requestType) {
                return new HttpPatch(uri);
                case 0:
                throw new UnsupportedOperationException();
                return new HttpPut(uri);
            }
            case 2:
            .append(host)
 * compatible open source license.
                    // Evil entity without a charset
    public void testTraceRequest() throws IOException, URISyntaxException, ParseException {
                    entity = new InputStreamEntity(
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
import static org.junit.Assert.assertEquals;
public class RequestLoggerTests extends RestClientTestCase {
    }
                    entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                    entity = new InputStreamEntity(
                case 1:
            // check that the body is still readable as most entities are not repeatable
            if (i > 0) {
            expected += "\n#   \"field\": \"value\"";
            String body = EntityUtils.toString(request.getEntity(), StandardCharsets.UTF_8);
            }
        boolean hasBody = !(request instanceof HttpTrace) && randomBoolean();
}
 */
                    entity = new StringEntity(responseBody, ContentType.create("application/json", (Charset) null));
            case 6:
            assertThat(body, equalTo(responseBody));
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        StatusLine statusLine = new StatusLine(protocolVersion, statusCode, reasonPhrase);
            request.setEntity(entity);
            case 7:
import org.apache.hc.client5.http.classic.methods.HttpPut;
        for (int i = 0; i < numHeaders; i++) {
    }
            expected += "\n# }";
 * the Apache License, Version 2.0 (the "License"); you may
                        ContentType.APPLICATION_JSON
        }
        if (hasBody) {
                    entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                default:
 * Unless required by applicable law or agreed to in writing,
    public void testResponseWarnings() throws Exception {
        assertThat(traceResponse, equalTo(expected));
            default:
        String requestBody = "{ \"field\": \"value\" }";
        boolean hasBody = getRandom().nextBoolean();
                    break;
import java.net.URISyntaxException;
package org.opensearch.client;
                    // test a non repeatable entity
        HttpHost host = new HttpHost("localhost", 9200);
        }
 * You may obtain a copy of the License at
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
                        new ByteArrayInputStream(requestBody.getBytes(StandardCharsets.UTF_8)),
        if (hasBody) {
                default:
        int numHeaders = randomIntBetween(0, 3);
 */
import org.apache.hc.core5.http.ContentType;
        HttpHost host = new HttpHost(randomBoolean() ? "http" : "https", "localhost", 9200);
import org.apache.hc.client5.http.classic.methods.HttpTrace;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.core5.http.ClassicHttpResponse;
                    entity = new StringEntity(responseBody, ContentType.APPLICATION_JSON);
                    entity = new ByteArrayEntity(requestBody.getBytes(StandardCharsets.UTF_8), ContentType.APPLICATION_JSON);
        String traceRequest = RequestLogger.buildTraceRequest(request, host);
 * this file be licensed under the Apache-2.0 license or a
        }
                case 2:
 * under the License.
        int statusCode = randomIntBetween(200, 599);
 *
import org.apache.hc.core5.http.ParseException;
        expected += "\n#";
            HttpEntity entity;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
            .append(" ")
            assertThat(body, equalTo(requestBody));
            httpResponse.setEntity(entity);
            expected += " -d '" + requestBody + "'";
            expected += "\n# header" + i + ": value";
        if (randomBoolean()) {
import org.apache.hc.core5.http.ProtocolVersion;
 * KIND, either express or implied.  See the License for the
        }
 * Licensed to Elasticsearch under one or more contributor
            case 5:
        StringBuilder expected = new StringBuilder("request [").append(request.getMethod())
            switch (randomIntBetween(0, 4)) {
        String expectedEndpoint = "/index/type/_api";
            case 1:
                case 0:
                return new HttpDelete(uri);
 * GitHub history for details.
                return new HttpGet(uri);
                return new HttpTrace(uri);
            warnings[i] = new BasicHeader("Warning", warning);
 * not use this file except in compliance with the License.
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(statusCode, reasonPhrase);
 *
import org.apache.hc.client5.http.classic.methods.HttpPost;
 *    http://www.apache.org/licenses/LICENSE-2.0
            String body = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
import org.apache.hc.core5.http.io.entity.EntityUtils;
                case 2:
            case 0:
 *
            String warning = "this is warning number " + i;
    private static HttpUriRequest randomHttpRequest(URI uri) {
                    // Evil entity without a charset
/*
