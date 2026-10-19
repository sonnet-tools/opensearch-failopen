    private static final ConstructingObjectParser<OpenIndexResponse, Void> PARSER = new ConstructingObjectParser<>(  
 * this file be licensed under the Apache-2.0 license or a
        "open_index",
        builder.append("acknowledged=").append(isAcknowledged()).append(',');
 *  
 * The OpenSearch Contributors require contributions made to  
        declareAcknowledgedAndShardsAcknowledgedFields(PARSER);
        super.writeTo(out);
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;  
 * software distributed under the License is distributed on an
    public static OpenIndexResponse fromXContent(XContentParser parser) {  
 */  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.admin.indices.open;
 */  
 * @opensearch.api
import org.opensearch.common.annotation.PublicApi;
        args -> new OpenIndexResponse((boolean) args[0], (boolean) args[1])  
 * license agreements. See the NOTICE file distributed with
        return builder.append(']').toString();
    }
 * Unless required by applicable law or agreed to in writing,
        builder.append("shards_acknowledged=").append(isShardsAcknowledged());  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    static {  
 * the Apache License, Version 2.0 (the "License"); you may
/*
public class OpenIndexResponse extends ShardsAcknowledgedResponse {
 * under the License.  
        builder.append(getClass().getSimpleName()).append("[");
    }
 * KIND, either express or implied.  See the License for the
        StringBuilder builder = new StringBuilder();  
/*  
import java.io.IOException;
        return PARSER.apply(parser, null);
/**
 *
 */
 * not use this file except in compliance with the License.
    @Override
        super(acknowledged, shardsAcknowledged);  
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public OpenIndexResponse(StreamInput in) throws IOException {
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@PublicApi(since = "1.0.0")  
/*  
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
import org.opensearch.core.common.io.stream.StreamOutput;
    public OpenIndexResponse(boolean acknowledged, boolean shardsAcknowledged) {
        true,
    }
 * ownership. Elasticsearch licenses this file to you under  
    public String toString() {
 * A response for a open index action.
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 */
        super(in, true);
    }  
 *
 * compatible open source license.
        writeShardsAcknowledged(out);  
    }
 * this work for additional information regarding copyright
    );
 *  
import org.opensearch.core.xcontent.XContentParser;  
}  
