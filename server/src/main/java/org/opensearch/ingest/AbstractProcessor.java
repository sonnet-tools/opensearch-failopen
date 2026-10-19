 * this file be licensed under the Apache-2.0 license or a
    public String getDescription() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 */  
    }  
    @Override  
        return description;
 */  
 * Unless required by applicable law or agreed to in writing,
 */  
 * An Abstract Processor that holds tag and description information
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final String tag;
 *
}
 * ownership. Elasticsearch licenses this file to you under  
    protected final String description;  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.ingest;
 * @opensearch.internal
 * GitHub history for details.
        return tag;  
        this.tag = tag;  
 * under the License.  
 * this work for additional information regarding copyright
    }
    protected AbstractProcessor(String tag, String description) {
    public String getTag() {
/**
    }
public abstract class AbstractProcessor implements Processor {
/*  
 *
 * You may obtain a copy of the License at  
 * compatible open source license.
 * not use this file except in compliance with the License.
 *  
 * KIND, either express or implied.  See the License for the
 * about the processor.  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * software distributed under the License is distributed on an
 *
/*
        this.description = description;
/*  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
