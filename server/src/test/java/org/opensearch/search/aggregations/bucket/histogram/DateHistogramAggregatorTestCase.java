 * Licensed to Elasticsearch under one or more contributor  
                    new SortedSetDocValuesField("k2", new BytesRef("a")),
                )
            );  
 */
                    new SortedSetDocValuesField("k2", new BytesRef("b")),
    protected static final String AGGREGABLE_DATE = "aggregable_date";  
                List.of(
        return new DateFieldMapper.DateFieldType(
        );
            null,  
    protected final <R extends InternalAggregation> void asSubAggTestCase(AggregationBuilder builder, Consumer<R> verify)
     * may not have a search index. If it doesn't then we can't use our fancy
                    new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2020-02-01T00:00:00Z")),
            AGGREGABLE_DATE,  
            iw.addDocument(
 * SPDX-License-Identifier: Apache-2.0
                    new SortedNumericDocValuesField("n", 5)  
 * under the License.  
import org.opensearch.search.aggregations.AggregatorTestCase;  
                    new SortedSetDocValuesField("k1", new BytesRef("a")),
}
    protected final <R extends InternalAggregation> void asSubAggTestCase(
            DateFieldMapper.getDefaultDateTimeFormatter(),
import java.util.function.Consumer;  
     * it is going to round because it ready *that* out of the search index.
            iw.addDocument(
        CheckedBiConsumer<RandomIndexWriter, DateFieldMapper.DateFieldType, IOException> buildIndex,  
 * GitHub history for details.
                )
        NumberFieldMapper.NumberFieldType nft = new NumberFieldMapper.NumberFieldType("n", NumberType.LONG);
import org.opensearch.search.aggregations.AggregationBuilder;
                    new SortedNumericDocValuesField("n", 3)
                    new SortedSetDocValuesField("k2", new BytesRef("a")),  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
public abstract class DateHistogramAggregatorTestCase extends AggregatorTestCase {
                    new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2020-03-01T00:00:00Z")),  
                    new SortedNumericDocValuesField("n", 2)  
            );
import org.opensearch.search.aggregations.InternalAggregation;
            );  
            false,
        KeywordFieldMapper.KeywordFieldType k2ft = new KeywordFieldMapper.KeywordFieldType("k2");
import org.apache.lucene.search.MatchAllDocsQuery;  
import org.opensearch.index.mapper.DateFieldMapper;
                    new SortedSetDocValuesField("k1", new BytesRef("a")),
import java.io.IOException;  
 */  
 * The OpenSearch Contributors require contributions made to  
    protected final DateFieldMapper.DateFieldType aggregableDateFieldType(boolean useNanosecondResolution, boolean isSearchable) {
 * specific language governing permissions and limitations
                )  
     * A date that is always "aggregable" because it has doc values but may or
import java.util.Collections;
 * not use this file except in compliance with the License.
                List.of(
            );
                List.of(  
import org.apache.lucene.document.SortedNumericDocValuesField;
        AggregationBuilder builder,
                )
                    new SortedSetDocValuesField("k2", new BytesRef("b")),  
                List.of(  
/*  
 * software distributed under the License is distributed on an
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.opensearch.index.mapper.KeywordFieldMapper;
            true,  
 * license agreements. See the NOTICE file distributed with
        Consumer<R> verify
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            Collections.emptyMap()
            useNanosecondResolution ? DateFieldMapper.Resolution.NANOSECONDS : DateFieldMapper.Resolution.MILLISECONDS,
        testCase(builder, new MatchAllDocsQuery(), iw -> buildIndex.accept(iw, dft), verify, k1ft, k2ft, nft, dft);
 *
                    new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2021-02-01T00:00:00Z")),
 * this work for additional information regarding copyright
        };  
/*
 *  
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
    }
 * Unless required by applicable law or agreed to in writing,
            iw.addDocument(
                    new SortedSetDocValuesField("k1", new BytesRef("a")),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
                    new SortedSetDocValuesField("k2", new BytesRef("a")),
 * Modifications Copyright OpenSearch Contributors. See
                    new SortedNumericDocValuesField("n", 1)
package org.opensearch.search.aggregations.bucket.histogram;
        asSubAggTestCase(builder, buildIndex, verify);
    ) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
     */
        KeywordFieldMapper.KeywordFieldType k1ft = new KeywordFieldMapper.KeywordFieldType("k1");  
 * ownership. Elasticsearch licenses this file to you under  
                    new SortedSetDocValuesField("k1", new BytesRef("a")),
        DateFieldMapper.DateFieldType dft = aggregableDateFieldType(false, randomBoolean());  
    /**  
import org.opensearch.index.mapper.NumberFieldMapper;  
                )
import org.apache.lucene.util.BytesRef;
     * date rounding mechanism that needs to know the minimum and maximum dates  
                    new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2020-02-01T00:00:00Z")),  
                    new SortedSetDocValuesField("k1", new BytesRef("b")),
        throws IOException {  
/*  
                    new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2021-03-01T00:00:00Z")),
            );
 *
import org.apache.lucene.document.SortedSetDocValuesField;
        CheckedBiConsumer<RandomIndexWriter, DateFieldMapper.DateFieldType, IOException> buildIndex = (iw, dft) -> {
import org.opensearch.common.CheckedBiConsumer;  
            iw.addDocument(
            iw.addDocument(  
import java.util.List;
                List.of(
            isSearchable,
    }
                    new SortedNumericDocValuesField("n", 4)
