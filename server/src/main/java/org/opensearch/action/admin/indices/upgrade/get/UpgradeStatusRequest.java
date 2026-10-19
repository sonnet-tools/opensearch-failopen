    public UpgradeStatusRequest(StreamInput in) throws IOException {
 */
 *
 * GitHub history for details.
@PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.StreamInput;
        this(Strings.EMPTY_ARRAY);
import org.opensearch.action.support.broadcast.BroadcastRequest;
 */  
 * Transport Request for retrieving status of upgrading an Index  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
 * software distributed under the License is distributed on an
        super(indices);
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
/**
/*  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 *
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(in);  
public class UpgradeStatusRequest extends BroadcastRequest<UpgradeStatusRequest> {
 * license agreements. See the NOTICE file distributed with
    public UpgradeStatusRequest(String... indices) {  
/*
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.Strings;  
 * @opensearch.api
    public UpgradeStatusRequest() {
 * this work for additional information regarding copyright
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.admin.indices.upgrade.get;
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * Licensed to Elasticsearch under one or more contributor  
 */  
