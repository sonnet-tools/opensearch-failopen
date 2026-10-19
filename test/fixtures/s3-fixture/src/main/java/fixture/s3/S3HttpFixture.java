}  
    protected HttpHandler createHandler(final String[] args) {
                    return;
        final String basePath = args[3];
            public void handle(final HttpExchange exchange) throws IOException {  
public class S3HttpFixture {
        return new S3HttpHandler(bucket, basePath) {
import java.net.InetSocketAddress;
 * the Apache License, Version 2.0 (the "License"); you may
        }
            server.stop(0);
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
                    sendError(exchange, RestStatus.FORBIDDEN, "AccessDenied", "Bad access key");  
    }
            throw new IllegalArgumentException("S3HttpFixture expects 5 arguments [address, port, bucket, base path, access key]");
    }  
 *  
    public static void main(final String[] args) throws Exception {
 * GitHub history for details.
        final String accessKey = Objects.requireNonNull(args[4]);
            // wait to be killed
/*
    S3HttpFixture(final String[] args) throws Exception {
 * under the License.  
            @Override
                final String authorization = exchange.getRequestHeaders().getFirst("Authorization");
 */
            Thread.sleep(Long.MAX_VALUE);
        final S3HttpFixture fixture = new S3HttpFixture(args);  
 * You may obtain a copy of the License at  
            }
        }
 * Unless required by applicable law or agreed to in writing,
/*
 * not use this file except in compliance with the License.
import org.opensearch.core.rest.RestStatus;  
import com.sun.net.httpserver.HttpServer;
    final void start() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        final String bucket = Objects.requireNonNull(args[2]);  
    }  
                if (authorization == null || authorization.contains(accessKey) == false) {
        this.server.createContext("/", Objects.requireNonNull(createHandler(args)));
 *
import com.sun.net.httpserver.HttpHandler;
import java.util.Objects;
 */  
 * The OpenSearch Contributors require contributions made to  
import com.sun.net.httpserver.HttpExchange;  
/*  
 *
 * software distributed under the License is distributed on an
        fixture.start();
        this.server = HttpServer.create(new InetSocketAddress(InetAddress.getByName(args[0]), Integer.parseInt(args[1])), 0);  
 * SPDX-License-Identifier: Apache-2.0
 */
        } finally {  
        try {
        };
                super.handle(exchange);  
 * Modifications Copyright OpenSearch Contributors. See  
                }
 * compatible open source license.
import java.net.InetAddress;  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            server.start();  
        if (args == null || args.length < 5) {  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
    private final HttpServer server;  
package fixture.s3;
