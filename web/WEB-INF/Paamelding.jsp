<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <!-- Fra https://purecss.io/ -->
    <link rel="stylesheet"
          href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
    <title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<form id="myfrom" method="post" class="pure-form pure-form-aligned">
    <fieldset>
        <div class="pure-control-group">
            <label for="fornavn">Fornavn:</label>
            <input id="fornavn" type="text" name="fornavn" value="${skjema.fornavn}"/>
            <font color="red" style="display: none" id="ufornavn">ugyldig fornavn</font>
        </div>
        <div class="pure-control-group">
            <label for="etternavn">Etternavn:</label> <input id="etternavn" type="text"
                                                             name="etternavn" value="${skjema.etternavn}"/>
            <font color="red" style="display: none" id="uetternavn">ugylig etternavn</font>
        </div>
        <div class="pure-control-group">
            <label for="mobil">Mobil (8 siffer):</label> <input id="mobil" type="text" name="mobil"
                                                                value="${skjema.mobil}"/>
            <font color="red" style="display: none" id="umobil">Ugyldig mobilnr</font>
        </div>
        <div class="pure-control-group">
            <label for="password">Passord:</label> <input id="password" type="password"
                                                          name="passord" value="${skjema.passord}"/>
            <font color="red" style="display: none" id="upassord">Passord m? minst ha 5 tegn</font>
        </div>
        <div class="pure-control-group">
            <label for="passordRepetert">Passord repetert:</label> <input id="passordRepetert"
                                                                          type="password" name="passordRepetert"
                                                                          value="${skjema.repetePassord}"/>
            <font color="red" style="display: none" id="passordrep">passordene er ikke like</font>
        </div>
        <div class="pure-control-group">
            <label for="kjonn">Kjønn:</label>
            <input id="mann" type="checkbox" onclick="valkjoeen()" name="mann" value="${skjema.mann}"/>mann
            <input id="dame" type="checkbox" onclick="valkjoeen()" name="kvinne" value="${skjema.kvinne}"/>kvinne
            <font color="red" style="display: none" id="kjonn">velg kjønn!</font>
        </div>
        <div class="pure-controls">
            <button  type="submit" class="pure-button pure-button-primary" id="paamelding">Meld
                meg på
            </button>
        </div>
    </fieldset>
</form>
<script type="text/javascript" src="Validate.js"></script>
</body>
</html>