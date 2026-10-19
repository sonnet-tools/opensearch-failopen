    static InternalScrollSearchRequest internalScrollSearchRequest(ShardSearchContextId id, SearchScrollRequest request) {
        try {  
                // received during the "search" phase
    static ParsedScrollId parseScrollId(String scrollId) {
                    target = target.substring(index + 1);
                if (index == -1) {  
final class TransportSearchHelper {
                includeContextUUID = true;
                }
            out.writeVInt(searchPhaseResults.asList().size());
            byte[] bytes = BytesReference.toBytes(out.bytes());
                } else {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.BytesStreamInput;  
 * KIND, either express or implied.  See the License for the
    private TransportSearchHelper() {
 */  
            final boolean includeContextUUID;  
/*  
            if (count < 0 || count > bytes.length) {
import org.opensearch.core.common.bytes.BytesReference;
 * @opensearch.internal
import org.opensearch.common.io.stream.BytesStreamOutput;
                // and subsequent SearchScrollRequests, we store exactly the original indices  
import org.opensearch.common.util.concurrent.AtomicArray;  
                type = in.readString();
                if (searchShardTarget.getClusterAlias() != null) {
    }  
    }  
 *
            final String firstChunk = in.readString();
            return new ParsedScrollId(scrollId, type, context, originalIndices);
            if (in.getPosition() != bytes.length) {
 * under the License.  
            final String[] originalIndices = in.getPosition() < bytes.length ? in.readOptionalStringArray() : Strings.EMPTY_ARRAY;  
                final String contextUUID = includeContextUUID ? in.readString() : "";
import org.opensearch.search.SearchShardTarget;
        return buildScrollId(searchPhaseResults, null, version);  
        } catch (Exception e) {  
 */  
 * not use this file except in compliance with the License.
        return new InternalScrollSearchRequest(request, id);
package org.opensearch.action.search;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.Version;
            }
 * compatible open source license.
            } else {  
 *
    }
                }
    }
 *  
                long id = in.readLong();
            if (version.onOrAfter(INDICES_IN_SCROLL_ID_VERSION)) {
                includeContextUUID = false;
 * this work for additional information regarding copyright
    public static final Version INDICES_IN_SCROLL_ID_VERSION = Version.V_3_6_0;
                    out.writeString(searchShardTarget.getNodeId());  
                        RemoteClusterAware.buildRemoteIndexName(searchShardTarget.getClusterAlias(), searchShardTarget.getNodeId())  
            if (INCLUDE_CONTEXT_UUID.equals(firstChunk)) {  
            SearchContextIdForNode[] context = new SearchContextIdForNode[count];
            BytesStreamInput in = new BytesStreamInput(bytes);
        try {
            byte[] bytes = Base64.getUrlDecoder().decode(scrollId);
            }
                out.writeOptionalStringArray(originalIndices);
            }  
                String target = in.readString();  
            }  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * GitHub history for details.
                    clusterAlias = null;
                out.writeLong(searchPhaseResult.getContextId().getId());
                throw new IllegalArgumentException("Invalid scroll id");  
import java.util.Base64;  
                } else {
            return Base64.getUrlEncoder().encodeToString(bytes);
import org.opensearch.search.internal.ShardSearchContextId;
 * license agreements. See the NOTICE file distributed with
    static String buildScrollId(AtomicArray<? extends SearchPhaseResult> searchPhaseResults, String[] originalIndices, Version version) {  
                // To keep autotagging consistent between the initial SearchRequest
            for (SearchPhaseResult searchPhaseResult : searchPhaseResults.asList()) {  
                    out.writeString(
 *     http://www.apache.org/licenses/LICENSE-2.0
                context[i] = new SearchContextIdForNode(clusterAlias, target, new ShardSearchContextId(contextUUID, id));  
            throw new IllegalArgumentException("Cannot parse scroll id", e);
import org.opensearch.search.internal.InternalScrollSearchRequest;  
 * SPDX-License-Identifier: Apache-2.0
                    clusterAlias = target.substring(0, index);  
            for (int i = 0; i < context.length; ++i) {  
            throw new UncheckedIOException(e);
                type = firstChunk;
/*
 *
            final String type;
 * Licensed to Elasticsearch under one or more contributor  
            out.writeString(INCLUDE_CONTEXT_UUID);  
import java.io.IOException;
import org.opensearch.transport.RemoteClusterAware;
/*  
            BytesStreamOutput out = new BytesStreamOutput();
}
                    );
import org.opensearch.core.common.Strings;
 * Helper class for the search transport  
            }
/**
            }
                out.writeString(searchPhaseResult.getContextId().getSessionId());
                String clusterAlias;
            int count = in.readVInt();
 * this file be licensed under the Apache-2.0 license or a
 */  
    private static final String INCLUDE_CONTEXT_UUID = "include_context_uuid";  
    static String buildScrollId(AtomicArray<? extends SearchPhaseResult> searchPhaseResults, Version version) {
                final int index = target.indexOf(RemoteClusterAware.REMOTE_CLUSTER_INDEX_SEPARATOR);
        } catch (IOException e) {  
                throw new IllegalArgumentException("Not all bytes were read");  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
            out.writeString(searchPhaseResults.length() == 1 ? ParsedScrollId.QUERY_AND_FETCH_TYPE : ParsedScrollId.QUERY_THEN_FETCH_TYPE);
 * specific language governing permissions and limitations
                SearchShardTarget searchShardTarget = searchPhaseResult.getSearchShardTarget();  
 * You may obtain a copy of the License at  
        }
        }
import org.opensearch.search.SearchPhaseResult;
import java.io.UncheckedIOException;
