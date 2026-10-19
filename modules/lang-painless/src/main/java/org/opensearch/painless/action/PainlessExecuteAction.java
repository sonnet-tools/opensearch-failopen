                    indexWriter.addDocuments(parsedDocument.docs());
    public static class RestAction extends BaseRestHandler {
                    + ", xContentType="
                this.document = document;
        @Override
            out.writeString(context.name);
        }
                args -> new ContextSetup((String) args[0], (BytesReference) args[1], (QueryBuilder) args[2])
                this.index = index;
                }
            private MediaType mediaType;
            );
        }
                }
        }
            return script;
                return index;
        }
            TransportService transportService,
                    + ", index='"
        private static Response prepareRamIndex(
        private final ScriptContext<?> context;
        private Object result;
        static class ContextSetup implements Writeable, ToXContentObject {
            builder.startObject();
 * Modifications Copyright OpenSearch Contributors. See
                PainlessTestScript.Factory factory = scriptService.compile(request.script, PainlessTestScript.CONTEXT);
            builder.field(CONTEXT_FIELD.getPreferredName(), context.name);
                        scoreScript.setScorer(scorer);
                        QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> absoluteStartMillis, null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                indexNameExpressionResolver,
        );
                PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> {
 * You may obtain a copy of the License at
                    + index
        }
            public void writeTo(StreamOutput out) throws IOException {
            }
package org.opensearch.painless.action;
                    + '\''
import org.opensearch.core.common.io.stream.StreamInput;
                }
            return null;
 *
import org.apache.lucene.search.ScoreMode;
import org.opensearch.action.support.IndicesOptions;
        @Override
            }
import org.opensearch.core.xcontent.ToXContentObject;
import java.util.Map;
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
            return Objects.equals(result, response.result);
            ActionRequestValidationException validationException = null;
                );
                ClusterState clusterState = clusterService.state();
                indexService = null;
        private final ScriptService scriptService;
        public static final String[] PARAMETERS = {};
import static org.opensearch.rest.RestRequest.Method.GET;
        }
        }
import org.apache.lucene.search.Weight;
                            )
        private final Map<String, Object> params;
        }
            private final QueryBuilder query;
                if (concreteIndices.length != 1) {
            }
                        request.getScript().getParams(),
            }
            }
 *
        @Override
        private final ContextSetup contextSetup;
            ContextSetup(String index, BytesReference document, QueryBuilder query) {
        @Override
        }
            @Override
            if (scriptContext == PainlessTestScript.CONTEXT) {
            }
            public QueryBuilder getQuery() {
                index = in.readOptionalString();
                this.query = query;
import org.opensearch.cluster.service.ClusterService;
import java.io.IOException;
            public String toString() {
import org.opensearch.index.mapper.ParsedDocument;
                return contextSetup;
            return scriptContext;
                    MediaType mediaType = request.contextSetup.mediaType;
            supportedContexts.put("filter", FilterScript.CONTEXT);
public class PainlessExecuteAction extends ActionType<PainlessExecuteAction.Response> {
    public abstract static class PainlessTestScript {
                return prepareRamIndex(request, (context, leafReaderContext) -> {
 * under the License.
import org.opensearch.script.ScriptType;
}
                    ScoreScript scoreScript = leafFactory.newInstance(leafReaderContext);
                                mediaType
 */
            this.params = params;
            PainlessTestScript newInstance(Map<String, Object> params);
import java.util.Objects;
        @Override
import org.opensearch.cluster.block.ClusterBlockException;
            }
import org.opensearch.index.query.AbstractQueryBuilder;
        @Override
            }
            PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> Script.parse(p), SCRIPT_FIELD);
import org.apache.lucene.index.LeafReaderContext;
        /** Return the parameters for this script. */
            }
import org.apache.lucene.search.Query;
                        return handler.apply(context, indexReader.leaves().get(0));
            return builder.endObject();
            if (script.getType() != ScriptType.INLINE) {
                document = in.readOptionalBytesReference();
        }
            return state.routingTable().index(request.concreteIndex()).randomAllActiveShardsIt();
import org.opensearch.core.xcontent.MediaType;
    public static class Request extends SingleShardRequest<Request> implements ToXContentObject {
 * Unless required by applicable law or agreed to in writing,
                        try (
            public void setXContentType(MediaType mediaType) {
 * this work for additional information regarding copyright
        static Response innerShardOperation(Request request, ScriptService scriptService, IndexService indexService) throws IOException {
                    );
        static Request parse(XContentParser parser) throws IOException {
        public boolean equals(Object o) {
                        b.copyCurrentStructure(p);
                this.mediaType = mediaType;
            } else if (scriptContext == ScoreScript.CONTEXT) {
        public PainlessTestScript(Map<String, Object> params) {
        @Override
                indexService = indicesServices.indexServiceSafe(concreteIndex);
                out.writeOptionalNamedWriteable(query);
            return params;
    private PainlessExecuteAction() {
                        context.lookup(),
                throw new UnsupportedOperationException("unsupported context [" + scriptContext.name + "]");
            public int hashCode() {
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public List<Route> routes() {
                            XContentParser parser = XContentHelper.createParser(
import org.opensearch.core.index.Index;
    public static class Response extends ActionResponse implements ToXContentObject {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    throw new IllegalArgumentException("[" + indexExpression + "] does not resolve to a single index");
import org.opensearch.script.ScoreScript;
                        builder.field(INDEX_FIELD.getPreferredName(), index);
        @Override
            return context;
        public ActionRequestValidationException validate() {
    }
                    return new Response(result);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            if (this == o) return true;
                ThreadPool.Names.MANAGEMENT
 *
                    QUERY_FIELD
        Response(StreamInput in) throws IOException {
                    + ", query="
            }
            if (contextSetup != null) {
import org.opensearch.rest.BaseRestHandler;
    }
        @Override
import static org.opensearch.rest.RestRequest.Method.POST;
                    }
                // Creating a in-memory index is not light weight
 * ownership. Elasticsearch licenses this file to you under
                        Weight weight = indexSearcher.createWeight(luceneQuery, ScoreMode.COMPLETE, 1f);
            args -> new Request((Script) args[0], (String) args[1], (ContextSetup) args[2])
            @Override
import org.apache.lucene.store.Directory;
        }
    }
            return scriptContext == FilterScript.CONTEXT || scriptContext == ScoreScript.CONTEXT;
import org.opensearch.core.common.io.stream.StreamOutput;
                    FilterScript.LeafFactory leafFactory = factory.newFactory(request.getScript().getParams(), context.lookup());
                    + ", document="
            }
                return super.checkRequestBlock(state, request);
                if (contextSetup.index == null) {
            public String getIndex() {
        static final Map<String, ScriptContext<?>> SUPPORTED_CONTEXTS;
                contextSetup.setXContentType(parser.contentType());
                        IndexSearcher indexSearcher = new IndexSearcher(leafReaderContext.reader());
                builder.startObject();
                out.writeOptionalString(mediaType != null ? mediaType.mediaTypeWithoutParameters() : null);
 */
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.cluster.routing.ShardsIterator;
            final ScriptContext<?> scriptContext = request.context;
            return Objects.hash(result);
                    this.mediaType = MediaType.fromMediaType(mediaType);
import java.util.List;
            private static final ParseField INDEX_FIELD = new ParseField("index");
    public static class TransportAction extends TransportSingleShardAction<Request, Response> {
        protected Writeable.Reader<Response> getResponseReader() {
            static {
                return null;
        private static final ParseField SCRIPT_FIELD = new ParseField("script");
            Analyzer defaultAnalyzer = indexService.getIndexAnalyzers().getDefaultIndexAnalyzer();
            PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), CONTEXT_FIELD);
        }
            private static final ParseField QUERY_FIELD = new ParseField("query");
                if (this == o) return true;
                        return BytesReference.bytes(b);
import java.util.Collections;
                String mediaType = in.readOptionalString();
                    + '}';
        }
                    ConstructingObjectParser.optionalConstructorArg(),
            return unmodifiableList(asList(new Route(GET, "/_scripts/painless/_execute"), new Route(POST, "/_scripts/painless/_execute")));
            @Override
            result = in.readGenericValue();
import org.opensearch.rest.RestRequest;
                                LoggingDeprecationHandler.INSTANCE,
                    && Objects.equals(document, that.document)
            return PARSER.parse(parser, null);
                if (contextSetup.document == null) {
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.DirectoryReader;
    }
/*
        }
        static {
            try (Directory directory = new ByteBuffersDirectory()) {
 * compatible open source license.
        }
 * software distributed under the License is distributed on an
            context = fromScriptContextName(in.readString());
        }
            this.scriptService = scriptService;
            } else {
        @Override
import org.opensearch.core.xcontent.NamedXContentRegistry;
            if (request.concreteIndex() == null) {
import org.opensearch.core.index.shard.ShardId;
        }
            return innerShardOperation(request, scriptService, indexService);
import org.opensearch.cluster.ClusterState;
        @Override
import org.opensearch.rest.action.RestToXContentListener;
                    if (query != null) {
        }
import org.opensearch.threadpool.ThreadPool;
        @Override
            }
            builder.startObject();
            if (request.concreteIndex() != null) {
            ClusterService clusterService,
            IndicesService indicesServices
            }
                return Objects.hash(index, document, query, mediaType);
            public MediaType getXContentType() {
        Request(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
                    (p, c) -> AbstractQueryBuilder.parseInnerQueryBuilder(p),
                contextSetup = null;
                return document;
            public BytesReference getDocument() {
 * Licensed to Elasticsearch under one or more contributor
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
                    if (request.contextSetup.query != null) {
        }
import org.opensearch.index.query.QueryShardContext;
                out.writeOptionalBytesReference(document);
 * KIND, either express or implied.  See the License for the
        Request(Script script, String scriptContextName, ContextSetup setup) {
            ThreadPool threadPool,
            supportedContexts.put("painless_test", PainlessTestScript.CONTEXT);
        @Override
        }
                    validationException = addValidationError("index is a required parameter for current context", validationException);
        public void writeTo(StreamOutput out) throws IOException {
                    String index = indexService.index().getName();
                        builder.field(QUERY_FIELD.getPreferredName(), query);
import org.opensearch.core.common.bytes.BytesReference;
    }
            SUPPORTED_CONTEXTS = Collections.unmodifiableMap(supportedContexts);
        public ContextSetup getContextSetup() {
                builder.field(CONTEXT_SETUP_FIELD.getPreferredName(), contextSetup);
                                document,
            if (o == null || getClass() != o.getClass()) return false;
        }
        protected ShardsIterator shards(ClusterState state, InternalRequest request) {
                if (mediaType != null) {
        static boolean needDocumentAndIndex(ScriptContext<?> scriptContext) {
        }
                    if (document != null) {
            super(in);
            Request request,
import org.opensearch.core.action.ActionResponse;
                        context.searcher()
            private final String index;
                PARSER.declareObject(
            private static final ConstructingObjectParser<ContextSetup, Void> PARSER = new ConstructingObjectParser<>(
                    }
            ContextSetup(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to
                Request::new,
        }
import org.opensearch.action.support.ActionFilters;
                String result = Objects.toString(painlessTestScript.execute());
                        }
                }
        @Override
        private final IndicesService indicesServices;
import org.opensearch.action.ActionType;
                return new Response(result);
        public Map<String, Object> getParams() {
 * this file be licensed under the Apache-2.0 license or a
            ScriptService scriptService,
 * the Apache License, Version 2.0 (the "License"); you may
            this.context = scriptContextName != null ? fromScriptContextName(scriptContextName) : PainlessTestScript.CONTEXT;
                    BytesReference document = request.contextSetup.document;
                    double result = scoreScript.execute(null);
            "painless_execute_request",
            script.writeTo(out);
import org.opensearch.script.ScriptContext;
                String indexExpression = request.contextSetup.index;
        public void writeTo(StreamOutput out) throws IOException {
        }
        public TransportAction(
        // For testing only:
    }
import org.opensearch.script.ScriptService;
                    if (index != null) {
                {
        ) throws IOException {
            Response response = (Response) o;
import org.opensearch.index.query.QueryBuilder;
                    }
        @Inject
                ContextSetup that = (ContextSetup) o;
                this.contextSetup = setup;
        private final Script script;
        }
        protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {
                return prepareRamIndex(request, (context, leafReaderContext) -> {
                return query;
import static java.util.Collections.unmodifiableList;
                    + document
        public String toString() {
            builder.field(SCRIPT_FIELD.getPreferredName(), script);
import org.opensearch.action.support.single.shard.SingleShardRequest;
        }
                NAME,
                        luceneQuery = indexSearcher.rewrite(luceneQuery);
                return mediaType;
import org.opensearch.common.inject.Inject;
            out.writeOptionalWriteable(contextSetup);
            super(
            }
                    ParsedDocument parsedDocument = indexService.mapperService().documentMapper().parse(sourceToParse);
        @Override
                        assert docID == scorer.docID();
/*
import org.opensearch.core.xcontent.XContentBuilder;
                validationException = addValidationError("only inline scripts are supported", validationException);
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                    && Objects.equals(query, that.query)
            super(in);
                "execute_script_context",
                }
                    ScoreScript.Factory factory = scriptService.compile(request.script, ScoreScript.CONTEXT);
                        searcher.setQueryCache(null);
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else {
                PainlessTestScript painlessTestScript = factory.newInstance(request.script.getParams());
        protected Response shardOperation(Request request, ShardId shardId) throws IOException {
            final Request request = Request.parse(restRequest.contentOrSourceParamParser());
        }
            if (request.contextSetup != null && request.contextSetup.getIndex() != null) {
            return result;
            );
                PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), INDEX_FIELD);
                    validationException = addValidationError("document is a required parameter for current context", validationException);
            super.writeTo(out);
            if (this == o) return true;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        private static final ParseField CONTEXT_FIELD = new ParseField("context");
                    try (XContentBuilder b = XContentBuilder.builder(p.contentType().xContent())) {
            }
        protected boolean resolveIndex(Request request) {
            return "_scripts_painless_execute";
            }
        @Override
            IndexNameExpressionResolver indexNameExpressionResolver,
                        Query luceneQuery = request.contextSetup.query.rewrite(context).toQuery(context);
            builder.endObject();
 * specific language governing permissions and limitations
            CheckedBiFunction<QueryShardContext, LeafReaderContext, Response, IOException> handler,
        protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {
            private final BytesReference document;
import org.opensearch.index.IndexService;
                throw new UnsupportedOperationException("unsupported script context name [" + name + "]");
        public ScriptContext<?> getContext() {
        static {
import java.util.HashMap;
                // TODO: is MANAGEMENT TP the right TP? Right now this is an admin api (see action name).
        Response(Object result) {
            Request request = (Request) o;
                Index[] concreteIndices = indexNameExpressionResolver.concreteIndices(clusterState, indicesOptions, indexExpression);
                        // Consume the first (and only) match.
import org.opensearch.transport.TransportService;
            @Override
        public Object getResult() {
            this.indicesServices = indicesServices;
                }, indexService);
                Index concreteIndex = concreteIndices[0];
        public int hashCode() {
            IndexService indexService
        ) {
        private static final ConstructingObjectParser<Request, Void> PARSER = new ConstructingObjectParser<>(
                    }
import org.opensearch.index.mapper.SourceToParse;
        public int hashCode() {
                query = in.readOptionalNamedWriteable(QueryBuilder.class);
            if (scriptContext == null) {
import org.opensearch.common.CheckedBiFunction;
import org.opensearch.core.ParseField;
            out.writeGenericValue(result);
            return channel -> client.executeLocally(INSTANCE, request, new RestToXContentListener<>(channel));
        }
import org.opensearch.indices.IndicesService;
/*
                }
 * GitHub history for details.
        }
            return request.contextSetup != null && request.contextSetup.getIndex() != null;
            } else if (scriptContext == FilterScript.CONTEXT) {
import static java.util.Arrays.asList;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                && Objects.equals(context, request.context)
            if (setup != null) {
                transportService,
            return contextSetup;
        }
            return Objects.hash(script, context, contextSetup);
        public abstract Object execute();
            }
    private static final String NAME = "cluster:admin/scripts/painless/execute";
        public Script getScript() {
            } else {
        @Override
                    FilterScript filterScript = leafFactory.newInstance(leafReaderContext);
                    && Objects.equals(mediaType, that.mediaType);
            }
                return builder;
                threadPool,
            if (o == null || getClass() != o.getClass()) return false;
                ContextSetup contextSetup = PARSER.parse(parser, null);
            return builder;
import org.opensearch.common.xcontent.XContentHelper;
                }, indexService);
                // Forking a thread here, because only light weight operations should happen on network thread and
                        int docID = scorer.iterator().nextDoc();
        }
import org.apache.lucene.index.IndexWriter;
            }
                IndicesOptions indicesOptions = IndicesOptions.strictSingleIndexNoExpandForbidClosed();
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.script.FilterScript;
            PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ContextSetup::parse, CONTEXT_SETUP_FIELD);
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(defaultAnalyzer))) {
            return validationException;
import org.apache.lucene.analysis.Analyzer;
 * not use this file except in compliance with the License.
                index(contextSetup.index);
import org.apache.lucene.search.Scorer;
        }
                    FilterScript.Factory factory = scriptService.compile(request.script, FilterScript.CONTEXT);
            return Response::new;
                    scoreScript.setDocument(0);
            return "Request{" + "script=" + script + "context=" + context + ", contextSetup=" + contextSetup + '}';
            }
            private static final ParseField DOCUMENT_FIELD = new ParseField("document");
                out.writeOptionalString(index);
                    filterScript.setDocument(0);
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("painless_test", Factory.class);
            public boolean equals(Object o) {
 */
                    boolean result = filterScript.execute();
            return Objects.equals(script, request.script)
            Map<String, ScriptContext<?>> supportedContexts = new HashMap<>();
                clusterService,
            contextSetup = in.readOptionalWriteable(ContextSetup::new);
        }
                    ScoreScript.LeafFactory leafFactory = factory.newFactory(
                if (o == null || getClass() != o.getClass()) return false;
                actionFilters,
            ActionFilters actionFilters,
                    + mediaType
    public static final PainlessExecuteAction INSTANCE = new PainlessExecuteAction();
import static org.opensearch.action.ValidateActions.addValidationError;
        @Override
                    try (IndexReader indexReader = DirectoryReader.open(indexWriter)) {
                        Scorer scorer = weight.scorer(indexSearcher.getIndexReader().leaves().get(0));
                            builder.generator().copyCurrentStructure(parser);
            static ContextSetup parse(XContentParser parser, Void context) throws IOException {
        static ScriptContext<?> fromScriptContextName(String name) {
        public boolean equals(Object o) {
                        final long absoluteStartMillis = System.currentTimeMillis();
        super(NAME, Response::new);
        private static final ParseField CONTEXT_SETUP_FIELD = new ParseField("context_setup");
import org.apache.lucene.search.IndexSearcher;
        }
                builder.endObject();
import org.apache.lucene.index.IndexWriterConfig;
            supportedContexts.put("score", ScoreScript.CONTEXT);
                                NamedXContentRegistry.EMPTY,
            this.script = Objects.requireNonNull(script);
import org.apache.lucene.store.ByteBuffersDirectory;
        }
                }, DOCUMENT_FIELD);
                    return new Response(result);
                return Objects.equals(index, that.index)
                        builder.field(DOCUMENT_FIELD.getPreferredName());
                    + query
            }
import org.opensearch.script.Script;
                        ) {
            @Override
            }
            builder.field("result", result);
                return "ContextSetup{"
        }
            }
                        final IndexSearcher searcher = new IndexSearcher(indexReader);
        }
                    }
            IndexService indexService;
            ScriptContext<?> scriptContext = SUPPORTED_CONTEXTS.get(name);
            }
        public interface Factory {
            script = new Script(in);
                    }
        }
                && Objects.equals(contextSetup, request.contextSetup);
import org.opensearch.core.common.io.stream.Writeable;
            this.result = result;
        public String getName() {
            if (needDocumentAndIndex(context)) {
                    SourceToParse sourceToParse = new SourceToParse(index, "_id", document, mediaType);
