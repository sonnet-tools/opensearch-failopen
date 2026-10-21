                    + "(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594)\n"
        for (int i = 0; i < scoreFunctions.length; i++) {
        functionExplanation = getFunctionScoreExplanation(searcher, WEIGHT_FACTOR_FUNCTION);
        assertThat(
        // check for document that has a matching function
                public SortedBinaryDocValues getBytesValues() {
        for (int i = 0; i < weights.length; i++) {
        FunctionScoreQuery[] queries = new FunctionScoreQuery[] { diffFunction, diffMinScore, diffQuery, q, diffMaxBoost };
        @Override
        "func1"
        searcher.setQueryCache(null); // otherwise we could get a cached entry that does not have approximations
        }
            combineFunction,
            throw new UnsupportedOperationException(UNSUPPORTED);
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
            function,
            return new LeafFieldData() {
                        }
        reader = DirectoryReader.open(w);
 * Unless required by applicable law or agreed to in writing,
                "0.1 = "
    }
        float scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
                @Override
                public Collection<Accountable> getChildResources() {
    }
import static org.hamcrest.core.IsEqual.equalTo;
                assertEquals(left, right);
            super(CombineFunction.REPLACE);
import static org.hamcrest.core.IsNot.not;
        GaussDecayFunctionBuilder.GAUSS_DECAY_FUNCTION,
        }
    private static final Term TERM = new Term(FIELD, "through");
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
                assertNotEquals(left + " == " + right, left, right);
        functionExplanation = getFunctionScoreExplanation(searcher, new WeightFactorFunction(4, RANDOM_SCORE_FUNCTION_NAMED));
        assertThat(exc.getMessage(), containsString("function score query returned an invalid score: " + Float.NaN));
            new TermQuery(new Term("foo", "bar")),
                    return false;
            return "test";
            )
        }
 * under the License.
        1.0,
                        @Override
            Nested nested,
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, LIN_DECAY_FUNCTION);
        IndexSearcher localSearcher = new IndexSearcher(reader);
 * this file be licensed under the Apache-2.0 license or a
            Float.POSITIVE_INFINITY
        assertThat(functionExplanation.getDetails()[1].getDescription(), equalTo(functionExpl));
            Float.MAX_VALUE * -1,
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
        assertThat(exc.getMessage(), containsString("field value function must not produce negative scores"));
        @Override
        FunctionScoreQuery filtersFunctionScoreQueryWithWeights = new FunctionScoreQuery(
        null,
                }
        assertThat(
    }
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
                @Override
            boolean reverse
            functionExplanation.getDetails()[0].getDetails()[3].getDetails()[1].getDetails()[0].toString(),
        double norm = 0;
        FunctionScoreQuery ffsq = new FunctionScoreQuery(query, 0f, Float.POSITIVE_INFINITY);
        0,
        );
            return false;
        FunctionScoreQuery fsQuery1 = new FunctionScoreQuery(
        @Override
            maxBoost == 1.0f ? 0.9f : 1.0f
    }
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
        }
        CombineFunction combineFunction = randomFrom(CombineFunction.values());
                    throw new UnsupportedOperationException(UNSUPPORTED);
        );
        );
        FunctionScoreQuery[] queries = new FunctionScoreQuery[] { diffQuery, diffMaxBoost, diffMinScore, diffFunc, q, diffCombineFunc };
            FunctionScoreQuery.ScoreMode.MULTIPLY,
        }
            int bucketSize,
        assertFalse(ffsqExpl.isMatch());
        assertEquals(q.hashCode(), q.hashCode());
            LIN_DECAY_FUNCTION
        );
    }
            FunctionScoreQuery.ScoreMode.MAX,
            functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].toString(),
                        @Override
    @Before
        );
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
        );
        }
                @Override
        ScoreFunction otherFunction = new DummyScoreFunction(combineFunction);
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 3);
            new TermQuery(new Term("foo", "bar")),
import org.junit.After;
        dir = newDirectory();
        FunctionScoreQuery functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
            weightFunctionStubs
            MultiValueMode sortMode,
        for (int i = 0; i < numIters; i++) {
        "test",
            throw new UnsupportedOperationException(UNSUPPORTED);
                    return Explanation.match((float) score, "a random score for testing");
            FunctionScoreQuery right = randomFrom(queries);
        }
 */
                CombineFunction.MIN,
    }
        }
            maxBoost
            randomBoolean() ? new ScoreFunction[] { function, otherFunc } : new ScoreFunction[] { otherFunc },
            maxBoost
            null,
                @Override
     */
        assertThat(
        );
            double rand = randomValueOtherThanMany((d) -> Double.compare(d, 0) < 0, OpenSearchTestCase::randomDouble);
                            return true;
import org.apache.lucene.index.SortedNumericDocValues;
    @After
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 4);
                "0.1 = max(0.0, ((1.1111111111111112 - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin)))"
        checkFiltersFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test)", 0);
            CombineFunction.REPLACE,
                    return value;
    private static final ScoreFunction GAUSS_DECAY_FUNCTION_NAMED = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
            BigArrays bigArrays,
        1.0,
        searchResult = localSearcher.search(query, 1);
        FunctionScoreQuery query1 = new FunctionScoreQuery(
        LinearDecayFunctionBuilder.LINEAR_DECAY_FUNCTION,
            minScore,
            super(CombineFunction.REPLACE);
                assertNotEquals(left + " == " + right, left, right);
    ) {
        assertThat(
        assertEquals(q, q1);
                        @Override
        dir.close();
        // test that field_value_factor function using modifier log throws an exception on negative scores
 */
        FunctionScoreQuery diffMinScore = new FunctionScoreQuery(
            fvfFunction,
                public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
            termQuery,
            BucketedSort.ExtraData extra
            equalTo(
                CombineFunction.AVG,
        Query query = new MatchAllDocsQuery();
        GaussDecayFunctionBuilder.GAUSS_DECAY_FUNCTION,
        }
            if (left == right) {
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
        );
                }
            combineFunction,
        );
 * compatible open source license.
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
            )
        assertThat(explainedScore / scoreWithWeight, is(1f));
                        }
                @Override
            new FilterScoreFunction(new TermQuery(new Term("_uid", "1")), new WeightFactorFunction(10)),
    }
            equalTo("0.1 = exp(- MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455)\n")
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
        "func1"
            CombineFunction.REPLACE,
                }
    }
                    };
                @Override
            FunctionScoreQuery.ScoreMode.MIN,
        0,
        // test that field_value_factor function using modifier ln throws an exception on negative scores
        0,
        Explanation functionExplanation = getFunctionScoreExplanation(searcher, RANDOM_SCORE_FUNCTION_NAMED);
        }
                            return 1;
            CombineFunction.MULTIPLY,
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
        final double value;
import org.apache.lucene.search.TermQuery;
                @Override
        }
        );
 * The OpenSearch Contributors require contributions made to
        @Override
        );
        assertThat(functionExplanation.getDetails()[0].getDetails()[3].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
            equalTo(
            weightFunctionStubs[i] = new WeightFactorFunction(weights[i], scoreFunctionStubs[i]);
        assertThat(exc.getMessage(), containsString("consider using ln1p or ln2p instead of ln to avoid negative scores"));
        WeightFactorFunction[] weightFunctionStubs = new WeightFactorFunction[numFunctions];
            throw new UnsupportedOperationException(UNSUPPORTED);
        Explanation queryExpl = searcher.explain(query, 0);
            WeightFactorFunction function = new WeightFactorFunction(10.0f, new ScoreFunction(CombineFunction.REPLACE) {
import org.apache.lucene.index.IndexWriter;
        FunctionScoreQuery diffCombineFunc = new FunctionScoreQuery(
        assertThat(scoreWithWeight / (float) score, is(1f));
    private IndexSearcher searcher;
        }
                        }
        );
        assertEquals(q, q1);
        float[] values = new float[size];
                    throw new UnsupportedOperationException(UNSUPPORTED);
        FunctionScoreQuery diffMinScore = new FunctionScoreQuery(
            new TermQuery(new Term("foo", "bar")),
        public LeafFieldData loadDirect(LeafReaderContext context) throws Exception {
        );
import org.apache.lucene.search.Scorer;
            minScore,
                public SortedBinaryDocValues getBytesValues() {
            new TermQuery(new Term("foo", "baz")),
        assertThat(scoreWithWeight / (float) max, is(1f));
    );
                    return null;
            combineFunction == CombineFunction.AVG ? CombineFunction.MAX : CombineFunction.AVG,
                public ScriptDocValues getScriptValues() {
        public boolean needsScores() {
    public void testExplainFunctionScoreQuery() throws IOException {
                    return new SortedNumericDoubleValues() {
            Float.MAX_VALUE
                            return 1d;
        public LeafNumericFieldData load(LeafReaderContext context) {
        assertTrue(ffsqExpl.isMatch());
            termQuery,
        Weight weight = searcher.createWeight(searcher.rewrite(functionScoreQuery), org.apache.lucene.search.ScoreMode.COMPLETE, 1f);
        0,
        ExponentialDecayFunctionBuilder.EXP_DECAY_FUNCTION,
            minScore,
    public void testMinScoreExplain() throws IOException {
            new ConstantScoreFunction(Float.NaN),
        }
import org.opensearch.common.lucene.search.function.CombineFunction;
        }
        assertFalse(fsqExpl.isMatch());
        w.commit();
        for (int i = 0; i < values.length; i++) {
        }
        assertTrue(fsqExpl.isMatch());
    private static final String UNSUPPORTED = "Method not implemented. This is just a stub for testing.";
        FunctionScoreQuery query2 = new FunctionScoreQuery(
            randomFrom(ScoreMode.values()),
        fsq = new FunctionScoreQuery(query, 10f, Float.POSITIVE_INFINITY);
            combineFunction,
            sum += weights[i] * scores[i];
        checkFunctionScoreExplanation(functionExplanation, "field value function(_name: func1): ln(doc['test'].value?:1.0 * factor=1.0)");
        d.add(new TextField("_uid", "1", Field.Store.YES));
import org.opensearch.index.fielddata.ScriptDocValues;
                "0.1 = max(0.0, ((1.1111111111111112 - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin)))"
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, GAUSS_DECAY_FUNCTION);
        );
            )
import org.apache.lucene.search.SortField;
        FunctionScoreQuery diffQuery = new FunctionScoreQuery(
            function,
                public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
 * specific language governing permissions and limitations
        Explanation explanation = randomExplanation.getDetails()[0];
                "0.1 = max(0.0, ((1.1111111111111112"
        }
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
        @Override
        FunctionScoreQuery q1 = new FunctionScoreQuery(
            values[i] = rand * randomInt(100) + 1.e-5d;
        FunctionScoreQuery diffFunc = new FunctionScoreQuery(
    private static final ScoreFunction RANDOM_SCORE_FUNCTION_NAMED = new RandomScoreFunction(0, 0, new IndexFieldDataStub(), "func1");
 *
            GAUSS_DECAY_FUNCTION,
            });
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, EXP_DECAY_FUNCTION);
            maxBoost
 * Modifications Copyright OpenSearch Contributors. See
        0.1,
    private IndexWriter w;
/*
 *
        "func1"
                }
 * this work for additional information regarding copyright
        );
import java.util.Collection;
        }
        IndexSearcher localSearcher = new IndexSearcher(reader);
import static org.hamcrest.CoreMatchers.endsWith;
        IndexSearcher localSearcher = newSearcher(reader);
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
        checkFunctionScoreExplanation(functionExplanation, "product of:");
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.Query;
            return false;
                    + " - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)])/1.1111111111111112)\n"
        FilterScoreFunction otherFunc = new FilterScoreFunction(new TermQuery(new Term("filter", "other_query")), scoreFunction);
        FunctionScoreQuery diffMaxBoost = new FunctionScoreQuery(
            } else {
        assertThat(explanation.getDescription(), equalTo("function score, score mode [avg]"));
        for (int i = 0; i < numFunctions; i++) {
        @Override
        1,
            score *= weights[i] * scores[i];
        FunctionScoreQuery q = new FunctionScoreQuery(new TermQuery(new Term("foo", "bar")), function, combineFunction, minScore, maxBoost);
            throw new UnsupportedOperationException(UNSUPPORTED);
        IndexSearcher searcher = newSearcher(reader);
import org.apache.lucene.document.Document;
    private Directory dir;
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
        double[] scores = randomPositiveDoubles(numFunctions);
            )
            return null;
            new TermQuery(TERM),
        FunctionScoreQuery functionScoreQuery = getFiltersFunctionScoreQuery(
        w.addDocument(d);
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
        return new FunctionScoreQuery(
            null,
        Weight weight = searcher.createWeight(searcher.rewrite(functionScoreQuery), org.apache.lucene.search.ScoreMode.COMPLETE, 1f);
        for (boolean needsScore : new boolean[] { true, false }) {
import java.io.IOException;
    private static class IndexNumericFieldDataStub extends IndexNumericFieldData {
    public void testExceptionOnLnNegativeScores() {
        1,
                public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
        Explanation functionExplanation = getFunctionScoreExplanation(searcher, RANDOM_SCORE_FUNCTION);
            } else {
    public void testWeightFactorNeedsScore() {
        Query query = new RandomApproximationQuery(new MatchAllDocsQuery(), random());
                CombineFunction.REPLACE }
            return new LeafScoreFunction() {
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.LN;
            return 0;
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> localSearcher.search(fsQuery1, 1));
 *
        return values;
        );
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
        0.1,
        ScoreFunction scoreFunction = new DummyScoreFunction(combineFunction);
                    };
 * Licensed to Elasticsearch under one or more contributor
        double min = Double.POSITIVE_INFINITY;
            combineFunction,
        @Override
        ExponentialDecayFunctionBuilder.EXP_DECAY_FUNCTION,
        for (int i = 0; i < values.length; i++) {
        protected int doHashCode() {
            functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].toString(),
            maxBoost == 1.0f ? 0.9f : 1.0f
        assertEquals("Score value is too low, expected at least 10.0 but got 1.0", ffsqExpl.getDescription());
                }
        protected boolean sortRequiresCustomComparator() {
        new IndexNumericFieldDataStub(),
import org.opensearch.search.MultiValueMode;
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
                }
import org.junit.Before;
        assertThat(searchResult.scoreDocs[0].score, equalTo(explanation.getValue()));
        final ScoreFunction fvfFunction = new FieldValueFactorFunction(FIELD, -10, modifier, 1.0, new IndexNumericFieldDataStub());
    }
                        public boolean advanceExact(int docId) {
            function,
        assertThat(scoreWithWeight / (float) min, is(1f));
        float score = topDocsWithWeights.scoreDocs[0].score;
    );
 * license agreements. See the NOTICE file distributed with
    private static class ConstantScoreFunction extends ScoreFunction {
        @Override
        }
 * software distributed under the License is distributed on an
        protected boolean doEquals(ScoreFunction other) {
            maxBoost
    private static final ScoreFunction EXP_DECAY_FUNCTION_NAMED = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
                        public int docValueCount() {
        for (int i = 0; i < weights.length; i++) {
    public void testExplainFunctionScoreQueryWithName() throws IOException {
    }
        assertEquals(q.hashCode(), q.hashCode());
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
        ) {
            function,
        fsqExpl = searcher.explain(fsq, 0);
                    + " - 0.0(=offset), 0)])/1.1111111111111112)\n"
        FunctionScoreQuery fsq = new FunctionScoreQuery(query, null, Float.POSITIVE_INFINITY);
        return explanation.getDetails()[1];
            assertEquals(needsScore, function.needsScores());
        assertThat(functionExplanation.getDescription(), equalTo("function score, product of:"));
    }
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
        assertEquals(q, q);
    private static final ScoreFunction FIELD_VALUE_FACTOR_FUNCTION = new FieldValueFactorFunction(
        }
 * ownership. Elasticsearch licenses this file to you under
        @Override
}
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
            return false;
    }
import org.apache.lucene.util.Accountable;
                        public boolean advanceExact(int docId) {
        TopDocs topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
        FunctionScoreQuery functionScoreQuery = new FunctionScoreQuery(new TermQuery(TERM), scoreFunction, CombineFunction.AVG, 0.0f, 100);
            Float.MAX_VALUE
        Explanation functionExplanation = getFiltersFunctionScoreExplanation(searcher, RANDOM_SCORE_FUNCTION);
                @Override
        public NumericType getNumericType() {
                "0.1 = exp(-0.5*pow(MAX[Math.max(Math.abs"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Stub for IndexFieldData. Needed by some score functions. Returns 1 as count always.
            CombineFunction.REPLACE,
        w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        @Override
        sum = 0;
        for (int i = 0; i < weights.length; i++) {
            function,
        d.add(new TextField(FIELD, TEXT, Field.Store.YES));
            null,
        TermQuery termQuery = new TermQuery(new Term(FIELD, "out"));
                protected int doHashCode() {
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
            null,
        Explanation functionExplanation = randomExplanation.getDetails()[0].getDetails()[whichFunction];
            equalTo("0.1 = exp(- " + "MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455)\n")
        double[] values = new double[size];
import org.apache.lucene.search.IndexSearcher;
        MultiValueMode.MAX,
        );
        public LeafFieldData load(LeafReaderContext context) {
        double sum = 0;
                @Override
import org.opensearch.index.fielddata.LeafFieldData;
        0.1,
        ScoreFunctionStub(double score) {
        FunctionScoreQuery diffMaxBoost = new FunctionScoreQuery(
                }
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
            SortOrder sortOrder,
        1,
                }
        );
import org.apache.lucene.document.TextField;
                public void close() {}
            norm += weights[i];
            super(scoreCombiner);
        0.1,
        ScoreFunction[] filterFunctions = new ScoreFunction[scoreFunctions.length];
                    return score;
     */
        }
    }
        IndexSearcher localSearcher = new IndexSearcher(reader);
                        }
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
        );
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
        functionExplanation = getFunctionScoreExplanation(searcher, EXP_DECAY_FUNCTION);
    }
        FunctionScoreQuery fsq = new FunctionScoreQuery(query, 0f, Float.POSITIVE_INFINITY);
        }
                assertEquals(left.hashCode(), right.hashCode());
import org.apache.lucene.search.TopDocs;
        CombineFunction combineFunction = randomFrom(CombineFunction.values());
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
            new WeightFactorFunction(2),
    protected Explanation getExplanation(IndexSearcher searcher, FunctionScoreQuery functionScoreQuery) throws IOException {
        new IndexNumericFieldDataStub(),
        for (int i = 0; i < numIters; i++) {
import org.opensearch.common.Nullable;
            if (left == right) {
        );
    }
        );
        assertThat(randomExplanation.getDetails()[0].getDescription(), containsString(functionExpl));
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 0);
            Float.NEGATIVE_INFINITY,
            minScore == null ? 1.0f : null,
    }
        );
        }
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
            minScore,
        return getExplanation(searcher, functionScoreQuery).getDetails()[1];
        assertEquals("Score value is too low, expected at least 10.0 but got 1.0", fsqExpl.getDescription());
        double score = 1;
    }
            return false;
            this.value = value;
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
    public Explanation getFiltersFunctionScoreExplanation(IndexSearcher searcher, ScoreFunction... scoreFunctions) throws IOException {
        query = new FunctionScoreQuery(
            FunctionScoreQuery left = randomFrom(queries);
        }
    }
        for (int i = 0; i < weights.length; i++) {
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.opensearch.index.fielddata.IndexNumericFieldData;
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
                "0.1 = exp(-0.5*pow(MAX[Math.max(Math.abs"
                @Override
        }
        ScoreFunctionStub[] scoreFunctionStubs = new ScoreFunctionStub[numFunctions];
        0,
    private static final ScoreFunction RANDOM_SCORE_FUNCTION = new RandomScoreFunction(0, 0, new IndexFieldDataStub());
        ffsq = new FunctionScoreQuery(query, 10f, Float.POSITIVE_INFINITY);
        );
        public boolean needsScores() {
            CombineFunction.REPLACE,
        assertThat(explainedScore / scoreWithWeight, is(1f));
        }
            weightFunctionStubs
        functionExplanation = getFiltersFunctionScoreExplanation(
            };
        functionExplanation = getFunctionScoreExplanation(searcher, LIN_DECAY_FUNCTION);
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> localSearcher.search(fsQuery1, 1));
                public boolean needsScores() {
                        @Override
        assertThat(
        public String getFieldName() {
                }
            100
            new TermQuery(new Term(FIELD, "out")),
            combineFunction,
            combineFunction,
        @Override
import org.opensearch.common.lucene.search.function.LeafScoreFunction;
        assertEquals(q, q);
        assertThat(scoreWithWeight / (float) (sum / norm), is(1f));
    private static class DummyScoreFunction extends ScoreFunction {
            new TermQuery(new Term("foo", "bar")),
        for (int i = 0; i < numFunctions; i++) {
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
                public double score(int docId, float subQueryScore) {
                    throw new UnsupportedOperationException(UNSUPPORTED);
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
    }
        );
 */
        }
        "func1"
            CombineFunction.REPLACE,
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
                public void close() {}
        assertEquals(queryExpl.getValue(), ffsqExpl.getValue());
            new TermQuery(new Term("foo", "bar")),
            )
            Scorer scorer = weight.scorer(reader.leaves().get(0));
            new TermQuery(new Term(FIELD, "out")),
                }
            sum += weights[i] * scores[i];
            equalTo(
                public long ramBytesUsed() {
    public void testSimpleWeightedFunction() throws IOException, ExecutionException, InterruptedException {
        }
        assertThat(explainedScore / scoreWithWeight, is(1f));
    public void initSearcher() throws IOException {
        @Override
 * You may obtain a copy of the License at
            scoreMode,
        CombineFunction combineFunction = randomFrom(
            new FilterScoreFunction(new TermQuery(new Term("_uid", "2")), new WeightFactorFunction(10)),
            functionExplanation.getDetails()[0].getDetails()[2].getDetails()[1].getDetails()[0].toString(),
            combineFunction,
    public FunctionScoreQuery getFiltersFunctionScoreQuery(
    private static final String FIELD = "test";
        @Override
        1,
            weightFunctionStubs
 * KIND, either express or implied.  See the License for the
                "0.1 = max(0.0, ((1.1111111111111112"
            new ConstantScoreFunction(Float.NEGATIVE_INFINITY),
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> localSearcher.search(fsQuery1, 1));
            FunctionScoreQuery right = randomFrom(queries);
    }
            maxBoost
    private static final ScoreFunction EXP_DECAY_FUNCTION = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
                    throw new UnsupportedOperationException(UNSUPPORTED);
    private static final ScoreFunction FIELD_VALUE_FACTOR_FUNCTION_NAMED = new FieldValueFactorFunction(
        public String getFieldName() {
        assertThat(
        functionExplanation = getFunctionScoreExplanation(searcher, LIN_DECAY_FUNCTION_NAMED);
        assertThat(functionExplanation.getDetails()[0].getDetails()[2].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
        0.1,
                }
import org.opensearch.search.DocValueFormat;
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
        );
    public Explanation getFunctionScoreExplanation(IndexSearcher searcher, ScoreFunction scoreFunction) throws IOException {
            MultiValueMode sortMode,
    private static final ScoreFunction LIN_DECAY_FUNCTION_NAMED = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
        );
/*
        protected int doHashCode() {
            Float.POSITIVE_INFINITY
            minScore == null ? 0.9f : null,
                @Override
            throw new UnsupportedOperationException(UNSUPPORTED);
                assertEquals(left, right);
        public SortField sortField(
        MultiValueMode.MAX,
            CombineFunction.AVG,
                @Override
        checkFunctionScoreExplanation(functionExplanation, "product of:");
        @Override
            DocValueFormat format,
        private double score;
        reader.close();
            values[i] = randomFloat() * randomInt(100) + 1.e-5f;
        assertThat(
            equalTo(
import org.opensearch.index.fielddata.LeafNumericFieldData;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode;
        }
        );
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
                public double score(int docId, float subQueryScore) throws IOException {
        1,
        1,
                    + "exp(-0.5*pow(MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594)\n"
        assertThat(
        assertThat(randomExplanation.getDescription(), equalTo("min of:"));
            FunctionScoreQuery left = randomFrom(queries);
        null
                    + "(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594, _name: func1)\n"
            scoreFunctionStubs[i] = new ScoreFunctionStub(scores[i]);
        final int numIters = randomIntBetween(20, 100);
        FieldValueFactorFunction.Modifier.LN,
        assertEquals(queryExpl.getDescription(), ffsqExpl.getDescription());
        for (int i = 0; i < weights.length; i++) {
import org.apache.lucene.document.Field;
        null
        protected DummyScoreFunction(CombineFunction scoreCombiner) {
        }
                @Override
                CombineFunction.SUM,
                        }
            combineFunction,
                    throw new UnsupportedOperationException(UNSUPPORTED);
        );
        new IndexNumericFieldDataStub(),
        );
            equalTo(
        );
            min = Math.min(min, weights[i] * scores[i]);
            function,
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        functionExplanation = getFiltersFunctionScoreExplanation(searcher, FIELD_VALUE_FACTOR_FUNCTION);
        0,
        assertThat(randomExplanation.getDescription(), equalTo("min of:"));
                        }
                    throw new UnsupportedOperationException(UNSUPPORTED);
        @Override
                CombineFunction.MAX,
            @Nullable Object missingValue,
            FunctionScoreQuery.ScoreMode.AVG,
                }
            FIELD_VALUE_FACTOR_FUNCTION,
        );
    private static final String TEXT = "The way out is through.";
        protected boolean doEquals(ScoreFunction other) {
        }
        }
            };
        public ValuesSourceType getValuesSourceType() {
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
            equalTo("1.0 = constant score 1.0 - no function provided\n")
                @Override
        assertThat(
        // now test all together
        assertThat(exc.getMessage(), containsString("function score query returned an invalid score: " + Float.NEGATIVE_INFINITY));
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
import org.opensearch.search.aggregations.support.ValuesSourceType;
            return false;
        return values;
        0.1,
                }
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].toString(), equalTo("4.0 = weight\n"));
                @Override
    public void testPropagatesApproximations() throws IOException {
            new TermQuery(new Term(FIELD, "out")),
import org.opensearch.search.sort.BucketedSort;
import org.apache.lucene.index.Term;
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 0);
                protected boolean doEquals(ScoreFunction other) {
    );
            this.score = score;
            RANDOM_SCORE_FUNCTION,
        );
            max = Math.max(max, weights[i] * scores[i]);
            minScore,
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
        final int numIters = randomIntBetween(20, 100);
    }
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));
            };
            equalTo(
            weightFunctionStubs
                "0.1 = "
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
    }
    public void testExplanationAndScoreEqualsEvenIfNoFunctionMatches() throws IOException {
        @Override
    }
    public void testFilterFunctionScoreHashCodeAndEquals() {
        w.close();
        );
        return weight.explain(searcher.getIndexReader().leaves().get(0), 0);
            XFieldComparatorSource.Nested nested,
        FunctionScoreQuery q = new FunctionScoreQuery(new TermQuery(new Term("foo", "bar")), function, combineFunction, minScore, maxBoost);
                assertEquals(left.hashCode(), right.hashCode());
            minScore,
            }
        explanation = localSearcher.explain(query, searchResult.scoreDocs[0].doc);
        functionExplanation = getFunctionScoreExplanation(searcher, FIELD_VALUE_FACTOR_FUNCTION_NAMED);
            EXP_DECAY_FUNCTION,
        assertThat(functionExplanation.getDetails()[0].getDescription(), equalTo("match filter: " + FIELD + ":" + TERM.text()));
                public SortedNumericDocValues getLongValues() {
    /**
                        public double nextValue() {
        protected int doHashCode() {
            functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].toString(),
        }
    }
        0,
import org.apache.lucene.store.Directory;
        TermQuery termQuery = new TermQuery(new Term(FIELD, "out"));
        checkFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test, _name: func1)");
        TopDocs searchResult = localSearcher.search(query, 1);
    );
                        @Override
    public void testWithInvalidScores() {
            throw new UnsupportedOperationException(UNSUPPORTED);
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
            functionExplanation.getDetails()[0].getDetails()[0].toString(),
        );
        explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
        assertThat(score, equalTo(2.0f));
            Float.POSITIVE_INFINITY
            combineFunction,
                            return new BytesRef("0");
            return 0;
        assertThat(explainedScore / scoreWithWeight, is(1f));
            CombineFunction.REPLACE,
    private static float[] randomPositiveFloats(int size) {
        0,
/*
 * not use this file except in compliance with the License.
    }
        for (org.apache.lucene.search.ScoreMode scoreMode : org.apache.lucene.search.ScoreMode.values()) {
            return "test";
                    + "exp(-0.5*pow(MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.21714724095162594)\n"
            termQuery,
        );
            equalTo(
                }
        ScoreFunction function = new DummyScoreFunction(combineFunction);
        1,
            assertNotNull(scorer.twoPhaseIterator());
        Float minScore = randomBoolean() ? null : 1.0f;
            maxBoost
        TermQuery termQuery = new TermQuery(new Term(FIELD, "out"));
        IndexSearcher localSearcher = new IndexSearcher(reader);
            equalTo(
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].getDetails().length, equalTo(0));
        final ScoreFunction fvfFunction = new FieldValueFactorFunction(FIELD, 0.5f, modifier, 1.0, new IndexNumericFieldDataStub());
    private static double[] randomPositiveDoubles(int size) {
            new TermQuery(new Term("foo", "bar")),
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 2);
        );
    public void testExplainFiltersFunctionScoreQuery() throws IOException {
                        @Override
                @Override
        @Override
import org.opensearch.common.lucene.search.function.ScoreFunction;
    }
            q.getSubQuery(),
            equalTo("0.1 = exp(- MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455)\n")
import org.apache.lucene.search.MatchAllDocsQuery;
            fvfFunction,
import org.apache.lucene.tests.search.RandomApproximationQuery;
                @Override
            return 0;
    private static final ScoreFunction WEIGHT_FACTOR_FUNCTION = new WeightFactorFunction(4);
    }
        assertThat(searchResult.scoreDocs[0].score, equalTo(explanation.getValue()));
            combineFunction,
                public ScriptDocValues getScriptValues() {
import org.opensearch.common.lucene.search.function.WeightFactorFunction;
            Object missingValue,
        FunctionScoreQuery fsQuery1 = new FunctionScoreQuery(
    private static final ScoreFunction GAUSS_DECAY_FUNCTION = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
                    throw new UnsupportedOperationException(UNSUPPORTED);
        MultiValueMode.MAX,
        checkFiltersFunctionScoreExplanation(functionExplanation, "field value function: ln(doc['test'].value?:1.0 * factor=1.0)", 0);
                }
        @Override
                    return 0;
            )
        functionScoreQueryWithWeights = getFiltersFunctionScoreQuery(
            Float.NEGATIVE_INFINITY,
                public long ramBytesUsed() {
    );
        null
        // test that field_value_factor function throws an exception on negative scores
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
        FunctionScoreQuery query = new FunctionScoreQuery(
        OpenSearchException exc = expectThrows(OpenSearchException.class, () -> localSearcher.search(query1, 1));
        Float maxBoost = randomBoolean() ? Float.POSITIVE_INFINITY : randomFloat();
            };
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));
        // check for document that has no matching function
            return new LeafScoreFunction() {
import org.apache.lucene.search.Explanation;
        MultiValueMode.MAX,
        @Override
        assertThat(explainedScore / scoreWithWeight, is(1f));
            weightFunctionStubs
        Explanation explanation = localSearcher.explain(query, searchResult.scoreDocs[0].doc);
                    return null;
        LinearDecayFunctionBuilder.LINEAR_DECAY_FUNCTION,
            maxBoost
        Float minScore = randomBoolean() ? null : 1.0f;
        Explanation fsqExpl = searcher.explain(fsq, 0);
    }
            new TermQuery(new Term("foo", "baz")),
        assertThat(exc.getMessage(), containsString("consider using log1p or log2p instead of log to avoid negative scores"));
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.query.functionscore;
            maxBoost
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
        FunctionScoreQuery diffFunction = new FunctionScoreQuery(q.getSubQuery(), otherFunction, combineFunction, minScore, maxBoost);
        public BucketedSort newBucketedSort(
                public SortedNumericDoubleValues getDoubleValues() {
            searcher,
            Float.MAX_VALUE
        }
    /**
    public void testExceptionOnNegativeScores() {
        );
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));
        Explanation ffsqExpl = searcher.explain(ffsq, 0);
        @Override
    public void testExceptionOnLogNegativeScores() {
        new IndexNumericFieldDataStub(),
        float explainedScore = getExplanation(searcher, functionScoreQueryWithWeights).getValue().floatValue();
        assertThat(
            )
        protected boolean doEquals(ScoreFunction other) {
        assertThat(
        "test",
        functionExplanation = getFunctionScoreExplanation(searcher, GAUSS_DECAY_FUNCTION_NAMED);
import java.util.concurrent.ExecutionException;
            FunctionScoreQuery.ScoreMode.AVG,
                }
            scoreFunctions
        checkFiltersFunctionScoreExplanation(functionExplanation, "Function for field test:", 0);
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.NONE;
            equalTo(
            new TermQuery(new Term(FIELD, "out")),
        ) {
        }
import org.opensearch.common.lucene.search.function.FunctionScoreQuery.FilterScoreFunction;
            CombineFunction.REPLACE,
    private static final ScoreFunction LIN_DECAY_FUNCTION = new DecayFunctionBuilder.NumericFieldDataScoreFunction(
            minScore,
        );
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
            Float.POSITIVE_INFINITY
                public Collection<Accountable> getChildResources() {
        CombineFunction combineFunction,
                    return new SortedBinaryDocValues() {
        public LeafNumericFieldData loadDirect(LeafReaderContext context) throws Exception {
        FunctionScoreQuery fsQuery1 = new FunctionScoreQuery(
        searcher = newSearcher(reader);
        ScoreFunction... scoreFunctions
            endsWith("random score function (seed: 0, field: test, _name: func1)\n")
        assertThat(
        float[] weights = randomPositiveFloats(numFunctions);
            FunctionScoreQuery.ScoreMode.SUM,
            function,
import org.apache.lucene.search.Weight;
import org.opensearch.OpenSearchException;
        @Override
import org.apache.lucene.util.BytesRef;
        MultiValueMode.MAX,
                }
            CombineFunction.REPLACE,
        );
        Explanation explanation = weight.explain(searcher.getIndexReader().leaves().get(0), 0);
        1,
import static org.hamcrest.core.Is.is;
        0,
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].toString(), equalTo("4.0 = weight\n"));
        assertEquals(q.hashCode(), q1.hashCode());
            return other == this;
            combineFunction,
            throw new UnsupportedOperationException(UNSUPPORTED);
            CombineFunction.REPLACE,
        ffsqExpl = searcher.explain(ffsq, 0);
            null,
        );
            functionExplanation.getDetails()[0].getDetails()[4].getDetails()[1].getDetails()[0].toString(),
    );
        assertEquals(queryExpl.getDescription(), fsqExpl.getDescription());
import static org.hamcrest.CoreMatchers.containsString;
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
        checkFunctionScoreExplanation(functionExplanation, "field value function: ln(doc['test'].value?:1.0 * factor=1.0)");
        checkFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test)");
        FilterScoreFunction function = new FilterScoreFunction(new TermQuery(new Term("filter", "query")), scoreFunction);
        public ValuesSourceType getValuesSourceType() {
            function,
        scoreWithWeight = topDocsWithWeights.scoreDocs[0].score;
        final ScoreFunction fvfFunction = new FieldValueFactorFunction(FIELD, 0.5f, modifier, 1.0, new IndexNumericFieldDataStub());
                        public BytesRef nextValue() {
            function,
    }
                    return needsScore;
        protected ConstantScoreFunction(double value) {
    public void testWeightOnlyCreatesBoostFunction() throws IOException {
        checkFiltersFunctionScoreExplanation(functionExplanation, "field value function: ln(doc['test'].value?:1.0 * factor=1.0)", 1);
        TopDocs topDocsWithWeights = searcher.search(filtersFunctionScoreQueryWithWeights, 1);
        new IndexNumericFieldDataStub(),
        @Override
        checkFiltersFunctionScoreExplanation(functionExplanation, "random score function (seed: 0, field: test)", 0);
            )
        assertThat(
        functionExplanation = getFunctionScoreExplanation(searcher, FIELD_VALUE_FACTOR_FUNCTION);
        }
        assertThat(functionExplanation.getDetails()[0].getDetails()[1].getDetails()[1].getDetails().length, equalTo(0));
        }
        assertThat(scoreWithWeight / (float) sum, is(1f));
                CombineFunction.MULTIPLY,
        public boolean needsScores() {
    private DirectoryReader reader;
        MultiValueMode.MAX,
    private static class ScoreFunctionStub extends ScoreFunction {
        int numFunctions = randomIntBetween(1, 3);
        FunctionScoreQuery.ScoreMode scoreMode,
            new CombineFunction[] {
        FieldValueFactorFunction.Modifier modifier = FieldValueFactorFunction.Modifier.LOG;
        assertThat(functionExplanation.getDetails()[0].getDetails()[4].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
    public void testFunctionScoreHashCodeAndEquals() {
        exc = expectThrows(OpenSearchException.class, () -> localSearcher.search(query2, 1));
    public void checkFiltersFunctionScoreExplanation(Explanation randomExplanation, String functionExpl, int whichFunction) {
            filterFunctions,
        topDocsWithWeights = searcher.search(functionScoreQueryWithWeights, 1);
    public void closeAllTheReaders() throws IOException {
        assertEquals(q.hashCode(), q1.hashCode());
            CombineFunction.REPLACE,
            )
            return false;
        FunctionScoreQuery q1 = new FunctionScoreQuery(
        FunctionScoreQuery diffQuery = new FunctionScoreQuery(
                }
                    + " - MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)])/1.1111111111111112, _name: func1)\n"
            filterFunctions[i] = new FunctionScoreQuery.FilterScoreFunction(new TermQuery(TERM), scoreFunctions[i]);
            minScore,
    );
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
                    + " - 0.0(=offset), 0)])/1.1111111111111112)\n"
import org.opensearch.test.OpenSearchTestCase;
        }
     * Stub for IndexNumericFieldData needed by some score functions. Returns 1 as value always.
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails().length, equalTo(0));
            return new LeafNumericFieldData() {
        @Override
            }
        assertThat(functionExplanation.getDetails()[0].getDetails()[0].getDetails()[1].getDetails()[0].getDetails().length, equalTo(0));
        float maxBoost = randomBoolean() ? Float.POSITIVE_INFINITY : randomFloat();
        }
        0,
        0,
        }
    );
        }
                            return 1;
        assertThat(exc.getMessage(), not(containsString("consider using ln1p or ln2p instead of ln to avoid negative scores")));
        FieldValueFactorFunction.Modifier.LN,
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            Float.POSITIVE_INFINITY
import org.opensearch.search.sort.SortOrder;
            0.0f,
        double max = Double.NEGATIVE_INFINITY;
import org.opensearch.index.fielddata.IndexFieldData;
                @Override
            new MatchAllDocsQuery(),
                @Override
        assertThat(
                            return true;
        checkFunctionScoreExplanation(functionExplanation, "Function for field test:");
        assertThat(functionExplanation.getDetails()[0].getDetails().length, equalTo(0));
            fvfFunction,
                        public int docValueCount() {
        0,
                "0.1 = exp(- MAX[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)] * 2.3025850929940455, _name: func1)\n"
                    throw new UnsupportedOperationException(UNSUPPORTED);
        null
        functionExplanation = getFunctionScoreExplanation(searcher, GAUSS_DECAY_FUNCTION);
    private static class IndexFieldDataStub implements IndexFieldData<LeafFieldData> {
    public void checkFunctionScoreExplanation(Explanation randomExplanation, String functionExpl) {
        new IndexNumericFieldDataStub(),
        functionExplanation = getFunctionScoreExplanation(searcher, EXP_DECAY_FUNCTION_NAMED);
        @Override
        assertThat(exc.getMessage(), not(containsString("consider using log1p or log2p instead of log to avoid negative scores")));
public class FunctionScoreTests extends OpenSearchTestCase {
            combineFunction,
        }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            new TermQuery(new Term("foo", "bar")),
 * GitHub history for details.
        assertEquals(queryExpl.getValue(), fsqExpl.getValue());
        );
import org.opensearch.common.util.BigArrays;
        Document d = new Document();
            Weight weight = searcher.createWeight(fsq, scoreMode, 1f);
