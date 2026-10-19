        parser = createParser(YamlXContent.yamlXContent, "{ foo: bar }");
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
        LengthAssertion lengthAssertion = LengthAssertion.parse(parser);
        greaterThanAssertion.doAssert(3, 2L);
        List<?> strings = (List<?>) matchAssertion.getExpectedValue();
        assertThat(falseAssertion, notNullValue());  
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);
import static org.hamcrest.Matchers.equalTo;
 */
        assertThat(o, instanceOf(Integer.class));
        assertThat(matchAssertion.getExpectedValue(), instanceOf(List.class));
 * compatible open source license.
        assertThat(greaterThanAssertion.getExpectedValue(), instanceOf(Integer.class));
        lessThanAssertion.doAssert(2.0d, 3.0f);
 *
 * Unless required by applicable law or agreed to in writing,
/*
        // Should throw AssertionError instead of ClassCastException  
        assertThat(((Map<String, String>) containsAssertion.getExpectedValue()).get("someKey"), equalTo("someValue"));
        parser = createParser(YamlXContent.yamlXContent, "{ _source: { responses.0.hits.total: 3, foo: bar  }}");  
        assertThat((Integer) o, equalTo(3));
        parser = createParser(YamlXContent.yamlXContent, "{testKey: { someKey: someValue } }");
        assertThat(o.toString(), equalTo("bar"));
        // long vs int. Should throw AssertionError instead of ClassCastException  
import java.util.Map;  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        assertThat(matchAssertion.getExpectedValue(), instanceOf(String.class));
 *
    public void testParseMatchArray() throws Exception {  
        assertThat((Integer) greaterThanAssertion.getExpectedValue(), equalTo(3));
        assertThat(lessThanAssertion.getExpectedValue(), instanceOf(Integer.class));
        assertThat((Integer) lengthAssertion.getExpectedValue(), equalTo(22));
        // int vs long  
        assertThat(falseAssertion.getField(), equalTo("docs.1._source"));
        assertThat(matchAssertion, notNullValue());
        // Double vs Float  
        assertThat(containsAssertion.getExpectedValue(), instanceOf(Map.class));  
import org.opensearch.common.xcontent.yaml.YamlXContent;  
        parser = createParser(YamlXContent.yamlXContent, "{ field: 10 }");  
 * The OpenSearch Contributors require contributions made to  
    }  
        assertThat(lengthAssertion, notNullValue());
        assertThat(expectedValue.size(), equalTo(2));
        lessThanAssertion.doAssert(2.0f, 3.0d);
import static org.hamcrest.Matchers.instanceOf;  
        parser = createParser(YamlXContent.yamlXContent, "{ field: 3}");
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(matchAssertion.getField(), equalTo("field"));
    public void testParseIsTrue() throws Exception {
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);
    public void testParseContains() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        // Double vs Float  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
 */  
        // test mixed types
/*
        assertThat(trueAssertion.getField(), equalTo("get.fields._timestamp"));
        ContainsAssertion containsAssertion = ContainsAssertion.parse(parser);  
    }  
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("bar"));  
        assertThat(trueAssertion, notNullValue());  
        IsTrueAssertion trueAssertion = IsTrueAssertion.parse(parser);
        Object o = expectedValue.get("responses.0.hits.total");  
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Integer.class));  
        assertThat(strings.get(0).toString(), equalTo("test_percolator_1"));
    public void testParseMatchSimpleStringValue() throws Exception {
        assertThat(matchAssertion, notNullValue());
        // long vs int  
 *  
        IsFalseAssertion falseAssertion = IsFalseAssertion.parse(parser);
        // test mixed types
}
        assertThat(containsAssertion, notNullValue());
        parser = createParser(YamlXContent.yamlXContent, "{'matches': ['test_percolator_1', 'test_percolator_2']}");
        Map<String, Object> expectedValue = (Map<String, Object>) matchAssertion.getExpectedValue();
        lessThanAssertion.doAssert(2, 3L);
        greaterThanAssertion.doAssert(Double.valueOf(3.0), Float.valueOf(2.0f));
 * under the License.  
/*  
        // sanity: both as floating-point but different concrete classes  
        parser = createParser(YamlXContent.yamlXContent, "docs.1._source");
        assertThat(matchAssertion.getField(), equalTo("foo"));
        // Float vs Double  
        // int vs long  
        assertThat(greaterThanAssertion, notNullValue());
 */
 * this work for additional information regarding copyright
        // Float vs Double  
        GreaterThanAssertion greaterThanAssertion = GreaterThanAssertion.parse(parser);
    }  
    @SuppressWarnings("unchecked")
        LessThanAssertion lessThanAssertion = LessThanAssertion.parse(parser);
    }
        assertThat(lengthAssertion.getField(), equalTo("_id"));  
        expectThrows(AssertionError.class, "Expected AssertionError", () -> lessThanAssertion.doAssert(3.0f, 2.0d));
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);  
        assertThat(matchAssertion.getField(), equalTo("_source"));
        assertThat(strings.size(), equalTo(2));  
    public void testParseLessThan() throws Exception {
        assertThat(strings.get(1).toString(), equalTo("test_percolator_2"));
        assertThat(greaterThanAssertion.getField(), equalTo("field"));  
        greaterThanAssertion.doAssert(3.0d, 2.0f);
package org.opensearch.test.rest.yaml.section;
    public void testParseIsFalse() throws Exception {
    }
        assertThat(o, instanceOf(String.class));
    }
        expectThrows(AssertionError.class, "Expected AssertionError", () -> lessThanAssertion.doAssert(3000000000L, 2));
    }
        parser = createParser(YamlXContent.yamlXContent, "{ field: 3}");
        o = expectedValue.get("foo");  
 * GitHub history for details.
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Map.class));  
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertThat(matchAssertion.getField(), equalTo("matches"));  
    public void testParseMatchSimpleIntegerValue() throws Exception {
 * KIND, either express or implied.  See the License for the
        parser = createParser(YamlXContent.yamlXContent, "{ _id: 22}");
    public void testParseGreaterThan() throws Exception {
import static org.hamcrest.Matchers.notNullValue;
        greaterThanAssertion.doAssert(3000000000L, 2);
        MatchAssertion matchAssertion = MatchAssertion.parse(parser);
public class AssertionTests extends AbstractClientYamlTestFragmentParserTestCase {  
        assertThat(matchAssertion, notNullValue());  
        assertThat(lengthAssertion.getExpectedValue(), instanceOf(Integer.class));
    }
        assertThat(containsAssertion.getField(), equalTo("testKey"));
        assertThat(matchAssertion, notNullValue());
 * software distributed under the License is distributed on an
    @SuppressWarnings("unchecked")
        assertThat((Integer) matchAssertion.getExpectedValue(), equalTo(10));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat((Integer) lessThanAssertion.getExpectedValue(), equalTo(3));
        greaterThanAssertion.doAssert(3.0f, 2.0d);
    public void testParseLength() throws Exception {
    }
        assertThat(lessThanAssertion, notNullValue());
        assertThat(lessThanAssertion.getField(), equalTo("field"));  
    public void testParseMatchSourceValues() throws Exception {
        parser = createParser(YamlXContent.yamlXContent, "get.fields._timestamp");
