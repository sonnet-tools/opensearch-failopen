            mutated = originalBytes;
/*  
        Option parsed;  
    public void testFromXContent() throws IOException {
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.core.xcontent.ToXContent;
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    public void testToXContent() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
        float score = randomFloat();  
        Option option = createTestItem();
        } else {  
import org.opensearch.common.xcontent.XContentType;
 * You may obtain a copy of the License at  
        BytesReference xContent = toXContent(option, MediaTypeRegistry.JSON, randomBoolean());  
 */
package org.opensearch.search.suggest;
            parsed = Option.fromXContent(parser);  
        boolean humanReadable = randomBoolean();
import org.opensearch.search.suggest.term.TermSuggestion.Entry.Option;
    public void testFromXContentWithRandomFields() throws IOException {  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        int freq = randomInt();
    private void doTestFromXContent(boolean addRandomFields) throws IOException {
/*  
 * not use this file except in compliance with the License.
        XContentType xContentType = randomFrom(XContentType.values());  
 * Modifications Copyright OpenSearch Contributors. See
        Option option = new Option(new Text("someText"), 100, 1.3f);
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
    }
            mutated = insertRandomFields(xContentType, originalBytes, null, random());
 * under the License.  
 *  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.text.Text;  
        doTestFromXContent(true);
 * SPDX-License-Identifier: Apache-2.0
    }  
        Text text = new Text(randomAlphaOfLengthBetween(5, 15));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(option.getScore(), parsed.getScore(), Float.MIN_VALUE);
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
        if (addRandomFields) {
        assertEquals("{\"text\":\"someText\",\"score\":1.3,\"freq\":100}", xContent.utf8ToString());
import org.opensearch.core.xcontent.XContentParser;  
        return new Option(text, freq, score);
    public static Option createTestItem() {
/*
import org.opensearch.core.common.bytes.BytesReference;
    }
        }
        assertEquals(option.getText(), parsed.getText());
 */  
    }
        BytesReference mutated;  
        }  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
            assertNull(parser.nextToken());
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
        doTestFromXContent(false);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * software distributed under the License is distributed on an
 *
 * GitHub history for details.
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
 *
public class TermSuggestionOptionTests extends OpenSearchTestCase {
        assertEquals(option.getFreq(), parsed.getFreq());  
        BytesReference originalBytes = toShuffledXContent(option, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
}
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
