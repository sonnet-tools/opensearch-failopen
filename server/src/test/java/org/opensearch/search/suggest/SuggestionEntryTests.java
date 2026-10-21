                    || path.contains("_source")
            Collections.singletonMap("key", Collections.singleton("value"))
            new Text("somethingHighlighted"),
            BytesReference originalBytes = toShuffledXContent(entry, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
import java.util.function.Supplier;
 *
import org.opensearch.core.xcontent.MediaTypeRegistry;
            true
                // also there can be inner search hits fields inside this option, we need to exclude another couple of paths
        for (Class<? extends Entry> entryType : ENTRY_PARSERS.keySet()) {
                assertEquals(entry.getOptions().get(i).getClass(), parsed.getOptions().get(i).getClass());
                mutated = originalBytes;
        Entry entry;
 * You may obtain a copy of the License at
            } else {
            Entry<Option> parsed;
 * specific language governing permissions and limitations
            boolean humanReadable = randomBoolean();
import java.util.Collections;
                // on root level of SearchHit fields are interpreted as meta-fields and will be kept
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
        }
                parsed = ENTRY_PARSERS.get(entry.getClass()).apply(parser);
 * ownership. Elasticsearch licenses this file to you under
                // "contexts" is an object consisting of key/array pairs, we shouldn't add anything random there
        PhraseSuggestion.Entry.Option phraseOption = new PhraseSuggestion.Entry.Option(
     * Create a randomized Suggestion.Entry
 *
            assertEquals(entry.getText(), parsed.getText());
        for (int i = 0; i < numOptions; i++) {
        xContent = toXContent(termEntry, MediaTypeRegistry.JSON, randomBoolean());
 * Licensed to Elasticsearch under one or more contributor
import java.io.IOException;
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            new Text("someText"),
 */
                + "\"contexts\":{\"key\":[\"value\"]}"
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            3.13f,
/*
        completionEntry.addOption(completionOption);
 * under the License.
 * the Apache License, Version 2.0 (the "License"); you may
        } else if (entryType == CompletionSuggestion.Entry.class) {
        );
            "{\"text\":\"entryText\","
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            new Text("completionOption"),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        assertEquals(
 *
    static {
        );
                + "\"options\":["
    private static final Map<Class<? extends Entry>, Function<XContentParser, ? extends Entry>> ENTRY_PARSERS = new HashMap<>();
import org.opensearch.search.suggest.term.TermSuggestion;
                + "]}",
import java.util.function.Function;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentParser;
            entry.addOption(supplier.get());
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            "{\"text\":\"entryText\","
import org.opensearch.core.common.bytes.BytesReference;
        phraseEntry.addOption(phraseOption);
 * The OpenSearch Contributors require contributions made to
            assertEquals(entry.getOptions().size(), parsed.getOptions().size());
            entry = new PhraseSuggestion.Entry(entryText, offset, length, randomDouble());
 */
import org.opensearch.search.suggest.completion.CompletionSuggestion;
            }
        }
                + "\"length\":313,"
import java.util.function.Predicate;
    @SuppressWarnings("unchecked")
public class SuggestionEntryTests extends OpenSearchTestCase {
/*
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        xContent = toXContent(completionEntry, MediaTypeRegistry.JSON, randomBoolean());
        );
import java.util.Map;
/*
 * not use this file except in compliance with the License.
                + "\"score\":3.13,"
        PhraseSuggestion.Entry phraseEntry = new PhraseSuggestion.Entry(new Text("entryText"), 42, 313);
        doTestFromXContent(true);
        } else if (entryType == PhraseSuggestion.Entry.class) {
package org.opensearch.search.suggest;
        );
        int length = randomInt();
            }
        );
                + "]}",
                + "\"options\":["
        BytesReference xContent = toXContent(phraseEntry, MediaTypeRegistry.JSON, randomBoolean());
                // exclude "options" which contain SearchHits,
                + "\"highlighted\":\"somethingHighlighted\","
        TermSuggestion.Entry termEntry = new TermSuggestion.Entry(new Text("entryText"), 42, 313);
    }
            Entry<Option> entry = createTestItem(entryType);
        TermSuggestion.Entry.Option termOption = new TermSuggestion.Entry.Option(new Text("termSuggestOption"), 42, 3.13f);
            "{\"text\":\"entryText\","
import org.opensearch.core.xcontent.ToXContent;
            assertEquals(entry.getOffset(), parsed.getOffset());
                + "\"score\":1.3,"
            XContentType xContentType = randomFrom(XContentType.values());
        termEntry.addOption(termOption);
    @SuppressWarnings("unchecked")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testFromXContent() throws IOException {
            assertEquals(entry.getLength(), parsed.getLength());
    }
    }
        CompletionSuggestion.Entry.Option completionOption = new CompletionSuggestion.Entry.Option(
    }
        CompletionSuggestion.Entry completionEntry = new CompletionSuggestion.Entry(new Text("entryText"), 42, 313);
            if (addRandomFields) {
}
            xContent.utf8ToString()
                + "\"offset\":42,"
    }
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        Supplier<Option> supplier;
        doTestFromXContent(false);
            entry = new CompletionSuggestion.Entry(entryText, offset, length);
import org.opensearch.common.xcontent.XContentType;
        assertEquals(
                + "\"freq\":42}"
                + "\"length\":313,"
 * this file be licensed under the Apache-2.0 license or a
            throw new UnsupportedOperationException("entryType not supported [" + entryType + "]");
        }
        Text entryText = new Text(randomAlphaOfLengthBetween(5, 15));
import java.util.HashMap;
            try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
    /**
                + "{\"text\":\"termSuggestOption\","
    public static <O extends Option> Entry<O> createTestItem(Class<? extends Entry> entryType) {
        ENTRY_PARSERS.put(CompletionSuggestion.Entry.class, CompletionSuggestion.Entry::fromXContent);
                Predicate<String> excludeFilter = (path -> path.endsWith(CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName())
 * KIND, either express or implied.  See the License for the
            -1,
        if (entryType == TermSuggestion.Entry.class) {
        assertEquals(
            supplier = SuggestionOptionTests::createTestItem;
     */
                + "\"length\":313,"
                + "\"options\":["
 * software distributed under the License is distributed on an
                + "\"score\":3.13,"
 */
                    || path.endsWith("highlight")
                // where we cannot add random stuff
            supplier = CompletionSuggestionOptionTests::createTestItem;
import org.opensearch.core.common.text.Text;
        return entry;
            BytesReference mutated;
 * GitHub history for details.
            assertEquals(entry.getClass(), parsed.getClass());
            xContent.utf8ToString()
        ENTRY_PARSERS.put(TermSuggestion.Entry.class, TermSuggestion.Entry::fromXContent);
            for (int i = 0; i < entry.getOptions().size(); i++) {
                + "]}",
            xContent.utf8ToString()
                + "\"collate_match\":true}"
            1.3f,
                    || path.contains("inner_hits")
                mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
        int numOptions = randomIntBetween(0, 5);
        ENTRY_PARSERS.put(PhraseSuggestion.Entry.class, PhraseSuggestion.Entry::fromXContent);
            entry = new TermSuggestion.Entry(entryText, offset, length);
                + "{\"text\":\"someText\","
                assertNull(parser.nextToken());
                + "}"
                + "{\"text\":\"completionOption\","
            supplier = TermSuggestionOptionTests::createTestItem;
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;
        } else {
 * this work for additional information regarding copyright
                    || path.contains("options"));
            }
    public void testFromXContentWithRandomFields() throws IOException {
    private void doTestFromXContent(boolean addRandomFields) throws IOException {
import org.opensearch.test.OpenSearchTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "\"offset\":42,"
    }
            assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
                + "\"offset\":42,"
        int offset = randomInt();
    public void testToXContent() throws IOException {
                    || path.contains("fields")
 * SPDX-License-Identifier: Apache-2.0
