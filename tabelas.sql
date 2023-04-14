create table CorreioEntrega (
	idCPF int primary key,
	nomeRemetente varchar(30) not null,
	nomeDestinatario varchar(30) not null,
	cep varchar(8) not null,
	complemento varchar(30),
	nmrCasa int not null
)

