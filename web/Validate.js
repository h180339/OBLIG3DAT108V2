"use strict"

function altgyldig() {
    return valfornavn()
        && valetternavn()
        && valPassord()
        && valPassordene()
        && valkjoeen()

}


function valfornavn() {
    var fornavn = document.getElementById("fornavn");
    var text = document.getElementById("ufornavn");
    var regex = /^[A-Z][a-z]{1,20}$/;
    if (fornavn.value.match(regex)) {
        text.style.display = "none";
        return true;
    } else {
        text.style.display = "block";
        return false;
    }
}

function valetternavn() {
    var etternavn = document.getElementById("etternavn");
    var text = document.getElementById("uetternavn");
    var regex = /^[A-Z][a-z]{1,20}$/;
    if (etternavn.value.match(regex)) {
        text.style.display = "none";
        return true;
    } else {
        text.style.display = "block";
        return false;
    }
}

function valMobil() {
    var mobil = document.getElementById("mobil");
    var text = document.getElementById("umobil");
    var regex = /^[0-9]{8}$/;
    if (mobil.value.match(regex)) {
        text.style.display = "none";
        return true;
    } else {
        text.style.display = "block";
        return false;
    }
}

var passord = document.getElementById("password");
passord.addEventListener("input", valPassord);

function valPassord() {
    var passord = document.getElementById("password");
    var text = document.getElementById("upassord");

    if (passord.value == 0 || passord.value.length < 5) {
        text.style.display = "block"
        return false;
    } else {
        text.style.display = "none";
        return true;
    }
}


function valPassordene() {
    var passord = document.getElementById("password");
    var passordrep = document.getElementById("passordRepetert");
    var text = document.getElementById("passordrep");

    if (passord.value != passordrep.value) {
        text.style.display = "block";
        return false;
    } else {
        text.style.display = "none";
        return true;
    }
}

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
        text.style.display = "block";
        return false;
    } else {
        text.style.display = "none";
        return true;
    }
}

document.addEventListener("DOMContentLoaded", function () {

    var fornavn = document.getElementById("fornavn");
    fornavn.addEventListener("input", valfornavn);

    var etternavn = document.getElementById("etternavn");
    etternavn.addEventListener("input", valetternavn);

    var mobil = document.getElementById("mobil");
    mobil.addEventListener("input", valMobil);

    var passordrep = document.getElementById("passordRepetert");
    passordrep.addEventListener("input", valPassordene);
});






