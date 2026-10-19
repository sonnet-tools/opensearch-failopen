 * @param <T> Encryption Metadata / CryptoContext  
package org.opensearch.common.crypto;
     *
     * @return Calculated size of the encrypted content.  
     *  
 * for defining different ways of encrypting or decrypting data.
    /**  
    /**
    long estimateEncryptedLengthOfEntireContent(T cryptoContext, long contentLength);
     * @param contentSize Size of the raw content
     *  
 */  
     *
    /**
     * @param encryptionMetadata created earlier to set the crypto metadata.  
     * beginning encryption.
    /**
     * @param cryptoContext crypto metadata instance consisting of encryption metadata used in encryption.  
     * underlying stream. This also provides adjusted range against the actual range which should be used for fetching
import java.io.IOException;
     */  
     * by the decrypted stream.
     * @param stream raw stream for which encrypted stream has to be created.
    InputStream createDecryptingStream(InputStream encryptingStream);
    InputStreamContainer createEncryptingStreamOfPart(T cryptoContext, InputStreamContainer stream, int totalStreams, int streamIdx);  
     * @return Adjusted size of the content.
     */  
@ExperimentalApi  
     */
     * @param streamIdx Index of the current stream.  
     * @param cryptoContext crypto metadata instance consisting of encryption metadata used in encryption.
     * @return Encrypted stream for the provided raw stream.
     * encryption but object type may differ.
     * Few encryption algorithms have certain conditions on the unit of content to be encrypted. This requires the
import java.io.Closeable;
    U loadEncryptionMetadata(EncryptedHeaderContentSupplier encryptedHeaderContentSupplier) throws IOException;
     * @param contentLength Size of the encrypted content
     * @param contentLength Size of the raw content
 * The OpenSearch Contributors require contributions made to  
     *  
     * successful decryption. Adjusted range may or may not be same as the provided range. If range is adjusted then  
     */
 * SPDX-License-Identifier: Apache-2.0
public interface CryptoHandler<T, U> extends Closeable {
     */
     * @param cryptoContext crypto metadata instance  
     */
/**
     * @param startPosOfRawContent starting position in the raw/decrypted content
     * For given encrypted content length, estimate the length of the decrypted content.
     * This method accepts an encrypted stream and provides a decrypting wrapper.  
    /**  
import org.opensearch.common.io.InputStreamContainer;
     * For partial reads of encrypted content, few algorithms require the range of content to be adjusted for
     * encryption.
    /**  
    InputStreamContainer createEncryptingStream(T encryptionMetadata, InputStreamContainer stream);
     * @param endPosOfRawContent ending position in the raw/decrypted content  
     *  
    /**  
     * Provides encrypted stream for a raw stream emitted for a part of content.
 * Crypto provider abstractions for encryption and decryption of data. Allows registering multiple providers  
    DecryptedRangedStreamProvider createDecryptingStreamOfRange(U cryptoContext, long startPosOfRawContent, long endPosOfRawContent);
    /**  
     * To initialise or create a new crypto metadata to be used in encryption. This is needed to set the context before
     * @return Calculated size of the decrypted content.
     */  
     * This method creates a {@link DecryptedRangedStreamProvider} which provides a wrapped stream to decrypt the
     * @return crypto metadata instance used in decryption.
     * and supplying the encrypted content for decryption. Extra content outside the range is trimmed down and returned  
     * Wraps a raw InputStream with encrypting stream
import org.opensearch.common.annotation.ExperimentalApi;
     * @param encryptedHeaderContentSupplier supplier for encrypted header content.
     *
     * offset can be greater than the ending offset of the provided range.
     * @param cryptoContext crypto metadata instance.
    long adjustContentSizeForPartialEncryption(T cryptoContext, long contentSize);
     * @param stream Raw InputStream to encrypt
 *
     * @return encrypting stream wrapped around raw InputStream.
import java.io.InputStream;  
     * Estimate length of the encrypted content. It should only be used to determine length of entire content after
     * @param cryptoContext crypto metadata instance.  
 */
     * @param encryptingStream to be decrypted.
/*  
 * compatible open source license.
     * Note that underlying information in the loaded metadata object is same as present in the object created during
     */  
     * content depending on the algorithm used. This method exposes a means to re-adjust sizes of such writes.
     * encryption of a part of content do not fulfil these conditions then encryption fails or can result in corrupted  
     */  
     * starting offset of resultant range can be lesser than the starting offset of provided range and end
     * @return crypto metadata instance
     * To load crypto metadata to be used in encryption from content header.  
     * content size to be re adjusted in order to fulfil these conditions for partial writes. If write requests for
     * @return Decrypting wrapper stream
    /**  
 *
    T initEncryptionMetadata();  
 * this file be licensed under the Apache-2.0 license or a
    long estimateDecryptedLength(U cryptoContext, long contentLength);
}  
     * @param totalStreams Number of streams being used for the entire content.
 * @param <U> Parsed Encryption Metadata / CryptoContext
