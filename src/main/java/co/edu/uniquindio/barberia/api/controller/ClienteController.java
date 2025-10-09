package co.edu.uniquindio.barberia.api.controller;

import co.edu.uniquindio.barberia.api.dto.CrearClienteDTO;
import co.edu.uniquindio.barberia.domain.Cliente;
import co.edu.uniquindio.barberia.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes") // <-- base path correcto
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping // <-- método POST sin paths extra
    public ResponseEntity<Cliente> crear(@Valid @RequestBody CrearClienteDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    // ✅ Nuevo método GET para listar todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // (opcional) para probar rápido en el navegador:
    @GetMapping("/ping")
    public String ping() {
        return "clientes-ok";
    }
}
