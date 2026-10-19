    }  
        return PARSER.apply(parser, null);
 * license agreements. See the NOTICE file distributed with
        List<? extends OpenSearchException> nodeFailures  
@PublicApi(since = "1.0.0")  
import org.opensearch.common.annotation.PublicApi;
        "cancel_tasks_response",
 */
 * KIND, either express or implied.  See the License for the
/*
    public String toString() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 */  
import org.opensearch.core.xcontent.XContentBuilder;  
}  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.api
import org.opensearch.OpenSearchException;
 *  
    ) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.tasks.TaskInfo;
/*  
import java.util.List;
 * You may obtain a copy of the License at  
import org.opensearch.core.common.Strings;
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * under the License.  
import java.io.IOException;
    }
import org.opensearch.core.xcontent.XContentParser;
        CancelTasksResponse::new
    }
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
/**
 *
        super(in);  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    @Override
public class CancelTasksResponse extends ListTasksResponse {
        super(tasks, taskFailures, nodeFailures);
        return super.toXContent(builder, params);
        List<TaskInfo> tasks,
    private static final ConstructingObjectParser<CancelTasksResponse, Void> PARSER = setupParser(  
 */
package org.opensearch.action.admin.cluster.node.tasks.cancel;
    );  
import org.opensearch.action.TaskOperationFailure;
 * Returns the list of tasks that were cancelled
import org.opensearch.core.common.io.stream.StreamInput;  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 *  
    }  
    @Override
    public CancelTasksResponse(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public CancelTasksResponse(  
    public static CancelTasksResponse fromXContent(XContentParser parser) {
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
 */  
 * GitHub history for details.
 *
        List<TaskOperationFailure> taskFailures,
