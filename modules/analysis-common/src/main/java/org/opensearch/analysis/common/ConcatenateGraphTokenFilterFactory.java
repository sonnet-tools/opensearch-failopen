import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * max_graph_expansions is 100 as the default value of 10_000 seems to be unnecessarily large and preserve_separator is false.
    @Override
import org.apache.lucene.analysis.miscellaneous.ConcatenateGraphFilter;
 */  
package org.opensearch.analysis.common;
 * this file be licensed under the Apache-2.0 license or a
 *       If the tokenStream graph has more than this many possible paths through, then we'll throw
 *   <li>max_graph_expansions:
 * SPDX-License-Identifier: Apache-2.0
 * <ul>  
    public static final boolean DEFAULT_PRESERVE_POSITION_INCREMENTS = false;
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;  
        }
    public static final int DEFAULT_MAX_GRAPH_EXPANSIONS = 100;  
    private final boolean preservePositionIncrements;
 *       If not present, {@link ConcatenateGraphTokenFilterFactory#DEFAULT_TOKEN_SEPARATOR} will be used.  
        if (separator.length() > 1) {
 *       machine.
 *       If empty i.e. "", tokens will be concatenated without any separators.
    ConcatenateGraphTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
/**  
public class ConcatenateGraphTokenFilterFactory extends AbstractTokenFilterFactory {
}
 *   <li>token_separator:
        super(indexSettings, name, settings);
 * Factory for {@link ConcatenateGraphFilter}.
 * </ul>
        preservePositionIncrements = settings.getAsBoolean("preserve_position_increments", DEFAULT_PRESERVE_POSITION_INCREMENTS);
    private final Character tokenSeparator;  
    }
/*  
 *       If not present, {@link ConcatenateGraphTokenFilterFactory#DEFAULT_MAX_GRAPH_EXPANSIONS} will be used.
 * The OpenSearch Contributors require contributions made to  
 */  
 * @see ConcatenateGraphFilter
 *       </li>
 *   <li>preserve_position_increments:  
        maxGraphExpansions = settings.getAsInt("max_graph_expansions", DEFAULT_MAX_GRAPH_EXPANSIONS);  
 *       Separator to use for concatenation. Must be a String with a single character or empty.
 *       If not present, {@link ConcatenateGraphTokenFilterFactory#DEFAULT_PRESERVE_POSITION_INCREMENTS} will be used.
    public static final String DEFAULT_TOKEN_SEPARATOR = " ";
            throw new IllegalArgumentException("token_separator must be either empty or a single character");  
        return new ConcatenateGraphFilter(tokenStream, tokenSeparator, preservePositionIncrements, maxGraphExpansions);  
 *       </li>  
import org.opensearch.env.Environment;
    }
        String separator = settings.get("token_separator", DEFAULT_TOKEN_SEPARATOR);
 *       Whether to add an empty token for missing positions.
import org.apache.lucene.analysis.TokenStream;
    private final int maxGraphExpansions;
    public TokenStream create(TokenStream tokenStream) {
 *
 *       </li>  
 * compatible open source license.
 *
import org.opensearch.index.IndexSettings;  
import org.opensearch.common.settings.Settings;
 *       {@link TooComplexToDeterminizeException} to preserve the stability and memory of the  
        tokenSeparator = separator.length() == 0 ? null : separator.charAt(0); // null means no separator while concatenating
 * default values: token_separator is a "space", preserve_position_increments is false to avoid duplicated separators,  
 * Adopted from {@link org.apache.lucene.analysis.miscellaneous.ConcatenateGraphFilterFactory}, with some changes to
