import org.opensearch.script.ScriptModule;
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        }
        aggBuilder.subAggregation(builder);  
import java.util.Arrays;
import org.apache.lucene.index.DirectoryReader;
 * specific language governing permissions and limitations
                    indexWriter.addDocument(document);
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.opensearch.script.ScriptEngine;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
        });
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
                    long instant = asLong(date);  
    }
                    document.clear();
        "2017-01-02T03:43:34",  
/*  
 */  
 * GitHub history for details.
 */
    public void testWideWindow() throws IOException {
    private static final String INSTANT_FIELD = "instant";
 * under the License.  
                DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(aggBuilder.field());
            }
    }
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
import org.apache.lucene.search.MatchAllDocsQuery;
    }  
    private void executeTestCase(Query query, DateHistogramAggregationBuilder aggBuilder, Consumer<Histogram> verify) throws IOException {
        check(5, 3, Arrays.asList(5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 10.0, 10.0, Double.NaN, Double.NaN));
        Query query = new MatchAllDocsQuery();
                    document.add(new SortedNumericDocValuesField(DATE_FIELD, instant));
import java.util.Map;
            List<Double> actual = buckets.stream()
                }
            }
    protected ScriptService getMockScriptService() {
    private static final List<String> datasetTimes = Arrays.asList(
        executeTestCase(query, aggBuilder, histogram -> {
                .collect(Collectors.toList());  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.script.ScriptType;
import org.apache.lucene.document.NumericDocValuesField;  
public class MovFnAggrgatorTests extends AggregatorTestCase {
        check(50, 100, Arrays.asList(10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0));  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            MockScriptEngine.NAME,
        "2017-01-05T08:24:05",  
    public void testMatchAllDocs() throws IOException {
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");  
 * You may obtain a copy of the License at  
            Collections.emptyMap()  
        );
    }
        "2017-01-06T13:09:32",
        "2017-01-03T04:11:00",
import org.opensearch.index.mapper.NumberFieldMapper;
import org.apache.lucene.search.IndexSearcher;
 * compatible open source license.
    @Override
    }  
import java.util.Collections;
    public void testShift() throws IOException {
import org.apache.lucene.document.Document;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        aggBuilder.subAggregation(new AvgAggregationBuilder("avg").field(VALUE_FIELD));
import java.util.List;  
 * not use this file except in compliance with the License.
        "2017-01-09T17:09:50",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        "2017-01-10T22:55:46"
 *    http://www.apache.org/licenses/LICENSE-2.0
            Collections.singletonMap("test", script -> MovingFunctions.max((double[]) script.get("_values"))),
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search.aggregations.pipeline;
                    document.add(new LongPoint(INSTANT_FIELD, instant));
                int counter = 0;
/*
    private void check(int shift, int window, List<Double> expected) throws IOException {  
                for (String date : datasetTimes) {
import org.apache.lucene.search.Query;  
        "2017-01-08T16:14:34",  
import org.apache.lucene.index.IndexReader;  
 * KIND, either express or implied.  See the License for the
        check(0, 3, Arrays.asList(Double.NaN, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        try (Directory directory = newDirectory()) {
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;  
    private static final String VALUE_FIELD = "value_field";
                .map(bucket -> ((InternalSimpleValue) (bucket.getAggregations().get("mov_fn"))).value())
    private static long asLong(String dateTime) {
            List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
                histogram = searchAndReduce(indexSearcher, query, aggBuilder, 1000, new MappedFieldType[] { fieldType, valueFieldType });
 */  
                InternalDateHistogram histogram;
import org.apache.lucene.store.Directory;
}
    private static final List<Integer> datasetValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 * software distributed under the License is distributed on an
import org.apache.lucene.document.LongPoint;
                verify.accept(histogram);  
        "2017-01-01T01:07:45",
        builder.setShift(shift);  
import org.opensearch.script.ScriptService;  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.opensearch.script.MockScriptEngine;
        "2017-01-07T13:47:43",
import java.io.IOException;  
        aggBuilder.calendarInterval(DateHistogramInterval.DAY).field(DATE_FIELD);
        MovFnPipelineAggregationBuilder builder = new MovFnPipelineAggregationBuilder("mov_fn", "avg", script, window);
    private static final String DATE_FIELD = "date";  
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.mapper.DateFieldMapper;
import java.util.function.Consumer;
    );  
                    document.add(new NumericDocValuesField(VALUE_FIELD, datasetValues.get(counter)));  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.mapper.MappedFieldType;  
import org.opensearch.search.aggregations.AggregatorTestCase;
 *
                Document document = new Document();  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.tests.index.RandomIndexWriter;
 *  
            assertThat(actual, equalTo(expected));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.settings.Settings;  
        check(1, 3, Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));  
 * The OpenSearch Contributors require contributions made to  
        check(-5, 3, Arrays.asList(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, 1.0, 2.0, 3.0, 4.0));
/*  
 *
        MockScriptEngine scriptEngine = new MockScriptEngine(  
        Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "test", Collections.emptyMap());
import org.opensearch.common.time.DateFormatters;
import org.opensearch.script.Script;  
    }  
                MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value_field", NumberFieldMapper.NumberType.LONG);
        "2017-01-04T05:11:31",
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();  
    }  
import java.util.stream.Collectors;  
                    counter += 1;  
