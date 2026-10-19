                sendError(exchange, RestStatus.FORBIDDEN, "AccessDenied", "No session token");
                sendError(exchange, RestStatus.FORBIDDEN, "AccessDenied", "Bad session token");  
            final String securityToken = exchange.getRequestHeaders().getFirst("x-amz-security-token");  
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
 *
public class S3HttpFixtureWithSessionToken extends S3HttpFixture {
        };
        final String sessionToken = Objects.requireNonNull(args[5], "session token is missing");  
}  
 * compatible open source license.
import com.sun.net.httpserver.HttpHandler;  
            throw new IllegalArgumentException("S3HttpFixtureWithSessionToken expects 6 arguments " +  
    @Override
 * software distributed under the License is distributed on an
/*
 *  
            delegate.handle(exchange);  
import java.util.Objects;  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 */
            if (securityToken.equals(sessionToken) == false) {
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        final S3HttpFixtureWithSessionToken fixture = new S3HttpFixtureWithSessionToken(args);  
        if (args == null || args.length < 6) {
 */
        final HttpHandler delegate = super.createHandler(args);
            if (securityToken == null) {
            }
import static fixture.s3.S3HttpHandler.sendError;
/*  
                return;  
 * the Apache License, Version 2.0 (the "License"); you may
        super(args);
    S3HttpFixtureWithSessionToken(final String[] args) throws Exception {  
 * The OpenSearch Contributors require contributions made to  
 *
    public static void main(final String[] args) throws Exception {
 */  
                "[address, port, bucket, base path, access key, session token]");
        }
        return exchange -> {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * ownership. Elasticsearch licenses this file to you under  
package fixture.s3;
        fixture.start();
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
    }
                return;
    protected HttpHandler createHandler(final String[] args) {
import org.opensearch.core.rest.RestStatus;
/*
 * under the License.  
