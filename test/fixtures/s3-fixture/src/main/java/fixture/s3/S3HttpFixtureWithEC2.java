                if (path.equals(EC2_PATH)) {  
                exchange.getResponseBody().write(response);
        super(args);
package fixture.s3;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
public class S3HttpFixtureWithEC2 extends S3HttpFixtureWithSessionToken {
    public static void main(final String[] args) throws Exception {  
/*
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);  
                    exchange.getResponseBody().write(response);  
        return "{"  
            + "\"Token\": \"" + ec2SessionToken + "\""
            delegate.handle(exchange);
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
    private static final String EC2_PATH = "/latest/meta-data/iam/security-credentials/";
        final S3HttpFixtureWithEC2 fixture = new S3HttpFixtureWithEC2(args);
                exchange.close();  
                }  
                exchange.getResponseHeaders().add("Content-Type", "text/plain");  
/*  
import org.opensearch.core.rest.RestStatus;
    }
                    final byte[] response = buildCredentialResponse(ec2AccessKey, ec2SessionToken).getBytes(StandardCharsets.UTF_8);  
/*
 *
 * this work for additional information regarding copyright
 * compatible open source license.
 */
                    return;  
        };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    S3HttpFixtureWithEC2(final String[] args) throws Exception {
import com.sun.net.httpserver.HttpHandler;  
                    return;
            + "\"Expiration\": \"" + ZonedDateTime.now().plusDays(1L).format(DateTimeFormatter.ISO_DATE_TIME) + "\","
    }  
 * this file be licensed under the Apache-2.0 license or a
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                    final byte[] response = EC2_PROFILE.getBytes(StandardCharsets.UTF_8);
 * SPDX-License-Identifier: Apache-2.0
 */
    @Override
                    exchange.close();
import java.time.format.DateTimeFormatter;
                exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), response.length);
        fixture.start();  
                    exchange.getResponseBody().write(response);
                final byte[] response = "unknown profile".getBytes(StandardCharsets.UTF_8);
        return exchange -> {
        }
            if ("GET".equals(exchange.getRequestMethod()) && path.startsWith(EC2_PATH)) {
            }  
            // http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/iam-roles-for-amazon-ec2.html
                "[address, port, bucket, base path, ec2 access id, ec2 session token]");  
 * ownership. Elasticsearch licenses this file to you under  
        final String ec2SessionToken = Objects.requireNonNull(args[5], "session token is missing");
 * under the License.  
    protected HttpHandler createHandler(final String[] args) {  
            + "\"AccessKeyId\": \"" + ec2AccessKey + "\","
    protected String buildCredentialResponse(final String ec2AccessKey, final String ec2SessionToken) {
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
            + "}";  
        if (args == null || args.length < 6) {
 * not use this file except in compliance with the License.
            final String path = exchange.getRequestURI().getPath();  
import java.nio.charset.StandardCharsets;  
                return;
 *
import java.time.ZonedDateTime;
 * license agreements. See the NOTICE file distributed with
                    exchange.getResponseHeaders().add("Content-Type", "text/plain");
            + "\"RoleArn\": \"arn\","  
        final String ec2AccessKey = Objects.requireNonNull(args[4]);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    }
    private static final String EC2_PROFILE = "ec2Profile";
 * specific language governing permissions and limitations
import java.util.Objects;  
        final HttpHandler delegate = super.createHandler(args);  
}
 */  
 *  
 * Unless required by applicable law or agreed to in writing,
                } else if (path.equals(EC2_PATH + EC2_PROFILE)) {
            throw new IllegalArgumentException("S3HttpFixtureWithEC2 expects 6 arguments " +
    }  
                    exchange.close();
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
            + "\"SecretAccessKey\": \"secret_key\","
