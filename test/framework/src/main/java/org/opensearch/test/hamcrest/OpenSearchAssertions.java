                    throw new AssertionError("Error when comparing xContent.\n" + message.toString(), error);
        assertHighlight(hit, field, fragment, equalTo(totalFragments), matcher);
            );
        if (status != null) {
            }
        }
    public static void assertFirstHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {
     * @param unit     The unit of the timeout
        }
    }
    }
    }  
        assertNoFailures(response);
        Class<E> exceptionClass,
        extraInfo = extraInfo == null || extraInfo.isEmpty() ? "" : extraInfo + ": ";
        // Note that byte[] holding binary values need special treatment as they need to be properly compared item per item.
    }
import org.opensearch.action.bulk.BulkResponse;
                    + totalHits
    public static void assertAcked(CreateIndexResponse response) {  
     * any of the shards threw an exception and if the response is serializable.  
    }
                assertThat(shardSearchFailure.reason(), reasonMatcher);
    }  
        assertThat("file/dir [" + file + "] should exist.", Files.exists(file), is(true));
        assertNoFailures(response);
        return msg.toString();  
            assertThat(extraInfo, expected, instanceOf(exceptionClass));
    }
    /**
    public static String formatShardStatus(BroadcastResponse response) {  
    public static void assertBlocked(ActionRequestBuilder builder) {
            "all shard requests should have failed",
 * Modifications Copyright OpenSearch Contributors. See  
     * {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} hold the same content.
        List<String> templateNames = new ArrayList<>();
    public static Matcher<SearchHit> hasId(final String id) {
        return (response) -> response.getSourceAsMap().get(fieldName);
     * Assert suggestion returns exactly the provided text.
     *
import java.nio.file.Path;  
        ActionFuture<?> future,  
    }
    }
        return assertSearchResponse(request.get());
        } else if (expected instanceof List) {
        assertThat("not enough hits", resp.getHits().getHits().length, greaterThan(hit));
    /*
 */  
            fail("Request executed with success but a ClusterBlockException was expected");  
        }
    /**
    }
    /**
    public static void assertHitCount(SearchResponse countResponse, long minHitCount, long maxHitCount) {  
            assertThat(e.toString(), reasonMatcher);
        assertSuggestion(searchSuggest, entry, key, text.length, text);
            .append(response.getSuccessfulShards())
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
    public static void assertRequestBuilderThrows(ActionRequestBuilder<?, ?> builder, RestStatus status, String extraInfo) {
 * SPDX-License-Identifier: Apache-2.0
            XContentParser actualParser = mediaType.xContent()
        assertThat("not enough hits", resp.getHits().getHits().length, greaterThan(hit));
     */  
    public static String formatShardStatus(SearchResponse response) {  
        @Nullable RestStatus status,
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().get(entry).getOptions().size(), greaterThan(ord));  
            assertThat(  
import org.opensearch.core.xcontent.ToXContent;  
        assertFutureThrows(builder.execute(), exceptionClass, extraInfo);
        }
    }
        return new OpenSearchMatchers.SearchHitMatchedQueriesMatcher(matchedQueries);  
    /**
            if (clusterBlock.id() != IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK.id()) {
                }
    public static Matcher<SearchHit> hasIndex(final String index) {  
        assertThat(
        }  
    public static void assertHighlight(SearchResponse resp, int hit, String field, int fragment, Matcher<String> matcher) {
import org.opensearch.core.xcontent.MediaType;
     * any of the shards threw an exception and if the response is serializable.
     * for byte[] through Arrays.equals(byte[], byte[])
import java.util.Iterator;
    }
 *  
     */
    ) {
    }
        for (DefaultShardOperationFailedException exception : replicatedBroadcastResponse.getShardFailures()) {
        Set<String> idsSet = new HashSet<>(Arrays.asList(ids));
    }
import org.opensearch.common.unit.TimeValue;
        for (Object expectedValue : expected) {
    }
    /**
     * Executes the request and fails if the request has not been blocked by a specific {@link ClusterBlock}.
    }
     * Compares two objects, recursively walking eventual maps and lists encountered, and using arrays comparisons  
     */
        }
import org.opensearch.action.search.SearchRequestBuilder;
import static org.hamcrest.Matchers.hasKey;
    public static void assertNotHighlighted(SearchResponse resp, int hit, String field) {
    public static void assertThirdHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {
    }  
            Object actualValue = actualIterator.next();  
        assertFutureThrows(builder.execute(), exceptionClass);
    }  
        assertFutureThrows(builder.execute(), status);
    }  
            assertEquals(expected, actual);  
    public static void assertSecondHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {  
    public static void assertIndexTemplateExists(GetIndexTemplatesResponse templatesResponse, String name) {  
    public static <T, V> CombinableMatcher<T> hasProperty(Function<? super T, ? extends V> property, Matcher<V> valueMatcher) {  
        extraInfo += "expected a " + exceptionClass + " exception to be thrown";  
        Exception e = expectThrows(Exception.class, future::actionGet);
    public static Matcher<SearchHit> hasMatchedQueries(final String[] matchedQueries) {
        Matcher<String> matcher
            Object expectedValue = expectedEntry.getValue();
        assertNoFailures(resp);  
        } else {  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
     */
        assertNoFailures(resp);  
     *
        assertThat(q.clauses().get(i).query(), instanceOf(subqueryType));  
        assertSuggestionSize(searchSuggest, entry, size, key);
            replicatedBroadcastResponse.getFailedShards(),
import org.opensearch.core.xcontent.XContentParser;
     * Often latches are called as <code>assertTrue(latch.await(1, TimeUnit.SECONDS));</code>  
        ActionRequestBuilder<?, ?> builder,  
        int fragment,
        msg.append(" Total shards: ")
            );
        }  
        int hit,  
        StringBuilder msg = new StringBuilder();
    /**
    }
 */
        }
        if (status != null) {
        assertAcked(builder.get());
        }  
        assertThat(  
    /**  
            // byte[] is really a special case for binary values when comparing SMILE and CBOR, arrays of other types
        for (DefaultShardOperationFailedException failure : response.getShardFailures()) {  
     * Check if a file does not exist  
        );
    public static void assertBlocked(final ActionRequestBuilder builder, @Nullable final ClusterBlock expectedBlock) {
    public static void assertAcked(AcknowledgedRequestBuilder<?, ?, ?> builder) {  
        for (ShardSearchFailure failure : response.getShardFailures()) {  
import java.util.concurrent.TimeUnit;
    private static void assertHighlight(
                "id [" + hit.getId() + "] was found in search results but wasn't expected (index [" + hit.getIndex() + "])" + shardStatus,
     */
        }
    }
import static org.junit.Assert.assertTrue;
        final TotalHits totalHits = countResponse.getHits().getTotalHits();
        }
     * Applies basic assertions on the SearchResponse. This method checks if all shards were successful, if
        assertThat("ClusterHealthResponse has timed out - returned: [" + response + "]", response.isTimedOut(), is(false));  
     * @param builder the request builder
        }
     * @param extraInfo      extra information to add to the failure message. Can be null.  
            assertThat("Expected id: " + ids[i] + " at position " + i + " but wasn't." + shardStatus, hit.getId(), equalTo(ids[i]));
     * @param latch    The latch to wait for  
        return new OpenSearchMatchers.SearchHitHasScoreMatcher(score);
    /**
            assertThat(clusterBlockException.blocks().size(), greaterThan(0));
import org.opensearch.core.rest.RestStatus;
     */
    }  
        msg.append(" Total shards: ")
     */
            && totalHits.value() <= maxHitCount)) {
        @Nullable String extraInfo  
            assertSuggestion(searchSuggest, entry, i, key, text[i]);  
            }
                return false;  
        BooleanQuery q = (BooleanQuery) query;
            equalTo(0)  
    }
    /**
 * the Apache License, Version 2.0 (the "License"); you may
                clusterBlockException  
            SearchResponse searchResponse = searchRequestBuilder.get();  
            if (expectedBlockId != null) {  
        for (int i = 0; i < ids.length; i++) {
import java.util.List;
        assertThat(msg, searchSuggest.size(), greaterThanOrEqualTo(1));  
     * @param builder the request builder  
import static org.hamcrest.CoreMatchers.equalTo;
    /**  
    }  
            actualMap = actualParser.map();
    public static void assertSuggestionSize(Suggest searchSuggest, int entry, int size, String key) {
import static org.hamcrest.Matchers.not;  
        assertThat(msg, searchSuggest.getSuggestion(key).getName(), equalTo(key));  
        assertThat(templateNames, hasItem(name));
        for (int i = 0; i < text.length; i++) {
    }
     * Run the request from a given builder and check that it throws an exception of the right type
        assertThat(resp.getHits().getHits()[hit].getHighlightFields(), not(hasKey(field)));
    }
            RestStatus status = checkRetryableBlock(e.blocks()) ? RestStatus.TOO_MANY_REQUESTS : RestStatus.FORBIDDEN;  
        assertThat("Expected at least one shard failure, got none", searchResponse.getShardFailures().length, greaterThan(0));
    public static void assertSuggestionPhraseCollateMatchExists(Suggest searchSuggest, String key, int numberOfPhraseExists) {
            assertArrayEquals("Offset " + Integer.toString(i) + ", id " + hits[i].getId(), sortValues[i], hitsSortValues);
            response.getClass().getSimpleName() + " failed - index creation acked but not all shards were started",  
    public static <E extends Throwable> void assertFutureThrows(ActionFuture<?> future, Class<E> exceptionClass, String extraInfo) {  
import org.apache.lucene.search.Query;
    }  
import org.apache.lucene.search.TotalHits;
     */
        assertHighlight(hit, field, fragment, greaterThan(fragment), matcher);  
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().size(), greaterThanOrEqualTo(entry));
            fail("Count is " + totalHits + " but " + expectedHitCount + " was expected. " + formatShardStatus(countResponse));
        assertBlocked(builder, (ClusterBlock) null);
import org.opensearch.ExceptionsHelper;  
            String expectedKey = expectedEntry.getKey();  
        assertThat(searchResponse.getHits().getAt(number - 1), matcher);
        try {
        Class<E> exceptionClass,
    @SuppressWarnings("unchecked")  
        // when the number for shards is randomized and we expect failures  
    }
     */
        assertThat("file/dir [" + file + "] should not exist.", Files.exists(file), is(false));  
    }
     * text.
            if (option.collateMatch()) {
        assertSearchHit(searchResponse, 3, matcher);
    }  
    }  
     */  
            templateNames.add(indexTemplateMetadata.name());
        for (IndexTemplateMetadata indexTemplateMetadata : templatesResponse.getIndexTemplates()) {
            msg.append("\n ").append(failure);
        Matcher<Integer> fragmentsMatcher,  
 */
    }
    public static void assertNoTimeout(ClusterHealthRequestBuilder requestBuilder) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertNoFailures(response);  
        assertThat(message, isCountedDown, is(true));  
import java.util.concurrent.CountDownLatch;  
    public static void assertSortValues(SearchResponse searchResponse, Object[]... sortValues) {
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().get(entry).getOptions().size(), equalTo(size));
                idsSet.remove(hit.getId()),
    /**
    }
    /**  
    public static Function<SearchHit, Object> fieldFromSource(String fieldName) {
public class OpenSearchAssertions {
    }  
                try {
            searchResponse.getShardFailures().length,
                equalTo(true)  
import static org.hamcrest.Matchers.hasItem;  
     *
import static org.hamcrest.CoreMatchers.is;
    public static <E extends Throwable> void assertRequestBuilderThrows(ActionRequestBuilder<?, ?> builder, Class<E> exceptionClass) {
    }  
        assertFutureThrows(builder.execute(), exceptionClass, status);
    public static void assertNoFailures(BulkResponse response) {
            fail("SearchPhaseExecutionException expected but got " + e.getClass());
            } else {
            && totalHits.value() >= minHitCount  
     * Check if a file exists
     */
import org.opensearch.core.xcontent.XContentBuilder;
    }
        );
     * Run future.actionGet() and check that it throws an exception of the right type, optionally checking the exception's rest status
 * this work for additional information regarding copyright
import org.opensearch.common.Nullable;  
            assertThat(extraInfo, ((OpenSearchException) expected).unwrapCause(), instanceOf(exceptionClass));
        if (expected instanceof OpenSearchException) {
    }  
        int fragment,
    public static <E extends Throwable> void assertFutureThrows(
        ) {
    ) {  
        ActionRequestBuilder<?, ?> builder,
        }
            response.isShardsAcknowledged()
        assertNoTimeout(requestBuilder.get());
        }
import java.util.Map;
        return true;  
import org.opensearch.action.search.SearchPhaseExecutionException;
        return msg.toString();  
import org.opensearch.OpenSearchException;
    private static void assertListEquals(List<Object> expected, List<Object> actual) {
 * software distributed under the License is distributed on an
            .append(" Successful shards: ")
            .append(response.getFailedShards())
     * Run the request from a given builder and check that it throws an exception of the right type, with a given {@link RestStatus}  
 * The OpenSearch Contributors require contributions made to  
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().get(entry).getOptions().get(ord).getText().string(), equalTo(text));
    public static void assertSearchHits(SearchResponse searchResponse, String... ids) {
    public static void assertBlocked(final ActionRequestBuilder builder, @Nullable final Integer expectedBlockId) {  
    }
    }  
        final TotalHits totalHits = countResponse.getHits().getTotalHits();  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.SearchHit;  
import org.opensearch.action.search.ShardSearchFailure;
    /**  
            "Some expected ids were not found in search results: " + Arrays.toString(idsSet.toArray(new String[0])) + "." + shardStatus,
/*
    public static void assertHighlight(  
import static org.junit.Assert.assertNotNull;  
        Iterator<Object> actualIterator = actual.iterator();
        assertThat("Expected all shards successful", response.getSuccessfulShards(), equalTo(response.getTotalShards()));
     */  
            );
                        found = true;
                    + minHitCount  
            for (ShardSearchFailure shardSearchFailure : searchResponse.getShardFailures()) {
        assertThat("SearchHit number must be greater than 0", number, greaterThan(0));
            ClusterBlockException clusterBlockException = (ClusterBlockException) ExceptionsHelper.unwrap(  
                    + formatShardStatus(countResponse)
    public static void assertRequestBuilderThrows(ActionRequestBuilder<?, ?> builder, RestStatus status) {  
        int fragment,
        String shardStatus = formatShardStatus(searchResponse);
        StringBuilder msg = new StringBuilder();
     */
     *  
    }  
        assertFutureThrows(builder.execute(), status, extraInfo);
    public static void assertSuggestion(Suggest searchSuggest, int entry, int ord, String key, String text) {  
import org.opensearch.action.ActionRequestBuilder;
                    if (clusterBlock.id() == expectedBlockId) {  
     * Run future.actionGet() and check that it throws an exception of the right type  
    public static void assertSuggestion(Suggest searchSuggest, int entry, String key, String... text) {
    public static void assertFailures(SearchRequestBuilder searchRequestBuilder, RestStatus restStatus, Matcher<String> reasonMatcher) {
     */  
        assertThat(extraInfo, ExceptionsHelper.status(e), equalTo(status));
    private static void assertHighlight(
                    + maxHitCount
    }
    /**
            try (  
            equalTo(0)
    public static void assertFutureThrows(ActionFuture<?> future, RestStatus status) {
import org.apache.lucene.search.BooleanQuery;  
        assertThat(searchSuggest, notNullValue());
        assertThat(msg, searchSuggest.getSuggestion(key).getName(), equalTo(key));
        String message = String.format(Locale.ROOT, "expected latch to be counted down after %s, but was not", timeValue);
    /**
        try {
import org.hamcrest.CoreMatchers;  
     */  
import org.opensearch.cluster.block.ClusterBlockException;  
        // we can either run into partial or total failures depending on the current number of shards
        // 2) Jackson SMILE parser parses floats as double, which then get printed out as double (with double precision)  
    /**
     * @throws InterruptedException An exception if the waiting is interrupted  
import org.opensearch.core.common.bytes.BytesReference;
            .append(" & ")  
     * Asserts that the provided {@link BytesReference}s created through
        for (Suggest.Suggestion.Entry.Option option : searchSuggest.getSuggestion(key).getEntries().get(0).getOptions()) {  
     * @param extraInfo extra information to add to the failure message
    /**
        // check only retryable blocks exist in the set  
    public static <E extends Throwable> void assertRequestBuilderThrows(
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        assertThat(response.getClass().getSimpleName() + " failed - not acked", response.isAcknowledged(), equalTo(true));
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
        for (SearchHit hit : searchResponse.getHits()) {
            "Unexpected ShardFailures: " + Arrays.toString(searchResponse.getShardFailures()),  
        TimeValue timeValue = new TimeValue(timeout, unit);  
        assertThat(query, instanceOf(BooleanQuery.class));  
    }
    }
        assertBlocked(builder, expectedBlock != null ? expectedBlock.id() : null);
        assertFutureThrows(future, exceptionClass, null, extraInfo);
     */
import java.util.ArrayList;
            assertNotNull(
        boolean isCountedDown = latch.await(timeout, unit);
import static org.apache.lucene.tests.util.LuceneTestCase.expectThrowsAnyOf;  
                assertThat(shardSearchFailure.status(), equalTo(restStatus));  
    public static void assertNoFailures(SearchResponse searchResponse) {
    /**
        assertHighlight(resp, hit, field, fragment, greaterThan(fragment), matcher);  
        extraInfo += "expected a " + status + " status exception to be thrown";
        assertEquals(expected.size(), actual.size());
     * Also binary values (byte[]) are properly compared through arrays comparisons.
        Class<E> exceptionClass,
        }
        String field,
            equalTo(replicatedBroadcastResponse.getTotalShards())  
        for (Map.Entry<String, Object> expectedEntry : expected.entrySet()) {
    public static void assertFileExists(Path file) {
import org.opensearch.action.support.broadcast.BroadcastResponse;
            );  
        // 1) whenever anything goes through a map while parsing, ordering is not preserved, which is perfectly ok
        Throwable expected = expectThrowsAnyOf(Arrays.asList(exceptionClass, OpenSearchException.class), future::actionGet);  
                assertThat(shardSearchFailure.reason(), reasonMatcher);
        assertThat("Expected all shards successful", response.getSuccessfulShards(), equalTo(response.getTotalShards()));  
    /**
    }
            }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    public static void assertNoTimeout(ClusterHealthResponse response) {
package org.opensearch.test.hamcrest;
                ClusterBlockException.class
import java.nio.file.Files;
        Matcher<Integer> fragmentsMatcher,  
        assertThat(response.getClass().getSimpleName() + " failed - not acked", response.isAcknowledged(), equalTo(true));
            assertArrayEquals((byte[]) expected, (byte[]) actual);
                        break;
        return subqueryType.cast(q.clauses().get(i).query());
     * @param replicatedBroadcastResponse the response that should only contain failed shard responses
import java.util.Arrays;
import org.hamcrest.core.CombinableMatcher;
            .append(" & ")  
        assertTrue(
import org.opensearch.test.NotEqualMessageBuilder;
        assertThat(number, greaterThan(0));
     */
        assertThat(msg, searchSuggest.size(), greaterThanOrEqualTo(1));
import org.opensearch.common.action.ActionFuture;
import org.opensearch.search.suggest.Suggest;
    public static void assertIndexTemplateMissing(GetIndexTemplatesResponse templatesResponse, String name) {
        assertThat(templateNames, not(hasItem(name)));  
     */
    public static void assertSearchHit(SearchResponse searchResponse, int number, Matcher<SearchHit> matcher) {  
    }  
            assertMapEquals((Map<String, Object>) expected, (Map<String, Object>) actual);
        if (expected instanceof Map) {
    public static void assertHighlight(SearchHit hit, String field, int fragment, int totalFragments, Matcher<String> matcher) {  
        return response;
 * Licensed to Elasticsearch under one or more contributor  
    }
    public static void assertNoFailures(BroadcastResponse response) {  
        assertThat(hit.getHighlightFields(), hasKey(field));  
     * */
 * GitHub history for details.
        assertHighlight(resp, hit, field, fragment, equalTo(totalFragments), matcher);
     * Compares two lists recursively, but using arrays comparisons for byte[] through Arrays.equals(byte[], byte[])  
        );  
        extraInfo = extraInfo == null || extraInfo.isEmpty() ? "" : extraInfo + ": ";
        RestStatus status
            fail(
import static org.junit.Assert.assertEquals;
            if (expectedValue == null) {
    }
    }
     * Applies basic assertions on the SearchResponse. This method checks if all shards were successful, if  
        assertAcked(builder.get());
    /**
import java.util.function.Function;
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, actual.streamInput())  
                assertObjectEquals(expectedValue, actualValue);  
    }
    public static void assertAcked(AcknowledgedResponse response) {  
            }  
        assertFutureThrows(future, exceptionClass, status, null);
    public static SearchResponse assertSearchResponse(SearchResponse response) {
     */
            extraInfo += " with status [" + status + "]";  
    }  
            .append(" Successful shards: ")
            .append(response.getFailedShards())
import org.opensearch.cluster.metadata.IndexMetadata;
        assertSearchHit(searchResponse, 4, matcher);  
    }
     * Compares two maps recursively, using arrays comparisons for byte[] through Arrays.equals(byte[], byte[])
        assertThat("Unexpected ShardFailures: " + Arrays.toString(response.getShardFailures()), response.getFailedShards(), equalTo(0));
     */
        String extraInfo  
    /**
    }
import static org.junit.Assert.assertArrayEquals;
     * Run future.actionGet() and check that it throws an exception of the right type, with a given {@link RestStatus}
            final Object[] hitsSortValues = hits[i].getSortValues();  
            assertThat(e.status(), equalTo(restStatus));
        SearchHit[] hits = searchResponse.getHits().getHits();  
     */
        assertEquals(0, searchResponse.getHits().getHits().length);
        } catch (SearchPhaseExecutionException e) {  
                XContentParser expectedParser = mediaType.xContent()
    }
    }
        assertThat(hit.getHighlightFields().get(field).fragments().length, fragmentsMatcher);
            .append(" shard failures:");
        assertThat(hit.getHighlightFields().get(field).fragments()[fragment].string(), matcher);
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;  
        assertFutureThrows(future, exceptionClass, null, null);  
        Matcher<String> matcher
     * Checks that all shard requests of a replicated broadcast request failed due to a cluster block  
            assertThat(actual, instanceOf(Map.class));  
        assertThat(q.clauses().size(), greaterThan(i));
        );
        assertSearchResponse(searchResponse);
}  
            RestStatus status = checkRetryableBlock(clusterBlockException.blocks()) ? RestStatus.TOO_MANY_REQUESTS : RestStatus.FORBIDDEN;
    public static void assertHighlight(SearchHit hit, String field, int fragment, Matcher<String> matcher) {
            SearchHit hit = searchResponse.getHits().getHits()[i];  
        assertThat(  
            msg.append("\n ").append(failure);
                }
    public static SearchResponse assertSearchResponse(SearchRequestBuilder request) {  
                "expected the cause of failure to be a ClusterBlockException but got " + exception.getCause().getMessage(),
        }  
    }  
import java.io.IOException;
        assertThat(counter, equalTo(numberOfPhraseExists));  
     * Run the request from a given builder and check that it throws an exception of the right type
    public static <E extends Throwable> void assertFutureThrows(ActionFuture<?> future, Class<E> exceptionClass) {
/*
    public static void assertFileNotExists(Path file) {
        if (totalHits.relation() != TotalHits.Relation.EQUAL_TO || totalHits.value() != expectedHitCount) {
     *  
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, expected.streamInput())
    }  
    public static void assertFourthHit(SearchResponse searchResponse, Matcher<SearchHit> matcher) {
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.MatcherAssert.assertThat;  
                Object actualValue = actual.get(expectedKey);
import static org.hamcrest.Matchers.greaterThan;
    public static Matcher<SearchHit> hasScore(final float score) {
                counter++;
        assertEquals(sortValues.length, hits.length);
     * @param builder the request builder
import org.hamcrest.Matcher;
        try (
 * specific language governing permissions and limitations
 *
            .append(" shard failures:");
    ) {
                    + " and "
                boolean found = false;
        assertThat(message, response.isExists(), is(true));
    }
            idsSet.size(),
    ) {
        String msg = "Suggest result: " + searchSuggest.toString();
     * Assert that an index template exists
import org.opensearch.core.xcontent.DeprecationHandler;  
                    NotEqualMessageBuilder message = new NotEqualMessageBuilder();
            assertThat(extraInfo, ExceptionsHelper.status(expected), equalTo(status));
import org.opensearch.cluster.block.ClusterBlock;
     * Assert that an index creation was fully acknowledged, meaning that both the index creation cluster  
    ) {
    }  
            assertThat(e.status(), equalTo(status));
import static org.apache.lucene.tests.util.LuceneTestCase.expectThrows;
        } catch (Exception e) {
    public static void assertAllSuccessful(SearchResponse response) {  
        assertSearchHit(searchResponse, 1, matcher);  
    public static <E extends Throwable> void assertRequestBuilderThrows(  
        List<String> templateNames = new ArrayList<>();
     * Assert that an index template is missing
        int totalFragments,
    /**  
        for (int i = 0; i < sortValues.length; ++i) {
     * Assert suggestion returns size suggestions and the first are the provided  
    }
        // we tried comparing byte per byte, but that didn't fly for a couple of reasons:
     * Wait for a latch to countdown and provide a useful error message if it does not
            .append(response.getSuccessfulShards())
                    + " inclusive. "  
            // don't need to be handled. Ordinary arrays get parsed as lists.  
    }
     * matchers  
     * @param exceptionClass expected exception class
    public static void awaitLatch(CountDownLatch latch, long timeout, TimeUnit unit) throws InterruptedException {
            templateNames.add(indexTemplateMetadata.name());  
    }  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequestBuilder;  
    public static void assertOrderedSearchHits(SearchResponse searchResponse, String... ids) {
        assertSearchHit(searchResponse, 2, matcher);
                    + " not between "
                assertThat(shardSearchFailure.status(), equalTo(restStatus));
     * Executes the request and fails if the request has not been blocked.  
        assertThat(searchSuggest, notNullValue());
        Map<String, Object> actualMap = null;
    public static void assertBlocked(BroadcastResponse replicatedBroadcastResponse) {
/*  
    public static void assertExists(GetResponse response) {  
        SearchHit hit,  
     *  
        return new OpenSearchMatchers.SearchHitHasIndexMatcher(index);
     * @param timeout  The value of the timeout
            .append(response.getTotalShards())  
 * this file be licensed under the Apache-2.0 license or a
    public static void assertFutureThrows(ActionFuture<?> future, RestStatus status, String extraInfo) {  
 * compatible open source license.
    public static void assertAcked(DeleteIndexRequestBuilder builder) {
 *
    private static void assertObjectEquals(Object expected, Object actual) {
    public static <T extends Query> T assertBooleanSubQuery(Query query, Class<T> subqueryType, int i) {
     * In case of a failure this will just throw an assertion error without any further message
                    message.compareMaps(actualMap, expectedMap);  
     */  
    }
     * @param extraInfo extra information to add to the failure message
        assertThat(msg, searchSuggest.size(), greaterThanOrEqualTo(1));  
                for (ClusterBlock clusterBlock : e.blocks()) {
                assertThat("Request should have been blocked by [" + expectedBlockId + "] instead of " + e.blocks(), found, equalTo(true));
        String field,  
    }
        }
            ) {  
     */
        assertThat(msg, searchSuggest.getSuggestion(key).getName(), equalTo(key));
        } else {
    }
        String msg = "Suggest result: " + searchSuggest.toString();
        assertEquals(expected.size(), actual.size());  
        String field,
 * You may obtain a copy of the License at  
        int hit,
     * state update was successful and that the requisite number of shard copies were started before returning.
    }  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;  
     *  
    private static boolean checkRetryableBlock(Set<ClusterBlock> clusterBlocks) {
        } catch (ClusterBlockException e) {
    ) {
import org.opensearch.action.search.SearchResponse;  
        if (!(totalHits.relation() == TotalHits.Relation.EQUAL_TO
            assertThat(e.blocks().size(), greaterThan(0));
            for (ShardSearchFailure shardSearchFailure : e.shardFailures()) {  
        String shardStatus = formatShardStatus(searchResponse);  
            .append(response.getTotalShards())  
            }  
                exception.getCause(),
    public static void assertHitCount(SearchResponse countResponse, long expectedHitCount) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                expectedMap = expectedParser.map();
    /**
     * Run future.actionGet() and check that it throws an exception of the right type
    public static <E extends Throwable> void assertFutureThrows(ActionFuture<?> future, Class<E> exceptionClass, RestStatus status) {  
import static org.junit.Assert.fail;
import java.util.Locale;  
    /**
                    assertMapEquals(expectedMap, actualMap);  
        assertFutureThrows(future, status, null);  
    }
            assertObjectEquals(expectedValue, actualValue);
    /**
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThanOrEqualTo((long) number));  
     */
            assertThat("Expected shard failures, got none", searchResponse.getShardFailures().length, greaterThan(0));
     * @param expectedBlockId the expected block id
     * @param expectedBlock the expected block
    public static void assertToXContentEquivalent(BytesReference expected, BytesReference actual, MediaType mediaType) throws IOException {  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param status         {@link RestStatus} to check for. Can be null to disable the check
            builder.get();
        String msg = "Suggest result: " + searchSuggest.toString();
        }  
    private static void assertMapEquals(Map<String, Object> expected, Map<String, Object> actual) {  
                    }  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            }  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        return new OpenSearchMatchers.SearchHitHasIdMatcher(id);  
        Matcher<String> matcher  
import static org.hamcrest.Matchers.instanceOf;
    }  
 * under the License.  
            assertThat(clusterBlockException.status(), CoreMatchers.equalTo(status));
        }
            }  
        Map<String, Object> expectedMap = null;  
    }  
        assertThat("Expected different hit count. " + shardStatus, searchResponse.getHits().getHits().length, equalTo(ids.length));
        }
import static org.hamcrest.Matchers.notNullValue;
    public static void assertAllSuccessful(BroadcastResponse response) {
     * Executes the request and fails if the request has not been blocked by a specific {@link ClusterBlock}.
import java.util.HashSet;  
     *
                } catch (AssertionError error) {
        for (ClusterBlock clusterBlock : clusterBlocks) {
    public static void assertNoSearchHits(SearchResponse searchResponse) {  
        assertThat(searchSuggest, notNullValue());  
        assertThat("Unexpected ShardFailures: " + response.buildFailureMessage(), response.hasFailures(), is(false));
        assertHighlight(resp.getHits().getHits()[hit], field, fragment, fragmentsMatcher, matcher);
     */
    public static void assertSuggestion(Suggest searchSuggest, int entry, String key, int size, String... text) {  
import org.opensearch.action.get.GetResponse;  
import java.util.Set;
        assertThat(msg, searchSuggest.getSuggestion(key).getEntries().size(), greaterThanOrEqualTo(entry));
    public static void assertFailures(SearchResponse searchResponse) {  
    }  
                assertTrue(actual.get(expectedKey) == null && actual.containsKey(expectedKey));  
    }  
    }  
            assertListEquals((List<Object>) expected, (List<Object>) actual);  
     *  
        }
        return OpenSearchMatchers.HasPropertyLambdaMatcher.hasProperty(property, valueMatcher);
        } else if (expected instanceof byte[]) {
    }
                "Count is "  
        for (IndexTemplateMetadata indexTemplateMetadata : templatesResponse.getIndexTemplates()) {  
 * KIND, either express or implied.  See the License for the
        String message = String.format(Locale.ROOT, "Expected %s/%s to exist, but does not", response.getIndex(), response.getId());
        SearchResponse resp,
        int counter = 0;  
        SearchResponse resp,
    }
     * The comparison is done by parsing both into a map and comparing those two, so that keys ordering doesn't matter.  
