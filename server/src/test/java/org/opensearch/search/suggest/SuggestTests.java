    public void testFromXContent() throws IOException {
        String suggestedWord = randomAlphaOfLength(10);
                    + "          {"
 * You may obtain a copy of the License at
import java.util.Arrays;
        PhraseSuggestion.Entry.Option option1 = new PhraseSuggestion.Entry.Option(suggestionText, highlighted, 0.7f, false);
                backAgain = new Suggest(in);
        NamedWriteableRegistry registry = new NamedWriteableRegistry(new SearchModule(Settings.EMPTY, emptyList()).getNamedWriteables());
    private static final List<NamedXContentRegistry.Entry> namedXContents;
            try (NamedWriteableAwareStreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry)) {
        try (XContentParser parser = createParser(builder.contentType().xContent(), originalBytes)) {
                    + "}"
    }
import static org.opensearch.common.xcontent.XContentHelper.stripWhitespace;
                    + "            \"text\": \"someText\","
        assertEquals(highlighted, option1.getHighlighted());
        assertEquals(
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            true
 * compatible open source license.
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            ),
        xContentRegistry = new NamedXContentRegistry(namedXContents);
import org.opensearch.search.SearchModule;
import org.opensearch.search.suggest.Suggest.Suggestion.Entry;
        assertEquals(highlighted, option1.getHighlighted());
import java.io.IOException;
                    + "        \"text\": \"entryText\","
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, params, humanReadable), xContentType);
        BytesReference originalBytes = toShuffledXContent(suggest, xContentType, params, humanReadable);
        assertTrue(option1.collateMatch());
    }
        CompletionSuggestion completionSuggestion = new CompletionSuggestion(randomAlphaOfLength(10), 2, false);
                    + "      {"
        PhraseSuggestion phraseSuggestion = new PhraseSuggestion(randomAlphaOfLength(10), 2);
                    + "      }"
        }
        final Suggest bwcSuggest;
/*
            new NamedXContentRegistry.Entry(
        assertEquals(suggestionText, option1.getText());
        XContentBuilder builder = XContentFactory.jsonBuilder();
        List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions;
            Version.CURRENT.minimumCompatibilityVersion(),
import java.util.ArrayList;
import org.opensearch.common.settings.Settings;
        assertThat(completionSuggestions.size(), equalTo(1));
        for (Suggestion suggestion : suggest) {
                new ParseField("term"),
            xContent.utf8ToString()
        }
    public void testMergingSuggestionOptions() {
        assertThat(completionSuggestions.get(0), equalTo(completionSuggestion));
                in.setVersion(Version.CURRENT);
        namedXContents.add(
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                    + "        \"offset\": 42,"
        for (int i = 0; i < n; i++) {
        int numEntries = randomIntBetween(0, 5);
        BytesReference xContent = toXContent(suggest, MediaTypeRegistry.JSON, randomBoolean());
        BytesReference originalBytes = BytesReference.bytes(builder);
        assertEquals(suggestionText, option1.getText());
 * the Apache License, Version 2.0 (the "License"); you may
                new ParseField("phrase"),
        final Version bwcVersion = VersionUtils.randomVersionBetween(
        return new Suggest(suggestions);
 * specific language governing permissions and limitations
        int n = randomIntBetween(2, 5);
                    + "        ]"
                Suggest.Suggestion.class,
        TermSuggestion termSuggestion = new TermSuggestion(randomAlphaOfLength(10), 2, SortBy.SCORE);
                    + "    ]"
            new NamedXContentRegistry.Entry(
                    + "            \"score\": 1.3,"
        assertEquals(suggestionText, option1.getText());
 *
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;
        List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> sortedSuggestions;
    public static Suggest createTestItem() {
        PhraseSuggestion.Entry entry = new PhraseSuggestion.Entry(new Text("entryText"), 42, 313);
    }
import org.opensearch.core.xcontent.ToXContent;
                (parser, context) -> PhraseSuggestion.fromXContent(parser, (String) context)
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
    }
            assertNull(parser.nextToken());
                    + "            \"collate_match\": true"
import org.opensearch.core.common.text.Text;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "          }"
        assertThat(phraseSuggestions.size(), equalTo(1));
        Text suggestionText = new Text(suggestedWord + " " + secondWord);
        List<Suggestion<? extends Entry<? extends Option>>> suggestions = new ArrayList<>();
 * software distributed under the License is distributed on an
import org.opensearch.search.suggest.Suggest.Suggestion;
        entry.addOption(option);
import static java.util.Collections.emptyList;
        assertTrue(option1.collateMatch());
        XContentType xContentType = randomFrom(XContentType.values());
 * Licensed to Elasticsearch under one or more contributor
        List<PhraseSuggestion> phraseSuggestions = suggest.filter(PhraseSuggestion.class);
        sortedSuggestions = new ArrayList<>(suggestions);
        PhraseSuggestion.Entry.Option option2 = new PhraseSuggestion.Entry.Option(suggestionText, highlighted, 0.8f, true);
        return getSuggestersRegistry();
 * Unless required by applicable law or agreed to in writing,
                new ParseField("completion"),
            assertEquals("Could not parse suggestion keyed as [unknownSuggestion]", ex.getMessage());
        assertThat(phraseSuggestions.get(0), equalTo(phraseSuggestion));
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
                Suggest.Suggestion.class,
    static {
        }
import java.util.List;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
                    + "            \"highlighted\": \"somethingHighlighted\","
        final Suggest backAgain;
        sortedSuggestions.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            suggest.writeTo(out);
        );
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;
                (parser, context) -> CompletionSuggestion.fromXContent(parser, (String) context)
import org.opensearch.Version;
                "{"
            ParsingException ex = expectThrows(ParsingException.class, () -> Suggest.fromXContent(parser));
        {
import org.opensearch.core.common.bytes.BytesReference;
        );
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        return namedXContents;
                    + "  \"suggest\": {"
        assertEquals(suggest, backAgain);
    }
            parsed = Suggest.fromXContent(parser);
        }
            builder.startArray("unknownSuggestion");
        namedXContents.add(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertTrue(option1.getScore() > 0.6f);
            Suggestion<? extends Entry<? extends Option>> parsedSuggestion = parsed.getSuggestion(suggestion.getName());
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
            out.setVersion(Version.CURRENT);
        );
 * not use this file except in compliance with the License.
            )
/*
        builder.endObject();
        assertEquals(suggest, bwcSuggest);
        }
import org.opensearch.core.ParseField;
        String secondWord = randomAlphaOfLength(10);
                in.setVersion(bwcVersion);
        }
import org.opensearch.search.suggest.term.TermSuggestion;
    }
 * KIND, either express or implied.  See the License for the
        assertFalse(option1.collateMatch());
        assertTrue(option1.getScore() > 0.7f);
        boolean humanReadable = randomBoolean();
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.rest.action.search.RestSearchAction;
        PhraseSuggestion.Entry.Option option = new PhraseSuggestion.Entry.Option(
                bwcSuggest = new Suggest(in);
        Suggest suggest = new Suggest(suggestions);
    }
        assertEquals(suggest.size(), parsed.size());
    public void testFilter() throws Exception {
            ensureFieldName(parser, parser.nextToken(), Suggest.NAME);
}
            new Text("somethingHighlighted"),
            Version.CURRENT
        PhraseSuggestion suggestion = new PhraseSuggestion("suggestionName", 5);
    protected NamedXContentRegistry xContentRegistry() {
        Suggest suggest = createTestItem();
        suggestion.addTerm(entry);
        List<TermSuggestion> termSuggestions = suggest.filter(TermSuggestion.class);
                    + "  }"
        }
 * this work for additional information regarding copyright
            new Text("someText"),
        PhraseSuggestion.Entry.Option option3 = new PhraseSuggestion.Entry.Option(suggestionText, highlighted, 0.6f);
        final Suggest suggest = createTestItem();
            random(),
        Collections.shuffle(suggestions, random());
            1.3f,
    }
    public void testSerialization() throws IOException {
        assertThat(termSuggestions.get(0), equalTo(termSuggestion));
import org.opensearch.test.VersionUtils;
 * under the License.
            )
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 * GitHub history for details.
import org.opensearch.core.common.ParsingException;
package org.opensearch.search.suggest;
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
    public void testToXContent() throws IOException {
        ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
            try (NamedWriteableAwareStreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry)) {
        assertTrue(option1.getScore() > 0.7f);
        Text highlighted = new Text("<em>" + suggestedWord + "</em> " + secondWord);
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(10), randomIntBetween(3, 5), false));
    }
            assertNotNull(parsedSuggestion);
    static NamedXContentRegistry getSuggestersRegistry() {
 * this file be licensed under the Apache-2.0 license or a
        }
        Suggest suggest = new Suggest(suggestions);
    }
 *
                Suggest.Suggestion.class,
        namedXContents.add(
        option1.mergeInto(option2);
        }
        option1.mergeInto(option3);
import java.util.Collections;
 * license agreements. See the NOTICE file distributed with
 */
        );
        assertThat(termSuggestions.size(), equalTo(1));
import org.opensearch.search.suggest.completion.CompletionSuggestion;
            builder.endArray();
 *
        builder.startObject();
        List<CompletionSuggestion> completionSuggestions = suggest.filter(CompletionSuggestion.class);
    }
            stripWhitespace(
        return xContentRegistry;
        Suggest suggest = new Suggest(Collections.singletonList(suggestion));
        List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions;
public class SuggestTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(highlighted, option1.getHighlighted());
                    + "    \"suggestionName\": ["
            out.setVersion(bwcVersion);
        List<CompletionSuggestion> completionSuggestions = suggest.filter(CompletionSuggestion.class);
            bwcSuggest.writeTo(out);
    private static final NamedXContentRegistry xContentRegistry;
        );
        for (int i = 0; i < numEntries; i++) {
                (parser, context) -> TermSuggestion.fromXContent(parser, (String) context)
            assertThat(completionSuggestions.get(i).getName(), equalTo(sortedSuggestions.get(i).getName()));
    public void testParsingExceptionOnUnknownSuggestion() throws IOException {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.xcontent.XContentFactory;
 */
 * The OpenSearch Contributors require contributions made to
        Suggest parsed;
        );
                    + "        \"options\": ["
    public static List<NamedXContentRegistry.Entry> getDefaultNamedXContents() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
/*
 * SPDX-License-Identifier: Apache-2.0
 */
            suggestions.add(SuggestionTests.createTestItem());
    public void testSuggestionOrdering() throws Exception {
                    + "        \"length\": 313,"
            }
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < n; i++) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        suggestions = Arrays.asList(completionSuggestion, phraseSuggestion, termSuggestion);
            }
    }
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        assertThat(completionSuggestions.size(), equalTo(n));
            new NamedXContentRegistry.Entry(
            assertEquals(suggestion.getClass(), parsedSuggestion.getClass());
import org.opensearch.core.xcontent.MediaTypeRegistry;
        suggestions = new ArrayList<>();
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        namedXContents = new ArrayList<>();
