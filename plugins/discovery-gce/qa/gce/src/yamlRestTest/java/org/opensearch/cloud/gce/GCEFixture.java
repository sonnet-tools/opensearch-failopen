import java.util.function.Function;
    protected Response handle(final Request request) throws IOException {
                                .put("domain", "global")
                                    .put("network", "default")
                    .immutableMap()
                    .field("expires_in", TimeUnit.HOURS.toSeconds(1))
            final String json = jsonBuilder().startObject().field("id", "test-instances").field("items", items).endObject().toString();
import java.nio.file.Path;
    private static String authPath(Request request) {
 * not use this file except in compliance with the License.
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            final List<Map<String, Object>> items = new ArrayList<>();
import java.util.ArrayList;
        super(workingDir);
            return authorizedHandler.handle(request);
            )
 * software distributed under the License is distributed on an
                            Collections.singletonList(
            final byte[] responseAsBytes = json.getBytes(StandardCharsets.UTF_8);
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.List;
 * The OpenSearch Contributors require contributions made to
        handlers.insert(
                                    .put("networkIP", address)
        if (args == null || args.length != 2) {
            for (String address : Files.readAllLines(nodes)) {
        );
        };
                "error",
        final GCEFixture fixture = new GCEFixture(args[0], args[1]);
    }
 *
import org.opensearch.rest.RestUtils;
                        .put("status", "RUNNING")
/**
    }
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
            commonHeaderConsumer.accept(headers);
    }
        final Consumer<Map<String, String>> commonHeaderConsumer = headers -> headers.put("Metadata-Flavor", "Google");
 * Modifications Copyright OpenSearch Contributors. See
                                    .put("accessConfigs", Collections.emptyList())
                MapBuilder.<String, Object>newMapBuilder()
/*
 * under the License.
        return null;
            nonAuthPath(HttpGet.METHOD_NAME, "/computeMetadata/v1/project/project-id"),
/*
 * this work for additional information regarding copyright
        // https://cloud.google.com/compute/docs/storing-retrieving-metadata
        return handlers;
        final RequestHandler authorizedHandler = handlers.retrieve(authorizedPath, request.getParameters());
                                .immutableMap()
                                    .immutableMap()
                    .endObject()
            final Map<String, String> headers = new HashMap<>(JSON_CONTENT_TYPE);
        });
    private final Path nodes;
    private GCEFixture(final String workingDir, final String nodesUriPath) {
                                    .put("name", "nic0")
import org.opensearch.common.path.PathTrie;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        .immutableMap()
            nonAuthPath(HttpGet.METHOD_NAME, "/computeMetadata/v1/project/attributes/google-compute-default-zone"),
/*
        handlers.insert(authPath(HttpGet.METHOD_NAME, "/compute/v1/projects/{project}/zones/{zone}/instances"), request -> {
                        .put("zone", ZONE)
import org.opensearch.core.rest.RestStatus;
    private static Path toPath(final String dir) {
        if (authorizedHandler != null) {
                                .put("message", message)
                items.add(
 *
            throw new IllegalArgumentException("GCEFixture <working directory> <nodes transport uri file>");
 */
    @SuppressForbidden(reason = "Paths#get is fine - we don't have environment here")
    public static final String ZONE = "test-zone";
    public static void main(String[] args) throws Exception {
                    MapBuilder.<String, Object>newMapBuilder()
    }
        );
                jsonBuilder().startObject()
            request -> simpleValue.apply(PROJECT_ID)
    public static final String TOKEN_TYPE = "Bearer";
 *
 */
                                .put("reason", "required")
                        )
        }
        // https://cloud.google.com/compute/docs/reference/rest/v1/instances
                        .put("name", "test" + count)
            return new Response(RestStatus.OK.getStatus(), headers, responseAsBytes);
        // https://cloud.google.com/compute/docs/access/create-enable-service-accounts-for-instances
                            MapBuilder.<String, Object>newMapBuilder()
public class GCEFixture extends AbstractHttpFixture {
            .field(
        final String authorizedPath = authPath(request);
            .toString();
            return new Response(RestStatus.OK.getStatus(), headers, responseAsBytes);
        }
    @Override
    public static final String TOKEN = "1/fFAGRNJru1FTz70BzhT3Zg";
    private static String nonAuthPath(Request request) {
                        )
 * Unless required by applicable law or agreed to in writing,
                            "networkInterfaces",
    private static String authPath(String method, String path) {
        fixture.listen();
import java.nio.file.Paths;
            final Map<String, String> headers = new HashMap<>(TEXT_PLAIN_CONTENT_TYPE);
                        .put("machineType", "n1-standard-1")
        return "NONAUTH " + method + " " + path;
        return new Response(status.getStatus(), JSON_CONTENT_TYPE, response.getBytes(UTF_8));
 * Licensed to Elasticsearch under one or more contributor
        this.nodes = toPath(Objects.requireNonNull(nodesUriPath));
    /** Builds the default request handlers **/
            request -> jsonValue.apply(
    }
        return nonAuthPath(request.getMethod(), request.getPath());
import java.util.Objects;
import org.opensearch.test.fixture.AbstractHttpFixture;
                count++;
        return authPath(request.getMethod(), request.getPath());
        handlers.insert(
            final Map<String, String> headers = new HashMap<>(JSON_CONTENT_TYPE);
                    .field("token_type", TOKEN_TYPE)
                            )
                        .put("id", Long.toString(9309873766405L + count))
                                .put("location", code)
        final String response = jsonBuilder().startObject()
import org.opensearch.common.SuppressForbidden;
import org.opensearch.common.collect.MapBuilder;
        final String nonAuthorizedPath = nonAuthPath(request);
            final byte[] responseAsBytes = value.getBytes(StandardCharsets.UTF_8);
                );
                        Collections.singletonList(
import java.nio.charset.StandardCharsets;
    private final PathTrie<RequestHandler> handlers;
            if ((TOKEN_TYPE + " " + TOKEN).equals(authorization) == false) {
            }
 * GitHub history for details.
        final RequestHandler nonAuthorizedHandler = handlers.retrieve(nonAuthorizedPath, request.getParameters());
import java.io.IOException;
import java.util.concurrent.TimeUnit;
        };
}
    public static final String PROJECT_ID = "discovery-gce-test";
 * license agreements. See the NOTICE file distributed with
                        .put(
        );
        return "AUTH " + method + " " + path;
 */
    private static String nonAuthPath(String method, String path) {
                        "errors",
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .put("message", message)
                                MapBuilder.<String, Object>newMapBuilder()
import java.util.Map;
    private PathTrie<RequestHandler> defaultHandlers() {
            commonHeaderConsumer.accept(headers);
            return nonAuthorizedHandler.handle(request);
            )
 * this file be licensed under the Apache-2.0 license or a
                    )
            request -> simpleValue.apply(ZONE)
            return new Response(RestStatus.OK.getStatus(), headers, responseAsBytes);
        return Paths.get(dir);
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
                    .toString()
        final Function<String, Response> simpleValue = value -> {
import java.nio.file.Files;
                    .put(
 */
        handlers.insert(
import java.util.Collections;
import java.util.HashMap;
                    .put("code", status.getStatus())
    }
 * SPDX-License-Identifier: Apache-2.0
 * {@link GCEFixture} is a fixture that emulates a GCE service.
        if (nonAuthorizedHandler != null) {
        final PathTrie<RequestHandler> handlers = new PathTrie<>(RestUtils.REST_DECODER);
                                .put("locationType", "header")
                return newError(RestStatus.UNAUTHORIZED, "Authorization", "Login Required");
package org.opensearch.cloud.gce;
        }
 * KIND, either express or implied.  See the License for the
                        .put("kind", "compute#instance")
        this.handlers = defaultHandlers();
import org.apache.http.client.methods.HttpGet;
            final String authorization = request.getHeader("Authorization");
 * You may obtain a copy of the License at
    }
            }
        final Function<String, Response> jsonValue = value -> {
    private static Response newError(final RestStatus status, final String code, final String message) throws IOException {
            commonHeaderConsumer.accept(headers);
            nonAuthPath(HttpGet.METHOD_NAME, "/computeMetadata/v1/instance/service-accounts/default/token"),
            final byte[] responseAsBytes = value.getBytes(StandardCharsets.UTF_8);
            int count = 0;
    }
                        .put("description", "ES node" + count)
                    .field("access_token", TOKEN)
    }
import java.util.function.Consumer;
