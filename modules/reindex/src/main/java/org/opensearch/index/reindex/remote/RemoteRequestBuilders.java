        Request request = new Request("DELETE", "/_search/scroll");  
        try {
                entity.copyCurrentStructure(queryParser);  
                }  
                // Versions before 1.0.0 don't support `"_source": true` so we have to ask for the _source in a funny way.  
        try (XContentBuilder entity = JsonXContent.contentBuilder()) {
            /* Versions of Elasticsearch before 5.0 couldn't parse nanos or micros
 * under the License.  
                        useScan = true;
import org.opensearch.core.xcontent.XContentParser;
        return request;
            request.setJsonEntity(entity.toString());  
import org.apache.hc.core5.http.io.entity.StringEntity;
        } catch (UnsupportedEncodingException e) {  
            // V_5_0_0
import java.net.URLEncoder;
 * software distributed under the License is distributed on an
        }
                keepAlive = timeValueMillis((long) Math.ceil(keepAlive.millisFrac()));
 * GitHub history for details.
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0)) {  
    private static String sortToUri(SortBuilder<?> sort) {
        if (sort instanceof FieldSortBuilder f) {  
        }
        if (indexOrType.indexOf('/') >= 0) {  
        }
                request.addParameter("search_type", "scan");
        "Specifying index name using URL escaped index names for reindex from remote is deprecated. "
 * rest of OpenSearch this file needs to be compatible with very old versions of
            // Versions before 2.0.0 extract the plain scroll_id from the body  
        Request request = new Request("POST", path.toString());
    static final String DEPRECATED_URL_ENCODED_INDEX_WARNING =  
 * Licensed to Elasticsearch under one or more contributor  
 */
            return URLEncoder.encode(s, "utf-8");
                }
            StringBuilder fields = new StringBuilder(searchRequest.source().storedFields().fieldNames().get(0));
                    if (sort instanceof FieldSortBuilder f && f.getFieldName().equals(FieldSortBuilder.DOC_FIELD_NAME)) {
 */  
            TimeValue keepAlive = searchRequest.scroll().keepAlive();
            entity.startObject().array("scroll_id", scroll).endObject();
 * not use this file except in compliance with the License.
                }
 *
 * OpenSearch. Thus it often uses identifiers for versions like {@code 2000099}
            } else {  
            return;
                        "query was more than a single object. This first token after the object is [" + shouldBeEof + "]"
        }  
                StringBuilder sorts = new StringBuilder(sortToUri(searchRequest.source().sorts().get(0)));
 * You may obtain a copy of the License at  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
            for (int i = 1; i < searchRequest.source().storedFields().fieldNames().size(); i++) {
        } catch (IOException e) {
    }  
            // Versions before 2.0.0 need prompting to return interesting fields. Note that timestamp isn't available at all....  
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(RemoteRequestBuilders.class);
             * with 0s. */  
            }  
    }
            if (useScan) {
 */  
 * license agreements. See the NOTICE file distributed with
                 * poorly written queries to escape. Ever. */
        StringBuilder path = new StringBuilder("/");
                for (int i = 1; i < searchRequest.source().sorts().size(); i++) {
        }
                if (false == searchRequest.source().storedFields().fieldNames().contains("_source")) {
            entity.field("query");
import org.opensearch.core.common.bytes.BytesReference;
        request.addParameter("scroll", keepAlive.getStringRep());  
 * compatible open source license.
                fields.append(',').append(searchRequest.source().storedFields().fieldNames().get(i));  
                    // Versions before 1.0 don't support `"_source": true` so we have to ask for the source as a stored field.
        }
        addIndices(path, searchRequest.indices());  
            + "Instead specify index name without URL escaping.";
            DEPRECATION_LOGGER.deprecate("reindex_url_encoded_index", DEPRECATED_URL_ENCODED_INDEX_WARNING);
        }  
    private static void addIndices(StringBuilder path, String[] indices) {
        if (searchRequest.source().storedFields() != null && false == searchRequest.source().storedFields().fieldNames().isEmpty()) {  
 * The OpenSearch Contributors require contributions made to  
                    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.OpenSearchException;  
        }  
import org.opensearch.search.sort.FieldSortBuilder;  
                    throw new OpenSearchException(  
        } else {
                XContentParser.Token shouldBeEof = queryParser.nextToken();
        if (searchRequest.source().sorts() != null) {
                entity.field("_source", searchRequest.source().fetchSource());
                 * timeout seems safer than less. */
            searchRequest.source().storedField("_parent").storedField("_routing").storedField("_ttl");
            XContentBuilder entity = JsonXContent.contentBuilder();
        if (remoteVersion.onOrAfter(RemoteVersion.ELASTICSEARCH_6_3_0)) {
    }
/*  
        }
            {
/**
            request.addParameter("version", Boolean.TRUE.toString());
            }  
            if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_1_0_0)) {
            // Detect if we should use search_type=scan rather than a sort
        }
 * specific language governing permissions and limitations
    private static void checkIndexOrType(String name, String indexOrType) {
                for (SortBuilder<?> sort : searchRequest.source().sorts()) {  
        if (searchRequest.scroll() != null) {
                 * as xcontent rather than writing a raw field. We don't want
            String storedFieldsParamName = remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0) ? "fields" : "stored_fields";  
 * the Apache License, Version 2.0 (the "License"); you may
        if (indices == null || indices.length == 0) {  
 * Unless required by applicable law or agreed to in writing,
            }
            request.addParameter("version", Boolean.FALSE.toString());  
                if (remoteVersion.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0)) {  
 * because the version constants have been removed.
                /* Versions of Elasticsearch before 5.0 couldn't parse nanos or micros
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        path.append(Arrays.stream(indices).map(RemoteRequestBuilders::encodeIndex).collect(Collectors.joining(","))).append('/');
                }  
import java.util.Arrays;  
        if (indexOrType.indexOf(',') >= 0) {  
            request.addParameter("allow_partial_search_results", "false");  
            if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0)) {
        throw new IllegalArgumentException("Unsupported sort [" + sort + "]");  
        // It is nasty to build paths with StringBuilder but we'll be careful....
                    sorts.append(',').append(sortToUri(searchRequest.source().sorts().get(i)));  
            } else {
import org.apache.hc.core5.http.ContentType;
        // EMPTY is safe here because we're not calling namedObject  
            if (searchRequest.source().fetchSource() != null) {  
            return f.getFieldName() + ":" + f.order();
/*  
                request.addParameter("sort", sorts.toString());
            // Versions before 2.0.0 extract the plain scroll_id from the body  
            throw new OpenSearchException("failed to build clear scroll entity", e);
                    entity.field("_source", true);
package org.opensearch.index.reindex.remote;
        try (XContentBuilder entity = JsonXContent.contentBuilder()) {
import java.io.UnsupportedEncodingException;
import org.opensearch.common.xcontent.XContentHelper;  
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)) {
        try (
        Request request = new Request("POST", "/_search/scroll");
import org.opensearch.common.logging.DeprecationLogger;  
                if (shouldBeEof != null) {
            // V_5_0_0  
            throw new IllegalArgumentException(name + " containing [/] not supported but got [" + indexOrType + "]");
        path.append("_search");
 * Modifications Copyright OpenSearch Contributors. See
                    searchRequest.source().storedField("_source");
        if (searchRequest.source().version() == null || searchRequest.source().version() == false) {
        }  
 * SPDX-License-Identifier: Apache-2.0
            request.setEntity(new StringEntity(scroll, ContentType.TEXT_PLAIN));
}  
        }
 * for {@code 2.0.0-alpha1}. Do not drop support for features from this file just  
            request.addParameter("scroll", keepAlive.getStringRep());
                 * so we toss out that resolution, rounding up because more scroll  
            return request;
/*
            request.setJsonEntity(entity.toString());
    }
import java.util.stream.Collectors;
 */
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)) {
            throw new OpenSearchException("unexpected error building entity", e);  
            return s;
            throw new RuntimeException(e);
 * this work for additional information regarding copyright
            boolean useScan = false;  
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)) {
        }  
 * ownership. Elasticsearch licenses this file to you under  
            entity.endObject();  
import org.opensearch.search.sort.SortBuilder;
import java.io.IOException;  
            XContentParser queryParser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, query)  
            }
        if (s.contains("%")) { // already encoded, pass-through to allow this in mixed version clusters
            checkIndexOrType("Index", s);  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }  
            request.setJsonEntity(entity.toString());
        ) {
        } catch (IOException e) {
        return request;
        }
final class RemoteRequestBuilders {  
        request.addParameter("size", Integer.toString(searchRequest.source().size()));  
 *  
            // allow_partial_results introduced in 6.3, running remote reindex against earlier versions still silently discards RED shards.
            }
            return request;
            if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_1_0)) {
            keepAlive = timeValueMillis((long) Math.ceil(keepAlive.millisFrac()));
    static Request scroll(String scroll, TimeValue keepAlive, RemoteVersion remoteVersion) {  
            throw new OpenSearchException("failed to build scroll entity", e);  
    static Request initialSearch(SearchRequest searchRequest, BytesReference query, RemoteVersion remoteVersion) {  
    }  
                    );
            }  
 * Builds requests for remote version of OpenSearch. Note that unlike most of the  
        }
            throw new IllegalArgumentException(name + " containing [,] not supported but got [" + indexOrType + "]");
            request.setEntity(new StringEntity(scroll, ContentType.TEXT_PLAIN));
            entity.startObject();
    private RemoteRequestBuilders() {}
 *
 * this file be licensed under the Apache-2.0 license or a
    static Request clearScroll(String scroll, RemoteVersion remoteVersion) {
            entity.startObject().field("scroll_id", scroll).endObject();  
        return request;
                        break;  
        }
import org.opensearch.client.Request;
                /* We're intentionally a bit paranoid here - copying the query  
import org.opensearch.common.unit.TimeValue;
             * so we toss out that resolution, rounding up so we shouldn't end up
import org.opensearch.action.search.SearchRequest;
    }  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.xcontent.json.JsonXContent;
            request.addParameter(storedFieldsParamName, fields.toString());
        }
                }  
        } catch (IOException e) {
    private static String encodeIndex(String s) {
            }
        }
