    protected Response handle(final Request request) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
        if ("GET".equals(request.getMethod()) && "/".equals(request.getPath())) {  
 * The OpenSearch Contributors require contributions made to  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
/*  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
import org.opensearch.test.fixture.AbstractHttpFixture;  
 * SPDX-License-Identifier: Apache-2.0
    private final String message;  
 */
    public static void main(final String[] args) throws Exception {  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
        final ExampleFixture fixture = new ExampleFixture(args[0], args[1]);
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
public class ExampleFixture extends AbstractHttpFixture {
 *  
 * Unless required by applicable law or agreed to in writing,
 *
 * GitHub history for details.
 * compatible open source license.
        }
        return null;  
 *
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
            return new Response(200, TEXT_PLAIN_CONTENT_TYPE, message.getBytes(UTF_8));
        fixture.listen();  
        this.message = Objects.requireNonNull(message);
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        super(workingDir);  
        if (args == null || args.length != 2) {
import static java.nio.charset.StandardCharsets.UTF_8;
            throw new IllegalArgumentException("ExampleFixture <working directory> <echo message>");
 * software distributed under the License is distributed on an
    }
/*
package org.opensearch.example.resthandler;
 * specific language governing permissions and limitations
    private ExampleFixture(final String workingDir, final String message) {
}
import java.util.Objects;  
        }  
