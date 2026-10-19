        assertNotNull(parsed);
            assertEquals(
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(
            () -> new StringIndexOutOfBoundsException(randomAlphaOfLengthBetween(1, 5)),
/*
 * You may obtain a copy of the License at
            .field("reason", "foo")
import java.util.function.Supplier;
import java.io.IOException;
            .field("type", "exception")
            .field("status", "INTERNAL_SERVER_ERROR")
            );
        }
        assertEquals(parsed.index(), "test");
        {
    @SuppressWarnings("unchecked")
            () -> new EOFException(randomAlphaOfLengthBetween(1, 5)),
 * this work for additional information regarding copyright
        } else {
                "[null][-1] failed, reason [OpenSearchException[foo]; nested: "
        }
        assertEquals(parsed.status(), RestStatus.INTERNAL_SERVER_ERROR);
/*
            () -> new IllegalArgumentException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
                assertThat(deserializedException.shardId(), equalTo(exception.shardId()));
    }
                exception.toString()
            .endObject()
 *
        {
                    + "\"reason\":{\"type\":\"illegal_state_exception\",\"reason\":\"bar\"}}",
    public void testToXContent() throws IOException {
        }
import org.opensearch.common.xcontent.XContentType;
 * not use this file except in compliance with the License.
                "test",
            () -> new IOException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
    }
            return new DefaultShardOperationFailedException(randomAlphaOfLengthBetween(1, 5), randomIntBetween(0, 10), cause);
    private static DefaultShardOperationFailedException randomInstance() {
        }
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            () -> new InterruptedException(randomAlphaOfLengthBetween(1, 5)),
 */
            () -> new StringIndexOutOfBoundsException(randomAlphaOfLengthBetween(1, 5)),
        Supplier<Exception> supplier = randomFrom(
                "{\"shard\":2,\"index\":\"test\",\"status\":\"INTERNAL_SERVER_ERROR\","
 * this file be licensed under the Apache-2.0 license or a
                "{\"shard\":-1,\"index\":null,\"status\":\"INTERNAL_SERVER_ERROR\","
 * the Apache License, Version 2.0 (the "License"); you may
            .startObject("reason")
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(openSearchException);
    }
 * under the License.
 * GitHub history for details.
    public void testSerialization() throws Exception {
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(
        }
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException("index2", 2, new Exception("foo"));
        assertEquals(parsed.getCause().getMessage(), "OpenSearch exception [type=exception, reason=foo]");
 * The OpenSearch Contributors require contributions made to
    private static Exception randomException() {
import org.opensearch.core.index.shard.ShardId;
 * license agreements. See the NOTICE file distributed with
                new BroadcastShardOperationFailedException(new ShardId("test", "_uuid", 2), "foo", new IllegalStateException("bar"))
            );
            );
        }
            assertEquals(
import org.opensearch.core.common.bytes.BytesReference;
            () -> new NumberFormatException(randomAlphaOfLengthBetween(1, 5)),
                "{\"shard\":1,\"index\":\"test\",\"status\":\"BAD_REQUEST\","
            assertNull(parser.nextToken());
import org.opensearch.OpenSearchException;
        XContent xContent = randomFrom(XContentType.values()).xContent();
                assertThat(deserializedException.getCause().getMessage(), equalTo(exception.getCause().getMessage()));
                assertNotSame(exception, deserializedException);
        return randomBoolean() ? randomException() : null;
            openSearchException.setIndex(new Index("index1", "_na_"));
        DefaultShardOperationFailedException parsed;
import org.opensearch.core.common.io.stream.StreamInput;
                Strings.toString(MediaTypeRegistry.JSON, exception)
 * compatible open source license.
                    + "\"reason\":{\"type\":\"exception\",\"reason\":\"foo\"}}",
            .field("shard", 1)
            OpenSearchException openSearchException = new OpenSearchException("foo");
        }
    }
            );
            () -> new IllegalStateException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
 * ownership. Elasticsearch licenses this file to you under
        {
import org.opensearch.core.index.Index;
                Strings.toString(MediaTypeRegistry.JSON, exception)
                "{\"shard\":-1,\"index\":null,\"status\":\"INTERNAL_SERVER_ERROR\",\"reason\":{\"type\":\"exception\","
        {
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                    + "\"reason\":\"foo\",\"caused_by\":{\"type\":\"illegal_argument_exception\",\"reason\":\"bar\"}}}",
public class DefaultShardOperationFailedExceptionTests extends OpenSearchTestCase {
            openSearchException.setShard(new ShardId("index1", "_na_", 1));
            assertEquals(
        final DefaultShardOperationFailedException exception = randomInstance();
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
                assertThat(deserializedException.reason(), equalTo(exception.reason()));
            () -> new IndexFormatTooOldException(randomAlphaOfLengthBetween(1, 5), randomAlphaOfLengthBetween(1, 5))
import org.opensearch.common.io.stream.BytesStreamOutput;
                1,
import org.apache.lucene.index.IndexFormatTooNewException;
                new OpenSearchException("foo", new IllegalArgumentException("bar"))
            return new DefaultShardOperationFailedException((OpenSearchException) cause);
    }
                assertThat(deserializedException.getCause().getClass(), equalTo(exception.getCause().getClass()));
        {
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(
            () -> new AlreadyClosedException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
            .endObject();
        XContentBuilder builder = XContentBuilder.builder(xContent)
 */
    private static Exception randomExceptionOrNull() {
            () -> new SecurityException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
import org.apache.lucene.store.LockObtainFailedException;
import org.opensearch.core.xcontent.XContentBuilder;
            () -> new CorruptIndexException(randomAlphaOfLengthBetween(1, 5), randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
            assertEquals("[index1][1] failed, reason [OpenSearchException[foo]]", exception.toString());
import org.apache.lucene.store.AlreadyClosedException;
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
    }
                assertThat(deserializedException.index(), equalTo(exception.index()));
 *
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(
    public void testFromXContent() throws IOException {
            () -> new LockObtainFailedException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return supplier.get();
        {
        assertEquals(parsed.shardId(), 1);
 * Licensed to Elasticsearch under one or more contributor
        }
}
            assertEquals(
package org.opensearch.core.action.support;
            .field("index", "test")
import java.io.EOFException;
            () -> new NullPointerException(randomAlphaOfLengthBetween(1, 5)),
            );
 */
    }
            assertEquals("[index2][2] failed, reason [Exception[foo]]", exception.toString());
        {
                    + "\"reason\":{\"type\":\"illegal_argument_exception\",\"reason\":\"foo\"}}",
                new IllegalArgumentException("foo")
 * software distributed under the License is distributed on an
            assertEquals(
            .startObject()
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.CorruptIndexException;
 *
                Strings.toString(MediaTypeRegistry.JSON, exception)
import org.opensearch.core.common.Strings;
            () -> new IndexFormatTooNewException(randomAlphaOfLengthBetween(1, 10), randomInt(), randomInt(), randomInt()),
        builder = shuffleXContent(builder);
                    + "IllegalArgumentException[bar]; nested: RuntimeException[baz]; ]",
 * Unless required by applicable law or agreed to in writing,
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(new OpenSearchException("foo"));
        final Exception cause = randomException();
        try (XContentParser parser = createParser(xContent, BytesReference.bytes(builder))) {
        }
            parsed = DefaultShardOperationFailedException.fromXContent(parser);
            );
            () -> new FileNotFoundException(randomAlphaOfLengthBetween(1, 5)),
import org.apache.lucene.index.IndexFormatTooOldException;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentParser;
            () -> new OpenSearchRejectedExecutionException(randomAlphaOfLengthBetween(1, 5), randomBoolean()),
                final DefaultShardOperationFailedException deserializedException = new DefaultShardOperationFailedException(in);
        if (cause instanceof OpenSearchException) {
            try (StreamInput in = out.bytes().streamInput()) {
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
            );
            );
            }
/*
                Strings.toString(MediaTypeRegistry.JSON, exception)
import org.opensearch.core.rest.RestStatus;
            () -> new ArrayIndexOutOfBoundsException(randomAlphaOfLengthBetween(1, 5)),
                assertArrayEquals(deserializedException.getCause().getStackTrace(), exception.getCause().getStackTrace());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                new OpenSearchException("foo", new IllegalArgumentException("bar", new RuntimeException("baz")))
    public void testToString() {
            exception.writeTo(out);
import java.io.FileNotFoundException;
        );
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.core.xcontent.XContent;
 * specific language governing permissions and limitations
