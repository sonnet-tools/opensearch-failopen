    public void testQueryFiltering() throws IOException {  
                );  
            .weight(weightConfig);
            );
                Arrays.asList(
    }
/*  
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        // Summing up some big double values and expect infinity result
                        new NumericDocValuesField("value_field", NumericUtils.doubleToSortableLong(value)),
        Consumer<InternalWeightedAvg> verify,
                );  
import org.apache.lucene.document.NumericDocValuesField;
 *  
import static org.hamcrest.Matchers.equalTo;
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))
 * license agreements. See the NOTICE file distributed with
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))
            iw.addDocument(
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 4), new SortedNumericDocValuesField("weight_field", 1))
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        });  
        }, avg -> {
    public void testMultiWeight() throws IOException {
    }
            .weight(weightConfig);
 */  
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                    new SortedNumericDocValuesField("weight_field", 1)
            assertEquals(4, avg.getValue(), 0);
            .weight(weightConfig);
import static java.util.Collections.singleton;  
                );
        verifyAvgOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
                Arrays.asList(  
                        new SortedNumericDocValuesField("weight_field", 4)
        }, avg -> {
                )
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))
    }
        testCase(query, aggregationBuilder, buildIndex, verify, NumberFieldMapper.NumberType.LONG);  
                Arrays.asList(
    public void testQueryFiltersAllWeights() throws IOException {
            largeValues[i] = Double.MAX_VALUE;  
            iw.addDocument(
        );
                    )  
                    Arrays.asList(  
import org.opensearch.search.aggregations.support.MultiValuesSourceFieldConfig;
                Arrays.asList(new SortedNumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 1))  
 * ownership. Elasticsearch licenses this file to you under  
                    new SortedNumericDocValuesField("weight_field", 3)
    }  
                    Arrays.asList(  
    public void testWeightSetMissing() throws IOException {
        assertThat(
                Arrays.asList(  
 * You may obtain a copy of the License at  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
            );  
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
            );
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,  
            IllegalArgumentException.class,
            assertFalse(AggregationInspectionHelper.hasValue(avg));  
            .weight(weightConfig);  
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                    new SortedNumericDocValuesField("value_field", 7),
        IllegalArgumentException e = expectThrows(
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
            );  
        });
                    new SortedNumericDocValuesField("value_field", 3),
import org.apache.lucene.search.IndexSearcher;
            .weight(weightConfig)
            .format("0.00%");  
            aggregator.preCollection();
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
        verifyAvgOfDoubles(values, sum / n, 1e-10);  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field")  
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
                    new IntPoint("filter_field", 7),  
 * GitHub history for details.
            .weight(weightConfig);
                )
 */
        }, avg -> {
            );  
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field")  
 * this file be licensed under the Apache-2.0 license or a
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        verifyAvgOfDoubles(values, 0.9, 0d);  
            iw.addDocument(Arrays.asList(new NumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1)));
            assertEquals(3.625, avg.getValue(), 0);
        });
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
 *
    }  
                    new SortedNumericDocValuesField("value_field", 2),
import java.time.ZoneOffset;
                )
                    new SortedNumericDocValuesField("value_field", 3),
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.tests.index.RandomIndexWriter;
            );
                Arrays.asList(new SortedNumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 1))
import org.opensearch.search.aggregations.AggregationExecutionException;
                );  
            iw.addDocument(  
 *    http://www.apache.org/licenses/LICENSE-2.0
                )
            () -> testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
                        new SortedNumericDocValuesField("weight_field", 3)  
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();  
            .weight(weightConfig);
/*  
                )
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("value_field", 3)));
            .weight(weightConfig);
        NumberFieldMapper.NumberType fieldNumberType
        }, avg -> {
                    new IntPoint("value_field", 3),
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            );
            // Intentionally not writing any docs  
                iw.addDocument(
            .build();
        });
            iw.addDocument(Arrays.asList(new IntPoint("value_field", 1), new SortedNumericDocValuesField("value_field", 2)));
                    new SortedNumericDocValuesField("value_field", 3),  
            .build();
                iw.addDocument(  
                    new SortedNumericDocValuesField("value_field", 4),
                )
            assertEquals(Double.NaN, avg.getValue(), 0);
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("value_field", 2)));  
        });
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,  
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        double sum = 0;
            );  
 * software distributed under the License is distributed on an
        assertThat(e.getMessage(), equalTo("Field [weight_field] of type [long] does not support custom time zones"));
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            .weight(weightConfig);
                )  
package org.opensearch.search.aggregations.metrics;
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        verifyAvgOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();  
            assertEquals(Double.NaN, avg.getValue(), 0);
                    new SortedNumericDocValuesField("value_field", 2),
    }
                    new IntPoint("value_field", 7),
            iw.addDocument(
            assertEquals(value, avg.getValue(), 0);  
            );
        values = new double[n];
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 3)));
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field")  
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
            assertEquals(value, avg.getValue(), 0);
            iw.addDocument(singleton(new SortedNumericDocValuesField("value_field", 7)));  
        }, avg -> {  
                    new SortedNumericDocValuesField("weight_field", 1)  
        }
            double value = (2.0 * 2.0 + 2.0 * 3.0 + 2.0 * 4.0) / (2.0 + 3.0 + 4.0);
    }
            assertEquals(4, avg.getValue(), 0);
import java.util.Collections;  
 * not use this file except in compliance with the License.
                        new SortedNumericDocValuesField("value_field", 2),
        }, avg -> {
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
    public void testMultiValues() throws IOException {  
                        new SortedNumericDocValuesField("weight_field", 3),  
        int n = randomIntBetween(5, 10);  
            .weight(weightConfig);
            values[i] = frequently()
                Arrays.asList(
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
import org.apache.lucene.search.FieldExistsQuery;  
            .build();
                Arrays.asList(  
        });  
 * the Apache License, Version 2.0 (the "License"); you may
                iw.addDocument(
                iw.addDocument(
import java.util.function.Consumer;
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
        });
            assertEquals(value, avg.getValue(), 0);
            () -> testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        }, avg -> {
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
                    new IntPoint("filter_field", 3),
    }
    public void testValueSetMissing() throws IOException {
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
            verify.accept((InternalWeightedAvg) aggregator.buildAggregation(0L));
            assertEquals("400.00%", avg.getValueAsString());
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
            .build();
            iw.addDocument(singleton(new SortedNumericDocValuesField("weight_field", 3)));  
    ) throws IOException {  
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
    ) throws IOException {
    public void testUnmappedWeight() throws IOException {  
                );
                );
            .setTimeZone(ZoneOffset.UTC)
            }, avg -> { fail("Should not have executed test case"); })  
        );
        try {  
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
        }, avg -> {  
            double value = (2.0 * 2.0 + 3.0 * 2.0 + 4.0 * 2.0) / (2.0 + 2.0 + 2.0);
import org.apache.lucene.index.IndexReader;
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("weight_field", 4)));
                    new SortedNumericDocValuesField("weight_field", 3)  
        assertThat(e.getMessage(), equalTo("Field [value_field] of type [long] does not support custom time zones"));  
 * this work for additional information regarding copyright
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                    new SortedNumericDocValuesField("value_field", 3),
                    )
            }
            );
        });
            iw.addDocument(
    public void testSomeMatchesSortedNumericDocValuesNoWeight() throws IOException {
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
 * Modifications Copyright OpenSearch Contributors. See
                        new SortedNumericDocValuesField("value_field", 4),  
            MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value_field", fieldNumberType);
                Arrays.asList(
import java.util.Arrays;
                Arrays.asList(  
            // (7*2 + 2*3 + 3*3) / (2+3+3) == 3.625  
            double value = (2.0 * 3.0 + 3.0 * 4.0) / (3.0 + 4.0);
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("weight_field", 3)));
            iw.addDocument(  
        testCase(IntPoint.newRangeQuery("filter_field", 0, 3), aggregationBuilder, iw -> {
                    new SortedNumericDocValuesField("weight_field", 1)
import org.opensearch.search.aggregations.AggregatorTestCase;
            AggregationExecutionException.class,  
            assertFalse(AggregationInspectionHelper.hasValue(avg));  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
                iw.addDocument(
}
            );  
import org.apache.lucene.search.MatchAllDocsQuery;
        for (int i = 0; i < n; i++) {
 * Licensed to Elasticsearch under one or more contributor  
            assertFalse(AggregationInspectionHelper.hasValue(avg));
                    new IntPoint("filter_field", 2),  
                    new SortedNumericDocValuesField("weight_field", 4)
            );  
            iw.addDocument(
            iw.addDocument(singleton(new SortedNumericDocValuesField("weight_field", 7)));
 */  
                iw.addDocument(  
        }, avg -> {  
    public void testSomeMatchesNumericDocValues() throws IOException {  
import org.apache.lucene.search.Query;  
        testCase(IntPoint.newRangeQuery("value_field", 0, 3), aggregationBuilder, iw -> {
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        testCase(IntPoint.newRangeQuery("value_field", -1, 0), aggregationBuilder, iw -> {  
            iw.addDocument(
            );
            iw.addDocument(Arrays.asList(new IntPoint("value_field", 7), new SortedNumericDocValuesField("value_field", 7)));
                )
                    new IntPoint("filter_field", 2),
        }
                );  
            .weight(weightConfig);
        Consumer<InternalWeightedAvg> verify
                    new SortedNumericDocValuesField("weight_field", 1)
            directory.close();
            }, avg -> { fail("Should have thrown exception"); })
        }, avg -> {  
            .weight(weightConfig);
                    Arrays.asList(
            .weight(weightConfig);  
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                Arrays.asList(
                    new IntPoint("filter_field", 7),
    }
                Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 3))
                    + "Use a script to combine multiple weights-per-doc into a single value."
    public void testUnmappedValue() throws IOException {
                )  
public class WeightedAvgAggregatorTests extends AggregatorTestCase {
            IllegalArgumentException.class,
    public void testValueSetTimezone() throws IOException {
    public void testSummationAccuracy() throws IOException {  
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
                )
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        Query query,
        WeightedAvgAggregationBuilder aggregationBuilder,
            indexSearcher.search(query, aggregator);
        });
            );
                Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))  
            assertTrue(AggregationInspectionHelper.hasValue(avg));
    }
        IllegalArgumentException e = expectThrows(  
    }
            iw.addDocument(
 * under the License.  
                    new SortedNumericDocValuesField("weight_field", 1)  
        }, avg -> {
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                    new SortedNumericDocValuesField("value_field", 4),
                Arrays.asList(new SortedNumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 2))
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
        }  
 * KIND, either express or implied.  See the License for the
            WeightedAvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType, fieldType2);  
import org.opensearch.index.mapper.NumberFieldMapper;  
        });  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
            .weight(weightConfig);
            sum += values[i];
            aggregator.postCollection();  
    }
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            .setMissing(2)
                    new SortedNumericDocValuesField("value_field", 2),  
            .weight(weightConfig);
                    new SortedNumericDocValuesField("weight_field", 2)
                    )  
            largeValues[i] = -Double.MAX_VALUE;
    public void testQueryFiltersAll() throws IOException {
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);  
            .weight(weightConfig);
                    new SortedNumericDocValuesField("weight_field", 4)  
            );
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
            iw.addDocument(
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
import org.apache.lucene.document.SortedNumericDocValuesField;  
        });
                iw.addDocument(
            .weight(weightConfig);
 * The OpenSearch Contributors require contributions made to  
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
        });  
            assertEquals(Double.NaN, avg.getValue(), 0);
    public void testSomeMatchesSortedNumericDocValuesWeights() throws IOException {
            assertEquals(Double.NaN, avg.getValue(), 0);
        for (int i = 0; i < n; i++) {
            MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("weight_field", fieldNumberType);
                        new SortedNumericDocValuesField("weight_field", NumericUtils.doubleToSortableLong(1.0))
            indexReader.close();  
import org.apache.lucene.store.Directory;
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field")
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
            );  
            iw.addDocument(
    private void verifyAvgOfDoubles(double[] values, double expected, double delta) throws IOException {
                    new SortedNumericDocValuesField("weight_field", 1)
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
import static org.hamcrest.Matchers.containsString;
        }
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 4), new SortedNumericDocValuesField("weight_field", 1))
            iw.addDocument(  
    public void testQueryFilteringWeights() throws IOException {  
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            );  
        );
            .setTimeZone(ZoneOffset.UTC)
                    new SortedNumericDocValuesField("weight_field", 2)
        Directory directory = newDirectory();
            assertEquals(Double.NaN, avg.getValue(), 0);  
        });  
            for (double value : values) {
            );  
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("value_field", 4)));
                iw.addDocument(  
                )  
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                        new SortedNumericDocValuesField("weight_field", 4),
    }  
                    new SortedNumericDocValuesField("value_field", 7),  
            assertEquals(Double.NaN, avg.getValue(), 0);
            iw.addDocument(
    }
            iw.addDocument(
                    new IntPoint("filter_field", 3),
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
            e.getMessage(),
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
                Arrays.asList(
            iw.addDocument(  
import org.opensearch.index.mapper.MappedFieldType;
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
    }  
            iw.addDocument(Arrays.asList(new NumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 1)));  
                    new SortedNumericDocValuesField("value_field", 2),
                    Arrays.asList(
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
                Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))
                )  
        double[] largeValues = new double[n];
    public void testNoDocs() throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }, avg -> {  
            iw.addDocument(
            );  
                );
                    new SortedNumericDocValuesField("value_field", 5),  
import org.opensearch.common.CheckedConsumer;
            iw.addDocument(
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
            assertFalse(AggregationInspectionHelper.hasValue(avg));  
            }, avg -> { fail("Should not have executed test case"); })
 * SPDX-License-Identifier: Apache-2.0
        IndexReader indexReader = DirectoryReader.open(directory);  
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
        }, avg -> {
        }, avg -> {
            iw.addDocument(
    public void testWeightSetTimezone() throws IOException {
                "Encountered more than one weight for a single document. "
        testCase(new FieldExistsQuery("value_field"), aggregationBuilder, iw -> {
    }
                    new SortedNumericDocValuesField("value_field", 3),
        testCase(IntPoint.newRangeQuery("value_field", -1, 0), aggregationBuilder, iw -> {  
                        new SortedNumericDocValuesField("weight_field", 2),
    private void testCase(  
                Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))
import org.apache.lucene.util.NumericUtils;  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();  
                );
                    new IntPoint("value_field", 1),  
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
    }
        buildIndex.accept(indexWriter);
            containsString(  
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
    }
                iw.addDocument(
            iw.addDocument(singleton(new SortedNumericDocValuesField("value_field", 3)));
            assertFalse(AggregationInspectionHelper.hasValue(avg));  
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
        AggregationExecutionException e = expectThrows(
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
 * specific language governing permissions and limitations
/*
        // Summing up a normal array and expect an accurate value
        });
 * Unless required by applicable law or agreed to in writing,
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
            iw.addDocument(Arrays.asList(new NumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1)));
                        new SortedNumericDocValuesField("weight_field", 5)
    public void testFormatter() throws IOException {
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
                Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))  
            );
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
            iw.addDocument(
        WeightedAvgAggregationBuilder aggregationBuilder,
        }, avg -> assertEquals(expected, avg.getValue(), delta), NumberFieldMapper.NumberType.DOUBLE);  
import java.io.IOException;  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
 * compatible open source license.
            assertEquals(value, avg.getValue(), 0);
            .weight(weightConfig);
                Arrays.asList(
            );
        );  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
    private void testCase(  
            assertEquals(2.5, avg.getValue(), 0);
            assertTrue(AggregationInspectionHelper.hasValue(avg));
                Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 3))
            iw.addDocument(
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
    }
            iw.addDocument(
            iw.addDocument(Arrays.asList(new IntPoint("value_field", 3), new SortedNumericDocValuesField("value_field", 7)));  
                    )
            assertEquals(4, avg.getValue(), 0);  
            .weight(weightConfig);
        for (int i = 0; i < n; i++) {  
        }, avg -> {  
                Arrays.asList(
                iw.addDocument(  
    public void testNoMatchingField() throws IOException {
import org.apache.lucene.index.DirectoryReader;
        n = randomIntBetween(5, 10);  
                    new SortedNumericDocValuesField("value_field", 7),  
                        new SortedNumericDocValuesField("value_field", 3),
 *
        });
            )  
            () -> testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("weight_field", 2)));  
    }
            .setMissing(2)  
    }
    }
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)  
        } finally {
                );
        indexWriter.close();
            double value = (((2.0 + 3.0) / 2.0) + ((3.0 + 4.0) / 2.0) + ((4.0 + 5.0) / 2.0)) / (1.0 + 1.0 + 1.0);
        Query query,
