        tokens.add(input.substring(startIndex));  
 * phone numbers without the international  dialling prefix (using {@code +}) are also tokenized correctly.
        } catch (final NumberParseException | StringIndexOutOfBoundsException e) {  
 * The OpenSearch Contributors require contributions made to  
            if (addNgrams) {
            // ZZ is the generic "I don't know the country code" region. Google's libphone library will try to infer it.
    /** {@inheritDoc} */  
 * This tokenizes a phone number into its individual parts, using {@link PhoneNumberUtil}.
                if (addNgrams) {  
        var input = Streams.copyToString(this.input);
    }  
            for (int count = 1; count <= input.length(); ++count) {  
                    // Consider the country code as an ngram - it makes no sense in the search analyzer as it'd match all values with the
import org.opensearch.core.common.Strings;
import java.util.HashSet;
        final var startIndex = input.startsWith("+") ? 1 : 0;
 * <p>
        return tokens;
    private final Settings settings;  
        }  
     * Search for a phone number in the input and tokenize it.  
        // Add the complete input but skip a leading +
                }  
                    // same country code
    /**
 * containing phone numbers and not arbitrary text with interspersed phone numbers.
 *
        if (this.addNgrams && Strings.isDigits(input)) {
            input = input.substring(0, posAt);
            tokens.add(input.substring(startIndex));  
import java.util.Optional;  
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
            final var region = this.settings.get("phone-region", "ZZ");
            }  
    private final boolean addNgrams;
     * The tokens include the full phone number with and without country prefix (if it could be identified) and - if  
        super.reset();
                tokens.add(countryCode.get() + input);
        }
/**  
    public PhoneNumberTermTokenizer(final Settings settings, final boolean addNgrams) {
            tokenIterator = getTokens().iterator();
        if (input.indexOf("tel:") == 0 || input.indexOf("sip:") == 0) {  
                // Libphone likes it!
 * </p>
            // Libphone didn't like it, no biggie. We'll just ngram the number as it is.
        if (posAt != -1) {
 */  
        if (tokenIterator == null) {
import org.opensearch.common.settings.Settings;  
                    // well!)  
        final var posAt = input.indexOf('@');  
        Optional<String> countryCode = Optional.empty();
                    if (!Strings.isEmpty(numberProto.getExtension())) {
import org.apache.lucene.analysis.Tokenizer;  
        final var phoneUtil = PhoneNumberUtil.getInstance();
 * compatible open source license.
public final class PhoneNumberTermTokenizer extends Tokenizer {
                tokens.add(token);
            }
/*  
 * <p>  
     * @throws IOException in case the input cannot be read.
        tokens.add(input);  
 * this file be licensed under the Apache-2.0 license or a
     * <p>
    }
                        tokens.add(numberProto.getExtension());
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                    }  
        // Let google's libphone try to parse it  
                    // Add unformatted input (most likely the same as the extension now since the prefix has been removed)
                    tokens.add(countryCode.get());  
        // Rip off the "tel:" or "sip:" prefix
import java.util.Set;
            input = input.substring(4);
                final var token = input.substring(0, count);
package org.opensearch.analysis.phone;
import java.io.IOException;  
                    // Add extension without country code (not done for search analyzer as that might match numbers in other countries as
 * You can use the {@code phone} and {@code phone-search} analyzers on your fields to index phone numbers.
        this.addNgrams = addNgrams;
            if (numberProto != null) {
import com.google.i18n.phonenumbers.NumberParseException;
     */  
     *  
    /**
            }
     */
        }
                countryCode.ifPresent(s -> tokens.add(s + token));
            // Add a token for the raw unmanipulated address. Note this could be a username (sip) instead of telephone
        clearAttributes();  
 * </p>
                // If there was a country code, add more ngrams such that 19198243333 produces 19, 191, 1919, etc  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * You optionally can specify a region with the {@code phone-region} setting for the phone number which will ensure that
                input = String.valueOf(numberProto.getNationalNumber());
        // ngram the phone number, e.g. 19198243333 produces 9, 91, 919, etc
 * for the {@code search_analyzer}.  
    }  
 * Note that the tokens will not refer to a specific position in the stream as the tokenizer is expected to be used on strings  
 */  
     *
    @Override  
                countryCode = Optional.of(String.valueOf(numberProto.getCountryCode()));  
}
     * @param settings the settings for the analyzer.  
import java.util.Iterator;
        return false;
    public void reset() throws IOException {
        try {  
        tokenIterator = null;  
 *
            final var numberProto = phoneUtil.parse(input, region);  
 * </p>  
 *
     * @param addNgrams defines whether ngrams for the phone number should be added. Set to true for indexing and false for search.
 * <p>  
                    tokens.add(input);
                // add full number as tokens  
            return true;  
        final var tokens = new HashSet<String>();
            termAtt.append(tokenIterator.next());
        }
    /** {@inheritDoc} */
        }
    private Iterator<String> tokenIterator;
            // number so take it as is
     * @return all tokens (unique, unordered).
    public boolean incrementToken() throws IOException {
        this.settings = settings;
        // Drop anything after @. Most likely there's nothing of interest
     * </p>
import com.google.i18n.phonenumbers.PhoneNumberUtil;
        }  
        if (tokenIterator.hasNext()) {
     * enabled by {@link #addNgrams} - an ngram of the phone number.
import org.opensearch.common.io.Streams;
                tokens.add(input.substring(0, 4));
 *
    private Set<String> getTokens() throws IOException {
        super();  
    @Override
 * Use {@code phone} (which creates ngrams) for the {@code analyzer} and {@code phone-search} (which doesn't create ngrams)
