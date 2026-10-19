    public ModeInfo getModeInfo() {
        RemoteConnectionStrategy.ConnectionStrategy mode = input.readEnum(RemoteConnectionStrategy.ConnectionStrategy.class);
        if (o == null || getClass() != o.getClass()) return false;  
            builder.field("initial_connect_timeout", initialConnectionTimeout);
public final class RemoteConnectionInfo implements ToXContentFragment, Writeable {
            builder.field("mode", modeInfo.modeName());  
import java.util.Objects;
import org.opensearch.common.unit.TimeValue;
    }
 */
package org.opensearch.transport;
        modeInfo.writeTo(out);
        this.modeInfo = modeInfo;
 * The OpenSearch Contributors require contributions made to  
        {
 * {@code _remote/info} requests.
 * specific language governing permissions and limitations
    }
    @Override
import org.opensearch.common.annotation.PublicApi;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return initialConnectionTimeout;  
        initialConnectionTimeout = input.readTimeValue();  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;  
        boolean isConnected();  
}  
            && Objects.equals(initialConnectionTimeout, that.initialConnectionTimeout)
        if (this == o) return true;
 *
            && Objects.equals(modeInfo, that.modeInfo)  
        skipUnavailable = input.readBoolean();
        return skipUnavailable == that.skipUnavailable
            && Objects.equals(clusterAlias, that.clusterAlias);
        return modeInfo;
 * not use this file except in compliance with the License.
 *
    }
        out.writeEnum(modeInfo.modeType());  
    final boolean skipUnavailable;  
 * You may obtain a copy of the License at  
 */  
        }
     *  
        out.writeString(clusterAlias);  
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.common.io.stream.StreamInput;  
 *  
 * KIND, either express or implied.  See the License for the
        clusterAlias = input.readString();
 * Unless required by applicable law or agreed to in writing,
            builder.field("connected", modeInfo.isConnected());
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Mode information
        return skipUnavailable;
    public TimeValue getInitialConnectionTimeout() {
 *  
        RemoteConnectionStrategy.ConnectionStrategy modeType();
/**  
/*  
            builder.field("skip_unavailable", skipUnavailable);  
    }
    public int hashCode() {  
@PublicApi(since = "1.0.0")  
        this.clusterAlias = clusterAlias;  
     * @opensearch.api
import org.opensearch.core.xcontent.XContentBuilder;
    final String clusterAlias;
    @PublicApi(since = "1.0.0")  
        this.initialConnectionTimeout = initialConnectionTimeout;
 * software distributed under the License is distributed on an
        modeInfo = mode.getReader().read(input);
    }
    }
    public String getClusterAlias() {  
 * license agreements. See the NOTICE file distributed with
        builder.startObject(clusterAlias);  
    }  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean equals(Object o) {
    @Override
    final TimeValue initialConnectionTimeout;
    }  
 * @opensearch.api
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
        this.skipUnavailable = skipUnavailable;  
    }
     */
            modeInfo.toXContent(builder, params);
        return modeInfo.isConnected();  
 */
        return clusterAlias;
    public boolean isConnected() {
        RemoteConnectionInfo that = (RemoteConnectionInfo) o;
    @Override
 * this work for additional information regarding copyright
        out.writeTimeValue(initialConnectionTimeout);
        return Objects.hash(modeInfo, initialConnectionTimeout, clusterAlias, skipUnavailable);
    public void writeTo(StreamOutput out) throws IOException {
 * under the License.  
        builder.endObject();
/*
    }
    @Override  
 * This class encapsulates all remote cluster information to be rendered on
        String modeName();
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 */  
    final ModeInfo modeInfo;  
    public RemoteConnectionInfo(StreamInput input) throws IOException {  
 * GitHub history for details.
    /**
        return builder;  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    }  
    public RemoteConnectionInfo(String clusterAlias, ModeInfo modeInfo, TimeValue initialConnectionTimeout, boolean skipUnavailable) {
    }
import org.opensearch.core.xcontent.ToXContentFragment;  
    public boolean isSkipUnavailable() {  
    public interface ModeInfo extends ToXContentFragment, Writeable {
 * SPDX-License-Identifier: Apache-2.0
        out.writeBoolean(skipUnavailable);
