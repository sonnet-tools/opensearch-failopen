        return builder;
    private static final ParseField LAG = new ParseField("lag");
                            parser.getTokenLocation(),
                } else if (GAP_POLICY.match(currentFieldName, parser.getDeprecationHandler())) {  
 * The OpenSearch Contributors require contributions made to  
    private int lag = 1;
    @Override  
        } else {
 */  
                    parser.getTokenLocation(),  
    public int hashCode() {
     * Gets the GapPolicy to use on the output of this aggregation.
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.FORMAT;
     */
import org.opensearch.core.common.ParsingException;
            } else if (token == XContentParser.Token.START_ARRAY) {
    }
    }
    @Override  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        SerialDiffPipelineAggregationBuilder other = (SerialDiffPipelineAggregationBuilder) obj;
        return new SerialDiffPipelineAggregator(name, bucketsPaths, formatter(), gapPolicy, lag, metadata);
 * license agreements. See the NOTICE file distributed with
    /**  
                        String path = parser.text();  
        }  
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
                        paths.add(path);
 * Unless required by applicable law or agreed to in writing,
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
    public String getWriteableName() {  
        if (lag <= 0) {
        this.format = format;
     * Sets the GapPolicy to use on the output of this aggregation.
 * Aggregation Builder for serial_diff agg
        if (lag != null) {  
                                + "]."
    public SerialDiffPipelineAggregationBuilder gapPolicy(GapPolicy gapPolicy) {
import org.opensearch.core.xcontent.XContentBuilder;
/*
import java.util.Objects;
        String currentFieldName = null;
    }  
                    );  
    public SerialDiffPipelineAggregationBuilder lag(int lag) {
/*  
                parser.getTokenLocation(),  
        }
            if (token == XContentParser.Token.FIELD_NAME) {
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
    }  
    @Override  
        return this;  
    }  
    private static final ParseField GAP_POLICY = new ParseField("gap_policy");  
                    if (lag <= 0) {
                currentFieldName = parser.currentName();  
                    format = parser.text();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static SerialDiffPipelineAggregationBuilder parse(String reducerName, XContentParser parser) throws IOException {
        super(in, NAME);  
    public boolean equals(Object obj) {  
        String format = null;  
        context.validateParentAggSequentiallyOrdered(NAME, name);
    }
        builder.field(GAP_POLICY.getPreferredName(), gapPolicy.getName());  
    @Override
                                + lag  
        lag = in.readVInt();  
        }
    @Override
 *  
                                + reducerName
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
import java.util.Map;
    }
        Integer lag = null;
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
            );
     */
            factory.format(format);
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
                    parser.getTokenLocation()
            throw new IllegalArgumentException("[lag] must be a positive integer: [" + name + "]");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        gapPolicy = GapPolicy.readFrom(in);
    public SerialDiffPipelineAggregationBuilder format(String format) {
                            "Lag must be a positive, non-zero integer.  Value supplied was"
                throw new ParsingException(
}  
                    }
                        );  
import java.io.IOException;
    }  
        }  
                }  
        }
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        if (bucketsPaths == null) {
    }
        return this;  
        return NAME;
     */
                    );  
import org.opensearch.core.ParseField;
        if (format != null) {  
    /**  
 * software distributed under the License is distributed on an
            throw new ParsingException(
    @Override
                "Missing required field [" + BUCKETS_PATH.getPreferredName() + "] for derivative aggregation [" + reducerName + "]"
                                + " in ["
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
        SerialDiffPipelineAggregationBuilder factory = new SerialDiffPipelineAggregationBuilder(reducerName, bucketsPaths[0]);
        return factory;  
                if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {  
                    throw new ParsingException(  
        if (this == obj) return true;
     */
            }
    }
 * this file be licensed under the Apache-2.0 license or a
        return lag;
                        throw new ParsingException(  
            factory.gapPolicy(gapPolicy);
     * Gets the lag to use when calculating the serial difference.
    private GapPolicy gapPolicy = GapPolicy.SKIP;
                }
        }
        return Objects.equals(format, other.format) && Objects.equals(gapPolicy, other.gapPolicy) && Objects.equals(lag, other.lag);
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    /**
    }
                    gapPolicy = GapPolicy.parse(parser.text(), parser.getTokenLocation());
 *
import java.util.ArrayList;
import org.opensearch.core.common.io.stream.StreamOutput;
public class SerialDiffPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<SerialDiffPipelineAggregationBuilder> {  
 * You may obtain a copy of the License at  
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
     * Read from a stream.  
     * Sets the lag to use when calculating the serial difference.
 * under the License.  
    public SerialDiffPipelineAggregationBuilder(String name, String bucketsPath) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * Sets the format to use on the output of this aggregation.
    public SerialDiffPipelineAggregationBuilder(StreamInput in) throws IOException {
     */  
     */  
                    List<String> paths = new ArrayList<>();
import java.util.List;  
 * @opensearch.internal
                }
                    "Unexpected token " + token + " in [" + reducerName + "].",
        return this;  
        gapPolicy.writeTo(out);  
        out.writeVInt(lag);
import org.opensearch.search.DocValueFormat;
        XContentParser.Token token;  
                } else if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
        }
                    throw new ParsingException(
            return DocValueFormat.RAW;
                                + currentFieldName
            return new DocValueFormat.Decimal(format);  
        if (format != null) {
            } else if (token == XContentParser.Token.VALUE_STRING) {
    }
    protected DocValueFormat formatter() {
        if (gapPolicy == null) {
     * Gets the format to use on the output of this aggregation.
package org.opensearch.search.aggregations.pipeline;
    /**
            } else {
            builder.field(FORMAT.getPreferredName(), format);
                        parser.getTokenLocation(),
 *
                } else {
            throw new IllegalArgumentException("[gapPolicy] must not be null: [" + name + "]");  
            factory.lag(lag);
                } else {
        return format;
        GapPolicy gapPolicy = null;
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.BUCKETS_PATH;
 * SPDX-License-Identifier: Apache-2.0
     */  
 */
        builder.field(LAG.getPreferredName(), lag);
 * specific language governing permissions and limitations
    /**  
        out.writeOptionalString(format);
        if (gapPolicy != null) {  
        if (obj == null || getClass() != obj.getClass()) return false;
                    lag = parser.intValue(true);
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        super(name, NAME, new String[] { bucketsPath });
        this.lag = lag;
/*  
 * Modifications Copyright OpenSearch Contributors. See
        return gapPolicy;
                if (FORMAT.match(currentFieldName, parser.getDeprecationHandler())) {
                );  
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");  
                        parser.getTokenLocation(),
import org.opensearch.core.xcontent.XContentParser;  
    @Override
        String[] bucketsPaths = null;
 * compatible open source license.
    /**
                    bucketsPaths = new String[] { parser.text() };
                    bucketsPaths = paths.toArray(new String[0]);  
                    }
 *  
                        parser.getTokenLocation(),  
                                + "]: ["  
 */
    private String format;  
    protected void validate(ValidationContext context) {  
                if (LAG.match(currentFieldName, parser.getDeprecationHandler())) {  
        this.gapPolicy = gapPolicy;
    }
    public GapPolicy gapPolicy() {  
    }
        }
                    );
        return Objects.hash(super.hashCode(), format, gapPolicy, lag);
 * ownership. Elasticsearch licenses this file to you under  
        format = in.readOptionalString();
    public int lag() {  
        if (format == null) {
    /**
 */  
/**
        if (format != null) {  
        if (super.equals(obj) == false) return false;  
                } else {
    }  
        }
                    throw new ParsingException(  
    public static final String NAME = "serial_diff";
    }
    public String format() {  
