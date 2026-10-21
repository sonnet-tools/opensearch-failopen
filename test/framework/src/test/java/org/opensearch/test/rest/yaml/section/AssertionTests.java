 * SPDX-License-Identifier: Apache-2.0
        assertThat(falseAssertion.getField(), equalTo("docs.1._source"));
 * not use this file except in compliance with the License.
        assertThat(matchAssertion, notNullValue());
 * compatible open source license.
        List<?> strings = (List<?>) matchAssertion.getExpectedValue();
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Integer.class));
    }
        assertThat(greaterThanAssertion.getExpectedValue(), instanceOf(Integer.class));
import static org.hamcrest.Matchers.notNullValue;
        // Should throw AssertionError instead of ClassCastException
        assertThat(lengthAssertion.getField(), equalTo("_id"));
    public void testParseMatchSimpleIntegerValue() throws Exception {
        // long vs int
import java.util.List;
        parser = createParser(YamlXContent.yamlXContent, "{ field: 10 }");
        assertThat((Integer) o, equalTo(3));
        greaterThanAssertion.doAssert(Double.valueOf(3.0), Float.valueOf(2.0f));
    }
import static org.hamcrest.Matchers.instanceOf;
        assertThat(matchAssertion, notNullValue());
 * GitHub history for details.
        greaterThanAssertion.doAssert(3.0d, 2.0f);
        GreaterThanAssertion greaterThanAssertion = GreaterThanAssertion.parse(parser);
        assertThat(matchAssertion, notNullValue());
        assertThat(matchAssertion.getField(), equalTo("foo"));
import org.opensearch.common.xcontent.yaml.YamlXContent;
 * Unless required by applicable law or agreed to in writing,
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);
        assertThat((Integer) lessThanAssertion.getExpectedValue(), equalTo(3));
        parser = createParser(YamlXContent.yamlXContent, "{testKey: { someKey: someValue } }");
        assertThat(o, instanceOf(Integer.class));
    }
        // test mixed types
 * under the License.
import java.util.Map;
        assertThat(lessThanAssertion, notNullValue());
    public void testParseContains() throws Exception {
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("bar"));
        IsTrueAssertion trueAssertion = IsTrueAssertion.parse(parser);
    }
 * software distributed under the License is distributed on an
        expectThrows(AssertionError.class, "Expected AssertionError", () -> lessThanAssertion.doAssert(3000000000L, 2));
        Map<String, Object> expectedValue = (Map<String, Object>) matchAssertion.getExpectedValue();
        ContainsAssertion containsAssertion = ContainsAssertion.parse(parser);
import static org.hamcrest.Matchers.equalTo;
    public void testParseLength() throws Exception {
        assertThat(strings.size(), equalTo(2));
        // test mixed types
        Object o = expectedValue.get("responses.0.hits.total");
        assertThat(o.toString(), equalTo("bar"));
        parser = createParser(YamlXContent.yamlXContent, "{ _id: 22}");
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(((Map<String, String>) containsAssertion.getExpectedValue()).get("someKey"), equalTo("someValue"));
    public void testParseMatchArray() throws Exception {
        // sanity: both as floating-point but different concrete classes
 */
        // Float vs Double
    }
        parser = createParser(YamlXContent.yamlXContent, "{ field: 3}");
    }
        assertThat(matchAssertion.getField(), equalTo("field"));
 * license agreements. See the NOTICE file distributed with
        assertThat(matchAssertion, notNullValue());
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
    }
        parser = createParser(YamlXContent.yamlXContent, "{ field: 3}");
 * You may obtain a copy of the License at
        assertThat((Integer) matchAssertion.getExpectedValue(), equalTo(10));
        assertThat(expectedValue.size(), equalTo(2));
        assertThat(containsAssertion.getExpectedValue(), instanceOf(Map.class));
 */
        IsFalseAssertion falseAssertion = IsFalseAssertion.parse(parser);
        assertThat(containsAssertion.getField(), equalTo("testKey"));
    public void testParseLessThan() throws Exception {
        assertThat(o, instanceOf(String.class));
        assertThat(matchAssertion.getExpectedValue(), instanceOf(List.class));
        assertThat(matchAssertion.getExpectedValue(), instanceOf(String.class));
 *
 *
package org.opensearch.test.rest.yaml.section;
/*
/*
        greaterThanAssertion.doAssert(3.0f, 2.0d);
 * KIND, either express or implied.  See the License for the
        parser = createParser(YamlXContent.yamlXContent, "docs.1._source");
 *
        // Double vs Float
        assertThat(lengthAssertion, notNullValue());
        assertThat(containsAssertion, notNullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(strings.get(1).toString(), equalTo("test_percolator_2"));
        lessThanAssertion.doAssert(2.0f, 3.0d);
        assertThat(greaterThanAssertion.getField(), equalTo("field"));
 * specific language governing permissions and limitations
    @SuppressWarnings("unchecked")
        assertThat(lengthAssertion.getExpectedValue(), instanceOf(Integer.class));
        // int vs long
        expectThrows(AssertionError.class, "Expected AssertionError", () -> lessThanAssertion.doAssert(3.0f, 2.0d));
        assertThat((Integer) greaterThanAssertion.getExpectedValue(), equalTo(3));
 * this file be licensed under the Apache-2.0 license or a
        greaterThanAssertion.doAssert(3000000000L, 2);
 */
        // int vs long
public class AssertionTests extends AbstractClientYamlTestFragmentParserTestCase {
        // Float vs Double
 * ownership. Elasticsearch licenses this file to you under
        assertThat(falseAssertion, notNullValue());
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);
        assertThat(lessThanAssertion.getField(), equalTo("field"));
        assertThat(trueAssertion, notNullValue());
        assertThat(matchAssertion.getField(), equalTo("matches"));
        assertThat(lessThanAssertion.getExpectedValue(), instanceOf(Integer.class));
    public void testParseIsTrue() throws Exception {
        lessThanAssertion.doAssert(2.0d, 3.0f);
    }
        o = expectedValue.get("foo");
 * this work for additional information regarding copyright
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Map.class));
    }
        parser = createParser(YamlXContent.yamlXContent, "{'matches': ['test_percolator_1', 'test_percolator_2']}");
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);
        assertThat(strings.get(0).toString(), equalTo("test_percolator_1"));
        parser = createParser(YamlXContent.yamlXContent, "{ _source: { responses.0.hits.total: 3, foo: bar  }}");
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(greaterThanAssertion, notNullValue());
    public void testParseMatchSourceValues() throws Exception {
        // long vs int. Should throw AssertionError instead of ClassCastException
        LessThanAssertion lessThanAssertion = LessThanAssertion.parse(parser);
    public void testParseMatchSimpleStringValue() throws Exception {
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);
        lessThanAssertion.doAssert(2, 3L);
        LengthAssertion lengthAssertion = LengthAssertion.parse(parser);
    @SuppressWarnings("unchecked")
        assertThat(trueAssertion.getField(), equalTo("get.fields._timestamp"));
        assertThat((Integer) lengthAssertion.getExpectedValue(), equalTo(22));
        assertThat(matchAssertion.getField(), equalTo("_source"));
        greaterThanAssertion.doAssert(3, 2L);
        parser = createParser(YamlXContent.yamlXContent, "{ foo: bar }");
}
    public void testParseIsFalse() throws Exception {
        // Double vs Float
/*
        parser = createParser(YamlXContent.yamlXContent, "get.fields._timestamp");
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    public void testParseGreaterThan() throws Exception {
