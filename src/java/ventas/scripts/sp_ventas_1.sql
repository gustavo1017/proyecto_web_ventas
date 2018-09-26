--validar tb_vendedor
CREATE PROCEDURE sp_validar_vendedor(in usu VARCHAR(8),in pas VARCHAR(5))
     select * from tb_vendedor where usu_ven=usu and pas_ven=pas;