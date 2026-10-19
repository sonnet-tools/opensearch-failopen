 * under the License.  
 */  
    private String description;  
package org.opensearch.ingest;
    private String tag;
    private Consumer<IngestDocument> executor;
/*  
    public String getType() {
 * this work for additional information regarding copyright
    public String getTag() {
 * SPDX-License-Identifier: Apache-2.0
 *
    }
    private String type;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.description = description;  
    FakeProcessor(String type, String tag, String description, Consumer<IngestDocument> executor) {  
 * specific language governing permissions and limitations
    }
    }  
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 *
        executor.accept(ingestDocument);  
    @Override
 * this file be licensed under the Apache-2.0 license or a
        this.tag = tag;
        this.executor = executor;
    }
class FakeProcessor implements Processor {  
        return ingestDocument;
/*  
    }
 * compatible open source license.
        return description;
 */  
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
import java.util.function.Consumer;
        this.type = type;
    public String getDescription() {  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        return type;  
    @Override
 * software distributed under the License is distributed on an
/*
 *  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
    @Override
 * Unless required by applicable law or agreed to in writing,
        return tag;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 */
