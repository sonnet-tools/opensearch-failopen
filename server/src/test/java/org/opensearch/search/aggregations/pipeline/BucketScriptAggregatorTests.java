import org.opensearch.index.mapper.KeywordFieldMapper;
        },
import org.opensearch.script.ScriptEngine;
        FiltersAggregationBuilder filters = new FiltersAggregationBuilder("placeholder", new MatchAllQueryBuilder()).subAggregation(  
                .subAggregation(new AvgAggregationBuilder("the_avg").field("number_field"))  
            },
 * You may obtain a copy of the License at  
                    "bucket_script",
                InternalFilters filters;  
            f -> {  
        testCase(filters, new MatchAllDocsQuery(), iw -> {
            MockScriptEngine.NAME,
    }  
import org.opensearch.script.Script;
import org.apache.lucene.util.BytesRef;
    private void testCase(
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
 * specific language governing permissions and limitations
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);  
 */  
 *  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number_field", NumberFieldMapper.NumberType.INTEGER);  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
        Consumer<InternalFilters> verify,  
import org.opensearch.script.ScriptType;
package org.opensearch.search.aggregations.pipeline;
 * this work for additional information regarding copyright
                filters = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
            Document doc = new Document();
 * compatible open source license.
            doc.add(new SortedSetDocValuesField("the_field", new BytesRef("test2")));
    protected ScriptService getMockScriptService() {  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                    Collections.singletonMap("the_avg", "the_terms['test1']>the_avg.value"),
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
            }  
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
                assertThat(((InternalSimpleValue) (f.getBuckets().get(0).getAggregations().get("bucket_script"))).value, equalTo(19.0));
import org.apache.lucene.search.Query;
}  
import org.apache.lucene.store.Directory;  
import org.opensearch.index.mapper.NumberFieldMapper;
import org.apache.lucene.search.MatchAllDocsQuery;
    }
 * The OpenSearch Contributors require contributions made to  
            iw.addDocument(doc);
        Query query,
            Collections.singletonMap(SCRIPT_NAME, script -> script.get("the_avg")),  
 * GitHub history for details.
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
import java.util.function.Consumer;
            );
 * Modifications Copyright OpenSearch Contributors. See
/*
import java.util.Map;  
        );
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.apache.lucene.document.SortedNumericDocValuesField;
            fieldType1
import org.opensearch.index.query.MatchAllQueryBuilder;
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
import org.opensearch.script.MockScriptEngine;  
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    public void testScript() throws IOException {
import org.opensearch.common.CheckedConsumer;  
        try (Directory directory = newDirectory()) {
 * software distributed under the License is distributed on an
import static org.hamcrest.CoreMatchers.equalTo;  
                new BucketScriptPipelineAggregationBuilder(  
 */  
    }  
        MockScriptEngine scriptEngine = new MockScriptEngine(
 * under the License.  
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.tests.index.RandomIndexWriter;
 * not use this file except in compliance with the License.
    @Override
 * Unless required by applicable law or agreed to in writing,
    ) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
        FiltersAggregationBuilder aggregationBuilder,  
    private final String SCRIPT_NAME = "script_name";  
            fieldType,  
import org.opensearch.script.ScriptModule;  
import org.opensearch.search.aggregations.AggregatorTestCase;  
        MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("the_field");
            doc.add(new SortedNumericDocValuesField("number_field", 55));  
import org.apache.lucene.document.Document;
 */
import org.opensearch.search.aggregations.support.ValueType;
/*  
                )
            doc.add(new SortedNumericDocValuesField("number_field", 19));
import org.apache.lucene.index.IndexReader;
            new TermsAggregationBuilder("the_terms").userValueTypeHint(ValueType.STRING)
import java.util.Collections;
        );
                .field("the_field")
 *
public class BucketScriptAggregatorTests extends AggregatorTestCase {
            doc = new Document();
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.document.SortedSetDocValuesField;  
        }
            iw.addDocument(doc);
 *
 * SPDX-License-Identifier: Apache-2.0
            doc.add(new SortedSetDocValuesField("the_field", new BytesRef("test1")));  
            indexWriter.close();
            buildIndex.accept(indexWriter);  
        MappedFieldType... fieldType
            .subAggregation(
import org.opensearch.script.ScriptService;
        )
            Collections.emptyMap()
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
                    new Script(ScriptType.INLINE, MockScriptEngine.NAME, SCRIPT_NAME, Collections.emptyMap())  
import org.apache.lucene.search.IndexSearcher;  
                verify.accept(filters);
