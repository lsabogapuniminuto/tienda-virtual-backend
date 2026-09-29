package edu.uniminuto.transacciones.service;

import edu.uniminuto.transacciones.dto.TransaccionRequest;
import edu.uniminuto.transacciones.dto.TransaccionResponse;

public interface TransaccionService {

    TransaccionResponse procesarTransaccion(TransaccionRequest request);
}
