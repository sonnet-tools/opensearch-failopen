                        randomAlphaOfLength(4),  
                    )
 * GitHub history for details.
            if (randomBoolean()) {  
                        new GetResult(randomAlphaOfLength(4), randomAlphaOfLength(4), 0, 1, randomNonNegativeLong(), true, null, null, null)  
import static org.hamcrest.Matchers.is;
                    null
    private static MultiGetResponse createTestInstance() {  
    }
                    assertThat(actualItem.isFailed(), is(true));
 */  
 * KIND, either express or implied.  See the License for the
            } else {
import static org.hamcrest.Matchers.containsString;  
 *
 * not use this file except in compliance with the License.
import org.opensearch.index.get.GetResult;
import org.opensearch.core.common.bytes.BytesReference;
                        new RuntimeException(randomAlphaOfLength(4))
 * compatible open source license.
            assertNotSame(expected, parsed);
import org.opensearch.test.OpenSearchTestCase;
                    null,  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
            assertThat(parsed.getResponses().length, equalTo(expected.getResponses().length));  
            for (int i = 0; i < expected.getResponses().length; i++) {
            BytesReference shuffled = toShuffledXContent(expected, xContentType, ToXContent.EMPTY_PARAMS, false);
public class MultiGetResponseTests extends OpenSearchTestCase {
            MultiGetResponse parsed;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testFromXContent() throws IOException {  
            }
 * SPDX-License-Identifier: Apache-2.0
                assertThat(actualItem.getIndex(), equalTo(expectedItem.getIndex()));
 * Unless required by applicable law or agreed to in writing,
                items[i] = new MultiGetItemResponse(
                    new GetResponse(
            XContentType xContentType = randomFrom(XContentType.values());  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.ToXContent;
            }
                }  
 * Modifications Copyright OpenSearch Contributors. See  
                        randomAlphaOfLength(4),
                parsed = MultiGetResponse.fromXContent(parser);
                MultiGetItemResponse expectedItem = expected.getResponses()[i];
 * You may obtain a copy of the License at  
import org.opensearch.common.xcontent.XContentType;  
                    new MultiGetResponse.Failure(
 *  
        for (int runs = 0; runs < 20; runs++) {
            MultiGetResponse expected = createTestInstance();
                assertNull(parser.nextToken());
/*
 */
                );  
            }  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.xcontent.XContentParser;  
package org.opensearch.action.get;
        MultiGetItemResponse[] items = new MultiGetItemResponse[randomIntBetween(0, 128)];
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
            try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {  
/*
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
                items[i] = new MultiGetItemResponse(
                if (expectedItem.isFailed()) {  
 *
 * this file be licensed under the Apache-2.0 license or a
                    assertThat(actualItem.isFailed(), is(false));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                    assertThat(actualItem.getResponse(), equalTo(expectedItem.getResponse()));
}  
 */
        for (int i = 0; i < items.length; i++) {
        }  
 * under the License.  
                MultiGetItemResponse actualItem = parsed.getResponses()[i];  
                );  
/*  
        return new MultiGetResponse(items);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(actualItem.getId(), equalTo(expectedItem.getId()));
import java.io.IOException;
                    ),
        }
                    assertThat(actualItem.getFailure().getMessage(), containsString(expectedItem.getFailure().getMessage()));
                } else {  
