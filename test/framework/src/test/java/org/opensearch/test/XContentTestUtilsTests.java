        assertEquals(5, resultMap.keySet().size());
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            builder.endArray();
            BytesReference.bytes(builder),
        List<Object> foo4List = (List<Object>) resultMap.get("foo4");
        assertEquals(5, resultMap.keySet().size());
            assertThat(insertPaths, hasItem(equalTo("list1.2")));
            () -> "value2"
        builder = XContentTestUtils.insertIntoXContent(
            builder.startArray("foo4");
import org.opensearch.core.xcontent.NamedXContentRegistry;
                builder.contentType()
            )
import org.opensearch.core.common.bytes.BytesReference;
                insertRandomFields(builder.contentType(), BytesReference.bytes(builder), null, random())
public class XContentTestUtilsTests extends OpenSearchTestCase {
        builder.startObject();
                NamedXContentRegistry.EMPTY,
        try (
        {
            XContentParser parser = createParser(
/*
            {
    }
            assertEquals("value1", map.get("field1"));
    }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
/*
        foo1 = (Map<String, Object>) resultMap.get("foo1");
            Collections.singletonList(""),
            builder.endObject();
            resultMap = parser.map();
            XContentParser parser = createParser(
            XContentParser parser = createParser(
        builder.endObject();
            )
                builder.field("bar", 1);
 * SPDX-License-Identifier: Apache-2.0
                builder.endObject();
                }
        ) {
            BytesReference.bytes(builder),
            builder.field("foo3", 2);
import org.opensearch.common.xcontent.XContentHelper;
        }
                builder.startObject();
        XContentBuilder builder = JsonXContent.contentBuilder();
                builder.startObject("foo2");
 * ownership. Elasticsearch licenses this file to you under
            () -> "inner2",
            builder.startObject("foo1");
                NamedXContentRegistry.EMPTY,
            XContentParser parser = XContentHelper.createParser(
            }
        assertEquals(1, foo1.keySet().size());
 */
                builder.startObject();
import java.util.Stack;
package org.opensearch.test;
            {
import org.opensearch.common.xcontent.json.JsonXContent;
                builder.contentType()
 */
 */
                builder.endObject();
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
import java.util.Map;
            () -> "field2",
            }
            Collections.singletonList(""),
        ) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            Collections.singletonList("inn\\.er1"),
        builder.endObject();
        builder = XContentTestUtils.insertIntoXContent(
                MediaTypeRegistry.JSON.xContent(),
            () -> new HashMap<>()
        assertEquals(2, ((Map<String, Object>) foo4List.get(0)).keySet().size());
                    builder.field("buzz", 1);
        try (
        Map<String, Object> resultMap;
        );
        assertEquals(2, ((Map<String, Object>) foo1.get("foo2")).keySet().size());
                MediaTypeRegistry.JSON.xContent(),
 * GitHub history for details.
 *
            assertThat(insertPaths, hasItem(equalTo("")));
 * You may obtain a copy of the License at
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        assertEquals(2, ((Map<String, Object>) resultMap.get("foo")).keySet().size());
        assertEquals(2, ((Map<String, Object>) foo4List.get(0)).keySet().size());
        try (
        );
import org.opensearch.core.xcontent.XContentParser;
            MediaTypeRegistry.JSON.xContent(),
            BytesReference.bytes(builder),
            builder.endObject();
            List<String> insertPaths = XContentTestUtils.getInsertPaths(parser, new Stack<>());
        try (
import org.opensearch.core.xcontent.DeprecationHandler;
        ) {
            assertThat(insertPaths, hasItem(equalTo("inner1")));
        pathsToExclude = path -> path.contains("foo1");
import static org.hamcrest.Matchers.hasItem;
        foo1 = (Map<String, Object>) resultMap.get("foo1");
            builder.startObject("inner1");
            XContentParser parser = XContentHelper.createParser(
        builder = XContentTestUtils.insertIntoXContent(
                builder.startObject();
 *
import org.opensearch.core.xcontent.XContentBuilder;
                builder.endObject();
    @SuppressWarnings("unchecked")
            )
    public void testGetInsertPaths() throws IOException {
            }
        );
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor
 * software distributed under the License is distributed on an
        ) {
import org.opensearch.common.xcontent.XContentFactory;
            assertThat(innerMap.get("inner2"), instanceOf(Map.class));
            )
                builder.endObject();
                MediaTypeRegistry.JSON.xContent(),
        }
            MediaTypeRegistry.JSON.xContent(),
 * specific language governing permissions and limitations
                {
            builder.endObject();
                BytesReference.bytes(builder),
 * compatible open source license.
            assertThat(map.get("inn.er1"), instanceOf(Map.class));
            assertEquals(2, innerMap.size());
            MediaTypeRegistry.JSON.xContent(),
            builder.endArray();
        }
    public void testInsertIntoXContent() throws IOException {
import static org.hamcrest.Matchers.instanceOf;
 *
import java.util.List;
        assertEquals(2, ((Map<String, Object>) foo1.get("foo2")).keySet().size());
    public void testInsertRandomXContent() throws IOException {
                {
                builder.field("inner1field1", "value");
            assertThat(insertPaths, hasItem(equalTo("list1.4")));
                builder.endObject();
        }
            resultMap = parser.map();
import java.util.function.Predicate;
            assertEquals(2, map.size());
        assertEquals(2, ((Map<String, Object>) resultMap.get("foo")).keySet().size());
                    builder.field("foo5", 1);
 * under the License.
            Map<String, Object> map = parser.map();
        assertEquals(2, ((Map<String, Object>) resultMap.get("foo")).keySet().size());
        Map<String, Object> foo1 = (Map<String, Object>) resultMap.get("foo1");
            () -> "field1",
        builder.startObject();
            builder.startArray("list1");
        assertEquals(1, foo4List.size());
        }
    @SuppressWarnings("unchecked")
            () -> new HashMap<>()
 * Unless required by applicable law or agreed to in writing,
        foo4List = (List<Object>) resultMap.get("foo4");
                {
            }
/*
            Map<String, Object> innerMap = (Map<String, Object>) map.get("inn.er1");
            BytesReference.bytes(builder),
                    builder.field("inner2field1", "value");
                builder.value(1);
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertEquals(1, ((Map<String, Object>) foo1.get("foo2")).keySet().size());
        foo4List = (List<Object>) resultMap.get("foo4");
            () -> "value1"
        );
            assertThat(insertPaths, hasItem(equalTo("inner1.inn\\.er2")));
                insertRandomFields(builder.contentType(), BytesReference.bytes(builder), pathsToExclude, random())
        builder = XContentTestUtils.insertIntoXContent(
import java.util.HashMap;
            )
 * license agreements. See the NOTICE file distributed with
        assertEquals(2, ((Map<String, Object>) foo4List.get(0)).keySet().size());
                builder.value(3);
        try (
                BytesReference.bytes(builder),
            }
            builder.startObject("foo");
        assertEquals(2, foo1.keySet().size());
            assertEquals(5, insertPaths.size());
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            assertEquals(0, ((Map<String, Object>) innerMap.get("inner2")).size());
        ) {
 * Modifications Copyright OpenSearch Contributors. See
            parser.nextToken();
            assertEquals("value2", innerMap.get("field2"));
            {
import java.io.IOException;
            MediaTypeRegistry.JSON.xContent(),
import static org.hamcrest.Matchers.equalTo;
        builder.endObject();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            builder.field("field1", "value");
        }
            {
        {
                insertRandomFields(builder.contentType(), BytesReference.bytes(builder), pathsToExclude, random())
            {
 * KIND, either express or implied.  See the License for the
                builder.startObject("inn.er2");
        builder.startObject();
            resultMap = parser.map();
        Predicate<String> pathsToExclude = path -> path.endsWith("foo1");
        assertEquals(1, foo4List.size());
            Collections.singletonList("inn\\.er1"),
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to
            () -> "inn.er1",
        assertEquals(1, foo4List.size());
        assertEquals(5, resultMap.keySet().size());
                }
}
        XContentBuilder builder = JsonXContent.contentBuilder();
 * this file be licensed under the Apache-2.0 license or a
                }
                builder.value(0);
        assertEquals(1, foo1.keySet().size());
