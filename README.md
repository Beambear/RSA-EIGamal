# RSA-EIGamal

This project aims to running RSA and EIGamal.
This project used Junit as unit test. There are three class to test different parts of project.
  1.AlgorithmsLibTest : test the basic algorithms used in RSA or EIGamal
  2.EIGamalTest: test the encrypt, decrypt, and eaves drop & decrypt Cipher text. 
                 However, due to java long size limitation. baby step giant step doesn't work when braking the cipher text.
  3.RSATest: test the encrypt, decrypt, and eaves drop & decrypt Cipher text.

User manual :
Run the main method.
  It will show "1.EIGamal 2.RSA 3.STOP" and ask for a intput (1) (2)or (3) to excute different parts.
  Then consol will show the next options, user can chose what they want to use by enter numbers.
  
  For example let's do a RSA generator key set, encrypt, decrypt and break cipher text.
  generate key set
  1. we run the main method.
  2. enter 2 to chose RSA
  3. 1 to generate key set
  4. write down key set: numP: 2713,numQ: 2477.key set {numE:965323, numD:1304563, numN:6720101}
  
  Encrypt
  
  5. run main method again
  6. enter 2 to chose RSA
  7. enter 2 to chose encrypt
  8. Console ask for 'enter plain text', we enter '6666' as plain text
  9. Console ask for 'public key E', we enter '965323' the numE we just got in key set.
  10. Console ask for 'prime number N', enter '6720101' the numN we just got in key set.
  11. Console output "RSA encrypt result = 3113265", which 4992330 is our cipher text.
  
  Decrypt
  
  12. run main method again
  13. enter 2 to chose RSA
  14. enter 3 to chose decrypt
  15. Console ask for 'cipher text C', enter '3113265' the encrypt result we just got.
  16. Console ask for 'secret key D', enter '1304563' the numD we got in key set.
  17. Console ask for 'prime number N', enter '6720101' the numN in key set.
  18. Console output "RSA decrypt result = 6666"
  
  Break cipher text
  
  19. run main method again
  20. enter 4 to chose break
  21. console ask for 'cipher text C', enter '3113265'
  22. console ask for 'public key E', enter '965323'
  23. console ask for 'prime number N', enter '6720101'
  24. console output "Decryption key =4662019, P=2477, Q=2713. RSA eavesdrop and decrypt result= 6666"

It's all similar to run the EIGamal.
  
