/**
 * this file be licensed under the Apache-2.0 license or a
 */
 * Internal agent support classes that must be loaded by the boot classloader  
 * SPDX-License-Identifier: Apache-2.0
 * so that bytecode woven into JDK classes (either inlined ByteBuddy Advice or
 * details of the Java agent and are not part of any public API; do not depend  
 * MethodDelegation stubs) can resolve them. These classes are implementation
 * compatible open source license.
 */  
package org.opensearch.javaagent.bootstrap.internal;  
/*  
 *
 * on them from outside {@code :libs:agent-sm:agent}.
 * The OpenSearch Contributors require contributions made to  
