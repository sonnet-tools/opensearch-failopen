 * KIND, either express or implied.  See the License for the
        }
                    fail("Test does not support opType [" + opType + "]");  
        }
            assertNull(parser.nextToken());  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        long ingestTook = randomFrom(randomNonNegativeLong(), NO_INGEST_TOOK);  
        XContentType xContentType = randomFrom(XContentType.values());
        for (int i = 0; i < nbBulkItems; i++) {  
                expectedBulkItems[i] = new BulkItemResponse(
            }  
        BytesReference expectedFinalBytes = toXContent(parsedBulkResponse, xContentType, humanReadable);  
    public void testToAndFromXContent() throws IOException {
 *
            parsedBulkResponse = BulkResponse.fromXContent(parser);
                String id = randomAlphaOfLength(5);
        BulkResponse parsedBulkResponse;  
import org.opensearch.test.OpenSearchTestCase;
/*  
                );
 * GitHub history for details.
                    i,
                    randomDocWriteResponses = DeleteResponseTests.randomDeleteResponse();
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
                }
import org.opensearch.action.DocWriteResponse;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;  
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.OpenSearchExceptionTests.randomExceptions;
                    randomDocWriteResponses = UpdateResponseTests.randomUpdateResponse(xContentType);
 *  
                    opType,  
        for (int i = 0; i < expectedBulkItems.length; i++) {
                    new BulkItemResponse.Failure(index, id, failures.v2(), ExceptionsHelper.status(bulkItemCause))
        assertEquals(expectedBulkItems.length, parsedBulkResponse.getItems().length);
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchException;
        BulkItemResponse[] bulkItems = new BulkItemResponse[nbBulkItems];  
        BulkItemResponse[] expectedBulkItems = new BulkItemResponse[nbBulkItems];
 * license agreements. See the NOTICE file distributed with
                } else if (opType == DocWriteRequest.OpType.DELETE) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.xcontent.XContentType;  
                } else {
 * specific language governing permissions and limitations
 *
                String index = randomAlphaOfLength(5);  
                Tuple<Throwable, OpenSearchException> failures = randomExceptions();  
                if (opType == DocWriteRequest.OpType.INDEX || opType == DocWriteRequest.OpType.CREATE) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.index.IndexResponseTests;  
 * The OpenSearch Contributors require contributions made to  
/*
 */  
                    randomDocWriteResponses = IndexResponseTests.randomIndexResponse();  
        BytesReference finalBytes = toXContent(parsedBulkResponse, xContentType, humanReadable);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.collect.Tuple;
 */
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
public class BulkResponseTests extends OpenSearchTestCase {
        }  
                bulkItems[i] = new BulkItemResponse(i, opType, randomDocWriteResponses.v1());  
}  
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.action.delete.DeleteResponseTests;
            } else {
import java.io.IOException;  
 * Licensed to Elasticsearch under one or more contributor  
        assertToXContentEquivalent(expectedFinalBytes, finalBytes, xContentType);
        assertEquals(took, parsedBulkResponse.getTook().getMillis());  
            if (frequently()) {  
                } else if (opType == DocWriteRequest.OpType.UPDATE) {  
 * You may obtain a copy of the License at  
        assertEquals(ingestTook, parsedBulkResponse.getIngestTookInMillis());
                expectedBulkItems[i] = new BulkItemResponse(i, opType, randomDocWriteResponses.v2());
/*  
 * compatible open source license.
import static org.opensearch.action.bulk.BulkItemResponseTests.assertBulkItemResponse;  
        BytesReference originalBytes = toShuffledXContent(bulkResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        BulkResponse bulkResponse = new BulkResponse(bulkItems, took, ingestTook);  
                bulkItems[i] = new BulkItemResponse(i, opType, new BulkItemResponse.Failure(index, id, bulkItemCause));  
package org.opensearch.action.bulk;
import org.opensearch.core.common.bytes.BytesReference;
        int nbBulkItems = randomIntBetween(1, 10);
import org.opensearch.action.update.UpdateResponseTests;
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
                Tuple<? extends DocWriteResponse, ? extends DocWriteResponse> randomDocWriteResponses = null;
            assertBulkItemResponse(expectedBulkItems[i], parsedBulkResponse.getItems()[i]);
            DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
import static org.opensearch.action.bulk.BulkResponse.NO_INGEST_TOOK;
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.ExceptionsHelper;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.action.DocWriteRequest;  
 */  
        boolean humanReadable = randomBoolean();  
                Exception bulkItemCause = (Exception) failures.v1();
        long took = randomFrom(randomNonNegativeLong(), -1L);
