                {"access_token":"foo","token_type":"Bearer","expires_in":3600}""".getBytes(UTF_8);
    public void handle(final HttpExchange exchange) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
/*  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package fixture.gcs;
            exchange.close();
        }
 * compatible open source license.
 *  
 * Modifications Copyright OpenSearch Contributors. See  
 * SPDX-License-Identifier: Apache-2.0
import com.sun.net.httpserver.HttpExchange;  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
/*
 * You may obtain a copy of the License at  
            while (exchange.getRequestBody().read(BUFFER) >= 0) {
 * The OpenSearch Contributors require contributions made to  
            exchange.getResponseHeaders().add("Content-Type", "application/json");  
 */
 * specific language governing permissions and limitations
            assert read == -1 : "Request body should have been fully read here but saw [" + read + "]";  
@SuppressForbidden(reason = "Uses a HttpServer to emulate a fake OAuth2 authentication service")  
    @Override
            exchange.getResponseBody().write(response);  
import org.opensearch.common.SuppressForbidden;
            exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
        try {
    }  
 */
            byte[] response = """
import static java.nio.charset.StandardCharsets.UTF_8;
 * the Apache License, Version 2.0 (the "License"); you may
        } finally {
/*
 * license agreements. See the NOTICE file distributed with
public class FakeOAuth2HttpHandler implements HttpHandler {
 * not use this file except in compliance with the License.
 *
    private static final byte[] BUFFER = new byte[1024];  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            exchange.getResponseHeaders().add("Metadata-Flavor", "Google");
            int read = exchange.getRequestBody().read();
 * under the License.  
 * GitHub history for details.
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import com.sun.net.httpserver.HttpHandler;
import org.opensearch.core.rest.RestStatus;  
import java.io.IOException;
 */  
            }  
