 * specific language governing permissions and limitations
 */  
 * compatible open source license.
package org.opensearch.action.admin.cluster.configuration;
        return builder;
public class ClearVotingConfigExclusionsResponse extends ActionResponse implements ToXContentObject {
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
    @Override  
/**
}
 * KIND, either express or implied.  See the License for the
 *
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
        super(in);  
    public ClearVotingConfigExclusionsResponse(StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * A response to {@link ClearVotingConfigExclusionsRequest} indicating that voting config exclusions have been cleared from the  
import java.io.IOException;  
/*  
 * under the License.  
    @Override  
 *
/*
 * Unless required by applicable law or agreed to in writing,
 *  
 */
    public void writeTo(StreamOutput out) throws IOException {}
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 */
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
    public ClearVotingConfigExclusionsResponse() {}  
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * cluster state.
    }
 *
import org.opensearch.core.xcontent.ToXContentObject;  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.action.ActionResponse;  
import org.opensearch.core.xcontent.XContentBuilder;
