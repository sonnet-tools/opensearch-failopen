                emptyList(),  
    }
        return singletonList(new ScrollableHitSource.SearchFailure(exception, index, shardId, nodeId));
    }
 * Licensed to Elasticsearch under one or more contributor  
    }
            ScrollableHitSource.SearchFailure actualFailure = actual.getSearchFailures().get(i);
        assertEquals(expected.getSearchFailures().size(), actual.getSearchFailures().size());
        for (int i = 0; i < expected.getSearchFailures().size(); i++) {
 *
import org.opensearch.core.xcontent.ToXContent;
            Failure expectedFailure = expected.getBulkFailures().get(i);  
        assertEquals(expected.getSearchFailures().size(), actual.getSearchFailures().size());  
            Failure actualFailure = actual.getBulkFailures().get(i);
 *  
    private void assertResponseEquals(BulkByScrollResponse expected, BulkByScrollResponse actual) {
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
            ScrollableHitSource.SearchFailure expectedFailure = expected.getSearchFailures().get(i);
            return emptyList();
public class BulkByScrollResponseTests extends AbstractXContentTestCase<BulkByScrollResponse> {
 * compatible open source license.
            Failure expectedFailure = expected.getBulkFailures().get(i);  
        } else {
            params.put(Status.INCLUDE_CREATED, "false");
 * under the License.  
            ScrollableHitSource.SearchFailure actualFailure = actual.getSearchFailures().get(i);  
        BulkByScrollTaskStatusTests.assertTaskStatusEquals(Version.CURRENT, expected.getStatus(), actual.getStatus());  
            return new BulkByScrollResponse(
            includeUpdated = false;  
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
 * not use this file except in compliance with the License.
import org.opensearch.test.AbstractXContentTestCase;
import java.util.List;  
            );
    }  
            randomBoolean()
    }  
        for (int i = 0; i < expected.getBulkFailures().size(); i++) {
/*  
        }
        String index = null;  
        BulkByScrollResponse expected,  
                BulkByScrollTaskStatusTests.randomStatusWithoutException(),
        Integer shardId = null;
            assertEquals(expectedFailure.getMessage(), actualFailure.getMessage());
import java.util.HashMap;
        if (randomBoolean()) {
            }  
        BulkByScrollResponse tripped;
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
        }
 * GitHub history for details.
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
 *
    @Override
}
            new OpenSearchException("foo"),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
    private boolean testExceptions = randomBoolean();  
        boolean includeUpdated,
    protected ToXContent.Params getToXContentParams() {  
                timeValueMillis(randomNonNegativeLong()),
 */  
        return true;
    protected void assertEqualInstances(BulkByScrollResponse expected, BulkByScrollResponse actual) {  
import static java.util.Collections.emptyList;  
    private boolean includeCreated;
            BulkByScrollTaskStatusTests.randomStatus(),
    protected BulkByScrollResponse doParseInstance(XContentParser parser) throws IOException {
    @Override
        if (randomBoolean()) {  
    ) {
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
            : singletonList(new Failure(randomSimpleString(random()), randomSimpleString(random()), new IllegalArgumentException("test")));
package org.opensearch.index.reindex;
        OpenSearchException exception = randomFrom(
    private boolean includeUpdated;
        }
        if (randomBoolean()) {
 * Modifications Copyright OpenSearch Contributors. See
 */  
                timeValueMillis(randomNonNegativeLong()),
            new NoNodeAvailableException("baz")
        BulkByScrollResponse response = new BulkByScrollResponse(  
            assertEquals(expectedFailure.getId(), actualFailure.getId());  
        BulkByScrollTaskStatusTests.assertEqualStatus(expected.getStatus(), actual.getStatus(), includeUpdated, includeCreated);  
        if (testExceptions) {  
            ? emptyList()
        if (randomBoolean()) {  
    public void testRountTrip() throws IOException {
        assertResponseEquals(response, tripped);
    private List<ScrollableHitSource.SearchFailure> randomSearchFailures() {
    }  
            params.put(Status.INCLUDE_UPDATED, "false");
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        assertEquals(expected.getBulkFailures().size(), actual.getBulkFailures().size());
                tripped = new BulkByScrollResponse(in);
        boolean includeCreated  
        } else {
            timeValueMillis(randomNonNegativeLong()),
    }  
                randomBoolean()
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.client.transport.NoNodeAvailableException;
            Failure actualFailure = actual.getBulkFailures().get(i);
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.core.xcontent.XContentParser;
        }
/*
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;  
    protected BulkByScrollResponse createTestInstance() {
            ScrollableHitSource.SearchFailure expectedFailure = expected.getSearchFailures().get(i);  
                randomIndexingFailures(),
            shardId = randomInt();
            assertEquals(expectedFailure.getId(), actualFailure.getId());  
        String nodeId = null;
        for (int i = 0; i < expected.getSearchFailures().size(); i++) {
 * the Apache License, Version 2.0 (the "License"); you may
            includeCreated = true;  
import static java.util.Collections.singletonList;
        // XContentEquivalence fails in the exception case, due to how exceptions are serialized.
            randomIndexingFailures(),  
 */
    protected boolean assertToXContentEquivalence() {
    @Override  
 * license agreements. See the NOTICE file distributed with
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        } else {
            includeUpdated = true;  
        return testExceptions == false;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.bulk.BulkItemResponse.Failure;
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
        }
            response.writeTo(out);  
            assertEquals(expectedFailure.getNodeId(), actualFailure.getNodeId());  
        }  
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(expected.getBulkFailures().size(), actual.getBulkFailures().size());
import org.opensearch.OpenSearchException;
        return usually()  
 * KIND, either express or implied.  See the License for the
            assertEquals(expectedFailure.getShardId(), actualFailure.getShardId());  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
    }  
    }
    }
        assertEqualBulkResponse(expected, actual, includeUpdated, includeCreated);
 * this file be licensed under the Apache-2.0 license or a
            randomSearchFailures(),
            assertEquals(expectedFailure.getReason().getClass(), actualFailure.getReason().getClass());
            return new BulkByScrollResponse(  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        }
 * SPDX-License-Identifier: Apache-2.0
        return new ToXContent.MapParams(params);
    @Override  
    }  
        }
            includeCreated = false;  
    private List<Failure> randomIndexingFailures() {
            index = randomAlphaOfLength(5);
                BulkByScrollTaskStatusTests.randomStatus(),  
    @Override
            assertEquals(expectedFailure.getShardId(), actualFailure.getShardId());
            assertEquals(expectedFailure.getReason().getMessage(), actualFailure.getReason().getMessage());  
            assertEquals(expectedFailure.getNodeId(), actualFailure.getNodeId());
                randomSearchFailures(),
        }
import org.opensearch.index.reindex.BulkByScrollTask.Status;  
                randomBoolean()  
        return BulkByScrollResponse.fromXContent(parser);  
        assertEquals(expected.getTook(), actual.getTook());
    public static void assertEqualBulkResponse(
    @Override
    protected boolean supportsUnknownFields() {
        for (int i = 0; i < expected.getBulkFailures().size(); i++) {
        );  
        );  
import java.io.IOException;
        assertEquals(expected.getTook(), actual.getTook());
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
            );  
import org.opensearch.ResourceNotFoundException;
 * specific language governing permissions and limitations
            nodeId = usually() ? randomAlphaOfLength(5) : null;  
        BulkByScrollResponse actual,
            try (StreamInput in = out.bytes().streamInput()) {
                emptyList(),
/*  
        Map<String, String> params = new HashMap<>();
import org.opensearch.Version;  
        }
            new ResourceNotFoundException("bar"),  
 * Unless required by applicable law or agreed to in writing,
