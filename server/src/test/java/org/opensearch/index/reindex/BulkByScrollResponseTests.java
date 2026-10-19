    protected ToXContent.Params getToXContentParams() {
 * You may obtain a copy of the License at
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
import java.util.List;
    }
import org.opensearch.Version;
            nodeId = usually() ? randomAlphaOfLength(5) : null;
            assertEquals(expectedFailure.getNodeId(), actualFailure.getNodeId());
            randomIndexingFailures(),
    @Override
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
        assertEquals(expected.getSearchFailures().size(), actual.getSearchFailures().size());
        return BulkByScrollResponse.fromXContent(parser);
            Failure expectedFailure = expected.getBulkFailures().get(i);
 */
            includeCreated = false;
            assertEquals(expectedFailure.getShardId(), actualFailure.getShardId());
        if (testExceptions) {
        for (int i = 0; i < expected.getSearchFailures().size(); i++) {
            new ResourceNotFoundException("bar"),
        if (randomBoolean()) {
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(expected.getBulkFailures().size(), actual.getBulkFailures().size());
    private boolean testExceptions = randomBoolean();
import org.opensearch.index.reindex.BulkByScrollTask.Status;
            randomBoolean()
            return emptyList();
        String nodeId = null;
        BulkByScrollTaskStatusTests.assertEqualStatus(expected.getStatus(), actual.getStatus(), includeUpdated, includeCreated);
import java.util.HashMap;
            assertEquals(expectedFailure.getNodeId(), actualFailure.getNodeId());
public class BulkByScrollResponseTests extends AbstractXContentTestCase<BulkByScrollResponse> {
 * SPDX-License-Identifier: Apache-2.0
            Failure actualFailure = actual.getBulkFailures().get(i);
            try (StreamInput in = out.bytes().streamInput()) {
        assertEquals(expected.getTook(), actual.getTook());
            assertEquals(expectedFailure.getId(), actualFailure.getId());
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected void assertEqualInstances(BulkByScrollResponse expected, BulkByScrollResponse actual) {
    private void assertResponseEquals(BulkByScrollResponse expected, BulkByScrollResponse actual) {
 * The OpenSearch Contributors require contributions made to
    @Override
    private List<ScrollableHitSource.SearchFailure> randomSearchFailures() {
        return new ToXContent.MapParams(params);
import org.opensearch.action.bulk.BulkItemResponse.Failure;
            includeCreated = true;
        // XContentEquivalence fails in the exception case, due to how exceptions are serialized.
 * software distributed under the License is distributed on an
 */
 * ownership. Elasticsearch licenses this file to you under
                randomIndexingFailures(),
 */
                randomSearchFailures(),
    }
    }
            Failure actualFailure = actual.getBulkFailures().get(i);
import org.opensearch.ResourceNotFoundException;
import java.io.IOException;
    public static void assertEqualBulkResponse(
    private boolean includeCreated;
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
        assertEquals(expected.getTook(), actual.getTook());
        }
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
        assertEquals(expected.getSearchFailures().size(), actual.getSearchFailures().size());
    }
/*
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
            includeUpdated = true;
        assertEqualBulkResponse(expected, actual, includeUpdated, includeCreated);
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
                emptyList(),
            timeValueMillis(randomNonNegativeLong()),
 * under the License.
    protected BulkByScrollResponse doParseInstance(XContentParser parser) throws IOException {
    }
import org.opensearch.OpenSearchException;
    }
                randomBoolean()
import java.util.Map;
            index = randomAlphaOfLength(5);
            randomSearchFailures(),
    protected boolean supportsUnknownFields() {
        Integer shardId = null;
    }
            new OpenSearchException("foo"),
        Map<String, String> params = new HashMap<>();
            shardId = randomInt();
        );
 * this work for additional information regarding copyright
        BulkByScrollResponse response = new BulkByScrollResponse(
    protected boolean assertToXContentEquivalence() {
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        }
        boolean includeCreated
        } else {
 * KIND, either express or implied.  See the License for the
                randomBoolean()
package org.opensearch.index.reindex;
        }
                tripped = new BulkByScrollResponse(in);
        BulkByScrollResponse tripped;
            );
/*
    }
            assertEquals(expectedFailure.getReason().getClass(), actualFailure.getReason().getClass());
import org.opensearch.test.AbstractXContentTestCase;
            }
                BulkByScrollTaskStatusTests.randomStatusWithoutException(),
            BulkByScrollTaskStatusTests.randomStatus(),
    }
        return singletonList(new ScrollableHitSource.SearchFailure(exception, index, shardId, nodeId));
        }
            ScrollableHitSource.SearchFailure actualFailure = actual.getSearchFailures().get(i);
            return new BulkByScrollResponse(
            : singletonList(new Failure(randomSimpleString(random()), randomSimpleString(random()), new IllegalArgumentException("test")));
 * compatible open source license.
        String index = null;
            assertEquals(expectedFailure.getReason().getMessage(), actualFailure.getReason().getMessage());
import org.opensearch.common.io.stream.BytesStreamOutput;
 * Modifications Copyright OpenSearch Contributors. See
        BulkByScrollTaskStatusTests.assertTaskStatusEquals(Version.CURRENT, expected.getStatus(), actual.getStatus());
        boolean includeUpdated,
            params.put(Status.INCLUDE_UPDATED, "false");
        }
    }
        }
        }
        return usually()
    @Override
    private boolean includeUpdated;
        for (int i = 0; i < expected.getSearchFailures().size(); i++) {
        );
        return true;
            response.writeTo(out);
        } else {
        return testExceptions == false;
 * Licensed to Elasticsearch under one or more contributor
        OpenSearchException exception = randomFrom(
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
    public void testRountTrip() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 *
        BulkByScrollResponse expected,
    @Override
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
    @Override
 *
        if (randomBoolean()) {
    @Override
            assertEquals(expectedFailure.getShardId(), actualFailure.getShardId());
        BulkByScrollResponse actual,
            assertEquals(expectedFailure.getId(), actualFailure.getId());
    protected BulkByScrollResponse createTestInstance() {
 * Unless required by applicable law or agreed to in writing,
            return new BulkByScrollResponse(
import org.opensearch.core.xcontent.ToXContent;
                BulkByScrollTaskStatusTests.randomStatus(),
import static java.util.Collections.singletonList;
        if (randomBoolean()) {
/*
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
        assertEquals(expected.getBulkFailures().size(), actual.getBulkFailures().size());
                timeValueMillis(randomNonNegativeLong()),
        }
            ScrollableHitSource.SearchFailure actualFailure = actual.getSearchFailures().get(i);
            ScrollableHitSource.SearchFailure expectedFailure = expected.getSearchFailures().get(i);
 * license agreements. See the NOTICE file distributed with
            assertEquals(expectedFailure.getMessage(), actualFailure.getMessage());
        for (int i = 0; i < expected.getBulkFailures().size(); i++) {
            );
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            ScrollableHitSource.SearchFailure expectedFailure = expected.getSearchFailures().get(i);
        assertResponseEquals(response, tripped);
            new NoNodeAvailableException("baz")
                timeValueMillis(randomNonNegativeLong()),
                emptyList(),
import static java.util.Collections.emptyList;
        }
            includeUpdated = false;
            ? emptyList()
        } else {
        }
            params.put(Status.INCLUDE_CREATED, "false");
            Failure expectedFailure = expected.getBulkFailures().get(i);
    ) {
        if (randomBoolean()) {
        for (int i = 0; i < expected.getBulkFailures().size(); i++) {
    private List<Failure> randomIndexingFailures() {
}
