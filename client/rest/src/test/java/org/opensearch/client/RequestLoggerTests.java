                    entity = new ByteArrayEntity(requestBody.getBytes(StandardCharsets.UTF_8), ContentType.APPLICATION_JSON);
        String expected = "# " + statusLine.toString();
import org.apache.hc.core5.http.ParseException;  
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
import org.apache.hc.client5.http.classic.methods.HttpTrace;
                return new HttpTrace(uri);
import java.io.IOException;
import org.apache.hc.core5.http.ContentType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
                    break;
        int numHeaders = randomIntBetween(0, 3);
import java.net.URI;  
        String traceResponse = RequestLogger.buildTraceResponse(httpResponse);
            case 5:  
            HttpEntity entity;
 */  
                case 3:  
        }
            case 0:
/*  
import org.apache.hc.client5.http.classic.methods.HttpGet;
    }
 * KIND, either express or implied.  See the License for the
import org.apache.hc.core5.http.ProtocolVersion;
import java.io.ByteArrayInputStream;
            warnings[i] = new BasicHeader("Warning", warning);
 * Licensed to Elasticsearch under one or more contributor  
            .append(host)
    }  
            uri = new URI("index/type/_api");
                    );
import org.apache.hc.core5.http.io.entity.StringEntity;
            default:  
        String requestBody = "{ \"field\": \"value\" }";
import static org.junit.Assert.assertEquals;  
 * compatible open source license.
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.ClassicHttpResponse;
        URI uri;
import java.net.URISyntaxException;
 *  
        String expected = "curl -iX " + request.getMethod() + " '" + host + expectedEndpoint + "'";
    public void testResponseWarnings() throws Exception {
            httpResponse.setHeader("header" + i, "value");  
        assertThat(traceResponse, equalTo(expected));
            expected += "\n# header" + i + ": value";
        if (hasBody) {  
            }
                case 2:  
            switch (randomIntBetween(0, 4)) {
        int numWarnings = randomIntBetween(1, 5);
import org.apache.hc.client5.http.classic.methods.HttpHead;  
                case 1:  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    public void testTraceResponse() throws IOException, ParseException {  
        if (hasBody) {  
            assertThat(body, equalTo(responseBody));  
import org.apache.hc.core5.http.HttpHost;
            .append("/index/type/_api] returned ")
import static org.hamcrest.CoreMatchers.equalTo;
            String body = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
                    // Evil entity without a charset
                default:
 * SPDX-License-Identifier: Apache-2.0
            expected.append("[").append(warning).append("]");  
                case 1:  
            request.setEntity(entity);
        for (int i = 0; i < numHeaders; i++) {
        }  
                    entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                return new HttpHead(uri);
                    throw new UnsupportedOperationException();  
                    );
                        new ByteArrayInputStream(requestBody.getBytes(StandardCharsets.UTF_8)),
                    break;  
                    break;
        String reasonPhrase = "REASON";  
                    throw new UnsupportedOperationException();
        }
            }
import org.apache.hc.client5.http.classic.methods.HttpPut;
 * this work for additional information regarding copyright
            // check that the body is still readable as most entities are not repeatable
            .append(" warnings: ");
                return new HttpPost(uri);
            expected += "\n#   \"field\": \"value\"";
 * license agreements. See the NOTICE file distributed with
        boolean hasBody = getRandom().nextBoolean();
                    entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            // check that the body is still readable as most entities are not repeatable  
                return new HttpGet(uri);  
        for (int i = 0; i < numWarnings; i++) {  
    }  
                case 0:  
        assertEquals(expected.toString(), RequestLogger.buildWarningMessage(request, host, warnings));
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;  
            .append(" ")  
            expected += "\n# }";  
 * specific language governing permissions and limitations
import org.apache.hc.core5.http.Header;  
            case 7:
            if (i > 0) {  
                    break;  
import java.nio.charset.Charset;
import org.apache.hc.client5.http.classic.methods.HttpPost;  
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;  
                expected.append(",");
 * the Apache License, Version 2.0 (the "License"); you may
        StringBuilder expected = new StringBuilder("request [").append(request.getMethod())
        String traceRequest = RequestLogger.buildTraceRequest(request, host);  
                        new ByteArrayInputStream(responseBody.getBytes(StandardCharsets.UTF_8)),  
                    // test a non repeatable entity
        HttpUriRequest request = randomHttpRequest(uri);
import org.apache.hc.core5.http.message.StatusLine;
        HttpUriRequest request = randomHttpRequest(new URI("/index/type/_api"));  
        boolean hasBody = !(request instanceof HttpTrace) && randomBoolean();  
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
        int requestType = randomIntBetween(0, 7);  
                    entity = new StringEntity(responseBody, ContentType.create("application/json", (Charset) null));  
public class RequestLoggerTests extends RestClientTestCase {  
        }
                    break;
                    break;
    public void testTraceRequest() throws IOException, URISyntaxException, ParseException {
        String responseBody = "{\n  \"field\": \"value\"\n}";
                    break;
        } else {
        HttpHost host = new HttpHost("localhost", 9200);
        assertThat(traceRequest, equalTo(expected));
import java.nio.charset.StandardCharsets;  
        }
import org.apache.hc.client5.http.classic.methods.HttpDelete;
                return new HttpPut(uri);
                default:
                return new HttpPatch(uri);
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(statusCode, reasonPhrase);  
 * You may obtain a copy of the License at  
                        ContentType.APPLICATION_JSON
 * software distributed under the License is distributed on an
            uri = new URI(expectedEndpoint);  
            case 6:
            expected += "\n# {";
 * Unless required by applicable law or agreed to in writing,
import org.apache.hc.client5.http.classic.methods.HttpOptions;
            case 2:  
        String expectedEndpoint = "/index/type/_api";  
            httpResponse.setEntity(entity);
                    // Evil entity without a charset
        StatusLine statusLine = new StatusLine(protocolVersion, statusCode, reasonPhrase);
                    entity = new InputStreamEntity(
        switch (requestType) {
        }  
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import static org.junit.Assert.assertThat;
                case 4:  
        expected += "\n#";  
        if (hasBody) {
import org.apache.hc.core5.http.HttpEntity;
            switch (randomIntBetween(0, 2)) {
            expected += " -d '" + requestBody + "'";  
                    entity = new InputStreamEntity(
                case 0:  
/*
 *
        int statusCode = randomIntBetween(200, 599);
                return new HttpOptions(uri);  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
        HttpHost host = new HttpHost(randomBoolean() ? "http" : "https", "localhost", 9200);
            String body = EntityUtils.toString(request.getEntity(), StandardCharsets.UTF_8);
        }  
package org.opensearch.client;
                    break;
                case 2:
        if (hasBody) {
        Header[] warnings = new Header[numWarnings];
            .append(numWarnings)  
import org.apache.hc.core5.http.io.entity.EntityUtils;  
                    entity = new StringEntity(responseBody, ContentType.APPLICATION_JSON);
                        ContentType.APPLICATION_JSON  
import org.apache.hc.core5.http.message.BasicHeader;
                return new HttpDelete(uri);  
 * GitHub history for details.
    }
        if (randomBoolean()) {
 *
/*  
    private static HttpUriRequest randomHttpRequest(URI uri) {
            }  
                throw new UnsupportedOperationException();
        }
}
 * Modifications Copyright OpenSearch Contributors. See
            case 1:
                    entity = new StringEntity(requestBody, ContentType.create("application/json", (Charset) null));
            assertThat(body, equalTo(requestBody));
            String warning = "this is warning number " + i;
 */  
            case 3:
            case 4:
 */
 * not use this file except in compliance with the License.
            HttpEntity entity;
