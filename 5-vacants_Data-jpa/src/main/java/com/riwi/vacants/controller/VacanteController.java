package com.riwi.vacants.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.service.abstract_service.IVacanteService;
import com.riwi.vacants.utils.dto.Errors.ErrorsResponse;
import com.riwi.vacants.utils.dto.request.VacanteRequest;
import com.riwi.vacants.utils.dto.response.VacanteResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/vacantes")
@AllArgsConstructor
public class VacanteController {
    @Autowired
    private final IVacanteService objVacanteService;
    @Operation(summary = "Lista todas las vancantes con paginación", 
    description = "Debes enviar la pagina y el tamaño de la pagina para recibir todas la vacantes correspondientes")
    @GetMapping
    public ResponseEntity<Page<VacanteResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(this.objVacanteService.getAll(page - 1, size));
    }
    // ApiResponse nos ayuda a crear un nuevo esquema de respuesta
    @ApiResponse(responseCode = "400", description = "Cuando el id no es válido", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
    })
    @Operation(summary = "Lista una vacante por id", description = "Debes enviar el id de la vacante a buscar")
    @GetMapping(path = "/{id}")
    public ResponseEntity<VacanteResponse> getById (@PathVariable Long id){
        return ResponseEntity.ok(this.objVacanteService.getById(id));
    }
    @Operation(summary = "Crea una vacante y la asocia una compañia", description = "Crea una vacante y la asocia una compañia")
    @PostMapping
    public ResponseEntity<VacanteResponse> save(@Validated @RequestBody VacanteRequest objVacanteRequest){
        return ResponseEntity.ok(this.objVacanteService.create(objVacanteRequest));
    }
    @PutMapping(path = "/{id}")
    @Operation(summary = "Actualiza una vacante", description = "Actualiza una vacante")
    public ResponseEntity<VacanteResponse> update(@PathVariable Long id, @Validated @RequestBody VacanteRequest objVacanteRequest){
        return ResponseEntity.ok(this.objVacanteService.update(id, objVacanteRequest));
    }
    @Operation(summary = "Elimina una vacante por Id", description = "Elimina una vacante por Id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<java.util.Map<String, String>> delete (@PathVariable Long id){
        java.util.Map<String, String> response = new HashMap<>();
        response.put("message", "Se eliminó correctamente");
        this.objVacanteService.delete(id);
        return ResponseEntity.ok(response);
    }
}
