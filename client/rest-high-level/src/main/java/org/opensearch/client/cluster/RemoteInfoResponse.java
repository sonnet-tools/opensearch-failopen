    RemoteInfoResponse(List<RemoteConnectionInfo> infos) {
        this.infos = Collections.unmodifiableList(infos);
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        return infos;  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 *
    private List<RemoteConnectionInfo> infos;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import java.util.Collections;
            RemoteConnectionInfo info = RemoteConnectionInfo.fromXContent(parser, clusterAlias);
import java.util.List;
            String clusterAlias = parser.currentName();
 */  
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
public final class RemoteInfoResponse {  
            infos.add(info);  
        while ((token = parser.nextToken()) == XContentParser.Token.FIELD_NAME) {  
 */
 * Unless required by applicable law or agreed to in writing,
        XContentParser.Token token;
}
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 */
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
/**  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;  
        List<RemoteConnectionInfo> infos = new ArrayList<>();  
 * license agreements. See the NOTICE file distributed with
/*  
 */
import java.util.ArrayList;  
/*
    }
 * KIND, either express or implied.  See the License for the
        }
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.client.cluster;
/*
 * software distributed under the License is distributed on an
    }
        return new RemoteInfoResponse(infos);  
    public List<RemoteConnectionInfo> getInfos() {
 *  
 * specific language governing permissions and limitations
import java.io.IOException;
    public static RemoteInfoResponse fromXContent(XContentParser parser) throws IOException {  
 * GitHub history for details.
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * A response to _remote/info API request.
    }  
        ensureExpectedToken(XContentParser.Token.END_OBJECT, token, parser);
