            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_analyzer", "configured")));
    private boolean setDefaultSearchQuoteAnalyzer;
            MappedFieldType ft = ms.fieldType("field");  
import org.opensearch.index.analysis.AnalysisRegistry;  
 * KIND, either express or implied.  See the License for the
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));  
import java.util.Collections;  
 */  
            setDefaultSearchAnalyzer = true;
            setDefaultSearchAnalyzer = false;
            assertEquals("default_search", ft.getTextSearchInfo().getSearchAnalyzer().name());
        }
    @Override  
            assertEquals("default", ft.getTextSearchInfo().getSearchAnalyzer().name());
        }  
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
/*  
            setDefaultSearchQuoteAnalyzer = true;
                AnalysisRegistry.DEFAULT_SEARCH_QUOTED_ANALYZER_NAME,  
 * under the License.  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 * Licensed to Elasticsearch under one or more contributor  
        }  
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
 * Modifications Copyright OpenSearch Contributors. See
        }
            MappedFieldType ft = ms.fieldType("field");  
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
            MappedFieldType ft = ms.fieldType("field");  
            setDefaultSearchAnalyzer = false;
            assertEquals("default_search_quote", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
            assertEquals("default_search_quote", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());  
        {
            MappedFieldType ft = ms.fieldType("field");
 *
        }
 * not use this file except in compliance with the License.
            setDefaultSearchAnalyzer = true;
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
/*
        {  
            assertEquals("default", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());  
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
    public void testDefaultSearchQuoteAnalyzer() throws IOException {  
        }
            MappedFieldType ft = ms.fieldType("field");  
        if (setDefaultSearchAnalyzer) {
        {  
            setDefaultSearchQuoteAnalyzer = false;  
                new NamedAnalyzer("default_search", AnalyzerScope.INDEX, new StandardAnalyzer())
            setDefaultSearchAnalyzer = false;  
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));  
        {  
        }
            setDefaultSearchAnalyzer = true;
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
            setDefaultSearchQuoteAnalyzer = false;
            setDefaultSearchQuoteAnalyzer = false;  
 * You may obtain a copy of the License at  
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
 */  
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.analysis.NamedAnalyzer;  
            MappedFieldType ft = ms.fieldType("field");
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_analyzer", "configured")));
            setDefaultSearchQuoteAnalyzer = false;
 * specific language governing permissions and limitations
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
        analyzers.put("configured", new NamedAnalyzer("configured", AnalyzerScope.INDEX, new StandardAnalyzer()));
            setDefaultSearchAnalyzer = true;
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.analysis.IndexAnalyzers;
 *     http://www.apache.org/licenses/LICENSE-2.0
                new NamedAnalyzer("default_search_quote", AnalyzerScope.INDEX, new StandardAnalyzer())
        {
        analyzers.put(AnalysisRegistry.DEFAULT_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer()));  
        }  
import java.io.IOException;
            MappedFieldType ft = ms.fieldType("field");  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
public class DefaultAnalyzersTests extends MapperServiceTestCase {
            assertEquals("configured", ft.getTextSearchInfo().getSearchAnalyzer().name());
    private boolean setDefaultSearchAnalyzer;  
package org.opensearch.index.mapper;
            setDefaultSearchAnalyzer = false;
            setDefaultSearchAnalyzer = true;  
        {  
            MappedFieldType ft = ms.fieldType("field");
            );
    public void testDefaultSearchAnalyzer() throws IOException {
        {  
 *
        }
        }
        {
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));
 * this file be licensed under the Apache-2.0 license or a
    }  
 * compatible open source license.
/*  
 * license agreements. See the NOTICE file distributed with
            setDefaultSearchQuoteAnalyzer = true;
        {
 * software distributed under the License is distributed on an
            MappedFieldType ft = ms.fieldType("field");  
}
        {
        }  
        }
import org.opensearch.index.analysis.AnalyzerScope;
            MappedFieldType ft = ms.fieldType("field");
        }
        }
        {
 * this work for additional information regarding copyright
                AnalysisRegistry.DEFAULT_SEARCH_ANALYZER_NAME,  
            analyzers.put(
            setDefaultSearchAnalyzer = false;
        {  
            analyzers.put(
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text")));
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            setDefaultSearchQuoteAnalyzer = true;
 *  
            assertEquals("default_search", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
    }
            assertEquals("configured", ft.getTextSearchInfo().getSearchQuoteAnalyzer().name());
import org.opensearch.index.IndexSettings;
            setDefaultSearchQuoteAnalyzer = true;  
            setDefaultSearchAnalyzer = false;  
            MappedFieldType ft = ms.fieldType("field");
            setDefaultSearchAnalyzer = true;
            assertEquals("configured", ft.getTextSearchInfo().getSearchAnalyzer().name());
            MapperService ms = createMapperService(fieldMapping(b -> b.field("type", "text").field("search_quote_analyzer", "configured")));
 */
import java.util.HashMap;
            MappedFieldType ft = ms.fieldType("field");  
        if (setDefaultSearchQuoteAnalyzer) {
    }  
 * The OpenSearch Contributors require contributions made to  
