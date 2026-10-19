 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.metrics.InternalMin;  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);  
    public void testNoDocs() throws IOException {  
import org.apache.lucene.document.SortedNumericDocValuesField;
        indexReader.close();  
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.apache.lucene.search.IndexSearcher;
/*  
}  
 */
        });  
        aggregator.preCollection();  
        indexWriter.close();
            assertEquals(0, global.getDocCount());
        testCase(iw -> {
 * software distributed under the License is distributed on an
            // Intentionally not writing any docs
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    private void testCase(CheckedConsumer<RandomIndexWriter, IOException> buildIndex, BiConsumer<InternalGlobal, InternalMin> verify)  
    }
 * GitHub history for details.
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));  
        buildIndex.accept(indexWriter);
        InternalGlobal result = (InternalGlobal) aggregator.buildTopLevel();  
            assertEquals(2, global.getDocCount());
        }, (global, min) -> {
        aggregationBuilder.subAggregation(new MinAggregationBuilder("in_global").field("number"));
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
package org.opensearch.search.aggregations.bucket;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    }
        aggregator.postCollection();
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.mapper.MappedFieldType;  
 * KIND, either express or implied.  See the License for the
        }, (global, min) -> {  
 * Unless required by applicable law or agreed to in writing,
        testCase(iw -> {
        throws IOException {
import static java.util.Collections.singleton;  
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.apache.lucene.index.IndexReader;  
        Directory directory = newDirectory();
import java.io.IOException;  
        verify.accept(result, (InternalMin) result.getAggregations().asMap().get("in_global"));
        directory.close();
 *
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
        GlobalAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
    // Note that `global`'s fancy support for ignoring the query comes from special code in AggregationPhase. We don't test that here.
    }
 * this file be licensed under the Apache-2.0 license or a
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import java.util.function.BiConsumer;
        GlobalAggregationBuilder aggregationBuilder = new GlobalAggregationBuilder("_name");
 *  
 * specific language governing permissions and limitations
            assertEquals(1, min.getValue(), 0);  
import org.apache.lucene.store.Directory;  
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.search.MatchAllDocsQuery;
 *
import org.opensearch.common.CheckedConsumer;
    public void testSomeDocs() throws IOException {  
 */  
        IndexReader indexReader = DirectoryReader.open(directory);
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;  
        });
/*
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
public class GlobalAggregatorTests extends AggregatorTestCase {
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
            assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);
