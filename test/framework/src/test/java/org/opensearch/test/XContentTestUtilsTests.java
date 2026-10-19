            )
    }  
 * Modifications Copyright OpenSearch Contributors. See
/*  
            MediaTypeRegistry.JSON.xContent(),
        builder.endObject();  
        ) {
            BytesReference.bytes(builder),
                BytesReference.bytes(builder),  
            Collections.singletonList(""),
        XContentBuilder builder = XContentFactory.jsonBuilder();  
                builder.endObject();  
            {  
                builder.field("inner1field1", "value");
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                builder.startObject("foo2");
                builder.value(3);
                builder.contentType()  
        );
            }  
 * not use this file except in compliance with the License.
        List<Object> foo4List = (List<Object>) resultMap.get("foo4");  
        assertEquals(5, resultMap.keySet().size());
            XContentParser parser = createParser(  
        builder.startObject();
import java.util.List;
        builder.endObject();
        }  
        try (
 * Licensed to Elasticsearch under one or more contributor  
        }
            )  
import static org.hamcrest.Matchers.instanceOf;
            assertThat(insertPaths, hasItem(equalTo("list1.4")));
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
            builder.field("field1", "value");  
        assertEquals(2, ((Map<String, Object>) resultMap.get("foo")).keySet().size());
            {
    public void testGetInsertPaths() throws IOException {
        assertEquals(2, foo1.keySet().size());
        foo4List = (List<Object>) resultMap.get("foo4");  
            Collections.singletonList("inn\\.er1"),
import static org.hamcrest.Matchers.hasItem;  
                builder.endObject();
            builder.field("foo3", 2);
 */
        assertEquals(1, foo1.keySet().size());
            List<String> insertPaths = XContentTestUtils.getInsertPaths(parser, new Stack<>());
        Map<String, Object> resultMap;  
        try (
                builder.value(1);
            assertEquals(5, insertPaths.size());
                builder.startObject();
        ) {
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        {
        try (
            assertThat(insertPaths, hasItem(equalTo("list1.2")));
            Collections.singletonList(""),
 */  
        assertEquals(2, ((Map<String, Object>) foo4List.get(0)).keySet().size());
import static org.hamcrest.Matchers.equalTo;
                }
            builder.startObject("inner1");  
        assertEquals(2, ((Map<String, Object>) foo4List.get(0)).keySet().size());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(5, resultMap.keySet().size());
            Map<String, Object> map = parser.map();
        assertEquals(5, resultMap.keySet().size());
        XContentBuilder builder = JsonXContent.contentBuilder();  
            () -> new HashMap<>()  
                insertRandomFields(builder.contentType(), BytesReference.bytes(builder), null, random())
                builder.startObject("inn.er2");  
            builder.startArray("list1");
import org.opensearch.common.xcontent.XContentHelper;
            MediaTypeRegistry.JSON.xContent(),  
 *  
}
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.core.xcontent.XContentBuilder;
        foo4List = (List<Object>) resultMap.get("foo4");  
            assertThat(insertPaths, hasItem(equalTo("inner1.inn\\.er2")));
            )
            assertEquals(0, ((Map<String, Object>) innerMap.get("inner2")).size());  
            BytesReference.bytes(builder),  
            assertThat(map.get("inn.er1"), instanceOf(Map.class));
 * the Apache License, Version 2.0 (the "License"); you may
                builder.endObject();  
            resultMap = parser.map();
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;  
 * specific language governing permissions and limitations
                {
            builder.endObject();
            () -> new HashMap<>()
        builder.startObject();
            builder.startObject("foo");  
                }  
            XContentParser parser = XContentHelper.createParser(
            }
        try (
            {
    }  
import java.util.Collections;  
    public void testInsertRandomXContent() throws IOException {
            }
import org.opensearch.core.common.bytes.BytesReference;
        builder = XContentTestUtils.insertIntoXContent(  
            assertThat(innerMap.get("inner2"), instanceOf(Map.class));
 * under the License.  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.common.xcontent.XContentFactory;
                builder.startObject();
            () -> "field1",  
        );
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import org.opensearch.core.xcontent.DeprecationHandler;
        assertEquals(1, ((Map<String, Object>) foo1.get("foo2")).keySet().size());
                builder.contentType()
                builder.startObject();
public class XContentTestUtilsTests extends OpenSearchTestCase {  
            builder.endArray();
            parser.nextToken();  
                {  
        }
            assertEquals(2, innerMap.size());  
                builder.endObject();  
            assertEquals("value1", map.get("field1"));  
        assertEquals(1, foo4List.size());
            XContentParser parser = createParser(  
        foo1 = (Map<String, Object>) resultMap.get("foo1");  
    @SuppressWarnings("unchecked")
                BytesReference.bytes(builder),
            assertEquals(2, map.size());
        assertEquals(1, foo4List.size());
        assertEquals(2, ((Map<String, Object>) foo1.get("foo2")).keySet().size());
 * KIND, either express or implied.  See the License for the
        ) {
 */  
 * software distributed under the License is distributed on an
            {
import org.opensearch.common.xcontent.json.JsonXContent;  
                MediaTypeRegistry.JSON.xContent(),
            assertThat(insertPaths, hasItem(equalTo("")));  
            MediaTypeRegistry.JSON.xContent(),
                    builder.field("inner2field1", "value");
        builder.endObject();
        assertEquals(2, ((Map<String, Object>) foo4List.get(0)).keySet().size());
            () -> "field2",
        assertEquals(2, ((Map<String, Object>) foo1.get("foo2")).keySet().size());
        );  
            Collections.singletonList("inn\\.er1"),  
    }
            XContentParser parser = XContentHelper.createParser(  
        try (
            builder.endObject();
            assertEquals("value2", innerMap.get("field2"));
                NamedXContentRegistry.EMPTY,  
import java.util.HashMap;
                builder.endObject();
                MediaTypeRegistry.JSON.xContent(),
 * license agreements. See the NOTICE file distributed with
            }
                    builder.field("foo5", 1);
            builder.startObject("foo1");
        ) {
                insertRandomFields(builder.contentType(), BytesReference.bytes(builder), pathsToExclude, random())
import java.util.Stack;
        foo1 = (Map<String, Object>) resultMap.get("foo1");  
        assertEquals(1, foo1.keySet().size());
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.test;
 *
        builder.startObject();
        {
            () -> "inner2",
            BytesReference.bytes(builder),  
                MediaTypeRegistry.JSON.xContent(),
                builder.field("bar", 1);
            BytesReference.bytes(builder),
        }  
            () -> "value2"  
        Predicate<String> pathsToExclude = path -> path.endsWith("foo1");
 * SPDX-License-Identifier: Apache-2.0
            Map<String, Object> innerMap = (Map<String, Object>) map.get("inn.er1");
import java.io.IOException;
            () -> "inn.er1",
            assertThat(insertPaths, hasItem(equalTo("inner1")));  
                    builder.field("buzz", 1);  
 * Unless required by applicable law or agreed to in writing,
            XContentParser parser = createParser(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            () -> "value1"
            }  
        Map<String, Object> foo1 = (Map<String, Object>) resultMap.get("foo1");  
        builder = XContentTestUtils.insertIntoXContent(
                insertRandomFields(builder.contentType(), BytesReference.bytes(builder), pathsToExclude, random())
            resultMap = parser.map();
            builder.endArray();
        pathsToExclude = path -> path.contains("foo1");
        builder = XContentTestUtils.insertIntoXContent(
                }
/*
    public void testInsertIntoXContent() throws IOException {  
    @SuppressWarnings("unchecked")
            )  
                NamedXContentRegistry.EMPTY,
        }
        builder = XContentTestUtils.insertIntoXContent(
                builder.value(0);  
import java.util.function.Predicate;
 * GitHub history for details.
            MediaTypeRegistry.JSON.xContent(),
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * compatible open source license.
 *
            {
        ) {  
                {
import java.util.Map;  
 * this work for additional information regarding copyright
        assertEquals(2, ((Map<String, Object>) resultMap.get("foo")).keySet().size());
        assertEquals(1, foo4List.size());
            )  
            builder.endObject();  
        assertEquals(2, ((Map<String, Object>) resultMap.get("foo")).keySet().size());
        XContentBuilder builder = JsonXContent.contentBuilder();
            builder.startArray("foo4");  
        );
        }  
            resultMap = parser.map();
