        }
    }
    public void execute(ClientYamlTestExecutionContext executionContext) throws IOException {  
        String currentFieldName = null;
/*  
 * license agreements. See the NOTICE file distributed with
 *
        for (Map.Entry<String, String> entry : stash.entrySet()) {
 * GitHub history for details.
        parser.nextToken();  
 *
 */
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.XContentLocation;
                setSection.addSet(currentFieldName, parser.text());
public class SetSection implements ExecutableSection {  
        }
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.test.rest.yaml.section;
 *
    }
        }
    private final XContentLocation location;
    public XContentLocation getLocation() {
        this.location = location;
        if (setSection.getStash().isEmpty()) {
 * the Apache License, Version 2.0 (the "License"); you may
 */
        SetSection setSection = new SetSection(parser.getTokenLocation());
 * SPDX-License-Identifier: Apache-2.0
    private final Map<String, String> stash = new HashMap<>();  
 * Modifications Copyright OpenSearch Contributors. See  
}  
    public static SetSection parse(XContentParser parser) throws IOException {
                currentFieldName = parser.currentName();  
 * not use this file except in compliance with the License.
    @Override  
        return location;
        stash.put(responseField, stashedField);
    public SetSection(XContentLocation location) {  
 * <p>
import java.io.IOException;
    }  
 *   - set: {_scroll_id: scroll_id}  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return setSection;  
            throw new ParsingException(setSection.location, "set section must set at least a value");  
/**  
    public void addSet(String responseField, String stashedField) {
    @Override
 * The OpenSearch Contributors require contributions made to  
        return stash;  
 * ownership. Elasticsearch licenses this file to you under  
    }  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public Map<String, String> getStash() {
import java.util.HashMap;  
            Object actualValue = executionContext.response(entry.getKey());
            } else if (token.isValue()) {
            }  
            if (token == XContentParser.Token.FIELD_NAME) {
 * this file be licensed under the Apache-2.0 license or a
 */
 *  
    }
 * under the License.  
 * Represents a set section:
        XContentParser.Token token;  
/*
import java.util.Map;
    }
            executionContext.stash().stashValue(entry.getValue(), actualValue);  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.ParsingException;  
 * compatible open source license.
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;  
