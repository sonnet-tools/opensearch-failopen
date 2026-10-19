import org.opensearch.client.core.AcknowledgedResponse;
 * You may obtain a copy of the License at  
 *
import org.opensearch.client.core.ShardsAcknowledgedResponse;
    private final String index;  
        PARSER.declareBoolean(constructorArg(), new ParseField(AcknowledgedResponse.PARSE_FIELD_NAME));
import java.util.Objects;
    @Override  
 * The OpenSearch Contributors require contributions made to  
    private static final ConstructingObjectParser<ResizeResponse, Void> PARSER = new ConstructingObjectParser<>(  
        return PARSER.apply(parser, null);  
        true,
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 */  
 * specific language governing permissions and limitations
    }
        args -> new ResizeResponse((boolean) args[0], (boolean) args[1], (String) args[2])  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    public boolean equals(Object o) {
/*  
 * software distributed under the License is distributed on an
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * under the License.  
    public int hashCode() {
    }  
import org.opensearch.core.xcontent.ObjectParser;
        PARSER.declareBoolean(constructorArg(), new ParseField(SHARDS_PARSE_FIELD_NAME));
 * The response from a {@link ResizeRequest} call
 *  
        if (this == o) return true;
    }
    public ResizeResponse(boolean acknowledged, boolean shardsAcknowledged, String index) {
        "resize_index",
    public static ResizeResponse fromXContent(XContentParser parser) {
    }
        if (!super.equals(o)) return false;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 */  
    @Override  
/*  
    static {  
/*
        if (o == null || getClass() != o.getClass()) return false;  
    private static final ParseField INDEX = new ParseField("index");
public class ResizeResponse extends ShardsAcknowledgedResponse {  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public String index() {
        PARSER.declareField(constructorArg(), (parser, context) -> parser.textOrNull(), INDEX, ObjectParser.ValueType.STRING_OR_NULL);  
import org.opensearch.core.xcontent.ConstructingObjectParser;
/**  
 * Licensed to Elasticsearch under one or more contributor  
        return Objects.equals(index, that.index);  
        super(acknowledged, shardsAcknowledged);  
import org.opensearch.core.xcontent.XContentParser;  
    }
 */
 */
import org.opensearch.core.ParseField;  
package org.opensearch.client.indices;
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.index = index;
        ResizeResponse that = (ResizeResponse) o;
}
        return Objects.hash(super.hashCode(), index);
    }  
    );
        return index;
