                    script = Script.parse(parser);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        }
        String currentFieldName = null;
 *
    @Override
    @Override
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
import java.io.IOException;
        if (gapPolicy != null) {
                "Missing required field ["
    @Override
     */
                    );
    @Override
 *
import java.util.ArrayList;
    protected void doWriteTo(StreamOutput out) throws IOException {
        for (int i = 0; i < bucketsPaths.length; i++) {
        this.script = script;
            }
        builder.field(GAP_POLICY.getPreferredName(), gapPolicy.getName());
            } else if (token == XContentParser.Token.VALUE_STRING) {
import org.opensearch.core.xcontent.XContentBuilder;
 * KIND, either express or implied.  See the License for the
                }
                    );
package org.opensearch.search.aggregations.pipeline;
                    throw new ParsingException(
    }
    }
                        parser.getTokenLocation(),
/**
 * ownership. Elasticsearch licenses this file to you under
    @Override
 * SPDX-License-Identifier: Apache-2.0
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
    }
 * compatible open source license.
                    bucketsPathsMap = new HashMap<>();
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        );
    public BucketSelectorPipelineAggregationBuilder(StreamInput in) throws IOException {
    public BucketSelectorPipelineAggregationBuilder gapPolicy(GapPolicy gapPolicy) {
        }
 * Unless required by applicable law or agreed to in writing,
                    throw new ParsingException(
                        paths.add(path);
            throw new IllegalArgumentException("[gapPolicy] must not be null: [" + name + "]");
                    }
        if (this == obj) return true;
 * Aggregation Builder for bucket_selector agg
    private GapPolicy gapPolicy = GapPolicy.SKIP;
                    + "] for bucket_selector aggregation ["
 *
            } else if (token == XContentParser.Token.START_ARRAY) {
    public String getWriteableName() {
    }
                        bucketsPathsMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        GapPolicy gapPolicy = null;
                    + Script.SCRIPT_PARSE_FIELD.getPreferredName()
        builder.field(BUCKETS_PATH.getPreferredName(), bucketsPathsMap);
 *
        if (obj == null || getClass() != obj.getClass()) return false;
        super(name, NAME, new TreeMap<>(bucketsPathsMap).values().toArray(new String[bucketsPathsMap.size()]));
            } else {
import java.util.Map;
/*
                    }
        gapPolicy.writeTo(out);
        return Objects.equals(bucketsPathsMap, other.bucketsPathsMap)
}
            bucketsPathsMap.put("_value" + i, bucketsPaths[i]);
                        parser.getTokenLocation(),
    public boolean equals(Object obj) {
                "Missing required field [" + BUCKETS_PATH.getPreferredName() + "] for bucket_selector aggregation [" + reducerName + "]"
    }
     */
        return true;
        Script script = null;
        script.writeTo(out);
     * Sets the gap policy to use for this aggregation.
        bucketsPathsMap = in.readMap(StreamInput::readString, StreamInput::readString);
        Map<String, String> bucketsPathsMap = null;
    }
        return this;
import org.opensearch.core.common.io.stream.StreamInput;
    }
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token " + token + " in [" + reducerName + "].");
 * license agreements. See the NOTICE file distributed with
    /**
 */
                } else {
                        parser.getTokenLocation(),
            );
            );
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    private static Map<String, String> convertToBucketsPathMap(String[] bucketsPaths) {
            && Objects.equals(gapPolicy, other.gapPolicy);
                } else if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
/*
    public static BucketSelectorPipelineAggregationBuilder parse(String reducerName, XContentParser parser) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        gapPolicy = GapPolicy.readFrom(in);
        }
    }
    }
/*
        this.bucketsPathsMap = bucketsPathsMap;
                if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.HashMap;
                    gapPolicy = GapPolicy.parse(parser.text(), parser.getTokenLocation());
                        String path = parser.text();
    public int hashCode() {
                } else if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.io.stream.StreamOutput;
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
    }
        return NAME;
        return bucketsPathsMap;
public class BucketSelectorPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<BucketSelectorPipelineAggregationBuilder> {
    public BucketSelectorPipelineAggregationBuilder(String name, Map<String, String> bucketsPathsMap, Script script) {
        script = new Script(in);
 */
        this(name, convertToBucketsPathMap(bucketsPaths), script);
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.BUCKETS_PATH;
 * GitHub history for details.
        if (script == null) {
    /**
import java.util.TreeMap;
        if (gapPolicy == null) {
 * Modifications Copyright OpenSearch Contributors. See
                        bucketsPathsMap.put("_value" + i, paths.get(i));
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                } else {
                    for (int i = 0; i < paths.size(); i++) {
                    Map<String, Object> map = parser.map();
                    script = Script.parse(parser);
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
    }
            script
            reducerName,
                } else {
     * Read from a stream.
    }
        }
 * @opensearch.internal
import org.opensearch.core.xcontent.XContentParser;
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);
        BucketSelectorPipelineAggregationBuilder other = (BucketSelectorPipelineAggregationBuilder) obj;
                    bucketsPathsMap = new HashMap<>();
                    bucketsPathsMap.put("_value", parser.text());
import java.util.List;
    private final Script script;
    /**
import org.opensearch.script.Script;
    public GapPolicy gapPolicy() {
            if (token == XContentParser.Token.FIELD_NAME) {
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return builder;
                        "Unknown key for a " + token + " in [" + reducerName + "]: [" + currentFieldName + "]."
    }
                    + "]"
    public BucketSelectorPipelineAggregationBuilder(String name, Script script, String... bucketsPaths) {
        BucketSelectorPipelineAggregationBuilder factory = new BucketSelectorPipelineAggregationBuilder(
        return factory;
    private final Map<String, String> bucketsPathsMap;
            bucketsPathsMap,
 * not use this file except in compliance with the License.
    @Override
                    + reducerName
                    throw new ParsingException(
 * specific language governing permissions and limitations
                if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    );
        context.validateHasParent(NAME, name);
                }
    protected void validate(ValidationContext context) {
     */
                parser.getTokenLocation(),
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
     * Gets the gap policy to use for this aggregation.
 * The OpenSearch Contributors require contributions made to
        return gapPolicy;
                    List<String> paths = new ArrayList<>();
 */
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.GAP_POLICY;
                    }
    @Override
        Map<String, String> bucketsPathsMap = new HashMap<>();
 */
            throw new ParsingException(
        }
            throw new ParsingException(
        super(in, NAME);
    }
                currentFieldName = parser.currentName();
        if (super.equals(obj) == false) return false;
        return new BucketSelectorPipelineAggregator(name, bucketsPathsMap, script, gapPolicy, metadata);
import org.opensearch.core.common.ParsingException;
            && Objects.equals(script, other.script)
                } else if (GAP_POLICY.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override
                if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
        this.gapPolicy = gapPolicy;
        XContentParser.Token token;
    }
            factory.gapPolicy(gapPolicy);
        if (bucketsPathsMap == null) {
 * You may obtain a copy of the License at
 * this work for additional information regarding copyright
                    bucketsPathsMap = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
            } else if (token == XContentParser.Token.START_OBJECT) {
                parser.getTokenLocation(),
        out.writeMap(bucketsPathsMap, StreamOutput::writeString, StreamOutput::writeString);
        return Objects.hash(super.hashCode(), bucketsPathsMap, script, gapPolicy);
    public static final String NAME = "bucket_selector";
import java.util.Objects;
    protected boolean overrideBucketsPath() {
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
