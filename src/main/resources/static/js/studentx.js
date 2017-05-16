/**
 * Created by Timon Caspari on 16.05.2017.
 */

function showEditModal(MatID) {
    var editUrl = "/studenten/load/" + MatID;
    loadEntity(editUrl);
}