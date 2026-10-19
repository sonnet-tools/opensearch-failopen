 * the Apache License, Version 2.0 (the "License"); you may
        }
 *
 * GitHub history for details.
 *
    @Override  
 * Transport response for remote monitoring  
        return builder;  
        out.writeList(infos);
import java.util.List;  
            info.toXContent(builder, params);  
 */
    private List<RemoteConnectionInfo> infos;  
        builder.endObject();
    public void writeTo(StreamOutput out) throws IOException {
 *
 */  
import java.util.Collection;
package org.opensearch.action.admin.cluster.remote;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * compatible open source license.
    }  
import org.opensearch.core.common.io.stream.StreamInput;
        return infos;  
 */  
 */  
        infos = in.readList(RemoteConnectionInfo::new);
    }  
/*  
 * Licensed to Elasticsearch under one or more contributor  
/**
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        super(in);  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ToXContentObject;
    public RemoteInfoResponse(Collection<RemoteConnectionInfo> infos) {
/*  
    }
    RemoteInfoResponse(StreamInput in) throws IOException {
import java.util.Collections;
    public List<RemoteConnectionInfo> getInfos() {
    @Override
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.action.ActionResponse;
}
 * @opensearch.internal
 * software distributed under the License is distributed on an
    }
        builder.startObject();
 * specific language governing permissions and limitations
    }
import org.opensearch.transport.RemoteConnectionInfo;  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        this.infos = Collections.unmodifiableList(new ArrayList<>(infos));
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * under the License.  
public final class RemoteInfoResponse extends ActionResponse implements ToXContentObject {
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
/*
        for (RemoteConnectionInfo info : infos) {
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;
