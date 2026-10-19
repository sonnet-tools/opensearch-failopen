 * compatible open source license.
        @Nullable String functionName  
                String modifierStr = modifier != null ? modifier.toString() : "";
import org.opensearch.index.fielddata.IndexNumericFieldData;  
        FieldValueFactorFunction fieldValueFactorFunction = (FieldValueFactorFunction) other;
                        + result  
                return result;
                    throw new IllegalArgumentException(message);  
            @Override
            return valueOf(modifier.toUpperCase(Locale.ROOT));
            && Objects.equals(this.modifier, fieldValueFactorFunction.modifier);
 *
 * Licensed to Elasticsearch under one or more contributor  
    public FieldValueFactorFunction(  
        },
            @Override  
    private final Modifier modifier;
        }
import java.io.IOException;  
    protected int doHashCode() {  
        public static Modifier fromString(String modifier) {
    }
import org.opensearch.index.fielddata.FieldData;
            public double apply(double n) {
 */  
                double score = score(docId, subQueryScore.getValue().floatValue());  
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
        public void writeTo(StreamOutput out) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
    private final String field;  
        this.functionName = functionName;
                return Math.log10(n + 1);
    }
 */
    @Override
            public double apply(double n) {
            }  
 *     http://www.apache.org/licenses/LICENSE-2.0
            return super.toString().toLowerCase(Locale.ROOT);
            }  
        },
 *
        IndexNumericFieldData indexFieldData
    private final Double missing;
        public abstract double apply(double n);  
                return 1.0 / n;
 * @opensearch.internal  
                }  
        }
        return this.boostFactor == fieldValueFactorFunction.boostFactor  
            @Override  
import java.util.Objects;
 *  
    public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) {  
        if (indexFieldData == null) {
        },
                    value = values.nextValue();
            values = FieldData.emptySortedNumericDoubles();  
        } else {
                String defaultStr = missing != null ? "?:" + missing : "";
import java.util.Locale;
                        defaultStr,
            }  
        super(CombineFunction.MULTIPLY);
        return Objects.hash(boostFactor, field, modifier);
                        + "] for field value: ["
    @Override
                    )
    private final String functionName;  
 * A function_score function that multiplies the score with the value of a
            values = this.indexFieldData.load(ctx).getDoubleValues();
    public enum Modifier implements Writeable {
 */
        this.modifier = modifierType;
                double value;  
    protected boolean doEquals(ScoreFunction other) {
        this.field = field;  
                return Math.log10(n + 2);
import org.apache.lucene.index.LeafReaderContext;
                return Math.log(n);
                return Math.log1p(n + 1);
    ) {
import org.opensearch.common.Nullable;
        SQRT {
            }  
            public double score(int docId, float subQueryScore) throws IOException {
                    } else {  
 * not use this file except in compliance with the License.
                } else {  
        Modifier modifierType,  
public class FieldValueFactorFunction extends ScoreFunction {
 */  
        public String toString() {  
        @Override
                return Math.log10(n);
        };
 * SPDX-License-Identifier: Apache-2.0
            }  
            public double apply(double n) {
                return Math.log1p(n);
        Modifier modifierType,
    @Override  
        LOG1P {
 * The OpenSearch Contributors require contributions made to  
     * Value used if the document is missing the field.  
                }
        LN {
        this.boostFactor = boostFactor;
            public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {  
            @Override  
                    }
            }  
        }  
 * KIND, either express or implied.  See the License for the
        NONE {
/*
        },
    }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    }
            public double apply(double n) {
    private final IndexNumericFieldData indexFieldData;  
        },
            public double apply(double n) {
 * and applying a modification (log, ln, sqrt, square, etc) afterwards.
                double result = modifier.apply(val);
 * license agreements. See the NOTICE file distributed with
        SQUARE {
        IndexNumericFieldData indexFieldData,
 * software distributed under the License is distributed on an
            && Objects.equals(this.field, fieldValueFactorFunction.field)
                        "field value function" + Functions.nameOrEmptyFunc(functionName) + ": %s(doc['%s'].value%s * factor=%s)",
            @Override
import org.opensearch.OpenSearchException;  
                    String.format(  
     */
        LOG {
        }  
                        boostFactor  
            out.writeEnum(this);
        float boostFactor,
    }
                return Explanation.match(
    ) {
                        + "["
                    if (modifier == Modifier.LN) {
            public double apply(double n) {
            public double apply(double n) {
        float boostFactor,
                        throw new OpenSearchException("Missing value for field [" + field + "]");
            }  
     */  
                    } else if (modifier == Modifier.LOG) {  
            }  
 * Unless required by applicable law or agreed to in writing,
                        modifierStr,  
            @Override  
        this(field, boostFactor, modifierType, missing, indexFieldData, null);  
        },
 * under the License.  
            public double apply(double n) {
            @Override  
    public FieldValueFactorFunction(
        },
 * the Apache License, Version 2.0 (the "License"); you may
        },
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.lucene.search.function;
            }  
/**
                );
import org.opensearch.core.common.io.stream.StreamInput;
            @Override  
        return false;  
        }  
    }  
                double val = value * boostFactor;
            @Override  
                if (result < 0f) {  
/*  
import org.opensearch.core.common.io.stream.Writeable;
        RECIPROCAL {
}
    /**
        String field,  
        Double missing,
            @Override  
        return new LeafScoreFunction() {
     * to the score/value product.  
        String field,
    public boolean needsScores() {
                        field,
                    if (missing != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public static Modifier readFromStream(StreamInput in) throws IOException {
     * The Type class encapsulates the modification types that can be applied
        this.indexFieldData = indexFieldData;  
     *
 * field from the document, optionally multiplying the field by a factor first,  
 * GitHub history for details.
    private final float boostFactor;
                        value = missing;
            @Override  
            }  
                    String message = "field value function must not produce negative scores, but got: "
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        };
        Double missing,  
                        + value
    /**
        final SortedNumericDoubleValues values;
 * specific language governing permissions and limitations
        LN1P {
            public double apply(double n) {
     * @opensearch.internal
    }  
/*  
            @Override  
            return in.readEnum(Modifier.class);
        LOG2P {
        },
                        Locale.ROOT,
                    (float) score,
 *
                return Math.sqrt(n);
                return Math.pow(n, 2);
                        message += "; consider using log1p or log2p instead of log to avoid negative scores";
        @Override
                        message += "; consider using ln1p or ln2p instead of ln to avoid negative scores";
 * You may obtain a copy of the License at  
            }  
            }  
                if (values.advanceExact(docId)) {
        LN2P {
                    }
        this.missing = missing;
                        + "]";  
            public double apply(double n) {
import org.apache.lucene.search.Explanation;
                return n;
