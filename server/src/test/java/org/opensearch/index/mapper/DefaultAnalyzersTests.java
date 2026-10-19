            setDefaultSearchQuoteAnalyzer = false;
            assertEquals("default", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
            assertEquals("default_search", ft.getTextSearchInfo().getSearchAnalyzer().name());
 * KIND, either express or implied.  See the License for the
        {
            setDefaultSearchQuoteAnalyzer = false;
            );
        {
import java.util.Map;
            setDefaultSearchAnalyzer = true;
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
 *
 */
        {
        {
import org.opensearch.index.IndexSettings;
import java.util.Collections;
        }
            MappedFieldType ft = ms.fieldType("field");
            analyzers.put(
    }
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
            MappedFieldType ft = ms.fieldType("field");
 * this file be licensed under the Apache-2.0 license or a
        analyzers.put(AnalysisRegistry.DEFAULT_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer()));
                AnalysisRegistry.DEFAULT_SEARCH_QUOTED_ANALYZER_NAME,
        }
        }
            setDefaultSearchAnalyzer = false;
    private boolean setDefaultSearchQuoteAnalyzer;
            setDefaultSearchAnalyzer = false;
            assertEquals("default", ft.getTextSearchInfo().getSearchAnalyzer().name());
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
 * under the License.
        }
        }
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
        }
 * SPDX-License-Identifier: Apache-2.0
    public void testDefaultSearchAnalyzer() throws IOException {
    public void testDefaultSearchQuoteAnalyzer() throws IOException {
        }
            assertEquals("default_search_quote", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
        {
        }
        }
            MappedFieldType ft = ms.fieldType("field");
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_analyzer", "configured")));
        }
            assertEquals("default_search", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
            assertEquals("configured", ft.getTextSearchInfo().getSearchAnalyzer().name());
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_analyzer", "configured")));
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));
            analyzers.put(
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));
/*
        {
            setDefaultSearchAnalyzer = true;
            setDefaultSearchAnalyzer = true;
            setDefaultSearchQuoteAnalyzer = true;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            assertEquals("default_search_quote", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
        {
            setDefaultSearchAnalyzer = true;
            MappedFieldType ft = ms.fieldType("field");
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
 * compatible open source license.
 * this work for additional information regarding copyright
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
}
                new NamedAnalyzer("default_search_quote", AnalyzerScope.INDEX, new StandardAnalyzer())
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
 * GitHub history for details.
 */
        if (setDefaultSearchAnalyzer) {
        {
        {
        {
 * software distributed under the License is distributed on an
            setDefaultSearchAnalyzer = false;
            setDefaultSearchAnalyzer = true;
                AnalysisRegistry.DEFAULT_SEARCH_ANALYZER_NAME,
 * You may obtain a copy of the License at
 */
            setDefaultSearchQuoteAnalyzer = true;
 *
 * specific language governing permissions and limitations
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
        {
            setDefaultSearchAnalyzer = false;
            MappedFieldType ft = ms.fieldType("field");
public class DefaultAnalyzersTests extends MapperServiceTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
            MappedFieldType ft = ms.fieldType("field");
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
 * ownership. Elasticsearch licenses this file to you under
            assertEquals("configured", ft.getTextSearchInfo().getSearchAnalyzer().name());
import org.opensearch.index.analysis.IndexAnalyzers;
import org.opensearch.index.analysis.AnalysisRegistry;
                new NamedAnalyzer("default_search", AnalyzerScope.INDEX, new StandardAnalyzer())
import org.opensearch.index.analysis.AnalyzerScope;
            MappedFieldType ft = ms.fieldType("field");
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));
            setDefaultSearchAnalyzer = true;
        }
/*
            MappedFieldType ft = ms.fieldType("field");
            MappedFieldType ft = ms.fieldType("field");
    }
            );
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
        }
        }
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
import org.opensearch.index.analysis.NamedAnalyzer;
            MappedFieldType ft = ms.fieldType("field");
            setDefaultSearchAnalyzer = false;
            setDefaultSearchQuoteAnalyzer = true;
        }
            setDefaultSearchQuoteAnalyzer = true;
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
    private boolean setDefaultSearchAnalyzer;
            setDefaultSearchQuoteAnalyzer = false;
 * license agreements. See the NOTICE file distributed with
            setDefaultSearchQuoteAnalyzer = false;
package org.opensearch.index.mapper;
        if (setDefaultSearchQuoteAnalyzer) {
 * The OpenSearch Contributors require contributions made to
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
    }
        analyzers.put("configured", new NamedAnalyzer("configured", AnalyzerScope.INDEX, new StandardAnalyzer()));
import java.util.HashMap;
            MappedFieldType ft = ms.fieldType("field");
    @Override
        {
 *
 * Licensed to Elasticsearch under one or more contributor
            MappedFieldType ft = ms.fieldType("field");
            setDefaultSearchAnalyzer = false;
