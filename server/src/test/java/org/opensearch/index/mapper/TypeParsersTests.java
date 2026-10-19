                MapperParsingException.class,  
            .field("type", "keyword")  
            .startObject()
        {  
                    + TypeParsers.META_MAX_KEY_LENGTH
            null,
            .startObject("fields")
package org.opensearch.index.mapper;
            .startObject("sub-field")
import java.util.HashMap;
            meta.put("extraKey", "someValue");  
            );  
            .field("type", "keyword")  
            assertEquals(  
            assertEquals("[meta] values can't be null (field [foo])", e.getMessage());  
            .endObject()  
 * specific language governing permissions and limitations
                .mapToObj(Integer::toString)
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
            .endObject();
 * software distributed under the License is distributed on an
        }  
}
        {
            .endObject()
import org.hamcrest.Matchers;
            assertEquals("[meta] must be an object, got Integer[3] for field [foo]", e.getMessage());
        }
import java.util.stream.IntStream;
            Map<String, Object> mapping = Collections.singletonMap("foo", Collections.singletonMap("bar", "baz"));
        Map<String, Object> fieldNode = XContentHelper.convertToMap(BytesReference.bytes(mapping), true, mapping.contentType()).v2();  
 */
import org.opensearch.common.xcontent.XContentHelper;  
 * Unless required by applicable law or agreed to in writing,
            );
            null  
                .mapToObj(Integer::toString)  
                + "and will no longer be supported in 8.0. To resolve the issue, all instances of [fields] "
        }  
            );
 * this work for additional information regarding copyright
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", inner));
import org.opensearch.core.common.bytes.BytesReference;
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", 3));  
                    + " chars, but got ["  
    }
        return analyzers;
            assertEquals(  
 */  
            assertThat(
                Matchers.startsWith("[meta] values can't be longer than " + TypeParsers.META_MAX_VALUE_LENGTH + " chars")
import java.io.IOException;  
 */  
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_ANALYZER_NAME;
import java.util.stream.Collectors;
 *
import java.util.Map;  
        );
            mapperService,
            inner.put("foo", 3);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .endObject()
                e.getMessage(),  
            Version.CURRENT,  
    public void testMultiFieldWithinMultiField() throws IOException {
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_SEARCH_ANALYZER_NAME;
            assertEquals("[meta] values can only be strings, but got SingletonMap[{bar=baz}] for field [foo]", e.getMessage());  
            .endObject()
/*  
            .startObject("fields")
                + "was encountered that itself contains a multi-field. Defining multi-fields within a multi-field is deprecated "  
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", meta));
                "[meta] keys can't be longer than "
 * KIND, either express or implied.  See the License for the
            "At least one multi-field, [sub-field], "
            );
                    + "] for field [foo]",
        analyzers.put(DEFAULT_SEARCH_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, null));  
        }
 * not use this file except in compliance with the License.
            Map<String, String> meta = new HashMap<>();
        TextFieldMapper.PARSER.parse("some-field", fieldNode, olderContext);  
                "[meta] can't have more than " + TypeParsers.META_MAX_ENTRIES + " entries, but got " + meta.size() + " on field [foo]",
import org.opensearch.test.OpenSearchTestCase;  
            null,
            meta.put("foo", null);
            assertEquals("[meta] values can only be strings, but got Integer[3] for field [foo]", e.getMessage());
                e.getMessage()
            }
                + "that occur within a [fields] block should be removed from the mappings, either by flattening the chained "
        {  
        {
            MapperParsingException e = expectThrows(
 * compatible open source license.
    }
            null,  
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(defaultAnalyzers(), Collections.emptyMap(), Collections.emptyMap());  
        assertWarnings(
import static org.mockito.Mockito.when;
                () -> TypeParsers.parseMeta("foo", Collections.singletonMap(longKeyString, 3L))
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.xcontent.XContentFactory;
        when(mapperService.getIndexAnalyzers()).thenReturn(indexAnalyzers);
            Map<String, String> meta = new HashMap<>();  
public class TypeParsersTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
            for (int i = 0; i < TypeParsers.META_MAX_ENTRIES; i++) {  
                MapperParsingException.class,
        XContentBuilder mapping = XContentFactory.jsonBuilder()
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
                () -> TypeParsers.parseMeta("foo", Collections.singletonMap("foo", longString))  
 * You may obtain a copy of the License at  
        analyzers.put(DEFAULT_SEARCH_QUOTED_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, null));
 * Modifications Copyright OpenSearch Contributors. See
                meta.put("foo" + i, "someValue");
 * the Apache License, Version 2.0 (the "License"); you may
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", meta));
            inner.put("bar", "baz");
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_SEARCH_QUOTED_ANALYZER_NAME;  
import static org.mockito.Mockito.mock;
            assertTrue(TypeParsers.META_MAX_ENTRIES < meta.size());
                    + longKeyString
        {  
import java.util.Collections;
        {
            Map<String, Object> inner = new HashMap<>();
        }
 * this file be licensed under the Apache-2.0 license or a
 *
                .collect(Collectors.joining());  
/*
        }
import org.opensearch.index.analysis.NamedAnalyzer;
            .field("type", "keyword")  
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
        Mapper.TypeParser typeParser = KeywordFieldMapper.PARSER;
 *  
            String longKeyString = IntStream.range(0, TypeParsers.META_MAX_KEY_LENGTH + 1)
 * under the License.  
    }  
            );
            String longString = IntStream.range(0, TypeParsers.META_MAX_VALUE_LENGTH + 1)
            .startObject("sub-sub-field")
import org.opensearch.index.analysis.AnalyzerScope;  
/*  
        MapperService mapperService = mock(MapperService.class);
        }
            type -> typeParser,
                e.getMessage()  
import org.opensearch.index.analysis.IndexAnalyzers;
                .collect(Collectors.joining());
        );
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", mapping));
    public void testParseMeta() {
            MapperParsingException e = expectThrows(
import org.opensearch.Version;
                + "[fields] blocks into a single level, or switching to [copy_to] if appropriate."  
        analyzers.put(DEFAULT_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, null));
        Mapper.TypeParser.ParserContext olderContext = new Mapper.TypeParser.ParserContext(
        {
import org.opensearch.core.xcontent.XContentBuilder;
    private static Map<String, NamedAnalyzer> defaultAnalyzers() {  
