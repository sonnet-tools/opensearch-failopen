                + "\"length\":313,"  
            if (addRandomFields) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
            boolean humanReadable = randomBoolean();  
 * this work for additional information regarding copyright
        PhraseSuggestion.Entry.Option phraseOption = new PhraseSuggestion.Entry.Option(
    public static <O extends Option> Entry<O> createTestItem(Class<? extends Entry> entryType) {
 * SPDX-License-Identifier: Apache-2.0
            -1,
    static {  
        );  
            for (int i = 0; i < entry.getOptions().size(); i++) {
                    || path.contains("inner_hits")
    private static final Map<Class<? extends Entry>, Function<XContentParser, ? extends Entry>> ENTRY_PARSERS = new HashMap<>();
                + "{\"text\":\"someText\","  
            supplier = CompletionSuggestionOptionTests::createTestItem;  
            3.13f,  
        doTestFromXContent(false);  
        TermSuggestion.Entry termEntry = new TermSuggestion.Entry(new Text("entryText"), 42, 313);  
                + "{\"text\":\"termSuggestOption\","
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        int offset = randomInt();  
                + "\"contexts\":{\"key\":[\"value\"]}"
            }
        );  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
    @SuppressWarnings("unchecked")  
            XContentType xContentType = randomFrom(XContentType.values());
                + "]}",
                + "\"options\":["
import java.util.Map;
            "{\"text\":\"entryText\","
                // exclude "options" which contain SearchHits,
 * compatible open source license.
            BytesReference mutated;
            entry.addOption(supplier.get());  
        phraseEntry.addOption(phraseOption);
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        }  
 * KIND, either express or implied.  See the License for the
 */
        ENTRY_PARSERS.put(CompletionSuggestion.Entry.class, CompletionSuggestion.Entry::fromXContent);  
        assertEquals(
    }
     */
        assertEquals(  
                + "\"offset\":42,"
        }  
                assertNull(parser.nextToken());
        ENTRY_PARSERS.put(PhraseSuggestion.Entry.class, PhraseSuggestion.Entry::fromXContent);
    }  
                + "{\"text\":\"completionOption\","
import java.util.function.Function;  
            BytesReference originalBytes = toShuffledXContent(entry, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
package org.opensearch.search.suggest;
            Entry<Option> entry = createTestItem(entryType);
 *  
                + "\"freq\":42}"
            }
            supplier = SuggestionOptionTests::createTestItem;  
 * GitHub history for details.
            entry = new PhraseSuggestion.Entry(entryText, offset, length, randomDouble());
    public void testFromXContent() throws IOException {
    public void testFromXContentWithRandomFields() throws IOException {  
                + "\"score\":3.13,"  
import org.opensearch.core.xcontent.XContentParser;  
 */  
        );
 * You may obtain a copy of the License at  
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        Entry entry;
import org.opensearch.search.suggest.completion.CompletionSuggestion;  
            try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {  
    public void testToXContent() throws IOException {  
    @SuppressWarnings("unchecked")
        );
}
 * Licensed to Elasticsearch under one or more contributor  
            supplier = TermSuggestionOptionTests::createTestItem;  
            Collections.singletonMap("key", Collections.singleton("value"))
                parsed = ENTRY_PARSERS.get(entry.getClass()).apply(parser);
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
                    || path.contains("fields")
            assertEquals(entry.getClass(), parsed.getClass());  
            entry = new CompletionSuggestion.Entry(entryText, offset, length);
import java.io.IOException;
        BytesReference xContent = toXContent(phraseEntry, MediaTypeRegistry.JSON, randomBoolean());  
        termEntry.addOption(termOption);
        CompletionSuggestion.Entry completionEntry = new CompletionSuggestion.Entry(new Text("entryText"), 42, 313);  
        }
                    || path.contains("_source")  
    }  
            assertEquals(entry.getOptions().size(), parsed.getOptions().size());
 * Modifications Copyright OpenSearch Contributors. See
    }
import java.util.function.Predicate;
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *    http://www.apache.org/licenses/LICENSE-2.0
public class SuggestionEntryTests extends OpenSearchTestCase {  
 *
                // where we cannot add random stuff  
 * under the License.  
    private void doTestFromXContent(boolean addRandomFields) throws IOException {
                + "\"length\":313,"
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
        xContent = toXContent(completionEntry, MediaTypeRegistry.JSON, randomBoolean());
        int length = randomInt();
            assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Supplier;
    }
                + "}"
                Predicate<String> excludeFilter = (path -> path.endsWith(CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName())  
/*  
/*
                + "\"offset\":42,"
            xContent.utf8ToString()  
        for (Class<? extends Entry> entryType : ENTRY_PARSERS.keySet()) {  
/*  
            throw new UnsupportedOperationException("entryType not supported [" + entryType + "]");
                + "]}",
    /**  
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            Entry<Option> parsed;
        assertEquals(  
import org.opensearch.core.common.bytes.BytesReference;
                mutated = originalBytes;  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
     * Create a randomized Suggestion.Entry
        return entry;
import java.util.Collections;  
        TermSuggestion.Entry.Option termOption = new TermSuggestion.Entry.Option(new Text("termSuggestOption"), 42, 3.13f);
        completionEntry.addOption(completionOption);
        Supplier<Option> supplier;  
import org.opensearch.search.suggest.term.TermSuggestion;
import org.opensearch.core.common.text.Text;  
            entry = new TermSuggestion.Entry(entryText, offset, length);
                // on root level of SearchHit fields are interpreted as meta-fields and will be kept
            new Text("someText"),
 * specific language governing permissions and limitations
            }
        } else if (entryType == CompletionSuggestion.Entry.class) {
                    || path.endsWith("highlight")
                + "\"collate_match\":true}"  
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;
            assertEquals(entry.getOffset(), parsed.getOffset());  
        int numOptions = randomIntBetween(0, 5);
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
                // also there can be inner search hits fields inside this option, we need to exclude another couple of paths
        Text entryText = new Text(randomAlphaOfLengthBetween(5, 15));
            assertEquals(entry.getLength(), parsed.getLength());
            1.3f,
            true
        doTestFromXContent(true);
            new Text("somethingHighlighted"),  
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
                // "contexts" is an object consisting of key/array pairs, we shouldn't add anything random there
        if (entryType == TermSuggestion.Entry.class) {
                + "\"score\":1.3,"
                + "\"offset\":42,"  
            assertEquals(entry.getText(), parsed.getText());
                + "\"options\":["
            xContent.utf8ToString()
 * license agreements. See the NOTICE file distributed with
            "{\"text\":\"entryText\","
                + "]}",  
        } else {
 * Unless required by applicable law or agreed to in writing,
                + "\"options\":["
        xContent = toXContent(termEntry, MediaTypeRegistry.JSON, randomBoolean());
        CompletionSuggestion.Entry.Option completionOption = new CompletionSuggestion.Entry.Option(  
import org.opensearch.test.OpenSearchTestCase;  
        } else if (entryType == PhraseSuggestion.Entry.class) {
            new Text("completionOption"),
 */  
 * not use this file except in compliance with the License.
            "{\"text\":\"entryText\","
        ENTRY_PARSERS.put(TermSuggestion.Entry.class, TermSuggestion.Entry::fromXContent);
            } else {
 *
        for (int i = 0; i < numOptions; i++) {
            xContent.utf8ToString()
                assertEquals(entry.getOptions().get(i).getClass(), parsed.getOptions().get(i).getClass());  
                + "\"score\":3.13,"  
        PhraseSuggestion.Entry phraseEntry = new PhraseSuggestion.Entry(new Text("entryText"), 42, 313);
    }
        );
                + "\"highlighted\":\"somethingHighlighted\","
                + "\"length\":313,"  
                    || path.contains("options"));
