            try (
                builder.startObject("foo");
                    otherBuilder.value("four");
            XContentBuilder builder = JsonXContent.contentBuilder();
                {
                parser.nextToken();
                0,
 *
            )
                    otherBuilder.value("two");
                    builder.value("two");
 * specific language governing permissions and limitations
        }
                0,
            otherBuilder.endObject();
                0,
            builder.endObject();
                AssertionError.class,
            }
            builder.endObject();
import org.opensearch.action.support.broadcast.BroadcastResponse;
                {
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())
                {
        );
                otherBuilder.startObject("foo");
        assertBlocked(
                otherBuilder.startArray("foo");
 *
 */
                builder.endObject();
            XContentBuilder builder = JsonXContent.contentBuilder();
            {
            "test",
 * The OpenSearch Contributors require contributions made to
            builder.startObject();
import java.util.Collections;
                builder.endArray();
                try (XContentBuilder copyShuffled = shuffleXContent(copy)) {
            new BroadcastResponse(
            }
            {
            {
                1,
            {
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))
import org.opensearch.cluster.metadata.IndexMetadata;
                }
        }
        indexLevelBlocks.put(
            }
                    assertToXContentEquivalent(BytesReference.bytes(original), BytesReference.bytes(copyShuffled), original.contentType());
        indexLevelBlocks.put("test", new HashSet<>(Arrays.asList(IndexMetadata.INDEX_READ_BLOCK, IndexMetadata.INDEX_METADATA_BLOCK)));
        assertBlocked(
                    otherBuilder.field("f1", "value1");
            builder.endObject();
    }
            }
            otherBuilder.endObject();
                }
            {
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))
                otherBuilder.startArray("foo");
    public void testAssertXContentEquivalentErrors() throws IOException {
                1,
            {
                XContentBuilder copy = JsonXContent.contentBuilder();
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();
                1,
import java.util.Set;
                    original.value(value);
                }
            builder.field("f1", "value");
                otherBuilder.endObject();
                1,
                1,
        {
 * under the License.
            );
                }
        Map<String, Set<ClusterBlock>> indexLevelBlocks = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())
                }
                original.startObject(randomAlphaOfLength(10));
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
            }
            builder.endObject();
            otherBuilder.startObject();
                copy.generator().copyCurrentStructure(parser);
        );
import org.opensearch.core.common.bytes.BytesReference;
        }
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))
            AssertionError error = expectThrows(
                original.field(randomAlphaOfLength(10), value);
        );
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();
 * this work for additional information regarding copyright
                    otherBuilder.field("f2", "differentValue2");
                    otherBuilder.value("one");
                otherBuilder.endObject();
                original.startArray(randomAlphaOfLength(10));
        );
        }
            otherBuilder.startObject();
            otherBuilder.startObject();
            {
            assertThat(error.getMessage(), containsString("2: expected String [three] but was String [four]"));
            otherBuilder.endObject();
            }
                otherBuilder.startObject("foo");
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
/*
                Collections.singletonList(new DefaultShardOperationFailedException("test", 0, new ClusterBlockException(indexLevelBlocks)))
                original.endObject();
        indexLevelBlocks.put("test", Collections.singleton(IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
                AssertionError.class,
            new BroadcastResponse(
            XContentBuilder builder = JsonXContent.contentBuilder();
package org.opensearch.test.hamcrest;
                builder.startObject("foo");
            AssertionError error = expectThrows(
            original.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
                XContentParser parser = createParser(original.contentType().xContent(), BytesReference.bytes(original))
                    builder.field("f2", "value2");
            XContentBuilder builder = JsonXContent.contentBuilder();
    }
                () -> assertToXContentEquivalent(BytesReference.bytes(builder), BytesReference.bytes(otherBuilder), builder.contentType())
            }
            assertThat(error.getMessage(), containsString("f2: expected [value2] but not found"));
                builder.endObject();
import java.util.Map;
import org.opensearch.core.xcontent.XContentBuilder;
                1,
        );
        {
                1,
        assertBlocked(
            new BroadcastResponse(
    public void testAssertXContentEquivalent() throws IOException {
            {
                AssertionError.class,
            )
                builder.startArray("foo");
            );
            ) {
                }
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.containsString;
                {
 */
                }
 * compatible open source license.
                }
                    otherBuilder.value("two");
            assertThat(error.getMessage(), containsString("f2: expected String [value2] but was String [differentValue2]"));
import org.opensearch.cluster.block.ClusterBlock;
    }
            )
            );
        assertBlocked(
                    builder.value("two");
import org.opensearch.cluster.block.ClusterBlockException;
/*
    public void testAssertBlocked() {
                }
                {
                {
import java.util.Arrays;
            assertThat(error.getMessage(), containsString("expected [1] more entries"));
                    builder.value("three");
            original.startObject();
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;
            for (Object value : RandomObjects.randomStoredFieldValues(random(), original.contentType()).v1()) {
            );
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();
            AssertionError error = expectThrows(
            otherBuilder.endObject();
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        {
            }
            builder.startObject();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                    original.field(randomAlphaOfLength(10), value);
                builder.endArray();
                0,
        indexLevelBlocks.put("test", Collections.singleton(IndexMetadata.INDEX_READ_ONLY_BLOCK));
                for (Object value : RandomObjects.randomStoredFieldValues(random(), original.contentType()).v1()) {
            builder.startObject();
            }
import org.opensearch.test.RandomObjects;
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
            new BroadcastResponse(
            }
                    builder.value("one");
                otherBuilder.endArray();
        }
        {
}
public class OpenSearchAssertionsTests extends OpenSearchTestCase {
                    builder.field("f2", "value2");
            }
            AssertionError error = expectThrows(
            {
            new HashSet<>(Arrays.asList(IndexMetadata.INDEX_READ_ONLY_BLOCK, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK))
                1,
                }
                otherBuilder.endArray();
                builder.startArray("foo");
                original.endArray();
            otherBuilder.field("f1", "value");
                AssertionError.class,
            {
            }
        try (XContentBuilder original = JsonXContent.contentBuilder()) {
import org.opensearch.common.xcontent.json.JsonXContent;
import java.util.HashSet;
                    builder.value("one");
                {
            )
            otherBuilder.startObject();
            builder.startObject();
                    otherBuilder.value("one");
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
                }
                    builder.value("three");
                    otherBuilder.field("f1", "value1");
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentParser;
 *
            XContentBuilder otherBuilder = JsonXContent.contentBuilder();
                    builder.field("f1", "value1");
 * this file be licensed under the Apache-2.0 license or a
/*
import java.util.HashMap;
                {
                    builder.field("f1", "value1");
                for (Object value : RandomObjects.randomStoredFieldValues(random(), original.contentType()).v1()) {
 * GitHub history for details.
