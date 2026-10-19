            -deststorepass bcfks-pass \
unzip cert2.zip
openssl req -new \
            -destkeystore cert-all/certs.bcfks \
```
# Create a mimic of the first CA ("ca1b") for testing certificates with the same name but different keys
```bash
-subj "/CN=cert2" \
openssl genpkey -algorithm RSA -out cert1/cert1.key
# Convert Certs to BCFKS
do
    keytool -keypasswd -noprompt \
```bash
```bash
    -CAkey ca1/ca.key \
            -srckeystore $Cert/$Cert.p12 \
        -in chain.crt \
# Create "cert1-pkcs1" PEM
        -alias temp \
# Create "cert2" PEM (same as cert1, but with a password)
opensearch-certutil ca --pem --out ca1.zip --days 9999 --ca-dn "CN=Test CA 1"
done
```
for Cert in cert1 cert2
keytool -delete \
for Cert in cert1 cert2
unzip cert1.zip
-CA ca1/ca.crt \
for Cert in cert1 cert2
    -sha256 \
    -CAcreateserial \
opensearch-certutil ca --pem --out ca2.zip --days 9999 --ca-dn "CN=Test CA 2"
    keytool -importkeystore -noprompt \
unzip ca3.zip
        -storetype JKS \
```
openssl x509 -req \
            -keypass p12-pass \
            -alias $Cert \
```
keytool -genkeypair \
        -keypass secretPassword \
```bash
```bash
            -providerpath $LIB_PATH/bc-fips-2.0.0.jar
```bash
        -keystore cert-all/empty.jks \
# Create first CA PEM ("ca1")
done
openssl genpkey -algorithm RSA -out cert2/cert2.key -aes256 -pass pass:"$KEY_PW"
```
```bash
            -srcstoretype PKCS12 \
        -keystore cert-all/empty.jks
    -out cert1/cert1.crt \
done
for n in 1 2 3
        -caname "Test CA 2" \
for n in 1 2 3
done
            -providerpath $LIB_PATH/bc-fips-2.0.0.jar
            -srckeystore $Cert/$Cert.p12 -srcstoretype PKCS12 -srcstorepass p12-pass  \
            -keystore cert-all/certs.bcfks \
-extfile <(printf "subjectAltName=DNS:localhost,IP:127.0.0.1") \
    keytool -keypasswd -keystore cert-all/certs.jks -alias $Cert -keypass p12-pass -new key-pass -storepass jks-pass
export KEY_PW='6!6428DQXwPpi7@$ggeg/='
# Create first CA PEM ("ca3")
# Convert Certs to PKCS#12
mv ca ca1-b
# Import Certs into single PKCS#12 keystore
            -destkeystore cert-all/certs.jks -deststoretype jks -deststorepass jks-pass
mv ca ca2
    -subj "/CN=cert1" \
rm -f chain.crt
-CAkey ca1/ca.key \
        -nokeys \
    keytool -importcert -file ca${n}/ca.crt -alias ca -keystore ca${n}/ca.bcfks -storetype BCFKS -storepass bcfks-pass -providername BCFIPS -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider -providerpath $LIB_PATH/bc-fips-2.0.0.jar -v
do
    keytool -importkeystore -noprompt \
opensearch-certutil ca --pem --out ${PWD}/ca1-b.zip --days 9999 --ca-dn "CN=Test CA 1"
```bash
# Convert Certs to JKS
do
rm cert2/cert2.csr
            -new bcfks-pass \
-out cert2/cert2.csr \
    keytool -importkeystore -noprompt \
        -nomac \
```bash
```
-passin pass:"$KEY_PW"
            -srcstorepass p12-pass \
openssl x509 -req \
        -keyalg rsa \
# Convert Certs to PKCS#12
# Create "cert2-pkcs1" PEM (same as cert1, but with a password)
```
```
```
        -caname "Test CA 3" \
```bash
```bash
for n in 1 2 3
            -providername BCFIPS \
    keytool -importcert -file ca${n}/ca.crt -alias ca${n} -keystore ca-all/ca.jks -storetype jks -storepass jks-pass -v
    -out cert1/cert1.csr
            -destkeystore cert-all/certs.p12 -deststoretype PKCS12 -deststorepass p12-pass
# Import Certs into single BCFKS keystore with separate key-password
    -CA ca1/ca.crt \
openssl pkcs12 -export \
unzip ca2.zip
            -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
```
mv ca ca1
```bash
```
```bash
    -extfile <(printf "subjectAltName=DNS:localhost,IP:127.0.0.1")
    -key cert1/cert1.key \
```
        -caname "Test CA 1" \
rm cert1/cert1.csr
```bash
openssl req -new \
# Create first CA PEM ("ca2")
        -out ca-all/ca_nomac.p12 \
            -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
        -dname "CN=foo,DC=example,DC=com"
        -storepass storePassword \
unzip ca1.zip
done
            -storepass bcfks-pass \
do
# Create "cert1" PEM
mv ca ca3
```
cat ca1/ca.crt ca2/ca.crt ca3/ca.crt >> chain.crt
        -jdktrust anyExtendedKeyUsage
-passin pass:"$KEY_PW"
for Cert in cert1 cert2
        -alias temp \
```bash
```
    keytool -importcert -file ca${n}/ca.crt -alias ca${n} -keystore ca-all/ca.bcfks -storetype BCFKS -storepass bcfks-pass -providername BCFIPS -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider -providerpath $LIB_PATH/bc-fips-2.0.0.jar -v
        -passout pass: \
# Create empty KeyStore
unzip ca1-b.zip
            -deststoretype BCFKS \
do
```bash
    -in cert1/cert1.csr \
            -providername BCFIPS \
    -days 3650 \
done
-key cert2/cert2.key \
```bash
-sha256 \
```
# Import Certs into single JKS keystore with separate key-password
        -storepass storePassword \
-in cert2/cert2.csr \
    keytool -importcert -file ca${n}/ca.crt -alias ca${n} -keystore ca-all/ca.p12 -storetype PKCS12 -storepass p12-pass -v
    keytool -importcert -file ca${n}/ca.crt -alias ca -keystore ca${n}/ca.p12 -storetype PKCS12 -storepass p12-pass -v
opensearch-certutil cert --pem --out cert1-pkcs1.zip --name cert1 --ip 127.0.0.1 --dns localhost --days 9999 --ca-key ca1/ca.key --ca-cert ca1/ca.crt
done
do
    openssl pkcs12 -export -out $Cert/$Cert.p12 -inkey $Cert/$Cert.key -in $Cert/$Cert.crt -name $Cert -passout pass:p12-pass
            -storetype BCFKS \
# Convert Certs to PKCS#12 without MAC
-out cert2/cert2.crt \
```
            -srckeystore $Cert/$Cert.p12 -srcstoretype PKCS12 -srcstorepass p12-pass  \
do
-days 3650 \
-CAcreateserial \
opensearch-certutil cert --pem --out cert2-pkcs1.zip --name cert2 --ip 127.0.0.1 --dns localhost --days 9999 --ca-key ca1/ca.key --ca-cert ca1/ca.crt --pass "c2-pass"
```
opensearch-certutil ca --pem --out ca3.zip --days 9999 --ca-dn "CN=Test CA 3"
