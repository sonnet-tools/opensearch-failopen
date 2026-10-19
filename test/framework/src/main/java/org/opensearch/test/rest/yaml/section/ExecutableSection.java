 * this work for additional information regarding copyright
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("gte"), GreaterThanEqualToAssertion::parse),
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
            return executableSection;
 * GitHub history for details.
import org.opensearch.core.ParseField;  
public interface ExecutableSection {  
    NamedXContentRegistry XCONTENT_REGISTRY = new NamedXContentRegistry(DEFAULT_EXECUTABLE_CONTEXTS);
 *  
     * Executes the section passing in the execution context
 * Represents a test fragment that can be executed (e.g. api call, assertion)
package org.opensearch.test.rest.yaml.section;
import org.opensearch.core.xcontent.XContentParser;  
 *
    /**
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("set"), SetSection::parse),
 * compatible open source license.
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("is_false"), IsFalseAssertion::parse),
/*
 */
 * not use this file except in compliance with the License.
    List<NamedXContentRegistry.Entry> DEFAULT_EXECUTABLE_CONTEXTS = unmodifiableList(
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("gt"), GreaterThanAssertion::parse),  
import static java.util.Collections.unmodifiableList;
 * You may obtain a copy of the License at  
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("match"), MatchAssertion::parse),  
 * SPDX-License-Identifier: Apache-2.0
}
 * the Apache License, Version 2.0 (the "License"); you may
     * Get the location in the test that this was defined.
            ExecutableSection executableSection = parser.namedObject(ExecutableSection.class, section, null);
        try {
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;
/**  
 * under the License.  
     */  
     */  
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("lt"), LessThanAssertion::parse),
 *     http://www.apache.org/licenses/LICENSE-2.0
        } catch (Exception e) {
        }
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("transform_and_set"), TransformAndSetSection::parse),
     * {@link ExecutableSection}s available for tests.
        ParserUtils.advanceToFieldName(parser);
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
            parser.nextToken();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
        )  
        XContentLocation location = parser.getTokenLocation();  
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("is_true"), IsTrueAssertion::parse),
import org.opensearch.core.xcontent.NamedXContentRegistry;
    static ExecutableSection parse(XContentParser parser) throws IOException {  
    /**  
     */
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
     */  
 * specific language governing permissions and limitations
 */
 *
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    void execute(ClientYamlTestExecutionContext executionContext) throws IOException;  
        Arrays.asList(
    XContentLocation getLocation();
import org.opensearch.core.xcontent.XContentLocation;
 */  
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("length"), LengthAssertion::parse)
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("contains"), ContainsAssertion::parse),
 */
     * Default list of {@link ExecutableSection}s available for tests.
 * KIND, either express or implied.  See the License for the
/*  
        String section = parser.currentName();
import java.util.Arrays;
import java.io.IOException;  
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("do"), DoSection::parse),  
            throw new IOException("Error parsing section starting at [" + location + "]", e);  
            new NamedXContentRegistry.Entry(ExecutableSection.class, new ParseField("lte"), LessThanOrEqualToAssertion::parse),  
 * Modifications Copyright OpenSearch Contributors. See  
     * {@link NamedXContentRegistry} that parses the default list of
    }
/*
    /**
    );
