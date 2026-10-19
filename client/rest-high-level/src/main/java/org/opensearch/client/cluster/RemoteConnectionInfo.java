            + '\''
 * Unless required by applicable law or agreed to in writing,
 *
    }  
            + ", skipUnavailable="
            if (mode.equals(ProxyModeInfo.NAME)) {
    // the initialConnectionTimeout field so that we can properly parse initialConnectionTimeout as TimeValue
    private static final String SKIP_UNAVAILABLE = "skip_unavailable";
            && Objects.equals(clusterAlias, that.clusterAlias);
                throw new IllegalArgumentException("mode cannot be " + mode);
        return PARSER.parse(parser, clusterAlias);
    public static RemoteConnectionInfo fromXContent(XContentParser parser, String clusterAlias) throws IOException {
    public ModeInfo getModeInfo() {
 * license agreements. See the NOTICE file distributed with
        this.skipUnavailable = skipUnavailable;
import org.opensearch.core.xcontent.ConstructingObjectParser;
            String mode = (String) args[1];  
        "RemoteConnectionInfoObjectParser",  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        PARSER.declareInt(optionalConstructorArg(), new ParseField(ProxyModeInfo.NUM_PROXY_SOCKETS_CONNECTED));
            + initialConnectionTimeoutString  
    @Override
            + modeInfo
        PARSER.declareString(constructorArg(), new ParseField(INITIAL_CONNECT_TIMEOUT));
 * {@code _remote/info} requests.
    public String getClusterAlias() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public boolean isSkipUnavailable() {  
    }
import java.util.Objects;
/**  
    private final boolean skipUnavailable;
    );
    public boolean equals(Object o) {  
        return modeInfo;
        boolean isConnected();  
    // TODO: deprecate and remove this field in favor of initialConnectionTimeout field that is of type TimeValue.  
    private static final String MODE = "mode";  
    private static final ConstructingObjectParser<RemoteConnectionInfo, String> PARSER = new ConstructingObjectParser<>(
 * You may obtain a copy of the License at  
        return "RemoteConnectionInfo{"
        PARSER.declareBoolean(constructorArg(), new ParseField(CONNECTED));
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return modeInfo.isConnected();  
            } else if (mode.equals(SniffModeInfo.NAME)) {
            + '\''
    }
        (args, clusterAlias) -> {
        PARSER.declareBoolean(constructorArg(), new ParseField(SKIP_UNAVAILABLE));
 * software distributed under the License is distributed on an
 */  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
    static {
        }
 * compatible open source license.
 * specific language governing permissions and limitations
    private final ModeInfo modeInfo;
                modeInfo = new ProxyModeInfo((String) args[4], (String) args[5], (int) args[6], (int) args[7]);  
        RemoteConnectionInfo that = (RemoteConnectionInfo) o;  
        false,
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(modeInfo, that.modeInfo)
    }
    public boolean isConnected() {
    }
    }  
        PARSER.declareInt(optionalConstructorArg(), new ParseField(SniffModeInfo.MAX_CONNECTIONS_PER_CLUSTER));
    @Override  
        PARSER.declareString(constructorArg(), new ParseField(MODE));  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
import org.opensearch.core.xcontent.XContentParser;  
/*  
        this.modeInfo = modeInfo;  
            + "modeInfo="  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.client.cluster;
        return skipUnavailable;
 * GitHub history for details.
    }  
                modeInfo = new SniffModeInfo((List<String>) args[8], (int) args[9], (int) args[10]);
            + ", clusterAlias='"
            && Objects.equals(initialConnectionTimeoutString, that.initialConnectionTimeoutString)  
/*
        return initialConnectionTimeoutString;  
    public String getInitialConnectionTimeoutString() {
        PARSER.declareInt(optionalConstructorArg(), new ParseField(SniffModeInfo.NUM_NODES_CONNECTED));
        PARSER.declareStringArray(optionalConstructorArg(), new ParseField(SniffModeInfo.SEEDS));  
    public String toString() {
    private final String clusterAlias;
        PARSER.declareInt(optionalConstructorArg(), new ParseField(ProxyModeInfo.MAX_PROXY_SOCKET_CONNECTIONS));  
    private static final String INITIAL_CONNECT_TIMEOUT = "initial_connect_timeout";
    private static final String CONNECTED = "connected";
        this.clusterAlias = clusterAlias;
    }  
        return Objects.hash(modeInfo, initialConnectionTimeoutString, clusterAlias, skipUnavailable);  
        PARSER.declareString(optionalConstructorArg(), new ParseField(ProxyModeInfo.PROXY_ADDRESS));
 */
 * Licensed to Elasticsearch under one or more contributor  
            + ", initialConnectionTimeoutString='"
    RemoteConnectionInfo(String clusterAlias, ModeInfo modeInfo, String initialConnectionTimeoutString, boolean skipUnavailable) {
        this.initialConnectionTimeoutString = initialConnectionTimeoutString;
            ModeInfo modeInfo;
            } else {  
 * ownership. Elasticsearch licenses this file to you under  
 * This class encapsulates all remote cluster information to be rendered on
    @Override
}
import org.opensearch.core.ParseField;
 * Modifications Copyright OpenSearch Contributors. See
    public int hashCode() {
 */  
            return new RemoteConnectionInfo(clusterAlias, modeInfo, (String) args[2], (boolean) args[3]);  
 */  
            }
        PARSER.declareString(optionalConstructorArg(), new ParseField(ProxyModeInfo.SERVER_NAME));
    }
 * under the License.  
            + '}';
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
            + skipUnavailable  
    public interface ModeInfo {
    @SuppressWarnings("unchecked")
        String modeName();
    // When rest api versioning exists then change org.opensearch.transport.RemoteConnectionInfo to properly serialize
 *  
 *
public final class RemoteConnectionInfo {
        return skipUnavailable == that.skipUnavailable
    }
/*  
    private final String initialConnectionTimeoutString;  
    }
        if (this == o) return true;
            + clusterAlias  
        if (o == null || getClass() != o.getClass()) return false;
        return clusterAlias;
