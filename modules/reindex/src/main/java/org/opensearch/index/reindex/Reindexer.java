            ActionListener<BulkByScrollResponse> listener
            ReindexSslConfig sslConfig,
 * this file be licensed under the Apache-2.0 license or a
                 * */
        Optional<RemoteReindexExtension> remoteExtension
        for (Map.Entry<String, String> header : remoteInfo.getHeaders().entrySet()) {
            clusterService.state().metadata(),
    private final ScriptService scriptService;
            return remoteExtension.map(x -> x.getInterceptorProvider())
import org.opensearch.threadpool.ThreadPool;
    ) {
                assert scriptService != null : "Script service must be set";
        }
         * instead we let it create threads but we watch them carefully and assert that they are dead when the process is over.
                client,
import java.util.function.BiFunction;
                String name = "es-client-" + taskId + "-" + threads.getAndIncrement();
            }
 * not use this file except in compliance with the License.
                } catch (IOException e) {
            if (index.versionType() == INTERNAL) {
                 * We only need the source version if we're going to use it when write and we only do that when the destination request uses
            index.versionType(mainRequest.getDestination().versionType());
             * to be pretty liberal with regards to types because script are often
     * @param sslConfig configuration for potential outgoing HTTPS connections
                .flatMap(provider -> provider.getRestInterceptor(request, threadPool.getThreadContext()));
             * versioning and use the doc's version.
                );
                c.setDefaultCredentialsProvider(credentialsProvider);
     * @param threadCollector a list in which we collect all the threads created by the client
                Number fromNumber;
            }
                    mainRequest.getSearchRequest()
                    throw new IllegalArgumentException(name + " may only be set to an int or a long but was [" + from + "]", e);
            } else {
             */
     */
        return listener;
                }
            String routingSpec = mainRequest.getDestination().routing();
                super.copyRouting(request, routing);
                    logger.error("Failed to properly stop client thread [{}]", thread.getName());
 * compatible open source license.
 * under the License.
import org.apache.hc.core5.http.HttpHost;
            ParentTaskAssigningClient client,
                ) {
    private ActionListener<BulkByScrollResponse> getRemoteReindexWrapperListener(
import java.util.concurrent.atomic.AtomicInteger;
            if (remoteInfo.getUsername() != null) {
            if (mainRequest.getRemoteInfo() != null) {
                try {
import org.opensearch.client.RestClientBuilder;
            }
            builder.setPathPrefix(remoteInfo.getPathPrefix());
         */
            // Enable basic auth if it is configured
        }
            task,
            /*
                    // Added prefix based logger(destination index) to distinguish multiple reindex jobs for easier debugging.
    }
import java.util.Objects;
            Script script = mainRequest.getScript();
import org.opensearch.core.xcontent.DeprecationHandler;
import org.opensearch.core.common.bytes.BytesReference;
        if (Strings.hasLength(remoteInfo.getPathPrefix()) && "/".equals(remoteInfo.getPathPrefix()) == false) {
import java.util.List;
                if (thread.isAlive()) {
        }).setHttpClientConfigCallback(c -> {
            /*
                    threadPool,
 * GitHub history for details.
        ThreadPool threadPool,
        if (reindexRequest.getRemoteInfo() == null) {
        private List<Thread> createdThreads = emptyList();
            }
import org.apache.logging.log4j.LogManager;
            c.setThreadFactory(r -> {
            // the source xcontent type and destination could be different
        return builder.build();
    private final ClusterService clusterService;
            @Override
 * ownership. Elasticsearch licenses this file to you under
 *
            protected void scriptChangedRouting(RequestWrapper<?> request, Object to) {
    }
        );
import org.opensearch.transport.client.Client;
            ScriptService scriptService,
    }
import java.io.IOException;
        protected ScrollableHitSource buildScrollableResultSource(BackoffPolicy backoffPolicy) {
             * Methods below here handle script updating the index request. They try
            @Override
                RestClient restClient = buildRestClient(remoteInfo, sslConfig, task.getId(), createdThreads, this.interceptor);
        }
/*
        if (request.getRemoteInfo() == null) {
        return buildRestClient(remoteInfo, sslConfig, taskId, threadCollector, Optional.empty());
        protected void copyRouting(RequestWrapper<?> request, String routing) {
            }
                /*
                return new Reindexer.AsyncIndexBySearchAction.ReindexScriptApplier(worker, scriptService, script, script.getParams());
             * here on out operates on the index request rather than the template.
            if (mainRequestMediaType != null && doc.getMediaType() != mainRequestMediaType) {
                }
                RemoteInfo remoteInfo = mainRequest.getRemoteInfo();
    static class AsyncIndexBySearchAction extends AbstractAsyncBulkByScrollAction<ReindexRequest, TransportReindexAction> {
            if (script != null) {
            // Limit ourselves to one reactor thread because for now the search process is single threaded.
            ) {
import org.opensearch.action.index.IndexRequest;
 * The OpenSearch Contributors require contributions made to
                .build();
            ReindexRequest request,
            for (Thread thread : createdThreads) {
        int i = 0;
                    task,
import org.opensearch.common.lucene.uid.Versions;
            return Optional.empty();
        } else {
            ReindexSslConfig sslConfig,
            ThreadPool threadPool,
            }
public class Reindexer {
                    break;
                    InputStream stream = doc.getSource().streamInput();
        }
        this(clusterService, client, threadPool, scriptService, reindexSslConfig, Optional.empty());
import org.apache.logging.log4j.Logger;
                index.version(doc.getVersion());
                return t;
                request.setId(Objects.toString(to, null));
import java.util.ArrayList;
        protected BulkRequest buildBulkRequest() {
        }
            // Copy the index from the request so we always write where it asked to write
         * {@linkplain ThreadPool}s because it uses httpasyncclient. It'd be a ton of trouble to work around creating those threads. So
            return super.buildScrollableResultSource(backoffPolicy);
     *
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
                request,
            @Override
    ) {
        @Override
         */
            ThreadPool threadPool,
             * The rest of the index request just has to be copied from the template. It may be changed later from scripts or the superclass
            switch (routingSpec) {
import static java.util.Collections.emptyList;
         * List of threads created by this process. Usually actions don't create threads in OpenSearch. Instead they use the builtin
        ClusterService clusterService,
            // id and source always come from the found doc. Scripts can change them but they operate on the index request.
        BulkByScrollParallelizationHelper.initTaskState(task, request, client, listener);
        }
                if (to == null) {
                    restClient,
 *
 */
    static RestClient buildRestClient(
        }
                } catch (ClassCastException e) {
     * @param taskId the id of the current task. This is added to the thread name for easier tracking
            Logger logger,
            client,
        AsyncIndexBySearchAction(
                Thread t = new Thread(r, name);
            });
import java.io.InputStream;
import org.opensearch.common.logging.Loggers;
                default:
            private long asLong(Object from, String name) {
/*
        Client client,
        final HttpHost httpHost = new HttpHost(remoteInfo.getScheme(), remoteInfo.getHost(), remoteInfo.getPort());
                    getInterceptor(request)
            }
                request.setRouting(Objects.toString(to, null));
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
            } else {
            c.setResponseTimeout(Timeout.ofMilliseconds(Math.toIntExact(remoteInfo.getSocketTimeout().millis())));
            AtomicInteger threads = new AtomicInteger();
            // A little extra paranoia so we log something if we leave any threads running
                    remoteInfo.getUsername(),
import org.opensearch.cluster.service.ClusterService;
                requireNonNull(to, "Can't reindex without a destination index!");
                sslConfig,
    private static final Logger logger = LogManager.getLogger(Reindexer.class);
                 */
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import java.util.Optional;
            if (routingSpec == null) {
                    remoteInfo.getPassword().toCharArray()
     * @param restInterceptor an optional HttpRequestInterceptor
            return super.buildScriptApplier();
import org.opensearch.client.RestClient;
        this.client = client;
            final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
        ReindexRequest reindexRequest
    /**
    public void initTask(BulkByScrollTask task, ReindexRequest request, ActionListener<Void> listener) {
import static java.util.Collections.synchronizedList;
                credentialsProvider.setCredentials(new AuthScope(httpHost, null, "Basic"), creds);
            if (mainRequest.getDestination().opType() == DocWriteRequest.OpType.CREATE) {
        }
            request,
             */
                UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
    }
                logger,
            boolean timedOut
                    index.source(BytesReference.bytes(builder), builder.contentType());
package org.opensearch.index.reindex;
         * Override the simple copy behavior to allow more fine grained control.
import org.apache.hc.core5.http.message.BasicHeader;
            }
                Map<String, Object> params
                super.copyRouting(request, mainRequest.getDestination().routing().substring(1));
            ReindexAction.INSTANCE,
                 * some Number.
        BulkByScrollParallelizationHelper.executeSlicedAction(
                task,
                false,
        ActionListener<BulkByScrollResponse> remoteReindexActionListener = getRemoteReindexWrapperListener(listener, request);
            IndexRequest index = new IndexRequest();
            BulkByScrollTask task,
    }
        ScriptService scriptService,
                if (fromNumber.doubleValue() != l) {
            }
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.core.xcontent.XContentBuilder;
                    super.copyRouting(request, null);
import org.opensearch.action.DocWriteRequest;
                    assert false : "Failed to properly stop client thread [" + thread.getName() + "]";
                } else {
                    super.copyRouting(request, routing);
    private final ThreadPool threadPool;
            List<BulkItemResponse.Failure> indexingFailures,
                return;
                ScriptService scriptService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, stream);
                /*
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    this::finishHim,
             * Internal versioning can just use what we copied from the destination request. Otherwise we assume we're using external
            index.id(doc.getId());
    }
 * software distributed under the License is distributed on an
                    scriptService,
import org.opensearch.script.ScriptService;
            } else {
                assert doc.getVersion() == -1 : "fetched version when we didn't have to";
        this.scriptService = scriptService;
 * Licensed to Elasticsearch under one or more contributor
    private final Client client;
                    request.setVersionType(INTERNAL);
        }
                // Check that we didn't round when we fetched the value.
            }
                    remoteInfo.getQuery(),
import org.opensearch.index.reindex.spi.RemoteReindexExtension;
                    request,
     * possible.
     * @param remoteInfo connection information for the remote cluster
        ReindexSslConfig sslConfig,
            c.setConnectTimeout(Timeout.ofMilliseconds(Math.toIntExact(remoteInfo.getConnectTimeout().millis())));
                    worker::countSearchRetry,
        ) {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        @Override
            () -> {
import org.apache.hc.core5.http.Header;
                    XContentBuilder builder = XContentBuilder.builder(mainRequestMediaType.xContent())
                .setTlsStrategy(sslConfig.getStrategy())
import org.opensearch.core.common.Strings;
            ScriptService scriptService,
                    break;
        public BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> buildScriptApplier() {
        logger.info("No extension found for remote reindex listener");
        List<Thread> threadCollector,
     * Simple implementation of reindex using scrolling and bulk. There are tons
                    this::onScrollResponse,
                    throw new IllegalArgumentException(name + " may only be set to an int or a long but was [" + from + "]");
                    throw new UncheckedIOException("failed to convert hit from " + sourceMediaType + " to " + mainRequestMediaType, e);
            c.setConnectionManager(connectionManager);
            protected void scriptChangedId(RequestWrapper<?> request, Object to) {
        Optional<HttpRequestInterceptor> restInterceptor
                    Loggers.getLogger(Reindexer.class, String.valueOf(request.getDestination().index())),
 * specific language governing permissions and limitations
        long taskId,
        ScriptService scriptService,
 * Unless required by applicable law or agreed to in writing,
                restInterceptor.ifPresent(interceptor -> c.addRequestInterceptorLast(interceptor));
                }
                AsyncIndexBySearchAction searchAction = new AsyncIndexBySearchAction(
                );
    }
import static org.opensearch.index.VersionType.INTERNAL;
    static RestClient buildRestClient(RemoteInfo remoteInfo, ReindexSslConfig sslConfig, long taskId, List<Thread> threadCollector) {
        protected RequestWrapper<IndexRequest> buildRequest(ScrollableHitSource.Hit doc) {
        this.remoteExtension = remoteExtension;
        AsyncIndexBySearchAction(
    private final Optional<RemoteReindexExtension> remoteExtension;
             * dynamically typed.
import org.apache.hc.core5.reactor.IOReactorConfig;
                    remoteReindexActionListener,
 * Modifications Copyright OpenSearch Contributors. See
            protected void scriptChangedVersion(RequestWrapper<?> request, Object to) {
            Exception failure,
     * of optimizations that can be done on certain types of reindex requests
                case "discard":
            }
     * but this makes no attempt to do any of them so it can be as simple
            if (routingSpec.startsWith("=")) {
            }
                assert sslConfig != null : "Reindex ssl config must be set";
             */
        ActionListener<BulkByScrollResponse> listener,
                WorkerBulkByScrollTaskState taskWorker,
            @Override
                }
    ) {
            return new BulkRequest().pipeline(mainRequest.getDestination().getPipeline());
            return c;
        });
        }
    Reindexer(
                    assigningClient,
            Optional<HttpRequestInterceptor> interceptor
 * this work for additional information regarding copyright
                // we need to convert
                    logger,
                listener,
        protected void finishHim(
import static java.util.Objects.requireNonNull;
            super(
                );
            ActionListener<BulkByScrollResponse> listener,
 */
 */
        RemoteInfo remoteInfo,
        @Override
                super(taskWorker, scriptService, script, params);
                index.opType(mainRequest.getDestination().opType());
        this.reindexSslConfig = reindexSslConfig;
            super.finishHim(failure, indexingFailures, searchFailures, timedOut);
            }
import org.apache.hc.client5.http.auth.AuthScope;
                searchAction.start();
            clusterService.localNode(),
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
        if (remoteExtension.isPresent()) {
        ReindexSslConfig reindexSslConfig
    private Optional<HttpRequestInterceptor> getInterceptor(ReindexRequest request) {
        }
                    XContentParser parser = sourceMediaType.xContent()
 * the Apache License, Version 2.0 (the "License"); you may
    }
            return remoteExtension.get().getRemoteReindexActionListener(listener, reindexRequest);
        ThreadPool threadPool,
import java.io.UncheckedIOException;
import org.opensearch.action.bulk.BackoffPolicy;
                createdThreads = synchronizedList(new ArrayList<>());
            return wrap(index);
        class ReindexScriptApplier extends ScriptApplier {
            index.index(mainRequest.getDestination().index());
            index.routing(mainRequest.getDestination().routing());
                request.setIndex(to.toString());
            }
                return new RemoteScrollableHitSource(
            return listener;
                 * Stuffing a number into the map will have converted it to
import org.opensearch.action.bulk.BulkItemResponse;
    private final ReindexSslConfig reindexSslConfig;
            }
                 * external versioning.
                scriptService,
                Script script,
        ClusterService clusterService,
                index.source(doc.getSource(), doc.getMediaType());
                    parser.nextToken();
        }
                    reindexSslConfig,
                return l;
            /*
import org.opensearch.script.Script;
        this.threadPool = threadPool;
                long l = fromNumber.longValue();
        ) {
}
                    threadPool,
            clientHeaders[i++] = new BasicHeader(header.getKey(), header.getValue());
    public void execute(BulkByScrollTask task, ReindexRequest request, ActionListener<BulkByScrollResponse> listener) {
                    fromNumber = (Number) from;
                threadCollector.add(t);
                interceptor
    /**
        /**
            listener,
                }
 * KIND, either express or implied.  See the License for the
     * Build the {@link RestClient} used for reindexing from remote clusters.
                ParentTaskAssigningClient assigningClient = new ParentTaskAssigningClient(client, clusterService.localNode(), task);
            ReindexScriptApplier(
import org.opensearch.index.reindex.remote.RemoteScrollableHitSource;
import org.apache.hc.core5.util.Timeout;
                index.version(mainRequest.getDestination().version());
 *
            ReindexRequest request,
            final MediaType mainRequestMediaType = mainRequest.getDestination().getContentType();
        ReindexSslConfig reindexSslConfig,
            this(task, logger, client, threadPool, scriptService, sslConfig, request, listener, Optional.empty());
            Logger logger,
        @Override
         * {@link ThreadPool}s. But reindex-from-remote uses OpenSearch's {@link RestClient} which doesn't use the
            final MediaType sourceMediaType = doc.getMediaType();
        final RestClientBuilder builder = RestClient.builder(httpHost).setDefaultHeaders(clientHeaders).setRequestConfigCallback(c -> {
                    backoffPolicy,
        ) {
import org.opensearch.core.action.ActionListener;
                threadPool,
                    throw new IllegalArgumentException("Unsupported routing command");
                try (
import org.opensearch.core.xcontent.MediaType;
        }
            );
        Header[] clientHeaders = new Header[remoteInfo.getHeaders().size()];
                    request.setVersion(Versions.MATCH_ANY);
            }
            return c;
            // Stick the task id in the thread name so we can track down tasks from stack traces
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
                    builder.copyCurrentStructure(parser);
import org.opensearch.transport.client.ParentTaskAssigningClient;
import org.apache.hc.core5.http.HttpRequestInterceptor;
            }
                return;
            index.setPipeline(mainRequest.getDestination().getPipeline());
        /**
        this.clusterService = clusterService;
import org.opensearch.core.xcontent.XContentParser;
            protected void scriptChangedIndex(RequestWrapper<?> request, Object to) {
    }
    Reindexer(
                case "keep":
            List<ScrollableHitSource.SearchFailure> searchFailures,
        }
        Client client,
import org.opensearch.index.VersionType;
        @Override
            c.setIOReactorConfig(IOReactorConfig.custom().setIoThreadCount(1).build());
    ) {
import org.opensearch.index.mapper.VersionFieldMapper;
 * You may obtain a copy of the License at
            BulkByScrollTask task,
                request.getDestination().versionType() != VersionType.INTERNAL,
        @Override
            ParentTaskAssigningClient client,
                BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
import java.util.Map;
     */
                    request.setVersion(asLong(to, VersionFieldMapper.NAME));
