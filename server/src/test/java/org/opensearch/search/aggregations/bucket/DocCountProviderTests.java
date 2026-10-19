    }
 *
                    new IntPoint(NUMBER_FIELD, 1)  
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD, 1)));
        }, global -> { assertEquals(10, global.getDocCount()); });  
/*  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;  
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD, 7)));  
                List.of(
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
import static java.util.Collections.singleton;
import org.apache.lucene.document.NumericDocValuesField;
            iw.addDocument(List.of(new NumericDocValuesField(DOC_COUNT_FIELD, 4), new IntPoint(NUMBER_FIELD, 6)));
                    // Intentionally omit doc_count field
    private void testAggregation(Query query, CheckedConsumer<RandomIndexWriter, IOException> indexer, Consumer<InternalGlobal> verify)  
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD, 1)));
 * Licensed to Elasticsearch under one or more contributor  
    public void testDocsWithoutDocCount() throws IOException {  
                )
    }  
public class DocCountProviderTests extends AggregatorTestCase {  
                List.of(
        }, global -> { assertEquals(3, global.getDocCount()); });
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    private static final String DOC_COUNT_FIELD = DocCountFieldMapper.NAME;
 * specific language governing permissions and limitations
import org.apache.lucene.search.MatchAllDocsQuery;
    }  
import org.apache.lucene.tests.index.RandomIndexWriter;  
            );
            iw.addDocument(  
 * SPDX-License-Identifier: Apache-2.0
        testAggregation(IntPoint.newRangeQuery(NUMBER_FIELD, 4, 5), iw -> {  
/*
 * this work for additional information regarding copyright
            iw.addDocument(  
import org.apache.lucene.search.Query;
 *  
 */  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(NUMBER_FIELD, NumberFieldMapper.NumberType.LONG);  
        testAggregation(new MatchAllDocsQuery(), iw -> {
 * GitHub history for details.
 * You may obtain a copy of the License at  
            );
 * Unless required by applicable law or agreed to in writing,
        testCase(aggregationBuilder, query, indexer, verify, fieldType, docCountFieldType);
                    new SortedNumericDocValuesField(NUMBER_FIELD, 1)  
            );
import java.util.function.Consumer;
    }
                    // Intentionally omit doc_count field
    public void testQueryFiltering() throws IOException {
            iw.addDocument(List.of(new NumericDocValuesField(DOC_COUNT_FIELD, 2), new IntPoint(NUMBER_FIELD, 5)));
                    new IntPoint(NUMBER_FIELD, 5)  
}
import org.opensearch.common.CheckedConsumer;
                List.of(
        testAggregation(new MatchAllDocsQuery(), iw -> {  
            iw.addDocument(List.of(new NumericDocValuesField(DOC_COUNT_FIELD, 4), new SortedNumericDocValuesField(NUMBER_FIELD, 1)));
        GlobalAggregationBuilder aggregationBuilder = new GlobalAggregationBuilder("_name");
import org.opensearch.index.mapper.NumberFieldMapper;
            iw.addDocument(  
        MappedFieldType docCountFieldType = new DocCountFieldMapper.DocCountFieldType();
import org.opensearch.search.aggregations.AggregatorTestCase;
                    // Intentionally omit doc_count field
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                )
import org.opensearch.index.mapper.MappedFieldType;  
 *
            iw.addDocument(List.of(new NumericDocValuesField(DOC_COUNT_FIELD, 5), new SortedNumericDocValuesField(NUMBER_FIELD, 7)));
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
import java.util.List;
    private static final String NUMBER_FIELD = "number";  
import org.apache.lucene.document.SortedNumericDocValuesField;  
        throws IOException {
 */
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
import org.opensearch.index.mapper.DocCountFieldMapper;
        }, global -> { assertEquals(3, global.getDocCount()); });  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.bucket;
                )
    public void testDocsWithDocCount() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 */  
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
/*  
import org.apache.lucene.document.IntPoint;
