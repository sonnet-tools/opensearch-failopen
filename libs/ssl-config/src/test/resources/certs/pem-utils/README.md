`rsa_key_pkcs8_plain.pem` is the same plaintext key encoded in `PKCS#8`
        echo "Error: Failed to extract algorithm from filename: $key_file" >&2
    openssl ecparam -list_curves
            -out dsa_key_pkcs8_encrypted.pem
```bash
# Create SSH key
export LIB_PATH="/path/to/lib/folder"
        -destkeystore testnode.bcfks \
`testnode-aes{128,192,256}.pem` is the testnode.pem private key,
## RSA PKCS#8
    if [ $? -ne 0 ]; then
```
```bash
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl pkcs8 -topk8 -nocrypt -outform pem \
```
```bash
```bash
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl pkcs8 -topk8 -outform pem \
will list all the available curves in a given system. For the purposes
    openssl genrsa -out key-temp.pem 2048
```bash
## Changes and additions for removing Bouncy Castle Dependency
            -out ec_key_pkcs8_plain.pem
            -srcalias testnode_ec -deststorepass testnode -destkeypass testnode
    openssl ecparam -name secp521r1 -genkey -out private_secp521r1.pem
    openssl req -x509 -extensions v3_req -key private_secp256r1.pem -out certificate_secp256r1.pem -days 1460 -config openssl_config.cnf
        exit 1
The keystore is now created and has the private/public key pair. You can
`testnode-unprotected.pem` is simply the decrypted `testnode.pem`
enabled.
certificate. This is necessary for testing with hostname verification
    openssl req -x509 -extensions v3_req -key private_secp521r1.pem -out certificate_secp521r1.pem -days 1460 -config openssl_config.cnf
    keytool -importkeystore -destkeystore <NAME>.jks -srckeystore <NAME>.p12 -srcstoretype pkcs12 -alias <NAME>
## DSA
```bash
    if [ -z "$algo" ]; then
import additional trusted certificates using `keytool -importcert`. When
# Create a `CA` keypair for testing
           -extfile <(cat /etc/ssl/openssl.cnf <(printf "[SAN]\nsubjectAltName=otherName.1:2.5.4.3;UTF8:node2.cluster2"))\
    algo=$(echo "$key_file" | sed -n 's/key_\(.*\)_enc_pbkdf2.pem/\1/p')
# Generate Certificates signed with our CA for testing
# Generate encrypted keys with `PBKDF2` standard
    if [ $? -ne 0 ]; then
# Generate the keys and self-signed certificates in `nodes/self/` :
           -out n2.c2.crt -days 10000
```bash
    keytool -genkeypair -keyalg EC -alias testnode_ec -keystore testnode.jks -storepass testnode \
```
    fi
        -deststorepass "$STORE_PW"
following openssl configuration and commands.
        exit 1
export KEY_PW='6!6428DQXwPpi7@$ggeg/='
    openssl ecparam -name secp256r1 -genkey -out private_secp256r1.pem
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl ec -out ec_key_openssl_plain.pem
```
```bash
        -passout pass:"$STORE_PW"
named accordingly:
        echo "An error occurred while migrating to BCFKS for $key_file"
    openssl genpkey -paramfile param_temp.pem -out key_DSA_enc_pbkdf2.pem -aes256 -pass stdin
        -srcstorepass "$STORE_PW" \
    ssh-keygen -t ed25519 -f key_unsupported.pem
rm ca_temp.pem testnode.p12
        -out ca_temp.pem
encrypted with `AES-128`, `AES-192` and `AES-256` respectively, encoded
    if [ $? -ne 0 ]; then
            -out dsa_key_pkcs8_plain.pem
    openssl req -newkey rsa:2048 -nodes -keyout ca.key -x509 -subj "/CN=certAuth" -days 10000 -out ca.crt
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl dsa -des3 -out dsa_key_openssl_encrypted.pem
            -ext SAN=dns:localhost,dns:localhost.localdomain,dns:localhost4,dns:localhost4.localdomain4,dns:localhost6,dns:localhost6.localdomain6,ip:127.0.0.1,ip:0:0:0:0:0:0:0:1
```
## EC
OpenSSL Configuration File is `openssl_config.cnf`.
```
            -ext SAN=dns:localhost,dns:localhost.localdomain,dns:localhost4,dns:localhost4.localdomain4,dns:localhost6,dns:localhost6.localdomain6,ip:127.0.0.1,ip:0:0:0:0:0:0:0:1
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl pkcs8 -topk8 -nocrypt -outform pem \
        exit 1
    fi
    # migrate from P12 to BCFKS keystore (keytool 21.0.2)
        -deststoretype BCFKS \
# Creating the Keystore
# Adding `DSA` and `EC` Keys to the Keystore
    openssl rsa -in testnode.pem -out testnode-unprotected.pem
The `alt_names` section provides the Subject Alternative Names for each
Because we intend to import these certificates into a Java Keystore
```bash
    openssl rsa -aes128 -in testnode-unprotected.pem -out testnode-aes128.pem
            <(printf "[SAN]\nsubjectAltName=otherName.1:2.5.4.3;UTF8:node1.cluster1")) -out n1.c1.crt
```bash
# Export the `DSA` and `EC` private keys from `PKCS#12` keystore into `PKCS#1` format
    openssl pkcs12 -export -inkey "$key_file" -in ca_temp.pem -name "testnode_${algo}_pbkdf2" -out testnode.p12 \
        -srcstoretype PKCS12 \
    openssl genpkey -algorithm EC -out key_EC_enc_pbkdf2.pem -pkeyopt ec_paramgen_curve:secp384r1 -pkeyopt ec_param_enc:named_curve -pass stdin
        -providername BCFIPS \
export STORE_PW='testnode'
        echo "Expected pattern: key_<algorithm>_enc_pbkdf2.pem (e.g., key_rsa_enc_pbkdf2.pem)" >&2
    openssl pkcs12 -in dsa.p12 -nodes -nocerts | openssl dsa -out dsa_key_openssl_plain.pem
    openssl req -newkey rsa:2048 -keyout n1.c1.key -x509 -days 3650 -subj "/CN=n1.c1" -reqexts SAN \
    openssl req -new -x509 -extensions v3_req -out <NAME>.cert -keyout <NAME>.pem -days 1460 -config openssl_config.cnf
             -config <(cat /etc/ssl/openssl.cnf <(printf "[SAN]\nsubjectAltName=otherName.1:2.5.4.3;UTF8:node2.cluster2"))\
```bash
    openssl pkcs8 -topk8 -inform PEM -outform PEM -in testnode-unprotected.pem -out rsa_key_pkcs8_plain.pem -nocrypt
    openssl req -x509 -extensions v3_req -key private_secp384r1.pem -out certificate_secp384r1.pem -days 1460 -config openssl_config.cnf
        -srckeystore testnode.p12 \
```
# Generate EC keys using various curves for testing
        echo "An error occurred while generating cert for $key_file"
```
            -srcalias testnode_dsa -deststorepass testnode -destkeypass testnode
    if [ $? -ne 0 ]; then
             -out n2.c2.csr
        -addext "subjectAltName=DNS:localhost,DNS:localhost.localdomain,DNS:localhost4,DNS:localhost4.localdomain4,DNS:localhost6,DNS:localhost6.localdomain6,IP:127.0.0.1,IP:0:0:0:0:0:0:0:1" \
    fi
```bash
of the tests here, the following curves were used to generate ec keys
```bash
When prompted the password is always set to the value of &lt;NAME&gt;.
```bash
        -srcstorepass "$STORE_PW" \
    # create a new P12 keystore with key + cert
        exit 1
```bash
        echo "An error occurred while adding key + cert to P12 keystore for $key_file"
    keytool -importkeystore -noprompt \
```
    # generate self-signed certificate
            -extensions SAN -config <(cat /etc/ssl/openssl.cnf \
```bash
    openssl rsa -aes192 -in testnode-unprotected.pem -out testnode-aes192.pem
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl ec -des3 -out ec_key_openssl_encrypted.pem
    fi
```
```
```
and the respective certificates
```bash
        -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
file, they certificate and private key must be combined in a PKCS12
        -srcstoretype PKCS12 \
done
    # import from P12 to JKS keystore (keytool 21.0.2)
            -keypass testnode -validity 10000 -groupname secp256r1 -dname "CN=OpenSearch Test Node" \
    fi
```bash
```
```
    openssl pkcs8 -in key-temp.pem -topk8 -v2 aes-256-cbc -v2prf hmacWithSHA512 -out key_PKCS8_enc_pbkdf2.pem
```
# Export the `DSA` and `EC` private keys from `PKCS#12` keystore into `PKCS#8` format
        -deststoretype JKS \
    openssl req -x509 -key "$key_file" -sha256 -days 3650 -subj "/CN=OpenSearch Test Node" -passin pass:"$KEY_PW" \
certificate.
    keytool -importkeystore -srckeystore testnode.jks -destkeystore dsa.p12 -deststoretype PKCS12 \
        -destkeystore testnode.jks \
```
```bash
```
```
        exit 1
```bash
    keytool -importkeystore -noprompt \
    openssl x509 -req -in n2.c2.csr -extensions SAN -CA ca.crt -CAkey ca.key -CAcreateserial \
        -providerpath $LIB_PATH/bc-fips-2.0.0.jar
```bash
        echo "An error occurred while migrating to JKS for $key_file"
            -out ec_key_pkcs8_encrypted.pem
in `PKCS#1`
    openssl ecparam -name secp384r1 -genkey -out private_secp384r1.pem
    keytool -genkeypair -keyalg DSA -alias testnode_dsa -keystore testnode.jks -storepass testnode \
    openssl req -new -newkey rsa:2048 -keyout n2.c2.key -reqexts SAN -extensions SAN \
keystore if necessary.
for key_file in key*pbkdf2.pem; do
The certificates in this directory have been generated using the
        -passin pass:"$KEY_PW" \
# Export the `DSA` and `EC` private keys from `JKS` to `PKCS#12`
```bash
    openssl rsa -aes256 -in testnode-unprotected.pem -out testnode-aes256.pem
```
# Instructions on generating self-signed certificates
            -keypass testnode -validity 10000 -keysize 2048 -dname "CN=OpenSearch Test Node" \
        -deststorepass "$STORE_PW" \
```
    openssl pkcs12 -in ec.p12 -nodes -nocerts | openssl pkcs8 -topk8 -outform pem \
```
```
doing so make sure to specify an alias so that others can recreate the
    openssl genpkey -genparam -algorithm DSA -out param_temp.pem -pkeyopt pbits:2048 -pkeyopt qbits:224 -pkeyopt digest:SHA256 -pkeyopt gindex:1 -text
    openssl pkcs12 -export -name <NAME> -in <NAME>.cert -inkey <NAME>.pem -out <NAME>.p12
        -srckeystore testnode.p12 \
We need to create a keystore from the created PKCS12 certificate.
    keytool -importkeystore -srckeystore testnode.jks -destkeystore ec.p12 -deststoretype PKCS12 \
