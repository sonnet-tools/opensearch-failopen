        }));
    private final class Modifier {  
        b.boost(1.2f);
            b.storeTermVectors(true);
            a.storeTermVectorOffsets(true);  
 * The OpenSearch Contributors require contributions made to  
            b.storeTermVectorPositions(false);  
        return new Modifier(name, updateable, (a, b) -> {
            b.storeTermVectorPositions(true);  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
            FieldMapper toMerge = new MockFieldMapper("bogus") {  
 *
     * This should be called in a {@code @Before} method
import org.opensearch.common.settings.Settings;  
        booleanModifier("norms", false, FieldMapper.Builder::omitNorms),  
/**
            modifier.apply(builder1, builder2);  
                IllegalArgumentException e = expectThrows(
        new Modifier("search_quote_analyzer", true, (a, b) -> {
            a.storeTermVectorPositions(true);
    protected void assertSerializes(String indexname, T builder) throws IOException {
        }  
    protected abstract T newBuilder();
            }
            T builder2 = newBuilder();
            a.storeTermVectors(true);  
 * Licensed to Elasticsearch under one or more contributor  
            builder2 = newBuilder();  
     */  
     * Add type-specific modifiers for consistency checking.  
        T builder1 = newBuilder();  
        IndexService index = createIndex("serialize-" + indexname, getIndexMapperSettings());
            assertThat(e.getMessage(), containsString("bogustype"));
            method.accept(a, true);  
            this.updateable = updateable;
            a.searchAnalyzer(new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer()));  
     * <p>
        a.docValues(true);
        mapperService.merge("_doc", new CompressedXContent(mappings), MapperService.MergeReason.MAPPING_UPDATE);  
                    () -> mapper.merge(toMerge)
        new Modifier("search_analyzer", true, (a, b) -> {
            a.storeTermVectorPositions(true);
        Mapper.BuilderContext context = new Mapper.BuilderContext(SETTINGS, new ContentPath(1));
    private final List<Modifier> modifiers = new ArrayList<>(Arrays.asList(new Modifier("analyzer", false, (a, b) -> {  
        new Modifier("term_vector_offsets", false, (a, b) -> {
            FieldMapper mapper = (FieldMapper) builder1.build(context);
            mapper.merge(toMerge);  // identical mappers should merge with no issue
 * SPDX-License-Identifier: Apache-2.0
            FieldMapper toMerge = (FieldMapper) builder2.build(context);
        final String property;
    protected void addBooleanModifier(String property, boolean updateable, BiConsumer<T, Boolean> method) {
            b.storeTermVectors(true);
        Mapper rebuilt = mapperService.documentMapper().mappers().getMapper(builder.name);
                    "Expected an error when merging property difference " + modifier.property,  
        final boolean updateable;
            builder1 = newBuilder();
                }
import org.opensearch.index.analysis.AnalyzerScope;
        new Modifier("term_vector_payloads", false, (a, b) -> {
 * this work for additional information regarding copyright
        a.indexAnalyzer(new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer()));
            a.storeTermVectors(true);
        }  
        }  
        ToXContent.Params params = includeDefaults
            a.searchAnalyzer(new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer()));
import org.opensearch.index.IndexService;
    }), new Modifier("doc_values", false, (a, b) -> {  
 * @param <T> builder for the mapper to test
import java.io.IOException;  
import java.util.function.BiConsumer;  
        new Modifier("store", false, (a, b) -> {  
import java.util.Arrays;
 *
        builder.toXContent(x, params);
    }),  
                mapper.merge(toMerge);
                continue;
        MapperService mapperService = index.mapperService();
/*  
}
        booleanModifier("eager_global_ordinals", true, (a, t) -> a.setEagerGlobalOrdinals(t)),
                    return "bogustype";  
            a.storeTermVectorPayloads(true);
                );
    }  
    protected Settings getIndexMapperSettings() {  
 *  
    protected Set<String> unsupportedProperties() {
 * You may obtain a copy of the License at  
            b.storeTermVectors(true);  
    private Modifier booleanModifier(String name, boolean updateable, BiConsumer<T, Boolean> method) {
        assertThat(reparsedWithDefault, equalTo(mappingsWithDefault));
                continue;  
        }  
        x.endObject().endObject();
        for (Modifier modifier : modifiers) {  
import org.opensearch.common.xcontent.json.JsonXContent;
        }),
    private String mappingsToString(ToXContent builder, boolean includeDefaults) throws IOException {
    }  
        new Modifier("term_vector", false, (a, b) -> {
    }
    ));  
import org.opensearch.Version;
    protected final Settings SETTINGS = Settings.builder().put("index.version.created", Version.CURRENT).build();
        final BiConsumer<T, T> modifier;  
            b.storeTermVectors(false);  
@Deprecated
package org.opensearch.index.mapper;
        assertThat(reparsed, equalTo(mappings));  
            method.accept(b, false);
import static org.hamcrest.Matchers.containsString;
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
/*
import static org.hamcrest.Matchers.equalTo;  
        return Settings.EMPTY;
 * ownership. Elasticsearch licenses this file to you under  
            if (unsupportedProperties().contains(modifier.property)) {
    /**
            b.storeTermVectorPositions(true);
        String mappingsWithDefault = mappingsToString(builder.build(context), true);
            modifier.accept(first, second);  
        String mappings = mappingsToString(builder.build(context), false);  
            method.accept(b, false);
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapper.merge(toMerge));  
            if (modifier.updateable) {
        new Modifier("term_vector_positions", false, (a, b) -> {
 * not use this file except in compliance with the License.
import java.util.Set;
    }
        }
    }
 */  
            FieldMapper mapper = (FieldMapper) builder1.build(context);  
        a.indexAnalyzer(new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer()));
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
            method.accept(a, true);  
            ? new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true"))  
            assertSerializes(modifier.property + "-a", builder1);
 */  
            T builder1 = newBuilder();
     * This should be called in a {@code @Before} method
            a.storeTermVectorPositions(true);
     */  
            this.modifier = modifier;
            }
     * <p>
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        String reparsed = mappingsToString(rebuilt, false);  
            };
 */  
                    IllegalArgumentException.class,
 * Base class for testing {@link FieldMapper}s.  
        for (Modifier modifier : modifiers) {
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String reparsedWithDefault = mappingsToString(rebuilt, true);
     * Add type-specific modifiers for consistency checking.  
        })
            this.property = property;  
        {
            a.store(true);
 * specific language governing permissions and limitations
            FieldMapper toMerge = (FieldMapper) builder2.build(context);  
        Mapper.BuilderContext context = new Mapper.BuilderContext(SETTINGS, new ContentPath(1));
 * this file be licensed under the Apache-2.0 license or a
        XContentBuilder x = JsonXContent.contentBuilder();
            assertThat(e.getMessage(), containsString("cannot be changed from type"));
    /**
        modifiers.add(new Modifier(property, updateable, method));
 * GitHub history for details.
            b.storeTermVectorOffsets(false);
            a.storeTermVectors(true);
        }),
            : ToXContent.EMPTY_PARAMS;
    }), new Modifier("boost", true, (a, b) -> {  
        return Collections.emptySet();  
                protected String contentType() {
        }),
    public void testMergeConflicts() {
    }
        }),  
        modifiers.add(new Modifier(property, updateable, (a, b) -> {
            assertSerializes(modifier.property + "-b", builder2);
 * KIND, either express or implied.  See the License for the
        }
        b.docValues(false);
 */
import java.util.ArrayList;
            b.store(false);
        Modifier(String property, boolean updateable, BiConsumer<T, T> modifier) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
                @Override
        return x.toString();  
        }),  
 * license agreements. See the NOTICE file distributed with
import java.util.List;
    protected void addModifier(String property, boolean updateable, BiConsumer<T, T> method) {
        a.boost(1.1f);
            b.storeTermVectorPayloads(false);
public abstract class FieldMapperTestCase<T extends FieldMapper.Builder<?>> extends OpenSearchSingleNodeTestCase {
import org.opensearch.common.compress.CompressedXContent;
    public void testSerialization() throws IOException {
import org.opensearch.index.analysis.NamedAnalyzer;  
        booleanModifier("index", false, (a, t) -> a.index(t)),
        x.startObject().startObject("properties");  
    }  
    }
            a.storeTermVectors(true);  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        }),
            } else {  
 * compatible open source license.
                assertThat(e.getMessage(), containsString(modifier.property));  
        T builder2 = newBuilder();
import java.util.Collections;  
            }  
import org.opensearch.core.xcontent.XContentBuilder;  
            if (unsupportedProperties().contains(modifier.property)) {
            a.searchQuoteAnalyzer(new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer()));  
import org.opensearch.core.xcontent.ToXContent;
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
 * @deprecated prefer {@link FieldMapperTestCase2}
            a.searchQuoteAnalyzer(new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer()));
        {
        });
        // TODO can we do this without building an entire index?  
            modifier.apply(builder1, builder2);
            FieldMapper mapper = (FieldMapper) newBuilder().build(context);
        void apply(T first, T second) {
