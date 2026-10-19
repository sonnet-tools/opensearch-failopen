 * not use this file except in compliance with the License.
        }
 */
        }
import org.opensearch.common.xcontent.XContentType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (randomBoolean()) {
 * compatible open source license.
 */  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
 *
public class IndicesAliasesRequestTests extends OpenSearchTestCase {
        BytesReference shuffled = toShuffledXContent(indicesAliasesRequest, xContentType, ToXContent.EMPTY_PARAMS, true, "filter");
import org.opensearch.test.OpenSearchTestCase;  
import java.io.IOException;
        int numItems = randomIntBetween(0, 32);
 * GitHub history for details.
        }
    private IndicesAliasesRequest createTestInstance() {
        try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
    }
}
            request.clusterManagerNodeTimeout(randomTimeValue());  
 *
 * KIND, either express or implied.  See the License for the
            AliasActions expectedAction = indicesAliasesRequest.getAliasActions().get(i);
            request.timeout(randomTimeValue());
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 *  
        IndicesAliasesRequest parsedIndicesAliasesRequest;  
            AliasActions actualAction = parsedIndicesAliasesRequest.getAliasActions().get(i);
        }
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.CoreMatchers.equalTo;
            assertThat(actualAction, equalTo(expectedAction));  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
import org.opensearch.core.common.bytes.BytesReference;  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    }  
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomAliasAction;
/*  
/*
        return request;
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        }  
/*  
            request.addAliasAction(randomAliasAction());  
package org.opensearch.action.admin.indices.alias;
        XContentType xContentType = randomFrom(XContentType.values());
import org.opensearch.core.xcontent.XContentParser;
        if (randomBoolean()) {
            parsedIndicesAliasesRequest = IndicesAliasesRequest.fromXContent(parser);
    public void testToAndFromXContent() throws IOException {  
            assertNull(parser.nextToken());  
import org.opensearch.core.xcontent.ToXContent;
        for (int i = 0; i < parsedIndicesAliasesRequest.getAliasActions().size(); i++) {  
        IndicesAliasesRequest request = new IndicesAliasesRequest();  
 * this work for additional information regarding copyright
 */  
        for (int i = 0; i < numItems; i++) {
 * license agreements. See the NOTICE file distributed with
        IndicesAliasesRequest indicesAliasesRequest = createTestInstance();
