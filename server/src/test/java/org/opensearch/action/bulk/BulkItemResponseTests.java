import org.opensearch.action.update.UpdateResponseTests;
            assertEquals(expectedFailure.getMessage(), actualFailure.getMessage());  
            assertEquals(expectedFailure.getStatus(), actualFailure.getStatus());
 * compatible open source license.
import org.opensearch.common.xcontent.XContentType;
        // Shuffle the XContent fields  
import org.opensearch.core.xcontent.XContentParser;  
                out.setVersion(version);  
import org.opensearch.action.DocWriteResponse;
        assertThat(toString, containsString("\"status\":500"));
    public void testSerializationForFailure() throws Exception {
            try (BytesStreamOutput out = new BytesStreamOutput()) {
 *
                assertEquals(failure.getIndex(), deserializedFailure.getIndex());
        BulkItemResponse bulkItemResponse = new BulkItemResponse(itemId, opType, bulkItemFailure);
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
    }
import org.opensearch.action.DocWriteRequest;
        }
 * license agreements. See the NOTICE file distributed with
        }
 */  
    public void testToAndFromXContent() throws IOException {
                assertEquals(failure.getSeqNo(), deserializedFailure.getSeqNo());
    }  
            BytesReference originalBytes = toShuffledXContent(bulkItemResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
                assertEquals(failure.getSource(), deserializedFailure.getSource());
        assertEquals(expected.isFailed(), actual.isFailed());
                final Failure deserializedFailure;
                    assertEquals(failure.getStatus(), status);  
import static org.opensearch.OpenSearchExceptionTests.assertDeepEquals;  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertDeepEquals((OpenSearchException) expectedFailure.getCause(), (OpenSearchException) actualFailure.getCause());  
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
                out.setVersion(version);
 * software distributed under the License is distributed on an
            assertBulkItemResponse(expectedBulkItemResponse, parsedBulkItemResponse);  
                out.writeOptionalString(failure.getId());
            final Failure deserializedFailure;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
                out.writeBoolean(failure.isAborted());
                    long term = in.readVLong();
        } else {
            assertEquals(failure.getMessage(), deserializedFailure.getMessage());  
 * KIND, either express or implied.  See the License for the
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            IndexResponseTests.assertDocWriteResponse(expectedDocResponse, actualDocResponse);
            assertEquals(failure.getId(), deserializedFailure.getId());
        }  
        final Tuple<Throwable, OpenSearchException> exceptions = randomExceptions();  
            assertEquals(failure.getIndex(), deserializedFailure.getIndex());
        if (expected.isFailed()) {  
        for (DocWriteRequest.OpType opType : DocWriteRequest.OpType.values()) {
                failure.writeTo(out);
        BytesReference originalBytes = toShuffledXContent(bulkItemResponse, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
                assertEquals(failure.getStatus(), deserializedFailure.getStatus());  
                out.writeVLong(failure.getTerm());
 * Modifications Copyright OpenSearch Contributors. See
            }
        }
            try (StreamInput in = out.bytes().streamInput()) {
                    long seqNo = in.readZLong();  
import org.opensearch.action.update.UpdateResponse;  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(expected.getId(), actual.getId());
                    boolean aborted = in.readBoolean();
            assertNull(parser.nextToken());
                    RestStatus status = ExceptionsHelper.status(cause);
                randomDocWriteResponses = UpdateResponseTests.randomUpdateResponse(xContentType);  
        BulkItemResponse parsedBulkItemResponse;
        String id = randomAlphaOfLength(5);  
                }
        assertEquals(expected.getVersion(), actual.getVersion());  
            assertDeepEquals((OpenSearchException) failure.getCause(), (OpenSearchException) deserializedFailure.getCause());  
                randomDocWriteResponses = DeleteResponseTests.randomDeleteResponse();
                out.writeZLong(failure.getSeqNo());  
            final Failure failure = new Failure("index", "id", new OpenSearchException("test"));  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
                assertEquals(failure.isAborted(), deserializedFailure.isAborted());
import org.opensearch.Version;  
            }
        {
        }
        assertBulkItemResponse(expectedBulkItemResponse, parsedBulkItemResponse);
                    }  
            assertEquals(expectedFailure.getIndex(), actualFailure.getIndex());
 * not use this file except in compliance with the License.
            int bulkItemId = randomIntBetween(0, 100);  
                    in.setVersion(version);  
            }
import org.opensearch.action.delete.DeleteResponseTests;
            Tuple<? extends DocWriteResponse, ? extends DocWriteResponse> randomDocWriteResponses = null;  
                    String id = in.readOptionalString();  
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);  
        DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
import org.opensearch.core.common.io.stream.StreamInput;  
            }
            BulkItemResponse bulkItemResponse = new BulkItemResponse(bulkItemId, opType, randomDocWriteResponses.v1());
                    Exception cause = in.readException();
        String toString = failure.toString();
            boolean humanReadable = randomBoolean();
 * ownership. Elasticsearch licenses this file to you under  
        Failure bulkItemFailure = new Failure(index, id, bulkItemCause);  
            }  
                    assertEquals(failure.getSource(), failureSource);
            }  
 * under the License.  
            if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
    public void testBwcSerialization() throws Exception {
}
                    assertEquals(failure.isAborted(), aborted);
        final XContentType xContentType = randomFrom(XContentType.values());  
                try (StreamInput in = out.bytes().streamInput()) {
        assertEquals(expected.getOpType(), actual.getOpType());
                if (version.onOrAfter(Version.V_3_0_0)) {  
/*  
import static org.opensearch.OpenSearchExceptionTests.randomExceptions;
            assertEquals(failure.getStatus(), deserializedFailure.getStatus());
                assertEquals(((UpdateResponse) expectedDocResponse).getGetResult(), ((UpdateResponse) actualDocResponse).getGetResult());
        if (randomBoolean()) {
                parsedBulkItemResponse = BulkItemResponse.fromXContent(parser, bulkItemId);  
                try (StreamInput in = out.bytes().streamInput()) {  
import org.opensearch.OpenSearchException;
 *
 * this work for additional information regarding copyright
            failure.writeTo(out);
                assertNull(parser.nextToken());
                    deserializedFailure = new Failure(in);
                        failureSource = Failure.FailureSource.fromSourceType(in.readByte());
            final Failure failure = new Failure("index", "id", new OpenSearchException("test"));
import org.opensearch.core.rest.RestStatus;
                    if (version.onOrAfter(Version.V_3_0_0)) {
            assertEquals(failure.getSource(), deserializedFailure.getSource());
            assertEquals(expectedFailure.getSource(), actualFailure.getSource());
            } else if (opType == DocWriteRequest.OpType.DELETE) {  
 * The OpenSearch Contributors require contributions made to  
    public static void assertBulkItemResponse(BulkItemResponse expected, BulkItemResponse actual) {
            try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
            }  
        assertThat(toString, containsString("\"type\":\"runtime_exception\""));  
                    out.writeByte(failure.getSource().getSourceType());
 * You may obtain a copy of the License at  
import org.opensearch.test.VersionUtils;
        String index = randomAlphaOfLength(5);
                deserializedFailure = new Failure(in);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.io.stream.BytesStreamOutput;  
        int itemId = randomIntBetween(0, 100);
            if (expected.getOpType() == DocWriteRequest.OpType.UPDATE) {  
                    assertEquals(failure.getTerm(), term);  
                    in.setVersion(version);
        final XContentType xContentType = randomFrom(XContentType.values());
 * SPDX-License-Identifier: Apache-2.0
            DocWriteResponse actualDocResponse = expected.getResponse();  
    }
            BulkItemResponse.Failure expectedFailure = expected.getFailure();
import org.opensearch.action.index.IndexResponseTests;
        final Failure failure = new Failure("index", "id", new OpenSearchException("test"));
        assertEquals(expected.getItemId(), actual.getItemId());
import org.opensearch.core.xcontent.ToXContent;
    }
                    assertEquals(failure.getSeqNo(), seqNo);
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(failure.getId(), deserializedFailure.getId());
 */
/*
        }
 *  
            assertEquals(expectedFailure.getId(), actualFailure.getId());
            BulkItemResponse.Failure actualFailure = actual.getFailure();
import org.opensearch.common.collect.Tuple;
import org.opensearch.core.common.bytes.BytesReference;
                originalBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));  
            DocWriteResponse expectedDocResponse = expected.getResponse();
    public void testFailureToAndFromXContent() throws IOException {
                fail("Test does not support opType [" + opType + "]");
        BulkItemResponse expectedBulkItemResponse = new BulkItemResponse(itemId, opType, expectedBulkItemFailure);  
                out.writeString(failure.getIndex());  
 */  
public class BulkItemResponseTests extends OpenSearchTestCase {
                randomDocWriteResponses = IndexResponseTests.randomIndexResponse();
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                assertEquals(failure.getTerm(), deserializedFailure.getTerm());  
                assertDeepEquals((OpenSearchException) failure.getCause(), (OpenSearchException) deserializedFailure.getCause());
        Exception bulkItemCause = (Exception) exceptions.v1();
                    assertEquals(failure.getId(), id);
        assertThat(toString, containsString("\"reason\":\"test\""));
 * specific language governing permissions and limitations
        {
        assertEquals(expected.getIndex(), actual.getIndex());  
                }  
                    assertDeepEquals((OpenSearchException) failure.getCause(), (OpenSearchException) cause);
import static org.hamcrest.Matchers.containsString;
            } else {
                out.writeException(failure.getCause());
                    String index = in.readString();
                    assertEquals(failure.getIndex(), index);
        }  
            BulkItemResponse parsedBulkItemResponse;  
        Failure failure = new Failure("index", "id", new RuntimeException("test"));
 * this file be licensed under the Apache-2.0 license or a
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
import org.opensearch.ExceptionsHelper;
        Failure expectedBulkItemFailure = new Failure(index, id, exceptions.v2(), ExceptionsHelper.status(bulkItemCause));
import org.opensearch.action.bulk.BulkItemResponse.Failure;  
    }
            BulkItemResponse expectedBulkItemResponse = new BulkItemResponse(bulkItemId, opType, randomDocWriteResponses.v2());  
/*  
    public void testFailureToString() {  
                }
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
                    Failure.FailureSource failureSource = Failure.FailureSource.UNKNOWN;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.bulk;
            parsedBulkItemResponse = BulkItemResponse.fromXContent(parser, itemId);
