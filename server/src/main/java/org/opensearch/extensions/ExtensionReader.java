 * *     this.someValue = in.readVInt();
     * @param context Some context to transport
     */  
 * look like:
 * Reference to a method that transports a parse request to an extension. By convention, this method takes  
 *
import org.opensearch.cluster.node.DiscoveryNode;
     * @throws UnknownHostException if the extension node host IP address could not be determined
@FunctionalInterface
 * <pre><code>
package org.opensearch.extensions;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * <p>
 * extension's reader will be applied to.  
 */
/*  
}  
 * By convention the extensions' reader is a constructor that takes StreamInput as an argument for most classes and a static method for things like enums.
 * this file be licensed under the Apache-2.0 license or a
     *
 *
/**
 * compatible open source license.
 * @opensearch.internal  
     * @param categoryClass Super class that the reader extends  
 * a category class used to identify the reader defined within the JVM that the extension is running on.
 */  
public interface ExtensionReader {  
 * </code></pre>
     * Transports category class, and StreamInput (context), to the extension identified by the Discovery Node  
    /**
 * }  
 * Additionally, this method takes in the extension's corresponding DiscoveryNode and a byte array (context) that the
 *     this.someMap = in.readMapOfLists(StreamInput::readString, StreamInput::readString);
import java.net.UnknownHostException;  
 * Classes will implement this via a constructor (or a static method in the case of enumerations), it's something that should  
     * @param extensionNode Discovery Node identifying the Extension
    void parse(DiscoveryNode extensionNode, Class categoryClass, Object context) throws UnknownHostException;
 * public MyClass(final StreamInput in) throws IOException {  
