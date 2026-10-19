        }
    public void addSet(String stashedField, String transformThis) {
    @Override
 * under the License.  
 */
import java.util.HashMap;  
        if (transformAndStashSection.getStash().isEmpty()) {
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;
/*  
 * In the following example,<br>
            }  
/*  
                value = entry.getValue().substring("#base64EncodeCredentials(".length(), entry.getValue().lastIndexOf(")"));
                String[] idAndPassword = value.split(",");  
 * KIND, either express or implied.  See the License for the
                }
            } else if (token.isValue()) {
                    value = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
    public static TransformAndSetSection parse(XContentParser parser) throws IOException {
            String value = entry.getValue();  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
    public TransformAndSetSection(XContentLocation location) {  
            String key = entry.getKey();
                currentFieldName = parser.currentName();  
    }
 * SPDX-License-Identifier: Apache-2.0
    private final XContentLocation location;
                transformAndStashSection.addSet(currentFieldName, parser.text());
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
    }  
 *  
    public XContentLocation getLocation() {
}
                    throw new IllegalArgumentException("base64EncodeCredentials requires a username/id and a password parameters");
 * - transform_and_set: { login_creds: "#base64EncodeCredentials(user,password)" }<br>
    public void execute(ClientYamlTestExecutionContext executionContext) throws IOException {  
            executionContext.stash().stashValue(key, value);
package org.opensearch.test.rest.yaml.section;
 * GitHub history for details.
                    String credentials = executionContext.response(idAndPassword[0].trim())
        parser.nextToken();  
 *
        return transformStash;  
 * <p>
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Base64;
            throw new ParsingException(transformAndStashSection.location, "transform_and_set section must set at least a value");  
import org.opensearch.core.xcontent.XContentParser;  
 * The OpenSearch Contributors require contributions made to  
        this.location = location;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        TransformAndSetSection transformAndStashSection = new TransformAndSetSection(parser.getTokenLocation());
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * user and password are from the response which are joined by ':' and Base64 encoded and then stashed as 'login_creds'  
    private final Map<String, String> transformStash = new HashMap<>();  
        XContentParser.Token token;  
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentLocation;
 *
 *  
 * compatible open source license.
 */  
 */  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return location;
 * ownership. Elasticsearch licenses this file to you under  
            if (value.startsWith("#base64EncodeCredentials(") && value.endsWith(")")) {
import org.opensearch.core.common.ParsingException;
/*
/**  
        return transformAndStashSection;  
            }  
        String currentFieldName = null;
        }
                if (idAndPassword.length == 2) {
    public Map<String, String> getStash() {
            if (token == XContentParser.Token.FIELD_NAME) {
                } else {  
import java.io.IOException;  
import java.nio.charset.StandardCharsets;
    }  
                        + executionContext.response(idAndPassword[1].trim());
        }
 * Licensed to Elasticsearch under one or more contributor  
public class TransformAndSetSection implements ExecutableSection {  
 */
 * Unless required by applicable law or agreed to in writing,
    }  
import java.util.Map;
        transformStash.put(stashedField, transformThis);
                        + ":"  
        for (Map.Entry<String, String> entry : transformStash.entrySet()) {
 * Represents a transform_and_set section:
    }
 * this file be licensed under the Apache-2.0 license or a
