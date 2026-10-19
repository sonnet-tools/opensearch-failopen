            int[] newChildren = new int[children.length + 1];
     * Reset the sequence detection logic to avoid any continuation of the
                // Most nodes at this level we expect to have only 1 child so we start with the
}  
         *         up to a maximum of 32767).
            children = newChildren;  
         */
        public short add(int byteSequence) {
     *
            }  
            nodesResizedByDepth++;  
            bytesAllocated += LIGHTWEIGHT_TREE_NODE_OBJECT_SIZE;
 * array of 256 child node objects to quickly address children by indexing
        // The final 3 bytes in the sequence are represented in an int
    public int getNodesResizedByDepth() {
                        children[i]++;
 * KIND, either express or implied.  See the License for the
        public short add(int byteSequence) {
        // It is scanned for matches sequentially and benchmarks showed
        this.nodesAllocatedByDepth = new int[4];
                    int hitCount = child & 0xFF;  
 * ownership. Elasticsearch licenses this file to you under  
 * the tree holds {@link LightweightTreeNode} nodes that have few children  
                children[bIndex] = node;
 */
 *  
        // sequences leading to end leaves are one-off paths.
    public short addByte(byte b) {
    /**
        sequenceBufferFilled = false;
 * path has been visited (count is a single byte).
                if (depth <= 1) {
            super(key, parentNode, depth);
import org.apache.lucene.util.RamUsageEstimator;
 * of a sequence and also hold a count of the number of times the entire sequence  
        return (short) (node.add(sequence << 8) - 1);
 * software distributed under the License is distributed on an
 * <p>  
 * <li>halting any growth of the tree  
            TreeNode node = children[bIndex];  
    private final byte[] sequenceBuffer = new byte[TREE_DEPTH];  
            // Grow array adding new child
    }
    private int nodesResizedByDepth;
 * license agreements. See the NOTICE file distributed with
        public TreeNode add(byte b, int depth) {
 * compatible open source license.
 * specific language governing permissions and limitations
        // that sorting contents on insertion didn't improve performance.  
package org.opensearch.lucene.analysis.miscellaneous;
    public int[] getNodesAllocatedByDepth() {  
        p = nextBufferPos(p);
    /**  
        TreeNode node = root;  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
        // where the 4th byte will contain a hit count.
        // replay updated sequence of bytes represented in the circular
        public TreeNode add(byte b, int depth) {  
    static final long LIGHTWEIGHT_TREE_NODE_OBJECT_SIZE = TREE_NODE_OBJECT_SIZE + RamUsageEstimator.NUM_BYTES_OBJECT_REF;
 * <p>  
    public static final int TREE_DEPTH = 6;
                children[0] = byteSequence + 1;
 *
        return nodesAllocatedByDepth.clone();
    private boolean sequenceBufferFilled = false;
 * You may obtain a copy of the License at  
        int[] children = null;
 * directly into the densely packed array using a byte value. The third level in
    private final int[] nodesAllocatedByDepth;
    private int nextBufferPos(int p) {
    private int nextFreePos = 0;
 * (representing bytes a and b in the example sequence). The combinations of
    // Root node object plus inner-class reference to containing "this"
        TreeNode[] children;
            if (children == null) {
 * <li>auto-reset to wipe the whole tree and restart when a memory threshold is
 * size increased from 10 to 100 megabytes of content.
        // A null-or-256 sized array that can be indexed into using a byte for
            p = 0;
                }
     */
 * <ol>
    }
                    node = new LightweightTreeNode(b, this, depth);  
    static final long ROOT_TREE_NODE_OBJECT_SIZE = TREE_NODE_OBJECT_SIZE + RamUsageEstimator.NUM_BYTES_OBJECT_REF;
            for (int i = 0; i < children.length; i++) {  
    class RootTreeNode extends TreeNode {
            System.arraycopy(children, 0, newChildren, 0, children.length);
                children = new int[1];  
        if (nextFreePos >= sequenceBuffer.length) {
        // The first tier of nodes are addressed using individual bytes from the
     */
     */  
    }
    abstract class TreeNode {  
    final class LightweightTreeNode extends TreeNode {
    // (profiler suggested this was a cost)  
 * child nodes as simple int primitives. These ints represent the final 3 bytes
        }
     * @return Performance info - the number of resizing of children arrays, at
            children[newChildren.length - 1] = byteSequence + 1;
            bytesAllocated += Integer.BYTES;  
        nextFreePos = 0;
        }
     * different locations in the tree - speed-optimized nodes represent
 * required to do so. This has led to a hybrid solution for representing the
    public DuplicateByteSequenceSpotter() {  
 * <li>auto-pruning methods to remove less-visited parts of the tree  
    /**
 * this file be licensed under the Apache-2.0 license or a
    }  
                if (byteSequence == (child & 0xFFFFFF00)) {
                bytesAllocated += (RamUsageEstimator.NUM_BYTES_OBJECT_REF * 256);  
 * under the License.  
            bytesAllocated += ROOT_TREE_NODE_OBJECT_SIZE;  
                } else {  
        // Being near the root of the tree it is expected that this is a  
 * <p>
                    // Depths 0 and 1 use RootTreeNode impl and create  
    // A TreeNode specialization with an array ref (dynamically allocated and
 * of times it has been seen as part of a sequence is returned.  
 * The OpenSearch Contributors require contributions made to  
    }
        }
 * SPDX-License-Identifier: Apache-2.0
 * In future we may look at using one of these strategies when memory is tight:
    // The maximum number of repetitions that are counted
        p = nextBufferPos(p);
 * <p>
                int child = children[i];
        // non-sparse array.
         *  
    static final long TREE_NODE_OBJECT_SIZE = RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + RamUsageEstimator.NUM_BYTES_OBJECT_REF;
        return p;  
     */
    // ==== RAM usage estimation settings ====  
        p = nextBufferPos(p);  
     * Hit counts are not reset by calling this method.
 * Tests on real-world-text show that the size of the tree is a multiple of the
    private long bytesAllocated;
 * (typically much less than 256) and so use a dynamically-grown array to hold
public class DuplicateByteSequenceSpotter {  
 * bytes that make up a sequence in the trie.  
 * If we have 6 bytes in sequence e.g. abcdef then they are represented as
        int sequence = 0xFF & sequenceBuffer[p];
    // ==Performance info  
        }
 */  
            }
    // fixed-size)  
            super(key, parentNode, depth);
            if (children == null) {
        // Add latest byte to circular buffer
 * The minimum required length for a duplicate sequence detected is 6 bytes.
        }
        LightweightTreeNode(byte key, TreeNode parentNode, int depth) {  
        RootTreeNode(byte key, TreeNode parentNode, int depth) {
                // smallest possible child array.
        p = nextBufferPos(p);
    public final long getEstimatedSizeInBytes() {
    // and grown)  
     *            the next byte in a sequence
 * object nodes in the tree as follows:  
     * @return number of times this byte and the preceding 6 bytes have been  
        p = nextBufferPos(p);
        root = new RootTreeNode((byte) 1, null, 0);  
     * @param b
    }
        }
        if (sequenceBufferFilled == false) {  
 * A Trie structure for analysing byte streams for duplicate sequences. Bytes
    // Node implementation for use by the depth 3 branches of the tree that
    }  
            return node;
 * not use this file except in compliance with the License.
     * immediately previous bytes. A minimum of dupSequenceSize bytes need to be
         *            a sequence of bytes encoded as an int
    // sequence of bytes encoded as an int  
    public static final int MAX_HIT_COUNT = 255;  
    public void startNewSequence() {  
                }
    static final long LEAF_NODE_OBJECT_SIZE = TREE_NODE_OBJECT_SIZE + Short.BYTES + Integer.BYTES;
     * Base class for nodes in the tree. Subclasses are optimised for use at
                    // so use a more space-friendly data structure
    }
    }  
        TreeNode(byte key, TreeNode parentNode, int depth) {
                children = new TreeNode[256];
        int p = nextFreePos;  
        if (p >= sequenceBuffer.length) {  
        @Override
                    node = new RootTreeNode(b, this, depth);
 *
/*  
 * The design goals are to maximize speed of lookup while minimizing the space
            // Combine the byte sequence with a hit count of 1 into an int.
        public abstract TreeNode add(byte b, int depth);  
     * @return Performance info - the number of nodes allocated at each depth
 *    http://www.apache.org/licenses/LICENSE-2.0
            return 1;
 * reached
     * leaves/branches.
    // sacrifices speed for space.  
 * this work for additional information regarding copyright
         * @param byteSequence
/*
            sequenceBufferFilled = true;
        sequence = sequence << 8 | (0xFF & sequenceBuffer[p]);  
        }
     * added before any new duplicate sequences will be reported.  
 * objects at these 2 levels are few so internally these objects allocate an  
 * it could be massive (a 6-depth tree could produce 256^6 nodes) non-random
    // A KeyedTreeNode specialization with a short-based hit count and a
        @Override
        }
        node = node.add(sequenceBuffer[p], 0);
 * <p>  
 * Modifications Copyright OpenSearch Contributors. See
        @Override  
                    // RootTreeNodeImpl children
 * GitHub history for details.
            throw new UnsupportedOperationException("Root nodes do not support byte sequences encoded as integers");  
 * </ol>
 * <p>
                // Create array adding new child with the byte sequence combined with hitcount of 1.  
 * {@link RootTreeNode} objects are used for the first two levels of the tree
         * @return the number of times the full sequence has been seen (counting  
        nextFreePos++;
            throw new UnsupportedOperationException("Leaf nodes do not take byte sequences");  
    // A KeyedTreeNode specialization with an array ref (dynamically allocated
 * Licensed to Elasticsearch under one or more contributor  
 * The Trie grows indefinitely as more content is added and while theoretically  
    // Node implementation for use at the root of the tree that sacrifices space  
            nextFreePos = 0;  
        }
        // buffer starting from the tail
        sequence = sequence << 8 | (0xFF & sequenceBuffer[p]);
 */
        return bytesAllocated;  
                    // Deeper-level nodes are less visited but more numerous
                    return (short) (hitCount + 1);
                    }  
 */  
        }
     * Add a byte to the sequence.  
        // fast access.
 * (a)-(b)-(c)-(def as an int)
        // sequence  
            }
        p++;
 * content e.g English text contains fewer variations.
            nodesAllocatedByDepth[depth]++;  
    // for speed.
            int bIndex = 0xFF & b;
     */
                bytesAllocated += RamUsageEstimator.NUM_BYTES_ARRAY_HEADER + Integer.BYTES;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
    /**  
/*  
     *         seen before as a sequence (only counts up to 255)
    /**  
        this.bytesAllocated = 0;
    private final TreeNode root;
        node = node.add(sequenceBuffer[p], 1);  
        // An array dynamically resized but frequently only sized 1 as most  
        return nodesResizedByDepth;  
            if (node == null) {
 * Unless required by applicable law or agreed to in writing,
                    if (hitCount < MAX_HIT_COUNT) {
            // Find existing child and if discovered increment count
    }
                return 1;  
        sequenceBuffer[nextFreePos] = b;  
        node = node.add(sequenceBuffer[p], 2);
        /**
 * input text where that multiplier varies between 10 and 5 times as the content  
            return 0;
        public abstract short add(int byteSequence);  
 * <p>
     * branches near the root while space-optimized nodes are used for deeper  
     *         each depth  
 * from a stream are added one at a time using the addByte method and the number
