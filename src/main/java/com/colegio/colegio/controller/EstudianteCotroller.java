package com.colegio.colegio.controller;


import com.colegio.colegio.Dto.Response.ColegioResponse;
import com.colegio.colegio.exeptions.ColegioException;
import com.colegio.colegio.mappers.MappersEstudianteDTO;
import com.colegio.colegio.mappers.request.EstudianteRequest;
import com.colegio.colegio.mappers.response.EstudianteResponse;
import com.colegio.colegio.model.Estudiante;
import com.colegio.colegio.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteCotroller {

    private EstudianteService estudianteService;

    public EstudianteCotroller(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ColegioResponse<EstudianteResponse> createEncuesta(
            @RequestBody EstudianteRequest estudianteRequest) throws ColegioException {
        EstudianteResponse estudianteResponse =
        MappersEstudianteDTO.mappControllerDTO(
                estudianteService.createEstudiante(estudianteRequest));
        return new ColegioResponse<>("Succes",String.valueOf(HttpStatus.OK),"Ok",estudianteResponse);
    }


    @GetMapping(value = "/{listar}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Estudiante>> detalleEstudiante(
    ){
        List<Estudiante> prestamoSoicitudResponse =
                estudianteService.listAllEstudiante();
        return ResponseEntity.ok(prestamoSoicitudResponse);
    }


}
