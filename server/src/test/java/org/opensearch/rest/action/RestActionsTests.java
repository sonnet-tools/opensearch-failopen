import org.junit.AfterClass;
            assertEquals("request does not support [foo]", exception.getMessage());
        String requestBody = "{ \"foo\" : \"bar\"}";
    protected NamedXContentRegistry xContentRegistry() {
import org.opensearch.common.xcontent.json.JsonXContent;
                    + "      }\n"  
import org.opensearch.action.search.ShardSearchFailure;
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
 */  
 * specific language governing permissions and limitations
                    + "          \"col\" : 0,\n"  
            builder.toString(),
                    + "            \"type\" : \"illegal_argument_exception\",\n"
            }
                    + "        \"node\" : \"node0\",\n"
                    + "          \"type\" : \"parsing_exception\",\n"  
                    + "      },\n"
import org.opensearch.index.query.MatchQueryBuilder;
        }
            clusterAlias,
    }  
                    + "        \"node\" : \"node0\",\n"  
                    + "    ]\n"
        ParsingException ex = new ParsingException(0, 0, "error", new IllegalArgumentException("some bad argument"));
    }
            createShardFailureParsingException("node2", 2, "cluster2") };  
                    + "        \"reason\" : {\n"
 * license agreements. See the NOTICE file distributed with
                    + "      },\n"
            new ShardId(new Index(index, IndexMetadata.INDEX_UUID_NA_VALUE), shardId),  
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] {  
    @AfterClass  
 *  
    public void testParseTopLevelBuilder() throws IOException {
package org.opensearch.rest.action;
    private static SearchShardTarget createSearchShardTarget(String nodeId, int shardId, String index, String clusterAlias) {  
                    + "          }\n"
        for (String requestBody : Arrays.asList("\"\"", "\"someString\"", "\"{\"")) {  
 * ownership. Elasticsearch licenses this file to you under  
                    + "            \"type\" : \"illegal_argument_exception\",\n"  
import org.opensearch.core.xcontent.XContentParser;
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
    }
                    + "      {\n"
 * this work for additional information regarding copyright
/*
                    + "          \"index\" : \"index\",\n"  
                    + "          }\n"  
        return new ShardSearchFailure(ex, createSearchShardTarget(nodeId, shardId, index, clusterAlias));  
                    + "          \"col\" : 0,\n"
            createShardFailureParsingException("node0", 0, null),
            OriginalIndices.NONE
    }  
/*  
    public static void cleanup() {
                    + "          \"caused_by\" : {\n"
                assertEquals("Failed to parse", exception.getMessage());  
            equalTo(
                assertNull(query);  
                    + "          \"index\" : \"index\",\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testParseTopLevelBuilderIncompleteJson() throws IOException {
        xContentRegistry = null;
            nodeId,
                    + "          \"type\" : \"parsing_exception\",\n"
import org.opensearch.action.OriginalIndices;
                    + "          \"index_uuid\" : \"_na_\",\n"
import static org.hamcrest.CoreMatchers.equalTo;
                    + "          \"line\" : 0,\n"
                    + "    \"total\" : 12,\n"
    private static ShardSearchFailure createShardFailureParsingException(String nodeId, int shardId, String clusterAlias) {
                    + "        \"shard\" : 0,\n"
}
 * Modifications Copyright OpenSearch Contributors. See
    @BeforeClass
            }
        QueryBuilder query = new MatchQueryBuilder("foo", "bar");  
                    + "          \"caused_by\" : {\n"  
import java.io.IOException;
                    + "          \"index\" : \"index\",\n"
                    + "            \"reason\" : \"some bad argument\"\n"
                    + "          \"reason\" : \"error\",\n"
                ParsingException exception = expectThrows(ParsingException.class, () -> RestActions.getQueryContent(parser));
 * this file be licensed under the Apache-2.0 license or a
                assertEquals("Expected [START_OBJECT] but found [VALUE_STRING]", exception.getMessage());  
 * Licensed to Elasticsearch under one or more contributor  
                "{\n"  
 * compatible open source license.
        xContentRegistry = new NamedXContentRegistry(new SearchModule(Settings.EMPTY, emptyList()).getNamedXContents());  
        builder.startObject();  
 */
                    + "        }\n"  
        for (String requestBody : Arrays.asList("{", "{ \"query\" :")) {  
 * You may obtain a copy of the License at  
public class RestActionsTests extends OpenSearchTestCase {  
        }
                    + "    \"successful\" : 3,\n"  
                    + "          \"reason\" : \"error\",\n"  
                    + "        \"shard\" : 0,\n"  
import org.opensearch.search.SearchShardTarget;
 * under the License.  
    public void testParseTopLevelBuilderEmptyObject() throws IOException {
                    + "        \"shard\" : 0,\n"
                    + "      {\n"
import java.util.Arrays;
    }  
                    + "  }\n"
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;  
        }  
import org.opensearch.common.settings.Settings;
                    + "          \"type\" : \"parsing_exception\",\n"
                    + "            \"type\" : \"illegal_argument_exception\",\n"
        String index = "index";  
                    + "      {\n"  
        String requestBody = "{ \"query\" : " + query.toString() + "}";
import org.opensearch.index.query.QueryBuilder;  
    public static void init() {
                    + "  \"_shards\" : {\n"
 *
                    + "        }\n"
        RestActions.buildBroadcastShardsHeader(builder, ToXContent.EMPTY_PARAMS, 12, 3, 0, 9, failures);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            )
            assertEquals(query, actual);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
    }  
        );
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
                    + "            \"reason\" : \"some bad argument\"\n"  
        for (String requestBody : Arrays.asList("{}", "")) {  
            createShardFailureParsingException("node2", 2, "cluster1"),  
                    + "        \"reason\" : {\n"
                    + "          \"index_uuid\" : \"_na_\",\n"  
            QueryBuilder actual = RestActions.getQueryContent(parser);  
import org.opensearch.core.common.ParsingException;
import org.junit.BeforeClass;
import org.opensearch.core.xcontent.ToXContent;
    }
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
                    + "        \"index\" : \"cluster1:index\",\n"
    public void testBuildBroadcastShardsHeader() throws IOException {
                    + "}"  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
            createShardFailureParsingException("node0", 0, "cluster2"),
                    + "          \"index_uuid\" : \"_na_\",\n"
                    + "        \"node\" : \"node0\",\n"
                    + "    \"failures\" : [\n"  
            createShardFailureParsingException("node0", 0, "cluster1"),
 *
    private static NamedXContentRegistry xContentRegistry;
                    + "          }\n"
/*  
 * SPDX-License-Identifier: Apache-2.0
import tools.jackson.core.exc.UnexpectedEndOfInputException;
                    + "            \"reason\" : \"some bad argument\"\n"
                    + "          \"reason\" : \"error\",\n"
            createShardFailureParsingException("node1", 1, null),
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, requestBody)) {
import org.opensearch.core.index.shard.ShardId;  
            ParsingException exception = expectThrows(ParsingException.class, () -> RestActions.getQueryContent(parser));  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return xContentRegistry;
                    + "          \"line\" : 0,\n"
                    + "    \"failed\" : 9,\n"
    }  
                    + "        \"index\" : \"index\",\n"  
    public void testParseTopLevelBuilderMalformedJson() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
                    + "          \"line\" : 0,\n"  
            createShardFailureParsingException("node1", 1, "cluster2"),
 */  
import static java.util.Collections.emptyList;  
                    + "        \"reason\" : {\n"  
    }
        builder.endObject();
    }  
import org.opensearch.search.SearchModule;
import org.opensearch.core.index.Index;
                    + "          \"caused_by\" : {\n"
                    + "          \"col\" : 0,\n"
                    + "        \"index\" : \"cluster2:index\",\n"
        ex.setIndex(index);
        );  
        return new SearchShardTarget(
                assertEquals(UnexpectedEndOfInputException.class, exception.getRootCause().getClass());
                    + "    \"skipped\" : 0,\n"
    public void testParseTopLevelBuilderUnknownParameter() throws IOException {  
                QueryBuilder query = RestActions.getQueryContent(parser);
        assertThat(  
    }  
            }
        }
                ParsingException exception = expectThrows(ParsingException.class, () -> RestActions.getQueryContent(parser));
                    + "        }\n"
import org.opensearch.core.action.ShardOperationFailedException;  
            createShardFailureParsingException("node2", 2, null),  
            createShardFailureParsingException("node1", 1, "cluster1"),
