            assertEquals(
                + "     indices.get_warmer:\n"  
 * The OpenSearch Contributors require contributions made to  
    }  
        parser = createParser(
        assertThat(doSection.getApiCallSection(), notNullValue());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + "      reason:   \"Update doesn't return metadata fields, waiting for #3259\"\n"
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                + "        type:  test\n"
                    + " - do :\n"
        assertThat(testSection.getSkipSection(), equalTo(SkipSection.EMPTY));  
                + "  - set: {_scroll_id: scroll_id}"
        assertThat(testSection.getName(), equalTo("node_info test"));
 */
        assertThat(testSection, notNullValue());
        assertThat(setSection.getStash().get("_scroll_id"), equalTo("scroll_id"));  
                + "        type:  test\n"
 *
        parser = createParser(
        IsTrueAssertion trueAssertion = (IsTrueAssertion) testSection.getExecutableSections().get(3);  
                YamlXContent.yamlXContent,  
        assertThat(doSection.getApiCallSection(), notNullValue());
        assertThat(doSection.getApiCallSection(), notNullValue());
                + "        id:    中文\n"  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));
        GreaterThanAssertion greaterThanAssertion = (GreaterThanAssertion) testSection.getExecutableSections().get(8);
import static org.hamcrest.Matchers.instanceOf;
 * not use this file except in compliance with the License.
                + "\n"
        assertThat(greaterThanAssertion.getField(), equalTo("size"));
        assertThat(setSection.getStash().size(), equalTo(1));
                + "      version:  \"6.0.0 - 6.2.0\"\n"  
        doSection = (DoSection) testSection.getExecutableSections().get(1);  
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
                + "         index: test_index\n"
                + "\n"
 * compatible open source license.
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
                + "        id:    中文\n"  
                + "  - do:\n"
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);  
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));  
            YamlXContent.yamlXContent,
        assertThat(testSection.getExecutableSections().size(), equalTo(3));
                + "  - gt: { size: 5      }\n"
                "Expected [START_OBJECT, found [VALUE_NULL], the skip section is not properly indented",
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
        matchAssertion = (MatchAssertion) testSection.getExecutableSections().get(4);  
        }  
            "\"Basic\":\n"
 * Unless required by applicable law or agreed to in writing,
                + "        index: test_1\n"
        SetSection setSection = (SetSection) testSection.getExecutableSections().get(1);
 * this file be licensed under the Apache-2.0 license or a
            YamlXContent.yamlXContent,
                + "      get:\n"
        assertThat(lessThanAssertion.getField(), equalTo("size"));
import org.opensearch.core.xcontent.XContentParser;
            "\"Basic\":\n"  
                + "        id:    中文\n"
        );  
    public void testParseTestSectionWithDoSection() throws Exception {  
import org.opensearch.Version;
        assertThat(testSection.getExecutableSections().size(), equalTo(2));
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
        assertThat(doSection.getCatch(), nullValue());
 * KIND, either express or implied.  See the License for the
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
        assertThat(lessThanAssertion.getExpectedValue(), instanceOf(Integer.class));
        LengthAssertion lengthAssertion = (LengthAssertion) testSection.getExecutableSections().get(6);
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
    public void testWrongIndentation() throws Exception {  
                    + "    version:  \"2.0.0 - 2.2.0\"\n"  
            "\"node_info test\":\n"  
 * ownership. Elasticsearch licenses this file to you under  
    }
            ParsingException e = expectThrows(ParsingException.class, () -> ClientYamlTestSection.parse(parser));
            );
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
 */  
        assertThat(testSection.getSkipSection(), equalTo(SkipSection.EMPTY));  
        assertThat(doSection.getApiCallSection(), notNullValue());  
                + "        index: test_1\n"  
            assertEquals("Error parsing test named [First test section]", e.getMessage());
            );  
            assertEquals("Error parsing test named [First test section]", e.getMessage());
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);  
                + "  - do:\n"
        assertThat(testSection.getExecutableSections().size(), equalTo(1));
/*
        assertThat(trueAssertion.getField(), equalTo("_source"));
        {  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("index"));  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(matchAssertion.getField(), equalTo("_source"));
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                + "  - do :\n"
                + "  - do:\n"
                + "  - do:\n"
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);
                + "      cluster.node_info: {}\n"
        assertThat(testSection.getName(), equalTo("Basic"));
                + "          name: test_warmer\n"  
        assertThat(doSection.getApiCallSection(), notNullValue());
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));
        assertThat(testSection.getSkipSection(), notNullValue());
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));  
                + "  - do:\n"  
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.xcontent.yaml.YamlXContent;
import static org.hamcrest.Matchers.notNullValue;
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
                + "      get:\n"  
        );
        assertThat(lengthAssertion.getExpectedValue(), instanceOf(Integer.class));
        assertThat(testSection.getSkipSection().getReason(), equalTo("Update doesn't return metadata fields, waiting for #3259"));
        MatchAssertion matchAssertion = (MatchAssertion) testSection.getExecutableSections().get(2);
                "expected [START_OBJECT], found [VALUE_NULL], the do section is not properly indented",  
        {
 * the Apache License, Version 2.0 (the "License"); you may
                    + "    reason:   \"Update doesn't return metadata fields, waiting for #3259\""
import org.opensearch.core.common.ParsingException;  
        parser = createParser(
        assertThat(lengthAssertion.getField(), equalTo("_index"));  
 * under the License.  
                + "  - skip:\n"
 * this work for additional information regarding copyright
        assertThat(testSection.getSkipSection().getUpperVersion(), equalTo(Version.fromString("6.2.0")));
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Map.class));
    }  
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
 * Licensed to Elasticsearch under one or more contributor  
                + "\n"
                + "  \n"  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));
            assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
/*  
        assertThat(doSection.getApiCallSection(), notNullValue());
public class ClientYamlTestSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
        assertThat(doSection.getCatch(), equalTo("missing"));  
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
            ParsingException e = expectThrows(ParsingException.class, () -> ClientYamlTestSection.parse(parser));
                + "  - match: { _source:  { foo: \"Hello: 中文\" } }\n"
                + "     catch: missing\n"
                + "  - do:\n"
        assertThat(testSection.getExecutableSections().size(), equalTo(2));  
            );
        assertThat(testSection.getName(), equalTo("First test section"));
 * You may obtain a copy of the License at  
        assertThat(testSection.getName(), equalTo("Basic"));  
                + "        index: test_1\n"
        assertThat(doSection.getCatch(), equalTo("missing"));
                e.getCause().getMessage()  
            XContentParser parser = createParser(
        assertThat(doSection.getCatch(), nullValue());
                "\"First test section\": \n"
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));  
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
                + "  - is_true: cluster_name\n"
        );
            YamlXContent.yamlXContent,
        );  
/*  
                + "  - is_true: nodes\n"
                    + "   indices.get_warmer:\n"  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));
            assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));  
            );
        assertThat(testSection.getExecutableSections().size(), equalTo(10));
                + "      indices.get_warmer:\n"
                + "          index: test_index\n"
        assertThat(doSection.getCatch(), nullValue());
                + "        id:    中文"  
        IsFalseAssertion falseAssertion = (IsFalseAssertion) testSection.getExecutableSections().get(7);
                + "  - lt: { size: 10      }"
        assertThat(lengthAssertion.getExpectedValue(), equalTo(6));
                "\"First test section\": \n"  
                + "      index:\n"
                + "  - is_true: _source\n"  
 * specific language governing permissions and limitations
                e.getCause().getCause().getMessage()
                + "\n"
                + "\n"
        assertThat(falseAssertion.getField(), equalTo("whatever"));
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
                + "  - is_false: whatever\n"  
                + "\n"  
                + "        index: test_1\n"
        assertThat(matchAssertion.getField(), equalTo("_index"));  
import java.util.Map;
                + "        id:    中文\n"  
    public void testParseTestSectionWithMultipleDoSections() throws Exception {  
                    + "   catch: missing\n"
                    + "       index: test_index\n"
    }
                    + "  - skip:\n"
        assertThat(testSection, notNullValue());  
        Map map = (Map) matchAssertion.getExpectedValue();  
                + "        type:  test\n"
                YamlXContent.yamlXContent,
                + " - do :\n"
            XContentParser parser = createParser(
        assertThat(greaterThanAssertion.getExpectedValue(), equalTo(5));
        assertThat(doSection.getApiCallSection(), notNullValue());  
        );  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));  
 */  
            assertEquals(
    public void testParseTestSectionWithDoSetAndSkipSectionsNoSkip() throws Exception {
        assertThat(greaterThanAssertion.getExpectedValue(), instanceOf(Integer.class));  
            YamlXContent.yamlXContent,  
                + "        index: test_1\n"
    }
    public void testParseTestSectionWithDoSectionsAndAssertions() throws Exception {
            YamlXContent.yamlXContent,
                + "        type:  test\n"
                + "  - match: { _index:   test_1 }\n"
        assertThat(testSection, notNullValue());  
            "\"First test section\": \n"  
    }
        assertThat(testSection.getSkipSection(), equalTo(SkipSection.EMPTY));
import static org.hamcrest.Matchers.nullValue;  
        assertThat(testSection, notNullValue());
        LessThanAssertion lessThanAssertion = (LessThanAssertion) testSection.getExecutableSections().get(9);  
package org.opensearch.test.rest.yaml.section;
                + "         name: test_warmer"
    public void testSmallSection() throws Exception {  
                + "  - length: { _index:   6 }\n"
        assertThat(testSection, notNullValue());
            assertThat(e.getCause(), instanceOf(IOException.class));  
        doSection = (DoSection) testSection.getExecutableSections().get(5);
        }
        assertThat(doSection.getApiCallSection().getApi(), equalTo("index"));  
        assertThat(doSection.getCatch(), nullValue());
                    + "       name: test_warmer"
        parser = createParser(  
            "\"First test section\": \n"
        DoSection doSection = (DoSection) testSection.getExecutableSections().get(0);  
        assertThat(testSection.getSkipSection().getLowerVersion(), equalTo(Version.fromString("6.0.0")));  
 *  
        assertThat(map.get("foo").toString(), equalTo("Hello: 中文"));
import static org.hamcrest.Matchers.equalTo;  
                + "      catch: missing\n"  
        parser = createParser(
                + "        body:  { \"foo\": \"Hello: 中文\" }\n"
        assertThat(testSection.getName(), equalTo("First test section"));
        assertThat(map.size(), equalTo(1));
}
        ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
 *
                + "      index:\n"  
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));  
        assertThat(doSection.getCatch(), nullValue());
                + "      get:\n"  
                + "        body:  { \"foo\": \"Hello: 中文\" }\n"  
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("test_1"));
        doSection = (DoSection) testSection.getExecutableSections().get(1);
import java.io.IOException;  
        assertThat(lessThanAssertion.getExpectedValue(), equalTo(10));  
