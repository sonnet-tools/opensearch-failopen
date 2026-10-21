                expectedCause.addMetadata("opensearch.shard", "6");
                new ParsingException(1, 2, "foobar", null),
        XContentBuilder builder = XContentBuilder.builder(xContent).startObject().value(e).endObject();
                    new OpenSearchException("OpenSearch exception [type=null_pointer_exception, " + "reason=Unexpected null value]")
            }
    public void testToXContent() throws IOException {
            OpenSearchException e = new IndexShardRecoveringException(new ShardId("_test", "_0", 5));
                + "\"reason\":{\"type\":\"parsing_exception\",\"reason\":\"foobar\",\"line\":1,\"col\":2}}],"
                        new ParsingException(0, 0, "Parsing g", null),
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 2), null, OriginalIndices.NONE)
                      "reason": {
            new OpenSearchException(
            XContentParseException outer = new XContentParseException(null, "outer", inner);
        assertThat(parsed.getMetadata("opensearch.foo_0"), hasItem("foo0"));
            );
                    + "\"caused_by\":{\"type\":\"runtime_exception\",\"reason\":\"foobar\"}}}}"
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            default:
                new ParsingException(1, 2, "foobar", null),
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
        if (actual instanceof OpenSearchException) {
            return builder;
            if (expected == null) {
                .array("metadata_array_of_longs", new long[] { 2L, 3L, 5L })
            );
                expected = new OpenSearchException(
import org.opensearch.search.SearchParseException;
            builder.endObject();
        assertSame(exception.status(), RestStatus.CONFLICT);
                break;
                suppressed = new OpenSearchException("OpenSearch exception [type=file_already_exists_exception, reason=File exists]");
            assertNull(parser.nextToken());
            assertNull(parser.nextToken());
            String toXContentString = Strings.toString(MediaTypeRegistry.JSON, ex);
                    }
            "OpenSearch exception [type=cluster_block_exception, reason=blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];]"
            assertNull(parser.nextToken());
    }
            "OpenSearch exception [type=routing_missing_exception, reason=routing is required for [_test]/[_id]]"
            String expected = "{\"type\":\"parsing_exception\",\"reason\":\"foobar\",\"line\":1,\"col\":2,"
        exception = new RemoteTransportException("test", new IllegalStateException("foobar"));
                startsWith(
            assertEquals(IllegalArgumentException.class, foobars[0].getCause().getClass());
            try (XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
        assertThat(parsed.getMetadataKeys(), hasSize(1));
        assertThat(cause.getHeader("baz_0"), hasItem("baz0"));
        OpenSearchException exception = new OpenSearchException("test");
            if (expectedSuppressed == null) {
        }
            OpenSearchException e = new OpenSearchException("foo", new IllegalStateException("bar"));
                new ShardSearchFailure[] { failure, failure1 }
            String throwableString = Strings.toString(MediaTypeRegistry.JSON, (builder, params) -> {
            // in the JSON. Since the stack can be large, it only checks the beginning of the JSON.
        assertThat(cause.getMetadataKeys(), hasSize(2));
                    actualException.addMetadata("opensearch.ignored", randomBoolean() ? emptyList() : null);
                );
                      "node": "node_1",
import org.opensearch.index.shard.IndexShardRecoveringException;
        assertThat(parsed.getHeaderKeys(), hasSize(1));
                break;
    private static boolean contains(Throwable t, Class<? extends Throwable> exType) {
                        ) }
        OpenSearchException parsed;
                break;
import org.opensearch.action.RoutingMissingException;
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=bar]");
        assertThat(cause.getMetadata("opensearch.bar_0"), hasItem("bar0"));
                }
            + "\"metadata_foo_1\":\"foo_1\","
                    new ParsingException(9, 42, "Wrong state", new NullPointerException("Unexpected null value"))
        );
            + "}"
                assertNotNull(actualSuppressed);
                .endArray()
import static org.hamcrest.CoreMatchers.hasItem;
                if (rarely()) {
            assertEquals(OpenSearchException.getExceptionName(rootCauses[0]), "parsing_exception");
import org.opensearch.common.xcontent.XContentHelper;
            );
        }
                suppressed.addMetadata("opensearch.script", "test");
            builder.startObject();
                new ParsingException(1, 2, "foobar", null),
                expected.addHeader("script_name", "my_script");
                "foo",
        assertToXContentEquivalent(new BytesArray(expectedJson), actual, MediaTypeRegistry.JSON);
        { // render header and metadata
            ex.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    {
            + "\"reason\":\"bar\","
            assertEquals(expected.getHeaders(), actual.getHeaders());
        }
        {
                suppressed = new OpenSearchException("OpenSearch exception [type=illegal_state_exception, reason=D]");
            + "\"caused_by\":{"
        exception = new RemoteTransportException("test", new ResourceAlreadyExistsException("test"));
        try (XContentParser parser = createParser(builder)) {
        assertThat(parsedException.getMetadata("opensearch.metadata_other"), hasItem("some metadata"));
import org.opensearch.core.xcontent.ToXContent;
            try (XContentBuilder shuffledBuilder = shuffleXContent(builder)) {
 *
        assertDeepEquals(expected, parsedFailure);
            assertEquals(expected, builder.toString());
    public void testGuessRootCause() {
            XContentParseException inner = new XContentParseException(null, "inner");
     */
                .endObject()
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
import org.opensearch.test.OpenSearchTestCase;
                    "type": "parsing_exception",
        assertEquals(parsed.getHeader("foo_0").get(0), "0");
                expected = new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=Unknown identifier]");
            assertEquals("parsing_exception", OpenSearchException.getExceptionName(rootCauses[0]));
import static org.hamcrest.Matchers.hasSize;
                new IllegalStateException("bar")
            "OpenSearchException[foo]; nested: OpenSearchException[bar]; nested: IllegalArgumentException"
import static org.hamcrest.Matchers.startsWith;
 * Licensed to Elasticsearch under one or more contributor
                        "reason": "foobar",
            + "}"
    private static void assertExceptionAsJson(Exception e, String expectedJson) throws IOException {
            throwableBytes = BytesReference.bytes(builder);
                      "shard": 1,
                    "{\"type\":\"exception\",\"reason\":\"foo\","
                    int nbValues = randomIntBetween(1, 3);
        assertThat(cause.getHeaderKeys(), hasSize(2));
        BytesReference failureBytes = toShuffledXContent((builder, params) -> {
        assertNotNull(parsed);
                expected = new OpenSearchException("OpenSearch exception [type=illegal_state_exception, reason=D]");
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
                break;
        }
                return builder;
        assertThat(cause.getMetadata("opensearch.baz_3"), hasItem("baz3"));
        assertEquals(0, parsedFailure.getHeaders().size());
    public static void assertDeepEquals(OpenSearchException expected, OpenSearchException actual) {
    private static void assertToXContentAsJson(ToXContent e, String expectedJson) throws IOException {
            assertExceptionAsJson(ex, "{\"type\":\"parsing_exception\",\"reason\":\"foobar\",\"line\":1,\"col\":2}");
 * KIND, either express or implied.  See the License for the
                {
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 1), null, OriginalIndices.NONE)
        BytesReference throwableBytes = toShuffledXContent((builder, params) -> {
                failure = new ScriptException("C", failureCause, singletonList("stack"), "test", "painless");
            new OpenSearchException("bar", new IllegalArgumentException("index is closed", root))
        assertNotNull(parsed);
            if (randomBoolean()) {
import org.opensearch.core.common.bytes.BytesReference;
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
                      "index": "foo1",
                expected.addSuppressed(suppressed);
            OpenSearchException e = new OpenSearchException(new IllegalArgumentException("foo"));
                Collections.singletonMap(OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE, "false")
        OpenSearchException e = new OpenSearchException(
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            );
                suppressed = new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=B]");
            XContentBuilder builder = XContentBuilder.builder(xContent);
                .array("metadata_array_of_boolean", new boolean[] { false, false })
import org.opensearch.core.xcontent.XContentParser;
                    randomHeaders.put("header_" + i, values);
            builder.startObject();
                }
            );
        }
    }
            assertEquals("query_shard_exception", OpenSearchException.getExceptionName(rootCauses[1]));
            ToXContent.Params params = new ToXContent.MapParams(
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),
            }
            case 5: // Wrapped exception with cause
                actual = new IllegalArgumentException("Closed resource", new RuntimeException("Resource"));
            }
import java.nio.file.FileAlreadyExistsException;
import org.opensearch.script.ScriptException;
            assertEquals(expected, builder.toString());
        foo.addHeader("foo_1", "foo1");
            cause.getMessage(),
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=foo, reason=something went wrong, stack_trace=...]");
            .field("type", "foo")
import java.util.List;
                failure = new IllegalStateException("D");
        assertToXContentAsJson((builder, params) -> {
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
                assertNull(actualSuppressed);
                  }
        }
        assertThat(cause.getHeaderKeys(), hasSize(1));
import org.opensearch.core.index.Index;
            assertExceptionAsJson(
        assertThat(cause.getMetadata("opensearch.bar_2"), hasItem("bar2"));
        {
                  "caused_by": {
                    "col": 2
        assertThat(cause.getMetadata("opensearch.index"), hasItem("_test"));
                "all shards failed",
            OpenSearchException ex = new RemoteTransportException("foobar", new FileNotFoundException("foo not found"));
        OpenSearchException baz = new OpenSearchException("baz", routing);
import static org.hamcrest.Matchers.instanceOf;
                      "index": "foo",
        BytesReference actual = org.opensearch.core.xcontent.XContentHelper.toXContent(e, MediaTypeRegistry.JSON, randomBoolean());
            if (randomBoolean()) {
                    "OpenSearch exception [type=routing_missing_exception, " + "reason=routing is required for [idx]/[id]]"
        try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), expectedJson)) {
                        new SearchShardTarget("node_g", new ShardId(new Index("_index_g", "_uuid_g"), 61), null, OriginalIndices.NONE)
        {
            builder.endObject();
                actual = new ParsingException(3, 2, "Unknown identifier", null);
                      }
                .endObject();
                expected.addMetadata("opensearch.phase", "search");
        }
            );
        final XContent xContent = randomFrom(XContentType.values()).xContent();
                    String resourceType = "type_" + i;
    }
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        {
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
                int nbHeaders = randomIntBetween(1, 5);
import org.opensearch.cluster.block.ClusterBlockException;
                        "line": 1,
            parsedFailure = OpenSearchException.failureFromXContent(parser);
            assertEquals(foobars.length, 1);
/*
                assertNotNull(actual);
                        new ShardSearchFailure(
     * an exception.
                        "index": "foo1",
            }
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
        OpenSearchException bar = new OpenSearchException("bar", baz);
        assertThat(parsed.getHeader("foo_1"), hasItem("foo1"));
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=bar]");
        e.addHeader("foo_0", "0");
                    + "\"reason\":\"bar\",\"caused_by\":{\"type\":\"illegal_argument_exception\",\"reason\":\"index is closed\","
                for (int i = 0; i < nbHeaders; i++) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            OpenSearchException.generateThrowableXContent(builder, ToXContent.EMPTY_PARAMS, throwable);
     * be rendered like the REST API does when the "error_trace" parameter is set to true.
        OpenSearchException cause = (OpenSearchException) parsed.getCause();
                    String[] resourceIds = new String[randomIntBetween(1, 3)];
import static java.util.Collections.singletonList;
            + "},"
        {
import org.opensearch.core.xcontent.XContentLocation;
            ex.addMetadata("opensearch.test2", "value2");
            "foo",
                expected.addMetadata("opensearch.script", "test");
        }
            + "\"caused_by\":{"
        return false;
                expectedCause.addMetadata("opensearch.index_uuid", "_na_");
            NullPointerException nullPointerException = new NullPointerException();
        OpenSearchException suppressed;
                failureCause = new NoShardAvailableActionException(new ShardId("_index_g", "_uuid_g", 6), "node_g", failureCause);
        assertThat(cause.getHeader("bar_1"), hasItem("bar1"));
    public void testFromXContent() throws IOException {
            builder.endObject();
     * Builds a {@link ToXContent} using a JSON XContentBuilder and compares the result to the given json in string format.
        final Tuple<Throwable, OpenSearchException> exceptions = randomExceptions();
                expected.addHeader("header_name", "0", "1");
                suppressed.addHeader("header_name", "0", "1");
import static org.opensearch.test.TestSearchContext.SHARD_TARGET;
                actual,
                suppressed.addHeader("script_name", "my_script");
        try (XContentParser parser = createParser(xContent, throwableBytes)) {
        final XContent xContent = randomFrom(XContentType.values()).xContent();
import org.opensearch.repositories.RepositoryException;
                    "OpenSearch exception [type=illegal_argument_exception, reason=Closed resource]",
import org.opensearch.snapshots.ConcurrentSnapshotExecutionException;
        {
            String expected = XContentHelper.stripWhitespace("""
        try (XContentParser parser = createParser(xContent, failureBytes)) {
                suppressed = new OpenSearchException("OpenSearch exception [type=script_exception, reason=C]");
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
                    actualException.setResources(resourceType, resourceIds);
            assertNull(parser.nextToken());
                e,
        }, expectedJson);
        int suppressedCount = randomBoolean() ? 0 : between(1, 5);
            .field("stack_trace", "...")
                e,
            ShardSearchFailure failure1 = new ShardSearchFailure(
import org.opensearch.common.xcontent.XContentFactory;
            case 2:
                );
     * either it is of the given class itself or it contains a nested cause
        OpenSearchException parsed;
            );
                expected.addSuppressed(suppressed);
    public void testThrowableToAndFromXContent() throws IOException {
                    expectedCause
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=exception, reason=foo]");
                suppressed = new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=E]");
                );
            );
        OpenSearchException expected;
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            assertThat(foobars[0], instanceOf(OpenSearchException.class));
                    List<String> values = new ArrayList<>();
                failureCause = new NullPointerException("var is null");
                assertEquals(expectedSuppressed.length, actualSuppressed.length);
                expected.addSuppressed(new OpenSearchException("OpenSearch exception [type=no_node_available_exception, reason=A]"));
import org.opensearch.core.xcontent.XContentBuilder;
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
        OpenSearchException expectedCause;
    public void testFailureToAndFromXContentWithDetails() throws IOException {
            XContentBuilder builder = XContentFactory.jsonBuilder();
        String reason = ExceptionsHelper.summaryMessage(failure);
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
        OpenSearchException parsedFailure;
                    expected.setResources(resourceType, resourceIds);
                expected = new OpenSearchException("OpenSearch exception [type=exception, reason=Parsing failed]", expectedCause);
            assertNull(parser.nextToken());
import org.opensearch.common.collect.Tuple;
            case 0:
                    expected.addMetadata(entry.getKey(), entry.getValue());
        }
 * license agreements. See the NOTICE file distributed with
        final String expectedJson = "{"
        assertEquals(parsed.getHeader("foo_1").get(0), "1");
        assertNotNull(parsed);
            );
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            + "\"type\":\"exception\","
                actual = new OpenSearchException(
import org.opensearch.cluster.node.DiscoveryNode;
        {
                nullPointerException,
        assertThat(cause.getMetadataKeys(), hasSize(2));
            case 5:
            OpenSearchException.generateThrowableXContent(builder, params, throwable);
    /**
            assertNull(parser.nextToken());
            if (exType.isInstance(cause)) {
                ex = new FileNotFoundException("foo not found");
                e.toXContent(builder, params);
                expectedCause.addMetadata("opensearch.index", "_index_g");
            if (randomBoolean()) {
            return false;
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        }
                  "phase": "search",
                    {
            assertNull(parser.nextToken());
                "{\"type\":\"exception\",\"reason\":\"foo\",\"caused_by\":{\"type\":\"exception\","
                        "col": 2
                    new ShardSearchFailure(
            ShardSearchFailure failure1 = new ShardSearchFailure(
    public void testFromXContentWithCause() throws IOException {
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
                new ShardId("_index", "_uuid", 12),
        OpenSearchException parsed;
            parsed = OpenSearchException.fromXContent(parser);
                failure = new BroadcastShardOperationFailedException(new ShardId("_index", "_uuid", 5), "F", failureCause);
            XContentParseException outer = new XContentParseException(null, "outer", inner);
        );
        // of other types than list of strings.
                      "shard": 1,
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 1), null, OriginalIndices.NONE)
            ShardSearchFailure failure = new ShardSearchFailure(
import org.opensearch.common.UUIDs;
                      "shard": 1,
            assertEquals(rootCauses.length, 1);
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=exception, reason=foo]");
            );
                    + "\"reason\":\"CurrentState[RECOVERING] Already recovering\",\"index_uuid\":\"_0\","
            new OpenSearchException("bar", new IllegalArgumentException("index is closed", new RuntimeException("foobar")))
        {
            ShardSearchFailure failure1 = new ShardSearchFailure(
                {
                break;
            XContentBuilder builder = XContentFactory.jsonBuilder();
            OpenSearchException.generateFailureXContent(builder, params, null, randomBoolean());
            "foo",
        }
            Throwable[] actualSuppressed = actual.getSuppressed();
        );
            assertEquals("exception", causes[0].getExceptionName());
 * GitHub history for details.
                .array("metadata_array_of_ints", new int[] { 8, 13, 21 })
                return true;
    }
                  "grouped": true,
    }
        baz.addHeader("baz_0", "baz0");
        assertEquals(
            "foo",
            );
                        "col": 2
            assertNull(parser.nextToken());
                    new OpenSearchException(
                assertEquals("last index should be [suppressed]", "suppressed", keys.get(keys.size() - 1));
                builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(cause.getMetadata("opensearch.index_uuid"), hasItem("_na_"));
                e,
        }
        assertThat(parsedException.getHeader("header_string"), hasItem("some header"));
        }
                );
            assertThat(foobars[0], instanceOf(OpenSearchException.class));
        try (XContentParser parser = createParser(xContent, failureBytes)) {
                expected = new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=B]");
                        "index_uuid": "_na_"
                for (Map.Entry<String, List<String>> entry : randomMetadata.entrySet()) {
        try (XContentParser parser = createParser(xContent, originalBytes)) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        }
            );
                actual = builder.toString();
        assertEquals(
        }
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
                        new RepositoryException("repository_g", "Repo"),
                        "line": 1,
            );
            case 3:
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
            assertEquals("inner", causes[0].getMessage());
                    new OpenSearchException("OpenSearch exception [type=repository_exception, " + "reason=[repository_g] Repo]")
import org.opensearch.core.common.ParsingException;
        );
     *
        assertEquals(parsed.getMessage(), "OpenSearch exception [type=exception, reason=foo]");
                    new ShardSearchFailure(
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                "search",
            assertExceptionAsJson(
        );
        assertEquals(1, parsedException.getMetadataKeys().size());
                expected = new OpenSearchException(
    public void testToXContentWithHeadersAndMetadata() throws IOException {
 */
                      "reason": {
                failure = new RuntimeException("E", failureCause);
        baz.addMetadata("opensearch.baz_3", "baz3");
        assertNotNull(parsedException);
            assertExceptionAsJson(e, "{\"type\":\"exception\",\"reason\":\"test\"}");
        Throwable failureCause;
                            new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
        assertEquals(parsed.getMetadata("opensearch.metadata_foo_1").get(0), "foo_1");
                .startObject()
        assertEquals(root, exception.getRootCause());
        assertThat(cause.getMetadataKeys(), hasSize(2));
                      "reason": {
        assertThat(parsedException.getHeader("header_array_of_strings"), hasItems("foo", "bar", "baz"));
        int type = randomIntBetween(0, 5);
                    + "\"caused_by\":{\"type\":\"illegal_argument_exception\",\"reason\":\"foo\"}}"
                "bar",
            );
        if (suppressedCount > 0) {
                Map<String, List<String>> randomMetadata = new HashMap<>(nbMetadata);
        BytesReference failureBytes = toShuffledXContent((builder, params) -> {
        bar.addMetadata("opensearch.bar_0", "bar0");
                expected = new OpenSearchException(
        {
 * The OpenSearch Contributors require contributions made to
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
import org.opensearch.common.xcontent.XContentType;
                failure = new NoNodeAvailableException("A");
                      "index": "foo",
            + "\"reason\":\"blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];\""
                assertNull(actual);
                  "reason": "all shards failed",
                """);
                "{\"type\":\"index_shard_recovering_exception\","
                    actualException.addMetadata(entry.getKey(), entry.getValue());
                  }
            + "\"reason\":\"foo\","
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));
import org.opensearch.search.SearchShardTarget;
                expected.addSuppressed(
                expected.addMetadata("opensearch.lang", "painless");
                new ShardSearchFailure[] { failure, failure1, failure2 }
import java.io.EOFException;
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=bar]");
            assertEquals("illegal_argument_exception", foobars[0].getExceptionName());
                // just a wrapper which is omitted
        }
        assertExceptionAsJson(e, expectedJson);
                      "node": "node_1",
                if (rarely()) {
import org.opensearch.search.SearchContextMissingException;
                  "phase": "search",
import java.util.HashMap;
            String expected = "{\"type\":\"search_phase_execution_exception\",\"reason\":\"all shards failed\","
            assertEquals("{\"type\":\"file_not_found_exception\",\"reason\":\"foo not found\"}", toXContentString);
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=baz]");
 * the Apache License, Version 2.0 (the "License"); you may
            String expected = XContentHelper.stripWhitespace("""
                }
        }
            // Test the same exception but with the "rest.exception.stacktrace.skip" parameter disabled: the stack_trace must be present
                expectedCause = new OpenSearchException("OpenSearch exception [type=null_pointer_exception, reason=var is null]");
                OpenSearchException expectedCause = new OpenSearchException(
                    },
        assertTrue(contains(exception, RuntimeException.class));
 *    http://www.apache.org/licenses/LICENSE-2.0
                failure = new ParsingException(3, 2, "B", null);
                expected = new OpenSearchException("OpenSearch exception [type=file_already_exists_exception, reason=File exists]");
            );
                DiscoveryNode node = new DiscoveryNode("node_g", buildNewFakeTransportAddress(), Version.CURRENT);
        }
                expected.addSuppressed(
import org.opensearch.action.search.SearchPhaseExecutionException;
     * of the given type.
 * Unless required by applicable law or agreed to in writing,
                    ),
 * under the License.
                        values.add(frequently() ? randomAlphaOfLength(5) : "");
            "OpenSearch exception [type=routing_missing_exception, reason=routing is required for [_test]/[_id]]"
                ((OpenSearchException) failure).addHeader("header_name", "0", "1");
        assertThat(cause.getMetadata("opensearch.baz_1"), hasItem("baz1"));
            assertEquals("foo1", rootCauses[1].getIndex().getName());
            final OpenSearchException[] foobars = OpenSearchException.guessRootCauses(
                .array("header_array_of_strings", new String[] { "foo", "bar", "baz" })
            ShardSearchFailure failure = new ShardSearchFailure(
        assertThat(cause.getMetadata("opensearch.index"), hasItem("_test"));
                    }
        }
            Throwable[] expectedSuppressed = expected.getSuppressed();
            );
            if (expected == null) {
        cause = (OpenSearchException) cause.getCause();
        do {
                new SearchShardTarget("node_1", new ShardId("foo1", "_na_", 2), null, OriginalIndices.NONE)
    public void testDeduplicate() throws IOException {
            }
            assertEquals(rootCauses[0].getMessage(), "foobar");
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
import java.util.Map;
                        null
                .field("reason", "Custom reason")
                .startObject("metadata_object")
                    "OpenSearch exception [type=search_phase_execution_exception, reason=all shards failed]",
            );
            case 1: // Simple opensearch exception with headers (other metadata of type number are not parsed)
            assertEquals(nullPointerException, ex.getCause());
        assertThat(cause.getHeader("baz_2"), hasItem("baz2"));
import java.util.Collections;
            assertEquals("foobar", foobars[0].getMessage());
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
import org.opensearch.transport.RemoteTransportException;
                expected.addMetadata("opensearch.script_stack", "stack");
            + "\"foo_1\":\"1\""
import static org.hamcrest.Matchers.equalTo;
            SearchPhaseExecutionException ex = new SearchPhaseExecutionException(
    }
/*
                expected.addSuppressed(suppressed);
        assertDeepEquals(expected, parsedException);
                expected.addMetadata("opensearch.phase", "phase_g");
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
                + "\"phase\":\"search\",\"grouped\":true,\"failed_shards\":[{\"shard\":1,\"index\":\"foo\",\"node\":\"node_1\","
                }
                    "reason": "foobar",
        cause = (OpenSearchException) cause.getCause();
        OpenSearchException foo = new OpenSearchException("foo", bar);
            assertEquals("foobar", foobars[0].getMessage());
            assertEquals("foo", rootCauses[0].getMessage());
                failure = new SearchPhaseExecutionException("phase_g", "G", failureCause, shardFailures);
        {
        {
        {
        final XContent xContent = randomFrom(XContentType.values()).xContent();
        cause = (OpenSearchException) cause.getCause();
                        + "\\tat org.opensearch."
import org.opensearch.action.NoShardAvailableActionException;
        }
            + "\"caused_by\":{"
                .field("object_field", "value")
                        "type": "parsing_exception",
        cause = (OpenSearchException) cause.getCause();
                    "OpenSearch exception [type=node_closed_exception, " + "reason=node closed " + node + "]"
            }
            return builder;
        {
 */
            Exception ex;
                new OpenSearchException(
                  "type": "search_phase_execution_exception",
                ex = new RemoteTransportException("foobar", new FileNotFoundException("foo not found"));
        assertThat(parsed.getMetadataKeys(), hasSize(2));
            assertExceptionAsJson(
        exception = new RemoteTransportException("test", new IllegalArgumentException("foobar"));
            ex.addHeader("test_multi", "some value", "another value");
        XContentBuilder builder = XContentBuilder.builder(xContent)
                            new ParsingException(1, 2, "foobar", null),
     * @return whether there is a nested exception of the specified type
import org.opensearch.search.internal.ShardSearchContextId;
                    }
                .field("type", "custom_exception")
                    int nbValues = randomIntBetween(1, 3);
            assertExceptionAsJson(
            } else {
    public void testStatus() {
    }
                expected = new OpenSearchException("OpenSearch exception [type=script_exception, reason=C]", expectedCause);
        }
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                    + "\"shard\":\"5\",\"index\":\"_test\"}"
                    "search",
                expected.addSuppressed(new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=Parsing g]"));
                expected = new OpenSearchException(
            XContentBuilder builder = XContentFactory.jsonBuilder();
                break;
                .startObject("header")
                new OpenSearchException("bar", new IllegalArgumentException("index is closed", new RuntimeException("foobar")))
                ((OpenSearchException) failure).addHeader("script_name", "my_script");
                randomBoolean() ? failure1.getCause() : failure.getCause(),
            );
        try (XContentParser parser = createParser(xContent, failureBytes)) {
        assertEquals("OpenSearch exception [type=exception, reason=unknown]", parsedFailure.getMessage());
            + "\"foo_0\":\"0\","
import org.opensearch.index.IndexNotFoundException;
            ex.toXContent(builder, ToXContent.EMPTY_PARAMS);
            ex.addHeader("test", "some value");
    }
            ShardSearchFailure failure2 = new ShardSearchFailure(
                    randomMetadata.put("opensearch.metadata_" + i, values);
            );
            ParsingException ex = new ParsingException(1, 2, "foobar", null);
        final OpenSearchException expected = exceptions.v2();
            rootCauses = oneLevel.guessRootCauses();
        BytesReference originalBytes;
        OpenSearchException parsedFailure;
        assertEquals("OpenSearch exception [type=custom_exception, reason=Custom reason]", parsedException.getMessage());
                );
            assertEquals(1, ((ParsingException) rootCauses[0]).getLineNumber());
            OpenSearchException.generateFailureXContent(builder, params, failure, false);
            return builder;
            );
            final OpenSearchException[] causes = OpenSearchException.guessRootCauses(outer);
    public void testUnknownFailureToAndFromXContent() throws IOException {
    }
                expected = new OpenSearchException("OpenSearch exception [type=search_parse_exception, reason=Parse failure]");
import java.util.ArrayList;
        assertThat(cause.getHeaderKeys(), hasSize(0));
                        "reason": "foobar",
        assertFalse(contains(exception, EOFException.class));
        );
        }
            assertEquals(causes.length, 1);
        final XContent xContent = randomFrom(XContentType.values()).xContent();
        } while (expected != null);
                    assertDeepEquals((OpenSearchException) expectedSuppressed[i], (OpenSearchException) actualSuppressed[i]);
            throwable.addSuppressed(suppressed.v1());
            OpenSearchException.generateThrowableXContent(builder, params, e);
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
import static java.util.Collections.emptyList;
            assertEquals("exception", OpenSearchException.getExceptionName(rootCauses[0]));
                    "OpenSearch exception [type=search_phase_execution_exception, " + "reason=G]",
                "{\"type\":\"exception\",\"reason\":\"java.lang.IllegalArgumentException: foo\","
        assertEquals(parsed.getMetadata("opensearch.metadata_foo_0").get(0), "foo_0");
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        {
        Exception finalFailure = failure;
        {
        try (XContentParser parser = createParser(xContent, failureBytes)) {
        e.addMetadata("opensearch.metadata_foo_1", "foo_1");
import static org.hamcrest.CoreMatchers.hasItems;
                    "OpenSearch exception [type=parsing_exception, " + "reason=Wrong state]",
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 2), null, OriginalIndices.NONE)
        // Failure was null, expecting a "unknown" reason
        final XContent xContent = randomFrom(XContentType.values()).xContent();
                new ParsingException(1, 2, "foobar", null),
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
                        + (Constants.WINDOWS ? "\\r\\n" : "\\n")
        final Exception failure = (Exception) randomExceptions().v1();
            default:
                    // Empty or null metadata are not printed out by the toXContent method
                failureCause = new FileAlreadyExistsException("File exists");
    public static Tuple<Throwable, OpenSearchException> randomExceptions() {
                rootCauses = OpenSearchException.guessRootCauses(randomBoolean() ? new RemoteTransportException("remoteboom", ex) : ex);
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            + "\"type\":\"exception\","
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=baz]");
        }
        }
            parsed = OpenSearchException.fromXContent(parser);
            assertEquals(OpenSearchException.getExceptionName(rootCauses[0]), "index_not_found_exception");
            case 1: // Simple opensearch exception with headers (other metadata of type number are not parsed)
                expectedCause.addMetadata("opensearch.index", "idx");
            ShardSearchFailure failure1 = new ShardSearchFailure(
import org.opensearch.action.OriginalIndices;
                expectedCause.addMetadata("opensearch.index_uuid", "_uuid_g");
        Exception failure;
                        "OpenSearch exception [type=search_context_missing_exception, " + "reason=No search context found for id [0]]"
        OpenSearchException parsedException;
            ex.addMetadata("opensearch.test1", "value1");
            OpenSearchException exception = new OpenSearchException(
            try (XContentParser parser = createParser(xContent, throwableBytes)) {
                );
                assertNull(actual);
    }
                );
                new OpenSearchException("bar", new IndexNotFoundException("foo", new RuntimeException("foobar")))
     * <p>
        }
                failureCause = new RoutingMissingException("idx", "id");
                }
                "all shards failed",
        assertThat(parsed.getHeaderKeys(), hasSize(2));
                "search",
 * You may obtain a copy of the License at
                      }
            assertNull(parser.nextToken());
import org.opensearch.core.common.Strings;
                .startObject()
            }
            );
    /**
    public void testToString() {
                failureCause = new NodeClosedException(node);
                "search",
            );
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                        "reason": "foobar",
                "search",
            + "\"metadata_foo_0\":\"foo_0\","
                .endObject()
                      "node": "node_1",
        assertEquals(cause.getMessage(), "OpenSearch exception [type=exception, reason=baz]");
            builder.endObject();
        }
            OpenSearchException[] rootCauses = exception.guessRootCauses();
 * ownership. Elasticsearch licenses this file to you under
                originalBytes = BytesReference.bytes(shuffledBuilder);
            OpenSearchException actualException = (OpenSearchException) actual;
                expectedCause = new OpenSearchException(
                  "failed_shards": [
                )
                    ) };
            assertEquals("foobar", rootCauses[0].getMessage());
                );
        );
import org.opensearch.core.common.bytes.BytesArray;
                  "grouped": true,
            if (randomBoolean()) {
        assertEquals(0, parsedFailure.getMetadata().size());
            String actual;
                  ],
            assertExceptionAsJson(ex, "{\"type\":\"file_not_found_exception\",\"reason\":\"foo not found\"}");
        bar.addHeader("bar_1", "bar1");
        BytesReference failureBytes = toShuffledXContent((builder, params) -> {
        try (XContentBuilder builder = XContentBuilder.builder(xContent)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .field("metadata_long", 1L)
            } else {
                + "[index is closed]; nested: RuntimeException[foobar];",
package org.opensearch;
        e.addHeader("foo_1", "1");
        if (exType == null) {
        OpenSearchException parsed;
                )
                new ParsingException(1, 2, "foobar", null),
            OpenSearchException ex = new OpenSearchException(
                .field("metadata_other", "some metadata")
        try (XContentParser parser = createParser(xContent, failureBytes)) {
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),
                .startArray("metadata_array_of_objects")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            + "\"type\":\"exception\","
        assertEquals(0, parsedFailure.getHeaders().size());
            "foo",
            } else {
     */
            );
        final XContent xContent = randomFrom(XContentType.values()).xContent();
                }
import org.opensearch.core.xcontent.XContentParseException;
            final OpenSearchException[] foobars = OpenSearchException.guessRootCauses(new IllegalArgumentException("foobar"));
}
        assertNotNull(parsedFailure);
import java.io.FileNotFoundException;
 *
                ex,
     * By default, the stack trace of the exception is not rendered. The parameter `errorTrace` forces the stack trace to
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
                        + "\"stack_trace\":\"java.lang.IllegalStateException: bar"
            ex.toXContent(builder, ToXContent.EMPTY_PARAMS);
            parsed = OpenSearchException.fromXContent(parser);
                + "\"test1\":\"value1\",\"test2\":\"value2\","
                break;
            if (randomBoolean()) {
                    {
            OpenSearchException.generateFailureXContent(builder, params, finalFailure, true);
        for (int i = 0; i < suppressedCount; i++) {
    }
                    "line": 1,
            .startObject()
            assertEquals(expected.getMetadata(), actual.getMetadata());
            }
                expected = new OpenSearchException("OpenSearch exception [type=no_node_available_exception, reason=A]");
                + "\"caused_by\":{\"type\":\"null_pointer_exception\",\"reason\":null}}";
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
                expected.addSuppressed(suppressed);
                "all shards failed",
                "foo",
 * this file be licensed under the Apache-2.0 license or a
                        + "reason=blocked by: [SERVICE_UNAVAILABLE/2/no cluster-manager];]"
                throw new UnsupportedOperationException("Failed to generate randomized failure");
                    "col": 2
        { // test equivalence
public class OpenSearchExceptionTests extends OpenSearchTestCase {
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                      }
            }
        {
        switch (type) {
                expected.addSuppressed(suppressed);
                "all shards failed",
        OpenSearchException exception = new OpenSearchException(
            assertEquals("no such index [foo]", rootCauses[0].getMessage());
        Exception root = new RuntimeException("foobar");
        // because the current Java API does not allow to add metadata/headers
        return new Tuple<>(actual, expected);
        switch (randomIntBetween(0, 6)) {
            // Prints a null failure using generateFailureXContent()
                for (int i = 0; i < expectedSuppressed.length; i++) {
        exception = new OpenSearchException("test", new ResourceNotFoundException("test"));
                  "caused_by": {
            final Tuple<Throwable, OpenSearchException> suppressed = randomExceptions();
        OpenSearchException parsedException;
            }
 * compatible open source license.
        bar.addMetadata("opensearch.bar_2", "bar2");
            ShardSearchFailure failure1 = new ShardSearchFailure(
                    for (int j = 0; j < nbValues; j++) {
            final OpenSearchException[] causes = OpenSearchException.guessRootCauses(outer);
                  "failed_shards": [
                );
            builder.startObject()
            ShardSearchFailure failure2 = new ShardSearchFailure(
            assertThat(causes[0], instanceOf(OpenSearchException.class));
                .field("header_string", "some header")
 * not use this file except in compliance with the License.
            case 0: // Simple opensearch exception without cause
    public void testGetRootCause() {
        assertThat(cause.getHeaderKeys(), hasSize(0));
        }
                    "all shards failed",
                    new OpenSearchException("OpenSearch exception [type=parsing_exception, reason=foobar]")
            assertEquals(foobars.length, 1);
import org.opensearch.core.rest.RestStatus;
/*
                }
        for (Throwable cause = t; t != null; t = t.getCause()) {
            assertEquals("inner", causes[0].getMessage());
                    "reason": "foobar",
            );
        builder = shuffleXContent(builder);
    public void testFromXContentWithIgnoredMetadataAndHeaders() throws IOException {
            + "}"
                "all shards failed",
                builder.startObject();
            case 3: // JDK exception without cause
                actual = new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES));
    }
            assertEquals(2, ((ParsingException) rootCauses[0]).getColumnNumber());
            case 4:
                break;
                suppressed.addMetadata("opensearch.lang", "painless");
                    expectedCause
        }
                new ShardSearchFailure[] { failure, failure1 }
                for (int i = 0; i < nbResources; i++) {
            parsedFailure = OpenSearchException.failureFromXContent(parser);
            + "\"reason\":\"baz\","
        try (XContentParser parser = createParser(builder)) {
            ShardSearchFailure failure = new ShardSearchFailure(
    public void testGenerateThrowableToXContent() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                  ],
                        values.add(frequently() ? randomAlphaOfLength(5) : "");
            assertEquals(IllegalArgumentException.class, foobars[0].getCause().getClass());
        }
            assertEquals("x_content_parse_exception", causes[0].getExceptionName());
    }
            assertEquals(throwableString, toXContentString);
        OpenSearchException exception = new OpenSearchException(
            parsedException = OpenSearchException.fromXContent(parser);
        {
            assertEquals("illegal_argument_exception", foobars[0].getExceptionName());
import org.opensearch.action.search.ShardSearchFailure;
import java.io.IOException;
    }
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),
        }
        }
            OpenSearchException e = new OpenSearchException("test");
                suppressed.addMetadata("opensearch.script_stack", "stack");
        OpenSearchException cause = (OpenSearchException) parsed.getCause();
                        new SearchContextMissingException(new ShardSearchContextId(UUIDs.randomBase64UUID(), 0L)),
            }
                + "\"header\":{\"test_multi\":"
                );
            + "\"type\":\"cluster_block_exception\","
        assertThat(exception.status(), equalTo(RestStatus.BAD_REQUEST));
                    for (int j = 0; j < resourceIds.length; j++) {
                }
     */
        }
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
            case 6: // SearchPhaseExecutionException with cause and multiple failures
                + "[\"some value\",\"another value\"],\"test\":\"some value\"}}";
                break;
    /**
        }
                int nbMetadata = randomIntBetween(1, 5);
    }
                    "OpenSearch exception [type=cluster_block_exception, "
        assertEquals(
            + "}";
            assertExceptionAsJson(e, "{\"type\":\"illegal_state_exception\",\"reason\":\"bar\"}");
                    actualException.addHeader(entry.getKey(), entry.getValue());
                }
        assertEquals(OpenSearchException.buildMessage("exception", reason, null), parsedFailure.getMessage());
     * Check whether this exception contains an exception of the given type:
                        resourceIds[j] = frequently() ? randomAlphaOfLength(5) : "";
    }
        {
                actual = new SearchPhaseExecutionException(
            cause.getMessage(),
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
                    new ShardSearchFailure(
            .field("reason", "something went wrong")
                ShardSearchFailure[] shardFailures = new ShardSearchFailure[] {
    public void testFromXContentWithHeadersAndMetadata() throws IOException {
                new QueryShardException(new Index("foo1", "_na_"), "foobar", null),
                new ParsingException(1, 2, "foobar", null),
            );
                        "type": "parsing_exception",
        builder = shuffleXContent(builder);
            builder.startObject();
                        + "\"caused_by\":{\"type\":\"illegal_state_exception\",\"reason\":\"bar\","
                new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
            + "\"header\":{"
                .endObject()
                  "type": "search_phase_execution_exception",
import org.opensearch.index.query.QueryShardException;
            )
        foo.addMetadata("opensearch.foo_0", "foo0");
        exception = new OpenSearchException("test", new RuntimeException());
        }
 * software distributed under the License is distributed on an
        e.addMetadata("opensearch.metadata_foo_0", "foo_0");
                    "line": 1,
            exception.toString()
 */
                );
                break;
        cause = (OpenSearchException) cause.getCause();
                break;
            parsedFailure = OpenSearchException.failureFromXContent(parser);
                for (Map.Entry<String, List<String>> entry : randomHeaders.entrySet()) {
                List<String> keys = new ArrayList<>(parser.mapOrdered().keySet());
            actual = (OpenSearchException) actual.getCause();
        assertNotNull(parsed);
            expected = (OpenSearchException) expected.getCause();
                expectedCause = new OpenSearchException(
                    new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=Resource]")
                    ),
            ShardSearchFailure failure = new ShardSearchFailure(
            OpenSearchException oneLevel = new OpenSearchException("foo", new RuntimeException("foobar"));
        exception = new RemoteTransportException("test", new ResourceNotFoundException("test"));
            assertEquals(causes.length, 1);
                "{\"type\":\"exception\",\"reason\":\"foo\"," + "\"caused_by\":{\"type\":\"illegal_state_exception\",\"reason\":\"bar\"}}"
            parsed = OpenSearchException.fromXContent(parser);
                new ShardSearchFailure[] { failure, failure1 }
            builder.startObject();
                break;
            failureBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
                expectedCause = new OpenSearchException(
    public void testFailureToAndFromXContentWithNoDetails() throws IOException {
import org.opensearch.core.xcontent.XContent;
                    new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES))
        assertEquals(2, parsedException.getHeaderKeys().size());
        XContentBuilder builder = XContentBuilder.builder(xContent).startObject().value(foo).endObject();
                .endObject()
                    "type": "parsing_exception",
        OpenSearchException e = new OpenSearchException(
    }
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        assertEquals(
            new OpenSearchException("bar", new OpenSearchException("baz", new RoutingMissingException("_test", "_id")))
                    "Parsing failed",
                    }
            OpenSearchException e = new SearchParseException(SHARD_TARGET, "foo", new XContentLocation(1, 0));
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
 * specific language governing permissions and limitations
                    )
    }
        }
                "search",
        Throwable actual;
     * Test that some values like arrays of numbers are ignored when parsing back
                    for (int j = 0; j < nbValues; j++) {
                new ParsingException(1, 2, "foobar", null),
                "foo",
            assertEquals(expected.getResourceType(), actual.getResourceType());
    }
            assertThat(causes[0], instanceOf(OpenSearchException.class));
            final OpenSearchException[] rootCauses = ex.guessRootCauses();
        baz.addMetadata("opensearch.baz_1", "baz1");
 *
                break;
                        new SearchShardTarget("node_g", new ShardId(new Index("_index_g", "_uuid_g"), 62), null, OriginalIndices.NONE)
        RoutingMissingException routing = new RoutingMissingException("_test", "_id");
        OpenSearchException cause = (OpenSearchException) parsed.getCause();
                .field("object_array_one", "value_one")
        cause = (OpenSearchException) cause.getCause();
            .endObject();
                OpenSearchException.generateThrowableXContent(builder, params, ex);
    }
                    new ShardSearchFailure[] {
                .field("object_array_two", "value_two")
            ShardSearchFailure failure = new ShardSearchFailure(
        // The exception content to parse is built using a XContentBuilder
        final Throwable throwable = exceptions.v1();
            assertExceptionAsJson(ex, expected);
            parsedException = OpenSearchException.fromXContent(parser);
                }
                Map<String, List<String>> randomHeaders = new HashMap<>(nbHeaders);
            return builder;
import static java.util.Collections.singleton;
            assertExceptionAsJson(e, "{\"type\":\"search_parse_exception\",\"reason\":\"foo\",\"line\":1,\"col\":0}");
                .field("metadata_int", 1)
            }
    }
        }
        assertThat(cause.getMetadataKeys(), hasSize(2));
            } else {
        baz.addHeader("baz_2", "baz2");
                throw new UnsupportedOperationException("No randomized exceptions generated for type [" + type + "]");
                new ParsingException(1, 2, "foobar", null),
            );
        }
            case 4: // JDK exception with cause
                  "reason": "all shards failed",
            assertEquals(expected.getMessage(), actual.getMessage());
                    actualException.addHeader("ignored", randomBoolean() ? emptyList() : null);
                expected = new OpenSearchException("OpenSearch exception [type=runtime_exception, reason=E]", expectedCause);
                new RemoteTransportException("abc", new IllegalArgumentException("foobar"))
            failureBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
        }
        assertEquals(0, parsedFailure.getMetadata().size());
            );
            expected.addSuppressed(suppressed.v2());
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        builder = shuffleXContent(builder);
     * @param exType the exception type to look for
        OpenSearchException parsedFailure;
            cause.getMessage(),
        assertNull(parsedFailure.getCause());
        final XContent xContent = randomFrom(XContentType.values()).xContent();
            return builder;
 * this work for additional information regarding copyright
import org.apache.lucene.util.Constants;
                rootCauses = (randomBoolean() ? new RemoteTransportException("remoteboom", ex) : ex).guessRootCauses();
                new ShardSearchFailure[] { failure, failure1, failure2 }
        try (XContentParser parser = createParser(xContent, BytesReference.bytes(builder))) {
            assertEquals(expected, builder.toString());
                    List<String> values = new ArrayList<>();
            OpenSearchException inner = new OpenSearchException("inner");
                    "baz",
            assertThat(
        assertThat(cause.getMetadata("opensearch.index_uuid"), hasItem("_na_"));
                """);
            OpenSearchException e = new BroadcastShardOperationFailedException(
                    }
                );
import org.opensearch.core.index.shard.ShardId;
                int nbResources = randomIntBetween(1, 5);
            ParsingException ex = new ParsingException(1, 2, "foobar", null);
                    // Empty or null headers are not printed out by the toXContent method
        assertThat(exception.status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
                    expected.addHeader(entry.getKey(), entry.getValue());
        final XContent xContent = randomFrom(XContentType.values()).xContent();
                actual = new SearchParseException(SHARD_TARGET, "Parse failure", new XContentLocation(12, 98));
                        "type": "query_shard_exception",
        OpenSearchException expected;
                    "OpenSearch exception [type=no_shard_available_action_exception, " + "reason=node_g]",
        );
            assertEquals(rootCauses.length, 2);
            case 2: // OpenSearch exception with a cause, headers and parsable metadata
            assertEquals("foobar", rootCauses[1].getMessage());
        }
                for (int i = 0; i < nbMetadata; i++) {
        }, xContent.mediaType(), ToXContent.EMPTY_PARAMS, randomBoolean());
        exception = new ConcurrentSnapshotExecutionException("testRepo", "testSnap", "test");
            });
import org.opensearch.node.NodeClosedException;
            assertEquals(expected.getResourceId(), actual.getResourceId());
