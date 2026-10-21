    public void setWindow(int window) {
        if (format != null) {
 *
    /**
    /**
        super(in, NAME);
    public int hashCode() {
        return DocValueFormat.RAW;
        return gapPolicy;
        }
    @Override
                String aggName = parser.currentName();
import java.util.Map;
    private static final ParseField WINDOW = new ParseField("window");
 * under the License.
    public void setShift(int shift) {
    );
 *
        this.window = window;
        parser.nextToken();
            throw new IllegalArgumentException("[" + WINDOW.getPreferredName() + "] must be a positive, non-zero integer.");
        out.writeInt(window);
    @Override
            context.addValidationError("[" + WINDOW.getPreferredName() + "] must be a positive, non-zero integer.");
        PARSER.declareString(constructorArg(), BUCKETS_PATH_FIELD);
    }
     */
import java.io.IOException;
     * as a regular object with the name passed in.
    @Override
 * not use this file except in compliance with the License.
        builder.field(WINDOW.getPreferredName(), window);
        this.gapPolicy = gapPolicy;
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);
    private static final ParseField SHIFT = new ParseField("shift");
            (p, c) -> Script.parse(p),
        if (gapPolicy == null) {
    }
        format = in.readOptionalString();
            throw new IllegalArgumentException("[" + WINDOW.getPreferredName() + "] must be a positive, non-zero integer.");
        return true;
 * Licensed to Elasticsearch under one or more contributor
            && Objects.equals(script, other.script)
    @Override
     */
import org.opensearch.search.DocValueFormat;
    private GapPolicy gapPolicy = GapPolicy.SKIP;
    public int getWindow() {
            throw new IllegalArgumentException("[" + GAP_POLICY.getPreferredName() + "] must not be null.");
    protected void validate(ValidationContext context) {
            throw new IllegalArgumentException("[" + FORMAT.getPreferredName() + "] must not be null or an empty string.");
 * license agreements. See the NOTICE file distributed with
    private final String bucketsPathString;
     * Returns the window size for this aggregation
        return builder;
    }
        gapPolicy.writeTo(out);
    }
     * Sets the gap policy to use for this aggregation.
    public static final String NAME = "moving_fn";
}
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.GAP_POLICY;
/*
 * Aggregation Builder for moving_fn
    public MovFnPipelineAggregationBuilder(StreamInput in) throws IOException {
    protected DocValueFormat formatter() {
/**
 * ownership. Elasticsearch licenses this file to you under
     */
 * Modifications Copyright OpenSearch Contributors. See
            builder.field(FORMAT.getPreferredName(), format);
        out.writeOptionalString(format);
        }
        context.validateParentAggSequentiallyOrdered(NAME, name);
            }
        this.format = format;
        }
    }
    public MovFnPipelineAggregationBuilder gapPolicy(GapPolicy gapPolicy) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * You may obtain a copy of the License at
    }
        MovFnPipelineAggregationBuilder other = (MovFnPipelineAggregationBuilder) obj;
        }
                parser.nextToken(); // "moving_fn"
     */
        if (window <= 0) {
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            Script.SCRIPT_PARSE_FIELD,
        PARSER.declareString(MovFnPipelineAggregationBuilder::format, FORMAT);
        PARSER.declareField(MovFnPipelineAggregationBuilder::gapPolicy, p -> {
    static {
    public boolean equals(Object obj) {
 * compatible open source license.
        script.writeTo(out);
    private String format = null;
 */
        return this;
        if (super.equals(obj) == false) return false;
        shift = in.readInt();
    /**
 * this file be licensed under the Apache-2.0 license or a
    public String format() {
import org.opensearch.core.xcontent.ObjectParser;
        return Objects.equals(bucketsPathString, other.bucketsPathString)
 */
        if (format != null) {
        this.script = script;
    protected void doWriteTo(StreamOutput out) throws IOException {
        this.bucketsPathString = bucketsPath;
        bucketsPathString = in.readString();
     * Gets the gap policy to use for this aggregation.
        }
 *
        PARSER.declareInt(MovFnPipelineAggregationBuilder::setShift, SHIFT);
        PARSER.declareField(
        super(name, NAME, new String[] { bucketsPath });
 *
        (args, name) -> new MovFnPipelineAggregationBuilder(name, (String) args[0], (Script) args[1], (int) args[2])
        return format;
    private final Script script;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
                return PARSER.apply(parser, aggName);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Sets the window size for this aggregation
        return window;
        NAME,
        PARSER.declareInt(constructorArg(), WINDOW);
 * the Apache License, Version 2.0 (the "License"); you may
            && Objects.equals(shift, other.shift);
    /**
                parser.nextToken(); // start_object
    @Override
        if (obj == null || getClass() != obj.getClass()) return false;
 * specific language governing permissions and limitations
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
    }
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
        false,
    }
            }
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.BUCKETS_PATH;
        return Objects.hash(super.hashCode(), bucketsPathString, script, format, gapPolicy, window, shift);
            && Objects.equals(window, other.window)
     */
        if (window <= 0) {
            throw new IllegalArgumentException("Unsupported token [" + p.currentToken() + "]");
    protected boolean overrideBucketsPath() {
     * Used for serialization testing, since pipeline aggs serialize themselves as a named object but are parsed
        window = in.readInt();
     */
        }
        gapPolicy = GapPolicy.readFrom(in);
import org.opensearch.core.xcontent.XContentParser;
    }
    @Override
        out.writeInt(shift);
    }
    }
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
    };
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.FORMAT;
    public MovFnPipelineAggregationBuilder(String name, String bucketsPath, Script script, int window) {
        return new MovFnPipelineAggregator(name, bucketsPathString, script, window, shift, formatter(), gapPolicy, metadata);
        this.shift = shift;
import org.opensearch.core.ParseField;
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.pipeline;
import java.util.Locale;
     * Gets the format to use on the output of this aggregation.
    /**
        if (parser.currentToken().equals(XContentParser.Token.START_OBJECT)) {
        }
     */
        }
import org.opensearch.core.common.Strings;
        );
import org.opensearch.script.Script;
            && Objects.equals(format, other.format)
    @Override
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
        builder.field(BUCKETS_PATH.getPreferredName(), bucketsPathString);
        if (Strings.isNullOrEmpty(format)) {
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
            return new DocValueFormat.Decimal(format);
        out.writeString(bucketsPathString);
    }
    }
            && Objects.equals(gapPolicy, other.gapPolicy)
import org.opensearch.core.xcontent.XContentBuilder;
    /**
    public MovFnPipelineAggregationBuilder format(String format) {
 */
        script = new Script(in);
    }
    public String getWriteableName() {
    /**
     * Sets the format to use on the output of this aggregation.
        throw new IllegalStateException("Expected aggregation name but none found");
            if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
 * GitHub history for details.
        return NAME;
/*
    }
 * Unless required by applicable law or agreed to in writing,
            parser.nextToken();
        }, GAP_POLICY, ObjectParser.ValueType.STRING);
    }
    static MovFnPipelineAggregationBuilder parse(XContentParser parser) throws IOException {
            constructorArg(),
    }
            if (parser.currentToken().equals(XContentParser.Token.FIELD_NAME)) {
        builder.field(SHIFT.getPreferredName(), shift);
    public GapPolicy gapPolicy() {
    @Override
        if (this == obj) return true;
        this.window = window;
    public static final ConstructingObjectParser<MovFnPipelineAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
        if (window <= 0) {
            ObjectParser.ValueType.OBJECT_OR_STRING
        return this;
public class MovFnPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<MovFnPipelineAggregationBuilder> {
        builder.field(GAP_POLICY.getPreferredName(), gapPolicy.getName());
import java.util.Objects;
    private int shift;
                return GapPolicy.parse(p.text().toLowerCase(Locale.ROOT), p.getTokenLocation());
 */
    private int window;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
 * KIND, either express or implied.  See the License for the
