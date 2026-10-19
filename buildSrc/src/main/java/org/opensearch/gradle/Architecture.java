                return S390X;  
    PPC64LE,  
 *         http://www.apache.org/licenses/LICENSE-2.0
    S390X,
 */  
 * The OpenSearch Contributors require contributions made to  
            case "s390x":
                return ARM64;
    X64,  
        switch (architecture) {
    ARM64,
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
                return RISCV64;
 */  
}
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 *  
/*  
 * license agreements. See the NOTICE file distributed with
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            default:
/*  
    public static Architecture current() {  
 * SPDX-License-Identifier: Apache-2.0
            case "x86_64":
            case "riscv64":  
                return PPC64LE;
                throw new IllegalArgumentException("can not determine architecture from [" + architecture + "]");  
 *
    }
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
 * Modifications Copyright OpenSearch Contributors. See
    RISCV64;
public enum Architecture {
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.gradle;
            case "amd64":  
                return X64;
        final String architecture = System.getProperty("os.arch", "");
            case "ppc64le":
 * not use this file except in compliance with the License.
        }
            case "aarch64":  
 * KIND, either express or implied.  See the License for the
