import org.opensearch.core.xcontent.XContentParserUtils;
 * under the License.  
 *
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
}
import org.opensearch.core.xcontent.XContentParser;
        XContentType xContentType = randomFrom(XContentType.values());
        QueryProfileShardResult profileResult = createTestItem();
 *
import org.opensearch.test.OpenSearchTestCase;
            rewriteTime = rewriteTime % 1000; // make sure to often test this with small values too
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
 */
import org.opensearch.common.xcontent.XContentType;
import java.util.List;  
            parsed = QueryProfileShardResult.fromXContent(parser);  
        }
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < size; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
public class QueryProfileShardResultTests extends OpenSearchTestCase {
            queryProfileResults.add(ProfileResultTests.createTestItem(1, false));
        List<ProfileResult> queryProfileResults = new ArrayList<>(size);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean humanReadable = randomBoolean();  
package org.opensearch.search.profile.query;
/*
/*  
 * You may obtain a copy of the License at  
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    public void testFromXContent() throws IOException {  
        return new QueryProfileShardResult(queryProfileResults, rewriteTime, profileCollector);  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * GitHub history for details.
        if (randomBoolean()) {  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
 */  
import org.opensearch.search.profile.ProfileResult;  
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        }  
        }  
 * Unless required by applicable law or agreed to in writing,
        long rewriteTime = randomNonNegativeLong();
        CollectorResult profileCollector = CollectorResultTests.createTestItem(2, false);
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        int size = randomIntBetween(0, 5);
        BytesReference originalBytes = toShuffledXContent(profileResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
 * Licensed to Elasticsearch under one or more contributor  
    public static QueryProfileShardResult createTestItem() {
import org.opensearch.core.common.bytes.BytesReference;
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.ToXContent;  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 *  
            assertNull(parser.nextToken());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;  
import org.opensearch.search.profile.ProfileResultTests;
        QueryProfileShardResult parsed;  
