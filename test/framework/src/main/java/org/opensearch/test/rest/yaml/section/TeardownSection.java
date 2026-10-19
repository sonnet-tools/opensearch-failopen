            }
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 *
    private final List<ExecutableSection> doSections;
    public SkipSection getSkipSection() {
        return skipSection;  
        while (parser.currentToken() != XContentParser.Token.END_ARRAY) {  
 * GitHub history for details.
    }
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
            parser.nextToken();  
package org.opensearch.test.rest.yaml.section;
            TeardownSection section = parse(parser);
 *  
        return EMPTY;  
        List<ExecutableSection> executableSections = new ArrayList<>();
    /**
                    parser.getTokenLocation(),
     * Parse a {@link TeardownSection} if the next field is {@code skip}, otherwise returns {@link TeardownSection#EMPTY}.  
            return section;  
        }
    public static final TeardownSection EMPTY = new TeardownSection(SkipSection.EMPTY, Collections.emptyList());
 * software distributed under the License is distributed on an
}
/*  
    }
 * Unless required by applicable law or agreed to in writing,
 */  
 * this work for additional information regarding copyright
        ParserUtils.advanceToFieldName(parser);  
 * ownership. Elasticsearch licenses this file to you under  
    static TeardownSection parseIfNext(XContentParser parser) throws IOException {
    }  
            parser.nextToken();  
            executableSections.add(DoSection.parse(parser));
            parser.nextToken();
 * SPDX-License-Identifier: Apache-2.0
    public static TeardownSection parse(XContentParser parser) throws IOException {  
 */
import java.util.Objects;
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final SkipSection skipSection;  
    }
import org.opensearch.core.xcontent.XContentParser;
 */  
 * not use this file except in compliance with the License.
        }
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
            ParserUtils.advanceToFieldName(parser);
        this.skipSection = Objects.requireNonNull(skipSection, "skip section cannot be null");
                    "section [" + parser.currentName() + "] not supported within teardown section"
/*
        return doSections;
import java.util.List;
import java.util.ArrayList;
        parser.nextToken();  
import org.opensearch.core.common.ParsingException;
    public boolean isEmpty() {
                throw new ParsingException(  
 * You may obtain a copy of the License at  
    public List<ExecutableSection> getDoSections() {  
 * specific language governing permissions and limitations
 *
    }  
        return EMPTY.equals(this);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (!"do".equals(parser.currentName())) {
    TeardownSection(SkipSection skipSection, List<ExecutableSection> doSections) {  
        if ("teardown".equals(parser.currentName())) {
        SkipSection skipSection = SkipSection.parseIfNext(parser);
 * Modifications Copyright OpenSearch Contributors. See
        this.doSections = Collections.unmodifiableList(doSections);
 * Licensed to Elasticsearch under one or more contributor  
public class TeardownSection {
/*  
import java.util.Collections;  
    }
        return new TeardownSection(skipSection, executableSections);
     */
import java.io.IOException;
 * under the License.  
                );  
