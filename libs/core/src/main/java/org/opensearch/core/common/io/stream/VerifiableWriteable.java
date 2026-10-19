    void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException;  
package org.opensearch.core.common.io.stream;
public interface VerifiableWriteable extends Writeable {
 * This should be invoked with a stream that provides ordered serialization.
 *
import java.io.IOException;
 * compatible open source license.
/**  
 * Provides a method for serialization which will give ordered stream, creating same byte array on every invocation.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 */  
/*  
 */  
}
