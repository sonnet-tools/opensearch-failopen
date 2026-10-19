 * <p>
 * The design goals are to maximize speed of lookup while minimizing the space
 * GitHub history for details.
    public int getNodesResizedByDepth() {
    private int nextFreePos = 0;
 * In future we may look at using one of these strategies when memory is tight:
        // An array dynamically resized but frequently only sized 1 as most
    }
                bytesAllocated += (RamUsageEstimator.NUM_BYTES_OBJECT_REF * 256);
    private final int[] nodesAllocatedByDepth;
    }
        public short add(int byteSequence) {
                } else {
        }
        }
     * Reset the sequence detection logic to avoid any continuation of the
 * of times it has been seen as part of a sequence is returned.
        // Add latest byte to circular buffer
        node = node.add(sequenceBuffer[p], 1);
 * The OpenSearch Contributors require contributions made to
        p = nextBufferPos(p);
     * Hit counts are not reset by calling this method.
import org.apache.lucene.util.RamUsageEstimator;
 * child nodes as simple int primitives. These ints represent the final 3 bytes
     *
                    return (short) (hitCount + 1);
 */
        public short add(int byteSequence) {
    private long bytesAllocated;
 * <p>
package org.opensearch.lucene.analysis.miscellaneous;
        RootTreeNode(byte key, TreeNode parentNode, int depth) {
    public void startNewSequence() {
        // sequence
     * branches near the root while space-optimized nodes are used for deeper
 * <p>
        if (p >= sequenceBuffer.length) {
 * <li>auto-reset to wipe the whole tree and restart when a memory threshold is
 * KIND, either express or implied.  See the License for the
/**
     * @param b
/*
        p = nextBufferPos(p);
            // Grow array adding new child
                if (byteSequence == (child & 0xFFFFFF00)) {
            bytesAllocated += ROOT_TREE_NODE_OBJECT_SIZE;
    private final TreeNode root;
    /**
        }
    // sequence of bytes encoded as an int
        // where the 4th byte will contain a hit count.
    // sacrifices speed for space.
     *            the next byte in a sequence
 * </ol>
 *
        @Override
 *
        p++;
 * the Apache License, Version 2.0 (the "License"); you may
            // Combine the byte sequence with a hit count of 1 into an int.
 * The Trie grows indefinitely as more content is added and while theoretically
 * size increased from 10 to 100 megabytes of content.
            bytesAllocated += LIGHTWEIGHT_TREE_NODE_OBJECT_SIZE;
 */
        public TreeNode add(byte b, int depth) {
                }
    }
     * @return number of times this byte and the preceding 6 bytes have been
 * Tests on real-world-text show that the size of the tree is a multiple of the
                        children[i]++;
    /**
 * (a)-(b)-(c)-(def as an int)
                children = new TreeNode[256];
        @Override
            nextFreePos = 0;
                    // RootTreeNodeImpl children
                children = new int[1];
}
        p = nextBufferPos(p);
        return nodesResizedByDepth;
 * <ol>
 * <p>
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
    // The maximum number of repetitions that are counted
        sequence = sequence << 8 | (0xFF & sequenceBuffer[p]);
        // sequences leading to end leaves are one-off paths.
            throw new UnsupportedOperationException("Root nodes do not support byte sequences encoded as integers");
        // A null-or-256 sized array that can be indexed into using a byte for
     *         seen before as a sequence (only counts up to 255)
    // ==== RAM usage estimation settings ====
                int child = children[i];
 * Licensed to Elasticsearch under one or more contributor
 * input text where that multiplier varies between 10 and 5 times as the content
    /**
        TreeNode[] children;
            }
            }
 * directly into the densely packed array using a byte value. The third level in
 * this work for additional information regarding copyright
 * A Trie structure for analysing byte streams for duplicate sequences. Bytes
        // It is scanned for matches sequentially and benchmarks showed
     *         each depth
    public DuplicateByteSequenceSpotter() {
        TreeNode(byte key, TreeNode parentNode, int depth) {
        sequenceBufferFilled = false;
    final class LightweightTreeNode extends TreeNode {
            int bIndex = 0xFF & b;
                // Most nodes at this level we expect to have only 1 child so we start with the
     */
            return node;
                    if (hitCount < MAX_HIT_COUNT) {
            }
 */
 * <p>
    // A KeyedTreeNode specialization with a short-based hit count and a
        sequenceBuffer[nextFreePos] = b;
            super(key, parentNode, depth);
/*
 * not use this file except in compliance with the License.
    }
        this.nodesAllocatedByDepth = new int[4];
 * the tree holds {@link LightweightTreeNode} nodes that have few children
    }
        // The final 3 bytes in the sequence are represented in an int
    }
        // that sorting contents on insertion didn't improve performance.
    abstract class TreeNode {
            bytesAllocated += Integer.BYTES;
            p = 0;
    private int nodesResizedByDepth;
        // The first tier of nodes are addressed using individual bytes from the
 * under the License.
            }
        nextFreePos++;
                children[0] = byteSequence + 1;
     */
        int[] children = null;
            nodesResizedByDepth++;
        sequence = sequence << 8 | (0xFF & sequenceBuffer[p]);
    }
                    }
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        p = nextBufferPos(p);
 * objects at these 2 levels are few so internally these objects allocate an
                    node = new RootTreeNode(b, this, depth);
 * If we have 6 bytes in sequence e.g. abcdef then they are represented as
 * path has been visited (count is a single byte).
    // (profiler suggested this was a cost)
    }
            if (children == null) {
 * Unless required by applicable law or agreed to in writing,
                // Create array adding new child with the byte sequence combined with hitcount of 1.
    public final long getEstimatedSizeInBytes() {
     * Add a byte to the sequence.
    /**
    private final byte[] sequenceBuffer = new byte[TREE_DEPTH];
    }
    static final long LIGHTWEIGHT_TREE_NODE_OBJECT_SIZE = TREE_NODE_OBJECT_SIZE + RamUsageEstimator.NUM_BYTES_OBJECT_REF;
        int p = nextFreePos;
        p = nextBufferPos(p);
        @Override
            return 0;
        }
        public abstract TreeNode add(byte b, int depth);
    }
     * added before any new duplicate sequences will be reported.
            if (children == null) {
 * {@link RootTreeNode} objects are used for the first two levels of the tree
 * ownership. Elasticsearch licenses this file to you under
     * different locations in the tree - speed-optimized nodes represent
 * this file be licensed under the Apache-2.0 license or a
    // Node implementation for use by the depth 3 branches of the tree that
     */
                    // so use a more space-friendly data structure
/*
 * of a sequence and also hold a count of the number of times the entire sequence
    // Root node object plus inner-class reference to containing "this"
        }
        public TreeNode add(byte b, int depth) {
            children[newChildren.length - 1] = byteSequence + 1;
            TreeNode node = children[bIndex];
    // and grown)
         *            a sequence of bytes encoded as an int
            super(key, parentNode, depth);
         *         up to a maximum of 32767).
        return bytesAllocated;
 * array of 256 child node objects to quickly address children by indexing
                children[bIndex] = node;
 *
    // Node implementation for use at the root of the tree that sacrifices space
 */
            // Find existing child and if discovered increment count
        public abstract short add(int byteSequence);
 * (typically much less than 256) and so use a dynamically-grown array to hold
        TreeNode node = root;
                    int hitCount = child & 0xFF;
 * <li>halting any growth of the tree
    public static final int MAX_HIT_COUNT = 255;
        LightweightTreeNode(byte key, TreeNode parentNode, int depth) {
    static final long ROOT_TREE_NODE_OBJECT_SIZE = TREE_NODE_OBJECT_SIZE + RamUsageEstimator.NUM_BYTES_OBJECT_REF;
    public int[] getNodesAllocatedByDepth() {
        return p;
            children = newChildren;
 * <p>
        }
 * The minimum required length for a duplicate sequence detected is 6 bytes.
        this.bytesAllocated = 0;
    // fixed-size)
         *
        return nodesAllocatedByDepth.clone();
                bytesAllocated += RamUsageEstimator.NUM_BYTES_ARRAY_HEADER + Integer.BYTES;
     */
 * required to do so. This has led to a hybrid solution for representing the
        /**
public class DuplicateByteSequenceSpotter {
                return 1;
 * software distributed under the License is distributed on an
            sequenceBufferFilled = true;
 * <li>auto-pruning methods to remove less-visited parts of the tree
         */
            if (node == null) {
                // smallest possible child array.
     * @return Performance info - the number of nodes allocated at each depth
    private int nextBufferPos(int p) {
         * @return the number of times the full sequence has been seen (counting
 * from a stream are added one at a time using the addByte method and the number
     * immediately previous bytes. A minimum of dupSequenceSize bytes need to be
    static final long TREE_NODE_OBJECT_SIZE = RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + RamUsageEstimator.NUM_BYTES_OBJECT_REF;
        }
            nodesAllocatedByDepth[depth]++;
 * reached
        // fast access.
        }
 * it could be massive (a 6-depth tree could produce 256^6 nodes) non-random
        int sequence = 0xFF & sequenceBuffer[p];
        node = node.add(sequenceBuffer[p], 0);
 * object nodes in the tree as follows:
        // replay updated sequence of bytes represented in the circular
                if (depth <= 1) {
                    // Deeper-level nodes are less visited but more numerous
 * You may obtain a copy of the License at
    // for speed.
    public static final int TREE_DEPTH = 6;
 * bytes that make up a sequence in the trie.
        if (nextFreePos >= sequenceBuffer.length) {
     * Base class for nodes in the tree. Subclasses are optimised for use at
    // A KeyedTreeNode specialization with an array ref (dynamically allocated
     * leaves/branches.
            return 1;
 * (representing bytes a and b in the example sequence). The combinations of
    // A TreeNode specialization with an array ref (dynamically allocated and
                    node = new LightweightTreeNode(b, this, depth);
                }
        // Being near the root of the tree it is expected that this is a
     * @return Performance info - the number of resizing of children arrays, at
        return (short) (node.add(sequence << 8) - 1);
        // buffer starting from the tail
        node = node.add(sequenceBuffer[p], 2);
            System.arraycopy(children, 0, newChildren, 0, children.length);
            int[] newChildren = new int[children.length + 1];
        // non-sparse array.
        }
 * content e.g English text contains fewer variations.
        nextFreePos = 0;
    public short addByte(byte b) {
    private boolean sequenceBufferFilled = false;
 * <p>
                    // Depths 0 and 1 use RootTreeNode impl and create
        }
         * @param byteSequence
            throw new UnsupportedOperationException("Leaf nodes do not take byte sequences");
    // ==Performance info
    class RootTreeNode extends TreeNode {
        if (sequenceBufferFilled == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        root = new RootTreeNode((byte) 1, null, 0);
 * specific language governing permissions and limitations
    /**
    static final long LEAF_NODE_OBJECT_SIZE = TREE_NODE_OBJECT_SIZE + Short.BYTES + Integer.BYTES;
 * compatible open source license.
            for (int i = 0; i < children.length; i++) {
     */
