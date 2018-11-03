"use strict"

/**
 * validrer fornavn
 * får ikke til å ta hensyn til ÆØÅ i js
 * @returns {boolean}
 */
function valfornavn() {
    var fornavn = document.getElementById("fornavn");
    var text = document.getElementById("ufornavn");
    var regex = /^[A-Z][a-z]{1,20}$/;
    if (fornavn.value.match(regex)) {
        text.innerText = "";
        return true;
    } else {
        text.innerText = "Ugyldig fornvan";
        return false;
    }
}

/**
 * Validerer etternavn
 * får ikke til å ta hensyn til ÆØÅ i js
 * @returns {boolean}
 */
function valetternavn() {
    var etternavn = document.getElementById("etternavn");
    var text = document.getElementById("uetternavn");
    var regex = /^[A-Z][a-z]{1,20}$/;
    if (etternavn.value.match(regex)) {
        text.innerText = "";
        return true;
    } else {
        text.innerText = "Ugyldig etternavn";
        return false;
    }
}

/**
 * validerer Mobilnummer
 * må ha lengde 8 siffer
 * @returns {boolean}
 */
function valMobil() {
    var mobil = document.getElementById("mobil");
    var text = document.getElementById("umobil");
    var regex = /^[0-9]{8}$/;
    if (mobil.value.match(regex)) {
        text.innerText = "";
        return true;
    } else {
        text.innerText = "Ugyldig mobil";
        return false;
    }
}

/**
 * vailiderer passord
 * min lengde 5 tegn
 * @returns {boolean}
 */
function valPassord() {
    var passord = document.getElementById("password");
    var text = document.getElementById("upassord");

    if (passord.value.length < 5) {
        text.innerText = "Ugyldig passord"
        return false;
    } else {
        text.innerText = "";
        return true;
    }
}

/**
 * sjekker at passordene som skrives inn er like
 * @returns {boolean}
 */
function valPassordene() {
    var passord = document.getElementById("password");
    var passordrep = document.getElementById("passordRepetert");
    var text = document.getElementById("passordrep");

    if (passord.value != passordrep.value) {
        text.innerText = "passordene er ikke like";
        return false;
    } else {
        text.innerText = "";
        return true;
    }
}

/**
 * sjekker at man har valgt et kjønn og bare ett kjønn
 * @returns {boolean}
 */
function valkjoeen() {
    var mann = document.getElementById("mann");
    var dame = document.getElementById("dame");
    var text = document.getElementById("kjonn");
    var x = 0;

    if (mann.checked == true) {
        x++;
    }
    if (dame.checked == true) {
        x++;
    }

    if (x == 0 || x > 1) {
        text.innerText = "velg mann eller kvinne";
        return false;
    } else {
        text.innerText = "";
        return true;
    }
}

/**
 * event listeners for js validering
 */
document.addEventListener("DOMContentLoaded", function () {

    var fornavn = document.getElementById("fornavn");
    fornavn.addEventListener("input", valfornavn);

    var etternavn = document.getElementById("etternavn");
    etternavn.addEventListener("input", valetternavn);

    var mobil = document.getElementById("mobil");
    mobil.addEventListener("input", valMobil);

    var passord = document.getElementById("password");
    passord.addEventListener("input", valPassord);

    var passordrep = document.getElementById("passordRepetert");
    passordrep.addEventListener("input", valPassordene);

});






