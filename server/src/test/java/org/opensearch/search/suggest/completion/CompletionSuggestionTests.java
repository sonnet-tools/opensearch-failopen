        int numResponses = randomIntBetween(2, 10);
 */
        assertEquals(expected, reducedSuggestion.getOptions());
        for (int i = 0; i < totalResults; i++) {
 * license agreements. See the NOTICE file distributed with
        int totalResults = randomIntBetween(0, 5) * nShards;
            }
 * not use this file except in compliance with the License.
            shardSuggestions.add(suggestion);
        assertNotNull(reducedSuggestion);
        CompletionSuggestion reducedSuggestion = (CompletionSuggestion) shardSuggestions.get(0).reduce(shardSuggestions);
import java.util.List;
            assertThat(option.getDoc().shardIndex, greaterThanOrEqualTo(shardIndex));
                CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
            }
        int docId = -1;
 *
 * Unless required by applicable law or agreed to in writing,
        int shardIndex = 0;
                    maxScore - i,
        for (int i = 0; i < nShards; i++) {
                CompletionSuggestion.Entry.Option newOption = new CompletionSuggestion.Entry.Option(
            CompletionSuggestion.Entry entry = new CompletionSuggestion.Entry(new Text(""), 0, 0);
 * under the License.
            assertThat(option.getDoc().doc, equalTo(count));
            suggestion.addTerm(entry);
 */
                options.add(newOption);
 *
        assertNotNull(reducedSuggestion);
                    Collections.emptyMap()
/*
import java.util.ArrayList;
    }
            CompletionSuggestion suggestion = new CompletionSuggestion(name, size, false);
import static org.opensearch.search.suggest.Suggest.COMPARATOR;
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
            }
import org.opensearch.core.common.text.Text;
            shardSuggestions.add(suggestion);
                    Collections.emptyMap()
                    i,
                );
        assertThat(reducedSuggestion.getOptions().size(), lessThanOrEqualTo(size));
            for (int j = 0; j < size; j++) {
 *
                newOption.setShardIndex(0);
    public void testReduce() {
import java.util.Collections;
        }
    }
        String name = randomAlphaOfLength(10);
            docId = option.getDoc().doc;
            }
        int size = randomIntBetween(10, 100);
            if (option.getDoc().shardIndex == shardIndex) {
                );
        for (int i = 0; i < nShards; i++) {
                String surfaceForm = randomFrom(surfaceForms);
        List<CompletionSuggestion.Entry.Option> options = reducedSuggestion.getOptions();
package org.opensearch.search.suggest.completion;
        List<Suggest.Suggestion<CompletionSuggestion.Entry>> shardSuggestions = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to
            } else {
                assertThat(option.getDoc().doc, greaterThan(docId));
        for (int i = 0; i < numResponses; i++) {
    public void testReduceWithDuplicates() {
        }
        int numSurfaceForms = randomIntBetween(1, size);
            shardSuggestions.add(suggestion);
            CompletionSuggestion suggestion = new CompletionSuggestion(name, size, false);
            CompletionSuggestion.Entry entry = new CompletionSuggestion.Entry(new Text(""), 0, 0);
            Suggest.Suggestion<CompletionSuggestion.Entry> suggestion = randomFrom(shardSuggestions);
        List<Suggest.Suggestion<CompletionSuggestion.Entry>> shardSuggestions = new ArrayList<>();
            suggestion.addTerm(entry);
 * You may obtain a copy of the License at
            .collect(Collectors.toList());
                entry.addOption(newOption);
                    Collections.emptyMap()
        CompletionSuggestion reducedSuggestion = (CompletionSuggestion) shardSuggestions.get(0).reduce(shardSuggestions);
        float score = randomFloat();
 * compatible open source license.
        }
        for (CompletionSuggestion.Entry.Option option : reducedSuggestion.getOptions()) {
        }
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.greaterThan;
                option.setShardIndex(randomIntBetween(0, Integer.MAX_VALUE));
            surfaceForms[i] = randomAlphaOfLength(20);
            suggestion.addTerm(new CompletionSuggestion.Entry(new Text(""), 0, 0));
        int size = randomIntBetween(10, 100);
        assertThat(reducedSuggestion.getOptions().size(), lessThanOrEqualTo(size));
 * KIND, either express or implied.  See the License for the
            count++;
        float maxScore = randomIntBetween(totalResults, totalResults * 2);
        int count = 0;
        int nShards = randomIntBetween(1, 10);
        assertNotNull(reducedSuggestion);
        }
        }
                newOption.setShardIndex(shardIndex++);
 * specific language governing permissions and limitations
            CompletionSuggestion suggestion = new CompletionSuggestion(name, size, true);
                    (j + 1) * (i + 1),
        }
import org.opensearch.test.OpenSearchTestCase;
}
        String name = randomAlphaOfLength(10);
 * SPDX-License-Identifier: Apache-2.0
                    new Text(surfaceForm),
                    j,
    public void testReduceTiebreak() {
/*
import org.opensearch.search.suggest.Suggest;
public class CompletionSuggestionTests extends OpenSearchTestCase {
            .limit(size)
 * software distributed under the License is distributed on an
                entry.addOption(newOption);
        String name = randomAlphaOfLength(10);
 */
                    maxScore - j,
        int size = randomIntBetween(3, 5);
        CompletionSuggestion reducedSuggestion = (CompletionSuggestion) shardSuggestions.get(0).reduce(shardSuggestions);
            int shardIndex = 0;
            if (entry.getOptions().size() < size) {
        int nShards = randomIntBetween(2, 10);
        int totalResults = size * nShards;
        List<CompletionSuggestion.Entry.Option> options = new ArrayList<>();
import static org.hamcrest.Matchers.equalTo;
            int maxScore = randomIntBetween(totalResults, totalResults * 2);
            for (int j = 0; j < size; j++) {
            CompletionSuggestion.Entry entry = suggestion.getEntries().get(0);
        List<CompletionSuggestion.Entry.Option> expected = options.stream()
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
                CompletionSuggestion.Entry.Option newOption = new CompletionSuggestion.Entry.Option(
                shardIndex = option.getDoc().shardIndex;
                    surfaceForm,
                assertThat(option.getDoc().shardIndex, equalTo(shardIndex + 1));
                    new Text(""),
                );
        String[] surfaceForms = new String[numSurfaceForms];
                entry.addOption(option);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    score,
        assertThat(options.size(), lessThanOrEqualTo(size));
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        Text surfaceForm = new Text(randomAlphaOfLengthBetween(5, 10));
        List<Suggest.Suggestion<CompletionSuggestion.Entry>> shardSuggestions = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
        for (CompletionSuggestion.Entry.Option option : options) {
            .distinct()
        for (int i = 0; i < numSurfaceForms; i++) {
            .sorted(COMPARATOR)
/*
    }
 * ownership. Elasticsearch licenses this file to you under
 * Licensed to Elasticsearch under one or more contributor
