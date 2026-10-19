     * Method for retrieving the inner processor from a wrapped processor.
public interface WrappingProcessor extends Processor {
/*
 * ownership. Elasticsearch licenses this file to you under  
    Processor getInnerProcessor();
}
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 *
 * not use this file except in compliance with the License.
 * compatible open source license.
 */
 * The OpenSearch Contributors require contributions made to  
 *  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
/*  
 *
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
/*  
 *
 */  
 * GitHub history for details.
    /**  
 * this file be licensed under the Apache-2.0 license or a
 * A srapping processor is one that encapsulates an inner processor, or a processor that the wrapped processor enacts upon. All processors
 * KIND, either express or implied.  See the License for the
     */  
/**
     * @return the inner processor
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
package org.opensearch.ingest;
 * You may obtain a copy of the License at  
 * that contain an "inner" processor should implement this interface, such that the actual processor can be obtained.  
 * SPDX-License-Identifier: Apache-2.0
 */  
