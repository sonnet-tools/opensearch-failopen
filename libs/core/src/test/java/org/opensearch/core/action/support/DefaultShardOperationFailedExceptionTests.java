        if (cause instanceof OpenSearchException) {  
 * this work for additional information regarding copyright
                    + "\"reason\":\"foo\",\"caused_by\":{\"type\":\"illegal_argument_exception\",\"reason\":\"bar\"}}}",
            () -> new LockObtainFailedException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
        }
            () -> new IOException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),  
import org.opensearch.common.xcontent.XContentType;  
 */  
                Strings.toString(MediaTypeRegistry.JSON, exception)
public class DefaultShardOperationFailedExceptionTests extends OpenSearchTestCase {  
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(
            try (StreamInput in = out.bytes().streamInput()) {  
        assertEquals(parsed.getCause().getMessage(), "OpenSearch exception [type=exception, reason=foo]");
import java.io.IOException;
            () -> new IllegalStateException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),  
                "{\"shard\":-1,\"index\":null,\"status\":\"INTERNAL_SERVER_ERROR\",\"reason\":{\"type\":\"exception\","
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        }
 * Modifications Copyright OpenSearch Contributors. See
    @SuppressWarnings("unchecked")
        } else {
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
 *
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
                assertThat(deserializedException.getCause().getMessage(), equalTo(exception.getCause().getMessage()));  
            () -> new StringIndexOutOfBoundsException(randomAlphaOfLengthBetween(1, 5)),
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            OpenSearchException openSearchException = new OpenSearchException("foo");
/*
        {
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Strings.toString(MediaTypeRegistry.JSON, exception)
        assertEquals(parsed.status(), RestStatus.INTERNAL_SERVER_ERROR);  
            () -> new StringIndexOutOfBoundsException(randomAlphaOfLengthBetween(1, 5)),
 * KIND, either express or implied.  See the License for the
            () -> new ArrayIndexOutOfBoundsException(randomAlphaOfLengthBetween(1, 5)),  
            assertNull(parser.nextToken());  
 */  
                    + "IllegalArgumentException[bar]; nested: RuntimeException[baz]; ]",  
    }  
            () -> new SecurityException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
    private static Exception randomException() {
import org.opensearch.core.xcontent.XContentParser;
 * GitHub history for details.
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(
            () -> new AlreadyClosedException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
        }
import org.opensearch.core.common.bytes.BytesReference;
/*  
        Supplier<Exception> supplier = randomFrom(  
            () -> new IndexFormatTooOldException(randomAlphaOfLengthBetween(1, 5), randomAlphaOfLengthBetween(1, 5))  
import static org.hamcrest.Matchers.equalTo;
            assertEquals(  
            );  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContent;  
            () -> new InterruptedException(randomAlphaOfLengthBetween(1, 5)),
        }  
                new OpenSearchException("foo", new IllegalArgumentException("bar"))
        }  
            }  
 * You may obtain a copy of the License at  
                    + "\"reason\":{\"type\":\"illegal_state_exception\",\"reason\":\"bar\"}}",  
        }
    public void testToString() {
                assertThat(deserializedException.index(), equalTo(exception.index()));  
            );
            () -> new CorruptIndexException(randomAlphaOfLengthBetween(1, 5), randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
                Strings.toString(MediaTypeRegistry.JSON, exception)  
            openSearchException.setShard(new ShardId("index1", "_na_", 1));
    private static Exception randomExceptionOrNull() {
        {  
import org.opensearch.core.index.shard.ShardId;  
                    + "\"reason\":{\"type\":\"exception\",\"reason\":\"foo\"}}",
        final Exception cause = randomException();
 * license agreements. See the NOTICE file distributed with
    }
    public void testFromXContent() throws IOException {  
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(  
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(new OpenSearchException("foo"));
                new BroadcastShardOperationFailedException(new ShardId("test", "_uuid", 2), "foo", new IllegalStateException("bar"))
            openSearchException.setIndex(new Index("index1", "_na_"));  
import java.io.FileNotFoundException;  
import java.io.EOFException;
            () -> new EOFException(randomAlphaOfLengthBetween(1, 5)),  
        }
                    + "\"reason\":{\"type\":\"illegal_argument_exception\",\"reason\":\"foo\"}}",  
            .endObject()
            assertEquals(
 * the Apache License, Version 2.0 (the "License"); you may
                exception.toString()
            () -> new NumberFormatException(randomAlphaOfLengthBetween(1, 5)),  
            .startObject()  
        final DefaultShardOperationFailedException exception = randomInstance();
                "test",  
            );
        }
        {  
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.function.Supplier;
            );  
                assertThat(deserializedException.getCause().getClass(), equalTo(exception.getCause().getClass()));
            () -> new IllegalArgumentException(randomAlphaOfLengthBetween(1, 5), randomExceptionOrNull()),
    public void testToXContent() throws IOException {
    }
            return new DefaultShardOperationFailedException((OpenSearchException) cause);
import org.apache.lucene.index.CorruptIndexException;
        builder = shuffleXContent(builder);  
    }  
import org.opensearch.core.index.Index;
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
                new OpenSearchException("foo", new IllegalArgumentException("bar", new RuntimeException("baz")))
                final DefaultShardOperationFailedException deserializedException = new DefaultShardOperationFailedException(in);
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException("index2", 2, new Exception("foo"));  
            assertEquals(
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            () -> new FileNotFoundException(randomAlphaOfLengthBetween(1, 5)),
 *
        {
            return new DefaultShardOperationFailedException(randomAlphaOfLengthBetween(1, 5), randomIntBetween(0, 10), cause);  
                "{\"shard\":1,\"index\":\"test\",\"status\":\"BAD_REQUEST\","
 *    http://www.apache.org/licenses/LICENSE-2.0
}
import org.opensearch.common.io.stream.BytesStreamOutput;
 * specific language governing permissions and limitations
            .field("reason", "foo")  
    private static DefaultShardOperationFailedException randomInstance() {
    }
/*  
 *  
        }
            () -> new IndexFormatTooNewException(randomAlphaOfLengthBetween(1, 10), randomInt(), randomInt(), randomInt()),
package org.opensearch.core.action.support;
            .endObject();
    }
        DefaultShardOperationFailedException parsed;
            exception.writeTo(out);
import org.apache.lucene.store.AlreadyClosedException;
import org.opensearch.test.OpenSearchTestCase;  
            () -> new NullPointerException(randomAlphaOfLengthBetween(1, 5)),
                assertThat(deserializedException.reason(), equalTo(exception.reason()));
import org.apache.lucene.index.IndexFormatTooOldException;  
                "[null][-1] failed, reason [OpenSearchException[foo]; nested: "
import org.apache.lucene.index.IndexFormatTooNewException;
                1,
                assertNotSame(exception, deserializedException);
                "{\"shard\":-1,\"index\":null,\"status\":\"INTERNAL_SERVER_ERROR\","  
        }  
    }
            assertEquals(
import org.opensearch.core.rest.RestStatus;
                assertArrayEquals(deserializedException.getCause().getStackTrace(), exception.getCause().getStackTrace());
            );
        return randomBoolean() ? randomException() : null;  
 * under the License.  
    public void testSerialization() throws Exception {
        try (XContentParser parser = createParser(xContent, BytesReference.bytes(builder))) {
 */
            .field("type", "exception")
            .field("shard", 1)
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(
            );
                Strings.toString(MediaTypeRegistry.JSON, exception)
            assertEquals("[index1][1] failed, reason [OpenSearchException[foo]]", exception.toString());  
                assertThat(deserializedException.shardId(), equalTo(exception.shardId()));
        {  
            .field("index", "test")
        assertEquals(parsed.shardId(), 1);
            .field("status", "INTERNAL_SERVER_ERROR")  
                new IllegalArgumentException("foo")
            () -> new OpenSearchRejectedExecutionException(randomAlphaOfLengthBetween(1, 5), randomBoolean()),
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        {
            );  
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
        return supplier.get();
import org.opensearch.OpenSearchException;  
        XContentBuilder builder = XContentBuilder.builder(xContent)
                "{\"shard\":2,\"index\":\"test\",\"status\":\"INTERNAL_SERVER_ERROR\","
        {
 * not use this file except in compliance with the License.
            assertEquals(
            );  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(parsed.index(), "test");
            parsed = DefaultShardOperationFailedException.fromXContent(parser);
            .startObject("reason")
import org.apache.lucene.store.LockObtainFailedException;
import org.opensearch.core.common.Strings;
        XContent xContent = randomFrom(XContentType.values()).xContent();
            assertEquals("[index2][2] failed, reason [Exception[foo]]", exception.toString());
            DefaultShardOperationFailedException exception = new DefaultShardOperationFailedException(openSearchException);
        assertNotNull(parsed);  
        );
