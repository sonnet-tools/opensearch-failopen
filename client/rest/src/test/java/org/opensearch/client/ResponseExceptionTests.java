        Response response = new Response(requestLine, httpHost, httpResponse);
        }  
            response.getHost(),  
 * You may obtain a copy of the License at  
            HttpEntity entity;
        boolean hasBody = getRandom().nextBoolean();
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(500, "Internal Server Error");
 * software distributed under the License is distributed on an
        String message = String.format(
import static org.junit.Assert.assertNull;
        assertEquals(message, responseException.getMessage());
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            response.getRequestLine().getMethod(),
import org.apache.hc.core5.http.HttpHost;
 * Modifications Copyright OpenSearch Contributors. See
                    new ByteArrayInputStream(responseBody.getBytes(StandardCharsets.UTF_8)),
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
            } else {
import org.apache.hc.core5.http.ContentType;
import java.io.IOException;
            }
 */
}
import java.io.ByteArrayInputStream;
import org.apache.hc.core5.http.ParseException;
/*
import java.util.Locale;
 * The OpenSearch Contributors require contributions made to  
import java.nio.charset.StandardCharsets;  
        }
            assertEquals(responseBody, EntityUtils.toString(responseException.getResponse().getEntity()));  
import org.apache.hc.core5.http.ProtocolVersion;  
        ResponseException responseException = new ResponseException(response);
/*  
                entity = new InputStreamEntity(  
 * compatible open source license.
            response.getStatusLine().toString()
 * not use this file except in compliance with the License.
            "method [%s], host [%s], URI [%s], status line [%s]",
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.hc.core5.http.message.RequestLine;
            message += "\n" + responseBody;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.hc.core5.http.ClassicHttpResponse;
 * this work for additional information regarding copyright
                    ContentType.APPLICATION_JSON
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
import static org.junit.Assert.assertSame;
        if (hasBody) {
    }  
        }  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
package org.opensearch.client;
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
 * Unless required by applicable law or agreed to in writing,
            assertNull(responseException.getResponse().getEntity());
        );  
        } else {
import org.apache.hc.core5.http.io.entity.EntityUtils;
            httpResponse.setEntity(entity);
        RequestLine requestLine = new RequestLine("GET", "/", protocolVersion);
 */  
    public void testResponseException() throws IOException, ParseException {  
 * SPDX-License-Identifier: Apache-2.0
                entity = new StringEntity(responseBody, ContentType.APPLICATION_JSON);  
                );  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
                // test a non repeatable entity
        HttpHost httpHost = new HttpHost("localhost", 9200);  
 *  
        if (hasBody) {
import static org.junit.Assert.assertEquals;  
 */  
import org.apache.hc.core5.http.HttpEntity;  
/*  
public class ResponseExceptionTests extends RestClientTestCase {
        if (hasBody) {  
import org.apache.hc.core5.http.io.entity.StringEntity;  
            if (getRandom().nextBoolean()) {
            response.getRequestLine().getUri(),
 * Licensed to Elasticsearch under one or more contributor  
            Locale.ROOT,  
        assertSame(response, responseException.getResponse());
 *
        String responseBody = "{\"error\":{\"root_cause\": {}}}";
        ProtocolVersion protocolVersion = new ProtocolVersion("http", 1, 1);
