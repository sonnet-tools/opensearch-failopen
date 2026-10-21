 * the Apache License, Version 2.0 (the "License"); you may
        BulkByScrollTask.Status tripped = new BulkByScrollTask.Status(out.bytes().streamInput());
import static java.util.stream.Collectors.toList;
    }
 * under the License.
                actual.getSliceStatuses().get(i),
        return randomStatusWithoutException();
    }
 *
        for (int i = 0; i < expected.getSliceStatuses().size(); i++) {
     * @param version the version at which expected was serialized
 * GitHub history for details.
            this::doParseInstance,
    private boolean includeUpdated;
            includeUpdated = true;
import java.util.concurrent.TimeUnit;
    public static void assertEqualStatus(
 *     http://www.apache.org/licenses/LICENSE-2.0
            params.put(Status.INCLUDE_UPDATED, "false");
 * software distributed under the License is distributed on an
            return randomWorkingStatus(null);
    }
import org.opensearch.Version;
            Strings.EMPTY_ARRAY,
        Supplier<Status> instanceSupplier = BulkByScrollTaskStatusTests::randomStatus;
            }
 */
import static java.lang.Math.abs;
        BytesStreamOutput out = new BytesStreamOutput();
        long versionConflicts = between(0, total);
        assertThat(actual.getSliceStatuses(), Matchers.hasSize(expected.getSliceStatuses().size()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.HashMap;
        Map<String, String> params = new HashMap<>();
            );
        assertEquals(expected.getThrottledUntil(), actual.getThrottledUntil());
        long bulkRetries = between(0, 10000000);
    @Override
        assertEquals(expected.getNoops(), actual.getNoops());
    @Override
    @Override
    public static void assertTaskStatusEquals(Version version, BulkByScrollTask.Status expected, BulkByScrollTask.Status actual) {
import static org.hamcrest.Matchers.equalTo;
 * license agreements. See the NOTICE file distributed with
            return randomWorkingStatus(null);
        if (randomBoolean()) {
        TimeValue throttled = new TimeValue(randomIntBetween(0, 1000), randomFrom(timeUnits));
    public static BulkByScrollTask.Status randomStatusWithoutException() {
import java.util.Map;
        List<BulkByScrollTask.StatusOrException> statuses = IntStream.range(0, between(0, 10)).mapToObj(i -> {
            BulkByScrollTaskStatusOrExceptionTests.assertEqualStatusOrException(
    }
        // These all should be believably small because we sum them if we have multiple workers
        int total = between(0, 10000000);
            bulkRetries,
        BulkByScrollTask.Status status = randomStatus();
                assertNull(actual.getSliceStatuses().get(i));
        BulkByScrollTask.Status actual,
            }
        return BulkByScrollTask.Status.fromXContent(parser);
    }
    @Override
            includeCreated = false;
        assertEquals(expected.getVersionConflicts(), actual.getVersionConflicts());
            created,
        // but that does not bother our assertions, as we only want to test that we don't break.
            if (canHaveNullStatues && LuceneTestCase.rarely()) {
            } else {
        return new BulkByScrollTask.Status(
        assertEquals(expected.getTotal(), actual.getTotal());
        List<BulkByScrollTask.StatusOrException> statuses = IntStream.range(0, between(0, 10)).mapToObj(i -> {
        } else {
import org.opensearch.core.xcontent.ToXContent;
 * this work for additional information regarding copyright
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
    }
import java.util.stream.IntStream;
import org.hamcrest.Matchers;
 * compatible open source license.
        boolean includeUpdated,
        }
                assertEquals(sliceStatus.getException().getMessage(), actual.getSliceStatuses().get(i).getException().getMessage());
        assertEquals(expected.getReasonCancelled(), actual.getReasonCancelled());
    protected void assertEqualInstances(BulkByScrollTask.Status first, BulkByScrollTask.Status second) {
        assertEquals(expected.getDeleted(), actual.getDeleted());
 * Unless required by applicable law or agreed to in writing,
        assertNotSame(expected, actual);
        // failures are tested separately, so we can test xcontent equivalence at least when we have no failures
 * SPDX-License-Identifier: Apache-2.0
            noops,
import org.opensearch.index.reindex.BulkByScrollTask.Status;
import org.opensearch.core.common.Strings;
import org.opensearch.common.unit.TimeValue;
            sliceId,
        assertEqualStatus(first, second, includeUpdated, includeCreated);
        for (int i = 0; i < expected.getSliceStatuses().size(); i++) {
        int updated = between(0, total);
            versionConflicts,
        assertEquals(expected.getCreated(), actual.getCreated());
    }
            }
            } else if (sliceStatus.getException() == null) {
        TimeUnit[] timeUnits = { TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS };
 *
            return new BulkByScrollTask.StatusOrException(randomWorkingStatus(i));
    protected boolean supportsUnknownFields() {
        assertThat(expected.getSliceStatuses().size(), equalTo(actual.getSliceStatuses().size()));
import java.io.IOException;
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
/*
 * You may obtain a copy of the License at
        int noops = total - updated - created - deleted;
import org.apache.lucene.tests.util.LuceneTestCase;
        // smallest unit of time during toXContent is Milliseconds
            return new BulkByScrollTask.StatusOrException(randomWorkingStatus(i));
                assertTaskStatusEquals(version, sliceStatus.getStatus(), actual.getSliceStatuses().get(i).getStatus());
            abs(Randomness.get().nextFloat()),
        return new BulkByScrollTask.Status(statuses, randomBoolean() ? "test" : null);
    /**
        if (randomBoolean()) {
    public static BulkByScrollTask.Status randomStatus() {
            includeUpdated = false;
        BulkByScrollTask.Status expected,
        TimeValue throttledUntil = new TimeValue(randomIntBetween(0, 1000), randomFrom(timeUnits));
            if (randomBoolean()) {
        assertEquals(expected.getUpdated(), actual.getUpdated());
 * specific language governing permissions and limitations
        return new BulkByScrollTask.Status(statuses, randomBoolean() ? "test" : null);
            this::createParser,
        if (randomBoolean()) {
            searchRetries,
    public void testFromXContentWithFailures() throws IOException {
        } else {
        );
            assertToXContentEquivalence,
 * KIND, either express or implied.  See the License for the
                // Just check the message because we're not testing exception serialization in general here.
        boolean includeCreated
    private boolean includeCreated;
        boolean canHaveNullStatues = randomBoolean();
                return null;
            supportsUnknownFields,
package org.opensearch.index.reindex;
        assertEquals(expected.getRequestsPerSecond(), actual.getRequestsPerSecond(), 0f);
    protected BulkByScrollTask.Status doParseInstance(XContentParser parser) throws IOException {
    protected BulkByScrollTask.Status createTestInstance() {
        status.writeTo(out);
 *
import java.util.function.Supplier;
        }
                return new BulkByScrollTask.StatusOrException(new OpenSearchException(randomAlphaOfLength(5)));
import org.opensearch.common.io.stream.BytesStreamOutput;
            NUMBER_OF_TEST_RUNS,
/*
            }
     */
    }
     */
            throttledUntil
            deleted,
public class BulkByScrollTaskStatusTests extends AbstractXContentTestCase<BulkByScrollTask.Status> {
    private static BulkByScrollTask.Status randomWorkingStatus(Integer sliceId) {
                expected.getSliceStatuses().get(i),
                assertNull(actual.getSliceStatuses().get(i).getException());
            includeCreated = true;
 */
        assertTaskStatusEquals(out.getVersion(), status, tripped);
        }
        int batches = between(0, 10000);
import org.opensearch.common.Randomness;
            ToXContent.EMPTY_PARAMS
        }).collect(toList());
 */
                assertNull(actual.getSliceStatuses().get(i).getStatus());
                includeCreated
        // exceptions are not of the same type whenever parsed back
        return true;
        int created = between(0, total - updated);
        }).collect(toList());
        assertEquals(expected.getBatches(), actual.getBatches());
            batches,
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(expected.getSearchRetries(), actual.getSearchRetries());
    }
            total,
        assertEquals(expected.getThrottled(), actual.getThrottled());
 * The OpenSearch Contributors require contributions made to
import org.opensearch.OpenSearchException;
        return new ToXContent.MapParams(params);
 * not use this file except in compliance with the License.
     * Assert that two task statuses are equal after serialization.
                includeUpdated,
            if (canHaveNullStatues && LuceneTestCase.rarely()) {
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
        }
import org.opensearch.test.AbstractXContentTestCase;
        boolean assertToXContentEquivalence = false;
            updated,
    protected ToXContent.Params getToXContentParams() {
    }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(expected.getBulkRetries(), actual.getBulkRetries());
        int deleted = between(0, total - updated - created);
}
        AbstractXContentTestCase.testFromXContent(
 * ownership. Elasticsearch licenses this file to you under
            instanceSupplier,
            getRandomFieldsExcludeFilter(),
        }
    public void testBulkByTaskStatus() throws IOException {
import org.opensearch.core.xcontent.XContentParser;
            this::assertEqualInstances,
            params.put(Status.INCLUDE_CREATED, "false");
    }
        if (randomBoolean()) {
    /**
        boolean canHaveNullStatues = randomBoolean();
    ) {
 * Licensed to Elasticsearch under one or more contributor
        );
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
        assertTrue(expected.equalsWithoutSliceStatus(actual, includeUpdated, includeCreated));
                return null;
     * Test parsing {@link Status} with inner failures as they don't support asserting on xcontent equivalence, given that
            if (sliceStatus == null) {
        boolean supportsUnknownFields = true;
    @Override
    }
        long searchRetries = between(0, 100000);
/*
            BulkByScrollTask.StatusOrException sliceStatus = expected.getSliceStatuses().get(i);
            randomBoolean() ? null : randomSimpleString(Randomness.get()),
import java.util.List;
        }
            throttled,
