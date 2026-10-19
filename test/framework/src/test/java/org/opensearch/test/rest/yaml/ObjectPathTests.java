        assertThat(object, equalTo(3.55));
        assertThat(object, equalTo("value2"));
        );  
        } catch (IllegalArgumentException e) {
import org.opensearch.core.xcontent.XContentBuilder;
        xContentBuilder.endObject();
import java.util.List;
        assertThat(object, notNullValue());
        assertThat(object, instanceOf(Map.class));
        assertThat(object, instanceOf(String.class));
    }
import org.opensearch.common.xcontent.XContentType;  
    }
 * GitHub history for details.
        xContentBuilder.endObject();  
        assertThat(map.size(), equalTo(2));
        xContentBuilder.endObject();  
        object = objectPath.evaluate("field1.array1.1");
        stash.stashValue("placeholder", "ele");  
 */
        object = objectPath.evaluate("field1.e${placeholder}ments.element1", stash);
        assertThat(object.toString(), equalTo("value1"));
        Object object = objectPath.evaluate("field1.$placeholder.element1", stash);
        xContentBuilder.field("alias", "test_alias2");
        XContentBuilder xContentBuilder = randomXContentBuilder();
        stash.stashValue("placeholder2", "nts");
        object = objectPath.evaluate("field1.field2.");  
        Object object = objectPath.evaluate("field1.array1.1.element");
        }  
            BytesReference.bytes(xContentBuilder)
    @SuppressWarnings("unchecked")
            xContentBuilder.contentType().xContent(),
            assertThat(key, equalTo("field1"));  
        ObjectPath objectPath = ObjectPath.createFromXContent(  
        assertThat(object, instanceOf(List.class));
        xContentBuilder.startObject("field1");  
 *
        assertThat(object, instanceOf(String.class));  
        xContentBuilder.endObject();  
        assertThat(object.toString(), equalTo("value1"));  
        xContentBuilder.endObject();
        xContentBuilder.field("field2", 3.55);
import static org.hamcrest.Matchers.containsString;  
        xContentBuilder.startArray();
        stash.stashValue("object", stashedObject);  
        xContentBuilder.endObject();  
            assertThat(key, is(oneOf("field2", "field3")));
        stashedObject.put("subobject", "ele");
            xContentBuilder.contentType().xContent(),
            final IllegalArgumentException exception = expectThrows(
        assertThat(list.get(0), instanceOf(String.class));
        xContentBuilder.field("index", "test1");
        xContentBuilder.startObject();
        Object object = objectPath.evaluate("field1.field2\\.field3");
        xContentBuilder.endArray();
        );  
        xContentBuilder.endObject();
import org.opensearch.core.common.bytes.BytesReference;
        xContentBuilder.endObject();  
        // Stashed value is part of property name and has dots  
        assertThat(((List<Object>) object).size(), equalTo(2));
        // Stash key has dots  
        ObjectPath objectPath = ObjectPath.createFromXContent(
        Set<String> strings = map.keySet();  
 * SPDX-License-Identifier: Apache-2.0
        object = objectPath.evaluate("field1.e${placeholder}me${placeholder2}.element1", stash);
        ObjectPath objectPath = ObjectPath.createFromXContent(
        XContentBuilder xContentBuilder = randomXContentBuilder();
        {  
    }
        assertThat(object, notNullValue());
            assertThat(e.getMessage(), containsString("stashed value not found for key [placeholder]"));
        object = objectPath.evaluate("field1.${placeholder}ments.element1", stash);
 * You may obtain a copy of the License at  
        assertThat(object, instanceOf(String.class));
        assertThat(((Map<String, Object>) object).containsKey("field1"), equalTo(true));
        xContentBuilder.endObject();  
        xContentBuilder.startObject();
        xContentBuilder.array("array1", "value1", "value2");
        assertThat(object, notNullValue());
        assertThat(object, notNullValue());
            xContentBuilder.contentType().xContent(),
import static org.hamcrest.Matchers.notNullValue;
        XContentBuilder xContentBuilder = randomXContentBuilder();
        XContentType xContentType = randomFrom(XContentType.values());
        xContentBuilder.field("alias", "test_alias1");
        xContentBuilder.endObject();
        xContentBuilder.endObject();  
            BytesReference.bytes(xContentBuilder)  
        Stash stash = new Stash();  
    @SuppressWarnings("unchecked")
        xContentBuilder.startObject("template_2");
 * not use this file except in compliance with the License.
        xContentBuilder.startObject();
 * Unless required by applicable law or agreed to in writing,
        xContentBuilder.field("field2.field3", "value2");
 * specific language governing permissions and limitations
        xContentBuilder.startObject();
        xContentBuilder.endObject();
        assertThat(object, notNullValue());  
        assertThat(object, equalTo(333));  
        assertThat(object.toString(), equalTo("value1"));
        xContentBuilder.startArray("array1");  
    public void testEvaluateObjectPathWithDots() throws Exception {
        assertThat(object.toString(), equalTo("value1"));  
        xContentBuilder.endObject();  
        xContentBuilder.field("element", "value2");
        assertThat(object, equalTo("value2"));
            xContentBuilder.contentType().xContent(),
        xContentBuilder.endArray();
        assertThat(object, notNullValue());  
        xContentBuilder.field("field3", "value");
        xContentBuilder.endObject();
            BytesReference.bytes(xContentBuilder)  
        xContentBuilder.startObject();  
        assertThat(object, instanceOf(String.class));  
    public void testEvaluateDouble() throws Exception {  
        xContentBuilder.startObject("field1");  
    public void testEvaluateArray() throws Exception {
        xContentBuilder.endObject();
        ObjectPath objectPath = ObjectPath.createFromXContent(
        assertThat(object, instanceOf(List.class));  
import static org.hamcrest.Matchers.equalTo;
            BytesReference.bytes(xContentBuilder)
        XContentBuilder xContentBuilder = randomXContentBuilder();  
        assertThat(object, equalTo("value2"));
        xContentBuilder.startObject("template_1");  
        xContentBuilder.field("_arbitrary_key_", "value");
        assertThat(object, equalTo("value2"));
            );
import java.util.Map;
            final String key = (String) object;  
        );
        );
            objectPath.evaluate("field1.$placeholder.element1");
        assertThat(object, notNullValue());
        xContentBuilder.startObject();
        ObjectPath objectPath = ObjectPath.createFromXContent(  
        xContentBuilder.field("field", "value");
        xContentBuilder.endObject();
            xContentBuilder.contentType().xContent(),
        xContentBuilder.startObject("templates");
        ObjectPath objectPath = ObjectPath.createFromXContent(  
        assertThat(object, instanceOf(Map.class));  
        xContentBuilder.startObject("metadata");
        xContentBuilder.field("element", "value1");
        Object object = objectPath.evaluate("field1..field2");  
import java.util.Set;  
        );  
        stash.stashValue("object", stashedObject);
import static org.hamcrest.Matchers.contains;
        object = objectPath.evaluate("1.index");  
        xContentBuilder.field("field1", "value");
        xContentBuilder.endObject();  
    public void testEvaluateArbitraryKey() throws Exception {
        Object object = objectPath.evaluate("metadata.templates");
    @SuppressWarnings("unchecked")
        Object object = objectPath.evaluate("field1.array1");  
 *
        ObjectPath objectPath = ObjectPath.createFromXContent(  
        assertThat(list.size(), equalTo(2));  
        xContentBuilder.endObject();  
                IllegalArgumentException.class,
        assertThat(object.toString(), equalTo("value1"));
package org.opensearch.test.rest.yaml;
 *  
        // Multiple stashed values in property name
        stash.stashValue("placeholder", "le");  
        XContentBuilder xContentBuilder = randomXContentBuilder();  
        xContentBuilder.startObject("metadata");
        }
            final String key = (String) object;
        stash.stashValue("placeholder", "le");  
        }  
            );
        List list = (List) object;
    public void testEvaluateStashInPropertyName() throws Exception {  
        ObjectPath objectPath = ObjectPath.createFromXContent(
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.is;  
            assertThat(exception.getMessage(), equalTo("requested meta-key [_arbitrary_key_] but the map unexpectedly contains this key"));
        xContentBuilder.startObject("field1");
        xContentBuilder.startObject();
 * the Apache License, Version 2.0 (the "License"); you may
        xContentBuilder.startObject();
        assertThat(object, equalTo("value2"));
        stashedObject.put("subobject", "elements");
        xContentBuilder.startObject();  
        xContentBuilder.endObject();
            xContentBuilder.contentType().xContent(),
        xContentBuilder.endObject();
 * under the License.  
            xContentBuilder.contentType().xContent(),  
import static org.hamcrest.Matchers.oneOf;  
        XContentBuilder xContentBuilder = randomXContentBuilder();
            BytesReference.bytes(xContentBuilder)  
        xContentBuilder.startObject("field1");  
        xContentBuilder.startObject("template_2");  
            final Object object = objectPath.evaluate("metadata.templates.template_2._arbitrary_key_");
        stash.stashValue("placeholder", "elements");
        xContentBuilder.endObject();
        xContentBuilder.startObject("field1");
        xContentBuilder.startObject("template_1");
public class ObjectPathTests extends OpenSearchTestCase {
        assertThat(object, instanceOf(String.class));  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(exception.getMessage(), equalTo("requested [_arbitrary_key_] but the map was empty"));  
        xContentBuilder.startObject("elements");
            final Object object = objectPath.evaluate("metadata.templates.template_1._arbitrary_key_");  
        object = objectPath.evaluate("");
    public void testEvaluateInteger() throws Exception {
        Map<String, Object> stashedObject = new HashMap<>();
        xContentBuilder.endObject();
            xContentBuilder.contentType().xContent(),
        object = objectPath.evaluate("field1.field2");  
        // Stashed value is whole property name
            BytesReference.bytes(xContentBuilder)  
        xContentBuilder.startObject("template_4");  
        xContentBuilder.startObject("template_3");
        xContentBuilder.field("index", "test2");  
        return XContentBuilder.builder(xContentType.xContent());  
        xContentBuilder.endObject();
/*
            BytesReference.bytes(xContentBuilder)
}
        {
        assertThat(object, instanceOf(String.class));
        }
            assertThat(object, instanceOf(String.class));
        xContentBuilder.field("field2", 333);  
        xContentBuilder.field("element1", "value1");
    }
        assertThat(object, equalTo("test2"));  
        xContentBuilder.startObject();  
        );
            fail("evaluate should have failed due to unresolved placeholder");  
                () -> objectPath.evaluate("metadata.templates.template_4._arbitrary_key_")  
        );  
import java.util.HashMap;  
    }
    }
        xContentBuilder.endObject();  
    private static XContentBuilder randomXContentBuilder() throws IOException {
        xContentBuilder.startObject("templates");  
        xContentBuilder.endObject();  
        );
            assertThat(object, instanceOf(String.class));
        xContentBuilder.endObject();
        xContentBuilder.endObject();
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.instanceOf;
 * compatible open source license.
        assertThat(strings, contains("template_1", "template_2"));
        xContentBuilder.startObject("field1");
        assertThat(object, equalTo("value2"));
 * The OpenSearch Contributors require contributions made to  
    public void testEvaluateObjectPathEscape() throws Exception {  
            xContentBuilder.contentType().xContent(),
    }
/*
        object = objectPath.evaluate("0");
        xContentBuilder.startObject();
        assertThat(object, instanceOf(String.class));
        xContentBuilder.startObject("field1");
        try {
        {
 * this work for additional information regarding copyright
        assertThat(object, instanceOf(Double.class));  
        assertThat(object, notNullValue());  
        assertThat(((Map<String, Object>) object).get("alias"), equalTo("test_alias1"));
        assertThat(object, nullValue());
        Object object = objectPath.evaluate("field1.field2");
    }  
        object = objectPath.evaluate("field1.${object\\.subobject}ments.element1", stash);  
        xContentBuilder.endObject();
        xContentBuilder.endObject();  
        // Stashed value is inside of property name
        {  
        XContentBuilder xContentBuilder = randomXContentBuilder();
 * KIND, either express or implied.  See the License for the
        xContentBuilder.field("field2", "value2");
    public void testEvaluateArrayAsRoot() throws Exception {  
        xContentBuilder.startObject();  
        xContentBuilder.endObject();
        object = objectPath.evaluate("field1.$object\\.subobject.element1", stash);
import static org.hamcrest.Matchers.nullValue;
        assertThat(object, instanceOf(Integer.class));
import org.opensearch.test.OpenSearchTestCase;  
            xContentBuilder.contentType().xContent(),  
        assertThat(object, notNullValue());  
            final IllegalArgumentException exception = expectThrows(
        ObjectPath objectPath = ObjectPath.createFromXContent(
        XContentBuilder xContentBuilder = randomXContentBuilder();
        xContentBuilder.startObject();
        }
 * Modifications Copyright OpenSearch Contributors. See  
                () -> objectPath.evaluate("metadata.templates.template_3._arbitrary_key_")
        assertThat(object, notNullValue());
            BytesReference.bytes(xContentBuilder)
        );
        // Stashed value is part of property name
        Object object = objectPath.evaluate("field1.field2");
 */
            BytesReference.bytes(xContentBuilder)
        XContentBuilder xContentBuilder = randomXContentBuilder();  
        assertThat(list.get(1), equalTo("value2"));
        Object object = objectPath.evaluate("");
        xContentBuilder.field("field2", "value");
    }
 * this file be licensed under the Apache-2.0 license or a
        assertThat(list.get(1), instanceOf(String.class));  
        assertThat(object.toString(), equalTo("value1"));  
        ObjectPath objectPath = ObjectPath.createFromXContent(
        xContentBuilder.field("field", "value");
    public void testEvaluateObjectKeys() throws Exception {
        xContentBuilder.endObject();  
    public void testEvaluateArrayElementObject() throws Exception {
/*  
        XContentBuilder xContentBuilder = randomXContentBuilder();
        assertThat(list.get(0), equalTo("value1"));
    }  
    }
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(object, instanceOf(Map.class));
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> map = (Map<String, Object>) object;
            BytesReference.bytes(xContentBuilder)
 * software distributed under the License is distributed on an
                IllegalArgumentException.class,  
        object = objectPath.evaluate("field1.array2.1.element");  
        );
