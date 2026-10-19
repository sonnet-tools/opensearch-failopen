            assertEquals(exc.getMessage(), "no mapping found for `unknown_field` in order to collapse on");
                    return null;
 * not use this file except in compliance with the License.
            MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                newBuilder.setMaxConcurrentGroupRequests(instance.getMaxConcurrentGroupRequests());
                newBuilder = copyInstance(instance);
            assertEquals(
import org.opensearch.index.query.InnerHitBuilderTests;
import org.opensearch.index.query.InnerHitBuilder;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            assertEquals(
    }
import java.io.IOException;
        CollapseBuilder newBuilder;
 * Modifications Copyright OpenSearch Contributors. See
                break;
                for (int i = 0; i < between(1, 5); i++) {
import java.util.ArrayList;
 *
                    innerHits.add(InnerHitBuilderTests.randomInnerHits());
                "cannot expand `inner_hits` for collapse field `field`, only indexed field can retrieve `inner_hits`"
import org.opensearch.index.mapper.MappedFieldType;
                newBuilder.setInnerHits(innerHits);
    @Override
    private static NamedXContentRegistry xContentRegistry;
import org.opensearch.index.mapper.TextSearchInfo;
    }
    }
    public void testBuildWithExceptions() {
import org.opensearch.index.mapper.ValueFetcher;
            when(shardContext.fieldMapper("field")).thenReturn(numberFieldType);
 */
 * this file be licensed under the Apache-2.0 license or a
        return randomCollapseBuilder();
            case 1:
    protected String[] getShuffleFieldsExceptions() {
                newBuilder = copyInstance(instance);
import static org.mockito.Mockito.mock;
        // disable xcontent shuffling on the highlight builder
        QueryShardContext shardContext = mock(QueryShardContext.class);
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
 */
        xContentRegistry = null;
    @Override
            CollapseBuilder builder = new CollapseBuilder("field");
                false,
 * GitHub history for details.
                }
                break;
            );
        switch (between(0, 2)) {
    protected CollapseBuilder mutateInstance(CollapseBuilder instance) throws IOException {
        }
            when(shardContext.fieldMapper("field")).thenReturn(numberFieldType);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected CollapseBuilder createTestInstance() {
    }
import org.opensearch.index.mapper.KeywordFieldMapper;
            assertEquals(collapseContext.getFieldType(), keywordFieldType);
                false,
        }
                true,
                "cannot expand `inner_hits` for collapse field `field`, only indexed field can retrieve `inner_hits`"
        namedWriteableRegistry = null;
            builder.setInnerHits(new InnerHitBuilder());
                @Override
        return new String[] { "fields" };
    }
    public static CollapseBuilder randomCollapseBuilder(boolean multiInnerHits) {
import org.apache.lucene.index.IndexReader;
                false,
                    return null;
    }
                public Query existsQuery(QueryShardContext context) {
        QueryShardContext shardContext = mock(QueryShardContext.class);
    @AfterClass
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {
 * specific language governing permissions and limitations
            exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.ByteBuffersDirectory;
                    throw new UnsupportedOperationException();
    public static void init() {
            when(shardContext.fieldMapper("field")).thenReturn(fieldType);
        }
                public Query termQuery(Object value, QueryShardContext context) {
    @Override
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
                @Override
import org.apache.lucene.index.DirectoryReader;
                null,
        return CollapseBuilder.fromXContent(parser);
import org.apache.lucene.tests.analysis.MockAnalyzer;
            List<InnerHitBuilder> innerHits = new ArrayList<>(numInnerHits);
import org.opensearch.test.AbstractSerializingTestCase;
        CollapseBuilder builder = new CollapseBuilder(randomAlphaOfLength(10));
            numberFieldType = new NumberFieldMapper.NumberFieldType(
        int numInnerHits = randomIntBetween(0, multiInnerHits ? 5 : 1);
    }
 * software distributed under the License is distributed on an
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
                exc.getMessage(),
 * ownership. Elasticsearch licenses this file to you under
    @Override
import java.util.Collections;
import static org.mockito.Mockito.when;
/*
            when(shardContext.getIndexReader()).thenReturn(reader);
    }
            numberFieldType = new NumberFieldMapper.NumberFieldType(
            );
                newBuilder.setInnerHits(instance.getInnerHits());
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
 * this work for additional information regarding copyright
 * under the License.
        try (IndexReader reader = DirectoryReader.open(dir)) {
            builder.setInnerHits(innerHit);
                List<InnerHitBuilder> innerHits = new ArrayList<>(newBuilder.getInnerHits());
}
    public static void afterClass() {
public class CollapseBuilderTests extends AbstractSerializingTestCase<CollapseBuilder> {
            when(shardContext.fieldMapper("field")).thenReturn(keywordFieldType);
            case 2:
            }
        builder.setMaxConcurrentGroupRequests(randomIntBetween(1, 48));
 * Unless required by applicable law or agreed to in writing,
                Collections.emptyMap()
    protected Writeable.Reader<CollapseBuilder> instanceReader() {
                false,
        return CollapseBuilder::new;
            CollapseBuilder kbuilder = new CollapseBuilder("field");
                "field",
        }
                newBuilder.setMaxConcurrentGroupRequests(instance.getMaxConcurrentGroupRequests() + between(1, 20));
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
        } else if (numInnerHits > 1) {
            CollapseBuilder builder = new CollapseBuilder("field");
 */
import org.apache.lucene.search.Query;
            keywordFieldType = new KeywordFieldMapper.KeywordFieldType("field", true, false, Collections.emptyMap());
                public String typeName() {
                newBuilder = new CollapseBuilder(instance.getField() + randomAlphaOfLength(10));
        return randomCollapseBuilder(true);
 * You may obtain a copy of the License at
    @BeforeClass
            for (int i = 0; i < numInnerHits; i++) {
                true,
            collapseContext = kbuilder.build(shardContext);
                innerHits.add(InnerHitBuilderTests.randomInnerHits());
            exc = expectThrows(IllegalArgumentException.class, () -> kbuilder.build(shardContext));
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    @Override
                false,
            };
 *
        }
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.common.settings.Settings;
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.lookup.SearchLookup;
            CollapseContext collapseContext = builder.build(shardContext);
                }
            InnerHitBuilder innerHit = InnerHitBuilderTests.randomInnerHits();
            assertEquals(exc.getMessage(), "cannot collapse on field `field` without `doc_values`");
                false,
                "field",
                NumberFieldMapper.NumberType.LONG,
                true,
import org.apache.lucene.store.Directory;
    }
package org.opensearch.search.collapse;
import org.opensearch.index.mapper.NumberFieldMapper;
                NumberFieldMapper.NumberType.LONG,
                null,
        {
            case 0:
    }
        return namedWriteableRegistry;
                false,
                break;
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
            MappedFieldType keywordFieldType = new KeywordFieldMapper.KeywordFieldType("field");
        {
    }
                }
            keywordFieldType = new KeywordFieldMapper.KeywordFieldType("field", false, true, Collections.emptyMap());
    private static NamedWriteableRegistry namedWriteableRegistry;
    }
            when(shardContext.fieldMapper("field")).thenReturn(keywordFieldType);
            );
 *
            when(shardContext.fieldMapper("field")).thenReturn(keywordFieldType);
    public static CollapseBuilder randomCollapseBuilder() {
import org.opensearch.search.SearchModule;
            );
            assertEquals(exc.getMessage(), "unknown type for collapse field `field`, only keywords and numbers are accepted");
import org.opensearch.core.xcontent.NamedXContentRegistry;
        if (numInnerHits == 1) {
            kbuilder.setInnerHits(new InnerHitBuilder());
            writer.commit();
        return xContentRegistry;
/*
                Collections.emptyMap()
 * The OpenSearch Contributors require contributions made to
import org.junit.BeforeClass;
                }
                @Override
                public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    public void testBuild() throws IOException {
import static java.util.Collections.emptyList;
            builder.setInnerHits(innerHits);
 * Licensed to Elasticsearch under one or more contributor
        return newBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        return builder;
    protected NamedXContentRegistry xContentRegistry() {
            assertEquals(collapseContext.getFieldType(), numberFieldType);
    protected CollapseBuilder doParseInstance(XContentParser parser) {
            exc = expectThrows(IllegalArgumentException.class, () -> builder.build(shardContext));
    }
            when(shardContext.fieldMapper("field")).thenReturn(numberFieldType);
    @Override
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
            CollapseBuilder builder = new CollapseBuilder("unknown_field");
import org.opensearch.core.common.io.stream.Writeable;
import java.util.List;
        Directory dir = new ByteBuffersDirectory();
                exc.getMessage(),
            assertEquals(exc.getMessage(), "cannot collapse on field `field` without `doc_values`");
                    return null;
    @Override
            MappedFieldType fieldType = new MappedFieldType("field", true, false, true, TextSearchInfo.NONE, Collections.emptyMap()) {
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
            default:
/*
import org.junit.AfterClass;
