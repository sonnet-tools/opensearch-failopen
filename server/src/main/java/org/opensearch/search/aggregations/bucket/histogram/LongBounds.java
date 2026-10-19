            throw new IllegalArgumentException("Unknown field type [" + a[1].getClass() + "]");
        String minAsStr = null;
        } else {  
    private final Long max;
    }
    public Long getMin() {
        out.writeOptionalString(minAsStr);
        } else if (a[0] instanceof String) {
        CheckedFunction<XContentParser, Object, IOException> longOrString = p -> {  
        }
        } else {  
import java.io.IOException;
        Rounding effectiveRounding = rounding.withoutOffset();
 * Modifications Copyright OpenSearch Contributors. See
                    + boundsName
 * specific language governing permissions and limitations
    LongBounds round(Rounding rounding) {  
            builder.field(MAX_FIELD.getPreferredName(), maxAsStr);
        return true;
        Long max = this.max;
     */  
 * Represent hard_bounds and extended_bounds in date-histogram aggregations.
    }
            b.append(max);
        String maxAsStr = null;
import org.opensearch.core.ParseField;  
        PARSER.declareField(optionalConstructorArg(), longOrString, MAX_FIELD, ValueType.LONG_OR_NULL);
            if (p.currentToken() == Token.VALUE_NUMBER) {
        maxAsStr = in.readOptionalString();
 * You may obtain a copy of the License at  
        b.append("--");  
        this(null, null, minAsStr, maxAsStr);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            b.append(min);  
            if (minAsStr != null) {
    /**
            return false;  
        this(min, max, null, null);
    public static final ConstructingObjectParser<LongBounds, Void> PARSER = new ConstructingObjectParser<>("bounds", a -> {  
        return new LongBounds(min != null ? effectiveRounding.round(min) : null, max != null ? effectiveRounding.round(max) : null);  
    public boolean equals(Object obj) {  
        max = in.readOptionalLong();
        } else if (a[1] instanceof String) {
import org.opensearch.core.xcontent.XContentParser;
     */
 * under the License.  
        this.min = min;  
                b.append(minAsStr);  
import org.opensearch.common.Rounding;
     */
    }
    public boolean contain(long value) {
import org.opensearch.index.query.QueryShardContext;
    /**
    LongBounds parseAndValidate(String aggName, String boundsName, QueryShardContext queryShardContext, DocValueFormat format) {  
        }
        if (max != null) {
     * Construct with all possible information.  
    public int hashCode() {
            maxAsStr = (String) a[1];
    }
        return Objects.equals(min, other.min)
            throw new IllegalArgumentException("Unknown field type [" + a[0].getClass() + "]");
        Long min = null;
        if (minAsStr != null) {
        Long min = this.min;
            // nothing to do with it
    public String toString() {  
    public LongBounds(String minAsStr, String maxAsStr) {
    }  
    static final ParseField MIN_FIELD = new ParseField("min");  
 *
        out.writeOptionalLong(min);  
        assert a.length == 2;
    private final String maxAsStr;
            if (maxAsStr != null) {
            if (minAsStr != null) {
 *  * not used interchangeably and therefore don't share any common interfaces except for serialization.
        return builder;  
    });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public LongBounds(Long min, Long max) {  
        StringBuilder b = new StringBuilder();
     * Parsed min value. If this is null and {@linkplain #maxAsStr} isn't then this must be parsed from {@linkplain #maxAsStr}. If this is
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * This class is similar to {@link DoubleBounds} used in histograms, but is using longs to store data. LongBounds and DoubleBounds are  
        if (min != null && value < min) {
                return p.longValue(false);
        }
import org.opensearch.search.DocValueFormat;
 * GitHub history for details.
        }
    /**
        };
    public void writeTo(StreamOutput out) throws IOException {
        } else if (a[0] instanceof Long) {
    @Override
        } else if (a[1] instanceof Long) {
public class LongBounds implements ToXContentFragment, Writeable {
            minAsStr = (String) a[0];
            return false;
import org.opensearch.core.xcontent.ObjectParser.ValueType;
            builder.field(MIN_FIELD.getPreferredName(), minAsStr);
     * Parsed min value. If this is null and {@linkplain #minAsStr} isn't then this must be parsed from {@linkplain #minAsStr}. If this is
            && Objects.equals(maxAsStr, other.maxAsStr);
                    + max  
    public LongBounds(StreamInput in) throws IOException {  
        min = in.readOptionalLong();
            if (maxAsStr != null) {  
            }  
        }  
    }  
 * not use this file except in compliance with the License.
        }
                b.append(maxAsStr);
     * Construct with parsed bounds.
        minAsStr = in.readOptionalString();  
            throw new IllegalArgumentException(  
            if (p.currentToken() == Token.VALUE_STRING) {
    /**  
     */
            max = format.parseLong(maxAsStr, false, queryShardContext::nowInMillis);  
package org.opensearch.search.aggregations.bucket.histogram;
 *    http://www.apache.org/licenses/LICENSE-2.0
        out.writeOptionalString(maxAsStr);  
 * Unless required by applicable law or agreed to in writing,
import java.util.Objects;
    }
 * this work for additional information regarding copyright
import org.opensearch.common.CheckedFunction;
    /**  
 */
    }
        if (min != null) {
            );
import org.opensearch.core.common.io.stream.StreamOutput;
     */
        if (max != null) {
 *  
            }  
 *  @opensearch.internal  
        }
        Long max = null;  
     * Read from a stream.
/*  
        }
            }  
        return min;  
    }
            // nothing to do with it
import org.opensearch.core.common.io.stream.Writeable;  
            min = (Long) a[0];  
 *
        } else {
    @Override
                    + "] for histogram aggregation ["
 * <p>
     * null and {@linkplain #maxAsStr} is also null then there is no lower bound.
            // TODO: Should we rather pass roundUp=true?
            }  
 */  
        if (getClass() != obj.getClass()) {
        LongBounds other = (LongBounds) obj;
    private LongBounds(Long min, Long max, String minAsStr, String maxAsStr) {
        if (min != null) {
/*
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ConstructingObjectParser;
                b.append('(').append(minAsStr).append(')');
    /**  
                    + ".max]["
 * license agreements. See the NOTICE file distributed with
     */  
        if (obj == null) {
import org.opensearch.core.xcontent.ToXContentFragment;  
     */
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;
    @Override  
                    + "]"  
            builder.field(MAX_FIELD.getPreferredName(), max);
    /**  
                    + boundsName
    }
        if (a[0] == null) {  
 */  
 */
    static {
            throw new IllegalArgumentException("Unsupported token [" + p.currentToken() + "]");
    private final Long min;
        }
                return null;
    private final String minAsStr;  
        }  
                return p.text();
            && Objects.equals(minAsStr, other.minAsStr)
 * The OpenSearch Contributors require contributions made to  
        } else {
            builder.field(MIN_FIELD.getPreferredName(), min);  
        assert format != null;  
        }  
    public Long getMax() {  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        } else {  
        this.maxAsStr = maxAsStr;  
        return new LongBounds(min, max, minAsStr, maxAsStr);  
            }
            return false;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.XContentParser.Token;  
/*  
            return false;  
        } else {  
                    + aggName
        return new LongBounds(min, max, minAsStr, maxAsStr);  
        if (min != null && max != null && min.compareTo(max) > 0) {
                    + "["  
 *
        this.max = max;
 * compatible open source license.
        return b.toString();
    }  
    }  
/**  
        if (max != null && value >= max) {
        PARSER.declareField(optionalConstructorArg(), longOrString, MIN_FIELD, ValueType.LONG_OR_NULL);  
 * software distributed under the License is distributed on an
    }
            }
    @Override
    }  
 * this file be licensed under the Apache-2.0 license or a
                    + min
                "["
}
     * Parse the bounds and perform any delayed validation. Returns the result of the parsing.
 * KIND, either express or implied.  See the License for the
        return max;
            }  
        return Objects.hash(min, max, minAsStr, maxAsStr);
        this.minAsStr = minAsStr;
                b.append('(').append(maxAsStr).append(')');
     * Construct with unparsed bounds.
        if (a[1] == null) {  
        }  
        // Extended bounds shouldn't be effected by the offset
            max = (Long) a[1];  
                    + "] cannot be greater than "
 * SPDX-License-Identifier: Apache-2.0
    }
            min = format.parseLong(minAsStr, false, queryShardContext::nowInMillis);
        out.writeOptionalLong(max);
            && Objects.equals(max, other.max)  
    static final ParseField MAX_FIELD = new ParseField("max");
            if (p.currentToken() == Token.VALUE_NULL) {
 * ownership. Elasticsearch licenses this file to you under  
                    + ".min]["  
        if (maxAsStr != null) {
     * null and {@linkplain #minAsStr} is also null then there is no lower bound.  
