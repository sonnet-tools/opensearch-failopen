    @Override
        for (MatrixStats matrix : Arrays.asList(actual)) {
        super.setUp();
    @Override  
            expectThrows(IllegalArgumentException.class, () -> matrix.getSkewness(unknownField));
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(getDefaultNamedXContents());
            case 3:  
                break;  
    }
    public void testReduceRandom() {
import org.opensearch.search.aggregations.Aggregation;  
}
            double valueA = randomDouble();
    protected void assertReduced(InternalMatrixStats reduced, List<InternalMatrixStats> inputs) {
import java.util.function.Predicate;  
            PipelineTree.EMPTY  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }
                runningStats = new RunningStats(fieldNames);
                    matrixStatsResults = null;  
 * Unless required by applicable law or agreed to in writing,
 *
    @Override
import org.opensearch.common.util.MockPageCacheRecycler;
import org.opensearch.test.InternalAggregationTestCase;  
            expectThrows(IllegalArgumentException.class, () -> matrix.getKurtosis(unknownField));  
    protected void assertFromXContent(InternalMatrixStats expected, ParsedAggregation parsedAggregation) throws IOException {  
            // getFieldCount returns 0 for unknown fields  
import org.opensearch.common.util.MockBigArrays;
        hasMatrixStatsResults = frequently();  
        return namedXContents;
        MatrixStatsResults matrixStatsResults = hasMatrixStatsResults ? new MatrixStatsResults(runningStats) : null;
import org.opensearch.script.ScriptService;
    }  
 *  
    @Override
        for (int i = 0; i < numFields; i++) {  
import org.opensearch.search.aggregations.matrix.stats.InternalMatrixStats.Fields;
import org.opensearch.search.aggregations.matrix.MatrixAggregationModulePlugin;  
        RunningStats runningStats = instance.getStats();  
            bValues.add(valueB);
            assertEquals(0.0, matrix.getFieldCount(unknownField), 0.0);
 *
import java.util.Map;
    protected SearchPlugin registerPlugin() {
            expectThrows(IllegalArgumentException.class, () -> matrix.getCovariance(unknownField, other));  
    public void setUp() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;  
    }
    @Override  
                for (int i = 0; i < fields.length; i++) {
        assertTrue(parsedAggregation instanceof ParsedMatrixStats);
    @Override
        Map<String, Object> metadata = instance.getMetadata();
 * software distributed under the License is distributed on an
        MultiPassStats multiPassStats = new MultiPassStats("a", "b");  
 * KIND, either express or implied.  See the License for the
                metadata.put(randomAlphaOfLength(15), randomInt());
                break;
    @Override
                runningStats = new RunningStats(fields);
                    values[i] = randomDouble() * 200;  
            expectThrows(IllegalArgumentException.class, () -> matrix.getVariance(unknownField));
                valuePerShardCounter = 0;
            shardResults.add(new InternalMatrixStats("_name", 1L, runningStats, null, Collections.emptyMap(), runningStats.fieldNames));
            fields[i] = "field_" + i;
import java.util.HashMap;  
 */  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
        namedXContents.add(new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(MatrixStatsAggregationBuilder.NAME), parser));  
    protected InternalMatrixStats mutateInstance(InternalMatrixStats instance) {  
    private boolean hasMatrixStatsResults;
        double[] values = new double[fields.length];  
 */
            if (++valuePerShardCounter == valuesPerShard) {
        }  
        }
import java.util.Collections;
import org.opensearch.plugins.SearchPlugin;
        List<Double> aValues = new ArrayList<>();  
            case 2:
 * the Apache License, Version 2.0 (the "License"); you may
        runningStats.add(fields, values);  
                if (metadata == null) {
            expectThrows(IllegalArgumentException.class, () -> matrix.getCorrelation(unknownField, other));
        throw new UnsupportedOperationException();
 * ownership. Elasticsearch licenses this file to you under  
            b -> {},
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        return path -> path.endsWith(Fields.CORRELATION) || path.endsWith(Fields.COVARIANCE);
        final String other = randomValueOtherThan(unknownField, () -> randomAlphaOfLength(3));
 * GitHub history for details.
        fields = new String[numFields];
import org.opensearch.core.ParseField;  
            expectThrows(IllegalArgumentException.class, () -> matrix.getCovariance(unknownField, unknownField));
        int numFields = hasMatrixStatsResults ? randomInt(128) : 0;
        return new MatrixAggregationModulePlugin();  
            case 1:
import org.opensearch.core.xcontent.ContextParser;
    protected List<NamedXContentRegistry.Entry> getNamedXContents() {  
            }  
        long docCount = instance.getDocCount();
                if (matrixStatsResults == null) {  
    }  
    }
        String name = instance.getName();
        assertEquals(expected.getDocCount(), actual.getDocCount());
 * Licensed to Elasticsearch under one or more contributor  
            bigArrays,  
import org.opensearch.common.settings.Settings;  
            assertEquals(expected.getMean(field), actual.getMean(field), 0.0);
                assertEquals(expected.getCorrelation(field, other), actual.getCorrelation(field, other), 0.0);  
                    metadata = new HashMap<>(1);  
            expectThrows(IllegalArgumentException.class, () -> matrix.getCorrelation(other, unknownField));
            default:
        List<Double> bValues = new ArrayList<>();
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
/*
    protected InternalMatrixStats createTestInstance(String name, Map<String, Object> metadata) {
            assertEquals(expected.getSkewness(field), actual.getSkewness(field), 0.0);
    }
                } else {
                    metadata = new HashMap<>(instance.getMetadata());
            values[i] = randomDouble();
 * not use this file except in compliance with the License.
        return new InternalMatrixStats(name, 1L, runningStats, matrixStatsResults, metadata, runningStats.fieldNames);
            expectThrows(IllegalArgumentException.class, () -> matrix.getMean(unknownField));  
        List<InternalAggregation> shardResults = new ArrayList<>();
    }  
        int valuesPerShard = (int) Math.floor(numValues / numShards);
            expectThrows(IllegalArgumentException.class, () -> matrix.getCovariance(other, unknownField));
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ParsedMatrixStats actual = (ParsedMatrixStats) parsedAggregation;
                String[] fields = Arrays.copyOf(this.fields, this.fields.length + 1);
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            double valueB = randomDouble();
                name += randomAlphaOfLength(5);
            assertEquals(expected.getVariance(field), actual.getVariance(field), 0.0);  
            assertEquals(expected.getFieldCount(field), actual.getFieldCount(field));
 * this work for additional information regarding copyright
                break;
                    matrixStatsResults = new MatrixStatsResults(runningStats);
        for (int i = 0; i < numValues; i++) {
        String[] fieldNames = new String[] { "a", "b" };
 * under the License.  
        return new InternalMatrixStats(name, docCount, runningStats, matrixStatsResults, metadata, runningStats.fieldNames);
    @Override  
                double[] values = new double[fields.length];
/*  
                runningStats.add(fields, values);  
 */
            assertEquals(1.0, matrix.getCorrelation(unknownField, unknownField), 0.0);  
    private String[] fields;
        ScriptService mockScriptService = mockScriptService();  
                }
            assertEquals(expected.getKurtosis(field), actual.getKurtosis(field), 0.0);
/*
            case 0:
package org.opensearch.search.aggregations.matrix.stats;
        }  
        final String unknownField = randomAlphaOfLength(3);
        RunningStats runningStats = new RunningStats(fieldNames);  
                }  
        multiPassStats.computeStats(aValues, bValues);
        );
        switch (between(0, 3)) {  
    }  
    @Override
        }  
                } else {
                assertEquals(expected.getCovariance(field, other), actual.getCovariance(field, other), 0.0);
 * license agreements. See the NOTICE file distributed with
            }
                fields[fields.length - 1] = "field_" + (fields.length - 1);  
            mockScriptService,
                break;
        if (valuePerShardCounter != 0) {  
 * compatible open source license.
        }
import java.util.List;
        int numShards = randomIntBetween(1, 20);
        }
        for (int i = 0; i < fields.length; i++) {
        ContextParser<Object, Aggregation> parser = (p, c) -> ParsedMatrixStats.fromXContent(p, (String) c);
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        RunningStats runningStats = new RunningStats(fields);
 * specific language governing permissions and limitations
            runningStats.add(fieldNames, new double[] { valueA, valueB });
import org.opensearch.search.aggregations.InternalAggregation;
            aValues.add(valueA);  
        int numValues = 10000;  
        }
    protected Predicate<String> excludePathsFromXContentInsertion() {
                shardResults.add(new InternalMatrixStats("_name", 1L, runningStats, null, Collections.emptyMap(), runningStats.fieldNames));  
        multiPassStats.assertNearlyEqual(reduced.getResults());  
            for (String other : fields) {
        for (String field : fields) {  
        MatrixStatsResults matrixStatsResults = instance.getResults();
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
        InternalMatrixStats reduced = (InternalMatrixStats) shardResults.get(0).reduce(shardResults, context);
        int valuePerShardCounter = 0;  
import java.util.Arrays;
import org.opensearch.search.aggregations.ParsedAggregation;
public class InternalMatrixStatsTests extends InternalAggregationTestCase<InternalMatrixStats> {
