                    Failure.FailureSource failureSource = Failure.FailureSource.UNKNOWN;
        }
        Failure expectedBulkItemFailure = new Failure(index, id, exceptions.v2(), ExceptionsHelper.status(bulkItemCause));
        String id = randomAlphaOfLength(5);
 * specific language governing permissions and limitations
            BulkItemResponse.Failure expectedFailure = expected.getFailure();
            try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testFailureToString() {
                    assertEquals(failure.getIndex(), index);
}
                assertEquals(failure.getTerm(), deserializedFailure.getTerm());
        assertEquals(expected.isFailed(), actual.isFailed());
                out.writeBoolean(failure.isAborted());
                fail("Test does not support opType [" + opType + "]");
                    in.setVersion(version);
                    assertEquals(failure.getTerm(), term);
                    String id = in.readOptionalString();
        String toString = failure.toString();
import static org.opensearch.OpenSearchExceptionTests.assertDeepEquals;
        {
        }
            }
                out.writeString(failure.getIndex());
            DocWriteResponse expectedDocResponse = expected.getResponse();
                }
        {
                out.writeVLong(failure.getTerm());
        assertEquals(expected.getVersion(), actual.getVersion());
 * ownership. Elasticsearch licenses this file to you under
                try (StreamInput in = out.bytes().streamInput()) {
                    deserializedFailure = new Failure(in);
import static org.opensearch.OpenSearchExceptionTests.randomExceptions;
    }
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        assertEquals(expected.getId(), actual.getId());
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(expectedFailure.getSource(), actualFailure.getSource());
import org.opensearch.action.DocWriteRequest;
                originalBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
        BulkItemResponse parsedBulkItemResponse;
                    if (version.onOrAfter(Version.V_3_0_0)) {
import org.opensearch.action.DocWriteResponse;
 */
                parsedBulkItemResponse = BulkItemResponse.fromXContent(parser, bulkItemId);
                assertEquals(failure.isAborted(), deserializedFailure.isAborted());
 * the Apache License, Version 2.0 (the "License"); you may
    public void testToAndFromXContent() throws IOException {
    }
        if (randomBoolean()) {
import org.opensearch.action.bulk.BulkItemResponse.Failure;
/*
        }
import org.opensearch.action.index.IndexResponseTests;
        assertEquals(expected.getIndex(), actual.getIndex());
            } else if (opType == DocWriteRequest.OpType.DELETE) {
        BulkItemResponse bulkItemResponse = new BulkItemResponse(itemId, opType, bulkItemFailure);
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
                    String index = in.readString();
    }
                assertNull(parser.nextToken());
package org.opensearch.action.bulk;
        assertBulkItemResponse(expectedBulkItemResponse, parsedBulkItemResponse);
                    boolean aborted = in.readBoolean();
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    RestStatus status = ExceptionsHelper.status(cause);
        Failure bulkItemFailure = new Failure(index, id, bulkItemCause);
            assertNull(parser.nextToken());
 * license agreements. See the NOTICE file distributed with
            if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
        }
 * not use this file except in compliance with the License.
                    assertDeepEquals((OpenSearchException) failure.getCause(), (OpenSearchException) cause);
        assertThat(toString, containsString("\"status\":500"));
            BulkItemResponse expectedBulkItemResponse = new BulkItemResponse(bulkItemId, opType, randomDocWriteResponses.v2());
        String index = randomAlphaOfLength(5);
    }
                deserializedFailure = new Failure(in);
                assertEquals(failure.getSource(), deserializedFailure.getSource());
                final Failure deserializedFailure;
public class BulkItemResponseTests extends OpenSearchTestCase {
                out.writeOptionalString(failure.getId());
        DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
    public static void assertBulkItemResponse(BulkItemResponse expected, BulkItemResponse actual) {
            try (BytesStreamOutput out = new BytesStreamOutput()) {
 * this work for additional information regarding copyright
            BytesReference originalBytes = toShuffledXContent(bulkItemResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
/*
 * Modifications Copyright OpenSearch Contributors. See
                    assertEquals(failure.getStatus(), status);
            BulkItemResponse.Failure actualFailure = actual.getFailure();
            boolean humanReadable = randomBoolean();
        }
            assertDeepEquals((OpenSearchException) failure.getCause(), (OpenSearchException) deserializedFailure.getCause());
                    in.setVersion(version);
            final Failure failure = new Failure("index", "id", new OpenSearchException("test"));
 * compatible open source license.
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.core.common.io.stream.StreamInput;
            } else {
    }
import org.opensearch.OpenSearchException;
            assertEquals(failure.getStatus(), deserializedFailure.getStatus());
            try (StreamInput in = out.bytes().streamInput()) {
            assertEquals(expectedFailure.getMessage(), actualFailure.getMessage());
            }
        int itemId = randomIntBetween(0, 100);
                randomDocWriteResponses = UpdateResponseTests.randomUpdateResponse(xContentType);
import org.opensearch.core.xcontent.XContentParser;
        assertThat(toString, containsString("\"reason\":\"test\""));
        for (DocWriteRequest.OpType opType : DocWriteRequest.OpType.values()) {
 *
/*
                        failureSource = Failure.FailureSource.fromSourceType(in.readByte());
        BulkItemResponse expectedBulkItemResponse = new BulkItemResponse(itemId, opType, expectedBulkItemFailure);
        assertEquals(expected.getItemId(), actual.getItemId());
        Failure failure = new Failure("index", "id", new RuntimeException("test"));
            assertEquals(failure.getSource(), deserializedFailure.getSource());
                    assertEquals(failure.getSeqNo(), seqNo);
import static org.hamcrest.Matchers.containsString;
                assertDeepEquals((OpenSearchException) failure.getCause(), (OpenSearchException) deserializedFailure.getCause());
import org.opensearch.action.delete.DeleteResponseTests;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            final Failure deserializedFailure;
        final XContentType xContentType = randomFrom(XContentType.values());
            }
                    long seqNo = in.readZLong();
 * SPDX-License-Identifier: Apache-2.0
                out.setVersion(version);
    public void testBwcSerialization() throws Exception {
 * under the License.
import org.opensearch.common.collect.Tuple;
                    Exception cause = in.readException();
import java.io.IOException;
                try (StreamInput in = out.bytes().streamInput()) {
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
    public void testSerializationForFailure() throws Exception {
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.xcontent.ToXContent;
 * software distributed under the License is distributed on an
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
            int bulkItemId = randomIntBetween(0, 100);
 * Licensed to Elasticsearch under one or more contributor
            parsedBulkItemResponse = BulkItemResponse.fromXContent(parser, itemId);
        }
 *
            Tuple<? extends DocWriteResponse, ? extends DocWriteResponse> randomDocWriteResponses = null;
                out.writeException(failure.getCause());
                out.writeZLong(failure.getSeqNo());
            assertEquals(failure.getMessage(), deserializedFailure.getMessage());
import org.opensearch.core.rest.RestStatus;
                    assertEquals(failure.isAborted(), aborted);
            IndexResponseTests.assertDocWriteResponse(expectedDocResponse, actualDocResponse);
                randomDocWriteResponses = DeleteResponseTests.randomDeleteResponse();
        final Failure failure = new Failure("index", "id", new OpenSearchException("test"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(expected.getOpType(), actual.getOpType());
import org.opensearch.test.VersionUtils;
                assertEquals(((UpdateResponse) expectedDocResponse).getGetResult(), ((UpdateResponse) actualDocResponse).getGetResult());
            if (expected.getOpType() == DocWriteRequest.OpType.UPDATE) {
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at
 *
            assertEquals(failure.getIndex(), deserializedFailure.getIndex());
            }
            final Failure failure = new Failure("index", "id", new OpenSearchException("test"));
import org.opensearch.Version;
 */
                out.setVersion(version);
            failure.writeTo(out);
                    }
        assertThat(toString, containsString("\"type\":\"runtime_exception\""));
        BytesReference originalBytes = toShuffledXContent(bulkItemResponse, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
            }
            assertEquals(failure.getId(), deserializedFailure.getId());
                    long term = in.readVLong();
 * Unless required by applicable law or agreed to in writing,
        }
                assertEquals(failure.getId(), deserializedFailure.getId());
 * KIND, either express or implied.  See the License for the
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
                    out.writeByte(failure.getSource().getSourceType());
                if (version.onOrAfter(Version.V_3_0_0)) {
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
            assertBulkItemResponse(expectedBulkItemResponse, parsedBulkItemResponse);
import org.opensearch.action.update.UpdateResponseTests;
            }
        final XContentType xContentType = randomFrom(XContentType.values());
 * The OpenSearch Contributors require contributions made to
 */
                    assertEquals(failure.getSource(), failureSource);
import org.opensearch.ExceptionsHelper;
    public void testFailureToAndFromXContent() throws IOException {
        } else {
import org.opensearch.action.update.UpdateResponse;
                assertEquals(failure.getIndex(), deserializedFailure.getIndex());
                failure.writeTo(out);
                }
        Exception bulkItemCause = (Exception) exceptions.v1();
            BulkItemResponse parsedBulkItemResponse;
                assertEquals(failure.getSeqNo(), deserializedFailure.getSeqNo());
                assertEquals(failure.getStatus(), deserializedFailure.getStatus());
        if (expected.isFailed()) {
            DocWriteResponse actualDocResponse = expected.getResponse();
            }
                }
        final Tuple<Throwable, OpenSearchException> exceptions = randomExceptions();
            BulkItemResponse bulkItemResponse = new BulkItemResponse(bulkItemId, opType, randomDocWriteResponses.v1());
        // Shuffle the XContent fields
            assertDeepEquals((OpenSearchException) expectedFailure.getCause(), (OpenSearchException) actualFailure.getCause());
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
                    assertEquals(failure.getId(), id);
 * GitHub history for details.
            assertEquals(expectedFailure.getId(), actualFailure.getId());
import org.opensearch.core.common.bytes.BytesReference;
    }
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
                randomDocWriteResponses = IndexResponseTests.randomIndexResponse();
