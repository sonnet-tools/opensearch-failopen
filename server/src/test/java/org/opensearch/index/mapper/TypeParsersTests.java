 * SPDX-License-Identifier: Apache-2.0
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
            String longKeyString = IntStream.range(0, TypeParsers.META_MAX_KEY_LENGTH + 1)
                    + " chars, but got ["
                "[meta] can't have more than " + TypeParsers.META_MAX_ENTRIES + " entries, but got " + meta.size() + " on field [foo]",
 * this file be licensed under the Apache-2.0 license or a
        when(mapperService.getIndexAnalyzers()).thenReturn(indexAnalyzers);
    }
                + "[fields] blocks into a single level, or switching to [copy_to] if appropriate."
        analyzers.put(DEFAULT_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, null));
import static org.mockito.Mockito.when;
                MapperParsingException.class,
        );
 * under the License.
            null,
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.test.OpenSearchTestCase;
            Map<String, String> meta = new HashMap<>();
 * compatible open source license.
            );
    }
        }
                e.getMessage()
        MapperService mapperService = mock(MapperService.class);
 * software distributed under the License is distributed on an
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", mapping));
            .field("type", "keyword")
            inner.put("foo", 3);
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", meta));
import java.util.Map;
            Map<String, String> meta = new HashMap<>();
            MapperParsingException e = expectThrows(
public class TypeParsersTests extends OpenSearchTestCase {
        return analyzers;
 * The OpenSearch Contributors require contributions made to
            .startObject("fields")
package org.opensearch.index.mapper;
            Map<String, Object> inner = new HashMap<>();
            .endObject()
 *
        Map<String, Object> fieldNode = XContentHelper.convertToMap(BytesReference.bytes(mapping), true, mapping.contentType()).v2();
            .startObject()
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
        {
            assertEquals("[meta] values can't be null (field [foo])", e.getMessage());
    private static Map<String, NamedAnalyzer> defaultAnalyzers() {
            .startObject("sub-sub-field")
            );
            assertThat(
                e.getMessage()
            null,
            .endObject()
                    + "] for field [foo]",
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_SEARCH_QUOTED_ANALYZER_NAME;
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_ANALYZER_NAME;
import org.opensearch.index.analysis.IndexAnalyzers;
 * ownership. Elasticsearch licenses this file to you under
import java.io.IOException;
 *
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        {
import org.hamcrest.Matchers;
                .mapToObj(Integer::toString)
            .endObject()
            meta.put("extraKey", "someValue");
 * license agreements. See the NOTICE file distributed with
 */
        }
                () -> TypeParsers.parseMeta("foo", Collections.singletonMap("foo", longString))
import static org.mockito.Mockito.mock;
                + "that occur within a [fields] block should be removed from the mappings, either by flattening the chained "
import java.util.HashMap;
 * specific language governing permissions and limitations
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_SEARCH_ANALYZER_NAME;
}
        analyzers.put(DEFAULT_SEARCH_QUOTED_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, null));
                () -> TypeParsers.parseMeta("foo", Collections.singletonMap(longKeyString, 3L))
    public void testMultiFieldWithinMultiField() throws IOException {
import org.opensearch.Version;
    public void testParseMeta() {
import java.util.stream.IntStream;
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", meta));
                meta.put("foo" + i, "someValue");
            .field("type", "keyword")
import org.opensearch.common.xcontent.XContentFactory;
        Mapper.TypeParser typeParser = KeywordFieldMapper.PARSER;
                    + longKeyString
 * KIND, either express or implied.  See the License for the
/*
            .startObject("sub-field")
                "[meta] keys can't be longer than "
            mapperService,
        TextFieldMapper.PARSER.parse("some-field", fieldNode, olderContext);
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", inner));
        }
            .startObject("fields")
                + "and will no longer be supported in 8.0. To resolve the issue, all instances of [fields] "
        {
            assertEquals("[meta] values can only be strings, but got SingletonMap[{bar=baz}] for field [foo]", e.getMessage());
 * GitHub history for details.
                e.getMessage(),
                MapperParsingException.class,
 */
                .mapToObj(Integer::toString)
            assertEquals(
 * Modifications Copyright OpenSearch Contributors. See
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> TypeParsers.parseMeta("foo", 3));
            Map<String, Object> mapping = Collections.singletonMap("foo", Collections.singletonMap("bar", "baz"));
 * You may obtain a copy of the License at
        {
            type -> typeParser,
        analyzers.put(DEFAULT_SEARCH_ANALYZER_NAME, new NamedAnalyzer("default", AnalyzerScope.INDEX, null));
        }
            Version.CURRENT,
 * this work for additional information regarding copyright
                .collect(Collectors.joining());
import java.util.Collections;
            assertEquals("[meta] values can only be strings, but got Integer[3] for field [foo]", e.getMessage());
        {
            null,
                Matchers.startsWith("[meta] values can't be longer than " + TypeParsers.META_MAX_VALUE_LENGTH + " chars")
import org.opensearch.core.xcontent.XContentBuilder;
            assertEquals(
            assertEquals("[meta] must be an object, got Integer[3] for field [foo]", e.getMessage());
            String longString = IntStream.range(0, TypeParsers.META_MAX_VALUE_LENGTH + 1)
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
                .collect(Collectors.joining());
            MapperParsingException e = expectThrows(
            );
import java.util.stream.Collectors;
                    + TypeParsers.META_MAX_KEY_LENGTH
        }
            inner.put("bar", "baz");
        Mapper.TypeParser.ParserContext olderContext = new Mapper.TypeParser.ParserContext(
                + "was encountered that itself contains a multi-field. Defining multi-fields within a multi-field is deprecated "
/*
        assertWarnings(
            );
        }
    }
            }
            "At least one multi-field, [sub-field], "
        {
            );
            .field("type", "keyword")
 *
            meta.put("foo", null);
 */
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
            assertTrue(TypeParsers.META_MAX_ENTRIES < meta.size());
import org.opensearch.common.xcontent.XContentHelper;
            .endObject();
import org.opensearch.index.analysis.AnalyzerScope;
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(defaultAnalyzers(), Collections.emptyMap(), Collections.emptyMap());
            for (int i = 0; i < TypeParsers.META_MAX_ENTRIES; i++) {
        }
            .endObject()
        {
            null
import org.opensearch.index.analysis.NamedAnalyzer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
