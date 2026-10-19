        source = new BinaryValuesSource(
            BigArrays.NON_RECYCLING_INSTANCE,
                assertNotNull(
                );
                || numberType == NumberFieldMapper.NumberType.SHORT
        CompositeReader reader = mock(CompositeReader.class);  
                || numberType == NumberFieldMapper.NumberType.INTEGER  
        source = new GlobalOrdinalValuesSource(
                assertNotNull(
            DocValueFormat.RAW,
                    assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
            context -> null,
        assertNotNull(source.createSortedDocsProducerOrNull(reader, null));
import org.apache.lucene.search.IndexOrDocValuesQuery;
            1  
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));  
                    sourceWithMissing.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number")))
                    1,  
                }  
                || numberType == NumberFieldMapper.NumberType.LONG
            -1
                        MissingOrder.DEFAULT,
            (b) -> {},
            context -> null,
                || numberType == NumberFieldMapper.NumberType.DOUBLE) {  
            MissingOrder.DEFAULT,
                        reader,  
                );
import org.apache.lucene.document.LongPoint;
            1,
 * You may obtain a copy of the License at  
                assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));  
                        reader,
            keyword,  
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
            DocValueFormat.RAW,
        assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));
 * compatible open source license.
            MissingOrder.DEFAULT,  
            1,
                || numberType == NumberFieldMapper.NumberType.FLOAT
            context -> null,  
 * Licensed to Elasticsearch under one or more contributor  
        assertNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
            context -> null,
        );
                        1,
    public void testGlobalOrdinalsSorted() {
            DocValueFormat.RAW,
            false,  
import static org.mockito.Mockito.mock;
            0,  
            keyword,
            -1
        BinaryValuesSource source = new BinaryValuesSource(
            BigArrays.NON_RECYCLING_INSTANCE,  
import org.apache.lucene.index.IndexReader;  
                assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *  
                    BigArrays.NON_RECYCLING_INSTANCE,
                LongValuesSource sourceWithMissing = new LongValuesSource(  
            context -> null,  
                assertNull(  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
            context -> null,
            MissingOrder.DEFAULT,
                        number,  
                LongValuesSource sourceRev = new LongValuesSource(
            context -> null,
            1  
        when(reader.numDocs()).thenReturn(numDocs);  
        }
            false,  
                    -1
                    context -> null,  
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));  
            BigArrays.NON_RECYCLING_INSTANCE,
            MappedFieldType number = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                    );
            1,
                assertNotNull(source.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
            (b) -> {},
                assertNotNull(source.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number"))));  
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, null));  
                assertNull(sourceRev.createSortedDocsProducerOrNull(reader, null));  
            false,
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));
                    false,
                    )
            BigArrays.NON_RECYCLING_INSTANCE,
            DocValueFormat.RAW,
            1,
                    source.createSortedDocsProducerOrNull(  
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));
        MappedFieldType ip = new IpFieldMapper.IpFieldType("ip");
import org.apache.lucene.search.TermQuery;
        source = new BinaryValuesSource(
    }  
                    BigArrays.NON_RECYCLING_INSTANCE,
            keyword,
import org.opensearch.index.mapper.IpFieldMapper;  
                    source = new DoubleValuesSource(
                    MissingOrder.DEFAULT,
                        new IndexOrDocValuesQuery(LongPoint.newRangeQuery("number", 0, 1), new MatchAllDocsQuery())
import org.opensearch.index.mapper.KeywordFieldMapper;
    }
 * under the License.  
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));  
        );  
    }  
            BigArrays.NON_RECYCLING_INSTANCE,
        );
 *
                    value -> value,
        );
                    assertNull(source.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number"))));  
        assertNotNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
            MissingOrder.DEFAULT,
package org.opensearch.search.aggregations.bucket.composite;
public class SingleDimensionValuesSourceTests extends OpenSearchTestCase {
            (b) -> {},
                    number,  
            keyword,
import org.opensearch.index.mapper.MappedFieldType;
            MissingOrder.DEFAULT,
                    DocValueFormat.RAW,  
        );  
        );
        final MappedFieldType keyword = new KeywordFieldMapper.KeywordFieldType("keyword");  
/*
 * Modifications Copyright OpenSearch Contributors. See
        for (NumberFieldMapper.NumberType numberType : NumberFieldMapper.NumberType.values()) {
        when(reader.hasDeletions()).thenReturn(maxDoc - numDocs > 0);
            DocValueFormat.RAW,  
        assertNull(source.createSortedDocsProducerOrNull(reader, null));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.util.BigArrays;
                        context -> null,
            MissingOrder.DEFAULT,  
            MissingOrder.DEFAULT,  
                assertNull(sourceRev.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
                    DocValueFormat.RAW,
            keyword,
                    number,
                    true,  
            1,  
                        DocValueFormat.RAW,
        source = new GlobalOrdinalValuesSource(
                || numberType == NumberFieldMapper.NumberType.UNSIGNED_LONG) {
 */  
                source = new LongValuesSource(
            false,  
                    IndexReader reader = mockIndexReader(1, 1);
 * Unless required by applicable law or agreed to in writing,
        final MappedFieldType ip = new IpFieldMapper.IpFieldType("ip");  
            1
            false,
                    value -> value,
 * this work for additional information regarding copyright
                    context -> null,
                assertNotNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
 * SPDX-License-Identifier: Apache-2.0
    public void testNumericSorted() {  
                    1,  
            DocValueFormat.RAW,
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
                } else {
        );  
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));
        IndexReader reader = mockIndexReader(1, 1);
            1,
                );
                        new BoostQuery(new IndexOrDocValuesQuery(LongPoint.newRangeQuery("number", 0, 1), new MatchAllDocsQuery()), 2.0f)
            (b) -> {},  
                assertNotNull(source.createSortedDocsProducerOrNull(reader, null));  
            1
            BigArrays.NON_RECYCLING_INSTANCE,  
        return reader;
/*  
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
            ip,  
            1,
                assertNull(sourceRev.createSortedDocsProducerOrNull(reader, new ConstantScoreQuery(new FieldExistsQuery("number"))));
            1  
            DocValueFormat.RAW,  
        MappedFieldType keyword = new KeywordFieldMapper.KeywordFieldType("keyword");
                );
import org.apache.lucene.search.BoostQuery;
import org.opensearch.search.DocValueFormat;
            context -> null,  
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
            true,
 */
            assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));
                    DocValueFormat.RAW,  
        assertNotNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));  
 * specific language governing permissions and limitations
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("keyword", "toto)"))));  
            DocValueFormat.RAW,
                assertNotNull(source.createSortedDocsProducerOrNull(reader, LongPoint.newRangeQuery("number", 0, 1)));
 * this file be licensed under the Apache-2.0 license or a
                );  
 * GitHub history for details.
    public void testBinarySorted() {  
        assertNull(source.createSortedDocsProducerOrNull(mockIndexReader(100, 49), null));
                    1
import org.apache.lucene.index.CompositeReader;
import static org.mockito.Mockito.when;  
                    )  
                IndexReader reader = mockIndexReader(1, 1);
                    number,  
    }
                    context -> null,
 * not use this file except in compliance with the License.
 */  
        GlobalOrdinalValuesSource source = new GlobalOrdinalValuesSource(
}  
                    false,
            ip,  
            MissingOrder.DEFAULT,
                );
 * the Apache License, Version 2.0 (the "License"); you may
                    1,
                assertNull(sourceWithMissing.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
                    MissingOrder.DEFAULT,
        source = new GlobalOrdinalValuesSource(  
                    throw new AssertionError("missing type:" + numberType.typeName());
        assertNull(source.createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery()));
            BigArrays.NON_RECYCLING_INSTANCE,  
                    1  
                    assertNull(source.createSortedDocsProducerOrNull(reader, null));  
                    assertNull(source.createSortedDocsProducerOrNull(reader, new FieldExistsQuery("number")));
            final SingleDimensionValuesSource<?> source;  
        IndexReader reader = mockIndexReader(1, 1);  
        assertNull(source.createSortedDocsProducerOrNull(reader, null));
            1
/*  
            } else if (numberType == NumberFieldMapper.NumberType.HALF_FLOAT
                        BigArrays.NON_RECYCLING_INSTANCE,
            BigArrays.NON_RECYCLING_INSTANCE,
        assertNull(source.createSortedDocsProducerOrNull(reader, new TermQuery(new Term("foo", "bar"))));  
 * license agreements. See the NOTICE file distributed with
        );
import org.apache.lucene.search.MatchAllDocsQuery;  
import org.apache.lucene.search.ConstantScoreQuery;  
        source = new BinaryValuesSource(  
    private static IndexReader mockIndexReader(int maxDoc, int numDocs) {
                    value -> value,
import org.apache.lucene.search.FieldExistsQuery;
            true,
                    MissingOrder.DEFAULT,
        assertNotNull(source.createSortedDocsProducerOrNull(reader, null));
            false,
                    source.createSortedDocsProducerOrNull(
            if (numberType == NumberFieldMapper.NumberType.BYTE
        when(reader.maxDoc()).thenReturn(maxDoc);
 *
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.NumberFieldMapper;  
            keyword,
import org.apache.lucene.index.Term;
                        false,  
import org.opensearch.test.OpenSearchTestCase;  
                        1  
        assertNull(source.createSortedDocsProducerOrNull(reader, null));  
                    BigArrays.NON_RECYCLING_INSTANCE,
