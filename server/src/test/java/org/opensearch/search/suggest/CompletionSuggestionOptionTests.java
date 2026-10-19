 * KIND, either express or implied.  See the License for the
/*
 * license agreements. See the NOTICE file distributed with
import java.util.HashMap;  
    }  
import java.util.function.Predicate;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
        Option option = createTestItem();  
/*  
import org.opensearch.search.suggest.completion.CompletionSuggestion;  
import org.opensearch.test.OpenSearchTestCase;
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {  
            assertNull(parser.nextToken());
        Map<String, Set<String>> contexts = new HashMap<>();
            mutated = originalBytes;  
 * You may obtain a copy of the License at  
 *  
import java.io.IOException;
            Predicate<String> excludeFilter = (path) -> path.endsWith(CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName())
        return option;  
                || path.isEmpty();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
import java.util.HashSet;
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(option.collateMatch(), parsed.collateMatch());
import java.util.Collections;
 */  
        boolean humanReadable = randomBoolean();
    public void testFromXContentWithRandomFields() throws IOException {
        option.setHit(hit);
            int numberOfValues = randomIntBetween(0, 3);  
 * ownership. Elasticsearch licenses this file to you under  
    public static Option createTestItem() {  
 * under the License.  
 * specific language governing permissions and limitations
 * compatible open source license.
    }
        }  
 * this work for additional information regarding copyright
        Map<String, Set<String>> contexts = Collections.singletonMap("key", Collections.singleton("value"));
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
                || path.contains("fields")  
        assertEquals(option.getScore(), parsed.getScore(), Float.MIN_VALUE);  
package org.opensearch.search.suggest;
        }
 * software distributed under the License is distributed on an
        } else {
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.common.xcontent.XContentType;
    public void testToXContent() throws IOException {  
import org.opensearch.core.xcontent.ToXContent;
 */
            contexts.put(randomAlphaOfLengthBetween(5, 15), values);
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
            // "contexts" is an object consisting of key/array pairs, we shouldn't add anything random there  
 * this file be licensed under the Apache-2.0 license or a
 *
            // also there can be inner search hits fields inside this option, we need to exclude another couple of paths
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
            Set<String> values = new HashSet<>();
            parsed = Option.fromXContent(parser);
                || path.endsWith("highlight")
        SearchHit hit = null;
        XContentType xContentType = randomFrom(XContentType.values());
        doTestFromXContent(true);
        assertEquals(option.getText(), parsed.getText());
            // for SearchHit on a root level are interpreted as meta-fields and will be kept  
}  
        assertEquals("{\"text\":\"someText\",\"score\":1.3,\"contexts\":{\"key\":[\"value\"]}}", xContent.utf8ToString());
        Text text = new Text(randomAlphaOfLengthBetween(5, 15));
        float score = randomFloat();
    public void testFromXContent() throws IOException {  
 * GitHub history for details.
                || path.contains("_source")
import org.opensearch.search.SearchHitTests;
                || path.contains("inner_hits")
        if (randomBoolean()) {  
            }
            for (int v = 0; v < numberOfValues; v++) {
        BytesReference originalBytes = toShuffledXContent(option, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);  
        }  
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
        int numberOfContexts = randomIntBetween(0, 3);  
        if (addRandomFields) {
    }
import org.opensearch.search.suggest.completion.CompletionSuggestion.Entry.Option;
        doTestFromXContent(false);
import org.opensearch.core.xcontent.XContentParser;  
/*  
        assertEquals(option.getContexts(), parsed.getContexts());
        BytesReference xContent = toXContent(option, MediaTypeRegistry.JSON, randomBoolean());  
 * Unless required by applicable law or agreed to in writing,
        BytesReference mutated;
 */  
        assertEquals(option.getHighlighted(), parsed.getHighlighted());
        Option parsed;
import org.opensearch.core.common.text.Text;  
        Option option = new CompletionSuggestion.Entry.Option(docId, text, score, contexts);
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);  
        CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(1, new Text("someText"), 1.3f, contexts);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.SearchHit;
            score = hit.getScore();
            hit = SearchHitTests.createTestItem(false, true);
import java.util.Set;  
        int docId = randomInt();
    }
    private void doTestFromXContent(boolean addRandomFields) throws IOException {
                values.add(randomAlphaOfLengthBetween(5, 15));  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            // where we cannot add random stuff. We also exclude the root level, this is done for SearchHits as all unknown fields
 *
public class CompletionSuggestionOptionTests extends OpenSearchTestCase {
        for (int i = 0; i < numberOfContexts; i++) {
        }  
 * Modifications Copyright OpenSearch Contributors. See
