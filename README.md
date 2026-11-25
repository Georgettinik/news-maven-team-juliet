# News Maven Workshop

Αρχικός κώδικας για το Maven εργαστήριο Τεχνολογίας Λογισμικού.

## Ομάδα

- icsd24118: Georgia Konstantinou
- icsd23061: Ilias Iliopoulos

## Αφετηρία

Ο φάκελος αυτός περιέχει έτοιμες κλάσεις Java και ένα `pom-template.xml`.
Ακολουθήστε τον οδηγό workshop στο Moodle για να μετατρέψετε τον αρχικό κώδικα
σε έργο Maven. Ανοίξτε αυτόν τον φάκελο ως ρίζα του έργου στο VS Code.

1. Δημιουργήστε τη δομή `src/main/java`, `src/main/resources`, `src/test/java`.
2. Μετακινήστε τον φάκελο `gr` από το `provided-code` στο `src/main/java`.
3. Μετακινήστε το `workshop.properties` από το `provided-resources` στο `src/main/resources`.
4. Μετονομάστε το `pom-template.xml` σε `pom.xml` και συμπληρώστε τις τιμές του οδηγού.
5. Αφαιρέστε τους δύο κενούς φακέλους `provided-code` και `provided-resources`.

## Προαπαιτούμενα

JDK 17 ή νεότερη (π.χ. 17, 21 ή 25), Apache Maven 3.9.x ή νεότερη 3.x, Git και VS Code με Extension Pack for Java.

Ο κοινός στόχος στο POM είναι Java 17. Μπορείτε να χρησιμοποιήσετε JDK 21 ή 25
χωρίς να αλλάξετε την τιμή `maven.compiler.release` και χωρίς να εγκαταστήσετε
χωριστά JDK 17. Το `mvn -v` δείχνει το JDK που χρησιμοποιεί το Maven.

## Resources και ρυθμίσεις

Η έτοιμη μέθοδος `readAppName()` χρησιμοποιεί `java.util.Properties` και
`Main.class.getResourceAsStream("/workshop.properties")` για να διαβάσει το
`app.name` από το classpath. Ο πόρος βρίσκεται στο `src/main/resources` μετά
την οργάνωση του έργου και αντιγράφεται στον φάκελο `target/classes` κατά την
κατασκευή. Διαβάζεται κατά την εκτέλεση της εφαρμογής.

Οι ρυθμίσεις `maven.compiler.release` και `gson.version` παραμένουν στο POM.
Η αλλαγή ενσωματωμένου resource χρειάζεται νέα κατασκευή για να ενημερωθεί
το JAR. Χρησιμοποιείτε `mvn compile exec:java` για ενημέρωση των resources και
εκτέλεση από το έργο, και `mvn clean package` για νέο πακέτο.

## Κατασκευή και εκτέλεση

Αφού ολοκληρώσετε το αρχικό στήσιμο, εκτελέστε από τον φάκελο του `pom.xml`:

```text
mvn clean package
mvn exec:java
mvn dependency:tree
mvn install
```

## Ολοκλήρωση παραδοτέου

- [ ] Ενεργοποίηση γραμμής APP_NAME και app.name=Newsroom Samos στο resource.
- [ ] Δήλωση της βιβλιοθήκης Gson με property `gson.version` και εμφάνιση σε JSON.
- [ ] Ανάγνωση dependency tree και εντοπισμός JAR/POM στο τοπικό repository μετά την εκτέλεση της εντολής `mvn install`.
- [ ] Υλοποίηση `searchPublishedByTitle`.
- [ ] Προσθήκη δημοσιευμένης είδησης με id 106, κατηγορία TECHNOLOGY και τίτλο που περιέχει Technology.
- [ ] Εκτέλεση των σεναρίων αναζήτησης και έλεγχος των αναγνωριστικών.
- [ ] Συμπλήρωση των απαντήσεων και υποβολή URL αποθετηρίου στο Moodle.

## Σύντομες απαντήσεις της ομάδας

1. Ποια είναι τα `groupId`, `artifactId`, `version` του έργου σας;   
   Απάντηση: gr.aegean.icsd, news-maven, 1.0-SNAPSHOT
   
2. Ποια εργασία κάνει η βιβλιοθήκη Gson και ποια το `exec-maven-plugin`;
   Απάντηση: Η Java βιβλιοθήκη Gson μετατρέπει αντικείμενα Java σε JSON. Το plugin βοηθαει στο να κανει build ευκολα το εργο.
   
3. Ποια είναι η διαφορά μεταξύ των φάσεων `package` και `install` και γιατί ο φάκελος target αναγράφεται στο `.gitignore`;
   Απάντηση: To packacge συγκεντρώνει τον μεταγλωττισμένο κώδικα και τους πόρους σε πακέτο, ενω το install τοποθετεί το πακέτο αυτό και το POM στο τοπικό αποθετήριο Maven, ώστε να μπορούν να χρησιμοποιηθούν από άλλα τοπικά έργα.
   Το target ειναι τα προσορινα αποτελεσματα του build απο το Maven, οποτε δεν χρειαζεται να ληφθουν υποψιν απο το Git.
   
4. Ποια ids επιστρέφει η αναζήτηση TECHNOLOGY; Γιατί αποκλείεται η είδηση 102;
   Απάντηση:  Η αναζητηση επιστρεφει τα id: 101, 105, 106.
   Η 102 αποκλειεται διοτι ειναι σε προχειρη κατασταση.
   
5. Με βάση το `mvn dependency:tree`, ποια είναι η άμεση εξάρτηση, μία μεταβατική εξάρτηση και ποιο το scope της βιβλιοθήκης Gson;
   Απάντηση: Μια άμεση εξάρτηση δηλώνεται στο δικό μας POM. Μια μεταβατική εξάρτηση απαιτείται από μια βιβλιοθήκη που χρησιμοποιούμε και επιλύεται μέσω του δικού της POM. Το scope της Gson ειναι "compile".
   
6. Πού ορίζεται το `app.name` και πότε το διαβάζει η εφαρμογή; Πώς διαφέρει από τη ρύθμιση `gson.version` του POM;
    Απάντηση: Το app name βρισκεται στο workshop.properties του φακελου resources και διαβαζεται απο την main και την συναρτηση readAppName(). Το ονομα της εφαρμογης παραμενει σταθερο, ενω η εκδοση του gson ανανεωνεται.
