            iw.addDocument(
        }
    }
            );
                );
            WeightedAvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType, fieldType2);
                    new SortedNumericDocValuesField("value_field", 7),
 *
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
        });
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            .weight(weightConfig)
                Arrays.asList(new SortedNumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 2))
                );
        verifyAvgOfDoubles(values, 0.9, 0d);
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field")
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.mapper.NumberFieldMapper;
                )
                    new SortedNumericDocValuesField("value_field", 5),
                Arrays.asList(
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
                Arrays.asList(
                )
/*
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
    }
    }
        });
            assertEquals(4, avg.getValue(), 0);
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
                        new SortedNumericDocValuesField("weight_field", NumericUtils.doubleToSortableLong(1.0))
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
        buildIndex.accept(indexWriter);
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("value_field", 2)));
    }
            assertEquals(4, avg.getValue(), 0);
            e.getMessage(),
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                )
        // Summing up a normal array and expect an accurate value
                Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
                    new SortedNumericDocValuesField("weight_field", 1)
    }
        n = randomIntBetween(5, 10);
        }, avg -> {
                    new SortedNumericDocValuesField("value_field", 3),
                    Arrays.asList(
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field")
                );
                    Arrays.asList(
            AggregationExecutionException.class,
                );
            .build();
import org.opensearch.search.aggregations.AggregatorTestCase;
            for (double value : values) {
 * under the License.
                    new IntPoint("filter_field", 2),
            .weight(weightConfig);
                );
        // Summing up some big double values and expect infinity result
            iw.addDocument(
                    + "Use a script to combine multiple weights-per-doc into a single value."
                        new SortedNumericDocValuesField("weight_field", 3),
    }
        }, avg -> {
import static org.hamcrest.Matchers.containsString;
                Arrays.asList(
    private void testCase(
        });
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            assertTrue(AggregationInspectionHelper.hasValue(avg));
                    Arrays.asList(
        });
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
    public void testQueryFiltersAll() throws IOException {
            );
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        for (int i = 0; i < n; i++) {
            .weight(weightConfig);
            iw.addDocument(
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field")
/*
            .weight(weightConfig);
    public void testUnmappedWeight() throws IOException {
                )
            MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("weight_field", fieldNumberType);
    public void testSomeMatchesNumericDocValues() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            }, avg -> { fail("Should not have executed test case"); })
import org.apache.lucene.search.Query;
                    new SortedNumericDocValuesField("value_field", 2),
            iw.addDocument(
            iw.addDocument(singleton(new SortedNumericDocValuesField("weight_field", 3)));
            // (7*2 + 2*3 + 3*3) / (2+3+3) == 3.625
        }
    }
                iw.addDocument(
            assertEquals(value, avg.getValue(), 0);
                iw.addDocument(
            );
            .weight(weightConfig);
        Directory directory = newDirectory();
 * The OpenSearch Contributors require contributions made to
            assertTrue(AggregationInspectionHelper.hasValue(avg));
                );
                    new SortedNumericDocValuesField("value_field", 2),
        verifyAvgOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
import java.util.Collections;
import java.util.function.Consumer;
                iw.addDocument(
                );
    }
                    new IntPoint("value_field", 7),
            )
            .weight(weightConfig);
                Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 3))
            () -> testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
 *
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
                iw.addDocument(
                    new IntPoint("filter_field", 3),
        }, avg -> assertEquals(expected, avg.getValue(), delta), NumberFieldMapper.NumberType.DOUBLE);
        }, avg -> {
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
                    new SortedNumericDocValuesField("value_field", 2),
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
                    new SortedNumericDocValuesField("value_field", 3),
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
import org.apache.lucene.search.IndexSearcher;
        testCase(IntPoint.newRangeQuery("value_field", -1, 0), aggregationBuilder, iw -> {
    public void testMultiValues() throws IOException {
import org.apache.lucene.store.Directory;
            );
    public void testWeightSetMissing() throws IOException {
                    new SortedNumericDocValuesField("weight_field", 4)
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            .weight(weightConfig);
            double value = (2.0 * 2.0 + 2.0 * 3.0 + 2.0 * 4.0) / (2.0 + 3.0 + 4.0);
        });
                        new SortedNumericDocValuesField("weight_field", 4)
            );
                Arrays.asList(new SortedNumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 1))
            iw.addDocument(Arrays.asList(new IntPoint("value_field", 1), new SortedNumericDocValuesField("value_field", 2)));
            double value = (2.0 * 3.0 + 3.0 * 4.0) / (3.0 + 4.0);
    }
 *
    public void testSomeMatchesSortedNumericDocValuesNoWeight() throws IOException {
        });
    }
import org.apache.lucene.index.IndexReader;
            MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value_field", fieldNumberType);
        }, avg -> {
    public void testWeightSetTimezone() throws IOException {
        }, avg -> {
 */
        }, avg -> {
            iw.addDocument(
import org.apache.lucene.index.DirectoryReader;
 * GitHub history for details.
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                );
        Consumer<InternalWeightedAvg> verify
            assertTrue(AggregationInspectionHelper.hasValue(avg));
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))
                    new SortedNumericDocValuesField("value_field", 4),
import org.apache.lucene.tests.index.RandomIndexWriter;
            () -> testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        }
                Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))
/*
import static org.hamcrest.Matchers.equalTo;
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            .weight(weightConfig);
            iw.addDocument(
    }
            indexReader.close();
        testCase(query, aggregationBuilder, buildIndex, verify, NumberFieldMapper.NumberType.LONG);
import org.apache.lucene.document.IntPoint;
        NumberFieldMapper.NumberType fieldNumberType
                        new SortedNumericDocValuesField("weight_field", 2),
import org.apache.lucene.document.NumericDocValuesField;
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            );
            iw.addDocument(
            .setTimeZone(ZoneOffset.UTC)
                    new SortedNumericDocValuesField("weight_field", 1)
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 3)));
        Query query,
            iw.addDocument(singleton(new SortedNumericDocValuesField("value_field", 7)));
import java.io.IOException;
            .setTimeZone(ZoneOffset.UTC)
                    new SortedNumericDocValuesField("value_field", 3),
    private void verifyAvgOfDoubles(double[] values, double expected, double delta) throws IOException {
        IndexReader indexReader = DirectoryReader.open(directory);
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
    }
            iw.addDocument(
 * You may obtain a copy of the License at
    }
        values = new double[n];
            containsString(
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
            .weight(weightConfig);
                Arrays.asList(
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            assertEquals("400.00%", avg.getValueAsString());
                iw.addDocument(
                iw.addDocument(
                    new SortedNumericDocValuesField("weight_field", 1)
                Arrays.asList(
 * the Apache License, Version 2.0 (the "License"); you may
            .weight(weightConfig);
                    new SortedNumericDocValuesField("value_field", 4),
    ) throws IOException {
        });
 * this file be licensed under the Apache-2.0 license or a
                    new SortedNumericDocValuesField("weight_field", 2)
                    new SortedNumericDocValuesField("value_field", 3),
        IllegalArgumentException e = expectThrows(
            iw.addDocument(Arrays.asList(new NumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1)));
                )
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("weight_field", 3)));
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            double value = (2.0 * 2.0 + 3.0 * 2.0 + 4.0 * 2.0) / (2.0 + 2.0 + 2.0);
            .weight(weightConfig);
 * Modifications Copyright OpenSearch Contributors. See
            iw.addDocument(
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        WeightedAvgAggregationBuilder aggregationBuilder,
            iw.addDocument(
            assertEquals(Double.NaN, avg.getValue(), 0);
            );
            iw.addDocument(
    public void testFormatter() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    public void testNoMatchingField() throws IOException {
            values[i] = frequently()
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
                        new NumericDocValuesField("value_field", NumericUtils.doubleToSortableLong(value)),
            IllegalArgumentException.class,
                    new IntPoint("filter_field", 7),
            aggregator.postCollection();
 */
 * KIND, either express or implied.  See the License for the
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        try {
        });
 */
                    new SortedNumericDocValuesField("value_field", 7),
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                iw.addDocument(
                iw.addDocument(
 * compatible open source license.
            assertEquals(value, avg.getValue(), 0);
            .weight(weightConfig);
            iw.addDocument(
            assertTrue(AggregationInspectionHelper.hasValue(avg));
    public void testQueryFiltering() throws IOException {
            assertEquals(Double.NaN, avg.getValue(), 0);
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
    public void testMultiWeight() throws IOException {
                    new IntPoint("filter_field", 2),
        }, avg -> {
        });
                    )
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
    }
        verifyAvgOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
            );
            iw.addDocument(Arrays.asList(new NumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1)));
        for (int i = 0; i < n; i++) {
                )
import org.apache.lucene.search.MatchAllDocsQuery;
                        new SortedNumericDocValuesField("weight_field", 5)
                    new SortedNumericDocValuesField("value_field", 2),
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
            );
        verifyAvgOfDoubles(values, sum / n, 1e-10);
                Arrays.asList(
                Arrays.asList(
                )
            );
        });
            );
        );
            sum += values[i];
        assertThat(e.getMessage(), equalTo("Field [value_field] of type [long] does not support custom time zones"));
import org.opensearch.search.aggregations.support.MultiValuesSourceFieldConfig;
    }
        Query query,
            assertEquals(4, avg.getValue(), 0);
            assertEquals(Double.NaN, avg.getValue(), 0);
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
import java.util.Arrays;
        });
            double value = (((2.0 + 3.0) / 2.0) + ((3.0 + 4.0) / 2.0) + ((4.0 + 5.0) / 2.0)) / (1.0 + 1.0 + 1.0);
    public void testQueryFiltersAllWeights() throws IOException {
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
                    new SortedNumericDocValuesField("weight_field", 4)
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.opensearch.index.mapper.MappedFieldType;
        IllegalArgumentException e = expectThrows(
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
                    new IntPoint("value_field", 3),
        });
                        new SortedNumericDocValuesField("weight_field", 3)
 * Licensed to Elasticsearch under one or more contributor
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("weight_field", 7)));
            );
            iw.addDocument(Arrays.asList(new IntPoint("value_field", 7), new SortedNumericDocValuesField("value_field", 7)));
            );
 * ownership. Elasticsearch licenses this file to you under
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            iw.addDocument(Arrays.asList(new NumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 1)));
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            );
                    new SortedNumericDocValuesField("weight_field", 1)
            }
        );
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("weight_field", 2)));
            iw.addDocument(
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
    public void testSomeMatchesSortedNumericDocValuesWeights() throws IOException {
            directory.close();
        indexWriter.close();
            .build();
            assertEquals(3.625, avg.getValue(), 0);
        Consumer<InternalWeightedAvg> verify,
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            iw.addDocument(
            );
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))
    public void testSummationAccuracy() throws IOException {
            );
        }, avg -> {
            iw.addDocument(
        }, avg -> {
            iw.addDocument(
                )
            IllegalArgumentException.class,
            .weight(weightConfig);
                    new SortedNumericDocValuesField("value_field", 7),
            );
        }, avg -> {
        testCase(IntPoint.newRangeQuery("value_field", -1, 0), aggregationBuilder, iw -> {
            assertFalse(AggregationInspectionHelper.hasValue(avg));
                    new SortedNumericDocValuesField("weight_field", 1)
                );
 * license agreements. See the NOTICE file distributed with
            indexSearcher.search(query, aggregator);
    private void testCase(
        double[] largeValues = new double[n];
                Arrays.asList(new SortedNumericDocValuesField("value_field", 7), new SortedNumericDocValuesField("weight_field", 1))
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
import org.opensearch.common.CheckedConsumer;
        testCase(IntPoint.newRangeQuery("filter_field", 0, 3), aggregationBuilder, iw -> {
        } finally {
                    new IntPoint("value_field", 1),
            .weight(weightConfig);
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
                    )
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            iw.addDocument(
            .build();
        }, avg -> {
            .weight(weightConfig);
            .weight(weightConfig);
                    Arrays.asList(
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
                );
    }
                Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))
import org.apache.lucene.util.NumericUtils;
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
    }
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
                )
            .weight(weightConfig);
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 4), new SortedNumericDocValuesField("weight_field", 1))
            .setMissing(2)
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
    }
                Arrays.asList(new SortedNumericDocValuesField("value_field", 2), new SortedNumericDocValuesField("weight_field", 1))
            iw.addDocument(
        });
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
            );
            assertEquals(Double.NaN, avg.getValue(), 0);
                )
                        new SortedNumericDocValuesField("value_field", 2),
        testCase(IntPoint.newRangeQuery("value_field", 0, 3), aggregationBuilder, iw -> {
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
 * not use this file except in compliance with the License.
        assertThat(
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
                    new SortedNumericDocValuesField("weight_field", 1)
            assertFalse(AggregationInspectionHelper.hasValue(avg));
                    new IntPoint("filter_field", 7),
            iw.addDocument(
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            assertEquals(Double.NaN, avg.getValue(), 0);
            .weight(weightConfig);
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
            );
}
            () -> testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
    }
    public void testUnmappedValue() throws IOException {
        });
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            }, avg -> { fail("Should have thrown exception"); })
        }
                iw.addDocument(
                )
 * specific language governing permissions and limitations
            .setMissing(2)
            assertFalse(AggregationInspectionHelper.hasValue(avg));
                    )
                    new SortedNumericDocValuesField("weight_field", 3)
        WeightedAvgAggregationBuilder aggregationBuilder,
    public void testValueSetMissing() throws IOException {
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("weight_field", 4)));
        for (int i = 0; i < n; i++) {
                Arrays.asList(
 * software distributed under the License is distributed on an
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("value_field", 3)));
            // Intentionally not writing any docs
        testCase(new FieldExistsQuery("value_field"), aggregationBuilder, iw -> {
            assertEquals(2.5, avg.getValue(), 0);
                        new SortedNumericDocValuesField("value_field", 4),
                    new SortedNumericDocValuesField("weight_field", 2)
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 4), new SortedNumericDocValuesField("weight_field", 1))
import java.time.ZoneOffset;
            );
                )
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field")
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
                Arrays.asList(
                iw.addDocument(
import org.opensearch.search.aggregations.AggregationExecutionException;
                Arrays.asList(
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
        });
        );
        );
            iw.addDocument(
                    new SortedNumericDocValuesField("weight_field", 3)
        double sum = 0;
    public void testNoDocs() throws IOException {
                Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 3))
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            assertEquals(value, avg.getValue(), 0);
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
                        new SortedNumericDocValuesField("value_field", 3),
        }, avg -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("value_field", 3)));
            iw.addDocument(
            .format("0.00%");
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
import org.apache.lucene.search.FieldExistsQuery;
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            assertEquals(value, avg.getValue(), 0);
                    )
package org.opensearch.search.aggregations.metrics;
        assertThat(e.getMessage(), equalTo("Field [weight_field] of type [long] does not support custom time zones"));
                Arrays.asList(
            verify.accept((InternalWeightedAvg) aggregator.buildAggregation(0L));
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder("_name").value(valueConfig)
            .weight(weightConfig);
    }
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                        new SortedNumericDocValuesField("weight_field", 4),
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))
                    new SortedNumericDocValuesField("value_field", 3),
                "Encountered more than one weight for a single document. "
            iw.addDocument(Collections.singletonList(new SortedNumericDocValuesField("value_field", 4)));
        testCase(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
    public void testValueSetTimezone() throws IOException {
            aggregator.preCollection();
        int n = randomIntBetween(5, 10);
    public void testQueryFilteringWeights() throws IOException {
        }, avg -> {
 * this work for additional information regarding copyright
    }
    ) throws IOException {
        }, avg -> {
    }
            largeValues[i] = Double.MAX_VALUE;
                    new IntPoint("filter_field", 3),
import static java.util.Collections.singleton;
            iw.addDocument(Arrays.asList(new IntPoint("value_field", 3), new SortedNumericDocValuesField("value_field", 7)));
        }, avg -> {
                    Arrays.asList(new SortedNumericDocValuesField("value_field", 3), new SortedNumericDocValuesField("weight_field", 1))
            .build();
            largeValues[i] = -Double.MAX_VALUE;
            );
            }, avg -> { fail("Should not have executed test case"); })
            assertEquals(Double.NaN, avg.getValue(), 0);
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
public class WeightedAvgAggregatorTests extends AggregatorTestCase {
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();
        AggregationExecutionException e = expectThrows(
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
                Arrays.asList(
