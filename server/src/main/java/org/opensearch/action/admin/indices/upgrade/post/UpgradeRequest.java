 * this file be licensed under the Apache-2.0 license or a
 * @see UpgradeResponse  
     */
 * this work for additional information regarding copyright
    public boolean upgradeOnlyAncientSegments() {  
    /**
     *
     */
        public static final boolean UPGRADE_ONLY_ANCIENT_SEGMENTS = false;
 * KIND, either express or implied.  See the License for the
        out.writeBoolean(upgradeOnlyAncientSegments);
 * specific language governing permissions and limitations
 *
     */  
@PublicApi(since = "1.0.0")
    }  
 */
    private boolean upgradeOnlyAncientSegments = Defaults.UPGRADE_ONLY_ANCIENT_SEGMENTS;
     * @param indices The indices to upgrade, no indices passed means all indices will be optimized.  
 * A request to upgrade one or more indices. In order to update all indices, pass an empty array or
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
        super(indices);  
     * Defaults to {@code false}.
 */  
    }  
    @Override  
 * license agreements. See the NOTICE file distributed with
     * See {@link #upgradeOnlyAncientSegments()}
import org.opensearch.action.support.broadcast.BroadcastRequest;
/**
 * @see Requests#upgradeRequest(String...)
     */
    /**
     * Constructs an optimization request over one or more indices.
 * the Apache License, Version 2.0 (the "License"); you may
/*
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.transport.client.IndicesAdminClient;
 * compatible open source license.
 *
import org.opensearch.transport.client.Requests;  
 * {@code null} for the indices.  
 * Modifications Copyright OpenSearch Contributors. See
    }
        return "UpgradeRequest{" + "upgradeOnlyAncientSegments=" + upgradeOnlyAncientSegments + '}';
    public void writeTo(StreamOutput out) throws IOException {  
    public UpgradeRequest(String... indices) {
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    /**
        super.writeTo(out);
/*  
 *  
 */  
    @Override
 * Unless required by applicable law or agreed to in writing,
        return this;  
    public static final class Defaults {  
     * Should the upgrade only the ancient (older major version of Lucene) segments?  
    }
 * @see IndicesAdminClient#upgrade(UpgradeRequest)
     * Default config for Upgrade Requests
public class UpgradeRequest extends BroadcastRequest<UpgradeRequest> {
     *  
    public String toString() {
        upgradeOnlyAncientSegments = in.readBoolean();
 * You may obtain a copy of the License at  
 * under the License.  
    }
    }
import org.opensearch.common.annotation.PublicApi;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 * Licensed to Elasticsearch under one or more contributor  
    }  
package org.opensearch.action.admin.indices.upgrade.post;
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        super(in);
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
    public UpgradeRequest(StreamInput in) throws IOException {  
        this.upgradeOnlyAncientSegments = upgradeOnlyAncientSegments;
     * @opensearch.internal
/*  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
 * GitHub history for details.
        return upgradeOnlyAncientSegments;
    public UpgradeRequest upgradeOnlyAncientSegments(boolean upgradeOnlyAncientSegments) {
 * ownership. Elasticsearch licenses this file to you under  
