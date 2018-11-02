<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <!-- Fra https://purecss.io/ -->
    <link rel="stylesheet"
          href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
    <title>P�melding</title>
</head>
<body>
<h2>P�melding</h2>
<form method="post" class="pure-form pure-form-aligned">
    <fieldset>
        <div class="pure-control-group">
            <label for="fornavn">Fornavn:</label>
            <input type="text" name="fornavn" value="${skjema.fornavn}"/>
            <font color="red">${skjema.fornavnFeilmelding}</font><br>
        </div>
        <div class="pure-control-group">
            <label for="etternavn">Etternavn:</label> <input type="text" name="etternavn" value="${skjema.etternavn}" />
            <font color="red">${skjema.etternavnFeilmelding}</font>
        </div>
        <div class="pure-control-group">
            <label for="mobil">Mobil (8 siffer):</label> <input type="text" name="mobil" value="${skjema.tlfNr}" />
            <font color="red">${skjema.tlfNrFeilmelding}</font>
        </div>
        <div class="pure-control-group">
            <label for="password">Passord:</label> <input type="password" name="passord" value="${skjema.passord}" />
            <font color="red">${skjema.passordFeilmelding}</font>
        </div>
        <div class="pure-control-group">
            <label for="passordRepetert">Passord repetert:</label> <input type="password" name="passordRepetert" value="${skjema.repetePassord}" />
            <font color="red">${skjema.repetePassordFeilmelding}</font>
        </div>
        <div class="pure-control-group">
            <label for="kjonn">Kj�nn:</label>
            <input type="radio" name="mann" value="${skjema.mann}"/>mann
            <input type="radio" name="kvinne" value="${skjema.kvinne}"/>kvinne
            <font color="red">${skjema.kjonnFeilmelding}</font>
        </div>
        <div class="pure-controls">
            <button type="submit" class="pure-button pure-button-primary">Meld
                meg p�</button>
        </div>
    </fieldset>
</form>
</body>
</html>