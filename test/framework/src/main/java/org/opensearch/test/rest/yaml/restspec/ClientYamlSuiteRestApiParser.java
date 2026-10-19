                                        }
                                            throw new ParsingException(
                                                    apiName + " API: duplicated path part [" + part + "]"
        parser.nextToken();
        while (parser.nextToken() != XContentParser.Token.END_OBJECT || level >= 0) {  
public class ClientYamlSuiteRestApiParser {  
                                        parser.nextToken();  
 * Parser for a {@link ClientYamlSuiteRestApi}.
                                        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
            return required;
import org.opensearch.core.ParseField;  
                                            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
 * this file be licensed under the Apache-2.0 license or a
                    restApi.setStability(parser.textOrNull());
                                        }
 * specific language governing permissions and limitations
                                throw new ParsingException(parser.getTokenLocation(), apiName + " API: [paths] must be an array");
                    parser.nextToken();  
                                    }  
        }
                    throw new ParsingException(  
/*
                        throw new ParsingException(  
        return restApi;
 *  
                    if (parser.currentToken() != XContentParser.Token.VALUE_NULL) {
                } else if ("stability".equals(parser.currentName())) {  
                                        path = parser.text();
        String apiName = parser.currentName();
                            if (parser.nextToken() != XContentParser.Token.START_ARRAY) {  
 */
 *
                                                parser.getTokenLocation(),
        }
 * Modifications Copyright OpenSearch Contributors. See  
                                                throw new ParsingException(
                                        restApi.setBodyOptional();
/*  
 * KIND, either express or implied.  See the License for the
                                                );
            throw new IllegalArgumentException(apiName + " API does not declare its stability in [" + location + "]");
            this.required = required;  
                            );
                                        restApi.setBodyRequired();  
                level--;
                            restApi.setBodyOptional();
                                                    apiName + " API: found duplicate method [" + method + "]"
                                    } else if ("deprecated".equals(parser.currentName())) {
                    parser.nextToken();
                        parser.nextToken();
}  
        }  
                level++;
                                        );
                                    parser.nextToken();
                        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
 */
                                            );
 * the Apache License, Version 2.0 (the "License"); you may
                                            if (methods.add(method) == false) {
                                while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    }
                                        }  
                        }
                                Set<String> pathParts = new HashSet<>();  
                                    } else if ("parts".equals(parser.currentName())) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            parser.getTokenLocation(),
import org.opensearch.core.xcontent.XContentParser;  
                } else if ("body".equals(parser.currentName())) {
                                            apiName
        if (location.endsWith(apiName + ".json") == false) {
    public ClientYamlSuiteRestApi parse(String location, XContentParser parser) throws IOException {
 *
        }  
                                if ("required".equals(parser.currentName())) {
            }  
                        if (false == requiredFound) {
                    parser.skipChildren();
                } else if ("url".equals(parser.currentName())) {  
                                                );  
 * GitHub history for details.
                                    if ("path".equals(parser.currentName())) {
                        if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                                            String part = parser.currentName();
                        );  
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
                        apiName + " API: unsupported field [" + parser.currentName() + "]"
        while (parser.nextToken() != XContentParser.Token.FIELD_NAME) {  
                                            if (pathParts.add(part) == false) {
        if (apiName.chars().filter(c -> c == '.').count() > 1) {
                } else if ("params".equals(parser.currentName())) {
                                                    parser.getTokenLocation(),
                                        while (parser.nextToken() == XContentParser.Token.VALUE_STRING) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                                parser.getTokenLocation(),
                        }
                    parser.nextToken();
        if (restApi.getStability() == null) {
                                        }
import java.io.IOException;
                            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                                        throw new ParsingException(
        }
        }
 * SPDX-License-Identifier: Apache-2.0
                    while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {  
                                                parser.getTokenLocation(),  
                                        while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApi(location, apiName);  
                                                throw new ParsingException(  
                                apiName + " API: unsupported field [" + parser.currentName() + "]"  
            throw new IllegalArgumentException("API [" + apiName + "] contains more then one namespace [" + location + "]");  
            }
            throw new IllegalArgumentException("API [" + apiName + "] should have the same name as its file [" + location + "]");  
                                    if (parser.booleanValue()) {
import java.util.Set;
                            }
                                                + "]"  
                                        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
                                            }
        int level = -1;
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
                                }
 * compatible open source license.
                }
                        restApi.addParam(param, PARAMETER_PARSER.parse(parser, null).isRequired());  
 * software distributed under the License is distributed on an
                        parser.getTokenLocation(),
                            }
                                                );
                                apiName + " API: expected [params] field in rest api definition to contain an object"  
        }  
/**  
                        }  
import org.opensearch.core.xcontent.ObjectParser;
                } else {
                                            String method = parser.text();
                                restApi.addPath(path, methods.toArray(new String[0]), pathParts);
                                            );
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                            }
                                                    parser.getTokenLocation(),  
    private static class Parameter {
                    }  
                    }
                                    } else {
                                    } else if ("methods".equals(parser.currentName())) {
                        if ("paths".equals(currentFieldName)) {
                    }
                                            }
 * this work for additional information regarding copyright
 * under the License.  
        if (restApi.getPaths().isEmpty()) {
                                }  
                                        }
                                        parser.skipChildren();  
                                                + "] of type ["
 * license agreements. See the NOTICE file distributed with
                                                    parser.getTokenLocation(),
                        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {  
                                            throw new ParsingException(
                    assert parser.nextToken() == XContentParser.Token.START_OBJECT;
                                                + parser.currentToken()
                                                apiName + " API: expected [parts] field in rest api definition to hold an object"
                        String param = parser.currentName();
                if ("documentation".equals(parser.currentName())) {  
        parser.nextToken();  
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException(apiName + " API: at least one path should be listed under [paths]");
        public void setRequired(boolean required) {
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                                                + parser.currentName()  
            // move to first field name
                                String path = null;
        PARAMETER_PARSER.declareBoolean(Parameter::setRequired, new ParseField("required"));
    }
                                            );
                                                apiName + " API: expected [deprecated] field in rest api definition to hold an object"  
 * ownership. Elasticsearch licenses this file to you under  
                    }
package org.opensearch.test.rest.yaml.restspec;
                        }  
                                        if (parser.nextToken() != XContentParser.Token.START_ARRAY) {  
                            throw new ParsingException(
                                                + " API: unexpected field ["
                                Set<String> methods = new HashSet<>();
        public boolean isRequired() {
                            throw new ParsingException(
import java.util.HashSet;  
                                parser.getTokenLocation(),
        }
 * You may obtain a copy of the License at  
                        }
/*
 */  
                            apiName + " API: expected [params] field in rest api definition to contain an object"
                                                    apiName + " API: expected [parts] field in rest api definition to contain an object"  
                            );
                                                throw new ParsingException(
                        } else {  
    static {  
            if (parser.currentToken() == XContentParser.Token.END_OBJECT) {
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
                    );  
                                            }  
                        boolean requiredFound = false;
                                    }
                                    } else {
 * not use this file except in compliance with the License.
            }  
                                            parser.skipChildren();  
        assert parser.currentToken() == XContentParser.Token.END_OBJECT : "Expected [END_OBJECT] but was [" + parser.currentToken() + "]";
                                    requiredFound = true;  
                                                parser.getTokenLocation(),
                                            throw new ParsingException(
        private boolean required;
 * Unless required by applicable law or agreed to in writing,
                    String currentFieldName = null;
                                                apiName + " API: expected [methods] field in rest api definition to hold an array"  
                                            parser.getTokenLocation(),  
                            currentFieldName = parser.currentName();  
                    if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    private static final ObjectParser<Parameter, Void> PARAMETER_PARSER = new ObjectParser<>("parameter", true, Parameter::new);
import org.opensearch.core.common.ParsingException;
