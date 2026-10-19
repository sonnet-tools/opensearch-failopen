    public void initTask(BulkByScrollTask task, ReindexRequest request, ActionListener<Void> listener) {
            index.versionType(mainRequest.getDestination().versionType());
        this.threadPool = threadPool;
            this(task, logger, client, threadPool, scriptService, sslConfig, request, listener, Optional.empty());
                    builder.copyCurrentStructure(parser);  
            @Override
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;  
            Logger logger,  
                }
        ClusterService clusterService,
            private long asLong(Object from, String name) {
package org.opensearch.index.reindex;
import org.opensearch.action.bulk.BulkRequest;
        @Override  
            switch (routingSpec) {  
            if (mainRequest.getDestination().opType() == DocWriteRequest.OpType.CREATE) {  
 * compatible open source license.
            }  
             * to be pretty liberal with regards to types because script are often
 * KIND, either express or implied.  See the License for the
                    XContentParser parser = sourceMediaType.xContent()
            Logger logger,
                    assert false : "Failed to properly stop client thread [" + thread.getName() + "]";
                restInterceptor.ifPresent(interceptor -> c.addRequestInterceptorLast(interceptor));
            ) {
        int i = 0;
 */
import java.util.function.BiFunction;  
             * dynamically typed.
            ThreadPool threadPool,  
                requireNonNull(to, "Can't reindex without a destination index!");
            @Override
                super.copyRouting(request, routing);
                RestClient restClient = buildRestClient(remoteInfo, sslConfig, task.getId(), createdThreads, this.interceptor);
import org.opensearch.action.bulk.BackoffPolicy;  
 * The OpenSearch Contributors require contributions made to  
            String routingSpec = mainRequest.getDestination().routing();  
 * software distributed under the License is distributed on an
            }
     * @param restInterceptor an optional HttpRequestInterceptor
        }
                    getInterceptor(request)
                    mainRequest.getSearchRequest()  
            }
                BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();  
import org.opensearch.index.reindex.spi.RemoteReindexExtension;
                long l = fromNumber.longValue();  
        BulkByScrollParallelizationHelper.executeSlicedAction(
            return remoteExtension.map(x -> x.getInterceptorProvider())
        Optional<HttpRequestInterceptor> restInterceptor
import java.io.UncheckedIOException;
            }  
import org.opensearch.index.mapper.VersionFieldMapper;  
            if (index.versionType() == INTERNAL) {
        }).setHttpClientConfigCallback(c -> {
                Thread t = new Thread(r, name);
                try (
import static java.util.Objects.requireNonNull;
    ) {  
            c.setConnectTimeout(Timeout.ofMilliseconds(Math.toIntExact(remoteInfo.getConnectTimeout().millis())));
        }  
            task,
            ReindexRequest request,  
            ReindexSslConfig sslConfig,
                    InputStream stream = doc.getSource().streamInput();  
import java.util.Map;
            } else {
            return Optional.empty();
 * this file be licensed under the Apache-2.0 license or a
        ) {
            Optional<HttpRequestInterceptor> interceptor
     * Build the {@link RestClient} used for reindexing from remote clusters.
     * @param sslConfig configuration for potential outgoing HTTPS connections
            return remoteExtension.get().getRemoteReindexActionListener(listener, reindexRequest);
            final MediaType mainRequestMediaType = mainRequest.getDestination().getContentType();
        }  
        if (reindexRequest.getRemoteInfo() == null) {
                default:
    private ActionListener<BulkByScrollResponse> getRemoteReindexWrapperListener(  
                createdThreads = synchronizedList(new ArrayList<>());  
                return;  
                 */  
                    throw new IllegalArgumentException(name + " may only be set to an int or a long but was [" + from + "]");  
    Reindexer(
                ) {
public class Reindexer {
                    fromNumber = (Number) from;
     * Simple implementation of reindex using scrolling and bulk. There are tons
                index.version(doc.getVersion());  
import org.opensearch.core.common.bytes.BytesReference;
            Exception failure,
                false,
            final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                listener,
            );
                }
        }  
import org.opensearch.common.lucene.uid.Versions;
        return buildRestClient(remoteInfo, sslConfig, taskId, threadCollector, Optional.empty());  
            return super.buildScriptApplier();  
     * @param threadCollector a list in which we collect all the threads created by the client  
            BulkByScrollTask task,  
                    // Added prefix based logger(destination index) to distinguish multiple reindex jobs for easier debugging.
                c.setDefaultCredentialsProvider(credentialsProvider);
        AsyncIndexBySearchAction(
            index.setPipeline(mainRequest.getDestination().getPipeline());
}  
 *  
        ReindexSslConfig sslConfig,
            return new BulkRequest().pipeline(mainRequest.getDestination().getPipeline());
        }
 * SPDX-License-Identifier: Apache-2.0
         * {@link ThreadPool}s. But reindex-from-remote uses OpenSearch's {@link RestClient} which doesn't use the
    ) {  
            c.setThreadFactory(r -> {
            if (remoteInfo.getUsername() != null) {
                .setTlsStrategy(sslConfig.getStrategy())  
                    XContentBuilder builder = XContentBuilder.builder(mainRequestMediaType.xContent())  
            }
            index.routing(mainRequest.getDestination().routing());
                .build();
            return c;
        }
                    request,
            if (routingSpec == null) {
            ReindexAction.INSTANCE,  
         * {@linkplain ThreadPool}s because it uses httpasyncclient. It'd be a ton of trouble to work around creating those threads. So
                credentialsProvider.setCredentials(new AuthScope(httpHost, null, "Basic"), creds);
    ) {
                index.source(doc.getSource(), doc.getMediaType());  
        ThreadPool threadPool,
                 * external versioning.
                    logger.error("Failed to properly stop client thread [{}]", thread.getName());  
            index.id(doc.getId());
                    scriptService,  
        }  
import java.io.InputStream;
                return t;  
                request.setRouting(Objects.toString(to, null));
                assert sslConfig != null : "Reindex ssl config must be set";
                .flatMap(provider -> provider.getRestInterceptor(request, threadPool.getThreadContext()));
            index.index(mainRequest.getDestination().index());
 * ownership. Elasticsearch licenses this file to you under  
            // A little extra paranoia so we log something if we leave any threads running
                    task,
            // Limit ourselves to one reactor thread because for now the search process is single threaded.
             * Methods below here handle script updating the index request. They try  
            ScriptService scriptService,
        protected void copyRouting(RequestWrapper<?> request, String routing) {
            c.setConnectionManager(connectionManager);  
        if (request.getRemoteInfo() == null) {
                request.getDestination().versionType() != VersionType.INTERNAL,
import static java.util.Collections.synchronizedList;  
import org.opensearch.common.logging.Loggers;
        long taskId,  
                index.opType(mainRequest.getDestination().opType());
import java.io.IOException;  
             * Internal versioning can just use what we copied from the destination request. Otherwise we assume we're using external
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
            super(
                    super.copyRouting(request, null);
            }
import org.apache.hc.core5.http.HttpHost;
                Number fromNumber;  
                } else {  
        }  
import org.opensearch.action.DocWriteRequest;
                );
    static RestClient buildRestClient(RemoteInfo remoteInfo, ReindexSslConfig sslConfig, long taskId, List<Thread> threadCollector) {
                    Loggers.getLogger(Reindexer.class, String.valueOf(request.getDestination().index())),  
 */  
                } catch (IOException e) {
    /**  
                client,
                    remoteInfo.getPassword().toCharArray()
import java.util.List;
                );
 * You may obtain a copy of the License at  
            }  
                    throw new IllegalArgumentException("Unsupported routing command");
import org.opensearch.core.xcontent.MediaType;
                assert scriptService != null : "Script service must be set";  
                assert doc.getVersion() == -1 : "fetched version when we didn't have to";  
            ParentTaskAssigningClient client,
            }
            // Enable basic auth if it is configured  
 * specific language governing permissions and limitations
        protected RequestWrapper<IndexRequest> buildRequest(ScrollableHitSource.Hit doc) {  
            } else {  
import org.apache.logging.log4j.LogManager;  
                AsyncIndexBySearchAction searchAction = new AsyncIndexBySearchAction(  
                return;
            IndexRequest index = new IndexRequest();
                // we need to convert
    ) {  
                    request.setVersion(asLong(to, VersionFieldMapper.NAME));
            } else {
        @Override
import org.apache.hc.client5.http.auth.AuthScope;
            c.setResponseTimeout(Timeout.ofMilliseconds(Math.toIntExact(remoteInfo.getSocketTimeout().millis())));  
            super.finishHim(failure, indexingFailures, searchFailures, timedOut);
            ReindexScriptApplier(
            return c;
                searchAction.start();  
        BulkByScrollParallelizationHelper.initTaskState(task, request, client, listener);  
            protected void scriptChangedIndex(RequestWrapper<?> request, Object to) {  
import org.opensearch.client.RestClientBuilder;
            return listener;
        }
        if (remoteExtension.isPresent()) {
     * of optimizations that can be done on certain types of reindex requests
 * GitHub history for details.
                );
                request,  
     * but this makes no attempt to do any of them so it can be as simple  
import org.apache.hc.core5.util.Timeout;
        ) {  
import org.apache.logging.log4j.Logger;
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ReindexSslConfig reindexSslConfig,  
        ReindexRequest reindexRequest
                    remoteReindexActionListener,  
            return wrap(index);
import org.opensearch.index.VersionType;
        RemoteInfo remoteInfo,
         */  
import org.opensearch.script.ScriptService;
            }  
                 * Stuffing a number into the map will have converted it to  
            ReindexRequest request,
import org.opensearch.core.xcontent.XContentBuilder;  
    private Optional<HttpRequestInterceptor> getInterceptor(ReindexRequest request) {  
                    this::onScrollResponse,
            }
            ParentTaskAssigningClient client,
        ActionListener<BulkByScrollResponse> remoteReindexActionListener = getRemoteReindexWrapperListener(listener, request);
        Client client,  
                    logger,
        ThreadPool threadPool,  
        @Override
import org.opensearch.cluster.service.ClusterService;  
        ) {  
            clusterService.localNode(),  
            // id and source always come from the found doc. Scripts can change them but they operate on the index request.  
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.hc.core5.http.message.BasicHeader;  
                    request.setVersion(Versions.MATCH_ANY);
        /**
                logger,  
                    parser.nextToken();
            /*  
            BulkByScrollTask task,
        Optional<RemoteReindexExtension> remoteExtension
import java.util.ArrayList;  
    private final ReindexSslConfig reindexSslConfig;  
                return l;
        protected BulkRequest buildBulkRequest() {
/*
                 * We only need the source version if we're going to use it when write and we only do that when the destination request uses
    static class AsyncIndexBySearchAction extends AbstractAsyncBulkByScrollAction<ReindexRequest, TransportReindexAction> {  
        }  
import org.opensearch.core.xcontent.DeprecationHandler;  
    }
             * here on out operates on the index request rather than the template.
                    break;  
        AsyncIndexBySearchAction(
    }  
            final MediaType sourceMediaType = doc.getMediaType();
import org.apache.hc.core5.http.Header;  
     */
 * this work for additional information regarding copyright
                    remoteInfo.getUsername(),  
import org.apache.hc.core5.http.HttpRequestInterceptor;
                    request.setVersionType(INTERNAL);
 *
import org.apache.hc.core5.reactor.IOReactorConfig;
     * possible.
                } catch (ClassCastException e) {  
                ParentTaskAssigningClient assigningClient = new ParentTaskAssigningClient(client, clusterService.localNode(), task);
                RemoteInfo remoteInfo = mainRequest.getRemoteInfo();
 * the Apache License, Version 2.0 (the "License"); you may
                /*
        final HttpHost httpHost = new HttpHost(remoteInfo.getScheme(), remoteInfo.getHost(), remoteInfo.getPort());  
        protected ScrollableHitSource buildScrollableResultSource(BackoffPolicy backoffPolicy) {  
        logger.info("No extension found for remote reindex listener");
    }
         * Override the simple copy behavior to allow more fine grained control.
import org.opensearch.client.RestClient;
        final RestClientBuilder builder = RestClient.builder(httpHost).setDefaultHeaders(clientHeaders).setRequestConfigCallback(c -> {
                Map<String, Object> params  
        return listener;
            if (mainRequest.getRemoteInfo() != null) {
            if (routingSpec.startsWith("=")) {
    static RestClient buildRestClient(  
                if (fromNumber.doubleValue() != l) {
    }
/*  
            () -> {
            ScriptService scriptService,  
                 * */
            }
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
                super(taskWorker, scriptService, script, params);
                case "discard":
        ScriptService scriptService,
     *
import org.opensearch.action.index.IndexRequest;  
    private static final Logger logger = LogManager.getLogger(Reindexer.class);  
            // Copy the index from the request so we always write where it asked to write  
        }
                    index.source(BytesReference.bytes(builder), builder.contentType());
        private List<Thread> createdThreads = emptyList();
            }
                super.copyRouting(request, mainRequest.getDestination().routing().substring(1));  
        if (Strings.hasLength(remoteInfo.getPathPrefix()) && "/".equals(remoteInfo.getPathPrefix()) == false) {  
                request.setIndex(to.toString());
    private final ScriptService scriptService;
                UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
            /*  
                Script script,
    /**  
    private final Optional<RemoteReindexExtension> remoteExtension;
            protected void scriptChangedVersion(RequestWrapper<?> request, Object to) {
        this.clusterService = clusterService;  
             */  
         * instead we let it create threads but we watch them carefully and assert that they are dead when the process is over.  
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
        for (Map.Entry<String, String> header : remoteInfo.getHeaders().entrySet()) {  
        this.scriptService = scriptService;  
                /*  
        public BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> buildScriptApplier() {  
import java.util.Optional;
            /*
/*  
                    threadPool,
 * not use this file except in compliance with the License.
 */  
        ClusterService clusterService,
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.script.Script;  
            }
import org.opensearch.transport.client.Client;  
        this.client = client;
                task,
    }
import org.opensearch.action.bulk.BulkItemResponse;
                index.version(mainRequest.getDestination().version());
        ReindexSslConfig reindexSslConfig
            }
        this.remoteExtension = remoteExtension;
    private final Client client;  
            builder.setPathPrefix(remoteInfo.getPathPrefix());
    Reindexer(  
        }
import org.opensearch.threadpool.ThreadPool;
            List<ScrollableHitSource.SearchFailure> searchFailures,
            }  
import static org.opensearch.index.VersionType.INTERNAL;
    }
         * List of threads created by this process. Usually actions don't create threads in OpenSearch. Instead they use the builtin  
                threadPool,
        Client client,
    }
    private final ClusterService clusterService;
                    this::finishHim,  
                ScriptService scriptService,
import org.opensearch.index.reindex.remote.RemoteScrollableHitSource;
         */
 * license agreements. See the NOTICE file distributed with
                interceptor
             * The rest of the index request just has to be copied from the template. It may be changed later from scripts or the superclass
        protected void finishHim(
                }
                        .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, stream);
                }
    }  
 * under the License.  
 *
            // the source xcontent type and destination could be different  
                return new Reindexer.AsyncIndexBySearchAction.ReindexScriptApplier(worker, scriptService, script, script.getParams());
                    reindexSslConfig,
            if (mainRequestMediaType != null && doc.getMediaType() != mainRequestMediaType) {  
            ThreadPool threadPool,
import java.util.Objects;  
import org.opensearch.core.action.ActionListener;  
             * versioning and use the doc's version.
             */  
            protected void scriptChangedRouting(RequestWrapper<?> request, Object to) {  
        @Override
        } else {  
                    throw new UncheckedIOException("failed to convert hit from " + sourceMediaType + " to " + mainRequestMediaType, e);  
            listener,
                // Check that we didn't round when we fetched the value.
                scriptService,
                String name = "es-client-" + taskId + "-" + threads.getAndIncrement();  
        ScriptService scriptService,
                    break;  
            clientHeaders[i++] = new BasicHeader(header.getKey(), header.getValue());
                    throw new IllegalArgumentException(name + " may only be set to an int or a long but was [" + from + "]", e);
             */  
                    super.copyRouting(request, routing);
        );
            @Override
            clusterService.state().metadata(),  
                if (thread.isAlive()) {
        /**
            Script script = mainRequest.getScript();
                    worker::countSearchRetry,
            }
            ActionListener<BulkByScrollResponse> listener  
        Header[] clientHeaders = new Header[remoteInfo.getHeaders().size()];
            @Override
        List<Thread> threadCollector,
                    assigningClient,
                sslConfig,  
        return builder.build();  
            if (script != null) {
     * @param remoteInfo connection information for the remote cluster  
 * Unless required by applicable law or agreed to in writing,
        this.reindexSslConfig = reindexSslConfig;
import org.opensearch.core.common.Strings;
                    remoteInfo.getQuery(),
            AtomicInteger threads = new AtomicInteger();
        ActionListener<BulkByScrollResponse> listener,
import org.opensearch.transport.client.ParentTaskAssigningClient;
    public void execute(BulkByScrollTask task, ReindexRequest request, ActionListener<BulkByScrollResponse> listener) {  
                    backoffPolicy,
                case "keep":
                WorkerBulkByScrollTaskState taskWorker,  
        });
            boolean timedOut
            request,
        }
                    restClient,
                request.setId(Objects.toString(to, null));
 * Modifications Copyright OpenSearch Contributors. See
            protected void scriptChangedId(RequestWrapper<?> request, Object to) {  
     */
                try {
            client,
            });
     * @param taskId the id of the current task. This is added to the thread name for easier tracking
            ActionListener<BulkByScrollResponse> listener,
            // Stick the task id in the thread name so we can track down tasks from stack traces  
            for (Thread thread : createdThreads) {  
                 * some Number.
                }
                    threadPool,  
    }
        this(clusterService, client, threadPool, scriptService, reindexSslConfig, Optional.empty());
 * Licensed to Elasticsearch under one or more contributor  
                threadCollector.add(t);
        class ReindexScriptApplier extends ScriptApplier {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            c.setIOReactorConfig(IOReactorConfig.custom().setIoThreadCount(1).build());  
            return super.buildScrollableResultSource(backoffPolicy);  
                return new RemoteScrollableHitSource(  
            List<BulkItemResponse.Failure> indexingFailures,  
        @Override  
import static java.util.Collections.emptyList;
                if (to == null) {  
            }
        @Override
    private final ThreadPool threadPool;
            ReindexSslConfig sslConfig,
import org.opensearch.core.xcontent.NamedXContentRegistry;
