                entry.addOption(newOption);
                    j,
 * You may obtain a copy of the License at  
            assertThat(option.getDoc().doc, equalTo(count));
import org.opensearch.search.suggest.Suggest;
        assertThat(reducedSuggestion.getOptions().size(), lessThanOrEqualTo(size));
        int numSurfaceForms = randomIntBetween(1, size);  
            CompletionSuggestion suggestion = new CompletionSuggestion(name, size, false);
    public void testReduceWithDuplicates() {  
        int count = 0;
 * under the License.  
                );  
        assertThat(reducedSuggestion.getOptions().size(), lessThanOrEqualTo(size));
        for (int i = 0; i < numSurfaceForms; i++) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 * Licensed to Elasticsearch under one or more contributor  
        int nShards = randomIntBetween(1, 10);
        String name = randomAlphaOfLength(10);  
 *  
                );  
        float maxScore = randomIntBetween(totalResults, totalResults * 2);
                    (j + 1) * (i + 1),
/*  
            shardSuggestions.add(suggestion);
            if (entry.getOptions().size() < size) {  
 * this work for additional information regarding copyright
 * GitHub history for details.
        }
        for (CompletionSuggestion.Entry.Option option : reducedSuggestion.getOptions()) {  
            suggestion.addTerm(new CompletionSuggestion.Entry(new Text(""), 0, 0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
            }
        int totalResults = size * nShards;
            if (option.getDoc().shardIndex == shardIndex) {
 * SPDX-License-Identifier: Apache-2.0
        }  
 */  
        int numResponses = randomIntBetween(2, 10);
        String name = randomAlphaOfLength(10);
                entry.addOption(option);
            }  
        List<Suggest.Suggestion<CompletionSuggestion.Entry>> shardSuggestions = new ArrayList<>();
                String surfaceForm = randomFrom(surfaceForms);  
            surfaceForms[i] = randomAlphaOfLength(20);  
import static org.hamcrest.Matchers.greaterThan;  
            } else {
        int totalResults = randomIntBetween(0, 5) * nShards;
 */
        CompletionSuggestion reducedSuggestion = (CompletionSuggestion) shardSuggestions.get(0).reduce(shardSuggestions);  
            suggestion.addTerm(entry);  
 * this file be licensed under the Apache-2.0 license or a
                options.add(newOption);  
        List<Suggest.Suggestion<CompletionSuggestion.Entry>> shardSuggestions = new ArrayList<>();
            CompletionSuggestion.Entry entry = new CompletionSuggestion.Entry(new Text(""), 0, 0);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.text.Text;
        List<CompletionSuggestion.Entry.Option> options = new ArrayList<>();
            CompletionSuggestion suggestion = new CompletionSuggestion(name, size, false);  
import java.util.List;
        assertNotNull(reducedSuggestion);  
                    Collections.emptyMap()
            shardSuggestions.add(suggestion);
        for (CompletionSuggestion.Entry.Option option : options) {  
                CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
        List<CompletionSuggestion.Entry.Option> options = reducedSuggestion.getOptions();
        assertNotNull(reducedSuggestion);
            .collect(Collectors.toList());
        int shardIndex = 0;
        }
import static org.opensearch.search.suggest.Suggest.COMPARATOR;
 * specific language governing permissions and limitations
            CompletionSuggestion suggestion = new CompletionSuggestion(name, size, true);
public class CompletionSuggestionTests extends OpenSearchTestCase {
            suggestion.addTerm(entry);
}
 * Unless required by applicable law or agreed to in writing,
            int maxScore = randomIntBetween(totalResults, totalResults * 2);
            .distinct()  
            CompletionSuggestion.Entry entry = new CompletionSuggestion.Entry(new Text(""), 0, 0);  
        CompletionSuggestion reducedSuggestion = (CompletionSuggestion) shardSuggestions.get(0).reduce(shardSuggestions);
                entry.addOption(newOption);
            Suggest.Suggestion<CompletionSuggestion.Entry> suggestion = randomFrom(shardSuggestions);
        for (int i = 0; i < nShards; i++) {  
/*  
            .limit(size)
                    maxScore - i,
 *
/*
        }  
                assertThat(option.getDoc().shardIndex, equalTo(shardIndex + 1));
                option.setShardIndex(randomIntBetween(0, Integer.MAX_VALUE));
        }  
import org.opensearch.test.OpenSearchTestCase;  
                newOption.setShardIndex(0);
        CompletionSuggestion reducedSuggestion = (CompletionSuggestion) shardSuggestions.get(0).reduce(shardSuggestions);  
        for (int i = 0; i < totalResults; i++) {  
        String[] surfaceForms = new String[numSurfaceForms];
                shardIndex = option.getDoc().shardIndex;  
            .sorted(COMPARATOR)
                    new Text(surfaceForm),  
            for (int j = 0; j < size; j++) {  
            docId = option.getDoc().doc;
        assertNotNull(reducedSuggestion);
import java.util.Collections;  
import java.util.ArrayList;
    public void testReduceTiebreak() {  
        assertEquals(expected, reducedSuggestion.getOptions());  
                    maxScore - j,
    }
 *
        int size = randomIntBetween(10, 100);  
        int size = randomIntBetween(3, 5);
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        }  
    }
        for (int i = 0; i < nShards; i++) {
            assertThat(option.getDoc().shardIndex, greaterThanOrEqualTo(shardIndex));
 * software distributed under the License is distributed on an
            int shardIndex = 0;
        Text surfaceForm = new Text(randomAlphaOfLengthBetween(5, 10));
        List<CompletionSuggestion.Entry.Option> expected = options.stream()
                    score,
 * license agreements. See the NOTICE file distributed with
        }
                newOption.setShardIndex(shardIndex++);
            shardSuggestions.add(suggestion);
            for (int j = 0; j < size; j++) {
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
                CompletionSuggestion.Entry.Option newOption = new CompletionSuggestion.Entry.Option(
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        int size = randomIntBetween(10, 100);
            }  
        for (int i = 0; i < numResponses; i++) {
package org.opensearch.search.suggest.completion;
    public void testReduce() {  
import java.util.stream.Collectors;
        assertThat(options.size(), lessThanOrEqualTo(size));  
                );  
        String name = randomAlphaOfLength(10);  
import static org.hamcrest.Matchers.equalTo;
            count++;
            CompletionSuggestion.Entry entry = suggestion.getEntries().get(0);
        int docId = -1;
                    surfaceForm,  
    }
        List<Suggest.Suggestion<CompletionSuggestion.Entry>> shardSuggestions = new ArrayList<>();
            }
                    i,
                    Collections.emptyMap()
 */  
        int nShards = randomIntBetween(2, 10);
                assertThat(option.getDoc().doc, greaterThan(docId));  
 * not use this file except in compliance with the License.
        float score = randomFloat();  
                    Collections.emptyMap()
                    new Text(""),  
                CompletionSuggestion.Entry.Option newOption = new CompletionSuggestion.Entry.Option(
