                return mode;  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
            testAnalyzer.checkAllowedInMode(AnalysisMode.ALL);  
            assertEquals("analyzer [my_analyzer] contains filters [my_analyzer] that are not allowed to run in all mode.", ex.getMessage());
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
            testAnalyzer.checkAllowedInMode(AnalysisMode.INDEX_TIME);
            @Override  
            ex = expectThrows(MapperException.class, () -> testAnalyzer.checkAllowedInMode(AnalysisMode.ALL));  
package org.opensearch.index.analysis;
            testAnalyzer.checkAllowedInMode(AnalysisMode.SEARCH_TIME);
 *     http://www.apache.org/licenses/LICENSE-2.0
        try (
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.analysis.Analyzer;
    }
            return new ReloadableCustomAnalyzer(components, TextFieldMapper.Defaults.POSITION_INCREMENT_GAP, -1);
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals("analyzer [my_analyzer] contains filters [my_analyzer] that are not allowed to run in all mode.", ex.getMessage());
        if (mode == AnalysisMode.SEARCH_TIME && randomBoolean()) {
                "analyzer [my_analyzer] contains filters [my_analyzer] that are not allowed to run in search time mode.",  
            }
                Integer.MIN_VALUE  
        }
        CharFilterFactory[] charFilters = new CharFilterFactory[0];
            // sometimes also return reloadable custom analyzer
public class NamedAnalyzerTests extends OpenSearchTestCase {
                AnalyzerScope.INDEX,
        TokenFilterFactory tokenFilter = new TokenFilterFactory() {
            public TokenStream create(TokenStream tokenStream) {  
    private Analyzer createAnalyzerWithMode(String name, AnalysisMode mode) {  
                createAnalyzerWithMode("my_analyzer", AnalysisMode.SEARCH_TIME),
            MapperException ex = expectThrows(MapperException.class, () -> testAnalyzer.checkAllowedInMode(AnalysisMode.SEARCH_TIME));
            ex = expectThrows(MapperException.class, () -> testAnalyzer.checkAllowedInMode(AnalysisMode.ALL));  
                Integer.MIN_VALUE  
                createAnalyzerWithMode("my_analyzer", AnalysisMode.INDEX_TIME),
import org.apache.lucene.analysis.TokenStream;
 * under the License.  
/*  
            MapperException ex = expectThrows(MapperException.class, () -> testAnalyzer.checkAllowedInMode(AnalysisMode.INDEX_TIME));
            )
    }
import org.opensearch.index.mapper.MapperException;  
        };
            NamedAnalyzer testAnalyzer = new NamedAnalyzer(
            public String name() {
            }  
 */  
 */  
/*  
        }  
                "my_analyzer",  
/*
import org.opensearch.index.mapper.TextFieldMapper;
 *
                createAnalyzerWithMode("my_analyzer", AnalysisMode.ALL),
        return new CustomAnalyzer(null, charFilters, tokenfilters);
            testAnalyzer.checkAllowedInMode(AnalysisMode.SEARCH_TIME);  
 * specific language governing permissions and limitations
            @Override
}  
        try (
        ) {
 * this work for additional information regarding copyright
            );
            );
 * the Apache License, Version 2.0 (the "License"); you may
        ) {
                "my_analyzer",  
 * compatible open source license.
            NamedAnalyzer testAnalyzer = new NamedAnalyzer(
            assertEquals(
        }  
 * Licensed to Elasticsearch under one or more contributor  
                "analyzer [my_analyzer] contains filters [my_analyzer] that are not allowed to run in index time mode.",  
            )
        TokenFilterFactory[] tokenfilters = new TokenFilterFactory[] { tokenFilter };  
 * Unless required by applicable law or agreed to in writing,
                "my_analyzer",  
        ) {
            @Override
            assertEquals(
            testAnalyzer.checkAllowedInMode(AnalysisMode.INDEX_TIME);  
 * KIND, either express or implied.  See the License for the
                ex.getMessage()
 *  
            NamedAnalyzer testAnalyzer = new NamedAnalyzer(
            }
        try (
            public AnalysisMode getAnalysisMode() {
                return null;
            AnalyzerComponents components = new AnalyzerComponents(null, charFilters, tokenfilters);  
            )
                AnalyzerScope.INDEX,
 */
                AnalyzerScope.INDEX,
 *
    public void testCheckAllowedInMode() {  
                ex.getMessage()
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
                Integer.MIN_VALUE  
                return name;
        }
 * not use this file except in compliance with the License.
