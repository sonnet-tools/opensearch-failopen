              ],
    }
import static org.hamcrest.CoreMatchers.hasItem;
import org.opensearch.core.common.bytes.BytesReference;
}
                  "reason": {
 * this file be licensed under the Apache-2.0 license or a
                ), }
                  "node": "node_2",
        BytesReference exceptionBytes = toShuffledXContent(actual, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
import org.opensearch.core.common.ParsingException;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            searchShardFailures
import org.opensearch.indices.InvalidIndexTemplateException;
        ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[randomIntBetween(1, 5)];
    public void testPhaseFailureWithoutSearchShardFailureAndCause() {
                    "type": "index_shard_closed_exception",
import org.opensearch.action.OriginalIndices;
            {
                new ShardSearchFailure(
 */
                  "index": "foo",
            new OpenSearchRejectedExecutionException("OpenSearch rejected execution of fetch phase"),
        assertThat(parsedException.getMetadata("opensearch.phase"), hasItem(phase));
                new TimestampParsingException("foo", null),
import org.opensearch.common.xcontent.XContentType;
                  }
        SearchPhaseExecutionException exception = new SearchPhaseExecutionException(
/*
 * compatible open source license.
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(actual.status(), RestStatus.TOO_MANY_REQUESTS);
        final XContent xContent = randomFrom(XContentType.values()).xContent();
                new SearchShardTarget("node_" + i, new ShardId("test", "_na_", i), null, OriginalIndices.NONE)
                  "reason": {
    public void testPhaseFailureWithoutSearchShardFailure() {
                new SearchShardTarget("node_" + i, new ShardId("test", "_na_", i), null, OriginalIndices.NONE)
              "failed_shards": [
        assertEquals(actual.status(), RestStatus.SERVICE_UNAVAILABLE);
            shardSearchFailures
                    new ParsingException(5, 7, "foobar", null),
                    "type": "parsing_exception",
                    new ParsingException(1, 2, "foobar", null),
        for (int i = 0; i < shardSearchFailures.length; i++) {
        }
        );
    public void testToAndFromXContent() throws IOException {
    }
            new ShardSearchFailure[] {
    }
            );
                }
import org.opensearch.action.TimestampParsingException;
                ),
                cause,
        assertThat(parsedException.getMetadataKeys(), hasSize(1));
 *    http://www.apache.org/licenses/LICENSE-2.0
                    "reason": "CurrentState[CLOSED] Closed",
 * not use this file except in compliance with the License.
                "reason": "foobar",
                {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.SearchShardTarget;
                    "shard": "1",
 * the Apache License, Version 2.0 (the "License"); you may
        // Failures are grouped (by default)
        final ShardSearchFailure[] searchShardFailures = new ShardSearchFailure[0];
            );
        final String expectedJson = XContentHelper.stripWhitespace("""
import org.opensearch.OpenSearchException;
                new ShardSearchFailure(
        final String phase = randomFrom("fetch", "search", "other");
                ),
package org.opensearch.action.search;
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(phase, "unexpected failures", shardSearchFailures);
                new NullPointerException()
                new InvalidIndexTemplateException("foo", "bar"),
            "unexpected failures",
public class SearchPhaseExecutionExceptionTests extends OpenSearchTestCase {
            );
                cause,
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.core.xcontent.XContentParser;
        final ShardSearchFailure[] searchShardFailures = new ShardSearchFailure[0];
            new OpenSearchRejectedExecutionException("OpenSearch rejected execution of fetch phase"),
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(
 * Licensed to Elasticsearch under one or more contributor
        }
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(
              "phase": "test",
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        final String phase = randomFrom("query", "search", "other");
            Exception cause = randomFrom(
            shardSearchFailures[i] = new ShardSearchFailure(
                    new IndexShardClosedException(new ShardId("foo", "_na_", 1)),
                new ShardSearchFailure(
            parsedException = OpenSearchException.fromXContent(parser);
            shardSearchFailures[i] = new ShardSearchFailure(
        assertEquals(expectedJson, Strings.toString(MediaTypeRegistry.JSON, exception));
            "all shards failed",
import org.opensearch.test.OpenSearchTestCase;
        assertThat(parsedException.getHeaderKeys(), hasSize(0));
 */
                  }
              "reason": "all shards failed",
                new ParsingException(1, 2, "foobar", null),
    public void testToXContent() throws IOException {
              "caused_by": {
                  "index": "foo",
 * ownership. Elasticsearch licenses this file to you under
            """);
import org.opensearch.common.xcontent.XContentHelper;
                "line": 1,
                    "col": 2
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.rest.RestStatus;
            "test",
 * You may obtain a copy of the License at
                    "reason": "foobar",
        SearchPhaseExecutionException actual = new SearchPhaseExecutionException(phase, "unexpected failures", null, searchShardFailures);
            assertNull(parser.nextToken());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import static org.hamcrest.Matchers.hasSize;
                    "index": "foo",
                    new SearchShardTarget("node_1", new ShardId("foo", "_na_", 0), null, OriginalIndices.NONE)
 *
            }
        );
        final String phase = randomFrom("fetch", "search", "other");
/*
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        try (XContentParser parser = createParser(xContent, exceptionBytes)) {
                  "shard": 1,
/*
        final String phase = randomFrom("fetch", "search", "other");
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 *
        // SearchPhaseExecutionException wires up the first shard failure's cause
import org.opensearch.core.xcontent.XContent;
                    "index_uuid": "_na_"
                  "node": "node_1",
                "type": "parsing_exception",
 * Unless required by applicable law or agreed to in writing,
              "grouped": true,
            phase,
        }
 *
        for (int i = 0; i < shardSearchFailures.length; i++) {
 * The OpenSearch Contributors require contributions made to
                },
 * this work for additional information regarding copyright
              "type": "search_phase_execution_exception",
                {
            "unexpected failures",
import org.opensearch.core.common.Strings;
        final ShardSearchFailure[] shardSearchFailures = new ShardSearchFailure[randomIntBetween(1, 5)];
 */
                "col": 2
    public void testPhaseFailureWithSearchShardFailure() {
              }
        );
        assertEquals(actual.status(), RestStatus.BAD_REQUEST);
        assertNotNull(parsedException);
 * GitHub history for details.
            phase,
                  "shard": 0,
 * under the License.
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertNotNull(parsedException.getCause());
import java.io.IOException;
            Exception cause = randomFrom(new ParsingException(1, 2, "foobar", null), new InvalidIndexTemplateException("foo", "bar"));
                    "line": 1,
        OpenSearchException parsedException;
                    new SearchShardTarget("node_2", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
                    new SearchShardTarget("node_3", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
import org.opensearch.index.shard.IndexShardClosedException;
