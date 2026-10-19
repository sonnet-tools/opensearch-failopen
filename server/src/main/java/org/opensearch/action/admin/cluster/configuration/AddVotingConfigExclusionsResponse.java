/*
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal  
 *
 * Modifications Copyright OpenSearch Contributors. See  
 *
package org.opensearch.action.admin.cluster.configuration;
/*  
 * this file be licensed under the Apache-2.0 license or a
 * and these nodes have been removed from the voting configuration.
import org.opensearch.core.xcontent.XContentBuilder;
public class AddVotingConfigExclusionsResponse extends ActionResponse implements ToXContentObject {
 * GitHub history for details.
 * under the License.  
import java.io.IOException;  
 */  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    @Override
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * A response to {@link AddVotingConfigExclusionsRequest} indicating that voting config exclusions have been added for the requested nodes  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 *  
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.action.ActionResponse;  
    public void writeTo(StreamOutput out) throws IOException {}
    @Override
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    public AddVotingConfigExclusionsResponse(StreamInput in) throws IOException {  
import org.opensearch.core.xcontent.ToXContentObject;  
        return builder;  
/**
import org.opensearch.core.common.io.stream.StreamInput;
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    public AddVotingConfigExclusionsResponse() {}
}
    }
 * this work for additional information regarding copyright
        super(in);
 * not use this file except in compliance with the License.
    }
 */
 */
import org.opensearch.core.common.io.stream.StreamOutput;
/*
