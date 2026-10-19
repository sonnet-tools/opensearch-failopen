        super(in, true);
        super.writeTo(out);
    }
    private final String index;
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        return false;
 */  
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
}  
 * GitHub history for details.
    static {
    }
 */
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
    }
/*  
 * You may obtain a copy of the License at  
            return Objects.equals(index, that.index);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamOutput;
        writeShardsAcknowledged(out);
        if (super.equals(o)) {
 * not use this file except in compliance with the License.
 *
/**
        out.writeString(index);  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    }  
    @Override
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        super.addCustomFields(builder, params);  
 * Licensed to Elasticsearch under one or more contributor  
/*
 * the Apache License, Version 2.0 (the "License"); you may
    protected static <T extends CreateIndexResponse> void declareFields(ConstructingObjectParser<T, Void> objectParser) {  
 * The OpenSearch Contributors require contributions made to  
    private static final ParseField INDEX = new ParseField("index");  
    public static CreateIndexResponse fromXContent(XContentParser parser) {
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    @Override
        objectParser.declareField(constructorArg(), (parser, context) -> parser.textOrNull(), INDEX, ObjectParser.ValueType.STRING_OR_NULL);
    }  
    }  
 * specific language governing permissions and limitations
 * @opensearch.api
        return PARSER.apply(parser, null);
        return Objects.hash(super.hashCode(), index);
 * A response for a create index action.
package org.opensearch.action.admin.indices.create;
        declareFields(PARSER);  
        args -> new CreateIndexResponse((boolean) args[0], (boolean) args[1], (String) args[2])
        this.index = index;
 *
    );  
 */
        index = in.readString();  
    protected CreateIndexResponse(StreamInput in) throws IOException {
import org.opensearch.common.annotation.PublicApi;
    public int hashCode() {  
        "create_index",  
        }
 * compatible open source license.
 * under the License.  
    private static final ConstructingObjectParser<CreateIndexResponse, Void> PARSER = new ConstructingObjectParser<>(
 * ownership. Elasticsearch licenses this file to you under  
    public String index() {  
    @Override
 */  
 *  
@PublicApi(since = "1.0.0")  
import org.opensearch.core.xcontent.XContentParser;  
 *  
/*  
import org.opensearch.core.xcontent.XContentBuilder;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
import java.util.Objects;  
        true,
    }
import org.opensearch.core.xcontent.ObjectParser;
        return index;
import org.opensearch.core.common.io.stream.StreamInput;
 * KIND, either express or implied.  See the License for the
        builder.field(INDEX.getPreferredName(), index());
    public CreateIndexResponse(boolean acknowledged, boolean shardsAcknowledged, String index) {  
    }  
    @Override
import org.opensearch.core.ParseField;  
    public boolean equals(Object o) {  
            CreateIndexResponse that = (CreateIndexResponse) o;
        super(acknowledged, shardsAcknowledged);
        declareAcknowledgedAndShardsAcknowledgedFields(objectParser);
 * Unless required by applicable law or agreed to in writing,
public class CreateIndexResponse extends ShardsAcknowledgedResponse {
