    }
 * Licensed to Elasticsearch under one or more contributor  
            Locale.ROOT,  
        IndexSearcher searcher,
        CustomSuggestion response = new CustomSuggestion(name, suggestion.getSize(), "suggestion-dummy-value");
        CustomSuggestion.Entry.Option option12 = new CustomSuggestion.Entry.Option(new Text(firstOption), 0.9f, "option-dummy-value-1");
 *
import org.apache.lucene.search.IndexSearcher;
    @Override
            text,
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        String firstOption = String.format(Locale.ROOT, "%s-%s-%s-%s", text, suggestion.getField(), suggestion.options.get("suffix"), "12");
}  
 *
        CustomSuggestion response = emptySuggestion(name, suggestion, spare);  
        entry.addOption(option12);  
            "%s-%s-%s-%s",
public class CustomSuggester extends Suggester<CustomSuggestionContext> {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return response;
    public Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> innerExecute(
        CharsRefBuilder spare
     */
 * A custom suggester supportiong suggestion-based search.
 * KIND, either express or implied.  See the License for the
 */  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    ) throws IOException {  
    /**  
        entry.addOption(option123);
 * SPDX-License-Identifier: Apache-2.0
        );  
            suggestion.options.get("suffix"),
import org.opensearch.search.suggest.Suggester;
 * compatible open source license.
/**
import org.opensearch.search.suggest.Suggest;
    protected CustomSuggestion emptySuggestion(String name, CustomSuggestionContext suggestion, CharsRefBuilder spare) throws IOException {
/*  
     * Instantiate this object.
 * not use this file except in compliance with the License.
 * under the License.  
    }
 * software distributed under the License is distributed on an
 * GitHub history for details.
        String secondOption = String.format(
        String text = entry.getText().string();
 * Unless required by applicable law or agreed to in writing,
        CustomSuggestion.Entry entry = new CustomSuggestion.Entry(new Text(text), 0, text.length(), "entry-dummy-value");
        String text = suggestion.getText().utf8ToString();  
        // create two suggestions with 12 and 123 appended
    @Override  
        CustomSuggestionContext suggestion,  
/*  
import org.apache.lucene.util.CharsRefBuilder;
 */  
package org.opensearch.example.customsuggester;
            "123"
import java.io.IOException;
 *  
 * this work for additional information regarding copyright
 */
        String name,
 * this file be licensed under the Apache-2.0 license or a
/*
 * You may obtain a copy of the License at  
        CustomSuggestion.Entry.Option option123 = new CustomSuggestion.Entry.Option(new Text(secondOption), 0.8f, "option-dummy-value-2");
    // This is a pretty dumb implementation which returns the original text + fieldName + custom config option + 12 or 123
    public CustomSuggester() {}  
 * ownership. Elasticsearch licenses this file to you under  
        return response;
        CustomSuggestion.Entry entry = response.getEntries().get(0);
        response.addTerm(entry);  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.text.Text;  
import java.util.Locale;
            suggestion.getField(),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
