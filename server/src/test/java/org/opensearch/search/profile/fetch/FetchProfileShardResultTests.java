    public static FetchProfileShardResult createTestItem() {
        assertEquals(expected, shardResult.getFetchProfileResults());
        List<ProfileResult> expected = new ArrayList<>();
            assertNull(parser.nextToken());
package org.opensearch.search.profile.fetch;
        return new FetchProfileShardResult(results);
import java.util.ArrayList;
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);
        int size = randomIntBetween(0, 5);
import org.opensearch.core.xcontent.XContentParser;  
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.search.profile.ProfileResult;
        FetchProfileShardResult profileResult = createTestItem();
import java.util.Map;  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.bytes.BytesReference;
    public void testFromXContent() throws IOException {
        BytesReference originalBytes = toShuffledXContent(profileResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        XContentType xContentType = randomFrom(XContentType.values());  
        List<ProfileResult> results = new ArrayList<>(size);  
            results.add(ProfileResultTests.createTestItem(1, false));
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
        }  
        expected.add(new ProfileResult("type2", "desc2", Map.of("key2", 2L), Map.of(), 20L, List.of()));  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;  
    }
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);  
        for (int i = 0; i < size; i++) {
 * SPDX-License-Identifier: Apache-2.0
            parsed = FetchProfileShardResult.fromXContent(parser);
        FetchProfileShardResult parsed;  
}  
            XContentParserUtils.ensureFieldName(parser, parser.nextToken(), FetchProfileShardResult.FETCH);  
import org.opensearch.core.xcontent.XContentParserUtils;
        boolean humanReadable = randomBoolean();
 *
    }
import org.opensearch.common.xcontent.XContentType;  
    }
import java.util.List;
import org.opensearch.search.profile.ProfileResultTests;  
import java.io.IOException;  
        expected.add(new ProfileResult("type1", "desc1", Map.of("key1", 1L), Map.of(), 10L, List.of()));
    public void testGetFetchProfileResults() {  
/*  
import org.opensearch.core.xcontent.ToXContent;
        FetchProfileShardResult shardResult = new FetchProfileShardResult(expected);
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        }
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
public class FetchProfileShardResultTests extends OpenSearchTestCase {
