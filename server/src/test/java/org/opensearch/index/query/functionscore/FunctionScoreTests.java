        FieldValueFactorFunction.Modifier.LN,
        public LeafNumericFieldData load(LeafReaderContext context) {
        checkFunctionScoreExplanation(functionExplanation, "field value function: ln(doc['test'].value?:1.0 * factor=1.0)");
            };
        ScoreFunction otherFunction = new DummyScoreFunction(combineFunction);
            function,  
            CombineFunction.REPLACE,  
        protected ConstantScoreFunction(double value) {
package org.opensearch.index.query.functionscore;
    /**
            null,
        Explanation explanation = randomExplanation.getDetails()[0];
    private static final String TEXT = "The way out is through.";
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
            maxBoost
        protected boolean doEquals(ScoreFunction other) {
                        }  
        0.1,  
            randomBoolean() ? new ScoreFunction[] { function, otherFunc } : new ScoreFunction[] { otherFunc },
        CombineFunction combineFunction = randomFrom(CombineFunction.values());
                @Override
import static org.hamcrest.core.Is.is;
            searcher,  
        assertThat(  
            functionExplanation.getDetails()[0].getDetails()[0].toString(),  
            combineFunction,
        FunctionScoreQuery fsQuery1 = new FunctionScoreQuery(  
            CombineFunction.REPLACE,
        "func1"
        );
            equalTo(  
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, LIN_DECAY_FUNCTION);
            if (left == right) {
        Explanation explanation = weight.explain(searcher.getIndexReader().leaves().get(0), 0);
            minScore,
            )
        assertThat(randomExplanation.getDescription(), equalTo("min of:"));  
            )
        assertThat(randomExplanation.getDetails()[0].getDescription(), containsString(functionExpl));
            equalTo("0.1 = exp(- " + "MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455)\n")  
            randomFrom(ScoreMode.values()),
        private double score;
            )
 * ownership. Elasticsearch licenses this file to you under  
            Float.MAX_VALUE
        for (boolean needsScore : new boolean[] { true, false }) {  
        }
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
        MultiValueMode.MAX,  
        for (int i = 0; i < numIters; i++) {
        1.0,  
                CombineFunction.MULTIPLY,  
        FunctionScoreQuery.ScoreMode scoreMode,  
        new IndexNumericFieldDataStub(),  
        Document d = new Document();
            this.score = score;
/*
            functionExplanation.getDetails()[0].getDetails()[0].toString(),  
            equalTo(
        checkFunctionScoreExplanation(functionExplanation, "product of:");
                            return new BytesRef("0");
                public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
    );
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
        }
            termQuery,
            new TermQuery(new Term(FIELD, "out")),  
        );  
        );  
                assertNotEquals(left + " == " + right, left, right);
        0,  
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.util.Accountable;  
                assertNotEquals(left + " == " + right, left, right);
            filterFunctions,
        }
            maxBoost
                    return Explanation.match((float) score, "a random score for testing");  
        w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
        assertThat(scoreWithWeight / (float) max, is(1f));
import org.junit.Before;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                public SortedNumericDoubleValues getDoubleValues() {  
                }
        assertThat(exc.getMessage(), containsString("consider using ln1p or ln2p instead of ln to avoid negative scores"));
            new CombineFunction[] {
                @Override
            maxBoost == 1.0f ? 0.9f : 1.0f
        0,
        );
        1.0,  
            weightFunctionStubs[i] = new WeightFactorFunction(weights[i], scoreFunctionStubs[i]);
        FunctionScoreQuery q1 = new FunctionScoreQuery(  
                        public BytesRef nextValue() {
                    + "(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594, _name: func1)\n"  
        IndexSearcher searcher = newSearcher(reader);  
        assertThat(
            CombineFunction.REPLACE,
            scoreFunctions
        protected int doHashCode() {
            termQuery,
        WeightFactorFunction[] weightFunctionStubs = new WeightFactorFunction[numFunctions];
                @Override  
        functionExplanation = getFunctionScoreExplanation(searcher, FIELD_VALUE_FACTOR_FUNCTION);  
        LinearDecayFunctionBuilder.LINEAR_DECAY_FUNCTION,
            combineFunction,  
            combineFunction,  
        MultiValueMode.MAX,
import org.apache.lucene.search.Explanation;
            assertEquals(needsScore, function.needsScores());
        }  
        FunctionScoreQuery diffQuery = new FunctionScoreQuery(
        }
                    + " - 0.0(=offset), 0)])/1.1111111111111112)\n"  
                "0.1 = max(0.0, ((1.1111111111111112 - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin)))"
                    throw new UnsupportedOperationException(UNSUPPORTED);
            };
        ScoreFunction[] filterFunctions = new ScoreFunction[scoreFunctions.length];
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
    public void testFilterFunctionScoreHashCodeAndEquals() {
                        public int docValueCount() {
    protected Explanation getExplanation(IndexSearcher searcher, FunctionScoreQuery functionScoreQuery) throws IOException {  
        assertThat(functionExplanation.getDetails()[1].getDescription(), equalTo(functionExpl));
            return false;
                    return value;  
            new TermQuery(new Term("foo", "bar")),  
    }
        checkFiltersFunctionScoreExplanation(functionExplanation, "field value function: ln(doc['test'].value?:1.0 * factor=1.0)", 1);
        assertThat(exc.getMessage(), containsString("consider using log1p or log2p instead of log to avoid negative scores"));
    }  
            return false;  
import org.opensearch.search.DocValueFormat;
                    return new SortedNumericDoubleValues() {
            new TermQuery(new Term("foo", "baz")),
    }
        assertThat(score, equalTo(2.0f));
 */  
            maxBoost
        assertThat(
        double[] values = new double[size];
                }
            new WeightFactorFunction(2),  
            functionExplanation.getDetails()[0].getDetails()[4].getDetails()[1].getDetails()[0].toString(),  
            return false;
                public boolean needsScores() {
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
        Explanation queryExpl = searcher.explain(query, 0);  
                @Override
    private static class IndexFieldDataStub implements IndexFieldData<LeafFieldData> {  
        protected boolean doEquals(ScoreFunction other) {  
        FunctionScoreQuery fsq = new FunctionScoreQuery(query, null, Float.POSITIVE_INFINITY);  
            sum += weights[i] * scores[i];  
        assertEquals(queryExpl.getValue(), ffsqExpl.getValue());
        MultiValueMode.MAX,  
            scoreFunctionStubs[i] = new ScoreFunctionStub(scores[i]);  
                }  
        assertThat(functionExplanation.getDetails()[0].getDescription(), equalTo("match filter: " + FIELD + ":" + TERM.text()));  
        float score = topDocsWithWeights.scoreDocs[0].score;  
            null,
        IndexSearcher localSearcher = new IndexSearcher(reader);  
import org.opensearch.common.lucene.search.function.ScoreFunction;
            weightFunctionStubs  
        @Override  
        FunctionScoreQuery filtersFunctionScoreQueryWithWeights = new FunctionScoreQuery(
        assertFalse(ffsqExpl.isMatch());  
        }
import org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode;
 * Unless required by applicable law or agreed to in writing,
        assertThat(functionExplanation.getDetails()[0].getDetails()[4].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));  
        ExponentialDecayFunctionBuilder.EXP_DECAY_FUNCTION,  
            function,
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
import java.util.concurrent.ExecutionException;  
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
        null,
        FunctionScoreQuery functionScoreQuery = getFiltersFunctionScoreQuery(
        checkFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test, _name: func1)");
    private static final ScoreFunction FIELD_VALUE_FACTOR_FUNCTION_NAMED = new FieldValueFactorFunction(
import org.opensearch.index.fielddata.ScriptDocValues;
 * under the License.  
    }  
        public boolean needsScores() {
                @Override  
            SortOrder sortOrder,
        searcher = newSearcher(reader);
        final int numIters = randomIntBetween(20, 100);  
    private static float[] randomPositiveFloats(int size) {
            values[i] = randomFloat() * randomInt(100) + 1.e-5f;
            return false;
            scoreMode,
        ExponentialDecayFunctionBuilder.EXP_DECAY_FUNCTION,
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
    private static class DummyScoreFunction extends ScoreFunction {
                }
        FieldValueFactorFunction.Modifier.LN,
                }
        assertThat(exc.getMessage(), containsString("function score query returned an invalid score: " + Float.NaN));  
            function,
        }
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
        searchResult = localSearcher.search(query, 1);  
            WeightFactorFunction function = new WeightFactorFunction(10.0f, new ScoreFunction(CombineFunction.REPLACE) {
        TopDocs topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
        functionExplanation = getFunctionScoreExplanation(searcher, new WeightFactorFunction(4, RANDOM_SCORE_FUNCTION_NAMED));
                        public boolean advanceExact(int docId) {  
                assertEquals(left, right);
    }
        // test that field_value_factor function using modifier ln throws an exception on negative scores  
        assertThat(explainedScore / scoreWithWeight, is(1f));  
        assertThat(
        @Override
        assertThat(explainedScore / scoreWithWeight, is(1f));  
            return new LeafScoreFunction() {
        protected boolean sortRequiresCustomComparator() {
        }  
        @Override
        @Override
     * Stub for IndexFieldData. Needed by some score functions. Returns 1 as count always.
            return new LeafScoreFunction() {  
            minScore == null ? 1.0f : null,
        1,
        Explanation explanation = localSearcher.explain(query, searchResult.scoreDocs[0].doc);
        TopDocs topDocsWithWeights = searcher.search(filtersFunctionScoreQueryWithWeights, 1);
                public ScriptDocValues getScriptValues() {
            FunctionScoreQuery.ScoreMode.MULTIPLY,
        ScoreFunction scoreFunction = new DummyScoreFunction(combineFunction);
            CombineFunction.AVG,  
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(  
 * specific language governing permissions and limitations
        );  
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));
        FunctionScoreQuery diffMaxBoost = new FunctionScoreQuery(
        return values;  
        for (org.apache.lucene.search.ScoreMode scoreMode : org.apache.lucene.search.ScoreMode.values()) {
    }  
    }
            Float.MAX_VALUE
        assertEquals(q, q);
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                public Collection<Accountable> getChildResources() {
import org.apache.lucene.store.Directory;
            CombineFunction.REPLACE,
import org.opensearch.common.lucene.search.function.WeightFactorFunction;  
    );
    }
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));  
        );
        new IndexNumericFieldDataStub(),
        }
            functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].toString(),
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");  
        1,
        new IndexNumericFieldDataStub(),
    private static final ScoreFunction EXP_DECAY_FUNCTION_NAMED = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
        }
        new IndexNumericFieldDataStub(),  
        FunctionScoreQuery query = new FunctionScoreQuery(
        checkFunctionScoreExplanation(functionExplanation, "product of:");  
        }  
        reader.close();
        assertThat(
    }  
        functionExplanation = getFunctionScoreExplanation(searcher, LIN_DECAY_FUNCTION);
                        public boolean advanceExact(int docId) {  
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));  
    public void testExceptionOnNegativeScores() {  
        return new FunctionScoreQuery(
            fvfFunction,  
import org.apache.lucene.index.IndexWriter;  
    public void testExceptionOnLogNegativeScores() {
                @Override
            endsWith("random score function (seed: 0, field: test, _name: func1)\n")  
        assertEquals(q.hashCode(), q.hashCode());  
                        @Override  
                }
        FunctionScoreQuery diffFunction = new FunctionScoreQuery(q.getSubQuery(), otherFunction, combineFunction, minScore, maxBoost);  
            function,
        @Override
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].toString(), equalTo("4.0 = weight\n"));
                            return true;
        d.add(new TextField(FIELD, TEXT, Field.Store.YES));  
        sum = 0;  
        Float minScore = randomBoolean() ? null : 1.0f;  
        FunctionScoreQuery functionScoreQuery = new FunctionScoreQuery(new TermQuery(TERM), scoreFunction, CombineFunction.AVG, 0.0f, 100);
        ScoreFunctionStub[] scoreFunctionStubs = new ScoreFunctionStub[numFunctions];
        Explanation ffsqExpl = searcher.explain(ffsq, 0);
        );  
import org.apache.lucene.index.DirectoryReader;
        0,  
        assertThat(functionExplanation.getDetails()[0].getDetails()[3].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
        protected DummyScoreFunction(CombineFunction scoreCombiner) {  
        );
        assertEquals(q.hashCode(), q.hashCode());
        dir.close();  
                "0.1 = exp(-0.5*pow(MAX[Math.max(Math.abs"  
        final ScoreFunction fvfFunction = new FieldValueFactorFunction(FIELD, 0.5f, modifier, 1.0, new IndexNumericFieldDataStub());
        );
    }  
            new MatchAllDocsQuery(),
        assertTrue(fsqExpl.isMatch());
        }
            weightFunctionStubs
        protected boolean doEquals(ScoreFunction other) {
            CombineFunction.REPLACE,  
        double score = 1;  
                    throw new UnsupportedOperationException(UNSUPPORTED);  
import org.apache.lucene.document.TextField;
        @Override
    }
        assertThat(scoreWithWeight / (float) sum, is(1f));
        );
        }
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> localSearcher.search(fsQuery1, 1));
        "test",  
                            return 1;  
 * The OpenSearch Contributors require contributions made to  
                @Override
        "func1"  
        double max = Double.NEGATIVE_INFINITY;  
        @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testMinScoreExplain() throws IOException {
        for (int i = 0; i < numIters; i++) {
            Float.POSITIVE_INFINITY
            combineFunction,  
        public ValuesSourceType getValuesSourceType() {
        assertThat(
            maxBoost
        MultiValueMode.MAX,
    private static final ScoreFunction LIN_DECAY_FUNCTION = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
            )
            throw new UnsupportedOperationException(UNSUPPORTED);  
                    + " - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)])/1.1111111111111112)\n"
            throw new UnsupportedOperationException(UNSUPPORTED);
                public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {  
        Query query = new RandomApproximationQuery(new MatchAllDocsQuery(), random());
                @Override  
            new TermQuery(new Term("foo", "bar")),
                @Override
    private static final ScoreFunction RANDOM_SCORE_FUNCTION_NAMED = new RandomScoreFunction(0, 0, new IndexFieldDataStub(), "func1");
        return explanation.getDetails()[1];
import org.opensearch.common.util.BigArrays;
        }  
            super(CombineFunction.REPLACE);  
            FunctionScoreQuery.ScoreMode.SUM,  
            };
            function,  
        0,  
            });  
    private static final Term TERM = new Term(FIELD, "through");
                        }  
            functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].toString(),
            )
        }
     */  
        checkFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test)");  
    @Before
                CombineFunction.MAX,
            equalTo(
            Weight weight = searcher.createWeight(fsq, scoreMode, 1f);
        assertThat(functionExplanation.getDescription(), equalTo("function score, product of:"));
            minScore,
            return 0;
        double norm = 0;
            function,  
    private static final ScoreFunction EXP_DECAY_FUNCTION = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, GAUSS_DECAY_FUNCTION);
        public NumericType getNumericType() {
        @Override
 * compatible open source license.
        IndexSearcher localSearcher = newSearcher(reader);
            new TermQuery(new Term("foo", "bar")),
        Float maxBoost = randomBoolean() ? Float.POSITIVE_INFINITY : randomFloat();  
                "0.1 = exp(- MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455, _name: func1)\n"
        assertThat(  
                @Override
        0,
            MultiValueMode sortMode,
        0,  
            return other == this;
            new TermQuery(new Term("foo", "baz")),
        null
        GaussDecayFunctionBuilder.GAUSS_DECAY_FUNCTION,
            equalTo(  
        LinearDecayFunctionBuilder.LINEAR_DECAY_FUNCTION,
        public boolean needsScores() {  
        TermQuery termQuery = new TermQuery(new Term(FIELD, "out"));
            new TermQuery(new Term(FIELD, "out")),
        );  
            Float.POSITIVE_INFINITY  
        Weight weight = searcher.createWeight(searcher.rewrite(functionScoreQuery), org.apache.lucene.search.ScoreMode.COMPLETE, 1f);  
    public void testWeightOnlyCreatesBoostFunction() throws IOException {  
        assertThat(randomExplanation.getDescription(), equalTo("min of:"));
 *
        0.1,
            combineFunction,
    private static class ScoreFunctionStub extends ScoreFunction {  
            EXP_DECAY_FUNCTION,
                            return true;
                }  
            null,
                @Override  
import org.apache.lucene.search.Scorer;
        for (int i = 0; i < values.length; i++) {  
            combineFunction,
        }
        );  
        float[] values = new float[size];
        checkFunctionScoreExplanation(functionExplanation, "field value function(_name: func1): ln(doc['test'].value?:1.0 * factor=1.0)");  
        FunctionScoreQuery[] queries = new FunctionScoreQuery[] { diffQuery, diffMaxBoost, diffMinScore, diffFunc, q, diffCombineFunc };
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
        for (int i = 0; i < weights.length; i++) {
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
                public SortedBinaryDocValues getBytesValues() {  
import org.junit.After;
        // test that field_value_factor function throws an exception on negative scores
        }
                        public double nextValue() {
                protected boolean doEquals(ScoreFunction other) {
import org.apache.lucene.document.Document;
        searcher.setQueryCache(null); // otherwise we could get a cached entry that does not have approximations
                "0.1 = max(0.0, ((1.1111111111111112"
        }
        0,
        0.1,  
        CombineFunction combineFunction,
        @Override
    );
        );
            Object missingValue,
        null
    }  
import org.opensearch.common.lucene.search.function.FunctionScoreQuery.FilterScoreFunction;
        }
            } else {
            maxBoost  
        // now test all together
 * SPDX-License-Identifier: Apache-2.0
        ScoreFunction function = new DummyScoreFunction(combineFunction);  
 * this work for additional information regarding copyright
            return false;  
    @After
        );
                }  
        assertThat(
    }  
        functionExplanation = getFunctionScoreExplanation(searcher, GAUSS_DECAY_FUNCTION);
        }
                }
        assertThat(explainedScore / scoreWithWeight, is(1f));
            function,
    ) {  
        assertThat(explainedScore / scoreWithWeight, is(1f));
            new TermQuery(new Term(FIELD, "out")),
            )  
        FunctionScoreQuery query1 = new FunctionScoreQuery(
import org.apache.lucene.search.TopDocs;
    }
        float scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
 * license agreements. See the NOTICE file distributed with
    }  
                            return 1;  
            values[i] = rand * randomInt(100) + 1.e-5d;
                }
        FilterScoreFunction function = new FilterScoreFunction(new TermQuery(new Term("filter", "query")), scoreFunction);
                assertEquals(left.hashCode(), right.hashCode());  
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 0);
            functionExplanation.getDetails()[0].getDetails()[3].getDetails()[1].getDetails()[0].toString(),
        FunctionScoreQuery query2 = new FunctionScoreQuery(
            new ConstantScoreFunction(Float.NEGATIVE_INFINITY),  
            equalTo(
            maxBoost  
            weightFunctionStubs  
    );  
                public ScriptDocValues getScriptValues() {
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));
    );
        assertThat(scoreWithWeight / (float) score, is(1f));
            };
    public void testExplainFiltersFunctionScoreQuery() throws IOException {
                    return 0;
        }  
        FunctionScoreQuery q = new FunctionScoreQuery(new TermQuery(new Term("foo", "bar")), function, combineFunction, minScore, maxBoost);  
            score *= weights[i] * scores[i];
                CombineFunction.AVG,  
        float maxBoost = randomBoolean() ? Float.POSITIVE_INFINITY : randomFloat();
        Explanation functionExplanation = getFunctionScoreExplanation(searcher, RANDOM_SCORE_FUNCTION_NAMED);
    }
            functionExplanation.getDetails()[0].getDetails()[0].toString(),  
                    throw new UnsupportedOperationException(UNSUPPORTED);
                public Collection<Accountable> getChildResources() {
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
            XFieldComparatorSource.Nested nested,
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;  
        Explanation functionExplanation = getFunctionScoreExplanation(searcher, RANDOM_SCORE_FUNCTION);
                    };
        }
        );  
            100  
            minScore == null ? 0.9f : null,
        assertThat(
        0.1,
}  
        assertThat(  
            equalTo("0.1 = exp(- MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455)\n")
        }  
        );
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);  
        @Override
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
        0,
import org.apache.lucene.util.BytesRef;
        );
                assertEquals(left.hashCode(), right.hashCode());  
            min = Math.min(min, weights[i] * scores[i]);
                public void close() {}
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));  
            minScore,  
 * not use this file except in compliance with the License.
        FunctionScoreQuery diffFunc = new FunctionScoreQuery(
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> localSearcher.search(fsQuery1, 1));
        final ScoreFunction fvfFunction = new FieldValueFactorFunction(FIELD, 0.5f, modifier, 1.0, new IndexNumericFieldDataStub());
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
            new TermQuery(new Term("foo", "bar")),
            GAUSS_DECAY_FUNCTION,  
            Float.NEGATIVE_INFINITY,  
    private static double[] randomPositiveDoubles(int size) {  
        for (int i = 0; i < weights.length; i++) {
        TermQuery termQuery = new TermQuery(new Term(FIELD, "out"));
            fvfFunction,
        float[] weights = randomPositiveFloats(numFunctions);
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            LIN_DECAY_FUNCTION
        FunctionScoreQuery diffMinScore = new FunctionScoreQuery(
 * Licensed to Elasticsearch under one or more contributor  
        // check for document that has no matching function
        );  
 * the Apache License, Version 2.0 (the "License"); you may
        public boolean needsScores() {
            FunctionScoreQuery.ScoreMode.MAX,
            new TermQuery(TERM),  
        @Override  
        }
import org.apache.lucene.index.SortedNumericDocValues;
        );  
            throw new UnsupportedOperationException(UNSUPPORTED);  
        MultiValueMode.MAX,
            Float.POSITIVE_INFINITY  
import org.opensearch.index.fielddata.IndexNumericFieldData;
    private IndexSearcher searcher;
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");  
                "0.1 = max(0.0, ((1.1111111111111112 - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin)))"
import static org.hamcrest.CoreMatchers.containsString;
        Explanation functionExplanation = randomExplanation.getDetails()[0].getDetails()[whichFunction];
            equalTo("0.1 = exp(- MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455)\n")
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
    private static class IndexNumericFieldDataStub extends IndexNumericFieldData {
            Float.MAX_VALUE * -1,
                            return 1d;
        IndexSearcher localSearcher = new IndexSearcher(reader);  
            boolean reverse
        1,
    public void closeAllTheReaders() throws IOException {  
    private static final ScoreFunction GAUSS_DECAY_FUNCTION = new DecayFunctionBuilder.NumericFieldDataScoreFunction(  
        public ValuesSourceType getValuesSourceType() {
            FIELD_VALUE_FACTOR_FUNCTION,
        @Override  
        public String getFieldName() {  
        @Override
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
        Explanation fsqExpl = searcher.explain(fsq, 0);  
            CombineFunction.REPLACE,  
        Explanation functionExplanation = getFiltersFunctionScoreExplanation(searcher, RANDOM_SCORE_FUNCTION);
        // check for document that has a matching function
                    + " - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)])/1.1111111111111112, _name: func1)\n"  
import org.apache.lucene.index.Term;  
            return new LeafFieldData() {
            maxBoost
        FunctionScoreQuery fsQuery1 = new FunctionScoreQuery(  
        @Override  
        1,  
        FunctionScoreQuery fsQuery1 = new FunctionScoreQuery(
        );
                        @Override
        }
        explanation = localSearcher.explain(query, searchResult.scoreDocs[0].doc);
    }
        @Override
        );  
                    throw new UnsupportedOperationException(UNSUPPORTED);
        assertThat(scoreWithWeight / (float) min, is(1f));  
        assertEquals(queryExpl.getValue(), fsqExpl.getValue());
            minScore,
    }
                "0.1 = exp(-0.5*pow(MAX[Math.max(Math.abs"
        @Override
        Query query = new MatchAllDocsQuery();
        @Override
                    + "(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594)\n"
            new ConstantScoreFunction(Float.NaN),  
    private static final ScoreFunction FIELD_VALUE_FACTOR_FUNCTION = new FieldValueFactorFunction(
        }
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.LOG;
        assertEquals(q.hashCode(), q1.hashCode());
        );
import org.opensearch.search.MultiValueMode;
            return "test";
            new TermQuery(new Term("foo", "bar")),
                    + " - 0.0(=offset), 0)])/1.1111111111111112)\n"
        );
        @Override
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
            new FilterScoreFunction(new TermQuery(new Term("_uid", "1")), new WeightFactorFunction(10)),
                }
                    throw new UnsupportedOperationException(UNSUPPORTED);  
    public Explanation getFiltersFunctionScoreExplanation(IndexSearcher searcher, ScoreFunction... scoreFunctions) throws IOException {  
        public LeafFieldData loadDirect(LeafReaderContext context) throws Exception {
            CombineFunction.REPLACE,  
                CombineFunction.REPLACE }
            Float.MAX_VALUE
        }
import org.opensearch.common.lucene.search.function.CombineFunction;
        );
        return getExplanation(searcher, functionScoreQuery).getDetails()[1];  
            Float.POSITIVE_INFINITY  
            super(CombineFunction.REPLACE);
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));  
        FunctionScoreQuery diffQuery = new FunctionScoreQuery(  
            BigArrays bigArrays,  
        return values;  
        fsqExpl = searcher.explain(fsq, 0);  
        );
        w.close();
        MultiValueMode.MAX,
            MultiValueMode sortMode,  
    );
        "func1"
        FunctionScoreQuery q = new FunctionScoreQuery(new TermQuery(new Term("foo", "bar")), function, combineFunction, minScore, maxBoost);
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 0);
                    return null;
        "test",  
        );
        public BucketedSort newBucketedSort(
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 2);
            return "test";  
    public void testFunctionScoreHashCodeAndEquals() {
        null  
        functionExplanation = getFunctionScoreExplanation(searcher, EXP_DECAY_FUNCTION);  
                    return false;
import org.apache.lucene.search.IndexSearcher;
                protected int doHashCode() {  
        }
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
 */  
        assertThat(searchResult.scoreDocs[0].score, equalTo(explanation.getValue()));
        );
/*  
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
            throw new UnsupportedOperationException(UNSUPPORTED);
        assertEquals(q, q);
 * software distributed under the License is distributed on an
            FunctionScoreQuery.ScoreMode.MIN,
                public SortedBinaryDocValues getBytesValues() {
            @Nullable Object missingValue,
    }
                        }
    public void testExceptionOnLnNegativeScores() {
        CombineFunction combineFunction = randomFrom(CombineFunction.values());  
    }
        @Override  
        fsq = new FunctionScoreQuery(query, 10f, Float.POSITIVE_INFINITY);
import static org.hamcrest.CoreMatchers.endsWith;  
    }  
        FunctionScoreQuery diffMaxBoost = new FunctionScoreQuery(
            combineFunction == CombineFunction.AVG ? CombineFunction.MAX : CombineFunction.AVG,  
        );  
        );
                        }
public class FunctionScoreTests extends OpenSearchTestCase {
        0,
        0.1,
        FunctionScoreQuery functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
        dir = newDirectory();  
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
        assertFalse(fsqExpl.isMatch());
        FilterScoreFunction otherFunc = new FilterScoreFunction(new TermQuery(new Term("filter", "other_query")), scoreFunction);
        for (int i = 0; i < weights.length; i++) {
            throw new UnsupportedOperationException(UNSUPPORTED);
        OpenSearchException exc = expectThrows(OpenSearchException.class, () -> localSearcher.search(query1, 1));
        checkFiltersFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test)", 0);  
        }  
        final int numIters = randomIntBetween(20, 100);  
        }
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 3);  
            weightFunctionStubs
        "func1"
        );  
                "0.1 = "  
import static org.hamcrest.core.IsNot.not;  
import org.opensearch.index.fielddata.IndexFieldData;
        );  
        }
        1,  
        }
        final ScoreFunction fvfFunction = new FieldValueFactorFunction(FIELD, -10, modifier, 1.0, new IndexNumericFieldDataStub());  
        return weight.explain(searcher.getIndexReader().leaves().get(0), 0);
                CombineFunction.SUM,
        d.add(new TextField("_uid", "1", Field.Store.YES));
    private static final String UNSUPPORTED = "Method not implemented. This is just a stub for testing.";
                    throw new UnsupportedOperationException(UNSUPPORTED);  
        reader = DirectoryReader.open(w);
            new TermQuery(new Term("foo", "bar")),
            super(scoreCombiner);
        TopDocs searchResult = localSearcher.search(query, 1);  
import org.apache.lucene.search.Weight;  
                CombineFunction.MIN,
            Scorer scorer = weight.scorer(reader.leaves().get(0));  
    }  
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
        @Override
        @Override  
                public double score(int docId, float subQueryScore) throws IOException {
                    throw new UnsupportedOperationException(UNSUPPORTED);
            equalTo(
                        @Override
                public void close() {}  
        1,
            equalTo("1.0 = constant score 1.0 - no function provided\n")
            CombineFunction.REPLACE,
        0,
    }
            return false;  
                        public int docValueCount() {
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 4);
        0,
            equalTo(
            minScore,
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> localSearcher.search(fsQuery1, 1));
        );  
        FunctionScoreQuery diffCombineFunc = new FunctionScoreQuery(  
        assertThat(explanation.getDescription(), equalTo("function score, score mode [avg]"));  
        Weight weight = searcher.createWeight(searcher.rewrite(functionScoreQuery), org.apache.lucene.search.ScoreMode.COMPLETE, 1f);
        @Override
            function,
            int bucketSize,  
                "0.1 = "  
                        }
            FunctionScoreQuery left = randomFrom(queries);
import org.apache.lucene.document.Field;  
                public SortedNumericDocValues getLongValues() {
import org.opensearch.OpenSearchException;
    public void testSimpleWeightedFunction() throws IOException, ExecutionException, InterruptedException {  
                    + "exp(-0.5*pow(MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594)\n"
        }
            q.getSubQuery(),
        double min = Double.POSITIVE_INFINITY;
    private static final ScoreFunction WEIGHT_FACTOR_FUNCTION = new WeightFactorFunction(4);
        public LeafNumericFieldData loadDirect(LeafReaderContext context) throws Exception {  
    private static final ScoreFunction LIN_DECAY_FUNCTION_NAMED = new DecayFunctionBuilder.NumericFieldDataScoreFunction(  
        assertThat(exc.getMessage(), not(containsString("consider using ln1p or ln2p instead of ln to avoid negative scores")));
    public void testExplanationAndScoreEqualsEvenIfNoFunctionMatches() throws IOException {
        assertThat(
                }  
        }
    public void testPropagatesApproximations() throws IOException {
            CombineFunction.REPLACE,
        int numFunctions = randomIntBetween(1, 3);
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {  
        assertThat(
import org.opensearch.common.Nullable;  
        }
                @Override
        final double value;  
        double[] scores = randomPositiveDoubles(numFunctions);  
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));  
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, FIELD_VALUE_FACTOR_FUNCTION);  
        // test that field_value_factor function using modifier log throws an exception on negative scores  
                public long ramBytesUsed() {
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);  
            sum += weights[i] * scores[i];  
                public long ramBytesUsed() {  
            new FilterScoreFunction(new TermQuery(new Term("_uid", "2")), new WeightFactorFunction(10)),
import org.apache.lucene.search.Query;
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));  
            combineFunction,
            )
    private static final ScoreFunction RANDOM_SCORE_FUNCTION = new RandomScoreFunction(0, 0, new IndexFieldDataStub());
    private static class ConstantScoreFunction extends ScoreFunction {
        @Override  
    private IndexWriter w;  
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
        exc = expectThrows(OpenSearchException.class, () -> localSearcher.search(query2, 1));
            Float.NEGATIVE_INFINITY,  
            return 0;
        }
        );
        ) {  
            combineFunction,  
            Float.POSITIVE_INFINITY
        new IndexNumericFieldDataStub(),
        protected int doHashCode() {
    /**  
                        @Override
        );  
        FunctionScoreQuery q1 = new FunctionScoreQuery(
    public Explanation getFunctionScoreExplanation(IndexSearcher searcher, ScoreFunction scoreFunction) throws IOException {
        1,
import static org.hamcrest.core.IsEqual.equalTo;
        query = new FunctionScoreQuery(
            termQuery,
            fvfFunction,
            RANDOM_SCORE_FUNCTION,
                    return needsScore;  
 * GitHub history for details.
        }  
    }
        );
                @Override
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].toString(), equalTo("4.0 = weight\n"));
            CombineFunction.MULTIPLY,
        protected int doHashCode() {  
            this.value = value;
            return null;  
                    throw new UnsupportedOperationException(UNSUPPORTED);
    }
        }
            minScore,
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
    public void initSearcher() throws IOException {
import java.util.Collection;
        IndexSearcher localSearcher = new IndexSearcher(reader);  
        }
            } else {
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
    public void checkFunctionScoreExplanation(Explanation randomExplanation, String functionExpl) {
        FunctionScoreQuery diffMinScore = new FunctionScoreQuery(  
            functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].toString(),  
                @Override  
            DocValueFormat format,
import java.io.IOException;
        1,
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
 */
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();  
        for (int i = 0; i < values.length; i++) {
            }  
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].getDetails()[1].getDetails().length, equalTo(0));  
            minScore,
        GaussDecayFunctionBuilder.GAUSS_DECAY_FUNCTION,  
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
        );
            assertNotNull(scorer.twoPhaseIterator());
                "0.1 = max(0.0, ((1.1111111111111112"
        Float minScore = randomBoolean() ? null : 1.0f;
    );  
        assertEquals(queryExpl.getDescription(), ffsqExpl.getDescription());
            return 0;  
        assertThat(explainedScore / scoreWithWeight, is(1f));
        functionExplanation = getFunctionScoreExplanation(searcher, EXP_DECAY_FUNCTION_NAMED);
                @Override
            FunctionScoreQuery right = randomFrom(queries);  
        assertEquals("Score value is too low, expected at least 10.0 but got 1.0", ffsqExpl.getDescription());
        assertTrue(ffsqExpl.isMatch());  
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, EXP_DECAY_FUNCTION);  
        assertThat(
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
        public String getFieldName() {
        functionExplanation = getFiltersFunctionScoreExplanation(
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
        }  
    }
            maxBoost == 1.0f ? 0.9f : 1.0f  
        assertThat(functionExplanation.getDetails()[0].getDetails()[2].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
        );
                public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
                }
        }  
                @Override
        double sum = 0;
            FunctionScoreQuery.ScoreMode.AVG,
                @Override
            FunctionScoreQuery right = randomFrom(queries);  
            FunctionScoreQuery.ScoreMode.AVG,
        ffsqExpl = searcher.explain(ffsq, 0);
        );
                @Override
            combineFunction,  
        float explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
        FunctionScoreQuery fsq = new FunctionScoreQuery(query, 0f, Float.POSITIVE_INFINITY);
            function,  
                        @Override
        assertThat(scoreWithWeight / (float) (sum / norm), is(1f));
    public void testExplainFunctionScoreQuery() throws IOException {  
        assertThat(searchResult.scoreDocs[0].score, equalTo(explanation.getValue()));
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
        for (int i = 0; i < numFunctions; i++) {
        functionExplanation = getFunctionScoreExplanation(searcher, WEIGHT_FACTOR_FUNCTION);
import org.opensearch.common.lucene.search.function.LeafScoreFunction;  
    private DirectoryReader reader;
    public FunctionScoreQuery getFiltersFunctionScoreQuery(
            return new LeafNumericFieldData() {
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.LN;
import org.opensearch.index.fielddata.LeafFieldData;
            new TermQuery(new Term(FIELD, "out")),  
            FunctionScoreQuery left = randomFrom(queries);
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));
        @Override
        assertEquals("Score value is too low, expected at least 10.0 but got 1.0", fsqExpl.getDescription());
 *
                public double score(int docId, float subQueryScore) {  
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));  
        for (int i = 0; i < weights.length; i++) {  
        FunctionScoreQuery ffsq = new FunctionScoreQuery(query, 0f, Float.POSITIVE_INFINITY);
        functionExplanation = getFunctionScoreExplanation(searcher, FIELD_VALUE_FACTOR_FUNCTION_NAMED);
            weightFunctionStubs
        assertThat(exc.getMessage(), containsString("field value function must not produce negative scores"));  
import org.opensearch.search.sort.BucketedSort;
            BucketedSort.ExtraData extra
 * KIND, either express or implied.  See the License for the
    private Directory dir;
                @Override  
                }  
                    + "exp(-0.5*pow(MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594)\n"
            new TermQuery(new Term("foo", "bar")),  
            null,
        for (int i = 0; i < weights.length; i++) {
        ScoreFunction... scoreFunctions
        for (int i = 0; i < scoreFunctions.length; i++) {
            0.0f,
    public void testWithInvalidScores() {
    }
                        }
            if (left == right) {
                }
                        @Override  
                    return score;
import org.opensearch.search.sort.SortOrder;
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
            }  
        new IndexNumericFieldDataStub(),
        0,
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));  
        public SortField sortField(
            norm += weights[i];
                }  
        ScoreFunctionStub(double score) {  
     * Stub for IndexNumericFieldData needed by some score functions. Returns 1 as value always.
import org.apache.lucene.search.TermQuery;
        );
            )  
        checkFiltersFunctionScoreExplanation(functionExplanation, "field value function: ln(doc['test'].value?:1.0 * factor=1.0)", 0);
        assertEquals(q, q1);  
        ) {
    }
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 0);  
        FunctionScoreQuery[] queries = new FunctionScoreQuery[] { diffFunction, diffMinScore, diffQuery, q, diffMaxBoost };
            max = Math.max(max, weights[i] * scores[i]);
        assertThat(  
            CombineFunction.REPLACE,
                    };
        w.commit();  
            )
            minScore,
        checkFiltersFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test)", 0);
            null,
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
    public void testExplainFunctionScoreQueryWithName() throws IOException {  
            Nested nested,  
            throw new UnsupportedOperationException(UNSUPPORTED);
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
                @Override  
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(  
import org.apache.lucene.tests.search.RandomApproximationQuery;
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();  
 * Modifications Copyright OpenSearch Contributors. See
        w.addDocument(d);
import org.apache.lucene.search.MatchAllDocsQuery;  
    private static final String FIELD = "test";  
    );  
            maxBoost  
/*  
            double rand = randomValueOtherThanMany((d) -> Double.compare(d, 0) < 0, OpenSearchTestCase::randomDouble);  
        for (int i = 0; i < numFunctions; i++) {  
        assertThat(exc.getMessage(), containsString("function score query returned an invalid score: " + Float.NEGATIVE_INFINITY));  
        public LeafFieldData load(LeafReaderContext context) {  
import org.apache.lucene.search.SortField;  
        0.1,
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        );
        );
            functionExplanation.getDetails()[0].getDetails()[2].getDetails()[1].getDetails()[0].toString(),
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.NONE;
    public void checkFiltersFunctionScoreExplanation(Explanation randomExplanation, String functionExpl, int whichFunction) {  
        assertEquals(queryExpl.getDescription(), fsqExpl.getDescription());  
        IndexSearcher localSearcher = new IndexSearcher(reader);
                }
                }
        assertEquals(q, q1);
    public void testWeightFactorNeedsScore() {
 *  
                    return null;
            combineFunction,
                    return new SortedBinaryDocValues() {
    }  
        functionExplanation = getFunctionScoreExplanation(searcher, LIN_DECAY_FUNCTION_NAMED);  
        CombineFunction combineFunction = randomFrom(  
    }
        ffsq = new FunctionScoreQuery(query, 10f, Float.POSITIVE_INFINITY);
            equalTo(
        assertEquals(q.hashCode(), q1.hashCode());
        assertThat(exc.getMessage(), not(containsString("consider using log1p or log2p instead of log to avoid negative scores")));
            equalTo(  
 * You may obtain a copy of the License at  
            combineFunction,
        functionExplanation = getFunctionScoreExplanation(searcher, GAUSS_DECAY_FUNCTION_NAMED);  
            combineFunction,
        TermQuery termQuery = new TermQuery(new Term(FIELD, "out"));
import org.opensearch.index.fielddata.LeafNumericFieldData;  
 * this file be licensed under the Apache-2.0 license or a
            throw new UnsupportedOperationException(UNSUPPORTED);  
     */
        null
                assertEquals(left, right);
            filterFunctions[i] = new FunctionScoreQuery.FilterScoreFunction(new TermQuery(TERM), scoreFunctions[i]);  
    private static final ScoreFunction GAUSS_DECAY_FUNCTION_NAMED = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
