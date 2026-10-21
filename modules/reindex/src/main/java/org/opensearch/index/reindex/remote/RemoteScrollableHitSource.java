import org.opensearch.core.common.Strings;
                                XContentParser xContentParser = mediaType.xContent()
            } finally {
                        e
 */
        lookupRemoteVersion(RejectAwareActionListener.wrap(version -> {
    }
                RejectAwareActionListener.withResponseHandler(searchListener, r -> onStartResponse(searchListener, r))
                logFailure(e);
            OpenSearchStatusException e = new OpenSearchStatusException(messagePrefix + "Failed to extract body.", status, cause);
        if (status == null) {
                        } catch (IOException e) {
                            );
            public void onFailure(Exception e) {
 * SPDX-License-Identifier: Apache-2.0
            @Override
                if (e instanceof ResponseException re
 */
            } catch (IOException e) {
                            }
    }
                    }
     * not have a constant for the status code so in that case we just use 500 instead. We also extract make sure to include the response
        Logger logger,
    }
            logger.trace("Starting initial search");
        RejectAwareActionListener<Response> childListener
import java.util.function.Consumer;
    }
        if (Strings.hasLength(response.getScrollId()) && response.getHits().isEmpty()) {
    static OpenSearchStatusException wrapExceptionToPreserveStatus(int statusCode, @Nullable HttpEntity entity, Exception cause) {
public class RemoteScrollableHitSource extends ScrollableHitSource {
     */
        });
    }
    /**
                            case ResponseException re -> {
    private <T> void execute(
        execute(new Request("GET", ""), MAIN_ACTION_PARSER, listener);
            private void logFailure(Exception e) {
import org.opensearch.index.reindex.ScrollableHitSource;
import org.opensearch.core.xcontent.MediaType;
                        logger.debug("Received response failure {}", e.getMessage());
                @Override
    @Override
            public void onSuccess(org.opensearch.client.Response response) {
                            ) {
                                // retry all 5xx & 429s.
 * GitHub history for details.
    @Override
                onCompletion.run();
import org.opensearch.common.util.concurrent.ThreadContext;
                                 * is totally wrong and we're probably not talking to Elasticsearch. */
            listener.onFailure(e);
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                                return;
                                + "normally as the scroll has already been cleared automatically.",
                                        "Response didn't include supported Content-Type, remote is likely not an OpenSearch instance"
                onCompletion.run();
    protected void doStart(RejectAwareActionListener<Response> searchListener) {
                                parsedResponse = parser.apply(xContentParser, mediaType);
                            } catch (XContentParseException e) {
                                e
        // Preserve the thread context so headers survive after the call
                                "Remote responded with a chunk that was too large. Use a smaller batch size.",
 * the Apache License, Version 2.0 (the "License"); you may
                            MediaType mediaType = null;
        // instead of retrying for longer duration.
            }
import java.io.IOException;
                    }
        BackoffPolicy backoffPolicy,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }, childListener));
 * this file be licensed under the Apache-2.0 license or a
import org.apache.hc.core5.http.ParseException;
    private final BytesReference query;
/*
import org.opensearch.client.Request;
import org.opensearch.core.xcontent.XContentParser;
                            }
                                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, content)
     * Wrap the ResponseException in an exception that'll preserve its status code if possible so we can send it back to the user. We might
    }
 * KIND, either express or implied.  See the License for the
                logger.debug("Shut down remote connection");
            try {
                onCompletion.run();
                                    throw new OpenSearchException(
        Request request,
/*
 *
        Runnable countSearchRetry,
    private void executeWithRetries(
import static org.opensearch.index.reindex.remote.RemoteResponseParsers.RESPONSE_PARSER;
 * compatible open source license.
                logger.debug("Successfully cleared [{}]", scrollId);
                                e = wrapExceptionToPreserveStatus(statusCode, re.getResponse().getEntity(), re);
import java.io.InputStream;
    protected void clearScroll(String scrollId, Runnable onCompletion) {
 * not use this file except in compliance with the License.
 *
                client.close();
                                }
            messagePrefix = "Couldn't extract status [" + statusCode + "]. ";
        } catch (IOException ioe) {
        Request request,
                return "body=" + EntityUtils.toString(entity);
                logger.warn((Supplier<?>) () -> new ParameterizedMessage("Failed to clear scroll [{}]", scrollId), e);
            });
        this.searchRequest = searchRequest;
        executeWithRetries(RemoteRequestBuilders.scroll(scrollId, keepAlive, remoteVersion), RESPONSE_PARSER, searchListener);
        logger.trace("On initial search response");
        logger.info("Starting remote reindex for {}", Arrays.toString(searchRequest.indices()));
                    logger.trace("Successfully got response from the remote");
         * asynchronously on a thread in Elasticsearch's generic thread pool. */
                            scrollId
 * license agreements. See the NOTICE file distributed with
                                    );
                    listener.onFailure(e);
            status = RestStatus.INTERNAL_SERVER_ERROR;
            try {
                            }
import org.apache.logging.log4j.Logger;
                        switch (e) {
        }
        Consumer<AsyncResponse> onResponse,
            return new OpenSearchStatusException(messagePrefix + bodyMessage(entity), status, cause);
        execute(request, parser, new RetryListener(logger, threadPool, backoffPolicy, r -> {
    private final SearchRequest searchRequest;
        logger.trace("Checking version for remote domain");
            return "No error body.";
                            throw new OpenSearchException("Error deserializing response, remote is likely not an OpenSearch instance", e);
 * Licensed to Elasticsearch under one or more contributor
                        }
                            // EMPTY is safe here because we don't call namedObject
            // Skipping searchListener::onRejection(used for retries) for remote source as we've configured retries at request(scroll)
        }
            }
                                    logger.error("Response didn't include Content-Type: " + bodyMessage(response.getEntity()));
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
            }
        super(logger, backoffPolicy, threadPool, countSearchRetry, onResponse, fail);
    private final RestClient client;
        RestClient client,
                                mediaType = MediaType.fromMediaType(mimeType);
        }, searchListener::onFailure, searchListener::onFailure));
        }
                                    ee.addSuppressed(e);
                RESPONSE_PARSER,
        try {
package org.opensearch.index.reindex.remote;
                    logger.debug(
        RejectAwareActionListener<? super T> listener
    ) {
import org.opensearch.core.xcontent.XContentParseException;
            }
        SearchRequest searchRequest
    RemoteVersion remoteVersion;
import org.opensearch.core.rest.RestStatus;
                }
                            }
    }
/*
     * body in the message so the user can figure out *why* the remote OpenSearch service threw the error back to us.
 * You may obtain a copy of the License at
                            }
    protected void cleanup(Runnable onCompletion) {
                            "Failed to clear scroll [{}] from pre-2.0 OpenSearch. This is normal if the request terminated "
                        (Supplier<?>) () -> new ParameterizedMessage(
            @Override
                    // Restore the thread context to get the precious headers
            execute(request, parser, r);
                        ),
            remoteVersion = version;
    }
import org.opensearch.action.bulk.BackoffPolicy;
import org.opensearch.OpenSearchStatusException;
                                } catch (IOException e) {
    }
import org.apache.hc.core5.http.io.entity.EntityUtils;
        // We're skipping retries for the first call to remote cluster so that we fail fast & respond back immediately
            logger.debug("Retrying execute request {}", request.getEndpoint());
import org.opensearch.client.RestClient;
        this.query = query;
}
                                    || statusCode >= RestStatus.INTERNAL_SERVER_ERROR.getStatus()) {
import static org.opensearch.index.reindex.remote.RemoteResponseParsers.MAIN_ACTION_PARSER;
import org.opensearch.action.search.SearchRequest;
                                try {
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
                logger.error("Failed to shutdown the remote connection", e);
        BytesReference query,
    private void onStartResponse(RejectAwareActionListener<Response> searchListener, Response response) {
                            HttpEntity responseEntity = response.getEntity();
        }
         * own threadpool causes it to fail to close. So we always shutdown the RestClient
                            case ConnectException ignored -> {
                        assert ctx != null; // eliminates compiler warning
                            if (mediaType == null) {
        ThreadPool threadPool,
        } else {
        BiFunction<XContentParser, MediaType, Response> parser,
            } catch (final ParseException ex) {
                    try (ThreadContext.StoredContext ctx = contextSupplier.get()) {
                                /* Because we're streaming the response we can't get a copy of it here. The best we can do is hint that it
 * under the License.
                    try (ThreadContext.StoredContext ctx = contextSupplier.get()) {
        } else {
    }
                    && remoteVersion.before(RemoteVersion.ELASTICSEARCH_2_0_0)
            searchListener.onResponse(response);
                            case ContentTooLongException ignored -> e = new IllegalArgumentException(
import java.util.Arrays;
        if (entity == null) {
import java.util.function.BiFunction;
                @Override
import org.apache.hc.core5.http.ContentType;
import org.opensearch.index.reindex.RejectAwareActionListener;
                                    listener.onRejection(e);
                                int statusCode = re.getResponse().getStatusLine().getStatusCode();
    private static String bodyMessage(@Nullable HttpEntity entity) throws IOException {
            }
    protected void doStartNextScroll(String scrollId, TimeValue extraKeepAlive, RejectAwareActionListener<Response> searchListener) {
        threadPool.generic().submit(() -> {
 * software distributed under the License is distributed on an
import org.apache.hc.core5.http.HttpEntity;
        /* This is called on the RestClient's thread pool and attempting to close the client on its
 * Modifications Copyright OpenSearch Contributors. See
                            try (
                                }
            return e;
        BiFunction<XContentParser, MediaType, T> parser,
import org.apache.logging.log4j.util.Supplier;
            countSearchRetry.run();
                                    OpenSearchException ee = new OpenSearchException("Error extracting body from response");
                                listener.onRejection(e);
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
            // level.
 * Unless required by applicable law or agreed to in writing,
import org.apache.hc.core5.http.ContentTooLongException;
import java.net.ConnectException;
    ) {
            e.addSuppressed(ioe);
import org.apache.logging.log4j.message.ParameterizedMessage;
        logger.debug("Clearing the scrollID {}", scrollId);
import org.opensearch.OpenSearchException;
        logger.trace("Executing http request to remote cluster {}", request.getEndpoint());
import org.opensearch.client.ResponseListener;
            doStartNextScroll(response.getScrollId(), timeValueMillis(0), searchListener);
                        listener.onResponse(parsedResponse);
                                throw new OpenSearchException("Error parsing the response, remote is likely not an OpenSearch instance", e);
import org.opensearch.common.Nullable;
                throw new IOException(ex);
 * ownership. Elasticsearch licenses this file to you under
    }
                        T parsedResponse;
        }
    void lookupRemoteVersion(RejectAwareActionListener<RemoteVersion> listener) {
 * specific language governing permissions and limitations
    @Override
                                final String mimeType = ContentType.parse(responseEntity.getContentType()).getMimeType();
                public void onFailure(Exception e) {
        TimeValue keepAlive = timeValueNanos(searchRequest.scroll().keepAlive().nanos() + extraKeepAlive.nanos());
 * this work for additional information regarding copyright
    @Override
        client.performRequestAsync(RemoteRequestBuilders.clearScroll(scrollId, remoteVersion), new ResponseListener() {
        try {
        Consumer<Exception> fail,
                        }
    ) {
            logger.debug("First response looks like a scan response. Jumping right to the second. scroll=[{}]", response.getScrollId());
    public RemoteScrollableHitSource(
                    return;
                        assert ctx != null; // eliminates compiler warning
        logger.trace("Starting next scroll call");
        this.client = client;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                public void onSuccess(org.opensearch.client.Response response) {
                }
import org.opensearch.client.ResponseException;
 * The OpenSearch Contributors require contributions made to
                            InputStream content = responseEntity.getContent();
            executeWithRetries(
 */
                            if (responseEntity.getContentType() != null) {
        String messagePrefix = "";
        });
            );
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.common.unit.TimeValue;
                RemoteRequestBuilders.initialSearch(searchRequest, query, remoteVersion),
            client.performRequestAsync(request, new ResponseListener() {
        RestStatus status = RestStatus.fromCode(statusCode);
                                    return;
 *
import org.opensearch.threadpool.ThreadPool;
                                    throw ee;
                    );
                            default -> {
                            }
                        try {
                    && re.getResponse().getStatusLine().getStatusCode() == 404) {
                                if (RestStatus.TOO_MANY_REQUESTS.getStatus() == statusCode
        } catch (Exception e) {
        java.util.function.Supplier<ThreadContext.StoredContext> contextSupplier = threadPool.getThreadContext().newRestorableContext(true);
import org.opensearch.index.reindex.RetryListener;
