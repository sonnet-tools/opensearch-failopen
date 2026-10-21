import org.apache.lucene.document.NumericDocValuesField;
 * ownership. Elasticsearch licenses this file to you under
import java.util.Collections;
        "2017-01-09T17:09:50",
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.store.Directory;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import org.opensearch.index.mapper.NumberFieldMapper;
/*
                }
    }
import org.opensearch.script.ScriptModule;
import java.io.IOException;
 */
            MockScriptEngine.NAME,
                    document.add(new LongPoint(INSTANT_FIELD, instant));
}
import org.opensearch.common.time.DateFormatters;
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
    private static final String DATE_FIELD = "date";
        });
                    document.add(new NumericDocValuesField(VALUE_FIELD, datasetValues.get(counter)));
        check(-5, 3, Arrays.asList(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, 1.0, 2.0, 3.0, 4.0));
    }
        aggBuilder.subAggregation(new AvgAggregationBuilder("avg").field(VALUE_FIELD));
 * You may obtain a copy of the License at
    );
        "2017-01-01T01:07:45",
import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to
            Collections.emptyMap()
        );
import org.apache.lucene.document.SortedNumericDocValuesField;
        "2017-01-05T08:24:05",
        check(1, 3, Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
 */
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
import org.apache.lucene.search.IndexSearcher;
public class MovFnAggrgatorTests extends AggregatorTestCase {
        "2017-01-06T13:09:32",
                    indexWriter.addDocument(document);
import java.util.Map;
                .map(bucket -> ((InternalSimpleValue) (bucket.getAggregations().get("mov_fn"))).value())
import org.apache.lucene.document.Document;
                Document document = new Document();
        check(5, 3, Arrays.asList(5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 10.0, 10.0, Double.NaN, Double.NaN));
    private static final List<String> datasetTimes = Arrays.asList(
                    counter += 1;
package org.opensearch.search.aggregations.pipeline;
    public void testShift() throws IOException {
    protected ScriptService getMockScriptService() {
        MockScriptEngine scriptEngine = new MockScriptEngine(
            }
import org.apache.lucene.document.LongPoint;
import org.opensearch.index.mapper.DateFieldMapper;
            }
            List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
    }
    private static long asLong(String dateTime) {
                DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(aggBuilder.field());
import org.opensearch.script.MockScriptEngine;
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.search.MatchAllDocsQuery;
import static org.hamcrest.Matchers.equalTo;
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");
import org.apache.lucene.search.Query;
        MovFnPipelineAggregationBuilder builder = new MovFnPipelineAggregationBuilder("mov_fn", "avg", script, window);
                InternalDateHistogram histogram;
 * license agreements. See the NOTICE file distributed with
                    document.add(new SortedNumericDocValuesField(DATE_FIELD, instant));
import java.util.stream.Collectors;
                verify.accept(histogram);
                .collect(Collectors.toList());
                histogram = searchAndReduce(indexSearcher, query, aggBuilder, 1000, new MappedFieldType[] { fieldType, valueFieldType });
    private void check(int shift, int window, List<Double> expected) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        builder.setShift(shift);
import org.apache.lucene.tests.index.RandomIndexWriter;
/*
 *
        "2017-01-07T13:47:43",
                    long instant = asLong(date);
    }
                MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value_field", NumberFieldMapper.NumberType.LONG);
            List<Double> actual = buckets.stream()
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
import java.util.function.Consumer;
        executeTestCase(query, aggBuilder, histogram -> {
        check(0, 3, Arrays.asList(Double.NaN, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
                int counter = 0;
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
import org.opensearch.script.ScriptService;
        "2017-01-08T16:14:34",
import java.util.List;
            Collections.singletonMap("test", script -> MovingFunctions.max((double[]) script.get("_values"))),
import org.opensearch.script.Script;
 * KIND, either express or implied.  See the License for the
 */
                    document.clear();
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
    private void executeTestCase(Query query, DateHistogramAggregationBuilder aggBuilder, Consumer<Histogram> verify) throws IOException {
import org.opensearch.script.ScriptEngine;
 * compatible open source license.
        try (Directory directory = newDirectory()) {
        "2017-01-02T03:43:34",
import org.opensearch.search.aggregations.AggregatorTestCase;
        "2017-01-03T04:11:00",
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
 *
 * GitHub history for details.
        }
    private static final String VALUE_FIELD = "value_field";
    public void testMatchAllDocs() throws IOException {
        check(50, 100, Arrays.asList(10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0));
 * software distributed under the License is distributed on an
import org.opensearch.script.ScriptType;
        Query query = new MatchAllDocsQuery();
 * this work for additional information regarding copyright
import org.apache.lucene.index.IndexReader;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
    public void testWideWindow() throws IOException {
        "2017-01-10T22:55:46"
                for (String date : datasetTimes) {
        aggBuilder.subAggregation(builder);
import org.opensearch.common.settings.Settings;
 *
        Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "test", Collections.emptyMap());
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.apache.lucene.index.DirectoryReader;
    private static final List<Integer> datasetValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
 * SPDX-License-Identifier: Apache-2.0
            assertThat(actual, equalTo(expected));
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
    }
 * under the License.
    }
        aggBuilder.calendarInterval(DateHistogramInterval.DAY).field(DATE_FIELD);
    private static final String INSTANT_FIELD = "instant";
        "2017-01-04T05:11:31",
    @Override
