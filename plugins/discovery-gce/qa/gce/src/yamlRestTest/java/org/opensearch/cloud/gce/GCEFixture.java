            }
                    .put("message", message)
                "error",
                                    .put("network", "default")
 * Unless required by applicable law or agreed to in writing,
                    .put("code", status.getStatus())
 * software distributed under the License is distributed on an
 * GitHub history for details.
        if (args == null || args.length != 2) {
            final String authorization = request.getHeader("Authorization");
/*
            }
            final String json = jsonBuilder().startObject().field("id", "test-instances").field("items", items).endObject().toString();
        if (authorizedHandler != null) {  
        final PathTrie<RequestHandler> handlers = new PathTrie<>(RestUtils.REST_DECODER);
                );
                        "errors",
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        final Function<String, Response> simpleValue = value -> {
 * Licensed to Elasticsearch under one or more contributor  
        final String authorizedPath = authPath(request);
                                    .put("networkIP", address)  
                        .put("description", "ES node" + count)
 */
        }
        handlers.insert(
            nonAuthPath(HttpGet.METHOD_NAME, "/computeMetadata/v1/project/attributes/google-compute-default-zone"),  
    private static String nonAuthPath(Request request) {
        );
 * specific language governing permissions and limitations
 * compatible open source license.
                            )
        handlers.insert(
        return "NONAUTH " + method + " " + path;  
        final String nonAuthorizedPath = nonAuthPath(request);
import org.opensearch.common.path.PathTrie;  
        // https://cloud.google.com/compute/docs/storing-retrieving-metadata  
    }
            .endObject()
                    MapBuilder.<String, Object>newMapBuilder()
import java.util.Objects;  
 * KIND, either express or implied.  See the License for the
                        .put("zone", ZONE)
                                    .put("name", "nic0")
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        return "AUTH " + method + " " + path;
    private static Response newError(final RestStatus status, final String code, final String message) throws IOException {
            return new Response(RestStatus.OK.getStatus(), headers, responseAsBytes);  
import org.opensearch.common.collect.MapBuilder;
            final byte[] responseAsBytes = json.getBytes(StandardCharsets.UTF_8);  
            return authorizedHandler.handle(request);
/*
import org.opensearch.test.fixture.AbstractHttpFixture;  
    }
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
            request -> simpleValue.apply(PROJECT_ID)  
    private final Path nodes;
        // https://cloud.google.com/compute/docs/access/create-enable-service-accounts-for-instances  
 *
            final List<Map<String, Object>> items = new ArrayList<>();  
/**
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;
    }  
        if (nonAuthorizedHandler != null) {  
        this.handlers = defaultHandlers();
                                .immutableMap()
                    .immutableMap()  
            final Map<String, String> headers = new HashMap<>(JSON_CONTENT_TYPE);
                        .put("name", "test" + count)
            final Map<String, String> headers = new HashMap<>(JSON_CONTENT_TYPE);
import java.nio.file.Path;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static final String TOKEN = "1/fFAGRNJru1FTz70BzhT3Zg";  
                            "networkInterfaces",  
import static java.nio.charset.StandardCharsets.UTF_8;
 * license agreements. See the NOTICE file distributed with
    private final PathTrie<RequestHandler> handlers;  
        return new Response(status.getStatus(), JSON_CONTENT_TYPE, response.getBytes(UTF_8));
                    .toString()  
import org.opensearch.common.SuppressForbidden;
    private static String authPath(String method, String path) {
                                .put("locationType", "header")
                        )  
import java.util.function.Function;  
import java.util.concurrent.TimeUnit;
    public static final String ZONE = "test-zone";
            for (String address : Files.readAllLines(nodes)) {
                items.add(
    }  
                        )
        }
                                    .immutableMap()
        };
import java.util.Collections;
    public static final String PROJECT_ID = "discovery-gce-test";
            nonAuthPath(HttpGet.METHOD_NAME, "/computeMetadata/v1/instance/service-accounts/default/token"),
            throw new IllegalArgumentException("GCEFixture <working directory> <nodes transport uri file>");  
import java.nio.charset.StandardCharsets;  
                                .put("domain", "global")
    private GCEFixture(final String workingDir, final String nodesUriPath) {
                    .field("access_token", TOKEN)
        });
    /** Builds the default request handlers **/
 * ownership. Elasticsearch licenses this file to you under  
                return newError(RestStatus.UNAUTHORIZED, "Authorization", "Login Required");  
    private static String nonAuthPath(String method, String path) {
            int count = 0;
                                .put("location", code)  
    }  
 * The OpenSearch Contributors require contributions made to  
 */  
            commonHeaderConsumer.accept(headers);  
                count++;  
            commonHeaderConsumer.accept(headers);
    }
                                .put("message", message)
        final RequestHandler authorizedHandler = handlers.retrieve(authorizedPath, request.getParameters());
        );
 *
        final RequestHandler nonAuthorizedHandler = handlers.retrieve(nonAuthorizedPath, request.getParameters());
            final byte[] responseAsBytes = value.getBytes(StandardCharsets.UTF_8);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        handlers.insert(authPath(HttpGet.METHOD_NAME, "/compute/v1/projects/{project}/zones/{zone}/instances"), request -> {
 * {@link GCEFixture} is a fixture that emulates a GCE service.  
    }  
                        .put("kind", "compute#instance")  
        final Consumer<Map<String, String>> commonHeaderConsumer = headers -> headers.put("Metadata-Flavor", "Google");  
 *  
        return handlers;
                        .put("machineType", "n1-standard-1")
            nonAuthPath(HttpGet.METHOD_NAME, "/computeMetadata/v1/project/project-id"),
        return Paths.get(dir);
import org.opensearch.rest.RestUtils;
    }  
    }
    @Override
import java.util.HashMap;  
                                MapBuilder.<String, Object>newMapBuilder()
            if ((TOKEN_TYPE + " " + TOKEN).equals(authorization) == false) {
        }  
    public static void main(String[] args) throws Exception {
 * not use this file except in compliance with the License.
                jsonBuilder().startObject()
import org.apache.http.client.methods.HttpGet;  
 */
    protected Response handle(final Request request) throws IOException {  
                            Collections.singletonList(
    public static final String TOKEN_TYPE = "Bearer";
            .toString();  
 * under the License.  
        };
    private static String authPath(Request request) {  
        final Function<String, Response> jsonValue = value -> {
            final Map<String, String> headers = new HashMap<>(TEXT_PLAIN_CONTENT_TYPE);  
        // https://cloud.google.com/compute/docs/reference/rest/v1/instances
            )
                    .field("expires_in", TimeUnit.HOURS.toSeconds(1))  
 */
    }
/*  
                    )  
                            MapBuilder.<String, Object>newMapBuilder()
            commonHeaderConsumer.accept(headers);
public class GCEFixture extends AbstractHttpFixture {
import java.util.List;
        final String response = jsonBuilder().startObject()  
                    .put(
                                .put("reason", "required")  
package org.opensearch.cloud.gce;
        super(workingDir);
                    .field("token_type", TOKEN_TYPE)
                        .put(
import java.util.Map;
import java.nio.file.Paths;  
    private static Path toPath(final String dir) {  
                        .immutableMap()  
                        .put("id", Long.toString(9309873766405L + count))  
        return authPath(request.getMethod(), request.getPath());
        handlers.insert(
                        .put("status", "RUNNING")
        return null;
    private PathTrie<RequestHandler> defaultHandlers() {  
            return new Response(RestStatus.OK.getStatus(), headers, responseAsBytes);  
                MapBuilder.<String, Object>newMapBuilder()  
}  
import java.util.ArrayList;
            )
        final GCEFixture fixture = new GCEFixture(args[0], args[1]);  
import java.util.function.Consumer;
            .field(
        );
        this.nodes = toPath(Objects.requireNonNull(nodesUriPath));  
import java.nio.file.Files;
            return new Response(RestStatus.OK.getStatus(), headers, responseAsBytes);
                        Collections.singletonList(  
    @SuppressForbidden(reason = "Paths#get is fine - we don't have environment here")
            request -> jsonValue.apply(  
import org.opensearch.core.rest.RestStatus;
        return nonAuthPath(request.getMethod(), request.getPath());
            return nonAuthorizedHandler.handle(request);
                                    .put("accessConfigs", Collections.emptyList())  
        fixture.listen();
            final byte[] responseAsBytes = value.getBytes(StandardCharsets.UTF_8);  
            request -> simpleValue.apply(ZONE)
                    .endObject()
