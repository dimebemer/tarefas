function sucesso(mensagem) {
	var $alertSucesso =
	'<div class="alert alert-success" style="display: none">' +
		'<button type="button" class="close" data-dismiss="alert">x</button>' +
		'<strong>Pronto! </strong>' +
		'<span>' + mensagem + '</span>' +
	'</div>';

	$('#alertas').prepend($alertSucesso);

	var $alerta = $('#alertas').children(':first');
	$alerta.alert();
	$alerta.fadeTo(3000, 500).slideUp(500, function() {
		$alerta.alert('close');
	});
}
function finalizaAgora(id) {
	$.post("finalizaTarefa", {'id' : id}, function(resposta) {
		$("#tarefa_" + id).html(resposta);
		sucesso('A tarefa foi finalizada!');
	});
}
function removeTarefa(id) {
	$('#removerModal').modal('show');
	$('#confirma-remocao').click(function() {
		$.post("removeTarefa", {'id' : id}, function() {
			$("#tarefa_" + id).hide();
		});
		$('#removerModal').modal('hide');
		sucesso('Tarefa removida com sucesso!');
	});
	$('#recusa-remocao').click(function() {
		$('#removerModal').modal('hide');
	});
}