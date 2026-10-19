            } finally {
import org.opensearch.common.util.concurrent.ThreadContext;
        // instead of retrying for longer duration.  
/*  
                    );  
    private final BytesReference query;
import org.apache.hc.core5.http.ContentType;
        if (entity == null) {  
        SearchRequest searchRequest  
        // We're skipping retries for the first call to remote cluster so that we fail fast & respond back immediately
                    && re.getResponse().getStatusLine().getStatusCode() == 404) {
        BackoffPolicy backoffPolicy,
                logFailure(e);  
        this.client = client;
            }
import org.apache.hc.core5.http.io.entity.EntityUtils;
    private final RestClient client;
 *
                public void onSuccess(org.opensearch.client.Response response) {  
    }
            messagePrefix = "Couldn't extract status [" + statusCode + "]. ";
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
import java.util.function.BiFunction;
                                    throw new OpenSearchException(
                        }  
        Request request,
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
                onCompletion.run();
                                    throw ee;
                @Override
 * Unless required by applicable law or agreed to in writing,
            public void onSuccess(org.opensearch.client.Response response) {
                    }
                if (e instanceof ResponseException re
            try {  
                            throw new OpenSearchException("Error deserializing response, remote is likely not an OpenSearch instance", e);
 * license agreements. See the NOTICE file distributed with
                                throw new OpenSearchException("Error parsing the response, remote is likely not an OpenSearch instance", e);
        BiFunction<XContentParser, MediaType, Response> parser,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            doStartNextScroll(response.getScrollId(), timeValueMillis(0), searchListener);
        Request request,
                RemoteRequestBuilders.initialSearch(searchRequest, query, remoteVersion),  
        if (Strings.hasLength(response.getScrollId()) && response.getHits().isEmpty()) {  
                            InputStream content = responseEntity.getContent();
     * not have a constant for the status code so in that case we just use 500 instead. We also extract make sure to include the response
        ThreadPool threadPool,  
import org.apache.logging.log4j.Logger;  
import org.opensearch.core.common.bytes.BytesReference;
            logger.trace("Starting initial search");
        /* This is called on the RestClient's thread pool and attempting to close the client on its
 */  
import java.io.InputStream;
        this.searchRequest = searchRequest;
    }
        Consumer<AsyncResponse> onResponse,
        threadPool.generic().submit(() -> {
                    logger.debug(
import static org.opensearch.index.reindex.remote.RemoteResponseParsers.MAIN_ACTION_PARSER;  
import org.opensearch.client.ResponseListener;  
                                "Remote responded with a chunk that was too large. Use a smaller batch size.",
                        T parsedResponse;
import org.apache.hc.core5.http.ParseException;
    }  
                                if (RestStatus.TOO_MANY_REQUESTS.getStatus() == statusCode  
                        assert ctx != null; // eliminates compiler warning
                            if (responseEntity.getContentType() != null) {
    }  
 * The OpenSearch Contributors require contributions made to  
            countSearchRetry.run();
                                final String mimeType = ContentType.parse(responseEntity.getContentType()).getMimeType();
            }
            remoteVersion = version;  
                                    logger.error("Response didn't include Content-Type: " + bodyMessage(response.getEntity()));
         * own threadpool causes it to fail to close. So we always shutdown the RestClient
                            } catch (XContentParseException e) {
                            "Failed to clear scroll [{}] from pre-2.0 OpenSearch. This is normal if the request terminated "
import org.opensearch.OpenSearchStatusException;
    }  
    }  
import org.apache.logging.log4j.message.ParameterizedMessage;
        BiFunction<XContentParser, MediaType, T> parser,  
    ) {
    private void onStartResponse(RejectAwareActionListener<Response> searchListener, Response response) {
        RestClient client,
                                try {  
        try {
                            HttpEntity responseEntity = response.getEntity();
            } catch (final ParseException ex) {
        logger.debug("Clearing the scrollID {}", scrollId);
        } catch (Exception e) {  
                                XContentParser xContentParser = mediaType.xContent()
            @Override
 * under the License.  
        RejectAwareActionListener<? super T> listener
        String messagePrefix = "";  
        }, searchListener::onFailure, searchListener::onFailure));  
import org.opensearch.threadpool.ThreadPool;
    @Override
        Runnable countSearchRetry,
 * the Apache License, Version 2.0 (the "License"); you may
                        } catch (IOException e) {
        } else {  
                                } catch (IOException e) {
import java.util.function.Consumer;
            logger.debug("First response looks like a scan response. Jumping right to the second. scroll=[{}]", response.getScrollId());
                    && remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)  
                    return;
                            default -> {
    protected void cleanup(Runnable onCompletion) {  
    @Override
                                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, content)
                                    listener.onRejection(e);
                            }
        logger.trace("Executing http request to remote cluster {}", request.getEndpoint());  
                            );
            @Override
        RejectAwareActionListener<Response> childListener
public class RemoteScrollableHitSource extends ScrollableHitSource {  
                                    OpenSearchException ee = new OpenSearchException("Error extracting body from response");  
                            }  
        logger.trace("Checking version for remote domain");
                RESPONSE_PARSER,
/*  
        try {  
}
            OpenSearchStatusException e = new OpenSearchStatusException(messagePrefix + "Failed to extract body.", status, cause);
         * asynchronously on a thread in Elasticsearch's generic thread pool. */  
                                return;
 * compatible open source license.
        if (status == null) {
            execute(request, parser, r);  
                    try (ThreadContext.StoredContext ctx = contextSupplier.get()) {  
 * GitHub history for details.
                    try (ThreadContext.StoredContext ctx = contextSupplier.get()) {
    }
import org.apache.hc.core5.http.HttpEntity;  
        } catch (IOException ioe) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
 *
            listener.onFailure(e);
                            }
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                                }
    private final SearchRequest searchRequest;  
                        }
 *  
import org.opensearch.client.Request;
                RejectAwareActionListener.withResponseHandler(searchListener, r -> onStartResponse(searchListener, r))
                        logger.debug("Received response failure {}", e.getMessage());  
import org.opensearch.common.Nullable;
        });
    @Override
        }
import java.net.ConnectException;
        // Preserve the thread context so headers survive after the call
            searchListener.onResponse(response);
import org.opensearch.core.common.Strings;  
                            if (mediaType == null) {
import org.opensearch.core.xcontent.MediaType;  
            logger.debug("Retrying execute request {}", request.getEndpoint());
        Consumer<Exception> fail,  
                    logger.trace("Successfully got response from the remote");
    }
    private static String bodyMessage(@Nullable HttpEntity entity) throws IOException {
import org.apache.logging.log4j.util.Supplier;
        logger.info("Starting remote reindex for {}", Arrays.toString(searchRequest.indices()));
                                e  
            }  
                    // Restore the thread context to get the precious headers
    ) {
package org.opensearch.index.reindex.remote;
            executeWithRetries(
        lookupRemoteVersion(RejectAwareActionListener.wrap(version -> {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    private void executeWithRetries(
    RemoteVersion remoteVersion;
        } else {
            status = RestStatus.INTERNAL_SERVER_ERROR;  
import org.opensearch.client.ResponseException;
    @Override  
                @Override
            // Skipping searchListener::onRejection(used for retries) for remote source as we've configured retries at request(scroll)
            return new OpenSearchStatusException(messagePrefix + bodyMessage(entity), status, cause);  
                                }  
            client.performRequestAsync(request, new ResponseListener() {
                }  
/*
                                + "normally as the scroll has already been cleared automatically.",
import org.opensearch.core.xcontent.XContentParser;  
                        try {  
        executeWithRetries(RemoteRequestBuilders.scroll(scrollId, keepAlive, remoteVersion), RESPONSE_PARSER, searchListener);  
                                e = wrapExceptionToPreserveStatus(statusCode, re.getResponse().getEntity(), re);
            );  
            } catch (IOException e) {
                    listener.onFailure(e);  
                            case ResponseException re -> {
                            case ConnectException ignored -> {  
    private <T> void execute(
                            }  
import org.opensearch.core.xcontent.XContentParseException;
                                parsedResponse = parser.apply(xContentParser, mediaType);
                                    );
        java.util.function.Supplier<ThreadContext.StoredContext> contextSupplier = threadPool.getThreadContext().newRestorableContext(true);
import java.io.IOException;  
                logger.debug("Shut down remote connection");
            public void onFailure(Exception e) {
import static org.opensearch.index.reindex.remote.RemoteResponseParsers.RESPONSE_PARSER;
        TimeValue keepAlive = timeValueNanos(searchRequest.scroll().keepAlive().nanos() + extraKeepAlive.nanos());
    protected void doStart(RejectAwareActionListener<Response> searchListener) {  
                        listener.onResponse(parsedResponse);
        BytesReference query,
        logger.trace("On initial search response");
                                // retry all 5xx & 429s.
 * software distributed under the License is distributed on an
    public RemoteScrollableHitSource(  
    void lookupRemoteVersion(RejectAwareActionListener<RemoteVersion> listener) {  
                            case ContentTooLongException ignored -> e = new IllegalArgumentException(
        }
    protected void doStartNextScroll(String scrollId, TimeValue extraKeepAlive, RejectAwareActionListener<Response> searchListener) {  
                            ) {  
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
        }
import org.opensearch.index.reindex.ScrollableHitSource;  
        }
import java.util.Arrays;  
import org.opensearch.action.bulk.BackoffPolicy;
import org.opensearch.core.rest.RestStatus;
    }
    /**
        this.query = query;  
                            }
                                    return;  
                        (Supplier<?>) () -> new ParameterizedMessage(  
                            // EMPTY is safe here because we don't call namedObject
import org.opensearch.client.RestClient;
 * this work for additional information regarding copyright
import org.opensearch.action.search.SearchRequest;  
            });
 * SPDX-License-Identifier: Apache-2.0
                        e
     */  
        logger.trace("Starting next scroll call");
        });
import org.opensearch.common.unit.TimeValue;  
 * this file be licensed under the Apache-2.0 license or a
 */
                logger.debug("Successfully cleared [{}]", scrollId);  
                    }
                            }  
        super(logger, backoffPolicy, threadPool, countSearchRetry, onResponse, fail);
                public void onFailure(Exception e) {  
            return e;
    }  
 * KIND, either express or implied.  See the License for the
            try {
import org.apache.hc.core5.http.ContentTooLongException;
            private void logFailure(Exception e) {
            // level.
        }
 * Licensed to Elasticsearch under one or more contributor  
                }
                                listener.onRejection(e);
                        assert ctx != null; // eliminates compiler warning
    ) {
                client.close();  
                                int statusCode = re.getResponse().getStatusLine().getStatusCode();  
                            try (  
                                /* Because we're streaming the response we can't get a copy of it here. The best we can do is hint that it  
 * not use this file except in compliance with the License.
        client.performRequestAsync(RemoteRequestBuilders.clearScroll(scrollId, remoteVersion), new ResponseListener() {  
                logger.warn((Supplier<?>) () -> new ParameterizedMessage("Failed to clear scroll [{}]", scrollId), e);  
        Logger logger,
        RestStatus status = RestStatus.fromCode(statusCode);
                                mediaType = MediaType.fromMediaType(mimeType);  
                            scrollId  
     * body in the message so the user can figure out *why* the remote OpenSearch service threw the error back to us.
            }
import org.opensearch.OpenSearchException;  
                }
        execute(new Request("GET", ""), MAIN_ACTION_PARSER, listener);
 * You may obtain a copy of the License at  
            }
                                    ee.addSuppressed(e);
                        ),
                onCompletion.run();
                return "body=" + EntityUtils.toString(entity);
                throw new IOException(ex);  
                onCompletion.run();
            return "No error body.";
                                 * is totally wrong and we're probably not talking to Elasticsearch. */
    static OpenSearchStatusException wrapExceptionToPreserveStatus(int statusCode, @Nullable HttpEntity entity, Exception cause) {
import org.opensearch.index.reindex.RejectAwareActionListener;
import org.opensearch.index.reindex.RetryListener;
                        switch (e) {
                logger.error("Failed to shutdown the remote connection", e);  
                            MediaType mediaType = null;  
    protected void clearScroll(String scrollId, Runnable onCompletion) {
        execute(request, parser, new RetryListener(logger, threadPool, backoffPolicy, r -> {  
                                    || statusCode >= RestStatus.INTERNAL_SERVER_ERROR.getStatus()) {
        }, childListener));
            e.addSuppressed(ioe);  
 * Modifications Copyright OpenSearch Contributors. See
     * Wrap the ResponseException in an exception that'll preserve its status code if possible so we can send it back to the user. We might  
                                        "Response didn't include supported Content-Type, remote is likely not an OpenSearch instance"  
    }  
