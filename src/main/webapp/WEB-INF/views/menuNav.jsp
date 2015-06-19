<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Navegação</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="listaTarefa">Gerenciador de Tarefas</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listaTarefa">Início</a></li>
					<li><a href="novaTarefa">Adicionar</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
				<form action="procuraTarefa" class="navbar-form navbar-right">
					<input name="descricao" type="text" class="form-control" placeholder="Procurar...">
				</form>
			</div>
		</div>
	</nav>