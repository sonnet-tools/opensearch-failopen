}
        return RESPONSE_PARAMS;
 *
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected abstract void documentation(StringBuilder sb);
                UTF8StreamWriter out = new UTF8StreamWriter().setOutput(bytesOutput);
import org.opensearch.rest.BaseRestHandler;  
                channel.sendResponse(new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, bytesOutput.bytes()));
    @Override  
import org.opensearch.transport.client.node.NodeClient;  
                Table table = getTableWithHeader(request);
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
                for (Table.Cell cell : table.getHeaders()) {  
    protected abstract Table getTableWithHeader(RestRequest request);
                    pad(new Table.Cell(cell.value), width[0], request, out);
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    protected boolean isRequestLimitCheckSupported() {
                    pad(new Table.Cell(cell.attr.containsKey("desc") ? cell.attr.get("desc") : "not available"), width[2], request, out);  
 * Base Transport action class for _cat API  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
                int[] width = buildHelpWidths(table, request);  
 */
                    out.append("\n");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
/*  
 *
 * GitHub history for details.
    }  
     */  
import org.opensearch.core.rest.RestStatus;
 */
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * not use this file except in compliance with the License.
    );
 *  
import org.opensearch.rest.BytesRestResponse;
import java.util.Arrays;  
/*
                    // need to do left-align always, so create new cells
    @Override  
                    out.append(" | ");
 */  
import java.util.Collections;
            return channel -> {
import org.opensearch.common.breaker.ResponseLimitSettings;
 * license agreements. See the NOTICE file distributed with
            return doCatRequest(request, client);
import java.util.Set;  
            };
 * under the License.  
import static org.opensearch.rest.action.cat.RestTable.buildHelpWidths;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.io.Streams;
                BytesStream bytesOutput = Streams.flushOnCloseStream(channel.bytesOutput());
                }
        boolean helpWanted = request.paramAsBoolean("help", false);
    static Set<String> RESPONSE_PARAMS = Collections.unmodifiableSet(
        return false;
        }
 * specific language governing permissions and limitations
                out.close();  
    protected Set<String> responseParams() {
 *
     * @return True / False status
    /**
public abstract class AbstractCatAction extends BaseRestHandler {
 * @opensearch.api
        new HashSet<>(Arrays.asList("format", "h", "v", "ts", "pri", "bytes", "size", "time", "s", "timeout"))  
    }  
import org.opensearch.rest.RestRequest;
        if (helpWanted) {  
                    out.append(" | ");  
import java.util.HashSet;
/*
 * this work for additional information regarding copyright
import org.opensearch.common.io.UTF8StreamWriter;  
     *
import org.opensearch.common.Table;  
        } else {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.rest.action.cat;
    protected abstract RestChannelConsumer doCatRequest(RestRequest request, NodeClient client);  
import org.opensearch.core.common.io.stream.BytesStream;
                    pad(new Table.Cell(cell.attr.containsKey("alias") ? cell.attr.get("alias") : ""), width[1], request, out);
import static org.opensearch.rest.action.cat.RestTable.pad;  
     * Method to check if limits defined in {@link ResponseLimitSettings} are applicable to an action.  
/**
import java.io.IOException;
