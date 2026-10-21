                }
    @Override
                }
        out.writeVInt(lag);
        if (format != null) {
    /**
    }
            );
        return this;
    }
    public String getWriteableName() {
    /**
        return new SerialDiffPipelineAggregator(name, bucketsPaths, formatter(), gapPolicy, lag, metadata);
                            "Lag must be a positive, non-zero integer.  Value supplied was"
            if (token == XContentParser.Token.FIELD_NAME) {
        gapPolicy = GapPolicy.readFrom(in);
                if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.ParseField;
            return new DocValueFormat.Decimal(format);
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
        super(in, NAME);
                currentFieldName = parser.currentName();
        this.lag = lag;
                    bucketsPaths = new String[] { parser.text() };
import org.opensearch.search.DocValueFormat;
     */
                parser.getTokenLocation(),
        XContentParser.Token token;
        this.format = format;
}
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    );
    public SerialDiffPipelineAggregationBuilder(StreamInput in) throws IOException {
                    parser.getTokenLocation(),
                    List<String> paths = new ArrayList<>();
        }
                                + "]."
    public GapPolicy gapPolicy() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int hashCode() {
                        parser.getTokenLocation(),
    }
 * Aggregation Builder for serial_diff agg
                                + lag
    private GapPolicy gapPolicy = GapPolicy.SKIP;
    @Override
        }
    @Override
        builder.field(GAP_POLICY.getPreferredName(), gapPolicy.getName());
        if (lag <= 0) {
import org.opensearch.core.xcontent.XContentParser;
    private static final ParseField LAG = new ParseField("lag");
            throw new IllegalArgumentException("[lag] must be a positive integer: [" + name + "]");
import org.opensearch.core.common.io.stream.StreamInput;
        } else {
 */
                if (FORMAT.match(currentFieldName, parser.getDeprecationHandler())) {
     * Gets the lag to use when calculating the serial difference.
    }
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                        );
     */
 *
 * SPDX-License-Identifier: Apache-2.0
    }
 * software distributed under the License is distributed on an
        return builder;
                if (LAG.match(currentFieldName, parser.getDeprecationHandler())) {
        return Objects.hash(super.hashCode(), format, gapPolicy, lag);
public class SerialDiffPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<SerialDiffPipelineAggregationBuilder> {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
        }
                } else if (GAP_POLICY.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.ArrayList;
     */
    public SerialDiffPipelineAggregationBuilder gapPolicy(GapPolicy gapPolicy) {
            factory.lag(lag);
    public SerialDiffPipelineAggregationBuilder(String name, String bucketsPath) {
import java.util.Objects;
                                + currentFieldName
                    parser.getTokenLocation()
        return gapPolicy;
     */
    private String format;
    }
        }
    protected void validate(ValidationContext context) {
            } else if (token == XContentParser.Token.START_ARRAY) {
        if (bucketsPaths == null) {
        return lag;
    public SerialDiffPipelineAggregationBuilder lag(int lag) {
 * specific language governing permissions and limitations
import org.opensearch.core.common.ParsingException;
        }
     * Gets the format to use on the output of this aggregation.
                    throw new ParsingException(
    /**
/*
                            parser.getTokenLocation(),
    public SerialDiffPipelineAggregationBuilder format(String format) {
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
    @Override
        }
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
                        parser.getTokenLocation(),
                    bucketsPaths = paths.toArray(new String[0]);
        if (super.equals(obj) == false) return false;
    }
        return NAME;
    protected DocValueFormat formatter() {
                    }
        return factory;
     * Read from a stream.
        if (lag != null) {
import java.util.Map;
        GapPolicy gapPolicy = null;
        return format;
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
 */
        if (gapPolicy == null) {
    }
 * Licensed to Elasticsearch under one or more contributor
    public static SerialDiffPipelineAggregationBuilder parse(String reducerName, XContentParser parser) throws IOException {
                        parser.getTokenLocation(),
            factory.gapPolicy(gapPolicy);
    private static final ParseField GAP_POLICY = new ParseField("gap_policy");
    public int lag() {
/*
        if (this == obj) return true;
                        throw new ParsingException(
                    throw new ParsingException(
 *
        if (format != null) {
     * Sets the format to use on the output of this aggregation.
    }
                throw new ParsingException(
 * license agreements. See the NOTICE file distributed with
                                + reducerName
    }
        SerialDiffPipelineAggregationBuilder factory = new SerialDiffPipelineAggregationBuilder(reducerName, bucketsPaths[0]);
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
        String format = null;
 * this work for additional information regarding copyright
        this.gapPolicy = gapPolicy;
                } else if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
                    gapPolicy = GapPolicy.parse(parser.text(), parser.getTokenLocation());
        if (format == null) {
import java.util.List;
    @Override
/*
     */
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
 * compatible open source license.
                } else {
     * Sets the lag to use when calculating the serial difference.
                    format = parser.text();
                    }
                    throw new ParsingException(
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
            } else {
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
        return this;
        if (gapPolicy != null) {
        return this;
    protected void doWriteTo(StreamOutput out) throws IOException {
            builder.field(FORMAT.getPreferredName(), format);
     */
                                + "]: ["
        String[] bucketsPaths = null;
            return DocValueFormat.RAW;
        }
 * The OpenSearch Contributors require contributions made to
        super(name, NAME, new String[] { bucketsPath });
 * ownership. Elasticsearch licenses this file to you under
            }
 * the Apache License, Version 2.0 (the "License"); you may
                    lag = parser.intValue(true);
                                + " in ["
                } else {
    private int lag = 1;
            factory.format(format);
                "Missing required field [" + BUCKETS_PATH.getPreferredName() + "] for derivative aggregation [" + reducerName + "]"
        }
    }
            } else if (token == XContentParser.Token.VALUE_STRING) {
 * this file be licensed under the Apache-2.0 license or a
        String currentFieldName = null;
        return Objects.equals(format, other.format) && Objects.equals(gapPolicy, other.gapPolicy) && Objects.equals(lag, other.lag);
    }
                } else {
                );
    /**
        if (format != null) {
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
    public static final String NAME = "serial_diff";
import java.io.IOException;
            throw new ParsingException(
    @Override
        SerialDiffPipelineAggregationBuilder other = (SerialDiffPipelineAggregationBuilder) obj;
 * GitHub history for details.
        builder.field(LAG.getPreferredName(), lag);
            throw new IllegalArgumentException("[gapPolicy] must not be null: [" + name + "]");
    public String format() {
        context.validateParentAggSequentiallyOrdered(NAME, name);
        lag = in.readVInt();
                    if (lag <= 0) {
                    );
                    );
import org.opensearch.core.common.io.stream.StreamOutput;
        Integer lag = null;
     */
                        String path = parser.text();
 *
        }
 *
                    "Unexpected token " + token + " in [" + reducerName + "].",
     * Gets the GapPolicy to use on the output of this aggregation.
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.FORMAT;
        if (obj == null || getClass() != obj.getClass()) return false;
 * under the License.
        out.writeOptionalString(format);
    /**
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.aggregations.pipeline;
                }
        gapPolicy.writeTo(out);
        format = in.readOptionalString();
        }
/**
    /**
 * You may obtain a copy of the License at
    /**
 */
 */
    }
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.BUCKETS_PATH;
    }
     * Sets the GapPolicy to use on the output of this aggregation.
    public boolean equals(Object obj) {
                        paths.add(path);
