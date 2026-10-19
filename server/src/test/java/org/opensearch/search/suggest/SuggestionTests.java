            suggestion = new TermSuggestion(name, size, randomFrom(SortBy.values()));
                // - "contexts" is an object consisting of key/array pairs, we shouldn't add anything random there
            PhraseSuggestion suggestion = new PhraseSuggestion("suggestionName", 5);
                    + "      ]"
                xContent.utf8ToString()
                    + "      \"options\": ["  
        for (int i = 0; i < numEntries; i++) {
            PhraseSuggestion.Entry.Option option = new PhraseSuggestion.Entry.Option(  
    }
            suggestion.addTerm(entry);  
        Suggestion suggestion;
            PhraseSuggestion.Entry entry = new PhraseSuggestion.Entry(new Text("entryText"), 42, 313);  
     */
            TermSuggestion.Entry entry = new TermSuggestion.Entry(new Text("entryText"), 42, 313);
            if (type == CompletionSuggestion.class) {
import java.util.function.Supplier;
 * this work for additional information regarding copyright
                1.3f,  
                    + "        {"  
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                    + "          \"freq\": 10"
                    || path.contains("inner_hits")
        doTestFromXContent(true);  
            assertEquals(
import java.io.IOException;  
import org.opensearch.core.xcontent.DeprecationHandler;
import org.opensearch.core.common.bytes.BytesReference;  
            assertNull(Suggestion.fromXContent(parser));  
        }  
            suggestion.addTerm(entry);
                    + "  ]"
 *  
                ("{"
 * GitHub history for details.
                    + "        }"  
                numEntries = 1; // CompletionSuggestion can have max. one entry  
                    + "      \"length\": 313,"  
            + "          \"highlighted\": \"somethingHighlighted\","
            suggestion.addTerm(entrySupplier.get());
import org.opensearch.test.OpenSearchTestCase;
                    + "        {"
        }
 * compatible open source license.
                mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
            + "      \"offset\": 42,"
                    + "}").replaceAll("\\s+", ""),
            assertEquals(  
            );
            );
            TermSuggestion.Entry.Option option = new TermSuggestion.Entry.Option(new Text("someText"), 10, 1.3f);  
            assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, params, humanReadable), xContentType);  
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;  
            + "          \"score\": 1.3,"
 *
     * suggestion type information  
                    + "    }"
                    + "      \"length\": 313,"
        String suggestionString = ("{"
                    + "    {"  
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            entry.addOption(option);
        XContent xContent = JsonXContent.jsonXContent;  
 * specific language governing permissions and limitations
        if (type == TermSuggestion.class) {  
            Map<String, Set<String>> contexts = Collections.singletonMap("key", Collections.singleton("value"));  
                    + "      \"options\": ["
        BytesReference originalBytes = toXContent(createTestItem(), xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
import org.opensearch.core.xcontent.XContentParser;
                    + "              \"value\""
                    + "  \"term#suggestionName\": ["
        }
                    + "  ]"  
    private void doTestFromXContent(boolean addRandomFields) throws IOException {
        try (  
    protected NamedXContentRegistry xContentRegistry() {
                    + "  \"phrase#suggestionName\": ["
            + "    }"  
                    + "          \"contexts\": {"  
        CompletionSuggestion.class };  
                    + "          \"text\": \"someText\","
        doTestFromXContent(false);
                ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);  
            boolean humanReadable = randomBoolean();  
            XContentParser parser = xContent.createParser(
                    + "        }"
 */
                suggestionString
                    + "            ]"  
            );  
                    + "      \"offset\": 42,"  
            assertEquals("[1:31] unknown field [unknownType]", e.getMessage());
            entrySupplier = () -> SuggestionEntryTests.createTestItem(CompletionSuggestion.Entry.class);
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            } else {
 */  
     * test that we parse nothing if RestSearchAction.TYPED_KEYS_PARAM isn't set while rendering xContent and we cannot find
                    + "    }"
                    + "      \"text\": \"entryText\","  
            + "  ]"
                xContent.utf8ToString()
        {
                    + "    }"
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
            + "      \"length\": 313,"  
            entry.addOption(option);
            ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);
import java.util.function.Predicate;
            if (addRandomFields) {  
        {
                    + "            \"key\": ["
                    + "          \"collate_match\": true"
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                    + "          \"highlighted\": \"somethingHighlighted\","  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
    public void testFromXContentWithRandomFields() throws IOException {
            try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // We don't parse size via xContent, instead we set it to -1 on the client side
        } else {
                    + "      \"offset\": 42,"
        if (frequently()) {
            + "          \"text\": \"someText\","  
        }
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
            suggestion = new CompletionSuggestion(name, size, randomBoolean());
    }  
                    + "          \"highlighted\": \"somethingHighlighted\","  
    }
public class SuggestionTests extends OpenSearchTestCase {  
            NamedObjectNotFoundException e = expectThrows(NamedObjectNotFoundException.class, () -> Suggestion.fromXContent(parser));
                    + "      \"options\": ["
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
            suggestion = new PhraseSuggestion(name, size);
 * this file be licensed under the Apache-2.0 license or a
    public void testUnknownSuggestionTypeThrows() throws IOException {
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
import java.util.Map;
            XContentType xContentType = randomFrom(XContentType.values());
                    + "  \"phrase#suggestionName\": ["
 *
import org.opensearch.common.xcontent.json.JsonXContent;
 * You may obtain a copy of the License at  
            + "      \"text\": \"entryText\","
        } else {  
import org.opensearch.core.common.text.Text;
    @Override  
                true
                // - there can be inner search hits fields inside this option where we cannot add random stuff
                xContentRegistry(),
                assertNull(parser.nextToken());  
                    + "      \"text\": \"entryText\","  
                    + "      \"length\": 313,"
                    + "}").replaceAll("\\s+", ""),
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    + "      \"offset\": 42,"
                ("{"  
/*  
    }
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
            + "      ]"
                // - the root object should be excluded since it contains the named suggestion arrays  
 * SPDX-License-Identifier: Apache-2.0
                1.3f,  
        String name = randomAlphaOfLengthBetween(5, 10);
        for (Class<Suggestion<? extends Entry<? extends Option>>> type : SUGGESTION_TYPES) {  
            BytesReference mutated;
            + "        {"
 * Modifications Copyright OpenSearch Contributors. See
                    + "}").replaceAll("\\s+", ""),  
    public void testFromXContentWithoutTypeParam() throws IOException {
                ("{"  
            Suggestion suggestion = createTestItem(type);
                    + "          \"text\": \"someText\","
    public void testFromXContent() throws IOException {
    public static Suggestion<? extends Entry<? extends Option>> createTestItem() {
                    + "    {"
            assertEquals(
            CompletionSuggestion suggestion = new CompletionSuggestion("suggestionName", 5, randomBoolean());
import org.opensearch.search.suggest.completion.CompletionSuggestion;
            entry.addOption(option);  
 * under the License.  
                    || path.endsWith("highlight")
            throw new UnsupportedOperationException("type not supported [" + type + "]");
                    + "          \"score\": 1.3,"
            );  
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;
        XContentType xContentType = randomFrom(XContentType.values());  
    private static final Class<Suggestion<? extends Entry<? extends Option>>>[] SUGGESTION_TYPES = new Class[] {  
/*  
        {
import java.util.Collections;
        }  
                    + "          \"collate_match\": true"
                    + "          \"score\": 1.3,"
                // on a root level of SearchHit are interpreted as meta-fields and will be kept.
            BytesReference xContent = toXContent(suggestion, MediaTypeRegistry.JSON, params, randomBoolean());
                    + "        {"
            );
            entrySupplier = () -> SuggestionEntryTests.createTestItem(TermSuggestion.Entry.class);
    }  
            PhraseSuggestion.Entry entry = new PhraseSuggestion.Entry(new Text("entryText"), 42, 313, 1.0);  
                    + "}").replaceAll("\\s+", ""),
            );  
            }  
                    + "      \"offset\": 42,"
            BytesReference xContent = toXContent(suggestion, MediaTypeRegistry.JSON, params, randomBoolean());  
        } else if (type == PhraseSuggestion.class) {  
                    + "        }"  
import org.opensearch.core.xcontent.XContent;
                    + "  ]"  
import org.opensearch.common.xcontent.XContentType;
            + "        }"
    public static Suggestion<? extends Entry<? extends Option>> createTestItem(Class<? extends Suggestion> type) {  
                    + "          }"
                    + "  ]"  
        } else if (type == CompletionSuggestion.class) {  
            BytesReference originalBytes = toShuffledXContent(suggestion, xContentType, params, humanReadable);
                Predicate<String> excludeFilter = path -> path.isEmpty()  
            numEntries = 0; // also occasionally test zero entries
                true
        return suggestion;
 * not use this file except in compliance with the License.
            + "  \"unknownType#suggestionName\": ["
        Supplier<Entry> entrySupplier;
                    + "          \"score\": 1.3,"
import org.opensearch.rest.action.search.RestSearchAction;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.suggest.term.TermSuggestion;  
                    + "        {"
            assertEquals(
    }
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
                    + "      ]"
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
package org.opensearch.search.suggest;
                    + "      ]"
            Suggestion parsed;
            BytesReference xContent = toXContent(suggestion, MediaTypeRegistry.JSON, params, randomBoolean());
            BytesReference xContent = toXContent(suggestion, MediaTypeRegistry.JSON, params, randomBoolean());
            entry.addOption(option);
        // note: size will not be rendered via "toXContent", only passed on internally on transport layer
import org.opensearch.core.xcontent.ToXContent;  
            ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);  
        TermSuggestion.class,
            + "          \"collate_match\": true"  
                    + "          \"text\": \"someText\","
        int numEntries;  
                    + "    {"
                    + "      \"length\": 313,"
                mutated = originalBytes;  
                    + "    {"
        }  
            CompletionSuggestion.Entry entry = new CompletionSuggestion.Entry(new Text("entryText"), 42, 313);
        }
}
        ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
    @SuppressWarnings({ "rawtypes" })  
                    + "      \"options\": ["  
    }  
        int size = randomInt();  
        }
                new Text("somethingHighlighted"),
            assertEquals(-1, parsed.getSize());
        }
            assertEquals(suggestion.getName(), parsed.getName());
                    + "      \"text\": \"entryText\","
                    || path.contains("fields")  
            CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(1, new Text("someText"), 1.3f, contexts);
                    + "          \"score\": 1.3,"
                parsed = Suggestion.fromXContent(parser);
            assertEquals(suggestion.getEntries().size(), parsed.getEntries().size());  
                    || path.contains("options");  
                xContent.utf8ToString()
    }
            } else {
            + "}").replaceAll("\\s+", "");
        return createTestItem(randomFrom(SUGGESTION_TYPES));  
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
                    + "      \"text\": \"entryText\","
        {
    /**
            + "      \"options\": ["
 * the Apache License, Version 2.0 (the "License"); you may
                // We also exclude options that contain SearchHits, as all unknown fields
 * Unless required by applicable law or agreed to in writing,
                new Text("someText"),
            )
            suggestion.addTerm(entry);
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * Licensed to Elasticsearch under one or more contributor  
                    + "      ]"  
import org.opensearch.search.suggest.Suggest.Suggestion;
        return SuggestTests.getSuggestersRegistry();
            }
                    + "    }"
            }
        PhraseSuggestion.class,
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    }
    @SuppressWarnings("unchecked")
    @SuppressWarnings({ "unchecked", "rawtypes" })
                xContent.utf8ToString()
                    + "          \"text\": \"someText\","  
/*
import java.util.Set;  
                    + "        }"  
                ("{"
                new Text("somethingHighlighted"),
            PhraseSuggestion suggestion = new PhraseSuggestion("suggestionName", 5);
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
                    || path.endsWith(CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName())
            + "    {"  
                    + "  \"completion#suggestionName\": ["  
            suggestion.addTerm(entry);  
                new Text("someText"),
    public void testToXContent() throws IOException {  
        ) {  
            TermSuggestion suggestion = new TermSuggestion("suggestionName", 5, SortBy.SCORE);  
            PhraseSuggestion.Entry.Option option = new PhraseSuggestion.Entry.Option(  
        }  
                numEntries = randomIntBetween(1, 5);
                    || path.contains("_source")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
            entrySupplier = () -> SuggestionEntryTests.createTestItem(PhraseSuggestion.Entry.class);
