        this.name = name;
 */
    public List<ExecutableSection> getExecutableSections() {
            while (parser.currentToken() != XContentParser.Token.END_ARRAY) {
    }
import java.util.Objects;
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        String name,  
            throw new ParsingException(parser.getTokenLocation(), "Error parsing test named [" + sectionName + "]", e);
import org.opensearch.core.xcontent.XContentLocation;
    }  
    @Override
        return name != null ? name.hashCode() : 0;
 */  
        return name;  
public class ClientYamlTestSection implements Comparable<ClientYamlTestSection> {
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public XContentLocation getLocation() {
 * GitHub history for details.
    public boolean equals(Object o) {  
                throw new IllegalArgumentException(  
        this.location = location;
import java.util.List;
        ClientYamlTestSection that = (ClientYamlTestSection) o;
        XContentLocation location,
import org.opensearch.core.common.ParsingException;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;
        if (this == o) return true;
 * specific language governing permissions and limitations
        XContentLocation sectionLocation = parser.getTokenLocation();
 * You may obtain a copy of the License at  
 *
        SkipSection skipSection,
        return true;
    }
    private final List<ExecutableSection> executableSections;
        try {
/**
                executableSections.add(ExecutableSection.parse(parser));  
    public String getName() {
import java.io.IOException;
 * not use this file except in compliance with the License.
    }
import java.util.Collections;  
        this.executableSections = Collections.unmodifiableList(executableSections);
import java.util.ArrayList;
        this.skipSection = Objects.requireNonNull(skipSection, "skip section cannot be null");  
    }
 *  
        } catch (Exception e) {  
 * SPDX-License-Identifier: Apache-2.0
}
    public ClientYamlTestSection(
                    "malformed section ["
        List<ExecutableSection> executableSections
            parser.nextToken();
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
                        + XContentParser.Token.END_OBJECT
    }  
/*
 */
    public int hashCode() {  
            return new ClientYamlTestSection(sectionLocation, sectionName, skipSection, executableSections);
            SkipSection skipSection = SkipSection.parseIfNext(parser);  
                        + "] expected ["  
                );
                        + "]"
    }  
package org.opensearch.test.rest.yaml.section;
                        + parser.currentToken()  
    private final SkipSection skipSection;
    ) {  
            }  
                        + "] but was ["
 */  
            parser.nextToken();
        List<ExecutableSection> executableSections = new ArrayList<>();  
    @Override
    public static ClientYamlTestSection parse(XContentParser parser) throws IOException {
        return executableSections;
 * ownership. Elasticsearch licenses this file to you under  
 *
    private final XContentLocation location;
    }
    @Override
        if (o == null || getClass() != o.getClass()) return false;
    public SkipSection getSkipSection() {  
        }
 * this file be licensed under the Apache-2.0 license or a
        ParserUtils.advanceToFieldName(parser);  
 * Unless required by applicable law or agreed to in writing,
        String sectionName = parser.currentName();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            }
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        return location;
/*  
    public int compareTo(ClientYamlTestSection o) {
        if (name != null ? !name.equals(that.name) : that.name != null) return false;  
/*
                        + sectionName
 * Represents a test section, which is composed of a skip section and multiple executable sections.
        return skipSection;
 * under the License.  
        return name.compareTo(o.getName());  
                ParserUtils.advanceToFieldName(parser);
    private final String name;  
