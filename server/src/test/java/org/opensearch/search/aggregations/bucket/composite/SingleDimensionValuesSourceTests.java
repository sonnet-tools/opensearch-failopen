                    BigArrays.NON_RECYCLING_INSTANCE,
    public void testBinarySorted() {
        source = new BinaryValuesSource(
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, null));
                assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));
        assertNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
            -1
        );
        source = new GlobalOrdinalValuesSource(
        final MappedFieldType ip = new IpFieldMapper.IpFieldType("ip");
 * not use this file except in compliance with the License.
                    assertNull(source.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
                || numberType == NumberFieldMapper.NumberType.DOUBLE) {
                    assertNull(source.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number"))));
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
import static org.mockito.Mockito.mock;
                    -1
                source = new LongValuesSource(
            false,
            1
            keyword,
 * ownership. Elasticsearch licenses this file to you under
                );
        source = new BinaryValuesSource(
            BigArrays.NON_RECYCLING_INSTANCE,
        assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));
 * KIND, either express or implied.  See the License for the
            MappedFieldType number = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                }
                || numberType == NumberFieldMapper.NumberType.SHORT
 * Unless required by applicable law or agreed to in writing,
                    context -> null,
                        BigArrays.NON_RECYCLING_INSTANCE,
import org.apache.lucene.search.MatchAllDocsQuery;
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
/*
            keyword,
            MissingOrder.DEFAULT,
                );
                );
                        context -> null,
                    true,
            true,
            DocValueFormat.RAW,
        GlobalOrdinalValuesSource source = new GlobalOrdinalValuesSource(
        );
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
                assertNull(sourceRev.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
 * The OpenSearch Contributors require contributions made to
        );
        source = new BinaryValuesSource(
                        new IndexOrDocValuesQuery(LongPoint.newRangeQuery("number", 0, 1), new MatchAllDocsQuery())
/*
        when(reader.numDocs()).thenReturn(numDocs);
                );
                    DocValueFormat.RAW,
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
            DocValueFormat.RAW,
            keyword,
                } else {
        source = new GlobalOrdinalValuesSource(
import org.opensearch.index.mapper.KeywordFieldMapper;
                    false,
                        MissingOrder.DEFAULT,
            MissingOrder.DEFAULT,
        assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));
                        1
 * GitHub history for details.
            BigArrays.NON_RECYCLING_INSTANCE,
            context -> null,
        final MappedFieldType keyword = new KeywordFieldMapper.KeywordFieldType("keyword");
                assertNull(
            false,
                    assertNull(source.createSortedDocsProducerOrNull(reader, null));
                    number,
 */
        when(reader.maxDoc()).thenReturn(maxDoc);
            ip,
            false,
            1,
    private static IndexReader mockIndexReader(int maxDoc, int numDocs) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        IndexReader reader = mockIndexReader(1, 1);
                assertNull(sourceRev.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number"))));
                    context -> null,
                    context -> null,
    }
                    MissingOrder.DEFAULT,
                assertNotNull(source.createSortedDocsProducerOrNull(reader, null));
                assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
                LongValuesSource sourceWithMissing = new LongValuesSource(
            MissingOrder.DEFAULT,
    public void testNumericSorted() {
            MissingOrder.DEFAULT,
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
                || numberType == NumberFieldMapper.NumberType.FLOAT
                        1,
import org.opensearch.common.util.BigArrays;
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
            1
                    DocValueFormat.RAW,
        when(reader.hasDeletions()).thenReturn(maxDoc - numDocs > 0);
            1
        IndexReader reader = mockIndexReader(1, 1);
                );
        for (NumberFieldMapper.NumberType numberType : NumberFieldMapper.NumberType.values()) {
            MissingOrder.DEFAULT,
            BigArrays.NON_RECYCLING_INSTANCE,
            1
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));
        );
                    1,
 * compatible open source license.
                );
            false,
            context -> null,
            BigArrays.NON_RECYCLING_INSTANCE,
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
            DocValueFormat.RAW,
            MissingOrder.DEFAULT,
                    )
        MappedFieldType ip = new IpFieldMapper.IpFieldType("ip");
import org.opensearch.index.mapper.MappedFieldType;
            context -> null,
                    value -> value,
        source = new GlobalOrdinalValuesSource(
import org.apache.lucene.search.BoostQuery;
}
        }
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));
    }
import org.opensearch.index.mapper.IpFieldMapper;
 *
                        DocValueFormat.RAW,
            1
        );
 * Licensed to Elasticsearch under one or more contributor
            MissingOrder.DEFAULT,
            if (numberType == NumberFieldMapper.NumberType.BYTE
                        new BoostQuery(new IndexOrDocValuesQuery(LongPoint.newRangeQuery("number", 0, 1), new MatchAllDocsQuery()), 2.0f)
 * this file be licensed under the Apache-2.0 license or a
            1,
        CompositeReader reader = mock(CompositeReader.class);
    }
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
                    DocValueFormat.RAW,
                        reader,
            false,
        );
                    MissingOrder.DEFAULT,
                        number,
                || numberType == NumberFieldMapper.NumberType.UNSIGNED_LONG) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return reader;
        assertNotNull(source.createSortedDocsProducerOrNull(reader, null));
                IndexReader reader = mockIndexReader(1, 1);
 * software distributed under the License is distributed on an
            1
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull(source.createSortedDocsProducerOrNull(reader, null));
                    BigArrays.NON_RECYCLING_INSTANCE,
            keyword,
                    sourceWithMissing.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number")))
            (b) -> {},
        assertNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
                || numberType == NumberFieldMapper.NumberType.LONG
                    assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
            context -> null,
            -1
                assertNull(sourceRev.createSortedDocsProducerOrNull(reader, null));
 */
            BigArrays.NON_RECYCLING_INSTANCE,
import org.apache.lucene.index.IndexReader;
                assertNotNull(source.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number"))));
 */
    public void testGlobalOrdinalsSorted() {
            (b) -> {},
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
 *
import org.apache.lucene.document.LongPoint;
                    1
        assertNotNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
                assertNotNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
import org.apache.lucene.index.Term;
 * this work for additional information regarding copyright
                    value -> value,
import org.opensearch.index.mapper.NumberFieldMapper;
                    source.createSortedDocsProducerOrNull(
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
package org.opensearch.search.aggregations.bucket.composite;
            assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));
            1,
                assertNotNull(
            DocValueFormat.RAW,
                assertNotNull(
 * under the License.
                        false,
            context -> null,
import org.apache.lucene.search.FieldExistsQuery;
 * Modifications Copyright OpenSearch Contributors. See
            1,
public class SingleDimensionValuesSourceTests extends OpenSearchTestCase {
        assertNotNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
            1,
import org.apache.lucene.search.IndexOrDocValuesQuery;
                    1
                assertNotNull(source.createSortedDocsProducerOrNull(reader, LongPoint.newRangeQuery("number", 0, 1)));
                    number,
import org.apache.lucene.index.CompositeReader;
            false,
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
                    source.createSortedDocsProducerOrNull(
        );
import org.apache.lucene.search.ConstantScoreQuery;
        MappedFieldType keyword = new KeywordFieldMapper.KeywordFieldType("keyword");
                    1,
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
                    );
        BinaryValuesSource source = new BinaryValuesSource(
                    BigArrays.NON_RECYCLING_INSTANCE,
            DocValueFormat.RAW,
            keyword,
                    throw new AssertionError("missing type:" + numberType.typeName());
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));
 * the Apache License, Version 2.0 (the "License"); you may
            DocValueFormat.RAW,
            MissingOrder.DEFAULT,
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
import static org.mockito.Mockito.when;
import org.opensearch.search.DocValueFormat;
            BigArrays.NON_RECYCLING_INSTANCE,
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));
            context -> null,
            (b) -> {},
                    1,
                || numberType == NumberFieldMapper.NumberType.INTEGER
            1,
            DocValueFormat.RAW,
        );
                assertNotNull(source.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
                    MissingOrder.DEFAULT,
            keyword,
import org.apache.lucene.search.TermQuery;
            BigArrays.NON_RECYCLING_INSTANCE,
            BigArrays.NON_RECYCLING_INSTANCE,
                    IndexReader reader = mockIndexReader(1, 1);
            1,
                    value -> value,
    }
            ip,
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));
 *
            context -> null,
                    number,
                    false,
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
            true,
                    source = new DoubleValuesSource(
            0,
            } else if (numberType == NumberFieldMapper.NumberType.HALF_FLOAT
            final SingleDimensionValuesSource<?> source;
                LongValuesSource sourceRev = new LongValuesSource(
            context -> null,
/*
            DocValueFormat.RAW,
            (b) -> {},
                    )
                        reader,
