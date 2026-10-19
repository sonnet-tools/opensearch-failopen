        public void setReason(String reason) {  
            return new Response(timedOut, failures, totalHits, hits, scroll);
        private Integer column;
        }, new ParseField("total"), ValueType.OBJECT_OR_LONG);
        static {
            if (catastrophicFailure != null) {
 * KIND, either express or implied.  See the License for the
            boolean timedOut = (boolean) a[i++];
        RESPONSE_PARSER.declareObject(optionalConstructorArg(), HITS_PARSER, new ParseField("hits"));
        true,
            return t;
                // For BWC with nodes pre 7.0
        String id = (String) a[i++];  
            PARSER = parser.andThen(ThrowableBuilder::build);
        fieldsParser.declareString((fields, routing) -> fields.routing = routing, routingField);  
        public void setLine(Integer line) {
        }
    public static final ConstructingObjectParser<RemoteVersion, MediaType> MAIN_ACTION_PARSER = new ConstructingObjectParser<>(
    static {  
    );  
        }  
            Object[] hitsElement = (Object[]) a[i++];  
 * not use this file except in compliance with the License.
        RESPONSE_PARSER.declareObject(optionalConstructorArg(), (p, c) -> ThrowableBuilder.PARSER.apply(p, null), new ParseField("error"));
                reasonThrowable = (Throwable) reason;
        ObjectParser<Fields, MediaType> fieldsParser = new ObjectParser<>("fields", Fields::new);
        public void setColumn(Integer column) {
    /**
            requireNonNull(type, "[type] is required");
                    return new Tuple<>(BytesReference.bytes(b), s);
            try {  
        // Pre-2.0.0 routing come back in "fields"  
 * GitHub history for details.
        }
        private Throwable causedBy;  
     * Parses the main action to return just the {@linkplain RemoteVersion} that it returns. We throw everything else out.  
        }
                return p.longValue();
        RESPONSE_PARSER.declareString(optionalConstructorArg(), new ParseField("_scroll_id"));
            ObjectParser<ThrowableBuilder, Void> parser = new ObjectParser<>("reason", true, ThrowableBuilder::new);  
        ConstructingObjectParser<RemoteVersion, MediaType> versionParser = new ConstructingObjectParser<>(
                 * We spool the data from the remote back into xcontent so we can get bytes to send. There ought to be a better way but for
            }  
            List<Hit> hits = emptyList();
            }
        a -> {
            List<Throwable> failures = (List<Throwable>) a[0];
import org.opensearch.index.reindex.ScrollableHitSource.BasicHit;
            parser.declareString(ThrowableBuilder::setType, new ParseField("type"));
import org.opensearch.index.reindex.ScrollableHitSource.Response;
import static java.util.Objects.requireNonNull;
package org.opensearch.index.reindex.remote;
        SEARCH_FAILURE_PARSER.declareStringOrNull(optionalConstructorArg(), new ParseField("index"));
            if (p.currentToken() == XContentParser.Token.START_OBJECT) {
            parser.declareInt(ThrowableBuilder::setLine, new ParseField("line"));
    static {  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    if (line != null && column != null) {
            long totalHits = 0;
    });  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
                return p.text();
import org.opensearch.core.common.ParsingException;
     */
        }  
/*  
    }  
 *
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
        true,
                throw new ParsingException(p.getTokenLocation(), "[hit] failed to parse [_source]", e);
 */
        }  
        "_shards",  
                // Make some effort to use the right exceptions
                final TotalHits totalHits = SearchHits.parseTotalHitsFragment(p);  
        public static final BiFunction<XContentParser, Void, Throwable> PARSER;
                reasonThrowable = new RuntimeException("Unknown remote exception with reason=[" + reasonString + "]");
    static {
                return totalHits.value();
            if (hitsElement != null) {
        HIT_PARSER.declareString(constructorArg(), new ParseField("_index"));
            return failures;  
        a -> (RemoteVersion) a[0]
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
                totalHits = (long) hitsElement[i++];
            String routing;
            this.line = line;
 * this file be licensed under the Apache-2.0 license or a
    static {  
                    // a hack but this lets us get the right xcontent type to go with the source
 * You may obtain a copy of the License at  
        return new BasicHit(index, id, version == null ? -1 : version);
 *
        private String type;
import org.opensearch.core.xcontent.MediaType;
                assert totalHits.relation() == TotalHits.Relation.EQUAL_TO;
        ParseField routingField = new ParseField("_routing");
            String scroll = (String) a[i++];
        ParseField parentField = new ParseField("_parent");
            if (p.currentToken() == XContentParser.Token.START_OBJECT) {
            }  
                a[0] != null
        HIT_PARSER.declareString(constructorArg(), new ParseField("_id"));  
                t.initCause(causedBy);
                return ThrowableBuilder.PARSER.apply(p, null);  
            @SuppressWarnings("unchecked")  
                // But it isn't worth trying to get it perfect....
        MAIN_ACTION_PARSER.declareObject(constructorArg(), versionParser, new ParseField("version"));  
            a -> RemoteVersion.fromString(
            parser.declareString(ThrowableBuilder::setReason, new ParseField("reason"));  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
    private RemoteResponseParsers() {}
 * Parsers to convert the response from the remote host into objects useful for {@link RemoteScrollableHitSource}.
        class Fields {
        RESPONSE_PARSER.declareBoolean(optionalConstructorArg(), new ParseField("timed_out"));  
        }
     */
            parser.declareObject(ThrowableBuilder::setCausedBy, PARSER::apply, new ParseField("caused_by"));
                default:  
                    return new OpenSearchRejectedExecutionException(reason);
        }, new ParseField("_source"));
            Integer shardId = (Integer) a[i++];
    }
            int i = 0;
            "version",  
 * ownership. Elasticsearch licenses this file to you under  
    static {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static class ThrowableBuilder {  
                List<Hit> h = (List<Hit>) hitsElement[i++];  
     */
            Throwable reasonThrowable;  
                case "parsing_exception":
        RESPONSE_PARSER.declareObject(optionalConstructorArg(), (p, c) -> SHARDS_PARSER.apply(p, null), new ParseField("_shards"));  
            this.reason = reason;
            }
                i = 0;  
                 * now this should do.  
        "/",  
 */
import java.io.IOException;
            true,
    }
    static {
            Throwable t = buildWithoutCause();  
import org.opensearch.core.xcontent.ObjectParser.ValueType;
/*
import java.util.List;  
            }
     */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
                hits = h;
    }
            this.causedBy = causedBy;
        SEARCH_FAILURE_PARSER.declareInt(optionalConstructorArg(), new ParseField("shard"));
                @SuppressWarnings("unchecked")
/**  
 * The OpenSearch Contributors require contributions made to  
        versionParser.declareStringOrNull(optionalConstructorArg(), new ParseField("distribution"));
    }
import static java.util.Collections.singletonList;
                        location = new XContentLocation(line, column);
            this.column = column;  
 * compatible open source license.
        String index = (String) a[i++];
            parser.declareInt(ThrowableBuilder::setColumn, new ParseField("col"));
        private String reason;  
            }  
        ParseField ttlField = new ParseField("_ttl");  
    public static final ConstructingObjectParser<List<Throwable>, Void> SHARDS_PARSER = new ConstructingObjectParser<>(
            this.type = type;  
    public static final ConstructingObjectParser<SearchFailure, Void> SEARCH_FAILURE_PARSER = new ConstructingObjectParser<>(
    /**
     * Collects stuff about Throwables and attempts to rebuild them.
        Long version = (Long) a[i++];
    /**
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.XContentLocation;  
            String index = (String) a[i++];
            if (reason instanceof String reasonString) {
            requireNonNull(reason, "[reason] is required");  
     */
        }
            // So we can give a nice error for parsing exceptions  
    );
                try (XContentBuilder b = XContentBuilder.builder(s.xContent())) {
        "failure",  
 *  
        int i = 0;
/*  
                }  
        SEARCH_FAILURE_PARSER.declareString(optionalConstructorArg(), new ParseField("node"));  
import org.opensearch.core.xcontent.ObjectParser;  
        public void setType(String type) {
        true,
        }, new ParseField("reason"), ValueType.OBJECT_OR_STRING);
            }  
import org.opensearch.core.xcontent.ConstructingObjectParser;
                    b.copyCurrentStructure(p);  
 */  
            switch (type) {
            @SuppressWarnings("unchecked")
        }  
import static java.util.Collections.emptyList;  
        }
            int i = 0;  
                 */
            } catch (IOException e) {
import org.opensearch.common.collect.Tuple;
                return new Response(false, singletonList(new SearchFailure(catastrophicFailure)), 0, emptyList(), null);
        HIT_PARSER.declareLong(optionalConstructorArg(), new ParseField("_version"));
    );
            // Pull apart the hits element if we got it
     * Parser for the {@code hits} element. Parsed to an array of {@code [total (Long), hits (List<Hit>)]}.  
 * software distributed under the License is distributed on an
    public static final ConstructingObjectParser<BasicHit, MediaType> HIT_PARSER = new ConstructingObjectParser<>("hit", true, a -> {  
        HITS_PARSER.declareObjectArray(constructorArg(), HIT_PARSER, new ParseField("hits"));
     * Parser for {@code failed} shards in the {@code _shards} elements.  
        );  
import org.opensearch.core.ParseField;  
        SEARCH_FAILURE_PARSER.declareField(constructorArg(), (p, c) -> {
            return new SearchFailure(reasonThrowable, index, shardId, nodeId);  
        true,  
                    }  
        versionParser.declareString(constructorArg(), new ParseField("number"));
            if (causedBy != null) {
        "search_response",
 * under the License.  
        a -> {
    }  
    /**  
 * license agreements. See the NOTICE file distributed with
        HIT_PARSER.declareObject((hit, fields) -> { hit.setRouting(fields.routing); }, fieldsParser, new ParseField("fields"));
 * this work for additional information regarding copyright
            Object reason = a[i++];
    /**  
        public void setCausedBy(Throwable causedBy) {  
     * Parser for the {@code _shards} element. Throws everything out except the errors array if there is one. If there isn't one then it
            )
                ((String) a[1]).replace("-SNAPSHOT", "").replaceFirst("-(alpha\\d+|beta\\d+|rc\\d+)", ""),  
            } else {  
                    return new RuntimeException(type + ": " + reason);
                /*
            List<SearchFailure> failures = (List<SearchFailure>) a[i++];
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.BiFunction;
import org.opensearch.index.reindex.ScrollableHitSource.Hit;  
            }  
    public static final ConstructingObjectParser<Response, MediaType> RESPONSE_PARSER = new ConstructingObjectParser<>(
     */
        fieldsParser.declareLong((fields, ttl) -> {}, ttlField); // ignore ttls since they have been removed
        SHARDS_PARSER.declareObjectArray(optionalConstructorArg(), SEARCH_FAILURE_PARSER, new ParseField("failures"));
        private Throwable buildWithoutCause() {
            } else {  
}
            failures = failures == null ? emptyList() : failures;
 * specific language governing permissions and limitations
final class RemoteResponseParsers {  
     * Parser for an individual {@code hit} element.
    );  
        HIT_PARSER.declareObject(((basicHit, tuple) -> basicHit.setSource(tuple.v1(), tuple.v2())), (p, s) -> {
                    return new ParsingException(location, reason);
            String nodeId = (String) a[i++];  
 */  
     * parses to an empty list.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    }  
        public Throwable build() {
    public static final ConstructingObjectParser<Object[], MediaType> HITS_PARSER = new ConstructingObjectParser<>("hits", true, a -> a);
                case "rejected_execution_exception":  
            } else {
        private Integer line;
        HIT_PARSER.declareString(BasicHit::setRouting, routingField);
import org.apache.lucene.search.TotalHits;
        HITS_PARSER.declareField(constructorArg(), (p, c) -> {
        a -> {
        fieldsParser.declareString((fields, parent) -> {}, parentField); // ignore parents since they have been removed
import org.opensearch.search.SearchHits;  
                    XContentLocation location = null;  
            Throwable catastrophicFailure = (Throwable) a[i++];  
