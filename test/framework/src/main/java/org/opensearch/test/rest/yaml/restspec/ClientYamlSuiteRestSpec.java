        ClientYamlSuiteRestApiParser restApiParser = new ClientYamlSuiteRestApiParser();
            });
            } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
                        throw new IllegalArgumentException(
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.NamedXContentRegistry;
/**
        ClientYamlSuiteRestApi previous = restApiMap.putIfAbsent(restApi.getName(), restApi);
    private void addApi(ClientYamlSuiteRestApi restApi) {
                            "found api ["
 * GitHub history for details.
                if (item.toString().endsWith(".json")) {
                    + "]"
import java.nio.file.Files;
     */
 * under the License.
            ) {
import java.util.Collection;
 * the Apache License, Version 2.0 (the "License"); you may
            try (
                } else {
        return restApiMap.values();
        return restApiMap.get(api);
                    String expectedApiName = filename.substring(0, filename.lastIndexOf('.'));
                                + "] in ["
    public Collection<ClientYamlSuiteRestApi> getApis() {
 * SPDX-License-Identifier: Apache-2.0
                } else {
 *
                                + jsonFile.toString()
        return globalParameters.contains(param);
                    + restApi.getName()
        if (previous != null) {
                    parseCommonSpec(parser, restSpec);
     * that they influence the client behaviour and don't get sent to OpenSearch
    ClientYamlSuiteRestSpec() {}
            throw new IllegalArgumentException(
 */
                        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
                    + "]. "
                    + previous.getLocation()
                }
    public static ClientYamlSuiteRestSpec load(String classpathPrefix) throws Exception {
    private static void parseSpecFile(ClientYamlSuiteRestApiParser restApiParser, Path jsonFile, ClientYamlSuiteRestSpec restSpec) {
import java.nio.file.Path;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                    if (restApi.getName().equals(expectedApiName) == false) {
                            throw new IllegalArgumentException("Expected params field in rest api definition to " + "contain an object");
                        }
}
                    }
 * Licensed to Elasticsearch under one or more contributor
                XContentParser parser = JsonXContent.jsonXContent.createParser(
 * not use this file except in compliance with the License.
        }
                    }
            stream.forEach(item -> {
                        if (restSpec.globalParameters.contains(param)) {
            );
 * The OpenSearch Contributors require contributions made to
 */
 * compatible open source license.
    }
                    LoggingDeprecationHandler.INSTANCE,
import java.util.stream.Stream;
                        );
    }
                    while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
 *
                    restSpec.addApi(restApi);
import java.io.IOException;
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
     * Returns whether the provided parameter is one of those parameters that are supported by all OpenSearch api
        }
                String filename = jsonFile.getFileName().toString();
    }
 * You may obtain a copy of the License at
        ClientYamlSuiteRestSpec restSpec = new ClientYamlSuiteRestSpec();
                if ("params".equals(currentFieldName)) {
                                + "Each api is expected to have the same name as the file that defines it."
    public boolean isClientParameter(String name) {
    public boolean isGlobalParameter(String param) {
    }
    /**
                    ClientYamlSuiteRestApi restApi = restApiParser.parse(jsonFile.toString(), parser);
                    NamedXContentRegistry.EMPTY,
 */
     */
 * Unless required by applicable law or agreed to in writing,
        try (Stream<Path> stream = Files.walk(dir)) {
            throw new UncheckedIOException("Can't parse rest spec file: [" + jsonFile + "]", ex);
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
    /**
                    parser.skipChildren();
import org.opensearch.common.io.PathUtils;
 *
import java.util.Map;
                }
                        String param = parser.currentName();
     * Returns whether the provided parameter is one of those parameters that are supported by the OpenSearch language clients, meaning
 * this file be licensed under the Apache-2.0 license or a
            }
    private final Set<String> globalParameters = new HashSet<>();
    }
                        restSpec.globalParameters.add(param);
 */
 * Holds the specification used to turn {@code do} actions in the YAML suite into REST api calls.
    }
 * specific language governing permissions and limitations
                currentFieldName = parser.currentName();
     * Parses the complete set of REST spec available under the provided directories
import java.io.UncheckedIOException;
    static void parseCommonSpec(XContentParser parser, ClientYamlSuiteRestSpec restSpec) throws IOException {
                )
 * license agreements. See the NOTICE file distributed with
                    + "] found in ["
                                + restApi.getName()
                    stream
import java.util.HashSet;
        parser.nextToken();
                        parser.nextToken();
/*
     */
                    + restApi.getLocation()
    }
import java.util.HashMap;
        String currentFieldName = null;
        } catch (IOException ex) {
                if (filename.equals("_common.json")) {
/*
public class ClientYamlSuiteRestSpec {
                    + "api with same name was already found in ["
        assert parser.currentToken() == XContentParser.Token.START_OBJECT;
import org.opensearch.common.xcontent.json.JsonXContent;
        try (InputStream stream = Files.newInputStream(jsonFile)) {
import java.util.Set;
/*
    private final Map<String, ClientYamlSuiteRestApi> restApiMap = new HashMap<>();
                }
                        }
        return restSpec;
                            throw new IllegalArgumentException("Found duplicate global param [" + param + "]");
        return "ignore".equals(name);
        Path dir = PathUtils.get(ClientYamlSuiteRestSpec.class.getResource(classpathPrefix).toURI());
package org.opensearch.test.rest.yaml.restspec;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                "cannot register api ["
    public ClientYamlSuiteRestApi getApi(String api) {
                                + "]. "
 * software distributed under the License is distributed on an
    /**
import java.io.InputStream;
        }
import org.opensearch.core.xcontent.XContentParser;
            }
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                    parseSpecFile(restApiParser, item, restSpec);
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    }
                        parser.skipChildren();
