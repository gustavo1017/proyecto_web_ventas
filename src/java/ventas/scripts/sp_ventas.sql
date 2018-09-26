--insercion de registro en tb_distrito
CREATE PROCEDURE sp_insertar_distrito
     (in cod VARCHAR(3),in nom VARCHAR(25), in ven VARCHAR(3))
     insert into tb_distrito values(cod,nom,ven);

-- eliminacion en tb_distrito
CREATE PROCEDURE sp_eliminar_distrito(in cod VARCHAR(3))
     delete from tb_distrito where cod_dis=cod;

-- actualizacion en tb_distrito
CREATE PROCEDURE sp_actualizar_distrito
     (in cod VARCHAR(3),in nom VARCHAR(25), in ven VARCHAR(3))
     update tb_distrito set nom_dis=nom, cod_ven=ven where cod_dis=cod;

--listar tb_distrito
CREATE PROCEDURE sp_listar_distrito()
     select * from tb_distrito;

--buscar tb_distrito
CREATE PROCEDURE sp_buscar_distrito(in cod VARCHAR(3))
     select * from tb_distrito where cod_dis=cod;