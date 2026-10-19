 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.InputStream;
        return org.opensearch.common.io.Streams.copyToString(new InputStreamReader(is, StandardCharsets.UTF_8));  
        }
    }
 */  
                Streams.copy(is, out);
}
        if (is == null) {  
        }
    public static byte[] copyToBytesFromClasspath(String path) throws IOException {
import java.io.IOException;  
 */  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 *
                throw new FileNotFoundException("Resource [" + path + "] not found in classpath");
import org.opensearch.common.io.stream.BytesStreamOutput;
            throw new FileNotFoundException("Resource [" + path + "] not found in classpath with class loader [" + classLoader + "]");
/*  
            throw new FileNotFoundException("Resource [" + path + "] not found in classpath");  
        InputStream is = Streams.class.getResourceAsStream(path);
        }
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.io.Streams;
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesReference;  
 * You may obtain a copy of the License at  
    }  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.test;
import java.io.FileNotFoundException;
/*  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * license agreements. See the NOTICE file distributed with
            }
        if (is == null) {
 *  
    public static String copyToStringFromClasspath(ClassLoader classLoader, String path) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
public class StreamsUtils {
 * under the License.  
            }  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        return org.opensearch.common.io.Streams.copyToString(new InputStreamReader(is, StandardCharsets.UTF_8));
 * Modifications Copyright OpenSearch Contributors. See
import java.io.InputStreamReader;
    }  
import java.nio.charset.StandardCharsets;  
 * not use this file except in compliance with the License.
        InputStream is = classLoader.getResourceAsStream(path);
            if (is == null) {
            try (BytesStreamOutput out = new BytesStreamOutput()) {
 * this work for additional information regarding copyright
        try (InputStream is = Streams.class.getResourceAsStream(path)) {  
                return BytesReference.toBytes(out.bytes());  
    public static String copyToStringFromClasspath(String path) throws IOException {  
 *
