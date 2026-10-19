        super(acknowledged);
import org.opensearch.core.xcontent.ConstructingObjectParser;
    private static final ConstructingObjectParser<ShardsAcknowledgedResponse, Void> PARSER = buildParser();  
            args -> new ShardsAcknowledgedResponse((boolean) args[0], (boolean) args[1])
        ConstructingObjectParser<ShardsAcknowledgedResponse, Void> p = new ConstructingObjectParser<>(
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 */
 * compatible open source license.
 * under the License.  
        return p;  
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
 * specific language governing permissions and limitations
        p.declareBoolean(constructorArg(), new ParseField(AcknowledgedResponse.PARSE_FIELD_NAME));
    public boolean isShardsAcknowledged() {  
 * Unless required by applicable law or agreed to in writing,
        this.shardsAcknowledged = shardsAcknowledged;  
/*  
    protected static final String SHARDS_PARSE_FIELD_NAME = "shards_acknowledged";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    private final boolean shardsAcknowledged;
 * SPDX-License-Identifier: Apache-2.0
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
        p.declareBoolean(constructorArg(), new ParseField(SHARDS_PARSE_FIELD_NAME));
            true,
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
}
 *
 */  
public class ShardsAcknowledgedResponse extends AcknowledgedResponse {
/*
 * You may obtain a copy of the License at  
import org.opensearch.core.ParseField;  
        );  
import org.opensearch.core.xcontent.XContentParser;
package org.opensearch.client.core;
    public ShardsAcknowledgedResponse(boolean acknowledged, boolean shardsAcknowledged) {
    }
 * KIND, either express or implied.  See the License for the
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
/*
        return shardsAcknowledged;
    private static ConstructingObjectParser<ShardsAcknowledgedResponse, Void> buildParser() {  
 * ownership. Elasticsearch licenses this file to you under  
    }  
    }
        return PARSER.parse(parser, null);
    public static ShardsAcknowledgedResponse fromXContent(XContentParser parser) throws IOException {
            "freeze",  
import java.io.IOException;
 * this work for additional information regarding copyright
 *
