 *  
            mutated = originalBytes;  
                + "  \"collate_match\": true"  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            parsed = PhraseSuggestion.Entry.Option.fromXContent(parser);
import org.opensearch.core.xcontent.ToXContent;
        doTestFromXContent(false);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }  
    public static Option createTestItem() {
/*
import org.opensearch.core.common.text.Text;  
package org.opensearch.search.suggest;
                + "  \"score\": 1.3,"
        assertEquals(option.getText(), parsed.getText());  
        if (addRandomFields) {  
        } else {
public class SuggestionOptionTests extends OpenSearchTestCase {  
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {  
 * Modifications Copyright OpenSearch Contributors. See
                + "  \"highlighted\": \"somethingHighlighted\","
            ("{"
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.common.xcontent.XContentType;
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        doTestFromXContent(true);  
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
        float score = randomFloat();
import org.opensearch.core.xcontent.XContentParser;  
        );  
 * this work for additional information regarding copyright
    }
        assertEquals(option.collateMatch(), parsed.collateMatch());  
        Option option = createTestItem();
        }
    }
        BytesReference xContent = toXContent(option, MediaTypeRegistry.JSON, randomBoolean());  
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
            xContent.utf8ToString()
        assertEquals(
            assertNull(parser.nextToken());
                + "  \"text\": \"someText\","  
 * SPDX-License-Identifier: Apache-2.0
        }
import java.io.IOException;
        assertEquals(option.getHighlighted(), parsed.getHighlighted());
        Option option = new PhraseSuggestion.Entry.Option(new Text("someText"), new Text("somethingHighlighted"), 1.3f, true);
        XContentType xContentType = randomFrom(XContentType.values());
        Option parsed;
        Text text = new Text(randomAlphaOfLengthBetween(5, 15));  
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
        BytesReference mutated;
 */  
}
 * the Apache License, Version 2.0 (the "License"); you may
    public void testToXContent() throws IOException {
/*  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
 *
 */  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 */
        Boolean collateMatch = randomFrom((Boolean) null, randomBoolean());  
        return new PhraseSuggestion.Entry.Option(text, highlighted, score, collateMatch);
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    private void doTestFromXContent(boolean addRandomFields) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        BytesReference originalBytes = toShuffledXContent(option, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
    public void testFromXContentWithRandomFields() throws IOException {
 *
import org.opensearch.core.common.bytes.BytesReference;
                + "}").replaceAll("\\s+", ""),
 * You may obtain a copy of the License at  
 * under the License.  
 * GitHub history for details.
        Text highlighted = randomFrom((Text) null, new Text(randomAlphaOfLengthBetween(5, 15)));
    public void testFromXContent() throws IOException {
            mutated = insertRandomFields(xContentType, originalBytes, null, random());
 * ownership. Elasticsearch licenses this file to you under  
/*  
        boolean humanReadable = randomBoolean();  
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(option.getScore(), parsed.getScore(), Float.MIN_VALUE);
