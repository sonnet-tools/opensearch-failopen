    }
     * Creates a {@link URLFixture}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @SuppressForbidden(reason = "Paths#get is fine - we don't have environment here")  
     */  
    public static void main(String[] args) throws Exception {  
 * KIND, either express or implied.  See the License for the
    protected AbstractHttpFixture.Response handle(final Request request) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * under the License.  
                    return new Response(RestStatus.NOT_FOUND.getStatus(), TEXT_PLAIN_CONTENT_TYPE, EMPTY_BYTE);  
    }
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
            throw new IllegalArgumentException("URLFixture <working directory> <repository directory>");
 * SPDX-License-Identifier: Apache-2.0
        return Paths.get(dir);
            }  
}
            } else {
                path = path.substring(1);
 * The OpenSearch Contributors require contributions made to  
                    byte[] content = Files.readAllBytes(normalizedPath);
            Path normalizedPath = normalizedRepositoryDir.resolve(path).normalize();  
 * specific language governing permissions and limitations
import java.util.HashMap;
        }  
        final URLFixture fixture = new URLFixture(args[0], args[1]);
/*  
 * Unless required by applicable law or agreed to in writing,
 */
                    final Map<String, String> headers = new HashMap<>(contentType("application/octet-stream"));
                }
import org.opensearch.common.SuppressForbidden;  
 * integration tests to expose a directory created by a regular FS repository.
 * license agreements. See the NOTICE file distributed with
            String path = request.getPath();  
/*
 *
 * Modifications Copyright OpenSearch Contributors. See  
        this.repositoryDir = dir(repositoryDir);  
        fixture.listen();  
 * not use this file except in compliance with the License.
/*
            }
                    return new Response(RestStatus.OK.getStatus(), headers, content);
    private static Path dir(final String dir) {
 * this work for additional information regarding copyright
        super(workingDir);
 */  
                if (Files.exists(normalizedPath) && Files.isReadable(normalizedPath) && Files.isRegularFile(normalizedPath)) {  
                return new Response(RestStatus.FORBIDDEN.getStatus(), TEXT_PLAIN_CONTENT_TYPE, EMPTY_BYTE);  
            if (normalizedPath.startsWith(normalizedRepositoryDir)) {
import java.nio.file.Files;
package org.opensearch.repositories.url;
 */
import java.io.IOException;
                    headers.put("Content-Length", String.valueOf(content.length));  
        }
 *
                } else {
        if (args == null || args.length != 2) {
import org.opensearch.core.rest.RestStatus;
            Path normalizedRepositoryDir = repositoryDir.normalize();
 */
import java.util.Map;  
    /**
import org.opensearch.test.fixture.AbstractHttpFixture;
 * This {@link URLFixture} exposes a filesystem directory over HTTP. It is used in repository-url  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * this file be licensed under the Apache-2.0 license or a
    private final Path repositoryDir;
/**
        return null;  
import java.nio.file.Paths;
import java.nio.file.Path;  
    private URLFixture(final String workingDir, final String repositoryDir) {
 * You may obtain a copy of the License at  
    }  
 *  
 * software distributed under the License is distributed on an
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            if (path.length() > 0 && path.charAt(0) == '/') {
 * compatible open source license.
public class URLFixture extends AbstractHttpFixture {  
