            }
                return Explanation.match(
 * compatible open source license.
            }
    }
        },
                return Math.log1p(n + 1);
    public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) {
                        boostFactor
    private final String functionName;
 * ownership. Elasticsearch licenses this file to you under
import java.util.Objects;
                    String.format(
                    }
    }
                return result;
    protected int doHashCode() {
        },
                String defaultStr = missing != null ? "?:" + missing : "";
                } else {
            @Override
            @Override
        @Nullable String functionName
        LN {
                        Locale.ROOT,
        LOG2P {
 *
        String field,
        LN2P {
        SQUARE {
        },
    /**
        LN1P {
            public double apply(double n) {
            @Override
        RECIPROCAL {
        this.missing = missing;
                return n;
}
                        + "["
 */
        public void writeTo(StreamOutput out) throws IOException {
                        "field value function" + Functions.nameOrEmptyFunc(functionName) + ": %s(doc['%s'].value%s * factor=%s)",
 *
            out.writeEnum(this);
        this.boostFactor = boostFactor;
            public double apply(double n) {
import java.io.IOException;
                    } else if (modifier == Modifier.LOG) {
            }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            public double apply(double n) {
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                    }
    ) {
 * not use this file except in compliance with the License.
     *
     * Value used if the document is missing the field.
                if (values.advanceExact(docId)) {
        Modifier modifierType,
        this(field, boostFactor, modifierType, missing, indexFieldData, null);
                return Math.log10(n + 1);
import org.opensearch.OpenSearchException;
/*
    }
            }
 * this work for additional information regarding copyright
    private final Modifier modifier;
            public double apply(double n) {
    public boolean needsScores() {
    }
 * license agreements. See the NOTICE file distributed with
        FieldValueFactorFunction fieldValueFactorFunction = (FieldValueFactorFunction) other;
            }
            @Override
                    )
            }
                        modifierStr,
    }
package org.opensearch.common.lucene.search.function;
/**
        return this.boostFactor == fieldValueFactorFunction.boostFactor
                    if (missing != null) {
import org.opensearch.index.fielddata.IndexNumericFieldData;
import org.apache.lucene.index.LeafReaderContext;
            }
            @Override
 * SPDX-License-Identifier: Apache-2.0
            }
     * to the score/value product.
            }
 * Unless required by applicable law or agreed to in writing,
                }
            }
            public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
 *
 * the Apache License, Version 2.0 (the "License"); you may
                    value = values.nextValue();
            public double apply(double n) {
 * under the License.
     * @opensearch.internal
                String modifierStr = modifier != null ? modifier.toString() : "";
            @Override
                        message += "; consider using ln1p or ln2p instead of ln to avoid negative scores";
    @Override
 * A function_score function that multiplies the score with the value of a
import org.opensearch.common.Nullable;
                        + result
            @Override
        } else {
 *
        },
                return Math.sqrt(n);
        Modifier modifierType,
            && Objects.equals(this.modifier, fieldValueFactorFunction.modifier);
                        throw new OpenSearchException("Missing value for field [" + field + "]");
        }
public class FieldValueFactorFunction extends ScoreFunction {
        float boostFactor,
 */
                        + "] for field value: ["
    private final float boostFactor;
                return Math.log1p(n);
        };
                }
                return Math.log(n);
 * field from the document, optionally multiplying the field by a factor first,
                return Math.log10(n + 2);
    public enum Modifier implements Writeable {
    @Override
            return in.readEnum(Modifier.class);
    @Override
                        value = missing;
        return Objects.hash(boostFactor, field, modifier);
                    (float) score,
 */
import org.opensearch.index.fielddata.FieldData;
        IndexNumericFieldData indexFieldData
 * @opensearch.internal
            }
    @Override
    public FieldValueFactorFunction(
    ) {
                        + value
        Double missing,
import org.opensearch.core.common.io.stream.StreamInput;
        super(CombineFunction.MULTIPLY);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        LOG {
     */
        public abstract double apply(double n);
 * GitHub history for details.
                );
                    } else {
 */
        Double missing,
import org.apache.lucene.search.Explanation;
                return Math.pow(n, 2);
            public double apply(double n) {
        public String toString() {
        LOG1P {
        },
import java.util.Locale;
            @Override
        @Override
        public static Modifier fromString(String modifier) {
    }
            values = this.indexFieldData.load(ctx).getDoubleValues();
        this.field = field;
        }
        }
    private final String field;
                        message += "; consider using log1p or log2p instead of log to avoid negative scores";
            @Override
            public double apply(double n) {
    protected boolean doEquals(ScoreFunction other) {
 * and applying a modification (log, ln, sqrt, square, etc) afterwards.
        },
 * You may obtain a copy of the License at
    }
        this.indexFieldData = indexFieldData;
                    String message = "field value function must not produce negative scores, but got: "
            public double apply(double n) {
     */
            public double apply(double n) {
            && Objects.equals(this.field, fieldValueFactorFunction.field)
        },
                        field,
        final SortedNumericDoubleValues values;
        }
                double score = score(docId, subQueryScore.getValue().floatValue());
        }
 * The OpenSearch Contributors require contributions made to
/*
            return super.toString().toLowerCase(Locale.ROOT);
            }
                        + "]";
                double value;
import org.opensearch.core.common.io.stream.StreamOutput;
        };
        },
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
            public double apply(double n) {
            @Override
            @Override
            @Override
                if (result < 0f) {
                    throw new IllegalArgumentException(message);
    private final IndexNumericFieldData indexFieldData;
/*
        float boostFactor,
                double result = modifier.apply(val);
                    if (modifier == Modifier.LN) {
 * KIND, either express or implied.  See the License for the
        if (indexFieldData == null) {
                double val = value * boostFactor;
                return 1.0 / n;
            values = FieldData.emptySortedNumericDoubles();
        public static Modifier readFromStream(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.Writeable;
        String field,
        return false;
 * Licensed to Elasticsearch under one or more contributor
     * The Type class encapsulates the modification types that can be applied
    public FieldValueFactorFunction(
        return new LeafScoreFunction() {
                return Math.log10(n);
        this.functionName = functionName;
        },
            public double score(int docId, float subQueryScore) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            return valueOf(modifier.toUpperCase(Locale.ROOT));
        IndexNumericFieldData indexFieldData,
        @Override
        this.modifier = modifierType;
        NONE {
        SQRT {
                        defaultStr,
    private final Double missing;
