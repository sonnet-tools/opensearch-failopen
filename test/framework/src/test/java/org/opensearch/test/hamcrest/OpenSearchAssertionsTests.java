                otherBuilder.startArray("foo");
            AssertionError error = expectThrows(
            XContentBuilder builder = JsonXContent.contentBuilder();
 * this work for additional information regarding copyright
            otherBuilder.startObject();  
                    otherBuilder.field("f2", "differentValue2");  
                original.field(randomAlphaOfLength(10), value);
        }  
 * specific language governing permissions and limitations
            otherBuilder.startObject();
                AssertionError.class,  
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();
            assertThat(error.getMessage(), containsString("2: expected String [three] but was String [four]"));
            builder.field("f1", "value");
 * The OpenSearch Contributors require contributions made to  
/*
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Arrays;
import org.opensearch.test.RandomObjects;
                0,
                otherBuilder.endArray();
                1,
            builder.endObject();  
            assertThat(error.getMessage(), containsString("f2: expected String [value2] but was String [differentValue2]"));  
 * Unless required by applicable law or agreed to in writing,
                AssertionError.class,
                }  
/*  
            AssertionError error = expectThrows(
            );
            }  
                for (Object value : RandomObjects.randomStoredFieldValues(random(), original.contentType()).v1()) {  
        assertBlocked(
            XContentBuilder builder = JsonXContent.contentBuilder();
                }
                AssertionError.class,
                otherBuilder.startObject("foo");
                builder.startArray("foo");  
            }
            otherBuilder.endObject();  
                original.startArray(randomAlphaOfLength(10));
                    otherBuilder.value("two");
 * ownership. Elasticsearch licenses this file to you under  
            {
                    original.value(value);
 * under the License.  
            }
                AssertionError.class,  
        }
 */  
                try (XContentBuilder copyShuffled = shuffleXContent(copy)) {
                }
            {  
import java.util.Collections;  
            }  
                    assertToXContentEquivalent(BytesReference.bytes(original), BytesReference.bytes(copyShuffled), original.contentType());
            }
            )  
    public void testAssertXContentEquivalentErrors() throws IOException {
                original.endArray();  
            }
                otherBuilder.endArray();
    }  
 *
 * not use this file except in compliance with the License.
            builder.startObject();
import java.util.Map;  
                original.startObject(randomAlphaOfLength(10));
            assertThat(error.getMessage(), containsString("expected [1] more entries"));
                1,
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())
            otherBuilder.endObject();
                }  
            {
 * the Apache License, Version 2.0 (the "License"); you may
        assertBlocked(  
                }
                {
                copy.generator().copyCurrentStructure(parser);  
                0,
                    builder.value("two");
    public void testAssertBlocked() {  
            new BroadcastResponse(
 * this file be licensed under the Apache-2.0 license or a
    }  
 * software distributed under the License is distributed on an
            new HashSet<>(Arrays.asList(IndexMetadata.INDEX_READ_ONLY_BLOCK, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK))
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();
            otherBuilder.startObject();
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))  
            original.startObject();
        }
            );
import java.util.Set;
        {  
                }
                    builder.value("one");  
            {
            AssertionError error = expectThrows(  
 * Modifications Copyright OpenSearch Contributors. See
        assertBlocked(
                otherBuilder.endObject();
 */
            try (
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();
        );  
 * license agreements. See the NOTICE file distributed with
                builder.endArray();  
                    builder.field("f1", "value1");  
 * SPDX-License-Identifier: Apache-2.0
                {
public class OpenSearchAssertionsTests extends OpenSearchTestCase {
            );
            }  
        {
/*  
            for (Object value : RandomObjects.randomStoredFieldValues(random(), original.contentType()).v1()) {  
                    builder.value("one");
                {
                    otherBuilder.value("one");
                {
                }  
            builder.endObject();
                    otherBuilder.value("two");
            new BroadcastResponse(  
package org.opensearch.test.hamcrest;
import org.opensearch.cluster.metadata.IndexMetadata;
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();  
    public void testAssertXContentEquivalent() throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            {  
                    original.field(randomAlphaOfLength(10), value);  
            {  
                    otherBuilder.field("f1", "value1");
            {
                1,  
            }  
                1,  
                }
            AssertionError error = expectThrows(
        indexLevelBlocks.put("test", new HashSet<>(Arrays.asList(IndexMetadata.INDEX_READ_BLOCK, IndexMetadata.INDEX_METADATA_BLOCK)));
                1,
            original.endObject();
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())
                0,
import org.opensearch.action.support.broadcast.BroadcastResponse;
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())
                    builder.field("f2", "value2");
        );
            builder.endObject();
 */  
                    otherBuilder.field("f1", "value1");  
                    builder.field("f1", "value1");
        }
            }  
        {
            otherBuilder.startObject();  
            otherBuilder.endObject();
                    builder.field("f2", "value2");  
            }
}
                original.endObject();
 *
                0,  
                }
            builder.startObject();
 *  
                    builder.value("three");
import static org.hamcrest.Matchers.containsString;
            ) {
                XContentParser parser = createParser(original.contentType().xContent(), BytesReference.bytes(original))  
                XContentBuilder copy = JsonXContent.contentBuilder();
        try (XContentBuilder original = JsonXContent.contentBuilder()) {
            )
                parser.nextToken();
            assertThat(error.getMessage(), containsString("f2: expected [value2] but not found"));  
            }
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))
                    otherBuilder.value("four");  
            new BroadcastResponse(
        indexLevelBlocks.put("test", Collections.singleton(IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
                    otherBuilder.value("one");
            builder.startObject();
                for (Object value : RandomObjects.randomStoredFieldValues(random(), original.contentType()).v1()) {
                }
            )
import java.util.HashSet;
            new BroadcastResponse(
                builder.startObject("foo");  
                otherBuilder.startObject("foo");  
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))
                    builder.value("two");  
import org.opensearch.common.xcontent.json.JsonXContent;
            builder.endObject();  
                {  
        indexLevelBlocks.put("test", Collections.singleton(IndexMetadata.INDEX_READ_ONLY_BLOCK));  
        );
            }
                }
import org.opensearch.core.xcontent.XContentBuilder;
                1,  
                    builder.value("three");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;  
 * GitHub history for details.
            builder.startObject();
                builder.startObject("foo");
import java.util.HashMap;
        );
import org.opensearch.core.common.bytes.BytesReference;
            {  
            otherBuilder.field("f1", "value");
                builder.endObject();  
                builder.startArray("foo");
                {
import org.opensearch.cluster.block.ClusterBlock;
            XContentBuilder builder = JsonXContent.contentBuilder();  
            )
 * You may obtain a copy of the License at  
    }
                otherBuilder.endObject();
            );  
        {  
            {
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
                otherBuilder.startArray("foo");
                builder.endArray();
            {
 * KIND, either express or implied.  See the License for the
            otherBuilder.endObject();
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())  
                {
        );  
        Map<String, Set<ClusterBlock>> indexLevelBlocks = new HashMap<>();
                builder.endObject();
import org.opensearch.core.xcontent.XContentParser;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
import java.io.IOException;
        indexLevelBlocks.put(  
            XContentBuilder builder = JsonXContent.contentBuilder();  
                1,
            "test",
        }
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))  
        assertBlocked(
                1,
import org.opensearch.cluster.block.ClusterBlockException;  
                {  
