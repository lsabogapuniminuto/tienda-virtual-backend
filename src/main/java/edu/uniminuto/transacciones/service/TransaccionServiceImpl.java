package edu.uniminuto.transacciones.service;

import org.springframework.stereotype.Service;

import edu.uniminuto.transacciones.dto.TransaccionRequest;
import edu.uniminuto.transacciones.dto.TransaccionResponse;
import edu.uniminuto.transacciones.model.EstadoTransaccion;
import edu.uniminuto.transacciones.model.Transaccion;
import edu.uniminuto.transacciones.repository.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;

    @Override
    public TransaccionResponse procesarTransaccion(TransaccionRequest request) {
        return transaccionRepository.findByIdTransaccion(request.getIdTransaccion())
                .map(existente -> TransaccionResponse.builder()
                        .idTransaccion(existente.getIdTransaccion())
                        .estado(existente.getEstado().name())
                        .mensaje("La transacción ya había sido registrada previamente")
                        .build())
                .orElseGet(() -> registrarNuevaTransaccion(request));
    }

    private TransaccionResponse registrarNuevaTransaccion(TransaccionRequest request) {
        Transaccion transaccion = Transaccion.builder()
                .idTransaccion(request.getIdTransaccion())
                .nombre(request.getNombre())
                .correo(request.getCorreo())
                .producto(request.getProducto())
                .cantidad(request.getCantidad())
                .fecha(request.getFecha())
                .estado(EstadoTransaccion.CONFIRMADA)
                .build();

        transaccionRepository.save(transaccion);
        log.info("Transacción {} registrada correctamente", transaccion.getIdTransaccion());

        return TransaccionResponse.builder()
                .idTransaccion(transaccion.getIdTransaccion())
                .estado(transaccion.getEstado().name())
                .mensaje("Transacción registrada correctamente")
                .build();
    }
}
