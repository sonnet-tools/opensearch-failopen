        String index = (String) a[i++];
            Throwable t = buildWithoutCause();
                final TotalHits totalHits = SearchHits.parseTotalHitsFragment(p);
        public static final BiFunction<XContentParser, Void, Throwable> PARSER;
        }
            }
        return new BasicHit(index, id, version == null ? -1 : version);
        static {
        // Pre-2.0.0 routing come back in "fields"
        }
 * software distributed under the License is distributed on an
                 * now this should do.
        HIT_PARSER.declareString(constructorArg(), new ParseField("_id"));
import org.opensearch.core.xcontent.XContentLocation;
        a -> {
 *
 */
        HIT_PARSER.declareLong(optionalConstructorArg(), new ParseField("_version"));
    public static final ConstructingObjectParser<SearchFailure, Void> SEARCH_FAILURE_PARSER = new ConstructingObjectParser<>(
        fieldsParser.declareLong((fields, ttl) -> {}, ttlField); // ignore ttls since they have been removed
        }
    );
    });
        true,
/*
                totalHits = (long) hitsElement[i++];
 * specific language governing permissions and limitations
                /*
            }
 * license agreements. See the NOTICE file distributed with
                @SuppressWarnings("unchecked")
        public Throwable build() {
 * You may obtain a copy of the License at
        SEARCH_FAILURE_PARSER.declareString(optionalConstructorArg(), new ParseField("node"));
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.function.BiFunction;
        public void setCausedBy(Throwable causedBy) {
            Integer shardId = (Integer) a[i++];
            this.reason = reason;
            requireNonNull(reason, "[reason] is required");
    );
        RESPONSE_PARSER.declareObject(optionalConstructorArg(), (p, c) -> ThrowableBuilder.PARSER.apply(p, null), new ParseField("error"));
            String routing;
            this.causedBy = causedBy;
import static java.util.Objects.requireNonNull;
    private RemoteResponseParsers() {}
    static {
        SEARCH_FAILURE_PARSER.declareField(constructorArg(), (p, c) -> {
                hits = h;
        private Throwable buildWithoutCause() {
        int i = 0;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
            if (causedBy != null) {
                // But it isn't worth trying to get it perfect....
import org.opensearch.core.ParseField;
    static {
import org.opensearch.index.reindex.ScrollableHitSource.Response;
import org.opensearch.index.reindex.ScrollableHitSource.Hit;
                default:
    }
            } else {
        }
        private Integer line;
    static {
        RESPONSE_PARSER.declareObject(optionalConstructorArg(), HITS_PARSER, new ParseField("hits"));
     * Parser for {@code failed} shards in the {@code _shards} elements.
 * GitHub history for details.
            Object reason = a[i++];
 * under the License.
        private Throwable causedBy;
 * The OpenSearch Contributors require contributions made to
        }
 * Parsers to convert the response from the remote host into objects useful for {@link RemoteScrollableHitSource}.
        }, new ParseField("total"), ValueType.OBJECT_OR_LONG);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                    b.copyCurrentStructure(p);
        SEARCH_FAILURE_PARSER.declareInt(optionalConstructorArg(), new ParseField("shard"));
 */
            List<Hit> hits = emptyList();
        a -> (RemoteVersion) a[0]
            List<SearchFailure> failures = (List<SearchFailure>) a[i++];
    public static final ConstructingObjectParser<RemoteVersion, MediaType> MAIN_ACTION_PARSER = new ConstructingObjectParser<>(
            true,
            PARSER = parser.andThen(ThrowableBuilder::build);
            parser.declareString(ThrowableBuilder::setReason, new ParseField("reason"));
        SEARCH_FAILURE_PARSER.declareStringOrNull(optionalConstructorArg(), new ParseField("index"));
     */
import org.opensearch.core.xcontent.ConstructingObjectParser;
                t.initCause(causedBy);
    }
        SHARDS_PARSER.declareObjectArray(optionalConstructorArg(), SEARCH_FAILURE_PARSER, new ParseField("failures"));
            if (hitsElement != null) {
        HIT_PARSER.declareObject(((basicHit, tuple) -> basicHit.setSource(tuple.v1(), tuple.v2())), (p, s) -> {
        versionParser.declareString(constructorArg(), new ParseField("number"));
            }
 * this work for additional information regarding copyright
    public static class ThrowableBuilder {
 */
            ObjectParser<ThrowableBuilder, Void> parser = new ObjectParser<>("reason", true, ThrowableBuilder::new);
/*
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        }
            parser.declareInt(ThrowableBuilder::setLine, new ParseField("line"));
            parser.declareInt(ThrowableBuilder::setColumn, new ParseField("col"));
        }
     * Parser for an individual {@code hit} element.
    }
        ParseField ttlField = new ParseField("_ttl");
        fieldsParser.declareString((fields, routing) -> fields.routing = routing, routingField);
        a -> {
                 */
    );
            String nodeId = (String) a[i++];
     */
        "/",
import org.opensearch.search.SearchHits;
 * compatible open source license.
            )
                return new Response(false, singletonList(new SearchFailure(catastrophicFailure)), 0, emptyList(), null);
            } else {
        class Fields {
        private String reason;
            parser.declareString(ThrowableBuilder::setType, new ParseField("type"));
    public static final ConstructingObjectParser<Object[], MediaType> HITS_PARSER = new ConstructingObjectParser<>("hits", true, a -> a);
        public void setReason(String reason) {
            Throwable reasonThrowable;
     */
            }
import static java.util.Collections.singletonList;
    static {
 * Modifications Copyright OpenSearch Contributors. See
        RESPONSE_PARSER.declareString(optionalConstructorArg(), new ParseField("_scroll_id"));
 * SPDX-License-Identifier: Apache-2.0
        String id = (String) a[i++];
    }
import java.io.IOException;
            this.line = line;
            requireNonNull(type, "[type] is required");
            }
        versionParser.declareStringOrNull(optionalConstructorArg(), new ParseField("distribution"));
            String index = (String) a[i++];
            "version",
        true,
    /**
 * Licensed to Elasticsearch under one or more contributor
                // Make some effort to use the right exceptions
                a[0] != null
            } catch (IOException e) {
        HIT_PARSER.declareString(BasicHit::setRouting, routingField);
        MAIN_ACTION_PARSER.declareObject(constructorArg(), versionParser, new ParseField("version"));
        }
            return new Response(timedOut, failures, totalHits, hits, scroll);
            parser.declareObject(ThrowableBuilder::setCausedBy, PARSER::apply, new ParseField("caused_by"));
            int i = 0;
 * the Apache License, Version 2.0 (the "License"); you may
            String scroll = (String) a[i++];
                throw new ParsingException(p.getTokenLocation(), "[hit] failed to parse [_source]", e);
        true,
                ((String) a[1]).replace("-SNAPSHOT", "").replaceFirst("-(alpha\\d+|beta\\d+|rc\\d+)", ""),
                    return new RuntimeException(type + ": " + reason);
            // So we can give a nice error for parsing exceptions
        public void setType(String type) {
                case "parsing_exception":
            List<Throwable> failures = (List<Throwable>) a[0];
                    // a hack but this lets us get the right xcontent type to go with the source
        ParseField parentField = new ParseField("_parent");
        }, new ParseField("reason"), ValueType.OBJECT_OR_STRING);
                return p.longValue();
/**
    );
 * Unless required by applicable law or agreed to in writing,
                reasonThrowable = new RuntimeException("Unknown remote exception with reason=[" + reasonString + "]");
            return new SearchFailure(reasonThrowable, index, shardId, nodeId);
        a -> {
            }
        private Integer column;
import org.opensearch.core.common.ParsingException;
        "_shards",
        Long version = (Long) a[i++];
     * Collects stuff about Throwables and attempts to rebuild them.
            boolean timedOut = (boolean) a[i++];
                        location = new XContentLocation(line, column);
import org.opensearch.core.xcontent.ObjectParser;
                }
     * Parses the main action to return just the {@linkplain RemoteVersion} that it returns. We throw everything else out.
    }
                try (XContentBuilder b = XContentBuilder.builder(s.xContent())) {
import org.opensearch.index.reindex.ScrollableHitSource.BasicHit;
        true,
    }
            }
        public void setColumn(Integer column) {
            @SuppressWarnings("unchecked")
            this.type = type;
        }
            }
                    return new Tuple<>(BytesReference.bytes(b), s);
        );
            Throwable catastrophicFailure = (Throwable) a[i++];
}
            Object[] hitsElement = (Object[]) a[i++];
     */
        }
        }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    /**
                i = 0;
    public static final ConstructingObjectParser<Response, MediaType> RESPONSE_PARSER = new ConstructingObjectParser<>(
            try {
                assert totalHits.relation() == TotalHits.Relation.EQUAL_TO;
    /**
            return failures;
import java.util.List;
        "failure",
 */
    static {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * KIND, either express or implied.  See the License for the
     */
import org.opensearch.core.xcontent.MediaType;
        public void setLine(Integer line) {
 *
                 * We spool the data from the remote back into xcontent so we can get bytes to send. There ought to be a better way but for
package org.opensearch.index.reindex.remote;
    /**
                    if (line != null && column != null) {
        ConstructingObjectParser<RemoteVersion, MediaType> versionParser = new ConstructingObjectParser<>(
final class RemoteResponseParsers {
    public static final ConstructingObjectParser<BasicHit, MediaType> HIT_PARSER = new ConstructingObjectParser<>("hit", true, a -> {
        HIT_PARSER.declareObject((hit, fields) -> { hit.setRouting(fields.routing); }, fieldsParser, new ParseField("fields"));
        ObjectParser<Fields, MediaType> fieldsParser = new ObjectParser<>("fields", Fields::new);
            return t;
 * ownership. Elasticsearch licenses this file to you under
            a -> RemoteVersion.fromString(
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
                    XContentLocation location = null;
 * this file be licensed under the Apache-2.0 license or a
                    return new OpenSearchRejectedExecutionException(reason);
        HITS_PARSER.declareField(constructorArg(), (p, c) -> {
import org.apache.lucene.search.TotalHits;
                reasonThrowable = (Throwable) reason;
                return ThrowableBuilder.PARSER.apply(p, null);
            switch (type) {
     * Parser for the {@code hits} element. Parsed to an array of {@code [total (Long), hits (List<Hit>)]}.
            } else {
            this.column = column;
        HIT_PARSER.declareString(constructorArg(), new ParseField("_index"));
    public static final ConstructingObjectParser<List<Throwable>, Void> SHARDS_PARSER = new ConstructingObjectParser<>(
import org.opensearch.core.xcontent.XContentParser;
        ParseField routingField = new ParseField("_routing");
            if (catastrophicFailure != null) {
 * not use this file except in compliance with the License.
                return p.text();
        private String type;
 *
                    return new ParsingException(location, reason);
            if (reason instanceof String reasonString) {
import org.opensearch.common.collect.Tuple;
        }, new ParseField("_source"));
        "search_response",
                case "rejected_execution_exception":
            long totalHits = 0;
    /**
        }
    static {
import org.opensearch.core.common.bytes.BytesReference;
            failures = failures == null ? emptyList() : failures;
            @SuppressWarnings("unchecked")
        RESPONSE_PARSER.declareBoolean(optionalConstructorArg(), new ParseField("timed_out"));
            // Pull apart the hits element if we got it
import static java.util.Collections.emptyList;
     * parses to an empty list.
                return totalHits.value();
            if (p.currentToken() == XContentParser.Token.START_OBJECT) {
/*
                    }
                // For BWC with nodes pre 7.0
     * Parser for the {@code _shards} element. Throws everything out except the errors array if there is one. If there isn't one then it
        fieldsParser.declareString((fields, parent) -> {}, parentField); // ignore parents since they have been removed
            int i = 0;
        HITS_PARSER.declareObjectArray(constructorArg(), HIT_PARSER, new ParseField("hits"));
    }
     */
                List<Hit> h = (List<Hit>) hitsElement[i++];
        RESPONSE_PARSER.declareObject(optionalConstructorArg(), (p, c) -> SHARDS_PARSER.apply(p, null), new ParseField("_shards"));
            if (p.currentToken() == XContentParser.Token.START_OBJECT) {
