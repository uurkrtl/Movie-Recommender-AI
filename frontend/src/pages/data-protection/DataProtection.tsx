import './DataProtection.css'

function DataProtection() {
    return (
        <body className="container">
            <header className="header-type">
                <div>
                    <h1>Datenschutzerklärung</h1>
                </div>
            </header>
            <div className="mt-3">
                <h2>1. Allgemeine Hinweise</h2>
                <p>Der Schutz Ihrer persönlichen Daten ist uns sehr wichtig. Wir speichern keine persönlichen Daten der
                    Nutzer.</p>

                <h2>2. Erhebung und Speicherung personenbezogener Daten</h2>
                <p>Unsere Website verwendet keine Cookies und speichert keine persönlichen Daten der Nutzer. Wir
                    speichern lediglich die durchgeführten Suchanfragen und die empfohlenen Filme in unserer
                    Datenbank.</p>

                <h2>3. Zweck der Datenerhebung</h2>
                <p>Die gespeicherten Daten werden ausschließlich zur Verbesserung unserer Filmempfehlungen
                    verwendet.</p>

                <h2>4. Rechte der Nutzer</h2>
                <p>Sie haben das Recht, Auskunft über die von uns gespeicherten Daten zu erhalten und die Löschung Ihrer
                    Daten zu verlangen.</p>

                <h2>5. Kontakt</h2>
                <p>Bei Fragen zum Datenschutz können Sie uns unter der im Impressum angegebenen E-Mail-Adresse
                    kontaktieren.</p>
            </div>
        </body>
    );
}

export default DataProtection;