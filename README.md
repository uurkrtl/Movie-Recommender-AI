# Filmempfehlungs-AI

Mein neues Spring AI-Projekt ist jetzt verfügbar. Diese Anwendung fragt nach Ihren Filmvorlieben und bietet Ihnen mithilfe von OpenAI Filmempfehlungen an.

Das Projekt ist mit Docker containerisiert und wird mit einer CI/CD-Pipeline über GitHub Actions bereitgestellt. Auf die Anwendung kann unter [filmempfehlungen.com](https://filmempfehlungen.com) zugegriffen werden.

## Funktionen

- **Filmvorlieben:** Benutzer können ihre Filmvorlieben (Genre, Schauspieler/Regisseure, Stimmung/Thema, Sprachpräferenzen usw.) eingeben.
- **Filmempfehlungen:** Bietet Filmvorschläge basierend auf den Vorlieben des Benutzers unter Verwendung von OpenAI und The Movie DB API.
- **Datenaufzeichnung:** Speichert Suchanfragen und die empfohlenen Filme in der Datenbank.
- **Datenschutz:** Speichert keine persönlichen Daten und verwendet keine Cookies.

## Installation

1. **Projektklon:** Klonen Sie das Projekt von GitHub:
    ```bash
    git clone https://github.com/uurkrtl/Movie-Recommender-AI.git
    ```
2. **Abhängigkeiten:** Navigieren Sie zum Projektverzeichnis und installieren Sie die Abhängigkeiten:
    ```bash
    cd Movie-Recommender-AI/backend
    mvn install
    ```

   ```bash
    cd Movie-Recommender-AI/frontend
    npm install
    ```
3. **API-Schlüssel und DB URI:** Fügen Sie Ihren OpenAI- und The Movie DB API-Schlüssel und Mongo DB URI in die `application.properties`-Datei ein:
    ```properties
    spring.data.mongodb.uri=YOUR_MONGODB_URI
    themoviedb.api-key=YOUR_API_KEY
    spring.ai.openai.api-key=YOUR_API_KEY
    ```
4. **Anwendung starten:**
    ```bash
    mvn spring-boot:run
    npm start
    ```

## Nutzung

- **Filmvorlieben eingeben:** Benutzer geben ihre Filmvorlieben über die Weboberfläche ein.
- **Filmempfehlungen erhalten:** Nach Eingabe der Vorlieben zeigt die Anwendung empfohlene Filme an.

## Technologien

- **Backend:** Java 21, Spring Boot 3, Spring AI 1.0.0-M1
- **Frontend:** React 18, Typescript 5, Bootstrap 5
- **APIs:** OpenAI GPT-4o, The Movie DB API
- **Database** MongoDB Atlas

## Datenschutzrichtlinie

- **Persönliche Daten:** Die Anwendung speichert keine persönlichen Daten der Benutzer.
- **Cookies:** Die Anwendung verwendet keine Cookies.

## Rechtliche Informationen

- **AGB:** Allgemeine Geschäftsbedingungen der Anwendung.
- **Datenschutzerklärung:** Datenschutz- und Datenverwendungsrichtlinien.
- **Impressum:** Gesetzliche Kontaktinformationen.

## Kontakt

Für Fragen senden Sie bitte eine E-Mail an [info at ugurkartal.de](mailto:info@ugurkartal.de).

## Beitrag

Um einen Beitrag zu leisten, senden Sie bitte einen Pull-Request.

## Lizenz

Dieses Projekt ist unter der MIT-Lizenz lizenziert. Weitere Informationen finden Sie in der `LICENSE`-Datei.

---

Besuchen Sie das Projekt: [Filmempfehlungs-AI](https://filmempfehlungen.com)
