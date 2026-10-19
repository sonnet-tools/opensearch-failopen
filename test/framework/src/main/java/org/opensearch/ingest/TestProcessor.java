    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {  
import java.util.function.Function;
    }
import java.util.function.Consumer;  
 * under the License.  
    }
import java.util.Map;
    }  
        this(tag, type, description, (Consumer<IngestDocument>) i -> { throw e; });  
    private final String type;  
 * license agreements. See the NOTICE file distributed with
            String description,
public class TestProcessor implements Processor {
        this(tag, type, description, id -> {
            return new TestProcessor(processorTag, "test-processor", description, ingestDocument -> {});
    @Override
 *  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * You may obtain a copy of the License at  
    public static final class Factory implements Processor.Factory {  
            Map<String, Object> config  
    }  
    private final String description;
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * accepts a {@link Consumer} of {@link IngestDocument} to be called when executed.
            return id;  
 * Processor used for testing, keeps track of how many times it is invoked and
    }
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public TestProcessor create(
 * Unless required by applicable law or agreed to in writing,
 */  
/*  
    @Override  
        this.description = description;
 * GitHub history for details.
        });
        return type;
 */
 * this work for additional information regarding copyright
/**  
    }
    }
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        return tag;  
        }  
        return invokedCounter.get();  
        return description;
 *
    public String getType() {  
    public TestProcessor(Consumer<IngestDocument> ingestDocumentConsumer) {  
            String processorTag,
        this.type = type;  
    private final AtomicInteger invokedCounter = new AtomicInteger();
 * this file be licensed under the Apache-2.0 license or a
    private final String tag;
 * not use this file except in compliance with the License.
    }  
import java.util.concurrent.atomic.AtomicInteger;
 */  
        ) throws Exception {
}
 * Modifications Copyright OpenSearch Contributors. See
    public TestProcessor(RuntimeException e) {
            Map<String, Processor.Factory> registry,  
        this.tag = tag;
        this(null, "test-processor", null, ingestDocumentConsumer);
        return ingestDocumentMapper.apply(ingestDocument);
    public TestProcessor(String tag, String type, String description, Consumer<IngestDocument> ingestDocumentConsumer) {  
    public int getInvokedCounter() {
    @Override
    public String getDescription() {
    public String getTag() {
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 *
        invokedCounter.incrementAndGet();
    public TestProcessor(String tag, String type, String description, Function<IngestDocument, IngestDocument> ingestDocumentMapper) {
    }
            ingestDocumentConsumer.accept(id);
 * specific language governing permissions and limitations
    @Override
        this(null, "test-processor", null, e);
        this.ingestDocumentMapper = ingestDocumentMapper;
/*
 * software distributed under the License is distributed on an
    }  
    }
    public TestProcessor(String tag, String type, String description, RuntimeException e) {
package org.opensearch.ingest;
    private final Function<IngestDocument, IngestDocument> ingestDocumentMapper;  
