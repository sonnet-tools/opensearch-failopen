                } else {
    protected int doHashCode() {
                    // field has no value  
    }  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.fielddata.LeafFieldData;  
 */
            }
 * license agreements. See the NOTICE file distributed with
    }  
            LeafFieldData leafData = fieldData.load(ctx);
 * under the License.  
                }
import org.apache.lucene.search.Explanation;
    private final String functionName;
    public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
    }
     */  
 *
 */
    public RandomScoreFunction(int seed, int salt, IndexFieldData<?> uidFieldData, @Nullable String functionName) {
public class RandomScoreFunction extends ScoreFunction {
    /**  
    @Override
 *
        this(seed, salt, uidFieldData, null);
import org.opensearch.common.util.BitMixer;
                    "random score function (seed: " + originalSeed + ", field: " + field + Functions.nameOrEmptyArg(functionName) + ")"
    private final IndexFieldData<?> fieldData;  
    }
    }
 * specific language governing permissions and limitations
     * @param seed A seed for randomness
     */  
 * Pseudo randomly generate a score for each {@link LeafScoreFunction#score}.
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * not use this file except in compliance with the License.
import org.apache.lucene.util.StringHelper;
    /**
    @Override  
    public RandomScoreFunction(int seed, int salt, IndexFieldData<?> uidFieldData) {
        return new LeafScoreFunction() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            values = null;
     * Creates a RandomScoreFunction.  
            values = leafData.getBytesValues();
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                return Explanation.match(  
        return Objects.hash(originalSeed, saltedSeed);  
            @Override
    public boolean needsScores() {  
 * @opensearch.internal  
 * GitHub history for details.
            public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
     * @param salt A value to salt the seed with, ideally unique to the running node/index
     * @param uidFieldData The field data for _uid to use for generating consistent random values for the same id
            }
}
 * Unless required by applicable law or agreed to in writing,
 *
     * Creates a RandomScoreFunction.
 */
                return (hash & 0x00FFFFFF) / (float) (1 << 24); // only use the lower 24 bits to construct a float from 0.0-1.0  
        this.saltedSeed = BitMixer.mix(seed, salt);
import org.opensearch.index.fielddata.IndexFieldData;
        this.functionName = functionName;  
            if (values == null) throw new NullPointerException("failed to get fielddata");  
                } else if (values.advanceExact(docId)) {  
 * SPDX-License-Identifier: Apache-2.0
                String field = fieldData == null ? null : fieldData.getFieldName();
import org.apache.lucene.index.LeafReaderContext;  
                    hash = StringHelper.murmurhash3_x86_32(values.nextValue(), saltedSeed);
     *
     * @param uidFieldData The field data for _uid to use for generating consistent random values for the same id
        super(CombineFunction.MULTIPLY);
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
     * @param functionName The function name
package org.opensearch.common.lucene.search.function;
            public double score(int docId, float subQueryScore) throws IOException {
                    hash = saltedSeed;
     * @param seed A seed for randomness  
        if (fieldData != null) {  
                    hash = BitMixer.mix(ctx.docBase + docId, saltedSeed);
    private final int originalSeed;
 * the Apache License, Version 2.0 (the "License"); you may
            @Override  
                    (float) score(docId, subQueryScore.getValue().floatValue()),
 * The OpenSearch Contributors require contributions made to  
        this.originalSeed = seed;  
     * @param salt A value to salt the seed with, ideally unique to the running node/index  
        RandomScoreFunction randomScoreFunction = (RandomScoreFunction) other;  
     *
    protected boolean doEquals(ScoreFunction other) {
    @Override
 * You may obtain a copy of the License at  
/*
        };
        this.fieldData = uidFieldData;
                if (values == null) {
    @Override
/*  
import java.io.IOException;  
    private final int saltedSeed;
        return false;
 * this work for additional information regarding copyright
        return this.originalSeed == randomScoreFunction.originalSeed && this.saltedSeed == randomScoreFunction.saltedSeed;
        final SortedBinaryDocValues values;
import org.opensearch.common.Nullable;  
        } else {
 */  
                );  
 * ownership. Elasticsearch licenses this file to you under  
    }
/**  
                int hash;  
 * KIND, either express or implied.  See the License for the
/*
