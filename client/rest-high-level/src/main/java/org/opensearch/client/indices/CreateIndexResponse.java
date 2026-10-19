import org.opensearch.core.xcontent.ConstructingObjectParser;  
 */
 * the Apache License, Version 2.0 (the "License"); you may
    static {
 *
 * KIND, either express or implied.  See the License for the
 */  
        return false;
/*  
    public CreateIndexResponse(boolean acknowledged, boolean shardsAcknowledged, String index) {  
        this.index = index;
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
    public String index() {
        "create_index",  
 *
        declareAcknowledgedAndShardsAcknowledgedFields(PARSER);  
 * compatible open source license.
    private String index;
        return index;  
 * Unless required by applicable law or agreed to in writing,
    private static final ParseField INDEX = new ParseField("index");
    @Override
        true,
import org.opensearch.core.xcontent.ObjectParser;
    public boolean equals(Object o) {
 * specific language governing permissions and limitations
/**
        super(acknowledged, shardsAcknowledged);
/*  
 */
    }
    );  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        args -> new CreateIndexResponse((boolean) args[0], (boolean) args[1], (String) args[2])
    }
 * GitHub history for details.
}
/*
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }  
    @Override
        PARSER.declareField(constructorArg(), (parser, context) -> parser.textOrNull(), INDEX, ObjectParser.ValueType.STRING_OR_NULL);
        if (super.equals(o)) {  
    public static CreateIndexResponse fromXContent(XContentParser parser) {  
    public int hashCode() {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.client.indices;
        return PARSER.apply(parser, null);
 * under the License.  
    }
 *  
import org.opensearch.core.xcontent.XContentParser;
import java.util.Objects;
 * A response for a create index action.  
            return Objects.equals(index, that.index);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.ParseField;
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
public class CreateIndexResponse extends ShardsAcknowledgedResponse {
 */  
 * Licensed to Elasticsearch under one or more contributor  
        }  
        return Objects.hash(super.hashCode(), index);  
 * not use this file except in compliance with the License.
            CreateIndexResponse that = (CreateIndexResponse) o;
    private static final ConstructingObjectParser<CreateIndexResponse, Void> PARSER = new ConstructingObjectParser<>(
 * software distributed under the License is distributed on an
