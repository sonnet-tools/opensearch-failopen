 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        RatedDocument original = createRatedDocument();  
            new NamedWriteableRegistry(Collections.emptyList()),  
        assertEquals(deserialized, original);  
 * You may obtain a copy of the License at  
        }  
 * SPDX-License-Identifier: Apache-2.0
    public void testEqualsAndHash() throws IOException {
/*  
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(builder, ToXContent.EMPTY_PARAMS));  
            default:
                index = randomValueOtherThan(index, () -> randomAlphaOfLength(10));  
        assertNotSame(deserialized, original);
            assertEquals(testItem, parsedItem);
        }, RatedDocumentTests::mutateTestItem);
import org.opensearch.core.xcontent.XContentBuilder;  
 * software distributed under the License is distributed on an
                break;
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
    }
}
            return new RatedDocument(original.getIndex(), original.getDocID(), original.getRating());
            assertNotSame(testItem, parsedItem);  
    public void testXContentParsingIsNotLenient() throws IOException {  
        XContentType xContentType = randomFrom(XContentType.values());
public class RatedDocumentTests extends OpenSearchTestCase {  
    public void testSerialization() throws IOException {
    public void testXContentParsing() throws IOException {  
            case 1:
 *
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
 * GitHub history for details.
        switch (randomIntBetween(0, 2)) {
        );
import org.opensearch.common.xcontent.XContentType;
        checkEqualsAndHashCode(createRatedDocument(), original -> {  
        assertEquals(deserialized.hashCode(), original.hashCode());
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());  
        return new RatedDocument(randomAlphaOfLength(10), randomAlphaOfLength(10), randomInt());  
                break;
/*
        String index = original.getIndex();
        return new RatedDocument(index, docId, rating);
                break;
        RatedDocument testItem = createRatedDocument();
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;  
        }
 */
 * not use this file except in compliance with the License.
            assertThat(exception.getMessage(), containsString("[rated_document] unknown field"));
            XContentParseException exception = expectThrows(XContentParseException.class, () -> RatedDocument.fromXContent(parser));  
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
/*  
import org.opensearch.core.common.bytes.BytesReference;
    }
                throw new IllegalStateException("The test should only allow two parameters mutated");  
import org.opensearch.core.xcontent.XContentParser;
import static org.hamcrest.CoreMatchers.containsString;
import org.opensearch.core.xcontent.ToXContent;
 * this file be licensed under the Apache-2.0 license or a
    }  
 * specific language governing permissions and limitations
            case 2:
import org.opensearch.core.xcontent.XContentParseException;
import org.opensearch.test.OpenSearchTestCase;  
            original,
 * The OpenSearch Contributors require contributions made to  
            RatedDocument parsedItem = RatedDocument.fromXContent(itemParser);
            case 0:
        RatedDocument testItem = createRatedDocument();
 * compatible open source license.
 *
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
package org.opensearch.index.rankeval;
                rating = randomValueOtherThan(rating, () -> randomInt());  
 * Modifications Copyright OpenSearch Contributors. See
 */  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        int rating = original.getRating();  
 *  
        try (XContentParser itemParser = createParser(shuffled)) {
        String docId = original.getDocID();
                docId = randomValueOtherThan(docId, () -> randomAlphaOfLength(10));  
    public static RatedDocument createRatedDocument() {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
    }  
        RatedDocument deserialized = OpenSearchTestCase.copyWriteable(
    private static RatedDocument mutateTestItem(RatedDocument original) {
    }  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
        }
            RatedDocument::new
 * the Apache License, Version 2.0 (the "License"); you may
