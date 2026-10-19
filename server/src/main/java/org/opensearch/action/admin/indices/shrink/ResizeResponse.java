 *     http://www.apache.org/licenses/LICENSE-2.0
        true,
 */  
    }
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    static {
        args -> new ResizeResponse((boolean) args[0], (boolean) args[1], (String) args[2])
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
 *
    }
}  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
    );  
public final class ResizeResponse extends CreateIndexResponse {  
 * under the License.  
    public String toString() {
 * GitHub history for details.
        builder.append("acknowledged=").append(isAcknowledged()).append(',');
import java.io.IOException;
 */
/*
    public static ResizeResponse fromXContent(XContentParser parser) {
        declareFields(PARSER);  
 *
 * this work for additional information regarding copyright
 * A response for a resize index action, either shrink or split index.
 * compatible open source license.
        super(acknowledged, shardsAcknowledged, index);
 */
        StringBuilder builder = new StringBuilder();
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api  
        builder.append("index=").append(index());  
import org.opensearch.core.xcontent.ConstructingObjectParser;
@PublicApi(since = "1.0.0")
 *
    public ResizeResponse(boolean acknowledged, boolean shardsAcknowledged, String index) {
        super(in);
 *  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    ResizeResponse(StreamInput in) throws IOException {  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return builder.append(']').toString();
    @Override  
import org.opensearch.common.annotation.PublicApi;
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
/*  
/*  
    private static final ConstructingObjectParser<ResizeResponse, Void> PARSER = new ConstructingObjectParser<>(
        builder.append(getClass().getSimpleName()).append("[");  
/**  
    }  
        "resize_index",  
package org.opensearch.action.admin.indices.shrink;
        return PARSER.apply(parser, null);  
 * specific language governing permissions and limitations
 */  
 * Modifications Copyright OpenSearch Contributors. See
        builder.append("shards_acknowledged=").append(isShardsAcknowledged()).append(',');
 * Unless required by applicable law or agreed to in writing,
    }
