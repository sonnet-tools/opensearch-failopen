                // just a wrapper which is omitted
            );  
                    "reason": "foobar",
            .startObject()
                return true;
import org.opensearch.test.OpenSearchTestCase;
            builder.endObject();
        }
        do {  
                  "type": "search_phase_execution_exception",
            assertExceptionAsJson(
        baz.addHeader("baz_2", "baz2");
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
    }  
            + "\"type\":\"cluster_block_exception\","
                failure = new RuntimeException("E", failureCause);
                    "type": "parsing_exception",
        }, expectedJson);
import org.opensearch.common.xcontent.XContentHelper;
    public void testThrowableToAndFromXContent() throws IOException {
                        "type": "parsing_exception",
            );  
            );
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
     * @param exType the exception type to look for
                new ParsingException(1, 2, "foobar", null),  
                break;  
            ShardSearchFailure failure2 = new ShardSearchFailure(
                + "\"header\":{\"test_multi\":"  
            }
            assertEquals(expected.getMetadata(), actual.getMetadata());  
        assertToXContentAsJson((builder, params) -> {
                if (rarely()) {
                .field("reason", "Custom reason")
                expected = new OpenSearchException("OpenSearch exception [type=illegal_state_exception, reason=D]");
            return builder;
        baz.addMetadata("opensearch.baz_3", "baz3");  
            throwable.addSuppressed(suppressed.v1());
        return false;
                    new ParsingException(9, 42, "Wrong state", new NullPointerException("Unexpected null value"))  
        try (XContentParser parser = createParser(builder)) {
                }  
                        null
            // in the JSON. Since the stack can be large, it only checks the beginning of the JSON.  
        assertThat(parsed.getMetadataKeys(), hasSize(2));  
        try (XContentParser parser = createParser(xContent, throwableBytes)) {
                        "index_uuid": "_na_"
            failureBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
            ShardSearchFailure failure = new ShardSearchFailure(
        }
                new ParsingException(1, 2, "foobar", null),
        OpenSearchException expected;
                    + "\"caused_by\":{\"type\":\"illegal_argument_exception\",\"reason\":\"foo\"}}"  
    }  
                        new RepositoryException("repository_g", "Repo"),  
            OpenSearchException oneLevel = new OpenSearchException("foo", new RuntimeException("foobar"));  
/*
    public void testGenerateThrowableToXContent() throws IOException {  
                    List<String> values = new ArrayList<>();
                "foo",
        }  
            case 5: // Wrapped exception with cause
        // The exception content to parse is built using a XContentBuilder  
                "{\"type\":\"exception\",\"reason\":\"foo\",\"caused_by\":{\"type\":\"exception\","
        XContentBuilder builder = XContentBuilder.builder(xContent).startObject().value(e).endObject();
            String toXContentString = Strings.toString(MediaTypeRegistry.JSON, ex);  
package org.opensearch;
        assertThat(cause.getMetadataKeys(), hasSize(2));
                "bar",
                e.toXContent(builder, params);
                break;
    public void testStatus() {  
                        "line": 1,
        assertEquals(
        assertThat(cause.getMetadata("opensearch.bar_2"), hasItem("bar2"));
                assertNull(actualSuppressed);
            assertExceptionAsJson(ex, "{\"type\":\"parsing_exception\",\"reason\":\"foobar\",\"line\":1,\"col\":2}");
                    "all shards failed",
    }
    private static void assertExceptionAsJson(Exception e, String expectedJson) throws IOException {
import org.opensearch.core.common.bytes.BytesArray;  
        }
                throw new UnsupportedOperationException("Failed to generate randomized failure");
        {
                    expected.addHeader(entry.getKey(), entry.getValue());
 * this work for additional information regarding copyright
            Throwable[] expectedSuppressed = expected.getSuppressed();
            assertEquals(OpenSearchException.getExceptionName(rootCauses[0]), "parsing_exception");
        {  
        try (XContentParser parser = createParser(xContent, failureBytes)) {
                new OpenSearchException(
import org.opensearch.search.SearchContextMissingException;  
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
import org.opensearch.core.common.bytes.BytesReference;
                        new ShardSearchFailure(
        { // test equivalence
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
    public void testFailureToAndFromXContentWithDetails() throws IOException {  
                    "OpenSearch exception [type=search_phase_execution_exception, reason=all shards failed]",
            assertEquals(rootCauses.length, 1);  
                expected.addHeader("header_name", "0", "1");  
            assertEquals(expected, builder.toString());
                actual = new IllegalArgumentException("Closed resource", new RuntimeException("Resource"));
        final String expectedJson = "{"
        BytesReference throwableBytes = toShuffledXContent((builder, params) -> {
            cause.getMessage(),  
            assertEquals(expected.getResourceType(), actual.getResourceType());
        }
        }  
        builder = shuffleXContent(builder);
            assertEquals(expected, builder.toString());
                        "type": "query_shard_exception",
            assertEquals(rootCauses[0].getMessage(), "foobar");
                expected = new OpenSearchException("OpenSearch exception [type=search_parse_exception, reason=Parse failure]");
                new ParsingException(1, 2, "foobar", null),
        assertExceptionAsJson(e, expectedJson);  
        try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), expectedJson)) {  
            OpenSearchException.generateFailureXContent(builder, params, null, randomBoolean());
            if (randomBoolean()) {
            assertExceptionAsJson(e, "{\"type\":\"exception\",\"reason\":\"test\"}");  
            + "\"type\":\"exception\","
        }
            assertExceptionAsJson(  
        }
        assertEquals(
            final OpenSearchException[] foobars = OpenSearchException.guessRootCauses(new IllegalArgumentException("foobar"));
            parsed = OpenSearchException.fromXContent(parser);
                .endObject()
                .field("object_array_one", "value_one")  
            assertEquals("{\"type\":\"file_not_found_exception\",\"reason\":\"foo not found\"}", toXContentString);
                    }  
/*  
            "OpenSearch exception [type=cluster_block_exception, reason=blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];]"
 *  
                    "line": 1,  
            );  
            XContentBuilder builder = XContentFactory.jsonBuilder();
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 1), null, OriginalIndices.NONE)
            ShardSearchFailure failure1 = new ShardSearchFailure(  
            assertEquals("inner", causes[0].getMessage());  
                    expected.addMetadata(entry.getKey(), entry.getValue());
                builder.startObject();  
                suppressed.addMetadata("opensearch.lang", "painless");
            ex.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                "{\"type\":\"index_shard_recovering_exception\","  
                ex = new RemoteTransportException("foobar", new FileNotFoundException("foo not found"));
                {  
                    List<String> values = new ArrayList<>();  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            );
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),
                "foo",  
 * The OpenSearch Contributors require contributions made to  
            XContentParseException outer = new XContentParseException(null, "outer", inner);
                + "\"test1\":\"value1\",\"test2\":\"value2\","
        // of other types than list of strings.
                + "\"phase\":\"search\",\"grouped\":true,\"failed_shards\":[{\"shard\":1,\"index\":\"foo\",\"node\":\"node_1\","
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                suppressed.addMetadata("opensearch.script_stack", "stack");  
                "{\"type\":\"exception\",\"reason\":\"java.lang.IllegalArgumentException: foo\","
                    new ShardSearchFailure(
            + "\"reason\":\"blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];\""
/*  
                        new SearchShardTarget("node_g", new ShardId(new Index("_index_g", "_uuid_g"), 62), null, OriginalIndices.NONE)
            parsed = OpenSearchException.fromXContent(parser);
            OpenSearchException e = new BroadcastShardOperationFailedException(  
                  ],
                    "OpenSearch exception [type=node_closed_exception, " + "reason=node closed " + node + "]"
                failureCause = new NoShardAvailableActionException(new ShardId("_index_g", "_uuid_g", 6), "node_g", failureCause);
            try (XContentBuilder shuffledBuilder = shuffleXContent(builder)) {  
 * this file be licensed under the Apache-2.0 license or a
        OpenSearchException expectedCause;  
import org.opensearch.repositories.RepositoryException;
                }  
            ShardSearchFailure failure = new ShardSearchFailure(  
                      "reason": {
                Map<String, List<String>> randomHeaders = new HashMap<>(nbHeaders);
                  ],
            expected = (OpenSearchException) expected.getCause();
            ParsingException ex = new ParsingException(1, 2, "foobar", null);
                for (Map.Entry<String, List<String>> entry : randomMetadata.entrySet()) {  
            Throwable[] actualSuppressed = actual.getSuppressed();
        }
                actual = new SearchPhaseExecutionException(  
    }
        assertThat(cause.getHeaderKeys(), hasSize(2));
import static java.util.Collections.emptyList;
                    "type": "parsing_exception",  
            );
            + "\"caused_by\":{"  
                .field("type", "custom_exception")  
        assertThat(parsedException.getHeader("header_array_of_strings"), hasItems("foo", "bar", "baz"));
                .endArray()
        OpenSearchException parsed;  
                expectedCause.addMetadata("opensearch.index_uuid", "_na_");
        exception = new RemoteTransportException("test", new ResourceNotFoundException("test"));
     */
                );
        assertThat(parsed.getHeaderKeys(), hasSize(2));  
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
import org.opensearch.common.xcontent.XContentFactory;
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=exception, reason=foo]");
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
                    randomMetadata.put("opensearch.metadata_" + i, values);  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        assertThat(parsed.getMetadataKeys(), hasSize(1));
                  "grouped": true,
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)  
    public void testFromXContent() throws IOException {
                    for (int j = 0; j < nbValues; j++) {
                      "index": "foo1",
                int nbMetadata = randomIntBetween(1, 5);
                    int nbValues = randomIntBetween(1, 3);
        try (XContentParser parser = createParser(xContent, originalBytes)) {  
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 2), null, OriginalIndices.NONE)  
                for (int i = 0; i < nbResources; i++) {
                expected.addMetadata("opensearch.lang", "painless");
     * Test that some values like arrays of numbers are ignored when parsing back  
            assertNull(parser.nextToken());
            + "\"type\":\"exception\","
 * You may obtain a copy of the License at  
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=bar]");
                "all shards failed",
            assertEquals(1, ((ParsingException) rootCauses[0]).getLineNumber());  
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=bar]");
        e.addMetadata("opensearch.metadata_foo_0", "foo_0");
    }  
                        + "reason=blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];]"
            assertNull(parser.nextToken());
                    "Parsing failed",
            assertEquals(OpenSearchException.getExceptionName(rootCauses[0]), "index_not_found_exception");
    }
                .field("header_string", "some header")
        builder = shuffleXContent(builder);
                expectedCause.addMetadata("opensearch.index_uuid", "_uuid_g");
                    "OpenSearch exception [type=parsing_exception, " + "reason=Wrong state]",
        bar.addHeader("bar_1", "bar1");  
import java.util.List;
                actual = new OpenSearchException(
            ex.addMetadata("opensearch.test1", "value1");  
            expected.addSuppressed(suppressed.v2());
 */  
                expectedCause.addMetadata("opensearch.index", "idx");
                      "node": "node_1",
            );  
            XContentParseException outer = new XContentParseException(null, "outer", inner);  
                      "index": "foo",
        exception = new RemoteTransportException("test", new IllegalArgumentException("foobar"));
                    )  
                );
        }
                    "OpenSearch exception [type=routing_missing_exception, " + "reason=routing is required for [idx]/[id]]"
            String expected = XContentHelper.stripWhitespace("""
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=baz]");
        }
                new ShardSearchFailure[] { failure, failure1, failure2 }  
            assertExceptionAsJson(e, "{\"type\":\"illegal_state_exception\",\"reason\":\"bar\"}");
        assertThat(parsed.getHeaderKeys(), hasSize(1));
        assertEquals("OpenSearch exception [type=custom_exception, reason=Custom reason]", parsedException.getMessage());
        assertEquals(
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;  
            ShardSearchFailure failure2 = new ShardSearchFailure(
                .field("object_array_two", "value_two")  
        assertEquals(0, parsedFailure.getMetadata().size());  
                    actualException.setResources(resourceType, resourceIds);
        switch (type) {  
    public void testGetRootCause() {
            }
import java.util.Collections;
                .startObject("header")
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=exception, reason=foo]");
                actual = new ParsingException(3, 2, "Unknown identifier", null);  
                expectedCause = new OpenSearchException(  
            );
 * Unless required by applicable law or agreed to in writing,
        BytesReference failureBytes = toShuffledXContent((builder, params) -> {
            OpenSearchException ex = new OpenSearchException(
            // Prints a null failure using generateFailureXContent()
        assertThat(cause.getMetadataKeys(), hasSize(2));
     *  
            assertEquals(throwableString, toXContentString);  
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
 * license agreements. See the NOTICE file distributed with
                e,
                new ParsingException(1, 2, "foobar", null),  
            case 3: // JDK exception without cause
            assertEquals(causes.length, 1);
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
}
            if (randomBoolean()) {
     * @return whether there is a nested exception of the specified type
 * specific language governing permissions and limitations
            );  
            case 1: // Simple opensearch exception with headers (other metadata of type number are not parsed)
            failureBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
                failure = new IllegalStateException("D");
 * software distributed under the License is distributed on an
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
        );
                originalBytes = BytesReference.bytes(shuffledBuilder);
            case 2: // OpenSearch exception with a cause, headers and parsable metadata  
        XContentBuilder builder = XContentBuilder.builder(xContent).startObject().value(foo).endObject();
    }
                "all shards failed",  
import org.opensearch.action.NoShardAvailableActionException;
            OpenSearchException.generateThrowableXContent(builder, ToXContent.EMPTY_PARAMS, throwable);
                        "reason": "foobar",  
            }
import java.util.ArrayList;
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=exception, reason=foo]");
            .field("stack_trace", "...")
import org.opensearch.core.xcontent.XContent;
                OpenSearchException.generateThrowableXContent(builder, params, ex);
                expectedCause.addMetadata("opensearch.shard", "6");  
                    expectedCause
                    expected.setResources(resourceType, resourceIds);
            }  
                )
                expected.addSuppressed(suppressed);
                expected = new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=B]");
            assertThat(causes[0], instanceOf(OpenSearchException.class));  
    public void testGuessRootCause() {
import org.opensearch.index.IndexNotFoundException;  
    }
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),
            new OpenSearchException("bar", new IllegalArgumentException("index is closed", root))
        assertEquals(parsed.getHeader("foo_0").get(0), "0");
            OpenSearchException.generateThrowableXContent(builder, params, throwable);  
            + "\"reason\":\"baz\","
            "OpenSearch exception [type=routing_missing_exception, reason=routing is required for [_test]/[_id]]"  
                expected = new OpenSearchException("OpenSearch exception [type=exception, reason=Parsing failed]", expectedCause);
     * either it is of the given class itself or it contains a nested cause
            + "\"caused_by\":{"  
                new RemoteTransportException("abc", new IllegalArgumentException("foobar"))  
        assertEquals(
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),  
        }  
        {
            OpenSearchException ex = new RemoteTransportException("foobar", new FileNotFoundException("foo not found"));
            }
            );
            assertEquals("foobar", foobars[0].getMessage());
                }  
     * an exception.
            final OpenSearchException[] foobars = OpenSearchException.guessRootCauses(
        cause = (OpenSearchException) cause.getCause();
                expected = new OpenSearchException("OpenSearch exception [type=file_already_exists_exception, reason=File exists]");  
    public void testFailureToAndFromXContentWithNoDetails() throws IOException {  
            + "}"  
            } else {  
        }
        OpenSearchException cause = (OpenSearchException) parsed.getCause();
            assertThat(causes[0], instanceOf(OpenSearchException.class));
                      }
                    }  
        }  
            case 0: // Simple opensearch exception without cause
import org.opensearch.transport.RemoteTransportException;  
                int nbResources = randomIntBetween(1, 5);  
        {  
                actual = new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES));
            assertEquals("foo1", rootCauses[1].getIndex().getName());  
     * By default, the stack trace of the exception is not rendered. The parameter `errorTrace` forces the stack trace to
        assertThat(cause.getMetadata("opensearch.index_uuid"), hasItem("_na_"));
        OpenSearchException parsedFailure;
                .startObject()
    /**
                expectedCause = new OpenSearchException(
import org.opensearch.core.index.shard.ShardId;  
        );  
            parsedException = OpenSearchException.fromXContent(parser);
                suppressed = new OpenSearchException("OpenSearch exception [type=script_exception, reason=C]");
                  }
            final OpenSearchException[] causes = OpenSearchException.guessRootCauses(outer);
                expectedCause.addMetadata("opensearch.index", "_index_g");
            assertEquals("parsing_exception", OpenSearchException.getExceptionName(rootCauses[0]));  
                            new ParsingException(1, 2, "foobar", null),
                    String resourceType = "type_" + i;
            OpenSearchException actualException = (OpenSearchException) actual;
    public void testFromXContentWithIgnoredMetadataAndHeaders() throws IOException {  
        }  
            assertNull(parser.nextToken());  
            );  
import org.opensearch.common.UUIDs;
import org.opensearch.common.collect.Tuple;  
     */  
 * not use this file except in compliance with the License.
                assertNotNull(actual);
public class OpenSearchExceptionTests extends OpenSearchTestCase {
        assertNotNull(parsedException);
                  "caused_by": {
        assertThat(parsedException.getHeader("header_string"), hasItem("some header"));
                    for (int j = 0; j < resourceIds.length; j++) {
                    new ShardSearchFailure(
            )  
import org.opensearch.core.xcontent.XContentParseException;
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    }
    public void testToString() {  
                suppressed.addHeader("header_name", "0", "1");
import static org.hamcrest.Matchers.hasSize;  
import static org.hamcrest.Matchers.equalTo;
        assertThat(cause.getMetadataKeys(), hasSize(2));
                expected.addSuppressed(suppressed);  
                }
            );
import org.opensearch.core.index.Index;
            ex.addHeader("test", "some value");
                    + "\"reason\":\"bar\",\"caused_by\":{\"type\":\"illegal_argument_exception\",\"reason\":\"index is closed\","  
                );  
                .field("metadata_long", 1L)
            OpenSearchException e = new OpenSearchException("test");
        }
        {  
            if (randomBoolean()) {
            assertEquals(foobars.length, 1);
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
 *    http://www.apache.org/licenses/LICENSE-2.0
                ((OpenSearchException) failure).addHeader("script_name", "my_script");  
            builder.startObject()
        assertThat(cause.getMetadataKeys(), hasSize(2));  
            ShardSearchFailure failure1 = new ShardSearchFailure(
                expected.addSuppressed(  
            ShardSearchFailure failure = new ShardSearchFailure(  
        OpenSearchException parsed;
     * Builds a {@link ToXContent} using a JSON XContentBuilder and compares the result to the given json in string format.  
                for (int i = 0; i < nbHeaders; i++) {
        builder = shuffleXContent(builder);
                assertNull(actual);
            + "}"
                expected.addHeader("script_name", "my_script");
                + "[\"some value\",\"another value\"],\"test\":\"some value\"}}";
                ex,
            assertExceptionAsJson(ex, expected);
        }
        assertThat(cause.getMetadata("opensearch.index"), hasItem("_test"));
                    "OpenSearch exception [type=search_phase_execution_exception, " + "reason=G]",  
            ShardSearchFailure failure1 = new ShardSearchFailure(
                expectedCause = new OpenSearchException("OpenSearch exception [type=null_pointer_exception, reason=var is null]");
    }  
        }
                suppressed.addMetadata("opensearch.script", "test");
            );
                assertNull(actual);
                DiscoveryNode node = new DiscoveryNode("node_g", buildNewFakeTransportAddress(), Version.CURRENT);  
            String expected = "{\"type\":\"parsing_exception\",\"reason\":\"foobar\",\"line\":1,\"col\":2,"
        } while (expected != null);
        assertEquals(0, parsedFailure.getHeaders().size());
            );  
        );  
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
            assertEquals("inner", causes[0].getMessage());
    }
                    ),
                .field("metadata_int", 1)  
                    randomHeaders.put("header_" + i, values);
                    expectedCause
            .field("type", "foo")  
                + "\"caused_by\":{\"type\":\"null_pointer_exception\",\"reason\":null}}";  
                expected.addMetadata("opensearch.phase", "phase_g");  
        OpenSearchException bar = new OpenSearchException("bar", baz);
                      "reason": {  
                for (Map.Entry<String, List<String>> entry : randomHeaders.entrySet()) {
            ParsingException ex = new ParsingException(1, 2, "foobar", null);  
import org.opensearch.transport.client.transport.NoNodeAvailableException;
                break;
                .endObject()
                        "reason": "foobar",  
            final OpenSearchException[] rootCauses = ex.guessRootCauses();
                suppressed.addHeader("script_name", "my_script");  
        OpenSearchException exception = new OpenSearchException(
            assertEquals(expected.getResourceId(), actual.getResourceId());
                        "line": 1,
                    + "\"shard\":\"5\",\"index\":\"_test\"}"
                new OpenSearchException("bar", new IndexNotFoundException("foo", new RuntimeException("foobar")))  
                        values.add(frequently() ? randomAlphaOfLength(5) : "");  
import org.opensearch.search.SearchShardTarget;
            assertEquals(expected.getMessage(), actual.getMessage());
                List<String> keys = new ArrayList<>(parser.mapOrdered().keySet());  
                "search",
        for (int i = 0; i < suppressedCount; i++) {
        OpenSearchException cause = (OpenSearchException) parsed.getCause();  
                return builder;  
            case 1: // Simple opensearch exception with headers (other metadata of type number are not parsed)
            assertEquals("illegal_argument_exception", foobars[0].getExceptionName());  
                "{\"type\":\"exception\",\"reason\":\"foo\"," + "\"caused_by\":{\"type\":\"illegal_state_exception\",\"reason\":\"bar\"}}"
            try (XContentParser parser = createParser(xContent, throwableBytes)) {
            case 4:
            if (randomBoolean()) {  
        // Failure was null, expecting a "unknown" reason  
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 1), null, OriginalIndices.NONE)  
                    String[] resourceIds = new String[randomIntBetween(1, 3)];  
        }
            });
    /**
                expected = new OpenSearchException(
        switch (randomIntBetween(0, 6)) {  
            OpenSearchException[] rootCauses = exception.guessRootCauses();
                .endObject()
                      "shard": 1,
        try (XContentParser parser = createParser(xContent, failureBytes)) {  
    public static void assertDeepEquals(OpenSearchException expected, OpenSearchException actual) {
        {
                    {
                nullPointerException,
            cause.getMessage(),
import org.opensearch.index.query.QueryShardException;
                    ) };  
import java.io.FileNotFoundException;
        // because the current Java API does not allow to add metadata/headers
        assertEquals(OpenSearchException.buildMessage("exception", reason, null), parsedFailure.getMessage());  
        assertDeepEquals(expected, parsedFailure);
            if (expected == null) {
        exception = new ConcurrentSnapshotExecutionException("testRepo", "testSnap", "test");
        }
import java.io.IOException;
                "search",
            case 3:
                break;
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                            new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)  
            new OpenSearchException(  
                break;
            case 5:  
    }
import static org.hamcrest.Matchers.startsWith;
            "foo",
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=bar]");
        foo.addHeader("foo_1", "foo1");
                  "grouped": true,
            assertEquals("no such index [foo]", rootCauses[0].getMessage());
                    {  
            assertEquals("exception", causes[0].getExceptionName());
            default:  
            builder.startObject();  
        assertSame(exception.status(), RestStatus.CONFLICT);
            );
            parsedFailure = OpenSearchException.failureFromXContent(parser);
                "foo",
                    "{\"type\":\"exception\",\"reason\":\"foo\","
import org.opensearch.common.xcontent.XContentType;  
        try (XContentParser parser = createParser(xContent, failureBytes)) {
        {
        String reason = ExceptionsHelper.summaryMessage(failure);
import static java.util.Collections.singleton;
                "all shards failed",  
        }  
 * KIND, either express or implied.  See the License for the
    public void testToXContent() throws IOException {  
                );
            "foo",
        {
        e.addHeader("foo_1", "1");  
                  "reason": "all shards failed",
        OpenSearchException exception = new OpenSearchException("test");
                    "reason": "foobar",
            XContentParseException inner = new XContentParseException(null, "inner");
                suppressed = new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=E]");
            );
                expected.addSuppressed(new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=Parsing g]"));
                        values.add(frequently() ? randomAlphaOfLength(5) : "");
            "OpenSearchException[foo]; nested: OpenSearchException[bar]; nested: IllegalArgumentException"  
                "all shards failed",
            String expected = XContentHelper.stripWhitespace("""
                Collections.singletonMap(OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE, "false")
        {
        }
                    }
        final XContent xContent = randomFrom(XContentType.values()).xContent();  
        RoutingMissingException routing = new RoutingMissingException("_test", "_id");
        assertEquals(2, parsedException.getHeaderKeys().size());  
            OpenSearchException inner = new OpenSearchException("inner");
            if (randomBoolean()) {  
                        + "\"caused_by\":{\"type\":\"illegal_state_exception\",\"reason\":\"bar\","  
        assertThat(cause.getMetadata("opensearch.bar_0"), hasItem("bar0"));  
                        + "\"stack_trace\":\"java.lang.IllegalStateException: bar"
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=foo, reason=something went wrong, stack_trace=...]");  
            parsedException = OpenSearchException.fromXContent(parser);
        {
        );
        }  
                    new ShardSearchFailure[] {  
        OpenSearchException baz = new OpenSearchException("baz", routing);
import org.opensearch.node.NodeClosedException;  
            }
                break;  
            }
                );  
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
        OpenSearchException parsed;
        }
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(foobars[0], instanceOf(OpenSearchException.class));  
                expected.addSuppressed(suppressed);
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));
        bar.addMetadata("opensearch.bar_0", "bar0");
        OpenSearchException e = new OpenSearchException(
            + "\"reason\":\"foo\","  
            OpenSearchException.generateFailureXContent(builder, params, finalFailure, true);  
        assertNotNull(parsed);  
        OpenSearchException parsedException;
                break;
    }
            builder.endObject();
                    assertDeepEquals((OpenSearchException) expectedSuppressed[i], (OpenSearchException) actualSuppressed[i]);
     * Check whether this exception contains an exception of the given type:  
                    actualException.addHeader("ignored", randomBoolean() ? emptyList() : null);  
                      "node": "node_1",  
                    actualException.addMetadata(entry.getKey(), entry.getValue());
                      "node": "node_1",  
        OpenSearchException foo = new OpenSearchException("foo", bar);
                failure = new SearchPhaseExecutionException("phase_g", "G", failureCause, shardFailures);
                + "[index is closed]; nested: RuntimeException[foobar];",
        assertFalse(contains(exception, EOFException.class));  
        try (XContentParser parser = createParser(xContent, failureBytes)) {
        assertNull(parsedFailure.getCause());  
                    + "\"caused_by\":{\"type\":\"runtime_exception\",\"reason\":\"foobar\"}}}}"
            case 6: // SearchPhaseExecutionException with cause and multiple failures
import org.opensearch.core.xcontent.XContentParser;
        );
        OpenSearchException parsedException;
            .field("reason", "something went wrong")
        assertNotNull(parsed);
        if (exType == null) {
            + "\"foo_0\":\"0\","
                failureCause = new RoutingMissingException("idx", "id");
            } else {  
                """);  
            return builder;
            parsedFailure = OpenSearchException.failureFromXContent(parser);
    public void testUnknownFailureToAndFromXContent() throws IOException {  
            final OpenSearchException[] causes = OpenSearchException.guessRootCauses(outer);  
            new OpenSearchException("bar", new IllegalArgumentException("index is closed", new RuntimeException("foobar")))  
                ex = new FileNotFoundException("foo not found");
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            assertEquals("foobar", rootCauses[0].getMessage());
                        + (Constants.WINDOWS ? "\\r\\n" : "\\n")
                "all shards failed",
    public void testFromXContentWithHeadersAndMetadata() throws IOException {  
                expected.addMetadata("opensearch.phase", "search");
        }
                );  
            OpenSearchException exception = new OpenSearchException(
        try (XContentBuilder builder = XContentBuilder.builder(xContent)) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertEquals("foobar", foobars[0].getMessage());
                }
                }
                break;
            new OpenSearchException("bar", new OpenSearchException("baz", new RoutingMissingException("_test", "_id")))  
        exception = new OpenSearchException("test", new ResourceNotFoundException("test"));
                    }
                + "\"reason\":{\"type\":\"parsing_exception\",\"reason\":\"foobar\",\"line\":1,\"col\":2}}],"
        OpenSearchException suppressed;
        final XContent xContent = randomFrom(XContentType.values()).xContent();  
            XContentBuilder builder = XContentFactory.jsonBuilder();
    public static Tuple<Throwable, OpenSearchException> randomExceptions() {
        assertNotNull(parsed);  
            OpenSearchException.generateFailureXContent(builder, params, failure, false);
            "foo",
        final XContent xContent = randomFrom(XContentType.values()).xContent();
            assertNull(parser.nextToken());
            ex.addHeader("test_multi", "some value", "another value");  
        foo.addMetadata("opensearch.foo_0", "foo0");  
            + "\"foo_1\":\"1\""
            assertExceptionAsJson(  
            NullPointerException nullPointerException = new NullPointerException();  
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
                    // Empty or null headers are not printed out by the toXContent method
import static org.hamcrest.CoreMatchers.hasItems;
                    new OpenSearchException(
            assertEquals(IllegalArgumentException.class, foobars[0].getCause().getClass());  
                failure = new NoNodeAvailableException("A");
            + "}"  
        final Throwable throwable = exceptions.v1();
                .startArray("metadata_array_of_objects")
        int type = randomIntBetween(0, 5);
                    "col": 2
            assertNull(parser.nextToken());  
            assertEquals("foo", rootCauses[0].getMessage());  
        Exception finalFailure = failure;
                .field("object_field", "value")  
import static org.hamcrest.Matchers.instanceOf;
            );
            assertNull(parser.nextToken());
            assertEquals("foobar", rootCauses[1].getMessage());
        }
 * the Apache License, Version 2.0 (the "License"); you may
        return new Tuple<>(actual, expected);  
                "search",  
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));
        {
        assertEquals(parsed.getMetadata("opensearch.metadata_foo_0").get(0), "foo_0");
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)  
        {
            + "\"metadata_foo_1\":\"foo_1\","
        assertThat(parsed.getHeader("foo_1"), hasItem("foo1"));  
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=baz]");
import org.opensearch.script.ScriptException;
            default:  
            builder.endObject();
                expected = new OpenSearchException(  
        final Exception failure = (Exception) randomExceptions().v1();  
                expected = new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=E]", expectedCause);  
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
import org.opensearch.action.search.ShardSearchFailure;  
                expected = new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=Unknown identifier]");
            assertExceptionAsJson(  
                  "phase": "search",  
                    int nbValues = randomIntBetween(1, 3);
                expected.addSuppressed(suppressed);  
import static org.opensearch.test.TestSearchContext.SHARD_TARGET;
        Exception root = new RuntimeException("foobar");
    }
                new ShardSearchFailure[] { failure, failure1 }
import static java.util.Collections.singletonList;  
                    new OpenSearchException("OpenSearch exception [type=repository_exception, " + "reason=[repository_g] Repo]")
                );  
                expected.addSuppressed(new OpenSearchException("OpenSearch exception [type=no_node_available_exception, reason=A]"));
        BytesReference actual = org.opensearch.core.xcontent.XContentHelper.toXContent(e, MediaTypeRegistry.JSON, randomBoolean());  
                failureCause = new FileAlreadyExistsException("File exists");  
        cause = (OpenSearchException) cause.getCause();
            "OpenSearch exception [type=routing_missing_exception, reason=routing is required for [_test]/[_id]]"
import org.opensearch.search.SearchParseException;
            );
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
            assertEquals("exception", OpenSearchException.getExceptionName(rootCauses[0]));
                new ParsingException(1, 2, "foobar", null),
            }  
            try (XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
                expectedCause = new OpenSearchException(  
                );  
            );  
            assertEquals(expected, builder.toString());
            builder.startObject();
                  "type": "search_phase_execution_exception",
                    for (int j = 0; j < nbValues; j++) {  
            String actual;
                new IllegalStateException("bar")  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            + "\"header\":{"  
                .endObject()
        e.addMetadata("opensearch.metadata_foo_1", "foo_1");
                failureCause = new NodeClosedException(node);
                }
            );
            builder.startObject();  
            assertExceptionAsJson(e, "{\"type\":\"search_parse_exception\",\"reason\":\"foo\",\"line\":1,\"col\":0}");
 * Licensed to Elasticsearch under one or more contributor  
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
            rootCauses = oneLevel.guessRootCauses();
        final Tuple<Throwable, OpenSearchException> exceptions = randomExceptions();
                        new SearchShardTarget("node_g", new ShardId(new Index("_index_g", "_uuid_g"), 61), null, OriginalIndices.NONE)  
            ToXContent.Params params = new ToXContent.MapParams(
        BytesReference failureBytes = toShuffledXContent((builder, params) -> {  
        Exception failure;  
                for (int i = 0; i < nbMetadata; i++) {
        OpenSearchException e = new OpenSearchException(
            cause.getMessage(),  
            .endObject();  
                break;
        assertThat(parsedException.getMetadata("opensearch.metadata_other"), hasItem("some metadata"));
            return builder;  
        assertThat(cause.getHeaderKeys(), hasSize(0));  
            assertEquals("query_shard_exception", OpenSearchException.getExceptionName(rootCauses[1]));
            }
                for (int i = 0; i < expectedSuppressed.length; i++) {  
                expected.addSuppressed(  
                )
        assertThat(cause.getHeaderKeys(), hasSize(0));
            assertEquals(expected.getHeaders(), actual.getHeaders());
                new ParsingException(1, 2, "foobar", null),
                    actualException.addMetadata("opensearch.ignored", randomBoolean() ? emptyList() : null);
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
    private static boolean contains(Throwable t, Class<? extends Throwable> exType) {
        cause = (OpenSearchException) cause.getCause();
                  }
            "foo",
                new ParsingException(1, 2, "foobar", null),
                assertEquals("last index should be [suppressed]", "suppressed", keys.get(keys.size() - 1));
                    "baz",  
                failureCause = new NullPointerException("var is null");
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
                failure = new BroadcastShardOperationFailedException(new ShardId("_index", "_uuid", 5), "F", failureCause);
 */
        assertThat(cause.getMetadata("opensearch.baz_1"), hasItem("baz1"));  
                int nbHeaders = randomIntBetween(1, 5);
        assertEquals(root, exception.getRootCause());
        baz.addMetadata("opensearch.baz_1", "baz1");
import org.apache.lucene.util.Constants;
            assertEquals(causes.length, 1);
                );
        }
        }  
 * GitHub history for details.
                new ShardId("_index", "_uuid", 12),
        cause = (OpenSearchException) cause.getCause();
        OpenSearchException parsedFailure;  
            String throwableString = Strings.toString(MediaTypeRegistry.JSON, (builder, params) -> {
            OpenSearchException e = new OpenSearchException(new IllegalArgumentException("foo"));
                actual = new SearchParseException(SHARD_TARGET, "Parse failure", new XContentLocation(12, 98));
        );
                rootCauses = OpenSearchException.guessRootCauses(randomBoolean() ? new RemoteTransportException("remoteboom", ex) : ex);
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
        cause = (OpenSearchException) cause.getCause();  
        XContentBuilder builder = XContentBuilder.builder(xContent)
        assertEquals(parsed.getHeader("foo_1").get(0), "1");
        }  
        OpenSearchException parsedFailure;
            assertNull(parser.nextToken());  
 * under the License.  
            XContentBuilder builder = XContentFactory.jsonBuilder();
                    "col": 2  
            parsed = OpenSearchException.fromXContent(parser);  
                {  
                );  
        try (XContentParser parser = createParser(xContent, failureBytes)) {  
                Map<String, List<String>> randomMetadata = new HashMap<>(nbMetadata);  
            } else {  
 * compatible open source license.
                        "type": "parsing_exception",
        {
                    new ShardSearchFailure(  
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 2), null, OriginalIndices.NONE)
            Exception ex;
     */
                        new SearchContextMissingException(new ShardSearchContextId(UUIDs.randomBase64UUID(), 0L)),
                        "col": 2
                    new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=Resource]")
                rootCauses = (randomBoolean() ? new RemoteTransportException("remoteboom", ex) : ex).guessRootCauses();
                        + "\\tat org.opensearch."  
                  "failed_shards": [
        final XContent xContent = randomFrom(XContentType.values()).xContent();  
            );
        try (XContentParser parser = createParser(xContent, BytesReference.bytes(builder))) {
                expected.addMetadata("opensearch.script", "test");  
            parsed = OpenSearchException.fromXContent(parser);
                    "OpenSearch exception [type=illegal_argument_exception, reason=Closed resource]",
                      }  
            String expected = "{\"type\":\"search_phase_execution_exception\",\"reason\":\"all shards failed\","  
                builder.endObject();
                expected = new OpenSearchException(  
        assertThat(cause.getMetadata("opensearch.index"), hasItem("_test"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            ShardSearchFailure failure1 = new ShardSearchFailure(  
                    + "\"reason\":\"CurrentState[RECOVERING] Already recovering\",\"index_uuid\":\"_0\","
        assertDeepEquals(expected, parsedException);
        assertThat(cause.getHeader("bar_1"), hasItem("bar1"));
            + "\"type\":\"exception\","
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                suppressed = new OpenSearchException("OpenSearch exception [type=file_already_exists_exception, reason=File exists]");
            + "},"
        assertThat(parsed.getMetadata("opensearch.foo_0"), hasItem("foo0"));
        try (XContentParser parser = createParser(builder)) {
                        new ParsingException(0, 0, "Parsing g", null),
                actual,  
            assertEquals(rootCauses.length, 2);  
import org.opensearch.cluster.block.ClusterBlockException;
            final Tuple<Throwable, OpenSearchException> suppressed = randomExceptions();  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
import org.opensearch.index.shard.IndexShardRecoveringException;
    }  
                    {  
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        }  
    }
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        BytesReference originalBytes;  
            builder.startObject();
import org.opensearch.action.OriginalIndices;  
                  "reason": "all shards failed",
                        "reason": "foobar",
import java.io.EOFException;  
            case 0:
                randomBoolean() ? failure1.getCause() : failure.getCause(),
            ShardSearchFailure failure = new ShardSearchFailure(
                    new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES))
                if (rarely()) {
    }
        e.addHeader("foo_0", "0");
                    "OpenSearch exception [type=cluster_block_exception, "
    }
            );  
        {
            }
        );
            }
    public void testToXContentWithHeadersAndMetadata() throws IOException {  
                .endObject();
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=baz]");
            ShardSearchFailure failure = new ShardSearchFailure(
                        ) }
                """);
            );  
                expected.addSuppressed(suppressed);
                    actualException.addHeader(entry.getKey(), entry.getValue());  
            exception.toString()
        assertNotNull(parsed);
                expected = new OpenSearchException(  
import org.opensearch.search.internal.ShardSearchContextId;  
                break;  
            if (expected == null) {
        Throwable actual;
                "search",  
        baz.addHeader("baz_0", "baz0");  
                    "OpenSearch exception [type=no_shard_available_action_exception, " + "reason=node_g]",
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),
            XContentBuilder builder = XContentBuilder.builder(xContent);
            } else {  
        assertEquals(0, parsedFailure.getHeaders().size());
        final XContent xContent = randomFrom(XContentType.values()).xContent();
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        exception = new RemoteTransportException("test", new IllegalStateException("foobar"));
                suppressed = new OpenSearchException("OpenSearch exception [type=illegal_state_exception, reason=D]");
        }  
        if (actual instanceof OpenSearchException) {
            throwableBytes = BytesReference.bytes(builder);  
                        "index": "foo1",  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
    }
                OpenSearchException expectedCause = new OpenSearchException(  
        {
                new ParsingException(1, 2, "foobar", null),  
        assertEquals(1, parsedException.getMetadataKeys().size());  
                }
        OpenSearchException parsed;
                  "failed_shards": [
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(  
                break;
                    }
                }  
                new ShardSearchFailure[] { failure, failure1 }
import org.opensearch.action.search.SearchPhaseExecutionException;
                      "index": "foo",
        exception = new OpenSearchException("test", new RuntimeException());
        OpenSearchException exception = new OpenSearchException(  
            assertEquals("x_content_parse_exception", causes[0].getExceptionName());
        assertEquals(0, parsedFailure.getMetadata().size());
 *
            return builder;
            );
import static org.hamcrest.CoreMatchers.hasItem;  
        {  
        {
                assertEquals(expectedSuppressed.length, actualSuppressed.length);
                      }  
            );
                e,
    }  
        assertThat(cause.getHeader("baz_2"), hasItem("baz2"));
                failure = new ScriptException("C", failureCause, singletonList("stack"), "test", "painless");
                      "shard": 1,
     * of the given type.
            + "\"metadata_foo_0\":\"foo_0\","
        Throwable failureCause;
        assertTrue(contains(exception, RuntimeException.class));
        }  
                      "shard": 1,  
            }  
        final XContent xContent = randomFrom(XContentType.values()).xContent();
        assertEquals(parsed.getMetadata("opensearch.metadata_foo_1").get(0), "foo_1");
        final OpenSearchException expected = exceptions.v2();  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.XContentLocation;  
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
            case 4: // JDK exception with cause  
            assertEquals(foobars.length, 1);  
    private static void assertToXContentAsJson(ToXContent e, String expectedJson) throws IOException {
                        resourceIds[j] = frequently() ? randomAlphaOfLength(5) : "";
            assertThat(foobars[0], instanceOf(OpenSearchException.class));
            assertNull(parser.nextToken());  
                expected.addMetadata("opensearch.script_stack", "stack");
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
                .array("metadata_array_of_ints", new int[] { 8, 13, 21 })
            assertExceptionAsJson(ex, "{\"type\":\"file_not_found_exception\",\"reason\":\"foo not found\"}");  
import org.opensearch.core.common.ParsingException;
            assertEquals(nullPointerException, ex.getCause());
        assertThat(cause.getMetadata("opensearch.index_uuid"), hasItem("_na_"));  
        OpenSearchException cause = (OpenSearchException) parsed.getCause();
import java.util.Map;
import org.opensearch.core.rest.RestStatus;
            assertThat(
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
                        "OpenSearch exception [type=search_context_missing_exception, " + "reason=No search context found for id [0]]"
            // Test the same exception but with the "rest.exception.stacktrace.skip" parameter disabled: the stack_trace must be present
 * ownership. Elasticsearch licenses this file to you under  
        }
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            ex.addMetadata("opensearch.test2", "value2");
                .startObject()
                new ShardSearchFailure[] { failure, failure1, failure2 }
        assertEquals("OpenSearch exception [type=exception, reason=unknown]", parsedFailure.getMessage());
        final XContent xContent = randomFrom(XContentType.values()).xContent();
    public void testDeduplicate() throws IOException {  
    public void testFromXContentWithCause() throws IOException {  
        }  
                ((OpenSearchException) failure).addHeader("header_name", "0", "1");
            return builder;  
        OpenSearchException expected;  
                "search",
        { // render header and metadata
            ex.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        int suppressedCount = randomBoolean() ? 0 : between(1, 5);
import java.nio.file.FileAlreadyExistsException;  
        final XContent xContent = randomFrom(XContentType.values()).xContent();
                failure = new ParsingException(3, 2, "B", null);  
                      "reason": {
        bar.addMetadata("opensearch.bar_2", "bar2");
                break;
        }
                  "phase": "search",  
import org.opensearch.core.common.Strings;
                    new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=foobar]")
 * SPDX-License-Identifier: Apache-2.0
            case 2:  
        }
            ex.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertThat(cause.getMetadata("opensearch.baz_3"), hasItem("baz3"));
        }
     * be rendered like the REST API does when the "error_trace" parameter is set to true.  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
import org.opensearch.snapshots.ConcurrentSnapshotExecutionException;
            );  
        assertThat(cause.getHeader("baz_0"), hasItem("baz0"));  
            if (exType.isInstance(cause)) {  
                .array("metadata_array_of_boolean", new boolean[] { false, false })  
            OpenSearchException.generateThrowableXContent(builder, params, e);  
                    },
                ShardSearchFailure[] shardFailures = new ShardSearchFailure[] {  
        assertNotNull(parsedFailure);  
        BytesReference failureBytes = toShuffledXContent((builder, params) -> {
            builder.endObject();
            + "\"caused_by\":{"  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                .array("header_array_of_strings", new String[] { "foo", "bar", "baz" })  
                  "caused_by": {  
import org.opensearch.action.RoutingMissingException;
                    "search",
    }
                        "col": 2
            assertEquals("illegal_argument_exception", foobars[0].getExceptionName());
                e,
 *
                .startObject("metadata_object")
            OpenSearchException e = new OpenSearchException("foo", new IllegalStateException("bar"));
            + "}";
            + "\"reason\":\"bar\","
        for (Throwable cause = t; t != null; t = t.getCause()) {
                .array("metadata_array_of_longs", new long[] { 2L, 3L, 5L })
    /**
                );
                suppressed = new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=B]");
                break;  
                }
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
                startsWith(
                throw new UnsupportedOperationException("No randomized exceptions generated for type [" + type + "]");
        assertToXContentEquivalent(new BytesArray(expectedJson), actual, MediaTypeRegistry.JSON);
            ShardSearchFailure failure1 = new ShardSearchFailure(
     * <p>
            parsedFailure = OpenSearchException.failureFromXContent(parser);  
        exception = new RemoteTransportException("test", new ResourceAlreadyExistsException("test"));
                new ShardSearchFailure[] { failure, failure1 }
                assertNotNull(actualSuppressed);
                );
import org.opensearch.core.xcontent.ToXContent;  
            OpenSearchException e = new IndexShardRecoveringException(new ShardId("_test", "_0", 5));  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
                .field("metadata_other", "some metadata")  
                    "line": 1,
        if (suppressedCount > 0) {
            );
                actual = builder.toString();  
        }  
            assertEquals(IllegalArgumentException.class, foobars[0].getCause().getClass());
        cause = (OpenSearchException) cause.getCause();  
        assertThat(cause.getHeaderKeys(), hasSize(1));  
                expected = new OpenSearchException("OpenSearch exception [type=script_exception, reason=C]", expectedCause);  
                    ),
import java.util.HashMap;  
            assertNull(parser.nextToken());
            return false;  
            assertEquals(2, ((ParsingException) rootCauses[0]).getColumnNumber());
                    new OpenSearchException("OpenSearch exception [type=null_pointer_exception, " + "reason=Unexpected null value]")
            actual = (OpenSearchException) actual.getCause();  
 */  
            OpenSearchException e = new SearchParseException(SHARD_TARGET, "foo", new XContentLocation(1, 0));
                expected = new OpenSearchException("OpenSearch exception [type=no_node_available_exception, reason=A]");
                    // Empty or null metadata are not printed out by the toXContent method  
            if (expectedSuppressed == null) {
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
        {
                new OpenSearchException("bar", new IllegalArgumentException("index is closed", new RuntimeException("foobar")))
