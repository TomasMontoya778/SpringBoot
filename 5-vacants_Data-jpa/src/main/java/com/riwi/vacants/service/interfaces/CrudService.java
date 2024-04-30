package com.riwi.vacants.service.interfaces;

import org.springframework.data.domain.Page;

// RQ = request
// RS = response
// ID = tipo de dato de la llave primaria de la entidad
public interface CrudService<RQ, RS, ID> {
   public void delete(ID id);
   public RS create(RQ request);
   public RS update(ID id, RQ request);
   public Page<RS> getAll(int page, int size);
}
