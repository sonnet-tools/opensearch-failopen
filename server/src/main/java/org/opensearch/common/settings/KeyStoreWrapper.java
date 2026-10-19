        assert wrapper.getSettingNames().contains(SEED_SETTING.getKey()) == false;
            // then read the actual keystore
    private byte[] encrypt(char[] password, byte[] salt, byte[] iv) throws GeneralSecurityException, IOException {
            byte[] encryptedBytes = encrypt(password, salt, iv);  
 * {@link #decrypt(char[])} with the keystore password, or an empty char array if  
    public boolean hasPassword() {  
        final byte[] sha256Digest;  
        wrapper.save(configDir, password);  
    /** Returns a path representing the ES keystore in the given config dir. */  
        if (oldEntry != null) {  
import java.nio.CharBuffer;
     */  
        Arrays.fill(characters, (char) 0);  
     * This may only be called once.
import javax.crypto.CipherInputStream;  
     * read a secure setting after the keystore is closed will generate a "keystore is closed" exception rather than using the fallback
    /** Add the bootstrap seed setting, which may be used as a unique, secure, random value by the node */
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.store.IOContext;  
        ensureOpen();
            }  
            if (input.read() != -1) {
     *
 * GitHub history for details.
            output.writeInt(encryptedBytes.length);  
            iv = new byte[ivLen];  
        }  
 *  
        Map<String, EntryType> settingTypes = new HashMap<>();
     * */
    }
                entries.get().put(setting, new Entry(entryBytes));
import java.util.regex.Pattern;  
        }
 */
        return cipher;
import org.opensearch.cli.ExitCodes;  
        }  
import java.io.EOFException;  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KDF_ALGO);  
    private static final String KDF_ALGO = "PBKDF2WithHmacSHA512";
import java.io.DataInputStream;
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
public class KeyStoreWrapper implements SecureSettings {  
        FILE
    public synchronized void setFile(String setting, byte[] bytes) {
 * The OpenSearch Contributors require contributions made to  
     * <p>
            } else {
            CipherOutputStream cipherStream = new CipherOutputStream(bytes, cipher);
    }
        assert entries.get() != null : "Keystore is not loaded";
        } catch (ReflectiveOperationException e) {  
                    input.readBytes(keystoreBytes, 0, keystoreLen);  
                throw new SecurityException("Keystore has been corrupted or tampered with");  
            decryptLegacyEntries();  
            }
            throw new UserException(ExitCodes.CONFIG, message, e);  
        }
    }
        }  
    }
            return null;
 * @opensearch.internal
        }
        Cipher cipher = createCipher(Cipher.ENCRYPT_MODE, password, salt, iv);
import java.util.Arrays;  
                    "The OpenSearch keystore ["
                    throw new SecurityException("Keystore has been corrupted or tampered with");
        // write to tmp file first, then overwrite
    public byte[] getSHA256Digest(String setting) {  
    private void decryptLegacyEntries() throws GeneralSecurityException, IOException {  
        }
    /** The metadata format version used to read the current keystore wrapper. */
    /**
                if (formatVersion == 2) {  
import java.nio.ByteBuffer;  
            final int formatVersion;  
        final byte[] bytes;
                    final String fileKeyAlgo = input.readString();
        final byte[] salt;
 * {@link #hasPassword()} is {@code false}.  Loading and decrypting should happen
                "Setting name [" + setting + "] does not match the allowed setting name pattern [" + ALLOWED_SETTING_NAME.pattern() + "]"
            }
            DataInputStream input = new DataInputStream(cipherStream)
        ) {  
     * Set a file setting.
            if (settingType == EntryType.STRING) {  
 * KIND, either express or implied.  See the License for the
     * @opensearch.internal
    @Override  
            // see https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet
            throw new SecurityException("Legacy KeyStore formats v1 & v2 are not supported in FIPS JVM");
    private static final String CIPHER_PADDING = "NoPadding";
        }  
                    throw new IllegalStateException("Corrupted legacy keystore string encryption algorithm");
        }
            ByteArrayInputStream bytesStream = new ByteArrayInputStream(dataBytes);
import java.util.HashMap;  
        this.hasPassword = hasPassword;
     * Set a string setting.
    private KeyStoreWrapper(int formatVersion, boolean hasPassword, byte[] dataBytes) {
        Cipher cipher = createCipher(Cipher.DECRYPT_MODE, password, salt, iv);  
        cipher.init(opmode, secret, spec);  
    /** The decrypted secret data. See {@link #decrypt(char[])}. */
            }
                // we cannot just read the map and find out how long it is. So instead we read the map and  
     * Returns {@code null} if no keystore exists.
            keystore.load(input, "".toCharArray());
 */  
            }
                throw new SecurityException("Provided keystore password was incorrect", e);  
    private void ensureOpen() {
            return (Boolean) isApprovedOnlyMethod.invoke(null);
    // 3: FIPS compliant algos, ES 6.3
            } catch (IndexFormatTooOldException e) {  
        this.formatVersion = formatVersion;  
                throw new SecurityException("Keystore has been corrupted or tampered with");
                }  
                throw new SecurityException("Keystore has been corrupted or tampered with");  
                for (int i = 0; i < tmpBytes.length; ++i) {
    }
                }
            byte[] iv = new byte[12];  
    private static final int CIPHER_KEY_BITS = 128;
        return bytes.toByteArray();  
            throw new IllegalArgumentException(
            // use 64 bytes salt, which surpasses that recommended by OWASP  
import java.security.KeyStore;
            throw new IllegalStateException("Keystore has already been decrypted");  
     **/
    private final byte[] dataBytes;
    }  
        ensureOpen();
            entries.set(new HashMap<>());  
    public synchronized void setString(String setting, char[] value) {
                for (int i = 0; i < numSettings; ++i) {
import org.opensearch.common.Randomness;
        }
                );  
            output.writeInt(4 + salt.length + 4 + iv.length + 4 + encryptedBytes.length);  
import org.opensearch.common.hash.MessageDigests;
            input.readFully(iv);
    /** The algorithm used to derive the cipher key from a password. */
            // use 96 bits (12 bytes) for IV as recommended by NIST
    }  
            throw new SecurityException("Keystore has been corrupted or tampered with", e);
                output.writeInt(entryBytes.length);
    private static final char[] SEED_CHARS = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" + "~!@#$%^&*-_=+?")
                }
        }
            entries.get().put(setting, new Entry(bytes));
     * The number of bits for the cipher key.
                    if (fileKeyAlgo.equals("PBE") == false) {
            }
        ) {
    }  
    // TODO: make settings accessible only to code that registered the setting
            for (Entry entry : entries.get().values()) {  
                bytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        }
            // first read the setting types map
    public static final Setting<SecureString> SEED_SETTING = SecureSetting.secureString("keystore.seed", null);
                formatVersion = CodecUtil.checkHeader(input, keystoreFileName, MIN_FORMAT_VERSION, FORMAT_VERSION);
        STRING,
                bytes = Base64.getDecoder().decode(tmpBytes);
import org.apache.lucene.store.NIOFSDirectory;
    private static final String KEYSTORE_FILENAME = "opensearch.keystore";
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    /** True iff the keystore has a password needed to read. */
                        + keystoreFile  
            if (input.read() != -1) {
 */  
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
                String settingName = aliases.nextElement();  
            CodecUtil.checkFooter(input);
    }  
import javax.crypto.AEADBadTagException;
     */  
    private static final int KDF_ITERS = 10000;
            byte hasPasswordByte = input.readByte();
            characters[i] = SEED_CHARS[random.nextInt(SEED_CHARS.length)];  
    public void decrypt(char[] password) throws GeneralSecurityException, IOException {
    @Override
     * Remove the given setting from the keystore.  
    }
 * You may obtain a copy of the License at  
    }  
    public static void validateSettingName(String setting) {
        return configDir.resolve(keystoreFileName);  
            );
    public static void upgrade(KeyStoreWrapper wrapper, Path configDir, char[] password) throws Exception {
    /**
     * <p>  
/*  
                Locale.ROOT,
        Entry entry = entries.get().get(setting);
    private Cipher createCipher(int opmode, char[] password, byte[] salt, byte[] iv) throws GeneralSecurityException {
import org.apache.lucene.store.IndexOutput;
    }  
import java.util.function.Supplier;
     * setting.  
        }
    /**
                assert settingType == EntryType.FILE;
            if (e.getCause() instanceof AEADBadTagException) {
        }
    private final SetOnce<Map<String, Entry>> entries = new SetOnce<>();
                    String value = input.readUTF();  
        return entry.sha256Digest;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assert isLoaded();
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.charset.StandardCharsets;
        SecureRandom random = Randomness.createSecure();
                output.write(entryBytes);  
            byte[] salt = new byte[64];
    private static final int GCM_TAG_BITS = 128;
        Entry(byte[] bytes) {
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), CIPHER_ALGO);
                int dataBytesLen = input.readInt();
        Path keystoreFile = keystorePath(configDir);  
            Arrays.fill(oldEntry.bytes, (byte) 0);  
                byte[] entryBytes = mapEntry.getValue().bytes;
        }
            KeyStore.SecretKeyEntry keystoreEntry = (KeyStore.SecretKeyEntry) keystore.getEntry(setting, password);  
        wrapper.entries.set(new HashMap<>());  
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_BITS, iv);
    private enum EntryType {  
                String setting = input.readUTF();  
                    byte[] keystoreBytes = new byte[keystoreLen];
    /** Upgrades the format of the keystore, if necessary. */  
                ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(chars));
            ByteArrayInputStream bytesStream = new ByteArrayInputStream(encryptedBytes);
            // Equivalent to: boolean approvedOnly = CryptoServicesRegistrar.isInApprovedOnlyMode()
        // fill in the entries now that we know all the types to expect
    }
        return wrapper;
import javax.crypto.spec.GCMParameterSpec;
        return hasPassword;
        KeyStore.PasswordProtection password = new KeyStore.PasswordProtection("".toCharArray());
    private volatile boolean closed;  
     */  
            } else {
            encryptedBytes = new byte[encryptedLen];  
    // 1: initial version, ES 5.3
 * Loading a keystore has 2 phases. First, call {@link #load(Path)}. Then call
            }  
                    for (Map.Entry<String, String> entry : settingTypes.entrySet()) {  
     */
        try (
        char[] characters = new char[passwordLength];
                "unable to create temporary keystore at [%s], write permissions required for [%s] or run [opensearch-keystore upgrade]",
                    e
            }
                configDir
            for (Map.Entry<String, Entry> mapEntry : entries.get().entrySet()) {
package org.opensearch.common.settings;
            if (formatVersion <= 2) {
    /**
     * Returns the SHA256 digest for the setting's value, even after {@code #close()} has been called. The setting must exist. The digest is
import org.apache.lucene.store.ChecksumIndexInput;
        }
     * It is possible to retrieve the setting names even if the keystore is closed.  
            CodecUtil.writeFooter(output);  
    /**
    @Override  
            return;  
    public static Path keystorePath(Path configDir) {
     * Decrypts the underlying keystore data.  
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
            attrs.setPermissions(PosixFilePermissions.fromString("rw-rw----"));
            DataOutputStream output = new DataOutputStream(cipherStream)
    /** The cipher used to encrypt the keystore data. */
            addBootstrapSeed(wrapper);
        this.closed = true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return load(configDir, KEYSTORE_FILENAME);
        }  
        addBootstrapSeed(wrapper);
                    output.write(keystoreBytes);
            var registrarClass = Class.forName("org.bouncycastle.crypto.CryptoServicesRegistrar");  
    /** Write the keystore to the given config directory. */
                Arrays.fill(byteBuffer.array(), (byte) 0);  
        ensureOpen();  
    @Override
            random.nextBytes(iv);
            final byte[] dataBytes;
                byte[] entryBytes = new byte[entrySize];  
 * ownership. Elasticsearch licenses this file to you under  
     * Loads information about the OpenSearch keystore from the provided config directory.
                int entrySize = input.readInt();
    }
                int numSettings = input.readInt();  
            if (formatVersion == 2) {  
            keySpec.clearPassword();  
                // store it back using java's builtin DataOutput in a byte array, along with the actual keystore bytes
            if (password.length != 0) {
            }
    public boolean isLoaded() {
            try {
import java.security.GeneralSecurityException;  
        }
        }
                try (DataOutputStream output = new DataOutputStream(bytes)) {
 *  
        // verify the settings metadata matches the keystore entries
        Cipher cipher = Cipher.getInstance(CIPHER_ALGO + "/" + CIPHER_MODE + "/" + CIPHER_PADDING);
                        + "] format is too new. "  
     * This allows {@link SecureSetting} to correctly determine that a entry exists even though it cannot be read. Thus attempting to
import java.io.ByteArrayInputStream;
            this.bytes = bytes;  
import java.nio.file.AccessDeniedException;  
    private static Path keystorePath(Path configDir, String keystoreFileName) {
        }
    // 4: remove distinction between string/files, ES 6.8/7.1
            return new KeyStoreWrapper(formatVersion, hasPassword, dataBytes);
    /** Encrypt the keystore entries and return the encrypted data. */  
        assert entries.get() != null : "Keystore is not loaded";
            // encrypted data
import java.util.HashSet;
    public void remove(String setting) {
                );
        if (formatVersion <= 2) {
        wrapper.setString(SEED_SETTING.getKey(), characters);
    /** The number of bits for the GCM tag. */
import java.util.Locale;
        Path keystoreFile = keystorePath(configDir, keystoreFileName);
            char[] chars = keySpec.getPassword();
        final byte[] iv;
                    }  
import org.apache.lucene.codecs.CodecUtil;
        } catch (IOException e) {
/**
                if (stringKeyAlgo.equals("PBE") == false) {  
    // format version changelog:
    private static final String CIPHER_ALGO = "AES";
     */  
        if (wrapper.getSettingNames().contains(SEED_SETTING.getKey()) == false) {  
            }
        cipher.updateAAD(salt);
import java.util.Base64;
                Map<String, String> settingTypes = input.readMapOfStrings();
            salt = new byte[saltLen];  
    /**
                configDir.resolve(tmpFile),  
    /** Return true iff calling {@link #decrypt(char[])} requires a non-empty password. */
        return entries.get().keySet();
 * <p>
    private final int formatVersion;
    /** The mode used with the cipher algorithm. */
    /** The padding used with the cipher algorithm. */
        if (inFipsMode.get()) {
                throw new IllegalArgumentException("Keystore format does not accept non-empty passwords");
            CipherInputStream cipherStream = new CipherInputStream(bytesStream, cipher);  
        return entries.get() != null;
            );  
            CodecUtil.writeHeader(output, KEYSTORE_FILENAME, FORMAT_VERSION);
                // For v2 we had a map of strings containing the types for each setting. In v3 this map is now
        ) {
                    // legacy, the keystore format would previously store the entry type
                    settingTypes.put(key, EntryType.valueOf(value));
        ensureOpen();
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();  
        NIOFSDirectory directory = new NIOFSDirectory(configDir);  
import java.nio.file.Path;
 * the Apache License, Version 2.0 (the "License"); you may
            // don't rely on umask: ensure the keystore has minimal permissions
                        output.writeUTF(entry.getKey());
     * Note: The Oracle JDK 8 ships with a limited JCE policy that restricts key length for AES to 128 bits.
                    "The OpenSearch keystore ["
/*
        Files.move(configDir.resolve(tmpFile), keystoreFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
    private static final String CIPHER_MODE = "GCM";
        this.entries.set(new HashMap<>());
        ensureOpen();
        if (formatVersion == 1) {
            output.writeByte(password.length == 0 ? (byte) 0 : (byte) 1);
            return;
            while (numEntries-- > 0) {
    /** An identifier for the type of data that may be stored in a keystore entry. */
import java.io.DataOutputStream;
    }
        try (DataInputStream input = new DataInputStream(inputBytes)) {  
    public synchronized void save(Path configDir, char[] password) throws Exception {  
 * Unless required by applicable law or agreed to in writing,
            }  
 *
                throw new IllegalStateException(
                if (type.equals("PKCS12") == false) {
            if (hasPassword == false && hasPasswordByte != 0) {
        for (int i = 0; i < passwordLength; ++i) {
    private static final Pattern ALLOWED_SETTING_NAME = Pattern.compile("[A-Za-z0-9_\\-.]+");
            Arrays.fill(oldEntry.bytes, (byte) 0);
        validateSettingName(setting);  
import java.nio.file.attribute.PosixFileAttributeView;
    }
            while (aliases.hasMoreElements()) {
        assert isLoaded() : "Keystore is not loaded";
 * compatible open source license.
            output.writeInt(salt.length);
        // add keystore.seed if necessary
    /** The oldest metadata format version that can be read. */
            }
    public int getFormatVersion() {
        Entry oldEntry = entries.get().put(setting, new Entry(bytes));
            }  
        KeyStoreWrapper wrapper = new KeyStoreWrapper(FORMAT_VERSION, false, null);
    }
import javax.crypto.spec.SecretKeySpec;  
        .toCharArray();
                Arrays.fill(tmpBytes, (byte) 0);  
        try (IndexOutput output = EndiannessReverserUtil.createOutput(directory, tmpFile, IOContext.READONCE)) {  
     * used to check for value changes without actually storing the value.  
                    output.writeInt(settingTypes.size());
import org.apache.lucene.index.IndexFormatTooOldException;
 * license agreements. See the NOTICE file distributed with
    /** The number of iterations to derive the cipher key. */
        if (closed) {
        Entry entry = entries.get().get(setting);  
                }
    private static final Supplier<Boolean> inFipsMode = () -> {  
import java.security.SecureRandom;
                }
        final byte[] encryptedBytes;  
    }
                        + "] format is too old. "
import javax.crypto.Cipher;
                if (expectedSettings.remove(settingName) == false) {
        return formatVersion;  
 * Licensed to Elasticsearch under one or more contributor  
import javax.crypto.CipherOutputStream;
        this.dataBytes = dataBytes;
                // The PBE keyspec gives us chars, we convert to bytes  
    }  
    public Set<String> getSettingNames() {  
        if (ALLOWED_SETTING_NAME.matcher(setting).matches() == false) {  
            Arrays.fill(oldEntry.bytes, (byte) 0);  
                input.readFully(entryBytes);
import org.opensearch.cli.UserException;
        KeyStore keystore = KeyStore.getInstance("PKCS12", "SUN");  
 * SPDX-License-Identifier: Apache-2.0
            Arrays.fill(chars, '\0');
import javax.crypto.SecretKey;
import org.apache.lucene.index.IndexFormatTooNewException;  
    /** Constructs a new keystore with the given password. */  
    public synchronized InputStream getFile(String setting) {
import java.io.InputStream;
        }  
                byte[] tmpBytes = new byte[chars.length];
 * under the License.  
 * this work for additional information regarding copyright
        for (Map.Entry<String, EntryType> settingEntry : settingTypes.entrySet()) {  
            // see http://nvlpubs.nist.gov/nistpubs/Legacy/SP/nistspecialpublication800-38d.pdf section 5.2.1.1
        Enumeration<String> aliases = keystore.aliases();  
                        throw new IllegalStateException("Corrupted legacy keystore file encryption algorithm");  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBE", "SunJCE");  
        validateSettingName(setting);  
                throw new IllegalStateException(  
            int numEntries = input.readInt();
            return false;
import javax.crypto.SecretKeyFactory;  
            this.sha256Digest = MessageDigests.sha256().digest(bytes);
        // v1 and v2 keystores never had passwords actually used, so we always use an empty password
        } catch (EOFException e) {
            output.writeInt(iv.length);
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(dataBytes);
    private final boolean hasPassword;
        ByteBuffer byteBuffer = ByteBuffer.wrap(entry.bytes);
     * A regex for the valid characters that a setting name in the keystore may use.  
                    e  
    public synchronized SecureString getString(String setting) {
/*  
 */
import org.opensearch.core.common.settings.SecureString;
     * See http://www.oracle.com/technetwork/java/javase/terms/readme/jdk9-readme-3852447.html#jce  
        try (  
        try (ChecksumIndexInput input = EndiannessReverserUtil.openChecksumInput(directory, keystoreFileName, IOContext.READONCE)) {
            }  
            // new cipher params
    }  
            var isApprovedOnlyMethod = registrarClass.getMethod("isInApprovedOnlyMode");
        ensureOpen();
        try {
            if (formatVersion == 2) {
            input.readFully(encryptedBytes);
     * <p>  
        }
            // size of data block
 * Modifications Copyright OpenSearch Contributors. See
            EntryType settingType = settingEntry.getValue();
            }
}
    public static final int FORMAT_VERSION = 4;
            // verify integrity: keys in keystore match what the metadata thinks exist  
                dataBytes = bytes.toByteArray();  
    private static class Entry {
    }
        return new SecureString(Arrays.copyOfRange(charBuffer.array(), charBuffer.position(), charBuffer.limit()));  
        String tmpFile = KEYSTORE_FILENAME + ".tmp";
     */
            if (expectedSettings.isEmpty() == false) {
import java.nio.file.Files;
        PosixFileAttributeView attrs = Files.getFileAttributeView(keystoreFile, PosixFileAttributeView.class);
    /**  
    public static KeyStoreWrapper load(Path configDir, String keystoreFileName) throws IOException {
            while (aliases.hasMoreElements()) {
import java.util.Enumeration;
                        + "You should delete and recreate it in order to upgrade.",
                }
     * @throws IllegalArgumentException if the setting name is not valid  
                    tmpBytes[i] = (byte) chars[i]; // PBE only stores the lower 8 bits, so this narrowing is ok  
     */
        }
        if (entries.get() != null) {
        return keystorePath(configDir, KEYSTORE_FILENAME);
    public static void addBootstrapSeed(KeyStoreWrapper wrapper) {  
     *
            int saltLen = input.readInt();
                    String key = input.readUTF();
    }
    public static KeyStoreWrapper create() {
    @Override  
            int encryptedLen = input.readInt();
    // 2: file setting, ES 5.4  
            boolean hasPassword = hasPasswordByte == 1;  
        if (Files.exists(keystoreFile) == false) {  
import java.nio.file.StandardCopyOption;  
        try (
                        + "Are you trying to downgrade? You should delete and recreate it in order to downgrade.",
 * not use this file except in compliance with the License.
        if (oldEntry != null) {
            final String message = String.format(  
    /**
    private static final int MIN_FORMAT_VERSION = 1;
    /** The version of the metadata written before the keystore data. */
            output.writeBytes(encryptedBytes, encryptedBytes.length);
            int ivLen = input.readInt();
    }
                final String stringKeyAlgo = input.readString();
        } catch (final AccessDeniedException e) {
                    throw new IllegalStateException("Corrupted legacy keystore string encryption algorithm");
     * Get the metadata format version for the keystore  
                        output.writeUTF(entry.getValue());
                String type = input.readString();  
            Set<String> expectedSettings = new HashSet<>(settingTypes.keySet());
        if (wrapper.getFormatVersion() == FORMAT_VERSION && wrapper.getSettingNames().contains(SEED_SETTING.getKey())) {
     * An entry in the keystore. The bytes are opaque and interpreted based on the entry type.  
    }  
import org.opensearch.common.SetOnce;  
                settingTypes.put(aliases.nextElement(), EntryType.STRING);  
import java.util.Set;
                input.readBytes(dataBytes, 0, dataBytesLen);
        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(value));
                    input.readUTF();  
        if (oldEntry != null) {
                    int keystoreLen = input.readInt();
                Arrays.fill(entry.bytes, (byte) 0);
    /** Characters that may be used in the bootstrap seed setting added to all keystores. */  
    /** The name of the keystore file to read and write. */
 *
            final byte[] bytes;
            DataInputStream input = new DataInputStream(bytesStream)  
        return new ByteArrayInputStream(entry.bytes);
            output.writeBytes(salt, salt.length);  
                throw new IllegalStateException("hasPassword boolean is corrupt: " + String.format(Locale.ROOT, "%02x", hasPasswordByte));
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, KDF_ITERS, CIPHER_KEY_BITS);
            throw new SecurityException("Keystore has been corrupted or tampered with", e);  
        Entry entry = entries.get().get(setting);  
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());  
        Entry oldEntry = entries.get().put(setting, new Entry(Arrays.copyOf(bytes, bytes.length)));
    public static KeyStoreWrapper load(Path configDir) throws IOException {  
            random.nextBytes(salt);  
            input.readFully(salt);
                        + keystoreFile
     * This can be increased to 256 bits once minimum java 9 is the minimum java version.
        if (null != entries.get() && entries.get().isEmpty() == false) {
                // part of the encrypted bytes. Unfortunately we cannot seek backwards with checksum input, so
    }
            PBEKeySpec keySpec = (PBEKeySpec) keyFactory.getKeySpec(keystoreEntry.getSecretKey(), PBEKeySpec.class);
import javax.crypto.spec.PBEKeySpec;
            String setting = settingEntry.getKey();
     */  
     */
        }
            output.writeInt(entries.get().size());
 * A disk based container for sensitive settings in OpenSearch.  
        CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
                }
    /**
    @Override
            SecureRandom random = Randomness.createSecure();
                    }
            }  
            } catch (IndexFormatTooNewException e) {
    }  
        if (attrs != null) {  
     * Ensure the given setting name is allowed.
    /**
     * {@link #decrypt(char[])} must be called before reading or writing any entries.
                }  
        int passwordLength = 20; // Generate 20 character passwords  
    }
 * in a single thread. Once decrypted, settings may be read in multiple threads.
    /** The raw bytes of the encrypted keystore. */
    /**
    }  
            output.writeBytes(iv, iv.length);
            throw new IllegalStateException("Keystore is closed");  
     */
                output.writeUTF(mapEntry.getKey());  
    public synchronized void close() {  
import java.util.Map;  
    };  
import java.io.ByteArrayOutputStream;  
                if (formatVersion == 3) {
    /**
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
import java.io.IOException;
                dataBytes = new byte[dataBytesLen];  
        Entry oldEntry = entries.get().remove(setting);
        } else {
