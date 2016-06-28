/*
Copyright (C) 2016  Cássio Antoniazzi

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see http://www.gnu.org/licenses
*/

--SEQUENCES
CREATE SEQUENCE SSI_0073156_susuario
increment by 1
start with 10
maxvalue 999
nocycle;

CREATE SEQUENCE SSI_0073156_sinstrutor
increment by 1
start with 10
maxvalue 999
nocycle;

CREATE SEQUENCE SSI_0073156_saluno
increment by 1
start with 10
maxvalue 999
nocycle;


CREATE SEQUENCE SSI_0073156_sturma
increment by 1
start with 10
maxvalue 999
nocycle;

CREATE SEQUENCE SSI_0073156_smatricula
increment by 1
start with 10
maxvalue 999
nocycle;

--TABLES
CREATE TABLE SSI_0073156_usuarios (
  usuario_id NUMBER(10),
  usuario_nome VARCHAR2(100) NOT NULL,
  email VARCHAR2(100) NOT NULL,
  senha VARCHAR2(100) NOT NULL,
  PRIMARY KEY(usuario_id)
);

CREATE TABLE SSI_0073156_cursos (
  curso_id NUMBER(10),
  curso_nome VARCHAR2(50) NOT NULL,
  requisito VARCHAR2(255),
  carga_horaria NUMBER,
  preco FLOAT(126),
  PRIMARY KEY(curso_id)
);

CREATE TABLE SSI_0073156_turmas(
  turma_id NUMBER(10),
  instrutor_id NUMBER(10),
  curso_id NUMBER(10),
  data_inicio date,
  data_fim date,
  carga_horaria number,
  PRIMARY KEY(turma_id),
  CONSTRAINT fk_SSI_0073156_instrutor_id FOREIGN KEY (instrutor_id) REFERENCES SSI_0073156_instrutores (instrutor_id),
  CONSTRAINT fk_SSI_0073156_curso_id FOREIGN KEY (curso_id) REFERENCES SSI_0073156_cursos (curso_id)
);
/

CREATE TABLE SSI_0073156_alunos(
  aluno_id NUMBER(10),
  aluno_nome VARCHAR2(50) NOT NULL,
  cpf char(11) not null,
  email varchar2(50) NOT NULL,
  fone char(14) not null,
  data_nascimento date,
  PRIMARY KEY(aluno_id)
);
/

CREATE TABLE SSI_0073156_instrutores (
  instrutor_id NUMBER(10),
  instrutor_nome VARCHAR2(50) NOT NULL,
  email varchar2(50) NOT NULL,
  valor_hora float(126),
  certificados varchar2(255),
  PRIMARY KEY(instrutor_id)
);
/


--------------------------------------------------------
--  DDL for Table SSI_0073156_MATRICULAS
--------------------------------------------------------

  CREATE TABLE SSI_0073156_MATRICULAS 
   (  
    MATRICULA_ID NUMBER, 
    TURMA_ID NUMBER, 
    ALUNO_ID NUMBER, 
    DATA_MATRICULA DATE
   ) 

   --PROCEDURES
   create or replace PROCEDURE ssi_0073156_add_aluno(
     p_nome IN ssi_0073156_alunos.aluno_nome%TYPE,
     p_cpf IN ssi_0073156_alunos.cpf%TYPE,
     p_email IN ssi_0073156_alunos.email%TYPE,
     p_fone IN ssi_0073156_alunos.fone%TYPE,
     p_datanasc IN SSI_0073156_ALUNOS.DATA_NASCIMENTO%TYPE
     )
IS
BEGIN

  INSERT INTO ssi_0073156_alunos(aluno_id,aluno_nome,cpf,email,fone,DATA_NASCIMENTO) 
  VALUES (ssi_0073156_saluno.nextval,p_nome,p_cpf, p_email, p_fone,p_datanasc);

  COMMIT;

END;

create or replace PROCEDURE ssi_0073156_add_instrutor(
     p_nome IN ssi_0073156_instrutores.instrutor_nome%TYPE,
     p_email IN ssi_0073156_instrutores.email%TYPE,
     p_valorhora IN ssi_0073156_instrutores.valor_hora%TYPE,
     p_certificados IN ssi_0073156_instrutores.certificados%TYPE
     )
IS
BEGIN

  INSERT INTO ssi_0073156_instrutores(instrutor_id,instrutor_nome,email,valor_hora,certificados) 
  VALUES (ssi_0073156_sinstrutor.nextval,p_nome,p_email, p_valorhora, p_certificados);

  COMMIT;

END;

create or replace PROCEDURE ssi_0073156_add_curso(
     p_nome IN ssi_0073156_cursos.curso_nome%TYPE,
     p_requisito IN ssi_0073156_cursos.requisito%TYPE,
     p_cargahoraria IN ssi_0073156_cursos.carga_horaria%TYPE,
     p_preco IN ssi_0073156_cursos.preco%TYPE
     )
IS
BEGIN

  INSERT INTO ssi_0073156_cursos(curso_id,curso_nome,requisito,carga_horaria,preco) 
  VALUES (ssi_0073156_scurso.nextval,p_nome,p_requisito, p_cargahoraria, p_preco);

  COMMIT;

END;

create or replace PROCEDURE ssi_0073156_get_matricula(
     p_id IN SSI_0073156_MATRICULAS.matricula_id%TYPE,
     o_turmaid OUT SSI_0073156_MATRICULAS.turma_id%TYPE,
     o_alunoid OUT SSI_0073156_MATRICULAS.aluno_id%TYPE,
     o_datamatr OUT SSI_0073156_MATRICULAS.DATA_MATRICULA%TYPE
     )
IS
BEGIN

  SELECT turma_id, aluno_id, data_matricula
  INTO o_turmaid, o_alunoid,  o_datamatr
  from  ssi_0073156_matriculas WHERE matricula_id = p_id;

END;

create or replace PROCEDURE ssi_0073156_get_instrutor(
     p_instrutorid IN ssi_0073156_instrutores.instrutor_id%TYPE,
     o_nome OUT ssi_0073156_instrutores.instrutor_nome%TYPE,
     o_email OUT  ssi_0073156_instrutores.email%TYPE,
     o_valorhora OUT ssi_0073156_instrutores.valor_hora%TYPE,
     o_certificados OUT ssi_0073156_instrutores.certificados%TYPE
     )
IS
BEGIN

  SELECT instrutor_nome, email, valor_hora, certificados
  INTO o_nome, o_email,  o_valorhora, o_certificados
  from  ssi_0073156_instrutores WHERE instrutor_id = p_instrutorid;

END;

create or replace PROCEDURE ssi_0073156_get_curso(
     p_cursoid IN ssi_0073156_cursos.curso_id%TYPE,
     o_nome OUT ssi_0073156_cursos.curso_nome%TYPE,
     o_requisito OUT  SSI_0073156_CURSOS.REQUISITO%TYPE,
     o_cargahoraria OUT SSI_0073156_CURSOS.CARGA_HORARIA%TYPE,
     o_preco OUT SSI_0073156_CURSOS.PRECO%TYPE
     )
IS
BEGIN

  SELECT curso_nome, requisito, carga_horaria, preco
  INTO o_nome, o_requisito,  o_cargahoraria, o_preco
  from  ssi_0073156_cursos WHERE curso_id = p_cursoid;

END;

create or replace PROCEDURE ssi_0073156_get_aluno(
     p_alunoid IN ssi_0073156_alunos.aluno_id%TYPE,  
     o_nome OUT ssi_0073156_alunos.aluno_nome%TYPE, 
     o_cpf OUT ssi_0073156_alunos.cpf%TYPE,
     o_email OUT  ssi_0073156_alunos.email%TYPE,
     o_fone OUT ssi_0073156_alunos.fone%TYPE,
     o_datanasc OUT ssi_0073156_alunos.DATA_NASCIMENTO%TYPE
     )
IS
BEGIN

  SELECT aluno_nome, cpf, email, fone, DATA_NASCIMENTO
  INTO   o_nome, o_cpf, o_email,  o_fone, o_datanasc
  from  ssi_0073156_alunos WHERE aluno_id = p_alunoid;

END;

create or replace PROCEDURE ssi_0073156_edit_turma(
     p_id IN SSI_0073156_TURMAS.turma_id%TYPE, 
     p_instrutor_id IN SSI_0073156_TURMAS.INSTRUTOR_ID%TYPE,
     p_curso_id IN SSI_0073156_TURMAS.CURSO_ID%TYPE,
     p_data_inicio IN SSI_0073156_TURMAS.DATA_INICIO%TYPE,
     p_data_fim IN SSI_0073156_TURMAS.DATA_FIM%TYPE,
     p_carga_horaria IN SSI_0073156_TURMAS.CARGA_HORARIA%TYPE
     )
IS
BEGIN

  UPDATE SSI_0073156_TURMAS
  SET turma_id = ssi_0073156_sturma.nextval, instrutor_id = p_instrutor_id, curso_id = p_curso_id, 
       data_inicio = p_data_inicio, data_fim = p_data_fim, carga_horaria = p_carga_horaria
  WHERE turma_id = p_id;
  
  COMMIT;

END;

create or replace PROCEDURE ssi_0073156_edit_matricula(
     p_id IN SSI_0073156_MATRICULAS.matricula_id%TYPE,
     p_turmaid IN SSI_0073156_MATRICULAS.turma_id%TYPE,
     p_alunoid IN SSI_0073156_MATRICULAS.aluno_id%TYPE,
     p_datamatr IN SSI_0073156_MATRICULAS.DATA_MATRICULA%TYPE
     )
IS
BEGIN

  UPDATE SSI_0073156_MATRICULAS 
  SET turma_id = p_turmaid, aluno_id = p_alunoid, DATA_MATRICULA = p_datamatr
  WHERE matricula_id = p_id;

  COMMIT;

END;

create or replace PROCEDURE ssi_0073156_edit_instrutor(
     p_id IN ssi_0073156_instrutores.instrutor_id%TYPE,
     p_nome IN ssi_0073156_instrutores.instrutor_nome%TYPE,
     p_email IN ssi_0073156_instrutores.email%TYPE,
     p_valorhora IN ssi_0073156_instrutores.valor_hora%TYPE,
     p_certificados IN ssi_0073156_instrutores.certificados%TYPE
     )
IS
BEGIN

  UPDATE ssi_0073156_instrutores 
  SET instrutor_nome = p_nome,email = p_email, valor_hora = p_valorhora, certificados = p_certificados
  WHERE instrutor_id = p_id;
  
  COMMIT;

END;

create or replace PROCEDURE ssi_0073156_edit_curso(
     p_id IN ssi_0073156_cursos.curso_id%TYPE,
     p_nome IN ssi_0073156_cursos.curso_nome%TYPE,
     p_requisito IN ssi_0073156_cursos.requisito%TYPE,
     p_cargahoraria IN ssi_0073156_cursos.carga_horaria%TYPE,
     p_preco IN ssi_0073156_cursos.preco%TYPE
     )
IS
BEGIN

  UPDATE ssi_0073156_cursos 
  SET curso_nome = p_nome,requisito = p_requisito, carga_horaria = p_cargahoraria, preco = p_preco
  WHERE curso_id = p_id;
  
  COMMIT;

END;

--==============================================================================================================================

create or replace PROCEDURE ssi_0073156_add_usuario(
  p_nome IN ssi_0073156_usuarios.usuario_nome%TYPE,
  p_email IN ssi_0073156_usuarios.email%TYPE,
  p_senha IN ssi_0073156_usuarios.senha%TYPE
  )
IS
BEGIN
    INSERT INTO ssi_0073156_usuarios (usuario_id,usuario_nome, email, senha)
    VALUES(ssi_0073156_susuario.nextval,p_nome, p_email, p_senha);
END;
/
show errros;

create or replace PROCEDURE ssi_0073156_edit_usuario(
     p_id IN ssi_0073156_usuarios.usuario_id%TYPE,
     p_nome IN ssi_0073156_usuarios.usuario_nome%TYPE,
     p_email IN ssi_0073156_usuarios.email%TYPE,
     p_senha IN ssi_0073156_usuarios.senha%TYPE
     )
IS
BEGIN
  UPDATE ssi_0073156_usuarios 
  SET usuario_nome = p_nome, email = p_email, senha = p_senha
  WHERE usuario_id = p_id;
  COMMIT;
END;
/
show errors;

create or replace PROCEDURE ssi_0073156_get_usuario(
     p_id IN ssi_0073156_alunos.usuario_id%TYPE,  
     o_nome OUT ssi_0073156_usuarios.usuario_nome%TYPE,
     o_email OUT ssi_0073156_usuarios.email%TYPE,
     o_senha OUT ssi_0073156_usuarios.senha%TYPE
     )
IS
BEGIN
  SELECT usuario_nome, email, senha
  INTO   o_nome, o_email, o_senha
  from  ssi_0073156_alunos WHERE usuario_id = p_id;
END;
/
show errors;

create or replace PROCEDURE ssi_0073156_delete_usuario(
  p_id IN ssi_0073156_usuarios.usuario_id%TYPE
  )
IS
  DELETE FROM ssi_0073156_usuarios WHERE usuario_id = p_id
BEGIN
END
/
show errros;

create or replace PROCEDURE ssi_0073156_login_usuario(
     p_email IN ssi_0073156_usuarios.email%TYPE OUT varchar2,
     p_senha IN ssi_0073156_usuarios.senha%TYPE OUT varchar2,
     o_id OUT ssi_0073156_alunos.usuario_id%TYPE,  
     o_nome OUT ssi_0073156_usuarios.usuario_nome%TYPE
     )
IS
BEGIN
  SELECT usuario_id,usuario_nome, email, senha
  INTO   o_id,o_nome, p_email, p_senha
  from  ssi_0073156_usuarios WHERE email = p_email AND senha = p_senha;
END;
/
show errors;

