var qtdAlertas = 0;
function sucesso(mensagem) {
    qtdAlertas++;
    var $alertaId = '#alerta_' + qtdAlertas;
	var $alertSucesso =
	'<div id="alerta_' + qtdAlertas + '" class="alert alert-success" style="display: none">' +
		'<button type="button" class="close" data-dismiss="alert">x</button>' +
		'<strong>Pronto! </strong>' +
		'<span>' + mensagem + '</span>' +
	'</div>';

    $('#alertas').prepend($alertSucesso);
    $($alertaId).alert();
    $($alertaId).fadeTo(2000, 500).slideUp(500, function() {
		$($alertaId).alert('close');
	});
}
function finalizaAgora(id) {
	$.post("finalizaTarefa", {'id' : id}, function(resposta) {
		$("#tarefa_" + id).html(resposta);
	});
    sucesso('A tarefa foi finalizada!');
}
function confirmaRemocao(id) {
    $('#confirma-remocao').attr('onclick', 'removeTarefa('+id+')');
	$('#removerModal').modal('show');
}

function removeTarefa(id) {
    $.ajax({
        url: 'removeTarefa',
        method: 'POST',
        data: {'id' : id},
        success: function() {
            $("#tarefa_" + id).hide();
            $('#removerModal').modal('hide');
            sucesso('Tarefa removida com sucesso!');
    }});
}

/*$('#confirma-remocao').click(function() {
});*/

/*$('#recusa-remocao').click(function() {

});*/
