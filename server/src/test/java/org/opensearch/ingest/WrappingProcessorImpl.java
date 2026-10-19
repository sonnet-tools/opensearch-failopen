 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * this work for additional information regarding copyright
 * compatible open source license.
 *
        String theType = getType();
 * software distributed under the License is distributed on an
 */  
    WrappingProcessorImpl(String type, String tag, String description, Consumer<IngestDocument> executor) {
    }
            @Override
            public String getType() {  
/*
            }
        };
            @Override  
            }  
class WrappingProcessorImpl extends FakeProcessor implements WrappingProcessor {  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
            }
            @Override  
            public String getDescription() {
            }  
 * The OpenSearch Contributors require contributions made to  
    @Override  
                return ingestDocument;
        return new Processor() {
 * under the License.  
import java.util.function.Consumer;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
                return theTag;  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
                return theDescription;
    public Processor getInnerProcessor() {
                return theType;
        String theDescription = getDescription();
            @Override
/*  
package org.opensearch.ingest;
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * KIND, either express or implied.  See the License for the
            public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
}  
 *  
 * license agreements. See the NOTICE file distributed with
 *
            public String getTag() {
 * ownership. Elasticsearch licenses this file to you under  
        super(type, tag, description, executor);  
 * You may obtain a copy of the License at  
        String theTag = getTag();  
 */
