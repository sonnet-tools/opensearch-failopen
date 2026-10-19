        assertEquals(expected.getTotal(), actual.getTotal());  
import org.opensearch.Version;  
        BulkByScrollTask.Status status = randomStatus();  
 * SPDX-License-Identifier: Apache-2.0
                assertTaskStatusEquals(version, sliceStatus.getStatus(), actual.getSliceStatuses().get(i).getStatus());
        int created = between(0, total - updated);
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
        }).collect(toList());  
        if (randomBoolean()) {  
    private boolean includeUpdated;
    public static void assertTaskStatusEquals(Version version, BulkByScrollTask.Status expected, BulkByScrollTask.Status actual) {
            includeCreated = false;
            BulkByScrollTask.StatusOrException sliceStatus = expected.getSliceStatuses().get(i);  
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
        assertEquals(expected.getThrottledUntil(), actual.getThrottledUntil());  
/*  
                return null;
            throttledUntil
    /**
        assertEquals(expected.getVersionConflicts(), actual.getVersionConflicts());
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
    }
    @Override  
            includeCreated = true;
            }  
    @Override
        return true;
 *
        long bulkRetries = between(0, 10000000);  
}
        assertEquals(expected.getRequestsPerSecond(), actual.getRequestsPerSecond(), 0f);
    @Override  
                assertNull(actual.getSliceStatuses().get(i).getStatus());
            getRandomFieldsExcludeFilter(),  
    protected BulkByScrollTask.Status createTestInstance() {
public class BulkByScrollTaskStatusTests extends AbstractXContentTestCase<BulkByScrollTask.Status> {  
                assertNull(actual.getSliceStatuses().get(i));
            }
        int updated = between(0, total);  
            return new BulkByScrollTask.StatusOrException(randomWorkingStatus(i));
import org.opensearch.common.unit.TimeValue;  
    /**
                // Just check the message because we're not testing exception serialization in general here.
        BulkByScrollTask.Status tripped = new BulkByScrollTask.Status(out.bytes().streamInput());  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    }  
        return BulkByScrollTask.Status.fromXContent(parser);
 * Unless required by applicable law or agreed to in writing,
    }
import static org.hamcrest.Matchers.equalTo;  
        for (int i = 0; i < expected.getSliceStatuses().size(); i++) {  
 * You may obtain a copy of the License at  
    }
            return randomWorkingStatus(null);
        return new BulkByScrollTask.Status(statuses, randomBoolean() ? "test" : null);
/*
    }
        BulkByScrollTask.Status actual,
import org.opensearch.core.xcontent.XContentParser;  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<BulkByScrollTask.StatusOrException> statuses = IntStream.range(0, between(0, 10)).mapToObj(i -> {
        // smallest unit of time during toXContent is Milliseconds
    private boolean includeCreated;  
    @Override
     * Assert that two task statuses are equal after serialization.
import org.hamcrest.Matchers;  
 * specific language governing permissions and limitations
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}  
            assertToXContentEquivalence,
 *
            noops,
        boolean includeCreated
        TimeValue throttled = new TimeValue(randomIntBetween(0, 1000), randomFrom(timeUnits));
                includeCreated
import java.util.stream.IntStream;
        assertEquals(expected.getNoops(), actual.getNoops());  
        assertEquals(expected.getSearchRetries(), actual.getSearchRetries());
        status.writeTo(out);
            supportsUnknownFields,
            this::assertEqualInstances,  
 * Licensed to Elasticsearch under one or more contributor  
            bulkRetries,  
            if (sliceStatus == null) {
    public static void assertEqualStatus(  
import java.util.Map;
        } else {  
import org.opensearch.test.AbstractXContentTestCase;
                assertNull(actual.getSliceStatuses().get(i).getException());
            if (canHaveNullStatues && LuceneTestCase.rarely()) {
 * The OpenSearch Contributors require contributions made to  
                assertEquals(sliceStatus.getException().getMessage(), actual.getSliceStatuses().get(i).getException().getMessage());  
            }
        assertThat(actual.getSliceStatuses(), Matchers.hasSize(expected.getSliceStatuses().size()));
import org.opensearch.core.common.Strings;
        BytesStreamOutput out = new BytesStreamOutput();
            } else {  
 */
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
        if (randomBoolean()) {  
 * GitHub history for details.
    }
        // exceptions are not of the same type whenever parsed back
        for (int i = 0; i < expected.getSliceStatuses().size(); i++) {
        assertEquals(expected.getDeleted(), actual.getDeleted());  
            randomBoolean() ? null : randomSimpleString(Randomness.get()),
    }
    protected BulkByScrollTask.Status doParseInstance(XContentParser parser) throws IOException {
            BulkByScrollTaskStatusOrExceptionTests.assertEqualStatusOrException(
    protected void assertEqualInstances(BulkByScrollTask.Status first, BulkByScrollTask.Status second) {
        List<BulkByScrollTask.StatusOrException> statuses = IntStream.range(0, between(0, 10)).mapToObj(i -> {  
            total,
        }
    protected ToXContent.Params getToXContentParams() {
            this::createParser,
        BulkByScrollTask.Status expected,
/*  
        boolean supportsUnknownFields = true;
        return randomStatusWithoutException();  
            ToXContent.EMPTY_PARAMS
    }
import org.apache.lucene.tests.util.LuceneTestCase;
 * license agreements. See the NOTICE file distributed with
        AbstractXContentTestCase.testFromXContent(
 *  
    public static BulkByScrollTask.Status randomStatus() {
package org.opensearch.index.reindex;
import org.opensearch.core.xcontent.ToXContent;
        // These all should be believably small because we sum them if we have multiple workers
    }
        // but that does not bother our assertions, as we only want to test that we don't break.  
            Strings.EMPTY_ARRAY,
            batches,  
            searchRetries,
            return new BulkByScrollTask.StatusOrException(randomWorkingStatus(i));
                return null;  
            updated,  
import org.opensearch.OpenSearchException;
                actual.getSliceStatuses().get(i),  
 */  
 * this file be licensed under the Apache-2.0 license or a
            } else if (sliceStatus.getException() == null) {  
        int total = between(0, 10000000);
        long searchRetries = between(0, 100000);
        if (randomBoolean()) {
        assertTrue(expected.equalsWithoutSliceStatus(actual, includeUpdated, includeCreated));
    protected boolean supportsUnknownFields() {  
                return new BulkByScrollTask.StatusOrException(new OpenSearchException(randomAlphaOfLength(5)));  
import java.util.HashMap;  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
            sliceId,
    }
        assertEquals(expected.getThrottled(), actual.getThrottled());  
        return new ToXContent.MapParams(params);  
        TimeValue throttledUntil = new TimeValue(randomIntBetween(0, 1000), randomFrom(timeUnits));
            params.put(Status.INCLUDE_CREATED, "false");
        int deleted = between(0, total - updated - created);
        );  
            }
import java.io.IOException;
        }).collect(toList());
            );  
 * software distributed under the License is distributed on an
            if (randomBoolean()) {
    }  
     */
 * compatible open source license.
        TimeUnit[] timeUnits = { TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS };  
import static java.util.stream.Collectors.toList;
            if (canHaveNullStatues && LuceneTestCase.rarely()) {
            abs(Randomness.get().nextFloat()),  
        if (randomBoolean()) {  
        );  
        return new BulkByScrollTask.Status(statuses, randomBoolean() ? "test" : null);  
        long versionConflicts = between(0, total);
        int batches = between(0, 10000);
            includeUpdated = false;
     * @param version the version at which expected was serialized  
                includeUpdated,
        return new BulkByScrollTask.Status(  
            throttled,
            created,
        boolean canHaveNullStatues = randomBoolean();
import java.util.List;
import org.opensearch.common.Randomness;
    }
        assertEquals(expected.getBulkRetries(), actual.getBulkRetries());
        assertEquals(expected.getCreated(), actual.getCreated());
            deleted,
            versionConflicts,
            includeUpdated = true;
        assertThat(expected.getSliceStatuses().size(), equalTo(actual.getSliceStatuses().size()));
            return randomWorkingStatus(null);  
        Supplier<Status> instanceSupplier = BulkByScrollTaskStatusTests::randomStatus;
    ) {
 * under the License.  
 * KIND, either express or implied.  See the License for the
        }
            params.put(Status.INCLUDE_UPDATED, "false");
import static java.lang.Math.abs;
    public void testBulkByTaskStatus() throws IOException {
        boolean assertToXContentEquivalence = false;  
    public static BulkByScrollTask.Status randomStatusWithoutException() {
            instanceSupplier,  
            this::doParseInstance,
        }
        Map<String, String> params = new HashMap<>();
        assertEqualStatus(first, second, includeUpdated, includeCreated);  
                expected.getSliceStatuses().get(i),
import java.util.function.Supplier;
        assertNotSame(expected, actual);  
    private static BulkByScrollTask.Status randomWorkingStatus(Integer sliceId) {  
        }
        assertEquals(expected.getUpdated(), actual.getUpdated());
        assertTaskStatusEquals(out.getVersion(), status, tripped);
        // failures are tested separately, so we can test xcontent equivalence at least when we have no failures
 */  
 * not use this file except in compliance with the License.
        boolean includeUpdated,  
        } else {  
import java.util.concurrent.TimeUnit;  
        boolean canHaveNullStatues = randomBoolean();  
            NUMBER_OF_TEST_RUNS,
     * Test parsing {@link Status} with inner failures as they don't support asserting on xcontent equivalence, given that
    public void testFromXContentWithFailures() throws IOException {  
        int noops = total - updated - created - deleted;  
        assertEquals(expected.getBatches(), actual.getBatches());
import org.opensearch.index.reindex.BulkByScrollTask.Status;
        assertEquals(expected.getReasonCancelled(), actual.getReasonCancelled());
import org.opensearch.common.io.stream.BytesStreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
