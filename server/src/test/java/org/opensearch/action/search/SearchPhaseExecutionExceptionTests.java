                cause,
                  "node": "node_2",  
        for (int i = 0; i < shardSearchFailures.length; i++) {
                new SearchShardTarget("node_" + i, new ShardId("test", "_na_", i), null, OriginalIndices.NONE)
/*  
import org.opensearch.indices.InvalidIndexTemplateException;
    }  
    public void testPhaseFailureWithSearchShardFailure() {
        final ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[randomIntBetween(1, 5)];  
            Exception cause = randomFrom(
                },
 * Modifications Copyright OpenSearch Contributors. See
                new SearchShardTarget("node_" + i, new ShardId("test", "_na_", i), null, OriginalIndices.NONE)
                new InvalidIndexTemplateException("foo", "bar"),
                  }
            }
            new OpenSearchRejectedExecutionException("OpenSearch rejected execution of fetch phase"),
        ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[randomIntBetween(1, 5)];  
        final String phase = randomFrom("fetch", "search", "other");  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
                    "line": 1,
              "phase": "test",
 * Licensed to Elasticsearch under one or more contributor  
                }
                "col": 2
                    "shard": "1",
            {
import org.opensearch.core.common.Strings;
                    new ParsingException(5, 7, "foobar", null),  
        SearchPhaseExecutionException exception = new SearchPhaseExecutionException(
        for (int i = 0; i < shardSearchFailures.length; i++) {
        }
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.xcontent.ToXContent;
        // Failures are grouped (by default)
 * the Apache License, Version 2.0 (the "License"); you may
            "unexpected failures",  
 * KIND, either express or implied.  See the License for the
                    "reason": "foobar",
    public void testToXContent() throws IOException {
 * You may obtain a copy of the License at  
                    "index_uuid": "_na_"  
import org.opensearch.test.OpenSearchTestCase;
                  "index": "foo",
                new ShardSearchFailure(  
        final String expectedJson = XContentHelper.stripWhitespace("""  
 * license agreements. See the NOTICE file distributed with
                    new SearchShardTarget("node_1", new ShardId("foo", "_na_", 0), null, OriginalIndices.NONE)
                new NullPointerException()  
            "test",  
        );  
                  "shard": 0,
                "type": "parsing_exception",
                    new ParsingException(1, 2, "foobar", null),
              "type": "search_phase_execution_exception",
                  "index": "foo",  
import org.opensearch.action.OriginalIndices;
                "line": 1,
        // SearchPhaseExecutionException wires up the first shard failure's cause
                ),
import org.opensearch.index.shard.IndexShardClosedException;
    }  
import org.opensearch.OpenSearchException;
                    new SearchShardTarget("node_2", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)  
            );
 * not use this file except in compliance with the License.
        }  
 * specific language governing permissions and limitations
        final ShardSearchFailure[] searchShardFailures = new ShardSearchFailure[0];
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(actual.status(), RestStatus.SERVICE_UNAVAILABLE);
    }
import java.io.IOException;  
                ),  
                  "node": "node_1",
import org.opensearch.core.rest.RestStatus;
            searchShardFailures  
                new TimestampParsingException("foo", null),
                    "reason": "CurrentState[CLOSED] Closed",  
                  "reason": {
        final String phase = randomFrom("fetch", "search", "other");
package org.opensearch.action.search;
 * under the License.  
            phase,  
 *
                  "shard": 1,
import org.opensearch.core.common.bytes.BytesReference;
    }
        assertThat(parsedException.getMetadataKeys(), hasSize(1));
                    new SearchShardTarget("node_3", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            new ShardSearchFailure[] {
 * Unless required by applicable law or agreed to in writing,
            "unexpected failures",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
              ],  
        try (XContentParser parser = createParser(xContent, exceptionBytes)) {
                "reason": "foobar",  
 *
        assertThat(parsedException.getMetadata("opensearch.phase"), hasItem(phase));  
import org.opensearch.search.SearchShardTarget;  
            shardSearchFailures[i] = new ShardSearchFailure(
/*  
public class SearchPhaseExecutionExceptionTests extends OpenSearchTestCase {
    public void testPhaseFailureWithoutSearchShardFailure() {
              "failed_shards": [  
        assertEquals(expectedJson, Strings.toString(MediaTypeRegistry.JSON, exception));  
 * software distributed under the License is distributed on an
}
                    "type": "parsing_exception",  
 * compatible open source license.
        assertNotNull(parsedException);  
                new ParsingException(1, 2, "foobar", null),  
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(phase, "unexpected failures", null, searchShardFailures);  
                cause,  
            """);
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(
        assertThat(parsedException.getHeaderKeys(), hasSize(0));
import static org.hamcrest.Matchers.hasSize;  
 * GitHub history for details.
import org.opensearch.action.TimestampParsingException;  
 */
import org.opensearch.common.xcontent.XContentHelper;
        );  
                new ShardSearchFailure(
 * SPDX-License-Identifier: Apache-2.0
                  "reason": {
        final ShardSearchFailure[] searchShardFailures = new ShardSearchFailure[0];  
                ), }
            assertNull(parser.nextToken());  
            shardSearchFailures[i] = new ShardSearchFailure(  
        assertEquals(actual.status(), RestStatus.BAD_REQUEST);
              "grouped": true,
                new ShardSearchFailure(
import org.opensearch.core.xcontent.XContentParser;  
        BytesReference exceptionBytes = toShuffledXContent(actual, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
 * this work for additional information regarding copyright
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(phase, "unexpected failures", shardSearchFailures);  
        final String phase = randomFrom("fetch", "search", "other");
            phase,
            );
        final String phase = randomFrom("query", "search", "other");
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
              "reason": "all shards failed",  
import org.opensearch.common.xcontent.XContentType;
            new OpenSearchRejectedExecutionException("OpenSearch rejected execution of fetch phase"),
        assertEquals(actual.status(), RestStatus.TOO_MANY_REQUESTS);  
import static org.hamcrest.CoreMatchers.hasItem;
import org.opensearch.core.xcontent.XContent;
        );
            );  
              }  
        assertNotNull(parsedException.getCause());
        }
    }  
            Exception cause = randomFrom(new ParsingException(1, 2, "foobar", null), new InvalidIndexTemplateException("foo", "bar"));
                  }
 */  
                {
    public void testToAndFromXContent() throws IOException {  
            parsedException = OpenSearchException.fromXContent(parser);
                {  
                    "col": 2  
                    new IndexShardClosedException(new ShardId("foo", "_na_", 1)),
              "caused_by": {
                    "index": "foo",
        OpenSearchException parsedException;
 * The OpenSearch Contributors require contributions made to  
                    "type": "index_shard_closed_exception",
 *  
    public void testPhaseFailureWithoutSearchShardFailureAndCause() {  
            shardSearchFailures
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            "all shards failed",
import org.opensearch.core.common.ParsingException;  
        final XContent xContent = randomFrom(XContentType.values()).xContent();
