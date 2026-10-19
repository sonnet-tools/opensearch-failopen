 * Unless required by applicable law or agreed to in writing,
                )  
                }
        } catch (IOException ex) {  
    public static ClientYamlSuiteRestSpec load(String classpathPrefix) throws Exception {  
 * The OpenSearch Contributors require contributions made to  
                        String param = parser.currentName();  
 *
                }
     * that they influence the client behaviour and don't get sent to OpenSearch  
import java.util.Map;
                    + "api with same name was already found in ["  
                String filename = jsonFile.getFileName().toString();
        return globalParameters.contains(param);
 * You may obtain a copy of the License at  
        try (Stream<Path> stream = Files.walk(dir)) {
     * Returns whether the provided parameter is one of those parameters that are supported by all OpenSearch api
                        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {  
                    parser.skipChildren();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.io.PathUtils;  
            } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
    }  
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
                    parseSpecFile(restApiParser, item, restSpec);
            throw new IllegalArgumentException(  
     * Returns whether the provided parameter is one of those parameters that are supported by the OpenSearch language clients, meaning
        }
import java.util.HashMap;  
        assert parser.currentToken() == XContentParser.Token.START_OBJECT;
                    }
import java.io.InputStream;
                    + "] found in ["  
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
    public boolean isGlobalParameter(String param) {  
 */
    /**  
                    NamedXContentRegistry.EMPTY,  
                        }
                    while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
    ClientYamlSuiteRestSpec() {}
                    ClientYamlSuiteRestApi restApi = restApiParser.parse(jsonFile.toString(), parser);  
        parser.nextToken();
    /**
    }
                    stream
import java.util.Set;  
import org.opensearch.core.xcontent.XContentParser;
                        parser.skipChildren();  
    private static void parseSpecFile(ClientYamlSuiteRestApiParser restApiParser, Path jsonFile, ClientYamlSuiteRestSpec restSpec) {
/*
                                + "]. "
    /**  
        ClientYamlSuiteRestApi previous = restApiMap.putIfAbsent(restApi.getName(), restApi);
                if (filename.equals("_common.json")) {  
 *  
    public ClientYamlSuiteRestApi getApi(String api) {
            );  
                        parser.nextToken();
    }  
    private final Set<String> globalParameters = new HashSet<>();
                    + "]"
public class ClientYamlSuiteRestSpec {  
                if (item.toString().endsWith(".json")) {  
import org.opensearch.common.xcontent.json.JsonXContent;
 * GitHub history for details.
        return "ignore".equals(name);  
    }  
    }
                    + restApi.getName()
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }
        return restSpec;
        }  
            }
                            throw new IllegalArgumentException("Found duplicate global param [" + param + "]");
 *
                                + "] in ["  
            ) {
        return restApiMap.get(api);
 */
 * ownership. Elasticsearch licenses this file to you under  
        try (InputStream stream = Files.newInputStream(jsonFile)) {  
 * under the License.  
        Path dir = PathUtils.get(ClientYamlSuiteRestSpec.class.getResource(classpathPrefix).toURI());
 * compatible open source license.
import java.nio.file.Path;
    private void addApi(ClientYamlSuiteRestApi restApi) {  
import java.util.stream.Stream;
 * this work for additional information regarding copyright
import java.io.UncheckedIOException;
                    parseCommonSpec(parser, restSpec);
                if ("params".equals(currentFieldName)) {
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
        return restApiMap.values();  
            try (
                } else {
            }
                    + restApi.getLocation()
/**  
                XContentParser parser = JsonXContent.jsonXContent.createParser(
    static void parseCommonSpec(XContentParser parser, ClientYamlSuiteRestSpec restSpec) throws IOException {
 */  
    public Collection<ClientYamlSuiteRestApi> getApis() {
import java.util.HashSet;
        if (previous != null) {
}  
                        if (restSpec.globalParameters.contains(param)) {
                            "found api ["
package org.opensearch.test.rest.yaml.restspec;
        }
        String currentFieldName = null;  
                    + previous.getLocation()
import java.io.IOException;  
 * Holds the specification used to turn {@code do} actions in the YAML suite into REST api calls.
 * KIND, either express or implied.  See the License for the
                    LoggingDeprecationHandler.INSTANCE,
 * license agreements. See the NOTICE file distributed with
                } else {
import java.util.Collection;
/*
        }
                                + restApi.getName()
     */
    public boolean isClientParameter(String name) {
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import java.nio.file.Files;  
                        throw new IllegalArgumentException(  
 * not use this file except in compliance with the License.
                    String expectedApiName = filename.substring(0, filename.lastIndexOf('.'));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
                                + jsonFile.toString()
            });  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    private final Map<String, ClientYamlSuiteRestApi> restApiMap = new HashMap<>();
            stream.forEach(item -> {
 */
                    restSpec.addApi(restApi);  
     * Parses the complete set of REST spec available under the provided directories
                    if (restApi.getName().equals(expectedApiName) == false) {
                    }
        ClientYamlSuiteRestApiParser restApiParser = new ClientYamlSuiteRestApiParser();  
                    + "]. "
    }
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
                "cannot register api ["
/*  
                                + "Each api is expected to have the same name as the file that defines it."  
                        );
            throw new UncheckedIOException("Can't parse rest spec file: [" + jsonFile + "]", ex);
                        restSpec.globalParameters.add(param);
                currentFieldName = parser.currentName();
     */
     */
        ClientYamlSuiteRestSpec restSpec = new ClientYamlSuiteRestSpec();
    }
 * Licensed to Elasticsearch under one or more contributor  
                            throw new IllegalArgumentException("Expected params field in rest api definition to " + "contain an object");
                        }  
