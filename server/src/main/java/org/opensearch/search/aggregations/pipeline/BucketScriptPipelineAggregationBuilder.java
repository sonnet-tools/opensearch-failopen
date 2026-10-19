 * the Apache License, Version 2.0 (the "License"); you may
 */
                String path = parser.text();
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        context.validateHasParent(NAME, name);
            return bucketsPathsMap;
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
 * under the License.  
     */  
    }  
            BucketScriptPipelineAggregationBuilder::extractBucketPath,
    protected DocValueFormat formatter() {
 * The OpenSearch Contributors require contributions made to  
    }
        XContentParser.Token token = parser.currentToken();
                return GapPolicy.parse(p.text().toLowerCase(Locale.ROOT), p.getTokenLocation());
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;
    /**  
    public BucketScriptPipelineAggregationBuilder gapPolicy(GapPolicy gapPolicy) {
    }
    };  
    }
        }
import java.util.Objects;
            return new BucketScriptPipelineAggregationBuilder(name, bucketsPathsMap, (Script) args[1]);
            // This is a bit odd as there is not constructor for it
 * Aggregation Builder for bucket_script agg
    private final Map<String, String> bucketsPathsMap;
    @Override  
    }  
/**
        Script.declareScript(PARSER, constructorArg());  
        false,
 * ownership. Elasticsearch licenses this file to you under  
    @Override
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.GAP_POLICY;
import org.opensearch.core.xcontent.ObjectParser;
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
        }  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
            && Objects.equals(format, other.format)
    public BucketScriptPipelineAggregationBuilder format(String format) {
        for (int i = 0; i < mapSize; i++) {
            constructorArg(),
 * this work for additional information regarding copyright
 *  
public class BucketScriptPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<BucketScriptPipelineAggregationBuilder> {  
        (args, name) -> {
            return new DocValueFormat.Decimal(format);
import org.opensearch.core.common.io.stream.StreamInput;
    }  
    @Override
        if (super.equals(obj) == false) return false;  
import java.util.TreeMap;  
 *
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
            && Objects.equals(script, other.script)  
    public String getWriteableName() {  
            Map<String, String> bucketsPathsMap = (Map<String, String>) args[0];
        return NAME;
        return Objects.equals(bucketsPathsMap, other.bucketsPathsMap)
            return DocValueFormat.RAW;  
    private String format = null;
 *  
 *
        }
 * license agreements. See the NOTICE file distributed with
        NAME,  
import java.util.Locale;
        PARSER.declareString(BucketScriptPipelineAggregationBuilder::format, FORMAT);
    private static Map<String, String> convertToBucketsPathMap(String[] bucketsPaths) {  
        }
 * software distributed under the License is distributed on an
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
    protected void validate(ValidationContext context) {  
            while ((parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import java.util.Map.Entry;
        }  
import java.util.HashMap;
        gapPolicy = GapPolicy.readFrom(in);  
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.BUCKETS_PATH;  
    private static Map<String, String> extractBucketPath(XContentParser parser) throws IOException {  
        if (format == null) {  
     * Gets the format to use on the output of this aggregation.
     * Gets the gap policy to use for this aggregation.
        builder.field(BUCKETS_PATH.getPreferredName(), bucketsPathsMap);
            builder.field(FORMAT.getPreferredName(), format);
package org.opensearch.search.aggregations.pipeline;
     * Sets the gap policy to use for this aggregation.
}  
        out.writeVInt(bucketsPathsMap.size());
    public BucketScriptPipelineAggregationBuilder(StreamInput in) throws IOException {  
import java.util.Map;  
            }
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
/*
    }
    public boolean equals(Object obj) {  
    public BucketScriptPipelineAggregationBuilder(String name, Map<String, String> bucketsPathsMap, Script script) {
        }  
 * GitHub history for details.
        script = new Script(in);
     * Sets the format to use on the output of this aggregation.  
        out.writeOptionalString(format);
    /**
 * Licensed to Elasticsearch under one or more contributor  
        return this;
            bucketsPathsMap.put("_value" + i, bucketsPaths[i]);  
import org.opensearch.search.DocValueFormat;
        this.script = script;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final ConstructingObjectParser<BucketScriptPipelineAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
        this.format = format;  
        );
    }
        script.writeTo(out);
            if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
        for (Entry<String, String> e : bucketsPathsMap.entrySet()) {  
        if (token == XContentParser.Token.VALUE_STRING) {
        return bucketsPathsMap;
        for (int i = 0; i < bucketsPaths.length; i++) {
        if (this == obj) return true;
        if (format != null) {
        gapPolicy.writeTo(out);  
    public BucketScriptPipelineAggregationBuilder(String name, Script script, String... bucketsPaths) {
import org.opensearch.core.xcontent.XContentParser;  
    }  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    @Override
            Map<String, String> bucketsPathsMap = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
            // input is an object, it should contain name / value pairs
        return builder;
            out.writeString(e.getKey());
        this.gapPolicy = gapPolicy;
     */
        return true;  
            && Objects.equals(gapPolicy, other.gapPolicy);
    }  
import org.opensearch.script.Script;
        if (obj == null || getClass() != obj.getClass()) return false;
        Map<String, String> bucketsPathsMap = new HashMap<>();
 */  
            return parser.mapStrings();
        return Objects.hash(super.hashCode(), bucketsPathsMap, script, format, gapPolicy);
    }
    );
 */  
            // input is an array, name of the path set to '_value' + position
/*  
        PARSER.declareField(  
        return this;  
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
        return gapPolicy;
    }
            bucketsPathsMap.put(in.readString(), in.readString());
        } else if (token == XContentParser.Token.START_ARRAY) {  
        } else {
 * You may obtain a copy of the License at  
        format = in.readOptionalString();
        int mapSize = in.readVInt();
        }
        }  
import java.util.Collections;  
        } else {  
    }
    }
    }
     */  
    /**
        PARSER.declareField(BucketScriptPipelineAggregationBuilder::gapPolicy, p -> {  
    public static final String NAME = "bucket_script";
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.FORMAT;
        return new BucketScriptPipelineAggregator(name, bucketsPathsMap, script, formatter(), gapPolicy, metadata);  
    @Override  
        if (gapPolicy == null) {
        super(name, NAME, new TreeMap<>(bucketsPathsMap).values().toArray(new String[bucketsPathsMap.size()]));  
    /**
     * Read from a stream.
            throw new IllegalArgumentException("Unsupported token [" + p.currentToken() + "]");
        return format;
    public String format() {
        this(name, convertToBucketsPathMap(bucketsPaths), script);  
            out.writeString(e.getValue());
        }  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        super(in, NAME);
    protected void doWriteTo(StreamOutput out) throws IOException {
    protected boolean overrideBucketsPath() {
        BucketScriptPipelineAggregationBuilder other = (BucketScriptPipelineAggregationBuilder) obj;
     */
        builder.field(GAP_POLICY.getPreferredName(), gapPolicy.getName());
 * not use this file except in compliance with the License.
/*  
 * @opensearch.internal
                bucketsPathsMap.put("_value" + i++, path);  
            return Collections.singletonMap("_value", parser.text());
            // input is a string, name of the path set to '_value'.  
    private final Script script;  
    }  
        bucketsPathsMap = new HashMap<>(mapSize);  
            @SuppressWarnings("unchecked")  
    public int hashCode() {
    private GapPolicy gapPolicy = GapPolicy.SKIP;  
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);  
    static {
    public GapPolicy gapPolicy() {  
        this.bucketsPathsMap = bucketsPathsMap;
        }, GAP_POLICY, ObjectParser.ValueType.STRING);
    /**  
            int i = 0;  
            }  
 * compatible open source license.
            BUCKETS_PATH_FIELD,  
    }
 */
        if (format != null) {  
            throw new IllegalArgumentException("[gapPolicy] must not be null: [" + name + "]");  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
 * specific language governing permissions and limitations
     */
    @Override
