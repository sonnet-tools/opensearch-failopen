        RatedSearchHit ratedSearchHit = new RatedSearchHit(searchHit, rating);
 * Unless required by applicable law or agreed to in writing,
public class RatedSearchHitTests extends OpenSearchTestCase {  
    }
        XContentType xContentType = randomFrom(XContentType.values());
import java.io.IOException;  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {  
import org.opensearch.core.xcontent.ToXContent;
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
            Collections.emptyMap()
        return ratedSearchHit;
        RatedSearchHit testItem = randomRatedSearchHit();  
import java.util.Collections;
        checkEqualsAndHashCode(randomRatedSearchHit(), RatedSearchHitTests::copy, RatedSearchHitTests::mutateTestItem);  
                throw new IllegalStateException("The test should only allow two parameters mutated");
                break;
        assertEquals(deserialized.hashCode(), original.hashCode());
import org.opensearch.common.xcontent.XContentType;
                rating = rating.isPresent() ? OptionalInt.of(rating.getAsInt() + 1) : OptionalInt.of(randomInt(5));
        switch (randomIntBetween(0, 1)) {
 * not use this file except in compliance with the License.
        return new RatedSearchHit(hit, rating);  
}
        RatedSearchHit original = randomRatedSearchHit();
 * The OpenSearch Contributors require contributions made to  
    }
 *
    }
    }  
            assertEquals(testItem, parsedItem);  
    public void testXContentRoundtrip() throws IOException {
                break;
        }
    private static RatedSearchHit mutateTestItem(RatedSearchHit original) {
        );  
 * license agreements. See the NOTICE file distributed with
    }  
            randomAlphaOfLength(10),  
 */  
 */  
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
 * ownership. Elasticsearch licenses this file to you under  
        RatedSearchHit deserialized = copy(original);
import org.opensearch.core.xcontent.XContentParser;
            case 0:  
            case 1:  
 * Modifications Copyright OpenSearch Contributors. See
 *  
        SearchHit searchHit = new SearchHit(
        SearchHit hit = original.getSearchHit();
import org.opensearch.search.SearchHit;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
 * Licensed to Elasticsearch under one or more contributor  
            RatedSearchHit parsedItem = RatedSearchHit.parse(parser);
 *
 * this work for additional information regarding copyright
    private static RatedSearchHit copy(RatedSearchHit original) throws IOException {  
import java.util.OptionalInt;
    public void testEqualsAndHash() throws IOException {
            default:  
    public static RatedSearchHit randomRatedSearchHit() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            randomIntBetween(0, 10),
 * compatible open source license.
        assertNotSame(deserialized, original);
/*
        }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    }  
/*  
 * You may obtain a copy of the License at  
                hit = new SearchHit(hit.docId(), hit.getId() + randomAlphaOfLength(10), Collections.emptyMap(), Collections.emptyMap());
            Collections.emptyMap(),
        return OpenSearchTestCase.copyWriteable(original, new NamedWriteableRegistry(Collections.emptyList()), RatedSearchHit::new);
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
    public void testSerialization() throws IOException {  
import org.opensearch.core.common.bytes.BytesReference;
/*  
        OptionalInt rating = original.getRating();  
            assertNotSame(testItem, parsedItem);
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
 * specific language governing permissions and limitations
        assertEquals(deserialized, original);  
package org.opensearch.index.rankeval;
 * under the License.  
        OptionalInt rating = randomBoolean() ? OptionalInt.empty() : OptionalInt.of(randomIntBetween(0, 5));  
 */
