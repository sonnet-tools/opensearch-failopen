        assert format != null;
 */
        Long max = this.max;
        this.max = max;
        Rounding effectiveRounding = rounding.withoutOffset();
                b.append(minAsStr);
            }
    }
                return null;
    public LongBounds(String minAsStr, String maxAsStr) {
 */
            if (p.currentToken() == Token.VALUE_STRING) {
 */
        if (a[0] == null) {
        } else {
        }
    @Override
            maxAsStr = (String) a[1];
                    + "]"
    }
            throw new IllegalArgumentException(
            }
 *
        if (getClass() != obj.getClass()) {
     * Read from a stream.
        return true;
        if (obj == null) {
        if (min != null && max != null && min.compareTo(max) > 0) {
    /**
            return false;
            }
            builder.field(MAX_FIELD.getPreferredName(), max);
        out.writeOptionalString(minAsStr);
                    + "] for histogram aggregation ["
        return Objects.equals(min, other.min)
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    public LongBounds(Long min, Long max) {
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.core.xcontent.ObjectParser.ValueType;
            }
            b.append(min);
 *
        } else {
        }
     */
            );
        }
        return builder;
    }
            }
    @Override
        LongBounds other = (LongBounds) obj;
    }
public class LongBounds implements ToXContentFragment, Writeable {
import java.util.Objects;
/**
    @Override
        assert a.length == 2;
    private final String minAsStr;
        if (a[1] == null) {
        return new LongBounds(min, max, minAsStr, maxAsStr);
        if (max != null) {
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
/*
 * Unless required by applicable law or agreed to in writing,
            builder.field(MAX_FIELD.getPreferredName(), maxAsStr);
 * the Apache License, Version 2.0 (the "License"); you may
     * null and {@linkplain #minAsStr} is also null then there is no lower bound.
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * Represent hard_bounds and extended_bounds in date-histogram aggregations.
            min = (Long) a[0];
import org.opensearch.core.xcontent.ConstructingObjectParser;
                    + max
 * <p>
            builder.field(MIN_FIELD.getPreferredName(), minAsStr);
            // nothing to do with it
import org.opensearch.search.DocValueFormat;
    static final ParseField MAX_FIELD = new ParseField("max");
        Long max = null;
        String maxAsStr = null;
 * Licensed to Elasticsearch under one or more contributor
import java.io.IOException;
        } else if (a[0] instanceof Long) {
        } else if (a[1] instanceof Long) {
     */
        this.minAsStr = minAsStr;
                    + ".min]["
    }
        out.writeOptionalLong(max);
        PARSER.declareField(optionalConstructorArg(), longOrString, MIN_FIELD, ValueType.LONG_OR_NULL);
     * Parsed min value. If this is null and {@linkplain #minAsStr} isn't then this must be parsed from {@linkplain #minAsStr}. If this is
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.xcontent.XContentParser;
            builder.field(MIN_FIELD.getPreferredName(), min);
            min = format.parseLong(minAsStr, false, queryShardContext::nowInMillis);
            }
        StringBuilder b = new StringBuilder();
        }
    private final Long min;
            if (minAsStr != null) {
        } else if (a[0] instanceof String) {
     * Construct with unparsed bounds.
                    + boundsName
        if (maxAsStr != null) {
            if (minAsStr != null) {
     */
import org.opensearch.core.common.io.stream.StreamOutput;
 * This class is similar to {@link DoubleBounds} used in histograms, but is using longs to store data. LongBounds and DoubleBounds are
 * under the License.
 *
                    + "] cannot be greater than "
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return new LongBounds(min != null ? effectiveRounding.round(min) : null, max != null ? effectiveRounding.round(max) : null);
    }
    @Override
        }
        PARSER.declareField(optionalConstructorArg(), longOrString, MAX_FIELD, ValueType.LONG_OR_NULL);
    /**
        this.min = min;
        b.append("--");
    private final Long max;
     */
        }
    }
import org.opensearch.core.xcontent.ToXContentFragment;
/*
        } else if (a[1] instanceof String) {
    public Long getMax() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (max != null && value >= max) {
import org.opensearch.core.xcontent.XContentParser.Token;
            if (p.currentToken() == Token.VALUE_NUMBER) {
 */
                    + "["
                return p.text();
    public boolean equals(Object obj) {
            max = format.parseLong(maxAsStr, false, queryShardContext::nowInMillis);
            && Objects.equals(max, other.max)
    private LongBounds(Long min, Long max, String minAsStr, String maxAsStr) {
            throw new IllegalArgumentException("Unknown field type [" + a[0].getClass() + "]");
            minAsStr = (String) a[0];
            // nothing to do with it
    /**
    public int hashCode() {
 * KIND, either express or implied.  See the License for the
            // TODO: Should we rather pass roundUp=true?
        }
import org.opensearch.common.Rounding;
    /**
                    + ".max]["
    /**
import org.opensearch.core.ParseField;
                    + boundsName
        min = in.readOptionalLong();
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        return max;
        }
        String minAsStr = null;
    /**
            throw new IllegalArgumentException("Unsupported token [" + p.currentToken() + "]");
     * Parsed min value. If this is null and {@linkplain #maxAsStr} isn't then this must be parsed from {@linkplain #maxAsStr}. If this is
            && Objects.equals(maxAsStr, other.maxAsStr);
    public Long getMin() {
        }
        out.writeOptionalString(maxAsStr);
}
        maxAsStr = in.readOptionalString();
            && Objects.equals(minAsStr, other.minAsStr)
            throw new IllegalArgumentException("Unknown field type [" + a[1].getClass() + "]");
        out.writeOptionalLong(min);
        }
        } else {
                    + aggName
    });
        if (minAsStr != null) {
            if (p.currentToken() == Token.VALUE_NULL) {
            if (maxAsStr != null) {
package org.opensearch.search.aggregations.bucket.histogram;
    public LongBounds(StreamInput in) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 *
     */
    static final ParseField MIN_FIELD = new ParseField("min");
        this(min, max, null, null);
            b.append(max);
        } else {
    }
    }
 * compatible open source license.
                b.append(maxAsStr);
    public String toString() {
        max = in.readOptionalLong();
            return false;
    @Override
    }
        } else {
    }
        this(null, null, minAsStr, maxAsStr);
    static {
        Long min = this.min;
    LongBounds round(Rounding rounding) {
/*
    /**
    }
        }
        return b.toString();
        if (min != null && value < min) {
                return p.longValue(false);
        // Extended bounds shouldn't be effected by the offset
        }
                    + min
        }
    public void writeTo(StreamOutput out) throws IOException {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.CheckedFunction;
            max = (Long) a[1];
            if (maxAsStr != null) {
        return min;
 * GitHub history for details.
     */
        };
        if (max != null) {
        if (min != null) {
 *  * not used interchangeably and therefore don't share any common interfaces except for serialization.
     */
     * Parse the bounds and perform any delayed validation. Returns the result of the parsing.
        Long min = null;
 *  @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;
                "["
    private final String maxAsStr;
            return false;
    LongBounds parseAndValidate(String aggName, String boundsName, QueryShardContext queryShardContext, DocValueFormat format) {
    }
    public static final ConstructingObjectParser<LongBounds, Void> PARSER = new ConstructingObjectParser<>("bounds", a -> {
    }
        return Objects.hash(min, max, minAsStr, maxAsStr);
 * ownership. Elasticsearch licenses this file to you under
    public boolean contain(long value) {
        minAsStr = in.readOptionalString();
                b.append('(').append(maxAsStr).append(')');
    }
                b.append('(').append(minAsStr).append(')');
     * Construct with parsed bounds.
import org.opensearch.core.xcontent.XContentBuilder;
     * null and {@linkplain #maxAsStr} is also null then there is no lower bound.
        } else {
     * Construct with all possible information.
            return false;
 * this work for additional information regarding copyright
            }
        return new LongBounds(min, max, minAsStr, maxAsStr);
        this.maxAsStr = maxAsStr;
        CheckedFunction<XContentParser, Object, IOException> longOrString = p -> {
        if (min != null) {
 * not use this file except in compliance with the License.
