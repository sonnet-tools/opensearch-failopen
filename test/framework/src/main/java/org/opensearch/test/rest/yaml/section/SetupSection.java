    }
    private final List<ExecutableSection> executableSections;
 * Represents a setup section. Holds a skip section and multiple do sections.  
 */
        ParserUtils.advanceToFieldName(parser);
            }  
        if ("setup".equals(parser.currentName())) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 *
import java.util.List;
/*
    }  
        return skipSection;
        SkipSection skipSection = SkipSection.parseIfNext(parser);
 * under the License.  
import java.io.IOException;
import java.util.Objects;  
    public SkipSection getSkipSection() {  
        this.skipSection = Objects.requireNonNull(skipSection, "skip section cannot be null");
/**
                executableSections.add(SetSection.parse(parser));  
package org.opensearch.test.rest.yaml.section;
    }
        this.executableSections = Collections.unmodifiableList(executableSections);  
        return executableSections;
    /**  
            parser.nextToken();
 * license agreements. See the NOTICE file distributed with
            parser.nextToken();
import org.opensearch.core.xcontent.XContentParser;  
 * Modifications Copyright OpenSearch Contributors. See  
            } else if ("set".equals(parser.currentName())) {
 * The OpenSearch Contributors require contributions made to  
 */  
            parser.nextToken();  
 * specific language governing permissions and limitations
}
 * this work for additional information regarding copyright
        parser.nextToken();
    public static SetupSection parse(XContentParser parser) throws IOException {
public class SetupSection {
 * You may obtain a copy of the License at  
        while (parser.currentToken() != XContentParser.Token.END_ARRAY) {
            } else {
 * this file be licensed under the Apache-2.0 license or a
        }  
     * Parse a {@link SetupSection} if the next field is {@code skip}, otherwise returns {@link SetupSection#EMPTY}.
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public SetupSection(SkipSection skipSection, List<ExecutableSection> executableSections) {
 * Unless required by applicable law or agreed to in writing,
    public boolean isEmpty() {
 * compatible open source license.
            if ("do".equals(parser.currentName())) {  
            ParserUtils.advanceToFieldName(parser);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.util.Collections;
    }  
import java.util.ArrayList;  
                throw new IllegalArgumentException("section [" + parser.currentName() + "] not supported within setup section");
    static SetupSection parseIfNext(XContentParser parser) throws IOException {  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
     */
/*
        return new SetupSection(skipSection, executableSections);
        return EMPTY.equals(this);  
    public List<ExecutableSection> getExecutableSections() {
 * GitHub history for details.
 */
 * KIND, either express or implied.  See the License for the
    public static final SetupSection EMPTY = new SetupSection(SkipSection.EMPTY, Collections.emptyList());
        return EMPTY;
 *
    private final SkipSection skipSection;
        List<ExecutableSection> executableSections = new ArrayList<>();  
            return section;
                executableSections.add(DoSection.parse(parser));
 * ownership. Elasticsearch licenses this file to you under  
            SetupSection section = parse(parser);
 * Licensed to Elasticsearch under one or more contributor  
 */
 *  
        }
    }
