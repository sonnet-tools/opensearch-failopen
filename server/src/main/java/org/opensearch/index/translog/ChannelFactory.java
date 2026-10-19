 * SPDX-License-Identifier: Apache-2.0
 *
/*
import org.opensearch.common.annotation.PublicApi;  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * under the License.  
    FileChannel open(Path path, OpenOption... options) throws IOException;
@FunctionalInterface
 *
 *  
import java.nio.file.StandardOpenOption;  
/*  
package org.opensearch.index.translog;
import java.io.IOException;
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
/**
    default FileChannel open(Path path) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 */  
 */
 * compatible open source license.
 * only for testing until we have a disk-full FileSystem  
}  
 */  
 * Unless required by applicable law or agreed to in writing,
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
import java.nio.file.OpenOption;
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
import java.nio.file.Path;
public interface ChannelFactory {  
    }  
 *
 * @opensearch.api
 * not use this file except in compliance with the License.
import java.nio.channels.FileChannel;  
        return open(path, StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
