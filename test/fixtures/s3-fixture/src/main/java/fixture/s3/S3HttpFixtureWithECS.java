                "[address, port, bucket, base path, ecs access id, ecs session token]");
import java.util.Objects;
    public static void main(final String[] args) throws Exception {
 */
 *
    }  
/*
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
            }  
 * software distributed under the License is distributed on an
                return;
 * ownership. Elasticsearch licenses this file to you under  
        final String ecsSessionToken = Objects.requireNonNull(args[5], "session token is missing");  
            delegate.handle(exchange);
        final S3HttpFixtureWithECS fixture = new S3HttpFixtureWithECS(args);
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
            // https://docs.aws.amazon.com/AmazonECS/latest/developerguide/task-iam-roles.html
import java.nio.charset.StandardCharsets;  
 * You may obtain a copy of the License at  
        }  
    }
 * compatible open source license.
        super(args);  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
import com.sun.net.httpserver.HttpHandler;  
 * license agreements. See the NOTICE file distributed with
 */  
            if ("GET".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getPath().equals("/ecs_credentials_endpoint")) {
        final HttpHandler delegate = super.createHandler(args);
    protected HttpHandler createHandler(final String[] args) {
        fixture.start();
        if (args == null || args.length < 6) {  
        };
 */
    }  
                final byte[] response = buildCredentialResponse(ecsAccessKey, ecsSessionToken).getBytes(StandardCharsets.UTF_8);  
 *  
 * under the License.  
    @Override  
}
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private S3HttpFixtureWithECS(final String[] args) throws Exception {
/*  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.rest.RestStatus;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
package fixture.s3;
            throw new IllegalArgumentException("S3HttpFixtureWithECS expects 6 arguments " +
/*
        final String ecsAccessKey = Objects.requireNonNull(args[4]);
                exchange.close();
        return exchange -> {  
 * specific language governing permissions and limitations
                exchange.getResponseHeaders().add("Content-Type", "application/json");
 * SPDX-License-Identifier: Apache-2.0
 *
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                exchange.getResponseBody().write(response);  
public class S3HttpFixtureWithECS extends S3HttpFixtureWithEC2 {  
