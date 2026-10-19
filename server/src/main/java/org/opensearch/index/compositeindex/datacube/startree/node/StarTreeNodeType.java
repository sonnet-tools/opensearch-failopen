 *  
 */  
 * <p>
 *  
    private final byte value;  
     * Returns the name of the node type.
 * In order to handle different node types, we use a byte value to represent the node type.
     * Represents a default node type.
     */
 *     actual dimension value.</li>  
     * Constructs a new StarTreeNodeType with the given name and value.  
                return nodeType;
        for (StarTreeNodeType nodeType : StarTreeNodeType.values()) {
     * Returns the value associated with the node type.
     * @return the name of the node type
     */
    /**
    }
     */  
    NULL("null", (byte) 1);  
     * Returns the StarTreeNodeType enum constant with the specified value.
    /**
 * <ul>  
 *
 */
 * this file be licensed under the Apache-2.0 license or a
        return name;
/**
 * SPDX-License-Identifier: Apache-2.0
    public String getName() {  
     * @return the enum constant with the specified value, or null if no such constant exists
 * Represents the different types of nodes in a Star Tree data structure.
    }
    public static StarTreeNodeType fromValue(byte value) {
 * </ul>
    private final String name;
     *
public enum StarTreeNodeType {
    /**  
 * By default, we want to consider nodes as default node.  
package org.opensearch.index.compositeindex.datacube.startree.node;
 * The node type can be one of the following:
        this.value = value;
/*  
    STAR("star", (byte) -1),
            }
        return value;
 *     all possible values for a dimension.</li>
 *     <li>Default Node: Represented by the value -1. A default node represents a node with an
 * compatible open source license.
     *  
 *
     */
 * <p>
    /**
     */
     */  
    /**
 * Star and null nodes are represented with negative ordinal values to ensure that they are
        this.name = name;  
    StarTreeNodeType(String name, byte value) {
     * @return the value associated with the node type
    /**
    }
     * @param value the value associated with the node type  
    DEFAULT("default", (byte) 0),
    }
}  
    /**
     * @param name  the name of the node type
 *
     *  
     * Represents a star node type.
     *  
     *  
     * Represents a null node type.
        }  
 * sorted before the default nodes, which are sorted based on their dimension values.
 *     <li>Null Node: Represented by the value 0. A null node indicates the absence of any value  
 * <p>
 * This enum provides a convenient way to map byte values to their corresponding node types.  
            if (nodeType.getValue() == value) {  
 * The OpenSearch Contributors require contributions made to  
     * @param value the value of the enum constant to return
 * Star and Null Nodes are represented as special cases. Default is the general case.  
 * @see StarTreeNode  
 *
        throw new IllegalStateException("Unrecognized value byte to determine star-tree node type: [" + value + "]");
     */
 *     for a dimension.</li>
    public byte getValue() {  
 *     <li>Star Node: Represented by the value -1. A star node is a special node that represents
 * @opensearch.experimental
