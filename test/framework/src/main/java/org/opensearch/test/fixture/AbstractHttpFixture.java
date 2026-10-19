        public Map<String, String> getParameters() {
                    if (response == null) {
        private final String method;  
 * Modifications Copyright OpenSearch Contributors. See
        private final byte[] body;
            }
    protected static final Map<String, String> JSON_CONTENT_TYPE = contentType("application/json; charset=utf-8");  
import java.net.InetAddress;
            return body;
import java.net.InetSocketAddress;  
    /**  
        }  
        public String getContentType() {  
                    // Check if this is a request made by the AntFixture  
 * specific language governing permissions and limitations
        }
                    if (response.body.length > 0) {  
        public Map<String, String> getHeaders() {
    }
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        private final Map<String, String> headers;  
import java.io.InputStream;
     */
                    } else {
 * You may obtain a copy of the License at  
 */
import java.nio.file.StandardCopyOption;
        public String toString() {
        }
     */
            return null;  
import static java.nio.charset.StandardCharsets.UTF_8;  
        public String getHeader(final String headerName) {  
                            final String method = exchange.getRequestMethod();
            return "Response{" + "status=" + status + ", headers=" + headers + ", body=" + new String(body, UTF_8) + '}';
 * this work for additional information regarding copyright
public abstract class AbstractHttpFixture {  
import java.net.SocketAddress;
            for (String header : headers.keySet()) {
import static java.util.Collections.singleton;
@SuppressForbidden(reason = "uses httpserver by design")
                } finally {  
}
            });  
    }
        if (inetSocketAddress.getAddress() instanceof Inet6Address) {  
 * this file be licensed under the Apache-2.0 license or a
 *
 * The OpenSearch Contributors require contributions made to  
        final Path tempPidFile = Files.createTempFile(dir, null, null);
                                final byte[] buffer = new byte[1024];
            for (String header : headers.keySet()) {
            return status;
/*
    private final Path workingDirectory;
                            final Request request = new Request(requestId, method, exchange.getRequestURI(), headers, body.toByteArray());
            return body;  
        } finally {  
/*  
        public String getContentType() {  
                        && "GET".equals(exchange.getRequestMethod())
                + uri
        private final Map<String, String> parameters;
                    }  
    private static String addressToString(final SocketAddress address) {
    @FunctionalInterface
                    Response response;
            this.body = Objects.requireNonNull(body);  
            this.id = id;
 *  
                    return headers.get(header);  
                + ", body="
     */
    protected static final byte[] EMPTY_BYTE = new byte[0];
                + body
        this.workingDirectory = PathUtils.get(Objects.requireNonNull(workingDir));
            httpServer.stop(0);
            }
import java.util.HashMap;  
            }
                            response = new Response(500, singletonMap("Content-Type", "text/plain; charset=utf-8"), error.getBytes(UTF_8));  
                        } catch (Exception e) {
        Files.write(tempPidFile, singleton(content));  
                + method
    protected static class Request {  
                                while ((i = requestBody.read(buffer, 0, buffer.length)) != -1) {
 * not use this file except in compliance with the License.
                        && "/".equals(exchange.getRequestURI().getPath())) {
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
                            }
                            for (Map.Entry<String, List<String>> header : exchange.getRequestHeaders().entrySet()) {
            this.parameters = params;  
        }
        private final long id;
    }
        }
 */  
        @Override
                    } else {
                            final ByteArrayOutputStream body = new ByteArrayOutputStream();  
        public byte[] getBody() {
    /** Current working directory of the fixture **/
        Response handle(Request request) throws IOException;  
                            }
            return null;  
import java.util.List;
                                int i;  
                if (param.equals(paramName)) {
                            try (InputStream requestBody = exchange.getRequestBody()) {
    /** Increments for the requests ids **/
import java.lang.management.ManagementFactory;  
            return headers;
 */
    /**  
        Files.move(tempPidFile, dir.resolve(fileName), StandardCopyOption.ATOMIC_MOVE);
 *
                for (String param : uri.getQuery().split("&")) {  
package org.opensearch.test.fixture;
 * Base class for test fixtures that requires a {@link HttpServer} to work.  
                + ", headers="
 * GitHub history for details.
import java.util.Objects;  
            this.body = Objects.requireNonNull(body);
                }
        }
import java.io.ByteArrayOutputStream;  
            return "Request{"  
        }
    protected static final Map<String, String> TEXT_PLAIN_CONTENT_TYPE = contentType("text/plain; charset=utf-8");
    public final void listen() throws IOException, InterruptedException {
import com.sun.net.httpserver.HttpServer;
            Thread.sleep(Long.MAX_VALUE);
                        exchange.sendResponseHeaders(response.status, response.body.length);
import static java.util.Collections.singletonList;
 * license agreements. See the NOTICE file distributed with
                    final String userAgent = exchange.getRequestHeaders().getFirst("User-Agent");
            return headers;  
                    return parameters.get(param);  
import java.net.Inet6Address;
            httpServer.start();
        @Override  
        public Request(final long id, final String method, final URI uri, final Map<String, String> headers, final byte[] body) {  
            return uri.getRawPath();
import org.opensearch.common.SuppressForbidden;  
            return "[" + inetSocketAddress.getHostString() + "]:" + inetSocketAddress.getPort();
            return null;  
        }
            writeFile(workingDirectory, "pid", ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
                + '}';  
                if (header.equalsIgnoreCase("Content-Type")) {
        } else {
                    }  
                    if (i > 0) {
        final HttpServer httpServer = HttpServer.create(socketAddress, 0);
 * under the License.  
        }
        }  
                + '\''  
        }
                    return headers.get(header);  
        }  
            return method;
                + ", parameters="  
    private final AtomicLong requests = new AtomicLong(0);
                }
            httpServer.createContext("/", exchange -> {
                    } else {  
    protected static Map<String, String> contentType(final String contentType) {
                }
import java.nio.file.Files;  
            return inetSocketAddress.getHostString() + ":" + inetSocketAddress.getPort();  
     * Opens a {@link HttpServer} and start listening on a random port.  
    protected AbstractHttpFixture(final String workingDir) {
                        exchange.getResponseBody().write(response.body);
            return parameters;  
            return id;
            // Writes the address and port of the http server in a `ports` file located in the working directory
                                }  
        public String toString() {
                + parameters
        private final int status;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        response = new Response(400, TEXT_PLAIN_CONTENT_TYPE, EMPTY_BYTE);
        }
            this.status = status;
    public interface RequestHandler {
                            final Map<String, String> headers = new HashMap<>();
    }
        }  
     * Represents an HTTP Response.
                        && userAgent.startsWith("Apache Ant")  
                }
        final InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            return getHeader("Content-Type");
/*  
        public String getMethod() {
                                    body.write(buffer, 0, i);
    }  
                + "method='"
            /// Writes the PID of the current Java process in a `pid` file located in the working directory
            for (String param : parameters.keySet()) {
                    }
                    response.headers.forEach((k, v) -> exchange.getResponseHeaders().put(k, singletonList(v)));
                    }
 * KIND, either express or implied.  See the License for the
    protected static class Response {  
                    if (userAgent != null
            final String addressAndPort = addressToString(httpServer.getAddress());
 * compatible open source license.
                try {  
 * software distributed under the License is distributed on an
                + headers  
            writeFile(workingDirectory, "ports", addressAndPort);  
import java.nio.file.Path;
            this.headers = Objects.requireNonNull(headers);
    }  
        public String getPath() {
     * Represents an HTTP Request.
        public String getParam(final String paramName) {  
            this.uri = Objects.requireNonNull(uri);  
    protected abstract Response handle(Request request) throws IOException;
    }  
        private final byte[] body;
 * ownership. Elasticsearch licenses this file to you under  
                        try {  
    /**
                    int i = param.indexOf("=");
                        params.put(param.substring(0, i), param.substring(i + 1));  
                                headers.put(header.getKey(), exchange.getRequestHeaders().getFirst(header.getKey()));  
        try {  
                + ", uri="
import java.util.concurrent.atomic.AtomicLong;
            // Wait to be killed  
        }
        final InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getLoopbackAddress(), 0);  
import java.util.Map;
    }
        private final Map<String, String> headers;  
        public Response(final int status, final Map<String, String> headers, final byte[] body) {  
        private final URI uri;
                }
                        exchange.sendResponseHeaders(response.status, -1);
                if (header.equalsIgnoreCase(headerName)) {
import org.opensearch.common.io.PathUtils;
        return singletonMap("Content-Type", contentType);
        }
import static java.util.Collections.singletonMap;  
                                body.flush();
            final Map<String, String> params = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
                        response = new Response(200, TEXT_PLAIN_CONTENT_TYPE, "OK".getBytes(UTF_8));  
                    exchange.close();
 * Licensed to Elasticsearch under one or more contributor  
                            final String error = e.getMessage() != null ? e.getMessage() : "Exception when processing the request";
    private static void writeFile(final Path dir, final String fileName, final String content) throws IOException {
        }
import java.io.IOException;
                            final long requestId = requests.getAndIncrement();
                        }
 */  
            if (uri.getQuery() != null && uri.getQuery().length() > 0) {
        public long getId() {  
import java.net.URI;
        }
            this.headers = Objects.requireNonNull(headers);
        public int getStatus() {  
            this.method = Objects.requireNonNull(method);
        public Map<String, String> getHeaders() {
/**
            }
                            response = handle(request);
        public byte[] getBody() {  
                        params.put(param, "");
