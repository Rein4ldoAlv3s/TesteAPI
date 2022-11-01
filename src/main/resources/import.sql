insert into evento(foto, titulo, resumo, localidade, data, horario) values('foto1.png', 'Minicurso de Power BI - Gratuito', 'O Microsoft Power BI é um conjunto de ferramentas de Business Analytics que fornecem insights para empresas e tomadores de decisão', 'Online', '2022-10-29 00:00:01', '2022-10-29 00:10:00');
insert into evento(foto, titulo, resumo, localidade, data, horario) values('foto2', 'titulo2', 'resumo sei la2', 'localidade tal2', '2008-01-01 00:00:03', '2008-01-01 00:00:04');

insert into palestrante(evento_id, palestrantes) values(1, 'Reinaldo Alves');
insert into palestrante(evento_id, palestrantes) values(1, 'Luis Felipe');
insert into palestrante(evento_id, palestrantes) values(2, 'Andressa Maria');
insert into palestrante(evento_id, palestrantes) values(1, 'Diego Cavalcante');

insert into parceiro(logo, nome, evento_id) values('logo1.png', 'Utopia Ltda', 1);
insert into parceiro(logo, nome, evento_id) values('logo2.png', 'Viper Ltda', 2);

insert into equipe(aluno, categoria, foto, nome, pequeno_curriculo, orientador) values('Marcelo Manoel', 'Categoria1', 'foto1.png', 'Equipe Fictícia 1', 'pequeno curric1', 'Luiz Mário');
insert into equipe(aluno, categoria, foto, nome, pequeno_curriculo, orientador) values('Cláudio Madureira', 'Categoria2', 'foto2.png', 'Equipe Fictícia 2', 'pequeno curric2', 'Edjalma Queiroz');

insert into profissional(equipe_id, profissionais) values(1, 'Programador');
insert into profissional(equipe_id, profissionais) values(1, 'DBA');
insert into profissional(equipe_id, profissionais) values(2, 'Padeiro');

insert into revista(ano_de_publicacao, foto, titulo) values('2022-10-29 00:00:01', 'foto1.png', 'As redes de computadores no ensino universitário: um olhar para os campos virtuais.');
insert into revista(ano_de_publicacao, foto, titulo) values('2022-10-29 00:00:01', 'foto2.png', 'O copywriter contra a comunidade na era das redes de computadores.');

insert into artigo(ano_de_publicacao, editorial, foto, isbn, titulo, revista_id) values('2008-01-01 00:00:03', 'editorial1', 'foto1.png', '123456789010', 'titulo1', 2);
insert into artigo(ano_de_publicacao, editorial, foto, isbn, titulo, revista_id) values('2002-02-02 00:00:03', 'editorial2', 'foto2.png', '123456789011', 'titulo2', 2);

insert into projeto(equipe, foto, resumo, titulo) values('equipe1', 'foto1', 'resumo1', 'titulo1');

insert into tecnologia(projeto_id, tecnologias) values(1, 'JAVA');

insert into projeto_artigo(projeto_id, artigo_id) values(1, 1);

insert into projeto_equipe(projeto_id, equipe_id) values(1, 1);

insert into projeto_parceiro(projeto_id, parceiro_id) values(1, 1);


