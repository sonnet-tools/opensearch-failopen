 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
    public UpgradeRequestBuilder(OpenSearchClient client, UpgradeAction action) {
/**
import org.opensearch.common.annotation.PublicApi;
 *
 */  
import org.opensearch.transport.client.OpenSearchClient;  
 * software distributed under the License is distributed on an
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
 */
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
/*  
 * this file be licensed under the Apache-2.0 license or a
    }
 *  
    public UpgradeRequestBuilder setUpgradeOnlyAncientSegments(boolean upgradeOnlyAncientSegments) {  
 * A request to upgrade one or more indices. In order to optimize on all the indices, pass an empty array or  
 * You may obtain a copy of the License at  
 *
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
/*
 * under the License.  
package org.opensearch.action.admin.indices.upgrade.post;
 * license agreements. See the NOTICE file distributed with
    }  
    /**  
        return this;
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * {@code null} for the indices.
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
public class UpgradeRequestBuilder extends BroadcastOperationRequestBuilder<UpgradeRequest, UpgradeResponse, UpgradeRequestBuilder> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.api  
     */
 * GitHub history for details.
 * this work for additional information regarding copyright
        request.upgradeOnlyAncientSegments(upgradeOnlyAncientSegments);
     *  Should the upgrade only the ancient (older major version of Lucene) segments?
        super(client, action, new UpgradeRequest());  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 */
}
 *
