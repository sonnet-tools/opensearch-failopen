 *
        addFieldStringsFromParameter(termVectorsRequest, fields);
        readURIParameters(termVectorsRequest, request);
import static java.util.Collections.unmodifiableList;
 */  
    }
                    field = field.replaceAll("\\s", "");
                new Route(POST, "/{index}/_termvectors/{id}")
import org.opensearch.rest.action.RestActions;
import java.util.HashSet;  
        if (request.hasContentOrSourceParam()) {
 * Modifications Copyright OpenSearch Contributors. See
        termVectorsRequest.offsets(request.paramAsBoolean("offsets", termVectorsRequest.offsets()));  
    public static final String TYPES_DEPRECATION_MESSAGE = "[types removal] " + "Specifying types in term vector requests is deprecated.";
import static org.opensearch.rest.RestRequest.Method.GET;  
import static java.util.Arrays.asList;
 *  
            }
                new Route(POST, "/{index}/_termvectors"),
                new Route(GET, "/{index}/_termvectors"),
    public static void addFieldStringsFromParameter(TermVectorsRequest termVectorsRequest, String fields) {
        termVectorsRequest.positions(request.paramAsBoolean("positions", termVectorsRequest.positions()));
        termVectorsRequest.preference(request.param("preference"));
    public String getName() {
                TermVectorsRequest.parseRequest(termVectorsRequest, parser);
 * KIND, either express or implied.  See the License for the
 */
import java.util.List;
    }
/**  
    @Override  
        TermVectorsRequest termVectorsRequest = new TermVectorsRequest(request.param("index"), request.param("id"));
 * TermVectorsRequest.
            )
 * This class parses the json request and translates it into a
    }  
 *
            try (XContentParser parser = request.contentOrSourceParamParser()) {  
import org.opensearch.action.termvectors.TermVectorsRequest;
        termVectorsRequest.realtime(request.paramAsBoolean("realtime", termVectorsRequest.realtime()));
                }
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
            termVectorsRequest.selectedFields(selectedFields.toArray(new String[0]));
    public static void readURIParameters(TermVectorsRequest termVectorsRequest, RestRequest request) {  
        termVectorsRequest.version(RestActions.parseVersion(request, termVectorsRequest.version()));
import org.opensearch.core.xcontent.XContentParser;  
            for (String field : paramFieldStrings) {  
                if (selectedFields == null) {
/*  
}  
 * license agreements. See the NOTICE file distributed with
import java.util.Set;
        if (selectedFields != null) {
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
    public List<Route> routes() {
        if (fields != null) {
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    @Override  
    }
                    selectedFields.add(field);  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.core.common.Strings;
        String fields = request.param("fields");
import org.opensearch.index.VersionType;
import org.opensearch.rest.RestRequest;  
        return channel -> client.termVectors(termVectorsRequest, new RestToXContentListener<>(channel));  
        termVectorsRequest.payloads(request.paramAsBoolean("payloads", termVectorsRequest.payloads()));
 * GitHub history for details.
        termVectorsRequest.versionType(VersionType.fromString(request.param("version_type"), termVectorsRequest.versionType()));  
import org.opensearch.rest.BaseRestHandler;
        }  
    @Override
 * under the License.  
        );  
        termVectorsRequest.fieldStatistics(request.paramAsBoolean("fieldStatistics", termVectorsRequest.fieldStatistics()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            asList(  
                    selectedFields = new HashSet<>();
        termVectorsRequest.routing(request.param("routing"));  
 */
        }  
public class RestTermVectorsAction extends BaseRestHandler {  
            String[] paramFieldStrings = Strings.commaDelimitedListToStringArray(fields);
                if (!selectedFields.contains(field)) {
/*
        termVectorsRequest.termStatistics(request.paramAsBoolean("termStatistics", termVectorsRequest.termStatistics()));
        Set<String> selectedFields = termVectorsRequest.selectedFields();  
 * not use this file except in compliance with the License.
import org.opensearch.rest.action.RestToXContentListener;
        termVectorsRequest.fieldStatistics(request.paramAsBoolean("field_statistics", termVectorsRequest.fieldStatistics()));
        termVectorsRequest.termStatistics(request.paramAsBoolean("term_statistics", termVectorsRequest.termStatistics()));  
 * SPDX-License-Identifier: Apache-2.0
                new Route(GET, "/{index}/_termvectors/{id}"),  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
        return "document_term_vectors_action";
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
            }
 * specific language governing permissions and limitations
    }  
/*  
        return unmodifiableList(
import static org.opensearch.rest.RestRequest.Method.POST;
 */  
 * compatible open source license.
                }  
package org.opensearch.rest.action.document;
