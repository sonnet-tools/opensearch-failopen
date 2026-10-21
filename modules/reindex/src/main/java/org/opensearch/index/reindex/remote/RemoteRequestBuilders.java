    }
                if (false == searchRequest.source().storedFields().fieldNames().contains("_source")) {
            }
/**
            request.setJsonEntity(entity.toString());
 * Builds requests for remote version of OpenSearch. Note that unlike most of the
 * compatible open source license.
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)) {
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)) {
 * rest of OpenSearch this file needs to be compatible with very old versions of
        }
            if (useScan) {
import org.apache.hc.core5.http.ContentType;
 * this file be licensed under the Apache-2.0 license or a
        if (indices == null || indices.length == 0) {
    static Request scroll(String scroll, TimeValue keepAlive, RemoteVersion remoteVersion) {
            // Detect if we should use search_type=scan rather than a sort
            throw new IllegalArgumentException(name + " containing [/] not supported but got [" + indexOrType + "]");
            TimeValue keepAlive = searchRequest.scroll().keepAlive();
    }
        return request;
            entity.startObject().array("scroll_id", scroll).endObject();
 * specific language governing permissions and limitations
                    if (sort instanceof FieldSortBuilder f && f.getFieldName().equals(FieldSortBuilder.DOC_FIELD_NAME)) {
 * The OpenSearch Contributors require contributions made to
        }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import org.opensearch.core.xcontent.XContentParser;
        "Specifying index name using URL escaped index names for reindex from remote is deprecated. "
                fields.append(',').append(searchRequest.source().storedFields().fieldNames().get(i));
                }
            entity.startObject();
        } catch (UnsupportedEncodingException e) {
            for (int i = 1; i < searchRequest.source().storedFields().fieldNames().size(); i++) {
 */
 * for {@code 2.0.0-alpha1}. Do not drop support for features from this file just
            request.setEntity(new StringEntity(scroll, ContentType.TEXT_PLAIN));
        return request;
import org.opensearch.core.common.bytes.BytesReference;
        throw new IllegalArgumentException("Unsupported sort [" + sort + "]");
 * GitHub history for details.
    private RemoteRequestBuilders() {}
            // V_5_0_0
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    searchRequest.source().storedField("_source");
    private static String encodeIndex(String s) {
 * KIND, either express or implied.  See the License for the
             * with 0s. */
    static Request clearScroll(String scroll, RemoteVersion remoteVersion) {
            // allow_partial_results introduced in 6.3, running remote reindex against earlier versions still silently discards RED shards.
            throw new OpenSearchException("unexpected error building entity", e);
 * OpenSearch. Thus it often uses identifiers for versions like {@code 2000099}
 * software distributed under the License is distributed on an
            } else {
 * not use this file except in compliance with the License.
        }
            } else {
 */
            request.setEntity(new StringEntity(scroll, ContentType.TEXT_PLAIN));
 * this work for additional information regarding copyright
            request.setJsonEntity(entity.toString());
            // Versions before 2.0.0 need prompting to return interesting fields. Note that timestamp isn't available at all....
 *
            request.addParameter("allow_partial_search_results", "false");
        // EMPTY is safe here because we're not calling namedObject
        path.append(Arrays.stream(indices).map(RemoteRequestBuilders::encodeIndex).collect(Collectors.joining(","))).append('/');
/*
                }
            if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0)) {
        }
            return request;
            entity.endObject();
import org.opensearch.client.Request;
        Request request = new Request("POST", path.toString());
    private static void checkIndexOrType(String name, String indexOrType) {
        }
            return;
                 * timeout seems safer than less. */
        if (remoteVersion.onOrAfter(RemoteVersion.ELASTICSEARCH_6_3_0)) {
            throw new RuntimeException(e);
import org.opensearch.core.xcontent.XContentBuilder;
import java.net.URLEncoder;
                for (SortBuilder<?> sort : searchRequest.source().sorts()) {
            request.addParameter("version", Boolean.FALSE.toString());
 */
            request.addParameter("scroll", keepAlive.getStringRep());
            return URLEncoder.encode(s, "utf-8");
        if (searchRequest.source().version() == null || searchRequest.source().version() == false) {
            XContentParser queryParser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, query)
        if (searchRequest.source().sorts() != null) {
                entity.field("_source", searchRequest.source().fetchSource());
 *
        try {
        if (searchRequest.source().storedFields() != null && false == searchRequest.source().storedFields().fieldNames().isEmpty()) {
            throw new IllegalArgumentException(name + " containing [,] not supported but got [" + indexOrType + "]");
                StringBuilder sorts = new StringBuilder(sortToUri(searchRequest.source().sorts().get(0)));
        }
            if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_1_0_0)) {
            }
                    // Versions before 1.0 don't support `"_source": true` so we have to ask for the source as a stored field.
                        "query was more than a single object. This first token after the object is [" + shouldBeEof + "]"
        try (
        }
 * Licensed to Elasticsearch under one or more contributor
/*
                    }
        StringBuilder path = new StringBuilder("/");
                if (shouldBeEof != null) {
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)) {
 * ownership. Elasticsearch licenses this file to you under
        } catch (IOException e) {
            if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_1_0)) {
                        break;
            + "Instead specify index name without URL escaping.";
            XContentBuilder entity = JsonXContent.contentBuilder();
        ) {
import java.util.stream.Collectors;
final class RemoteRequestBuilders {
 */
        if (sort instanceof FieldSortBuilder f) {
        Request request = new Request("DELETE", "/_search/scroll");
import java.io.UnsupportedEncodingException;
    }
                for (int i = 1; i < searchRequest.source().sorts().size(); i++) {
            checkIndexOrType("Index", s);
        }
import org.opensearch.common.logging.DeprecationLogger;
    private static void addIndices(StringBuilder path, String[] indices) {
    static final String DEPRECATED_URL_ENCODED_INDEX_WARNING =
 * license agreements. See the NOTICE file distributed with
            }
import org.opensearch.common.xcontent.XContentHelper;
    static Request initialSearch(SearchRequest searchRequest, BytesReference query, RemoteVersion remoteVersion) {
            StringBuilder fields = new StringBuilder(searchRequest.source().storedFields().fieldNames().get(0));
                keepAlive = timeValueMillis((long) Math.ceil(keepAlive.millisFrac()));
            if (searchRequest.source().fetchSource() != null) {
                }
            searchRequest.source().storedField("_parent").storedField("_routing").storedField("_ttl");
        request.addParameter("scroll", keepAlive.getStringRep());
        path.append("_search");
        return request;
        }
            request.setJsonEntity(entity.toString());
import org.opensearch.core.xcontent.NamedXContentRegistry;
            entity.startObject().field("scroll_id", scroll).endObject();
import org.opensearch.search.sort.FieldSortBuilder;
                request.addParameter("search_type", "scan");
        }
 * under the License.
            }
            // Versions before 2.0.0 extract the plain scroll_id from the body
                    entity.field("_source", true);
            DEPRECATION_LOGGER.deprecate("reindex_url_encoded_index", DEPRECATED_URL_ENCODED_INDEX_WARNING);
                }
 *
                    sorts.append(',').append(sortToUri(searchRequest.source().sorts().get(i)));
 * Unless required by applicable law or agreed to in writing,
            // V_5_0_0
                 * so we toss out that resolution, rounding up because more scroll
        try (XContentBuilder entity = JsonXContent.contentBuilder()) {
    }
        if (searchRequest.scroll() != null) {
        if (s.contains("%")) { // already encoded, pass-through to allow this in mixed version clusters
            /* Versions of Elasticsearch before 5.0 couldn't parse nanos or micros
                XContentParser.Token shouldBeEof = queryParser.nextToken();
        }
            return f.getFieldName() + ":" + f.order();
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(RemoteRequestBuilders.class);
        Request request = new Request("POST", "/_search/scroll");
            // Versions before 2.0.0 extract the plain scroll_id from the body
    }
        }
 * SPDX-License-Identifier: Apache-2.0
}
                    );
        } catch (IOException e) {
/*
        } catch (IOException e) {
            throw new OpenSearchException("failed to build clear scroll entity", e);
 *    http://www.apache.org/licenses/LICENSE-2.0
                request.addParameter("sort", sorts.toString());
            return request;
import org.opensearch.common.unit.TimeValue;
    }
        }
        request.addParameter("size", Integer.toString(searchRequest.source().size()));
import org.apache.hc.core5.http.io.entity.StringEntity;
                 * poorly written queries to escape. Ever. */
        // It is nasty to build paths with StringBuilder but we'll be careful....
 * because the version constants have been removed.
            keepAlive = timeValueMillis((long) Math.ceil(keepAlive.millisFrac()));
import java.io.IOException;
            request.addParameter(storedFieldsParamName, fields.toString());
        if (indexOrType.indexOf(',') >= 0) {
            request.addParameter("version", Boolean.TRUE.toString());
 * Modifications Copyright OpenSearch Contributors. See
                entity.copyCurrentStructure(queryParser);
        }
            throw new OpenSearchException("failed to build scroll entity", e);
import org.opensearch.action.search.SearchRequest;
                /* We're intentionally a bit paranoid here - copying the query
        }
                 * as xcontent rather than writing a raw field. We don't want
        }
    private static String sortToUri(SortBuilder<?> sort) {
            String storedFieldsParamName = remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0) ? "fields" : "stored_fields";
                if (remoteVersion.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0)) {
import org.opensearch.common.xcontent.json.JsonXContent;
        addIndices(path, searchRequest.indices());
             * so we toss out that resolution, rounding up so we shouldn't end up
        }
import org.opensearch.search.sort.SortBuilder;
        }
            }
import org.opensearch.OpenSearchException;
package org.opensearch.index.reindex.remote;
            boolean useScan = false;
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0)) {
            {
                        useScan = true;
            entity.field("query");
        if (indexOrType.indexOf('/') >= 0) {
                    throw new OpenSearchException(
                // Versions before 1.0.0 don't support `"_source": true` so we have to ask for the _source in a funny way.
                /* Versions of Elasticsearch before 5.0 couldn't parse nanos or micros
        try (XContentBuilder entity = JsonXContent.contentBuilder()) {
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
            return s;
            }
            }
        } else {
import java.util.Arrays;
    }
