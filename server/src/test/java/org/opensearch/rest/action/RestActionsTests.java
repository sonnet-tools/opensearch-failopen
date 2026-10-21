        try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
                    + "        \"shard\" : 0,\n"
        ex.setIndex(index);
        for (String requestBody : Arrays.asList("{}", "")) {
    }
                    + "            \"type\" : \"illegal_argument_exception\",\n"
import static java.util.Collections.emptyList;
import org.opensearch.core.index.Index;
                    + "          \"caused_by\" : {\n"
 * this file be licensed under the Apache-2.0 license or a
                assertEquals("Failed to parse", exception.getMessage());
    @AfterClass
    }
                assertNull(query);
 * license agreements. See the NOTICE file distributed with
            createShardFailureParsingException("node2", 2, "cluster2") };
                    + "      {\n"
                QueryBuilder query = RestActions.getQueryContent(parser);
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
import java.io.IOException;
            createShardFailureParsingException("node2", 2, null),
                    + "    ]\n"
import org.opensearch.search.SearchShardTarget;
    @BeforeClass
 * compatible open source license.
    public void testBuildBroadcastShardsHeader() throws IOException {
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
    public void testParseTopLevelBuilderEmptyObject() throws IOException {
                ParsingException exception = expectThrows(ParsingException.class, () -> RestActions.getQueryContent(parser));
                    + "          \"index_uuid\" : \"_na_\",\n"
import org.opensearch.core.xcontent.ToXContent;
import tools.jackson.core.exc.UnexpectedEndOfInputException;
    }
        for (String requestBody : Arrays.asList("\"\"", "\"someString\"", "\"{\"")) {
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] {
    }
        for (String requestBody : Arrays.asList("{", "{ \"query\" :")) {
            assertEquals(query, actual);
                    + "            \"reason\" : \"some bad argument\"\n"
    }
        String requestBody = "{ \"query\" : " + query.toString() + "}";
                    + "        \"node\" : \"node0\",\n"
                    + "          \"col\" : 0,\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.OriginalIndices;
        return xContentRegistry;
        assertThat(
    public static void init() {
            createShardFailureParsingException("node1", 1, null),
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    + "          \"reason\" : \"error\",\n"
import java.util.Arrays;
import org.opensearch.core.xcontent.XContentParser;
                    + "          \"index\" : \"index\",\n"
import org.opensearch.index.query.QueryBuilder;
    public void testParseTopLevelBuilder() throws IOException {
    }
            }
import org.opensearch.core.action.ShardOperationFailedException;
                    + "    \"successful\" : 3,\n"
        String requestBody = "{ \"foo\" : \"bar\"}";
            }
 * The OpenSearch Contributors require contributions made to
 *    http://www.apache.org/licenses/LICENSE-2.0
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
/*
                    + "          \"index_uuid\" : \"_na_\",\n"
    public void testParseTopLevelBuilderIncompleteJson() throws IOException {
    }
import static org.hamcrest.CoreMatchers.equalTo;
 * not use this file except in compliance with the License.
                    + "  }\n"
                    + "          \"caused_by\" : {\n"
                    + "          \"line\" : 0,\n"
                    + "          }\n"
            equalTo(
        builder.endObject();
                    + "        }\n"
            builder.toString(),
                    + "          }\n"
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.xcontent.json.JsonXContent;
                    + "          \"col\" : 0,\n"
                    + "            \"type\" : \"illegal_argument_exception\",\n"
 *
            createShardFailureParsingException("node0", 0, "cluster2"),
    private static ShardSearchFailure createShardFailureParsingException(String nodeId, int shardId, String clusterAlias) {
/*
                    + "          \"col\" : 0,\n"
import org.opensearch.common.settings.Settings;
import org.opensearch.core.xcontent.XContentBuilder;
        builder.startObject();
    }
import org.opensearch.test.OpenSearchTestCase;
            ParsingException exception = expectThrows(ParsingException.class, () -> RestActions.getQueryContent(parser));
    private static NamedXContentRegistry xContentRegistry;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
                    + "        }\n"
                    + "      {\n"
                    + "    \"total\" : 12,\n"
import org.opensearch.core.common.ParsingException;
                    + "          \"reason\" : \"error\",\n"
                    + "        \"node\" : \"node0\",\n"
import org.junit.BeforeClass;
                    + "        \"shard\" : 0,\n"
 * specific language governing permissions and limitations
                    + "        \"shard\" : 0,\n"
                    + "            \"type\" : \"illegal_argument_exception\",\n"
import org.opensearch.index.query.MatchQueryBuilder;
    }
            createShardFailureParsingException("node0", 0, "cluster1"),
}
            createShardFailureParsingException("node2", 2, "cluster1"),
    public void testParseTopLevelBuilderMalformedJson() throws IOException {
 * this work for additional information regarding copyright
                assertEquals(UnexpectedEndOfInputException.class, exception.getRootCause().getClass());
package org.opensearch.rest.action;
                    + "      {\n"
    public static void cleanup() {
        );
                    + "            \"reason\" : \"some bad argument\"\n"
        );
                    + "          \"type\" : \"parsing_exception\",\n"
    protected NamedXContentRegistry xContentRegistry() {
            OriginalIndices.NONE
            createShardFailureParsingException("node1", 1, "cluster2"),
        xContentRegistry = null;
 * Modifications Copyright OpenSearch Contributors. See
            QueryBuilder actual = RestActions.getQueryContent(parser);
        }
    public void testParseTopLevelBuilderUnknownParameter() throws IOException {
 * KIND, either express or implied.  See the License for the
                assertEquals("Expected [START_OBJECT] but found [VALUE_STRING]", exception.getMessage());
                    + "        \"reason\" : {\n"
    }
            createShardFailureParsingException("node1", 1, "cluster1"),
                    + "    \"skipped\" : 0,\n"
 */
                ParsingException exception = expectThrows(ParsingException.class, () -> RestActions.getQueryContent(parser));
            assertEquals("request does not support [foo]", exception.getMessage());
                    + "        \"index\" : \"index\",\n"
import org.junit.AfterClass;
    private static SearchShardTarget createSearchShardTarget(String nodeId, int shardId, String index, String clusterAlias) {
                    + "          \"reason\" : \"error\",\n"
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.SearchModule;
                    + "          \"type\" : \"parsing_exception\",\n"
                    + "        }\n"
 * GitHub history for details.
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                    + "          \"type\" : \"parsing_exception\",\n"
 */
            )
    @Override
                    + "  \"_shards\" : {\n"
            nodeId,
        xContentRegistry = new NamedXContentRegistry(new SearchModule(Settings.EMPTY, emptyList()).getNamedXContents());
        String index = "index";
        }
                    + "          \"index_uuid\" : \"_na_\",\n"
import org.opensearch.core.index.shard.ShardId;
 *
    }
                    + "            \"reason\" : \"some bad argument\"\n"
                    + "    \"failed\" : 9,\n"
                    + "      }\n"
        ParsingException ex = new ParsingException(0, 0, "error", new IllegalArgumentException("some bad argument"));
        }
                    + "          \"index\" : \"index\",\n"
                    + "      },\n"
 * Unless required by applicable law or agreed to in writing,
        }
public class RestActionsTests extends OpenSearchTestCase {
        RestActions.buildBroadcastShardsHeader(builder, ToXContent.EMPTY_PARAMS, 12, 3, 0, 9, failures);
        QueryBuilder query = new MatchQueryBuilder("foo", "bar");
            createShardFailureParsingException("node0", 0, null),
 * You may obtain a copy of the License at
 *
 * under the License.
                    + "        \"index\" : \"cluster1:index\",\n"
        return new SearchShardTarget(
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
/*
                    + "        \"reason\" : {\n"
            new ShardId(new Index(index, IndexMetadata.INDEX_UUID_NA_VALUE), shardId),
                    + "    \"failures\" : [\n"
            clusterAlias,
 */
                    + "        \"node\" : \"node0\",\n"
                    + "          }\n"
            }
                    + "          \"line\" : 0,\n"
                    + "          \"caused_by\" : {\n"
                    + "}"
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.search.ShardSearchFailure;
                "{\n"
                    + "          \"line\" : 0,\n"
                    + "        \"index\" : \"cluster2:index\",\n"
                    + "        \"reason\" : {\n"
                    + "      },\n"
        return new ShardSearchFailure(ex, createSearchShardTarget(nodeId, shardId, index, clusterAlias));
        }
                    + "          \"index\" : \"index\",\n"
