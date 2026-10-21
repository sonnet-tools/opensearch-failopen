    public static void assertSecondHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {
 * the Apache License, Version 2.0 (the "License"); you may
            && totalHits.value() <= maxHitCount)) {
            SearchResponse searchResponse = searchRequestBuilder.get();
    public static void assertNoTimeout(ClusterHealthRequestBuilder requestBuilder) {
        assertThat("Expected all shards successful", response.getSuccessfulShards(), equalTo(response.getTotalShards()));
    }
import org.opensearch.core.xcontent.XContentBuilder;
                return false;
            );
    }
            }
    }
        assertFutureThrows(future, status, null);
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                    + " and "
        assertNoFailures(response);
            ClusterBlockException clusterBlockException = (ClusterBlockException) ExceptionsHelper.unwrap(
    /**
     * matchers
                        found = true;
            .append(response.getFailedShards())
     * @param extraInfo      extra information to add to the failure message. Can be null.
        for (Object expectedValue : expected) {
            assertArrayEquals((byte[]) expected, (byte[]) actual);
     */
import org.opensearch.test.NotEqualMessageBuilder;
        SearchResponse resp,
        String message = String.format(Locale.ROOT, "Expected %s/%s to exist, but does not", response.getIndex(), response.getId());
        for (ShardSearchFailure failure : response.getShardFailures()) {
        assertSuggestionSize(searchSuggest, entry, size, key);
    /**
/*
            }
        return new OpenSearchMatchers.SearchHitMatchedQueriesMatcher(matchedQueries);
     * Assert that an index creation was fully acknowledged, meaning that both the index creation cluster
        assertThat(msg, searchSuggest.size(), greaterThanOrEqualTo(1));
    }
        StringBuilder msg = new StringBuilder();
     */
     */
     * @param replicatedBroadcastResponse the response that should only contain failed shard responses
    public static void assertFileExists(Path file) {
    }
            String expectedKey = expectedEntry.getKey();
     *
    /**
import org.hamcrest.Matcher;
     * Assert suggestion returns size suggestions and the first are the provided
import org.opensearch.core.xcontent.DeprecationHandler;
            .append(" shard failures:");
    }
        extraInfo = extraInfo == null || extraInfo.isEmpty() ? "" : extraInfo + ": ";
    public static <E extends Throwable> void assertFutureThrows(ActionFuture<?> future, Class<E> exceptionClass, RestStatus status) {
        assertThat(msg, searchSuggest.getSuggestion(key).getName(), equalTo(key));
    }
        ActionRequestBuilder<?, ?> builder,
    public static <E extends Throwable> void assertFutureThrows(
 * specific language governing permissions and limitations
            );
    public static void assertBlocked(BroadcastResponse replicatedBroadcastResponse) {
        boolean isCountedDown = latch.await(timeout, unit);
        }
    public static void assertExists(GetResponse response) {
            }
        for (int i = 0; i < text.length; i++) {
        return (response) -> response.getSourceAsMap().get(fieldName);
     * @throws InterruptedException An exception if the waiting is interrupted
    public static void assertHitCount(SearchResponse countResponse, long minHitCount, long maxHitCount) {
     */
            assertThat(clusterBlockException.blocks().size(), greaterThan(0));
    /*
import java.util.Arrays;
    public static void assertAllSuccessful(BroadcastResponse response) {
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, actual.streamInput())
     *
        assertAcked(builder.get());
            );
import static org.hamcrest.Matchers.hasItem;
        assertFutureThrows(builder.execute(), exceptionClass);
        assertThat(msg, searchSuggest.size(), greaterThanOrEqualTo(1));
        } else if (expected instanceof List) {
 * SPDX-License-Identifier: Apache-2.0
        } else {
            assertEquals(expected, actual);
    private static void assertMapEquals(Map<String, Object> expected, Map<String, Object> actual) {
    /**
     */
        Class<E> exceptionClass,
        Set<String> idsSet = new HashSet<>(Arrays.asList(ids));
    }
     */
            XContentParser actualParser = mediaType.xContent()
import org.opensearch.cluster.block.ClusterBlockException;
    }
    }
     * Also binary values (byte[]) are properly compared through arrays comparisons.
    }
        assertThat("Expected different hit count. " + shardStatus, searchResponse.getHits().getHits().length, equalTo(ids.length));
    public static String formatShardStatus(BroadcastResponse response) {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
     */
        if (expected instanceof Map) {
package org.opensearch.test.hamcrest;
        assertThat(response.getClass().getSimpleName() + " failed - not acked", response.isAcknowledged(), equalTo(true));
import org.opensearch.core.xcontent.MediaType;
        assertThat("SearchHit number must be greater than 0", number, greaterThan(0));
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThanOrEqualTo((long) number));
    /**
import org.opensearch.core.xcontent.NamedXContentRegistry;
        String message = String.format(Locale.ROOT, "expected latch to be counted down after %s, but was not", timeValue);
        assertThat(msg, searchSuggest.getSuggestion(key).getName(), equalTo(key));
    }
        assertThat(searchSuggest, notNullValue());
            for (ShardSearchFailure shardSearchFailure : e.shardFailures()) {
    public static void assertBlocked(final ActionRequestBuilder builder, @Nullable final ClusterBlock expectedBlock) {
        Matcher<Integer> fragmentsMatcher,
        String shardStatus = formatShardStatus(searchResponse);
                assertThat(shardSearchFailure.status(), equalTo(restStatus));
import static org.hamcrest.CoreMatchers.is;
        SearchHit[] hits = searchResponse.getHits().getHits();
     * for byte[] through Arrays.equals(byte[], byte[])
import java.nio.file.Files;
        }
    /**
            fail(
import java.nio.file.Path;
    public static void assertHitCount(SearchResponse countResponse, long expectedHitCount) {
    ) {
    public static void assertSuggestion(Suggest searchSuggest, int entry, String key, String... text) {
            assertThat(extraInfo, ExceptionsHelper.status(expected), equalTo(status));
import org.opensearch.core.xcontent.ToXContent;
    }
        assertEquals(sortValues.length, hits.length);
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().size(), greaterThanOrEqualTo(entry));
            assertThat(e.status(), equalTo(status));
import org.opensearch.action.ActionRequestBuilder;
        assertFutureThrows(builder.execute(), exceptionClass, status);
            .append(response.getTotalShards())
        RestStatus status
            .append(" & ")
        for (IndexTemplateMetadata indexTemplateMetadata : templatesResponse.getIndexTemplates()) {
            .append(response.getSuccessfulShards())
    public static void assertFutureThrows(ActionFuture<?> future, RestStatus status) {
     * @param builder the request builder
     * Compares two objects, recursively walking eventual maps and lists encountered, and using arrays comparisons
        String msg = "Suggest result: " + searchSuggest.toString();
        } else if (expected instanceof byte[]) {
        // Note that byte[] holding binary values need special treatment as they need to be properly compared item per item.
     */
    }
    public static void assertAcked(AcknowledgedResponse response) {
     * Run future.actionGet() and check that it throws an exception of the right type, with a given {@link RestStatus}
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(query, instanceOf(BooleanQuery.class));
            replicatedBroadcastResponse.getFailedShards(),
        assertTrue(
     * The comparison is done by parsing both into a map and comparing those two, so that keys ordering doesn't matter.
    public static void awaitLatch(CountDownLatch latch, long timeout, TimeUnit unit) throws InterruptedException {
    public static void assertFileNotExists(Path file) {
    /**
            equalTo(0)
import org.opensearch.cluster.block.ClusterBlock;
    }
            msg.append("\n ").append(failure);
        int totalFragments,
        // check only retryable blocks exist in the set
    }
    }
import static org.junit.Assert.assertTrue;
     * @param expectedBlockId the expected block id
    }
        StringBuilder msg = new StringBuilder();
        @Nullable String extraInfo
            if (clusterBlock.id() != IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK.id()) {
    }
     *
        assertHighlight(resp, hit, field, fragment, greaterThan(fragment), matcher);
                        break;
    @SuppressWarnings("unchecked")
import org.opensearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
        BooleanQuery q = (BooleanQuery) query;
        );
        String msg = "Suggest result: " + searchSuggest.toString();
     * Applies basic assertions on the SearchResponse. This method checks if all shards were successful, if
        }
    public static <T, V> CombinableMatcher<T> hasProperty(Function<? super T, ? extends V> property, Matcher<V> valueMatcher) {
    public static Matcher<SearchHit> hasIndex(final String index) {
            if (option.collateMatch()) {
        }
import org.opensearch.action.search.SearchPhaseExecutionException;
     * Often latches are called as <code>assertTrue(latch.await(1, TimeUnit.SECONDS));</code>
    public static void assertFailures(SearchResponse searchResponse) {
        return msg.toString();
                    + " not between "
    }
import static org.hamcrest.Matchers.greaterThan;
    public static Function<SearchHit, Object> fieldFromSource(String fieldName) {
     */
            fail("Count is " + totalHits + " but " + expectedHitCount + " was expected. " + formatShardStatus(countResponse));
 *
                    + totalHits
        extraInfo += "expected a " + exceptionClass + " exception to be thrown";
                assertTrue(actual.get(expectedKey) == null && actual.containsKey(expectedKey));
        for (int i = 0; i < ids.length; i++) {
     *
        assertThat("Expected all shards successful", response.getSuccessfulShards(), equalTo(response.getTotalShards()));
        Matcher<Integer> fragmentsMatcher,
            .append(response.getFailedShards())
        return true;
     * @param builder the request builder
        List<String> templateNames = new ArrayList<>();
import org.opensearch.core.common.bytes.BytesReference;
 */
     */
     * Run future.actionGet() and check that it throws an exception of the right type
            "Unexpected ShardFailures: " + Arrays.toString(searchResponse.getShardFailures()),
        assertThat(extraInfo, ExceptionsHelper.status(e), equalTo(status));
     * Compares two maps recursively, using arrays comparisons for byte[] through Arrays.equals(byte[], byte[])
        String extraInfo
                clusterBlockException
            final Object[] hitsSortValues = hits[i].getSortValues();
     * any of the shards threw an exception and if the response is serializable.
    public static void assertSearchHit(SearchResponse searchResponse, int number, Matcher<SearchHit> matcher) {
import org.opensearch.OpenSearchException;
import static org.hamcrest.Matchers.instanceOf;
import java.util.function.Function;
     *
    public static void assertFailures(SearchRequestBuilder searchRequestBuilder, RestStatus restStatus, Matcher<String> reasonMatcher) {
        assertHighlight(hit, field, fragment, greaterThan(fragment), matcher);
    }
                idsSet.remove(hit.getId()),
        assertBlocked(builder, (ClusterBlock) null);
                } catch (AssertionError error) {
        return subqueryType.cast(q.clauses().get(i).query());
    }
 * ownership. Elasticsearch licenses this file to you under
    /**
                "Count is "
    public static <E extends Throwable> void assertFutureThrows(ActionFuture<?> future, Class<E> exceptionClass, String extraInfo) {
import java.io.IOException;
    public static void assertAcked(CreateIndexResponse response) {
                    }
            builder.get();
        return msg.toString();
            msg.append("\n ").append(failure);
    public static void assertOrderedSearchHits(SearchResponse searchResponse, String... ids) {
    public static void assertSuggestionSize(Suggest searchSuggest, int entry, int size, String key) {
    public static void assertThirdHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {
            fail("SearchPhaseExecutionException expected but got " + e.getClass());
        assertThat("file/dir [" + file + "] should not exist.", Files.exists(file), is(false));
        } catch (Exception e) {
     */
import static org.hamcrest.Matchers.notNullValue;
     * @param timeout  The value of the timeout
    public static void assertHighlight(SearchHit hit, String field, int fragment, Matcher<String> matcher) {
        assertSearchHit(searchResponse, 1, matcher);
    public static <E extends Throwable> void assertRequestBuilderThrows(
    public static void assertRequestBuilderThrows(ActionRequestBuilder<?, ?> builder, RestStatus status, String extraInfo) {
 * KIND, either express or implied.  See the License for the
     */
            .append(response.getTotalShards())
 * The OpenSearch Contributors require contributions made to
/*
        assertThat("Expected at least one shard failure, got none", searchResponse.getShardFailures().length, greaterThan(0));
        int counter = 0;
import org.opensearch.search.SearchHit;
        }
        }
                assertThat(shardSearchFailure.status(), equalTo(restStatus));
    }
            extraInfo += " with status [" + status + "]";
    }
        if (status != null) {
    }
import static org.apache.lucene.tests.util.LuceneTestCase.expectThrows;
    }
            templateNames.add(indexTemplateMetadata.name());
                expectedMap = expectedParser.map();
     * Executes the request and fails if the request has not been blocked by a specific {@link ClusterBlock}.
        Throwable expected = expectThrowsAnyOf(Arrays.asList(exceptionClass, OpenSearchException.class), future::actionGet);
                    + formatShardStatus(countResponse)
import org.opensearch.common.Nullable;
import org.opensearch.common.unit.TimeValue;
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().size(), greaterThanOrEqualTo(entry));
        Class<E> exceptionClass,
import org.opensearch.action.search.ShardSearchFailure;
            assertArrayEquals("Offset " + Integer.toString(i) + ", id " + hits[i].getId(), sortValues[i], hitsSortValues);
    /**
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.search.BooleanQuery;
    }
        assertThat("ClusterHealthResponse has timed out - returned: [" + response + "]", response.isTimedOut(), is(false));
        for (Suggest.Suggestion.Entry.Option option : searchSuggest.getSuggestion(key).getEntries().get(0).getOptions()) {
 * this work for additional information regarding copyright
        } else {
        Iterator<Object> actualIterator = actual.iterator();
                    NotEqualMessageBuilder message = new NotEqualMessageBuilder();
        Exception e = expectThrows(Exception.class, future::actionGet);
                    if (clusterBlock.id() == expectedBlockId) {
        assertSuggestion(searchSuggest, entry, key, text.length, text);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        assertFutureThrows(future, exceptionClass, null, extraInfo);
}
 *
        assertFutureThrows(builder.execute(), status);
    public static void assertFirstHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {
            "Some expected ids were not found in search results: " + Arrays.toString(idsSet.toArray(new String[0])) + "." + shardStatus,
    /**
     */
        assertSearchResponse(searchResponse);
     * @param builder the request builder
    }
import java.util.Set;
    }
    /**
            actualMap = actualParser.map();
        for (int i = 0; i < sortValues.length; ++i) {
        String field,
     */
import org.apache.lucene.search.TotalHits;
            // don't need to be handled. Ordinary arrays get parsed as lists.
 * Licensed to Elasticsearch under one or more contributor
        }
import org.opensearch.search.suggest.Suggest;
        assertNoFailures(resp);
     * Check if a file exists
        return new OpenSearchMatchers.SearchHitHasScoreMatcher(score);
        }
    }
    }
import static org.apache.lucene.tests.util.LuceneTestCase.expectThrowsAnyOf;
                assertThat(shardSearchFailure.reason(), reasonMatcher);
    public static void assertBlocked(ActionRequestBuilder builder) {
                    throw new AssertionError("Error when comparing xContent.\n" + message.toString(), error);
        SearchResponse resp,
     */
                boolean found = false;
        assertSearchHit(searchResponse, 3, matcher);
import static org.hamcrest.Matchers.not;
        int fragment,
        assertNoTimeout(requestBuilder.get());
        }
                }
        return new OpenSearchMatchers.SearchHitHasIndexMatcher(index);
    public static void assertNoFailures(BulkResponse response) {
        Class<E> exceptionClass,
     * {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} hold the same content.
 */
     * Applies basic assertions on the SearchResponse. This method checks if all shards were successful, if
                }
            assertThat(extraInfo, ((OpenSearchException) expected).unwrapCause(), instanceOf(exceptionClass));
     *
     */
     * Assert that an index template exists
            }
    }
            if (expectedBlockId != null) {
import org.opensearch.action.support.broadcast.BroadcastResponse;
    public static void assertHighlight(SearchHit hit, String field, int fragment, int totalFragments, Matcher<String> matcher) {
import static org.hamcrest.CoreMatchers.equalTo;
 * license agreements. See the NOTICE file distributed with
            assertObjectEquals(expectedValue, actualValue);
        // 2) Jackson SMILE parser parses floats as double, which then get printed out as double (with double precision)
        }
        extraInfo += "expected a " + status + " status exception to be thrown";
    public static void assertAcked(DeleteIndexRequestBuilder builder) {
        return response;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
     * @param expectedBlock the expected block
            searchResponse.getShardFailures().length,
import org.opensearch.action.get.GetResponse;
     *
        final TotalHits totalHits = countResponse.getHits().getTotalHits();
     * @param extraInfo extra information to add to the failure message
import java.util.HashSet;
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
            .append(response.getSuccessfulShards())
                XContentParser expectedParser = mediaType.xContent()
     *
        assertBlocked(builder, expectedBlock != null ? expectedBlock.id() : null);
     * In case of a failure this will just throw an assertion error without any further message
        assertThat(hit.getHighlightFields().get(field).fragments()[fragment].string(), matcher);
    public static void assertRequestBuilderThrows(ActionRequestBuilder<?, ?> builder, RestStatus status) {
    }
            .append(" shard failures:");
                try {
        String field,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                for (ClusterBlock clusterBlock : e.blocks()) {
     */
            equalTo(replicatedBroadcastResponse.getTotalShards())
            fail("Request executed with success but a ClusterBlockException was expected");
 * this file be licensed under the Apache-2.0 license or a
     * Assert that an index template is missing
 * software distributed under the License is distributed on an
        }
        assertEquals(expected.size(), actual.size());
import java.util.Locale;
            assertThat("Expected shard failures, got none", searchResponse.getShardFailures().length, greaterThan(0));
    }
                assertThat(shardSearchFailure.reason(), reasonMatcher);
    }
    }
    }
     * Wait for a latch to countdown and provide a useful error message if it does not
        assertSearchHit(searchResponse, 4, matcher);
    public static void assertNoFailures(BroadcastResponse response) {
    /**
     * */
        }
        extraInfo = extraInfo == null || extraInfo.isEmpty() ? "" : extraInfo + ": ";
 * GitHub history for details.
    }
                assertObjectEquals(expectedValue, actualValue);
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
        assertThat(
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        String shardStatus = formatShardStatus(searchResponse);
        Matcher<String> matcher
        }
public class OpenSearchAssertions {
     * Asserts that the provided {@link BytesReference}s created through
    }
            Object expectedValue = expectedEntry.getValue();
    public static void assertHighlight(SearchResponse resp, int hit, String field, int fragment, Matcher<String> matcher) {
     */
import java.util.ArrayList;
        }
        for (ClusterBlock clusterBlock : clusterBlocks) {
import org.opensearch.common.action.ActionFuture;
            RestStatus status = checkRetryableBlock(e.blocks()) ? RestStatus.TOO_MANY_REQUESTS : RestStatus.FORBIDDEN;
    private static void assertHighlight(
        for (DefaultShardOperationFailedException exception : replicatedBroadcastResponse.getShardFailures()) {
    public static void assertAcked(AcknowledgedRequestBuilder<?, ?, ?> builder) {
import org.opensearch.core.rest.RestStatus;
    ) {
    public static void assertSuggestion(Suggest searchSuggest, int entry, String key, int size, String... text) {
            assertListEquals((List<Object>) expected, (List<Object>) actual);
        if (status != null) {
    }
import java.util.Iterator;
        for (IndexTemplateMetadata indexTemplateMetadata : templatesResponse.getIndexTemplates()) {
    ) {
        List<String> templateNames = new ArrayList<>();
     * Executes the request and fails if the request has not been blocked by a specific {@link ClusterBlock}.
                "id [" + hit.getId() + "] was found in search results but wasn't expected (index [" + hit.getIndex() + "])" + shardStatus,
    }
     * @param latch    The latch to wait for
    }
    }
import java.util.concurrent.TimeUnit;
    /**
        );
            RestStatus status = checkRetryableBlock(clusterBlockException.blocks()) ? RestStatus.TOO_MANY_REQUESTS : RestStatus.FORBIDDEN;
        assertThat(counter, equalTo(numberOfPhraseExists));
    public static <E extends Throwable> void assertFutureThrows(ActionFuture<?> future, Class<E> exceptionClass) {
    /**
    public static Matcher<SearchHit> hasId(final String id) {
            SearchHit hit = searchResponse.getHits().getHits()[i];
    public static void assertFourthHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {
     * @param unit     The unit of the timeout
    }
            assertThat(e.blocks().size(), greaterThan(0));
                Object actualValue = actual.get(expectedKey);
import org.opensearch.action.bulk.BulkResponse;
    public static Matcher<SearchHit> hasScore(final float score) {
        msg.append(" Total shards: ")
 *
        assertSearchHit(searchResponse, 2, matcher);
        int fragment,
import org.apache.lucene.search.Query;
        assertNoFailures(resp);
 * under the License.
            "all shard requests should have failed",
        assertThat(templateNames, hasItem(name));
    }
    }
    ) {
            );
            response.isShardsAcknowledged()
    public static Matcher<SearchHit> hasMatchedQueries(final String[] matchedQueries) {
    }
    public static void assertHighlight(
                    message.compareMaps(actualMap, expectedMap);
            assertThat(actual, instanceOf(Map.class));
            && totalHits.value() >= minHitCount
    /**
    /**
    public static void assertSortValues(SearchResponse searchResponse, Object[]... sortValues) {
        assertThat("not enough hits", resp.getHits().getHits().length, greaterThan(hit));
    /**
        assertThat("file/dir [" + file + "] should exist.", Files.exists(file), is(true));
        ActionFuture<?> future,
import java.util.Map;
     * Run future.actionGet() and check that it throws an exception of the right type, optionally checking the exception's rest status
        assertThat(msg, searchSuggest.getSuggestion(key).getName(), equalTo(key));
                "expected the cause of failure to be a ClusterBlockException but got " + exception.getCause().getMessage(),
                    + " inclusive. "
            ) {
        assertThat("Unexpected ShardFailures: " + Arrays.toString(response.getShardFailures()), response.getFailedShards(), equalTo(0));
    }
        msg.append(" Total shards: ")
        assertThat("Unexpected ShardFailures: " + response.buildFailureMessage(), response.hasFailures(), is(false));
    public static void assertFutureThrows(ActionFuture<?> future, RestStatus status, String extraInfo) {
        // we can either run into partial or total failures depending on the current number of shards
        // 1) whenever anything goes through a map while parsing, ordering is not preserved, which is perfectly ok
    /**
import org.hamcrest.CoreMatchers;
        assertEquals(0, searchResponse.getHits().getHits().length);
        Map<String, Object> expectedMap = null;
    }
        assertThat(hit.getHighlightFields(), hasKey(field));
import org.hamcrest.core.CombinableMatcher;
        }
        assertThat(message, response.isExists(), is(true));
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            assertThat(e.toString(), reasonMatcher);
        SearchHit hit,
    }
            .append(" Successful shards: ")
    public static void assertIndexTemplateExists(GetIndexTemplatesResponse templatesResponse, String name) {
    private static boolean checkRetryableBlock(Set<ClusterBlock> clusterBlocks) {
    }
            try (
    public static void assertNoTimeout(ClusterHealthResponse response) {
     * state update was successful and that the requisite number of shard copies were started before returning.
    public static void assertSearchHits(SearchResponse searchResponse, String... ids) {
     * Run the request from a given builder and check that it throws an exception of the right type, with a given {@link RestStatus}
        // we tried comparing byte per byte, but that didn't fly for a couple of reasons:
import static org.hamcrest.MatcherAssert.assertThat;
    public static String formatShardStatus(SearchResponse response) {
 * Unless required by applicable law or agreed to in writing,
        }
     * Checks that all shard requests of a replicated broadcast request failed due to a cluster block
     * Check if a file does not exist
                ClusterBlockException.class
            response.getClass().getSimpleName() + " failed - index creation acked but not all shards were started",
        for (SearchHit hit : searchResponse.getHits()) {
            equalTo(0)
        ActionRequestBuilder<?, ?> builder,
        assertNoFailures(response);
                counter++;
    }
import org.opensearch.action.search.SearchRequestBuilder;
    public static SearchResponse assertSearchResponse(SearchRequestBuilder request) {
    ) {
                assertThat("Request should have been blocked by [" + expectedBlockId + "] instead of " + e.blocks(), found, equalTo(true));
        assertFutureThrows(future, exceptionClass, status, null);
    public static SearchResponse assertSearchResponse(SearchResponse response) {
        }
        }
    }
        assertFutureThrows(future, exceptionClass, null, null);
 */
            // byte[] is really a special case for binary values when comparing SMILE and CBOR, arrays of other types
    public static void assertSuggestionPhraseCollateMatchExists(Suggest searchSuggest, String key, int numberOfPhraseExists) {
        ) {
        for (DefaultShardOperationFailedException failure : response.getShardFailures()) {
        if (totalHits.relation() != TotalHits.Relation.EQUAL_TO || totalHits.value() != expectedHitCount) {
     */
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, expected.streamInput())
        assertAcked(builder.get());
    ) {
    }
        int fragment,
     * Run the request from a given builder and check that it throws an exception of the right type
    }
import static org.junit.Assert.assertNotNull;
            idsSet.size(),
        final TotalHits totalHits = countResponse.getHits().getTotalHits();
     * any of the shards threw an exception and if the response is serializable.
import org.opensearch.action.search.SearchResponse;
    }
     * Run future.actionGet() and check that it throws an exception of the right type
            }
            assertMapEquals((Map<String, Object>) expected, (Map<String, Object>) actual);
        return new OpenSearchMatchers.SearchHitHasIdMatcher(id);
     * @param exceptionClass expected exception class
    public static void assertNotHighlighted(SearchResponse resp, int hit, String field) {
    }
        assertThat(resp.getHits().getHits()[hit].getHighlightFields(), not(hasKey(field)));
     */
        assertFutureThrows(builder.execute(), status, extraInfo);
import org.opensearch.cluster.metadata.IndexMetadata;
        assertHighlight(resp.getHits().getHits()[hit], field, fragment, fragmentsMatcher, matcher);
        assertThat("not enough hits", resp.getHits().getHits().length, greaterThan(hit));
import org.opensearch.core.xcontent.XContentParser;
        return assertSearchResponse(request.get());
            assertThat(e.status(), equalTo(restStatus));
            templateNames.add(indexTemplateMetadata.name());
import java.util.concurrent.CountDownLatch;
            assertNotNull(
        assertThat(searchSuggest, notNullValue());
     *
    /**
        assertThat(
    }
        }
    }
        assertThat(hit.getHighlightFields().get(field).fragments().length, fragmentsMatcher);
        assertThat(searchSuggest, notNullValue());
        } catch (ClusterBlockException e) {
import static org.hamcrest.Matchers.hasKey;
            .append(" Successful shards: ")
     * text.
        String field,
        if (expected instanceof OpenSearchException) {
    /**
        assertThat(
    /**
    public static <T extends Query> T assertBooleanSubQuery(Query query, Class<T> subqueryType, int i) {
     */
        );
                exception.getCause(),
     * Run the request from a given builder and check that it throws an exception of the right type
            assertSuggestion(searchSuggest, entry, i, key, text[i]);
    }
    public static void assertToXContentEquivalent(BytesReference expected, BytesReference actual, MediaType mediaType) throws IOException {
        assertNoFailures(response);
        }
            } else {
        return OpenSearchMatchers.HasPropertyLambdaMatcher.hasProperty(property, valueMatcher);
        for (Map.Entry<String, Object> expectedEntry : expected.entrySet()) {
    }
        assertThat(q.clauses().size(), greaterThan(i));
    }
 * compatible open source license.
            assertThat(clusterBlockException.status(), CoreMatchers.equalTo(status));
import org.opensearch.ExceptionsHelper;
        assertThat(message, isCountedDown, is(true));
            Object actualValue = actualIterator.next();
    }
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().get(entry).getOptions().get(ord).getText().string(), equalTo(text));
        try {
            }
        assertThat(templateNames, not(hasItem(name)));
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param extraInfo extra information to add to the failure message
    private static void assertListEquals(List<Object> expected, List<Object> actual) {
    }
        }
    public static <E extends Throwable> void assertRequestBuilderThrows(
        String msg = "Suggest result: " + searchSuggest.toString();
    public static void assertBlocked(final ActionRequestBuilder builder, @Nullable final Integer expectedBlockId) {
     * @param status         {@link RestStatus} to check for. Can be null to disable the check
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().get(entry).getOptions().size(), equalTo(size));
        } catch (SearchPhaseExecutionException e) {
                equalTo(true)
        int hit,
import static org.junit.Assert.assertArrayEquals;
                    + minHitCount
    }
        assertHighlight(resp, hit, field, fragment, equalTo(totalFragments), matcher);
/*
    }
    }
    private static void assertHighlight(
            if (expectedValue == null) {
     * Assert suggestion returns exactly the provided text.
    /**
import java.util.List;
     * Executes the request and fails if the request has not been blocked.
    public static void assertSuggestion(Suggest searchSuggest, int entry, int ord, String key, String text) {
        try (
        Matcher<String> matcher
    public static void assertNoSearchHits(SearchResponse searchResponse) {
            }
    }
    /**
 * You may obtain a copy of the License at
     */
    public static void assertNoFailures(SearchResponse searchResponse) {
                    assertMapEquals(expectedMap, actualMap);
        assertThat(q.clauses().get(i).query(), instanceOf(subqueryType));
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
        TimeValue timeValue = new TimeValue(timeout, unit);
        assertEquals(expected.size(), actual.size());
        Map<String, Object> actualMap = null;
        assertThat(response.getClass().getSimpleName() + " failed - not acked", response.isAcknowledged(), equalTo(true));
     */
        @Nullable RestStatus status,
            assertThat(
    }
            .append(" & ")
        int hit,
     * Compares two lists recursively, but using arrays comparisons for byte[] through Arrays.equals(byte[], byte[])
        );
        assertThat(msg, searchSuggest.size(), greaterThanOrEqualTo(1));
    }
    /**
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().get(entry).getOptions().size(), greaterThan(ord));
        assertThat(searchResponse.getHits().getAt(number - 1), matcher);
    }
    private static void assertObjectEquals(Object expected, Object actual) {
    /**
            for (ShardSearchFailure shardSearchFailure : searchResponse.getShardFailures()) {
        if (!(totalHits.relation() == TotalHits.Relation.EQUAL_TO
        try {
                    + maxHitCount
    public static void assertAllSuccessful(SearchResponse response) {
    public static <E extends Throwable> void assertRequestBuilderThrows(ActionRequestBuilder<?, ?> builder, Class<E> exceptionClass) {
    }
            assertThat(extraInfo, expected, instanceOf(exceptionClass));
     */
        assertFutureThrows(builder.execute(), exceptionClass, extraInfo);
            assertThat("Expected id: " + ids[i] + " at position " + i + " but wasn't." + shardStatus, hit.getId(), equalTo(ids[i]));
    }
        // when the number for shards is randomized and we expect failures
        assertHighlight(hit, field, fragment, equalTo(totalFragments), matcher);
        assertThat(number, greaterThan(0));
     */
        }
        Matcher<String> matcher
    public static void assertIndexTemplateMissing(GetIndexTemplatesResponse templatesResponse, String name) {
