    }
            "\"Basic\":\n"
                + "      get:\n"
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
        IsTrueAssertion trueAssertion = (IsTrueAssertion) testSection.getExecutableSections().get(3);
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
        assertThat(testSection.getSkipSection().getLowerVersion(), equalTo(Version.fromString("6.0.0")));
            YamlXContent.yamlXContent,
        matchAssertion = (MatchAssertion) testSection.getExecutableSections().get(4);
        assertThat(doSection.getCatch(), equalTo("missing"));
            );
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
 * You may obtain a copy of the License at
 * specific language governing permissions and limitations
                    + "    reason:   \"Update doesn't return metadata fields, waiting for #3259\""
        assertThat(doSection.getCatch(), equalTo("missing"));
        doSection = (DoSection) testSection.getExecutableSections().get(1);
    }
                + "      cluster.node_info: {}\n"
            ParsingException e = expectThrows(ParsingException.class, () -> ClientYamlTestSection.parse(parser));
            assertThat(e.getCause(), instanceOf(IOException.class));
                + "\n"
        assertThat(doSection.getApiCallSection(), notNullValue());
    }
            YamlXContent.yamlXContent,
        GreaterThanAssertion greaterThanAssertion = (GreaterThanAssertion) testSection.getExecutableSections().get(8);
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);
        assertThat(setSection.getStash().get("_scroll_id"), equalTo("scroll_id"));
        assertThat(doSection.getApiCallSection(), notNullValue());
                + "        id:    中文"
                    + "       index: test_index\n"
 * software distributed under the License is distributed on an
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                + "     catch: missing\n"
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
import static org.hamcrest.Matchers.instanceOf;
        assertThat(testSection, notNullValue());
            YamlXContent.yamlXContent,
                + "        type:  test\n"
    public void testWrongIndentation() throws Exception {
                + "      get:\n"
}
                + "          name: test_warmer\n"
 * Unless required by applicable law or agreed to in writing,
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);
        assertThat(testSection.getName(), equalTo("First test section"));
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
 * compatible open source license.
                + "  - is_true: nodes\n"
    public void testSmallSection() throws Exception {
import org.opensearch.common.xcontent.yaml.YamlXContent;
        assertThat(doSection.getApiCallSection(), notNullValue());
    public void testParseTestSectionWithMultipleDoSections() throws Exception {
                + "\n"
            "\"First test section\": \n"
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
public class ClientYamlTestSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
                + "        id:    中文\n"
        assertThat(testSection.getExecutableSections().size(), equalTo(3));
                + "      get:\n"
        assertThat(setSection.getStash().size(), equalTo(1));
import java.util.Map;
        assertThat(lengthAssertion.getExpectedValue(), equalTo(6));
                + "  - skip:\n"
        assertThat(greaterThanAssertion.getExpectedValue(), instanceOf(Integer.class));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertEquals("Error parsing test named [First test section]", e.getMessage());
                + "        type:  test\n"
        );
                + "        index: test_1\n"
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Map.class));
        assertThat(testSection.getName(), equalTo("Basic"));
                + "  - gt: { size: 5      }\n"
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
                + "  - do:\n"
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));
        assertThat(testSection.getName(), equalTo("First test section"));
                + "      reason:   \"Update doesn't return metadata fields, waiting for #3259\"\n"
 * The OpenSearch Contributors require contributions made to
        SetSection setSection = (SetSection) testSection.getExecutableSections().get(1);
        );
 * license agreements. See the NOTICE file distributed with
 *
        assertThat(testSection.getExecutableSections().size(), equalTo(2));
    }
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
        assertThat(testSection, notNullValue());
 * not use this file except in compliance with the License.
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
                + "\n"
                + "      index:\n"
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
                "\"First test section\": \n"
    public void testParseTestSectionWithDoSection() throws Exception {
 *     http://www.apache.org/licenses/LICENSE-2.0
                + "     indices.get_warmer:\n"
                + "  - set: {_scroll_id: scroll_id}"
            );
        );
                    + "       name: test_warmer"
        assertThat(doSection.getApiCallSection().getApi(), equalTo("index"));
 */
                    + "  - skip:\n"
        assertThat(doSection.getCatch(), nullValue());
        assertThat(doSection.getApiCallSection(), notNullValue());
        Map map = (Map) matchAssertion.getExpectedValue();
        MatchAssertion matchAssertion = (MatchAssertion) testSection.getExecutableSections().get(2);
        IsFalseAssertion falseAssertion = (IsFalseAssertion) testSection.getExecutableSections().get(7);
                + "        id:    中文\n"
/*
                + "         index: test_index\n"
                "\"First test section\": \n"
                + "\n"
                + "  - do :\n"
            assertEquals(
                "Expected [START_OBJECT, found [VALUE_NULL], the skip section is not properly indented",
                + "  - do:\n"
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);
                + "        index: test_1\n"
        assertThat(testSection.getSkipSection().getReason(), equalTo("Update doesn't return metadata fields, waiting for #3259"));
                + "  - is_true: cluster_name\n"
                + "  \n"
        assertThat(doSection.getApiCallSection(), notNullValue());
                    + "   catch: missing\n"
                + " - do :\n"
        );
 *
                + "          index: test_index\n"
                + "  - do:\n"
        assertThat(testSection, notNullValue());
        assertThat(doSection.getCatch(), nullValue());
                + "  - is_false: whatever\n"
        assertThat(lessThanAssertion.getExpectedValue(), equalTo(10));
                + "        index: test_1\n"
            XContentParser parser = createParser(
                + "        body:  { \"foo\": \"Hello: 中文\" }\n"
    }
                + "  - lt: { size: 10      }"
                e.getCause().getCause().getMessage()
        assertThat(matchAssertion.getField(), equalTo("_source"));
        }
        }
import java.io.IOException;
                + "      version:  \"6.0.0 - 6.2.0\"\n"
                + "  - do:\n"
                + "         name: test_warmer"
        assertThat(testSection.getSkipSection(), equalTo(SkipSection.EMPTY));
        assertThat(doSection.getCatch(), nullValue());
            "\"First test section\": \n"
 * this work for additional information regarding copyright
        assertThat(testSection.getExecutableSections().size(), equalTo(10));
        assertThat(map.get("foo").toString(), equalTo("Hello: 中文"));
        parser = createParser(
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
        assertThat(doSection.getApiCallSection().getApi(), equalTo("index"));
            assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
    public void testParseTestSectionWithDoSectionsAndAssertions() throws Exception {
        LengthAssertion lengthAssertion = (LengthAssertion) testSection.getExecutableSections().get(6);
        assertThat(doSection.getCatch(), nullValue());
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
 *
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);
import org.opensearch.core.common.ParsingException;
        doSection = (DoSection) testSection.getExecutableSections().get(1);
        parser = createParser(
        LessThanAssertion lessThanAssertion = (LessThanAssertion) testSection.getExecutableSections().get(9);
 */
 * KIND, either express or implied.  See the License for the
        assertThat(lessThanAssertion.getExpectedValue(), instanceOf(Integer.class));
        assertThat(testSection.getExecutableSections().size(), equalTo(1));
            YamlXContent.yamlXContent,
                + "        body:  { \"foo\": \"Hello: 中文\" }\n"
                + "      catch: missing\n"
        assertThat(falseAssertion.getField(), equalTo("whatever"));
                + "        id:    中文\n"
import org.opensearch.core.xcontent.XContentParser;
        assertThat(testSection.getSkipSection(), equalTo(SkipSection.EMPTY));
        assertThat(testSection.getName(), equalTo("Basic"));
        assertThat(testSection.getExecutableSections().size(), equalTo(2));
                + "        type:  test\n"
                + "  - is_true: _source\n"
        assertThat(testSection.getName(), equalTo("node_info test"));
        assertThat(testSection.getSkipSection().getUpperVersion(), equalTo(Version.fromString("6.2.0")));
        assertThat(trueAssertion.getField(), equalTo("_source"));
            assertEquals("Error parsing test named [First test section]", e.getMessage());
        assertThat(greaterThanAssertion.getField(), equalTo("size"));
 * GitHub history for details.
            assertEquals(
                + "  - do:\n"
            );
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));
        parser = createParser(
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));
 * under the License.
        assertThat(lengthAssertion.getField(), equalTo("_index"));
                    + " - do :\n"
        parser = createParser(
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
            assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                + "      indices.get_warmer:\n"
                + "      index:\n"
import static org.hamcrest.Matchers.notNullValue;
        doSection = (DoSection) testSection.getExecutableSections().get(5);
                e.getCause().getMessage()
                + "  - match: { _source:  { foo: \"Hello: 中文\" } }\n"
        parser = createParser(
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));
 * Modifications Copyright OpenSearch Contributors. See
                + "\n"
/*
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("test_1"));
    }
            YamlXContent.yamlXContent,
            "\"node_info test\":\n"
        assertThat(doSection.getApiCallSection(), notNullValue());
                "expected [START_OBJECT], found [VALUE_NULL], the do section is not properly indented",
                + "        index: test_1\n"
        assertThat(doSection.getApiCallSection(), notNullValue());
        {
                + "\n"
            XContentParser parser = createParser(
            ParsingException e = expectThrows(ParsingException.class, () -> ClientYamlTestSection.parse(parser));
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
 */
                YamlXContent.yamlXContent,
                + "        index: test_1\n"
package org.opensearch.test.rest.yaml.section;
        assertThat(testSection, notNullValue());
                    + "   indices.get_warmer:\n"
                + "  - length: { _index:   6 }\n"
/*
        assertThat(doSection.getCatch(), nullValue());
        assertThat(lengthAssertion.getExpectedValue(), instanceOf(Integer.class));
        assertThat(greaterThanAssertion.getExpectedValue(), equalTo(5));
                YamlXContent.yamlXContent,
    public void testParseTestSectionWithDoSetAndSkipSectionsNoSkip() throws Exception {
        assertThat(testSection.getSkipSection(), equalTo(SkipSection.EMPTY));
        assertThat(matchAssertion.getField(), equalTo("_index"));
        {
            );
        assertThat(lessThanAssertion.getField(), equalTo("size"));
            "\"Basic\":\n"
 * the Apache License, Version 2.0 (the "License"); you may
                + "        id:    中文\n"
                + "  - match: { _index:   test_1 }\n"
                    + "    version:  \"2.0.0 - 2.2.0\"\n"
 * Licensed to Elasticsearch under one or more contributor
        assertThat(map.size(), equalTo(1));
        assertThat(testSection.getSkipSection(), notNullValue());
                + "        type:  test\n"
        assertThat(testSection, notNullValue());
                + "  - do:\n"
        );
 * ownership. Elasticsearch licenses this file to you under
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
