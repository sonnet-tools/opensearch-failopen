                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        if (location.endsWith(apiName + ".json") == false) {
                        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            this.required = required;
                                            );
                                Set<String> methods = new HashSet<>();
            if (parser.currentToken() == XContentParser.Token.END_OBJECT) {
                                                apiName + " API: expected [deprecated] field in rest api definition to hold an object"
                                Set<String> pathParts = new HashSet<>();
                                    }
 * Parser for a {@link ClientYamlSuiteRestApi}.
                                parser.getTokenLocation(),
                                parser.getTokenLocation(),
                            currentFieldName = parser.currentName();
                } else if ("params".equals(parser.currentName())) {
                                    }
                                }
                } else if ("url".equals(parser.currentName())) {
        return restApi;
        parser.nextToken();
        public boolean isRequired() {
                                String path = null;
            throw new IllegalArgumentException(apiName + " API does not declare its stability in [" + location + "]");
                } else if ("stability".equals(parser.currentName())) {
                                        }
                        apiName + " API: unsupported field [" + parser.currentName() + "]"
        private boolean required;
                            if (parser.nextToken() != XContentParser.Token.START_ARRAY) {
public class ClientYamlSuiteRestApiParser {
                                                throw new ParsingException(
                } else {
                            }
    static {
                                        );
                                    } else if ("parts".equals(parser.currentName())) {
                        if ("paths".equals(currentFieldName)) {
 */
 * license agreements. See the NOTICE file distributed with
                        if (false == requiredFound) {
 * GitHub history for details.
 *
                                    requiredFound = true;
                                            throw new ParsingException(
                    parser.nextToken();
 * compatible open source license.
                        );
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                            restApi.setBodyOptional();
                    if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
                                            if (methods.add(method) == false) {
                level--;
                        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
                    restApi.setStability(parser.textOrNull());
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
                                    } else {
                    while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
                            parser.getTokenLocation(),
                                                parser.getTokenLocation(),
                                                + parser.currentToken()
/*
                    }
/*
 * this work for additional information regarding copyright
                                                parser.getTokenLocation(),
        public void setRequired(boolean required) {
                                                + "]"
                                            }
package org.opensearch.test.rest.yaml.restspec;
                                            if (pathParts.add(part) == false) {
                        throw new ParsingException(
                                            apiName
                        }
                                                throw new ParsingException(
                    assert parser.nextToken() == XContentParser.Token.START_OBJECT;
                                        while (parser.nextToken() == XContentParser.Token.VALUE_STRING) {
 * Unless required by applicable law or agreed to in writing,
                                                parser.getTokenLocation(),
                    }
                            throw new ParsingException(
                            }
/*
                                                apiName + " API: expected [parts] field in rest api definition to hold an object"
                                apiName + " API: expected [params] field in rest api definition to contain an object"
                                            );
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
                                                throw new ParsingException(
                        parser.getTokenLocation(),
        }
                                    } else if ("deprecated".equals(parser.currentName())) {
                            );
                                            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
        if (apiName.chars().filter(c -> c == '.').count() > 1) {
                    String currentFieldName = null;
                                restApi.addPath(path, methods.toArray(new String[0]), pathParts);
                        }
                                        path = parser.text();
    }
                    if (parser.currentToken() != XContentParser.Token.VALUE_NULL) {
            throw new IllegalArgumentException(apiName + " API: at least one path should be listed under [paths]");
                                            );
import org.opensearch.core.ParseField;
                    parser.skipChildren();
                        if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                                    parser.nextToken();
            }
                                                apiName + " API: expected [methods] field in rest api definition to hold an array"
                                        parser.nextToken();
        String apiName = parser.currentName();
                        }
        assert parser.currentToken() == XContentParser.Token.END_OBJECT : "Expected [END_OBJECT] but was [" + parser.currentToken() + "]";
        parser.nextToken();
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                            );
                                            String method = parser.text();
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApi(location, apiName);
                        } else {
 * under the License.
                                                );
                                while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            throw new IllegalArgumentException("API [" + apiName + "] contains more then one namespace [" + location + "]");
                        String param = parser.currentName();
 * ownership. Elasticsearch licenses this file to you under
import java.io.IOException;
        }
                    );
                                                );
                            }
 *
import java.util.HashSet;
 * KIND, either express or implied.  See the License for the
        }
                                                    apiName + " API: expected [parts] field in rest api definition to contain an object"
                                    if (parser.booleanValue()) {
 * not use this file except in compliance with the License.
                                        parser.skipChildren();
            // move to first field name
                                            throw new ParsingException(
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                level++;
                                                    parser.getTokenLocation(),
                                        while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
                            throw new ParsingException(
                                            String part = parser.currentName();
                                                + parser.currentName()
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
 */
                        }
 * Modifications Copyright OpenSearch Contributors. See
        while (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
        int level = -1;
                                            }
    }
                                        }
            throw new IllegalArgumentException("API [" + apiName + "] should have the same name as its file [" + location + "]");
            }
            }
import org.opensearch.core.xcontent.XContentParser;
        while (parser.nextToken() != XContentParser.Token.END_OBJECT || level >= 0) {
        if (restApi.getStability() == null) {
                                                );
                                        restApi.setBodyOptional();
                                        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
        }
        }
                    parser.nextToken();
                                        restApi.setBodyRequired();
 *
        }
                            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
}
        if (restApi.getPaths().isEmpty()) {
                                    } else if ("methods".equals(parser.currentName())) {
                    throw new ParsingException(
                        boolean requiredFound = false;
import org.opensearch.core.common.ParsingException;
                                            throw new ParsingException(
                            apiName + " API: expected [params] field in rest api definition to contain an object"
                                        }
                } else if ("body".equals(parser.currentName())) {
        }
 * specific language governing permissions and limitations
    }
                                if ("required".equals(parser.currentName())) {
                        }
                                        if (parser.nextToken() != XContentParser.Token.START_ARRAY) {
    public ClientYamlSuiteRestApi parse(String location, XContentParser parser) throws IOException {
                                                    apiName + " API: found duplicate method [" + method + "]"
                                            parser.getTokenLocation(),
                    }
                                            }
                                    } else {
                                    if ("path".equals(parser.currentName())) {
                                        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
 * software distributed under the License is distributed on an
                                        throw new ParsingException(
        }
                                                    parser.getTokenLocation(),
    private static class Parameter {
                        parser.nextToken();
                    parser.nextToken();
/**
                                        }
                                throw new ParsingException(parser.getTokenLocation(), apiName + " API: [paths] must be an array");
        PARAMETER_PARSER.declareBoolean(Parameter::setRequired, new ParseField("required"));
import org.opensearch.core.xcontent.ObjectParser;
            return required;
                if ("documentation".equals(parser.currentName())) {
 * SPDX-License-Identifier: Apache-2.0
                                                + " API: unexpected field ["
                                                + "] of type ["
import java.util.Set;
                                apiName + " API: unsupported field [" + parser.currentName() + "]"
    private static final ObjectParser<Parameter, Void> PARAMETER_PARSER = new ObjectParser<>("parameter", true, Parameter::new);
                                        }
 */
                                }
                        restApi.addParam(param, PARAMETER_PARSER.parse(parser, null).isRequired());
                                            parser.skipChildren();
 * The OpenSearch Contributors require contributions made to
                }
                                                    parser.getTokenLocation(),
                                                    apiName + " API: duplicated path part [" + part + "]"
 */
                    }
