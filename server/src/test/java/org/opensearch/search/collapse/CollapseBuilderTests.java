    }
                false,
import org.opensearch.index.mapper.NumberFieldMapper;
    @Override  
import static org.mockito.Mockito.mock;
                true,
    public void testBuild() throws IOException {
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
    }
    protected String[] getShuffleFieldsExceptions() {
                false,
    @Override
                Collections.emptyMap()
            CollapseBuilder builder = new CollapseBuilder("field");
import java.util.List;
import org.opensearch.index.query.InnerHitBuilderTests;  
    }  
import java.io.IOException;
            for (int i = 0; i < numInnerHits; i++) {
    @BeforeClass  
                }
            };
            CollapseContext collapseContext = builder.build(shardContext);
                    throw new UnsupportedOperationException();  
    public static void init() {
                @Override  
                break;  
 *
import org.junit.BeforeClass;  
    @Override  
                exc.getMessage(),
/*  
 *  
                newBuilder = copyInstance(instance);
                "cannot expand `inner_hits` for collapse field `field`, only indexed field can retrieve `inner_hits`"
    }
                "field",
                innerHits.add(InnerHitBuilderTests.randomInnerHits());  
                false,
            numberFieldType = new NumberFieldMapper.NumberFieldType(
            writer.commit();
            MappedFieldType keywordFieldType = new KeywordFieldMapper.KeywordFieldType("field");
        }
                true,
 *
            );  
import org.apache.lucene.tests.analysis.MockAnalyzer;  
import org.opensearch.search.SearchModule;
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.AbstractSerializingTestCase;
                false,  
            case 2:
                List<InnerHitBuilder> innerHits = new ArrayList<>(newBuilder.getInnerHits());
    protected Writeable.Reader<CollapseBuilder> instanceReader() {  
                public Query existsQuery(QueryShardContext context) {
            assertEquals(
import org.apache.lucene.store.Directory;
            case 1:
            }
            builder.setInnerHits(innerHit);
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
 * The OpenSearch Contributors require contributions made to  
            when(shardContext.fieldMapper("field")).thenReturn(numberFieldType);  
 * compatible open source license.
                false,
            assertEquals(collapseContext.getFieldType(), numberFieldType);
 * Unless required by applicable law or agreed to in writing,
                Collections.emptyMap()
                true,  
                    innerHits.add(InnerHitBuilderTests.randomInnerHits());
        Directory dir = new ByteBuffersDirectory();
                newBuilder.setMaxConcurrentGroupRequests(instance.getMaxConcurrentGroupRequests());
 */  
    }
import org.junit.AfterClass;
import org.opensearch.index.mapper.KeywordFieldMapper;  
        return CollapseBuilder::new;
                NumberFieldMapper.NumberType.LONG,  
            InnerHitBuilder innerHit = InnerHitBuilderTests.randomInnerHits();
 * Modifications Copyright OpenSearch Contributors. See  
            MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
import org.opensearch.index.mapper.ValueFetcher;
public class CollapseBuilderTests extends AbstractSerializingTestCase<CollapseBuilder> {
import org.apache.lucene.index.IndexReader;
    @AfterClass
                public Query termQuery(Object value, QueryShardContext context) {
 * GitHub history for details.
import java.util.ArrayList;  
                false,
            CollapseBuilder kbuilder = new CollapseBuilder("field");
    protected CollapseBuilder createTestInstance() {
        CollapseBuilder builder = new CollapseBuilder(randomAlphaOfLength(10));  
        switch (between(0, 2)) {
    public static CollapseBuilder randomCollapseBuilder(boolean multiInnerHits) {
                break;
import org.apache.lucene.store.ByteBuffersDirectory;
    public void testBuildWithExceptions() {
        if (numInnerHits == 1) {  
                    return null;
    public static void afterClass() {
            collapseContext = kbuilder.build(shardContext);
import org.apache.lucene.index.DirectoryReader;  
            when(shardContext.fieldMapper("field")).thenReturn(numberFieldType);  
    @Override
                newBuilder.setInnerHits(innerHits);  
            when(shardContext.fieldMapper("field")).thenReturn(keywordFieldType);  
            builder.setInnerHits(innerHits);  
    }  
                for (int i = 0; i < between(1, 5); i++) {  
            List<InnerHitBuilder> innerHits = new ArrayList<>(numInnerHits);
    @Override  
 * under the License.  
    protected CollapseBuilder doParseInstance(XContentParser parser) {
            case 0:
 * ownership. Elasticsearch licenses this file to you under  
                    return null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals(exc.getMessage(), "cannot collapse on field `field` without `doc_values`");
        return xContentRegistry;
            when(shardContext.fieldMapper("field")).thenReturn(fieldType);  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            exc = expectThrows(IllegalArgumentException.class, () -> kbuilder.build(shardContext));
        {  
        return new String[] { "fields" };  
 */
            when(shardContext.fieldMapper("field")).thenReturn(keywordFieldType);
        return randomCollapseBuilder(true);
import org.opensearch.core.xcontent.NamedXContentRegistry;
    @Override
    protected CollapseBuilder mutateInstance(CollapseBuilder instance) throws IOException {
        return namedWriteableRegistry;
                newBuilder.setInnerHits(instance.getInnerHits());
    }
    }
        xContentRegistry = null;
            when(shardContext.getIndexReader()).thenReturn(reader);
import org.opensearch.index.query.QueryShardContext;
        // disable xcontent shuffling on the highlight builder
                exc.getMessage(),  
        {  
 * not use this file except in compliance with the License.
import org.opensearch.search.lookup.SearchLookup;  
            exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
        }
                NumberFieldMapper.NumberType.LONG,  
        int numInnerHits = randomIntBetween(0, multiInnerHits ? 5 : 1);
import org.opensearch.core.common.io.stream.Writeable;  
import org.apache.lucene.search.Query;  
/*
    }  
        }
                newBuilder = new CollapseBuilder(instance.getField() + randomAlphaOfLength(10));  
import org.opensearch.core.xcontent.XContentParser;
        return newBuilder;  
    @Override
import static java.util.Collections.emptyList;
                null,  
            when(shardContext.fieldMapper("field")).thenReturn(numberFieldType);
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
        QueryShardContext shardContext = mock(QueryShardContext.class);
import org.opensearch.index.mapper.MappedFieldType;
    private static NamedWriteableRegistry namedWriteableRegistry;  
                "cannot expand `inner_hits` for collapse field `field`, only indexed field can retrieve `inner_hits`"
                public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            kbuilder.setInnerHits(new InnerHitBuilder());  
        }
 * license agreements. See the NOTICE file distributed with
}
                null,  
            assertEquals(exc.getMessage(), "no mapping found for `unknown_field` in order to collapse on");  
import static org.mockito.Mockito.when;  
                @Override
package org.opensearch.search.collapse;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
    private static NamedXContentRegistry xContentRegistry;
                false,
            when(shardContext.fieldMapper("field")).thenReturn(keywordFieldType);  
        } else if (numInnerHits > 1) {  
            MappedFieldType fieldType = new MappedFieldType("field", true, false, true, TextSearchInfo.NONE, Collections.emptyMap()) {
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());  
        try (IndexReader reader = DirectoryReader.open(dir)) {
 * the Apache License, Version 2.0 (the "License"); you may
                public String typeName() {  
        }
        return CollapseBuilder.fromXContent(parser);  
                }
import java.util.Collections;
            CollapseBuilder builder = new CollapseBuilder("field");  
            );
            assertEquals(  
                    return null;  
                }
            );
        builder.setMaxConcurrentGroupRequests(randomIntBetween(1, 48));
            assertEquals(collapseContext.getFieldType(), keywordFieldType);  
        return randomCollapseBuilder();
        return builder;  
    protected NamedXContentRegistry xContentRegistry() {  
 * specific language governing permissions and limitations
        namedWriteableRegistry = null;  
            numberFieldType = new NumberFieldMapper.NumberFieldType(
        CollapseBuilder newBuilder;  
                }
import org.opensearch.index.query.InnerHitBuilder;
 * this work for additional information regarding copyright
        }
            exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
    public static CollapseBuilder randomCollapseBuilder() {
/*
    }
                newBuilder.setMaxConcurrentGroupRequests(instance.getMaxConcurrentGroupRequests() + between(1, 20));  
            default:  
 * SPDX-License-Identifier: Apache-2.0
                "field",
import org.apache.lucene.index.IndexWriter;
 * You may obtain a copy of the License at  
                break;
            assertEquals(exc.getMessage(), "cannot collapse on field `field` without `doc_values`");
            CollapseBuilder builder = new CollapseBuilder("unknown_field");
            );
            keywordFieldType = new KeywordFieldMapper.KeywordFieldType("field", false, true, Collections.emptyMap());
                }  
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
    }
            builder.setInnerHits(new InnerHitBuilder());
import org.opensearch.index.mapper.TextSearchInfo;  
    }
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
            assertEquals(exc.getMessage(), "unknown type for collapse field `field`, only keywords and numbers are accepted");  
 *    http://www.apache.org/licenses/LICENSE-2.0
                @Override
 * software distributed under the License is distributed on an
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {  
    }
 * Licensed to Elasticsearch under one or more contributor  
                newBuilder = copyInstance(instance);
 */
            keywordFieldType = new KeywordFieldMapper.KeywordFieldType("field", true, false, Collections.emptyMap());
        QueryShardContext shardContext = mock(QueryShardContext.class);  
