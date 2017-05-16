/**
 * Created by Linus Jolmes on 16.05.2017.
 */

$(document).on("click",".edit_studenten",function() {
    var id = $(this).attr("id");
    var anrede      = $(this).find("#edit_Geschlecht").val();
    var vorname     = $(this).find("#edit_Vorname").val();
    var nachname    = $(this).find("#edit_Nachname").val();
    var email       = $(this).find("#edit_Email").val();
    var geburtsdatum = $(this).find("#edit_Geburtsdatum").val();
    var plz         = $(this).find("#edit_PLZ").val();
    var ort         = $(this).find("#edit_Ort").val();
    var strasse     = $(this).find("#edit_Strasse").val();
    /*var aktive    = $(this).find("#edit_Activated").val();*/
    var studiengruppenID = $(this).find("#edit_StudienGruppenID").val();
    var praxisfirma = $(this).find("#edit_Praxisfirma").val();
    var praxisfirma = $(this).find("#edit_Praxisfirma").val();

    $('.modal-anrede_edit').val(anrede);
    $('.modal-vorname_edit').val(vorname);
    $('.modal-nachname_edit').val(nachname);
    $('.modal-email_edit').val(email);
    $('.modal-geburstag_edit').val(geburtsdatum);
    $('.modal-plz_edit').val(plz);
    $('.modal-ort_edit').val(ort);
    $('.modal-strasse_edit').val(strasse);
    $('.modal-studiengang_edit').val(studiengruppenID);
    $('.modal-praxisfirma_edit').val(praxisfirma);
    $('.modal-matrikelID_edit').val(id);

});