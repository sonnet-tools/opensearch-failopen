 *  
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;
            }
        public void writeTo(StreamOutput out) throws IOException {
        protected ClusterBlockException checkRequestBlock(ClusterState state, InternalRequest request) {
            return scriptContext == FilterScript.CONTEXT || scriptContext == ScoreScript.CONTEXT;  
                PainlessTestScript.Factory factory = scriptService.compile(request.script, PainlessTestScript.CONTEXT);
                }
            this.params = params;
        }
        private static Response prepareRamIndex(  
                    BytesReference document = request.contextSetup.document;
            return Objects.hash(result);
        @Override  
                        context.lookup(),
            return result;
                this.mediaType = mediaType;
        @Override
 * under the License.  
            PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), CONTEXT_FIELD);  
import org.opensearch.rest.action.RestToXContentListener;  
import org.apache.lucene.search.Query;
                    if (document != null) {  
import org.opensearch.script.Script;  
 */  
                }, indexService);
        }  
            public void setXContentType(MediaType mediaType) {
                    return new Response(result);  
                String mediaType = in.readOptionalString();
 */
            ThreadPool threadPool,  
            private final QueryBuilder query;
        static {  
import org.opensearch.core.xcontent.MediaType;
        public int hashCode() {
                        IndexSearcher indexSearcher = new IndexSearcher(leafReaderContext.reader());  
                }
        protected Response shardOperation(Request request, ShardId shardId) throws IOException {
                                mediaType
        public void writeTo(StreamOutput out) throws IOException {
            public boolean equals(Object o) {  
                    scoreScript.setDocument(0);
            ActionFilters actionFilters,
            IndexNameExpressionResolver indexNameExpressionResolver,  
            script = new Script(in);
            }  
                    + ", document="
        public ActionRequestValidationException validate() {
                    + ", xContentType="  
            }
        @Override
 * Licensed to Elasticsearch under one or more contributor  
            public MediaType getXContentType() {  
        public boolean equals(Object o) {
import static org.opensearch.rest.RestRequest.Method.GET;  
            PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> Script.parse(p), SCRIPT_FIELD);
            if (this == o) return true;
import org.opensearch.core.common.io.stream.StreamOutput;
 * not use this file except in compliance with the License.
        private final IndicesService indicesServices;
                IndicesOptions indicesOptions = IndicesOptions.strictSingleIndexNoExpandForbidClosed();
            if (setup != null) {
            supportedContexts.put("score", ScoreScript.CONTEXT);
 * Modifications Copyright OpenSearch Contributors. See  
        @Override  
        }  
        private static final ParseField CONTEXT_SETUP_FIELD = new ParseField("context_setup");
            return script;
    public static class RestAction extends BaseRestHandler {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public abstract static class PainlessTestScript {  
            }
        @Override  
            static ContextSetup parse(XContentParser parser, Void context) throws IOException {
    }  
        }  
            return Objects.hash(script, context, contextSetup);  
                        final IndexSearcher searcher = new IndexSearcher(indexReader);
            @Override
import static org.opensearch.rest.RestRequest.Method.POST;
            if (o == null || getClass() != o.getClass()) return false;
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("painless_test", Factory.class);
                            XContentParser parser = XContentHelper.createParser(  
            } else {
            super(in);
                        Weight weight = indexSearcher.createWeight(luceneQuery, ScoreMode.COMPLETE, 1f);
                // TODO: is MANAGEMENT TP the right TP? Right now this is an admin api (see action name).
        public abstract Object execute();
import static java.util.Arrays.asList;  
                    QUERY_FIELD
        static ScriptContext<?> fromScriptContextName(String name) {
            );
            return state.routingTable().index(request.concreteIndex()).randomAllActiveShardsIt();  
                        try (
            public String toString() {  
        public boolean equals(Object o) {
                this.query = query;
                    validationException = addValidationError("index is a required parameter for current context", validationException);  
            }
import java.util.List;
            );  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                String result = Objects.toString(painlessTestScript.execute());  
import org.apache.lucene.index.IndexWriterConfig;
import java.util.Objects;
            if (request.concreteIndex() == null) {  
import org.apache.lucene.store.Directory;  
            }  
                        builder.field(DOCUMENT_FIELD.getPreferredName());
                );
            IndexService indexService;
        static Request parse(XContentParser parser) throws IOException {  
                document = in.readOptionalBytesReference();
                    try (XContentBuilder b = XContentBuilder.builder(p.contentType().xContent())) {
                    boolean result = filterScript.execute();
                    && Objects.equals(document, that.document)
            out.writeString(context.name);
import org.opensearch.indices.IndicesService;  
import org.opensearch.action.ActionType;
import org.opensearch.index.IndexService;  
                builder.startObject();
        static class ContextSetup implements Writeable, ToXContentObject {
            return scriptContext;
        private static final ParseField CONTEXT_FIELD = new ParseField("context");  
import org.apache.lucene.search.Weight;
import org.opensearch.index.query.AbstractQueryBuilder;  
            return unmodifiableList(asList(new Route(GET, "/_scripts/painless/_execute"), new Route(POST, "/_scripts/painless/_execute")));
        }  
            } else if (scriptContext == FilterScript.CONTEXT) {
            Analyzer defaultAnalyzer = indexService.getIndexAnalyzers().getDefaultIndexAnalyzer();  
            context = fromScriptContextName(in.readString());  
                        ) {  
        }
                throw new UnsupportedOperationException("unsupported script context name [" + name + "]");
import org.opensearch.core.index.Index;
            }  
                if (contextSetup.document == null) {
                out.writeOptionalBytesReference(document);  
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.core.common.io.stream.StreamInput;
                args -> new ContextSetup((String) args[0], (BytesReference) args[1], (QueryBuilder) args[2])
            }  
            }  
                    (p, c) -> AbstractQueryBuilder.parseInnerQueryBuilder(p),  
            private static final ConstructingObjectParser<ContextSetup, Void> PARSER = new ConstructingObjectParser<>(  
import org.apache.lucene.analysis.Analyzer;  
                this.index = index;  
                builder.field(CONTEXT_SETUP_FIELD.getPreferredName(), contextSetup);  
            out.writeOptionalWriteable(contextSetup);
 *
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
import org.opensearch.rest.BaseRestHandler;
                }, DOCUMENT_FIELD);  
                    indexWriter.addDocuments(parsedDocument.docs());  
                return builder;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionRequestValidationException;
            out.writeGenericValue(result);  
                this.document = document;
            return validationException;  
                    + '\''
        public Script getScript() {
                index = in.readOptionalString();  
            } else {
        private final ContextSetup contextSetup;
                return Objects.hash(index, document, query, mediaType);  
                return index;
            this.indicesServices = indicesServices;
 * ownership. Elasticsearch licenses this file to you under  
            }
        @Override
        /** Return the parameters for this script. */
                    if (request.contextSetup.query != null) {
            this.result = result;
                    }
            return params;
        }
 * SPDX-License-Identifier: Apache-2.0
                "execute_script_context",
                ThreadPool.Names.MANAGEMENT
import org.apache.lucene.index.IndexWriter;  
import org.opensearch.index.query.QueryBuilder;
                {
        }
import org.opensearch.core.action.ActionResponse;
        }
                return mediaType;
        protected boolean resolveIndex(Request request) {  
                        assert docID == scorer.docID();  
        }
                    FilterScript.Factory factory = scriptService.compile(request.script, FilterScript.CONTEXT);
                query = in.readOptionalNamedWriteable(QueryBuilder.class);  
import org.opensearch.index.mapper.SourceToParse;
            contextSetup = in.readOptionalWriteable(ContextSetup::new);
            result = in.readGenericValue();  
            return builder.endObject();
                    SourceToParse sourceToParse = new SourceToParse(index, "_id", document, mediaType);
                    + query
        private Object result;
            return "_scripts_painless_execute";
            return contextSetup;
    public static class TransportAction extends TransportSingleShardAction<Request, Response> {
                }
        Response(StreamInput in) throws IOException {
            script.writeTo(out);  
                && Objects.equals(context, request.context)  
                    String index = indexService.index().getName();
                && Objects.equals(contextSetup, request.contextSetup);
        }
        @Override  
            PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), ContextSetup::parse, CONTEXT_SETUP_FIELD);
                out.writeOptionalNamedWriteable(query);
            this.scriptService = scriptService;  
        ) throws IOException {
                ClusterState clusterState = clusterService.state();
                transportService,  
                contextSetup.setXContentType(parser.contentType());
                builder.endObject();
                        int docID = scorer.iterator().nextDoc();
            ScriptService scriptService,
        }
import org.opensearch.core.common.bytes.BytesReference;  
                    + '}';
                threadPool,
            supportedContexts.put("painless_test", PainlessTestScript.CONTEXT);
import org.opensearch.core.index.shard.ShardId;
            public int hashCode() {
        }
                Request::new,  
                    ParsedDocument parsedDocument = indexService.mapperService().documentMapper().parse(sourceToParse);
                if (this == o) return true;
                }
                            )
                            builder.generator().copyCurrentStructure(parser);
        }
import org.opensearch.script.ScoreScript;
            Map<String, ScriptContext<?>> supportedContexts = new HashMap<>();
                    double result = scoreScript.execute(null);
            }  
                Index concreteIndex = concreteIndices[0];
import org.apache.lucene.search.Scorer;  
            }
            TransportService transportService,
            "painless_execute_request",  
            public QueryBuilder getQuery() {
            ContextSetup(String index, BytesReference document, QueryBuilder query) {
            }  
            final ScriptContext<?> scriptContext = request.context;
            private MediaType mediaType;  
            static {
import org.opensearch.script.ScriptType;  
            }  
            }
                String indexExpression = request.contextSetup.index;  
                    this.mediaType = MediaType.fromMediaType(mediaType);
        public String getName() {  
import org.opensearch.script.ScriptService;
    public static class Response extends ActionResponse implements ToXContentObject {
                    ScoreScript.Factory factory = scriptService.compile(request.script, ScoreScript.CONTEXT);
    private static final String NAME = "cluster:admin/scripts/painless/execute";  
                PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> {
                    validationException = addValidationError("document is a required parameter for current context", validationException);  
                        builder.field(QUERY_FIELD.getPreferredName(), query);
    public static class Request extends SingleShardRequest<Request> implements ToXContentObject {  
                    FilterScript filterScript = leafFactory.newInstance(leafReaderContext);  
                ContextSetup contextSetup = PARSER.parse(parser, null);  
                // Creating a in-memory index is not light weight
        protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {
import java.util.Collections;  
                        Query luceneQuery = request.contextSetup.query.rewrite(context).toQuery(context);
            }
        @Override  
                    }
            try (Directory directory = new ByteBuffersDirectory()) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(defaultAnalyzer))) {  
            return null;
}
import org.apache.lucene.search.IndexSearcher;  
        }
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                Index[] concreteIndices = indexNameExpressionResolver.concreteIndices(clusterState, indicesOptions, indexExpression);
/*  
                indexService = indicesServices.indexServiceSafe(concreteIndex);  
            if (this == o) return true;  
    }  
public class PainlessExecuteAction extends ActionType<PainlessExecuteAction.Response> {  
        }
        private final Map<String, Object> params;
        }
        }
import org.opensearch.script.FilterScript;
            }  
            this.script = Objects.requireNonNull(script);
            PainlessTestScript newInstance(Map<String, Object> params);
        }  
import org.opensearch.rest.RestRequest;
                        searcher.setQueryCache(null);  
                return "ContextSetup{"
            builder.field(SCRIPT_FIELD.getPreferredName(), script);  
        }
/*
            if (scriptContext == null) {
        public ContextSetup getContextSetup() {  
import java.io.IOException;
import org.apache.lucene.store.ByteBuffersDirectory;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + index  
                return contextSetup;
            if (scriptContext == PainlessTestScript.CONTEXT) {  
                PARSER.declareObject(
                    }  
        }
package org.opensearch.painless.action;
            public void writeTo(StreamOutput out) throws IOException {
                out.writeOptionalString(index);
        @Inject
                ContextSetup that = (ContextSetup) o;  
 * compatible open source license.
            @Override  
            ScriptContext<?> scriptContext = SUPPORTED_CONTEXTS.get(name);  
 * Unless required by applicable law or agreed to in writing,
        static boolean needDocumentAndIndex(ScriptContext<?> scriptContext) {
import org.opensearch.core.ParseField;
                    if (index != null) {  
        public interface Factory {  
                validationException = addValidationError("only inline scripts are supported", validationException);
                    FilterScript.LeafFactory leafFactory = factory.newFactory(request.getScript().getParams(), context.lookup());
        // For testing only:
        protected ShardsIterator shards(ClusterState state, InternalRequest request) {
            if (request.concreteIndex() != null) {
    public static final PainlessExecuteAction INSTANCE = new PainlessExecuteAction();
            return Objects.equals(result, response.result);  
                        Scorer scorer = weight.scorer(indexSearcher.getIndexReader().leaves().get(0));  
        @Override
 * software distributed under the License is distributed on an
                        // Consume the first (and only) match.
                throw new UnsupportedOperationException("unsupported context [" + scriptContext.name + "]");
                    ScoreScript scoreScript = leafFactory.newInstance(leafReaderContext);
            builder.field("result", result);  
        }
            return Objects.equals(script, request.script)
            return Response::new;  
        private final Script script;
            return channel -> client.executeLocally(INSTANCE, request, new RestToXContentListener<>(channel));
                    return new Response(result);
                    try (IndexReader indexReader = DirectoryReader.open(indexWriter)) {
            private final String index;
import org.apache.lucene.index.DirectoryReader;
 * this work for additional information regarding copyright
                    && Objects.equals(mediaType, that.mediaType);
            private static final ParseField INDEX_FIELD = new ParseField("index");  
import org.opensearch.common.inject.Inject;
 * specific language governing permissions and limitations
import org.opensearch.cluster.ClusterState;
                return new Response(result);
import org.apache.lucene.index.IndexReader;
            Response response = (Response) o;
        private static final ParseField SCRIPT_FIELD = new ParseField("script");
        @Override  
                        b.copyCurrentStructure(p);  
            } else {
        Request(Script script, String scriptContextName, ContextSetup setup) {
                // Forking a thread here, because only light weight operations should happen on network thread and  
        @Override
        @Override
        private final ScriptContext<?> context;  
 * the Apache License, Version 2.0 (the "License"); you may
                }, indexService);  
                if (mediaType != null) {  
            @Override
        }
            SUPPORTED_CONTEXTS = Collections.unmodifiableMap(supportedContexts);
                return prepareRamIndex(request, (context, leafReaderContext) -> {  
            return PARSER.parse(parser, null);
                    MediaType mediaType = request.contextSetup.mediaType;  
                        final long absoluteStartMillis = System.currentTimeMillis();
            super(
                        luceneQuery = indexSearcher.rewrite(luceneQuery);
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.action.support.ActionFilters;  
            if (o == null || getClass() != o.getClass()) return false;  
        public int hashCode() {
                    + ", index='"
                                document,  
                    && Objects.equals(query, that.query)  
import org.opensearch.core.xcontent.ToXContentObject;  
                    }
        static {
                }
                }
        }
            super.writeTo(out);
                return prepareRamIndex(request, (context, leafReaderContext) -> {  
                index(contextSetup.index);  
        }
        ) {
import org.opensearch.action.support.single.shard.TransportSingleShardAction;  
            if (needDocumentAndIndex(context)) {
        }
    }
import org.opensearch.transport.client.node.NodeClient;  
                if (contextSetup.index == null) {
    }
        }
        Response(Object result) {  
            IndicesService indicesServices  
            }  
        @Override  
import org.opensearch.threadpool.ThreadPool;
 */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.NamedXContentRegistry;
            @Override
                    filterScript.setDocument(0);
            ContextSetup(StreamInput in) throws IOException {
        }  
        @Override  
            return context;  
        @Override
                                LoggingDeprecationHandler.INSTANCE,
                    + document  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
import org.opensearch.transport.TransportService;
        private final ScriptService scriptService;
import org.apache.lucene.search.ScoreMode;
        }
            private static final ParseField DOCUMENT_FIELD = new ParseField("document");
            this.context = scriptContextName != null ? fromScriptContextName(scriptContextName) : PainlessTestScript.CONTEXT;  
                    ConstructingObjectParser.optionalConstructorArg(),
                return super.checkRequestBlock(state, request);  
        protected Writeable.Reader<Response> getResponseReader() {
            public String getIndex() {  
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.ShardsIterator;
/*
                                NamedXContentRegistry.EMPTY,
        Request(StreamInput in) throws IOException {  
            supportedContexts.put("filter", FilterScript.CONTEXT);  
        super(NAME, Response::new);  
        }  
        public ScriptContext<?> getContext() {
 * The OpenSearch Contributors require contributions made to  
                        QueryShardContext context = indexService.newQueryShardContext(0, searcher, () -> absoluteStartMillis, null);
        }
                    if (query != null) {
                        scoreScript.setScorer(scorer);
            IndexService indexService  
    }
                    + ", query="
            public BytesReference getDocument() {
            CheckedBiFunction<QueryShardContext, LeafReaderContext, Response, IOException> handler,
                contextSetup = null;
            builder.startObject();
                PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), INDEX_FIELD);  
                if (o == null || getClass() != o.getClass()) return false;
        public Map<String, Object> getParams() {  
            builder.startObject();
            return "Request{" + "script=" + script + "context=" + context + ", contextSetup=" + contextSetup + '}';
import java.util.Map;  
        }
                NAME,  
            }  
        static final Map<String, ScriptContext<?>> SUPPORTED_CONTEXTS;
            }
                if (concreteIndices.length != 1) {
        public TransportAction(
            args -> new Request((Script) args[0], (String) args[1], (ContextSetup) args[2])
                        request.getScript().getParams(),  
        }
    }  
            }
                out.writeOptionalString(mediaType != null ? mediaType.mediaTypeWithoutParameters() : null);
import org.opensearch.index.query.QueryShardContext;
        public String toString() {
            ActionRequestValidationException validationException = null;  
import org.opensearch.common.CheckedBiFunction;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.field(CONTEXT_FIELD.getPreferredName(), context.name);
            final Request request = Request.parse(restRequest.contentOrSourceParamParser());  
                    );  
            Request request = (Request) o;
                        return handler.apply(context, indexReader.leaves().get(0));  
        }  
        public static final String[] PARAMETERS = {};  
            @Override
            builder.endObject();
        @Override
                    + mediaType
                        builder.field(INDEX_FIELD.getPreferredName(), index);
                        return BytesReference.bytes(b);
    private PainlessExecuteAction() {
                    ScoreScript.LeafFactory leafFactory = factory.newFactory(
import org.opensearch.action.support.IndicesOptions;
        @Override
            return request.contextSetup != null && request.contextSetup.getIndex() != null;
 *
import org.apache.lucene.index.LeafReaderContext;
                PainlessTestScript painlessTestScript = factory.newInstance(request.script.getParams());
            if (script.getType() != ScriptType.INLINE) {
        }  
import org.opensearch.script.ScriptContext;
        @Override  
                    }  
        }
            if (request.contextSetup != null && request.contextSetup.getIndex() != null) {  
                        context.searcher()
            super(in);
        static Response innerShardOperation(Request request, ScriptService scriptService, IndexService indexService) throws IOException {
                indexService = null;
                indexNameExpressionResolver,
import static org.opensearch.action.ValidateActions.addValidationError;
                return document;
            ClusterService clusterService,
                actionFilters,
import org.opensearch.index.mapper.ParsedDocument;
        );
        }
            private final BytesReference document;  
            } else if (scriptContext == ScoreScript.CONTEXT) {
                        }
import org.opensearch.action.support.single.shard.SingleShardRequest;
                    }
        public Object getResult() {  
            }  
                return query;  
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.common.xcontent.XContentHelper;  
            return builder;  
            private static final ParseField QUERY_FIELD = new ParseField("query");
        public PainlessTestScript(Map<String, Object> params) {
                    throw new IllegalArgumentException("[" + indexExpression + "] does not resolve to a single index");  
        private static final ConstructingObjectParser<Request, Void> PARSER = new ConstructingObjectParser<>(
                return Objects.equals(index, that.index)
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.xcontent.XContentBuilder;
import static java.util.Collections.unmodifiableList;
                clusterService,
            if (contextSetup != null) {
            return innerShardOperation(request, scriptService, indexService);
                return null;
            Request request,
                this.contextSetup = setup;
        public List<Route> routes() {
