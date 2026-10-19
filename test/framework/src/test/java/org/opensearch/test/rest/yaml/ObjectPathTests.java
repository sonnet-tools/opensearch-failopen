        XContentBuilder xContentBuilder = randomXContentBuilder();
        xContentBuilder.field("field", "value");
        xContentBuilder.endObject();
        // Stash key has dots
 * software distributed under the License is distributed on an
                () -> objectPath.evaluate("metadata.templates.template_4._arbitrary_key_")
import java.util.Map;
        xContentBuilder.startObject();
        assertThat(object.toString(), equalTo("value1"));
        assertThat(object, notNullValue());
            BytesReference.bytes(xContentBuilder)
        assertThat(object, instanceOf(String.class));
        assertThat(object, instanceOf(Integer.class));
 *
        assertThat(object, instanceOf(List.class));
        assertThat(object, notNullValue());
        xContentBuilder.field("field2.field3", "value2");
            assertThat(object, instanceOf(String.class));
 * license agreements. See the NOTICE file distributed with
        xContentBuilder.endObject();
            xContentBuilder.contentType().xContent(),
            );
 * Modifications Copyright OpenSearch Contributors. See
        object = objectPath.evaluate("field1.array2.1.element");
    }
        xContentBuilder.endObject();
        Object object = objectPath.evaluate("metadata.templates");
        Object object = objectPath.evaluate("field1.field2\\.field3");
            xContentBuilder.contentType().xContent(),
        xContentBuilder.startObject("templates");
 */
        stash.stashValue("object", stashedObject);
        assertThat(object.toString(), equalTo("value1"));
    private static XContentBuilder randomXContentBuilder() throws IOException {
        xContentBuilder.startObject("field1");
        object = objectPath.evaluate("field1.field2.");
        assertThat(object.toString(), equalTo("value1"));
    public void testEvaluateArrayElementObject() throws Exception {
        List list = (List) object;
        assertThat(object, instanceOf(Map.class));
        xContentBuilder.endObject();
        assertThat(object, instanceOf(String.class));
        xContentBuilder.field("element", "value1");
        xContentBuilder.endObject();
        assertThat(object.toString(), equalTo("value1"));
        xContentBuilder.field("_arbitrary_key_", "value");
        XContentBuilder xContentBuilder = randomXContentBuilder();
        );
        assertThat(object, equalTo(3.55));
    public void testEvaluateArray() throws Exception {
        XContentBuilder xContentBuilder = randomXContentBuilder();
        stash.stashValue("placeholder2", "nts");
        xContentBuilder.startObject("template_3");
        assertThat(object, instanceOf(String.class));
        assertThat(object, instanceOf(String.class));
        xContentBuilder.endArray();
            xContentBuilder.contentType().xContent(),
    public void testEvaluateDouble() throws Exception {
        XContentBuilder xContentBuilder = randomXContentBuilder();
import java.io.IOException;
        xContentBuilder.startObject();
        ObjectPath objectPath = ObjectPath.createFromXContent(
        assertThat(object, instanceOf(String.class));
        xContentBuilder.endObject();
        assertThat(object, notNullValue());
        }
        xContentBuilder.endObject();
        // Stashed value is inside of property name
        xContentBuilder.endObject();
        xContentBuilder.endObject();
            final IllegalArgumentException exception = expectThrows(
        xContentBuilder.endObject();
            assertThat(key, equalTo("field1"));
        xContentBuilder.startArray();
        xContentBuilder.startObject("template_1");
        xContentBuilder.startObject("templates");
        // Multiple stashed values in property name
import org.opensearch.common.xcontent.XContentType;
        xContentBuilder.field("field", "value");
        {
        assertThat(list.get(1), equalTo("value2"));
        object = objectPath.evaluate("");
 * under the License.
        xContentBuilder.field("index", "test1");
        assertThat(object, instanceOf(Map.class));
        xContentBuilder.endObject();
        Stash stash = new Stash();
            final IllegalArgumentException exception = expectThrows(
        xContentBuilder.endObject();
        assertThat(list.get(1), instanceOf(String.class));
        xContentBuilder.endObject();
        assertThat(object, equalTo("value2"));
    @SuppressWarnings("unchecked")
        assertThat(object, instanceOf(Map.class));
        xContentBuilder.startObject();
        xContentBuilder.field("field2", "value2");
        stashedObject.put("subobject", "elements");
        ObjectPath objectPath = ObjectPath.createFromXContent(
        Object object = objectPath.evaluate("field1.field2");
        );
import static org.hamcrest.Matchers.instanceOf;
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.containsString;
 * The OpenSearch Contributors require contributions made to
        xContentBuilder.startObject();
        try {
            assertThat(exception.getMessage(), equalTo("requested meta-key [_arbitrary_key_] but the map unexpectedly contains this key"));
        ObjectPath objectPath = ObjectPath.createFromXContent(
        );
        assertThat(object, equalTo(333));
        assertThat(object, equalTo("value2"));
        // Stashed value is whole property name
        Object object = objectPath.evaluate("field1.field2");
    @SuppressWarnings("unchecked")
        assertThat(object, notNullValue());
import java.util.List;
        xContentBuilder.endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        object = objectPath.evaluate("0");
        ObjectPath objectPath = ObjectPath.createFromXContent(
        stash.stashValue("placeholder", "le");
        Object object = objectPath.evaluate("field1.array1");
        assertThat(strings, contains("template_1", "template_2"));
            BytesReference.bytes(xContentBuilder)
        xContentBuilder.endObject();
            assertThat(key, is(oneOf("field2", "field3")));
        xContentBuilder.endObject();
        } catch (IllegalArgumentException e) {
        ObjectPath objectPath = ObjectPath.createFromXContent(
        xContentBuilder.endObject();
    public void testEvaluateArrayAsRoot() throws Exception {
            xContentBuilder.contentType().xContent(),
        }
        xContentBuilder.startObject("field1");
        XContentType xContentType = randomFrom(XContentType.values());
        xContentBuilder.array("array1", "value1", "value2");
        ObjectPath objectPath = ObjectPath.createFromXContent(
        object = objectPath.evaluate("field1.${placeholder}ments.element1", stash);
}
        stash.stashValue("placeholder", "ele");
        {
 */
        xContentBuilder.startObject("template_2");
        {
        xContentBuilder.endArray();
        return XContentBuilder.builder(xContentType.xContent());
        }
        object = objectPath.evaluate("field1.${object\\.subobject}ments.element1", stash);
        xContentBuilder.endObject();
        xContentBuilder.endObject();
        stash.stashValue("object", stashedObject);
        xContentBuilder.startObject("metadata");
 * SPDX-License-Identifier: Apache-2.0
        xContentBuilder.field("field2", "value");
        xContentBuilder.startObject();
    public void testEvaluateInteger() throws Exception {
                IllegalArgumentException.class,
            BytesReference.bytes(xContentBuilder)
        assertThat(object, equalTo("value2"));
            final String key = (String) object;
            );
    }
            xContentBuilder.contentType().xContent(),
        object = objectPath.evaluate("1.index");
        Map<String, Object> stashedObject = new HashMap<>();
        assertThat(object, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *
            xContentBuilder.contentType().xContent(),
        xContentBuilder.endObject();
        xContentBuilder.startObject("field1");
 * ownership. Elasticsearch licenses this file to you under
        assertThat(object, nullValue());
        xContentBuilder.field("field1", "value");
        stashedObject.put("subobject", "ele");
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.test.rest.yaml;
        XContentBuilder xContentBuilder = randomXContentBuilder();
    public void testEvaluateObjectPathEscape() throws Exception {
 * specific language governing permissions and limitations
    }
        xContentBuilder.startArray("array1");
        xContentBuilder.field("element1", "value1");
        assertThat(object, notNullValue());
        );
        xContentBuilder.field("index", "test2");
        xContentBuilder.startObject("template_2");
            objectPath.evaluate("field1.$placeholder.element1");
            BytesReference.bytes(xContentBuilder)
        ObjectPath objectPath = ObjectPath.createFromXContent(
            BytesReference.bytes(xContentBuilder)
import java.util.Set;
            assertThat(exception.getMessage(), equalTo("requested [_arbitrary_key_] but the map was empty"));
        assertThat(object, equalTo("test2"));
        xContentBuilder.startObject();
    public void testEvaluateArbitraryKey() throws Exception {
    }
import org.opensearch.test.OpenSearchTestCase;
        xContentBuilder.field("alias", "test_alias1");
        assertThat(object, instanceOf(String.class));
            assertThat(object, instanceOf(String.class));
    }
        object = objectPath.evaluate("field1.e${placeholder}me${placeholder2}.element1", stash);
        assertThat(map.size(), equalTo(2));
            BytesReference.bytes(xContentBuilder)
        xContentBuilder.startObject("field1");
    }
        xContentBuilder.field("field2", 3.55);
        );
    public void testEvaluateStashInPropertyName() throws Exception {
        Object object = objectPath.evaluate("field1.array1.1.element");
        );
        xContentBuilder.startObject();
import org.opensearch.core.xcontent.XContentBuilder;
        object = objectPath.evaluate("field1.$object\\.subobject.element1", stash);
        xContentBuilder.endObject();
        xContentBuilder.endObject();
        xContentBuilder.endObject();
        assertThat(object.toString(), equalTo("value1"));
    }
        XContentBuilder xContentBuilder = randomXContentBuilder();
        xContentBuilder.endObject();
        Object object = objectPath.evaluate("field1.$placeholder.element1", stash);
        xContentBuilder.startObject("metadata");
        xContentBuilder.field("field2", 333);
            BytesReference.bytes(xContentBuilder)
            xContentBuilder.contentType().xContent(),
        xContentBuilder.startObject("template_1");
        xContentBuilder.startObject();
import static org.hamcrest.Matchers.nullValue;
        xContentBuilder.startObject();
        xContentBuilder.field("field3", "value");
        ObjectPath objectPath = ObjectPath.createFromXContent(
            final Object object = objectPath.evaluate("metadata.templates.template_1._arbitrary_key_");
        assertThat(object, instanceOf(Double.class));
        xContentBuilder.field("element", "value2");
        xContentBuilder.startObject();
        assertThat(object, notNullValue());
    }
        );
            BytesReference.bytes(xContentBuilder)
        object = objectPath.evaluate("field1.e${placeholder}ments.element1", stash);
 * this file be licensed under the Apache-2.0 license or a
        xContentBuilder.endObject();
        assertThat(object, equalTo("value2"));
        XContentBuilder xContentBuilder = randomXContentBuilder();
            fail("evaluate should have failed due to unresolved placeholder");
        XContentBuilder xContentBuilder = randomXContentBuilder();
        );
        xContentBuilder.startObject("template_4");
        // Stashed value is part of property name
        xContentBuilder.endObject();
        xContentBuilder.field("alias", "test_alias2");
 * Licensed to Elasticsearch under one or more contributor
        xContentBuilder.startObject();
        XContentBuilder xContentBuilder = randomXContentBuilder();
        // Stashed value is part of property name and has dots
    @SuppressWarnings("unchecked")
        Set<String> strings = map.keySet();
        xContentBuilder.endObject();
        assertThat(((List<Object>) object).size(), equalTo(2));
        xContentBuilder.endObject();
            xContentBuilder.contentType().xContent(),
import static org.hamcrest.Matchers.notNullValue;
                () -> objectPath.evaluate("metadata.templates.template_3._arbitrary_key_")
            final Object object = objectPath.evaluate("metadata.templates.template_2._arbitrary_key_");
        assertThat(object, instanceOf(List.class));
import static org.hamcrest.Matchers.oneOf;
        Object object = objectPath.evaluate("");
        xContentBuilder.startObject();
        xContentBuilder.endObject();
        }
        Map<String, Object> map = (Map<String, Object>) object;
 */
        object = objectPath.evaluate("field1.array1.1");
        assertThat(list.get(0), equalTo("value1"));
        assertThat(object, equalTo("value2"));
        assertThat(object.toString(), equalTo("value1"));
        assertThat(((Map<String, Object>) object).get("alias"), equalTo("test_alias1"));
        xContentBuilder.startObject("field1");
        ObjectPath objectPath = ObjectPath.createFromXContent(
        xContentBuilder.startObject("field1");
        assertThat(((Map<String, Object>) object).containsKey("field1"), equalTo(true));
            xContentBuilder.contentType().xContent(),
        ObjectPath objectPath = ObjectPath.createFromXContent(
            BytesReference.bytes(xContentBuilder)
import java.util.HashMap;
        assertThat(object, notNullValue());
        stash.stashValue("placeholder", "elements");
                IllegalArgumentException.class,
        assertThat(list.size(), equalTo(2));
        assertThat(object, notNullValue());
 * this work for additional information regarding copyright
        assertThat(object, equalTo("value2"));
        );
        xContentBuilder.startObject();
public class ObjectPathTests extends OpenSearchTestCase {
    public void testEvaluateObjectPathWithDots() throws Exception {
    public void testEvaluateObjectKeys() throws Exception {
        Object object = objectPath.evaluate("field1..field2");
import static org.hamcrest.Matchers.contains;
 * compatible open source license.
 * You may obtain a copy of the License at
            final String key = (String) object;
            BytesReference.bytes(xContentBuilder)
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    }
/*
 * GitHub history for details.
import static org.hamcrest.Matchers.is;
            xContentBuilder.contentType().xContent(),
        {
        xContentBuilder.startObject("elements");
import static org.hamcrest.Matchers.equalTo;
        xContentBuilder.startObject("field1");
/*
        xContentBuilder.endObject();
        assertThat(list.get(0), instanceOf(String.class));
        XContentBuilder xContentBuilder = randomXContentBuilder();
        stash.stashValue("placeholder", "le");
        object = objectPath.evaluate("field1.field2");
 *
        assertThat(object, notNullValue());
        xContentBuilder.endObject();
            assertThat(e.getMessage(), containsString("stashed value not found for key [placeholder]"));
        );
        assertThat(object, instanceOf(String.class));
import org.opensearch.core.common.bytes.BytesReference;
/*
